
<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 19-09-2013 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="/resources/demos/style.css" />

<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
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
					
						$('#stockSubmit')
								.click(
									
										function(event) {
											
											$("#stockForm")
													.validate(
															{
																rules : {
																	stockCategoryName : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	}
																},
																messages : {
																	stockCategoryName :{
																		required : "<font style='color: red;'><b>Stock Category is Required.</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																		
																	}
																},

															});
										});

						$('#stockSubmitupdate')
								.click(
										function(event) {

											$("#stockUpdate")
													.validate(
															{
																rules : {
																	stockCategoryNameEdit : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	},
																},
																messages : {
																	stockCategoryNameEdit :{
																		required : "<font style='color: red;'><b>Stock Category is Required.</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																		
																	}
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
<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

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
		$('#search').click(function(e) {
			$('#edit').hide();

		});
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


</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Stock Category</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${stockCategoryEditValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /> </a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /> </a></li>
			</ul>

			<!--=================== ============================================Begin OrgTypeSearch================================================= -->
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">


					<form:form action="stockCategorySearch.mnt" method="get"
						commandName="stockCategoryForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach  items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/> </strong>
											<s:message code="label.stockCategory"/> <s:message code="label.saveSuccess"/>
										</div>
									</c:forEach>

									<c:forEach 
										items="${param.listw}">
										<div class="alert-danger" id="savemessage">
												<strong><s:message code="label.error"/> </strong>
											<s:message code="label.stockCategory"/> <s:message code="label.saveFail"/>
										</div>
										
									</c:forEach><c:forEach items="${stockCategoryUpdate}">
										<div class="alert-success" id="successmessage">
												<strong><s:message code="label.success"/> </strong>
											<s:message code="label.stockCategory"/> <s:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach items="${stockCategoryUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/> </strong>
											<s:message code="label.stockCategory"/> <s:message code="label.updateFail"/>
										</div>
									</c:forEach>
									<c:forEach items="${stockCategoryDelete}">
										<div class="alert-success" id="successmessage">
												<strong><s:message code="label.success"/> </strong>
											<s:message code="label.stockCategory"/> <s:message code="label.deleteSuccess"/>
										</div>
									</c:forEach>
								<c:forEach items="${stockCategoryDeleteError}">
										<div class="alert-danger" id="successmessage">
												<strong><s:message code="label.error"/> </strong>
											<s:message code="label.stockCategory"/> <s:message code="label.deleteFail"/>
										</div>
									</c:forEach>
									
									
									
									
									</td>
							</tr>
							<%-- <tr>
								<td><s:message code="label.organizationTypeName" /></td>
								<td><form:select path="orgTypeId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${organizationIds}" />
								</form:select></td>
								<td><input type="submit"
									value="<s:message code="label.search"/> "
									class="btn btn-primary"/></td>
							</tr> --%>
							<tr>
								<td><s:message code="label.searchby" /> </td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select>  <s:bind path="stockCategoryForm.operations">
								<select class="select" name="operations">
								<option value="<s:message code='assignedOperator'/>"><s:message code="label.equalsTo"/> </option>
								<option value="<s:message code='notequalsOperator'/>"><s:message code="label.notEqualsTo"/> </option>
							 <option value="<s:message code='beginsWithOperator'/>"> <s:message code="label.beginsWith"/> </option> 
								<option value="<s:message code='endsWithOperator'/>"><s:message code="label.endsWith"/> </option>
								<option value="<s:message code='containsOperator'/>"><s:message code="label.contains"/></option>
								</select>
									 </s:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
									 
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
								<c:when test="${search }">
								
								<input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<s:message code="label.search"/>"
									class="btn btn-danger" />
									</c:otherwise>
								</c:choose></td>
							</tr>
							

						</table>
					</form:form>
					<!--=================== ============================================End OrgTypeSearch================================================= -->

					<!--=================== ============================================Begin DisplayTable================================================= -->
					<c:forEach var="stockCategoryDisplay"
						items="${stockCategoryDisplay}">
						<c:set var="g" value="${stockCategoryDisplay}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">

						<display:table id="stockCategoryRow"
							name="stockCategoryDisplay"
							requestURI="stockCategorySearch.mnt" pagesize="5"
							class="table">
							<display:column property="stockCategoryName"
								titleKey="label.stockCategory" media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit }">
								<a
									href="stackCategoryEditHome.mnt?stockCategoryedit=<c:out value="${stockCategoryRow.stockCategoryId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px" class="btn btn-danger" height="20px" /> </a>
									
									</c:otherwise>
									</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete }">
								<a
									href="stockCategoryDelete.mnt?stockCategoryDelete=<c:out value="${stockCategoryRow.stockCategoryId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /> </a>
									</c:otherwise>
									</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

							
						</display:table>
					</c:if>
					<c:set var="noData" value="${stockCategoryNoData}"></c:set>
					<c:if test="${noData!=null}">
						<c:out value="${noData}"></c:out>
					</c:if>
				</div>
			</div>
			<!--=================== ============================================End DisplayTable================================================= -->


			<!--=================== ============================================Begin OrgTypeAdd================================================= -->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table class="tableGeneral">
						<tr>
							<td colspan="2"><c:forEach var="stockSuccessdup"
									items="${stockSuccessdup}">
									<div class="alert-warning">
									<strong><s:message code="label.warning"/> </strong>
									<s:message code="label.stockCategory"/>	<s:message code="label.duplicateCheck"/>								</div>
								</c:forEach></td>
						</tr>
					</table>
					<form:form action="stockCategoryAdd.mnt" id="stockForm" 
					 onsubmit="return validateOrgType(this);"
						method="POST" commandName="stockCategoryForm">
						<%-- <form:hidden path="OrgTypeIdEdit" /> --%>
						<form:hidden path="aid" />
						<table>
							<tr>
								<td><s:message code="label.stockCategory" /><font
									color="red">*</font></td>
								<td><form:input path="stockCategoryName" id="stockCategory" class="textbox" maxlength="50"/>
								</td>
							</tr>
							<tr>
								<td>
								<c:choose>
								<c:when test="${save }">
								
							
								<input type="submit"
									value="<s:message code="label.save"/> " class="btn btn-primary"
									id="stockSubmit" />	</c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
									value="<s:message code="label.save"/> " class="btn btn-danger"
									id="stockSubmit" />
									</c:otherwise>
									</c:choose>
									<input type="reset"
									value="<s:message code="label.reset"/> "
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>


				</div>
			</div>
			<!--=================== ============================================End OrgTypeAdd================================================= -->

			<!--=================== ============================================Begin OrgTypeEdit================================================= -->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="stockCategoryEdit"
						items="${stockCategoryEditValues}">

						<form:form action="stockCategoryUpdate.mnt" method="POST"
							commandName="stockCategoryForm" id="stockUpdate">
							<table>
								<tr>
									<td colspan="2"><c:forEach var="stockUpdateDuplicate"
											items="${stockUpdateDuplicate}">
											<div class="alert-warning">
											<strong><s:message code="label.warning"/> </strong>
									<s:message code="label.stockCategory"/>	<s:message code="label.duplicateCheck"/>
											</div>
										</c:forEach></td>
								</tr> 
								<form:hidden path="stockCategoryIdEdit" />
								<tr>
									<td><s:message code="label.stockCategory" /><font
										color="red">*</font></td>
									<td><form:input path="stockCategoryNameEdit" id="stockCategoryEdit"
											class="textbox" maxlength="50"/></td>
								</tr>

								<tr>
									<td>
									<c:choose>
									<c:when test="${update}">			
									<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-primary" id="stockSubmitupdate" />
											</c:when>
											<c:otherwise>
											<input type="submit" disabled="disabled"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" id="stockSubmitupdate" />
											</c:otherwise>
											</c:choose>
										
										</td>
								</tr>
							</table>
						</form:form>
						<!--=================== ============================================End OrgTypeEdit================================================= -->

					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




