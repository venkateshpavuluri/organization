<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'wip.jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(function() {
		$("#tabs,#tab").tabs();
	});

	function dateFun(datePattern) {
		$('#workDay,#workDayEdit').datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : datePattern

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

#error {
	color: red;
	font-style: Bold;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {

											$('#addForm')
													.validate(
															{
																rules : {
																	jobcardId : {
																		required : true
																	},
																	workDay : {
																		required : true

																	},
																	shiftId : {
																		required : true
																	},
																	workcenterId : {
																		required : true
																	},
																	equipmentId : {
																		required : true
																	},
																	empId : {
																		required : true
																	},
																	qtyPlanned : {
																		required : true,
																		number : true
																	},
																	qtyManufactured : {
																		required : true,
																		number : true
																	},
																	uomId : {
																		required : true
																	},

																	qtyAccepted : {
																		number : true
																	},
																	qtyRejected : {
																		number : true
																	},
																	qtyRework : {
																		number : true
																	},
																	qtyRerun : {
																		number : true
																	},
																	toBeInspected : {
																		number : true
																	},
																	electricalMain : {
																		number : true
																	},
																	mechanicalmain : {
																		number : true
																	},
																	idleTime : {
																		number : true
																	},
																	setUpTime : {
																		number : true
																	},
																	waitingTime : {
																		number : true
																	},
																	unloadingTime : {
																		number : true
																	},
																	other : {
																		number : true
																	}

																},
																/*  errorPlacement :function(error){
																	return false;
																}, */
																messages : {

																	jobcardId : "<font style='color: red;'><b>Job Card is Required</b></font>",
																	workDay : "<font style='color: red;'><b>Work Day is Required</b></font>",
																	shiftId : "<font style='color: red;'><b>Shift is Required</b></font>",
																	workcenterId : "<font style='color: red;'><b>Work Center is Required</b></font>",
																	equipmentId : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	empId : "<font style='color: red;'><b>Employee is Required</b></font>",
																	qtyPlanned : {
																		required : "<font style='color: red;'><b>Quantity Planned is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Only Numbers</b></font>"
																	},
																	qtyManufactured : {
																		required : "<font style='color: red;'><b>Quantity Manufactured is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Only Numbers</b></font>"
																	},
																	uomId : "<font style='color: red;'><b>Uom is Required</b></font>",

																	qtyAccepted : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	qtyRejected : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	qtyRework : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	qtyRerun : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	toBeInspected : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	electricalMain : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	mechanicalmain : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	idleTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	setUpTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	waitingTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	unloadingTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	other : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",

																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											$('#editForm')
													.validate(
															{
																rules : {
																	jobcardId : {
																		required : true
																	},
																	workDay : {
																		required : true

																	},
																	shiftId : {
																		required : true
																	},
																	workcenterId : {
																		required : true
																	},
																	equipmentId : {
																		required : true
																	},
																	empId : {
																		required : true
																	},
																	qtyPlanned : {
																		required : true,
																		number : true
																	},
																	qtyManufactured : {
																		required : true,
																		number : true
																	},
																	uomId : {
																		required : true
																	},
																	qtyAccepted : {
																		number : true
																	},
																	qtyRejected : {
																		number : true
																	},
																	qtyRework : {
																		number : true
																	},
																	qtyRerun : {
																		number : true
																	},
																	toBeInspected : {
																		number : true
																	},
																	electricalMain : {
																		number : true
																	},
																	mechanicalmain : {
																		number : true
																	},
																	idleTime : {
																		number : true
																	},
																	setUpTime : {
																		number : true
																	},
																	waitingTime : {
																		number : true
																	},
																	unloadingTime : {
																		number : true
																	},
																	other : {
																		number : true
																	}

																},
																messages : {
																	jobcardId : "<font style='color: red;'><b>Job Card is Required</b></font>",
																	workDay : "<font style='color: red;'><b>Work Day is Required</b></font>",
																	shiftId : "<font style='color: red;'><b>Shift is Required</b></font>",
																	workcenterId : "<font style='color: red;'><b>Work Center is Required</b></font>",
																	equipmentId : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	empId : "<font style='color: red;'><b>Employee is Required</b></font>",
																	qtyPlanned : {
																		required : "<font style='color: red;'><b>Quantity Planned is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Planned Allows Only Numbers</b></font>"
																	},
																	qtyManufactured : {
																		required : "<font style='color: red;'><b>Quantity Manufactured is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Manufactured Allows Only Numbers</b></font>"
																	},
																	uomId : "<font style='color: red;'><b>Uom is Required</b></font>",
																	qtyAccepted : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	qtyRejected : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	qtyRework : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	qtyRerun : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	toBeInspected : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	electricalMain : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	mechanicalmain : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	idleTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	setUpTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	waitingTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	unloadingTime : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																	other : "<font style='color: red;'><b>It Allows Only Numbers</b></font>",
																},
															});

										});

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#jobcardId').val('');
			$('#workDay').val('');
			$('#shiftId').val('');
			$('#workcenterId').val('');
			$('#equipmentId').val('');
			$('#empId').val('');
			$('#uomId').val('');
			$('#qtyPlanned').val('');
			$('#qtyManufactured').val('');

			$('#qtyAccepted').val(null);
			$('#qtyRejected').val(null);
			$('#qtyRework').val(null);
			$('#qtyRerun').val(null);
			$('#toBeInspected').val(null);
			$('#electricalMain').val(null);
			$('#mechanicalmain').val(null);
			$('#idleTime').val(null);
			$('#setUpTime').val(null);
			$('#waitingTime').val(null);
			$('#unloadingTime').val(null);
			$('#other').val(null);
			$('#remarks').val('');

		});
	});
