<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>确认配售</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {

	getAllInfo();
	  
});
//加载所有信息
function getAllInfo(){
	$('#name').val("");
	 $('#depositInfo').datagrid({  
         title:'配售信息',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {  
             field : 'test1',  
             width : 200,  
             align: "center",
             title : '商品代码'  
         },{
        	 field : 'test2',  
             width : 200,  
             align: "center",
             title : '增发数量'
         },{  
             field : 'test3',  
             width : 200,  
             align: "center",
             title : '增发价格'  
         },{  
             field : 'test5',  
             width : 200, 
             align: "center",
             title : '配售数量'
         }, {  
             field : 'test7',  
             width : 200, 
             align: "center",
             title : '配售还款'
         },  {  
             field : 'test9',  
             width : 200, 
             align: "center",
             title : '配售手续费'
         }, {  
             field : 'test10',  
             width : 200, 
             align: "center",
             title : '登记日期'
         }, {  
             field : 'test11',  
             width : 200, 
             align: "center",
             title : '增发日期'
         }, {  
             field : 'test12',  
             width : 200, 
             align: "center",
             title : '上市日期'
         }, {  
             field : 'test13',  
             width : 200, 
             align: "center",
             title : '配售状态'
         }, {  
             field : 'test14',  
             width : 200, 
             align: "center",
             title : '操作'
         }]],  
         pagination : true
     });  
	 var p = $('#depositInfo').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
	
}
</script>
</head>
<body>
	<div id="main_body">
<table class="table1_style" border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td>		
		<br />
			<div class="div_list">
				<table id="depositInfo">
				</table>
				<div id="tb" style="padding:5px;height:auto">
					<div>
					<form name="frm" action="" >
					商品代码: <input id="name" name="userid" class="easyui-textbox" style="border:1px solid #ccc" onkeydown='if(event.keyCode==13) return false;'>
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="getAllInfo()">重置</a>					
					</form> 
					</div>
				</div>
				
			</div>
		</td>
	</tr>
</table>
   
</div>
</body>
</html>