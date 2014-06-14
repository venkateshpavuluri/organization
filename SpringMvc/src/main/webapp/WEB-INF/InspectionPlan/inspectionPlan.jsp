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
<title>My JSP 'InspectionPlan .jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
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
																	materialId : {
																		required : true
																	},
																	inspLotOriginId : {
																		required : true
																	},
																	
																
																	
																	

																},
																messages : {
																	materialId : "<font style='color: red;'><b>Material is Required</b></font>",

																	inspLotOriginId : "<font style='color: red;'><b>Inspection Lot Origin is Required</b></font>",

																	
																	

																	


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
																	materialId : {
																		required : true
																	},
																	inspLotOriginId : {
																		required : true
																	},
																	
																	
																},
																messages : {
																	materialId : "<font style='color: red;'><b>Material is Required</b></font>",

																	inspLotOriginId : "<font style='color: red;'><b>Inspection Lot Origin is Required</b></font>",


 
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
			
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#material').val('');
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
			$("#materialId").val('');
			$("#inspLotOriginId").val('');
			
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
		<div class="PageTitle">Inspection Plan</div>
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
					<form:form method="get" action="InspectionPlanSearch.mnt"
						commandName="inspectionPlanCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="resourceReqAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.InspectionPlan"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.InspectionPlan"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
						<c:forEach var="resourceReqUpdate"
										items="${InspectionPlanUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.InspectionPlan"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="InspectionPlanUpdateError"
										items="${resourceReqUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.InspectionPlan"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="InspectionPlanDelete"
										items="${InspectionPlanDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.InspectionPlan"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="InspectionPlanDeleteError"
										items="${InspectionPlanDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.InspectionPlan"/> <spring:message code="label.deleteFail"></spring:message>
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

					<display:table name="InspectionPlan" id="InspectionPlan" class="table"
						requestURI="InspectionPlanSearch.mnt" pagesize="5">
						
					
						<display:column property="materialName" sortable="true"
							titleKey="label.material" media="html" />
							 <display:column property="insplotOrginName" sortable="true"
							titleKey="label.inspLotOrigin" media="html" />
							
							
						<display:column titleKey="label.edit">
							<a
								href="InspectionPlanEdit.mnt?InspectionPlanId=<c:out value="${InspectionPlan.inspectionPlanId}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:column titleKey="label.delete">
							<a
								href="InspectionPlanDelete.mnt?InspectionPlanId=<c:out value="${InspectionPlan.inspectionPlanId}"/> "
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

					<form:form commandName="inspectionPlanCommand" id="addform" method="POST"
						action="InspectionPlanAdd.mnt">
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
							<td><spring:message code="label.material"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="materialId" id="materialId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${material }" />
									</form:select></td>
                                  
							</tr>
                                <tr>
							<td><spring:message code="label.inspLotOrigin"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="inspLotOriginId" id="inspLotOriginId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${inspLotOrigin }" />
									</form:select></td>
                                  
							</tr>
							
								
							
                              
</table>

					 	<div id="tabsForAdd">
								<!-- Employee Manager tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.inspectionPlanLineDetails" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
										var btInspectionPlanid = 1;
										$(function() {

											var processDetailId = $("#processDetailId"), 
												mvalue=$("#pNumber"), 
												inspCharacteristicId = $("#inspCharacteristicId"), 
												mtvalue=$("#insNumber"), 
												equipmentId=$("#equipmentId"), 
												evalue=$("#eNumber"),
												hiddenInspectionPlanID = $("#hiddenInspectionPlanPopUp"),
											
											
											
											allFields = $([]).add(processDetailId).add(mvalue).add(inspCharacteristicId).add(mtvalue).add(equipmentId).add(evalue).add(hiddenInspectionPlanID),
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
											$("#dialog-form-InspectionPlan")
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
																				processDetailId,
																				"Process Detail"
																				);
																	
																		 
																		bValid1 = bValid1
																			&& selectLength(
																					inspCharacteristicId,
																					"Inspection Characteristic"
																					);
																	
																		 
																		bValid1 = bValid1
																		&& selectLength(
																				equipmentId,
																				"Equipment"
																				);
																					
																		
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenInspectionPlanID
																					.val() == "0"
																					|| hiddenInspectionPlanID
																							.val() == "") {
																			
																				
																				$("#InspectionPlanAdd tbody")
																						.append(
																								"<tr id="+btInspectionPlanid+">"
																								
																																										   
																								 

																								     + "<td ><spring:bind path='inspectionPlanCommand.processDetailId'><input type='hidden' name='processDetailId' id='processDetailId"
																										+ btInspectionPlanid
																										+ "' value="
																										+ processDetailId
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='pNumber' id='pNumber"
																										+ btInspectionPlanid
																										+ "' value="
																										+ $('#processDetailId :selected').text()
																																																				
																										+ " class='textbox'readonly/></td>" 

																									     + "<td ><spring:bind path='inspectionPlanCommand.inspCharacteristicId'><input type='hidden' name='inspCharacteristicId' id='inspCharacteristicId"
																											+ btInspectionPlanid
																											+ "' value="
																											+ inspCharacteristicId
																													.val()
																											+ " class='textbox'/></spring:bind> <input type='text' name='insNumber' id='insNumber"
																											+ btInspectionPlanid
																											+ "' value="
																											+ $('#inspCharacteristicId :selected').text()
																																																					
																											+ " class='textbox'readonly/></td>" 
																											  
																										    + "<td ><spring:bind path='inspectionPlanCommand.equipmentId'><input type='hidden' name='equipmentId' id='equipmentId"
																											+ btInspectionPlanid
																											+ "' value="
																											+ equipmentId
																													.val()
																											+ " class='textbox'/></spring:bind> <input type='text' name='eNumber' id='eNumber"
																											+ btInspectionPlanid
																											+ "' value="
																											+ $('#equipmentId :selected').text()
																																																					
																											+ " class='textbox'readonly/></td>" 
																											  
																										     
																									    +"<td><a href='#'  onclick='editInspectionPlan("
																										+ btInspectionPlanid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btInspectionPlanid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btInspectionPlanid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenInspectionPlanID
																					.val() != "0") {
																				
																	
																																						
																				$(
																						'#processDetailId'
																								+ hiddenInspectionPlanID
																										.val())
																						.val(
																								processDetailId 
																								        .val());
																				$(
																						'#pNumber'
																								+ hiddenInspectionPlanID
																										.val())
																						.val(
																								 $('#processDetailId :selected').text());
																				

																				$(
																						'#inspCharacteristicId'
																								+ hiddenInspectionPlanID
																										.val())
																						.val(
																								inspCharacteristicId 
																								        .val());
																				$(
																						'#insNumber'
																								+ hiddenInspectionPlanID
																										.val())
																						.val(
																								 $('#inspCharacteristicId :selected').text());
																				
																				$(
																						'#equipmentId'
																								+ hiddenInspectionPlanID
																										.val())
																						.val(
																								equipmentId 
																								        .val());
																				$(
																						'#eNumber'
																								+ hiddenInspectionPlanID
																										.val())
																						.val(
																								 $('#equipmentId :selected').text());
																				$(
																						'#hiddenInspectionPlanPopUp')
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

										
											$("#AddInspectionPlan")
													.button()
													.click(
															function() {
														
																$("#dialog-form-InspectionPlan")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editInspectionPlan(id) {
									
											$("#dialog-form-InspectionPlan").dialog("open");
								
										
											
											$('#processDetailId').val(
													$('#processDetailId' + id).val());
											
											$('#pNumber').val(
													$('#pNumber' + id).val()); 
											
											$('#inspCharacteristicId').val(
													$('#inspCharacteristicId' + id).val());
											
											$('#insNumber').val(
													$('#insNumber' + id).val()); 
											$('#equipmentId').val(
													$('#equipmentId' + id).val());
											
											$('#eNumber').val(
													$('#eNumber' + id).val()); 
										
											$('#hiddenInspectionPlanPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-InspectionPlan" title="Add New Inspection Plan Line Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
									
									
																 <tr>
												<td><spring:message code="label.processDetail" /><font color="red">*</font></td>
											<td><form:select path="processDetailId" id="processDetailId" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${processDetail}" /> 
													
												</form:select>	
												</td>
												</tr>
												
																<tr>
							<td><spring:message code="label.inspCharacteristic"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="inspCharacteristicId" id="inspCharacteristicId"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${inspCharacteristic }" />
									</form:select></td>
                                  
							</tr>
															 
									
																<tr>
							<td><spring:message code="label.equipment"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="equipmentId" id="equipmentId"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${equipment }" />
									</form:select><input type="hidden"
													name="hiddenInspectionPlanPopUp" id="hiddenInspectionPlanPopUp" value="0" /></td>
											</tr>
															 
									
											
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="InspectionPlanAdd" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.processDetail" /></th>
													<th><spring:message code="label.inspCharacteristic" /></th>
													<th><spring:message code="label.equipment" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
													
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="AddInspectionPlan" type="button">Add New Inspection Plan Line Details</button>
									

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

						<form:form method="post" action="InspectionPlanUpdate.mnt"
							commandName="inspectionPlanCommand" id="editForm">
							<table class="tableGeneral">


								<form:hidden path="inspectionPlanId" id="inspectionPlanId" />
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
							<td><spring:message code="label.material"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="materialId" id="materialId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${material }" />
									</form:select></td>
                                  
							</tr>
                                <tr>
							<td><spring:message code="label.inspLotOrigin"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="inspLotOriginId" id="inspLotOriginId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${inspLotOrigin }" />
									</form:select></td>
                                  
							</tr>
							
                               

							</table>
							
							<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.inspectionPlanLineDetails" /></a></li>

								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {
									
												var 
											
												
												inspCharacteristicIdEdit=$("#inspCharacteristicIdEdit"),
												processDetailIdEdit = $("#processDetailIdEdit"),
												equipmentIdEdit= $("#equipmentIdEdit"),
											
												hiddenEdit = $("#hiddenInspectionPlanPopUpEdit"),
												
												allFields = $([]).add(inspCharacteristicIdEdit).add(equipmentIdEdit).add(processDetailIdEdit)
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

												$("#dialog-form-InspectionPlanEdit")
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
																						processDetailIdEdit,
																						"Process Detail"
																						);
																		
																			 bValid1 = bValid1
																				&& selectLength(
																						inspCharacteristicIdEdit,
																						"Inspection Characteristic"
																						);
																			

																			 bValid1 = bValid1
																				&& selectLength(
																						equipmentIdEdit,
																						"Equipment"
																						);
																						
																				
																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					
																					$(
																							
																							"#AddInspectionPlanEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<spring:bind path='inspectionPlanCommand.inspectionEditt'><input type='hidden' name='inspectionEditt' id='inspectionEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																										
																											
																											
																											
																										
																									
																										
																										 + "<td><spring:bind path='inspectionPlanCommand.processDetailIdEdit'><input type='hidden' name='processDetailIdEdit' id='processDetailIdEdit"
																											+ btrid
																											+ "' value="
																											+ processDetailIdEdit.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='inspectionPlanCommand.processDetailName'><input type='text' name='processDetailName' id='processDetailName"
																											+ btrid
																											+ "' value="
																											
																											+$('#processDetailIdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																											

																											 + "<td><spring:bind path='inspectionPlanCommand.inspCharacteristicIdEdit'><input type='hidden' name='inspCharacteristicIdEdit' id='inspCharacteristicIdEdit"
																												+ btrid
																												+ "' value="
																												+ inspCharacteristicIdEdit.val()
																												+ " class='textbox' readonly/></spring:bind>"
																												+"<spring:bind path='inspectionPlanCommand.inspectionCharName'><input type='text' name='inspectionCharName' id='inspectionCharName"
																												+ btrid
																												+ "' value="
																												
																												+$('#inspCharacteristicIdEdit :selected').text()
																												+ " class='textbox' readonly/></spring:bind></td>" 

																												 + "<td><spring:bind path='inspectionPlanCommand.equipmentIdEdit'><input type='hidden' name='equipmentIdEdit' id='equipmentIdEdit"
																													+ btrid
																													+ "' value="
																													+ equipmentIdEdit.val()
																													+ " class='textbox' readonly/></spring:bind>"
																													+"<spring:bind path='inspectionPlanCommand.equipmentName'><input type='text' name='equipmentName' id='equipmentName"
																													+ btrid
																													+ "' value="
																													
																													+$('#equipmentIdEdit :selected').text()
																													+ " class='textbox' readonly/></spring:bind></td>" 
																											
																									 	
																											+"<input type='hidden' name='inspectionPlanLineIdEdit' id='inspectionPlanLineIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+"<td><a href='#'  onclick='editInspectionPlanDetailsInEditNew("
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
																						'#processDetailIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#processDetailIdEdit')
																										.val());
																				$(
																						'#processDetailName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#processDetailIdEdit :selected').text());

																				$(
																						'#inspCharacteristicIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#inspCharacteristicIdEdit')
																										.val());
																				$(
																						'#inspectionCharName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#inspCharacteristicIdEdit :selected').text());
																				
																				$(
																						'#equipmentIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#equipmentIdEdit')
																										.val());
																				$(
																						'#equipmentName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#equipmentIdEdit :selected').text());
																				$(
																						'#hiddenInspectionPlanPopUpEdit')
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

												$("#create-AddInspectionPlanEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-InspectionPlanEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(
													id) {
											alert("id is:"+id);
												$('#' + id).remove();
											}
											function editInspectionPlanDetailsInEditNew(
													link) {
												
												
												$("#dialog-form-InspectionPlanEdit")
														.dialog("open");
												
										
												
												$('#inspCharacteristicIdEdit').val(
														$(
																'#inspCharacteristicIdEdit'
																		+ link)
																.val());
												$('#processDetailIdEdit').val(
														$(
																'#processDetailIdEdit'
																		+ link)
																.val());
												
												$('#equipmentIdEdit').val(
														$(
																'#equipmentIdEdit'
																		+ link)
																.val());

												$('#hiddenInspectionPlanPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-InspectionPlanEdit" title="Add New Inspection Plan Line Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

															 
												 
																					 <tr>
												<td><spring:message code="label.processDetail" /><font color="red">*</font></td>
											<td><form:select path="processDetailIdEdit" id="processDetailIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${processDetail}" /> 
													
												</form:select>	
												</td>
												</tr>
												
																<tr>
							<td><spring:message code="label.inspCharacteristic"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="inspCharacteristicIdEdit" id="inspCharacteristicIdEdit"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${inspCharacteristic }" />
									</form:select></td>
                                  
							</tr>
															 
									
																<tr>
							<td><spring:message code="label.equipment"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="equipmentIdEdit" id="equipmentIdEdit"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${equipment }" />
									</form:select>
													<input type="hidden"
													name="hiddenInspectionPlanPopUpEdit" id="hiddenInspectionPlanPopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddInspectionPlanEdit" class="table">
												<thead>
													<tr>
													
													<th><spring:message code="label.processDetail" /></th>
													<th><spring:message code="label.inspCharacteristic" /></th>
													<th><spring:message code="label.equipment" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="preMainCatList"
															items="${preMainCatList}">

															<c:set var="edit1" value="${preMainCatList.inspectionPlanLineIdEdit}"></c:set> 
														
																<tr id="${preMainCatList.inspectionPlanLineIdEdit}">
																
                                                                    <spring:bind
																			path="inspectionPlanCommand.inspectionPlanId">
																			<input type="hidden" name="inspectionEditt"
																				class="textbox" 
																				value="${preMainCatList.inspectionPlanLineIdEdit}" id="inspectionPlanLineId${preMainCatList.inspectionPlanLineIdEdit}" />
																		</spring:bind>
																													
																           <spring:bind
																			path="inspectionPlanCommand.processDetailIdEdit">
																			<input type="hidden" name="processDetailIdEdit"
																				class="textbox" 
																				value="${preMainCatList.processDetailIdEdit}" id="processDetailIdEdit${preMainCatList.inspectionPlanLineIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="inspectionPlanCommand.processDetailName">
																			<input type="text" name="processDetailName"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.processDetailName}" id="processDetailName${preMainCatList.inspectionPlanLineIdEdit}" />
																		</spring:bind></td>
																		 <spring:bind
																			path="inspectionPlanCommand.inspCharacteristicIdEdit">
																			<input type="hidden" name="inspCharacteristicIdEdit"
																				class="textbox" 
																				value="${preMainCatList.inspCharacteristicIdEdit}" id="inspCharacteristicIdEdit${preMainCatList.inspectionPlanLineIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="inspectionPlanCommand.inspectionCharName">
																			<input type="text" name="inspectionCharName"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.inspectionCharName}" id="inspectionCharName${preMainCatList.inspectionPlanLineIdEdit}" />
																		</spring:bind></td>
																		 <spring:bind
																			path="inspectionPlanCommand.equipmentIdEdit">
																			<input type="hidden" name="equipmentIdEdit"
																				class="textbox" 
																				value="${preMainCatList.equipmentIdEdit}" id="equipmentIdEdit${preMainCatList.inspectionPlanLineIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="inspectionPlanCommand.equipmentName">
																			<input type="text" name="equipmentName"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.equipmentName}" id="equipmentName${preMainCatList.inspectionPlanLineIdEdit}" />
																		</spring:bind>
								
																	<input type="hidden" name="${preMainCatList.inspectionPlanLineIdEdit}Check" id="${preMainCatList.inspectionPlanLineIdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editInspectionPlanDetailsInEdit(${preMainCatList.inspectionPlanLineIdEdit})"><img src="images/Edit.jpg" height="25px" width="25px"
																id="${preMainCatList.inspectionPlanLineIdEdit}"></img></a></td>
														<td><a href="#"
															id="${preMainCatList.inspectionPlanLineIdEdit}"
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
																function editInspectionPlanDetailsInEdit(
																		link) {
																	
																
																	$(
																			"#dialog-form-InspectionPlanEdit").dialog(
																					"open");
																	
																
																	
																	
																	
																	$('#inspCharacteristicIdEdit').val(
																			$(
																					'#inspCharacteristicIdEdit'
																							+ link)
																					.val());
																	
																	$('#processDetailIdEdit').val(
																			$(
																					'#processDetailIdEdit'
																							+ link)
																					.val());	

																	$('#equipmentIdEdit').val(
																			$(
																					'#equipmentIdEdit'
																							+ link)
																					.val());	
																																
																	$('#hiddenInspectionPlanPopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddInspectionPlanEdit" type="button">Add New Inspection Plan Line Details</button>

									</div>

								</div> 
								</div>
								<table>
									<tr>
										<td colspan=""><input type="submit" id="updated"
											value="<spring:message code="label.update"/>"
											class="btn btn-primary" id="submitId" /></td>

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
