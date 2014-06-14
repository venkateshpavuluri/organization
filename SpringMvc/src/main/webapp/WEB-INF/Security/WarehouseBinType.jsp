
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>WarehouseBin Type</title>
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
	$(document)
			.ready(
					function() {
						$('#' + "sumbnid")
								.click(
										function(event) {
											//alert($('#privilege').val());
											$("#addWarehouseBinTypeForm")
													.validate(
															{

																rules : {
																	warehousebintype : {
																		required : true
																	},

																},
																messages : {
																	warehousebintype : "<font style='color: red;'><b> WarehouseBinType is Required</b></font>"
																},

															});
										});

						$('#updbut')
								.click(
										function(event) {

											$("#updateWarehouseBinTypeForm")
													.validate(
															{
																rules : {
																	warehousebintypeEdit : {
																		required : true
																	},
																},
																messages : {
																	warehousebintypeEdit : "<font style='color: red;'><b> WarehouseBinType is Required</b></font>"
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
		<div class="PageTitle">WarehouseBin Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="warehousebintypeValues"
					items="${warehousebintypeValues}">
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

					<form:form action="warehousebintypeSearch.mnt" method="get"
						commandName="warehousebintypeAdd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="warehousebintypeUpadted"
										items="${warehousebintypeSave}">
										<div class="alert-success" id="savemessage">
											<c:out value="${warehousebintypeSave}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="warehousebintypeUpadted"
										items="${warehousebintypeUpadteSuccess}">
										<div class="alert-success" id="successmessage">
											<c:out value="${warehousebintypeUpadteSuccess}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="warehousebintypeUpadted"
										items="${warehousebintypeUpadteFail}">
										<div class="alert-warning" id="successmessage">
											<c:out value="${warehousebintypeUpadteFail}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>

								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="warehousebintypeAdd.operations">
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
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>

						</table>
					</form:form>

					<c:forEach var="warehousebintypeSearch"
						items="${warehousebintypeSearch}">
						<c:set var="g" value="${warehousebintypeSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="warehousebintypeRow"
							name="warehousebintypeSearch"
							requestURI="warehousebintypeSearch.mnt" pagesize="5"
							class="table">

							<display:column property="warehousebintype"
								titleKey="label.warehousebinType" media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
								<a
									href="warehousebintypeEditHome.mnt?warehousebintypeDetEdit=<c:out value="${warehousebintypeRow.warehousebintypeId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>

							<display:column titleKey="label.delete">
								<a
									href="warehousebintypeDelete.mnt?warehousebintypeIdDelete=<c:out value="${warehousebintypeRow.warehousebintypeId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
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

					<form:form action="warehousebintypeAdd.mnt" method="GET"
						commandName="warehousebintypeAdd" id="addWarehouseBinTypeForm"
						onsubmit="return validateForm()">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="warehousebintypeUpadted"
										items="${warehousebintypeSaveFail}">
										<div class="alert-warning" id="savemessage">
											<c:out value="${warehousebintypeSaveFail}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${WarehouseBinTypeDuplicate }">
										<div class="alert-warning">
											<font color="red"> <c:out value="${a}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="warehousebintypeId" />

							<tr>
								<td><spring:message code="label.warehousebinType" /><span
									class="required">*</span></td>
								<td><form:input path="warehousebintype"
										id="warehousebintype" class="textbox" /></td>
							</tr>

							<form:hidden path="aid" />


							<tr>
								<td colspan="2"><input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbnid" /> <input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="warehousebintypeEditValues"
						items="${warehousebintypeValues }">
						<form:form action="warehousebintypeUpdate.mnt" method="POST"
							commandName="warehousebintypeAdd" id="updateWarehouseBinTypeForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="warehousebintypeUpadted"
											items="${warehousebintypeUpadteFail}">
											<div class="alert-danger" id="successmessage">
												<c:out value="${warehousebintypeUpadteFail}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${warehousebintypeEditDuplicate }">
											<div class="alert-warning">
												<font color="red"> <c:out value="${duplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="warehousebintypeUpadted"
											items="${warehousebintypeUpadte}">
											<div class="alert-warning" id="successmessage">
												<c:out value="${warehousebintypeUpadted}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="warehousebintypeIdEdit" />

								<tr>
									<td><spring:message code="label.warehousebinType" /><span
										class="required">*</span></td>
									<td><form:input path="warehousebintypeEdit"
											id="warehousebintype" class="textbox" /></td>
								</tr>



								<tr>
									<td colspan="2"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updbut" /></td>
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




