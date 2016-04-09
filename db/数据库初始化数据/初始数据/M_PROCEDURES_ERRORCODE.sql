prompt Importing table M_PROCEDURES_ERRORCODE...
set feedback off
set define off
insert into M_PROCEDURES_ERRORCODE (MODULEID, ERRORCODE, ERRORINFO)
values (11, -901, '交易商资金不为0');

insert into M_PROCEDURES_ERRORCODE (MODULEID, ERRORCODE, ERRORINFO)
values (13, -130, '交易商有可用的仓单');

insert into M_PROCEDURES_ERRORCODE (MODULEID, ERRORCODE, ERRORINFO)
values (28, -1, '交易商有与银行签约信息');

insert into M_PROCEDURES_ERRORCODE (MODULEID, ERRORCODE, ERRORINFO)
values (10, -900, '交易商不存在');
commit;

prompt Done.
