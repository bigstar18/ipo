<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>

<html>
<head>
<title>查询条件</title>
<script type="text/javascript">
	


	function setFirmid(value){
		$("#firm").val(value);
	}
	
	<%-- function query(){
		 var iWidth = 800; //弹出窗口的宽度;
	      var iHeight = 700; //弹出窗口的高度;
	      var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
	      var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
	      window.open("<%=request.getContextPath()%>/brokerageReportController/brokerinfoforward, 
	    		  "报表页面", 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',
	    		  innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',
	    		  toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
	} --%>
	
	
</script>
</head>
<body>
	<form id="query" name="query">
		<table border="0" align="center" >
			<tr>
				<td>
					<fieldset>
						<legend>经纪会员结算报表</legend>
						<table border="0" align="center" cellpadding="5" cellspacing="5" class="common">
							<tr>
								<td align="center" colspan="2" style="color: red">(填空为查询全部)</td>
							</tr>
							<!-- <tr>
								<td align="right" style="font-size: 15px" width="50%"></td>
								<td align="left" width="60%">
									<span class="required"></span>
								</td>
							</tr> -->
							<tr>
								<td align="right">经纪会员账号：</td>
								<td>
									<input id="firm" name="firm" type="text" size=8 maxlength=8 />
								  
									<select name="userid" style="width:100px" onchange="setFirmid(value)">
										<option value="">请选择</option>
										<c:forEach items="${firmid}" var="a">
											<option value="${a}">${a}</option>
										</c:forEach>
									</select>
									<span class="req">*</span>
								</td>
							</tr> 
							<tr>
								<td align="left">查询日期：</td>
								<td>
									<input style="width: 100px" id="payables" name="payables" class="esayui-datebox" data-options="required:true,missingMessage:'必填'"/>
									<span class="required">*</span>
								</td>
							</tr>
						</table>
						<table border="0" align="center" cellpadding="5" cellspacing="5" class="common">
							<tr>
								<td>
									<button class="btn_sec" id="add" action="/issue/queryreport/brokerEndTradeQuery.action" onclick="return query('pdf')">查看</button>

	     						</td>
	     						<td>
	     							<button class="btn_sec1" id="saveExcel" action="/issue/queryreport/brokerEndTradeQueryExcel.action" onclick="return query('excel')">保存为excel</button>

	     						</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>