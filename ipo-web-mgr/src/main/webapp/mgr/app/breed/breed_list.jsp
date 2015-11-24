<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>品种管理列表</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
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
         collapsible:false,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/BreedController/findIpoABreeds', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         remoteSort:false,  
         columns : [ [ {  
             field : 'breedid',  
             width : 200,  
             align: "center",
             title : '品种ID' ,
             formatter:function(value,row){
         	    return "<a href=\"#\" onclick=\"updateBreed("+value+")\">"+value+"</a>";
         }
         }, {  
             field : 'breedname',  
             width : 200, 
             align: "center",
             title : '品种名称'  
         }, {  
             field : 'sortid',  
             width : 200,  
             align: "center",
             title : '对应商品' ,
             formatter:function(value,row){
            	 var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
         	    return "<a href=\"#\" onclick=\"getCommBelonged("+row.breedid+")\"><img src="+imgurl+"></a>";
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
	var breedname= $("#breedname").val(); 
	 $('#tt').datagrid({  
         title:'品种列表',  
         iconCls:'icon-ok', 
         method:'post',
         height:400,
         singleSelect:true,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         striped:true,  
         collapsible:false,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/BreedController/findBreedByName?breedname='+ encodeURI(encodeURI(breedname)) , //搜索  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         remoteSort:false,  
         columns : [ [ {  
             field : 'breedid',  
             width : 200,  
             align: "center",
             title : '品种ID' ,
             formatter:function(value,row){
          	    return "<a href=\"#\" onclick=\"updateBreed("+value+")\">"+value+"</a>";
          }
         }, {  
             field : 'breedname',  
             width : 200,  
             align: "center",
             title : '品种名称'  
         }, {  
             field : 'sortid',  
             width : 200,  
             align: "center",
             title : '对应商品',  
             formatter:function(value,row){
            	 var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
          	    return "<a href=\"#\" onclick=\"getCommBelonged("+row.breedid+")\"><img src="+imgurl+"></a>";
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
    
//跳转到添加品种页面
function addForward(){
	document.location.href = "<%=request.getContextPath()%>/IpoController/addBreedforward";
}

//批量删除信息
function deleteList(){
	var deleteUrl = document.getElementById('delete').action;
	var url = "${basePath}"+deleteUrl;
	updateRMIEcside(ec.ids,url);
}

//修改品种配置信息，跳转到修改页面
function updateBreed(breedid){
	var Url = "<%=request.getContextPath()%>/IpoController/updateBreedforward?breedID="+breedid;
	document.location.href = Url;
}

//查询对应商品列表
function getCommBelonged(breedid) {
	var Url = "<%=request.getContextPath()%>/BreedController/findComsByBreedid?breedID="+breedid;//get方式提交
	document.location.href = Url;
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
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addForward();" id="add">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBreed();" id="delete">删除</a>
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
