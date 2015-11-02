<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%><html>
<head>
<title>投资者申购</title>
     <meta name="decorator" content="default"/>
     <link rel="stylesheet" href="${ctxStatic}/bootstrap/2.3.1/css_default/bootstrap.min.css">
	 <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/default/easyui.css"> 
     <link rel="stylesheet" type="text/css" href="${ctxStatic}/jquery-easyui/themes/icon.css"> 
	<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"   type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
</head>
<body>
	<div class="col-xs-12">
		<div class="col-xs-12 position">您当前的位置：
			<span class="text-primary">投资者申购</span>
		</div>
		<div class="col-xs-8">		 
  <table class="easyui-datagrid"  title="可申购商品列表"   style="width:100%;height:345px"
            data-options="singleSelect:true,collapsible:false,pagination:true,pageList:[10,15,20,25],fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findComms',method:'get'">
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
    <table id="dg"></table>
		</div>
		<div class="col-xs-4">
		 <div class="easyui-panel"   title="投资者申购信息" style="width:100%;height:345px;padding:10px">
	    <form class="form-inline"  id="fm1">
	      <div class="form-group">
	        <label>产品代码：</label>
	        <input type="text" id="commodityid"   class="form-control"  placeholder="请输入产品代码"  onkeyup="showInfo(this.value)">
	      </div>
	    </form>
	    <div>
        <h4>详细信息：</h4>
        <p>账户编号：<b >${param.userID  }</b></p>
        <p>申购产品：<b id="comname"></b></p>
        <p>保证金余额：<b id="money"></b></p>
        <p>可购买数量：<b id="counts"></b></p>
        <p>申购额度：<b id="limit"></b></p>
      </div>
      <form class="form-inline" id="fm2" style="margin-top: 20px">
	      <div class="form-group">
	        <label style="width: 70px">购买量：</label>
	        <input type="text"  id="quantity"     class="form-control"   placeholder="请输入申购量">
	      </div>
	    </form>
	     <div>
	     <button type="button"  id="btn"    class="btn btn-default"  style="margin-top:12px;float:left">申购</button><b id="remind" style="color: red;float:left;line-height: 57px; margin-left: 20px;"></b>	  
	    </div>
	    </div>
		</div>
		
		<div class="col-xs-12">
		<br>
			<div id="myTabContent" class="tab-content">
		   <table class="easyui-datagrid"  title="投资者配号查询"   style="width:100%;height:345px"
            data-options="singleSelect:true,collapsible:false,pagination:true,pageSize:10,pageList:[10,15,20,25],fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findApplyNums',method:'get'">
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
		//var datas =  [{"storeId":"0a1", "address":"西斗门路2号", "goods":[{"goodsId":"1"}, {"goodsId":"2"}, {"goodsId":"3"}]}] ;
		var infos={ "userid":"${param.userID}","commodityid": $("#commodityid").val() , "quantity" : $("#quantity").val() };
		    $.ajax({  
		    type: 'GET',  
		    url: "<%=request.getContextPath()%>/CommodityController/purchApply",  
		    contentType: "application/json; charset=utf-8", 
		    data:infos,  
		    dataType: 'json',  
		    async: false,  
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
</body>
</html>