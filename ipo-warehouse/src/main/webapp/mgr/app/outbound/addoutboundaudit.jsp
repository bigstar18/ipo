<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../skinstyle/default/css/common.css"> 
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		<title>出库添加</title>
		<style type="text/css">
			tr{font-size:12px};
			.bj{color:red};
		</style>
<script type="text/javascript"> 

function doSearch(){
	var deliveryorderId = $("#deliveryorderId").val();
	var pickupPassword = $("#pickupPassword").val();	
	$.ajax({
		type:"GET",
		url:"<%=request.getContextPath()%>/OutBoundController/getDeliveryInfo?randnum="+Math.floor(Math.random()*1000000),
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
				$("#warehouseName").val(data.warehousename);
				$("#deliveryMethod").val(data.deliveryMethod);
				$("#deliveryDate").val(data.deliveryDate.substr(0,10));
				$("#deliveryQuatity").val(data.deliveryQuatity);
				$("#deliveryperson").val(data.dealerName);
				$("#idnum").val(data.idcardNum);
				if(data.idcardNum!=null){
					$("#idtype").val("身份证");
					if (parseInt(data.idcardNum.substr(16, 1)) % 2 == 1) { 
						$("#sex").val("男");
						} else { 
						$("#sex").val("女");
						} 
				}				
				
				
				switch(data.approvalStatus){
				case 1:
					$("#approvalStatus").val("申请");
					break;
				case 2:
					$("#approvalStatus").val("市场通过");
					break;
				case 3:
					$("#approvalStatus").val("市场驳回");
					break;
				case 4:
					$("#approvalStatus").val("已打印");
					break;
				case 5:
					$("#approvalStatus").val("已过户");
					$("#add").val("添加");
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
				if(data.deliveryMethod=="在线配送"){
					$("#psInfo").show();
				}
				$("#cost").html(data.cost);
				$("#receiver").html(data.receiver);
				$("#tel").html(data.tel);
				$("#address").html(data.address);
				
				
			}else if(data.commodityId==null){
				$("#deliveryInfo").hide();
				alert("提货单不存在！")
			}
		}
		
	});
}

function existOutboundId(){
	var deliveryorderId = $("#deliveryorderId").val();
	var url_="<%=request.getContextPath()%>/OutBoundController/getOutboundorder?deliveryorderId="+deliveryorderId;
	$.get(url_,function(data){
		 if(data==true){
			 doAdd();
		 }else{
			 alert("出库申请已经存在");
		 }

});

}

function doAdd(){
	var deliveryorderId = $("#deliveryorderId").val();
	var outboundstate = 1;
	var outbounddate = $("#deliveryDate").val();
	var warehouseid = $("#warehouseName").val();
	var deliveryperson = $("#deliveryperson").val();
	var sex=$("#sex").val();
	var idtype = $("#idtype").val();
	var idnum=$("#idnum").val();
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/OutBoundController/addOutBoundOrder",
		data:{
			deliveryorderid:deliveryorderId,
			outboundstate:outboundstate,
			warehouseid:warehouseid,
			deliveryperson:deliveryperson,
			sex:sex,
			idtype:idtype,
			idnum:11
		},
		success:function(data){
			if(data=="success"){
				alert("添加成功！");
				parent.doSearch();
				parent.$('#dd').window('close');
			}
			if(data=="fail"){
				alert("添加失败！");
			}
			if(data=="error"){
				alert("系统异常!");
			}
		}
		
	});
}

function closeform(){
	parent.$('#dd').window('close');
}

function doClick(){
	var temp = $("#add").val();
	if(temp=="查询"){
		doSearch();
	}else if(temp=="添加"){
		existOutboundId();
	}
}

var idNum =/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;//验证身份证
function validate(obj){
	if($(obj).val()=="")
		 return;
	 if(!idNum.test($(obj).val())){
		 alert("请输入正确的身份证号码！");
		 $(obj).val("");
	 }
}


