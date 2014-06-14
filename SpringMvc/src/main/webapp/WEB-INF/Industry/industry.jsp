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
						//AddForm Validations
						$('#sumbnid')
								.click(
										function(event) {
											//alert($('#sdType').val());
											
											$('#addindustryform')
													.validate(
															{
																rules : {
																	industryType : {
																		required : true },
																	
																},
																messages : {
																	industryType : "<font style='color: red;'><b>Industry Type is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updated')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert(assetedit);
											$('#editindustryForm')
													.validate(
															{
																rules : {
																	industryTypeEdit : {
																		required : true
																	},

																},
																messages : {
																	industryTypeEdit : "<font style='color: red;'><b>Industry Type is Required</b></font>"
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
		<div class="PageTitle">Industry</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="industryValues" items="${industryValues}">
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
					<form:form action="searchIndustry.mnt" commandName="industry"
						method="GET">
						<body>
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="addIndustrySuccess"
											items="${param.addIndustrySuccess}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.addIndustrySuccess}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>

								<tr>
									<td colspan="2"><c:forEach var="industryUpdate"
											items="${param.industryUpdate}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.industryUpdate}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="industryDelete"
											items="${param.industryDelete}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.industryDelete}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>

								
								<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="industry.operations">
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

						</body>
					</form:form>

					<c:forEach var="industrySearch" items="${industrySearch}">
						<c:set var="i" value="${industrySearch}"></c:set>
					</c:forEach>

					<c:if test="${i!=null}">
						<display:table id="industryRow" name="industrySearch"
							requestURI="searchIndustry.mnt" pagesize="5" class="table">
							<display:column property="industryTypeId" title="IndustryTypeId"
								media="none" sortable="true"></display:column>
							<display:column property="industryType" titleKey="label.industrytype"
								media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit }">
								<a
									href="industryEditHome.mnt?industryTypeIdEdit=<c:out value="${industryRow.industryTypeId}"/>"
									style="color: red"> <img src="images/Edit.jpg" width="20px"
									height="20px" />
								</a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
								<a
									href="industryDelete.mnt?industryTypeIdDelete=<c:out value="${industryRow.industryTypeId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
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
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="addIndustry.mnt" commandName="industry"
						method="post" id="addindustryform">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addIndustryDuplicate"
										items="${addIndustryDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${addIndustryDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" id="aid" />
							<tr>
								<td><spring:message code="label.industrytype"/><span class="required">*</span></td>
								<td><form:input path="industryType" class="textbox" maxlength="250"/></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><c:choose>
							<c:when test="${save }">
								<input type="submit" value="<spring:message code="label.save"/>"
									id="sumbnid" class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/> " class="btn btn-danger"
									id="orgTypeSubmit" />
									</c:otherwise>
							</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>" class="btn btn-primary" /></td>
							</tr>
						</table>

					</form:form>

				</div>
			</div>

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="industryEditValues" items="${industryValues }">
						<form:form action="industryUpdate.mnt" method="POST"
							commandName="industry" id="editindustryForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="updateIndustryDuplicate"
											items="${updateIndustryDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out
														value="${updateIndustryDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="industryTypeIdEdit" />
								<tr>
									<td><spring:message code="label.industrytype"/><span class="required">*</span></td>
									<td><form:input path="industryTypeEdit" class="textbox" maxlength="250"/>
									</td>
								</tr>
								<tr>
									<td colspan="2" ><c:choose>
								<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-primary" id="updated"/></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/> "
										class="btn btn-danger" id="orgTypeSubmitupdate" />
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