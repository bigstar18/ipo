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
  <title>自提打印</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
  <link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"></script>
</head>

<body>
  <div class="main">
    <div class="msg">
      您当前的位置：<span>自提打印</span>
    </div>
    <div class="warning">
      <div class="title font_orange_14b">温馨提示 :</div>
      <div class="content">1.在此展示您的所有可打印自提的提货单信息。 2.如果您要打印自提，请点击“打印自提”
      </div>
    </div>
    <table id="dg" style="height: 385px;"></table>
    <script type="text/javascript">
    $(document).ready(function() {
      $('#dg').datagrid({
    	method:"get",
        url: '<%=request.getContextPath()%>/SettlementDeliveryController/print?dealerId='+'<%=dealerId %>', //从远程站点请求数据的 URL。
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
        title: '自提打印单号', //列的标题文本。
        remoteSort: false, //定义是否从服务器排序数据。
        columns: [
          [{
            field: 'deliveryorderId',
            title: '提货单号',
            width: 100,
            align: 'center'
          }, {
            field: 'commodityId',
            title: '商品代码',
            width: 100,
            align: 'center'
          }, {
            field: 'commodityName',
            title: '商品名称',
            width: 100,
            align: 'center'
          }, {
            field: 'warehouseId',
            title: '交收仓库代码',
            width: 100,
            align: 'center'
          }, {
            field: 'warehousename',
            title: '交收仓库名称',
            width: 100,
            align: 'center'
          }, {
            field: 'position',
            title: '持仓数量',
            width: 100,
            align: 'center'
          }, {
            field: 'deliverQuatity',
            title: '交割数量',
            width: 100,
            align: 'center'
          }, {
            field: 'unit',
            title: '单位',
            width: 100,
            align: 'center'
          }, {
            field: 'applyDate',
            title: '注册日期',
            width: 100,
            align: 'center',
            formatter: function(value, row) {
              return value.substr(0, 10);
            }
          }, {
            field: 'deliveryDate',
            title: '提货日期',
            width: 100,
            align: 'center',
            formatter: function(value, row) {
              return value.substr(0, 10);
            }
          }, {
            field: 'approvalStatus',
            title: '状态',
            width: 100,
            align: 'center',
            formatter: function(value, row) {
              if (value == 1) {
                return '已申请';
              }if (value == 2) {
                return '市场通过';
              }if (value == 3) {
                return '市场驳回';
              }if (value == 4) {
                return '仓库通过';
              }if (value == 5) {
                return '仓库驳回';
              }if (value == 6) {
                return '已确认';
              }if (value == 7) {
                return '已废除';
              }if (value == 8) {
                return '已设置配置费用';
              }if (value == 9) {
                return '已出库';
              }if (value == 10) {
                return '已收货';
              }
            }
          }, {
            field: 'test',
            title: '操作',
            width: 100,
            align: 'center',
            formatter: function(value, row, index) {
              return "<a href=\"#\" onclick=\"updateForward('" + row.methodId + "')\">" + "打印自提" + "</a>";
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
    })

    function updateForward(id) {
      var iWidth = 800; //弹出窗口的宽度;
      var iHeight = 700; //弹出窗口的高度;
      var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
      var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
      window.open("${pageContext.request.contextPath}/front/app/delivery/customer_table.jsp?methodId=" + id, "打印页面", 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
    }

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
