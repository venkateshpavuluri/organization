<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'customerTemplate.jsp' starting page</title>

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
<link rel="stylesheet" href="css/jquery-ui.css" />
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
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {

											$('#addcustomerform')
													.validate(
															{
																rules : {
																	customerName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	companyName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	customerGroupId : {
																		required : true
																	},

																	mobile : {
																		required : true,
																		number : true,
																		minlength : 10
																	},

																	address : {
																		required : true
																	},

																	contactPerson : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},

																	contactPersonPhone : {
																		required : true,
																		number : true,
																		minlength : 10
																	},

																	city : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},

																	state : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},

																	email : {
																		required : true,
																		email : true
																	},

																	salesAreaId : {
																		required : true

																	},
																	countryId : {
																		required : true

																	},
																	statusId : {
																		required : true

																	},
																	zip : {
																		number : true

																	},
																	fax : {
																		number : true
																	},
																	phone:{number:true,maxlength:12}


																},
																messages : {
																	customerName :{
																		required: "<font style='color: red;'><b>Customer Name is Required</b></font>",
																			alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																			specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	companyName : {
																		required:"<font style='color: red;'><b>Company Name is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	salesAreaId : "<font style='color: red;'><b>Sales Area is Required</b></font>",
																	countryId : "<font style='color: red;'><b>Country is Required</b></font>",
																	customerGroupId : "<font style='color: red;'><b>Customer Group is Required</b></font>",
																	address : "<font style='color: red;'><b>Address is Required</b></font>",
																	contactPerson :{
																		required:"<font style='color: red;'><b>Contact Person is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	}, 
																	contactPersonPhone : {
																		required:"<font style='color: red;'><b>Contact Person Phone is Required</b></font>",
																		number:"<font style='color: red;'><b>Contact Person Phone must be numbers</b></font>",
																		minlength:"<font style='color: red;'><b>Contact Person Phone Minlength Should be 10 Numbers</b></font>",
																	},
																	city : {
																		required:"<font style='color: red;'><b>City is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	state :{
																		required: "<font style='color: red;'><b>State is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		
																	},
																	email :{
																		required:"<font style='color: red;'><b>Email is Required</b></font>",
																		email:"<font style='color: red;'><b>Email Must be Email Format</b></font>",
																	},
																	mobile : {
																		required:"<font style='color: red;'><b>Mobile is Required</b></font>",
																		number:"<font style='color: red;'><b>Mobile must be numbers</b></font>",
																		minlength:"<font style='color: red;'><b>Mobile Minlength Should be 10 Numbers</b></font>",
																	},
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	zip : "<font style='color: red;'><b>Zip must be numbers</b></font>",
																	fax : "<font style='color: red;'><b>Fax must be numbers</b></font>",
																	phone : "<font style='color: red;'><b>Phone must be numbers</b></font>"
																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editcustomerForm')
													.validate(
															{
																rules : {
																	ecustomerName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	ecompanyName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	ecustomerGroupId : {
																		required : true
																	},

																	emobile : {
																		required : true,
																		number : true,
																		minlength : 10
																	},

																	eaddress : {
																		required : true
																	},

																	econtactPerson : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},

																	econtactPersonPhone : {
																		required : true,
																		number : true,
																		minlength : 10
																	},

																	ecity : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},

																	estate : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},

																	eemail : {
																		required : true,
																		email : true
																	},
																	esalesAreaId : {
																		required : true

																	},
																	ecountryId : {
																		required : true

																	},
																	estatusId : {
																		required : true

																	},
																	ezip : {
																		number : true

																	},
																	efax : {
																		number : true
																	},
																	ephone:{number:true,maxlength:12}

																},
																messages : {
																	ecustomerName : {
																		required: "<font style='color: red;'><b>Customer Name is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	ecompanyName : {
																		required:"<font style='color: red;'><b>Company Name is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	ecustomerGroupId : "<font style='color: red;'><b>Customer Group is Required</b></font>",
																	esalesAreaId : "<font style='color: red;'><b>Sales Area is Required</b></font>",
																	ecountryId : "<font style='color: red;'><b>Country is Required</b></font>",
																	eaddress : "<font style='color: red;'><b>Address is Required</b></font>",
																	econtactPerson :{
																		required:"<font style='color: red;'><b>Contact Person is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	econtactPersonPhone : {
																		required:"<font style='color: red;'><b>Contact Person Phone is Required</b></font>",
																		number:"<font style='color: red;'><b>Contact Person Phone must be numbers</b></font>",
																		minlength:"<font style='color: red;'><b>Contact Person Phone Minlength Should be 10 Numbers</b></font>",
																	},
																	ecity : {
																		required:"<font style='color: red;'><b>City is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	estate : {
																		required: "<font style='color: red;'><b>State is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	eemail : {
																		required:"<font style='color: red;'><b>Email is Required</b></font>",
																		email:"<font style='color: red;'><b>Email Must be Email Format</b></font>",
																	},
																	emobile : {
																		required:"<font style='color: red;'><b>Mobile is Required</b></font>",
																		number:"<font style='color: red;'><b>Mobile must be numbers</b></font>",
																		minlength:"<font style='color: red;'><b>Mobile Minlength Should be 10 Numbers</b></font>",
																	},
																	estatusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	ezip : "<font style='color: red;'><b>Zip must be numbers</b></font>",
																	efax : "<font style='color: red;'><b>Fax must be numbers</b></font>",
																	ephone : "<font style='color: red;'><b>Phone must be numbers</b></font>"
																},
															});

										});

					});
</script>

