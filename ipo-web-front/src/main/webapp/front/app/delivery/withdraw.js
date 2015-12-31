$(function() {

  $('.pickup').change(function() {
    var value = $(".pickup").find("option:selected").val();
    if (value == '1') {
      $('.customer').removeClass('hide');
      $('.dispatching').addClass('hide');
      $('.dispatching input').attr('required', false);
      $('.customer input').attr("required",true);
    }
    if (value == '2') {
      $('.customer').addClass('hide');
      $('.dispatching').removeClass('hide');
      $('.customer input').attr('required', false);
      $('.dispatching input').attr("required",true);

    }
  });

  //定义加载对象
  var commodities = [{
    "commodityname": '春树秋香图',
    "commodityid": '201510010000',
    "position": "50",
    "warehouse": ["1号仓库", "长三角"],
    "warehouseId": ["23", "543"]
  }, {
    "commodityname": '奔马图',
    "commodityid": '11010000',
    "position": "100",
    "warehouse": ["5号仓库", "东北亚", "长三角"],
    "warehouseId": ["536", "543", "123"]
  }, {
    "commodityname": '墨竹戒指',
    "commodityid": '666666',
    "position": "2333",
    "warehouse": ["老王家", "长三角"],
    "warehouseId": ["6345323", "543"]
  }];
  //ajax获取远程对象并替换本地
  // $.ajax({
  //   type: "GET",
  //   async: false,
  //   url: '<%=request.getContextPath()%>/SettlementDeliveryController/deliveryInfo?dealerId=' + '<%=dealerId %>',
  //   success: function(response) {
  //     commodities = eval(response);
  //   },
  //   error: function(response) {
  //     alert("出错咯");
  //   }
  // });

  //页面初始化
  initial();
  //加载藏品名称数据
  function initial() {
    var selname = $('#nametext');
    var selhouse = $('#housetext');
    for (var i = 0; i < commodities.length; i++) {
      selname.append('<option logix =' + i + '>' + commodities[i].commodityname + '</option>');
    }
    $("#vcode").val(commodities[0].commodityid);
    $("#vcount").val(commodities[0].position);
    var warehouses = commodities[0].warehouse;
    var warehouseId = commodities[0].warehouseId;
    for (var i = 0; i < warehouses.length; i++) {
      selhouse.append('<option value =' + warehouseId[i] + '>' + warehouses[i] + '</option>');
    }
    $('#dcount').attr('min', 1);
  	$('#dcount').attr('max', $('#vcount').val());
  }
  //选择其他商品名称是变化
  $('#nametext').change(function() {
    var logic = $("#nametext").find("option:selected").attr('logix');
    var selname = $('#nametext');
    var selhouse = $('#housetext');
    $("#vcode").val(commodities[logic].commodityid);
    $("#vcount").val(commodities[logic].position);
    var warehouses = commodities[logic].warehouse;
    var warehouseId = commodities[logic].warehouseId;
    selhouse.empty()
    for (var i = 0; i < warehouses.length; i++) {
      selhouse.append('<option value =' + warehouseId[i] + '>' + warehouses[i] + '</option>');
    }
    $('#dcount').attr('min', 1);
  	$('#dcount').attr('max', $('#vcount').val());
  });

  function checksubmit(){
	}
})













