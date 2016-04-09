--------------------------------------------------
-- Export file for user TRADE_GNNT@SPOT.DEV.183 --
-- Created by Bob on 2016-04-07, 13:54:02 --------
--------------------------------------------------

set define off
spool view.log

prompt
prompt Creating view E_TRADETIME_RT
prompt ============================
prompt
create or replace force view e_tradetime_rt as
select id, week restweekday, day holiday, modifytime from t_a_nottradeday;

prompt
prompt Creating view V_BI_BUSINESSRELATIONSHIP
prompt =======================================
prompt
create or replace force view v_bi_businessrelationship as
select  t."STOCKID",t."BREEDNAME",t."WAREHOUSEID",t."QUANTITY",t."UNIT",t."SELLER",t."BUYER",t."RECEIVED",t."RECEIVEDDATE",t."SELLTIME", nvl(bi.stockid,0)  as invoiceStatus
from (select b.stockid,m.breedname,s.warehouseid,s.quantity,s.unit,b.seller,b.buyer,b.received,b.receiveddate,b.selltime
from  BI_BusinessRelationship b,BI_stock s,m_breed m
where b.stockid=s.stockid and s.breedid=m.breedid)t
left join bi_invoiceinform bi on bi.stockid=t.stockid;

prompt
prompt Creating view V_BI_INVOICEINFORM
prompt ================================
prompt
create or replace force view v_bi_invoiceinform as
select i.stockid,m.breedname,s.warehouseid,s.quantity,s.unit,i.invoicetype,
i.companyname,i.address,i.dutyparagraph,i.bank,i.bankaccount,i.name,i.phone
from  BI_Invoiceinform i,BI_stock s,m_breed m
where i.stockid=s.stockid and s.breedid=m.breedid;

prompt
prompt Creating view V_BI_OUTSTOCK
prompt ===========================
prompt
create or replace force view v_bi_outstock as
select  t3.stockid,t3.realstockcode,t3.breedid,t3.breedname,t3.ownerfirm,t3.warehouseid,t3.quantity,t3.unit,t3.createtime,t3.lasttime,t3.company,t3.logisticsorder,
case when t3.received is null or t3.received='0' then 0
else 1 end isreceived,t3.receiveddate,nvl(i.stockid,0) as invoiceStatus
from (select   t1.stockid,t1.realstockcode,t1.breedid,t1.breedname,t1.ownerfirm,t1.warehouseid,t1.quantity,t1.unit,t1.createtime,t1.lasttime,t1.company,t1.logisticsorder,t2.received,t2.receiveddate from (
              select t.stockid,t.realstockcode,t.breedid,m.breedname,t.ownerfirm,t.warehouseid,t.quantity,t.unit,t.createtime,t.lasttime,b.company,b.logisticsorder from
                     (select stockid,realstockcode,breedid,ownerfirm,warehouseid,quantity,unit,createtime,lasttime from bi_stock o where stockstatus=2) t
                      left  join bi_logistics b on t.stockid=b.stockid
                      inner join  m_breed   m on m.breedid=t.breedid
               ) t1

left  join
(select stockid,received,receiveddate,buyer from bi_businessrelationship  where  selltime in (select selltime from ( select stockid,max(selltime) selltime from bi_businessrelationship group by stockid))) t2
on t1.stockid=t2.stockid and t1.ownerfirm=t2.buyer) t3
LEFT JOIN BI_INVOICEINFORM i ON i.STOCKID=t3.stockid;

