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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script type="text/javascript">
$(document).ready(function() {

		
	$( "#sDate" ).datepicker();
		$("#endDate").datepicker();
		$("#stDateEdit").datepicker();
		$("#endDateEdit").datepicker();
	
	});
</script>
<script type="text/javascript">


	$(document)
			.ready(
					function() {
						jQuery.validator.addMethod("alphaNumeric", function (value, element) {
							  
					        return this.optional(element) || /^[a-zA-Z&]+$/.test(value);
						});
						$("#subtnId")
								.click(
										function(event) {

											$("#addForm")
													.validate(
															{

																rules : {
																	employee : {
																		required : true, 
																		maxlength:50
															            
																	},
																	project : {
																		required : true
																	},
																	designation : {
																		required : true
																	},
																	stDate : {
																		required : true
																	},
																	endDate : {
																		required : true
																	},
																	prtype : {
																		required : true
																	},
																	stdCostHr : {
																		required : true
																	},
																	otCostHr : {
																		required : true
																	},
																	uom : {
																		required : true
																	},
																},
																messages : {
																	employee :"<font style='color: red;'><b>Employee name is Required</b></font>",
																	project : "<font style='color: red;'><b>Project  is Required</b></font>",
																	designation : "<font style='color: red;'><b>designation is Required</b></font>",
																	stDate : "<font style='color: red;'><b>Start date is Required</b></font>",
																	endDate : "<font style='color: red;'><b>End date is Required</b></font>",
																	prtype : "<font style='color: red;'><b>Project Resource Type is Required</b></font>",
																	stdCostHr : "<font style='color: red;'><b>Standard cost is Required</b></font>",
																	otCostHr : "<font style='color: red;'><b>Ordered Cost is Required</b></font>",
																	uom : "<font style='color: red;'><b>Uom is Required</b></font>",
																},

															});
										});
						

						$('#updateId ')
								.click(
										function(event) {
                                           
											$("#updatePRForm")
													.validate(
															{
																rules : {
																	employeeEdit : {
																		required : true, 
																		maxlength:50
															            
																	},
																	projectEdit : {
																		required : true
																	},
																	designationEdit : {
																		required : true
																	},
																	stDateEdit : {
																		required : true
																	},
																	endDateEdit : {
																		required : true
																	},
																	prtypeEdit : {
																		required : true
																	},
																	stdCostHrEdit : {
																		required : true
																	},
																	otCostHrEdit : {
																		required : true
																	},
																	uomEdit : {
																		required : true
																	},
																},
																messages : {
																	employeeEdit :"<font style='color: red;'><b>Employee name is Required</b></font>",
																	projectEdit : "<font style='color: red;'><b>Project  is Required</b></font>",
																	designationEdit : "<font style='color: red;'><b>designation is Required</b></font>",
																	stDateEdit : "<font style='color: red;'><b>Start date is Required</b></font>",
																	endDateEdit : "<font style='color: red;'><b>End date is Required</b></font>",
																	prtypeEdit : "<font style='color: red;'><b>Project Resource Type is Required</b></font>",
																	stdCostHrEdit : "<font style='color: red;'><b>Standard cost is Required</b></font>",
																	otCostHrEdit : "<font style='color: red;'><b>Ordered Cost is Required</b></font>",
																	uomEdit : "<font style='color: red;'><b>Uom is Required</b></font>",
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#subid').click(function(e) {

			var aid = document.getElementById("breakhide").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("breakhide").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

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
		<div class="PageTitle">Project Resource</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="projectResourceValues" items="${editvalues}">
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
					<form:form action="searchProjectResource.mnt" method="GET"
						commandName="ProjectResource">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.projectResource"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
											<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.projectResource"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="projResourceDel"
										items="${projResourceDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.projectResource"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="projResourceDelErr"
										items="${projResourceDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.projectResource"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="projResourceUpdate"
										items="${projResourceUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.projectResource"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="projResourceUpdateErr"
										items="${projResourceUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.projectResource"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
								
								
								</td></tr>
							
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="ProjectResource.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> <td><form:select path="employee" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${employee}" />
								</form:select></td></td>
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
								<c:when test="${true}"><input type="submit"
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

					<c:forEach var="projectResourceList" items="${projectResourceList}">
						<c:set var="sf" value="${projectResourceList}"></c:set>
					</c:forEach>
					<c:if test="${sf!=null}">
						<display:table id="PResourceId" name="projectResourceList"
							requestURI="searchProjectResource.mnt" pagesize="5" class="table">
							 <display:column property="projectResource_Id" title="ProjectResourceId" media="none"
								sortable="true"></display:column> --%>
							<display:column property="employee" titleKey="label.employee"
								media="html" sortable="true"></display:column>
							<display:column property="project" titleKey="label.project"
								media="html" sortable="true"></display:column>
							<display:column property="designation" titleKey="label.designation"
								media="html" sortable="true"></display:column>
							<display:column property="stDate" titleKey="label.stdate"
								media="html" sortable="true"></display:column>
							<display:column property="endDate" titleKey="label.enddate"
								media="html" sortable="true"></display:column>
								<display:column property="prtype" titleKey="label.projectResourceType"
								media="html" sortable="true"></display:column>
								<display:column property="stdCostHr" titleKey="label.stdCostHr"
								media="html" sortable="true"></display:column>
							<display:column property="otCostHr" titleKey="label.otCostHr"
								media="html" sortable="true"></display:column>
							<display:column property="uom" titleKey="label.uom"
								media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
								<c:when test="${edit}"><a
									href="projectResourceEdit.mnt?projectResourceEdit=<c:out value="${PResourceId.projectResource_Id}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when><c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
								<c:when test="${delete}"><a
									href="projectResourceDelete.mnt?projectResourceDelete=<c:out value="${PResourceId.projectResource_Id}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
							</c:when><c:otherwise>
							
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

					<form:form action="addProjectResource.mnt"
						commandName="ProjectResource" method="post"  id="addForm">
						<table class="tableGeneral">

							<form:hidden path="aid" id="aid" />
							<tr>
								<td colspan="2"><c:forEach var="PRSuccessDup"
										items="${PRSuccessDup}">
										<div class="alert-warning" id="savemessage">
											<c:out value="${PRSuccessDup}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.employee" /><span
									class="required">*</span></td>
									<td><form:select path="employee" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${employee}" />
								</form:select></td>
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
								<td><spring:message code="label.designation" /><span
									class="required">*</span></td>
									<td><form:select path="designation" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${designation}" />
								</form:select></td>
								</tr>
							<tr>
									<td><spring:message code="label.stDate" /><font
										color="red">*</font></td>
									<td><form:input path="stDate" id="sDate"
											class="textbox" /></td>
								</tr>
								
									<tr>
									<td><spring:message code="label.endDate" /><font
										color="red">*</font></td>
									<td><form:input path="endDate" id="endDate"
											class="textbox" /></td>
								</tr>
							
							<tr>
								<td><spring:message code="label.prtype" /><span
									class="required">*</span></td>
									<td><form:select path="prtype" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${prtype}" />
								</form:select></td>
								</tr>
							
							<tr>
									<td><spring:message code="label.stdCostHr" /><font
										color="red">*</font></td>
									<td><form:input path="stdCostHr" id="stdCostHr"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.otCostHr" /><font
										color="red">*</font></td>
									<td><form:input path="otCostHr" id="otCostHr"
											class="textbox" /></td>
								</tr>
							
								<tr>
									<td><spring:message code="label.uom" /><span
									class="required">*</span></td>
									<td><form:select path="uom" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${uom}" />
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
					<c:forEach var="editvalues" items="${editvalues }">
						<form:form action="projectResourceUpdate.mnt" method="POST"
							commandName="ProjectResource" id="updatePRForm">
							<table class="tableGeneral">
							
							<form:hidden path="projectResource_IdEdit" id="projectResource_IdEdit" />
							
							<tr>
								<td colspan="2"><c:forEach var="projResourceUpDup"
										items="${projResourceUpDup}">
										<div class="alert-warning" id="savemessage">
											<c:out value="${projResourceUpDup}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							
							
								<tr>
								<td><spring:message code="label.employee" /><span
									class="required">*</span></td>
									<td><form:select path="employeeEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${employee}" />
								</form:select></td>
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
								<td><spring:message code="label.designation" /><span
									class="required">*</span></td>
									<td><form:select path="designationEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${designation}" />
								</form:select></td>
								</tr>
							<tr>
									<td><spring:message code="label.stDate" /><font
										color="red">*</font></td>
									<td><form:input path="stDateEdit" id="stDateEdit"
											class="textbox" /></td>
								</tr>
								
									<tr>
									<td><spring:message code="label.endDate" /><font
										color="red">*</font></td>
									<td><form:input path="endDateEdit" id="endDateEdit"
											class="textbox" /></td>
								</tr>
							
							<tr>
								<td><spring:message code="label.prtype" /><span
									class="required">*</span></td>
									<td><form:select path="prtypeEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${prtype}" />
								</form:select></td>
								</tr>
							
							<tr>
									<td><spring:message code="label.stdCostHr" /><font
										color="red">*</font></td>
									<td><form:input path="stdCostHrEdit" id="stdCostHr"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.otCostHr" /><font
										color="red">*</font></td>
									<td><form:input path="otCostHrEdit" id="otCostHr"
											class="textbox" /></td>
								</tr>
							
								<tr>
									<td><spring:message code="label.uom" /><span
									class="required">*</span></td>
									<td><form:select path="uomEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${uom}" />
								</form:select></td>
								</tr>
						<tr>
									<td colspan="2"><c:choose><c:when test="${update }"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateId" /></c:when><c:otherwise>
										<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/> "
										class="btn btn-danger" id="updated" />
										</c:otherwise></c:choose></td>
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