<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>发行会员结算表</title>
<script src="<%=request.getContextPath()%>/static/ipo/publisherQuery/commPubQuery.js" type="text/javascript"></script>
</head>
<body>
<div class="warning">
		<div class="title font_orange_14b">温馨提示 :  货款跟踪录入</div>
		<div class="content" style="color: red"> 添加应付发行商的货款信息。</div>
	</div>
	<form method="POST" action="" name="frm" id="frm">
        <table border="0" height="40%" width="60%" align="center">
			<tr>
				<td>
              <fieldset class="pickList" >
	                 <legend class="common"><b>录入货款跟踪信息</b></legend>
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
	        	<td align="left" width="60%">
	        	<select id="commodityid" name="commodityid" style="width:150px" >
						<option value="">请选择</option>
                         <c:forEach var="commodity" items="${commlist}">
                         <option value="${commodity.commodityid}">${commodity.commodityid}${commodity.commodityname}</option>
                          </c:forEach>
				</select><span class="required">*</span>
	        	</td>
	        </tr>  
	         <tr>
	        	<td style="font-size:15px" align="right" width="20%">应付货款：</td>
	        	<td align="left" width="60%">
	        	 <input style="width:150px;" id="payables" name="payables"
	        	  class="easyui-numberbox" data-options="required:true,missingMessage:'请填入正数',min:0,max:99999999999999,precision:2"/><span class="required">*</span>
	        	
	        	</td>
	        </tr> 
	        <tr>
	        	<td style="font-size:15px" align="right" width="20%">状态：</td>
	        	<td align="left" width="60%">
	        	<select id="status" name="status" style="width:150px">
	        	 <option value="">请选择</option>
			     <option value="1">未付款</option>
				 <option value="2">已付款</option>
	        	</select><span class="required">*</span>
	        	</td>
	        </tr>  
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