<script>
	$(function() {
		$("#tabs,#tabss,#edittabs").tabs();
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
	function AjaxForDuplicate() {
		var cust = $('#customerName').val();
		//alert(cust);
		$
				.ajax({
					type : "POST",
					url : "checkAddDuplicate.mnt",
					data : "customerName=" + cust,
					success : function(response) {
						if (response != "") {
							document.getElementById("custDuplMessage").style.display = "block";
							//$('#custDuplMessage').html(response);
							$('#submitid').hide();

						} else {
							document.getElementById("custDuplMessage").style.display = "none";
							$('#submitid').show();
						}

					},
					error : function(e) {
						alert('Error' + e);
					}

				});

	}

	function AjaxUpdateDuplicate() {
		var cust = $('#ecustomerName').val();
		var id = $('#ecustomerId').val();
		//alert(id);
		$
				.ajax({
					type : "POST",
					url : "checkUpdateDuplicate.mnt",
					data : "customerName=" + cust + "&cuId=" + id,
					success : function(response) {

						if (response != "") {
							document.getElementById("custUpDuplMessage").style.display = "block";
							//$('#custUpDuplMessage').html(response);
							$('#updateid').hide();

						} else {
							document.getElementById("custUpDuplMessage").style.display = "none";
							$('#updateid').show();
						}

					},
					error : function(e) {
						alert('Error' + e);
					}

				});

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#basicSearchId').focus();
			$('#customerName').focus();
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Customer Details</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:forEach var="customerEditList" items="${customerEditList}">
					<c:set var="customerEditList" value="${customerEditList }"></c:set>
				</c:forEach>
				<c:if test="${customerEditList!=null}">

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

					<form:form method="get" action="customerSearch.mnt"
						commandName="customerCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.customer" />
											<spring:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:forEach var="success" items="${param.addFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.customer" />
											<spring:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach var="custDel" items="${custDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.customer" />
											<spring:message code="label.deleteSuccess" />

										</div>
									</c:forEach> <c:forEach var="custDelErr" items="${custDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.customer" />
											<spring:message code="label.deleteFail" />

										</div>
									</c:forEach> <c:forEach var="custUpdate" items="${custUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.customer" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach var="custUpdateErr" items="${custUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.customer" />
											<spring:message code="label.updateFail" />

										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="customerCmd.operations">
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

								<td><c:choose>
										<c:when test="${search}">
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
					
						<c:if test="${customerList!=null }">
							<display:table name="customerList" id="custList" class="table"
								requestURI="customerSearch.mnt" pagesize="5">
								<display:column property="customerId" sortable="true"
									title="customerId" media="none" />
								<display:column property="customerName" sortable="true"
									titleKey="label.custName" media="html" />

								<display:column property="customerGroupId" sortable="true"
									titleKey="label.custGroup" media="html" />
								<display:column property="salesAreaId" sortable="true"
									titleKey="label.sarea" media="html" />

								<display:column property="companyName" sortable="true"
									titleKey="label.cmpName" media="html" />
								<display:column property="address" sortable="true"
									titleKey="label.addr" media="html" />

								<display:column property="city" sortable="true"
									titleKey="label.city" media="html" />
								<display:column property="state" sortable="true" title="State"
									media="none" />

								<display:column property="countryName" sortable="true"
									titleKey="label.country" media="html" />
								<display:column property="zip" sortable="true" title="Zip"
									media="none" />

								<display:column property="email" sortable="true"
									titleKey="label.email" media="html" />

								<display:column property="phone" sortable="true" title="Phone"
									media="none" />
								<display:column property="mobile" sortable="true"
									titleKey="label.mobile" media="html" />
								<display:column property="fax" sortable="true" title="Fax"
									media="none" />

								<display:column property="contactPerson" sortable="true"
									title="Contact Person" media="none" />
								<display:column property="contactPersonPhone" sortable="true"
									title="Contact PersonPhone" media="none" />

								<display:column titleKey="label.edit">
									<c:choose>
										<c:when test="${edit}">
											<a
												href="customerEdit.mnt?customerId=<c:out value="${custList.customerId}"/> "><img
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
												href="customerDelete.mnt?customerId=<c:out value="${custList.customerId}"/> "
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
							<td colspan="2" id="custDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.custName" />
									<spring:message code="label.duplicateCheck" />
								</div>

							</td>
						</tr>
					</table>
					<form:form action="customerAdd.mnt" method="POST"
						commandName="customerCmd" id="addcustomerform">
						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">
										<form:hidden path="cuId" />
										<tr>
											<td><spring:message code="label.custName" /><span
												class="required">*</span></td>
											<td><form:input path="customerName" id="customerName"
													maxlength="50" cssClass="textbox"
													onkeyup="AjaxForDuplicate()" /></td>
											<td></td>
											<td></td>
											<td><spring:message code="label.state" /><span
												class="required">*</span></td>
											<td><form:input path="state" cssClass="textbox"
													maxlength="50" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.cmpName" /><span
												class="required">*</span></td>
											<td><form:input path="companyName" cssClass="textbox"
													maxlength="50" /></td>
											<td></td>
											<td></td>
											<td><spring:message code="label.country" /><span
												class="required">*</span></td>
											<td><form:select path="countryId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${countrys}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.custGroup" /><span
												class="required">*</span></td>
											<td><form:select path="customerGroupId"
													cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${custGroupSelect}" />
												</form:select></td>

											<td></td>
											<td></td>

											<td><spring:message code="label.email" /><span
												class="required">*</span></td>
											<td><form:input path="email" cssClass="textbox"
													maxlength="30" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.sarea" /><span
												class="required">*</span></td>
											<td><form:select path="salesAreaId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${salesAreaSelect}" />

												</form:select></td>

											<td></td>
											<td></td>

											<td><spring:message code="label.mobile" /><span
												class="required">*</span></td>
											<td><form:input path="mobile" cssClass="textbox"
													maxlength="12" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.addr" /><span
												class="required">*</span></td>
											<td><form:textarea path="address" cssClass="textbox"
													maxlength="250" /></td>
											<td></td>
											<td></td>
											<td><spring:message code="label.phone" /></td>
											<td><form:input path="phone" cssClass="textbox"
													maxlength="12" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.cntperson" /><span
												class="required">*</span></td>
											<td><form:input path="contactPerson" cssClass="textbox"
													maxlength="50" /></td>
											<td></td>
											<td></td>

											<td><spring:message code="label.zip" /></td>
											<td><form:input path="zip" cssClass="textbox"
													maxlength="10" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.cntpersonphn" /><span
												class="required">*</span></td>
											<td><form:input path="contactPersonPhone"
													cssClass="textbox" maxlength="50" /></td>
											<td></td>
											<td></td>
											<td><spring:message code="label.fax" /></td>
											<td><form:input path="fax" cssClass="textbox"
													maxlength="15" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.city" /><span
												class="required">*</span></td>
											<td><form:input path="city" cssClass="textbox"
													maxlength="30" /></td>
											<td></td>
											<td></td>

											<td><spring:message code="label.custst" /><span
												class="required">*</span></td>
											<td><form:select path="statusId" cssClass="select">
													<form:option value="">-Select-</form:option>
													<form:options items="${statusSelect}" />

												</form:select></td>
										</tr>

									</table>

								</td>

							</tr>

						</table>

						<!-- window 2 -->

						<div id="tabss" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.CustomerBankDetails" /></a></li>
								<li><a href="#tab2"><spring:message
											code="label.addcustac" /></a></li>
							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1">
								<!-- Model Pop-up Start-->

								<div align="center">
									<script type="text/javascript">
										var btrid = 1;
										$(function() {
											var name = $("#bankName"), address = $("#bankAddress"), MICRCode = $("#MICRCode"), IFSCCode = $("#IFSCCode"), accountType = $("#accountType"), accountNumber = $("#accountNumber"), hiddenID = $("#hiddenIdBankPopUp"),

											allFields = $([]).add(name).add(
													address).add(MICRCode).add(
													IFSCCode).add(accountType)
													.add(accountNumber).add(
															hiddenID), tips = $(".validateTips");

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

											function required(o, n) {
												if (o.val().length == 0) {
													o
															.addClass("ui-state-error");
													updateTips("" + n);
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
											

											$("#dialog-form-Bank")
													.dialog(

															{
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields
																				.removeClass("ui-state-error");

																		bValid = bValid
																				&& required(name,"Bank Name is Required")&&
																				checkRegexp(name,/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphabet") && checkRegexp(name,/^([0-9a-zA-Z_& ])*$/i,"Special Characters except &,_ are not allowed");
																						
																		bValid = bValid
																				&& required(address,"Bank Address Required");
																						
																		bValid = bValid
																				&& required(MICRCode,"MICR Code Required")&& checkRegexp(MICRCode,/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphanumeric") && checkRegexp(MICRCode,/^([0-9a-zA-Z ])*$/i,"Special Characters except &,_ are not allowed");
																						
																						
																		bValid = bValid
																				&& required(IFSCCode,"IFSC Code Required")&& checkRegexp(IFSCCode,/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphanumeric") && checkRegexp(IFSCCode,/^([0-9a-zA-Z ])*$/i,"Special Characters except &,_ are not allowed");
																						
																		bValid = bValid
																				&& required(
																						accountType,"Account Type Required")&& 
																						checkRegexp(accountType,/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphabet") && checkRegexp(accountType,/^([0-9a-zA-Z_& ])*$/i,"Special Characters except &,_ are not allowed");
																		bValid = bValid
																				&& required(accountNumber,"Account Number Required")&&
																				 checkRegexp(accountNumber,/^([0-9a-zA-Z ])*$/i,"Special Characters are not allowed");		

																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				$(
																						"#BankAdd tbody")
																						.append(

																								"<tr id="+btrid+">"
																										+ "<td ><spring:bind path='customerCmd.bankName'><input name='bankName' id='bankName"
																										+ btrid
																										+ "' value="
																										+ name
																												.val()

																										+ " class='textbox' readonly/></spring:bind>  </td>"
																										+ "<td><input name='bankAddress' id='bankAddress"
																										+ btrid
																										+ "' value="
																										+ address
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+ "<td><input name='MICRCode' id='MICRCode"
																										+ btrid
																										+ "' value="
																										+ MICRCode
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+ "<td><input name='IFSCCode' id='IFSCCode"
																										+ btrid
																										+ "' value="
																										+ IFSCCode
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+ "<td><input name='accountType' id='accountType"
																										+ btrid
																										+ "' value="
																										+ accountType
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+ "<td><input name='accountNumber' id='accountNumber"
																										+ btrid
																										+ "' value="
																										+ accountNumber
																												.val()
																										+ " class='textbox' readonly/></td>"

																										+ "<td><a href='#'  onclick='editcustBank("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removecustBank("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");

																				btrid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}

																			if (hiddenID
																					.val() != "0") {

																				$(
																						'#bankName'
																								+ hiddenID
																										.val())
																						.val(
																								name
																										.val());

																				$(
																						'#bankAddress'
																								+ hiddenID
																										.val())
																						.val(
																								address
																										.val());

																				$(
																						'#MICRCode'
																								+ hiddenID
																										.val())
																						.val(
																								MICRCode
																										.val());

																				$(
																						'#IFSCCode'
																								+ hiddenID
																										.val())
																						.val(
																								IFSCCode
																										.val());

																				$(
																						'#accountType'
																								+ hiddenID
																										.val())
																						.val(
																								accountType
																										.val());
																				$(
																						'#accountNumber'
																								+ hiddenID
																										.val())
																						.val(
																								accountNumber
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

											$("#create-AddBank")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-Bank")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removecustBank(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editcustBank(id) {
											//alert("edit row " + id);

											$("#dialog-form-Bank").dialog(
													"open");

											$('#bankName').val(
													$('#bankName' + id).val());

											$('#bankAddress').val(
													$('#bankAddress' + id)
															.val());

											$('#MICRCode').val(
													$('#MICRCode' + id).val());

											$('#IFSCCode').val(
													$('#IFSCCode' + id).val());

											$('#accountType').val(
													$('#accountType' + id)
															.val());

											$('#accountNumber').val(
													$('#accountNumber' + id)
															.val());

											$('#hiddenIdBankPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>

									<div id="dialog-form-Bank"
										title="<spring:message code="label.bankform" />">
										<p class="validateTips" align="center" style="color: blue;">All
											Form Fields are Required</p>
										<table class="tableGeneral">
											<tr>
												<td><spring:message code="label.bankname" /><span
													class=required>*</span></td>
												<td><form:input path="bankName" id="bankName"
														class="textbox" maxlength="50" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.bankaddr" /><span
													class=required>*</span></td>
												<td><form:input path="bankAddress" id="bankAddress"
														class="textbox" maxlength="150" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.micrcode" /> <span
													class=required>*</span></td>
												<td><form:input path="MICRCode" id="MICRCode"
														class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.ifsccode" /><span
													class=required>*</span></td>
												<td><form:input path="IFSCCode" id="IFSCCode"
														class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.acttype" /><span
													class=required>*</span></td>
												<td><form:input path="accountType" id="accountType"
														class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.actno" /><span
													class=required>*</span></td>
												<td><form:input path="accountNumber" id="accountNumber"
														class="textbox" maxlength="25" /> <input type="hidden"
													name="hiddenIdBankPopUp" id="hiddenIdBankPopUp" value="0" /></td>
											</tr>

										</table>
									</div>

									<div id="users-contain-Bank">
										<table id="BankAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.bankname" /></th>
													<th><spring:message code="label.bankaddr" /></th>
													<th><spring:message code="label.acttype" /></th>
													<th><spring:message code="label.actno" /></th>
													<th><spring:message code="label.micrcode" /></th>
													<th><spring:message code="label.ifsccode" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
									<button id="create-AddBank" type="button">
										<spring:message code="label.newcustbank" />
									</button>

								</div>
								<!-- Model Pop-up End-->
							</div>


							<!--Sub Tab  -->
							<div id="tab2">
								<div align="center">

									<script type="text/javascript">
										var btrid = 1;

										$(document)
												.ready(
														function() {

															var acGr = $("#acGroupIdChild"), recnd = $("#reCondIdChild"), payTerm = $("#paymentTermIdChild"), payMthd = $("#paymentMethodIdChild"), hiddenID = $("#hiddenIdAccountPopUp"),

															allFields = $([])
																	.add(acGr)
																	.add(recnd)
																	.add(
																			payTerm)
																	.add(
																			payMthd)
																	.add(
																			hiddenID), tips = $(".validateTips");
															function updateTips(
																	t) {
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
																	"#dialogformCustAccount")
																	.dialog(
																			{

																				autoOpen : false,
																				height : 300,
																				width : 350,
																				modal : true,
																				buttons : {
																					Submit : function() {
																						var bValid = true;
																						allFields
																								.removeClass("ui-state-error");

																						//bValid = bValid && required(cust,"Customer Name");
																						bValid = bValid
																								&& required(
																										acGr,
																										"Account Group");
																						bValid = bValid
																								&& required(
																										recnd,
																										"Reconciliation");
																						bValid = bValid
																								&& required(
																										payTerm,
																										"Payment Term");
																						bValid = bValid
																								&& required(
																										payMthd,
																										"Payment Method");

																						if (bValid) {
																							//alert("hiddenid"+hiddenID.val());
																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {
																								$(
																										"#CustAccountAdd tbody")
																										.append(

																												"<tr id="+btrid+">"

																														+ "<td><input type='hidden' name='acGroupId' id='acGroupIdChild"
																														+ btrid
																														+ "' value="
																														+ acGr
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='acGroupName' id='acGroupName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#acGroupIdChild :selected')
																																.text()
																														+ "'"
																														+ "</td>"

																														+ "<td><input type='hidden' name='reCondId' id='reCondIdChild"
																														+ btrid
																														+ "' value="
																														+ recnd
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='reCondName' id='reCondName"
																														+ btrid
																														+ "'  value='"
																														+ $(
																																'#reCondIdChild :selected')
																																.text()
																														+ "'"
																														+ "</td>"

																														+ "<td><input type='hidden' name='paymentTermId' id='paymentTermIdChild"
																														+ btrid
																														+ "' value="
																														+ payTerm
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='paymentTermName' id='paymentTermName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#paymentTermIdChild :selected')
																																.text()
																														+ "'"
																														+ "</td>"

																														+ "<td><input type='hidden' name='paymentMethodId' id='paymentMethodIdChild"
																														+ btrid
																														+ "' value="
																														+ payMthd
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='paymentMethodName' id='paymentMethodName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#paymentMethodIdChild :selected')
																																.text()
																														+ "'"
																														+ "</td>"

																														+ "<td><a href='#'  onclick='editCustAccount("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeCustAccount("
																														+ btrid
																														+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																														+ "</tr>");

																								btrid++;
																								$(
																										this)
																										.dialog(
																												"close");
																							}

																							if (hiddenID
																									.val() != "0") {
																								/* $('#customIdChild'+ hiddenID.val()).val(cust.val());
																								$('#customName'+hiddenID.val()).val($('#customIdChild :selected').text()); */
																								$(
																										'#acGroupIdChild'
																												+ hiddenID
																														.val())
																										.val(
																												acGr
																														.val());
																								$(
																										'#acGroupName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#acGroupIdChild :selected')
																														.text());
																								$(
																										'#reCondIdChild'
																												+ hiddenID
																														.val())
																										.val(
																												recnd
																														.val());
																								$(
																										'#reCondName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#reCondIdChild :selected')
																														.text());
																								$(
																										'#paymentTermIdChild'
																												+ hiddenID
																														.val())
																										.val(
																												payTerm
																														.val());
																								$(
																										'#paymentTermName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#paymentTermIdChild :selected')
																														.text());
																								$(
																										'#paymentMethodIdChild'
																												+ hiddenID
																														.val())
																										.val(
																												payMthd
																														.val());
																								$(
																										'#paymentMethodName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#paymentMethodIdChild :selected')
																														.text());
																								$(
																										'#hiddenIdAccountPopUp')
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
																	'#createAddCustAccount')
																	.button()
																	.click(
																			function() {

																				$(
																						"#dialogformCustAccount")
																						.dialog(
																								"open");
																				//alert("opened");
																			});
														});

										function removeCustAccount(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editCustAccount(id) {
											//alert("edit row " + id);
											$("#dialogformCustAccount").dialog(
													"open");
											//$('#customIdChild').val($('#customIdChild' + id).val());
											$('#acGroupIdChild').val(
													$('#acGroupIdChild' + id)
															.val());
											$('#reCondIdChild').val(
													$('#reCondIdChild' + id)
															.val());
											$('#paymentTermIdChild')
													.val(
															$(
																	'#paymentTermIdChild'
																			+ id)
																	.val());
											$('#paymentMethodIdChild')
													.val(
															$(
																	'#paymentMethodIdChild'
																			+ id)
																	.val());
											$('#hiddenIdAccountPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>

									<div id="dialogformCustAccount" align="center"
										title="<spring:message code="label.custacform" />">
										<p class="validateTips" align="center" style="color: blue;">All
											Form Fields are Required</p>
										<table class="tableGeneral">										
											<tr>
												<td><spring:message code="label.custacgrid" /> <span
													class=required>*</span></td>
												<td><form:select path="acGroupName" id="acGroupIdChild"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${AccGroupSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.custacrecondid" /> <span
													class=required>*</span></td>
												<td><form:select path="reCondName" id="reCondIdChild"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${AccGroupSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.custacpt" /> <span
													class=required>*</span></td>
												<td><form:select path="paymentTermName"
														id="paymentTermIdChild" class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${PaymentTermSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.custacpm" /> <span
													class=required>*</span></td>
												<td><form:select path="paymentMethodName"
														id="paymentMethodIdChild" class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${PaymentMethodSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><input type="hidden" name="hiddenIdAccountPopUp"
													id="hiddenIdAccountPopUp" value="0" /></td>
											</tr>

										</table>
									</div>

									<div id="users-CustAccount">
										<table id="CustAccountAdd" class="table">
											<thead>
												<tr>

													<th><spring:message code="label.custacgrid" /></th>
													<th><spring:message code="label.custacrecondid" /></th>
													<th><spring:message code="label.custacpt" /></th>
													<th><spring:message code="label.custacpm" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>

									<button id="createAddCustAccount" type="button">
										<spring:message code="label.newaddcustac" />
									</button>

								</div>

							</div>


						</div>
						<!-- window 2 -->
						<table>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save}">
											<input type="submit"
												value="<spring:message code="label.save"/>" id="submitid"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="sumnid" disabled="disabled"
												value='<spring:message code="label.save"/>'
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose> <input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
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
							<td colspan="2" id="custUpDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.custName" />
									<spring:message code="label.duplicateCheck" />
								</div>

							</td>
						</tr>
					</table>
					<form:form method="post" action="customerUpdate.mnt"
						commandName="customerCmd" id="editcustomerForm">
						<c:forEach var="customerEditList" items="${customerEditList}">
							<c:set var="editMode" value="${customerEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td width="">
										<div>

											<table class="tableGeneral">
												<tr>
													<td colspan="2"><c:forEach
															var="updateCustomerDuplicate"
															items="${updateCustomerDuplicate}">
															<div class="alert-warning" id="savemessage">
																<font color="red"><c:out
																		value="${updateCustomerDuplicate}"></c:out></font>
															</div>
														</c:forEach></td>
												</tr>

												<form:hidden path="cuEditId" />
												<form:hidden path="eactive" />
												<form:hidden path="ecustomerId" id="ecustomerId" />
												<tr>
													<td><spring:message code="label.custName" /><span
														class="required">*</span></td>
													<td><form:input path="ecustomerName"
															cssClass="textbox" onkeyup="AjaxUpdateDuplicate()"
															maxlength="50" /></td>
													<td></td>
													<td></td>
													<td><spring:message code="label.state" /><span
														class="required">*</span></td>
													<td><form:input path="estate" cssClass="textbox"
															maxlength="50" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.cmpName" /><span
														class="required">*</span></td>
													<td><form:input path="ecompanyName" cssClass="textbox"
															maxlength="50" /></td>
													<td></td>
													<td></td>
													<td><spring:message code="label.country" /><span
														class="required">*</span></td>
													<td><form:select path="ecountryId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${countrys}" />
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.custGroup" /><span
														class="required">*</span></td>
													<td><form:select path="ecustomerGroupId"
															cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${custGroupSelect}" />

														</form:select></td>
													<td></td>
													<td></td>
													<td><spring:message code="label.email" /><span
														class="required">*</span></td>
													<td><form:input path="eemail" cssClass="textbox"
															maxlength="30" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.sarea" /><span
														class="required">*</span></td>
													<td><form:select path="esalesAreaId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${salesAreaSelect}" />

														</form:select></td>

													<td></td>
													<td></td>
													<td><spring:message code="label.mobile" /><span
														class="required">*</span></td>
													<td><form:input path="emobile" cssClass="textbox"
															maxlength="12" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.addr" /><span
														class="required">*</span></td>
													<td><form:textarea path="eaddress" cssClass="textbox"
															maxlength="250" /></td>
													<td></td>
													<td></td>
													<td><spring:message code="label.phone" /><span
														class="required"></span></td>
													<td><form:input path="ephone" cssClass="textbox"
															maxlength="12" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.cntperson" /><span
														class="required">*</span></td>
													<td><form:input path="econtactPerson"
															cssClass="textbox" maxlength="50" /></td>

													<td></td>
													<td></td>
													<td><spring:message code="label.zip" /><span
														class="required"></span></td>
													<td><form:input path="ezip" cssClass="textbox"
															maxlength="10" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.cntpersonphn" /><span
														class="required">*</span></td>
													<td><form:input path="econtactPersonPhone"
															cssClass="textbox" maxlength="50" /></td>

													<td></td>
													<td></td>
													<td><spring:message code="label.fax" /><span
														class="required"></span></td>
													<td><form:input path="efax" cssClass="textbox"
															maxlength="15" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.city" /><span
														class="required">*</span></td>
													<td><form:input path="ecity" cssClass="textbox"
															maxlength="30" /></td>
													<td></td>
													<td></td>
													<td><spring:message code="label.custst" /><span
														class="required">*</span></td>
													<td><form:select path="estatusId" cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${statusSelect}" />

														</form:select></td>
												</tr>
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
												code="label.CustomerBankDetails" /></a></li>
									<li><a href="#tab2"><spring:message
												code="label.addcustac" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 100;
											$(function() {

												var nameEdit = $("#bankNameEdit"), addressEdit = $("#bankAddressEdit"), miCodeEdit = $("#micrCodeEdit"), ifCodeEdit = $("#ifscCodeEdit"), accTypeEdit = $("#accountTypeEdit"), accNumberEdit = $("#accountNumberEdit"), hiddenEdit = $("#hiddenIdBankPopUpEdit"),

												allFields = $([]).add(nameEdit)
														.add(addressEdit).add(
																miCodeEdit)
														.add(ifCodeEdit).add(
																accTypeEdit)
														.add(accNumberEdit)
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
												function required(o, n) {
													if (o.val().length == 0) {
														o
																.addClass("ui-state-error");
														updateTips("" + n);
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

												$("#dialog-form-BankEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 300,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");					
																			bValid1 = bValid1
																			&& required(nameEdit,"Bank Name is Required")&&
																			checkRegexp(nameEdit,/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphabet") && checkRegexp(nameEdit,/^([0-9a-zA-Z_& ])*$/i,"Special Characters except &,_ are not allowed");
																					
																	bValid1 = bValid1
																			&& required(addressEdit,"Bank Address Required");
																					
																	bValid1 = bValid1
																			&& required(miCodeEdit,"MICR Code Required")&& checkRegexp(miCodeEdit,/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphanumeric") && checkRegexp(miCodeEdit,/^([0-9a-zA-Z ])*$/i,"Special Characters except &,_ are not allowed");
																					
																					
																	bValid1 = bValid1
																			&& required(ifCodeEdit,"IFSC Code Required")&& checkRegexp(ifCodeEdit,/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphanumeric") && checkRegexp(ifCodeEdit,/^([0-9a-zA-Z ])*$/i,"Special Characters except &,_ are not allowed");
																					
																	bValid1 = bValid1
																			&& required(
																					accTypeEdit,"Account Type Required")&& 
																					checkRegexp(accTypeEdit,/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,"First Letter must be alphabet") && checkRegexp(accTypeEdit,/^([0-9a-zA-Z_& ])*$/i,"Special Characters except &,_ are not allowed");
																	bValid1 = bValid1
																			&& required(accNumberEdit,"Account Number Required")&&
																			 checkRegexp(accNumberEdit,/^([0-9a-zA-Z ])*$/i,"Special Characters are not allowed");

																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddBankEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='customerCmd.ebankName'><input name='ebankName' id='bankNameEdit"
																											+ btrid
																											+ "' value="
																											+ nameEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='customerCmd.ebankAddress'><input name='ebankAddress' id='bankAddressEdit"
																											+ btrid
																											+ "' value="
																											+ addressEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='customerCmd.emicrCode'><input name='emicrCode' id='micrCodeEdit"
																											+ btrid
																											+ "' value="
																											+ miCodeEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='customerCmd.eifscCode'><input name='eifscCode' id='ifscCodeEdit"
																											+ btrid
																											+ "' value="
																											+ ifCodeEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='customerCmd.eaccountType'><input name='eaccountType' id='accountTypeEdit"
																											+ btrid
																											+ "' value="
																											+ accTypeEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='customerCmd.eaccountNumber'><input name='eaccountNumber' id='accountNumberEdit"
																											+ btrid
																											+ "' value="
																											+ accNumberEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind><input type='hidden' name='ecustomerBankDetId' id='vendorBankDetIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																											+
																											// "<td>" + password.val() + "</td>" +
																											"<td><a href='#'  onclick='editBankDetailsInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeBankDetailsEditNew("
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
																						.val() != "0") {

																					$(
																							'#bankNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#bankNameEdit')
																											.val());
																					$(
																							'#bankAddressEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#bankAddressEdit')
																											.val());
																					$(
																							'#micrCodeEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#micrCodeEdit')
																											.val());
																					$(
																							'#ifscCodeEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#ifscCodeEdit')
																											.val());
																					$(
																							'#accountTypeEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#accountTypeEdit')
																											.val());
																					$(
																							'#accountNumberEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#accountNumberEdit')
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

												$("#create-AddBankEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-BankEdit")
																			.dialog(
																					"open");

																});
											});
											function removeBankDetailsEditNew(
													id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editBankDetailsInEditNew(
													link) {
												//alert(link.id);
												$("#dialog-form-BankEdit")
														.dialog("open");
												$('#bankNameEdit').val(
														$(
																'#bankNameEdit'
																		+ link)
																.val());
												$('#bankAddressEdit').val(
														$(
																'#bankAddressEdit'
																		+ link)
																.val());
												$('#micrCodeEdit').val(
														$(
																'#micrCodeEdit'
																		+ link)
																.val());
												$('#ifscCodeEdit').val(
														$(
																'#ifscCodeEdit'
																		+ link)
																.val());
												$('#accountTypeEdit').val(
														$(
																'#accountTypeEdit'
																		+ link)
																.val());
												$('#accountNumberEdit').val(
														$(
																'#accountNumberEdit'
																		+ link)
																.val());

												$('#hiddenIdBankPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-BankEdit"
											title="<spring:message code="label.bankform" />">
											<p class="validateTips" style="color: blue;" align="center">All
												Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="ecustomerBankDetId" value="0" />

												<tr>
													<td><spring:message code="label.bankname" /><span
														class=required>*</span></td>
													<td><form:input path="ebankName" id="bankNameEdit"
															class="textbox" maxlength="50" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.bankaddr" /><span
														class=required>*</span></td>
													<td><form:input path="ebankAddress"
															id="bankAddressEdit" class="textbox" maxlength="150" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.micrcode" /> <span
														class=required>*</span></td>
													<td><form:input path="emicrCode" id="micrCodeEdit"
															class="textbox" maxlength="20" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.ifsccode" /><span
														class=required>*</span></td>
													<td><form:input path="eifscCode" id="ifscCodeEdit"
															class="textbox" maxlength="20" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.acttype" /><span
														class=required>*</span></td>
													<td><form:input path="eaccountType"
															id="accountTypeEdit" class="textbox" maxlength="20" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.actno" /><span
														class=required>*</span></td>
													<td><form:input path="eaccountNumber"
															id="accountNumberEdit" class="textbox" maxlength="25" />
														<input type="hidden" name="hiddenIdBankPopUpEdit"
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

														<th><spring:message code="label.bankname" /></th>
														<th><spring:message code="label.bankaddr" /></th>
														<th><spring:message code="label.acttype" /></th>
														<th><spring:message code="label.actno" /></th>
														<th><spring:message code="label.micrcode" /></th>
														<th><spring:message code="label.ifsccode" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>

													</tr>
												</thead>
												<tbody>

													<c:forEach var="customerBankEditList"
														items="${customerBankEditList}">

														<spring:bind path="customerCmd.ebcustomerId">
															<input type="hidden" name="ebcustomerId"
																value="${customerBankEditList.ebcustomerId}" />
														</spring:bind>
														<spring:bind path="customerCmd.ecustomerBankDetId">
															<input type="hidden" name="ecustomerBankDetId"
																id="ecustomerBankDetId${customerBankEditList.ecustomerBankDetId}"
																value="${customerBankEditList.ecustomerBankDetId}" />
														</spring:bind>

														<tr id="${customerBankEditList.ecustomerBankDetId}">

															<td><spring:bind path="customerCmd.ebankName">
																	<input type="text" name="ebankName" class="textbox"
																		id="bankNameEdit${customerBankEditList.ecustomerBankDetId}"
																		value="${customerBankEditList.ebankName}" readonly />
																</spring:bind></td>

															<td><spring:bind path="customerCmd.ebankAddress">
																	<input type="text" name="ebankAddress" class="textbox"
																		id="bankAddressEdit${customerBankEditList.ecustomerBankDetId}"
																		value="${customerBankEditList.ebankAddress}" readonly />
																</spring:bind></td>
															<td><spring:bind path="customerCmd.eaccountType">
																	<input type="text" name="eaccountType" class="textbox"
																		id="accountTypeEdit${customerBankEditList.ecustomerBankDetId}"
																		value="${customerBankEditList.eaccountType}" readonly />
																</spring:bind></td>
															<td><spring:bind path="customerCmd.eaccountNumber">
																	<input type="text" name="eaccountNumber"
																		id="accountNumberEdit${customerBankEditList.ecustomerBankDetId}"
																		class="textbox"
																		value="${customerBankEditList.eaccountNumber}"
																		readonly />
																</spring:bind></td>
															<td><spring:bind path="customerCmd.emicrCode">
																	<input type="text" name="emicrCode" class="textbox"
																		id="micrCodeEdit${customerBankEditList.ecustomerBankDetId}"
																		value="${customerBankEditList.emicrCode}" readonly />
																</spring:bind></td>
															<td><spring:bind path="customerCmd.eifscCode">
																	<input type="text" name="eifscCode" class="textbox"
																		id="ifscCodeEdit${customerBankEditList.ecustomerBankDetId}"
																		value="${customerBankEditList.eifscCode}" readonly />
																</spring:bind></td>


															<td><a href="#"
																id="${customerBankEditList.ecustomerBankDetId}"
																onclick="javascript:editBankDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${customerBankEditList.ecustomerBankDetId}"></img></a></td>

															<td><a href="#"
																id="${customerBankEditList.ecustomerBankDetId}"
																onclick="javascript:getID1(this.id)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px"
																	id="${customerBankEditList.ecustomerBankDetId}"></img></a>

																<input type="hidden"
																name="checkDelete${customerBankEditList.ecustomerBankDetId}"
																id="${customerBankEditList.ecustomerBankDetId}checkDelete"
																value="0" /></td>

														</tr>

														<script>
															function getID1(
																	link) {
																//alert(link);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link
																				+ "checkDelete").value = "1";
																document
																		.getElementById(link).style.display = "none";
															}
															function editBankDetailsInEdit(
																	link) {
																//alert(""+ link.id);

																$(
																		"#dialog-form-BankEdit")
																		.dialog(
																				"open");
																$(
																		'#bankNameEdit')
																		.val(
																				$(
																						'#bankNameEdit'
																								+ link.id)
																						.val());
																$(
																		'#bankAddressEdit')
																		.val(
																				$(
																						'#bankAddressEdit'
																								+ link.id)
																						.val());
																$(
																		'#micrCodeEdit')
																		.val(
																				$(
																						'#micrCodeEdit'
																								+ link.id)
																						.val());
																$(
																		'#ifscCodeEdit')
																		.val(
																				$(
																						'#ifscCodeEdit'
																								+ link.id)
																						.val());
																$(
																		'#accountTypeEdit')
																		.val(
																				$(
																						'#accountTypeEdit'
																								+ link.id)
																						.val());
																$(
																		'#accountNumberEdit')
																		.val(
																				$(
																						'#accountNumberEdit'
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
										<button id="create-AddBankEdit" type="button">
											<spring:message code="label.newcustbank" />
										</button>

									</div>

								</div>



								<!-- Sub Tab Edit Start -->

								<div id="tab2">
									<div align="center">
										<script>
											var btrid = 40;
											$(function() {

												var acGrEdit = $("#acGroupIdEdit"), recndEdit = $("#reCondIdEdit"), payTermEdit = $("#paymentTermIdEdit"), payMthdEdit = $("#paymentMethodIdEdit"), hiddenEdit = $("#hiddenIdAccountEditPopUpEdit"),

												allFields = $([]).add(acGrEdit)
														.add(recndEdit).add(
																payTermEdit)
														.add(payMthdEdit).add(
																hiddenEdit), tips = $(".validateTips");

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

												$(
														"#dialog-form-CustAccountEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 300,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");

																			bValid1 = bValid1
																					&& requiredEdit(
																							acGrEdit,
																							"Account Group");
																			bValid1 = bValid1
																					&& requiredEdit(
																							recndEdit,
																							"Reconciliation");
																			bValid1 = bValid1
																					&& requiredEdit(
																							payTermEdit,
																							"Payment Term");
																			bValid1 = bValid1
																					&& requiredEdit(
																							payMthdEdit,
																							"Payment Method");

																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {

																					$(
																							"#CustAccountEdit tbody")
																							.append(
																									"<tr id="+btrid+">"

																											+ "<td><input type='hidden' name='eacGroupId' id='acGroupIdEdit"
																											+ btrid
																											+ "' value="
																											+ acGrEdit
																													.val()
																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='acGroupName' id='acGroupNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#acGroupIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><input type='hidden' name='ereCondId' id='reCondIdEdit"
																											+ btrid
																											+ "' value="
																											+ recndEdit
																													.val()
																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='reCondName' id='reCondNameEdit"
																											+ btrid
																											+ "'  value='"
																											+ $(
																													'#reCondIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><input type='hidden' name='epaymentTermId' id='paymentTermIdEdit"
																											+ btrid
																											+ "' value="
																											+ payTermEdit
																													.val()
																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='paymentTermName' id='paymentTermNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#paymentTermIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><input type='hidden' name='epaymentMethodId' id='paymentMethodIdEdit"
																											+ btrid
																											+ "' value="
																											+ payMthdEdit
																													.val()
																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='paymentMethodName' id='paymentMethodNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#paymentMethodIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"
																											+ "<input type='hidden' name='ecustAccountId' id='ecustAccountId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"

																											+ "<td><a href='#'  onclick='editSalesOdrSchInNewEdit("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeCustAccountEditNew("
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
																						.val() != "0") {
																					$(
																							'#acGroupIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#acGroupIdEdit')
																											.val());
																					$(
																							'#acGroupNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#acGroupIdEdit :selected')
																											.text());
																					$(
																							'#reCondIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#reCondIdEdit')
																											.val());
																					$(
																							'#reCondNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#reCondIdEdit :selected')
																											.text());
																					$(
																							'#paymentTermIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#paymentTermIdEdit')
																											.val());
																					$(
																							'#paymentTermNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#paymentTermIdEdit :selected')
																											.text());
																					$(
																							'#paymentMethodIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#paymentMethodIdEdit')
																											.val());
																					$(
																							'#paymentMethodNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#paymentMethodIdEdit :selected')
																											.text());
																					$(
																							'#hiddenIdAccountEditPopUpEdit')
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

												$("#createEditcustAccount")
														.button()
														.click(
																function() {

																	$(
																			"#dialog-form-CustAccountEdit")
																			.dialog(
																					"open");
																	//alert("Open");

																});
											});
											function removeCustAccountEditNew(
													id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editSalesOdrSchInNewEdit(
													link) {
												//alert(link);
												$(
														"#dialog-form-CustAccountEdit")
														.dialog("open");
												$('#acGroupIdEdit').val(
														$(
																'#acGroupIdEdit'
																		+ link)
																.val());
												$('#reCondIdEdit').val(
														$(
																'#reCondIdEdit'
																		+ link)
																.val());
												$('#paymentTermIdEdit').val(
														$(
																'#paymentTermIdEdit'
																		+ link)
																.val());
												$('#paymentMethodIdEdit').val(
														$(
																'#paymentMethodIdEdit'
																		+ link)
																.val());
												$(
														'#hiddenIdAccountEditPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-CustAccountEdit"
											title="<spring:message code="label.custacform"  />">
											<p class="validateTips" align="center" style="color: blue;">All
												Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="ecustAccountId" value="0" />

												<tr>
													<td><spring:message code="label.custacgrid" /> <span
														class=required>*</span></td>
													<td><form:select path="acGroupName" id="acGroupIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${AccGroupSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.custacrecondid" /> <span
														class=required>*</span></td>
													<td><form:select path="reCondName" id="reCondIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${AccGroupSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.custacpt" /> <span
														class=required>*</span></td>
													<td><form:select path="paymentTermName"
															id="paymentTermIdEdit" class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${PaymentTermSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.custacpm" /> <span
														class=required>*</span></td>
													<td><form:select path="paymentMethodName"
															id="paymentMethodIdEdit" class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${PaymentMethodSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><input type="hidden"
														name="hiddenIdAccountEditPopUpEdit"
														id="hiddenIdAccountEditPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>
										<div id="users-CustAccountEdit">
											<table id="CustAccountEdit" class="table">

												<tr>
													<th><spring:message code="label.custacgrid" /></th>
													<th><spring:message code="label.custacrecondid" /></th>
													<th><spring:message code="label.custacpt" /></th>
													<th><spring:message code="label.custacpm" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>

												<c:forEach var="custAccountEditList"
													items="${custAccountEditList}">

													<spring:bind path="customerCmd.ecustAccountId">
														<input type="hidden" name="ecustAccountId"
															id="custAccountId${custAccountEditList.ecustAccountId}"
															value="${custAccountEditList.ecustAccountId}" />
													</spring:bind>
													<tr id="a${custAccountEditList.ecustAccountId}">

														<td><spring:bind path="customerCmd.eacGroupId">
																<input type="hidden" name="eacGroupId"
																	id="acGroupIdEdit${custAccountEditList.ecustAccountId}"
																	class="textbox"
																	value="${custAccountEditList.eacGroupId}" readonly />
															</spring:bind> <spring:bind path="customerCmd.eacGroupName">
																<input type="text" name="eacGroupName"
																	id="acGroupNameEdit${custAccountEditList.ecustAccountId}"
																	class="textbox"
																	value="${custAccountEditList.eacGroupName}" readonly />
															</spring:bind></td>

														<td><spring:bind path="customerCmd.ereCondId">
																<input type="hidden" name="ereCondId" class="textbox"
																	id="reCondIdEdit${custAccountEditList.ecustAccountId}"
																	value="${custAccountEditList.ereCondId}" readonly />
															</spring:bind> <spring:bind path="customerCmd.ereCondName">
																<input type="text" name="ereCondName"
																	id="reCondNameEdit${custAccountEditList.ecustAccountId}"
																	class="textbox"
																	value="${custAccountEditList.ereCondName}" readonly />
															</spring:bind></td>

														<td><spring:bind path="customerCmd.epaymentTermId">
																<input type="hidden" name="epaymentTermId"
																	class="textbox"
																	id="paymentTermIdEdit${custAccountEditList.ecustAccountId}"
																	value="${custAccountEditList.epaymentTermId}" readonly />
															</spring:bind> <spring:bind path="customerCmd.epaymentTermName">
																<input type="text" name="epaymentTermName"
																	id="paymentTermNameEdit${custAccountEditList.ecustAccountId}"
																	class="textbox"
																	value="${custAccountEditList.epaymentTermName}"
																	readonly />
															</spring:bind></td>

														<td><spring:bind path="customerCmd.epaymentMethodId">
																<input type="hidden" name="epaymentMethodId"
																	class="textbox"
																	id="paymentMethodIdEdit${custAccountEditList.ecustAccountId}"
																	value="${custAccountEditList.epaymentMethodId}"
																	readonly />
															</spring:bind> <spring:bind path="customerCmd.epaymentMethodName">
																<input type="text" name="epaymentMethodName"
																	id="paymentMethodNameEdit${custAccountEditList.ecustAccountId}"
																	class="textbox"
																	value="${custAccountEditList.epaymentMethodName}"
																	readonly />
															</spring:bind></td>

														<td><a href="#"
															id="${custAccountEditList.ecustAccountId}"
															onclick="javascript:editCustAccountInEdit(this)"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="edit${custAccountEditList.ecustAccountId}"></img></a></td>
														<td><a href="#"
															id="${custAccountEditList.ecustAccountId}"
															onclick="javascript:getIDAC(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px" id="${custAccountEditList.ecustAccountId}"></img></a>

															<input type="hidden"
															name="checkAccount${custAccountEditList.ecustAccountId}"
															id="${custAccountEditList.ecustAccountId}checkAccount"
															value="0" /></td>
													</tr>

													<script>
														function getIDAC(accId) {
															//alert(accId.id);
															alert("Deleting Particular Row Will Deleted Once You Click Update Button");
															document
																	.getElementById(accId.id
																			+ "checkAccount").value = "1";
															document
																	.getElementById("a"
																			+ accId.id).style.display = "none";
														}
														function editCustAccountInEdit(
																link) {
															//alert(""+ link.id);
															$(
																	"#dialog-form-CustAccountEdit")
																	.dialog(
																			"open");
															$('#acGroupIdEdit')
																	.val(
																			$(
																					'#acGroupIdEdit'
																							+ link.id)
																					.val());
															$('#reCondIdEdit')
																	.val(
																			$(
																					'#reCondIdEdit'
																							+ link.id)
																					.val());
															$(
																	'#paymentTermIdEdit')
																	.val(
																			$(
																					'#paymentTermIdEdit'
																							+ link.id)
																					.val());
															$(
																	'#paymentMethodIdEdit')
																	.val(
																			$(
																					'#paymentMethodIdEdit'
																							+ link.id)
																					.val());
															$(
																	'#hiddenIdAccountEditPopUpEdit')
																	.val(
																			link.id);
														}
													</script>

												</c:forEach>

											</table>
										</div>


										<button id="createEditcustAccount" type="button">
											<spring:message code="label.newaddcustac" />
										</button>

									</div>
								</div>

								<!-- Sub Tab Edit Start -->
							</div>
							<table>
								<tr>
									<td colspan=""><c:choose>
											<c:when test="${update}">
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateid" />
											</c:when>
											<c:otherwise>
												<input type="submit"
													value="<s:message code="label.update"/> "
													class="btn btn-danger" disabled="disabled" id="sumbnid" />
											</c:otherwise>
										</c:choose></td>

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