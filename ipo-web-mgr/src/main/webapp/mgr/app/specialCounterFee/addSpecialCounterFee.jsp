<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>特殊手续费添加</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<link rel="stylesheet" href="../../skinstyle/default/css/common.css" type="text/css" />
<script src="<%=request.getContextPath()%>/mgr/public/js/json2.js" type="text/javascript"></script>
</head>
<body>
	<div class="warning">
		<div class="content" style="height:80%;font-size:12px">
			<span>温馨提示 :</span>
			<span> 特殊手续费添加</span>
		</div>
	</div>
	<form id="frm" method="POST">
		<div class="div_cxtj">
			<div class="div_cxtjL"></div>
			<div id="title" class="div_cxtjC">
				特殊手续费添加
			</div>
			<div class="div_cxtjR"></div>
		</div>
		<table width="95%" height="100" align="center" class="table2_style">
			<tr>
				<td align='right' style="width:45%">
				交易商代码：
				</td>
				<td align='left'>
				<input id="firmId" type="text" onblur="isFirm()" style="width:180px;height:18px">
				</td>
			</tr>
			<tr>
				<td align='right' style="width:45%">
				商品代码：
				</td>
				<td align='left'>
				<select id="commodityId" style="width:182px;height:21px">
					<option value="">请选择</option>
				</select>
				<input id="commodityId2" readonly="readonly" style="width:180px;height:18px;display:none;">
				</td>
			</tr>
			<tr>
				<td align='right' style="width:45%">
				手续费算法：
				</td>
				<td align='left'>
				<select id="tradealgr" style="width:182px;height:21px">
					<option value="">请选择</option>
					<option value="1">百分比</option>
					<option value="2">绝对值</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align='right' style="width:45%">
				手续费种类：
				</td>
				<td align='left'>
				<select id="counterFeeType" style="width:182px;height:21px">
					<option value="">请选择</option>
					<option value="1">交易买手续费</option>
					<option value="2">交易卖手续费</option>
					<option value="3">发行手续卖</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align='right' style="width:45%">
				手续费：
				</td>
				<td align='left'>
				<input id="counterfee" type="text" onblur="isNum(this)" style="width:180px;height:18px">
				</td>
			</tr>
		</table>
		<br>
		<table width="100%" style="margin-top:15px">
			<tr >
				<td align="center">
					<input type="button" class="btn_sec" id="add" onclick="addOrUpdate()" value="添加">
				    <input type="button" class="btn_sec" id="close" onclick="doClose()" value="关闭">
				</td>
			</tr>
		</table>
	</form>
</body>

