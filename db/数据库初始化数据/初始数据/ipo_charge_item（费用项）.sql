prompt Importing table IPO_CHARGE_ITEM...
set feedback off
set define off
insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('003003', '提单过户费', 1, '003', 1, '提单过户费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('003002', '提单注销费', 1, '003', 1, '提货单注销费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('004003', '托管费', 1, '004', 3, '托管费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('004002', '保险费', 1, '004', 2, '保险费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('004001', '仓储费', 1, '004', 1, '仓储费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('003001', '提单注册费', 1, '003', 1, '提货单注册费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('003004', '提单配送费', 1, '003', 1, '提单配送费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('001', '手续费', 1, '0', 1, '手续费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('002', '货款', 1, '0', 2, '货款', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), 'hl', to_date('14-03-2016 21:21:25', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('003', '交收费用', 1, '0', 3, '交收费用', 0, '0', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('004', '仓库费用', 1, '0', 4, '仓库费用', 0, '0', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('005', '挂牌费', 1, '0', 5, '挂牌费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('006', '佣金', 1, '0', 6, '佣金', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), 'sc', to_date('27-01-2016 20:27:55', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CHARGE_ITEM (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('007', '其他费', 1, '0', 7, '其他费', 0, '1', 'hl', to_date('15-01-2016 14:54:46', 'dd-mm-yyyy hh24:mi:ss'), null, null);
commit;

prompt Done.
