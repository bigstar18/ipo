<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>品种管理列表</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">
 
$(document).ready(function() {
	
	 $('#tt').datagrid({  
         title:'品种列表',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         collapsible:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/BreedController/findIpoABreeds', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         sortName:'breedid',  
         sortOrder:'asc',  
         remoteSort:false,  
         columns : [ [ {  
             field : 'breedid',  
             width : 200,  
             title : '品种id'  
         }, {  
             field : 'breedname',  
             width : 200,  
             title : '品种名称'  
         }, {  
             field : 'breedid',  
             width : 200,  
             title : '对应商品' ,
             formatter:function(value,row){
            	 var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
         	    return "<a href=\"#\" onclick=\"updateForward("+value+")\"><img src="+imgurl+"/></a>";
         } }]],  
         pagination : true,  
         rownumbers : false  
     });  
	
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
});
    
function doSearch(){
	var breedname=$("#breedname").val();
	 $('#tt').datagrid({  
         title:'品种列表',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         singleSelect:true,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         striped:true,  
         collapsible:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/BreedController/findBreedByName?breedname='+breedname, //搜索  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         sortName:'breedid',  
         sortOrder:'asc',  
         remoteSort:false,  
         columns : [ [ {  
             field : 'breedid',  
             width : 200,  
             title : '品种id'  
         }, {  
             field : 'breedname',  
             width : 200,  
             title : '品种名称'  
         }, {  
             field : 'breedid',  
             width : 200,  
             title : '对应商品',  
             formatter:function(value,row){
              // var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
               return "<a href='"+value+"' >开始摇号</a>";
              // return "<a href=\"#\" onclick=\"updateForward("+value+")\"><img src="+imgurl+"/></a>";
             } }]],
         pagination : true,  
         rownumbers : false  
     });  
	 var p2 = $('#tt').datagrid('getPager'); 
	    $(p2).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
	 
}
    

//添加信息跳转
function addForward(){
	//获取配置权限的 URL
	var addUrl=document.getElementById('add').action;
	//获取完整跳转URL
	var url = "${basePath}"+addUrl;

	document.location.href = "<%=request.getContextPath()%>/IpoController/addBreedforward";
	
}
function addSortForward(){
	//获取配置权限的 URL
	var addUrl=document.getElementById('addBC').action;
	//获取完整跳转URL
	var url = "${basePath}"+addUrl;

	if(window.open(url, "", "width=450,height=400")){
		//如果修改成功，则刷新列表
		ECSideUtil.reload("ec");
	};
	
}
//修改信息跳转
function detailForward(id){
	//获取配置权限的 URL
	var detailUrl = "${basePath}/timebargain/tradeparams/detailBreed.action?breedID=";
	//获取完整跳转URL
	var url = detailUrl + id;

	document.location.href = url;
	
}
//批量删除信息
function deleteList(){
	//获取配置权限的 URL
	var deleteUrl = document.getElementById('delete').action;
	//获取完整跳转URL
	var url = "${basePath}"+deleteUrl;
	//执行删除操作
	updateRMIEcside(ec.ids,url);
}

function updateForward(id) {
	//获取配置权限的 URL
	var updateUrl = "/timebargain/tradeparams/detailToCommodity.action";
	//获取完整跳转URL
	var url = "${basePath}"+updateUrl;
	//给 URL 添加参数
	url += "?breedID="+id+"&sortColumns=order+by+commodityID+asc";

	document.location.href = url;
}

function dolistquery() {
	frm.submit();
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
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addForward();" action="" id="add">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBreed();" action="/BreedController/deleteBreed?autoInc=false" id="delete">删除</a>
		</div>
		<div>
		<form name="frm" action="<%=request.getContextPath()%>/BreedController/findBreedByName" method="post">
			品种名称: <input id="breedname" name="breedname" class="easyui-textbox" style="width:80px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>					
		</form> 
		</div>
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
		<!-- 编辑和过滤所使用的 通用的文本框模板 -->
		<textarea id="ecs_t_input" rows="" cols="" style="display: none">
			<input type="text" class="inputtext" value="" onblur="ECSideUtil.updateEditCell(this)" style="width: 100%;" name="" />
		</textarea>
</body>

</html>
