<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>打印单号</title>
  <script type="text/javascript" src="../../../static/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="dickytest/vue.js"></script>
</head>
<body>
  <input type="button" value="打印页面" onclick="printpage()" />

    <table id="ctable" width="65%" border="1" cellspacing="0" cellpadding="0" align="center">
      <tbody>
        <tr>
          <td align="center" height="35">
            <span>
	          提货单号：
	        </span>
          </td>
          <td align="center">
          {{deliveryorderId}}
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
	          商品代码：
	        </span>
          </td>
          <td align="center">
          {{commodityId}}
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
	          商品名称：
	        </span>
          </td>
          <td align="center">
          {{commodityName}}
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
	          交收仓库名称：
	        </span>
          </td>
          <td align="center">
          {{warehouseName}}
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
	          交割数量：
	        </span>
          </td>
          <td align="center">
          {{deliveryQuatity}}
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            提货密码：
          </span>
          </td>
          <td align="center">
          {{pickupPassword}}
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
	          单位：
	        </span>
          </td>
          <td align="center">
          {{unit}}
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
	          提货日期：
	        </span>
          </td>
          <td align="center" id="deliveryDate">
          {{deliveryDate}}
          </td>
        </tr>
      </tbody>
    </table>

  <script type="text/javascript">
  function printpage() {
	  window.print();
  }
  $(document).ready(function() {
    var url = location.search;
    if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("=");
    }
    var methodid = strs[1];//获取url参数

    var ctable = new Vue({
      el: '#ctable',
      data: {
	          "deliveryorderId": 321,
	          "commodityId": "3214",
	          "commodityName": "4",
	          "warehouseName": "自提",
	          "deliveryQuatity": "111",
	          "pickupPassword": "654",
	          "unit": "534",
	          "deliveryDate": "7657"
 		
    }
  });
   	$.ajax({
      type: 'post',
      url: "../../../SettlementDeliveryController/getDetail",
      data:{"methodid":methodid},
      success : function(response) {
   	  	var responseStr = $.parseJSON(response);
   	 	ctable.deliveryorderId = responseStr.deliveryorderId;
   	 	ctable.commodityId = responseStr.commodityId;
   	 	ctable.commodityName = responseStr.commodityName;
	   	ctable.warehouseName = responseStr.warehouseName;
	   	ctable.deliveryQuatity = responseStr.deliveryQuatity;
	   	ctable.pickupPassword = responseStr.pickupPassword;
	   	ctable.unit = responseStr.unit;
	   	ctable.deliveryDate = responseStr.deliveryDate;
      },
      error: function(response) {
        alert(response);
        //console.log(response);
      }
    });

    // $('#deliveryDate').val().substr(0, 10);
    var cdata = $('#deliveryDate').text().substr(10, 10)
    $('#deliveryDate').html(cdata);
    // console.log($('#deliveryDate').text().substr(10, 10));
  });
  </script>
</body>
</html>