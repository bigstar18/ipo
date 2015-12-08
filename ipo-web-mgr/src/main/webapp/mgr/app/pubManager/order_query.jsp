<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>申购记录信息列表</title>


<!-- <meta name="decorator" content="default" /> -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	 $('#tt').datagrid({  
         title:'申购记录',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/QueryController/getAllOrder', //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
          
         columns : [ [ {  
             field : 'userid',  
             width : 200,  
             title : '交易商代码'  
         }, {  
             field : 'commodityid',  
             width : 200,  
             title : '商品编号'  
         }, {  
             field : 'commodityname',  
             width : 200,  
             title : '商品名称'
         },{
			field : 'counts',
			width : 200,
			title : '已申购数量'
		 },{
			field : 'createtime',
			width : 200,
			title :  '申购时间'
		 },{
			field : 'frozenfunds',
			width : 200,
			title : '资金冻结'
		 }]],  
         pagination : true 
     });  
	
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
});
    
function doSearch(){
	var userid=$("#userid").val();
	 $('#tt').datagrid({  
         title:'申购记录',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,
         singleSelect:true,
         striped:true,
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/QueryController/getOrderByUserid?userid='+ userid, //搜索  
		 loadMsg : '数据加载中......',
		 fitColumns : true,//允许表格自动缩放,以适应父容器  
		 columns : [ [ {
		 field : 'userid',
		 width : 200,
		 title : '交易商代码'
	}, {
		field : 'commodityid',
		width : 200,
		title : '商品编号'
	}, {
		field : 'commodityname',
		width : 200,
		title : '商品名称'
	}, {
		field : 'counts',
		width : 200,
		title : '已申购数量'
	}, {
		field : 'createtime',
		width : 200,
		title : '申购时间'
	}, {
		field : 'frozenfunds',
		width : 200,
		title : '资金冻结'
	} ] ],
		pagination : true
	});
		var p2 = $('#tt').datagrid('getPager');
			$(p2).pagination({
				beforePageText : '第',
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});

		}
</script>
</head>
<body>
	<div id="main_body">
		<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><br />
					<div class="div_list">
						<table id="tt"></table>
						<div id="tb" style="padding: 5px; height: auto">

							<div>
								<form name="frm"
									action="<%=request.getContextPath()%>/QueryController/commodityInfo"
									method="post">
									交易商代码: <input id="userid" name="userid" class="easyui-textbox"
										style="border: 1px solid #ccc"> <a
										href="#" class="easyui-linkbutton" iconCls="icon-search"
										id="view" onclick="doSearch()">查询</a>
								</form>
							</div>
						</div>
					</div></td>
			</tr>
		</table>
	</div>
	<!-- 编辑和过滤所使用的 通用的文本框模板 -->
	<textarea id="ecs_t_input" rows="" cols="" style="display: none">
			<input type="text" class="inputtext" value=""
			onblur="ECSideUtil.updateEditCell(this)" style="width: 100%;" name="" />
		</textarea>
</body>

</html>
