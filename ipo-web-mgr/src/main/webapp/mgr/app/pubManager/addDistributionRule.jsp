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
<script type="text/javascript">

</script>
</head>

<body>
	<div style="width:80%;margin:0 auto;margin-top:180px">
		<fieldset style="padding:15px">
		<legend>分配方式设置</legend>
		<fieldset class="info">
			<legend>商品信息</legend>
			<div style="width:300px;margin:0 auto;">
				<p id="commId"></p>
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
						
						<input class="inputtext" id="positionRatio" type="text" onblur="validate(this)">%
					</td>
					
				</tr>
				<tr>
				
					<td align="right">申购量优先中签比率：<span>*</span></td>
					<td align="left">
						
						<input class="inputtext" id="countsRatio" type="text" onblur="validate(this)">%
					</td>
				</tr>
				<tr>
					<td align="right">单号最大中签量：<span>*</span></td>
					<td align="left">
						
						<input class="inputtext" id="maxNum" type="text" onblur="validate1(this)">
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
	var operationType="<%=request.getParameter("operationType")%>";
	var holdRatio;
	var purchaseRatio;
	var maxqty;
	var zeroToHundred;
	var pintegral;
	var zeroToHundred = /^(\d{1,2}(\.{1}\d+)?|100)$/;//正则表达式，0~100的数；
	var pintegral =  /^[0-9]*[1-9][0-9]*$/;//正则表达式，正整数！
	$(document).ready(function(){
		getCommonityInfo();
		if(operationType=="update"){
			getRuleInfo();
		}
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
	function getRuleInfo(){
		$.ajax({
			type:"GET",
			url:"<%=request.getContextPath()%>/DistributionRuleController/getRuleInfoByCommId?t="+Math.random(),
			data:{commodityId:commId},
			dataType:"json",
			success:function(data){
				$("#positionRatio").val(data.holdRatio);
				$("#countsRatio").val(data.purchaseRatio);
				$("#maxNum").val(data.maxqty);
			}
		})
	}
	
	$("#ok").click(function(){
		holdRatio=$("#positionRatio").val();
		purchaseRatio=$("#countsRatio").val();
		maxqty=$("#maxNum").val();
		if(holdRatio>100){
			alert("持仓优先率不能大于100");
			return;
		}
		if(purchaseRatio>100){
			alert("申购量优先率不能大于100");
			return;
		}
		if((parseFloat(purchaseRatio)+parseFloat(holdRatio))!=100){
			alert("持仓优先率+申购量优先率需为100%");
			return;
		}
		if(operationType=="insert"){
			idExistence();
		}else if(operationType=="update"){
			updateRuleInfo();
		}
	});
	
	function insertRuleInfo(){
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/DistributionRuleController/insertRuleInfo",
			data:{
				commodityid:commId,
				holdRatio:holdRatio,
				purchaseRatio:purchaseRatio,
				maxqty:maxqty
				},
			success:function(data){
				switch(data){
				case "success":
					alert("添加成功");
					break;
				case "fail":
					alert("添加失败");
					break;
				case "error":
					alert("系统异常");
					break;
				}
			}
		});
	}
	
	function updateRuleInfo(){
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/DistributionRuleController/updateInfoByCommId",
			data:{
				commodityid:commId,
				holdRatio:holdRatio,
				purchaseRatio:purchaseRatio,
				maxqty:maxqty
				},
			success:function(data){
				switch(data){
				case "success":
					alert("修改成功");
					break;
				case "fail":
					alert("修改失败");
					break;
				case "error":
					alert("系统异常");
					break;
				}
			}
		});
	}
	
	function idExistence(){
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/DistributionRuleController/isExistence",
			data:{
				commodityId:commId,
				
				},
			success:function(data){
				if(data){
					insertRuleInfo();
				}else{
					alert("该商品的配售信息已经存在！");
				}
				
				}
		});
	}
	function go(){
		if(operationType=="insert"){
			window.self.location="issuedAdmin.jsp";
		}
		if(operationType=="update"){
			window.self.location="distributionRule.jsp";
		}
	}
	
	
	//正则验证0~100
	function validate(obj){
		if($(obj).val()=="")
			return;
		 if(!zeroToHundred.test($(obj).val())){
			 alert("请输入小于100的非负数！");
			 $(obj).val("");
		 }
	}
	//正则验证0~100正整数
	function validate1(obj){
		if($(obj).val()=="")
			return;
		 if(!pintegral.test($(obj).val())){
			 alert("请输入小于100的非负数！");
			 $(obj).val("");
		 }
	}
</script>
</html>
		