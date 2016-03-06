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
		<title>认购商品成交页面</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript">
function add(){
	if($("#commodityid").val()==''){
		alert("请选择商品");
		return;
	}
    $.ajax({ 
         cache:false,
         type: "post",  
         url: "<%=request.getContextPath()%>/UnderwriterSetController/unfrozenSubFunds",       
         data: $("#frm").serialize(),      
         success: function(data) { 
                   if(data=='true'){
                     alert("处理成功!");
                     returntoList();
                   }
                   if(data=='false'){
                	   alert("处理失败!"); 
                   }
                 },  
          error: function(data) {  
                   alert("请求失败!");  
                }  
         }) ;
}

function returntoList(){
	var backUrl="<%=request.getContextPath()%>/mgr/app/underwritingManage/subFundsProcessing.jsp";
	document.location.href = backUrl;
}

function onlyNumberInput(){
	 if (event.keyCode<46 || event.keyCode>57 || event.keyCode == 47){
		    event.returnValue=false;
	 }
}

function setSortName(value) {
	if(value==''){
		$("#subscribecounts").numberbox("setValue","0");
		$("#subscribeprice").numberbox("setValue","0.00");
		$("#loan").numberbox("setValue","0.00");
		return;
	}
	var commList =<%=request.getAttribute("subCommlist") %>; 
	 for(var o in commList){  
	        if (value == commList[o].commodityid ) {
				$("#subscribecounts").numberbox("setValue",commList[o].subscribecounts);
				$("#subscribeprice").numberbox("setValue",commList[o].subscribeprice);
				break;
		}
	 } 
	 $("#loan").numberbox("setValue",parseFloat($("#subscribecounts").val())*parseFloat($("#subscribeprice").val()));
}
			
</script>
</head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 :  认购成交页面</div>
		<div class="content" style="color: red"> 显示承销商认购的商品信息，并解冻预付货款</div>
	</div>
	<form method="POST" action="" name="frm" id="frm">
        <table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
              <fieldset class="pickList" >
	                 <legend class="common"><b>认购商品</b></legend>
		<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" width="100%">
			<tr>
	           	<td align="center" colspan="2" style="color:red"></td>
	        </tr>  
	        <tr>
	        	<td align="right" style="font-size:15px" width="50%">承销会员编号：</td>
	            <td align="left" width="60%">
	                   <input style="width:150px;" id="underwriterid" name="underwriterid" readonly="readonly" value="${brokerid }"/>
	                   <span class="required">*</span>  
	            </td>
	        </tr>   
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">商品代码：</td>
	        	<td align="left" width="60%">
	        	<select id="commodityid" name="commodityid" style="width:150px" onchange="setSortName(this.value)">
						<option value="">请选择</option>
                         <c:forEach var="commodity" items="${subCommList}">
                         <option value="${commodity.commodityid}">${commodity.commodityid}</option>
                          </c:forEach>
				</select>
				<span class="required">*</span>
	        	</td>
	        </tr>  
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">认购数量(个)：</td>
	        	<td align="left" width="60%">
	        	 <input style="width:150px;" id="subscribecounts" name="subscribecounts"  
	        	 class="easyui-numberbox" data-options="required:true,min:0,disabled:true"/>
	        	</td>
	        </tr> 
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">认购价格(元/个)：</td>
	        	<td align="left" width="60%">
	        	 <input style="width:150px;" id="subscribeprice" name="subscribeprice"
	        	  class="easyui-numberbox" data-options="required:true,min:0,precision:2,disabled:true"/>
	        	</td>
	        </tr> 
	         <tr>
	        	<td style="font-size:15px" align="right" width="20%">应付货款(元)：</td>
	        	<td align="left" width="60%">
	        	 <input style="width:150px;" id="loan" name="loan" 
	        	 class="easyui-numberbox" data-options="required:true,min:0,precision:2,disabled:true"/>
	        	</td>
	        </tr> 
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">预付货款(元)：</td>
	        	<td align="left" width="60%">
	        	 <input style="width:150px;" id="proportion" name="proportion" 
	        	 class="easyui-numberbox" data-options="required:true,min:0,precision:2,disabled:true" value="${deposit.amount}"/>
	        	</td>
	        </tr>  
		  	<tr>
				<td align="right">
					<input type="button" value="提交" onclick="add()"/>
		    	</td>
		    	<td align="left"><input type="button" value="返回" onclick="returntoList()"/></td>
		 	</tr>
	    </table>
	</fieldset>
	</td>
	</tr>
</table>
</form>
</body>
</html>
