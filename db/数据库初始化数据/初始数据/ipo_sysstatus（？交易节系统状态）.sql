prompt Importing table IPO_SYSSTATUS...
set feedback off
set define off
insert into IPO_SYSSTATUS (TRADEDATE, STATUS, SECTIONID, NOTE, RECOVERTIME)
values (to_date('01-04-2016', 'dd-mm-yyyy'), 3, 223, null, null);
commit;

prompt Done.
