<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script type="text/javascript" src="js/MntValidator.js"></script>
	<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#' + "sumbnid")
								.click(
										function(event) {

											$("#projectTaskAdd")
													.validate(
															{

																rules : {
																	projectTask : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},

																	projectId : {
																		required : true
																	},
																	plantStartDt : {
																		required : true
																	},
																	plantEndDt : {
																		required : true
																	},
																
																	durationHrs : {
																		required : true
																		
																	},
																	projectResource_Id : {
																		required : true
																	},
																	
																	
																},
																messages : {
																	projectTask : {
																		required: "<font style='color: red;'><b>Project task is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			},
																			projectId : "<font style='color: red;'><b> ProjectId is Required</b></font>",
																			plantStartDt : "<font style='color: red;'><b>Plant StartDate is Required</b></font>",
																			plantEndDt : "<font style='color: red;'><b>Plant EndDate is required</b></font>",
																			durationHrs : "<font style='color: red;'><b>Durations is Required</b></font>",
																			projectResource_Id : "<font style='color: red;'><b>Projecttask resource is Required</b></font>",
																					
																
																},

															});
										});

						$('#updatebtn ')
								.click(
										function(event) {

											$("#projectTaskUp")
													.validate(
															{
																rules : {
																	projectTaskEdit : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},

																	projectIdEdit : {
																		required : true
																	},
																	plantStartDtEdit : {
																		required : true
																	},
																	plantEndDtEdit : {
																		required : true
																	},
																
																	durationHrsEdit : {
																		required : true,
																		number: true
																	},
																	projectResource_IdEdit : {
																		required : true
																	},
																	
																	
																},
																messages : {
																	projectTaskEdit : {
																		required: "<font style='color: red;'><b>Project task is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																			projectIdEdit : "<font style='color: red;'><b> ProjectId is Required</b></font>",
																			plantStartDtEdit : "<font style='color: red;'><b>Plant StartDate is Required</b></font>",
																			plantEndDtEdit : "<font style='color: red;'><b>Plant EndDate is required</b></font>",
																			durationHrsEdit : "<font style='color: red;'><b>Durations is Required</b></font>",
																			projectResource_IdEdit : "<font style='color: red;'><b>Project task resource is Required</b></font>",
																					
																
																},

															});
										});

					});
