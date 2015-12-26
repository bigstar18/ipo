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
		<title>托管仓库管理</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript"> 
		
		$(function(){
			$('#commodityName').combobox({
				onSelect: function(){
					$("#commodityId").val($('#commodityName').combobox("getValue"));
				}
			});

		})
		

function add(){
	var breedid=$("#breedid").val();
	var bname=$("#bname").val();
	var concurrency=$("#contractcurrency").val();
    var publishalgr=$("#publishalgr").val();
    var tradealgr=$("#tradealgr").val();
	var flag= $('#frm').form('validate');
	if(bname!=''&&concurrency!= ''&&publishalgr!= ''&&tradealgr!= ''&&flag==true){
            	 $.ajax({  
        			 type: 'GET',  //
        		      url: "<%=request.getContextPath()%>/BreedController/findExsitIds",  
        		     contentType: "application/json; charset=utf-8", 
        		     data:{"breedid":breedid,"randnum":Math.floor(Math.random()*1000000)},  
        			 dataType: 'json',  
        		     success : function(data, stats) { 
        			           if(data=='0'){
        			        	   alert("该品种已配置，请选择其他品种！")
        			           }
                               if(data=='1'){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/BreedController/addBreed",       
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
					alert("所有参数必填！");
		}
}
		
function update(){
	
	var bname=$("#bname").val();
	var concurrency=$("#contractcurrency").val();
	 var tradealgr=$("#tradealgr").val();
	var publishalgr=$("#publishalgr").val();
	var flag= $('#frm').form('validate');
	if(bname!=''&&concurrency!= ''&& publishalgr!= ''&&tradealgr!= ''&&flag==true){
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

function returntoList(){
	var backUrl="<%=request.getContextPath()%>/mgr/app/trusteeship/trustWarehouse.jsp";
	document.location.href = backUrl;
}
			
</script>
</head>
<body leftmargin="14" topmargin="0">
	<form method="POST" action="" name="frm" id="frm">
        <table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
              <fieldset class="pickList" >
	                 <legend class="common"><b><c:if test="${crud == 'update'}">更新</c:if><c:if test="${crud == 'create'}">增加</c:if>托管仓库</b></legend>
		<table border="0" align="center" cellpadding="5" cellspacing="5" class="common" width="100%">
			<tr>
	           	<td align="center" colspan="2" style="color:red">（温馨提示：必须为商品绑定至少一个仓库）</td>
	        </tr>  
	        <tr>
	        	<td align="right" width="40%">托管商品：</td>
	            <td align="left" width="60%">
	                    <c:if test="${crud == 'create'}">
	                   <input id="commodityName" class="easyui-combobox" name="commodityName" data-options="required:true,missingMessage:'必选',valueField:'id',textField:'text',url:'get_data.php'" />
	                   <span class="required">*</span>  
	                    </c:if>
	            		<c:if test="${crud == 'update'}">
	            		<input type="text" id="commodityName" name="commodityName" style="ime-mode:disabled; width: 130;background-color: C0C0C0" readonly="readonly" value="${commName }" />
	            		</c:if>
	            		<input type="hidden" id="commodityId" name="commodityId"  value="${commId }" />
	            </td>
	        </tr>   
	        <tr>
	        	<td align="right">仓库：</td>
	        	<td>
	        	<c:forEach var="warehouse" items="${allWarehouse }" varStatus="status">
                     <div style="width: 100px; float: left;">
						<input type="checkbox" name="warehouse" class="NormalInput" value="${warehouse.id }"/>
						<label class="hand">
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
