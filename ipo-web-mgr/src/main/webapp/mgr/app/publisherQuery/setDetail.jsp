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
		<title>货款跟踪录入单</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript">
function add(){
	if($("#commodityid").val()==''){
		alert("请选择商品");
		return;
	}
	if($("#status").val()==''){
		alert("请选择状态");
		return;
	}
	var flag= $('#frm').form('validate');
	if(flag==true){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/PublisherController/addPaymentTrack",       
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
                                           alert("系统异常，请联系管理员！");  
                                       }  
                                   }) ;
        			        }    
}
		

function returntoList(){
	var backUrl="<%=request.getContextPath()%>/mgr/app/publisherQuery/paymentTracking.jsp";
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
		<div class="title font_orange_14b">温馨提示 :  货款跟踪录入</div>
		<div class="content" style="color: red"> 添加应付发行商的货款信息。</div>
	</div>
	<form method="POST" action="" name="frm" id="frm">
        <table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
              <fieldset class="pickList" >
	                 <legend class="common"><b>录入货款跟踪信息</b></legend>
		<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" width="100%">
			<tr>
	           	<td align="center" colspan="2" style="color:red"></td>
	        </tr>  
	       <!--  <tr>
	        	<td align="right" style="font-size:15px" width="50%">发行会员编号：</td>
	            <td align="left" width="60%">
	                   <input style="width:150px;" id="pubmemberid" name="pubmemberid"/>
	                   <span class="required">*</span>  
	            </td>
	        </tr>    -->
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">商品代码：</td>
	        	<td align="left" width="60%">
	        	<select id="commodityid" name="commodityid" style="width:150px" >
						<option value="">请选择</option>
                         <c:forEach var="commodity" items="${commlist}">
                         <option value="${commodity.commodityid}">${commodity.commodityid}${commodity.commodityname}</option>
                          </c:forEach>
				</select><span class="required">*</span>
	        	</td>
	        </tr>  
	         <tr>
	        	<td style="font-size:15px" align="right" width="20%">应付货款：</td>
	        	<td align="left" width="60%">
	        	 <input style="width:150px;" id="payables" name="payables"
	        	  class="easyui-numberbox" data-options="required:true,missingMessage:'请填入正数',min:0,max:99999999999999,precision:2"/><span class="required">*</span>
	        	
	        	</td>
	        </tr> 
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">状态：</td>
	        	<td align="left" width="60%">
	        	<select id="status" name="status" style="width:150px">
	        	 <option value="">请选择</option>
			     <option value="1">未付款</option>
				 <option value="2">已付款</option>
	        	</select><span class="required">*</span>
	        	</td>
	        </tr>  
		  	<tr>
				<td align="right">
					<input type="button" value="添加" onclick="add()"/>
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
