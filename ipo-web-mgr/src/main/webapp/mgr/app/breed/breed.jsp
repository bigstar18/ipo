<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<html>
	<head>
		<link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
		<script src="${publicPath }/js/jquery-1.6.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/static/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		<script src="${mgrPath }/app/ipo/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="UTF-8"></script>
		<script src="${mgrPath }/app/ipo/js/jquery.validationEngine.js" type="text/javascript" charset="UTF-8"></script>	
		<title>品种</title>
		<style type="text/css">
		<!--
		.yin {
			visibility:hidden;
			position:absolute;
			
		}
		.xian{
			visibility:visible;
		}
		-->
		</style>
		<script type="text/javascript"> 

		function addBreed(){
			var breedid=$("#breedid").val();
			var bname=$("#bname").val();
			var spreadalgr=$("#spreadalgr").val();
			var publishalgr=$("#publishalgr").val();
			if(bname!=''&&spreadalgr!= ''&& publishalgr!= ''){ 
			 $.ajax({  
				    type: 'GET',  
				    url: "<%=request.getContextPath()%>/BreedController/findExsitIds",  
				    contentType: "application/json; charset=utf-8", 
				    data:{"breedid":breedid},  
				    dataType: 'json',  
				    success : function(data, stats) { 
			           if(data=='0'){
			        	   alert("该品种已配置，请选择其他品种！")
			           }
                       if(data=='1'){
                    	$("#frm").attr("action","<%=request.getContextPath()%>/BreedController/addBreed");
               	     	$("#frm").submit();
			           }
                       if(data=='2'){
                    	   alert("系统内部异常！")
			           }
			        }    
				});  }
			else{
					alert("所有下拉框必选！");
				}
		}
		
		function updateBreed(){
			$("#frm").attr("action","<%=request.getContextPath()%>/BreedController/updateBreed");
	     	$("#frm").submit();
		}
		function returntoList(){
			var backUrl=document.getElementById('back').action;
			var url = "${basePath}"+backUrl;
			document.location.href = url;
			
		}
		
		function setReadOnly(obj)
		{
		  obj.readOnly = true;
		  obj.style.backgroundColor = "#C0C0C0";
		}
		function setReadWrite(obj)
		{
		  obj.readOnly = false;
		  obj.style.backgroundColor = "white";
		}
		function setDisabled(obj)
		{
		  obj.disabled = true;
		  obj.style.backgroundColor = "#C0C0C0";
		}
		function setEnabled(obj)
		{
		  obj.disabled = false;
		  obj.style.backgroundColor = "white";
		}
		function keyEnter(iKeyCode)
		{
		  var srcElement = window.event.srcElement;
		  /*
		  if(srcElement.name == "save" || iKeyCode==-1)
		  {
		    document.forms[0].submit();
		    return true;
		  }
		  */
		  if(iKeyCode != 13)
		  {
		    return false;
		  }
		  if ((srcElement.tagName == "INPUT" && srcElement.type != "button" &&
		       srcElement.type != "submit" && srcElement.type != "reset") ||
		       srcElement.tagName == "SELECT")
		  {
		    var i = 0;
		    while (srcElement != srcElement.form.elements[i])
		    {
		      i++;
		    } 
		    if(i == srcElement.form.elements.length-1)
		    {
		      return false;
		    }    
		    while (srcElement.form.elements[i+1].tagName == "FIELDSET")
		    {
		      i++;
		    } 
		    if(i == srcElement.form.elements.length-1)
		    {
		      return false;
		    } 
		    while (srcElement.form.elements[i+1].disabled || srcElement.form.elements[i+1].readOnly || srcElement.form.elements[i+1].type == "hidden")
		    {
		      i++;
		    } 

		    if(i == srcElement.form.elements.length-1)
		    {
		      return false;
		    }
		    
		    while (srcElement.form.elements[i+1].tagName == "FIELDSET")
		    {
		      i++;
		    } 
		    if(i == srcElement.form.elements.length-1)
		    {
		      return false;
		    }  
		        
		    if(srcElement.form.elements[i+1] != null)
		    {
		      srcElement.form.elements[i+1].focus();
		    }
		  }
		  return false;
		}
	


