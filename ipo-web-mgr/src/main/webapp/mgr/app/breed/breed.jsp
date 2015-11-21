<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
<html>
	<head>
		<link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
		<script src="${publicPath }/js/jquery-1.6.min.js" type="text/javascript"></script>
		<script src="${mgrPath }/app/timebargain/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="GBK"></script>
		<script src="${mgrPath }/app/timebargain/js/jquery.validationEngine.js" type="text/javascript" charset="GBK"></script>	
		<title>Ʒ��</title>
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

			$(document).ready(function() {
		    	//ajax��֤
				jQuery("#frm").validationEngine( {
					ajaxFormValidation : true,
					ajaxFormValidationURL : "../../ajaxcheck/demo/formCheckBreedById.action",
					onAjaxFormComplete : ajaxValidationCallback,
					onBeforeAjaxFormValidation : beforeCall
				});

				jQuery("#frm").validationEngine('attach');

				//�ύǰ�¼�
				function beforeCall(form, options) {
					return true;
				}

				//�ύ���¼�
				function ajaxValidationCallback(status, form, json, options) {
					//������سɹ�
					if (status === true) {
					    var flag = false;
				    	flag = save_onclick();
				    	if(flag){
					    	var vaild = affirm("��ȷ��Ҫ������");
							if(vaild){
								//�����ϢURL
								var updateDemoUrl = $("#add").attr("action");
								//ȫ URL ·��
								var url = "${basePath}"+updateDemoUrl;
								$("#frm").attr("action",url);
								frm.submit();
								$("#add").attr("disabled",true);
							}	
				    	}
					} else {
						alert("��Ʒ�ִ����Ѵ��ڣ����޸�");
						$("#breedID").focus();
					}
				}
		    	
				//�޸İ�ťע�����¼�
				$("#add").click(function(){
					jQuery("#frm").modifyAjax( {
						ajaxFormValidation : true
					});
					//��֤��Ϣ
					if(jQuery("#frm").validationEngine('validateform')){
					}
				});
				
				$("#update").click(function(){
					jQuery("#frm").modifyAjax( {
						ajaxFormValidation : false
					});
					//��֤��Ϣ
					if(jQuery("#frm").validationEngine('validateform')){
						var flag = false;
					    flag = save_onclick();
					    if(flag){
					    	var vaild = affirm("��ȷ��Ҫ������");
							if(vaild){
								//�����ϢURL
								var updateDemoUrl = $(this).attr("action");
								//ȫ URL ·��
								var url = "${basePath}"+updateDemoUrl;
								$("#frm").attr("action",url);
								$("#frm").submit();
								$(this).attr("disabled",true);
							}
						}	
					}
				});
				$("#back").click(function(){
					
					//�����ϢURL
					var updateDemoUrl = $(this).attr("action");
					//ȫ URL ·��
					var url = "${basePath}"+updateDemoUrl+"?sortColumns=order+by+breedID+asc";

					document.location.href = url;
					
				});
				
				try {
					var crud = $("#crud").val();
					if (crud == "update") {
						$("#breedID").attr("readonly", true).css("background-color", "#c0c0c0");

						if ($("#limitBreedQty").val() == "-1") {
	      					changeManner101(2);
						} else {
							changeManner101(1);
						}
						if ($("#limitCmdtyQty").val() == "-1") {
							changeManner102(2);
						} else {
							changeManner102(1);
						}
						if ($("#firmCleanQty").val() == "-1") {
							changeManner103(2);
						} else {
							changeManner103(1);
						}
						if ($("#firmMaxHoldQty").val() == "-1") {
							changeManner104(2);
						} else {
							changeManner104(1);
						}
	      				if ($("#oneMaxHoldQty").val() == "-1") {
	      					changeManner105(2);
	      				} else {
	      					changeManner105(1);
	      				}
				    } else {
						var breedsList = eval("(${breedsList})");
						var $breedID = $("#breedName");
						for (var i=0; i<breedsList.length; i++) {
							$breedID.append("<option value='"+breedsList[i].breedName+"'>"+breedsList[i].breedName+"</option>");
						}
						//$list_week.append("<option value=''></option>");
						$breedID.data("breedsList", breedsList);
					}
					var trades = "${entity.tradeTime}".split(",");
					$("input[name='entity.tradeTime']").each(function() {
						if (crud == "create") {
							$(this).attr("checked", true);
						} else {
							for (var k=0 ; k<trades.length; k++) {
								if ($(this).val() == trades[k]) {
									$(this).attr("checked", true);
								}
							}
						}
					});

					marginAlgr_change();//��֤��ٷֱ�
				} catch (e) {
					alert("�޽��׽ڣ�")
				}
				
				

				
		 	});
		 	function change() {
		 		var settlePriceType = $("#settlePriceType").val();
				
				if (settlePriceType == "3") {//ָ�����ռ�
					$("#bbb0").hide();
				 	$("#aaa0").hide();
					$("#ccc0").show();
				 	$("#ddd0").show();
				}else if (settlePriceType == "1"){//���㽻�ռ۵���ǰ��
					$("#bbb0").show();
				 	$("#aaa0").show();
				 	$("#ccc0").hide();
				 	$("#ddd0").hide();	
				}else {
					$("#bbb0").hide();
				 	$("#aaa0").hide();
				 	$("#ccc0").hide();
				 	$("#ddd0").hide();
				}
			}
			function window_onload() {
    			 
    			
    			if(breedForm.crud.value == "create") {
      				breedForm.spreadAlgr.value = ""
					breedForm.limitCmdtyQty.focus();
					breedForm.type101[0].checked = true;
					breedForm.type102[0].checked = true;
					breedForm.type103[0].checked = true;
					breedForm.type104[0].checked = true;
					breedForm.type105[0].checked = true;
					breedForm.limitBreedQty.value = "-1";
					breedForm.limitCmdtyQty.value = "-1";
					breedForm.firmCleanQty.value = "-1";
					breedForm.firmMaxHoldQty.value = "-1";
					breedForm.oneMaxHoldQty.value = "-1";
					if (breedForm.firmMaxHoldQty.value == "-1") {
      					changeManner104(2);
      				}
					setReadOnly(breedForm.limitBreedQty);
					setReadOnly(breedForm.limitCmdtyQty);
					setReadOnly(breedForm.firmCleanQty);
					setReadOnly(breedForm.firmMaxHoldQty);
					setReadOnly(breedForm.oneMaxHoldQty);
					breedForm.minPriceMove.value="1.0";
					breedForm.contractFactor.value="1";
					breedForm.minQuantityMove.value="1";
					breedForm.minSettleMoveQty.value="1";
					breedForm.minSettleQty.value="1";
					breedForm.marginItemAssure1.value = "0";
					breedForm.marginItemAssure2.value = "0";
					breedForm.marginItemAssure3.value = "0";
					breedForm.marginItemAssure4.value = "0";
					breedForm.marginItemAssure5.value = "0";
    			} else if(breedForm.crud.value == "update") {
      				breedForm.limitCmdtyQty.focus();
      				if (breedForm.limitBreedQty.value == "-1") {
      					changeManner101(2);
					} else {
						changeManner101(1);
					}
					if (breedForm.limitCmdtyQty.value == "-1") {
						changeManner102(2);
					} else {
						changeManner102(1);
					}
					if (breedForm.firmCleanQty.value == "-1") {
						changeManner103(2);
					} else {
						changeManner103(1);
					}
					if (breedForm.firmMaxHoldQty.value == "-1") {
						changeManner104(2);
					} else {
						changeManner104(1);
					}
      				if (breedForm.oneMaxHoldQty.value == "-1") {
      					changeManner105(2);
      				} else {
      					changeManner105(1);
      				}
    			} 
    			//marginAlgr_change();//��֤��ٷֱ�
    			//Ĭ�����ڷ���ȡ��ʽ
    			//breedForm.delayFeeWay.value = "1";
    			//<c:if test="${breedForm.isSettle == 'Y'}">
    				//breed();
    			//</c:if>
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
//save
function save_onclick()
{
	if(!tmp_baseinfo_up)
    {
      baseinfo_onclick();
    }
    if(!tmp_paraminfo_up)
    {
      paraminfo_onclick();
    }
    
    if(!tmp_paraminfo_up6)
    {
      paraminfo6_onclick();
    }
    if (!tmp_baseinfo_up2) {
    	baseinfo2_onclick();
    }
    if (!tmp_baseinfo_up3) {
    	baseinfo3_onclick();
    }
	if (!tmp_baseinfo_up4) {
		baseinfo4_onclick();
	}
	if(!tmp_baseinfo_upy)
    {
      baseinfoy_onclick();
    }

	if (!$("input[name='entity.tradeTime']:checked").val()) {
		alert("û��ѡ�����׽�");
		return false;
	}
	if ($("input[name='type']:checked").val() == "1") {
		$("#marginItem1_S").val($("#marginItem1").val());
		$("#marginItemAssure1_S").val($("#marginItemAssure1").val());
	}
    for (var i=1; i<5; i++) {
    	if ($("input[name='type"+i+"']:checked").val() == "1") {
    		$("#marginItem"+(i+1)+"_S").val($("#marginItem"+(i+1)).val());
    		$("#marginItemAssure"+(i+1)+"_S").val($("#marginItemAssure"+(i+1)).val());
    	}
    }
    for (var i=1; i<5; i++) {
    	if ($("#marginItem"+(i+1)).val()=="" && $("#marginItem"+(i+1)+"_S").val()=="" && $("#marginItemAssure"+(i+1)).val()=="" && $("#marginItemAssure"+(i+1)+"_S").val()=="") {	
    	} else if ($("#marginItem"+(i+1)).val()!="" && $("#marginItem"+(i+1)+"_S").val()!="" && $("#marginItemAssure"+(i+1)).val()!="" && $("#marginItemAssure"+(i+1)+"_S").val()!="") {}else {alert("��"+(i+1)+"�׶α�֤����������");return false;}
    }

    if (document.getElementById("minQuantityMove").value <= 0) {
    	alert("��С�䶯����Ӧ����0��");
    	document.getElementById("minQuantityMove").focus();
    	return false;
    }
  
    if (document.getElementById("minSettleMoveQty").value <= 0) {
    	alert("��С���λӦ����0��");
    	document.getElementById("minSettleMoveQty").focus();
    	return false;
    }
    
    if (document.getElementById("minSettleQty").value <= 0) {
    	alert("��С��������Ӧ����0��");
    	document.getElementById("minSettleQty").focus();
    	return false;
    }

    //if (breedForm.maxFeeRate.value == "") {
    	//alert("�����������ϵ������Ϊ�գ�");
    	//breedForm.maxFeeRate.focus();
    	//return false;
   // }
    
    
    if (document.getElementById("contractFactor").value <=0) {
    	alert("��λ�������������0��");
    	document.getElementById("contractFactor").focus();
    	return false;
    }
    if (document.getElementById("minPriceMove").value <=0) {
    	alert("��С��λ�����0��");
    	document.getElementById("minPriceMove").focus();
    	return false;
    }
    
	if (document.all.type101[1].checked == true) {
		if (document.getElementById("limitBreedQty").value < 0) {
			alert("Ʒ�ֵ�����󶩻�������Ϊ����");
			return false;
		}
	}
	if (document.all.type102[1].checked == true) {
		if (document.getElementById("limitCmdtyQty").value < 0) {
			alert("��Ʒ������󶩻�������Ϊ����");
			return false;
		}
	}
	
	if (document.all.type103[1].checked == true) {
		if (document.getElementById("firmCleanQty").value < 0) {
			alert("��������󾻶���������Ϊ����");
			return false;
		}
	}
 	if (document.all.type104[1].checked == true) {
 		if (document.getElementById("firmMaxHoldQtyAlgr").value == "") {
 			alert("�����̶����������㷨����Ϊ�գ�");
 			return false;
 		}
 		if (document.getElementById("firmMaxHoldQtyAlgr").value == "2") {
 			if (document.getElementById("firmMaxHoldQty").value == "") {
		 		alert("���������˫�߶���������Ϊ�գ�");
		 		document.getElementById("firmMaxHoldQty").focus();
		    	return false;
		 	}
		 	if (document.getElementById("firmMaxHoldQty").value < 0) {
				alert("���������˫�߶���������Ϊ����");
				return false;
			}
 		}else {
 			if (document.getElementById("startPercentQty").value == "") {
 				alert("��Ʒ��������ֵ����Ϊ�գ�");
 				return false;
 			}
 			if (document.getElementById("maxPercentLimit").value == "") {
 				alert("��������������Ϊ�գ�");
 				return false;
 			}
 			document.getElementById("firmMaxHoldQty").value = parseInt((document.getElementById("startPercentQty").value * (document.getElementById("maxPercentLimit").value/100))+"");
 			if (document.getElementById("firmMaxHoldQty").value < 1) {
 				alert("��ֵ��������ò���ȷ���˻���СΪ1��");
 				return false;
 			}
 		}
	}else {
		document.getElementById("firmMaxHoldQtyAlgr").value = '2';
		document.getElementById("startPercentQty").value = '0';
		document.getElementById("maxPercentLimit").value = '0';
	}
	
	if (document.all.type105[1].checked == true) {
		if (document.getElementById("oneMaxHoldQty").value < 0) {
			alert("�������ί��������Ϊ����");
			return false;
		}
	}
	
	if(document.getElementById("storeRecoupRate").value >= 100){
		alert("�ִ������ѱ���С��100");
		return false;
	}
	var addedTax = Number($("#addedTax").val());
    $("#addedTaxFactor").val(addedTax/(addedTax+100));    setEnabled(document.all.marginPriceType);
    return true;
}
//���������ֺ�.
function onlyNumberInput()
{
  if (event.keyCode<46 || event.keyCode>57 || event.keyCode == 47)
  {
    event.returnValue=false;
  }
}
function suffixNamePress()
{
	
  if ((event.keyCode>=46 && event.keyCode<=57) )  //|| (event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=97 && event.keyCode<=122)
  {
  	
    event.returnValue=true;
  }
  else
  {
    event.returnValue=false;
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
   td1.html('��֤��'+step+'��');
   td2.html('������'+step+'��');
   $("#"+td3).hide();
  }
  else if(id==2)
  {
	td1.html('��֤��'+step+'��');
	td2.html('�򵣱���'+step+'��');
	$("#"+td3).show();
  }
} 


 function marginPriceType_change(){
 	var marginAlgr = document.getElementById("marginAlgr").value;
 	var tdName = document.getElementById("td1s");
 	if (marginAlgr == 1) {
 		tdName.innerHTML = '��֤��������ݣ�';
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
 		//���ƽ����̶����������㷨����
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

 			// �����̶����������㷨Ϊ����ֵʱ
 			frm.startPercentQty.value = "0";  // ��Ʒ�ٷֱȷ�ֵ�� ��Ĭ��ֵΪ0
 			frm.maxPercentLimit.value = "0";  // �����̶��������ٷֱȣ�Ĭ��ֵΪ0
 		}
 	}

//add by yangpei 2011-12-2���ձ�֤����㷽ʽ
function change2(){
	var settleMarginType = document.forms(0).settleMarginType.value;
	if (settleMarginType == "1"){//���㽻�ռ۵���ǰ��
		$("#bbb02").show();
		$("#aaa02").show();
		
	}else {
		$("#bbb02").hide();
		$("#aaa02").hide();
	}
}

//�������óֲ��������Ƶ���ֲ�����
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

//�ж����ֲ������Ƿ�Ϊ��
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
    alert("�������뽻�׵�λ����");
    else 
   document.getElementById("span_contractFactor").innerHTML ="("+value+ "/��)";
    }
