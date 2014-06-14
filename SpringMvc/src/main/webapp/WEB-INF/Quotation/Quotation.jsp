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
						$('#sumbtnid')
								.click(
										function(event) {

											$('#addquotationform')
													.validate(
															{
																rules : {
																	quotationNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	vendorId : {
																		required : true
																	},
																	quotationDate : {
																		required : true
																	},

																	quantity : {
																		required : true
																	},
																	quotStatusId : {
																		required : true
																	},

																},
																messages : {
																	quotationNo : {
																		required : "<font style='color: red;'><b>Qutation No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>Allowes alphanumerics</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed</b></font>"
																	},
																	vendorId : "<font style='color: red;'><b>Vendor is Required</b></font>",
																	quotationDate : "<font style='color: red;'><b>Qutation Date is Required</b></font>",
																	quantity : "<font style='color: red;'><b>Quantity is Required</b></font>",
																	quotStatusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},

															});
											
											if($('#quotationNo').val()!="" && $('#vendorId').val()!="" && $('#quotationDate').val()!="" && $('#quotStatusId').val()!=""){
												if($('#checkChildData').val()==0)
												{
												document.getElementById("addmessage").style.display = "block";
												$('#addmessage').html("Warning! Please Enter AtLeast One Quotation Line");
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
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editquotationForm')
													.validate(
															{
																rules : {
																	quotationNoEditt : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	vendorIdEditt : {
																		required : true
																	},
																	quotationDateEditt : {
																		required : true
																	},

																	quantityEditt : {
																		required : true
																	},
																	quotStatusIdEditt : {
																		required : true
																	},

																},
																messages : {
																	quotationNoEditt : {
																		required : "<font style='color: red;'><b>Qutation No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>Allowes alphanumerics</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed</b></font>"
																	},
																	vendorIdEditt : "<font style='color: red;'><b>Vendor is Required</b></font>",
																	quotationDateEditt : "<font style='color: red;'><b>Qutation Date is Required</b></font>",
																	quantityEditt : "<font style='color: red;'><b>Quantity is Required</b></font>",
																	quotStatusIdEditt : "<font style='color: red;'><b>Status is Required</b></font>",
																},

															});

										});

					});
</script>
<script type="text/javascript">
	function AjaxForStorLoc(id, Mode) {
		var pId = $('#' + id).val();
		/* alert(pId); */
		var i = 1, msg = null;

		$
				.ajax({
					type : "POST",
					url : "forStorLocIdsQuotation.mnt",
					data : "plantId=" + pId,
					success : function(response) {
						var ss = "";
						if (Mode == 'AddMode') {
							ss = $("#slId").empty();
							msg = "The Selected Plant Name Does Not Contain Storage Locations";
						} else if (Mode == 'ToAddMode') {
							ss = $("#toSlId").empty();
							msg = "The Selected To Plant Name Does Not Contain Storage Locations";
						} else if (Mode == 'EditMode') {
							ss = $("#slIdEdit").empty();
							msg = "The Selected Plant Name Does Not Contain Storage Locations";
						} else {
							ss = $("#toSlIdEdit").empty();
							msg = "The Selected To Plant Name Does Not Contain Storage Locations";
						}
						if (response == "") {
							if (Mode == 'AddMode' || Mode == 'ToAddMode') {
								document.getElementById("addmessage").style.display = "block";
								$('#addmessage').html(msg);
							} else {
								document.getElementById("addmessage").style.display = "block";
								$('#addmessage').html(msg);
							}

						} else {
							document.getElementById("addmessage").style.display = "none";
							document.getElementById("addmessage").style.display = "none";

							$.each(response, function(key, value) {
								if (i == 1) {
									ss.append(new Option("-Select-", "0"));
									ss.append(new Option(value, key));
								} else {
									ss.append(new Option(value, key));
								}
								i++;
							});

						}

					},
					error : function(e) {
						alert('Error' + e);
					}

				});

	}
</script>
<script type="text/javascript">
	function doAjaxPostEdit() {

		var quotationId = $('#quotationNoEditt').val();

		var qid = $('#quotationIdEditt').val();

		$
				.ajax({

					type : "POST",

					url : "quotationDuplicateEditCheck.mnt",

					data : "quotationId=" + quotationId + "&qid=" + qid,

					success : function(response) {
	var checkResponse = "Quotation Number is Already Exists Please try some other number";

						if (checkResponse == response) {
							document.getElementById("editmessage").style.display = "block";
							$('#editmessage').html(response);
							$("#updateid").hide();
							
						} else {
							document.getElementById("editmessage").style.display = "none";
							$("#updateid").show();
						}
					},

					error : function(e) {

					}

				});

	}
</script>
<script type="text/javascript">
	function doAjaxPost() {

		var quotationno = $('#quotationNo').val();

		$
				.ajax({

					type : "POST",

					url : "quotationDuplicateAddCheck.mnt",

					data : "quotationno=" + quotationno,

					success : function(response) {

						var checkResponse = "Quotation Number is Already Exists Please try some other number";

						if (checkResponse == response) {
							document.getElementById("addmessage").style.display = "block";
								$('#addmessage').html(response);
								$("#sumbtnid").hide();
						} else {
							document.getElementById("addmessage").style.display = "none";
							$("#sumbtnid").show();
						}
					},

					error : function(e) {

					}

				});

	}
</script>

<!--  Date picker -->
<script>
	function dateFun(datePattern) {

		$('#quotationDate,#deliveryDate,#adddeliveryDate,#editrowdeliveryDate,#addrowdeliveryDate,#rfqDateEditt,#quotationDateEditt,#deliveryDateEditt')
				.datepicker({
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					 minDate: 0,
						onSelect: function (date) {
				            var date2 = $('#quotationDate').datepicker('getDate');
				            date2.setDate(date2.getDate() + 0);
				            $('#deliveryDate').datepicker('option', 'minDate', date2);
				        }
				});

	}
</script>
<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();

	});

	$(function() {
		$("#tabsForAdd").tabs();
	});
	$(function() {
		$("#tabsForEdit").tabs();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#tabsForEdit").hide();
			$("#warningmesssage").hide();

		});
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
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#bsId").focus();
		$('#search,#add').click(function(e) {
			$("#quotationNo").focus();
			$("#bsId").focus();
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});
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

<!-- Horizantol scroll -->
<style type="text/css">
#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 900px;
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
		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();

		});
	});
</script>

<script type="text/javascript">
	function multiply() {
		var quantity = document.getElementById("quantity");
		var perUnit = document.getElementById("perUnit");
		var result = quantity.value * perUnit.value;
		document.getElementById("lineAmount").value = result;
		document.getElementById("netPrice").value = result;

	}
