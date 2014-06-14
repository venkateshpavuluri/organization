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
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#' + "subtnId")
								.click(
										function(event) {

											$("#addForm")
													.validate(
															{

																rules : {
																	payGrade_Id : {
																		required : true,
																		
																	},

																	payElement_Id : {
																		required : true
																	},
																	amount_Formulae : {
																		required : true
																	},
																	include : {
																		required : true
																	},
																	
																},
																messages : {
																	payGrade_Id :"<font style='color: red;'><b>PayGrade is Required</b></font>",
																		
																	payElement_Id : "<font style='color: red;'><b>PayElement is Required</b></font>",
																	amount_Formulae : "<font style='color: red;'><b>Amount is Required</b></font>",
																	include : "<font style='color: red;'><b>include is Required</b></font>",
																	},

															});
										});

						$('#updateId ')
								.click(
										function(event) {

											$("#upBreakForm")
													.validate(
															{
																rules : {
																	payGrade_IdEdit : {
																		required : true,
																		
																	},

																	payElement_IdEdit : {
																		required : true
																	},
																	amount_FormulaeEdit : {
																		required : true
																	},
																	includeEdit : {
																		required : true
																	},
																	
																},
																messages : {
																	payGrade_IdEdit :"<font style='color: red;'><b>PayGrade is Required</b></font>",
																	
																	payElement_IdEdit : "<font style='color: red;'><b>PayElement is Required</b></font>",
																	amount_FormulaeEdit : "<font style='color: red;'><b>Amount is Required</b></font>",
																	includeEdit : "<font style='color: red;'><b>include is Required</b></font>",
																		},

															});
										});

					});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

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

<body>
        <div class="divUserDefault">
		<div class="PageTitle">PayGradeSalElement</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="breakValues" items="${editvalues}">
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
					<form:form action="searchPayGradeSalElement.mnt" method="GET"
						commandName="PayGradeSalElement">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">
								
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.payGradeSalElement"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
											<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.payGradeSalElement"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="payGradeDel"
										items="${payGradeDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.payGradeSalElement"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="payGradeDelErr"
										items="${payGradeDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.payGradeSalElement"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="payGradeUpdate"
										items="${payGradeUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.payGradeSalElement"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="payGradeUpdateErr"
										items="${payGradeUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.payGradeSalElement"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
								
								</td></tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="PayGradeSalElement.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
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
								<c:when test="${true}">
								<input type="submit"
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

					
					<c:if test="${payGradeBeans!=null}">
						<display:table id="payGradeId" name="payGradeBeans"
							requestURI="searchPayGradeSalElement.mnt" pagesize="5" class="table">
							<display:column property="payGradeSalElement_Id" title="PayGradeSalElement_Id" media="none"
								sortable="true"></display:column>
							<display:column property="payGrade_Id" titleKey="label.payGrade"
								media="html" sortable="true"></display:column>
							<display:column property="payElement_Id" titleKey="label.payElement"
								media="html" sortable="true"></display:column>
							<display:column property="amount_Formulae" titleKey="label.amount"
								media="html" sortable="true"></display:column>
							<display:column property="include" titleKey="label.include"
								media="html" sortable="true"></display:column>
								
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true}">
								<a
									href="PayGradeSalElementEdit.mnt?payGradeEdit=<c:out value="${payGradeId.payGradeSalElement_Id}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
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
									href="PayGradeSalElementDelete.mnt?paygradeDelete=<c:out value="${payGradeId.payGradeSalElement_Id}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
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

					<form:form action="addPayGradeSalElement.mnt"
						commandName="PayGradeSalElement" method="post"  id="addForm">
						<table class="tableGeneral">


                             <tr>
								<td colspan="2"><c:forEach var="payGradesuccessdup"
										items="${payGradesuccessdup}">
										<div class="alert-warning" id="successmessage">

											<c:out value="${payGradesuccessdup}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							
							<form:hidden path="aid" id="aid" />
							<tr>
								<td><spring:message code="label.payGrade" /><span
									class="required">*</span></td>
									<td><form:select path="payGrade_Id" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${payGrade}" />
								</form:select></td>
								</tr>
								<tr>
								<td><spring:message code="label.payElement" /><span
									class="required">*</span></td>
									<td><form:select path="payElement_Id" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${payElement}" />
								</form:select></td>
								</tr>
							<tr>
								<td><spring:message code="label.amount" /></td>
								<td><form:input path="amount_Formulae" id="length" name="length"
										class="textbox"  /></td>
							</tr>
							<tr>
								<td><spring:message code="label.include" /><span
									class="required">*</span></td>
									<td><form:select path="include" class="select">
										<form:option value="">--Select--</form:option>
								         <form:option value="True">True</form:option>
								         <form:option value="False">False</form:option>
								</form:select></td>
								</tr>
												
													
								<tr>
								<td colspan="2"><c:choose>
							<c:when test="${true}"><input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/> " class="btn btn-danger"
									id="orgTypeSubmit" />
									</c:otherwise>
							</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="PayGradeEditValues" items="${editvalues }">
						<form:form action="PayGradeSalElementUpdate.mnt" method="POST"
							commandName="PayGradeSalElement" id="upBreakForm">
							<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="payGradeUpdatedup"
										items="${payGradeUpdatedup}">
										<div class="alert-warning" id="successmessage">

											<c:out value="${payGradeUpdatedup}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="payGradeSalElement_IdEdit" id="payGradeSalElement_IdEdit" />
								<tr>
								<td><spring:message code="label.payGrade" /><span
									class="required">*</span></td>
									<td><form:select path="payGrade_IdEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${payGrade}" />
								</form:select></td>
								</tr>
								<tr>
								<td><spring:message code="label.payElement" /><span
									class="required">*</span></td>
									<td><form:select path="payElement_IdEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${payElement}" />
								</form:select></td>
								</tr>
							<tr>
								<td><spring:message code="label.amount" /></td>
								<td><form:input path="amount_FormulaeEdit" id="length" name="length"
										class="textbox"  /></td>
							</tr>
							<tr>
								<td><spring:message code="label.include" /><span
									class="required">*</span></td>
									<td><form:select path="includeEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:option value="True">True</form:option>
								         <form:option value="False">False</form:option>
								</form:select></td>
								</tr>
										
						<tr>
									<td colspan="2"><c:choose>
								<c:when test="${true}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateId" /></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/> "
										class="btn btn-danger" id="updateId" />
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