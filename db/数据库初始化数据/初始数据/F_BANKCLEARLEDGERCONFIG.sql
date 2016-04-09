prompt Importing table F_BANKCLEARLEDGERCONFIG...
set feedback off
set define off
insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('BankFee', 0, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('Margin_T', 1, -1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('SettleMargin_T', 1, -1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('FL_T', 1, -1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('TradeFee_T', 0, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('SettleFee_T', 0, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('Margin_E', 1, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('MarginBack_E', 1, -1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('TradeFee_E', 0, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('SettleFee_E', 0, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('Subscirption_E', 1, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('Margin_V', 1, 1);

insert into F_BANKCLEARLEDGERCONFIG (LEDGERCODE, FEETYPE, FIELDSIGN)
values ('TradeFee_V', 0, 1);
commit;

prompt Done.
