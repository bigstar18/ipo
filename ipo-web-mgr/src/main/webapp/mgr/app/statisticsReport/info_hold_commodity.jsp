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
									<h2>商品交易商持有报表</h2>
								</center>
								<br/> <br/> <br/>  
								<center class="reportHead">
									<h3>${time }</h3>
								</center>
								<br/> <br/> 
								<c:forEach var="settle" items="${holdList}" varStatus="status">
								<br><br> 
									<table width="800px" align="center">
										<tr>
											<td class="reportLeft">商品代码:${settle.list }</td>
											<td class="reportLeft">商品名称:${settle.broker }</td>
										</tr>
									</table>
									<br/>
									<div class="table-c">
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="900px">
											<tr>
												<td class="td_reportMdHead" align="center">序号</td>
												<td class="td_reportMdHead" align="center">交易商代码</td>
												<td class="td_reportMdHead" align="center">交易商名称</td>
												<td class="td_reportMdHead" align="center">持有数量</td>
												<td class="td_reportMdHead" align="center">持有均价</td>
												<td class="td_reportMdHead" align="center">持有盈亏</td>
											</tr>
											<c:forEach var="holdInfo" items="${settle.holdInfo}" varStatus="status">
												<tr>
													<td class="td_reportMdHead" align="center">${status.count}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.firmid}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.firmName}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.holdqty}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.evenprice}</td>
													<td class="td_reportMdHead" align="center">${holdInfo.holdinggainsandlosses} </td>
												</tr>
											</c:forEach>
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