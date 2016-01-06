<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>入库申请</title>
<script type="text/javascript">
$(document).ready(function() {
	 $('#dg').datagrid({  
        title:'库存查询',  
        iconCls:'icon-ok', 
        method:"post",
        height:400,
        pageSize:10,  
        pageList:[5,10,15],  
        singleSelect:true,
        toolbar:"#tb", 
        nowrap:true,  
        striped:true,  
        collapsible:false,  
        url:  getRootPath () + "/DeliveryController/findStocks?randnum=" +Math.floor(Math.random()*1000000),  
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器   
        columns : [ [  {
       	 field : 'stockid',  
            width : 300,  
            align: "center",
            title : '序号'
        },  {
          	 field : 'warehouseid',  
             width : 300,  
             align: "center",
             title : '仓库号'
         }, {
          	 field : 'warehousename',  
             width : 300,  
             align: "center",
             title : '仓库名称'
         }, {
       	 field : 'commodityid',  
            width : 200,  
            align: "center",
            title : '商品代码'
        }, {
       	 field : 'commodityname',  
            width : 200,  
            align: "center",
            title : '商品名称'
        } ,{
       	 field : 'pubmemberid',  
            width : 200,  
            align: "center",
            title : '发行会员代码'
        }, {
       	 field : 'pubmembername',  
            width : 200,  
            align: "center",
            title : '发行会员名称'
        } ,{
       	 field : 'storagenum',  
            width : 200,  
            align: "center",
            title : '入库数量'
        } ,{
       	 field : 'forzennum',  
            width : 200,  
            align: "center",
            title : '冻结数量'
        }, {
       	 field : 'availablenum',  
            width : 200,  
            align: "center",
            title : '有效数量'
        },{
       	 field : 'outboundnum',  
            width : 200,  
            align: "center",
            title : '出库数量'
        }
        ]],  
        pagination : true 
    });  
	 var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    }); 
 });


	
function doSearch(){
	$('#dg').datagrid('load',{
		commodityid: $('#commodityid').val(),
		warehouseid:$('#warehouseid').val()
	});
}


function clearInfo(){
	$("#commodityid").val("");
	$("#warehouseid").val("");
}

</script>
</head>
<body>
<div id="main_body">
			
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		 <div>
			商品代码：<input type="text" id="commodityid" name="commodityid" />
			仓库号：<input type="text" id="warehouseid" name="warehouseid" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload"  onclick="clearInfo()">重置</a><br/>
		</div>  
	</div>
	</div>
	
</div>
</body>

</html>
