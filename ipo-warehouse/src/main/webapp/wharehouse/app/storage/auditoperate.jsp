<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/wharehouse/public/includefiles/allincludefiles.jsp"%>

<html>
	<head>
	    <base target="_self" />
		<title>添加入库单</title>
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
	<%-- document.location.href = "<%=request.getContextPath()%>/SpacialSetController/goBackPage?randnum="+Math.floor(Math.random()*1000000); --%>
}


function changeState(){
	var id = document.getElementById("storageid").value;
	alert(id);
	 $.ajax({ 
		 url: "<%=request.getContextPath()%>/StorageController/pass?storageid="+id,  
		 type: 'POST',
		 dataType: 'String',  
         success: function(data) { 
      	   if(data=='true' || data == true || data eq 'true'){
             alert("添加成功！"); 
      	   }else{
      		   alert("添加失败");  
      	   }
         }
	})
}

function modifyState(){
	var id = document.getElementById("storageid").value;
	 $.ajax({ 
		 url: "<%=request.getContextPath()%>/StorageController/back?storageid="+id,  
		 type: 'POST',
		 dataType: 'String',  
         success: function(data) { 
      	   if(data=='true' || data == true || data eq 'true'){
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
		<form>
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
											<table border="0" cellspacing="0" cellpadding="4" width="100%" align="center" class="table2_style"
											 >
												<tr>
													<td >
													入库单号:<input id="storageid" name="storageUnionVo.storageid" value="${storageUnionVo.storageid}" readonly="readonly"/> 
													</td>
													<td >
														商品代码:<input  name="storageUnionVo.commodityid" value="${storageUnionVo.commodityid}"  readonly="readonly"/> 
													</td>
													<td >
													商品名称：<input name="storageUnionVo.commodityname" value="${storageUnionVo.commodityname}"   readonly="readonly"/> 
            									   </td>
													<td > 
													<td >
													发行会员代码：<input name="storageUnionVo.brokerid" value="${storageUnionVo.brokerid}"   readonly="readonly"/> 
            									   </td>
            									   <td >
													发行会员名称：<input name="storageUnionVo.name" value="${storageUnionVo.name}"  readonly="readonly"/> 
            									   </td>
            									   	<td >
													入库件数：<input  name="storageUnionVo.storagenum" value="${storageUnionVo.storagenum}"  readonly="readonly"/> 
            									   </td>
            									   <td >
													入库数量：<input name="storageUnionVo.instoragenum" value="${storageUnionVo.instoragenum}"  readonly="readonly"/> 
            									   </td>
													<td> 
													<input type="button" value="通过" onclick="changeState()" class="anniu_btn"  id="add"/>
														&nbsp;&nbsp;
														<input type="button" value="驳回" onclick="modifyState()" class="anniu_btn"  id="add"/>
														&nbsp;&nbsp;
													<input type="button" value="关闭" onclick="goBackPage()" class="anniu_btn"  id="back"/>
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
