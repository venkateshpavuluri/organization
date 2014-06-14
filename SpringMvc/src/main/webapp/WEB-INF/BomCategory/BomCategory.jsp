<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#sumbnid')
								.click(
										function(event) {

											$("#bomCategoryadd")
													.validate(
															{
																rules : {
																	bomCategory : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	bomCategory : {
																		required : "<font style='color: red;'><b>BOM Category is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	}
																},

															});
										});

						$('#subbtnId')
								.click(
										function(event) {

											$("#bomCategoryedit")
													.validate(
															{
																rules : {
																	bomCategoryEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	bomCategoryEdit : {
																		required : "<font style='color: red;'><b>BOM Category is Required</b></font>",
																		alphaNumeric : "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
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
	$(document)
			.ready(
					function() {
						if (document
								.getElementById("duplicateMessageBomCategory").value == 1) {
							var index = $('#tabs li a').index(
									$('a[href="#tabs-3"]').get(0));

							$('#tabs').tabs({
								active : index
							});
						}

						if (document
								.getElementById("duplicateMessageBomCategoryUpdate").value == 1) {
							var index = $('#tabs li a').index(
									$('a[href="#tabs-1"]').get(0));

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
		$('#add,#search').click(function(event) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">BOM Category</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="bomCategoryValues" items="${bomCategoryValues}">
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
					<form:form action="bomCategorySearch.mnt" method="get"
						commandName="bomCategoryForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${param.success}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.bomcategory" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${addfail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.bomcategory" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${bomUpadte}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.bomcategory" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${updatefail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.bomcategory" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${deleteSus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.bomcategory" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${deletefail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.bomcategory" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td width="15%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
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

					<c:if test="${bomCategorySearch!=null}">
						<display:table id="bomRow" name="bomCategorySearch"
							requestURI="bomCategorySearch.mnt" pagesize="5" class="table">

							<display:column property="bomCategory"
								titleKey="label.bomcategory" media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
								<a
									href="bomCategoryEdit.mnt?bomCategoryEdit=<c:out value="${bomRow.bomCategoryId}"/>"
									style="color: red"><img src="images/Edit.jpg" title="Edit"
									width="20px" height="20px" /> </a>
							</display:column>

							<display:column titleKey="label.delete">
								<a
									href="bomCategoryDelete.mnt?bomCategoryDelete=<c:out value="${bomRow.bomCategoryId}"/>"
									onclick="return confirm('Do You Want To Delete This Record?')"
									style="color: red"><img src="images/Delete.jpg"
									title="Delete" width="20px" height="20px" /></a>
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

					<form:form action="bomCategoryAdd.mnt" method="POST"
						commandName="bomCategoryForm" id="bomCategoryadd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="bomCategoryDuplicateAdd"
										items="${bomCategoryDuplicateAdd}">
										<div class="alert-warning" id="savemessage">
											<strong> <spring:message code="label.warning" /></strong>
											<c:out value="${bomCategoryDuplicateAdd}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><form:hidden path="duplicateMessageBomCategory"
										id="duplicateMessageBomCategory" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.bomcategory" /><label
									style="color: red">*</label></td>
								<td><form:input path="bomCategory" id="bomCategory"
										class="textbox" maxlength="50" /></td>
							</tr>

							<tr>

								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="sumbnid"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="sumbnid" disabled="disabled"
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
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="bomCategoryEditValues"
						items="${bomCategoryValues }">
						<form:form action="bomCategoryUpdate.mnt" method="POST"
							commandName="bomCategoryForm" id="bomCategoryedit">

							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach
											var="bomCategoryDuplicateUpdate"
											items="${bomCategoryDuplicateUpdate}">
											<div class="alert-warning" id="savemessage">
												<strong> <spring:message code="label.warning" /></strong>
												<c:out value="${bomCategoryDuplicateUpdate}"></c:out>
											</div>
										</c:forEach></td>
								</tr>

								<tr>
									<td><form:hidden path="duplicateMessageBomCategoryUpdate"
											id="duplicateMessageBomCategoryUpdate" /></td>
								</tr>
								<form:hidden path="bomCategoryIdEdit" />
								<%--  <tr><td>Bom Id</td><td><form:input path="bomCategoryIdEdit" id="bomCategoryId"  class="textbox" /> </td> </tr> --%>
								<tr>
									<td><spring:message code="label.bomcategory" /> <label
										style="color: red">*</label></td>
									<td><form:input path="bomCategoryEdit" id="bomCategory"
											class="textbox" maxlength="50" /></td>
									<form:hidden path="bomCategoryEditUpdate" />
									<td><input type="hidden" name="bomCategoryValuesForword"
										value="${bomCategoryValues}" /></td>

								</tr>
								<tr>
									<c:choose>

										<c:when test="${update}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="subbtnId" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="subbtnId" /></td>
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




