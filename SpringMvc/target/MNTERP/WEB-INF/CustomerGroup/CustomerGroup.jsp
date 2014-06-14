<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
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
											
											$('#addcgform')
													.validate(
															{
																rules : {
																	custGroup : {
																		required : true },
																	
																},
																messages : {
																	custGroup : "<font style='color: red;'><b>Customer Group is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert("hai");
											$('#editcgForm')
													.validate(
															{
																rules : {
																	custGroupEditt : {
																		required : true
																	},

																},
																messages : {
																	custGroupEditt : "<font style='color: red;'><b>Customer Group is Required</b></font>"
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
		<div class="PageTitle">Customer Group</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="custGroupValues" items="${list}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="custGroupSearch.mnt" method="GET"
						commandName="custGroupCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="customerUpadted"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="customerUpadted"
										items="${customerUpadte}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${customerUpadted}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="customerGroupUpadted"
										items="${param.list1}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning!</strong>
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
								<td>Customer Group Id</td>
								<td><form:input path="custGroupId" cssClass="textbox"/></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary" /></td>
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
					<c:forEach var="customerSearch" items="${custGroupSearch}">
						<c:set var="g" value="${customerSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="custGroupValue" name="custGroupSearch"
							requestURI="custGroupSearch.mnt" pagesize="5" class="table">

							<display:column property="custGroup" title="Customer Group "
								media="html" sortable="true" />
							<display:column title="Edit" style="color:white">
								<a
									href="custGroupIdEdit.mnt?custGroupIdEdit=<c:out value="${custGroupValue.custGroupId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column title="Delete">
								<a
									href="custGroupIdDelete.mnt?custGroupIdDelete=<c:out value="${custGroupValue.custGroupId}"/>"
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
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					
						<form:form action="CustGroup.mnt" method="POST"
							commandName="custGroupCommand" id="addcgform">
							<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2" height="20px"><c:forEach
										var="addCustDuplicate" items="${addCustDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out value="${addCustDuplicate}" /></font>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td>Customer Group<font color="red">*</font>
								</td>
								<td><form:input path="custGroup" id="custGroup"
										class="textbox" /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
							</table>
						</form:form>

					

				</div>
			</div>

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="custGroupValues" items="${list}">
						<form:form action="custGroupEdit.mnt" method="POST"
							commandName="custGroupCommand" id="editcgForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2" height="20px"><c:forEach
											var="addCustDuplicate" items="${addCustDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out value="${addCustDuplicate}" /></font>
											</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="custGroupIdEditt" />
								<tr>
									<td>Customer Group<font color="red">*</font>
									</td>
									<td><form:input path="custGroupEditt" id="custGroupEditt"
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
