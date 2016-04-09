prompt Importing table F_VOUCHERMODEL...
set feedback off
set define off
insert into F_VOUCHERMODEL (CODE, NAME, SUMMARYNO, DEBITCODE, CREDITCODE, NEEDCONTRACTNO, NOTE)
values ('1', '入金-现金', '11001', '1001', '200100-', 'N', null);

insert into F_VOUCHERMODEL (CODE, NAME, SUMMARYNO, DEBITCODE, CREDITCODE, NEEDCONTRACTNO, NOTE)
values ('2', '入金-存款', '11001', '100201', '200100-', 'N', null);

insert into F_VOUCHERMODEL (CODE, NAME, SUMMARYNO, DEBITCODE, CREDITCODE, NEEDCONTRACTNO, NOTE)
values ('3', '出金-现金', '11002', '200100-', '1001', 'N', null);

insert into F_VOUCHERMODEL (CODE, NAME, SUMMARYNO, DEBITCODE, CREDITCODE, NEEDCONTRACTNO, NOTE)
values ('4', '出金-存款', '11002', '200100-', '100201', 'N', null);
commit;

prompt Done.
