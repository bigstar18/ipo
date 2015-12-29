<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>
<%@page import="java.lang.String"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%String dealerId ="111";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提货申请</title>
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
    padding: 5px;
    border-top: 1px solid #95B8E7;
    border-left: 1px solid #95B8E7;
    border-right: 1px solid #95B8E7;
    background: #EFF5FF;
  }

  .mbody {
    border: 1px solid #95B8E7;
    background: #F4F4F4;
  }
  /*body{background-color: #E0EEEE}*/
  </style>
  <link href="../../../front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="../../../static/jquery-easyui/themes/default/easyui.css">
  <script type="text/javascript" src="../../../static/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="../../../static/jquery-easyui/jquery.easyui.min.js"></script>

</head>
<body>
  <div class="main">
    <div class="msg">
      您当前的位置：<span>提货申请</span>
    </div>
    <div class="warning">
      <div class="title font_orange_14b">温馨提示 :</div>
      <div class="content">在此页面上提交提货单
      </div>
    </div>
    <div class="mbodytop">
      <div class="panel-title panel-with-icon">提货信息</div>
    </div>
    <div class="mbody">
      <form id="withdraw">
        <table border="0" width="300" cellspacing="0" cellpadding="0" align="center">
          <tbody>
            <tr>
              <td height="15" colspan="2">
                &nbsp;
              </td>
            </tr>
            <tr>
              <td height="3" colspan="2">
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;藏品名称：
                        </span>
              </td>
              <td>
                <select name="" style="width: 154px;" id="nametext">
                </select><b>*</b>
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;藏品代码：
                        </span>
              </td>
              <td>
                <input id="vcode" type="text" value="" name="" style="width: 150px;" disabled="disabled"><b>*</b>
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;交货仓库：
                        </span>
              </td>
              <td>
                <select name="" style="width: 154px;" id="housetext">
                </select><b>*</b>
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;持仓数量：
                        </span>
              </td>
              <td>
                <input id="vcount" type="text" name="" style="width: 150px;" disabled="disabled"><b>*</b>
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;交割数量：
                        </span>
              </td>
              <td>
                <input type="text" name="" value="" style="width: 150px;"><b>*</b>
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;提货日期：
                        </span>
              </td>
              <td>
                <input class="easyui-datebox" type="datetime" name="" value="" style="150px"><b>*</b>
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;提货方式：
                        </span>
              </td>
              <td>
                <select class="pickup" name="" style="width: 154px;">
                  <option value="customer">
                    自提
                  </option>
                  <option value="dispatching">
                    配送
                  </option>
                </select><b>*</b>
              </td>
            </tr>
            <tr class="customer">
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;身份证号：
                        </span>
              </td>
              <td>
                <input type="text" name="" value="" style="width: 150px;"><b>*</b>
              </td>
            </tr>
            <tr class="dispatching hide">
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;电话：
                        </span>
              </td>
              <td>
                <input type="text" name="" value="" style="width: 150px;"><b>*</b>
              </td>
            </tr>
            <tr class="dispatching hide">
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;收货人：
                        </span>
              </td>
              <td>
                <input type="text" name="" value="" style="width: 150px;"><b>*</b>
              </td>
            </tr>
            <tr class="dispatching hide">
              <td align="center" height="35" width="100">
                <span>
                          &nbsp;&nbsp;地址：
                        </span>
              </td>
              <td>
                <input type="text" name="" value="" style="width: 150px;"><b>*</b>
              </td>
            </tr>
            <tr>
              <td align="center" height="35" width="100">
                <input type="submit" id="subbtn" value="提交">
              </td>
              <td align="center" height="35" width="100">
                <input type="reset" name="button" value="重置" />
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>
  <table border="0" width="700" align="center">
    <tbody>
      <tr>
        <td align="center" style="color: red">提示：提货单注册后过了提货日期则不能提货，需注销提货单后重新注册</td>
      </tr>
    </tbody>
  </table>
  <script type="text/javascript">
$(function() {
	  $('.pickup').change(function() {

	    var value = $(".pickup").find("option:selected").val();

	    if (value == 'customer') {
	      $('.customer').removeClass('hide');
	      $('.dispatching').addClass('hide');
	    }
	    if (value == 'dispatching') {
	      $('.customer').addClass('hide');
	      $('.dispatching').removeClass('hide');
	    }

	  });

	  var commodities;
	  $.ajax({
	  	type:"GET",
	  	async: false,
	    url:'<%=request.getContextPath()%>/SettlementDeliveryController/deliveryInfo?dealerId='+'<%=dealerId %>',
	    success: function(response) {
	    	commodities = eval(response);
	    },
	    error: function(response) {
	    	alert("出错咯");
	    }
	  });

	  //页面初始化
	  initial ();
	  //加载藏品名称数据
	  function initial () {

	    var selname = $('#nametext');
	    var selhouse = $('#housetext');
	    for(var i = 0; i < commodities.length; i++){
	      selname.append('<option logix =' + i + '>'+commodities[i].commodityname+'</option>');
	    }
	    $("#vcode").val(commodities[0].commodityid);
	    $("#vcount").val(commodities[0].position);
	    var warehouses = commodities[0].warehouse;
	    for(var i = 0; i < warehouses.length; i++){
	      selhouse.append('<option logix =' + i + '>'+warehouses[i]+'</option>');
	    }
	  }
	  //选择其他商品名称是变化
	  $('#nametext').change(function() {
	    var logic = $("#nametext").find("option:selected").attr('logix');

	    var selname = $('#nametext');
	    var selhouse = $('#housetext');
	    $("#vcode").val(commodities[logic].commodityid);
	    $("#vcount").val(commodities[logic].position);
	    var warehouses = commodities[logic].warehouse;
	    selhouse.empty()
	    for(var i = 0; i < warehouses.length; i++){
	      selhouse.append('<option logix =' + i + '>'+warehouses[i]+'</option>');
	    }
	  });
	  
	  $('#subbtn').click(function () {
		    $.ajax({
		      cache: true,
		      type: "POST",
		      url:,
		      data:$('#withdraw').serialize(),
		      async: false,
		      success: function(response) {
		          alert("提交成功");
		      },
		      error: function(response) {
		          alert("提交失败，请联系管理员");
		      }
		    });
		  });
	})
	
</script>
</body>
</html>