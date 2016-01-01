<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
	<head>
		<title>入库单添加 </title>
<style type="text/css">
		td{font-size:12px;}
		tr{margin-top:10px}
		input{background-color:#ccc}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ipo/delivery/addStorage.js" >        
</script>
</head>
<body  leftmargin="14" topmargin="0">
<div class="warning">
		<div class="title font_orange_14b">温馨提示 : 入库单添加 </div>
		<div class="content" style="color: red">
		* 入库件数=仓单数量/交割与交易单位换算。仓单数量=商品数量/交易单位。<br/>
        * 系统在此过滤了没有交收属性的商品   </div>
	</div>
	<table border="0"  width="90%"  >
		<tr>
			<td valign="top">
				<form id="frm" name="frm" method="POST" >
				<fieldset>
				<legend class="common"><b>添加入库单</b></legend>
				<span id="baseinfo9">
				<table width="850" border="0" align="center"  class="common" cellpadding="0" cellspacing="2">
					<!-- 基本信息 -->
        				<tr class="common">
							<td colspan="4">
					      		<fieldset>
					          	<legend>基本信息
					         	</legend>
								<span id="baseinfo">
								<table cellSpacing="0" cellPadding="0" width="800" border="0" align="left" class="common">
        							<tr>
										<td align="right" width="110">商品代码：</td>     
            							<td width="110"> 
            							<input  type="text" id="commodityid" name="commodityid" />
										</td>
										<td align="right" width="110"></td>
	      								<td width="110">
		          						</td>
							        </tr>  
							        <tr>
        			 					<td align="right" width="110">商品名称：</td>
	      								<td width="110">
	      								    <input id="commodityname" type="text" name="commodityname" readonly="readonly"/>
		          						</td>
										<td align="right" width="110">品种代码：</td>     
            							<td width="110"> 
            								 <input id="breedid" type="text" name="breedid"  readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="110">发行会员代码：</td>
	      								<td width="110">
	      								    <input id="pubmemberid" type="text" name="pubmemberid" readonly="readonly"/>
		          						</td>
										<td align="right" width="110">发行会员名称：</td>     
            							<td width="110"> 
            								 <input id="pubmembername" type="text" name="pubmembername" readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="110">上市日期：</td>
	      								<td width="110">
	      								    <input id="listingdate" type="text" name="listingdate"  readonly="readonly"/>
		          						</td>
		          						<td align="right" width="110">交货开始日期：</td>     
            							<td width="110">
            								 <input id="deliverystartday" type="text" name="deliverystartday" readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="110">入库件数：</td>
	      								<td width="110">
	      								    <input id="storagenum" type="text" name="storagenum" onfocus="checkCommodity()" onblur="getStorageCounts()"/>
	      								    <input id="deliunittocontract" type="hidden">
	      								    <span class="required">*</span>
		          						</td>
		          						<td align="right" width="110">入库数量：</td>     
            							<td width="110">
            								 <input id="storagecounts" type="text" name="storagecounts" readonly="readonly"/>
										</td>
							        </tr> 
							         <tr>
        			 					<td align="right" width="110">起始标码编号：</td>
	      								<td width="110">
	      								    <input id="startnum" type="text" name="startnum"/>
		          						</td>
		          						<td align="right" width="110">结束标码编号：</td>     
            							<td width="110">
            								 <input id="endnum" type="text" name="endnum"/>
										</td>
							        </tr> 
								</table >
								</span>
						    	</fieldset>
							</td>
						</tr>

						<tr>
							<td colspan="4" align="center">
								<div class="div_gn">
								    	<input type="button" value="添加" onclick="saveStorage()" class="anniu_btn"/>
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
