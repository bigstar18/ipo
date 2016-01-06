<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>
<%@page import="java.lang.String"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%String dealerId =((UserManageVO)session.getAttribute("CurrentUser")).getUserID();%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
	<link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		.mbodytop{padding:5px;border-top:1px solid #95b8e7;border-left:1px solid #95b8e7;border-right:1px solid #95b8e7;background:#eff5ff}
		input{border:1px solid #95b8e7;border-radius:5px;height:20px;padding-left:4px;width:160px}
		b{color:red;font-size:15px}
		td{white-space:normal}
		.mbody{border:1px solid #95b8e7;background:#f4f4f4}
		.deliveryInfo{display:none}
		#transfer{width:120px;height:25px;border-radius:3px;background:#fff}
	</style>
	  <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.0.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="msg">
		  您当前的位置：<span>提单过户</span>
		</div>
		<div class="warning">
		  <div class="title font_orange_14b">温馨提示 :</div>
		  <div class="content">输入提货单号和密码，点击搜索，之后点击过户即可完成提单过户。
		  </div>
		</div>
		<div class="mbodytop">
		  <div class="panel-title panel-with-icon">提单过户</div>
		</div>
		<div class="mbody">
			<table border="0" width="550px" align="center" style="margin-top: 25px;">
				<tr>
					<td align="right">
						提货单号：
					</td>
					<td align="left">
						<input name="" value="" id="deliveryorderId" />
					</td>
					<td align="right">
						提货单密码：
					</td>
					<td align="left">
						<input name="" value="" id="pickupPassword" />
					</td>
				</tr>
				<tr  class="deliveryInfo">
					<td align="right">
						商品代码：
					</td>
					<td align="left">
						<input name="" value="" id="commodityid"/>
					</td>
					<td align="right">
						商品名称：
					</td>
					<td align="left">
						<input name="" value="" id="commodityname"/>
					</td>
				</tr>
				<tr  class="deliveryInfo">
					<td align="right">
						交易商名称：
					</td>
					<td align="left">
						<input name="" value="" id="dealerName"/>
					</td>
					<td align="right">
						仓库名称：
					</td>
					<td align="left">
						<input name="" value="" id="warehouseName"/>
					</td>
				</tr>
				<tr  class="deliveryInfo">
					<td align="right">
						提货方式：
					</td>
					<td align="left">
						<input name="" value="" id="deliveryMethod"/>
					</td>
					<td align="right">
						提货日期：
					</td>
					<td align="left">
						<input name="" value="" id="deliveryDate"/>
					</td>
				</tr>
				<tr  class="deliveryInfo">
					<td align="right">
						交割数量：
					</td>
					<td align="left">
						<input name="" value="" id="deliveryQuatity"/>
					</td>
					<td align="right">
						审批状态：
					</td>
					<td align="left">
						<input name="" value="" id="approvalStatus"/>
					</td>
				</tr>
				<tr  class="deliveryInfo">
					<td align="right">
						快递费用：
					</td>
					<td align="left">
						<input name="" value="" id="cost"/>
					</td>
					<td align="right">
						收货人：
					</td>
					<td align="left">
						<input name="" value="" id="receiver"/>
					</td>
				</tr>
			</table>
			<table border="0" width="350px" align="center">
				<tr  class="deliveryInfo">
					<td align="right">
						电话：
					</td>
					<td align="left">
						<input name="" value="" style="width: 290px;" id="tel"/>
					</td>
				</tr>
				<tr  class="deliveryInfo">
					<td align="right">
						地址：
					</td>
					<td align="left">
						<input name="" value="" style="width: 290px;" id="address"/>
					</td>
				</tr>
			</table>
			<table border="0" width="350px" align="center" style="margin-bottom: 10px;">
				<tr>
					<td align="center">
						<input type="button" onclick="doClick()" value="查询"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function doClick(){
			var temp = $("#add").val();
			if(temp=="查询"){
				doSearch();
			}else if(temp=="提单过户"){
				doSure();
			}
		}
		function doSearch(){
			var deliveryorderId = $("#deliveryorderId").val();
			var pickupPassword = $("#pickupPassword").val();
			$.ajax({
				type:"GET",
				// url:"<%=request.getContextPath()%>/OutBoundController/getDeliveryInfo?randnum="+Math.floor(Math.random()*1000000),
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
						$("#warehouseName").val(data.warehouseName);
						$("#deliveryMethod").val(data.deliveryMethod);
						$("#deliveryDate").val(data.deliveryDate.substr(0,10));
						$("#deliveryQuatity").val(data.deliveryQuatity);
						switch(data.approvalStatus){
						case 1:
							$("#approvalStatus").val("申请");
							break;
						case 2:
							$("#approvalStatus").val("市场通过");
							$("#add").val("提单过户");
							break;
						case 3:
							$("#approvalStatus").val("市场驳回");
							break;
						case 4:
							$("#approvalStatus").val("仓库通过");
							break;
						case 5:
							$("#approvalStatus").val("仓库驳回");
							break;
						case 6:
							$("#approvalStatus").val("已确认");
							break;
						case 7:
							$("#approvalStatus").val("已废除");
							break;
						case 8:
							$("#approvalStatus").val("已设置配置费用");
							break;
						case 9:
							$("#approvalStatus").val("已出库");
							break;
						case 10:
							$("#approvalStatus").val("已收货");
							break;
						}

						$("#cost").val(data.cost);
						$("#receiver").val(data.receiver);
						$("#tel").val(data.tel);
						$("#address").val(data.address);


					}else if(data.commodityId==null){
						$(".deliveryInfo").hide();
						alert("提货单不存在！");
					}
				},
				error:function(data){
					alert("系统异常，请稍后再试");
				}
			});
		}
		function doSure(){
			var deliveryorderId = $("#deliveryorderId").val();
			$.ajax({
				type:"POST",
				// url:"<%=request.getContextPath()%>/OutBoundController/addOutBoundOrder",
				data:{
					deliveryorderid:deliveryorderId
				},
				success:function(data){
					if(data=="success"){
						alert("提单过户成功！");
					}
					if(data=="fail"){
						alert("提单过户失败！");
					}
					if(data=="error"){
						alert("系统异常!请稍后再试");
					}
				},
				error:function(data){
					alert("系统异常!请稍后再试");
				}
			});
		}
	</script>
</body>
</html>