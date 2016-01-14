<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>发行货款跟踪</title>
<script src="<%=request.getContextPath()%>/static/ipo/publisherQuery/paymentTracking.js" type="text/javascript"></script>
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
					  <!--   <a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="addInfo()">添加</a>
					   <a href="#" class="easyui-linkbutton" iconCls="icon-remove" id="view" onclick="deleteList()">删除</a><br/> -->
						商品代码：<input type="text" id="commodityid" name="commodityid" />
						状态：<select id="status" name="status" style="width:80">
						   <option value="">请选择</option>
						   <option value="1">未付款</option>
						   <option value="2">已付款</option>
						</select>
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
