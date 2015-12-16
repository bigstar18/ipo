<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>提货单查询</title>
<script src="<%=request.getContextPath()%>/mgr/app/delivery/query.js" type="text/javascript"></script>
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
	 <form id="frm" name="frm" method="POST">
		<div>
			提货单号：<input type="text" id="deliveryorderId" name="deliveryorderId" />
			申请日期：<input type="text" id="applyDate" name="applyDate"></input> 
			提货单状态: 	<select id="approvalStatus" name="approvalStatus" style="width:80">
					<option value="">请选择</option>
					<option value="1">未审核</option>
					<option value="2">通过</option>
					<option value="3">驳回</option>
					<option value="4">已收货</option>
					<option value="5">废除</option>
					</select>
			交易商代码：<input type="text" id="dealerId" name="dealerId" />
			<input type="button" value="查询" onclick="doSearch()"/>		
			<input type="button" value="重置" onclick="clearInfo()"/>			
		</div> 
		</from>
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
