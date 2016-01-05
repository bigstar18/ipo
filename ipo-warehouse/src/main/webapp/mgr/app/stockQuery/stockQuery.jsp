<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>入库申请</title>
<script src="<%=request.getContextPath()%>/static/ipo/stockQuery/stockQuery.js" type="text/javascript"></script>
</head>
<body>
<div id="main_body">
			
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		 <div>
			
			商品代码：<input type="text" id="commodityid" name="commodityid" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload"  onclick="clearInfo()">重置</a><br/>
		</div>  
	</div>
	</div>
	
</div>
</body>

</html>
