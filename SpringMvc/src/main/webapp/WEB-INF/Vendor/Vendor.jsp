<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
<link rel="stylesheet"
	href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumbnid')
								.click(
										function(event) {

											$('#vendorAdd')
													.validate(
															{
																rules : {

																	blocked : {
																		required : true
																	},
																	vendGroupId : {
																		required : true
																	},
																	country : {
																		required : true
																	},
																	vendorName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	address : {
																		required : true
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
																	country : {
																		required : true
																	},
																	phone : {
																		required : true,
																		number : true
																	},
																	mobile : {
																		required : true,
																		number : true
																	},

																	serviceTaxNo : {
																		required : true
																	},
																	fax : {
																		required : true
																	},
																	zip : {
																		required : true
																	},
																	email : {
																		required : true,
																		email : true
																	},
																	tinNo : {
																		required : true
																	},
																	panNo : {
																		required : true
																	},
																	vatNo : {
																		required : true
																	},
																	statusId : {
																		required : true
																	}

																},
																messages : {
																	vendorName : {
																		required : "<font style='color: red;'><b>Vendor Name is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	address : "<font style='color: red;'><b>Address is Required</b></font>",
																	city : {
																		required : "<font style='color: red;'><b>City is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	state : {
																		required : "<font style='color: red;'><b>State is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	country : "<font style='color: red;'><b>Country is Required</b></font>",
																	mobile : {
																		required : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Only Numbers</b></font>"
																	},
																	phone : {
																		required : "<font style='color: red;'><b>Phone is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Only Numbers</b></font>"
																	},
																	fax : "<font style='color: red;'><b>Fax is Required</b></font>",
																	zip : "<font style='color: red;'><b>Zip Code is Required</b></font>",
																	email : {
																		required : "<font style='color: red;'><b>Email is Required</b></font>",
																		email : "<font style='color: red;'><b>Email must be Email Format</b></font>"
																	},
																	tinNo : "<font style='color: red;'><b>Tin no is Required</b></font>",
																	panNo : "<font style='color: red;'><b>Pan no is Required</b></font>",
																	vatNo : "<font style='color: red;'><b>Vat no is Required</b></font>",
																	serviceTaxNo : "<font style='color: red;'><b>Service Tax No is Required</b></font>",
																	/* customerId:"<font style='color: red;'><b>Customer Name is Required</b></font>", */
																	blocked : "<font style='color: red;'><b>Blocked is Required</b></font>",
																	vendGroupId : "<font style='color: red;'><b>Vendor Group is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},

															});

										});

					});

	$(document)
			.ready(
					function() {

						$('#updatebtn')
								.click(
										function(event) {

											$('#updateForm2')
													.validate(
															{

																rules : {

																	vendorNameEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	addressEdit : {
																		required : true
																	},
																	cityEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	stateEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	countryEdit : {
																		required : true
																	},
																	phoneEdit : {
																		required : true,
																		number : true
																	},
																	mobileEdit : {
																		required : true,
																		number : true
																	},
																	serviceTaxNoEdit : {
																		required : true
																	},
																	emailEdit : {
																		required : true,
																		email : true
																	},
																	tinNoEdit : {
																		required : true
																	},
																	panNoEdit : {
																		required : true
																	},
																	vatNoEdit : {
																		required : true
																	},
																	blockedEdit : {
																		required : true
																	},
																	vendGroupIdEdit : {
																		required : true
																	},

																},
																messages : {

																	vendorNameEdit : {
																		required : "<font style='color: red;'><b>Vendor Name is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	addressEdit : "<font style='color: red;'><b>Address is Required</b></font>",
																	cityEdit : {
																		required : "<font style='color: red;'><b>City is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	stateEdit : {
																		required : "<font style='color: red;'><b>State is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},

																	mobileEdit : {
																		required : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Only Numbers</b></font>"
																	},
																	phoneEdit : {
																		required : "<font style='color: red;'><b>Phone Number is Required</b></font>",
																		number : "<font style='color: red;'><b>It Allows Only Numbers</b></font>"
																	},
																	emailEdit : {
																		required : "<font style='color: red;'><b>Email is Required</b></font>",
																		email : "<font style='color: red;'><b>Email must be Email Format</b></font>"
																	},
																	tinNoEdit : "<font style='color: red;'><b>Tin no is Required</b></font>",
																	panNoEdit : "<font style='color: red;'><b>Pan no is Required</b></font>",
																	vatNoEdit : "<font style='color: red;'><b>Vat no is Required</b></font>",
																	serviceTaxNoEdit : "<font style='color: red;'><b>Service Tax No is Required</b></font>",
																	blockedEdit : "<font style='color: red;'><b>Blocked is Required</b></font>",
																	vendGroupIdEdit : "<font style='color: red;'><b>Vendor Group is Required</b></font>",
																	countryEdit : "<font style='color: red;'><b>Country is Required</b></font>",

																},

															});

										});

					});
</script>
<script>
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#basicSearchId').focus();
			$('#vendorNameAdd').focus();
			$('#edit').hide();
			$('#tabs-1').hide();
			$('#statusId').val("");
			$('#successmessage').hide();
			$('#savemessage').hide();

		});

	});
