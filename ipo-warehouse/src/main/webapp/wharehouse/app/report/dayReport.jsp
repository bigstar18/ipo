<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/wharehouse/public/includefiles/allincludefiles.jsp"%>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
		<title>仓库每日运费统计表</title>
		</script>
		<style type="text/css">
		</style>
</head>
<body topmargin="0" style="width:100%">
			<div style="width:600px; margin:0 auto;height:300px">
			<form id="frm" name="frm" method="POST"  >
			<fieldset>
				<legend class="common"><b>库每日运费统计表</b></legend>
				<span id="baseinfo9" style="height:250px;display:block">
					<table align="center">
					&nbsp
						&nbsp
						<tr>
							<td>查询日期：<input id="name" name="userid" class="easyui-datebox" style="border:1px solid #ccc;height:18px;width:160px;" onkeydown='if(event.keyCode==13) return false;'></td>
						</tr>
						<tr>
						
						</tr>
						<tr>
						
							<td align="center">
							<input type="button" value="提交" onclick="" class="anniu_btn"/>
							&nbsp						
							<input type="button" value="保存为Excel" onclick="" class="anniu_btn"/>
							</td>
						</tr>
					</table>
				</span>
			</fieldset>
			</form>
			</div>
</body>
</html>
