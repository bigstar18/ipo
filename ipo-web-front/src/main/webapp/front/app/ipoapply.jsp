<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%><html>
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
.infos{margin-top:13px}
.infos h4{margin-top: 13px; margin-bottom: 13px}
.infos p{ margin-bottom: 13px}
</style>
</head>
<body>
<div class="main">
	<div class="msg">您当前的位置：<span>投资者申购</span></div>
	<div class="warning">
		<div class="title font_orange_14b">温馨提示 :</div>
		<div class="content">在此展示投资者申购所需要的信息。</div>
	</div>
	<div class="col-xs-12">
	<!-- 	<div class="col-xs-12 position">您当前的位置：
			<span class="text-primary">IPO申购</span>
		</div> -->
		<div style="height:350px;">		 
			  <table class="easyui-datagrid"  title="可申购商品列表"   style="width:65%;height:365px;"
			            data-options="singleSelect:true,collapsible:false,nowrap:true,pagination:true,pageList:[10,15,20,25],fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findComms',method:'get'">
			        <thead>
			            <tr>
			                <th data-options="field:'commodityid',width:200">产品代码</th>
			                <th data-options="field:'commodityname',width:200">申购产品</th>
			                <th data-options="field:'price',width:180">发售价格</th>
			                <th data-options="field:'units',width:200">配售单位</th>
			                <th data-options="field:'starttime',width:200,formatter:dateconvertfunc">发售日期</th>
			                <th data-options="field:'endtime',width:200,formatter:dateconvertfunc">截止日期</th>
			            </tr>
			        </thead>
			    </table>
			
			    <div class="easyui-panel"   title="投资者申购信息"  style="width:35%;height:365px;padding:10px;">
				    <form class="form-inline"  id="fm1" style="margin-top: 10px">
				      <div class="form-group">
				        <label>产品代码：</label>
				        <input type="text" id="commodityid"   class="form-control"  placeholder="请输入产品代码" style="height: 25px; padding-top: 0px; padding-bottom: 0px;"  onkeyup="showInfo(this.value)">
				      </div>
				    </form>
				    <div class="infos">
			        <h4>详细信息：</h4>
			        <p>账户编号：<b >${param.userID  }</b></p>
			        <p>申购产品：<b id="comname"></b></p>
			        <p>保证金余额：<b id="money"></b></p>
			        <p>可购买数量：<b id="counts"></b></p>
			        <p>申购额度：<b id="limit"></b></p>
			      </div>
			      <form class="form-inline" id="fm2" style="margin-top: 15px">
				      <div class="form-group">
				        <label style="width: 70px">购买量：</label>
				        <input type="text"  id="quantity"  class="easyui-numberbox" data-options="required:true,min:1,missingMessage:'申购必填'">
				      </div>
				    </form>
				     <div>
				     <button type="button"  id="btn"  style="margin-top:15px;float:left;padding-right: 25px; padding-left: 25px; height: 30px;">申购</button><b id="remind" style="color: red;float:left;line-height: 60px; height:40px;margin-left: 20px;"></b>	  
				    </div>
				    </div>
			</div>
		 
		
		<div class="col-xs-12">
		<br>
			<div id="myTabContent" class="tab-content">
		   <table class="easyui-datagrid"  title="投资者配号查询"   style="width:100%;height:365px"
            data-options="singleSelect:true,collapsible:false,nowrap:true,pagination:true,pageSize:10,pageList:[10,15,20,25],fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findApplyNums',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'commodityname',width:200">申购产品</th>
                <th data-options="field:'startnumber',width:180">起始配号</th>
                <th data-options="field:'pcounts',width:200">配号数量</th>
                <th data-options="field:'ptime',width:200,formatter:dateconvertfunc">配号时间</th>
            </tr>
        </thead>
    </table>
			</div>
		</div>
	</div>
<script type="text/javascript">

$(document).ready(function() {
	
	$("#btn").bind('click',function(){
		if($("#comname").text()==""){
			$("#remind").text("请输入正确的商品编号！");
			return;
		}
		//var datas =  [{"storeId":"0a1", "address":"西斗门路2号", "goods":[{"goodsId":"1"}, {"goodsId":"2"}, {"goodsId":"3"}]}] ;
		var infos={ "userid":"${param.userID}","commodityid": $("#commodityid").val() , "quantity" : $("#quantity").val() };
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
	        },  
	        error : function(data) {  
	           // alert("请求失败");  
	        }  
		});  
	});
});

//日期转换
function dateconvertfunc(value,row){
         //  return new Date(value).toLocaleDateString(); //返回本地系统格式时间
        /*    var date=new Date(value);
        var year=date.getFullYear();
        var month=date.getMonth()<9?'0'+(date.getMonth()+1):(date.getMonth()+1);
        var day=date.getDate()<10?'0'+date.getDate():date.getDate(); 
        return year+'-'+month+'-'+day;     JSON返回已做类型转换处理 */ 
        return value.substr(0,10);
} 

//申购面板异步刷新
function showInfo(str){
            var xmlhttp;
          if (str.length==0) {
        	  document.getElementById("comname").innerHTML="";
        	  document.getElementById("money").innerHTML="";
        	  document.getElementById("counts").innerHTML="";
        	  document.getElementById("limit").innerHTML="";
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
		           document.getElementById("comname").innerHTML=com.name;
		           document.getElementById("money").innerHTML=com.monery;
		           document.getElementById("counts").innerHTML=com.number;
		           document.getElementById("limit").innerHTML=com.limit;
	               }
	         }
	        else{
		  document.getElementById("comname").innerHTML="";
		  document.getElementById("money").innerHTML="";
    	  document.getElementById("counts").innerHTML="";
    	  document.getElementById("limit").innerHTML="";
	  }
    };
           xmlhttp.open("GET","<%=request.getContextPath()%>/CommodityController/getInfos?commodityid="+str+"&userid="+"${param.userID}",true);
           xmlhttp.send();
}


</script>
</div>
</body>
</html>