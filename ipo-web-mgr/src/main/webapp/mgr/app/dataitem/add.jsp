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
		<title>添加数据项</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
			function save(){
				
				 if(dataForm.code.value==""){
					alert('编码不能为空!');return ;
				 };
				 if(dataForm.type.value==""){
						alert('类别不能为空!');return ;
				 };
				 if(dataForm.value.value==""){
					alert('值不能为空!');return ;
				 };
		    	  $.ajax({  
		  		    url: "<%=request.getContextPath()%>/dataItemController/save",  
		  		    data:$('#dataForm').serialize(),  
		  		    type: 'POST',dataType: 'text',  
		  		    success : function(data, stats) {  
		  		    	 if(data=="success"){
		  	            	 alert('保存成功');
		  	            	closeWin();
		  	             }else if(data=="error"){
		  	            	 alert('保存失败');
		  	             }else if(data=="001"){
		  	            	alert('类型和编码已经存在,请勿重复添加');
		  	             }
		  	        },
			  	    error: function (jqXHR, textStatus, errorThrown) {
			              alert('系统异常!');
			        }
		  		}); 
		      }

			function closeWin(){
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
					       		<legend>添加数据项</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 20px">   
        								<td align="right" >编码:&nbsp;&nbsp;</td>
            							<td> <input name="code" type="text" size="28"  style="height: 24px;" maxlength="25" value=""/>
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
									<tr style="height: 20px">   
        								<td align="right" >类别:&nbsp;&nbsp;</td>
            							<td> <input name="type" type="text" size="28"   style="height: 24px;" maxlength="40" value=""/>
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
            						<tr style="height: 20px">   
        								<td align="right" >值:&nbsp;&nbsp;</td>
            							<td> <input name="value" type="text" size="28"   style="height: 24px;" maxlength="50" value=""/>
            							     <font style="color:red">*</font> 
            							</td> 
        							</tr>
        							<tr style="height: 20px">   
        								<td align="right" >备注:&nbsp;&nbsp;</td>
            							<td> <input name="remark" type="text" size="28"   style="height: 24px;" maxlength="50" value=""/>
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
