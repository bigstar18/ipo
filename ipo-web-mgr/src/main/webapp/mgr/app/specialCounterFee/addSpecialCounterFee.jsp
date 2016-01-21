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
<script type="text/javascript">
</script>
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
				<select id="commodityId" style="width:184px;height:21px">
					<option value="">请选择</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align='right' style="width:45%">
				手续费算法：
				</td>
				<td align='left'>
				<select id="tradealgr" style="width:184px;height:21px">
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
				<select id="counterFeeType" style="width:184px;height:21px">
					<option value="">请选择</option>
					<option value="1">交易手续费</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align='right' style="width:45%">
				买：
				</td>
				<td align='left'>
				<input id="buy" type="text" style="width:180px;height:18px">
				</td>
			</tr>
			<tr>
				<td align='right' style="width:45%">
				卖：
				</td>
				<td align='left'>
				<input id="sell" type="text" style="width:180px;height:18px">
				</td>
			</tr>
		</table>
		<br>
		<table width="100%" style="margin-top:15px">
			<tr >
				<td align="center">
					<input type="button" class="btn_sec" id="add" onclick="doAddInfo()" value="添加">
				    <input type="button" class="btn_sec" id="close" onclick="doClose()" value="关闭">
				</td>
			</tr>
		</table>
	</form>
</body>

<script type="text/javascript">
	var reg =  /.*\((.*)\)/;//正则获取括号中的内容
	$(document).ready(function(){
		getIPOCommInfo();
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
				firmid:firmId,
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

	function doAddInfo(){
		var firmId = $("#firmId").val();
		var commonityId = $("#commodityId").val().match(reg)[1];
		var tradealgr = $("#tradealgr").val();
		var counterfeetype = $("#counterFeeType").val();
		var buy = $("#buy").val();
		var sell = $("#sell").val();
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/SpecialCounterFeeController/addSpecialCounterfeeInfo",
			data:{
				firmid:firmId,
				commodityid:commonityId,
				tradealgr:tradealgr,
				counterfeetype:counterfeetype,
				buy:buy,
				sell:sell
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

	function doClose(){
		parent.$("#dd").window("close");
	}
	function getIPOCommInfo(){
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
</script>
</html>