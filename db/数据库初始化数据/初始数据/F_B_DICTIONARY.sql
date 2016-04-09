prompt Importing table F_B_DICTIONARY...
set feedback off
set define off
insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (1, 0, null, 'insummary', '11003', '入金摘要');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (2, 0, null, 'outsummary', '11004', '出金摘要');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (3, 0, null, 'feesummary', '11005', '手续费摘要');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (4, 3, null, 'inRateFee', '007', '交易商入金手续费');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (5, 3, null, 'outRateFee', '008', '交易商出金手续费');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (6, 1, '50', 'banksub', '9527', '银行资金科目');
commit;

prompt Done.