function changeUnits1(){ 
    var value=document.getElementById("contractFactorName").value;
    if(value=="")
   document.getElementById("span_contractFactor").innerHTML ="��(��/��)"
   else 
   document.getElementById("span_contractFactor").innerHTML ="("+value+ "/��)";
     }
 
//-----------------------------end paraminfo-----------------------------

function setSortName(value) {
	//$("#sortName").val(obj.options[obj.selectedIndex].text);

	var breedsList =eval('(' +"<%=request.getAttribute("Mlist") %>" + ')');  
	for (var i=0; i<breedsList.length; i++) {
		if (value == breedsList[i].breedName) {
			$("#breedid").val(breedsList[i].breedid);
			$("#sortid").val(breedsList[i].categoryid);
			$("#contractfactorname").val(breedsList[i].unit);
			$("#span_contractFactor").html("("+breedsList[i].unit+ "/��)");
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
				<form id="frm" name="frm" action="" method="POST">
				<fieldset>
				<legend class="common"><b>����Ʒ����Ϣ</b></legend>
				<span id="baseinfo9">
				<table width="850" border="0" align="center"  class="common" cellpadding="0" cellspacing="2">
					<!-- ������Ϣ -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					          	<legend>
					           	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common">
					            	<col width="55"></col><col></col><col width="6"></col>
					               	<tr>
					                 	<td><b>������Ϣ</b></td>
					                    <td><hr width="735" class="pickList"/></td>
					                    <td ><img id="baseinfo_img" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" style="cursor:hand" onclick="javascript:baseinfo_onclick()"/></td>
					            	</tr>
					         	</table>
					         	</legend>
								<span id="baseinfo">
								<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
        							<tr>
        			 					<td align="right" width="98"><span class="required">Ʒ������</span>��</td>
	      								<td style="white-space:nowrap;">
	      								    <c:if test="${crud == 'create'}">
		      									<select id="breedname" name="entity.breedname" style="width:100" class="validate[required]" onchange="setSortName(this.value)">
								            		<option value="">��ѡ��</option>
                                                    <c:forEach var="mbreed" items="${requestScope.list}">
                                                      <option value="${mbreed.breedid}">${mbreed.breedname}</option>
                                                    </c:forEach>
								            	</select>
								            </c:if>
								            <c:if test="${crud == 'update'}">
								            	<input id="breedname" name="entity.breedname" value="${entity.breedname }" style="width: 80;background-color: #C0C0C0" class="input_text" size="10" readonly="readonly"/>
								            </c:if>
							            	<input id="sortid" type="hidden" name="entity.sortid" value="${entity.sortid }" />
							            	<input id="breedid" type="hidden" name="entity.breedid" value="${entity.breedid }" />
		          							<span class="required">*</span>
		          						</td>
										<td align="right" width="90">���ۻ��ң�</td>     
            							<td>  
											<input id="contractcurrency" name="entity.contractcurrency" maxlength="10" value="${entity.contractcurrency }"
			  									style="ime-mode:disabled; width: 60" class="validate[required] input_text datepicker" size="5" />
											<span class="required">��Ԫ����Ԫ��*</span>
										</td>
							        </tr>  
								</table >
								</span>
						    	</fieldset>
							</td>
						</tr>
						<!-- ������Ϣ -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					       		<legend>
					        	<table cellspacing="0" cellpadding="0" border="0" width="800" class="common">
					           		<col width="55"></col><col></col><col width="6"></col>
					         		<tr>
					              		<td><b>��������</b></td>
					                    <td><hr width="770" class="pickList"/></td>
					                    <td ><img id="baseinfo_img2" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" style="cursor:hand" onclick="javascript:baseinfo2_onclick()"/></td>
					             	</tr>
					         	</table>
					       		</legend>
								<span id="baseinfo2">
								<table cellSpacing="0" cellPadding="0" width="790" border="0" align="left" class="common">   
									<tr>
        								<input type="hidden" id="cmdtyPrefix"/>   
        	  							<td align="right">&nbsp;&nbsp;���۵�λ��</td>
            							<td>Ԫ/<input id="contractfactorname" name="entity.contractfactorname" value="${entity.contractfactorname }"
            								maxlength="10" class="input_text datepicker" size="7" style="width: 60; background-color: C0C0C0" readOnly="readOnly"/>          
			  								<span class="required">&nbsp;</span>  
            							</td>    
        								<td align="right" >���׵�λ��</td> 
            							<td> 
			  								<input id="contractfactor" name="entity.contractfactor" maxlength="10" value="${entity.contractfactor }"
			  									style="ime-mode:disabled; width: 60" class="validate[required] input_text datepicker" size="5" onkeypress="onlyNumberInput()"/>
			  								<span id="span_contractFactor"  class="required">
			  									<c:if test="${entity.contractfactorname!=null}">(${entity.contractfactorname}/��)</c:if>
			  									<c:if test="${entity.contractfactorname==null}">��(��/��)</c:if>
			  								</span>          
            							</td>
            							<td align="right"></td>
										<td>
										</td>
        							</tr>
							        <tr>
							            <td align="right" >&nbsp;�ǵ�ͣ���㷨��</td>
							            <td >
											<select id="spreadalgr" name="entity.spreadalgr" style="width:80" onchange="spreadAlgr_onchange(this.value)">
												<option value=""></option>
											    <option value="1" <c:if test="${entity.spreadalgr==1 }">selected</c:if>>���ٷֱ�</option>
												<option value="2" <c:if test="${entity.spreadalgr==2 }">selected</c:if>>������ֵ</option>
										   </select> <span class="required">*</span>            
							            </td>        
							            <td align="right">�Ƿ����ޣ�</td>
							            <td>
			  								<input id="spreaduplmt" name="entity.spreaduplmt" maxlength="10" value="${entity.spreaduplmt }"
			  									style="ime-mode:disabled; width: 60" onkeypress="return onlyNumberInput()" class="validate[required] input_text datepicker" size="10"/>
			  								<span id="spreadUpLmtPercent">%</span><span class="required">*</span>           
            							</td>
            							<td align="right">�������ޣ�</td>
            							<td>
											<input id="spreaddownlmt" name="entity.spreaddownlmt" maxlength="10" value="${entity.spreaddownlmt }"
												style="ime-mode:disabled; width: 70" onkeypress="return onlyNumberInput()" class="validate[required] input_text datepicker" size="10"/>
											<span id="spreadDownLmtPercent">%</span><span class="required">*</span>           
								      	</td>
								      	<td>&nbsp;</td>
								      	<script type="text/javascript">
							            	if ("${entity.spreadalgr}" == "1"){$("#spreadUpLmtPercent").show();$("#spreadDownLmtPercent").show();} else {$("#spreadUpLmtPercent").hide();$("#spreadDownLmtPercent").hide();}
							            </script>
        							</tr> 
									<tr>
										<td align="right">&nbsp;��С�䶯��λ(Ԫ)��</td>
            							<td>
			  								<input type="text" id="minpricemove" name="entity.minpricemove" maxlength="10" value="${entity.minpricemove }"
			  									style="ime-mode:disabled; width: 80" onkeypress="return onlyNumberInput()" class="validate[required] input_text datepicker" style="width: 80"/>          
			  								<span class="required">*</span>  
            							</td>
            							<td align="right">&nbsp;��С�䶯������</td>
            							<td>
			  								<input type="text" id="minquantitymove" name="entity.minquantitymove" maxlength="3" value="${entity.minquantitymove }" 
			  									class="validate[required] input_text datepicker"  style="ime-mode:disabled; width: 80"  onkeyup="value=value.replace(/[^\d]/g,'')" style="width: 80"/>          
			  								<span class="required">*</span>  
            							</td>
            							<td align="right">T+N����������</td>
										<td>
										<input type="text" id="tradedays" name="entity.tradedays" maxlength="3" value="${entity.tradedays }" 
			  									class="validate[required] input_text datepicker"  style="ime-mode:disabled; width: 80"  onkeyup="value=value.replace(/[^\d]/g,'')" style="width: 80"/>          
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
              					<legend>
                				<table cellspacing="0" cellpadding="0" border="0" width="800" class="common">
                  					<col width="70"></col><col></col><col width="6"></col>
                  					<tr>
                    					<td><b>���в�������</b></td>
                    					<td><hr width="725" class="pickList"/></td>
                    					<td ><img id="paraminfo_img6" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" style="cursor:hand" onclick="javascript:paraminfo6_onclick()"/></td>
                  					</tr>
                				</table>
              					</legend>
								<span id="paraminfo6">
								<table cellSpacing="0" cellPadding="0" width="720" border="0" align="left" class="common">                        
         							<tr>
										<td align="right">��С�깺������</td>
										<td>
											<input type="text" id="minapplynum" name="entity.minapplynum" maxlength="3" value="${entity.minapplynum }" 
			  									class="validate[required] input_text datepicker"  style="ime-mode:disabled; width: 80"  onkeyup="value=value.replace(/[^\d]/g,'')" style="width: 80"/>          
			  								<span class="required">*</span> 
										</td>
										<td align="right">����깺������</td>
										<td>
											<input type="text" id="maxapplynum" name="entity.maxapplynum" maxlength="3" value="${entity.maxapplynum }" 
			  									class="validate[required] input_text datepicker"  style="ime-mode:disabled; width: 80"  onkeyup="value=value.replace(/[^\d]/g,'')" style="width: 80"/>          
			  								<span class="required">*</span> 
										</td>
										<td align="right">��С�깺�䶯����</td>
										<td>
										<input type="text" id="minapplyquamove" name="entity.minapplyquamove" maxlength="3" value="${entity.minapplyquamove }" 
			  									class="validate[required] input_text datepicker"  style="ime-mode:disabled; width: 80"  onkeyup="value=value.replace(/[^\d]/g,'')" style="width: 80"/>          
			  								<span class="required">*</span>  
										</td>
									</tr>
									<tr> 		            
		            					<td rowspan="4" width="220" height="10" valign="top">
		            						<div align="right">
		            							<span >�����������㷨��
		            								<select id="publishalgr" name="entity.publishalgr" style="width:80" onchange="on_change()">
														<option value=""></option>
					    								<option value="1" <c:if test="${entity.publishalgr==1 }">selected</c:if>>���ٷֱ�</option>
														<option value="2" <c:if test="${entity.publishalgr==2 }">selected</c:if>>������ֵ</option>
			   										</select> 
			   										<span class="required">*</span>  
												</span>
											</div>
										</td>	            		            
		            					<td align="right" rowspan="1" width="225" height="5">�����̷��������ѱ�����<input id="dealerpubcharatio" name="entity.dealerpubcharatio" maxlength="6" value="${entity.dealerpubcharatio }"
		            										style="ime-mode:disabled; width: 80" onkeypress="return onlyNumberInput()" class="validate[required] input_text datepicker"  size="10"/>
			  								<span id="dealerpubcharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span><span class="required">*</span>
			  							</td>
			  							<td align="right" >�����̷����������г����������<input id="mktdeapubcharatio" name="entity.mktdeapubcharatio"  maxlength="6" value="${entity.mktdeapubcharatio }"
			  											style="ime-mode:disabled; width: 80" onkeypress="return onlyNumberInput()" class="validate[required] input_text datepicker" size="10"/>
			  								<span id="mktdeapubcharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span><span class="required">*</span>  </td>
			  							<td width="25"></td>
		    						</tr>
		    						<tr> 		            
		            					<td align="right" width="225" height="5">�����̷��������ѱ�����<input id="publishercharatio" name="entity.publishercharatio" maxlength="11" value="${entity.publishercharatio }"
		            										style="ime-mode:disabled; width: 80" onkeypress="return onlyNumberInput()" class="validate[required] input_text datepicker" size="10"/>
											<span id="publishercharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span><span class="required">*</span>
										</td>
			  							<td align="right">�����̷����������г����������<input id="mktpubcharatio" name="entity.mktpubcharatio" maxlength="11" value="${entity.mktpubcharatio }" 
			  										style="ime-mode:disabled; width: 80" onkeypress="return onlyNumberInput()" class="validate[required] input_text datepicker" size="10"/>
											<span id="mktpubcharatioPercent" class="<%if("1".equals("${entity.publishalgr==1 }")){%>xian<%}else{%>yin<%}%>">%</span><span class="required">*</span>
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
					                  <col width="70"></col><col></col><col width="6"></col>
					                  <tr>
					                    <td><b>�������׽�</b></td>
					                    <td><hr width="715" class="pickList"/></td>
					                    <td >
					                    	<img id="baseinfo_img3" src="<c:url value="${skinPath }/image/app/timebargain/ctl_detail_Up.gif"/>" 
												style="cursor:hand" onclick="javascript:baseinfo3_onclick()"/>
										</td>
					                  </tr>
					                </table>
					              </legend>
									<span id="baseinfo3">
										<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
							         		<tr>
											<td>&nbsp;&nbsp;</td>
							                <td align="left">
							                    <c:forEach var="tradeTime" items="${listSection}" varStatus="status">
							                      <c:if test="${status.count%5==0}"><br /></c:if>
							                      <input type="checkbox" name="entity.tradetime" class="NormalInput" value="${tradeTime.sectionID }"/>
							                        
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
								    <c:if test="${request.crud == 'create'}">
								    	<input name="���" onclick="" className="anniu_btn" action="<%=request.getContextPath()%>/BreedController/addBreeds" id="add"/>
								    </c:if>
								    <c:if test="${request.crud == 'update'}">
								    	<input name="�ύ" onclick="" className="anniu_btn" action="<%=request.getContextPath()%>/BreedController/updateBreeds" id="update"/>
								    </c:if>
									&nbsp;&nbsp;
									<input name="����" onclick="" className="anniu_btn" action="<%=request.getContextPath()%>/BreedController/returntoList" id="back"/>
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
			 		<span class="required">��ʾ����ɫ�����ʾ������Ʒ����</span>
			    </td>
			</tr>
		 </table>
</body>
</html>
