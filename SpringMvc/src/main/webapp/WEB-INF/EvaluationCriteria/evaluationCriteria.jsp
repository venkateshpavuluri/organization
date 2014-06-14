<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
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


<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#subid')
								.click(
										function(event) {
											$("#addform")
													.validate(
															{
																rules : {
																	evaluationCriteria : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																		
																	},
																	weightingFactor : {
																		required : true,
																		number :true
																		
																		
																	}
																},
																messages : {

																	evaluationCriteria : {

																		required : "<font style='color: red;'><b>Evaluation Criteria is Required.</b></font>",

																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		
																	},

																	weightingFactor : {

																	required : "<font style='color: red;'><b>Weighting Factor is Required.</b></font>",

																	number : "<font style='color: red;'><b>Weighting Factor must be number</b></font>",
																	
																	
																}
																},

															});
										});

						$('#updateSubmit')
								.click(
										function(event) {

											$("#editform")
													.validate(
															{
																rules : {
																	evaluationCriteriaEdit : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																		
																	},
																	weightingFactorEdit : {
																		required : true,
																		number :true
																		
																		
																	}
																},
																messages : {
																	evaluationCriteriaEdit : {

																		required : "<font style='color: red;'><b>Evaluation Criteria is Required.</b></font>",

																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		
																	},

																	weightingFactorEdit : {

																	required : "<font style='color: red;'><b>Weighting Factor is Required.</b></font>",

																	number : "<font style='color: red;'><b>Weighting Factor must be number</b></font>",
																	
																	
																}
																},

															});
										});
					});
