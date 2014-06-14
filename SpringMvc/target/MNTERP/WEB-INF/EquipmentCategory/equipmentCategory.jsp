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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											
											$('#addecategoryform')
													.validate(
															{
																rules : {
																	equipmentCategory : {
																		required : true },
																	
																},
																messages : {
																	equipmentCategory : "<font style='color: red;'><b>Equipment Category is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
											
											$('#editecategoryForm')
													.validate(
															{
																rules : {
																	equipmentCategoryEdit : {
																		required : true
																	},

																},
																messages : {
																	equipmentCategoryEdit : "<font style='color: red;'><b>Equipment Categoryis Required</b></font>"
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
		<div class="PageTitle">Equipment Category</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="equipmentCategoryValues"
					items="${equipmentCategoryValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="searchEquipmentCategory.mnt"
						commandName="equipmentCategory" method="GET">
						<body>
							<table class="tableGeneral">


								<tr>
									<td colspan="2"><c:forEach
											var="addEquipmentCategorySuccess"
											items="${param.addEquipmentCategorySuccess}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.addEquipmentCategorySuccess}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="equipmentCategoryUpdate"
											items="${param.equipmentCategoryUpdate}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.equipmentCategoryUpdate}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="equipmentCategoryDelete"
											items="${param.equipmentCategoryDelete}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.equipmentCategoryDelete}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>

								<%-- <tr>
									<td><spring:message code="label.equipmentcategory"/><form:select
											path="equipmentCategoryId" class="textbox">
											<form:option value="0">..select..</form:option>
											<form:options items="${selectEquipmentCategoryType}" />
										</form:select> <input type="submit" value="search" class="btn btn-primary" />
									</td>
								</tr> --%>
								
								<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">										
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>
								
							</table>

						</body>

					</form:form>

					<c:forEach var="equipmentCategorySearch"
						items="${equipmentCategorySearch}">
						<c:set var="i" value="${equipmentCategorySearch}"></c:set>
					</c:forEach>

					<c:if test="${i!=null}">
						<display:table id="equipmentCategoryRow"
							name="equipmentCategorySearch"
							requestURI="searchEquipmentCategory.mnt" pagesize="5"
							class="table">
							<display:column property="equipmentCategoryId"
								title="EquipmentCategoryId" media="none" sortable="true"></display:column>
							<display:column property="equipmentCategory"
								title="Equipment Category" media="html" sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<a
									href="equipmentCategoryEditHome.mnt?equipmentCategoryIdEdit=<c:out value="${equipmentCategoryRow.equipmentCategoryId}"/>"
									style="color: red"> <img src="images/Edit.jpg" width="20px"
									height="20px" />
								</a>
							</display:column>

							<display:column title="Delete">
								<a
									href="equipmentCategoryDelete.mnt?equipmentCategoryIdDelete=<c:out value="${equipmentCategoryRow.equipmentCategoryId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
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
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="addEquipmentCategory.mnt"
						commandName="equipmentCategory" method="post" id="addecategoryform">
						<table class="tableGeneral" >
							<tr>
								<td colspan="2" ><c:forEach
										var="addEquipmentCategoryDuplicate"
										items="${addEquipmentCategoryDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${addEquipmentCategoryDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" id="aid" />
							<tr>
								<td><spring:message code="label.equipmentcategory"/><span class="required">*</span></td>
								<td><form:input path="equipmentCategory" class="textbox" />
								</td>
							</tr>

							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Save"
									id="submitid" class="btn btn-primary" /><input type="reset"
									value="Reset" class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="equipmentCategoryEditValues"
						items="${equipmentCategoryValues }">
						<form:form action="equipmentCategoryUpdate.mnt" method="POST"
							commandName="equipmentCategory" id="editecategoryForm">
							<table class="tableGeneral">
							<tr>
								<td colspan="2" ><c:forEach
										var="updateEquipmentCategoryDuplicate"
										items="${updateEquipmentCategoryDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${updateEquipmentCategoryDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
								<form:hidden path="equipmentCategoryIdEdit" />
								<tr>
									<td><spring:message code="label.equipmentcategory"/><span class="required">*</span></td>
									<td><form:input path="equipmentCategoryEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td colspan="2" ><input type="submit"
										value="Update" class="btn btn-primary" id="updateid" /></td>
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




