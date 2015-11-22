<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>


<title>申购记录信息列表</title>

<meta name="decorator" content="default" />
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js" type="text/javascript"></script>

</head>
<body>
	<div class="main">

		<div class="col-xs-12">
			<br>
			<div id="myTabContent" class="tab-content">
				<table id="mytb" class="easyui-datagrid" title="申购记录查询" style="width: 100%; height: 385px" data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/QueryController/getAllOrder',method:'get'" toolbar="#tb">
					<thead>
						<tr>
							<th data-options="field:'userid',width:200">交易商代码</th>
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
		<!-- <div id="tb" style="padding:3px">
			<span>商品代码:</span>
			<input id="commodityid" style="line-height:26px;border:1px solid #ccc">
			<span>交易商代码:</span>
			<input id="userid" style="line-height:26px;border:1px solid #ccc">
			<a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
			</div> -->

		<script type="text/javascript">
			$ (document).ready (function ()
            {
	            var p = $ ('#mytb').datagrid ('getPager');
	            $ (p).pagination (
	            {
	                pageSize : 10,
	                pageList : [
	                        5, 10, 15
	                ],
	                beforePageText : '第',
	                afterPageText : '页    共 {pages} 页',
	                displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	            });
            });
            
            //日期转换
            function dateconvertfunc (value, row)
            {
	            return value.substr (0, 10);
            }

            function doSearch ()
            {
	            $ ('#mytb').datagrid ('load',
	            {
	                commodityid : $ ('#itemid').val (),
	                userid : $ ('#userid').val ()
	            });
            }
		</script>
	</div>
</body>
</html>
