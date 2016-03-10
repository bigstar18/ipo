<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
									<h2>商品发行申购报表</h2>
								</center>
								<br/> <br/> <br/>  
								<center class="reportHead">
									<h3>${time }</h3>
								</center>
								<br/> <br/> 
								<c:forEach var="settle" items="${settles}" varStatus="status">
								<br><br> 
									<table width="800px" align="center">
										<tr>
											<td class="reportLeft">商品代码:${settle.commodity.commodityid }</td>
											<td class="reportLeft">商品名称:${settle.commodity.commodityname }</td>
											<td class="reportLeft">发行日期:<fmt:formatDate value="${settle.commodity.starttime}" pattern="yyyy-MM-dd"/></td>
											<td class="reportLeft">发行价格:${settle.commodity.price }</td>
										</tr>
									</table>
									<br/>
									<div class="table-c">
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="900px">
											<tr>
												<td class="td_reportMdHead" align="center">序号</td>
												<td class="td_reportMdHead" align="center">交易商代码</td>
												<td class="td_reportMdHead" align="center">交易商名称</td>
												<td class="td_reportMdHead" align="center">申购数量</td>
												<td class="td_reportMdHead" align="center">申购金额</td>
												<td class="td_reportMdHead" align="center">发行量</td>
												<td class="td_reportMdHead" align="center">申购倍率(%)</td>
											</tr>
											<c:forEach var="purchase" items="${settle.purchase}" varStatus="status">
												<tr>
													<td class="td_reportMdHead" align="center">${status.count}</td>
													<td class="td_reportMdHead" align="center">${purchase.firmId}</td>
													<td class="td_reportMdHead" align="center">${purchase.firmName}</td>
													<td class="td_reportMdHead" align="center">${purchase.count}</td>
													<td class="td_reportMdHead" align="center">${purchase.cost}</td>
													<td class="td_reportMdHead" align="center">${purchase.circulation} </td>
													<td class="td_reportMdHead" align="center">${purchase.rate}</td>
												</tr>
											</c:forEach>
												<tr>
													<td class="td_reportMdHead" align="center">合计</td>
													<td class="td_reportMdHead" align="center"> </td>
													<td class="td_reportMdHead" align="center"> </td>
													<td class="td_reportMdHead" align="center">${settle.purcount} </td>
													<td class="td_reportMdHead" align="center">${settle.purcost} </td>
													<td class="td_reportMdHead" align="center">${settle.purcir} </td>
													<td class="td_reportMdHead" align="center">${settle.purrate} </td>
												</tr>
										</table>
									</div>
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