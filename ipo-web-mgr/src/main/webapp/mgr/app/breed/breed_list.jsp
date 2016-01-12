<%@ page contentType="text/html;charset=UTF-8"%>
 <%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>品种管理列表</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">
 
$(document).ready(function() {
	 $('#tt').datagrid({  
         title:'品种列表',  
         iconCls:'icon-ok', 
         method:"post",
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
	document.location.href = "<%=request.getContextPath()%>/IpoController/addBreedforward?randnum="+Math.floor(Math.random()*1000000);
}

//删除品种
function deleteBreed(){
	 var row = $("#tt").datagrid("getSelected"); 
	  if(row){
	if(confirm("确定删除该品种吗？")){
		  $.post("<%=request.getContextPath()%>/BreedController/deleteBreed",{"breedid":row.breedid},function(data,status){
			  if(data=='true'){
				  alert("删除成功！")
				  $('#tt').datagrid('reload');
			  }
			  if(data=='false'){
				  alert("该品种下有对应商品，不可删除！");
			  }
			  if(data=='error'){
				  alert("发生异常，删除失败！");
			  }
				  });}
	}
		  else{
			  alert("请先选中一行再进行删除！");
		  }
 }

//修改品种配置信息，跳转到修改页面
function updateBreed(breedid){
	var Url = "<%=request.getContextPath()%>/IpoController/updateBreedforward?breedID="+breedid+"&&randnum="+Math.floor(Math.random()*1000000) ;
	document.location.href = Url;
}

//查询对应商品列表
function getCommBelonged(breedid) {
	var Url = "<%=request.getContextPath()%>/IpoController/CommodityList?breedID="+breedid+"&&randnum="+Math.floor(Math.random()*1000000);//get方式提交
	document.location.href = Url;
}


function clearInfo(){
	$("#breedname").val("");
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
		<form name="frm" action="<%=request.getContextPath()%>/BreedController/findBreedByName" method="post"  onsubmit="return false;">
			品种名称: <input id="breedname" name="breedname" class="easyui-textbox" style="width:150px">
			<input type="hidden">
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
