<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<input type="hidden" id="sessionID" name="sessionID"
	value="3883941706676255488">

<script>
	function showKeyPress(evt) {
		evt = (evt) ? evt : window.event
		return checkSpecific(String.fromCharCode(evt.keyCode));
	}
	function checkSpecific(realkey) {
		var specialKey = "!<>#$()?%\&\^*\'\"\+\|";//特殊字符列表
		var flg = false;
		flg = (specialKey.indexOf(realkey) >= 0);
		if (flg) {
			return false;
		}
		return true;
	}
	document.onkeypress = showKeyPress;
</script>
<html>
<style type="text/css">
a:visited {
	text-decoration: underline;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>余额包销</title>
</head>

<script type="text/javascript">
	$(document).ready(function() {
		//隐藏掉商品信息
		$("#info").hide();
	});

	//执行查询列表
	function frm_commit() {
		//获取配置权限的 URL
		var commitUrl = document.getElementById('commit').action;
		//获取完整跳转URL
		var url = "http://124.207.182.187:16961/issue_mgr" + commitUrl;
		frm.action = url;
		if (commit_check()) {
			if (confirm("确定提交余额包销信息？")) {
				frm.submit();
			}
		}
	}
	//信息检查
	function commit_check() {
		var balanceUnderwriterId = $("#balanceUnderwriterId").val();
		var balanceQty = $("#balanceQty").val();
		var notAssignQty = $("notAssignQty").val();
		if (balanceUnderwriterId == "") {
			alert("请选择包销承销商");
			return false;
		}
		if (balanceQty == "") {
			alert("包销数量不能为空");
			return false;
		}
		if (balanceQty == 0) {
			alert("包销数量不能0");
			return false;
		}
		if (balanceQty > notAssignQty) {
			alert("包销数量不能大于未配售数量");
			return false
		}
		return true;
	}
	//显示商品信息
	function viewCommodityInfo(value) {
		if (value == "") {
			$("#info").hide();
			$("#registerDate").attr("value", "");
			$("#reissueDate").attr("value", "");
			$("#listingDate").attr("value", "");
			$("#price").attr("value", "");
			$("#assignQty").attr("value", "");
			$("#notAssignQty").attr("value", "");
			$("#balanceUnderwriterId").empty();
		} else {
			var commodityId = value.split(",")[0];
			$("#real_commodityId").attr("value", commodityId);
			var registerDate = value.split(",")[1];
			$.getJSON("../../ajaxcheck/reissue/queryReissueCommodity.action?t="
					+ Math.random(), {
				"commodityId" : commodityId,
				"registerDate" : registerDate
			}, function(data) {
				var infos = data.toString().split(",");
				$("#registerDate").attr("value", infos[0]);
				$("#reissueDate").attr("value", infos[1]);
				$("#listingDate").attr("value", infos[2]);
				$("#price").attr("value", infos[3]);
				$("#assignQty").attr("value", infos[4]);
				$("#notAssignQty").attr("value", infos[5]);
				$("#balanceUnderwriterId").empty();
				$("#balanceUnderwriterId").append(
						"<option value=''>请选择</option>");
				for (var i = 6; i < infos.length; i++) {
					if (infos[i] != null && infos[i] != "") {
						$("#balanceUnderwriterId").append(
								"<option value='"+infos[i]+"'>" + infos[i]
										+ "</option>");
					}
				}

			});
			$("#info").show();
		}
	}
</script>
</head>
<body>
	<table border="0" height="100" width="100%" align="center">
		<tr>
			<td>
				<fieldset class="pickList">
					<legend class="common">
						<b class="required">商品选择 (--括号内为该商品的登记日期--)</b>
					</legend>

					<table align="center">
						<tr>
							<td align="right">&nbsp; &nbsp; &nbsp; &nbsp; <span
								class="required">*</span> 商品代码：
							</td>
							<td><select id="commodityId" name="commodityId_show"
								onchange="viewCommodityInfo(this.value);" style="width: 180px;">
									<option value="">--------请选择--------</option>

							</select></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</table>

	<div id="info">
		<table border="0" height="100" width="100%" align="center">
			<tr>
				<td>
					<form id="frm" method="post" action="">
						<fieldset class="pickList">
							<legend class="common">
								<b class="required">商品详情 </b>
							</legend>
							<input type="hidden" name="commodityId" id="real_commodityId"
								value="" />
							<table align="center">
								<tr>
									<td align="right"><span class="required">*</span> 登记日期：</td>
									<td><input type="text" id="registerDate"
										style="width: 130px" name="registerDate" value=""
										readonly="readonly" /></td>
								</tr>
								<tr>
									<td align="right"><span class="required">*</span> 增发日期：</td>
									<td><input type="text" id="reissueDate"
										style="width: 130px" name="reissueDate" value=""
										readonly="readonly" /></td>
								</tr>
								<tr>
									<td align="right"><span class="required">*</span> 上市日期：</td>
									<td><input type="text" id="listingDate"
										style="width: 130px" name="listingDate" value=""
										readonly="readonly" /></td>
								</tr>
								<tr>
									<td align="right"><span class="required">*</span> 价格：</td>
									<td><input type="text" id="price" name="price" value=""
										style="width: 130px" readonly="readonly" /></td>
								</tr>
								<tr>
									<td align="right"><span class="required">*</span> 已配售数量：</td>
									<td><input type="text" id="assignQty" name="assignQty"
										value="" style="width: 130px" readonly="readonly" /></td>

								</tr>
								<tr>
									<td align="right"><span class="required">*</span>未配售数量：</td>
									<td><input type="text" id="notAssignQty"
										name="notAssignQty" value="" style="width: 130px"
										readonly="readonly" /></td>
								</tr>
								<tr>
									<td align="right"><span class="required">*</span>包销承销商代码：
									</td>
									<td><select id="balanceUnderwriterId"
										name="balanceUnderwriterId" style="width: 130px">
									</select></td>
								</tr>
								<tr>
									<td align="right"><span class="required">*</span>包销数量：</td>
									<td><input type="text" id="balanceQty" name="balanceQty"
										style="width: 130px;"></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr align="center">
									<td colspan="2" align="center">
										<button class="btn_sec" id="commit"
											action="/issue/reissue/balanceUnderWriting.action"
											onclick="frm_commit();">提交</button>
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>