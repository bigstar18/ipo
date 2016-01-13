$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'发行货款跟踪',  
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
         } ,{
        	 field : 'listingdate',  
             width : 200,  
             align: "center",
             title : '摇号日期',
             formatter: function(value,row){
                  return value.substr(0,10);
          } 
         },{
        	 field : 'commodityname',  
             width : 200,  
             align: "center",
             title : '应付货款'
         } , {
        	 field : 'status',  
             width : 200,  
             align: "center",
             title : '状态',
             formatter:function(value){
            	 if(value=='1') return "已付款";
            	 if(value=='2') return "未付款";
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
		commodityid:$("#commodityid").val()
	});
}


function clearInfo(){
	$("#commodityid").val("");
}

