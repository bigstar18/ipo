<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
	<head>
	    <base target="_self" />
		<title>添加特殊手续费</title>
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
		<form id="frm" name="frm">
			<div class="div_cx">
				<table border="0" width="100%" align="center">
					<tr>
						<td>
							<div class="warning">
								<div class="content">
									温馨提示 :特殊手续费添加
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
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
														交易商代码：
													</td>
													<td>
													<input id="name" name="name" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width: 160"/> 
													</td>
													<td align="center">
														<span class="required">*</span>
														商品代码：
													</td>
													<td>
														<select id="status" name="status" style="width:120">
															  <option value="">请选择</option>
									                          <c:forEach var="commId" items="${commIds}">
                                                      		  	<option value="${commId}">${commId}</option>
                                                  			  </c:forEach>
														</select>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<table border="0" width="95%" height="100" align="center">
								<tr>
									<td>
										<div class="div_cxtj">
											<div class="div_cxtjL"></div>
											<div class="div_cxtjC">
												手续费
											</div>
											<div class="div_cxtjR"></div>
										</div>
										<div style="clear: both;"></div>
												<div>
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
												<tr>
													<td align="center">
														<span class="required">*</span>
														发行特殊手续费算法：
													</td>
													<td>
														<select id="status" name="status" style="width:120">
															  <option value="">请选择</option>
									                          <option value="0">按百分比</option>
										                      <option value="1" selected="selected">按绝对值</option>
														</select>
													</td>
													<td align="center">
														<span class="required">*</span>
														发行特殊手续费比例：
													</td>
													<td>
													<input id="name" name="name" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width:160"/> 
													</td>
												</tr>


											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								    	<input type="button" value="添加" onclick="addPoundage()" class="anniu_btn"  id="add"/>
										&nbsp;&nbsp;
										<input type="button" value="返回" onclick="goBackPage()" class="anniu_btn"  id="back"/>
								</div>
							</td>
					</tr>
				</table>
			</div>
			
		</form>
				
	</body>
</html>
