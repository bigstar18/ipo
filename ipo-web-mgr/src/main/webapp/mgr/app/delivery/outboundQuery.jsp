<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>出库单权限查询</title>
<script src="<%=request.getContextPath()%>/static/ipo/delivery/outboundQuery.js" type="text/javascript"></script>
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
			出库单号：<input type="text" id="outboundorderid" name="outboundorderid" />
			出库日期：<input type="text" id="outbounddate" name="outbounddate"></input> 
			出库状态: 	<select id="outboundstate" name="outboundstate" style="width:80">
					<option value="">请选择</option>
					<option value="1">申请</option>
					<option value="2">审核通过</option>
					<option value="3">审核驳回</option>
					</select>
			提货单号：<input type="text" id="deliveryorderid" name="deliveryorderid" />
			提货类型：<select id="deliveryMethod" name="deliveryMethod" style="width:80">
					<option value="">请选择</option>
					<option value="自提">自提</option>
					<option value="在线配送">在线配送</option>
					</select>
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
