<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
<title>配号记录查询页面</title>
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
	<div class="msg">您当前的位置：<span>配号记录</span></div>
	<div class="warning">
		<div class="title font_orange_14b">温馨提示 :</div>
		<div class="content">在此展示投资者提交申购订单后获得的配号信息。</div>
	</div>

		<div class="col-xs-12">
		<br>
			
		<br>
			<div id="myTabContent" class="tab-content">
			<table id="mytb" class="easyui-datagrid"  title="配号记录查询"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/QueryController/findRockNums',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'commodityid',width:200">商品代码</th>
                <th data-options="field:'starttime',width:180">发行开始日期</th>
                <th data-options="field:'endtime',width:200">发行截至日期</th>
                <th data-options="field:'ptime',width:200,formatter:dateconvertfunc">网上发行数量</th>
                <th data-options="field:'zcounts',width:200,formatter:rocknum">申购数量</th>
                <th data-options="field:'id',width:200,formatter:rocknum">开始摇号</th>
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

function rocknum(){
	return "<a id= href="javascript:void(0);" >开始摇号</a>";
}



$()function start(){
	
}

//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
} 
</script>
</div>
</body>
</html>