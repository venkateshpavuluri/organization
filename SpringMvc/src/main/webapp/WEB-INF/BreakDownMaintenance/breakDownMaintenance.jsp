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
<title>My JSP 'breakDown.jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
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
		$('#recordedDT,#recordedDTEdit').datepicker({
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
																	breakDownNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	department_Id : {
																		required : true
																	},
																	problem : {
																		required : true
																	},
																	equipment_Id : {
																		required : true

																	},
																	recordedDT : {
																		required : true
																	},
																	maintenanceProblemType_Id : {
																		required : true
																	},
																	status_Id : {
																		required : true
																	}

																},
																/*  errorPlacement :function(error){
																	return false;
																}, */
																messages : {
																	breakDownNo : {
																		required:"<font style='color: red;'><b>Break Down Maintenance No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	department_Id : {
																		required : "<font style='color: red;'><b>Department is Required</b></font>",
																	},
																	problem : "<font style='color: red;'><b>Problem is Required</b></font>",
																	equipment_Id : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	recordedDT : "<font style='color: red;'><b>Recorded Date is Required</b></font>",
																	maintenanceProblemType_Id : "<font style='color: red;'><b>Maintenance Problem Type is Required</b></font>",
																	status_Id : "<font style='color: red;'><b>Status is Required</b></font>"

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
																	breakDownNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	department_Id : {
																		required : true
																	},
																	problem : {
																		required : true
																	},
																	equipment_Id : {
																		required : true

																	},
																	recordedDT : {
																		required : true
																	},
																	maintenanceProblemType_Id : {
																		required : true
																	},
																	status_Id : {
																		required : true
																	}

																},
																/*  errorPlacement :function(error){
																	return false;
																}, */
																messages : {
																	breakDownNo : {
																		required:"<font style='color: red;'><b>Break Down Maintenance No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	department_Id : {
																		required : "<font style='color: red;'><b>Department is Required</b></font>",
																	},
																	problem : "<font style='color: red;'><b>Problem is Required</b></font>",
																	equipment_Id : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	recordedDT : "<font style='color: red;'><b>Recorded Date is Required</b></font>",
																	maintenanceProblemType_Id : "<font style='color: red;'><b>Maintenance Problem Type is Required</b></font>",
																	status_Id : "<font style='color: red;'><b>Status is Required</b></font>"
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
			$('#breakDownNo').val('');
			$('#department_Id').val('');
			$('#equipment_Id').val('');
			$('#problem').val('');
			$('#recordedDT').val('');
			$('#maintenanceProblemType_Id').val('');
			$('#status_Id').val('');

		});
	});
