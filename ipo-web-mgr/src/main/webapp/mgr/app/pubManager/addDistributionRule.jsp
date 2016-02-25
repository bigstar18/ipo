<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
   
<html>
<head>
<title>添加分配方式</title>
<style type="text/css">
	fieldset{border:1px solid #ccc;font-size:15px;font-family:"微软雅黑";}
	.info{width:95%;margin:0 auto;height:180px;margin-bottom:15px;margin-top:20px}
	table{width:100%}
	tr{height:45px}
	.inputtext{width:180px}
	.inputbutton{width:80px;height:25px;}
	p{font-size:18px;padding:6px;}
	span{color:#f00;}
</style>
<script type="text/javascript"></script>
</head>

<body>
	<div style="width:80%;margin:0 auto;margin-top:180px">
		<fieldset style="padding:15px">
		<legend>分配方式设置</legend>
		<fieldset class="info">
			<legend>商品信息</legend>
			<div style="width:300px;margin:0 auto;">
				<p id="commId">商品代码：<%=request.getParameter("commodityid")%></p>
				<p id="commName"></p>
				<p id="counts"></p>
				<p id="ccounts"></p>
			</div>
		</fieldset>
		<fieldset class="info">
			<legend>分配信息</legend>
			<table>
				<tr>
					
					<td align="right">持仓优先中签比率：<span>*</span></td>
					<td align="left">
						
						<input class="inputtext" id="positionRatio" type="text">%
					</td>
					
				</tr>
				<tr>
				
					<td align="right">申购量优先中签比率：<span>*</span></td>
					<td align="left">
						
						<input class="inputtext" id="countsRatio" type="text">%
					</td>
				</tr>
				<tr>
					<td align="right">单号最大中签量：<span>*</span></td>
					<td align="left">
						
						<input class="inputtext" id="maxNum" type="text">
					</td>
				</tr>
			</table>
		</fieldset>
		<div style="width:180px;margin:0 auto">		
			<input id="ok" class="inputbutton" type="button" value="确定">
			<input id="back" class="inputbutton" type="button" onclick="go()" value="返回">
		</div>

		</fieldset>
	</div>
</body>
<script type="text/javascript">
	var commId="<%=request.getParameter("commodityid")%>";
	$(document).ready(function(){
		getCommonityInfo();
	});
	function getCommonityInfo(){
		$.ajax({
			type:"GET",
			url:"<%=request.getContextPath()%>/DistributionRuleController/getCommonityById?t="+Math.random(),
			data:{
				commodity:commId
				},
			dataType:"json",
			success:function(data){
				$("#commId").text("商品代码："+data.commodityid);
				$("#commName").text("商品名称："+data.commodityname);
				$("#counts").text("网上发行量："+data.counts);
				$("#ccounts").text("申购量："+data.ccounts);
			}
					
			
		});
	}
	function go(){
		window.self.location="issuedAdmin.jsp";
	}
</script>
</html>
		