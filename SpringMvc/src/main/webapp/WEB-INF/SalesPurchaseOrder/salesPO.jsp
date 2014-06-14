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
<title>My JSP 'salesPO.jsp' starting page</title>

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
						//Json Data	
						$('#salesPOQuotId')
								.change(
										function() {
											//alert($(this).val());
											var msg;
											//alert($(this).val());
											var id = $(this).val();
											if (id == 0) {
												msg = confirm("Do U Want Remove Sales Quotation Line Details?");
											} else {
												msg = confirm("Do U Want Add Sales Quotation Line Details?");
											}
											if (msg == true) {

												$
														.ajax({
															type : "POST",
															url : "salesQuotDetails.mnt",
															data : "salesQuotId="
																	+ $(this)
																			.val(),
															success : function(
																	data) {
																//alert("data  "+data); 
																$('#extender')
																		.empty();
																var raw = JSON
																		.parse(data);

																$
																		.each(
																				raw,
																				function(
																						idx,
																						item) {
																					//$('#extender').show();
																					forAddRow(item.count);
																					$(
																							"#materialId"
																									+ item.count)
																							.val(
																									item.materialId);
																					$(
																							"#materialName"
																									+ item.count)
																							.val(
																									item.ematerialName);
																					$(
																							"#quantity"
																									+ item.count)
																							.val(
																									item.quantity);
																					$(
																							"#UOMId"
																									+ item.count)
																							.val(
																									item.umId);
																					$(
																							"#uomName"
																									+ item.count)
																							.val(
																									item.euomName);
																					$(
																							"#currenId"
																									+ item.count)
																							.val(
																									item.currencyId);
																					$(
																							"#currencyName"
																									+ item.count)
																							.val(
																									item.ecurrencyName);
																					$(
																							"#unitPrice"
																									+ item.count)
																							.val(
																									item.perUnit);
																					$(
																							"#lineAmount"
																									+ item.count)
																							.val(
																									item.lineAmount);
																					$('#spoId').val(1);

																				});

															}
														});
											}

										});

						$('#esalesPOQuotId')
								.change(
										function() {
											var c;
											//alert($(this).val());
											var value = $(this).val();
											if (value == 0) {
												c = confirm("Do U Want Remove Sales Quotation Line Details?");
											} else {
												c = confirm("Do U Want Add Sales Quotation Line Details?");
											}
											if (c == true) {
												$
														.ajax({
															type : "POST",
															url : "salesQuotDetails.mnt",
															data : "salesQuotId="
																	+ $(this)
																			.val(),
															success : function(
																	data) {
																//alert("data  "+data); 
																$(
																		'#extenderEdit')
																		.empty();
																var raw = JSON
																		.parse(data);
																$
																		.each(
																				raw,
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
																									item.euomName);
																					$(
																							"#currenIdEdit"
																									+ item.count)
																							.val(
																									item.currencyId);
																					$(
																							"#currencyNameEdit"
																									+ item.count)
																							.val(
																									item.ecurrencyName);
																					$(
																							"#unitPriceEdit"
																									+ item.count)
																							.val(
																									item.perUnit);
																					$(
																							"#lineAmountEdit"
																									+ item.count)
																							.val(
																									item.lineAmount);

																				});

															}
														});
											}

										});

						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addSalesForm')
													.validate(
															{
																rules : {
																	salesPONbr : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},

																	salesPODate : {
																		required : true
																	},
																	salesPOValue : {
																		required : true,
																		number : true
																	},
																	description : {
																		required : true
																	},
																	customerId : {
																		required : true
																	},
																	paymentTermId : {
																		required : true
																	},
																	currencyId : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	dueDate : {
																		required : true
																	},
																	memo : {
																		required : true
																	},
																	salesTaxAmount : {
																		required : true,
																		number : true
																	},
																	VATAmount : {
																		required : true,
																		number : true
																	},
																	exiciseAmount : {
																		required : true,
																		number : true
																	},
																	frieghtCharges : {
																		required : true,
																		number : true
																	},
																	PnFCharges : {
																		required : true,
																		number : true
																	},

																},
																messages : {
																	salesPONbr : {
																		required:"<font style='color: red;'><b>Sales Purchase Order No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	salesPODate : "<font style='color: red;'><b>Sales Purchase Order Date is Required</b></font>",
																	salesPOValue : {
																		required:"<font style='color: red;'><b>Sales Purchase Order Value is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	description : "<font style='color: red;'><b>Description is Required</b></font>",
																	customerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	paymentTermId : "<font style='color: red;'><b>Payment Term is Required</b></font>",
																	currencyId : "<font style='color: red;'><b>Currency Name is Required</b></font>",
																	
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	dueDate : "<font style='color: red;'><b>Due Date is Required</b></font>",
																	memo : "<font style='color: red;'><b>Memo is Required</b></font>",
																	salesTaxAmount : {
																		required:"<font style='color: red;'><b>Sales TaxAmount is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	VATAmount : {
																		required:"<font style='color: red;'><b>VAT Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	exiciseAmount : {
																		required:"<font style='color: red;'><b>Exicise Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	frieghtCharges : {
																		required:"<font style='color: red;'><b>Frieght Charges is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	PnFCharges :{
																		required:"<font style='color: red;'><b>PNF Charges is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},

																},

															});
											
											if ($('#salesPONbr').val() != ""
												&& $('#dueDate').val() != ""
												&& $('#statusId').val() != ""
												&& $('#description').val() != "") {
											if ($('#spoId').val() == 0) {
												//alert("Please Enter AtLeast One Sales Purchase Order Line");
												document
														.getElementById("childMsg").style.display = "block";
												$('#childMsg')
														.html(
																"Warning! Please Enter AtLeast One Sales Purchase Order Line");
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
																	esalesPONbr : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},

																	esalesPODate : {
																		required : true
																	},
																	esalesPOValue : {
																		required : true,
																		number : true
																	},
																	edescription : {
																		required : true
																	},
																	ecustomerId : {
																		required : true
																	},
																	epaymentTermId : {
																		required : true
																	},
																	ecurrencyId : {
																		required : true
																	},
																	estatusId : {
																		required : true
																	},
																	edueDate : {
																		required : true
																	},
																	ememo : {
																		required : true
																	},
																	esalesTaxAmount : {
																		required : true,
																		number : true
																	},
																	eVATAmount : {
																		required : true,
																		number : true
																	},
																	eexiciseAmount : {
																		required : true,
																		number : true
																	},
																	efrieghtCharges : {
																		required : true,
																		number : true
																	},
																	ePnFCharges : {
																		required : true,
																		number : true
																	},
																},
																messages : {
																	esalesPONbr : {
																		required:"<font style='color: red;'><b>Sales Purchase Order No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	esalesPODate : "<font style='color: red;'><b>Sales Purchase Order Date is Required</b></font>",
																	esalesPOValue : {
																		required:"<font style='color: red;'><b>Sales Purchase Order Value is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	edescription : "<font style='color: red;'><b>Description is Required</b></font>",
																	ecustomerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	epaymentTermId : "<font style='color: red;'><b>Payment Term is Required</b></font>",
																	ecurrencyId : "<font style='color: red;'><b>Currency Name is Required</b></font>",
																	estatusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	edueDate : "<font style='color: red;'><b>Due Date is Required</b></font>",
																	ememo : "<font style='color: red;'><b>Memo is Required</b></font>",
																	esalesTaxAmount : {
																		required:"<font style='color: red;'><b>Sales TaxAmount is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	eVATAmount :{
																		required:"<font style='color: red;'><b>VAT Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	} ,
																	eexiciseAmount :{
																		required:"<font style='color: red;'><b>Exicise Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	} ,
																	efrieghtCharges :{
																		required:"<font style='color: red;'><b>Frieght Charges is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	ePnFCharges : {
																		required:"<font style='color: red;'><b>PNF Charges  is Required</b></font>",
																		number:"<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},

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
				'#spoDate,#dueDate,#dueDateChild')
				.datepicker({
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					onSelect : function(d){
						var date=$('#spoDate').datepicker('getDate');
						date.setDate(date.getDate()+0);
						$('#dueDate,#dueDateChild').datepicker('option','minDate',date);
					}

				});
		
		$(
		'#spoDateEdit,#dueDateEdit,#dueDateChildEdit')
		.datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true,
			onSelect : function(d){
				var date=$('#spoDateEdit').datepicker('getDate');
				date.setDate(date.getDate()+0);
				$('#dueDateEdit,#dueDateChildEdit').datepicker('option','minDate',date);
			}

		});

	};
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
	width: 1100px;
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
		var unitPrice = document.getElementById("unitPrice").value;
		var result = quantity * unitPrice;
		document.getElementById("lineAmount").value = result;

	}
	function multiplyEdit() {

		var quantity = $("#quantityEdit").val();
		var unitPrice = document.getElementById("unitPriceEdit").value;
		var result = quantity * unitPrice;
		document.getElementById("lineAmountEdit").value = result;

	}

	function AjaxForDuplicate() {
		var cust = $('#salesPONbr').val();
		//alert(cust);
		$
				.ajax({
					type : "POST",
					url : "checkSPOAddDuplicate.mnt",
					data : "salesPONo=" + cust,
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
		var cust = $('#esalesPONbr').val();
		var id = $('#esalesPOId').val();
		//alert(id);
		$
				.ajax({
					type : "POST",
					url : "checkSPOUpdateDuplicate.mnt",
					data : "esalesPONo=" + cust + "&spoId=" + id,
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

		if (document.getElementById("spoId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
		$('#sumbnasdStop').click(function(e) {
			document.getElementById("spoId").value = 1;
			//alert(document.getElementById("asId").value);
		});

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#basicSearchId').focus();
			$('#salesPONbr').focus();
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Sales Purchase Order</div>

		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:if test="${salesPOEditList!=null}">

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

					<form:form method="GET" action="salesPOSearch.mnt"
						commandName="salesPOCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addSPOSus"
										items="${param.addSPOSus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sales" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="addSPOFail"
										items="${param.addSPOFail}">
										<div class="alert-danger" id="savemessage">
										<strong><spring:message code="label.error" /> </strong>
										<spring:message code="label.sales" />
										<spring:message code="label.saveFail" />
											</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="UpdateSPOsus"
										items="${param.UpdateSPOsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sales" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSPOFail"
										items="${param.UpdateSPOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sales" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteSPOsus"
										items="${param.DeleteSPOsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sales" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteSPOFail"
										items="${param.DeleteSPOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sales" />
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
							
							<form:form action="SPOAdvanceSearch.mnt" method="get"
								commandName="salesPOCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="SPOAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>

						</table>
						
						<form:form action="SPOAdvanceSearchOperations.mnt"
							commandName="salesPOCmd" method="get">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="salesPOCmd.asOpts">
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
											<td><spring:bind path="salesPOCmd.asOpts">
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
											<c:set var="paymentTermId" value="paymentTermId" />
											<c:set var="customerId" value="customerId" />
											
											<c:if test="${bdField eq customerId}">
												<c:set var="selectBox" value="${custSelect}" />
											</c:if>
											<c:if test="${bdField eq paymentTermId}">
												<c:set var="selectBox" value="${paymentTermSelect}" />
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
					
						<c:if test="${SPOList!=null }">
						<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="SPOAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="salesPOSearch.mnt" />
							</c:otherwise>

						</c:choose>
							<display:table name="SPOList" id="SPOIdList" class="table"
								requestURI="${search}" pagesize="5">

								<display:column property="salesPOId" sortable="true"
									title="salesPOId" media="none" />

								<display:column property="salesPONbr" sortable="true"
									titleKey="label.sponbr" media="html" />

								<display:column property="customerId" sortable="true"
									titleKey="label.spocustid" media="html" />


								<display:column property="salesPODate" sortable="true"
									titleKey="label.spodate" media="html" />

								<display:column property="salesPOValue" sortable="true"
									titleKey="label.spovalue" media="html" />


								<display:column property="description" sortable="true"
									titleKey="label.spodesc" media="none" />

								<display:column property="statusId" sortable="true"
									titleKey="label.spostid" media="html" />

								<display:column property="paymentTermId" sortable="true"
									titleKey="label.spopaymentid" media="html" />

								<display:column property="currencyId" sortable="true"
									titleKey="label.spocurid" media="html" />

								<display:column property="salesTaxAmount" sortable="true"
									titleKey="label.spostamt" media="html" />

								<display:column property="VATAmount" sortable="true"
									titleKey="label.spovatamt" media="html" />

								<display:column property="exiciseAmount" sortable="true"
									titleKey="label.spoexcamt" media="html" />

								<display:column property="frieghtCharges" sortable="true"
									titleKey="label.spofrncharges" media="html" />

								<display:column property="dueDate" sortable="true"
									titleKey="label.spoduedate" media="html" />

								<display:column titleKey="label.edit">
									<c:choose>
										<c:when test="${edit}">
											<a
												href="SalesPOEdit.mnt?salesPOId=<c:out value="${SPOIdList.salesPOId}"/> "><img
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
												href="salesPODelete.mnt?salesPOId=<c:out value="${SPOIdList.salesPOId}"/> "
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
									<spring:message code="label.sponbr" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="salesPOAdd.mnt" method="POST"
						commandName="salesPOCmd" id="addSalesForm">

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">
										<tr>
											<td><spring:message code="label.sponbr" /><span
												class="required">*</span></td>
											<td><form:input path="salesPONbr" id="salesPONbr"
													cssClass="textbox" onkeyup="AjaxForDuplicate()"
													maxlength="50" /></td>

											<td><spring:message code="label.spoduedate" /><span
												class="required">*</span></td>
											<td><form:input path="dueDate" cssClass="textbox"
													id="dueDate" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.spodate" /><span
												class="required">*</span></td>
											<td><form:input path="salesPODate" cssClass="textbox"
													id="spoDate" /></td>

											<td><spring:message code="label.spomemo" /><span
												class="required">*</span></td>
											<td><form:input path="memo" cssClass="textbox" maxlength="50"/></td>
										</tr>

										<tr>
											<td><spring:message code="label.spovalue" /><span
												class="required">*</span></td>
											<td><form:input path="salesPOValue" cssClass="textbox" maxlength="13"/></td>
											<td><spring:message code="label.spostamt" /><span
												class="required">*</span></td>
											<td><form:input path="salesTaxAmount" cssClass="textbox" maxlength="13"/></td>

										</tr>

										<tr>
											<td><spring:message code="label.sposq" /><span
												class="required"></span></td>
											<td><form:select path="salesQuotationId"
													id="salesPOQuotId" cssClass="select">
													<form:option value="0">-Select-</form:option>
													<form:options items="${salesQuotSelect}" />
												</form:select></td>

											<td><spring:message code="label.spovatamt" /><span
												class="required">*</span></td>
											<td><form:input path="VATAmount" cssClass="textbox" maxlength="13"/></td>
										</tr>

										<tr>
											<td><spring:message code="label.spocustid" /><span
												class="required">*</span></td>
											<td><form:select path="customerId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${custSelect}" />

												</form:select></td>

											<td><spring:message code="label.spoexcamt" /><span
												class="required">*</span></td>
											<td><form:input path="exiciseAmount" cssClass="textbox" maxlength="13"/></td>

										</tr>

										<tr>
											<td><spring:message code="label.spopaymentid" /><span
												class="required">*</span></td>
											<td><form:select path="paymentTermId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${paymentTermSelect}" />

												</form:select></td>

											<td><spring:message code="label.spofrncharges" /><span
												class="required">*</span></td>
											<td><form:input path="frieghtCharges" cssClass="textbox" maxlength="13"/></td>

										</tr>
										<tr>
											<td><spring:message code="label.spocurid" /><span
												class="required">*</span></td>
											<td><form:select path="currencyId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${SelectCurrency}" />

												</form:select></td>

											<td><spring:message code="label.spopnfchs" /><span
												class="required">*</span></td>
											<td><form:input path="PnFCharges" cssClass="textbox" maxlength="13"/></td>

										</tr>
										<tr>
											<td><spring:message code="label.spostid" /><span
												class="required">*</span></td>
											<td><form:select path="statusId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${statusSelect}" />

												</form:select></td>

											<td><spring:message code="label.spodesc" /><span
												class="required">*</span></td>
											<td><form:textarea path="description" cssClass="textbox"
													maxlength="250" />
													<input type="hidden" name="spoId"
												id="spoId" class="textbox" value="0" />
													</td>

										</tr>

									</table>

								</td>

							</tr>

						</table>

						<!-- window 2 -->

						<div id="tabss" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.spoline" /></a></li>
							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1" align="center">

								<!-- Model Pop-up Start-->

								<div align="center" id="subscroll">

									<script type="text/javascript">
										var btrid = 10;

										$(document)
												.ready(
														function() {

															var matId = $("#materialId"), qty = $("#quantity"), uomId = $("#UOMId"), currcId = $("#currenId"), dueDate = $("#dueDateChild"), unitPrice = $("#unitPrice"), lineAmt = $("#lineAmount"), hiddenID = $("#hiddenIdSalesPopUp"),

															allFields = $([])
																	.add(matId)
																	.add(qty)
																	.add(uomId)
																	.add(
																			currcId)
																	.add(
																			dueDate)
																	.add(
																			unitPrice)
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
																				height : 350,
																				width : 380,
																				modal : true,
																				buttons : {
																					Submit : function() {
																						var bValid = true;
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
																								&& required(
																										currcId,

																										"Currency");

																						bValid = bValid
																								&& checkRegexp(
																										qty,
																										/^([0-9.])+$/i,
																										"Quantity is Required And Must be  Number");

																						bValid = bValid
																								&& checkRegexp(
																										unitPrice,
																										/^([0-9.])+$/i,
																										"Unit Price is Required And Must be  Number");
																						bValid = bValid
																								&& checkRegexp(
																										lineAmt,
																										/^([0-9.])+$/i,
																										"Line Amount is Required And Must be  Number");
																						bValid = bValid
																								&& required(
																										dueDate,

																										"Due Date");

																						if (bValid) {

																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {

																								$(
																										"#SalesLineAdd tbody")
																										.append(

																												"<tr id="+btrid+">"
																														+ "<td ><spring:bind path='salesPOCmd.materialId'><input type='hidden' name='materialId' id='materialId"
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
																														+ "<td><input type='hidden' name='curId' id='currenId"
																														+ btrid
																														+ "' value="
																														+ currcId
																																.val()

																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='currencyName' id='currencyName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#currenId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input name='quantity' id='quantity"
																														+ btrid
																														+ "' value="
																														+ qty
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><input name='unitPrice' id='unitPrice"
																														+ btrid
																														+ "' value="
																														+ unitPrice
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><input name='lineAmount' id='lineAmount"
																														+ btrid
																														+ "' value="
																														+ lineAmt
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><input name='dueDateChild' id='dueDateChild"
																														+ btrid
																														+ "' value="
																														+ dueDate
																																.val()

																														+ " class='textbox' readonly/></td>"

																														+ "<td><a href='#'  onclick='editSalesPOLine("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeSalesPOLine("
																														+ btrid
																														+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																														+ "</tr>");
																								$('#spoId').val(btrid);

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
																										'#currenId'
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
																														'#currenId :selected')
																														.text());
																								$(
																										'#unitPrice'
																												+ hiddenID
																														.val())
																										.val(
																												unitPrice
																														.val());
																								$(
																										'#lineAmount'
																												+ hiddenID
																														.val())
																										.val(
																												lineAmt
																														.val());
																								$(
																										'#dueDateChild'
																												+ hiddenID
																														.val())
																										.val(
																												dueDate
																														.val());

																								$(
																										'#hiddenIdSalesPopUp')
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
																				//alert("opened");
																				tips.text('');
																			});
														});

										function removeSalesPOLine(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editSalesPOLine(id) {
											//alert("edit row " + id);
											$("#dialogformsalesLine").dialog(
													"open");
											$(".validateTips").text('');
											$('#materialId')
													.val(
															$(
																	'#materialId'
																			+ id)
																	.val());
											$('#quantity').val(
													$('#quantity' + id).val());
											$('#currenId').val(
													$('#currenId' + id).val());
											$('#UOMId').val(
													$('#UOMId' + id).val());
											$('#unitPrice').val(
													$('#unitPrice' + id).val());
											$('#lineAmount')
													.val(
															$(
																	'#lineAmount'
																			+ id)
																	.val());
											$('#dueDateChild').val(
													$('#dueDateChild' + id)
															.val());
											$('#hiddenIdSalesPopUp').val(id);

										}
									</script>

									<div id="dialogformsalesLine" align="center"
										title="<spring:message code="label.spoform" />">
										<p class="validateTips" align="center" style="color: blue;"></p>
										<table class="tableGeneral">
											<tr>
												<td><spring:message code="label.spolmatid" /><span
													class=required>*</span></td>
												<td><form:select path="material_Id" id="materialId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.spoluomid" /> <span
													class=required>*</span></td>
												<td><form:select path="uom_Id" id="UOMId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.spolcurid" /> <span
													class=required>*</span></td>
												<td><form:select path="currency_Id" id="currenId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectCurrency}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.spolqty" /><span
													class=required>*</span></td>
												<td><form:input path="quantity" id="quantity"
														class="textbox" onkeyup="multiply()" maxlength="13"/></td>
											</tr>

											<tr>
												<td><spring:message code="label.spolunit" /><span
													class=required>*</span></td>
												<td><form:input path="unitPrice" id="unitPrice"
														class="textbox" onkeyup="multiply()" maxlength="13"/></td>
											</tr>

											<tr>
												<td><spring:message code="label.spollineamt" /><span
													class=required>*</span></td>
												<td><form:input path="lineAmount" id="lineAmount"
														class="textbox" readonly="true" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.spolduedate" /><span
													class=required>*</span></td>
												<td><form:input path="dueDateChild" id="dueDateChild"
														class="textbox" /></td>
											</tr>

											<tr>
												<td><input type="hidden" name="hiddenIdSalesPopUp"
													id="hiddenIdSalesPopUp" value="0" />
											</tr>

										</table>
									</div>
								</div>

								<div id="users-SalesLine">
									<div id="scroll1">
										<table id="SalesLineAdd" class="table">

											<tr>
												<th><spring:message code="label.spolmatid" /></th>
												<th><spring:message code="label.spoluomid" /></th>
												<th><spring:message code="label.spolcurid" /></th>
												<th><spring:message code="label.spolqty" /></th>
												<th><spring:message code="label.spolunit" /></th>
												<th><spring:message code="label.spollineamt" /></th>
												<th><spring:message code="label.spolduedate" /></th>
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>
											</tr>

										</table>

										<script type="text/javascript">
											function forAddRow(id) {

												//alert("came "+id);
												var options = '<table><tr ><td><table  class="table" >'

														+ '<tr>'
														+ '<td><spring:bind path="salesPOCmd.materialId"><input type="hidden" name="materialId" id="materialId'+id+'" class="textbox"/></spring:bind>'
														+ '<spring:bind path="salesPOCmd.materialName"><input type="text" name="materialName" id="materialName'+id+'" class="textbox" readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesPOCmd.UOMId"><input type="hidden" name="UOMId" id="UOMId'+id+'" class="textbox" /></spring:bind>'
														+ '<spring:bind path="salesPOCmd.uomName"><input type="text" name="uomName" id="uomName'+id+'" class="textbox" readOnly /></spring:bind></td>'
														+ '<td><spring:bind path="salesPOCmd.curId"><input name="curId" type="hidden" class="textbox" id="currenId'+id+'" readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesPOCmd.currencyName"><input  type="text" class="textbox" name="currencyName" id="currencyName'+id+'" readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesPOCmd.quantity"><input name="quantity" id="quantity'+id+'"  class="textbox" readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesPOCmd.unitPrice"><input name="unitPrice" id="unitPrice'+id+'"  class="textbox"  readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesPOCmd.lineAmount"><input name="lineAmount" class="textbox" id="lineAmount'+id+'" readOnly/></spring:bind></td>'
														+ '<td><spring:bind path="salesPOCmd.dueDateChild"><input type="text" name="dueDateChild" class="textbox" id="dueDateChild'+id+'" readOnly/></spring:bind></td>'
														+ '</td></tr></table>'

														+ "<a href='#'  onclick='editSalesPOLine("
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
											function multiplication(id) {
												var netPrice = $(
														"#netPrice" + id).val();
												var perUnit = document
														.getElementById("perUnit"
																+ id).value;
												var result = netPrice * perUnit;
												document
														.getElementById("lineAmount"
																+ id).value = result;

											}
										</script>

										<table>

											<tbody>
											</tbody>
										</table>

										<div id="extender"></div>
										<button id="createAddSalesLine" type="button">
											<spring:message code="label.newspoline" />
										</button>
									</div>
								</div>


							</div>


							<!-- Model Pop-up End-->
						</div>

						<!-- window 2 -->
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
									<spring:message code="label.sponbr" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form method="post" action="salesPOUpdate.mnt"
						commandName="salesPOCmd" id="editSalesForm">
						<c:forEach var="salesPOEditList" items="${salesPOEditList}">
							<c:set var="editMode" value="${salesPOEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td>
										<div>

											<table class="tableGeneral">

												<form:hidden path="esalesPOId" id="esalesPOId" />
												<form:hidden path="ecreatedBy" id="ecreatedBy" />
												<form:hidden path="ecreatedDTTM" id="ecreatedDTTM" />
												<tr>
													<td><spring:message code="label.sponbr" /><span
														class="required">*</span></td>
													<td><form:input path="esalesPONbr" id="esalesPONbr"
															cssClass="textbox" onkeyup="AjaxUpdateDuplicate()"
															maxlength="50" /></td>

													<td><spring:message code="label.spoduedate" /><span
														class="required">*</span></td>
													<td><form:input path="edueDate" cssClass="textbox"
															id="dueDateEdit" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.spodate" /><span
														class="required">*</span></td>
													<td><form:input path="esalesPODate" cssClass="textbox"
															id="spoDateEdit" /></td>

													<td><spring:message code="label.spomemo" /><span
														class="required">*</span></td>
													<td><form:input path="ememo" cssClass="textbox" maxlength="50"/></td>
												</tr>

												<tr>
													<td><spring:message code="label.spovalue" /><span
														class="required">*</span></td>
													<td><form:input path="esalesPOValue"
															cssClass="textbox" maxlength="13"/></td>
													<td><spring:message code="label.spostamt" /><span
														class="required">*</span></td>
													<td><form:input path="esalesTaxAmount"
															cssClass="textbox" maxlength="13"/></td>

												</tr>

												<tr>
													<td><spring:message code="label.sposq" /><span
														class="required"></span></td>
													<td><form:select path="esalesQuotationId"
															id="esalesPOQuotId" cssClass="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${salesQuotSelect}" />
														</form:select></td>

													<td><spring:message code="label.spovatamt" /><span
														class="required">*</span></td>
													<td><form:input path="eVATAmount" cssClass="textbox" maxlength="13"/></td>
												</tr>

												<tr>
													<td><spring:message code="label.spocustid" /><span
														class="required">*</span></td>
													<td><form:select path="ecustomerId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${custSelect}" />

														</form:select></td>

													<td><spring:message code="label.spoexcamt" /><span
														class="required">*</span></td>
													<td><form:input path="eexiciseAmount"
															cssClass="textbox" maxlength="13"/></td>

												</tr>

												<tr>
													<td><spring:message code="label.spopaymentid" /><span
														class="required">*</span></td>
													<td><form:select path="epaymentTermId"
															cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${paymentTermSelect}" />

														</form:select></td>

													<td><spring:message code="label.spofrncharges" /><span
														class="required">*</span></td>
													<td><form:input path="efrieghtCharges"
															cssClass="textbox" maxlength="13"/></td>

												</tr>
												<tr>
													<td><spring:message code="label.spocurid" /><span
														class="required">*</span></td>
													<td><form:select path="ecurrencyId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${SelectCurrency}" />

														</form:select></td>

													<td><spring:message code="label.spopnfchs" /><span
														class="required">*</span></td>
													<td><form:input path="ePnFCharges" cssClass="textbox" maxlength="13"/></td>

												</tr>
												<tr>
													<td><spring:message code="label.spostid" /><span
														class="required">*</span></td>
													<td><form:select path="estatusId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${statusSelect}" />

														</form:select></td>

													<td><spring:message code="label.spodesc" /><span
														class="required">*</span></td>
													<td><form:textarea path="edescription"
															cssClass="textbox" maxlength="250" /></td>

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
												code="label.spoline" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 50;

											$(function() {

												var matIdEdit = $("#materialIdEdit"), qtyEdit = $("#quantityEdit"), uomIdEdit = $("#UOMIdEdit"), currcIdEdit = $("#currenIdEdit"), dueDateEdit = $("#dueDateChildEdit"), unitPriceEdit = $("#unitPriceEdit"), lineAmtEdit = $("#lineAmountEdit"), hiddenEdit = $("#hiddenIdSalesPopUpEdit"),

												allFields = $([])
														.add(matIdEdit).add(
																qtyEdit).add(
																uomIdEdit).add(
																currcIdEdit)
														.add(dueDateEdit).add(
																unitPriceEdit)
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
																	height : 350,
																	width : 380,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
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
																							/^([0-9.])+$/i,
																							"Quantity is Required And Must be  Number");

																			bValid1 = bValid1
																					&& checkRegexp(
																							unitPriceEdit,
																							/^([0-9.])+$/i,
																							"Per Unit is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkRegexp(
																							lineAmtEdit,
																							/^([0-9.])+$/i,
																							"Net Price is Required And Must be  Number");

																			bValid1 = bValid1
																					&& required(
																							dueDateEdit,

																							"Required Date");

																			// alert("edi"+ hiddenEdit.val());
																			if (bValid1) {

																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {

																					$(
																							"#AddSalesEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td ><spring:bind path='salesPOCmd.ematerialId'><input type='hidden' name='ematerialId' id='materialIdEdit"
																											+ btrid
																											+ "' value="
																											+ matIdEdit
																													.val()

																											+ " class='textbox' readonly/></spring:bind> "
																											+ "<input type='text' readonly class='textbox' name='ematerialName' id='materialNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#materialIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><spring:bind path='salesPOCmd.eUOMId'><input type='hidden' name='eUOMId' id='UOMIdEdit"
																											+ btrid
																											+ "' value="
																											+ uomIdEdit
																													.val()

																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text' class='textbox' readonly name='euomName' id='uomNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#UOMIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><input type='hidden' name='ecurId' id='currenIdEdit"
																											+ btrid
																											+ "' value="
																											+ currcIdEdit
																													.val()

																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='ecurrencyName' id='currencyNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#currenIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"
																											+ "<td><input name='equantity' id='quantityEdit"
																											+ btrid
																											+ "' value="
																											+ qtyEdit
																													.val()

																											+ " class='textbox' readonly/></td>"
																											+ "<td><input name='eunitPrice' id='unitPriceEdit"
																											+ btrid
																											+ "' value="
																											+ unitPriceEdit
																													.val()

																											+ " class='textbox' readonly/></td>"

																											+ "<td><input name='elineAmount' id='lineAmountEdit"
																											+ btrid
																											+ "' value="
																											+ lineAmtEdit
																													.val()

																											+ " class='textbox' readonly/></td>"
																											+ "<td><input name='edueDateChild' id='dueDateChildEdit"
																											+ btrid
																											+ "' value="
																											+ dueDateEdit
																													.val()

																											+ " class='textbox' readonly/></td>"

																											+ "<input type='hidden' name='esalesPOLineId' id='esalesPOLineId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"

																											+ "<td><a href='#'  onclick='editSalesPOInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeSalesPOEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					btrid++;
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
																							'#currenIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#currenIdEdit')
																											.val());
																					$(
																							'#currencyNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#currenIdEdit :selected')
																											.text());
																					$(
																							'#dueDateChildEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#dueDateChildEdit')
																											.val());
																					$(
																							'#unitPriceEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#unitPriceEdit')
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
																							'#hiddenIdSalesPopUpEdit')
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
																	tips.text('');

																});
											});
											function removeSalesPOEditNew(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editSalesPOInEditNew(link) {
												//alert(link.id);
												$(".validateTips").text('');
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
												$('#currenIdEdit').val(
														$(
																'#currenIdEdit'
																		+ link)
																.val());
												$('#dueDateChildEdit').val(
														$(
																'#dueDateChildEdit'
																		+ link)
																.val());
												$('#unitPriceEdit').val(
														$(
																'#unitPriceEdit'
																		+ link)
																.val());
												$('#lineAmountEdit').val(
														$(
																'#lineAmountEdit'
																		+ link)
																.val());

												$('#hiddenIdSalesPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-salesLineEdit"
											title="<spring:message code="label.spoform" />">
											<p class="validateTips" align="center" style="color: blue;"></p>
											<table class="tableGeneral">
												<form:hidden path="esalesPOLineId" value="0" />

												<tr>
													<td><spring:message code="label.spolmatid" /><span
														class=required>*</span></td>
													<td><form:select path="ematerial_Id"
															id="materialIdEdit" class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.spoluomid" /> <span
														class=required>*</span></td>
													<td><form:select path="euom_Id" id="UOMIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.spolcurid" /> <span
														class=required>*</span></td>
													<td><form:select path="ecurrency_Id" id="currenIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectCurrency}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.spolqty" /><span
														class=required>*</span></td>
													<td><form:input path="equantity" id="quantityEdit"
															class="textbox" onkeyup="multiplyEdit()" maxlength="13"/></td>
												</tr>

												<tr>
													<td><spring:message code="label.spolunit" /><span
														class=required>*</span></td>
													<td><form:input path="eunitPrice" id="unitPriceEdit"
															class="textbox" onkeyup="multiplyEdit()" maxlength="13"/></td>
												</tr>

												<tr>
													<td><spring:message code="label.spollineamt" /><span
														class=required>*</span></td>
													<td><form:input path="elineAmount" id="lineAmountEdit"
															class="textbox" maxlength="13" readonly="true"/></td>
												</tr>

												<tr>
													<td><spring:message code="label.spolduedate" /><span
														class=required>*</span></td>
													<td><form:input path="edueDateChild"
															id="dueDateChildEdit" class="textbox" /></td>
												</tr>


												<tr>
													<td><input type="hidden" name="hiddenIdSalesPopUpEdit"
														id="hiddenIdSalesPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-contain-SalesEdit">

											<div id="scroll1">
												<table id="AddSalesEdit" class="table">
													<thead>
														<tr>
															<th><spring:message code="label.spolmatid" /></th>
															<th><spring:message code="label.spoluomid" /></th>
															<th><spring:message code="label.spolcurid" /></th>
															<th><spring:message code="label.spolqty" /></th>
															<th><spring:message code="label.spolunit" /></th>
															<th><spring:message code="label.spollineamt" /></th>
															<th><spring:message code="label.spolduedate" /></th>
															<th><spring:message code="label.edit" /></th>
															<th><spring:message code="label.remove" /></th>

														</tr>
													</thead>
													<tbody>

														<c:forEach var="salesPOLineEditList"
															items="${salesPOLineEditList}">

															<spring:bind path="salesPOCmd.esalesPOLineId">
																<input type="hidden" name="esalesPOLineId"
																	id="esalesPOLineId${salesPOLineEditList.esalesPOLineId}"
																	value="${salesPOLineEditList.esalesPOLineId}" />
															</spring:bind>
															<tr id="${salesPOLineEditList.esalesPOLineId}">

																<td><spring:bind path="salesPOCmd.ematerialId">
																		<input type="hidden" name="ematerialId"
																			class="textbox"
																			id="materialIdEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.ematerialId}" readonly />
																	</spring:bind> <spring:bind path="salesPOCmd.ematerialName">
																		<input type="text" name="materialName" class="textbox"
																			id="materialNameEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.ematerialName}" readonly />
																	</spring:bind></td>



																<td><spring:bind path="salesPOCmd.eUOMId">
																		<input type="hidden" name="eUOMId"
																			id="UOMIdEdit${salesPOLineEditList.esalesPOLineId}"
																			class="textbox" value="${salesPOLineEditList.eUOMId}"
																			readonly />
																	</spring:bind> <spring:bind path="salesPOCmd.euomName">
																		<input type="text" name="UomName"
																			id="uomNameEdit${salesPOLineEditList.esalesPOLineId}"
																			class="textbox"
																			value="${salesPOLineEditList.euomName}" readonly />
																	</spring:bind></td>


																<td><spring:bind path="salesPOCmd.ecurId">
																		<input type="hidden" name="ecurId" class="textbox"
																			id="currenIdEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.ecurId}" readonly />
																	</spring:bind> <spring:bind path="salesPOCmd.ecurrencyName">
																		<input type="text" name="currencyName" class="textbox"
																			id="currencyNameEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.ecurrencyName}" readonly />
																	</spring:bind></td>
																<td><spring:bind path="salesPOCmd.equantity">
																		<input type="text" name="equantity" class="textbox"
																			id="quantityEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.equantity}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesPOCmd.eunitPrice">
																		<input type="text" name="eunitPrice" class="textbox"
																			id="unitPriceEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.eunitPrice}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesPOCmd.elineAmount">
																		<input type="text" name="elineAmount" class="textbox"
																			id="lineAmountEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.elineAmount}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesPOCmd.edueDateChild">
																		<input type="text" name="edueDateChild"
																			class="textbox"
																			id="dueDateChildEdit${salesPOLineEditList.esalesPOLineId}"
																			value="${salesPOLineEditList.edueDateChild}" readonly />
																	</spring:bind></td>

																<td><a href="#"
																	id="${salesPOLineEditList.esalesPOLineId}"
																	onclick="javascript:editSalesPOInEdit(this.id)"><img
																		src="images/Edit.jpg" height="25px" width="25px"
																		id="edit${salesPOLineEditList.esalesPOLineId}"></img></a></td>
																		
															<c:if test="${delBtn==true}">
																<td><a href="#"
																	id="${salesPOLineEditList.esalesPOLineId}"
																	onclick="javascript:getIDSPO(this.id)"><img
																		src="images/button_cancel.png" height="25px"
																		width="25px"
																		id="${salesPOLineEditList.esalesPOLineId}"></img></a> <input
																	type="hidden"
																	name="Check${salesPOLineEditList.esalesPOLineId}"
																	id="${salesPOLineEditList.esalesPOLineId}Check"
																	value="0" /></td>
																	</c:if>
																<c:set var="delBtn" value="true"></c:set>
															</tr>

															<script>
																function getIDSPO(
																		link) {
																	//alert(link);
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link
																					+ "Check").value = "1";
																	document
																			.getElementById(link).style.display = "none";
																}
																function editSalesPOInEdit(
																		id) {
																	//alert(""+id);

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
																			'#currenIdEdit')
																			.val(
																					$(
																							'#currenIdEdit'
																									+ id)
																							.val());
																	$(
																			'#dueDateChildEdit')
																			.val(
																					$(
																							'#dueDateChildEdit'
																									+ id)
																							.val());
																	$(
																			'#unitPriceEdit')
																			.val(
																					$(
																							'#unitPriceEdit'
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
																			'#hiddenIdSalesPopUpEdit')
																			.val(
																					id);

																}
															</script>

														</c:forEach>

													</tbody>

												</table>
												<script type="text/javascript">
													function forAddRowEdit(id) {

														//alert("came "+id);
														var optionsEdit = '<table><tr ><td><table  class="table" >'

																+ '<tr id="'+id+'">'
																+ '<td><spring:bind path="salesPOCmd.ematerialId"><input type="hidden" name="ematerialId" id="materialIdEdit'+id+'"  class="textbox"/></spring:bind>'
																+ '<input type="text" name="ematerialName" id="materialNameEdit'+id+'"  class="textbox" readOnly/> </td>'
																+ '<td><spring:bind path="salesPOCmd.eUOMId"><input type="hidden" name="eUOMId" id="UOMIdEdit'+id+'" class="textbox" /></spring:bind>'
																+ '<spring:bind path="salesPOCmd.euomName"><input type="text" name="euomName" id="uomNameEdit'+id+'" class="textbox" readOnly /></spring:bind></td>'
																+ '<td><spring:bind path="salesPOCmd.ecurId"><input name="ecurId" type="hidden" class="textbox" id="currenIdEdit'+id+'" readOnly/></spring:bind></td>'
																+ '<td><spring:bind path="salesPOCmd.ecurrencyName"><input type="text" class="textbox" name="ecurrencyName" id="currencyNameEdit'+id+'" readOnly/></spring:bind></td>'
																+ '<td><spring:bind path="salesPOCmd.equantity"><input name="equantity" id="quantityEdit'+id+'"  class="textbox" readOnly /></spring:bind></td>'
																+ '<td><spring:bind path="salesPOCmd.eunitPrice"><input name="eunitPrice" id="unitPriceEdit'+id+'"  class="textbox"  readOnly/></spring:bind></td>'
																+ '<td><spring:bind path="salesPOCmd.elineAmount"><input name="elineAmount" class="textbox" id="lineAmountEdit'+id+'" readOnly/></spring:bind></td>'
																+ '<td><spring:bind path="salesPOCmd.edueDateChild"><input type="text" name="edueDateChild" class="textbox" id="dueDateChildEdit'+id+'" readOnly/></spring:bind></td>'
																+ '<spring:bind path="salesPOCmd.esalesPOLineId"><input type="hidden" name="esalesPOLineId"  value="0"/></spring:bind>'
																+ '</td></tr></table>'
																+ "<a href='#' id='"
																+ id
																+ "' onclick='editSalesPOInEdit("
																+ id
																+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a>"

																+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="removeEdit"><strong><img src="images/button_cancel.png" height="25px" width="25px" onclick="getIDSPO('
																+ id
																+ ')" /></strong></a>'
																+ '</td></tr></table>';

														$(optionsEdit)
																.fadeIn("slow")
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
													function multiplication(id) {
														var netPrice = $(
																"#netPrice"
																		+ id)
																.val();
														var perUnit = document
																.getElementById("perUnit"
																		+ id).value;
														var result = netPrice
																* perUnit;
														document
																.getElementById("lineAmount"
																		+ id).value = result;

													}
												</script>

												<div id="extenderEdit"></div>
												<button id="create-AddSalesEdit" type="button">
													<spring:message code="label.newspoline" />
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