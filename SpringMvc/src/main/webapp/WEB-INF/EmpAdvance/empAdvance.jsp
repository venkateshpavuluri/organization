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
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						jQuery.validator.addMethod("alphabets", function(value,
								element) {
							return this.optional(element)
									|| /^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});
						
						jQuery.validator.addMethod("alphanumeric", function(value,
								element) {
							return this.optional(element)
									|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});

						jQuery.validator.addMethod("specialcharacters",
								function(value, element) {
									return this.optional(element)
											|| /^[0-9a-zA-Z&_ ]+$/.test(value);
								});

						$('#subid')
								.click(
										function(event) {
											$("#addForm")
													.validate(
															{
																rules : {
																	
																	loanTypeId:{
																		required : true	
																	},
																	employeeId:{
																		required : true	
																	},
																	advanceAmount:{
																		required : true,
																		number:true
																	},
																	currencyId:{
																		required : true	
																	},
																	repayAmountPM:{
																		required : true	
																	},
																	statusId:{
																		required : true	
																	},
																	payModeId:{
																		required : true	
																	},
																	bankId:{
																		required : true	
																	},
																	fixedAmount:{
																		number:true
																	},
																	noofInstallments:{
																		required : true,
																		number:true
																		
																	},
																	sTDT:{
																		required : true
																	
																		
																	}
																	
																	
																	
																	
																},
																messages : {

																	loanTypeId : {

																		required : "<font style='color: red;'><b>Loan Type is Required.</b></font>",

																	
																		
																	},
																employeeId : {

																	required : "<font style='color: red;'><b>Employee is Required.</b></font>",

																
																	
																},
																advanceAmount : {

																			required : "<font style='color: red;'><b>Advance Amount is Required.</b></font>",
																			number : "<font style='color: red;'><b>Advance Amount should be a number.</b></font>",
																		
																			
																		},
																		currencyId : {

																		required : "<font style='color: red;'><b>Currency is Required.</b></font>",

																	
																		
																	},
																	repayAmountPM : {

																				required : "<font style='color: red;'><b>RepayAmountPM is Required.</b></font>",

																			
																				
																			},
																			fixedAmount:{
																				number:"<font style='color: red;'><b>Fixed amount should be a number.</b></font>"
																			},
																		statusId : {

																			required : "<font style='color: red;'><b>Status is Required.</b></font>",

																		
																			
																		},
																				payModeId : {

																					required : "<font style='color: red;'><b>PayMode is Required.</b></font>",

																				
																					
																				},
																			bankId : {

																				required : "<font style='color: red;'><b>Bank is Required.</b></font>",

																			
																				
																			},
																			noofInstallments:{
																				required : "<font style='color: red;'><b>No Of Installments is Required.</b></font>",
																				number:"<font style='color: red;'><b>No Of Installments should be number.</b></font>"
																			},
																			sTDT:{
																				required : "<font style='color: red;'><b>Start Date is Required.</b></font>",
																			}
																},

															});
										});

						$('#updateAgree')
								.click(
										function(event) {

											$("#agreementUpdate")
													.validate(
															{
																rules : {
																	loanTypeId:{
																		required : true	
																	},
																	employeeId:{
																		required : true	
																	},
																	advanceAmount:{
																		required : true,
																		number:true
																	},
																	currencyId:{
																		required : true	
																	},
																	repayAmountPM:{
																		required : true	
																	},
																	statusId:{
																		required : true	
																	},
																	payModeId:{
																		required : true	
																	},
																	bankId:{
																		required : true	
																	},
																	noofInstallments:{
																		required : true,
																		number:true
																		
																	},
																	fixedAmount:{
																		number:true
																	},
																	sTDT:{
																		required : true
																	
																		
																	}
																	
																	
																	
																	
																},
																messages : {
																	loanTypeId : {

																		required : "<font style='color: red;'><b>Loan Type is Required.</b></font>",

																	
																		
																	},
																employeeId : {

																	required : "<font style='color: red;'><b>Employee is Required.</b></font>",

																
																	
																},
																advanceAmount : {

																			required : "<font style='color: red;'><b>Advance Amount is Required.</b></font>",
																			number : "<font style='color: red;'><b>Advance Amount should be a number.</b></font>",
																		
																			
																		},
																		currencyId : {

																		required : "<font style='color: red;'><b>Currency is Required.</b></font>",

																	
																		
																	},
																	repayAmountPM : {

																				required : "<font style='color: red;'><b>RepayAmountPM is Required.</b></font>",

																			
																				
																			},
																			fixedAmount:{
																				number:"<font style='color: red;'><b>Fixed amount should be a number.</b></font>"
																			},
																		statusId : {

																			required : "<font style='color: red;'><b>Status is Required.</b></font>",

																		
																			
																		},
																				payModeId : {

																					required : "<font style='color: red;'><b>PayMode is Required.</b></font>",

																				
																					
																				},
																			bankId : {

																				required : "<font style='color: red;'><b>Bank is Required.</b></font>",

																			
																				
																			},
																			noofInstallments:{
																				required : "<font style='color: red;'><b>No Of Installments is Required.</b></font>",
																				number:"<font style='color: red;'><b>No Of Installments should be number.</b></font>"
																			},
																			sTDT:{
																				required : "<font style='color: red;'><b>Start Date is Required.</b></font>",
																			}
																},

															});
										});
					});
