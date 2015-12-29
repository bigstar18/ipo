<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<title>出库申请</title>

<script type="text/javascript">
$(document).ready(function() {
	getAllInfo();	  
});
//加载所有信息
function getAllInfo(){
	$('#name').val("");
	 $('#storageInfo').datagrid({  
         title:'出库申请单',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/OutBoundController/geOutBoundInfo', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {  
             field : 'outboundorderid',  
             width : 200,  
             align: "center",
             title : '出库单号'  
         },{
        	 field : 'deliveryorderid',  
             width : 200,  
             align: "center",
             title : '提货单号'
         },{
        	 field : 'commodityid',  
             width : 200,  
             align: "center",
             title : '商品代码'
         },{  
             field : 'commodityname',  
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
             field : 'deliveryperson',  
             width : 200, 
             align: "center",
             title : '提货人'
         }, {  
             field : 'sex',  
             width : 200, 
             align: "center",
             title : '性别'
         }, {  
             field : 'idtype',  
             width : 200, 
             align: "center",
             title : '证件类型'
         }, {  
             field : 'idnum',  
             width : 200, 
             align: "center",
             title : '证件号码 '
         }, {  
             field : 'deliveryQuatity',  
             width : 200, 
             align: "center",
             title : '交割数量(批)'
         }, {  
             field : 'deliveryMethod',  
             width : 200, 
             align: "center",
             title : '提货类型'
         }, {  
             field : 'outboundstate',  
             width : 200, 
             align: "center",
             title : '出库状态',
             formatter: function(value,row){
                 switch(value){
                 case 1:
                	 return "申请";
                	 break;
                 case 2:
                	 return "审核通过";
                	 break;
                 case 3:
                	 return "审核驳回";
                	 break;
                 }
             }
         }, {  
             field : 'outbounddate',  
             width : 200, 
             align: "center",
             title : '出库时间',
             formatter: function(value,row){
                 return value.substr(0,10);
             }
         }, {  
             field : 'operatorid',  
             width : 200, 
             align: "center",
             title : '录入员'
         }, {  
             field : 'auditorid',  
             width : 200, 
             align: "center",
             title : '审核员'
         }]],  
         pagination : true
     });  
	 var p = $('#storageInfo').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
	
}

function doSearch(){
	$('#storageInfo').datagrid('load',{
		outboundorderid: $('#outboundorderid').val(),
		outbounddate: $('#outbounddate').datebox('getValue'),
		outboundstate: $('#outboundstate').val(),
		deliveryorderid: $('#deliveryorderid').val(),
		deliveryMethod: $('#deliveryMethod').val()
	});
}

function clearInfo(){
	$("#outboundorderid").val("");
	$("#deliveryorderid").val("");
	$("#outbounddate").datebox('setValue',"")
	$("#outboundstate").val("");
	$("#deliveryMethod").val("");
	doSearch();
}


//修改日期格式
function myformatter(date){
		 var y = date.getFullYear();
		 var m = date.getMonth()+1;
		 var d = date.getDate();
		 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
function myparser(s){
		 if (!s) return new Date();
		 var ss = (s.split('-'));
		 var y = parseInt(ss[0],10);
		 var m = parseInt(ss[1],10);
		 var d = parseInt(ss[2],10);
		 if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		 return new Date(y,m-1,d);
	}else{
		return new Date();
	}
 }

//弹窗
function OpenFrame() {
	$('#dd').empty();
    $('#dd').append("<iframe style='width:100%;height:100%' src='../outbound/addoutboundaudit.jsp'></iframe>");
    $('#dd').window('open');
}

</script>
</head>
<body>
<div id="dd" title="出库单添加"  class="easyui-window"  closed="true" style="width:800px;height:600px;padding:5px;">
</div>
<div id="main_body">
<table class="table1_style" border="0" cellspacing="0" cellpadding="0" style="border:0;width:100%">
	<tr>
		<td>		
		<br />
			<div class="div_list">
				<table id="storageInfo">
				</table>
				<div id="tb" style="padding:5px;height:auto">
					<div>
					<form name="frm" action="" >
					<table style="font-size:12px">
						<tr>
							<td>
								出库单号:
							 <input id="outboundorderid" name="" class="easyui-textbox" style="border:1px solid #ccc;height:18px;width:160px;">
								&nbsp
								提货单号: 
							 <input id="deliveryorderid" name="" class="easyui-textbox" style="border:1px solid #ccc;height:18px;width:160px;">
								&nbsp
								出库时间: 
								<input id="outbounddate" name="outbounddate" class="easyui-datebox" style="border:1px solid #ccc;height:18px;width:160px;" data-options="formatter:myformatter,parser:myparser">
							</td>
						</tr>
						<tr>
						
						</tr>
						<tr>
							<td>
								出库状态:
								<select id="outboundstate" name="" style="width:160px">
									<option value="">全部</option>
									<option value="1">申请</option>
									<option value="2">审核通过</option>
									<option value="3">审核驳回</option>
								</select>
								&nbsp
								提货类型:
								<select id="deliveryMethod" name="" style="width:160px">
									<option value="">全部</option>
									<option value="自提">自提</option>
									<option value="在线配送">在线配送</option>
								</select>
								&nbsp
								<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="clearInfo()">重置</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="OpenFrame()">添加</a>
							</td>
						</tr>
					</table>

					
					</form> 
					</div>
				</div>
				
			</div>
		</td>
	</tr>
</table>
   
</div>
</body>
</html>