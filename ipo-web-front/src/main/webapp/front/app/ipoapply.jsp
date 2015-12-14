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
<title>Ͷ�����깺ҳ��</title>
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
			����ǰ��λ�ã�<span>��Ʒ�깺</span>
		</div>
		<div class="warning">
			<div class="title font_orange_14b">��ܰ��ʾ :</div>
			<div class="content">�ڴ�չʾͶ�����깺����Ҫ����Ϣ��</div>
		</div>
		<div class="col-xs-12">
			<div style="height: 350px;">
				<table id="mytb" class="easyui-datagrid" title="���깺��Ʒ�б�"
					style="width: 70%; height: 385px;"
					data-options="singleSelect:true,autoRowHeight:false,toolbar:'#tb',nowrap:true,onClickRow:getDetail,pagination:true,fitColumns:true,url:'<%=request.getContextPath()%>/CommodityController/findComms',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'id',width:0">��Ʒ���</th>
							<th data-options="field:'commodityid',width:160">��Ʒ����</th>
							<th data-options="field:'commodityname',width:160">�깺��Ʒ</th>
							<th data-options="field:'price',width:160">���ۼ۸�</th>
							<th data-options="field:'units',width:160">���۵�λ</th>
							<th data-options="field:'counts',width:160">��������</th>
							<th data-options="field:'purchaseCredits',width:0">�깺���</th>
							<th data-options="field:'starttime',width:160,formatter:dateconvertfunc">��������</th>
							<th data-options="field:'endtime',width:160,formatter:dateconvertfunc">��ֹ����</th>
						</tr>
					</thead>
				</table>
                 <div id="tb" style="padding:5px;height:auto">
		          <div>
		        	��Ʒ���룺<input type="text" id="commid" name="commodityid" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
			              ��Ʒ���ƣ�<input type="text" id="commname" name="commodityname" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
		          <input type="button" value="��ѯ" onclick="doSearch()"/>				
		          </div> 
	             </div>
				<div class="easyui-panel" title="��ϸ��Ϣ"  style="width: 30%; height: 385px; padding: 10px; overflow: hidden;font-size: 16px;">
					<div class="infos">
						 <input type="hidden" id="id" />
						 <input type="hidden" id="commodityid" />
						 <input type="hidden" id="price" />
					     <input type="hidden" id="units" />
						<p>�˻���ţ�<b id="userId"><%=userId%></b></p>
						<p>�깺��Ʒ��<b id="comname"></b></p>
						<p>�����ʽ�(/Ԫ)��<b id="money"></b></p>
						<p>�ɹ���������<b id="availibleQua"></b></p>
						<p>�깺��ȣ�<b id="purchaseCredits"></b></p>
					</div>
					<form class="form-inline" id="fm2" style="margin-bottom: 12px" onsubmit="return false;">
						<div class="form-group">
							<label style="font-size: 16px;">��������</label> 
							<input type="text" onfocus="clearNote()"  id="quantity" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}" style="padding-top: 0px; padding-bottom: 0px;margin-top: 0px;margin-bottom: 0px;line-height: 14px;"/>
						</div>
					<div>
						<button type="button" id="btn" style="float: left; padding-right: 25px; padding-left: 25px; height: 30px; margin-top: 30px;">�깺</button>
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
	        beforePageText: '��',
	        afterPageText: 'ҳ    �� {pages} ҳ', 
	        displayMsg: '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼'
	    });  
	    
   //��ȡ�û���֤��	
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
			$("#remind").text("����ѡ��ĳ����Ʒ�ٽ����깺��");
			return;
		}
		if($("#quantity").val().length>9){
			$("#remind").text("����������");
			return;
		}
		if($("#quantity").val().length==0){
			$("#remind").text("�깺�����");
			return;
		}
		if($("#quantity").val()%($("#units").val())!=0){
			$("#remind").text("���������Ʒ���۵�λ���������깺����");
			return;
		}
		var price=$("#price").val();
		var num=$("#quantity").val();
		var moneyneed=parseFloat(price)*parseInt(num);
		var money= parseFloat($("#money").text());
		if(moneyneed>money){
			$("#remind").text("�ʽ��㣡");
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
	            	$("#remind").text("�ύ�����ɹ���");
	            }  
	            if (data == "1") {  
	            	$("#remind").text("������Ʒ�����ڣ�");
	            }  
	            if (data == "2") {  
	            	$("#remind").text("�ʽ��㣡");
	            }  
	            if (data == "3") {  
	            	$("#remind").text("�����ύ�����������ظ�������");
	            }  
	            if (data == "5") {  
	            	$("#remind").text("������Ʒ�깺��ȣ�");
	            }
	            if(data == "6"){
	            	$("#remind").text("���ڷ��깺ʱ�䣡");
	            }
	        },  
	        error : function(data) {  
	        	$("#remind").text("ϵͳ�����쳣�������µ�½��");
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
	        beforePageText: '��',
	        afterPageText: 'ҳ    �� {pages} ҳ', 
	        displayMsg: '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼'
	    });
}

//����ת��
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
//����
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