</script>
<script type="text/javascript">
function dateFun(datePattern) {
	$('#sTDT,#startDate').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
		
});
}
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
			$('#loanTypeId').val('');
			$('#employeeId').val('');
			$('#currencyId').val('');
			$('#advanceAmount').val('');
			$('#repayAmountPM').val('');
			$('#statusId').val('');
			$('#description').val('');
			$('#bankId').val('');
			$('#branch').val('');
			$('#isFixedAmount').val('');
			$('#isEMI').val('');
			$('#noofInstallments').val('');
			$('#fixedAmount').val('');
			$('#sTDT').val('');
			$('#payModeId').val('');

		});
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Employee Advance</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="EmpAdvancevalues" items="${EmpAdvancevalues}">
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
					<form:form action="EmpAdvanceSearch.mnt" method="get"
						commandName="empAdvanceCommand" name="agreementform">
						<table class="tableGeneral">
						
						
					
							<tr>
								<td colspan="2"><c:forEach var="empAdvanceCommand"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.empAdvance"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="EmpAdvanceUpdate"
										items="${EmpAdvanceUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="EmpAdvanceUpdateError"
										items="${EmpAdvanceUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="EmpAdvancedelete"
										items="${EmpAdvancedelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="EmpAdvancedeleteError"
										items="${EmpAdvancedeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="empAdvanceCommand.operations">
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

									</c:forEach>
									
									 <c:choose>
										<c:when test="${true}"><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
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
						<display:table id="EmpAdvance" name="EmpAdvance"
							requestURI="EmpAdvanceSearch.mnt" pagesize="5" class="table">

						<display:column property="loanTypeName" sortable="true"
							titleKey="label.loanType" media="html" />
							
							<display:column property="empName" sortable="true"
							titleKey="label.employee" media="html" />
	<display:column property="advanceAmount" sortable="true"
							titleKey="label.advanceAmount" media="html" />
							<display:column property="currencyName" sortable="true"
							titleKey="label.currency" media="html" />
							<display:column property="repayAmountPM" sortable="true"
							titleKey="label.repayAmountPM" media="html" />
							<display:column property="statusName" sortable="true"
							titleKey="label.status" media="html" />

							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
								<a
									href="EmpAdvanceEditHome.mnt?EmpAdvanceEdit=<c:out 

								value="${EmpAdvance.empAdvanceId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
									</c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${true}">
							
								<a
									href="EmpAdvanceDelete.mnt?EmpAdvanceDelete=<c:out value="${EmpAdvance.empAdvanceId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
									
									</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
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

					<form:form action="EmpAdvanceAdd.mnt" method="POST"
						commandName="empAdvanceCommand" id="addForm">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach var="addEmpAdvanceDuplicate"
										items="${addEmpAdvanceDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
						<td><spring:message code="label.loanType"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:select path="loanTypeId" id="loanTypeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${loanType }" />
									</form:select></td>
								<td><spring:message code="label.employee"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:select path="employeeId" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
                                </tr>
                           <tr>
							<td><spring:message code="label.advanceAmount"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="advanceAmount" id="advanceAmount" class="textbox" /></td>
                                  <td><spring:message code="label.currency"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="currencyId" id="currencyId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${currency }" />
									</form:select></td>
							</tr> 
								<tr>
						<td><spring:message code="label.repayAmountPM"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="repayAmountPM" id="repayAmountPM" class="textbox" /></td>
								<td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                </tr>
											<tr>
						<td><spring:message code="label.description"></spring:message></td>
								
								
								<td><form:input path="description" id="description" class="textbox" /></td>
								<td><spring:message code="label.payMode"></spring:message></td>
								<td><form:select path="payModeId" id="payModeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${payMode }" />
									</form:select></td>
								
							
                                </tr>
                                
                                		<tr>
						<td><spring:message code="label.bank"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="bankId" id="bankId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${bank }" />
									</form:select></td>
						<td><spring:message code="label.branch"></spring:message></td>
								
								
								<td><form:input path="branch" id="branch" class="textbox" /></td>
								
							
                                </tr>
								
								<tr>
						<td><spring:message code="label.isFixedAmount"></spring:message></td>
									<td><form:select path="isFixedAmount" id="isFixedAmount"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:option value="true">Yes</form:option>
										<form:option value="false">No</form:option>
									</form:select></td>
									
									
									<td><spring:message code="label.fixedAmount"></spring:message></td>
								<td><form:input path="fixedAmount" id="fixedAmount" class="textbox" /></td>
									
								
							
                                </tr>
                                
                                
								<tr>
						<td><spring:message code="label.isEMI"></spring:message></td>
								
									
									<td><form:select path="isEMI" id="isEMI"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:option value="true">Yes</form:option>
										<form:option value="false">No</form:option>
									</form:select></td>
									
									<td><spring:message code="label.noofInstallments"></spring:message></td>
								<td><form:input path="noofInstallments" id="noofInstallments" class="textbox" /></td>
									
								
							
                                </tr>
                                <tr>
						<td><spring:message code="label.sTDT"></spring:message></td>
								
									<td><form:input path="sTDT" id="sTDT" class="textbox" /></td>
									
									
								
							
                                </tr>
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${true}"><input type="submit"
									value="<spring:message
								code="label.save" />"
									class="btn btn-primary" id="subid" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose> <input type="reset"
									class="btn btn-primary"
									value="<spring:message
								code="label.reset" />" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="EmpAdvancevalues" items="${EmpAdvancevalues }">

						<form:form action="EmpAdvanceUpdate.mnt" method="POST"
							commandName="empAdvanceCommand" id="agreementUpdate">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="editEmpAdvanceDuplicate"
											items="${editEmpAdvanceDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="empAdvanceId"
									id="empAdvanceId" />
									<tr>
								<td colspan="2"><c:forEach var="addEmpAdvanceDuplicate"
										items="${addEmpAdvanceDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.empAdvance"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
						<td><spring:message code="label.loanType"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:select path="loanTypeId" id="loanTypeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${loanType }" />
									</form:select></td>
								<td><spring:message code="label.employee"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:select path="employeeId" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
                                </tr>
                           <tr>
							<td><spring:message code="label.advanceAmount"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="advanceAmount" id="advanceAmount" class="textbox" /></td>
                                  <td><spring:message code="label.currency"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="currencyId" id="currencyId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${currency }" />
									</form:select></td>
							</tr> 
								<tr>
						<td><spring:message code="label.repayAmountPM"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="repayAmountPM" id="repayAmountPM" class="textbox" /></td>
								<td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                </tr>
											<tr>
						<td><spring:message code="label.description"></spring:message></td>
								
								
								<td><form:input path="description" id="description" class="textbox" /></td>
								<td><spring:message code="label.payMode"></spring:message></td>
								<td><form:select path="payModeId" id="payModeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${payMode }" />
									</form:select></td>
								
							
                                </tr>
                                
                                		<tr>
						<td><spring:message code="label.bank"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="bankId" id="bankId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${bank }" />
									</form:select></td>
						<td><spring:message code="label.branch"></spring:message></td>
								
								
								<td><form:input path="branch" id="branch" class="textbox" /></td>
								
							
                                </tr>
								
								<tr>
						<td><spring:message code="label.isFixedAmount"></spring:message></td>
									<td><form:select path="isFixedAmount" id="isFixedAmount"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:option value="true">Yes</form:option>
										<form:option value="false">No</form:option>
									</form:select></td>
									
									
									<td><spring:message code="label.fixedAmount"></spring:message></td>
								<td><form:input path="fixedAmount" id="fixedAmount" class="textbox" /></td>
									
								
							
                                </tr>
                                
                                
                                
								<tr>
						<td><spring:message code="label.isEMI"></spring:message></td>
								
									
									<td><form:select path="isEMI" id="isEMI"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:option value="true">Yes</form:option>
										<form:option value="false">No</form:option>
									</form:select></td>
									
									<td><spring:message code="label.noofInstallments"></spring:message></td>
								<td><form:input path="noofInstallments" id="noofInstallments" class="textbox" /></td>
									
								
							
                                </tr>
                                <tr>
						<td><spring:message code="label.sTDT"></spring:message></td>
								
									<td><form:input path="sTDT" id="startDate" class="textbox" /></td>
									
									
								
							
                                </tr>
								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${true}"><input type="submit"
										value="<spring:message
								code="label.update" />"
										class="btn btn-primary" id="updateAgree" /></c:when>
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




