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
<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>

<script type="text/javascript">
$(document).ready(function() {
	$('#posubmit').click(function(event) {
		//alert($('#sdType').val());
		//alert("ljls");
		$("#poADD").validate({
			rules : {
				purOrg : {required : true},
				plantId: {required : true},
				orgId : {required : true}
			},
			messages : {
				purOrg : "<font style='color: red;'><b>Purchase Organization is Required</b></font>",
				plantId : "<font style='color: red;'><b>Select atleast one Plant type</b></font>",
				orgId :"<font style='color: red;'><b>Select atleast one Company Type</b></font>"
			},

		});
	});
	
	$('#poUpdate').click(function(event) {
		
		$("#poUdate").validate({
			rules : {
				editpurOrg : {required : true},
				editplantId: {required : true},
				editorgId : {required : true}
				
			},
			messages : {
				editpurOrg : "<font style='color: red;'><b>Purchase Organization is Required</b></font>",
				editplantId : "<font style='color: red;'><b>Select atleast one Plant Type</b></font>",
				editorgId :"<font style='color: red;'><b>Select atleast one Company Type</b></font>"
			},

		});
	});
});
</script>
<script>
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs").tabs();
	});

	$(function() {
		$("#tabsForAdd").tabs();
	});
	$(function() {
		$("#tabsForEdit").tabs();
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});
</script>



