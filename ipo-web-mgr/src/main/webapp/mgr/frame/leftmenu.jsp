<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<script type="text/javascript" src="<%=publicPath%>/js/xtree.js"></script>
<link rel="stylesheet" href="<%=skinPath%>/css/xtree.css" type="text/css" />
<html>
<head>
<style type="text/css">
body{
	background: #2553a0;
}
.left_body{
	padding-left: 0px;
}
.main_Menu{
	background: url(<%=framePath %>/leftmenupic/left_main.png) no-repeat;
}
.first_Menu{
	/*background: url(<%=framePath %>/leftmenupic/left_first.png) no-repeat;*/
}
.second_Menu{
	/*background: black;*/
	display: none;
}
.main_Span{
	color: #fff;
	line-height: 30px;
	padding-left: 10px;
}
.first_li{
	background: url(<%=framePath %>/leftmenupic/left_first.png) no-repeat;
}
.first_li_change{
	background: url(<%=framePath %>/leftmenupic/left_first2.png) no-repeat;
}
.first_Span{
	cursor: hand;
	color: #fff;
	line-height: 26px;
	padding-left: 25px;
}
.second_li{
	color: #fff;
	background: url(<%=framePath %>/leftmenupic/left_second.png) no-repeat;
}
.second_Span{
	cursor: hand;
	margin-left: 25px;
	line-height: 27px;
	color: #fff;
}

</style>
<script type="text/javascript" src="${publicPath}/js/jquery-1.6.min.js"></script>
</head>
<body>
	<div class="left_body">
		<li class="main_Menu">
			<div class="main_Span">发售管理</div>
			<ul class="first_Menu">
				<li class="first_li">
					<div class="first_Span">运营管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/trade/systemManager.jsp" class="second_Span">交易状态管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/trade/tradeSettle.jsp" class="second_Span">结算处理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/debitFlowController/index" class="second_Span">扣款流水记录</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">交易参数设置</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/TradetimeController/getTradeTimeForward" class="second_Span">交易节管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/CommodityManage" class="second_Span">商品管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/TradetimeController/getNottradedayforward" class="second_Span">非交易日设置</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">交易商特殊设置</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/specialCounterFee/specialCounterFeeSet.jsp" class="second_Span">特殊手续费设置</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">交易商权限设置</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/tradingAuthority/authority_trade.jsp" class="second_Span">权限分配</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">发行管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/QueryController/IssuedManage" class="second_Span">发行摇号</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/pubManager/distributionRule.jsp" class="second_Span">摇号规则</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/pubManager/issuedAdmin.jsp" class="second_Span">摇号规则配置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/QueryController/ApplySuccManage" class="second_Span">申购成交</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/pubManager/publish_goods.jsp" class="second_Span">付发行商货款</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">数据查询</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/CommodityQuery" class="second_Span">商品查询</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">经纪会员查询</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/brokerageReportController/brokerid" class="second_Span">经纪会员结算表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/brokerageReportController/ibrokerid" class="second_Span">经纪会员经纪收入表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/brokerageReportController/pbrokerid" class="second_Span">经纪会员申购收入表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/brokerageReportController/bbrokerid" class="second_Span">经纪会员提货单收入表</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">承销会员查询</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/underwritingQuery/commodityinfo.jsp" class="second_Span">商品承销信息</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">承销会员认购管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/underwritingManage/loanDeposit.jsp" class="second_Span">承销货款押金</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/underwritingManage/underwritingSet.jsp" class="second_Span">承销设置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/underwritingManage/subFundsProcessing.jsp" class="second_Span">认购资金处理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/underwritingManage/reduce.jsp" class="second_Span">承销商分期解冻</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">发行会员管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/publisherQuery/commPubQuery.jsp" class="second_Span">产品发行查询</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/publisherQuery/publish_goods.jsp" class="second_Span">发行货款跟踪</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/publisherQuery/underwriterQuery.jsp" class="second_Span">承销会员查询</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/publisherQuery/transferPosition.jsp" class="second_Span">发行商转持仓</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/publisherQuery/transferQuery.jsp" class="second_Span">库存转持仓查询</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/publisherQuery/reduce.jsp" class="second_Span">发行商减持设置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/PublisherController/settleReports" class="second_Span">发行商结算表</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">统计报表</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/statisticsReportController/purchase" class="second_Span">商品发行申购表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/statisticsReport/index_hold_firm.jsp" class="second_Span">交易商商品持有表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/statisticsReportController/allComid" class="second_Span">商品交易商持有表</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">交收管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/delivery/deliveryProps.jsp" class="second_Span">交收属性管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/StorageApprove" class="second_Span">入库单审核</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/StorageQuery" class="second_Span">查询入库单</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/OutboundQuery" class="second_Span">出库单权限查询</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/DeliveryApprove" class="second_Span">提货单审核</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/DeliveryCancel" class="second_Span">提货单注销</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/IpoController/DeliveryQuery" class="second_Span">提货单查询</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/delivery/stockQuery.jsp" class="second_Span">库存查询</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">申请托管管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/trusteeship/plan.jsp" class="second_Span">托管计划管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/trusteeship/trustWarehouse.jsp" class="second_Span">托管仓库管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/trusteeshipCommodityController/apply" class="second_Span">托管申请管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/trusteeshipCommodityController/turnToPosition" class="second_Span">托管转持仓</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/trusteeshipCommodityController/prereduce" class="second_Span">预减持设置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/trusteeship/positionflow.jsp" class="second_Span">减持设置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/trusteeshipCommodityController/returnGoods" class="second_Span">返还申请人货款</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">增发业务</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/SPO/rationInfo.jsp" class="second_Span">增发商品管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/SPO/orientationassign.jsp" class="second_Span">定向配售</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/SPO/ppPlacingManage.jsp" class="second_Span">定向配售管理</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/SPO/positionflow.jsp" class="second_Span">减持设置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/SPO/increase_publish_goods.jsp" class="second_Span">付发行商货款</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">股份管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/stockManagement/stock_transfer_positions.jsp" class="second_Span">持仓过户</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/stockManagement/stock_freeze.jsp" class="second_Span">持仓冻结/解冻</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">配置管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/chargeitem/index.jsp" class="second_Span">费用项配置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/chargerole/index.jsp" class="second_Span">一般费用配置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/chargeuser/index.jsp" class="second_Span">特殊费用配置</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/dataitem/index.jsp" class="second_Span">数据项配置</div>
						</li>
					</ul>
				</li>
			</ul>
		</li>
	</div>
	<script type="text/javascript">
		$(".second_Span").click(function() {
		 	window.parent.frames["workspace"]["mainFrame"].location.href = $(this).attr("href");
		 	$(".second_Span").css("color", "rgb(255, 255, 255)");
		 	$(this).css("color", "rgb(255, 230, 0)");
		});
		$(".first_Span").click(function() {
		 	$(this).next().slideToggle(80);
		 	$(this).parent().toggleClass("first_li_change");
		});
		$(".first_Span")[0].click();
	</script>
</body>
</html>