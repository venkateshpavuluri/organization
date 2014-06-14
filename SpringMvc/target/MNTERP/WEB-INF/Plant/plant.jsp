
<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 20-09-2013 -->
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

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

		});
	});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumnid')
								.click(
										function(event) {

											$('#plantAdd')
													.validate(
															{
																rules : {
																	plantName : {
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
																	country : {
																		required : true
																	},
																	phone : {
																		required : true
																	},
																	mobile : {
																		required : true
																	},

																	orgId : {
																		required : true
																	}

																},
																messages : {
																	plantName : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	add1 : "<font style='color: red;'><b>Address1 is Required</b></font>",

																	city : "<font style='color: red;'><b>City is Required</b></font>",
																	state : "<font style='color: red;'><b>State is Required</b></font>",
																	country : "<font style='color: red;'><b>Country is Required</b></font>",

																	mobile : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
																	phone : "<font style='color: red;'><b>Phone Number is Required</b></font>",

																	orgId : "<font style='color: red;'><b>Organization Name is Required</b></font>"

																},

															});
										});

						$('#sumbnid')
								.click(
										function(event) {

											$("#formEdit")
													.validate(
															{
																rules : {
																	plantNameEdit : {
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
																	countryEdit : {
																		required : true
																	},
																	phoneEdit : {
																		required : true
																	},
																	mobileEdit : {
																		required : true
																	},

																	orgIdEdit : {
																		required : true
																	}

																},
																messages : {
																	plantNameEdit : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	add1Edit : "<font style='color: red;'><b>Address1 is Required</b></font>",
																	add2Edit : "<font style='color: red;'><b>Address2 is Required</b></font>",
																	add3Edit : "<font style='color: red;'><b>Address3 is Required</b></font>",
																	cityEdit : "<font style='color: red;'><b>City is Required</b></font>",
																	stateEdit : "<font style='color: red;'><b>State is Required</b></font>",
																	countryEdit : "<font style='color: red;'><b>Country is Required</b></font>",

																	mobileEdit : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
																	phoneEdit : "<font style='color: red;'><b>Phone Number is Required</b></font>",

																	orgIdEdit : "<font style='color: red;'><b>Organization Name is Required</b></font>"
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
		<div class="PageTitle">Plant Details</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${plantValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /> </a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /> </a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<!--=================== ============================================Begin PlantSearch================================================= -->
					<form:form action="plantSearch.mnt" method="get"
						commandName="plant">
						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach var="plantUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="3"><c:forEach var="plantUpdate"
										items="${plantUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${plantUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td><s:message code="label.plantName" /></td>
								<td><form:select path="plantId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${plantIds}" />
								</form:select></td>
								<td><input type="submit"
									value="<s:message code="label.search"/> "
									class="btn btn-primary"/></td>
							</tr> --%>

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
					<!--=================== ============================================End PlantSearch================================================= -->
					<c:forEach var="oplantSearch" items="${plantSearch}">
						<c:set var="g" value="$oplantSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<!--=================== ============================================Begin DisplayTable================================================= -->
						<display:table id="plantRow" name="plantSearch"
							requestURI="plantSearch.mnt" pagesize="5" class="table">
							<display:column property="plantName" titleKey="label.plantName"
								media="html" sortable="true"></display:column>
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
							<display:column property="countryName" titleKey="label.country"
								sortable="true" />
							<display:column property="phone" titleKey="label.phoneNumber"
								sortable="true" />
							<display:column property="fax" titleKey="label.fax"
								sortable="true" />
							<display:column property="mobile" titleKey="label.mobileNumber"
								sortable="true" />

							<display:column titleKey="label.edit" style="color:white">
								<a
									href="plantEdit.mnt?plantEdit=<c:out value="${plantRow.plantId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="plantDelete.mnt?plantDelete=<c:out value="${plantRow.plantId}"/>"
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
					<!--=================== ============================================End DisplayTable================================================= -->
				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="plantAdd.mnt" method="POST" commandName="plant"
						id="plantAdd">
						<form:hidden path="aid" />
						<table class="tableGeneral">

							<!--=================== ============================================Begin PlantAdd================================================= -->
							<tr>
								<td colspan="2"><c:forEach var="duplicateId"
										items="${duplicate}">

										<div class="alert-warning">
											<font color="red"><c:out value="${duplicateId}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><s:message code="label.plantName" /><font color="red">*</font></td>
								<td><form:input path="plantName" id="plantName"
										class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.address1" /></td>
								<td><form:input path="add1" id="add1" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.address2" /></td>
								<td><form:input path="add2" id="add2" class="textbox" /></td>
							</tr>
							<tr>

								<td><s:message code="label.address3" /></td>
								<td><form:input path="add3" id="add3" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.city" /><font color="red">*</font></td>
								<td><form:input path="city" id="city" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.state" /><font color="red">*</font></td>
								<td><form:input path="state" id="State" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.country" /></td>
								<td><form:select path="country" id="country" class="select">
										<form:option value="0" disabled="true">--Select--</form:option>

										<form:options items="${country}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.phoneNumber" /></td>
								<td><form:input path="phone" id="phone" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.mobileNumber" /></td>
								<td><form:input path="mobile" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.fax" /></td>
								<td><form:input path="fax" id="fax" class="textbox" /></td>
							</tr>


							<tr>
								<td><s:message code="label.organizationName" /></td>
								<td><form:select path="orgId" id="orgId" class="select">
										<form:option value="0">--Select--</form:option>

										<form:options items="${orgName}" />
									</form:select></td>
							</tr>
							<tr>
								<td><input type="submit" id="sumnid"
									value='<s:message code="label.save"/>' class="btn btn-primary" /><input
									type="reset" value='<s:message code="label.reset"/>'
									class="btn btn-primary" /></td>
							</tr>

						</table>
					</form:form>
					<!--=================== ============================================End PlantAdd================================================= -->
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<!--=================== ============================================Begin PlantUpdate================================================= -->
					<c:forEach var="materialEditValues" items="${plantValues }">

						<form:form action="plantUpdate.mnt" method="POST"
							commandName="plant" id="formEdit">

							<form:hidden path="plantIdEdit" />
							<table>
								<tr>
									<td colspan="2"><c:forEach var="plantDuplicate"
											items="${plantDuplicate}">
											<div class="alert-warning">
												<font color="red"> <c:out value="${plantDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td><s:message code="label.plantName" /><font color="red">*</font></td>
									<td><form:input path="plantNameEdit" id="plantName"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.address1" /></td>
									<td><form:input path="add1Edit" id="add1" class="textbox" />
									</td>
								</tr>
								<tr>
									<td><s:message code="label.address2" /></td>
									<td><form:input path="add2Edit" id="add2" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.address3" /></td>
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
									<td><form:select path="countryEdit" id="country"
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
									<td><s:message code="label.mobileNumber" /></td>
									<td><form:input path="mobileEdit" id="phone"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.fax" /></td>
									<td><form:input path="faxEdit" id="fax" class="textbox" /></td>
								</tr>


								<tr>
									<td><s:message code="label.organizationName" /></td>
									<td><form:select path="orgIdEdit" id="orgId"
											class="select">
											<form:option value="0">--Select--</form:option>

											<form:options items="${orgName}" />
										</form:select></td>
								</tr>
								<tr>
									<td><input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-primary" id="sumbnid" /><input type="reset"
										value="<s:message code="label.reset"/> "
										class="btn btn-primary" /></td>
								</tr>
							</table>
						</form:form>


						<!--=================== ============================================End PlantUpdate================================================= -->
					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




