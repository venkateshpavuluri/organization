
<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 18-09-2013 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<script>
	$(function() {
		$("#tabs,#tab").tabs();
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
	$(function() {
		$('#basicSearch').click(function() {
			$("#advanceSearchHidden").val("0");
			$("#aslink").show();

			$('#mainSearch').show();
			$('#advanceSearchDiv').hide();
			$('#advanceSearch').show();
			$('#basicSearch').hide();
			
			return false;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$('#withHoldReason').val('');
			$('#withHoldAmount').val('');
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

		});
	});
</script>

<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumbnid')
								.click(
										function(event) {
											

											$("#paymentAdd")
													.validate(
															{
																rules : {
																	orgId : {
																		required : true
																	},
																	paymentMethodId : {
																		required : true
																	},
																	currecyId : {
																		required : true
																	},
																	
																	paymentNo : {
																		required : true
																	},
																	amount : {
																		required : true
																	},
																	paymentTypeId : {
																		required : true,
																	
																	},
																	
																	paymentStatus : {
																	
																		number:true
																	},
																	chequeIssuedBy : {
																
																		number:true
																	},
																	chequeClearanceStatus : {
																
																		number:true
																	},
																	postingDate : {
																		
																		required:true
																	},vendorId : {
																		required:true 
																		},withHoldReason : {
																			required:true
																		},withHoldAmount: {
																			required:true,
																			number:true
																		}

																	
																	

																},
																messages : {
																	orgId : "<font style='color: red;'><b>Organization  is Required</b></font>",
																	paymentMethodId : "<font style='color: red;'><b>paymentMethod is Required</b></font>",
																	currecyId : "<font style='color: red;'><b>currecy is Required</b></font>",
																	paymentNo : "<font style='color: red;'><b>Payment Number is Required</b></font>",
																	amount : "<font style='color: red;'><b>Amount is Required</b></font>",
																	paymentTypeId : "<font style='color: red;'><b>Payment Type is Required</b></font>",
																	chequeIssuedBy : "<font style='color: red;'><b>Cheque IssuedBy is Must Be Number</b></font>",
																	chequeClearanceStatus : "<font style='color: red;'><b>Cheque Clearance Status is Must Be Number</b></font>",
																	paymentStatus : "<font style='color: red;'><b>Payment Status is Must Be Number</b></font>",
																	postingDate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	vendorId : "<font style='color: red;'><b>Vendor is Required</b></font>",
																	withHoldReason: "<font style='color: red;'><b>With Hold Reason is Required</b></font>",
																	withHoldAmount: "<font style='color: red;'><b>With Hold Amount is Required and must be number</b></font>"

																},

															});
										});

						$('#updateId')
								.click(
										function(event) {

											$("#paymentUpForm")
													.validate(
															{
																rules : {
																	orgIdEdit : {
																		required : true
																	},
																	paymentMethodIdEdit : {
																		required : true
																	},
																	currecyIdEdit : {
																		required : true
																	},
																	
																	paymentNoEdit : {
																		required : true
																	},
																	amountEdit : {
																		required : true
																	},
																	paymentTypeIdEdit : {
																		required : true,
																		number:true
																		
																	},
																	
																	paymentStatusEdit : {
																	
																		number:true
																	},
																	chequeIssuedByEdit : {
																
																		number:true
																	},
																	chequeClearanceStatusEdit : {
																
																		number:true
																	},
																	postingDateEdit : {
							
																		required:true
																	},vendorIdEdit : {
																		
																		required:true
																	},withHoldReason: {
																		required:true
																	},withHoldAmount: {
																		required:true,
																		number:true
																	}
																	
																	
																},
																messages : {
																	orgIdEdit : "<font style='color: red;'><b>Organization  is Required</b></font>",
																	paymentMethodIdEdit : "<font style='color: red;'><b>Payment Method is Required</b></font>",

																	currecyIdEdit : "<font style='color: red;'><b>Currecy is Required</b></font>",
																	paymentNoEdit : "<font style='color: red;'><b>Payment Number is Required</b></font>",
																	
																	amountEdit : "<font style='color: red;'><b>Amount is Required</b></font>",
																	paymentTypeIdEdit : "<font style='color: red;'><b>Payment Type  is Required</b></font>",
																	paymentStatusEdit : "<font style='color: red;'><b>Payment Status is Required</b></font>",
																	chequeIssuedByEdit : "<font style='color: red;'><b>Cheque Issued By  is Required</b></font>",
																	chequeClearanceStatusEdit : "<font style='color: red;'><b>Cheque Clearance Status   is Required</b></font>",
																	postingDateEdit : "<font style='color: red;'><b>Posting Date  is Required</b></font>",
																	vendorIdEdit : "<font style='color: red;'><b>Vendor  is Required</b></font>",
																		withHoldReason : "<font style='color: red;'><b>With Hold Reason  is Required</b></font>",
																		withHoldAmount : "<font style='color: red;'><b>With Hold Amount is Required and must be number</b></font>"
																	
																},

															});
										});
					});
