<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/wharehouse/public/includefiles/allincludefiles.jsp"%>

<html>
	<head>
	    <base target="_self" />
		<title>入库添加</title>
		 <link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
		<link rel="stylesheet" href="${skinPath }/css/common.css" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		
<script type="text/javascript"> 

function goBackPage(){
	document.location.href = "<%=request.getContextPath()%>/SpacialSetController/goBackPage?randnum="+Math.floor(Math.random()*1000000);
}

function addPoundage(){
	 $.ajax({ 
		 cache:false,
         type: "post",  
         url: "<%=request.getContextPath()%>/SpacialSetController/addPoundage",       
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
	})
}

function updatePoundage(){
	var bname=$("#bname").val();
	var concurrency=$("#contractcurrency").val();
	var publishalgr=$("#publishalgr").val();
	var flag= $('#frm').form('validate');
	if(bname!=''&&concurrency!= ''&& publishalgr!= ''&&flag==true){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/BreedController/updateBreed",       
                                       data: $("#frm").serialize(),      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("修改成功！"); 
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

</script>
	</head>

	<body>
		<div class="warning">
		<div class="content">
		温馨提示 :出库添加
		<br>
		<div class="required" style="color: red">提货类型为自提时需要提货单密码，在线配送是不需要提货单密码！  </div>
	</div>
	</div>
		<form>
		<table border="0" width="95%" height="100" align="center">
								<tr>
									<td>
										<div class="div_cxtj">
											<div class="div_cxtjL"></div>
											<div class="div_cxtjC">
												基本信息
											</div>
											<div class="div_cxtjR"></div>
										</div>
										<div style="clear: both;"></div>
												<div>
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
												<tr>
													
													<td align="center">
														<span class="required">*</span>
														提货单号：
													</td>
													<td>
													<input id="name" name="name" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width: 180px"/> 
													</td>
													<td align="center">
														<span class="required">*</span>
														提货单密码：
													</td>
													<td>
														<input id="name" name="name" value="" class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width: 180px"/> 
													</td>
													<td> 	
													<input type="button" value="添加" onclick="addPoundage()" class="anniu_btn"  id="add"/>
														&nbsp;&nbsp;
													<input type="button" value="返回" onclick="goBackPage()" class="anniu_btn"  id="back"/>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
		</form>
				
	</body>
</html>