prompt
prompt Creating view V_COMMODITYTARIFF
prompt ===============================
prompt
create or replace force view v_commoditytariff as
select tariffID,
    decode(t.FEEALGR,1,to_char(t.FEERATE_B * 100, 'fm9999999990.009999') || '%',to_char(t.FEERATE_B, 'fm9999999990.009999')) newFeeRate_B,
    decode(t.FEEALGR,1,to_char(t.FEERATE_S * 100, 'fm9999999990.009999') || '%',to_char(t.FEERATE_S, 'fm9999999990.009999')) newFeeRate_S,
    decode(t.FEEALGR,1,to_char(t.TodayCloseFeeRate_B * 100, 'fm9999999990.009999') || '%',to_char(t.TodayCloseFeeRate_B, 'fm9999999990.009999')) newTodayCloseFeeRate_B,
    decode(t.FEEALGR,1,to_char(t.TodayCloseFeeRate_S * 100, 'fm9999999990.009999') || '%',to_char(t.TodayCloseFeeRate_S, 'fm9999999990.009999')) newTodayCloseFeeRate_S,
    decode(t.FEEALGR,1,to_char(t.HistoryCloseFeeRate_B * 100, 'fm9999999990.009999') || '%',to_char(t.HistoryCloseFeeRate_B, 'fm9999999990.009999')) newHistoryCloseFeeRate_B,
    decode(t.FEEALGR,1,to_char(t.HistoryCloseFeeRate_S * 100, 'fm9999999990.009999') || '%',to_char(t.HistoryCloseFeeRate_S, 'fm9999999990.009999')) newHistoryCloseFeeRate_S,
    decode(t.ForceCloseFeeAlgr,1,to_char(t.ForceCloseFeeRate_B * 100, 'fm9999999990.009999') || '%',to_char(t.ForceCloseFeeRate_B, 'fm9999999990.009999')) newForceCloseFeeRate_B,
    decode(t.ForceCloseFeeAlgr,1,to_char(t.ForceCloseFeeRate_S * 100, 'fm9999999990.009999') || '%',to_char(t.ForceCloseFeeRate_S, 'fm9999999990.009999')) newForceCloseFeeRate_S,
    decode(c.FEEALGR,1,to_char(c.FEERATE_B * 100, 'fm9999999990.009999') || '%',to_char(c.FEERATE_B, 'fm9999999990.009999')) oldFeeRate_B,
    decode(c.FEEALGR,1,to_char(c.FEERATE_S * 100, 'fm9999999990.009999') || '%',to_char(c.FEERATE_S, 'fm9999999990.009999')) oldFeeRate_S,
    decode(c.FEEALGR,1,to_char(c.TodayCloseFeeRate_B * 100, 'fm9999999990.009999') || '%',to_char(c.TodayCloseFeeRate_B, 'fm9999999990.009999')) oldTodayCloseFeeRate_B,
    decode(c.FEEALGR,1,to_char(c.TodayCloseFeeRate_S * 100, 'fm9999999990.009999') || '%',to_char(c.TodayCloseFeeRate_S, 'fm9999999990.009999')) oldTodayCloseFeeRate_S,
    decode(c.FEEALGR,1,to_char(c.HistoryCloseFeeRate_B * 100, 'fm9999999990.009999') || '%',to_char(c.HistoryCloseFeeRate_B, 'fm9999999990.009999')) oldHistoryCloseFeeRate_B,
    decode(c.FEEALGR,1,to_char(c.HistoryCloseFeeRate_S * 100, 'fm9999999990.009999') || '%',to_char(c.HistoryCloseFeeRate_S, 'fm9999999990.009999')) oldHistoryCloseFeeRate_S,
    decode(c.ForceCloseFeeAlgr,1,to_char(c.ForceCloseFeeRate_B * 100, 'fm9999999990.009999') || '%',to_char(c.ForceCloseFeeRate_B, 'fm9999999990.009999')) oldForceCloseFeeRate_B,
    decode(c.ForceCloseFeeAlgr,1,to_char(c.ForceCloseFeeRate_S * 100, 'fm9999999990.009999') || '%',to_char(c.ForceCloseFeeRate_S, 'fm9999999990.009999')) oldForceCloseFeeRate_S,
     t.MODIFYTIME,t.createUser,t.TariffName,TariffRate * 100 || '%' TARIFFRATE,c.name,t.commodityID from T_A_Tariff t, T_COMMODITY c where t.commodityid = c.commodityid;

