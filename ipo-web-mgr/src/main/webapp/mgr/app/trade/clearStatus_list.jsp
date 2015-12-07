<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>财务结算</title>
<script src="<%=request.getContextPath()%>/static/ipo/clearStatus.js" type="text/javascript"></script>
</head>
<body>
	<table id="dg" title="手工结算" class="easyui-datagrid" toolbar="#toolbar" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th width="50" field="number">序号</th>
				<th width="50" field="process">步骤名称说明</th>
				<th width="50" field="state">状态</th>
				<th width="50" field="finish">完成时间</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>0</td>
				<td>结算开始</td>
				<td>未执行</td>
				<td></td>
			</tr>
			<tr>
				<td>1</td>
				<td>收付当日货款、手续费开始</td>
				<td>未执行</td>
				<td></td>
			</tr>
			<tr>
				<td>2</td>
				<td>更新交易商资金</td>
				<td>未执行</td>
				<td></td>
			</tr>
			<tr>
				<td>3</td>
				<td>导入历史数据</td>
				<td>未执行</td>
				<td></td>
			</tr>
			<tr>
				<td>4</td>
				<td>释放冻结数据</td>
				<td>未执行</td>
				<td></td>
			</tr>
			<tr>
				<td>5</td>
				<td>结算完成</td>
				<td>未执行</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>