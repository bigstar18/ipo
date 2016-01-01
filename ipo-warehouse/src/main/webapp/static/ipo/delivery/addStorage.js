$(function(){
$('#commodityid').combobox({  
    url:getRootPath()+ "/DeliveryController/getDeliveryCommodity",    
    valueField:'commodityid',    
    textField:'commodityid' ,
    editable:true,
    onSelect:function(param){
    $("#commodityname").val(param.commodityname);
	$("#breedid").val(param.breedid);
	$("#pubmemberid").val(param.pubmemberid);
	$("#listingdate").val(param.listingdate);
	$("#deliverystartday").val(param.deliverystartday);
	$("#deliunittocontract").val(param.deliunittocontract);
	}
});  
});


function checkCommodity(){
	if( $("#commodityname").val()==""){
		alert("请先选择商品！");
	}
}

function getStorageCounts(){
	if($("#deliunittocontract").val()!=""&&$("#storagenum").val()!=""){
		var counts=("#storagenum").val() * $("#deliunittocontract").val();
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
                                  alert("审核完成！"); 
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
var backUrl=getRootPath ()+"/warehouse/app/storage/storageQuery.jsp";
document.location.href = backUrl;
}

function setCommodity(commId) {
var commlist =getRootPath ()+"/warehouse/app/storage/storageQuery.jsp"; 
for(var o in commlist){  
 if (commId == commlist[o].commodityid ) {
	$("#commodityname").val(commlist[o].commodityname);
	$("#breedid").val(commlist[o].breedid);
	$("#listingdate").val(commlist[o].listingdate);
	$("#deliverystartday").val(commlist[o].deliverystartday);
	$("#deliunittocontract").val(commlist[o].deliunittocontract);
	break;
	}
}  
}	