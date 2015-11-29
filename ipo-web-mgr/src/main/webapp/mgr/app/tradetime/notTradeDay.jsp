<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
		<script src="${publicPath }/js/jquery-1.6.min.js" type="text/javascript"></script>
		<script src="${mgrPath }/app/ipo/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="UTF-8"></script> 
		<script src="${mgrPath }/app/ipo/js/jquery.validationEngine.js" type="text/javascript" charset="UTF-8"></script>
		
		
		<title>非 交易日设置</title>
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
					<form id="frm" method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/TradetimeController/addTradetime">
						<fieldset>
							<legend>
								<b style="color: red;"> 非交易日设置 </b>
							</legend>
							<table>
								<!-- 基本信息 -->
								<tbody>
									<tr>
										<td><span>
												<table cellspacing="4" cellpadding="4" width="100%"
													style="font-size: 12px;">
													<tbody>
														<tr>
															<td align="right" width="118">非交易星期：</td>
															<td align="left" width="460">
															星期一 
															<input type="checkbox" style="margin-left: -7px;" name="entity.weeks" value="1" class="NormalInput"/> 
															星期二 
															<input	type="checkbox" style="margin-left: -7px;" name="entity.weeks" value="2" class="NormalInput"/> 
															星期三 
															<input type="checkbox" style="margin-left: -7px;" name="entity.weeks" value="3" class="NormalInput"/> 
															星期四
															<input type="checkbox" style="margin-left: -7px;" name="entity.weeks" value="4" class="NormalInput"/> 
															星期五 
															<input type="checkbox" style="margin-left: -7px;" name="entity.weeks" value="5" class="NormalInput"/> 
															星期六 
															<input type="checkbox" style="margin-left: -7px;" name="entity.weeks" value="6" class="NormalInput"/> 
															星期日
															<input type="checkbox" style="margin-left: -7px;" name="entity.weeks" value="7" class="NormalInput"/>
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
															<td><textarea rows="5" cols="55" style="width: 428"></textarea></td>
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
											<button onclick="confirm();">提交</button>
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
    	jQuery("#frm").validationEngine('attach');
		//修改按钮注册点击事件
		$("#update").click(function(){
			//验证信息
			if(jQuery("#frm").validationEngine('validateform')){
				var flag = false;
				flag = save_onclick();
				if (flag) {
					var vaild = affirm("您确定要操作吗？");
					if(vaild){
						//添加信息URL
						var updateDemoUrl = $(this).attr("action");
						//全 URL 路径
						var url = "${basePath}"+updateDemoUrl;
						$("#frm").attr("action",url);
						$("#frm").submit();
						$(this).attr("disabled",true);
					}
				}	
			}
		});
		changeColor();
		window_onload();
    });
	
	function window_onload()
	{
	    var relWeek = "${entity.week}";
	    //alert(relWeek);
	    if (relWeek) {
	    	var relWeeks = relWeek.split(",");
	    	var weeks = $(":checkbox");
	    	for (j = 0; j < relWeeks.length; j++) {
	    	//alert(relWeeks.length);
	    	//alert(relWeeks[j]);
	    		for (i = 0; i < weeks.length; i++) {
	    			if (relWeeks[j] == weeks[i].value) {
	    			
	    				weeks[i].checked = true;
	    			}
	    		}
	    	}
	    }	
	}
	
	function save_onclick()
	{
		
		var is = date();
		//alert(is);
		//alert(document.forms(0).day.value);
		if (document.getElementById("day").value != "") {
			if (!is) {
			return false;
			}
		}
		return true;
	}

	    
	  function date(){  
	  	if (document.getElementById("day").value != "") {
	  		var relDay0 = document.getElementById("day").value;
	  		
	  		var relDays0 = relDay0.replace(/\r/ig,"").replace(/\n/ig,"");
	  		var days = relDays0.split(",");
	  		for (i = 0; i < days.length; i++) {
	  			ymd1 = days[i].split("-");
	  			month1=ymd1[1]-1   
	    		var Date1 = new Date(ymd1[0],month1,ymd1[2]);     
	    		//alert(ymd1[0].length);
	    		//alert(ymd1[1].length);
	    		//alert(ymd1[2].length);
	    		//alert(Date1.getMonth()+1);
	  			if (Date1.getMonth()+1!=ymd1[1] || Date1.getDate()!=ymd1[2] || Date1.getFullYear()!=ymd1[0] || ymd1[0].length!=4 || ymd1[1].length!=2 || ymd1[2].length!=2){   
	           		//alert(ymd1[0]);
	           		//alert(ymd1[1]);
	           		//alert(ymd1[2]);
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
	  		//alert(relDays0);
	  		document.getElementById("day").value = relDays0;  
	  		return   true;
	  	}
	  }
	</script>
</body>
</html>