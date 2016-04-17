<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>

<html>
<head>
<title>查询条件</title>
<script type="text/javascript">
$(function () {
    $("#payables").datebox({
   	 editable: false,
        required: true,
        missingMessage: "必填项",
        formatter: function (date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
        }
      });
    });


	function setFirmid(value){
		$("#firm").val(value);
	}
	
	function examine(){
		  var time = $("#payables").datebox("getValue");
		  if(time == "" || time == null){
			  alert("请选择查询时间");
		  }else{
			  var iWidth = 1000; //弹出窗口的宽度;
		      var iHeight = 700; //弹出窗口的高度;
		      var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		      var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
		      window.open("<%=request.getContextPath()%>/brokerageReportController/deliveryIncomeInfo?time="+time,"报表页面",'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth +  ',top=' + iTop + ',left=' + iLeft+",scrollbars=yes,location=no");
		  }
	}
 	
</script>
</head>
<body>
	<form id="frm" name="frm">
	<br>
	<br>
	<br>
	<br>
	<br>
		<table border="0" align="center"  style="height: 30%;width: 60%" >
			<tr>
				<td>
					<fieldset>
						<legend>经纪会员注册/注销提货单经纪收入报表</legend>
						<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" >
							<tr>
								<td align="center" colspan="2" style="color: red">(填空为查询全部)</td>
							</tr>
							<tr>
								<td align="right">查询日期：</td>
								<td>
									<input style="width: 100px" id="payables" name="payables" />
									<span class="required">*</span>
								</td>
							</tr>
						</table>
						<table border="0" align="center" cellpadding="5" cellspacing="5" class="common">
							<tr>
								<td>
									<button class="btn_sec" id="add" onclick="examine()">查看</button>

	     						</td>
	     						<td>
	     							<button class="btn_sec1" id="saveExcel"  onclick="return query('excel')">保存为excel</button>
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