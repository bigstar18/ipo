<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>分配增发商品及查询</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<link rel="stylesheet" href="../../skinstyle/default/css/common.css" type="text/css" />
<script src="<%=request.getContextPath()%>/mgr/public/js/json2.js" type="text/javascript"></script>
<style type="text/css">
	.content span{font-size:12px}
</style>
<script type="text/javascript">
var pintegral =  /^[0-9]*[1-9][0-9]*$/;
var zeroToHundred = /^(\d{1,2}(\.{1}\d+)?|100)$/;
var editRow = undefined;
$(document).ready(function(){

	 $('#tt').datagrid({  
        title:'分配增发商品及查询',  
        iconCls:'icon-ok', 
        method:"get",
        height:400,
        pageSize:5,  
        pageList:[5,10,15],  
        nowrap:true,
        singleSelect:true,
        striped:true,  
        url:"<%=request.getContextPath()%>/SPOController/getUnderwriterInfo?randnum="+Math.floor(Math.random()*1000000), //搜索前,触发此action请求所有用户信息 
        queryParams:{spoId:parent.$("#hidSpoId").val()},
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器  
        columns : [ [ {  
        	 fiele:'checked',
	     	 checkbox:true  
        },{
          	 field : 'rationid',  
             width : 200,
             hidden:'true',	
             align: "center",
             title : 'rationid'
         },{
          	 field : 'spoid',  
             width : 200,
             hidden:'true',
             align: "center",
             title : 'spoId',
             formatter:function(value,row){
            	 row.spoid = parent.$("#hidSpoId").val();
            	 return parent.$("#hidSpoId").val();
             }
         },{
       	 field : 'brokerid',  
            width : 200,  
            align: "center",
            title : '承销商代码'
        },{
       	 field : 'name',  
            width : 200,  
            align: "center",
            title : '承销商名称'
        },{  
            field : 'salesAllocationratio',  
            width : 200,  
            align: "center",
            title : '承销商分配比例（%）',
            editor: { type: 'text', options: { required: true } },
	        formatter:function(value,row){
	       	 return value;
	        }
        },{  
            field : 'salesRebateratio',  
            width : 200, 
            align: "center",
            title : '承销商返佣比例（%）',
            editor: { type: 'text', options: { required: true } },
            formatter:function(value,row){
            	 editRow = undefined;
            	return value;
            }
        }]],
        toolbar:[{text: '修改', iconCls: 'icon-edit', handler: function () {
            var row = $("#tt").datagrid('getSelected');
            if (row !=null) {
                if (editRow != undefined) {
                    $("#tt").datagrid('endEdit', editRow);
                }
                if (editRow == undefined) {
                    var index = $("#tt").datagrid('getRowIndex', row);
                    $("#tt").datagrid('beginEdit', index);
                    editRow = index;
                    $("#tt").datagrid('unselectAll');
                }
            } else {
                
            }
        }},
        '-',
        { text: '保存', iconCls: 'icon-save', handler: function () {
        	$("#tt").datagrid("endEdit", editRow);
        	var spoState=parent.$("#spoType").val();
        	var hidrationType=parent.$("#hidrationType").val();
        	var hidipodate=parent.$("#hidipodate").val();
        	
            var rows = $('#tt').datagrid('getChecked');
            if(rows.length==0){
            	alert("至少请勾选一条分配信息");
            	return;
            }
            var counts=0;
            var sales=0;
	        for(var temp in rows){
	        	if(rows[temp].salesAllocationratio==null||rows[temp].salesAllocationratio==''){
	        		alert("承销商分配比例不能为空");
	        		return;
	        	}
	        	if(rows[temp].salesRebateratio==null||rows[temp].salesRebateratio==''){
	        		alert("承销商返佣比例不能为空");
	        		return;
	        	}
	        	if(rows[temp].salesRebateratio>100){
	        		alert("承销商返佣比例不能大于100");
	        		return;
	        	}
	        	if(rows[temp].rationid==null||rows[temp].rationid==""){
	        		rows[temp].rationid='0';
	        	}
	        	counts=Number(counts)+Number(rows[temp].salesAllocationratio);
	        	if(rows[temp].operationdate!=null){
	        		rows[temp].operationdate=null;
	        	}
	        	sales = Number(sales)+Number(rows[temp].salesRebateratio);
	        }
     	   	if(counts>100){
     	   		alert("所分配的比例总和不能大于100");
     	   		return;
     	   	}else if(counts=='0'){
     	   		alert("分配比例总和不能为0");
     	   		return;
     	   	}
     	   	if(sales != '100'){
     	   		alert("返佣比例总和为100");
 	   			return;
     	   	}
     	   if(hidrationType == '2'){
       		if(hidipodate == "true"){
       			alert("已到上市日期，该配售方案已被采用，不能再次修改！");
       			return;
       		}
       	}else{
       		if(spoState!='4'){
       		alert("已到增发日期，该配售方案已被采用，不能再次修改！");
       		return;
       		}
       	}
            	if(rows.length!=0){
            		$.ajax({
            			traditional: true,
            			type:"POST",
            			url:"<%=request.getContextPath()%>/SPOController/addUnderwriterRationInfo",
            			contentType:"application/json", 
                     	data:JSON.stringify(rows),
            			success:function(data){
            				if(data=="fail"){
            					alert("插入失败！");
            					return;
            				}else if(data=="error"){
            					alert("系统异常！");
            					return;
            				}else if(data=="1001"){
            					alert("资金不足");
            					return;
            				}else if(data=="success"){
            					alert("分配成功！");
            					parent.$("#dd").window("close");
            					parent.getAllInfo();
            					return;
            				}
            			}
            		});
            	}
            	
            	
        }},
        '-',
        { text: '取消编辑', iconCls: 'icon-redo', handler: function () {
            editRow = undefined;
            $("#tt").datagrid("rejectChanges");
            $("#tt").datagrid("unselectAll");
        }
        }],
        onAfterEdit: function (rowIndex, rowData, changes) {
             editRow = undefined;
             if(rowData.salesRebateratio!=''&&!zeroToHundred.test(rowData.salesRebateratio)){
            	 alert("请输入小于100的正整数！");
            	 $('#tt').datagrid('reload');
            	 return;
             }
        	 if(rowData.salesAllocationratio!=''&&!zeroToHundred.test(rowData.salesAllocationratio)){
        		 alert("请输入小于100的正整数！");
        		 $('#tt').datagrid('reload');
        		 return;
        	 }
        	 
        },
        onDblClickRow:function (rowIndex, rowData) {
        	
        },
        onClickRow:function(rowIndex,rowData){
        	 if (editRow != undefined) {
                 $("#tt").datagrid('endEdit', editRow);
             }
             if (editRow == undefined) {
                 $("#tt").datagrid('beginEdit', rowIndex);
                 editRow = rowIndex;
             }
        },
        pagination : true,
        rownumbers : false,
        selectOnCheck: false,
        checkOnSelect: false
       
	 
});

});

//关闭
function doClose(){
	parent. $('#dd').window('close');
}

</script>
</head>
<body>
	<div class="warning">
		<div class="content" style="height:80%">
			<span>温馨提示 :</span>
			<span>分配增发商品及查询</span>
		</div>
	</div>

	<form>
		<div align="center">
		<table id="tt" height="100" align="center">
		</table>
		</div>
		<div align="center" style="margin-top:20px">
			<input type="button" class="btn_sec" id="close" onclick="doClose()" value="关闭">
		</div>
	</form>
	
</body>
</html>