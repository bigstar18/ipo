<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
	<head>
	    <base target="_self" />
		<title>添加特殊手续费</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		
<script type="text/javascript"> 

function back(){
	document.location.href = "<%=request.getContextPath()%>/SpacialSetController/back?randnum="+Math.floor(Math.random()*1000000);
}
function addPoundage(){
	 $.ajax({ 
		 cache:false,
         type: "post",  
         url: "<%=request.getContextPath()%>/SpacialSetController/addBreed",       
         data: $("#frm").serialize(),      
         success: function(data) { 
      	   if(data=='true'){
             alert("添加成功！"); 
             returntoList();
      	   }else{
      		   alert("系统异常，请联系管理员");  
      	   }
         },  
         error: function(data) {  
             alert("系统异常，请联系管理员");  
         } 
	
}
// function addTradeTime(){
// 	var status=$("#status").val();     
// 	if(status!=''){ 
// 		var flag=false;
// 		var flag=save_onclick();
// 		var comms = document.getElementsByName("comms");
// 		var commArry = [];
// 		for(var i = 0;i<comms.length;i++){
// 			if(comms[i].checked){
// 				commArry.push(comms[i].value);
// 			}
// 		}
// 		if(flag){
// 			window.returnValue =true;
// 		}else{
// 			return false;
// 		}
	
// 	}else{
// 					alert("请选择交易节状态");
// 					return false;
// 		}
// 	 }         

           
//  function isTime(val) {
// 		var str=val;
	    
//  	if(str.length == 8) {
//       	var j=str.split(":");
//       	if(j.length == 3) {
//       		var a = j[0].match(/^(\d{2})$/);
// 		   		if (a == null) {
// 					return false;
// 				}
// 				a = j[1].match(/^(\d{2})$/);
// 		   		if (a == null) {
// 					return false;
// 				}
// 		   		a = j[2].match(/^(\d{2})$/);
// 		   		if (a == null) {
// 					return false;
// 				}
				
// 				if (j[0]>24||j[1]>60||j[2]>60) {
// 		           	return false;
// 		    	}
// 	        } else {
// 				return false;
// 		    } 	
//    	} else {
//         	return false;
//     	}
//      return true;
// }

// 	// 获取市场参数
// 	function getMarket(){
		
// 			// 设置交易时间类型，0：同一天交易；1：跨天交易
// 			document.getElementById("tradeTimeType").value = 0;
// 	}

// 	//save
// 	function save_onclick()
// 	{
// 		// 获取市场参数的交易时间类型	
// 		getMarket();
// 	  if(document.forms[0].tradeTimeType.value != ""){

		
// 			if (document.forms[0].starttime.value.indexOf("：") != "-1") {
// 				alert("时间不能输入中文冒号！");
// 				return false;
// 			}
// 			if (!isTime(document.forms[0].starttime.value)) {
// 				alert("交易开始时间格式不正确！");
// 				document.forms[0].starttime.focus();
// 				return false;
// 			}
			
// 			if (document.forms[0].endtime.value.indexOf("：") != "-1") {
// 				alert("时间不能输入中文冒号！");
// 				return false;
// 			}
// 			if (!isTime(document.forms[0].endtime.value)) {
// 				alert("交易结束时间格式不正确！");
// 				document.forms[0].endTime.focus();
// 				return false;
// 			}
			
// 			if (document.forms[0].tradeTimeType.value == "0") {//同一天交易
// 				if (true) {
				
// 					var startTimes = document.forms[0].starttime.value.split(":");
					
// 					var dateST = new Date(0,0,0,startTimes[0],startTimes[1],startTimes[2]);
// 					var hourST = dateST.getHours();
// 					var minuteST = dateST.getMinutes();
// 					var secondST = dateST.getSeconds();
// 					var relDateST = parseInt(hourST)*3600 + parseInt(minuteST)*60 + parseInt(secondST);
					
// 					var endTimes = document.forms[0].endtime.value.split(":");
// 					var dateET = new Date(0,0,0,endTimes[0],endTimes[1],endTimes[2]);
// 					var hourET = dateET.getHours();
// 					var minuteET = dateET.getMinutes();
// 					var secondET = dateET.getSeconds();
// 					var relDateET = parseInt(hourET)*3600 + parseInt(minuteET)*60 + parseInt(secondET);
// 					if (relDateST > relDateET || relDateST == relDateET) {
// 						alert("交易开始时间应早于交易结束时间！");
// 						document.forms[0].starttime.focus();
// 						return false;
// 					}
// 				}
// 			}

// 			return true;
// 	  }else{
// 		  alert("请先在交易市场参数中，设置交易时间类型！");
// 		  return false;
// 	  }
			
// 	 }

// function suffixNamePress()
// {
	
// if (event.keyCode<=47 || event.keyCode>58)
// {
//  event.returnValue=false;
// }
// else
// {
//  event.returnValue=true;
// }
// }       
           
			
</script>
	</head>

	<body>
		<form id="frm" name="frm" method="post" action="<%=request.getContextPath()%>/SpacialSetController/addPoundage" onsubmit="return addTradeTime();">
			<div class="div_cx">
				<table border="0" width="100%" align="center">
					<tr>
						<td>
							<div class="warning">
								<div class="content">
									温馨提示 :特殊手续费添加
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
												基本信息
											</div>
											<div class="div_cxtjR"></div>
										</div>
										<div style="clear: both;"></div>
												<div>
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
												<tr>
													
													<td align="center">
														<span class="required">*</span>
														交易商代码：
													</td>
													<td>
													<input id="name" name="name" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width: 160"/> 
													</td>
													<td align="center">
														<span class="required">*</span>
														商品代码：
													</td>
													<td>
														<select id="status" name="status" style="width:120">
															  <option value="">请选择</option>
									                          <option value="0">无效</option>
										                      <option value="1" selected="selected">正常</option>
														</select>
													</td>
												</tr>
												
												
												
									
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
						
						<tr>
						<td>
							<table border="0" width="100%" align="center">
								<tr>
									<td>
										<div class="div_cxtj">
											<div class="div_cxtjL"></div>
											<div class="div_cxtjC">
												手续费
											</div>
											<div class="div_cxtjR"></div>
										</div>
										<div style="clear: both;"></div>
												<div>
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
												<tr>
													<td align="center">
														<span class="required">*</span>
														发行特殊手续费算法：
													</td>
													<td>
														<select id="status" name="status" style="width:120">
															  <option value="">请选择</option>
									                          <option value="0">1</option>
										                      <option value="1" selected="selected">0</option>
														</select>
													</td>
													<td align="center">
														<span class="required">*</span>
														发行特殊手续费比例：
													</td>
													<td>
													<input id="name" name="name" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width:160"/> 
													</td>
												
												</tr>
												
												
												
									
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					</tr>
				</table>
			</div>
			
			
			<input type="hidden" id="tradeTimeType" name="tradeTimeType"  />
			<div class="tab_pad" style="bottom: 250">
				<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center">
					<tr>
						<td align="center">
							<button class="btn_sec" id="add" onClick="addPoundage">添加</button>

							&nbsp;&nbsp;
							<button class="btn_sec" onClick="back">取消</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
