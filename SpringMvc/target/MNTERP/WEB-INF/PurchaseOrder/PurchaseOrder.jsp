
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ page import="java.util.*,org.codehaus.jackson.type.TypeReference,com.mnt.erp.bean.AjaxPurchase,org.codehaus.jackson.map.ObjectMapper,java.io.File, com.google.gson.JsonElement,com.google.gson.JsonParser" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>

<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<!--  Date picker -->
<script>
	$(function() {

		$("#dueDate,#addrowdueDate,#purchaseOrderDate,#cDueDate").datepicker();
		

	});
</script>



<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<c:url var="purchaseOrderDetails" value="/purchaseOrderDetails.mnt" />
 
<script type="text/javascript">
$(document).ready(function() { 

			
$('#quotationID').change(function() {	
	alert($(this).val());
	
	$.ajax({
        type: "GET",
        url : "/MNTERP/purchaseOrderDetails.mnt",
        data : "quotationId="+$(this).val(), 
        success: function(data) {
        	//alert("data  "+data);
            var raw=JSON.parse(data);
       		response($.map(raw, function(item) {
			// alert(item.vendorId);
			forAddRow(item.count);
			 $("#vendorId"+item.count).val(item.vendorId);
			 $("#materialId"+item.count).val(item.materialId);
			 $("#quantity"+item.count).val(item.qty);
			 $("#unitPrice"+item.count).val(item.unitprise);
			 $("#lineAmt"+item.count).val(item.lineamount);
			 $("#uom"+item.count).val(item.uom);
			 $("#currencyId"+item.count).val(item.currencyId);
			 
			 
		   
          }));
		    
           }
       });
	

	
	
		});
}); 
		
		
function globalAutoComplete(urlData)
{
	//alert("1      "+urlData+"   "+$('#materialName').val());
               $("#materialName").autocomplete({
	 			minLength:1,
               source: function( request, response ) {
               $.ajax({
                    type: "POST",
                    url : urlData,
                    //"/MNTERPA/materialIdAutoInit.mnt"
                    data : "materialIdAuto="+$("#materialName").val(), 
                    success: function(data) {
                    var raw=JSON.parse(data);
                   // alert(raw);
					 response($.map(raw, function(item) {
					    return {
                              label : item.MaterialName,
                              value : item.MaterialName,
                              ex:item.Id
                          }
                      }));
					    
                       }
                   });
               }, select: function(event, ui) {
					    //alert(ui.item.value);
					       $("#materialId").val(ui.item.ex);
					    }
               
            
           });
           
           }

</script>
<script>
	$(function() {
		$("#tabs").tabs();

	});

	$(function() {
		$("#tabsForAdd").tabs();
	});
	$(function() {
		$("#tabsForEdit").tabs();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#tabsForEdit").hide();
			$("#warningmesssage").hide();

		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("aid").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});
</script>


<!-- Horizantol scroll -->

<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 100%;
}
</style>

 <!-- Horizantol scroll -->
		<style type="text/css">
		
		#scroll1{
			overflow:auto;
			overflow-y:hidden;
			overflow-x:scroll;
			width:49%;
			
			
					
		}
		
		</style> 

<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("aid").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();

		});
	});
</script>


              
<script type="text/javascript">
	function multiply() {
		var quantity = document.getElementById("quantity");
		var unitPrice = document.getElementById("unitPrice");
		var result = quantity.value * unitPrice.value;
		document.getElementById("lineAmount").value = result;

	}
</script>
</head>

