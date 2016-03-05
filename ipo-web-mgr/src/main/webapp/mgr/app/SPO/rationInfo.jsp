<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>增发商品管理</title>
<style type="text/css">
#tb td{font-size:12px}
</style>

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
         pageSize:10,
         pageList:[5,10,15],
         nowrap:true,
         singleSelect:true,
         striped:true,
         fitColumns:true,
         toolbar:"#tb",
         url:"<%=request.getContextPath()%>/SPOController/getAllSPOInfo?randnum="+Math.floor(Math.random()*1000000), //搜索前,触发此action请求所有用户信息
         loadMsg:'数据加载中......',
         fitColumns:true,//允许表格自动缩放,以适应父容器
         columns : [ [ {
        	 field : 'spoId',
             width : 200,
             hidden:'true',
             align: "center",
             title : 'spoId'
         },{
        	 field : 'commodityId',
             width : 200,
             align: "center",
             title : '商品代码',
             formatter: function(value,row){
            	 switch(row.spoSate){
            	 case 4:
            		 return "<a href='#' onclick='OpenFrame(\""+row.spoId+"\")'>"+value+"</a>";
            		 break;
            	 default:
            		 return value;
            	 }
       	 	 }
         },{
           	 field : 'registerDate',
             width : 200,
             align: "center",
             title : '登记日期',
             formatter: function(value,row){
            	 if(value!=null){
                 	return value.substr(0,10);
            	 }
             }
         },{
             field : 'spoDate',
             width : 200,
             align: "center",
             title : '增发日期',
             formatter: function(value,row){
            	 if(value!=null){
                  	return value.substr(0,10);
             	 }
             }
         },{
             field : 'ipoDate',
             width : 200,
             align: "center",
             title : '上市日期',
             formatter: function(value,row){
            	 if(value!=null){
                  	return value.substr(0,10);
             	 }
             }
         },{
             field : 'spoCounts',
             width : 200,
             align: "center",
             title : '数量'
         },{
             field : 'spoPrice',
             width : 200,
             align: "center",
             title : '价格'
         },{
             field : 'rationType',
             width : 200,
             align: "center",
             title : '配售类型',
             formatter:function(value,row){
            	 switch(value){
            	 case "1":
            		 return "比例配售";
            		 break;
            	 case "2":
            		 return "定向配售";
            		 break;
            	 }
             }
         },{
             field : 'notRationCounts',
             width : 200,
             align: "center",
             title : '未配售数量'
         },{
             field : 'successRationCounts',
             width : 200,
             align: "center",
             title : '已配售数量'
         },{
             field : 'minRationCounts',
             width : 200,
             align: "center",
             title : '最小配售数量'
         },{
             field : 'minRationProportion',
             width : 200,
             align: "center",
             title : '最小配售比例'
         },{
             field : 'spoSate',
             width : 200,
             align: "center",
             title : '状态',
             formatter: function(value,row){
            	 switch(value){
            	 case 1:
            		 return "未增发";
            		 break;
            	 case 2:
            		 return "增发成功";
            		 break;
            	 case 3:
            		 return "增发失败";
            		 break;
            	 case 4:
            		 return "未增发";
            		 break;
            	 case 5:
            		 return "未增发";
            		 break;
            	 }
       	 	 }
         },{
             field : 'rebate',
             width : 200,
             align: "center",
             title : '是否返佣',
             formatter: function(value,row){
            	 switch(value){
            	 case 1:
            		 return "已返佣";
            		 break;
            	 case 2:
            		 return "未返佣";
            		 break;
            	 }
       	 	 }
         },{
             field : 'beListed',
             width : 200,
             align: "center",
             title : '是否上市',
             formatter: function(value,row){
            	 switch(value){
            	 case 1:
            		 return "已上市";
            		 break;
            	 case 2:
            		 return "未上市";
            		 break;
            	 }
       	 	 }
         },{
             field : 'test15',
             width : 200,
             align: "center",
             title : '分配承销商配售比例',
             formatter: function(value,row,index){
                 return "<a href='#' onclick='ration(\""+row.spoId+"\",\""+row.spoSate+"\",\""+row.rationType+"\","+index+")'>分配及查询</a>";
       	 	 }
         },{
             field : 'prePlacement',
             width : 200,
             align: "center",
             title : '预配售',
             formatter: function(value,row){
                 return "<a herf='#'>---</a>";
       	 	 }
         },{
             field : 'test17',
             width :400,
             align: "center",
             title : '操作',
             formatter: function(value,row){
            	 var s = "<a href='#' onclick='orderBalance(\""+row.spoId+"\")'>配售</a>";
            	 switch(row.spoSate){
            	 case 1:
            		 return "<a href='#' onclick='updateSPOSate("+row.spoId+",\"2\")'>增发成功</a>  <a href='#' onclick='updateSPOSate("+row.spoId+",\"3\")'>增发失败</a>"+' '+ s;
            		 break;
            	 case 2:
            		 return "----";
            		 break;
            	 case 3:
            		 return "----";
            		 break;
            	 case 4:
            		 return "<a href='#' onclick='deleteSPOInfo(\""+row.spoId+"\")'>删除</a>";
            		 break;
            	 case 5:
            		 return "<a href='#' onclick='updateSPOSate("+row.spoId+",\"2\")'>增发成功</a>  <a href='#' onclick='updateSPOSate("+row.spoId+",\"3\")'>增发失败</a>"+' '+ s;
            		 
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
//修改增发状态
function updateSPOSate(spoid,spoSate){
	if(!sure("是否确认更改增发状态？"))
		return;
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/SPOController/updateSPOSate",
		data:{
		  spoId:spoid,
		  rationSate:spoSate
		},
		success:function(data){
        	if(data=="success"){
        		alert("修改成功！");
        		getAllInfo();
        		$('#depositInfo').datagrid('reload');
        	}
        	else if(data=="error")
        		alert("修改失败，请稍后再试");
         }
	});
}


function doSearch(){
	$('#depositInfo').datagrid('load',{
		commodityId:$("#commIdp").val(),
		registerDate:$("#registerDate").datebox("getValue"),
		spoDate:$("#spoDate").datebox("getValue"),
		ipoDate:$("#ipoDate").datebox("getValue"),
		rationType:$("#rationTypep").val(),
		spoSate:$("#rationSatep").val()
	});
}
//查询
// function doSearch(){
// 	getAllInfo();
// }
function reSet(){
	$("#commIdp").val("");
	$("#rationTypep ").get(0).selectedIndex=0;
	$("#rationSatep ").get(0).selectedIndex=0;
	$("#registerDate").datebox('setValue',"");
	$("#spoDate").datebox('setValue',"");
	$("#ipoDate").datebox('setValue',"");
}


function deleteSPOInfo(spoId){
	if(!sure("是否确认删除增发商品信息？"))
		return;
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/SPOController/deleteSPOInfo",
		data:{spoId:spoId},
		success:function(data){
        	if(data=="success"){
        		alert("删除成功");
        		getAllInfo();
        	}
        	else if(data=="error")
        		alert("删除失败，请稍后再试");
         }
	});
}
//确认消息
function sure(message){
	if(window.confirm(message)){
        //alert("确定");
        return true;
     }else{
        //alert("取消");
        return false;
     }
}


//弹窗
function OpenFrame(spoId) {
	$('#dd').empty();
	$("#hidSpoId").val("");
	$("#hidSpoId").val(spoId);
    $('#dd').append("<iframe style='width:100%;height:100%' src='../SPO/addspoComm.jsp'></iframe>");
    $('#dd').window('open');
}

function ration(spoId,spoSate,rationType,index) {
	var bool = date(index);
	$("#hidSpoId").val("");
	$("#hidSpoId").val(spoId);
	$("#spoType").val("");
	$("#spoType").val(spoSate);
	$("#hidrationType").val("");
	$("#hidrationType").val(rationType);
	$("#hidipodate").val("");
	$("#hidipodate").val(bool);
	$('#dd').empty();
    $('#dd').append("<iframe style='width:100%;height:100%' src='../SPO/distributionAndSelect.jsp'></iframe>");
    $('#dd').window('open');
}

function date(index){
	$('#depositInfo').datagrid('selectRow',index);
	var row = $("#depositInfo").datagrid("getSelected");
	var ipoDate = row.ipoDate.substr(0,10);
	
	var nowDate = new Date();
	var year = nowDate.getFullYear();
	var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1) : nowDate.getMonth() + 1;
	var day = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate.getDate();
	var time1 = year + "" + month + "" + day;
	
	var time2 = ipoDate.replace(/\-/g, "");
	if(time1 <= time2){
		return false;
	}else{
		return true;
	}
}
function orderBalance(spoid){
	if(!sure("是否确认配售？"))
		return;
	$.ajax({
		type:"get",
		url:"<%=request.getContextPath()%>/SPOController/orderBalance",
		success:function(data){
        	if(data=="success"){
        		alert("配售成功！");
        	}
        	else if(data=="error")
        		alert("配售失败 ");
         }
	});
}





