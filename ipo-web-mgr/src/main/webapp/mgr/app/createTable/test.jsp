<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>

<html>
<head>
<title>动态生成table测试</title>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script src="CreateTable.js"  type="text/javascript"></script>
</head>
<body>
	<div id="createTable"></div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var titles = new Array();//标题
	var ttt=new Array();//内容
	for(var k=0;k<5;k++){
		ttt[k]= new Array();
		for(var j=0;j<5;j++){
			ttt[k][j]="www"+j;
		}
	}
	titles[0] = "q";
	titles[1] = "w";
	titles[2] = "e";
	titles[3] = "r";
	titles[4] = "t";
	createTable("#createTable",titles,ttt);//主函数
});

</script>

</html>