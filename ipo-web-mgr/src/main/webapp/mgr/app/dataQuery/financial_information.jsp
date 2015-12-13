<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金明细</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	 $('#tt').datagrid({  
         title:'资金明细',
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         collapsible:false,
         pagination : true,
         toolbar:"#tb",  
         url:'',  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         remoteSort:false,
         columns : [ [ 
					{field:'',title:'交易商代码',align: "center",width:200},
					{fieid:'',title:'交易商名称',align: "center",width:200},
					{fieid:'',title:'当前可用资金',align: "center",width:200},
					{fieid:'',title:'冻结货款',align: "center",width:200},
					{fieid:'',title:'手续费',align: "center",width:200}
                      ]]
});
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });

	    function doSearch(){
	    	$('#tt').datagrid('load',{
	    		userid: $('#userid').val(),
	    		username: $('#username').val()
	    	});
	    }



</script>
</head>
<body>
<div id="main_body">
			<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<br />
	<div class="div_list">
	<table id="tt" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		<div>
			交易商代码：<input type="text" id="userid" name="userid" />
			交易商名称：<input type="text" id="username" name="username" />
			<input type="button" value="查询" onclick="doSearch()"/>
			<input type="reset" value="重置">	
		</div> 
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>
</html>