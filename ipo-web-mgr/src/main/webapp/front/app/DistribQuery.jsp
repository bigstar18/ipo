<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%><html>
<head>
<title>Ͷ�����깺ҳ��</title>
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
	<div class="msg">����ǰ��λ�ã�<span>Ͷ�������</span></div>
	<div class="warning">
		<div class="title font_orange_14b">��ܰ��ʾ :</div>
		<div class="content">�ڴ�չʾͶ�����ύ�깺�������õ������Ϣ��</div>
	</div>

		<div class="col-xs-12">
		<br>
			<div id="myTabContent" class="tab-content">
		   <table class="easyui-datagrid"  title="Ͷ������Ų�ѯ"   style="width:100%;height:345px"
            data-options="singleSelect:true,collapsible:false,pagination:true,pageSize:10,pageList:[10,15,20,25],fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findApplyNums',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'commodityname',width:200">�깺��Ʒ</th>
                <th data-options="field:'startnumber',width:180">��ʼ���</th>
                <th data-options="field:'pcounts',width:200">�������</th>
                <th data-options="field:'ptime',width:200,formatter:dateconvertfunc">���ʱ��</th>
            </tr>
        </thead>
    </table>
			</div>
		</div>

<script type="text/javascript">

//����ת��
function dateconvertfunc(value,row){
         //  return new Date(value).toLocaleDateString(); //���ر���ϵͳ��ʽʱ��
        /*    var date=new Date(value);
        var year=date.getFullYear();
        var month=date.getMonth()<9?'0'+(date.getMonth()+1):(date.getMonth()+1);
        var day=date.getDate()<10?'0'+date.getDate():date.getDate(); 
        return year+'-'+month+'-'+day;     JSON������������ת������ */ 
        return value.substr(0,10);
} 



</script>
</div>
</body>
</html>