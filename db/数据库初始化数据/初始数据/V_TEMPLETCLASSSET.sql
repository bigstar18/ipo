prompt Importing table V_TEMPLETCLASSSET...
set feedback off
set define off
insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (1, 'gnnt.MEBS.vendue.service.impl.FirmLimitImpl', 0, '������Ȩ����֤');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (2, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForBuy', 1, '������Ʒ������֤');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (3, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForSell', 1, '������Ʒ������֤');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (4, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForBid', 1, '�б���Ʒ������֤');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (5, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForSplit', 2, '��ֽ��׹���');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (6, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForMonoblock', 2, '����ֽ��׹���');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (7, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForBid', 2, '�б꽻�׹���');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (8, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForBuyImpl', 3, '����ɽ�����');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (9, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForSellImpl', 3, '�����ɽ�����');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (10, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForBidImpl', 3, '�б�ɽ�����');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (11, 'gnnt.MEBS.priceranking.server.timeEngine.impl.KernelEngineImpl', 4, '���������̿���');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (13, 'gnnt.MEBS.priceranking.server.timeEngine.impl.CountDownEngineImpl', 5, '����ʱ����');
commit;

prompt Done.