function chackValue(){
    if (event.keyCode==32)
    {
		 event.returnValue=false;
    }
}

function on_change(){
	if (document.getElementById("publishalgr").value == "1") {
		document.getElementById("dealerpubcharatioPercent").className = "xian";
		document.getElementById("mktdeapubcharatioPercent").className = "xian";
		document.getElementById("publishercharatioPercent").className = "xian";
		document.getElementById("mktpubcharatioPercent").className = "xian";

	}else {
		document.getElementById("dealerpubcharatioPercent").className = "yin";
		document.getElementById("mktdeapubcharatioPercent").className = "yin";
		document.getElementById("publishercharatioPercent").className = "yin";
		document.getElementById("mktpubcharatioPercent").className = "yin";
	}
}


//spreadAlgr_onchange()
function spreadAlgr_onchange(value)
{
	if (value == "1") {
		$("#spreadUpLmtPercent").show();
		$("#spreadDownLmtPercent").show();
	}else {
		$("#spreadUpLmtPercent").hide();
		$("#spreadDownLmtPercent").hide();
	}
}

//---------------------------start baseinfo-------------------------------

var tmp_baseinfo_up = true;
function baseinfo_onclick()
{
	if (tmp_baseinfo_up)
  {
    tmp_baseinfo_up = false;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Down.gif";
    $("#baseinfo_img").attr("src", src);
    $("#baseinfo").hide();
  }
  else
  {
    tmp_baseinfo_up = true;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Up.gif";
    $("#baseinfo_img").attr("src", src);
    $("#baseinfo").show();
  }
  
}
var tmp_baseinfo_up2 = true;
function baseinfo2_onclick()
{
  if (tmp_baseinfo_up2)
  {
    tmp_baseinfo_up2 = false;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Down.gif";
    $("#baseinfo_img2").attr("src", src);
    $("#baseinfo2").hide();
  }
  else
  {
    tmp_baseinfo_up2 = true;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Up.gif";
    $("#baseinfo_img2").attr("src", src);
    $("#baseinfo2").show();
  }
}

var tmp_baseinfo_up3 = true;
function baseinfo3_onclick()
{
  if (tmp_baseinfo_up3)
  {
    tmp_baseinfo_up3 = false;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Down.gif";
    $("#baseinfo_img3").attr("src", src);
    $("#baseinfo3").hide();
  }
  else
  {
    tmp_baseinfo_up3 = true;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Up.gif";
    $("#baseinfo_img3").attr("src", src);
    $("#baseinfo3").show();
  }
}

var tmp_baseinfo_up4 = true;
function baseinfo4_onclick()
{
  if (tmp_baseinfo_up4)
  {
    tmp_baseinfo_up4 = false;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Down.gif";
    $("#baseinfo_img4").attr("src", src);
    $("#baseinfo4").hide();
  }
  else
  {
    tmp_baseinfo_up4 = true;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Up.gif";
    $("#baseinfo_img4").attr("src", src);
    $("#baseinfo4").show();
  }
}

var tmp_baseinfo_upy = true;
function baseinfoy_onclick()
{
  if (tmp_baseinfo_upy)
  {
    tmp_baseinfo_upy = false;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Down.gif";
    $("#baseinfo_imgy").attr("src", src);
    $("#baseinfoy").hide();
  }
  else
  {
    tmp_baseinfo_upy = true;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Up.gif";
    $("#baseinfo_imgy").attr("src", src);
    $("#baseinfoy").show();
  }
}
//-----------------------------end baseinfo-----------------------------
//---------------------------start paraminfo-------------------------------
var tmp_paraminfo_up = true;
function paraminfo_onclick()
{
  if (tmp_paraminfo_up)
  {
    tmp_paraminfo_up = false;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Down.gif";
    $("#paraminfo_img").attr("src", src);
    $("#paraminfo").hide();
  }
  else
  {
    tmp_paraminfo_up = true;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Up.gif";
    $("#paraminfo_img").attr("src", src);
    $("#paraminfo").show();
  }
}

