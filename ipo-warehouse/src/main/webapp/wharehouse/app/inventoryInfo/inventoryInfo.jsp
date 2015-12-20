<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/wharehouse/public/includefiles/allincludefiles.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<title>库存汇总信息查询</title>

<script type="text/javascript">
$(document).ready(function() {

	getAllInfo();
	  
});
//加载所有信息
function getAllInfo(){
	$('#name').val("");
	 $('#storageInfo').datagrid({  
         title:'库存信息',  
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
             field : 'test1',  
             width : 200,  
             align: "center",
             title : '序号'  
         },{
        	 field : 'test16',  
             width : 200,  
             align: "center",
             title : '商品代码'
         },{  
             field : 'test3',  
             width : 200,  
             align: "center",
             title : '商品名称'  
         }, {  
             field : 'test4',  
             width : 200, 
             align: "center",
             title : '发行会员代码'
         }, {  
             field : 'test5',  
             width : 200, 
             align: "center",
             title : '发行会员名称'
         }, {  
             field : 'test6',  
             width : 200, 
             align: "center",
             title : '入库数量'
         }, {  
             field : 'test7',  
             width : 200, 
             align: "center",
             title : '冻结数量'
         }, {  
             field : 'test8',  
             width : 200, 
             align: "center",
             title : '有效数量'
         }, {  
             field : 'test9',  
             width : 200, 
             align: "center",
             title : '出库数量'
         }]],  
         pagination : true
     });  
	 var p = $('#storageInfo').datagrid('getPager'); 
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
				<table id="storageInfo">
				</table>
				<div id="tb" style="padding:5px;height:auto">
					<div>
					<form name="frm" action="" >
					商品代码: <input id="name" name="userid" class="easyui-textbox" style="border:1px solid #ccc;height:18px;width:160px;" onkeydown='if(event.keyCode==13) return false;'>
					&nbsp

						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="">重置</a>					
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