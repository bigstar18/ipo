<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>财务结算</title>
</head>
<body>
	<table id="dg" title="手工结算" class="easyui-datagrid" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th width="500" field="number">序号</th>
				<th width="500" field="process">步骤名称说明</th>
				<th width="500" field="state">状态</th>
				<th width="500" field="finish">完成时间</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>