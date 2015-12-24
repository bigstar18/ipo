<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>配售查询</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {

	getAllInfo();
	  
});
//加载所有信息
function getAllInfo(){
	 $('#depositInfo').datagrid({  
         title:'增发商品信息',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:5,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:"<%=request.getContextPath()%>", //搜索前,触发此action请求所有用户信息  
        queryParams:{
    
        },
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {
           	 field : 'id',  
             width : 200,  
             align: "center",
             title : '登记日期'
         },{
        	 field : 'test2',  
             width : 200,  
             align: "center",
             title : '商品代码',
             formatter: function(value,row){
                 return "<a herf='#'>"+value+"</a>";
       	 	 }
         },{  
             field : 'test3',  
             width : 200,  
             align: "center",
             title : '增发日期'
         },{  
             field : 'test4',  
             width : 200, 
             align: "center",
             title : '上市日期'
         },{  
             field : 'test5',  
             width : 200, 
             align: "center",
             title : '数量'
         },{  
             field : 'test6',  
             width : 200, 
             align: "center",
             title : '价格'
         },{  
             field : 'test7',  
             width : 200, 
             align: "center",
             title : '配售类型'
         },{  
             field : 'test8',  
             width : 200, 
             align: "center",
             title : '未配售数量'
         },{  
             field : 'test9',  
             width : 200, 
             align: "center",
             title : '已配售数量'
         },{  
             field : 'test10',  
             width : 200, 
             align: "center",
             title : '最小配售数量'
         },{  
             field : 'test11',  
             width : 200, 
             align: "center",
             title : '最小配售比例'
         },{  
             field : 'test12',  
             width : 200, 
             align: "center",
             title : '状态'
         },{  
             field : 'test13',  
             width : 200, 
             align: "center",
             title : '是否返佣'
         },{  
             field : 'test14',  
             width : 200, 
             align: "center",
             title : '是否上市'
         },{  
             field : 'test15',  
             width : 200, 
             align: "center",
             title : '分配承销商配售比例',
             formatter: function(value,row){
                 return "<a herf='#'>分配及查询</a>";
       	 	 }
         },{  
             field : 'test16',  
             width : 200, 
             align: "center",
             title : '预配售',
             formatter: function(value,row){
                 return "<a herf='#'>---</a>";
       	 	 }
         },{  
             field : 'test17',  
             width : 200, 
             align: "center",
             title : '操作',
             formatter: function(value,row){
            	 return "<a herf='#'>增发成功</a><a herf='#'>增发失败</a>";
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
	getAllInfo();
}
function reSet(){
	$("#commId").val("");
	$("#startdate").datebox('setValue',""),
	$("#enddate").datebox('setValue',"")
	getAllInfo();
}


function OpenFrame() {
	$('#dd').empty();
    $('#dd').append("<iframe style='width:100%;height:100%' src='../SPO/addspoComm.jsp'></iframe>");
    $('#dd').window('open');
}

</script>
</head>
<body>
 

<div id="dd" title="增发商品添加"  class="easyui-window"  closed="true" style="width:800px;height:600px;padding:5px;">
</div> 

<div id="main_body">
<table class="table1_style" border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td>		
		<br />
			<div class="div_list">
				<table id="depositInfo">
				</table>
				<div id="tb" style="padding:5px;height:auto">
					<div>
					<form name="frm" action="" >
						<table>
							<tr>
								<td>
									商品代码: <input id="commId" name="communityId" class="easyui-textbox" style="border:1px solid #ccc">
											&nbsp
											&nbsp
									配售类型: <select style="width:150px">
												<option>全部</option>
											</select>
											&nbsp
											&nbsp
									增发状态：<select style="width:150px">
												<option>全部</option>
											</select>
											&nbsp
											&nbsp
										<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
											&nbsp
											&nbsp
											&nbsp
											&nbsp
										<a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="OpenFrame()">添加</a>		
								</td>
							</tr>
							<tr>
								<td>
										登记日期: <input id="commId" name="communityId" class="esayui-datebox" style="border:1px solid #ccc">
										&nbsp
										&nbsp
										查询日期: <input id="startdate" name="startdate" class="easyui-datebox" style="border:1px solid #ccc" >
										&nbsp
										&nbsp
										上市日期：<input id="enddate" name="enddate" class="easyui-datebox" style="border:1px solid #ccc" >
											&nbsp
											&nbsp
											<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="reSet()">重置</a>		
								</td>
							</tr>
						
						</table>
							
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