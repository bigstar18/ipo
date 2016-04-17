<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/broker/public/includefiles/allincludefiles.jsp"%>
<%@page import="java.lang.String" %>
<html>
<head>
<style type="text/css">
body{
	background:#576a85;
}
.left_body{
	padding-left: 0px;
}
.main_Menu{
}
.first_Menu{
}
.second_Menu{
		border-top: 1px solid #7d92af;
		color: #fff;
		font-size: 12px;
		font-family: "微软雅黑";
		text-align: left;
		display: none;
		padding-left: 45px;
		cursor: hand;
		background:#576a85;
}
.main_Span{
		background-color:#4f627c;
		height: 35px;
		line-height: 35px;
		border-top:1px solid #617591;
		border-bottom: 1px solid #3d4e68;
		color: #fffbbd;
		font-size: 14px;
		font-family: "微软雅黑";
		text-align: left;
		padding-left: 20px;
		cursor: hand;
}
.first_li{
}
.first_li_change{
}
.first_Span{
		background-color:#6c809c;
		color: #fff;
		font-size: 13px;
		font-family: "微软雅黑";
		border-bottom: 1px solid #5e728e;
		border-top: 1px solid #7d92af;
		text-align: left;
		padding-left: 30px;
		cursor: hand;
		height:28px;
		line-height: 28px;
}

.second_Span{
		height: 25px;
		line-height: 25px;
		font-family:"微软雅黑";
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