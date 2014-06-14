<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
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
<script type="text/javascript">
	function loadXMLDoc() {
		alert("hai");
		var ve = $('#vendorId').val();
		alert("the id is:"+ve);
		var xmlhttp;
		//alert("fdfd"+xmlhttp);
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("vendorEmailId").innerHTML = xmlhttp.responseText;
			}
		};
		
		//alert(goodsReceipt);

		//var selectedText = vendor.options[vendor.selectedIndex].text;
		//alert(selectedText);

		var url = "vendorDetails.mnt?vendor=" + ve;
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Vacancy Mail</div>
<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

<form:form action="sendVacancyMail.mnt" method="POST"
							commandName="vacancyMail">
							
					<table class="tableGeneral">
					<%-- 	<tr style="width:30%">
						
						<c:forEach var="vacancyMail" items="vacancyMail"><div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.vacancyMail"/> <spring:message code="label.sendSuccess"></spring:message>
										</div></c:forEach>
						
						</tr> --%>
								<tr>
								<td><spring:message code="label.vacancy" /><span
									class="required">*</span></td>
									<td><form:select path="vacancyId" class="select">
										<form:option value="0">--Select--</form:option>
								         <form:options items="${vacancyMailIds}" />
								</form:select></td>
								</tr>
								<tr>
								<td><spring:message code="label.employee"/><span class="required">*</span></td>
								<td><form:checkbox path="employee" value="Yes" /></td>
							</tr>
							
					
					</table>
				
			<div id="tabsForAdd">
								<!-- Recruitment Plan Line Tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.vendorDetails" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
										var btresreqid = 1;
										$(function() {

											var 
										
											vendorId= $("#vendorId"), 
											vendorName=$("#vendorNumber"), 
											vendorEmailId=$("#vendorEmailId");
											vendorEmail=$("#vendorEmail"),
											hiddenRecruitmentPlanID = $("#hiddenRecruitmentPlanPopUp"),
											
											
											
											allFields = $([]).add(vendorId).add(vendorName).add(vendorEmail).add(vendorEmailId).add(hiddenRecruitmentPlanID),
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
																		//alert("hai");
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
																			
																			
																			if (hiddenRecruitmentPlanID
																					.val() == "0"
																					|| hiddenRecruitmentPlanID
																							.val() == "") {
																				
																				
																				$("#resReqAdd tbody")
																						.append(
																								"<tr id="+btresreqid+">"
																								



																								     + "<td ><spring:bind path='vacancyMail.vendorId'><input type='hidden' name='vendorId' id='vendorId"
																										+ btresreqid
																										+ "' value="
																										+ vendorId
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='vendorName' id='vendorName"
																										+ btresreqid
																										+ "' value="
																										+ $('#vendorId :selected').text()
																																																				
																										+ " class='textbox'readonly/></td>" 
																										
																										  + "<td ><spring:bind path='vacancyMail.vendorEmailId'><input type='hidden' name='vendorEmailId' id='vendorEmailId"
																											+ btresreqid
																											+ "' value="
																											+ vendorEmailId
																													.val()
																											+ " class='textbox'/></spring:bind> <input type='text' name='vendorEmail' id='vendorEmail"
																											+ btresreqid
																											+ "' value="
																											+ $('#vendorEmailId :selected').text()
																																																					
																											+ " class='textbox'readonly/></td>" 
																											
																										
																								    
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
																						'#vendorId'
																								+ hiddenRecruitmentPlanID
																										.val())
																						.val(
																								vendorId 
																								        .val());
																				$(
																						'#vendorName'
																								+ hiddenRecruitmentPlanID
																										.val())
																						.val(
																								 $('#vendorId :selected').text());
																				
																				$(
																						'#vendorEmailId'
																								+ hiddenRecruitmentPlanID
																										.val())
																						.val(
																								vendorEmailId 
																								        .val());
																				$(
																						'#vendorEmail'
																								+ hiddenRecruitmentPlanID
																										.val())
																						.val(
																								 $('#vendorEmailId :selected').text());
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
								
																					
											$('#vendorId').val(
													$('#vendorId' + id).val());
											
											$('#vendorName').val(
													$('#vendorName' + id).val()); 
											
											$('#vendorEmailId').val(
													$('#vendorEmailId' + id).val());
											
											$('#vendorEmail').val(
													$('#vendorEmail' + id).val()); 
										
											$('#hiddenRecruitmentPlanPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-resReq" title="Add Vendors">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
								
														
															
															 <tr>
												<td><spring:message code="label.vendor" /><font color="red">*</font></td>
												<td><form:select path="vendorId" id="vendorId" class="select" 
													cssStyle="height:25px;" onchange="loadXMLDoc()">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${vendorIds}" /> 
													
												</form:select>	</td></tr>
												<tr>	<td><spring:message code="label.vendorEmail" /></td>
									<td><form:select path="vendorEmailId"
											id="vendorEmailId" class="select">
											<form:option value="0">--- Select ---</form:option>
										</form:select>
						
															
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
													
													<th><spring:message code="label.vendor" /><font color="red">*</font></th>
													<th><spring:message code="label.vendorEmail" /><font color="red">*</font></th>
												
													
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
			</div>
			
				
</body>
</html>