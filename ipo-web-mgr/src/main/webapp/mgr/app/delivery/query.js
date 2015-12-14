$(document).ready(function() {
	 $('#tt').datagrid({  
         title:'提货单查询',  
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
         url:'<%=request.getContextPath()%>/DeliveryController/findAllDeliveryOrders',  
         queryParams:{
        	status: null,
     		commodityname: null,
     		commodityid: null,
     		starttime:null,
     		endtime: null
    	    },
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
            	 if(value=='0') return "未申购";
            	 if(value=='1') return "已配号";
            	 if(value=='2') return "已摇号";
            	 if(value=='3') return "已结算";
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
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    }); 
		      
		      $("#starttime").datebox({
		    	        editable: false,
		                formatter: function (date) {
		                    var y = date.getFullYear();
		                    var m = date.getMonth() + 1;
		                    var d = date.getDate();
		                    return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		                },
		                onSelect:function (date){
		                  var stime=parseISO8601($('#starttime').datebox('getValue'));
		   		          var etime=parseISO8601($('#endtime').datebox('getValue'));
		   		    	   if (etime < stime) {
		   		               alert('结束日期小于开始日期');
		   		               $('#starttime').datebox('setValue', '').datebox('showPanel');
		   		           } 	
		   	     	}
		            });
	                $("#endtime").datebox({
	                	editable: false,
		                formatter: function (date) {
		                    var y = date.getFullYear();
		                    var m = date.getMonth() + 1;
		                    var d = date.getDate();
		                    return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		                },
		                onSelect:function (date){
		                  var stime=parseISO8601($('#starttime').datebox('getValue'));
		   		          var etime=parseISO8601($('#endtime').datebox('getValue'));
		   		    	   if (etime < stime) {
		   		               alert('结束日期小于开始日期');
		   		               $('#endtime').datebox('setValue', '').datebox('showPanel');
		   		           } 	
		   	     	}
		            });  
});

function doSearch(){
	$('#tt').datagrid('load',{
		status: $('#status').val(),
		commodityname: $('#commodityname').val(),
		commodityid: $('#commodityid').val(),
		starttime: $('#starttime').datebox('getValue'),
		endtime: $('#endtime').datebox('getValue')
	});
}

function parseISO8601(dateStringInRange) {
     var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s*$/,
         date = new Date(NaN), month,
         parts = isoExp.exec(dateStringInRange);
   
     if(parts) {
       month = +parts[2];
       date.setFullYear(parts[1], month - 1, parts[3]);
       if(month != date.getMonth() + 1) {
         date.setTime(NaN);
       }
     }
     return date;//new Date(str) IE8不兼容
   }