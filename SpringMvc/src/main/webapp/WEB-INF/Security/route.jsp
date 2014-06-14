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
											//alert($('#routeTypeId').val());
											$("#addRouteForm")
													.validate(
															{

																rules : {
																	routeCode : {
																		required : true
																	},
																	organizationId : {
																		required : true
																	},
																	fromPlace : {
																		required : true
																	},
																	toPlace : {
																		required : true
																	},
																	distance : {
																		required : true,
																		number : true
																	},
																	uomId : {
																		required : true
																	},
																	approxTime : {
																		required : true,
																		number : true
																	},
																	timeUomId : {
																		required : true
																	},

																},
																messages : {
																	routeCode : "<font style='color: red;'><b> Route Code is Required</b></font>",
																	organizationId : "<font style='color: red;'><b> Organization Name is Required</b></font>",
																	fromPlace : "<font style='color: red;'><b> From Place is Required</b></font>",
																	toPlace : "<font style='color: red;'><b> To Place is Required and must be Integer</b></font>",
																	distance : "<font style='color: red;'><b> Distance is Required</b></font>",
																	uomId : "<font style='color: red;'><b>  Units of Distance is Required</b></font>",
																	approxTime : "<font style='color: red;'><b>  Approximate Time is Required</b></font>",
																	timeUomId : "<font style='color: red;'><b> Units of Time is Required</b></font>",

																},

															});
										});

						$('#updbut')
								.click(
										function(event) {

											$("#updateRouteForm")
													.validate(
															{
																rules : {
																	routeCodeEdit : {
																		required : true
																	},
																	organizationIdEdit : {
																		required : true
																	},
																	fromPlaceEdit : {
																		required : true
																	},
																	toPlaceEdit : {
																		required : true
																	},
																	distanceEdit : {
																		required : true,
																		number : true
																	},
																	uomIdEdit : {
																		required : true
																	},
																	approxTimeEdit : {
																		required : true,
																		number : true
																	},
																	timeUomIdEdit : {
																		required : true
																	},

																},
																messages : {
																	routeCodeEdit : "<font style='color: red;'><b> Route Code is Required</b></font>",
																	organizationIdEdit : "<font style='color: red;'><b> Organization Name is Required</b></font>",
																	fromPlaceEdit : "<font style='color: red;'><b> From Place is Required</b></font>",
																	toPlaceEdit : "<font style='color: red;'><b> To Place is Required and must be Integer</b></font>",
																	distanceEdit : "<font style='color: red;'><b> Distance is Required</b></font>",
																	uomIdEdit : "<font style='color: red;'><b>  Units of Distance is Required</b></font>",
																	approxTimeEdit : "<font style='color: red;'><b>  Approximate Time is Required</b></font>",
																	timeUomIdEdit : "<font style='color: red;'><b> Units of Time is Required</b></font>",

																},

															});
										});

					});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#search').click(function(e) {
			$('#edit').hide();
			$('#map-canvas').hide();
			$('#map_container').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#add').click(function(e) {

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
<!-- <style type="text/css">
div#map_container{
	width:100%;
	height:350px;
}
</style> -->
<style type="text/css">
div#map-canvas {
	width: 100%;
	height: 450px;
}
</style>

<script type="text/javascript">
	function loadMap() {
		// alert("hi i'm in google maps");
		var latlng = new google.maps.LatLng(17.3660, 78.4760);
		var myOptions = {
			zoom : 10,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map_container"),
				myOptions);

		var marker = new google.maps.Marker({
			position : latlng,
			map : map,
			title : "my hometown, Malim Nawar!"
		});

	}
</script>


<!--  -->


<meta name="viewport" content="initial-scale=1.0, user-scalable=no"></meta>

<title>Waypoints in directions</title>

