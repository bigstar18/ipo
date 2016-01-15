   
-- 一级费用   
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('001', '手续费', 1, '0', 1, '手续费', 0, '0', 'hl', sysdate, null, null);
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('002', '押金', 1, '0', 2, '押金', 0, '1', 'hl', sysdate, null, null);

insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('003', '预付款', 1, '0', 3, '预付款', 0, '1', 'hl', sysdate, null, null);
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('004', '挂牌费', 1, '0', 4, '挂牌费', 0, '1', 'hl', sysdate, null, null);

insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('005', '滞纳金', 1, '0', 5, '滞纳金', 0, '1', 'hl', sysdate, null, null);
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('006', '过户费', 1, '0', 6, '过户费', 0, '1', 'hl', sysdate, null, null);
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('007', '服务费', 1, '0', 7, '服务费', 0, '1', 'hl', sysdate, null, null);   
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('008', '运费', 1, '0', 8, '运费', 0, '1', 'hl', sysdate, null, null);   
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('009', '提货单费', 1, '0', 9, '提货单费', 0, '1', 'hl', sysdate, null, null);       

insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('010', '发行费', 1, '0', 10, '发行费', 0, '1', 'hl', sysdate, null, null); 

-- 二级费用
insert into ipo_charge_item (ID, NAME, TYPE, PARENT_ID, SORT_ID, REMARK, DELETE_FLAG, LEAF, CREATE_USER, CREATE_DATE, UPDATE_USER, UPDATE_DATE)
values ('001001', '增发手续费', 1, '001', 1, '增发手续费', 0, '1', 'hl', sysdate, null, null);   
   
   