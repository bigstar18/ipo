<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加增发商品</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<link rel="stylesheet" href="../../skinstyle/default/css/common.css" type="text/css" />
<style type="text/css">
	.content span{display:block}
	.radio{display:none}
	.all{display:none}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var spoid=parent.$("#hidSpoId").val();
	getIPOCommInfo();
	
	if(spoid!=""){
		getSpoInfo(spoid);
		var value = $("#rationType").val();
		$("#communityId").hide();
		$("#commIdInput").show();
		$(".radio").show();
		$(".all").show();
	 	$("#add").val("修改");
	 	$("#title").html("修改增发商品");
		
	}
});

//获取增发修改的基本信息
function getSpoInfo(spoId){
	var tempType;
	$.ajax({
		type:"GET",
		url:"<%=request.getContextPath()%>/SPOController/getSPOInfoBySPOId?randnum="+Math.floor(Math.random()*1000000),
		data:{spoId:spoId},
		dataType: "json", 
		success:function(data){
			if(data!="error"&&data!=""){
				$("#spoCounts").val(data.spoCounts);
				$("#commIdInput").val(data.communityId);
				if(data.registerDate!=null){
					$("#registerDate").datebox("setValue",data.registerDate.substr(0,10));
				}
				if(data.spoDate!=null){
					$("#spoDate").datebox("setValue",data.spoDate.substr(0,10));
				}
				if(data.ipoDate!=null){
					$("#ipoDate").datebox("setValue",data.ipoDate.substr(0,10));
				}
				$("#rationType ").get(0).selectedIndex=data.rationType;
				$("#spoPrice").val(data.spoPrice);
				$("#positionsPrice").val(data.positionsPrice);
				$("#minRationCounts").val(data.minRationCounts);
				$("#minRationProportion").val(data.minRationProportion);
			}
			if(data.rationType==1){
				$(".radio").show();
				$(".all").show();
			}else if(data.rationType==2){
				$(".radio").hide();
				$(".all").show();
			}
				
			
		}
		
	});
}

function rationTypeChange(){
	var spoid=parent.$("#hidSpoId").val();
	var value = $("#rationType").val();
	if(spoid==""){
		$("#spoDate").datebox("setValue","");
		$("#ipoDate").datebox("setValue","");
		$("#registerDate").datebox("setValue","");
		$("span input").val("");
		if(value=="1"){
			$(".radio").show();
			$(".all").show();
		}else if(value=="2"){
			$(".radio").hide();
			$(".all").show();
		}else{
			$(".radio").hide();
			$(".all").hide();
		}
	}else if(spoid!=""){
		if(value=="1"){
			$(".radio").show();
			$(".all").show();
		}else if(value=="2"){
			$(".radio").hide();
			$("#minRationCounts").val("");
			$("#minRationProportion").val("");
			$(".all").show();
		}else{
			$(".radio").hide();
			$(".all").hide();
		}
	}
	
}

//获取商品信息
function getIPOCommInfo(){
	$.ajax({
		type:"GET",
		url:"<%=request.getContextPath()%>/SPOController/getIPOCommonity",
		success:function(data){
        	if(data!="error"&&data!=""&&data!="null"){
        		var temp = data.split("|");
        		for(var ele in temp){
        			if(temp[ele] !="")
        				$("#communityId").append("<option>"+temp[ele]+"</option>");
        		}
        	}else if(data=="null"){
        		return;
        	}
        	else if(data=="error")
        		alert("初始化，请稍后再试");
         } 
	});
}


function btnClick(){
	if($("#add").val()=="添加"){
		addSPOInfo();
	}
	if($("#add").val()=="修改"){
		updateSPOInfo();
	}
}

