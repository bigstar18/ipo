<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
	<head>
		<title>交收属性设置</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/static/ipo/delivery/propsManage.js"> </script>
		<style type="text/css">
		td{font-size:12px;}
		tr{margin-top:10px}
		input{background-color:#ccc}
		</style>
</head>
<body  leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : 交收属性设置 </div>
		<div class="content" style="color: red"> </div>
	</div>
	<table border="0"  width="90%"  >
		<tr>
			<td valign="top">
				<form id="frm" name="frm" method="POST" >
				<fieldset>
				<legend class="common"><b>基本信息</b></legend>
				<span id="baseinfo9">
				<table width="850" border="0" align="center"  class="common" cellpadding="0" cellspacing="2">
					<!-- 基本信息 -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
								<span id="baseinfo">
								<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
        							<tr>
        							    <td align="right" width="110">商品代码：</td>     
            							<td width="110"> 
            								 <input id="commodityId" type="text" name="commodityId" value="${commodityId }" readonly="readonly"/>
										</td>
        			 					<td align="right" width="110">商品名称：</td>
	      								<td width="110">
	      								    <input id="commodityName" type="text" name="commodityName" value="${commodityName }" readonly="readonly"/>
		          						</td>
										<td align="right" width="110"> </td>     
            							<td width="110"> 
										</td>
							        </tr> 
							        <input type="hidden" id="flag" value="${flag }"/> 
							        <c:forEach var="props" items="${proplist }" varStatus="status">
							         <tr>
        			 					<td align="right" width="110"><span class="required">*</span><c:out value="${props.propertyname }"/>:</td>
	      								<td width="110">
	      							<%-- 	<input type="hidden"  name="propertyid" value="${props.propertyid }"   /> --%>
	      								<select id="sortno${status.count }" name="propertys"   style="width:110">
								            		<option value="">请选择<c:out value="${props.propertyname }"/></option>
                                                    <c:forEach var="propvalue" items="${propvaluelist}">
                                                      <c:if test="${propvalue.propertyid eq props.propertyid }">
                                                      <option value="${propvalue.propertyid}:${propvalue.sortno}">${propvalue.propertyvalue}</option>
                                                      </c:if>
                                                    </c:forEach>
								        </select>
		          						</td>
										<td align="right" width="110"></td>     
            							<td width="110"> 
            							<span style="color: blue;">请选择<c:out value="${props.propertyname }"/>信息！</span>	
            							</td>
										<td align="right" width="110"></td>     
            							<td width="110"> 
										</td>
							        </tr> 
			                        </c:forEach> 
								</table >
								</span>
						    	</fieldset>
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								    	<input type="button" value="提交" onclick="updateDeliveryProps()" class="anniu_btn"/>
									&nbsp;&nbsp;
									<input type="button" value="返回" onclick="returntoList()" class="anniu_btn"/>
								</div>
							</td>
						</tr>
					</table>
				</span>
			</fieldset>
			</form>
		</td>
	</tr>
</table>
</body>
</html>
