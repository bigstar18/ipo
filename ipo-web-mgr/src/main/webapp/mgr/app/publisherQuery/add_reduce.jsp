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
		<title>添加减持</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
			function save(){
				
				 if(dataForm.ratio.value==""){
					alert('减持比例不能为空!');return ;
				 };
				 if(parseInt(dataForm.ratio.value)>100){
					 alert('减持比例不能大于100!');return ;
				 };
				 if(dataForm.reduceqty.value=="0"){
					alert('减持数量不能为0!');return ;
				 };
				 var reduceDateVal= $("#reduceDate").datebox("getValue");
				 if(reduceDateVal==""||reduceDateVal==""){
					alert('减持日期不能为空!');return ;
				 };
		    	  $.ajax({  
		  		    url: "<%=request.getContextPath()%>/trusteeshipCommodityController/saveReduce",  
		  		    data:$('#dataForm').serialize(),  
		  		    type: 'POST',dataType: 'text',  
		  		    success : function(data, stats) {  
		  	             if(data=="success"){
		  	            	 alert('设置成功');
		  	            	 back();
		  	             }else if (data=="001"){
		  	            	 alert('减持比例超出范围!');
		  	             }else {
		  	            	alert('设置失败');
		  	             }
		  	        },
			  	    error: function (jqXHR, textStatus, errorThrown) {
			              alert('系统异常!');
			        }
		  		});  
		      }

		 
			//修改日期格式
			function myformatter(date){
				 var y = date.getFullYear();
				 var m = date.getMonth()+1;
				 var d = date.getDate();
				 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
			};
		 
			 
			function back(){
				var positionFlowId_=dataForm.positionFlowId.value;
				var url_='<%=request.getContextPath()%>/PublisherController/reduceSet?id='+positionFlowId_+'&&randnum='+Math.floor(Math.random()*1000000);
				window.location.href=url_; 
			}
			
			function ratioOnBlur(){
				var reduceqtyVal=0;
				var frozenqtyVal=$('#frozenqty').val();
				var ratioVal=dataForm.ratio.value;
				if(parseInt(ratioVal)>100){
					 alert('减持比例不能大于100!');return ;
				};
				reduceqtyVal=parseInt(frozenqtyVal*ratioVal/100);
				dataForm.reduceqty.value=reduceqtyVal;
			}
			
       </script>
    </head>
<body leftmargin="14" topmargin="0"  >
<div class="warning">
		<div class="title font_orange_14b">温馨提示 :添加减持 <font style="color: red">*号为必填项</font></div>
	</div>
	<input  type="hidden" id="holdqty" value="${flow.holdqty}">
	<input  type="hidden" id="frozenqty" value="${flow.frozenqty}">
	<form id="dataForm" name="dataForm"  >
	            <input  type="hidden" name="positionFlowId" value="${flow.id}">
				<table style="border:0;width:850px" align="center"  class="common" cellpadding="0" cellspacing="2">
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>添加减持</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
        							<tr style="height: 30px">   
        								<td align="right" >减持比例:&nbsp;&nbsp;</td>
            							<td> 
            							    <input name="ratio"   size="23"   value="" maxlength="3"
            							    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
            							    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"
            							    onBlur="ratioOnBlur();"
            							     />％  
            							    <font style="color:red">*</font>
            							</td> 
        							</tr>
        							<tr style="height: 30px">   
        								<td align="right" >减持数量:&nbsp;&nbsp;</td>
            							<td> 
            							    <input name="reduceqty"  size="23"   value="0" readonly="readonly" />  
            							</td> 
        							</tr>  
        							<tr style="height: 30px">   
        								<td align="right" >减持日期:&nbsp;&nbsp;</td>
            							<td> 
            							    <input id="reduceDate" name="reduceDate"    class="easyui-datebox" style="width:150px" editable="false" data-options="formatter:myformatter" />  
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
								    <input type="button" value="保存" onclick="save();" class="anniu_btn"   />&nbsp;&nbsp;
									<input type="button" value="返回" onclick="back();" class="anniu_btn"   />
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
