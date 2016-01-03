<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
   
 
<html>
<head>
<title>费用项配置</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
 
  <script type="text/javascript">
  $(document).ready(function() {
	  
	    var parentId_=$('#parentId').val();
	    var url_="<%=request.getContextPath()%>/chargeItemController/querySubLevel";
	    url_+='?parentId='+parentId_+'&t='+Math.random();
	    
	    $('#dg').datagrid({
	      url: url_, //从远程站点请求数据的 URL。
	      method:"post",
	      height:430,
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
	      title: '${param.name}', //列的标题文本。
	      remoteSort: false, //定义是否从服务器排序数据。
	      columns: [
	        [
			  {field: 'id',title: '费用编号',width: '200',align: 'center'
				    //,formatter: function(value, row, index) {
		           //   return "<a href=\"#\" onclick=\"view('"+row.id+"','"+row.name+"')\">" + row.id + "</a>&nbsp;&nbsp;";
		           // }
			  },
	          {field: 'name',title: '费用名称',width: '200',align: 'center'},
	          {field: 'parentId',title: '上级费用编号',width: '200',align: 'center'},
	          {field: 'parentName',title: '上级费用名称',width: '200',align: 'center'},
	          {field: 'typeName',title: '费用周期',width: '200',align: 'center'},
	          {field: 'remark',title: '备注',width: '300',align: 'center'},
	          {field: 'oper',title: '操作',width : 200,align: 'center',
	              formatter: function(value, row, index) {
	            	  return "<a href=\"#\" onclick=\"edit('"+row.id+"')\">" + "修改" + "</a>&nbsp;&nbsp;"+
                      "<a href=\"#\" onclick=\"deleteById('"+row.id+"')\">" + "删除" + "</a>";
	              }
	          }
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
	  		'name':$('#name').val(),
	  		'parentId':$('#parentId').val()
	  	});
	 };
	 
	 function view(id,name){
		  var url_='sub_index.jsp?id='+id+'&name='+name;
		  window.open(url_);
	 };
	 
	 function edit(id){
		  var url_='<%=request.getContextPath()%>/chargeItemController/edit?id='+id+'&t='+Math.random();
		  window.open(url_);
	 };
	 
	 
	 function deleteById(id){
		  if(!confirm('确认删除?')){
			 return false; 
		  };
		  var url_="<%=request.getContextPath()%>/chargeItemController";
		  url_+="/delete?id="+id;
		  $.ajax({  
	  		    url: url_ ,  
	  		    data:$('#dataForm').serialize(),  
	  		    type: 'POST',dataType: 'html',  
	  		    success : function(data, stats) {  
	  	             if(data=="001"){
	  	            	 alert('删除成功');
	  	            	 doSearch();
	  	             }else if(data=="002"){
	  	            	 alert('该费用下包含子费用,无法删除!');
	  	             }else{
	  	            	alert('删除失败');
	  	             }
	  	        },
		  	    error: function (jqXHR, textStatus, errorThrown) {
		              alert('系统异常!');
		        }
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
		<form name="frm"   style="line-height: 10px;">
		      <input type="hidden" id="parentId" value="${param.id}" />
			       费用名称：<input type="text" id="name" size="20"/>&nbsp;&nbsp;&nbsp;
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
