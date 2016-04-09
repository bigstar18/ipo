prompt Importing table W_TRADEMODULE...
set feedback off
set define off
insert into W_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (99, 'common', '公用系统', '公用系统', null, null, null, 'N', null, null, null, 'N', 'Y');

insert into W_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (12, 'integrated', '综合系统', '综合系统', null, null, null, 'N', null, null, null, 'N', 'Y');

insert into W_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (40, 'ipo', '发售仓库', '发售仓库', null, null, null, 'N', null, null, null, 'N', 'Y');
commit;

prompt Done.
