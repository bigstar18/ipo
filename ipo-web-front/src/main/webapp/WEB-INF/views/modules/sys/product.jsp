<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%><html>
<head>
<title>投资者申购</title>
     <meta name="decorator" content="default"/>
     <link rel="stylesheet" href="jquery-easyui/themes/bootstrap/css/bootstrap.min.css">
	 <link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css"> 
     <link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css"> 
	 <link rel="stylesheet" type="text/css" href="../demo.css">
	<script src="${ctxStatic}/jquery-easyui/jquery.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-easyui/themes/bootstrap/js/bootstrap.min.js"   type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
</head>
<body>
	<div class="col-xs-12">
		<div class="col-xs-12 position">您当前的位置：
			<span class="text-primary">投资者申购</span>
		</div>
		<div class="col-xs-8">		 
		 <table  id="dg"  style="width:100%;height:345px" >
         </table>
		</div>
		<div class="col-xs-4">
		 <div class="easyui-panel" title="投资者申购信息" style="width:100%;height:345px;padding:10px;">
	    <form class="form-inline"  id="fm1">
	      <div class="form-group">
	        <label>产品代码：</label>
	        <input type="text" id="productid "   class="form-control" placeholder="请输入产品代码">
	      </div>
	    </form>
	    <div>
        <h4>详细信息：</h4>
        <p>账户编号：</p>
        <p>申购产品：</p>
        <p>保证金余额：</p>
        <p>可购买数量：</p>
        <p>申购额度：</p>
      </div>
      <form class="form-inline" id="fm2" style="margin-top: 20px;">
	      <div class="form-group">
	        <label style="width: 70px">购买量：</label>
	        <input type="text"  id="quantity "     class="form-control" placeholder="请输入申购量">
	      </div>
	    </form>
	    <button type="submit" class="btn btn-default"  style="margin-top: 12px;">申购</button>
	    </div>
		</div>
		
		<div class="col-xs-12">
			<p>配号查询：</p>
			<div id="myTabContent" class="tab-content">
		    <table class="easyui-datagrid"  style="width:100%;height:345px"
            data-options="singleSelect:true,collapsible:false,pagination:true,fitColumns:true,url:'/Test3/CommodityController/findComms.do‘,method:'get'">
           <thead>
            <tr>
                <th data-options="field:'itemid',width:200">申购产品</th>
                <th data-options="field:'initdistrib',width:200">起始配号</th>
                <th data-options="field:'distribamount',width:180">配号数量</th>
                <th data-options="field:' distribdate,width:200">配号时间</th>
            </tr>
           </thead>
          </table>
			</div>
		</div>
	</div>
<script type="text/javascript">

$(function(){
	$("#dg").datagrid({
	  url:"ipo/findComms",//加载的URL  
      isField:"id",  
      pagination:true,//显示分页  
      pageSize:5,//分页大小  
      pageList:[5,10,15,20],//每页的个数  
      fit:true,//自动补全  
      fitColumns:true, 
      title:"可申购产品列表",
      singleSelect:true,
      collapsible:false,
      iconCls:"icon-save",//图标  
      columns:[[    
                {field:'commodityid',  title:'商品编码',   width:180},     
                {field:'commodityname',  title:'商品名称',   width:180},     
                {field:'price',title:'发售价格',width:180} ,
                {field:'unit',title:'配售单位',width:180} ,
                {field:'start_time',title:'发售日期',width:180} ,
                {field:'end_time',title:'截止日期',width:180}   
            ]]  
	});
});
</script>
</body>
</html>