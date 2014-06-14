<!-- @author Venkatesh -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
											
											$('#addDeliveryform')
													.validate(
															{
																rules : {
																	applicantId : {
																		required : true },
																		
																		vacancyDetailId:{
																			required : true	
																		},
																		scheduledTime:{
																			required : true	
																		},
																		assignedTo:{
																			required : true	
																		},
																		venue:{
																			required : true	
																		},
																		scheduledDate:{
																			required : true	
																		},
																		
																		
																},
																 messages : {
																	 applicantId : "<font style='color: red;'><b>Applicant is Required</b></font>",
																	 vacancyDetailId : "<font style='color: red;'><b>Vacancy Detail is Required</b></font>",
																	 scheduledTime : "<font style='color: red;'><b>Scheduled Time is Required</b></font>",
																	 assignedTo : "<font style='color: red;'><b>Employee is Required</b></font>",
																	 venue : "<font style='color: red;'><b>Venue is Required</b></font>",
																	 scheduledDate : "<font style='color: red;'><b>Scheduled Date is Required</b></font>",
																	
																	
																},
																
																	});
															});
									//	});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
									
											$('#editDeliveryForm')
													.validate(
															{
																rules : {
																	applicantId : {
																		required : true },
																		
																		vacancyDetailId:{
																			required : true	
																		},
																		scheduledTime:{
																			required : true	
																		},
																		assignedTo:{
																			required : true	
																		},
																		venue:{
																			required : true	
																		},
																		scheduledDate:{
																			required : true	
																		},
																		
																},
																messages : {
																	 applicantId : "<font style='color: red;'><b>Applicant is Required</b></font>",
																	 vacancyDetailId : "<font style='color: red;'><b>Vacancy Detail is Required</b></font>",
																	 scheduledTime : "<font style='color: red;'><b>Scheduled Time is Required</b></font>",
																	 assignedTo : "<font style='color: red;'><b>Employee is Required</b></font>",
																	 venue : "<font style='color: red;'><b>Venue is Required</b></font>",
																	 scheduledDate : "<font style='color: red;'><b>Scheduled Date is Required</b></font>",
																	
																	
																},
															});

										}); 
						
					});
					
					
					
					function doAjaxPost() {
						var vendorName = $('#applicantId').val();
						
							$.ajax({
								type : "POST",
								url : "IVScheduleDuplicate.mnt",
								data : "applicantName=" + vendorName,
								success : function(response) {
							
									//var checkResponse="Warning ! @Vendor@ Duplicate values are not allowed";
									if(response=="")
									{
									document.getElementById("IVScheduleDuplicateMess").style.display="block";
									//$('#vendorDuplicateMess').html("Warning ! Vendor Name aleardy exists. Please try some other name");
									$('#subid').hide();
									}
									else
									{
									document.getElementById("IVScheduleDuplicateMess").style.display="none";
									$('#subid').show();
									}
								},
								error : function(e) {
									//alert('Error: ' + e);
								}

							});
						}
					
					
					function  doAjaxPostEdit()
					{
					var applicantName=$('#applicantIdEdit').val();
					var IVScheduleId=$('#interviewScheduleId').val();
		
							$.ajax({
							type : "POST",
							url : "IVScheduleCheckEdit.mnt",
							data : "applicantName=" + applicantName+ "&IVScheduleId=" + IVScheduleId,
							success : function(response) {
							// we have the response
			
								if(response=="")
								{
								document.getElementById("IVScheduleDuplicateMessEdit").style.display="block";
								//$('#vendorDuplicateMessEdit').html(response);
								$('#updateid').hide();
								
								}
								else
								{
								document.getElementById("IVScheduleDuplicateMessEdit").style.display="none";
								$('#updateid').show();
								}
							

							},

							error : function(e) {

							//	alert('Error: ' + e);

							}

						});
						}

					
