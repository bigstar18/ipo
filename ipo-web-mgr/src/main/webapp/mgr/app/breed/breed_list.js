/*
 *
 */
$(document).ready(function() {
	 var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
		    
	 function rowformatertoimg(value,row){
	   var imgurl="${skinPath}"+"/image/app/timebargain/commodity.gif";
       return "<a href=\"#\" onclick=\"updateForward("+value+")\"><img src="+imgurl+"/></a>";
}        
	    
	function rowformater(value,row){
       return "<a href=\"#\" class=\"blank_a\" onclick=\"return detailForward("+value+");\"><font color=\"#880000\">"+value+"</font></a>";
}    
	    

	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
});