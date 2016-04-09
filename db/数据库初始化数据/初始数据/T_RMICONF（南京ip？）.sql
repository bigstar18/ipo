prompt Importing table T_RMICONF...
set feedback off
set define off
insert into T_RMICONF (SERVICEID, CNNAME, ENAME, HOSTIP, PORT, RMIDATAPORT, ENABLED)
values (1, '条件下单服务', 'ConditionOrder', '172.17.12.22', 21011, 21012, 'Y');
commit;

prompt Done.
