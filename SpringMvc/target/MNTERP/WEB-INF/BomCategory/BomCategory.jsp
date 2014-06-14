
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

<script type="text/javascript">
$(document).ready(function() {
	$('#sumbnid').click(function(event) {
		//alert($('#sdType').val());
		//alert("ljls");
		$("#bomCategoryadd").validate({
			rules : {
				bomCategory : {required : true},
			},
			messages : {
				bomCategory : "<font style='color: red;'><b>BOM Category is Required</b></font>"
			},

		});
	});
	
	$('#subbtnId').click(function(event) {
		
		$("#bomCategoryedit").validate({
			rules : {
				bomCategoryEdit : {
					required : true
				},
			},
			messages : {
				bomCategoryEdit : "<font style='color: red;'><b>BOM Category is Required</b></font>"
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
		$('#add').click(function(event) {
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
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="bomCategorySearch.mnt" method="get"
						commandName="bomCategoryForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong></strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="bomCategoryUpadted"
										items="${bomUpadte}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${bomUpadte}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td>BOM Category</td>
								<td><form:input path="bomCategory" class="textbox" /></td>
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

					<c:forEach var="bomSearch" items="${bomCategorySearch}">
						<c:set var="g" value="${bomCategorySearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="bomRow" name="bomCategorySearch"
							requestURI="bomCategorySearch.mnt" pagesize="5" class="table">

							<display:column property="bomCategory" title="BOM Category"
								media="html" sortable="true"></display:column>


							<display:column title="Edit" style="color:white">
								<a
									href="bomCategoryEdit.mnt?bomCategoryEdit=<c:out value="${bomRow.bomCategoryId}"/>"
									style="color: red"><img src="images/Edit.jpg" title="Edit"
									width="20px" height="20px" /> </a>
							</display:column>

							<display:column title="Delete">
								<a
									href="bomCategoryDelete.mnt?bomCategoryDelete=<c:out value="${bomRow.bomCategoryId}"/>"
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
								<td colspan="2" height="50px;"><form:hidden
										path="duplicateMessageBomCategory"
										id="duplicateMessageBomCategory" />
									<c:forEach var="bomCategoryDuplicateAddValue"
										items="${bomCategoryDuplicateAdd}">
										<div class="alert-warning" id="successmessage">
											<strong></strong>
											<c:out value="${bomCategoryDuplicateAddValue}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td>BOM Category<label style="color: red">*</label></td>
								<td><form:input path="bomCategory" id="bomCategory"
										class="textbox" /></td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid"/><input
										type="reset" class="btn btn-primary"/></td>
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
									<td colspan="2" height="50px;"><form:hidden
											path="duplicateMessageBomCategoryUpdate"
											id="duplicateMessageBomCategoryUpdate" />
										<c:forEach var="bomCategoryDuplicateUpdateValue"
											items="${bomCategoryDuplicateUpdate}">
											<div class="alert-warning" id="successmessage">
												<strong></strong>
												<c:out value="${bomCategoryDuplicateUpdateValue}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="bomCategoryIdEdit" />
								<%--  <tr><td>Bom Id</td><td><form:input path="bomCategoryIdEdit" id="bomCategoryId"  class="textbox" /> </td> </tr> --%>
								<tr>
									<td>BOM Category <label style="color: red">*</label></td>
									<td><form:input path="bomCategoryEdit" id="bomCategory"
											class="textbox" /></td>
									<form:hidden path="bomCategoryEditUpdate" />
									<td><input type="hidden" name="bomCategoryValuesForword" value="${bomCategoryValues}" /></td>
										
								</tr>
								<tr>
									<td colspan="2" ><input type="submit"
										value="Update" class="btn btn-primary" id="subbtnId"/></td>
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




