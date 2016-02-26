<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
   
<html>
<head>
<title>分配方式</title>
 
  <script type="text/javascript">
  

  
  $(document).ready(function() {
    $('#dg').datagrid({
      url: "<%=request.getContextPath()%>/DistributionRuleController/getRuleInfoByPages?t="+Math.random(),//从远程站点请求数据的 URL。
      method:"post",
      loadMsg: '加载中', //当从远程站点加载数据时，显示的提示消息。
      iconCls: 'icon-ok', //它将显示一个背景图片
      fitColumns: true, //设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
      height:400,
      nowrap: true, //设置为 true，则把数据显示在一行里。设置为 true 可提高加载性能。
      singleSelect: true, //设置为 true，则只允许选中一行。
      striped: true, //设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
      pagination: true, //设置为 true，则在数据网格（datagrid）底部显示分页工具栏。
      pageNumber: 1, //当设置了 pagination 属性时，初始化页码。
      pageSize: 10, //当设置了 pagination 属性时，初始化页面尺寸。
      pageList: [5, 10, 15, 20], //当设置了 pagination 属性时，初始化页面尺寸的选择列表。
      toolbar: "#tb", //数据网格（datagrid）面板的头部工具栏。
      title: '分配设置', //列的标题文本。
      remoteSort: false, //定义是否从服务器排序数据。
      columns: [
        [{
          field: 'commodityid',
          title: '商品编号',
          width : '200',
          align: 'center',
          formatter:function(value,row){
        	  if(row.deleteFlag==0){
        	  	return "<a href='addDistributionRule.jsp?commodityid="+value+"&operationType=update'>"+value+"</a>";
        	  }else{
        		  return value;
        	  }
          }
        },{
          field: 'holdRatio',
          title: '持仓优先中签比例',
          width : '200',
          align: 'center'
        }, {
          field: 'purchaseRatio',
          title: '申购量优先中签比例',
          width : '200',
          align: 'center' 
        },{
          field: 'maxqty',
          title: '单账户最大中签量',
          width : '200',
          align: 'center'
         
        },{
          field: 'createUser',
          title: '创建人',
          width : '200',
          align: 'center' 
        },{
          field: 'createDate',
          title: '创建时间',
          width : '200',
          align: 'center',
          formatter: function(value, row, index) {
          	   if(row.createDate!='null'&&row.createDate!=null){
          		   return row.createDate.substr(0,10);
          	   }
          }
        },{
          field: 'updateUser',
          title: '修改人',
          width : '200',
          align: 'center' 
        },{
            field: 'updateDate',
            title: '修改时间',
            width : '200',
            align: 'center',
            formatter: function(value, row, index) {
           	   if(row.updateDate!='null'&&row.updateDate!=null){
           		   return row.updateDate.substr(0,10);
           	   }
           } 
          },{
              field: 'deleteFlag',
              title: '是否有效',
              width : '200',
              align: 'center',
              formatter:function(value,row){
            	  switch(value){
            	  case 0:
            		  return "有效";
            		  break;
            	  case 1:
            		  return "已被删除";
            		  break;
            	  }
              }
          },{
            field: 'oper',
            title: '操作',
            align: 'center',
            width:'100',
            formatter: function(value, row, index) {
            	  if(row.deleteFlag==0){
            		return "<a href=\"#\" onclick=\"deleteById("+row.commodityid+")\">" + "删除" + "</a>";
            	  }
            }
        }]
      ]
    });
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
      beforePageText: '第',
      afterPageText: '页    共 {pages} 页',
      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    });
  });
  
  function reset(){
	  $("#commodityId").val("");
  }


  function deleteById(id){
		
	  if(!confirm('确定删除?')){
		 return false;
	  }	; 
 	  $.ajax({  
		    url: "<%=request.getContextPath()%>/DistributionRuleController/deleteInfoByCommId",  
		    data:{"commodityid":id},  
		    type: 'POST',
		    success : function(data, stats) {  
	             if(data=="success"){
	            	 alert('删除成功');
	            	 doSearch();
	             }else if(data="fail"){
	            	 alert('删除失败');
	             }else{
	            	 alert("系统异常！");
	             }
	        },
	  	    error: function (jqXHR, textStatus, errorThrown) {
	              alert('系统异常!');
	        }
		});  
   }

  
  function doSearch(){
    	$('#dg').datagrid('load',{
    		commodityid:$('#commodityId').val()
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
		<form name="frm" action="<%=request.getContextPath()%>/BreedController/findBreedByName" method="post">
			商品编码: <input id="commodityId"  class="easyui-textbox" style="width:150px;height:20px;">&nbsp;
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" id="view" onclick="reset()">重置</a>							
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
