prompt Importing table F_B_DICTIONARY...
set feedback off
set define off
insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (1, 0, null, 'insummary', '11003', '���ժҪ');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (2, 0, null, 'outsummary', '11004', '����ժҪ');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (3, 0, null, 'feesummary', '11005', '������ժҪ');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (4, 3, null, 'inRateFee', '007', '���������������');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (5, 3, null, 'outRateFee', '008', '�����̳���������');

insert into F_B_DICTIONARY (ID, TYPE, BANKID, NAME, VALUE, NOTE)
values (6, 1, '50', 'banksub', '9527', '�����ʽ��Ŀ');
commit;

prompt Done.
