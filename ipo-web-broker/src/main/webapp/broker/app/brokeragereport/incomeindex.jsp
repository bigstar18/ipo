<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>

<html>
<head>
<title>查询条件</title>
<script type="text/javascript">

	$(function () {
	     $("#startTime").datebox({
	    	 editable: false,
	         required: true,
	         missingMessage: "必填项",
	         formatter: function (date) {
	         var y = date.getFullYear();
	         var m = date.getMonth() + 1;
	         var d = date.getDate();
	         return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
	         },
	         onSelect:function (date){
                var stime=parseISO8601($('#starttime').datebox('getValue'));
 		          var etime=parseISO8601($('#endtime').datebox('getValue'));
 		    	   if (etime < stime) {
 		               alert('结束日期小于开始日期');
 		               $('#starttime').datebox('setValue', '').datebox('showPanel');
 		           }
 	     	}
	       });
	     
	     $("#endTime").datebox({
	    	 editable: false,
	         required: true,
	         missingMessage: "必填项",
	         formatter: function (date) {
	         var y = date.getFullYear();
	         var m = date.getMonth() + 1;
	         var d = date.getDate();
	         return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
	         },
	         onSelect:function (date){
                var stime=parseISO8601($('#starttime').datebox('getValue'));
 		          var etime=parseISO8601($('#endtime').datebox('getValue'));
 		    	   if (etime < stime) {
 		               alert('结束日期小于开始日期');
 		               $('#starttime').datebox('setValue', '').datebox('showPanel');
 		           }
 	     	}
	       });
	     }
	);
	
	function parseISO8601(dateStringInRange) {
	        var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s*$/,
	            date = new Date(NaN), month,
	            parts = isoExp.exec(dateStringInRange);

	        if(parts) {
	          month = +parts[2];
	          date.setFullYear(parts[1], month - 1, parts[3]);
	          if(month != date.getMonth() + 1) {
	            date.setTime(NaN);
	          }
	        }
	        return date;//new Date(str) IE8不兼容
	      }

	function setFirmid(value){
		$("#firm").val(value);
	}
	
	function examine(){
		  var time = $("#startTime").datebox("getValue");
		  var endtime = $("#endTime").datebox("getValue");
		  if(time == "" || time == null){
			  alert("请选择查询时间");
		  }else if(time > endtime){
			  alert("结束日期大于起始日期");
		  }
		  else{
			  var iWidth = 1000; //弹出窗口的宽度;
		      var iHeight = 700; //弹出窗口的高度;
		      var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		      var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
		      window.open("<%=request.getContextPath()%>/brokerageReportController/incomeForward?starttime="+time+"&&endtime="+endtime,"报表页面",'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth +  ',top=' + iTop + ',left=' + iLeft+",scrollbars=yes,location=no"); 
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
						<legend>经纪会员经济收入报表</legend>
						<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" >
							<tr>
								<td align="center" colspan="2" style="color: red">(填空为查询全部)</td>
							</tr>
							 
							<tr>
								<td align="right">起始日期：</td>
								<td>
									<input style="width: 100px" id="startTime" name="startTime" />
									<span class="required">*</span>
								</td>
							</tr>
							<tr>
								<td align="right">结束日期：</td>
								<td>
									<input style="width: 100px" id="endTime" name="endTime" />
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