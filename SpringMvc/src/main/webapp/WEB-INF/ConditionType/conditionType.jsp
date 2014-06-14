<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'AssertTypeTemplate.jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
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
	$(document)
			.ready(
					function() {
						jQuery.validator.addMethod("alphabets", function(value,
								element) {
							return this.optional(element)
									|| /^[A-Za-z][A-Za-z0-9!@#$%^&*()_+:;?><~ ]*$/
											.test(value);
						});

						jQuery.validator
								.addMethod(
										"alphanumeric",
										function(value, element) {
											return this.optional(element)
													|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+:;?><~ ]*$/
															.test(value);
										});

						jQuery.validator.addMethod("specialcharacters",
								function(value, element) {
									return this.optional(element)
											|| /^[0-9a-zA-Z&_ ]+$/.test(value);
								});
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {
											//alert($('#sdType').val());
											$('#addForm')
													.validate(
															{
																rules : {
																	conditionType : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	conditionType : {
																		required:"<font style='color: red;'><b>Condition Type is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											
											//alert(assetedit);
											$('#editForm')
													.validate(
															{
																rules : {
																	conditionTypeEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},

																},
																messages : {
																	conditionTypeEdit : {
																		required:"<font style='color: red;'><b>Condition Type is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																},
															});

										});

					});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("ctId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnasid').click(function(e) {
			document.getElementById("ctId").value = 1;
			//alert(document.getElementById("atId").value);
		});
	});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("ctIdEdit").value == 1) {
			//alert("Hai");
			var index = $('#tabs li a').index($('a[href="#tabs-1"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$('#updateid').click(function(e) {
			document.getElementById("ctIdEdit").value = 1;
			//alert(document.getElementById("ateditId").value);

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
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Condition Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="conditionTypeEdit" items="${conditionTypeEdit}">
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
				<div align="left" class="TabbedPanelsContent">
					<form:form method="get" action="conditionTypeSearch.mnt"
						commandName="conditionTypeCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">
							<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.conditionType"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.conditionType"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										<c:forEach var="conDel"
										items="${conDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.conditionType"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="conDelErr"
										items="${conDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.conditionType"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="conditionTypeUpdte"
										items="${conditionTypeUpdte}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.conditionType"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="conditionTypeUpdteErr"
										items="${conditionTypeUpdteErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.conditionType"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
							
							</td></tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="conditionTypeCmd.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
						 	 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind><form:input path="basicSearchId" cssClass="textbox" /></td>
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

						</table>
					</form:form>

					<c:if test="${conditionTypeBean!=null }">
						<display:table name="conditionTypeBean" id="conditionTypeList" class="table"
							requestURI="conditionTypeSearch.mnt" pagesize="5">
							<display:column property="conditionTypeId" sortable="true"
								title="condition Type Id" media="none" />
							<display:column property="conditionType" sortable="true"
								titleKey="label.conditionType" media="html" />

							<display:column titleKey="label.edit">
							<c:choose>
							<c:when test="${edit}">
								<a
									href="conditionTypeEdit.mnt?conditionTypeId=<c:out value="${conditionTypeList.conditionTypeId}"/> "><img
									src="images/Edit.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
								<a
									href="conditionTypeDelete.mnt?conditionTypeId=<c:out value="${conditionTypeList.conditionTypeId}"/> "
									onclick="return confirm('Do You Want To Delete This Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
							</display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>

					</c:if>

				</div>

			</div>

			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="conditionTypeAdd.mnt" id="addForm" method="POST"
						commandName="conditionTypeCmd">
						<table class="tableGeneral">
							<form:hidden path="ctId" />
							 <tr>
								<td colspan="2"><c:forEach var="addConditionTypeDuplicate"
										items="${addConditionTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.conditionType"/> <spring:message code="label.duplicateCheck"></spring:message>
													</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.conditionType" /><span
									class="required">*</span> <form:input path="conditionType"
										class="textbox" id="conditionTypeId" maxlength="50"/></td>


							</tr> 
							
							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${save}">
								<input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" />
									</c:when>
									<c:otherwise>
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

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="conditionTypeEditValues" items="${conditionTypeEdit}">

						<form:form method="GET" action="conditionTypeUpdate.mnt"
							commandName="conditionTypeCmd" id="editForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="updateCTDuplicate"
											items="${updateCTDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.conditionType"/> <spring:message code="label.duplicateCheck"></spring:message>
													</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="ctIdEdit" id="ctIdEdit" />
								<form:hidden path="conditionTypeIdEdit" />
								<tr>
									<td><spring:message code="label.conditionType" /><span
										class="required">*</span></td>
									<td><form:input path="conditionTypeEdit"
											cssClass="textbox" maxlength="50"/></td>

								</tr>
								<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${update}">
									<input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when>
										<c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
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
