$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'入库单审核',  
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
         url:  getRootPath () + "/DeliveryController/findAllStorages" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [ {
        	 field : 'warehouseid',  
             width : 200, 
             align: "center",
             title : '仓库号'
         }, {
        	 field : 'storageid',  
             width : 200,  
             align: "center",
             title : '入库单号'
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
        	 field : 'publishername',  
             width : 200,  
             align: "center",
             title : '发行会员名称'
         } ,{
        	 field : 'storagenum',  
             width : 200,  
             align: "center",
             title : '入库件数'
         } ,{
        	 field : 'storagecounts',  
             width : 200,  
             align: "center",
             title : '入库数量（批）'
         }, {
        	 field : 'startnum',  
             width : 200,  
             align: "center",
             title : '起始标码'
         },{
        	 field : 'endnum',  
             width : 200,  
             align: "center",
             title : '结束标码'
         }, {
        	 field : 'operatorid',  
             width : 200,  
             align: "center",
             title : '录入员'
         },{
        	 field : 'warehouseauditorid',  
             width : 200,  
             align: "center",
             title : '仓库审核员'
         }, {
        	 field : 'marketauditorid',  
             width : 200,  
             align: "center",
             title : '市场审核员'
         }, {
        	 field : 'storagestate',  
             width : 200,  
             align: "center",
             title : '入库状态',
             formatter:function(value){
            	 if(value=='1') return "申请";
            	 if(value=='2') return "仓库通过";
            	 if(value=='3') return "仓库驳回";
            	 if(value=='4') return "市场通过";
            	 if(value=='5') return "市场驳回";
           }
         },{
        	 field : 'storagedate',  
             width : 200,  
             align: "center",
             title : '入库日期',
             formatter: function(value,row){
                  return value.substr(0,10);
          } 
         },
         {
        	 field : 'mapperbillid',  
             width : 200,  
             align: "center",
             title : '操作',
             formatter: function(value,row){
             	if(row.storagestate==2){
                  var hrefpath=getRootPath () + "/DeliveryController/approveStorages";
                  return  "<a href=\""+hrefpath+"?storageId="+row.storageid+"&&flag=true\"  onclick=\"confirmDialog(1);\">通过</a>&nbsp; <a href=\""+hrefpath+"?storageId="+row.storageid+"&&flag=false\"  onclick=\"confirmDialog(2);\">驳回</a>";
             	}
             	return "";} 
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
		      
	 $("#storagedate").datebox({
		 editable: false,
		 formatter: function (date) {
		            var y = date.getFullYear();
		            var m = date.getMonth() + 1;
		            var d = date.getDate();
		            return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		          }
		 });
		            
});

function confirmDialog(flag){
	if(flag==1){
    if(confirm('确定要审核通过吗？')){
        return true;
    }else{
        return false;
    }}
    if(flag==2){
    if(confirm('确定要审核驳回吗？')){
        return true;
    }else{
        return false;
    }}
    return false;
}

	
 function doSearch(){
	$('#dg').datagrid('load',{
		storageid: $('#storageid').val(),
		commodityid: $('#commodityid').val(),
		storagestate: $('#storagestate').val(),
		storagedate: $('#storagedate').datebox('getValue')
	});
}


function clearInfo(){
	$("#storageid").val("");
	$("#storagedate").datebox('setValue',"")
	$("#commodityid").val("");
	$("#storagestate").val("");
}
