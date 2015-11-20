<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
<title>��ż�¼��ѯҳ��</title>
     <meta name="decorator" content="default"/>
	 <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
     <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css"> 
	<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<style type="text/css">
.panel{float:left}
</style>
</head>
<body>
<div class="main">
	<div class="msg">����ǰ��λ�ã�<span>��ż�¼</span></div>
	<div class="warning">
		<div class="title font_orange_14b">��ܰ��ʾ :</div>
		<div class="content">�ڴ�չʾͶ�����ύ�깺�������õ������Ϣ��</div>
	</div>

		<div class="col-xs-12">
		<br>
			
		<br>
			<div id="myTabContent" class="tab-content">
			<table id="mytb" class="easyui-datagrid"  title="��ż�¼��ѯ"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/QueryController/findRockNums',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'commodityid',width:200">��Ʒ����</th>
                <th data-options="field:'starttime',width:180">���п�ʼ����</th>
                <th data-options="field:'endtime',width:200">���н�������</th>
                <th data-options="field:'ptime',width:200,formatter:dateconvertfunc">���Ϸ�������</th>
                <th data-options="field:'zcounts',width:200,formatter:rocknum">�깺����</th>
                <th data-options="field:'id',width:200,formatter:rocknum">��ʼҡ��</th>
            </tr>
        </thead>
    </table>
			</div>
		</div>

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

function rocknum(){
	return "<a id= href="javascript:void(0);" >��ʼҡ��</a>";
}



$()function start(){
	
}

//����ת��
function dateconvertfunc(value,row){
        return value.substr(0,10);
} 
</script>
</div>
</body>
</html>