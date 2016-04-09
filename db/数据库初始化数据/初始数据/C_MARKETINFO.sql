prompt Importing table C_MARKETINFO...
set feedback off
set define off
insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('JMSBrokerURL', 'tcp://10.0.100.181:20071');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('abbreviation', 'yrdce');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('copyrightof', '中国供销集团');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('frontIsNeedKey', 'N');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('marketEmail', 'service@yrdce.com');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('marketNO', '0');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('marketName', '中国供销集团交易系统');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('marketPhone', '13888888888');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('mgrIsNeedKey', 'N');

insert into C_MARKETINFO (INFONAME, INFOVALUE)
values ('warehouseIsNeedKey', 'N');
commit;

prompt Done.
