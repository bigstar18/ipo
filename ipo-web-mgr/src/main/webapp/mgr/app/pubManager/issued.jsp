<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>发行摇号</title>


<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>


<script type="text/javascript">

$(document).ready(function() {

	 $('#tt').datagrid({  
         title:'发行摇号',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/QueryController/findRockNums', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {  
             field : 'commodityid',  
             width : 200,  
             title : '商品代码'  
         }, {  
             field : 'starttime',  
             width : 200,  
             title : '发行开始日期'  
         }, {  
             field : 'endtime',  
             width : 200,  
             title : '发行截至日期'
         },{
			field : 'counts',
			width : 200,
			title : '网上发行量'
		 },{
			field : 'ccounts',
			width : 200,
			title :  '申购数量'
		 },{
			field : 'operating',
			width : 200,
			title : '开始摇号',
			formatter:function(value,row){
				if(row.status == 0){
					return '申购成功';
				}else if(row.status == 1){
					return '配号成功';
				}else if(row.status == 2){
					return '摇号成功';
				}else if(row.status == 3){
					return '结算成功';
				}
			}
		 }]],  
         pagination : true
     });  
	
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
});



//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
}

<%-- function constructionManager(commodityid){
	$.ajax({
		type: 'get',  
	    url: "<%=request.getContextPath()%>/QueryController/rock",  
	    contentType: "application/json; charset=utf-8", 
	    data:{"commodityid":commodityid},
	    dataType: 'json',  
	    async: true,  
	    success : function(data, stats) { 
	    	if(data == "1"){
            alert('摇号结束');
	    	}
        }
	});
} --%>
    
function doSearch(){
	var commodityid=$("#commodityid").val();
	 $('#tt').datagrid({  
         title:'发行摇号',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/QueryController/commodityInfo?commodityid='+commodityid, //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器
         columns : [ [ {  
             field : 'commodityid',  
             width : 200,  
             title : '商品代码'  
         }, {  
             field : 'starttime',  
             width : 200,  
             title : '发行开始日期'  
         }, {  
             field : 'endtime',  
             width : 200,  
             title : '发行截至日期'
         },{
			field : 'counts',
			width : 200,
			title : '网上发行量'
		 },{
			field : 'ccounts',
			width : 200,
			title :  '申购数量'
		 },{
			field : 'operating',
			width : 200,
			title : '开始摇号',
			formatter:function(value,row){
				if(row.status == 0){
					return '申购成功';
				}else if(row.status == 1){
					return '配号成功';
				}else if(row.status == 2){
					return '摇号成功';
				}else if(row.status == 3){
					return '结算成功';
				}
			}
		 }]],  
         pagination : true
     });  
	
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
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
	<table id="tt"></table>
		<div id="tb" style="padding:5px;height:auto">
		
		<div>
		<form name="frm" action="<%=request.getContextPath()%>/QueryController/commodityInfo" method="post">
		商品代码: <input id="commodityid" name="userid" class="easyui-textbox" style="border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>					
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
