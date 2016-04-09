prompt Importing table IPO_CLEARSTATUS...
set feedback off
set define off
insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (0, '结算开始', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (1, '扣发行手续费,扣托管商品的手续费', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (2, '扣增发的货款,扣增发的手续费', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (3, '扣发售的货款,扣发售的手续费', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (4, '扣过户费', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (5, '扣仓储费,仓库保险费,仓库托管费', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (6, '佣金结算', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));

insert into IPO_CLEARSTATUS (ACTIONID, ACTIONNOTE, STATUS, FINISHTIME)
values (7, '结算完成', 'Y', to_date('05-04-2016 16:15:52', 'dd-mm-yyyy hh24:mi:ss'));
commit;

prompt Done.
