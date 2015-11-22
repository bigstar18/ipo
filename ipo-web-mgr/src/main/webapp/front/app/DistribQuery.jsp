<%@ page contentType="text/html;charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>


<title>����ҡ��</title>

	<meta name="decorator" content="default"/>
	<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
    <script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
	<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
</head>
 <body>
	<div class="main">
	<div class="msg">����ǰ��λ�ã�<span>����ҡ��</span></div>
	
		<div class="col-xs-12">
		<br>
			
			<div id="myTabContent" class="tab-content">
			<table id="mytb" border ="1" class="easyui-datagrid"  title="����ҡ��"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/QueryController/findRockNums',method:'get'"
            toolbar="#tb">
        <thead>
            <tr>
                <th data-options="field:'commodityid',width:200">��Ʒ����</th>
                <th data-options="field:'starttime',width:200,formatter:dateconvertfunc">���п�ʼ����</th>
                <th data-options="field:'endtime',width:200,formatter:dateconvertfunc">���н�������</th>
                <th data-options="field:'counts',width:200">���Ϸ�������</th>
                <th data-options="field:'ccounts',width:200">�깺����</th>
                <th data-options="field:'operating',width:200,formatter:rocknum">��ʼҡ��</th>
            </tr>
        </thead>
    		</table>
    		<!-- <div id="tb" style="padding:3px">
			<span>��Ʒ����:</span>
			<input id="itemid" name = "itemid"style="line-height:26px;border:1px solid #ccc">
			<a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">��ѯ</a>
			<a href="javascript:reset()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">����</a>
			</div>
			</div>
		</div> -->
		
		

<script type="text/javascript">
$(document).ready(function() {
	 var p = $('#mytb').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '��',
	        afterPageText: 'ҳ    �� {pages} ҳ', 
	        displayMsg: '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼', 
	    });  
});

//����ת��
function dateconvertfunc(value,row){
        return value.substr(0,10);
}

function rocknum(value,row){
	if(row.status == 2){
		
		return '<a href="javascript:constructionManager(\'' + row.commodityid+ '\')" >ִ��ҡ��</a>';
	}else{
		return '�ѳɽ�';
		//return '<a href="javascript:constructionManager(\'' + row.commodityid+ '\')" >ִ��ҡ��</a>';
	}
}

function constructionManager(commodityid){
	 $.ajax({  
		    type: 'get',  
		    url: "<%=request.getContextPath()%>/QueryController/rock",  
		    contentType: "application/json; charset=utf-8", 
		    data:{"commodityid":commodityid},
		    dataType: 'json',  
		    async: true,  
		    success : function(data, stats) { 
		    	if(data == "1"){
	            alert('ҡ�Ž���');
		    	}
	        }
		});  
}

function doSearch(){
	//$('#mytb').datagrid('load',{
	//	commodityid : $('#itemid').val()
	//});
	var itemid = $('#itemid').val();
	$.ajax({  
	    type: 'GET',  
	    url: "<%=request.getContextPath()%>/QueryController/commodityInfo",  
	    contentType: "application/json; charset=utf-8", 
	    data:{commodityid: itemid},  
	    dataType: 'json',  
	    async: true,  
	    success : function(data, stats) {
	    	alert("hehe");
	    },
		error : function(data) {  
	    	alert(data);
	    	console.log(data);
	    } 
 });
}

function reset(){
	itemid.reset();
}


</script>
</div>
</body> 
</html>
