<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>提货单注销</title>
<script src="<%=request.getContextPath()%>/static/ipo/delivery/cancel.js" type="text/javascript"></script>
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
			提货单号：<input type="text" id="deliveryorderId" name="deliveryorderId" />
			申请日期：<input type="text" id="applyDate" name="applyDate"></input> 
			交易商代码：<input type="text" id="dealerId" name="dealerId" />
			<input type="button" value="查询" onclick="doSearch()"/>		
			<input type="button" value="重置" onclick="clearInfo()"/>			
		</div> 
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
