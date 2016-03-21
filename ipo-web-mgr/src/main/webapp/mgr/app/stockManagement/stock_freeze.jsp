<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>持仓冻结/解冻</title>
<script type="text/javascript">
<%   String j;%> 
$(document).ready(function() {
	 $('#dg').datagrid({  
        title:'持仓冻结/解冻',  
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
        url:  getRootPath () + "/StockController/freezeRecordList" ,  
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
            title : '冻结编号'
        }, {
       	 field : 'commodityid',  
            width : 200,  
            align: "center",
            title : '商品代码'
        },  {
       	 field : 'customerid',  
            width : 200,  
            align: "center",
            title : '交易商代码'
        }, {
       	 field : 'freezeNumber',  
            width : 200,  
            align: "center",
            title : '冻结数量'
        }, {
       	 field : 'state',  
            width : 200,  
            align: "center",
            title : '状态',
            formatter:function(value){
           	 if(value=='0') return "冻结";
           	 if(value=='1') return "解冻";
            }
        }, {
          	 field : 'freezereason',  
             width : 200,  
             align: "center",
             title : '冻结原因'
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
	    $("#reviewtime").datebox({
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
		commodityid: $('#commodityid').val(),
		state: $('#state').val(),
		reviewtime: $('#reviewtime').datebox('getValue'),
		customerid: $('#customerid').val()
		
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
	$("#customerid").val("");
	 $("#state").val("");
}


//添加
function add(){
	  var url_='<%=request.getContextPath()%>/StockController/addFreeze';
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
		if(confirm("确定解冻所选记录？")){
			  var row = $("#dg").datagrid("getSelected");
			  $.post("<%=request.getContextPath()%>/StockController/unfreezeInfo",{"applicationIds":applicationId},function(data,status){
				  if(data=='true'){
					  alert("解冻成功！")
					  $('#dg').datagrid('reload');
				  }
				  if(data=='false'){
					  alert("解冻失败，请选择冻结状态下的信息")
				  }
					  });
			  }
	}else{
		alert("至少选择一条记录再进行解冻！");
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
					<option value="0">冻结</option>
					<option value="1">解冻</option>	
					</select>
			交易商代码：<input type="text" id="customerid" name="customeridApply" />
			审核时间：<input type="text" id="reviewtime" name="reviewtime" class="easyui-datebox"></input> 
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload"  onclick="clearInfo()">重置</a><br/>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"  onclick="add()">冻结</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove"  onclick="deleteList();">解冻</a>		
		</div>  
	</div>
	</div>
	
</div>
</body>

</html>
