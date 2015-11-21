<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>  
<%@page import="java.lang.String"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%//String userId =((UserManageVO)session.getAttribute("CurrentUser")).getUserID();
String userId ="888";%><html>
<head>
<title>投资者申购页面</title>
     <meta name="decorator" content="default"/>
     <link rel="stylesheet" href="${ctxStatic}/bootstrap/2.3.1/css_default/bootstrap.min.css">
	 <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
     <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css"> 
     <link href="${skinPath}/css/mgr/memberadmin/module.css" rel="stylesheet" type="text/css" />
	<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<style type="text/css">
.panel{float:left}
.infos{margin-top:10px}
.infos h4{margin-top: 10px; margin-bottom: 13px}
.infos p{ margin-bottom: 13px}
</style>
</head>
<body>
<div class="main">
	<div class="msg">您当前的位置：<span>商品申购</span></div>
	<div class="warning">
		<div class="title font_orange_14b">温馨提示 :</div>
		<div class="content">在此展示投资者申购所需要的信息。</div>
	</div>
	<div class="col-xs-12">
		<div style="height:350px;">		 
			  <table id="mytb" class="easyui-datagrid"  title="可申购商品列表"   style="width:70%;height:385px;"
			            data-options="singleSelect:true,autoRowHeight:false,nowrap:true,onClickRow:getDetail,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findComms',method:'get'">
			        <thead>
			            <tr>
			                <th data-options="field:'commodityid',width:160">产品代码</th>
			                <th data-options="field:'commodityname',width:160">申购产品</th>
			                <th data-options="field:'price',width:160">发售价格</th>
			                <th data-options="field:'units',width:160">配售单位</th>
			                <th data-options="field:'starttime',width:160,formatter:dateconvertfunc">发售日期</th>
			            </tr>
			        </thead>
			    </table>
			
			    <div class="easyui-panel"   title="投资者申购信息"  style="width:30%;height:385px;padding:10px;overflow:hidden;">
				    <form class="form-inline"  id="fm1" style="margin-top: 10px">
				      <div class="form-group">
				        <label>产品代码：</label>
				        <input type="hidden" id="id" />
				        <input type="text" id="commodityid"   class="form-control"  placeholder="请输入产品代码" style="height: 25px; padding-top: 0px; padding-bottom: 0px;"  onkeyup="showInfo(this.value)">
				      </div>
				    </form>
				    <div class="infos">
			        <h4>详细信息：</h4>
			        <p>账户编号：<b id="userId"><%=userId %></b></p>
			        <p>申购产品：<b id="comname"></b></p>
			        <p>可用资金：<b id="money"></b></p>
			        <p>可购买数量：<b id="counts"></b></p>
			        <p>申购额度：<b id="limit"></b></p>
			        <input type="hidden"   id="price"/>
			        <input type="hidden"   id="units"/>
			        <input type="hidden"   id="pathStr1" value="<%=request.getContextPath()%>/CommodityController/getUserInfo"/>
			        <input type="hidden"   id="pathStr2" value="<%=request.getContextPath()%>/CommodityController/getInfos"/>
			      </div>
			      <form class="form-inline" id="fm2" style="margin-bottom: 12px">
				      <div class="form-group">
				        <label style="width: 70px">购买量：</label>
				        <input type="text"  id="quantity"  class="easyui-numberbox" data-options="required:true,min:1,missingMessage:'申购必填'">
				      </div>
				    </form>
				     <div>
				     <button type="button"  id="btn"  style="float:left;padding-right: 25px; padding-left: 25px; height: 30px;">申购</button><b id="remind" style="color: red;float:left;line-height: 30px; height:40px;margin-left: 20px;"></b>	  
				    </div>
				    </div>
			</div>
	</div>
<script type="text/javascript">

$(document).ready(function() {
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
		    data:{"userid":"<%=userId %>"},  
		    dataType: 'json',  
		    async: true,  
		    success : function(data, stats) {  
	            $("#money").text(data);
	        }    
		});  

	$("#btn").bind('click',function(){
		if($("#comname").text()==""){
			$("#remind").text("请输入正确的商品编号！");
			return;
		}
		if($("#quantity").val().length>9){
			$("#remind").text("购买量过大！");
			return;
		}
		if($("#quantity").val().length==0){
			$("#remind").text("请输入购买量！");
			return;
		}
		var price=$("#price").val();
		var units=$("#units").val();
		var num=$("#quantity").val();
		var moneyneed=parseFloat(price)*parseInt(num)*parseInt(units);
		var money= parseFloat( $("#money").text());
		if(moneyneed>money){
			$("#remind").text("资金不足！");
		}else{
		var infos={ "id":$("#id").val(),"userid":"<%=userId %>","commodityid": $("#commodityid").val() , "quantity" : $("#quantity").val() };
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
	            	$("#remind").text("现在非申购时间！");
	            }  
	            if (data == "2") {  
	            	$("#remind").text("资金不足！");
	            }  
	            if (data == "3") {  
	            	$("#remind").text("您已提交订单，请勿重复操作！");
	            }  
	            if (data == "4") {  
	            	$("#remind").text("提交订单失败！");
	            }  
	            if (data == "5") {  
	            	$("#remind").text("超出商品申购额度！");
	            }  
	        },  
	        error : function(data) {  
	        	$("#remind").text("系统出现异常，请重新登陆！");
	        }  
		});  
		}     
	});
});

//日期转换
function dateconvertfunc(value,row){
        return value.substr(0,10);
} 
//联动
function getDetail(index, data) {
	  if (data) {
		        $("#commodityid").val(data.commodityid);
		        $("#comname").text(data.commodityname);
		        $("#price").val(data.price);
		        $("#units").val(data.units);
		        $("#id").val(data.id);
		        $("#remind").text("");
		        var comid= data.commodityid;
		  	  $.ajax({  
				    type: 'GET',  
				    url: "<%=request.getContextPath()%>/CommodityController/getInfos",  
				    contentType: "application/json; charset=utf-8", 
				    data:{"commodityid":comid,"money": $("#money").text()},  
				    dataType: 'json',  
				    async: true,  
				    success : function(data, stats) {  
			            $("#counts").text(data.number);
			            $("#limit").text(data.purchaseCredits);
			        }    
				});  
	        }
}
//申购面板异步刷新
 function showInfo(str){
            var xmlhttp;
          if (str.length==0) {
        	   $("#comname").text("");
	           $("#counts").text("");
	           $("#limit").text("");
	           $("#remind").text("");
	           $("#id").text("");
              return; 
           }
         if (window.XMLHttpRequest) {
            xmlhttp=new XMLHttpRequest();  }
        else {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); }
        xmlhttp.onreadystatechange=function() { 
        	if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	               if( xmlhttp.responseText){
	            	   var com=eval('(' + xmlhttp.responseText + ')');
		           $("#comname").text(com.name);
		           $("#counts").text(com.number);
		           $("#limit").text(com.purchaseCredits);
		           $("#price").val(com.price);
		           $("#units").val(com.units);
		           $("#id").val(com.id);
	               }
	         }
	        else{
	        	   $("#comname").text("");
		           $("#counts").text("");
		           $("#limit").text("");
		           $("#remind").text("");
		           $("#id").text("");

	  }
    };
           xmlhttp.open("GET","<%=request.getContextPath()%>/CommodityController/getInfos?commodityid="+str+"&money="+$("#money").text(),true);
           xmlhttp.send();
}
</script>
</div>
</body>
</html>