</script>
<!--  Date picker -->
<script type="text/javascript">
function dateFun(datePattern) {
	$("#tabs,#tab").tabs();
	$('#chequeClearanceDate,#chequeIssuedDate,#postingDate,#chequeDate,#chequeClearanceDateEdit,#chequeIssuedDateEdit,#postingDateEdit,#chequeDateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>
<!-- <script >
$(function() {
	$("#chequeClearanceDate,#chequeIssuedDate,#postingDate,#chequeDate").datepicker();
	$("#chequeClearanceDateEdit,#chequeIssuedDateEdit,#postingDateEdit,#chequeDateEdit").datepicker();
	
});
</script> --> 

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

		});
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


</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Payment</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${paymentEditValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<!-- ============================================Begin OrganizationSearch=================================================================================================== -->
					<form:form action="paymentSearch.mnt" method="get"
						commandName="paymentForm">

						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach var="paymentUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.payment"/> <spring:message code="label.saveSuccess"/> 
										</div>
									</c:forEach><c:forEach var="paymentUpdateError"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.payment"/> <spring:message code="label.saveFail"/> 
										</div>
									</c:forEach>
									
									<c:forEach
										items="${paymentUpdate}">
										
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.payment"/> <spring:message code="label.updateSuccess"/> 
										</div>
									</c:forEach>
									
									
									<c:forEach 
										items="${paymentUpdateError}">
										
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.payment"/> <spring:message code="label.updateFail"/> 
										</div>
									</c:forEach>
									
									<c:forEach
										items="${paymentDelete}">
										
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.payment"/> <spring:message code="label.deleteSuccess"/> 
										</div>
									</c:forEach>
									
										<c:forEach 
										items="${paymentDeleteError}">
										
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.payment"/> <spring:message code="label.deleteFail"/> 
										</div>
									</c:forEach>
									
									</td>

							</tr>
						
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" />
								<form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="paymentForm.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
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
										<c:when test="${privileges eq messageup }">
										<c:set var="update" value="true"></c:set>
										</c:when>
										</c:choose>
								</c:forEach>
								
								
								
								<td>
								<c:choose>
								<c:when test="${true }">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" />
									</c:otherwise>
									
								</c:choose></td>
							</tr>
							
							<form:form action="paymentAdvanceSearch.mnt" method="get"
							commandName="organization" name="advanceSearchFinal" id="advanceSearchFinal">
							<tr>
								<td>
									<a href="paymentAdvanceSearch.mnt"><font
										style="color: blue" id="aslink"><u><b>Advanced Search</b></u></font></a>
										<a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							
							</tr>
						</form:form>
						</table>
						<form:form action="paymentdvanceSearchOperations.mnt"
						commandName="paymentForm">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${paymentSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label><form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><spring:bind path="paymentForm.operations1">
								<select class="select" name="operations1">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> </td>
										<td><form:input path="advanceSearchText"
												id="advanceSearchkk" cssClass="textbox" /></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3">
									
									<c:choose>
									<c:when test="${search }">
									
									
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
					</form:form>
					<!-- ============================================End OrganizationSearch=================================================================================================== -->
					<c:forEach var="paymentSearch" items="${paymentSearch}">
						<c:set var="g" value="${paymentSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<!-- ============================================Begin OrgDisplayTable=================================================================================================== -->
						<display:table id="paymentRow" name="paymentSearch"
							requestURI="paymentSearch.mnt" pagesize="5" class="table">
							<display:column property="paymentNo"
								titleKey="label.paymentNo" media="html" sortable="true"></display:column>
							
							<display:column property="amount" titleKey="label.amount"
								media="html" sortable="true" />
							<display:column property="accountNo" titleKey="label.accountNo"
								media="html" sortable="true" />
							<display:column property="bankName" titleKey="label.bank"
								media="html" sortable="true" />
							
							<display:column property="vendorName" titleKey="label.vendor"
								sortable="true" />
							
							
							<display:column property="postingDate" titleKey="label.postingDate"
								sortable="true" />
							
							
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
							
							
								<a
									href="paymentEditHome.mnt?paymentEdit=<c:out value="${paymentRow.paymentId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
									height="20px" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${true }">
							
							
								<a
									href="paymentDelete.mnt?paymentCodeDelete=<c:out value="${paymentRow.paymentId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
									<c:otherwise>
									<a><img
									src="images/Delete.jpg" width="20px" height="20px" class="btn btn-danger" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

							<display:setProperty name="paging.banner.group_size" value="3" />

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>
					</c:if>

				</div>
			</div>
			<!-- ============================================End OrgDisplayTable=================================================================================================== -->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table class="tableGeneral">
			<!-- ============================================Begin Organization Add=================================================================================================== -->
						<tr>
							<td colspan="2"><c:forEach var="duplicatei"
									items="${duplicate}">
									<div class="alert-warning">
										<strong><spring:message code="label.warning"/> </strong>
										<spring:message code="label.paymentNo"/> <spring:message code="label.duplicateCheck"/>
									
									</div>
								</c:forEach></td>
						</tr>
					</table>
					<form:form action="paymentAdd.mnt" method="POST"
						commandName="paymentForm" id="paymentAdd">

						<table>
							<form:hidden path="aid" />
							
							<tr>
								<td><spring:message code="label.organizationName"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="orgId" cssClass="select">
								<form:option value="">--Select--</form:option>
								<form:options items="${orgDetails}" />
								</form:select>
								</td>
								<td></td>
								<td><spring:message code="label.paymentNo"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="paymentNo" id="PaymentNo" class="textbox" maxlength="50"/></td>
								
							</tr>
							<tr>
								<td><spring:message code="label.bank"></spring:message></td>
							
								<td><form:select path="bankId" id="bankId" cssClass="select">
								<form:option value="0">--Select--</form:option>
								<form:options items="${bankDetails }" />
								</form:select></td>
								<td></td>
								<td><spring:message code="label.accountNo"></spring:message></td>
								<td><form:input path="accountNo" id="AccountNo" class="textbox" maxlength="50"/></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.currency"></spring:message><font
									color="red">*</font></td>
							
								<td><form:select path="currecyId" id="currecyId" cssClass="select">
								<form:option value="">--Select--</form:option>
								<form:options items="${currencyDetails }" />
								
								</form:select></td>
								<td></td>
								<td><spring:message code="label.paymentMethod"></spring:message><font
									color="red">*</font> </td>
								<td><form:select path="paymentMethodId" cssClass="select">
								<form:option value="">--Select--</form:option>
								<form:options items="${paymentMethodDetails }" />
								</form:select></td>
								
								
							</tr>
							<tr>
								<td><spring:message code="label.amount"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="amount" id="amount" class="textbox" /></td>
								<td></td>
								<td><spring:message code="label.vendor"></spring:message><font
									color="red">*</font></td><td>
									<form:select path="vendorId" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options  items="${vendorDetails}"/>
									</form:select>
									</td>
							</tr>
							<tr>
						<td><spring:message code="label.paymentType"></spring:message><font
									color="red">*</font></td>
							<td><form:select path="paymentTypeId" id="paymentTypeId"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${paymentTypeDetails}" />
									</form:select></td>
									<td></td>
								<td><spring:message code="label.vendorInvoice"></spring:message></td>
								<td><form:select path="vendorInvoiceId" id="vendorInvoiceId"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${vendorInvoiceDetails}" />
									</form:select></td>
									
									
							</tr>
							<tr>
								
								
								
							</tr>
							<tr>
								<td><spring:message code="label.chequeNo"></spring:message></td>
								<td><form:input path="chequeNo" id="chequeNo" class="textbox" maxlength="50"/></td>
								<td></td>
								<td><spring:message code="label.chequeDate"></spring:message></td>
								<td><form:input path="chequeDate" id="chequeDate" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.paymentStatus"></spring:message></td>
								<td><form:input path="paymentStatus" id="paymentStatus" class="textbox" /></td>
								<td></td>
								<td><spring:message code="label.description"></spring:message></td>
								<td><form:textarea path="description" id="description" class="textbox" maxlength="500"/></td>
							</tr>

							<tr>
								<td><spring:message code="label.chequeIssuedBy"></spring:message></td>
									<td><form:input path="chequeIssuedBy" id="chequeIssuedBy" class="textbox" /></td>
									<td></td>
							<td><spring:message code="label.chequeIssuedDate"></spring:message></td>
									<td><form:input path="chequeIssuedDate" id="chequeIssuedDate" class="textbox" /></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.chequeClearanceStatus"></spring:message></td>
									<td><form:input path="chequeClearanceStatus" id="chequeClearanceStatus" class="textbox" /></td>
									<td></td>
							<td><spring:message code="label.chequeClearanceDate"></spring:message></td>
									<td><form:input path="chequeClearanceDate" id="chequeClearanceDate" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.postingDate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="postingDate" id="postingDate" class="textbox" /></td>
							</tr>
							
							
							<%-- <tr>
								<td><input type="submit"
									value='<spring:message code="label.save"/>' class="btn btn-primary"
									id="sumbnid" /> <input type="reset"
									value='<spring:message code="label.reset"/>' class="btn btn-primary" /></td>
							</tr> --%>
						</table>
				
						
							<div id="tab" align="left">
							<ul>
								<li><a href="#tab1"><spring:message code="label.paymentHold" /></a></li>
							</ul>

							<div id="tab1">
								<div align="left">
									<table>

										<tr>
											<td><spring:message code="label.withholdReason" /><span
												class="required">*</span></td>
											<td><form:input path="withHoldReason" class="textbox"
													id="withHoldReason" /></td>

										</tr>
										<tr>
											<td><spring:message code="label.withholdAmount" /><span
												class="required">*</span></td>
											<td><form:input path="withHoldAmount" class="textbox"
													id="withHoldAmount" /></td>

										</tr>
									</table>


								</div>

							</div>

						</div>
						
						
						<table>
							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${true}">
								<input type="submit"
									value="<spring:message code="label.save"/>" id="sumbnid"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>" id="sumbnid"
									class="btn btn-danger" />
									</c:otherwise>
									</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
					<!-- ============================================End OrganizationAdd=================================================================================================== -->


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
				 <!-- ============================================Begin organizationUpdate=================================================================================================== -->
					<c:forEach var="paymentEditValues" items="${paymentEditValues }">
						<form:form action="paymentUpdate.mnt" method="POST"
						commandName="paymentForm" id="paymentUpForm">

						<table>
						<tr>
							<td colspan="2"><c:forEach var="duplicatei"
									items="${paymentUpdateDuplicate}">
									<div class="alert-warning">
											<strong><spring:message code="label.warning"/> </strong>
										<spring:message code="label.paymentNo"/> <spring:message code="label.duplicateCheck"/>
									
									</div>
								</c:forEach></td>
						</tr>
							<form:hidden path="aid" />
							<form:hidden path="paymentId" />
							<tr>
								<td><spring:message code="label.organizationName"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="orgIdEdit" id="orgIdEdit" cssClass="select">
									<form:option value="">--Select--</form:option>
								<form:options items="${orgDetails}" />
							
								</form:select>
								</td>
									<td></td>
								<td><spring:message code="label.paymentNo"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="paymentNoEdit" id="PaymentNoEdit" class="textbox" /></td>
								
								
							</tr>
							<tr>
								<td><spring:message code="label.bank"></spring:message></td>
							
								<td><form:select path="bankIdEdit" id="bankIdEdit" cssClass="select">
								<form:option value="">--Select--</form:option>
								<form:options items="${bankDetails }" />
								</form:select></td>
									<td></td>
								<td><spring:message code="label.accountNo"></spring:message></td>
								<td><form:input path="accountNoEdit" id="AccountNoEdit" class="textbox" maxlength="50"/></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.currency"></spring:message><font
									color="red">*</font></td>
							
								<td><form:select path="currecyIdEdit" id="currecyIdEdit" cssClass="select">
								<form:option value="">--Select--</form:option>
								<form:options items="${currencyDetails }" />
								
								</form:select></td>
									<td></td>
								<td><spring:message code="label.paymentMethod"></spring:message><font
									color="red">*</font> </td>
								<td><form:select path="paymentMethodIdEdit" id="paymentMethodIdEdit" cssClass="select">
									<form:option value="">--Select--</form:option>
								<form:options items="${paymentMethodDetails }" />
							
								</form:select></td>
							
								
								
							</tr>
							<tr>
								<td><spring:message code="label.amount"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="amountEdit" id="amountEdit" class="textbox" /></td>
									<td></td>
								<td><spring:message code="label.vendor"></spring:message><font
									color="red">*</font></td><td>
									<form:select path="vendorIdEdit" id="vendorIdEdit" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options  items="${vendorDetails}"/>
									</form:select>
									</td>
									
								<td></td>
							</tr>
							<tr>
							
								<td><spring:message code="label.paymentType"></spring:message><font
									color="red">*</font></td>
							<td><form:select path="paymentTypeIdEdit" id="paymentTypeIdEdit"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${paymentTypeDetails}" />
									</form:select></td>
							
										<td></td>
								<td><spring:message code="label.vendorInvoice"></spring:message></td>
								<td><form:select path="vendorInvoiceIdEdit" id="vendorInvoiceIdEdit"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${vendorInvoiceDetails}" />
									</form:select></td>
									
									
							</tr>
						
							<tr>
								<td><spring:message code="label.chequeNo"></spring:message></td>
								<td><form:input path="chequeNoEdit" id="chequeNoEdit" class="textbox" maxlength="50"/></td>
									<td></td>
								<td><spring:message code="label.chequeDate"></spring:message></td>
								<td><form:input path="chequeDateEdit" id="chequeDateEdit" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.paymentStatus"></spring:message></td>
								<td><form:input path="paymentStatusEdit" id="paymentStatusEdit" class="textbox" /></td>
									<td></td>
								<td><spring:message code="label.description"></spring:message></td>
								<td><form:textarea path="descriptionEdit" id="descriptionEdit" class="textbox" maxlength="250"/></td>
</tr>


							<tr>
								<td><spring:message code="label.chequeIssuedBy"></spring:message></td>
									<td><form:input path="chequeIssuedByEdit" id="chequeIssuedByEdit" class="textbox" /></td>
										<td></td>
							<td><spring:message code="label.chequeIssuedDate"></spring:message></td>
									<td><form:input path="chequeIssuedDateEdit" id="chequeIssuedDateEdit" class="textbox" /></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.chequeClearanceStatus"></spring:message></td>
									<td><form:input path="chequeClearanceStatusEdit" id="chequeClearanceStatusEdit" class="textbox" /></td>
										<td></td>
							<td><spring:message code="label.chequeClearanceDate"></spring:message></td>
									<td><form:input path="chequeClearanceDateEdit" id="chequeClearanceDateEdit" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.postingDate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="postingDateEdit" id="postingDateEdit" class="textbox" /></td>
							</tr>
							
							
						<%-- 	<tr>
								<td><input type="submit"
									value='<spring:message code="label.update"/>' class="btn btn-primary"
									id="updateId" /> <input type="reset"
									value='<spring:message code="label.reset"/>' class="btn btn-primary" /></td>
							</tr> --%>
						</table>
						
						
						
						<div id="tab" align="left">
							<ul>
								<li><a href="#tab1"><spring:message code="label.paymentHold" /></a></li>
							</ul>

							<div id="tab1">
								<div align="left">
									<table>

										<tr>
											<td><spring:message code="label.withholdReason" /><span
												class="required">*</span></td>
											<td><form:input path="withHoldReason" class="textbox"
													id="withHoldReasonj" /></td>

										</tr>
										<tr>
										<form:hidden path="paymentwithholdid" />
											<td><spring:message code="label.withholdAmount" /><span
												class="required">*</span></td>
											<td><form:input path="withHoldAmount" class="textbox"
													id="withHoldAmountj" /></td>

										</tr>
									</table>


								</div>

							</div>

						</div>
						
						
						<table>
							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${true }">
								<input type="submit"
									value="<spring:message code="label.update"/>" id="updateId"
									class="btn btn-primary" /></c:when>
									
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.update"/>" id="updateId"
									class="btn btn-danger" />
									</c:otherwise>
									</c:choose>
									
									</td>
							</tr>
						</table>
						
					</form:form>
						<!-- ============================================End organizationEdit=================================================================================================== -->

					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




