<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>  
<%@page import="java.lang.String"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%String userId =((UserManageVO)session.getAttribute("CurrentUser")).getUserID();
//String userId ="888";%><html>
<head>
<title>中签记录查询页面</title>
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
	<div class="msg">您当前的位置：<span>中签记录</span></div>
	<div class="warning">
		<div class="title font_orange_14b">温馨提示 :</div>
		<div class="content">在此展示投资者的中签记录信息。</div>
	</div>

		<div class="col-xs-12">
		<br>
			<div id="myTabContent" class="tab-content">
		   <table  id="mytb"  class="easyui-datagrid"  title="中签记录查询"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findApplyNumsuserid=<%=userId %>',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'commodityname',width:200">申购产品</th>
                <th data-options="field:'startnumber',width:180">起始配号</th>
                <th data-options="field:'pcounts',width:200">配号数量</th>
                <th data-options="field:'ptime',width:200,formatter:dateconvertfunc">配号时间</th>
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