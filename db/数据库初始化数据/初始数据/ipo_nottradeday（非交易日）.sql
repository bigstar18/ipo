prompt Importing table IPO_NOTTRADEDAY...
set feedback off
set define off
insert into IPO_NOTTRADEDAY (ID, WEEK, DAY, MODIFYTIME)
values (1, '6,7', '2008-10-01,2008-10-02,2008-10-03,2015-11-30,2015-11-22', to_date('05-04-2016', 'dd-mm-yyyy'));
commit;

prompt Done.
