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
									<h2>经纪会员注册/注销提货单经纪收入报表</h2>
								</center>
								<br/> <br/> <br/> <br/>
								<center class="reportHead">
									<h3>${today }</h3>
								</center>
								<br/> <br/> <br/> 
								<c:forEach var="settle" items="${settles}" varStatus="status">
								<br><br><br><br>
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
										<table border="1" cellspacing="0" cellpadding="0" align="center" width="900px">
											<tr>
												<td class="td_reportMdHead" align="center">序号</td>
												<td class="td_reportMdHead" align="center">交易商代码</td>
												<td class="td_reportMdHead" align="center">交易商名称</td>
												<td class="td_reportMdHead" align="center">商品代码</td>
												<td class="td_reportMdHead" align="center">商品名称</td>
												<td class="td_reportMdHead" align="center">类型</td>
												<td class="td_reportMdHead" align="center">数量</td>
												<td class="td_reportMdHead" align="center">件数</td>
												<td class="td_reportMdHead" align="center">提货单金额</td>
												<td class="td_reportMdHead" align="center">提货单经纪收入</td>
												<td class="td_reportMdHead" align="center">直属居间商代码</td>
												<td class="td_reportRdHead" align="center">直属居间商名称</td>
											</tr>
											<c:forEach var="publish" items="${result}" varStatus="status">
												<tr>
													<td class="td_reportMdHead" align="center">${status.count}</td>
													<td class="td_reportMdHead" align="center">${publish.commodityid}</td>
													<td class="td_reportMdHead" align="center">${publish.commodityname}</td>
													<td class="td_reportMdHead" align="center">${publish.price}</td>
													<td class="td_reportMdHead" align="center">${publish.loan==null?0:publish.loan/publish.price }</td>
													<td class="td_reportMdHead" align="center">${publish.loan==null?0:publish.loan}</td>
													<td class="td_reportMdHead" align="center">${publish.handing==null?0:publish.handing}</td>
													<td class="td_reportRdHead" align="center">${publish.loan-publish.handing}</td>
													<td class="td_reportRdHead" align="center">${publish.loan-publish.handing}</td>
													<td class="td_reportRdHead" align="center">${publish.loan-publish.handing}</td>
													<td class="td_reportRdHead" align="center">${publish.loan-publish.handing}</td>
													<td class="td_reportRdHead" align="center">${publish.loan-publish.handing}</td>
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