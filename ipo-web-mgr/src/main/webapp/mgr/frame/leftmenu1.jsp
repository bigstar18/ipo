<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
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
		<c:forEach var="menu" items="${HaveRightMenu.childMenuSet}">
			<li class="main_Menu">
				<div class="main_Span">${menu.name}</div>
				<ul class="first_Menu">
					<c:set var="firstMenu" value="${menu.childMenuSet}"></c:set>
					<c:forEach var="firstMenu" items="${firstMenu}">
						<li class="first_li">
							<div class="first_Span">${firstMenu.name}</div>
							<ul class="second_Menu">
								<c:set value="${firstMenu.childMenuSet}" var="secondMenu"></c:set>
								<c:forEach var="secondMenu" items="${secondMenu}">
									<li class="second_li">
										<div href="${basePath}${secondMenu.url}" class="second_Span">${secondMenu.name}</div>
									</li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
	</div>
	<script type="text/javascript">
		$(".second_Span").click(function() {
		 	window.parent.frames["workspace"]["mainFrame"].location.href = $(this).attr("href");
		 	$(".second_Span").css("color", "rgb(255, 255, 255)");
		 	$(this).css("color", "#ffde00");
		});
		$(".first_Span").click(function() {
		 	$(this).next().slideToggle(150);
		 	$(this).parent().toggleClass("first_li_change");
		});
		$(".first_Span")[0].click();
	</script>
</body>
</html>