var tmp_paraminfo_up6 = true;
function paraminfo6_onclick()
{
  if (tmp_paraminfo_up6)
  {
    tmp_paraminfo_up6 = false;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Down.gif";
    $("#paraminfo_img6").attr("src", src);
    $("#paraminfo6").hide();
  }
  else
  {
    tmp_paraminfo_up6 = true;
    var src = "${skinPath}/image/app/timebargain/ctl_detail_Up.gif";
    $("#paraminfo_img6").attr("src", src);
    $("#paraminfo6").show();
  }
}

function changeManner(id, td1, td2, td3, step){ 
  var td1 = $("#"+td1);
  var td2 = $("#"+td2);
  if(id==1)
  {
   td1.html('保证金'+step+'：');
   td2.html('担保金'+step+'：');
   $("#"+td3).hide();
  }
  else if(id==2)
  {
	td1.html('买保证金'+step+'：');
	td2.html('买担保金'+step+'：');
	$("#"+td3).show();
  }
} 


 function marginPriceType_change(){
 	var marginAlgr = document.getElementById("marginAlgr").value;
 	var tdName = document.getElementById("td1s");
 	if (marginAlgr == 1) {
 		tdName.innerHTML = '保证金计算依据：';
 		$("#td1s").show();
 		$("#td2s").show();
 		document.getElementById("marginPriceType").value = "";
 	}else {
 		tdName.innerHTML = '';
 		$("#td1s").hide();
 		$("#td2s").hide();
 		document.getElementById("marginPriceType").value = "0";
 		
 	}
 }

 function marginAlgr_change(){
 	if (document.getElementById("marginAlgr").value == "1") {
 		document.getElementById("marginItem1Percent").innerHTML = '%';
 		document.getElementById("marginItemAssure1Percent").innerHTML = '%';
 		document.getElementById("marginItem1_SPercent").innerHTML = '%';
 		document.getElementById("marginItemAssure1_SPercent").innerHTML = '%';
 		
 		document.getElementById("marginItem2Percent").innerHTML = '%';
 		document.getElementById("marginItemAssure2Percent").innerHTML = '%';
 		document.getElementById("marginItem2_SPercent").innerHTML = '%';
 		document.getElementById("marginItemAssure2_SPercent").innerHTML = '%';
 		
 		document.getElementById("marginItem3Percent").innerHTML = '%';
 		document.getElementById("marginItemAssure3Percent").innerHTML = '%';
 		document.getElementById("marginItem3_SPercent").innerHTML = '%';
 		document.getElementById("marginItemAssure3_SPercent").innerHTML = '%';
 		
 		document.getElementById("marginItem4Percent").innerHTML = '%';
 		document.getElementById("marginItemAssure4Percent").innerHTML = '%';
 		document.getElementById("marginItem4_SPercent").innerHTML = '%';
 		document.getElementById("marginItemAssure4_SPercent").innerHTML = '%';
 		
 		document.getElementById("marginItem5Percent").innerHTML = '%';
 		document.getElementById("marginItemAssure5Percent").innerHTML = '%';
 		document.getElementById("marginItem5_SPercent").innerHTML = '%';
 		document.getElementById("marginItemAssure5_SPercent").innerHTML = '%';
 		
 	}else {
 		document.getElementById("marginItem1Percent").innerHTML = '';
 		document.getElementById("marginItemAssure1Percent").innerHTML = '';
 		document.getElementById("marginItem1_SPercent").innerHTML = '';
 		document.getElementById("marginItemAssure1_SPercent").innerHTML = '';
 		
 		document.getElementById("marginItem2Percent").innerHTML = '';
 		document.getElementById("marginItemAssure2Percent").innerHTML = '';
 		document.getElementById("marginItem2_SPercent").innerHTML = '';
 		document.getElementById("marginItemAssure2_SPercent").innerHTML = '';
 		
 		document.getElementById("marginItem3Percent").innerHTML = '';
 		document.getElementById("marginItemAssure3Percent").innerHTML = '';
 		document.getElementById("marginItem3_SPercent").innerHTML = '';
 		document.getElementById("marginItemAssure3_SPercent").innerHTML = '';
 		
 		document.getElementById("marginItem4Percent").innerHTML = '';
 		document.getElementById("marginItemAssure4Percent").innerHTML = '';
 		document.getElementById("marginItem4_SPercent").innerHTML = '';
 		document.getElementById("marginItemAssure4_SPercent").innerHTML = '';
 		
 		document.getElementById("marginItem5Percent").innerHTML = '';
 		document.getElementById("marginItemAssure5Percent").innerHTML = '';
 		document.getElementById("marginItem5_SPercent").innerHTML = '';
 		document.getElementById("marginItemAssure5_SPercent").innerHTML = '';
 	}
 }


 
 function changeManner101(id){
 	if (id == "1") {
 		setReadWrite(document.getElementById("limitBreedQty"));
 	}
 	if (id == "2") {
 		document.getElementById("limitBreedQty").value = "-1";
 		setReadOnly(document.getElementById("limitBreedQty"));
 	}
 }
 
  function changeManner102(id){
 	if (id == "1") {
 		setReadWrite(document.getElementById("limitCmdtyQty"));
 	}
 	if (id == "2") {
 		document.getElementById("limitCmdtyQty").value = "-1";
 		setReadOnly(document.getElementById("limitCmdtyQty"));
 	}
 }
 
 function changeManner103(id){
 	if (id == "1") {
 		setReadWrite(document.getElementById("firmCleanQty"));
 	}
 	if (id == "2") {
 		document.getElementById("firmCleanQty").value = "-1";
 		setReadOnly(document.getElementById("firmCleanQty"));
 	}
 }
 
  function changeManner105(id){
 	if (id == "1") {
 		setReadWrite(document.getElementById("oneMaxHoldQty"));
 	}
 	if (id == "2") {
 		document.getElementById("oneMaxHoldQty").value = "-1";
 		setReadOnly(document.getElementById("oneMaxHoldQty"));
 	}
 }

 function changeManner104(id){
 	if (id == "1") {
 		setReadWrite(document.getElementById("firmMaxHoldQty"));
 		//控制交易商订货量限制算法隐现
 		$("#tdFirmMaxHoldQtyAlgr").show();
 		changeFirmMaxHoldQtyAlgr();
 		$("#firmMaxHoldQtyAlgr").addClass("validate[required]");
 	}
 	if (id == "2") {
 		$("#tdFirmMaxHoldQtyAlgr").hide();
 		$("#tdFirmMaxHoldQty").show();
 		$("#firmMaxHoldQtyAlgr").removeClass("validate[required]");	
 		
 		document.getElementById("firmMaxHoldQty").value = "-1";
 		setReadOnly(document.getElementById("firmMaxHoldQty"));
 	}
 }
 
 	function changeFirmMaxHoldQtyAlgr(){
 		if (document.getElementById("firmMaxHoldQtyAlgr").value == "1") {
 			$("#tdStartPercentQty").show();
 			$("#tdMaxPercentLimit").show();
 			$("#tdFirmMaxHoldQty").hide();
 		}else {
 			$("#tdStartPercentQty").hide();
 			$("#tdMaxPercentLimit").hide();
 			$("#tdFirmMaxHoldQty").show();

 			// 交易商订货量限制算法为绝对值时
 			frm.startPercentQty.value = "0";  // 商品百分比阀值量 ，默认值为0
 			frm.maxPercentLimit.value = "0";  // 交易商订货量最大百分比，默认值为0
 		}
 	}

