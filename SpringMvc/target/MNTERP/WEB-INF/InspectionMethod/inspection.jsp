<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author Srinivas
 @version 1.0    -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
											
											$('#addinspectionform')
													.validate(
															{
																rules : {
																	inspectionmethod : {
																		required : true },
																	
																},
																messages : {
																	inspectionmethod : "<font style='color: red;'><b>Inspection Method is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updated')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert(assetedit);
											$('#editinspectionForm')
													.validate(
															{
																rules : {
																	inspectionmethodedit : {
																		required : true
																	},

																},
																messages : {
																	inspectionmethodedit : "<font style='color: red;'><b>Inspection Method is Required</b></font>"
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
		$('#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("inspectionmethodhide").value == 1) {
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
			var aid = document.getElementById("inspectionmethodhide").value = 1;
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
		<div class="PageTitle">Inspection</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchInspectionMethod.mnt" method="GET"
						commandName="InspectionMethod">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="accountsuccess"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="InspectionMethodUpdate"
										items="${InspectionMethodUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${InspectionMethodUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td>Inspection Method</td>
								<td><form:select path="inspectionmethodid" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${inspectionmethodSearch}" />
								</form:select></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary"/></td>
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
					</form:form>

					<c:forEach var="inspectionMethodBeans"
						items="${inspectionMethodBeans}">
						<c:set var="ag" value="${inspectionMethodBeans}"></c:set>
					</c:forEach>
					<c:if test="${ag!=null}">
						<display:table id="inspectionid" name="inspectionMethodBeans"
							requestURI="searchInspectionMethod.mnt" pagesize="5"
							class="table">
							<display:column property="inspectionmethodid"
								title="AccountGroupID" media="none" sortable="true"></display:column>
							<display:column property="inspectionmethod" title="Inspection Method"
								media="html" sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<a
									href="inspectionEdit.mnt?inspectionedit=<c:out value="${inspectionid.inspectionmethodid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column title="Delete">
								<a
									href="inspectionDelete.mnt?inspectiondelete=<c:out value="${inspectionid.inspectionmethodid}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>
					</c:if>

				</div>
			</div>

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
				<form:form action="saveInspection.mnt" method="POST"
							commandName="InspectionMethod" id="addinspectionform">
					<table class="tableGeneral">

						<tr>
							<td colspan="2"><c:forEach var="inspectionsuccessdup"
									items="${inspectionsuccessdup}">
									<div class="alert-warning" id="successmessage">
										
							
									<font color="red"> 	<c:out value="${inspectionsuccessdup}"></c:out></font>
									</div>
								</c:forEach></td>
						</tr>
						
							<form:hidden path="inspectionmethodhide" />	
							<tr>
							<td><spring:message code="label.inspectionmethod" /><span
									class="required">*</span> <form:input path="inspectionmethod"
										class="textbox"  /></td>						
								
								
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
					<c:forEach var="InspectionMethodEditValues" items="${editvalues }">
						<form:form action="inspectionMethodUpdate.mnt" method="POST"
							commandName="InspectionMethod" id="editinspectionForm">
							<table class="tableGeneral">
							<td colspan="2"><c:forEach var="inspectionsuccessdupedit"
									items="${inspectionsuccessdupedit}">
									<div class="alert-warning" id="successmessage">
										
									<font color="red">	<c:out value="${inspectionsuccessdupedit}"></c:out></font>
									</div>
								</c:forEach></td>
                                     <form:hidden path="inspectionmethodhideedit" />
								<form:hidden path="inspectionmethodidedit" />
								<tr>
								<td><spring:message code="label.inspectionmethod" /><span
									class="required">*</span> <form:input path="inspectionmethodedit"
										class="textbox"  /></td>	
								</tr>

								<tr>
									<td colspan="2"><input type="submit"
										value="Update" class="btn btn-primary" id="updated"/></td>
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




