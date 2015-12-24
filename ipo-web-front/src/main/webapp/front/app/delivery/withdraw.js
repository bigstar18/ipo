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


  var withdraw = new Vue({
    el: '#withdraw',
    data: {
      selected: '201510010000-50',
      options: [
        { text: '春树秋香图', value: '201510010000-50'},
        { text: '梁非凡', value: '201510010020-55'},
        { text: '刘醒', value: '201510010011-500'},
        { text: '非凡哥', value: '201510010005-150'}
      ],
      warehouseNames: [
        {warehouseName: '长三角'},
        {warehouseName: '东北亚'}
      ]
    }
  });
  // $.ajax({
  //   type:"GET",
  //   url:'http://172.17.12.23',
  //   success: function(response) {
  //     purchase.purchases = response;
  //   },
  //   error: function(response) {
  //   }
  // });
  var vcode = $('#vcode').val().split('-');
  $('#vcode').attr('value', vcode[0]);
  $('#vcount').attr('value', vcode[1]);
  $("#nametext").bind("change",function(){
    if($(this).val()==0){
      return;
    }
    else{
      var vcode = $('#vcode').val().split('-');
      $('#vcode').attr('value', vcode[0]);
      $('#vcount').attr('value', vcode[1]);
    }
  });




  // console.log(withdraw.options);
  // console.log($('#vcode').val().split('-')[0]);
  // console.log($('#vcode').val().split('-')[1]);
  // var vcode = $('#vcode').val().split('-');
  // $('#vcode').attr('value', vcode[0]);
  // $('#vcount').attr('value', vcode[1]);
})
