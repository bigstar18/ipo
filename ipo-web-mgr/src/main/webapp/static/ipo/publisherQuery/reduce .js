$(document).ready(function() {
	 $('#dg').datagrid({  
         title:'�ֲ���Ϣ',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         singleSelect:true,
         toolbar:"#tb", 
         nowrap:true,  
         striped:true,  
         collapsible:false,  
         url:  getRootPath () + "/PublisherController/reduceHoldPosition" ,  
         loadMsg:'���ݼ�����......',  
         fitColumns:true,//�������Զ�����,����Ӧ������   
         columns : [ [  {
        	 field : 'id',  
             width : 200,  
             align: "center",
             title : '���۳ֲֵ���'
         },  {
        	 field : 'publisherId',  
             width : 200,  
             align: "center",
             title : '���л�Ա���'
         }, {
        	 field : 'firmId',  
             width : 200,  
             align: "center",
             title : '�����̴���'
         }, {
        	 field : 'commodityId',  
             width : 200,  
             align: "center",
             title : '��Ʒ����'
         } ,{
        	 field : 'commodityName',  
             width : 200,  
             align: "center",
             title : '��Ʒ����'
         } ,{
        	 field : 'holdqty',  
             width : 200,  
             align: "center",
             title : 'ת�ֲ�����'
         } 
         ,{
        	 field : 'frozenqty',  
             width : 200,  
             align: "center",
             title : '��������'
         } ,{
        	 field : 'freeqty',  
             width : 200,  
             align: "center",
             title : '�ͷ�����'
         },{
          field: 'oper',
          title: '����',
          align: 'center',
          formatter: function(value, row, index) {
        	   return "<a href=\"#\" onclick=\"add("+row.id+")\">" + "��������" + "</a>";
          }
         }
         ]],  
         pagination : true 
     });  
	 var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '��',
	        afterPageText: 'ҳ    �� {pages} ҳ', 
	        displayMsg: '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼'
	    }); 
});
	
 function doSearch(){
	$('#dg').datagrid('load',{
		publisherId:$("#publisherid").val(),
		commodityId:$("#commodityid").val()
	});
}


function clearInfo(){
	$("#publisherid").val("");
	$("#commodityid").val("");
}

  function add(id){
	  var url_=getRootPath () +'/trusteeshipCommodityController/reduce?positionFlowId='+id;
	  window.location.href=url_; 
  }