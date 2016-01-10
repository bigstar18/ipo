<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<html>
	<head>
	    <base target="_self" />
		<title>认购资金处理</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
	</head>
	
	<body>
		<div id="tb">
			 <input id="brokerageId" value="" style="width:160px;height:20px;padding:0">
			 <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查询</a>
			 <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reSet()">重置</a>	
		</div>
		<table id="tt"></table>
	</body>
	
	<script type="text/javascript">
	$(document).ready(function() {
		getAllInfo();
	});
	//加载所有信息
	function getAllInfo(){
		 $('#tt').datagrid({  
	         title:'认购资金信息',  
	         iconCls:'icon-ok', 
	         method:"get",
	         height:400,
	         pageSize:10,  
	         pageList:[5,10,15],
	         nowrap:true,  
	         singleSelect:true,
	         striped:true, 
	         fitColumns:true,
	         toolbar:"#tb",
	         queryParams:{underwriterid:$("#brokerageId").val()},
	         url:"<%=request.getContextPath()%>/SubFundsController/insertSPOInfo?randnum="+Math.floor(Math.random()*1000000), //搜索前,触发此action请求所有用户信息  
	         loadMsg:'数据加载中......',  
	         fitColumns:true,//允许表格自动缩放,以适应父容器  
	         columns : [ [ {
	        	 field : 'underwriterid',
	             width : 200,
	             align: "center",
	             title : '承销会员编号'
	         },{  
	             field : 'amount',  
	             width : 200, 
	             align: "center",
	             title : '预付货款'
	         },{  
	             field : 'commodityid',  
	             width : 200, 
	             align: "center",
	             title : '认购商品'
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
	function doSearch(){
		$('#tt').datagrid('load',{
			underwriterid:$("#brokerageId").val()
		}); 
	}
	function reSet(){
		$("#brokerageId").val("");
		doSearch();
	}

	</script>
</html>
