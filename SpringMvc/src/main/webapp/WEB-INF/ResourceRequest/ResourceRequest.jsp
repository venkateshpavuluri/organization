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
	$('#resourceReqDate,#requiredDate,#resourceReqDateEdit,#requiredDateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>

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
		<div class="PageTitle">Resource Request</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="resReqEdit" items="${resReqEdit}">
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
					<form:form method="get" action="resourceReqSearch.mnt"
						commandName="resourceRequestCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="resourceReqAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.resourceReq"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.resourceReq"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
						<c:forEach var="resourceReqUpdate"
										items="${resourceReqUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.resourceReq"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="resourceReqUpdateError"
										items="${resourceReqUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.resourceReq"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="resReqDelete"
										items="${resReqDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.resourceReq"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="resReqDeleteError"
										items="${resReqDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.resourceReq"/> <spring:message code="label.deleteFail"></spring:message>
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

                   <c:forEach var="resourceReqValues" items="${resourceReqValues}">

						<c:set var="as" value="${resourceReqValues}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">

					<display:table name="resourceRequest" id="resourceRequest" class="table"
						requestURI="resourceReqSearch.mnt" pagesize="5">
						<display:column property="empName" sortable="true"
							titleKey="label.employee" media="html" />
					
						<display:column property="resourceReqDate" sortable="true"
							titleKey="label.ResourceReqDate" media="html" />
							
							<display:column property="description" sortable="true"
							titleKey="label.description" media="html" />
							<display:column property="statusName" sortable="true"
							titleKey="label.status" media="html" />
							
						<display:column titleKey="label.edit">
							<a
								href="resourceReqEdit.mnt?resourceReqId=<c:out value="${resourceRequest.resourceReqId}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:column titleKey="label.delete">
							<a
								href="resourceReqDelete.mnt?resourceReqId=<c:out value="${resourceRequest.resourceReqId}"/> "
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

					<form:form commandName="resourceRequestCommand" id="addform" method="POST"
						action="resourceRequestAdd.mnt">
						<table class="tableGeneral">
						<tr>
						<td><spring:message code="label.ResourceReqDate"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="resourceReqDate" id="resourceReqDate" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.Employee"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="employeeId" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
                                  
							</tr>
							
								<tr>
							
                                 <td><spring:message code="label.Description"></spring:message><font
									color="red"></font></td>
								<td><form:textarea path="description" id="description" class="textbox" /></td>
                                    

							</tr>
							<tr>
							
                                 <td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="statusId" id="statusId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                    

							</tr>

							
                              
</table>

					 		<div id="tabsForAdd">
								<!-- Employee Manager tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.resourceRequestDetails" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
										var btresreqid = 1;
										$(function() {

											var 
											noOfPositions = $("#noOfPositions"), 
											jobDescription=$("#jobDescription"),
										   
										    
										    requiredDate = $("#requiredDate"), 
										  
											priority=$("#priority"),
											
										    rdstatusId = $("#rdstatusId"), 
												svalue=$("#sNumber"), 
											
												hiddenResourceRequestID = $("#hiddenResourceRequestPopUp"),
											
											
											
											allFields = $([]).add(noOfPositions).add(jobDescription).add(requiredDate).add(priority).add(rdstatusId).add(svalue).add(hiddenResourceRequestID),
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
																		alert("hai");
																		var bValid1 = true;
																		allFields.removeClass("ui-state-error");
                                    								
																		
																	  /* bValid1 = bValid1
																		&& selectLength(
																				material_Id,
																				"Material"
																				);
																		bValid1 = bValid1
																		&& checkLength(
																				qty,
																				"Quantity",
																				1,
																				16);
																		 
																		bValid1 = bValid1
																			&& selectLength(
																					uOM_Id,
																					"Uom"
																					);
																		bValid1 = bValid1
																		&& checkLength(
																				startDT,
																				"Start Date",
																				1,
																				16);
																		 
																		 
																		 bValid1 = bValid1
																			&& checkLength(
																					finishDT,
																					"Finish Date",
																					1,
																					16); */
																					
																			/* bValid1 = bValid1
																			&& selectLength(
																					productionOrder_Id,
																					"Production Order Number"
																					); */
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenResourceRequestID
																					.val() == "0"
																					|| hiddenResourceRequestID
																							.val() == "") {
																				
																				
																				$("#resReqAdd tbody")
																						.append(
																								"<tr id="+btresreqid+">"
																								
																								
																								+ "<td align='center'><input type='text' name='noOfPositions' id='noOfPositions"
																							      + btresreqid
																							     + "' value="
																							     + noOfPositions
																									.val()
																							     + "  class='textbox'readonly/></td>"
																							     

																									+ "<td align='center'><input type='text' name='jobDescription' id='jobDescription"
																								      + btresreqid
																								     + "' value="
																								     + jobDescription
																										.val()
																								     + "  class='textbox'readonly/></td>"
																								     
																								 	+ "<td align='center'><input type='text' name='requiredDate' id='requiredDate"
																								      + btresreqid
																								     + "' value="
																								     + requiredDate
																										.val()
																								     + "  class='textbox'readonly/></td>"
																								     
																								 	+ "<td align='center'><input type='text' name='priority' id='priority"
																								      + btresreqid
																								     + "' value="
																								     + priority
																										.val()
																								     + "  class='textbox'readonly/></td>"

																								     + "<td ><spring:bind path='resourceRequestCommand.rdstatusId'><input type='hidden' name='rdstatusId' id='rdstatusId"
																										+ btresreqid
																										+ "' value="
																										+ rdstatusId
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='sNumber' id='sNumber"
																										+ btresreqid
																										+ "' value="
																										+ $('#rdstatusId :selected').text()
																																																				
																										+ " class='textbox'readonly/></td>" 
																								    
																									    +"<td><a href='#'  onclick='editResourceRequest("
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
																		
																		
																			if (hiddenResourceRequestID
																					.val() != "0") {
																				
																				
																			 $(
																						'#noOfPositions'
																								+ hiddenResourceRequestID
																										.val())
																						.val(
																								noOfPositions
																										.val());
																				
																				
																				$(
																						'#jobDescription'
																								+ hiddenResourceRequestID
																										.val())
																						.val(
																								jobDescription
																										.val());
																				
																				$(
																						'#requiredDate'
																								+ hiddenResourceRequestID
																										.val())
																						.val(
																								requiredDate 
																								        .val());

																				 
																				$(
																						'#priority'
																								+ hiddenResourceRequestID
																										.val())
																						.val(
																								priority 
																								        .val());
																		
																				
																				$(
																						'#rdstatusId'
																								+ hiddenResourceRequestID
																										.val())
																						.val(
																								rdstatusId 
																								        .val());
																				$(
																						'#sNumber'
																								+ hiddenResourceRequestID
																										.val())
																						.val(
																								 $('#rdstatusId :selected').text());
																				
																				$(
																						'#hiddenResourceRequestPopUp')
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
										function editResourceRequest(id) {
									
											$("#dialog-form-resReq").dialog("open");
								
											
											$('#noOfPositions').val($('#noOfPositions' + id).val());
										
											$('#jobDescription').val(
													$('#jobDescription' + id).val()); 
											
											
											$('#requiredDate').val($('#requiredDate' + id).val());
											$('#priority').val(
													$('#priority' + id).val());
											


											
											$('#rdstatusId').val(
													$('#rdstatusId' + id).val());
											
											$('#sNumber').val(
													$('#sNumber' + id).val()); 
										
											$('#hiddenResourceRequestPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-resReq" title="Add New Resource Request Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
									
															 
														<tr>	 	
												<td><spring:message code="label.noOfPositions" /><font color="red">*</font></td>
											<td><form:input path="noOfPositions" id="noOfPositions" class="textbox"/>
												
													
												</td>
															</tr>
															
															 <tr>
												<td><spring:message code="label.jobDescription" /><font color="red">*</font></td>
												<td><form:textarea path="jobDescription" id="jobDescription"/>
															</td>
															</tr>
                                           <tr>
												<td><spring:message code="label.requiredDate" /><font color="red">*</font></td>
											<td><form:input path="requiredDate" id="requiredDate" class="textbox"/>
												</td>
															</tr> 
											<tr><td><spring:message code="label.priority" /><font color="red">*</font></td> <td><form:select path="priority" Id="priority" class="select"  >
											<form:option value="">--Select--</form:option>
 											 <form:option value="high">High</form:option>
   											<form:option value="medium">Medium</form:option>
   											<form:option value="medium">Low</form:option>
 
                     
  											 </form:select></td></tr>
																 <tr>
												<td><spring:message code="label.status" /><font color="red">*</font></td>
											<td><form:select path="rdstatusId" id="rdstatusId" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${status}" /> 
													
												</form:select>	
											<input type="hidden"
													name="hiddenResourceRequestPopUp" id="hiddenResourceRequestPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="resReqAdd" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.noOfPositions" /><font color="red">*</font></th>
													<th><spring:message code="label.jobDescription" /><font color="red">*</font></th>
													<th><spring:message code="label.requiredDate" /><font color="red">*</font></th>
													<th><spring:message code="label.priority" /><font color="red">*</font></th>
													<th><spring:message code="label.status" /><font color="red">*</font></th>
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="AddResReq" type="button">Add New Resource Request Details</button>
									

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
					<c:forEach var="resReqEdit" items="${resReqEdit}">

						<form:form method="post" action="resouceReqUpdate.mnt"
							commandName="resourceRequestCommand" id="editForm">
							<table class="tableGeneral">


								<form:hidden path="resourceReqIdEdit" id="resourceReqIdEdit" />
                               <tr>
						<td><spring:message code="label.ResourceReqDate"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="resourceReqDateEdit" id="resourceReqDateEdit" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.Employee"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="employeeIdEdit" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
                                  
							</tr>
							
								<tr>
							
                                 <td><spring:message code="label.Description"></spring:message><font
									color="red"></font></td>
								<td><form:textarea path="descriptionEdit" id="descriptionEdit" class="textbox" /></td>
                                    

							</tr>
							<tr>
							
                                 <td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="statusIdEdit" id="statusIdEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                    

							</tr>
                               
                               

							</table>
							
							<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.resourceRequestDetails" /></a></li>

								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {
									
												var 
												noOfPositionsEdit=$("#noOfPositionsEdit"),
												jobDescriptionEdit=$("#jobDescriptionEdit"),
												requiredDateEdit = $("#requiredDateEdit"),
												priorityEdit=$("#priorityEdit"),
												rdstatusIdEdit = $("#rdstatusIdEdit"),
											
												hiddenEdit = $("#hiddenResourceRequestPopUpEdit"),
												
												allFields = $([]).add(noOfPositionsEdit).add(jobDescriptionEdit).add(requiredDateEdit).add(priorityEdit).add(rdstatusIdEdit)
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

												$("#dialog-form-resReqEdit")
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
																			
																			
																			/* bValid1 = bValid1
																			&& selectLength(
																					material_IdEdit,
																					"Material"
																					);
																			bValid1 = bValid1
																			&& checkLength(
																					qtyEdit,
																					"Quantity",
																					1,
																					16);
																			 
																			bValid1 = bValid1
																				&& selectLength(
																						uOM_IdEdit,
																						"Uom"
																						);
																			bValid1 = bValid1
																			&& checkLength(
																					startDTEdit,
																					"Start Date",
																					1,
																					16);
																			 
																			 
																			 bValid1 = bValid1
																				&& checkLength(
																						finishDTEdit,
																						"Finish Date",
																						1,
																						16); */
																						
																				/* bValid1 = bValid1
																				&& selectLength(
																						productionOrder_IdEdit,
																						"Production Order Number"
																						); */

																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					alert("rdstatusid:"+$("#rdstatusIdEdit"));
																					$(
																							
																							"#AddResReqEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<spring:bind path='resourceRequestCommand.resReqEditt'><input type='hidden' name='resReqEditt' id='resReqEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																										
																											+ "<td><spring:bind path='resourceRequestCommand.noOfPositionsEdit'><input name='noOfPositionsEdit' id='noOfPositionsEdit"
																											+ btrid
																											+ "' value="
																											+ noOfPositionsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											
																											+ "<td><spring:bind path='resourceRequestCommand.jobDescriptionEdit'><input name='jobDescriptionEdit' id='jobDescriptionEdit"
																											+ btrid
																											+ "' value="
																											+ jobDescriptionEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											
																											+ "<td><spring:bind path='resourceRequestCommand.requiredDateEdit'><input name='requiredDateEdit' id='requiredDateEdit"
																											+ btrid
																											+ "' value="
																											+ requiredDateEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											
																											+ "<td><spring:bind path='resourceRequestCommand.priorityEdit'><input name='priorityEdit' id='priorityEdit"
																											+ btrid
																											+ "' value="
																											+ priorityEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											
																											
																										
																									
																										
																										 + "<td><spring:bind path='resourceRequestCommand.rdstatusIdEdit'><input type='hidden' name='rdstatusIdEdit' id='rdstatusIdEdit"
																											+ btrid
																											+ "' value="
																											+ rdstatusIdEdit.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='resourceRequestCommand.rdstatusname'><input type='text' name='rdstatusname' id='rdstatusname"
																											+ btrid
																											+ "' value="
																											
																											+$('#rdstatusIdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																									 	
																											+"<input type='hidden' name='resourceReqDetIdEdit' id='resourceReqDetIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+"<td><a href='#'  onclick='editResourceRequestDetailsInEditNew("
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
																			alert("rdstatus......:"+rdstatusIdEdit);
																				
																																					
																				$(
																						'#noOfPositionsEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#noOfPositionsEdit')
																										.val());
																			
																				$(
																						'#jobDescriptionEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#jobDescriptionEdit')
																										.val());
																				$(
																						'#requiredDateEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#requiredDateEdit')
																										.val());
																				
																				$(
																						'#priorityEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#priorityEdit')
																										.val());
																				
																				$(
																						'#rdstatusIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#rdstatusIdEdit')
																										.val());
																				$(
																						'#rdstatusname'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#rdstatusIdEdit :selected').text());
																				
																				$(
																						'#hiddenResourceRequestPopUpEdit')
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

												$("#create-AddResReqEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-resReqEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(
													id) {
											alert("id is:"+id);
												$('#' + id).remove();
											}
											function editResourceRequestDetailsInEditNew(
													link) {
												
												
												$("#dialog-form-resReqEdit")
														.dialog("open");
												
										      alert("the status is:"+rdstatusIdEdit);
												$('#noOfPositionsEdit').val(
														$(
																'#noOfPositionsEdit'
																		+ link)
																.val());
												$('#jobDescriptionEdit').val(
														$(
																'#jobDescriptionEdit'
																		+ link)
																.val());
												$('#requiredDateEdit').val(
														$(
																'#requiredDateEdit'
																		+ link)
																.val());
												
												$('#priorityEdit').val(
														$(
																'#priorityEdit'
																		+ link)
																.val());
												$('#rdstatusIdEdit').val(
														$(
																'#rdstatusIdEdit'
																		+ link)
																.val());
												
											

												$('#hiddenResourceRequestPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-resReqEdit" title="Add New Production Plan Line Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

															 
												 
														<tr>	 	
												<td><spring:message code="label.noOfPositions" /><font color="red">*</font></td>
											<td><form:input path="noOfPositionsEdit" id="noOfPositionsEdit" class="textbox"/>
												
													
												</td>
															</tr>
															
															 <tr>
												<td><spring:message code="label.jobDescription" /><font color="red">*</font></td>
												<td><form:textarea path="jobDescriptionEdit" id="jobDescriptionEdit"/>
															</td>
															</tr>
                                           <tr>
												<td><spring:message code="label.requiredDate" /><font color="red">*</font></td>
											<td><form:input path="requiredDateEdit" id="requiredDateEdit" class="textbox"/>
												</td>
															</tr> 
											<tr><td><spring:message code="label.priority" /><font color="red">*</font></td> <td><form:select path="priorityEdit" Id="priorityEdit" class="select"  >
											<form:option value="">--Select--</form:option>
 											 <form:option value="high">High</form:option>
   											<form:option value="medium">Medium</form:option>
   											<form:option value="medium">Low</form:option>
 
                     
  											 </form:select></td></tr>
																 <tr>
												<td><spring:message code="label.status" /><font color="red">*</font></td>
											<td><form:select path="rdstatusIdEdit" id="rdstatusIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${status}" /> 
													
												</form:select>	
													<input type="hidden"
													name="hiddenResourceRequestPopUpEdit" id="hiddenResourceRequestPopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddResReqEdit" class="table">
												<thead>
													<tr>
													
														<th><spring:message code="label.noOfPositions" /><font color="red">*</font></th>
													<th><spring:message code="label.jobDescription" /><font color="red">*</font></th>
													<th><spring:message code="label.requiredDate" /><font color="red">*</font></th>
													<th><spring:message code="label.priority" /><font color="red">*</font></th>
													<th><spring:message code="label.status" /><font color="red">*</font></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="resourceReqDetailList"
															items="${resourceReqDetailList}">

															<c:set var="edit1" value="${resourceReqDetailList.resourceReqDetIdEdit}"></c:set> 
														
																<tr id="${resourceReqDetailList.resourceReqDetIdEdit}">
																
                                                                    <spring:bind
																			path="resourceRequestCommand.resourceReqDetId">
																			<input type="hidden" name="resReqEditt"
																				class="textbox" 
																				value="${resourceReqDetailList.resourceReqDetIdEdit}" id="resourceReqDetId${resourceReqDetailList.resourceReqDetIdEdit}" />
																		</spring:bind>
																
																		<td><spring:bind
																			path="resourceRequestCommand.noOfPositionsEdit">
																			<input type="text" name="noOfPositionsEdit"
																				class="textbox" readonly="readonly"
																				value="${resourceReqDetailList.noOfPositionsEdit}"  id="noOfPositionsEdit${resourceReqDetailList.resourceReqDetIdEdit}"/>
																		</spring:bind></td>
																		
																		<td><spring:bind
																			path="resourceRequestCommand.jobDescriptionEdit">
																			<input type="text" name="jobDescriptionEdit"
																				class="textbox" readonly="readonly"
																				value="${resourceReqDetailList.jobDescriptionEdit}"  id="jobDescriptionEdit${resourceReqDetailList.resourceReqDetIdEdit}"/>
																		</spring:bind></td>
																		<td><spring:bind
																			path="resourceRequestCommand.requiredDateEdit">
																			<input type="text" name="requiredDateEdit"
																				class="textbox" readonly="readonly"
																				value="${resourceReqDetailList.requiredDateEdit}"  id="requiredDateEdit${resourceReqDetailList.resourceReqDetIdEdit}"/>
																		</spring:bind></td>

																			<td><spring:bind
																			path="resourceRequestCommand.priorityEdit">
																			<input type="text" name="priorityEdit"
																				class="textbox" readonly="readonly"
																				value="${resourceReqDetailList.priorityEdit}"  id="priorityEdit${resourceReqDetailList.resourceReqDetIdEdit}"/>
																		</spring:bind></td>
																           <spring:bind
																			path="resourceRequestCommand.rdstatusIdEdit">
																			<input type="hidden" name="rdstatusIdEdit"
																				class="textbox" 
																				value="${resourceReqDetailList.rdstatusIdEdit}" id="rdstatusIdEdit${resourceReqDetailList.resourceReqDetIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="resourceRequestCommand.rdstatusname">
																			<input type="text" name="rdstatusname"
																				class="textbox" readonly="readonly"
																				value="${resourceReqDetailList.rdstatusname}" id="rdstatusname${resourceReqDetailList.resourceReqDetIdEdit}" />
																		</spring:bind>
								
																	<input type="hidden" name="${resourceReqDetailList.resourceReqDetIdEdit}Check" id="${resourceReqDetailList.resourceReqDetIdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editResourceRequestDetailsInEdit(${resourceReqDetailList.resourceReqDetIdEdit})"><img src="images/Edit.jpg" height="25px" width="25px"
																id="${resourceReqDetailList.resourceReqDetIdEdit}"></img></a></td>
														<td><a href="#"
															id="${resourceReqDetailList.resourceReqDetIdEdit}"
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
																function editResourceRequestDetailsInEdit(
																		link) {
																	
																
																	$(
																			"#dialog-form-resReqEdit").dialog(
																					"open");
																	
																	$('#noOfPositionsEdit').val(
																			$(
																					'#noOfPositionsEdit'
																							+ link)
																					.val());
																	$('#jobDescriptionEdit').val(
																			$(
																					'#jobDescriptionEdit'
																							+ link)
																					.val());
																	
																	
																	$('#requiredDateEdit').val(
																			$(
																					'#requiredDateEdit'
																							+ link)
																					.val());
																	
																	$('#priorityEdit').val(
																			$(
																					'#priorityEdit'
																							+ link)
																					.val());
																	
																	$('#rdstatusIdEdit').val(
																			$(
																					'#rdstatusIdEdit'
																							+ link)
																					.val());	
																	
																																
																	$('#hiddenResourceRequestPopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddResReqEdit" type="button">Add New
											Request Resource Details</button>

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
