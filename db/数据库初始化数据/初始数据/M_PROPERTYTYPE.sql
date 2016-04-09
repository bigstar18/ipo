prompt Importing table M_PROPERTYTYPE...
set feedback off
set define off
insert into M_PROPERTYTYPE (PROPERTYTYPEID, NAME, STATUS, SORTNO)
values (160, '数量', 0, 24);

insert into M_PROPERTYTYPE (PROPERTYTYPEID, NAME, STATUS, SORTNO)
values (180, '纯度', 0, 6);

insert into M_PROPERTYTYPE (PROPERTYTYPEID, NAME, STATUS, SORTNO)
values (121, '基本属性', 0, 1);

insert into M_PROPERTYTYPE (PROPERTYTYPEID, NAME, STATUS, SORTNO)
values (122, '质量属性', 0, 2);

insert into M_PROPERTYTYPE (PROPERTYTYPEID, NAME, STATUS, SORTNO)
values (140, '含量', 0, 4);

insert into M_PROPERTYTYPE (PROPERTYTYPEID, NAME, STATUS, SORTNO)
values (120, '绵绵', 0, 3);
commit;

prompt Done.
