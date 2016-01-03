<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>入库单审核</title>

<style type="text/css">
a {color:#00f;}
</style>
<script src="<%=request.getContextPath()%>/static/ipo/delivery/storageApprove.js" type="text/javascript"></script>

</head>
<body>
<div id="main_body">
			
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		 <div>
			入库单号：<input type="text" id="storageid" name="storageid" />
			商品代码：<input type="text" id="commodityid" name="commodityid" />
			入库时间：<input type="text" id="storagedate" name="storagedate"></input> 
			入库状态: 	<select id="storagestate" name="storagestate" style="width:80">
					<option value="">请选择</option>
					<option value="1">申请</option>
					<option value="2">仓库通过</option>
					<option value="3">仓库驳回</option>
					<option value="4">市场通过</option>
					<option value="5">市场驳回</option>
					</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload"  onclick="clearInfo()">重置</a><br/>		
		</div> 
	</div>
	</div>
	
</div>
</body>

</html>
