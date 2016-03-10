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
        <script type="text/javascript">
        
        
        function back(){
			var url_='<%=basePath%>/mgr/app/stockManagement/stock_freeze.jsp';
			window.location.href=url_; 
		}
        
        
        function save(){
    		var commodityid=String($("#commodityid").val());//入库数量
    		var customerid=String($("#customerid").val());//发行数量
    		var freezeNumber=parseInt($("#freezeNumber").val());//转发售数量
    		var freezereason=String($("#freezereason").val());
    		var createtime = new Date( );;
    	
			 if(dataForm.purchaseRate1.value==""){
				alert('商品代码不能为空!');return ;
			 };
			 if(dataForm.purchaseRate2.value==""){
				alert('交易商代码不能为空!');return ;
			 };
			 if(dataForm.purchaseRate4.value==""){
				alert('冻结数量不能为空!');return ;
			 };	
			 if(dataForm.purchaseRate4.value<=0){
					alert('冻结数量必须大于0!');return ;
			};
			if(parseInt(dataForm.purchaseRate4.value)!=dataForm.purchaseRate4.value){
				alert('冻结数量必须为整数!');return ;
			};
			if(dataForm.purchaseRate5.value==""){
				alert('冻结原因不能为空!');return ;
			};
			$.ajax({ 
     		   cache:false,
                type: "post",  
                url: "<%=request.getContextPath()%>/StockController/addNewFreeze",       
                data:{"commodityid":commodityid,"customerid":customerid,"freezereason":freezereason,"freezeNumber":freezeNumber,"createtime":createtime},     
               
                success: function(data) { 
             	   if(data=='true'){

                    alert("添加成功！"); 
                    back();
             	   }
             	  else if(data=='nocommid')
         			{
         		  	alert("请输入正确的商品！"); 
         			} 
             	  	else if(data=='nofirmid')
           			{
           		  	alert("请输入正确的交易商！"); 
           			}         	 	
             	   	else if(data=='noquatity')
             		{
             		  alert("该用户持该商品不足！"); 
             		}
             	   	else if(data == 'false')
             	   	{
             		   alert("添加失败！");  
             	   	}
                },  
                error: function(data) {  
                    alert("请求失败！");  
                }  
            }) ;
			
	      }
        </script>
    </head>
<body leftmargin="14" topmargin="0" >
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : <font style="color: red">*号为必填项</font></div>
	</div>
	<form id="dataForm" name="dataForm"  >
				<table style="border:0;width:850px" align="center"  class="common" cellpadding="0" cellspacing="2">
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>申请持仓过户信息</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 30px">
        	  							<td align="right" >商品代码:&nbsp;&nbsp;</td>
            							<td> <input id='commodityid' name="purchaseRate1" type="text" size="28" style="height: 24px;"    onkeyup="value=value.replace(/[/W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^/d]/g,''))" value="${entity.commodityid }" />
			  								<font style="color:red">*</font> 
            							</td> 
            						</tr>
            						<tr style="height: 30px">
        	  							<td align="right" >交易商ID:&nbsp;&nbsp;</td>
            							<td> <input id='customerid' name="purchaseRate2" type="text" size="28" style="height: 24px;"  onkeyup="value=value.replace(/[/W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^/d]/g,''))" value="${entity.customerid }"/>
			  								<font style="color:red">*</font> 
            							</td> 
            						</tr>
        							<tr style="height: 30px">
        	  							<td align="right" >冻结数量:&nbsp;&nbsp;</td>
            							<td> <input id='freezeNumber' name="purchaseRate4" type="text" size="28" style="height: 24px;"   onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" value="${entity.freezeNumber }"/>
			  								<font style="color:red">*</font> 
            							</td> 
            						</tr>
            						<tr style="height: 30px">
        	  							<td align="right" >冻结原因:&nbsp;&nbsp;</td>
            							<td> <input id='freezereason' name="purchaseRate5" type="text" size="28" style="height: 24px;"    value="${entity.freezereason }"/>
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
								    <input type="button" value="冻结" onclick="save();" class="anniu_btn"   />&nbsp;&nbsp;
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