</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Purchase Organization</div>

		<!-- Tabs Declaration -->

		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="povalues" items="${povalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>

			<!-- Search tab part -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<table class="tableGeneral">
						<tr>
							<td>&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2"><c:forEach var="uupdate"
									items="${param.list}">
									<div class="alert-success" id="savemessage">
										<strong>Success! </strong>
										<c:out value="${param.success}"></c:out>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td colspan="2"><c:forEach var="uupdate" items="${pUpadte}">
									<div class="alert-success" id="successmessage">
										<strong>Success! </strong>
										<c:out value="${uupdate}"></c:out>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td colspan="2"><c:forEach var="podup"
									items="${param.list1}">
									<div class="alert-warning" id="warningmesssage">
										<strong>Warning! </strong>
										<c:out value="${param.warning}"></c:out>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td colspan="2"><c:forEach var="poedup"
									items="${param.list2}">
									<div class="alert-warning" id="warningmesssage">
										<strong>Warning! </strong>
										<c:out value="${param.warning}"></c:out>
									</div>
								</c:forEach></td>
						</tr>
						<%-- <tr><td colspan="2"><c:forEach var="pdeleted" items="${pdelete}"><div class="alert-success" id="successmessage"><strong>Success!</strong><c:out value="${pdeleted}"></c:out></div> </c:forEach> </td></tr>
					<tr><td colspan="2"><c:forEach var="podup" items="${param.list1}"><div class="alert-warning" id="warningmessage"><strong>Warning!</strong><c:out value="${param.warning}"></c:out></div> </c:forEach> </td></tr>
					 --%>
						<form:form action="posearch.mnt" method="GET" commandName="poadd">
							<%-- <tr>
								<td>Purchase Organization Id:</td>
								<td><form:input path="purOrg" id="purOrg" class="textbox" /></td>
								<td><input type="submit" value="Search" name="Search"
									id="sumbnid" class="btn btn-primary" /></td>
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
						</form:form>
					</table>

					<!-- Displaying  the Searched information by using display tag -->

					<display:table id="purchaseOrganization"
						name="purchaseOrganization" requestURI="posearch.mnt" pagesize="4"
						class="table">
						<%-- <display:column property="purOrg_Id" title="purOrg_Id" media="html" sortable="true" ></display:column> --%>
						<display:column property="purOrg" title="Purchase Organization"
							media="html" sortable="true"></display:column>
						<%--  <display:column property="plantName" title="plantName" media="html" sortable="true"/>
		 		<display:column property="orgName" title="orgName"  media="html" sortable="true"/> --%>
						<display:column title="Edit" style="color:white">
							<a
								href="purOrgEditHome.mnt?purOrgEdit=<c:out value="${purchaseOrganization.purOrg_Id}"/>"
								style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a>
						</display:column>
						<display:column title="Delete">
							<a
								href="purOrgDelete.mnt?purOrgDelete=<c:out value="${purchaseOrganization.purOrg_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
						</display:column>

						<!-- For displaying the pagination part -->

						<display:setProperty name="paging.banner.placement" value="bottom" />
						<display:setProperty name="paging.banner.group_size" value="3" />
						<display:setProperty name="paging.banner.some_items_found"
							value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
					</display:table>

				</div>
			</div>

			<!-- Add tab details -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="PlantAdd.mnt" method="POST" commandName="poadd" id="poADD">
						<table class="tableGeneral">

							<form:hidden path="aid" />
							<tr>
								<td colspan="2" height="20px"><c:forEach
										var="addPurchaseOrganizationDuplicate"
										items="${addPurchaseOrganizationDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${addPurchaseOrganizationDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<!-- <tr><td></td> </tr> -->
							<tr>
								<td>Purchase Organization<font color="red">*</font></td>
								<td><form:input path="purOrg" id="purOrg" class="textbox" />
								</td>
								<td><font color="red"></font></td>
							</tr>
							<!-- <tr><td colspan="2"><input  type="submit" value="Save" class="btn btn-primary" id="sumbnid"><input type="reset" class="btn btn-primary"> </td> </tr>
						</table> -->
						</table>

						<!-- Sub tabbing for adding plants and company details -->
						<div id="tabsForAdd">
							<ul>
								<li><a href="#tabs-1">Plant</a></li>
								<li><a href="#tabs-2">Company</a></li>
							</ul>
							<!-- Plant Details tab -->
							<div id="tabs-1">
								<div align="left">
									<!-- Selecting the plant details -->
									<table class="tableGeneral">
										<tr>
											<td width="75px">Plant</td>
											<td><form:select path="plantId" multiple="true"
													id="plantId" class="select">
													<%-- <form:option value="..Select.." >--Select--</form:option> --%>
													<form:options items="${PurOrgPlant}" />
												</form:select></td>
											<td><font color="red"> <form:errors
														path="plantId"></form:errors></font></td>
										</tr>
									</table>
									<div id="extender"></div>
								</div>
							</div>

							<!-- Company Details tab -->
							<div id="tabs-2">
								<div align="left">
									<table class="tableGeneral">
										<tr>
											<td width="75px">Company</td>
											<td><form:select path="orgId" multiple="true" id="orgId"
													class="select">
													<%-- <form:option value="..Select.." >--Select--</form:option> --%>
													<form:options items="${PurOrgCompany}" />
												</form:select></td>
											<td><font color="red"> <form:errors path="orgId"></form:errors></font>
											</td>
											<!-- <td><a href="#" id="addoc"><img src="images/add (1).png""></img></a></td> -->
										</tr>
									</table>
									<div id="extender"></div>
								</div>
							</div>
						</div>

						<input type="submit" value="Save" name="Save"
							class="btn btn-primary" id="posubmit"/>
						<input type="reset" class="btn btn-primary" />

					</form:form>
				</div>
			</div>
			<!-- Edit tab -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="povalues" items="${povalues}">
						<form:form action="poedit.mnt" method="POST" commandName="poadd" id="poUdate">
							<div id="tabsForEdit">
								<table class="tableGeneral">
									<%-- <form:hidden path="aid" /> --%>
									<tr>
										<td colspan="2" height="20px"><c:forEach
												var="addPurchaseOrganizationDuplicate"
												items="${addPurchaseOrganizationDuplicate}">
												<div class="alert-warning" id="savemessage">
													<font color="red"><c:out
															value="${addPurchaseOrganizationDuplicate}"></c:out></font>
												</div>
											</c:forEach></td>
									</tr>

									<form:hidden path="purOrg_Id" id="purOrg_Id" />
									<tr>
										<td>Purchase Organization:</td>
										<td><form:input path="editpurOrg" id="editpurOrg"
												class="textbox" /></td>
									</tr>
									<!-- <tr><td colspan="2"><input  type="submit" value="Save" class="btn btn-primary" id="sumbnid"><input type="reset" class="btn btn-primary"> </td> </tr>
						</table> -->
								</table>

								<!-- tabs for plant and company -->

								<ul>
									<li><a href="#tabs-1">Plant</a></li>
									<li><a href="#tabs-2">Company</a></li>

								</ul>

								<!-- Tab for Plants -->
								<div id="tabs-1">
									<div align="left">
										<table class="tableGeneral">
											<tr>
												<td>Plant</td>
												<td><form:select path="editplantId" multiple="true"
														id="editplantId" class="select">
														<%-- <form:option value="..Select.." >--Select--</form:option> --%>
														<form:options items="${PurOrgPlant}" />
													</form:select></td>
											</tr>
										</table>
										<div id="extender"></div>
									</div>
								</div>
								<!-- Tab for Company -->
								<div id="tabs-2">
									<div align="left">
										<table class="tableGeneral">
											<tr>
												<td>Company</td>
												<td><form:select path="editorgId" multiple="true"
														id="editorgId" class="select">
														<%-- <form:option value="..Select.." >--Select--</form:option> --%>
														<form:options items="${PurOrgCompany}" />
													</form:select></td>
											</tr>
										</table>
										<div id="extender"></div>
									</div>
								</div>

								<input type="submit" value="Update" name="Update"
									class="btn btn-primary" id="poUpdate" />
							</div>
						</form:form>
					</c:forEach>
				</div>
			</div>

		</div>

	</div>
</body>

</html>




