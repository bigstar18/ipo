$(document).ready(function() {
	 var p1 = $('#mytb1').datagrid('getPager'); 
	    $(p1).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    });  
	    
	     var p2 = $('#mytb2').datagrid('getPager'); 
	    $(p2).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    }); 
	
   //获取用户保证金	
	  $.ajax({  
		    type: 'GET',  
		    url: "<%=request.getContextPath()%>/CommodityController/getUserInfo",  
		    contentType: "application/json; charset=utf-8", 
		    data:{"userid":"<%=userId %>"},  
		    dataType: 'json',  
		    async: true,  
		    success : function(data, stats) {  
	            $("#money").text(data);
	        }    
		});  

		//申购
	$("#btn").bind('click',function(){
		if($("#comname").text()==""){
			$("#remind").text("请输入正确的商品编号！");
			return;
		}
		if($("#quantity").val().length>9){
			$("#remind").text("购买量过大！");
			return;
		}
		if($("#quantity").val().length==0){
			$("#remind").text("请输入购买量！");
			return;
		}
		var price=$("#price").val();
		var units=$("#units").val();
		var num=$("#quantity").val();
		var moneyneed=parseFloat(price)*parseInt(num)*parseInt(units);
		var money= parseFloat( $("#money").text());
		if(moneyneed>money){
			$("#remind").text("资金不足！");
		}else{
		var infos={ "userid":"<%=userId %>","commodityid": $("#commodityid").val() , "quantity" : $("#quantity").val() };
		    $.ajax({  
		    type: 'GET',  
		    url: "<%=request.getContextPath()%>/CommodityController/purchApply",  
		    contentType: "application/json; charset=utf-8", 
		    data:infos,  
		    dataType: 'json',  
		    async: true,  
		    success : function(data, stats) {  
		        if (data == "0") {  
	            	$("#remind").text("提交订单成功！");
	            }  
	            if (data == "1") {  
	            	$("#remind").text("现在非申购时间！");
	            }  
	            if (data == "2") {  
	            	$("#remind").text("资金不足！");
	            }  
	            if (data == "3") {  
	            	$("#remind").text("您已提交订单，请勿重复操作！");
	            }  
	            if (data == "4") {  
	            	$("#remind").text("提交订单失败！");
	            }  
	        },  
	        error : function(data) {  
	           // alert("请求失败");  
	        }  
		});  
		}     
	});
});

//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
} 

//联动
function getDetail(index, data) {
	  if (data) {
		        $("#commodityid").val(data.commodityid);
		        $("#comname").text(data.commodityname);
		        $("#price").val(data.price);
		        $("#units").val(data.units);
		        var comid= data.commodityid;
		  	  $.ajax({  
				    type: 'GET',  
				    url: "<%=request.getContextPath()%>/CommodityController/getInfos",  
				    contentType: "application/json; charset=utf-8", 
				    data:{"commodityid":comid,"money": $("#money").text()},  
				    dataType: 'json',  
				    async: true,  
				    success : function(data, stats) {  
			            $("#counts").text(data.number);
			            $("#limit").text(data.limit);
			        }    
				});  
	        }
}
//申购面板异步刷新
 function showInfo(str){
            var xmlhttp;
          if (str.length==0) {
        	/*   document.getElementById("comname").innerHTML="";
        	  document.getElementById("counts").innerHTML="";
        	  document.getElementById("limit").innerHTML=""; */
        	   $("#comname").text("");
	           $("#counts").text("");
	           $("#limit").text("");
              return; 
           }
         if (window.XMLHttpRequest) {
            xmlhttp=new XMLHttpRequest();  }
        else {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); }
        xmlhttp.onreadystatechange=function() { 
        	if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	               if( xmlhttp.responseText){
	            	   var com=eval('(' + xmlhttp.responseText + ')');
		        /*    document.getElementById("comname").innerHTML=com.name;
		           document.getElementById("counts").innerHTML=com.number;
		           document.getElementById("limit").innerHTML=com.limit; */
		           $("#comname").text(com.name);
		           $("#counts").text(com.number);
		           $("#limit").text(com.limit);
		           $("#price").val(com.price);
		           $("#units").val(com.units);
	               }
	         }
	        else{
	        	   $("#comname").text("");
		           $("#counts").text("");
		           $("#limit").text("");
	  }
    };
           xmlhttp.open("GET","<%=request.getContextPath()%>/CommodityController/getInfos?commodityid="+str+"&money="+$("#money").text(),true);
           xmlhttp.send();
}