//添加增发信息
function addSPOInfo(){
	
	var reg =  /.*\((.*)\)/;//正则表达式获取括号内容
	var registerDate = $("#registerDate").datebox("getValue");
	var spoDate = $("#spoDate").datebox("getValue");
	var ipoDate = $("#ipoDate").datebox("getValue");
	var rationType = $("#rationType").val();
	var spoCounts = $("#spoCounts").val();
	var spoPrice = $("#spoPrice").val();
	var positionsPrice = $("#positionsPrice").val();
	var minRationCounts = $("#minRationCounts").val();
	var minRationProportion = $("#minRationProportion").val();

	//验证
	if($("#communityId").val() == "请选择"){
		alert("请选择具体商品！");
		return;
	}
	var commonityId = $("#communityId").val().match(reg)[1];
	if(!myDateValidate(ipoDate,registerDate)){
		alert("上市日期不能小于登记日期！")
		return;
	}
	if(!myDateValidate(ipoDate,spoDate)){
		alert("上市日期不能小于增发日期！")
		return;
	}
	if(!myDateValidate(spoDate,registerDate)){
		alert("增发日期不能小于登记日期！")
		return;
	}
	if(parseInt(spoCounts) < parseInt(minRationCounts)){
		alert("增发数量不能小于最小配售数量！")
		return;
	}
	if(registerDate ==""){
		alert("请选择登记日期！");
		return;
	}
	if(ipoDate==""){
		alert("请选择上市日期！");
		return;
	}
	if(rationType=="比例配售"){
		if(spoDate==""){
			alert("请选择增发日期！");
			return;
		}
		if(minRationCounts==""){
			alert("请输入最小配售数量！");
			return;
		}
		if(minRationProportion==""){
			alert("请输入最小配售比例！");
			return;
		}
	}
	if(spoCounts==""){
		alert("输入增发数量！");
		return;
	}
	if(spoPrice==""){
		alert("请输入增发价格！")
		return;
	}
	//转换数据格式
	if(rationType=="比例配售"){
		rationType=1;
	}else if(rationType=="定向配售"){
		rationType=2;
	}
	

	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/SPOController/insertSPOInfo",
		data:{communityId:commonityId,
			spoCounts:spoCounts,
			spoPrice:spoPrice,
			registerDate:registerDate,
			spoDate:spoDate,
			ipoDate:ipoDate,
			rationType:rationType,
			minRationCounts:minRationCounts,
			minRationProportion:minRationProportion,
			positionsPrice:positionsPrice
		},
		success:function(data){
        	if(data=="success"){
        		alert("添加成功！");
        		parent.getAllInfo();
        		parent.$('#dd').window('close');
        	 	return;
        	}
        	else if(data=="error")
        		alert("操作失败，请稍后再试");
        		return;
         } 
	});
}
//修改增发信息
function updateSPOInfo(){
	var reg =  /.*\((.*)\)/;//正则表达式获取括号内容
	var spoid=parent.$("#hidSpoId").val();
	var registerDate = $("#registerDate").datebox("getValue");
	var spoDate = $("#spoDate").datebox("getValue");
	var ipoDate = $("#ipoDate").datebox("getValue");
	var rationType = $("#rationType").val();
	var spoCounts = $("#spoCounts").val();
	var spoPrice = $("#spoPrice").val();
	var positionsPrice = $("#positionsPrice").val();
	var minRationCounts = $("#minRationCounts").val();
	var minRationProportion = $("#minRationProportion").val();
	//验证
	var commonityId = $("#commIdInput").val();
	if(!myDateValidate(ipoDate,registerDate)){
		alert("上市日期不能小于登记日期！")
		return;
	}
	if(!myDateValidate(ipoDate,spoDate)){
		alert("上市日期不能小于增发日期！")
		return;
	}
	if(!myDateValidate(spoDate,registerDate)){
		alert("增发日期不能小于登记日期！")
		return;
	}
	if(parseInt(spoCounts) < parseInt(minRationCounts)){
		alert("增发数量不能小于最小配售数量！")
		return;
	}
	if(registerDate ==""){
		alert("请选择登记日期！");
		return;
	}
	if(ipoDate==""){
		alert("请选择上市日期！");
		return;
	}
	if(rationType=="比例配售"){
		if(spoDate==""){
			alert("请选择增发日期！");
			return;
		}
		if(minRationCounts==""){
			alert("请输入最小配售数量！");
			return;
		}
		if(minRationProportion==""){
			alert("请输入最小配售比例！");
			return;
		}
	}
	if(spoCounts==""){
		alert("输入增发数量！");
		return;
	}
	if(spoPrice==""){
		alert("请输入增发价格！")
		return;
	}
	//转换数据格式
	if(rationType=="比例配售"){
		rationType=1;
	}else if(rationType=="定向配售"){
		rationType=2;
	}
	

	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/SPOController/updateSPOInfo",
		data:{communityId:commonityId,
			spoCounts:spoCounts,
			spoPrice:spoPrice,
			registerDate:registerDate,
			spoDate:spoDate,
			ipoDate:ipoDate,
			rationType:rationType,
			minRationCounts:minRationCounts,
			minRationProportion:minRationProportion,
			positionsPrice:positionsPrice,
			spoId:spoid
		},
		success:function(data){
        	if(data=="success"){
        		alert("修改成功！")
        		parent.getAllInfo();
        		parent.$('#dd').window('close');
        	 	return;
        	}
        	else if(data=="error")
        		alert("操作失败，请稍后再试");
        		return;
         } 
	});
}

//修改日期格式
function myformatter(date){
		 var y = date.getFullYear();
		 var m = date.getMonth()+1;
		 var d = date.getDate();
		 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
function myparser(s){
		 if (!s) return new Date();
		 var ss = (s.split('-'));
		 var y = parseInt(ss[0],10);
		 var m = parseInt(ss[1],10);
		 var d = parseInt(ss[2],10);
		 if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		 return new Date(y,m-1,d);
	}else{
		return new Date();
	}
 }


//验证
var nonnegative = /^\d+(\.{1}\d+)?$/;//正则表达式 数字
var pintegral =  /^[0-9]*[1-9][0-9]*$/;//正则表达式，正整数！
var zeroToHundred = /^(\d{1,2}(\.{1}\d+)?|100)$/;//正则表达式，0~100的数；

function validate3(obj){
	 if($(obj).val()=="")
		 return;
	 if(!pintegral.test($(obj).val())){
		 alert("请输入正整数！");
		 $(obj).val("");
	 }
}

