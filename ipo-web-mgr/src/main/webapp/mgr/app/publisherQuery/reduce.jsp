<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>��������</title>
<script src="<%=request.getContextPath()%>/static/ipo/publisherQuery/reduce.js" type="text/javascript"></script>
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
						���л�Ա��ţ�<input type="text" id="publisherid" name="publisherid" />
						��Ʒ���룺<input type="text" id="commodityid" name="commodityid" />
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">��ѯ</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="clearInfo()">����</a>
					</div>
				</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>

</html>
