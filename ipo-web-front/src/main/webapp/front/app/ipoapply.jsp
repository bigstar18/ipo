<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>
<%@page import="java.lang.String"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<% String userId = ((UserManageVO) session.getAttribute("CurrentUser")).getUserID();
//String userId ="888";
%><html>
<head>
<title>投资者申购页面</title>
<meta name="decorator" content="default" />
<link rel="stylesheet"  href="${ctxStatic}/bootstrap/2.3.1/css_default/bootstrap.min.css">
<link rel="stylesheet" type="text/css"  href="${ctxStatic}/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"  href="${ctxStatic}/jquery-easyui/themes/icon.css">
<link href="${skinPath}/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css" />
<script src="${ctxStatic}/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js" type="text/javascript"></script>
<style type="text/css">


.panel {
	float: left
}

.infos {
	margin-top: 25px
}

.infos h4 {
	margin-top: 25px;
	margin-bottom: 25px
}

.infos p {
	margin-bottom: 25px
}
</style>
</head>
<body>
	<div class="main">
		<div class="msg">
			您当前的位置：<span>商品申购</span>
		</div>
		<div class="warning">
			<div class="title font_orange_14b">温馨提示 :</div>
			<div class="content">在此展示投资者申购所需要的信息。</div>
		</div>
		<div class="col-xs-12">
			<div style="height: 350px;">
				<table id="mytb" class="easyui-datagrid" title="可申购商品列表"
					style="width: 70%; height: 385px;"
					data-options="singleSelect:true,autoRowHeight:false,toolbar:'#tb',nowrap:true,onClickRow:getDetail,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findComms',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'id',width:0">商品编号</th>
							<th data-options="field:'commodityid',width:160">商品代码</th>
							<th data-options="field:'commodityname',width:160">申购产品</th>
							<th data-options="field:'price',width:160">发售价格</th>
							<th data-options="field:'units',width:160">配售单位</th>
							<th data-options="field:'counts',width:160">发售数量</th>
							<th data-options="field:'purchaseCredits',width:0">申购额度</th>
							<th data-options="field:'starttime',width:160,formatter:dateconvertfunc">发售日期</th>
							<th data-options="field:'endtime',width:160,formatter:dateconvertfunc">截止日期</th>
						</tr>
					</thead>
				</table>
                 <div id="tb" style="padding:5px;height:auto">
		          <div>
		        	商品代码：<input type="text" id="commid" name="commodityid" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
			              商品名称：<input type="text" id="commname" name="commodityname" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
		          <input type="button" value="查询" onclick="doSearch()"/>				
		          </div> 
	             </div>
				<div class="easyui-panel" title="详细信息"  style="width: 30%; height: 385px; padding: 10px; overflow: hidden;font-size: 16px;">
					<div class="infos">
						 <input type="hidden" id="id" />
						 <input type="hidden" id="commodityid" />
						 <input type="hidden" id="price" />
					     <input type="hidden" id="units" />
						<p>账户编号：<b id="userId"><%=userId%></b></p>
						<p>申购产品：<b id="comname"></b></p>
						<p>可用资金(/元)：<b id="money"></b></p>
						<p>可购买数量：<b id="availibleQua"></b></p>
						<p>申购额度：<b id="purchaseCredits"></b></p>
					</div>
					<form class="form-inline" id="fm2" style="margin-bottom: 12px" onsubmit="return false;">
						<div class="form-group">
							<label style="font-size: 16px;">购买量：</label> 
							<input type="text" onfocus="clearNote()"  id="quantity" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
						</div>
					<div>
						<button type="button" id="btn" style="float: left; padding-right: 25px; padding-left: 25px; height: 30px; margin-top: 30px;">申购</button>
						<b id="remind" style="color: red; float: left; line-height: 30px; height: 40px; margin-left: 20px;margin-top: 30px;"></b>
					</div>
					</form>
				</div>
			</div>
		</div>
<script type="text/javascript">
$(document).ready(function() {
	$('#mytb').datagrid('hideColumn','id');
	$('#mytb').datagrid('hideColumn','purchaseCredits');
	 var p = $('#mytb').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });  
	    
   //获取用户保证金	
	  $.ajax({  
		    type: 'GET',  
		    url: "<%=request.getContextPath()%>/CommodityController/getUserInfo",  
		    contentType: "application/json; charset=utf-8", 
		    data:{"userid":"<%=userId%>"},  
		    dataType: 'json',  
		    async: true,  
		    success : function(data, stats) {  
	            $("#money").text(data);
	        }    
		});  


	$("#btn").bind('click',function(){
		if($("#comname").text()==""){
			$("#remind").text("请先选中某个商品再进行申购！");
			return;
		}
		if($("#quantity").val().length>9){
			$("#remind").text("购买量过大！");
			return;
		}
		if($("#quantity").val().length==0){
			$("#remind").text("申购量必填！");
			return;
		}
		if($("#quantity").val()%($("#units").val())!=0){
			$("#remind").text("请输入该商品配售单位整数倍的申购量！");
			return;
		}
		var price=$("#price").val();
		var num=$("#quantity").val();
		var moneyneed=parseFloat(price)*parseInt(num);
		var money= parseFloat($("#money").text());
		if(moneyneed>money){
			$("#remind").text("资金不足！");
		}else{
		var infos={ "id":$("#id").val(),"userid":"<%=userId%>","commodityid": $("#commodityid").val() , "quantity" : $("#quantity").val(),"randnum":Math.floor(Math.random()*1000000) };
		    $.ajax({  
		    type: 'GET',  
		    url: "<%=request.getContextPath()%>/CommodityController/purchApply",  
		    contentType: "application/json; charset=utf-8", 
		    data:infos,  
		    dataType: 'json',  
		    async: true,  
		    success : function(data, stats) {  
		        if (data == "0") {  
	            	$("#remind").text("提交订单成功！");
	            }  
	            if (data == "1") {  
	            	$("#remind").text("不在商品发售期！");
	            }  
	            if (data == "2") {  
	            	$("#remind").text("资金不足！");
	            }  
	            if (data == "3") {  
	            	$("#remind").text("您已提交订单，请勿重复操作！");
	            }  
	            if (data == "5") {  
	            	$("#remind").text("超出商品申购额度！");
	            }
	            if(data == "6"){
	            	$("#remind").text("现在非申购时间！");
	            }
	        },  
	        error : function(data) {  
	        	$("#remind").text("系统出现异常，请重新登陆！");
	        }  
		});  
		}     
	});
});

function doSearch(){
	$("#mytb").datagrid({
		method:'POST',
		url:'<%=request.getContextPath()%>/CommodityController/QueryByConditionsFront',
	    queryParams:{  
	    	commodityid:$("#commid").val(),  
	    	commodityname:$("#commname").val()  
		    }  
	});
	 var p = $('#mytb').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15],
	        beforePageText: '第',
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
}

//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
}

function onlyNumberInput(){
	 if (event.keyCode<46 || event.keyCode>57 || event.keyCode == 47){
		    event.returnValue=false;
	 }
}

function clearNote(){
	  $("#remind").text("");
}
//联动
function getDetail(index, data) {
	  if (data) {
		        $("#remind").text("");
		        $("#id").val(data.id);
		        $("#commodityid").val(data.commodityid);
		        $("#comname").text(data.commodityname);
		        $("#purchaseCredits").text(data.purchaseCredits);
		        $("#price").val(data.price);
		        $("#units").val(data.units);
		        var money=$("#money").text();
		        $("#availibleQua").text(parseInt(money/(data.price)));
	        }
}
</script>
	</div>
</body>
</html>
