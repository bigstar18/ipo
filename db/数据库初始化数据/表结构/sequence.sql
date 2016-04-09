--------------------------------------------------
-- Export file for user TRADE_GNNT@SPOT.DEV.183 --
-- Created by Bob on 2016-04-07, 13:53:19 --------
--------------------------------------------------

set define off
spool sequence.log

prompt
prompt Creating sequence SEQ_BI_DISMANTLE
prompt ==================================
prompt
create sequence SEQ_BI_DISMANTLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_FINANCINGSTOCK
prompt =======================================
prompt
create sequence SEQ_BI_FINANCINGSTOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_FROZENSTOCK
prompt ====================================
prompt
create sequence SEQ_BI_FROZENSTOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_OUTSTOCK
prompt =================================
prompt
create sequence SEQ_BI_OUTSTOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_PLEDGESTOCK
prompt ====================================
prompt
create sequence SEQ_BI_PLEDGESTOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_STOCK
prompt ==============================
prompt
create sequence SEQ_BI_STOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_STOCKCHGLOG
prompt ====================================
prompt
create sequence SEQ_BI_STOCKCHGLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_TRADESTOCK
prompt ===================================
prompt
create sequence SEQ_BI_TRADESTOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BI_WAREHOUSE
prompt ==================================
prompt
create sequence SEQ_BI_WAREHOUSE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BR_BROKERAREA
prompt ===================================
prompt
create sequence SEQ_BR_BROKERAREA
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_C_APPLY
prompt =============================
prompt
create sequence SEQ_C_APPLY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_C_AUDIT
prompt =============================
prompt
create sequence SEQ_C_AUDIT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_C_FRONT_ROLE
prompt ==================================
prompt
create sequence SEQ_C_FRONT_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_C_GLOBALLOG
prompt =================================
prompt
create sequence SEQ_C_GLOBALLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_C_ROLE
prompt ============================
prompt
create sequence SEQ_C_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_F_B_ACTION
prompt ================================
prompt
create sequence SEQ_F_B_ACTION
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_BANKCOMPAREINFO
prompt =========================================
prompt
create sequence SEQ_F_B_BANKCOMPAREINFO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_CAPITALINFO
prompt =====================================
prompt
create sequence SEQ_F_B_CAPITALINFO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_DICTIONARY
prompt ====================================
prompt
create sequence SEQ_F_B_DICTIONARY
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_FEEINFO
prompt =================================
prompt
create sequence SEQ_F_B_FEEINFO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_INTERFACELOG
prompt ======================================
prompt
create sequence SEQ_F_B_INTERFACELOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_LOG
prompt =============================
prompt
create sequence SEQ_F_B_LOG
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_MAKETMONEY
prompt ====================================
prompt
create sequence SEQ_F_B_MAKETMONEY
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_MARGINS
prompt =================================
prompt
create sequence SEQ_F_B_MARGINS
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_QSRESULT
prompt ==================================
prompt
create sequence SEQ_F_B_QSRESULT
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_RGSTCAPITALVALUE
prompt ==========================================
prompt
create sequence SEQ_F_B_RGSTCAPITALVALUE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_TRADEDATA
prompt ===================================
prompt
create sequence SEQ_F_B_TRADEDATA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_TRADELIST
prompt ===================================
prompt
create sequence SEQ_F_B_TRADELIST
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_B_TRANSMONEYOBJ
prompt =======================================
prompt
create sequence SEQ_F_B_TRANSMONEYOBJ
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_FROZENFUNDFLOW
prompt ======================================
prompt
create sequence SEQ_F_FROZENFUNDFLOW
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_FUNDFLOW
prompt ================================
prompt
create sequence SEQ_F_FUNDFLOW
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_VOUCHER
prompt ===============================
prompt
create sequence SEQ_F_VOUCHER
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_F_VOUCHERENTRY
prompt ====================================
prompt
create sequence SEQ_F_VOUCHERENTRY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_IPO_BALLOTNO_INFO
prompt =======================================
prompt
create sequence SEQ_IPO_BALLOTNO_INFO
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_BILLOFLADING
prompt ======================================
prompt
create sequence SEQ_IPO_BILLOFLADING
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_BREED
prompt ===============================
prompt
create sequence SEQ_IPO_BREED
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_CHARGE_ROLE
prompt =====================================
prompt
create sequence SEQ_IPO_CHARGE_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_CHARGE_USER
prompt =====================================
prompt
create sequence SEQ_IPO_CHARGE_USER
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_COMMODITY_SALE
prompt ========================================
prompt
create sequence SEQ_IPO_COMMODITY_SALE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_DEBITFLOW
prompt ===================================
prompt
create sequence SEQ_IPO_DEBITFLOW
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_DELIVERT_PROP
prompt =======================================
prompt
create sequence SEQ_IPO_DELIVERT_PROP
minvalue 1
maxvalue 9999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_DELIVERY
prompt ==================================
prompt
create sequence SEQ_IPO_DELIVERY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_DELIVERYORDER
prompt =======================================
prompt
create sequence SEQ_IPO_DELIVERYORDER
minvalue 1
maxvalue 9999
start with 1
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence SEQ_IPO_DELIVERY_COST
prompt =======================================
prompt
create sequence SEQ_IPO_DELIVERY_COST
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_DISTRIBUTION
prompt ======================================
prompt
create sequence SEQ_IPO_DISTRIBUTION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_EXPRESS
prompt =================================
prompt
create sequence SEQ_IPO_EXPRESS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_FIRMREWARDDEAIL
prompt =========================================
prompt
create sequence SEQ_IPO_FIRMREWARDDEAIL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_HOLDCOMMODITY
prompt =======================================
prompt
create sequence SEQ_IPO_HOLDCOMMODITY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_NOTTRADEDAY
prompt =====================================
prompt
create sequence SEQ_IPO_NOTTRADEDAY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_NUMBEROFRECORDS
prompt =========================================
prompt
create sequence SEQ_IPO_NUMBEROFRECORDS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_NUMBEROFRECORDS_H
prompt ===========================================
prompt
create sequence SEQ_IPO_NUMBEROFRECORDS_H
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_ORDER
prompt ===============================
prompt
create sequence SEQ_IPO_ORDER
minvalue 1
maxvalue 9999
start with 1
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence SEQ_IPO_ORDER_H
prompt =================================
prompt
create sequence SEQ_IPO_ORDER_H
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_PAYFLOW
prompt =================================
prompt
create sequence SEQ_IPO_PAYFLOW
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_PICKUP
prompt ================================
prompt
create sequence SEQ_IPO_PICKUP
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence SEQ_IPO_POSITION
prompt ==================================
prompt
create sequence SEQ_IPO_POSITION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_POSITIONFLOW
prompt ======================================
prompt
create sequence SEQ_IPO_POSITIONFLOW
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_POSITIONREDUCE
prompt ========================================
prompt
create sequence SEQ_IPO_POSITIONREDUCE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_PUBLISHER_POSITION
prompt ============================================
prompt
create sequence SEQ_IPO_PUBLISHER_POSITION
minvalue 1
maxvalue 99999999999999999999999999
start with 1
increment by 1
cache 21;

