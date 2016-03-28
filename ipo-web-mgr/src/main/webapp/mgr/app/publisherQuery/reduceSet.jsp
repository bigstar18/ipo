<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../ipoInclude.jsp"%>
<html>
<head>
<title>减持设置</title>
<script  type="text/javascript">
$(document).ready(function() {
	 $('#dg').datagrid({  
        title:'减持设置',  
        iconCls:'icon-ok', 
        method:"get",
        height:400,
        pageSize:10,  
        pageList:[5,10,15],  
        singleSelect:true,
        toolbar:"#tb", 
        nowrap:true,  
        striped:true,  
        collapsible:false,  
        url:  getRootPath () + "/PublisherController/reduceSetList?id="+"${id}"+"&&randnum="+Math.floor(Math.random()*1000000) ,  
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器   
        columns : [ [  {
       	 field : 'positionFlowId',  
            width : 200,  
            align: "center",
            title : '持仓单号'
           },{
       	 field : 'firmId',  
            width : 200,  
            align: "center",
            title : '交易商代码'
        }, {
       	 field : 'commodityId',  
            width : 200,  
            align: "center",
            title : '商品代码'
        } ,{
       	 field : 'reduceDate',  
            width : 200,  
            align: "center",
            title : '减持日期',
            formatter: function(value) {
            	   return value.substr(0,10);
                     } 
        } ,{
       	 field : 'ratio',  
            width : 200,  
            align: "center",
            title : '减持比例'
        } ,{
       	 field : 'reduceqty',  
            width : 200,  
            align: "center",
            title : '减持数量(批)'
        } ,{
          	 field : 'stateName',  
             width : 200,  
             align: "center",
             title : '状态'
         } ,{
           field: 'oper',
           title: '操作',
           align: 'center',
           formatter: function(value,row) {
        	   if(row.state==1){
       	         return "<a href=\"#\" onclick=\"deleteById("+row.id+")\">" + "删除" + "</a>";
        	   }  }
            }
        ]],  
        pagination : true 
    });  
	 var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    }); 
});

function returnToList(){
	document.location.href="<%=request.getContextPath()%>/mgr/app/publisherQuery/reduce.jsp";
}
function deleteById(id){
	
	  if(!confirm('确定删除?')){
		 return false;
	  }	; 
	  $.ajax({  
		    url: "<%=request.getContextPath()%>/trusteeshipCommodityController/deleteReduce",  
		    data:{"id":id},  
		    type: 'POST',dataType: 'text',  
		    success : function(data, stats) {  
	             if(data=="success"){
	            	 alert('删除成功');
	            	 $('#dg').datagrid('reload');  
	             }else{
	            	 alert('删除失败');
	             }
	        },
	  	    error: function (jqXHR, textStatus, errorThrown) {
	              alert('系统异常!');
	        }
		});  
 }
function addSet(){
	  var url_='<%=request.getContextPath()%>/PublisherController/addReduce?positionFlowId='+'${id}';
	  window.location.href=url_; 
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
				<table id="dg" width="100%"></table>
				 <div id="tb" style="padding:5px;height:auto">
					 <div>
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" id="view" onclick="addSet()">新增</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-back" id="view" onclick="returnToList()">返回</a>
					</div>
				</div>
				</div>
			</td>
		</tr>
	</table>
</div>

</body>

</html>
