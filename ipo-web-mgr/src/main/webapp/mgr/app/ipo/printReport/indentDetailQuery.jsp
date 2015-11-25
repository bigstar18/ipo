<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="common/util.jsp" %>
<html>
<head>
<%
    String reportTiltle = "������ϸ��";
%>
<%
	List CateGoryIdList=getList("select id,name from m_firmcategory order by id");  
	pageContext.setAttribute("CateGoryIdList",CateGoryIdList);
   List breedList=getList("select breedId from T_A_Breed");
   pageContext.setAttribute("breedList",breedList);
   List brokerIdList=getList("select brokerId from BR_Broker");
   pageContext.setAttribute("brokerIdList",brokerIdList);
%>
<script src="${publicPath }/js/jquery-1.6.min.js" type="text/javascript"></script>
<script language="javascript">

function onloaddate(){
	var month=new Date().getMonth()+1;
	if(month.toString().length==1){
		month="0"+month;
	}
	var day=new Date().getDate();
	if(day.toString().length==1){
		day="0"+day;
	}	
	document.getElementById("zDate").value=new Date().getYear()+'-'+month+'-'+day;
	
	
}
</script>

</head>

<body onload="onloaddate()">
<FORM METHOD=POST ACTION="" name="frm">
<table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
<fieldset class="pickList" >
	<legend class="common">
		<b>������ϸ��</b>
	</legend>
	<table border="0" align="center" cellpadding="5" cellspacing="5" class="common">
	  <tr>
        <td align="center" colspan="2" style="color:red">�����Ϊ��ѯȫ����</td>
      </tr>
		<tr>
        <td align="right">�����̣�</td>
        <td>
        <INPUT TYPE="text" NAME="BrokerId" value="" style="ime-mode:disabled" size="15" maxlength="4"  onkeypress="notSpace()" id="brokerId" onblur="fandealcontentBroker(this)">
         <SELECT name="select5"  onchange="dealcontentBroker(this)">
         <OPTION value="">��ѡ��</OPTION>
         <c:forEach items="${brokerIdList}" var="result">
	     <option value="${result.brokerId}">${result.brokerId}</option>
		 </c:forEach>
          </SELECT>   
		  <span class="req"></span>
        </td>
      </tr>   
      
       <tr>
	        <td align="right">���������</td>
	        <td>
	        <INPUT TYPE="text" NAME="cateGoryId" value="" style="ime-mode:disabled" size="15" maxlength="10"  onkeypress="notSpace()" id="cateGoryId" onblur="fandealcontentCateGory(this)">
	         <SELECT name="select8" id="cateGorySel"  onchange="dealcontentCateGory(this)">
	         <OPTION value="">��ѡ��</OPTION>
	         <c:forEach items="${CateGoryIdList}" var="result">
		     <option value="${result.id}">${result.name}</option>
			 </c:forEach>
	          </SELECT>   
			  <span class="req"></span>
	        </td>
       </tr> 
		<tr>
        <td align="right">��ʼ�����̣�</td>
        <td>
        <INPUT TYPE="text" NAME="zStart" value="" style="ime-mode:disabled" size="15" maxlength="32" onkeypress="notSpace()" >
         <div id="divContent" style="display:none; position:absolute; background-color:#ffffff;border: solid 1px #9DCEE8;"></div>  
		  <span class="req"></span>
        </td>
      </tr>       
      <tr>
        <td align="right">���������̣�</td>
        <td>
          <div align="left">
            <INPUT TYPE="text" NAME="zEnd" value=""  style="ime-mode:disabled"  size="15" maxlength="32"  onkeypress="notSpace()">
            <div id="divContentEnd" style="display:none; position:absolute; background-color:#ffffff;border: solid 1px #9DCEE8;"></div>  
		     <span class="req"></span>
            </div></td>
      </tr>   
      <tr>
        <td align="right">Ʒ�֣�</td>
        <td>
        <INPUT TYPE="text" NAME="breed" style="ime-mode:disabled"  id="breedId" value="" size="15" maxlength="10" onblur="dealcontentStartBreed(this)" onkeypress="notSpace()"/>
         <SELECT name="selectStartBreed" onchange="dealcontentBreed(this)"  >
         <OPTION value="">��ѡ��</OPTION>
         <c:forEach items="${breedList}" var="breed">
	     <option value="${breed.breedId}">${breed.breedId}</option>
		 </c:forEach>
          </SELECT>   
		  <span class="req"></span>
        </td>
      </tr> 
      <tr>
        <td align="right">��ʼ��Ʒ��</td>
        <td>
        <INPUT TYPE="text" NAME="zStartCommodity" style="ime-mode:disabled"   value="" size="15" maxlength="10" onblur="dealcontentStrartCommodity(this)" onkeypress="notSpace()">
         <SELECT name="selectStartCommodity" onchange="dealcontentCommodity(this)" style="width:100px;" >
         <OPTION value="">��ѡ��</OPTION>
         <c:forEach items="${listAsc}" var="commodity">
	     <option value="${commodity.COMMODITYID}">${commodity.COMMODITYID}</option>
		 </c:forEach>
          </SELECT>   
        </td>
      </tr> 
       <tr>
        <td align="right">������Ʒ��</td>
        <td>
          <div align="left">
            <INPUT TYPE="text" NAME="zEndCommodity" style="ime-mode:disabled"  value="" size="15" maxlength="10" onblur="dealcontentEndCommodity1(this)" onkeypress="notSpace()">
            <SELECT  name="selectEndCommodity" onchange="dealcontentCommodity1(this)" style="width:100px;">
            <OPTION value="">��ѡ��</OPTION>
            <c:forEach items="${listDESC}" var="commodity">
	        <option value="${commodity.COMMODITYID}">${commodity.COMMODITYID}</option>
		    </c:forEach>
          </SELECT>   
            </div></td>
      </tr>    
		<tr>
        <td align="right">������</td>
        <td>
          <div align="left">
            <SELECT  name="bs">
            <OPTION value="">��ѡ��</OPTION>
	        <option value="1">��</option>
			<option value="2">��</option>
			<option value="3">ȫ��</option>
          </SELECT>   
		  <span class="required">*</span>
            </div></td>
      </tr>    
		 
      <tr>
        <td align="right">��ѯ���ڣ�</td>
        <td >
        	<input type="text" style="width: 100px" id="zDate"
				class="wdate" maxlength="10" name="zDate"
				value="" onblur="onloaddate()"
				onFocus="WdatePicker({el:this,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})">
			<span class="required">*</span>
      </tr>
	 
	
    </table>
    
	<table border="0" align="center" cellpadding="5" cellspacing="5" class="common">
		<tr>
				<td>
				<rightButton:rightButton name="�鿴" onclick="return query('pdf')" className="btn_sec" action="${basePath}/timebargain/indentDetailReport/indentDetailReport.action" id="add"></rightButton:rightButton>
	     		</td>
	     		<td>
	     		<rightButton:rightButton name="����Ϊexcel" onclick="return query('excel')" className="btn_sec1" action="${basePath}/timebargain/indentDetailReport/indentDetailReportExcel.action" id="saveExcel"></rightButton:rightButton>
	     		</td>
		</tr>
	</table>
	</fieldset>
	</td>
	</tr>
