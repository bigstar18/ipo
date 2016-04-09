prompt Importing table BR_TRADEMODULE...
set feedback off
set define off
insert into BR_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME)
values (15, '订单大宗商品交易系统', null, '订单系统');

insert into BR_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME)
values (40, '发售系统', null, '发售系统');
commit;

prompt Done.
