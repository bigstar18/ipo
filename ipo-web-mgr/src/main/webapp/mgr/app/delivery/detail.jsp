<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
	<head>
		<title>提货单详情</title>
		<script type="text/javascript"> 
		
		$(function () {
		     $("#expressDate").datebox({
		    	 editable: false,
		         required: true,
		         missingMessage: "必填项",
		         formatter: function (date) {
		         var y = date.getFullYear();
		         var m = date.getMonth() + 1;
		         var d = date.getDate();
		         return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		       },
		       onSelect:function (date){
		          var last=parseISO8601($('#lasttradate').datebox('getValue'));
		          var list=parseISO8601($('#listingdate').datebox('getValue'));
		    	   if (last < list) {
		               alert('配送日期必须介于申请日期和提货日期之间！');
		               $('#expressDate').datebox('setValue', '').datebox('showPanel');
		           } 
		       }
		      });
		});
		
function parseISO8601(dateStringInRange) {
 	        var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s*$/,
 	            date = new Date(NaN), month,
 	            parts = isoExp.exec(dateStringInRange);
 	      
 	        if(parts) {
 	          month = +parts[2];
 	          date.setFullYear(parts[1], month - 1, parts[3]);
 	          if(month != date.getMonth() + 1) {
 	            date.setTime(NaN);
 	          }
 	        }
 	        return date;//new Date(str) IE8不兼容
 	      }		
		
function updatePickup(){
	var approvalStatus=$("#approvalStatus").val();
	var flag= $('#frm').form('validate');
	if(approvalStatus!= ''&&flag==true){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/DeliveryController/checkPorders",       
                                       data: $("#frm").serialize(),      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("审核完成！"); 
                                           returntoList();
                                    	   }else{
                                    		   alert("系统异常，请联系管理员");  
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("系统异常，请联系管理员");  
                                       }  
                                   }); 
            }
			else{
					alert("所有参数必填！");
		}
}

function updateExpress(){
	var approvalStatus=$("#approvalStatus").val();
	var flag= $('#frm').form('validate');
	if(approvalStatus!= ''&&flag==true){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/DeliveryController/checkEorders",       
                                       data: $("#frm").serialize(),      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("审核完成！"); 
                                           returntoList();
                                    	   }else{
                                    		   alert("系统异常，请联系管理员");  
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("系统异常，请联系管理员");  
                                       }  
                                   }); 
            }
			else{
					alert("所有参数必填！");
		}
}
function returntoList(){
	var backUrl="<%=request.getContextPath()%>/IpoController/DeliveryApprove?randnum="+Math.floor(Math.random()*1000000);
	document.location.href = backUrl;
}
		
function onlyNumberInput(){
	 if (event.keyCode<46 || event.keyCode>57 || event.keyCode == 47){
		    event.returnValue=false;
	 }
}
	
