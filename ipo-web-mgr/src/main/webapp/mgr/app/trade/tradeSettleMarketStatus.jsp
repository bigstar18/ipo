<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>结算</title>
<script src="<%=request.getContextPath()%>/static/ipo/tradeSettle.js" type="text/javascript"></script>
</head>
<body>
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="middle">
				<button class="anniu_btn" id="add" action="/issue/tradeEnd/tradeEnd.action" onclick="addF();">手工结算</button>&nbsp;&nbsp;<font style="font-size: 13px;" id="balanceStatus"></font>
		</td>
		</tr>
	</table>
</body>
</html>