//验证是否为数字
function validate1(obj){
	if($(obj).val()=="")
		return;
	 if(!nonnegative.test($(obj).val())){
		 alert("请输入非负数！");
		 $(obj).val("");
	 }
}
//验证是否是0~一百的数
function validate2(obj){
	if($(obj).val()=="")
		return;
	 if(!zeroToHundred.test($(obj).val())){
		 alert("请输入小于100的非负数！");
		 $(obj).val("");
	 }
}
//获取当前日期
function getDateNow(){
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
    return currentdate;
}  
//日期验证
function onSelect(){
	var tempDate = $("#spoDate").datebox("getValue");
	var nowDate=getDateNow(); 
	var bool = myDateValidate(tempDate,nowDate);  
    if(!bool)  
	 {  
	  alert("不能选择过去的日期！");  
	  $("#spoDate").datebox("setValue","");
	  return;
	 }
}
function onSelect2(){
	var tempDate = $("#ipoDate").datebox("getValue");
	var nowDate=getDateNow(); 
	var bool = myDateValidate(tempDate,nowDate);
    if(!bool)  
	 {  
	  alert("不能选择过去的日期！");  
	  $("#ipoDate").datebox("setValue","");
	  return;
	 }
}

function myDateValidate(tempDate,nowDate){
	var d1 = new Date(tempDate.replace(/\-/g, "\/"));  
	var d2 = new Date(nowDate.replace(/\-/g, "\/"));
	if(nowDate!=""&&tempDate!=""&&d1<d2)  
	 {  
	  return false;
	 }
	else{
		return true;
	}
}


//关闭
function doClose(){
	parent. $('#dd').window('close');
	parent.$('#depositInfo').datagrid('reload');
}


</script>
</head>
<body>
	<div class="warning">
		<div class="content" style="height:80%;font-size:12px">
			<span>温馨提示 :（比例配售下）</span>
			<span> 1、最小配售数量指的是：增发的此商品数量如果不超过这个最小配售数量的话，就自动增发失败</span>
			<span>2、最小配售比例指的是：增发给承销会员的最小比例不能小于这个设置</span>
			<span>3、商品代码选项中括号内为该商品代码，括号外为商品名称</span>
		</div>
	</div>

	<form id="frm" method="POST">
		<div class="div_cxtj">
			<div class="div_cxtjL"></div>
			<div id="title" class="div_cxtjC">
				添加增发商品
			</div>
			<div class="div_cxtjR"></div>
		</div>
		<table width="95%" height="100" align="center" class="table2_style">
			<tr align="center">
				<td>
				<span>商品代码：</span>
				<span>
					<input type="text" id="commIdInput" readonly="readonly" style="width:150px;display:none;">
					<select id="communityId" name="communityId" style="width:150px" >
						<option>请选择</option>
					</select>
				</span>
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>登记日期：</span>
				<span>
					<input id="registerDate" name="registerDate" class="easyui-datebox" style="width:150px" editable="false" data-options="formatter:myformatter,parser:myparser">
				</span>	
				</td>
			</tr>
			<tr class="radio" align="center">
				<td>
				<span>增发日期：</span>
				<span>
					<input id="spoDate" name="spoDate" class="easyui-datebox" style="width:150px" editable="false" data-options="formatter:myformatter,parser:myparser,onSelect:onSelect">
				</span>	
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>上市日期：</span>
				<span>
					<input id="ipoDate" name="ipoDate" class="easyui-datebox" style="width:150px" editable="false" data-options="formatter:myformatter,parser:myparser,onSelect:onSelect2">
				</span>	
				</td>
			</tr>	
			<tr align="center">
				<td>
				<span>配售类型：</span>
				<span>
					<select id="rationType" name="rationType" style="width:150px" onchange="rationTypeChange()">
						<option value="">请选择</option>
						<option value="1">比例配售</option>
						<option value="2">定向配售</option>
					</select>
				</span>
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>增发数量：</span>
				<span>
					<input  onblur="validate3(this);" id="spoCounts" name="spoCounts" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>	
			<tr class="all" align="center">
				<td>
				<span>增发价格：</span>
				<span>
					<input onblur="validate1(this);" id="spoPrice" name="spoPrice" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="all" align="center">
				<td>
				<span>持仓价格：</span>
				<span>
					<input onblur="validate1(this);" id="positionsPrice" name="positionsPrice" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="radio" align="center">
				<td>
				<span>最小配售数量：</span>
				<span style="margin-right:25px">
					<input onblur="validate3(this);" id="minRationCounts" name="minRationCounts" class="easyui-textbox" style="width:150px">
				</span>	
				</td>
			</tr>
			<tr class="radio" align="center">
				<td>
				<span >最小配售比例：</span>
				<span style="margin-right:18px">
					<input onblur="validate2(this);" id="minRationProportion" name="minRationProportion" class="easyui-textbox" style="width:150px">%
				</span>	
				</td>
			</tr>
		</table>
		<table width="100%" style="margin-top:15px">
			<tr >
				<td align="center">
					<input type="button" class="btn_sec" id="add" onclick="btnClick()" value="添加">
				    <input type="button" class="btn_sec" id="close" onclick="doClose()" value="关闭">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>