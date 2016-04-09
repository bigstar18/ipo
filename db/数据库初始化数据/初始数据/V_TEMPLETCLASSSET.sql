prompt Importing table V_TEMPLETCLASSSET...
set feedback off
set define off
insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (1, 'gnnt.MEBS.vendue.service.impl.FirmLimitImpl', 0, '交易商权限验证');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (2, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForBuy', 1, '竞买商品属性验证');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (3, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForSell', 1, '竞卖商品属性验证');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (4, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForBid', 1, '招标商品属性验证');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (5, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForSplit', 2, '拆分交易规则');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (6, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForMonoblock', 2, '不拆分交易规则');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (7, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForBid', 2, '招标交易规则');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (8, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForBuyImpl', 3, '竞买成交对象');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (9, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForSellImpl', 3, '竞卖成交对象');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (10, 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForBidImpl', 3, '招标成交对象');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (11, 'gnnt.MEBS.priceranking.server.timeEngine.impl.KernelEngineImpl', 4, '竞买竞卖流程控制');

insert into V_TEMPLETCLASSSET (ID, CLASS, TYPE, NAME)
values (13, 'gnnt.MEBS.priceranking.server.timeEngine.impl.CountDownEngineImpl', 5, '倒计时对象');
commit;

prompt Done.
