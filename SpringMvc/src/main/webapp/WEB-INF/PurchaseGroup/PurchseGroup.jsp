<!-- @author Sailajach -->
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
						jQuery.validator.addMethod("alphanumeric", function(
								value, element) {
							return this.optional(element)
									|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});

						jQuery.validator.addMethod("specialcharacters",
								function(value, element) {
									return this.optional(element)
											|| /^[0-9a-zA-Z&_ ]+$/.test(value);
								});
						$('#' + "sumbtnid")
								.click(
										function(event) {

											$("#PgAddForm")
													.validate(
															{
																rules : {

																	purOrg_Id : {
																		required : true,

																	},
																	purchaseGroup : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},

																},
																messages : {
																	purOrg_Id : "<font style='color: red;'><b>Purchase Organization is Required</b></font>",
																	purchaseGroup : {
																		required : "<font style='color: red;'><b>Purchase Group is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"

																	},
																}

															});
										});

						$('#updateId')
								.click(
										function(event) {

											$("#pgUpdateForm")
													.validate(
															{
																rules : {
																	purOrg_IdEditt : {
																		required : true
																	},
																	purchaseGroupEditt : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	purOrg_IdEditt : "<font style='color: red;'><b>Purchase Organization is Required</b></font>",
																	purchaseGroupEditt : {
																		required : "<font style='color: red;'><b>Purchase Group  is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"

																	},
																}

															});
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
		<div class="PageTitle">Purchase Group</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="purchaseGroupValues" items="${list}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="purchaseGroupSearch.mnt" method="GET"
						commandName="purchaseGroupCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="purchaseUpadte"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>$uccess :</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="purchaseUpadte"
										items="${purchaseUpadte}">
										<div class="alert-success" id="successmessage">
											<strong>$uccess :</strong>
											<c:out value="${purchaseUpadte}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="purchaseUpadte"
										items="${param.list1}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning!</strong>
											<c:out value="${param.warning}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="purchaseUpadteF"
										items="${purchaseUpadteF}">
										<div class="alert-danger" id="errormessage">
											<strong>Error ! </strong>
											<c:out value="${purchaseUpadteF}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="purchaseGroupCommand.operations">
										<select class="select" name="operations">
											<option value="<spring:message code='assignedOperator'/>">
												<spring:message code="label.equalsTo" />
											</option>
											<option value="<spring:message code='notequalsOperator'/>">
												<spring:message code="label.notEqualsTo" />
											</option>
											<option value="<spring:message code='beginsWithOperator'/>">
												<spring:message code="label.beginsWith" />
											</option>
											<option value="<spring:message code='endsWithOperator'/>">
												<spring:message code="label.endsWith" />
											</option>
											<option value="<spring:message code='containsOperator'/>">
												<spring:message code="label.contains" />
											</option>
										</select>
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
					<c:forEach var="purchaseGroupSearch"
						items="${purchaseGroupSearchVlaue}">
						<c:set var="g" value="${purchaseGroupSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="purchaseGroupValue" name="purchaseGroupSearch"
							requestURI="purchaseGroupSearch.mnt" pagesize="5" class="table">
							<display:column property="purchaseGroup"
								titleKey="label.purchasegroup" media="html" sortable="true" />
							<display:column property="purOrg" titleKey="label.purchaseorg"
								media="html" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
								<a
									href="purchaseGroupIdEdit.mnt?purchaseGroupIdEdit=<c:out value="${purchaseGroupValue.purchaseGroupId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="purchaseGroupIdDelete.mnt?purchaseGroupIdDelete=<c:out value="${purchaseGroupValue.purchaseGroupId}"/>"
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

					<form:form action="purchaseGroupAdd.mnt" method="POST"
						commandName="purchaseGroupCommand" id="PgAddForm">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach var="addPGDuplicate"
										items="${addPGDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong>Warning!</strong> <font color="#C09853"><c:out
													value="${addPGDuplicate}" /></font>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.purchaseorg" /><font
									color="red">*</font></td>
								<td><form:select path="purOrg_Id" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${purchaseOrganization}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.purchasegroup" /><font
									color="red">*</font></td>
								<td><form:input path="purchaseGroup" id="purchaseGroup"
										class="textbox" maxlength="50" /></td>
								<td style="display: none" id="addmessage" class="alert-warning"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbtnid" /><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>



				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="purchaseGroupValues" items="${list}">
						<form:form action="purchaseGroupEdit.mnt" method="POST"
							commandName="purchaseGroupCommand" id="pgUpdateForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="addPGDuplicate"
											items="${addPGDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong>Warning!</strong> <font color="#C09853"><c:out
														value="${addPGDuplicate}" /></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="purchaseGroupIdEditt" />
								<tr>
									<td><spring:message code="label.purchaseorg" /><font
										color="red">*</font></td>
									<td><form:select path="purOrg_IdEditt" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${purchaseOrganization}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.purchasegroup" /><font
										color="red">*</font></td>
									<td><form:input path="purchaseGroupEditt"
											id="purchaseGroupEditt" class="textbox" maxlength="50" /></td>
									<td style="display: none" id="editmessage"
										class="alert-warning"></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateId" /></td>
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
