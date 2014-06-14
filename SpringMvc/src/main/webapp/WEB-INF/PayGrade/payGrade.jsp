<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {
											$('#addForm')
													.validate(
															{
																rules : {
																	payGrade : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},

																},
																messages : {
																	payGrade : {
																		required: "<font style='color: red;'><b>PayGrade is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																},
															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											$('#editForm')
													.validate(
															{
																rules : {
																	epayGrade : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},

																},
																messages : {
																	epayGrade : {
																		required: "<font style='color: red;'><b>PayGrade is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																},
															});
										});

					});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("pgId").value == 1) {

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
			document.getElementById("pgId").value = 1;
			//alert(document.getElementById("atId").value);
		});
	});
</script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#payGrade').val('');

		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Pay Grade</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="payGradeEdit" items="${payGradeEdit}">
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
					<form:form method="get" action="payGradeSearch.mnt"
						commandName="payGradeCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addpayGradesus"
										items="${param.addpayGradesus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.paygrade" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach>
									<c:forEach var="addpayGradeFail"
										items="${param.addpayGradeFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.paygrade" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach>
									<c:forEach var="updatepayGradesus"
										items="${param.updatepayGradesus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.paygrade" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach>
									<c:forEach var="updatepayGradeFail"
										items="${param.updatepayGradeFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.paygrade" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach>
									<c:forEach var="deletepayGradesus"
										items="${param.deletepayGradesus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.paygrade" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach>
									<c:forEach var="deletepayGradeFail"
										items="${param.deletepayGradeFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.paygrade" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="payGradeCmd.operations">
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
					
					<c:if test="${payGradeList!=null }">
						<display:table name="payGradeList" id="jobsList" class="table"
							requestURI="payGradeSearch.mnt" pagesize="5">
							<display:column property="payGradeId" sortable="true"
								title="payGradeId" media="none" />
							<display:column property="payGrade" sortable="true"
								titleKey="label.paygrade" media="html" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="payGradeEdit.mnt?payGradeId=<c:out value="${jobsList.payGradeId}"/> "><img
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
											href="payGradeDelete.mnt?payGradeId=<c:out value="${jobsList.payGradeId}"/> "
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
				<div align="left" class="TabbedPanelsContent">

					<form:form action="payGradeAdd.mnt" id="addForm" method="POST"
						commandName="payGradeCmd">
						<table class="tableGeneral">
							<form:hidden path="pgId" />
							<tr>
								<td colspan="2"><c:forEach var="addpayGradeDuplicate"
										items="${addpayGradeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong> <spring:message code="label.warning" /></strong>
											<c:out value="${addpayGradeDuplicate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.paygrade" /><span
									class="required">*</span>
								<form:input path="payGrade" class="textbox"
										id="payGrade" /></td>

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
										<td><input type="submit" id="subtnId"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="subtnId" disabled="disabled"
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
					<c:forEach var="payGradeEdit" items="${payGradeEdit}">

						<form:form method="post" action="payGradeUpdate.mnt"
							commandName="payGradeCmd" id="editForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="updatepayGradeDuplicate"
											items="${updatepayGradeDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong> <spring:message code="label.warning" /></strong>
												<c:out value="${updatepayGradeDuplicate}"></c:out>
											</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="epayGradeId" />
								<tr>
									<td><spring:message code="label.paygrade" /><span
										class="required">*</span></td>
									<td><form:input path="epayGrade" cssClass="textbox" /></td>

								</tr>
								<tr>
									<c:choose>

										<c:when test="${update}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updated" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updated" /></td>
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