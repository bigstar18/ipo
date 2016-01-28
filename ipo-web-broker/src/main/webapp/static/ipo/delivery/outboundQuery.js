$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'出库单权限查询',  
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
         url:  getRootPath () + "/DeliveryController/findAllOutBounds" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [ {
        	 field : 'warehouseid',  
             width : 200, 
             align: "center",
             title : '仓库号'
         }, {
        	 field : 'outboundorderid',  
             width : 200,  
             align: "center",
             title : '出库单号'
         },{
        	 field : 'deliveryorderid',  
             width : 200,  
             align: "center",
             title : '提货单号'
         },  {
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
        	 field : 'dealerId',  
             width : 200,  
             align: "center",
             title : '交易商代码'
         }, {
        	 field : 'dealerName',  
             width : 200,  
             align: "center",
             title : '交易商名称'
         } ,{
        	 field : 'deliveryperson',  
             width : 200,  
             align: "center",
             title : '提货人'
         } , {
        	 field : 'sex',  
             width : 200,  
             align: "center",
             title : '性别'
         }, {
        	 field : 'idtype',  
             width : 200,  
             align: "center",
             title : '证件类型'
         },{
        	 field : 'idnum',  
             width : 200,  
             align: "center",
             title : '证件号码'
         }, {
        	 field : 'deliveryQuatity',  
             width : 200,  
             align: "center",
             title : '交割件数（批）'
         },{
        	 field : 'deliveryMethod',  
             width : 200,  
             align: "center",
             title : '提货类型'
         }, {
        	 field : 'outboundstate',  
             width : 200,  
             align: "center",
             title : '出库状态',
             formatter:function(value){
            	 if(value=='1') return "申请";
            	 if(value=='2') return "审核通过";
            	 if(value=='3') return "审核驳回";
           }
         },{
        	 field : 'outbounddate',  
             width : 200,  
             align: "center",
             title : '出库日期',
             formatter: function(value,row){
                  return value.substr(0,10);
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
		      
		      $("#outbounddate").datebox({
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
	$('#dg').datagrid('load',{
		outboundorderid: $('#outboundorderid').val(),
		outbounddate: $('#outbounddate').datebox('getValue'),
		outboundstate: $('#outboundstate').val(),
		deliveryorderid: $('#deliveryorderid').val(),
		deliveryMethod: $('#deliveryMethod').val()
	});
}


function clearInfo(){
	$("#outboundorderid").val("");
	$("#deliveryorderid").val("");
	$("#outbounddate").datebox('setValue',"")
	$("#outboundstate").val("");
	$("#deliveryMethod").val("");
}

