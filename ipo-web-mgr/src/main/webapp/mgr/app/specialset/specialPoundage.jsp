<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<html>
<head>


<title>特殊手续费设置</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){
	issuePoundage();
});
 function addForward(){
	 alert("22");
 }
 
 function issuePoundage(){
	 $("#issue").css("color","red");
	 $("#regOrCan").css("color","#2828ff");
	 $('#tt').datagrid({
	      iconCls:'icon-ok',
	       method:"get",
	       height:400,
	      pageSize:10,
	      pageList:[5,10,15],
	      nowrap:true,
	      striped:true,
	      singleSelect:true,
	      collapsible:false,
		  toolbar:"#tb",
	      url:'<%=request.getContextPath()%>/SpacialSetController/getAllInfo', //搜索前,触发此action请求所有用户信息 
	      fitColumns:true,//允许表格自动缩放,以适应父容器
	      loadMsg:'数据加载中......', 
	      sortName:'sectionid',
	      sortOrder:'asc',
	      remoteSort:false,
	      columns : [ [ {
	     	 fiele : 'checked',
	     	 checkbox:true
	      },{
	          field : 'poundageId',
	          width : 200,
	          align: "center",
	          title : '手续费id',
	      },{
	          field : 'dealerId',
	          width : 200,
	          align: "center",
	          title : '交易商代码',
	      }, {
	          field : 'commodityId',
	          width : 200,
	          align: "center",
	          title : '商品代码',
	      }, {
	          field : 'poundageAlgr',
	          width : 200,
	          align: "center",
	          title : '手续费算法' ,
	        	 formatter:function(value){
	            	 if(value=='1') return "按百分比";
	            }
	      } ,{
	          field : 'poundageRatio',
	          width : 200,
	          align: "center",
	          title : '手续费标准' 
	      },{
	     	 field : 'changeInfo',  
	          width : 200,  
	          align: "center",
	          title : '修改' ,
	          formatter:function(value,row){
	         	 var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
	      	   return "<a href=\"#\" onclick=\"updatePoundForward("+row.poundageId+")\"><img src="+imgurl+"></a>";
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
 }
 function regOrCanPoundage(){
	 $("#issue").css("color","#2828ff");
	 $("#regOrCan").css("color","red");
	 $('#tt').datagrid({
	      iconCls:'icon-ok',
	       method:"get",
	       height:400,
	      pageSize:10,
	      pageList:[5,10,15],
	      nowrap:true,
	      striped:true,
	      singleSelect:true,
	      collapsible:false,
	      toolbar:"#tb",
	      url:'<%=request.getContextPath()%>/SpacialSetController/getAllInfo', //搜索前,触发此action请求所有用户信息 
	      fitColumns:true,//允许表格自动缩放,以适应父容器
	      loadMsg:'数据加载中......', 
	      sortName:'sectionid',
	      sortOrder:'asc',
	      remoteSort:false,
	      columns : [ [ {
	     	 fiele : 'checked',
	     	 checkbox:true
	      },{
	          field : 'poundageId',
	          width : 200,
	          align: "center",
	          title : '手续费id',
	      },{
	          field : 'dealerId',
	          width : 200,
	          align: "center",
	          title : '交易商代码',
	      }, {
	          field : 'commodityId',
	          width : 200,
	          align: "center",
	          title : '商品代码',
	      }, {
	          field : 'poundageAlgr',
	          width : 200,
	          align: "center",
	          title : '手续费算法' ,
	        	 formatter:function(value){
	            	 if(value=='1') return "按百分比";
	            }
	      } ,{
	          field : 'poundageRatio',
	          width : 200,
	          align: "center",
	          title : '手续费标准' 
	      },{
	     	 field : 'changeInfo',  
	          width : 200,  
	          align: "center",
	          title : '修改' ,
	          formatter:function(value,row){
	         	 var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
	      	   return "<a href=\"#\" onclick=\"updatePoundForward("+row.poundageId+")\"><img src="+imgurl+"></a>";
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
 }

//修改信息跳转
function updatePoundForward(poundageId){
	var Url = "<%=request.getContextPath()%>/SpacialSetController/updatePoundForward?poundageId="+poundageId+"&&randnum="+Math.floor(Math.random()*1000000) ;
	document.location.href = Url;
}

//添加信息跳转
function addForward(){
	//获取配置权限的 URL
	document.location.href = "<%=request.getContextPath()%>/SpacialSetController/addPoundageForward?randnum="+Math.floor(Math.random()*1000000);
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
</script>
</head>
<body>
<div id="main_body">

	<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
	<div style="width:100%;height:15px;padding-top:5px;">
		<table width="100%" >
			<tr>
			<td align="center"> 
				<a  id="issue" style="cursor:pointer;color:#2828ff;font-size:15px" onclick="issuePoundage()">发行</a>
			</td>
			<td align="center">
				<a id="regOrCan" style="cursor:pointer;color:#2828ff;font-size:15px" onclick="regOrCanPoundage()">注册/注销</a>
			</td>
		</tr>
	</table>
	</div>

	<tr>
		<td>		
		<br />
			<div class="div_list">
				<table id="tt">
				</table>
				<div id="tb" style="padding:5px;height:auto">
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="addForward()">添加</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove" id="view" onclick="deleteList()">删除</a>					
				</div>
				
			</div>
		</td>
	</tr>
</table>

	
	
		
</div>
</body>
</html>
