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
         url:  getRootPath () + "/PublisherController/findUnderwriters" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [   {
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
        	 field : 'underwriterid',  
             width : 200,  
             align: "center",
             title : '承销会员代码'
         }, {
        	 field : 'underwritername',  
             width : 200,  
             align: "center",
             title : '承销会员名称'
         } ,{
        	 field : 'starttime',  
             width : 200,  
             align: "center",
             title : '公开发行日期',
             formatter: function(value,row){
                  return value.substr(0,10);
          } 
         },{
        	 field : 'price',  
             width : 200,  
             align: "center",
             title : '发行价格' 
         },{
        	 field : 'counts',  
             width : 200,  
             align: "center",
             title : '发行数量' 
         },{
        	 field : 'listingdate',  
             width : 200,  
             align: "center",
             title : '上市日期',
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
		commodityid:$("#commodityid").val(),
		commodityname:$("#commodityname").val()
	});
}


function clearInfo(){
	$("#commodityid").val("");
	$("#commodityname").val("");
}

