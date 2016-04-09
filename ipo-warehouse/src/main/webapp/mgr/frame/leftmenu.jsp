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
					<div class="first_Span">入库流程</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/storage/storageQuery.jsp" class="second_Span">入库申请</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/storage/storageApprove.jsp" class="second_Span">入库单审核</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">出库流程</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/outbound/outboundApplication.jsp" class="second_Span">出库申请</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/outbound/outboundaudit.jsp" class="second_Span">出库单审核</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">配送管理</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/expressFeeSet/approve.jsp" class="second_Span">配送查询及设置</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">库存信息</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/mgr/app/stockQuery/stockQuery.jsp" class="second_Span">库存汇总信息查询</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">库转交易</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/trusteeshipCommodityController/apply" class="second_Span">初步托管审核</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/trusteeshipCommodityController/lastApply" class="second_Span">最终托管审核</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/trusteeshipCommodityController/query" class="second_Span">托管申请查询</div>
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