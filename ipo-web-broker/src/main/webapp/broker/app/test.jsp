<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>

<html>
<head>
<title>excel导出测试</title>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-tableexport/tableExport.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-tableexport/jquery.base64.js"  type="text/javascript"></script>
<style type="text/css">
	table{border-collapse:collapse;border-spacing:0;border-left:1px solid #000;border-top:1px solid #000;}
	th,td{border-right:1px solid #000;border-bottom:1px solid #000;padding:5px 15px;}
	th{font-weight:bold;background:#000;}
</style>

</head>
<body>
	<button type="button" onclick="exportTable()">
            <i>导出Excel</i>
    </button>
    
    <table id="test">
    	<tr>
    		<td>
    		学号
    		</td>
    		<td>
    		姓名
    		</td>
    		<td>
    		班级
    		</td>
    		<td>
    		性别
    		</td>		
    	</tr>
    	<tr>
    		<td>
    		001
    		</td>
    		<td>
    		张三
    		</td>
    		<td>
    		30
    		</td>
    		<td>
    		男
    		</td>		
    	</tr>
    	<tr>
    		<td>
    		002
    		</td>
    		<td>
    		李四
    		</td>
    		<td>
    		29
    		</td>
    		<td>
    		女
    		</td>		
    	</tr>
    </table>
</body>

<script type="text/javascript">
	function exportTable(){
		$('#test').tableExport({ 
			type: 'excel', 
			separator: ';',
			escape: 'false' 
			});
	}

</script>

</html>