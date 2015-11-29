<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>商品管理列表</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript">
 
$(document).ready(function() {
	 $('#tt').datagrid({  
         title:'商品列表',  
         iconCls:'icon-ok', 
         method:"get",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         collapsible:false,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/BreedController/findCommsByBreedId?breedid=<%=request.getAttribute("breedID") %>',  
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         remoteSort:false,  
         columns : [ [ {  
             field : 'commodityname',  
             width : 200,  
             align: "center",
             title : '商品名称',
             formatter:function(value,row){
          	    return "<a href=\"#\" onclick=\"updateCommodity("+row.commodityid+","+row.breedid+")\">"+value+"</a>";
          }
         }, {  
             field : 'commodityid',  
             width : 200, 
             align: "center",
             title : '商品代码'  
         }, {  
             field : 'currstatus',  
             width : 200,  
             align: "center",
             title : '状态' ,
             formatter:function(value){
            	 if(value=='0') return "有效";
            	 if(value=='1') return "暂停交易";
           }
          }, {  
              field : 'listingdate',  
              width : 200,  
              align: "center",
              title : '上市日期' ,
              formatter: function(value,row){
                  return value.substr(0,10);
          } 
           }, {  
               field : 'lasttradate',  
               width : 200,  
               align: "center",
               title : '交收日期' ,
               formatter: function(value,row){
                   return value.substr(0,10);
           } 
            }
         ]],  
         pagination : true,  
     });  
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
});
    
    
//跳转到添加商品页面
function addCommodity(){
	document.location.href = "<%=request.getContextPath()%>/IpoController/addCommodity?breedid=<%=request.getAttribute("breedID") %>";
}

<%-- //删除商品
function deleteCommodity(){
	if(confirm("确定删除该商品吗？")){
	  var row = $("#tt").datagrid("getSelected"); 
	  $.post("<%=request.getContextPath()%>/BreedController/deleteCommodity",{"commodityid":row.commodityid},function(data,status){
		  if(data=='success'){
			  alert("删除成功！")
			  $('#tt').datagrid('reload');
		  }
			  });
	  }
} --%>

//修改商品配置信息，跳转到修改页面
function updateCommodity(comid,breedid){
	var Url = "<%=request.getContextPath()%>/IpoController/updateCommodity?commodityid="+comid+"&&breedid="+breedid;
	document.location.href = Url;
}

//返回品种列表
function returnBreedList(){
	var backUrl="<%=request.getContextPath()%>/IpoController/CommodityManage";
	document.location.href = backUrl;
}


</script>
</head>
<body>
<div id="main_body">
			<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<br />
	<div class="div_list">
	<table id="tt" width="100%"></table>
		<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCommodity();" id="add">添加商品</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="returnBreedList();" id="delete">返回品种</a>
		</div>
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
		<!-- 编辑和过滤所使用的 通用的文本框模板 -->
		<textarea id="ecs_t_input" rows="" cols="" style="display: none">
			<input type="text" class="inputtext" value="" onblur="ECSideUtil.updateEditCell(this)" style="width: 100%;" name="" />
		</textarea>
</body>

</html>
