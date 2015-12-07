<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<html>
<head>


<title>交易节管理列表</title>

<meta name="decorator" content="default" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">

 
$(document).ready(function() {
	
	 $('#tt').datagrid({
         iconCls:'icon-ok',
         method:"post",
         height:400,
         pageSize:10,
         pageList:[5,10,15],
         nowrap:true,
         striped:true,
         singleSelect:true,
         collapsible:false,
         url:'<%=request.getContextPath()%>/TradetimeController/getTradetimeList?rand='+Math.random(), //搜索前,触发此action请求所有用户信息  
         fitColumns:true,//允许表格自动缩放,以适应父容器
         sortName:'sectionid',
         sortOrder:'asc',
         remoteSort:false,
         columns : [ [ {
        	 fiele : 'checked',
        	 checkbox:true
         },{
             field : 'sectionid',
             width : 200,
             title : '交易节编号',
			 formatter:function(value,row,index){
         	    return "<a href=\"#\" onclick=\"updateForward("+index+")\">"+value+"</a>";
			}
         }, {
             field : 'name',
             width : 200,
             title : '交易节名称',
			 formatter:function(value,row,index){
         	    return "<a href=\"#\" onclick=\"updateForward("+index+")\">"+value+"</a>";
			}
         }, {
             field : 'starttime',
             width : 200,
             title : '交易节开始时间' 
         },{
			field : 'endtime',
			width :	200,
			title : '交易节结束时间'
		 },{
			field : 'status',
			width : 200,
			title : '交易状态',
			formatter:function(value,row){
				if(row.status == 0){
					return '无效';
				}else if(row.status == 1){
					return '正常';
				}
			}
		 }]],
         pagination : true,
         rownumbers : false,
         selectOnCheck: false,
         checkOnSelect: false
         
     });
	 $('tt').datagrid('fitColumns');
	 var p = $('#tt').datagrid('getPager');
	    $(p).pagination({
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页',
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
});


//添加信息跳转
function addForward(){
	//获取配置权限的 URL
	var addUrl="<%=request.getContextPath()%>/TradetimeController/addTradetimeforward";
	 if(showDialog(addUrl, "", 800, 550)){
		//如果添加成功，则刷新列表
		$('#tt').datagrid('reload');
	} 
}
//修改信息跳转
function updateForward(index) {
	$('#tt').datagrid('selectRow',index);
	var row = $("#tt").datagrid("getSelected");
		   var updateUrl = "<%=request.getContextPath()%>/TradetimeController/updateTradetimeforward";
			//给 URL 添加参数
			if(showDialog(updateUrl, row, 800, 550)){
				//如果添加成功，则刷新列表
				$('#tt').datagrid('reload');
			}
}

//删除
function deleteList(){
	var checkedItems = $('#tt').datagrid('getChecked');
	var ids = [];
	$.each(checkedItems,function(index,item){
		ids.push(item.sectionid);
	});
	var id = ids.join(",");
	if(id.length != 0){
		if(confirm("确定删除该交易节吗？")){
			  var row = $("#tt").datagrid("getSelected"); 
			  $.post("<%=request.getContextPath()%>/TradetimeController/deleteTradetime",{"ids":id},function(data,status){
				  if(data=='success'){
					  alert("删除成功！")
					  $('#tt').datagrid('reload');
				  }
				  if(data=='error'){
					  alert("该交易节与商品有关联，不可删除")
				  }
					  });
			  }
	}else{
		alert("请选择要删除的交易节");
	}
}
</script>
</head>
<body>
<div id="main_body">
	<div class="warning">
			<div class="content">
				温馨提示 :添加、删除、修改交易节<br/>
			</div>
		</div>
	<div id="tb" >
			<input type="button" onclick="addForward();" value="添加" style="width:45px;height:25px;">
			&nbsp;&nbsp;
			<input id="delete" name="delete" type="button" onclick="deleteList();" value="删除" style="width:45px;height:25px;">
		
	</div>
	<table id="tt" width="100%"></table>
		
</div>
</body>
</html>