</script>
	</head>

	<body>
		<div class="warning">
		<div class="content">
		温馨提示 :出库添加
		<br>
		<div class="required" style="color: red">提货类型为自提时需要提货单密码，在线配送是不需要提货单密码！  </div>
	</div>
	</div>
		<form>
						<div class="div_cxtj">
							<div class="div_cxtjL"></div>
							<div class="div_cxtjC">
								添加出库单
							</div>
							<div class="div_cxtjR"></div>
						</div>
						<div style="clear: both;"></div>

							<table class="table2_style" align="center">
								<tr>
									<td style="width:15%" align="right">
										<span class="required">*</span>
										提货单号：
									</td>
									<td align="left">
										<input  id="deliveryorderId" name="" value="" class="easyui-validatebox textbox"   style="width:160px;height:20px;margin-left:2px"/> 
									</td>
									<td align="right" style="width:92px;">		
										提货单密码：
									</td>
									<td align="left">
										<input id="pickupPassword" name="" value="" class="easyui-validatebox textbox"   style="width:160px;height:20px;margin-left:2px"/> 
									</td>
								</tr>
							</table>
							<table id="deliveryInfo" class="table2_style" style="border-top:0;display:none" align="center">
										<tr>
											<td align="right">
											商品代码：
											</td>
											<td align="left">
											<input readonly="readonly" id="commodityid"  style="width:160px;height:20px;">
											</td>
											<td align="right">
											商品名称：
											</td>
											<td align="left">
											<input readonly="readonly" id="commodityname" style="width:160px;height:20px;">
											</td>
										</tr>
										<tr>
											<td align="right">
											交易商名称：
											</td>
											<td align="left">
											<input readonly="readonly" id="dealerName" style="width:160px;height:20px;margin-right:12px">
											</td>
											<td align="right">
											仓库名称：
											</td>
											<td align="left">
											<input readonly="readonly" id="warehouseName" style="width:160px;height:20px;">
											</td>
										</tr>
										<tr>
											<td align="right">
											提货方式：
											</td>
											<td align="left">
											<input readonly="readonly" id="deliveryMethod" style="width:160px;height:20px;">
											</td>
											<td align="right">
											提货日期：
											</td>
											<td align="left">
											<input readonly="readonly" id="deliveryDate" style="width:160px;height:20px;">
											</td>
										</tr>
										<tr>
											<td align="right">
											交割数量：
											</td>
											<td align="left">
											<input readonly="readonly" id="deliveryQuatity" style="width:160px;height:20px;">
											</td>
											<td align="right">
											审批状态：
											</td>
											<td align="left">
											<input readonly="readonly" id="approvalStatus"  style="width:160px;height:20px;">
											</td>
										</tr>
										
										<tr>
											<td align="right">
											提货人：
											</td>
											<td align="left">
											<input id="deliveryperson" readonly="readonly" style="width:160px;height:20px;">
											<span class="bj">*</span>
											</td>
											<td align="right">
											性别：
											</td>
											<td align="left">
											<input id="sex" readonly="readonly" style="width:160px;height:20px;">
<!-- 											<select style="width:160px;height:20px;" id="sex"> -->
<!-- 												<option value="男">男</option> -->
<!-- 												<option value="女">女</option> -->
<!-- 											</select> -->
											<span class="bj">*</span>
											</td>
										</tr>
										
										<tr>
											<td align="right">
											证件类型：
											</td>
											<td align="left">
											<input readonly="readonly" id="idtype"  style="width:160px;height:20px;" value="">
											</td>
											<td align="right">
											证件号码：
											</td>
											<td align="left">
											<input onblur="validate(this)" readonly="readonly" id="idnum" style="width:160px;height:20px;">
											<span class="bj">*</span>
											</td>
										</tr>
							</table>
							<table id="psInfo" class="table2_style" style="border-top:0;;display:none" align="center">
									<tr> 
										<td style="width:15%" align="right">快递费用：</td>
										<td align="left">
										<label id="cost"></label>
										</td>
									</tr>
									<tr>
										<td align="right">收 货 人：</td>
										<td align="left">
										<label id="receiver"></label>
										</td>
									</tr>
									<tr>
										<td align="right">电话：</td>
										<td align="left">
										<label id="tel"></label>
										</td>
									</tr>
									<tr>
										<td align="right">地址：</td>
										<td align="left">
										<label id="address"></label>
										</td>
									</tr>
							</table>
							<table class="table2_style" style="border-top:0;" align="center">
								<tr>
									<td align="center">
										<input type="button" class="btn_sec" id="add" onclick="doClick()" value="查询">
				   						<input type="button" class="btn_sec" id="close" onclick="closeform()" value="关闭">
									</td>
								</tr>
							</table>

				
						
			
		</form>	
	</body>
</html>
