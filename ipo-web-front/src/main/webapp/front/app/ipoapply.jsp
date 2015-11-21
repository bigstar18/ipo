<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="gnnt.MEBS.logonService.vo.UserManageVO"%>  
<%@page import="java.lang.String"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%//String userId =((UserManageVO)session.getAttribute("CurrentUser")).getUserID();
String userId ="888";%><html>
<head>
<title>Ͷ�����깺ҳ��</title>
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
	<div class="msg">����ǰ��λ�ã�<span>��Ʒ�깺</span></div>
	<div class="warning">
		<div class="title font_orange_14b">��ܰ��ʾ :</div>
		<div class="content">�ڴ�չʾͶ�����깺����Ҫ����Ϣ��</div>
	</div>
	<div class="col-xs-12">
		<div style="height:350px;">		 
			  <table id="mytb" class="easyui-datagrid"  title="���깺��Ʒ�б�"   style="width:70%;height:385px;"
			            data-options="singleSelect:true,autoRowHeight:false,nowrap:true,onClickRow:getDetail,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findComms',method:'get'">
			        <thead>
			            <tr>
			                <th data-options="field:'commodityid',width:160">��Ʒ����</th>
			                <th data-options="field:'commodityname',width:160">�깺��Ʒ</th>
			                <th data-options="field:'price',width:160">���ۼ۸�</th>
			                <th data-options="field:'units',width:160">���۵�λ</th>
			                <th data-options="field:'starttime',width:160,formatter:dateconvertfunc">��������</th>
			            </tr>
			        </thead>
			    </table>
			
			    <div class="easyui-panel"   title="Ͷ�����깺��Ϣ"  style="width:30%;height:385px;padding:10px;overflow:hidden;">
				    <form class="form-inline"  id="fm1" style="margin-top: 10px">
				      <div class="form-group">
				        <label>��Ʒ���룺</label>
				        <input type="hidden" id="id" />
				        <input type="text" id="commodityid"   class="form-control"  placeholder="�������Ʒ����" style="height: 25px; padding-top: 0px; padding-bottom: 0px;"  onkeyup="showInfo(this.value)">
				      </div>
				    </form>
				    <div class="infos">
			        <h4>��ϸ��Ϣ��</h4>
			        <p>�˻���ţ�<b id="userId"><%=userId %></b></p>
			        <p>�깺��Ʒ��<b id="comname"></b></p>
			        <p>�����ʽ�<b id="money"></b></p>
			        <p>�ɹ���������<b id="counts"></b></p>
			        <p>�깺��ȣ�<b id="limit"></b></p>
			        <input type="hidden"   id="price"/>
			        <input type="hidden"   id="units"/>
			        <input type="hidden"   id="pathStr1" value="<%=request.getContextPath()%>/CommodityController/getUserInfo"/>
			        <input type="hidden"   id="pathStr2" value="<%=request.getContextPath()%>/CommodityController/getInfos"/>
			      </div>
			      <form class="form-inline" id="fm2" style="margin-bottom: 12px">
				      <div class="form-group">
				        <label style="width: 70px">��������</label>
				        <input type="text"  id="quantity"  class="easyui-numberbox" data-options="required:true,min:1,missingMessage:'�깺����'">
				      </div>
				    </form>
				     <div>
				     <button type="button"  id="btn"  style="float:left;padding-right: 25px; padding-left: 25px; height: 30px;">�깺</button><b id="remind" style="color: red;float:left;line-height: 30px; height:40px;margin-left: 20px;"></b>	  
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
	        beforePageText: '��',
	        afterPageText: 'ҳ    �� {pages} ҳ', 
	        displayMsg: '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼'
	    });  
	    
   //��ȡ�û���֤��	
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
			$("#remind").text("��������ȷ����Ʒ��ţ�");
			return;
		}
		if($("#quantity").val().length>9){
			$("#remind").text("����������");
			return;
		}
		if($("#quantity").val().length==0){
			$("#remind").text("�����빺������");
			return;
		}
		var price=$("#price").val();
		var units=$("#units").val();
		var num=$("#quantity").val();
		var moneyneed=parseFloat(price)*parseInt(num)*parseInt(units);
		var money= parseFloat( $("#money").text());
		if(moneyneed>money){
			$("#remind").text("�ʽ��㣡");
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
	            if (data == "4") {  
	            	$("#remind").text("�ύ����ʧ�ܣ�");
	            }  
	            if (data == "5") {  
	            	$("#remind").text("������Ʒ�깺��ȣ�");
	            }  
	        },  
	        error : function(data) {  
	        	$("#remind").text("ϵͳ�����쳣�������µ�½��");
	        }  
		});  
		}     
	});
});

//����ת��
function dateconvertfunc(value,row){
        return value.substr(0,10);
} 
//����
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
//�깺����첽ˢ��
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