prompt
prompt Creating sequence SEQ_IPO_PUBPAYMENT_TRACK
prompt ==========================================
prompt
create sequence SEQ_IPO_PUBPAYMENT_TRACK
minvalue 1
maxvalue 999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_RELEASESUBSCRIPTION
prompt =============================================
prompt
create sequence SEQ_IPO_RELEASESUBSCRIPTION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_SALES
prompt ===============================
prompt
create sequence SEQ_IPO_SALES
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_SPECIALCOUNTERFEE
prompt ===========================================
prompt
create sequence SEQ_IPO_SPECIALCOUNTERFEE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_SPECIAL_POUNDAGE
prompt ==========================================
prompt
create sequence SEQ_IPO_SPECIAL_POUNDAGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_SPO_COMM
prompt ==================================
prompt
create sequence SEQ_IPO_SPO_COMM
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_SPO_RATION
prompt ====================================
prompt
create sequence SEQ_IPO_SPO_RATION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_STORAGE
prompt =================================
prompt
create sequence SEQ_IPO_STORAGE
minvalue 1
maxvalue 999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_TRADETIME
prompt ===================================
prompt
create sequence SEQ_IPO_TRADETIME
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_TRADETIME_COMM
prompt ========================================
prompt
create sequence SEQ_IPO_TRADETIME_COMM
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_TRUSTEESHIP
prompt =====================================
prompt
create sequence SEQ_IPO_TRUSTEESHIP
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_TRUSTEESHIP_COMMODITY
prompt ===============================================
prompt
create sequence SEQ_IPO_TRUSTEESHIP_COMMODITY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_TRUSTEESHIP_HIS
prompt =========================================
prompt
create sequence SEQ_IPO_TRUSTEESHIP_HIS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_TRUSTEESHIP_WAREHOUSE
prompt ===============================================
prompt
create sequence SEQ_IPO_TRUSTEESHIP_WAREHOUSE
minvalue 1
maxvalue 9999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_UNDERWRITER_DEPOSIT
prompt =============================================
prompt
create sequence SEQ_IPO_UNDERWRITER_DEPOSIT
minvalue 1
maxvalue 9999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_UNDERWRITER_SUB
prompt =========================================
prompt
create sequence SEQ_IPO_UNDERWRITER_SUB
minvalue 1
maxvalue 999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_UNDERWRITER_SUBSCRIBE
prompt ===============================================
prompt
create sequence SEQ_IPO_UNDERWRITER_SUBSCRIBE
minvalue 1
maxvalue 999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_IPO_WAREHOUSE_STOCK
prompt =========================================
prompt
create sequence SEQ_IPO_WAREHOUSE_STOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_BREED
prompt =============================
prompt
create sequence SEQ_M_BREED
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_CATEGORY
prompt ================================
prompt
create sequence SEQ_M_CATEGORY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_FIRMCATEGORY
prompt ====================================
prompt
create sequence SEQ_M_FIRMCATEGORY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_FIRM_APPLY
prompt ==================================
prompt
create sequence SEQ_M_FIRM_APPLY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_MESSAGE
prompt ===============================
prompt
create sequence SEQ_M_MESSAGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_NOTICE
prompt ==============================
prompt
create sequence SEQ_M_NOTICE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_PROPERTY
prompt ================================
prompt
create sequence SEQ_M_PROPERTY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_M_PROPERTYTYPE
prompt ====================================
prompt
create sequence SEQ_M_PROPERTYTYPE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ON_TEST
prompt =============================
prompt
create sequence SEQ_ON_TEST
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_ON_TEST2
prompt ==============================
prompt
create sequence SEQ_ON_TEST2
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_FIRM_PERMISSION
prompt =========================================
prompt
create sequence SEQ_SYS_FIRM_PERMISSION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TESTGB
prompt ============================
prompt
create sequence SEQ_TESTGB
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TM_TRADEMONITOR
prompt =====================================
prompt
create sequence SEQ_TM_TRADEMONITOR
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_A_BREED
prompt ===============================
prompt
create sequence SEQ_T_A_BREED
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_A_CMDTYSORT
prompt ===================================
prompt
create sequence SEQ_T_A_CMDTYSORT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_A_SETTLEPRIVILEGE
prompt =========================================
prompt
create sequence SEQ_T_A_SETTLEPRIVILEGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_A_TRADEPRIVILEGE
prompt ========================================
prompt
create sequence SEQ_T_A_TRADEPRIVILEGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_BILLFROZEN
prompt ==================================
prompt
create sequence SEQ_T_BILLFROZEN
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_BROADCAST
prompt =================================
prompt
create sequence SEQ_T_BROADCAST
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_CONDITIONORDER
prompt ======================================
prompt
create sequence SEQ_T_CONDITIONORDER
minvalue 1
maxvalue 10000000000000000
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_DELAYORDERS
prompt ===================================
prompt
create sequence SEQ_T_DELAYORDERS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_DELAYTRADE
prompt ==================================
prompt
create sequence SEQ_T_DELAYTRADE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_D_ORDERLOG
prompt ==================================
prompt
create sequence SEQ_T_D_ORDERLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_D_ORDERSUMLOG
prompt =====================================
prompt
create sequence SEQ_T_D_ORDERSUMLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_APPLYAHEADSETTLE
prompt ==========================================
prompt
create sequence SEQ_T_E_APPLYAHEADSETTLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_APPLYBILL
prompt ===================================
prompt
create sequence SEQ_T_E_APPLYBILL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_APPLYGAGE
prompt ===================================
prompt
create sequence SEQ_T_E_APPLYGAGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_APPLYTREATYSETTLE
prompt ===========================================
prompt
create sequence SEQ_T_E_APPLYTREATYSETTLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_DEDUCTPOSITION
prompt ========================================
prompt
create sequence SEQ_T_E_DEDUCTPOSITION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_T_E_EMBEDORDERS
prompt =====================================
prompt
create sequence SEQ_T_E_EMBEDORDERS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_FUNDTRANSFER
prompt ======================================
prompt
create sequence SEQ_T_E_FUNDTRANSFER
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_GAGEBILL
prompt ==================================
prompt
create sequence SEQ_T_E_GAGEBILL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_PLEDGE
prompt ================================
prompt
create sequence SEQ_T_E_PLEDGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_SETTLELOG
prompt ===================================
prompt
create sequence SEQ_T_E_SETTLELOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_E_VIRTUALFUNDSAPPLY
prompt ===========================================
prompt
create sequence SEQ_T_E_VIRTUALFUNDSAPPLY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_HOLDFROZEN
prompt ==================================
prompt
create sequence SEQ_T_HOLDFROZEN
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_HOLDPOSITION
prompt ====================================
prompt
create sequence SEQ_T_HOLDPOSITION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_NOTSENDBROADCAST
prompt ========================================
prompt
create sequence SEQ_T_NOTSENDBROADCAST
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_ORDERS
prompt ==============================
prompt
create sequence SEQ_T_ORDERS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_SETTLEHOLDPOSITION
prompt ==========================================
prompt
create sequence SEQ_T_SETTLEHOLDPOSITION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_SETTLEMATCH
prompt ===================================
prompt
create sequence SEQ_T_SETTLEMATCH
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_SETTLEMATCHFUNDMANAGE
prompt =============================================
prompt
create sequence SEQ_T_SETTLEMATCHFUNDMANAGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_SETTLEMATCHLOG
prompt ======================================
prompt
create sequence SEQ_T_SETTLEMATCHLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_SETTLEPROPS
prompt ===================================
prompt
create sequence SEQ_T_SETTLEPROPS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_SPECFROZENHOLD
prompt ======================================
prompt
create sequence SEQ_T_SPECFROZENHOLD
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_SYSLOG
prompt ==============================
prompt
create sequence SEQ_T_SYSLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_TRADE
prompt =============================
prompt
create sequence SEQ_T_TRADE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_UNTRADETRANSFER
prompt =======================================
prompt
create sequence SEQ_T_UNTRADETRANSFER
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_VALIDBILL
prompt =================================
prompt
create sequence SEQ_T_VALIDBILL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_V_COMMEXT
prompt ===============================
prompt
create sequence SEQ_V_COMMEXT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_V_FUNDFROZEN
prompt ==================================
prompt
create sequence SEQ_V_FUNDFROZEN
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_V_SECTIONATTRIBUTE
prompt ========================================
prompt
create sequence SEQ_V_SECTIONATTRIBUTE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_W_ERRORLOGINLOG
prompt =====================================
prompt
create sequence SEQ_W_ERRORLOGINLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_W_GLOBALLOG_ALL
prompt =====================================
prompt
create sequence SEQ_W_GLOBALLOG_ALL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_W_ROLE
prompt ============================
prompt
create sequence SEQ_W_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_BARGAIN
prompt ==============================
prompt
create sequence SP_V_BARGAIN
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_COMMODITY
prompt ================================
prompt
create sequence SP_V_COMMODITY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_COMMODITYTYPE
prompt ====================================
prompt
create sequence SP_V_COMMODITYTYPE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_COMMODITY_CODE
prompt =====================================
prompt
create sequence SP_V_COMMODITY_CODE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_CURSUBMIT
prompt ================================
prompt
create sequence SP_V_CURSUBMIT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_OUTID
prompt ============================
prompt
create sequence SP_V_OUTID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_PAYMENTFORSELLER
prompt =======================================
prompt
create sequence SP_V_PAYMENTFORSELLER
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_SYSLOG
prompt =============================
prompt
create sequence SP_V_SYSLOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_VOUCHERENTRYID
prompt =====================================
prompt
create sequence SP_V_VOUCHERENTRYID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SP_V_VOUCHERNO
prompt ================================
prompt
create sequence SP_V_VOUCHERNO
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence STOCK_FREEZE
prompt ==============================
prompt
create sequence STOCK_FREEZE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 10;


spool off
