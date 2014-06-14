<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'debitNote.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="css/jquery-ui.css" />
<link rel="stylesheet" href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#tabs,#tabss,#edittabs").tabs();
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addDebitForm')
													.validate(
															{
																rules : {
																	debitNoteNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	debitNoteDT : {
																		required : true

																	},
																	custInvoiceId : {
																		required : true
																	},
																	vendorInvoiceId : {
																		required : true
																	}
																											

																},
																messages : {
																	debitNoteNo : {
																		required:"<font style='color: red;'><b>Debit Note No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	debitNoteDT : "<font style='color: red;'><b>Debit Note Date is Required</b></font>",
																	custInvoiceId : "<font style='color: red;'><b>Customer Invoice is Required</b></font>",
																	vendorInvoiceId : "<font style='color: red;'><b>Vendor Invoice is Required</b></font>"
																	
																	
																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editDebitForm')
													.validate(
															{
																rules : {
																	edebitNoteNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	edebitNoteDT : {
																		required : true

																	},
																	ecustInvoiceId : {
																		required : true
																	},
																	evendorInvoiceId : {
																		required : true
																	}
														
																},
																messages : {
																	edebitNoteNo : {
																		required:"<font style='color: red;'><b>Debit Note No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	edebitNoteDT : "<font style='color: red;'><b>Debit Note Date is Required</b></font>",
																	ecustInvoiceId : "<font style='color: red;'><b>Customer Invoice is Required</b></font>",
																	evendorInvoiceId : "<font style='color: red;'><b>Vendor Invoice is Required</b></font>"
																	
																	
																},
															});

										});

					});
</script>
	<script type="text/javascript">
function dateFun(datePattern) {
	$('#debitDate,#debitDateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>


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
function multiplication(){
	var qty=$('#quantity').val();
	var pUnit=$('#perUnit').val();
	var res=qty*pUnit;
	document.getElementById("netPrice").value=res;
	
}

function multiplicationEdit(){
	var qty=$('#quantityEdit').val();
	var pUnit=$('#perUnitEdit').val();
	var res=qty*pUnit;
	document.getElementById("netPriceEdit").value=res;
	
}


	function AjaxForDuplicate() {
		var debit = $('#debitNoteNo').val();
		//alert(debit);
				$.ajax({
					type : "POST",
					url : "checkDNAddDuplicate.mnt",
					data : "debitNoteNo=" + debit,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesDuplMessage").style.display = "block";
							//$('#salesDuplMessage').html(response);
							$('#submitid').hide();

						} else {
							document.getElementById("salesDuplMessage").style.display = "none";
							$('#submitid').show();
						}

					},
					error : function(e) {
						//alert('Error' + e);
					}

				});

	}

	function AjaxUpdateDuplicate() {
		var cust = $('#edebitNoteNo').val();
		var id = $('#edebitNoteId').val();
		//alert(id);
				$.ajax({
					type : "POST",
					url : "checkDNUpdateDuplicate.mnt",
					data : "edebitNoteNo=" + cust + "&dnId=" + id,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesUpDuplMessage").style.display = "block";
							//$('#salesUpDuplMessage').html(response);
							$('#updateid').hide();

						} else {
							document.getElementById("salesUpDuplMessage").style.display = "none";
							$('#updateid').show();
						}

					},
					error : function(e) {
						//alert('Error' + e);
					}

				});

	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#basicSearchId').focus();
			$('#debitNoteNo').focus();

		});
	});
