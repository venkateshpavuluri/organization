<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'salesInquiry.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet"
	href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addSalesForm')
													.validate(
															{
																rules : {
																	salesInquiryNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	salesGroupId : {
																		required : true

																	},
																	customerId : {
																		required : true
																	},
																	requestedDate : {
																		required : true
																	},
																	validFrom : {
																		required : true
																	},
																	validTo : {
																		required : true
																	},
																	requiredDeliveryDate : {
																		required : true
																	},
																	description : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},

																},
																messages : {
																	salesInquiryNo : {
																		required : "<font style='color: red;'><b>Sales Inquiry No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	salesGroupId : "<font style='color: red;'><b>Sales Group is Required</b></font>",
																	customerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	requestedDate : "<font style='color: red;'><b>Requested Date is Required</b></font>",
																	validFrom : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	validTo : "<font style='color: red;'><b>Valid To is Required</b></font>",
																	requiredDeliveryDate : "<font style='color: red;'><b>Required Delivery Date is Required</b></font>",
																	description : "<font style='color: red;'><b>Description is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},

															});

											if ($('#salesInquiryNo').val() != ""
													&& $('#validFrom').val() != ""
													&& $('#description').val() != ""
													&& $('#customerId').val() != "") {
												if ($('#siId').val() == 0) {
													//alert("Please Enter AtLeast One Sales Inquiry Line");
													document
															.getElementById("childMsg").style.display = "block";
													$('#childMsg')
															.html(
																	"Warning! Please Enter AtLeast One Sales Inquiry Line");
													return false;
												} else {
													document
															.getElementById("childMsg").style.display = "none";
													$('#childMsg').html("");
													return true;
												}
											}
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editSalesForm')
													.validate(
															{
																rules : {
																	esalesInquiryNo : {
																		required : true,
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	esalesGroupId : {
																		required : true

																	},
																	ecustomerId : {
																		required : true
																	},
																	erequestedDate : {
																		required : true
																	},
																	evalidFrom : {
																		required : true
																	},
																	evalidTo : {
																		required : true
																	},
																	erequiredDeliveryDate : {
																		required : true
																	},
																	edescription : {
																		required : true
																	},
																	estatusId : {
																		required : true
																	},

																},
																messages : {
																	esalesInquiryNo : {
																		required : "<font style='color: red;'><b>Sales Inquiry No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	esalesGroupId : "<font style='color: red;'><b>Sales Group is Required</b></font>",
																	ecustomerId : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	erequestedDate : "<font style='color: red;'><b>Requested Date is Required</b></font>",
																	evalidFrom : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	evalidTo : "<font style='color: red;'><b>Valid To is Required</b></font>",
																	erequiredDeliveryDate : "<font style='color: red;'><b>Required Delivery Date is Required</b></font>",
																	edescription : "<font style='color: red;'><b>Description is Required</b></font>",
																	estatusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},
															});

										});

					});
</script>

