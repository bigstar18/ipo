prompt Importing table T_CLEARSTATUS...
set feedback off
set define off
insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (1, '交收处理', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (2, '重算交易资金', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (3, '重算浮亏', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (0, '结算开始', 'Y', to_date('31-03-2016 22:21:43', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (4, '延期交易结算', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (5, '退上日结算保证金', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (6, '扣当日结算保证金', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (7, '退上日浮亏', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (8, '扣当日浮亏', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (9, '更新交易商资金', 'Y', to_date('23-02-2016 20:46:08', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (10, '导入历史数据', 'Y', to_date('23-02-2016 20:46:09', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (11, '释放冻结数据', 'Y', to_date('23-02-2016 20:46:09', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (12, '返佣操作', 'Y', to_date('23-02-2016 20:46:09', 'dd-mm-yyyy hh24:mi:ss'));

insert into T_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (13, '结算完成', 'Y', to_date('23-02-2016 20:46:09', 'dd-mm-yyyy hh24:mi:ss'));
commit;

prompt Done.
