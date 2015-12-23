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
          {{ctables.deliveryorderId}}
          </td>
        </tr>
      </tbody>
    </table>

  <script type="text/javascript">
  function printpage() {
    var newWin = window.open('提货信息', '', '');
    var titleHTML = document.getElementById("form_table").innerHTML;
    newWin.document.write(titleHTML);
    newWin.document.location.reload();
    newWin.print();
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
		"ctables":
	 		{
	          "position": 321,
	          "approvers": "3214",
	          "dealerId": "4",
	          "deliveryMethod": "自提",
	          "remarks": null,
	          "dealerName": "654",
	          "warehouseId": "534",
	          "commodityName": "7657",
	          "applyDate": "2015-12-14 00:00:00",
	          "deliveryorderId": "544",
	          "unit": "11",
	          "warehouseName": "321412",
	          "cancelDate": null,
	          "approvalStatus": 7,
	          "approveDate": "2015-12-21 00:00:00",
	          "deliveryQuatity": 111,
	          "deliveryDate": "2015-12-30 00:00:00",
	          "canceler": null,
	          "commodityId": "145151",
	          "deliveryCounts": null,
	          "methodId": "99"
			}
 		
    }
  });
    $.ajax({
      type: 'post',
      url: "../../../SettlementDeliveryController/getDetail",
      data:{"methodid":methodid},
      success : function(response) {
   	  	//console.log(data);
   	 	//ctable.ctables = response;
        console.log(ctable.ctables);
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