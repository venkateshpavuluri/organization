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
<title>My JSP 'SalesOrder.jsp' starting page</title>

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

						$("#tabs,#tabss,#edittabs").tabs();

						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addSalesForm')
													.validate(
															{
																rules : {
																	salesOrderNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	salesGroupId : {
																		required : true
																	},
																	customerId : {
																		required : true
																	},
																	paymentTermId : {
																		required : true
																	},
																	orderTypeId : {
																		required : true
																	},
																	uom : {
																		required : true
																	},
																	custPONumber : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	salesOrderDate : {
																		required : true
																	},
																	reqDeliveryDate : {
																		required : true
																	},
																	custPODate : {
																		required : true
																	},
																	netWeight : {
																		required : true,
																		number : true
																	},
																	totalWeight : {
																		required : true,
																		number : true
																	},
																	totalVolume : {
																		required : true,
																		number : true
																	},
																	orderReason : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	unloadingPoint : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	route : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	receivingPoint : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	priority : {
																		required : true
																	},
																	statusId : {
																		required : true
																	}
																},
																messages : {
																	salesOrderNo : {
																		required : "<font style='color: red;'><b>Sales Order No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	salesGroupId : "<font style='color: red;'><b>Sales Group is Required</b></font>",
																	customerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	paymentTermId : "<font style='color: red;'><b>Payment Term is Required</b></font>",
																	orderTypeId : "<font style='color: red;'><b>Order Type is Required</b></font>",
																	uom : "<font style='color: red;'><b>Uom Name is Required</b></font>",
																	custPONumber : {
																		required : "<font style='color: red;'><b>Customer PO Number is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"

																	},
																	salesOrderDate : "<font style='color: red;'><b>Sales Order Date is Required</b></font>",
																	reqDeliveryDate : "<font style='color: red;'><b>Required Delivery Date is Required</b></font>",
																	custPODate : "<font style='color: red;'><b>Customer PO Date is Required</b></font>",
																	netWeight : {
																		required : "<font style='color: red;'><b>NetWeight is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	totalWeight : {
																		required : "<font style='color: red;'><b>Total Weight is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	totalVolume : {
																		required : "<font style='color: red;'><b>Total Volume is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	orderReason : {
																		required : "<font style='color: red;'><b>Order Reason is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	unloadingPoint : {
																		required : "<font style='color: red;'><b>Unloading Point is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	route : {
																		required : "<font style='color: red;'><b>Route is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	receivingPoint : {
																		required : "<font style='color: red;'><b>Receiving Point is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	priority : "<font style='color: red;'><b>priority is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},

															});
											
											if ($('#salesOrderNo').val() != ""
												&& $('#statusId').val() != ""
												&& $('#custPODate').val() != ""
												&& $('#priority').val() != "") {
											if ($('#soId').val() != 0) {
												//alert("Please Enter AtLeast One Sales Order Line");
												document
														.getElementById("childMsg").style.display = "block";
												$('#childMsg')
														.html(
																"Warning! Please Enter AtLeast One Sales Order Line");
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
																	esalesOrderNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	esalesGroupId : {
																		required : true
																	},
																	ecustomerId : {
																		required : true
																	},
																	epaymentTermId : {
																		required : true
																	},
																	eorderTypeId : {
																		required : true
																	},
																	euom : {
																		required : true
																	},
																	ecustPONumber : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	esalesOrderDate : {
																		required : true
																	},
																	ereqDeliveryDate : {
																		required : true
																	},
																	ecustPODate : {
																		required : true
																	},
																	enetWeight : {
																		required : true,
																		number : true
																	},
																	etotalWeight : {
																		required : true,
																		number : true
																	},
																	etotalVolume : {
																		required : true,
																		number : true
																	},
																	eorderReason : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	eunloadingPoint : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	eroute : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	ereceivingPoint : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	epriority : {
																		required : true
																	},
																	estatusId : {
																		required : true
																	}
																},
																messages : {
																	esalesOrderNo : {
																		required : "<font style='color: red;'><b>Sales Order No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	esalesGroupId : "<font style='color: red;'><b>Sales Group is Required</b></font>",
																	ecustomerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	epaymentTermId : "<font style='color: red;'><b>Payment Term is Required</b></font>",
																	eorderTypeId : "<font style='color: red;'><b>Order Type is Required</b></font>",
																	euom : "<font style='color: red;'><b>Uom Name is Required</b></font>",
																	ecustPONumber : {
																		required : "<font style='color: red;'><b>Customer PO Number is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	esalesOrderDate : "<font style='color: red;'><b>Sales Order Date is Required</b></font>",
																	ereqDeliveryDate : "<font style='color: red;'><b>Required Delivery Date is Required</b></font>",
																	ecustPODate : "<font style='color: red;'><b>Customer PO Date is Required</b></font>",
																	enetWeight : {
																		required : "<font style='color: red;'><b>Net Weight is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	etotalWeight : {
																		required : "<font style='color: red;'><b>Total Weight is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	etotalVolume : {
																		required : "<font style='color: red;'><b>Total Volume is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	eorderReason : {
																		required : "<font style='color: red;'><b>Order Reason is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	eunloadingPoint : {
																		required : "<font style='color: red;'><b>Unloading Point is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	eroute : {
																		required : "<font style='color: red;'><b>Route is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	ereceivingPoint : {
																		required : "<font style='color: red;'><b>Receiving Point is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	epriority : "<font style='color: red;'><b>priority is Required</b></font>",
																	estatusId : "<font style='color: red;'><b>Status is Required</b></font>"

																},
															});

										});

					});
</script>

