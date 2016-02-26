--------------------------------------------------
-- Export file for user TRADE_GNNT@SPOT.DEV.183 --
-- Created by hxx on 2016/2/26, 17:15:16 ---------
--------------------------------------------------

set define off
spool ipo_structA.log

prompt
prompt Creating procedure SP_I_TRANSFERGOODSPOSITION
prompt =============================================
prompt
create or replace procedure SP_I_TransferGoodsPosition(
    p_commodityid   varchar2, --��Ʒ����
    p_oper_user     varchar2
) as

v_count           number; --����
v_UNITS           number; --���׵�λ
v_PRICE           number; --���м�
v_TradeNo         number;
v_HoldNo          number;
v_customerid      VARCHAR2(40); --�ͻ�id
v_FIRMID          VARCHAR2(40); --������id
v_quantity        number;  --�ֲ�����
v_frozenqty       number; --��������
v_Margin          number default 0;  --ʵʱ��֤��
v_Assure          number default 0;  --�ֲֵ�����
v_mapper_commodityid  VARCHAR2(40); --��Ӧ���ֻ�ϵͳ��Ʒ���

begin
     -- ��ѯ��Ʒ����Ϣ
     select conf.mapperid 
     into   v_mapper_commodityid 
     from ipo_commodity_conf  conf where conf.commodityid=p_commodityid;
   
    -- ��ѯ�ֻ�ϵͳ��Ӧ�Ľ��׵�λ
    select t.contractfactor into v_UNITS from t_commodity  t where t.commodityid=v_mapper_commodityid; 
      
     -- ѭ������ֲּ�¼
     for row_ in (select * from ipo_positionflow where  state=1 and commodityid=p_commodityid) 
     loop
          v_customerid:=row_.firmid||'00';
          v_quantity:=row_.HOLDQTY;
          v_FIRMID:=row_.firmid;
          v_PRICE:=row_.PRICE;
          v_Margin:=v_PRICE*v_quantity*v_UNITS;
          v_frozenqty:=row_.FROZENQTY;
          select FN_T_ComputeTradeNo(SEQ_T_Trade.nextval) into v_TradeNo from dual;
          select FN_T_ComputeHoldNo(SEQ_T_HoldPosition.nextval) into v_HoldNo from dual;
          
         --����ֲ���ϸ��
          insert into T_Holdposition
          (a_holdno, a_tradeno,  CommodityID,     CustomerID , bs_flag, price, holdqty,    openqty,   holdtime,HoldMargin,HoldAssure,Firmid,FloatingLoss,AtClearDate)
        values
          (v_HoldNo, v_TradeNo, v_mapper_commodityid, v_customerid, 1, v_PRICE, v_quantity,v_quantity, sysdate,v_Margin,    0,       v_FIRMID,   0,      sysdate);
          
          
            
        --���½��׿ͻ��ֲֺϼƱ�
        select count(*) into v_count from T_CustomerHoldSum
        where CustomerID = v_customerid  and CommodityID = v_mapper_commodityid   and bs_flag = 1;
        if(v_count >0) then
            update T_CustomerHoldSum
            set holdQty = holdQty + v_quantity,
            holdFunds = holdFunds + v_PRICE*v_quantity*v_UNITS,
            HoldMargin = HoldMargin + v_Margin,
            HoldAssure = HoldAssure + v_Assure,
            evenprice = (holdFunds + v_PRICE*v_quantity*v_UNITS)/((holdQty + v_quantity)*v_UNITS),
            FrozenQty=nvl(FrozenQty,0)+nvl(v_frozenqty,0)
            where CustomerID = v_customerid
            and CommodityID = v_mapper_commodityid
            and bs_flag = 1;
        else
          insert into T_CustomerHoldSum
            (CustomerID,   CommodityID,        bs_flag, holdQty,  holdFunds,      FloatingLoss, evenprice,FrozenQty,HoldMargin,HoldAssure,FirmID)
          values
            (v_customerid, v_mapper_commodityid, 1,    v_quantity, v_PRICE*v_quantity*v_UNITS,0, v_PRICE, nvl(v_frozenqty,0),v_Margin, v_Assure,  v_FIRMID);
        end if;
  
         --���½����ֲֺ̳ϼƱ� 
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
       
        --��¼����ʷ����
         insert into ipo_positionflow_his
         ( id, firmid, holdqty, business_code, role_code, commodityid, price, 
           create_user, create_date, update_user, update_date, state,
           frozenqty, remark, freeqty, oper_user, oper_date
         )
        values(
          row_.id, row_.firmid, row_.holdqty, row_.business_code, row_.role_code, row_.commodityid, row_.price,
          row_.create_user, row_.create_date, row_.update_user,row_.update_date, row_.state,
          row_.frozenqty, row_.remark, row_.freeqty, p_oper_user, sysdate
         );
       
        -- ����ת�ֲ�״̬  
        update ipo_positionflow t set t.state=2,t.update_user=p_oper_user, t.update_date=sysdate where t.id=row_.id;
         
     end loop;
         
         
  

end ;
/


spool off
