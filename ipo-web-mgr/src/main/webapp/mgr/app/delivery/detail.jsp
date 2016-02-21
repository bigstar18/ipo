<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
	<head>
		<title>提货单详情</title>
		<script type="text/javascript">
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
	 	        return date;
	 	      }
		$(function () {
			 $("#deliveryDate").datebox({
		    	 editable: false,
		         required: true,
		         missingMessage: "必填项",
		         formatter: function (date) {
		         var y = date.getFullYear();
		         var m = date.getMonth() + 1;
		         var d = date.getDate();
		         return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		       }
			 });
			 $("#applyDate").datebox({
		    	 editable: false,
		         required: true,
		         missingMessage: "必填项",
		         formatter: function (date) {
		         var y = date.getFullYear();
		         var m = date.getMonth() + 1;
		         var d = date.getDate();
		         return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		       }
			 });
		   /*  $("#expressDate").datebox({
		    	 editable: false,
		         required: true,
		         missingMessage: "必填项，(驳回可不填)",
		         formatter: function (date) {
		         var y = date.getFullYear();
		         var m = date.getMonth() + 1;
		         var d = date.getDate();
		         return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		       },
		       onSelect:function (date){
		          var delivery=parseISO8601($('#deliveryDate').datebox('getValue'));
		          var apply=parseISO8601($('#applyDate').datebox('getValue'));
		          var express=parseISO8601($('#expressDate').datebox('getValue'));
		    	   if (express < apply || express > delivery) {
		               alert('配送日期必须介于申请日期和提货日期之间！');
		               $('#expressDate').datebox('setValue', '').datebox('showPanel');
		           } 
		       }
		      });*/
		        $("#deliveryDate").datebox("setValue",$("#picktime").val());
				$("#applyDate").datebox("setValue",$("#applytime").val());
		});
				
function updateDelivery(){
	var approvalStatus=$("#approvalStatus").val();
	var stock= parseInt($("#stock").val());
	var deliveryQuantity=parseInt($("#deliveryQuatity").val());
	if(stock==''){
		alert("库存为空，数据异常，请联系仓库管理员");
		return;
	}
	if(stock<deliveryQuantity&&approvalStatus=='002001'){
		alert("提货仓库库存不足，暂时无法通过审核!");
		return ;
	}
	if(approvalStatus!= ''){
                         	   $.ajax({ 
                         		   cache:false,
                                    type: "post",  
                                    url: getRootPath () +"/DeliveryController/checkOrders",       
                                    data: $("#frm").serialize(),      
                                    success: function(data) { 
                                 	   if(data=='true'){
                                        alert("审核完成！"); 
                                        returntoList();
                                 	   }else{
                                 		   alert("审核失败！");  
                                 	   }
                                    },  
                                    error: function(data) {  
                                        alert("系统异常，请联系管理员!");  
                                    }  
                                }); 
         }else{
			 alert("请先审核再提交!");  
		}
}

