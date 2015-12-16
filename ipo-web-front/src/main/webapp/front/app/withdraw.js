$(function() {
  $('.pickup').change(function() {

    var value = $(".pickup").find("option:selected").val();

    if (value == 'customer') {
      $('.dispatching').addClass('hide');
    }
    if (value == 'dispatching') {
      $('.dispatching').removeClass('hide');
    }

  });


})