</script>

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
	$(document).ready(function() {
		if (document.getElementById("aid").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#edit').hide();

		});
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
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
		<div class="PageTitle">Evaluation Criteria</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="EvaluationCriteriavalues"
					items="${EvaluationCriteriavalues}">
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
					<form:form action="EvaluationCriteriaSearch.mnt" method="get"
						commandName="EvaluationCriteriaadd" name="agreementform">
						<table class="tableGeneral">



							<tr>
								<td colspan="2"><c:forEach var="EvaluationCriteriaAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.EvaluationCriteria" />
											<spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach> <c:if test="${param.listwar!=null }">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>

											<spring:message code="label.EvaluationCriteria" />
											<spring:message code="label.saveFail" />
										</div>
									</c:if> <c:forEach var="EvaluationCriteriaUpdate"
										items="${EvaluationCriteriaUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.EvaluationCriteria" />
											<spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach> <c:forEach var="EvaluationCriteriaUpdateError"
										items="${EvaluationCriteriaUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.EvaluationCriteria" />
											<spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach>
									<c:forEach var="EvaluationCriteriadelete"
										items="${EvaluationCriteriadelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.EvaluationCriteria" />
											<spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach>
									<c:forEach var="EvaluationCriteriadeleteError"
										items="${EvaluationCriteriadeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.EvaluationCriteria" />
											<spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="EvaluationCriteriaadd.operations">
										<select class="select" name="operations">
											<option value="<spring:message code='assignedOperator'/>">
												<spring:message code="label.equalsTo" />
											</option>
											<option value="<spring:message code='notequalsOperator'/>">
												<spring:message code="label.notEqualsTo" />
											</option>
											<option value="<spring:message code='beginsWithOperator'/>">
												<spring:message code="label.beginsWith" />
											</option>
											<option value="<spring:message code='endsWithOperator'/>">
												<spring:message code="label.endsWith" />
											</option>
											<option value="<spring:message code='containsOperator'/>">
												<spring:message code="label.contains" />
											</option>
										</select>
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /> <c:set
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

									</c:forEach> <c:choose>
										<c:when test="${true}">
											<input type="submit"
												value="<spring:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>


					<c:if test="${agtvalues!=null }">
						<display:table id="EvaluationCriteria" name="EvaluationCriteria"
							requestURI="EvaluationCriteriaSearch.mnt" pagesize="5"
							class="table">


							<%-- <display:column property="EvaluationCriteria_Id" title="EvaluationCriteria_Id" media="html" sortable="true" ></display:column> --%>
							<display:column property="evaluationCriteria"
								titleKey="label.EvaluationCriteria" media="html" sortable="true" />
							<display:column property="weightingFactor"
								titleKey="label.WeightingFactor" media="html" sortable="true" />


							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${true }">
										<a
											href="EvaluationCriteriaEditHome.mnt?EvaluationCriteriaEdit=<c:out 

								value="${EvaluationCriteria.evaluationCriteriaId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px" height="20px"
											class="btn btn-danger" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${true}">

										<a
											href="EvaluationCriteriaDelete.mnt?EvaluationCriteriaDelete=<c:out value="${EvaluationCriteria.evaluationCriteriaId}"/>"
											style="color: red"
											onclick="return confirm('Do u want to delete the Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>

									</c:when>
									<c:otherwise>

										<a><img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

							<display:setProperty name="paging.banner.group_size" value="3" />

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. 

						</span>" />
						</display:table>
					</c:if>


				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="EvaluationCriteriaadd.mnt" method="POST"
						commandName="EvaluationCriteriaadd" id="addform">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach
										var="addEvaluationCriteriaDuplicate"
										items="${addEvaluationCriteriaDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.EvaluationCriteria" />
											<spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.EvaluationCriteria" /><font
									color="red">*</font></td>
								<td><form:input path="evaluationCriteria"
										id="evaluationCriteria" class="textbox" maxlength="50" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.WeightingFactor" /><font
									color="red">*</font></td>
								<td><form:input path="weightingFactor" id="weightingFactor"
										class="textbox" maxlength="50" /></td>

							</tr>

						</table>
						<div id="tabsForAdd">
							<!-- Employee Manager tab -->
							<ul>
								<li><a href="#subtabs-1"><spring:message
											code="label.EvaluationSubCriteriaDetails" /></a></li>

							</ul>
							<div id="scroll">
								<div align="center">


									<script>
										var btEvalCriteriaid = 1;
										$(function() {

											var
										    
										    score = $("#score"), 
										    evaluationSubCriteria=$("#evaluationSubCriteria"),
											
											
										    
												hiddenEvaluationCriteriaID = $("#hiddenEvaluationCriteriaPopUp"),
											
											
											
											allFields = $([]).add(evaluationSubCriteria).add(score).add(hiddenEvaluationCriteriaID),
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
											$("#dialog-form-EvalCriteria")
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
																			&& checkLength1(
																					evaluationSubCriteria,
																					"Evaluation Sub Criteria"
																					);
																	
																		 
																		 
																		 bValid1 = bValid1
																			&& checkLength1(
																					score,
																					"Score"
																					); 
																					
																		
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenEvaluationCriteriaID
																					.val() == "0"
																					|| hiddenEvaluationCriteriaID
																							.val() == "") {
																				
																				
																				$("#EvalCriteriaAdd tbody")
																						.append(
																								"<tr id="+btEvalCriteriaid+">"
																								
																																										   
																								 
																											
																											+ "<td><input type='text' name='evaluationSubCriteria' id='evaluationSubCriteria"
																										      + btEvalCriteriaid
																										     + "' value="
																										     + evaluationSubCriteria
																												.val()
																										     + "  class='textbox'readonly/></td>"  
																											
																										 	+ "<td><input type='text' name='score' id='score"
																										      + btEvalCriteriaid
																										     + "' value="
																										     + score
																												.val()
																										     + "  class='textbox'readonly/></td>"
																										     
																									    +"<td><a href='#'  onclick='editEvaluationCriteria("
																										+ btEvalCriteriaid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btEvalCriteriaid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btEvalCriteriaid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenEvaluationCriteriaID
																					.val() != "0") {
																				
																		
																				
																				$(
																						'#score'
																								+ hiddenEvaluationCriteriaID
																										.val())
																						.val(
																								score 
																								        .val());

																				 
																				
																				$(
																						'#evaluationSubCriteria'
																								+ hiddenEvaluationCriteriaID
																										.val())
																						.val(
																								evaluationSubCriteria 
																								        .val());
																		
																				
																				
																				
																				$(
																						'#hiddenEvaluationCriteriaPopUp')
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

										
											$("#AddEvalCriteria")
													.button()
													.click(
															function() {
														
																$("#dialog-form-EvalCriteria")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editEvaluationCriteria(id) {
									
											$("#dialog-form-EvalCriteria").dialog("open");
								
											
											
											
											$('#evaluationSubCriteria').val($('#evaluationSubCriteria' + id).val());
											$('#score').val($('#score' + id).val());
											


										
										
											$('#hiddenEvaluationCriteriaPopUp').val(id);
										
									}
									</script>


									<div id="dialog-form-EvalCriteria"
										title="Add Evaluation Sub Criteria Details">
										<p class="validateTips"></p>
										<table class="tableGeneral">

											<tr>
												<td><spring:message code="label.EvaluationSubCriteria" /><font
													color="red">*</font></td>
												<td><form:input path="evaluationSubCriteria"
														id="evaluationSubCriteria" class="textbox" maxlength="50" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.Score" /><font
													color="red">*</font></td>
												<td><form:input path="score" id="score" class="textbox"
														maxlength="50" /></td>

												<td><input type="hidden"
													name="hiddenEvaluationCriteriaPopUp"
													id="hiddenEvaluationCriteriaPopUp" value="0" /></td>
											</tr>
										</table>
									</div>



									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="EvalCriteriaAdd" class="table">
											<thead>
												<tr>


													<th><spring:message code="label.EvaluationSubCriteria" /></th>
													<th><spring:message code="label.Score" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>


												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									</div>
									<button id="AddEvalCriteria" type="button">Add
										Evaluation Sub Criteria Details</button>


								</div>
							</div>
						</div>
						<table>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${true}">
											<input type="submit"
												value="<spring:message
								code="label.save" />"
												class="btn btn-primary" id="subid" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value='<spring:message code="label.save"/>'
												class="btn btn-danger" id="sumbnid" />
										</c:otherwise>

									</c:choose> <input type="reset" class="btn btn-primary"
									value="<spring:message
								code="label.reset" />" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="EvaluationCriteriavalues"
						items="${EvaluationCriteriavalues }">

						<form:form action="EvaluationCriteriaUpdate.mnt" method="POST"
							commandName="EvaluationCriteriaadd" id="editform">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach
											var="editEvaluationCriteriaDuplicate"
											items="${editEvaluationCriteriaDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning" /></strong>
												<spring:message code="label.EvaluationCriteria" />
												<spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="evaluationCriteriaIdEdit"
									id="evaluationCriteriaIdEdit" />
								<tr>
									<td><spring:message code="label.EvaluationCriteria" /><font
										color="red">*</font></td>
									<td><form:input path="evaluationCriteriaEdit"
											id="evaluationCriteriaEdit" class="textbox" maxlength="50" /></td>
								</tr>

								<tr>
									<td><spring:message code="label.WeightingFactor" /><font
										color="red">*</font></td>
									<td><form:input path="weightingFactorEdit"
											id="weightingFactorEdit" class="textbox" maxlength="50" /></td>
								</tr>
							</table>
							<div id="tab1" class="TabbedPanelsContent">
								<div id="tabsForEdit">
									<ul>

										<li><a href="#tab1"><spring:message
													code="label.EvaluationSubCriteriaDetails" /></a></li>

									</ul>
									<div id="scroll">
										<!--Sub Tab-1 -->
										<div id="tab1">
											<div align="center">
												<script>
											var btrid = 1;
											$(function() {
									
												var 
											
												
												evaluationSubCriteriaEdit=$("#evaluationSubCriteriaEdit"),
												scoreEdit = $("#scoreEdit"),
											
											
												hiddenEdit = $("#hiddenEvalCriteriatenancePopUpEdit"),
												
												allFields = $([]).add(evaluationSubCriteriaEdit).add(scoreEdit)
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

												$("#dialog-form-EvalCriteriaEdit")
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
																				&& checkLength1(
																						evaluationSubCriteriaEdit,
																						"Evaluation Sub Criteria"
																						);
																			
																			 
																			 bValid1 = bValid1
																				&& checkLength1(
																						scoreEdit,
																						"Score"
																						); 
																						
																				
																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					
																					$(
																							
																							"#AddEvalCriteriaEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<spring:bind path='EvaluationCriteriaadd.eveCriteriaEditt'><input type='hidden' name='eveCriteriaEditt' id='eveCriteriaEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																										

																												+ "<td><spring:bind path='EvaluationCriteriaadd.evaluationSubCriteriaEdit'><input name='evaluationSubCriteriaEdit' id='evaluationSubCriteriaEdit"
																												+ btrid
																												+ "' value="
																												+ evaluationSubCriteriaEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind> </td>"
																												+ "<td><spring:bind path='EvaluationCriteriaadd.scoreEdit'><input name='scoreEdit' id='scoreEdit"
																												+ btrid
																												+ "' value="
																												+ scoreEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind> </td>"
																									 	
																											+"<input type='hidden' name='evaluationSubCriteriaIdEdit' id='evaluationSubCriteriaIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+"<td><a href='#'  onclick='editEvalCriteriatenanceDetailsInEditNew("
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
																						'#scoreEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#scoreEdit')
																										.val());
																				
																			
																				
																				

																				$(
																						'#evaluationSubCriteriaEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#evaluationSubCriteriaEdit')
																										.val());
																				
																				$(
																						'#hiddenEvalCriteriatenancePopUpEdit')
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

												$("#create-AddEvalCriteriaEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-EvalCriteriaEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(
													id) {
											alert("id is:"+id);
												$('#' + id).remove();
											}
											function editEvalCriteriatenanceDetailsInEditNew(
													link) {
												
												
												$("#dialog-form-EvalCriteriaEdit")
														.dialog("open");
												
										   ;
												
												$('#scoreEdit').val(
														$(
																'#scoreEdit'
																		+ link)
																.val());
												
												$('#evaluationSubCriteriaEdit').val(
														$(
																'#evaluationSubCriteriaEdit'
																		+ link)
																.val());
											
												
											

												$('#hiddenEvalCriteriatenancePopUpEdit')
														.val(link);

											}
										</script>


												<div id="dialog-form-EvalCriteriaEdit"
													title="Add Evaluation Sub Criteria Details">
													<p class="validateTips"></p>
													<table class="tableGeneral">

														<tr>
															<td><spring:message code="label.EvaluationCriteria" /><font
																color="red">*</font></td>
															<td><form:input path="evaluationSubCriteriaEdit"
																	id="evaluationSubCriteriaEdit" class="textbox"
																	maxlength="50" /></td>
														</tr>

														<tr>
															<td><spring:message code="label.Score" /><font
																color="red">*</font></td>
															<td><form:input path="scoreEdit" id="scoreEdit"
																	class="textbox" maxlength="50" /></td>
															<td><input type="hidden"
																name="hiddenEvalCriteriatenancePopUpEdit"
																id="hiddenEvalCriteriatenancePopUpEdit" value="0" /></td>
														</tr>





													</table>
												</div>

												<div id="users-contain-EmpEdit">

													<h3></h3>
													<table id="AddEvalCriteriaEdit" class="table">
														<thead>
															<tr>

																<th><spring:message
																		code="label.EvaluationSubCriteria" /></th>
																<th><spring:message code="label.Score" /></th>
																<th><spring:message code="label.edit" /></th>
																<th><spring:message code="label.remove" /></th>

															</tr>

														</thead>
														<tbody>
															<c:forEach var="evaluationSubCriteriaList"
																items="${evaluationSubCriteriaList}">

																<c:set var="edit1"
																	value="${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}"></c:set>

																<tr
																	id="${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}">

																	<spring:bind
																		path="EvaluationCriteriaadd.evaluationSubCriteriaId">
																		<input type="hidden" name="eveCriteriaEditt"
																			class="textbox"
																			value="${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}"
																			id="evaluationSubCriteriaId${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}" />
																	</spring:bind>



																	<td><spring:bind
																			path="EvaluationCriteriaadd.evaluationSubCriteriaEdit">
																			<input type="text" name="evaluationSubCriteriaEdit"
																				class="textbox" readonly="readonly"
																				value="${evaluationSubCriteriaList.evaluationSubCriteriaEdit}"
																				id="evaluationSubCriteriaEdit${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}" />
																		</spring:bind></td>

																	<td><spring:bind
																			path="EvaluationCriteriaadd.scoreEdit">
																			<input type="text" name="scoreEdit" class="textbox"
																				readonly="readonly"
																				value="${evaluationSubCriteriaList.scoreEdit}"
																				id="scoreEdit${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}" />
																		</spring:bind> <input type="hidden"
																		name="${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}Check"
																		id="${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}Check"
																		value="0" /></td>
																	<td><a href="#"
																		onclick="javascript:editEvalCriteriatenanceDetailsInEdit(${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit})"><img
																			src="images/Edit.jpg" height="25px" width="25px"
																			id="${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}"></img></a></td>
																	<td><a href="#"
																		id="${evaluationSubCriteriaList.evaluationSubCriteriaIdEdit}"
																		onclick="javascript:getID1(this)"><img
																			src="images/button_cancel.png" height="25px"
																			width="25px"></img></a></td>
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
																function editEvalCriteriatenanceDetailsInEdit(
																		link) {
																
																	$(
																			"#dialog-form-EvalCriteriaEdit").dialog(
																					"open");
																	
																	
																	
																	
																	
															
																	
																	$('#evaluationSubCriteriaEdit').val(
																			$(
																					'#evaluationSubCriteriaEdit'
																							+ link)
																					.val());
																	
																	$('#scoreEdit').val(
																			$(
																					'#scoreEdit'
																							+ link)
																					.val());
																	
																																
																	$('#hiddenEvalCriteriatenancePopUpEdit')
																			.val(
																					link);

										}
															</script>

															</c:forEach>


														</tbody>

													</table>
	</div>
												<button id="create-AddEvalCriteriaEdit" type="button">Add
													 Evaluation Sub Criteria Details</button>

											</div>

										</div>
									</div>

								</div>
							</div>









							<table>


								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${true}">
												<input type="submit"
													value="<spring:message
								code="label.update" />"
													class="btn btn-primary" id="updateSubmit" />
											</c:when>
											<c:otherwise>
												<td><input type="submit" disabled="disabled"
													value="<spring:message code="label.update"/>"
													class="btn btn-danger" id="updateId" /></td>
											</c:otherwise>

										</c:choose></td>
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>




