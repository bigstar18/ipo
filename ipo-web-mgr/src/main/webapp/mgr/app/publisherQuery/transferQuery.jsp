<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>发行库存转持仓</title>
<script src="<%=request.getContextPath()%>/static/ipo/publisherQuery/transferQuery.js" type="text/javascript"></script>
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
					<!--  <a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="addInfo()">添加</a><br/> -->
						商品代码：<input type="text" id="commodityid" name="commodityid" />
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="clearInfo()">重置</a>
					</div>
				</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>

</html>
