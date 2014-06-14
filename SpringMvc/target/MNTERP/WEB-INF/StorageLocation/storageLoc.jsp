<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 23-09-2013 -->

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
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>


<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumbnid')
								.click(
										function(event) {

											$('#slADD')
													.validate(
															{
																rules : {
																	storageLocation : {
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
																	}

																},
																messages : {
																	storageLocation : "<font style='color: red;'><b>storage Location is Required</b></font>",
																	add1 : "<font style='color: red;'><b>Address1 is Required</b></font>",

																	city : "<font style='color: red;'><b>City is Required</b></font>",
																	state : "<font style='color: red;'><b>State is Required</b></font>",
																	country : "<font style='color: red;'><b>Country is Required</b></font>",

																	mobile : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
																	phone : "<font style='color: red;'><b>Phone Number is Required</b></font>"

																},

															});
										});

						$('#editbtn')
								.click(
										function(event) {

											$("#slEdit")
													.validate(
															{
																rules : {
																	storageLocationEdit : {
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
																	}

																},
																messages : {
																	storageLocationEdit : "<font style='color: red;'><b>storage Location is Required</b></font>",
																	add1Edit : "<font style='color: red;'><b>Address1 is Required</b></font>",

																	cityEdit : "<font style='color: red;'><b>City is Required</b></font>",
																	stateEdit : "<font style='color: red;'><b>State is Required</b></font>",
																	countryEdit : "<font style='color: red;'><b>Country is Required</b></font>",

																	mobileEdit : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
																	phoneEdit : "<font style='color: red;'><b>Phone Number is Required</b></font>"

																},

															});
										});
					});
</script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
	$(function() {
		$("#tabs1").tabs();
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
			<s:message code="label.storageLocation"></s:message>
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="storageSearch" items="${storageSearchEdit}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /> </a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /> </a></li>
			</ul>
			<!--=================== ============================================Begin Storage Location Search================================================= -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="storageSearch.mnt" method="get"
						commandName="storageLocation">
						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach var="organizationTypeUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="3"><c:forEach var="storageUpdate"
										items="${storageUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${storageUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td><s:message code="label.storageLocationName"></s:message>
								</td>
								<td><form:select path="storageLocationId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${storageName}" />
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
					<!--=================== ============================================End Storage Location Search================================================= -->


					<!--=================== ============================================Begin Display Table================================================= -->

					<c:forEach var="storageSearch" items="${storageSearch}">
						<c:set var="g" value="${storageSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="storageLocRow" name="storageSearch"
							requestURI="storageSearch.mnt" pagesize="5" class="table">
							<display:column property="storageLocation"
								titleKey="label.storageLocation" media="html" sortable="true"></display:column>
							<display:column property="plantName" titleKey="label.plantName"
								media="html" sortable="true"></display:column>
							<display:column property="add1" titleKey="label.address1"
								media="html" sortable="true" />
							<display:column property="add2" titleKey="label.address2"
								media="html" sortable="true" />
							<display:column property="add3" titleKey="label.address3"
								media="html" sortable="true" />
							<display:column property="city" titleKey="label.city"
								sortable="true" />
							<display:column property="state" titleKey="label.state"
								sortable="true" />
							<display:column property="zip" titleKey="label.zip" media="html"
								sortable="true"></display:column>
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
									href="storageLocEdit.mnt?storageLocEdit=<c:out value="${storageLocRow.storageLocationId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="storageDelete.mnt?storageDelete=<c:out value="${storageLocRow.storageLocationId}"/>"
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
			<!--=================== ============================================Begin Storage Location Add================================================= -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="storageLocAdd.mnt" method="POST"
						commandName="storageLocation" id="slADD">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="duplicateid"
										items="${duplicate}">
										<div class="alert-warning">
											<font color="red"> <c:out value="${duplicateid}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" />
							<tr>
								<td><s:message code="label.storageLocationName" /><font
									color="red">*</font></td>
								<td><form:input path="storageLocation" class="textbox" />
								</td>
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

										<form:option value="0">--Select--</form:option>

										<form:options items="${country}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.phoneNumber" /></td>
								<td><form:input path="phone" id="phone" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.mobileNumber" /></td>
								<td><form:input path="mobile" id="mobile" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.fax" /></td>
								<td><form:input path="fax" id="fax" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.zip" /><font color="red">*</font></td>
								<td><form:input path="zip" id="zip" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.plantName"></s:message></td>
								<td><form:select path="plantId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${plantIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.organizationName"></s:message></td>
								<td><form:checkboxes cssClass="checkbox" items="${orgName}"
										path="orgId" element="ul" /></td>
							</tr>

							<tr>
								<td><input type="submit"
									value="<s:message code="label.save"/> " class="btn btn-primary"
									id="sumbnid" /><input type="reset"
									value="<s:message code="label.reset"/> "
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!--=================== ============================================End Storage Location Add================================================= -->


			<!--=================== ============================================Begin Storage Location Update================================================= -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="storageSearchEdit" items="${storageSearchEdit }">
						<table>

							<tr>
								<td colspan="2"><c:forEach var="storageDup"
										items="${storageLocUpdateDup }">
										<div class="alert-warning">
											<font color="red"> <c:out value="${storageDup}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
						</table>
						<form:form action="storageUpdate.mnt" method="POST"
							commandName="storageLocation" id="slEdit">
							<table>

								<form:hidden path="storageLocationIdEdit" />
								<tr>
									<td><s:message code="label.storageLocationName" /><font
										color="red">*</font></td>
									<td><form:input path="storageLocationEdit" class="textbox" />
									</td>
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
									<td><s:message code="label.city" /></td>
									<td><form:input path="cityEdit" id="city" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.state" /><font color="red">*</font></td>
									<td><form:input path="stateEdit" id="State"
											class="textbox" /></td>
								</tr>

								<tr>
									<td><s:message code="label.country" /><font color="red">*</font></td>
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
									<td><s:message code="label.zip" /><font color="red">*</font></td>
									<td><form:input path="zipEdit" id="zip" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.plantName" /></td>
									<td><form:select path="plantIdEdit" class="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${plantIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.organizationName" /></td>
									<td><form:checkboxes cssClass="checkbox" element="ul"
											items="${orgName}" path="orgIdEdit" /></td>
								</tr>

								<tr>
									<td><input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-primary" id="editbtn" /><input type="reset"
										value="<s:message code="label.reset"/> "
										class="btn btn-primary" /></td>
								</tr>
							</table>
						</form:form>


					</c:forEach>
					<!--=================== ============================================End Storage Location Update================================================= -->

				</div>
			</div>


		</div>
</body>
</html>




