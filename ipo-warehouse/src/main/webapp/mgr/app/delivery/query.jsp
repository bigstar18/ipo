<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<html>
<head>
<title>提货单查询</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">

$(document).ready(function() {
	 $('#dg').datagrid({  
        title:'提货单查询',  
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
        url:  "<%=request.getContextPath()%>/DeliveryController/findAllDeliveryOrders" ,  
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器   
        remoteSort:false, 
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
            title : '状态' ,
            formatter:function(value){
           	 if(value=='1') return "未审核";
           	 if(value=='2') return "通过";
           	 if(value=='3') return "驳回";
           	 if(value=='4') return "已收货";
           	 if(value=='5') return "废除";
          }
         }
        ]],  
        pagination : true ,  
        rownumbers : false 
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
});

function doSearch(){
	
   /* var options = $('#dg').datagrid('getPager').data("pagination").options;  
    var curr = options.pageNumber;
    var rows=  options.pageSize;
    $('#pageNo').val(curr);
    $('#pageSize').val(rows);
           $.ajax({ 
                 type: "post",  
                 url: getRootPath () + "/DeliveryController/QueryByConditions",       
                 data: form2Json(),      
                 success: function(result) { 
                     $("#dg").datagrid("reload",result); 
                 }
           });*/
           
 $('#dg').datagrid({  
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
        url:   "<%=request.getContextPath()%>/DeliveryController/QueryByConditions" ,  
        queryParams:{
		          deliveryorderId: $("#deliveryorderId").val(),
		          applyDate: $("#applyDate").datebox('getValue'),
		          approvalStatus: $("#approvalStatus").val(),
		          dealerId: $("#dealerId").val()
	      },
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器   
        remoteSort:false, 
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
            title : '状态' ,
            formatter:function(value){
           	 if(value=='1') return "未审核";
           	 if(value=='2') return "通过";
           	 if(value=='3') return "驳回";
           	 if(value=='4') return "已收货";
           	 if(value=='5') return "废除";
          }
         }
        ]],  
        pagination : true,  
        rownumbers : false  
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
	$("#approvalStatus").val("");
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
       
/*var sy = $.extend({}, sy);定义一个全局变量

sy.serializeObject = function (form) { 将form表单内的元素序列化为对象，扩展Jquery的一个方法
var o = {};
$.each(form.serializeArray(), function (index) {
if (o[this['name']]) {
o[this['name']] = o[this['name']] + "," + this['value'];
} else {
o[this['name']] = this['value'];
}
});
return o;
};*/




</script>
</head>
<body>
<div id="main_body">
			<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<br />
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
	 <form id="frm" name="frm" method="POST">
		<div>
			提货单号：<input type="text" id="deliveryorderId" name="deliveryorderId" />
			申请日期：<input type="text" id="applyDate" name="applyDate"></input> 
			提货单状态: 	<select id="approvalStatus" name="approvalStatus" style="width:80">
					<option value="">请选择</option>
					<option value="1">未审核</option>
					<option value="2">通过</option>
					<option value="3">驳回</option>
					<option value="4">已收货</option>
					<option value="5">废除</option>
					</select>
			交易商代码：<input type="text" id="dealerId" name="dealerId" />
			<input type="button" value="查询" onclick="doSearch()"/>		
			<input type="button" value="重置" onclick="clearInfo()"/>			
		</div> 
		</from>
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
