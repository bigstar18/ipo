<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>  
<%@page import="java.lang.String"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%String userId =((UserManageVO)session.getAttribute("CurrentUser")).getUserID();
//String userId ="888";%><html>
<head>
<title>�깺��¼��ѯҳ��</title>
     <meta name="decorator" content="default"/>
     <link rel="stylesheet" href="${ctxStatic}/bootstrap/2.3.1/css_default/bootstrap.min.css">
	 <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
     <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css"> 
     <link href="${skinPath}/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css" />
	<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<style type="text/css">
.panel{float:left}
</style>
</head>
<body>
<div class="main">
	<div class="msg">����ǰ��λ�ã�<span>�깺��¼</span></div>
	<div class="warning">
		<div class="title font_orange_14b">��ܰ��ʾ :</div>
		<div class="content">�ڴ�չʾͶ���ߵ��깺��¼��Ϣ��</div>
	</div>
		<div class="col-xs-12">
			<div id="myTabContent" class="tab-content">
		   <table  id="mytb"  class="easyui-datagrid"  title="�깺��¼��ѯ"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/getOrder',method:'get'">
        <thead>
            <tr>
            			<th data-options="field:'orderid',align: 'center',width:200">������</th>
                        <th data-options="field:'commodityid',align: 'center',width:200">��Ʒ���</th>
						<th data-options="field:'commodityname',align: 'center',width:180">��Ʒ����</th>
						<th data-options="field:'counts',align: 'center',width:200">���깺����</th>
						<th data-options="field:'createtime',align: 'center',width:200,formatter:dateconvertfunc">�깺ʱ��</th>
						<th data-options="field:'frozenfunds',align: 'center',width:200">�ʽ𶳽�</th>
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

//����ת��
function dateconvertfunc(value,row){
        return value.substr(0,10);
}
</script>
</div>
</body>
</html>