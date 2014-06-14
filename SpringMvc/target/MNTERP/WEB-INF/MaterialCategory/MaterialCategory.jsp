
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>


<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#submitadd')
								.click(
										function(event) {

											$("#materialCategoryAdd")
													.validate(
															{
																rules : {
																	materialCategory : {
																		required : true
																	},
																	materialCategoryCode : {
																		required : true
																	}
																},
																messages : {
																	materialCategory : "<font style='color: red;'><b>Material Category is Required</b></font>",
																	materialCategoryCode : "<font style='color: red;'><b>Material Category Code is Required</b></font>"
																},

															});
										});

						$('#materailudate')
								.click(
										function(event) {

											$("#materailCategoryUpdate")
													.validate(
															{
																rules : {
																	materialCategoryEdit : {
																		required : true
																	},
																	materialCategoryCodeEdit : {
																		required : true
																	}

																},
																messages : {
																	materialCategoryEdit : "<font style='color: red;'><b>Material Category is Required</b></font>",
																	materialCategoryCodeEdit : "<font style='color: red;'><b>Material Category Code is Required</b></font>"
																},

															});
										});
					});
</script>
<script>
	$(function() { /*  jldsfgjl;jg;dsgl;df */
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
		if (document.getElementById("duplicateMessage").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

		if (document.getElementById("duplicateMessageEdit").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-1"]').get(0));

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
		<div class="PageTitle">Material Category</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialCategoryValues"
					items="${materialCategoryValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>


				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>

			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="materialCategorySearch.mnt" method="get"
						commandName="materialCategoryForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="materialCategoryUpadted"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong></strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="materialCategoryUpadted"
										items="${materialUpadte}">
										<div class="alert-success" id="successmessage">
											<strong></strong>
											<c:out value="${materialUpadte}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td>Material Category</td>
								<td><form:input path="materialCategory" class="textbox" /></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary"/></td>
							</tr> --%>
							<tr>
								<td><s:message code="label.searchby" /></td>
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
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>
							

						</table>
					</form:form>

					<c:forEach var="materialSearch" items="${materialCategorySearch}">
						<c:set var="g" value="${materialCategorySearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="materialRow" name="materialCategorySearch"
							requestURI="materialCategorySearch.mnt" pagesize="5"
							class="table">

							<display:column property="materialCategory"
								title="Material Category" media="html" sortable="true"></display:column>
							<display:column property="materialCategoryCode"
								title="Material Category Code" media="html" sortable="true" />

							<display:column title="Edit" style="color:white">
								<a
									href="materialCategoryEdit.mnt?materialCategoryEdit=<c:out value="${materialRow.materialCategoryId}"/>"
									style="color: red"><img src="images/Edit.jpg" title="Edit"
									width="20px" height="20px" /> </a>
							</display:column>

							<display:column title="Delete">
								<a
									href="materialCategoryDelete.mnt?materialCategoryDelete=<c:out value="${materialRow.materialCategoryId}"/>"
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
					<form:form action="materialCategoryAdd.mnt" method="POST"
						commandName="materialCategoryForm" id="materialCategoryAdd">

						<table class="tableGeneral">

							<tr>
								<td colspan="2" height="50px"><form:hidden
										path="duplicateMessage" id="duplicateMessage" /> <c:forEach
										var="materialDuplicateAddValue"
										items="${materialDuplicateAdd}">
										<div class="alert-warning" id="successmessage">
											<strong></strong>
											<c:out value="${materialDuplicateAddValue}"></c:out>
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td>Material Category<label style="color: red;">*</label></td>
								<td><form:input path="materialCategory"
										id="materialCategory" class="textbox" /></td>
							</tr>
							<tr>
								<td>Material Category Code<label style="color: red;">*</label></td>
								<td><form:input path="materialCategoryCode"
										id="materialCategoryCode" class="textbox" /></td>
							</tr>


							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="submitadd" /><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="materialCategoryEditValues"
						items="${materialCategoryValues }">
						<form:form action="materialCategoryUpdate.mnt" method="POST"
							commandName="materialCategoryForm" id="materailCategoryUpdate">
							<table class="tableGeneral">

								<form:hidden path="materialCategoryIdEdit" />
								<tr>
									<td colspan="2" height="50px"><form:hidden
											path="duplicateMessageEdit" id="duplicateMessageEdit" /> <c:forEach
											var="materialDuplicateAddEditValue"
											items="${materialDuplicateAddEdit}">
											<div class="alert-warning" id="successmessage">
												<strong></strong>
												<c:out value="${materialDuplicateAddEditValue}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<%-- <tr><td>Materia Category</td><td><form:input path="materialCategoryIdEdit" id="materialCategoryId"  class="textbox" /> </td> </tr> --%>
								<tr>
									<td>Materia Category<label style="color: red;">*</label></td>
									<td><form:input path="materialCategoryEdit"
											id="materialCategory" class="textbox" /></td>
								</tr>
								<tr>
									<td>Material Category Code<label style="color: red;">*</label></td>
									<td><form:input path="materialCategoryCodeEdit"
											id="materialCategoryCode" class="textbox" /> <form:hidden
											path="materialCategoryEditUpdate" /><input type="hidden"
										name="materialCategoryValuesForword"
										value="${materialCategoryValues}" /></td>
								</tr>


								<tr>
									<td colspan="2" align="center"><input type="submit"
										value="Update" class="btn btn-primary" id="materailudate" /></td>
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




