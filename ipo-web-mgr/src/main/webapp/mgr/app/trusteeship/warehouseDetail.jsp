<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<%
   String name=(String)request.getAttribute("commName");
   if(name!=null){
	   name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
   }
%>
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
		<title>托管仓库管理</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
		
		$(function(){
			$('#commodityname').combobox({
				 url:'<%=request.getContextPath()  %>/trusteeshipWarehouseController/trusteeCommodity',    
				 valueField:'commodityid',    
				 textField:'commodityname',
				 required:true,
				 missingMessage:'必填',
				 onSelect: function(){
					$("#commodityId").val($('#commodityname').combobox("getValue"));
				}
			});

			    	var warehousesList =<%=request.getAttribute("warehouseList") %>;
			    	var cks = $(":checkbox");
			    	for (j = 0; j < warehousesList.length; j++) {
			    		for (i = 0; i < cks.length; i++) {
			    			if (warehousesList[j] == cks[i].value) {
			    				cks[i].checked = true;
			    			}
			    		}
			    	}
			   	
		})
		

function add(){
	var commId=$("#commodityId").val();
    var warehouseIds = "";
      $('input:checkbox[name=warehouse]:checked').each(function(i){
       if(0==i){
    	   warehouseIds = $(this).val();
       }else{
    	   warehouseIds += (","+$(this).val());
       }
      });
	var flag= $('#frm').form('validate');
	if(flag==true&&warehouseIds!=''){
            	 $.ajax({  
        			 type: 'GET',  //
        		      url: "<%=request.getContextPath()%>/trusteeshipWarehouseController/findExsitIds",  
        		     contentType: "application/json; charset=utf-8", 
        		     data:{"commId":commId,"randnum":Math.floor(Math.random()*1000000)},  
        			 dataType: 'json',  
        		     success : function(data, stats) { 
        			           if(data=='0'){
        			        	   alert("该商品已配置仓库，请到列表页面进行修改！")
        			           }
                               if(data=='1'){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/trusteeshipWarehouseController/addTrusteeWarehouse",       
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
                               if(data=='2'){
                            	   alert("系统内部异常,请联系管理员")
        			           }
        			        }    
        				});
            }
			else{
					alert("商品必选，仓库至少选中一个！");
		}
}
		
function update(){
	
	var commId=$("#commodityId").val();
    var warehouseIds = "";
      $('input:checkbox[name=warehouse]:checked').each(function(i){
       if(0==i){
    	   warehouseIds = $(this).val();
       }else{
    	   warehouseIds += (","+$(this).val());
       }
      });
	var flag= $('#frm').form('validate');
	if(flag==true&&warehouseIds!=''){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/trusteeshipWarehouseController/updateTrusteeWarehouse",       
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
					alert("商品必选，仓库至少选中一个！");
		}
}

function returntoList(){
	var backUrl="<%=request.getContextPath()%>/mgr/app/trusteeship/trustWarehouse.jsp";
	document.location.href = backUrl;
}


			
</script>
</head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : 托管仓库设置 </div>
		<div class="content" style="color: red">（温馨提示：必须为商品绑定至少一个仓库）  </div>
	</div>
	<form method="POST" action="" name="frm" id="frm">
        <table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
              <fieldset class="pickList" >
	                 <legend class="common"><b><c:if test="${crud == 'update'}">更新</c:if><c:if test="${crud == 'create'}">增加</c:if>托管仓库</b></legend>
		<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" width="100%">
			<tr>
	           	<td align="center" colspan="2" style="color:red"></td>
	        </tr>  
	        <tr>
	        	<td align="right" style="font-size:15px" width="20%">托管商品：</td>
	            <td align="left" width="60%">
	                    <c:if test="${crud == 'create'}">
	                   <input style="width:150px;" id="commodityname" name="commodityName"/>
	                   <span class="required">*</span>  
	                    </c:if>
	            		<c:if test="${crud == 'update'}">
	            		<input type="text" id="commodityName" name="commodityName" style="ime-mode:disabled; width:150px;background-color: C0C0C0" readonly="readonly" value="<%=name %>" />
	            		</c:if>
	            		<input type="hidden" id="commodityId" name="commodityId"  value="${commId }" />
	            </td>
	        </tr>   
	        <tr>
	        	<td style="font-size:15px" align="right">仓库：</td>
	        	<td>
	        	<c:forEach var="warehouse" items="${allWarehouse }" varStatus="status">
                     <div style="float:left;white-space:nowrap;display:inline-block;width:150px">
						<input type="checkbox" name="warehouse" style="float:left" class="NormalInput" value="${warehouse.id }"/>
						<label  style="padding-left:2px;padding-right:5px;padding-top:2px" class="hand">
						<c:out value="${warehouse.warehousename }"/>
						</label>
					</div>
			    </c:forEach> 
	        	
	        	
	        	
					<!-- 仓单系统和投资系统共有的仓库集合 -->
	    			
					<!-- 	<input type="checkbox" name="cangku" value="114" checked="checked" />杨羊仓库 -->
					
	        		<!-- 仓单系统中存在，投资系统的仓库中不存在的仓库 -->
	    			
						<!-- <input type="checkbox" name="cangku" value="1001" />天津九星港
					
						<input type="checkbox" name="cangku" value="111" />四川联合仓库
					
						<input type="checkbox" name="cangku" value="001" />1号库
					
						<input type="checkbox" name="cangku" value="2" />长三角仓库
					
						<input type="checkbox" name="cangku" value="3" />王轲菲仓库
					
						<input type="checkbox" name="cangku" value="002" />试用测试仓库
					
						<input type="checkbox" name="cangku" value="011" />jiangmx
					
						<input type="checkbox" name="cangku" value="8" />张丽仓库 -->
					
	        	</td>
	        </tr>  
		  	<tr>
				<td align="center" colspan="2">
					<c:if test="${crud == 'create'}">
					<input type="button" value="添加" onclick="add()"/>
					</c:if>
					<c:if test="${crud == 'update'}">
					<input type="button" value="提交" onclick="update()"/>
					</c:if>
                    &nbsp;&nbsp;
					<input type="button" value="返回" onclick="returntoList()"/>

		    	</td>
		 	</tr>
	    </table>
	</fieldset>
	</td>
	</tr>
</table>
</form>
</body>
</html>
