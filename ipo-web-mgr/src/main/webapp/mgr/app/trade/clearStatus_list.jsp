<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
	<head>
		<title>财务结算</title>
	</head>
	<body>
		<table id="tb" class="easyui-datagrid" border="0" cellspacing="0" cellpadding="0" width="100%" height="100%"
		toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true">
			<!-- <tr valign="top">
				<td>
					<ec:table items="pageInfo.result" var="clearStatus"
						action="${basePath}/timebargain/tradeManager/clearStatusList.action?sortColumns=order+by+actionId"
						autoIncludeParameters="${empty param.autoInc}"
						xlsFileName="demo.xls" csvFileName="demo.csv"
						showPrint="true" listWidth="100%"
						minHeight="180"  style="table-layout:fixed"
						retrieveRowsCallback="limit" sortRowsCallback="limit"
						filterRowsCallback="limit" toolbarContent="refresh|extend">
						<ec:row>
							<ec:column property="actionId" width="10%" title="序号" style="text-align:center;" sortable="false" />
							<ec:column property="actionNote" title="步骤名称说明" width="10%" style="text-align:center;" sortable="false" />
							<ec:column property="status" title="状态" width="10%" style="text-align:center;" sortable="false" >${clearStatus_statusMap[clearStatus.status]}</ec:column>
							<ec:column property="finishTime" title="完成时间" width="10%" style="text-align:center;" sortable="false" ><fmt:formatDate value="${clearStatus.finishTime }" pattern="yyyy-MM-dd HH:mm:ss"/></ec:column>
						</ec:row>
					</ec:table>
				</td>
			</tr> -->
			<thead>
		    <tr>
		      <th width="50">序号</th>
		      <th width="50">步骤名称说明</th>
		      <th width="50">状态</th>
		      <th width="50">完成时间</th>
		    </tr>
		  </thead>
		</table>
	</body>
</html>