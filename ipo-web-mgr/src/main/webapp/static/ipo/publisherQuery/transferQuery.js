$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'发行库存转持仓查询',  
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
         url:  getRootPath () + "/PublisherController/transferQuery" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [ {
        	 field : 'storageid',  
             width : 250,  
             align: "center",
             title : '入库单号'
         }, {
        	 field : 'publisherid',  
             width : 250,  
             align: "center",
             title : '发行会员代码'
         }, {
        	 field : 'publishername',  
             width : 250,  
             align: "center",
             title : '发行会员名称'
         },{
        	 field : 'commodityid',  
             width : 250,  
             align: "center",
             title : '商品代码'
         }, {
        	 field : 'commodityname',  
             width : 280,  
             align: "center",
             title : '商品名称'
         } ,{
        	 field : 'totalcounts',  
             width : 280,  
             align: "center",
             title : '总入库量'
         },{
        	 field : 'pubposition',  
             width : 250,  
             align: "center",
             title : '转持仓量(批)'
         },{
        	 field : 'salecounts',  
             width : 250,  
             align: "center",
             title : '转公开发行量(批)'
         },{
        	 field : 'subscricounts',  
             width : 250,  
             align: "center",
             title : '供承销认购量(批)'
         },{
        	 field : 'status',  
             width : 250,  
             align: "center",
             title : '状态',
             formatter:function(value){
            	 if(value=='1') return "新增";
            	 if(value=='2') return "已冻结费用";
            	 if(value=='3') return "已扣费";
            	 if(value=='4') return "已转持仓";
            	 return "未设置";
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




