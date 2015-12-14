<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>提货单查询</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/mgr/app/delivery/query.js" type="text/javascript"></script>
</head>
<body>
<div id="main_body">
			<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<br />
	<div class="div_list">
	<table id="tt" width="100%"></table>
	 <div id="tb" style="padding:5px;height:auto">
		<div>
			商品代码：<input type="text" id="commodityid" name="commodityid" />
			商品名称：<input type="text" id="commodityname" name="commodityname" />
			状态: 	<select id="status" name="status" style="width:80">
					<option value="">请选择</option>
					<option value="0">未配号</option>
					<option value="1">已配号</option>
					<option value="2">已摇号</option>
					<option value="3">已结算</option>
					</select>
			发售日期：<input type="text" id="starttime" name="starttime"></input> 
			截止日期：<input type="text" id="endtime" name="endtime"></input> 
			<input type="button" value="查询" onclick="doSearch()"/>				
		</div> 
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
		<!-- 编辑和过滤所使用的 通用的文本框模板 -->
		<textarea id="ecs_t_input" rows="" cols="" style="display: none">
			<input type="text" class="inputtext" value="" onblur="ECSideUtil.updateEditCell(this)" style="width: 100%;" name="" />
		</textarea>
</body>

</html>
