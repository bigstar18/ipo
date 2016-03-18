<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>交易商结算表</title>
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"  href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"  href="${ctxStatic}/jquery-easyui/themes/icon.css">
<link href="../skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
<%-- $(document).ready(function(){
	var time = getDateNow();
	$.ajax({
		type: "GET",
        url: "<%=request.getContextPath()%>/BillingReportController/getInfo",
        data:{date:time},
        error:function(date){
        	alert("页面加载失败，请稍后重试");
        }
	})
	}); --%>
	
function queryData(){
	var time = $("#queryTime").datebox("getValue");
	document.location.href="<%=request.getContextPath()%>/BillingReportController/fundsforward?date="+time;
	<%-- $.ajax({
		type: "GET",
        url: "<%=request.getContextPath()%>/BillingReportController/getInfo",
        data:{date:time},
        dataType:'json',
        success:function(date){
        	
        },
        error:function(date){
        	alert("页面加载失败，请稍后重试");
        }
	}) --%>
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
    
//获取当前日期
function getDateNow(){
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
    return currentdate;
} 
</script>

<style type="text/css">
.td_reportMdHead_Right{
	width:200px;
}

.td_reportMd1{
	width: 200px;
	
}
</style>

</head>
<body>
	<div class="main">
		<div class="msg">
			您当前的位置：<span>报表>交易商结算表</span>
		</div>
		<div class="warning">
			<div class="title font_orange_14b">温馨提示 :</div>
			<div class="content">在此可以查询您的结算信息报表</div>
		</div>
	<div>
	<br><br>
	<div class="sort">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="right">查询日期：</td>
				<td width="600px">
				<input id="queryTime" class="easyui-datebox" style="width:150px" editable="false" data-options="formatter:myformatter,parser:myparser">
				 
				</td>
				<td align="left"><input type="button" value="查询" onclick="queryData()"/></td>
			</tr>
		</table>
	</div>
	<br>
	<table align="center" width="600px" border="0">
		<tr>
			<td>
				<div id=ediv>
					<table align="center" width="1000px" height="400px" border="0"
						id="tableList">
						<tr>
							<td valign="top">
								<center class="reportHead">
									<h2>资金结算信息</h2>
								</center> <br />
								<div class="table-c">
									<table width="1000px" border="1" cellspacing="0" cellpadding="0"
										align="center">
										<tr>
											<td class="td_reportMdHead_Right" align="center">上日资金余额（元）:</td>
											<td class="td_reportMd1" align="center">${funds.lastBalance}</td>
											<td class="td_reportMdHead_Right" align="center">（+）上日保证金:</td>
											<td class="td_reportRd1" align="center">${funds.lastSettleMargin}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">（-）当日保证金:</td>
											<td class="td_reportMd1" align="center">${funds.settleMargin}</td>
											<td class="td_reportMdHead_Right" align="center">（+）货款：</td>
											<td class="td_reportRd1" align="center">${funds.payment}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">（+）入金:</td>
											<td class="td_reportMd1" align="center">${funds.deposit}</td>
											<td class="td_reportMdHead_Right" align="center">（-）出金:</td>
											<td class="td_reportRd1" align="center">${funds.withdrawal}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">（+）发售当日其他项:</td>
											<td class="td_reportMd1" align="center">${funds.otherSale}</td>
											<td class="td_reportMdHead_Right" align="center">（-）发售交货费用:</td>
											<td class="td_reportRd1" align="center">${funds.saleDelivery}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">（-）发行服务费:</td>
											<td class="td_reportMd1" align="center">${funds.issuedServiceFee}</td>
											<td class="td_reportMdHead_Right" align="center">（-）申购金额:</td>
											<td class="td_reportRd1" align="center">${funds.purchaseMoney}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">（-）交易费用:</td>
											<td class="td_reportMd1" align="center">${funds.transactionCost}</td>
											<td class="td_reportMdHead_Right" align="center">（+）其他交易系统:</td>
											<td class="td_reportRd1" align="center">${funds.otherSystem}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">当日资金余额:</td>
											<td class="td_reportMd1" align="center">${funds.balance}</td>
											<td class="td_reportMdHead_Right" align="center">预付货款:</td>
											<td class="td_reportRd1" align="center">${funds.advancePayment}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">历史申购金额:</td>
											<td class="td_reportMd1" align="center">${funds.hisPurchaseMoney}</td>
											<td class="td_reportMdHead_Right" align="center">当日持有市值:</td>
											<td class="td_reportRd1" align="center">${funds.marketValue}</td>
										</tr>
										<tr>
											<td class="td_reportMdHead_Right" align="center">当日交易商权益:</td>
											<td class="td_reportMd1" align="center">${funds.tradeEquity}</td>
										</tr>
									</table>
								</div> <br>
								<center class="reportHead">
									<b>发行申购明细表</b>
								</center> <br>
								<div class="table-c">
									<table border="1" cellspacing="0" cellpadding="0"
										align="center" width="1000px">
										<tr>
											<td class="td_reportMdHead">序号</td>
											<td class="td_reportMdHead">商品代码</td>
											<td class="td_reportMdHead">商品名称</td>
											<td class="td_reportMdHead">发行价格</td>
											<td class="td_reportMdHead">申购时间</td>
											<td class="td_reportMdHead">申购数量</td>
											<td class="td_reportMdHead">申购金额</td>
											<td class="td_reportMdHead">发行服务费</td>
											<td class="td_reportMdHead">退还申购金额</td>
											<td class="td_reportRdHead">退还发行服务费</td>
										</tr>
										<c:forEach  items="${rList}" var = "Relea" varStatus="status">
											<tr>
												<td class="td_reportMdHead" align="center">${status.count}</td>
												<td class="td_reportMdHead" align="center">${Relea.commodityid}</td>
												<td class="td_reportMdHead" align="center">${Relea.commodityname}</td>
												<td class="td_reportMdHead" align="center">${Relea.issueprice}</td>
												<td class="td_reportMdHead" align="center"><fmt:formatDate value="${Relea.purchasetime }" pattern="yyyy-MM-dd"/> </td>
												<td class="td_reportMdHead" align="center">${Relea.purchasequantity}</td>
												<td class="td_reportMdHead" align="center">${Relea.purchaseamount}</td>
												<td class="td_reportRdHead" align="center">${Relea.issuancefee}</td>
												<td class="td_reportRdHead" align="center">${Relea.refundablepurchaseamount}</td>
												<td class="td_reportRdHead" align="center">${Relea.refundableservicefee}</td>
											</tr>
										</c:forEach>
										
									</table>
								</div> <br>
								
								<center class="reportHead">
									<b>商品持有表</b>
								</center> <br>
								<div class="table-c">
									<table border="1" cellspacing="0" cellpadding="0"
										align="center" width="1000px">
										<tr>
											<td class="td_reportMdHead" align="center">序号</td>
											<td class="td_reportMdHead" align="center">商品代码</td>
											<td class="td_reportMdHead" align="center">商品名称</td>
											<td class="td_reportMdHead" align="center">持有数量</td>
											<td class="td_reportMdHead" align="center">冻结数量</td>
											<td class="td_reportMdHead" align="center">可用数量</td>
											<td class="td_reportMdHead" align="center">持有均价</td>
											<td class="td_reportRdHead" align="center">现价</td>
											<td class="td_reportRdHead" align="center">持有盈亏</td>
											<td class="td_reportRdHead" align="center">持有市值</td>
										</tr>
										<c:forEach items="${hList}" var="hold" varStatus="status">
											<tr>
												<td class="td_reportMdHead" align="center">${status.count}</td>
												<td class="td_reportMdHead" align="center">${hold.commodityid}</td>
												<td class="td_reportMdHead" align="center">${hold.commodityname}</td>
												<td class="td_reportMdHead" align="center">${hold.holdqty}</td>
												<td class="td_reportMdHead" align="center">${hold.frozenqty}</td>
												<td class="td_reportMdHead" align="center">${hold.quantityavailable}</td>
												<td class="td_reportMdHead" align="center">${hold.evenprice}</td>
												<td class="td_reportRdHead" align="center">${hold.price}</td>
												<td class="td_reportRdHead" align="center">${hold.holdinggainsandlosses}</td>
												<td class="td_reportRdHead" align="center">${hold.marketvalue}</td>
											</tr>
										</c:forEach>
										
									</table>
								</div> <br>

								<center class="reportHead">
									<b>商品注册/注销提货单表</b>
								</center> <br>
								<div class="table-c">
									<table border="1" cellspacing="0" cellpadding="0"
										align="center" width="1000px">
										<tr>
											<td class="td_reportMdHead" align="center">序号</td>
											<td class="td_reportMdHead" align="center">商品代码</td>
											<td class="td_reportMdHead" align="center">商品名称</td>
											<td class="td_reportMdHead" align="center">数量</td>
											<td class="td_reportMdHead" align="center">件数</td>
											<td class="td_reportMdHead" align="center">类型</td>
											<td class="td_reportMdHead" align="center">提货单手续费</td>
											<td class="td_reportRdHead" align="center">仓储费</td>
											<td class="td_reportRdHead" align="center">保险费</td>
											<td class="td_reportRdHead" align="center">托管费</td>
										</tr>
										<c:forEach items="${bList }" var="billfladInfo" varStatus="status">
											<tr>
												<td class="td_reportMdHead" align="center">${status.count}</td>
												<td class="td_reportMdHead" align="center">${billfladInfo.commodityid}</td>
												<td class="td_reportMdHead" align="center">${billfladInfo.commodityname}</td>
												<td class="td_reportMdHead" align="center">${billfladInfo.quantity}</td>
												<td class="td_reportMdHead" align="center">${billfladInfo.counts}</td>
												<td class="td_reportMdHead" align="center">${billfladInfo.deliverytype}</td>
												<td class="td_reportMdHead" align="center">${billfladInfo.billofladingfee}</td>
												<td class="td_reportRdHead" align="center">${billfladInfo.warehousingfee}</td>
												<td class="td_reportRdHead" align="center">${billfladInfo.insurance}</td>
												<td class="td_reportRdHead" align="center">${billfladInfo.trusteefee}</td>
											</tr>
										</c:forEach>
									</table>
								</div> <br>

								<center class="reportHead">
									<b>商品过户、提货表</b>
								</center> <br>
								<div class="table-c">
									<table border="1" cellspacing="0" cellpadding="0"
										align="center" width="1000px">
										<tr>
											<td class="td_reportMdHead" align="center">序号</td>
											<td class="td_reportMdHead" align="center">商品代码</td>
											<td class="td_reportMdHead" align="center">商品名称</td>
											<td class="td_reportMdHead" align="center">数量</td>
											<td class="td_reportMdHead" align="center">件数</td>
											<td class="td_reportMdHead" align="center">类型</td>
											<td class="td_reportMdHead" align="center">过户费</td>
											<td class="td_reportRdHead" align="center">运费</td>
										</tr>
										<c:forEach items="${dList }" var="deliveryInfo" varStatus="status">
											<tr>
												<td class="td_reportMdHead" align="center">${status.count}</td>
												<td class="td_reportMdHead" align="center">${deliveryInfo.commodityid}</td>
												<td class="td_reportMdHead" align="center">${deliveryInfo.commodityname}</td>
												<td class="td_reportMdHead" align="center">${deliveryInfo.quantity}</td>
												<td class="td_reportMdHead" align="center">${deliveryInfo.counts}</td>
												<td class="td_reportMdHead" align="center">${deliveryInfo.deliverytype}</td>
												<td class="td_reportMdHead" align="center">${deliveryInfo.transferfee}</td>
												<td class="td_reportRdHead" align="center">${deliveryInfo.postage}</td>
											</tr>
										</c:forEach>
									</table>
								</div> <br>
							</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>

</html>
