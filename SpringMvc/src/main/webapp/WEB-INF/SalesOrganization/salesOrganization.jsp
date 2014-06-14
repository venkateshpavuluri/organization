<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author Srinivas
 @version 1.0    -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						jQuery.validator
								.addMethod(
										"alphabets",
										function(value, element) {
											return this.optional(element)
													|| /^[A-Za-z][A-Za-z0-9!@#$%^&*()_+:;?><~ ]*$/
															.test(value);
										});

						jQuery.validator
								.addMethod(
										"alphanumeric",
										function(value, element) {
											return this.optional(element)
													|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+:;?><~ ]*$/
															.test(value);
										});

						jQuery.validator.addMethod("specialcharacters",
								function(value, element) {
									return this.optional(element)
											|| /^[0-9a-zA-Z&_ ]+$/.test(value);
								});
						//AddForm Validations
						$('#sumnid')
								.click(
										function(event) {

											$('#addSalesorgform')
													.validate(
															{
																rules : {
																	salesorganization : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	orgId : {
																		required : true
																	}

																},
																messages : {
																	salesorganization : {
																		required : "<font style='color: red;'><b>Sales Organization is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	orgId : "<font style='color: red;'><b>Orgnaization Name is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {

											$('#editsalesorgForm')
													.validate(
															{
																rules : {
																	esalesorganization : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	eorgId : {
																		required : true
																	},

																},
																messages : {
																	esalesorganization : {
																		required : "<font style='color: red;'><b>Sales Organization is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	eorgId : "<font style='color: red;'><b>Orgnaization Name is Required</b></font>"
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
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("sohide").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));
			$('#tabs').tabs({
				active : index
			});
		}

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

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">
			<spring:message code="label.salesorgnaization" />
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
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
					<form:form action="searchSalesOrganization.mnt" method="GET"
						commandName="SalesOrganization">
						<table class="tableGeneral">

							<tr>
								<td colspan="3"><c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.salesorgnaization" />
											<spring:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:forEach var="fail" items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.salesorgnaization" />
											<spring:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach var="SalesOrganizationDelete"
										items="${SalesOrganizationDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.salesorgnaization" />
											<spring:message code="label.deleteSuccess" />

										</div>
									</c:forEach> <c:forEach var="salesOrgDelErr" items="${salesOrgDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.salesorgnaization" />
											<spring:message code="label.deleteFail" />

										</div>
									</c:forEach> <c:forEach var="SalesOrganizationUpdate"
										items="${SalesOrganizationUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.salesorgnaization" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach var="salesOrgErr" items="${salesOrgErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.salesorgnaization" />
											<spring:message code="label.updateFail" />

										</div>
									</c:forEach></td>
							</tr>

							<%-- <tr>
								<td colspan="2"><c:forEach var="SalesOrganizationUpdate"
										items="${SalesOrganizationUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>$uccess : </strong>
											<c:out value="${SalesOrganizationUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr> --%>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="SalesOrganization.operations">
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
										<c:when test="${privileges eq messageup}">
											<c:set var="update" value="true"></c:set>
										</c:when>
									</c:choose>
								</c:forEach>

								<c:choose>
									<c:when test="${search }">
										<td><input type="submit"
											value="<spring:message code='label.search'/>"
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

					<c:if test="${sobeans!=null}">
						<display:table id="soid" name="sobeans"
							requestURI="searchSalesOrganization.mnt" pagesize="5"
							class="table">
							<display:column property="salesorgId" title="SalesOrganizationID"
								media="none" sortable="true"></display:column>
							<display:column property="salesorganization"
								titleKey="label.salesorgnaization" media="html" sortable="true"></display:column>
							<display:column property="organizationname"
								titleKey="label.sorgname" media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit }">
										<a
											href="SalesOrgEdit.mnt?soedit=<c:out value="${soid.salesorgId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete }">

										<a
											href="soDelete.mnt?sdelete=<c:out value="${soid.salesorgId}"/>"
											style="color: red"><img src="images/Delete.jpg"
											width="20px" height="20px"
											onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
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

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="saveSalesOrg.mnt" method="POST"
						commandName="SalesOrganization" id="addSalesorgform">
						<table class="tableGeneral">
							<form:hidden path="sohide" />
							<tr>
								<td colspan="2"><c:forEach var="salesOrgDup"
										items="${salesOrgDup}">
										<div class="alert-warning" id="successmessage">
											<strong><spring:message code="label.warning" /> </strong>
											<spring:message code="label.salesorgnaization" />
											<spring:message code="label.duplicateCheck" />

										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td><spring:message code="label.salesorgnaization" /><span
									class="required">*</span> <form:input path="salesorganization"
										class="textbox" maxlength="50" /></td>


							</tr>
							<tr>
								<td><spring:message code="label.organizationName" /><span
									class="required">*</span> <form:select path="orgId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${OrgSearch}" />
									</form:select></td>
							</tr>

							<tr>

								<td><c:choose>
										<c:when test="${save}">
											<input type="submit" id="sumnid"
												value='<spring:message code="label.save"/>'
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="sumnid" disabled="disabled"
												value='<spring:message code="label.save"/>'
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose><input type="reset"
									value='<spring:message code="label.reset"/>'
									class="btn btn-primary" /></td>
							</tr>

							<%-- <tr>
								<td colspan="2"><input type="submit" value="<spring:message code="label.save" />"
									class="btn btn-primary" id="sumbnid"/><input
										type="reset" value="<spring:message code="label.reset" />" class="btn btn-primary"/></td>
							</tr> --%>
						</table>
					</form:form>


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="SalesOrganizationEditValues" items="${editvalues }">
						<form:form action="SalesOrganizationUpdate.mnt" method="POST"
							commandName="SalesOrganization" id="editsalesorgForm">
							<table class="tableGeneral">
								<form:hidden path="sohideedit" />
								<form:hidden path="esalesorgId" />
								<tr>
									<td colspan="2"><c:forEach var="salesOrgupdatedup"
											items="${salesOrgupdatedup}">

											<div class="alert-warning">
												<strong> <spring:message code="label.warning" /></strong>
												<spring:message code="label.salesorgnaization" />
												<spring:message code="label.duplicateCheck" />
											</div>
										</c:forEach></td>
								</tr>

								<tr>
									<td><spring:message code="label.salesorgnaization" /><span
										class="required">*</span> <form:input
											path="esalesorganization" class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.organizationName" /><span
										class="required">*</span> <form:select path="eorgId"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:option value="0" class="select">All</form:option>
											<form:options items="${OrgSearch}" />
										</form:select></td>
								</tr>

								<tr>
									<c:choose>
										<c:when test="${update }">
											<td colspan="2"><input type="submit"
												value="<spring:message code="label.update" />"
												class="btn btn-primary" id="updated" /></td>
										</c:when>
										<c:otherwise>
											<td><input type="submit"
												value="<s:message code="label.update"/> "
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




