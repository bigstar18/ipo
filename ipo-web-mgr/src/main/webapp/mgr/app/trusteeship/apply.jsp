<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
   
 
<html>
<head>
<title>托管申请管理</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
 
  <script type="text/javascript">
  $(document).ready(function() {
	    $('#dg').datagrid({
	      url: '<%=request.getContextPath()%>/trusteeshipCommodityController/queryApply?t='+Math.random(), //从远程站点请求数据的 URL。
	      method:"post",
	      loadMsg: '加载中', //当从远程站点加载数据时，显示的提示消息。
	      iconCls: 'icon-ok', //它将显示一个背景图片
	      fitColumns: true, //设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
	      nowrap: true, //设置为 true，则把数据显示在一行里。设置为 true 可提高加载性能。
	      singleSelect: true, //设置为 true，则只允许选中一行。
	      striped: true, //设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
	      pagination: true, //设置为 true，则在数据网格（datagrid）底部显示分页工具栏。
	      pageNumber: 1, //当设置了 pagination 属性时，初始化页码。
	      pageSize: 10, //当设置了 pagination 属性时，初始化页面尺寸。
	      pageList: [5, 10, 15, 20], //当设置了 pagination 属性时，初始化页面尺寸的选择列表。
	      toolbar: "#tb", //数据网格（datagrid）面板的头部工具栏。
	      title: '商品信息', //列的标题文本。
	      remoteSort: false, //定义是否从服务器排序数据。
	      columns: [
	        [
			  {field: 'id',title: 'id',hidden:true},
	          {field: 'commodityId',title: '商品代码',width: '80',align: 'center'},
	          {field: 'commodityName',title: '商品名称',width: '100',align: 'center'},
	          {field: 'createUser',title: '交易商代码',width: '90',align: 'center'},
	          {field: 'createUserName',title: '交易商名称',width: '100',align: 'center'},
	          {field: 'createUserMobile',title: '联系电话',width: '80',align: 'center'},
	          {field: 'applyAmount',title: '申请数量',width: '80',align: 'center'},
	          {field: 'instorageAmount',title: '入库数量',width: '80',align: 'center'},
	          {field: 'effectiveAmount',title: '供申购数量',width: '100',align: 'center'},
	          {field: 'positionAmount',title: '持仓数量',width: '80',align: 'center'},
	          {field: 'plan',title: '托管计划',width: '140',align: 'center'},
	          {field: 'stateName',title: '状态',width: '100',align: 'center'},
	          {field: 'publishCharge',title: '发行手续费',width: '80',align: 'center'},
	          {field: 'warehouseName',title: '仓库',width: '100',align: 'center'},
	          {field: 'createDate',title: '申请时间',width: '90',align: 'center'},
	          {field: 'auditingDate',title: '审核时间',align: 'center'}
	       ]
	      ]
	    });
	    var p = $('#dg').datagrid('getPager');
	    $(p).pagination({
	      beforePageText: '第',
	      afterPageText: '页    共 {pages} 页',
	      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
	  });
  
	  function doSearch(){
	  	$('#dg').datagrid('load',{
	  		'commodityId':$('#commodityId').val(),'commodityName':$('#commodityName').val(),
	  		'createUser':$('#createUser').val(),
	  		'state':$('#state').val(),'warehouseId':$('#warehouseId').val(),
	  		'beginCreateDate':$('#beginCreateDate').datebox('getValue'),'endCreateDate':$('#endCreateDate').datebox('getValue'),
	  		'beginAuditingDate':$('#beginAuditingDate').datebox('getValue'),'endAuditingDate':$('#endAuditingDate').datebox('getValue')
	  	});
	 };
	 
	 
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
		<form name="frm"  >
			      商品代码：<input type="text" id="commodityId" size="10"/> 
			      商品名称：<input type="text" id="commodityName" size="15"/>
			      交易商代码：<input type="text" id="createUser" size="10"/> 
		                 状态： <select style="width:100px;"   id="state">
		            <option value="-1">------全部------</option>
		            <c:forEach items="${stateList }" var="item">
		             <option value="${item.code }">${item.name}</option>
		            </c:forEach>     
		          </select>
		                 仓库： <select style="width:140px;" id="warehouseId">
		            <option value="-1">-----------全部-----------</option>
		            <c:forEach items="${warehouseList }" var="item">
		             <option value="${item.id }">${item.warehousename}</option>
		            </c:forEach>   
		          </select>
		                 申请日期:<input class="easyui-datebox" type="datetime" id="beginCreateDate"  style="width:100px;" >~
		            <input class="easyui-datebox" type="datetime" id="endCreateDate"  style="width:100px"  >   
		                 审核日期:<input class="easyui-datebox" type="datetime" id="beginAuditingDate"  style="width:100px"  >~
		            <input class="easyui-datebox" type="datetime" id="endAuditingDate"  style="width:100px"  >
		      <a href="#" class="easyui-linkbutton" iconCls="icon-search"   onclick="doSearch()">查询</a>					
		</form> 
		</div>
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
