<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>承销设置</title>

<script type="text/javascript">
$(document).ready(function(){
	 $('#dg').datagrid({
		 title:'承销信息',
	      iconCls:'icon-ok',
	       method:"POST",
	       height:400,
	      pageSize:10,
	      pageList:[5,10,15],
	      nowrap:true,
	      striped:true,
	      toolbar:"#tb",
	      singleSelect:true,
	      striped:true,
 	      url:'<%=request.getContextPath()%>/UnderwriterSetController/findUnderwriterSet', //搜索前,触发此action请求所有用户信息
	      fitColumns:true,//允许表格自动缩放,以适应父容器
	      loadMsg:'数据加载中......',
	      columns:[[{
	     	 field:'ck',
	     	 checkbox:true
	      },{
	          field : 'underwriterid',
	          width : 800,
	          align: "center",
	          title : '承销会员编号'
	      },{
	          field : 'commodityid',
	          width : 800,
	          align: "center",
	          title : '商品代码'
	      }, {
	          field : 'subscribecounts',
	          width : 800,
	          align: "center",
	          title : '认购数量'
	      }, {
	          field : 'proportion',
	          width : 800,
	          align: "center",
	          title : '占承销会员手续费总和的比例（%）'
	      } , {
	          field : 'subscribeid',
	          width : 800,
	          align: "center",
	          title : '操作',
	          formatter:function(value,row){
	        	  return "<input type=\"button\" onclick=\"withhold('"+row.subscribeid+"','"+row.underwriterid+"')\" value=\"暂扣押金\"/>";
		      }
	      } ]],
	      pagination : true,
	      singleSelect: false,
	      selectOnCheck: true,
	      checkOnSelect: true
	  });
		 var p = $('#dg').datagrid('getPager');
		    $(p).pagination({
		        beforePageText: '第',
		        afterPageText: '页    共 {pages} 页',
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		    });
});

//删除
function deleteList(){
	var checkedItems = $('#dg').datagrid('getChecked');
	var ids = [];
	$.each(checkedItems,function(index,item){
		ids.push(item.subscribeid);
	});
	var id = ids.join(",");
	if(id.length != 0){
		if(confirm("确定删除所选记录？")){
			  var row = $("#dg").datagrid("getSelected");
			  $.post("<%=request.getContextPath()%>/UnderwriterSetController/deleteInfo",{"ids":id},function(data,status){
				  if(data=='true'){
					  alert("删除成功！")
					  $('#dg').datagrid('reload');
				  }
				  if(data=='false'){
					  alert("删除失败")
				  }
					  });
			  }
	}else{
		alert("至少选择一条记录再进行删除！");
	}
}
function withhold(id,underwriterId){
	document.location.href = '<%=request.getContextPath()%>/UnderwriterSetController/withhold?subscribeid='+id+'&&underwriterId='+underwriterId+'&&randnum='+Math.floor(Math.random()*1000000);

}

function addInfo(){
	document.location.href = '<%=request.getContextPath()%>/UnderwriterSetController/addInfo?&&randnum='+Math.floor(Math.random()*1000000);

}

function doSearch(){
$('#dg').datagrid('load',{
	commodityid: $('#commodityid').val(),
	underwriterid: $('#underwriterid').val()
});
}

function clearInfo(){
$("#commodityid").val("");
$("#underwriterid").val("");
}
</script>
</head>
<body>
<div id="main_body">
<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<br />
				<div class="div_list">
				<table id="dg" width="100%"></table>
				 <div id="tb" style="padding:5px;height:auto">
					<div>
					   <a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="addInfo()">添加</a>
					   <a href="#" class="easyui-linkbutton" iconCls="icon-remove" id="view" onclick="deleteList()">删除</a><br/>
						商品代码：<input type="text" id="commodityid" name="commodityid" />
						承销会员编码：<input type="text" id="underwriterid" name="underwriterid"></input>
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="clearInfo()">重置</a>
					</div>
				</div>
				</div>
				</td>
		</tr>
	</table>
</div>
</body>
</html>
