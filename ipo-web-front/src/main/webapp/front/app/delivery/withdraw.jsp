<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>
<%@page import="java.lang.String"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提货申请</title>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
<link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
<style type="text/css">
.hide {
	display: none;
}

td b {
	color: red;
}

legend b {
	color: blue
}

.mbodytop {
	padding: 5px; border-top: 1px solid #95B8E7; border-left: 1px solid #95B8E7; border-right: 1px solid #95B8E7; background: #EFF5FF;
}

.mbody {
	border: 1px solid #95B8E7; background: #F4F4F4;
}

input {
	border: 1px solid #95B8E7; border-radius: 5px; height: 20px; padding-left: 4px;
}

body {
	height: 600px;
}
</style>
<script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    function onlyNum() {
      if (!(event.keyCode == 46) && !(event.keyCode == 8) && !(event.keyCode == 37) && !(event.keyCode == 39))
        if (!((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)))
          event.returnValue = false;
    }
  </script>
</head>
<body>
	<div class="main">
		<div class="msg">
			您当前的位置：<span>提货申请</span>
		</div>
		<div class="warning">
			<div class="title font_orange_14b">温馨提示 :</div>
			<div class="content">在此页面上提交提货单，星号为必填项，请选择合适提货日期。</div>
		</div>
		<div class="mbodytop">
			<div class="panel-title panel-with-icon">提货信息</div>
		</div>
		<div class="mbody">
			<!-- <form id="withdraw" action="<%=request.getContextPath()%>/SettlementDeliveryController/deliveryApply" method="POST" onsubmit="return checkSubmit();"> -->
			<table border="0" width="300" cellspacing="0" cellpadding="0" align="center">
				<tbody>
					<tr>
						<td height="15" colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td height="3" colspan="2"></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;商品名称： </span></td>
						<td><select name="commodityName" style="width: 154px;" id="nametext">
						</select><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;商品代码： </span></td>
						<td><input id="vcode" type="text" value="" name="commodityId" style="width: 150px;" readonly="readonly"><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;交货仓库： </span></td>
						<td><select name="warehouseId" value="" style="width: 154px;" id="housetext">
						</select><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;持仓数量： </span></td>
						<td><input id="vcount" type="text" name="position" style="width: 150px;" readonly="readonly"><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;单位： </span></td>
						<td><input id="punit" type="text" name="positionUnit" style="width: 150px;" readonly="readonly"><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;交割数量： </span></td>
						<td><input id="dcount" class="btnreset" type="number" placeholder="您持仓数量内的正整数" name="deliveryQuatity" value="" onkeydown="onlyNum();" style="ime-mode: Disabled; width: 150px;"><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;提货日期： </span></td>
						<td><input id="ddate" type="text" name="deliveryDate" value="" class="easyui-datebox" style="width: 154px"><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;提货方式： </span></td>
						<td><select class="pickup" name="deliveryMethod" style="width: 154px;">
								<option value="1">自提</option>
								<option value="2">配送</option>
						</select><b>*</b></td>
					</tr>
					<tr class="customer">
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;身份证号： </span></td>
						<td><input type="text" class="btnreset" name="idcardNum" id="cardNum" value="" style="width: 150px;"><b>*</b></td>
					</tr>
					<tr class="dispatching hide">
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;电话： </span></td>
						<td><input type="text" class="btnreset" name="tel" id="telNum" value="" style="width: 150px;" onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"><b>*</b></td>
					</tr>
					<tr class="dispatching hide">
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;收货人： </span></td>
						<td><input type="text" class="btnreset" id="receiverName" name="receiver" value="" style="width: 150px;"><b>*</b></td>
					</tr>
					<tr class="dispatching hide">
						<td align="center" height="35" width="100"><span> &nbsp;&nbsp;地址： </span></td>
						<td><input type="text" class="btnreset" id="addressName" name="address" value="" style="width: 150px;"><b>*</b></td>
					</tr>
					<tr>
						<td align="center" height="35" width="100">
							<button id="postbtn">提交</button>
					</td>
						<td align="center" height="35" width="100">
							<button id="postrest">重置</button>
					</td>
					</tr>
				</tbody>
			</table>
			<!-- </form> -->
		</div>
	</div>
	<!-- <table border="0" width="700" align="center" class="tips">
    <tbody>
      <tr>
        <td align="center" style="color: red">提示：提货单注册后过了提货日期则不能提货，需注销提货单后重新注册</td>
      </tr>
    </tbody>
  </table> -->
	<script type="text/javascript">
	$ (function ()
			{
				loadData ();
				initCalendar ();
				
			});

			var commodities;
			function loadData ()
			{
				$.ajax (
				{
				    type : "GET",
				    cache : false,
				    async : false,
				    url : '<%=request.getContextPath()%>/SettlementDeliveryController/deliveryInfo',
				    success : function (response)
				    {
					    commodities = eval (response);
				    },
				    error : function (response)
				    {
					    alert ("出错咯");
				    }
				});
				
				// 页面初始化
				initial ();
				
			}
			// 加载藏品名称数据
			function initial ()
			{
				$('.validatebox-text').attr('readonly', 'readonly');
				var selname = $ ('#nametext');
				var selhouse = $ ('#housetext');
				selname.empty();
				selhouse.empty();
				
				for (var i = 0; i < commodities.length; i++)
				{
					selname.append ('<option logix =' + i + '>' + commodities[i].commodityname + '</option>');
				}
				$ ("#vcode").val (commodities[0].commodityid);
				$ ("#vcount").val (commodities[0].position);
				$ ("#punit").val (commodities[0].positionUnit);
				var warehouses = commodities[0].warehouse;
				var warehouseId = commodities[0].warehouseid;
				for (var i = 0; i < warehouses.length; i++)
				{
					selhouse.append ("<option value ='" + warehouseId[i] + "'>" + warehouses[i] + "</option>");
				}
		        $ ('#dcount').attr ('min', 1);
			}
			// 选择其他商品名称是变化
			$ ('#nametext').change (function ()
			{
				var logic = $ ("#nametext").find ("option:selected").attr ('logix');
				var selname = $ ('#nametext');
				var selhouse = $ ('#housetext');
				$ ("#vcode").val (commodities[logic].commodityid);
				$ ("#vcount").val (commodities[logic].position);
				$ ("#punit").val (commodities[logic].positionUnit);
				var warehouses = commodities[logic].warehouse;
				var warehouseId = commodities[logic].warehouseid;
				selhouse.empty ();
				for (var i = 0; i < warehouses.length; i++)
				{
					selhouse.append ("<option value ='" + warehouseId[i] + "'> " + warehouses[i] + "</option>");
				}
		        $ ('#dcount').attr ('min', 1);
			});

			function initCalendar ()
			{
				$ ('#ddate').datebox ('calendar').calendar (
				{
					validator : function (date)
					{
						var now = new Date ();
						var d1 = new Date (now.getFullYear (), now.getMonth (), now.getDate ());
						return d1 <= date;
					}
				});
			}

			$ ('.pickup').change (function ()
			{
				var value = $ (".pickup").find ("option:selected").val ();
				if (value == '1')
				{
					$ ('.customer').removeClass ('hide');
					$ ('.dispatching').addClass ('hide');
				}
				if (value == '2')
				{
					$ ('.customer').addClass ('hide');
					$ ('.dispatching').removeClass ('hide');
				}
				
			});

			// 提交
			$ ('#postbtn').click (function ()
			{
				var isIDcard = /^(\d{15}|\d{17}[x0-9])$/i;
				var value = $ (".pickup").find ("option:selected").val ();
				var vcount = Number ($ ('#vcount').val ());
				
				if (value == '1')
				{
					if ($ ('#dcount').val () == '' || Number ($ ('#dcount').val ()) > vcount || Number ($ ('#dcount').val ()) <= 0)
					{
						$ ('#dcount').css ('background', '#EEEE00');
						return false;
					}
					if ($ ('.textbox-text').val () == '')
					{
						$ ('.textbox-text').css ('background', '#EEEE00');
						return false;
					}
					if ($ ('#cardNum').val () == '')
					{
						$ ('#cardNum').css ('background', '#EEEE00');
						return false;
					}
					if (!isIDcard.test ($ ('#cardNum').val ()))
					{
						$ ('#cardNum').css ('background', '#EEEE00');
						$ ('#cardNum').attr ('placeholder', '请输入正确的身份证格式');
						$ ('#cardNum').val ('');
						return false;
					}
					else
					{
						ajaxpost ();
					}
				}
				if (value == '2')
				{
					if ($ ('#cardNum').val () != '')
					{
						$ ('#cardNum').val ('');
					}
					if ($ ('#dcount').val () == '' || Number ($ ('#dcount').val ()) > vcount || Number ($ ('#dcount').val ()) < 0)
					{
						$ ('#dcount').css ('background', '#EEEE00');
						return false;
					}
					if ($ ('.textbox-text').val () == '')
					{
						$ ('.textbox-text').css ('background', '#EEEE00');
						return false;
					}
					if ($ ('#telNum').val () == '')
					{
						$ ('#telNum').css ('background', '#EEEE00');
						return false;
					}
					if ($ ('#receiverName').val () == '')
					{
						$ ('#receiverName').css ('background', '#EEEE00');
						return false;
					}
					if ($ ('#addressName').val () == '')
					{
						$ ('#addressName').css ('background', '#EEEE00');
						return false;
					}
					else
					{
						ajaxpost ();
					}
				}
				;
			});

			$ ('#postrest').click (function ()
			{
				$ ('.btnreset').val ('');
				$ ('.btnreset').css ('background', '#fff');
				$ ('.textbox-text').val ('');
				$ ('.textbox-text').css ('background', '#fff');
			});

			function ajaxpost ()
			{
				$.ajax (
				{
				    type : "POST",
				    url : '<%=request.getContextPath()%>/SettlementDeliveryController/deliveryApply',
				    data :
				    {
				        "commodityName" : $ ('#nametext').val (),
				        "commodityId" : $ ('#vcode').val (),
				        "warehouseId" : $ ('#housetext').val (),
				        "position" : $ ('#vcount').val (),
				        "deliveryQuatity" : $ ('#dcount').val (),
				        "deliveryDate" : $ ('#ddate').datebox ('getValue'),
				        "deliveryMethod" : $ (".pickup").find ("option:selected").val (),
				        "idcardNum" : $ ('#cardNum').val (),
				        "tel" : $ ('#telNum').val (),
				        "receiver" : $ ('#receiverName').val (),
				        "address" : $ ('#addressName').val (),
				        "unit" : $ ('#punit').val ()
				    },
				    success : function (response)
				    {
					    if (response == "success")
					    {
						    alert ("添加成功");
						    $ ('.btnreset').val ('');
						    $ ('.btnreset').css ('background', '#fff');
						    $ ('.textbox-text').val ('');
						    $ ('.textbox-text').css ('background', '#fff');
						    
						    loadData ();
					    }
					    if (response == "error")
					    {
						    alert ("添加失败，请按照格式填写参数");
					    }
					    ;
				    },
				    error : function (response)
				    {
					    alert ("添加失败，请重试或联系管理员");
				    }
				});
			}
	</script>
</body>
</html>