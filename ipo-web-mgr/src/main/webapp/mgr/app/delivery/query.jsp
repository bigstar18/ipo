<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>提货单查询</title>
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
        url:  getRootPath () + "/DeliveryController/QueryByConditions?randnum="+Math.floor(Math.random()*1000000) ,  
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
          	 field : 'deliveryMethod',  
             width : 200,  
             align: "center",
             title : '提货方式'
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
            	 if(value=='001') return "申请";
               	 if(value=='002001') return "市场通过";
               	 if(value=='002002') return "市场驳回";
               	 if(value=='003001') return "已打印";
               	 if(value=='003001001') return "已过户";
            	 if(value=='003002') return "已设置配置费用";
            	 if(value=='003002001') return "已确认";
               	 if(value=='004001') return "仓库通过";
               	 if(value=='004002') return "仓库驳回";
               	 if(value=='005')  return "已出库";
               	 if(value=='006') return "已废除";
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
});

function doSearch(){          
 $('#dg').datagrid('load',{
		deliveryorderId: $('#deliveryorderId').val(),
		applyDate: $('#applyDate').datebox('getValue'),
		approvalStatus: $('#approvalStatus').val(),
		dealerId: $('#dealerId').val()
	});
}

function clearInfo(){
	$("#deliveryorderId").val("");
	$("#applyDate").datebox('setValue',"")
	$("#approvalStatus").val("");
	$("#dealerId").val("");
}

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
		<div>
			提货单号：<input type="text" id="deliveryorderId" name="deliveryorderId" />
			申请日期：<input type="text" id="applyDate" name="applyDate"></input> 
			提货单状态: 	<select id="approvalStatus" name="approvalStatus" style="width:80">
					<option value="">请选择</option>
					<option value="001">申请</option>
					<option value="002001">市场通过</option>
					<option value="002002">市场驳回</option>
					<option value="003001">已打印</option>
					<option value="003001001">已过户</option>
					<option value="003002">已设置配置费用</option>
					<option value="003002001">已确认</option>
					<option value="004001">仓库通过</option>
					<option value="004002">仓库驳回</option>
					<option value="005">已出库</option>
					<option value="006">已废除</option>
					</select>
			交易商代码：<input type="text" id="dealerId" name="dealerId" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="clearInfo()">重置</a>					
		</div> 
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
