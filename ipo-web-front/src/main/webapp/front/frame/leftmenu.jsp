<%@ page trimDirectiveWhitespaces="true" contentType="text/html;charset=GBK"%>
<%@ include file="/front/public/includefiles/taglib.jsp"%>
<%@ include file="/front/public/includefiles/path.jsp"%>
<script>
	var jastOpenMenu = "";
<%/* ��¼���һ�ε����˵���ID�� */%>
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
<%/* һ���˵�����¼� */%>
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
<%/* �����˵�����¼� */%>
	$ (".menu_3").click (function ()
	    {
		    jastOpenMenu = $ (this).attr ("id");
		    mymenu.close ("openUpdateMenuDiv");
		    $ (this).parent ().show ();
<%/* �򿪱������˵��ĸ��˵� */%>
	$ (".menu_4").attr ("class", "menu_3");
<%/*����ǰѡ�еĶ����˵���ʽ��ԭ*/%>
	$ (this).attr ("class", "menu_4");
<%/*�޸ĵ�ǰ��������˵�����ʽ*/%>
	$ ("#mainfrm").attr ("action", $ (this).attr ("action"));
		    $ ("#mainfrm").submit ();
		    return false;
	    });
	    $ ("#openUpdateMenuDiv").click (function ()
	    {
<%/* �������ҵĲ˵�div */%>
	var html = $ ("#updateMenuDiv").html ();
		    mymenu.show ($ (this).attr ("id"), html);
		    return false;
	    });
<%/* �����׸�һ���˵��� */%>
	$ (".menu_1")[0].click ();
    });
</script>
<form id="mainfrm" name="mainfrm" target="main" method="post" action=""></form>
<%
	/* չʾ��Ϣ */
%>
<div class="left_titlebor<c:if test="${empty modelContextMap[selfModuleID]['homepageAction']}">2</c:if>" style="height: 100%; width: 100%; z-index: 10;">
	<div class="title">��������</div>
	<div class="clear"></div>
	<%
		/* �ҵĲ˵���Ϣչʾ */
	%>
	<%
		/* ����ѭ���˵�չʾ */
	%>
	<div class="menu_1" id="4001001000">��Ʒ����</div>
	<div id="4001001000Div" style="display: none">
		<div class="menu_3" id="4001001010" action="<%=request.getContextPath()%>/CommodityController/ipoapply">��Ʒ�깺</div>
		<div class="menu_3" id="4001001020" action="<%=request.getContextPath()%>/CommodityController/OrderQuery">�깺��¼</div>
		<div class="menu_3" id="4001001030" action="<%=request.getContextPath()%>/CommodityController/DistribQuery">��ż�¼</div>
		<div class="menu_3" id="4001001040" action="<%=request.getContextPath()%>/CommodityController/SelectedQuery">��ǩ��¼</div>
	</div>
	<div class="menu_1" id="2001001000">��Ʒ����</div>
	<div id="2001001000Div" style="display: none;">
		<div class="menu_3" id="2001001010" action="<%=request.getContextPath()%>/front/app/SPO/rationInfo_determine.jsp">ȷ������</div>
		<div class="menu_3" id="2001001010" action="<%=request.getContextPath()%>/front/app/SPO/rationInfo.jsp">���۲�ѯ</div>
	</div>
	
	<div class="menu_1" id="3001001000">�����ѯ</div>
	<div id="3001001000Div" style="display: none;">
		<div class="menu_3" id="3001001010" action="<%=request.getContextPath()%>/BillingReportController/getInfo">�ʽ������Ϣ</div>
	</div>
	<%-- <div class="menu_1" id="3001001000">�������</div>
	<div id="3001001000Div" style="display: none;">
		<div class="menu_3" id="3001001010" action="<%=request.getContextPath()%>/SettlementDeliveryController/deliveryview">�������</div>
		<div class="menu_3" id="3001001010" action="<%=request.getContextPath()%>/SettlementDeliveryController/printView">�����ӡ</div>
		<div class="menu_3" id="3001001020" action="<%=request.getContextPath()%>/SettlementDeliveryController/revocationView">�������</div>
		<div class="menu_3" id="3001001020" action="<%=request.getContextPath()%>/SettlementDeliveryController/dispatchingView">��������</div>
		<div class="menu_3" id="3001001030" action="<%=request.getContextPath()%>/SettlementDeliveryController/deliveryQueryView">�����ѯ</div>
		<div class="menu_3" id="3001001040" action="<%=request.getContextPath()%>/SettlementDeliveryController/costQueryView">���ò�ѯ</div>
		<div class="menu_3" id="3001001050" action="<%=request.getContextPath()%>/front/app/delivery/transfer.jsp">�ᵥ����</div>
	</div> --%>
	<div class="menu_1" id="5001001000">��ת����</div>
	<div id="5001001000Div" style="display: none;">
		<div class="menu_3" id="5001001010" action="<%=request.getContextPath()%>/front/app/trusteeship/plan.jsp">����ί������</div>
		<div class="menu_3" id="5001001020" action="<%=request.getContextPath()%>/trusteeshipCommodityController/apply">�й������ѯ</div>
		<div class="menu_3" id="5001001030" action="<%=request.getContextPath()%>/trusteeshipCommodityController/listingCharge">֧�����Ʒ��б�</div>
	</div>
</div>