create or replace procedure SP_I_TransferGoodsPosition(
    p_commodityid   varchar2 --商品代码
) as

v_count           number; --数量
v_UNITS           number; --交易单位
v_PRICE           number; --发行价
v_TradeNo         number;
v_HoldNo          number;
v_customerid      VARCHAR2(40); --客户id
v_FIRMID          VARCHAR2(40); --交易商id
v_quantity        number;  --持仓数量
v_Margin          number default 0;  --实时保证金
v_Assure          number default 0;  --持仓担保金
v_mapper_commodityid  VARCHAR2(40); --对应的现货系统商品编号
begin
     -- 查询商品的信息
     select conf.mapperid 
     into   v_mapper_commodityid 
     from ipo_commodity_conf  conf where conf.commodityid=p_commodityid;
   
    -- 查询现货系统对应的交易单位
    select t.contractfactor into v_UNITS from t_commodity  t where t.commodityid=v_mapper_commodityid; 
      
     -- 循环处理持仓记录
     for row_ in (select * from ipo_position where commodityid=p_commodityid) 
     loop
          v_customerid:=row_.firmid||'00';
          v_quantity:=row_.position;
          v_FIRMID:=row_.firmid;
          v_PRICE:=row_.position_price;
          v_Margin:=v_PRICE*v_quantity*v_UNITS;
          
          select FN_T_ComputeTradeNo(SEQ_T_Trade.nextval) into v_TradeNo from dual;
          select FN_T_ComputeHoldNo(SEQ_T_HoldPosition.nextval) into v_HoldNo from dual;
          
         --插入持仓明细表
          insert into T_Holdposition
          (a_holdno, a_tradeno,  CommodityID,     CustomerID , bs_flag, price, holdqty,    openqty,   holdtime,HoldMargin,HoldAssure,Firmid,FloatingLoss,AtClearDate)
        values
          (v_HoldNo, v_TradeNo, v_mapper_commodityid, v_customerid, 1, v_PRICE, v_quantity,v_quantity, sysdate,v_Margin,    0,       v_FIRMID,   0,      sysdate);
          
          
            
        --更新交易客户持仓合计表
        select count(*) into v_count from T_CustomerHoldSum
        where CustomerID = v_customerid  and CommodityID = v_mapper_commodityid   and bs_flag = 1;
        if(v_count >0) then
            update T_CustomerHoldSum
            set holdQty = holdQty + v_quantity,
            holdFunds = holdFunds + v_PRICE*v_quantity*v_UNITS,
            HoldMargin = HoldMargin + v_Margin,
            HoldAssure = HoldAssure + v_Assure,
            evenprice = (holdFunds + v_PRICE*v_quantity*v_UNITS)/((holdQty + v_quantity)*v_UNITS),
            FrozenQty=nvl(FrozenQty,0)+v_quantity
            where CustomerID = v_customerid
            and CommodityID = v_mapper_commodityid
            and bs_flag = 1;
        else
          insert into T_CustomerHoldSum
            (CustomerID,   CommodityID,        bs_flag, holdQty,  holdFunds,      FloatingLoss, evenprice,FrozenQty,HoldMargin,HoldAssure,FirmID)
          values
            (v_customerid, v_mapper_commodityid, 1,    v_quantity, v_PRICE*v_quantity*v_UNITS,0, v_PRICE, v_quantity,v_Margin, v_Assure,  v_FIRMID);
        end if;
  
         --更新交易商持仓合计表 
       select count(*) into v_count from T_FirmHoldSum  where Firmid = v_FIRMID and CommodityID = v_mapper_commodityid  and bs_flag = 1;           
       if(v_count >0) then
          update T_FirmHoldSum
            set holdQty = holdQty + v_quantity,
            holdFunds = holdFunds + v_PRICE*v_quantity*v_UNITS,
            HoldMargin = HoldMargin + v_Margin,
            HoldAssure = HoldAssure + v_Assure,
            evenprice = (holdFunds + v_PRICE*v_quantity*v_UNITS)/((holdQty + v_quantity)*v_UNITS)
            where Firmid = v_FIRMID
            and CommodityID = v_mapper_commodityid
            and bs_flag = 1;
        else
          insert into T_FirmHoldSum
            (FirmID, CommodityID, bs_flag,  holdQty, holdFunds,                 FloatingLoss, evenprice,HoldMargin,HoldAssure)
          values
            (v_FIRMID, v_mapper_commodityid, 1, v_quantity, v_PRICE*v_quantity*v_UNITS,    0,         v_PRICE, v_Margin,  v_Assure);
        end if;
       
       -- 将记录移到历史表中      
        insert into ipo_position_his
           (positionid, firmid, position, commodityid, commodityname, position_price, position_unit, reduction_num,
            reduction_date, create_user, create_date)
         select  positionid, firmid, position, commodityid, commodityname, position_price, position_unit, reduction_num,
            reduction_date, 'job',sysdate
         from ipo_position
         where positionid=row_.positionid;
         
         -- 删除持仓表
         delete from ipo_position where positionid=row_.positionid;
       
     end loop;
         
         
  

end ;
