<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>报表展示</title>
</head>
<body>
	<table align="center" width="600px" border="0">
		<tr>
			<td>
				<table align="right" width="10%" border="0">
					<tr>
						<td align="right">
							<div align="right" id="butDivModUp" name="butDivModUp"
								class="Noprint">
								<input type="submit" onclick="javascript:window.print();"class="button" value="打印">  
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<div id=ediv>
					<table align="center" height="400px" width="800px" border="0" id="tableList">
						<tr>
							<td valign="top">
								<center class="reportHead">
									<h2>经纪会员结算报表</h2>
								</center>
								<br/> <br/> <br/> <br/>
								<center class="reportHead">
									<h3>${today }</h3>
								</center>
								<br/> <br/> <br/> 
								<c:forEach var="settle" items="${settles}" varStatus="status">
								<br><br>
									<table width="800px" align="center">
										<tr>
											<td class="reportLeft">会员代码:${settle.broker.brokerid }</td>
											<td class="reportLeft">会员名称:${settle.broker.name }</td>
											<td class="reportLeft">日期:${today }</td>
											<td class="reportLeft">交易商代码:${settle.broker.firmid }</td>
										</tr>
									</table>
									<br/>
									<div class="table-c">
										<table width="800px" border="1" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td class="td_reportMdHead_Right">上日资金余额：</td>
												<td class="td_reportMd1"></td>
												<td class="td_reportMdHead_Right">(+)上日保证金：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">(-)当日保证金：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">(+)货款：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">(-)发行服务费：</td>
												<td class="td_reportRd1"></td>
											</tr>
											<tr>
												<td class="td_reportMdHead_Right">(+)入金：</td>
												<td class="td_reportMd1"></td>
												<td class="td_reportMdHead_Right">(-)出金：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">(+)发售当日其他项：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">(-)发售交货费用：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">(-)交易费用：</td>
												<td class="td_reportRd1"></td>
											</tr>
											<tr>
												<td class="td_reportMdHead_Right">(-)申购金额：</td>
												<td class="td_reportMd1"></td>
												<td class="td_reportMdHead_Right">(+)经纪收入：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">(+)其他交易系统：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">当日资金余额：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">预付货款：</td>
												<td class="td_reportRd1"></td>
											</tr>
											<tr>
												<td class="td_reportMdHead_Right">历史申购金额：</td>
												<td class="td_reportMd1"></td>
												<td class="td_reportMdHead_Right">当日持有市值：</td>
												<td class="td_reportRd1"></td>
												<td class="td_reportMdHead_Right">当日交易商权益：</td>
												<td class="td_reportRd1"></td>
											</tr>
										</table>
									</div>
									<br><br>
									<center class="reportHead"> <b>交易明细表</b> </center>
									<br>
									<div class="table-c">
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="900px">
											<tr>
												<td class="td_reportMdHead">序号</td>
												<td class="td_reportMdHead">成交单号</td>
												<td class="td_reportMdHead">成交时间</td>
												<td class="td_reportMdHead">商品代码</td>
												<td class="td_reportMdHead">商品名称</td>
												<td class="td_reportMdHead">成交价格</td>
												<td class="td_reportMdHead">成交数量</td>
												<td class="td_reportMdHead">买/卖</td>
												<td class="td_reportMdHead">买入金额</td>
												<td class="td_reportRdHead">卖出金额</td>
												<td class="td_reportRdHead">盈亏</td>
												<td class="td_reportRdHead">交易手续费</td>
												<td class="td_reportMdHead">保险费</td>
												<td class="td_reportMdHead">仓储费</td>
												<td class="td_reportMdHead">托管费</td>
											</tr>
											<%-- <c:forEach var="publish" items="${result}" varStatus="status">
												<tr>
													<td class="td_reportMdHead">${status.count}</td>
													<td class="td_reportMdHead">${publish.commodityid}</td>
													<td class="td_reportMdHead">${publish.commodityname}</td>
													<td class="td_reportMdHead">${publish.price}</td>
													<td class="td_reportMdHead">${publish.loan==null?0:publish.loan/publish.price }</td>
													<td class="td_reportMdHead">${publish.loan==null?0:publish.loan}</td>
													<td class="td_reportMdHead">${publish.handing==null?0:publish.handing}</td>
													<td class="td_reportRdHead">${publish.loan-publish.handing}</td>
													<td class="td_reportRdHead">${publish.loan-publish.handing}</td>
													<td class="td_reportRdHead">${publish.loan-publish.handing}</td>
												</tr>
											</c:forEach> --%>
										</table>
									</div>
									<br><br>
									<center class="reportHead"> <b>发行申购明细表</b> </center>
									<br>
									<div class="table-c">
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="800px">
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
											<c:forEach var="releaInfo" items="${settle.releaInfo}" varStatus="status">
												<tr>
													<td class="td_reportMdHead" align="center">${status.count}</td>
													<td class="td_reportMdHead" align="center">${releaInfo.commodityid}</td>
													<td class="td_reportMdHead" align="center">${releaInfo.commodityname}</td>
													<td class="td_reportMdHead" align="center">${releaInfo.issueprice}</td>
													<td class="td_reportMdHead" align="center">${releaInfo.purchasetime }</td>
													<td class="td_reportMdHead" align="center">${releaInfo.purchasequantity}</td>
													<td class="td_reportMdHead" align="center">${releaInfo.purchaseamount}</td>
													<td class="td_reportRdHead" align="center">${releaInfo.issuancefee}</td>
													<td class="td_reportRdHead" align="center">${releaInfo.refundablepurchaseamount}</td>
													<td class="td_reportRdHead" align="center">${releaInfo.refundableservicefee}</td>
												</tr>
											</c:forEach>
										</table>
									</div>
									<br><br>
									<center class="reportHead">
										<b>商品持有表</b>
									</center>
									<br>
									<div class="table-c">
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="800px">
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
											<c:forEach var="holdInfo" items="${settle.holdInfo}" varStatus="status">
												<tr>
													<td class="td_reportMdHead" align="center">${status.count}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.commodityid}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.commodityname}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.holdqty}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.frozenqty}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.quantityavailable}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.evenprice}</td>
													<td class="td_reportRdHead" align="center">${holdInfo.price}</td>
													<td class="td_reportRdHead" align="center">${holdInfo.holdinggainsandlosses}</td>
													<td class="td_reportRdHead" align="center">${holdInfo.marketvalue}</td>
												</tr>
											</c:forEach>
										</table>
									</div>
									<br><br>
									
									<center class="reportHead">
										<b>商品注册/注销提货单表</b>
									</center>
									<br>
									<div class="table-c">
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="800px">
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
											<c:forEach var="billfladInfo" items="${settle.billfladInfo}" varStatus="status">
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
									</div>
									<br><br>
									
									<center class="reportHead">
										<b>商品过户、提货表</b>
									</center>
									<br>
									<div class="table-c">
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="800px">
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
											<c:forEach var="deliveryInfo" items="${settle.deliveryInfo}" varStatus="status">
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
									</div>
									<br><br>
									<center class="reportHead">--------------------------------------------------------------------</center>
									<br><br><br>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<table align="right" width="10%" border="0">
					<tr>
						<td align="right">
							<div align="right" id="butDivModDown" name="butDivModDown" class="Noprint">
								<input type="submit" onclick="javascript:window.print();" class="button" value="打印">
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	
</script>
</html>