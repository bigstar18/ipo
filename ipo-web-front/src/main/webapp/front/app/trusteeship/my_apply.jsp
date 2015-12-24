<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>托管申请查询</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
  <link href="${root}/fronnt/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"></script>
</head>

  <body>
<div class="main">

<div class="msg">
      您当前的位置：<span>托管申请查询</span>
    </div>
    <div class="warning">
      <div class="title font_orange_14b">温馨提示 :</div>
      <div class="content"> 
            1.在此展示您的所有托管申请信息。 
			2.如果您要查看详情，可点击查看详情。
      </div>
    </div>
  <table id="dg"></table>
  <script type="text/javascript">
  $(document).ready(function() {
    $('#dg').datagrid({
      url: '${root}/trusteeshipCommodityController/queryMyApply?t='+Math.random(), //从远程站点请求数据的 URL。
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
          {field: 'commodityId',title: '商品代码',width: '6%',align: 'center'},
          {field: 'commodityName',title: '商品名称',width: '10%',align: 'center'},
          {field: 'createUserName',title: '交易商名称',width: '8%',align: 'center'},
          {field: 'applyAmount',title: '申请数量',width: '6%',align: 'center'},
          {field: 'instorageAmount',title: '入库数量',width: '6%',align: 'center'},
          {field: 'plan',title: '托管计划',width: '10%',align: 'center'},
          {field: 'delayCharge',title: '滞纳金',width: '7%',align: 'center'},
          {field: 'stateName',title: '状态',width: '10%',align: 'center'},
          {field: 'warehouseName',title: '仓库',width: '10%',align: 'center'},
          {field: 'createDate',title: '申请时间',width: '10%',align: 'center'},
          {field: 'auditingDate',title: '审核时间',width: '10%',align: 'center'},
      	  {field: 'oper',title: '操作',width: '8%',align: 'center',
             formatter: function(value, row, index) {
              return "<a href=\"#\" onclick=\"view("+row.id+")\">" + "查看" + "</a>&nbsp;&nbsp;"+
                     "<a href=\"#\" onclick=\"canel("+row.id+","+row.state+")\">" + "撤销" + "</a>";
                      
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
  
  function canel(id,state){
	  if(state!=1){
		  alert('请选择状态为申请的记录');
		  return false;
	  };
	  $.ajax({  
		    url: '${root}/trusteeshipCommodityController/cancelMyApply?t='+Math.random(),  
		    data:{"id":id},  
		    type: 'POST',dataType: 'json',  
		    success : function(data, stats) {  
	             if(data==true||data=="true"){
	            	 alert('撤销成功');
	            	 doSearch();
	             }else{
	            	 alert('撤销失败');
	             }
	        },
	  	    error: function (jqXHR, textStatus, errorThrown) {
	              alert('系统异常!');
	        }
		});  
  }
  function view(){
	  alert('查看');
  }
  function doSearch(){
    	$('#dg').datagrid('load',{
    		'commodityId':$('#commodityId').val(),'commodityName':$('#commodityName').val(),
    		'state':$('#state').val(),'warehouseId':$('#warehouseId').val(),
    		'beginCreateDate':$('#beginCreateDate').datebox('getValue'),'endCreateDate':$('#endCreateDate').datebox('getValue'),
    		'beginAuditingDate':$('#beginAuditingDate').datebox('getValue'),'endAuditingDate':$('#endAuditingDate').datebox('getValue')
    	});
   }
  
  
  
  
  </script>
  <div id="tb" style="padding:5px;height:auto">
    <div>
                 商品代码：<input type="text" id="commodityId" size="10"/> 商品名称：<input type="text" id="commodityName" size="20"/>
                 状态： <select style="width:100px;"   id="state">
            <option value="-1">------全部------</option>
            <c:forEach items="${stateList }" var="item">
             <option value="${item.code }">${item.name}</option>
            </c:forEach>     
          </select>
                 仓库： <select style="width:140px;" id="warehouseId">
            <option value="-1">-----------全部-----------</option>
            <option value="1">鞍山支行</option>
          </select>
                 申请日期:<input class="easyui-datebox" type="datetime" id="beginCreateDate"  style="width:100px;" >~
            <input class="easyui-datebox" type="datetime" id="endCreateDate"  style="width:100px"  >   
                 审核日期:<input class="easyui-datebox" type="datetime" id="beginAuditingDate"  style="width:100px"  >~
            <input class="easyui-datebox" type="datetime" id="endAuditingDate"  style="width:100px"  >
      <a href="#" class="easyui-linkbutton" iconCls="icon-search"   onclick="doSearch()">查询</a>
    </div>
  </div>
  </div>
</body>

</html>
