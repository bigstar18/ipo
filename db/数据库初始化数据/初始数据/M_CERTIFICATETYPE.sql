prompt Importing table M_CERTIFICATETYPE...
set feedback off
set define off
insert into M_CERTIFICATETYPE (CODE, NAME, ISVISIBAL, SORTNO)
values (1, '居民身份证', 'Y', 1);

insert into M_CERTIFICATETYPE (CODE, NAME, ISVISIBAL, SORTNO)
values (2, '士官证', 'Y', 2);

insert into M_CERTIFICATETYPE (CODE, NAME, ISVISIBAL, SORTNO)
values (3, '学生证', 'Y', 3);

insert into M_CERTIFICATETYPE (CODE, NAME, ISVISIBAL, SORTNO)
values (4, '驾驶证', 'Y', 4);

insert into M_CERTIFICATETYPE (CODE, NAME, ISVISIBAL, SORTNO)
values (5, '护照', 'D', 5);

insert into M_CERTIFICATETYPE (CODE, NAME, ISVISIBAL, SORTNO)
values (6, '港澳通行证', 'Y', 6);

insert into M_CERTIFICATETYPE (CODE, NAME, ISVISIBAL, SORTNO)
values (12, '12', 'N', 12);
commit;

prompt Done.
