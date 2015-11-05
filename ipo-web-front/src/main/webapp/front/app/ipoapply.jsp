<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%><html>
<head>
<title>Ͷ�����깺ҳ��</title>
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
		<div class="col-xs-12 position">����ǰ��λ�ã�
			<span class="text-primary">Ͷ�����깺</span>
		</div>
		<div class="col-xs-8">		 
  <table class="easyui-datagrid"  title="���깺��Ʒ�б�"   style="width:100%;height:345px"
            data-options="singleSelect:true,collapsible:false,pagination:true,pageList:[10,15,20,25],fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findComms',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'commodityid',width:200">��Ʒ����</th>
                <th data-options="field:'commodityname',width:200">�깺��Ʒ</th>
                <th data-options="field:'price',width:180">���ۼ۸�</th>
                <th data-options="field:'units',width:200">���۵�λ</th>
                <th data-options="field:'starttime',width:200,formatter:dateconvertfunc">��������</th>
                <th data-options="field:'endtime',width:200,formatter:dateconvertfunc">��ֹ����</th>
            </tr>
        </thead>
    </table>
    <table id="dg"></table>
		</div>
		<div class="col-xs-4">
		 <div class="easyui-panel"   title="Ͷ�����깺��Ϣ" style="width:100%;height:345px;padding:10px">
	    <form class="form-inline"  id="fm1">
	      <div class="form-group">
	        <label>��Ʒ���룺</label>
	        <input type="text" id="commodityid"   class="form-control"  placeholder="�������Ʒ����"  onkeyup="showInfo(this.value)">
	      </div>
	    </form>
	    <div>
        <h4>��ϸ��Ϣ��</h4>
        <p>�˻���ţ�<b >${param.userID  }</b></p>
        <p>�깺��Ʒ��<b id="comname"></b></p>
        <p>��֤����<b id="money"></b></p>
        <p>�ɹ���������<b id="counts"></b></p>
        <p>�깺��ȣ�<b id="limit"></b></p>
      </div>
      <form class="form-inline" id="fm2" style="margin-top: 20px">
	      <div class="form-group">
	        <label style="width: 70px">��������</label>
	        <input type="text"  id="quantity"  class="easyui-numberbox" data-options="required:true,min:1">
	      </div>
	    </form>
	     <div>
	     <button type="button"  id="btn"    class="btn btn-default"  style="margin-top:12px;float:left">�깺</button><b id="remind" style="color: red;float:left;line-height: 57px; margin-left: 20px;"></b>	  
	    </div>
	    </div>
		</div>
		
		<div class="col-xs-12">
		<br>
			<div id="myTabContent" class="tab-content">
		   <table class="easyui-datagrid"  title="Ͷ������Ų�ѯ"   style="width:100%;height:345px"
            data-options="singleSelect:true,collapsible:false,pagination:true,pageSize:10,pageList:[10,15,20,25],fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findApplyNums',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'commodityname',width:200">�깺��Ʒ</th>
                <th data-options="field:'startnumber',width:180">��ʼ���</th>
                <th data-options="field:'pcounts',width:200">�������</th>
                <th data-options="field:'ptime',width:200,formatter:dateconvertfunc">���ʱ��</th>
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
			$("#remind").text("��������ȷ����Ʒ��ţ�");
			return;
		}
		//var datas =  [{"storeId":"0a1", "address":"������·2��", "goods":[{"goodsId":"1"}, {"goodsId":"2"}, {"goodsId":"3"}]}] ;
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
	            	$("#remind").text("�ύ�����ɹ���");
	            }  
	            if (data == "1") {  
	            	$("#remind").text("���ڷ��깺ʱ�䣡");
	            }  
	            if (data == "2") {  
	            	$("#remind").text("�ʽ��㣡");
	            }  
	            if (data == "3") {  
	            	$("#remind").text("�����ύ�����������ظ�������");
	            }  
	        },  
	        error : function(data) {  
	           // alert("����ʧ��");  
	        }  
		});  
	});
});

//����ת��
function dateconvertfunc(value,row){
         //  return new Date(value).toLocaleDateString(); //���ر���ϵͳ��ʽʱ��
        /*    var date=new Date(value);
        var year=date.getFullYear();
        var month=date.getMonth()<9?'0'+(date.getMonth()+1):(date.getMonth()+1);
        var day=date.getDate()<10?'0'+date.getDate():date.getDate(); 
        return year+'-'+month+'-'+day;     JSON������������ת������ */ 
        return value.substr(0,10);
} 

//�깺����첽ˢ��
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