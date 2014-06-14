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
<title>My JSP 'Prevmaintenance .jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>


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
<script>
	$(function() {

		$("#resourceReqDate").datepicker();
		$("#schDT").datepicker();
		$("#resourceReqDateEdit").datepicker();
		$("#schDTEdit").datepicker();
	
		

	});
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
																	prevMaintenanceSchNo : {
																		required : true
																	},
																	equipmentId : {
																		required : true
																	},
																	
																
																	
																	

																},
																messages : {
																	prevMaintenanceSchNo : "<font style='color: red;'><b>prevMaintenanceSchNo is Required</b></font>",

																	equipmentId : "<font style='color: red;'><b>Equipment is Required</b></font>",

																	
																	

																	


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
																	prevMaintenanceSchNoEdit : {
																		required : true
																	},
																	equipmentIdEdit : {
																		required : true
																	},
																	
																	
																},
																messages : {
																	prevMaintenanceSchNoEdit : "<font style='color: red;'><b>prevMaintenanceSchNo is Required</b></font>",

																	equipmentIdEdit : "<font style='color: red;'><b>Equipment is Required</b></font>",


 
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
	$(document).ready(function() {
		$('#submit').click(function(e) {
			alert("hai");
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#prevMaintenanceSchNo').val('');
			$('#equipmentId').val('');
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
		<div class="PageTitle">Prevent Maintenance</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="preMainEdit" items="${preMainEdit}">
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
					<form:form method="get" action="prevMaintenanceSearch.mnt"
						commandName="prevMaintenanceCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="resourceReqAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.PrevMaintenance"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.PrevMaintenance"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
						<c:forEach var="resourceReqUpdate"
										items="${prevMainUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.PrevMaintenance"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="prevMainUpdateError"
										items="${resourceReqUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.PrevMaintenance"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="prevMainDelete"
										items="${prevMainDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.PrevMaintenance"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="prevMainDeleteError"
										items="${prevMainDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.PrevMaintenance"/> <spring:message code="label.deleteFail"></spring:message>
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

                   <c:forEach var="preMainValues" items="${preMainValues}">

						<c:set var="as" value="${preMainValues}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">

					<display:table name="PrevMaintenance" id="PrevMaintenance" class="table"
						requestURI="prevMaintenanceSearch.mnt" pagesize="5">
						
					
						<display:column property="prevMaintenanceSchNo" sortable="true"
							titleKey="label.PrevMaintenanceSchNo" media="html" />
							 <display:column property="equipmentName" sortable="true"
							titleKey="label.Equipment" media="html" />
							
							
						<display:column titleKey="label.edit">
							<a
								href="prevMaintenanceEdit.mnt?prevMaintenanceId=<c:out value="${PrevMaintenance.prevMaintenanceSchId}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:column titleKey="label.delete">
							<a
								href="prevMaintenanceDelete.mnt?prevMaintenanceId=<c:out value="${PrevMaintenance.prevMaintenanceSchId}"/> "
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

					<form:form commandName="prevMaintenanceCommand" id="addform" method="POST"
						action="prevMaintenanceAdd.mnt">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
									<td colspan="2"><c:forEach
											var="addPrivMainDuplicate"
											items="${addPrivMainDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="#C09853"><c:out
														value="${addPrivMainDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
						<tr>
						<td><spring:message code="label.PrevMaintenanceSchNo"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="prevMaintenanceSchNo" id="prevMaintenanceSchNo" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.Equipment"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="equipmentId" id="equipmentId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${equipment }" />
									</form:select></td>
                                  
							</tr>
							
								
							
                              
</table>

					 	<div id="tabsForAdd">
								<!-- Employee Manager tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.PrevMaintenanceDetails" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
										var btPrevMainid = 1;
										$(function() {

											var
										    
										    schDT = $("#schDT"), 
										  
											
											
										    	maintenanceCategoryId = $("#maintenanceCategoryId"), 
												mvalue=$("#mNumber"), 
												maintenanceTypeId = $("#maintenanceTypeId"), 
												mtvalue=$("#mtNumber"), 
												hiddenPrevMaintenanceID = $("#hiddenPrevMaintenancePopUp"),
											
											
											
											allFields = $([]).add(maintenanceTypeId).add(mtvalue).add(schDT).add(maintenanceCategoryId).add(mvalue).add(hiddenPrevMaintenanceID),
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
											$("#dialog-form-PrevMain")
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
																				maintenanceCategoryId,
																				"Maintenance Category"
																				);
																	
																		 
																		bValid1 = bValid1
																			&& selectLength(
																					maintenanceTypeId,
																					"Maintenance Type"
																					);
																	
																		 
																		 
																		 bValid1 = bValid1
																			&& checkLength(
																					schDT,
																					"Shedule Date",
																					1,
																					16); 
																					
																		
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenPrevMaintenanceID
																					.val() == "0"
																					|| hiddenPrevMaintenanceID
																							.val() == "") {
																				
																				
																				$("#PrevMainAdd tbody")
																						.append(
																								"<tr id="+btPrevMainid+">"
																								
																																										   
																								 

																								     + "<td ><spring:bind path='prevMaintenanceCommand.maintenanceCategoryId'><input type='hidden' name='maintenanceCategoryId' id='maintenanceCategoryId"
																										+ btPrevMainid
																										+ "' value="
																										+ maintenanceCategoryId
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='mNumber' id='mNumber"
																										+ btPrevMainid
																										+ "' value="
																										+ $('#maintenanceCategoryId :selected').text()
																																																				
																										+ " class='textbox'readonly/></td>" 

																									     + "<td ><spring:bind path='prevMaintenanceCommand.maintenanceTypeId'><input type='hidden' name='maintenanceTypeId' id='maintenanceTypeId"
																											+ btPrevMainid
																											+ "' value="
																											+ maintenanceTypeId
																													.val()
																											+ " class='textbox'/></spring:bind> <input type='text' name='mtNumber' id='mtNumber"
																											+ btPrevMainid
																											+ "' value="
																											+ $('#maintenanceTypeId :selected').text()
																																																					
																											+ " class='textbox'readonly/></td>" 
																											  
																										 	+ "<td align='center'><input type='text' name='schDT' id='schDT"
																										      + btPrevMainid
																										     + "' value="
																										     + schDT
																												.val()
																										     + "  class='textbox'readonly/></td>"
																										     
																									    +"<td><a href='#'  onclick='editPrevMaintenance("
																										+ btPrevMainid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btPrevMainid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btPrevMainid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenPrevMaintenanceID
																					.val() != "0") {
																				
																		
																				
																				$(
																						'#schDT'
																								+ hiddenPrevMaintenanceID
																										.val())
																						.val(
																								schDT 
																								        .val());

																				 
																			
																		
																				
																				$(
																						'#maintenanceCategoryId'
																								+ hiddenPrevMaintenanceID
																										.val())
																						.val(
																								maintenanceCategoryId 
																								        .val());
																				$(
																						'#mNumber'
																								+ hiddenPrevMaintenanceID
																										.val())
																						.val(
																								 $('#maintenanceCategoryId :selected').text());
																				

																				$(
																						'#maintenanceTypeId'
																								+ hiddenPrevMaintenanceID
																										.val())
																						.val(
																								maintenanceTypeId 
																								        .val());
																				$(
																						'#mtNumber'
																								+ hiddenPrevMaintenanceID
																										.val())
																						.val(
																								 $('#maintenanceTypeId :selected').text());
																				
																				$(
																						'#hiddenPrevMaintenancePopUp')
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

										
											$("#AddPrevMain")
													.button()
													.click(
															function() {
														
																$("#dialog-form-PrevMain")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editPrevMaintenance(id) {
									
											$("#dialog-form-PrevMain").dialog("open");
								
											
											
											
											
											$('#schDT').val($('#schDT' + id).val());
											


											
											$('#maintenanceCategoryId').val(
													$('#maintenanceCategoryId' + id).val());
											
											$('#mNumber').val(
													$('#mNumber' + id).val()); 
											
											$('#maintenanceTypeId').val(
													$('#maintenanceTypeId' + id).val());
											
											$('#mtNumber').val(
													$('#mtNumber' + id).val()); 
										
											$('#hiddenPrevMaintenancePopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-PrevMain" title="Add New
											Prevent Maintenance Shedule Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
									
									
																 <tr>
												<td><spring:message code="label.MaintenanceCategory" /><font color="red">*</font></td>
											<td><form:select path="maintenanceCategoryId" id="maintenanceCategoryId" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${maintenanceCategory}" /> 
													
												</form:select>	
												</td>
												</tr>
									
																 <tr>
												<td><spring:message code="label.MaintenanceType" /><font color="red">*</font></td>
											<td><form:select path="maintenanceTypeId" id="maintenanceTypeId" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${maintenanceType}" /> 
													
												</form:select>	</td></tr>
															 
									
												  <tr>
						<td><spring:message code="label.SchDT"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="schDT" id="schDT" class="textbox" />
											<input type="hidden"
													name="hiddenPrevMaintenancePopUp" id="hiddenPrevMaintenancePopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="PrevMainAdd" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.MaintenanceCategory" /></th>
													<th><spring:message code="label.MaintenanceType" /></th>
													<th><spring:message code="label.SchDT" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
													
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="AddPrevMain" type="button">Add New
											Prevent Maintenance Shedule Details</button>
									

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
					<c:forEach var="preMainEdit" items="${preMainEdit}">

						<form:form method="post" action="prevMaintenanceUpdate.mnt"
							commandName="prevMaintenanceCommand" id="editForm">
							<table class="tableGeneral">


								<form:hidden path="prevMaintenanceSchIdEdit" id="prevMaintenanceSchIdEdit" />
								<tr>
									<td colspan="2"><c:forEach
											var="addPreMainEditDuplicate"
											items="${addPreMainEditDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="#C09853"><c:out
														value="${addPreMainEditDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
                               <tr>
						<td><spring:message code="label.PrevMaintenanceSchNo"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="prevMaintenanceSchNoEdit" id="prevMaintenanceSchNoEdit" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.Equipment"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="equipmentIdEdit" id="equipmentIdEdit"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${equipment }" />
									</form:select></td>
                                  
							</tr>
                               

							</table>
							
							<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.PrevMaintenanceDetails" /></a></li>

								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {
									
												var 
											
												schDTEdit = $("#schDTEdit"),
												maintenanceTypeIdEdit=$("#maintenanceTypeIdEdit"),
												maintenanceCategoryIdEdit = $("#maintenanceCategoryIdEdit"),
											
												hiddenEdit = $("#hiddenPrevMaintenancePopUpEdit"),
												
												allFields = $([]).add(maintenanceTypeIdEdit).add(schDTEdit).add(maintenanceCategoryIdEdit)
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

												$("#dialog-form-PrevMainEdit")
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
																						maintenanceCategoryIdEdit,
																						"Maintenance Category"
																						);
																		
																			 bValid1 = bValid1
																				&& selectLength(
																						maintenanceTypeIdEdit,
																						"Maintenance Type"
																						);
																			
																			 
																			 bValid1 = bValid1
																				&& checkLength(
																						schDTEdit,
																						"Shedule Date",
																						1,
																						16); 
																						
																				
																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					alert("maintenanceCategoryId:"+$("#maintenanceCategoryIdEdit"));
																					$(
																							
																							"#AddPrevMainEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<spring:bind path='prevMaintenanceCommand.PrevMainEditt'><input type='hidden' name='PrevMainEditt' id='PrevMainEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																										
																											
																											
																											
																										
																									
																										
																										 + "<td><spring:bind path='prevMaintenanceCommand.maintenanceCategoryIdEdit'><input type='hidden' name='maintenanceCategoryIdEdit' id='maintenanceCategoryIdEdit"
																											+ btrid
																											+ "' value="
																											+ maintenanceCategoryIdEdit.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='prevMaintenanceCommand.maintenanceCategoryName'><input type='text' name='maintenanceCategoryName' id='maintenanceCategoryName"
																											+ btrid
																											+ "' value="
																											
																											+$('#maintenanceCategoryIdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																											

																											 + "<td><spring:bind path='prevMaintenanceCommand.maintenanceTypeIdEdit'><input type='hidden' name='maintenanceTypeIdEdit' id='maintenanceTypeIdEdit"
																												+ btrid
																												+ "' value="
																												+ maintenanceTypeIdEdit.val()
																												+ " class='textbox' readonly/></spring:bind>"
																												+"<spring:bind path='prevMaintenanceCommand.maintenanceTypeBeanName'><input type='text' name='maintenanceTypeBeanName' id='maintenanceTypeBeanName"
																												+ btrid
																												+ "' value="
																												
																												+$('#maintenanceTypeIdEdit :selected').text()
																												+ " class='textbox' readonly/></spring:bind></td>" 

																												
																												+ "<td><spring:bind path='prevMaintenanceCommand.schDTEdit'><input name='schDTEdit' id='schDTEdit"
																												+ btrid
																												+ "' value="
																												+ schDTEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind> </td>"
																									 	
																											+"<input type='hidden' name='prevMaintenanceSchCatIdEdit' id='prevMaintenanceSchCatIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+"<td><a href='#'  onclick='editPrevMaintenanceDetailsInEditNew("
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
																						'#schDTEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#schDTEdit')
																										.val());
																				
																			
																				
																				$(
																						'#maintenanceCategoryIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#maintenanceCategoryIdEdit')
																										.val());
																				$(
																						'#maintenanceCategoryName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#maintenanceCategoryIdEdit :selected').text());

																				$(
																						'#maintenanceTypeIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#maintenanceTypeIdEdit')
																										.val());
																				$(
																						'#maintenanceTypeBeanName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#maintenanceTypeIdEdit :selected').text());
																				$(
																						'#hiddenPrevMaintenancePopUpEdit')
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

												$("#create-AddPrevMainEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-PrevMainEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(
													id) {
											alert("id is:"+id);
												$('#' + id).remove();
											}
											function editPrevMaintenanceDetailsInEditNew(
													link) {
												
												
												$("#dialog-form-PrevMainEdit")
														.dialog("open");
												
										   ;
												
												$('#schDTEdit').val(
														$(
																'#schDTEdit'
																		+ link)
																.val());
												
												$('#maintenanceTypeIdEdit').val(
														$(
																'#maintenanceTypeIdEdit'
																		+ link)
																.val());
												$('#maintenanceCategoryIdEdit').val(
														$(
																'#maintenanceCategoryIdEdit'
																		+ link)
																.val());
												
											

												$('#hiddenPrevMaintenancePopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-PrevMainEdit" title="Add New
											Prevent Maintenance Shedule Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

															 
												 
																					 <tr>
												<td><spring:message code="label.MaintenanceCategory" /><font color="red">*</font></td>
											<td><form:select path="maintenanceCategoryIdEdit" id="maintenanceCategoryIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${maintenanceCategory}" /> 
													
												</form:select>	
												</td>
												</tr>
									
																 <tr>
												<td><spring:message code="label.MaintenanceType" /><font color="red">*</font></td>
											<td><form:select path="maintenanceTypeIdEdit" id="maintenanceTypeIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${maintenanceType}" /> 
													
												</form:select>	</td></tr>
															 
									
												  <tr>
						<td><spring:message code="label.SchDT"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="schDTEdit" id="schDTEdit" class="textbox" />
													<input type="hidden"
													name="hiddenPrevMaintenancePopUpEdit" id="hiddenPrevMaintenancePopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddPrevMainEdit" class="table">
												<thead>
													<tr>
													
														<th><spring:message code="label.MaintenanceCategory" /></th>
													<th><spring:message code="label.MaintenanceType" /></th>
													<th><spring:message code="label.SchDT" /></th>
													<th><spring:message code="label.edit" /></th>
																<th><spring:message code="label.remove" /></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="preMainCatList"
															items="${preMainCatList}">

															<c:set var="edit1" value="${preMainCatList.prevMaintenanceSchCatIdEdit}"></c:set> 
														
																<tr id="${preMainCatList.prevMaintenanceSchCatIdEdit}">
																
                                                                    <spring:bind
																			path="prevMaintenanceCommand.prevMaintenanceSchCatId">
																			<input type="hidden" name="PrevMainEditt"
																				class="textbox" 
																				value="${preMainCatList.prevMaintenanceSchCatIdEdit}" id="prevMaintenanceSchCatId${preMainCatList.prevMaintenanceSchCatIdEdit}" />
																		</spring:bind>
																
																		
																		

																			
																           <spring:bind
																			path="prevMaintenanceCommand.maintenanceCategoryIdEdit">
																			<input type="hidden" name="maintenanceCategoryIdEdit"
																				class="textbox" 
																				value="${preMainCatList.maintenanceCategoryIdEdit}" id="maintenanceCategoryIdEdit${preMainCatList.prevMaintenanceSchCatIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="prevMaintenanceCommand.maintenanceCategoryName">
																			<input type="text" name="maintenanceCategoryName"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.maintenanceCategoryName}" id="maintenanceCategoryName${preMainCatList.prevMaintenanceSchCatIdEdit}" />
																		</spring:bind></td>
																		 <spring:bind
																			path="prevMaintenanceCommand.maintenanceTypeIdEdit">
																			<input type="hidden" name="maintenanceTypeIdEdit"
																				class="textbox" 
																				value="${preMainCatList.maintenanceTypeIdEdit}" id="maintenanceTypeIdEdit${preMainCatList.prevMaintenanceSchCatIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="prevMaintenanceCommand.maintenanceTypeBeanName">
																			<input type="text" name="maintenanceTypeBeanName"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.maintenanceTypeBeanName}" id="maintenanceTypeBeanName${preMainCatList.prevMaintenanceSchCatIdEdit}" />
																		</spring:bind></td>
																		<td><spring:bind
																			path="prevMaintenanceCommand.schDTEdit">
																			<input type="text" name="schDTEdit"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.schDTEdit}"  id="schDTEdit${preMainCatList.prevMaintenanceSchCatIdEdit}"/>
																		</spring:bind>
								
																	<input type="hidden" name="${preMainCatList.prevMaintenanceSchCatIdEdit}Check" id="${preMainCatList.prevMaintenanceSchCatIdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editPrevMaintenanceDetailsInEdit(${preMainCatList.prevMaintenanceSchCatIdEdit})"><img src="images/Edit.jpg" height="25px" width="25px"
																id="${preMainCatList.prevMaintenanceSchCatIdEdit}"></img></a></td>
														<td><a href="#"
															id="${preMainCatList.prevMaintenanceSchCatIdEdit}"
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
																function editPrevMaintenanceDetailsInEdit(
																		link) {
																	
																
																	$(
																			"#dialog-form-PrevMainEdit").dialog(
																					"open");
																	
																
																	
																	
																	$('#schDTEdit').val(
																			$(
																					'#schDTEdit'
																							+ link)
																					.val());
																	
																	$('#maintenanceTypeIdEdit').val(
																			$(
																					'#maintenanceTypeIdEdit'
																							+ link)
																					.val());
																	
																	$('#maintenanceCategoryIdEdit').val(
																			$(
																					'#maintenanceCategoryIdEdit'
																							+ link)
																					.val());	
																	
																																
																	$('#hiddenPrevMaintenancePopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddPrevMainEdit" type="button">Add New
											Prevent Maintenance Shedule Details</button>

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
