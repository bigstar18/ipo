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
		<title>添加一般费用配置</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
			function save(){
				 if(dataForm.businessCode.value==""){
					alert('请选择绑定业务!');return ;
				 };
				 if(dataForm.roleCode.value==""){
					alert('请选择绑定角色!');return ;
				 };
				 if(dataForm.chargeId.value==""){
					alert('请选择绑定费用!');return ;
				 };
				 if(dataForm.chargePattern.value==""){
					alert('请选择收费模式!');return ;
				 };
				 if(dataForm.amount.value==""){
					 alert('金额不能为空!');return ;
				 };
		    	  $.ajax({  
		  		    url: "<%=request.getContextPath()%>/chargeRoleController/save",  
		  		    data:$('#dataForm').serialize(),  
		  		    type: 'POST',dataType: 'json',  
		  		    success : function(data, stats) {  
		  	             if(data==true||data=="true"){
		  	            	 alert('保存成功');
		  	            	 closeWion();
		  	             }else{
		  	            	 alert('保存失败');
		  	             }
		  	        },
			  	    error: function (jqXHR, textStatus, errorThrown) {
			              alert('系统异常!');
			        }
		  		});  
		    	  
		      };

			function closeWion(){
				if(window.opener){
					window.opener.doSearch();
				};
				window.close();
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
					       		<legend>一般费用配置</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 20px">   
        								<td align="right" >绑定业务:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="businessCode" style="width:181px;">
            							      <option value="0">请选择业务</option>
            							      <c:forEach items="${businessList }" var="item">
            							        <option value="${item.code }">${item.value}</option>
            							      </c:forEach>
            							    </select> 
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
									<tr style="height: 30px">
        	  							<td align="right" >绑定角色:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="roleCode" style="width:181px;">
            							      <option value="0">请选择角色</option>
            							      <c:forEach items="${roleList }" var="item">
            							        <option value="${item.code }">${item.value}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">如果未选择一级费用，则表示此次待添加的费用将被列为一级费用</font>  
            							</td> 
            						</tr>
            						<tr style="height: 30px">   
        								<td align="right" >绑定费用:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="chargeId" style="width:180px;">
            							      <option value="">请选择费用</option>
            							      <c:forEach items="${leafChargeList }" var="item">
            							        <option value="${item.id }">${item.name}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >收费模式:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="chargePattern" style="width:180px;">
            							      <option value="">请选择收费模式</option>
            							      <c:forEach items="${patternList }" var="item">
            							        <option value="${item.code }">${item.name}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >金额:&nbsp;&nbsp;</td>
            							<td> <input name="amount" type="text" size="28" style="height: 24px;" maxlength="12"
            							    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                       						onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
			  								<font style="color:red">*</font> 
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
