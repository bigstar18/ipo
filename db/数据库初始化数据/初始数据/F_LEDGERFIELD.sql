prompt Importing table F_LEDGERFIELD...
set feedback off
set define off
insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('SellOtherItem_I', '发售卖出杂费', -1, '40', 40004, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('DeliveryGoods_I', '发售交货费用', -1, '40', 40005, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Payout_I', '发售购货支出', -1, '40', 40001, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('TradeFee_I', '发售交易手续费', -1, '40', 40103, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Income_I', '发售销售收入', 1, '40', 40002, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Deposit', '入金', 1, '11', 1, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Fetch', '出金', -1, '11', 2, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('BankFee', '银转手续费', -1, '11', 3, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('OtherItem', '当日其他项', 1, '11', 4, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Margin_T', '订单保证金变动', 1, '15', 15000, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('FL_T', '订单浮亏变动', 1, '15', 15001, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('SettleMargin_T', '订单交收保证金变动', 1, '15', 15002, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('TradePL_T', '订单转让盈亏', 1, '15', 15003, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('SettlePL_T', '订单交收盈亏', 1, '15', 15004, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Income_T', '订单销售收入', 1, '15', 15005, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Payout_T', '订单购货支出', -1, '15', 15006, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('TradeFee_T', '订单交易手续费', -1, '15', 15007, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('SettleFee_T', '订单交收手续费', -1, '15', 15008, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('SettleCompens_T', '订单交割补偿费', 1, '15', 15009, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('OtherItem_T', '订单当日其他项', 1, '15', 15010, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('TradeFee_E', '现货收交易手续费', -1, '23', 23000, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Margin_E', '现货收交收保证金', -1, '23', 23001, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('MarginBack_E', '现货退交收保证金', 1, '23', 23002, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('SettleFee_E', '现货收交收费用', -1, '23', 23003, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Payout_E', '现货收交易商货款', -1, '23', 23004, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Income_E', '现货付交易商货款', 1, '23', 23005, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Subscirption_E', '诚信保障金', -1, '23', 23006, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('OtherItem_E', '现货当日其他项', 1, '23', 23007, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Income_V', '竞价销售收入', 1, '21', 21000, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Payout_V', '竞价购货支出', -1, '21', 21001, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('TradeFee_V', '竞价交易手续费', -1, '21', 21002, 'Y');

insert into F_LEDGERFIELD (CODE, NAME, FIELDSIGN, MODULEID, ORDERNUM, ISINIT)
values ('Margin_V', '竞价保证金', -1, '21', 21003, 'Y');
commit;

prompt Done.
