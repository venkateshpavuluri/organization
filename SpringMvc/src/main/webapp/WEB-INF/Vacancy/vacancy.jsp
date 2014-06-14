   
<!-- @author Devi -->
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
						//AddForm Validations
						
						
						$('#subid')
								.click(
										function(event) {
											
											$('#addVacancyform')
													.validate(
															{
																rules : {
																	
																		postedDate:{
																			required : true
																			
																		},
																		vacancyNo:{
																			required: true
																		}
																		
																																				
																},
																 messages : {
																	 postedDate : "<font style='color: red;'><b>Posted Date is Required</b></font>",
																	 vacancyNo : "<font style='color: red;'><b>Vacancy Number is Required</b></font>"
																	
																},
																
																	});
															});
									//	});
						//UpdateForm Validations
						  $('#updateid')
								.click(
										function(event) {
									
											$('#editVacancyForm')
													.validate(
															{
																rules : {
																	postedDateEdit : {
																			required : true 
																			},
																			 vacancyNoEdit :{
																				 required: true
																			 }
																		
																},
																messages : {
																	postedDateEdit : "<font style='color: red;'><b>Posted Date is Required</b></font>",
																	 vacancyNoEdit : "<font style='color: red;'><b>Vacancy Number is Required</b></font>"
																	 
																},
															});

										});  
						
					});
</script>
	
	<script type="text/javascript">