<script type="text/javascript">
	$(document).ready(function() {
		$('#view-map').hide();

		// alert("hiding map");

	});

	$(function() {
		$('#getdir').click(function() {
			//	alert("show map");

			$('#view-map').show();
			//alert("map displayed");
		});
	});

	$(function() {
		$('#getdirEdit').click(function() {
			alert("show map in edit");

			$('#view-map').show();
			alert("map displayed");
		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Route</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="routeValues" items="${routeValues}">
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
						<form:form action="routeSearch.mnt" method="get"
							commandName="routeAdd">

							<tr>
								<td colspan="2">
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.routeCode"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.routeCode"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										<c:forEach var="routeDelSuccess"
										items="${routeDelSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.routeCode"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="routeDelFail"
										items="${routeDelFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.routeCode"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="routeUpadteSuccess"
										items="${routeUpadteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.routeCode"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="routeUpadteFail"
										items="${routeUpadteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.routeCode"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
							</td></tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" />

								<form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="routeAdd.operations">
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
									<td><c:choose>
									<c:when test="${search}">
									<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></c:otherwise>
								</c:choose></td>
							</tr>


						</form:form>

						<form:form action="routeAdvanceSearch.mnt" method="get"
							commandName="routeAdd" name="advanceSearchFinal">
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
					<form:form action="routeAdvanceSearchOperations.mnt"
						commandName="routeAdd">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${routeSearchAdvance}">
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
										<c:when test="${advanceSearch}">
									<input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" /></c:when>
										<c:otherwise><input type="submit" disabled="disabled"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-danger" /></c:otherwise></c:choose></td>
								</tr>

							</table>

						</div>
					</form:form>

					<c:if test="${routeSearch!=null}">
						<display:table id="routeRow" name="routeSearch"
							requestURI="routeSearch.mnt" pagesize="5" class="table">

							<display:column property="routeCode" titleKey="label.routeCode"
								media="html" sortable="true"></display:column>
							<display:column property="organizationName"
								titleKey="label.organizationName" media="html" sortable="true"></display:column>
							<display:column property="fromPlace" titleKey="label.fromPlace"
								media="html" sortable="true"></display:column>
							<display:column property="toPlace" titleKey="label.toPlace"
								media="html" sortable="true"></display:column>
							<display:column property="distance" titleKey="label.distance"
								media="html" sortable="true"></display:column>
							<display:column property="uomName" titleKey="label.uomName"
								media="html" sortable="true"></display:column>
							<display:column property="approxTime" titleKey="label.approxTime"
								media="html" sortable="true"></display:column>
							<display:column property="timeUomName" titleKey="label.timeUom"
								media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
								<a
									href="routeEditHome.mnt?routeDetEdit=<c:out value="${routeRow.routeId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when><c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
								<a
									href="routeDelete.mnt?routeIdDelete=<c:out value="${routeRow.routeId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when><c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
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

					<form:form action="routeAdd.mnt" method="GET"
						commandName="routeAdd" id="addRouteForm"
						onsubmit="return validateForm()">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="RouteDuplicate"
										items="${RouteDuplicate}">
										<div class="alert-warning" id="savemessage">
											<c:out value="${RouteDuplicate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							
							<form:hidden path="routeId" />
							<tr>
								<td><spring:message code="label.routeCode" /><span
									class="required">*</span></td>
								<td><form:input path="routeCode" id="routeCode"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.organizationName" /><span
									class="required">*</span></td>
								<td><form:select path="organizationId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${organizationIds}" />
									</form:select></td>
							</tr>


							<tr>
								<td><spring:message code="label.fromPlace" /><span
									class="required">*</span></td>
								<td><form:input path="fromPlace" id="fromplace"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.toPlace" /><span
									class="required">*</span></td>
								<td><form:input path="toPlace" id="toplace" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.distance" /><span
									class="required">*</span></td>
								<td><form:input path="distance" id="registrationNum"
										class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.uomName" /><span
									class="required">*</span></td>
								<td><form:select path="uomId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uomIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.approxTime" /><span
									class="required">*</span></td>
								<td><form:input path="approxTime" id="advetisementTax"
										class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.timeUom" /><span
									class="required">*</span></td>
								<td><form:select path="timeUomId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uomIds}" />
									</form:select></td>
							</tr>


							<form:hidden path="aid" />


							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${save}">
								<input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbnid" /> </c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>"
									class="btn btn-danger" /></c:otherwise></c:choose>
									<input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
							<tr>
								<td><input type="button" id="getdir" value="Get Direction"
									class="btn btn-primary" onclick="calcRoute();" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="routeEditValues" items="${routeValues }">
						<form:form action="routeUpdate.mnt" method="POST"
							commandName="routeAdd" id="updateRouteForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="routeUpdateDuplicate"
											items="${routeUpdateDuplicate}">
											<div class="alert-danger" id="successmessage">
												<c:out value="${routeUpdateDuplicate}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								
								
								<form:hidden path="routeIdEdit" />
								<tr>
									<td><spring:message code="label.routeCode" /><span
										class="required">*</span></td>
									<td><form:input path="routeCodeEdit" id="routeMade"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.organizationName" /><span
										class="required">*</span></td>
									<td><form:select path="organizationIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${organizationIds}" />
										</form:select></td>
								</tr>


								<tr>
									<td><spring:message code="label.fromPlace" /><span
										class="required">*</span></td>
									<td><form:input path="fromPlaceEdit" id="routeModel"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.toPlace" /><span
										class="required">*</span></td>
									<td><form:input path="toPlaceEdit" id="driverId"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.distance" /><span
										class="required">*</span></td>
									<td><form:input path="distanceEdit" id="registrationNum"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.uomName" /><span
										class="required">*</span></td>
									<td><form:select path="uomIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${uomIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.approxTime" /><span
										class="required">*</span></td>
									<td><form:input path="approxTimeEdit" id="advetisementTax"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.timeUom" /><span
										class="required">*</span></td>
									<td><form:select path="timeUomIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${uomIds}" />
										</form:select></td>
								</tr>


								<form:hidden path="aid" />


								<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updbut" /></c:when><c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
										</c:otherwise></c:choose></td>
								</tr>
								<tr>
									<td><input type="button" id="getdirEdit"
										value="Get Direction" class="btn btn-primary" /></td>
								</tr>

							</table>
						</form:form>
					</c:forEach>
				</div>

			</div>
		</div>
	</div>




	<%-- <div id="map_container">

<table class="tableGeneral">
<tr>
<td><spring:message code="label.fromPlace"></spring:message></td>
<td>
<input type="text" id="start" class="textbox" />
</td>
</tr>
<tr>
<td><spring:message code="label.toPlace"/></td>
<td><input type="text" id="end" class="textbox" /> </td>
</tr>
<!-- <tr><td> <input type="text" id="waypoints" class="textbox"></input></td></tr> -->
<tr><td colspan="2"><input type="button" id="showmap" value="Show Map"  class="btn btn-primary" onclick="calcRoute();"  /></td></tr>
</table>

</div>
 <div id="map-canvas"></div> --%>
	<div id="view-map">
		<jsp:include page="/WEB-INF/Security/New_Route.jsp" /></div>
	<input type="hidden" id="waypoints"></input>
</body>
</html>




