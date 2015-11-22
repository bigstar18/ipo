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
	 var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
});
    
function doSearch(){
	$('#dg').datagrid({    
	    url:'<%=request.getContextPath()%>/BreedController/findBreedByName',    
	    columns:[[    
	        {field:'breedid',title:'品种ID',width:100},    
	        {field:'breedname',title:'品种名称',width:100},    
	        {field:'breedid',title:'对应商品',width:100,}    
	    ]]    
	});  
}
    
    
	function rowformater(value,row){
    return "<a href=\"#\" class=\"blank_a\" onclick=\"return detailForward("+value+");\"><font color=\"#880000\">"+value+"</font></a>";
    }  
	
	function rowformatertoimg(value,row){
		   var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
	    return "<a href=\"#\" onclick=\"updateForward("+value+")\"><img src="+imgurl+"/></a>";
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
	<table id="dg" class="easyui-datagrid" title="品种列表" style="width:100%;height:350px"
			data-options="toolbar:'#tb',pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/BreedController/findIpoABreeds',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'breedid',width:200,formatter:rowformater">品种ID</th>
				<th data-options="field:'breedname',width:200">品种名称</th>
				<th data-options="field:'breedid',width:200,formatter:rowformatertoimg">对应商品</th>
			</tr>
		</thead>
	</table>
		<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addForward();" action="" id="add">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteList();" action="/BreedController/deleteBreed?autoInc=false" id="delete">删除</a>
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
