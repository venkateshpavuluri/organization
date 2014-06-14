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
<title>My JSP 'productionOrder.jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();

	});
	function dateFun(datePattern) {
		$(
				'#prodOrderDate,#estStartDate,#estEndDate,#actStartDate,#actEndDate,#prodOrderDateEdit,#estStartDateEdit,#estEndDateEdit,#actStartDateEdit,#actEndDateEdit')
				.datepicker({
					changeMonth : true,
					changeYear : true,
					dateFormat : datePattern

				});

	}
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
																	prodOrderNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	prodOrderDate : {
																		required : true
																	},
																	totQty : {
																		required : true,
																		number : true

																	},
																	estStartDate : {
																		required : true
																	},
																	estEndDate : {
																		required : true
																	},
																	actStartDate : {
																		required : true
																	},
																	actEndDate : {
																		required : true
																	},
																	prodOrderTypeId : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	materialId : {
																		required : true
																	},
																	uomId : {
																		required : true
																	},
																	salesOrderId : {
																		required : true
																	},
																	statusId : {
																		required : true

																	},
																	priority : {
																		required : true
																	},

																	desc : {
																		required : true
																	}

																},
																/*  errorPlacement :function(error){
																	return false;
																}, */
																messages : {
																	prodOrderNo : {
																		required : "<font style='color: red;'><b>Production Order No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	prodOrderDate : "<font style='color: red;'><b>Production Order Date is Required</b></font>",
																	totQty : {
																		required : "<font style='color: red;'><b>Total Quantity is Required</b></font>",
																		number : "<font style='color: red;'><b>Total Quantity Allows only Numbers</b></font>"
																	},
																	estStartDate : "<font style='color: red;'><b>Estimate Start Date is Required</b></font>",
																	estEndDate : "<font style='color: red;'><b>Estimate End Date is Required</b></font>",
																	actStartDate : "<font style='color: red;'><b>Actual Start Date is Required</b></font>",
																	actEndDate : "<font style='color: red;'><b>Actual End Date is Required</b></font>",
																	prodOrderTypeId : "<font style='color: red;'><b>Production Order Type is Required</b></font>",
																	plantId : "<font style='color: red;'><b>Plant is Required</b></font>",
																	materialId : "<font style='color: red;'><b>Material is Required</b></font>",
																	uomId : "<font style='color: red;'><b>Uom Name is Required</b></font>",
																	salesOrderId : "<font style='color: red;'><b>Sales Order is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	priority : "<font style='color: red;'><b>Priority is Required</b></font>",
																	postingDate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	chequeClearanceDate : "<font style='color: red;'><b>Cheque Clearance Date is Required</b></font>",
																	desc : "<font style='color: red;'><b>Description is Required</b></font>"
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
																	prodOrderNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	prodOrderDate : {
																		required : true
																	},
																	totQty : {
																		required : true,
																		number : true

																	},
																	estStartDate : {
																		required : true
																	},
																	estEndDate : {
																		required : true
																	},
																	actStartDate : {
																		required : true
																	},
																	actEndDate : {
																		required : true
																	},
																	prodOrderTypeId : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	materialId : {
																		required : true
																	},
																	uomId : {
																		required : true
																	},
																	salesOrderId : {
																		required : true
																	},
																	statusId : {
																		required : true

																	},
																	priority : {
																		required : true
																	},

																	desc : {
																		required : true
																	}

																},
																messages : {
																	prodOrderNo : {
																		required : "<font style='color: red;'><b>Production Order No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	prodOrderDate : "<font style='color: red;'><b>Production Order Date is Required</b></font>",
																	totQty : {
																		required : "<font style='color: red;'><b>Total Quantity is Required</b></font>",
																		number : "<font style='color: red;'><b>Total Quantity Allows only Numbers</b></font>"
																	},
																	estStartDate : "<font style='color: red;'><b>Estimate Start Date is Required</b></font>",
																	estEndDate : "<font style='color: red;'><b>Estimate End Date is Required</b></font>",
																	actStartDate : "<font style='color: red;'><b>Actual Start Date is Required</b></font>",
																	actEndDate : "<font style='color: red;'><b>Actual End Date is Required</b></font>",
																	prodOrderTypeId : "<font style='color: red;'><b>Production Order Type is Required</b></font>",
																	plantId : "<font style='color: red;'><b>Plant is Required</b></font>",
																	materialId : "<font style='color: red;'><b>Material is Required</b></font>",
																	uomId : "<font style='color: red;'><b>Uom Name is Required</b></font>",
																	salesOrderId : "<font style='color: red;'><b>Sales Order is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	priority : "<font style='color: red;'><b>Priority is Required</b></font>",
																	postingDate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	chequeClearanceDate : "<font style='color: red;'><b>Cheque Clearance Date is Required</b></font>",
																	desc : "<font style='color: red;'><b>Description is Required</b></font>"
																},
															});

										});

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#basicSearchId').focus();
			$('#prodOrderNo').focus();
			$('#prodOrderNo').val('');
			$('#prodOrderTypeId').val('');
			$('#prodOrderNo').val('');
			$('#prodOrderDate').val('');
			$('#plantId').val('');
			$('#materialId').val('');
			$('#uomId').val('');
			$('#salesOrderId').val('');
			$('#statusId').val('');
			$('#totQty').val('');
			$('#estStartDate').val('');
			$('#estEndDate').val('');
			$('#actStartDate').val('');
			$('#actEndDate').val('');
			$('#priority').val('');
			$('#desc').val('');

		});
	});
