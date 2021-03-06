<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>配送费用设置</title>
<script type="text/javascript">
$(document).ready(function() {
	 $('#dg').datagrid({  
        title:'配送提货单',  
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
        url:  getRootPath () + "/DeliveryController/QueryByConditions?randnum=" +Math.floor(Math.random()*1000000),  
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器   
        columns : [ [ {
       	 field : 'deliveryorderId',  
            width : 200, 
            align: "center",
            title : '提货单号'
        }, {
       	 field : 'commodityId',  
            width : 200,  
            align: "center",
            title : '商品代码'
        },  {
       	 field : 'commodityName',  
            width : 200,  
            align: "center",
            title : '商品名称'
        }, {
       	 field : 'dealerId',  
            width : 200,  
            align: "center",
            title : '交易商代码'
        }, {
       	 field : 'dealerName',  
            width : 200,  
            align: "center",
            title : '交易商名称'
        }, {
       	 field : 'warehouseId',  
            width : 200,  
            align: "center",
            title : '仓库代码'
        }, {
       	 field : 'warehouseName',  
            width : 200,  
            align: "center",
            title : '仓库名称'
        },{
       	 field : 'deliveryQuatity',  
            width : 200,  
            align: "center",
            title : '交割数量'
        },{
       	 field : 'unit',  
            width : 200,  
            align: "center",
            title : '单位'
        },{
          	 field : 'deliveryMethod',  
             width : 200,  
             align: "center",
             title : '提货方式'
         },{
       	 field : 'deliveryDate',  
            width : 200,  
            align: "center",
            title : '提货日期',
            formatter: function(value,row){
                 return value.substr(0,10);
         } 
        },{
       	 field : 'applyDate',  
            width : 200,  
            align: "center",
            title : '申请日期',
            formatter: function(value,row){
                 return value.substr(0,10);
         } 
        },{  
            field : 'approvalStatus',  
            width : 200,  
            align: "center",
            title : '操作' ,
            formatter:function(value,row){
        	    return "<input type=\"button\" onclick=\"approve('"+row.deliveryorderId+"')\" value=\"设置费用\"/>";
        }
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
		      
		      $("#applyDate").datebox({
		    	        editable: false,
		                formatter: function (date) {
		                    var y = date.getFullYear();
		                    var m = date.getMonth() + 1;
		                    var d = date.getDate();
		                    return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		                }
		            });
});

function approve(id){
	document.location.href =  getRootPath () + "/DeliveryController/setExpressFee?deliveryorderId="+id+"&&randnum="+Math.floor(Math.random()*1000000) ;
}



function doSearch(){
  $('#dg').datagrid('load',{
		deliveryorderId: $('#deliveryorderId').val(),
		applyDate: $('#applyDate').datebox('getValue'),
		dealerId: $('#dealerId').val()
	});       
}

function clearInfo(){
	$("#deliveryorderId").val("");
	$("#applyDate").datebox('setValue',"")
	$("#dealerId").val("");
}


</script>

</head>
<body>
<div id="main_body">
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		<div>
			提货单号：<input type="text" id="deliveryorderId" name="deliveryorderId" />
			申请日期：<input type="text" id="applyDate" name="applyDate"></input> 
			交易商代码：<input type="text" id="dealerId" name="dealerId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload"  onclick="clearInfo()">重置</a><br/>		
		</div> 
	</div>
	</div>
</div>
</body>

</html>
