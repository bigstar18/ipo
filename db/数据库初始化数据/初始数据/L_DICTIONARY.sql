prompt Importing table L_DICTIONARY...
set feedback off
set define off
insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('FrontMaxErrorLogonTimes', '前台登录最大错误次数', '3', '超过本设置的次数后，前台锁定用户');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('WarehouseMaxErrorLogonTimes', '仓库端登录最大错误次数', '3', '超过本设置的次数后，仓库端锁定用户');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('getLogonUser_ip', '获取在线用户RMI的ip', '10.0.100.181', '访问在线用户rmi的ip信息');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('getLogonUser_port', '获取在线用户RMI的port', '21871', '访问在线用户rmi的port信息');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('getLogonUser_dataPort', '获取在线用户RMI的dataPort', '21872', '访问在线用户rmi的dataPort信息');
commit;

prompt Done.