//add by yangpei 2011-12-2交收保证金计算方式
function change2(){
	var settleMarginType = document.forms(0).settleMarginType.value;
	if (settleMarginType == "1"){//计算交收价的提前日
		$("#bbb02").show();
		$("#aaa02").show();
		
	}else {
		$("#bbb02").hide();
		$("#aaa02").hide();
	}
}

//计算启用持仓天数限制的最长持仓天数
function change3(){
	var holdDaysLimit = document.forms(0).holdDaysLimit.value;
	
	if (holdDaysLimit == "1"){
		$("#bbb01").show();
		$("#aaa01").show();
	}else {
		$("#bbb01").hide();
		$("#aaa01").hide();
	}
}

//判断最大持仓天数是否为空
function changeMaxHoldPositionDay(){
	if(frm.holdDaysLimit.value == 1){
		$("#maxHoldPositionDay").removeClass("validate[maxSize[10] input_text");
		$("#maxHoldPositionDay").addClass("validate[required,maxSize[10] input_text");
	}
}

function settleFeeAlgr_change(){
	if ($("#settleFeeAlgr").val() == "1") {
		document.getElementById("settleFeeRate_BPercent").className = "xian";
		document.getElementById("settleFeeRate_SPercent").className = "xian";
	}else {
		document.getElementById("settleFeeRate_BPercent").className = "yin";
		document.getElementById("settleFeeRate_SPercent").className = "yin";
	}
}