prompt
prompt Creating view V_C_CUSTOMERFUNDS
prompt ===============================
prompt
create or replace force view v_c_customerfunds as
select FIRMID,FIRMNAME,NOWLEAVEBALANCE,RUNTIMEFL,RUNTIMEMARGIN,RUNTIMEASSURE,LASTBALANCE,CLEARFL,CLEARMARGIN,CLEARASSURE,TRADEFEE,MAXOVERDRAFT,CLOSE_PL
    from  (select a.*,
          f.balance,
          f.frozenfunds,
          f.lastbalance,
          m.name FirmName,
          tt.TradeFee,
          nvl(nvl(balance, 0) + nvl((-1) * FrozenFunds, 0), 0) nowLeaveBalance,
          nvl(d.close_PL, 0) close_PL
     from T_Firm a,
          (select sum(t.TradeFee) TradeFee, t.firmID firmID
             from T_Trade t
            group by firmID) tt,
          F_FirmFunds f,
          M_firm m,
          (select firmID, nvl(sum(Close_PL), 0) close_PL
             from T_Trade
            group by firmID) d
    where a.FirmID = tt.FirmID(+)
      and a.FirmID = f.FirmID
      and m.firmID = a.firmID
      and a.firmid = d.firmID(+)
    order by nowLeaveBalance ASC) Q;

prompt
prompt Creating view V_C_TRADEMODULE
prompt =============================
prompt
create or replace force view v_c_trademodule as
select distinct l.moduleid,t.shortname name from f_ledgerfield  l,C_TradeModule t where l.moduleid=t.moduleid;

prompt
prompt Creating view V_ERRORLOGINLOG
prompt =============================
prompt
create or replace force view v_errorloginlog as
select trader.traderid as "TRADERID",trader.userid as "USERID",logs.counts as "COUNTS",logs.loginDate as "LOGINDATE" from (select traderid,count(*) counts,trunc(loginDate) loginDate from m_errorloginlog group by traderid,trunc(loginDate)) logs,m_trader trader where trader.traderid = logs.traderid;

prompt
prompt Creating view V_F_FIRMCURFUNDS
prompt ==============================
prompt
create or replace force view v_f_firmcurfunds as
select firmId,          --交易商代码
       name,            --交易商名称
       f_balance,       --交易系统当前余额
       l_balance,       --财务结算余额
       y_balance,       --财务未结算金额
       balanceSubtract, --差额
       lastwarranty,    --担保金
       frozenFunds,     --临时资金
       user_balance     --可用资金
  from (select z.*,
               f_balance - l_balance - y_balance balanceSubtract,
               f_balance + FrozenFunds user_balance
          from (select f.firmid,
                       (select name from m_firm where firmId = f.firmId) name,
                       f.balance f_balance,
                       nvl(h.todaybalance, 0) l_balance,
                       nvl(e.y_balance, 0) y_balance,
                       nvl(f.lastwarranty, 0) lastwarranty,
                       nvl(-1 * FrozenFunds, 0) FrozenFunds
                  from F_FirmFunds f,
                       (select h1.firmid, h1.todaybalance
                          from f_firmbalance h1
                         where h1.b_date =
                               (select nvl(max(b_date),
                                           to_date('2009-01-01', 'yyyy-MM-dd'))
                                  from f_firmbalance)) h,
                       (select d.firmid,
                               0 + nvl(b.c_balance, 0) - nvl(c.d_balance, 0) y_balance
                          from F_FirmFunds d,
                               (select a.firmid, sum(a.amount) c_balance
                                  from f_fundflow a
                                 where a.oprcode in
                                       (select t.summaryno
                                          from f_summary t
                                         where t.funddcflag = 'C')
                                 group by firmid) b,
                               (select a.firmid, sum(a.amount) d_balance
                                  from f_fundflow a
                                 where a.oprcode in
                                       (select t.summaryno
                                          from f_summary t
                                         where t.funddcflag = 'D')
                                 group by firmid) c
                         where d.firmid = b.firmid(+)
                           and d.firmid = c.firmid(+)) e
                 where f.firmid = h.firmid(+)
                   and f.firmid = e.firmid(+)) z)
;

