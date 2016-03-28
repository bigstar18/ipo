<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>减持设置</title>
<script  type="text/javascript">
$(document).ready(function() {
	 $('#dg').datagrid({  
        title:'持仓信息',  
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
        url:  getRootPath () + "/PublisherController/reduceHoldPosition" ,  
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器   
        columns : [ [  {
       	 field : 'id',  
            width : 200,  
            align: "center",
            title : '持仓单号'
           },  {
       	 field : 'publisherId',  
            width : 200,  
            align: "center",
            title : '发行会员编号'
           }, {
       	 field : 'firmId',  
            width : 200,  
            align: "center",
            title : '交易商代码'
        }, {
       	 field : 'commodityId',  
            width : 200,  
            align: "center",
            title : '商品代码'
        } ,{
       	 field : 'commodityName',  
            width : 200,  
            align: "center",
            title : '商品名称'
        } ,{
       	 field : 'holdqty',  
            width : 200,  
            align: "center",
            title : '转持仓数量(批)'
        } ,{
       	 field : 'frozenqty',  
            width : 200,  
            align: "center",
            title : '冻结数量(批)',
            formatter: function(value,row) {
            	if(row.freeqty==null){
            		return value;
            	}
            	 return value-row.freeqty;
           }
        } ,{
       	 field : 'freeqty',  
            width : 200,  
            align: "center",
            title : '释放数量(批)',
            formatter: function(value,row) {
            	if(value==null){
            		return 0;
            	}
            	 return value;
           }
        } ,{
           field: 'oper',
           title: '操作',
           align: 'center',
           formatter: function(value,row) {
       	   return "<a href=\"#\" onclick=\"add("+row.id+")\">" + "减持设置" + "</a>";
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
		publisherId:$("#publisherid").val(),
		commodityId:$("#commodityid").val()
	});
}


function clearInfo(){
	$("#publisherid").val("");
	$("#commodityid").val("");
}

function add(id){
	document.location.href= '<%=request.getContextPath()%>/PublisherController/reduceSet?id='+id+'&&randnum='+Math.floor(Math.random()*1000000);
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
						发行会员编号：<input type="text" id="publisherid" name="publisherid" />
						商品代码：<input type="text" id="commodityid" name="commodityid" />
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
