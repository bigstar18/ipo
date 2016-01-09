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
	getAllInfo();
});
 function addForward(){
	 alert("22");
 }
 
 function getAllInfo(){
	 $('#tt').datagrid({
		 title:'承销信息',
	      iconCls:'icon-ok',
	       method:"POST",
	       height:400,
	      pageSize:10,
	      pageList:[5,10,15],
	      nowrap:true,
	      striped:true,
	      singleSelect:true,
	      striped:true,  
		  toolbar:[{text:'商品代码：<input id="test" name="commodityid" style="border:0;width:180px;height:18px"> 	&nbsp承销会员编号: <input id="name" name="frimid" style="border:0;width:180px;height:18px">'},
		           {text:'查询',iconCls:'icon-search',handler:function(){
		        	   alert($('#test').val());
		           }},'-',
		           {text:'重置',iconCls:'icon-reload',handler:function(){
		        	   $('#test').val("");
		           }},'-',
		           {text: '添加', iconCls: 'icon-add',handler:function(){
			 			OpenFrame();
		 			}},'-',
		           {text: '删除', iconCls: 'icon-remove',handler:function(){
		        	   deleteList();
		           }},'-'
		           ],
 	      url:'<%=request.getContextPath()%>/UnderwriterSetController/findUnderwriterSet', //搜索前,触发此action请求所有用户信息  
	      fitColumns:true,//允许表格自动缩放,以适应父容器
	      loadMsg:'数据加载中......', 
	      sortName:'sectionid',
	      sortOrder:'asc',
	      remoteSort:false,
	      columns:[[{
	     	 fiele:'checked',
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

	  });		
		 var p = $('#tt').datagrid('getPager');
		    $(p).pagination({
		        beforePageText: '第',
		        afterPageText: '页    共 {pages} 页',
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		    });
 }


//修改信息跳转
function updatePoundForward(poundageId){
	var Url = "<%=request.getContextPath()%>/SpacialSetController/updatePoundForward?poundageId="+poundageId+"&&randnum="+Math.floor(Math.random()*1000000) ;
	document.location.href = Url;
}

//添加信息跳转
function addForward(){
	//获取配置权限的 URL
	document.location.href = "<%=request.getContextPath()%>/LoanDepositController/addSubCommonityForward?randnum="+Math.floor(Math.random()*1000000);
}

//删除
function deleteList(){
	var checkedItems = $('#tt').datagrid('getChecked');
	var ids = [];
	$.each(checkedItems,function(index,item){
		ids.push(item.poundageId);
	});
	var id = ids.join(",");
	if(id.length != 0){
		if(confirm("确定删除所选手续费？")){
			  var row = $("#tt").datagrid("getSelected"); 
			  $.post("<%=request.getContextPath()%>/SpacialSetController/deleteById",{"ids":id},function(data,status){
				  if(data=='true'){
					  alert("删除成功！")
					  $('#tt').datagrid('reload');
				  }
				  if(data=='error'){
					  alert("删除失败")
				  }
					  });
			  }
	}else{
		alert("请选择要删除的手续费");
	}
}


function OpenFrame() {
	$('#dd').empty();
    $('#dd').append("<iframe style='width:100%;height:100%' src='../underwritingManage/addSubCommonity.jsp'></iframe>");
    $('#dd').window('open');
}
</script>
</head>
<body>
<div id="dd" title="承销商认购设置"  class="easyui-window"  closed="true" style="width:800px;height:600px;padding:5px;">
</div>
<div id="main_body">
	<table class="table1_style" style="width:100%;border:0;">
	<tr>
		<td>		
			<div class="div_list">
				<table id="tt">
				</table>
			</div>
		</td>
	</tr>
</table>

	
	
		
</div>
</body>
</html>
