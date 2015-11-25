<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>

<html>
  <head>
    <title>�޸�������Ʒ����������</title>
	  <link rel="stylesheet" href="${skinPath }/css/validationengine/validationEngine.jquery.css" type="text/css" />
	  <link rel="stylesheet" href="${skinPath }/css/validationengine/template.css" type="text/css" />
	  <script src="${publicPath }/js/jquery-1.6.min.js" type="text/javascript"></script>
	  <script src="${publicPath }/js/validationengine/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="GBK"></script>
	  <script src="${publicPath }/js/validationengine/jquery.validationEngine.js" type="text/javascript" charset="GBK"></script>
		
	  <script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery("#frm").validationEngine('attach');
			// �޸İ�ťע�����¼�
			$("#update").click(function(){
				// ��֤��Ϣ
				if(jQuery("#frm").validationEngine('validate')){
					
					var vaild = affirm("��ȷ��Ҫ������");
					if(vaild){
						// �޸���ϢURL
						var updateUrl = $(this).attr("action");
						// ȫ URL ·��
						var url = "${basePath}" + updateUrl;
						$("#frm").attr("action",url);
						$("#frm").submit();
					}
				}
			});

			
		});
	  </script>
	
    <script type="text/javascript">

      //���������ֺ�.
	  function onlyDoubleInput()
	  {
	    if (event.keyCode<46 || event.keyCode>57 || event.keyCode == 47)
	    {
	      event.returnValue=false;
	    }
	  } 

      function on_change(){
    		
    		if ($("#settleFeeAlgr").val() == "1") {
    		
    			$("#settleFeeRate_BPercent").show();
    			$("#settleFeeRate_SPercent").show();
    			
    		}else {
    			$("#settleFeeRate_BPercent").hide();
    			$("#settleFeeRate_SPercent").hide();
    			
    		}
    	}

    	 function window_load(){
    	   	   
    		 on_change();
    	 }
    </script>
  </head>
  <body onload="window_load()">
	<form id="frm" name="frm" method="post" enctype="multipart/form-data" action="" targetType="hidden" >

	  <div class="div_cx">
		<table border="0" width="100%" align="center">
		  <tr>
		    <td>
			  <div class="warning">
			    <div class="content">
			               ��ܰ��ʾ :�޸����⽻��������
				</div>
			  </div>
			</td>
		  </tr>
		  <tr>
		    <td>
			  <table border="0" width="100%" align="center">
			   
			    <tr>
				  <td>
				    <div class="div_cxtj">
					  <div class="div_cxtjL"></div>
					  <div class="div_cxtjC">
						������Ϣ
					  </div>
					  <div class="div_cxtjR"></div>
					</div>
					<div style="clear: both;"></div>
				    <div>
					  <table border="0" cellspacing="0" cellpadding="10" align="center" class="table2_style">
					    <tr>
		          		  <td align="right">�����̴��룺</td>   
						  <td>
							 ${entity.firmID}
                		    <input type="hidden" id="firmID" name="entity.firmID" value="${entity.firmID}" />
						  </td>
						  
            			  <td align="right">��Ʒ���룺</td>   		   
            			  <td>
							 ${entity.commodityID}
                		    <input type="hidden" id="commodityID" name="entity.commodityID" value="${entity.commodityID}" />
						  </td>
							           
						</tr>
					  </table>
				   	</div>
				  </td>
			    </tr>
				
				<tr>  
				  <td>
				  
				    <div class="div_cxtj">
					  <div class="div_cxtjL"></div>
					  <div class="div_cxtjC">
						������
					  </div>
					  <div class="div_cxtjR"></div>
					</div>
					<div style="clear: both;"></div>
				    <div>
			      
					  <table border="0" cellspacing="0" cellpadding="0"  class="table2_style" align="center">
					    <tr>
			              <td>
			              
                            <table cellSpacing="0" cellPadding="10" border="0" align="center" class="common"> 
								<tr > 		            
		            			  <td colspan="2">			
		            				<span >�����������㷨��
		            				  <select id="settleFeeAlgr" name="entity.settleFeeAlgr" onchange="on_change()" class="validate[required]">
										<option value="">��ѡ��</option>
					                    <c:forEach items="${algrMap}" var="map" >
									       <option value="${map.key}">${map.value}</option>
									    </c:forEach>
			   						  </select> 
			   						  <span class="required">*</span>  
									</span>
									<script type="text/javascript">
									   document.getElementById("settleFeeAlgr").value = ${entity.settleFeeAlgr};
									</script>		
								  </td>	
								</tr>  
								<tr>          		            
		            			  <td align="right" >������
		            			    <input id="settleFeeRate_B" name="entity.settleFeeRate_B" value="${entity.settleFeeRate_B }"
		            					   onkeypress="return onlyDoubleInput()" class="validate[required,maxSize[15],custom[onlyDoubleSp]] input_text"  />
			  						<span id="settleFeeRate_BPercent">%</span><span class="required">*</span>
			  					  </td>
			  					  <td align="right" >��������
			  					     <input id="settleFeeRate_S" name="entity.settleFeeRate_S" value="${entity.settleFeeRate_S }"
			  							    onkeypress="return onlyDoubleInput()" class="validate[required,maxSize[15],custom[onlyDoubleSp]] input_text"  />
			  						 <span id="settleFeeRate_SPercent">%</span><span class="required">*</span>  
			  					  </td>
		    					</tr>							
	                       </table>  
					
				         </td>
				       </tr>
			         </table>
			       </div> 
			       
			     </td>
		       </tr>
		</table>
	  </div>
	  <div class="tab_pad">
	    <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
		  <tr>
		    <td align="center">
			  <rightButton:rightButton name="�޸�" onclick="" className="btn_sec" action="/timebargain/firmSet/commoditySpecial/updateSettleFee.action" id="update"></rightButton:rightButton>
			  &nbsp;&nbsp;
			  <button class="btn_sec" onClick="window.close();">�ر�</button>
		    </td>
		  </tr>
	    </table>
	  </div>
    </form>
  </body>
</html>
<%@ include file="/mgr/public/jsp/footinc.jsp"%>