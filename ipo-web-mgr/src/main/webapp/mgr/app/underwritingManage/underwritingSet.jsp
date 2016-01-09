<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>承销设置</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){
	 $('#dg').datagrid({
		 title:'承销信息',
	      iconCls:'icon-ok',
	       method:"POST",
	       height:400,
	      pageSize:10,
	      pageList:[5,10,15],
	      nowrap:true,
	      striped:true,
	      toolbar:"#tb", 
	      singleSelect:true,
	      striped:true,  
 	      url:'<%=request.getContextPath()%>/UnderwriterSetController/findUnderwriterSet', //搜索前,触发此action请求所有用户信息  
	      fitColumns:true,//允许表格自动缩放,以适应父容器
	      loadMsg:'数据加载中......', 
	      columns:[[{
	     	 field:'ck',
	     	 checkbox:true
	      },{
	          field : 'underwriterid',
	          width : 200,
	          align: "center",
	          title : '承销会员编号',
	      },{
	          field : 'commodityid',
	          width : 200,
	          align: "center",
	          title : '商品代码',
	      }, {
	          field : 'subscribecounts',
	          width : 200,
	          align: "center",
	          title : '认购数量',
	      }, {
	          field : 'proportion',
	          width : 200,
	          align: "center",
	          title : '占承销会员手续费总和的比例（%）',
	      } ]],
	      pagination : true,
	      singleSelect: false,
	      selectOnCheck: true,
	      checkOnSelect: true
	  });		
		 var p = $('#dg').datagrid('getPager');
		    $(p).pagination({
		        beforePageText: '第',
		        afterPageText: '页    共 {pages} 页',
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		    });
});

//删除
function deleteList(){
	var checkedItems = $('#dg').datagrid('getChecked');
	var ids = [];
	$.each(checkedItems,function(index,item){
		ids.push(item.subscribeid);
	});
	var id = ids.join(",");
	if(id.length != 0){
		if(confirm("确定删除所选记录？")){
			  var row = $("#dg").datagrid("getSelected"); 
			  $.post("<%=request.getContextPath()%>/UnderwriterSetController/deleteInfo",{"ids":id},function(data,status){
				  if(data=='true'){
					  alert("删除成功！")
					  $('#dg').datagrid('reload');
				  }
				  if(data=='false'){
					  alert("删除失败")
				  }
					  });
			  }
	}else{
		alert("至少选择一条记录再进行删除！");
	}
}

function doSearch(){
$('#dg').datagrid('load',{
	commodityid: $('#commodityid').val(),
	underwriterid: $('#underwriterid').val()
});       
}

function clearInfo(){
$("#commodityid").val("");
$("#underwriterid").val("");
}
</script>
</head>
<body>
<div id="main_body">
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		<div>
		   <a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="OpenFrame()">添加</a>
		   <a href="#" class="easyui-linkbutton" iconCls="icon-remove" id="view" onclick="deleteList()">删除</a>
			商品代码：<input type="text" id="commodityid" name="commodityid" />
			承销会员编码：<input type="text" id="underwriterid" name="underwriterid"></input> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="clearInfo()">重置</a>					
		</div> 
	</div>
	</div>
</div>
</body>
</html>
