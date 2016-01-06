<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>定向配售管理</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<link rel="stylesheet" href="../../skinstyle/default/css/common.css" type="text/css" />
<style type="text/css">
	.content span{display:block}
</style>
<script type="text/javascript">
$(document).ready(function(){
	getAllInfo();
});
//加载所有信息
function getAllInfo(){
	 $('#tt').datagrid({  
         title:'定向配售信息',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:5,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         toolbar:"#tb",  
         url:"<%=request.getContextPath()%>/SPOController/getRationInfopp?randnum="+Math.floor(Math.random()*1000000), //搜索前,触发此action请求所有用户信息  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器  
         columns : [ [ {
        	 field : 'rationid',  
             width : 200,  
             align: "center",
             hidden:"true",
             title : '配售ID',
             formatter: function(value,row){
                 return "<a herf='#'>"+value+"</a>";
       	 	 }
         },{
        	 field : 'communityId',  
             width : 200,  
             align: "center",
             title : '商品代码',
             formatter: function(value,row){
                 return "<a herf='#'>"+value+"</a>";
       	 	 }
         },{  
             field : 'registerDate',  
             width : 200,  
             align: "center",
             title : '登记日期',
             formatter: function(value,row){
            	 if(value!=null)
                 	return value.substr(0,10);
             }
         },{  
             field : 'firmid',  
             width : 200, 
             align: "center",
             title : '交易商代码'
         },{  
             field : 'salesid',  
             width : 200, 
             align: "center",
             title : '承销商代码'
         },{  
             field : 'test6',  
             width : 200, 
             align: "center",
             title : '买卖方向'
         },{  
             field : 'rationcounts',  
             width : 200, 
             align: "center",
             title : '配售数量'
         },{  
             field : 'rationloan',  
             width : 200, 
             align: "center",
             title : '配售货款'
         },{  
             field : 'servicefee',  
             width : 200, 
             align: "center",
             title : '服务费'
         },{  
             field : 'operationdate',  
             width : 200, 
             align: "center",
             title : '操作日期',
             formatter: function(value,row){
            	 if(value!=null)
                 	return value.substr(0,10);
             }
         },{  
             field : 'test17',  
             width : 200, 
             align: "center",
             title : '操作',
             formatter: function(value,row){
            	 return "<a href='#' onclick='deleteRationInfo(\""+row.rationid+"\")'>删除</a>";
       	 }
         }]],  
         pagination : true
     });  
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
	
}

function deleteRationInfo(rantionId){
	if(!sure())
		return;
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/SPOController/deleteRationInfo",
		data:{rationid:rantionId},
		success:function(data){
        	if(data=="success"){
        		alert("删除成功");
        		getAllInfo();
        	}
        	else if(data=="error")
        		alert("初始化失败，请稍后再试");
        	
         } 
	});
}

//确认消息
function sure(){
	if(window.confirm('是否确认删除配售信息？')){
        //alert("确定");
        return true;
     }else{
        //alert("取消");
        return false;
     }
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

function doSearch(){
	$('#tt').datagrid('load',{
		communityId:$("#commId").val(),
    	registerDate:$("#registerDate").datebox("getValue")
	});
}

function reSet(){
	$("#commId").val("");
	$("#registerDate").datebox("setValue","");
	getAllInfo();
}
</script>
</head>
<body>
	<div class="warning">
		<div class="content" style="height:100%">
			<span>温馨提示 :</span>
			<span>只有定向配售在此可以进行删除操作 </span>
		</div>
	</div>

	<div id="tb" style="padding:5px;height:auto">
		<form>
			<table>
				<tr>
					<td>
						商品代码：
						<input id="commId" class="easyui-textbox" style="width:150px">
					</td>
					<td>&nbsp&nbsp</td>
					<td>
						登记日期：
						<input id="registerDate" class="easyui-datebox" style="width:150px" data-options="formatter:myformatter,parser:myparser">
					</td>
					<td>&nbsp&nbsp&nbsp</td>
					<td>
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="reSet()">重置</a>
					</td>
				</tr>
			
			</table>
		</form>
	</div>
	
	<table id="tt">
	</table>
</body>
</html>