function returntoList(){
	var backUrl=getRootPath () +"/IpoController/DeliveryApprove?randnum="+Math.floor(Math.random()*1000000);
	document.location.href = backUrl;
}	
		</script>
		<style type="text/css">
		td{font-size:12px;}
		tr{margin-top:10px}
		input{background-color:#ccc}
		</style>
</head>
<body  leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : 提货单审核 </div>
		<div class="content" style="color: red">此页展示提货单的详细信息，后台管理人员根据详细信息进行审核。  </div>
	</div>
	<table border="0"  width="90%"  >
		<tr>
			<td valign="top">
				<form id="frm" name="frm" method="POST" >
				<fieldset>
				<legend class="common"><b>提货单详情</b></legend>
				<span id="baseinfo9">
				<table width="850" border="0" align="center"  class="common" cellpadding="0" cellspacing="2">
					<!-- 基本信息 -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					          	<legend>基本信息
<!-- 					           	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common" > -->
<!-- 					            	<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					               	<tr> -->
<!-- 					                 	<td><b style="font-size: 11px;">基本信息</b></td> -->
<!-- 					                    <td><hr width="90%" class="pickList"/></td> -->
<!-- 					            	</tr> -->
<!-- 					         	</table> -->
					         	</legend>
								<span id="baseinfo">
								<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
        							<tr>
        			 					<td align="right" width="110">提货单号：</td>
	      								<td width="110">
	      								    <input id="deliveryorderId" type="text" name="deliveryorderId" value="${entity.deliveryorderId }" readonly="readonly"/>
		          						</td>
										<td align="right" width="110">商品代码：</td>     
            							<td width="110"> 
            								 <input id="commodityId" type="text" name="commodityId" value="${entity.commodityId }" readonly="readonly"/>
										</td>
										<td align="right" width="110">商品名称：</td>     
            							<td width="110"> 
            								 <input id="commodityName" type="text" name="commodityName" value="${entity.commodityName }" readonly="readonly"/>
										</td>
							        </tr>  
							        <tr>
        			 					<td align="right" width="110">交易商代码：</td>
	      								<td width="110">
	      								    <input id="dealerId" type="text" name="dealerId" value="${entity.dealerId }" readonly="readonly"/>
		          						</td>
										<td align="right" width="110">交易商名称：</td>     
            							<td width="110"> 
            								 <input id="dealerName" type="text" name="dealerName" value="${entity.dealerName }" readonly="readonly"/>
										</td>
										<td align="right" width="110">提货方式：</td>     
            							<td width="110"> 
            							 <c:if test="${entity.deliveryMethod == '自提'}">
            								 <input id="deliveryMethod" type="text" name="deliveryMethod" value="自提" readonly="readonly" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
            							</c:if>
            							<c:if test="${entity.deliveryMethod == '在线配送'}">
            								 <input id="deliveryMethod" type="text" name="deliveryMethod" value="在线配送" readonly="readonly" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
            							</c:if>
            							<input id="methodId" type="hidden" name="methodId" value="${entity.methodId }"/>
            							<input id="deliveryCounts" type="hidden" name="deliveryCounts" value="${entity.deliveryCounts }"/>
            							<input id="position" type="hidden" name="position" value="${entity.position }"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="110">仓库代码：</td>
	      								<td width="110">
	      								    <input id="warehouseId" type="text" name="warehouseId" value="${entity.warehouseId }" readonly="readonly"/>
		          						</td>
										<td align="right" width="110">仓库名称：</td>     
            							<td width="110"> 
            								 <input id="warehouseName" type="text" name="warehouseName" value="${entity.warehouseName }" readonly="readonly"/>
										</td>
										<td align="right" width="110">交割数量：</td>     
            							<td width="110"> 
            								 <input id="deliveryQuatity" type="text" name="deliveryQuatity" value="${entity.deliveryQuatity }" readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="110">单位：</td>
	      								<td width="110">
	      								    <input id="unit" type="text" name="unit" value="${entity.unit }" readonly="readonly"/>
		          						</td>
		          						<td align="right" width="110">申请日期：</td>     
            							<td width="110"><input type="hidden" value="${applyDate }" id="applytime"/>
            								 <input id="applyDate" type="text" name="applyDate" value="" disabled="disabled"/>
										</td>
										<td align="right" width="110">提货日期：</td>     
            							<td width="110"> <input type="hidden" value="${deliveryDate }" id="picktime"/>
            								 <input id="deliveryDate" type="text" name="deliveryDate" value="" disabled="disabled"/>
										</td>
										
							        </tr> 
							        <c:if test="${flag == 'pickup'}"> 
							        <tr>
        			 					<td align="right" width="110">身份证号：</td>
	      								<td width="110">
	      								    <input id="idcardNum" type="text" name="idcardNum" value="${detail.idcardNum }" readonly="readonly"/>
	      								    <input id="pickupPassword" type="hidden" name="pickupPassword" value="${detail.pickupPassword }" readonly="readonly"/>
		          						</td>
										<td align="right" width="110">仓库可用数量：</td>     
            							<td width="110"> 
            							<input id="stock" type="text" name="stock" value="${stock }" >
            							<input id="pickupId" type="hidden" name="pickupId" value="${detail.pickupId }" >
										</td>
										<td align="right" width="110">审核意见：</td>
	      								<td>
	      								 <select id="approvalStatus" name="approvalStatus" style="width:140px">
												<option value=""></option>
											    <option value="002001">通过</option>
												<option value="002002">驳回</option>
										   </select> <span class="required">*</span> 
										</td>
							        </tr> 
							        </c:if>
							        <c:if test="${flag == 'express'}">
							          <tr>
        			 					<td align="right" width="110">配送地址：</td>
	      								<td width="110">
	      								    <input id="address" type="text" name="address" value="${detail.address }" readonly="readonly"/>
		          						</td>
										<td align="right" width="110">收货人：</td>     
            							<td width="110"> 
            								 <input id="receiver" type="text" name="receiver" value="${detail.receiver }" readonly="readonly"/>
										      <input id="cost" type="hidden" name="cost" value="${detail.cost }" readonly="readonly"/>
									
										</td>
										<td align="right" width="110">联系电话：</td>     
            							<td width="110"> 
            								 <input id="tel" type="text" name="tel" value="${detail.tel }" readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
							            <td align="right" width="90">仓库可用数量：</td>     
            							<td width="110">
            							<input id="stock" type="text" name="stock" value="${stock }" >
            							<input id="expressId" type="hidden" name="expressId" value="${detail.expressId }" >
            							</td>
							            <td align="right" width="110">审核意见：</td>
	      								<td>
	      								 <select id="approvalStatus" name="approvalStatus" style="width:140px">
												<option value=""></option>
											    <option value="002001">通过</option>
												<option value="002002">驳回</option>
										   </select> <span class="required">*</span> 
										</td>
        			 					<td align="right" width="110"></td>
	      								<td width="110">
	      								</td>
							        </tr> 
							        </c:if>
							         <tr>
        			 					<td align="right" width="110">备注：</td>
	      								<td colspan="5">
	      								<textarea id="remarks" name="remarks" style="width: 675px;" rows="5"></textarea>
<!-- 	      								 <input  type="text"  style="width: 675px;"> -->
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
								    	<input type="button" value="提交" onclick="updateDelivery()" class="anniu_btn"/>
									&nbsp;&nbsp;
									<input type="button" value="返回" onclick="returntoList()" class="anniu_btn"/>
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
