<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'Resource Request.jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
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
<!--  Date picker -->
<script type="text/javascript">
function dateFun(datePattern) {
	$('#recruitmentPlanDT,#recruitmentPlanDTEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>
<!-- <script>
	$(function() {

		$("#recruitmentPlanDT").datepicker();
		$("#recruitmentPlanDTEdit").datepicker();
	
		

	});
</script> -->
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submit')
								.click(
										function(event) {

											$('#addform')
													.validate(
															{
																rules : {
																	productionPlanType_Id : {
																		required : true
																	},
																	planDate : {
																		required : true
																	},
																	
																	plant_Id : {
																		required : true
																	},
																	project_Id : {
																		required : true
																	},
																	status_Id : {
																		required : true
																	},
																	
																	
																	

																},
																messages : {
																	productionPlanType_Id : "<font style='color: red;'><b>Production Plan Type is Required</b></font>",

																	planDate : "<font style='color: red;'><b>Plan Date is Required</b></font>",

																	plant_Id : "<font style='color: red;'><b>Plant is Required</b></font>",

																	project_Id : "<font style='color: red;'><b>Project is Required</b></font>",

																	status_Id : "<font style='color: red;'><b>Status is Required</b></font>",

																	

																	


																}
															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											
											//alert(assetedit);
											$('#editForm')
													.validate(
															{
																rules : {
																	productionPlanType_IdEdit : {
																		required : true
																	},
																	planDateEdit : {
																		required : true
																	},
																	
																	plant_IdEdit : {
																		required : true
																	},
																	project_IdEdit : {
																		required : true
																	},
																	status_IdEdit : {
																		required : true
																	},
																},
																messages : {
																	productionPlanType_IdEdit : "<font style='color: red;'><b>Production Plan Type is Required</b></font>",

																	planDateEdit : "<font style='color: red;'><b>Plan Date is Required</b></font>",

																	plant_IdEdit : "<font style='color: red;'><b>Plant is Required</b></font>",

																	project_IdEdit : "<font style='color: red;'><b>Project is Required</b></font>",

																	status_IdEdit : "<font style='color: red;'><b>Status is Required</b></font>",

 
																},
															});

										});

					});
</script>


<script>
	$(function() {
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




</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Recruitment Plan</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="recPlanEdit" items="${recPlanEdit}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!-- Tab-2 -->
	<div id="tabs-2" class="TabbedPanelsContent">
			
<div align="left" class="TabbedPanelsContent">
					<form:form method="get" action="recruitmentPlanSearch.mnt"
						commandName="RecruitmentPlanCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="recPlanAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.RecruitmentPlan"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.RecruitmentPlan"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
						<c:forEach var="recPlanUpdate"
										items="${recPlanUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.RecruitmentPlan"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="recPlanUpdateError"
										items="${recPlanUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.RecruitmentPlan"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="recPlanDelete"
										items="${recPlanDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.RecruitmentPlan"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="recPlanDeleteError"
										items="${recPlanDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.RecruitmentPlan"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr> 
							


							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="0">-Select-</form:option>
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

                   <c:forEach var="recruitmentPlanValues" items="${recruitmentPlanValues}">

						<c:set var="as" value="${recruitmentPlanValues}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">

					<display:table name="recruitmentPlan" id="recruitmentPlan" class="table"
						requestURI="recruitmentPlanSearch.mnt" pagesize="5">
						<display:column property="vacancyNo" sortable="true"
							titleKey="label.Vacancy" media="html" />
					
						<display:column property="recruitmentPlanDT" sortable="true"
							titleKey="label.RecruitmentPlanDT" media="html" />
							
						
							
						<display:column titleKey="label.edit">
							<a
								href="recruitmentPlanEdit.mnt?recruitmentPlanId=<c:out value="${recruitmentPlan.recruitmentPlanId}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:column titleKey="label.delete">
							<a
								href="recruitmentPlanDelete.mnt?recruitmentPlanId=<c:out value="${recruitmentPlan.recruitmentPlanId}"/> "
								onclick="return confirm('Do You Want To Delete This Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
						</display:column>

						<display:setProperty name="paging.banner.placement" value="bottom" />
					</display:table>

</c:if>

				</div>

			</div> 
			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form commandName="RecruitmentPlanCommand" id="addform" method="POST"
						action="RecruitmentPlanAdd.mnt">
						<table class="tableGeneral">
						
						 <tr>
							<td><spring:message code="label.Vacancy"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="vacancyId" id="vacancyId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${vacancy }" />
									</form:select></td>
                                  
							</tr>
						<tr>
						<td><spring:message code="label.RecruitmentPlanDT"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="recruitmentPlanDT" id="recruitmentPlanDT" class="textbox" /></td>
							
                                </tr>
                               
							
                              
</table>

					 		 <div id="tabsForAdd">
								<!-- Recruitment Plan Line Tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.RecruitmentPlanLine" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
										var btresreqid = 1;
										$(function() {

											var 
										
											interviewRoundId = $("#interviewRoundId"), 
											intervNumber=$("#intervNumber"), 

												description=$("#description"),
												hiddenRecruitmentPlanID = $("#hiddenRecruitmentPlanPopUp"),
											
											
											
											allFields = $([]).add(interviewRoundId).add(intervNumber).add(description).add(hiddenRecruitmentPlanID),
											 tips = $(".validateTips");

											

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
																
											function selectLength(o, n) {
												if (o.val()=='0') {
													o
															.addClass("ui-state-error");
													updateTips(n+" is Required");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp,
													n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}
											$("#dialog-form-resReq")
													.dialog(
															{
																autoOpen : false,
																height : 270,
																width : 300,
																modal : true,
																buttons : {
																	Submit : function() {
																		
																		var bValid1 = true;
																		allFields.removeClass("ui-state-error");
                                    								
																		
																	 bValid1 = bValid1
																		&& selectLength(
																				interviewRoundId,
																				"Interview Round"
																				);
																		bValid1 = bValid1
																		&& checkLength(
																				description,
																				"Description",
																				1,
																				16);
																	
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenRecruitmentPlanID
																					.val() == "0"
																					|| hiddenRecruitmentPlanID
																							.val() == "") {
																				
																				
																				$("#resReqAdd tbody")
																						.append(
																								"<tr id="+btresreqid+">"
																								



																								     + "<td ><spring:bind path='RecruitmentPlanCommand.interviewRoundId'><input type='hidden' name='interviewRoundId' id='interviewRoundId"
																										+ btresreqid
																										+ "' value="
																										+ interviewRoundId
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='intervNumber' id='intervNumber"
																										+ btresreqid
																										+ "' value="
																										+ $('#interviewRoundId :selected').text()
																																																				
																										+ " class='textbox'readonly/></td>" 
																										
																										
																										+ "<td align='center'><input type='text' name='description' id='description"
																									      + btresreqid
																									     + "' value="
																									     + description
																											.val()
																									     + "  class='textbox'readonly/></td>"
																									     
																								    
																									    +"<td><a href='#'  onclick='editRecruitmentPlan("
																										+ btresreqid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btresreqid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btresreqid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenRecruitmentPlanID
																					.val() != "0") {				 
																			
																		
																				
																				$(
																						'#interviewRoundId'
																								+ hiddenRecruitmentPlanID
																										.val())
																						.val(
																								interviewRoundId 
																								        .val());
																				$(
																						'#intervNumber'
																								+ hiddenRecruitmentPlanID
																										.val())
																						.val(
																								 $('#interviewRoundId :selected').text());
																				
																				$(
																						'#description'
																								+ hiddenRecruitmentPlanID
																										.val())
																						.val(
																								description 
																								        .val());
																				
																				$(
																						'#hiddenRecruitmentPlanPopUp')
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

										
											$("#AddResReq")
													.button()
													.click(
															function() {
														
																$("#dialog-form-resReq")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editRecruitmentPlan(id) {
									
											$("#dialog-form-resReq").dialog("open");
								
																					
											$('#interviewRoundId').val(
													$('#interviewRoundId' + id).val());
											
											$('#intervNumber').val(
													$('#intervNumber' + id).val()); 
											
											$('#description').val(
													$('#description' + id).val());
											
										
											$('#hiddenRecruitmentPlanPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-resReq" title="Add New RecruitmentPlan Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
								
														
															
															 <tr>
												<td><spring:message code="label.InterviewRound" /><font color="red">*</font></td>
												<td><form:select path="interviewRoundId" id="interviewRoundId" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${interviewRound}" /> 
													
												</form:select>	</td></tr>
																		<tr>
						<td><spring:message code="label.Description"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="description" id="description" class="textbox" />
															
											<input type="hidden"
													name="hiddenRecruitmentPlanPopUp" id="hiddenRecruitmentPlanPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="resReqAdd" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.InterviewRound" /><font color="red">*</font></th>
													<th><spring:message code="label.Description" /><font color="red">*</font></th>
												
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="AddResReq" type="button">Add New Recruitment Plan Details</button>
									

								</div>
							</div>
							</div>  
						<input type="submit" id="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary"/><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" />
						
					</form:form>

				</div>
			</div>

			<!-- Tab-1 -->

			 <div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="recPlanEdit" items="${recPlanEdit}">

						<form:form method="post" action="recruitmentPlanUpdate.mnt"
							commandName="RecruitmentPlanCommand" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="recruitmentPlanIdEdit" id="recruitmentPlanIdEdit" /> 
                               
							
                                		 <tr>
												<td><spring:message code="label.Vacancy" /><font color="red">*</font></td>
												<td><form:select path="vacancyIdEdit" id="vacancyIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${vacancy}" /> 
													
												</form:select>	</td></tr>
																		<tr>
						<td><spring:message code="label.RecruitmentPlanDT"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="recruitmentPlanDTEdit" id="recruitmentPlanDTEdit" class="textbox" /></td></tr>
                               

							</table>
							
							<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.RecruitmentPlanLine" /></a></li>

								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {
									
												var 
												interviewRoundIdEdit=$("#interviewRoundIdEdit"),
												descriptionEdit=$("#descriptionEdit"),
											
											
												hiddenEdit = $("#hiddenRecruitmentPlanPopUpEdit"),
												
												allFields = $([]).add(interviewRoundIdEdit).add(descriptionEdit)
														.add(hiddenEdit),
														tips = $(".validateTips");

												function updateTips(t) {
													tips
															.text(t)
															.addClass(
																	"ui-state-highlight");
													setTimeout(
															function() {
																tips
																		.removeClass(
																				"ui-state-highlight",
																				1500);
															}, 500);
												}

												function checkLength(o, n, min, max) {
													if (o.val().length > max
															|| o.val().length < min) {
														o
																.addClass("ui-state-error");
														updateTips("Length of "
																+ n
																+ " must be between "
																+ min + " and "
																+ max + ".");
														return false;
													} else {
														return true;
													}
												}
																	
												function selectLength(o, n) {
													if (o.val()=='0') {
														o
																.addClass("ui-state-error");
														updateTips(n+" is Required");
														return false;
													} else {
														return true;
													}
												}

												function checkRegexp(o, regexp,
														n) {
													if (!(regexp.test(o.val()))) {
														o
																.addClass("ui-state-error");
														updateTips(n);
														return false;
													} else {
														return true;
													}
												}

												$("#dialog-form-recPlanEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 310,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");
																			
																			
																			 bValid1 = bValid1
																				&& selectLength(
																						interviewRoundIdEdit,
																						"Interview Round"
																						);
																				bValid1 = bValid1
																				&& checkLength(
																						descriptionEdit,
																						"Description",
																						1,
																						16);

																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					
																					$(
																							
																							"#AddrecPlanEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<spring:bind path='RecruitmentPlanCommand.recPlanEditt'><input type='hidden' name='recPlanEditt' id='recPlanEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																																																				
																										 + "<td><spring:bind path='RecruitmentPlanCommand.interviewRoundIdEdit'><input type='hidden' name='interviewRoundIdEdit' id='interviewRoundIdEdit"
																											+ btrid
																											+ "' value="
																											+ interviewRoundIdEdit.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='RecruitmentPlanCommand.interviewName'><input type='text' name='interviewName' id='interviewName"
																											+ btrid
																											+ "' value="
																											
																											+$('#interviewRoundIdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																											
																											+ "<td><spring:bind path='RecruitmentPlanCommand.descriptionEdit'><input name='descriptionEdit' id='descriptionEdit"
																											+ btrid
																											+ "' value="
																											+ descriptionEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																									 	
																											+"<input type='hidden' name='recruitmentPlanLineIdEdit' id='recruitmentPlanLineIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+"<td><a href='#'  onclick='editRecruitmentPlanLineInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeEmpDetailsEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					btrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																			
																			if (hiddenEdit
																					.val() != 0) {												
																				
																				$(
																						'#interviewRoundIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#interviewRoundIdEdit')
																										.val());
																				$(
																						'#interviewName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#interviewRoundIdEdit :selected').text());
																				
																				
																				$(
																						'#descriptionEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#descriptionEdit')
																										.val());
																			
																				
																				$(
																						'#hiddenRecruitmentPlanPopUpEdit')
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
																			$(
																					this)
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

												$("#create-AddrecPlanEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-recPlanEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(id) {
													
											//alert("id is:"+id);
												$('#' + id).remove();
											}
											function editRecruitmentPlanLineInEditNew(
													link) {
												
												
												$("#dialog-form-recPlanEdit")
														.dialog("open");
												
										      alert("the status is:"+interviewRoundIdEdit);
												$('#interviewRoundIdEdit').val(
														$(
																'#interviewRoundIdEdit'
																		+ link)
																.val());
												$('#descriptionEdit').val(
														$(
																'#descriptionEdit'
																		+ link)
																.val());
																							
											

												$('#hiddenRecruitmentPlanPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-recPlanEdit" title="Add New Recruitment Plan Line Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

															 
												 
															       		 <tr>
												<td><spring:message code="label.InterviewRound" /><font color="red">*</font></td>
												<td><form:select path="interviewRoundIdEdit" id="interviewRoundIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${interviewRound}" /> 
													
												</form:select>	</td></tr>
																		<tr>
						<td><spring:message code="label.Description"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="descriptionEdit" id="descriptionEdit" class="textbox" />
													<input type="hidden"
													name="hiddenRecruitmentPlanPopUpEdit" id="hiddenRecruitmentPlanPopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddrecPlanEdit" class="table">
												<thead>
													<tr>
													
														<th><spring:message code="label.InterviewRound" /><font color="red">*</font></th>
													<th><spring:message code="label.Description" /><font color="red">*</font></th>
												
														</tr>

														</thead>
												<tbody>
													<c:forEach var="recPlanLineList"
															items="${recPlanLineList}">

															<c:set var="edit1" value="${recPlanLineList.recruitmentPlanLineIdEdit}"></c:set> 
														
																<tr id="${recPlanLineList.recruitmentPlanLineIdEdit}">
																
                                                                    <spring:bind
																			path="RecruitmentPlanCommand.recruitmentPlanLineId">
																			<input type="hidden" name="recPlanEditt"
																				class="textbox" 
																				value="${recPlanLineList.recruitmentPlanLineIdEdit}" id="recruitmentPlanLineId${recPlanLineList.recruitmentPlanLineIdEdit}" />
																		</spring:bind>
																
																		
																	

																           <spring:bind
																			path="RecruitmentPlanCommand.interviewRoundIdEdit">
																			<input type="hidden" name="interviewRoundIdEdit"
																				class="textbox" 
																				value="${recPlanLineList.interviewRoundIdEdit}" id="interviewRoundIdEdit${recPlanLineList.recruitmentPlanLineIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="RecruitmentPlanCommand.interviewName">
																			<input type="text" name="interviewName"
																				class="textbox" readonly="readonly"
																				value="${recPlanLineList.interviewName}" id="interviewName${recPlanLineList.recruitmentPlanLineIdEdit}" />
																		</spring:bind></td>
																		
																		<td><spring:bind
																			path="RecruitmentPlanCommand.descriptionEdit">
																			<input type="text" name="descriptionEdit"
																				class="textbox" readonly="readonly"
																				value="${recPlanLineList.descriptionEdit}"  id="descriptionEdit${recPlanLineList.recruitmentPlanLineIdEdit}"/>
																		</spring:bind>
								
																	<input type="hidden" name="${recPlanLineList.recruitmentPlanLineIdEdit}Check" id="${recPlanLineList.recruitmentPlanLineIdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editRecruitmentPlanLineInEdit(${recPlanLineList.recruitmentPlanLineIdEdit})"><img src="images/Edit.jpg" height="25px" width="25px"
																id="${recPlanLineList.recruitmentPlanLineIdEdit}"></img></a></td>
														<td><a href="#"
															id="${recPlanLineList.recruitmentPlanLineIdEdit}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																></img></a></td>
																</tr>
		
																<script type="text/javascript">
																function getID1(
																		link) {
																	
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link.id
																					+ "Check").value = "1";
																document.getElementById(link.id).style.display = "none";
																}
																function editRecruitmentPlanLineInEdit(
																		link) {
																	alert("hai");
																
																	$(
																			"#dialog-form-recPlanEdit").dialog(
																					"open");
																	
																	$('#interviewRoundIdEdit').val(
																			$(
																					'#interviewRoundIdEdit'
																							+ link)
																					.val());
																	$('#descriptionEdit').val(
																			$(
																					'#descriptionEdit'
																							+ link)
																					.val());
																														
																																
																	$('#hiddenRecruitmentPlanPopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddrecPlanEdit" type="button">Add New
											Recruitment Plan Details</button>

									</div>

								</div> 
								</div>
								<table>
									<tr>
										<td colspan=""><input type="submit" id="updated"
											value="<spring:message code="label.update"/>"
											class="btn btn-primary" id="updateid" /></td>

									</tr>

								</table>
								
								</div>
								</div> 
							
						</form:form>
					</c:forEach>

				</div>
			</div>

		</div>
	</div>
</body>
</html>
