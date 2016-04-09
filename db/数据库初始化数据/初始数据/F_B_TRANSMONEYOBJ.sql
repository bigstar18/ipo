prompt Importing table F_B_TRANSMONEYOBJ...
set feedback off
set define off
insert into F_B_TRANSMONEYOBJ (ID, CLASSNAME, NOTE)
values (0, 'TransMoneyTradeRate', '划转交易手续费');
commit;

prompt Done.
