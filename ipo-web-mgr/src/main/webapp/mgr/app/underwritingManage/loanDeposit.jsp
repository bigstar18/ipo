<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>承销贷款押金</title>


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
         title:'承销贷款押金',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/LoanDepositController/getAllInfo', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {  
             field : 'name',  
             width : 200,  
             align: "center",
             title : '承销会员编号'  
         },{
        	 field : 'userBalance',  
             width : 200,  
             align: "center",
             title : '可用资金'
         },{  
             field : 'lastwarranty',  
             width : 200,  
             align: "center",
             title : '冻结预付款'  
         }, {  
             field : 'lBalance',  
             width : 200, 
             align: "center",
             title : '余额'
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

//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
}

    
function doSearch(){
	var name=$("#name").val();
	 $('#depositInfo').datagrid({  
         title:'承销贷款押金',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/LoanDepositController/getInfoByName?name='+name, //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器
         columns : [ [ {  
             field : 'name',  
             width : 200,  
             align: "center",
             title : '承销会员编号'  
         },{
        	 field : 'userBalance',  
             width : 200,  
             align: "center",
             title : '可用资金'
         },{  
             field : 'lastwarranty',  
             width : 200,  
             align: "center",
             title : '冻结预付款'  
         }, {  
             field : 'lBalance',  
             width : 200, 
             align: "center",
             title : '余额'
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
<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>		
		<br />
			<div class="div_list">
				<table id="depositInfo">
				</table>
				<div id="tb" style="padding:5px;height:auto">
					<div>
					<form name="frm" action="" >
					商品代码: <input id="name" name="userid" class="easyui-textbox" style="border:1px solid #ccc" value="22">
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