function settleMarginAlgr_B_change(){
	if ($("#settleMarginAlgr_B").val() == "1") {
		$("#settleMarginRate_BPercent").show();
	}else {
		$("#settleMarginRate_BPercent").hide();
	}
}

function settleMarginAlgr_S_change(){
	if ($("#settleMarginAlgr_S").val() == "1") {
		$("#settleMarginRate_SPercent").show();
	}else {
		$("#settleMarginRate_SPercent").hide();
	}
}

function payoutAlgr_change(){
	if ($("#payoutAlgr").val() == "1") {
		$("#payoutRatePercent").show();
	}else {
		$("#payoutRatePercent").hide();
	}
}



	function breed(){
		document.getElementById("breedName").value = document.all.breedID.options[document.all.breedID.selectedIndex].text;
	}

function changeUnits(){ 
    var value=document.getElementById("contractFactorName").value;
    if(value=="")
    alert("请先输入交易单位名称");
    else 
   document.getElementById("span_contractFactor").innerHTML ="("+value+ "/批)";
    }
function changeUnits1(){ 
    var value=document.getElementById("contractFactorName").value;
    if(value=="")
   document.getElementById("span_contractFactor").innerHTML ="如(吨/批)"
   else 
   document.getElementById("span_contractFactor").innerHTML ="("+value+ "/批)";
     }
 
//-----------------------------end paraminfo-----------------------------

