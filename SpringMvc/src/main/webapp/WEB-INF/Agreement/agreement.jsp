<!-- @author Srinivas -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						$('#subid')
								.click(
										function(event) {

											$('#addagform')
													.validate(
															{
																rules : {
																	agreementtypeid : {
																		required : true
																	},
																	agreementNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	vendorId : {
																		required : true
																	},
																	orgId : {
																		required : true
																	},
																	purOrgId : {
																		required : true
																	},
																	agreementDate : {
																		required : true
																	},
																	stdt : {
																		required : true
																	},
																	etdt : {
																		required : true

																	},
																	
																},
																messages : {
																	agreementtypeid : "<font style='color: red;'><b>Agreement Type is Required</b></font>",
																	agreementNo : {
																		required:"<font style='color: red;'><b>Agreement No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	vendorId : "<font style='color: red;'><b>Vendor is Required</b></font>",
																	orgId : "<font style='color: red;'><b>Organization is Required</b></font>",
																	purOrgId : "<font style='color: red;'><b>Purchase Organization is Required</b></font>",
																	agreementDate : "<font style='color: red;'><b>Agreement Date is Required</b></font>",
																	stdt : "<font style='color: red;'><b>Start Date is Required</b></font>",
																	etdt : "<font style='color: red;'><b>End Date is Required</b></font>",
																},

															});
											 if($('#agreementDate').val()!=0 && $('#agreementtypeid').val()!=0){
												if($('#valueForSubData').val()==0)
												{
												document.getElementById("addmessage").style.display = "block";
												$('#addmessage').html("Warning! Please Enter AtLeast One RFQ Line");
												return false;
												}
											
											else
												{
												document.getElementById("addmessage").style.display = "none";
												$('#addmessage').html("");
												return true;
												}
											} 
										});
						//	});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {
											//alert("hai");
											$('#editRfqForm')
													.validate(
															{
																rules : {
																	agreementtypeid : {
																		required : true
																	},
																	agreementNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	vendorId : {
																		required : true
																	},
																	orgId : {
																		required : true
																	},
																	purOrgId : {
																		required : true
																	},
																	agreementDate : {
																		required : true
																	},
																	stdt : {
																		required : true
																	},
																	etdt : {
																		required : true

																	},
																	
																},
																messages : {
																	agreementtypeid : "<font style='color: red;'><b>Agreement Type is Required</b></font>",
																	agreementNo : {
																		required:"<font style='color: red;'><b>Agreement No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	vendorId : "<font style='color: red;'><b>Vendor is Required</b></font>",
																	orgId : "<font style='color: red;'><b>Organization is Required</b></font>",
																	purOrgId : "<font style='color: red;'><b>Purchase Organization is Required</b></font>",
																	agreementDate : "<font style='color: red;'><b>Agreement Date is Required</b></font>",
																	stdt : "<font style='color: red;'><b>Start Date is Required</b></font>",
																	etdt : "<font style='color: red;'><b>End Date is Required</b></font>",
																},
															});

										});

					});
</script>

<script type="text/javascript">
function dateFun(datePattern) {
		$('#agDate,#et,#st').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true,
		});

	}
</script>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#basicSearchId").focus();
		$('#operations').val('');
		$('#add,#search').click(function(e) {
			$("#basicSearchId").focus();
			$('#edit').hide();
			$('#agreementtypeid').val('');
			$('#agreementNo').val('');
			$('#vendorId').val('');
			$('#OrgId').val('');
			$('#purOrgId').val('');
			$('#agDate').val('');
			$('#st').val('');
			$('#et').val('');
			$('#successmessage').hide();
			$('#savemessage').hide();
			

		});

	});
