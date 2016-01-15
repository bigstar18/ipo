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
		<title>暂扣货款</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript">
function add(){
	var flag= $('#frm').form('validate');
	if(flag==true){
		$.ajax({  
			type: "post",  
            url: "<%=request.getContextPath()%>/PublisherController/checkFundsAvailable",       
            data:  {"underwriterid":$("#underwriterid").val(),"amount":$("#amount").val()}       ,      
            success: function(data) { 
		              if(data=='true') {
            	                $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/UnderwriterSetController/deductMoney",       
                                       data: $("#frm").serialize(),      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("扣款成功！"); 
                                           returntoList();
                                    	   }else{
                                    		   alert("扣款失败！");  
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("系统异常，请联系管理员！");  
                                       }  
                                   }) ;}
		              if(data=='false'){
		            	  alert("资金不足！");
		              }
            },  
            error: function(data) {  
                alert("请求失败，无法扣款！");  
            }  
        }) ;
	}            
}
		

function returntoList(){
	var backUrl="<%=request.getContextPath()%>/mgr/app/underwritingManage/underwritingSet.jsp";
	document.location.href = backUrl;
}
			
</script>
</head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 :  承销设置</div>
		<div class="content" style="color: red"> 可分多次扣除承销商的认购货款。</div>
	</div>
	<form method="POST" action="" name="frm" id="frm">
        <table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
              <fieldset class="pickList" >
	                 <legend class="common"><b>暂扣货款</b></legend>
		<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" width="100%">
			<tr>
	           	<td align="center" colspan="2" style="color:red"></td>
	        </tr>  
	        <tr>
	        	<td align="right" style="font-size:15px" width="45%">承销会员编号：</td>
	            <td align="left" width="60%">
	                   <input style="width:150px;" id="underwriterid" name="underwriterid" value="${underwriterId }"/>
	                    <input type="hidden" id="subscribeid" name="subscribeid" value="${subscribeid }"/>
	                   <span class="required">*</span>  
	            </td>
	        </tr>  
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">预付货款金额：</td>
	        	<td align="left" width="60%">
	        	 <input style="width:150px;" id="amount" name="amount" 
	        	 class="easyui-numberbox" data-options="required:true,missingMessage:'必填',min:0,precision:2"/>
	                   <span class="required">*</span>
	        	</td>
	        </tr> 
	        </table>
	        <br>
	        <table style="width:85%">
	         <tr>
        		<td align="right" width="15%">备注：</td>
	      		<td style="width:100%;">
	      		<textarea id="remark" name="remark" style="width:100%;" rows="4"></textarea>
				</td>
			</tr>  
		  
	    </table>
	    <br>
	    <table style="width:100%">
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
