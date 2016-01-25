$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'承销货款押金',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         singleSelect:true,
         toolbar:"#tb", 
         nowrap:true,  
         striped:true,  
         collapsible:false,  
         url:  getRootPath () + "/DeliveryController/approveDeliveryOrders" ,  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [ {
        	 field : 'deliveryorderId',  
             width : 200, 
             align: "center",
             title : '承销会员编号'
         }, {
        	 field : 'commodityId',  
             width : 200,  
             align: "center",
             title : '可用资金'
         },  {
        	 field : 'commodityName',  
             width : 200,  
             align: "center",
             title : '冻结预付货款'
         }, {
        	 field : 'dealerId',  
             width : 200,  
             align: "center",
             title : '余额'
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

function approve(id){
	document.location.href =  getRootPath () + "/IpoController/approveDelivery?deliveryorderId="+id+"&&randnum="+Math.floor(Math.random()*1000000) ;
}



function doSearch(){
       
  $('#dg').datagrid({  
         title:'待审核提货单',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         singleSelect:true,
         toolbar:"#tb",  
         url:  getRootPath () + "/DeliveryController/QueryByConditions" ,  
         queryParams:{
		          deliveryorderId: $("#deliveryorderId").val(),
		          applyDate: $("#applyDate").datebox('getValue'),
		          approvalStatus: $("#approvalStatus").val(),
		          dealerId: $("#dealerId").val()
	      },
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         columns : [ [ {
        	 field : 'deliveryorderId',  
             width : 200, 
             align: "center",
             title : '提货单号'
         }, {
        	 field : 'commodityId',  
             width : 200,  
             align: "center",
             title : '商品代码'
         },  {
        	 field : 'commodityName',  
             width : 200,  
             align: "center",
             title : '商品名称'
         }, {
        	 field : 'dealerId',  
             width : 200,  
             align: "center",
             title : '交易商代码'
         }, {
        	 field : 'dealerName',  
             width : 200,  
             align: "center",
             title : '交易商名称'
         }, {
        	 field : 'warehouseId',  
             width : 200,  
             align: "center",
             title : '仓库代码'
         }, {
        	 field : 'warehouseName',  
             width : 200,  
             align: "center",
             title : '仓库名称'
         },{
        	 field : 'deliveryQuatity',  
             width : 200,  
             align: "center",
             title : '交割数量'
         },{
        	 field : 'unit',  
             width : 200,  
             align: "center",
             title : '单位'
         },{
        	 field : 'deliveryDate',  
             width : 200,  
             align: "center",
             title : '提货日期',
             formatter: function(value,row){
                  return value.substr(0,10);
          } 
         },{
        	 field : 'applyDate',  
             width : 200,  
             align: "center",
             title : '申请日期',
             formatter: function(value,row){
                  return value.substr(0,10);
          } 
         },{  
             field : 'approvalStatus',  
             width : 200,  
             align: "center",
             title : '操作' ,
             formatter:function(value,row){
         	   return "<input type=\"button\" onclick=\"approve("+row.deliveryorderId+")\" value=\"审核\"/>";
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
		      
		      $("#applyDate").datebox({
		    	        editable: false,
		                formatter: function (date) {
		                    var y = date.getFullYear();
		                    var m = date.getMonth() + 1;
		                    var d = date.getDate();
		                    return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		                }
		            });                      
}

function clearInfo(){
	$("#deliveryorderId").val("");
	$("#applyDate").datebox('setValue',"")
	$("#dealerId").val("");
}

  //将表单数据转为json
 function form2Json() {
            var arr = $("#frm").serializeArray();
            var jsonStr = "";
 
            jsonStr += '{';
            for (var i = 0; i < arr.length; i++) {
                jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
            }
            jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
            jsonStr += '}'
 
            var json = JSON.parse(jsonStr)
            return json
        }