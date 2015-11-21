<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>品种管理列表</title>

<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css"> 
<link href="${skinPath}/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css" />
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script src="breed_list.js" type="text/javascript"></script>


<script type="text/javascript">

//添加信息跳转
function addForward(){
	//获取配置权限的 URL
	var addUrl=document.getElementById('add').action;
	//获取完整跳转URL
	var url = "${basePath}"+addUrl;

	document.location.href = url;
	
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
	<table id="dg" class="easyui-datagrid" title="CheckBox Selection on DataGrid" style="width:100%;height:250px"
			data-options="toolbar:'#tb',pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/BreedController/findIpoABreeds',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'breedID',width:200,formatter: rowformater">品种ID</th>
				<th data-options="field:'breedName',width:200">品种名称</th>
				<th data-options="field:'breedID',width:200,formatter: rowformatertoimg">对应商品</th>
			</tr>
		</thead>
	</table>
		<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addForward();" action="/IpoController/addBreedforward" id="add">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteList();" action="/BreedController/deleteBreed?autoInc=false" id="delete">删除</a>
		</div>
		<div>
		<form name="frm" action="<%=request.getContextPath()%>/CommodityController/findComms?sortColumns=order+by+breedID+asc" method="post">
			品种名称: <input class="easyui-textbox" style="width:80px">
<%-- 			<input id="tariffID" name="${GNNT_}primary.breedName[allLike]" type="text" value="${oldParams['primary.breedName[allLike]'] }" class="input_text"/>	 --%>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick=dolistquery();>查询</a>					
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
