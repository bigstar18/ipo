$(function(){
$('#commodityid').combobox({  
    url:getRootPath()+ "/DeliveryController/getDeliveryCommodity",    
    valueField:'commodityid',    
    textField:'commodityid' ,
    editable:false,
    onSelect:function(param){
    $("#commodityname").val(param.commodityname);
	$("#breedid").val(param.breedid);
	$("#pubmemberid").val(param.pubmemberid);
	$("#listingdate").val(param.listingdate.substr(0,10));
	$("#deliverystartday").val(param.deliverystartday.substr(0,10));
	$("#deliunittocontract").val(param.deliunittocontract);
	$("#contractfactor").val(param.contractfactor);
	$("#storagenum").val("");
	}
});  
});


function checkCommodity(){
	if( $("#commodityname").val()==""){
		alert("请先选择商品！");
		$("#startnum").focus();
		return false;
	}
}

function getStorageCounts(){
	var multiple=$("#deliunittocontract").val();
	var storagenum=$("#storagenum").val();
	var contractfactor=$("#contractfactor").val();
	if(multiple!=""&&storagenum!=""&&contractfactor!=''){
		var counts=parseFloat(multiple) *parseFloat( storagenum) * parseFloat(contractfactor);
		$("#storagecounts").val(counts);
	}
}

function saveStorage(){
	if($("#commodityname").val()==""||$("#storagenum").val()==""){
		alert("请选择商品并填写入库件数！");
		return　　false;
	}
                   	   $.ajax({ 
                   		   cache:false,
                              type: "post", 
                              url:getRootPath ()+ "/DeliveryController/saveStorage",       
                              data: $("#frm").serialize(),      
                              success: function(data) { 
                           	   if(data=='true'){
                                  alert("增加成功！"); 
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


function returntoList(){
var backUrl=getRootPath ()+"/mgr/app/storage/storageQuery.jsp";
document.location.href = backUrl;
}
