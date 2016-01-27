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
		<title>修改数据项</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
			function save(){
				 if(dataForm.value.value==""){
					alert('值不能为空!');return ;
				 };
		    	  $.ajax({  
		  		    url: "<%=request.getContextPath()%>/dataItemController/update",  
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
	            
				<table style="border:0;width:850px" align="center"  class="common" cellpadding="0" cellspacing="2">
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>修改数据项</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 20px">   
        								<td align="right" >编码:&nbsp;&nbsp;</td>
            							<td> <input name="code" type="text" size="28" readonly="readonly" style="height: 24px;" maxlength="25" value="${entity.code }"/>
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
									<tr style="height: 20px">   
        								<td align="right" >类别:&nbsp;&nbsp;</td>
            							<td> <input name="type" type="text" size="28" readonly="readonly" style="height: 24px;" maxlength="40" value="${entity.type }"/>
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
            						<tr style="height: 20px">   
        								<td align="right" >值:&nbsp;&nbsp;</td>
            							<td> <input name="value" type="text" size="28"   style="height: 24px;" maxlength="50" value="${entity.value }"/>
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >备注:&nbsp;&nbsp;</td>
            							<td> <input name="remark" type="text" size="28"   style="height: 24px;" maxlength="50" value="${entity.remark }"/>
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
