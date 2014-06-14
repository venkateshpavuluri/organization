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
						$('#subid')
								.click(
										function(event) {
											//alert("hai");
											$('#adduomform')
													.validate(
															{
																rules : {
																	uom : {
																		required : true },
																		uomCode:{
																			required : true	
																		},
																	
																},
																messages : {
																	uom : "<font style='color: red;'><b>UOM is Required</b></font>",
																	uomCode : "<font style='color: red;'><b>UOM Code is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
											
											$('#edituomform')
													.validate(
															{
																rules : {
																	editUom : {
																		required : true },
																		editUomCode:{
																			required : true	
																		},
																	
																},
																messages : {
																	editUom : "<font style='color: red;'><b>UOM is Required</b></font>",
																	editUomCode : "<font style='color: red;'><b>UOM Code is Required</b></font>"
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
			$("#warningmessage").hide();
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
			$("#warningmessage").hide();
		});
	});
</script>


</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">UOM</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="UomValues" items="${uomvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="uomSearch.mnt" method="get"
						commandName="measuresAdd">
						<table class="tableGeneral">
							<tr>
								<td>&nbsp&nbsp&nbsp</td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="uupdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="uupdate" items="${uupdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${uupdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="uupdated"
										items="${UomDelete}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${uupdated}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="uupdated"
										items="${UomUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${uupdated}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="uomdup"
										items="${param.list1}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning!</strong>
											<c:out value="${param.warning}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="uomedup"
										items="${param.list2}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning!</strong>
											<c:out value="${param.warning}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr><td colspan="2"><c:forEach var="materialUpadted" items="${materialUpadte}"><div class="alert-success"><strong>Sucess! --%>

							<%--  </strong><c:out value="${materialUpadted}"></c:out> </div> </c:forEach> </td></tr> --%>
							<%-- <tr>
								<td>UOM Id: <form:input path="uom_Id" cssClass="textbox"/><input
									type="submit" value="Search" id="searbut"
									class="btn btn-primary"/></td>
							</tr> --%>
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

					<display:table id="uom" name="uom" requestURI="uomSearch.mnt"
						pagesize="5" class="table">


						<%-- <display:column property="uom_Id" title="Uom_Id" media="html" sortable="true" ></display:column> --%>
						<display:column property="uom" title="UOM" media="html"
							sortable="true" />
						<display:column property="uomCode" title="UOM Code" media="html"
							sortable="true" />


						<display:column title="Edit" style="color:white">
							<a
								href="UomEditHome.mnt?uomEdit=<c:out 

value="${uom.uom_Id}"/>"
								style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a>
						</display:column>

						<display:column title="Delete">
							<a href="UomDelete.mnt?uomDelete=<c:out value="${uom.uom_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:setProperty name="paging.banner.placement" value="bottom" />

						<display:setProperty name="paging.banner.group_size" value="3" />

						<display:setProperty name="paging.banner.some_items_found"
							value="<span class='pagebanner'>{0} {1},listing {2} to {3}. 

</span>" />
					</display:table>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					

						<form:form action="measuresAdd.mnt" method="POST"
							commandName="measuresAdd" id="adduomform">
							<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2" height="20px"><c:forEach
										var="addUomDuplicate" items="${addUomDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out value="${addUomDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td>UOM <font color="red">*</font></td>
								<td><form:input path="uom" id="uom" class="textbox" /></td>
							</tr>
							<tr>
								<td>UOM Code <font color="red">*</font></td>
								<td><form:input path="uomCode" id="uomCode" class="textbox" /></td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="subid" /><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
							</table>
						</form:form>
					

				</div>
			</div>

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="UomValues" items="${uomvalues }">
						<form:form action="uomEdit.mnt" method="POST"
							commandName="measuresAdd" id="edituomform">
							<table class="tableGeneral">
								<%-- <form:hidden path="aid" /> --%>
								<tr>
									<td colspan="2" height="20px"><c:forEach
											var="addUomDuplicate" items="${addUomDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out value="${addUomDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>

								<tr>
									<td></td>
									<td><form:hidden path="editUom_id" id="editUom_id" /></td>
								</tr>
								<tr>
									<td>UOM</td>
									<td><form:input path="editUom" id="editUom" cssClass="textbox"/></td>
								</tr>
								<tr>
									<td>UOM Code</td>
									<td><form:input path="editUomCode" id="editUomCode" cssClass="textbox"/></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="Update"
										class="btn btn-primary" id="updateid"/></td>
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




