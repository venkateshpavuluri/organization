<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
						jQuery.validator.addMethod("alphaNumeric", function (value, element) {
							  
					        return this.optional(element) || /^[a-zA-Z&]+$/.test(value);
					    });
						//AddForm Validations
						$('#subtnId ').click(function(event) {
							$('#addForm ').validate({
								rules : {
									projectPhase : {
										required : true, alphaNumeric:true,
										maxlength : 50
									},
									
								},
								messages : {
									projectPhase : {
										required :"<font style='color:red;'><b>projectPhase is required</b></font>",
										alphaNumeric:"<font style='color:red;'><b>should not allow special symbols</b></font>",
										maxlength:"<font style='color:red;'><b>length upto 50 charecters only</b></font>"
										},
									
								},
									});
										});
						//UpdateForm Validations
						$('#updated').click(function(event) {
							$('#editForm ').validate({
												rules : {
													projectPhaseEdit : {
															required : true, alphaNumeric:true, 
															maxlength : 50
																},
																	
																},
																messages : {
																	projectPhaseEdit : {
																		required :"<font style='color:red;'><b>projectPhase is required</b></font>",
																		alphaNumeric:"<font style='color:red;'><b>should not allow special symbols</b></font>",
																		maxlength:"<font style='color:red;'><b>length upto 50 charecters only</b></font>"
																		},
																	
																},
															});
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

<script>
	$(function() {
		$("#tabs").tabs();
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
<style>
.required{
color:red;

}
</style>
</head>
<body>
<div class="divUserDefault">
		<div class="PageTitle">Project Phase</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="projectPhaseValues" items="${projectPhaseValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:forEach>

				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="searchProjectPhase.mnt"
						commandName="ProjectPhase" method="get">

						<table class="tableGeneral">
							<tr>
								<td colspan="2">
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.projectPhase"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
											<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.projectPhase"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="qualDelete"
										items="${qualDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.projectPhase"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="qualDeleteErr"
										items="${qualDeleteErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.projectPhase"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="qualUpdate"
										items="${qualUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.projectPhase"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="qualUpdateErr"
										items="${qualUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.projectPhase"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
								
								
							</td></tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="ProjectPhase.operations">
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
								<c:when test="${search}"><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when><c:otherwise>
									<td><input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></td>
									</c:otherwise>
									</c:choose></td>
							</tr>
	</table>
					</form:form>
							<c:forEach var="projectPhaseSearch"
								items="${projectPhaseSearch}">
								<c:set var="i" value="${projectPhaseSearch}" />

							</c:forEach>
							<c:if test="${i!=null}">


								<display:table id="ProjectPhaseRow" name="projectPhaseSearch"
									requestURI="searchProjectPhase.mnt" pagesize="10"
									class="table">
									<%-- <display:column property="projectPhase_Id"
										title="projectPhaseId" media="none" sortable="true"></display:column> --%>
									<display:column property="projectPhase"
										titleKey="label.projectPhase" media="html" sortable="true"></display:column>
										<display:column property="project" titleKey="label.project"
								           media="html" sortable="true"></display:column>
									<display:column titleKey="label.edit" style="color:white">
										<c:choose>
										<c:when test="${edit}"><a
											href="projectPhaseEditHome.mnt?projectPhaseIdEdit=<c:out value="${ProjectPhaseRow.projectPhase_Id}"/>"
											style="color: red"> <img src="images/Edit.jpg"
											width="20px" height="20px" />
										</a></c:when><c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
									</display:column>
									<display:column titleKey="label.delete">
									<c:choose><c:when test="${delete}">
										<a
											href="projectPhaseDelete.mnt?projectPhaseIdDelete=<c:out value="${ProjectPhaseRow.projectPhase_Id}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
								</c:when>	<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
							</c:otherwise>
							</c:choose>	</display:column>
									<display:setProperty name="paging.banner.placement"
										value="bottom" />
									</display:table>

							</c:if>
					
				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="addProjectPhase.mnt"
						commandName="ProjectPhase" method="post" id="addForm">
						<table class="tableGeneral">

							<form:hidden path="aid" id="aid" />
							<tr>
								<td colspan="2"><c:forEach var="addProjectPhaseDuplicate"
										items="${addProjectPhaseDuplicate}">
										<div class="alert-warning" id="savemessage">
											<c:out value="${addProjectPhaseDuplicate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.projectPhase" /><span
									class="required" >*</span></td>
								<td><form:input path="projectPhase" class="textbox"
										maxlength="50" /></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.project" /><span
									class="required">*</span></td>
									<td><form:select path="project" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${project}" />
								</form:select></td>
								</tr>

							<tr>
								<td colspan="2"><c:choose>
								<c:when test="${save}"><input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/> " class="btn btn-danger"
									id="subtnId" />
									</c:otherwise></c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="ProjectPhaseEditValues"
						items="${projectPhaseValues }">
						<form:form action="projectPhaseUpdate.mnt" method="POST"
							commandName="ProjectPhase" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="projectPhase_IdEdit" />
								<tr>
									<td colspan="2"><c:forEach var="projectUpdateDup"
											items="${projectUpdateDup}">
											<div class="alert-warning" id="savemessage">
											<strong>Warning ! </strong>
											 <c:out value="${projectUpdateDup}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td><spring:message code="label.projectPhase" /><span
										class="required">*</span></td>
									<td><form:input path="projectPhaseEdit"
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
								<td><spring:message code="label.project" /><span
									class="required">*</span></td>
									<td><form:select path="projectEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${project}" />
								</form:select></td>
								</tr>
								
								<tr>
									<td colspan="2"><c:choose>
									<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when><c:otherwise>
										<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/> "
										class="btn btn-danger" id="updated" />
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