</script>
<script type="text/javascript">
	function AjaxForDuplicate() {
		var recNo = $('#breakDownNo').val();
		alert(recNo);

		$
				.ajax({
					type : "POST",
					url : "checkbreakDownAddDuplicate.mnt",
					data : "breakDownNo=" + recNo,
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
		var cust = $('#breakDownNoEdit').val();
		var id = $('#breakdownMaintenace_Id').val();
		alert(cust);

		$
				.ajax({
					type : "POST",
					url : "checkbreakDownUpdateDuplicate.mnt",
					data : "breakDownNo=" + cust + "&breakDownId=" + id,
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
		<div class="PageTitle">Break Down Maintenance</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="breakDownEdit" items="${breakDownEdit}">
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
					<form:form method="get" action="breakDownSearch.mnt"
						commandName="breakDownCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addRecsus"
										items="${param.addRecsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.bdm" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addRecFail"
										items="${param.addRecFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.bdm" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateRecssus"
										items="${param.updateRecssus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.bdm" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="updateRecFail"
										items="${param.updateRecFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.bdm" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteRecsus"
										items="${param.DeleteRecsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.bdm" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteRecFail"
										items="${param.DeleteRecFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.bdm" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="breakDownCmd.operations">
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

					<c:if test="${breakDownList!=null }">
						<display:table name="breakDownList" id="breakDownIDList"
							class="table" requestURI="breakDownSearch.mnt" pagesize="5">
							<display:column property="breakdownMaintenace_Id" sortable="true"
								title="breakdownMaintenace_Id" media="none" />
								
								<display:column property="breakDownNo" sortable="true"
								titleKey="label.bdownno" media="html" />

							<display:column property="department_Id" sortable="true"
								titleKey="label.bddept" media="html" />

							<display:column property="equipment_Id" sortable="true"
								titleKey="label.bdequip" media="html" />

							<display:column property="problem" sortable="true"
								titleKey="label.bdprob" media="html" />

							<display:column property="recordedDT" sortable="true"
								titleKey="label.bdrecdate" media="html" />

							<display:column property="maintenanceProblemType_Id"
								sortable="true" titleKey="label.bdmptype" media="html" />

							<display:column property="status_Id" sortable="true"
								titleKey="label.bdstatus" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="breakDownEdit.mnt?breakDownId=<c:out value="${breakDownIDList.breakdownMaintenace_Id}"/> "><img
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
											href="breakDownDelete.mnt?breakDownId=<c:out value="${breakDownIDList.breakdownMaintenace_Id}"/> "
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
									<spring:message code="label.bdownno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="breakDownAdd.mnt" id="addForm" method="POST"
						commandName="breakDownCmd">
						<table class="tableGeneral">
							<tr>
								<td><spring:message code="label.bdownno" /><span
									class="required">*</span></td>
								<td><form:input path="breakDownNo" class="textbox"
										id="breakDownNo" maxlength="50" onkeyup="AjaxForDuplicate()"/></td>
							</tr>

							<tr>

								<td><spring:message code="label.bddept" /><span
									class="required">*</span></td>
								<td><form:select path="department_Id" class="select"
										id="department_Id">
										<form:option value="">-Select-</form:option>
										<form:options items="${deptSelect}" />
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.bdprob" /><span
									class="required">*</span></td>
								<td><form:input path="problem" class="textbox" id="problem"
										maxlength="50" /></td>
							</tr>

							<tr>
								<td><spring:message code="label.bdrecdate" /><span
									class="required">*</span></td>
								<td><form:input path="recordedDT" class="textbox"
										id="recordedDT" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.bdequip" /><span
									class="required">*</span></td>
								<td><form:select path="equipment_Id" class="select"
										id="equipment_Id">
										<form:option value="">-Select-</form:option>
										<form:options items="${equipmentSelect}" />
									</form:select></td>

							</tr>
							<tr>

								<td><spring:message code="label.bdmptype" /><span
									class="required">*</span></td>
								<td><form:select path="maintenanceProblemType_Id"
										class="select" id="maintenanceProblemType_Id">
										<form:option value="">-Select-</form:option>
										<form:options items="${maintenanceSelect}" />
									</form:select></td>

							</tr>

							<tr>

								<td><spring:message code="label.bdstatus" /><span
									class="required">*</span></td>
								<td><form:select path="status_Id" class="select"
										id="status_Id">
										<form:option value="">-Select-</form:option>
										<form:options items="${statusSelect}" />
									</form:select></td>

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
									<spring:message code="label.bdownno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<c:forEach var="breakDownEdit" items="${breakDownEdit}">

						<form:form method="post" action="breakDownUpdate.mnt"
							commandName="breakDownCmd" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="breakdownMaintenace_Id"
									id="breakdownMaintenace_Id" />

								<tr>
									<td><spring:message code="label.bdownno" /><span
										class="required">*</span></td>
									<td><form:input path="breakDownNo" class="textbox"
											id="breakDownNoEdit" maxlength="50" onkeyup="AjaxUpdateDuplicate"/></td>
								</tr>

								<tr>

									<td><spring:message code="label.bddept" /><span
										class="required">*</span></td>
									<td><form:select path="department_Id" class="select"
											id="department_Id">
											<form:option value="">-Select-</form:option>
											<form:options items="${deptSelect}" />
										</form:select></td>
								</tr>

								<tr>
									<td><spring:message code="label.bdprob" /><span
										class="required">*</span></td>
									<td><form:input path="problem" class="textbox"
											id="problem" maxlength="50" /></td>
								</tr>

								<tr>
									<td><spring:message code="label.bdrecdate" /><span
										class="required">*</span></td>
									<td><form:input path="recordedDT" class="textbox"
											id="recordedDTEdit" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.bdequip" /><span
										class="required">*</span></td>
									<td><form:select path="equipment_Id" class="select"
											id="equipment_Id">
											<form:option value="">-Select-</form:option>
											<form:options items="${equipmentSelect}" />
										</form:select></td>

								</tr>
								<tr>

									<td><spring:message code="label.bdmptype" /><span
										class="required">*</span></td>
									<td><form:select path="maintenanceProblemType_Id"
											class="select" id="maintenanceProblemType_Id">
											<form:option value="">-Select-</form:option>
											<form:options items="${maintenanceSelect}" />
										</form:select></td>

								</tr>

								<tr>

									<td><spring:message code="label.bdstatus" /><span
										class="required">*</span></td>
									<td><form:select path="status_Id" class="select"
											id="status_Id">
											<form:option value="">-Select-</form:option>
											<form:options items="${statusSelect}" />
										</form:select></td>

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
