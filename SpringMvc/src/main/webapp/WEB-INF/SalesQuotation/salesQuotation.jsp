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
<title>My JSP 'salesQuotation.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="css/jquery-ui.css" />
<link rel="stylesheet"
	href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//Json Data	
						$('#salesInquiryId')
								.change(
										function() {
											var msg;
											var res = $(this).val();
											if (res != 0) {
												msg = confirm("Do U Want Add Sales Inquiry Line Details?");
											} else {
												msg = confirm("Do U Want Remove Sales Inquiry Line Details?");
											}
											if (msg == true) {
												$
														.ajax({
															type : "POST",
															url : "salesInquiryDetails.mnt",
															data : "salesInquiryId="
																	+ $(this)
																			.val(),
															success : function(
																	data) {
																$('#extender')
																		.empty();
																//alert("data  "+data); 
																var raw = JSON
																		.parse(data);
																$
																		.each(
																				raw,
																				function(
																						idx,
																						obj) {
																					//$('#extender').show();
																					forAddRow(obj.count);
																					$(
																							"#materialId"
																									+ obj.count)
																							.val(
																									obj.materialId);
																					$(
																							"#materialName"
																									+ obj.count)
																							.val(
																									obj.ematerialName);
																					$(
																							"#UOMId"
																									+ obj.count)
																							.val(
																									obj.umId);
																					$(
																							"#uomName"
																									+ obj.count)
																							.val(
																									obj.uomName);
																					$(
																							"#quantity"
																									+ obj.count)
																							.val(
																									obj.quantity);
																					$(
																							"#requiredDate"
																									+ obj.count)
																							.val(
																									obj.requiredDate);
																					$(
																							'#sqId')
																							.val(
																									1);

																				});

															}
														});
											}

										});

						$('#esalesInquiryId')
								.change(
										function() {
											var c;
											//alert($(this).val());
											var value = $(this).val();
											if (value == 0) {
												c = confirm("Do U Want Remove Sales Inquiry Line Details?");
											} else {
												c = confirm("Do U Want Add Sales Inquiry Line Details?");
											}
											if (c == true) {
												$
														.ajax({
															type : "POST",
															url : "salesInquiryDetails.mnt",
															data : "salesInquiryId="
																	+ $(this)
																			.val(),
															success : function(
																	data) {
																//alert("data  "+data); 
																$(
																		'#extenderEdit')
																		.empty();
																var row = JSON
																		.parse(data);
																$
																		.each(
																				row,
																				function(
																						idx,
																						item) {
																					//$('#extenderEdit').show();
																					forAddRowEdit(item.count);
																					$(
																							"#materialIdEdit"
																									+ item.count)
																							.val(
																									item.materialId);
																					$(
																							"#materialNameEdit"
																									+ item.count)
																							.val(
																									item.ematerialName);
																					$(
																							"#quantityEdit"
																									+ item.count)
																							.val(
																									item.quantity);
																					$(
																							"#UOMIdEdit"
																									+ item.count)
																							.val(
																									item.umId);
																					$(
																							"#uomNameEdit"
																									+ item.count)
																							.val(
																									item.uomName);
																					$(
																							"#requiredDateEdit"
																									+ item.count)
																							.val(
																									item.requiredDate);

																				});

															}
														});
											}

										});

						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											$('#addSalesForm')
													.validate(
															{
																rules : {
																	salesQuotationNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},

																	customerId : {
																		required : true
																	},
																	salesQuotationDate : {
																		required : true
																	},

																	description : {
																		required : true
																	},

																},
																messages : {
																	salesQuotationNo : {
																		required : "<font style='color: red;'><b>Sales Quotation No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},

																	customerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	salesQuotationDate : "<font style='color: red;'><b>Sales Quotation Date is Required</b></font>",

																	description : "<font style='color: red;'><b>Description is Required</b></font>",

																},

															});

											if ($('#salesQuotationNo').val() != ""
													&& $('#sqdate').val() != ""
													&& $('#customerId').val() != ""
													&& $('#description').val() != "") {
												if ($('#sqId').val() == 0) {
													//alert("Please Enter AtLeast One Sales Quotation Line");
													document
															.getElementById("childMsg").style.display = "block";
													$('#childMsg')
															.html(
																	"Warning! Please Enter AtLeast One Sales Quotation Line");
													return false;
												} else {
													document
															.getElementById("childMsg").style.display = "none";
													$('#childMsg').html("");
													return true;
												}
											}

										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editSalesForm')
													.validate(
															{
																rules : {
																	esalesQuotationNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},

																	ecustomerId : {
																		required : true
																	},
																	esalesQuotationDate : {
																		required : true
																	},

																	edescription : {
																		required : true
																	},
																},
																messages : {
																	esalesQuotationNo : {
																		required : "<font style='color: red;'><b>Sales Quotation No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},

																	ecustomerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	esalesQuotationDate : "<font style='color: red;'><b>Sales Quotation Date is Required</b></font>",

																	edescription : "<font style='color: red;'><b>Description is Required</b></font>",

																},
															});

										});

					});
</script>

<script>
	$(function() {
		$("#tabs,#tabss,#edittabs").tabs();
	});

	function dateFun(datePattern) {
		$(
				'#sqdate,#deliveryDate,#requiredDate,#sqdateEdit,#deliveryDateEdit,#requiredDateEdit,#deliveryDateChild')
				.datepicker({

					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true
				});

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
			
		}
		
		$('#basicSearch').click(function() {
			$("#advanceSearchHidden").val('0');
			$("#aslink").show();
			$('#mainSearch').show();
			$('#advanceSearchDiv').hide();
			$('#advanceSearch').show();
			$('#basicSearch').hide();

			return false;
		});
		
	});
</script>

<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

#scroll {
	align: left;
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 1000px;
}

#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 70%;
}

#subscroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 100%;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>
<script type="text/javascript">
	function multiply() {
		var quantity = $("#quantity").val();
		var perUnit = document.getElementById("perUnit").value;
		var result = quantity * perUnit;
		document.getElementById("netPrice").value = result;
		document.getElementById("lineAmount").value = result;

	}
	function multiplyEdit() {

		var quantity = $("#quantityEdit").val();
		var perUnit = document.getElementById("perUnitEdit").value;
		var result = quantity * perUnit;
		document.getElementById("netPriceEdit").value = result;
		document.getElementById("lineAmountEdit").value = result;

	}

	function AjaxForDuplicate() {

		var cust = $('#salesQuotationNo').val();
		//alert(cust);

		$
				.ajax({
					type : "POST",
					url : "checkSQAddDuplicate.mnt",
					data : "salesQuotationNo=" + cust,
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
						alert('Error' + e);
					}

				});

	}

	function AjaxUpdateDuplicate() {
		var cust = $('#esalesQuotationNo').val();
		var id = $('#esalesQuotationId').val();
		//alert(id);

		$
				.ajax({
					type : "POST",
					url : "checkSQUpdateDuplicate.mnt",
					data : "esalesQuotationNo=" + cust + "&sqId=" + id,
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
						alert('Error' + e);
					}

				});

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("sqId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
		$('#sumbnasdStop').click(function(e) {
			document.getElementById("sqId").value = 1;
			//alert(document.getElementById("asId").value);
		});

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#basicSearchId').focus();
			$('#salesQuotationNo').focus();
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Sales Quotation</div>

		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:if test="${salesQuotEditList!=null}">

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

					<form:form method="get" action="salesQuotationSearch.mnt"
						commandName="salesQuotationCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addSQSus"
										items="${param.addSQSus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.squotation" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="addSQFail"
										items="${param.addSQFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.squotation" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="UpdateSQsus"
										items="${param.UpdateSQsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.squotation" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSQFail"
										items="${param.UpdateSQFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.squotation" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteSQsus"
										items="${param.DeleteSQsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.squotation" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteSQFail"
										items="${param.DeleteSQFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.squotation" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr id="mainSearch">
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" id="basicSearchId"
										cssClass="textbox" /></td>

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
									<c:when test="${search}">
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
							
							<form:form action="SQAdvanceSearch.mnt" method="get"
								commandName="salesQuotationCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="SQAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>

						</table>
						
						<form:form action="SQAdvanceSearchOperations.mnt"
							commandName="salesQuotationCmd" method="get">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="salesQuotationCmd.asOpts">
													<select class="select" name="asOpts">
														<option value="<spring:message code='assignedOperator'/>">
															<spring:message code="label.equalsTo" />
														</option>
														<option value="<spring:message code='notequalsOperator'/>">
															<spring:message code="label.notEqualsTo" />
														</option>
														<option
															value="<spring:message code='beginsWithOperator'/>">
															<spring:message code="label.beginsWith" />
														</option>
														<option value="<spring:message code='endsWithOperator'/>">
															<spring:message code="label.endsWith" />
														</option>
														<option value="<spring:message code='containsOperator'/>">
															<spring:message code="label.contains" />
														</option>
													</select>
												</spring:bind></td>

											<td><form:input path="advanceSearchText"
													cssClass="textbox" /></td>
										</tr>

									</c:forEach>
									

									<c:forEach var="refList" items="${refList}">
										<tr>
											<td><label>${refList.labels}</label> <form:hidden
													path="dbField" id="dbField" value="${refList.dbField}" /></td>
											<td><spring:bind path="salesQuotationCmd.asOpts">
													<select class="select" name="asOpts">
														<option value="<spring:message code='assignedOperator'/>">
															<spring:message code="label.equalsTo" />
														</option>
														<option value="<spring:message code='notequalsOperator'/>">
															<spring:message code="label.notEqualsTo" />
														</option>
														
													</select>
												</spring:bind></td>

											<c:set var="bdField" value="${refList.dbField}" />
											<c:set var="customerId" value="customerId" />
											<c:set var="salesInquiryId" value="salesInquiryId" />
											<c:if test="${bdField eq customerId}">
												<c:set var="selectBox" value="${custSelect}" />
											</c:if>
											<c:if test="${bdField eq salesInquiryId}">
												<c:set var="selectBox" value="${salesInquirySelect}" />
											</c:if>

											<td><form:select class="select" path="advanceSearchText">
													<form:option value="">--Select--</form:option>
													<form:options items="${selectBox}" />
												</form:select></td>

										</tr>

									</c:forEach>

									<tr>
										<form:hidden path="advanceSearchHidden"
											id="advanceSearchHidden" />
										<c:choose>
											<c:when test="${search }">
												<td colspan="3"><input type="submit"
													id="advanceSearchButtonId" value="Advance Search"
													style="display: none" class="btn btn-primary" /></td>
											</c:when>
											<c:otherwise>
												<td colspan="3"><input type="submit"
													disabled="disabled" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-danger" /></td>
											</c:otherwise>
										</c:choose>
									</tr>

								</table>

							</div>
						</form:form>
					</form:form>

					<c:if test="${SQList!=null }">
					<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="SQAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="salesQuotationSearch.mnt" />
							</c:otherwise>

						</c:choose>
						<display:table name="SQList" id="SQIdList" class="table"
							requestURI="${search}" pagesize="5">

							<display:column property="salesQuotationId" sortable="true"
								title="salesQuotationId" media="none" />

							<display:column property="salesQuotationNo" sortable="true"
								titleKey="label.salesQuotno" media="html" />

							<display:column property="customerId" sortable="true"
								titleKey="label.salesquotcistid" media="html" />


							<display:column property="salesQuotationDate" sortable="true"
								titleKey="label.salesquotdate" media="html" />

							<display:column property="salesInquiryId" sortable="true"
								titleKey="label.salesinqid" media="none" />


							<display:column property="description" sortable="true"
								titleKey="label.salesquotdesc" media="html" />

							<display:column property="statusId" sortable="true"
								titleKey="label.sstatusId" media="none" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="SalesQuotationEdit.mnt?salesQuotationId=<c:out value="${SQIdList.salesQuotationId}"/> "><img
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
									<c:when test="${delete}">
										<a
											href="salesQuotationDelete.mnt?salesQuotationId=<c:out value="${SQIdList.salesQuotationId}"/> "
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
							<td colspan="4" class="alert-warning" id="childMsg"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
						<tr>
							<td colspan="2" id="salesDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.salesQuotno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="salesQuotationAdd.mnt" method="POST"
						commandName="salesQuotationCmd" id="addSalesForm">

						<table class="tableGeneral">

							<tr>
								<td><spring:message code="label.salesQuotno" /><span
									class="required">*</span></td>
								<td><form:input path="salesQuotationNo"
										id="salesQuotationNo" cssClass="textbox"
										onkeyup="AjaxForDuplicate()" maxlength="50" /></td>
							</tr>

							<tr>
								<td><spring:message code="label.salesinqid" /><span
									class="required"></span></td>
								<td><form:select path="salesInquiryId" cssClass="select">
										<form:option value="0">-Select-</form:option>
										<form:options items="${salesInquirySelect}" />
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.salesquotcistid" /><span
									class="required">*</span></td>
								<td><form:select path="customerId" cssClass="select"
										id="customerId">
										<form:option value="">-Select-</form:option>
										<form:options items="${custSelect}" />

									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.salesquotdate" /><span
									class="required">*</span></td>
								<td><form:input path="salesQuotationDate"
										cssClass="textbox" id="sqdate" /></td>
							<tr>
								<td><spring:message code="label.salesquotdesc" /><span
									class="required">*</span></td>
								<td><form:textarea path="description" cssClass="textbox"
										id="description" maxlength="250" /> <input type="hidden"
									name="sqId" id="sqId" class="textbox" value="0" /></td>

							</tr>

						</table>


						<!-- window 2 -->

						<div id="tabss" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.salesquotline" /></a></li>
							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1" align="left">

								<!-- Model Pop-up Start-->

								<div align="left">

									<script type="text/javascript">
										var btrid = 1;
										var list=[];

										$(document)
												.ready(
														function() {

															var matId = $("#materialId"), qty = $("#quantity"), uomId = $("#UOMId"), currcId = $("#currencyId"), reqDate = $("#requiredDate"), delDate = $("#deliveryDate"), pUnit = $("#perUnit"), nPrice = $("#netPrice"), lineAmt = $("#lineAmount"), hiddenID = $("#hiddenIdBankPopUp"),

															allFields = $([])
																	.add(matId)
																	.add(qty)
																	.add(uomId)
																	.add(
																			currcId)
																	.add(
																			reqDate)
																	.add(
																			delDate)
																	.add(pUnit)
																	.add(nPrice)
																	.add(
																			lineAmt)
																	.add(
																			hiddenID), tips = $(".validateTips");
															function updateTips(
																	t) {
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
															
															var n = 1;
															function DuplMaterials(
																	m) {
																var mId = m
																		.val();
																if (n == 1) {
																	list
																			.push(mId);
																	n++;
																	return true;
																} else {
																	var flag = $
																			.inArray(
																					mId,
																					list);
																	if (flag != -1) {
																		//alert("Material Name Already Exists!");
																		m
																				.addClass("ui-state-error");
																		updateTips("Warning! Material Name Already Exists");
																		return false;

																	} else {
																		list
																				.push(mId);
																		updateTips('');
																		return true;
																	}

																}

															}

															function checkLength(
																	o, n, min,
																	max) {
																if (o.val().length > max
																		|| o
																				.val().length < min) {
																	o
																			.addClass("ui-state-error");
																	updateTips("Length of "
																			+ n
																			+ " must be between "
																			+ min
																			+ " and "
																			+ max
																			+ ".");
																	return false;
																} else {
																	return true;
																}
															}
															function required(
																	o, n) {
																if (o.val() == '') {
																	o
																			.addClass("ui-state-error");
																	updateTips(n
																			+ " is Required");
																	return false;
																} else {
																	return true;
																}
															}

															function checkRegexp(
																	o, regexp,
																	n) {
																if (!(regexp
																		.test(o
																				.val()))) {
																	o
																			.addClass("ui-state-error");
																	updateTips(n);
																	return false;
																} else {
																	return true;
																}
															}

															$(
																	"#dialogformsalesLine")
																	.dialog(

																			{
																				autoOpen : false,
																				height : 380,
																				width : 400,
																				modal : true,
																				buttons : {
																					Submit : function() {
																						var bValid = true,flag=true;
																						flag = DuplMaterials(matId);
																						allFields
																								.removeClass("ui-state-error");

																						bValid = bValid
																								&& required(
																										matId,

																										"Material");

																						bValid = bValid
																								&& required(
																										uomId,

																										"UOM");

																						bValid = bValid
																								&& checkRegexp(
																										qty,
																										/^([0-9])+$/i,
																										"Quantity is Required And Must be  Number");
																						bValid = bValid
																								&& required(
																										reqDate,

																										"Required Date");

																						bValid = bValid
																								&& required(
																										currcId,

																										"Currency");
																						bValid = bValid
																								&& required(
																										delDate,

																										"Delivery Date");
																						bValid = bValid
																								&& checkRegexp(
																										pUnit,
																										/^([0-9])+$/i,
																										"Per Unit is Required And Must be  Number");
																						bValid = bValid
																								&& checkRegexp(
																										nPrice,
																										/^([0-9.])+$/i,
																										"Net Price is Required And Must be  Number");
																						bValid = bValid
																								&& checkRegexp(
																										lineAmt,
																										/^([0-9.])+$/i,
																										"Line Amount is Required And Must be  Number");

																						if (bValid && flag) {

																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {

																								$(
																										"#SalesLineAdd tbody")
																										.append(

																												"<tr id="+btrid+">"
																														+ "<td ><spring:bind path='salesQuotationCmd.materialId'><input type='hidden' name='materialId' id='materialId"
																														+ btrid
																														+ "' value="
																														+ matId
																																.val()

																														+ " class='textbox' readonly/></spring:bind> "
																														+ "<input type='text' readonly class='textbox' name='materialName' id='materialName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#materialId :selected')
																																.text()
																														+ "'"
																														+ "</td>"

																														+ "<td><input type='hidden' name='UOMId' id='UOMId"
																														+ btrid
																														+ "' value="
																														+ uomId
																																.val()

																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='uomName' id='uomName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#UOMId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input name='quantity' id='quantity"
																														+ btrid
																														+ "' value="
																														+ qty
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><input name='requiredDate' id='requiredDate"
																														+ btrid
																														+ "' value="
																														+ reqDate
																																.val()

																														+ " class='textbox' readonly/></td>"
																														+ "<td><input type='hidden' name='currencyId' id='currencyId"
																														+ btrid
																														+ "' value="
																														+ currcId
																																.val()

																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='currencyName' id='currencyName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#currencyId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input name='deliveryDate' id='deliveryDate"
																														+ btrid
																														+ "' value="
																														+ delDate
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><input name='perUnit' id='perUnit"
																														+ btrid
																														+ "' value="
																														+ pUnit
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><input name='netPrice' id='netPrice"
																														+ btrid
																														+ "' value="
																														+ nPrice
																																.val()

																														+ " class='textbox' readonly/></td>"
																														+ "<td><input name='lineAmount' id='lineAmount"
																														+ btrid
																														+ "' value="
																														+ lineAmt
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><a href='#'  onclick='editSalesQuotationLine("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeSalesQuotationLine("
																														+ btrid
																														+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																														+ "</tr>");
																								$(
																										'#sqId')
																										.val(
																												btrid);

																								btrid++;
																								$(
																										this)
																										.dialog(
																												"close");
																							}

																							if (hiddenID
																									.val() != "0") {

																								$(
																										'#materialId'
																												+ hiddenID
																														.val())
																										.val(
																												matId
																														.val());
																								$(
																										'#materialName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#materialId :selected')
																														.text());
																								$(
																										'#quantity'
																												+ hiddenID
																														.val())
																										.val(
																												qty
																														.val());
																								$(
																										'#UOMId'
																												+ hiddenID
																														.val())
																										.val(
																												uomId
																														.val());
																								$(
																										'#uomName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#UOMId :selected')
																														.text());
																								$(
																										'#currencyId'
																												+ hiddenID
																														.val())
																										.val(
																												currcId
																														.val());
																								$(
																										'#currencyName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#currencyId :selected')
																														.text());
																								$(
																										'#requiredDate'
																												+ hiddenID
																														.val())
																										.val(
																												reqDate
																														.val());
																								$(
																										'#deliveryDate'
																												+ hiddenID
																														.val())
																										.val(
																												delDate
																														.val());
																								$(
																										'#perUnit'
																												+ hiddenID
																														.val())
																										.val(
																												pUnit
																														.val());
																								$(
																										'#netPrice'
																												+ hiddenID
																														.val())
																										.val(
																												nPrice
																														.val());
																								$(
																										'#lineAmount'
																												+ hiddenID
																														.val())
																										.val(
																												lineAmt
																														.val());

																								$(
																										'#hiddenIdBankPopUp')
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
																						$(
																								this)
																								.dialog(
																										"close");

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

															$(
																	'#createAddSalesLine')
																	.button()
																	.click(
																			function() {

																				$(
																						"#dialogformsalesLine")
																						.dialog(
																								"open");
																				tips
																						.text('');
																				//alert("opened");
																			});
														});

										function removeSalesQuotationLine(id) {
											//alert("removing row " + id);
											list.pop(parseInt(id) - 1);
											$('#' + id).remove();
										}
										function editSalesQuotationLine(id) {
											//alert("edit row " + id);
											list.pop(parseInt(id) - 1);
											$("#dialogformsalesLine").dialog(
													"open");
											$('#materialId')
													.val(
															$(
																	'#materialId'
																			+ id)
																	.val());
											$('#quantity').val(
													$('#quantity' + id).val());
											$('#currencyId')
													.val(
															$(
																	'#currencyId'
																			+ id)
																	.val());
											$('#currencyName' + id).val(
													$('#currencyId :selected')
															.text());
											$('#UOMId').val(
													$('#UOMId' + id).val());
											$('#requiredDate').val(
													$('#requiredDate' + id)
															.val());
											$('#deliveryDate').val(
													$('#deliveryDate' + id)
															.val());
											$('#perUnit').val(
													$('#perUnit' + id).val());
											$('#netPrice').val(
													$('#netPrice' + id).val());
											$('#lineAmount')
													.val(
															$(
																	'#lineAmount'
																			+ id)
																	.val());

											$('#hiddenIdBankPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>

									<div id="dialogformsalesLine" align="left"
										title="<spring:message code="label.sqform" />">
										<p class="validateTips" align="center" style="color: blue;"></p>
										<table class="tableGeneral">
											<tr>
												<td><spring:message code="label.sqmatid" /><span
													class=required>*</span></td>
												<td><form:select path="material_Id" id="materialId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.squomid" /> <span
													class=required>*</span></td>
												<td><form:select path="uom_Id" id="UOMId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>
											</tr>


											<tr>
												<td><spring:message code="label.sqqty" /><span
													class=required>*</span></td>
												<td><form:input path="quantity" id="quantity"
														class="textbox" onkeyup="multiply()" maxlength="10" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sqreqdate" /><span
													class=required>*</span></td>
												<td><form:input path="requiredDate" id="requiredDate"
														class="textbox" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.sqcurid" /> <span
													class=required>*</span></td>
												<td><form:select path="currency_Id" id="currencyId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectCurrency}" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.sqdeldate" /><span
													class=required>*</span></td>
												<td><form:input path="deliveryDate" id="deliveryDate"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sqperunit" /><span
													class=required>*</span></td>
												<td><form:input path="perUnit" id="perUnit"
														class="textbox" onkeyup="multiply()" maxlength="10" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sqnetprice" /><span
													class=required>*</span></td>
												<td><form:input path="netPrice" id="netPrice"
														class="textbox" readonly="true" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sqlineamt" /><span
													class=required>*</span></td>
												<td><form:input path="lineAmount" id="lineAmount"
														class="textbox" readonly="true" /></td>
											</tr>

											<tr>
												<td><input type="hidden" name="hiddenIdBankPopUp"
													id="hiddenIdBankPopUp" value="0" />
											</tr>

										</table>
									</div>
								</div>

								<div id="users-SalesLine">
									<div id="scroll1" align="center">
										<table id="SalesLineAdd" class="table">

											<tr>
												<th><spring:message code="label.sqmatid" /></th>
												<th><spring:message code="label.squomid" /></th>
												<th><spring:message code="label.sqqty" /></th>
												<th><spring:message code="label.sqreqdate" /></th>
												<th><spring:message code="label.sqcurid" /></th>
												<th><spring:message code="label.sqdeldate" /></th>
												<th><spring:message code="label.sqperunit" /></th>
												<th><spring:message code="label.sqnetprice" /></th>
												<th><spring:message code="label.sqlineamt" /></th>
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>
											</tr>

										</table>

										<script type="text/javascript">
											function forAddRow(id) {

												//alert("came "+id);
												var options = '<table><tr ><td><table  class="table" >'

														+ '<tr>'
														+ '<td><spring:bind path="salesQuotationCmd.materialId"><input type="hidden" name="materialId" id="materialId'+id+'"  class="textbox"/></spring:bind>'
														+ '<input type="text" name="materialName" id="materialName'+id+'"  class="textbox" readOnly/> </td>'
														+ '<td><spring:bind path="salesQuotationCmd.UOMId"><input type="hidden" name="UOMId" id="UOMId'+id+'" class="textbox" /></spring:bind>'
														+ '<input type="text" name="uomName" id="uomName'+id+'" class="textbox" readOnly /></td>'
														+ '<td><spring:bind path="salesQuotationCmd.quantity"><input name="quantity" id="quantity'
														+ id
														+ '" onkeyup="multiplication('
														+ id
														+ ')"   class="textbox" readOnly /></spring:bind></td>'
														+ '<td><spring:bind path="salesQuotationCmd.requiredDate"><input name="requiredDate" id="requiredDate'+id+'"  class="textbox"  readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesQuotationCmd.currencyId"><input name="currencyId" type="hidden" class="textbox" id="currencyId'+id+'" readOnly/></spring:bind>'
														+ '<input type="text" class="textbox" name="currencyName" id="currencyName'
														+ id
														+ '" value="'
														+ $(
																'#currencyId :selected')
																.text()
														+ '"  readOnly/></td>'
														+ '<td><spring:bind path="salesQuotationCmd.deliveryDate"><input type="text" name="deliveryDate" class="textbox" id="deliveryDate'+id+'"   readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesQuotationCmd.perUnit"><input name="perUnit" class="textbox" id="perUnit'
														+ id
														+ '" onkeyup="multiplication('
														+ id
														+ ')" readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesQuotationCmd.netPrice"><input name="netPrice" class="textbox" id="netPrice'+id+'" readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesQuotationCmd.lineAmount"><input name="lineAmount" class="textbox" id="lineAmount'+id+'" readOnly/></spring:bind></td>'
														+ '</td></tr></table>'

														+ "<a href='#'  onclick='editSalesQuotationLine("
														+ id
														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a>"

														+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a>'
														+ '</td></tr></table>';

												$(options).fadeIn("slow")
														.appendTo('#extender');

												$('.remove')
														.live(
																'click',
																function() {

																	$(this)
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

											}
										</script>

										<div id="extender"></div>
										<button id="createAddSalesLine" type="button">
											<spring:message code="label.newsalesquotline" />
										</button>
									</div>

								</div>


							</div>


							<!-- Model Pop-up End-->
						</div>

						<table>
							<tr>
								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="submitid"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="submitid"
											disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</table>


						<!-- window 2 -->

					</form:form>
				</div>
			</div>

			<!--Edit  Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="salesUpDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.salesQuotno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form method="post" action="salesQuotationUpdate.mnt"
						commandName="salesQuotationCmd" id="editSalesForm">
						<c:forEach var="salesQuotEditList" items="${salesQuotEditList}">
							<c:set var="editMode" value="${salesQuotEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td>
										<div>

											<table class="tableGeneral">

												<form:hidden path="esalesQuotationId" id="esalesQuotationId" />
												<form:hidden path="estatusId" cssClass="textbox" />

												<tr>
													<td><spring:message code="label.salesQuotno" /><span
														class="required">*</span></td>
													<td><form:input path="esalesQuotationNo"
															cssClass="textbox" onkeyup="AjaxUpdateDuplicate()"
															maxlength="50" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.salesinqid" /><span
														class="required"></span></td>
													<td><form:select path="esalesInquiryId"
															id="esalesInquiryId" cssClass="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${salesInquirySelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.salesquotcistid" /><span
														class="required">*</span></td>
													<td><form:select path="ecustomerId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${custSelect}" />

														</form:select></td>

												</tr>

												<tr>
													<td><spring:message code="label.salesquotdate" /><span
														class="required">*</span></td>
													<td><form:input path="esalesQuotationDate"
															cssClass="textbox" id="sqdateEdit" /></td>
												<tr>
													<td><spring:message code="label.salesquotdesc" /><span
														class="required">*</span></td>
													<td><form:textarea path="edescription"
															cssClass="textbox" /></td>

												</tr>

											</table>
										</div>
									</td>

								</tr>

							</table>

							<!-- window 2 -->

							<div id="tabss" align="left">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.salesquotline" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="left">
										<script>
											var btridEdit = 1;
											var listEdit=[];
											$(function() {
												var list = ${mList};
												$.each(list, function(index,
														value) {
													listEdit.push(value.toString());

												});
												var matIdEdit = $("#materialIdEdit"), qtyEdit = $("#quantityEdit"), uomIdEdit = $("#UOMIdEdit"), currcIdEdit = $("#currencyIdEdit"), reqDateEdit = $("#requiredDateEdit"), delDateEdit = $("#deliveryDateEdit"), pUnitEdit = $("#perUnitEdit"), nPriceEdit = $("#netPriceEdit"), lineAmtEdit = $("#lineAmountEdit"), hiddenEdit = $("#hiddenIdBankPopUpEdit"),

												allFields = $([])
														.add(matIdEdit).add(
																qtyEdit).add(
																uomIdEdit).add(
																currcIdEdit)
														.add(reqDateEdit).add(
																delDateEdit)
														.add(pUnitEdit).add(
																nPriceEdit)
														.add(lineAmtEdit).add(
																hiddenEdit), tips = $(".validateTips");

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
												
												function DuplMaterialEdit(m) {
													var mId = m.val();
													var flag = $.inArray(mId,
															listEdit);
													if (flag != -1) {
														//alert("Material Name Already Exists!");
														
														m.addClass("ui-state-error");
														updateTips("Warning! Material Name Already Exists");
														return false;

													} else {
														listEdit.push(mId);
														updateTips('');
														return true;
													};

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
												function required(o, n) {
													if (o.val() == '') {
														o
																.addClass("ui-state-error");
														updateTips(n
																+ " is Required");
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

												$("#dialog-form-salesLineEdit")
														.dialog(
																{

																	autoOpen : false,
																	height : 380,
																	width : 400,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true,flag=true;
																			flag = DuplMaterialEdit(matIdEdit);
																			allFields
																					.removeClass("ui-state-error");

																			bValid1 = bValid1
																					&& required(
																							matIdEdit,
																							"Material");

																			bValid1 = bValid1
																					&& required(
																							uomIdEdit,

																							"UOM");
																			bValid1 = bValid1
																					&& required(
																							currcIdEdit,

																							"Currency");
																			bValid1 = bValid1
																					&& checkRegexp(
																							qtyEdit,
																							/^([0-9])+$/i,
																							"Quantity is Required And Must be  Number");

																			bValid1 = bValid1
																					&& required(
																							reqDateEdit,

																							"Required Date");
																			bValid1 = bValid1
																					&& required(
																							delDateEdit,

																							"Delivery Date");
																			bValid1 = bValid1
																					&& checkRegexp(
																							pUnitEdit,
																							/^([0-9])+$/i,
																							"Per Unit is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkRegexp(
																							nPriceEdit,
																							/^([0-9.])+$/i,
																							"Net Price is Required And Must be  Number");

																			bValid1 = bValid1
																					&& checkRegexp(
																							lineAmtEdit,
																							/^([0-9.])+$/i,
																							"Line Amount is Required And Must be  Number");

																			// alert("edi"+ hiddenEdit.val());

																			if (bValid1 && flag) {

																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {

																					$(
																							"#AddSalesQuEdit tbody")
																							.append(
																									"<tr id="+btridEdit+">"
																											+ "<td ><spring:bind path='salesQuotationCmd.ematerialId'><input type='hidden' name='ematerialId' id='materialIdEdit"
																											+ btridEdit
																											+ "' value="
																											+ matIdEdit
																													.val()

																											+ " class='textbox' readonly/></spring:bind> "
																											+ "<input type='text' readonly class='textbox' name='ematerialName' id='materialNameEdit"
																											+ btridEdit
																											+ "' value='"
																											+ $(
																													'#materialIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"
																											+ "<td><input name='equantity' id='quantityEdit"
																											+ btridEdit
																											+ "' value="
																											+ qtyEdit
																													.val()

																											+ " class='textbox' readonly/></td>"
																											+ "<td><spring:bind path='salesQuotationCmd.eUOMId'><input type='hidden' name='eUOMId' id='UOMIdEdit"
																											+ btridEdit
																											+ "' value="
																											+ uomIdEdit
																													.val()

																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text' class='textbox' readonly name='euomName' id='uomNameEdit"
																											+ btridEdit
																											+ "' value='"
																											+ $(
																													'#UOMIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><input name='erequiredDate' id='requiredDateEdit"
																											+ btridEdit
																											+ "' value="
																											+ reqDateEdit
																													.val()

																											+ " class='textbox' readonly/></td>"
																											+ "<td><input type='hidden' name='ecurrencyId' id='currencyIdEdit"
																											+ btridEdit
																											+ "' value="
																											+ currcIdEdit
																													.val()

																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='ecurrencyName' id='currencyNameEdit"
																											+ btridEdit
																											+ "' value='"
																											+ $(
																													'#currencyIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><input name='edeliveryDate' id='deliveryDateEdit"
																											+ btridEdit
																											+ "' value="
																											+ delDateEdit
																													.val()

																											+ " class='textbox' readonly/></td>"

																											+ "<td><input name='eperUnit' id='perUnitEdit"
																											+ btridEdit
																											+ "' value="
																											+ pUnitEdit
																													.val()

																											+ " class='textbox' readonly/></td>"

																											+ "<td><input name='enetPrice' id='netPriceEdit"
																											+ btridEdit
																											+ "' value="
																											+ nPriceEdit
																													.val()

																											+ " class='textbox' readonly/></td>"
																											+ "<td><input name='elineAmount' id='lineAmountEdit"
																											+ btridEdit
																											+ "' value="
																											+ lineAmtEdit
																													.val()

																											+ " class='textbox' readonly/></td>"
																											+ "<input type='hidden' name='esalesQuotationLineId' id='esalesQuotationLineId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"

																											+ "<td><a href='#'  onclick='editSalesQuotInEditNew("
																											+ btridEdit
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeSalesQuotEditNew("
																											+ btridEdit
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					btridEdit++;
																					$(
																							this)
																							.dialog(
																									"close");

																				}

																				if (hiddenEdit
																						.val() != "0") {

																					$(
																							'#materialIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#materialIdEdit')
																											.val());

																					$(
																							'#materialNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#materialIdEdit :selected')
																											.text());

																					$(
																							'#UOMIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#UOMIdEdit')
																											.val());

																					$(
																							'#uomNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#UOMIdEdit :selected')
																											.text());

																					$(
																							'#quantityEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#quantityEdit')
																											.val());
																					$(
																							'#currencyIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#currencyIdEdit')
																											.val());
																					$(
																							'#currencyNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#currencyIdEdit :selected')
																											.text());
																					$(
																							'#requiredDateEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#requiredDateEdit')
																											.val());
																					$(
																							'#deliveryDateEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#deliveryDateEdit')
																											.val());
																					$(
																							'#perUnitEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#perUnitEdit')
																											.val());
																					$(
																							'#netPriceEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#netPriceEdit')
																											.val());
																					$(
																							'#lineAmountEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#lineAmountEdit')
																											.val());

																					$(
																							'#hiddenIdBankPopUpEdit')
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
																			$(
																					this)
																					.dialog(
																							"close");

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

												$("#create-AddSalesEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-salesLineEdit")
																			.dialog(
																					"open");
																	tips
																			.text('');

																});
											});
											function removeSalesQuotEditNew(id) {
												//alert("removing row " + id);
												listEdit.pop(parseInt(id) - 1);
												$('#' + id).remove();
											}
											function editSalesQuotInEditNew(
													link) {
												//alert(link.id);
												listEdit.pop(parseInt(link.id) - 1);
												$("#dialog-form-salesLineEdit")
														.dialog("open");
												$('#materialIdEdit').val(
														$(
																'#materialIdEdit'
																		+ link)
																.val());
												$('#UOMIdEdit').val(
														$('#UOMIdEdit' + link)
																.val());
												$('#quantityEdit').val(
														$(
																'#quantityEdit'
																		+ link)
																.val());
												$('#currencyIdEdit').val(
														$(
																'#currencyIdEdit'
																		+ link)
																.val());
												$('#requiredDateEdit').val(
														$(
																'#requiredDateEdit'
																		+ link)
																.val());
												$('#deliveryDateEdit').val(
														$(
																'#deliveryDateEdit'
																		+ link)
																.val());
												$('#perUnitEdit')
														.val(
																$(
																		'#perUnitEdit'
																				+ link)
																		.val());
												$('#netPriceEdit').val(
														$(
																'#netPriceEdit'
																		+ link)
																.val());
												$('#lineAmountEdit').val(
														$(
																'#lineAmountEdit'
																		+ link)
																.val());
												$('#hiddenIdBankPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-salesLineEdit"
											title="<spring:message code="label.sqform" />">
											<p class="validateTips" align="center" style="color: blue;"></p>
											<table class="tableGeneral">
												<form:hidden path="esalesQuotationLineId" value="0" />

												<tr>
													<td><spring:message code="label.sqmatid" /><span
														class=required>*</span></td>
													<td><form:select path="ematerial_Id"
															id="materialIdEdit" class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.squomid" /> <span
														class=required>*</span></td>
													<td><form:select path="euom_Id" id="UOMIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>
												</tr>


												<tr>
													<td><spring:message code="label.sqqty" /><span
														class=required>*</span></td>
													<td><form:input path="equantity" id="quantityEdit"
															class="textbox" onkeyup="multiplyEdit()" maxlength="10" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.sqreqdate" /><span
														class=required>*</span></td>
													<td><form:input path="erequiredDate"
															id="requiredDateEdit" class="textbox" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.sqcurid" /> <span
														class=required>*</span></td>
													<td><form:select path="ecurrency_Id"
															id="currencyIdEdit" class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectCurrency}" />
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.sqdeldate" /><span
														class=required>*</span></td>
													<td><form:input path="edeliveryDate"
															id="deliveryDateEdit" class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.sqperunit" /><span
														class=required>*</span></td>
													<td><form:input path="eperUnit" id="perUnitEdit"
															class="textbox" onkeyup="multiplyEdit()" maxlength="10" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.sqnetprice" /><span
														class=required>*</span></td>
													<td><form:input path="enetPrice" id="netPriceEdit"
															class="textbox" readonly="true" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.sqlineamt" /><span
														class=required>*</span></td>
													<td><form:input path="elineAmount" id="lineAmountEdit"
															class="textbox" readonly="true" /></td>
												</tr>

												<tr>
													<td><input type="hidden" name="hiddenIdBankPopUpEdit"
														id="hiddenIdBankPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-contain-BankEdit">
											<!-- class="ui-widget" -->

											<div id="scroll1" align="center">
												<table id="AddSalesQuEdit" class="table">
													<thead>
														<tr>

															<th><spring:message code="label.sqmatid" /></th>
															<th><spring:message code="label.squomid" /></th>
															<th><spring:message code="label.sqqty" /></th>
															<th><spring:message code="label.sqreqdate" /></th>
															<th><spring:message code="label.sqcurid" /></th>
															<th><spring:message code="label.sqdeldate" /></th>
															<th><spring:message code="label.sqperunit" /></th>
															<th><spring:message code="label.sqnetprice" /></th>
															<th><spring:message code="label.sqlineamt" /></th>
															<th><spring:message code="label.edit" /></th>
															<th><spring:message code="label.remove" /></th>

														</tr>
													</thead>

													<tbody>
														<c:forEach var="salesQuotLineEditList"
															items="${salesQuotLineEditList}">

															<spring:bind
																path="salesQuotationCmd.esalesQuotationLineId">
																<input type="hidden" name="esalesQuotationLineId"
																	id="esalesQuotationLineId${salesQuotLineEditList.esalesQuotationLineId}"
																	value="${salesQuotLineEditList.esalesQuotationLineId}" />
															</spring:bind>
															<tr id="${salesQuotLineEditList.esalesQuotationLineId}">

																<td><spring:bind
																		path="salesQuotationCmd.ematerialId">
																		<input type="hidden" name="ematerialId"
																			class="textbox"
																			id="materialIdEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.ematerialId}" readonly />
																	</spring:bind> <spring:bind path="salesQuotationCmd.ematerialName">
																		<input type="text" name="materialName" class="textbox"
																			id="materialNameEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.ematerialName}"
																			readonly />
																	</spring:bind></td>


																<td><spring:bind path="salesQuotationCmd.eUOMId">
																		<input type="hidden" name="eUOMId"
																			id="UOMIdEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			class="textbox"
																			value="${salesQuotLineEditList.eUOMId}" readonly />
																	</spring:bind> <spring:bind path="salesQuotationCmd.euomName">
																		<input type="text" name="UomName"
																			id="uomNameEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			class="textbox"
																			value="${salesQuotLineEditList.euomName}" readonly />
																	</spring:bind></td>
																<td><spring:bind path="salesQuotationCmd.equantity">
																		<input type="text" name="equantity" class="textbox"
																			id="quantityEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.equantity}" readonly />
																	</spring:bind></td>

																<td><spring:bind
																		path="salesQuotationCmd.erequiredDate">
																		<input type="text" name="erequiredDate"
																			class="textbox"
																			id="requiredDateEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.erequiredDate}"
																			readonly />
																	</spring:bind></td>
																<td><spring:bind
																		path="salesQuotationCmd.ecurrencyId">
																		<input type="hidden" name="ecurrencyId"
																			class="textbox"
																			id="currencyIdEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.ecurrencyId}" readonly />
																	</spring:bind> <spring:bind path="salesQuotationCmd.ecurrencyName">
																		<input type="text" name="currencyName" class="textbox"
																			id="currencyNameEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.ecurrencyName}"
																			readonly />
																	</spring:bind></td>
																<td><spring:bind
																		path="salesQuotationCmd.edeliveryDate">
																		<input type="text" name="edeliveryDate"
																			class="textbox"
																			id="deliveryDateEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.edeliveryDate}"
																			readonly />
																	</spring:bind></td>
																<td><spring:bind path="salesQuotationCmd.eperUnit">
																		<input type="text" name="eperUnit" class="textbox"
																			id="perUnitEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.eperUnit}" readonly />
																	</spring:bind></td>
																<td><spring:bind path="salesQuotationCmd.enetPrice">
																		<input type="text" name="enetPrice" class="textbox"
																			id="netPriceEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.enetPrice}" readonly />
																	</spring:bind></td>
																<td><spring:bind
																		path="salesQuotationCmd.elineAmount">
																		<input type="text" name="elineAmount" class="textbox"
																			id="lineAmountEdit${salesQuotLineEditList.esalesQuotationLineId}"
																			value="${salesQuotLineEditList.elineAmount}" readonly />
																	</spring:bind></td>

																<td><a href="#"
																	id="${salesQuotLineEditList.esalesQuotationLineId}"
																	onclick="javascript:editSalesQuotInEdit(this.id)"><img
																		src="images/Edit.jpg" height="25px" width="25px"
																		id="edit${salesQuotLineEditList.esalesQuotationLineId}"></img></a>
																</td>
																	<c:if test="${delBtn==true}">
																<td><a href="#"
																	id="${salesQuotLineEditList.esalesQuotationLineId}"
																	onclick="javascript:getIDSQ(this.id)"><img
																		src="images/button_cancel.png" height="25px"
																		width="25px"
																		id="${salesQuotLineEditList.esalesQuotationLineId}"></img></a>

																	<input type="hidden"
																	name="Check${salesQuotLineEditList.esalesQuotationLineId}"
																	id="${salesQuotLineEditList.esalesQuotationLineId}Check"
																	value="0" /></td>
																	</c:if>
																<c:set var="delBtn" value="true"></c:set>
															</tr>

															<script>
																function getIDSQ(
																		link) {
																	//alert(link.id);
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link
																					+ "Check").value = "1";
																	document
																			.getElementById(link).style.display = "none";
																}
																function editSalesQuotInEdit(
																		id) {
																	//alert(""+ id);
																	listEdit.pop(parseInt(id));
																	$(
																			"#dialog-form-salesLineEdit")
																			.dialog(
																					"open");
																	$(
																			'#materialIdEdit')
																			.val(
																					$(
																							'#materialIdEdit'
																									+ id)
																							.val());
																	$(
																			'#UOMIdEdit')
																			.val(
																					$(
																							'#UOMIdEdit'
																									+ id)
																							.val());
																	$(
																			'#quantityEdit')
																			.val(
																					$(
																							'#quantityEdit'
																									+ id)
																							.val());
																	$(
																			'#currencyIdEdit')
																			.val(
																					$(
																							'#currencyIdEdit'
																									+ id)
																							.val());
																	$(
																			'#currencyNameEdit'
																					+ id)
																			.val(
																					$(
																							'#currencyIdEdit : selected')
																							.text());
																	$(
																			'#requiredDateEdit')
																			.val(
																					$(
																							'#requiredDateEdit'
																									+ id)
																							.val());
																	$(
																			'#deliveryDateEdit')
																			.val(
																					$(
																							'#deliveryDateEdit'
																									+ id)
																							.val());
																	$(
																			'#perUnitEdit')
																			.val(
																					$(
																							'#perUnitEdit'
																									+ id)
																							.val());
																	$(
																			'#netPriceEdit')
																			.val(
																					$(
																							'#netPriceEdit'
																									+ id)
																							.val());
																	$(
																			'#lineAmountEdit')
																			.val(
																					$(
																							'#lineAmountEdit'
																									+ id)
																							.val());
																	$(
																			'#hiddenIdBankPopUpEdit')
																			.val(
																					id);

																}
															</script>

														</c:forEach>


														<script type="text/javascript">
															function forAddRowEdit(
																	id) {

																//alert("came "+id);
																var optionsEdit = '<table><tr ><td><table  class="table" >'

																		+ '<tr>'
																		+ '<td><spring:bind path="salesQuotationCmd.ematerialId"><input type="hidden" name="ematerialId" id="materialIdEdit'+id+'"  class="textbox"/></spring:bind>'
																		+ '<input type="text" name="ematerialName" id="materialNameEdit'+id+'"  class="textbox" readOnly/> </td>'
																		+ '<td><spring:bind path="salesQuotationCmd.eUOMId"><input type="hidden" name="eUOMId" id="UOMIdEdit'+id+'" class="textbox" /></spring:bind>'
																		+ '<input type="text" name="euomName" id="uomNameEdit'+id+'" class="textbox" readOnly /></td>'
																		+ '<td><spring:bind path="salesQuotationCmd.equantity"><input name="equantity" id="quantityEdit'
																		+ id
																		+ '" onkeyup="multiplication('
																		+ id
																		+ ')"  class="textbox" readOnly /></spring:bind></td>'
																		+ '<td><spring:bind path="salesQuotationCmd.erequiredDate"><input name="erequiredDate" id="requiredDateEdit'+id+'"  class="textbox"  readOnly/></spring:bind></td>'
																		+ '<td><spring:bind path="salesQuotationCmd.ecurrencyId"><input name="ecurrencyId" type="hidden" class="textbox" id="currencyIdEdit'+id+'" readOnly/></spring:bind>'
																		+ '<input type="text" class="textbox" name="ecurrencyName" id="currencyNameEdit'
																		+ id
																		+ '" value="'
																		+ $(
																				'#currencyIdEdit :selected')
																				.text()
																		+ '"  readOnly/></td>'
																		+ '<td><spring:bind path="salesQuotationCmd.edeliveryDate"><input type="text" name="edeliveryDate" class="textbox" id="deliveryDateEdit'+id+'"   readOnly/></spring:bind></td>'
																		+ '<td><spring:bind path="salesQuotationCmd.eperUnit"><input name="eperUnit" class="textbox" id="perUnitEdit'
																		+ id
																		+ '" onkeyup="multiplication('
																		+ id
																		+ ')" readOnly/></spring:bind></td>'
																		+ '<td><spring:bind path="salesQuotationCmd.enetPrice"><input name="enetPrice" class="textbox" id="netPriceEdit'+id+'" readOnly/></spring:bind></td>'
																		+ '<td><spring:bind path="salesQuotationCmd.elineAmount"><input name="elineAmount" class="textbox" id="lineAmountEdit'+id+'" readOnly/></spring:bind></td>'
																		+ '<spring:bind path="salesQuotationCmd.esalesQuotationLineId"><input type="hidden" name="esalesQuotationLineId"  value="0"/></spring:bind>'
																		+ '</td></tr></table>'

																		+ "<a href='#' id='"
																		+ id
																		+ "' onclick='editSalesQuotInEdit("
																		+ id
																		+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a>"

																		+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="removeEdit"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a>'
																		+ '</td></tr></table>';

																$(optionsEdit)
																		.fadeIn(
																				"slow")
																		.appendTo(
																				'#extenderEdit');

																$('.removeEdit')
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

															}
														</script>

													</tbody>

												</table>

												<div id="extenderEdit"></div>
												<button id="create-AddSalesEdit" type="button">
													<spring:message code="label.newsalesquotline" />
												</button>
											</div>

										</div>


									</div>

								</div>

							</div>
							<table>
								<tr>

									<c:choose>

										<c:when test="${update}">

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