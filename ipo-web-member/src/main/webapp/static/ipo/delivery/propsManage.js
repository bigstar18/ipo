function returntoList(){
      document.location.href =   getRootPath () +"/mgr/app/delivery/deliveryProps.jsp" ;
}

function updateDeliveryProps(){
	if($("#flag").val()=='0'){
		alert("无法设置商品的交收属性，请先到综合系统配置所属分类和品名的属性！");
		return false;
	}
	for(var i=1;i<=$("#flag").val();i++){
		var id="sortno"+i;
		var temp = document.getElementById(id).value;
		if (temp==""){
			alert("所有项必选！")
			return false;
		}
	}
	                   $.ajax({ 
                            		   cache:false,
                                       type: "post",  
                                       url: getRootPath () +"/DeliveryController/setCommDeliveryProps",       
                                       data: $("#frm").serialize(),      
                                       success: function(data) { 
                                    	   if(data=='true'){
                                           alert("已设置交收属性！"); 
                                           returntoList();
                                    	   }else{
                                    		   alert("系统异常，请联系管理员");  
                                    	   }
                                       },  
                                       error: function(data) {  
                                           alert("系统异常，请联系管理员!");  
                                       }  
                                   }); 
	
	
}
