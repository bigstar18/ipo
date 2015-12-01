<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title></title>
<script src="<%=request.getContextPath()%>/static/ipo/systemManager.js" type="text/javascript"></script>
</head>
<body leftmargin="0" topmargin="0" onkeypress="keyEnter(event.keyCode);">
	<table width="550" border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td height="50">&nbsp;</td>
		</tr>
		<tr>
			<td height="5">&nbsp;</td>
		</tr>
		<tr>
			<td>
				<div class="div_cxtj">
					<div class="div_cxtjL"></div>
					<div class="div_cxtjC">交易状态管理</div>
					<div class="div_cxtjR"></div>
				</div>
				<div style="clear: both;"></div>
				<div class="div_tj">
					<table border="0" cellpadding="0" cellspacing="0" class="table2_style" width="95%">
						<tr>
							<td>
								<div class="div2_top">
									<table width="65%" border="0" cellspacing="0" cellpadding="0" align="center">
										<tr>
											<td height="15" colspan="2">&nbsp;</td>
										</tr>
										<tr>
											<td height="3" colspan="2"></td>
										</tr>
										<tr>
											<td height="35" colspan="2"><span style="font-weight: bold; color: #f38243; font-size: 14px">&nbsp;&nbsp;当前时间：</span> <span id="systime" style="font-family: 宋体; font-size: 12px; font-weight: bold; color: #7d0c01;"></span>&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td colspan="2" align="left" height="35"><span style="font-weight: bold; color: #f38243; font-size: 14px">&nbsp;&nbsp;交易日期：</span> <span id="tradeDate" style="font-family: 宋体; font-size: 12px; font-weight: bold; color: #7d0c01;"><fmt:formatDate
														value="" pattern="yyyy-MM-dd" /></span></td>
										</tr>
										<tr>
											<td colspan="2" align="left" height="35"><span style="font-weight: bold; color: #f38243; font-size: 14px">&nbsp;&nbsp;市场状态：</span> <span id="marketStatus" style="font-family: 宋体; font-size: 12px; font-weight: bold; color: #7d0c01;"></span>&nbsp;&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td height="35"><span style="font-weight: bold; color: #f38243; font-size: 14px">&nbsp;&nbsp;备注：</span> <span id="remark" style="font-family: 宋体; font-size: 12px; font-weight: bold; color: #7d0c01;"></span>&nbsp;&nbsp;</td>
											<td height="35"><span style="font-weight: bold; color: #f38243; font-size: 14px">&nbsp;&nbsp;交易节：</span> <span id="session" style="font-family: 宋体; font-size: 12px; font-weight: bold; color: #7d0c01;"></span>&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td height="3" colspan="2"></td>
										</tr>
										<tr>
											<td colspan="2" height="3"></td>
										</tr>
										<tr>
											<td align="left" width="35%" height="35">&nbsp;&nbsp; <font color=red>●</font>&nbsp;<button class="btn_sec" name="ok4" id="ok4" onclick="javascript:balanceChk_onclick('08');">开市准备</button>
											</td>
											<td><span style="color: #f38243; font-size: 12px">(默认自动)</span></td>
										</tr>
										<tr height="30">
											<td align="left" width="35%" height="35">&nbsp;&nbsp; <font color=red>●</font>&nbsp;<font id="tradeColor" color="blue">开始交易</font>
											</td>
										</tr>
										<tr>
											<td colspan="2" height="3"></td>
										</tr>
										<tr>
											<td colspan="2" height="3"></td>
										</tr>
										<tr>
											<td colspan="2" align="left" height="35">&nbsp;&nbsp; <font color=red>●</font>&nbsp;<button class="btn_sec" name="ok3" id="ok3" onclick="javascript:balanceChk_onclick('05');">暂停交易</button>
											</td>
										</tr>
										<tr>
											<td colspan="2" height="3"></td>
										</tr>
										<tr>
											<td colspan="2" align="left" height="35">&nbsp;&nbsp; <font color=red>●</font>&nbsp;<button class="btn_sec" name="ok1" id="ok1" onclick="javascript:balanceChk_onclick('06');">恢复交易</button>
											</td>
										</tr>
										<tr>
											<td colspan="2" height="3"></td>
										</tr>
										<tr>
											<td align="left" width="35%" height="35">&nbsp;&nbsp; <font color=red>●</font>&nbsp;<button class="btn_sec" name="ok2" id="ok2" onclick="javascript:balanceChk_onclick('09');">交易结束</button>
											</td>
											<td><span style="color: #f38243; font-size: 12px">(默认自动)</span></td>
											<td></td>
										</tr>
										<tr>
											<td colspan="2" height="3"></td>
										</tr>
										<tr>
											<td align="left" width="35%" height="35">&nbsp;&nbsp; <font color=red>●</font>&nbsp;<button class="btn_sec" name="ok11" id="ok11" onclick="javascript:balanceChk_onclick('07');">闭市操作</button>
											</td>
										</tr>
										<tr>
											<td colspan="2" height="3"></td>
										</tr>
										<tr>
											<td colspan="2" align="left">
												<div id="status1" align="center" class="common1"></div>
											</td>
										</tr>
										<tr>
											<td colspan="2" height="15">&nbsp;</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</table>
			</td>
		</tr>
	</table>
</body>
</html>