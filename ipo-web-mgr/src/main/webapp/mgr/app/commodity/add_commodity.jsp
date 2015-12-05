<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
		<style type="text/css">input {line-height: 14px;}</style>
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		<title>商品新增</title>
		<script type="text/javascript"> 
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
	       },
	       onSelect:function (date){
	          var last=new Date($('#lasttradate').datebox('getValue'));
	          var list=new Date($('#listingdate').datebox('getValue'));
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
	        	  var last=new Date($('#lasttradate').datebox('getValue'));
		          var list=new Date($('#listingdate').datebox('getValue'));
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
	                },
	                onSelect:function (date){
	                  var stime=new Date($('#starttime').datebox('getValue'));
	   		          var etime=new Date($('#endtime').datebox('getValue'));
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
	                  var stime=new Date($('#starttime').datebox('getValue'));
	   		          var etime=new Date($('#endtime').datebox('getValue'));
	   		    	   if (etime < stime) {
	   		               alert('结束日期小于开始日期');
	   		               $('#endtime').datebox('setValue', '').datebox('showPanel');
	   		           } 	
	   	     	}
	            });  
	        });	
		 
function addComm(){
	var curstatus=$("#currstatus").val();
	var publishalgr=$("#publishalgr").val();
	var nonissuereg=$("#nonissuereg").val();
	var mapperid=$("#mapperid").val();
	var pubmemberid=$("#pubmemberid").val();
	var commid=$("#commodityid").val();
	var flag= $('#frm').form('validate');
	if(curstatus!=''&&publishalgr!=''&&nonissuereg!=''&&mapperid!=''&&pubmemberid!=''&&flag==true){ 
		 $.ajax({  
			 type: 'GET',  
		      url: "<%=request.getContextPath()%>/BreedController/findExsitCommIds",  
		     contentType: "application/json; charset=utf-8", 
		     data:{"commodityid":commid,"randnum":Math.floor(Math.random()*1000000)},  
			 dataType: 'json',  
		     success : function(data, stats) { 
			           if(data=='0'){
			        	   alert("商品代码已存在，请重新输入！")
			           }
                       if(data=='1'){
                    	   $.ajax({ 
                               type: "post",  
                               url: "<%=request.getContextPath()%>/BreedController/addCommodity",       
                               data: $("#frm").serialize(),      
                               success: function(data) { 
                            	   if(data=='true'){
                                   alert("添加成功！"); 
                                   returntoList();
                            	   }else{
                            		   alert("系统异常，请联系管理员");  
                            	   }
                               },  
                               error: function(data) {  
                                   alert("系统异常，请联系管理员");  
                               }  
                           }) ;
			           }
                       if(data=='2'){
                    	   alert("系统内部异常,请联系管理员！")
			           }
			        }    
				});
	}else{
					alert("所有参数必填！");
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
   	
</script>
</head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : 商品增加</div>
		<div class="content" style="color: red">   手续费算法：百分比按货款计算手续费，绝对值按数量计算手续费  </div>
	</div>
	<table border="0"  height="100%" width="100%"  align="center" >
		<tr>
			<td style="margin-top: 50px;">
				<form id="frm" name="frm" action="" method="POST" enctype="mutipart/form-data">
				<fieldset>
				<legend class="common"><b>设置商品信息</b></legend>
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
					                    <td><hr width="715" class="pickList"/></td>
					                    <td ><img id="baseinfo_img" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" style="cursor:hand" onclick=""/></td>
					            	</tr>
					         	</table>
					         	</legend>
								<span id="baseinfo">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								      <tr>
        								<input type="hidden" id="breedid" name="breedid" value="${entity.breedid }"/>   
        	  							<td align="right">商品品种：</td>
            							<td>
            							<input id="breedname" value="${entity.breedname }"
            								class="easyui-textbox" data-options="required:true"  style="width: 60; background-color:gray"  readonly="readonly"/>          
			  								<span class="required">&nbsp;</span>   
            							</td>    
        								<td align="right" ></td> 
            							<td> 
            							</td>
            							<td align="right"></td>
										<td>
										</td>
        							</tr>
									<tr>
        	  							<td align="right">商品名称：</td>
            							<td><input id="commodityname" name="commodityname" value=""
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"  style="width: 60"/>          
            							</td>    
        								<td align="right" >商品代码：</td> 
            							<td> 
			  							<input id="commodityid" name="commodityid" value=""
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"  style="width: 60"/>          
            							</td>
            							<td align="right">当前状态</td>
										<td>
										<select id="currstatus" name="currstatus" style="width:80">
												<option value=""></option>
											    <option value="0">有效</option>
												<option value="1">暂停交易</option>
										   </select>
										</td>
        							</tr>
							        <tr>
							            <td align="right" >开市指导价：</td>
            							<td >
            							<input id="supervisedprice" name="supervisedprice" value=""
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" onkeypress="return onlyNumberInput()" style="width: 60"/>
							            </td>        
							            <td align="right">上市日期：</td>
							            <td>
			  							<input type="text" id="listingdate" name="listingdate" value="" ></input>       
            							</td>
            							<td align="right">最后交易日：</td>
            							<td>
										<input type="text" id="lasttradate" name="lasttradate" value=""></input> 
								      	</td>
        							</tr> 
									<tr>
										<td align="right">发行价：</td>
            							<td>
			  							<input type="text" id="price" name="price"  value=""
			  									style="ime-mode:disabled; width: 80" onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"/>          
            							</td>
            							<td align="right">发售单位</td>
            							<td>
            							<input type="text" id="units" name="units"  value=""
			  									style="ime-mode:disabled; width: 80"  class="easyui-validatebox numberbox" data-options="required:true,missingMessage:'必填项(500或500的整数倍)',min:0,precision:2"/>          
            							</td>
            							<td align="right">对应现货商品</td>
										<td>
										<select id="mapperid" name="mapperid" style="width:100">
								            		<option value="">请选择</option>
                                                    <c:forEach var="Tcomm" items="${Tlist}">
                                                      <option value="${Tcomm.commodityid}">${Tcomm.name}</option>
                                                    </c:forEach>
								         </select>
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
					       		<legend>
					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common">
					           		<col width="55"></col><col></col><col width="6"></col>
					         		<tr>
					              		<td><b>基本参数</b></td>
					                    <td><hr width="715" class="pickList"/></td>
					                    <td ><img id="baseinfo_img2" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" style="cursor:hand" onclick=""/></td>
					             	</tr>
					         	</table>
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr>
        	  							<td align="right">交易单位：</td>
            							<td><input id="contractfactor" name="contractfactor" value="${entity.contractfactor }"   readonly="readonly"
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"  style="width: 60; background-color: C0C0C0"  />          
			  								<span id="span_contractFactor"  class="required">
			  									<c:if test="${entity.contractfactorname!=null}">(${entity.contractfactorname}/批)</c:if>
			  									<c:if test="${entity.contractfactorname==null}">如(吨/批)</c:if>
			  								</span> 
			  								<input type="hidden" id="contractfactorname" name="contractfactorname" value="${entity.contractfactorname }" />
            							</td>    
        								<td align="right"></td>
            							<td></td>
            							<td align="right"></td>
            							<td></td>
        							</tr>
									<tr>
            							<td align="right">T+N交易天数：</td>
										<td>
										<input type="text" id="tradedays" name="tradedays" value="${entity.tradedays }" 
			  									class="easyui-validatebox numberbox" data-options="required:true,missingMessage:'必填项',min:0,max:9,invalidMessage:'请输入1-9的整数'"  style="ime-mode:disabled; width: 80" />          
										</td>
										<td align="right">是否开启标码提货：</td>
										<td>
										<select id="codedelivery" name="codedelivery" style="width:80">
											    <option value="0">开启</option>
												<option value="1" selected>关闭</option>
										   </select>
										</td>
										<td align="right">非发行注册：</td>
										<td>
										<select id="nonissuereg" name="nonissuereg" style="width:80">
										        <option value=""></option>
											    <option value="0">是</option>
												<option value="1">否</option>
										   </select>
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
					       		<legend>
					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common">
					           		<col width="55"></col><col></col><col width="6"></col>
					         		<tr>
					              		<td><b>发行参数</b></td>
					                    <td><hr width="715" class="pickList"/></td>
					                    <td ><img id="baseinfo_img2" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" style="cursor:hand" onclick=""/></td>
					             	</tr>
					         	</table>
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
								    <tr>
        	  							<td align="right">发行会员编号：</td>
            							<td>
            							<select id="pubmemberid" name="pubmemberid" style="width:100">
								            		<option value="">请选择</option>
                                                    <c:forEach var="pubmember" items="${Blist}">
                                                      <option value="${pubmember.brokerid}">${pubmember.name}</option>
                                                    </c:forEach>
								            	</select>
            							</td>    
        								<td align="right" >发行开始日期：</td> 
            							<td> 
			  								<input type="text" id="starttime" name="starttime" value=""></input> 
			  							</td>
            							<td align="right">发行结束日期：</td>
										<td>
											<input type="text" id="endtime" name="endtime" value=""></input> 
										</td>
        							</tr>
									<tr>
        	  							<td align="right">最小申购数量：</td>
            							<td><input id="minapplynum" name="minapplynum" value="${entity.minapplynum }"
            								 class="easyui-validatebox numberbox" data-options="required:true,missingMessage:'必填项',min:0,max:9999999999,invalidMessage:'请填入10位以内的正整数！'"  style="width: 60"/>          
            							</td>    
        								<td align="right" >最大申购数量：</td> 
            							<td> 
			  								<input id="maxapplynum" name="maxapplynum"  value="${entity.maxapplynum }"
			  									style="ime-mode:disabled; width: 60" class="easyui-validatebox numberbox" data-options="required:true,missingMessage:'必填项',min:0,invalidMessage:'请填入32位以内的正整数！'"/>
            							</td>
            							<td align="right">最小申购变动量：</td>
										<td>
										<input id="minapplyquamove" name="minapplyquamove"  value="${entity.minapplyquamove }"
			  									style="ime-mode:disabled; width: 60" class="easyui-validatebox numberbox" data-options="required:true,missingMessage:'必填项',min:0,max:99999999,invalidMessage:'请填入8位以内的正整数！'"/>
										</td>
        							</tr>
							        <tr>
							            <td align="right" >发行手续费算法：</td>
							            <td >
											<select id="publishalgr" name="publishalgr" style="width:80" onchange="on_change()">
												<option value=""></option>
											    <option value="1" <c:if test="${entity.publishalgr==1 }">selected</c:if>>按百分比</option>
												<option value="2" <c:if test="${entity.publishalgr==2 }">selected</c:if>>按绝对值</option>
										   </select> <span class="required">*</span>            
							            </td>        
							            <td align="right">交易商发行手续费比例：</td>
							            <td>
			  								<input id="dealerpubcharatio" name="dealerpubcharatio" maxlength="10" value="${entity.dealerpubcharatio }"
			  									style="ime-mode:disabled; width: 60" onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"/>
			  								<span id="dealerpubcharatioPercent">%</span>          
            							</td>
            							<td align="right">交易商发行手续费市场留存比例：</td>
            							<td>
											<input id="mktdeapubcharatio" name="mktdeapubcharatio" maxlength="10" value="${entity.mktdeapubcharatio }"
												style="ime-mode:disabled; width: 70" onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"/>
											<span id="mktdeapubcharatioPercent">%</span>          
								      	</td>
								      	<td>&nbsp;</td>
								      	<script type="text/javascript">
							            	if ("${entity.publishalgr}" == "1"){$("#dealerpubcharatioPercent").show();$("#mktdeapubcharatioPercent").show();} else {$("#dealerpubcharatioPercent").hide();$("#mktdeapubcharatioPercent").hide();}
							            </script>
        							</tr> 
									<tr>
										<td align="right">发行数量：</td>
            							<td>
            							<input type="text" id="counts" name="counts"  value=""
			  									style="ime-mode:disabled; width: 80" class="easyui-validatebox numberbox" data-options="required:true,missingMessage:'必填项',min:0,invalidMessage:'请填入32位以内的正整数！'"/>          
            							</td>
            							<td align="right">发行商发行手续费比例：</td>
            							<td>
			  								<input type="text" id="publishercharatio" name="publishercharatio" value="${entity.publishercharatio }" 
			  									onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"  style="ime-mode:disabled; width: 80" />  
			  								<span id="publishercharatioPercent">%</span>        
            							</td>
            							<td align="right">发行商发行手续费市场留存比例：</td>
										<td>
										<input type="text" id="mktpubcharatio" name="mktpubcharatio" value="${entity.mktpubcharatio }" 
			  									onkeypress="return onlyNumberInput()" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'"  style="ime-mode:disabled; width: 80" />          
										<span id="mktpubcharatioPercent">%</span>
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
 
						<tr>
							<td colspan="4" height="3">	
						</td>
						</tr>                   
						<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								    	<input type="button" value="添加" onclick="addComm()" className="anniu_btn"  id="add"/>
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
