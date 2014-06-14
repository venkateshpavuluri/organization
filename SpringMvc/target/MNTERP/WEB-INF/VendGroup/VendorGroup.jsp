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
$(document).ready(function() {
	$('#subtnId').click(function(event) {
		//alert($('#sdType').val());
		//alert("ljls");
		$("#vendorGroupAdd1").validate({
			rules : {
				vendorGroup : {required : true},
				vendorGroupCode:{required : true}
			},
			messages : {
				vendorGroup : "<font style='color: red;'><b>Vendor Group is Required</b></font>",
				vendorGroupCode:"<font style='color: red;'><b>Vendor Group Code is Required</b></font>"
			},

		});
	});
	
	$('#updatetId').click(function(event) {
		
		$("#updateForm").validate({
			rules : {
				editVendorGroup : {required : true},
				editVendorGroupCode:{required : true}
				
			},
			messages : {
				editVendorGroup : "<font style='color: red;'><b>Vendor Group is Required</b></font>",
				editVendorGroupCode:"<font style='color: red;'><b>Vendor Group Code is Required</b></font>"
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

		$('#search,#add').click(function(e) {
			$('#edit').hide();
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

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {

			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

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

		$("#add").click(function(e) {

			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

		});
	});
</script>


</head>
<body>

	<div class="divUserDefault">
		<div class="PageTitle">Vendor Group</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vgValues" items="${vgvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="VendGroupSearch.mnt" method="GET"
						commandName="vendorGroupAdd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="vupadted"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success! </strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="vupadted"
										items="${vupadte}">
										<div class="alert-success" id="successmessage">
											<strong>Success! </strong>
											<c:out value="${vupadted}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="vendorUpdated"
										items="${vendorUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success! </strong>
											<c:out value="${vendorUpdated}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="vdeleted"
										items="${vdelete}">
										<div class="alert-success" id="successmessage">
											<strong>Success! </strong>
											<c:out value="${vdeleted}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="vdup"
										items="${param.list1}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning! </strong>
											<c:out value="${param.warning}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="vedup"
										items="${param.list2}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning! </strong>
											<c:out value="${param.warning}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td>&nbsp;&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2"></td>
							</tr>
							<%-- <tr>
								<td>Vendor Group Id:</td>
								<td><form:input path="vendorGroup_Id" cssClass="textbox"/></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary" /></td>
							</tr>
 --%>
 <tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> 
									<form:select path="operations" cssClass="select">										
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
					</form:form>
					<%-- <c:forEach var="vgSearch" items="${vgTypeSearch}">
	<c:set var="g" value="${vgSearch}"></c:set></c:forEach>
	<c:if test="${g!=null}"> --%>
					<display:table id="VendorGroup" name="VendorGroup"
						requestURI="VendGroupSearch.mnt" pagesize="5" class="table">

						<display:column property="vendorGroup" title="Vendor Group"
							media="html" sortable="true" />
						<display:column property="vendorGroupCode"
							title="Vendor Group Code" media="html" sortable="true" />
						<display:column title="Edit" style="color:white">
							<a
								href="VendorGroupEditHome.mnt?VendorGroupEdit=<c:out value="${VendorGroup.vendorGroup_Id}"/>"
								style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a>
						</display:column>
						<display:column title="Delete">
							<a
								href="VendorGroupDelete.mnt?vendorGroupDelete=<c:out value="${VendorGroup.vendorGroup_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:setProperty name="paging.banner.placement" value="bottom" />
						<display:setProperty name="paging.banner.group_size" value="3" />
						<display:setProperty name="paging.banner.some_items_found"
							value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />





					</display:table>
					<%-- </c:if> --%>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					

						<form:form action="vendorGroupAdd.mnt" method="POST"
							commandName="vendorGroupAdd" id="vendorGroupAdd1">
							<form:hidden path="aid" />
							<table class="tableGeneral">
							<tr>
								<td colspan="2" height="20px"><c:forEach
										var="addVendGroupDuplicate" items="${addVendGroupDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${addVendGroupDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td>Vendor Group:</td>
								<td><form:input path="vendorGroup" id="vendorGroup"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Vendor Group Code:</td>
								<td><form:input path="vendorGroupCode" id="vendorGroupCode"
										class="textbox" /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Save" id="subtnId"
									class="btn btn-primary" /><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
							</table>
						</form:form>

					

				</div>
			</div>

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="vgValues" items="${vgvalues}">
						<form:form action="VendorGroupEdit.mnt" method="POST"
							commandName="vendorGroupAdd" id="updateForm">
							<table class="tableGeneral">
								<%-- <form:hidden path="aid" /> --%>
								<tr>
									<td colspan="2" height="20px"><c:forEach
											var="addVendGroupDuplicate" items="${addVendGroupDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out
														value="${addVendGroupDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="editVendorGroup_Id" />
								<tr>
									<td>Vendor Group</td>
									<td><form:input path="editVendorGroup" id="vendorGroup"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Vendor Group Code</td>
									<td><form:input path="editVendorGroupCode"
											id="vendorGroupCode" class="textbox" /></td>
								</tr>
								<tr>
									<td colspan="2" ><input type="submit"
										value="Update" class="btn btn-primary" id="updatetId"/></td>
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