</script>
<script type="text/javascript">
	function AjaxForDuplicate() {
		var PONo = $('#prodOrderNo').val();
		//alert(PONo);

		$
				.ajax({
					type : "POST",
					url : "checkProdOrderAddDuplicate.mnt",
					data : "prodOrderNo=" + PONo,
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
		var cust = $('#prodOrderNoEdit').val();
		var id = $('#prodOrderIdEdit').val();
		//alert(cust);

		$
				.ajax({
					type : "POST",
					url : "checkProdOrderUpdateDuplicate.mnt",
					data : "prodOrderNo=" + cust + "&prodOrderId=" + id,
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
		<div class="PageTitle">Production Order</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="prodOrderEdit" items="${prodOrderEdit}">
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
					<form:form method="get" action="prodOrderSearch.mnt"
						commandName="prodOrderCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addPOsus"
										items="${param.addPOsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.prododr" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addPOFail"
										items="${param.addPOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.prododr" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updatePOsus"
										items="${param.updatePOsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.prododr" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="updatePOFail"
										items="${param.updatePOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.prododr" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeletePOsus"
										items="${param.DeletePOsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.prododr" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeletePOFail"
										items="${param.DeletePOFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.prododr" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="prodOrderCmd.operations">
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
									<c:when test="${search}">
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

					<c:if test="${prodOrderList!=null }">
						<display:table name="prodOrderList" id="prodOrderIDList"
							class="table" requestURI="prodOrderSearch.mnt" pagesize="5">
							<display:column property="prodOrderId" sortable="true"
								title="prodOrderId" media="none" />

							<display:column property="prodOrderNo" sortable="true"
								titleKey="label.pono" media="html" />

							<display:column property="prodOrderDate" sortable="true"
								titleKey="label.podate" media="html" />

							<display:column property="plantId" sortable="true"
								titleKey="label.poplant" media="html" />

							<display:column property="prodOrderTypeId" sortable="true"
								titleKey="label.potid" media="html" />

							<display:column property="salesOrderId" sortable="true"
								titleKey="label.poso" media="html" />

							<display:column property="materialId" sortable="true"
								titleKey="label.pomat" media="html" />

							<display:column property="uomId" sortable="true"
								titleKey="label.pouom" media="html" />

							<display:column property="totQty" sortable="true"
								titleKey="label.potqty" media="html" />

							<display:column property="statusId" sortable="true"
								titleKey="label.postatus" media="html" />

							<display:column property="estStartDate" sortable="true"
								titleKey="label.poedate" media="html" />
							<display:column property="estEndDate" sortable="true"
								titleKey="label.poeedate" media="html" />
							<display:column property="actStartDate" sortable="true"
								titleKey="label.poacdate" media="html" />
							<display:column property="actEndDate" sortable="true"
								titleKey="label.poacedate" media="html" />

							<display:column property="priority" sortable="true"
								titleKey="label.poprt" media="none" />
							<display:column property="desc" sortable="true"
								titleKey="label.podesc" media="none" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="prodOrderEdit.mnt?prodOrderId=<c:out value="${prodOrderIDList.prodOrderId}"/> "><img
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
									<c:when test="${delete}">
										<a
											href="prodOrderDelete.mnt?prodOrderId=<c:out value="${prodOrderIDList.prodOrderId}"/> "
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
									<spring:message code="label.pono" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="prodOrderAdd.mnt" id="addForm" method="POST"
						commandName="prodOrderCmd">
						<table class="tableGeneral">
							<tr>
								<td><spring:message code="label.pono" /><span
									class="required">*</span></td>
								<td><form:input path="prodOrderNo" class="textbox"
										id="prodOrderNo" maxlength="20" onkeyup="AjaxForDuplicate()" /></td>

								<td><spring:message code="label.potid" /><span
									class="required">*</span></td>
								<td><form:select path="prodOrderTypeId" class="select"
										id="prodOrderTypeId">
										<form:option value="">-Select-</form:option>
										<form:options items="${POTypeSelect}" />
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.podate" /><span
									class="required">*</span></td>
								<td><form:input path="prodOrderDate" class="textbox"
										id="prodOrderDate" /></td>

								<td><spring:message code="label.poplant" /><span
									class="required">*</span></td>
								<td><form:select path="plantId" class="select" id="plantId">
										<form:option value="">-Select-</form:option>
										<form:options items="${plantSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.potqty" /><span
									class="required">*</span></td>
								<td><form:input path="totQty" class="textbox" id="totQty"
										maxlength="21" /></td>

								<td><spring:message code="label.pomat" /><span
									class="required">*</span></td>
								<td><form:select path="materialId" class="select"
										id="materialId">
										<form:option value="">-Select-</form:option>
										<form:options items="${materialSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.poedate" /><span
									class="required">*</span></td>
								<td><form:input path="estStartDate" class="textbox"
										id="estStartDate" /></td>

								<td><spring:message code="label.pouom" /><span
									class="required">*</span></td>
								<td><form:select path="uomId" class="select" id="uomId">
										<form:option value="">-Select-</form:option>
										<form:options items="${uomSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.poeedate" /><span
									class="required">*</span></td>
								<td><form:input path="estEndDate" class="textbox"
										id="estEndDate" /></td>
								<td><spring:message code="label.poso" /><span
									class="required">*</span></td>
								<td><form:select path="salesOrderId" class="select"
										id="salesOrderId">
										<form:option value="">-Select-</form:option>
										<form:options items="${salesOrderSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.poacdate" /><span
									class="required">*</span></td>
								<td><form:input path="actStartDate" class="textbox"
										id="actStartDate" /></td>

								<td><spring:message code="label.postatus" /><span
									class="required">*</span></td>
								<td><form:select path="statusId" class="select"
										id="statusId">
										<form:option value="">-Select-</form:option>
										<form:options items="${statusSelect}" />
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.poacedate" /><span
									class="required">*</span></td>
								<td><form:input path="actEndDate" class="textbox"
										id="actEndDate" /></td>

								<td><spring:message code="label.poprt" /><span
									class="required">*</span></td>
								<td><form:select path="priority" class="select"
										id="priority">
										<form:option value="">-Select-</form:option>
										<form:option value="HIGH">HIGH</form:option>
										<form:option value="MEDIUM">MEDIUM</form:option>
										<form:option value="LOW">LOW</form:option>
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.podesc" /><span
									class="required">*</span></td>
								<td><form:textarea path="desc" class="textbox" id="desc"
										maxlength="250" /></td>

							</tr>

							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${save}">
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
									<spring:message code="label.pono" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<c:forEach var="prodOrderEdit" items="${prodOrderEdit}">

						<form:form method="post" action="prodOrderUpdate.mnt"
							commandName="prodOrderCmd" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="prodOrderId" id="prodOrderIdEdit" />

								<tr>
									<td><spring:message code="label.pono" /><span
										class="required">*</span></td>
									<td><form:input path="prodOrderNo" class="textbox"
											id="prodOrderNoEdit" maxlength="20"
											onkeyup="AjaxUpdateDuplicate()" /></td>

									<td><spring:message code="label.potid" /><span
										class="required">*</span></td>
									<td><form:select path="prodOrderTypeId" class="select"
											id="prodOrderTypeId">
											<form:option value="">-Select-</form:option>
											<form:options items="${POTypeSelect}" />
										</form:select></td>
								</tr>

								<tr>
									<td><spring:message code="label.podate" /><span
										class="required">*</span></td>
									<td><form:input path="prodOrderDate" class="textbox"
											id="prodOrderDateEdit" /></td>

									<td><spring:message code="label.poplant" /><span
										class="required">*</span></td>
									<td><form:select path="plantId" class="select"
											id="plantId">
											<form:option value="">-Select-</form:option>
											<form:options items="${plantSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.potqty" /><span
										class="required">*</span></td>
									<td><form:input path="totQty" class="textbox" id="totQty"
											maxlength="21" /></td>

									<td><spring:message code="label.pomat" /><span
										class="required">*</span></td>
									<td><form:select path="materialId" class="select"
											id="materialId">
											<form:option value="">-Select-</form:option>
											<form:options items="${materialSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.poedate" /><span
										class="required">*</span></td>
									<td><form:input path="estStartDate" class="textbox"
											id="estStartDateEdit" /></td>

									<td><spring:message code="label.pouom" /><span
										class="required">*</span></td>
									<td><form:select path="uomId" class="select" id="uomId">
											<form:option value="">-Select-</form:option>
											<form:options items="${uomSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.poeedate" /><span
										class="required">*</span></td>
									<td><form:input path="estEndDate" class="textbox"
											id="estEndDateEdit" /></td>
									<td><spring:message code="label.poso" /><span
										class="required">*</span></td>
									<td><form:select path="salesOrderId" class="select"
											id="salesOrderId">
											<form:option value="">-Select-</form:option>
											<form:options items="${salesOrderSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.poacdate" /><span
										class="required">*</span></td>
									<td><form:input path="actStartDate" class="textbox"
											id="actStartDateEdit" /></td>

									<td><spring:message code="label.postatus" /><span
										class="required">*</span></td>
									<td><form:select path="statusId" class="select"
											id="statusId">
											<form:option value="">-Select-</form:option>
											<form:options items="${statusSelect}" />
										</form:select></td>

								</tr>

								<tr>
									<td><spring:message code="label.poacedate" /><span
										class="required">*</span></td>
									<td><form:input path="actEndDate" class="textbox"
											id="actEndDateEdit" /></td>

									<td><spring:message code="label.poprt" /><span
										class="required">*</span></td>
									<td><form:select path="priority" class="select"
											id="priority">
											<form:option value="">-Select-</form:option>
											<form:option value="HIGH">HIGH</form:option>
											<form:option value="MEDIUM">MEDIUM</form:option>
											<form:option value="LOW">LOW</form:option>
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.podesc" /><span
										class="required">*</span></td>
									<td><form:textarea path="desc" class="textbox" id="desc"
											maxlength="250" /></td>

								</tr>

								<tr>
									<td></td>
								</tr>
								<tr>
									<td></td>
								</tr>
								<tr>
									<c:choose>

										<c:when test="${update}">

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
