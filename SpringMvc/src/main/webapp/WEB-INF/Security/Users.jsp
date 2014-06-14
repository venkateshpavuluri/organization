<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="/resources/demos/style.css" />

<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
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
	$(document)
			.ready(
					function() {
						$('#' + "sumbnid")
								.click(
										function(event) {
											//alert($('#privilege').val());
											$("#addUserForm")
													.validate(
															{

																rules : {
																	userName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	password : {
																		required : true,
																		minlength : 5
																	},
																	IsActive : {
																		required : true
																	},
																	roleName : {
																		required : true
																	},
																	usergroupId : {
																		required : true
																	},
																	functionId : {
																		required : true
																	},
																	organizationId : {
																		required : true
																	},
																	validFrom : {
																		required : true
																	},
																	validTo : {
																		required : true
																	}
																},
																messages : {
																	userName : {
																		required : "<font style='color:red;'><b>User Name is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},
																	password : "<font style='color: red;'><b>Password is Required and should be atleast 5 characters</b></font>",
																	IsActive : "<font style='color: red;'><b>Status should be active</b></font>",
																	roleName : "<font style='color: red;'><b>Please select atleast one Role Name</b></font>",
																	usergroupId : "<font style='color: red;'><b>Please select User Group</b></font>",
																	functionId : "<font style='color: red;'><b>Please select Function</b></font>",
																	organizationId : "<font style='color: red;'><b>Please select Organization</b></font>",
																	validFrom : "<font style='color: red;'><b>Please select Valid From</b></font>",
																	validTo : "<font style='color: red;'><b>Please select Valid To</b></font>"
																},

															});
										});

						$('#updbut')
								.click(
										function(event) {

											$("#updateUserForm")
													.validate(
															{
																rules : {
																	userNameEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	passwordEdit : {
																		required : true,
																		minlength : 5
																	},
																	IsActiveEdit : {
																		required : true
																	},
																	roleNameEdit : {
																		required : true
																	},
																	usergroupIdEdit : {
																		required : true
																	},
																	functionIdEdit : {
																		required : true
																	},
																	organizationIdEdit : {
																		required : true
																	},
																	validFromEdit : {
																		required : true
																	},
																	validToEdit : {
																		required : true
																	}
																},
																messages : {
																	userNameEdit : {
																		required : "<font style='color:red;'><b>User Name is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},
																	passwordEdit : "<font style='color: red;'><b>Password is Required and should be atleast 5 characters</b></font>",
																	IsActiveEdit : "<font style='color: red;'><b>Please select Status</b></font>",
																	roleNameEdit : "<font style='color: red;'><b>Please select atleast one Role Name</b></font>",
																	usergroupIdEdit : "<font style='color: red;'><b>Please select User Group</b></font>",
																	functionIdEdit : "<font style='color: red;'><b>Please select Function</b></font>",
																	organizationIdEdit : "<font style='color: red;'><b>Please select Organization</b></font>",
																	validFromEdit : "<font style='color: red;'><b>Please select Valid From</b></font>",
																	validToEdit : "<font style='color: red;'><b>Please select Valid To</b></font>"

																},

															});
										});

					});
</script>
<script>
	$(function() {
		$("#validFrom,#validTo,#validFromEdit,#validToEdit").datepicker();

	});
</script>
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
		<div class="PageTitle">
			<s:message code="label.user" />
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="usersValues" items="${usersValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit"></s:message> </a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>

			<!---================================ Search tab =======================================-->
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="usersSearch.mnt" method="get"
						commandName="usersAdd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong> <s:message code="label.success" /></strong>
											<s:message code="label.User" />
											<s:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong> <s:message code="label.error" /></strong>
											<s:message code="label.User" />
											<s:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${usersUpadteSuccess}">
										<div class="alert-success">
											<strong> <s:message code="label.success" /></strong>
											<s:message code="label.User" />
											<s:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${usersUpadteFail}">
										<div class="alert-danger">
											<strong><s:message code="label.error" /> </strong>
											<s:message code="label.User" />
											<s:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<c:forEach items="${usersDeleteSuccess}">
								<div class="alert-success">
									<strong> <s:message code="label.success" /></strong>
									<s:message code="label.User" />
									<s:message code="label.deleteSuccess" />
								</div>
							</c:forEach>
							<c:forEach items="${usersDeleteFail}">
								<div class="alert-danger">
									<strong><s:message code="label.error" /> </strong>
									<s:message code="label.User" />
									<s:message code="label.deleteFail" />
								</div>
							</c:forEach>

							<%-- <tr><td>users</td><td><form:select path="userNameSearch" class="select">
										<form:option value="all">--Select--</form:option>
										<form:options items="${usersSearchNames}" /></form:select></td><td><input type="submit" value="Search" class="btn btn-primary"/></td></tr>  --%>

							<tr>
								<td><s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />

									</form:select> <s:bind path="usersAdd.operations">
										<select class="select" name="operations">
											<option value="<s:message code='assignedOperator'/>">
												<s:message code="label.equalsTo" />
											</option>
											<option value="<s:message code='notequalsOperator'/>">
												<s:message code="label.notEqualsTo" />
											</option>
											<option value="<s:message code='beginsWithOperator'/>">
												<s:message code="label.beginsWith" />
											</option>
											<option value="<s:message code='endsWithOperator'/>">
												<s:message code="label.endsWith" />
											</option>
											<option value="<s:message code='containsOperator'/>">
												<s:message code="label.contains" />
											</option>
										</select>
									</s:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
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
											<input type="submit" value="<s:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<s:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>
						</table>
					</form:form>

					<c:if test="${usersSearch!=null}">
						<display:table id="usersRow" name="usersSearch"
							requestURI="usersSearch.mnt" pagesize="5" class="table">

							<display:column property="userName" title="User Name"
								media="html" sortable="true"></display:column>
							<%--  <display:column property="IsActive" title="Is Active"  media="html" sortable="true"  /> --%>
							<display:column property="roleDisplay" title="Roles" media="html"
								sortable="true" />
							<display:column property="usergroupName" title="User Group"
								media="html" sortable="true"></display:column>
							<display:column property="functionName" title="Function"
								media="html" sortable="true"></display:column>
							<display:column property="organizationName" title="Organization"
								media="html" sortable="true"></display:column>
							<display:column property="validFrom" title="Valid From"
								media="html" sortable="true"></display:column>
							<display:column property="validTo" title="Valid To" media="html"
								sortable="true"></display:column>
							<display:column property="theme" title="Theme" media="html"
								sortable="true"></display:column>
							

							<display:column title="Edit" style="color:white">
								<c:choose>
									<c:when test="${edit }">
										<a
											href="usersEditHome.mnt?usersDetEdit=<c:out value="${usersRow.user_Id}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px" height="20px"
											class="btn btn-danger" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column title="Delete">
								<c:choose>
									<c:when test="${delete}">

									<a
											href="usersDelete.mnt?usersidDelete=<c:out value="${usersRow.user_Id}"/>"
											style="color: red"
											onclick="return confirm('Do u want to delete the Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" width="20px" height="20px"
											class="btn btn-danger" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>
					</c:if>

				</div>
			</div>

			<!---================================ Add tab =======================================-->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">


					<form:form action="usersAdd.mnt" method="GET"
						commandName="usersAdd" id="addUserForm">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${UsersDuplicate }">
										<div class="alert-warning">
											<strong><s:message code="label.warning" /></strong>
											<s:message code="label.userName" />
											<s:message code="label.duplicateCheck" />
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="user_Id" />
							<form:hidden path="aid" />

							<tr>
								<td>User Name<span class="required">*</span></td>
								<td><form:input path="userName" id="userName"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Password<span class="required">*</span></td>
								<td><form:password path="password" id="password"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Status<span class="required">*</span></td>
								<td><form:select path="IsActive" id="IsActive"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:option value="1">Active</form:option>
										<form:option value="0">In Active</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td>Role Name<span class="required">*</span></td>
								<td><form:select path="roleName" multiple="true"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${RolesSearchIds}" />
									</form:select></td>
							</tr>

							<tr>
								<td>User Group<span class="required">*</span></td>
								<td><form:select path="usergroupId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${UsersGroupSearchIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td>Function<span class="required">*</span></td>
								<td><form:select path="functionId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${FunctionSearchIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td>Organization<span class="required">*</span></td>
								<td><form:checkboxes cssClass="checkbox"
										items="${OrganizationSearchIds}" path="organizationId"
										element="ul" /></td>
							</tr>
							<tr>
								<td>Valid From<span class="required">*</span></td>
								<td><form:input path="validFrom" id="validFrom"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Valid To<span class="required">*</span></td>
								<td><form:input path="validTo" id="validTo" class="textbox" /></td>
							</tr>
							 <tr>
								<td><s:message code="label.theme" /><span
									class="required">*</span></td>
									<td><form:select path="theme" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${themeIds}" />
								</form:select></td>
								</tr>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save}">
											<input type="submit" value="Save" class="btn btn-primary"
												id="sumbnid" />
										</c:when>
										<c:otherwise>
											<input type="submit" value="Save" class="btn btn-danger"
												disabled="disabled" id="sumbnid" />
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

					<c:forEach var="usersEditValues" items="${usersValues }">
						<form:form action="usersUpdate.mnt" method="POST"
							commandName="usersAdd" id="updateUserForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${usersEditDuplicate }">
											<div class="alert-warning">
												<strong><s:message code="label.warning" /></strong>
												<s:message code="label.userName" />
												<s:message code="label.duplicateCheck" />
											</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="user_IdEdit" />
								<form:hidden path="aid" />
								<tr>
									<td>User Name<span class="required">*</span></td>
									<td><form:input path="userNameEdit" id="userName"
											class="textbox" /></td>
								</tr>
								 <form:hidden path="passwordEdit" /> 
								<tr>
									<td>Password<span class="required">*</span></td>
									<td><form:password path="passwordEdit" id="passwordEdit"
											showPassword="true" class="textbox" /></td>
								</tr>
								<tr>
									<td>Status<span class="required">*</span></td>
									<td><form:select path="IsActiveEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:option value="1">Active</form:option>
											<form:option value="0">In Active</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>Role Name<span class="required">*</span></td>
									<td><form:select path="roleNameEdit" multiple="true"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${RolesSearchIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td>User Group<span class="required">*</span></td>
									<td><form:select path="usergroupIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${UsersGroupSearchIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td>Function<span class="required">*</span></td>
									<td><form:select path="functionIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${FunctionSearchIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td>Organization<span class="required">*</span></td>
									<td><form:checkboxes cssClass="checkbox" element="ul"
											items="${OrganizationSearchIds}" path="organizationIdEdit" />
									</td>
								</tr>
								<tr>
									<td>Valid From<span class="required">*</span></td>
									<td><form:input path="validFromEdit" id="validFromEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Valid To<span class="required">*</span></td>
									<td><form:input path="validToEdit" id="validToEdit"
											class="textbox" /></td>
								</tr>
								
                           <tr>
								<td><s:message code="label.theme" /><span
									class="required">*</span></td>
									<td><form:select path="themeEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${themeIds}" />
								</form:select></td>
								</tr>
								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${update }">
												<input type="submit" value="Update" class="btn btn-primary"
													id="updbut" />
											</c:when>
											<c:otherwise>
												<input type="submit" value="Update" class="btn btn-danger"
													disabled="disabled" id="updbut" />
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




