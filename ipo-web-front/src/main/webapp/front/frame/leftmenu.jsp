<%@ page trimDirectiveWhitespaces="true" contentType="text/html;charset=GBK"%>
<%@ include file="/front/public/includefiles/taglib.jsp"%>
<%@ include file="/front/public/includefiles/path.jsp"%>
<script>
	var jastOpenMenu = "";
<%/* 记录最后一次点击左菜单的ID号 */%>
	function selectMenu (menuID)
    {
	    if (menuID)
	    {
		    $ ("#" + menuID).click ();
	    }
	    else if (jastOpenMenu)
	    {
		    $ ("#" + jastOpenMenu).click ();
	    }
    }
    jQuery (document).ready (function ()
    {
<%/* 一级菜单点击事件 */%>
	$ (".menu_1").click (function ()
	    {
		    if ($ (this).attr ("class") == 'menu_1')
		    {
			    $ (this).attr ("class", "menu_2");
		    }
		    else
		    {
			    $ (this).attr ("class", "menu_1");
		    }
		    $ ("#" + $ (this).attr ("id") + "Div").toggle ("fast");
		    return false;
	    });
<%/* 二级菜单点击事件 */%>
	$ (".menu_3").click (function ()
	    {
		    jastOpenMenu = $ (this).attr ("id");
		    mymenu.close ("openUpdateMenuDiv");
		    $ (this).parent ().show ();
<%/* 打开本二级菜单的父菜单 */%>
	$ (".menu_4").attr ("class", "menu_3");
<%/*将以前选中的二级菜单样式还原*/%>
	$ (this).attr ("class", "menu_4");
<%/*修改当前点击二级菜单的样式*/%>
	$ ("#mainfrm").attr ("action", $ (this).attr ("action"));
		    $ ("#mainfrm").submit ();
		    return false;
	    });
	    $ ("#openUpdateMenuDiv").click (function ()
	    {
<%/* 打开设置我的菜单div */%>
	var html = $ ("#updateMenuDiv").html ();
		    mymenu.show ($ (this).attr ("id"), html);
		    return false;
	    });
<%/* 设置首个一级菜单打开 */%>
	$ (".menu_1")[0].click ();
    });
</script>
<form id="mainfrm" name="mainfrm" target="main" method="post" action=""></form>
<%
	/* 展示信息 */
%>
<div class="left_titlebor<c:if test="${empty modelContextMap[selfModuleID]['homepageAction']}">2</c:if>" style="height: 100%; width: 100%; z-index: 10;">
	<div class="title">管理中心</div>
	<div class="clear"></div>
	<%
		/* 我的菜单信息展示 */
	%>
	<%
		/* 遍历循环菜单展示 */
	%>
	<div class="menu_1" id="4001001000">商品发售</div>
	<div id="4001001000Div" style="display: none">
		<div class="menu_3" id="4001001010" action="<%=request.getContextPath()%>/CommodityController/ipoapply">商品申购</div>
		<div class="menu_3" id="4001001020" action="<%=request.getContextPath()%>/CommodityController/OrderQuery">申购记录</div>
		<div class="menu_3" id="4001001030" action="<%=request.getContextPath()%>/CommodityController/DistribQuery">配号记录</div>
		<div class="menu_3" id="4001001040" action="<%=request.getContextPath()%>/CommodityController/SelectedQuery">中签记录</div>
	</div>
	<div class="menu_1" id="2001001000">商品增发</div>
	<div id="2001001000Div" style="display: none;">
		<div class="menu_3" id="2001001010" action="<%=request.getContextPath()%>/front/app/SPO/rationInfo_determine.jsp">确认配售</div>
		<div class="menu_3" id="2001001010" action="<%=request.getContextPath()%>/front/app/SPO/rationInfo.jsp">配售查询</div>
	</div>
	
	<div class="menu_1" id="3001001000">报表查询</div>
	<div id="3001001000Div" style="display: none;">
		<div class="menu_3" id="3001001010" action="<%=request.getContextPath()%>/BillingReportController/getInfo">资金结算信息</div>
	</div>
	<%-- <div class="menu_1" id="3001001000">交收提货</div>
	<div id="3001001000Div" style="display: none;">
		<div class="menu_3" id="3001001010" action="<%=request.getContextPath()%>/SettlementDeliveryController/deliveryview">提货申请</div>
		<div class="menu_3" id="3001001010" action="<%=request.getContextPath()%>/SettlementDeliveryController/printView">自提打印</div>
		<div class="menu_3" id="3001001020" action="<%=request.getContextPath()%>/SettlementDeliveryController/revocationView">撤销提货</div>
		<div class="menu_3" id="3001001020" action="<%=request.getContextPath()%>/SettlementDeliveryController/dispatchingView">在线配送</div>
		<div class="menu_3" id="3001001030" action="<%=request.getContextPath()%>/SettlementDeliveryController/deliveryQueryView">提货查询</div>
		<div class="menu_3" id="3001001040" action="<%=request.getContextPath()%>/SettlementDeliveryController/costQueryView">费用查询</div>
		<div class="menu_3" id="3001001050" action="<%=request.getContextPath()%>/front/app/delivery/transfer.jsp">提单过户</div>
	</div> --%>
	<div class="menu_1" id="5001001000">库转交易</div>
	<div id="5001001000Div" style="display: none;">
		<div class="menu_3" id="5001001010" action="<%=request.getContextPath()%>/front/app/trusteeship/plan.jsp">在线委托申请</div>
		<div class="menu_3" id="5001001020" action="<%=request.getContextPath()%>/trusteeshipCommodityController/apply">托管申请查询</div>
		<div class="menu_3" id="5001001030" action="<%=request.getContextPath()%>/trusteeshipCommodityController/listingCharge">支付挂牌费列表</div>
	</div>
</div>