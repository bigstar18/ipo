<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>入库申请</title>
<script src="<%=request.getContextPath()%>/static/ipo/delivery/storageQuery.js" type="text/javascript"></script>
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
			<input type="button" value="查询" onclick="doSearch()"/>		
			<input type="button" value="重置" onclick="clearInfo()"/><br/>
			<input type="button" value="添加" onclick="addStorage()"/>		
		</div>  
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