<script>
	$(function() {
		$("#tabs,#tabss,#edittabs").tabs();
		
	});

	function dateFun(datePattern) {

		$('#reqdate,#reqdelDate,#validFrom,#validTo,#requiredDate').datepicker(
				{
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					onSelect : function(d) {
						var date = $('#validFrom,#reqdate').datepicker(
								'getDate');
						date.setDate(date.getDate() + 0);
						$('#validTo,#reqdelDate').datepicker('option',
								'minDate', date);
					}
				});

		$(
				'#reqdateEdit,#reqdelDateEdit,#validFromEdit,#validToEdit,#requiredDateEdit')
				.datepicker(
						{
							dateFormat : datePattern,
							changeMonth : true,
							changeYear : true,
							onSelect : function(d) {
								var date = $('#validFromEdit,#reqdateEdit')
										.datepicker('getDate');
								date.setDate(date.getDate() + 0);
								$('#validToEdit,#reqdelDateEdit').datepicker(
										'option', 'minDate', date);
							}
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
</style>
<script type="text/javascript">
	$(document).ready(function() {
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
			
		}
		
		$('#basicSearch').click(function() {
			$("#advanceSearchHidden").val('0');
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
	function AjaxForDuplicate() {
		var cust = $('#salesInquiryNo').val();
		//alert(cust);
		$
				.ajax({
					type : "POST",
					url : "checkSalesAddDuplicate.mnt",
					data : "salesInquiryNo=" + cust,
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
		var cust = $('#esalesInquiryNo').val();
		var id = $('#esalesInquiryId').val();
		//alert(id);
		$
				.ajax({
					type : "POST",
					url : "checkSalesUpdateDuplicate.mnt",
					data : "esalesInquiryNo=" + cust + "&siId=" + id,
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
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("siId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

		$('#sumbnasdStop').click(function(e) {
			document.getElementById("siId").value = 1;
			//alert(document.getElementById("asId").value);
		});
		
		

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#basicSearchId').focus();
			$('#salesInquiryNo').focus();
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Sales Inquiry</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:if test="${salesEditList!=null}">

					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:if>

				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!-- Tab-2 -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form method="get" action="salesInquirySearch.mnt"
						commandName="salesInquiryCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addSESus"
										items="${param.addSESus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sinquiry" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addSEFail"
										items="${param.addSEFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sinquiry" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSEsus"
										items="${param.UpdateSEsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sinquiry" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSEFail"
										items="${param.UpdateSEFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sinquiry" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteSEsus"
										items="${param.DeleteSEsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.sinquiry" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteSEFail"
										items="${param.DeleteSEFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.sinquiry" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr id="mainSearch">
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox"
										id="basicSearchId" /></td>
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
							
							<form:form action="SIAdvanceSearch.mnt" method="get"
								commandName="salesInquiryCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="SIAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>

						</table>
						<form:form action="SIAdvanceSearchOperations.mnt"
							commandName="salesInquiryCmd" method="get">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="salesInquiryCmd.asOpts">
													<select class="select" name="asOpts">
														<option value="<spring:message code='assignedOperator'/>">
															<spring:message code="label.equalsTo" />
														</option>
														<option value="<spring:message code='notequalsOperator'/>">
															<spring:message code="label.notEqualsTo" />
														</option>
														<option
															value="<spring:message code='beginsWithOperator'/>">
															<spring:message code="label.beginsWith" />
														</option>
														<option value="<spring:message code='endsWithOperator'/>">
															<spring:message code="label.endsWith" />
														</option>
														<option value="<spring:message code='containsOperator'/>">
															<spring:message code="label.contains" />
														</option>
													</select>
												</spring:bind></td>

											<td><form:input path="advanceSearchText"
													cssClass="textbox" /></td>
										</tr>

									</c:forEach>
									

									<c:forEach var="refList" items="${refList}">
										<tr>
											<td><label>${refList.labels}</label> <form:hidden
													path="dbField" id="dbField" value="${refList.dbField}" /></td>
											<td><spring:bind path="salesInquiryCmd.asOpts">
													<select class="select" name="asOpts">
														<option value="<spring:message code='assignedOperator'/>">
															<spring:message code="label.equalsTo" />
														</option>
														<option value="<spring:message code='notequalsOperator'/>">
															<spring:message code="label.notEqualsTo" />
														</option>
														
													</select>
												</spring:bind></td>

											<c:set var="bdField" value="${refList.dbField}" />
											<c:set var="salesGroupId" value="salesGroupId" />
											<c:set var="customerId" value="customerId" />
											<c:if test="${bdField eq salesGroupId}">
												<c:set var="selectBox" value="${salesGroupSelect}" />
											</c:if>
											<c:if test="${bdField eq customerId}">
												<c:set var="selectBox" value="${custSelect}" />
											</c:if>

											<td><form:select class="select" path="advanceSearchText">
													<form:option value="">--Select--</form:option>
													<form:options items="${selectBox}" />
												</form:select></td>

										</tr>

									</c:forEach>

									<tr>
										<form:hidden path="advanceSearchHidden"
											id="advanceSearchHidden" />
										<c:choose>
											<c:when test="${search }">
												<td colspan="3"><input type="submit"
													id="advanceSearchButtonId" value="Advance Search"
													style="display: none" class="btn btn-primary" /></td>
											</c:when>
											<c:otherwise>
												<td colspan="3"><input type="submit"
													disabled="disabled" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-danger" /></td>
											</c:otherwise>
										</c:choose>
									</tr>

								</table>

							</div>
						</form:form>
						
					</form:form>

					<c:if test="${SEList!=null }">
					<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="SIAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="salesInquirySearch.mnt" />
							</c:otherwise>

						</c:choose>
					
						<display:table name="SEList" id="SEIdList" class="table"
							requestURI="${search}" pagesize="5">

							<display:column property="salesInquiryId" sortable="true"
								title="salesInquiryId" media="none" />

							<display:column property="salesInquiryNo" sortable="true"
								titleKey="label.salesinqno" media="html" />

							<display:column property="customerId" sortable="true"
								titleKey="label.salescustId" media="html" />


							<display:column property="requestedDate" sortable="true"
								titleKey="label.reqdate" media="html" />

							<display:column property="validFrom" sortable="true"
								titleKey="label.validfrom" media="html" />

							<display:column property="validTo" sortable="true"
								titleKey="label.validto" media="html" />


							<display:column property="requiredDeliveryDate" sortable="true"
								titleKey="label.reqdeldate" media="html" />


							<display:column property="salesGroupId" sortable="true"
								titleKey="label.salesgroupid" media="html" />

							<display:column property="description" sortable="true"
								titleKey="label.salesdesc" media="html" />

							<display:column property="statusId" sortable="true"
								titleKey="label.sstatusId" media="none" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="SalesInquiryEdit.mnt?salesInquiryId=<c:out value="${SEIdList.salesInquiryId}"/> "><img
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
											href="salesInquiryDelete.mnt?salesInquiryId=<c:out value="${SEIdList.salesInquiryId}"/> "
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
							<td colspan="4" class="alert-warning" id="childMsg"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
						<tr>
							<td colspan="2" id="salesDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.salesinqno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="salesInquiryAdd.mnt" method="POST"
						commandName="salesInquiryCmd" id="addSalesForm">

						<table class="tableGeneral">
							<tr>
								<td>

									<table class="tableGeneral">

										<tr>
											<td><spring:message code="label.salesinqno" /><span
												class="required">*</span></td>
											<td><form:input path="salesInquiryNo"
													id="salesInquiryNo" cssClass="textbox"
													onkeyup="AjaxForDuplicate()" maxlength="20" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.salesgroupid" /><span
												class="required">*</span></td>
											<td><form:select path="salesGroupId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${salesGroupSelect}" />
												</form:select></td>
										</tr>

										<tr>
											<td><spring:message code="label.salescustId" /><span
												class="required">*</span></td>
											<td><form:select path="customerId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${custSelect}" />

												</form:select></td>

										</tr>

										<tr>
											<td><spring:message code="label.reqdate" /><span
												class="required">*</span></td>
											<td><form:input path="requestedDate" cssClass="textbox"
													id="reqdate" /></td>

										</tr>
										<tr>
											<td><spring:message code="label.reqdeldate" /><span
												class="required">*</span></td>
											<td><form:input path="requiredDeliveryDate"
													cssClass="textbox" id="reqdelDate" /></td>

										</tr>
										<tr>
											<td><spring:message code="label.validfrom" /><span
												class="required">*</span></td>
											<td><form:input path="validFrom" cssClass="textbox"
													id="validFrom" /></td>

										</tr>
										<tr>
											<td><spring:message code="label.validto" /><span
												class="required">*</span></td>
											<td><form:input path="validTo" cssClass="textbox"
													id="validTo" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.salesdesc" /><span
												class="required">*</span></td>
											<td><form:textarea path="description" cssClass="textbox"
													maxlength="250" /> <input type="hidden" name="siId"
												id="siId" class="textbox" value="0" /></td>
										</tr>

										<%--<tr>
											  <td><spring:message code="label.sstatusId" /><span
												class="required">*</span></td>
											<td><form:input path="statusId" cssClass="textbox" /> 
											
											</td>
										</tr>  --%>

									</table>

								</td>

							</tr>

						</table>

						<!-- window 2 -->

						<div id="tabss" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.salesline" /></a></li>
							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1">

								<!-- Model Pop-up Start-->

								<div align="center">
									<script type="text/javascript">
										var btrid = 1;
										var list = [];
										$(document)
												.ready(
														function() {

															var matId = $("#materialId"), qty = $("#quantity"), uomId = $("#UOMId"), reqDate = $("#requiredDate"), hiddenID = $("#hiddenIdBankPopUp"),

															allFields = $([])
																	.add(matId)
																	.add(qty)
																	.add(uomId)
																	.add(
																			reqDate)
																	.add(
																			hiddenID), tips = $(".validateTips");
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

															var n = 1;
															function DuplMaterials(
																	m) {
																var mId = m
																		.val();
																if (n == 1) {
																	list
																			.push(mId);
																	n++;
																	return true;
																} else {
																	var flag = $
																			.inArray(
																					mId,
																					list);
																	if (flag != -1) {
																		//alert("Material Name Already Exists!");
																		m
																				.addClass("ui-state-error");
																		updateTips("Warning! Material Name Already Exists");
																		return false;

																	} else {
																		list
																				.push(mId);
																		updateTips('');
																		return true;
																	}

																}

															}

															function checkLength(
																	o, n, min,
																	max) {
																if (o.val().length > max
																		|| o
																				.val().length < min) {
																	o
																			.addClass("ui-state-error");
																	updateTips("Length of "
																			+ n
																			+ " must be between "
																			+ min
																			+ " and "
																			+ max
																			+ ".");
																	return false;
																} else {
																	return true;
																}
															}
															function required(
																	o, n) {
																if (o.val() == '') {
																	o
																			.addClass("ui-state-error");
																	updateTips(n
																			+ " is Required");
																	return false;
																} else {
																	return true;
																}
															}

															function checkRegexp(
																	o, regexp,
																	n) {
																if (!(regexp
																		.test(o
																				.val()))) {
																	o
																			.addClass("ui-state-error");
																	updateTips(n);
																	return false;
																} else {
																	return true;
																}
															}

															$(
																	"#dialogformsalesLine")
																	.dialog(

																			{
																				autoOpen : false,
																				height : 300,
																				width : 350,
																				modal : true,
																				buttons : {
																					Submit : function() {
																						var bValid = true, flag = true;
																						flag = DuplMaterials(matId);

																						allFields
																								.removeClass("ui-state-error");

																						bValid = bValid
																								&& required(
																										matId,
																										"Material");

																						bValid = bValid
																								&& checkRegexp(
																										qty,
																										/^([0-9])+$/,
																										"Quantity is Required And Must be  Number");

																						bValid = bValid
																								&& required(
																										uomId,

																										"UOM");

																						bValid = bValid
																								&& required(
																										reqDate,
																										"Required Date");

																						if (bValid
																								&& flag) {
																							//alert("hiddenid"+hiddenID.val());
																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {
																								$(
																										"#SalesLineAdd tbody")
																										.append(

																												"<tr id="+btrid+">"
																														+ "<td ><spring:bind path='salesInquiryCmd.materialId'><input type='hidden' name='materialId' id='materialId"
																														+ btrid
																														+ "' value="
																														+ matId
																																.val()

																														+ " class='textbox' readonly/></spring:bind> "
																														+ "<input type='text' readonly class='textbox' name='materialName' id='materialName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#materialId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input name='quantity' id='quantity"
																														+ btrid
																														+ "' value="
																														+ qty
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input type='hidden' name='UOMId' id='UOMId"
																														+ btrid
																														+ "' value="
																														+ uomId
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='uomName' id='uomName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#UOMId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input name='requiredDate' id='requiredDate"
																														+ btrid
																														+ "' value="
																														+ reqDate
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+

																														"<td><a href='#'  onclick='editSalesInquiryLine("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeSalesInquiryLine("
																														+ btrid
																														+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																														+ "</tr>");
																								$(
																										'#siId')
																										.val(
																												btrid);
																								btrid++;
																								$(
																										this)
																										.dialog(
																												"close");
																							}

																							if (hiddenID
																									.val() != "0") {

																								$(
																										'#materialId'
																												+ hiddenID
																														.val())
																										.val(
																												matId
																														.val());

																								$(
																										'#materialName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#materialId :selected')
																														.text());

																								$(
																										'#quantity'
																												+ hiddenID
																														.val())
																										.val(
																												qty
																														.val());

																								$(
																										'#UOMId'
																												+ hiddenID
																														.val())
																										.val(
																												uomId
																														.val());
																								$(
																										'#uomName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#UOMId :selected')
																														.text());

																								$(
																										'#requiredDate'
																												+ hiddenID
																														.val())
																										.val(
																												reqDate
																														.val());

																								$(
																										'#hiddenIdBankPopUp')
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

															$(
																	'#createAddSalesLine')
																	.button()
																	.click(
																			function() {

																				$(
																						"#dialogformsalesLine")
																						.dialog(
																								"open");
																				tips
																						.text('');
																				//alert("opened");
																			});
														});

										function removeSalesInquiryLine(id) {
											//alert("removing row " + id);
											list.pop(parseInt(id)-1);
											$('#' + id).remove();
										}
										function editSalesInquiryLine(id) {
											//alert("edit row " + id);
											list.pop(parseInt(id) - 1);
											$(".validateTips").text('');
											$("#dialogformsalesLine").dialog(
													"open");

											$('#materialId')
													.val(
															$(
																	'#materialId'
																			+ id)
																	.val());

											$('#quantity').val(
													$('#quantity' + id).val());

											$('#UOMId').val(
													$('#UOMId' + id).val());

											$('#requiredDate').val(
													$('#requiredDate' + id)
															.val());

											$('#hiddenIdBankPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialogformsalesLine" align="center"
										title="<spring:message code="label.saleslineform" />">
										<p class="validateTips" align="center" style="color: blue;"></p>
										<table class="tableGeneral">
											<tr>
												<td><spring:message code="label.matid" /><span
													class=required>*</span></td>
												<td><form:select path="material_Id" id="materialId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.sqty" /><span
													class=required>*</span></td>
												<td><form:input path="quantity" id="quantity"
														class="textbox" maxlength="10" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.sauomid" /> <span
													class=required>*</span></td>
												<td><form:select path="uom_Id" id="UOMId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.requireddate" /><span
													class=required>*</span></td>
												<td><form:input path="requiredDate" id="requiredDate"
														class="textbox" /></td>
											</tr>

											<tr>
												<td><input type="hidden" name="hiddenIdBankPopUp"
													id="hiddenIdBankPopUp" value="0" /></td>
											</tr>

										</table>
									</div>

									<div id="users-SalesLine">
										<table id="SalesLineAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.matid" /></th>
													<th><spring:message code="label.sqty" /></th>
													<th><spring:message code="label.sauomid" /></th>
													<th><spring:message code="label.requireddate" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>

									<button id="createAddSalesLine" type="button">
										<spring:message code="label.newsalesline" />
									</button>

								</div>


								<!-- Model Pop-up End-->
							</div>


						</div>

						<!-- window 2 -->
						<table>
							<tr>
								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="submitid"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="submitid"
											disabled="disabled"
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
			<!--Edit  Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="salesUpDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.salesinqno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form method="post" action="salesInquiryUpdate.mnt"
						commandName="salesInquiryCmd" id="editSalesForm">
						<c:forEach var="salesEditList" items="${salesEditList}">
							<c:set var="editMode" value="${salesEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td>
										<div>

											<table class="tableGeneral">

												<form:hidden path="esalesInquiryId" id="esalesInquiryId" />
												<form:hidden path="estatusId" cssClass="textbox" />

												<tr>
													<td><spring:message code="label.salesinqno" /><span
														class="required">*</span></td>
													<td><form:input path="esalesInquiryNo"
															id="esalesInquiryNo" cssClass="textbox"
															onkeyup="AjaxUpdateDuplicate()" maxlength="20" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.salesgroupid" /><span
														class="required">*</span></td>
													<td><form:select path="esalesGroupId"
															cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${salesGroupSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.salescustId" /><span
														class="required">*</span></td>
													<td><form:select path="ecustomerId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${custSelect}" />

														</form:select></td>

												</tr>

												<tr>
													<td><spring:message code="label.reqdate" /><span
														class="required">*</span></td>
													<td><form:input path="erequestedDate"
															cssClass="textbox" id="reqdateEdit" /></td>

												</tr>
												<tr>
													<td><spring:message code="label.reqdeldate" /><span
														class="required">*</span></td>
													<td><form:input path="erequiredDeliveryDate"
															cssClass="textbox" id="reqdelDateEdit" /></td>

												</tr>
												<tr>
													<td><spring:message code="label.validfrom" /><span
														class="required">*</span></td>
													<td><form:input path="evalidFrom" cssClass="textbox"
															id="validFromEdit" /></td>

												</tr>
												<tr>
													<td><spring:message code="label.validto" /><span
														class="required">*</span></td>
													<td><form:input path="evalidTo" cssClass="textbox"
															id="validToEdit" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.salesdesc" /><span
														class="required">*</span></td>
													<td><form:textarea path="edescription"
															cssClass="textbox" /></td>

												</tr>
												<%-- <tr>
											<td><spring:message code="label.sstatusId" /><span
												class="required">*</span></td>
											<td><form:input path="estatusId" cssClass="textbox" /></td>
										</tr>  --%>



											</table>
										</div>
									</td>
									<td></td>

								</tr>

							</table>

							<!-- window 2 -->

							<div id="tabss" align="left">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.salesline" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var listEdit = [];
											var btridEdit = 1;
											$(function() {
												var list = ${mList};
												$.each(list, function(index,
														value) {
													listEdit.push(value.toString());

												});
												
												var matIdEdit = $("#materialIdEdit"), qtyEdit = $("#quantityEdit"), uomIdEdit = $("#UOMIdEdit"), reqDateEdit = $("#requiredDateEdit"), hiddenEdit = $("#hiddenIdBankPopUpEdit"),

												allFields = $([])
														.add(matIdEdit).add(
																qtyEdit).add(
																uomIdEdit).add(
																reqDateEdit)
														.add(hiddenEdit), tips = $(".validateTips");

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

												function DuplMaterialEdit(m) {
													var mId = m.val();
													var flag = $.inArray(mId,
															listEdit);
													if (flag != -1) {
														//alert("Material Name Already Exists!");
														
														m.addClass("ui-state-error");
														updateTips("Warning! Material Name Already Exists");
														return false;

													} else {
														listEdit.push(mId);
														updateTips('');
														return true;
													};

												}

												function checkLength(o, n, min,
														max) {
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
												function requiredEdit(o, n) {
													if (o.val() == '') {
														o
																.addClass("ui-state-error");
														updateTips(n
																+ " is Required");
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

												$("#dialog-form-salesLineEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 300,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true, flag = true;
																			
																			flag = DuplMaterialEdit(matIdEdit);
																			allFields
																					.removeClass("ui-state-error");

																			bValid1 = bValid1
																					&& requiredEdit(
																							matIdEdit,

																							"Material");
																			bValid1 = bValid1
																					&& checkRegexp(
																							qtyEdit,
																							/^([0-9])+$/,
																							"Quantity is Required And Must be  Number");

																			bValid1 = bValid1
																					&& requiredEdit(
																							uomIdEdit,

																							"UOM");

																			bValid1 = bValid1
																					&& requiredEdit(
																							reqDateEdit,

																							"Required Date");

																			if (bValid1
																					&& flag) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddBankEdit tbody")
																							.append(
																									"<tr id="+btridEdit+">"
																											+ "<td><spring:bind path='salesInquiryCmd.ematerialId'><input type='hidden' name='ematerialId' id='materialIdEdit"
																											+ btridEdit
																											+ "' value="
																											+ matIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text' readonly class='textbox' name='materialName' id='materialNameEdit"
																											+ btridEdit
																											+ "' value='"
																											+ $(
																													'#materialIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"
																											+ "<td><spring:bind path='salesInquiryCmd.equantity'><input name='equantity' id='quantityEdit"
																											+ btridEdit
																											+ "' value="
																											+ qtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='salesInquiryCmd.eUOMId'><input type='hidden' name='eUOMId' id='UOMIdEdit"
																											+ btridEdit
																											+ "' value="
																											+ uomIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text'readonly class='textbox' name='uomName' id='UOMNameEdit"
																											+ btridEdit
																											+ "' value='"
																											+ $(
																													'#UOMIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"
																											+ "<td><spring:bind path='salesInquiryCmd.erequiredDate'><input name='erequiredDate' id='requiredDateEdit"
																											+ btridEdit
																											+ "' value="
																											+ reqDateEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<input type='hidden' name='esalesInquiryLineId' id='esalesInquiryId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																											+

																											"<td><a href='#'  onclick='editSalesDetailsInEditNew("
																											+ btridEdit
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeBankDetailsEditNew("
																											+ btridEdit
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					btridEdit++;
																					$(
																							this)
																							.dialog(
																									"close");

																				}

																				if (hiddenEdit
																						.val() != "0") {
																					$(
																							'#materialIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#materialIdEdit')
																											.val());
																					$(
																							'#materialNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#materialIdEdit :selected')
																											.text());
																					$(
																							'#UOMIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#UOMIdEdit')
																											.val());
																					$(
																							'#UOMNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#UOMIdEdit :selected')
																											.text());
																					$(
																							'#quantityEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#quantityEdit')
																											.val());
																					$(
																							'#requiredDateEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#requiredDateEdit')
																											.val());

																					$(
																							'#hiddenIdBankPopUpEdit')
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

												$("#create-AddSalesEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-salesLineEdit")
																			.dialog(
																					"open");
																	tips
																			.text('');

																});
											});
											function removeBankDetailsEditNew(
													id) {
												//alert("removing row " + id);
												listEdit.pop(parseInt(id) - 1);
												$('#' + id).remove();
											}
											function editSalesDetailsInEditNew(
													link) {
												//alert(link);
												listEdit.pop(parseInt(link) - 1);
												$(".validateTips").text('');
												$("#dialog-form-salesLineEdit")
														.dialog("open");
												$('#materialIdEdit').val(
														$(
																'#materialIdEdit'
																		+ link)
																.val());
												$('#UOMIdEdit').val(
														$('#UOMIdEdit' + link)
																.val());
												$('#quantityEdit').val(
														$(
																'#quantityEdit'
																		+ link)
																.val());
												$('#requiredDateEdit').val(
														$(
																'#requiredDateEdit'
																		+ link)
																.val());

												$('#hiddenIdBankPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-salesLineEdit"
											title="<spring:message code="label.saleslineform" />">
											<p class="validateTips" align="center" style="color: blue;"></p>
											<table class="tableGeneral">
												<form:hidden path="esalesInquiryLineId" value="0" />

												<tr>
													<td><spring:message code="label.matid" /><span
														class=required>*</span></td>
													<td><form:select path="ematerial_Id"
															id="materialIdEdit" class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.sqty" /><span
														class=required>*</span></td>
													<td><form:input path="equantity" id="quantityEdit"
															class="textbox" maxlength="10" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.sauomid" /> <span
														class=required>*</span></td>
													<td><form:select path="euom_Id" id="UOMIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.requireddate" /><span
														class=required>*</span></td>
													<td><form:input path="erequiredDate"
															id="requiredDateEdit" class="textbox" /></td>
												</tr>

												<tr>
													<td><input type="hidden" name="hiddenIdBankPopUpEdit"
														id="hiddenIdBankPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-contain-BankEdit">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="AddBankEdit" class="table">
												<thead>
													<tr>

														<th><spring:message code="label.matid" /></th>
														<th><spring:message code="label.sqty" /></th>
														<th><spring:message code="label.sauomid" /></th>
														<th><spring:message code="label.requireddate" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>

													</tr>
												</thead>
												<tbody>

													<c:forEach var="salesLineEditList"
														items="${salesLineEditList}">

														<spring:bind path="salesInquiryCmd.esalesInquiryLineId">
															<input type="hidden" name="esalesInquiryLineId"
																id="esalesInquiryLineId${salesLineEditList.esalesInquiryLineId}"
																value="${salesLineEditList.esalesInquiryLineId}" />
														</spring:bind>
														<tr id="${salesLineEditList.esalesInquiryLineId}">

															<td><spring:bind path="salesInquiryCmd.ematerialId">
																	<input type="hidden" name="ematerialId" class="textbox"
																		id="materialIdEdit${salesLineEditList.esalesInquiryLineId}"
																		value="${salesLineEditList.ematerialId}" readonly />
																</spring:bind> <spring:bind path="salesInquiryCmd.ematerialName">
																	<input type="text" name="ematerialName" class="textbox"
																		id="materialNameEdit${salesLineEditList.esalesInquiryLineId}"
																		value="${salesLineEditList.ematerialName}" readonly />
																</spring:bind></td>

															<td><spring:bind path="salesInquiryCmd.equantity">
																	<input type="text" name="equantity" class="textbox"
																		id="quantityEdit${salesLineEditList.esalesInquiryLineId}"
																		value="${salesLineEditList.equantity}" readonly />
																</spring:bind></td>

															<td><spring:bind path="salesInquiryCmd.eUOMId">
																	<input type="hidden" name="eUOMId"
																		id="UOMIdEdit${salesLineEditList.esalesInquiryLineId}"
																		class="textbox" value="${salesLineEditList.eUOMId}"
																		readonly />
																</spring:bind> <spring:bind path="salesInquiryCmd.eUomName">
																	<input type="text" name="eUomName"
																		id="UOMNameEdit${salesLineEditList.esalesInquiryLineId}"
																		class="textbox" value="${salesLineEditList.eUomName}"
																		readonly />
																</spring:bind></td>
															<td><spring:bind
																	path="salesInquiryCmd.erequiredDate">
																	<input type="text" name="erequiredDate" class="textbox"
																		id="requiredDateEdit${salesLineEditList.esalesInquiryLineId}"
																		value="${salesLineEditList.erequiredDate}" readonly />
																</spring:bind></td>

															<td><a href="#"
																id="${salesLineEditList.esalesInquiryLineId}"
																onclick="javascript:editSalesDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${salesLineEditList.esalesInquiryLineId}"></img></a></td>
																	
																	
																	<c:if test="${delBtn==true}">

															<td><a href="#"
																id="${salesLineEditList.esalesInquiryLineId}"
																onclick="javascript:getIDSales(this.id)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px"
																	id="${salesLineEditList.esalesInquiryLineId}"></img></a> <input
																type="hidden"
																name="Check${salesLineEditList.esalesInquiryLineId}"
																id="${salesLineEditList.esalesInquiryLineId}Check"
																value="0" /></td>
																</c:if>
																<c:set var="delBtn" value="true"></c:set>
														</tr>

														<script>
															function getIDSales(
																	link) {
																//alert(link);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link
																				+ "Check").value = "1";
																document
																		.getElementById(link).style.display = "none";
															}
															function editSalesDetailsInEdit(
																	link) {
																//alert(""+ link.id);
																listEdit.pop(parseInt(link.id));
																$(
																		"#dialog-form-salesLineEdit")
																		.dialog(
																				"open");
																$(
																		'#materialIdEdit')
																		.val(
																				$(
																						'#materialIdEdit'
																								+ link.id)
																						.val());
																$('#UOMIdEdit')
																		.val(
																				$(
																						'#UOMIdEdit'
																								+ link.id)
																						.val());
																$(
																		'#quantityEdit')
																		.val(
																				$(
																						'#quantityEdit'
																								+ link.id)
																						.val());
																$(
																		'#requiredDateEdit')
																		.val(
																				$(
																						'#requiredDateEdit'
																								+ link.id)
																						.val());

																$(
																		'#hiddenIdBankPopUpEdit')
																		.val(
																				link.id);

															}
														</script>

													</c:forEach>


												</tbody>

											</table>
										</div>
										<button id="create-AddSalesEdit" type="button">
											<spring:message code="label.newsalesline" />
										</button>

									</div>

								</div>
							</div>
							<table>
								<tr>
									<c:choose>

										<c:when test="${update}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updateid" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updateid" /></td>
										</c:otherwise>
									</c:choose>

								</tr>

							</table>
						</c:if>
						<!-- window 2 -->

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>