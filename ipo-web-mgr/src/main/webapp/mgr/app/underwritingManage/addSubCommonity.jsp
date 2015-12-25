<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
	<head>
	    <base target="_self" />
		<title>承销商认购设置</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
        <script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		
<script type="text/javascript"> 

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


	

</script>
	</head>

	<body>
	<div class="warning">
		<div class="content" >
			<span>温馨提示 :</span>
			<span>认购商品添加</span>
		</div>
	</div>
		<form id="frm" name="frm">
			<div class="div_cx" >
				<table border="0" width="100%"align="center">
					<tr>
						<td>
							<table border="0" width="95%" height="100" align="center">
								<tr>
									<td>
										<div class="div_cxtj">
											<div class="div_cxtjL"></div>
											<div class="div_cxtjC">
												添加认购商品
											</div>
											<div class="div_cxtjR"></div>
										</div>
										<div style="clear: both;"></div>
												<div>
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
												<tr>
													
													<td align="center">
														<span class="required">*</span>
														承销会员编号：
													</td>
													<td>
													<input id="frimId" name="frimId" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width: 160"/> 
													</td>
												</tr>
												<tr>
													<td align="center">
														<span class="required">*</span>
														商品代码：
													</td>
													<td>
														<select id="commodity" name="commodity" style="width:160">
															  <option value="">请选择</option>
									                          <option value="0">无效</option>
										                      <option value="1" selected="selected">正常</option>
														</select>
													</td>
													</tr>
													<tr>
													<td align="center">
														<span class="required">*</span>
														认购数量：
													</td>
													<td>
													<input id="counts" name="counts" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width: 160"/> 
													</td>
													</tr>
													<tr>
												
													<td align="center">
														<span class="required">*</span>
														占承销会员手续费总和比例（%）：
													</td>
													<td>
													<input id="radio" name="radio" value="" 
            								class="easyui-validatebox textbox" data-options="required:true,missingMessage:'必填项'" validtype="length[0,20]"  invalidMessage="最大长度20位"  style="width: 160"/> 
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
								</div>
							</td>
					</tr>
				</table>
			</div>
			
		</form>
				
	</body>
</html>
