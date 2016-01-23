<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<script type="text/javascript" src="<%=publicPath%>/js/xtree.js"></script>
<link rel="stylesheet" href="<%=skinPath%>/css/xtree.css" type="text/css" />
<html>
<head>
<script type="text/javascript">
var oldTradeNo = -1;
var oldSystemStatus = "";
var promptTime = 60;

			var screenAvailHeight = window.screen.availHeight;
			function regInput(str){  
			      reg=/^[a-z]*$/;
			      return reg.test(str)
		      }
	      
      		function goto(pathRrl,node,parentNode){
	          parent.workspace.topFrame1.document.getElementById("tree").value="";
			    //parent.workspace.mainFrame.location.href=pathRrl;
			    parent.workspace.mainFrame.window.location.replace(pathRrl);
				var title=parentNode + " >> " + node;
				parent.workspace.topFrame1.document.getElementById("loc").innerHTML=title;
				var title=parent.document.title;
				var titleArray=title.split("-");
				if(titleArray.length==1){
					title=node+"-"+title;
				}else if(titleArray.length==2){
					title=node+"-"+titleArray[1];
				}
				parent.document.title=title;
			}
			
			function noUse(){
			}
			
			function defDrawerHegiht()
			{
			    //当窗口很小时,菜单不能完全显示,下面时让窗口最大化
			    //top.moveTo(0,0);
				//top.resizeTo(screen.availWidth,screen.availHeight);
				var objBackGround = document.getElementById( "div_BackGround" );
				var objContainer = document.getElementById( "div_Container" );
				var bottomPosition = objBackGround.getBoundingClientRect().bottom;
				if(bottomPosition<40) bottomPosition=40;
				div_Container.style.height = ( bottomPosition - 21  );
				
				var objDrwPanel = document.all.namedItem( "div_drw_Panel" );
				var objDrwContent = document.all.namedItem( "div_drw_Content" );
				for ( var i = 0; i < objDrwContent.length; i++ )
				{   
					var opsheight =( bottomPosition - 21  - 14 - ( 26 * objDrwPanel.length ) );
					opsheight = opsheight>0?opsheight:1;
					objDrwContent[i].style.height = opsheight;
				}
				var topPosition = objBackGround.getBoundingClientRect().top + 21;
				objContainer.style.position = "absolute";
				objContainer.style.display = "inline";
				objContainer.style.top = topPosition - parseInt( div_Container.style.height.substr( 0, ( div_Container.style.height.length - 2 ) ) ) + 14;
				objContainer.style.left = "0px";
				objContainer.showTop = topPosition;
				objContainer.hideTop = topPosition - parseInt( div_Container.style.height.substr( 0, ( div_Container.style.height.length - 2 ) ) ) + 14;
				
			}
			
			function collaspe( action )
			{
				var obj = document.getElementById( "div_entry" );
				var objContainer = document.getElementById( "div_Container" );
				//var objSwitch = document.getElementById( "img_drwPuller" );
				
				if ( obj.curstatus == "hide" || action =="show" )
				{
					objContainer.style.display = "inline";

					objContainer.style.pixelTop += 50;
					if ( objContainer.style.pixelTop >= objContainer.showTop )
					{
						objContainer.style.pixelTop = objContainer.showTop;
						obj.curstatus = "show";
					}
					else
						window.setTimeout ("collaspe( 'show' );", 10);

					//objSwitch.src = "images1/drawer_PullUp.gif";
					//objSwitch.src = "${skinPath}/image/frame/menu/drawer_PullDown_01.gif";
				}
				else
				{
					objContainer.style.pixelTop -= 50;
					if (objContainer.style.pixelTop <= objContainer.hideTop) 
					{
						objContainer.style.pixelTop = objContainer.hideTop;
						obj.curstatus = "hide";
					}
					else
						window.setTimeout ("collaspe( 'hide' );", 10);

					//objSwitch.src = "images1/drawer_PullDown.gif";
					//objSwitch.src = "${skinPath}/image/frame/menu/drawer_PullDown_01.gif";
					//alert ( objContainer.hideTop );
				}
				
			}
			
			function drwSwitch()
			{
				var objDrwContent = document.all.namedItem( "div_drw_Content" );
				var objMem = document.getElementById("span_curstatus");

				var curNo = event.srcElement.curDrwNo;
            	var lastNo = objMem.curNo;
            	if(curNo!=0){
            		objDrwContent[0].style.display = "none";		
                 }
            	if ( lastNo != curNo )
            	{
            		if(objDrwContent[lastNo] && objDrwContent[lastNo].style){
            			objDrwContent[lastNo].style.display = "none";
            		}
            		if(objDrwContent[curNo] && objDrwContent[curNo].style){
	            		objDrwContent[curNo].style.display = "inline";
            		}
            		objMem.curNo = curNo;
            	}
            	else
            		return;
			}
			
			function start()
			{
				defDrawerHegiht();
				//correctPNG();
				collaspe("show");
			}

			
			function chgFont()
			{
				var chgF = document.all("chgF");
				var pic = document.all("pic");
				if(chgF != null)
				{
					for(var i=0;i<chgF.length;i++)
					{
						if(event.srcElement == chgF[i]||event.srcElement == pic[i])
						{
							chgF[i].className = "drwItemBold";
						}
						else
						{
							chgF[i].className = "drwItem";
						}
					}
				}	
			}
			function setFastMenu(){
				if(showDialog("${basePath}/myMenu/getMyMenu.action", "", 580, 600)){
					frm.action="${basePath}/menu/menuList.action";
					frm.submit();
				};
				}
