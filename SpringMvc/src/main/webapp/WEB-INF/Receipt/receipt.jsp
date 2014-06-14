<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'receipt.jsp' starting page</title>
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
<script type="text/javascript" src="js/MntValidator.js"></script>


<!--  Date picker -->
<script type="text/javascript">
function dateFun(datePattern) {
	$("#tabs,#tab").tabs();
	$('#postingDate,#chequeDate,#postingDateEdit,#chequeDateEdit,#chequeClearanceDate,#chequeClearanceDateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>
<!-- <script type="text/javascript">
	$(function() {
		$("#tabs,#tab").tabs();
		$(
				'#postingDate,#chequeDate,#postingDateEdit,#chequeDateEdit,#chequeClearanceDate,#chequeClearanceDateEdit')
				.datepicker({
					changeMonth : true,
					changeYear : true,
					dateFormat : "yy-mm-dd"

				});
	});
</script> -->

<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}

#error {
	color: red;
	font-style: Bold;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {

											$('#addForm')
													.validate(
															{
																rules : {
																	receiptNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	orgId : {
																		required : true
																	},
																	paymentTypeId : {
																		required : true

																	},
																	paymentMethodId : {
																		required : true
																	},
																	custId : {
																		required : true
																	},
																	custInvoiceId : {
																		required : true
																	},
																	currencyId : {
																		required : true
																	},
																	bankId : {
																		required : true
																	},
																	receiptStatus : {
																		required : true
																	},
																	chequeClearanceStatus : {
																		required : true
																	},
																	accNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	chequeNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	amount : {
																		required : true,
																		number : true
																	},
																	chequeDate : {
																		required : true
																	},
																	postingDate : {
																		required : true
																	},
																	chequeClearanceDate : {
																		required : true
																	},
																	desc : {
																		required : true
																	},
																	withHoldReason : {
																		required : true
																	},
																	withHoldAmount : {
																		required : true,
																		number : true
																	}

																},
																/*  errorPlacement :function(error){
																	return false;
																}, */
																messages : {
																	receiptNo : {
																		required:"<font style='color: red;'><b>Receipt No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	orgId : "<font style='color: red;'><b>Organization is Required</b></font>",
																	paymentTypeId : "<font style='color: red;'><b>Payment Type is Required</b></font>",
																	paymentMethodId : "<font style='color: red;'><b>Payment Method is Required</b></font>",
																	custId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	custInvoiceId : "<font style='color: red;'><b>Customer Invoice is Required</b></font>",
																	currencyId : "<font style='color: red;'><b>Currency is Required</b></font>",
																	bankId : "<font style='color: red;'><b>Bank is Required</b></font>",
																	receiptStatus : "<font style='color: red;'><b>Receipt Status is Required</b></font>",
																	chequeClearanceStatus : "<font style='color: red;'><b>Cheque Clearance Status is Required</b></font>",
																	accNo : {
																		required:"<font style='color: red;'><b>Account No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	chequeNo : {
																		required:"<font style='color: red;'><b>Cheque No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	amount : {
																		required:"<font style='color: red;'><b>Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>Amount Allows Only Numbers</b></font>"
																	},
																	chequeDate : "<font style='color: red;'><b>Cheque Date is Required</b></font>",
																	postingDate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	chequeClearanceDate : "<font style='color: red;'><b>Cheque Clearance Date is Required</b></font>",
																	desc : "<font style='color: red;'><b>Description is Required</b></font>",
																	withHoldReason : "<font style='color: red;'><b>With Hold Reason is Required</b></font>",
																	withHoldAmount : {
																		required:"<font style='color: red;'><b>With Hold Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>With Hold Amount Allows Only Numbers</b></font>"
																	}
																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											$('#editForm')
													.validate(
															{
																rules : {
																	receiptNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	orgId : {
																		required : true
																	},
																	paymentTypeId : {
																		required : true

																	},
																	paymentMethodId : {
																		required : true
																	},
																	custId : {
																		required : true
																	},
																	custInvoiceId : {
																		required : true
																	},
																	currencyId : {
																		required : true
																	},
																	bankId : {
																		required : true
																	},
																	receiptStatus : {
																		required : true
																	},
																	chequeClearanceStatus : {
																		required : true
																	},
																	accNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	chequeNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	amount : {
																		required : true,
																		number : true
																	},
																	chequeDate : {
																		required : true
																	},
																	postingDate : {
																		required : true
																	},
																	chequeClearanceDate : {
																		required : true
																	},
																	desc : {
																		required : true
																	},
																	withHoldReason : {
																		required : true
																	},
																	withHoldAmount : {
																		required : true,
																		number : true
																	}

																},
																messages : {
																	receiptNo : {
																		required:"<font style='color: red;'><b>Receipt No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	orgId : "<font style='color: red;'><b>Organization is Required</b></font>",
																	paymentTypeId : "<font style='color: red;'><b>Payment Type is Required</b></font>",
																	paymentMethodId : "<font style='color: red;'><b>Payment Method is Required</b></font>",
																	custId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	custInvoiceId : "<font style='color: red;'><b>Customer Invoice is Required</b></font>",
																	currencyId : "<font style='color: red;'><b>Currency is Required</b></font>",
																	bankId : "<font style='color: red;'><b>Bank is Required</b></font>",
																	receiptStatus : "<font style='color: red;'><b>Receipt Status is Required</b></font>",
																	chequeClearanceStatus : "<font style='color: red;'><b>Cheque Clearance Status is Required</b></font>",
																	accNo : {
																		required:"<font style='color: red;'><b>Account No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	chequeNo :{
																		required:"<font style='color: red;'><b>Cheque No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	amount : {
																		required:"<font style='color: red;'><b>Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>Amount Allows Only Numbers</b></font>"
																	},
																	chequeDate : "<font style='color: red;'><b>Cheque Date is Required</b></font>",
																	postingDate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	chequeClearanceDate : "<font style='color: red;'><b>Cheque Clearance Date is Required</b></font>",
																	desc : "<font style='color: red;'><b>Description is Required</b></font>",
																	withHoldReason : "<font style='color: red;'><b>With Hold Reason is Required</b></font>",
																	withHoldAmount :{
																		required:"<font style='color: red;'><b>With Hold Amount is Required</b></font>",
																		number:"<font style='color: red;'><b>With Hold Amount Allows Only Numbers</b></font>"
																	} 
																},
															});

										});

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function() {
			$('#basicSearchId').focus();
			$('#receiptNo').focus();
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#receiptNo').val('');
			$('#orgId').val('');
			$('#paymentTypeId').val('');
			$('#paymentMethodId').val('');
			$('#custId').val('');
			$('#custInvoiceId').val('');
			$('#currencyId').val('');
			$('#bankId').val('');
			$('#receiptStatus').val('');
			$('#accNo').val('');
			$('#chequeNo').val('');
			$('#amount').val('');
			$('#chequeDate').val('');
			$('#postingDate').val('');
			$('#chequeClearanceStatus').val('');
			$('#chequeClearanceDate').val('');
			$('#desc').val('');
			$('#withHoldReason').val('');
			$('#withHoldAmount').val('');

		});
	});
</script>
<script type="text/javascript">
	function AjaxForDuplicate() {
		var recNo = $('#receiptNo').val();
		//alert(recNo);

		$
				.ajax({
					type : "POST",
					url : "checkReceiptAddDuplicate.mnt",
					data : "receiptNo=" + recNo,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesDuplMessage").style.display = "block";
							//$('#salesDuplMessage').html(response);
							$('#submitid').hide();

						} else {
							document.getElementById("salesDuplMessage").style.display = "none";
							$('#submitid').show();
						}

					},
					error : function(e) {
						//alert('Error' + e);
					}

				});

	}

	function AjaxUpdateDuplicate() {
		var cust = $('#receiptNoEdit').val();
		var id = $('#receiptIdEdit').val();
		//alert(cust);

		$
				.ajax({
					type : "POST",
					url : "checkReceiptUpdateDuplicate.mnt",
					data : "receiptNo=" + cust + "&receiptId=" + id,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesUpDuplMessage").style.display = "block";
							//$('#salesUpDuplMessage').html(response);
							$('#updateid').hide();

						} else {
							document.getElementById("salesUpDuplMessage").style.display = "none";
							$('#updateid').show();
						}

					},
					error : function(e) {
						//alert('Error' + e);
					}

				});

	}
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Receipt</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="receiptEdit" items="${receiptEdit}">
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
					<form:form method="get" action="receiptSearch.mnt"
						commandName="receiptCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addRecsus"
										items="${param.addRecsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.receipt" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addRecFail"
										items="${param.addRecFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.receipt" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateRecssus"
										items="${param.updateRecssus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.receipt" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="updateRecFail"
										items="${param.updateRecFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.receipt" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteRecsus"
										items="${param.DeleteRecsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.receipt" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteRecFail"
										items="${param.DeleteRecFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.receipt" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="receiptCmd.operations">
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
									</spring:bind> <form:input path="basicSearchId" id="basicSearchId" cssClass="textbox" /></td>
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

								<c:choose>
									<c:when test="${true}">
										<td><input type="submit"
											value="<spring:message code="label.search"/>"
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" disabled="disabled"
											value="<spring:message code="label.search"/>"
											class="btn btn-danger" /></td>
									</c:otherwise>
								</c:choose>
							</tr>

						</table>
					</form:form>

					<c:if test="${receiptList!=null }">
						<display:table name="receiptList" id="receiptIDList" class="table"
							requestURI="receiptSearch.mnt" pagesize="5">
							<display:column property="receiptId" sortable="true"
								title="receiptId" media="none" />

							<display:column property="receiptNo" sortable="true"
								titleKey="label.recno" media="html" />
							<display:column property="orgId" sortable="true"
								titleKey="label.recorg" media="html" />

							<display:column property="paymentMethodId" sortable="true"
								titleKey="label.recpm" media="html" />

							<display:column property="paymentTypeId" sortable="true"
								titleKey="label.recpt" media="html" />

							<display:column property="currencyId" sortable="true"
								titleKey="label.reccur" media="html" />

							<display:column property="custId" sortable="true"
								titleKey="label.reccust" media="html" />

							<display:column property="custInvoiceId" sortable="true"
								titleKey="label.reccustinv" media="html" />

							<display:column property="bankId" sortable="true"
								titleKey="label.recbank" media="html" />

							<display:column property="receiptStatus" sortable="true"
								titleKey="label.recst" media="html" />

							<display:column property="accNo" sortable="true"
								titleKey="label.recaccno" media="html" />
							<display:column property="chequeNo" sortable="true"
								titleKey="label.reccheque" media="html" />
							<display:column property="chequeDate" sortable="true"
								titleKey="label.recchedate" media="html" />
							<display:column property="postingDate" sortable="true"
								titleKey="label.recpd" media="html" />
							<display:column property="amount" sortable="true"
								titleKey="label.recamt" media="html" />

							<display:column property="chequeIssuedDate" sortable="true"
								title="Cheque Issued Date" media="none" />
							<display:column property="chequeClearanceDate" sortable="true"
								titleKey="label.recchcldt" media="none" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${true}">
										<a
											href="receiptEdit.mnt?receiptId=<c:out value="${receiptIDList.receiptId}"/> "><img
											src="images/Edit.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${true}">
										<a
											href="receiptDelete.mnt?receiptId=<c:out value="${receiptIDList.receiptId}"/> "
											onclick="return confirm('Do You Want To Delete This Record?')"><img
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
						</display:table>

					</c:if>

				</div>

			</div>

			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="salesDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.recno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="receiptAdd.mnt" id="addForm" method="POST"
						commandName="receiptCmd">
						<table class="tableGeneral">
							<tr>
								<td><spring:message code="label.recno" /><span
									class="required">*</span></td>
								<td><form:input path="receiptNo" class="textbox"
										id="receiptNo" maxlength="50" onkeyup="AjaxForDuplicate()" /></td>

								<td><spring:message code="label.recorg" /><span
									class="required">*</span></td>
								<td><form:select path="orgId" class="select" id="orgId">
										<form:option value="">-Select-</form:option>
										<form:options items="${orgSelect}" />
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.recaccno" /><span
									class="required">*</span></td>
								<td><form:input path="accNo" class="textbox" id="accNo"
										maxlength="50" /></td>

								<td><spring:message code="label.recpt" /><span
									class="required">*</span></td>
								<td><form:select path="paymentTypeId" class="select"
										id="paymentTypeId">
										<form:option value="">-Select-</form:option>
										<form:options items="${paymentTypeSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.reccheque" /><span
									class="required">*</span></td>
								<td><form:input path="chequeNo" class="textbox"
										id="chequeNo" maxlength="50"/></td>

								<td><spring:message code="label.recpm" /><span
									class="required">*</span></td>
								<td><form:select path="paymentMethodId" class="select"
										id="paymentMethodId">
										<form:option value="">-Select-</form:option>
										<form:options items="${paymentMethodSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.recamt" /><span
									class="required">*</span></td>
								<td><form:input path="amount" class="textbox" id="amount" maxlength="21"/></td>

								<td><spring:message code="label.reccust" /><span
									class="required">*</span></td>
								<td><form:select path="custId" class="select" id="custId">
										<form:option value="">-Select-</form:option>
										<form:options items="${custSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.recchedate" /><span
									class="required">*</span></td>
								<td><form:input path="chequeDate" class="textbox"
										id="chequeDate" /></td>
								<td><spring:message code="label.reccustinv" /><span
									class="required">*</span></td>
								<td><form:select path="custInvoiceId" class="select"
										id="custInvoiceId">
										<form:option value="">-Select-</form:option>
										<form:options items="${custInvoiceSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.recpd" /><span
									class="required">*</span></td>
								<td><form:input path="postingDate" class="textbox"
										id="postingDate" /></td>

								<td><spring:message code="label.reccur" /><span
									class="required">*</span></td>
								<td><form:select path="currencyId" class="select"
										id="currencyId">
										<form:option value="">-Select-</form:option>
										<form:options items="${currencySelect}" />
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.recchcldt" /><span
									class="required">*</span></td>
								<td><form:input path="chequeClearanceDate" class="textbox"
										id="chequeClearanceDate" /></td>

								<td><spring:message code="label.recbank" /><span
									class="required">*</span></td>
								<td><form:select path="bankId" class="select" id="bankId">
										<form:option value="">-Select-</form:option>
										<form:options items="${bankSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.recdesc" /><span
									class="required">*</span></td>
								<td><form:textarea path="desc" class="textbox" id="desc"
										maxlength="250" /></td>

								<td><spring:message code="label.recst" /><span
									class="required">*</span></td>
								<td><form:select path="receiptStatus" class="select"
										id="receiptStatus">
										<form:option value="">-Select-</form:option>
										<form:options items="${statusSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.recchcl" /><span
									class="required">*</span></td>
								<td><form:select path="chequeClearanceStatus"
										class="select" id="chequeClearanceStatus">
										<form:option value="">-Select-</form:option>
										<form:options items="${statusSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>

						<div id="tab" align="left">
							<ul>
								<li><a href="#tab1"><spring:message code="label.recwh" /></a></li>
							</ul>

							<div id="tab1">
								<div align="left">
									<table>

										<tr>
											<td><spring:message code="label.rechrea" /><span
												class="required">*</span></td>
											<td><form:input path="withHoldReason" class="textbox"
													id="withHoldReason" /></td>

										</tr>
										<tr>
											<td><spring:message code="label.rechamt" /><span
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
								<c:choose>
									<c:when test="${true}">
										<td><input type="submit" id="subtnId"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="subtnId" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</table>
					</form:form>

				</div>

			</div>

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="salesUpDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.recno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<c:forEach var="receiptEdit" items="${receiptEdit}">

						<form:form method="post" action="receiptUpdate.mnt"
							commandName="receiptCmd" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="receiptId" id="receiptIdEdit" />
								<form:hidden path="chequeIssuedBy" />
								<form:hidden path="chequeIssuedDate" />
								<tr>
									<td><spring:message code="label.recno" /><span
										class="required">*</span></td>
									<td><form:input path="receiptNo" class="textbox"
											id="receiptNoEdit" maxlength="50"
											onkeyup="AjaxUpdateDuplicate()" /></td>

									<td><spring:message code="label.recorg" /><span
										class="required">*</span></td>
									<td><form:select path="orgId" class="select" id="orgId">
											<form:option value="">-Select-</form:option>
											<form:options items="${orgSelect}" />
										</form:select></td>
								</tr>

								<tr>
									<td><spring:message code="label.recaccno" /><span
										class="required">*</span></td>
									<td><form:input path="accNo" class="textbox" id="accNo"
											maxlength="50" /></td>

									<td><spring:message code="label.recpt" /><span
										class="required">*</span></td>
									<td><form:select path="paymentTypeId" class="select"
											id="paymentTypeId">
											<form:option value="">-Select-</form:option>
											<form:options items="${paymentTypeSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.reccheque" /><span
										class="required">*</span></td>
									<td><form:input path="chequeNo" class="textbox"
											id="chequeNo" maxlength="50"/></td>

									<td><spring:message code="label.recpm" /><span
										class="required">*</span></td>
									<td><form:select path="paymentMethodId" class="select"
											id="paymentMethodId">
											<form:option value="">-Select-</form:option>
											<form:options items="${paymentMethodSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.recamt" /><span
										class="required">*</span></td>
									<td><form:input path="amount" class="textbox" id="amount" maxlength="21"/></td>

									<td><spring:message code="label.reccust" /><span
										class="required">*</span></td>
									<td><form:select path="custId" class="select" id="custId">
											<form:option value="">-Select-</form:option>
											<form:options items="${custSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.recchedate" /><span
										class="required">*</span></td>
									<td><form:input path="chequeDate" class="textbox"
											id="chequeDateEdit" /></td>
									<td><spring:message code="label.reccustinv" /><span
										class="required">*</span></td>
									<td><form:select path="custInvoiceId" class="select"
											id="custInvoiceId">
											<form:option value="">-Select-</form:option>
											<form:options items="${custInvoiceSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.recpd" /><span
										class="required">*</span></td>
									<td><form:input path="postingDate" class="textbox"
											id="postingDateEdit" /></td>

									<td><spring:message code="label.reccur" /><span
										class="required">*</span></td>
									<td><form:select path="currencyId" class="select"
											id="currencyId">
											<form:option value="">-Select-</form:option>
											<form:options items="${currencySelect}" />
										</form:select></td>

								</tr>

								<tr>
									<td><spring:message code="label.recchcldt" /><span
										class="required">*</span></td>
									<td><form:input path="chequeClearanceDate" class="textbox"
											id="chequeClearanceDateEdit" /></td>

									<td><spring:message code="label.recbank" /><span
										class="required">*</span></td>
									<td><form:select path="bankId" class="select" id="bankId">
											<form:option value="">-Select-</form:option>
											<form:options items="${bankSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.recdesc" /><span
										class="required">*</span></td>
									<td><form:textarea path="desc" class="textbox" id="desc"
											maxlength="250" /></td>

									<td><spring:message code="label.recst" /><span
										class="required">*</span></td>
									<td><form:select path="receiptStatus" class="select"
											id="receiptStatus">
											<form:option value="">-Select-</form:option>
											<form:options items="${statusSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.recchcl" /><span
										class="required">*</span></td>
									<td><form:select path="chequeClearanceStatus"
											class="select" id="chequeClearanceStatus">
											<form:option value="">-Select-</form:option>
											<form:options items="${statusSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td></td>
								</tr>
								<tr>
									<td></td>
								</tr>

							</table>


							<div id="tab" align="left">
								<ul>
									<li><a href="#tab1"><spring:message code="label.recwh" /></a></li>
								</ul>

								<div id="tab1">
									<div align="left">
										<table>
											<c:forEach var="rwHold" items="${recHold}">
												<c:set var="Hold" value="${rwHold}"></c:set>
											</c:forEach>
											<c:choose>
												<c:when test="${Hold!=null}">
													<spring:bind path="receiptCmd.recWithHoldId">
														<input type="hidden" name="recWithHoldId"
															value="${Hold.recWithHoldId}" />
													</spring:bind>
													<tr>
														<td><spring:message code="label.rechrea" /><span
															class="required">*</span></td>
														<td><spring:bind path="receiptCmd.withHoldReason">
																<input type="text" name="withHoldReason"
																	value="${Hold.withHoldReason}" class="textbox" />
															</spring:bind></td>

													</tr>
													<tr>
														<td><spring:message code="label.rechamt" /><span
															class="required">*</span></td>
														<td><spring:bind path="receiptCmd.withHoldAmount">
																<input type="text" name="withHoldAmount"
																	value="${Hold.withHoldAmount}" class="textbox" />
															</spring:bind></td>

													</tr>
												</c:when>
												<c:otherwise>

													<tr>
														<td><spring:message code="label.rechrea" /><span
															class="required">*</span></td>
														<td><form:input path="withHoldReason" class="textbox"
																id="withHoldReason" /></td>

													</tr>
													<tr>
														<td><spring:message code="label.rechamt" /><span
															class="required">*</span></td>
														<td><form:input path="withHoldAmount" class="textbox"
																id="withHoldAmount" /></td>

													</tr>

												</c:otherwise>
											</c:choose>

										</table>

									</div>

								</div>

							</div>
							<table>

								<tr>

									<c:choose>

										<c:when test="${true}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updated" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updated" /></td>
										</c:otherwise>
									</c:choose>

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
