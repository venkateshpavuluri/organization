<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
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
	$(document)
			.ready(
					function() {
						$('#saveButton')
								.click(
										function(event) {

											$('#physicalVerificationAddForm')
													.validate(
															{
																rules : {

																	verificationNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	verificationTypeId : {
																		required : true
																	},
																	orgId : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	storageLocaionId : {
																		required : true
																	},
																	verificationDate : {
																		required : true
																	},

																},
																messages : {

																	verificationNo : {
																		required : "<font style='color: red;'><b>Physical Verification No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	verificationTypeId : "<font style='color: red;'><b>Physical Verification Type No is Required</b></font>",
																	orgId : "<font style='color: red;'><b>Organisation No is Required</b></font>",
																	plantId : "<font style='color: red;'><b>Plant No is Required</b></font>",
																	storageLocaionId : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	verificationDate : "<font style='color: red;'><b>Verification Date is Required</b></font>",

																},

															});

										});

						$('#updateButton')
								.click(
										function(event) {

											//alert("update validation");
											var jj = $(
													'#physicalVerificationUpdateForm')
													.validate(
															{
																rules : {

																	verificationNoEdit : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	verificationTypeIdEdit : {
																		required : true
																	},
																	orgIdEdit : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	storageLocaionIdEdit : {
																		required : true
																	},
																	verificationDateEdit : {
																		required : true
																	},

																},
																messages : {

																	verificationNoEdit : {
																		required : "<font style='color: red;'><b>Physical Verification No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	verificationTypeIdEdit : "<font style='color: red;'><b>Physical Verification Type No is Required</b></font>",
																	orgIdEdit : "<font style='color: red;'><b>Organisation No is Required</b></font>",
																	plantIdEdit : "<font style='color: red;'><b>Plant No is Required</b></font>",
																	storageLocaionIdEdit : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	verificationDateEdit : "<font style='color: red;'><b>Verification Date is Required</b></font>",

																}

															});

										});

					});

	function numbersonly(myfield, e, dec) {

		var key;
		var keychar;

		if (window.event)
			key = window.event.keyCode;
		else if (e)
			key = e.which;
		else
			return true;
		keychar = String.fromCharCode(key);

		// control keys
		if ((key == null) || (key == 0) || (key == 8) || (key == 9)
				|| (key == 13) || (key == 27))
			return true;
		else if ((("0123456789.").indexOf(keychar) > -1))
			return true;
		else
			return false;
	}

	function dateFun(datePattern) {

		$("#verificationDate,#verificationDateEdit").datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true

		});
	}

	$(function() {
		if ($('#advanceSearchHidden').val() == "1") {
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
		}
		$('#basicSearch').click(function() {
			$("#advanceSearchHidden").val("0");
			$('#advanceSearchButtonId').hide();
			$('#mainSearch').show();
			$('#advanceSearchDiv').hide();
			$('#advanceSearch').show();
			$('#basicSearch').hide();
			return false;
		});
	});

	function doAjaxPost(id) {

		var verificationNo = $('#verificationNo').val();
		//alert(verificationNo);
		$
				.ajax({
					type : "POST",
					url : "PhysicalNoCheck.mnt",
					data : "verificationNo=" + verificationNo,
					success : function(response) {
						var checkResponse = "Warning ! Physical Verication no aleardy exists. Please try some other no";
						if (checkResponse == response) {
							document
									.getElementById("physicalVerificationDuplicateMess").style.display = "block";
							//$('#physicalVerificationDuplicateMess').html(response);

							$('#saveButton').hide();
						} else {
							document
									.getElementById("physicalVerificationDuplicateMess").style.display = "none";
							$('#saveButton').show();
						}
					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});
	}

	function doAjaxPostEdit() {

		var verificationNoEdit = $('#verificationNoEdit').val();
		var verificationIdEdit = $('#verificationIdEdit').val();
		//alert(purchaseOrderNoEdit +" "+purchaseOrderIdEdit);
		$
				.ajax({
					type : "POST",
					url : "verificationNoEditCheckEdit.mnt",
					data : "verificationNoEdit=" + verificationNoEdit
							+ "&verificationIdEdit=" + verificationIdEdit,
					success : function(response) {
						//	alert(response);
						var checkResponse = "Warning ! Physical Verication no aleardy exists. Please try some other no";
						if (checkResponse == response) {
							document
									.getElementById("physicalVerificationDuplicateMessEdit").style.display = "block";
							//$('#physicalVerificationDuplicateMessEdit').html(response);

							$('#updateButton').hide();
						} else {
							document
									.getElementById("physicalVerificationDuplicateMessEdit").style.display = "none";
							$('#updateButton').show();
						}
					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});
	}

	function doPlant(id, x) {

		var plantId = $('#' + id).val();
		//alert("plantId selected "+plantId);

		$.ajax({
			type : "POST",
			url : "plantOnChange.mnt",
			data : "plantId=" + plantId,
			success : function(response) {

				var k = 1;
				var options = "";
				if (x == 'A') {

					options = $("#storageLocaionId").empty();
				}
				if (x == 'E') {

					options = $("#storageLocaionIdEdit").empty();
				}
				options.append(new Option("-Select-", ""));
				$.each(response, function(key, value) {
					if (k == 1) {
						options.append(new Option(value, key));
					} else {
						options.append(new Option(value, key));
					}
					k++;
				});

			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});
	}

	function doOrganisation(id, x) {

		var orgId = $('#' + id).val();
		//alert(orgId);
		$.ajax({
			type : "POST",
			url : "orgOnChange.mnt",
			data : "orgId=" + orgId,
			success : function(response) {
				var i = 1;
				var options = "";
				if (x == 'A') {

					options = $("#plantId").empty();
				}
				if (x == 'E') {

					options = $("#plantIdEdit").empty();
				}
				options.append(new Option("-Select-", ""));
				$.each(response, function(key, value) {
					if (i == 1) {

						options.append(new Option(value, key));
					} else {
						options.append(new Option(value, key));
					}
					i++;
				});

			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});
	}

	function doStorageLocationOnChange(id, x) {

		var storageId = $('#' + id).val();
		//alert("Strogr"+storageId);
		//alert(orgId);
		$.ajax({
			type : "POST",
			url : "storageLocationOnChange.mnt",
			data : "storageId=" + storageId,
			success : function(response) {

				//alert("storageLocationOnChange Change"+response);
				if (x == 'A') {
					$('#extender').empty();
					var raw = JSON.parse(response);
					$.each(raw, function(idx, item) {
						$('#extenderEdit').show();
						$('#extender').show();
						forAddRow(item.count);
						$("#materialId" + item.count).val(item.materialId);
						$("#materialName" + item.count).val(item.materialName);
						$("#batchNo" + item.count).val(item.batchNo);
						$("#bookQty" + item.count).val(item.bookQty);
						$("#physicalQty" + item.count).val("");
						$("#uomId" + item.count).val(item.uomId);
						$("#uomName" + item.count).val(item.uomName);

					});

				}
				if (x == 'E') {
					alert("Cannot Be Change at this Postion");
					$("#storageLocaionIdEdit").val(
							$("#hiddenStorageLocation").val());
				}

			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});
	}

	$(document).ready(function() {
		$("#tabs,#tabs1,#tabs2").tabs();
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#tabs-1').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

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
		<div class="PageTitle">
			<spring:message code="label.PhysicalVerification1" />
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vendorValues"
					items="${physicalVerificationEditList}">
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

						<form:form action="physicalVerificationSearch.mnt" method="GET"
							commandName="physicalVerificationCommand">

							<tr>
								<td colspan="2"><c:forEach var="addPursu"
										items="${param.addPV}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.PhysicalVerification1" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach var="fail" items="${Addfail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.PhysicalVerification1" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="pVUpdate"
										items="${param.pVUpdate}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.PhysicalVerification1" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach var="fail" items="${updatefail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.PhysicalVerification1" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>

							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeletePursu"
										items="${param.DeletePursu}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.PhysicalVerification1" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach var="fail" items="${fail}">
										<div class="alert-danger" id="fail">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.PhysicalVerification1" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /> <form:select
										path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
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


						</form:form>
						<form:form action="physicalVerificationAdvanceSearch.mnt"
							method="get" commandName="physicalVerificationCommand"
							name="advanceSearchFinal">
							<tr>
								<td><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue"><u><b><spring:message
														code="label.advancedSearchSearchPhysical" /></b></u></font></a> <a href="#"
									id="basicSearch" style="display: none"><font
										style="color: blue"><u><b><spring:message
														code="label.backToBasicSearchPhysical" /></b></u></font></a></td>
							</tr>
						</form:form>
					</table>
					<form:form action="PhysicalAdvanceSearchOperations.mnt"
						commandName="physicalVerificationCommand" method="get">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue"
									items="${physicalVerificationAdvance}">
									<tr>
										<td><label><spring:message
													code="label.verificationNo" /> <%-- ${xmlLabelValue.secondLabel} --%></label>
											<form:hidden path="firstLabel" id="firstLabel"
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
												id="advanceSearch" class="textbox" /></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3"><input type="submit"
										id="advanceSearchButtonId"
										value="<spring:message code="label.advancedSearchPhysical" />"
										style="display: none" class="btn btn-primary" /></td>
								</tr>
								
							</table>

						</div>
					</form:form>


					<c:if test="${physicalVerificationList!=null }">

						<display:table name="physicalVerificationList" id="purcList"
							class="table" requestURI="physicalVerificationSearch.mnt"
							pagesize="5">

							<display:column property="verificationNo" sortable="true"
								titleKey="label.verificationNo" media="html" />

							<display:column property="verificationTypeId" sortable="true"
								titleKey="label.verificationTypeId" media="html" />


							<display:column property="orgId" sortable="true"
								titleKey="label.orgId" media="html" />
							<display:column property="plantId" sortable="true"
								titleKey="label.plantId" media="html" />

							<display:column property="storageLocaionId" sortable="true"
								titleKey="label.storageLocaionId" media="html" />


							<display:column property="verificationDate" sortable="true"
								titleKey="label.verificationDate" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="PhysicalVerificationEdit.mnt?verificationId=<c:out value="${purcList.verificationId}"/> "><img
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
											href="PhysicalVerificationDelete.mnt?verificationId=<c:out value="${purcList.verificationId}"/> "
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

					<c:forEach var="physicalVerificationListAdvanced"
						items="${physicalVerificationListAdvanced}">
						<c:set var="purcAdvanced"
							value="${physicalVerificationListAdvanced}"></c:set>
					</c:forEach>


					<c:choose>
						<c:when test="${purcAdvanced!=null }">


							<display:table name="physicalVerificationListAdvanced"
								id="purcList1" class="table"
								requestURI="PhysicalAdvanceSearchOperations.mnt" pagesize="5">


								<display:column property="verificationNo" sortable="true"
									titleKey="label.verificationNo" media="html" />

								<display:column property="verificationTypeId" sortable="true"
									titleKey="label.verificationTypeId" media="html" />


								<display:column property="orgId" sortable="true"
									titleKey="label.orgId" media="html" />
								<display:column property="plantId" sortable="true"
									titleKey="label.plantId" media="html" />

								<display:column property="storageLocaionId" sortable="true"
									titleKey="label.storageLocaionId" media="html" />


								<display:column property="verificationDate" sortable="true"
									titleKey="label.verificationDate" media="html" />



								<display:column titleKey="label.edit">
									<a
										href="PhysicalVerificationEdit.mnt?verificationId=<c:out value="${purcList1.verificationId}"/> "><img
										src="images/Edit.jpg" width="20px" height="20px" /></a>
								</display:column>
								<display:column titleKey="label.delete">
									<a
										href="PhysicalVerificationDelete.mnt?verificationId=<c:out value="${purcList1.verificationId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" />

							</display:table>
						</c:when>

					</c:choose>



				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td id="physicalVerificationDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.verificationNo" />
									<spring:message code="label.duplicateCheck" />

								</div>
							</td>
						</tr>
					</table>
					<form:form action="physicalVerificationAdd.mnt" method="POST"
						commandName="physicalVerificationCommand"
						id="physicalVerificationAddForm"
						name="physicalVerificationAddForm">
						<table>
							<form:hidden path="physicalVerificationAddDuplicate" />
							<tr>

								<td><spring:message code="label.verificationNo" /><span
									class="required">*</span></td>
								<td><form:input path="verificationNo" id="verificationNo"
										class="textbox" onkeyup="doAjaxPost()" maxlength="20" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.verificationTypeId" /><span
									class="required">*</span></td>
								<td><form:select path="verificationTypeId"
										id="verificationTypeId" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${Selectverification}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.orgId" /><span
									class="required">*</span></td>
								<td><form:select path="orgId" id="orgId" class="select"
										onchange="doOrganisation(this.id,'A')">
										<form:option value="">-Select-</form:option>
										<form:options items="${SelectOrg }" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.plantId" /><span
									class="required">*</span></td>
								<td><form:select path="plantId" id="plantId" class="select"
										onchange="doPlant(this.id,'A')">
										<form:option value="">-Select-</form:option>
										<%-- 	<form:options items="${SelectPlant }" /> --%>
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.storageLocationId" /><span
									class="required">*</span></td>
								<td><form:select path="storageLocaionId"
										id="storageLocaionId" class="select"
										onchange="doStorageLocationOnChange(this.id,'A')">
										<form:option value="">-Select-</form:option>
										<%-- 	<form:options items="${SelectStorageLocation }" /> --%>
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.verificationDate" /><span
									class="required">*</span></td>
								<td><form:input path="verificationDate"
										id="verificationDate" class="textbox" /></td>

							</tr>



						</table>


						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11"><spring:message
											code="label.physicalVerificationLine" /></a></li>

							</ul>
							<div id="tabs-11">



								<div align="center">

									<script>
										var phyid = 200;
										$(function() {

											var materialId = $("#materialId"), batchNo = $("#batchNo"), bookQty = $("#bookQty"), physicalQty = $("#physicalQty"), uomId = $("#uomId"), hiddenID = $("#hiddenIdPhysicalPopUp"),

											allFields = $([]).add(materialId)
													.add(batchNo).add(bookQty)
													.add(physicalQty)
													.add(uomId).add(hiddenID), tips = $(".validateTips");
											//add(salesTaxAmtChildS).add(vatTaxAmtChildS).add(exciseAmtChildS).add(frieghtChargesChildS).add(pnfChargesChildS).
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

											function checkLength1(o, n) {
												if (o.val() == '0') {
													o
															.addClass("ui-state-error");
													updateTips("Select " + n
															+ " Value ");
													return false;
												} else {
													return true;
												}
											}
											function checkLength2(o, n) {
												//alert("sss"+o.val());
												if (o.val() == "") {
													o
															.addClass("ui-state-error");
													updateTips(""
															+ n
															+ " Should Not Be Empty ");
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

											$("#dialog-form-Physical")
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
																				&& checkLength1(
																						materialId,
																						"Material Name ");
																		bValid = bValid
																				&& checkLength2(
																						batchNo,
																						"Batch No");
																		bValid = bValid
																				&& checkLength2(
																						bookQty,
																						"Book Quantity");
																		bValid = bValid
																				&& checkLength2(
																						physicalQty,
																						"Physical Quantity");
																		bValid = bValid
																				&& checkLength1(
																						uomId,
																						"Uom");
																		if (bValid) {
																			alert("hiddenid"
																					+ hiddenID
																							.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {

																				$(
																						"#PhysicalAdd tbody")
																						.append(
																								"<tr id="+phyid+">"

																										+ "<td><spring:bind path='physicalVerificationCommand.materialIdChild'><input type='hidden' name='materialIdChild' id='materialId"
																										+ phyid
																										+ "' value="
																										+ materialId
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='physicalVerificationCommand.materialName'><input type='text' name='materialName' id='materialName"
																										+ phyid
																										+ "' value='"
																										+ $(
																												'#materialId :selected')
																												.text()
																										+ "' class='textbox' readonly/></spring:bind> </td>"
																										+ "<td><spring:bind path='physicalVerificationCommand.batchNoChild'><input name='batchNoChild' id='batchNo"
																										+ phyid
																										+ "' value="
																										+ batchNo
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='physicalVerificationCommand.bookQtyChild'><input name='bookQtyChild' id='bookQty"
																										+ phyid
																										+ "' value="
																										+ bookQty
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='physicalVerificationCommand.physicalQtyChild'><input name='physicalQtyChild' id='physicalQty"
																										+ phyid
																										+ "' value="
																										+ physicalQty
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='physicalVerificationCommand.uomIdChild'><input type='hidden' name='uomIdChild' id='uomId"
																										+ phyid
																										+ "' value="
																										+ uomId
																												.val()
																										+ " class='textbox'/></spring:bind><spring:bind path='physicalVerificationCommand.uomName'><input name='uomName' id='uomName"
																										+ phyid
																										+ "' value='"
																										+ $(
																												'#uomId :selected')
																												.text()
																										+ "' class='textbox'/></spring:bind></td>"
																										+ "<td><a href='#'  onclick='editPhysicalInAdd("
																										+ phyid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removePhysicalInAdd("
																										+ phyid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");

																				phyid++;

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
																								materialId
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
																						'#batchNo'
																								+ hiddenID
																										.val())
																						.val(
																								batchNo
																										.val());
																				$(
																						'#bookQty'
																								+ hiddenID
																										.val())
																						.val(
																								bookQty
																										.val());
																				$(
																						'#physicalQty'
																								+ hiddenID
																										.val())
																						.val(
																								physicalQty
																										.val());

																				$(
																						'#uomId'
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
																										'#uomId :selected')
																										.text());
																				$(
																						'#hiddenIdPhysicalPopUp')
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

											$("#create-AddPhysical")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-Physical")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removePhysicalInAdd(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editPhysicalInAdd(id) {
											alert("edit row " + id);
											$("#dialog-form-Physical").dialog(
													"open");

											$('#materialId')
													.val(
															$(
																	'#materialId'
																			+ id)
																	.val());

											$('#batchNo').val(
													$('#batchNo' + id).val());

											$('#bookQty').val(
													$('#bookQty' + id).val());
											$('#physicalQty').val(
													$('#physicalQty' + id)
															.val());
											$('#uomId').val(
													$('#uomId' + id).val());
											$('#hiddenIdPhysicalPopUp').val(id);
										}

										function sumAdd() {
											//alert("ss");  
											$('#lineAmtChild')
													.val(
															parseFloat($(
																	'#quantityChild')
																	.val())
																	* parseFloat($(
																			'#unitPriceChild')
																			.val()));
										}
									</script>




									<div id="dialog-form-Physical"
										title="<spring:message code="label.AddNewPhysicalVerificationLineDetails" /> ">
										<p class="validateTips">
											<spring:message
												code="label.AllformfieldsarerequiredPhysical." />
										</p>
										<table class="tableGeneral">





											<tr>
												<td><spring:message code="label.materialName" /></td>
												<td><form:select path="materialId" id="materialId"
														class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.batchNo" /></td>
												<td><form:input path="batchNo" id="batchNo"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.bookQty" /></td>
												<td><form:input path="bookQty" id="bookQty"
														class="textbox" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.physicalQty" /></td>
												<td><form:input path="physicalQty" id="physicalQty"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.uomId" /></td>
												<td><form:select path="uomId" id="uomId" class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select><input type="hidden" name="hiddenIdPhysicalPopUp"
													id="hiddenIdPhysicalPopUp" value="0" /></td>
											</tr>


										</table>
									</div>



									<div id="users-contain-Physical">
										<!-- class="ui-widget" -->


										<table id="PhysicalAdd" class="table">
											<tbody>
												<tr id="PhysicalAddHead">
													<th><spring:message code="label.materialName" /></th>
													<th><spring:message code="label.batchNo" /></th>
													<th><spring:message code="label.bookQty" /></th>
													<th><spring:message code="label.physicalQty" /></th>
													<th><spring:message code="label.uomId" /></th>
													<%-- <th><spring:message code="label.Edit" /></th>
													<th><spring:message code="label.Delete" /></th> --%>

												</tr>

											</tbody>
										</table>
										<script type="text/javascript">
											function forAddRow(id) {
												//alert(" cam eid"+id);

												var options = '<table class="table"><tr id='+id+'>'

														+ '<td><spring:bind path="physicalVerificationCommand.materialIdChild"><input type="hidden" name="materialIdChild" id="materialId'+id+'"  class="textbox" readonly/></spring:bind>'
														+ '<spring:bind path="physicalVerificationCommand.materialName"><input type="text" name="materialName" id="materialName'+id+'"  class="textbox" readonly/></spring:bind> </td>'
														+ '<td><spring:bind path="physicalVerificationCommand.batchNoChild"><input name="batchNoChild" id="batchNo'+id+'"  class="textbox" readonly /></spring:bind></td>'
														+ '<td><spring:bind path="physicalVerificationCommand.bookQtyChild"><input name="bookQtyChild" id="bookQty'+id+'" class="textbox" readonly /></spring:bind></td>'
														+ '<td><spring:bind path="physicalVerificationCommand.physicalQtyChild"><input name="physicalQtyChild" id="physicalQty'
														+ id
														+ '" value="" class="textbox" onKeyPress="return numbersonly(this, event)" /></spring:bind></td>'
														+ '<td><spring:bind path="physicalVerificationCommand.uomIdChild"><input type="hidden" name="uomIdChild" id="uomId'+id+'" value="" class="textbox" readonly /></spring:bind>'
														+ '<spring:bind path="physicalVerificationCommand.uomName"><input type="text" name="uomName" id="uomName'+id+'" class="textbox" readonly /></spring:bind> </td>'
												// +'<td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/Edit.jpg" height="20px" width="20px" onclick="editPhysicalInAdd('+ id+ ')" /></strong></a></td><td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove" onclick="removePhysicalInAdd('+ id+ ')" ><strong><img src="images/button_cancel.png"   height="20px" width="20px" /></strong></a></td></tr></table>';
												$("#extender").append(options);

											}
										</script>
										<!-- </div> -->
									</div>
									<div id="extender"></div>
									<%--  <button id="create-AddPhysical" type="button"><spring:message code="label.AddNewPhysicalVerificationLineDetails" /></button>  --%>


								</div>

							</div>



						</div>

						<table>
							<tr>
								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="saveButton"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="saveButton"
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


			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td id="physicalVerificationDuplicateMessEdit"
								style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.verificationNo" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="physicalVerificationUpdate.mnt" method="POST"
						commandName="physicalVerificationCommand"
						id="physicalVerificationUpdateForm"
						name="physicalVerificationUpdateForm">
						<c:forEach var="physicalVerificationEditList"
							items="${physicalVerificationEditList}">

							<table>
								<form:hidden path="physicalVerificationEditDuplicate" />
								<tr>

									<td><form:hidden path="verificationIdEdit"
											id="verificationIdEdit" class="textbox" /> <spring:message
											code="label.verificationNo" /><span class="required">*</span></td>
									<td><form:input path="verificationNoEdit"
											id="verificationNoEdit" class="textbox"
											onkeyup="doAjaxPostEdit()" maxlength="20" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.verificationTypeId" /><span
										class="required">*</span></td>
									<td><form:select path="verificationTypeIdEdit"
											id="verificationTypeIdEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${Selectverification}" />
										</form:select></td>
								</tr>
								<tr>

									<td><spring:message code="label.orgId" /><span
										class="required">*</span></td>
									<td><form:select path="orgIdEdit" id="orgIdEdit"
											class="select" onchange="doOrganisation(this.id,'E')">
											<form:option value="">-Select-</form:option>
											<form:options items="${SelectOrg }" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.plantId" /><span
										class="required">*</span></td>
									<td><form:select path="plantIdEdit" id="plantIdEdit"
											class="select" onchange="doPlant(this.id,'E')">
											<form:option value="">-Select-</form:option>
											<form:options items="${SelectPlant }" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.storageLocationId" /><span
										class="required">*</span></td>
									<td><form:select path="storageLocaionIdEdit"
											id="storageLocaionIdEdit" class="select"
											onchange="doStorageLocationOnChange(this.id,'E')">
											<form:option value="">-Select-</form:option>
											<form:options items="${SelectStorageLocation }" />
										</form:select><input type="hidden" name="hiddenStorageLocation"
										id="hiddenStorageLocation"
										value="${physicalVerificationEditList.storageLocaionIdEdit}" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.verificationDate" /><span
										class="required">*</span></td>
									<td><form:input path="verificationDateEdit"
											id="verificationDateEdit" class="textbox" /></td>

								</tr>

							</table>

							<div id="tabs2">

								<ul>
									<li><a href="#tabs-21"><spring:message
												code="label.physicalVerificationLine" /></a></li>

								</ul>
								<div id="tabs-21">


									<div align="center">

										<script>
											var phyidEdit = 200;
											$(function() {

												var materialId = $("#materialIdEdit"), batchNo = $("#batchNoEdit"), bookQty = $("#bookQtyEdit"), physicalQty = $("#physicalQtyEdit"), uomId = $("#uomIdEdit"), hiddenID = $("#hiddenIdPhysicalPopUpEdit"),

												allFields = $([]).add(
														materialId)
														.add(batchNo).add(
																bookQty).add(
																physicalQty)
														.add(uomId).add(
																hiddenID), tips = $(".validateTips");
												//add(salesTaxAmtChildS).add(vatTaxAmtChildS).add(exciseAmtChildS).add(frieghtChargesChildS).add(pnfChargesChildS).
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

												function checkLength1(o, n) {
													if (o.val() == '0') {
														o
																.addClass("ui-state-error");
														updateTips("Select "
																+ n + " Value ");
														return false;
													} else {
														return true;
													}
												}
												function checkLength2(o, n) {
													//alert("sss"+o.val());
													if (o.val() == "") {
														o
																.addClass("ui-state-error");
														updateTips(""
																+ n
																+ " Should Not Be Empty");
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

												$("#dialog-form-PhysicalEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 330,
																	width : 350,
																	modal : true,
																	buttons : {
																		Submit : function() {
																			var bValid = true;
																			allFields
																					.removeClass("ui-state-error");
																			bValid = bValid
																					&& checkLength1(
																							materialId,
																							"Material Name ");
																			bValid = bValid
																					&& checkLength2(
																							batchNo,
																							"Batch No");
																			bValid = bValid
																					&& checkLength2(
																							bookQty,
																							"Book Quantity");
																			bValid = bValid
																					&& checkLength2(
																							physicalQty,
																							"Physical Quantity");
																			bValid = bValid
																					&& checkLength1(
																							uomId,
																							"Uom");

																			if (bValid) {
																				alert("hiddenid"
																						+ hiddenID
																								.val());
																				if (hiddenID
																						.val() == "0"
																						|| hiddenID
																								.val() == "") {

																					alert("value "
																							+ materialId
																									.val());

																					$(
																							"#PhysicalEdit tbody")
																							.append(
																									"<tr id="+phyid+">"

																											+ "<td><spring:bind path='physicalVerificationCommand.verificationLineIdChildEdit'><input type='hidden' name='verificationLineIdChildEdit' id='verificationLineIdChildEdit' value='0'/></spring:bind><spring:bind path='physicalVerificationCommand.materialIdChildEdit'><input type='hidden' name='materialIdChildEdit' id='materialIdChildEdit"
																											+ phyidEdit
																											+ "' value="
																											+ materialId
																													.val()
																											+ " class='textbox' readonly/></spring:bind><spring:bind path='physicalVerificationCommand.materialName'><input type='text' name='materialName' id='materialName"
																											+ phyidEdit
																											+ "' value="
																											+ $(
																													'#materialIdEdit :selected')
																													.text()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='physicalVerificationCommand.batchNoChildEdit'><input name='batchNoChildEdit' id='batchNoChildEdit"
																											+ phyidEdit
																											+ "' value="
																											+ batchNo
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='physicalVerificationCommand.bookQtyChildEdit'><input name='bookQtyChildEdit' id='bookQtyChildEdit"
																											+ phyidEdit
																											+ "' value="
																											+ bookQty
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='physicalVerificationCommand.physicalQtyChildEdit'><input name='physicalQtyChildEdit' id='physicalQtyChildEdit"
																											+ phyidEdit
																											+ "' value="
																											+ physicalQty
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='physicalVerificationCommand.uomIdChildEdit'><input type='hidden' name='uomIdChildEdit' id='uomIdChildEdit"
																											+ phyidEdit
																											+ "' value="
																											+ uomId
																													.val()
																											+ " class='textbox'/></spring:bind><spring:bind path='physicalVerificationCommand.uomName'><input name='uomName' id='uomName"
																											+ phyidEdit
																											+ "' value='"
																											+ $(
																													'#uomIdEdit :selected')
																													.text()
																											+ "' class='textbox'/></spring:bind></td>"
																											+ "<td><a href='#'  onclick='editPhysicalInEdit("
																											+ phyidEdit
																											+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removePhysicalInEdit("
																											+ phyidEdit
																											+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																											+ "</tr>");

																					phyidEdit++;

																					$(
																							this)
																							.dialog(
																									"close");

																				}
																				if (hiddenID
																						.val() != "0") {

																					$(
																							'#materialIdChildEdit'
																									+ hiddenID
																											.val())
																							.val(
																									materialId
																											.val());
																					$(
																							'#materialName'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#materialIdEdit :selected')
																											.text());
																					$(
																							'#batchNoChildEdit'
																									+ hiddenID
																											.val())
																							.val(
																									batchNo
																											.val());
																					$(
																							'#bookQtyChildEdit'
																									+ hiddenID
																											.val())
																							.val(
																									bookQty
																											.val());
																					$(
																							'#physicalQtyChildEdit'
																									+ hiddenID
																											.val())
																							.val(
																									physicalQty
																											.val());

																					$(
																							'#uomIdChildEdit'
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
																											'#uomIdEdit :selected')
																											.text());
																					$(
																							'#hiddenIdPhysicalPopUpEdit')
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

												$("#create-EditPhysical")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-PhysicalEdit")
																			.dialog(
																					"open");
																	//alert("opened");
																});
											});

											function removePhysicalInEdit(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}

											function disabledPhysicalInEdit(id) {
												//alert(link.id);
												alert("Deleting Particular Row Will Deleted Once You Click Update Button");
												document
														.getElementById("CheckPhysical"
																+ id).value = "1";
												document.getElementById(id).style.display = "none";
											}
											function editPhysicalInEdit(id) {
												//alert("edit row " + $('#materialIdChildEdit' + id).val());
												$("#dialog-form-PhysicalEdit")
														.dialog("open");

												$('#hiddenIdPhysicalPopUpEdit')
														.val(id);
												$('#materialIdEdit').val(
														$(
																'#materialIdChildEdit'
																		+ id)
																.val());

												$('#batchNoEdit').val(
														$(
																'#batchNoChildEdit'
																		+ id)
																.val());

												$('#bookQtyEdit').val(
														$(
																'#bookQtyChildEdit'
																		+ id)
																.val());
												$('#physicalQtyEdit').val(
														$(
																'#physicalQtyChildEdit'
																		+ id)
																.val());
												$('#uomIdEdit').val(
														$(
																'#uomIdChildEdit'
																		+ id)
																.val());

											}

											function sumAdd() {
												//alert("ss");  
												$('#lineAmtChild')
														.val(
																parseFloat($(
																		'#quantityChild')
																		.val())
																		* parseFloat($(
																				'#unitPriceChild')
																				.val()));
												/* if(!isNaN($('#lineAmtChild').val())){
													alert(parseFloat($('#PhysicalOrderValue').val()));
												$('#PhysicalOrderValue').val(parseFloat($('#lineAmtChild').val()));
												//alert("PhysicalOrderValue"+$('#PhysicalOrderValue').val());
												} */
											}
											/* function auditDetails(id)
											{
												$('#verificationDateEditHidden').val($('#verificationDateEdit').val());
											} */
										</script>




										<div id="dialog-form-PhysicalEdit"
											title="<spring:message code="label.AddNewPhysicalVerificationLineDetails" />">
											<p class="validateTips">
												<spring:message
													code="label.AllformfieldsarerequiredPhysical." />
											</p>
											<table class="tableGeneral">





												<tr>
													<td><spring:message code="label.materialName" /></td>
													<td><form:select path="materialId" id="materialIdEdit"
															class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>




												</tr>



												<tr>
													<td><spring:message code="label.batchNo" /></td>
													<td><form:input path="batchNo" id="batchNoEdit"
															class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.bookQty" /></td>
													<td><form:input path="bookQty" id="bookQtyEdit"
															class="textbox" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.physicalQty" /></td>
													<td><form:input path="physicalQty"
															id="physicalQtyEdit" class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.uomId" /></td>
													<td><form:select path="uomId" id="uomIdEdit"
															class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select><input type="hidden" name="hiddenIdPhysicalPopUpEdit"
														id="hiddenIdPhysicalPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>



										<div id="users-contain-PhysicalEdit">
											<!-- class="ui-widget" -->

											<!-- <div style="height: 200px;width: 1000px;overflow: auto;border: 1px solid #666;background-color: #ccc;padding: 8px;">
										 -->
											<table id="PhysicalEdit" class="table">

												<tr id="PhysicalEditHead">
													<th><spring:message code="label.materialName" /></th>
													<th><spring:message code="label.batchNo" /></th>
													<th><spring:message code="label.bookQty" /></th>
													<th><spring:message code="label.physicalQty" /></th>
													<th><spring:message code="label.uomId" /></th>
													<%-- <th><spring:message code="label.Edit" /></th>
													<th><spring:message code="label.Delete" /></th> --%>

												</tr>

											</table>
											<table class="table">



												<tbody />
												<c:forEach var="physicalVerificationLineEditList"
													items="${physicalVerificationLineEditList }">

													<tr
														id="${physicalVerificationLineEditList.verificationLineId}">

														<td><spring:bind
																path="physicalVerificationCommand.verificationLineIdChildEdit">
																<input type='hidden' name="verificationLineIdChildEdit"
																	id="verificationLineIdChildEdit"
																	value="${physicalVerificationLineEditList.verificationLineId }" />
															</spring:bind> <spring:bind
																path="physicalVerificationCommand.materialIdChildEdit">
																<input type="hidden" name="materialIdChildEdit"
																	id="materialIdChildEdit${physicalVerificationLineEditList.verificationLineId }"
																	class="textbox"
																	value="${physicalVerificationLineEditList.materialId }" />
															</spring:bind> <spring:bind
																path="physicalVerificationCommand.materialName">
																<input name="materialName"
																	id="materialName${physicalVerificationLineEditList.verificationLineId }"
																	class="textbox"
																	value="${physicalVerificationLineEditList. materialName}"
																	readonly="readonly" />
															</spring:bind></td>

														<td><spring:bind
																path="physicalVerificationCommand.batchNoChildEdit">
																<input name="batchNoChildEdit"
																	id="batchNoChildEdit${physicalVerificationLineEditList.verificationLineId }"
																	class="textbox"
																	value="${physicalVerificationLineEditList.batchNo }"
																	readonly="readonly" />
															</spring:bind></td>
														<td><spring:bind
																path="physicalVerificationCommand.bookQtyChildEdit">
																<input name="bookQtyChildEdit"
																	id="bookQtyChildEdit${physicalVerificationLineEditList.verificationLineId }"
																	class="textbox"
																	value="${physicalVerificationLineEditList.bookQty }"
																	readonly="readonly" />
															</spring:bind></td>
														<td><spring:bind
																path="physicalVerificationCommand.physicalQtyChildEdit">
																<input name="physicalQtyChildEdit"
																	id="physicalQtyChildEdit${physicalVerificationLineEditList.verificationLineId }"
																	class="textbox"
																	value="${physicalVerificationLineEditList.physicalQty }"
																	onKeyPress="return numbersonly(this, event)" />
															</spring:bind></td>
														<td><spring:bind
																path="physicalVerificationCommand.uomIdChildEdit">
																<input type="hidden" name="uomIdChildEdit"
																	id="uomIdChildEdit${physicalVerificationLineEditList.verificationLineId }"
																	class="textbox"
																	value="${physicalVerificationLineEditList.uomId }"
																	readonly="readonly" />
															</spring:bind> <spring:bind path="physicalVerificationCommand.uomName">
																<input name="uomName"
																	id="uomName${physicalVerificationLineEditList.verificationLineId }"
																	class="textbox"
																	value="${physicalVerificationLineEditList.uomName }"
																	readonly="readonly" />
															</spring:bind> <input type="hidden"
															name="CheckPhysical${physicalVerificationLineEditList.verificationLineId}"
															id="CheckPhysical${physicalVerificationLineEditList.verificationLineId}"
															value="0" /></td>

														<%-- <td><a href="#" class="remove"><strong><img src="images/Edit.jpg" height="25px" width="25px" onclick="editPhysicalInEdit(${physicalVerificationLineEditList.verificationLineId })" /></strong></a></td><td><a href="#"  class="remove" onclick="disabledPhysicalInEdit(${physicalVerificationLineEditList.verificationLineId})"><strong><img src="images/button_cancel.png"  height="25px" width="25px" /></strong></a></td> --%>
													</tr>

												</c:forEach>

											</table>

											<!-- </div> -->
										</div>
										<div id="extender"></div>
										<%--  <button id="create-EditPhysical" type="button"><spring:message code="label.AddNewPhysicalVerificationLineDetails" /></button> 
									 --%>

									</div>

								</div>
							</div>
							<c:choose>
								<c:when test="${update}">

									<input type="submit"
										value="<spring:message code="label.update"/> "
										class="btn btn-primary" id="updateButton" />
								</c:when>

								<c:otherwise>

									<input type="submit"
										value="<spring:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="updateButton" />
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</form:form>
				</div>


			</div>
		</div>


	</div>

</body>
</html>