</script>
<style>
.a {
	font-weight: bold;
}

.b {
	font-weight: normal;
}

.webfx-tree-item1 {
	font-size: 13px; line-height: 25px; color: #26548B;
}
</style>
</head>
<body class="leftframe" onLoad="start();" onselectstart="return false">
	<form action="" method="post" name="frm" id="frm"></form>
	<div id="div_BackGround">
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" align="right">
			<tr height="100%">
				<td></td>
			</tr>
			<tr height="25">
				<td>
					<table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
						<tr>
							<td align="center" valign="middle"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div id="div_Drawer">
		<div id="div_entry" align="left" onClick="collaspe();" curstatus="hide">
			<img src="${skinPath}/image/frame/menu/menu_top.gif" />
		</div>
		<div style="clear: both;"></div>
		<div id="div_Container" align="left">
			<c:set var="pictureLayerNumber" value="0" />
			<div class="leftMenu_div">
				<div id="div_drw_Panel" align="left" curDrwNo="0" onClick="drwSwitch();">
					&nbsp; <a><img src="<%=skinPath%>/image/frame/menu/06.gif" align="top" curDrwNo="0" /> </a> &nbsp;我的菜单&nbsp;&nbsp;
				</div>
				<div id="div_drw_Content" style="display: none;">
					<DIV id=tree></DIV>
				</DIV>
				<DIV onclick=drwSwitch(); id=div_drw_Panel align=left curDrwNo="1">
					&nbsp; <A><IMG src="<%=basePath%>/mgr/skinstyle/default/image/frame/menu/06.gif" align=top curDrwNo="1"> </A>&nbsp;发售管理
				</DIV>
				<div id="div_drw_Content" style="display: inline;">
					<DIV id=tree>
					<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 运营管理","");</SCRIPT>

						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("交易状态管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/trade/systemManager.jsp");
									M01.add(M0101);</SCRIPT>

                        <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("结算处理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/trade/tradeSettle.jsp");
									M01.add(M0101);</SCRIPT>

						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						        	
						<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 交易参数设置","");</SCRIPT>
                     
                        <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("交易节管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/TradetimeController/getTradeTimeForward");
									M01.add(M0101);</SCRIPT>
						
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("商品管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/CommodityManage");
									M01.add(M0101);</SCRIPT>
						
						 <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("非交易日设置,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/TradetimeController/getNottradedayforward");
									M01.add(M0101);</SCRIPT>

						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 发行管理","");</SCRIPT>

						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("发行摇号,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/QueryController/IssuedManage");
									M01.add(M0101);</SCRIPT>

						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("申购成交,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/QueryController/ApplySuccManage");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("付发行商货款,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif",<%=basePath%>/mgr/app/pubManager/publish_goods.jsp");
									M01.add(M0101);</SCRIPT>

						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						        	
						        	
						<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 数据查询","");</SCRIPT>

						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("商品查询,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/CommodityQuery");
									M01.add(M0101);</SCRIPT>

						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						        	
						        	
						<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 承销会员查询","");</SCRIPT>

						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("商品查询,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/underwritingQuery/commodityinfo.jsp");
									M01.add(M0101);</SCRIPT>

						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						        	
						        	
						<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 承销会员认购管理","");</SCRIPT>

						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("承销设置,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/underwritingManage/underwritingSet.jsp");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("承销贷款押金,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/underwritingManage/loanDeposit.jsp");
									M01.add(M0101);</SCRIPT>			

						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 发行会员管理","");</SCRIPT>

						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("产品发行查询,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/publisherQuery/commPubQuery.jsp");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("发行货款跟踪,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/publisherQuery/paymentTracking.jsp");
									M01.add(M0101);</SCRIPT>			
									
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("承销会员查询,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/publisherQuery/underwriterQuery.jsp");
									M01.add(M0101);</SCRIPT>
									
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("发行商转持仓,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/publisherQuery/transferPosition.jsp");
									M01.add(M0101);</SCRIPT>		

						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						        	        	
						        	
						 <SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 交收管理","");</SCRIPT>
                        <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("交收属性管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/delivery/deliveryProps.jsp");
									M01.add(M0101);</SCRIPT>
                       
                        <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("入库单审核,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/StorageApprove");
									M01.add(M0101);</SCRIPT>
									
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("查询入库单,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/StorageQuery");
									M01.add(M0101);</SCRIPT>
									
						 <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("出库单权限查询,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/OutboundQuery");
									M01.add(M0101);</SCRIPT>	
									
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("提货单审核,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/DeliveryApprove");
									M01.add(M0101);</SCRIPT>

                        <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("提货单注销,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/DeliveryCancel");
									M01.add(M0101);</SCRIPT>
									
						 <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("注册提货单查询,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/IpoController/DeliveryQuery");
									M01.add(M0101);</SCRIPT>
                         <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("库存查询,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/delivery/stockQuery.jsp");
									M01.add(M0101);</SCRIPT>


						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>       	
						        	
						 <SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 申请托管管理","");</SCRIPT>
                        <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("托管计划管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/trusteeship/plan.jsp");
									M01.add(M0101);</SCRIPT>
									
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("托管仓库管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/trusteeship/trustWarehouse.jsp");
									M01.add(M0101);</SCRIPT>
									 
						 <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("托管申请管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/trusteeshipCommodityController/apply");
									M01.add(M0101);</SCRIPT>	
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("托管转持仓,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/trusteeshipCommodityController/turnToPosition");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("返还申请人货款,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/trusteeshipCommodityController/returnGoods");
									M01.add(M0101);</SCRIPT>			
						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>
						        	
						<SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 增发业务","");</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("增发商品管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/SPO/rationInfo.jsp");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("定向配售管理,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/SPO/ppPlacingManage.jsp");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("付发行商货款,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif",<%=basePath%>/mgr/app/SPO/increase_publish_goods.jsp");
									M01.add(M0101);</SCRIPT>			
									
						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>        	          	
						        	
						        	
						 <SCRIPT type=text/javascript>
								var M01;
								var M0101;
								M01 = new WebFXTree("<img src='<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/42_42.gif'> 配置管理","");</SCRIPT>
                        <SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("费用项配置,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/chargeitem/index.jsp");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("一般费用配置,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/chargerole/index.jsp");
									M01.add(M0101);</SCRIPT>
						<SCRIPT type=text/javascript>
									M0101 = new WebFXTreeItem("特殊费用配置,<%=basePath%>/mgr/skinstyle/default/image/app/timebargain_mgr/menu/29_29.gif","<%=basePath%>/mgr/app/chargeuser/index.jsp");
									M01.add(M0101);</SCRIPT>
									
						<SCRIPT type=text/javascript>
						        	document.write(M01);</SCRIPT>       
						        	
						        	    	
					</DIV>
				</DIV>
			</DIV>
			<DIV class=menu_bottom></DIV>
		</div>
		<c:if test="${pictureLayerNumber==0 }">
			<div>
				<div id="div_drw_Content" align="center" class="div_drwContent" style="display: none;"></div>
				<div id="div_drw_Panel" align="center" class="div_drwContent" style="display: none;"></div>
			</div>
		</c:if>
		<c:if test="${fn:length(myMenuList)>0}">
			<span id="span_curstatus" curNo="0" style="display: none;"></span>
		</c:if>
		<c:if test="${fn:length(myMenuList)==0}">
			<span id="span_curstatus" curNo="1" style="display: none;"></span>
		</c:if>
</body>
</html>