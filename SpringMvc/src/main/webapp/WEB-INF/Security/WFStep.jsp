<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
											$("#addwfstepForm")
													.validate(
															{

																rules : {
																	wfstepStageGUID : {
																		required : true
																	},
																	wfstepStep : {
																		required : true,
																		number : true 
																		
																	},
																	wfstepName : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	},
																	wfstepType : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	},
																	wfstepStatus : {
																		required : true
																		 
																	},
																	wfstepAssignedTo : {
																		required : true
																	},

																},
																messages : {
																	wfstepStageGUID : "<font style='color: red;'><b>Stage Name is Required</b></font>",
																	wfstepStep : {
																		required : "<font style='color: red;'><b>Step No is Required</b></font>",
																		number:"<font style='color:red;'><b>Step No must be numbers</b></font>"
																	},
																	wfstepName : {

																		required :"<font style='color:red;'><b>Step is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																		},
																	wfstepType : {

																		required :"<font style='color:red;'><b>Type Name is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																		},
																	wfstepStatus : "<font style='color: red;'><b>Status is Required</b></font>",
																	wfstepAssignedTo : "<font style='color: red;'><b>Assigned To is Required</b></font>",
																},
															
															

															});
										});

						$('#updbut')
								.click(
										function(event) {

											$("#updatewfstepForm")
													.validate(
															{
																rules : {
																	wfstepStageGUIDEdit : {
																		required : true
																	},
																	wfstepStepEdit : {
																		required : true,
																		number : true
																		
																	},
																	wfstepNameEdit : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	},
																	wfstepTypeEdit : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	},
																	wfstepStatusEdit : {
																		required : true
																		 
																	},
																	wfstepAssignedToEdit : {
																		required : true
																	}

																},
																messages : {
																	wfstepStageGUIDEdit : "<font style='color: red;'><b>Stage Name is Required</b></font>",
																	wfstepStepEdit : {
																		required : "<font style='color: red;'><b>Step No is Required</b></font>",
																		number: "<font style='color:red;'><b>Step No must be numbers</b></font>"
																	},
																	wfstepNameEdit : {

																		required :"<font style='color:red;'><b>Step is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		},
																	wfstepTypeEdit : {

																		required :"<font style='color:red;'><b>Type Name is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		},
																	wfstepStatusEdit : "<font style='color: red;'><b>Status is Required</b></font>",
																	wfstepAssignedToEdit : "<font style='color: red;'><b>Assigned To is Required</b></font>",
																},
															});
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

		$('#search,#add').click(function(e) {
			$('#edit').hide();
			
			
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if ($('#advanceSearchHidden').val() == "1") {
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
		<div class="PageTitle">Process Step</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="wfstepValues" items="${wfstepValues}">
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
						<form:form action="wfstepSearch.mnt" method="get"
							commandName="wfstepAdd">

							<tr>
								<td colspan="2"><c:forEach var="wfStepSave"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.processStep"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.processStep"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								
								<c:forEach var="wfstepUpadteSuccess"
										items="${wfstepUpadteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.processStep"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
									<c:forEach var="wfstepUpadteFail"
										items="${wfstepUpadteFail}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.processStep"/> <spring:message code="label.updateFail"></spring:message>
											</div>
									</c:forEach>
									<c:forEach var="wfstepDeleteSuccess"
										items="${wfstepDeleteSuccess}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.processStep"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="wfstepDeleteError"
										items="${wfstepDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.processStep"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
							
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>

								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="wfstepAdd.operations">
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
									
									<c:set
										var="save" value="false"></c:set> <c:set var="edit"
										value="false"></c:set> <c:set var="delete" value="false"></c:set>
									<c:set var="update" value="false"></c:set> <c:set var="search"
										value="false"></c:set> <fmt:setBundle basename="button" /> <fmt:message
										key="label.save" var="messagesav" /> <fmt:message
										key="label.search" var="messagesea" /> <fmt:message
										key="label.delete" var="messagedel" /> <fmt:message
										key="label.update" var="messageup" /> <fmt:message
										key="label.edit" var="messageed" /> <c:forEach
										items="${sessionScope.privilegeList}" var="privileges">
										<c:choose>
											<c:when test="${privileges eq messagesav }">
												<c:set var="save" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messagesea }">
												<c:set var="search" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messagedel }">
												<c:set var="delete" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messageed }">
												<c:set var="edit" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messageup }">
												<c:set var="update" value="true"></c:set>
											</c:when>
										</c:choose>

									</c:forEach>
																										
									
								<td><c:choose>
								<c:when test="${search}">
								  <input type="submit" value="Search"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									 <input type="submit" value="Search" disabled="disabled"
									class="btn btn-danger" />
									</c:otherwise>
									
								</c:choose></td>
							</tr>

						</form:form>
						<form:form action="wfstepAdvanceSearch.mnt" method="get"
							commandName="wfstepAdd" name="advanceSearchFinal">
							<tr>
								<td><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue"><u><b>Advanced Search</b></u></font></a> <a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							</tr>
						</form:form>


					</table>
					<form:form action="wfstepAdvanceSearchOperations.mnt"
						commandName="wfstepAdd">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${wfstepSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label>
										<form:hidden path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1">
												<form:option value="0">-Select-</form:option>
												<form:option value="=">Equals To</form:option>
												<form:option value="!=">Not Equals To</form:option>
												<form:option value="_%">BeginsWith</form:option>
												<form:option value="%_">EndsWith</form:option>
												<form:option value="%_%">Contains</form:option>
											</form:select></td>
											<td>
											<c:choose>
											<c:when test="${xmlLabelValue.secondLabel=='Step'}">
											 	<form:select path="advanceSearchText" class="select">
										      <form:option value="">--Select--</form:option>
								              <form:options items="${WFStepSearchNames}" />
							            	</form:select>
											</c:when>
											<c:otherwise>
											<form:input path="advanceSearchText"
												id="advanceSearch" />
											</c:otherwise>
											</c:choose>
										</td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3">
									<c:choose>
									<c:when test="${search }">
									<input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" /></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
								</tr>

							</table>

						</div>
					</form:form>

					<c:if test="${wfstepSearch!=null}">
						<display:table id="wfstepRow" name="wfstepSearch"
							requestURI="wfstepSearch.mnt" pagesize="5" class="table">

							<display:column property="wfstageName" titleKey="label.stageName"
								media="html" sortable="true" />
							<display:column property="wfstepStep" titleKey="label.step"
								media="html" sortable="true" />
							<display:column property="wfstepName" titleKey="label.stepName"
								media="html" sortable="true" />
							<display:column property="wfstepType" titleKey="label.type"
								media="html" sortable="true" />
							<display:column property="wfstepStatus" titleKey="label.status"
								media="html" sortable="true" />
							<display:column property="role" titleKey="label.assignedTo"
								media="html" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
							
						
								<a
									href="wfstepEditHome.mnt?wfstepDetEdit=<c:out value="${wfstepRow.wfstepid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>	</c:when>
									
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"/></a>
									</c:otherwise>
									
							</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
							
							
								<a
									href="wfstepDelete.mnt?wfstepidDelete=<c:out value="${wfstepRow.wfstepid}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement" value="bottom" />
									</display:table>
					</c:if>

				</div>
			</div>



			<!---================================ Add tab =======================================-->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">


					<form:form action="wfstepAdd.mnt" method="GET"
						commandName="wfstepAdd" id="addwfstepForm">
						<table class="tableGeneral">
							
							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${WFStepDuplicate }">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.stepName"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="wfstepid" />
							<tr>
								<td><spring:message code="label.stageName" /><span
									class="required">*</span></td>
								<td><form:select path="wfstepStageGUID" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${StageSearchIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.step" /><span
									class="required">*</span></td>
								<td><form:input path="wfstepStep" id="wfstepStep"
										class="textbox" maxlength="15"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.stepName" /><span
									class="required">*</span></td>
								<td><form:input path="wfstepName" id="wfstepName"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.type" /><span
									class="required">*</span></td>
								<td><form:input path="wfstepType" id="wfstepType"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.status" /><span
									class="required">*</span></td>
								<td><form:select path="wfstepStatus" id="wfstepStatus"
										class="select">

										<form:option value="">--Select--</form:option>
										<form:option value="1">Active</form:option>
										<form:option value="2">In Active</form:option>

									</form:select></td>
							</tr>
							<form:hidden path="wfstepCreatedBy" />
							<form:hidden path="wfstepCreatedDate" />
							<form:hidden path="aid" />
							<tr>
								<td><spring:message code="label.assignedTo" /><span
									class="required">*</span></td>
								<td><form:select path="wfstepAssignedTo" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${RolesSearchIds}" />
									</form:select></td>
							</tr>


							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${save}">
								<input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /></c:when>
									<c:otherwise>
									<input type="submit" value="Save" disabled="disabled"
									class="btn btn-danger" id="sumbnid" />
									</c:otherwise>
									
								</c:choose><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="wfstepEditValues" items="${wfstepValues }">
						<form:form action="wfstepUpdate.mnt" method="POST"
							commandName="wfstepAdd" id="updatewfstepForm">
							<table class="tableGeneral">
								
								<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${wfstepEditDuplicate }">
											<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.stepName"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
										</c:forEach></td>
								</tr>
								
								<form:hidden path="wfstepidEdit" />
								<tr>
									<td><spring:message code="label.stageName" /><span
										class="required">*</span></td>
									<td><form:select path="wfstepStageGUIDEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${StageSearchIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.step" /><span
										class="required">*</span></td>
									<td><form:input path="wfstepStepEdit" id="wfstepStep"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.stepName" /><span
										class="required">*</span></td>
									<td><form:input path="wfstepNameEdit" id="wfstepName"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.type" /><span
										class="required">*</span></td>
									<td><form:input path="wfstepTypeEdit" id="wfstepType"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.status" /><span
										class="required">*</span></td>
									<td><form:select path="wfstepStatusEdit" id="wfstepStatus"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:option value="1">Active</form:option>
											<form:option value="2">In Active</form:option>

										</form:select></td>
								</tr>

								<tr>
									<td><spring:message code="label.assignedTo" /><span
										class="required">*</span></td>
									<td><form:select path="wfstepAssignedToEdit"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${RolesSearchIds}" />
										</form:select></td>
								</tr>

								<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${update }">
										<input type="submit" value="Update"
										class="btn btn-primary" id="updbut" /></c:when>
										<c:otherwise>
										<input type="submit" value="Update" disabled="disabled"
										class="btn btn-danger" id="updbut" />
										</c:otherwise>
										
									</c:choose></td>
								</tr> 
								<form:hidden path="wfstepCreatedByEdit" />
								<form:hidden path="wfstepCreatedDateEdit" />
								<form:hidden path="aid" />
								
								
							</table>
						</form:form>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>

</body>
</html>




