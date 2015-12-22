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


})