</script>
<script type="text/javascript">
function dateFun(datePattern) {
	$('#scheduledDate,#scheduledDateEdit').datepicker({
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
			$('#vacancyDetailId').val('');
			$('#applicantId').val('');
			$('#scheduledDate').val('');
			$('#scheduledTime').val('');
			$('#interviewRoundId').val('');
			$('#assignedTo').val('');
			$('#venue').val('');

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
		$('#search').click(function(e) {
			$('#edit').hide();

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
		<div class="PageTitle">Interview Schedule</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editValues}">
				
				
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
						<form:form action="searchIVSchedule.mnt" method="GET"
						commandName="interviewSchedule">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
                                      <strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.interviewSchedule"/> <spring:message code="label.saveSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
                              <strong><spring:message code="label.error"/> </strong>
                              <spring:message code="label.interviewSchedule"/> <spring:message code="label.saveFail"/>
											
										</div>
									</c:forEach><c:forEach items="${IVScheduleUpdate}">
										<div class="alert-success" id="successmessage">
										  <strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.interviewSchedule"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach items="${IVScheduleUpdateFail}">
										<div class="alert-danger" id="successmessage">
											  <strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.interviewSchedule"/> <spring:message code="label.updateFail"/>
										</div>
									</c:forEach>
									<c:forEach items="${IVScheduleDelete}">
										<div class="alert-success" id="successmessage">
										  <strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.interviewSchedule"/> <spring:message code="label.deleteSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach items="${IVScheduleDeleteFail}">
										<div class="alert-danger" id="successmessage">
											  <strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.interviewSchedule"/> <spring:message code="label.deleteFail"/>
										</div>
									</c:forEach>
									
									
									</td>
								
							</tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> 
									<form:select path="operations" cssClass="select">										
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
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
								<c:when test="${save }">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary"  /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger"  />
									</c:otherwise>
									
								</c:choose></td>
							</tr>
							</form:form>
							<form:form action="IVScheduleAdvanceSearch.mnt" method="get"
							commandName="interviewSchedule" name="advanceSearchFinal">
							<tr>
								<td colspan="2"><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue"><u><b>Advanced Search</b></u></font></a> <a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							</tr>
						</form:form>
						</table>
					
	        <form:form action="IVSheduleAdvanceSearchOperations.mnt" commandName="interviewSchedule">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${listofIVSchedule}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1">
												<form:option value="0">-Select-</form:option>
												<form:option value="=">Equals To</form:option>
												<form:option value="!=">Not Equals To</form:option>
												<form:option value="_%">BeginsWith</form:option>
												<form:option value="%_">EndsWith</form:option>
												<form:option value="%_%">Contains</form:option>
											</form:select></td>
										<td><form:input path="advanceSearchText"
												id="advanceSearch" /></td>
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
										style="display: none" class="btn btn-primary" /></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
								</tr>
								
							</table>

						</div>
					</form:form>
				
					<c:if test="${IVScheduleDetails!=null}">
					<div >
						<display:table id="IVScheduleDetailsRow" name="IVScheduleDetails"
							requestURI="searchIVSchedule.mnt" pagesize="5" class="table">
						
							<display:column property="vacancyNo" titleKey="label.vacancyNumber" media="html"
								sortable="true"></display:column>
								<display:column property="empName" titleKey="label.empName" media="html"
								sortable="true"></display:column>
								<display:column property="applicanName" titleKey="label.applicanName" media="html"
								sortable="true"></display:column>
								<display:column property="iVRoundName" titleKey="label.interviewRound" media="html"
								sortable="true"></display:column>
								<display:column property="scheduledDate" titleKey="label.scheduledDate" media="html"
								sortable="true"></display:column>
								<display:column property="scheduledTime" titleKey="label.scheduledTime" media="html"
								sortable="true"></display:column>
								<display:column property="venue" titleKey="label.venue" media="html"
								sortable="true"></display:column>
							
								
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
								<a
									href="iVScheduleEdit.mnt?iVScheduleId=<c:out value="${IVScheduleDetailsRow.interviewScheduleId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px" onclick="toggleTable();" 
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px" class="btn btn-danger" height="20px" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
								<a
									href="iVScheduleDelete.mnt?iVScheduleId=<c:out value="${IVScheduleDetailsRow.interviewScheduleId}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a></c:when>
									<c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger"
									width="20px" height="20px"/>  </a>
									</c:otherwise>
									</c:choose>
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

					<form:form action="saveInterviewSchedule.mnt" method="POST"
							commandName="interviewSchedule" id="addDeliveryform">


							<table class="tableGeneral">
                     <tr><td>
								<table class="tableGeneral">
					 <tr>
									<td colspan="4" id="IVScheduleDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.applicant" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr> 
						
							<tr>
							<%-- 	<td><spring:message code="label.deliveryNoteId" /><span
									class="required">*</span></td>
									<td><form:input path="deliveryNoteId" /> </td> --%>
								
								<td><spring:message code="label.vacancyDetails" /><span
									class="required">*</span> </td>
									<td>
									<form:select path="vacancyDetailId" id="vacancyDetailId" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options items="${vacancyDetails}"/>
									</form:select>
									</td>
								<td><spring:message code="label.applicant" /><span
									class="required">*</span></td>
									<td> 
										<form:select path="applicantId" id="applicantId" cssClass="select" onchange="doAjaxPost()">
										<form:option value="">--Select--</form:option>
										<form:options items="${applicantDetails}" />
										</form:select>
										
										</td></tr>
										<tr><td><spring:message code="label.scheduledDate" /><span
									class="required">*</span></td>
									<td> <form:input path="scheduledDate" id="scheduledDate"
										class="textbox"  /></td>
										<td><spring:message code="label.scheduledTime" /><span
									class="required">*</span></td>
									<td><form:input path="scheduledTime" id="scheduledTime" maxlength="50" cssClass="textbox"/> </td>
										
										</tr>
						<tr><td><spring:message code="label.interviewRound" /><span
									class="required">*</span></td>
									<td>
										<form:select path="interviewRoundId" id="interviewRoundId" cssClass="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${interviewRoundDetails}" />
										</form:select>
										</td>
												<td><spring:message code="label.assignedTo"  /><span
									class="required">*</span></td>
									<td>
									<form:select path="assignedTo" id="assignedTo" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options  items="${employeeDetails}"/>
									</form:select>
									
									
									</td>
										</tr>
										<tr> 
										<td><spring:message code="label.venue"/> </td>
										<td><form:input path="venue" id="venue" maxlength="50" cssClass="select"/> </td>
										</tr>
						
								
				
							</table>
							</td>

							</tr>
							</table>
						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message code="label.interViewResult" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->
									
									<!-- <div align="center"> -->
								<script>
										var btrfqid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */
											
											
											var irApplicantId = $("#irApplicantId"), rating = $("#rating"),nextRound=$("#nextRound"), comments = $("#comments"), hiddenDeliveryID = $("#hiddenIdDeliveryPopUp")
											
											
											allFields = $([]).add(irApplicantId).add(nextRound).add(rating).add(comments).add(hiddenDeliveryID),
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
												if (o.val().length =="") {
													o
															.addClass("ui-state-error");
													updateTips("Required");
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

											$("#dialog-form-Rfq")
													.dialog(
															{
																autoOpen : false,
																height : 250,
																width : 300,
																modal : true,
																buttons : {
																	Submit : function() {
																		
																		
																		allFields.removeClass("ui-state-error");
																		var bValid1 = true;	
																		  bValid1 = bValid1
																			&& checkLength1(
																					irApplicantId,
																					
																					"Applicant is Required");
																		  bValid1 = bValid1
																			&& checkLength1(
																					nextRound,
																					
																					"NextRound is Required");
																		  bValid1 = bValid1
																			&& checkLength1(
																					rating,/^([0-9.])+$/i,"Rating is Required And Must be  Number");
																		  bValid1 = bValid1
																			&& checkLength1(
																					comments,
																					
																					"Comments is Required");
																		
																		  
																			/* bValid1 = bValid1
																			&& checkLength1(
																					nextRound,/^([0-9.])+$/i,"Quantity is Required And Must be  Number"); */
																			
																					
																	 	if (bValid1) {
																	 	
																			
																			if (hiddenDeliveryID
																					.val() == "0"
																					|| hiddenDeliveryID
																							.val() == "") {
																				
																				$("#deliveryAdd tbody")
																						.append(
																								
																								"<tr id="+btrfqid+">"
																								+ "<td ><input type='hidden' name='irApplicantId' id='irApplicantId"
																								+ btrfqid
																								+ "' value="
																								+ irApplicantId
																										.val()
																								+ " class='textbox'readonly/>"
																								+" <input type='text' readonly class='textbox' name='applicantName' id='applicantName"+btrfqid+"' value='"+$('#irApplicantId :selected').text()+"'"
																								 +" /></td>" 
																								
																							
																							
																								+ "<td><input type='text' name='rating' id='rating"
																								+ btrfqid
																								+ "' value="
																								+ rating
																										.val()
																								+ "  class='textbox'readonly/></td>"
																								+ "<td><input type='hidden' name='nextRound' id='nextRound"
																								+ btrfqid
																								+ "' value="
																								+ nextRound
																										.val()
																								+ " class='textbox'readonly/>"
																								+"<input type='text' readonly class='textbox' name='nextRoundName' id='nextRoundName"+btrfqid+"' value='"+$('#nextRound :selected').text()+"'"
																								+"/></td>"
																								
																								+ "<td><input type='text' name='comments' id='comments"
																								+ btrfqid
																								+ "' value="
																								+ comments
																										.val()
																								+ "  class='textbox'readonly/></td>" 
																								+"<td><a href='#'  onclick='editRfq("
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
																		
																	 	if (hiddenDeliveryID
																				.val() != "0") {
																			$(
																					'#irApplicantId'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							irApplicantId
																									.val());
																			
																			
																			
																			
																			
																			$(
																					'#applicantName'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							$('#irApplicantId :selected').text());
																		
																			$(
																					'#rating'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							rating
																									.val());
																			$(
																					'#nextRound'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							nextRound
																									.val());
																			$(
																					'#nextRoundName'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							$('#nextRound :selected').text());
																			
																			$(
																					'#comments'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							comments
																									.val());
																			
																			$(
																					'#hiddenIdDeliveryPopUp')
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

										
											$("#Rfqlineadd")
													.button()
													.click(
															function() {
																$("#dialog-form-Rfq")
																		.dialog(
																				"open");
																
															});
										});
										function removeRfq(id) {
								
											$('#' + id).remove();
										}
										function editRfq(id) {
										
											$("#dialog-form-Rfq").dialog("open");
										    $('#irApplicantId').val($('#irApplicantId' + id).val());
										  
											$('#rating').val($('#rating' + id).val());
											$('#nextRound').val($('#nextRound' + id).val());
											$('#comments').val($('#comments' + id).val());
											$('#hiddenIdDeliveryPopUp').val(id);
										
									}  
									
									</script> 


								  <div id="dialog-form-Rfq" align="center" title="Add New DeleveryNoteLine Details">
										<p class="validateTips" align="center" ></p>
										<table class="tableGeneral" cellspacing=0>
				
											
											<tr>
												<td><spring:message code="label.applicant"/><span
									class="required">*</span> </td>
												<td>
										<form:select path="irApplicantId" id="irApplicantId"  cssClass="select" >
												<form:option value="">--Select--</form:option>
												<form:options items="${applicantDetails}" />
												</form:select>
												
												</td>
												
											</tr>
											<tr>
												<td> <spring:message code="label.rating"/><span
									class="required">*</span>
												</td>
												<td>
												<form:input path="rating"  id="rating" cssClass="select" />
<form:hidden path="aid" />
												 </td>
											</tr>
									         											<tr>
												<td><spring:message code="label.nextRound"/><span
									class="required">*</span></td>
												<td> <form:select path="nextRound" id="nextRound" cssClass="select">
 	                                         <form:option value="">--Select--</form:option>  
												<form:option value="true">Yes</form:option>
												<form:option value="false">No</form:option>
												</form:select>
													  
													 <input type="hidden" 
													name="hiddenIdDeliveryPopUp" id="hiddenIdDeliveryPopUp" value="0" /> </td>
											</tr>
											
										
											 <tr><td><spring:message code="label.Commnets" /><span
									class="required">*</span></td>
											  <td><form:input path="comments" maxlength="500" id="comments" cssClass="textbox"/> </td> </tr>
											 
											

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
											
													<th><spring:message code="label.applicant"/></th>
													<th><spring:message code="label.rating"/></th>
													<th><spring:message code="label.nextRound"/> </th>
													<th><spring:message code="label.comments"></spring:message> </th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
			
												</tr>
											</thead>
											<tbody>
												
											</tbody> 
										</table>
										<button id="Rfqlineadd" type="button"><spring:message code="label.addInterviewresults"/></button>
									</div> 
									
								<%-- <form:hidden path="deliveryhide" /> --%>

						<!-- 	</div>   -->
									
									
									
									
									
									
									
			
								
								<!-- </div> -->
							</div>
								
								
						</div>
							 <table>
										<tr>
											<td colspan="2">
											<c:choose>
											<c:when test="${update}">
											<input type="submit" value="<spring:message code="label.save"/>"
												class="btn btn-primary" id="subid" /><!-- <input type="reset"
												class="btn btn-primary" /> -->
												</c:when>
												<c:otherwise>
												<input type="submit" value="<spring:message code="label.save"/>" 
												class="btn btn-danger" disabled="disabled" id="subid" />
												</c:otherwise>
												</c:choose>
												<input type="reset" value="<spring:message code="label.reset"/>"  class="btn btn-primary" />
												 </td>
										</tr>
									
									</table> 
					</form:form>

				</div>
			</div>
			
			
			
			
			
			
		<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="searchIVUpdate.mnt" method="POST"
						commandName="interviewSchedule" id="editDeliveryForm">
						
						<c:if test="${editValues!=null}">

							
							<table class="tableGeneral">
 <tr>
									<td colspan="4" id="IVScheduleDuplicateMessEdit" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.applicant" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr> 
								
								<form:hidden path="" />
							
								<tr>
							
								<form:hidden path="interviewScheduleId" id="interviewScheduleId" />
							<td><spring:message code="label.vacancyDetails" /><span
									class="required">*</span> </td>
									<td>
									<form:select path="vacancyDetailId" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options items="${vacancyDetails}"/>
									</form:select>
									</td>
								<td><spring:message code="label.applicant" /><span
									class="required">*</span></td>
									<td> 
										<form:select path="applicantId" id="applicantIdEdit" onchange="doAjaxPostEdit()" cssClass="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${applicantDetails}" />
										</form:select>
										
										</td></tr>
										<tr><td><spring:message code="label.scheduledDate" /><span
									class="required">*</span></td>
									<td> <form:input path="scheduledDate" id="scheduledDateEdit"
										class="textbox"  /></td>
										<td><spring:message code="label.scheduledTime" /><span
									class="required">*</span></td>
									<td><form:input path="scheduledTime" id="scheduledTime" maxlength="50"  cssClass="textbox"/> </td>
										
										</tr>
						<tr><td><spring:message code="label.interviewRound" /><span
									class="required">*</span></td>
									<td>
										<form:select path="interviewRoundId" id="interviewRoundId" cssClass="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${interviewRoundDetails}" />
										</form:select>
										</td>
												<td><spring:message code="label.assignedTo"  /><span
									class="required">*</span></td>
									<td>
									<form:select path="assignedTo" id="assignedTo" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options  items="${employeeDetails}"/>
									</form:select>
									
									
									</td>
										</tr>
										<tr> 
										<td><spring:message code="label.venue"/> </td>
										<td><form:input path="venue" id="venue" maxlength="50" cssClass="select"/> </td>
										</tr>
						
								
							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message code="label.interViewResult" /></a></li>

								</ul>
								
								
                         <div align="center">

								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->
									
									<!-- <div align="center"> -->
									
									<script>
										var btrfqid = 0;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */
											
											
											var irApplicantIdEdit = $("#irApplicantIdEdit"), ratingEdit = $("#ratingEdit"),nextRoundEdit=$("#nextRoundEdit"), commentsEdit = $("#commentsEdit"), ehiddenrfqID = $("#hiddenIddeliveryeditPopUp");
											
											
											allFields = $([]).add(irApplicantIdEdit).add(ratingEdit).add(nextRoundEdit).add(commentsEdit).add(ehiddenrfqID),
											 tips = $(".validateTips");

											

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength2(o, n) {
												
												if (o.val().length =="") {
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
																		allFields.removeClass("ui-state-error");
																		bValid2 = bValid2
																			&& checkLength2(
																					irApplicantIdEdit,
																					
																					"Applicant is Required");
																		bValid2 = bValid2
																			&& checkLength2(
																					nextRoundEdit,
																					
																					"NextRound is Required"); 
																		bValid2 = bValid2
																		&& checkLength2(
																				commentsEdit,
																				
																				"Comments is Required"); 
																		
																		bValid2 = bValid2
																			&& checkLength2(
																					ratingEdit, /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/,"Rating is Required And Must be  Number");
															
																		
															 if(bValid2){
																	
																																					
																			if (ehiddenrfqID
																					.val() == "0"
																					|| ehiddenrfqID
																							.val() == "") {

																				 $("#RFQEdit tbody")
																						.append(
																								"<tr id="+btrfqid+">"
																										+ "<td ><spring:bind path='interviewSchedule.interviewResultIdEdit' ><input type='hidden'name='interviewResultIdEdit'  value='0'/> <input type='hidden' name='irApplicantIdEdit' id='irApplicantIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ irApplicantIdEdit
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  "
																										+"<spring:bind path='interviewSchedule.applicanName'><input type='text'class='textbox' name='applicanName' id='applicanName"+btrfqid+"' value='"+$('#irApplicantIdEdit :selected').text()+"'"
																										+"</spring:bind></td>"
																										 + "<spring:bind path='interviewSchedule.ratingEdit'><td align='left'><input type='text' name='ratingEdit' id='ratingEdit"
																										+ btrfqid
																										+ "' value="
																										+ ratingEdit
																												.val()
																										+ "  class='textbox'readonly/></spring:bind></td>"
																										+ "<td ><spring:bind path='interviewSchedule.nextRoundEdit' ><input type='hidden'name='nextRoundEdit'  value='0'/> <input type='hidden' name='nextRoundEdit' id='nextRoundEdit"
																										+ btrfqid
																										+ "' value="
																										+ nextRoundEdit
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  "
																										+"<spring:bind path='interviewSchedule.nextRoundNameEdit'><input type='text'class='textbox' name='nextRoundNameEdit' id='nextRoundNameEdit"+btrfqid+"' value='"+$('#nextRoundEdit :selected').text()+"'"
																										+"</spring:bind></td>"

																									/* 	+ "<input type='hidden' name='nextRoundEdit' id='nextRoundEdit"
																										+ btrfqid
																										+ "'value="
																										+ nextRoundEdit
																										.val() */
																										
																										/* +"<spring:bind path='interviewSchedule.nextRoundNameEdit'><td align='left'
																										<input type='text' name='nextRoundNameEdit' id='nextRoundNameEdit"
																										+ btrfqid
																										+ "'"+$('#nextRoundEdit :selected').text()+"'"
																										+ "  class='textbox'readonly/></spring:bind></td>" */
																									
																									 + "<td><spring:bind path='interviewSchedule.commentsEdit'><input type='text' name='commentsEdit' id='commentsEdit"
																										+ btrfqid
																										+ "' value="
																										+ commentsEdit
																												.val()
																										+ " class='textbox'readonly/></spring:bind>" 
																										
																										+"</td>"
																										+ "<input type='hidden' name='interviewResultIdEdit' value='0' id='interviewResultIdEdit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/>"
																										 
																										
																										// "<td>" + password.val() + "</td>" +
																										+"<td><a href='#'  onclick='editRfqEdit("
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
																				
																				
																				$('#irApplicantIdEdit'+ ehiddenrfqID.val()).val(irApplicantIdEdit.val());
																				$('#applicanName'+ ehiddenrfqID.val()).val($('#irApplicantIdEdit :selected').text());
																				 $('#ratingEdit'+ ehiddenrfqID.val()).val(ratingEdit.val()); 
																				$('#nextRoundEdit'+ ehiddenrfqID.val()).val(nextRoundEdit.val());
																				$('#nextRoundNameEdit'+ ehiddenrfqID.val()).val($('#nextRoundEdit :selected').text());
																				$('#commentsEdit'+ ehiddenrfqID.val()).val(commentsEdit.val()); 
																				$('#hiddenIddeliveryeditPopUp').val("0");
																				$(this).dialog("close");
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
																$("#dialog-form-RfqEdit")
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
										
											
											$('#irApplicantIdEdit').val(
													$('#irApplicantIdEdit' + id).val());
											 $('#ratingEdit').val(
													$('#ratingEdit' + id)
															.val());
											$('#nextRoundEdit').val(
													$('#nextRoundEdit' + id)
															.val());
											$('#commentsEdit').val(
													$('#commentsEdit' + id).val()); 
											
									
										$('#hiddenIddeliveryeditPopUp').val(id);
										// document.getElementById("").value="edit";
									}
									</script> 


									 <div id="dialog-form-RfqEdit" align="center" title="Add New DeliveryLine Details">
										<p class="validateTips" align="center" ><font color="red">All form fields are required</font></p>
										<table class="tableGeneral" cellspacing=0>
                           <form:hidden path="interviewResultIdEdit" id="interviewResultIdEdit" value="0"/>  
								<tr>
												<td><spring:message code="label.applicant"/><span
									class="required">*</span> </td>
												<td>
										<form:select path="irApplicantIdEdit" id="irApplicantIdEdit" cssClass="select">
												<form:option value="">--Select--</form:option>
												<form:options items="${applicantDetails}" />
												</form:select>
												
												</td>
											</tr>
											<tr>
												<td> <spring:message code="label.rating"/><span
									class="required">*</span>
												</td>
												<td>
												<form:input path="ratingEdit"  id="ratingEdit" cssClass="textbox" />

												 </td>
											</tr>
									         											<tr>
												<td><spring:message code="label.nextRound"/><span
									class="required">*</span> </td>
												<td> <form:select path="nextRoundEdit" id="nextRoundEdit" cssClass="select">
 	                                     <form:option value="">--Select--</form:option>  
												<form:option value="1">Yes</form:option>
												<form:option value="0">No</form:option>
												</form:select>
													  
													 <input type="hidden" 
													name="hiddenIddeliveryeditPopUp" id="hiddenIddeliveryeditPopUp" value="0" /> </td>
											</tr>
											
										
											 <tr><td><spring:message code="label.Commnets" /><span
									class="required">*</span></td>
											  <td><form:input path="commentsEdit" maxlength="500" id="commentsEdit" cssClass="textbox"/> </td> </tr>
										</table>
										
									</div> 


									
									<div id="users-contain-Process">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="RFQEdit" class="table">
											<thead>
												<tr>
												 
												<%-- 	<th><spring:message code="label.deliveryNote"/></th>  --%>
												<th><spring:message code="label.applicant"/></th>
													<th><spring:message code="label.rating"/></th>
													<th><spring:message code="label.nextRound"/> </th>
													<th><spring:message code="label.comments"></spring:message> </th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
			
												
											</thead>
											<tbody>
												<c:forEach items="${interviewResult}"
												var="interviewResult">
                                                
                                              
                                                
                                               <spring:bind path="interviewSchedule.interviewResultIdEdit">
															<input type="hidden" name="interviewResultIdEdit" id="interviewResultIdEdit${interviewResult.interviewResultIdEdit}"
																value="${interviewResult.interviewResultIdEdit}"  />
														</spring:bind>
                                                
												
													
						
	                                                <tr id="${interviewResult.interviewResultIdEdit}">
												<spring:bind path="interviewSchedule.irApplicantIdEdit">
															<input type="hidden" name="irApplicantIdEdit"  class="textbox" id="irApplicantIdEdit${interviewResult.interviewResultIdEdit}"
																value="${interviewResult.irApplicantIdEdit}"  />
														</spring:bind>														
													
													<td>	<spring:bind path="interviewSchedule.applicanName">
															<input type="text" name="applicanName"  class="textbox" id="applicanName${interviewResult.interviewResultIdEdit}"
																value="${interviewResult.applicanName}"  />
														</spring:bind>
														
														</td>
														
														<td><spring:bind path="interviewSchedule.ratingEdit">
																	<input type="text" name="ratingEdit" class="textbox"
																		id="ratingEdit${interviewResult.interviewResultIdEdit}"
																		value="${interviewResult.ratingEdit}" readonly="readonly"/>
																</spring:bind></td>
																


													<spring:bind path="interviewSchedule.nextRoundEdit">
															<input type="hidden" name="nextRoundEdit" id="nextRoundEdit${interviewResult.interviewResultIdEdit}"
																class="textbox"
																value="${interviewResult.nextRoundEdit}" readonly="readonly" />
														</spring:bind>
														<td>
														
														<spring:bind path="interviewSchedule.nextRoundNameEdit">
															<input type="text" name="nextRoundNameEdit" id="nextRoundNameEdit${interviewResult.interviewResultIdEdit}"
																class="textbox"
																value="${interviewResult.nextRoundNameEdit}" readonly="readonly" />
														</spring:bind>
														</td>
														
													<td><spring:bind path="interviewSchedule.commentsEdit">
															<input type="text" name="commentsEdit" id="commentsEdit${interviewResult.interviewResultIdEdit}"
																class="textbox"
																value="${interviewResult.commentsEdit}" readonly="readonly"/>
														</spring:bind>
														
														<input type="hidden" name="Checkdelete${interviewResult.interviewResultIdEdit}" id="${interviewResult.interviewResultIdEdit}Checkdelete" value="0"/></td>
													
												<%-- 	<c:out value="${interviewResult.interviewResultIdEdit}"></c:out> --%>
													<td><a href='#' id="${interviewResult.interviewResultIdEdit}" onclick="editRfqEdit(this.id)"><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>
													<td><a href='#' id="${interviewResult.interviewResultIdEdit}" onclick="getID11(this)"><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>
												</tr>

												
															
															<script type="text/javascript">
																function getID11(
																		link) {
																
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link.id+"Checkdelete").value = "1";
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
																			'#irApplicantIdEdit'+link.id)
																			.val(
																					$(
																							'#irApplicantIdEdit').val());
																	$('#ratingEdit')
																			.val(
																					$('#ratingEdit'
																									+ link.id)
																							.val());
																	$('#nextRoundEdit')
																			.val(
																					$('#nextRoundEdit'
																									+ link.id)
																							.val());
																	$('#commentsEdit')
																			.val(
																					$('#commentsEdit'
																									+ link.id)
																							.val());
																	

																	$('#hiddenIddeliveryeditPopUp')
																			.val(
																					link.id);

																}
															</script>
														
											</c:forEach>
											</tbody>
										</table>
										<button id="AddRFQEdit" type="button"><spring:message code="label.addInterviewresults"/> </button>
									</div>
									
									</div> 
								
							</div>
							
							<table>
								<tr>
									<td colspan="2" align="center">
									<c:choose>
									<c:when test="${true }">
									
									<input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-primary" id="updateid" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/>" class="btn btn-danger" id="updateido" />
									</c:otherwise>
									</c:choose>
										
                                    </td>
										 
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
			
			
			
		