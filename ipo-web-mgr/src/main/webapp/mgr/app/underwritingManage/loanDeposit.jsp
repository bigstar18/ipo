<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/app/ipoInclude.jsp"%>
<html>
<head>

<title>承销货款押金</title>
<script type="text/javascript">

$(document).ready(function() {

	getAllInfo();
	  
});
//加载所有信息
function getAllInfo(){
	 $('#name').val("");
	 $('#depositInfo').datagrid({  
         title:'承销货款押金',  
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
             field : 'underwriterid',  
             width : 200,  
             align: "center",
             title : '承销会员编号'  
         },{
        	 field : 'userBalance',
             width : 200,  
             align: "center",
             title : '可用资金'
         },{  
             field : 'amount',  
             width : 200,  
             align: "center",
             title : '冻结预付款'  
         }, {  
             field : 'balance',  
             width : 200, 
             align: "center",
             title : '冻结后余额'
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
	$('#depositInfo').datagrid('load',{
		underwriterid:$("#underwriterid").val()
	});
}
  
function clearInfo(){
	$("#underwriterid").val("");
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
					承销会员编号: <input id="underwriterid" name="underwriterid" class="easyui-textbox" style="border:1px solid #ccc" >
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="clearInfo()">重置</a>
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