</script>
<script type="text/javascript">
	function ediMultiply() {
		var editquantity = document.getElementById("quantityEditt");
		var editperUnit = document.getElementById("perUnitEditt");
		var ediRresult = editquantity.value * editperUnit.value;
		document.getElementById("lineAmountEditt").value = ediRresult;
		document.getElementById("netPriceEditt").value = ediRresult;
	}
</script>
<script type="text/javascript">
	
</script>


</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Quotation</div>

		<!-- Tabs Declaration -->
		<div>
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="quotationEditList" items="${quotationEditList}">
						<c:set var="quotationEditList" value="${quotationEditList }"></c:set>
					</c:forEach>
					<c:if test="${quotationEditList!=null}">

						<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
									code="label.edit" /></a></li>
					</c:if>
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
								code="label.search" /></a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
								code="label.add" /></a></li>
				</ul>

				<!-- Search tab part -->

				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">
						<form:form action="quotationSearch.mnt" method="GET"
							commandName="quotationCommand">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach items="${param.list}">
											<div class="alert-success">
												<strong><spring:message code="label.success" /> </strong>
												<spring:message code="label.quotation" />
												<spring:message code="label.saveSuccess" />
											</div>
										</c:forEach> <c:forEach items="${param.listwar}">
											<div class="alert-danger">
												<strong><spring:message code="label.error" /> </strong>
												<spring:message code="label.quotation" />
												<spring:message code="label.saveFail" />
											</div>
										</c:forEach> <c:forEach items="${quotationUpadateSuccess}">
											<div class="alert-success">
												<strong><spring:message code="label.success" /> </strong>
												<spring:message code="label.quotation" />
												<spring:message code="label.updateSuccess" />
											</div>
										</c:forEach> <c:forEach items="${quotationUpadateFail}">
											<div class="alert-danger">
												<strong><spring:message code="label.error" /> </strong>
												<spring:message code="label.quotation" />
												<spring:message code="label.updateFail" />
											</div>
										</c:forEach> <c:forEach items="${quotationDeleteSuccess}">
											<div class="alert-success">
												<strong><spring:message code="label.success" /> </strong>
												<spring:message code="label.quotation" />
												<spring:message code="label.deleteSuccess" />
											</div>
										</c:forEach> <c:forEach items="${quotationDeleteFail}">
											<div class="alert-danger">
												<strong><spring:message code="label.error" /> </strong>
												<spring:message code="label.quotation" />
												<spring:message code="label.deleteFail" />
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"></td>
								</tr>

								<tr id="mainSearch">
									<td><spring:message code="label.searchby" /> <form:select
											path="xmlLabel" cssClass="select">
											<form:options items="${xmlItems}" />
										</form:select> <spring:bind path="quotationCommand.operations">
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
										</spring:bind> <form:input path="basicSearchId" id="bsId" cssClass="textbox" /></td>
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
											<c:when test="${true}">
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
								<form:form action="quotationAdvanceSearch.mnt" method="get"
									commandName="quotationCommand" name="advanceSearchFinal"
									id="advanceSearchFinal">
									<tr>
										<td><a href="quotationAdvanceSearch.mnt"><font
												style="color: blue" id="aslink"><u><b>Advanced
															Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
												style="color: blue"><u><b>Back To Basic
															Search</b></u></font></a></td>

									</tr>
								</form:form>
							</table>
							<form:form action="quotationAdvanceSearchOperations.mnt"
								commandName="quotationCommand">
								<div id="advanceSearchDiv" style="display: none">
									<table class="tableGeneral">
										<c:forEach var="xmlLabelValue"
											items="${quotationSearchAdvance}">
											<tr>
												<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
														path="firstLabel" id="firstLabel"
														value="${xmlLabelValue.firstLabel}" /></td>
												<td><spring:bind path="quotationCommand.operations1">
														<select class="select" name="operations1">
															<option value="<spring:message code='assignedOperator'/>">
																<spring:message code="label.equalsTo" />
															</option>
															<option
																value="<spring:message code='notequalsOperator'/>">
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
														id="advanceSearchkk" cssClass="textbox"/></td>
											</tr>

										</c:forEach>
										<tr>
											<form:hidden path="advanceSearchHidden"
												id="advanceSearchHidden" />
											<td colspan="3"><c:choose>
													<c:when test="${true}">
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

						</form:form>

						<c:if test="${quotationSearch!=null}">
							<display:table id="quotationValue" name="quotationSearch"
								requestURI="quotationSearch.mnt" pagesize="5" class="table">
								<!-- Displaying  the Searched information by using display tag -->
								<display:column property="quotationNo"
									titleKey="label.quotationno" media="html" sortable="true" />
								<display:column property="vendorId" titleKey="label.vendor"
									media="html" sortable="true" />
								<%-- <display:column property="rfqid" titleKey="label.rfqno"
									media="html" sortable="true"/> --%>

								<display:column property="quotationDate"
									titleKey="label.quotqtiondate" media="html" sortable="true" />
								<display:column property="description" titleKey="label.desc"
									media="html" sortable="true" />
								<display:column property="status" titleKey="label.qstatus"
									media="html" sortable="true" />
								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${true}">

											<a
												href="quotationIdEdit.mnt?quotationId=<c:out value="${quotationValue.quotationId}"/>"
												style="color: red"><img src="images/Edit.jpg"
												width="20px" height="20px" /> </a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Edit.jpg" width="20px"
												class="btn btn-danger" height="20px" /> </a>
										</c:otherwise>
									</c:choose>
								</display:column>
								<display:column titleKey="label.delete">
									<c:choose>
										<c:when test="${true}">
											<a
												href="quotationIdDelete.mnt?quotationId=<c:out value="${quotationValue.quotationId}"/>"
												style="color: red"
												onclick="return confirm('Do u want to delete the Record?')"><img
												src="images/Delete.jpg" width="20px" height="20px" /></a>
										</c:when>
										<c:otherwise>
											<a> <img src="images/Delete.jpg" width="20px"
												class="btn btn-danger" height="20px" />
											</a>
										</c:otherwise>

									</c:choose>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" />

							</display:table>
						</c:if>
					</div>
				</div>

				<!-- Add tab details -->


				<div id="tabs-3" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						<table>
						<tr>
							<td colspan="4" class="alert-warning" id="addmessage"
								style="display: none; width: 470px; height: 25px;"></td>
						</tr>
							<tr>
								<td id="addmessage" style="display: none;">
									<div class="alert-warning">
										<strong> <spring:message code="label.warning" /></strong>
										<spring:message code="label.quotationno" />
										<spring:message code="label.duplicateCheck" />
									</div>
								</td>
							</tr>
						</table>
						<form:form action="quotation.mnt" method="GET"
							commandName="quotationCommand" id="addquotationform">

							<table class="tableGeneral">
								<form:hidden path="aid" />
								<form:hidden path="quotationIdEditt" />
								<form:hidden path="quotationLineIdEditt" />
								<tr>
									<td><spring:message code="label.quotationno" /><font
										color="red">*</font></td>
									<td><form:input path="quotationNo" id="quotationNo"
											class="textbox" onkeyup="doAjaxPost()" maxlength="20" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.vendor" /><font
										color="red">*</font></td>
									<td><form:select path="vendorId" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${vendor}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.rfqno" /></td>
									<td><form:select path="rfqid" class="select">
											<form:option value="0">-Select-</form:option>
											<form:options items="${rfqno}" />
										</form:select></td>
								</tr>

								<tr>
									<td><spring:message code="label.quotqtiondate" /><font
										color="red">*</font></td>
									<td><form:input path="quotationDate" id="quotationDate"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.desc" /></td>
									<td><form:textarea path="description" id="description"
											class="textbox" maxlength="250" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.qstatus" /><font
										color="red">*</font></td>
									<td><form:select path="quotStatusId" id="quotStatusId"
											class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${status }" />
										</form:select>
										<input type="hidden" name="checkChildData"
											id="checkChildData" class="textbox" value="0"/>
										</td>
								</tr>

							</table>

							<!-- Sub tabbing for adding Quotation Line details -->
							<div id="tabsForAdd">
								<div id="scroll1">
									<!-- Quotation Line tab -->
									<ul>
										<li><a href="#subtabs-1"><spring:message
													code="label.quotationline" /> </a></li>

									</ul>

									<div align="center">

										<script>
											var qltrid = 1;
											$(function() {

												var mId = $("#mId"), mvalue = $("#mNumber"), quantity = $("#quantity"), uomm = $("#uomm"), uvalue = $("#uNumber"), perUnit = $("#perUnit"), lineAmount = $("#lineAmount"), netPrice = $("#netPrice"), cId = $("#cId"), cvalue = $("#cNumber"), deliveryDate = $("#deliveryDate"), pId = $("#pId"), pvalue = $("#pNumber"), stId = $("#stId"), svalue = $("#sNumber"), stLId = $("#slId"), sLvalue = $("#sLNumber"), hiddenID = $("#hiddenIdQuotationPopUp"),

												allFields = $([]).add(mId).add(
														mvalue).add(quantity)
														.add(uomm).add(uvalue)
														.add(perUnit).add(
																lineAmount)
														.add(netPrice).add(cId)
														.add(cvalue).add(
																deliveryDate)
														.add(pId).add(pvalue)
														.add(stId).add(svalue)
														.add(stLId)
														.add(sLvalue).add(
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
														updateTips(""+ n+ " is required and must be a number ");
														return false;
													} else {
														return true;
													}
												}

												function selectLength(o, n) {
													if (o.val() == '0') {
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

												$("#dialog-form-QuotLine")
														.dialog(
																{
																	autoOpen : false,
																	height : 460,
																	width : 350,
																	modal : true,
																	buttons : {
																		Submit : function() {
																			var bValid = true;
																			allFields
																					.removeClass("ui-state-error");

																			bValid = bValid
																					&& selectLength(
																							mId,
																							"Material");
																			bValid = bValid
																					&& checkLength(
																							quantity,
																							"Quantity",
																							1,
																							16);
																			bValid = bValid
																					&& selectLength(
																							uomm,
																							"UOM");

																			bValid = bValid
																					&& checkLength(
																							perUnit,
																							"Per Unit",
																							1,
																							16);

																			bValid = bValid
																					&& selectLength(
																							cId,
																							"Currency");
																			bValid = bValid
																					&& checkLength(
																							deliveryDate,
																							"Delivery Date",
																							1,
																							16);

																			bValid = bValid
																					&& selectLength(
																							pId,
																							"Plant");
																			

																			bValid = bValid
																					&& selectLength(
																							stLId,
																							"Storage Location");
																			
																			bValid = bValid
																			&& selectLength(
																					stId,
																					"Status");

																			bValid = bValid
																					&& checkRegexp(
																							quantity,
																							/^([0-9])+$/i,
																							"Quantity is required and must be a number");
																			bValid = bValid
																					&& checkRegexp(
																							perUnit,
																							/^([0-9])+$/i,
																							"Unit Cost may consist of  0-9");

																			if (bValid) {

																				if (hiddenID
																						.val() == "0"
																						|| hiddenID
																								.val() == "") {

																					$(
																							"#quotLineAdd tbody")
																							.append(
																									"<tr id="+qltrid+">"

																											+ "<td align='center'><input type='hidden' name='mId' id='mId"
																											+ qltrid
																											+ "' value="
																											+ mId
																													.val()
																											+ "  class='textbox'readonly/><input type='text' name='mNumber' id='mNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#mId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input name='quantity' id='quantity"
																											+ qltrid
																											+ "' value="
																											+ quantity
																													.val()
																											+ " class='textbox' readonly/></td>"

																											+ "<td><input type='hidden' name='uomm' id='uomm"
																											+ qltrid
																											+ "' value="
																											+ uomm
																													.val()
																											+ " class='textbox'/><input type='text' name='uNumber' id='uNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#uomm :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input name='perUnit' id='perUnit"
																											+ qltrid
																											+ "' value="
																											+ perUnit
																													.val()
																											+ " class='textbox' readonly/></td>"

																											+ "<td><input name='lineAmount' id='lineAmount"
																											+ qltrid
																											+ "' value="
																											+ lineAmount
																													.val()
																											+ " class='textbox' readonly/></td>"

																											+ "<td><input name='netPrice' id='netPrice"
																											+ qltrid
																											+ "' value="
																											+ netPrice
																													.val()
																											+ " class='textbox' readonly/></td>"
																											+ "<td><input type='hidden' name='cId' id='cId"
																											+ qltrid
																											+ "' value="
																											+ cId
																													.val()
																											+ " class='textbox'/><input type='text' name='cNumber' id='cNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#cId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"
																											+ "<td><input name='deliveryDate' id='deliveryDate"
																											+ qltrid
																											+ "' value="
																											+ deliveryDate
																													.val()
																											+ " class='textbox' readonly/></td>"

																											+ "<td><input type='hidden' name='pId' id='pId"
																											+ qltrid
																											+ "' value="
																											+ pId
																													.val()
																											+ " class='textbox'/><input type='text' name='pNumber' id='pNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#pId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input type='hidden' name='stLId' id='stLId"
																											+ qltrid
																											+ "' value="
																											+ stLId
																													.val()
																											+ " class='textbox'/>"
																											+ "<input type='text' name='sLNumber' id='sLNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#slId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"
																											+ "<td><input type='hidden' name='stId' id='stId"
																											+ qltrid
																											+ "' value="
																											+ stId
																													.val()
																											+ " class='textbox'/>"
																											+ "<input type='text' name='sNumber' id='sNumber"
																											+ qltrid
																											+ "' value="
																											+ $('#stId :selected').text()
																											+ "  class='textbox'readonly/></td>"
																											+"<td><a href='#'  onclick='editMaterialm("
																											+ qltrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeMaterialm("
																											+ qltrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					
																					$('#checkChildData').val(qltrid);

																					qltrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																				if (hiddenID
																						.val() != "0") {
																					$(
																							'#mId'
																									+ hiddenID
																											.val())
																							.val(
																									mId
																											.val());
																					$(
																							'#mNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#mId :selected')
																											.text());
																					$(
																							'#quantity'
																									+ hiddenID
																											.val())
																							.val(
																									quantity
																											.val());
																					$(
																							'#uomm'
																									+ hiddenID
																											.val())
																							.val(
																									uomm
																											.val());
																					$(
																							'#uNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#uomm :selected')
																											.text());

																					$(
																							'#perUnit'
																									+ hiddenID
																											.val())
																							.val(
																									perUnit
																											.val());
																					$(
																							'#lineAmount'
																									+ hiddenID
																											.val())
																							.val(
																									lineAmount
																											.val());
																					$(
																							'#netPrice'
																									+ hiddenID
																											.val())
																							.val(
																									netPrice
																											.val());
																					$(
																							'#cId'
																									+ hiddenID
																											.val())
																							.val(
																									cId
																											.val());
																					$(
																							'#cNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#cId :selected')
																											.text());
																					$(
																							'#deliveryDate'
																									+ hiddenID
																											.val())
																							.val(
																									deliveryDate
																											.val());

																					$(
																							'#pId'
																									+ hiddenID
																											.val())
																							.val(
																									pId
																											.val());
																					$(
																							'#pNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#pId :selected')
																											.text());

																					$(
																							'#stLId'
																									+ hiddenID
																											.val())
																							.val(
																									stLId
																											.val());
																					$(
																							'#sLNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#slId :selected')
																											.text());
																					$(
																							'#stId'
																									+ hiddenID
																											.val())
																							.val(
																									stId
																											.val());
																					$(
																							'#sNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#stId :selected')
																											.text());
																					$(
																							'#hiddenIdQuotationPopUp')
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

												$("#create-AddQuotLine")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-QuotLine")
																			.dialog(
																					"open");

																});
											});
											function removeMaterialm(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editMaterialm(id) {
												//alert("edit row " + id);

												$("#dialog-form-QuotLine")
														.dialog("open");

												$('#mId').val(
														$('#mId' + id).val());
												$('#mNumber').val(
														$('#mNumber' + id)
																.val());
												$('#quantity').val(
														$('#quantity' + id)
																.val());
												$('#uomm').val(
														$('#uomm' + id).val());
												$('#uNumber').val(
														$('#uNumber' + id)
																.val());

												$('#perUnit').val(
														$('#perUnit' + id)
																.val());
												$('#lineAmount').val(
														$('#lineAmount' + id)
																.val());
												$('#netPrice').val(
														$('#netPrice' + id)
																.val());
												$('#cId').val(
														$('#cId' + id).val());
												$('#cNumber').val(
														$('#cNumber' + id)
																.val());
												$('#deliveryDate').val(
														$('#deliveryDate' + id)
																.val());
												$('#pId').val(
														$('#pId' + id).val());
												$('#pNumber').val(
														$('#pNumber' + id)
																.val());

												$('#slId').val(
														$('#stLId' + id).val());

												$('#sLNumber').val(
														$('#sLNumber' + id)
																.val());
												$('#stId').val(
														$('#stId' + id).val());
												$('#sNumber').val(
														$('#sNumber' + id)
																.val());

												$('#hiddenIdQuotationPopUp')
														.val(id);

											}
										</script>


										<div id="dialog-form-QuotLine"
											title="Add New QuotLine Details">
											<p class="validateTips"></p>
											<table class="tableGeneral">

												<tr>
													<td><spring:message code="label.qmaterial" /><font
														color="red">*</font></td>
													<td><form:select path="mId" class="select" id="mId"
															cssStyle="height:25px" onchange="one()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="mNumber" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.qty" /><font
														color="red">*</font></td>
													<td><form:input path="quantity" id="quantity"
															class="textbox" onkeyup="multiply()" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.quom" /><font
														color="red">*</font></td>
													<td><form:select path="uomm" id="uomm" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="uNumber" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.perunit" /></td>
													<td><form:input path="perUnit" id="perUnit"
															class="textbox" onkeyup="multiply()" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.lineamt" /></td>
													<td><form:input path="lineAmount" id="lineAmount"
															class="textbox" readonly="true" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.netprice" /></td>
													<td><form:input path="netPrice" id="netPrice"
															class="textbox" readonly="true" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.qcurrency" /><font
														color="red">*</font></td>
													<td><form:select path="cId" id="cId" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${currency }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="cNumber" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.dldate" /><font
														color="red">*</font></td>
													<td><form:input path="deliveryDate" id="deliveryDate"
															class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.qplant" /><font
														color="red">*</font></td>
													<td><form:select path="pId" id="pId" class="select"
															cssStyle="height:25px"
															onchange="AjaxForStorLoc(this.id,'AddMode')">
															<form:option value="0">-Select-</form:option>
															<form:options items="${plant }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="pNumber" /></td>
												</tr>
												

												<tr>
													<td><spring:message code="label.storloc" /><font
														color="red">*</font></td>
													<td><form:select path="stLId" id="slId" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<%-- <form:options items="${storageId }" />  --%>
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.qstatus" /><font
														color="red">*</font></td>
													<td><form:select path="stId" id="stId" class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${status }" />
														</form:select> <input type='hidden' id="sNumber" /> <input
														type="hidden" name="hiddenIdQuotationPopUp"
														id="hiddenIdQuotationPopUp" value="0" /></td>
												</tr>

												<tr>
													<td><input type='hidden' id="sLNumber" /></td>
												</tr>

											</table>
										</div>



										<div id="users-contain-quotLine">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="quotLineAdd" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.qmaterial" /></th>
														<th><spring:message code="label.qty" /></th>
														<th><spring:message code="label.quom" /></th>
														<th><spring:message code="label.perunit" /></th>
														<th><spring:message code="label.lineamt" /></th>
														<th><spring:message code="label.netprice" /></th>
														<th><spring:message code="label.qcurrency" /></th>
														<th><spring:message code="label.dldate" /></th>
														<th><spring:message code="label.qplant" /></th>
														<th><spring:message code="label.storloc" /></th>
														<th><spring:message code="label.qstatus" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>
													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
										<button id="create-AddQuotLine" type="button">Add New
											Quotation Line</button>


									</div>
								</div>
							</div>
							<c:choose>
								<c:when test="${true }">

									<input type="submit"
										value="<spring:message code="label.save"/>"
										class="btn btn-primary" id="sumbtnid" />
								</c:when>
								<c:otherwise>
									<input type="submit" disabled="disabled"
										value="<spring:message code="label.save"/>"
										class="btn btn-danger" id="sumbtnid" />
								</c:otherwise>
							</c:choose>
							<input type="reset" value="<spring:message code="label.reset"/>"
								class="btn btn-primary" />
						</form:form>
					</div>

				</div>

				<!-- Edit tab -->

				<div id="tabs-1" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">

						<form:form action="quotationEdit.mnt" method="GET"
							commandName="quotationCommand" id="editquotationForm">

							<c:if test="${quotationEditList!=null}">

								<table class="tableGeneral">

									<form:hidden path="quotationIdEditt" />
									<tr>
										<td><spring:message code="label.quotationno" /><font
											color="red">*</font></td>
										<td><form:input path="quotationNoEditt" class="textbox"
												onkeyup="doAjaxPostEdit()" maxlength="20" /></td>
										<td colspan="4" class="alert-warning" id="editmessage"
								style="display: none; width: 470px; height: 25px;"></td>
										<!-- <td style="display: none" id="editmessage"
											class="alert-warning"></td> -->
									</tr>
									<tr>
										<td><spring:message code="label.vendor" /><font
											color="red">*</font></td>
										<td><form:select path="vendorIdEditt" class="select">
												<form:option value="0">-Select-</form:option>
												<form:options items="${vendor}" />
											</form:select></td>
									</tr>
									<tr>
										<td><spring:message code="label.rfqno" /></td>
										<td><form:select path="rfqidEditt" class="select">
												<form:option value="0">-Select-</form:option>
												<form:options items="${rfqno}" />
											</form:select></td>
									</tr>

									<tr>
										<td><spring:message code="label.quotqtiondate" /><font
											color="red">*</font></td>
										<td><form:input path="quotationDateEditt"
												id="quotationDateEditt" class="textbox" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.desc" /></td>
										<td><form:textarea path="descriptionEditt"
												id="description" class="textbox" maxlength="250" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.qstatus" /><font
											color="red">*</font></td>
										<td><form:select path="quotStatusIdEditt"
												id="quotStatusIdEditt" class="select" cssStyle="height:25px">
												<form:option value="">-Select-</form:option>
												<form:options items="${status }" />
											</form:select></td>
									</tr>

								</table>



								<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
										<div id="scroll1">
											<ul>

												<li><a href="#tab1"><spring:message
															code="label.quotationline" /></a></li>

											</ul>

											<!--Sub Tab-1 -->
											<div id="tab1">
												<div align="center">
													<script>
													
														var btrid = 1;
														$(function() {

															var mIdEditt = $("#mIdEditt"), quantityEditt = $("#quantityEditt"), uommEditt = $("#uommEditt"), perUnitEditt = $("#perUnitEditt"), lineAmountEditt = $("#lineAmountEditt"), netPriceEditt = $("#netPriceEditt"), cIdEditt = $("#cIdEditt"), deliveryDateEditt = $("#deliveryDateEditt"), pIdEditt = $("#pIdEditt"), stLIdEditt = $("#slIdEdit"), stIdEditt = $("#stIdEditt"), hiddenEdit = $("#hiddenIdEditQPopUp"),

															allFields = $([])
																	.add(
																			mIdEditt)
																	.add(
																			quantityEditt)
																	.add(
																			uommEditt)
																	.add(
																			perUnitEditt)
																	.add(
																			lineAmountEditt)
																	.add(
																			netPriceEditt)
																	.add(
																			cIdEditt)
																	.add(
																			deliveryDateEditt)
																	.add(
																			pIdEditt)
																	.add(
																			stLIdEditt)
																	.add(
																			stIdEditt)
																	.add(
																			hiddenEdit), tips = $(".validateTips");

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
																	updateTips(""+n +" is required and must be a number");
																	return false;
																} else {
																	return true;
																}
															}

															function selectLength(
																	o, n) {
																if (o.val() == '0') {
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
																	"#dialog-form-QuotationEdit")
																	.dialog(
																			{
																				autoOpen : false,
																				height : 460,
																				width : 350,
																				modal : true,
																				buttons : {
																					"Submit" : function() {
																						var bValid1 = true;
																						allFields
																								.removeClass("ui-state-error");
																						bValid1 = bValid1
																								&& selectLength(
																										mIdEditt,
																										"Material");
																						bValid1 = bValid1
																								&& checkLength(
																										quantityEditt,
																										"Quantity",
																										1,
																										16);
																						bValid1 = bValid1
																								&& selectLength(
																										uommEditt,
																										"UOM");
																						bValid1 = bValid1
																								&& checkLength(
																										perUnitEditt,
																										"Per Unit",
																										1,
																										16);

																						bValid1 = bValid1
																								&& selectLength(
																										cIdEditt,
																										"Currency");
																						bValid1 = bValid1
																								&& checkLength(
																										deliveryDateEditt,
																										"Delivery Date",
																										1,
																										16);

																						bValid1 = bValid1
																								&& selectLength(
																										pIdEditt,
																										"Plant");

																						bValid1 = bValid1
																								&& selectLength(
																										stLIdEditt,
																										"Storage Location");
																						bValid1 = bValid1
																								&& selectLength(
																										stIdEditt,
																										"Status");
																						bValid1 = bValid1
																								&& checkRegexp(
																										quantityEditt,
																										/^([0-9])+$/i,
																										"Quantity is required and must be a number");
																						bValid1 = bValid1
																								&& checkRegexp(
																										perUnitEditt,
																										/^([0-9])+$/i,
																										"Unit Cost may consist of  0-9");

																						if (bValid1) {

																							if (hiddenEdit
																									.val() == "0"
																									|| hiddenEdit
																											.val() == "") {
																								$(
																										"#AddQuotationEdit tbody")
																										.append(
																												"<tr id="+btrid+">"
																														+ "<td><spring:bind path='quotationCommand.quotationLineIdEditt'><input type='hidden' name='quotationLineIdEditt' id='quotationLineIdEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='quotationCommand.mIdEditt'><input type='hidden' name='mIdEditt' id='mIdEditt"
																														+ btrid
																														+ "' value="
																														+ mIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"

																														+ "<spring:bind path='quotationCommand.materialName'><input type='text' name='materialName' id='materialName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#mIdEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='quotationCommand.quantityEditt'><input name='quantityEditt' id='quantityEditt"
																														+ btrid
																														+ "' value="
																														+ quantityEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='quotationCommand.uommEditt'><input type='hidden' name='uommEditt' id='uommEditt"
																														+ btrid
																														+ "' value="
																														+ uommEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"

																														+ "<spring:bind path='quotationCommand.uomName'><input type='text' name='uomName' id='uomName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#uommEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='quotationCommand.perUnitEditt'><input name='perUnitEditt' id='perUnitEditt"
																														+ btrid
																														+ "' value="
																														+ perUnitEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"
																														+ "<td><spring:bind path='quotationCommand.lineAmountEditt'><input name='lineAmountEditt' id='lineAmountEditt"
																														+ btrid
																														+ "' value="
																														+ lineAmountEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"
																														+ "<td><spring:bind path='quotationCommand.netPriceEditt'><input name='netPriceEditt' id='netPriceEditt"
																														+ btrid
																														+ "' value="
																														+ netPriceEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='quotationCommand.cIdEditt'><input type='hidden' name='cIdEditt' id='cIdEditt"
																														+ btrid
																														+ "' value="
																														+ cIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='quotationCommand.currencyName'><input type='text' name='currencyName' id='currencyName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#cIdEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='quotationCommand.deliveryDateEditt'><input name='deliveryDateEditt' id='deliveryDateEditt"
																														+ btrid
																														+ "' value="
																														+ deliveryDateEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='quotationCommand.pIdEditt'><input type='hidden' name='pIdEditt' id='pIdEditt"
																														+ btrid
																														+ "' value="
																														+ pIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='quotationCommand.plantName'><input type='text' name='plantName' id='plantName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#pIdEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														

																														+ "<input type='hidden' name='quotationLineIdEditt' id='quotationLineIdEditt' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																														+ "<td><spring:bind path='quotationCommand.stLIdEditt'><input type='hidden' name='stLIdEditt' id='stLIdEditt"
																														+ btrid
																														+ "' value="
																														+ stLIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='quotationCommand.stlocName'><input type='text' name='stlocName' id='stlocName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#slIdEdit :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"
																														+ "<td><spring:bind path='quotationCommand.stIdEditt'><input type='hidden' name='stIdEditt' id='stIdEditt"
																														+ btrid
																														+ "' value="
																														+ stIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"

																														+ "<spring:bind path='quotationCommand.statusName'><input type='text' name='statusName' id='statusName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#stIdEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<td><a href='#'  onclick='editQuotationDetailsInEditNew("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeQuotationDetailsEditNew("
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
																										'#mIdEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#mIdEditt')
																														.val());
																								$(
																										'#materialName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#mIdEditt :selected')
																														.text());

																								$(
																										'#quantityEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#quantityEditt')
																														.val());

																								$(
																										'#uommEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#uommEditt')
																														.val());
																								$(
																										'#uomName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#uommEditt :selected')
																														.text());

																								$(
																										'#perUnitEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#perUnitEditt')
																														.val());
																								$(
																										'#lineAmountEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#lineAmountEditt')
																														.val());
																								$(
																										'#netPriceEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#netPriceEditt')
																														.val());
																								$(
																										'#cIdEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#cIdEditt')
																														.val());
																								$(
																										'#currencyName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#cIdEditt :selected')
																														.text());

																								$(
																										'#deliveryDateEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#deliveryDateEditt')
																														.val());

																								$(
																										'#pIdEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#pIdEditt')
																														.val());
																								$(
																										'#plantName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#pIdEditt :selected')
																														.text());

																								$(
																										'#slIdEdit'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#stLIdEditt')
																														.val());
																								$(
																										'#stlocName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#slIdEdit :selected')
																														.text());
																								$(
																										'#stIdEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#stIdEditt')
																														.val());
																								$(
																										'#statusName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#stIdEditt :selected')
																														.text());

																								$(
																										'#hiddenIdQuotationPopUpEdit')
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
																	"#create-AddQuotationEdit")
																	.button()
																	.click(
																			function() {
																				$(
																						"#dialog-form-QuotationEdit")
																						.dialog(
																								"open");

																			});
														});
														function removeQuotationDetailsEditNew(
																id) {
															$('#' + id)
																	.remove();
														}
														function editQuotationDetailsInEditNew(
																link) {

															$(
																	"#dialog-form-QuotationEdit")
																	.dialog(
																			"open");
															$('#mIdEditt')
																	.val(
																			$(
																					'#mIdEditt'
																							+ link)
																					.val());
															$('#quantityEditt')
																	.val(
																			$(
																					'#quantityEditt'
																							+ link)
																					.val());
															$('#uommEditt')
																	.val(
																			$(
																					'#uommEditt'
																							+ link)
																					.val());

															$('#perUnitEditt')
																	.val(
																			$(
																					'#perUnitEditt'
																							+ link)
																					.val());
															$(
																	'#lineAmountEditt')
																	.val(
																			$(
																					'#lineAmountEditt'
																							+ link)
																					.val());
															$('#netPriceEditt')
																	.val(
																			$(
																					'#netPriceEditt'
																							+ link)
																					.val());
															$('#cIdEditt')
																	.val(
																			$(
																					'#cIdEditt'
																							+ link)
																					.val());
															$(
																	'#deliveryDateEditt')
																	.val(
																			$(
																					'#deliveryDateEditt'
																							+ link)
																					.val());

															$('#pIdEditt')
																	.val(
																			$(
																					'#pIdEditt'
																							+ link)
																					.val());
															$('#slIdEdit')
																	.val(
																			$(
																					'#stLIdEditt'
																							+ link)
																					.val());
															$('#stIdEditt')
																	.val(
																			$(
																					'#stIdEditt'
																							+ link)
																					.val());
															$(
																	'#hiddenIdEditQPopUp')
																	.val(link);

														}
													</script>


													<div id="dialog-form-QuotationEdit"
														title="Add New Quotation Details">
														<p class="validateTips"></p>
														<table class="tableGeneral">

															<tr>
																<td><spring:message code="label.qmaterial" /><font
																	color="red">*</font></td>
																<td><form:select path="mIdEditt" class="select"
																		id="mIdEditt" cssStyle="height:25px">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${material }" />
																	</form:select></td>
															</tr>
															<tr>
																<td><spring:message code="label.qty" /><font
																	color="red">*</font></td>
																<td><form:input path="quantityEditt"
																		id="quantityEditt" class="textbox"
																		onkeyup="ediMultiply()" /></td>
															</tr>
															<tr>
																<td><spring:message code="label.quom" /><font
																	color="red">*</font></td>
																<td><form:select path="uommEditt" id="uommEditt"
																		class="select" cssStyle="height:25px">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${uom }" />
																	</form:select></td>
															</tr>

															<tr>
																<td><spring:message code="label.perunit" /></td>
																<td><form:input path="perUnitEditt"
																		id="perUnitEditt" class="textbox"
																		onkeyup="ediMultiply()" /></td>
															</tr>
															<tr>
																<td><spring:message code="label.lineamt" /></td>
																<td><form:input path="lineAmountEditt"
																		id="lineAmountEditt" class="textbox" readonly="true" /></td>
															</tr>
															<tr>
																<td><spring:message code="label.netprice" /></td>
																<td><form:input path="netPriceEditt"
																		id="netPriceEditt" class="textbox" readonly="true" /></td>
															</tr>

															<tr>
																<td><spring:message code="label.qcurrency" /><font
																	color="red">*</font></td>
																<td><form:select path="cIdEditt" id="cIdEditt"
																		class="select" cssStyle="height:25px">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${currency }" />
																	</form:select></td>
															</tr>

															<tr>
																<td><spring:message code="label.dldate" /><font
																	color="red">*</font></td>
																<td><form:input path="deliveryDateEditt"
																		id="deliveryDateEditt" class="textbox" /></td>
															</tr>

															<tr>
																<td><spring:message code="label.qplant" /><font
																	color="red">*</font></td>
																<td><form:select path="pIdEditt" id="pIdEditt"
																		class="select" cssStyle="height:25px"
																		onchange="AjaxForStorLoc(this.id,'EditMode')">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${plant }" />
																	</form:select></td>
															</tr>
															<tr>
																<td><spring:message code="label.storloc" /><font
																	color="red">*</font></td>
																<td><form:select path="stLIdEditt" id="slIdEdit"
																		class="select" cssStyle="height:25px">
																		<form:option value="0">-Select-</form:option>
																		<%-- <form:options items="${storageId }" /> --%>
																	</form:select></td>
															</tr>
															<tr>
																<td><spring:message code="label.qstatus" /><font
																	color="red">*</font></td>
																<td><form:select path="stIdEditt" id="stIdEditt"
																		class="select" cssStyle="height:25px">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${status }" />
																	</form:select></td>
																<td><input type="hidden" name="hiddenIdEditQPopUp"
																	id="hiddenIdEditQPopUp" value="0" /></td>
															</tr>
															

														</table>
													</div>

													<div id="users-contain-QuotationEdit">
														<!-- class="ui-widget" -->
														<h3></h3>
														<table id="AddQuotationEdit" class="table">
															<thead>
																<tr>
																	<th><spring:message code="label.qmaterial" /></th>
																	<th><spring:message code="label.qty" /></th>
																	<th><spring:message code="label.quom" /></th>
																	<th><spring:message code="label.perunit" /></th>
																	<th><spring:message code="label.lineamt" /></th>
																	<th><spring:message code="label.netprice" /></th>
																	<th><spring:message code="label.qcurrency" /></th>
																	<th><spring:message code="label.dldate" /></th>
																	<th><spring:message code="label.qplant" /></th>
																	<th><spring:message code="label.storloc" /></th>
																	<th><spring:message code="label.qstatus" /></th>
																	<th><spring:message code="label.edit" /></th>
																	<th><spring:message code="label.remove" /></th>

																</tr>

															</thead>
															<tbody>
																<c:forEach var="quotationLineEditList"
																	items="${quotationLineEditList}">

																	<c:set var="edit1"
																		value="${quotationLineEditList.quotationLineId}"></c:set>

																	<tr id="${quotationLineEditList.quotationLineId}">


																		<spring:bind
																			path="quotationCommand.quotationLineIdEditt">
																			<input type="hidden" name="quotationLineIdEditt"
																				class="textbox"
																				value="${quotationLineEditList.quotationLineId}"
																				id="quotationLineIdEditt${quotationLineEditList.quotationLineId}" />
																		</spring:bind>

																		<spring:bind path="quotationCommand.mIdEditt">
																			<input type="hidden" name="mIdEditt" class="textbox"
																				value="${quotationLineEditList.material_IdEditt}"
																				id="mIdEditt${quotationLineEditList.quotationLineId}" />
																		</spring:bind>

																		<td><spring:bind
																				path="quotationCommand.materialName">
																				<input type="text" name="materialName"
																					class="textbox" readonly="readonly"
																					value="${quotationLineEditList.materialName}"
																					id="materialName${quotationLineEditList.quotationLineId}" />
																			</spring:bind></td>
																		<td><spring:bind
																				path="quotationCommand.quantityEditt">
																				<input type="text" name="quantityEditt"
																					class="textbox" onkeyup="ediMultiply()"
																					readonly="readonly"
																					value="${quotationLineEditList.quantityEditt}"
																					id="quantityEditt${quotationLineEditList.quotationLineId}" />
																			</spring:bind></td>
																		<spring:bind path="quotationCommand.uommEditt">
																			<input type="hidden" name="uommEditt" class="textbox"
																				value="${quotationLineEditList.uomEditt}"
																				id="uommEditt${quotationLineEditList.quotationLineId}" />
																		</spring:bind>
																		<td><spring:bind path="quotationCommand.uomName">
																				<input type="text" name="uomName" class="textbox"
																					readonly="readonly"
																					value="${quotationLineEditList.uomName}"
																					id="uomName${quotationLineEditList.quotationLineId}" />
																			</spring:bind></td>

																		<td><spring:bind
																				path="quotationCommand.perUnitEditt">
																				<input type="text" name="perUnitEditt"
																					id="perUnitEditt${quotationLineEditList.quotationLineId}"
																					class="textbox" onkeyup="ediMultiply()"
																					readonly="readonly"
																					value="${quotationLineEditList.perUnitEditt }" />
																			</spring:bind></td>
																		<td><spring:bind
																				path="quotationCommand.lineAmountEditt">
																				<input type="text" name="lineAmountEditt"
																					id="lineAmountEditt${quotationLineEditList.quotationLineId}"
																					class="textbox"
																					value="${quotationLineEditList.lineAmountEditt}"
																					readonly="readonly" />
																			</spring:bind></td>
																		<td><spring:bind
																				path="quotationCommand.netPriceEditt">
																				<input type="text" name="netPriceEditt"
																					id="netPriceEditt${quotationLineEditList.quotationLineId}"
																					class="textbox" readonly="readonly"
																					value="${quotationLineEditList.netPriceEditt }" />
																			</spring:bind></td>
																		<spring:bind path="quotationCommand.cIdEditt">
																			<input type="hidden" name="cIdEditt" class="textbox"
																				id="cIdEditt${quotationLineEditList.quotationLineId}"
																				value="${quotationLineEditList.currencyIdEditt}" />
																		</spring:bind>
																		<td><spring:bind
																				path="quotationCommand.currencyName">
																				<input type="text" name="currencyName"
																					class="textbox" readonly="readonly"
																					value="${quotationLineEditList.currencyName}"
																					id="currencyName${quotationLineEditList.quotationLineId}" />
																			</spring:bind></td>



																		<td><spring:bind
																				path="quotationCommand.deliveryDateEditt">
																				<input type="text" name="deliveryDateEditt"
																					id="deliveryDateEditt${quotationLineEditList.quotationLineId}"
																					class="textbox" readonly="readonly"
																					value="${quotationLineEditList.deliveryDateEditt }" />
																			</spring:bind></td>

																		<spring:bind path="quotationCommand.pIdEditt">
																			<input type="hidden" name="pIdEditt" class="textbox"
																				id="pIdEditt${quotationLineEditList.quotationLineId}"
																				value="${quotationLineEditList.plantIdEditt}" />
																		</spring:bind>
																		<td><spring:bind
																				path="quotationCommand.plantName">
																				<input type="text" name="plantName" class="textbox"
																					readonly="readonly"
																					value="${quotationLineEditList.plantName}"
																					id="plantName${quotationLineEditList.quotationLineId}" />
																			</spring:bind></td>
                                                                           <spring:bind path="quotationCommand.stLIdEditt">
																			<input type="hidden" name="stLIdEditt"
																				class="textbox"
																				id="stLIdEditt${quotationLineEditList.quotationLineId}"
																				value="${quotationLineEditList.storageLocIdEditt}" />
																		</spring:bind>
																		<td><spring:bind
																				path="quotationCommand.stlocName">
																				<input type="text" name="stlocName" class="textbox"
																					readonly="readonly"
																					value="${quotationLineEditList.stlocName}"
																					id="stlocName${quotationLineEditList.quotationLineId}" />
																			</spring:bind></td>
																		<spring:bind path="quotationCommand.stIdEditt">
																			<input type="hidden" name="stIdEditt" class="textbox"
																				id="stIdEditt${quotationLineEditList.quotationLineId}"
																				value="${quotationLineEditList.statusIdEditt}" />
																		</spring:bind>
																		<td><spring:bind
																				path="quotationCommand.statusName">
																				<input type="text" name="statusName" class="textbox"
																					readonly="readonly"
																					value="${quotationLineEditList.statusName}"
																					id="statusName${quotationLineEditList.quotationLineId}" />
																			</spring:bind> <input type="hidden"
																			name="${quotationLineEditList.quotationLineId}Check"
																			id="${quotationLineEditList.quotationLineId}Check"
																			value="0" /></td>

																		

																		<td><a href="#"
																			id="${quotationLineEditList.quotationLineId}"
																			onclick="javascript:editQuotationDetailsInEdit(this)"><img
																				src="images/Edit.jpg" height="25px" width="25px"
																				id="${quotationLineEditList.quotationLineId}"></img></a></td>
																		<td><a href="#"
																			id="${quotationLineEditList.quotationLineId}"
																			onclick="javascript:getID1(this)"><img
																				src="images/button_cancel.png" height="25px"
																				width="25px"
																				id="${quotationLineEditList.quotationLineId}"></img></a></td>
																	</tr>

																	<tr>

																		<script type="text/javascript">
																			function getID1(
																					link) {

																				alert("Deleting Particular Row Will Deleted Once You Click Ok");
																				document
																						.getElementById(link.id
																								+ "Check").value = "1";
																				document
																						.getElementById(link.id).style.display = "none";
																			}
																			function editQuotationDetailsInEdit(
																					link) {

																				$(
																						"#dialog-form-QuotationEdit")
																						.dialog(
																								"open");
																				$(
																						'#mIdEditt')
																						.val(
																								$(
																										'#mIdEditt'
																												+ link.id)
																										.val());
																				$(
																						'#quantityEditt')
																						.val(
																								$(
																										'#quantityEditt'
																												+ link.id)
																										.val());
																				$(
																						'#uommEditt')
																						.val(
																								$(
																										'#uommEditt'
																												+ link.id)
																										.val());

																				$(
																						'#perUnitEditt')
																						.val(
																								$(
																										'#perUnitEditt'
																												+ link.id)
																										.val());
																				$(
																						'#lineAmountEditt')
																						.val(
																								$(
																										'#lineAmountEditt'
																												+ link.id)
																										.val());
																				$(
																						'#netPriceEditt')
																						.val(
																								$(
																										'#netPriceEditt'
																												+ link.id)
																										.val());
																				$(
																						'#cIdEditt')
																						.val(
																								$(
																										'#cIdEditt'
																												+ link.id)
																										.val());
																				$(
																						'#deliveryDateEditt')
																						.val(
																								$(
																										'#deliveryDateEditt'
																												+ link.id)
																										.val());

																				$(
																						'#pIdEditt')
																						.val(
																								$(
																										'#pIdEditt'
																												+ link.id)
																										.val());

																				$(
																						'#stIdEditt')
																						.val(
																								$(
																										'#stIdEditt'
																												+ link.id)
																										.val());
																				$(
																						'#stLIdEditt')
																						.val(
																								$(
																										'#stLIdEditt'
																												+ link.id)
																										.val());
																				$(
																						'#hiddenIdEditQPopUp')
																						.val(
																								link.id);

																			}
																		</script>
																	</tr>
																</c:forEach>

															</tbody>

														</table>
													</div>
													<button id="create-AddQuotationEdit" type="button">Add
														New Quotation Line</button>

												</div>
											</div>
										</div>
										<table>
											<tr>
												<td colspan=""><c:choose>
														<c:when test="${true }">
															<input type="submit"
																value="<spring:message code="label.update"/>"
																class="btn btn-primary" id="updateid" />
														</c:when>
														<c:otherwise>
															<input type="submit" disabled="disabled"
																value="<spring:message code="label.update"/>"
																class="btn btn-danger" id="updateid" />
														</c:otherwise>
													</c:choose></td>

											</tr>

										</table>

									</div>
								</div>
							</c:if>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>




