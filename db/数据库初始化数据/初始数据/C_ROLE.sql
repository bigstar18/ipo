prompt Importing table C_ROLE...
set feedback off
set define off
insert into C_ROLE (ID, NAME, DESCRIPTION)
values (1, '交易部', '交易部');

insert into C_ROLE (ID, NAME, DESCRIPTION)
values (41, '全面权限', null);

insert into C_ROLE (ID, NAME, DESCRIPTION)
values (43, '技术部', null);

insert into C_ROLE (ID, NAME, DESCRIPTION)
values (42, '交收部', null);

insert into C_ROLE (ID, NAME, DESCRIPTION)
values (61, '风控', null);

insert into C_ROLE (ID, NAME, DESCRIPTION)
values (101, '供销集团', null);
commit;

prompt Done.
