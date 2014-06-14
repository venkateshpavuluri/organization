
<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 18-09-2013 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="/resources/demos/style.css" />

<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>

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

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

		});
	});
</script>

<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumbnid')
								.click(
										function(event) {

											$("#organizationAdd")
													.validate(
															{
																rules : {
																	orgName : {
																		required : true
																	},
																	add1 : {
																		required : true
																	},
																	city : {
																		required : true
																	},
																	state : {
																		required : true
																	},
																	phone : {
																		required : true
																	},

																	email : {
																		required : true
																	}

																},
																messages : {
																	orgName : "<font style='color: red;'><b>Organization Name is Required</b></font>",
																	add1 : "<font style='color: red;'><b>Address1 is Required</b></font>",
																	city : "<font style='color: red;'><b>City is Required</b></font>",
																	state : "<font style='color: red;'><b>State is Required</b></font>",
																	countryId : "<font style='color: red;'><b>Country is Required</b></font>",
																	phone : "<font style='color: red;'><b>Phone Number is Required</b></font>",
																	email : "<font style='color: red;'><b>Email is Required</b></font>"

																},

															});
										});

						$('#updateId')
								.click(
										function(event) {

											$("#orgUpForm")
													.validate(
															{
																rules : {
																	orgNameEdit : {
																		required : true
																	},
																	add1Edit : {
																		required : true
																	},
																	cityEdit : {
																		required : true
																	},
																	stateEdit : {
																		required : true
																	},
																	phoneEdit : {
																		required : true
																	},

																	emailEdit : {
																		required : true
																	}
																},
																messages : {
																	orgNameEdit : "<font style='color: red;'><b>Organization Name is Required</b></font>",
																	add1Edit : "<font style='color: red;'><b>Address1 is Required</b></font>",

																	cityEdit : "<font style='color: red;'><b>City is Required</b></font>",
																	stateEdit : "<font style='color: red;'><b>State is Required</b></font>",
																	countryIdEdit : "<font style='color: red;'><b>Country is Required</b></font>",
																	phoneEdit : "<font style='color: red;'><b>Phone Number is Required</b></font>",

																	emailEdit : "<font style='color: red;'><b>Email is Required</b></font>"
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
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();

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


</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Organization</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${organizationValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<!-- ============================================Begin OrganizationSearch=================================================================================================== -->
					<form:form action="orgnizationSearch.mnt" method="get"
						commandName="organization">


						<table class="tableGeneral">


							<tr>
								<td colspan="3"><c:forEach var="organizationUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="3"><c:forEach var="organizationUpdate"
										items="${organizationUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${organizationUpdate}"></c:out>
										</div>
									</c:forEach></td>

							</tr>
							<%-- <tr>
								<td><s:message code="label.organizationName"></s:message></td>
								<td><form:select path="orgId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${orgName}" />
								</form:select></td>
								<td><input type="submit"
									value="<s:message code="label.search"/> "
									class="btn btn-primary"/></td>
							</tr>
 --%>
							<tr>
								<td><s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
					<!-- ============================================End OrganizationSearch=================================================================================================== -->
					<c:forEach var="organizationSearch" items="${organizationSearch}">
						<c:set var="g" value="${organizationSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<!-- ============================================Begin OrgDisplayTable=================================================================================================== -->
						<display:table id="organizationRow" name="organizationSearch"
							requestURI="orgnizationSearch.mnt" pagesize="5" class="table">
							<display:column property="orgName"
								titleKey="label.organizationName" media="html" sortable="true"></display:column>
							<display:column property="add1" titleKey="label.address1"
								media="html" sortable="true" />
							<display:column property="add2" titleKey="label.address2"
								media="html" sortable="true" />
							<display:column property="add3" titleKey="label.address3"
								media="html" sortable="true" />
							<display:column property="city" titleKey="label.city"
									media="html" sortable="true" />
							<display:column property="state" titleKey="label.state"
								sortable="true" />
							<display:column property="country" titleKey="label.country"
								sortable="true" />
							<display:column property="phone" titleKey="label.phoneNumber"
								sortable="true" />
							<display:column property="fax" titleKey="label.fax"
								sortable="true" />
							<display:column property="email" titleKey="label.email"
								sortable="true" />
							<display:column property="orgType"
								titleKey="label.organizationType" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
								<a
									href="organizationEditHome.mnt?organizationEdit=<c:out value="${organizationRow.orgId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="organizationDelete.mnt?organizationCodeDelete=<c:out value="${organizationRow.orgId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
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
			<!-- ============================================End OrgDisplayTable=================================================================================================== -->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table class="tableGeneral">
						<!-- ============================================Begin Organization Add=================================================================================================== -->
						<tr>
							<td colspan="2"><c:forEach var="duplicatei"
									items="${duplicate}">
									<div class="alert-warning">
										<font color="red"><c:out value="${duplicatei}"></c:out></font>
									</div>
								</c:forEach></td>
						</tr>
					</table>
					<form:form action="organizationAdd.mnt" method="POST"
						commandName="organization" id="organizationAdd">

						<table>
							<form:hidden path="aid" />
							<tr>
								<td><s:message code="label.organizationName"></s:message><font
									color="red">*</font></td>
								<td><form:input path="orgName" id="orgName" class="textbox" />
								</td>
							</tr>
							<tr>
								<td><s:message code="label.address1"></s:message></td>
								<td><form:input path="add1" id="add1" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.address2"></s:message></td>
								<td><form:input path="add2" id="add2" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.address3"></s:message></td>
								<td><form:input path="add3" id="add3" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.city"></s:message><font
									color="red">*</font></td>
								<td><form:input path="city" id="city" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.state"></s:message><font
									color="red">*</font></td>
								<td><form:input path="state" id="State" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.country"></s:message></td>
								<td><form:select path="countryId" id="country"
										class="select">
										<form:option value="0">--Select--</form:option>

										<form:options items="${country}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.phoneNumber"></s:message></td>
								<td><form:input path="phone" id="phone" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.fax"></s:message></td>
								<td><form:input path="fax" id="fax" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.email"></s:message></td>
								<td><form:input path="email" id="email" class="textbox" /></td>
							</tr>

							<tr>
								<td><s:message code="label.organizationType"></s:message></td>
								<td><form:select path="orgTypeId" id="orgTypeId"
										class="select">
										<form:option value="0">--Select--</form:option>

										<form:options items="${organizationIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><input type="submit"
									value='<s:message code="label.add"/>' class="btn btn-primary"
									id="sumbnid" /> <input type="reset"
									value='<s:message code="label.reset"/>' class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
					<!-- ============================================End OrganizationAdd=================================================================================================== -->


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<!-- ============================================Begin organizationUpdate=================================================================================================== -->
					<c:forEach var="orgEditValues" items="${organizationValues }">
						<form:form action="organizationUpdate.mnt" method="POST"
							commandName="organization" id="orgUpForm">
							<table>
								<tr>
									<td colspan="2"><c:forEach var="orgDupId"
											items="${orgUpdateDuplicate}">
											<div class="alert-warning">
												<font color="red"><c:out value="${orgDupId}"></c:out>
												</font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="orgIdEdit" />
								<tr>
									<td><s:message code="label.organizationName" /><font
										color="red">*</font></td>
									<td><form:input path="orgNameEdit" id="orgName"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.address1" /></td>
									<td><form:input path="add1Edit" id="add1" class="textbox" />
									</td>
								</tr>
								<tr>
									<td><s:message code="label.address1" /></td>
									<td><form:input path="add2Edit" id="add2" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.address1" /></td>
									<td><form:input path="add3Edit" id="add3" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.city" /><font color="red">*</font></td>
									<td><form:input path="cityEdit" id="city" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.state" /><font color="red">*</font></td>
									<td><form:input path="stateEdit" id="State"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.country" /></td>
									<td><form:select path="countryIdEdit" id="country"
											class="select">
											<form:option value="0">--Select--</form:option>

											<form:options items="${country}" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.phoneNumber" /></td>
									<td><form:input path="phoneEdit" id="phone"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.fax" /></td>
									<td><form:input path="faxEdit" id="faxEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.email" /></td>
									<td><form:input path="emailEdit" id="email"
											class="textbox" /></td>
								</tr>

								<tr>
									<td><s:message code="label.organizationType" /></td>
									<td><form:select path="orgTypeIdEdit" id="orgTypeId"
											class="select">
											<form:option value="0">--Select--</form:option>

											<form:options items="${organizationIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td><input type="submit"
										value="<s:message code="label.update"/>"
										class="btn btn-primary" id="updateId" /><input type="reset"
										value="<s:message code="label.reset"/>"
										class="btn btn-primary" /></td>
								</tr>
							</table>
						</form:form>
						<!-- ============================================End organizationEdit=================================================================================================== -->

					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