</table>
</FORM>
</body>

</html>
<SCRIPT LANGUAGE="JavaScript">
function ajaxCommodityIdByBreedrId(breedId){
	
    $.ajax({
		type: "post",
		url: "../../ajaxcheck//tAPLStatisticReport/checkBreed.action",
		data: {
    	breedId: breedId
			  },
		success : function(data){
				    var selectStartCommodity=document.getElementById("selectStartCommodity");
		    		var selectEndCommodity=document.getElementById("selectEndCommodity");
		    		selectStartCommodity.length=1;
		    		selectEndCommodity.length=1;

		    		var datas=data.split("|");
		    		for(var i=0;i<datas.length-1;i++){
		    			var str=datas[i].split("=")[1].substring(0,datas[i].split("=")[1].length-1);
		    			var option=document.createElement("option");
		    			option.text=str;
		    			option.value=str;
		    			selectStartCommodity.add(option);
		    		}
		    		for(var i=datas.length-2;i>=0;i--){
		    			var str=datas[i].split("=")[1].substring(0,datas[i].split("=")[1].length-1);
		    			var option=document.createElement("option");
		    			option.text=str;
		    			option.value=str;
		    			selectEndCommodity.add(option);
		    		}
		          }
	});
}
function dealcontentBreed(sel)
{
    document.forms[0].breed.value=sel.options[sel.selectedIndex].value;
    ajaxCommodityIdByBreedrId(sel.options[sel.selectedIndex].value);
}
function dealcontentStartBreed(sel)
{
    var len=document.forms[0].selectStartBreed.options.length;
    
    for(var i=0;i<len;i++)
    {
        if(document.forms[0].selectStartBreed.options[i].value-sel.value==0)
        {
            document.forms[0].selectStartBreed.options[i].selected=true;
            break;
        }
    }
    var breedId=document.getElementById("breed").value;
    ajaxCommodityIdByBreedrId(breedId);
}

