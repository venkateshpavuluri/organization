<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'schedulingTemplate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
	$(window).load(function() {
		$(".loader").fadeOut(800);
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
.loader {
	position:absolute;
	center: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('images/loader.gif') 10% 10% no-repeat rgb(249,249,249);
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						
						$('#' + "sumbtnid")
								.click(
										function(event) {
											//alert($('#sdType').val());
											$("#addForm")
													.validate(
															{
																rules : {
																	shedulingType : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	shedulingType :{
																		required:"<font style='color: red;'><b>Sheduling Type is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	}
																},

															});
										});

						$('#updateId')
								.click(
										function(event) {

											$("#updateForm")
													.validate(
															{
																rules : {
																	shedulingEditType : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	shedulingEditType : {
																		required:"<font style='color: red;'><b>Sheduling Type is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	}
																},

															});
										});

						if (document.getElementById("shdId").value == 1) {
							//alert("Hai");
							var index = $('#tabs li a').index(
									$('a[href="#tabs-3"]').get(0));

							$('#tabs').tabs({
								active : index
							});
						}

					});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		 $("#bsId").focus();
		 //$("#sdTypeEdit").focus();
		$('#search,#add').click(function(e) {
			 $("#sdType").focus();
			 $("#bsId").focus();
			$('#edit').hide();

		});
		$('#sumbnasid').click(function(e) {
			document.getElementById("asId").value = 1;
			alert(document.getElementById("asId").value);
		});
	});
</script>

</head>

<body>

	<div class="divUserDefault">
		<div class="loader"></div>
		<div class="PageTitle">Scheduling Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="schedulingEditList" items="${schedulingEditList}">
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
				<div align="left">
					<form:form method="get" action="schedulingSearch.mnt"
						commandName="schedulingType">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addSchedulingsus"
										items="${param.addSchedulingsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.SchedulingType" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addSchedulingFail"
										items="${param.addSchedulingFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.SchedulingType" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSchedulingsus"
										items="${param.UpdateSchedulingsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.SchedulingType" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="UpdateSchedulingFail"
										items="${param.UpdateSchedulingFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.SchedulingType" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteSchedulingsus"
										items="${param.DeleteSchedulingsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.SchedulingType" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteSchedulingFail"
										items="${param.DeleteSchedulingFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.SchedulingType" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
										<%-- </form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td> --%>

									</form:select> <spring:bind path="schedulingType.operations">
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
									</spring:bind> <form:input path="basicSearchId" id="bsId" cssClass="textbox" /></td>

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
					

					<c:if test="${schedulingList!=null }">
						<display:table name="schedulingList" id="schdList" class="table"
							requestURI="schedulingSearch.mnt" pagesize="5">
							<display:column property="shedulingTypeId" sortable="true"
								title="shedulingTypeId" media="none" />
							<display:column property="shedulingType" sortable="true"
								titleKey="label.SchedulingType" media="html" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="schdulingEdit.mnt?schdulingId=<c:out value="${schdList.shedulingTypeId}"/> "><img
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
											href="schdulingDelete.mnt?schdulingId=<c:out value="${schdList.shedulingTypeId}"/> "
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
				<div align="left">

					<form:form action="schedulingAdd.mnt" method="POST"
						commandName="schedulingType" id="addForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="SchedulingTypeDuplicate"
										items="${SchedulingTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<c:out value="${SchedulingTypeDuplicate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="shdId" />
							<tr>
								<td><spring:message code="label.SchedulingType" /><span
									class="required">*</span> <form:input path="shedulingType"
										cssClass="textbox" id="sdType" maxlength="50"/></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>

								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="sumbtnid"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="sumbtnid"
											disabled="disabled"
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
					<c:forEach var="schedulingEditList" items="${schedulingEditList}">
						<form:form method="post" action="schdulingUpdate.mnt"
							commandName="schedulingType" id="updateForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach
											var="updateSchdulingTypeDuplicate"
											items="${updateSchdulingTypeDuplicate}">
											<div class="alert-warning" id="savemessage">
												<c:out value="${updateSchdulingTypeDuplicate}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="shedulingTypeEditId" />
								<tr>
									<td><spring:message code="label.SchedulingType" /><span
										class="required">*</span></td>
									<td><form:input path="shedulingEditType" id="sdTypeEdit"
											cssClass="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<c:choose>

										<c:when test="${update}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updateId" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updateId" /></td>
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