</script>
</head>
<body>

 <input type="hidden" id="spoType" value=""/>
 <input type="hidden" id="hidSpoId" value=""/>
 <input type="hidden" id="hidrationType" value=""/>
 <input type="hidden" id="hidipodate" value=""/>
<div id="dd" title="增发商品添加"  class="easyui-window"  closed="true" style="width:800%;height:600%;padding:5px;">
</div>

<div id="dd1" title="分配及查询"  class="easyui-window"  closed="true" style="width:800%;height:750%;padding:5px;">
</div>



<div id="main_body">
<div id="tb" style="padding:5px;height:auto">
	<form name="frm" action="" >
		<table>
			<tr>
				<td>
					商品代码: <input id="commIdp" name="commodityId" class="easyui-textbox" style="border:1px solid #ccc;height:20px;width:145px">
							&nbsp
							&nbsp
					配售类型: <select id="rationTypep" style="width:150px">
								<option value="">全部</option>
								<option value="1">比例配售</option>
								<option value="2">定向配售</option>
							</select>
							&nbsp
							&nbsp
					增发状态：<select id="rationSatep" style="width:150px">
								<option value="">全部</option>
								<option value="5">未增发</option>
								<option value="4">未到增发日期</option>
								<option value="2">增发成功</option>
								<option value="3">增发失败</option>
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

						登记日期: <input id="registerDate" class="easyui-datebox" style="width:146px" editable="false" data-options="formatter:myformatter,parser:myparser">
						&nbsp
						&nbsp
						增发日期: <input id="spoDate" class="easyui-datebox" style="width:149px" editable="false" data-options="formatter:myformatter,parser:myparser">
						&nbsp
						&nbsp
						上市日期：<input id="ipoDate" class="easyui-datebox" style="width:150px" editable="false" data-options="formatter:myformatter,parser:myparser">
							&nbsp
							&nbsp
							<a href="#" class="easyui-linkbutton" iconCls="icon-reload" id="view" onclick="reSet()">重置</a>
				</td>
			</tr>

		</table>

	</form>
</div>
<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <br />
				<table id="depositInfo">
				</table>
            </td>
        </tr>
</table>


</div>
</body>
</html>