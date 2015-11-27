<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<html>
<head>


<title>交易节管理列表</title>

<meta name="decorator" content="default" />
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
<script src="${ctxStatic}/static/jquery-easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/static/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>


<script type="text/javascript">

	//添加信息跳转
	function addForward(){
		//获取配置权限的 URL
		var addUrl=document.getElementById('add').action;
		//获取完整跳转URL
		var url = "${basePath}"+addUrl;

		if(showDialog(url, "", 800, 550)){
			//如果添加成功，则刷新列表
			ECSideUtil.reload("ec");
		}
		
	}
	//修改信息跳转
	function detailForward(id){
		//获取配置权限的 URL
		var detailUrl = "${basePath}/timebargain/tradeparams/detailTradeTimeforward.action?entity.sectionID=";
		//获取完整跳转URL
		var url = detailUrl + id;
		//弹出修改页面
		if(showDialog(url, "", 800, 550)){
			//如果修改成功，则刷新列表
			ECSideUtil.reload("ec");
		};
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


</script>
</head>
<body>
	<div id="main_body">
	    <div class="warning">
			<div class="content">
				温馨提示 :添加、删除、修改交易节
			</div>
		</div>	
	    <div class="div_gn">
			<rightButton:rightButton name="添加" onclick="addForward();" className="anniu_btn" action="<%=request.getContextPath()%>/TradetimeController/addTradetime" id="add"></rightButton:rightButton>
			&nbsp;&nbsp;
			<rightButton:rightButton name="删除" onclick="deleteList();" className="anniu_btn" action="<%=request.getContextPath()%>/TradetimeController/deleteTradetime" id="delete"></rightButton:rightButton>
		</div>
		<div class="div_list">
			<table id="tb" border="0" class="easyui-datagrid" cellspacing="0" cellpadding="0" width="100%" toolbar="#div_gn"
			data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/TradetimeController/getTradetimeList',method:'get'">>
				<thead>
					<tr>
						<th data-options="field:'sectionid',width:200">编号</th>
						<th data-options="field:'name',width:200">交易节名称</th>
						<th data-options="field:'starttime',width:200">交易节 开始时间</th>
						<th data-options="field:'endtime',width:200">交易节结束时间</th>
						<th data-options="field:'status',width:200">状态</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>
