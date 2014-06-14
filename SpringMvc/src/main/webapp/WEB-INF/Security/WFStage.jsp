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
<script type="text/javascript" src="js/MntValidator.js"></script>

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
						$('#' + "sumbnid")
								.click(
										function(event) {

											//alert($('#privilege').val());
											$("#addWfStageForm")
													.validate(
															{
																rules : {
																	wfstageProcessGUID : {
																		required : true
																	},
																	wfstageStage : {
																		required : true,
																		number : true

																	},
																	wfstageName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},

																},
																messages : {
																	wfstageProcessGUID : "<font style='color: red;'><b>Process Name is Required</b></font>",
																	wfstageStage : {
																		required : "<font style='color: red;'><b>Stage No is Required</b></font>",
																		number : "<font style='color:red;'><b>Stage No must be numbers</b></font>"
																	},
																	wfstageName : {
																		required : "<font style='color:red;'><b>Stage is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																},

															});
										});

						$('#updbut')
								.click(
										function(event) {
											$("#updateWFstageform")
													.validate(
															{
																rules : {

																	wfstageProcessGUIDEdit : {
																		required : true
																	},
																	wfstageStageEdit : {
																		required : true,
																		number : true

																	},
																	wfstageNameEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},

																},
																messages : {
																	wfstageProcessGUIDEdit : "<font style='color: red;'><b> Process Name is Required</b></font>",
																	wfstageStageEdit : {
																		required : "<font style='color: red;'><b> Stage is Required and must be Integer</b></font>",
																		number : "<font style='color:red;'><b>Stage No must be numbers</b></font>"
																	},
																	wfstageNameEdit : {
																		required : "<font style='color:red;'><b>stage is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},

																},
															});
										});

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#add,#search').click(function(e) {

			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

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
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
		}

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#basicSearch').click(function() {
			$("#advanceSearchHidden").val("0");
			$("#aslink").show();

			$('#mainSearch').show();
			$('#advanceSearchDiv').hide();
			$('#advanceSearch').show();
			$('#basicSearch').hide();

			return false;
		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Process Stage</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="wfstageValues" items="${wfstageValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>


			<!---================================ Search tab =======================================-->
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">


					<table class="tableGeneral">
						<form:form action="wfstageSearch.mnt" method="get"
							commandName="wfstageAdd">


							<tr>
								<td colspan="2"><c:forEach var="wfStageSave"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.procesStage" />
											<spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach> <c:if test="${param.listwar!=null }">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>

											<spring:message code="label.procesStage" />
											<spring:message code="label.saveFail" />
										</div>
									</c:if> <c:forEach var="wfstageUpadteSuccess"
										items="${wfstageUpadteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.procesStage" />
											<spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach> <c:forEach var="wfstageUpadteFail"
										items="${wfstageUpadteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.procesStage" />
											<spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach> <c:forEach var="wfstageDelete" items="${wfstageDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.procesStage" />
											<spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach> <c:forEach var="wfstageDeleteError"
										items="${wfstageDeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.procesStage" />
											<spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>


							<tr id="mainSearch">

								<td><spring:message code="label.searchby" /> <form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="wfstageAdd.operations">
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
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /> <input
									type="submit" value="Search" class="btn btn-primary" /></td>
							</tr>
						</form:form>


						<form:form action="wfstageAdvanceSearch.mnt" method="get"
							commandName="wfstageAdd" name="advanceSearchFinal">
							<tr>
								<td><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue" id="aslink"><u><b>Advanced
													Search </b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							</tr>
						</form:form>


					</table>
					<form:form action="wfstageAdvanceSearchOperations.mnt"
						commandName="wfstageAdd" id="advSearch">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${wfstageSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1">
												<form:option value="0">-Select-</form:option>
												<form:option value="=">Equals To</form:option>
												<form:option value="!=">Not Equals To</form:option>
												<form:option value="_%">BeginsWith</form:option>
												<form:option value="%_">EndsWith</form:option>
												<form:option value="%_%">Contains</form:option>
											</form:select></td>
										<td><c:choose>

												<c:when test="${xmlLabelValue.secondLabel=='Stage'}">
													<form:select path="advanceSearchText" class="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${WFStageSearchNames}" />
													</form:select>
												</c:when>
												<c:otherwise>
													<form:input path="advanceSearchText" id="advanceSearch" />
												</c:otherwise>
											</c:choose></td>

									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3"><input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" /></td>
								</tr>

							</table>

						</div>
					</form:form>

					<c:if test="${wfstageSearch!=null}">
						<display:table id="wfstageRow" name="wfstageSearch"
							requestURI="wfstageSearch.mnt" pagesize="5" class="table">

							<display:column property="wfprocessname"
								titleKey="label.processName" media="html" sortable="true"></display:column>
							<display:column property="wfstageStage" titleKey="label.stage"
								media="html" sortable="true" />
							<display:column property="wfstageName" titleKey="label.stageName"
								media="html" sortable="true" />
							<display:column property="wfstageDescription"
								titleKey="label.description" media="none" sortable="true" />
							<display:column property="wfstageType" titleKey="label.type"
								media="none" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
								<a
									href="wfstageEditHome.mnt?wfstageDetEdit=<c:out value="${wfstageRow.wfstageId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>

							<display:column titleKey="label.delete">
								<a
									href="wfstageDelete.mnt?wfstageidDelete=<c:out value="${wfstageRow.wfstageId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>
					</c:if>

				</div>
			</div>

			<!---================================ Add tab =======================================-->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">


					<form:form action="wfstageAdd.mnt" method="GET"
						commandName="wfstageAdd" id="addWfStageForm"
						onsubmit="return validateForm()">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${WFStageDuplicate }">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.stageName" />
											<spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="wfstageId" />

							<tr>
								<td><spring:message code="label.processName" /><span
									class="required">*</span></td>
								<td><form:select path="wfstageProcessGUID" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${ProcessSearchIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.stage" /><span
									class="required">*</span></td>
								<td><form:input path="wfstageStage" id="wfstageStage"
										class="textbox" maxlength="15" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.stageName" /><span
									class="required">*</span></td>
								<td><form:input path="wfstageName" id="wfstageName"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.description" /><span
									class="required"></span></td>
								<td><form:textarea path="wfstageDescription"
										id="wfstageDescription" class="textbox" maxlength="150" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.type" /><span
									class="required"></span></td>
								<td><form:input path="wfstageType" id="wfstageType"
										class="textbox" maxlength="50" /></td>
							</tr>
							<form:hidden path="aid" />


							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /><input type="reset"
									class="btn btn-primary"
									value="<spring:message code="label.reset"/>" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="wfstageEditValues" items="${wfstageValues }">
						<form:form action="wfstageUpdate.mnt" method="POST"
							commandName="wfstageAdd" id="updateWFstageform">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="wfstageEditDuplicate"
											items="${wfstageEditDuplicate }">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning" /></strong>
												<spring:message code="label.stageName" />
												<spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="wfstageIdEdit" />

								<tr>
									<td><spring:message code="label.processName" /><span
										class="required">*</span></td>
									<td><form:select path="wfstageProcessGUIDEdit"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${ProcessSearchIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.stage" /><span
										class="required">*</span></td>
									<td><form:input path="wfstageStageEdit" id="wfstageStage"
											class="textbox" maxlength="15" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.stageName" /><span
										class="required">*</span></td>
									<td><form:input path="wfstageNameEdit" id="wfstageName"
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.description" /><span
										class="required"></span></td>
									<td><form:textarea path="wfstageDescriptionEdit"
											id="wfstageDescription" class="textbox" maxlength="150" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.type" /><span
										class="required"></span></td>
									<td><form:input path="wfstageTypeEdit" id="wfstageType"
											class="textbox" maxlength="50" /></td>
								</tr>
								<form:hidden path="wfstageCreatedByEdit" />
								<form:hidden path="wfstageCreatedDateEdit" />
								<tr>
									<td colspan="2"><input type="submit" value="Update"
										class="btn btn-primary" id="updbut" /></td>
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




