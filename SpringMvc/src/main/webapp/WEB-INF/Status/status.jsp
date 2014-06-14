<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											
											$('#addstatusform')
													.validate(
															{
																rules : {
																	status : {
																		required : true },
																	
																},
																messages : {
																	status : "<font style='color: red;'><b>Status is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
											
											$('#editstatusForm')
													.validate(
															{
																rules : {
																	statusEdit : {
																		required : true
																	},

																},
																messages : {
																	statusEdit : "<font style='color: red;'><b>Status is Required</b></font>"
																},
															});

										}); 

					});
</script>


<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
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
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>


</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Status Details</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="industryValues" items="${statusValues}">
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
					<form:form action="searchStatus.mnt" commandName="status"
						method="GET">
						<body>
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="addStatusSuccess"
											items="${param.addStatusSuccess}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.addStatusSuccess}">												</c:out>
											</div>
										</c:forEach></td>
								</tr>

								<tr>
									<td colspan="2"><c:forEach var="statusUpdate"
											items="${param.statusUpdate}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.statusUpdate}">												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								

								<%-- <tr>
									<td>Status: <form:select path="statusId" class="textbox">
											<form:option value="0">..select..</form:option>
											<form:options items="${statusSelect}" />
										</form:select> <input type="submit" value="search" class="btn btn-primary" />
									</td>
								</tr> --%>
								<tr>
								<td width="18%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> 
									 <spring:bind path="status.operations">
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
								
								
								
								<td>
								<c:choose>
								<c:when test="${search }">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" />
								</c:when>
								<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" />
								</c:otherwise>
								
								</c:choose>
								</td>
							</tr>
							</table>

</body>
					</form:form>

					<c:forEach var="statusSearch" items="${statusSearch}">
						<c:set var="i" value="${statusSearch}"></c:set>
					</c:forEach>

					<c:if test="${i!=null}">
						<display:table id="statusRow" name="statusSearch"
							requestURI="searchStatus.mnt" pagesize="5" class="table">
							<display:column property="statusId" title="statusId" media="none"
								sortable="true"></display:column>
							<display:column property="status" titleKey="label.status" media="html"
								sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
							
							
								<a
									href="statusEditHome.mnt?statusIdEdit=<c:out value="${statusRow.statusId}"/>"
									style="color: red"> <img src="images/Edit.jpg" width="20px"
									height="20px" />
								</a></c:when>
								<c:otherwise>
								<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"/> </a>
								</c:otherwise>
							</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
							
							
								<a
									href="statusDelete.mnt?statusIdDelete=<c:out value="${statusRow.statusId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img
									src="images/Delete.jpg" width="20px" height="20px" class="btn btn-danger" /> </a>
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
					<form:form action="addStatus.mnt" commandName="status"
						method="post" id="addstatusform">
						<table class="tableGeneral">
							<tr>
								<td colspan="2" ><c:forEach var="addStatusDuplicate"
										items="${addStatusDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out value="${addStatusDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" id="aid" />
							<tr>
								<td><spring:message code="label.status"/><span class="required">*</span></td>
								<td><form:input path="status" class="textbox" maxlength="50"/></td>
							</tr>

							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${save}">
								<input type="submit" value="<spring:message code="label.save"/>"
									id="submitid" class="btn btn-primary" />
								
								</c:when>
								<c:otherwise>
								<input type="submit" value="<spring:message code="label.save"/>"
									id="submitid" class="btn btn-danger" disabled="disabled" />
								</c:otherwise>
								</c:choose>
								<input type="reset"
									value="<spring:message code="label.reset"/>" class="btn btn-primary" /></td>
							</tr>
						</table>

					</form:form>

				</div>
			</div>

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="statusEditValues" items="${statusValues }">
						<form:form action="statusUpdate.mnt" method="POST"
							commandName="status" id="editstatusForm">
							<table class="tableGeneral">
							<tr>
								<td colspan="2" ><c:forEach var="updateStatusDuplicate"
										items="${updateStatusDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out value="${updateStatusDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
								<form:hidden path="statusIdEdit" />
								<tr>
									<td><spring:message code="label.status"/><span class="required">*</span></td>
									<td><form:input path="statusEdit" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${update }">
									<input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-primary" id="updateid" />
									</c:when>
									<c:otherwise>
									<input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-danger" id="updateid"  disabled="disabled"/>
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