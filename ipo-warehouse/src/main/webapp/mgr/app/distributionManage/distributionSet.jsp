<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/wharehouse/public/includefiles/allincludefiles.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<title>配送查询及设置</title>

<script type="text/javascript">
$(document).ready(function() {

	getAllInfo();
	  
});
//加载所有信息
function getAllInfo(){
	$('#name').val("");
	 $('#storageInfo').datagrid({  
         title:'配送信息',  
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
        	 field : 'test2',  
             width : 200,  
             align: "center",
             title : '提货单号'
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
             title : '交易商代码'
         }, {  
             field : 'test5',  
             width : 200, 
             align: "center",
             title : '交易商名称'
         }, {  
             field : 'test6',  
             width : 200, 
             align: "center",
             title : '收货人姓名'
         }, {  
             field : 'test7',  
             width : 200, 
             align: "center",
             title : '电话'
         }, {  
             field : 'test8',  
             width : 200, 
             align: "center",
             title : '地址'
         }, {  
             field : 'test9',  
             width : 200, 
             align: "center",
             title : '邮编'
         }, {  
             field : 'test10',  
             width : 200, 
             align: "center",
             title : '状态'
         }, {  
             field : 'test11',  
             width : 200, 
             align: "center",
             title : '申请时间'
         }, {  
             field : 'test12',  
             width : 200, 
             align: "center",
             title : '发货日期'
         }, {  
             field : 'test13',  
             width : 200, 
             align: "center",
             title : '配送费用'
         }, {  
             field : 'test14',  
             width : 200, 
             align: "center",
             title : '录入员'
         },{  
             field : 'test17',  
             width : 200, 
             align: "center",
             title : '处理',
             formatter:function(value,row){
     	      	   return "<a href=\"#\" onclick=\"updatePoundForward("+row.poundageId+")\">通过</a><a href=\"#\" onclick=\"updatePoundForward("+row.poundageId+")\">驳回</a>";
     	      } 
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
					提货单号: <input id="name" name="userid" class="easyui-textbox" style="border:1px solid #ccc;height:18px;width:160px;" onkeydown='if(event.keyCode==13) return false;'>
					&nbsp
					申请时间: <input id="name" name="userid" class="easyui-datebox" style="border:1px solid #ccc;height:18px;width:160px;" onkeydown='if(event.keyCode==13) return false;'>
					&nbsp
					状态:<select id="storagestate" name="storagestate" style="width:160px">
								<option value="all">全部</option>
								<option value="">申请</option>
								<option value="">已设置配送费用</option>
								<option value="">确定配送</option>
								<option value="">已发货</option>
								<option value="">已收货</option>
							</select>
					&nbsp
					&nbsp
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