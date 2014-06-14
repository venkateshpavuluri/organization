
<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 19-09-2013 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#orgTypeSubmit')
								.click(
										function(event) {
											$("#orgTypeFormgh")
													.validate(
															{
																rules : {
																	orgType : {
																		required : true
																	}
																},
																messages : {
																	orgType : "<font style='color: red;'><b>Organization Type Name is Required</b></font>"
																},

															});
										});

						$('#orgTypeSubmitupdate')
								.click(
										function(event) {

											$("#otUpdate")
													.validate(
															{
																rules : {
																	orgTypeEdit : {
																		required : true
																	},
																},
																messages : {
																	orgTypeEdit : "<font style='color: red;'><b>Organization Type Name is Required</b></font>"
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
<script type="text/javascript">
	function validateOrgType() {

		$("#orgTypeFormgh").validate({

			rules : {

				orgType : {
					required : true

				},

				orgType : "required"

			},

			messages : {

				orgType : "MaterialCode is required "

			}
		});

	}
</script>
<%-- <script type="text/javaScript">
function validateOrgType()
{
var x=document.getElementById("orgType").value;
if(x==""||x==null)
{
alert("Organization Type Name Required");
return false;
}
}
</script> --%>


<script>
	$(function() {
		$("#tabs").tabs();
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
		<div class="PageTitle">Organization Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${organizationTypeValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /> </a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /> </a></li>
			</ul>

			<!--=================== ============================================Begin OrgTypeSearch================================================= -->
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">


					<form:form action="organizationTypeSearch.mnt" method="get"
						commandName="organizationType">
						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach var="organizationTypeUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="3"><c:forEach var="organizationTypeUpdate"
										items="${orgTypeUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${organizationTypeUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td><s:message code="label.organizationTypeName" /></td>
								<td><form:select path="orgTypeId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${organizationIds}" />
								</form:select></td>
								<td><input type="submit"
									value="<s:message code="label.search"/> "
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
					<!--=================== ============================================End OrgTypeSearch================================================= -->

					<!--=================== ============================================Begin DisplayTable================================================= -->
					<c:forEach var="organizationSearch"
						items="${organizationTypeSearch}">
						<c:set var="g" value="${organizationSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">

						<display:table id="organizationTypeRow"
							name="organizationTypeSearch"
							requestURI="organizationTypeSearch.mnt" pagesize="5"
							class="table">
							<display:column property="orgType"
								titleKey="label.organizationName" media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
								<a
									href="organizationTypeEditHome.mnt?organizationTypeEdit=<c:out value="${organizationTypeRow.orgTypeId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="organizationTypeDelete.mnt?organizationTypeCodeDelete=<c:out value="${organizationTypeRow.orgTypeId}"/>"
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
			<!--=================== ============================================End DisplayTable================================================= -->


			<!--=================== ============================================Begin OrgTypeAdd================================================= -->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table class="tableGeneral">
						<tr>
							<td colspan="2"><c:forEach var="orgTypeDuplicate"
									items="${duplicate}">
									<div class="alert-warning">
										<font color="red"><c:out value="${orgTypeDuplicate}"></c:out>
									</div>
								</c:forEach></font></td>
						</tr>
					</table>
					<form:form action="organizationTypeAdd.mnt" name="orgTypeFormgh"
						id="orgTypeFormgh" onsubmit="return validateOrgType(this);"
						method="POST" commandName="organizationType">
						<form:hidden path="OrgTypeIdEdit" />
						<form:hidden path="aid" />
						<table>
							<tr>
								<td><s:message code="label.organizationTypeName" /><font
									color="red">*</font></td>
								<td><form:input path="orgType" id="orgType" class="textbox" />
								</td>
							</tr>
							<tr>
								<td><input type="submit"
									value="<s:message code="label.save"/> " class="btn btn-primary"
									id="orgTypeSubmit" /><input type="reset"
									value="<s:message code="label.reset"/> "
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>


				</div>
			</div>
			<!--=================== ============================================End OrgTypeAdd================================================= -->

			<!--=================== ============================================Begin OrgTypeEdit================================================= -->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="orgTypeEditValues"
						items="${organizationTypeValues }">

						<form:form action="organizationTypeUpdate.mnt" method="POST"
							commandName="organizationType" id="otUpdate">
							<table>
								<tr>
									<td colspan="2"><c:forEach var="orgTypeUpdateDup"
											items="${orgTypeUpdateDuplicate}">
											<div class="alert-warning">
												<font color="red"><c:out value="${orgTypeUpdateDup}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="orgTypeIdEdit" />
								<tr>
									<td><s:message code="label.organizationTypeName" /><font
										color="red">*</font></td>
									<td><form:input path="orgTypeEdit" id="orgName"
											class="textbox" /></td>
								</tr>

								<tr>
									<td><input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-primary" id="orgTypeSubmitupdate" /><input
										type="reset" value="<s:message code="label.reset"/> "
										class="btn btn-primary" /></td>
								</tr>
							</table>
						</form:form>
						<!--=================== ============================================End OrgTypeEdit================================================= -->

					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




