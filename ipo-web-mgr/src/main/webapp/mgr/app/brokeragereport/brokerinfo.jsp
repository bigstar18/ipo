<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script src="CreateTable.js"  type="text/javascript"></script>
<title>报表展示</title>
</head>
<body>
	<div id="createTable" align="center"></div>
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