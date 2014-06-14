<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						
						//AddForm Validations
						$('#subtnId').click(function(event) {
							$('#addForm').validate({
								rules : {
									prodOrderType : {
										required : true,
										alphanumeric : true,
										specialcharacters: true
									},
									
								},
								messages : {
									prodOrderType :{
										required: "<font style='color: red;'><b>Production OrderType is Required</b></font>",
										alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
										specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
											
											},
								},
									});
										});
					
						//UpdateForm Validations
						$('#updated').click(function(event) {
							$('#editForm').validate({
												rules : {
													prodOrderTypeNameEdit : {
														required : true,
														alphanumeric : true,
														specialcharacters: true
													},
																	
																},
																messages : {
																	prodOrderTypeNameEdit : {
																		required: "<font style='color: red;'><b>Production OrderType is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																	
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#tabsForEdit").hide();
			$("#warningmesssage").hide();

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
<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
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
color:red
}
</style>
</head>
<body>

	<div class="divUserDefault">
		<div class="PageTitle">Production Order Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="prodOrderTypeValues" items="${prodOrderTypeValues}">
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

					<form:form action="searchProdOrderType.mnt"
						commandName="ProdOrderType" method="get">

						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="prodOrderTypeSave"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.potid"/> <spring:message code="label.saveSuccess"></spring:message>
											
										</div>
									</c:forEach></td>
							</tr>
							
							<tr><td>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.potid"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								</td>
							</tr>
							
							<tr>
								<td colspan="2"><c:forEach var="prodOrderTypeUpdate"
										items="${prodOrderTypeUpdate}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.potid"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="prodOrderTypeUpdateError"
										items="${prodOrderTypeUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.potid"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
							<tr>
								<td colspan="2"><c:forEach var="prodOrderTypeDelete"
										items="${prodOrderTypeDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.potid"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
                         
                         <tr>
								<td colspan="2"><c:forEach var="prodOrderTypeDeleteError"
										items="${prodOrderTypeDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.potid"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
                         
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="ProdOrderType.operations">
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
							
							<c:if test="${prodOrderTypeSearch!=null}">


								<display:table id="prodOrderTypeRow" name="prodOrderTypeSearch"
									requestURI="searchProdOrderType.mnt" pagesize="10"
									class="table">
									<display:column property="prodOrderTypeId"
										title="prodOrderTypeId" media="none" sortable="true"></display:column>
									<display:column property="prodOrderType"
										titleKey="label.potid" media="html" sortable="true"></display:column>
									<display:column titleKey="label.edit" style="color:white">
									<c:choose>
							<c:when test="${edit }">
										<a
											href="prodOrderTypeEditHome.mnt?prodOrderTypeIdEdit=<c:out value="${prodOrderTypeRow.prodOrderTypeId}"/>"
											style="color: red"> <img src="images/Edit.jpg"
											width="20px" height="20px" />
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
											href="prodOrderTypeDelete.mnt?prodOrderTypeIdDelete=<c:out value="${prodOrderTypeRow.prodOrderTypeId}"/>"
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

					<form:form action="addProdOrderType.mnt"
						commandName="ProdOrderType" method="post" id="addForm">
						<table class="tableGeneral">

							<form:hidden path="aid" id="aid" />
							<tr>
								<td colspan="2"><c:forEach var="addProdOrderTypeDuplicate"
										items="${addProdOrderTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.potid"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.potid" /><span
									class="required">*</span>
								<form:input path="prodOrderType" class="textbox"
										maxlength="50" /></td>
							</tr>

							<tr>
								<td colspan="2"><c:choose>
							<c:when test="${save }"><input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/> " class="btn btn-danger"
									id="subtnId" />
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
					<c:forEach var="prodOrderTypeEditValues"
						items="${prodOrderTypeValues }">
						<form:form action="prodOrderTypeUpdate.mnt" method="POST"
							commandName="ProdOrderType" id="editForm">
							<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="prodOrderTypeUpdateCheck"
										items="${prodOrderTypeUpdateCheck}">
									<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.potid"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
								<form:hidden path="prodOrderTypeIdEdit" />
								<tr>
									<td><spring:message code="label.potid" /><span
										class="required">*</span>
									<form:input path="prodOrderTypeNameEdit"
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td colspan="2"><c:choose>
								<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when>
										<c:otherwise>
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