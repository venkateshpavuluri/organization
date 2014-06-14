
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
						$('#sumbnid')
								.click(
										function(event) {
											
											$('#addassetgroupform')
													.validate(
															{
																rules : {
																	assetGroupType : {
																		required : true },
																	
																},
																messages : {
																	assetGroupType : "<font style='color: red;'><b>Asset Group Type is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											
											$('#editassetgroupForm')
													.validate(
															{
																rules : {
																	assetGroupTypeEdit : {
																		required : true
																	},

																},
																messages : {
																	assetGroupTypeEdit : "<font style='color: red;'><b>Asset Group Type is Required</b></font>"
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
		<div class="PageTitle">Asset Group</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="assetGroupValues" items="${assetGroupValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="searchAssetGroup.mnt" commandName="assetGroup"
						method="GET">
						<body>
							<table class="tableGeneral">


								<tr>
									<td colspan="2"><c:forEach var="addAssetGroupSuccess"
											items="${param.addAssetGroupSuccess}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.addAssetGroupSuccess}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="assetGroupUpdate"
											items="${param.assetGroupUpdate}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.assetGroupUpdate}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="assetGroupDelete"
											items="${param.assetGroupDelete}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.assetGroupDelete}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>

								<%-- <tr>
									<td><spring:message code="label.assetgrouptype"/><form:select path="assetGroupId"
											class="textbox">
											<form:option value="0">..select..</form:option>
											<form:options items="${assetGroupType}" />
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

					<c:forEach var="assetGroupSearch" items="${assetGroupSearch}">
						<c:set var="i" value="${assetGroupSearch}"></c:set>
					</c:forEach>

					<c:if test="${i!=null}">
						<display:table id="assetGroupRow" name="assetGroupSearch"
							requestURI="searchAssetGroup.mnt" pagesize="5" class="table">
							<display:column property="assetGroupId" title="AssetGroupId"
								media="none" sortable="true"></display:column>
							<display:column property="assetGroupType" title="Asset Group Type"
								media="html" sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<a
									href="assetGroupEditHome.mnt?assetGroupIdEdit=<c:out value="${assetGroupRow.assetGroupId}"/>"
									style="color: red"> <img src="images/Edit.jpg" width="20px"
									height="20px" />
								</a>
							</display:column>

							<display:column title="Delete">
								<a
									href="assetGroupDelete.mnt?assetGroupIdDelete=<c:out value="${assetGroupRow.assetGroupId}"/>"
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

					<form:form action="addAssetGroup.mnt" commandName="assetGroup"
						method="post" id="addassetgroupform">
						<table class="tableGeneral">
							<tr>
								<td colspan="2" ><c:forEach var="addAssetGroupDuplicate"
										items="${addAssetGroupDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${addAssetGroupDuplicate}">
												</c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" id="aid" />
							<tr>
								<td><spring:message code="label.assetgrouptype"/><span class="required">*</span></td>
								<td><form:input path="assetGroupType" class="textbox" /></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Save"
									id="sumbnid" class="btn btn-primary" /><input type="reset"
									value="Reset" class="btn btn-primary" /></td>
							</tr>

						</table>
					</form:form>
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="assetGroupEditValues" items="${assetGroupValues }">
						<form:form action="assetGroupUpdate.mnt" method="POST"
							commandName="assetGroup" id="editassetgroupForm">
							<table class="tableGeneral">
							
							<tr>
								<td colspan="2" ><c:forEach var="updateAssetGroupDuplicate"
										items="${updateAssetGroupDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${updateAssetGroupDuplicate}">
												</c:out></font>
										</div>
									</c:forEach></td>
							</tr>
								<form:hidden path="assetGroupIdEdit" />
								<tr>
									<td><spring:message code="label.assetgrouptype"/><span class="required">*</span></td>
									<td><form:input path="assetGroupTypeEdit" class="textbox" />
									</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit"
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




