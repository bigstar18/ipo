<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
<head>

<title>商品查询</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<style type="text/css">input {line-height: 14px;}</style>
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript">
 
function parseISO8601(dateStringInRange) {
     var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s*$/,
         date = new Date(NaN), month,
         parts = isoExp.exec(dateStringInRange);
   
     if(parts) {
       month = +parts[2];
       date.setFullYear(parts[1], month - 1, parts[3]);
       if(month != date.getMonth() + 1) {
         date.setTime(NaN);
       }
     }
     return date;//new Date(str) IE8不兼容
   }
 	 
$(document).ready(function() {
	 $('#tt').datagrid({  
         title:'发售商品查询',  
         iconCls:'icon-ok', 
         method:"post",
         height:400,
         pageSize:10,  
         pageList:[5,10,15],  
         nowrap:true,  
         singleSelect:true,
         striped:true,  
         collapsible:false,  
         toolbar:"#tb",  
         url:'<%=request.getContextPath()%>/CommodityController/QueryByConditions',  
         queryParams:{
        	status: null,
     		commodityname: null,
     		commodityid: null,
     		starttime:null,
     		endtime: null
    	    },
         loadMsg:'数据加载中......',  
         fitColumns:true,//允许表格自动缩放,以适应父容器   
         remoteSort:false,  
         columns : [ [ {
        	 field : 'commodityid',  
             width : 200, 
             align: "center",
             title : '商品代码'
         }, {
        	 field : 'commodityname',  
             width : 200,  
             align: "center",
             title : '商品名称'
         }, {  
             field : 'status',  
             width : 200, 
             align: "center",
             title : '状态' ,
             formatter:function(value){
            	 if(value=='1') return "未配号";
            	 if(value=='2') return "配号完毕";
            	 if(value=='3') return "抽签完毕";
            	 if(value=='4') return "结算完毕";
            	 if(value=='31') return "抽签中";
            	 if(value=='32') return "费用计算完毕";
            	 if(value=='41') return "结算中";
           }
          }, {  
              field : 'starttime',  
              width : 200,  
              align: "center",
              title : '发售日期' ,
              formatter: function(value,row){
                  return value.substr(0,10);
          } 
           }, {  
               field : 'endtime',  
               width : 200,  
               align: "center",
               title : '截止日期' ,
               formatter: function(value,row){
                   return value.substr(0,10);
           } 
            }
         ]],  
         pagination : true 
     });  
	 var p = $('#tt').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    }); 
		      
		      $("#starttime").datebox({
		    	        editable: false,
		                formatter: function (date) {
		                    var y = date.getFullYear();
		                    var m = date.getMonth() + 1;
		                    var d = date.getDate();
		                    return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		                },
		                onSelect:function (date){
		                  var stime=parseISO8601($('#starttime').datebox('getValue'));
		   		          var etime=parseISO8601($('#endtime').datebox('getValue'));
		   		    	   if (etime < stime) {
		   		               alert('结束日期小于开始日期');
		   		               $('#starttime').datebox('setValue', '').datebox('showPanel');
		   		           } 	
		   	     	}
		            });
	                $("#endtime").datebox({
	                	editable: false,
		                formatter: function (date) {
		                    var y = date.getFullYear();
		                    var m = date.getMonth() + 1;
		                    var d = date.getDate();
		                    return y + "-" + (m < 10 ? ("0" + m) : m) + "-" + (d < 10 ? ("0" + d) : d);
		                },
		                onSelect:function (date){
		                  var stime=parseISO8601($('#starttime').datebox('getValue'));
		   		          var etime=parseISO8601($('#endtime').datebox('getValue'));
		   		    	   if (etime < stime) {
		   		               alert('结束日期小于开始日期');
		   		               $('#endtime').datebox('setValue', '').datebox('showPanel');
		   		           } 	
		   	     	}
		            });  
});

function doSearch(){
	$('#tt').datagrid('load',{
		status: $('#status').val(),
		commodityname: $('#commodityname').val(),
		commodityid: $('#commodityid').val(),
		starttime: $('#starttime').datebox('getValue'),
		endtime: $('#endtime').datebox('getValue')
	});
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
		<div>
			商品代码：<input type="text" id="commodityid" name="commodityid" />
			商品名称：<input type="text" id="commodityname" name="commodityname" />
			状态: 	<select id="status" name="status" style="width:80">
					<option value="">请选择</option>
					<option value="1">未配号</option>
					<option value="2">配号完毕</option>
					<option value="3">抽签完毕</option>
					<option value="31">抽签中</option>
					<option value="32">费用计算完毕</option>
					<option value="4">结算完毕</option>
					<option value="41">结算中</option>
					</select>
			发售日期：<input type="text" id="starttime" name="starttime"></input> 
			截止日期：<input type="text" id="endtime" name="endtime"></input> 
			<input type="button" value="查询" onclick="doSearch()"/>				
		</div> 
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