</script>
<script type="text/javascript">
function AjaxPO() {
	var i = 1;
	var OrgId = $('#OrgId').val();
	$.ajax({
		type : "POST",
		url : "populatePO.mnt",
		data : "OrgId=" + OrgId ,
		success : function(response) {
			var match = "";
			match = $('#purOrgId').empty();
			match.append(new Option("-Select-", ""));
			$.each(response, function(key, value) {
				if (i == 1) {
					match.append(new Option(value, key));
				} else {
					match.append(new Option(value, key));
				}
				i++;
			});

		},
		error : function(e) {
			alert('Error' + e);
		}

	});

}
function AjaxPOEdit() {
	var i = 1;
	var OrgIdEdit = $('#OrgIdEdit').val();
	$.ajax({
		type : "POST",
		url : "populatePOEdit.mnt",
		data : "OrgIdEdit=" + OrgIdEdit ,
		success : function(response) {
			var match = "";
			match = $('#purOrgIdEdit').empty();
			match.append(new Option("-Select-", ""));
			$.each(response, function(key, value) {
				if (i == 1) {
					match.append(new Option(value, key));
				} else {
					match.append(new Option(value, key));
				}
				i++;
			});

		},
		error : function(e) {
			alert('Error' + e);
		}

	});

}
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
		<div class="PageTitle"><spring:message code="label.ag"/></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<c:set var="editvalues" value="${editvalues }"></c:set>

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
						<form:form action="searchagreement.mnt" method="GET" commandName="AGREEMENT">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.ag" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.ag" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${RfqUpdateSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.ag" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${RfqUpdateFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.ag" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${RfqDeleteSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.ag" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${RfqDeleteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.ag" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>

							</tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select" id="operations">
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



								<td><c:choose>
										<c:when test="${true }">
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
						</form:form>
						<form:form action="agreementAdvanceSearch.mnt" method="get"
							commandName="AGREEMENT" name="advanceSearchFinal">
							<tr>
								<td colspan="2"><a href="javascript: void(0);"
									id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue"><u><b>Advanced Search</b></u></font></a> <a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							</tr>
						</form:form>
					</table>

					<form:form action="agAdvanceSearchOperations.mnt"
						commandName="AGREEMENT">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${agSearchAdvance}">
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
									<td colspan="3"><c:choose>
											<c:when test="${search }">
												<input type="submit" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-primary" />
											</c:when>
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

					<c:if test="${agbeans!=null}">
						<div>
							<display:table id="agid" name="agbeans"
								requestURI="searchagreement.mnt" pagesize="5" class="table">
								<display:column property="agreementId" title="RFQID" media="none"
									sortable="true"></display:column>
								<display:column property="agreementtypeid" titleKey="label.agreementType"
									media="html" sortable="true"></display:column>
								<display:column property="agreementNo" titleKey="label.agreementNo"
									media="html" sortable="true"></display:column>
								<display:column property="vendorId" titleKey="label.vendorag"
									media="html" sortable="true"></display:column>
								<display:column property="orgId"
									titleKey="label.orgag" media="html" sortable="true"></display:column>
								<display:column property="purOrgId"
									titleKey="label.purOrg" media="html" sortable="true"></display:column>
								<display:column property="agreementDate"
									titleKey="label.agreementDate" media="html" sortable="true"></display:column>
								<display:column property="stdt" titleKey="label.stdt"
									media="html" sortable="true"></display:column>
								<display:column property="etdt" titleKey="label.etdt"
									media="html" sortable="true"></display:column>
								 <display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${true}">
											<a
												href="agreementEdit.mnt?agedit=<c:out value="${agid.agreementId}"/>"
												style="color: red"><img src="images/Edit.jpg"
												width="20px" onclick="toggleTable();" height="20px" /> </a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Edit.jpg" class="btn btn-danger"
												width="20px" onclick="toggleTable();" height="20px" /> </a>
										</c:otherwise>
									</c:choose>
								</display:column>
								<display:column titleKey="label.delete">
									<c:choose>
										<c:when test="${true}">
											<a
												href="agDelete.mnt?agdelete=<c:out value="${agid.agreementId}"/>"
												style="color: red"><img src="images/Delete.jpg"
												width="20px" height="20px"
												onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Delete.jpg" class="btn btn-danger"
												width="20px" onclick="toggleTable();" height="20px" /> </a>

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
					<table>
						<tr>
							<td colspan="4" id="RFQSuccessdup" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.rfqNo" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
							
							<td colspan="4" class="alert-warning" id="addmessage"
								style="display: none; width: 450px; height: 25px;"></td>
						
						</tr>
					</table>
					<form:form action="saveagreement.mnt" method="POST" commandName="AGREEMENT"
						id="addagform">

						<!-- <div id="RFQSuccessdup" class="alert-warning" style="display: none; "></div> -->

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">


										<%-- <form:hidden path="rfqhide" /> --%>

										
										<tr>
											<td><spring:message code="label.agreementType" /><span
												class="required">*</span></td>
											<td><form:select path="agreementtypeid" id="agreementtypeid"  class="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${agreementType}" />
												</form:select></td>

</tr>
										<tr>
											<td><spring:message code="label.agreementNo" /><span
												class="required">*</span></td>
											<td><form:input path="agreementNo" id="agreementNo"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.vendorag" /><span
												class="required">*</span></td>
											<td><form:select path="vendorId" id="vendorId"
													class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${Vendor}" />
												</form:select></td>

										</tr>
										<tr>
											<td><spring:message code="label.orgag" /><span
												class="required">*</span></td>
											<td><form:select path="orgId" id="OrgId" onchange="AjaxPO()"
													class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${Organization}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.purOrg" /><span
												class="required">*</span></td>
											<td><form:select path="purOrgId" class="select" id="purOrgId">
													<form:option value="">--Select--</form:option>
													<%-- <form:options items="${PurOrg}" /> --%>
												</form:select></td>
										</tr>
										<tr>
												<td><spring:message code="label.agreementDate" /><span
												class="required">*</span></td>
											<td><form:input path="agreementDate" id="agDate"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.stdt" /><span
												class="required">*</span></td>
											<td><form:input path="stdt" id="st"
													class="textbox" /></td>
													</tr>
													<tr>
													<td><spring:message code="label.etdt" /><span
												class="required">*</span></td>
											<td><form:input path="etdt" id="et"
													class="textbox" /></td>
											<td><input type="hidden" name="valueForSubData"
											id="valueForSubData" class="textbox" value="0"/></td>
										</tr>




									</table>
								</td>

							</tr>
						</table>
						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message
											code="label.agreementline" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

								<!-- <div align="center"> -->

								<script>
									var btrfqid = 1;
									$(function() {

										/* var currentText = $(this).find(":selected").text(); */

										var matid = $("#materialid"), qtid = $("#qty"), umid = $("#uomid"), ddate = $("#ddate"), hiddenrfqID = $("#hiddenIdrfqPopUp"),

										allFields = $([]).add(matid).add(qtid)
												.add(umid).add(ddate).add(
														hiddenrfqID), tips = $(".validateTips");

										function updateTips(t) {
											tips.text(t).addClass(
													"ui-state-highlight");
											setTimeout(function() {
												tips.removeClass(
														"ui-state-highlight",
														1500);
											}, 500);
										}

										function checkLength(o, n, min, max) {
											if (o.val().length > max
													|| o.val().length < min) {
												o.addClass("ui-state-error");
												updateTips("Length of " + n
														+ " must be between "
														+ min + " and " + max
														+ ".");
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

										function checkRegexp(o, regexp, n) {
											if (!(regexp.test(o.val()))) {
												o.addClass("ui-state-error");
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
															width : 350,
															modal : true,
															buttons : {
																Submit : function() {
																	var bValid1 = true;
																	allFields
																			.removeClass("ui-state-error");
																	bValid1 = bValid1
																			&& checkLength1(
																					matid,
																					"Material");
																	bValid1 = bValid1
																			&& checkRegexp(
																					qtid,
																					/^([0-9.])+$/i,
																					"Total Quantity is Required And Must be a Number");

																	bValid1 = bValid1
																			&& checkLength1(
																					umid,
																					"UOM");

																	bValid1 = bValid1
																			&& checkLength1(
																					ddate,
																					/^([0-9.])+$/i,
																					"Net Price");

																	if (bValid1) {
																		//alert("hiddenid"+hiddenID.val());

																		if (hiddenrfqID
																				.val() == "0"
																				|| hiddenrfqID
																						.val() == "") {

																			$(
																					"#RfqAdd tbody")
																					.append(
																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='materialId' id='materialid"
																									+ btrfqid
																									+ "' value="
																									+ matid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='materialName' id='materialName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#materialid :selected')
																											.text()
																									+ "'"
																									+ " </td>"
																									+ "<td><input type='text' name='targetqty' id='qty"
																									+ btrfqid
																									+ "' value="
																									+ qtid
																											.val()
																									+ "  class='textbox'readonly/></td>"

																									+ "<td><input type='hidden' name='uomId' id='uomid"
																									+ btrfqid
																									+ "' value="
																									+ umid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='uomName' id='uomName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#uomid :selected')
																											.text()
																									+ "'"
																									+ "</td>"
																									+ "<td><input name='netprice' id='ddate"
																									+ btrfqid
																									+ "' value="
																									+ ddate
																											.val()
																									+ " class='textbox'readonly/></td>"
																									+ "<td><a href='#'  onclick='editRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																									+ "<td><a href='#'  onclick='removeRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																									+ "</tr>");
																			$('#valueForSubData').val(btrfqid);
																			btrfqid++;
																			$(
																					this)
																					.dialog(
																							"close");
																		}

																		if (hiddenrfqID
																				.val() != "0") {
																			$(
																					'#materialid'
																							+ hiddenrfqID
																									.val())
																					.val(
																							matid
																									.val());

																			$(
																					'#materialName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#materialid :selected')
																									.text());
																			$(
																					'#qty'
																							+ hiddenrfqID
																									.val())
																					.val(
																							qtid
																									.val());
																			$(
																					'#uomid'
																							+ hiddenrfqID
																									.val())
																					.val(
																							umid
																									.val());
																			$(
																					'#uomName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#uomid :selected')
																									.text());

																			$(
																					'#ddate'
																							+ hiddenrfqID
																									.val())
																					.val(
																							ddate
																									.val());

																			$(
																					'#hiddenIdrfqPopUp')
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
																		.val("")
																		.removeClass(
																				"ui-state-error");
															}
														});

										$("#Rfqlineadd").button().click(
												function() {
													$("#dialog-form-Rfq")
															.dialog("open");
													//alert("opened");
												});
									});
									function removeRfq(id) {
										//alert("removing row " + id);
										$('#' + id).remove();
										$('#valueForSubData').val(parseFloat($('#valueForSubData').val())-parseFloat(1));
									}
									function editRfq(id) {
										//alert("edit row " + id);
										$("#dialog-form-Rfq").dialog("open");
										$('#materialid').val(
												$('#materialid' + id).val());
										$('#qty').val($('#qty' + id).val());
										$('#uomid').val($('#uomid' + id).val());
										$('#ddate').val($('#ddate' + id).val());
										$('#hiddenIdrfqPopUp').val(id);

									}
								</script>


								<div id="dialog-form-Rfq" align="center"
									title="<spring:message code="label.rfqlineadd" />">
									<p class="validateTips" align="center">
										<font color="red"></font>
									</p>
									<table class="tableGeneral" cellspacing=0>

										<tr>
											<td><spring:message code="label.materialag" /><span
												class="required">*</span></td>
											<td><form:select path="materialId" id="materialid"
													class="select" cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${materialid}" />

												</form:select></td>
										</tr>
										<tr>

											<!-- <td><input type="hidden" id="processNumber" class="select" 
													cssStyle="height:25px;" /> -->


										</tr>
										<tr>
											<td><spring:message code="label.qtyag" /><span
												class="required">*</span></td>
											<td><form:input path="targetqty" id="qty" class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.uomag" /><span
												class="required">*</span></td>
											<td><form:select path="uomId" id="uomid" class="select"
													cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${uom}" />

												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.netpriceag" /><span
												class="required">*</span></td>
											<td><form:input path="netprice" id="ddate"
													class="textbox" /> <input type="hidden"
												name="hiddenIdrfqPopUp" id="hiddenIdrfqPopUp" value="0" /></td>
										</tr>

									</table>
									<table>
										<tr class="alert-warning" id="ProcessdescDupMessage"
											style="display: none; width: 300px;"></tr>
									</table>
								</div>



								<div id="users-contain-Rfq">
									<!-- class="ui-widget" -->
									<h3></h3>
									<table id="RfqAdd" class="table">
										<thead>
											<tr>
												<th><spring:message code="label.materialrfq" /></th>
												<th><spring:message code="label.qtyrfq" /></th>
												<th><spring:message code="label.uomrfq" /></th>
												<th><spring:message code="label.netpriceag" /></th>
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>

											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<button id="Rfqlineadd" type="button">
										<spring:message code="label.aglineadd" />
									</button>
								</div>

								<%-- <form:hidden path="rfqhide" /> --%>

								<!-- </div> -->
							</div>
						</div>
						<table>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${true }">
											<input type="submit"
												value="<spring:message code="label.save"/>"
												class="btn btn-primary" id="subid" />
										</c:when>
										<c:otherwise>
											<input type="submit"
												value="<spring:message code="label.save"/>"
												class="btn btn-danger" disabled="disabled" id="subid" />
										</c:otherwise>
									</c:choose> <!-- <input type="reset"
												class="btn btn-primary" /> --> <input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
						<!-- </div> -->

					</form:form>

				</div>
			</div>
		 <div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td id="RFQSuccessdupedit" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.rfqNo" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>

					<form:form action="agreementUpdate.mnt" method="POST" commandName="AGREEMENT"
						id="editRfqForm">

						<c:if test="${editvalues!=null}">

							<table class="tableGeneral">
								<form:hidden path="agreementId" />
								<tr>
											<td><spring:message code="label.agreementType" /><span
												class="required">*</span></td>
											<td><form:select path="agreementtypeid" id="agreementtypeid"  class="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${agreementType}" />
												</form:select></td>

</tr>
										<tr>
											<td><spring:message code="label.agreementNo" /><span
												class="required">*</span></td>
											<td><form:input path="agreementNo" id="agreementNo"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.vendorag" /><span
												class="required">*</span></td>
											<td><form:select path="vendorId" id="vendorId"
													class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${Vendor}" />
												</form:select></td>

										</tr>
										<tr>
											<td><spring:message code="label.orgag" /><span
												class="required">*</span></td>
											<td><form:select path="orgId" id="OrgIdEdit" onchange="AjaxPOEdit()"
													class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${Organization}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.purOrg" /><span
												class="required">*</span></td>
											<td><form:select path="purOrgId" id="purOrgIdEdit" class="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${PurOrg}" /> 
												</form:select></td>
										</tr>
										<tr>
												<td><spring:message code="label.agreementDate" /><span
												class="required">*</span></td>
											<td><form:input path="agreementDate" id="agDateedit"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.stdt" /><span
												class="required">*</span></td>
											<td><form:input path="stdt" id="stedit"
													class="textbox" /></td>
													</tr>
													<tr>
													<td><spring:message code="label.etdt" /><span
												class="required">*</span></td>
											<td><form:input path="etdt" id="etedit"
													class="textbox" /></td>
											<td><input type="hidden" name="valueForSubData"
											id="valueForSubData" class="textbox" value="0"/></td>
										</tr>
							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.agreementline" /></a></li>

								</ul>


								<div align="center">

									<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

									<!-- <div align="center"> -->

									<script>
										var btrfqid = 0;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */

											var ematid = $("#materialidedit"), eqtid = $("#qtyedit"), eumid = $("#uomidedit"), eddate = $("#ddateedit"), ehiddenrfqID = $("#hiddenIdrfqeditPopUp")

											allFields = $([]).add(ematid).add(
													eqtid).add(eumid).add(
													eddate).add(ehiddenrfqID),
													tips = $(".validateTips");

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

											function checkLength2(o, n) {

												if (o.val().length == "") {
													o
															.addClass("ui-state-error");
													updateTips(n
															+ "is Required");
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
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid2 = true;
																		allFields
																				.removeClass("ui-state-error");

																		bValid2 = bValid2
																				&& checkLength2(
																						ematid,

																						"Material");

																		bValid2 = bValid2
																				&& checkRegexp(
																						eqtid,
																						/^([0-9.])+$/i,
																						"Quantity is Required And Must be a Number");

																		bValid2 = bValid2
																				&& checkLength2(
																						eumid,

																						"UOM");

																		bValid2 = bValid2
																				&& checkLength2(
																						eddate,
																						/^([0-9.])+$/i,
																						"Delivery Date");
																		if (bValid2) {
																			//alert("hiddenid"+hiddenID.val());

																			if (ehiddenrfqID
																					.val() == "0"
																					|| ehiddenrfqID
																							.val() == "") {

																				$(
																						"#RFQEdit tbody")
																						.append(
																								"<tr id="+btrfqid+">"
																										+ "<td ><input type='hidden' name='materialIdedit' id='materialidedit"
																										+ btrfqid
																										+ "' value="
																										+ ematid
																												.val()
																										+ " class='textbox'readonly/>  "
																										+ "<input type='text' readonly class='textbox' name='materialNameEdit' id='materialNameEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#materialidedit :selected')
																												.text()
																										+ "'"
																										+ "</td>"
																										+ "<td><input type='text' name='targetqtyedit' id='qtyedit"
																										+ btrfqid
																										+ "' value="
																										+ eqtid
																												.val()
																										+ "  class='textbox'readonly/></td>"

																										+ "<td><input type='hidden' name='uomIdedit' id='uomidedit"
																										+ btrfqid
																										+ "' value="
																										+ eumid
																												.val()
																										+ " class='textbox'readonly/>"
																										+ "<input type='text' readonly class='textbox' name='uomNameEdit' id='uomNameEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#uomidedit :selected')
																												.text()
																										+ "'"
																										+ "</td>"
																										+ "<td><input name='netpriceedit' id='ddateedit"
																										+ btrfqid
																										+ "' value="
																										+ eddate
																												.val()
																										+ " class='textbox'readonly/><input type='hidden' name='agreementlineidedit' value='0' id='agreementlineidedit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
																										+

																										// "<td>" + password.val() + "</td>" +
																										"<td><a href='#'  onclick='editRfqEdit("
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
																				$(
																						'#materialidedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								ematid
																										.val());
																				$(
																						'#materialNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#materialidedit :selected')
																										.text());
																				$(
																						'#qtyedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eqtid
																										.val());
																				$(
																						'#uomidedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eumid
																										.val());
																				$(
																						'#uomNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#uomidedit :selected')
																										.text());

																				$(
																						'#ddateedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eddate
																										.val());

																				$(
																						'#hiddenIdrfqeditPopUp')
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

											$("#AddRFQEdit")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-RfqEdit")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeRfqEdit(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}

										function editRfqEdit(id) {
											alert("edit row " + id);

											$("#dialog-form-RfqEdit").dialog(
													"open");

											$('#materialidedit').val(
													$('#materialidedit' + id)
															.val());
											$('#qtyedit').val(
													$('#qtyedit' + id).val());
											$('#uomidedit').val(
													$('#uomidedit' + id).val());
											$('#ddateedit').val(
													$('#ddateedit' + id).val());

											$('#hiddenIdrfqeditPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-RfqEdit" align="center"
										title="Add AgreementLine Details">
										<p class="validateTips" align="center">
											<font color="red"></font>
										</p>
										<table class="tableGeneral" cellspacing=0>
											<form:hidden path="agreementlineidedit" value="0" />
											<tr>
											<td><spring:message code="label.materialag" /><span
												class="required">*</span></td>
											<td><form:select path="materialId" id="materialidedit"
													class="select" cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${materialid}" />

												</form:select></td>
										</tr>
										<tr>
										</tr>
										<tr>
											<td><spring:message code="label.qtyag" /><span
												class="required">*</span></td>
											<td><form:input path="targetqty" id="qtyedit" class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.uomag" /><span
												class="required">*</span></td>
											<td><form:select path="uomId" id="uomidedit" class="select"
													cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${uom}" />

												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.netpriceag" /><span
												class="required">*</span></td>
											<td><form:input path="netprice" id="ddateedit"
													class="textbox" /> <input type="hidden"
												name="hiddenIdrfqPopUp" id="hiddenIdrfqPopUp" value="0" />
										 <input type="hidden"
													name="hiddenIdrfqeditPopUp" id="hiddenIdrfqeditPopUp"
													value="0" /></td>
											</tr>

										</table>

									</div>



									<div id="users-contain-Process">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="RFQEdit" class="table">
											<thead>
												<tr>

													<th><spring:message code="label.materialrfq" /></th>
													<th><spring:message code="label.qtyrfq" /></th>
													<th><spring:message code="label.uomrfq" /></th>
													<th><spring:message code="label.netpriceag" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>


											</thead>
											<tbody>
												<c:forEach items="${aglinelistdetails}" var="aglinelistdetails">



													<td><spring:bind path="AGREEMENT.agreementlineidedit">
															<input type="hidden" name="agreementlineidedit"
																id="agreementlineidedit${aglinelistdetails.agreementlineidedit}"
																value="${aglinelistdetails.agreementlineidedit}" />
														</spring:bind></td>


													<tr id="${aglinelistdetails.agreementlineidedit}">
														<td><spring:bind path="AGREEMENT.materialIdedit">
																<input type="hidden" name="materialIdedit"
																	class="textbox"
																	id="materialidedit${aglinelistdetails.agreementlineidedit}"
																	value="${aglinelistdetails.materialIdedit}" />
															</spring:bind> <spring:bind path="AGREEMENT.materialidName">
																<input type="text" name="materialidName" class="textbox"
																	id="materialNameEdit${aglinelistdetails.agreementlineidedit}"
																	value="${aglinelistdetails.materialidName}" readonly />
															</spring:bind></td>

														<td><spring:bind path="AGREEMENT.targetqtyedit">
																<input type="text" name="targetqtyedit"
																	id="qtyedit${aglinelistdetails.agreementlineidedit}"
																	class="textbox" value="${aglinelistdetails.targetqtyedit}"
																	readonly />
															</spring:bind></td>
														<td><spring:bind path="AGREEMENT.uomIdedit">
																<input type="hidden" name="uomIdedit"
																	id="uomidedit${aglinelistdetails.agreementlineidedit}"
																	class="textbox" value="${aglinelistdetails.uomIdedit}"
																	readonly />
															</spring:bind> <spring:bind path="AGREEMENT.uomidName">
																<input type="text" name="uomidName"
																	id="uomNameEdit${aglinelistdetails.agreementlineidedit}"
																	class="textbox" value="${aglinelistdetails.uomidName}"
																	readonly />
															</spring:bind></td>
														<td><spring:bind path="AGREEMENT.netpriceedit">
																<input type="text" name="netpriceedit"
																	id="ddateedit${aglinelistdetails.agreementlineidedit}"
																	class="textbox"
																	value="${aglinelistdetails.netpriceedit}" readonly />
															</spring:bind> <input type="hidden"
															name="Checkdelete${aglinelistdetails.agreementlineidedit}"
															id="${aglinelistdetails.agreementlineidedit}Checkdelete" value="0" /></td>


														<td><a href='#' id="${aglinelistdetails.agreementlineidedit}"
															onclick="editRfqEdit(this.id)"><strong><img
																	src='images/Edit.jpg' height='25px' width='25px' /></strong></a></td>
														<td><a href='#' id="${aglinelistdetails.agreementlineidedit}"
															onclick="getID11(this)"><strong><img
																	src='images/button_cancel.png' height='25px'
																	width='25px' /></strong></a></td>
													</tr>



													<script type="text/javascript">
														function getID11(link) {
															//alert(link.id);
															alert("Deleting Particular Row Will Deleted Once You Click Update Button");
															document
																	.getElementById(link.id
																			+ "Checkdelete").value = "1";
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
																	'#materialidedit'
																			+ link.id)
																	.val(
																			$(
																					'#materialidedit')
																					.val());
															$('#qtyedit')
																	.val(
																			$(
																					'#qtyedit'
																							+ link.id)
																					.val());
															$('#uomidedit')
																	.val(
																			$(
																					'#uomidedit'
																							+ link.id)
																					.val());
															$('#ddateedit')
																	.val(
																			$(
																					'#ddateedit'
																							+ link.id)
																					.val());

															$(
																	'#hiddenIdrfqeditPopUp')
																	.val(
																			link.id);

														}
													</script>

												</c:forEach>
											</tbody>
										</table>
										<button id="AddRFQEdit" type="button">
											<spring:message code="label.aglineadd" />
										</button>
									</div>

								</div>

							</div>

							<table>
								<tr>
									<td colspan="2" align="center"><c:choose>
											<c:when test="${true}">
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateid" />
											</c:when>
											<c:otherwise>
												<input type="submit"
													value="<spring:message code="label.update"/>"
													disabled="disabled" class="btn btn-danger" id="updateid" />
											</c:otherwise>

										</c:choose></td>

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