</script>
</head>
<body>
<div class="divUserDefault">
		<div class="PageTitle">Debit Note</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:forEach var="dNoteEditList" items="${dNoteEditList}">
					<c:set var="dNoteEditList" value="${dNoteEditList }"></c:set>
				</c:forEach>
				
				<c:if test="${dNoteEditList!=null}">

					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:if>

				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!-- Tab-2 -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form method="get" action="debitNoteSearch.mnt"
						commandName="debitNoteCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addDNsus"
										items="${param.addDNsus}">
										<div class="alert-success" id="savemessage">
												<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.dnote" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="addDNFail"
										items="${param.addDNFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.dnote" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateDNsus"
										items="${param.UpdateDNsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.dnote" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateDNFail"
										items="${param.UpdateDNFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.dnote" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteDNsus"
										items="${param.DeleteDNsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.dnote" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteDNFail"
										items="${param.DeleteDNFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.dnote" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" id="basicSearchId" cssClass="textbox" /></td>
								<c:set var="save" value="false"></c:set>
								<c:set var="edit" value="false"></c:set>
								<c:set var="delete" value="false"></c:set>
								<c:set var="update" value="false"></c:set>
								<c:set var="search" value="false"></c:set>
								<fmt:setBundle basename="button" />
								<fmt:message key="label.save" var="messagesav" />
								<fmt:message key="label.search" var="messagesea" />
								<fmt:message key="label.delete" var="messagedel" />
								<fmt:message key="label.update" var="messageup" />
								<fmt:message key="label.edit" var="messageed" />

								<c:forEach items="${sessionScope.privilegeList}"
									var="privileges">

									<c:choose>
										<c:when test="${privileges eq messagesav }">
											<c:set var="save" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messagesea }">
											<c:set var="search" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messagedel }">
											<c:set var="delete" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messageed }">
											<c:set var="edit" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messageup}">
											<c:set var="update" value="true"></c:set>
										</c:when>
									</c:choose>
								</c:forEach>

								<c:choose>
									<c:when test="${true}">
										<td><input type="submit"
											value="<spring:message code="label.search"/>"
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" disabled="disabled"
											value="<spring:message code="label.search"/>"
											class="btn btn-danger" /></td>
									</c:otherwise>
								</c:choose>
							</tr>

						</table>
					</form:form>
					
						<c:if test="${DNList!=null }">
							<display:table name="DNList" id="DNIdList" class="table"
								requestURI="debitNoteSearch.mnt" pagesize="5">
								
								<display:column property="debitNoteId" sortable="true"
									title="debitNoteId" media="none" />
									
								<display:column property="debitNoteNo" sortable="true"
									titleKey="label.dnno" media="html" />

								<display:column property="debitNoteDT" sortable="true"
									titleKey="label.dndate" media="html" />
								

								<display:column property="custInvoiceId" sortable="true"
									titleKey="label.dncustinvc" media="html" />
									
								<display:column property="vendorInvoiceId" sortable="true"
									titleKey="label.vendorinvc" media="html" />

								
								<display:column titleKey="label.edit">
								<c:choose>
										<c:when test="${true}">
									<a
										href="debitNoteEdit.mnt?debitNoteId=<c:out value="${DNIdList.debitNoteId}"/> "><img
										src="images/Edit.jpg" width="20px" height="20px" /></a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Edit.jpg" class="btn btn-danger"
												width="20px" height="20px" /></a>
										</c:otherwise>
									</c:choose>
								</display:column>
								<display:column titleKey="label.delete">
								<c:choose>
										<c:when test="${true}">
									<a
										href="debitNoteDelete.mnt?debitNoteId=<c:out value="${DNIdList.debitNoteId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Delete.jpg" class="btn btn-danger"
												width="20px" height="20px" /></a>
										</c:otherwise>
									</c:choose>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" />

							</display:table>
						</c:if>
				</div>

			</div>

			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2"  id="salesDuplMessage"
								style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.dnno" />
									<spring:message code="label.duplicateCheck" />
								</div>
								</td>
						</tr>
					</table>
					<form:form action="debitNoteAdd.mnt" method="POST"
						commandName="debitNoteCmd" id="addDebitForm">
						
						<table class="tableGeneral">
							<tr>
								<td>

									<table class="tableGeneral">
										
										<tr>
											<td><spring:message code="label.dnno" /><span
												class="required">*</span></td>
											<td><form:input path="debitNoteNo" id="debitNoteNo"
													cssClass="textbox" onkeyup="AjaxForDuplicate()" maxlength="50"/></td>
											
										</tr>
										
										<tr>
											<td><spring:message code="label.dndate" /><span
												class="required">*</span></td>
											<td><form:input path="debitNoteDT" cssClass="textbox" id="debitDate"/></td>
											</tr>
										
										<tr>
											<td><spring:message code="label.dncustinvc" /><span
												class="required">*</span></td>
											<td><form:select path="custInvoiceId"
													cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${custInvoiceSelect}" />
												</form:select></td>					
										</tr>

										<tr>
											<td><spring:message code="label.vendorinvc" /><span
												class="required">*</span></td>
											<td><form:select path="vendorInvoiceId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${vendorInvoiceSelect}" />

												</form:select></td>
											
										</tr>
										

									</table>

								</td>

							</tr>

						</table>

						<!-- window 2 -->

						<div id="tabss" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.debitdetail" /></a></li>
							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1">
							
								<!-- Model Pop-up Start-->							
															
							<div align="center">
									<script type="text/javascript">
										var btrid = 1;
										
										$(document).ready(function() {			
																													
											 var matId = $("#materialId"), qty = $("#quantity"), uomId = $("#UOMId"), perUnit = $("#perUnit"),netPrice=$('#netPrice'),debitAmt=$('#debitAmount'),hiddenID = $("#hiddenIdDebitPopUp"),
											
											allFields = $([]).add(matId).add(qty).add(uomId).add(perUnit).add(netPrice).add(debitAmt).add(hiddenID), 
											tips = $(".validateTips");																	
											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 500);
															
											}
												
											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o.addClass("ui-state-error");								
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
											function required(o, n) {
												if (o.val()=='') {
													o
															.addClass("ui-state-error");
													updateTips(n+" is Required");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o.addClass("ui-state-error");							
													updateTips(n);
													return false;
												} else {
													return true;
												}
											} 
											
											function checkAmount(a,b){
												if(a.val()>b.val()){
													a.addClass("ui-state-error");
													updateTips("Debit Amount Must be lessthan Net Price");
													return false;
												}
													else{
														return true;
													}
												
											}
										
											  $("#dialogformDebitNote").dialog(
													
															{
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
															Submit : function() {
																		var bValid = true;
																		allFields
																				.removeClass("ui-state-error");

																 	bValid = bValid
																				&& required(
																						matId,
																						
																						"Material Name");
																		
																		bValid = bValid
																				&& required(
																						uomId,
																					
																						"UOM Name");
																		bValid = bValid
																		&& checkRegexp(
																				qty,
																				/^([0-9.])+$/i,
																				"Quantity is Required And Must be  Number");
																		
																		bValid = bValid
																		&& checkRegexp(
																				perUnit,
																				/^([0-9])+$/i,
																				"Per Unit is Required And Must be  Number");
																		
																		bValid = bValid
																		&& checkRegexp(
																				netPrice,
																				/^([0-9.])+$/i,
																				"Net Price is Required And Must be  Number");
																		bValid = bValid
																		&& checkRegexp(
																				debitAmt,
																				/^([0-9.])+$/i,
																				"Debit Amount is Required And Must be  Number");
																		bValid = bValid && checkAmount(debitAmt,netPrice);
																		

																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID.val() == "0" || hiddenID.val() == "") {					
																				$("#DebitNoteAdd tbody").append(
																																									
																								"<tr id="+btrid+">"
																										+ "<td ><spring:bind path='debitNoteCmd.materialId'><input type='hidden' name='materialId' id='materialId"
																										+ btrid
																										+ "' value="
																										+ matId.val()
																												
																										+ " class='textbox' readonly/></spring:bind> " 
																										+"<input type='text' readonly class='textbox' name='materialName' id='materialName"+btrid+"' value='"+$('#materialId :selected').text()+"'"
																										+"</td>"
																										+ "<td><input name='quantity' id='quantity"
																										+ btrid
																										+ "' value="
																										+ qty
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+ "<td><input type='hidden' name='uomId' id='UOMId"
																										+ btrid
																										+ "' value="
																										+ uomId
																												.val()
																										+ " class='textbox' readonly/>"
																										+"<input type='text' class='textbox' readonly name='uomName' id='uomName"+btrid+"' value='"+$('#UOMId :selected').text()+"'"
																										+"</td>"
																										+ "<td><input name='perUnit' id='perUnit"
																										+ btrid
																										+ "' value="
																										+ perUnit
																												.val()
																										+ " class='textbox' readonly/></td>"	
																										+ "<td><input name='netPrice' id='netPrice"
																										+ btrid
																										+ "' value="
																										+ netPrice
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+"<td><input type='text' name='debitAmount' id='debitAmount"+btrid+"' value='"+debitAmt.val()+"' class='textbox' readonly/></td>"
																										
																										+"<td><a href='#'  onclick='editdebitNoteLine("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removedebitNoteLine("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");

																				btrid++;
																				$(this).dialog("close");
																			}																																									

																			
																			if (hiddenID.val() != "0"){
																					 
																				$('#materialId'+ hiddenID.val()).val(matId.val());	
																				$('#materialName'+ hiddenID.val()).val($('#materialId :selected').text()); 
																				$('#quantity'+ hiddenID.val()).val(qty.val());
																				$('#UOMId'+ hiddenID.val()).val(uomId.val());
																				$('#uomName'+ hiddenID.val()).val($('#UOMId :selected').text()); 
																				$('#perUnit'+ hiddenID.val()).val(perUnit.val());
																				$('#netPrice'+ hiddenID.val()).val(netPrice.val());
																				$('#debitAmount'+ hiddenID.val()).val(debitAmt.val());															
																				$('#hiddenIdDebitPopUp').val("0");																																									
																								
																				$(this).dialog("close");																																								
																								
																			}

																		}

																	},
																	Cancel : function() {
																		$(this).dialog("close");
																																	
																	}
																},
																close : function() {
																	allFields.val("").removeClass("ui-state-error");																												
																					
																}
															}); 
											 
											$('#createAddDebitNote').button().click(function() {
												 												
													$("#dialogformDebitNote").dialog("open");																																																					
													//alert("opened");
												});
								});	
													
										
										
										 function removedebitNoteLine(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editdebitNoteLine(id) {
											//alert("edit row " + id);
											
											$("#dialogformDebitNote").dialog("open");
											$('#materialId').val($('#materialId' + id).val());
											$('#quantity').val($('#quantity' + id).val());
											$('#UOMId').val($('#UOMId' + id).val());
											$('#perUnit').val($('#perUnit' + id).val());
											$('#netPrice').val($('#netPrice' + id).val());
											$('#debitAmount').val($('#debitAmount' + id).val());
													
											$('#hiddenIdDebitPopUp').val(id);
										} 
									</script>

 
									<div id="dialogformDebitNote" align="center" title="<spring:message code="label.debitdetail" />">
										<p class="validateTips" align="center" style="color:blue;">All Form Fields are Required</p>
										<table class="tableGeneral">
										
											<tr>
												<td><spring:message code="label.dndmid" /><span
													class=required>*</span></td>
												<td><form:select path="material_Id" id="materialId"
														class="select" >
														<form:option value="">-Select-</form:option>
													<form:options items="${materialSelect}" />
													</form:select>	</td>
											</tr>
											
											<tr>
												<td><spring:message code="label.dnduid" /> <span
													class=required>*</span></td>
												<td><form:select path="uom_Id" id="UOMId"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${uomSelect}" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndqty" /><span
													class=required>*</span></td>
												<td><form:input path="quantity" id="quantity"
														class="textbox" onblur="multiplication()" maxlength="21"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndperunit" /><span
													class=required>*</span></td>
												<td><form:input path="perUnit" id="perUnit"
														class="textbox" onblur="multiplication()" maxlength="21"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndnetpr" /><span
													class=required>*</span></td>
												<td><form:input path="netPrice" id="netPrice"
														class="textbox" readonly="true"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndamt" /><span
													class=required>*</span></td>
												<td><form:input path="debitAmount" id="debitAmount"
														class="textbox" maxlength="21"/></td>
											</tr>
											
											<tr>																							
											<td><input type="hidden"
													name="hiddenIdDebitPopUp" id="hiddenIdDebitPopUp" value="0" /></td>
											</tr>

										</table>
									</div> 

									<div id="users-DebitNote">
										<table id="DebitNoteAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.dndmid" /></th>
													<th><spring:message code="label.dnduid" /></th>
													<th><spring:message code="label.dndqty" /> </th>
													<th><spring:message code="label.dndperunit" /></th>	
													<th><spring:message code="label.dndnetpr" /></th>	
													<th><spring:message code="label.dndamt" /></th>													
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
									
									<button id="createAddDebitNote" type="button"><spring:message code="label.newdebit" /></button>

								</div>			
									
								
								<!-- Model Pop-up End-->
							</div>
							
							
						</div>
						
						<!-- window 2 -->
							<table>
								<tr>
										<c:choose>
									<c:when test="${true}">
										<td><input type="submit" id="submitid"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="submitid" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:otherwise>
								</c:choose>
								</tr>
							</table>
					</form:form>
				</div>
				
			</div>
			 <!--Edit  Tab-1 -->

			 <div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="salesUpDuplMessage"
								style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.dnno" />
									<spring:message code="label.duplicateCheck" />
								</div>
								</td>
						</tr>
					</table>
					<form:form method="post" action="debitNoteUpdate.mnt"
						commandName="debitNoteCmd" id="editDebitForm">
						<c:forEach var="dNoteEditList" items="${dNoteEditList}">
							<c:set var="editMode" value="${dNoteEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td>
										<div>

											<table class="tableGeneral">
																			
												<form:hidden path="edebitNoteId" id="edebitNoteId" />
												
												<tr>
											<td><spring:message code="label.dnno" /><span
												class="required">*</span></td>
											<td><form:input path="edebitNoteNo" id="edebitNoteNo"
													cssClass="textbox" onkeyup="AjaxUpdateDuplicate()" maxlength="50"/></td>
											
										</tr>
										
										<tr>
											<td><spring:message code="label.dndate" /><span
												class="required">*</span></td>
											<td><form:input path="edebitNoteDT" cssClass="textbox" id="debitDateEdit"/></td>
											</tr>
										
										<tr>
											<td><spring:message code="label.dncustinvc" /><span
												class="required">*</span></td>
											<td><form:select path="ecustInvoiceId"
													cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${custInvoiceSelect}" />
												</form:select></td>					
										</tr>

										<tr>
											<td><spring:message code="label.vendorinvc" /><span
												class="required">*</span></td>
											<td><form:select path="evendorInvoiceId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${vendorInvoiceSelect}" />

												</form:select></td>
											
										</tr>	
											
										
											</table>
										</div>
									</td>
									<td></td>

								</tr>

							</table>

							<!-- window 2 -->

							<div id="tabss" align="left">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.debitdetail" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 10;
											$(function() {

												var matIdEdit = $("#materialIdEdit"), qtyEdit = $("#quantityEdit"), uomIdEdit = $("#UOMIdEdit"), perUnitEdit = $("#perUnitEdit"),netPriceEdit=$('#netPriceEdit'),debitAmtEdit=$('#debitAmountEdit'),hiddenEdit = $("#hiddenIdDebitPopUpEdit"),
												
												allFields = $([]).add(matIdEdit)
														.add(qtyEdit).add(
																uomIdEdit)
														.add(perUnitEdit).add(netPriceEdit).add(debitAmtEdit)					
														.add(hiddenEdit), tips = $(".validateTips");

												function updateTips(t) {
													tips
															.text(t)
															.addClass(
																	"ui-state-highlight");
													setTimeout(
															function() {
																tips
																		.removeClass(
																				"ui-state-highlight",
																				1500);
															}, 500);
												}

												function checkLength(o, n, min,
														max) {
													if (o.val().length > max
															|| o.val().length < min) {
														o
																.addClass("ui-state-error");
														updateTips("Length of "
																+ n
																+ " must be between "
																+ min + " and "
																+ max + ".");
														return false;
													} else {
														return true;
													}
												}
												function requiredEdit(o, n) {
													if (o.val()=='') {
														o
																.addClass("ui-state-error");
														updateTips(n+" is Required");
														return false;
													} else {
														return true;
													}
												}

												function checkRegexp(o, regexp,
														n) {
													if (!(regexp.test(o.val()))) {
														o
																.addClass("ui-state-error");
														updateTips(n);
														return false;
													} else {
														return true;
													}
												}
												
												function checkAmount(a,b){
													if(a.val()>b.val()){
														a.addClass("ui-state-error");
														updateTips("Debit Amount Must be lessthan Net Price");
														return false;
													}
														else{
															return true;
														}
													
												}

												$("#dialog-form-DNoteEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 300,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");

																			bValid1 = bValid1
																			&& requiredEdit(
																					matIdEdit,
																					
																					"Material Name");
																	
																	bValid1 = bValid1
																			&& requiredEdit(
																					uomIdEdit,
																				
																					"UOM Name");
																	bValid1 = bValid1&& checkRegexp(qtyEdit,/^([0-9.])+$/i,"Quantity is Required And Must be  Number");
																	bValid1 = bValid1&& checkRegexp(perUnitEdit,/^([0-9])+$/i,"Per Unit is Required And Must be  Number");
																	bValid1 = bValid1&& checkRegexp(netPriceEdit,/^([0-9.])+$/i,"Net Price is Required And Must be  Number");
																	bValid1 = bValid1&& checkRegexp(debitAmtEdit,/^([0-9.])+$/i,"Debit Amount is Required And Must be  Number");	
																	bValid1 = bValid1 && checkAmount(debitAmtEdit,netPriceEdit);
																	
																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddDNoteDetailEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='debitNoteCmd.ematerialId'><input type='hidden' name='ematerialId' id='materialIdEdit"
																											+ btrid
																											+ "' value="
																											+ matIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<input type='text' readonly class='textbox' name='materialName' id='materialNameEdit"+btrid+"' value='"+$('#materialIdEdit :selected').text()+"'"
																											+"</td>"
																											+ "<td><spring:bind path='debitNoteCmd.equantity'><input name='equantity' id='quantityEdit"
																											+ btrid
																											+ "' value="
																											+ qtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='debitNoteCmd.euomId'><input type='hidden' name='euomId' id='UOMIdEdit"
																											+ btrid
																											+ "' value="
																											+ uomIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<input type='text'readonly class='textbox' name='uomName' id='UOMNameEdit"+btrid+"' value='"+$('#UOMIdEdit :selected').text()+"'"
																											+"</td>"
																											+ "<td><spring:bind path='debitNoteCmd.eperUnit'><input name='eperUnit' id='perUnitEdit"
																											+ btrid
																											+ "' value="
																											+ perUnitEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+"<td><input type='text' name='enetPrice' id='enetPrice"+btrid+"' value='"+netPriceEdit.val()+"' class='textbox' readonly/></td>"
																											+"<td><input type='text' name='edebitAmount' id='edebitAmount"+btrid+"' value='"+debitAmtEdit.val()+"' class='textbox' readonly/></td>"
																											
																											+"<input type='hidden' name='edebitNoteDetailId' id='edebitNoteDetailId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																											+
																											
																											"<td><a href='#'  onclick='editNoteDetailsInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeNoteDetailsEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					btrid++;
																					$(this).dialog("close");																												
																									
																				}
																			
																			if (hiddenEdit.val() != "0") {
																				 $('#materialIdEdit'+ hiddenEdit.val()).val($('#materialIdEdit').val()); 
																				 $('#materialNameEdit'	+ hiddenEdit.val()).val($('#materialIdEdit :selected').text()); 
																				$('#UOMIdEdit'+ hiddenEdit.val()).val($('#UOMIdEdit').val());
																				$('#UOMNameEdit'+ hiddenEdit.val()).val($('#UOMIdEdit :selected').text()); 
																				$('#quantityEdit'+ hiddenEdit.val()).val($('#quantityEdit').val());
																				$('#perUnitEdit'+ hiddenEdit.val()).val($('#perUnitEdit').val());
																				$('#netPriceEdit'+ hiddenEdit.val()).val($('#netPriceEdit').val());
																				$('#debitAmountEdit'+ hiddenEdit.val()).val($('#debitAmtEdit').val());
																		
																				$(
																						'#hiddenIdDebitPopUpEdit')
																						.val(
																								"0");
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																			}
																		},
																		Cancel : function() {
																			$(this).dialog("close");														
																							
																		}
																	},
																	close : function() {
																		allFields
																				.val(
																						"")
																				.removeClass(
																						"ui-state-error");
																	}
																});

												$("#create-AddDNoteEdit")
														.button()
														.click(
																function() {
																	$("#dialog-form-DNoteEdit").dialog("open");
																													

																});
											});
											function removeNoteDetailsEditNew(
													id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editNoteDetailsInEditNew(
													link) {
											//alert(link);
												$("#dialog-form-DNoteEdit")
														.dialog("open");
												$('#materialIdEdit').val(
														$(
																'#materialIdEdit'
																		+ link)
																.val());
												$('#UOMIdEdit').val(
														$(
																'#UOMIdEdit'
																		+ link)
																.val());
												$('#quantityEdit').val(
														$(
																'#quantityEdit'
																		+ link)
																.val());
												$('#perUnitEdit').val($('#perUnitEdit'+ link).val());
												$('#netPriceEdit').val($('#netPriceEdit'+ link).val());
												$('#debitAmountEdit').val($('#debitAmountEdit'+ link).val());

												$('#hiddenIdDebitPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-DNoteEdit" title="<spring:message code="label.debitdetail" />">
											<p class="validateTips" align="center" style="color: blue;">All Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="edebitNoteDetailId" value="0" />

												<tr>
												<td><spring:message code="label.dndmid" /><span
													class=required>*</span></td>
												<td><form:select path="material_Id" id="materialIdEdit"
														class="select" >
														<form:option value="">-Select-</form:option>
													<form:options items="${materialSelect}" />
													</form:select>	</td>
											</tr>
											
											<tr>
												<td><spring:message code="label.dnduid" /> <span
													class=required>*</span></td>
												<td><form:select path="uom_Id" id="UOMIdEdit"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${uomSelect}" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndqty" /><span
													class=required>*</span></td>
												<td><form:input path="equantity" id="quantityEdit"
														class="textbox" onblur="multiplicationEdit()" maxlength="21"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndperunit" /><span
													class=required>*</span></td>
												<td><form:input path="eperUnit" id="perUnitEdit"
														class="textbox" onblur="multiplicationEdit()" maxlength="21"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndnetpr" /><span
													class=required>*</span></td>
												<td><form:input path="enetPrice" id="netPriceEdit"
														class="textbox" readonly="true"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.dndamt" /><span
													class=required>*</span></td>
												<td><form:input path="edebitAmount" id="debitAmountEdit"
														class="textbox" maxlength="21"/></td>
											</tr>

											<tr>																							
											<td>
											<input type="hidden" name="hiddenIdDebitPopUpEdit" id="hiddenIdDebitPopUpEdit" value="0" />
														
												</td></tr>		
												

											</table>
										</div>

										<div id="users-DNoteDetailEdit">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="AddDNoteDetailEdit" class="table">
												<thead>
													<tr>
													<th><spring:message code="label.dndmid" /></th>
													<th><spring:message code="label.dnduid" /></th>
													<th><spring:message code="label.dndqty" /> </th>
													<th><spring:message code="label.dndperunit" /></th>	
													<th><spring:message code="label.dndnetpr" /></th>	
													<th><spring:message code="label.dndamt" /></th>													
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
												</thead>
												<tbody>

													<c:forEach var="dNoteLineEditList"
														items="${dNoteLineEditList}">
																									
														<spring:bind path="debitNoteCmd.edebitNoteDetailId">
															<input type="hidden" name="edebitNoteDetailId"
																id="edebitNoteDetailId${dNoteLineEditList.edebitNoteDetailId}"
																value="${dNoteLineEditList.edebitNoteDetailId}" />
														</spring:bind>
														<tr id="${dNoteLineEditList.edebitNoteDetailId}">

															<td><spring:bind path="debitNoteCmd.ematerialId">
																	<input type="hidden" name="ematerialId" class="textbox"
																		id="materialIdEdit${dNoteLineEditList.edebitNoteDetailId}"
																		value="${dNoteLineEditList.ematerialId}" readonly/>
																</spring:bind>
																<spring:bind path="debitNoteCmd.materialName">
																	<input type="text" name="materialName" class="textbox"
																		id="materialNameEdit${dNoteLineEditList.edebitNoteDetailId}"
																		value="${dNoteLineEditList.materialName}" readonly/>
																</spring:bind>
																</td>

															<td><spring:bind path="debitNoteCmd.equantity">
																	<input type="text" name="equantity" class="textbox"
																		id="quantityEdit${dNoteLineEditList.edebitNoteDetailId}"
																		value="${dNoteLineEditList.equantity}" readonly/>
																</spring:bind></td>
															
															<td><spring:bind path="debitNoteCmd.euomId">
																	<input type="hidden" name="euomId"
																		id="UOMIdEdit${dNoteLineEditList.edebitNoteDetailId}"
																		class="textbox"
																		value="${dNoteLineEditList.euomId}" readonly/>
																</spring:bind>
																
																<spring:bind path="debitNoteCmd.uomName">
																	<input type="text" name="uomName"
																		id="UOMNameEdit${dNoteLineEditList.edebitNoteDetailId}"
																		class="textbox"
																		value="${dNoteLineEditList.uomName}" readonly/>
																</spring:bind>
																
																</td>
																<td><spring:bind path="debitNoteCmd.eperUnit">
																	<input type="text" name="eperUnit" class="textbox"
																		id="perUnitEdit${dNoteLineEditList.edebitNoteDetailId}"
																		value="${dNoteLineEditList.eperUnit}" readonly/>
																</spring:bind></td>
																
																<td><spring:bind path="debitNoteCmd.enetPrice">
																	<input type="text" name="enetPrice" class="textbox"
																		id="netPriceEdit${dNoteLineEditList.edebitNoteDetailId}"
																		value="${dNoteLineEditList.enetPrice}" readonly/>
																</spring:bind></td>
																<td><spring:bind path="debitNoteCmd.edebitAmount">
																	<input type="text" name="edebitAmount" class="textbox"
																		id="debitAmountEdit${dNoteLineEditList.edebitNoteDetailId}"
																		value="${dNoteLineEditList.edebitAmount}" readonly/>
																</spring:bind></td>
															
															<td><a href="#"
																id="${dNoteLineEditList.edebitNoteDetailId}"
																onclick="javascript:editDNoteDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${dNoteLineEditList.edebitNoteDetailId}"></img></a></td>
																	
															<td><a href="#"
																id="${dNoteLineEditList.edebitNoteDetailId}"
																onclick="javascript:getIDNote(this.id)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px"
																	id="${dNoteLineEditList.edebitNoteDetailId}"></img></a> 

															
															<input type="hidden" name="Check${dNoteLineEditList.edebitNoteDetailId}" 
																	id="${dNoteLineEditList.edebitNoteDetailId}Check" value="0"/></td>
														</tr>

														<script>
															function getIDNote(
																	link) {
																//alert(link);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link
																				+ "Check").value = "1";
																document
																		.getElementById(link).style.display = "none";
															}
														function editDNoteDetailsInEdit(
																	link) {
																//alert(""+ link.id);

																$(
																		"#dialog-form-DNoteEdit")
																		.dialog(
																				"open");
																$(
																		'#materialIdEdit')
																		.val(
																				$(
																						'#materialIdEdit'
																								+ link.id)
																						.val());
																$(
																		'#UOMIdEdit')
																		.val(
																				$(
																						'#UOMIdEdit'
																								+ link.id)
																						.val());
																$(
																		'#quantityEdit')
																		.val(
																				$(
																						'#quantityEdit'
																								+ link.id)
																						.val());
																
																$('#perUnitEdit').val($('#perUnitEdit'+ link.id).val());
																$('#netPriceEdit').val($('#netPriceEdit'+ link.id).val());
																$('#debitAmountEdit').val($('#debitAmountEdit'+ link.id).val());
																		
														

																$(
																		'#hiddenIdDebitPopUpEdit')
																		.val(
																				link.id);

															}
														</script> 

													</c:forEach>


												</tbody>

											</table>
										</div>
										<button id="create-AddDNoteEdit" type="button"><spring:message code="label.newdebit" />
											</button>

									</div>

								</div>
							</div>
							<table>
									<tr>
										<c:choose>

										<c:when test="${true}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updateid" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updateid" /></td>
										</c:otherwise>
									</c:choose>

									</tr>

								</table>
						</c:if>
						<!-- window 2 -->

					</form:form>
				</div>
			</div> 
		</div>
	</div>
</body>
</html>