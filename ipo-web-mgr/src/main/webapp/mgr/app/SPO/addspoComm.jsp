<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加增发商品</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<link rel="stylesheet" href="../../skinstyle/default/css/common.css" type="text/css" />
<style type="text/css">
	.content span{display:block}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(".radio").hide();
	$(".all").hide();
	
});
function rationTypeChange(type){
	if(type.value=="比例配售"){
		$(".radio").show();
		$(".all").show();
	}else if(type.value=="定向配售"){
		$(".radio").hide();
		$(".all").show();
	}else{
		$(".radio").hide();
		$(".all").hide();
	}
}

function test(){
	parent.$('#dd').window('close');
	parent.$('depositInfo').datagrid("reload");
}

function addSPOInfo(){
	var commonityId = $("#commId").val();
	var registerDate = $("#registerDate").val();
	var spoDate = $("#spoDate").val();
	var ipoDate = $("#ipoDate").val();
	var rationType = $("#rationType").val();
	var rationCounts = $("#rationCounts").val();
	var spoPrice = $("#spoPrice").val();
	var positionsPrice = $("#positionsPrice").val();
	var minRationCounts = $("#minRationCounts").val();
	var minRationProportion = $("#minRationProportion").val();
	
	
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/SPOController/insertSPOInfo",
		data:{commonityId:commonityId,
			registerDate:registerDate,
			spoDate:spoDate,
			ipoDate:ipoDate,
			rationType:rationType,
			rationCounts:rationCounts,
			spoPrice:spoPrice,
			positionsPrice:positionsPrice,
			minRationCounts:minRationCounts,
			minRationProportion:minRationProportion
		},
		success:function(data){
        	if(data=="success")
        	  $('#depositInfo').datagrid('reload');
        	else if(data=="error")
        		alert("操作失败，请稍后再试");
         } 
	});
}

</script>
</head>
<body>
	<div class="warning">
		<div class="content" style="height:100%">
			<span>温馨提示 :（比例配售下）</span>
			<span> 1、最小配售数量指的是：增发的此商品数量如果不超过这个最小配售数量的话，就自动增发失败</span>
			<span>2、最小配售比例指的是：增发给承销会员的最小比例不能小于这个设置</span>
			<span>3、商品代码选项中括号内为该商品代码，括号外为商品名称</span>
		</div>
	</div>

	<form>
		<div class="div_cxtj">
			<div class="div_cxtjL"></div>
			<div class="div_cxtjC">
				添加增发商品
			</div>
			<div class="div_cxtjR"></div>
		</div>
		<table width="95%" height="100" align="center" class="table2_style">
			<tr align="center">
				<td>
				<span>商品代码：</span>
				<span>
					<select id="commId" style="width:150px">
						<option>请选择</option>
					</select>
				</span>
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>登记日期：</span>
				<span>
					<input id="registerDate" class="easyui-datebox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="radio" align="center">
				<td>
				<span>增发日期：</span>
				<span>
					<input id="spoDate" class="easyui-datebox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>上市日期：</span>
				<span>
					<input id="ipoDate" class="easyui-datebox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr align="center">
				<td>
				<span>配售类型：</span>
				<span>
					<select id="rationType" name="type" style="width:150px" onchange="rationTypeChange(this)">
						<option>请选择</option>
						<option>比例配售</option>
						<option>定向配售</option>
					</select>
				</span>
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>配售数量：</span>
				<span>
					<input id="rationCounts" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>	
			<tr class="all" align="center">
				<td>
				<span>增发价格：</span>
				<span>
					<input id="spoPrice" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>持仓价格：</span>
				<span>
					<input id="positionsPrice" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="radio" align="center">
				<td>
				<span>最小配售数量：</span>
				<span style="margin-right:25px">
					<input id="minRationCounts" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="radio" align="center">
				<td>
				<span >最小配售比例：</span>
				<span style="margin-right:18px">
					<input id="minRationProportion" class="easyui-textbox" style="width:150px">%
				</span>	
				</td>
			</tr>
		</table>
		<table width="100%" style="margin-top:15px">
			<tr >
				<td align="center">
					<button class="btn_sec" id="add" onclick="addSPOInfo()">添加</button>
					<button class="btn_sec" onclick="test()">关闭</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>