</script>
<script>
	$(function() {
		$("#tabs").tabs();
	});

	$(function() {
		$("#tabs1").tabs();
	});
	$(function() {
		$("#tabs2").tabs();
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
		if (document.getElementById("vendorAddDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
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

	function doAjaxPost() {
		var vendorName = $('#vendorNameAdd').val();
		//alert(vendorName);
		$
				.ajax({
					type : "POST",
					url : "vendorNameCheck.mnt",
					data : "vendorName=" + vendorName,
					success : function(response) {
						//var checkResponse="Warning ! @Vendor@ Duplicate values are not allowed";
						if (response != "") {
							document.getElementById("vendorDuplicateMess").style.display = "block";
							//$('#vendorDuplicateMess').html("Warning ! Vendor Name aleardy exists. Please try some other name");
							$('#sumbnid').hide();
						} else {
							document.getElementById("vendorDuplicateMess").style.display = "none";
							$('#sumbnid').show();
						}
					},
					error : function(e) {
						//alert('Error: ' + e);
					}

				});
	}

	function doAjaxPostEdit() {
		var vendorNameEdit = $('#vendorNameEdit').val();
		var vendorIdEdit = $('#vendorIdEdit').val();
		$
				.ajax({
					type : "POST",
					url : "vendorNameCheckEdit.mnt",
					data : "vendorNameEdit=" + vendorNameEdit
							+ "&vendorIdEdit=" + vendorIdEdit,
					success : function(response) {
						// we have the response
						var checkResponse = "Warning ! @Vendor@ Duplicate values are not allowed";
						if (checkResponse == response) {
							document.getElementById("vendorDuplicateMessEdit").style.display = "block";
							//$('#vendorDuplicateMessEdit').html(response);
							$('#updatebtn').hide();

						} else {
							document.getElementById("vendorDuplicateMessEdit").style.display = "none";
							$('#updatebtn').show();
						}

					},

					error : function(e) {

						//	alert('Error: ' + e);

					}

				});
	}
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Vendor Details</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vendorValues" items="${vendorValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<table class="tableGeneral">
						<tr>
							<td height="35px" colspan="5"><input type="hidden"
								name="search" /> <c:forEach var="vendorUpadted"
									items="${param.list}">
									<div class="alert-success" id="savemessage">
										<strong><s:message code="label.success" /> </strong>
										<s:message code="label.vendor" />
										<s:message code="label.saveSuccess" />
									</div>
								</c:forEach> <c:forEach var="vendorUpadted" items="${param.listwar}">
									<div class="alert-danger">
										<strong><s:message code="label.error" /> </strong>
										<s:message code="label.vendor" />
										<s:message code="label.saveFail" />
									</div>
								</c:forEach> <c:forEach items="${vendorUpadte}">
									<div class="alert-success">
										<strong><s:message code="label.success" /> </strong>
										<s:message code="label.vendor" />
										<s:message code="label.updateSuccess" />
									</div>
								</c:forEach> <c:forEach items="${vendorUpadteError}">
									<div class="alert-danger">
										<strong><s:message code="label.error" /> </strong>
										<s:message code="label.vendor" />
										<s:message code="label.updateFail" />
									</div>
								</c:forEach> <c:forEach items="${vendorDelete}">
									<div class="alert-success">
										<strong><s:message code="label.success" /> </strong>
										<s:message code="label.vendor" />
										<s:message code="label.deleteSuccess" />
									</div>
								</c:forEach> <c:forEach items="${vendorDeleteError}">
									<div class="alert-danger">
										<strong><s:message code="label.error" /> </strong>
										<s:message code="label.vendor" />
										<s:message code="label.deleteFail" />
									</div>
								</c:forEach></td>
						</tr>

						<form:form action="vendorSearch.mnt" method="get"
							commandName="vendorForm">

							<tr id="mainSearch">
								<td><s:message code="label.searchby" />
								<form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" id="basicSearchId" cssClass="textbox" /></td>
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
								<c:choose>
									<c:when test="${search}">
										<td><input type="submit"
											value="<s:message code="label.search"/>"
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" disabled="disabled"
											value="<s:message code="label.search"/>"
											class="btn btn-danger" /></td>
									</c:otherwise>
								</c:choose>
							</tr>

						</form:form>

						<form:form action="vendorAdvanceSearch.mnt" method="get"
							commandName="vendorForm" name="advanceSearchFinal">
							<tr>
								<td><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue"><u><b><s:message
														code="label.advanceSearchPO" /></b></u></font></a> <a href="#"
									id="basicSearch" style="display: none"><font
										style="color: blue"><u><b><s:message
														code="label.backToBasicSearchPO" /></b></u></font></a></td>
							</tr>
						</form:form>
					</table>



					<form:form action="vendorAdvanceSearchOperations.mnt"
						commandName="vendorForm">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${vendorSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1" cssClass="select">
												<%-- <form:option value="0">-Select-</form:option> --%>
												<form:option value="=">Equals To</form:option>
												<form:option value="!=">Not Equals To</form:option>
												<form:option value="_%">BeginsWith</form:option>
												<form:option value="%_">EndsWith</form:option>
												<form:option value="%_%">Contains</form:option>
											</form:select></td>
										<td><form:input path="advanceSearchText"
												id="advanceSearch" cssClass="textbox"/></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3"><c:choose>
											<c:when test="${search}">
												<input type="submit" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-primary" />
											</c:when>
											<c:otherwise>
												<td><input type="submit" disabled="disabled"
													value="<s:message code="label.search"/>"
													class="btn btn-danger" /></td>
											</c:otherwise>
										</c:choose></td>
								</tr>
								<%-- <tr>
								<td><s:message code="label.assetType" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="0">-Select-</form:option>
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>  --%>
							</table>

						</div>
					</form:form>

					<c:if test="${vendorSearch!=null}">
						<div class="scroll">
							<display:table id="vendorRow" name="vendorSearch"
								requestURI="vendorSearch.mnt" pagesize="5" class="table">

								<display:column property="customerId" titleKey="label.custid"
									media="none" sortable="true" />
								<display:column property="vendorName" titleKey="label.vendname"
									media="html" sortable="true" />
								<display:column property="address" titleKey="label.vaddress"
									sortable="true" media="none" />
								<display:column property="city" titleKey="label.vcity"
									sortable="true" />
								<display:column property="state" titleKey="label.vstate"
									sortable="true" />
								<display:column property="country" titleKey="label.vcountry"
									sortable="true" />
								<display:column property="zip" titleKey="label.vzip"
									sortable="true" />
								<display:column property="email" titleKey="label.vemail"
									media="html" sortable="true" />
								<display:column property="phone" titleKey="label.phno"
									sortable="true" media="html" />
								<display:column property="fax" titleKey="label.vfax"
									sortable="true" />
								<display:column property="mobile" titleKey="label.mobile"
									sortable="true" />
								<display:column property="vendGroupId" titleKey="label.vendgrid"
									media="html" sortable="true" />
								<display:column property="blocked" titleKey="label.blocked"
									sortable="true" />
								<display:column property="tinNo" titleKey="label.tinno"
									sortable="true" />
								<display:column property="panNo" titleKey="label.panno"
									sortable="true" />
								<display:column property="vatNo" titleKey="label.vatno"
									sortable="true" />
								<display:column property="serviceTaxNo"
									titleKey="label.sertaxno" media="html" sortable="true" />

								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${edit }">
											<a
												href="vendorEdit.mnt?vendorEdit=<c:out value="${vendorRow.vendorId}"/>"
												style="color: red"><img src="images/Edit.jpg"
												title="Edit" width="20px" height="20px" /> </a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Edit.jpg" width="20px" height="20px"
												class="btn btn-danger" /></a>
										</c:otherwise>
									</c:choose>
								</display:column>

								<display:column titleKey="label.delete">
									<c:choose>
										<c:when test="${delete}">
											<a
												href="vendorDelete.mnt?vendorDelete=<c:out value="${vendorRow.vendorId}"/>"
												style="color: red"><img src="images/Delete.jpg"
												title="Delete" width="20px" height="20px" /></a>
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
									value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
							</display:table>
						</div>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" id="vendorDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <s:message code="label.warning" /></strong>
									<s:message code="label.vendname" />
									<s:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="vendorAdd.mnt" method="POST"
						commandName="vendorForm" ENCTYPE="multipart/form-data"
						id="vendorAdd" name="formDD">
						<table class="tableGeneral">

							<form:hidden path="vendorAddDuplicate" />
							<tr>

								<td><s:message code="label.vendname" /><span
									class="required">*</span></td>
								<td><form:input path="vendorName" id="vendorNameAdd"
										class="textbox" onkeyup="doAjaxPost()" maxlength="50" /></td>
								<td><s:message code="label.custid" /></td>
								<td><form:select path="customerId" id="customerId"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${customerIdDetails}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.vaddress" /><span
									class="required">*</span></td>
								<td><form:textarea path="address" id="Address"
										class="textbox" /></td>
								<td><s:message code="label.panno" /><span class="required">*</span></td>
								<td><form:input path="panNo" id="PanNo" class="textbox"
										maxlength="30" /></td>

							</tr>
							<tr>
								<td><s:message code="label.vcity" /><span class="required">*</span></td>
								<td><form:input path="city" id="City" class="textbox"
										maxlength="30" /></td>
								<td><s:message code="label.vzip" /><span class="required">*</span></td>
								<td><form:input path="zip" id="Zip" class="textbox"
										maxlength="10" /></td>


							</tr>
							<tr>
								<td><s:message code="label.vstate" /><span
									class="required">*</span></td>
								<td><form:input path="state" id="State" class="textbox"
										maxlength="30" /></td>
								<td><s:message code="label.sertaxno" /><span
									class="required">*</span></td>
								<td><form:input path="serviceTaxNo" id="ServiceTaxNo"
										class="textbox" maxlength="20" /></td>

							</tr>
							<tr>
								<td><s:message code="label.vcountry" /><span
									class="required">*</span></td>
								<td><form:select path="country" id="Country" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${country}" />
									</form:select></td>
								<td><s:message code="label.vfax" /><span class="required">*</span></td>
								<td><form:input path="fax" id="Fax" class="textbox"
										maxlength="15" /></td>


							</tr>
							<tr>
								<td><s:message code="label.vemail" /><span
									class="required">*</span></td>
								<td><form:input path="email" id="Email" class="textbox"
										maxlength="40" /></td>
								<td><s:message code="label.tinno" /><span class="required">*</span></td>
								<td><form:input path="tinNo" id="TinNo" class="textbox"
										maxlength="20" /></td>


							</tr>
							<tr>
								<td><s:message code="label.phone" /><span class="required">*</span></td>
								<td><form:input path="phone" id="Phone" class="textbox"
										maxlength="12" /></td>
								<td><s:message code="label.vatno" /><span class="required">*</span></td>
								<td><form:input path="vatNo" id="VatNo" class="textbox"
										maxlength="20" /></td>


							</tr>
							<tr>
								<td><s:message code="label.mobile" /><span
									class="required">*</span></td>
								<td><form:input path="mobile" id="Mobile" class="textbox"
										maxlength="12" /></td>
								<td><s:message code="label.blocked" /><span
									class="required">*</span></td>
								<td><form:select path="blocked" id="Blocked" class="select">
										<form:option value="">--Select--</form:option>
										<form:option value="1">YES</form:option>
										<form:option value="2">NO</form:option>

									</form:select></td>

							</tr>
							<tr>
								<td><s:message code="label.vendgrid" /><span
									class="required">*</span></td>
								<td><form:select path="vendGroupId" id="vendGroupId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${vendorGroupIdDetails}" />
									</form:select></td>
								<td><s:message code="label.statusId" /><span
									class="required">*</span></td>
								<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${statusId}" />
									</form:select></td>
							</tr>
						</table>
						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11"><s:message
											code="label.BankDetailsv" /></a></li>
								<li><a href="#tabs-21"><s:message
											code="label.Documentsv" /></a></li>
								<li><a href="#tabs-31"><s:message
											code="label.Materialv" /></a></li>
								<li><a href="#tabs-41"><s:message
											code="label.VendorAccounts" /></a></li>
							</ul>
							<div id="tabs-11">
								<div align="center">

									<script>
										var btrid = 1;
										$(function() {

											var name = $("#bankName"), address = $("#bankAddress"), micrCode = $("#micrCode"), ifscCode = $("#ifscCode"), accountType = $("#accountType"), accountNumber = $("#accountNumber"), hiddenID = $("#hiddenIdBankPopUp"), allFields = $(
													[]).add(name).add(address)
													.add(micrCode)
													.add(ifscCode).add(
															accountType).add(
															accountNumber).add(
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
																				&& required(
																						name,
																						"Bank Name is Required")
																				&& checkRegexp(
																						name,
																						/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																						"First Letter must be alphabet")
																				&& checkRegexp(
																						name,
																						/^([0-9a-zA-Z_& ])*$/i,
																						"Special Characters except &,_ are not allowed");

																		bValid = bValid
																				&& required(
																						address,
																						"Bank Address Required");

																		bValid = bValid
																				&& required(
																						micrCode,
																						"MICR Code Required")
																				&& checkRegexp(
																						micrCode,
																						/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																						"First Letter must be alphanumeric")
																				&& checkRegexp(
																						micrCode,
																						/^([0-9a-zA-Z ])*$/i,
																						"Special Characters except &,_ are not allowed");

																		bValid = bValid
																				&& required(
																						ifscCode,
																						"IFSC Code Required")
																				&& checkRegexp(
																						ifscCode,
																						/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																						"First Letter must be alphanumeric")
																				&& checkRegexp(
																						ifscCode,
																						/^([0-9a-zA-Z ])*$/i,
																						"Special Characters except &,_ are not allowed");

																		bValid = bValid
																				&& required(
																						accountType,
																						"Account Type Required")
																				&& checkRegexp(
																						accountType,
																						/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																						"First Letter must be alphabet")
																				&& checkRegexp(
																						accountType,
																						/^([0-9a-zA-Z_& ])*$/i,
																						"Special Characters except &,_ are not allowed");
																		bValid = bValid
																				&& required(
																						accountNumber,
																						"Account Number Required")
																				&& checkRegexp(
																						accountNumber,
																						/^([0-9a-zA-Z ])*$/i,
																						"Special Characters are not allowed");

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
																										+ "<td ><s:bind path='vendorForm.bankName'><input name='bankName' id='bankName"
																										+ btrid
																										+ "' value="
																										+ name
																												.val()
																										+ " class='textbox' readonly /></s:bind>  </td>"
																										+ "<td><s:bind path='vendorForm.bankAddress'><input name='bankAddress' id='bankAddress"
																										+ btrid
																										+ "' value="
																										+ address
																												.val()
																										+ " class='textbox' readonly/></s:bind> </td>"
																										+ "<td><s:bind path='vendorForm.micrCode'><input name='micrCode' id='micrCode"
																										+ btrid
																										+ "' value="
																										+ micrCode
																												.val()
																										+ " class='textbox' readonly/></s:bind></td>"
																										+ "<td><s:bind path='vendorForm.ifscCode'><input name='ifscCode' id='ifscCode"
																										+ btrid
																										+ "' value="
																										+ ifscCode
																												.val()
																										+ " class='textbox' readonly/></s:bind></td>"
																										+ "<td><s:bind path='vendorForm.accountType'><input name='accountType' id='accountType"
																										+ btrid
																										+ "' value="
																										+ accountType
																												.val()
																										+ " class='textbox' readonly/></s:bind></td>"
																										+ "<td><s:bind path='vendorForm.accountNumber'><input name='accountNumber' id='accountNumber"
																										+ btrid
																										+ "' value="
																										+ accountNumber
																												.val()
																										+ " class='textbox'/></s:bind></td>"
																										+

																										// "<td>" + password.val() + "</td>" +
																										"<td><a href='#'  onclick='editMaterialm("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeMaterialm("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
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
																						'#micrCode'
																								+ hiddenID
																										.val())
																						.val(
																								micrCode
																										.val());
																				$(
																						'#ifscCode'
																								+ hiddenID
																										.val())
																						.val(
																								ifscCode
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
										function removeMaterialm(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}

										function editMaterialm(id) {
											//alert("edit row " + id);
											//$('#'+id).remove();

											$("#dialog-form-Bank").dialog(
													"open");

											$('#bankName').val(
													$('#bankName' + id).val());
											$('#bankAddress').val(
													$('#bankAddress' + id)
															.val());
											$('#micrCode').val(
													$('#micrCode' + id).val());
											$('#ifscCode').val(
													$('#ifscCode' + id).val());
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
										title="<s:message code="label.AddNewBankDetails" />">
										<p class="validateTips">
											<s:message code="label.Allformfieldsarerequired." />
										</p>
										<table class="tableGeneral">

											<tr>
												<td><s:message code="label.vbankname" /><span
													class="required">*</span></td>
												<td><form:input path="bankName" id="bankName"
														class="textbox" maxlength="50" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vbankaddr" /><span
													class="required">*</span></td>
												<td><form:input path="bankAddress" id="bankAddress"
														class="textbox" maxlength="100" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vmicrcode" /><span
													class="required">*</span></td>
												<td><form:input path="micrCode" id="micrCode"
														class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vifsccode" /><span
													class="required">*</span></td>
												<td><form:input path="ifscCode" id="ifscCode"
														class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vacttype" /><span
													class="required">*</span></td>
												<td><form:input path="accountType" id="accountType"
														class="textbox" maxlength="20" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vactno" /><span
													class="required">*</span></td>
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
													<th><s:message code="label.vbankname" /><span
														class="required"></span></th>
													<th><s:message code="label.vbankaddr" /><span
														class="required"></span></th>
													<th><s:message code="label.vmicrcode" /><span
														class="required"></span></th>
													<th><s:message code="label.vifsccode" /><span
														class="required"></span></th>
													<th><s:message code="label.vacttype" /><span
														class="required"></span></th>
													<th><s:message code="label.vactno" /><span
														class="required"></span></th>
													<th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>

												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									</div>
									<button id="create-AddBank" type="button">
										<s:message code="label.AddNewVendorBankDetails" />
									</button>

								</div>
							</div>
							<div id="tabs-21">
								<div align="center">
									<div align="center">

										<script type="text/javascript">
											var dmrid = 1;
											function addDocument() {
												var cc = dmrid - 1;
												//alert("file  "+$('#file'+cc).val());documentName0
												if ($('#documentName' + cc)
														.val() != ""
														&& $('#file' + cc)
																.val() != "") {

													$("#DocumentAdd tbody")
															.append(
																	"<tr id="+dmrid+">"
																			+ "<td ><s:bind path='vendorForm.documentName'><input name='documentName' id='documentName"
													+ dmrid
													+ "' "
													+ " class='textbox' /></s:bind>  </td>"
																			+ "<td><input type='file' name='file' id='file"
													+ dmrid
													+ "'  /></td>"
																			+ "<td><a href='#'  onclick='removeDocumentm("
																			+ dmrid
																			+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																			+ "</tr>");
													dmrid++;

												} else {
													alert("Please Fill The Available Document Name And File");
												}
											}
											function removeDocumentm(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
										</script>

										<div id="users-contain-Document">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="DocumentAdd" class="table">
												<thead>
													<tr>

														<th><s:message code="label.docname" /><span
															class="required"></span></th>
														<th><s:message code="label.docpath" /><span
															class="required"></span></th>


														<th><s:message code="label.remove" /></th>
														<th><s:message code="label.add" /></th>

													</tr>
												</thead>
												<tbody>
													<tr id="0">

														<td><form:input path="documentName"
																id="documentName0" class="textbox" /></td>


														<td><input type="file" name="file" id="file0" /></td>
														<td><a href='#' onclick='removeDocumentm(0)'><strong><img
																	src='images/button_cancel.png' height='20px'
																	width='20px' /></strong></a></td>
														<td><a href='#' onclick='addDocument()'><strong><img
																	src='images/add (1).png' height='20px' width='20px' /></strong></a></td>
													</tr>

												</tbody>
											</table>
										</div>
										<%-- <button id="create-AddDocuments" type="button"><s:message code="label.AddNewVendorDocuments" /></button> --%>


									</div>

								</div>
							</div>
							<div id="tabs-31">
								<div align="center">

									<script>
										var mmrid = 1;
										$(function() {

											var materialname = $("#materialName"), hiddenID = $("#hiddenIdMaterialPopUp"),

											allFields = $([]).add(materialname)
													.add(hiddenID), tips = $(".validateTips");

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

											function materialIdReq(o, n) {
												if (o.val() == "") {
													o
															.addClass("ui-state-error");
													updateTips("Material Name is Required");
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

											$("#dialog-form-Material")
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
																				&& materialIdReq(
																						materialname,
																						"Material Name");

																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {

																				$(
																						"#MaterialAdd tbody")
																						.append(
																								"<tr id="+mmrid+">"
																										+ "<td ><s:bind path='vendorForm.MaterialName'><input name='materialName' id='materialName"
																										+ mmrid
																										+ "' value='"
																										+ $(
																												'#materialName :selected')
																												.text()
																										+ "'"
																										+ " class='textbox'  readonly/></s:bind>  "
																										+ "<input type='hidden' name='materialId' id='materialId"
																										+ mmrid
																										+ "' value='"
																										+ materialname
																												.val()
																										+ "' class='textbox' /></td>"
																										+ "<td><a href='#'  onclick='editMaterialAdd("
																										+ mmrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeMaterialAdd("
																										+ mmrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");

																				dmrid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																			if (hiddenID
																					.val() != "0") {
																				$(
																						'#materialName'
																								+ hiddenID
																										.val())
																						.val(
																								$(
																										'#materialName :selected')
																										.text());
																				$(
																						'#materialId'
																								+ hiddenID
																										.val())
																						.val(
																								materialname
																										.val());
																				//$('#file'+ hiddenID.val()).val(address.val());
																				$(
																						'#hiddenIdMaterialPopUp')
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

											$("#create-AddMaterial")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-Material")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeMaterialAdd(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editMaterialAdd(id) {
											//alert("edit row " + id);
											//$('#'+id).remove();

											$("#dialog-form-Material").dialog(
													"open");

											$('#materialName')
													.val(
															$(
																	'#materialId'
																			+ id)
																	.val());

											$('#hiddenIdMaterialPopUp').val(id);

										}
									</script>


									<div id="dialog-form-Material"
										title="<s:message code="label.AddNewMaterialDetails" />">
										<p class="validateTips">
											<s:message code="label.Allformfieldsarerequired." />
										</p>
										<table class="tableGeneral">

											<tr>
												<td><s:message code="label.materialNamev" /><span
													class="required">*</span></td>
												<td><form:select path="materialName" id="materialName"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${materialId}" />
													</form:select> <input type="hidden" name="materialId" id="materialId" />
													<input type="hidden" name="hiddenIdMaterialPopUp"
													id="hiddenIdMaterialPopUp" value="0" /></td>
											</tr>


										</table>
									</div>



									<div id="users-contain-MaterialAdd">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="MaterialAdd" class="table">
											<thead>
												<tr>
													<th><s:message code="label.materialNamev" /><span
														class="required"></span></th>
													<th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									</div>
									<button id="create-AddMaterial" type="button">
										<s:message code="label.AddNewVendorSuppliedMaterials" />
									</button>


								</div>

							</div>

							<div id="tabs-41">
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
										title="<s:message code="label.vendacform" />">
										<p class="validateTips" align="center" style="color: blue;">All
											Form Fields are Required</p>
										<table class="tableGeneral">


											<tr>
												<td><s:message code="label.vendacgrid" /> <span
													class="required">*</span></td>
												<td><form:select path="acGroupName" id="acGroupIdChild"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${AccGroupSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><s:message code="label.vendacrecondid" /> <span
													class="required">*</span></td>
												<td><form:select path="reCondName" id="reCondIdChild"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${AccGroupSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><s:message code="label.vendacpt" /> <span
													class="required">*</span></td>
												<td><form:select path="paymentTermName"
														id="paymentTermIdChild" class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${PaymentTermSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><s:message code="label.vendacpm" /> <span
													class="required">*</span></td>
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

													<th><s:message code="label.vendacgrid" /><span
														class="required"></span></th>
													<th><s:message code="label.vendacrecondid" /> <span
														class="required"></span></th>
													<th><s:message code="label.vendacpt" /><span
														class="required"></span></th>
													<th><s:message code="label.vendacpm" /><span
														class="required"></span></th>
													<th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>

									<button id="createAddCustAccount" type="button">
										<s:message code="label.newaddvendac" />
									</button>

								</div>

							</div>
						</div>
						<table>
							<tr align="center">
								<td colspan="4"><c:choose>
										<c:when test="${save }">
											<input type="submit" value="<s:message code="label.save" />"
												class="btn btn-primary" id="sumbnid" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<s:message code="label.save"/> "
												class="btn btn-danger" id="orgTypeSubmit" />
										</c:otherwise>
									</c:choose><input type="reset" value="<s:message code="label.reset" />"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" id="vendorDuplicateMessEdit"
								style="display: none;">
								<div class="alert-warning">
									<strong> <s:message code="label.warning" /></strong>
									<s:message code="label.vendname" />
									<s:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>

					<form:form action="vendorUpdate.mnt" method="POST"
						commandName="vendorForm" id="updateForm2" name="updateForm2"
						ENCTYPE="multipart/form-data">
						<c:forEach var="vendorEditValues" items="${vendorValues }">

							<!-- 	<div class="alert-warning" id="vendorDuplicateMessEdit" style="display: none;"></div> -->

							<table class="tableGeneral">

								<form:hidden path="vendorIdEdit" />
								<form:hidden path="vendorAddDuplicateEdit" />

								<tr>
									<td><s:message code="label.vendname" /><span
										class="required">*</span></td>
									<td><form:input path="vendorNameEdit" id="vendorNameEdit"
											class="textbox" onkeyup="doAjaxPostEdit()" maxlength="50" /></td>
									<td><s:message code="label.custid" /></td>
									<td><form:select path="customerIdEdit" id="customerId"
											class="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${customerIdDetails}" />
										</form:select></td>

								</tr>
								<tr>
									<td><s:message code="label.vaddress" /><span
										class="required">*</span></td>
									<td><form:textarea path="addressEdit" id="addressEdit"
											class="textbox" /></td>

									<td><s:message code="label.panno" /><span
										class="required">*</span></td>
									<td><form:input path="panNoEdit" id="PanNoEdit"
											class="textbox" maxlength="30" /></td>


								</tr>
								<tr>
									<td><s:message code="label.vcity" /><span
										class="required">*</span></td>
									<td><form:input path="cityEdit" id="CityEdit"
											class="textbox" maxlength="30" /></td>
									<td><s:message code="label.vzip" /><span class="required">*</span></td>
									<td><form:input path="zipEdit" id="ZipEdit"
											class="textbox" maxlength="10" /></td>

								</tr>
								<tr>
									<td><s:message code="label.vstate" /><span
										class="required">*</span></td>
									<td><form:input path="stateEdit" id="StateEdit"
											class="textbox" maxlength="30" /></td>
									<td><s:message code="label.sertaxno" /><span
										class="required">*</span></td>
									<td><form:input path="serviceTaxNoEdit"
											id="ServiceTaxNoEdit" class="textbox" maxlength="20" /></td>

								</tr>
								<tr>
									<td><s:message code="label.vcountry" /><span
										class="required">*</span></td>
									<td><form:select path="countryEdit" id="CountryEdit"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${country}" />
										</form:select></td>
									<td><s:message code="label.vfax" /><span class="required">*</span></td>
									<td><form:input path="faxEdit" id="Fax" class="textbox"
											maxlength="15" /></td>


								</tr>
								<tr>
									<td><s:message code="label.vemail" /><span
										class="required">*</span></td>
									<td><form:input path="emailEdit" id="EmailEdit"
											class="textbox" maxlength="40" /></td>
									<td><s:message code="label.tinno" /><span
										class="required">*</span></td>
									<td><form:input path="tinNoEdit" id="TinNoEdit"
											class="textbox" maxlength="20" /></td>


								</tr>
								<tr>
									<td><s:message code="label.phno" /><span class="required">*</span></td>
									<td><form:input path="phoneEdit" id="PhoneEdit"
											class="textbox" maxlength="12" /></td>
									<td><s:message code="label.vatno" /><span
										class="required">*</span></td>
									<td><form:input path="vatNoEdit" id="VatNoEdit"
											class="textbox" maxlength="20" /></td>


								</tr>
								<tr>
									<td><s:message code="label.mobile" /><span
										class="required">*</span></td>
									<td><form:input path="mobileEdit" id="MobileEdit"
											class="textbox" maxlength="12" /></td>
									<td><s:message code="label.blocked" /><span
										class="required">*</span></td>
									<td><form:select path="blockedEdit" id="BlockedEdit"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:option value="1">YES</form:option>
											<form:option value="2">NO</form:option>

										</form:select></td>

								</tr>
								<tr>
									<td><s:message code="label.vendgrid" /><span
										class="required">*</span></td>
									<td><form:select path="vendGroupIdEdit"
											id="vendGroupIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${vendorGroupIdDetails}" />
										</form:select></td>
									<td><s:message code="label.statusId" /><span
										class="required">*</span></td>
									<td><form:select path="statusId" id="statusId"
											class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${statusId}" />
										</form:select></td>
								</tr>

							</table>

							<div id="tabs2">

								<ul>
									<li><a href="#tabs-21"><s:message
												code="label.BankDetailsv" /></a></li>
									<li><a href="#tabs-22"><s:message
												code="label.Documentsv" /></a></li>
									<li><a href="#tabs-23"><s:message
												code="label.Materialv" /></a></li>
									<li><a href="#tabs-24"><s:message
												code="label.VendorAccounts" /></a></li>
								</ul>

								<div id="tabs-21">
									<div align="center">
										<div align="center">

											<script>
												var btrid = 1;
												$(function() {

													var nameEdit = $("#bankNameEdit"), addressEdit = $("#bankAddressEdit"), micrCodeEdit = $("#micrCodeEdit"), ifscCodeEdit = $("#ifscCodeEdit"), accountTypeEdit = $("#accountTypeEdit"), accountNumberEdit = $("#accountNumberEdit"), hiddenEdit = $("#hiddenIdBankPopUpEdit"), allFields = $(
															[])
															.add(nameEdit)
															.add(addressEdit)
															.add(micrCodeEdit)
															.add(ifscCodeEdit)
															.add(
																	accountTypeEdit)
															.add(
																	accountNumberEdit)
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

													function checkLength(o, n,
															min, max) {
														if (o.val().length > max
																|| o.val().length < min) {
															o
																	.addClass("ui-state-error");
															updateTips("Length of "
																	+ n
																	+ " must be between "
																	+ min
																	+ " and "
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

													function checkRegexp(o,
															regexp, n) {
														if (!(regexp.test(o
																.val()))) {
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
																						&& required(
																								nameEdit,
																								"Bank Name is Required")
																						&& checkRegexp(
																								nameEdit,
																								/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																								"First Letter must be alphabet")
																						&& checkRegexp(
																								nameEdit,
																								/^([0-9a-zA-Z_& ])*$/i,
																								"Special Characters except &,_ are not allowed");

																				bValid1 = bValid1
																						&& required(
																								addressEdit,
																								"Bank Address Required");

																				bValid1 = bValid1
																						&& required(
																								micrCodeEdit,
																								"MICR Code Required")
																						&& checkRegexp(
																								micrCodeEdit,
																								/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																								"First Letter must be alphanumeric")
																						&& checkRegexp(
																								micrCodeEdit,
																								/^([0-9a-zA-Z ])*$/i,
																								"Special Characters except &,_ are not allowed");

																				bValid1 = bValid1
																						&& required(
																								ifscCodeEdit,
																								"IFSC Code Required")
																						&& checkRegexp(
																								ifscCodeEdit,
																								/^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																								"First Letter must be alphanumeric")
																						&& checkRegexp(
																								ifscCodeEdit,
																								/^([0-9a-zA-Z ])*$/i,
																								"Special Characters except &,_ are not allowed");

																				bValid1 = bValid1
																						&& required(
																								accountTypeEdit,
																								"Account Type Required")
																						&& checkRegexp(
																								accountTypeEdit,
																								/^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/i,
																								"First Letter must be alphabet")
																						&& checkRegexp(
																								accountTypeEdit,
																								/^([0-9a-zA-Z_& ])*$/i,
																								"Special Characters except &,_ are not allowed");
																				bValid1 = bValid1
																						&& required(
																								accountNumberEdit,
																								"Account Number Required")
																						&& checkRegexp(
																								accountNumberEdit,
																								/^([0-9a-zA-Z ])*$/i,
																								"Special Characters are not allowed");

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
																												+ "<td><s:bind path='vendorForm.bankNameEdit'><input name='bankNameEdit' id='bankNameEdit"
																												+ btrid
																												+ "' value="
																												+ nameEdit
																														.val()
																												+ " class='textbox' readonly/></s:bind></td>"
																												+ "<td><s:bind path='vendorForm.bankAddressEdit'><input name='bankAddressEdit' id='bankAddressEdit"
																												+ btrid
																												+ "' value="
																												+ addressEdit
																														.val()
																												+ " class='textbox' readonly/></s:bind> </td>"
																												+ "<td><s:bind path='vendorForm.micrCodeEdit'><input name='micrCodeEdit' id='micrCodeEdit"
																												+ btrid
																												+ "' value="
																												+ micrCodeEdit
																														.val()
																												+ " class='textbox' readonly/></s:bind></td>"
																												+ "<td><s:bind path='vendorForm.ifscCodeEdit'><input name='ifscCodeEdit' id='ifscCodeEdit"
																												+ btrid
																												+ "' value="
																												+ ifscCodeEdit
																														.val()
																												+ " class='textbox' readonly/></s:bind></td>"
																												+ "<td><s:bind path='vendorForm.accountTypeEdit'><input name='accountTypeEdit' id='accountTypeEdit"
																												+ btrid
																												+ "' value="
																												+ accountTypeEdit
																														.val()
																												+ " class='textbox' readonly/></s:bind></td>"
																												+ "<td><s:bind path='vendorForm.accountNumberEdit'><input name='accountNumberEdit' id='accountNumberEdit"
																												+ btrid
																												+ "' value="
																												+ accountNumberEdit
																														.val()
																												+ " class='textbox' readonly/></s:bind><input type='hidden' name='vendorBankDetIdEdit' id='vendorBankDetIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
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
													$('#bankNameEdit')
															.val(
																	$(
																			'#bankNameEdit'
																					+ link)
																			.val());
													$('#bankAddressEdit')
															.val(
																	$(
																			'#bankAddressEdit'
																					+ link)
																			.val());
													$('#micrCodeEdit')
															.val(
																	$(
																			'#micrCodeEdit'
																					+ link)
																			.val());
													$('#ifscCodeEdit')
															.val(
																	$(
																			'#ifscCodeEdit'
																					+ link)
																			.val());
													$('#accountTypeEdit')
															.val(
																	$(
																			'#accountTypeEdit'
																					+ link)
																			.val());
													$('#accountNumberEdit')
															.val(
																	$(
																			'#accountNumberEdit'
																					+ link)
																			.val());

													$('#hiddenIdBankPopUpEdit')
															.val(link);

												}
											</script>


											<div id="dialog-form-BankEdit"
												title="<s:message code="label.AddNewBankDetails" />">
												<p class="validateTips">
													<s:message code="label.Allformfieldsarerequired." />
												</p>
												<table class="tableGeneral">

													<tr>
														<td><s:message code="label.vbankname" /><span
															class="required">*</span></td>
														<td><form:input path="bankNameEdit" id="bankNameEdit"
																class="textbox" maxlength="50" /></td>
													</tr>
													<tr>
														<td><s:message code="label.vbankaddr" /><span
															class="required">*</span></td>
														<td><form:input path="bankAddressEdit"
																id="bankAddressEdit" class="textbox" maxlength="100" /></td>
													</tr>
													<tr>
														<td><s:message code="label.vmicrcode" /><span
															class="required">*</span></td>
														<td><form:input path="micrCodeEdit" id="micrCodeEdit"
																class="textbox" maxlength="20" /></td>
													</tr>
													<tr>
														<td><s:message code="label.vifsccode" /><span
															class="required">*</span></td>
														<td><form:input path="ifscCodeEdit" id="ifscCodeEdit"
																class="textbox" maxlength="20" /></td>
													</tr>
													<tr>
														<td><s:message code="label.vacttype" /><span
															class="required">*</span></td>
														<td><form:input path="accountTypeEdit"
																id="accountTypeEdit" class="textbox" maxlength="20" /></td>
													</tr>
													<tr>
														<td><s:message code="label.vactno" /><span
															class="required">*</span></td>
														<td><form:input path="accountNumberEdit"
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

															<th><s:message code="label.vbankname" /><span
																class="required"></span></th>
															<th><s:message code="label.vbankaddr" /><span
																class="required"></span></th>
															<th><s:message code="label.vmicrcode" /><span
																class="required"></span></th>
															<th><s:message code="label.vifsccode" /><span
																class="required"></span></th>
															<th><s:message code="label.vacttype" /><span
																class="required"></span></th>
															<th><s:message code="label.vactno" /><span
																class="required"></span></th>
															<th><s:message code="label.edit" /></th>
															<th><s:message code="label.remove" /></th>

														</tr>

													</thead>
													<tbody>

														<c:forEach var="vendorBankEditValues"
															items="${vendorBankValues}">
															<c:set var="idn"
																value="${vendorBankEditValues.vendorBankDetId}"></c:set>
															<tr id="${vendorBankEditValues.vendorBankDetId}">
																<c:out value="${vendorBankEditValues1.bankName}" />


																<td><input type="text" name="bankNameEdit"
																	id="bankNameEdit${vendorBankEditValues.vendorBankDetId}"
																	class="textbox" readonly="readonly"
																	value="${vendorBankEditValues.bankName}" /></td>
																<td><input type="text" name="bankAddressEdit"
																	id="bankAddressEdit${vendorBankEditValues.vendorBankDetId}"
																	class="textbox" readonly="readonly"
																	value="${vendorBankEditValues.bankAddress}" /></td>
																<td><input type="text" name="micrCodeEdit"
																	id="micrCodeEdit${vendorBankEditValues.vendorBankDetId}"
																	class="textbox" readonly="readonly"
																	value="${vendorBankEditValues.micrCode}" /></td>
																<td><input type="text" name="ifscCodeEdit"
																	id="ifscCodeEdit${vendorBankEditValues.vendorBankDetId}"
																	class="textbox" readonly="readonly"
																	value="${vendorBankEditValues.ifscCode}" /></td>
																<td><input type="text" name="accountTypeEdit"
																	id="accountTypeEdit${vendorBankEditValues.vendorBankDetId}"
																	class="textbox" readonly="readonly"
																	value="${vendorBankEditValues.accountType}" /></td>
																<td><input type="text" name="accountNumberEdit"
																	id="accountNumberEdit${vendorBankEditValues.vendorBankDetId}"
																	class="textbox" readonly="readonly"
																	value="${vendorBankEditValues.accountNumber}" /><input
																	type="hidden" name="vendorBankDetIdEdit"
																	id="vendorBankDetIdEdit" class="textbox"
																	value="${vendorBankEditValues.vendorBankDetId}" /><input
																	type="hidden"
																	name="${vendorBankEditValues.vendorBankDetId}Check"
																	id="${vendorBankEditValues.vendorBankDetId}Check"
																	value="0" /></td>
																<td><a href="#"
																	id="${vendorBankEditValues.vendorBankDetId}"
																	onclick="javascript:editBankDetailsInEdit(this)"><img
																		src="images/Edit.jpg" height="25px" width="25px"
																		id="${vendorBankEditValues.vendorBankDetId}"></img></a></td>
																<td><a href="#"
																	id="${vendorBankEditValues.vendorBankDetId}"
																	onclick="javascript:getID1(this)"><img
																		src="images/button_cancel.png" height="25px"
																		width="25px"
																		id="${vendorBankEditValues.vendorBankDetId}"></img></a> <script
																		type="text/javascript">
																			function getID1(
																					link) {
																				//alert(link.id);
																				alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																				document
																						.getElementById(link.id
																								+ "Check").value = "1";
																				document
																						.getElementById(link.id).style.display = "none";
																			}
																			function editBankDetailsInEdit(
																					link) {
																				//alert(link.id);
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
																		</script></td>
															</tr>
														</c:forEach>

													</tbody>
												</table>
											</div>
											<button id="create-AddBankEdit" type="button">
												<s:message code="label.AddNewVendorBankDetails" />
											</button>


										</div>

									</div>
								</div>

								<div id="tabs-22">
									<div align="center">

										<div align="center">

											<div id="users-contain-DocumentEdit">
												<!-- class="ui-widget" -->
												<h3></h3>
												<table id="DocumentEdit" class="table">
													<thead>
														<tr>
															<th><s:message code="label.docname" /><span
																class="required"></span></th>
															<th><s:message code="label.docpath" /><span
																class="required"></span></th>
															<th><s:message code="label.remove" /></th>
															<th><s:message code="label.edit" /></th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="vendorDocumentEditValues"
															items="${vendorDocumentsValues}">
															<tr id="${vendorDocumentEditValues.vendorDocId}">

																<td><input type="text" name="documentName"
																	id="documentName${vendorDocumentEditValues.vendorDocId}"
																	class="textbox"
																	value="${vendorDocumentEditValues.documentName}"
																	readonly="readonly" /></td>

																<td><a
																	href="download.mnt?id=${vendorDocumentEditValues.documentPath}">Click
																		here to download file</a> <input type="hidden"
																	name="vendorDocIdEdit" id="vendorDocIdEdit"
																	value="${vendorDocumentEditValues.vendorDocId}" /> <input
																	type="hidden" name="vendorDocumentPathEdit"
																	id="vendorDocumentPathEdit"
																	value="${vendorDocumentEditValues.documentPath}" /> <input
																	type="hidden"
																	name="${vendorDocumentEditValues.vendorDocId}CheckDoc"
																	id="${vendorDocumentEditValues.vendorDocId}CheckDoc"
																	value="0" /> <input type="hidden" name="checkPrevious"
																	id="checkPrevious" value="1" /></td>
																<td><a href="#"
																	id="${vendorDocumentEditValues.vendorDocId}"
																	onclick="checkDocEdit(this)"><img
																		src="images/button_cancel.png" height="20px"
																		width="20px"></img></a></td>
																<td></td>
															</tr>
														</c:forEach>
														<tr id="200">

															<td><form:input path="documentNameEdit"
																	id="documentName200" class="textbox" /></td>


															<td><input type="file" name="file" id="file200" /></td>
															<td><a href='#' onclick='removeDocumentEdit(200)'><strong><img
																		src='images/button_cancel.png' height='20px'
																		width='20px' /></strong></a></td>
															<td><script type="text/javascript">
																function checkDocEdit(
																		link) {

																	alert("Deleting Particular Row Will Deleted Once You Click Update Button Doc");
																	//alert(y);
																	document
																			.getElementById(link.id
																					+ "CheckDoc").value = "1";
																	document
																			.getElementById(link.id).style.display = "none";
																}

																function removeDocumentEdit(
																		id) {
																	//alert("removing row " + id);
																	$('#' + id)
																			.remove();
																}
																var deditmrid = 201;
																var cc = deditmrid - 1;
																function addDocumentEdit() {
																	if ($(
																			'#documentNameEdit'
																					+ cc)
																			.val() != ""
																			&& $(
																					'#file'
																							+ cc)
																					.val() != "") {

																		$(
																				"#DocumentEdit tbody")
																				.append(
																						"<tr id="+deditmrid+">"
																								+ "<td ><s:bind path='vendorForm.documentNameEdit'><input name='documentNameEdit' id='documentName"
																	+ deditmrid
																	+ "'"
																	+ " class='textbox' /></s:bind>  <input type='hidden' name='checkPreviousEdit' id='checkPreviousEdit'"
									                                +" value='0' /></td>"
																								+ "<td><input type='file' name='file' id='file"
																	+ deditmrid
																	+ "'  /></td>"

																								+ "<td><a href='#'  onclick='removeDocumentEdit("
																								+ deditmrid
																								+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																								+ "</tr>");

																		deditmrid++;
																	} else {
																		alert("Please Fill The Available Document Name And File");
																	}

																}
															</script> <a href='#' onclick='addDocumentEdit()'><strong><img
																		src='images/add (1).png' height='20px' width='20px' /></strong></a></td>
														</tr>




													</tbody>
												</table>
											</div>



										</div>




									</div>
								</div>




								<div id="tabs-23">
									<div align="center">


										<script>
											var memrid = 201;
											$(function() {

												var materialname = $("#materialNameEdit"), hiddenID = $("#hiddenIdMaterialEditPopUp"),

												allFields = $([]).add(
														materialname).add(
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

												function materialIdReq(o, n) {
													if (o.val() == "") {
														o
																.addClass("ui-state-error");
														updateTips("Material Name is Required");
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

												$("#dialog-form-MaterialEdit")
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
																					&& materialIdReq(
																							materialname,
																							"Material Name");

																			if (bValid) {
																				if (hiddenID
																						.val() == "0"
																						|| hiddenID
																								.val() == "") {

																					$(
																							"#MaterialEdit tbody")
																							.append(
																									"<tr id="+memrid+">"
																											+ "<td ><s:bind path='vendorForm.MaterialNameEdit'><input name='materialNameEdit' id='materialNameEdit"
																											+ memrid
																											+ "'  value='"
																											+ $(
																													'#materialNameEdit :selected')
																													.text()
																											+ "'"
																											+ " class='textbox' readonly/></s:bind>  "
																											+ "<input type='hidden' name='materialIdEdit' id='materialIdEdit"
																											+ memrid
																											+ "' value='"
																											+ materialname
																													.val()
																											+ "' class='textbox'  /><input type='hidden' name='vendorMatIdEdit'id='vendorMatIdEdit' value='0'/></td>"
																											+ "<td><a href='#'  onclick='editMaterialEdit("
																											+ memrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeMaterialEdit("
																											+ memrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");

																					dmrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																				if (hiddenID
																						.val() != "0") {
																					$(
																							'#materialNameEdit'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#materialNameEdit :selected')
																											.text());
																					$(
																							'#materialIdEdit'
																									+ hiddenID
																											.val())
																							.val(
																									materialname
																											.val());
																					$(
																							'#hiddenIdMaterialEditPopUp')
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

												$("#create-EditMaterial")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-MaterialEdit")
																			.dialog(
																					"open");
																	//alert("opened");
																});
											});
											function removeMaterialEdit(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editMaterialEdit(id) {
												//	alert("edit row " + id);
												//$('#'+id).remove();

												$("#dialog-form-MaterialEdit")
														.dialog("open");

												$('#materialNameEdit').val(
														$(
																'#materialIdEdit'
																		+ id)
																.val());
												//$('#materialIdEdit').val($('#materialIdEdit' + id).val());
												$('#hiddenIdMaterialEditPopUp')
														.val(id);
												// document.getElementById("").value="edit";
											}
										</script>


										<div id="dialog-form-MaterialEdit"
											title="<s:message code="label.AddNewMaterialDetails" />">
											<p class="validateTips">
												<s:message code="label.Allformfieldsarerequired." />
											</p>
											<table class="tableGeneral">



												<tr>
													<td><s:message code="label.materialNamev" /><span
														class="required">*</span></td>
													<td><form:select path="materialNameEdit"
															id="materialNameEdit" class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${materialId}" />

														</form:select> <input type="hidden" name="materialIdEdit"
														id="materialIdEdit" /> <input type="hidden"
														name="hiddenIdMaterialEditPopUp"
														id="hiddenIdMaterialEditPopUp" value="0" /></td>
												</tr>


											</table>
										</div>



										<div id="users-contain-MaterialEdit">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="MaterialEdit" class="table">
												<thead>
													<tr>
														<th><s:message code="label.materialNamev" /><span
															class="required"></span></th>
														<th><s:message code="label.edit" /></th>
														<th><s:message code="label.remove" /></th>
													</tr>

												</thead>
												<tbody>
													<c:forEach var="vendorMaterialEditValues"
														items="${vendorMaterialValues}">
														<c:set var="idn1"
															value="${vendorMaterialEditValues.vendorMatId}"></c:set>
														<tr id="${vendorMaterialEditValues.vendorMatId}">

															<td><input type="text" name="materialNameEdit"
																id="materialNameEdit${vendorMaterialEditValues.vendorMatId}"
																class="textbox" readonly="readonly"
																value="${vendorMaterialEditValues.materialName}" /><input
																type="hidden" name="materialIdEdit"
																id="materialIdEdit${vendorMaterialEditValues.vendorMatId}"
																class="textbox" readonly="readonly"
																value="${vendorMaterialEditValues.materialId}" /> <input
																type="hidden" name="vendorMatIdEdit"
																id="vendorMatIdEdit"
																value="${vendorMaterialEditValues.vendorMatId}" /> <input
																type="hidden"
																name="${vendorMaterialEditValues.vendorMatId}CheckMaterial"
																id="${vendorMaterialEditValues.vendorMatId}CheckMaterial"
																value="0" /></td>
															<td><a href="#"
																id="${vendorMaterialEditValues.vendorMatId}"
																onclick="javascript:editMaterialDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="${vendorMaterialEditValues.materialId}"></img></a></td>
															<td><a href="#"
																id="${vendorMaterialEditValues.vendorMatId}"
																onclick="javascript:getMaterialID1(this)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px"
																	id="${vendorMaterialEditValues.vendorMatId}"></img></a> <script
																	type="text/javascript">
																		function getMaterialID1(
																				link) {
																			//alert(link.id);
																			alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																			document
																					.getElementById(link.id
																							+ "CheckMaterial").value = "1";
																			document
																					.getElementById(link.id).style.display = "none";
																		}
																		function editMaterialDetailsInEdit(
																				link) {
																			//alert(link.id);
																			$(
																					"#dialog-form-MaterialEdit")
																					.dialog(
																							"open");
																			$(
																					'#materialNameEdit')
																					.val(
																							$(
																									'#materialIdEdit'
																											+ link.id)
																									.val());
																			//$('#materialIdEdit').val($('#materialIdEdit'+ link.id).val());

																			$(
																					'#hiddenIdMaterialEditPopUp')
																					.val(
																							link.id);

																		}
																	</script></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<button id="create-EditMaterial" type="button">
											<s:message code="label.AddNewVendorSuppliedMaterials" />
										</button>


									</div>

								</div>

								<div id="tabs-24">
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

																											+ "<td><input type='hidden' name='evendAccountId' value='0' /><input type='hidden' name='eacGroupId' id='acGroupIdEdit"
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
																											+ "<input type='hidden' name='ecustAccountId' id='ecustAccountId' value='0'/><input type='hidden' name='checkedAccount' id='Check' value='0' /></td>"

																											+ "<td><a href='#'  onclick='editSalesOdrSchInNewEdit("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeCustAccountEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
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
											title="<s:message code="label.vendacform"  />">
											<p class="validateTips" align="center" style="color: blue;">All
												Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="evendAccountId" value="0" />

												<tr>
													<td><s:message code="label.vendacgrid" /> <span
														class="required">*</span></td>
													<td><form:select path="acGroupName" id="acGroupIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${AccGroupSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><s:message code="label.vendacrecondid" /> <span
														class="required">*</span></td>
													<td><form:select path="reCondName" id="reCondIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${AccGroupSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><s:message code="label.vendacpt" /> <span
														class="required">*</span></td>
													<td><form:select path="paymentTermName"
															id="paymentTermIdEdit" class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${PaymentTermSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><s:message code="label.vendacpm" /> <span
														class="required">*</span></td>
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
												<thead>
													<tr>
														<th><s:message code="label.vendacgrid" /><span
															class="required"></span></th>
														<th><s:message code="label.vendacrecondid" /> <span
															class="required"></span></th>
														<th><s:message code="label.vendacpt" /><span
															class="required"></span></th>
														<th><s:message code="label.vendacpm" /><span
															class="required"></span></th>
														<th><s:message code="label.edit" /></th>
														<th><s:message code="label.remove" /></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="vendorAccountList"
														items="${vendorAccountList}">

														<s:bind path="vendorForm.evendAccountId">
															<input type="hidden" name="evendAccountId"
																id="custAccountId${vendorAccountList.evendAccountId}"
																value="${vendorAccountList.evendAccountId}" />
														</s:bind>
														<tr id="${vendorAccountList.evendAccountId}">

															<td><s:bind path="vendorForm.eacGroupId">
																	<input type="hidden" name="eacGroupId"
																		id="acGroupIdEdit${vendorAccountList.evendAccountId}"
																		class="textbox"
																		value="${vendorAccountList.eacGroupId}" readonly />
																</s:bind> <s:bind path="vendorForm.eacGroupName">
																	<input type="text" name="eacGroupName"
																		id="acGroupNameEdit${vendorAccountList.evendAccountId}"
																		class="textbox"
																		value="${vendorAccountList.eacGroupName}" readonly />
																</s:bind></td>

															<td><s:bind path="vendorForm.ereCondId">
																	<input type="hidden" name="ereCondId" class="textbox"
																		id="reCondIdEdit${vendorAccountList.evendAccountId}"
																		value="${vendorAccountList.ereCondId}" readonly />
																</s:bind> <s:bind path="vendorForm.ereCondName">
																	<input type="text" name="ereCondName"
																		id="reCondNameEdit${vendorAccountList.evendAccountId}"
																		class="textbox"
																		value="${vendorAccountList.ereCondName}" readonly />
																</s:bind></td>


															<td><s:bind path="vendorForm.epaymentTermId">
																	<input type="hidden" name="epaymentTermId"
																		class="textbox"
																		id="paymentTermIdEdit${vendorAccountList.evendAccountId}"
																		value="${vendorAccountList.epaymentTermId}" readonly />
																</s:bind> <s:bind path="vendorForm.epaymentTermName">
																	<input type="text" name="epaymentTermName"
																		id="paymentTermNameEdit${vendorAccountList.evendAccountId}"
																		class="textbox"
																		value="${vendorAccountList.epaymentTermName}" readonly />
																</s:bind></td>

															<td><s:bind path="vendorForm.epaymentMethodId">
																	<input type="hidden" name="epaymentMethodId"
																		class="textbox"
																		id="paymentMethodIdEdit${vendorAccountList.evendAccountId}"
																		value="${vendorAccountList.epaymentMethodId}" readonly />
																</s:bind> <s:bind path="vendorForm.epaymentMethodName">
																	<input type="text" name="epaymentMethodName"
																		id="paymentMethodNameEdit${vendorAccountList.evendAccountId}"
																		class="textbox"
																		value="${vendorAccountList.epaymentMethodName}"
																		readonly />
																</s:bind></td>


															<td><a href="#"
																id="${vendorAccountList.evendAccountId}"
																onclick="javascript:editCustAccountInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${vendorAccountList.evendAccountId}"></img></a> <%-- <a href="#"
																id="${salesOdrLineEditList.esalesOrderLineId}"
																onclick="javascript:getID1(this)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px"
																	id="${salesOdrLineEditList.esalesOrderLineId}"></img></a> --%>

															</td>
															<td><input type="hidden" name="checkedAccount"
																id="${vendorAccountList.evendAccountId}CheckAccount"
																value="0" /> <a href="#"
																id="${vendorAccountList.evendAccountId}"
																onclick="javascript:getIDAccount(this)"><img
																	src="images/button_cancel.png" height="20px"
																	width="20px" id="${vendorAccountList.evendAccountId}"></img></a>


															</td>
														</tr>

														<script>
															function editCustAccountInEdit(
																	link) {
																//alert("kk"+ link.id);
																$(
																		"#dialog-form-CustAccountEdit")
																		.dialog(
																				"open");
																$(
																		'#acGroupIdEdit')
																		.val(
																				$(
																						'#acGroupIdEdit'
																								+ link.id)
																						.val());
																$(
																		'#reCondIdEdit')
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

															function getIDAccount(
																	link) {
																//alert(link.id);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link.id
																				+ "CheckAccount").value = "1";
																document
																		.getElementById(link.id).style.display = "none";
															}
														</script>

													</c:forEach>


												</tbody>
											</table>
										</div>


										<button id="createEditcustAccount" type="button">
											<s:message code="label.newaddvendac" />
										</button>

									</div>


								</div>


							</div>
							<table>
								<tr align="center">
									<td colspan="4" align="center"><c:choose>
											<c:when test="${update}">

												<input type="submit"
													value="<s:message code="label.update" />"
													class="btn btn-primary" id="updatebtn" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<s:message code="label.update"/>"
													class="btn btn-danger" id="orgTypeSubmitupdate" />
											</c:otherwise>

										</c:choose></td>
								</tr>

							</table>
						</c:forEach>
					</form:form>

				</div>
			</div>
		</div>

	</div>


</body>
</html>