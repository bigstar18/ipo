<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>在线委托申请</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
  <link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"></script>
</head>

 <body>
<div class="main">

	<div class="msg">
	      您当前的位置：<span>在线委托申请</span>
	</div>
    <div class="warning">
      <div class="title font_orange_14b">温馨提示 :</div>
      <div class="content"> 
            1.在此展示您的可在线托管申请信息。 
			2.在进行托管的同时，请同意协议中的相关条款!!!。 
			3.以下带*的为必填项。
      </div>
    </div>
  <table id="dg"></table>
  <script type="text/javascript">
  $(document).ready(function() {
    $('#dg').datagrid({
      url: '${root}/trusteeshipCommodityController/queryPlan?t='+Math.random(), //从远程站点请求数据的 URL。
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
        [{
          field: 'id',
          title: 'id',
          hidden:true
         },{
          field: 'commodityId',
          title: '商品代码',
          width: '10%',
          align: 'center'
        }, {
          field: 'commodityName',
          title: '商品名称',
          width: '15%',
          align: 'center'
        }, {
          field: 'plan',
          title: '托管计划',
          width: '17%',
          align: 'center' 
        }, {
          field: 'counts',
          title: '发行数量',
          width: '15%',
          align: 'center' 
        },{
          field: 'price',
          title: '上市指导价',
          width: '15%',
          align: 'center'
        },{
          field: 'listingChargeRate',
          title: '挂牌费比例(%)',
          width: '15%',
          align: 'center'
        },{
          field: 'oper',
          title: '操作',
          width: '10%',
          align: 'center',
          formatter: function(value, row, index) {
              return "<a href=\"#\" onclick=\"add('"+row.id+"','"+row.commodityId+"','"+row.price+"','"+row.counts+"','"+row.listingChargeRate+"')\">" + "申请" + "</a>";
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
  
  function add(id,commodityId,price,counts,listingChargeRate){
	  var url_='${root}/trusteeshipCommodityController/addApply?id='+id+'&commodityId='+commodityId+'&price='+price+
			   '&counts='+counts+'&listingChargeRate='+listingChargeRate;
	  openCenterWindow(url_,'add_win',650,350);
  }
  
  function doSearch(){
    	$('#dg').datagrid('load',{
    		commodityId:$('#commodityId').val()
    	});
   }
  
  function openCenterWindow(url, name, width,height ) {
		var str = "height=" + height + ",innerHeight=" + height;
		str += "px,width=" + width + "px,innerWidth=" + width;
		if (window.screen) {
			var ah = screen.availHeight - 30;
			var aw = screen.availWidth - 10;
			var xc = (aw - width) / 2;
			var yc = (ah - height) / 2;
			xc = xc >= 0 ? xc : 0 ;
			yc = yc >= 0 ? yc : 0 ;
			str += ",left=" + xc + ",screenX=" + xc;
			str += ",top=" + yc + ",screenY=" + yc;
		}
	    window.open(url, name, str);
	}
  </script>
  <div id="tb" style="padding:5px;height:auto">
    <div>
      商品代码： <input type="text" id="commodityId"/>
      <a href="#" class="easyui-linkbutton" iconCls="icon-search"   onclick="doSearch()">查询</a>
    </div>
  </div>
  </div>
</body>

</html>
