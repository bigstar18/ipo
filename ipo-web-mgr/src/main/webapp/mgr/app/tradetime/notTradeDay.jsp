<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- <%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <base target="_self" />
		<title>非交易节设置</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		<script src="${mgrPath }/app/ipo/js/jquery.validationEngine.js" type="text/javascript" charset="UTF-8"></script>	
		<script src="${mgrPath }/app/ipo/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="UTF-8"></script>
		<style type="text/css">
		button {
			width: 200px;
			color: #fff;
			background-color: #337ab7;
			padding: 8px 12px;
			margin-bottom: 0;
			border: 1px solid transparent;
			}
</style>
</head>
<body>
	<table border="0" height="400" width="600" align="center">
		<tbody>
			<tr>
				<td>
					<form id="frm" name="frm" method="POST" enctype="mutipart/form-data">
						<fieldset>
							<legend>
								<b style="color: red;"> 非交易日设置 </b>
							</legend>
							<table>
								<!-- 基本信息 -->
								<tbody>
									<tr>
										<td><span>
												<table cellspacing="4" cellpadding="4" width="100%" class="common"
													style="font-size: 12px;">
													<tbody>
														<tr>
															<td align="right" width="118">非交易星期：</td>
															<td align="left" width="460">
															星期一 
															<input type="checkbox" style="margin-left: -7px;" name="week" value="1" class="NormalInput"/> 
															星期二 
															<input	type="checkbox" style="margin-left: -7px;" name="week" value="2" class="NormalInput"/> 
															星期三 
															<input type="checkbox" style="margin-left: -7px;" name="week" value="3" class="NormalInput"/> 
															星期四
															<input type="checkbox" style="margin-left: -7px;" name="week" value="4" class="NormalInput"/> 
															星期五 
															<input type="checkbox" style="margin-left: -7px;" name="week" value="5" class="NormalInput"/> 
															星期六 
															<input type="checkbox" style="margin-left: -7px;" name="week" value="6" class="NormalInput"/> 
															星期日
															<input type="checkbox" style="margin-left: -7px;" name="week" value="7" class="NormalInput"/>
															</td>
														</tr>
													</tbody>
												</table>
										</span></td>
									</tr>
									<!-- 参数信息 -->
									<tr>
										<td><span>
												<table style="font-size: 12px;">
													<tbody>
														<tr>
															<td align="right" width="118">非交易日期：</td>
															<td><textarea rows="5" cols="55" style="width: 428" id = "day" name = "day" ></textarea></td>
														</tr>
														<tr>
															<td></td>
															<td>逗号分隔的日期，
															<b style="color: red;">
																(逗号必须为英文状态下半角) 
															</b>
															</td>
														</tr>
														<tr>
															<td></td>
															<td>例如 ：2008-10-01,2008-10-02,2008-10-03</td>
														</tr>
													</tbody>
												</table>
										</span></td>
									</tr>
									<tr>
										<td></td>
									</tr>
									<tr>
										<td align="center">
											<input type="button" onclick="update()" value="提交"/>
										</td>
									</tr>
								</tbody>
							</table>
						</fieldset>
					</form>
				</td>
			</tr>
		</tbody>
	</table>
	<script type="text/javascript">
    	$(document).ready(function() {
		window_onload();
    });
	
	
	function window_onload(){
	    var relWeek = "<%=request.getAttribute("week") %>";
	    if (relWeek) {
	    	var relWeeks = relWeek.split(",");
	    	var weeks = $(":checkbox");
	    	for (j = 0; j < relWeeks.length; j++) {
	    		for (i = 0; i < weeks.length; i++) {
	    			if (relWeeks[j] == weeks[i].value) {
	    				weeks[i].checked = true;
	    			}
	    		}
	    	}
	    }	
	    var day = "<%=request.getAttribute("day") %>";
	    document.getElementById("day").value = day;
	}	
	 
	function update(){
		
			var flag = false;
			flag = date();
			var weeks = document.getElementsByName("week");
			var weekArry = [];
			for(var i = 0;i<weeks.length;i++){
				if(weeks[i].checked){
					 weekArry.push(weeks[i].value);
				}
			}
			var day = document.getElementById("day").value;
			alert(day);
			var week = weekArry.join(',');
			if (flag) {
				$('#frm').form({
	                url:'<%=request.getContextPath()%>/TradetimeController/update',
	                onSubmit:function(){
	                 return $(this).form('validate');
	                  },
	                success:function(data){
	                  		alert("提交成功！");
	                  }
	                 });  
	             $('#frm').submit(); 	
			}
	}                                              
	    
	//验证日期输入格式是否正确
	  function date(){  
	  	if (document.getElementById("day").value != "") {
	  		var relDay0 = document.getElementById("day").value;
	  		
	  		var relDays0 = relDay0.replace(/\r/ig,"").replace(/\n/ig,"");
	  		var days = relDays0.split(",");
	  		for (i = 0; i < days.length; i++) {
	  			ymd1 = days[i].split("-");
	  			month1=ymd1[1]-1   
	    		var Date1 = new Date(ymd1[0],month1,ymd1[2]);     
	  			if (Date1.getMonth()+1!=ymd1[1] || Date1.getDate()!=ymd1[2] || Date1.getFullYear()!=ymd1[0] || ymd1[0].length!=4 || ymd1[1].length!=2 || ymd1[2].length!=2){   
	           		alert("非法日期,请依【YYYY-MM-DD】格式输入");   
	           		document.getElementById("day").focus();   
	           		return false;                       
	    		}
	    		
	  		}
	  		
	  		for (j = 0; j < days.length; j++) {
	  			for (k = 0; k < days.length; k++) {
	  				var relDays = days[j];
	  				var relDays2 = days[k];
	  				if (j != k) {
	  					if (relDays == relDays2) {
	  						alert("不准输入相同日期！");
	  						document.getElementById("day").focus();
	  						return false;
	  					}
	  				}
	  			}
	  		}
	  		document.getElementById("day").value = relDays0;   
	  		return true;
	  	}
	  }
	</script>
</body>
</html>