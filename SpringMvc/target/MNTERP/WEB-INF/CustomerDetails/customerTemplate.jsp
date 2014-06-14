<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addcustomerform')
													.validate(
															{
																rules : {
																	customerName : {
																		required : true

																	},
																	companyName : {
																		required : true

																	},
																	customerGroupId : {
																		required : true
																	},
																	bankName : {
																		required : true
																	},
																	bankAddress : {
																		required : true
																	},
																	accountType : {
																		required : true
																	},
																	accountNumber : {
																		required : true
																	},
																	MICRCode : {
																		required : true
																	},
																	IFSCCode : {
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
																		required : true
																	},

																	contactPersonPhone : {
																		required : true,
																		number : true,
																		minlength : 10
																	},

																	city : {
																		required : true
																	},

																	state : {
																		required : true
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

																},
																messages : {
																	customerName : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	companyName : "<font style='color: red;'><b>Company Name is Required</b></font>",
																	bankName : "<font style='color: red;'><b>Bank Name is Required</b></font>",
																	bankAddress : "<font style='color: red;'><b>Banke Address is Required</b></font>",
																	accountType : "<font style='color: red;'><b>Account Type is Required</b></font>",
																	accountNumber : "<font style='color: red;'><b>Account Number is Required</b></font>",
																	MICRCode : "<font style='color: red;'><b>MICR Code is Required</b></font>",
																	IFSCCode : "<font style='color: red;'><b>IFSC Code is Required</b></font>",
																	salesAreaId : "<font style='color: red;'><b>Sales Area is Required</b></font>",
																	countryId : "<font style='color: red;'><b>Country is Required</b></font>",
																	customerGroupId : "<font style='color: red;'><b>Customer Group is Required</b></font>",
																	address : "<font style='color: red;'><b>Address is Required</b></font>",
																	contactPerson : "<font style='color: red;'><b>Contact Person is Required</b></font>",
																	contactPersonPhone : "<font style='color: red;'><b>Contact Person Phone is Required</b></font>",
																	city : "<font style='color: red;'><b>City is Required</b></font>",
																	state : "<font style='color: red;'><b>State is Required</b></font>",
																	email : "<font style='color: red;'><b>Email is Required And Must be Email Format</b></font>",
																	mobile : "<font style='color: red;'><b>Mobile is Required And Must be Number</b></font>",
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
																		required : true

																	},
																	ecompanyName : {
																		required : true

																	},
																	ecustomerGroupId : {
																		required : true
																	},
																	ebankName : {
																		required : true
																	},
																	ebankAddress : {
																		required : true
																	},
																	eaccountType : {
																		required : true
																	},
																	eaccountNumber : {
																		required : true
																	},
																	eMICRCode : {
																		required : true
																	},
																	eIFSCCode : {
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
																		required : true
																	},

																	econtactPersonPhone : {
																		required : true,
																		number : true,
																		minlength : 10
																	},

																	ecity : {
																		required : true
																	},

																	estate : {
																		required : true
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

																},
																messages : {
																	ecustomerName : "<font style='color: red;'><b>Customer Name is Required</b></font>",
																	ecompanyName : "<font style='color: red;'><b>Company Name is Required</b></font>",
																	ebankName : "<font style='color: red;'><b>Bank Name is Required</b></font>",
																	ebankAddress : "<font style='color: red;'><b>Banke Address is Required</b></font>",
																	eaccountType : "<font style='color: red;'><b>Account Type is Required</b></font>",
																	eaccountNumber : "<font style='color: red;'><b>Account Number is Required</b></font>",
																	eMICRCode : "<font style='color: red;'><b>MICR Code is Required</b></font>",
																	eIFSCCode : "<font style='color: red;'><b>IFSC Code is Required</b></font>",
																	ecustomerGroupId : "<font style='color: red;'><b>Customer Group is Required</b></font>",
																	esalesAreaId : "<font style='color: red;'><b>Sales Area is Required</b></font>",
																	ecountryId : "<font style='color: red;'><b>Country is Required</b></font>",
																	eaddress : "<font style='color: red;'><b>Address is Required</b></font>",
																	econtactPerson : "<font style='color: red;'><b>Contact Person is Required</b></font>",
																	econtactPersonPhone : "<font style='color: red;'><b>Contact Person Phone is Required</b></font>",
																	ecity : "<font style='color: red;'><b>City is Required</b></font>",
																	estate : "<font style='color: red;'><b>State is Required</b></font>",
																	eemail : "<font style='color: red;'><b>Email is Required And Must be Email Format</b></font>",
																	emobile : "<font style='color: red;'><b>Mobile is Required And Must be Number</b></font>",
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

					url : "/MNTERP/checkAddDuplicate.mnt",
					data : "customerName=" + cust,
					success : function(response) {
						if (response != "") {

							document.getElementById("custDuplMessage").style.display = "block";
							$('#custDuplMessage').html(response);

						} else {
							document.getElementById("custDuplMessage").style.display = "none";
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

					url : "/MNTERP/checkUpdateDuplicate.mnt",
					data : "customerName=" + cust + "&cuId=" + id,
					success : function(response) {
						if (response != "") {

							document.getElementById("custUpDuplMessage").style.display = "block";
							$('#custUpDuplMessage').html(response);

						} else {
							document.getElementById("custUpDuplMessage").style.display = "none";
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

		if (document.getElementById("cuId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

		if (document.getElementById("cuEditId").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-1"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnasd').click(function(e) {
			document.getElementById("asId").value = 1;
			//alert(document.getElementById("asId").value);
		});
	});
</script>
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script type="text/javascript"
	src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js">
	
</script>

<script type="text/javascript">
	$(function() {

		var row = '<table border="0" ><tr><td>'
				+ '<table border="0" style="float:left;"><tr><td><spring:bind path="customerCmd.bankName"><input type="text" value="" name="bankName" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.bankAddress"><input type="text" value="" name="bankAddress" class="textbox"></spring:bind></td>'
				+ '<td><spring:bind path="customerCmd.accountType"><input type="text" value="" name="accountType" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.accountNumber"><input type="text" value="" name="accountNumber" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.MICRCode"><input type="text" value="" name="MICRCode" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.IFSCCode"><input type="text" value="" name="IFSCCode" class="textbox"></spring:bind></td>'
				+ '</tr></table>'
				+ '<a href="#"  style="float:left; margin:0px 0 0 5px;" class="removerowe"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
		//fadeIn
		$('#addCust').click(function() {

			$(row).fadeIn("slow").appendTo("#newrow");
			i++;
			return false;

		});

		//fadeout selected item and remove
		$('.removerowe').live('click', function() {
			$(this).parent().fadeOut(300, function() {
				$(this).empty();
				return false;
			});
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
								<td colspan="2"><c:forEach var="addCustsus"
										items="${param.addCustsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${addCustsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateCustsus"
										items="${param.UpdateCustsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${UpdateCustsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteCustsus"
										items="${param.DeleteCustsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${DeleteCustsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- 
							<tr>
								<td><spring:message code="label.custName" /></td>
								<td><form:select path="customerId" Class="select">
										<form:option value="0">--All--</form:option>
										<form:options items="${customerSelect}" />
									</form:select></td>

								<td><input type="submit" value="<spring:message code="label.search"/>"
									class="btn btn-primary"></td>
							</tr> --%>

							<tr>
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
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>

						</table>
					</form:form>
					<c:forEach var="customer" items="${customerList}">
						<c:set var="cust" value="${customer}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${cust!=null }">
							<display:table name="customerList" id="custList" class="table"
								requestURI="customerSearch.mnt" pagesize="5">
								<display:column property="customerId" sortable="true"
									title="customerId" media="none" />
								<display:column property="customerName" sortable="true"
									titleKey="label.custName" media="html" />

								<display:column property="customerGroupId" sortable="true"
									titleKey="label.custGroup" media="html" />
								<display:column property="salesAreaId" sortable="true"
									title="salesAreaId" media="none" />

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
									<a
										href="customerEdit.mnt?customerId=<c:out value="${custList.customerId}"/> "><img
										src="images/Edit.jpg" width="20px" height="20px" /></a>
								</display:column>
								<display:column titleKey="label.delete">
									<a
										href="customerDelete.mnt?customerId=<c:out value="${custList.customerId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" />

							</display:table>
						</c:when>

						<c:otherwise>

							<%-- <h3 style="color:red"><c:out value="No Data Found"></c:out></h3> --%>

						</c:otherwise>
					</c:choose>
				</div>

			</div>

			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" class="alert-warning" id="custDuplMessage"
								style="display: none; width: 420px; height: 25px; color: red"></td>
						</tr>
					</table>
					<form:form action="customerAdd.mnt" method="POST"
						commandName="customerCmd" id="addcustomerform">
						<table class="tableGeneral">
							<tr>
								<td>

									<table class="tableGeneral">
										<%-- <tr>
											<td colspan="2"><c:forEach var="customerDuplicate"
													items="${customerDuplicate}">
													<div class="alert-warning" id="savemessage">
														<font color="red"><c:out
																value="${customerDuplicate}"></c:out></font>
													</div>
												</c:forEach></td>
										</tr> --%>
										<form:hidden path="cuId" />
										<form:hidden path="status" />
										<tr>
											<td><spring:message code="label.custName" /><span
												class="required">*</span></td>
											<td><form:input path="customerName" id="customerName"
													cssClass="textbox" onkeyup="AjaxForDuplicate()" /></td>
											<td></td>
											<td></td>
											<td><spring:message code="label.state" /><span
												class="required">*</span></td>
											<td><form:input path="state" cssClass="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.cmpName" /><span
												class="required">*</span></td>
											<td><form:input path="companyName" cssClass="textbox" /></td>
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
											<td><form:input path="email" cssClass="textbox" /></td>
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
											<td><form:input path="mobile" cssClass="textbox" /></td>
										</tr>


										<tr>
											<td><spring:message code="label.addr" /><span
												class="required">*</span></td>
											<td><form:input path="address" cssClass="textbox" /></td>
											<td></td>
											<td></td>
											<td><spring:message code="label.phone" /></td>
											<td><form:input path="phone" cssClass="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.cntperson" /><span
												class="required">*</span></td>
											<td><form:input path="contactPerson" cssClass="textbox" /></td>
											<td></td>
											<td></td>

											<td><spring:message code="label.zip" /></td>
											<td><form:input path="zip" cssClass="textbox" /></td>
										</tr>

										<tr>
											<td><spring:message code="label.cntpersonphn" /><span
												class="required">*</span></td>
											<td><form:input path="contactPersonPhone"
													cssClass="textbox" /></td>
											<td></td>
											<td></td>
											<td><spring:message code="label.fax" /></td>
											<td><form:input path="fax" cssClass="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.city" /><span
												class="required">*</span></td>
											<td><form:input path="city" cssClass="textbox" /></td>
										</tr>

									</table>

								</td>

							</tr>

						</table>

						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message
											code="label.CustomerBankDetails" /></a></li>

							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1">
								<div align="left">
									<table class="">
										<tr>
											<th><spring:message code="label.bankname" /><span
												class=required>*</span></th>
											<th><spring:message code="label.bankaddr" /><span
												class=required>*</span></th>
											<th><spring:message code="label.acttype" /><span
												class=required>*</span></th>
											<th><spring:message code="label.actno" /><span
												class=required>*</span></th>
											<th><spring:message code="label.micrcode" /> <span
												class=required>*</span></th>
											<th><spring:message code="label.ifsccode" /><span
												class=required>*</span></th>
										</tr>

										<c:forEach var="custBankList" items="${custBankList}">
											<tr>

												<td><spring:bind path="customerCmd.bankName">
														<input type="text" name="bankName" class="textbox"
															value="${custBankList.bankName}" />
													</spring:bind></td>

												<td><spring:bind path="customerCmd.bankAddress">
														<input type="text" name="bankAddress" class="textbox"
															value="${custBankList.bankAddress}" />
													</spring:bind></td>
												<td><spring:bind path="customerCmd.accountType">
														<input type="text" name="accountType" class="textbox"
															value="${custBankList.accountType}" />
													</spring:bind></td>
												<td><spring:bind path="customerCmd.accountNumber">
														<input type="text" name="accountNumber" class="textbox"
															value="${custBankList.accountNumber}" />
													</spring:bind></td>
												<td><spring:bind path="customerCmd.MICRCode">
														<input type="text" name="MICRCode" class="textbox"
															value="${custBankList.MICRCode}" />
													</spring:bind></td>
												<td><spring:bind path="customerCmd.IFSCCode">
														<input type="text" name="IFSCCode" class="textbox"
															value="${custBankList.MICRCode}" />
													</spring:bind></td>

												<td><a href="#" id="addCuste"><img
														src="images/add (1).png"></img> </a></td>
											</tr>

										</c:forEach>

										<c:forEach var="custBankList" items="${custBankList}">
											<c:set var="duplicate" value="${custBankList}"></c:set>
										</c:forEach>

										<c:if test="${duplicate==null }">

											<tr class="">
												<td><form:input path="bankName" cssClass="textbox" /></td>
												<td><form:input path="bankAddress" cssClass="textbox" /></td>
												<td><form:input path="accountType" cssClass="textbox" /></td>
												<td><form:input path="accountNumber" cssClass="textbox" /></td>
												<td><form:input path="MICRCode" cssClass="textbox" /></td>
												<td><form:input path="IFSCCode" cssClass="textbox" /></td>
												<td><a href="#" id="addCust"><img
														src="images/add (1).png"></img> </a></td>
											</tr>
										</c:if>

										<tr>


										</tr>

									</table>
									<div id="newrow"></div>
									<table>
										<tr>
											<td colspan="2"><input type="submit"
												value="<spring:message code="label.save"/>" id="submitid"
												class="btn btn-primary" /><input type="reset"
												value="<spring:message code="label.reset"/>"
												class="btn btn-primary" /></td>
										</tr>
									</table>

								</div>
							</div>

						</div>

						<!-- window 2 -->

					</form:form>
				</div>
			</div>

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" class="alert-warning" id="custUpDuplMessage"
								style="display: none; width: 420px; height: 25px; color: red"></td>
						</tr>
					</table>
					<form:form method="post" action="customerUpdate.mnt"
						commandName="customerCmd" id="editcustomerForm">
						<c:forEach var="customerEditList" items="${customerEditList}">
							<c:set var="edit" value="${customerEditList}"></c:set>
						</c:forEach>

						<c:if test="${edit!=null}">
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
												<form:hidden path="estatus" />
												<form:hidden path="ecustomerId" id="ecustomerId" />
												<tr>
													<td><spring:message code="label.custName" /><span
														class="required">*</span></td>
													<td><form:input path="ecustomerName"
															cssClass="textbox" onkeyup="AjaxUpdateDuplicate()"/></td>
													<td></td>
													<td></td>
													<td><spring:message code="label.state" /><span
														class="required">*</span></td>
													<td><form:input path="estate" cssClass="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.cmpName" /><span
														class="required">*</span></td>
													<td><form:input path="ecompanyName" cssClass="textbox" /></td>
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
													<td><form:input path="eemail" cssClass="textbox" /></td>
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
													<td><form:input path="emobile" cssClass="textbox" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.addr" /><span
														class="required">*</span></td>
													<td><form:input path="eaddress" cssClass="textbox" /></td>
													<td></td>
													<td></td>
													<td><spring:message code="label.phone" /><span
														class="required"></span></td>
													<td><form:input path="ephone" cssClass="textbox" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.cntperson" /><span
														class="required">*</span></td>
													<td><form:input path="econtactPerson"
															cssClass="textbox" /></td>

													<td></td>
													<td></td>
													<td><spring:message code="label.zip" /><span
														class="required"></span></td>
													<td><form:input path="ezip" cssClass="textbox" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.cntpersonphn" /><span
														class="required">*</span></td>
													<td><form:input path="econtactPersonPhone"
															cssClass="textbox" /></td>

													<td></td>
													<td></td>
													<td><spring:message code="label.fax" /><span
														class="required"></span></td>
													<td><form:input path="efax" cssClass="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.city" /><span
														class="required">*</span></td>
													<td><form:input path="ecity" cssClass="textbox" /></td>
												</tr>
											</table>
										</div>
									</td>
									<td></td>

								</tr>

							</table>

							<!-- window 2 -->

							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.CustomerBankDetails" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="left">

										<table>
											<tr>
												<th><spring:message code="label.bankname" /><span
													class=required>*</span></th>
												<th><spring:message code="label.bankaddr" /><span
													class=required>*</span></th>
												<th><spring:message code="label.acttype" /><span
													class=required>*</span></th>
												<th><spring:message code="label.actno" /><span
													class=required>*</span></th>
												<th><spring:message code="label.micrcode" /> <span
													class=required>*</span></th>
												<th><spring:message code="label.ifsccode" /><span
													class=required>*</span></th>
											</tr>

											<c:forEach var="customerBankEditList"
												items="${customerBankEditList}">

												<spring:bind path="customerCmd.ebcustomerId">
													<input type="hidden" name="ebcustomerId"
														value="${customerBankEditList.ebcustomerId}" />
												</spring:bind>
												<spring:bind path="customerCmd.ecustomerBankDetId">
													<input type="hidden" name="ecustomerBankDetId"
														value="${customerBankEditList.ecustomerBankDetId}" />
												</spring:bind>
												<tr>

													<td><spring:bind path="customerCmd.ebankName">
															<input type="text" name="ebankName" class="textbox"
																value="${customerBankEditList.ebankName}" />
														</spring:bind></td>

													<td><spring:bind path="customerCmd.ebankAddress">
															<input type="text" name="ebankAddress" class="textbox"
																value="${customerBankEditList.ebankAddress}" />
														</spring:bind></td>
													<td><spring:bind path="customerCmd.eaccountType">
															<input type="text" name="eaccountType" class="textbox"
																value="${customerBankEditList.eaccountType}" />
														</spring:bind></td>
													<td><spring:bind path="customerCmd.eaccountNumber">
															<input type="text" name="eaccountNumber" class="textbox"
																value="${customerBankEditList.eaccountNumber}" />
														</spring:bind></td>
													<td><spring:bind path="customerCmd.emicrCode">
															<input type="text" name="emicrCode" class="textbox"
																value="${customerBankEditList.emicrCode}" />
														</spring:bind></td>
													<td><spring:bind path="customerCmd.eifscCode">
															<input type="text" name="eifscCode" class="textbox"
																value="${customerBankEditList.eifscCode}" />
														</spring:bind></td>

													<td><a href="#" id="addCuste"><img
															src="images/add (1).png"></img> </a></td>
												</tr>
												<c:set var="data" value="${customerBankEditList }"></c:set>

											</c:forEach>
											<c:if test="${data==null}">

												<tr>
													<spring:bind path="customerCmd.ecustomerBankDetId">
														<input type="hidden" name="ecustomerBankDetId" value="0" />
													</spring:bind>
													<td><form:input path="ebankName" cssClass="textbox" /></td>
													<td><form:input path="ebankAddress" cssClass="textbox" /></td>
													<td><form:input path="eaccountType" cssClass="textbox" /></td>
													<td><form:input path="eaccountNumber"
															cssClass="textbox" /></td>
													<td><form:input path="emicrCode" cssClass="textbox" /></td>
													<td><form:input path="eifscCode" cssClass="textbox" /></td>
													<td><a href="#" id="addCuste"><img
															src="images/add (1).png"></img> </a></td>
												</tr>

											</c:if>
											<tr>
												<script src="js/jquery-1.7.2.js"></script>
												<script src="js/jquery-ui.js"></script>
												<script type="text/javascript"
													src="js/jquery.validate.min.js"></script>
												<script type="text/javascript">
													$(function() {

														var row = '<table border="0"><tr><td>'
																+ '<table border="0" style="float:left;"><tr><spring:bind path="customerCmd.ecustomerBankDetId"><input type="hidden" name="ecustomerBankDetId" value="0"/></spring:bind><spring:bind path="customerCmd.ebcustomerId"><input type="hidden" name="ebcustomerId" value="0"/></spring:bind><td><spring:bind path="customerCmd.ebankName"><input type="text" value="" name="ebankName" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.ebankAddress"><input type="text" value="" name="ebankAddress" class="textbox"></spring:bind></td>'
																+ '<td><spring:bind path="customerCmd.eaccountType"><input type="text" value="" name="eaccountType" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.eaccountNumber"><input type="text" value="" name="eaccountNumber" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.emicrCode"><input type="text" value="" name="emicrCode" class="textbox"></spring:bind></td><td><spring:bind path="customerCmd.eifscCode"><input type="text" value="" name="eifscCode" class="textbox"></spring:bind></td>'
																+ '</tr></table>'
																+ '<a href="#"  style="float:left; margin:0px 0 0 5px;" class="removerowe"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
														//fadeIn
														$('#addCuste')
																.click(
																		function() {

																			$(
																					row)
																					.fadeIn(
																							"slow")
																					.appendTo(
																							"#newrowe");
																			i++;
																			return false;

																		});

														//fadeout selected item and remove
														$('.removerowe')
																.live(
																		'click',
																		function() {
																			$(
																					this)
																					.parent()
																					.fadeOut(
																							300,
																							function() {
																								$(
																										this)
																										.empty();
																								return false;
																							});
																		});

													});
												</script>

											</tr>

										</table>

										<div id="newrowe"></div>

										<table>
											<tr>
												<td colspan="2"><input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateid" /></td>

											</tr>
										</table>

									</div>
								</div>
							</div>
						</c:if>
						<!-- window 2 -->
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>