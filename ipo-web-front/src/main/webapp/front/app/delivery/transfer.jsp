<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../skinstyle/default/css/common.css">
		<link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
    <style type="text/css">
    	.mbodytop{padding:5px;border-top:1px solid #95b8e7;border-right:1px solid #95b8e7;border-left:1px solid #95b8e7;background:#eff5ff}
			input{padding-left:4px;width:10pc;height:20px;border:1px solid #95b8e7;border-radius:5px}
			b{color:red;font-size:15px}
			td{white-space:normal}
			.mbody{border:1px solid #95b8e7;background:#f4f4f4}
			.deliveryInfo{display:none}
			#add,#close{width:90px;height:25px;border-radius:3px;background:#fff}
    </style>
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
				case "001":
					$("#approvalStatus").val("申请");
					break;
				case "002001":
					$("#approvalStatus").val("市场通过");
					$("#add").val("过户");
					break;
				case "002002":
					$("#approvalStatus").val("市场驳回");
					break;
				case "003001":
					$("#approvalStatus").val("已打印");
					break;
				case "003001001":
					$("#approvalStatus").val("已过户");
					break;
				case "003002":
					$("#approvalStatus").val("已设置配置费用");
					break;
				case "003002001":
					$("#approvalStatus").val("已确认");
					break;
				case "004001":
					$("#approvalStatus").val("仓库通过");
					break;
				case "004002":
					$("#approvalStatus").val("仓库驳回");
					break;
				
				case "005":
					$("#approvalStatus").val("已出库");
					break;
				case "006":
					$("#approvalStatus").val("已废除");
					break;
				}
			}else if(data.commodityId==null){
				$("#deliveryInfo").hide();
				alert("提货单不存在！")
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
    if(appstatus=='市场通过'||appstatus=='已打印'){
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/TransferController/updateSate",
		data:{
			deliveryorderId:$("#deliveryorderId").val(),
			pickupPassword:$("#pickupPassword").val()
		},
		success:function(data){
			if(data=="true"){
				alert("过户成功！");
				closeform();
			}
			if(data=="false"){
				alert("过户失败！");
			}
			if(data=="fundshort"){
				alert("资金不足，无法过户！");
			}
			if(data=="error"){
				alert("系统异常!");
			}
		}
	});
    }else{
    	alert("只有通过市场审核的提货单才能过户！");
    }
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
      <div class="content">提货单过户(必须是自提方式的提货单才能过户)！
      </div>
    </div>
    <div class="mbodytop">
		  <div class="panel-title panel-with-icon">提单过户</div>
		</div>
		<div class="mbody">
		<form>

							<table border="0" width="550" align="center" style="margin-top: 25px;">
								<tr>
									<td align="right" width="90">
											提货单号：
									</td>
									<td align="left" width="200">
										<input  id="deliveryorderId" name="" value="" class="easyui-validatebox textbox"  data-options="required:true,missingMessage:'必填'"/>
									</td>
									<td align="right" width="90">
										提货单密码：
									</td>
									<td align="left" width="200">
										<input id="pickupPassword" name="" value="" class="easyui-validatebox textbox"  data-options="required:true,missingMessage:'必填'"/>
									</td>
								</tr>
							</table>
							<table id="deliveryInfo" width="550" style="display:none" align="center">
										<tr>
											<td align="right" width="90">
												商品代码：
											</td>
											<td align="left" width="200">
												<input readonly="readonly" id="commodityid" class="easyui-text">
											</td>
											<td align="right" width="90">
												商品名称：
											</td>
											<td align="left" width="200">
												<input id="commodityname" class="easyui-text">
											</td>
										</tr>
										<tr>
											<td align="right" width="90">
												交易商名称：
											</td>
											<td align="left" width="200">
												<input id="dealerName" class="easyui-text">
											</td>
											<td align="right" width="90">
												仓库名称：
											</td>
											<td align="left" width="200">
												<input id="warehousename" class="easyui-text">
											</td>
										</tr>
										<tr>
											<td align="right" width="90">
												提货方式：
											</td>
											<td align="left" width="200">
												<input id="deliveryMethod" class="easyui-text">
											</td>
											<td align="right" width="90">
												提货日期：
											</td>
											<td align="left" width="200">
												<input id="deliveryDate" class="easyui-text">
											</td>
										</tr>
										<tr>
											<td align="right" width="90">
												交割数量：
											</td>
											<td align="left" width="200">
												<input id="deliveryQuatity" class="easyui-text">
											</td>
											<td align="right" width="90">
												审批状态：
											</td>
											<td align="left" width="200">
												<input id="approvalStatus" class="easyui-text">
											</td>
										</tr>
							</table>
							<table style="border-top:0" align="center">
								<tr>
									<td align="center">
										<input type="button" class="btn_sec" id="add" onclick="doClick()" value="查询">
				   						 <input type="button" class="btn_sec" id="close" onclick="closeform()" value="关闭">
									</td>
								</tr>
							</table>
		</form>
	</div>
	</div>
	</body>
</html>
