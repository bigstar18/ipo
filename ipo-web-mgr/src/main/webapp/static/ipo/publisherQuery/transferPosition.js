$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'发行库存转持仓',  
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
         url:  getRootPath () + "/PublisherController/transferPosition" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [  {
        	 field : 'pubmemberid',  
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
        	 field : 'storagecounts',  
             width : 280,  
             align: "center",
             title : '入库数量'
         },{
        	 field : 'storagedate',  
             width : 250,  
             align: "center",
             title : '入库日期',
             formatter:function(value){
             	return value.substr(0,10);
             }
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
           }
         } , {
        	 field : 'operator',  
             width : 200,  
             align: "center",
             title : '操作',
             formatter:function(value,row){
                 return "<input type=\"button\" onclick=\"transfer('"+row.storageid+"')\" value=\"转持仓\"/>";
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

function transfer(value){
	document.location.href = getRootPath ()+ '/PublisherController/addTransferPosition?storageid='+value+'&&randnum='+Math.floor(Math.random()*1000000);

}