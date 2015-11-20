<%@ page contentType="text/html;charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>


<title>申购记录信息列表</title>

	<meta name="decorator" content="default"/>
	<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
    <script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

</head>
<body>
	<div class="main">
	<div class="msg">您当前的位置：<span>申购记录</span></div>
	<div class="warning">
		<div class="title font_orange_14b">温馨提示 :</div>
		<div class="content">在此展示投资者的申购记录信息。</div>
	</div>

		<div class="col-xs-12">
		<br>
			<div id="myTabContent" class="tab-content">
		   <table  id="mytb"  class="easyui-datagrid"  title="申购记录查询"   style="width:100%;height:385px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/QueryController/getAllOrder',method:'get'">
        <thead>
            <tr>
                        <th data-options="field:'commodityid',width:200">商品编号</th>
						<th data-options="field:'commodityname',width:180">商品名称</th>
						<th data-options="field:'counts',width:200">已申购数量</th>
						<th data-options="field:'createtime',width:200,formatter:dateconvertfunc">申购时间</th>
						<th data-options="field:'frozenfunds',width:200">资金冻结</th>
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
