<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


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
<script type="text/javascript" src="js/MntValidator.js"></script>
 <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
	<script type="text/javascript">
	$(document)
			.ready(
					function() {
						jQuery.validator.addMethod("alphaNumeric", function (value, element) {
							  
					        return this.optional(element) || /^[a-zA-Z&]+$/.test(value);
					    });
						//AddForm Validations
						
						
						$('#subid')
								.click(
										function(event) {
											
											$('#addTScheduleForm')
													.validate(
															{
																rules : {
																	
																	date:{
																		required : true	
																		},
																		time:{
																			required : true	
																		},
																		venue:{
																			required : true,
																			alphaNumeric : true,
																			maxlength : 50,
																			
																		},
																		triner:{
																			required : true,
																			alphaNumeric : true,
																			maxlength : 50,
																		},
																		trainingCategoryId:{
																			required : true	
																		},
																		org_Id:{
																			required : true	
																		},
																		 
																		 
																		
																},
																 messages : {
																	 date : "<font style='color: red;'><b>Delivery Note Date is Required</b></font>",
																	 time : "<font style='color: red;'><b>Sales Order is Required</b></font>",
																	 venue :
																	 {
																			required :"<font style='color: red;'><b>Venue is Required</b></font>",
																			alphaNumeric:"<font style='color:red;'><b>should not allow special symbols</b></font>",
																			maxlength:"<font style='color:red;'><b>length upto 50 charecters only</b></font>"
																	 },
																			triner :  {
																				required :"<font style='color: red;'><b>Trainer is Required</b></font>",
																				alphaNumeric:"<font style='color:red;'><b>should not allow special symbols</b></font>",
																				maxlength:"<font style='color:red;'><b>length upto 50 charecters only</b></font>"
																		 },
																			
																		 trainingCategoryId : "<font style='color: red;'><b>Training Category is Required</b></font>",
																		 org_Id : "<font style='color: red;'><b>Organization is Required</b></font>",
																	 
																},
																
																	});
															});
									//	});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
									
											$('#editTScheduleForm')
													.validate(
															{
																rules : {
																	dateEdit:{
																		required : true	
																		},
																		timeEdit:{
																			required : true	
																		},
																		venueEdit:{
																			required : true,
																			alphaNumeric : true,
																			maxlength : 50,
																			
																		},
																		trainerEdit:{
																			required : true,
																			alphaNumeric : true,
																			maxlength : 50,
																		},
																		trainingCategoryIdEdit:{
																			required : true	
																		},
																		org_IdEdit:{
																			required : true	
																		},
																		 
																		 
																		
																},
																messages : {
																	 dateEdit : "<font style='color: red;'><b>Delivery Note Date is Required</b></font>",
																	 timeEdit : "<font style='color: red;'><b>Sales Order is Required</b></font>",
																	 venueEdit :
																	 {
																			required :"<font style='color: red;'><b>Venue is Required</b></font>",
																			alphaNumeric:"<font style='color:red;'><b>should not allow special symbols</b></font>",
																			maxlength:"<font style='color:red;'><b>length upto 50 charecters only</b></font>"
																	 },
																			trainerEdit :  {
																				required :"<font style='color: red;'><b>Trainer is Required</b></font>",
																				alphaNumeric:"<font style='color:red;'><b>should not allow special symbols</b></font>",
																				maxlength:"<font style='color:red;'><b>length upto 50 charecters only</b></font>"
																		 },
																			
																		 trainingCategoryIdEdit : "<font style='color: red;'><b>Training Category is Required</b></font>",
																		 org_IdEdit : "<font style='color: red;'><b>Organization is Required</b></font>",
																	 
																},
															});

										}); 
						
					});
</script>

