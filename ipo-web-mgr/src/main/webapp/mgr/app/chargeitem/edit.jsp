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
		<title>修改费用</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
			function save(){
				 if(dataForm.name.value==""){
					alert('费用名称不能为空!');return ;
				 };
				 
				 if(dataForm.type.value==""){
					alert('请选择费用周期');return ;
				 };
				 if(dataForm.sortId.value==""){
					alert('排序不能为空!');return ;
				 };
				 if(dataForm.remark.value.length>200){
					 alert('备注不能超过200个字符');return ;
				 };
				 
				  $("#parentId").removeAttr("disabled");
		    	  $.ajax({  
		  		    url: "<%=request.getContextPath()%>/chargeItemController/update",  
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
				 $("#parentId").attr("disabled","disabled");
		    	  
		      }

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
	            <input type="hidden" name="id" value="${entity.id }"/>
				<table style="border:0;width:850px" align="center"  class="common" cellpadding="0" cellspacing="2">
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>修改费用</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 20px">   
        								<td align="right" >费用名称:&nbsp;&nbsp;</td>
            							<td> <input name="name" type="text" size="28" readonly="readonly" style="height: 24px;" maxlength="50" value="${entity.name }"/>
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
									<tr style="height: 30px">
        	  							<td align="right" >上级费用:&nbsp;&nbsp;</td>
            							<td> 
            							    <select id="parentId" name="parentId" style="width:181px;" disabled="disabled">
            							      <option value="0">请选择费用</option>
            							      <c:forEach items="${chargeList }" var="item">
            							           <option value="${item.id }"  
            							             <c:if test="${item.id eq entity.parentId}" >selected</c:if>
            							           >${item.name}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">如果未选择一级费用，则表示此次待添加的费用将被列为一级费用</font>  
            							</td> 
            						</tr>
            						<tr style="height: 30px">   
        								<td align="right" >费用周期:&nbsp;&nbsp;</td>
            							<td> 
            							    <select name="type" style="width:180px;">
            							      <option value="">请选择费用周期</option>
            							      <c:forEach items="${typeList }" var="item">
            							        <option value="${item.code }"
            							          <c:if test="${item.code eq entity.type}" >selected</c:if>
            							        >${item.name}</option>
            							      </c:forEach>
            							    </select> 
			  								<font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >排序:&nbsp;&nbsp;</td>
            							<td> <input name="sortId" type="text" size="28" style="height: 24px;" maxlength="5" value="${entity.sortId }"
            							    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                       						onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
			  								<font style="color:red">*</font> 
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >备注:&nbsp;&nbsp;</td>
            							<td> <textarea name="remark" rows="5" cols="26" >${entity.remark }</textarea> 
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
