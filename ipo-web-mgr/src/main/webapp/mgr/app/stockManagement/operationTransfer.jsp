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
        <title>申请持仓过户信息审核</title>
        <style type="text/css">
			legend{font-weight:bold;}
		</style>
        <script type="text/javascript">
        $(document).ready(function(){
        	url:"<%=request.getContextPath()%>/StockController/operationTransfer";
        });
    
        
        function back(){
			var url_='<%=basePath%>/mgr/app/stockManagement/stock_transfer_positions.jsp';
			window.location.href=url_; 
		}   
        
        //审核
        function save(){
        	
                 var state=$('input:radio[name="myradiobtn"]:checked').val();
                 if(state==null){
                     alert("请审核!");
                     return false;
                 }
                 
	    	  $.ajax({ 
	    		type:'POST',
	  		    url:"<%=request.getContextPath()%>/StockController/update",  
	  		    data:{"applicationId":$('#applicationId').val(),"state":state,"remarks":$('#remarks').val()},
	  		    success:function(data) {  
	  	             if(data=="true"){
	  	            	 alert('审核成功');
	  	            	
	  	            	back();
	  	             }else{
	  	            	 alert('审核失败');
	  	            
	  	            	 
	  	             }
	  	        },
		  	    error:function (data) {
		              alert('系统异常!');
		        }
	  		});  
        }
		
		//禁用删除键
		window.onload=function(){
			document.getElementsByTagName("body")[0].onkeydown =function(){			
				//获取事件对象
				var elem = event.relatedTarget || event.srcElement || event.target ||event.currentTarget; 
				
				if(event.keyCode==8){//判断按键为backSpace键
				
						//获取按键按下时光标做指向的element
						var elem = event.srcElement || event.currentTarget; 
						
						//判断是否需要阻止按下键盘的事件默认传递
						var name = elem.nodeName;
						
						if(name!='INPUT' && name!='TEXTAREA'){
							return _stopIt(event);
						}
						var type_e = elem.type.toUpperCase();
						if(name=='INPUT' && (type_e!='TEXT' && type_e!='TEXTAREA' && type_e!='PASSWORD' && type_e!='FILE')){
								return _stopIt(event);
						}
						if(name=='INPUT' && (elem.readOnly==true || elem.disabled ==true)){
								return _stopIt(event);
						}
					}
				}
			}
		function _stopIt(e){
				if(e.returnValue){
					e.returnValue = false ;
				}
				if(e.preventDefault ){
					e.preventDefault();
				}				

				return false;
		}
        </script>
    </head>
<body leftmargin="14" topmargin="0" >
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : <font style="color: red">持仓过户信息审核</font></div>
	</div>
	<form id="dataForm" name="dataForm"  >
	 
				<table style="border:0;width:850px" align="center"  class="common" cellpadding="0" cellspacing="2">
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>申请持仓过户信息审核</legend>
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr style="height: 30px">
        	  							<td align="right" >申请编号:&nbsp;&nbsp;</td>
            							<td> <input id='applicationId' name="purchaseRate0"    readonly="readonly"  size="28" style="height: 24px;" maxlength="5" value=${param.applicationId} />
            							</td> 
            						</tr>
									<tr style="height: 30px">
        	  							<td align="right" >商品代码:&nbsp;&nbsp;</td>
            							<td> <input id='commodityid' name="purchaseRate1"  readonly="readonly"  size="28" style="height: 24px;" maxlength="5" value=${entity.commodityid } />
			  							
            							</td> 
            						</tr>
            						<tr style="height: 30px">
        	  							<td align="right" >申请过户交易商ID:&nbsp;&nbsp;</td>
            							<td> <input id='customeridApply' name="purchaseRate2" readonly="readonly" size="28" style="height: 24px;" maxlength="5" value=${entity.customeridApply } />
			  								
            							</td> 
            						</tr>
        							<tr style="height: 30px">
        	  							<td align="right" >接受过户交易商ID:&nbsp;&nbsp;</td>
            							<td> <input id='customeridAccept' name="purchaseRate3" readonly="readonly" size="28" style="height: 24px;" maxlength="5" value=${entity.customeridAccept } />
			  							
            							</td> 
            						</tr>
        							<tr style="height: 30px">
        	  							<td align="right" >过户数量:&nbsp;&nbsp;</td>
            							<td> <input id='transferNumber' name="purchaseRate4" readonly="readonly" size="28" style="height: 24px;" maxlength="5" value=${entity.transferNumber } />
			  							
            							</td> 
            						</tr>
            						<tr style="height: 30px">
        	  							<td align="right" >审核状态:&nbsp;&nbsp;</td>
        	  							
            							<td> 
            							<c:if test="${entity.state  == 0}">
            								<label id='state' name="purchaseRate5"  size="28"   style="height: 24px;" maxlength="5">申请</label>
            							</c:if>
            							<c:if test="${entity.state  == 1}">
            								<label id='state' name="purchaseRate5"  size="28"   style="height: 24px;" maxlength="5">审核通过</label>
            							</c:if>
            							<c:if test="${entity.state  == 2}">
            								<label id='state' name="purchaseRate5"  size="28"   style="height: 24px;" maxlength="5">审核驳回</label>
            							</c:if>
			  								
            							</td> 
            						</tr>
            						<tr style="height: 30px">
            						<c:if test="${entity.state  == 0}">
        	  							<td align="right" >审核:&nbsp;&nbsp;</td>
            							<td id='btnSubmit'> 
            								<input  name="myradiobtn" type="radio" size="28"  style="height: 24px;" maxlength="5" value="1">审核通过
            								<input  name="myradiobtn" type="radio" size="28"   style="height: 24px;" maxlength="5" value="2">审核驳回	
            							</td> 
            						</c:if>
            						<c:if test="${entity.state  == 1 ||entity.state  == 2}">
            							<td align="right" >备注:&nbsp;&nbsp;</td>
            							<td> <label  name="purchaseRate6"  size="28"  style="height: 24px;" maxlength="5">${entity.remarks }</label>
            						</c:if>
            						</tr>
            						<tr style="height: 30px">
            						<c:if test="${entity.state  == 0}">
        	  							<td align="right" >备注:&nbsp;&nbsp;</td>
            							<td> <input id=remarks  name="purchaseRate6" type="text" size="28"   style="height: 24px;" maxlength="5"" />
			  							
            							</td>
            						</c:if> 
            						</tr>
	 							</table >
								 </fieldset> 
						 	</td>
						</tr>
						<tr><td colspan="4" height="3"></td></tr> 
						<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								<c:if test="${entity.state  == 0}">
								    <input type="button" value="提交" onclick="save();" class="anniu_btn"   />&nbsp;&nbsp;
								</c:if>
									<input type="button" value="返回" onclick="back();" class="anniu_btn"   />
								</div>
							</td>
						</tr>
					</table>
			

</form>
</body>
</html>
