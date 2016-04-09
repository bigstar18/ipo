prompt Importing table V_SYSPARTITION...
set feedback off
set define off
insert into V_SYSPARTITION (PARTITIONID, FIRMLIMITCLASS, VALIDETCOMMODITYCLASS, TRADERULECLASS, BARGAINACTIONCLASS, KERNELENGINECLASS, COUNTDOWNCLASS, VALIDFLAG, DESCRIPTION, TRADEMODE, SELFRATE, ISSHOWQUOTATION, MAXSHOWQTY, COUNTMODE, ISMARGINCOUNT, ISSPLITTARGET, ISSHOWPRICE)
values (1, 'gnnt.MEBS.vendue.front.service.impl.FirmLimitImpl', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForBuy', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForSplit', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForBuyImpl', 'gnnt.MEBS.priceranking.server.timeEngine.impl.KernelEngineImpl', 'gnnt.MEBS.priceranking.server.timeEngine.impl.CountDownEngineImpl', 1, '¾ºÂò', 1, 100, 0, 10, 0, 1, 1, 0);

insert into V_SYSPARTITION (PARTITIONID, FIRMLIMITCLASS, VALIDETCOMMODITYCLASS, TRADERULECLASS, BARGAINACTIONCLASS, KERNELENGINECLASS, COUNTDOWNCLASS, VALIDFLAG, DESCRIPTION, TRADEMODE, SELFRATE, ISSHOWQUOTATION, MAXSHOWQTY, COUNTMODE, ISMARGINCOUNT, ISSPLITTARGET, ISSHOWPRICE)
values (2, 'gnnt.MEBS.vendue.front.service.impl.FirmLimitImpl', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForSell', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForSplit', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForSellImpl', 'gnnt.MEBS.priceranking.server.timeEngine.impl.KernelEngineImpl', 'gnnt.MEBS.priceranking.server.timeEngine.impl.CountDownEngineImpl', 1, '¾ºÂô', 2, 100, 0, 3, 0, 0, 0, 0);

insert into V_SYSPARTITION (PARTITIONID, FIRMLIMITCLASS, VALIDETCOMMODITYCLASS, TRADERULECLASS, BARGAINACTIONCLASS, KERNELENGINECLASS, COUNTDOWNCLASS, VALIDFLAG, DESCRIPTION, TRADEMODE, SELFRATE, ISSHOWQUOTATION, MAXSHOWQTY, COUNTMODE, ISMARGINCOUNT, ISSPLITTARGET, ISSHOWPRICE)
values (3, 'gnnt.MEBS.vendue.front.service.impl.FirmLimitImpl', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.ValidetCommodityForBid', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeRuleForBid', 'gnnt.MEBS.priceranking.server.tradeEngine.impl.TradeProcessForBidImpl', 'gnnt.MEBS.priceranking.server.timeEngine.impl.KernelEngineImpl', 'gnnt.MEBS.priceranking.server.timeEngine.impl.CountDownEngineImpl', 1, 'ÕÐ±ê', 3, 100, 0, 3, 0, 0, 0, 0);
commit;

prompt Done.
