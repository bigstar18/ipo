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
		<title>品种</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
			function save(){
				 if(dataForm.commodityId.value==""){
					alert('请选择商品');return ;
				 };
				 if(dataForm.plan.value==""){
					alert('托管计划不能为空!');return ;
						
				 };
				 if(dataForm.purchaseRate.value==""){
					alert('申购发行比例不能为空!');return ;
				 };
		    	  $.ajax({  
		  		    url: "<%=request.getContextPath()%>/trusteeshipCommodityController/savePlan",  
		  		    data:$('#dataForm').serialize(),  
		  		    type: 'POST',dataType: 'json',  
		  		    success : function(data, stats) {  
		  	             if(data==true||data=="true"){
		  	            	 alert('保存成功');
		  	             }else{
		  	            	 alert('保存失败');
		  	             }
		  	        },
			  	    error: function (jqXHR, textStatus, errorThrown) {
			              alert('系统异常!');
			        }
		  		});  
		    	  
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
					       		<legend>添加托管计划</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 30px">
        	  							<td align="right" >托管商品:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="commodityId" style="width:150px;">
            							      <option value="">请选择商品</option>
            							      <c:forEach items="${commodityList }" var="item">
            							        <option value="${item.commodityid }">${item.commodityname}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">*</font>  
            							</td> 
            						</tr>
            						<tr style="height: 30px">   
        								<td align="right" >托管计划:&nbsp;&nbsp;</td>
            							<td> <input name="plan" type="text" size="23" style="height: 24px;"/>  
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >申购发行比例:&nbsp;&nbsp;</td>
            							<td> <input name="purchaseRate" type="text" size="21" style="height: 24px;"
            							    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                       						onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>％
			  								<font style="color:red">*</font> 
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >备注:&nbsp;&nbsp;</td>
            							<td> <textarea name="remark" rows="5" cols="21"></textarea> 
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
								    <input type="button" value="添加" onclick="save()" class="anniu_btn"   />&nbsp;&nbsp;
									<input type="button" value="返回" onclick="window.history.go(-1)" class="anniu_btn"   />
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
