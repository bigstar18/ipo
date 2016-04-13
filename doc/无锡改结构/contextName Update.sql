select t.*,t.rowid from c_deploy_config t where t.moduleid <>40

update c_deploy_config c set c.contextname='mgr-account' where c.moduleid='11' and c.contextname='finance_mgr';
update c_deploy_config c set c.contextname='account' where c.moduleid='11' and c.contextname='finance_front';

update c_deploy_config c set c.contextname='mgr-warehouse' where c.moduleid='13' and c.contextname='bill_mgr';
update c_deploy_config c set c.contextname='warehouse' where c.moduleid='13' and c.contextname='bill_front';

update c_deploy_config c set c.contextname='mgr-user' where c.moduleid='99' and c.contextname='common_mgr';
update c_deploy_config c set c.contextname='user' where c.moduleid='99' and c.contextname='common_front';

update c_deploy_config c set c.contextname='mgr-public' where c.moduleid='10' and c.contextname='integrated_mgr';
update c_deploy_config c set c.contextname='public' where c.moduleid='10' and c.contextname='integrated_front';

update c_deploy_config c set c.contextname='mgr-member' where c.moduleid='19' and c.contextname='broker_mgr';
update c_deploy_config c set c.contextname='bank' where c.moduleid='28' and c.contextname='bank_front';

update c_deploy_config c set c.contextname='mgr-trade' where c.moduleid='15' and c.contextname='timebargain_mgr';
update c_deploy_config c set c.contextname='trade' where c.moduleid='15' and c.contextname='timebargain_front';

update c_deploy_config c set c.contextname='warehouse-public' where c.moduleid='12' and c.contextname='integrated_warehouse';
update c_deploy_config c set c.contextname='warehouse-user' where c.moduleid='99' and c.contextname='common_warehouse';

update c_deploy_config c set c.contextname='member-user' where c.moduleid='99' and c.contextname='common_broker';
update c_deploy_config c set c.contextname='member-trade' where c.moduleid='15' and c.contextname='timebargain_broker';
update c_deploy_config c set c.contextname='member-public' where c.moduleid='10' and c.contextname='integrated_broker';

commit;
