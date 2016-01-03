<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>在线委托申请</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
  <link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript">
  
      function save(){
    	   
    	  if(dataForm.applyAmount.value==""){
    		  alert('申购数量不能为空!');return false;
    	  };
    	  if(parseInt(dataForm.applyAmount.value)>parseInt(dataForm.counts.value)){
    		  alert('申购数量不能大于发行数量!');return false;
    	  };
    	  $.ajax({  
  		    url: "${root}/trusteeshipCommodityController/saveApply",  
  		    data:$('#dataForm').serialize(),  
  		    type: 'POST',dataType: 'json',  
  		    success : function(data, stats) {  
  	             if(data==true||data=="true"){
  	            	 alert('保存成功');
  	            	 window.close();
  	             }else{
  	            	 alert('保存失败');
  	             }
  	        },
	  	    error: function (jqXHR, textStatus, errorThrown) {
	              alert('系统异常!');
	        }
  		});  
    	  
      }
  
  
  </script>
</head>

 <body >
    
    <div id="tb" style="padding:15px;height:auto" >
	    <div>
		 <form   name="dataForm" id="dataForm">
		      <input type="hidden" name="trusteeshipCommodityId" value="${param.id}">
		      <input type="hidden" name="listingChargeRate" value="${param.listingChargeRate}">
		      <table>
		         <tr align="center" ><td colspan="4" style="padding-bottom: 20px;">托  管  申  请</td></tr>
		        <tr>
		           <td>商品编码:</td>
		           <td><input type="text" name="commodityId" value="${param.commodityId}" readonly="readonly"></td>
		           <td>发行价格:</td>
		           <td><input type="text" name="price" value="${param.price}" readonly="readonly"></td>   
		        </tr>
		        <tr>
		           <td> 发行数量:</td>
		           <td><input type="text" name="counts" value="${param.counts}" readonly="readonly"/></td>
		           <td> 托管数量:</td>
		           <td><input type="text" name="applyAmount" length="10"  maxlength="14"
		               onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                       onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                       <font style="color:red">*</font>
                   </td>   
		        </tr>
		        <tr >
		           <td colspan="4" align="center" style="padding-top:30px;" > 
		              <a href="#" class="easyui-linkbutton" iconCls="icon-save" id="view" onclick="save()">保存</a>
		           </td>
		        </tr>
		      </table>
		      
		 </form>  
         </div>
    </div>
  
</body>

</html>
