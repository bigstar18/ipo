$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'交收属性管理',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         collapsible:false,  
         toolbar:"#tb",  
         url: getRootPath () +'/DeliveryController/deliveryPropsList',  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         remoteSort:false,  
         columns : [ [ {
        	 field : 'commodityId',  
             width : 200, 
             align: "center",
             title : '商品代码' ,
             formatter: function(value,row){
                  	 return "<a href=\""+getRootPath () + "/DeliveryController/setDeliveryProps?commodityId="+value+"&&categoryId="+row.categoryId+"&&commName="+row.commodityName+"&&breedId="+row.breedId+"\">"+value+"</a>";
             } 
         }, {
        	 field : 'commodityName',  
             width : 200,  
             align: "center",
             title : '商品名称'
         }, {
        	 field : 'breedId',  
             width : 200, 
             align: "center",
             title : '品种代码'
         }, {
        	 field : 'breedName',  
             width : 200,  
             align: "center",
             title : '品种名称'
         }, {
        	 field : 'categoryId',  
             width : 200, 
             align: "center",
             title : '分类代码'
         }, {
        	 field : 'categoryName',  
             width : 200,  
             align: "center",
             title : '分类名称'
         },{  
             field : 'deliveryProp',  
             width : 200,  
             align: "center",
             title : '是否已设置' ,
             formatter:function(value){
            	 if(value=='1') return "是";
            	 if(value=='2') return "否"
           }
          }, {  
              field : '_operate',  
              width : 200,  
              align: "center",
              title : '删除操作' ,
              formatter: function(value,row){
              	if(row.deliveryProp==1){
                  return "<a  href=\"#\" onclick=\"deleteProps('"+row.commodityId+"')\">删除</a>";
                  }
                  if(row.deliveryProp==2){
                  	 return "<input type=\"button\" value=\"未设置\" disabled=\"disabled\" />";
                  }
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
		commodityName: $('#commodityName').val(),
		commodityId: $('#commodityId').val()
	});
}
function clearInfo(){
	     $('#commodityName').val("");
		 $('#commodityId').val("");
	
}
function deleteProps(commId){
	 $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: getRootPath () +"/DeliveryController/deleteCommDeliveryProps",       
                                       data: {"commodityId":commId},      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("已删除交收属性！"); 
                                           returntoList();
                                    	   }else{
                                    		   alert("系统异常，请联系管理员");  
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("系统异常，请联系管理员!");  
                                       }  
                                   }); 

}

function returntoList(){
      document.location.href =   getRootPath () +"/mgr/app/delivery/deliveryProps.jsp" ;
}