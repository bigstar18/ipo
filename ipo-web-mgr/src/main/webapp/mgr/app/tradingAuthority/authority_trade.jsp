<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>

<html>
<head>
<title>查询条件</title>
<script type="text/javascript">
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

	function getModel(firmid){
		if(firmid != ''){
			$.ajax({
				type : "GET",
				 url : "<%=request.getContextPath()%>/authorityController/getMoudel",
				data : {"firmid" : firmid,
					"randnum":Math.floor(Math.random()*1000000)},
				success : function(data){
					if(data == "error"){
						alert("交易商不存在");
					}else{
						$(":checkbox").attr("checked",false);
						if (data) {
					    	var models = eval(data);
					    	var model = $(":checkbox");
					    	for (j = 0; j < models.length; j++) {
					    		for (i = 0; i < model.length; i++) {
					    			if (models[j] == model[i].value) {
					    				model[i].checked = true;
					    			}
					    		}
					    	}
					    }
					}
				}
			});
		}
	}
	
	function saves(){
		$('#frm').form({
	                url:'<%=request.getContextPath()%>/authorityController/update',
	                onSubmit:function(){
	                	var firmid = $("#firmid").val();
	                	if(firmid != null && firmid != ''){
	                		return true;
	                	}else{
	                		alert("交易商账号不可为空");
	                		return false;
	                	}
	                  },
	                success:function(data){
	                  		alert("提交成功！");
	                  }
	                 });
		 $('#frm').submit();
	}
	
	
</script>
</head>
<body>
	<form id="frm" name="frm" method="post" action="<%=request.getContextPath()%>/authorityController/update">
	<br>
	<br>
	<br>
	<br>
	<br>
		<table border="0" align="center"  style="height: 30%;width: 60%" >
			<tr>
				<td>
					<fieldset>
						<legend>交易商交易模块权限设置</legend>
						<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" >
							<tr>
								<td align="right">交易商账号：</td>
								<td>
									<input id="firmid" name="firmid" type="text" size=10 maxlength=8 onblur="getModel(value);" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"/>
									<span class="req">*</span>
								</td>
							</tr> 
							<tr>
								<td align="right">模块权限：</td>
								<td>
									 <input type="checkbox" name="moudel" value="1" />邮币卡模块  &nbsp;&nbsp;&nbsp;&nbsp;
  									 <input type="checkbox" name="moudel" value="2" />大宗商品模块
								</td>
							</tr>
						</table>
						<table border="0" align="center" cellpadding="5" cellspacing="5" class="common">
							<tr>
								<td>
									<button class="btn_sec" id="add" onclick="saves();">保存</button>
									<!-- <input type="button" onclick="saves();" value="提交"/> -->
	     						</td>
	     						<!-- <td>
	     							<button class="btn_sec1" id="saveExcel"  onclick="return query('excel')">保存为excel</button>

	     						</td> -->
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>