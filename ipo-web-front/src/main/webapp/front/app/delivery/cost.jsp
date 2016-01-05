<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>
<%@page import="java.lang.String"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%String dealerId =((UserManageVO)session.getAttribute("CurrentUser")).getUserID();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>费用查询</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
  <link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body>
  <div class="main">
    <div class="msg">
      您当前的位置：<span>费用查询</span>
    </div>
    <div class="warning">
      <div class="title font_orange_14b">温馨提示 :</div>
      <div class="content">提货单费用查询:
      </div>
    </div>
    <table id="dg" style="height: 385px;"></table>
    <script type="text/javascript">
    $(document).ready(function() {
      $('#dg').datagrid({
        method:"get",
        url: '<%=request.getContextPath()%>/SettlementDeliveryController/costQuery?dealerId='+'<%=dealerId %>', //从远程站点请求数据的 URL。
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
        title: '费用信息查询', //列的标题文本。
        remoteSort: false, //定义是否从服务器排序数据。
        columns: [
          [{
            field: 'deliveryId',
            title: '提货单号',
            width: 130,
            align: 'center'
          }, {
            field: 'deliveryMethod',
            title: '提货方式',
            width: 130,
            align: 'center'
          }, {
            field: 'applyDate',
            title: '申请日期',
            width: 130,
            align: 'center',
            formatter: function(value, row) {
              if (value == null) {
                return value;
              }else{
                return value.substr(0, 10);
              }
            }
          }, {
            field: 'deliveryDate',
            title: '提货日期',
            width: 130,
            align: 'center',
            formatter: function(value, row) {
              if (value == null) {
                return value;
              }else{
                return value.substr(0, 10);
              }
            }
          }, {
            field: 'insurance',
            title: '保险费',
            width: 130,
            align: 'center'
          }, {
            field: 'trusteeFee',
            title: '托管费',
            width: 130,
            align: 'center'
          }, {
            field: 'warehousingFee',
            title: '仓储费',
            width: 130,
            align: 'center'
          }, {
            field: 'deliverFee',
            title: '提货单费用',
            width: 130,
            align: 'center'
          }]
        ]
      });
      var p = $('#dg').datagrid('getPager');
      $(p).pagination({
        beforePageText: '第',
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
      });
    })

    function doSearch(){
      	$('#dg').datagrid('load',{
      	deliveryorderId:$('#deliveryorderId').val()
      	});
      }
    </script>
  <div id="tb" style="padding:5px;height:auto">
    <div>
      提货单号：
      <input type="text" id="deliveryorderId"/>
      <input type="button" value="查询" onclick="doSearch()" />
    </div>
  </div>
  </div>
</body>

</html>