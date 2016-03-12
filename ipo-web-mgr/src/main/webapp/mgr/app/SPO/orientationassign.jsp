<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 获取返回信息 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定向配售</title>
<style type="text/css">
b {
	color: red;
}

td {
	font-size: 15px;
	height: 30px;
}

legend {
	color: red;
}

.codeselect {
	width: 200px;
}

.listinput {
	line-height: 12px;
	width: 150px;
}

.listselect {
	width: 150px;
}

#postbtn {
	width: 90px;
	border: 1px solid #DDAF73;
	background: #FFEF9D;
	margin-top: 18px;
}

.errorMsg{
	position: absolute;
	margin-left: 5px;
}
</style>
</head>
<body>
	<fieldset>
		<legend>商品选择（括号内为该商品的登记日期）</legend>
		<table border="0" width="400" cellspacing="0" cellpadding="0"
			align="center">
			<tbody>
				<tr>
					<td align="center"><b>*</b>商品代码： <select class="codeselect">
					</select></td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	<fieldset>
		<legend>商品详情</legend>
		<table border="0" width="350" cellspacing="0" cellpadding="0"
			align="center">
			<tbody>
				<tr>
					<td align="right"><b>*</b>登记日期：</td>
					<td align="left"><input type="text" id="registerDate"
						class="listinput" readonly="readonly" /></td>
				</tr>
				<tr>
					<td align="right"><b>*</b>上市日期：</td>
					<td align="left"><input type="text" id="ipoDate"
						class="listinput" readonly="readonly" /></td>
				</tr>
				<tr>
					<td align="right"><b>*</b>价格：</td>
					<td align="left"><input type="text" id="spoPrice"
						class="listinput" readonly="readonly" /></td>
				</tr>
				<tr>
					<td align="right"><b>*</b>已配售数量：</td>
					<td align="left"><input type="text" id="successRationCounts"
						class="listinput" readonly="readonly" /></td>
				</tr>
				<tr>
					<td align="right"><b>*</b>未配售数量：</td>
					<td align="left"><input type="text" id="notRationCounts"
						class="listinput" readonly="readonly" /></td>
					<input type="hidden" id = "spoid" name = "spoid"/>
				</tr>
				<tr>
					<td align="right"><b>*</b>客户类型：</td>
					<td align="left">
						<select class="listselect" id="customer_type" onchange="customerFocus()">
							<option value=""></option>
							<option value="0">普通会员</option>
							<option value="1">承销会员</option>
						</select>
						<span style="display:none;color: red;" id="errorMsg0" class="errorMsg"/>
					</td>
				</tr>
				<tr>
					<td align="right"><b>*</b>客户代码：</td>
					<td align="left">
						<input type="text" id = "firmid" class="listinput" onblur="firmidFocus();" onpaste="return false" ondragenter="return false" oncontextmenu="return false;" style="ime-mode:disabled" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"/>
						<span style="display:none;color: red;" id="errorMsg1" class="errorMsg"/>
					</td>
				</tr>
				<tr>
					<td align="right"><b>*</b>配售数量：</td>
					<td align="left">
						<input type="text" id = "count" class="listinput" onkeypress="number()" onkeyup="filterInput()" onpaste="return false" onblur="countFocus();" style="ime-mode: disabled" />
						<span style="display:none;color: red;" id="errorMsg2" class="errorMsg"/>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input id="postbtn"
						type="button" value="提交" /></td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	<script type="text/javascript">
		$(function() {
			loadData();
		});

		var commodities;

		function initial() {
			var spolist = $('.codeselect');
			for (var i = 0; i < commodities.length; i++) {
				spolist.append('<option value =' + i + ' logicvalue= '+commodities[i].commodityId+'>'+ commodities[i].commodityId + '(---'+ commodities[i].ipoDate.split(" ", 1) + '---)' + '</option>');
			}
			$('#registerDate').val(commodities[0].registerDate.split(" ", 1));
			$('#ipoDate').val(commodities[0].ipoDate.split(" ", 1));
			$('#spoPrice').val(commodities[0].spoPrice);
			$('#successRationCounts').val(commodities[0].successRationCounts);
			$('#notRationCounts').val(commodities[0].notRationCounts);
			$('#spoid').val(commodities[0].spoId);
		}

		function loadData() {
			$.ajax({
				type : "GET",
				cache : false,
				async : false,
				url : '<%=request.getContextPath()%>/SPOController/directional',
				success : function(response) {
					//在这里赋值
					commodities = eval (response);
				},
				error : function(response) {
					alert("数据加载错误，请稍后再试！");
				}
			});
			initial();
		}

		function getCost(){
			var spoid = $('#spoid').val();
			var firmid = $('#firmid').val();
			var counts = $('#count').val();
			$.ajax({
				type : "GET",
				url : "<%=request.getContextPath()%>/SPOController/amountandfee",
				data : {
				//数据要传的在这里
				"spoid":spoid,
				"firmid":firmid,
				"counts":counts
				},
				success : function(response) {
					var json = eval('(' + response + ')');
					var capital = json.capital;
					var fee = json.fee;
					if(confirm("货款为:"+capital+"元，手续费为:"+fee+"元。你确定提交吗?")){
						ajaxpost();
					}
				},
				error : function(response) {
					alert("提交失败，请重试或联系管理员");
				}
			});	
		}
		
		function ajaxpost() {
			var spoid = $('#spoid').val();
			var type = $(".listselect").find("option:selected").val();
			var firmid = $('#firmid').val();
			var counts = $('#count').val();
			var notRationCounts = $('#notRationCounts').val();
			if(counts < notRationCounts ){
				$.ajax({
					type : "POST",
					url : "<%=request.getContextPath()%>/SPOController/adddir",
					data : {
					//数据要传的在这里
					"spoid":spoid,
					"type":type,
					"firmid":firmid,
					"counts":counts
					},
					success : function(response) {
						if (response == "success") {
							alert("添加成功");
							loadData();
						}
						if (response == "1001") {
							alert("客户代码没有权限");
						}
					},
					error : function(response) {
						alert("提交失败，请重试或联系管理员");
					}
				});
			} 
		}

		$('.codeselect').change(function() {
							var logic = $(".codeselect").find("option:selected").attr('value');
							$('#registerDate').val(commodities[logic].registerDate.split(" ",1));
							$('#ipoDate').val(commodities[logic].ipoDate.split(" ", 1));
							$('#spoPrice').val(commodities[logic].spoPrice);
							$('#successRationCounts').val(commodities[logic].successRationCounts);
							$('#notRationCounts').val(commodities[logic].notRationCounts);
							$('#spoid').val(commodities[logic].spoId);
							$('#customer_type').val("");
							$('#firmid').val("");
							$('#count').val("");
							$("#errorMsg0").hide();
							$("#errorMsg1").hide();
							$("#errorMsg2").hide();
						});

		$('#postbtn').click(function() {
			//验证写在这里
			var firmid = $("#firmid").val();
			var count = $("#count").val();
			var customer = $("#customer_type").val();
			if(customer == ''){
				$("#errorMsg0").html("请选择");
				 $("#errorMsg0").show();
			}else if(firmid == '' || $.trim(firmid) == ''){
				$("#errorMsg1").html("不能为空");
				$("#errorMsg1").show();
			}else if($.trim(count) == '' || count == ""){
				$("#errorMsg2").html("不能为空");
				$("#errorMsg2").show();
			}else{
				getCost();
			}
		});
		
		function customerFocus(){
			var customer = $("#customer_type").val();
			if(customer == ''){
				$("#errorMsg0").html("请选择");
				 $("#errorMsg0").show();
			}else{
				$("#errorMsg0").hide();
			}
		}
		
		function firmidFocus(){
			var firmid = $("#firmid").val();
			if(firmid == '' || $.trim(firmid) == ''){
				$("#errorMsg1").html("不能为空");
				$("#errorMsg1").show();
			}else{
				$("#errorMsg1").hide();
			}
		}
		
		function countFocus(){
			var count = $("#count").val();
			var notRationCounts = $('#notRationCounts').val();
			if($.trim(count) == '' || count == ""){
				$("#errorMsg2").html("不能为空");
				 $("#errorMsg2").show();
			}else if(count > notRationCounts){
				$("#errorMsg2").html("配售量应小于未配售量");
				 $("#errorMsg2").show();
			}else{
				$("#errorMsg2").hide();
			}
		}
		
		function number(){
			var char = String.fromCharCode(event.keyCode)
			var re = /[0-9]/g
			event.returnValue = char.match(re) != null ? true : false
		}
		

		function filterInput(){
			if (event.type.indexOf("key") != -1){
				var re = /37|38|39|40/g
				if (event.keyCode.toString().match(re)) return false
			}
			event.srcElement.value = event.srcElement.value.replace(/[^0-9]/g, "")
		}
	</script>
</body>
</body>
</html>