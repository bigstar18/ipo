<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>配售查询</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<link href="${pageContext.request.contextPath}/front/skinstyle/default/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {

	getAllInfo();

});
//加载所有信息
function getAllInfo(){

	 $('#depositInfo').datagrid({
         title:'配售信息',
         iconCls:'icon-ok',
         method:"get",
         height:400,
         pageSize:5,
         pageList:[5,10,15],
         nowrap:true,
         singleSelect:true,
         striped:true,
         toolbar:"#tb",
         url:"<%=request.getContextPath()%>/spoRationController/selectRationInfo?randnum="+Math.floor(Math.random()*1000000), //搜索前,触发此action请求所有用户信息
        queryParams:{
        	
        },
         loadMsg:'数据加载中......',
         fitColumns:true,//允许表格自动缩放,以适应父容器
         columns : [ [ {
             field : 'commodityId',
             width : 200,
             align: "center",
             title : '商品代码'
         },{
        	 field : 'rationid',
             width : 200,
             hidden:'true',
             align: "center",
             title : 'rationid'
         },{
        	 field : 'spoCounts',
             width : 200,
             align: "center",
             title : '增发数量'
         },{
             field : 'spoPrice',
             width : 200,
             align: "center",
             title : '增发价格'
         },{
             field : 'rationcounts',
             width : 200,
             align: "center",
             title : '配售数量'
         }, {
             field : 'rationloan',
             width : 200,
             align: "center",
             title : '配售还款'
         },  {
             field : 'servicefee',
             width : 200,
             align: "center",
             title : '配售手续费'
         }, {
             field : 'registerDate',
             width : 200,
             align: "center",
             title : '登记日期',
             formatter: function(value,row){
                return value.substr(0,10);
             }
         }, {
             field : 'spoDate',
             width : 200,
             align: "center",
             title : '增发日期',
             formatter: function(value,row){
                return value.substr(0,10);
             }
         }, {
             field : 'ipoDate',
             width : 200,
             align: "center",
             title : '上市日期',
           	 formatter: function(value,row){
                     return value.substr(0,10);
           	 }
         }, {
             field : 'rationSate',
             width : 200,
             align: "center",
             title : '配售状态',
             formatter:function(value,row){
            	 switch(value)
            	 {
            	 case 1:
            	  return "未配售"
            	   break;
            	 case 2:
            	   	return "已配售"
            	   break;
            	 }
                 }
         }]],
         pagination : true
     });
	 var p = $('#depositInfo').datagrid('getPager');
	    $(p).pagination({
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页',
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });

}

//查询
function doSearch(){
	$('#depositInfo').datagrid('load',{
		commodityId: $("#commId").val(),
    	registerDateStart:$("#startdate").datebox('getValue'),
    	registerDateEnd:$("#enddate").datebox('getValue')
	});
}
function reSet(){
	$("#commId").val("");
	$("#startdate").datebox('setValue',""),
	$("#enddate").datebox('setValue',"")
	getAllInfo();
	//alert('重置');
}


//修改日期格式
function myformatter(date){
		 var y = date.getFullYear();
		 var m = date.getMonth()+1;
		 var d = date.getDate();
		 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
function myparser(s){
		 if (!s) return new Date();
		 var ss = (s.split('-'));
		 var y = parseInt(ss[0],10);
		 var m = parseInt(ss[1],10);
		 var d = parseInt(ss[2],10);
		 if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		 return new Date(y,m-1,d);
	}else{
		return new Date();
	}
 }
</script>
</head>
<body>
	<div id="main_body" class="main">
    <div class="msg">
      您当前的位置：<span>配售查询</span>
    </div>
    <div class="warning">
      <div class="title font_orange_14b">温馨提示 :</div>
      <div class="content">配售查询及详细信息显示:
      </div>
    </div>
<table class="table1_style" border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td>
			<div class="div_list">
				<table id="depositInfo">
				</table>
				<div id="tb" style="padding:5px;height:auto">
					<div>
					<form name="frm" action="" >
					商品代码: <input id="commId" name="commodityId" type="text" style="border:1px solid #ccc">
								&nbsp
								&nbsp
					查询日期: <input id="startdate" name="startdate" class="easyui-datebox" style="border:1px solid #ccc"  data-options="formatter:myformatter,parser:myparser" >
					至 <input id="enddate" name="enddate" class="easyui-datebox" style="border:1px solid #ccc" data-options="formatter:myformatter,parser:myparser">
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="reSet()">重置</a>
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