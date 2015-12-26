<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/wharehouse/public/includefiles/allincludefiles.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<title>入库申请</title>

<script type="text/javascript">

function doSearch(){
	$('#storageInfo').datagrid('load',{
		'storageid': $('#storageid').val(),
		'commodityid': $('#commodityid').val(),
		'storagestate': $('#storagestate').val()
	} );
}


$(document).ready(function() {
	getAllInfo();
});
//弹窗
function openWindow(){

		 var windowStatus = "dialogWidth:600px;dialogHeight:380px;center:1;status:0;";  
		  //在模式窗口中打开的页面  
		  var url = "app/storage/addstorageaudit.jsp";  
		  //将模式窗口返回的值临时保存  
		  var temp = showModalDialog(url,"入库单添加",windowStatus);  
		  //将刚才保存的值赋给文本输入框returnValue  
		  document.all.returnValue.value = temp; 
// 			window.open('../storage/addstorageaudit.jsp','入库单添加','height=600, width=600,top=50%,left=50%, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
<%-- 			window.open(<%=request.getContextPath()%>+'/'+data,"入库单添加",height=600,width=300); --%>

}
<%-- 	var url = "<%=request.getContextPath()%>/StorageController/AddStorageView?randnum="+Math.floor(Math.random()*1000000); --%>
// 	document.location.href=url;
	//window.open(url,"入库单添加",height=600,width=300);

//加载所有信息
function getAllInfo(){
	 $('#storageInfo').datagrid({  
         title:'入库申请单',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/StorageController/ListStorage?t='+Math.random(), //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {  
             field : 'storageid',  
             width : 200,  
             align: "center",
             title : '入库单号'  
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
             field : 'brokerid',  
             width : 200, 
             align: "center",
             title : '发行会员代码'
         }, {  
             field : 'name',  
             width : 200, 
             align: "center",
             title : '发行会员名称'
         }, {  
             field : 'storagenum',  
             width : 200, 
             align: "center",
             title : '入库件数'
         }, {  
             field : 'instoragenum',  
             width : 200, 
             align: "center",
             title : '入库数量(批)'
         }, {  
             field : 'operatorid',  
             width : 200, 
             align: "center",
             title : '录入员'
         }, {  
             field : 'warehouseauditorid',  
             width : 200, 
             align: "center",
             title : '仓库审核员'
         }, {  
             field : 'marketauditorid',  
             width : 200, 
             align: "center",
             title : '市场审核员'
         }, {  
             field : 'storagestate',  
             width : 200, 
             align: "center",
             title : '入库状态',
             formatter:function(value){
            	 if(value=='1') return "申请";
            	 if(value=='2') return "仓库通过";
            	 if(value=='3') return "仓库驳回";
            	 if(value=='4') return "市场通过";
            	 if(value=='5') return "市场驳回";
           }
         }, {  
             field : 'storagedate',  
             width : 200, 
             align: "center",
             title : '入库时间'
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




</script>
</head>
<body>
	<div id="main_body">
<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>		
		<br />
			<div class="div_list">
				<table id="storageInfo"  width="100%">
				</table>
				<div id="tb" style="padding:5px;height:auto">
					<div>
					<form name="frm"  >
					入库单号: <input id="storageid" name="storageid" class="easyui-textbox" style="border:1px solid #ccc;height:18px;width:160px;" onblur="this.value=this.value.trim()" onkeydown='if(event.keyCode==13) return false;'>
					&nbsp
					&nbsp
					商品代码: <input id="commodityid" name="commodityid" class="easyui-textbox" style="border:1px solid #ccc;height:18px;width:160px;" onblur="this.value=this.value.trim()" onkeydown='if(event.keyCode==13) return false;'>
					&nbsp
					&nbsp
					入库状态:<select id="storagestate" name="storagestate" style="width:160px">
								<option value="">全部</option>
								<option value="1"  <c:if test="${storagestate == 1}">selected</c:if>   >申请</option>
								<option value="2">仓库通过</option>
								<option value="3">仓库驳回</option>
								<option value="4">市场通过</option>
								<option value="5">市场驳回</option>
							</select>
							&nbsp
							&nbsp
							&nbsp
						<input type="button" value="查询" onclick="doSearch()"/>	
						<input type="reset" value="重置" >
							&nbsp
							&nbsp
							&nbsp
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="openWindow()">添加</a>	
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