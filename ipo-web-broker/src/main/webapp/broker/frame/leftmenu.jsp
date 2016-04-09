<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/broker/public/includefiles/allincludefiles.jsp"%>
<%@page import="java.lang.String" %>

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
			<div class="main_Span">发行客户端</div>
			<ul class="first_Menu">
				<li class="first_li">
					<div class="first_Span">发行会员查询</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/broker/app/publisherQuery/commPubQuery.jsp" class="second_Span">产品发行查询</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/broker/app/publisherQuery/publish_goods.jsp" class="second_Span">发行货款跟踪</div>
						</li>
					</ul>
				</li>
				<li class="first_li">
					<div class="first_Span">统计报表</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/broker/app/publisherQuery/settleReports.jsp" class="second_Span">发行会员结算表</div>
						</li>
					</ul>
				</li>
			</ul>
		</li>
		<li class="main_Menu">
			<div class="main_Span">经纪会员客户端</div>
			<ul class="first_Menu">
				<li class="first_li">
					<div class="first_Span">经纪会员查询</div>
					<ul class="second_Menu">
						<li class="second_li">
							<div href="<%=basePath%>/broker/app/brokeragereport/queryindex.jsp" class="second_Span">经纪会员结算表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/broker/app/brokeragereport/incomeindex.jsp" class="second_Span">经纪会员经纪收入表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/broker/app/brokeragereport/purchaseincomeindex.jsp" class="second_Span">经纪会员申购收入表</div>
						</li>
						<li class="second_li">
							<div href="<%=basePath%>/broker/app/brokeragereport/billofladingincome_index.jsp" class="second_Span">经纪会员提货单收入表</div>
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