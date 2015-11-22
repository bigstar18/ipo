<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<script type="text/javascript" src="<%=publicPath%>/js/xtree.js"></script>
<link rel="stylesheet" href="<%=skinPath%>/css/xtree.css" type="text/css"/>
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
			    //�����ں�Сʱ,�˵�������ȫ��ʾ,����ʱ�ô������
			    //top.moveTo(0,0);
				//top.resizeTo(screen.availWidth,screen.availHeight);
				var objBackGround = document.getElementById( "div_BackGround" );
				var objContainer = document.getElementById( "div_Container" );
				var bottomPosition = objBackGround.getBoundingClientRect().bottom;
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
            		objDrwContent[lastNo].style.display = "none";
            		objDrwContent[curNo].style.display = "inline";
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
			//�޸�����
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
	font-size: 13px;
	line-height: 25px;
	color: #26548B;
}
</style>
	</head>
	<body class="leftframe" onLoad="start();" onselectstart="return false">
		<form action="" method="post" name="frm" id="frm"></form>
		<div id="div_BackGround">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0" align="right">
				<tr height="100%">
					<td></td>
				</tr>
				<tr height="25">
					<td>
						<table border="0" cellspacing="0" cellpadding="0" width="100%"
							height="100%">
							<tr>
								<td align="center" valign="middle"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id="div_Drawer">
			<div id="div_entry" align="left" onClick="collaspe();"
				curstatus="hide">
				<img src="${skinPath}/image/frame/menu/menu_top.gif" />
			</div>
			<div style="clear: both;"></div>
			<div id="div_Container" align="left">
				<c:set var="pictureLayerNumber" value="0" />
				<div class="leftMenu_div">
					<div id="div_drw_Panel" align="left" curDrwNo="0"
						onClick="drwSwitch();">
						&nbsp;
						<a><img src="<%=skinPath%>/image/frame/menu/06.gif"
								align="top" curDrwNo="0" />
						</a> &nbsp;�ҵĲ˵�&nbsp;&nbsp;
						<a href="#" onclick="setFastMenu();"><span style="font-size: 12; text-decoration: none;" curDrwNo="0">�޸�����</span>
						</a>
					</div>
					<div id="div_drw_Content" style="display: inline;">
					<div id="tree">
						<script type="text/javascript">
							         var M01;
							         var M0101;
							         M01 = new WebFXTree("<img src='http://10.0.100.182:10061/ipo_mgr/mgr/skinstyle/gray/image/app/ipo_mgr/menu/42_42.gif'> ���ײ�������","");
						</script>
						<script type="text/javascript">
									M0101 = new WebFXTreeItem("���׽ڹ���,http://10.0.100.182:10061/ipo_mgr/mgr/skinstyle/gray/image/app/ipo_mgr/menu/29_29.gif","http://10.0.100.182:10061/ipo_mgr/IpoController/tradeTimeManage");
									M01.add(M0101);
						</script>
						<script type="text/javascript">
									M0101 = new WebFXTreeItem("��Ʒ����,http://10.0.100.182:10061/ipo_mgr/mgr/skinstyle/gray/image/app/ipo_mgr/menu/29_29.gif","http://10.0.100.182:10061/ipo_mgr/IpoController/CommodityManage");
									M01.add(M0101);
						</script>
						<script type="text/javascript">document.write(M01);</script>
						<div class="webfx-tree-item" id="webfx-tree-object-5" style="padding-top: 1px; padding-bottom: 1px; cursor: hand;" 
						onkeydown="return webFXTreeHandler.keydown(this, event)" onclick="webFXTreeHandler.toggle(this);" onselectstart="return false">
						<img class="webfx-tree-icon2" id="webfx-tree-object-5-icon" onclick="webFXTreeHandler.select(this);" onselectstart="return false" src="../mgr/skinstyle/gray/image/frame/menu/xtree_gif_05.gif">
						<span id="webfx-tree-object-5-anchor" onfocus="webFXTreeHandler.focus(this);" onblur="webFXTreeHandler.blur(this);" target="mainSwitch">
						<img src="http://10.0.100.182:10061/ipo_mgr/mgr/skinstyle/gray/image/app/ipo_mgr/menu/42_42.gif"> ���ײ�������</span>
						</div>	
						<div class="webfx-tree-container" id="webfx-tree-object-5-cont" style="display: block;">
						
                        <div class="webfx-tree-item" id="webfx-tree-object-7" onkeydown="return webFXTreeHandler.keydown(this, event)">
                        <img id="webfx-tree-object-7-plus" ondblclick="webFXTreeHandler.toggle(this);" src="../mgr/skinstyle/gray/image/frame/menu/xtree_T1.gif">
                        <img class="webfx-tree-icon1" id="webfx-tree-object-7-icon" onclick="webFXTreeHandler.select(this);" onselectstart="return false" src="http://10.0.100.182:10061/ipo_mgr/mgr/skinstyle/gray/image/app/ipo_mgr/menu/29_29.gif">
                        <span title="���׽ڹ���" onclick="goto('http://10.0.100.182:10061/ipo_mgr/IpoController/tradeTimeManage','���׽ڹ���','���ײ�������')">
                        <a name="third" id="webfx-tree-object-7-anchor" style="font-size: 12px;" onfocus="webFXTreeHandler.focus(this);" onblur="webFXTreeHandler.blur(this);" href="javascript:void(0)">���׽ڹ���</a></span></div>							
						<div class="webfx-tree-container" id="webfx-tree-object-7-cont" style="display: none;"></div>
						
						<div class="webfx-tree-item" id="webfx-tree-object-8" onkeydown="return webFXTreeHandler.keydown(this, event)">
						<img id="webfx-tree-object-8-plus" ondblclick="webFXTreeHandler.toggle(this);" src="../mgr/skinstyle/gray/image/frame/menu/xtree_T1.gif">
						<img class="webfx-tree-icon1" id="webfx-tree-object-8-icon" onclick="webFXTreeHandler.select(this);" onselectstart="return false" src="http://10.0.100.182:10061/ipo_mgr/mgr/skinstyle/gray/image/app/ipo_mgr/menu/29_29.gif">
						<span title="��Ʒ����" onclick="goto('http://10.0.100.182:10061/ipo_mgr/IpoController/CommodityManage','��Ʒ����','���ײ�������')">
						<a name="third" id="webfx-tree-object-8-anchor" style="font-size: 12px;" onfocus="webFXTreeHandler.focus(this);" onblur="webFXTreeHandler.blur(this);" href="javascript:void(0)">��Ʒ����</a></span></div>	
						<div class="webfx-tree-container" id="webfx-tree-object-8-cont" style="display: none;"></div>	
                        </div>
                        </div>
                        </div>
			<div class="menu_bottom"></div>
		</div>
	<span id="span_curstatus" curNo="0" style="display: none;"></span>
	</body>
</html>