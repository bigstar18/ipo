$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'所有提货单查询',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         singleSelect:true,
         toolbar:"#tb",  
         url:  getRootPath () + "/DeliveryController/findAllDeliveryOrders" ,  
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
             title : '状态' ,
             formatter:function(value){
            	 if(value=='1') return "未审核";
            	 if(value=='2') return "通过";
            	 if(value=='3') return "驳回";
            	 if(value=='4') return "已收货";
            	 if(value=='5') return "废除";
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

function doSearch(){
            $.ajax({ 
                  type: "post",  
                  url: getRootPath () + "/DeliveryController/QueryByConditions",       
                  data: $("#frm").serialize(),      
                  success: function(data) { 
                      $("#dg").datagrid("loadData",data); 
                     }
                  }) ;
}

function clear(){
	$("#deliveryorderId").val("");
	$("#applyDate").val("");
	$("#approvalStatus").val("");
	$("#dealerId").val("");
}
