prompt Importing table F_CLEARSTATUS...
set feedback off
set define off
insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (0, '结算开始', 'Y', to_date('28-01-2016 20:43:25', 'dd-mm-yyyy hh24:mi:ss'));

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (1, '抽取电脑凭证', 'N', null);

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (2, '归属流水及凭证日期', 'N', null);

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (3, '将凭证记入会计账簿', 'N', null);

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (4, '结算账户', 'N', null);

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (5, '生成客户总账', 'N', null);

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (6, '归档历史表', 'N', null);

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (7, '生成交易商清算资金数据', 'N', null);

insert into F_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (8, '结算完成', 'N', null);
commit;

prompt Done.
