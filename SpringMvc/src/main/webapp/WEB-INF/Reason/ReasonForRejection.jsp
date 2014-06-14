<!-- @author Sailajach -->
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
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

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
																	reasonForRejection : {
																		required : true
																	},
																},
																messages : {
																	reasonForRejection : "<font style='color: red;'><b>Reason For Rejection is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											var rfredit = $(
													'#reasonForRejectionIdEditt')
													.val();

											$('#editForm')
													.validate(
															{
																rules : {
																	reasonForRejectionEditt : {
																		required : true
																	},

																},
																messages : {
																	reasonForRejectionEditt : "<font style='color: red;'><b>Reason For Rejection is Required</b></font>"
																},
															});

										});

					});
</script>
<script>
	$(function() {
		$("#tabs").tabs();

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#search,#add').click(function(e) {
			$('#edit').hide();
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
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Reason For Rejection</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="rfrValues" items="${list}">
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

					<form:form action="rfrSearch.mnt" method="GET"
						commandName="rfrCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.reasonForRejection" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.reasonForRejection" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${rfrUpadte}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.reasonForRejection" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${rfrDelete}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.reasonForRejection" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${rfrUpadteError}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.reasonForRejection" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${rfrDeleteError}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.reasonForRejection" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="rfrCommand.operations">
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
										<c:when test="${search}">
											<input type="submit"
												value="<spring:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit"
												value="<spring:message code="label.search"/>"
												disabled="disabled" class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>
					
					<c:if test="${rfrSearch!=null}">
						<display:table id="rfrValue" name="rfrSearch"
							requestURI="rfrSearch.mnt" pagesize="5" class="table">

							<display:column property="reasonForRejection"
								titleKey="label.reasonForRejection" media="html" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit }">

										<a
											href="reasonForRejectionIdEdit.mnt?reasonForRejectionIdEdit=<c:out value="${rfrValue.reasonForRejectionId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete }">
										<a
											href="reasonForRejectionIdDelete.mnt?reasonForRejectionIdDelete=<c:out value="${rfrValue.reasonForRejectionId}"/>"
											style="color: red"
											onclick="return confirm('Do u want to delete the Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" />
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
							<display:setProperty name="paging.banner.group_size" value="3" />
							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />

						</display:table>

					</c:if>
					

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="RFRejection.mnt" method="POST"
						commandName="rfrCommand" id="addForm">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach var="addRFRDuplicate"
										items="${addRFRDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning" /> </strong>
											<spring:message code="label.reasonForRejection" />
											<spring:message code="label.duplicateCheck" />

										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.reasonForRejection" /><font
									color="red">*</font></td>
								<td><form:textarea path="reasonForRejection"
										id="reasonForRejection" class="textarea" maxlength="250" /></td>
							</tr>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save }">
											<input type="submit"
												value="<spring:message code="label.save"/>" id="subtnId"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.save"/>" id="subtnId"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>



				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="rfrValues" items="${list}">
						<form:form action="rfrEdit.mnt" method="POST"
							commandName="rfrCommand" id="editForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="addRFRDuplicate"
											items="${addRFRDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning" /> </strong>
												<spring:message code="label.reasonForRejection" />
												<spring:message code="label.duplicateCheck" />
											</div>
										</c:forEach></td>
								</tr>


								<form:hidden path="reasonForRejectionIdEditt" />
								<tr>
									<td><spring:message code="label.reasonForRejection" /><font
										color="red">*</font></td>
									<td><form:textarea path="reasonForRejectionEditt"
											id="reasonForRejectionEditt" class="textarea" maxlength="250" /></td>
								</tr>

								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${delete}">
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updated" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<spring:message code="label.update"/>"
													class="btn btn-danger" id="updated" />
											</c:otherwise>
										</c:choose></td>
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
