<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>托管仓库管理</title>
<script src="<%=request.getContextPath()%>/static/ipo/trusteeship/trustWarehouse.js" type="text/javascript"></script>
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
	 <div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTrusteeWareHouse()" >添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteTrusteeWareHouse()">删除</a><br/>
			商品代码：<input type="text" id="commodityId" name="commodityId" />
			商品名称：<input type="text" id="commodityName" name="commodityName" />
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
