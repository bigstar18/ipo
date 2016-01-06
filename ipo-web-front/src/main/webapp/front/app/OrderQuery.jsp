<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>  
<%@page import="java.lang.String"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%String userId =((UserManageVO)session.getAttribute("CurrentUser")).getUserID();
//String userId ="888";%><html>
<head>
<title>申购记录查询页面</title>
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
	<div class="msg">您当前的位置：<span>申购记录</span></div>
	<div class="warning">
		<div class="title font_orange_14b">温馨提示 :</div>
		<div class="content">在此展示投资者的申购记录信息。</div>
	</div>
		<div class="col-xs-12">
			<div id="myTabContent" class="tab-content">
		   <table  id="mytb"  class="easyui-datagrid"  title="申购记录查询"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/getOrder',method:'get'">
        <thead>
            <tr>
            			<th data-options="field:'orderid',align: 'center',width:200">订单号</th>
                        <th data-options="field:'commodityid',align: 'center',width:200">商品编号</th>
						<th data-options="field:'commodityname',align: 'center',width:180">商品名称</th>
						<th data-options="field:'counts',align: 'center',width:200">已申购数量</th>
						<th data-options="field:'createtime',align: 'center',width:200,formatter:dateconvertfunc">申购时间</th>
						<th data-options="field:'frozenfunds',align: 'center',width:200">资金冻结</th>
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
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    });  
});

//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
}
</script>
</div>
</body>
</html>