</script>
</head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : 提货单审核 </div>
		<div class="content" style="color: red">手续费算法：百分比按货款计算手续费，绝对值按数量计算手续费  </div>
	</div>
	<table border="0"  width="100%"  >
		<tr>
			<td valign="top">
				<form id="frm" name="frm" method="POST" >
				<fieldset>
				<legend class="common"><b>提货单详细信息</b></legend>
				<span id="baseinfo9">
				<table width="850" border="0" align="center"  class="common" cellpadding="0" cellspacing="2">
					<!-- 基本信息 -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					          	<legend>
					           	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common">
					            	<col width="55"></col><col></col><col width="6"></col>
					               	<tr>
					                 	<td><b>基本信息</b></td>
					                    <td><hr width="100%" class="pickList"/></td>
					            	</tr>
					         	</table>
					         	</legend>
								<span id="baseinfo">
								<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
        							<tr>
        			 					<td align="right" width="98">提货单号：</td>
	      								<td>
	      								    <input id="deliveryorderId" type="text" name="deliveryorderId" value="${entity.deliveryorderId }" readonly="readonly"/>
		          						</td>
										<td align="right" width="90">商品代码：</td>     
            							<td> 
            								 <input id="commodityId" type="text" name="commodityId" value="${entity.commodityId }" readonly="readonly"/>
										</td>
										<td align="right" width="90">商品名称：</td>     
            							<td> 
            								 <input id="commodityName" type="text" name="commodityName" value="${entity.commodityName }" readonly="readonly"/>
										</td>
							        </tr>  
							        <tr>
        			 					<td align="right" width="98">交易商代码：</td>
	      								<td>
	      								    <input id="dealerId" type="text" name="dealerId" value="${entity.dealerId }" readonly="readonly"/>
		          						</td>
										<td align="right" width="90">交易商名称：</td>     
            							<td> 
            								 <input id="dealerName" type="text" name="dealerName" value="${entity.dealerName }" readonly="readonly"/>
										</td>
										<td align="right" width="90">提货方式：</td>     
            							<td> 
            							 <c:if test="${entity.deliveryMethod == '1'}">
            								 <input id="deliveryMethod" type="text" name="deliveryMethod" value="自提" readonly="readonly"/>
            							</c:if>
            							<c:if test="${entity.deliveryMethod == '2'}">
            								 <input id="deliveryMethod" type="text" name="deliveryMethod" value="在线配送" readonly="readonly"/>
            							</c:if>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="98">仓库代码：</td>
	      								<td>
	      								    <input id="warehouseId" type="text" name="warehouseId" value="${entity.warehouseId }" readonly="readonly"/>
		          						</td>
										<td align="right" width="90">仓库名称：</td>     
            							<td> 
            								 <input id="warehouseName" type="text" name="warehouseName" value="${entity.warehouseName }" readonly="readonly"/>
										</td>
										<td align="right" width="90">交割数量：</td>     
            							<td> 
            								 <input id="deliveryQuatity" type="text" name="deliveryQuatity" value="${entity.deliveryQuatity }" readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="98">单位：</td>
	      								<td>
	      								    <input id="unit" type="text" name="unit" value="${entity.unit }" readonly="readonly"/>
		          						</td>
										<td align="right" width="90">提货日期：</td>     
            							<td> 
            								 <input id="deliveryDate" type="text" name="deliveryDate" value="${entity.deliveryDate }" readonly="readonly"/>
										</td>
										<td align="right" width="90">申请日期：</td>     
            							<td> 
            								 <input id="applyDate" type="text" name="applyDate" value="${entity.applyDate }" readonly="readonly"/>
										</td>
							        </tr> 
							        <c:if test="${flag == 'pickup'}"> 
							        <tr>
        			 					<td align="right" width="98">身份证号：</td>
	      								<td>
	      								    <input id="idcardNum" type="text" name="idcardNum" value="${detail.idcardNum }" readonly="readonly"/>
		          						</td>
										<td align="right" width="90"></td>     
            							<td> 
            							<input id="pickupId" type="hidden" name="pickupId" value="${detail.pickupId }" >
										</td>
										<td align="right" width="90"></td>     
            							<td> 
										</td>
							        </tr> 
							        </c:if>
							        <c:if test="${flag == 'express'}">
							          <tr>
        			 					<td align="right" width="98">配送地址：</td>
	      								<td>
	      								    <input id="address" type="text" name="address" value="${detail.address }" readonly="readonly"/>
		          						</td>
										<td align="right" width="90">收货人：</td>     
            							<td> 
            								 <input id="receiver" type="text" name="receiver" value="${detail.receiver }" readonly="readonly"/>
										</td>
										<td align="right" width="90">联系电话：</td>     
            							<td> 
            								 <input id="tel" type="text" name="tel" value="${detail.tel }" readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="98">配送费：</td>
	      								<td>
	      								    <input id="cost" type="text" name="cost"
	      								    class="easyui-numberbox" data-options="required:true,min:0,precision:2,missingMessage:'请输入精度为2的正数'"/>
		          						    <span class="required">*</span>
		          						</td>
										<td align="right" width="90">配送日期：</td>     
            							<td> 
            								 <input id="expressDate" type="text" name="expressDate" />
										</td>
										<td align="right" width="90"></td>     
            							<td> 
            							<input id="expressId" type="hidden" name="expressId" value="${detail.expressId }" >
										</td>
							        </tr> 
							        </c:if>
							         <tr>
        			 					<td align="right" width="98">备注：</td>
	      								<td colspan="5">
	      								 <input id="remarks" type="text" name="remarks">
										</td>
							        </tr> 
							        <tr>
        			 					<td align="right" width="98">审核意见：</td>
	      								<td>
	      								 <select id="approvalStatus" name="approvalStatus" style="width:100">
												<option value=""></option>
											    <option value="2">通过</option>
												<option value="3">驳回</option>
												 <span class="required">*</span> 
										   </select>
										</td>
										<td align="right" width="90"></td>     
            							<td> 
										</td>
										<td align="right" width="90"></td>     
            							<td> 
										</td>
							        </tr> 
								</table >
								</span>
						    	</fieldset>
							</td>
						</tr>

						<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								<c:if test="${flag == 'pickup'}"> 
								    	<input type="button" value="提交" onclick="updatePickup()" className="anniu_btn"/>
								    	</c:if>
								  <c:if test="${flag == 'express'}"> 
								    	<input type="button" value="提交" onclick="updateExpress()" className="anniu_btn"/>
								    	</c:if>  	
									&nbsp;&nbsp;
									<input type="button" value="返回" onclick="returntoList()" className="anniu_btn"/>
								</div>
							</td>
						</tr>
					</table>
				</span>
			</fieldset>
			</form>
		</td>
	</tr>
</table>
</body>
</html>