function dealcontentCateGory(sel)
{
    document.forms[0].cateGoryId.value=sel.options[sel.selectedIndex].innerHTML;
}
function fandealcontentCateGory(sel)
{

    var len=document.forms[0].select8.options.length;
    
    for(var i=0;i<len;i++)
    {
        if(document.forms[0].select8.options[i].value-sel.value==0)
        {
            document.forms[0].select8.options[i].selected=true;
            break;
        }
        //document.forms[0].FIRM_ID.value=sel.options[sel.selectedIndex].value;
    }
}
function dealcontentBroker(sel)
{
    document.forms[0].BrokerId.value=sel.options[sel.selectedIndex].value;
}
function fandealcontentBroker(sel)
{

    var len=document.forms[0].select5.options.length;
    
    for(var i=0;i<len;i++)
    {
        if(document.forms[0].select5.options[i].value-sel.value==0)
        {
            document.forms[0].select5.options[i].selected=true;
            break;
        }
        //document.forms[0].FIRM_ID.value=sel.options[sel.selectedIndex].value;
    }
}

function dealcontentCommodity(sel)
{
    document.forms[0].zStartCommodity.value=sel.options[sel.selectedIndex].value;
}
function dealcontentStrartCommodity(sel)
{

    var len=document.forms[0].selectStartCommodity.options.length;
    
    for(var i=0;i<len;i++)
    {
        if(document.forms[0].selectStartCommodity.options[i].value-sel.value==0)
        {
            document.forms[0].selectStartCommodity.options[i].selected=true;
            break;
        }
    }
}

function dealcontentCommodity1(sel)
{
    document.forms[0].zEndCommodity.value=sel.options[sel.selectedIndex].value;
}
function dealcontentEndCommodity1(sel)
{

    var len=document.forms[0].selectEndCommodity.options.length;
    
    for(var i=0;i<len;i++)
    {
        if(document.forms[0].selectEndCommodity.options[i].value-sel.value==0)
        {
            document.forms[0].selectEndCommodity.options[i].selected=true;
            break;
        }
    }
}
function query(exportTo)
{
    var zStart=document.forms[0].zStart.value;
    var zEnd=document.forms[0].zEnd.value;
    var zStartCommodity=document.forms[0].zStartCommodity.value;
	var zEndCommodity=document.forms[0].zEndCommodity.value;
	var bs = document.forms(0).bs.value;
    var zDate=document.forms[0].zDate.value;	
    var brokerId =document.forms[0].BrokerId.value;
	var breedId =document.forms[0].breed.value;
	var cateGoryId = document.getElementById("cateGorySel").value;

	if (zStart == "" && zEnd != "") {
		alert("��ʼ�����̲���Ϊ�գ�");
		return false;
	}
	if (zEnd == "" && zStart != "") {
		alert("���������̲���Ϊ�գ�");
		return false;
	}
	if (zStartCommodity == "" && zEndCommodity !="") {
		alert("��ʼ��Ʒ����Ϊ�գ�");
		return false;
	}
	if (zEndCommodity == "" && zStartCommodity != "") {
		alert("������Ʒ����Ϊ�գ�");
		return false;
	}
	if (bs == "") {
		alert("��������Ϊ�գ�");
		return false;
	}
	if (zDate == "") {
		alert("��ѯ���ڲ���Ϊ�գ�");
		return false;
	}
	if(zStart =="" && zEnd ==""){
		zStart = null;
		zEnd = null;
	}
	if(zStartCommodity == "" && zEndCommodity ==""){
		zStartCommodity =null;
		zEndCommodity = null;
	}
	if(breedId ==""){
		breedId=null;
	}
	if(brokerId ==""){
		brokerId = null;
	}
	if(cateGoryId == ""){
		cateGoryId=null;
	}
	
	if(exportTo=="excel"){		
		var url="${mgrPath}/app/timebargain/printReport/indentDetailReportExcel.jsp?startFirmID="+zStart +"&endFirmID="+ zEnd +"&startCommodityID=" + zStartCommodity + "&endCommodityID=" + zEndCommodity + "&bs=" + bs + "&cleardate=" + zDate +"&title=������ϸ��&brokerId="+brokerId+"&breedId="+breedId+"&cateGoryId="+cateGoryId;
		document.location.href = url;
	 }else{
		//��ȡ����Ȩ�޵� URL		
		var url="${mgrPath}/app/timebargain/printReport/indentDetailReport.jsp?startFirmID="+zStart +"&endFirmID="+ zEnd +"&startCommodityID=" + zStartCommodity + "&endCommodityID=" + zEndCommodity + "&bs=" + bs + "&cleardate=" + zDate +"&title=������ϸ��&brokerId="+brokerId+"&breedId="+breedId+"&cateGoryId="+cateGoryId;
		showDialog(url, "", 900, 650);
	}
}
</SCRIPT>