prompt
prompt Creating view V_H_TRADE
prompt =======================
prompt
create or replace force view v_h_trade as
select CLEARDATE, A_TRADENO,A_ORDERNO,TRADETIME,CUSTOMERID,COMMODITYID,BS_FLAG,ORDERTYPE,PRICE,QUANTITY,CLOSE_PL,TRADEFEE,TRADETYPE,HOLDPRICE,HOLDTIME,FIRMID,CLOSEADDEDTAX,FIRMNAME,OPPCUSTOMERID
           from (select a.*, m.name FirmName, a.oppFirmId oppCustomerID
                   from T_H_TRADE a,
                        M_firm m
                  where m.firmID = a.firmID
                  order by a.firmID, a_orderno) Q;

prompt
prompt Creating view V_M_FIRM_CREATE_STAT
prompt ==================================
prompt
create or replace force view v_m_firm_create_stat as
select
       trunc(createtime) createdate,        --开户日期
       count(1) cnt                         --开户数量
  from m_firm group by trunc(createtime)
;

prompt
prompt Creating view V_M_FRONT_LOGON_STAT
prompt ==================================
prompt
create or replace force view v_m_front_logon_stat as
select operatrdate, ---登录日期
       sum(logsu) logsuccess, --登录成功数量
       sum(logcount) logcount, --交易商登录数量
       sum(logfail) logfail --登录失败数量
  from (select trunc(t.operatetime) operatrdate,
               count(*) logsu,
               0 logcount,
               0 logfail
          from c_globallog_all t
         where t.operatetype = '3201'
           and t.operateresult = 1
           and t.operatecontent like '%登录成功%'
         group by trunc(t.operatetime)
        union
        select trunc(t.operatetime) operatrdate,
               count(*) logsu,
               0 logcount,
               0 logfail
          from c_globallog_all_h t
         where t.operatetype = '3201'
           and t.operateresult = 1
           and t.operatecontent like '%登录成功%'
         group by trunc(t.operatetime)
        union
        select trunc(t.operatetime) operatrdate,
               0 logsu,
               count(distinct t.operator) logcount,
               0 logfail
          from c_globallog_all t
         where t.operatetype = '3201'
         group by trunc(t.operatetime)
        union
        select trunc(t.operatetime) operatrdate,
               0 logsu,
               count(distinct t.operator) logcount,
               0 logfail
          from c_globallog_all_h t
         where t.operatetype = '3201'
         group by trunc(t.operatetime)
        union
        select trunc(t.operatetime) operatrdate,
               0 logsu,
               0 logcount,
               count(*) logfail
          from c_globallog_all t
         where t.operatetype = '3201'
           and t.operateresult = 0
         group by trunc(t.operatetime)
        union
        select trunc(t.operatetime) operatrdate,
               0 logsu,
               0 logcount,
               count(*) logfail
          from c_globallog_all_h t
         where t.operatetype = '3201'
           and t.operateresult = 0
         group by trunc(t.operatetime))
 group by operatrdate
;

prompt
prompt Creating view V_STOCKLIST
prompt =========================
prompt
create or replace force view v_stocklist as
select t5."STOCKID",t5."BREEDID",t5.ownerfirm,t5."WAREHOUSEID",t5."QUANTITY",t5."UNIT",t5."LASTTIME",t5."CREATETIME",t5."STOCKSTATUS",
t5."LOGISTICSORDER",t5."COMPANY",t5."RECEIVED" ,t5."RECEIVEDDATE",t5.breedname,nvl(b11.stockid,0) as invoiceStatus from
(select t4."STOCKID",t4."BREEDID",t4.ownerfirm,t4."WAREHOUSEID",t4."QUANTITY",t4."UNIT",t4."LASTTIME",t4."CREATETIME",t4."STOCKSTATUS",
        t4."LOGISTICSORDER",t4."COMPANY",t4."RECEIVED" ,t4."RECEIVEDDATE",m.breedname  from
       (select distinct(t3.stockid),t3.breedid,t3.warehouseid,t3.quantity,t3.ownerfirm,t3.unit,t3.lasttime,t3.createtime,t3.stockstatus,t3.logisticsorder,t3.company,t44.received,t44.receiveddate
               from
                   (select t.stockid,t.breedid,t.ownerfirm,t.warehouseid,t.quantity,t.unit,t.lasttime,t.createtime,t.stockstatus,t2.logisticsorder,t2.company
                        from bi_stock t
                             left join bi_logistics t2 on t.stockid=t2.stockid where t.stockstatus=2 ) t3
                                  left join
                                  (select stockid,received,receiveddate,buyer from bi_businessrelationship
 where  selltime in (select selltime from ( select stockid,max(selltime) selltime from bi_businessrelationship group by stockid)))
                                   t44 on t3.stockid=t44.stockid and t3.ownerfirm=t44.buyer  ) t4
                                       left join m_breed m on t4.breedid=m.breedid) t5

                                       left join bi_invoiceinform b11 on t5.stockid=b11.stockid;

