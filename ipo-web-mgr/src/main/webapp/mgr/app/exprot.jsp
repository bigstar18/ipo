<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<html>
<head>
<title>export</title>
</head>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-tableexport/jquery.base64.js"  type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/ipo/export/ecside.js"  type="text/javascript"></script>
<body>
<div style="margin-bottom:5px" id="tb">
<a href="#" class="easyui-linkbutton" onclick="ECSideUtil.doExport('xls','stock.xls','','ec');" iconcls="icon-save" plain="true" title="导出excel文件"></a>
</div>
<table id="dg"></table>

<!--[if lt IE 9]><script>supportBase64Import = false;</script><![endif]-->
<script>
   
    $(function () {
        $('#dg').datagrid({
            singleSelect: true,
            toolbar: '#tb',
            url: 'product.json',
            fitColumns: true, pagination: true, pageSize: 3,
            title: 'easyui datagrid数据导出excel文件示例',
            width: 400,
            height: 300,
            columns: [[{ field: 'itemid', width: 80, title: 'Item ID' },
                 { field: 'productname', width: 100, editor: 'text', title: 'Product Name' },
                 { field: 'listprice', width: 80, align: 'right', title: 'List Pirce' },
                 { field: 'unitcost', width: 80, align: 'right', title: 'Unit Cost' }]],
                 toolbar:[{
                     id:'btnsave',
                             text:'导出',
                             iconCls:'icon-save',
                             handler:function(){
                                 var url = '<%=request.getContextPath()%>/ExportTestController?method=sheetsExport';
                                 window.location.href=url;
                             }
                     }]
        });
    });
</script>
</body>
</html>