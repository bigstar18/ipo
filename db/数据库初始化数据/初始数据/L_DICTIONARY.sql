prompt Importing table L_DICTIONARY...
set feedback off
set define off
insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('FrontMaxErrorLogonTimes', 'ǰ̨��¼���������', '3', '���������õĴ�����ǰ̨�����û�');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('WarehouseMaxErrorLogonTimes', '�ֿ�˵�¼���������', '3', '���������õĴ����󣬲ֿ�������û�');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('getLogonUser_ip', '��ȡ�����û�RMI��ip', '10.0.100.181', '���������û�rmi��ip��Ϣ');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('getLogonUser_port', '��ȡ�����û�RMI��port', '21871', '���������û�rmi��port��Ϣ');

insert into L_DICTIONARY (KEY, NAME, VALUE, NOTE)
values ('getLogonUser_dataPort', '��ȡ�����û�RMI��dataPort', '21872', '���������û�rmi��dataPort��Ϣ');
commit;

prompt Done.
