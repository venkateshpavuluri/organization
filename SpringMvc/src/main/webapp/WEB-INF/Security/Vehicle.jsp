
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'AssertTypeTemplate.jsp' starting page</title>
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
											//alert($('#vehicleTypeId').val());
											$("#addVehicleForm")
													.validate(
															{

																rules : {
																	vehicleTypeId : {
																		required : true
																	},
																	vehicleMade : {
																		required : true
																	},
																	vehicleModel : {
																		required : true
																	},
																	driverId : {
																		required : true,
																		number : true
																	},
																	registrationNum : {
																		required : true
																	},
																	permit : {
																		required : true
																	},
																	advetisementTax : {
																		required : true,
																		number: true
																	},
																	roadTax : {
																		required : true,
																		number: true
																	},
																	professionalTax : {
																		required : true,
																		number: true
																	}
																},
																messages : {
																	vehicleTypeId : "<font style='color: red;'><b> Vehicle type is Required</b></font>",
																	vehicleMade : "<font style='color: red;'><b> Vehicle Made is Required</b></font>",
																	vehicleModel : "<font style='color: red;'><b> Vehicle Model is Required</b></font>",
																	driverId : {
																		required:"<font style='color: red;'><b> Driver Id is Required</b></font>",
																		number:"<font style='color: red;'><b> Driver Id must be numbers</b></font>"
																	},
																	registrationNum : "<font style='color: red;'><b> Registration Number is Required</b></font>",
																	permit : "<font style='color: red;'><b> Permit is Required</b></font>",
																	advetisementTax : {
																		required :"<font style='color:red;'><b>AdvertisementTax is required</b></font>",
																		number:"<font style='color:red;'><b>It allows only Numbers</b></font>",
																					},
																	roadTax : {
																		required :"<font style='color:red;'><b>RoadTax is required</b></font>",
																		number:"<font style='color:red;'><b>It allows only Numbers</b></font>",
																					},
																	professionalTax : {
																		required :"<font style='color:red;'><b>ProfessionalTax is required</b></font>",
																		number:"<font style='color:red;'><b>It allows only Numbers</b></font>",
																					}

																},

															});
										});

						$('#updbut')
								.click(
										function(event) {

											$("#updateVehicleForm")
													.validate(
															{
																rules : {
																	vehicleTypeIdEdit : {
																		required : true
																	},
																	vehicleMadeEdit : {
																		required : true
																	},
																	vehicleModelEdit : {
																		required : true
																	},
																	driverIdEdit : {
																		required : true,
																		number : true
																	},
																	registrationNumEdit : {
																		required : true
																	},
																	permitEdit : {
																		required : true
																	},
																	advetisementTaxEdit : {
																		required : true,
																		number: true
																	},
																	roadTaxEdit : {
																		required : true,
																		number: true
																	},
																	professionalTaxEdit : {
																		required : true,
																		number: true
																	}
																},
																messages : {
																	vehicleTypeIdEdit : "<font style='color: red;'><b> Vehicle type is Required</b></font>",
																	vehicleMadeEdit : "<font style='color: red;'><b> Vehicle Made is Required</b></font>",
																	vehicleModelEdit : "<font style='color: red;'><b> Vehicle Model is Required</b></font>",
																	driverIdEdit :{
																		required:"<font style='color: red;'><b> Driver Id is Required</b></font>",
																		number:"<font style='color: red;'><b> Driver Id must be numbers</b></font>"
																	} ,
																	registrationNumEdit : "<font style='color: red;'><b> Registration Number is Required</b></font>",
																	permitEdit : "<font style='color: red;'><b> Permit is Required</b></font>",
																	advetisementTaxEdit : {
																		required :"<font style='color:red;'><b>AdvertisementTax is required</b></font>",
																		number:"<font style='color:red;'><b>It allows only Numbers</b></font>",
																					},
																	roadTaxEdit : {
																		required :"<font style='color:red;'><b>RoadTax is required</b></font>",
																		number:"<font style='color:red;'><b>It allows only Numbers</b></font>",
																					},
																	professionalTaxEdit :{
																		required :"<font style='color:red;'><b>ProfessionalTax is required</b></font>",
																		number:"<font style='color:red;'><b>It allows only Numbers</b></font>",
																					},

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
<script type="text/javascript">
	$(document).ready(function() {

		if ($('#advanceSearchHidden').val() == "1") {
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
		}
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#basicSearch').click(function() {
			$("#advanceSearchHidden").val("0");
			$('#mainSearch').show();
			$('#advanceSearchDiv').hide();
			$('#advanceSearch').show();
			$('#basicSearch').hide();
			return false;
		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Vehicle</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vehicleValues" items="${vehicleValues}">
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
					<table class="tableGeneral">
						<form:form action="vehicleSearch.mnt" method="get"
							commandName="vehicleAdd">

							<tr>
								<td colspan="2">
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.vehicle"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.vehicle"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="vehicleDel"
										items="${vehicleDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.vehicle"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="vehicleDelErr"
										items="${vehicleDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.vehicle"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="vehicleUpadteSuccess"
										items="${vehicleUpadteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.vehicle"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="vehicleUpadteFail"
										items="${vehicleUpadteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.vehicle"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
							
						
								
							</td></tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" />

								<form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="vehicleAdd.operations">
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
							
							
							
								<td>
								<c:choose>
								<c:when test="${search}">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></c:otherwise>
								</c:choose>
								</td>
							</tr>


						</form:form>

						<form:form action="vehicleAdvanceSearch.mnt" method="get"
							commandName="vehicleAdd" name="advanceSearchFinal">
							<tr>
								<td><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue">
										<u>
										<b>Advanced Search</b></u></font></a> <a href="#" id="basicSearch"
									style="display: none"><font style="color: blue">
										<u>
										<b>Back To Basic Search</b></u></font></a></td>
							</tr>
						</form:form>


					</table>
					<form:form action="vehicleAdvanceSearchOperations.mnt"
						commandName="vehicleAdd">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${vehicleSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label>
										<form:hidden path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1" cssClass="select">
												<%-- <form:option value="0">-Select-</form:option> --%>
												<form:option value="=">Equals To</form:option>
												<form:option value="!=">Not Equals To</form:option>
												<form:option value="_%">BeginsWith</form:option>
												<form:option value="%_">EndsWith</form:option>
												<form:option value="%_%">Contains</form:option>
											</form:select></td>
										<td><form:input path="advanceSearchText"
												id="advanceSearch" cssClass="textbox"/></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3">
									<c:choose>
									<c:when test="${search}">
									<input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" /></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-danger" /></c:otherwise>
									</c:choose>
									</td>
								</tr>

							</table>

						</div>
					</form:form>

					<c:if test="${vehicleSearch!=null}">
						<display:table id="vehicleRow" name="vehicleSearch"
							requestURI="vehicleSearch.mnt" pagesize="5" class="table">

							<display:column property="vehicleType"
								titleKey="label.vehicleTypeId" media="html" sortable="true"></display:column>
							<display:column property="vehicleMade"
								titleKey="label.vehiclemade" media="html" sortable="true"></display:column>
							<display:column property="vehicleModel"
								titleKey="label.vehiclemodel" media="html" sortable="true"></display:column>
							<display:column property="driverId" titleKey="label.driverid"
								media="html" sortable="true"></display:column>
							<display:column property="registrationNum"
								titleKey="label.reginum" media="html" sortable="true"></display:column>
							<display:column property="permit" titleKey="label.permit"
								media="html" sortable="true"></display:column>
							<display:column property="advetisementTax"
								titleKey="label.advTax" media="html" sortable="true"></display:column>
							<display:column property="roadTax" titleKey="label.roadTax"
								media="html" sortable="true"></display:column>
							<display:column property="professionalTax"
								titleKey="label.proffTax" media="html" sortable="true"></display:column>
							<display:column property="insurance" titleKey="label.insurance"
								media="html" sortable="true"></display:column>
							<display:column property="fitness" titleKey="label.fitness"
								media="html" sortable="true"></display:column>
							<display:column property="pollution" titleKey="label.pollution"
								media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
								<a
									href="vehicleEditHome.mnt?vehicleDetEdit=<c:out value="${vehicleRow.vehicleId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
							</display:column>

							<display:column titleKey="label.delete">
								<c:choose>
								<c:when test="${delete}">
									<a
									href="vehicleDelete.mnt?vehicleIdDelete=<c:out value="${vehicleRow.vehicleId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
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

					<form:form action="vehicleAdd.mnt" method="GET"
						commandName="vehicleAdd" id="addVehicleForm"
						onsubmit="return validateForm()">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="VehicleDuplicate"
										items="${VehicleDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.reginum"/> <spring:message code="label.duplicateCheck"></spring:message>
											
										</div>
									</c:forEach></td>
							</tr>
							
							<form:hidden path="vehicleId" />
							<tr>
								<td><spring:message code="label.vehicleTypeId" /><span
									class="required">*</span></td>
								<td><form:select path="vehicleTypeId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${VehicleTypeIds}" />
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.vehiclemade" /><span
									class="required">*</span></td>
								<td><form:input path="vehicleMade" id="vehicleMade"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.vehiclemodel" /><span
									class="required">*</span></td>
								<td><form:input path="vehicleModel" id="vehicleModel"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.driverid" /><span
									class="required">*</span></td>
								<td><form:input path="driverId" id="driverId"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.reginum" /><span
									class="required">*</span></td>
								<td><form:input path="registrationNum" id="registrationNum"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.permit" /><span
									class="required">*</span></td>
								<td><form:input path="permit" id="permit" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.advTax" /><span
									class="required">*</span></td>
								<td><form:input path="advetisementTax" id="advetisementTax"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.roadTax" /><span
									class="required">*</span></td>
								<td><form:input path="roadTax" id="roadTax" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.proffTax" /><span
									class="required">*</span></td>
								<td><form:input path="professionalTax" id="professionalTax"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.insurance" /></td>
								<td><form:select path="insurance" id="insurance"
										class="select">
										<%-- <form:option value="">--Select--</form:option> --%>
										<form:option value="1">Yes</form:option>
										<form:option value="0">No</form:option>
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.fitness" /></td>
								<td><form:textarea path="fitness" id="fitness"
										class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.pollution" /></td>
								<td><form:select path="pollution" id="pollution"
										class="select">
										<%-- <form:option value="">--Select--</form:option> --%>
										<form:option value="1">Yes</form:option>
										<form:option value="0">No</form:option>
									</form:select></td>
							</tr>

							<form:hidden path="aid" />
							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${save}">
								<input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbnid" /> 
									</c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>"
									class="btn btn-danger" /></c:otherwise>
									</c:choose>
									<input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="vehicleEditValues" items="${vehicleValues }">
						<form:form action="vehicleUpdate.mnt" method="POST"
							commandName="vehicleAdd" id="updateVehicleForm">
							<table class="tableGeneral">
							
								<tr>
									<td colspan="2"><c:forEach var="vehicleEditDuplicate"
											items="${vehicleEditDuplicate}">
											<div class="alert-warning" id="successmessage">
												<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.reginum"/> <spring:message code="label.duplicateCheck"></spring:message>
											
											</div>
										</c:forEach></td>
								</tr>
								
								<form:hidden path="vehicleIdEdit" />

								<tr>
									<td><spring:message code="label.vehicleTypeId" /><span
										class="required">*</span></td>
									<td><form:select path="vehicleTypeIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${VehicleTypeIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.vehiclemade" /><span
										class="required">*</span></td>
									<td><form:input path="vehicleMadeEdit" id="vehicleMade"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.vehiclemodel" /><span
										class="required">*</span></td>
									<td><form:input path="vehicleModelEdit"
											id="vehicleModelEdit" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.driverid" /><span
										class="required">*</span></td>
									<td><form:input path="driverIdEdit" id="driverIdEdit"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.reginum" /><span
										class="required">*</span></td>
									<td><form:input path="registrationNumEdit"
											id="registrationNumEdit" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.permit" /><span
										class="required">*</span></td>
									<td><form:input path="permitEdit" id="permitEdit"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.advTax" /><span
										class="required">*</span></td>
									<td><form:input path="advetisementTaxEdit"
											id="advetisementTaxEdit" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.roadTax" /><span
										class="required">*</span></td>
									<td><form:input path="roadTaxEdit" id="roadTaxEdit"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.proffTax" /><span
										class="required">*</span></td>
									<td><form:input path="professionalTaxEdit"
											id="professionalTaxEdit" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.insurance" /></td>
									<td><form:select path="insuranceEdit" id="insurance"
											class="select">
											<%-- <form:option value="">--Select--</form:option> --%>
											<form:option value="1">Yes</form:option>
											<form:option value="0">No</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.fitness" /></td>
									<td><form:textarea path="fitnessEdit" id="fitnessEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.pollution" /></td>
									<td><form:select path="pollutionEdit" id="pollution"
											class="select">
											<%-- <form:option value="">--Select--</form:option> --%>
											<form:option value="1">Yes</form:option>
											<form:option value="0">No</form:option>
										</form:select></td>
								</tr>
								<form:hidden path="createDateEdit" />
								<form:hidden path="aid" />


								<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${update}">
									<input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updbut" /></c:when>
										<c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
										</c:otherwise>
									</c:choose>
									</td>
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