</script>
<script type="text/javascript">
	function AjaxForDuplicate() {
		var wipNo = $('#wipNo').val();
		//alert(wipNo);

		$
				.ajax({
					type : "POST",
					url : "checkwipAddDuplicate.mnt",
					data : "wipNo=" + wipNo,
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
		var cust = $('#wipNoEdit').val();
		var id = $('#wipIdEdit').val();
		//alert(cust);

		$
				.ajax({
					type : "POST",
					url : "checkwipUpdateDuplicate.mnt",
					data : "wipNo=" + cust + "&wipId=" + id,
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
		<div class="PageTitle">Work In Progress</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="wipEdit" items="${wipEdit}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!-- Tab-2 -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form method="get" action="wipSearch.mnt" commandName="wipCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addwipsus"
										items="${param.addwipsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.wip" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addwipFail"
										items="${param.addwipFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.wip" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updatewipssus"
										items="${param.updatewipssus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.wip" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="updatewipFail"
										items="${param.updatewipFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.wip" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="Deletewipsus"
										items="${param.Deletewipsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.wip" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeletewipFail"
										items="${param.DeletewipFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.wip" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="wipCmd.operations">
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
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<c:set var="save" value="true"></c:set>
								<c:set var="edit" value="true"></c:set>
								<c:set var="delete" value="true"></c:set>
								<c:set var="update" value="true"></c:set>
								<c:set var="search" value="true"></c:set>
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

						</table>
					</form:form>

					<c:if test="${wipList!=null }">
						<display:table name="wipList" id="wipIDList" class="table"
							requestURI="wipSearch.mnt" pagesize="5">
							<display:column property="wipId" sortable="true" title="wipId"
								media="none" />

							<display:column property="jobcardId" sortable="true"
								titleKey="label.wipjc" media="html" />

							<display:column property="workDay" sortable="true"
								titleKey="label.wipwd" media="html" />

							<display:column property="shiftId" sortable="true"
								titleKey="label.wipshift" media="html" />

							<display:column property="workcenterId" sortable="true"
								titleKey="label.wipwc" media="html" />

							<display:column property="equipmentId" sortable="true"
								titleKey="label.wipeqip" media="html" />

							<display:column property="empId" sortable="true"
								titleKey="label.wipemp" media="none" />

							<display:column property="qtyPlanned" sortable="true"
								titleKey="label.wipqtyplan" media="html" />

							<display:column property="qtyManufactured" sortable="true"
								titleKey="label.wipqtymf" media="html" />

							<display:column property="uomId" sortable="true"
								titleKey="label.wipuom" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="wipEdit.mnt?wipId=<c:out value="${wipIDList.wipId}"/> "><img
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
											href="wipDelete.mnt?wipId=<c:out value="${wipIDList.wipId}"/> "
											onclick="return confirm('Do You Want To Delete This wipord?')"><img
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
									<spring:message code="" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="wipAdd.mnt" id="addForm" method="POST"
						commandName="wipCmd">
						<table class="tableGeneral">
							<tr>
								<td><spring:message code="label.wipjc" /><span
									class="required">*</span></td>
								<td><form:select path="jobcardId" class="select"
										id="jobcardId">
										<form:option value="">-Select-</form:option>
										<form:options items="${jobCardSelect}" />
									</form:select></td>

								<td><spring:message code="label.wipwd" /><span
									class="required">*</span></td>
								<td><form:input path="workDay" class="textbox" id="workDay" /></td>
							</tr>

							<tr>

								<td><spring:message code="label.wipshift" /><span
									class="required">*</span></td>
								<td><form:select path="shiftId" class="select" id="shiftId">
										<form:option value="">-Select-</form:option>
										<form:options items="${shiftSelect}" />
									</form:select></td>

								<td><spring:message code="label.wipqtyplan" /><span
									class="required">*</span></td>
								<td><form:input path="qtyPlanned" class="textbox"
										id="qtyPlanned" maxlength="20" /></td>

							</tr>
							<tr>

								<td><spring:message code="label.wipwc" /><span
									class="required">*</span></td>
								<td><form:select path="workcenterId" class="select"
										id="workcenterId">
										<form:option value="">-Select-</form:option>
										<form:options items="${workCenterSelect}" />
									</form:select></td>
								<td><spring:message code="label.wipqtymf" /><span
									class="required">*</span></td>
								<td><form:input path="qtyManufactured" class="textbox"
										id="qtyManufactured" maxlength="20" /></td>
							</tr>
							<tr>

								<td><spring:message code="label.wipeqip" /><span
									class="required">*</span></td>
								<td><form:select path="equipmentId" class="select"
										id="equipmentId">
										<form:option value="">-Select-</form:option>
										<form:options items="${equipmentSelect}" />
									</form:select></td>

								<td><spring:message code="label.wiputime" /><span
									class="required"></span></td>
								<td><form:input path="unloadingTime" class="textbox"
										id="unloadingTime" maxlength="20" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.wipemp" /><span
									class="required">*</span></td>
								<td><form:select path="empId" class="select" id="empId">
										<form:option value="">-Select-</form:option>
										<form:options items="${empSelect}" />
									</form:select></td>

								<td><spring:message code="label.wipidletime" /><span
									class="required"></span></td>
								<td><form:input path="idleTime" class="textbox"
										id="idleTime" maxlength="20" /></td>

							</tr>
							<tr>

								<td><spring:message code="label.wipuom" /><span
									class="required">*</span></td>
								<td><form:select path="uomId" class="select" id="uomId">
										<form:option value="">-Select-</form:option>
										<form:options items="${uomSelect}" />
									</form:select></td>
								<td><spring:message code="label.wipsetuptime" /><span
									class="required"></span></td>
								<td><form:input path="setUpTime" class="textbox"
										id="setUpTime" maxlength="20" /></td>


							</tr>

							<tr>
								<td><spring:message code="label.wipwtime" /><span
									class="required"></span></td>
								<td><form:input path="waitingTime" class="textbox"
										id="waitingTime" maxlength="20" /></td>

								<td><spring:message code="label.wipother" /><span
									class="required"></span></td>
								<td><form:input path="other" class="textbox" id="other"
										maxlength="20" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.wipqtyac" /><span
									class="required"></span></td>
								<td><form:input path="qtyAccepted" class="textbox"
										id="qtyAccepted" maxlength="20" /></td>

								<td><spring:message code="label.wipqtyrej" /><span
									class="required"></span></td>
								<td><form:input path="qtyRejected" class="textbox"
										id="qtyRejected" maxlength="20" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.wipqtyrw" /><span
									class="required"></span></td>
								<td><form:input path="qtyRework" class="textbox"
										id="qtyRework" maxlength="20" /></td>

								<td><spring:message code="label.wipqtyrr" /><span
									class="required"></span></td>
								<td><form:input path="qtyRerun" class="textbox"
										id="qtyRerun" maxlength="20" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.wiptoinsp" /><span
									class="required"></span></td>
								<td><form:input path="toBeInspected" class="textbox"
										id="toBeInspected" maxlength="20" /></td>

								<td><spring:message code="label.wipelectrical" /><span
									class="required"></span></td>
								<td><form:input path="electricalMain" class="textbox"
										id="electricalMain" maxlength="20" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.wipmechanical" /><span
									class="required"></span></td>
								<td><form:input path="mechanicalmain" class="textbox"
										id="mechanicalmain" maxlength="20" /></td>

								<td><spring:message code="label.wipremarks" /><span
									class="required"></span></td>
								<td><form:input path="remarks" class="textbox" id="remarks"
										maxlength="50" /></td>

							</tr>
						</table>

						<table>
							<tr>
								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="subtnId"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="subtnId" disabled="disabled"
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

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="salesUpDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<c:forEach var="wipEdit" items="${wipEdit}">

						<form:form method="post" action="wipUpdate.mnt"
							commandName="wipCmd" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="wipId" id="wipId" />
								<tr>
									<td><spring:message code="label.wipjc" /><span
										class="required">*</span></td>
									<td><form:select path="jobcardId" class="select"
											id="jobcardId">
											<form:option value="">-Select-</form:option>
											<form:options items="${jobCardSelect}" />
										</form:select></td>

									<td><spring:message code="label.wipwd" /><span
										class="required">*</span></td>
									<td><form:input path="workDay" class="textbox"
											id="workDayEdit" /></td>
								</tr>

								<tr>

									<td><spring:message code="label.wipshift" /><span
										class="required">*</span></td>
									<td><form:select path="shiftId" class="select"
											id="shiftId">
											<form:option value="">-Select-</form:option>
											<form:options items="${shiftSelect}" />
										</form:select></td>

									<td><spring:message code="label.wipqtyplan" /><span
										class="required">*</span></td>
									<td><form:input path="qtyPlanned" class="textbox"
											id="qtyPlanned" maxlength="20" /></td>

								</tr>
								<tr>

									<td><spring:message code="label.wipwc" /><span
										class="required">*</span></td>
									<td><form:select path="workcenterId" class="select"
											id="workcenterId">
											<form:option value="">-Select-</form:option>
											<form:options items="${workCenterSelect}" />
										</form:select></td>
									<td><spring:message code="label.wipqtymf" /><span
										class="required">*</span></td>
									<td><form:input path="qtyManufactured" class="textbox"
											id="qtyManufactured" maxlength="20" /></td>
								</tr>
								<tr>

									<td><spring:message code="label.wipeqip" /><span
										class="required">*</span></td>
									<td><form:select path="equipmentId" class="select"
											id="equipmentId">
											<form:option value="">-Select-</form:option>
											<form:options items="${equipmentSelect}" />
										</form:select></td>

									<td><spring:message code="label.wiputime" /><span
										class="required"></span></td>
									<td><form:input path="unloadingTime" class="textbox"
											id="unloadingTime" maxlength="20" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.wipemp" /><span
										class="required">*</span></td>
									<td><form:select path="empId" class="select" id="empId">
											<form:option value="">-Select-</form:option>
											<form:options items="${empSelect}" />
										</form:select></td>

									<td><spring:message code="label.wipidletime" /><span
										class="required"></span></td>
									<td><form:input path="idleTime" class="textbox"
											id="idleTime" maxlength="20" /></td>

								</tr>
								<tr>

									<td><spring:message code="label.wipuom" /><span
										class="required">*</span></td>
									<td><form:select path="uomId" class="select" id="uomId">
											<form:option value="">-Select-</form:option>
											<form:options items="${uomSelect}" />
										</form:select></td>
									<td><spring:message code="label.wipsetuptime" /><span
										class="required"></span></td>
									<td><form:input path="setUpTime" class="textbox"
											id="setUpTime" maxlength="20" /></td>


								</tr>

								<tr>
									<td><spring:message code="label.wipwtime" /><span
										class="required"></span></td>
									<td><form:input path="waitingTime" class="textbox"
											id="waitingTime" maxlength="20" /></td>

									<td><spring:message code="label.wipother" /><span
										class="required"></span></td>
									<td><form:input path="other" class="textbox" id="other"
											maxlength="20" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.wipqtyac" /><span
										class="required"></span></td>
									<td><form:input path="qtyAccepted" class="textbox"
											id="qtyAccepted" maxlength="20" /></td>

									<td><spring:message code="label.wipqtyrej" /><span
										class="required"></span></td>
									<td><form:input path="qtyRejected" class="textbox"
											id="qtyRejected" maxlength="20" /></td>



								</tr>
								<tr>
									<td><spring:message code="label.wipqtyrw" /><span
										class="required"></span></td>
									<td><form:input path="qtyRework" class="textbox"
											id="qtyRework" maxlength="20" /></td>

									<td><spring:message code="label.wipqtyrr" /><span
										class="required"></span></td>
									<td><form:input path="qtyRerun" class="textbox"
											id="qtyRerun" maxlength="20" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.wiptoinsp" /><span
										class="required"></span></td>
									<td><form:input path="toBeInspected" class="textbox"
											id="toBeInspected" maxlength="20" /></td>

									<td><spring:message code="label.wipelectrical" /><span
										class="required"></span></td>
									<td><form:input path="electricalMain" class="textbox"
											id="electricalMain" maxlength="20" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.wipmechanical" /><span
										class="required"></span></td>
									<td><form:input path="mechanicalmain" class="textbox"
											id="mechanicalmain" maxlength="20" /></td>

									<td><spring:message code="label.wipremarks" /><span
										class="required"></span></td>
									<td><form:input path="remarks" class="textbox"
											id="remarks" maxlength="50" /></td>

								</tr>

							</table>

							<table>

								<tr>

									<c:choose>

										<c:when test="${update}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updated" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updated" /></td>
										</c:otherwise>
									</c:choose>

								</tr>
							</table>

						</form:form>
					</c:forEach>

				</div>
			</div>

		</div>

	</div>
</body>
</html>
