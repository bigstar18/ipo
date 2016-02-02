<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/ecside/css/ecside_style.css" type="text/css" />
		<style type="text/css">input {line-height: 14px;}    td {padding-bottom: 3px;}</style>
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		<title>添加扣款记录</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
			function save(){
				 if(dataForm.businessType.value==""){
					alert('请选择业务类型!');return ;
				 }; 
				 if(dataForm.chargeType.value==""){
					alert('请选择费用类型!');return ;
				 };
				 if(dataForm.debitChannel.value==""){
					alert('请选择扣款渠道!');return ;
				 };
				
				 if(dataForm.commodityId.value==""){
					alert('商品编号不能为空!');return ;
				 };
				 if(dataForm.orderId.value==""){
					alert('单号不能为空!');return ;
				 };
				 if(dataForm.amount.value==""){
					 alert('金额不能为空!');return ;
				 };
				 if(dataForm.payer.value==""){
					 alert('付款人不能为空!');return ;
				 };
				 var debitDateStrVal= $("#debitDateStr").datebox("getValue");
				 if(debitDateStrVal==""){
					 alert('付款时间不能为空!');return ;
				 };
		    	  $.ajax({  
		  		    url: "<%=request.getContextPath()%>/debitFlowController/save",  
		  		    data:$('#dataForm').serialize(),  
		  		    type: 'POST',dataType: 'text',  
		  		    success : function(data, stats) {  
		  	             if(data=="success"){
		  	            	 alert('保存成功');
		  	            	 closeWion();
		  	             }else if(data=="error"){
		  	            	 alert('保存失败');
		  	             }
		  	        },
			  	    error: function (jqXHR, textStatus, errorThrown) {
			              alert('系统异常!');
			        }
		  		});  
		    	  
		      };

		    //修改日期格式
			  function myformatter(date){
				 var y = date.getFullYear();
				 var m = date.getMonth()+1;
				 var d = date.getDate();
				 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
			  };
				
		      function closeWion(){
					if(window.opener){
						window.opener.doSearch();
					};
					window.close();
			  };
			  function clearNoNum(obj){
					obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
					obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是
					obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
					obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
					obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
			  }
       </script>
    </head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : <font style="color: red">*号为必填项</font></div>
	</div>
	<form id="dataForm" name="dataForm"  >
				<table style="border:0;width:850px" align="center"  class="common" cellpadding="0" cellspacing="2">
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>添加扣款记录</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 20px">   
        								<td align="right" >业务类型:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="businessType" style="width:181px;">
            							      <option value="">请选择业务</option>
            							      <c:forEach items="${businessTypeList }" var="item">
            							        <option value="${item.code }">${item.name}</option>
            							      </c:forEach>
            							    </select> 
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
            						<tr style="height: 30px">   
        								<td align="right" >费用类型:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="chargeType" style="width:180px;">
            							      <option value="">请选择费用</option>
            							      <c:forEach items="${chargeTypeList }" var="item">
            							        <option value="${item.code }">${item.name}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >扣款方式:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="debitMode" style="width:180px;" disabled="disabled">
            							       <option value="2">线下</option>
            							    </select> 
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >扣款渠道:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="debitChannel" style="width:180px;">
            							      <option value="">请选择收费模式</option>
            							      <c:forEach items="${debitChannelList }" var="item">
            							        <option value="${item.code }">${item.name}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >商品编码:&nbsp;&nbsp;</td>
            							<td> <input name="commodityId" type="text" size="26" style="height: 24px;" maxlength="32" />
			  								 <font style="color:red">*</font> 
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >单号:&nbsp;&nbsp;</td>
            							<td> <input name="orderId" type="text" size="26" style="height: 24px;" maxlength="32" />
			  								 <font style="color:red">*</font> 
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >金额:&nbsp;&nbsp;</td>
            							<td> <input name="amount" type="text" size="26" style="height: 24px;" maxlength="12"
            							    onkeyup="clearNoNum(this)" />
			  								<font style="color:red">*</font> 
            							</td> 
        							</tr>
        						    <tr style="height: 20px">   
        								<td align="right" >付款人:&nbsp;&nbsp;</td>
            							<td> <input name="payer" type="text" size="26" style="height: 24px;" maxlength="32" />
			  								 <font style="color:red">*</font> 
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >付款时间:&nbsp;&nbsp;</td>
            							<td> 
            								<input id="debitDateStr" name="debitDateStr" class="easyui-datebox" style="width:171px;height: 24px;" editable="false" data-options="formatter:myformatter"> 
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >备注:&nbsp;&nbsp;</td>
            							<td> <input name="remark" type="text" size="26" style="height: 24px;" maxlength="32" />
            							</td> 
        							</tr>
	 							</table >
								 </fieldset> 
						 	</td>
						</tr>
						<tr><td colspan="4" height="3"></td></tr> 
						<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								    <input type="button" value="提交" onclick="save()" class="anniu_btn"   />&nbsp;&nbsp;
								</div>
							</td>
						</tr>
					</table>
			
		</td>
	</tr>
</table>
</form>
</body>
</html>
