$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'产品发行查询',  
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
         url:  getRootPath () + "/PublisherController/findAllCommsByExample" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [  {
        	 field : 'pubmemberid',  
             width : 200,  
             align: "center",
             title : '发行会员代码'
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
         } , {
        	 field : 'status',  
             width : 200,  
             align: "center",
             title : '状态',
             formatter:function(value){
            	 if(value=='1') return "未配号";
            	 if(value=='2') return "已配号";
            	 if(value=='3') return "已摇号";
            	 if(value=='4') return "已结算";
           }
         },{
        	 field : 'listingdate',  
             width : 200,  
             align: "center",
             title : '上市日期',
             formatter: function(value,row){
                  return value.substr(0,10);
          } 
         },{
        	 field : 'lasttradate',  
             width : 200,  
             align: "center",
             title : '最后交易日',
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
});
	
 function doSearch(){
	$('#dg').datagrid('load',{
		pubmemberid:$("#pubmemberid").val()
	});
}


function clearInfo(){
	$("#pubmemberid").val("");
}

