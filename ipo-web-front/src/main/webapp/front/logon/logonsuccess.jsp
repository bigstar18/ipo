<%@ page contentType="text/html;charset=GBK"%>
<%@page import="gnnt.MEBS.common.front.common.Global"%>
<%@ include file="/front/public/includefiles/path.jsp" %>
<body>
	<form id="frm" action="${request.preUrl}" method="post"></form>
</body>
<script>
frm.action="${frontPath}/app/vendue/vendue1_nkst/submit/main.jsp";
frm.submit();
</script>