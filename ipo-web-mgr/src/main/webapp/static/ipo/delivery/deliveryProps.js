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
        	 field : 'commodityid',  
             width : 200, 
             align: "center",
             title : '商品代码'
         }, {
        	 field : 'commodityname',  
             width : 200,  
             align: "center",
             title : '商品名称'
         }, {  
             field : 'status',  
             width : 200,  
             align: "center",
             title : '状态' ,
             formatter:function(value){
            	 if(value=='1') return "未配号";
            	 if(value=='2') return "已配号";
            	 if(value=='3') return "已摇号";
            	 if(value=='4') return "已结算";
           }
          }, {  
              field : 'starttime',  
              width : 200,  
              align: "center",
              title : '发售日期' ,
              formatter: function(value,row){
                  return value.substr(0,10);
          } 
           }, {  
               field : 'endtime',  
               width : 200,  
               align: "center",
               title : '截止日期' ,
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
		commodityname: $('#commodityname').val(),
		commodityid: $('#commodityid').val()
	});
}
