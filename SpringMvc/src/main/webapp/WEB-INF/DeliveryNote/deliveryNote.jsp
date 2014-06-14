<!-- @author Venkatesh -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
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
						//AddForm Validations

						$('#subid')
								.click(
										function(event) {

											$('#addDeliveryform')
													.validate(
															{
																rules : {
																	rfqType : {
																		required : true
																	},
																	deliveryNoteDate : {
																		required : true
																	},
																	salesOrderId : {
																		required : true
																	},
																	totalWeight : {
																		required : true,
																		number : true
																	},
																	plannedGI : {
																		required : true
																	},
																	uomId : {
																		required : true
																	},
																	noofPacks : {
																		required : true,
																		number : true
																	},
																	palntRfq : {
																		required : true
																	},
																	actualGI : {
																		required : true

																	},
																	statusId : {
																		required : true

																	},

																},
																messages : {
																	deliveryNoteDate : "<font style='color: red;'><b>Delivery Note Date is Required</b></font>",
																	salesOrderId : "<font style='color: red;'><b>Sales Order is Required</b></font>",
																	totalWeight : {
																		required : "<font style='color: red;'><b>Total Weight is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	plannedGI : "<font style='color: red;'><b>Planned GI is Required</b></font>",
																	uomId : "<font style='color: red;'><b>Uom is Required</b></font>",
																	noofPacks : {
																		required : "<font style='color: red;'><b>Number Of Packs is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	actualGI : "<font style='color: red;'><b>Actual GI is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},

															});

											if ($('#deliveryNoteDate').val() != ""
													&& $('#actualGI').val() != ""
													&& $('#salesOrderId').val() != ""
													&& $('#statusId').val() != "") {
												if ($('#dnId').val() == 0) {
													//alert("Please Enter AtLeast One Delivery Note Line");
													document
															.getElementById("childMsg").style.display = "block";
													$('#childMsg')
															.html(
																	"Warning! Please Enter AtLeast One Delivery Note Line");
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

											$('#editDeliveryForm')
													.validate(
															{
																rules : {
																	deliveryNoteDateEdit : {

																		required : true
																	},
																	salesOrderIdEdit : {
																		required : true
																	},
																	totalWeightEdit : {
																		required : true,
																		number : true
																	},
																	plannedGIEdit : {
																		required : true
																	},
																	uomIdEdit : {
																		required : true
																	},
																	noofPacksEdit : {
																		required : true,
																		number : true
																	},
																	actualGIEdit : {
																		required : true
																	},
																	statusIdEdit : {
																		required : true
																	},

																},
																messages : {
																	deliveryNoteDateEdit : "<font style='color: red;'><b>Delivery NoteDate is Required</b></font>",
																	salesOrderIdEdit : "<font style='color: red;'><b>Sales Order is Required</b></font>",
																	totalWeightEdit : {
																		required : "<font style='color: red;'><b>Total Weight is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	plannedGIEdit : "<font style='color: red;'><b>Planned GI is Required</b></font>",
																	uomIdEdit : "<font style='color: red;'><b>Uomis Required</b></font>",
																	noofPacksEdit : {
																		required : "<font style='color: red;'><b>Number Of Packs is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Numbers Only</b></font>"
																	},
																	actualGIEdit : "<font style='color: red;'><b>Actual GI is Required</b></font>",
																	statusIdEdit : "<font style='color: red;'><b>Status is Required</b></font>",

																},
															});

										});

					});
</script>

<script type="text/javascript">
	function dateFun(datePattern) {
		$('#deliveryNoteDate,#plannedGI,#actualGI').datepicker(
				{
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					onSelect : function(d) {
						var date = $('#deliveryNoteDate,#plannedGI')
								.datepicker('getDate');
						date.setDate(date.getDate() + 0);
						$('#plannedGI,#actualGI').datepicker('option',
								'minDate', date);
					}

				});
		$('#deliveryNoteDateEdit,#plannedGIEdit,#actualGIEdit').datepicker(
				{
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					onSelect : function(d) {
						var date = $('#deliveryNoteDateEdit,#plannedGIEdit')
								.datepicker('getDate');
						date.setDate(date.getDate() + 0);
						$('#plannedGIEdit,#actualGIEdit').datepicker('option',
								'minDate', date);
					}
				});
		$('#date,#basicSearchId').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
			
		});

	}
</script>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#basicSearchId').focus();
			$('#salesOrderId').focus();
			$('#successmessage').hide();
			$('#savemessage').hide();

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
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Delivery Note</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<c:set var="editvalues" value="${editvalues }"></c:set>

					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					
						<form:form action="searchDelivery.mnt" method="GET"
							commandName="DeliveryNoteForm">
							<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.deliverynote" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.deliverynote" />
											<spring:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach items="${dlNoteUpdateSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.deliverynote" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${dlNoteUpdateFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.deliverynote" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${dlNoteDeleteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.deliverynote" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${dlNoteDeleteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.deliverynote" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>

							</tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
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
										<c:when test="${privileges eq messageup }">
											<c:set var="update" value="true"></c:set>
										</c:when>
									</c:choose>

								</c:forEach>

								<td><c:choose>
										<c:when test="${true }">
											<input type="submit"
												value="<spring:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>

									</c:choose></td>
							</tr>
						
						 <form:form action="deliveryAdvanceSearch.mnt" method="get"
							commandName="DeliveryNoteForm" name="advanceSearchFinal">
							<tr>
									<td colspan="2"><a href="deliveryAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
						</form:form>  
					</table>

					<form:form action="deliveryAdvanceSearchOperations.mnt"
						commandName="DeliveryNoteForm" method="get">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="DeliveryNoteForm.asOpts">
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
												<c:set var="bdField" value="${xmlLabelValue.dbField}" />
											<c:set var="deliveryNoteDate" value="deliveryNoteDate" />
												<c:if test="${bdField eq  deliveryNoteDate}">

											<td><form:input path="advanceSearchText"
													cssClass="textbox" id="date"/></td>
													</c:if>
										</tr>

									</c:forEach>
									

									<c:forEach var="refList" items="${refList}">
										<tr>
											<td><label>${refList.labels}</label> <form:hidden
													path="dbField" id="dbField" value="${refList.dbField}" /></td>
											<td><spring:bind path="DeliveryNoteForm.asOpts">
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
											<c:set var="salesOrderId" value="salesOrderId" />
											<c:set var="uomId" value="uomId" />
											
											<c:if test="${bdField eq salesOrderId}">
												<c:set var="selectBox" value="${salesOrderDetails}" />
											</c:if>
											<c:if test="${bdField eq uomId}">
												<c:set var="selectBox" value="${uomDetails}" />
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
									<td colspan="3"><c:choose>
											<c:when test="${search}">
												<input type="submit" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-primary" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													id="advanceSearchButtonId" value="Advance Search"
													style="display: none" class="btn btn-danger" />
											</c:otherwise>
										</c:choose></td>
								</tr>

							</table>

						</div>
					</form:form>
					</form:form>

					<c:if test="${listofDNotes!=null}">
					<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="deliveryAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="searchDelivery.mnt" />
							</c:otherwise>

						</c:choose>
						<div>
							<display:table id="listofDNotes" name="listofDNotes"
								requestURI="${search}" pagesize="5" class="table">
								<display:column property="deliveryNoteId"
									titleKey="label.deliveryNote" media="none" sortable="true"></display:column>
								<display:column property="deliveryNoteDate"
									titleKey="label.deliveryNoteDate" media="html" sortable="true"></display:column>
								<display:column property="salesOrderName"
									titleKey="label.salesOrder" media="html" sortable="true"></display:column>
								<display:column property="totalWeight"
									titleKey="label.totalWeight" media="html" sortable="true"></display:column>
								<display:column property="uomName" titleKey="label.uom"
									media="html" sortable="true"></display:column>
								<display:column property="plannedGI" titleKey="label.plannedGI"
									media="html" sortable="true"></display:column>
								<display:column property="actualGI" titleKey="label.actualGI"
									media="html" sortable="true"></display:column>
								<display:column property="statusName" titleKey="label.status"
									media="html" sortable="true"></display:column>
								<display:column property="noofPacks" titleKey="label.noofPacks"
									media="html" sortable="true"></display:column>

								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${true}">
											<a
												href="deliveryNoteEdit.mnt?dnEdit=<c:out value="${listofDNotes.deliveryNoteId}"/>"
												style="color: red"><img src="images/Edit.jpg"
												width="20px" onclick="toggleTable();" height="20px" /> </a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Edit.jpg" width="20px"
												class="btn btn-danger" height="20px" /> </a>
										</c:otherwise>
									</c:choose>
								</display:column>
								<display:column titleKey="label.delete">
									<c:choose>
										<c:when test="${true}">
											<a
												href="deliveryNoteDelete.mnt?dndelId=<c:out value="${listofDNotes.deliveryNoteId}"/>"
												style="color: red"><img src="images/Delete.jpg"
												width="20px" height="20px"
												onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Delete.jpg" class="btn btn-danger"
												width="20px" height="20px" /> </a>
										</c:otherwise>
									</c:choose>
								</display:column>
								<display:setProperty name="paging.banner.placement"
									value="bottom" />

							</display:table>
						</div>
					</c:if>

				</div>
			</div>

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left">
					<table>
						<tr>
							<td colspan="4" class="alert-warning" id="childMsg"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
					</table>

					<form:form action="saveDeliveryNote.mnt" method="POST"
						commandName="DeliveryNoteForm" id="addDeliveryform">
						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">
										<tr>
											<td><spring:message code="label.salesOrder" /><span
												class="required">*</span></td>
											<td><form:select path="salesOrderId" id="salesOrderId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${salesOrderDetails}" />
												</form:select></td>
											<td><spring:message code="label.deliveryNoteDate" /><span
												class="required">*</span></td>
											<td><form:input path="deliveryNoteDate"
													id="deliveryNoteDate" class="textbox" /></td>


										</tr>
										<tr>
											<td><spring:message code="label.uom" /><span
												class="required">*</span></td>
											<td><form:select path="uomId" id="uomId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${uomDetails}" />
												</form:select></td>
											<td><spring:message code="label.plannedGI" /><span
												class="required">*</span></td>
											<td><form:input path="plannedGI" id="plannedGI"
													cssClass="textbox" /></td>

										</tr>
										<tr>
											<td><spring:message code="label.totalWeight" /><span
												class="required">*</span></td>
											<td><form:input path="totalWeight" id="totalWeight"
													class="textbox" maxlength="16" /></td>

											<td><spring:message code="label.actualGI" /><span
												class="required">*</span></td>
											<td><form:input path="actualGI" id="actualGI"
													class="textbox" /></td>

										</tr>
										<tr>

											<td><spring:message code="label.noofPacks" /><span
												class="required">*</span></td>
											<td><form:input path="noofPacks" id="noofPacks"
													cssClass="textbox" maxlength="10" /></td>

											<td><spring:message code="label.status" /><span
												class="required">*</span></td>
											<td><form:select path="statusId" id="statusId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${statusDetails}" />
												</form:select> <input type="hidden" name="dnId" id="dnId" class="textbox"
												value="0" /></td>
										</tr>


									</table>
								</td>

							</tr>
						</table>
						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message
											code="label.deliveryNoteLine" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

								<!-- <div align="center"> -->

								<script>
									var btrfqid = 1;
									$(function() {

										var matid = $("#materialId"), umid = $("#dnluomid"), qtid = $("#quantity"), ddate = $("#storageLocation"),bNo=$('#batchNo'), hiddenDeliveryID = $("#hiddenIdDeliveryPopUp")

										allFields = $([]).add(matid).add(qtid)
												.add(umid).add(ddate).add(
														hiddenDeliveryID).add(bNo),
												tips = $(".validateTips");

										function updateTips(t) {
											tips.text(t).addClass(
													"ui-state-highlight");
											setTimeout(function() {
												tips.removeClass(
														"ui-state-highlight",
														1500);
											}, 500);
										}

										function checkLength(o, n, min, max) {
											if (o.val().length > max
													|| o.val().length < min) {
												o.focus();
												o.addClass("ui-state-error");
												updateTips("Length of " + n
														+ " must be between "
														+ min + " and " + max
														+ ".");
												return false;
											} else {
												return true;
											}
										}
										function checkLength1(o, n) {
											if (o.val().length == "") {
												o.focus();
												o.addClass("ui-state-error");
												updateTips(n);
												return false;
											} else {
												return true;
											}
										}

										function checkRegexp(o, regexp, n) {
											if (!(regexp.test(o.val()))) {
												o.focus();
												o.addClass("ui-state-error");
												updateTips(n);
												return false;
											} else {
												return true;
											}
										}

										$("#dialog-form-Rfq")
												.dialog(
														{
															autoOpen : false,
															height : 270,
															width : 350,
															modal : true,
															buttons : {
																Submit : function() {

																	var bValid1 = true;
																	allFields
																			.removeClass("ui-state-error");
																	bValid1 = bValid1
																			&& checkLength1(
																					matid,

																					"Material is Required");

																	bValid1 = bValid1
																			&& checkLength1(
																					umid,

																					"UOM is Required");
																	bValid1 = bValid1
																			&& checkRegexp(
																					qtid,
																					/^([0-9.])+$/i,
																					"Quantity is Required And Must be  Number");
																	bValid1 = bValid1
																			&& checkLength1(
																					ddate,
																					"Storage Location is Required");
																	bValid1 = bValid1
																	&& checkLength1(
																			bNo,
																			"Batch No is Required");

																	if (bValid1) {

																		if (hiddenDeliveryID
																				.val() == "0"
																				|| hiddenDeliveryID
																						.val() == "") {

																			$(
																					"#deliveryAdd tbody")
																					.append(

																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='materialId' id='materialId"
																									+ btrfqid
																									+ "' value="
																									+ matid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ " <input type='text' readonly class='textbox' name='materialName' id='materialName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#materialId :selected')
																											.text()
																									+ "'"
																									+ " /></td>"

																									+ "<td><input type='hidden' name='dnluomid' id='dnluomid"
																									+ btrfqid
																									+ "' value="
																									+ umid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='uomName' id='uomName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#dnluomid :selected')
																											.text()
																									+ "'"
																									+ "/></td>"
																									+ "<td><input type='text' name='quantity' id='quantity"
																									+ btrfqid
																									+ "' value="
																									+ qtid
																											.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td><input type='hidden' name='storageLocation' id='storageLocation"
																									+ btrfqid
																									+ "' value="
																									+ ddate
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input name='storageLocationName' id='storageLocationName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#storageLocation :selected')
																											.text()
																									+ "'"
																									+ btrfqid
																									+ "' value="
																									+ ddate
																											.val()
																									+ " class='textbox'readonly/></td>"
																									+ "<td><input type='text' name='batchNo' id='batchNo"
																									+ btrfqid
																									+ "' value="
																									+ bNo
																											.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td><a href='#'  onclick='editRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																									+ "<td><a href='#'  onclick='removeRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																									+ "</tr>");
																			$(
																					'#dnId')
																					.val(
																							btrfqid);

																			btrfqid++;
																			$(
																					this)
																					.dialog(
																							"close");
																		}

																		if (hiddenDeliveryID
																				.val() != "0") {
																			$(
																					'#materialId'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							matid
																									.val());

																			$(
																					'#materialName'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							$(
																									'#materialId :selected')
																									.text());

																			$(
																					'#quantity'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							qtid
																									.val());
																			$(
																					'#dnluomid'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							umid
																									.val());
																			$(
																					'#uomName'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							$(
																									'#dnluomid :selected')
																									.text());
																			$(
																					'#storageLocationName'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							$(
																									'#storageLocation :selected')
																									.text());

																			$(
																					'#storageLocation'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							ddate
																									.val());
																			$(
																					'#batchNo'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							bNo
																									.val());

																			$(
																					'#hiddenIdDeliveryPopUp')
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
																	$(this)
																			.dialog(
																					"close");
																}
															},
															close : function() {
																allFields
																		.val("")
																		.removeClass(
																				"ui-state-error");
															}
														});

										$("#Rfqlineadd").button().click(
												function() {
													$("#dialog-form-Rfq")
															.dialog("open");
													tips.text('');

												});
									});
									function removeRfq(id) {
										$('#' + id).remove();
									}
									function editRfq(id) {
										$(".validateTips").text('');
										$("#dialog-form-Rfq").dialog("open");
										$('#materialId').val(
												$('#materialId' + id).val());

										$('#quantity').val(
												$('#quantity' + id).val());
										$('#dnluomid').val(
												$('#dnluomid' + id).val());
										$('#storageLocation').val(
												$('#storageLocation' + id)
														.val());
										$('#batchNo').val(
												$('#batchNo' + id).val());
										$('#hiddenIdDeliveryPopUp').val(id);

									}
								</script>


								<div id="dialog-form-Rfq" align="center"
									title="Add New DeleveryNoteLine Details">
									<p class="validateTips" align="center" style="color: blue;">
									</p>
									<table class="tableGeneral">

										<%-- <tr><td><spring:message code="label.deliveryNote"/>
												</td>
												<td><form:select path="deliveryNoteId" id="deliveryNoteId" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${deliveryNoteId}" /> 
													
												</form:select></td>
											</tr> --%>
										<tr>

											<!-- <td><input type="hidden" id="processNumber" class="select" 
													cssStyle="height:25px;" /> -->


										</tr>
										<tr>
											<td><spring:message code="label.material" /><span
												class="required">*</span></td>
											<td><form:select path="materialId" id="materialId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${materialDetails}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.uom" /><span
												class="required">*</span></td>
											<td><form:select path="dnluomid" id="dnluomid"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${uomDetails}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.quantity" /><span
												class="required">*</span></td>
											<td><form:input path="quantity" id="quantity"
													class="textbox" maxlength="16" /> <input type="hidden"
												name="hiddenIdDeliveryPopUp" id="hiddenIdDeliveryPopUp"
												value="0" /></td>
										</tr>


										<tr>
											<td><spring:message code="label.storageLocation" /><span
												class="required">*</span></td>
											<td><form:select path="storageLocation"
													id="storageLocation" cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${storageLocDetails}" />
												</form:select></td>
										</tr>

										<tr>
										<td><spring:message code="label.dnbno" /><span
												class="required">*</span></td>
											<td><form:input path="batchNo" id="batchNo"
													class="textbox" maxlength="50" /></td>
										</tr>

									</table>
									<table>

									</table>
								</div>



								<div id="users-contain-Rfq">
									<!-- class="ui-widget" -->
									<h3></h3>
									<table id="deliveryAdd" class="table">
										<thead>
											<tr>
												<%-- 		<th><spring:message code="label.deliveryNote"/></th> --%>
												<th><spring:message code="label.material" /></th>
												<th><spring:message code="label.uom" /></th>
												<th><spring:message code="label.quantity" /></th>
												<th><spring:message code="label.storageLocation"></spring:message></th>
												<th><spring:message code="label.dnbno" /></th>
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>

											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<button id="Rfqlineadd" type="button">
										<spring:message code="label.adddeliveryline" />
									</button>
								</div>

								<form:hidden path="deliveryhide" />

							</div>
						</div>
						<table>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${true }">
											<input type="submit"
												value="<spring:message code="label.save"/>"
												class="btn btn-primary" id="subid" />
										</c:when>
										<c:otherwise>
											<input type="submit"
												value="<spring:message code="label.save"/>"
												class="btn btn-danger" disabled="disabled" id="subid" />
										</c:otherwise>
									</c:choose> <input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>

					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="deliveryUpdate.mnt" method="POST"
						commandName="DeliveryNoteForm" id="editDeliveryForm">

						<c:if test="${editvalues!=null}">
							<table class="tableGeneral">
								<form:hidden path="deliveryNoteIdEdit" />
								<tr>

									<td><spring:message code="label.salesOrder" /><span
										class="required">*</span></td>
									<td><form:select path="salesOrderIdEdit" cssClass="select"
											id="salesOrderIdEdit">
											<form:option value="">--Select--</form:option>
											<form:options items="${salesOrderDetails }" />
										</form:select></td>
									<td><spring:message code="label.deliveryNoteDate" /><span
										class="required">*</span></td>
									<td><form:input path="deliveryNoteDateEdit"
											id="deliveryNoteDateEdit" class="textbox" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.uom" /><span
										class="required">*</span></td>
									<td><form:select path="uomIdEdit" id="uomIdEdit"
											cssClass="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${uomDetails }" />
										</form:select></td>
									<td><spring:message code="label.plannedGI" /><span
										class="required">*</span></td>
									<td><form:input path="plannedGIEdit" id="plannedGIEdit"
											cssClass="textbox" /></td>
								</tr>
								<tr>

									<td><spring:message code="label.totalWeight" /><span
										class="required">*</span></td>

									<td><form:input path="totalWeightEdit"
											id="totalWeightEdit" class="textbox" maxlength="16" /></td>

									<td><spring:message code="label.actualGI" /><span
										class="required">*</span></td>
									<td><form:input path="actualGIEdit" id="actualGIEdit"
											class="textbox" /></td>

								</tr>
								<tr>

									<td><spring:message code="label.noofPacks" /><span
										class="required">*</span></td>
									<td><form:input path="noofPacksEdit" id="noofPacksEdit"
											cssClass="textbox" maxlength="10" /></td>

									<td><spring:message code="label.status" /><span
										class="required">*</span></td>
									<td><form:select path="statusIdEdit" id="statusIdEdit"
											cssClass="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${statusDetails }" />
										</form:select></td>
								</tr>

							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.deliveryNoteLine" /></a></li>

								</ul>


								<div align="center">

									<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

									<!-- <div align="center"> -->

									<script>
										var btrfqid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */

											var ematid = $("#materialIdEdit"), eqtid = $("#quantityEdit"), eumid = $("#dnluomIdEdit"), eddate = $("#storageLocationEdit"),bNoEdit=$('#batchNoEdit'), ehiddenrfqID = $("#hiddenIddeliveryeditPopUp")

											allFields = $([]).add(ematid).add(
													eqtid).add(eumid).add(
													eddate).add(ehiddenrfqID).add(bNoEdit),
													tips = $(".validateTips");

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips
																	.removeClass(
																			"ui-state-highlight",
																			1500);
														}, 500);
											}

											function checkLength2(o, n) {

												if (o.val().length == "") {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											function checkLength(o, n, min, max) {
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

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-RfqEdit")
													.dialog(
															{
																autoOpen : false,
																height : 270,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid2 = true;
																		allFields
																				.removeClass("ui-state-error");

																		bValid2 = bValid2
																				&& checkLength2(
																						ematid,

																						"Material is Required");

																		bValid2 = bValid2
																				&& checkLength2(
																						eumid,

																						"UOM is Required");
																		bValid2 = bValid2
																				&& checkRegexp(
																						eqtid,
																						/^([0-9.])+$/i,

																						"Quantity is Required  And Must be  Number");

																		bValid2 = bValid2
																				&& checkLength2(
																						eddate,
																						"Storage Location is Required");
																		bValid2 = bValid2
																		&& checkLength2(
																				bNoEdit,
																				"Batch No is Required");
																		if (bValid2) {

																			if (ehiddenrfqID
																					.val() == "0"
																					|| ehiddenrfqID
																							.val() == "") {

																				$(
																						"#RFQEdit tbody")
																						.append(
																								"<tr id="+btrfqid+">"
																										+ "<td ><spring:bind path='DeliveryNoteForm.deliveryNoteLineidedit' ><input type='hidden'name='deliveryNoteLineidedit'  value='0'/> <input type='hidden' name='materialIdEdit' id='materialIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ ematid
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  "
																										+ "<spring:bind path='DeliveryNoteForm.materialNameEdit'><input type='text' readonly class='textbox' name='materialNameEdit' id='materialNameEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#materialIdEdit :selected')
																												.text()
																										+ "'"
																										+ "</spring:bind></td>"
																										+ "<spring:bind path='DeliveryNoteForm.quantityEdit'><td align='left'><input type='text' name='quantityEdit' id='quantityEdit"
																										+ btrfqid
																										+ "' value="
																										+ eqtid
																												.val()
																										+ "  class='textbox'readonly/></spring:bind></td>"

																										+ "<td><spring:bind path='DeliveryNoteForm.dnluomIdEdit'><input type='hidden' name='dnluomIdEdit' id='dnluomIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ eumid
																												.val()
																										+ " class='textbox'readonly/></spring:bind>"

																										+ "<spring:bind path='DeliveryNoteForm.dnluomNameEdit'><input type='text' readonly class='textbox' name='dnluomNameEdit' id='dnluomNameEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#dnluomIdEdit :selected')
																												.text()
																										+ "'"
																										+ "</spring:bind></td>"
																										+ "<td> <input type='hidden' name='storageLocationEdit' id='storageLocationEdit"
																										+ btrfqid
																										+ "' value="
																										+ eddate
																												.val()

																										+ " class='textbox'readonly/><input type='text' name='storageLocNameEdit' id='storageLocNameEdit"
																										+ btrfqid
																										+ "' value="
																										+ $(
																												'#storageLocationEdit :selected')
																												.text()
																												
																										+ " class='textbox'readonly/><input type='hidden' name='deliveryineidedit' value='0' id='deliveryineidedit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
																										+ "<spring:bind path='DeliveryNoteForm.batchNoEdit'><td><input type='text' name='batchNoEdit' id='batchNoEdit"
																										+ btrfqid
																										+ "' value="
																										+ bNoEdit
																												.val()
																										+ "  class='textbox'readonly/></td></spring:bind>"
																										+

																										"<td><a href='#'  onclick='editRfqEdit("
																										+ btrfqid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeRfqEdit("
																										+ btrfqid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");

																				btrfqid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}

																			if (ehiddenrfqID
																					.val() != "0") {
																				$(
																						'#materialIdEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								ematid
																										.val());
																				$(
																						'#materialNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#materialIdEdit :selected')
																										.text());
																				$(
																						'#quantityEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eqtid
																										.val());
																				$(
																						'#dnluomIdEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eumid
																										.val());
																				$(
																						'#dnluomNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#dnluomIdEdit :selected')
																										.text());
																				$(
																						'#storageLocationEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eddate
																										.val());
																				$(
																						'#storageLocNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#storageLocationEdit :selected')
																										.text());
																				$('#batchNoEdit'+ehiddenrfqID.val()).val(bNoEdit.val());

																				$(
																						'#hiddenIddeliveryeditPopUp')
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
																		$(this)
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

											$("#AddRFQEdit")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-RfqEdit")
																		.dialog(
																				"open");
																tips.text('');
																//alert("opened");
															});
										});
										function removeRfqEdit(id) {
											$('#' + id).remove();
										}

										function editRfqEdit(id) {
											//alert("edit row " + id);
											$(".validateTips").text('');
											$("#dialog-form-RfqEdit").dialog(
													"open");

											$('#materialIdEdit').val(
													$('#materialIdEdit' + id)
															.val());
											$('#quantityEdit').val(
													$('#quantityEdit' + id)
															.val());
											$('#dnluomIdEdit').val(
													$('#dnluomIdEdit' + id)
															.val());
											$('#storageLocationEdit')
													.val(
															$(
																	'#storageLocationEdit'
																			+ id)
																	.val());
											$('#batchNoEdit').val($('#batchNoEdit'+id).val());

											$('#hiddenIddeliveryeditPopUp')
													.val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-RfqEdit" align="center"
										title="Add New DeliveryLine Details">
										<p class="validateTips" align="center" style="color: blue;">
										</p>
										<table class="tableGeneral">
											<form:hidden path="deliveryNoteLineidedit" value="0" />
											<tr>
												<td><spring:message code="label.material" /> <span
													class="required">*</span></td>
												<td><form:select path="materialIdEdit"
														id="materialIdEdit" cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${materialDetails}" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.uom"></spring:message><span
													class="required">*</span></td>
												<td><form:select path="dnluomIdEdit" id="dnluomIdEdit"
														cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${uomDetails}" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.quantity" /> <span
													class="required">*</span></td>
												<td><form:input path="quantityEdit" id="quantityEdit"
														class="textbox" maxlength="16" /> <input type="hidden"
													name="hiddenIddeliveryeditPopUp"
													id="hiddenIddeliveryeditPopUp" value="0" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.storageLocation" /> <span
													class="required">*</span></td>
												<td><form:select path="storageLocationEdit"
														id="storageLocationEdit" cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${storageLocDetails}" />
													</form:select></td>
											</tr>
											
											<tr>
										<td><spring:message code="label.dnbno" /><span
												class="required">*</span></td>
											<td><form:input path="batchNoEdit" id="batchNoEdit"
													class="textbox" maxlength="50" /></td>
										</tr>


										</table>

									</div>

									<div id="users-contain-Process">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="RFQEdit" class="table">
											<thead>
												<tr>

													<th><spring:message code="label.material" /></th>
													<th><spring:message code="label.quantity" /></th>
													<th><spring:message code="label.uom" /></th>
													<th><spring:message code="label.storageLocation" /></th>
													<th><spring:message code="label.dnbno" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>

											</thead>
											<tbody>
												<c:forEach items="${deliverylindetails}"
													var="deliverylindetails">

													<spring:bind path="DeliveryNoteForm.deliveryNoteLineidedit">
														<input type="hidden" name="deliveryNoteLineidedit"
															id="deliveryNoteLineidedit${deliverylindetails.deliveryNoteLineidedit}"
															value="${deliverylindetails.deliveryNoteLineidedit}" />
													</spring:bind>

													<tr id="${deliverylindetails.deliveryNoteLineidedit}">
														<td><spring:bind
																path="DeliveryNoteForm.materialIdEdit">
																<input type="hidden" name="materialIdEdit"
																	class="textbox"
																	id="materialIdEdit${deliverylindetails.deliveryNoteLineidedit}"
																	value="${deliverylindetails.materialIdEdit}" />
															</spring:bind> <spring:bind path="DeliveryNoteForm.materialNameEdit">
																<input type="text" name="materialNameEdit"
																	class="textbox"
																	id="materialNameEdit${deliverylindetails.deliveryNoteLineidedit}"
																	value="${deliverylindetails.materialNameEdit}" readonly />
															</spring:bind></td>

														<td><spring:bind path="DeliveryNoteForm.quantityEdit">
																<input type="text" name="quantityEdit"
																	id="quantityEdit${deliverylindetails.deliveryNoteLineidedit}"
																	class="textarea"
																	value="${deliverylindetails.quantityEdit}" readonly />
															</spring:bind></td>
														<td><spring:bind path="DeliveryNoteForm.dnluomIdEdit">
																<input type="hidden" name="dnluomIdEdit"
																	id="dnluomIdEdit${deliverylindetails.deliveryNoteLineidedit}"
																	class="textbox"
																	value="${deliverylindetails.dnluomIdEdit}" readonly />
															</spring:bind> <spring:bind path="DeliveryNoteForm.dnluomNameEdit">
																<input type="text" name="dnluomNameEdit"
																	id="dnluomNameEdit${deliverylindetails.deliveryNoteLineidedit}"
																	class="textbox"
																	value="${deliverylindetails.dnluomNameEdit}" readonly />
															</spring:bind></td>
														<td><spring:bind
																path="DeliveryNoteForm.storageLocationEdit">
																<input type="hidden" name="storageLocationEdit"
																	id="storageLocationEdit${deliverylindetails.deliveryNoteLineidedit}"
																	class="textbox"
																	value="${deliverylindetails.storageLocationEdit}"
																	readonly />
															</spring:bind> <spring:bind path="DeliveryNoteForm.storageLocNameEdit">
																<input type="text" name="storageLocNameEdit"
																	id="storageLocNameEdit${deliverylindetails.deliveryNoteLineidedit}"
																	class="textbox"
																	value="${deliverylindetails.storageLocNameEdit}"
																	readonly />
															</spring:bind> <input type="hidden"
															name="Checkdelete${deliverylindetails.deliveryNoteLineidedit}"
															id="${deliverylindetails.deliveryNoteLineidedit}Checkdelete"
															value="0" /></td>
															<td><spring:bind path="DeliveryNoteForm.batchNoEdit">
																<input type="text" name="batchNoEdit"
																	id="batchNoEdit${deliverylindetails.deliveryNoteLineidedit}"
																	class="textbox"
																	value="${deliverylindetails.batchNoEdit}"
																	readonly /></spring:bind></td>


														<td><a href='#'
															id="${deliverylindetails.deliveryNoteLineidedit}"
															onclick="editRfqEdit(this.id)"><strong><img
																	src='images/Edit.jpg' height='25px' width='25px' /></strong></a></td>
														<c:if test="${delBtn==true}">
															<td><a href='#'
																id="${deliverylindetails.deliveryNoteLineidedit}"
																onclick="getID11(this)"><strong><img
																		src='images/button_cancel.png' height='25px'
																		width='25px' /></strong></a></td>
														</c:if>
														<c:set var="delBtn" value="true"></c:set>
													</tr>



													<script type="text/javascript">
														function getID11(link) {
															//alert(link.id);
															alert("Deleting Particular Row Will Deleted Once You Click Update Button");
															document
																	.getElementById(link.id
																			+ "Checkdelete").value = "1";
															document
																	.getElementById(link.id).style.display = "none";
														}
														function editProcessDetailsInEdit(
																link) {

															$(
																	"#dialog-form-RfqEdit")
																	.dialog(
																			"open");
															$(
																	'#materialidedit'
																			+ link.id)
																	.val(
																			$(
																					'#materialidedit')
																					.val());
															$('#qtyedit')
																	.val(
																			$(
																					'#qtyedit'
																							+ link.id)
																					.val());
															$('#uomidedit')
																	.val(
																			$(
																					'#uomidedit'
																							+ link.id)
																					.val());
															$('#ddateedit')
																	.val(
																			$(
																					'#ddateedit'
																							+ link.id)
																					.val());
															$('#batchNoEdit')
															.val(
																	$(
																			'#batchNoEdit'
																					+ link.id)
																			.val());
															

															$(
																	'#hiddenIddeliveryeditPopUp')
																	.val(
																			link.id);

														}
													</script>

												</c:forEach>
											</tbody>
										</table>
										<button id="AddRFQEdit" type="button">
											<spring:message code="label.adddeliveryline" />
										</button>
									</div>

								</div>

							</div>

							<table>
								<tr>
									<td colspan="2" align="center"><c:choose>
											<c:when test="${true }">

												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateid" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<spring:message code="label.update"/>"
													class="btn btn-danger" id="updateid" />
											</c:otherwise>
										</c:choose></td>

								</tr>

							</table>
						</c:if>
					</form:form>

				</div>
			</div>

		</div>
	</div>
</body>
</html>
