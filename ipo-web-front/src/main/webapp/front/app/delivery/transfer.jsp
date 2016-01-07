<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../skinstyle/default/css/common.css"> 
		<link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		<title>提货单过户</title>
		<style type="text/css">
			tr{font-size:12px}
		</style>
<script type="text/javascript"> 

function doSearch(){
	var deliveryorderId = $("#deliveryorderId").val();
	var pickupPassword = $("#pickupPassword").val();	
	$.ajax({
		type:"GET",
		url:"<%=request.getContextPath()%>/TransferController/getDeliveryInfo?randnum="+Math.floor(Math.random()*1000000),
		data:{
			pickupPassword:pickupPassword,
			deliveryorderId:deliveryorderId
		},
		dataType: "json", 
		success:function(data){
			if(data!="error"&&data.commodityId!=null){
				$("#deliveryInfo").show();
				$("#commodityid").val(data.commodityId);
				$("#commodityname").val(data.commodityName);
				$("#dealerName").val(data.dealerName);
				$("#warehousename").val(data.warehousename);
				$("#deliveryMethod").val(data.deliveryMethod);
				$("#deliveryDate").val(data.deliveryDate.substr(0,10));
				$("#deliveryQuatity").val(data.deliveryQuatity);
				switch(data.approvalStatus){
				case 1:
					$("#approvalStatus").val("申请");
					break;
				case 2:
					$("#approvalStatus").val("市场通过");
					$("#add").val("过户");
					break;
				case 3:
					$("#approvalStatus").val("市场驳回");
					break;
				case 4:
					$("#approvalStatus").val("已过户");
					break;
				case 5:
					$("#approvalStatus").val("打印");
					break;
				case 6:
					$("#approvalStatus").val("仓库通过");
					break;
				case 7:
					$("#approvalStatus").val("仓库驳回");
					break;
				case 8:
					$("#approvalStatus").val("已设置配置费用");
					break;
				case 9:
					$("#approvalStatus").val("已确认");
					break;
				case 10:
					$("#approvalStatus").val("已废除");
					break;
				case 11:
					$("#approvalStatus").val("已出库");
					break;
				case 12:
					$("#approvalStatus").val("已收货");
					break;
				}
			}else if(data.commodityId==null){
				$("#deliveryInfo").hide();
				alert("提货单不存在(自提单请输入密码)！")
			}
		}
		
	});
}
	//过户
function doAdd(){
    var appstatus=$("#approvalStatus").val();
    if(appstatus=='申请'){
    	alert("提货单还未进行市场审核，无法过户！");
    	return ;
    }
    if(appstatus!='市场通过'){
    	alert("提货单未通过市场审核，无法过户！");
    	return ;
    }
	var deliveryorderId = $("#deliveryorderId").val();
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/TransferController/updateSate",
		data:{
			deliveryorderId:deliveryorderId
		},
		success:function(data){
			if(data=="success"){
				alert("过户成功！");
				closeform();
			}
			if(data=="fail"){
				alert("过户失败！");
			}
			if(data=="error"){
				alert("系统异常!");
			}
		}
		
	});
}

function closeform(){
	var backUrl="<%=request.getContextPath()%>/front/app/delivery/transfer.jsp";
	document.location.href = backUrl;
}

function doClick(){
	var temp = $("#add").val();
	if(temp=="查询"){
		doSearch();
	}else if(temp=="过户"){
		doAdd();
	}
}


</script>
	</head>
	<body>
	 <div class="main">
	<div class="msg">
         您当前的位置：<span>提货单过户</span>
    </div>
    <div class="warning">
      <div class="title font_orange_14b">温馨提示 :</div>
      <div class="content">提货类型为自提时需要提货单密码，在线配送时不需要提货单密码！ 
      </div>
    </div>
	
		<form>
						<div class="div_cxtj">
							<div class="div_cxtjL"></div>
							<div class="div_cxtjC">
								提货单过户
							</div>
							<div class="div_cxtjR"></div>
						</div>
						<div style="clear: both;"></div>

							<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
								<tr>
									<td align="center">
										<span class="required">*</span>
											提货单号：
										<input  id="deliveryorderId" name="" value="" class="easyui-validatebox textbox"   style="width:160px;height:20px;"/> 
									</td>
									<td align="center">
										<span class="required">*</span>
										提货单密码：
										<input id="pickupPassword" name="" value="" class="easyui-validatebox textbox"   style="width:160px;height:20px;"/> 
									</td>
								</tr>
							</table>
							<table id="deliveryInfo" class="table2_style" style="border-top:0;display:none" align="center">
										<tr>
											<td align="center">
											商品代码：
											<input readonly="readonly" id="commodityid" class="easyui-text" style="width:160px;height:20px;">
											</td>
											<td align="center">
											商品名称：
											<input id="commodityname" class="easyui-text" style="width:160px;height:20px;">
											</td>
										</tr>
										<tr>
											<td align="center">
											交易商名称：
											<input id="dealerName" class="easyui-text" style="width:160px;height:20px;margin-right:12px">
											</td>
											<td align="center">
											仓库名称：
											<input id="warehousename" class="easyui-text" style="width:160px;height:20px;">
											</td>
										</tr>
										<tr>
											<td align="center">
											提货方式：
											<input id="deliveryMethod" class="easyui-text" style="width:160px;height:20px;">
											</td>
											<td align="center">
											提货日期：
											<input id="deliveryDate" class="easyui-text" style="width:160px;height:20px;">
											</td>
										</tr>
										<tr>
											<td align="center">
											交割数量：
											<input id="deliveryQuatity" class="easyui-text" style="width:160px;height:20px;">
											</td>
											<td align="center">
											审批状态：
											<input id="approvalStatus" class="easyui-text" style="width:160px;height:20px;">
											</td>
										</tr>
							</table>
							<table class="table2_style" style="border-top:0" align="center">
								<tr>
									<td align="center">
										<input type="button" class="btn_sec" id="add" onclick="doClick()" value="查询">
				   						 <input type="button" class="btn_sec" id="close" onclick="closeform()" value="关闭">
									</td>
								</tr>
							</table>
		</form>	
	</div>
	</body>
</html>