<script type="text/javascript">
	var reg =  /.*\((.*)\)/;//正则获取括号中的内容
	var num = /^\d+(\.{0,1}\d+){0,1}$/ ;//正则非负数
	var zeroToHundred = /^(\d{1,2}(\.{1}\d+)?|100)$/;//正则表达式，0~100的数；
	function isNum(obj){
		if(!num.test(String($(obj).val()))){
			alert("请输入非负数！");
			$(obj).val("");
			return;
		}
		if($("#tradealgr").val()==1&&!zeroToHundred.test(String($(obj).val()))){
			alert("手续费算法为百分比时不得收费值不得大于100");
			$(obj).val("");
			return;
		}
		
	}
	
	$(document).ready(function(){
		var id = parent.$("#id").val();
		if(id!=''){
			$("#commodityId").hide();
			$("#commodityId2").show();
			getInfo(id);
		}else{
			getCommInfo();
		}
		
	});
	
	function isFirm(){
		var firmId = $("#firmId").val();
		if(firmId==''){
			alert("请输入交易商代码");
			return;
		}
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/SpecialCounterFeeController/isFirm",
			data:{
				firmid:firmId
			},
			success:function(data){
				if(data==false){
					alert("交易商不存在");
					$("#firmId").val("");
					return;
				}
			}
			
		});
	}

	
	function addOrUpdate(){
		var id = parent.$("#id").val();
		var firmId = $("#firmId").val();
		var tradealgr = $("#tradealgr").val();
		var commonityId = $("#commodityId").val();
		var counterfeetype = $("#counterFeeType").val();
		var counterfee = $("#counterfee").val();
		var sell = $("#sell").val();
		var name = $("#add").val();
		if(firmId==""){
			alert("请输入交易商代码");
			return;
		}
		if(tradealgr==""){
			alert("请选择手续费算法");
			return;
		}
		if(counterfeetype==""){
			alert("请选择手续费种类");
			return;
		}
		if(counterfee==""){
			alert("手续费不可为空");
			return;
		}
		if(name=="修改"){
			doUpdateInfo();
		}else{
			if(commonityId==""){
				alert("请选择商品");
				return;
			}
			selectCountsById();
		}
		
		
	}
	function doUpdateInfo(){
		var id = parent.$("#id").val();
		var firmId = $("#firmId").val();
		var commonityId = $("#commodityId2").val();
		var tradealgr = $("#tradealgr").val();
		var counterfeetype = $("#counterFeeType").val();
		var counterfee = $("#counterfee").val();
		var sell = $("#sell").val();
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/SpecialCounterFeeController/updateInfoById",
			data:{
				id:id,
				firmid:firmId,
				commodityid:commonityId,
				tradealgr:tradealgr,
				counterfeetype:counterfeetype,
				counterfee:counterfee
			},
			success:function(data){
				if(data=="success"){
					alert("修改成功！");
					doClose();
					parent.getAllInfo();
				}else if(data=="fail"){
					alert("修改失败！");
				}else{
					alert("系统异常！");
				}
			}
			
		});
	}
	

	
	function doAddInfo(){
		var firmId = $("#firmId").val();
		var commonityId = $("#commodityId").val().match(reg)[1];
		var tradealgr = $("#tradealgr").val();
		var counterfeetype = $("#counterFeeType").val();
		var counterfee = $("#counterfee").val();
		var sell = $("#sell").val();
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/SpecialCounterFeeController/addSpecialCounterfeeInfo",
			data:{
				firmid:firmId,
				commodityid:commonityId,
				tradealgr:tradealgr,
				counterfeetype:counterfeetype,
				counterfee:counterfee
			},
			success:function(data){
				if(data=="success"){
					alert("添加成功！");
					doClose();
					parent.getAllInfo();
				}else if(data=="fail"){
					alert("添加失败！");
				}else{
					alert("系统异常！");
				}
			}
			
		});
		
	}

	function selectCountsById(){
		var firmId = $("#firmId").val();
		var counterfeetype = $("#counterFeeType").val();
		var commonityId = $("#commodityId").val().match(reg)[1];
		$.ajax({
			type:"GET",
			url:"<%=request.getContextPath()%>/SpecialCounterFeeController/selectCountsById?randnum="+Math.floor(Math.random()*1000000),
			data:{
				firmid:firmId,
				counterfeetype:counterfeetype,
				commodityid:commonityId
			},
			success:function(data){
				if(data){
					alert("该交易商这类特殊手续费已存在！");
				}else{
					doAddInfo();
				}
			}
			
		});
	}
	
	function doClose(){
		parent.$("#id").val("");
		parent.$("#dd").window("close");
	}
	function getCommInfo(){
		$.ajax({
			type:"GET",
			url:"<%=request.getContextPath()%>/SPOController/getIPOCommonity",
			success:function(data){
	        	if(data!="error"&&data!=""&&data!="null"){
	        		var temp = data.split("|");
	        		for(var ele in temp){
	        			if(temp[ele] !="")
	        				$("#commodityId").append("<option>"+temp[ele]+"</option>");
	        		}
	        	}else if(data=="null"){
	        		return;
	        	}
	        	else if(data=="error")
	        		alert("初始化，请稍后再试");
	         } 
		});
	}
	
	
	//获取特殊手续费修改的基本信息
	function getInfo(id){
		$.ajax({
			type:"GET",
			url:"<%=request.getContextPath()%>/SpecialCounterFeeController/selectInfoById?randnum="+Math.floor(Math.random()*1000000),
			data:{id:id},
			dataType: "json", 
			success:function(data){
				if(data!="error"&&data!=""){
					$("#firmId").val(data.firmid);
					$("#commodityId2").val(data.commodityid);
					$("#tradealgr ").get(0).selectedIndex=data.tradealgr;
					$("#counterFeeType").get(0).selectedIndex=data.counterfeetype;
					$("#counterfee").val(data.counterfee);
					$("#sell").val(data.sell);
					$("#add").val("修改");
				}
			}
			
		});
	}
</script>
</html>