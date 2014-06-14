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
											$("#addWfActionForm")
													.validate(
															{

																rules : {
																	wfactionStepGUID : {
																		required : true,
																		
																	},
																	wfactionAction : {
																		required : true,
																		number : true
																		
																	},
																	wActionId : {
																		required : true,
																		
																	},
																	wfactionType : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	},
																	
																},
																messages : {
																	wfactionStepGUID: "<font style='color: red;'><b> Step is Required</b></font>",
																	wfactionAction : {
																		required : "<font style='color: red;'><b>Action No is Required</b></font>",
																		number:"<font style='color:red;'><b>Action No must be numbers</b></font>"
																	},
																	wActionId : {
																		required :"<font style='color:red;'><b>Action is required</b></font>",
																		
																		},
																	wfactionType : {
																		required :"<font style='color:red;'><b>Type is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},
																	
																},

															});
										
										});
					

						$('#updbut')
								.click(
										function(event) {

											$("#updateWfActionForm")
													.validate(
															{
																rules : {
																	wfactionStepGUIDEdit : {
																		required : true, 
																		
																	},
																	wfactionActionEdit : {
																		required : true,
																		number : true
																		
																	},
																	wActionIdEdit : {
																		required : true,
																		
																	},
																	wfactionTypeEdit : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																	},
																	
																},
																messages : {
																	wfactionStepGUIDEdit : "<font style='color: red;'><b>Step is Required</b></font>",
																	wfactionActionEdit : {
																		required : "<font style='color: red;'><b>Action No is Required</b></font>",
																		number:"<font style='color:red;'><b>Action No must be numbers</b></font>"
																	},
																	wActionIdEdit : {
																		required :"<font style='color:red;'><b>Action is required</b></font>",
																		
																		},
																	wfactionTypeEdit : {
																		required :"<font style='color:red;'><b>Type is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																		},
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
		$('#add,#search').click(function(e) {

			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

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
		<div class="PageTitle">Process Action</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="wfactionValues" items="${wfactionValues}">
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
						<form:form action="wfactionSearch.mnt" method="get"
							commandName="wfactionAdd">

							<tr>
								<td colspan="2"><c:forEach var="wfActionSave"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.processAction"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.processAction"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
							
							<c:forEach var="wfactionUpadteSuccess"
										items="${wfactionUpadteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.processAction"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
								<c:forEach var="wfactionUpadteError"
										items="${wfactionUpadteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.processAction"/> <spring:message code="label.updateFail"></spring:message>
											</div>
									</c:forEach>
								<c:forEach var="wfActionDeleteSuccess"
										items="${wfActionDeleteSuccess}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.processAction"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach>
								<c:forEach var="wfActionDeleteError"
										items="${wfActionDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.processAction"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr id="mainSearch">
								<td ><spring:message code="label.searchby" /></td>

								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select>
									<spring:bind path="wfactionAdd.operations">
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
								<td>
								<c:choose>
								<c:when test="${true}">
								<input type="submit" value="Search"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
								<input type="submit" value="Search" disabled="disabled"
									class="btn btn-danger" />
									</c:otherwise>
								</c:choose></td>
							</tr>

						</form:form>

						<form:form action="wfactionAdvanceSearch.mnt" method="get"
							commandName="wfactionAdd" name="advanceSearchFinal">
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
					<form:form action="wfactionAdvanceSearchOperations.mnt"
						commandName="wfactionAdd">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${wfactionSearchAdvance}">
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
											<c:when test="${xmlLabelValue.secondLabel=='Action'}">
											<form:select path="advanceSearchText" class="select">
										      <form:option value="">--Select--</form:option>
								              <form:options items="${WFActionSearchNames}" />
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
									<c:when test="${search}">
									
								
									<input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" />	</c:when>
										<c:otherwise>
										<input type="submit"
										id="advanceSearchButtonId" disabled="disabled" value="Advance Search"
										style="display: none" class="btn btn-danger" />	
										</c:otherwise>
										
									</c:choose></td>
								</tr>

							</table>

						</div>
					</form:form>

					<c:if test="${wfactionSearch!=null}">
						<display:table id="wfactionRow" name="wfactionSearch"
							requestURI="wfactionSearch.mnt" pagesize="5" class="table">

							<display:column property="wfstepName" titleKey="label.stepName"
								media="html" sortable="true" />
							<display:column property="wfactionAction" titleKey="label.action"
								media="html" sortable="true" />
							<display:column property="wfactionName"
								titleKey="label.actionName" media="html" sortable="true" />
							<display:column property="wfactionType" titleKey="label.type"
								media="html" sortable="true" />
							<display:column property="wfactionCondition"
								titleKey="label.condition" media="html" sortable="true" />
							<display:column property="wfactionDirection"
								titleKey="label.direction" media="html" sortable="true" />
							<display:column property="wfactionGotoStep"
								titleKey="label.gotoStep" media="html" sortable="true" />
							<display:column property="wfactionEmail" titleKey="label.email"
								media="html" sortable="true" />

							<display:column property="wfactionComments"
								titleKey="label.comments" media="html" sortable="true" />
							<display:column property="wfactionMessage"
								titleKey="label.message" media="html" sortable="true" />
							<display:column property="wfactionMessageDetails"
								titleKey="label.messageDetails" media="html" sortable="true" />

							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
							
								<a
									href="wfactionEditHome.mnt?wfactionDetEdit=<c:out value="${wfactionRow.wfactionId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
									height="20px" />  </a>
									</c:otherwise>
							</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${true}">
								<a
									href="wfactionDelete.mnt?wfactionidDelete=<c:out value="${wfactionRow.wfactionId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px"
									height="20px" /> </a>
									</c:otherwise>
							</c:choose>
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
					<form:form action="wfactionAdd.mnt" method="GET"
						commandName="wfactionAdd" id="addWfActionForm"
						onsubmit="return validateForm()">
						<table class="tableGeneral">

							
							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${WFActionDuplicate }">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.actionName"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="wfactionId" />
							<tr>
								<td><spring:message code="label.stepName" /><span
									class="required">*</span></td>
								<td><form:select path="wfactionStepGUID" class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${StepSearchIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.action" /><span
									class="required">*</span></td>
								<td><form:input path="wfactionAction" id="wfactionAction"
										class="textbox" maxlength="10"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.actionName" /><span
									class="required">*</span></td>
								<td><form:select path="wActionId" class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${WfActions}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.type" /><span
									class="required">*</span></td>
								<td><form:input path="wfactionType" id="wfactionType"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.condition" /></td>
								<td><form:input path="wfactionCondition"
										id="wfactionCondition" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.direction" /></td>
								<td><form:input path="wfactionDirection"
										id="wfactionDirection" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.gotoStep" /></td>
								<td><form:input path="wfactionGotoStep"
										id="wfactionGotoStep" class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.email" /></td>
								<td><form:input path="wfactionEmail" id="wfactionEmail"
										class="textbox" maxlength="50"/></td>
							</tr>

							<tr>
								<td><spring:message code="label.comments" /></td>
								<td><form:input path="wfactionComments"
										id="wfactionComments" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.message" /></td>
								<td><form:input path="wfactionMessage" id="wfactionMessage"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.messageDetails" /></td>
								<td><form:input path="wfactionMessageDetails"
										id="wfactionMessageDetails" class="textbox" maxlength="50"/></td>
							</tr>
							<form:hidden path="aid" />

							<tr>
								<td colspan="2">
								
								<c:choose>
								<c:when test="${true}">
								
								
								<input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /></c:when>
									<c:otherwise>
									<input type="submit" value="Save" disabled="disabled"
									class="btn btn-danger" id="sumbnid" />
									</c:otherwise>
								</c:choose>
								 <input type="reset"
									class="btn btn-primary" value="<spring:message
								code="label.reset" />"/>
								
								</td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="wfactionEditValues" items="${wfactionValues }">
						<form:form action="wfactionUpdate.mnt" method="POST"
							commandName="wfactionAdd" id="updateWfActionForm">
							<table class="tableGeneral">
								
								<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${wfactionEditDuplicate }">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.actionName"/> <spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								
								
								
								<form:hidden path="wfactionIdEdit" />
								<tr>
									<td><spring:message code="label.stepName" /><span
										class="required">*</span></td>
									<td><form:select path="wfactionStepGUIDEdit"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${StepSearchIds}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.action" /><span
										class="required">*</span></td>
									<td><form:input path="wfactionActionEdit"
											id="wfactionAction" class="textbox"  maxlength="10"/></td>
								</tr>
								<tr>
								<td><spring:message code="label.actionName" /><span
									class="required">*</span></td>
								<td><form:select path="wActionIdEdit" class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${WfActions}" />
									</form:select></td>
							</tr>
								<tr>
									<td><spring:message code="label.type" /><span
										class="required">*</span></td>
									<td><form:input path="wfactionTypeEdit" id="wfactionType"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.condition" /></td>
									<td><form:input path="wfactionConditionEdit"
											id="wfactionCondition" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.direction" /></td>
									<td><form:input path="wfactionDirectionEdit"
											id="wfactionDirection" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.gotoStep" /></td>
									<td><form:input path="wfactionGotoStepEdit"
											id="wfactionGotoStep" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.email" /></td>
									<td><form:input path="wfactionEmailEdit"
											id="wfactionEmail" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.comments" /></td>
									<td><form:input path="wfactionCommentsEdit"
											id="wfactionComments" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.message" />
										</td>
									<td><form:input path="wfactionMessageEdit"
											id="wfactionMessage" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.messageDetails" /></td>
									<td><form:input path="wfactionMessageDetailsEdit"
											id="wfactionMessageDetails" class="textbox" maxlength="50"/></td>
								</tr>
								<form:hidden path="aid" />
								<form:hidden path="wfactionCreatedByEdit" />
								<form:hidden path="wfactionCreateddateEdit" />

								<tr>
									<td colspan="2">
									
									<c:choose>
									<c:when test="${true}">
									
									
									<input type="submit" value="Update"
										class="btn btn-primary" id="updbut" /></c:when>
										<c:otherwise>
										<input type="submit" value="Update" disabled="disabled"
										class="btn btn-danger" id="updbut" />
										</c:otherwise>
									</c:choose></td>
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
