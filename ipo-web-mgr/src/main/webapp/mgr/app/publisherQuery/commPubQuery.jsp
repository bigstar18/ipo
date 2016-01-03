<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>产品发行查询</title>
<script src="<%=request.getContextPath()%>/static/ipo/delivery/commPubQuery.js" type="text/javascript"></script>
</head>
<body>
<div id="main_body">
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		 <div>
			发行会员编号：<input type="text" id="pubmemberid" name="pubmemberid" />
			<input type="button" value="查询" onclick="doSearch()"/>		
			<input type="button" value="重置" onclick="clearInfo()"/>			
		</div>  
	</div>
	</div>
</div>
</body>

</html>