function setSortName(value) {
	var breedslist =<%=request.getAttribute("breedlist") %>; 
	 for(var o in breedslist){  
	        if (value == breedslist[o].breedid ) {
				$("#breedid").val(breedslist[o].breedid);
				$("#breedname").val(breedslist[o].breedname);
				$("#sortid").val(breedslist[o].categoryid);
				$("#contractfactorname").val(breedslist[o].unit);
				$("#span_contractFactor").html("("+breedslist[o].unit+ "/批)");
				break;
		}
	 }  
}
</script>
</head>
<body leftmargin="14" topmargin="0">
	<table border="0"  height="100%" width="100%"  align="center" >
		<tr>
			<td>
				<form id="frm" name="frm" action="" method="POST" enctype="mutipart/form-data">
				<fieldset>
				<legend class="common"><b>设置品种信息</b></legend>
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
								<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
        							<tr>
        			 					<td align="right" width="98"><span class="required">品种名称</span>：</td>
	      								<td style="white-space:nowrap;">
	      								   <c:if test="${crud == 'create'}">
		      									<select id="bname" style="width:100" class="validate[required]" onchange="setSortName(this.value)">
								            		<option value="">请选择</option>
                                                    <c:forEach var="mbreed" items="${Mlist}">
                                                      <option value="${mbreed.breedid}">${mbreed.breedname}</option>
                                                    </c:forEach>
								            	</select>
								            </c:if> 
								            <c:if test="${crud == 'update'}">
								            	<input id="breedname" name="breedname" value="${entity.breedname }" style="width: 80;background-color: #C0C0C0" class="input_text" size="10" readonly="readonly"/>
								            </c:if>
							            	<input id="sortid" type="hidden" name="sortid" value="${entity.sortid }" />
							            	<input id="breedid" type="hidden" name="breedid" value="${entity.breedid }" />
							            	<input id="breedname" type="hidden" name="breedname" value="${entity.breedname }" />
		          							<span class="required">*</span>
		          						</td>
										<td align="right" width="90">报价货币：</td>     
            							<td>  
											<input id="contractcurrency" name="contractcurrency" value="${entity.contractcurrency }"
			  									style="ime-mode:disabled; width: 60" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" />
											<span class="required">如元、美元等</span>
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
        								<input type="hidden" id="cmdtyPrefix"/>   
        	  							<td align="right">&nbsp;&nbsp;报价单位：</td>
            							<td>元/<input id="contractfactorname" name="contractfactorname" value="${entity.contractfactorname }"
            								class="easyui-validatebox textbox" data-options="required:true,readonly:true,missingMessage:'必填项'"  style="width: 60; background-color: C0C0C0"/>          
			  								<span class="required">&nbsp;</span>  
            							</td>    
        								<td align="right" >交易单位：</td> 
            							<td> 
			  								<input id="contractfactor" name="contractfactor" maxlength="10" value="${entity.contractfactor }"
			  									style="ime-mode:disabled; width: 60" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'" onkeypress="onlyNumberInput()"/>
			  								<span id="span_contractFactor"  class="required">
			  									<c:if test="${entity.contractfactorname!=null}">(${entity.contractfactorname}/批)</c:if>
			  									<c:if test="${entity.contractfactorname==null}">如(吨/批)</c:if>
			  								</span>          
            							</td>
            							<td align="right"></td>
										<td>
										</td>
        							</tr>
							        <tr>
							            <td align="right" >&nbsp;涨跌停板算法：</td>
							            <td >
											<select id="spreadalgr" name="spreadalgr" style="width:80" onchange="spreadAlgr_onchange(this.value)">
												<option value=""></option>
											    <option value="1" <c:if test="${entity.spreadalgr==1 }">selected</c:if>>按百分比</option>
												<option value="2" <c:if test="${entity.spreadalgr==2 }">selected</c:if>>按绝对值</option>
										   </select> <span class="required">*</span>            
							            </td>        
							            <td align="right">涨幅上限：</td>
							            <td>
			  								<input id="spreaduplmt" name="spreaduplmt" maxlength="10" value="${entity.spreaduplmt }"
			  									style="ime-mode:disabled; width: 60" onkeypress="return onlyNumberInput()" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"/>
			  								<span id="spreadUpLmtPercent">%</span>           
            							</td>
            							<td align="right">跌幅下限：</td>
            							<td>
											<input id="spreaddownlmt" name="spreaddownlmt" maxlength="10" value="${entity.spreaddownlmt }"
												style="ime-mode:disabled; width: 70" onkeypress="return onlyNumberInput()" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"/>
											<span id="spreadDownLmtPercent">%</span>          
								      	</td>
								      	<td>&nbsp;</td>
								      	<script type="text/javascript">
							            	if ("${entity.spreadalgr}" == "1"){$("#spreadUpLmtPercent").show();$("#spreadDownLmtPercent").show();} else {$("#spreadUpLmtPercent").hide();$("#spreadDownLmtPercent").hide();}
							            </script>
        							</tr> 
									<tr>
										<td align="right">&nbsp;最小变动价位(元)：</td>
            							<td>
			  								<input type="text" id="minpricemove" name="minpricemove"  value="${entity.minpricemove }"
			  									style="ime-mode:disabled; width: 80" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"/>          
            							</td>
            							<td align="right">&nbsp;最小变动数量：</td>
            							<td>
			  								<input type="text" id="minquantitymove" name="minquantitymove" value="${entity.minquantitymove }" 
			  									class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"  style="ime-mode:disabled; width: 80" />          
            							</td>
            							<td align="right">T+N交易天数：</td>
										<td>
										<input type="text" id="tradedays" name="tradedays" value="${entity.tradedays }" 
			  									class="easyui-numberbox" data-options="min:0,max:100,required:true,missingMessage:'必填项'"  style="ime-mode:disabled; width: 80" />          
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
        	  							<td align="right">最小申购数量：</td>
            							<td>元/<input id="minapplynum" name="minapplynum" value="${entity.minapplynum }"
            								class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"  style="width: 60; background-color: C0C0C0"/>          
            							</td>    
        								<td align="right" >最大申购数量：</td> 
            							<td> 
			  								<input id="maxapplynum" name="maxapplynum"  value="${entity.maxapplynum }"
			  									style="ime-mode:disabled; width: 60" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"/>
            							</td>
            							<td align="right">最小申购变动量：</td>
										<td>
										<input id="minapplyquamove" name="minapplyquamove"  value="${entity.minapplyquamove }"
			  									style="ime-mode:disabled; width: 60" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"/>
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
			  									style="ime-mode:disabled; width: 60" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"/>
			  								<span id="dealerpubcharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span>          
            							</td>
            							<td align="right">交易商发行手续费市场留存比例：</td>
            							<td>
											<input id="mktdeapubcharatio" name="mktdeapubcharatio" maxlength="10" value="${entity.mktdeapubcharatio }"
												style="ime-mode:disabled; width: 70" class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"/>
											<span id="mktdeapubcharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span>          
								      	</td>
								      	<td>&nbsp;</td>
								      	<script type="text/javascript">
							            	if ("${entity.publishalgr}" == "1"){$("#dealerpubcharatioPercent").show();$("#mktdeapubcharatioPercent").show();} else {$("#dealerpubcharatioPercent").hide();$("#mktdeapubcharatioPercent").hide();}
							            </script>
        							</tr> 
									<tr>
										<td align="right"></td>
            							<td>
            							</td>
            							<td align="right">发行商发行手续费比例：</td>
            							<td>
			  								<input type="text" id="publishercharatio" name="publishercharatio" value="${entity.publishercharatio }" 
			  									class="easyui-numberbox" data-options="min:0,required:true,missingMessage:'必填项'"  style="ime-mode:disabled; width: 80" />  
			  								<span id="publishercharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span>        
            							</td>
            							<td align="right">发行商发行手续费市场留存比例：</td>
										<td>
										<input type="text" id="mktpubcharatio" name="mktpubcharatio" value="${entity.mktpubcharatio }" 
			  									class="easyui-numberbox" data-options="min:0,max:100,required:true,missingMessage:'必填项'"  style="ime-mode:disabled; width: 80" />          
										<span id="mktpubcharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span>
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
					                  <tr>
					                    <td><b>所属交易节</b></td>
					                    <td><hr width="715" class="pickList"/></td>
					                    <td >
					                    	<img id="baseinfo_img3" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" 
												style="cursor:hand" onclick=""/>
										</td>
					                  </tr>
					                </table>
					              </legend>
									<span id="baseinfo3">
										<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
							         		<tr>
											<td>&nbsp;&nbsp;</td>
							                <td align="left">
							                    <c:forEach var="tradeTime" items="${requestScope.tratimelist}" varStatus="status">
							                      <c:if test="${status.count%5==0}"><br /></c:if>
							                      <input type="checkbox" name="tradetime" class="NormalInput" value="${tradeTime.sectionid }"/>
							                      <label class="hand">
							                      <c:out value="${tradeTime.name}"/>
							                      </label>
							                    </c:forEach>
							                 </td>
							                </tr>	
									    </table>
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
								    <c:if test="${crud == 'create'}">
								    	<input type="button" value="添加" onclick="addBreed()" className="anniu_btn" action="<%=request.getContextPath()%>/BreedController/addBreed" id="add"/>
								    </c:if>
								    <c:if test="${crud == 'update'}">
								    	<input type="button" value="提交" onclick="updateBreed()" className="anniu_btn" action="<%=request.getContextPath()%>/BreedController/updateBreed" id="update"/>
								    </c:if>
									&nbsp;&nbsp;
									<input type="button" value="返回" onclick="returntoList()" className="anniu_btn" action="<%=request.getContextPath()%>/IpoController/CommodityManage" id="back"/>
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
		 <table cellSpacing="0" cellPadding="0" width="800" border="0" align="center" class="common">
			<tr>
				<td colspan="4" align="left">
			 		<span class="required">提示：红色字体表示不与商品关联</span>
			    </td>
			</tr>
		 </table>	 
</body>
</html>
