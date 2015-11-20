<%@ page contentType="text/html;charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>


<title>�깺��¼��Ϣ�б�</title>

	<meta name="decorator" content="default"/>
	<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
    <script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

</head>
<body>
	<div class="main">
	<div class="msg">����ǰ��λ�ã�<span>�깺��¼</span></div>
	<div class="warning">
		<div class="title font_orange_14b">��ܰ��ʾ :</div>
		<div class="content">�ڴ�չʾͶ���ߵ��깺��¼��Ϣ��</div>
	</div>

		<div class="col-xs-12">
		<br>
			<div id="myTabContent" class="tab-content">
		   <table  id="mytb"  class="easyui-datagrid"  title="�깺��¼��ѯ"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/QueryController/getAllOrder',method:'get'">
        <thead>
            <tr>
                        <th data-options="field:'commodityid',width:200">��Ʒ���</th>
						<th data-options="field:'commodityname',width:180">��Ʒ����</th>
						<th data-options="field:'counts',width:200">���깺����</th>
						<th data-options="field:'createtime',width:200,formatter:dateconvertfunc">�깺ʱ��</th>
						<th data-options="field:'frozenfunds',width:200">�ʽ𶳽�</th>
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
