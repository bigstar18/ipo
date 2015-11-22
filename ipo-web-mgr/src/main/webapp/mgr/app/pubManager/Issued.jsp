<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>


<title>发行摇号</title>

<meta name="decorator" content="default" />
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css">
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="main">

		<div class="col-xs-12">
			<br>

			<div id="myTabContent" class="tab-content">
				<table id="mytb" border="1" class="easyui-datagrid" title="发行摇号" style="width: 100%; height: 385px" data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/QueryController/findRockNums',method:'get'" toolbar="#tb">
					<thead>
						<tr>
							<th data-options="field:'commodityid',width:200">商品代码</th>
							<th data-options="field:'starttime',width:200,formatter:dateconvertfunc">发行开始日期</th>
							<th data-options="field:'endtime',width:200,formatter:dateconvertfunc">发行截至日期</th>
							<th data-options="field:'counts',width:200">网上发行数量</th>
							<th data-options="field:'ccounts',width:200">申购数量</th>
							<th data-options="field:'operating',width:200,formatter:rocknum">开始摇号</th>
						</tr>
					</thead>
				</table>
				<!-- <div id="tb" style="padding:3px">
			<span>商品代码:</span>
			<input id="itemid" name = "itemid"style="line-height:26px;border:1px solid #ccc">
			<a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
			<a href="javascript:reset()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">重置</a>
			</div>
			</div>
		</div> -->



				<script type="text/javascript">
$(document).ready(function() {
	 var p = $('#mytb').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    });  
});

//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
}

function rocknum(value,row){
	if(row.status == 2){
		
		return '<a href="javascript:constructionManager(\'' + row.commodityid+ '\')" >执行摇号</a>';
	}else{
		return '已成交';
		//return '<a href="javascript:constructionManager(\'' + row.commodityid+ '\')" >执行摇号</a>';
	}
}

function constructionManager(commodityid){
	 $.ajax({  
		    type: 'get',  
		    url: "<%=request.getContextPath()%>/QueryController/rock",  
		    contentType: "application/json; charset=utf-8", 
		    data:{"commodityid":commodityid},
		    dataType: 'json',  
		    async: true,  
		    success : function(data, stats) { 
		    	if(data == "1"){
	            alert('摇号结束');
		    	}
	        }
		});  
}

function doSearch(){
	//$('#mytb').datagrid('load',{
	//	commodityid : $('#itemid').val()
	//});
	var itemid = $('#itemid').val();
	$.ajax({  
	    type: 'GET',  
	    url: "<%=request.getContextPath()%>/QueryController/commodityInfo",
	                        contentType : "application/json; charset=utf-8",
	                        data :
	                        {
		                        commodityid : itemid
	                        },
	                        dataType : 'json',
	                        async : true,
	                        success : function (data, stats)
	                        {
		                        alert ("hehe");
	                        },
	                        error : function (data)
	                        {
		                        alert (data);
		                        console.log (data);
	                        }
	                    });
                    }

                    function reset ()
                    {
	                    itemid.reset ();
                    }
				</script>
			</div>
</body>
</html>
