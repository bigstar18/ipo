<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<title>出库单审核</title>

<script type="text/javascript">
$(document).ready(function() {
	getAllInfo();
});
//加载所有信息
function getAllInfo(){
	$('#name').val("");
	 $('#outboundinfo').datagrid({  
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
         url:"<%=request.getContextPath()%>/OutBoundController/geOutBoundInfo?randnum="+Math.floor(Math.random()*1000000), //搜索前,触发此action请求所有用户信息  
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
                 case 4:
                	 return "已出库";
                	 break;
                 }
             }
         }, {  
             field : 'outbounddate',  
             width : 250, 
             align: "center",
             title : '出库时间'
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
         }, {  
             field : 'test17',  
             width : 200, 
             align: "center",
             title : '操作',
             formatter:function(value,row){
            	 if(row.outboundstate==1){
     	      	   return "<a href=\"#\" onclick=\"audit('"+row.deliveryorderid+"','"+row.outboundorderid+"',2)\">通过</a>  <a href=\"#\" onclick=\"audit('"+row.deliveryorderid+"','"+row.outboundorderid+"',3)\">驳回</a>";
            	 }else if(row.outboundstate==2){
            		 return "<a href=\"#\" onclick=\"confirmOut('"+row.deliveryorderid+"','"+row.outboundorderid+"')\">已出库</a>";
            	 }else{
            		 return"";
            	 }
     	      } 
         }]],  
         pagination : true
     });  
	 var p = $('#outboundinfo').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
	
}


//确认出库
function confirmOut(deliveryorderid,outboundorderid){
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/OutBoundController/updateSate",
		data:{deliveryorderId:deliveryorderid,
			outboundorderid:outboundorderid
		},
		success:function(data){
			switch(data){
				case "success":
					alert("确认成功！");
					getAllInfo();
					break;
				case "fail":
					alert("确认失败，请稍后再试！");
					break;
				case "error":
					alert("系统异常！");
					break;
				case "no":
					alert("在线配送需客户确认后再执行出库！");
					break;
			}
		}
	});
}

//出库单审核
function audit(deliveryorderid,outboundorderid,outboundstate){
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/OutBoundController/updateOutBoundInfo",
		data:{
			outboundstate:outboundstate,
			outboundorderid:outboundorderid,
			deliveryorderid:deliveryorderid
		},
		success:function(data){
			switch(data){
			case "success":
				alert("审核成功！");
				getAllInfo();
				break;
			case "fail":
				alert("审核失败，请稍后再试！");
				break;
			case "error":
				alert("系统异常！");
				break;
			}
		}
		
	});
	
}


function doSearch(){
	$('#outboundinfo').datagrid('load',{
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

</script>
</head>
<body>
	<div id="main_body">
<table class="table1_style" border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td>		
		<br />
			<div class="div_list">
				<table id="outboundinfo" >
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