/*
 *
 */
$(document).ready(function() {
	 var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '��',
	        afterPageText: 'ҳ    �� {pages} ҳ', 
	        displayMsg: '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼'
	    });  
		    
	 function rowformatertoimg(value,row){
	   var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
       return "<a href=\"#\" onclick=\"updateForward("+value+")\"><img src="+imgurl+"/></a>";
}        
	    
	function rowformater(value,row){
       return "<a href=\"#\" class=\"blank_a\" onclick=\"return detailForward("+value+");\"><font color=\"#880000\">"+value+"</font></a>";
}    
	    

	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
});