<script type="text/javascript">
	function dateFun(datePattern) {
		//alert(datePattern);
				$('#reqdelDate,#custPODate,#sodate')
				.datepicker({
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					onSelect : function(d){
						var date=$('#sodate').datepicker('getDate');
						date.setDate(date.getDate()+0);
						$('#reqdelDate').datepicker('option','minDate',date);
					}
				});
				
				$('#sodateEdit,#reqdelDateEdit,#custPODateEdit')
				.datepicker({
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					onSelect : function(d){
						var date=$('#sodateEdit').datepicker('getDate');
						date.setDate(date.getDate()+0);
						$('#reqdelDateEdit').datepicker('option','minDate',date);
					}
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
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 65%;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>
<script type="text/javascript">
	function AjaxForDuplicate() {
		var soNo = $('#salesOrderNo').val();
		//alert(soNo);
		$
				.ajax({
					type : "POST",
					url : "checkSOAddDuplicate.mnt",
					data : "salesOrderNo=" + soNo,
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
		var soNo = $('#esalesOrderNo').val();
		var id = $('#esalesOrderId').val();
		//alert(soNo);
		$
				.ajax({
					type : "POST",
					url : "checkSOUpdateDuplicate.mnt",
					data : "esalesOrderNo=" + soNo + "&soId=" + id,
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

	function multiply() {
		var quantity = $("#quantity").val();
		var unitPrice = document.getElementById("unitPrice").value;
		var result = quantity * unitPrice;
		document.getElementById("netPrice").value = result;

	}

	function addition() {
		var netPrice = parseInt($("#netPrice").val());
		var dis = parseInt($("#discount").val());
		var tax = parseInt(document.getElementById("tax").value);
		var result = netPrice + tax - dis;
		document.getElementById("totalAmt").value = result;

	}
	function multiplyEdit() {

		var quantity = $("#quantityEdit").val();
		var perUnit = document.getElementById("unitPriceEdit").value;
		var result = quantity * perUnit;
		document.getElementById("netPriceEdit").value = result;

	}

	function additionEdit() {
		var netPrice = parseInt($("#netPriceEdit").val());
		var dis = parseInt($("#discountEdit").val());
		var tax = parseInt(document.getElementById("taxEdit").value);
		var result = netPrice + tax - dis;
		document.getElementById("totalAmtEdit").value = result;

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("soId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
		$('#sumbnasdStop').click(function(e) {
			document.getElementById("soId").value = 1;
			//alert(document.getElementById("asId").value);
		});

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#basicSearchId').focus();
			$('#salesOrderNo').focus();
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Sales Order</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:if test="${salesOdrEditList!=null}">

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

					<form:form method="get" action="salesOrderSearch.mnt"
						commandName="salesOrderCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addSOSus"
										items="${param.addSOSus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sorder" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addSOFail"
										items="${param.addSOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sorder" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSOsus"
										items="${param.UpdateSOsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sorder" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="UpdateSOFail"
										items="${param.UpdateSOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sorder" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteSOsus"
										items="${param.DeleteSOsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sorder" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteSOFail"
										items="${param.DeleteSOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sorder" />
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
								<c:set var="save" value="true"></c:set>
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
							
							<form:form action="SOAdvanceSearch.mnt" method="get"
								commandName="salesOrderCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="SOAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>

						</table>
						
						<form:form action="SOAdvanceSearchOperations.mnt"
							commandName="salesOrderCmd" method="get">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="salesOrderCmd.asOpts">
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
											<td><spring:bind path="salesOrderCmd.asOpts">
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
											<c:set var="salesGroupId" value="salesGroupId" />
											<c:set var="paymentTermId" value="paymentTermId" />
											<c:set var="customerId" value="customerId" />
											
											<c:if test="${bdField eq salesGroupId}">
												<c:set var="selectBox" value="${salesGroupSelect}" />
											</c:if>
											<c:if test="${bdField eq customerId}">
												<c:set var="selectBox" value="${custSelect}" />
											</c:if>
											<c:if test="${bdField eq paymentTermId}">
												<c:set var="selectBox" value="${paymentTermsSelect}" />
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

					<c:if test="${SOList!=null }">
					<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="SOAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="salesOrderSearch.mnt" />
							</c:otherwise>

						</c:choose>
						<display:table name="SOList" id="SOIdList" class="table"
							requestURI="${search}" pagesize="5">

							<display:column property="salesOrderId" sortable="true"
								title="salesOrderId" media="none" />

							<display:column property="salesOrderNo" sortable="true"
								titleKey="label.sono" media="html" />

							<display:column property="customerId" sortable="true"
								titleKey="label.socustid" media="html" />

							<display:column property="salesGroupId" sortable="true"
								titleKey="label.sosalesgroup" media="html" />

							<display:column property="paymentTermId" sortable="true"
								titleKey="label.sopterms" media="html" />

							<display:column property="orderTypeId" sortable="true"
								titleKey="label.soordertype" media="html" />


							<display:column property="uom" sortable="true"
								titleKey="label.souom" media="html" />


							<display:column property="custPONumber" sortable="true"
								titleKey="label.sopono" media="html" />

							<display:column property="salesOrderDate" sortable="true"
								titleKey="label.sodate" media="html"
								format="{0,date,dd-MM-yyyy}" />

							<display:column property="custPODate" sortable="true"
								titleKey="label.sopodate" media="html" />

							<display:column property="reqDeliveryDate" sortable="true"
								titleKey="label.sorddate" media="none" />
							<display:column property="netWeight" sortable="true"
								titleKey="label.sonw" media="html" />
							<display:column property="totalWeight" sortable="true"
								titleKey="label.sototweight" media="html" />
							<display:column property="totalVolume" sortable="true"
								titleKey="label.sototvol" media="html" />
							<display:column property="orderReason" sortable="true"
								titleKey="label.soorderrea" media="html" />
							<display:column property="priority" sortable="true"
								titleKey="label.soprior" media="html" />
							<display:column property="unloadingPoint" sortable="true"
								titleKey="label.unloadpoint" media="none" />
							<display:column property="route" sortable="true"
								titleKey="label.soroute" media="none" />
							<display:column property="receivingPoint" sortable="true"
								titleKey="label.soreceive" media="none" />
							<display:column property="statusId" sortable="true"
								titleKey="label.sostat" media="none" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="SalesOrderEdit.mnt?salesOrderId=<c:out value="${SOIdList.salesOrderId}"/> "><img
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
											href="salesOrderDelete.mnt?salesOrderId=<c:out value="${SOIdList.salesOrderId}"/> "
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
							<td colspan="2" id="salesDuplMessage"
								style="display: none; width:">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.sono" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="salesOrderAdd.mnt" method="POST"
						commandName="salesOrderCmd" id="addSalesForm">

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">

										<form:hidden path="soId" />
										<tr>
											<td><spring:message code="label.sono" /><span
												class="required">*</span></td>
											<td><form:input path="salesOrderNo" id="salesOrderNo"
													cssClass="textbox" onkeyup="AjaxForDuplicate()"
													maxlength="20" /></td>
											<td><spring:message code="label.sopodate" /><span
												class="required">*</span></td>
											<td><form:input path="custPODate" cssClass="textbox"
													id="custPODate" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.sosalesgroup" /><span
												class="required">*</span></td>
											<td><form:select path="salesGroupId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${salesGroupSelect}" />
												</form:select></td>
											<td><spring:message code="label.sonw" /><span
												class="required">*</span></td>
											<td><form:input path="netWeight" cssClass="textbox" maxlength="16"/></td>
										</tr>

										<tr>
											<td><spring:message code="label.socustid" /><span
												class="required">*</span></td>
											<td><form:select path="customerId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${custSelect}" />

												</form:select></td>
											<td><spring:message code="label.sototweight" /><span
												class="required">*</span></td>
											<td><form:input path="totalWeight" cssClass="textbox"
													maxlength="16" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.sopterms" /><span
												class="required">*</span></td>
											<td><form:select path="paymentTermId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${paymentTermsSelect}" />

												</form:select></td>
											<td><spring:message code="label.sototvol" /><span
												class="required">*</span></td>
											<td><form:input path="totalVolume" cssClass="textbox"
													maxlength="16" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.soordertype" /><span
												class="required">*</span></td>
											<td><form:select path="orderTypeId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${orderTypeSelect}" />

												</form:select></td>
											<td><spring:message code="label.soorderrea" /><span
												class="required">*</span></td>
											<td><form:input path="orderReason" cssClass="textbox"
													maxlength="50" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.souom" /><span
												class="required">*</span></td>
											<td><form:select path="uom" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${SelectUom}" />

												</form:select></td>

											<td><spring:message code="label.unloadpoint" /><span
												class="required">*</span></td>
											<td><form:input path="unloadingPoint" cssClass="textbox"
													maxlength="50" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.sopono" /><span
												class="required">*</span></td>
											<td><form:input path="custPONumber" cssClass="textbox"
													maxlength="20" /></td>

											<td><spring:message code="label.soroute" /><span
												class="required">*</span></td>
											<td><form:input path="route" cssClass="textbox"
													maxlength="50" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.sodate" /><span
												class="required">*</span></td>
											<td><form:input path="salesOrderDate" cssClass="textbox"
													id="sodate" /></td>

											<td><spring:message code="label.soreceive" /><span
												class="required">*</span></td>
											<td><form:input path="receivingPoint" cssClass="textbox"
													maxlength="50" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.sorddate" /><span
												class="required">*</span></td>
											<td><form:input path="reqDeliveryDate"
													cssClass="textbox" id="reqdelDate" /></td>

											<td><spring:message code="label.soprior" /><span
												class="required">*</span></td>
											<td><form:select path="priority" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:option value="HIGH">HIGH</form:option>
													<form:option value="MEDIUM">MEDIUM</form:option>
													<form:option value="LOW">LOW</form:option>
												</form:select></td>
										</tr>

										<tr>
											<td><spring:message code="label.sostat" /><span
												class="required">*</span></td>
											<td><form:select path="statusId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${statusSelect}" />

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
											code="label.salesodrline" /></a></li>
								<%-- <li><a href="#tab2"><spring:message code="label.salesodrschline" /></a></li>	 --%>

							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1" align="left">

								<!-- Model Pop-up Start-->

								<div align="left">
									<script type="text/javascript">
										var btrid = 1;

										$(document)
												.ready(
														function() {

															var matId = $("#materialId"), qty = $("#quantity"), uomId = $("#UOMId"), curId = $("#currencyId"), custMtNo = $("#custMaterailNo"), nPrice = $("#netPrice"), uPrice = $("#unitPrice"), tax = $("#tax"), discount = $("#discount"), totAmt = $("#totalAmt"), hiddenID = $("#hiddenIdBankPopUp"),

															allFields = $([])
																	.add(matId)
																	.add(qty)
																	.add(uomId)
																	.add(curId)
																	.add(
																			custMtNo)
																	.add(nPrice)
																	.add(uPrice)
																	.add(tax)
																	.add(
																			discount)
																	.add(totAmt)
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
																				height : 380,
																				width : 420,
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
																										curId,
																										"Currency Name");
																						bValid = bValid
																								&& required(
																										custMtNo,
																										"Customer Material No")
																								&& checkRegexp(
																										custMtNo,
																										/^([0-9a-zA-Z ])*$/i,
																										"Special Characters except &,_ are not allowed");

																						bValid = bValid
																								&& checkRegexp(
																										qty,
																										/^([0-9.])+$/i,
																										"Quantity is Required And Must be  Number");
																						bValid = bValid
																								&& required(
																										uomId,
																										"UOM Name");
																						bValid = bValid
																								&& checkRegexp(
																										uPrice,
																										/^([0-9.])+$/i,
																										"Unit Price is Required And Must be  Number");
																						bValid = bValid
																								&& checkRegexp(
																										nPrice,
																										/^([0-9.])+$/i,
																										"Net Price is Required And Must be  Number");
																						bValid = bValid
																								&& checkRegexp(
																										tax,
																										/^([0-9.])+$/i,
																										"Tax is Required And Must be  Number");
																						bValid = bValid
																								&& checkRegexp(
																										discount,
																										/^([0-9.])+$/i,
																										"Discount is Required And Must be  Number");
																						bValid = bValid
																								&& checkRegexp(
																										totAmt,
																										/^([0-9.])+$/i,
																										"Total Amount is Required And Must be  Number");

																						if (bValid) {
																							//alert("hiddenid"+hiddenID.val());
																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {
																								$(
																										"#SalesLineAdd tbody")
																										.append(

																												"<tr id="+btrid+">"
																														+ "<td ><spring:bind path='salesOrderCmd.materialId'><input type='hidden' name='materialId' id='materialId"
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

																														+ "<td><input type='hidden' name='currencyId' id='currencyId"
																														+ btrid
																														+ "' value="
																														+ curId
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

																														+ "<td><input type='text' name='custMaterailNo' id='custMaterailNo"
																														+ btrid
																														+ "' value="
																														+ custMtNo
																																.val()
																														+ " class='textbox' readonly/></td>"
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
																														+ "<input type='text' class='textbox' readonly name='uomName' id='uomName"
																														+ btrid
																														+ "'  value='"
																														+ $(
																																'#UOMId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input name='uPrice' id='unitPrice"
																														+ btrid
																														+ "' value="
																														+ uPrice
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input type='text' name='netPrice' id='netPrice"
																														+ btrid
																														+ "' value="
																														+ nPrice
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input type='text' name='tax' id='tax"
																														+ btrid
																														+ "' value="
																														+ tax
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input type='text' name='discount' id='discount"
																														+ btrid
																														+ "' value="
																														+ discount
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input type='text' name='totalAmt' id='totalAmt"
																														+ btrid
																														+ "' value="
																														+ totAmt
																																.val()
																														+ " class='textbox' readonly/></td>"

																														+ "<td><a href='#'  onclick='editSalesOrderLine("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeSalesOrderLine("
																														+ btrid
																														+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																														+ "</tr>");

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
																												curId
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
																										'#custMaterailNo'
																												+ hiddenID
																														.val())
																										.val(
																												custMtNo
																														.val());
																								$(
																										'#unitPrice'
																												+ hiddenID
																														.val())
																										.val(
																												uPrice
																														.val());
																								$(
																										'#netPrice'
																												+ hiddenID
																														.val())
																										.val(
																												nPrice
																														.val());
																								$(
																										'#tax'
																												+ hiddenID
																														.val())
																										.val(
																												tax
																														.val());
																								$(
																										'#discount'
																												+ hiddenID
																														.val())
																										.val(
																												discount
																														.val());
																								$(
																										'#totalAmt'
																												+ hiddenID
																														.val())
																										.val(
																												totAmt
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
																				tips.text('');
																				//alert("opened");
																			});
														});

										function removeSalesOrderLine(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editSalesOrderLine(id) {
											//alert("edit row " + id);
											$(".validateTips").text('');
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
											$('#UOMId').val(
													$('#UOMId' + id).val());
											$('#currencyId')
													.val(
															$(
																	'#currencyId'
																			+ id)
																	.val());
											$('#custMaterailNo').val(
													$('#custMaterailNo' + id)
															.val());
											$('#unitPrice').val(
													$('#unitPrice' + id).val());
											$('#netPrice').val(
													$('#netPrice' + id).val());
											$('#tax').val($('#tax' + id).val());
											$('#discount').val(
													$('#discount' + id).val());
											$('#totalAmt').val(
													$('#totalAmt' + id).val());

											$('#hiddenIdBankPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>

									<div id="dialogformsalesLine" align="center"
										title="<spring:message code="label.soform" />">
										<p class="validateTips" align="center" style="color: blue;"></p>
										<table class="tableGeneral">
											<tr>
												<td><spring:message code="label.matid" /><span
													class=required>*</span></td>
												<td><form:select path="material_Id" id="materialId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select></td>
											</tr>


											<tr>
												<td><spring:message code="label.socur" /> <span
													class=required>*</span></td>
												<td><form:select path="currency_Id" id="currencyId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectCurrency}" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.custmtno" /><span
													class=required>*</span></td>
												<td><form:input path="custMaterailNo"
														id="custMaterailNo" class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sqty" /><span
													class=required>*</span></td>
												<td><form:input path="quantity" id="quantity"
														class="textbox" onkeyup="multiply()" maxlength="16" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.sauomid" /> <span
													class=required>*</span></td>
												<td><form:select path="uom_Id" id="UOMId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.soup" /><span
													class=required>*</span></td>
												<td><form:input path="uPrice" id="unitPrice"
														class="textbox" onkeyup="multiply()" maxlength="16" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.sonprice" /><span
													class=required>*</span></td>
												<td><form:input path="netPrice" id="netPrice"
														class="textbox" readonly="true" onblur="addition()" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sotax" /><span
													class=required>*</span></td>
												<td><form:input path="tax" id="tax" class="textbox"
														onkeyup="addition()" maxlength="16" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sodisc" /><span
													class=required>*</span></td>
												<td><form:input path="discount" id="discount"
														class="textbox" onkeyup="addition()" maxlength="16" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sotamt" /><span
													class=required>*</span></td>
												<td><form:input path="totalAmt" id="totalAmt"
														class="textbox" readonly="true" /></td>
											</tr>

											<tr>
												<td><input type="hidden" name="hiddenIdBankPopUp"
													id="hiddenIdBankPopUp" value="0" /></td>
											</tr>

										</table>
									</div>

									<div id="users-SalesLine">
										<div id="scroll" align="center">
											<table id="SalesLineAdd" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.somtid" /></th>
														<th><spring:message code="label.socur" /></th>
														<th><spring:message code="label.custmtno" /></th>
														<th><spring:message code="label.soqty" /></th>
														<th><spring:message code="label.souom" /></th>
														<th><spring:message code="label.soup" /></th>
														<th><spring:message code="label.sonprice" /></th>
														<th><spring:message code="label.sotax" /></th>
														<th><spring:message code="label.sodisc" /></th>
														<th><spring:message code="label.sotamt" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>

											<button id="createAddSalesLine" type="button">
												<spring:message code="label.newsalesodrline" />
											</button>
										</div>
									</div>
								</div>

								<!-- Model Pop-up End-->
							</div>

							<!--Sub Tab  -->
							<%-- <div id="tab2">
							<div align="center">
							
							 <script type="text/javascript">
										var btrid = 1;
										
										$(document).ready(function() {			
																													
											 var qty = $("#childQuantity"), uomId = $("#childUOMId"),delDate = $("#deliveryDate"),hiddenID = $("#hiddenIdSalesPopUp"),
											
											allFields = $([]).add(qty).add(uomId).add(delDate).add(hiddenID), 
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

											  $("#dialogformsalesLineSch").dialog({
															
																autoOpen : false,
																height : 250,
																width : 350,
																modal : true,
																buttons : {
																Submit : function() {
																		var bValid = true;
																		allFields
																				.removeClass("ui-state-error");

																		bValid = bValid && required(uomId,"UOM");
																		bValid = bValid && checkRegexp(qty,/^([0-9.])+$/i,"Quantity is Required And Must be  Number");
																		bValid = bValid && required(delDate,"Required Delivery date");
																		
																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID.val() == "0" || hiddenID.val() == "") {					
																				$("#SalesLineSchAdd tbody").append(
																																									
																								"<tr id="+btrid+">"
																										+ "<td><input type='hidden' name='sosUomId' id='childUOMId"
																										+ btrid
																										+ "' value="
																										+ uomId
																												.val()
																										+ " class='textbox' readonly/>"
																										+"<input type='text' class='textbox' readonly name='uomName' value='"+$('#childUOMId :selected').text()+"'"
																										+"</td>"
																										
																										+ "<td><input name='sosQuantity' id='childQuantity"
																										+ btrid
																										+ "' value="
																										+ qty
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+ "<td><input type='text' name='sosDelDate' id='deliveryDate"
																										+ btrid
																										+ "' value="
																										+ delDate
																												.val()
																										+ " class='textbox' readonly/>"

																										+"<td><a href='#'  onclick='editSalesOrderLineSch("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeSalesOrderLineSch("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");

																				btrid++;
																				$(this).dialog("close");
																			}																																									

																			if (hiddenID.val() != "0"){
																				
																				$('#childUOMId'+ hiddenID.val()).val(uomId.val());
																				$('#childQuantity'+ hiddenID.val()).val(qty.val());
																				$('#deliveryDate'+ hiddenID.val()).val(delDate.val());
																				$('#hiddenIdBankPopUp').val("0");																																									
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
											 
												$('#createAddSalesLineSch').button().click(function() {
												 												
													$("#dialogformsalesLineSch").dialog("open");																																																					
													//alert("opened");
												});
								});	
										
										 function removeSalesOrderLineSch(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editSalesOrderLineSch(id) {
											//alert("edit row " + id);
											$("#dialogformsalesLineSch").dialog("open");
											$('#childQuantity').val($('#childQuantity' + id).val());
											$('#childUOMId').val($('#childUOMId' + id).val());
											$('#deliveryDate').val($('#deliveryDate' + id).val());
											$('#hiddenIdSalesPopUp').val(id);
											// document.getElementById("").value="edit";
										} 
									</script>  

									 <div id="dialogformsalesLineSch" align="center" title="<spring:message code="label.socform" />">
										<p class="validateTips" align="center" style="color:blue;">All Form Fields are Required</p>
										<table class="tableGeneral">
											
											<tr>
												<td><spring:message code="label.souomidc" /> <span
													class=required>*</span></td>
												<td><form:select path="sos_UomId" id="childUOMId"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${SelectUom}" />
														</form:select></td>
											</tr>
											
											<tr>
												<td><spring:message code="label.soqty" /><span
													class=required>*</span></td>
												<td><form:input path="sosQuantity" id="childQuantity"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sodeldate" /><span
													class=required>*</span></td>
												<td><form:input path="sosDelDate" id="deliveryDate"
														class="textbox" /></td>
											</tr>
											
											
											<tr>																							
											<td><input type="hidden"
													name="hiddenIdBankPopUp" id="hiddenIdSalesPopUp" value="0" /></td>
											</tr>

										</table>
									</div>  

									 <div id="users-SalesLineSch">
										<table id="SalesLineSchAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.souomidc" /></th>
													<th><spring:message code="label.soqty" /> </th>
														<th><spring:message code="label.sodeldate" /> </th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div> 
									
									<button id="createAddSalesLineSch" type="button"><spring:message code="label.sonewlinesch" /></button>
							
							</div>
							
							</div> --%>


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
									<spring:message code="label.sono" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form method="post" action="salesOrderUpdate.mnt"
						commandName="salesOrderCmd" id="editSalesForm">
						<c:forEach var="salesOdrEditList" items="${salesOdrEditList}">
							<c:set var="editMode" value="${salesOdrEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td>
										<table class="tableGeneral">

											<form:hidden path="editSOId" />
											<form:hidden path="esalesOrderId" id="esalesOrderId" />
											<tr>
												<td><spring:message code="label.sono" /><span
													class="required">*</span></td>
												<td><form:input path="esalesOrderNo" id="esalesOrderNo"
														cssClass="textbox" onkeyup="AjaxUpdateDuplicate()"
														maxlength="20" /></td>
												<td><spring:message code="label.sopodate" /><span
													class="required">*</span></td>
												<td><form:input path="ecustPODate" cssClass="textbox"
														id="custPODateEdit" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.sosalesgroup" /><span
													class="required">*</span></td>
												<td><form:select path="esalesGroupId" cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${salesGroupSelect}" />
													</form:select></td>
												<td><spring:message code="label.sonw" /><span
													class="required">*</span></td>
												<td><form:input path="enetWeight" cssClass="textbox"
														maxlength="16" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.socustid" /><span
													class="required">*</span></td>
												<td><form:select path="ecustomerId" cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${custSelect}" />

													</form:select></td>
												<td><spring:message code="label.sototweight" /><span
													class="required">*</span></td>
												<td><form:input path="etotalWeight" cssClass="textbox"
														maxlength="16" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.sopterms" /><span
													class="required">*</span></td>
												<td><form:select path="epaymentTermId"
														cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${paymentTermsSelect}" />

													</form:select></td>
												<td><spring:message code="label.sototvol" /><span
													class="required">*</span></td>
												<td><form:input path="etotalVolume" cssClass="textbox"
														maxlength="16" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.soordertype" /><span
													class="required">*</span></td>
												<td><form:select path="eorderTypeId" cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${orderTypeSelect}" />

													</form:select></td>
												<td><spring:message code="label.soorderrea" /><span
													class="required">*</span></td>
												<td><form:input path="eorderReason" cssClass="textbox"
														maxlength="50" /></td>

											</tr>

											<tr>
												<td><spring:message code="label.souom" /><span
													class="required">*</span></td>
												<td><form:select path="euom" cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${SelectUom}" />

													</form:select></td>

												<td><spring:message code="label.unloadpoint" /><span
													class="required">*</span></td>
												<td><form:input path="eunloadingPoint"
														cssClass="textbox" maxlength="50" /></td>

											</tr>

											<tr>
												<td><spring:message code="label.sopono" /><span
													class="required">*</span></td>
												<td><form:input path="ecustPONumber" cssClass="textbox"
														maxlength="20" /></td>

												<td><spring:message code="label.soroute" /><span
													class="required">*</span></td>
												<td><form:input path="eroute" cssClass="textbox"
														maxlength="50" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sodate" /><span
													class="required">*</span></td>
												<td><form:input path="esalesOrderDate"
														cssClass="textbox" id="sodateEdit" /></td>

												<td><spring:message code="label.soreceive" /><span
													class="required">*</span></td>
												<td><form:input path="ereceivingPoint"
														cssClass="textbox" maxlength="50" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sorddate" /><span
													class="required">*</span></td>
												<td><form:input path="ereqDeliveryDate"
														cssClass="textbox" id="reqdelDateEdit" /></td>

												<td><spring:message code="label.soprior" /><span
													class="required">*</span></td>
												<td><form:select path="epriority" cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:option value="HIGH">HIGH</form:option>
														<form:option value="MEDIUM">MEDIUM</form:option>
														<form:option value="LOW">LOW</form:option>
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.sostat" /><span
													class="required">*</span></td>
												<td><form:select path="estatusId" cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${statusSelect}" />

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
												code="label.salesodrline" /></a></li>
									<%-- <li><a href="#tabSchLine2"><spring:message code="label.salesodrschline" /></a></li> --%>


								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1" align="left">
									<div align="left">
										<script>
											var btrid = 400;
											$(function() {

												var matIdEdit = $("#materialIdEdit"), qtyEdit = $("#quantityEdit"), uomIdEdit = $("#UOMIdEdit"), curIdEdit = $("#currencyIdEdit"), custMtNoEdit = $("#custMaterailNoEdit"), nPriceEdit = $("#netPriceEdit"), uPriceEdit = $("#unitPriceEdit"), taxEdit = $("#taxEdit"), discountEdit = $("#discountEdit"), totAmtEdit = $("#totalAmtEdit"), hiddenEdit = $("#hiddenIdBankPopUpEdit"),

												allFields = $([])
														.add(matIdEdit).add(
																qtyEdit).add(
																uomIdEdit).add(
																curIdEdit).add(
																custMtNoEdit)
														.add(nPriceEdit).add(
																uPriceEdit)
														.add(taxEdit).add(
																discountEdit)
														.add(totAmtEdit).add(
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
												function requiredEdit(o, n) {
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
																	width : 420,
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
																							curIdEdit,
																							"Currency Name");
																			bValid1 = bValid1
																					&& requiredEdit(
																							custMtNoEdit,
																							"Customer Material No")
																					&& checkRegexp(
																							custMtNoEdit,
																							/^([0-9a-zA-Z ])*$/i,
																							"Special Characters except &,_ are not allowed");
																			bValid1 = bValid1
																					&& checkRegexp(
																							qtyEdit,
																							/^([0-9.])+$/i,
																							"Quantity is Required And Must be  Number");
																			bValid1 = bValid1
																					&& requiredEdit(
																							uomIdEdit,
																							"UOM Name");
																			bValid1 = bValid1
																					&& checkRegexp(
																							uPriceEdit,
																							/^([0-9.])+$/i,
																							"Unit Price is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkRegexp(
																							nPriceEdit,
																							/^([0-9.])+$/i,
																							"Net Price is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkRegexp(
																							taxEdit,
																							/^([0-9.])+$/i,
																							"Tax is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkRegexp(
																							discountEdit,
																							/^([0-9.])+$/i,
																							"Discount is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkRegexp(
																							totAmtEdit,
																							/^([0-9.])+$/i,
																							"Total Amount is Required And Must be  Number");
																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddBankEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='salesOrderCmd.ematerialId'><input type='hidden' name='ematerialId' id='materialIdEdit"
																											+ btrid
																											+ "' value="
																											+ matIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text' readonly class='textbox' name='materialNameEdit' id='materialNameEdit"
																											+ btrid
																											+ "'  value='"
																											+ $(
																													'#materialIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "</td>"
																											+ "<td><spring:bind path='salesOrderCmd.ecurrencyId'><input type='hidden' name='ecurrencyId' id='currencyIdEdit"
																											+ btrid
																											+ "' value="
																											+ curIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text' class='textbox' readonly name='currencyNameEdit' id='currencyNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#currencyIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><spring:bind path='salesOrderCmd.ecustMaterailNo'><input type='text' name='ecustMaterailNo' id='custMaterailNoEdit"
																											+ btrid
																											+ "' value="
																											+ custMtNoEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='salesOrderCmd.equantity'><input name='equantity' id='quantityEdit"
																											+ btrid
																											+ "' value="
																											+ qtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='salesOrderCmd.euomId'><input type='hidden' name='euomId' id='UOMIdEdit"
																											+ btrid
																											+ "' value="
																											+ uomIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text'readonly class='textbox' name='uomNameEdit' id='uomNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#UOMIdEdit :selected')
																													.text()
																											+ "'</td>"
																											+ "<td><spring:bind path='salesOrderCmd.euPrice'><input type='text' name='euPrice' id='unitPriceEdit"
																											+ btrid
																											+ "' value="
																											+ uPriceEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td> "

																											+ "<td><spring:bind path='salesOrderCmd.enetPrice'><input type='text' name='enetPrice' id='netPriceEdit"
																											+ btrid
																											+ "' value="
																											+ nPriceEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td> "
																											+ "<td><spring:bind path='salesOrderCmd.etax'><input type='text' name='etax' id='taxEdit"
																											+ btrid
																											+ "' value="
																											+ taxEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td> "

																											+ "<td><spring:bind path='salesOrderCmd.ediscount'><input type='text' name='ediscount' id='discountEdit"
																											+ btrid
																											+ "' value="
																											+ discountEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td> "

																											+ "<td><spring:bind path='salesOrderCmd.etotalAmt'><input type='text' name='etotalAmt' id='totalAmtEdit"
																											+ btrid
																											+ "' value="
																											+ totAmtEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> "

																											+ "<input type='hidden' name='esalesOrderLineId' id='esalesOrderLineId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"

																											+ "<td><a href='#'  onclick='editSalesOdrInNewEdit("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeSalesOdrEditNew("
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
																							'#UOMNameEdit'
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
																							'#custMaterailNoEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#custMaterailNoEdit')
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
																							'#netPriceEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#netPriceEdit')
																											.val());
																					$(
																							'#taxEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#taxEdit')
																											.val());
																					$(
																							'#discountEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#discountEdit')
																											.val());
																					$(
																							'#totalAmtEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#totalAmtEdit')
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
																				;
																			}
																			;

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
											function removeSalesOdrEditNew(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editSalesOdrInNewEdit(link) {
												//alert(link);
												$(".validateTips").text('');
												$("#dialog-form-salesLineEdit")
														.dialog("open");
												$('#materialIdEdit').val(
														$(
																'#materialIdEdit'
																		+ link)
																.val());
												//$('#materialNameEdit').val($('#materialIdEdit :selected').text());
												$('#UOMIdEdit').val(
														$('#UOMIdEdit' + link)
																.val());
												$('#currencyIdEdit').val(
														$(
																'#currencyIdEdit'
																		+ link)
																.val());
												$('#quantityEdit').val(
														$(
																'#quantityEdit'
																		+ link)
																.val());
												$('#custMaterailNoEdit').val(
														$(
																'#custMaterailNoEdit'
																		+ link)
																.val());
												$('#unitPriceEdit').val(
														$(
																'#unitPriceEdit'
																		+ link)
																.val());
												$('#netPriceEdit').val(
														$(
																'#netPriceEdit'
																		+ link)
																.val());
												$('#taxEdit').val(
														$('#taxEdit' + link)
																.val());
												$('#discountEdit').val(
														$(
																'#discountEdit'
																		+ link)
																.val());
												$('#totalAmtEdit').val(
														$(
																'#totalAmtEdit'
																		+ link)
																.val());

												$('#hiddenIdBankPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-salesLineEdit"
											title="<spring:message code="label.soform" />">
											<p class="validateTips" align="center" style="color: blue;"></p>
											<table class="tableGeneral">
												<form:hidden path="esalesOrderLineId" value="0" />

												<tr>
													<td><spring:message code="label.matid" /><span
														class=required>*</span></td>
													<td><form:select path="ematerial_Id"
															id="materialIdEdit" class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.socur" /> <span
														class=required>*</span></td>
													<td><form:select path="ecurrency_Id"
															id="currencyIdEdit" class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectCurrency}" />
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.custmtno" /><span
														class=required>*</span></td>
													<td><form:input path="ecustMaterailNo"
															id="custMaterailNoEdit" class="textbox" maxlength="20" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.sqty" /><span
														class=required>*</span></td>
													<td><form:input path="equantity" id="quantityEdit"
															class="textbox" onkeyup="multiplyEdit()" maxlength="16"/></td>
												</tr>

												<tr>
													<td><spring:message code="label.sauomid" /> <span
														class=required>*</span></td>
													<td><form:select path="euom_Id" id="UOMIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.soup" /><span
														class=required>*</span></td>
													<td><form:input path="euPrice" id="unitPriceEdit"
															class="textbox" onkeyup="multiplyEdit()" maxlength="16"/></td>
												</tr>

												<tr>
													<td><spring:message code="label.sonprice" /><span
														class=required>*</span></td>
													<td><form:input path="enetPrice" id="netPriceEdit"
															class="textbox" readonly="true" onblur="additionEdit()"
															maxlength="16" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.sotax" /><span
														class=required>*</span></td>
													<td><form:input path="etax" id="taxEdit"
															class="textbox" onkeyup="additionEdit()" maxlength="16" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.sodisc" /><span
														class=required>*</span></td>
													<td><form:input path="ediscount" id="discountEdit"
															class="textbox" onkeyup="additionEdit()" maxlength="16" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.sotamt" /><span
														class=required>*</span></td>
													<td><form:input path="etotalAmt" id="totalAmtEdit"
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
											<div id="scroll" align="center">
												<table id="AddBankEdit" class="table">
													<thead>
														<tr>

															<th><spring:message code="label.somtid" /></th>
															<th><spring:message code="label.socur" /></th>
															<th><spring:message code="label.custmtno" /></th>
															<th><spring:message code="label.soqty" /></th>
															<th><spring:message code="label.souom" /></th>
															<th><spring:message code="label.soup" /></th>
															<th><spring:message code="label.sonprice" /></th>
															<th><spring:message code="label.sotax" /></th>
															<th><spring:message code="label.sodisc" /></th>
															<th><spring:message code="label.sotamt" /></th>
															<th><spring:message code="label.edit" /></th>
															<th><spring:message code="label.remove" /></th>

														</tr>
													</thead>
													<tbody>

														<c:forEach var="salesOdrLineEditList"
															items="${salesOdrLineEditList}">

															<spring:bind path="salesOrderCmd.esalesOrderLineId">
																<input type="hidden" name="esalesOrderLineId"
																	id="esalesOrderLineId${salesOdrLineEditList.esalesOrderLineId}"
																	value="${salesOdrLineEditList.esalesOrderLineId}" />
															</spring:bind>
															<tr id="${salesOdrLineEditList.esalesOrderLineId}">

																<td><spring:bind path="salesOrderCmd.ematerialId">
																		<input type="hidden" name="ematerialId"
																			class="textbox"
																			id="materialIdEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.ematerialId}" readonly />
																	</spring:bind> <spring:bind path="salesOrderCmd.ematerialName">
																		<input type="text" name="ematerialName"
																			class="textbox"
																			id="materialNameEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.ematerialName}"
																			readonly />
																	</spring:bind></td>


																<td><spring:bind path="salesOrderCmd.ecurrencyId">
																		<input type="hidden" name="ecurrencyId"
																			id="currencyIdEdit${salesOdrLineEditList.esalesOrderLineId}"
																			class="textbox"
																			value="${salesOdrLineEditList.ecurrencyId}" readonly />
																	</spring:bind> <spring:bind path="salesOrderCmd.ecurrencyName">
																		<input type="text" name="ecurrencyName"
																			id="currencyNameEdit${salesOdrLineEditList.esalesOrderLineId}"
																			class="textbox"
																			value="${salesOdrLineEditList.ecurrencyName}"
																			readonly />
																	</spring:bind></td>


																<td><spring:bind
																		path="salesOrderCmd.ecustMaterailNo">
																		<input type="text" name="ecustMaterailNo"
																			class="textbox"
																			id="custMaterailNoEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.ecustMaterailNo}"
																			readonly />
																	</spring:bind></td>
																<td><spring:bind path="salesOrderCmd.equantity">
																		<input type="text" name="equantity" class="textbox"
																			id="quantityEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.equantity}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesOrderCmd.euomId">
																		<input type="hidden" name="euomId"
																			id="UOMIdEdit${salesOdrLineEditList.esalesOrderLineId}"
																			class="textbox"
																			value="${salesOdrLineEditList.euomId}" readonly />
																	</spring:bind> <spring:bind path="salesOrderCmd.euomName">
																		<input type="text" name="euomName"
																			id="UOMNameEdit${salesOdrLineEditList.esalesOrderLineId}"
																			class="textbox"
																			value="${salesOdrLineEditList.euomName}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesOrderCmd.euPrice">
																		<input type="text" name="euPrice" class="textbox"
																			id="unitPriceEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.euPrice}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesOrderCmd.enetPrice">
																		<input type="text" name="enetPrice" class="textbox"
																			id="netPriceEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.enetPrice}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesOrderCmd.etax">
																		<input type="text" name="etax" class="textbox"
																			id="taxEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.etax}" readonly />
																	</spring:bind></td>

																<td><spring:bind path="salesOrderCmd.ediscount">
																		<input type="text" name="ediscount" class="textbox"
																			id="discountEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.ediscount}" readonly />
																	</spring:bind></td>
																<td><spring:bind path="salesOrderCmd.etotalAmt">
																		<input type="text" name="etotalAmt" class="textbox"
																			id="totalAmtEdit${salesOdrLineEditList.esalesOrderLineId}"
																			value="${salesOdrLineEditList.etotalAmt}" readonly />
																	</spring:bind></td>

																<td><a href="#"
																	id="${salesOdrLineEditList.esalesOrderLineId}"
																	onclick="javascript:editSalesOdrDetailsInEdit(this)"><img
																		src="images/Edit.jpg" height="25px" width="25px"
																		id="edit${salesOdrLineEditList.esalesOrderLineId}"></img></a></td>
																		
																			<c:if test="${delBtn==true}">
																<td><a href="#"
																	id="${salesOdrLineEditList.esalesOrderLineId}"
																	onclick="javascript:getIDSO(this.id)"><img
																		src="images/button_cancel.png" height="25px"
																		width="25px"
																		id="${salesOdrLineEditList.esalesOrderLineId}"></img></a>

																	<input type="hidden"
																	name="Check${salesOdrLineEditList.esalesOrderLineId}"
																	id="${salesOdrLineEditList.esalesOrderLineId}Check"
																	value="0" /></td>
																	</c:if>
																<c:set var="delBtn" value="true"></c:set>
															</tr>

															<script>
																function getIDSO(
																		link) {
																	//alert(link.id);
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link
																					+ "Check").value = "1";
																	document
																			.getElementById(link).style.display = "none";
																}
																function editSalesOdrDetailsInEdit(
																		link) {
																	//alert(""+ link.id);

																	$(
																			"#dialog-form-salesLineEdit")
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
																	$(
																			'#currencyIdEdit')
																			.val(
																					$(
																							'#currencyIdEdit'
																									+ link.id)
																							.val());
																	$(
																			'#custMaterailNoEdit')
																			.val(
																					$(
																							'#custMaterailNoEdit'
																									+ link.id)
																							.val());
																	$(
																			'#unitPriceEdit')
																			.val(
																					$(
																							'#unitPriceEdit'
																									+ link.id)
																							.val());
																	$(
																			'#netPriceEdit')
																			.val(
																					$(
																							'#netPriceEdit'
																									+ link.id)
																							.val());
																	$(
																			'#taxEdit')
																			.val(
																					$(
																							'#taxEdit'
																									+ link.id)
																							.val());
																	$(
																			'#discountEdit')
																			.val(
																					$(
																							'#discountEdit'
																									+ link.id)
																							.val());
																	$(
																			'#totalAmtEdit')
																			.val(
																					$(
																							'#totalAmtEdit'
																									+ link.id)
																							.val());

																	$(
																			'#hiddenIdBankPopUpEdit')
																			.val(
																					link.id);

																};
															</script>

														</c:forEach>


													</tbody>

												</table>

												<button id="create-AddSalesEdit" type="button">
													<spring:message code="label.newsalesodrline" />
												</button>
											</div>

										</div>
									</div>

								</div>
								<!-- Sub Tab Edit Start -->

								<%-- 	<div id="tabSchLine2">
								<div align="center">
								 <script>
											var btrid =40;
											$(function() {

												var cqtyEdit = $("#childQuantityEdit"), cuomIdEdit = $("#childUOMIdEdit"),cdelDateEdit = $("#deliveryDateEdit"),hiddenEdit = $("#hiddenIdSalesSchPopUpEdit"),
												
												allFields = $([]).add(cqtyEdit).add(cuomIdEdit).add(cdelDateEdit)	
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

												$("#dialog-form-salesLineSchEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 250,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");

																	bValid1 = bValid1&& requiredEdit(cuomIdEdit,"UOM");
																	bValid1 = bValid1 && checkRegexp(cqtyEdit,/^([0-9.])+$/i,"Quantity is Required And Must be  Number");
																	bValid1 = bValid1&& requiredEdit(cdelDateEdit,"Delivery Date");
	
																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					
																					$("#SalesLineSchEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											
																											+ "<td><spring:bind path='salesOrderCmd.esosUomId'><input type='hidden' name='esosUomId' id='childUOMIdEdit"
																											+ btrid
																											+ "' value="
																											+ cuomIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<input type='text'readonly class='textbox' name='uomName' value='"+$('#childUOMIdEdit :selected').text()+"'"
																											+"</td>"
																											
																											+ "<td><spring:bind path='salesOrderCmd.esosQuantity'><input name='esosQuantity' id='childQuantityEdit"
																											+ btrid
																											+ "' value="
																											+ cqtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											
																											+ "<td><spring:bind path='salesOrderCmd.esosDelDate'><input name='esosDelDate' id='deliveryDateEdit"
																											+ btrid
																											+ "' value="
																											+ cdelDateEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+"<input type='hidden' name='esalesOrderSchLineId' id='esalesOrderSchLineId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																											
																											+"<td><a href='#'  onclick='editSalesOdrSchInNewEdit("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeSalesOdrSchEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					btrid++;
																					$(this).dialog("close");																												
																									
																				}
																			
																			if (hiddenEdit.val() != "0") {
																				$('#childUOMIdEdit'+ hiddenEdit.val()).val($('#childUOMIdEdit').val());
																				$('#UOMNameEdit'+ hiddenEdit.val()).val($('#childUOMIdEdit :selected').text()); 
																				$('#childQuantityEdit'+ hiddenEdit.val()).val($('#childQuantityEdit').val());
																				$('#deliveryDateEdit'+ hiddenEdit.val()).val($('#deliveryDateEdit').val());
																				$('#hiddenIdSalesSchPopUpEdit').val("0");
																						
																				$(this).dialog("close");
																								
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

												$("#createEditSalesLineSch").button().click(function() {
													
													$("#dialog-form-salesLineSchEdit").dialog("open");
													//alert("Open");
																
														});				
											});
											function removeSalesOdrSchEditNew(
													id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editSalesOdrSchInNewEdit(link) {
												//alert(link);
												$("#dialog-form-salesLineSchEdit").dialog("open");
												$('#childUOMIdEdit').val($('#childUOMIdEdit'+ link).val());
												$('#childQuantityEdit').val($('#childQuantityEdit'+ link).val());
												$('#deliveryDateEdit').val($('#deliveryDateEdit'+ link).val());
												$('#hiddenIdSalesSchPopUpEdit')
														.val(link);

											}
										</script> 
									
										
								  <div id="dialog-form-salesLineSchEdit" title="<spring:message code="label.socform"  />">
											<p class="validateTips" align="center" style="color: blue;">All Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="esalesOrderSchLineId" value="0" />

												<tr>
												<td><spring:message code="label.souomidc" /> <span
													class=required>*</span></td>
												<td><form:select path="esos_UomId" id="childUOMIdEdit"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${SelectUom}" />
														</form:select></td>
											</tr>
											
											<tr>
												<td><spring:message code="label.soqty" /><span
													class=required>*</span></td>
												<td><form:input path="esosQuantity" id="childQuantityEdit"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.sodeldate" /><span
													class=required>*</span></td>
												<td><form:input path="esosDelDate" id="deliveryDateEdit"
														class="textbox" /></td>
											</tr>
											
											<tr>																							
											<td>
											<input type="hidden" name="hiddenIdSalesSchPopUpEdit" id="hiddenIdSalesSchPopUpEdit" value="0" />
														
												</td></tr>		
												

											</table>
										</div>
								 <div id="users-SalesLineSchEdit">
										<table id="SalesLineSchEdit" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.souomidc" /></th>
													<th><spring:message code="label.soqty" /> </th>
													<th><spring:message code="label.sodeldate" /> </th>
													<th><spring:message code="label.edit" /></th>
													 <th><spring:message code="label.remove" /></th> 
												</tr>
											</thead>
											<tbody>
											<c:forEach var="salesSchEditList"
														items="${salesSchEditList}">
																									
														<spring:bind path="salesOrderCmd.esalesOrderSchLineId">
															<input type="hidden" name="esalesOrderSchLineId"
																id="esalesOrderSchLineId${salesSchEditList.esalesOrderSchLineId}"
																value="${salesSchEditList.esalesOrderSchLineId}" />
														</spring:bind>
														<tr id="${salesSchEditList.esalesOrderSchLineId}">

															<td><spring:bind path="salesOrderCmd.esosUomId">
																	<input type="hidden" name="esosUomId"
																		id="childUOMIdEdit${salesSchEditList.esalesOrderSchLineId}"
																		class="textbox"
																		value="${salesSchEditList.esosUomId}" readonly/>
																</spring:bind>
																
																 <spring:bind path="salesOrderCmd.childUomName">
																	<input type="text" name="childUomName"
																		id="childUOMNameEdit${salesSchEditList.esalesOrderSchLineId}"
																		class="textbox"
																		value="${salesSchEditList.childUomName}" readonly/>
																</spring:bind> 	
																</td>
																
																<td><spring:bind path="salesOrderCmd.esosQuantity">
																	<input type="text" name="esosQuantity" class="textbox"
																		id="childQuantityEdit${salesSchEditList.esalesOrderSchLineId}"
																		value="${salesSchEditList.esosQuantity}" readonly/>
																</spring:bind></td>
																
															
																<td><spring:bind path="salesOrderCmd.esosDelDate">
																	<input type="text" name="esosDelDate" class="textbox"
																		id="deliveryDateEdit${salesSchEditList.esalesOrderSchLineId}"
																		value="${salesSchEditList.esosDelDate}" readonly/>
																</spring:bind></td>
																
															
															<td><a href="#"
																id="${salesSchEditList.esalesOrderSchLineId}"
																onclick="javascript:editSalesOdrSchDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${salesSchEditList.esalesOrderSchLineId}"></img></a>
																	
																</td>
															<td> <a href="#"
																id="${salesSchEditList.esalesOrderSchLineId}"
																onclick="javascript:getIDSCH(this.id)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px"
																	id="${salesSchEditList.esalesOrderSchLineId}"></img></a>

															<input type="hidden" name="checkSch${salesSchEditList.esalesOrderSchLineId}" 
																	id="${salesSchEditList.esalesOrderSchLineId}checkSch" value="0"/></td>
														</tr>

														<script>
														function getIDSCH(
																link) {
															alert(link);
															alert("Deleting Particular Row Will Deleted Once You Click Update Button");
															document
																	.getElementById(link
																			+ "checkSch").value = "1";
															document
																	.getElementById(link).style.display = "none";
														}
														function editSalesOdrSchDetailsInEdit(link) {
																//alert(""+ link.id);
																$("#dialog-form-salesLineSchEdit").dialog("open");
																$('#childUOMIdEdit').val($('#childUOMIdEdit'+ link.id).val());
																$('#childQuantityEdit').val($('#childQuantityEdit'+ link.id).val());
																$('#deliveryDateEdit').val($('#deliveryDateEdit'+ link.id).val());
																$('#hiddenIdSalesSchPopUpEdit').val(link.id);
															}
														</script> 

													</c:forEach>
											
											
											</tbody>
										</table>
									</div>  
								
									<button id="createEditSalesLineSch" type="button"><spring:message code="label.sonewlinesch" /></button>
								
								</div>
								</div> --%>

								<!-- Sub Tab Edit Start -->

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