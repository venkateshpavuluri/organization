<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						

						$('#subid')
								.click(
										function(event) {
											$("#addform")
													.validate(
															{
																rules : {
																	orgId : {
																		required : true
																		
																		
																	},
																	designationId:{
																		required:true
																	},
																	parentDesignationId:{
																		required:true
																	}
																},
																messages : {

																	orgId : {

																		required : "<font style='color: red;'><b>Orgnization is Required.</b></font>",

																		
																		
																	},
																	designationId : {

																		required : "<font style='color: red;'><b>Designation is Required.</b></font>",

																		
																		
																	},
																	parentDesignationId:{
																		required : "<font style='color: red;'><b>Parent Designation is Required.</b></font>",
																	}
																	
																},

															});
										});

						$('#updateAgree')
								.click(
										function(event) {

											$("#editform")
													.validate(
															{
																rules : {
																	orgId : {
																		required : true,
																		
																		
																	},
																	designationId:{
																		required:true
																	},
																	parentDesignationId:{
																		required:true
																	}
																},
																messages : {
																	orgId : {

																		required : "<font style='color: red;'><b>Orgnization is Required.</b></font>",

																		
																		
																	},
																	designationId : {

																		required : "<font style='color: red;'><b>Designation is Required.</b></font>",
																		
																		

																		
																	},
																	parentDesignationId:{
																		required : "<font style='color: red;'><b>Parent Designation is Required.</b></font>",
																	}
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
		$('#search,#add').click(function(e) {
			$('#edit').hide();
			$('#orgId').val('');
			$('#designationId').val('');
			$('#parentDesignationId').val('');

		});
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Organization Chart</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="OrganizationChartvalues" items="${OrganizationChartvalues}">
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
					<form:form action="OrganizationChartSearch.mnt" method="get"
						commandName="OrganizationChartCommand" name="agreementform">
						<table class="tableGeneral">
						
						
					
							<tr>
								<td colspan="2"><c:forEach var="OrganizationChartCommand"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.organizationChart"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.organizationChart"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="OrganizationChartUpdate"
										items="${OrganizationChartUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.organizationChart"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="OrganizationChartUpdateError"
										items="${OrganizationChartUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.organizationChart"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="OrganizationChartdelete"
										items="${OrganizationChartdelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.organizationChart"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="OrganizationChartdeleteError"
										items="${OrganizationChartdeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.organizationChart"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="OrganizationChartCommand.operations">
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
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /> <c:set
										var="save" value="false"></c:set> <c:set var="edit"
										value="false"></c:set> <c:set var="delete" value="false"></c:set>
									<c:set var="update" value="false"></c:set> <c:set var="search"
										value="false"></c:set> <fmt:setBundle basename="button" /> <fmt:message
										key="label.save" var="messagesav" /> <fmt:message
										key="label.search" var="messagesea" /> <fmt:message
										key="label.delete" var="messagedel" /> <fmt:message
										key="label.update" var="messageup" /> <fmt:message
										key="label.edit" var="messageed" /> <c:forEach
										items="${sessionScope.privilegeList}" var="privileges">
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
									
									 <c:choose>
										<c:when test="${true}"><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>
					

					<c:if test="${agtvalues!=null }">
						<display:table id="OrganizationChart" name="OrganizationChart"
							requestURI="OrganizationChartSearch.mnt" pagesize="5" class="table">

							<display:column property="orgName" titleKey="label.org"
								media="html" sortable="true" />
									<display:column property="designationName" titleKey="label.designation"
								media="html" sortable="true" />
								<display:column property="parentDesignationName" titleKey="label.parentDesignation"
								media="html" sortable="true" />




							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
								<a
									href="OrganizationChartEditHome.mnt?OrganizationChartEdit=<c:out 

								value="${OrganizationChart.organizationChartId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
									</c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${true}">
							
								<a
									href="OrganizationChartDelete.mnt?OrganizationChartDelete=<c:out value="${OrganizationChart.organizationChartId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
									
									</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
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

					<form:form action="OrganizationChartadd.mnt" method="POST"
						commandName="OrganizationChartCommand" id="addform">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach var="addOrganizationChartDuplicate"
										items="${addOrganizationChartDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.organizationChart"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								   <td><spring:message code="label.org"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="orgId" id="orgId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${orgnization }" />
									</form:select></td>

							</tr>
							<tr>
								   <td><spring:message code="label.designation"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="designationId" id="designationId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${designation }" />
									</form:select></td>

							</tr>
							
							<tr>
								   <td><spring:message code="label.parentDesignation"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="parentDesignationId" id="parentDesignationId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${designation }" />
									</form:select></td>

							</tr>
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${true}"><input type="submit"
									value="<spring:message
								code="label.save" />"
									class="btn btn-primary" id="subid" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose> <input type="reset"
									class="btn btn-primary"
									value="<spring:message
								code="label.reset" />" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="OrganizationChartvalues" items="${OrganizationChartvalues }">

						<form:form action="OrganizationChartUpdate.mnt" method="POST"
							commandName="OrganizationChartCommand" id="editform">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="editOrganizationChartDuplicate"
											items="${editOrganizationChartDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.organizationChart"/> <spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="organizationChartId"
									id="organizationChartIdEdit" />
								<tr>
								   <td><spring:message code="label.org"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="orgId" id="orgId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${orgnization }" />
									</form:select></td>

							</tr>
							<tr>
								   <td><spring:message code="label.designation"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="designationId" id="designationId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${designation }" />
									</form:select></td>

							</tr>
							<tr>
								   <td><spring:message code="label.parentDesignation"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="parentDesignationId" id="parentDesignationId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${designation }" />
									</form:select></td>

							</tr>
								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${true}"><input type="submit"
										value="<spring:message
								code="label.update" />"
										class="btn btn-primary" id="updateAgree" /></c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<spring:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
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




