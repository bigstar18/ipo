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
		<title>发行会员库存转持仓录入</title>
		<style type="text/css">
			legend{font-weight:bold;}
		</style>
		<script type="text/javascript">
function add(){
	var flag= $('#frm').form('validate');
	if(flag==true){
		var totalcounts=parseInt($("#totalcounts").val());
		var counts=parseInt($("#counts").val());
		var salecounts=parseInt($("#salecounts").val());
		if(totalcounts<counts&&salecounts!=0){
			alert("总入库量小于发行量，只能全部转持仓！");
			$("#salecounts").val(0);
			$("#pubposition").val(totalcounts);
		}
		if(confirm("确定添加本记录吗？")){
		 $.ajax({  
			 type: 'POST', 
		     url: "<%=request.getContextPath()%>/PublisherController/checkSaleCounts",  
		     data:{"salecounts":salecounts,"commodityid":$("#commodityid").val(),"counts":$("#counts").val()},
		     success : function(data, stats) { 
			           if(data=='false'){
			        	   alert("发售数量已满，请全部转持仓");
			        	   return ;
			           }
                       if(data=='true'){
                            	   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: "<%=request.getContextPath()%>/PublisherController/addPublisherPosition",       
                                       data: $("#frm").serialize(),      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("添加成功！"); 
                                           returntoList();
                                    	   }else{
                                    		   alert("添加失败！");  
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("请求失败！");  
                                       }  
                                   }) ;
                       }
			        }    
				}); }
        			        }    
}
		

function returntoList(){
	var backUrl="<%=request.getContextPath()%>/mgr/app/publisherQuery/transferPosition.jsp";
	document.location.href = backUrl;
}
	
<%-- function setSortName(value) {
	var commList =<%=request.getAttribute("commList") %>; 
	 for(var o in commList){  
	        if (value == commList[o].commodityid ) {
				$("#commodityname").val(commList[o].commodityname);
				$("#publisherid").val(commList[o].pubmemberid);
				$("#publishername").val("");
				var brokerlist=<%=request.getAttribute("brokerlist") %>; 
				for(var i in brokerlist){
					if ($("#publisherid").val() == brokerlist[i].brokerid ) {
						$("#publishername").val(brokerlist[i].name);
						break;
					}
				}
				break;
		}
	 }  
} --%>
	
function getPosition(){
	
	var totalcounts=parseInt($("#totalcounts").val());
	if($("#salecounts").val()!='')
	{
		var salecounts=parseInt($("#salecounts").val());
		$("#pubposition").val(totalcounts-salecounts);
	}else{
	$("#pubposition").val("");
	}
}


</script>
</head>
<body leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 :  发行会员库存转持仓录入</div>
		<div class="content" style="color: red"> 添加应付发行商的货款信息。</div>
	</div>
	<form method="POST" action="" name="frm" id="frm">
        <table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
              <fieldset class="pickList" >
	                 <legend class="common"><b>发行会员库存转持仓</b></legend>
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
	        	<td>
	        	
	        	<input type="text" id="commodityid" name="commodityid" value="${entity.commodityid }" readonly="readonly"/>
	        	</td>
	        	<td style="font-size:15px" align="right" width="20%">商品名称：</td>
	        	<td>
	        	<input type="text" id="commodityname" name="commodityname" value="${entity.commodityname }" readonly="readonly"/>
	        	</td>
	        </tr>  
	         <tr>
	        	<td style="font-size:15px" align="right" width="20%">发行会员代码：</td>
	        	<td>
	        	<input type="text" id="publisherid" name="publisherid" value="${entity.pubmemberid }" readonly="readonly"/>
	        	</td>
	        	<td style="font-size:15px" align="right" width="20%">发行会员名称：</td>
	        	<td>
	        	<input type="text" id="publishername" name="publishername" value="${entity.publishername }" readonly="readonly"/>
	        	</td>
	        </tr> 
	         <tr>
	        	<td style="font-size:15px" align="right" width="20%">发行数量：</td>
	        	<td>
	        	<input type="text" id="counts" name="counts"  value="${entity.counts }" readonly="readonly"/>
	        	</td>
	        	<td style="font-size:15px" align="right" width="20%">入库单号：</td>
	        	<td>
	        	<input type="text" id="storageid" name="storageid" value="${entity.storageid }" readonly="readonly"/>
	        	</td>
	        </tr> 
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">入库数量：</td>
	        	<td>
	        	<input type="text" id="totalcounts" name="totalcounts"  value="${entity.storagecounts }" readonly="readonly"/>
	        	</td>
	        	<td style="font-size:15px" align="right" width="20%">鉴定总值：</td>
	        	<td>
	        	<input type="text" id="totalvalue" name="totalvalue" class="easyui-numberbox" data-options="required:true,min:0,precision:2,missingMessage:'必填'"/><span class="required">*</span>
	        	</td>
	        </tr>  
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">转发售量：</td>
	        	<td>
	        	
	        	<input type="text" onblur="getPosition()" class="easyui-numberbox" data-options="required:true,min:0,missingMessage:'必填'" id="salecounts" name="salecounts"/><span class="required">*</span>
	        	</td>
	        	<td style="font-size:15px" align="right" width="20%">转持仓量：</td>
	        	<td>
	        	<input type="text" id="pubposition" name="pubposition"  readonly="readonly"/>
	        	</td>
	        </tr>  
		  	<tr>
				<td align="right">
		    	</td>
		    	<td align="right"><input type="button" value="添加" onclick="add()"/></td>
		    	<td align="left"><input type="button" value="返回" onclick="returntoList()"/>
		    	</td>
		    	<td align="right"></td>
		 	</tr>
	    </table>
	</fieldset>
	</td>
	</tr>
</table>
</form>
</body>
</html>