<script type="text/javascript">
function dateFun(datePattern) {
	$('#date,#dateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
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
$('#add').click(function(e) {
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
		<div class="PageTitle">TrainingSchedule</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<c:set var="editvalues" value="${editvalues }"></c:set>

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


					<table class="tableGeneral">
						<form:form action="searchTSchedule.mnt" method="GET"
							commandName="TrainingSchedule">
							<tr>
								<td colspan="2">
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.trainingSchedule"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
											<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.trainingSchedule"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="TScheduleDel"
										items="${TScheduleDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.trainingSchedule"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="TScheduleDelErr"
										items="${TScheduleDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.trainingSchedule"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="TScheduleUpdate"
										items="${TScheduleUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.trainingSchedule"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="TScheduleUpdateErr"
										items="${TScheduleUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.trainingSchedule"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
								</td></tr>
								
								
										<tr id="mainSearch">
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
								 <c:set var="save" value="false"></c:set>
                                   <c:set var="edit" value="false"></c:set>
                                   <c:set var="delete" value="false"></c:set>
                                   <c:set var="update" value="false"></c:set>
                                   <c:set var="search" value="false"></c:set>
								<fmt:setBundle basename="button" />
								<fmt:message key="label.save" var="messagesav" />
								<fmt:message key="label.search" var="messagesea" />
								<fmt:message key="label.delete" var="messagedel" />
								<fmt:message key="label.update" var="messageup" />
									<fmt:message key="label.edit" var="messageed" />
								<c:forEach items="${sessionScope.privilegeList}"
									var="privileges">
									
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
										<c:when test="${privileges eq messageup}">
										<c:set var="update" value="true"></c:set>
										</c:when>
										</c:choose>
								</c:forEach>
							
								<td><c:choose><c:when test="${true}">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></c:otherwise>
								</c:choose></td>
							</tr>
						</form:form>

					</table>


					<c:forEach var="trainingScheduleDetails" items="${listofDNotes}">
						<c:set var="ag" value="${trainingScheduleDetails}"></c:set>
					</c:forEach>
					<c:if test="${ag!=null}">
						<div>
							<display:table id="listofDNotes" name="listofDNotes"
								requestURI="searchTSchedule.mnt" pagesize="5" class="table">
								<display:column property="trainingSchedule_Id" titleKey="label.trainingSchedule"
									media="none" sortable="true"></display:column>
								<display:column property="date"
									titleKey="label.date" media="html" sortable="true"></display:column>
                              	<display:column property="time"
									titleKey="label.time" media="html" sortable="true"></display:column>
                              	<display:column property="venue"
									titleKey="label.venue" media="html" sortable="true"></display:column>
										<display:column property="triner"
									titleKey="label.triner" media="html" sortable="true"></display:column>
                             <display:column property="trainingCategory"
									titleKey="label.trainingCategoryId" media="html" sortable="true"></display:column>
                             <display:column property="org_Name"
									titleKey="label.org_Id" media="html" sortable="true"></display:column>
                             
                             
								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
									<c:when test="${true }"><a
										href="tScheduleEdit.mnt?tsEditId=<c:out value="${listofDNotes.trainingSchedule_Id}"/>"
										style="color: red"><img src="images/Edit.jpg" width="20px"
										onclick="toggleTable();" height="20px" /> </a>
								</c:when><c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose></display:column>
								<display:column titleKey="label.delete">
									<c:choose>
									<c:when test="${true }"><a
										href="tScheduleDelete.mnt?tsdelId=<c:out value="${listofDNotes.trainingSchedule_Id}"/>"
										style="color: red"><img src="images/Delete.jpg"
										width="20px" height="20px"
										onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a></c:when><c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
								</display:column>
								<display:setProperty name="paging.banner.placement"
									value="bottom" />

							</display:table>
						</div>
					</c:if>

				</div>
			</div>

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="saveTSchedule.mnt" method="POST"
						commandName="TrainingSchedule" id="addTScheduleForm" >
						

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">


										<tr>
										<td><spring:message code="label.date" /><span
												class="required">*</span></td>
											<td><form:input path="date" id="date"
													class="textbox" /></td>

										</tr>
											<tr>
										<td><spring:message code="label.time" /><span
												class="required">*</span></td>
											<td><form:input path="time" id="time"
													class="textbox" /></td>

										</tr>
										<tr>
										<td><spring:message code="label.venue" /><span
												class="required">*</span></td>
											<td><form:input path="venue" id="venue"
													class="textbox" /></td>

										</tr>
										<tr>
										<td><spring:message code="label.triner" /><span
												class="required">*</span></td>
											<td><form:input path="triner" id="triner"
													class="textbox" /></td>

										</tr>
											<tr>
												<td><spring:message code="label.trainingCategoryId" /><span
													class="required">*</span></td>
												<td><form:select path="trainingCategoryId" id="trainingCategoryId"
														cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${trainingCategoryDetails}" />
													</form:select></td>
											</tr>
										
											<tr>
												<td><spring:message code="label.org_Id" /><span
													class="required">*</span></td>
												<td><form:select path="org_Id" id="org_Id"
														cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${orgDetails}" />
													</form:select></td>
											</tr>
										
										
									</table>
								</td>
							</tr>
						</table>
						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message
											code="label.trainingScheduleLine" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								

								<script>
									var btrfqid = 1;
									$(function() {

										

										var empid = $("#employeeId"),hiddenVacancyID = $("#hiddenIdVacancyPopUp"),

										allFields = $([]).add(empid).add(hiddenVacancyID),
												tips = $(".validateTips");

										function updateTips(t) {
											tips.text(t).addClass(
													"ui-state-highlight");
											setTimeout(function() {
												tips.removeClass(
														"ui-state-highlight",
														1500);
											}, 500);
										}
										
										
										$("#dialog-form-Rfq")
												.dialog(
														{
															autoOpen : false,
															height : 250,
															width : 300,
															modal : true,
															buttons : {
																Submit : function() {

																	var bValid1 = true;
																	allFields
																			.removeClass("ui-state-error");
																	/* bValid1 = bValid1
																			&& checkLength1(
																					empid,

																					"Employee is Required");

														 */			
																
																	if (bValid1) {

																		if (hiddenVacancyID
																				.val() == "0"
																				|| hiddenVacancyID
																						.val() == "") {

																			$(
																					"#deliveryAdd tbody")
																					.append(

																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='employeeId' id='employeeId"
																									+ btrfqid
																									+ "' value="
																									+ empid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ " <input type='text' readonly class='textbox' name='empName' id='empName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#employeeId :selected')
																											.text()
																									+ "'"
																									+ " /></td>"
																									+																									
																									"<td><a href='#'  onclick='editRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																									+ "<td><a href='#'  onclick='removeRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																									+ "</tr>");

																			btrfqid++;
																			$(
																					this)
																					.dialog(
																							"close");
																		}

																		 if (hiddenVacancyID
																				.val() != "0") {
																			$(
																					'#employeeId'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							empid
																									.val());

																			$(
																					'#empName'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							$(
																									'#employeeId :selected')
																									.text());

																			
																			
																			

																			$(
																					'#hiddenIdVacancyPopUp')
																					.val(
																							"0");
																			$(
																					this)
																					.dialog(
																							"close");
																		} 
																	}
																},
																Cancel : function() {
																	$(this)
																			.dialog(
																					"close");
																}
															},
															close : function() {
																allFields
																		.val("")
																		.removeClass(
																				"ui-state-error");
															}
														});

										$("#Rfqlineadd").button().click(
												function() {
													$("#dialog-form-Rfq")
															.dialog("open");

												});
									});
									function removeRfq(id) {
										$('#' + id).remove();
									}
									 function editRfq(id) {

										$("#dialog-form-Rfq").dialog("open");
										$('#employeeId').val(
												$('#employeeId' + id).val());
										
										$('#hiddenIdVacancyPopUp').val(id);

									} 
								</script>


								<div id="dialog-form-Rfq" align="center"
									title="Add New TrainingSchedule Details">
									<p class="validateTips" align="center">
										<font color="red">All form fields are required</font>
									</p>
									<table class="table" cellspacing=0>
										<tr>
											<td><spring:message code="label.employee" /><span
												class="required">*</span></td>
											<td><form:select path="employeeId" id="employeeId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${employeeDetails}" />
												</form:select></td>
										</tr>

										
										
										
										
										

										<tr>
											
											<td>
												
												<input type="hidden"
												name="hiddenIdVacancyPopUp" id="hiddenIdVacancyPopUp"
												value="0" /></td>
										</tr>



									</table>
									<table>

									</table>
								</div>



								<div id="users-contain-Rfq">
									<!-- class="ui-widget" -->
									<h3></h3>
									<table id="deliveryAdd" class="table">
										<thead>
											<tr>
											
												<th><spring:message code="label.employee" /></th>
												
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>

											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<button id="Rfqlineadd" type="button">
										<spring:message code="label.addtrainingScheduleline" />
									</button>
								</div>

								<form:hidden path="tSchedulehide" />

								<!-- </div> -->





								<table>
									<tr>
										<td colspan="2"><c:choose>
										<c:when test="${true }"><input type="submit"
											value="<spring:message code="label.save"/>"
											class="btn btn-primary" id="subid" /> </c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>"
									class="btn btn-danger" /></c:otherwise>
									</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
									</tr>
								</table>
								<!-- </div> -->
							</div>
						</div>
					</form:form>

				</div>
			</div>
			 <div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="tScheduleUpdate.mnt" method="POST"
						commandName="TrainingSchedule" id="editTScheduleForm">
						 
						
						<c:if test="${editvalues!=null}">


							<table class="tableGeneral">


								<form:hidden path="" />
								<form:hidden path="trainingSchedule_IdEdit" />
									<tr>
										<td><spring:message code="label.date" /><span
												class="required">*</span></td>
											<td><form:input path="dateEdit" id="dateEdit"
													class="textbox" /></td>

										</tr>
											<tr>
										<td><spring:message code="label.time" /><span
												class="required">*</span></td>
											<td><form:input path="timeEdit" id="timeEdit"
													class="textbox" /></td>

										</tr>
										<tr>
										<td><spring:message code="label.venue" /><span
												class="required">*</span></td>
											<td><form:input path="venueEdit" id="venueEdit"
													class="textbox" /></td>

										</tr>
										<tr>
										<td><spring:message code="label.triner" /><span
												class="required">*</span></td>
											<td><form:input path="trainerEdit" id="trainerEdit"
													class="textbox" /></td>

										</tr>
											<tr>
												<td><spring:message code="label.trainingCategoryId" /><span
													class="required">*</span></td>
												<td><form:select path="trainingCategoryIdEdit" id="trainingCategoryIdEdit"
														cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${trainingCategoryDetails}" />
													</form:select></td>
											</tr>
										
											<tr>
												<td><spring:message code="label.org_Id" /><span
													class="required">*</span></td>
												<td><form:select path="org_IdEdit" id="org_IdEdit"
														cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${orgDetails}" />
													</form:select></td>
											</tr>
										
							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.trainingScheduleLine" /></a></li>

								</ul>


								<div align="center">

									
									<script>
										var btrfqid = 1;
										$(function() {

											
											var empidEdit = $("#employeeIdEdit"),ehiddenrfqID = $("#hiddenIdvacancyeditPopUp"),

											allFields = $([]).add(empidEdit).add(ehiddenrfqID),
													tips = $(".validateTips");

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips
																	.removeClass(
																			"ui-state-highlight",
																			1500);
														}, 500);
											}

											
											

											
											$("#dialog-form-RfqEdit")
													.dialog(
															{
																autoOpen : false,
																height : 250,
																width : 300,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid2 = true;
																		allFields
																				.removeClass("ui-state-error");
/* 
																	 	bValid2 = bValid2
																				&& checkLength2(
																						empidEdit,

																						"Employee is Required");
												 		 */				

																	
																	if (bValid2) {
																		//alert("append=="+ehiddenrfqID.val());
                                                                  
                                                                      if (ehiddenrfqID
																					.val() == "0"
																					|| ehiddenrfqID
																							.val() == "") {
																			

																				$(
																						"#RFQEdit tbody")
																						.append(
																								"<tr id="+btrfqid+">"
																										+ "<td ><spring:bind path='TrainingSchedule.trainingScheduleDet_IdEdit' ><input type='hidden'name='trainingScheduleDet_IdEdit'  value='0'/> <input type='hidden' name='employeeIdEdit' id='employeeIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ empidEdit
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  "
																										+ "<spring:bind path='TrainingSchedule.empNameEdit'><input type='text' readonly class='textbox' name='empNameEdit' id='empNameEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#employeeIdEdit :selected')
																												.text()
																										+ "'"
																										+ "</spring:bind></td>"
																																																			
																										
																										+ " <input type='hidden' name='trainingScheduleDet_IdEdit' value='0' id='trainingScheduleDet_IdEdit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
																										+

																										
																										"<td><a href='#'  onclick='editRfqEdit("
																										+ btrfqid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeRfqEdit("
																										+ btrfqid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");

																				btrfqid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}

																			if (ehiddenrfqID
																					.val() != "0") {
																				
																				$('#employeeIdEdit'+ ehiddenrfqID.val()).val(empidEdit.val());
																				
																																				
																								
																										
																				$(
																						'#empNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#employeeIdEdit :selected')
																										.text());
																				
																				
																				
																				

																				$(
																						'#hiddenIdvacancyeditPopUp')
																						.val(
																								"0");
																				
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		}
																	},
																	Cancel : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																close : function() {
																	allFields
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

											$("#AddRFQEdit")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-RfqEdit")
																		.dialog(
																				"open");
																
															});
										});
										function removeRfqEdit(id) {
											$('#' + id).remove();
										}

										function editRfqEdit(id) {
										

											$("#dialog-form-RfqEdit").dialog(
													"open");
											
                        
											$('#employeeIdEdit').val(
													$('#employeeIdEdit' + id).val());
																				
											
											$('#hiddenIdvacancyeditPopUp').val(id);  
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-RfqEdit" align="center"
										title="Add New TrainingScheduleLine Details">
										<p class="validateTips" align="center">
											<font color="red">All form fields are required</font>
										</p>
										<table class="tableGeneral" cellspacing=0>
										
											<form:hidden path="trainingScheduleDet_IdEdit" id="trainingScheduleDet_IdEdit" value="0" />
											<tr>
												<td>
												<input type="hidden"
													name="hiddenIdvacancyeditPopUp" id="hiddenIdvacancyeditPopUp" value="0" />
												<spring:message code="label.employee" /><span
													class="required">*</span></td>
												<td><form:select path="employeeIdEdit"
														id="employeeIdEdit" cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${employeeDetails}" />
													</form:select></td>
											</tr>

										</table>

									</div>



									<div id="users-contain-Process">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="RFQEdit" class="table">
											
												<thead>
													<tr>

															<th><spring:message code="label.employee" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>

													</tr>
												</thead>


											
											<tbody>
												<c:forEach items="${tScheduleLinedetails}"
													var="tScheduleLinedetails">
                                          			<spring:bind path="TrainingSchedule.trainingScheduleDet_IdEdit">
														<input type="hidden" name="trainingScheduleDet_IdEdit"
															id="trainingScheduleDet_IdEdit${tScheduleLinedetails.trainingScheduleDet_IdEdit}"
															value="${tScheduleLinedetails.trainingScheduleDet_IdEdit}" />
													</spring:bind>

                                                    
                                                                                                         
													 <tr id="${tScheduleLinedetails.trainingScheduleDet_IdEdit}">
														<td><spring:bind path="TrainingSchedule.employeeIdEdit">
																<input type="hidden" name="employeeIdEdit"
																	class="textbox"
																	id="employeeIdEdit${tScheduleLinedetails.trainingScheduleDet_IdEdit}"
																	value="${tScheduleLinedetails.employeeIdEdit}" />
															</spring:bind> <spring:bind path="TrainingSchedule.empNameEdit">
																<input type="text" name="empNameEdit" class="textbox"
																	id="empNameEdit${tScheduleLinedetails.trainingScheduleDet_IdEdit}"
																	value="${tScheduleLinedetails.empNameEdit}" readonly="readonly" />
															</spring:bind>
 
																											
												
														<input type="hidden"
															name="Checkdelete${tScheduleLinedetails.trainingScheduleDet_IdEdit}"
															id="${tScheduleLinedetails.trainingScheduleDet_IdEdit}Checkdelete"
															value="0" /></td>


														<td><a href='#' id="${tScheduleLinedetails.trainingScheduleDet_IdEdit}" onclick="editRfqEdit(this.id)"><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>
													
														<td><a href='#'
															id="${tScheduleLinedetails.trainingScheduleDet_IdEdit}"
															onclick="getID11(this)"><strong><img
																	src='images/button_cancel.png' height='25px'
																	width='25px' /></strong></a></td>
													</tr>



													<script type="text/javascript">
														function getID11(link) {
															
															alert("Deleting Particular Row Will Deleted Once You Click Update Button");
															document
																	.getElementById(link.id
																			+ "Checkdelete").value = "1";
															document
																	.getElementById(link.id).style.display = "none";
														}
														function editProcessDetailsInEdit(
																link) {
															

															$(
																	"#dialog-form-RfqEdit")
																	.dialog(
																			"open");
															$(
																	'#employeeIdEdit'
																			+ link.id)
																	.val(
																			$(
																					'#employeeIdEdit')
																					.val());
																																													
															$(
																	'#hiddenIdvacancyeditPopUp')
																	.val(
																			link.id);

														}
													</script>

												</c:forEach>
											</tbody>
										</table>
										<button id="AddRFQEdit" type="button">Add TrainingScheduleLine Details</button>
									</div>

								</div>

							</div>

							<table>
								<tr>
									<td colspan="2" align="center"><c:choose>
									<c:when test="${true }"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateid" /></c:when><c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
										</c:otherwise></c:choose></td>

								</tr>

							</table>
						</c:if>
					</form:form>


				</div>
			</div>
 
 

		</div>
	</div>
</body>
</html>