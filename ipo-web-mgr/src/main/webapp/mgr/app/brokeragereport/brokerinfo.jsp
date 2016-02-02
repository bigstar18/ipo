<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%> 
<html>
<head> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/mgr/app/createTable/CreateTable.js"  type="text/javascript"></script>
<title>报表展示</title>
</head>
<body>
	<div id="createTable" align="center"></div>
	
	
	
	
</body>


<script type="text/javascript">
$(document).ready(function(){
	var titles = new Array();//标题
	var ttt=new Array();//内容
	for(var k=0;k<6;k++){
		ttt[k]= new Array();
		for(var j=0;j<10;j++){
			ttt[k][j]="www"+j;
		}
	}
	
	ttt[k]= new Array();
	
	
	
	titles[0] = "序号";
	titles[1] = "商品代码";
	titles[2] = "商品名称";
	titles[3] = "发行价格";
	titles[4] = "申购时间";
	titles[5] = "申购数量";
	titles[6] = "申购金额";
	titles[7] = "发行服务费";
	titles[8] = "退还申购金额";
	titles[9] = "退还发行服务费";
	
	createTable("#createTable",titles,ttt);//主函数
	<c:forEach items="${releaInfo}" var="a">
	</c:forEach>
	
});

</script>
</html>