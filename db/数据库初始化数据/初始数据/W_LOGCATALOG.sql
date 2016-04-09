prompt Importing table W_LOGCATALOG...
set feedback off
set define off
insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (9901, 99, '个人维护');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (3203, 32, '登录退出');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (3204, 32, '修改密码');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (1201, 12, '角色管理');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (1202, 12, '管理员管理');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (1211, 12, '仓单录入');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (1212, 12, '拆仓单管理');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (1213, 12, '仓单出库');

insert into W_LOGCATALOG (CATALOGID, MODULEID, CATALOGNAME)
values (4001, 40, 'IPO系统');
commit;

prompt Done.
