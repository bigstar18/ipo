<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>承销会员查询</title>
<script src="<%=request.getContextPath()%>/static/ipo/publisherQuery/underwriterQuery.js" type="text/javascript"></script>
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
			发行会员编号：<input type="text" id="pubmemberid" name="pubmemberid" />
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
