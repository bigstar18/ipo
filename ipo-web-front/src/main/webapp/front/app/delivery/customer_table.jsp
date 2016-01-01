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
      <tb
ody>
        <tr>
          <td align="center" height="35">
            <span>
            提货单号：
          </span>
          </td>
          <td align="center" id="deliveryorderId">
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            商品代码：
          </span>
          </td>
          <td align="center" id="commodityId">
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            商品名称：
          </span>
          </td>
          <td align="center" id="commodityName">
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            交收仓库名称：
          </span>
          </td>
          <td align="center" id="warehouseName">
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            交割数量：
          </span>
          </td>
          <td align="center" id="deliveryQuatity">
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            提货密码：
          </span>
          </td>
          <td align="center" id="pickupPassword">
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            单位：
          </span>
          </td>
          <td align="center" id="unit">
          </td>
        </tr>
        <tr>
          <td align="center" height="35">
            <span>
            提货日期：
          </span>
          </td>
          <td align="center" id="deliveryDate">
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

    var ctable = {}
    $.ajax({
      type: 'post',
      url: "../../../SettlementDeliveryController/getDetail",
      data:{"methodid":methodid},
      success : function(response) {
        var responseStr = $.parseJSON(response);
        $('#deliveryorderId').html(responseStr.deliveryorderId);
        $('#commodityId').html(responseStr.commodityId);
        $('#commodityName').html(responseStr.commodityName);
        $('#warehouseName').html(responseStr.warehousename);
        $('#deliveryQuatity').html(responseStr.deliveryQuatity);
        $('#pickupPassword').html(responseStr.pickupPassword);
        $('#unit').html(responseStr.unit);
        $('#deliveryDate').html(responseStr.deliveryDate);
        var cdata = $('#deliveryDate').text().substr(0, 10)
        $('#deliveryDate').html(cdata);
      },
      error: function(response) {
        alert(response);
        //console.log(response);
      }
    });

    // $('#deliveryDate').val().substr(0, 10);

    // console.log($('#deliveryDate').text().substr(10, 10));
  });
  </script>
</body>
</html>