<body>


	<div class="divUserDefault">
		<div class="PageTitle">Purchase Order</div>

		<!-- Tabs Declaration -->
		<div id="scroll">
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<%--  <c:forEach var="quotationEditList" items="${quotationEditList}"> 
			       <c:set var="quotationEditList" value="${quotationEditList }"></c:set>
				</c:forEach>
				<c:if test="${quotationEditList!=null}">
			  
				   <li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
			    </c:if> --%>
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
				</ul>

				<!-- Search tab part -->

				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">
						<form:form action="purchaseOrderHome.mnt" method="GET"
							commandName="purchaseOrderCommand">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td>Purchase Order Id</td>
									<td><form:input path="quotationId" /></td>
									<td><input type="submit" value="Search"
										class="btn btn-primary" /></td>
								</tr>
							</table>
						</form:form>

					</div>
				</div>

				<!-- Add tab details -->

				
					<div id="tabs-3" class="TabbedPanelsContent">
						<div align="left" class="TabbedPanelsContent">
						<form:form action="PurchaseOrderAdd.mnt" method="GET"
					commandName="purchaseOrderCommand">
							<table>
								<tr>
									<td>Purchase Order No</td>
									<td><form:input path="purchaseOrderNo"
											id="purchaseOrderNo" class="textbox" /></td>
									<td>Purchase Order Date</td>
									<td><form:input path="purchaseOrderDate"
											id="purchaseOrderDate" class="textbox" /></td>
								</tr>
								<tr>
									<td>Purchase Order Value</td>
									<td><form:input path="purchaseOrderValue"
											id="purchaseOrderValue" class="textbox" /></td>
									<td>Purchase Order Status</td>
									<td><form:select path="purchaseOrderStatus"
											id="purchaseOrderStatus" class="select">
											 <form:option value="0">-Select-</form:option>
											<form:options items="${status }" />
										</form:select></td>
								</tr>
								<tr>
									<td>Description</td>
									<td><form:textarea path="description" id="description"
											class="textarea" /></td>
									<td>Memo</td>
									<td><form:textarea path="memo" id="memo" class="textarea" /></td>
								</tr>
								<tr>
									<td>Quotation</td>
									<td><form:select path="quotationId" id="quotationID"
											class="select" >
											 <form:option value="0">-Select-</form:option>
											<form:options items="${quotation }" />
										</form:select></td>
									<td>Payment Terms</td>
									<td><form:select path="paymentTerms" id="paymentTerms"
											class="select">
											 <form:option value="0">-Select-</form:option>
											<form:options items="${paymentTerm }" />
										</form:select></td>
								</tr>
								<tr>
									<td>Vendor</td>
									<td><form:select path="vendorId" id="vendorId"
											class="select">
										 <form:option value="0">-Select-</form:option>
											<form:options items="${vendor }" />
										</form:select></td>
									<td>Currency Code</td>
									<td><form:select path="currencyCode" id="currencyCode"
											class="select">
											 <form:option value="0">-Select-</form:option>
											<form:options items="${ccode }" />
										</form:select></td>
								</tr>
								<tr>
									<td>Sales Tax Amount</td>
									<td><form:input path="salesTaxAmt" id="salesTaxAmt"
											class="textbox" /></td>
									<td>Vat Amount</td>
									<td><form:input path="vatAmt" id="vatAmt" class="textbox" />
									</td>
								</tr>
								<tr>
									<td>Excise Amount</td>
									<td><form:input path="exciseAmt" id="exciseAmt"
											class="textbox" /></td>
									<td>Frieght Charges</td>
									<td><form:input path="frieghtCharges" id="frieghtCharges"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>PNF Charges</td>
									<td><form:input path="pnFCharges" id="pnFCharges"
											class="textbox" /></td>
									<td>Due Date</td>
									<td><form:input path="dueDate" id="dueDate"
											class="textbox" /></td>
								</tr>
								


							</table>
						 <div id="tabsForAdd">
								<ul>
									<li><a href="#tabs-1">Purchase Order Line</a></li>

								</ul>
								
								
								<div id="tabs-1">
									<div  align="left">
									
										 <div id="scroll1">
										<table class="table">
											<tr>
												<th>Line Number<font color="red">*</font>
												</th>
												<th>Material</th>
												<th>Quantity<font color="red">*</font>
												</th>
												<th>Unit Price<font color="red">*</font>
												</th>
												<th>Line Amount<font color="red">*</font>
												</th>
												<th>Uom<font color="red">*</font>
												</th>
												<th>Currency Code<font color="red">*</font>
												</th>
												<th>Sales Tax Amount</th>
												<th>Vat Amount</th>
												<th>Excise Amount</th>
												<th>Frieght Charges</th>
												<th>PNF Charges</th>
												<th>Due Date</th>
											  </tr>
											  
											  <tr id="x"></tr>
												<tr>
												
													<td><form:input path="lineNumber" id="lineNumber" class="textbox" />
													
													</td>
													<td><form:select cssStyle="height:22px" path="materialId" id="materialId" class="textbox" >
													<option value="0">select</option>
													
													<form:options items="${materialId}" />
													</form:select></td>
													
													<td><form:input path="quantity"  id="quantity" class="textbox" /></td>
													<td><form:input path="unitPrice" id="unitPrice" class="textbox" /></td>
													<td><form:input path="lineAmt" id="lineAmt" class="textbox" /></td>
													<td><form:input path="uom" id="uom" class="textbox" /></td>
													<td><form:input path="currencyCode" id="currencyCode" class="textbox" /></td>
													<td><form:input path="salesTaxAmt" class="textbox" /></td>
													<td><form:input path="vatTaxAmt" class="textbox" /></td>
													<td><form:input path="exciseAmt" class="textbox" /></td>
													<td><form:input path="frieghtCharges" class="textbox" /></td>
													<td><form:input path="pnfCharges" class="textbox" /></td>
													<td><form:input path="dueDate" id="cDueDate"class="textbox" /></td>

													<td><a href="#" id="addoc"><img
															src="images/add (1).png"></img></a> <script
															src="http://code.jquery.com/jquery-1.8.2.js"></script> <script
															src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

														<script type="text/javascript">
														function forAddRow(id)
														{
															alert("came "+id)
															var options = '<table style="width:100px"><tr><td><table class="table" >'
																 +'<tr>'
																 +'<td><form:input path="lineNumber" id="lineNumber'+id+'" class="textbox" /></td>'
																 +'<td><form:select  path="materialId" id="materialId'+id+'" class="textbox" ><option value="0">select</option><form:options items="${materialId}" /></form:select></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.quantity"><input name="quantity" id="quantity'+id+'"  class="textbox"  /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.unitPrice"><input name="unitPrice" id="unitPrice'+id+'" class="textbox" /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.lineAmt"><input name="lineAmt" id="lineAmt'+id+'" class="textbox" /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.uom"><input name="uom" id="uom'+id+'" class="textbox" /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.currencyId"><input name="currencyId" id="currencyId'+id+'" class="textbox" /></spring:bind></td>'
																 +'<td><form:input path="salesTaxAmt" class="textbox" /></td>'
																 +'<td><form:input path="vatTaxAmt" class="textbox" /></td>'
																 +'<td><form:input path="exciseAmt" class="textbox" /></td>'
																 +'<td><form:input path="frieghtCharges" class="textbox" /></td>'
																 +'<td><form:input path="pnfCharges" class="textbox" /></td>'
																 +'	<td><form:input path="dueDate" id="addrowdueDate" class="datepicker1 textbox" /></td>'
																 +'</td></tr></table>'
																 +'<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
																
																					$(options).fadeIn("slow").appendTo('#extender');
														}
															
															$(document)
																	.ready(
																			function() {
																				$(function() {

																					//fadeout selected item and remove
																					$(
																							'.remove')
																							.live(
																									'click',
																									function() {
																										$(
																												this)
																												.parent()
																												.fadeOut(
																														300,
																														function() {
																															$(
																																	this)
																																	.empty();
																															return false;
																														});
																									});
																					//alert("came to add")

																					 var options = '<table style="width:100px"><tr><td><table class="table" >'
																					 +'<tr>'
																					 +'<td><form:input path="lineNumber" class="textbox" /></td>'
																					 +'<td><form:input path="materialId" class="textbox" /></td>'
																					 +'<td><form:input path="quantity" class="textbox"  /></td>'
																					 +'<td><form:input path="unitPrice" class="textbox" /></td>'
																					 +'<td><form:input path="lineAmt" class="textbox" /></td>'
																					 +'<td><form:input path="uom" class="textbox" /></td>'
																					 +'<td><form:input path="currencyCode" class="textbox" /></td>'
																					 +'<td><form:input path="salesTaxAmt" class="textbox" /></td>'
																					 +'<td><form:input path="vatTaxAmt" class="textbox" /></td>'
																					 +'<td><form:input path="exciseAmt" class="textbox" /></td>'
																					 +'<td><form:input path="frieghtCharges" class="textbox" /></td>'
																					 +'<td><form:input path="pnfCharges" class="textbox" /></td>'
																					 +'	<td><form:input path="dueDate" id="addrowdueDate" class="datepicker1 textbox" /></td>'
																					 +'</td></tr></table>'
																					 +'<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
																						//add input
																					$('#addoc')
																							.click(
																									function() {
																										$(options).fadeIn(
																														"slow")
																												.appendTo(
																														'#extender');
																										//	alert("affk");
																										i++;
																										return false;
																									});
																					 $('.datepicker').live('click', function() {
																					        $(this).datepicker('destroy').datepicker().focus();
																					    });
																					    $('.datepicker1').live('click', function() {
																					        $(this).datepicker('destroy').datepicker().focus();
																					    });
																				});

																				
																			});
														</script></td>
												</tr>
												
												
	                                          
											</table>
											<div id="extender"></div>
									</div>
								</div>
							</div>
							</div>

						 
						<input type="submit" value="Save" name="Save"  class="btn btn-primary"/><input type="reset" class="btn btn-primary"/>	
			  	     </form:form>
			  	     </div>
					</div>
				

				<!-- Edit tab -->
			</div>
		</div>
	</div>

</body>

</html>




