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
	history.go(-1);
}


function add(){
	var num = document.getElementById("my").innerHTML;
	var stro = document.getElementById("mystorageid").value;
	var both = num+stro;
	document.getElementById("storageid").value = both;
}


function change(){
	var id = document.getElementById("commodityid").value;
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath()%>/StorageController/auto?commodityid="+id,
		dataType:"json",
		success:function(data){
			if(data != null){
				document.getElementById("commodityname").value = data.commodityname;
			}
			
		}
	});
	
}


function addPoundage(){
	 $.ajax({ 
         type: "post",  
         url: "<%=request.getContextPath()%>/StorageController/add",       
         data: $("#dataForm").serialize(),
         success: function(data) { 
      	   if(data=='true' || data == true){
             alert("添加成功！"); 
      	   }else{
      		   alert("添加失败");  
      	   }
         }
	})
}



</script>
	</head>

	<body>
		<div class="warning">
		<div class="content">
		温馨提示 :入库单添加
		<br>
		<div class="required" style="color: red">系统在此过滤了没有交收属性的商品 </div>
	</div>
	</div>
	<form   name="dataForm" id="dataForm">
		<table border="0" width="95%" height="100" align="center">
								<tr>
									<td>
										<div class="div_cxtj">
											<div class="div_cxtjL"></div>
											<div class="div_cxtjC">
												添加入库单
											</div>
											<div class="div_cxtjR"></div>
										</div>
										<div style="clear: both;"></div>
												<div>
												 
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style">
												<tr>
												<td >
												  <input type="hidden" id="storageid" name="storageid" value="${param.storageid}"/>
												  </td>
													<td >
													入库单号：<U><span id="my">114151226</span></U><input class="required"  id="mystorageid" name="mystorageid"   onblur="add()" /> 
													</td>
													<td >
													商品代码:<select id="commodityid" name="commodityid" value="${param.commodityid}"  onchange="change()"> 
													<option value="" selected></option>
													<c:forEach var="item" items="${namelist}" varStatus="s">
													<option value="${item}">${item}</option>
													</c:forEach>
													</select>
													</td>
													<td >
													商品名称：<input id="commodityname" name="commodityname"    readonly="readonly"/> 
            									   </td>
            									   	<td >
													入库件数：<input id="storagenum" name="storagenum" value="${param.storagenum}"  /> 
            									   </td> 
													<td> 
													<input type="button" value="添加" onclick="addPoundage()" class="anniu_btn"  />
														&nbsp;&nbsp;
													<input type="button" value="关闭" onclick="goBackPage()" class="anniu_btn"  />
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
