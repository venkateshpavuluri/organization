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
<title>My JSP 'EmpPerformance .jsp' starting page</title>
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
	$('#periodFrom,#periodTo,#periodFromEdit,#periodToEdit').datepicker({
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
																	employeeId : {
																		required : true
																	},
																	periodFrom : {
																		required : true
																	},
																	
																	periodTo : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	
																	

																},
																messages : {
																	employeeId : "<font style='color: red;'><b>Employee is Required</b></font>",

																	periodFrom : "<font style='color: red;'><b>Period From is Required</b></font>",

																	periodTo : "<font style='color: red;'><b>Period To is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",


																	

																	


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
																	employeeId : {
																		required : true
																	},
																	periodFrom : {
																		required : true
																	},
																	
																	periodTo : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	
																	

																},
																messages : {
																	employeeId : "<font style='color: red;'><b>Employee is Required</b></font>",

																	periodFrom : "<font style='color: red;'><b>Period From is Required</b></font>",

																	periodTo : "<font style='color: red;'><b>Period To is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",


																	

																	


																},
															});

										});

					});
</script>


<script>
	$(function() {
		$("#tabs,#tabsForAdd,#tabsForEdit").tabs();
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
			$('#EmpPerformanceSchNo').val('');
			$('#equipmentId').val('');
			$('#edit').hide();
			$("#tabsForEdit").hide();
			$("#employeeId").val('');
			$("#periodFrom").val('');
			$("#statusId").val('');
			$("#periodTo").val('');
			

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
		<div class="PageTitle">Employee Performance</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="empPerEdit" items="${empPerEdit}">
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
	
					<form:form method="get" action="EmpPerformanceSearch.mnt"
						commandName="EmpPerformance">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="resourceReqAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.EmpPerformance"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.EmpPerformance"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
						<c:forEach var="empPerformanceUpdate"
										items="${empPerformanceUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.EmpPerformance"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="empPerformanceUpdateError"
										items="${empPerformanceUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.EmpPerformance"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="empPerformanceDelete"
										items="${empPerformanceDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.EmpPerformance"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="empPerformanceDeleteError"
										items="${empPerformanceDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.EmpPerformance"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr> 
							


							<tr>
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
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>

						</table>
					</form:form>

                   <c:forEach var="empPerValues" items="${empPerValues}">

						<c:set var="ast" value="${empPerValues}"></c:set>
					</c:forEach>

					<c:if test="${ast!=null }">

					<display:table name="EmpPerf" id="EmpPerf" class="table"
						requestURI="EmpPerformanceSearch.mnt" pagesize="5">
						<display:column property="empName" sortable="true"
							titleKey="label.employee" media="html" />
					
						<display:column property="periodFrom" sortable="true"
							titleKey="label.PeriodFrom" media="html" />
							 <display:column property="periodTo" sortable="true"
							titleKey="label.PeriodTo" media="html" />
							
							 <display:column property="statusName" sortable="true"
							titleKey="label.status" media="html" />
						<display:column titleKey="label.edit">
							<a
								href="EmpPerformanceEdit.mnt?EmpPerformanceId=<c:out value="${EmpPerf.performanceReviewId}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:column titleKey="label.delete">
							<a
								href="EmpPerformanceDelete.mnt?EmpPerformanceId=<c:out value="${EmpPerf.performanceReviewId}"/> "
								onclick="return confirm('Do You Want To Delete This Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
						</display:column>

						<display:setProperty name="paging.banner.placement" value="bottom" />
					</display:table>

</c:if>

				</div> 

			
			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
					<form:form commandName="EmpPerformance" id="addform" method="POST"
						action="empPerformanceAdd.mnt">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<%-- <tr>
									<td colspan="2"><c:forEach
											var="addPrivMainDuplicate"
											items="${addPrivMainDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="#C09853"><c:out
														value="${addPrivMainDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr> --%>
						<tr>
						<td><spring:message code="label.employee"></spring:message><font
									color="red">*</font></td>
									<td><form:select path="employeeId" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
								</tr>
								<tr>
								<td><spring:message code="label.PeriodFrom"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="periodFrom" id="periodFrom" class="textbox" /></td>
							
                                </tr>
                                <tr>
								<td><spring:message code="label.PeriodTo"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="periodTo" id="periodTo" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                  
							</tr>
							
								
							
                              
</table>

					<div id="tabsForAdd">
								<!-- EmpPerformanceKPI tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.EmpPerformanceKPI" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
									
										var btEmpPerid = 1;
										
										$(function() {

											var
										    
										    rating = $("#rating"), 
										  
										   
											
										    	kPIId = $("#kPIId"), 
												kvalue=$("#kNumber"), 
												 comment = $("#comment"), 
												evaluationBy = $("#evaluationBy"), 
												evalue=$("#eNumber"), 
												
												hiddenEmpPerformanceID = $("#hiddenEmpPerformancePopUp"),
											
											
											
											allFields = $([]).add(rating).add(kPIId).add(kvalue).add(comment).add(evaluationBy).add(evalue).add(hiddenEmpPerformanceID),
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
											function checkLength1(o, n) {
												if (o.val() == "") {
													o.addClass("ui-state-error");
													updateTips(n + " is Required");
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
											$("#dialog-form-EmpPer")
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
																				kPIId,
																				"KPI"
																				);
																	
																		
																		 
																		 
																		 bValid1 = bValid1
																			&& checkRegexp(
																					rating,
																					/^([0-9])+$/i,
																					"Rating is Required And Must be a Number"
																					
																					); 
																					
																		 bValid1 = bValid1
																			&& checkLength1(
																					comment,
																					"Comment"
																					); 
																		  bValid1 = bValid1
																			&& selectLength(
																					evaluationBy,
																					"EvaluationBy"
																					);
																		
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenEmpPerformanceID
																					.val() == "0"
																					|| hiddenEmpPerformanceID
																							.val() == "") {
																				
																				
																				$("#EmpPerAdd tbody")
																						.append(
																								"<tr id="+btEmpPerid+">"
																								
																																										   
																								 

																								     + "<td ><spring:bind path='EmpPerformance.kPIId'><input type='hidden' name='kPIId' id='kPIId"
																										+ btEmpPerid
																										+ "' value="
																										+ kPIId
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='kNumber' id='kNumber"
																										+ btEmpPerid
																										+ "' value="
																										+ $('#kPIId :selected').text()
																																																				
																										+ " class='textbox'readonly/></td>" 

																									 
																											  
																										 	+ "<td><input type='text' name='rating' id='rating"
																										      + btEmpPerid
																										     + "' value="
																										     + rating
																												.val()
																										     + "  class='textbox'readonly/></td>"
																										 	+ "<td><input type='text' name='comment' id='comment"
																										      + btEmpPerid
																										     + "' value="
																										     + comment
																												.val()
																										     + "  class='textbox'readonly/></td>"

																										     + "<td ><spring:bind path='EmpPerformance.evaluationBy'><input type='hidden' name='evaluationBy' id='evaluationBy"
																												+ btEmpPerid
																												+ "' value="
																												+ evaluationBy
																														.val()
																												+ " class='textbox'/></spring:bind> <input type='text' name='eNumber' id='eNumber"
																												+ btEmpPerid
																												+ "' value="
																												+ $('#evaluationBy :selected').text()
																																																						
																												+ " class='textbox'readonly/></td>"  
																									    +"<td><a href='#'  onclick='editEmpPerformance("
																										+ btEmpPerid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btEmpPerid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btEmpPerid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenEmpPerformanceID
																					.val() != "0") {
																				
																		
																				
																				$(
																						'#rating'
																								+ hiddenEmpPerformanceID
																										.val())
																						.val(
																								rating 
																								        .val());

																				 
																			
																		
																				
																				$(
																						'#kPIId'
																								+ hiddenEmpPerformanceID
																										.val())
																						.val(
																								kPIId 
																								        .val());
																				$(
																						'#kNumber'
																								+ hiddenEmpPerformanceID
																										.val())
																						.val(
																								 $('#kPIId :selected').text());
																				$(
																						'#comment'
																								+ hiddenEmpPerformanceID
																										.val())
																						.val(
																								comment 
																								        .val());

																				$(
																						'#evaluationBy'
																								+ hiddenEmpPerformanceID
																										.val())
																						.val(
																								evaluationBy 
																								        .val());
																				$(
																						'#eNumber'
																								+ hiddenEmpPerformanceID
																										.val())
																						.val(
																								 $('#evaluationBy :selected').text());
																				
																				$(
																						'#hiddenEmpPerformancePopUp')
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

										
											$("#AddEmpPer")
													.button()
													.click(
															function() {
														
																$("#dialog-form-EmpPer")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editEmpPerformance(id) {
									
											$("#dialog-form-EmpPer").dialog("open");
								
											
											
											
											
											$('#rating').val($('#rating' + id).val());
											


											
											$('#kPIId').val(
													$('#kPIId' + id).val());
											
											$('#kNumber').val(
													$('#kNumber' + id).val()); 
											
											$('#comment').val($('#comment' + id).val());

											$('#evaluationBy').val(
													$('#evaluationBy' + id).val());
											
											$('#eNumber').val(
													$('#eNumber' + id).val()); 
										
											$('#hiddenEmpPerformancePopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-EmpPer" title="Add Employee Performance KPI Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
									
									
																 <tr>
												<td><spring:message code="label.kpi" /><font color="red">*</font></td>
											<td><form:select path="kPIId" id="kPIId" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${kpi}" /> 
													
												</form:select>	
												</td>
												</tr>
									
															
															 
									
												  <tr>
						<td><spring:message code="label.rating"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="rating" id="rating" class="textbox" />
								</td></tr>
								
								  						  <tr>
						<td><spring:message code="label.comment"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="comment" id="comment" class="textbox" />
								</td></tr>
								  <tr>
							<td><spring:message code="label.evaluationBy"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="evaluationBy" id="evaluationBy"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select>
                            
											<input type="hidden"
													name="hiddenEmpPerformancePopUp" id="hiddenEmpPerformancePopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="EmpPerAdd" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.kpi" /></th>
													
													<th><spring:message code="label.rating" /></th>
													<th><spring:message code="label.comment" /></th>
													<th><spring:message code="label.evaluationBy" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="AddEmpPer" type="button">Add Employee Performance KPI Details</button>
									

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
			

			<!-- Tab-1 -->

			 <div id="tabs-1" class="TabbedPanelsContent">
		
					<c:forEach var="empPerEdit" items="${empPerEdit}"> 

						<form:form method="post" action="EmpPerformanceUpdate.mnt"
							commandName="EmpPerformance" id="editForm">
							<table class="tableGeneral">


								<form:hidden path="performanceReviewIdEdit" id="performanceReviewIdEdit" />
								<tr>
									<td colspan="2"><c:forEach
											var="addempPerEditDuplicate"
											items="${addempPerEditDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="#C09853"><c:out
														value="${addempPerEditDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								  <tr>
							<td><spring:message code="label.employee"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="employeeId" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
                                  
							</tr>
                               <tr>
						<td><spring:message code="label.PeriodFrom"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="periodFrom" id="periodFromEdit" class="textbox" /></td>
							
                                </tr>
                                  <tr>
						<td><spring:message code="label.PeriodTo"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="periodTo" id="periodToEdit" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                  
							</tr>
                               

							</table>
							
						  <div id="tab1" class="TabbedPanelsContent"> 
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.EmpPerformanceKPI" /></a></li>

								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {
									
												var 
											
												ratingEdit = $("#ratingEdit"),
												maintenanceTypeIdEdit=$("#maintenanceTypeIdEdit"),
												kPIIdEdit = $("#kPIIdEdit"),
												commentEdit = $("#commentEdit"),
												evaluationByEdit = $("#evaluationByEdit"),
												hiddenEdit = $("#hiddenEmpPerformancePopUpEdit"),
												
												allFields = $([]).add(maintenanceTypeIdEdit).add(ratingEdit).add(kPIIdEdit)
														.add(commentEdit).add(evaluationByEdit).add(hiddenEdit),
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
												function checkLength1(o, n) {
													if (o.val() == "") {
														o.addClass("ui-state-error");
														updateTips(n + " is Required");
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

												$("#dialog-form-EmpPerEdit")
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
																						kPIIdEdit,
																						"KPI"
																						);
																		
																			
																			 
																			 bValid1 = bValid1
																				&& checkRegexp(
																						ratingEdit,
																						/^([0-9])+$/i,
																						"Rating is Required And Must be a Number"
																						); 
																			 bValid1 = bValid1
																				&& checkLength1(
																						commentEdit,
																						"Comment"
																						); 
																				bValid1 = bValid1
																				&& selectLength(
																						evaluationByEdit,
																						"Evaluation By"
																						);
																		
																			
																			 
																					
																				
																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					
																					$(
																							
																							"#AddEmpPerEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<spring:bind path='EmpPerformance.empPerEditt'><input type='text' name='empPerEditt' id='empPerEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																																																		
																										 + "<td><spring:bind path='EmpPerformance.kPIIdEdit'><input type='hidden' name='kPIIdEdit' id='kPIIdEdit"
																											+ btrid
																											+ "' value="
																											+ kPIIdEdit.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='EmpPerformance.kpiName'><input type='text' name='kpiName' id='kpiName"
																											+ btrid
																											+ "' value="
																											
																											+$('#kPIIdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																											

																										

																												
																												+ "<td><spring:bind path='EmpPerformance.ratingEdit'><input name='ratingEdit' id='ratingEdit"
																												+ btrid
																												+ "' value="
																												+ ratingEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind> </td>"
																												+ "<td><spring:bind path='EmpPerformance.commentEdit'><input name='commentEdit' id='commentEdit"
																												+ btrid
																												+ "' value="
																												+ commentEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind> </td>"
																												 + "<td><spring:bind path='EmpPerformance.evaluationByEdit'><input type='hidden' name='evaluationByEdit' id='evaluationByEdit"
																													+ btrid
																													+ "' value="
																													+ evaluationByEdit.val()
																													+ " class='textbox' readonly/></spring:bind>"
																													+"<spring:bind path='EmpPerformance.empName'><input type='text' name='empName' id='empName"
																													+ btrid
																													+ "' value="
																													
																													+$('#evaluationByEdit :selected').text()
																													+ " class='textbox' readonly/></spring:bind></td>" 
																									 	
																											+"<input type='hidden' name='performanceReviewKPIIdEdit' id='performanceReviewKPIIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+"<td><a href='#'  onclick='editEmpPerformanceDetailsInEditNew("
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
																						'#ratingEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#ratingEdit')
																										.val());
																				
																			
																				
																				$(
																						'#kPIIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#kPIIdEdit')
																										.val());
																				$(
																						'#kpiName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#kPIIdEdit :selected').text());
																				

																				$(
																						'#commentEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#commentEdit')
																										.val());

																				$(
																						'#evaluationByEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#evaluationByEdit')
																										.val());
																				$(
																						'#empName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#evaluationByEdit :selected').text());
																				$(
																						'#hiddenEmpPerformancePopUpEdit')
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

												$("#create-AddEmpPerEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-EmpPerEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(
													id) {
											alert("id is:"+id);
												$('#' + id).remove();
											}
											function editEmpPerformanceDetailsInEditNew(
													link) {
												
												
												$("#dialog-form-EmpPerEdit")
														.dialog("open");
												
										   ;
												
												$('#ratingEdit').val(
														$(
																'#ratingEdit'
																		+ link)
																.val());
												
											
												$('#kPIIdEdit').val(
														$(
																'#kPIIdEdit'
																		+ link)
																.val());
												
												$('#commentEdit').val(
														$(
																'#commentEdit'
																		+ link)
																.val());
												
											
												$('#evaluationByEdit').val(
														$(
																'#evaluationByEdit'
																		+ link)
																.val());
												

												$('#hiddenEmpPerformancePopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-EmpPerEdit" title="Add Employee Performance KPI Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

															 
												 
																					 <tr>
												<td><spring:message code="label.kpi" /><font color="red">*</font></td>
											<td><form:select path="kPIIdEdit" id="kPIIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${kpi}" /> 
													
												</form:select>	
												</td>
												</tr>
									
														
															 
									
												  <tr>
						<td><spring:message code="label.rating"></spring:message><font
									color="red">*</font></td>
								
								
								
								<td><form:input path="ratingEdit" id="ratingEdit" class="textbox" /></td></tr>
								<tr><td>
								<spring:message code="label.comment"></spring:message><font
									color="red">*</font></td>
								
								
								
								<td><form:input path="commentEdit" id="commentEdit" class="textbox" /></td></tr>
								<tr><td><spring:message code="label.evaluationBy" /><font color="red">*</font></td>
											<td><form:select path="evaluationByEdit" id="evaluationByEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${employee}" /> 
													
												</form:select>	
													<input type="hidden"
													name="hiddenEmpPerformancePopUpEdit" id="hiddenEmpPerformancePopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddEmpPerEdit" class="table">
												<thead>
													<tr>
													
														<th><spring:message code="label.kpi" /></th>
													
													<th><spring:message code="label.rating" /></th>
															<th><spring:message code="label.comment" /></th>
													<th><spring:message code="label.evaluationBy" /></th>
													<th><spring:message code="label.edit" /></th>
																<th><spring:message code="label.remove" /></th>
														</tr>

														</thead>
												<tbody>
													<c:forEach var="empPerformanceKPIList"
															items="${empPerformanceKPIList}">

															<c:set var="edit1" value="${empPerformanceKPIList.performanceReviewKPIIdEdit}"></c:set> 
														
																<tr id="${empPerformanceKPIList.performanceReviewKPIIdEdit}">
																
                                                                    <spring:bind
																			path="EmpPerformance.performanceReviewKPIId">
																			<input type="hidden" name="empPerEditt"
																				class="textbox" 
																				value="${empPerformanceKPIList.performanceReviewKPIIdEdit}" id="performanceReviewKPIId${empPerformanceKPIList.performanceReviewKPIIdEdit}" />
																		</spring:bind>
																
																		
																		

																			
																           <spring:bind
																			path="EmpPerformance.kPIIdEdit">
																			<input type="hidden" name="kPIIdEdit"
																				class="textbox" 
																				value="${empPerformanceKPIList.kPIIdEdit}" id="kPIIdEdit${empPerformanceKPIList.performanceReviewKPIIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="EmpPerformance.kpiName">
																			<input type="text" name="kpiName"
																				class="textbox" readonly="readonly"
																				value="${empPerformanceKPIList.kpiName}" id="kpiName${empPerformanceKPIList.performanceReviewKPIIdEdit}" />
																		</spring:bind></td>
																		 
																		<td><spring:bind
																			path="EmpPerformance.ratingEdit">
																			<input type="text" name="ratingEdit"
																				class="textbox" readonly="readonly"
																				value="${empPerformanceKPIList.ratingEdit}"  id="ratingEdit${empPerformanceKPIList.performanceReviewKPIIdEdit}"/>
																		</spring:bind></td>
																		<td>
																	<spring:bind
																			path="EmpPerformance.commentEdit">
																			<input type="text" name="commentEdit"
																				class="textbox" readonly="readonly"
																				value="${empPerformanceKPIList.commentEdit}"  id="commentEdit${empPerformanceKPIList.performanceReviewKPIIdEdit}"/>
																		</spring:bind></td>
																		 <spring:bind
																			path="EmpPerformance.evaluationByEdit">
																			<input type="hidden" name="evaluationByEdit"
																				class="textbox" 
																				value="${empPerformanceKPIList.evaluationByEdit}" id="evaluationByEdit${empPerformanceKPIList.performanceReviewKPIIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="EmpPerformance.empName">
																			<input type="text" name="empName"
																				class="textbox" readonly="readonly"
																				value="${empPerformanceKPIList.empName}" id="empName${empPerformanceKPIList.performanceReviewKPIIdEdit}" />
																		</spring:bind>
																	<input type="hidden" name="${empPerformanceKPIList.performanceReviewKPIIdEdit}Check" id="${empPerformanceKPIList.performanceReviewKPIIdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editEmpPerformanceDetailsInEdit(${empPerformanceKPIList.performanceReviewKPIIdEdit})"><img src="images/Edit.jpg" height="25px" width="25px"
																id="${empPerformanceKPIList.performanceReviewKPIIdEdit}"></img></a></td>
														<td><a href="#"
															id="${empPerformanceKPIList.performanceReviewKPIIdEdit}"
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
																function editEmpPerformanceDetailsInEdit(
																		link) {
																	
																
																	$(
																			"#dialog-form-EmpPerEdit").dialog(
																					"open");
																	
																
																	$('#kPIIdEdit').val(
																			$(
																					'#kPIIdEdit'
																							+ link)
																					.val());	
																	
																	
																	$('#ratingEdit').val(
																			$(
																					'#ratingEdit'
																							+ link)
																					.val());
																	$('#commentEdit').val(
																			$(
																					'#commentEdit'
																							+ link)
																					.val());
																	
																	$('#evaluationByEdit').val(
																			$(
																					'#evaluationByEdit'
																							+ link)
																					.val());
																	
																
																																
																	$('#hiddenEmpPerformancePopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddEmpPerEdit" type="button">Add Employee Performance KPI Details</button>

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
				</div> 
			 </c:forEach>
</div>
</div>
</body>
</html>