prompt
prompt Creating view V_T_FIRM_INFO
prompt ===========================
prompt
create or replace force view v_t_firm_info as
select firmid, firmName, status, customerCounts, tcounts, createTime
    from (select a.*,
                 cf.name firmName,
                 cf.createtime createtime,
                 b.counts customerCounts,
                 t.tcounts tcounts
            from T_firm a,
                 (select T_customer.firmid,
                         count(T_customer.customerid) counts
                    from T_customer
                   group by T_customer.firmid) b,
                 (select M_trader.firmid, count(M_trader.traderid) tcounts
                    from M_trader
                   group by M_trader.firmid) t,
                 M_firm cf
           where a.firmid = b.firmid(+)
             and a.firmid = t.firmid(+)
             and a.firmid = cf.firmid
           order by a.firmID);

prompt
prompt Creating view V_T_OVERDUEHOLDPOSITION
prompt =====================================
prompt
create or replace force view v_t_overdueholdposition as
select firmid,       -- 交易商代码
       customerid,   -- 交易客户代码
       commodityid,  -- 商品代码
       bs_flag,      -- 买卖方向，1：买，2：卖
       holdqty,      -- 持仓数量
       openqty,      -- 开仓数量
       gageqty,      -- 抵顶数量
       maycloseQty   -- 可转让数量
  from (select ag.*, (s.holdqty - s.FrozenQty) maycloseQty
          from (select a.firmid,
                       a.customerid,
                       a.commodityid,
                       a.bs_flag,
                       sum(a.holdqty) holdqty,
                       sum(a.openqty) openqty,
                       sum(a.gageqty) gageqty
                  from T_HoldPosition a
                 where 1 = 1
                   and remainday = 0
                   and a.deadline is not null
                 group by a.firmid, a.customerid, a.commodityid, a.bs_flag) ag,
               t_customerholdsum s
         where ag.commodityid = s.commodityid
           and ag.customerid = s.customerid
           and ag.bs_flag = s.bs_flag
           and ag.holdqty > 0
           )
;

prompt
prompt Creating view V_T_TRADE
prompt =======================
prompt
create or replace force view v_t_trade as
select A_TRADENO,A_ORDERNO,TRADETIME,CUSTOMERID,COMMODITYID,BS_FLAG,ORDERTYPE,PRICE,QUANTITY,CLOSE_PL,TRADEFEE,TRADETYPE,HOLDPRICE,HOLDTIME,FIRMID,CLOSEADDEDTAX,FIRMNAME,OPPCUSTOMERID
           from (select a.*, m.name FirmName, a.oppFirmId oppCustomerID
                   from T_Trade a,
                        M_firm m
                  where m.firmID = a.firmID
                  order by a.firmID, a_orderno) Q;

prompt
prompt Creating view V_W_ERRORLOGINLOG
prompt ===============================
prompt
create or replace force view v_w_errorloginlog as
select u.userid   as userid,
       u.name as name,
       logs.warehouseid as warehouseid,
       logs.counts     as counts,
       logs.loginDate  as logindate
  from (select t.userid, count(*) counts,warehouseid, trunc(loginDate) loginDate
          from w_errorloginlog t
         group by userid,warehouseid, trunc(loginDate)) logs,
       w_user u
 where u.userid = logs.userid;


spool off
