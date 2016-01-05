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
         url:  getRootPath () + "/DeliveryController/findStocks" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [  {
        	 field : 'stockid',  
             width : 300,  
             align: "center",
             title : '序号'
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
		commodityid: $('#commodityid').val()
	});
}


function clearInfo(){
	$("#commodityid").val("");
}

