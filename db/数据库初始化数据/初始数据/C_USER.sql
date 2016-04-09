prompt Importing table C_USER...
set feedback off
set define off
insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('hl02', '梁非凡', 'cde2bb944d9cb463f52ee4050a5971c2', 'DEFAULT_ADMIN', null, 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('admin', 'admin', 'f2e2aa3200d9c92ff489ff0166b22a9f', 'DEFAULT_SUPER_ADMIN', '超级管理员', 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('0112', '秀', 'df7d81334a137e6c76241a6f44dd3b9e', 'DEFAULT_ADMIN', null, 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('hxx', 'hxx', 'ec867de3ffa50fd55c0a98cc7ad14a37', 'DEFAULT_SUPER_ADMIN', '超级管理员', 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('chenj', 'chenj', '398c8cad8f65891c1b31e62f6d77d09d', 'DEFAULT_SUPER_ADMIN', null, 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('lwd', 'lwd', '53c383e05331d271660e19a65f7f2047', 'DEFAULT_SUPER_ADMIN', null, 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('sc', 'sc', '7d6d7bdffe970b249908d996c3b34030', 'DEFAULT_SUPER_ADMIN', null, 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('byg', 'byg', '9005737b2831518566c69edc6d4f9d50', 'DEFAULT_SUPER_ADMIN', '超级管理员', 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('syb', 'syb', 'b327aa58a62bab24b309db51ba739e6a', 'DEFAULT_SUPER_ADMIN', null, 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('gaob', 'gaob', '2ddfb97eddd03460697bbeff6e18719c', 'DEFAULT_SUPER_ADMIN', null, 'N', 'gray', '0123456789ABCDE');

insert into C_USER (ID, NAME, PASSWORD, TYPE, DESCRIPTION, ISFORBID, SKIN, KEYCODE)
values ('hl', 'hl', 'eb68d0698f51023e898b1303479b2893', 'DEFAULT_SUPER_ADMIN', '超级管理员', 'N', 'gray', '0123456789ABCDE');
commit;

prompt Done.
