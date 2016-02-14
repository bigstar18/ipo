<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>发行会员结算报表</title>
<script type="text/javascript">
function returnToPage(){
	document.location.href= '<%=request.getContextPath()%>/PublisherController/settleReports';
}
</script>
</head>
<body>
	<table align="center" width="600px" border="0">
		<tr>
			<td>
				<table align="right" width="10%" border="0">
					<tr>
					<td align="right">
						<div align="right" id="butDivModUp" name="butDivModUp" class="Noprint">
		     		     <input type="submit" onclick="javascript:window.print();" class="button" value="打印"> 
		     		      <input type="button" onclick="returnToPage()" value="返回">
						</div>
					</td> 
					</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>
				<div id = ediv>
				<table align="center" height="400px" width="800px" border="0" id ="tableList">
					<tr>
						<td valign="top">
						    <center class="reportHead"><h2>发行会员结算报表</h2></center><br/>
							<br/>
							<br/>
    <br><center class="reportHead"><h3>${today }</h3></center><br>
    <br/>
    <br/>
    
    <c:forEach var="settle" items="${settles}" varStatus="status">
    
    
    
    
    
 
<br>
<br>	
<table width="800px" align="center" >
	<tr>
		<td class="reportLeft">会员代码:${settle.broker.brokerid }</td>
		<td class="reportLeft">会员名称:${settle.broker.name }</td>
		<td class="reportLeft">日期:${today }</td>
		<td class="reportLeft">交易商代码:${settle.broker.firmid }</td>
	</tr>

</table>
    
<br/>
<div class="table-c">
<table width="800px"  border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td class="td_reportMdHead_Right">上日资金余额：</td>
		<td class="td_reportMd1">${settle.balance.yesterdaybalance }</td>
		<td class="td_reportMdHead_Right">发行货款：</td>
		<td class="td_reportRd1">${settle.totalLoan }</td>		
	</tr>
	<tr>
		<td class="td_reportMdHead_Right">当日出入金：</td>
		<td class="td_reportMd1">0.00</td>
		<td class="td_reportMdHead_Right">当日资金余额</td>
		<td class="td_reportRd1">${settle.balance.todaybalance }</td>	
	</tr>
</table>
</div>
<br><center class="reportHead"><b>发行明细表</b></center><br>
<div class="table-c">
	<table  border="1" cellspacing="0" cellpadding="0" align="center" width="800px">
	<tr>
	<td class="td_reportMdHead">序号</td>
	<td class="td_reportMdHead">商品代码</td>
	<td class="td_reportMdHead">商品名称</td>
	<td class="td_reportMdHead">发行价格</td>
	<td class="td_reportMdHead">发行认购数量</td>
	<td class="td_reportMdHead">发行认购金额</td>
	<td class="td_reportMdHead">发行服务费</td>
	<td class="td_reportRdHead">发行应得收入</td>
	</tr>
		 <c:forEach var="publish" items="${settle.list}" varStatus="status">
		 <tr>
		 <td class="td_reportMdHead">${status.count}</td>
	     <td class="td_reportMdHead">${publish.commodityid}</td>
	     <td class="td_reportMdHead">${publish.commodityname}</td>
	     <td class="td_reportMdHead">${publish.price}</td>
	     <td class="td_reportMdHead">${publish.loan==null?0:publish.loan/publish.price }</td>
	     <td class="td_reportMdHead">${publish.loan==null?0:publish.loan}</td>
	     <td class="td_reportMdHead">${publish.handing==null?0:publish.handing}</td>
	     <td class="td_reportRdHead">${publish.loan-publish.handing}</td>
		 </tr>
          </c:forEach>	
	</table>
	</div>
	<br>
<br>
	<center class="reportHead">--------------------------------------------------------</center>
<br>		
<br>
<br>

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

</html>
