<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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
	$(document)
			.ready(
					function() {
						$('#' + "sumbnid")
								.click(
										function(event) {
											//alert($('#privilege').val());
											$("#addPrivilegeForm")
													.validate(
															{

																rules : {
																	privilege : {
																		required : true
																	},
																},
																messages : {
																	privilege : "<font style='color: red;'><b> Privilege is Required</b></font>"
																},

															});
										});

						$('#updbut')
								.click(
										function(event) {

											$("#updatePrivilegeForm")
													.validate(
															{
																rules : {
																	privilegeEdit : {
																		required : true
																	},
																},
																messages : {
																	privilegeEdit : "<font style='color: red;'><b> Privilege is Required</b></font>"
																},

															});
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

		$('#search').click(function(e) {
			$('#edit').hide();

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

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Privilege</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="privilegeValues" items="${privilegeValues}">
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

					<form:form action="privilegeSearch.mnt" method="get"
						commandName="privilegeAdd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach
										items="${param.list}">
										<div class="alert-success" >
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.privilege"/> <spring:message code="label.saveSuccess"/>
										</div></c:forEach>
										
										<c:forEach
										items="${param.listwar}">
										<div class="alert-success" >
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.privilege"/> <spring:message code="label.saveFail"/>
										</div></c:forEach>
										
										
						<c:forEach items="${privilegeUpadteSuccess}">
										<div class="alert-success">
										<strong><spring:message code="label.success"/></strong>
										<spring:message code="label.privilege"/> <spring:message code="label.updateSuccess"/>
										
										</div>
									</c:forEach>
									
									
									<c:forEach 
										items="${privilegeUpadteFail}">
									<div class="alert-success">
										<strong><spring:message code="label.error"/></strong>
										<spring:message code="label.privilege"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
									
									<c:forEach items="${privilegeDeleteSuccess}">
										<div class="alert-success">
										<strong><spring:message code="label.success"/></strong>
										<spring:message code="label.privilege"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
									
										<c:forEach 
										items="${privilegeDeleteFail}">
									<div class="alert-danger">
										<strong><spring:message code="label.error"/></strong>
										<spring:message code="label.privilege"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>
									
									
									
									</td>
							</tr>
							<tr>
								<td width="15%"><spring:message code="label.searchby" /></td>

								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="privilegeAdd.operations">
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
									
										<c:set
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
									

								<td>
								<c:choose>
								<c:when test="${search}">
								
								
								<input type="submit" value="Search"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" value="Search" disabled="disabled"
									class="btn btn-danger" />
									</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>

					<c:forEach var="privilegeSearch" items="${privilegeSearch}">
						<c:set var="g" value="${privilegeSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="privilegeRow" name="privilegeSearch"
							requestURI="privilegeSearch.mnt" pagesize="5" class="table">

							<display:column property="privilege" titleKey="label.privilege"
								media="html" sortable="true"></display:column>

							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit }">
							
							
								<a
									href="privilegeEditHome.mnt?privilegeDetEdit=<c:out value="${privilegeRow.privilegeid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
									height="20px" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
								<a
									href="privilegeDelete.mnt?privilegeidDelete=<c:out value="${privilegeRow.privilegeid}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img
									src="images/Delete.jpg" width="20px" height="20px"  class="btn btn-danger"/> </a>
									</c:otherwise>
									
							</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
							<display:setProperty name="paging.banner.group_size" value="3" />
							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>
					</c:if>

				</div>
			</div>



			<!---================================ Add tab =======================================-->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="privilegeAdd.mnt" method="GET"
						commandName="privilegeAdd" id="addPrivilegeForm">

						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${PrivilegeDuplicate }">
										<div class="alert-warning">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.privilege"/> <spring:message code="label.duplicateCheck"/>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="privilegeid" />

							<tr>
								<td><spring:message code="label.privilege" /><span
									class="required">*</span></td>
								<td><form:input path="privilege" id="privilege"
										class="textbox" maxlength="50"/></td>
							</tr>
							<form:hidden path="aid" />

							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${save}">
								
								
								<input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /></c:when>
									<c:otherwise>
									<input type="submit" value="Save" disabled="disabled"
									class="btn btn-danger" id="sumbnid" />
									</c:otherwise>
								</c:choose><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="privilegeEditValues" items="${privilegeValues }">
						<form:form action="privilegeUpdate.mnt" method="POST"
							id="updatePrivilegeForm" commandName="privilegeAdd">
							<table class="tableGeneral">
								
								
								<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${privilegeEditDuplicate }">
											<div class="alert-warning">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.privilege"/> <spring:message code="label.duplicateCheck"/>
										</div>
										</c:forEach></td>
								</tr>
								
								<form:hidden path="privilegeidEdit" />

								<tr>
									<td><spring:message code="label.privilege" /><span
										class="required">*</span></td>
									<td><form:input path="privilegeEdit" id="privilegeEdit"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td colspan="2">
									
									<c:choose>
									<c:when test="${update}">
									<input type="submit" value="Update"
										id="updbut" class="btn btn-primary" /></c:when>
										<c:otherwise>
											<input type="submit" value="Update"
										id="updbut" class="btn btn-danger"  disabled="disabled"/>
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




