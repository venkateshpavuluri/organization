<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
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
<script type="text/javascript" src="js/MntValidator.js"></script>

<script>
	$(function() {
		$("#tabs").tabs();
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
	$(document)
			.ready(
					function() {
						$('#' + "sumbnid")
								.click(
										function(event) {
											//alert($('#privilege').val());
											$("#addRoleForm")
													.validate(
															{

																rules : {
																	role : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},

																},
																messages : {
																	role : {
																		required : "<font style='color: red;'><b> Role is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	}
																},

															});
										});

						$('#updbut')
								.click(
										function(event) {

											$("#updateRoleForm")
													.validate(
															{
																rules : {
																	roleEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	roleEdit : {
																		required : "<font style='color: red;'><b> Role is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"

																	}
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

		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Role</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="roleValues" items="${roleValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!---================================ Search tab =======================================-->
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="roleSearch.mnt" method="get"
						commandName="roleAdd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.roles" />
											<spring:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.roles" />
											<spring:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach var="roleUpadted" items="${roleUpadteSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.roles" />
											<spring:message code="label.updateSuccess" />

										</div>
									</c:forEach> <c:forEach items="${roleUpadteFail}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.roles" />
											<spring:message code="label.updateFail" />

										</div>
									</c:forEach> <c:forEach items="${roleDeleteSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.roles" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${roleDeleteFail}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.roles" />
											<spring:message code="label.deleteFail" />

										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>

								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="roleAdd.operations">
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
										<c:when test="${search }">
											<input type="submit" value="Search" class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" value="Search" disabled="disabled"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>

					<c:if test="${roleSearch!=null}">
						<display:table id="roleRow" name="roleSearch"
							requestURI="roleSearch.mnt" pagesize="5" class="table">

							<display:column property="role" titleKey="label.role"
								media="html" sortable="true"></display:column>

							<display:column property="adgroup" titleKey="label.adgroup"
								media="html" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="roleEditHome.mnt?roleDetEdit=<c:out value="${roleRow.roleid}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a> <img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" />
										</a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete }">

										<a
											href="roleDelete.mnt?roleidDelete=<c:out value="${roleRow.roleid}"/>"
											style="color: red"
											onclick="return confirm('Do u want to delete the Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a> <img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" />
										</a>
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


			<!---================================ Add tab =======================================-->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="roleAdd.mnt" method="GET" commandName="roleAdd"
						id="addRoleForm" onsubmit="return validateForm()">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${RoleDuplicate }">
										<div class="alert-warning">
											<strong><spring:message code="label.warning" /> </strong>
											<spring:message code="label.role" />
											<spring:message code="label.duplicateCheck" />

										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="roleid" />

							<tr>
								<td><spring:message code="label.role" /><span
									class="required">*</span></td>
								<td><form:input path="role" id="role" class="textbox"
										maxlength="50" /></td>
							</tr>

							<form:hidden path="aid" />
							<tr>
								<td><spring:message code="label.adgroup" /></td>
								<td><form:input path="adgroup" id="adgroup" class="textbox"
										maxlength="50" /></td>
							</tr>

							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save}">
											<input type="submit" value="Save" class="btn btn-primary"
												id="sumbnid" />
										</c:when>
										<c:otherwise>
											<input type="submit" value="Save" disabled="disabled"
												class="btn btn-danger" id="sumbnid" />
										</c:otherwise>
									</c:choose><input type="reset" class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="roleEditValues" items="${roleValues }">
						<form:form action="roleUpdate.mnt" method="POST"
							commandName="roleAdd" id="updateRoleForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${roleEditDuplicate }">
											<div class="alert-warning">
												<strong><spring:message code="label.warning" /> </strong>
												<spring:message code="label.role" />
												<spring:message code="label.duplicateCheck" />

											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="roleUpadted"
											items="${roleUpadte}">
											<div class="alert-warning" id="successmessage">
												<c:out value="${roleUpadted}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="roleidEdit" />

								<tr>
									<td><spring:message code="label.role" /><span
										class="required">*</span></td>
									<td><form:input path="roleEdit" id="role" class="textbox"
											maxlength="50" /></td>
								</tr>

								<tr>
									<td><spring:message code="label.adgroup" /></td>
									<td><form:input path="adgroupEdit" id="adgroup"
											class="textbox" maxlength="50" /></td>
								</tr>

								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${update }">
												<input type="submit" value="Update" class="btn btn-primary"
													id="updbut" />
											</c:when>
											<c:otherwise>
												<input type="submit" value="Update" disabled="disabled"
													class="btn btn-danger" id="updbut" />
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




