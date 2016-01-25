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
         columns : [ [ {
        	 field : 'storageid',  
             width : 250,  
             align: "center",
             title : '入库单号'
         }, {
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
        	 field : 'transferstate',  
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
         } , {
        	 field : 'operator',  
             width : 200,  
             align: "center",
             title : '操作',
             formatter:function(value,row){
             	if(row.transferstate==1) return "<input type=\"button\" onclick=\"forzen('"+row.storageid+"')\" value=\"冻结\"/>";
             	if(row.transferstate==2) return "";
             	if(row.transferstate==3) return "<input type=\"button\" onclick=\"transfer('"+row.storageid+"')\" value=\"转持仓\"/>";
             	if(row.transferstate==4) return "";
                return "<input type=\"button\" onclick=\"setInfo('"+row.storageid+"')\" value=\"设置\"/>";
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

function setInfo(value){
	document.location.href = getRootPath ()+ '/PublisherController/addTransferPosition?storageid='+value+'&&randnum='+Math.floor(Math.random()*1000000);

}


function forzen(value){
	                        $.ajax({ 
                            		   cache:false,
                                       type: "get",  
                                       url: getRootPath ()+"/PublisherController/frozenFunds",    
                                       contentType: "application/json; charset=utf-8",
                                       data: {"storageid":value},  
                                        dataType: 'json',
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("冻结成功！");
                                           $('#dg').datagrid('reload');
                                    	   }else if(data=='false'){
                                    		   alert("资金不足，冻结失败！");  
                                    		   return;
                                    	   }else{
                                    	   alert("后台异常！");
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("请求失败！");  
                                       }  
                                   }) ;
}


function transfer(value){
	                        $.ajax({ 
                            		   cache:false,
                                       type: "get",  
                                       url: getRootPath ()+"/PublisherController/transfer",       
                                       data: {"storageid":value},      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("转持仓成功！");
                                           $('#dg').datagrid('reload');
                                    	   }else if(data=='false'){
                                    		   alert("转持仓失败！");  
                                    		   return;
                                    	   }else{
                                    	   alert("后台异常！");
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("请求失败！");  
                                       }  
                                   }) ;
}



