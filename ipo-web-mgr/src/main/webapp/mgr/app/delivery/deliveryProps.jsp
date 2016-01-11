<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>

<html>
<head>

<title>交收属性管理</title>
<script src="<%=request.getContextPath()%>/static/ipo/delivery/deliveryProps.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div id="main_body">
	<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<br />
				<div class="div_list">
				<table id="dg" width="100%"></table>
				 <div id="tb" style="padding:5px;height:auto">
					<div>
						商品代码：<input type="text" id="commodityId" name="commodityId" />
						商品名称：<input type="text" id="commodityName" name="commodityName" />
						<input type="button" value="查询" onclick="doSearch()"/>
						<input type="button" value="重置" onclick="clearInfo()"/>
					</div>
				</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>

</html>
