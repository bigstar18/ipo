prompt Importing table W_TRADEMODULE...
set feedback off
set define off
insert into W_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (99, 'common', '����ϵͳ', '����ϵͳ', null, null, null, 'N', null, null, null, 'N', 'Y');

insert into W_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (12, 'integrated', '�ۺ�ϵͳ', '�ۺ�ϵͳ', null, null, null, 'N', null, null, null, 'N', 'Y');

insert into W_TRADEMODULE (MODULEID, CNNAME, ENNAME, SHORTNAME, ADDFIRMFN, UPDATEFIRMSTATUSFN, DELFIRMFN, ISFIRMSET, HOSTIP, PORT, RMIDATAPORT, ISBALANCECHECK, ISNEEDBREED)
values (40, 'ipo', '���۲ֿ�', '���۲ֿ�', null, null, null, 'N', null, null, null, 'N', 'Y');
commit;

prompt Done.
