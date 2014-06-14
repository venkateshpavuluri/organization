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
<title>My JSP 'inspOperation.jsp' starting page</title>

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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addForm')
													.validate(
															{
																rules : {
																	operationNo : {
																		required : true,
																		number : true

																	},
																	inspTypeId : {
																		required : true

																	},
																	materialId : {
																		required : true
																	}

																},
																messages : {
																	operationNo : {
																		required : "<font style='color: red;'><b>Operation No is Required</b></font>",
																		number : "<font style='color: red;'><b>Operation No Allows Only Numbers</b></font>"
																	},
																	inspTypeId : "<font style='color: red;'><b>Inspection Type is Required</b></font>",
																	materialId : "<font style='color: red;'><b>Material Name is Required</b></font>"

																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editForm')
													.validate(
															{
																rules : {
																	operationNo : {
																		required : true,
																		number : true

																	},
																	inspTypeId : {
																		required : true

																	},
																	materialId : {
																		required : true
																	}

																},
																messages : {
																	operationNo : {
																		required : "<font style='color: red;'><b>Operation No is Required</b></font>",
																		number : "<font style='color: red;'><b>Operation No Allows Only Numbers</b></font>"
																	},
																	inspTypeId : "<font style='color: red;'><b>Inspection Type is Required</b></font>",
																	materialId : "<font style='color: red;'><b>Material Name is Required</b></font>"

																},

															});

										});

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#tabs,#tabss,#edittabs").tabs();
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#basicSearchId').focus();
			$('#operationNo').focus();
			$('#operationNo').val('');
			$('#inspTypeId').val('');
			$('#materialId').val('');
			$('#inspOperStepNo').val('');
			$('#noOfSamples').val('');

		});
	});
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

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>
<script type="text/javascript">
	function AjaxForDuplicate() {
		var debit = $('#inspOperationNo').val();
		//alert(debit);
		$
				.ajax({
					type : "POST",
					url : "checkDNAddDuplicate.mnt",
					data : "inspOperationNo=" + debit,
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
		var cust = $('#einspOperationNo').val();
		var id = $('#einspOperationId').val();
		//alert(id);
		$
				.ajax({
					type : "POST",
					url : "checkDNUpdateDuplicate.mnt",
					data : "einspOperationNo=" + cust + "&dnId=" + id,
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
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Inspection Operation</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:if test="${inspOperationEdit!=null}">

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

					<form:form method="get" action="inspOperationSearch.mnt"
						commandName="inspOperationCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addIOSsus"
										items="${param.addIOSsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.inspopr" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="addIOSFail"
										items="${param.addIOSFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.inspopr" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateInspSus"
										items="${param.updateInspSus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.inspopr" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateInspFail"
										items="${param.updateInspFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.inspopr" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteIOSsus"
										items="${param.DeleteIOSsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.inspopr" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteIOSFail"
										items="${param.DeleteIOSFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.inspopr" />
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
							
							<form:form action="inspOprAdvanceSearch.mnt" method="get"
								commandName="inspOperationCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="inspOprAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>

						</table>
						
						<form:form action="inspOprAdvanceSearchOperations.mnt"
							commandName="inspOperationCmd" method="get">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="inspOperationCmd.asOpts">
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
											<td><spring:bind path="inspOperationCmd.asOpts">
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
											<c:set var="materialId" value="materialId" />
											<c:set var="inspTypeId" value="inspTypeId" />
											<c:if test="${bdField eq materialId}">
												<c:set var="selectBox" value="${materialSelect}" />
											</c:if>
											
											<c:if test="${bdField eq inspTypeId}">
												<c:set var="selectBox" value="${inspTypeSelect}" />
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


					<c:if test="${IOSList!=null }">
					<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="inspOprAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="inspOperationSearch.mnt" />
							</c:otherwise>
						</c:choose>
						<display:table name="IOSList" id="IOSIDList" class="table"
							requestURI="${search}" pagesize="5">

							<display:column property="inspOperationId" sortable="true"
								title="inspOperationId" media="none" />

							<display:column property="inspTypeId" sortable="true"
								titleKey="label.insptype" media="html" />

							<display:column property="operationNo" sortable="true"
								titleKey="label.inspoperno" media="html" />


							<display:column property="materialId" sortable="true"
								titleKey="label.inspopmaid" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="inspOperationEdit.mnt?inspOperationId=<c:out value="${IOSIDList.inspOperationId}"/> "><img
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
											href="inspOperationDelete.mnt?inspOperationId=<c:out value="${IOSIDList.inspOperationId}"/> "
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
							<td colspan="2" id="salesDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.inspoperno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="inspOperationAdd.mnt" method="POST"
						commandName="inspOperationCmd" id="addForm">

						<table class="tableGeneral">
							<tr>
								<td>

									<table class="tableGeneral">

										<tr>
											<td><spring:message code="label.inspoperno" /><span
												class="required">*</span></td>
											<td><form:input path="operationNo" id="operationNo"
													cssClass="textbox" onkeyup="AjaxForDuplicate()"
													maxlength="20" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.insptype" /><span
												class="required">*</span></td>
											<td><form:select path="inspTypeId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${inspTypeSelect}" />
												</form:select></td>
										</tr>

										<tr>
											<td><spring:message code="label.inspopmaid" /><span
												class="required">*</span></td>
											<td><form:select path="materialId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${materialSelect}" />

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
											code="label.inopstep" /></a></li>
							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1">

								<!-- Model Pop-up Start-->

								<div align="center">
									<script type="text/javascript">
										var btrid = 1;

										$(document)
												.ready(
														function() {
															var stepNo = $("#inspOperStepNo"), noOfSam = $('#noOfSamples'), hiddenID = $("#hiddenIdDebitPopUp"),

															allFields = $([])
																	.add(stepNo)
																	.add(
																			noOfSam)
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
																	"#dialogforminspOperation")
																	.dialog(

																			{
																				autoOpen : false,
																				height : 250,
																				width : 350,
																				modal : true,
																				buttons : {
																					Submit : function() {
																						var bValid = true;
																						allFields
																								.removeClass("ui-state-error");

																						bValid = bValid
																								&& checkRegexp(
																										stepNo,
																										/^([0-9])+$/i,
																										"Inspection Operation Step is Required And Must be  Number");

																						bValid = bValid
																								&& checkRegexp(
																										noOfSam,
																										/^([0-9.])+$/i,
																										"No Of Samples is Required And Must be  Number");

																						if (bValid) {
																							//alert("hiddenid"+hiddenID.val());
																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {
																								$(
																										"#inspOperationAdd tbody")
																										.append(

																												"<tr id="+btrid+">"

																														+ "<td><input name='inspOperStepNo' id='inspOperStepNo"
																														+ btrid
																														+ "' value="
																														+ stepNo
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input name='noOfSamples' id='noOfSamples"
																														+ btrid
																														+ "' value="
																														+ noOfSam
																																.val()
																														+ " class='textbox' readonly/></td>"

																														+ "<td><a href='#'  onclick='editinspOperationLine("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeinspOperationLine("
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
																										'#inspOperStepNo'
																												+ hiddenID
																														.val())
																										.val(
																												stepNo
																														.val());
																								$(
																										'#noOfSamples'
																												+ hiddenID
																														.val())
																										.val(
																												noOfSam
																														.val());

																								$(
																										'#hiddenIdDebitPopUp')
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
																	'#createAddinspOperation')
																	.button()
																	.click(
																			function() {

																				$(
																						"#dialogforminspOperation")
																						.dialog(
																								"open");
																				//alert("opened");
																			});
														});

										function removeinspOperationLine(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editinspOperationLine(id) {
											//alert("edit row " + id);

											$("#dialogforminspOperation")
													.dialog("open");

											$('#inspOperStepNo').val(
													$('#inspOperStepNo' + id)
															.val());
											$('#noOfSamples').val(
													$('#noOfSamples' + id)
															.val());

											$('#hiddenIdDebitPopUp').val(id);
										}
									</script>


									<div id="dialogforminspOperation" align="center"
										title="<spring:message code="label.inopform" />">
										<p class="validateTips" align="center" style="color: blue;">All
											Form Fields are Required</p>
										<table class="tableGeneral">

											<tr>
												<td><spring:message code="label.inspstno" /><span
													class=required>*</span></td>
												<td><form:input path="inspOperStepNo"
														id="inspOperStepNo" class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.inspstsam" /><span
													class=required>*</span></td>
												<td><form:input path="noOfSamples" id="noOfSamples"
														class="textbox" maxlength="20" /></td>
											</tr>

											<tr>
												<td><input type="hidden" name="hiddenIdDebitPopUp"
													id="hiddenIdDebitPopUp" value="0" /></td>
											</tr>

										</table>
									</div>

									<div id="users-inspOperation">
										<table id="inspOperationAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.inspstno" /></th>
													<th><spring:message code="label.inspstsam" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>

									<button id="createAddinspOperation" type="button">
										<spring:message code="label.inopnew" />
									</button>

								</div>


								<!-- Model Pop-up End-->
							</div>


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
									<spring:message code="label.inspoperno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form method="post" action="inspOperationUpdate.mnt"
						commandName="inspOperationCmd" id="editForm">
						<c:forEach var="inspOperationEdit" items="${inspOperationEdit}">
							<c:set var="editMode" value="${inspOperationEdit}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td>
										<div>

											<table class="tableGeneral">

												<form:hidden path="inspOperationId" id="inspOperationId" />

												<tr>
													<td><spring:message code="label.inspoperno" /><span
														class="required">*</span></td>
													<td><form:input path="operationNo"
															id="operationNoEdit" cssClass="textbox"
															onkeyup="AjaxForDuplicate()" maxlength="20" /></td>

												</tr>



												<tr>
													<td><spring:message code="label.insptype" /><span
														class="required">*</span></td>
													<td><form:select path="inspTypeId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${inspTypeSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.inspopmaid" /><span
														class="required">*</span></td>
													<td><form:select path="materialId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${materialSelect}" />

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
												code="label.inopstep" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 10;
											$(function() {

												var inspOperStepNoEdit = $("#inspOperStepNoEdit"), noOfSamplesEdit = $('#noOfSamplesEdit'), hiddenEdit = $("#hiddenIdDebitPopUpEdit"),

												allFields = $([]).add(
														inspOperStepNoEdit)
														.add(noOfSamplesEdit)
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

												$("#dialog-form-InspOperEdit")
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

																			bValid1 = bValid1
																					&& checkRegexp(
																							inspOperStepNoEdit,
																							/^([0-9])+$/i,
																							"Inspection Operation No is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkRegexp(
																							noOfSamplesEdit,
																							/^([0-9.])+$/i,
																							"No Of Samples is Required And Must be  Number");

																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddInspOperEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='inspOperationCmd.inspOperStepNo'><input name='inspOperStepNo' id='inspOperStepNoEdit"
																											+ btrid
																											+ "' value="
																											+ inspOperStepNoEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><input type='text' name='noOfSamples' id='noOfSamplesEdit"
																											+ btrid
																											+ "' value='"
																											+ noOfSamplesEdit
																													.val()
																											+ "' class='textbox' readonly/></td>"

																											+ "<input type='hidden' name='inspOperStepId' id='inspOperStepId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																											+

																											"<td><a href='#'  onclick='editInspOperInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeInspOperEditNew("
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
																							'#inspOperStepNoEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#inspOperStepNoEdit')
																											.val());
																					$(
																							'#noOfSamplesEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#noOfSamplesEdit')
																											.val());

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

												$("#create-AddInspOperEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-InspOperEdit")
																			.dialog(
																					"open");

																});
											});
											function removeInspOperEditNew(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editInspOperInEditNew(link) {
												//alert(link);
												$("#dialog-form-InspOperEdit")
														.dialog("open");
												$('#inspOperStepNoEdit').val(
														$(
																'#inspOperStepNoEdit'
																		+ link)
																.val());
												$('#noOfSamplesEdit').val(
														$(
																'#noOfSamplesEdit'
																		+ link)
																.val());

												$('#hiddenIdDebitPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-InspOperEdit"
											title="<spring:message code="label.inopform" />">
											<p class="validateTips" align="center" style="color: blue;">All
												Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="inspOperStepId" value="0" />

												<tr>
													<td><spring:message code="label.inspstno" /><span
														class=required>*</span></td>
													<td><form:input path="inspOperStepNo"
															id="inspOperStepNoEdit" class="textbox" maxlength="20" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.inspstsam" /><span
														class=required>*</span></td>
													<td><form:input path="noOfSamples"
															id="noOfSamplesEdit" class="textbox" maxlength="20" /></td>
												</tr>


												<tr>
													<td><input type="hidden" name="hiddenIdDebitPopUpEdit"
														id="hiddenIdDebitPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-InspOperDetailEdit">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="AddInspOperEdit" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.inspstno" /></th>
														<th><spring:message code="label.inspstsam" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>
													</tr>
												</thead>
												<tbody>

													<c:forEach var="stepList" items="${stepList}">

														<spring:bind path="inspOperationCmd.inspOperStepId">
															<input type="hidden" name="inspOperStepId"
																id="inspOperStepId${stepList.inspOperStepId}"
																value="${stepList.inspOperStepId}" />
														</spring:bind>
														<tr id="${stepList.inspOperStepId}">

															<td><spring:bind
																	path="inspOperationCmd.inspOperStepNo">
																	<input type="text" name="inspOperStepNo"
																		class="textbox"
																		id="inspOperStepNoEdit${stepList.inspOperStepId}"
																		value="${stepList.inspOperStepNo}" readonly />
																</spring:bind></td>

															<td><spring:bind path="inspOperationCmd.noOfSamples">
																	<input type="text" name="noOfSamples" class="textbox"
																		id="noOfSamplesEdit${stepList.inspOperStepId}"
																		value="${stepList.noOfSamples}" readonly />
																</spring:bind></td>

															<td><a href="#" id="${stepList.inspOperStepId}"
																onclick="javascript:editInspOprInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${stepList.inspOperStepId}"></img></a></td>

															<td><a href="#" id="${stepList.inspOperStepId}"
																onclick="javascript:getIOStep(this.id)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px" id="${stepList.inspOperStepId}"></img></a> <input
																type="hidden" name="Check${stepList.inspOperStepId}"
																id="${stepList.inspOperStepId}Check" value="0" /></td>
														</tr>

														<script>
															function getIOStep(
																	link) {
																//alert(link);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link
																				+ "Check").value = "1";
																document
																		.getElementById(link).style.display = "none";
															}
															function editInspOprInEdit(
																	link) {
																//alert(""+ link.id);

																$(
																		"#dialog-form-InspOperEdit")
																		.dialog(
																				"open");

																$(
																		'#inspOperStepNoEdit')
																		.val(
																				$(
																						'#inspOperStepNoEdit'
																								+ link.id)
																						.val());
																$(
																		'#noOfSamplesEdit')
																		.val(
																				$(
																						'#noOfSamplesEdit'
																								+ link.id)
																						.val());

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
										<button id="create-AddInspOperEdit" type="button">
											<spring:message code="label.inopnew" />
										</button>

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