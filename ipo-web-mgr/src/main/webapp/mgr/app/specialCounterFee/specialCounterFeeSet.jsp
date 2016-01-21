<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>特殊手续费设置</title>
</head>
<body>

<input id="id" type="hidden">
<div id="dd" title="特殊手续费添加"  class="easyui-window"  closed="true" style="width:800%;height:600%;padding:5px;">
</div>
	
	<div id="tb">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="openFrame()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" id="view" onclick="deleteInfo()">删除</a>
	</div>
	<table id="tt">
	</table>
</body>



<script type="text/javascript">
	$(document).ready(function(){
		getAllInfo();
	});
	
 	function getAllInfo(){
 		$('#tt').datagrid({
 			title:'特殊手续费信息',
 			method:'get',
 			pageSize:10,
 			pageList:[5,10,15],
 			nowrap:true,
 	        singleSelect:true,
 	        striped:true,
 	        height:400,
 	        fitColumns:true,
 	        toolbar:"#tb",
 	        url:"<%=request.getContextPath()%>/SpecialCounterFeeController/getSpecialCounterfeeInfo?randnum="+Math.floor(Math.random()*1000000), //搜索前,触发此action请求所有用户信息 --%>
 	         loadMsg:'数据加载中......',
 	         fitColumns:true,//允许表格自动缩放,以适应父容器
 	         columns : [ [ {  
 	        	 fiele:'checked',
 		     	 checkbox:true  
 	        },{
 	        	 field : 'id',
 	             width : 200,
 	             align: "center",
 	             title : '序号',
 	             formatter:function(value,row){
 	            	 return "<a href='#' onclick='updateInfo(\""+value+"\")'>"+value+"</a>";
 	             }
 	         },{
 	        	 field : 'firmid',
 	             width : 200,
 	             align: "center",
 	             title : '交易商代码'
 	         },{
 	        	 field : 'commodityid',
 	             width : 200,
 	             align: "center",
 	             title : '商品代码'
 	         },{
 	        	 field : 'counterfeetype',
 	             width : 200,
 	             align: "center",
 	             title : '手续费类型',
 	             formatter:function(value,row){
 	            	 switch(value){
 	            	 case 1:
 	            		 return "交易手续费";
 	            		 break;
 	            	 }
 	             }
 	         },{
 	        	 field : 'tradealgr',
 	             width : 200,
 	             align: "center",
 	             title : '交易手续费算法',
 	             formatter:function(value,row){
 	            	 switch(value){
 	            	 case 1:
 	            		 return "百分比";
 	            		 break;
 	            	 case 2:
 	            		 return "绝对值";
 	            		 break;
 	            	 }
 	             }
 	         },{
 	        	 field : 'updatedate',
 	             width : 200,
 	             align: "center",
 	             title : '修改时间'
 	         }]],
 	        pagination : true,
 	        rownumbers : false,
 	        selectOnCheck: false,
 	        checkOnSelect: false		
 		});
 		 var p = $('#tt').datagrid('getPager');
 	    $(p).pagination({
 	        beforePageText: '第',
 	        afterPageText: '页    共 {pages} 页',
 	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
 	    });
 	}
	function deleteInfo(){
		var rows = $('#tt').datagrid('getChecked');
		var ids = new Array();
		if(rows.length==0){
        	alert("至少请勾选一条信息");
        	return;
        }
		for(var temp in rows){
			ids.push(rows[temp].id);
		}
		$.ajax({
			traditional: true,
			type:"POST",
			url:"<%=request.getContextPath()%>/SpecialCounterFeeController/deleteInfoById",
			contentType:"application/json", 
         	data:JSON.stringify(ids),
			success:function(data){
				if(data=="fail"){
					alert("删除失败！");
				}else if(data=="error"){
					alert("系统异常！");
				}else if(data=="success"){
					alert("删除成功！");
					getAllInfo();
				}
			}
		});
	}
	
	function updateInfo(id){
		$('#dd').empty();
 		$("#id").val("");
 		$("#id").val(id);
 	    $('#dd').append("<iframe style='width:100%;height:100%' src='../specialCounterFee/addSpecialCounterFee.jsp'></iframe>");
 	    $('#dd').window('open');
	}
	
 	function openFrame() {
 		$('#dd').empty();
 		$("#id").val("");
 	    $('#dd').append("<iframe style='width:100%;height:100%' src='../specialCounterFee/addSpecialCounterFee.jsp'></iframe>");
 	    $('#dd').window('open');
 	}
 	
</script>
</html>