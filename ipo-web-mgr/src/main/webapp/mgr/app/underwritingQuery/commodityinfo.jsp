<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/mgr/app/ipoInclude.jsp"%>
<html>
<head>
<title>商品承销信息</title>
<script type="text/javascript">
$(document).ready(function() {

	getAllInfo();

});
//加载所有信息
function getAllInfo(){
	 $('#tb').datagrid({  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tt",  
         url:'<%=request.getContextPath()%>/UnderwriterQueryController/getcommodityInfo', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {  
             field : 'underwriterid',  
             width : 200,  
             align: "center",
             title : '承销会员编号'  
         },{
        	 field : 'commodityid',
             width : 200,  
             align: "center",
             title : '商品代码'
         },{  
             field : 'commodityidname',  
             width : 200,  
             align: "center",
             title : '商品名称'  
         }, {  
             field : 'subscribeprice',  
             width : 200, 
             align: "center",
             title : '认购价格'
         },{  
             field : 'subscribecounts',  
             width : 200, 
             align: "center",
             title : '认购数量'
         },{  
             field : 'proportion',  
             width : 200, 
             align: "center",
             title : '分成比例(%)'
         }]],  
         pagination : true
     });  
	 var p = $('#tb').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
}
    
function doSearch(){
	$('#tb').datagrid('load',{
		underwriterid:$("#underwriterid").val(),
		commodityid:$("#commodityid").val()
		
	});
}
  
function clearInfo(){
	$("#underwriterid").val("");
	$("#commodityid").val("");
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
				<table id="tb">
				</table>
				<div id="tt" style="padding:5px;height:auto">
					<div>
					<form name="frm" action="" >
					承销会员编号: <input id="underwriterid" name="underwriterid" class="easyui-textbox" style="border:1px solid #ccc" >
					商品代码：<input id="commodityid" class="easyui-textbox" style="border:1px solid #ccc" >
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