function dateFun(datePattern) {
	$('#postedDate,#postedDateEdit').datepicker({
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
		<div class="PageTitle">Vacancy</div>
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
						<form:form action="searchVacancy.mnt" method="GET"
							commandName="VacancyForm">
							<tr>
								<td colspan="2">
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.vacancy"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
											<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.vacancy"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="vacancyDel"
										items="${vacancyDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.vacancy"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="vacancyDelErr"
										items="${vacancyDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.vacancy"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="vacancyUpdate"
										items="${vacancyUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.vacancy"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="vacancyUpdateErr"
										items="${vacancyUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.vacancy"/> <spring:message code="label.updateFail"/>
										
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


					<c:forEach var="vacancyDetails" items="${listofDNotes}">
						<c:set var="ag" value="${vacancyDetails}"></c:set>
					</c:forEach>
					<c:if test="${ag!=null}">
						<div>
							<display:table id="listofDNotes" name="listofDNotes"
								requestURI="searchrfq.mnt" pagesize="5" class="table">
								<display:column property="vacancyId" titleKey="label.vacancy"
									media="none" sortable="true"></display:column>
								<display:column property="postedDate"
									titleKey="label.postedDate" media="html" sortable="true"></display:column>
                              	<display:column property="vacancyNo"
									titleKey="label.vacancyNo" media="html" sortable="true"></display:column>
                              
                             
								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
									<c:when test="${true }"><a
										href="vacancyEdit.mnt?vEdit=<c:out value="${listofDNotes.vacancyId}"/>"
										style="color: red"><img src="images/Edit.jpg" width="20px"
										onclick="toggleTable();" height="20px" /> </a>
								</c:when><c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose></display:column>
								<display:column titleKey="label.delete">
									<c:choose>
									<c:when test="${true }"><a
										href="vacancyDelete.mnt?vdelId=<c:out value="${listofDNotes.vacancyId}"/>"
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

					<form:form action="saveVacancy.mnt" method="POST"
						commandName="VacancyForm" id="addVacancyform">
						

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">


										<tr>
										<td><spring:message code="label.postedDate" /><span
												class="required">*</span></td>
											<td><form:input path="postedDate" id="postedDate"
													class="textbox" /></td>

										</tr>
											<tr>
										<td><spring:message code="label.vacancyNo" /><span
												class="required">*</span></td>
											<td><form:input path="vacancyNo" id="vacancyNo"
													class="textbox" /></td>

										</tr>
										
									</table>
								</td>
							</tr>
						</table>
						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message
											code="label.vacancyLine" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								

								<script>
									var btrfqid = 1;
									$(function() {

										

										var deptid = $("#departmentId"), noofpos = $("#noOfPositions"), vDetailNo=$("#vacancyDetailNo"), skill = $("#skillId"), status = $("#statusId"), hiddenVacancyID = $("#hiddenIdVacancyPopUp")

										allFields = $([]).add(deptid).add(
												noofpos).add(vDetailNo).add(skill).add(status)
												.add(hiddenVacancyID),
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
											if (o.val().length == "") {
												o.addClass("ui-state-error");
												updateTips("Required");
												return false;
											} else {
												return true;
											}
										}

										function checkRegexp(o, regexp, n) {
											if (!(regexp.test(o.val()))) {
												o.addClass("ui-state-error");
												updateTips(n);
												return false;
											} else {
												return true;
											}
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
																	bValid1 = bValid1
																			&& checkLength1(
																					deptid,

																					"Department is Required");

																	bValid1 = bValid1
																			&& checkRegexp(
																					noofpos,
																					/^([0-9.])+$/i,

																					"NO Of Positions are Required and mustbe integer");
																
																	bValid1 = bValid1
																	&& checkRegexp(
																			vDetailNo,
																			/^([0-9.])+$/i,

																			"Vacancy Detail Number is Required and mustbe integer");
														
																	
																	bValid1 = bValid1
																			&& checkLength1(
																					skill,
																					"Skill is Required");
																	bValid1 = bValid1
																			&& checkLength1(
																					status,

																					"Status is Required");

																	if (bValid1) {

																		if (hiddenVacancyID
																				.val() == "0"
																				|| hiddenVacancyID
																						.val() == "") {

																			$(
																					"#deliveryAdd tbody")
																					.append(

																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='departmentId' id='departmentId"
																									+ btrfqid
																									+ "' value="
																									+ deptid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ " <input type='text' readonly class='textbox' name='department' id='department"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#departmentId :selected')
																											.text()
																									+ "'"
																									+ " /></td>"
																									+ "<td align='center'><input type='text' name='noOfPositions' id='noOfPositions"
																									+ btrfqid
																									+ "' value="
																									+ noofpos
																											.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td align='center'><input type='text' name='vacancyDetailNo' id='vacancyDetailNo"
																									+ btrfqid
																									+ "' value="
																									+ vDetailNo
																											.val()
																									+ "  class='textbox'readonly/></td>"

				

																									+ "<td><input type='hidden' name='skillId' id='skillId"
																									+ btrfqid
																									+ "' value="
																									+ skill
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='skill' id='skill"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#skillId :selected')
																											.text()
																									+ "'"
																									+ "/></td>"

																									+ "<td><input type='hidden' name='statusId' id='statusId"
																									+ btrfqid
																									+ "' value="
																									+ status
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input name='status' id='status"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#statusId :selected')
																											.text()
																									+ "'"
																									+ btrfqid
																									+ "' value="
																									+ status
																											.val()
																									+ " class='textbox'readonly/></td>"
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
																					'#departmentId'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							deptid
																									.val());

																			$(
																					'#department'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							$(
																									'#departmentId :selected')
																									.text());

																			$(
																					'#noOfPositions'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							noofpos
																									.val());
																			$(
																					'#vacancyDetailNo'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							vDetailNo
																									.val());
																			$(
																					'#skillId'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							skill
																									.val());
																			$(
																					'#skill'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							$(
																									'#skillId :selected')
																									.text());
																			$(
																					'#status'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							$(
																									'#statusId :selected')
																									.text());

																			$(
																					'#statusId'
																							+ hiddenVacancyID
																									.val())
																					.val(
																							status
																									.val());

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
										$('#departmentId').val(
												$('#departmentId' + id).val());
										$('#noOfPositions').val(
												$('#noOfPositions' + id).val());
										$('#vacancyDetailNo').val(
												$('#vacancyDetailNo' + id).val());
										$('#skillId').val(
												$('#skillId' + id).val());
										$('#statusId').val(
												$('#statusId' + id).val());
										$('#hiddenIdVacancyPopUp').val(id);

									} 
								</script>


								<div id="dialog-form-Rfq" align="center"
									title="Add New VacancyLine Details">
									<p class="validateTips" align="center">
										<font color="red">All form fields are required</font>
									</p>
									<table class="table" cellspacing=0>
										<tr>
											<td><spring:message code="label.department" /><span
												class="required">*</span></td>
											<td><form:select path="departmentId" id="departmentId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${departmentDetails}" />
												</form:select></td>
										</tr>

										
										<tr>
											<td><spring:message code="label.skill" /><span
												class="required">*</span></td>
											<td><form:select path="skillId" id="skillId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${skillDetails}" />
												</form:select></td>
										</tr>
										
										<tr>
											<td><spring:message code="label.noofpositions" /><span
												class="required">*</span></td>
											<td><form:input path="noOfPositions" id="noOfPositions"
													class="textbox" /></td>
										</tr>
										
										<tr>
											<td><spring:message code="label.vacancyDetailNo" /><span
												class="required">*</span></td>
											<td><form:input path="vacancyDetailNo" id="vacancyDetailNo"
													class="textbox" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.status" /><span
												class="required">*</span></td>
											<td><form:select path="statusId" id="statusId"
													cssClass="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${statusDetails}" />
												</form:select>
												
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
												<%-- 		<th><spring:message code="label.deliveryNote"/></th> --%>
												<th><spring:message code="label.department" /></th>
												<th><spring:message code="label.noofpositions" /></th>
												<th><spring:message code="label.vacancyDetailNo" /></th>
												<th><spring:message code="label.skill" /></th>
												<th><spring:message code="label.status"></spring:message>
												</th>
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>

											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<button id="Rfqlineadd" type="button">
										<spring:message code="label.addvacancyline" />
									</button>
								</div>

								<form:hidden path="vacancyhide" />

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
					<form:form action="vacancyUpdate.mnt" method="POST"
						commandName="VacancyForm" id="editVacancyForm">
						 
						
						<c:if test="${editvalues!=null}">


							<table class="tableGeneral">


								<form:hidden path="" />
								<form:hidden path="vacancyIdEdit" />
								<tr>
									<td><spring:message code="label.postedDate" /><span
										class="required">*</span></td>
									<td><form:input path="postedDateEdit" class="textbox" /></td>
									
								</tr>
                             	<tr>
									<td><spring:message code="label.vacancyNo" /><span
										class="required">*</span></td>
									<td><form:input path="vacancyNoEdit" class="textbox" /></td>
									
								</tr>

							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.vacancyLine" /></a></li>

								</ul>


								<div align="center">

									<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

									<!-- <div align="center"> -->

									<script>
										var btrfqid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */

											var edeptid = $("#departmentIdEdit"), enoofpos = $("#noOfPositionsEdit"), vDetailNo = $("#vacancyDetailNoEdit"), eskill = $("#skillIdEdit"), estatus = $("#statusIdEdit"), ehiddenrfqID = $("#hiddenIdvacancyeditPopUp")

											allFields = $([]).add(edeptid).add(
													enoofpos).add(vDetailNo).add(eskill).add(
													estatus).add(ehiddenrfqID),
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

											function checkLength2(o, n) {

												if (o.val().length == "") {
													o
															.addClass("ui-state-error");
													updateTips("Required");
													return false;
												} else {
													return true;
												}
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

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
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

																		bValid2 = bValid2
																				&& checkLength2(
																						edeptid,

																						"Department is Required");
																		bValid2 = bValid2
																				&& checkRegexp(
																						enoofpos,
																						/^([0-9.])+$/i,

																						"No Of Positions is Required  And Must be  Number");
																		bValid2 = bValid2
																		&& checkRegexp(
																				vDetailNo,
																				/^([0-9.])+$/i,

																				"Vacancy Detail Number is Required  And Must be  Number");


																		bValid2 = bValid2
																				&& checkLength2(
																						eskill,

																						"Skill is Required");

																		bValid2 = bValid2
																				&& checkLength2(
																						estatus,
																						"Status is Required");
																		if (bValid2) {
                                                                  
                                                                      if (ehiddenrfqID
																					.val() == "0"
																					|| ehiddenrfqID
																							.val() == "") {
																			

																				$(
																						"#RFQEdit tbody")
																						.append(
																								"<tr id="+btrfqid+">"
																										+ "<td ><spring:bind path='VacancyForm.vacancyLineidedit' ><input type='hidden'name='vacancyLineidedit'  value='0'/> <input type='hidden' name='departmentIdEdit' id='departmentIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ edeptid
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  "
																										+ "<spring:bind path='VacancyForm.departmentEdit'><input type='text' readonly class='textbox' name='departmentEdit' id='departmentEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#departmentIdEdit :selected')
																												.text()
																										+ "'"
																										+ "</spring:bind></td>"
																										+ "<spring:bind path='VacancyForm.noOfPositionsEdit'><td align='center'><input type='text' name='noOfPositionsEdit' id='noOfPositionsEdit"
																										+ btrfqid
																										+ "' value="
																										+ enoofpos
																												.val()
																										+ "  class='textbox'readonly/></spring:bind></td>"
																										+ "<spring:bind path='VacancyForm.vacancyDetailNoEdit'><td align='center'><input type='text' name='vacancyDetailNoEdit' id='vacancyDetailNoEdit"
																										+ btrfqid
																										+ "' value="
																										+ vDetailNo
																												.val()
																										+ "  class='textbox'readonly/></spring:bind></td>"


																										+ "<td><spring:bind path='VacancyForm.skillIdEdit'><input type='hidden' name='skillIdEdit' id='skillIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ eskill
																												.val()
																										+ " class='textbox'readonly/></spring:bind>"

																										+ "<spring:bind path='VacancyForm.skillEdit'><input type='text' readonly class='textbox' name='skillEdit' id='skillEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#skillIdEdit :selected')
																												.text()
																										+ "'"
																										+ "</spring:bind></td>"
																										+ "<td> <input type='hidden' name='statusIdEdit' id='statusIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ estatus
																												.val()

																										+ " class='textbox'readonly/><input type='text' name='statusEdit' id='statusEdit"
																										+ btrfqid
																										+ "' value="
																										+ $(
																												'#statusEdit :selected')
																												.text()

																										+ " class='textbox'readonly/><input type='hidden' name='vacancyLineidedit' value='0' id='vacancyLineidedit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
																										+

																										// "<td>" + password.val() + "</td>" +
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
																				
																				$('#departmentIdEdit'+ ehiddenrfqID.val()).val(edeptid.val());
																				
																																				
																								
																										
																				$(
																						'#departmentEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#departmentIdEdit :selected')
																										.text());
																				
																				$(
																						'#noOfPositionsEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								enoofpos
																										.val());
																				$(
																						'#vacancyDetailNoEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								vDetailNo
																										.val());
																				
																				
																				$(
																						'#skillIdEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eskill
																										.val());
																				
																				
																				$(
																						'#skillEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#skillIdEdit :selected')
																										.text());
																				$(
																						'#statusIdEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								estatus
																										.val());
																				$(
																						'#statusEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#statusIdEdit :selected')
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
																//alert("opened");
															});
										});
										function removeRfqEdit(id) {
											$('#' + id).remove();
										}

										function editRfqEdit(id) {
										

											$("#dialog-form-RfqEdit").dialog(
													"open");
											$('#noOfPositionsEdit').val($('#noOfPositionsEdit'+ id).val());
											$('#vacancyDetailNoEdit').val($('#vacancyDetailNoEdit'+ id).val());
                        
											$('#departmentIdEdit').val(
													$('#departmentIdEdit' + id).val());
											
											
											$('#skillIdEdit').val(
													$('#skillIdEdit' + id)
															.val());
											$('#statusIdEdit').val(
													$('#statusIdEdit' + id)
															.val()); 

											$('#hiddenIdvacancyeditPopUp').val(id);  
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-RfqEdit" align="center"
										title="Add New VacancyLine Details">
										<p class="validateTips" align="center">
											<font color="red">All form fields are required</font>
										</p>
										<table class="tableGeneral" cellspacing=0>
											<form:hidden path="vacancyLineidedit" value="0" />
											<tr>
												<td><spring:message code="label.department" /><span
													class="required">*</span></td>
												<td><form:select path="departmentIdEdit"
														id="departmentIdEdit" cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${departmentDetails}" />
													</form:select></td>
											</tr>

											
											<tr>
												<td><spring:message code="label.skill" /><span
													class="required">*</span></td>
												<td><form:select path="skillIdEdit" id="skillIdEdit"
														cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${skillDetails}" />
													</form:select></td>
											</tr>

                                             <tr>
												<td><spring:message code="label.noofpositions" /><span
													class="required">*</span></td>
												<td><form:input path="noOfPositionsEdit"
														id="noOfPositionsEdit" class="textbox" /> <input
													type="hidden" name="hiddenIdvacancyeditPopUp"
													id="hiddenIdvacancyeditPopUp" value="0" /></td>
											</tr>
                                             
                                     
                                         <tr>
												<td><spring:message code="label.vacancyDetailNo" /><span
													class="required">*</span></td>
												<td><form:input path="vacancyDetailNoEdit"
														id="vacancyDetailNoEdit" class="textbox" /> <input
													type="hidden" name="hiddenIdvacancyeditPopUp"
													id="hiddenIdvacancyeditPopUp" value="0" /></td>
											</tr>
                                     
											<tr>
												<td><spring:message code="label.status" /><span
													class="required">*</span></td>
												<td><form:select path="statusIdEdit" id="statusIdEdit"
														cssClass="select">
														<form:option value="">--Select--</form:option>
														<form:options items="${statusDetails}" />
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

														<%-- <th><spring:message code="label.deliveryNote"/></th>  --%>
													<th><spring:message code="label.department" /></th>
													<th><spring:message code="label.skill" /></th>
													<th><spring:message code="label.noofpositions" /></th>
													<th><spring:message code="label.vacancyDetailNo" /></th>
													<th><spring:message code="label.status" /></th>
													<th>Edit</th>
													<th>Remove</th>

												</tr>


											</thead>
											<tbody>
												<c:forEach items="${vacancylindetails}"
													var="vacancylindetails">
                                          			<spring:bind path="VacancyForm.vacancyLineidedit">
														<input type="hidden" name="vacancyLineidedit"
															id="vacancyLineidedit${vacancylindetails.vacancyLineidedit}"
															value="${vacancylindetails.vacancyLineidedit}" />
													</spring:bind>

                                                    
                                                                                                         
													 <tr id="${vacancylindetails.vacancyLineidedit}">
														<td><spring:bind path="VacancyForm.departmentIdEdit">
																<input type="hidden" name="departmentIdEdit"
																	class="textbox"
																	id="departmentIdEdit${vacancylindetails.vacancyLineidedit}"
																	value="${vacancylindetails.departmentIdEdit}" />
															</spring:bind> <spring:bind path="VacancyForm.departmentEdit">
																<input type="text" name="departmentEdit" class="textbox"
																	id="departmentEdit${vacancylindetails.vacancyLineidedit}"
																	value="${vacancylindetails.departmentEdit}" readonly />
															</spring:bind></td> 
 
														
														<td><spring:bind path="VacancyForm.skillIdEdit">
																<input type="hidden" name="skillIdEdit"
																	id="skillIdEdit${vacancylindetails.vacancyLineidedit}"
																	class="textbox"
																	value="${vacancylindetails.skillIdEdit}" readonly />
															</spring:bind> <spring:bind path="VacancyForm.skillEdit">
																<input type="text" name="skillEdit"
																	id="skillEdit${vacancylindetails.vacancyLineidedit}"
																	class="textbox" value="${vacancylindetails.skillEdit}"
																	readonly />
															</spring:bind></td>
															<td><spring:bind path="VacancyForm.noOfPositionsEdit">
																<input type="text" name="noOfPositionsEdit"
																	id="noOfPositionsEdit${vacancylindetails.vacancyLineidedit}"
																	class="textarea"
																	value="${vacancylindetails.noOfPositionsEdit}"
																	readonly />
															</spring:bind></td>
															
															<td><spring:bind path="VacancyForm.vacancyDetailNoEdit">
																<input type="text" name="vacancyDetailNoEdit"
																	id="vacancyDetailNoEdit${vacancylindetails.vacancyLineidedit}"
																	class="textarea"
																	value="${vacancylindetails.vacancyDetailNoEdit}"
																	readonly />
															</spring:bind></td>
															
														<td><spring:bind path="VacancyForm.statusIdEdit">
																<input type="hidden" name="statusIdEdit"
																	id="statusIdEdit${vacancylindetails.vacancyLineidedit}"
																	class="textbox"
																	value="${vacancylindetails.statusIdEdit}" readonly />
															</spring:bind> <spring:bind path="VacancyForm.statusEdit">
																<input type="text" name="statusEdit"
																	id="statusEdit${vacancylindetails.vacancyLineidedit}"
																	class="textbox"
																	value="${vacancylindetails.statusEdit}" readonly />
															</spring:bind> <input type="hidden"
															name="Checkdelete${vacancylindetails.vacancyLineidedit}"
															id="${vacancylindetails.vacancyLineidedit}Checkdelete"
															value="0" /></td>


														<td><a href='#' id="${vacancylindetails.vacancyLineidedit}" onclick="editRfqEdit(this.id)"><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>
													
														<td><a href='#'
															id="${vacancylindetails.vacancyLineidedit}"
															onclick="getID11(this)"><strong><img
																	src='images/button_cancel.png' height='25px'
																	width='25px' /></strong></a></td>
													</tr>



													<script type="text/javascript">
														function getID11(link) {
															//alert(link.id);
															alert("Deleting Particular Row Will Deleted Once You Click Update Button");
															document
																	.getElementById(link.id
																			+ "Checkdelete").value = "1";
															document
																	.getElementById(link.id).style.display = "none";
														}
														function editProcessDetailsInEdit(
																link) {
															//alert("CH");

															$(
																	"#dialog-form-RfqEdit")
																	.dialog(
																			"open");
															$(
																	'#departmentIdEdit'
																			+ link.id)
																	.val(
																			$(
																					'#departmentIdEdit')
																					.val());
															
															$('#skillIdEdit')
																	.val(
																			$(
																					'#skillIdEdit'
																							+ link.id)
																					.val());
															$(
																	'#noOfPositionsEdit')
																	.val(
																			$(
																					'#noOfPositionsEdit'
																							+ link.id)
																					.val());
															$(
															'#vacancyDetailNoEdit')
															.val(
																	$(
																			'#vacancyDetailNoEdit'
																					+ link.id)
																			.val());
														
															$('#statusIdEdit')
																	.val(
																			$(
																					'#statusIdEdit'
																							+ link.id)
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
										<button id="AddRFQEdit" type="button">Add Vacancy
											Line Details</button>
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