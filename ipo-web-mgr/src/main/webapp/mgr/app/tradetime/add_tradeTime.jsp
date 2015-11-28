<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>


<script>
function showKeyPress(evt) {
	evt = (evt) ? evt : window.event
	return checkSpecific(String.fromCharCode(evt.keyCode));
}
function checkSpecific(realkey){
	var specialKey = "!<>#$()?%\&\^*\'\"\+\|";//特殊字符列表
	var flg = false;
	flg = (specialKey.indexOf(realkey) >= 0);
	if (flg) {
		return false;
	}
	return true;
}
document.onkeypress=showKeyPress;
</script><!-- 获取返回信息 -->
<html>
	<head>
	    <base target="_self" />
		<title>交易节添加</title>
		<link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
		<script src="${publicPath }/js/jquery-1.6.min.js" type="text/javascript"></script>
		<script src="${mgrPath }/app/ipo/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="UTF-8"></script> 
		<script src="${mgrPath }/app/ipo/js/jquery.validationEngine.js" type="text/javascript" charset="UTF-8"></script>
		
		<script type="text/javascript"> 
		 $(document).ready(function() {
		//ajax验证
		jQuery("#frm").validationEngine( {
			ajaxFormValidation : true,
			onAjaxFormComplete : ajaxValidationCallback,
			onBeforeAjaxFormValidation : beforeCall
		});

		//提交前事件
		function beforeCall(form, options) {
			alert(options);
			return true;
		} 

		//提交后事件
		function ajaxValidationCallback(status, form, json, options) {
			//如果返回成功
			if (status === true) {
				var flag = false;
				
			    flag = save_onclick();
			    aler
			    alert(flag);
			   	if(flag){
			    	var vaild = affirm("您确定要操作吗？");
					if(vaild){	
						$("#frm").submit();
						$("#add").attr("disabled",true);
					}
			   	}
			} else {
				$("#sectionID").focus();
			}
		}
				 
		//修改按钮注册点击事件
		$("#add").click(function(){
			//验证信息
			if(jQuery("#frm").validationEngine('validateform')){
				return;
			}
		});
		 });

			 function isTime(val) {
					var str=val;
				    
			    	if(str.length == 8) {
			         	var j=str.split(":");
			         	if(j.length == 3) {
			         		var a = j[0].match(/^(\d{2})$/);
					   		if (a == null) {
								return false;
							}
							a = j[1].match(/^(\d{2})$/);
					   		if (a == null) {
								return false;
							}
					   		a = j[2].match(/^(\d{2})$/);
					   		if (a == null) {
								return false;
							}
							
							if (j[0]>24||j[1]>60||j[2]>60) {
					           	return false;
					    	}
				        } else {
							return false;
					    } 	
			      	} else {
			           	return false;
			       	}
			        return true;
			}
			
			// 获取市场参数
			function getMarket(){
				
					// 设置交易时间类型，0：同一天交易；1：跨天交易
					document.getElementById("tradeTimeType").value = 0;
			}

			//save
			function save_onclick()
			{
				// 获取市场参数的交易时间类型	
				getMarket();
			  if(document.forms(0).tradeTimeType.value != ""){

				
					if (document.forms(0).startTime.value.indexOf("：") != "-1") {
						alert("时间不能输入中文冒号！");
						return false;
					}
					if (!isTime(document.forms(0).startTime.value)) {
						alert("交易开始时间格式不正确！");
						document.forms(0).startTime.focus();
						return false;
					}
					
					if (document.forms(0).endTime.value.indexOf("：") != "-1") {
						alert("时间不能输入中文冒号！");
						return false;
					}
					if (!isTime(document.forms(0).endTime.value)) {
						alert("交易结束时间格式不正确！");
						document.forms(0).endTime.focus();
						return false;
					}
					
					if (document.forms(0).tradeTimeType.value == "0") {//同一天交易
						if (true) {
						
							var startTimes = document.forms(0).startTime.value.split(":");
							
							var dateST = new Date(0,0,0,startTimes[0],startTimes[1],startTimes[2]);
							var hourST = dateST.getHours();
							var minuteST = dateST.getMinutes();
							var secondST = dateST.getSeconds();
							var relDateST = parseInt(hourST)*3600 + parseInt(minuteST)*60 + parseInt(secondST);
							
							var endTimes = document.forms(0).endTime.value.split(":");
							var dateET = new Date(0,0,0,endTimes[0],endTimes[1],endTimes[2]);
							var hourET = dateET.getHours();
							var minuteET = dateET.getMinutes();
							var secondET = dateET.getSeconds();
							var relDateET = parseInt(hourET)*3600 + parseInt(minuteET)*60 + parseInt(secondET);
							if (relDateST > relDateET || relDateST == relDateET) {
								alert("交易开始时间应早于交易结束时间！");
								document.forms(0).startTime.focus();
								return false;
							}
						}
					}

					return true;
			  }else{
				  alert("请先在交易市场参数中，设置交易时间类型！");
				  return false;
			  }
					
			 }

			 function suffixNamePress()
			{
				
			  if (event.keyCode<=47 || event.keyCode>58)
			  {
			    event.returnValue=false;
			  }
			  else
			  {
			    event.returnValue=true;
			  }
			}

</script>
	</head>

	<body>
		<form id="frm" name="frm" method="post" action="<%=request.getContextPath()%>/TradetimeController/addTradetime">
			<div class="div_cx">
				<table border="0" width="100%" align="center">
					<tr>
						<td>
							<div class="warning">
								<div class="content">
									温馨提示 :交易节添加
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<table border="0" width="100%" align="center">
								<tr>
									<td>
										<div class="div_cxtj">
											<div class="div_cxtjL"></div>
											<div class="div_cxtjC">
												添加交易节
											</div>
											<div class="div_cxtjR"></div>
										</div>
										<div style="clear: both;"></div>
												<div>
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
												<tr>
													
													<td align="right">
														<span class="required">*</span>
														交易节名称：
													</td>
													<td>
													    <input type="text" id="name" name="entity.name" 
															class="validate[required] input_text datepicker"/>
													</td>
													<td align="left">
														<span class="required">*</span>
														当前交易节状态：
													</td>
													<td>
														<select id="status" name="entity.status" class="validate[required]" style="width:120">
															  <option value=""></option>
									                          <option value="0">无效</option>
										                      <option value="1" selected="selected">正常</option>
														</select>
													</td>
												</tr>
												
												<tr>
													<td align="right">
														<span class="required">*</span>
														当前交易节开始时间：
													</td>
													<td>
														<input type="text" id="startTime" name="entity.startTime" 
															class="validate[required] input_text datepicker" onkeypress="return suffixNamePress()"/>
															<span class="required">&nbsp; HH:MM:SS</span>
													</td>
													
													<td align="left">
													    <span class="required">*</span>
														当前交易节结束时间：
													</td>
													<td>
														<input type="text" id="endTime" name="entity.endTime" 
															class="validate[required] input_text datepicker" onkeypress="return suffixNamePress()"/>
															<span class="required">&nbsp; HH:MM:SS</span>
													</td>
												</tr>

											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<input type="hidden" id="tradeTimeType" name="tradeTimeType"  />
			<div class="tab_pad" style="bottom: 250">
				<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center">
					<tr>
						<td align="center">
							<button class="btn_sec" id="add" >添加</button>
							&nbsp;&nbsp;
							<button class="btn_sec" onClick="window.close();">关闭</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
