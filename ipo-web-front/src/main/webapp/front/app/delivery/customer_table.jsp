<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>打印单号</title>
  <script type="text/javascript" src="../../../static/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="dickytest/vue.js"></script>
  <style media=print type="text/css">
    .noprint{visibility:hidden}
  </style>
</head>
<body>
  <input class="noprint" id="printset" type="button" value="打印页面" onclick="printpage()" style="display: none;" />
  <fieldset>
    <legend>提货单信息</legend>
    <table id="ctable" width="55%" cellspacing="0" cellpadding="0" align="center">
      <tbody>
        <tr>
          <td align="center" height="45" colspan="2">
            <p style="font-size: 30px; font-weight: bold;">
              中国供销集团<br>提货单
            </p>
          </td>
        </tr>
        <tr>
          <td align="right" height="35">
            <span>
            提货单号：
          </span>
          </td>
          <td align="center" id="deliveryorderId">
          </td>
        </tr>
        <tr>
          <td align="right" height="35">
            <span>
            商品代码：
          </span>
          </td>
          <td align="center" id="commodityId">
          </td>
        </tr>
        <tr>
          <td align="right" height="35">
            <span>
            商品名称：
          </span>
          </td>
          <td align="center" id="commodityName">
          </td>
        </tr>
        <tr>
          <td align="right" height="35">
            <span>
            交收仓库名称：
          </span>
          </td>
          <td align="center" id="warehouseName">
          </td>
        </tr>
        <tr>
          <td align="right" height="35">
            <span>
            交割数量：
          </span>
          </td>
          <td align="center" id="deliveryQuatity">
          </td>
        </tr>
        <tr id="pickupshow">
          <td align="right" height="35">
            <span>
            提货密码：
          </span>
          </td>
          <td align="center" id="pickupPassword">
          </td>
        </tr>
        <tr>
          <td align="right" height="35">
            <span>
            单位：
          </span>
          </td>
          <td align="center" id="unit">
          </td>
        </tr>
        <tr>
          <td align="right" height="35">
            <span>
            提货日期：
          </span>
          </td>
          <td align="center" id="deliveryDate"><input id="approvalStatus" type="hidden">
          </td>
        </tr>

        <tr id="pickupset" class="noprint">
          <td colspan="3" align="center" height="35">
            <input type="password" id="setpickuppwd" placeholder="请输入您的8位提货密码"
            onkeyup="value=value.replace(/[\W]/g,'') "
            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
            style="width: 150px; border: 1px solid #95B8E7; border-radius: 5px; height: 20px; padding-left: 4px;" />
            <input type="password" id="checkpickuppwd" placeholder="请输入相同密码"
            onkeyup="value=value.replace(/[\W]/g,'') "
            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
            style="width: 150px; border: 1px solid #95B8E7; border-radius: 5px; height: 20px; padding-left: 4px;" />
            <input type="button" onclick="passwordset()" value="确认" />
          </td>
        </tr>
      </tbody>
    </table>
  </fieldset>
  <script type="text/javascript">


  $(document).ready(function() {


    var url = location.search;
    if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("=");
    }
    var methodid = strs[1];//获取url参数
    

    var ctable = {};
    $.ajax({
      type: 'post',
      url: "../../../SettlementDeliveryController/getDetail",
      data:{"methodid":methodid},
      success : function(response) {
        var responseStr = $.parseJSON(response);
        $('#deliveryorderId').html(responseStr[1].deliveryorderId);
        $('#commodityId').html(responseStr[1].commodityId);
        $('#commodityName').html(responseStr[1].commodityName);
        $('#warehouseName').html(responseStr[1].warehouseName);
        $('#deliveryQuatity').html(responseStr[1].deliveryQuatity);
        $('#pickupPassword').html(responseStr[0].pickupPassword);
        $('#unit').html(responseStr[1].unit);
        $('#deliveryDate').html(responseStr[1].deliveryDate);
        $('#approvalStatus').val(responseStr[1].approvalStatus);
        var cdata = $('#deliveryDate').text().substr(0, 10);
        $('#deliveryDate').html(cdata);
        $('#printset').show();
        $('#pickupshow').show();
      },
      error: function(response) {
        alert("加载失败，请刷新重试");
      }
    });

  });
  //点击设置密码
  function passwordset (argument) {
    var deliveryorderid = $('#deliveryorderId').html();
    var pickupPassword = $('#setpickuppwd').val();
    if ($('#setpickuppwd').val().length != 8) {
      alert("请输入八位有效密码");
      return false;
    }if ($('#setpickuppwd').val() != $('#checkpickuppwd').val()){
      alert("请输入相同密码");
      return false;
    }else{
      $.ajax({
        type: 'post',
        url: "<%=request.getContextPath()%>/TransferController/setPassword",
        data:{"deliveryorderid":deliveryorderid, "pickupPassword": pickupPassword},
        success : function(response) {
             if(response=='success'){
            	 alert("设置成功！");
            	 window.close();
             }else{
            	 alert("系统异常，请联系管理员！");
             }
        },
        error: function(response) {
          alert("系统异常，请联系管理员！");
        }
      });
    };
  }
  //点击打印
  function printpage() {
	  var status = '0';
 	  var deliveryorderid = $('#deliveryorderId').html();
 	  var approvalStatus = $('#approvalStatus').val();
 	  if(approvalStatus == '002001'){
 		  status = '003001';
 	  }else{
 		  status = approvalStatus;
 	  }
  	  $.ajax({
  			 type: 'post',
  		      url: "<%=request.getContextPath()%>/SettlementDeliveryController/updateByStatus",
  		     data:{"deliveryorderid":deliveryorderid,
  		    	 	"status":status
  		    	  },
  		     success : function(data) {
  			           if(data=='success'){
  			        	 window.print();
  			           }else{
  		          		   alert("系统异常，请联系管理员");
  		          	   }
  			        },
		      error : function(data) {
		    	  alert("系统异常，请联系管理员");
		        }
  				});
    }
  window.onunload = function(){
      window.opener.location.reload();
  }
  </script>
</body>
</html>