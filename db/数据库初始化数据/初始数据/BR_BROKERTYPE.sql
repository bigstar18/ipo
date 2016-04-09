prompt Importing table BR_BROKERTYPE...
set feedback off
set define off
insert into BR_BROKERTYPE (BORKERTYPE, BROKERNAME)
values (0, '经纪会员');

insert into BR_BROKERTYPE (BORKERTYPE, BROKERNAME)
values (1, '发行会员');

insert into BR_BROKERTYPE (BORKERTYPE, BROKERNAME)
values (2, '承销会员');
commit;
prompt Done.
