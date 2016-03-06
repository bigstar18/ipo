<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>持仓过户</title>
<script type="text/javascript">
<%   String j;%> 
$(document).ready(function() {
	 $('#dg').datagrid({  
        title:'持仓过户',  
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
        url:  getRootPath () + "/StockController/transferRecordList" ,  
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器  
       
        columns : [ [ 
       	 {
       		 fiele : 'checked',
           	 checkbox:true
       	 },{
       	 field : 'applicationId',  
            width : 200, 
            align: "center",
            title : '申请编号'
        }, {
       	 field : 'commodityid',  
            width : 200,  
            align: "center",
            title : '商品代码'
        },  {
       	 field : 'customeridApply',  
            width : 200,  
            align: "center",
            title : '申请过户方交易商代码'
        }, {
       	 field : 'customeridAccept',  
            width : 200,  
            align: "center",
            title : '接受过户方交易商代码'
        } ,{
       	 field : 'transferNumber',  
            width : 200,  
            align: "center",
            title : '过户数量'
        }, {
       	 field : 'state',  
            width : 200,  
            align: "center",
            title : '状态',
            formatter:function(value){
           	 if(value=='0') return "申请";
           	 if(value=='1') return "审核通过";
           	 if(value=='2') return "审核驳回";
            }
        } ,{
       	 field: 'oper',
       	 width : 200,  
            title: '操作',
            align: 'center',
            formatter: function(value, row, index) {
           	 if(row.state=='0')
           		 return "<a href=\"#\" onclick=\"operation("+row.applicationId+")\">" + "操作" + "</a>";
           		//return "<a href=\""+getRootPath () + "/DeliveryController/setDeliveryProps?commodityId="+value+"&&categoryId="+row.categoryId+"&&commName="+row.commodityName+"&&breedId="+row.breedId+"\">"+value+"</a>"
           	 if(row.state=='1'|| row.state=='2')
           		 return "<a href=\"#\" onclick=\"operation("+row.applicationId+")\">" + "查看" + "</a>";
           	 
            }
        } ,{
       	 field : 'remarks',  
            width : 200,  
            align: "center",
            title : '备注'
        }, {
       	 field : 'createtime',  
            width : 200,  
            align: "center",
            title : '创建日期',
            formatter: function(value,row){
                 return value.substr(0,10);
         } 
        },{
       	 field : 'reviewtime',  
            width : 200,  
            align: "center",
            title : '审核日期',
            
            formatter: function(value,row){
            	if(value !=null)
                 	return value.substr(0,10);
         } 
        }
        ]],  
        
        pagination : true,
	      singleSelect: false,
	      selectOnCheck: true,
	      checkOnSelect: true
	     
	    
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
		commodityid: $('#commodityid').val(),
		state: $('#state').val(),
		customeridApply: $('#customeridApply').val()
	});
}

//操作
function operation(applicationId,commodityid){
	  var url_='<%=request.getContextPath()%>/StockController/openTransfer?applicationId='+applicationId;
	  
	  window.location.href=url_; 
}


//查看
function check(){
	
	  var url_='<%=request.getContextPath()%>/StockController/addTransfer';
	  window.location.href=url_; 
}

function clearInfo(){
	$("#commodityid").val("");
	$("#reviewtime").datebox('setValue',"")
	$("#customeridApply").val("");
	 $("#state").val("");
}


//添加
function add(){
	  var url_='<%=request.getContextPath()%>/StockController/addTransfer';
	  window.location.href=url_; 
}

//删除
function deleteList(){
	var checkedItems = $('#dg').datagrid('getChecked');
	var applicationIds = [];
	$.each(checkedItems,function(index,item){
		applicationIds.push(item.applicationId);
	});
	var applicationId = applicationIds.join(",");
	if(applicationId.length != 0){
		if(confirm("确定删除所选记录？")){
			  var row = $("#dg").datagrid("getSelected");
			  $.post("<%=request.getContextPath()%>/StockController/deleteInfo",{"applicationIds":applicationId},function(data,status){
				  if(data=='true'){
					  alert("删除成功！")
					  $('#dg').datagrid('reload');
				  }
				  if(data=='false'){
					  alert("删除失败")
				  }
					  });
			  }
	}else{
		alert("至少选择一条记录再进行删除！");
	}

}
</script>
</head>
<body>
<div id="main_body">
			
	<div class="div_list">
	<table id="dg" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		 <div>
			商品代码：<input type="text" id="commodityid" name="commodityid" />
			状         态： 	<select id="state" name="state" style="width:80">
					<option value="">请选择</option>
					<option value="0">申请</option>
					<option value="1">审核通过</option>	
					</select>
			申请过户交易商代码：<input type="text" id="customeridApply" name="customeridApply" />
			入库时间：<input type="text" id="reviewtime" name="reviewtime"></input> 
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload"  onclick="clearInfo()">重置</a><br/>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"  onclick="add()">添加</a>		
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"  onclick="deleteList();">删除</a>		
		</div>  
	</div>
	</div>
	
</div>
</body>

</html>
