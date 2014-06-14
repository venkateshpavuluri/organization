<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Production Order Process</title>
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
<!--  Date picker -->
<script>
	function dateFun(datePattern) {

		$("#startDate,#startDateEditt,#endDate,#endDateEdit").datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true,

		});
	}
</script>

<script type="text/javascript">
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

		$("#add,#search").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#tabsForEdit").hide();
			$("#warningmesssage").hide();
			$("#prodOrderId").val('');
			$("#processDetailId").val('');
			$("#workCenterId").val('');
			$("#startDate").val('');
			$("#endDate").val('');
			$("#inspPoint").val('');

		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();

			$('#mainSearch').hide();

			$('#basicSearch').show();
		}
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#basicSearch').click(function() {
			$("#aslink").show();
			$('#mainSearch').show();
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

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#sumbtnid')
								.click(
										function(event) {

											$('#addPOPform')
													.validate(
															{
																rules : {
																	prodOrderId : {
																		required : true
																	},
																	processDetailId : {
																		required : true
																	},
																	workCenterId : {
																		required : true
																	},
																	startDate : {
																		required : true
																	},
																	endDate : {
																		required : true
																	},
																	inspPoint : {
																		required : true
																	}

																},
																messages : {
																	prodOrderId : "<font style='color: red;'><b>Production Order No is Required</b></font>",
																	processDetailId : "<font style='color: red;'><b>Process Detail is Required</b></font>",
																	workCenterId : "<font style='color: red;'><b>Work Center is Required</b></font>",
																	startDate : "<font style='color: red;'><b>Start Date is Required</b></font>",
																	endDate : "<font style='color: red;'><b>Finish Date is Required</b></font>",
																	inspPoint : "<font style='color: red;'><b>Inspection Point is Required</b></font>"

																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editPOPForm')
													.validate(
															{
																rules : {
																	prodOrderId : {
																		required : true
																	},
																	processDetailId : {
																		required : true
																	},
																	workCenterId : {
																		required : true
																	},
																	startDate : {
																		required : true
																	},
																	endDate : {
																		required : true
																	},
																	inspPoint : {
																		required : true
																	}

																},
																messages : {
																	prodOrderId : "<font style='color: red;'><b>Production Order No is Required</b></font>",
																	processDetailId : "<font style='color: red;'><b>Process Detail is Required</b></font>",
																	workCenterId : "<font style='color: red;'><b>Work Center is Required</b></font>",
																	startDate : "<font style='color: red;'><b>Start Date is Required</b></font>",
																	endDate : "<font style='color: red;'><b>Finish Date is Required</b></font>",
																	inspPoint : "<font style='color: red;'><b>Inspection Point is Required</b></font>"

																},

															});

										});

					});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Production Order Process</div>
		<!-- Tabs Declaration -->
		<div>
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					
					<c:if test="${popEditList!=null}">
						<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
									code="label.edit" /></a></li>
					</c:if>
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
								code="label.search" /></a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
								code="label.add" /></a></li>
				</ul>

				<!-- Search tab part -->

				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">
						<form:form action="popSearch.mnt" method="GET"
							commandName="popCmd">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="addSus"
											items="${param.addSus}">
											<div class="alert-success" id="savemessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.saveSuccess"></spring:message>
											</div>
										</c:forEach> <c:if test="${param.addFail!=null }">
											<div class="alert-danger" id="savemessage">
												<strong><spring:message code="label.error" /> </strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.saveFail" />
											</div>
										</c:if> <c:forEach var="popUpdate" items="${param.updateSus}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.updateSuccess"></spring:message>
											</div>
										</c:forEach> <c:forEach var="popUpdateError" items="${param.updateFail}">
											<div class="alert-danger" id="successmessage">
												<strong><spring:message code="label.error" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.updateFail"></spring:message>
											</div>
										</c:forEach> <c:forEach var="popDelete" items="${param.deleteSus}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.deleteSuccess"></spring:message>
											</div>
										</c:forEach> <c:forEach var="popDeleteError" items="${param.deleteFail}">
											<div class="alert-danger" id="successmessage">
												<strong><spring:message code="label.error" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.deleteFail"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<tr id="mainSearch">
									<td><spring:message code="label.searchby" /> <form:select
											path="xmlLabel" cssClass="select">
											<form:options items="${xmlItems}" />
										</form:select> <spring:bind path="popCmd.operations">
											<select class="select" name="operations">
												<option value="<spring:message code='assignedOperator'/>">
													<spring:message code="label.equalsTo" />
												</option>
												<option value="<spring:message code='notequalsOperator'/>">
													<spring:message code="label.notEqualsTo" />
												</option>
												<option value="<spring:message code='beginsWithOperator'/>">
													<spring:message code="label.beginsWith" />
												</option>
												<option value="<spring:message code='endsWithOperator'/>">
													<spring:message code="label.endsWith" />
												</option>
												<option value="<spring:message code='containsOperator'/>">
													<spring:message code="label.contains" />
												</option>
											</select>
										</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /> <c:set
											var="save" value="true"></c:set> <c:set var="edit"
											value="true"></c:set> <c:set var="delete" value="true"></c:set>
										<c:set var="update" value="true"></c:set> <c:set var="search"
											value="true"></c:set> <fmt:setBundle basename="button" /> <fmt:message
											key="label.save" var="messagesav" /> <fmt:message
											key="label.search" var="messagesea" /> <fmt:message
											key="label.delete" var="messagedel" /> <fmt:message
											key="label.update" var="messageup" /> <fmt:message
											key="label.edit" var="messageed" /> <c:forEach
											items="${sessionScope.privilegeList}" var="privileges">
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

										</c:forEach> <c:choose>
											<c:when test="${search}">

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

							</table>

						</form:form>

						<c:if test="${popSearch!=null}">
							<display:table id="popValue" name="popSearch"
								requestURI="popSearch.mnt" pagesize="5" class="table">
								<!-- Displaying  the Searched information by using display tag -->
								<display:column property="prodOrderId"
									titleKey="label.productionOrderNo" media="html" sortable="true" />
								<display:column property="processDetailId"
									titleKey="label.processDetail" media="html" sortable="true" />
								<display:column property="workCenterId"
									titleKey="label.workCenter" media="html" sortable="true" />
								<display:column property="startDate" titleKey="label.startDate"
									media="html" sortable="true" />
								<display:column property="endDate" titleKey="label.finishDate"
									media="html" sortable="true" />
									<display:column property="inspPoint" titleKey="label.popinsp"
									media="html" sortable="true" />
								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${edit }">
											<a
												href="popsEdit.mnt?popId=<c:out value="${popValue.popId}"/>"
												style="color: red"><img src="images/Edit.jpg"
												width="20px" height="20px" /> </a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Edit.jpg" width="20px" height="20px"
												class="btn btn-danger" /></a>
										</c:otherwise>
									</c:choose>
								</display:column>
								<display:column titleKey="label.delete">

									<c:choose>
										<c:when test="${delete}">
											<a
												href="popDelete.mnt?popId=<c:out value="${popValue.popId}"/>"
												style="color: red"
												onclick="return confirm('Do u want to delete the Record?')"><img
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
								<display:setProperty name="paging.banner.group_size" value="3" />
							</display:table>
						</c:if>
					</div>
				</div>

				<!-- Add tab details -->


				<div id="tabs-3" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						<form:form action="popAdd.mnt" method="POST" commandName="popCmd"
							id="addPOPform">
							<table class="tableGeneral">
								
								<tr>
									<td><spring:message code="label.productionOrderNo" /><font
										color="red">*</font></td>
									<td><form:select path="prodOrderId" class="select"
											id="prodOrderId">
											<form:option value="">-Select-</form:option>
											<form:options items="${productionOrder }" />
										</form:select></td>
									
								</tr>
								<tr>
									<td><spring:message code="label.processDetail" /><font
										color="red">*</font></td>
									<td><form:select path="processDetailId" class="select"
											id="processDetailId">
											<form:option value="">-Select-</form:option>
											<form:options items="${processDetail }" />
										</form:select></td>
								</tr>

								<tr>
									<td><spring:message code="label.workCenter" /><font
										color="red">*</font></td>
									<td><form:select path="workCenterId" id="workCenterId"
											class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${workCenter }" />
										</form:select></td>
								</tr>


								<tr>
									<td><spring:message code="label.startDate" /><font
										color="red">*</font></td>
									<td><form:input path="startDate" id="startDate"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.finishDate" /><font
										color="red">*</font></td>
									<td><form:input path="endDate" id="endDate"
											class="textbox" /></td>
								</tr>
								
								<tr>
									<td><spring:message code="label.popinsp" /><font
										color="red">*</font></td>
									<td><form:select path="inspPoint" id="inspPoint"
											class="select">
											<form:option value="">-Select-</form:option>
											<form:option value="1">Yes</form:option>
											<form:option value="0">No</form:option>
										</form:select></td>
								</tr>

							</table>

							<!-- Sub tabbing for adding pop Eqp details -->
							<div id="tabsForAdd">

								<!-- Production Order Process tab -->
								<ul>
									<li><a href="#subtabs-1"><spring:message code="label.popequipment" /> </a></li>
												
									<li><a href="#subtabs-2"><spring:message
												code="label.popemployee" /> </a></li>

								</ul>
								<div id="subtabs-1">
									<div align="center">
										<script>
											var poptrid = 1;
											$(function() {

												var eqpId = $("#eqpId"), uomId = $("#uomId"), eCost = $("#estimatedCost"), hiddenID = $("#hiddenIdPOPPopUp"), allFields = $(
														[]).add(eqpId).add(
														uomId).add(eCost).add(
														hiddenID), tips = $(".validateTips");
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

												function selectLength(o, n) {
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

												$("#dialog-form-POP")
														.dialog(
																{
																	autoOpen : false,
																	height : 260,
																	width : 320,
																	modal : true,
																	buttons : {
																		Submit : function() {
																			var bValid = true;
																			allFields
																					.removeClass("ui-state-error");

																			bValid = bValid
																					&& selectLength(
																							eqpId,
																							"Equipment Name");

																			bValid = bValid
																					&& selectLength(
																							uomId,
																							"Uom");

																			bValid = bValid
																					&& checkRegexp(
																							eCost,
																							/^([0-9.])+$/,
																							"Estimated Cost is Required And Must be  Number");

																			if (bValid) {

																				if (hiddenID
																						.val() == "0"
																						|| hiddenID
																								.val() == "") {

																					$(
																							"#POPAdd tbody")
																							.append(
																									"<tr id="+poptrid+">"

																											+ "<td align='center'><input type='hidden' name='equipmentId' id='eqpId"
																											+ poptrid
																											+ "' value="
																											+ eqpId
																													.val()
																											+ "  class='textbox'readonly/><input type='text' name='eqpName' id='eqpName"
																											+ poptrid
																											+ "' value="
																											+ $(
																													'#eqpId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input type='hidden' name='uomId' id='uomId"
																											+ poptrid
																											+ "' value="
																											+ uomId
																													.val()
																											+ " class='textbox'/><input type='text' name='uomName' id='uomName"
																											+ poptrid
																											+ "' value="
																											+ $(
																													'#uomId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input name='estimatedCost' id='estimatedCost"
																											+ poptrid
																											+ "' value="
																											+ eCost
																													.val()
																											+ " class='textbox' readonly/></td>"

																											+ "<td><a href='#'  onclick='editPopEqp("
																											+ poptrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removePopEqp("
																											+ poptrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");

																					poptrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																				if (hiddenID
																						.val() != "0") {
																					$(
																							'#eqpId'
																									+ hiddenID
																											.val())
																							.val(
																									eqpId
																											.val());
																					$(
																							'#eqpName'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#eqpId :selected')
																											.text());

																					$(
																							'#uomId'
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
																											'#uomId :selected')
																											.text());

																					$(
																							'#estimatedCost'
																									+ hiddenID
																											.val())
																							.val(
																									eCost
																											.val());

																					$(
																							'#hiddenIdPOPPopUp')
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

												$("#create-AddPOP")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-POP")
																			.dialog(
																					"open");

																});
											});
											function removePopEqp(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editPopEqp(id) {
												//alert("edit row " + id);

												$("#dialog-form-POP").dialog(
														"open");

												$('#eqpId').val(
														$('#eqpId' + id).val());
												$('#eqpName').val(
														$('#eqpName' + id)
																.val());

												$('#uomId').val(
														$('#uomId' + id).val());
												$('#uomName').val(
														$('#uomName' + id)
																.val());

												$('#estimatedCost')
														.val(
																$(
																		'#estimatedCost'
																				+ id)
																		.val());

												$('#hiddenIdPOPPopUp').val(id);

											}
										</script>
										<div id="dialog-form-POP"
											title="Add New Production Order Process Equipment">
											<p class="validateTips"></p>
											<table class="tableGeneral">

												<tr>
													<td><spring:message code="label.popeqp" /><font
														color="red">*</font></td>
													<td><form:select path="eqpName" id="eqpId"
															class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${equipmentSelect }" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.popuom" /><font
														color="red">*</font></td>
													<td><form:select path="uomName" id="uomId"
															class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${uomSelect }" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.popecost" /><font
														color="red">*</font></td>
													<td><form:input path="estimatedCost"
															id="estimatedCost" class="textbox" /> <input
														type="hidden" name="hiddenIdPOPPopUp"
														id="hiddenIdPOPPopUp" value="0" /></td>
												</tr>
											</table>
										</div>


										<div id="users-contain-POP">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="POPAdd" class="table">
												<thead>
													<tr>

														<th><spring:message code="label.popeqp" /></th>
														<th><spring:message code="label.popuom" /></th>
														<th><spring:message code="label.popecost" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>

													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
										<button id="create-AddPOP" type="button">
											<spring:message code="label.popaddeqp"/></button>

									</div>
								</div>


								<div id="subtabs-2">
									<div align="center">

										<script type="text/javascript">
											var btrid = 1;

											$(document)
													.ready(
															function() {

																var empId = $("#empId"), hiddenID = $("#hiddenIdAccountPopUp"),

																allFields = $(
																		[])
																		.add(
																				empId)
																		.add(
																				hiddenID), tips = $(".validateTips");
																function updateTips(
																		t) {
																	tips
																			.text(
																					t)
																			.addClass(
																					"ui-state-highlight");
																	setTimeout(
																			function() {
																				tips
																						.removeClass(
																								"ui-state-highlight",
																								1500);
																			},
																			500);

																}

																function checkLength(
																		o, n,
																		min,
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
																		o,
																		regexp,
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
																		"#dialogPopEmp")
																		.dialog(
																				{

																					autoOpen : false,
																					height : 200,
																					width : 290,
																					modal : true,
																					buttons : {
																						Submit : function() {
																							var bValid = true;
																							allFields
																									.removeClass("ui-state-error");

																							bValid = bValid
																									&& required(
																											empId,
																											"Employee");

																							if (bValid) {

																								if (hiddenID
																										.val() == "0"
																										|| hiddenID
																												.val() == "") {
																									$(
																											"#popEmpAdd tbody")
																											.append(

																													"<tr id="+btrid+">"

																															+ "<td><input type='hidden' name='empId' id='empId"
																															+ btrid
																															+ "' value="
																															+ empId
																																	.val()
																															+ " class='textbox' readonly/>"
																															+ "<input type='text' class='textbox' readonly name='empNo' id='empNo"
																															+ btrid
																															+ "' value='"
																															+ $(
																																	'#empId :selected')
																																	.text()
																															+ "'"
																															+ "</td>"

																															+ "<td><a href='#'  onclick='editCustAccount("
																															+ btrid
																															+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																															+ "<td><a href='#'  onclick='removeCustAccount("
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
																											'#empId'
																													+ hiddenID
																															.val())
																											.val(
																													empId
																															.val());
																									$(
																											'#empNo'
																													+ hiddenID
																															.val())
																											.val(
																													$(
																															'#empId :selected')
																															.text());

																									$(
																											'#hiddenIdAccountPopUp')
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
																		'#createAddPopEmp')
																		.button()
																		.click(
																				function() {

																					$(
																							"#dialogPopEmp")
																							.dialog(
																									"open");
																					//alert("opened");
																				});
															});

											function removeCustAccount(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editCustAccount(id) {
												//alert("edit row " + id);
												$("#dialogPopEmp").dialog(
														"open");
												//$('#customIdChild').val($('#customIdChild' + id).val());
												$('#empId').val(
														$('#empId' + id).val());

												$('#hiddenIdAccountPopUp').val(
														id);
												// document.getElementById("").value="edit";
											}
										</script>

										<div id="dialogPopEmp" align="center"
											title="Production Order Process Employee">
											<p class="validateTips" align="center" style="color: blue;"></p>
											<table class="tableGeneral">
												<tr>
													<td><spring:message code="label.popemp" /> <span
														class=required>*</span></td>
													<td><form:select path="empNo" id="empId"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${employeeSelect}" />
														</form:select></td>
												</tr>


												<tr>
													<td><input type="hidden" name="hiddenIdAccountPopUp"
														id="hiddenIdAccountPopUp" value="0" /></td>
												</tr>

											</table>
										</div>

										<div id="users-PopEmp">
											<table id="popEmpAdd" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.popemp" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>

										<button id="createAddPopEmp" type="button">
											<spring:message code="label.popaddemp"/></button>

									</div>

								</div>

							</div>
							<c:choose>
								<c:when test="${save}">
									<input type="submit"
										value="<spring:message code="label.save"/>"
										class="btn btn-primary" id="sumbtnid" />
								</c:when>
								<c:otherwise>
									<input type="submit" disabled="disabled"
										value='<spring:message code="label.save"/>'
										class="btn btn-danger" id="sumbnid" />
								</c:otherwise>

							</c:choose>
							<input type="reset" value="<spring:message code="label.reset"/>"
								class="btn btn-primary" />
						</form:form>
					</div>

				</div>

				<!-- Edit tab -->

				<div id="tabs-1" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">

						<form:form action="popsUpdate.mnt" method="POST" commandName="popCmd"
							id="editPOPForm">

							<c:if test="${popEditList!=null}">
								<table class="tableGeneral">
									
										<form:hidden path="popId" />
									<tr>
										<td><spring:message code="label.productionOrderNo" /><font
											color="red">*</font></td>
										<td><form:select path="prodOrderId" class="select"
												id="productionOrder">
												<form:option value="">-Select-</form:option>
												<form:options items="${productionOrder }" />
											</form:select></td>
										
									</tr>
									<tr>
										<td><spring:message code="label.processDetail" /><font
											color="red">*</font></td>
										<td><form:select path="processDetailId" class="select"
												id="processDetailId">
												<form:option value="">-Select-</form:option>
												<form:options items="${processDetail }" />
											</form:select></td>
									</tr>

									<tr>
										<td><spring:message code="label.workCenter" /><font
											color="red">*</font></td>
										<td><form:select path="workCenterId" id="workCenterId"
												class="select">
												<form:option value="">-Select-</form:option>
												<form:options items="${workCenter }" />
											</form:select></td>
									</tr>


									<tr>
										<td><spring:message code="label.startDate" /><font
											color="red">*</font></td>
										<td><form:input path="startDate" id="startDateEdit"
												class="textbox" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.finishDate" /><font
											color="red">*</font></td>
										<td><form:input path="endDate" id="endDateEdit"
												class="textbox" /></td>
									</tr>
									<tr>
									<td><spring:message code="label.popinsp" /><font
										color="red">*</font></td>
									<td><form:select path="inspPoint" id="inspPoint"
											class="select">
											<form:option value="">-Select-</form:option>
											<form:option value="1">Yes</form:option>
											<form:option value="0">No</form:option>
										</form:select></td>
								</tr>

								</table>

								<!-- Sub tabbing for adding Production Order Process details -->
								<div id="tabsForEdit">
									
										<!-- Production Order Process tab -->
										<ul>
											<li><a href="#subtabs-1"><spring:message code="label.popequipment" /></a></li>
														<li><a href="#subtabs-2"><spring:message code="label.popemployee" /></a></li>

										</ul>
										<div id="subtabs-1">
										<div align="center">
											<script>
												var btrid = 10;
												$(function() {

													var eqpIdEdit = $("#eqpIdEdit"), uomIdEdit = $("#uomIdEdit"), eCostEdit = $("#estimatedCostEdit"), hiddenEdit = $("#hiddenIdEqpPopUpEdit"),

													allFields = $([])
															.add(eqpIdEdit).add(
																	uomIdEdit).add(
																	eCostEdit).add(
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

													function checkLength(o, n,
															min, max) {
														if (o.val().length > max
																|| o.val().length < min) {
															o
																	.addClass("ui-state-error");
															updateTips("Length of "
																	+ n
																	+ " must be between "
																	+ min
																	+ " and "
																	+ max + ".");
															return false;
														} else {
															return true;
														}
													}
													function required(o, n) {
														if (o.val().length == 0) {
															o
																	.addClass("ui-state-error");
															updateTips("" + n);
															return false;
														} else {
															return true;
														}
													}

													function checkRegexp(o,
															regexp, n) {
														if (!(regexp.test(o
																.val()))) {
															o
																	.addClass("ui-state-error");
															updateTips(n);
															return false;
														} else {
															return true;
														}
													}

													$("#dialog-form-EqpEdit")
															.dialog(
																	{
																		autoOpen : false,
																		height : 260,
																		width : 300,
																		modal : true,
																		buttons : {
																			"Submit" : function() {
																				var bValid1 = true;
																				allFields
																						.removeClass("ui-state-error");
																				bValid1 = bValid1
																						&& required(
																								eqpIdEdit,
																								"Equipment Name is Required");

																				bValid1 = bValid1
																						&& required(
																								uomIdEdit,
																								"Uom is Required");
																				bValid1 = bValid1
																						&& checkRegexp(
																								eCostEdit,
																								/^([0-9.])+$/i,
																								"Estimated Cost is Required And Should be Numbers");

																				if (bValid1) {
																					//alert("edi"+ hiddenEdit	.val());
																					if (hiddenEdit
																							.val() == "0"
																							|| hiddenEdit
																									.val() == "") {
																						$(
																								"#AddEqpEdit tbody")
																								.append(
																										"<tr id="+btrid+">"
																												+ "<td ><spring:bind path='popCmd.equipmentId'><input type='hidden' name='equipmentId' id='eqpIdEdit"
																												+ btrid
																												+ "' value="
																												+ eqpIdEdit
																														.val()
																												+ "  class='textbox'readonly/></spring:bind><input type='text' name='eqpName' id='eqpNameEdit"
																												+ btrid
																												+ "' value="
																												+ $(
																														'#eqpIdEdit :selected')
																														.text()

																												+ "  class='textbox'readonly/></td>"

																												+ "<td><spring:bind path='popCmd.uomId'><input type='hidden' name='uomId' id='uomIdEdit"
																												+ btrid
																												+ "' value="
																												+ uomIdEdit
																														.val()
																												+ " class='textbox'/></spring:bind><input type='text' name='uomName' id='uomNameEdit"
																												+ btrid
																												+ "' value="
																												+ $(
																														'#uomIdEdit :selected')
																														.text()

																												+ "  class='textbox'readonly/></td>"

																												+ "<td><spring:bind path='popCmd.uomId'><input name='estimatedCost' id='estimatedCostEdit"
																												+ btrid
																												+ "' value="
																												+ eCostEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind><input type='hidden' name='popEqpId' id='popEqpIdEdit' value='0'/></td>"
																												+ "<td><a href='#'  onclick='editEqpInEditNew("
																												+ btrid
																												+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																												+ "<td><a href='#'  onclick='removeEqpEditNew("
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
																						$('#eqpIdEdit'+ hiddenEdit.val()).val($('#eqpIdEdit').val());																																				
																						$('#eqpNameEdit'+ hiddenEdit.val()).val($('#eqpIdEdit :selected').text());
																						$('#uomIdEdit'+ hiddenEdit.val()).val($('#uomIdEdit').val());																																				
																						$('#uomNameEdit'+ hiddenEdit.val()).val($('#uomIdEdit :selected').text());
																						$('#estimatedCostEdit'+ hiddenEdit.val()).val($('#estimatedCostEdit').val());	
																						$('#hiddenIdEqpPopUpEdit').val("0");
																								
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

													$("#create-AddEqpEdit")
															.button()
															.click(
																	function() {
																		$(
																				"#dialog-form-EqpEdit")
																				.dialog(
																						"open");

																	});
												});
												function removeEqpEditNew(
														id) {
													//alert("removing row " + id);
													$('#' + id).remove();
												}
												function editEqpInEditNew(
														link) {
													//alert(link);
													$("#dialog-form-EqpEdit")
															.dialog("open");
													$('#eqpIdEdit').val($('#eqpIdEdit'+ link).val());
													$('#eqpNameEdit').val($('#eqpNameEdit'+ link).val());
													$('#uomIdEdit').val($('#uomIdEdit'+ link).val());
													$('#uomNameEdit').val($('#uomNameEdit'+ link).val());
													$('#estimatedCostEdit').val($('#estimatedCostEdit'+ link).val());
																			
													$('#hiddenIdEqpPopUpEdit')
															.val(link);

												}
											</script>
											<div id="dialog-form-EqpEdit"
												title="Add New Production Order Process Equipment">
												<p class="validateTips"></p>
												<table class="tableGeneral">
												<form:hidden path="popEqpId" value="0" />
													<tr>
														<td><spring:message code="label.popeqp" /><font
															color="red">*</font></td>
														<td><form:select path="eqpName" id="eqpIdEdit"
																class="select">
																<form:option value="">-Select-</form:option>
																<form:options items="${equipmentSelect }" />
															</form:select></td>
													</tr>

													<tr>
														<td><spring:message code="label.popuom" /><font
															color="red">*</font></td>
														<td><form:select path="uomName" id="uomIdEdit"
																class="select">
																<form:option value="">-Select-</form:option>
																<form:options items="${uomSelect }" />
															</form:select></td>
													</tr>

													<tr>
														<td><spring:message code="label.popecost" /><font
															color="red">*</font></td>
														<td><form:input path="estimatedCost"
																id="estimatedCostEdit" class="textbox" /> <input
															type="hidden" name="hiddenIdEqpPopUpEdit"
															id="hiddenIdEqpPopUpEdit" value="0" /></td>
													</tr>
												</table>
											</div>

											<div id="users-contain-EqpEdit">
												<table id=AddEqpEdit class="table">
													<thead>
														<tr>

															<th><spring:message code="label.popeqp" /></th>
															<th><spring:message code="label.popuom" /></th>
															<th><spring:message code="label.popecost" /></th>
															<th><spring:message code="label.edit" /></th>
															<th><spring:message code="label.remove" /></th>

														</tr>
													</thead>
													<tbody>
														<c:forEach var="eqpEditList" items="${eqpEdit}">

															<tr id="${eqpEditList.popEqpId}">

																<spring:bind path="popCmd.popEqpId">
																	<input type="hidden"
																		name="popEqpId" class="textbox"
																		value="${eqpEditList.popEqpId}"
																		id="popEqpId${eqpEditList.popEqpId}" />
																</spring:bind>

																<spring:bind path="popCmd.equipmentId">
																	<input type="hidden" name="equipmentId" class="textbox"
																		value="${eqpEditList.equipmentId}"
																		id="eqpIdEdit${eqpEditList.popEqpId}" />
																</spring:bind>

																<td><spring:bind path="popCmd.eqpName">
																		<input type="text" name="eqpName" class="textbox"
																			readonly="readonly" value="${eqpEditList.eqpName}"
																			id="eqpNameEdit${eqpEditList.popEqpId}" />
																	</spring:bind></td>

																<spring:bind path="popCmd.uomId">
																	<input type="hidden" name="uomId" class="textbox"
																		value="${eqpEditList.uomId}"
																		id="uomIdEdit${eqpEditList.popEqpId}" />
																</spring:bind>
																<td><spring:bind path="popCmd.uomName">
																		<input type="text" name="uomName" class="textbox"
																			readonly="readonly" value="${eqpEditList.uomName}"
																			id="uomNameEdit${eqpEditList.popEqpId}" />
																	</spring:bind></td>


																<td><spring:bind path="popCmd.estimatedCost">
																		<input type="text" name="estimatedCost"
																			id="estimatedCostEdit${eqpEditList.popEqpId}" class="textbox"
																			value="${eqpEditList.estimatedCost}"
																			readonly="readonly" />
																			
																	</spring:bind> <input type='hidden'
																	name="${eqpEditList.popEqpId}Check"
																	id="${eqpEditList.popEqpId}Check" value="0" /></td>
																	
																<td><a href="#" id="${eqpEditList.popEqpId}"
																	onclick="javascript:editPOPDetailsInEdit(this)"><img
																		src="images/Edit.jpg" height="25px" width="25px"
																		id="edit${eqpEditList.popEqpId}"></img></a></td>
																<td><a href="#" id="${eqpEditList.popEqpId}"
																	onclick="javascript:getID1(this)"><img
																		src="images/button_cancel.png" height="25px"
																		width="25px" id="${eqpEditList.popEqpId}"></img></a></td>
															</tr>



															<script type="text/javascript">
																function getID1(
																		link) {

																	alert("Deleting Particular Row Will Deleted Once You Click Ok");
																	document
																			.getElementById(link.id
																					+ "Check").value = "1";

																	document
																			.getElementById(link.id).style.display = "none";
																}
																function editPOPDetailsInEdit(
																		link) {
																	//alert(link.id);

																	$(
																			"#dialog-form-EqpEdit")
																			.dialog(
																					"open");

																	$('#eqpIdEdit')
																			.val(
																					$(
																							'#eqpIdEdit'
																									+ link.id)
																							.val());

																	$('#uomIdEdit')
																			.val(
																					$(
																							'#uomIdEdit'
																									+ link.id)
																							.val());

																	$('#estimatedCostEdit')
																			.val(
																					$(
																							'#estimatedCostEdit'
																									+ link.id)
																							.val());

																	$(
																			'#hiddenIdEqpPopUpEdit')
																			.val(
																					link.id);

																}
															</script>

														</c:forEach> 

													</tbody>

												</table>
											</div>
											<button id="create-AddEqpEdit" type="button"><spring:message code="label.popaddeqp"/></button>

										</div>

									</div>
									
									<!-- Sub Tab Edit Start -->

								<div id="subtabs-2">
									<div align="center">
										<script>
											var btrid = 40;
											$(function() {

												var empIdEdit = $('#empIdEdit'), hiddenEdit = $("#hiddenIdEmpPopUpEdit"),

												allFields = $([]).add(empIdEdit)
														.add(
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

												$(
														"#dialog-form-popEmpEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 200,
																	width : 290,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");

																			bValid1 = bValid1
																					&& requiredEdit(
																							empIdEdit,
																							"Employee No");
																			

																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {

																					$(
																							"#PopEmpEdit tbody")
																							.append(
																									"<tr id="+btrid+">"

																											+ "<td><input type='hidden' name='empId' id='empIdEdit"
																											+ btrid
																											+ "' value="
																											+ empIdEdit
																													.val()
																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='empNo' id='empNoEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#empIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<input type='hidden' name='popEmpId' id='popEmpIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"

																											+ "<td><a href='#'  onclick='editPopEmpInNewEdit("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removePopEmpEditNew("
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
																							'#empIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#empIdEdit')
																											.val());
																					$(
																							'#empNoEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#empIdEdit :selected')
																											.text());
																															$(
																							'#hiddenIdEmpPopUpEdit')
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

												$("#createEditPopEmp")
														.button()
														.click(
																function() {

																	$(
																			"#dialog-form-popEmpEdit")
																			.dialog(
																					"open");
																	//alert("Open");

																});
											});
											function removePopEmpEditNew(
													id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editPopEmpInNewEdit(
													link) {
												//alert(link);
												$(
														"#dialog-form-popEmpEdit")
														.dialog("open");
												$('#empIdEdit').val(
														$(
																'#empIdEdit'
																		+ link)
																.val());
										
												$(
														'#hiddenIdEmpPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-popEmpEdit"
											title="Production Order Process Employee">
											<p class="validateTips" align="center" style="color: blue;">All
												Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="popEmpId" value="0" />

												<tr>
													<td><spring:message code="label.popemp" /> <span
														class=required>*</span></td>
													<td><form:select path="empNo" id="empIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${employeeSelect}" />
														</form:select></td>
												</tr>
												
												<tr>
													<td><input type="hidden"
														name="hiddenIdEmpPopUpEdit"
														id="hiddenIdEmpPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>
										<div id="users-PopEmpEdit">
											<table id="PopEmpEdit" class="table">

												<tr>
													<th><spring:message code="label.popemp" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>

												<c:forEach var="empEditList"
													items="${empEdit}">
													<spring:bind path="popCmd.popEmpId">
														<input type="hidden" name="popEmpId"
															id="popEmpId${empEditList.popEmpId}"
															value="${empEditList.popEmpId}" />
													</spring:bind>
													<tr id="a${empEditList.popEmpId}">
														<td><spring:bind path="popCmd.empId">
																<input type="hidden" name="empId"
																	id="empIdEdit${empEditList.popEmpId}"
																	class="textbox"
																	value="${empEditList.empId}" readonly />
															</spring:bind> <spring:bind path="popCmd.empNo">
																<input type="text" name="empNo"
																	id="empNoEdit${empEditList.popEmpId}"
																	class="textbox"
																	value="${empEditList.empNo}" readonly />
															</spring:bind></td>

														<td><a href="#"
															id="${empEditList.popEmpId}"
															onclick="javascript:editPopEmpInEdit(this)"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="edit${empEditList.popEmpId}"></img></a></td>
														<td><a href="#"
															id="${empEditList.popEmpId}"
															onclick="javascript:getIDAC(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px" id="${empEditList.popEmpId}"></img></a>

															<input type="hidden"
															name="checkEmp${empEditList.popEmpId}"
															id="${empEditList.popEmpId}checkEmp"
															value="0" /></td>
													</tr>

													<script>
														function getIDAC(accId) {
															//alert(accId.id);
															alert("Deleting Particular Row Will Deleted Once You Click Update Button");
															document
																	.getElementById(accId.id
																			+ "checkEmp").value = "1";
															document
																	.getElementById("a"
																			+ accId.id).style.display = "none";
														}
														function editPopEmpInEdit(
																link) {
															//alert(""+ link.id);
															$(
																	"#dialog-form-popEmpEdit")
																	.dialog(
																			"open");
															$('#empIdEdit')
																	.val(
																			$(
																					'#empIdEdit'
																							+ link.id)
																					.val());
															
															$(
																	'#hiddenIdEmpPopUpEdit')
																	.val(
																			link.id);
														}
													</script>

												</c:forEach>

											</table>
										</div>


										<button id="createEditPopEmp" type="button">
											<spring:message code="label.popaddemp"/>
										</button>

									</div>
								</div>

								<!-- Sub Tab Edit Start -->
									
								</div>
								<table>
									<tr>
										<td colspan="2"><c:choose>
												<c:when test="${update}">
													<input type="submit"
														value="<spring:message code="label.update"/>"
														class="btn btn-primary" id="updateid" />
												</c:when>
												<c:otherwise>
													<td><input type="submit" disabled="disabled"
														value="<spring:message code="label.update"/>"
														class="btn btn-danger" id="updateId" /></td>
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
	</div>
</body>
</html>