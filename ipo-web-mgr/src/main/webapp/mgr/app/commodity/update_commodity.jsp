<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
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
		<title>商品修改</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		
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
		     $("#listingdate").datebox({
		    	 editable: false,
		         required: true,
		         missingMessage: "必填项",
		         formatter: function (date) {
		         var y = date.getFullYear();
		         var m = date.getMonth() + 1;
		         var d = date.getDate();
		         return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		       } ,
		       onSelect:function (date){
		    	   
			          var last=parseISO8601($('#lasttradate').datebox('getValue'));
			          var list=parseISO8601($('#listingdate').datebox('getValue'));
			    	   if (last < list) {
			               alert('结束日期小于开始日期');
			               $('#listingdate').datebox('setValue', '').datebox('showPanel');
			           } 
			       }
		      });

		      $("#lasttradate").datebox({
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
		  		               alert('结束日期小于开始日期');
		  		               $('#lasttradate').datebox('setValue', '').datebox('showPanel');
		  		           } 
		  	     	}
		       });

              $("#starttime").datebox({
            	        editable: false,
 		                required: true,
		                missingMessage: "必填项",
		                formatter: function (date) {
		                    var y = date.getFullYear();
		                    var m = date.getMonth() + 1;
		                    var d = date.getDate();
		                    return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		                } ,
		                onSelect:function (date){
			                  var stime=parseISO8601($('#starttime').datebox('getValue'));
			   		          var etime=parseISO8601($('#endtime').datebox('getValue'));
			   		    	   if (etime < stime) {
			   		               alert('结束日期小于开始日期');
			   		               $('#starttime').datebox('setValue', '').datebox('showPanel');
			   		           } 	
			   	     	} 
		            });
		          
              $("#endtime").datebox({
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
		                  var stime=parseISO8601($('#starttime').datebox('getValue'));
		   		          var etime=parseISO8601($('#endtime').datebox('getValue'));
		   		    	   if (etime < stime) {
		   		               alert('结束日期小于开始日期');
		   		               $('#endtime').datebox('setValue', '').datebox('showPanel');
		   		           } 	
		   	     	} 
		            });  
              $("#warehousestartday").datebox({
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
	            
	            $("#insurancestartday").datebox({
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
	            
	            $("#deliverystartday").datebox({
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
             $("#listingdate").datebox("setValue",$("#listtime").val());
              $("#lasttradate").datebox("setValue",$("#lasttime").val());
              $("#starttime").datebox("setValue",$("#stime").val());
              $("#endtime").datebox("setValue",$("#etime").val()); 
              $("#deliverystartday").datebox("setValue",$("#deliverystart").val());
              $("#insurancestartday").datebox("setValue",$("#insurancestart").val());
              $("#warehousestartday").datebox("setValue",$("#warehousestart").val()); 
             /*  var arr1 = $("#stime").val().split("-");
              var date1=new Date(parseInt(arr1[0]),parseInt(arr1[1])-1,parseInt(arr1[2]),0,0,0); 
              var date2=new Date();
              if(date1.getTime()<date2.getTime()) {                               
            	  $("#starttime").attr("readonly","readonly");
            	  $("#endtime").attr("readonly","readonly");
            } */
		  });	
		
		
		
function updateComm(){
	var curstatus=$("#currstatus").val();
	var publishalgr=$("#publishalgr").val();
	var tradealgr=$("#tradealgr").val();
	var mapperid=$("#mapperid").val();
	var pubmemberid=$("#pubmemberid").val();
	var flag= $('#frm').form('validate');
	if(curstatus!=''&&publishalgr!=''&&tradealgr!=''&&mapperid!=''&&pubmemberid!=''&&flag==true){ 
		var units=$("#units").val();
		var contractfactor=$("#contractfactor").val();
		var counts=$("#counts").val();
		if(units % contractfactor !=0   ){
			alert("配售单位应为交易单位的整数倍！");
			return ;
		}
		if(counts%contractfactor!=0){
			alert("发行量必须为配售单位的整数倍！")
			return;
		}
		 $.ajax({ 
			 cache:false,
             type: "POST",  
             url: "<%=request.getContextPath()%>/BreedController/updateCommodity",   
             data:$("#frm").serialize(),  
             success: function(data) { 
          	   if(data=='success'){
                 alert("修改成功！"); 
                 returntoList();
          	   }else{
          		   alert("系统异常，请联系管理员");  
          	   }
             }
         }); 
	}else if(mapperid ==''){
		alert("请选择对应现货商品！");
		return;
	}else if(curstatus ==''){
		alert("请选择当前状态！");
		return;
	}else if(pubmemberid ==''){
		alert("请选择发行会员编号！");
		return;
	}else if(publishalgr ==''){
		alert("请选择发行手续费算法！");
		return;
	}else if(tradealgr ==''){
		alert("请选择申购手续费算法！");
		return;
	}
}

function returntoList(){
	var breedid=$("#breedid").val();
	var backUrl="<%=request.getContextPath()%>/IpoController/CommodityList?breedID="+breedid+"&&randnum="+Math.floor(Math.random()*1000000);
	document.location.href = backUrl;
}
		
function onlyNumberInput(){
	 if (event.keyCode<46 || event.keyCode>57 || event.keyCode == 47){
		    event.returnValue=false;
	 }
}

function on_change(){
	if (document.getElementById("publishalgr").value == "1") {
		$("#dealerpubcharatioPercent").show();
		$("#mktdeapubcharatioPercent").show();
		$("#publishercharatioPercent").show();
		$("#mktpubcharatioPercent").show();
	}else {
		$("#dealerpubcharatioPercent").hide();
		$("#mktdeapubcharatioPercent").hide();
		$("#publishercharatioPercent").hide();
		$("#mktpubcharatioPercent").hide();
	}
}

function changeTail(){
	$("#tail").html("批/"+$("#deliveryunit").val());
}

function on_tchange(){
	if (document.getElementById("tradealgr").value == "1") {
		$("#buyPercent").show();
		$("#sellPercent").show();
		$("#mktbuyPercent").show();
		$("#mktsellPercent").show();
	}else {
		$("#buyPercent").hide();
		$("#sellPercent").hide();
		$("#mktbuyPercent").hide();
		$("#mktsellPercent").hide();
	}
}
</script>
</head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : 商品修改</div>
		<div class="content" style="color: red">    手续费算法：百分比按货款计算手续费，绝对值按数量计算手续费              提货单费用价格提前天数：仓单交收费用计算平均价取前n天的平均价  </div>
	</div>
	<table border="0" width="100%">
		<tr>
			<td valign="top">
				<form id="frm" name="frm" action="" method="POST">
				<fieldset>
				<legend class="common"><b>设置商品信息</b></legend>
				<span id="baseinfo9">
				<table width="850" border="0" align="center"  class="common" cellpadding="0" cellspacing="2">
					<!-- 基本信息 -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					          	<legend>基本信息
<!-- 					           	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common"> -->
<!-- 					            	<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					               	<tr> -->
<!-- 					                 	<td><b>基本信息</b></td> -->
<!-- 					                    <td><hr width="100%" class="pickList"/></td> -->
<!-- 					            	</tr> -->
<!-- 					         	</table> -->
					         	</legend>
								<span id="baseinfo">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								      <tr>
        								<input type="hidden" id="breedid" name="breedid" value="${entity.breedid }"/>   
        								<input type="hidden" id="status" name="status" value="${entity.status }"/>   
        								<input type="hidden" id="codedelivery" name="codedelivery" value="${entity.codedelivery }"/>   
        								<input type="hidden" id="deliveryProp" name="deliveryProp" value="${entity.deliveryProp }"/>   
        							</tr>
									<tr>
        	  							<td align="right">商品名称：</td>
            							<td><input id="commodityname" name="commodityname" value="${entity.commodityname }"
            								class="easyui-validatebox textbox" data-options="required:true"  style="width: 100; background-color: gray" readonly="readonly"/>          
            							</td>    
        								<td align="right" >商品代码：</td> 
            							<td> 
			  							<input id="commodityid" name="commodityid" value="${entity.commodityid }"
            								class="easyui-validatebox textbox" data-options="required:true"  style="width: 100; background-color: gray" readonly="readonly"/>          
            							</td>
            							<td align="right">对应现货商品</td>
										<td>
										<c:set var='mappercomm' value="${entity.mapperid}" ></c:set>
										<input type="hidden" id="mapperid" name="mapperid" value="${entity.mapperid}">
                                        <input type="text" style="width: 100;" value="<c:forEach var="Tcomm" items="${Tlist}"><c:if test="${Tcomm.commodityid eq mappercomm}">${Tcomm.commodityid}${Tcomm.name}</c:if> </c:forEach>"  />
										 <span class="required">*</span>  
										</td> 
        							</tr>
							        <tr>
							            <td align="right">商品品种：</td>
            							<td>
            							<input id="breedname" value="${breedname }"
            								class="easyui-textbox" data-options="required:true"  style="width: 100; background-color: gray"  readonly="readonly"/>          
			  								<span class="required">&nbsp;</span>   
            							</td>
							            <td align="right">当前状态：</td>
										<td>
										<select id="currstatus" name="currstatus" style="width:100">
												<option value="">请选择</option>
											    <option value="0" <c:if test="${entity.currstatus==0 }">selected</c:if>>有效</option>
												<option value="1" <c:if test="${entity.currstatus==2 }">selected</c:if>>暂停交易</option>
										   </select>
										 <span class="required">*</span>  
										</td>     
							            <td align="right">上市日期：</td>
							            <td><input type="hidden" id="listtime" value="${listing }">
			  								<input  type="text" id="listingdate"   name="listingdate"  style="width: 100"></input>       
            							 <span class="required">*</span>  
            							</td>
        							</tr> 
									<tr>
										<td align="right">发行价：</td>
            							<td>
			  							<input type="text" id="price" name="price"  value="${entity.price }"  readonly="readonly"
			  									style="ime-mode:disabled; width: 100; background-color: gray" class="easyui-numberbox" data-options="required:true,min:0,precision:2,missingMessage:'请输入精度为2的正数'"/>          
            						   <span class="required">(元/批)*</span>  
            							</td>
            							<td align="right">发售单位：</td>
            							<td>
            							<input type="text" id="units" name="units"  value="${entity.units }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正整数',min:0"/>          
            							 <span class="required">(批/单位)*</span>  
            							</td>
            							<td align="right">最后交易日：</td>
            							<td><input type="hidden" id="lasttime" value="${lasttrade }">
										<input  type="text" id="lasttradate"   name="lasttradate" value="" style="width: 100"></input> 
								        <span class="required">*</span>  
								      	</td>
         							</tr>
	 							</table >
								</span>
						    	</fieldset>
							</td>
						</tr>
						<!-- 参数信息 -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>基本参数
<!-- 					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common"> -->
<!-- 					           		<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					         		<tr> -->
<!-- 					              		<td><b>基本参数</b></td> -->
<!-- 					                    <td><hr width="100%" class="pickList"/></td> -->
<!-- 					             	</tr> -->
<!-- 					         	</table> -->
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left"  class="common">   
									<tr>
        	  							<td align="right">交易单位：</td>
            							<td><input id="contractfactor" name="contractfactor" value="${entity.contractfactor }" readonly="readonly"
            								class="easyui-numberbox" data-options="required:true,missingMessage:'必填项'"  style="width: 100;"  />          
			  								<span id="span_contractFactor"  class="required">
			  									<c:if test="${entity.contractfactorname!=null}">(${entity.contractfactorname}/批)</c:if>
			  									<c:if test="${entity.contractfactorname==null}">如(吨/批)</c:if>
			  								</span> <span class="required">*</span>   
			  								<input type="hidden" id="contractfactorname" name="contractfactorname" value="${entity.contractfactorname }" />
            							</td> 
        								<td align="right">T+N交易天数：</td>
										<td>
										<input type="text" id="tradedays" name="tradedays" value="${entity.tradedays }"  
			  									class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正整数',min:0,precision:0"  style="ime-mode:disabled; width: 100" />          
										 <span class="required">*</span>  
										</td>
										<td align="right">是否非发行注册</td>
            							<td>
            							<select id="nonissuereg" name="nonissuereg" style="width:100">
												<option value="">请选择</option>
											    <option value="0" <c:if test="${entity.nonissuereg==0 }">selected</c:if>>是</option>
												<option value="1" <c:if test="${entity.nonissuereg==1 }">selected</c:if>>否</option>
										   </select>
										   <span class="required">*</span>
            							</td>
        							</tr>
	 							</table >
								</span>
								</fieldset>
						 	</td>
						</tr>

						<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>发行参数
<!-- 					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common"> -->
<!-- 					           		<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					         		<tr> -->
<!-- 					              		<td><b>发行参数</b></td> -->
<!-- 					                    <td><hr width="100%" class="pickList"/></td> -->
<!-- 					             	</tr> -->
<!-- 					         	</table> -->
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								    <tr>
        	  							<td align="right">发行会员编号：</td>
            							<td>
            							<c:set var='publisher' value="${entity.pubmemberid}" ></c:set>
            							<select id="pubmemberid" name="pubmemberid" style="width:100">
								            		<option value="">请选择</option>
                                                    <c:forEach var="pubmember" items="${Blist}">
                                                      <option value="${pubmember.brokerid}" <c:if test="${pubmember.brokerid eq publisher}">selected</c:if>>${pubmember.name}</option>
                                                    </c:forEach>
								            	</select> <span class="required">*</span>  
            							</td>  
            							<td align="right" >最大申购数量：</td> 
            							<td> 
			  								<input id="maxapplynum" name="maxapplynum"  value="${entity.maxapplynum }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请填入正整数',min:0"/>
            							 <span class="required">(批)*</span>  
            							</td>  
        								<td align="right" >发行开始日期：</td> 
            							<td> <input type="hidden" id="stime" value="${start }">
			  								<input type="text" id="starttime" name="starttime" style="width: 100" ></input> 
			  							 <span class="required">*</span>  
			  							</td>
            							
        							</tr>
									<tr>
        	  							<td align="right">最小申购数量：</td>
            							<td><input id="minapplynum" name="minapplynum" value="${entity.minapplynum }"
            								 class="easyui-numberbox" data-options="required:true,missingMessage:'请填入10位以内的正整数',min:0,max:9999999999"  style="width: 100"/>          
            							 <span class="required">(批)*</span>  
            							</td>    
            							<td align="right">最小申购变动量：</td>
										<td>
										<input id="minapplyquamove" name="minapplyquamove"  value="${entity.minapplyquamove }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请填入8位以内的正整数',min:0,max:99999999"/>
										 <span class="required">(批)*</span>  
										</td>
										<td align="right">发行结束日期：</td>
										<td>
										<input type="hidden" id="etime" value="${end }">
											<input type="text" id="endtime" name="endtime" value="" style="width: 100"></input> 
										 <span class="required">*</span>  
										</td>
        							</tr>
							        <tr>
							            <td align="right" >发行手续费算法：</td>
							            <td >
											<select id="publishalgr" name="publishalgr" style="width:100" onchange="on_change()">
												<option value="">请选择</option>
											    <option value="1" <c:if test="${entity.publishalgr==1 }">selected</c:if>>按百分比</option>
												<option value="2" <c:if test="${entity.publishalgr==2 }">selected</c:if>>按绝对值</option>
										   </select> <span class="required">*</span>            
							            </td>        
							            <td align="right">交易商发行手续费比例：</td>
							            <td>
			  								<input id="dealerpubcharatio" name="dealerpubcharatio" maxlength="10" value="${entity.dealerpubcharatio }"
			  									style="ime-mode:disabled; width: 100" onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'请输入正数'"/>
			  								<span id="dealerpubcharatioPercent">%</span> <span class="required">*</span>           
            							</td>
            							<td align="right">交易商发行手续费市场留存比例：</td>
            							<td>
											<input id="mktdeapubcharatio" name="mktdeapubcharatio" maxlength="10" value="${entity.mktdeapubcharatio }"
												style="ime-mode:disabled; width: 100" onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'请输入正数'"/>
											<span id="mktdeapubcharatioPercent">%</span>  <span class="required">*</span>           
								      	</td>
								      	<td>&nbsp;</td>
								      	<script type="text/javascript">
							            	if ("${entity.publishalgr}" == "1"){$("#dealerpubcharatioPercent").show();$("#mktdeapubcharatioPercent").show();} else {$("#dealerpubcharatioPercent").hide();$("#mktdeapubcharatioPercent").hide();}
							            </script>
        							</tr> 
									<tr>
										<td align="right">发行数量：</td>
            							<td>
            							<input type="text" id="counts" name="counts"  value="${entity.counts }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正数',min:0,max:999999999"/>          
            							 <span class="required">(批)*</span>  
            							</td>
            							<td align="right">发行商发行手续费比例：</td>
            							<td>
			  								<input type="text" id="publishercharatio" name="publishercharatio" value="${entity.publishercharatio }" 
			  									onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'请输入正数'"  style="ime-mode:disabled; width: 100" />  
			  								<span id="publishercharatioPercent">%</span>  <span class="required">*</span>         
            							</td>
            							<td align="right">发行商发行手续费市场留存比例：</td>
										<td>
										<input type="text" id="mktpubcharatio" name="mktpubcharatio" value="${entity.mktpubcharatio }" 
			  									onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'请输入正数'"  style="ime-mode:disabled; width: 100" />          
										<span id="mktpubcharatioPercent">%</span> <span class="required">*</span>  
										</td>
										<td>&nbsp;</td>
								      	<script type="text/javascript">
							            	if ("${entity.publishalgr}" == "1"){$("#publishercharatioPercent").show();$("#mktpubcharatioPercent").show();} else {$("#publishercharatioPercent").hide();$("#mktpubcharatioPercent").hide();}
							            </script>
         							</tr>
	 							</table >
								</span>
								</fieldset>
						 	</td>
						</tr>
 
 	<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>交易参数
<!-- 					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common"> -->
<!-- 					           		<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					         		<tr> -->
<!-- 					              		<td><b>交易参数</b></td> -->
<!-- 					                    <td><hr width="100%" class="pickList"/></td> -->
<!-- 					             	</tr> -->
<!-- 					         	</table> -->
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								    <tr>
        	  							<td align="right">申购手续费算法：</td>
            							<td>
            							<select id="tradealgr" name="tradealgr" style="width:100" onchange="on_tchange()">
												<option value="">请选择</option>
											    <option value="1" <c:if test="${entity.tradealgr==1 }">selected</c:if>>按百分比</option>
												<option value="2" <c:if test="${entity.tradealgr==2 }">selected</c:if>>按绝对值</option>
										   </select> <span class="required">*</span>  
            							</td>
            							<td align="right" >买入：</td> 
            							<td> 
			  								<input id="buy" name="buy"  value="${entity.buy }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正数',min:0,precision:2"/>
            							<span id="buyPercent">%</span> <span class="required">*</span> 
            							</td>    
        								<td align="right">买方手续费市场留存比例：</td>
										<td>
										<input id="mktbuyfeeradio" name="mktbuyfeeradio"  value="${entity.mktbuyfeeradio }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正数',min:0,precision:2"/>
										<span id="mktbuyPercent">%</span> <span class="required">*</span> 
										</td>
        							</tr>
									
							        <tr>
							            <td align="right" >仓储日租金标准：</td>
							            <td >
											<input id="warehousedailyrent" name="warehousedailyrent" value="${entity.warehousedailyrent }" 
											style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正数',min:0,precision:2"/>
										    <span class="required">*</span>         
							            </td>        
							            <td align="right">仓储日租金收取起始日期：</td>
							            <td>
							              <input type="hidden" id="warehousestart" value="${warehousestart }">
			   				                 <input type="text" id="warehousestartday" name="warehousestartday" style="width: 100"></input> 
			  								 <span class="required">*</span>          
            							</td>
            							<td align="right">日托管费标准：</td>
            							<td>
											<input id="trusteedailyrent" name="trusteedailyrent" value="${entity.trusteedailyrent }" 
											style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正数',min:0,precision:2"/>
										    <span class="required">*</span>       
								      	</td>
        							</tr> 
									<tr>
										<td align="right">日保险费标准：</td>
            							<td>
            							<input id="insurancedailyrent" name="insurancedailyrent" value="${entity.insurancedailyrent }" 
											style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正数',min:0,precision:2"/>
										    <span class="required">*</span>
            							</td>
            							<td align="right">日保险费收取起始日期：</td>
            							<td>
            							<input type="hidden" id="insurancestart" value="${insurancestart }">
			  								 <input type="text" id="insurancestartday" name="insurancestartday" style="width: 100"></input> 
			  								 <span class="required">*</span>           
            							</td>
            							<td align="right">免托管天数：</td>
										<td>
										<input type="text" id="freetrusteedays" name="freetrusteedays" value="${entity.freetrusteedays }" 
			  									onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'请填入正整数'"  style="ime-mode:disabled; width: 100" />          
										<span class="required">*</span> 
										</td>
										<td>&nbsp;</td>
								      	<script type="text/javascript">
							            	if ("${entity.tradealgr}" == "1"){$("#buyPercent").show();$("#sellPercent").show();$("#mktbuyPercent").show();$("#mktsellPercent").show();} else {$("#sellPercent").hide();$("#buyPercent").hide();$("#mktbuyPercent").hide();$("#mktsellPercent").hide();}
							            </script>
         							</tr>
	 							</table >
								</span>
								</fieldset>
						 	</td>
						</tr>
						
							<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>交收参数
<!-- 					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common"> -->
<!-- 					           		<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					         		<tr> -->
<!-- 					              		<td><b>交收参数</b></td> -->
<!-- 					                    <td><hr width="100%" class="pickList"/></td> -->
<!-- 					             	</tr> -->
<!-- 					         	</table> -->
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								    <tr>
        	  							<td align="right">交割单位：</td>
            							<td>
            							<input id="deliveryunit" name="deliveryunit" value="${entity.deliveryunit }"    style="width:100"  onblur="changeTail()"/>
											 <span class="required">如箱、吨等*</span>  
            							</td>
            							<td align="right" >交割与交易单位换算：</td> 
            							<td> 
			  								<input id="deliunittocontract" name="deliunittocontract"  value="${entity.deliunittocontract }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请输入正数',min:0,precision:2"/>
            							<span class="required"><span id="tail">批/<c:out value="${entity.deliveryunit }"></c:out></span>*</span>  
            							</td>    
        								<td align="right" >交货开始日期：</td> 
            							<td> 
            							<input type="hidden" id="deliverystart" value="${deliverystart }">
            							 <input type="text" id="deliverystartday" name="deliverystartday" style="width: 100"></input> 
			  								 <span class="required">*</span> 
			  							</td>
        							</tr>									
	 							</table >
								</span>
								</fieldset>
						 	</td>
						</tr>
						
						
						<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>仓库参数
<!-- 					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common"> -->
<!-- 					           		<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					         		<tr> -->
<!-- 					              		<td><b>仓库参数</b></td> -->
<!-- 					                    <td><hr width="100%" class="pickList"/></td> -->
<!-- 					             	</tr> -->
<!-- 					         	</table> -->
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								    <tr>
        	  							<td align="right">注册费用比例：</td>
            							<td>
            							<input id="registfeeradio" name="registfeeradio" value="${entity.registfeeradio }"    style="width:100"/>
											 <span class="required">%*</span>  
            							</td>
            							<td align="right" >注销费用比例：</td> 
            							<td> 
			  								<input id="cancelfeeradio" name="cancelfeeradio"  value="${entity.cancelfeeradio }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请填入正数',min:0,precision:2"/>
            							<span class="required">%*</span> 
            							</td>    
        								<td align="right" >过户费用比例：</td> 
            							<td> 
            							 <input id="transferfeeradio" name="transferfeeradio"  value="${entity.transferfeeradio }"  
            							 style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请填入正数',min:0,precision:2"></input> 
			  								 <span class="required">%*</span> 
			  							</td>
        							</tr>
        							 <tr>
        	  							<td align="right">注册费市场留存比例：</td>
            							<td>
            							<input id="mktregistfeeradio" name="mktregistfeeradio" value="${entity.mktregistfeeradio }"   
            							style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请填入正数',min:0,precision:2"/>
											 <span class="required">%*</span>  
            							</td>
            							<td align="right" >注销费市场留存比例：</td> 
            							<td> 
			  								<input id="mktcancelfeeradio" name="mktcancelfeeradio"  value="${entity.mktcancelfeeradio }"
			  									style="ime-mode:disabled; width: 100" class="easyui-numberbox" data-options="required:true,missingMessage:'请填入正数',min:0,precision:2"/>
            							<span class="required">%*</span> 
            							</td>    
        								<td align="right" >提货单费用价格提前天数：</td> 
            							<td> 
            							 <input id="deliverycostbefore" name="deliverycostbefore"  value="${entity.deliverycostbefore }"  
            							 style="width: 100"></input> 
			  						   <span class="required">*</span> 
			  							</td>
        							</tr>										
	 							</table >
								</span>
								</fieldset>
						 	</td>
						</tr>
						
						
						<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>详细描述
<!-- 					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common"> -->
<!-- 					           		<col width="55"></col><col></col><col width="6"></col> -->
<!-- 					         		<tr> -->
<!-- 					              		<td><b>详细描述</b></td> -->
<!-- 					                    <td><hr width="100%" class="pickList"/></td> -->
<!-- 					             	</tr> -->
<!-- 					         	</table> -->
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								    <tr>
        	  							<td align="right">商品详细描述：</td>
            							<td colspan="5">
            							<textarea rows="3" cols="110" name="commdetails"><c:out value="${entity.commdetails}"></c:out></textarea>
			  							</td>
        							</tr>
	 							</table >
								</span>
								</fieldset>
						 	</td>
						</tr>
 
 
 
 
						<tr>
							<td colspan="4" height="3">	
						</td>
						</tr>                   
						<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								    	<input type="button" value="修改" onclick="updateComm()" className="anniu_btn"  id="update"/>
									&nbsp;&nbsp;
									<input type="button" value="返回" onclick="returntoList()" className="anniu_btn"  id="back"/>
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