</script>
	
	<script>
	$(function() {
		$("#plantStartDt").datepicker();
		$("#plantEndDt").datepicker();
		$("#actualStartDt").datepicker();
		$("#actualEndDt").datepicker();
		$("#plantStartDtEdit").datepicker();
		$("#plantEndDtEdit").datepicker();
		$("#actualStartDtEdit").datepicker();
		$("#actualEndDtEdit").datepicker();


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
		$("#tabs,#tabss").tabs();
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

<!-- Horizantol scroll -->
<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 100%;
}
</style>
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
	$(function() {
		$('#basicSearch').click(function() {
			$('#mainSearch').show();
			$('#basicSearch').hide();
			return false;
		});
	});
</script>
</head>
<body>
<div class="divUserDefault">
		<div class="PageTitle">Project Task</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<c:set var="editvalues" value="${editvalues }"></c:set>
					
				</c:forEach>
<c:if test="${editvalues!=null}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /></a></li>
</c:if>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /></a></li>
			</ul>
			
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<!-- ============================================Begin OrganizationSearch=================================================================================================== -->
					<form:form action="projectTaskSearch.mnt" method="get"
						commandName="ProjectTask">

						<table class="tableGeneral">
							<tr>
								<td colspan="3">
								
								<c:if test="${param.list!=null}"> 
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/></strong>
											<s:message code="label.projectTask"/> <s:message code="label.saveSuccess"></s:message>
										</div>
									</c:if>
								<c:if test="${param.listwar}">
									
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error"/> </strong>
												<s:message code="label.projectTask"/> <s:message code="label.saveFail"></s:message>
										</div>
									</c:if>
							
								
								<c:if test="${ptaskUpdate!=null}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/></strong>
										<s:message code="label.projectTask"/> <s:message code="label.updateSuccess"></s:message>
										</div>
									</c:if><c:if test="${ptaskUpdateErr!=null }">

										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.projectTask"/> <s:message code="label.updateFail"></s:message>
										</div>
									</c:if><c:if test="${projectTaskDel!=null }">

										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/></strong>
										<s:message code="label.projectTask"/> <s:message code="label.deleteSuccess"></s:message>
										</div>
                                 </c:if>
								<c:if test="${projectTaskDelErr!=null}">

										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.projectTask"/> <s:message code="label.deleteFail"></s:message>
										</div>
									</c:if></td>

							</tr>
							

							<tr id="mainSearch">
								<td> <s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <s:bind path="ProjectTask.operations">
										<select class="select" name="operations">
											<option value="<s:message code='assignedOperator'/>">
												<s:message code="label.equalsTo" />
											</option>
											<option value="<s:message code='notequalsOperator'/>">
												<s:message code="label.notEqualsTo" />
											</option>
											<option value="<s:message code='beginsWithOperator'/>">
												<s:message code="label.beginsWith" />
											</option>
											<option value="<s:message code='endsWithOperator'/>">
												<s:message code="label.endsWith" />
											</option>
											<option value="<s:message code='containsOperator'/>">
												<s:message code="label.contains" />
											</option>
										</select>
									</s:bind> <form:input path="basicSearchId" cssClass="textbox" /> <c:set
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
									
									
									 <c:choose>
										<c:when test="${true}">
											<input type="submit" value="<s:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<s:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							


							</tr>

							
						</table>
						
					</form:form>
					<!-- ============================================End OrganizationSearch=================================================================================================== -->

						<c:set var="g" value="${listofptasks}"></c:set>
					
					<c:if test="${listofptasks!=null}">
						<!-- ============================================Begin OrgDisplayTable=================================================================================================== -->
						<display:table id="projectTaskRow" name="listofptasks"
							requestURI="projectTaskSearch.mnt" pagesize="5" class="table">
							
							<display:column property="projectTask"
								titleKey="label.projectTask" media="html" sortable="true"></display:column>
							<display:column property="projectName" titleKey="label.projectid"
								media="html" sortable="true" />
							<display:column property="plantStartDt" titleKey="label.plantStartDate"
								media="html" sortable="true" />
							<display:column property="plantEndDt" titleKey="label.plantEndDate"
								media="html" sortable="true" />
							<display:column property="actualStartDt" titleKey="label.actualStartDt"
								media="html" sortable="true" />
							<display:column property="actualEndDt" titleKey="label.actualEndDt"
								sortable="true" />
							<display:column property="durationHrs" titleKey="label.duration"
								sortable="true" />
							< <display:column property="predessor" titleKey="label.predessor"
								sortable="true" /> 
							<display:column property="percentComplete" titleKey="label.percentComplete"
								sortable="true" />
							<display:column property="milestone" titleKey="label.milestone"
								sortable="true" />
							

							<c:choose>
								<c:when test="${true}">
									<display:column titleKey="label.edit" style="color:white">
										<a
											href="projectTaskEditHome.mnt?ptaskEdit=<c:out value="${projectTaskRow.projectTaskId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /></a>
									</display:column>
								</c:when>
								<c:otherwise>
									<display:column titleKey="label.edit" style="color:white">
										<a><img src="images/Edit.jpg" width="20px"
											height="20px"  class="btn btn-danger"/></a>
									</display:column>
								</c:otherwise>
							</c:choose>

							
									<display:column titleKey="label.delete">
									<c:choose>
								<c:when test="${true}">
										<a
											href="projectTaskDelete.mnt?ptaskDelete=<c:out value="${projectTaskRow.projectTaskId}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									
								</c:when>
								<c:otherwise>
								
										<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>

								</c:otherwise>

							</c:choose></display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>
					</c:if>

				</div>
			</div>
												
             <div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" id="vendorDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <s:message code="label.warning" /></strong>
									<s:message code="label.vendname" />
									<s:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="saveProjectTask.mnt" method="POST"
						commandName="ProjectTask" ENCTYPE="multipart/form-data"
						id="projectTaskAdd" name="formDD">
						<table class="tableGeneral">

							<%-- <form:hidden path="vendorAddDuplicate" /> --%>
							<tr>

								<td><s:message code="label.projectTask" /><span
									class="required">*</span></td>
								<td><form:input path="projectTask" id="vendorNameAdd"
										class="textbox"  maxlength="50" /></td>
								<td><s:message code="label.projectid" /><span
									class="required">*</span></td>
								<td><form:select path="projectId" id="projectId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${projectIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.plantStartDate" /><span
									class="required">*</span></td>
								<td><form:input path="plantStartDt" id="plantStartDt"
										class="textbox" maxlength="30"  /></td>
								<td><s:message code="label.plantEndDate" /><span class="required">*</span></td>
								<td><form:input path="plantEndDt" id="plantEndDt" class="textbox"
										maxlength="30" /></td>
							</tr>
							<tr>
								<td><s:message code="label.actualStartDt" /></td>
								<td><form:input path="actualStartDt" id="actualStartDt" class="textbox"
										maxlength="30" /></td>
								<td><s:message code="label.actualEndDt" /></td>
								<td><form:input path="actualEndDt" id="actualEndDt" class="textbox"
										maxlength="30" /></td>
							</tr>
							<tr>
								<td><s:message code="label.duration" /><span class="required">*</span></td>
								<td><form:input path="durationHrs" id="Zip" class="textbox"
										maxlength="10" /></td>
								<td><s:message code="label.predessor" /></td>
								<td><form:input path="predessor" id="Email" class="textbox"
										maxlength="40" /></td>
							</tr>
							<tr>
								<td><s:message code="label.percentComplete" /></td>
								<td><form:input path="percentComplete" id="ServiceTaxNo"
										class="textbox" maxlength="20" /></td>
								
									<td><s:message code="label.milestone" /></td>
								
							<td><form:select path="milestone" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">True</form:option>
								         <form:option value="false">False</form:option>
								</form:select></td>
							</tr>
								<tr>
								<td><s:message code="label.projectResourceid" /><span
									class="required">*</span></td>
								<td><form:select path="projectResource_Id" id="projectResource_Id"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${projectResourceIds}" />
									</form:select></td></tr>				
							
						</table>
					
							<div id="tabs-21">
								<div align="center">
									<div align="center">

										<script type="text/javascript">
											var dmrid = 1;
											function addDocument() {
												var cc = dmrid - 1;
												//alert("file  "+$('#file'+cc).val());documentName0
												if ($('#projectTaskDocument' + cc)
														.val() != ""
														&& $('#file' + cc)
																.val() != "") {

													$("#DocumentAdd tbody")
															.append(
																	"<tr id="+dmrid+">"
																			+ "<td ><s:bind path='ProjectTask.documentPath'><input name='documentPath' id='documentPath"
													+ dmrid
													+ "' "
													+ " class='textbox' /></s:bind>  </td>"
																			+ "<td><input type='file' name='file' id='file"
													+ dmrid
													+ "'  /></td>"
																			+ "<td><a href='#'  onclick='removeDocumentm("
																			+ dmrid
																			+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																			+ "</tr>");
													dmrid++;

												} else {
													alert("Please Fill The Available Document Name And File");
												}
											}
											function removeDocumentm(id) {
												
												$('#' + id).remove();
											}
										</script>

										<div id="users-contain-Document">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="DocumentAdd" class="table">
												<thead>
													<tr>

														<th><s:message code="label.docName" /><span
															class="required"></span></th>
														<th><s:message code="label.docPath" /><span
															class="required"></span></th>


														<th><s:message code="label.remove" /></th>
														<th><s:message code="label.add" /></th>

													</tr>
												</thead>
												<tbody>
													<tr id="0">

														<td><form:input path="documentPath"
																id="documentName0" class="textbox" /></td>


														<td><input type="file" name="file" id="file0" /></td>
														<td><a href='#' onclick='removeDocumentm(0)'><strong><img
																	src='images/button_cancel.png' height='20px'
																	width='20px' /></strong></a></td>
														<td><a href='#' onclick='addDocument()'><strong><img
																	src='images/add (1).png' height='20px' width='20px' /></strong></a></td>
													</tr>

												</tbody>
											</table>
										</div>
										<%-- <button id="create-AddDocuments" type="button"><s:message code="label.AddNewVendorDocuments" /></button> --%>


									</div>

								</div>
							</div>
							
						
						
						<table>
							<tr align="center">
								<td colspan="4"><c:choose>
										<c:when test="${true }">
											<input type="submit" value="<s:message code="label.save" />"
												class="btn btn-primary" id="sumbnid" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<s:message code="label.save"/> "
												class="btn btn-danger" id="sumbnid" />
										</c:otherwise>
									</c:choose><input type="reset" value="<s:message code="label.reset" />"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			
			 <div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" id="vendorDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <s:message code="label.warning" /></strong>
									<s:message code="label.vendname" />
									<s:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="updateProjectTask.mnt" method="POST"
						commandName="ProjectTask" ENCTYPE="multipart/form-data"
						id="projectTaskUp" name="formDD">
					
						<c:if test="${editvalues!=null}">


							<table class="tableGeneral">


			
							<form:hidden path="projectTaskIdEdit" /> 
						<form:hidden path="projectTaskResId" /> 

						
							<tr>

								<td><s:message code="label.projectTask" /><span
									class="required">*</span></td>
								<td><form:input path="projectTaskEdit" id="vendorNameAdd"
										class="textbox"  maxlength="50" /></td>
								<td><s:message code="label.projectid" /><span
									class="required">*</span></td>
								<td><form:select path="projectIdEdit" id="customerId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${projectIds}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.plantStartDate" /><span
									class="required">*</span></td>
								<td><form:input path="plantStartDtEdit" id="plantStartDtEdit"
										class="textbox" maxlength="30"  /></td>
								<td><s:message code="label.plantEndDate" /><span class="required">*</span></td>
								<td><form:input path="plantEndDtEdit" id="plantEndDtEdit" class="textbox"
										maxlength="30" /></td>
							</tr>
							<tr>
								<td><s:message code="label.actualStartDt" /></td>
								<td><form:input path="actualStartDtEdit" id="actualStartDtEdit" class="textbox"
										maxlength="30" /></td>
								<td><s:message code="label.actualEndDt" /></td>
								<td><form:input path="actualEndDtEdit" id="actualEndDtEdit" class="textbox"
										maxlength="30" /></td>
							</tr>
							<tr>
								<td><s:message code="label.duration" /><span class="required">*</span></td>
								<td><form:input path="durationHrsEdit" id="Zip" class="textbox"
										maxlength="10" /></td>
								<td><s:message code="label.predessor" /></td>
								<td><form:input path="predessorEdit" id="Email" class="textbox"
										maxlength="40" /></td>
							</tr>
							<tr>
								<td><s:message code="label.percentComplete" /></td>
								<td><form:input path="percentCompleteEdit" id="ServiceTaxNo"
										class="textbox" maxlength="20" /></td>
								
									<td><s:message code="label.milestone" /></td>
								
							<td><form:select path="milestoneEdit" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">True</form:option>
								         <form:option value="false">False</form:option>
								</form:select></td>
							</tr>
								<tr>
								<td><s:message code="label.projectResourceid" /><span
									class="required">*</span></td>
								<td><form:select path="projectResource_IdEdit" id="projectResource_IdEdit"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${projectResourceIds}" />
									</form:select></td></tr>				
							
						</table>
					
								<div id="tabs-22">
									<div align="center">

										<div align="center">

											<div id="users-contain-DocumentEdit">
												<!-- class="ui-widget" -->
												<h3></h3>
												<table id="DocumentEdit" class="table">
													<thead>
														<tr>
															<th><s:message code="label.docName" /><span
																class="required"></span></th>
															<th><s:message code="label.docPath" /><span
																class="required"></span></th>
															<th><s:message code="label.remove" /></th>
															<th><s:message code="label.edit" /></th>
														</tr>
													</thead>
													<tbody>
													
											 	<input type="hidden" name="projectTaskDocIdEdit" value="0"/>  
														<c:forEach var="pTaskDocumentEditValues"
															items="${pTaskDocumentsValues}">
												<input type="hidden" name="checkPrevious"
																	id="checkPrevious" value="1" />
																		<tr id="${pTaskDocumentEditValues.projectTaskDocId}">

																<td><input type="text" name="projectTaskDocumentEdit"
																	id="projectTaskDocumenEdit${pTaskDocumentEditValues.projectTaskDocId}"
																	class="textbox"
																	value="${pTaskDocumentEditValues.projectTaskDocumentEdit}"
																	readonly="readonly" /></td>

																<td><a
																	href="download.mnt?id=${pTaskDocumentEditValues.documentPathEdit}">Click
																		here to download file</a> 
																		
																		<input type="hidden"
																	name="projectTaskDocIdEdit" id="projectTaskDocIdEdit"
																	value="${pTaskDocumentEditValues.projectTaskDocId}" />
																	 <input
																	type="hidden" name="documentPathEdit"
																	id="documentPathEdit"
																	value="${pTaskDocumentEditValues.documentPathEdit}" /> <input
																	type="hidden"
																	name="${pTaskDocumentEditValues.projectTaskDocId}Checkdelete"
																	id="${pTaskDocumentEditValues.projectTaskDocId}Checkdelete"
																	value="0" /> 
																		<td><a href="#"
																	id="${pTaskDocumentEditValues.projectTaskDocId}"
																	onclick="checkDocEdit(this)"><img
																		src="images/button_cancel.png" height="20px"
																		width="20px"></img></a></td>
									
																		 
																<td></td>
															</tr>
														</c:forEach> 
														<tr id="200">

															<td><form:input path="projectTaskDocumentEdit"
																	id="documentName200" class="textbox" /></td>


															<td><input type="file" name="file" id="file200" /></td>
															<td><a href='#' onclick='removeDocumentEdit(200)'><strong><img
																		src='images/button_cancel.png' height='20px'
																		width='20px' /></strong></a></td>
															<td><script type="text/javascript">
																function checkDocEdit(
																		link) {

																	alert("Deleting Particular Row Will Deleted Once You Click Update Button Doc");
															
																	document
																			.getElementById(link.id
																					+ "Checkdelete").value = "1";
																	alert(document
																			.getElementById(link.id
																					+ "Checkdelete").value);
																	document
																			.getElementById(link.id).style.display = "none";
																}

																function removeDocumentEdit(
																		id) {
																	
																	$('#' + id)
																			.remove();
																}
																var deditmrid = 201;
																var cc = deditmrid - 1;
																function addDocumentEdit() {
																	if ($(
																			'#projectTaskDocumentEdit'
																					+ cc)
																			.val() != ""
																			&& $(
																					'#file'
																							+ cc)
																					.val() != "") {

																		$(
																				"#DocumentEdit tbody")
																				.append(
																						"<tr id="+deditmrid+">"
																								+ "<td ><s:bind path='ProjectTask.projectTaskDocumentEdit'><input name='projectTaskDocumentEdit' id='documentName"
																	+ deditmrid
																	+ "'"
																	+ " class='textbox' /></s:bind> <input type='hidden' name='projectTaskDocIdEdit' id='projectTaskDocIdEdit'"
									                                +" value='0' />    <input type='hidden' name='checkPreviousEdit' id='checkPreviousEdit'"
									                                +" value='0' /></td>"
																								+ "<td><input type='file' name='file' id='file"
																	+ deditmrid
																	+ "'  /></td>"
														
														+ "<input type='hidden' name='projectTaskDocIdEdit' value='0' id='projectTaskDocIdEdit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/>"
																	

																								+ "<td><a href='#'  onclick='removeDocumentEdit("
																								+ deditmrid
																								+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																								+ "</tr>");

																		deditmrid++;
																	} else {
																		alert("Please Fill The Available Document Name And File");
																	}

																}
															</script> <a href='#' onclick='addDocumentEdit()'><strong><img
																		src='images/add (1).png' height='20px' width='20px' /></strong></a></td>
														</tr>




													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
                <table>
								<tr align="center">
									<td colspan="4" align="center"><c:choose>
											<c:when test="${true}">

												<input type="submit"
													value="<s:message code="label.update" />"
													class="btn btn-primary" id="updatebtn" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<s:message code="label.update"/>"
													class="btn btn-danger" id="updatebtn" />
											</c:otherwise>

										</c:choose></td>
								</tr>

							</table>
							</c:if>
					</form:form>
					
				</div>
			</div>
</div></div>
</body>
</html>