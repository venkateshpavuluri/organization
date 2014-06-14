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
<title>My JSP 'glJournal.jsp' starting page</title>

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
						$("#tabs,#tabss,#edittabs").tabs();
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addJournalForm')
													.validate(
															{
																rules : {
																	glAccountDT : {
																		required : true

																	},
																	postingDT : {
																		required : true

																	},
																	reference : {
																		required : true
																	},
																	orgId : {
																		required : true
																	},
																	currencyId : {
																		required : true
																	},
																	glFiscalYearId : {
																		required : true
																	},
																	description : {
																		required : true
																	},

																},
																messages : {
																	glAccountDT : "<font style='color: red;'><b>GL Account Date is Required</b></font>",
																	postingDT : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	reference : "<font style='color: red;'><b>Reference is Required</b></font>",
																	orgId : "<font style='color: red;'><b>Organization is Required</b></font>",
																	currencyId : "<font style='color: red;'><b>Currency Name is Required</b></font>",
																	glFiscalYearId : "<font style='color: red;'><b>GL Fiscal Year is Required</b></font>",
																	description : "<font style='color: red;'><b>Description is Required</b></font>"

																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editJournalForm')
													.validate(
															{
																rules : {
																	eglAccountDT : {
																		required : true

																	},
																	epostingDT : {
																		required : true

																	},
																	ereference : {
																		required : true
																	},
																	eorgId : {
																		required : true
																	},
																	ecurrencyId : {
																		required : true
																	},
																	eglFiscalYearId : {
																		required : true
																	},
																	edescription : {
																		required : true
																	},

																},
																messages : {
																	eglAccountDT : "<font style='color: red;'><b>GL Account Date is Required</b></font>",
																	epostingDT : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	ereference : "<font style='color: red;'><b>Reference is Required</b></font>",
																	eorgId : "<font style='color: red;'><b>Organization is Required</b></font>",
																	ecurrencyId : "<font style='color: red;'><b>Currency Name is Required</b></font>",
																	eglFiscalYearId : "<font style='color: red;'><b>GL Fiscal Year is Required</b></font>",
																	edescription : "<font style='color: red;'><b>Description is Required</b></font>"

																},
															});

										});

					});
</script>
	<script type="text/javascript">
function dateFun(datePattern) {
	$('#accDate,#accDateEdit,#psDate,#psDateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
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
	function addition() {
		var amt = parseInt($('#amount').val());
		var tax = parseInt($('#tax').val());
		var res = amt + tax;
		document.getElementById("total").value = res;

	}

	function additionEdit() {
		var amt = parseInt($('#amountEdit').val());
		var tax = parseInt($('#taxEdit').val());
		var res = amt + tax;
		document.getElementById("totalEdit").value = res;

	}

	function AjaxForDuplicate() {
		var debit = $('#glJournalNo').val();
		//alert(debit);
		$
				.ajax({
					type : "POST",
					url : "checkDNAddDuplicate.mnt",
					data : "glJournalNo=" + debit,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesDuplMessage").style.display = "block";
							$('#salesDuplMessage').html(response);
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
		var cust = $('#eglJournalNo').val();
		var id = $('#eglJournalId').val();
		//alert(id);
		$
				.ajax({
					type : "POST",
					url : "checkDNUpdateDuplicate.mnt",
					data : "eglJournalNo=" + cust + "&dnId=" + id,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesUpDuplMessage").style.display = "block";
							$('#salesUpDuplMessage').html(response);
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
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#basicSearchId').focus();

		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">GL Journal</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:forEach var="gljEditList" items="${gljEditList}">
					<c:set var="gljEditList" value="${gljEditList }"></c:set>
				</c:forEach>

				<c:if test="${gljEditList!=null}">

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

					<form:form method="get" action="glJournalSearch.mnt"
						commandName="glJournalCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addGLJsus"
										items="${param.addGLJsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.glj" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="addGLJFail"
										items="${param.addGLJFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.glj" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateGLJsus"
										items="${param.UpdateGLJsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.glj" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateGLJFail"
										items="${param.UpdateGLJFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.glj" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteGLJsus"
										items="${param.DeleteGLJsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.glj" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteGLJFail"
										items="${param.DeleteGLJFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.glj" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
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
					
						<c:if test="${GLJList!=null }">
							<display:table name="GLJList" id="GLJIdList" class="table"
								requestURI="glJournalSearch.mnt" pagesize="5">

								<display:column property="glAccountId" sortable="true"
									title="glAccountId" media="none" />

								<display:column property="glAccountDT" sortable="true"
									titleKey="label.gljacc" media="html" />

								<display:column property="postingDT" sortable="true"
									titleKey="label.gljpdate" media="html" />


								<display:column property="reference" sortable="true"
									titleKey="label.gljref" media="html" />

								<display:column property="orgId" sortable="true"
									titleKey="label.gljorg" media="html" />

								<display:column property="currencyId" sortable="true"
									titleKey="label.gljcurr" media="html" />

								<display:column property="glFiscalYearId" sortable="true"
									titleKey="label.gljfiscalyr" media="html" />

								<display:column property="description" sortable="true"
									titleKey="label.gljdesc" media="html" />


								<display:column titleKey="label.edit">
								<c:choose>
										<c:when test="${true}">
									<a
										href="glJournalEdit.mnt?glAccountId=<c:out value="${GLJIdList.glAccountId}"/> "><img
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
										href="glJournalDelete.mnt?glAccountId=<c:out value="${GLJIdList.glAccountId}"/> "
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
									<spring:message code="label.gljacc" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="glJournalAdd.mnt" method="POST"
						commandName="glJournalCmd" id="addJournalForm">

						<table class="tableGeneral">

							<tr>
								<td><spring:message code="label.gljacc" /><span
									class="required">*</span></td>
								<td><form:input path="glAccountDT" cssClass="textbox"
										onkeyup="AjaxForDuplicate()" id="accDate" /></td>

							</tr>

							<tr>
								<td><spring:message code="label.gljpdate" /><span
									class="required">*</span></td>
								<td><form:input path="postingDT" cssClass="textbox"
										id="psDate" /></td>
							</tr>

							<tr>
								<td><spring:message code="label.gljref" /><span
									class="required">*</span></td>
								<td><form:input path="reference" cssClass="textbox"
										maxlength="50" /></td>
							</tr>



							<tr>
								<td><spring:message code="label.gljorg" /><span
									class="required">*</span></td>
								<td><form:select path="orgId" cssClass="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${orgSelect}" />
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.gljcurr" /><span
									class="required">*</span></td>
								<td><form:select path="currencyId" cssClass="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${currencySelect}" />

									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.gljfiscalyr" /><span
									class="required">*</span></td>
								<td><form:select path="glFiscalYearId" cssClass="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${GLFiscalSelect}" />

									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.gljdesc" /><span
									class="required">*</span></td>
								<td><form:textarea path="description" cssClass="textbox"
										maxlength="250" /></td>
							</tr>

						</table>

						<!-- window 2 -->

						<div id="tabss" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.gljlform" /></a></li>
							</ul>

							<!--Sub Tab-1 -->
							<div id="tab1">

								<!-- Model Pop-up Start-->

								<div align="center">
									<script type="text/javascript">
										var btrid = 1;

										$(document)
												.ready(
														function() {

															var accGroup = $("#accGroupId"), cur = $("#currenId"), dc = $("#debitCredit"), amt = $("#amount"), tax = $('#tax'), total = $('#total'), hiddenID = $("#hiddenIdJournalPopUp"),

															allFields = $([])
																	.add(
																			accGroup)
																	.add(cur)
																	.add(dc)
																	.add(amt)
																	.add(tax)
																	.add(total)
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

															function checkAmount(
																	a, b) {
																if (a.val() > b
																		.val()) {
																	a
																			.addClass("ui-state-error");
																	updateTips("Debit Amount Must be lessthan Net Price");
																	return false;
																} else {
																	return true;
																}

															}

															$(
																	"#dialogformglJournal")
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
																										accGroup,

																										"Account Group");

																						bValid = bValid
																								&& required(
																										cur,
																										"Currency Name");
																						bValid = bValid
																								&& required(
																										dc,
																										"Debit/Credit");

																						bValid = bValid
																								&& checkRegexp(
																										amt,
																										/^([0-9.])+$/i,
																										"Amount is Required And Must be  Number");

																						bValid = bValid
																								&& checkRegexp(
																										tax,
																										/^([0-9.])+$/i,
																										"Tax is Required And Must be  Number");

																						bValid = bValid
																								&& checkRegexp(
																										total,
																										/^([0-9.])+$/i,
																										"Total is Required And Must be  Number");

																						if (bValid) {
																							//alert("hiddenid"+hiddenID.val());
																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {
																								$(
																										"#glJournalAdd tbody")
																										.append(

																												"<tr id="+btrid+">"
																														+ "<td ><spring:bind path='glJournalCmd.accGroupId'><input type='hidden' name='accGroupId' id='accGroupId"
																														+ btrid
																														+ "' value="
																														+ accGroup
																																.val()

																														+ " class='textbox' readonly/></spring:bind> "
																														+ "<input type='text' readonly class='textbox' name='accGrpName' id='accGrpName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#accGroupId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input type='hidden' name='currenId' id='currenId"
																														+ btrid
																														+ "' value="
																														+ cur
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='curName' id='curName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#currenId :selected')
																																.text()
																														+ "'"
																														+ "</td>"
																														+ "<td><input name='debitCredit' id='debitCredit"
																														+ btrid
																														+ "' value="
																														+ dc
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input name='amount' id='amount"
																														+ btrid
																														+ "' value="
																														+ amt
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input name='tax' id='tax"
																														+ btrid
																														+ "' value="
																														+ tax
																																.val()
																														+ " class='textbox' readonly/></td>"
																														+ "<td><input type='text' name='total' id='total"
																														+ btrid
																														+ "' value='"
																														+ total
																																.val()
																														+ "' class='textbox' readonly/></td>"

																														+ "<td><a href='#'  onclick='editglJournalLine("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeglJournalLine("
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
																										'#accGroupId'
																												+ hiddenID
																														.val())
																										.val(
																												accGroup
																														.val());
																								$(
																										'#accGrpName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#accGroupId :selected')
																														.text());
																								$(
																										'#amount'
																												+ hiddenID
																														.val())
																										.val(
																												amt
																														.val());
																								$(
																										'#currenId'
																												+ hiddenID
																														.val())
																										.val(
																												cur
																														.val());
																								$(
																										'#curName'
																												+ hiddenID
																														.val())
																										.val(
																												$(
																														'#currenId :selected')
																														.text());
																								$(
																										'#debitCredit'
																												+ hiddenID
																														.val())
																										.val(
																												dc
																														.val());
																								$(
																										'#tax'
																												+ hiddenID
																														.val())
																										.val(
																												tax
																														.val());
																								$(
																										'#total'
																												+ hiddenID
																														.val())
																										.val(
																												total
																														.val());
																								$(
																										'#hiddenIdJournalPopUp')
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
																	'#createAddglJournal')
																	.button()
																	.click(
																			function() {

																				$(
																						"#dialogformglJournal")
																						.dialog(
																								"open");
																				//alert("opened");
																			});
														});

										function removeglJournalLine(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editglJournalLine(id) {
											//alert("edit row " + id);

											$("#dialogformglJournal").dialog(
													"open");
											$('#accGroupId')
													.val(
															$(
																	'#accGroupId'
																			+ id)
																	.val());
											$('#currenId').val(
													$('#currenId' + id).val());
											$('#amount').val(
													$('#amount' + id).val());
											$('#debitCredit').val(
													$('#debitCredit' + id)
															.val());
											$('#tax').val($('#tax' + id).val());
											$('#total').val(
													$('#total' + id).val());

											$('#hiddenIdJournalPopUp').val(id);
										}
									</script>


									<div id="dialogformglJournal" align="center"
										title="<spring:message code="label.gljlform" />">
										<p class="validateTips" align="center" style="color: blue;">All
											Form Fields are Required</p>
										<table class="tableGeneral">

											<tr>
												<td><spring:message code="label.gljaccgr" /><span
													class=required>*</span></td>
												<td><form:select path="accGroup" id="accGroupId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${AccGroupSelect}" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.gljcurcy" /> <span
													class=required>*</span></td>
												<td><form:select path="curId" id="currenId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${currencySelect}" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.gljdc" /><span
													class=required>*</span></td>
												<td><form:select path="dc" id="debitCredit"
														cssClass="select">
														<form:option value="">-Select-</form:option>
														<form:option value="D">Debit</form:option>
														<form:option value="C">Credit</form:option>
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.gljamt" /><span
													class=required>*</span></td>
												<td><form:input path="amount" id="amount"
														class="textbox" onkeyup="addition()" maxlength="21"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.gljtax" /><span
													class=required>*</span></td>
												<td><form:input path="tax" id="tax" class="textbox"
														onkeyup="addition()" maxlength="21"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.gljtot" /><span
													class=required>*</span></td>
												<td><form:input path="total" id="total" class="textbox"
														readonly="true" /></td>
											</tr>

											<tr>
												<td><input type="hidden" name="hiddenIdJournalPopUp"
													id="hiddenIdJournalPopUp" value="0" /></td>
											</tr>

										</table>
									</div>

									<div id="users-glJournal">
										<table id="glJournalAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.gljaccgr" /></th>
													<th><spring:message code="label.gljcurcy" /></th>
													<th><spring:message code="label.gljdc" /></th>
													<th><spring:message code="label.gljamt" /></th>
													<th><spring:message code="label.gljtax" /></th>
													<th><spring:message code="label.gljtot" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>

									<button id="createAddglJournal" type="button">
										<spring:message code="label.gljlnew" />
									</button>

								</div>


								<!-- Model Pop-up End-->
							</div>


						</div>

						<!-- window 2 -->
						<table>
							<tr>
								<td colspan="2"><input type="submit"
									value="<spring:message code="label.save"/>" id="submitid"
									class="btn btn-primary" /><input type="reset"
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
							<td colspan="2" id="salesUpDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.gljacc" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form method="post" action="glJournalUpdate.mnt"
						commandName="glJournalCmd" id="editJournalForm">
						<c:forEach var="gljLineEditList" items="${gljLineEditList}">
							<c:set var="editMode" value="${gljLineEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<div>
								<table class="tableGeneral">

									<form:hidden path="eglAccountId" />
									<form:hidden path="ecreatedBy" />
									<form:hidden path="ecreatedDTTM" />

									<tr>
										<td><spring:message code="label.gljacc" /><span
											class="required">*</span></td>
										<td><form:input path="eglAccountDT" cssClass="textbox"
												id="accDateEdit" /></td>

									</tr>

									<tr>
										<td><spring:message code="label.gljpdate" /><span
											class="required">*</span></td>
										<td><form:input path="epostingDT" cssClass="textbox"
												id="psDateEdit" /></td>
									</tr>

									<tr>
										<td><spring:message code="label.gljref" /><span
											class="required">*</span></td>
										<td><form:input path="ereference" cssClass="textbox"
												maxlength="50" /></td>
									</tr>

									<tr>
										<td><spring:message code="label.gljorg" /><span
											class="required">*</span></td>
										<td><form:select path="eorgId" cssClass="select">
												<form:option value="">-Select-</form:option>
												<form:options items="${orgSelect}" />
											</form:select></td>
									</tr>

									<tr>
										<td><spring:message code="label.gljcurr" /><span
											class="required">*</span></td>
										<td><form:select path="ecurrencyId" cssClass="select">
												<form:option value="">-Select-</form:option>
												<form:options items="${currencySelect}" />

											</form:select></td>

									</tr>

									<tr>
										<td><spring:message code="label.gljfiscalyr" /><span
											class="required">*</span></td>
										<td><form:select path="eglFiscalYearId" cssClass="select">
												<form:option value="">-Select-</form:option>
												<form:options items="${GLFiscalSelect}" />

											</form:select></td>

									</tr>

									<tr>
										<td><spring:message code="label.gljdesc" /><span
											class="required">*</span></td>
										<td><form:textarea path="edescription" cssClass="textbox"
												maxlength="250" /></td>
									</tr>

								</table>
							</div>


							<!-- window 2 -->

							<div id="tabss" align="left">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.gljlform" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 10;
											$(function() {

												var accGroupEdit = $("#accGroupIdEdit"), curEdit = $("#currenIdEdit"), dcEdit = $("#debitCreditEdit"), amtEdit = $("#amountEdit"), taxEdit = $('#taxEdit'), totalEdit = $('#totalEdit'), hiddenEdit = $("#hiddenIdJournalPopUpEdit"),

												allFields = $([]).add(
														accGroupEdit).add(
														curEdit).add(dcEdit)
														.add(amtEdit).add(
																taxEdit).add(
																totalEdit).add(
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

												function checkAmount(a, b) {
													if (a.val() > b.val()) {
														a
																.addClass("ui-state-error");
														updateTips("Debit Amount Must be lessthan Net Price");
														return false;
													} else {
														return true;
													}

												}

												$("#dialog-form-GLJEdit")
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
																							accGroupEdit,
																							"Account Group");
																			bValid1 = bValid1
																					&& requiredEdit(
																							curEdit,
																							"Currency Name");
																			bValid1 = bValid1
																					&& requiredEdit(
																							dcEdit,
																							"Debit/Credit");
																			bValid1 = bValid1
																					&& checkRegexp(
																							amtEdit,
																							/^([0-9.])+$/i,
																							"Amount is Required And Must be  Number");

																			bValid1 = bValid1
																					&& checkRegexp(
																							taxEdit,
																							/^([0-9.])+$/i,
																							"Tax is Required And Must be  Number");

																			bValid1 = bValid1
																					&& checkRegexp(
																							totalEdit,
																							/^([0-9.])+$/i,
																							"Total is Required And Must be  Number");

																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddGLJLinelEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td ><spring:bind path='glJournalCmd.eaccGroupId'><input type='hidden' name='eaccGroupId' id='accGroupIdEdit"
																											+ btrid
																											+ "' value="
																											+ accGroupEdit
																													.val()

																											+ " class='textbox' readonly/></spring:bind> "
																											+ "<input type='text' readonly class='textbox' name='accGrpName' id='accGrpNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#accGroupIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"
																											+ "<td><input type='hidden' name='ecurrenId' id='currenIdEdit"
																											+ btrid
																											+ "' value="
																											+ curEdit
																													.val()
																											+ " class='textbox' readonly/>"
																											+ "<input type='text' class='textbox' readonly name='curName' id='curNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#currenIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"
																											+ "<td><input name='edebitCredit' id='debitCreditEdit"
																											+ btrid
																											+ "' value="
																											+ dcEdit
																													.val()
																											+ " class='textbox' readonly/></td>"
																											+ "<td><input name='eamount' id='amountEdit"
																											+ btrid
																											+ "' value="
																											+ amtEdit
																													.val()
																											+ " class='textbox' readonly/></td>"
																											+ "<td><input name='etax' id='taxEdit"
																											+ btrid
																											+ "' value="
																											+ taxEdit
																													.val()
																											+ " class='textbox' readonly/></td>"
																											+ "<td><input type='text' name='etotal' id='totalEdit"
																											+ btrid
																											+ "' value='"
																											+ totalEdit
																													.val()
																											+ "' class='textbox' readonly/></td>"

																											+ "<input type='hidden' name='eglAccountLineId' id='eglAccountLineId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"

																											+ "<td><a href='#'  onclick='editGLJInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeGLJEditNew("
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
																							'#accGroupIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#accGroupIdEdit')
																											.val());
																					$(
																							'#accGrpNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#accGroupIdEdit :selected')
																											.text());
																					$(
																							'#currenIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#currenIdEdit')
																											.val());
																					$(
																							'#curNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#currenIdEdit :selected')
																											.text());
																					$(
																							'#debitCreditEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#debitCreditEdit')
																											.val());
																					$(
																							'#amountEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#amountEdit')
																											.val());
																					$(
																							'#taxEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#taxEdit')
																											.val());
																					$(
																							'#totalEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#totalEdit')
																											.val());

																					$(
																							'#hiddenIdJournalPopUpEdit')
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

												$("#create-AddGLJLineEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-GLJEdit")
																			.dialog(
																					"open");

																});
											});
											function removeGLJEditNew(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editGLJInEditNew(link) {
												//alert(link);
												$("#dialog-form-GLJEdit")
														.dialog("open");
												$('#accGroupIdEdit').val(
														$(
																'#accGroupIdEdit'
																		+ link)
																.val());
												$('#currenIdEdit').val(
														$(
																'#currenIdEdit'
																		+ link)
																.val());
												$('#debitCreditEdit').val(
														$(
																'#debitCreditEdit'
																		+ link)
																.val());
												$('#amountEdit').val(
														$('#amountEdit' + link)
																.val());
												$('#taxEdit').val(
														$('#taxEdit' + link)
																.val());
												$('#totalEdit').val(
														$('#totalEdit' + link)
																.val());
												$('#hiddenIdJournalPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-GLJEdit"
											title="<spring:message code="label.gljlform" />">
											<p class="validateTips" align="center" style="color: blue;">All
												Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="eglAccountLineId" value="0" />

												<tr>
													<td><spring:message code="label.gljaccgr" /><span
														class=required>*</span></td>
													<td><form:select path="accGroup" id="accGroupIdEdit"
															class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${AccGroupSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.gljcurcy" /> <span
														class=required>*</span></td>
													<td><form:select path="curId" id="currenIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${currencySelect}" />
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.gljdc" /><span
														class=required>*</span></td>
													<td><form:select path="dc" id="debitCreditEdit"
															cssClass="select">
															<form:option value="">-Select-</form:option>
															<form:option value="D">Debit</form:option>
															<form:option value="C">Credit</form:option>
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.gljamt" /><span
														class=required>*</span></td>
													<td><form:input path="eamount" id="amountEdit"
															class="textbox" onkeyup="additionEdit()" maxlength="21"/></td>
												</tr>
												<tr>
													<td><spring:message code="label.gljtax" /><span
														class=required>*</span></td>
													<td><form:input path="etax" id="taxEdit"
															class="textbox" onkeyup="additionEdit()" maxlength="21"/></td>
												</tr>
												<tr>
													<td><spring:message code="label.gljtot" /><span
														class=required>*</span></td>
													<td><form:input path="etotal" id="totalEdit"
															class="textbox" readonly="true" /></td>
												</tr>
												<tr>
													<td><input type="hidden"
														name="hiddenIdJournalPopUpEdit"
														id="hiddenIdJournalPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-GLJLineEdit">
											<table id="AddGLJLinelEdit" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.gljaccgr" /></th>
														<th><spring:message code="label.gljcurcy" /></th>
														<th><spring:message code="label.gljdc" /></th>
														<th><spring:message code="label.gljamt" /></th>
														<th><spring:message code="label.gljtax" /></th>
														<th><spring:message code="label.gljtot" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>
													</tr>
												</thead>
												<tbody>

													<c:forEach var="gljLineEditList" items="${gljLineEditList}">

														<spring:bind path="glJournalCmd.eglAccountLineId">
															<input type="hidden" name="eglAccountLineId"
																id="glAccountLineIdEdit${gljLineEditList.eglAccountLineId}"
																value="${gljLineEditList.eglAccountLineId}" />
														</spring:bind>
														<tr id="${gljLineEditList.eglAccountLineId}">

															<td><spring:bind path="glJournalCmd.eaccGroupId">
																	<input type="hidden" name="eaccGroupId"
																		id="accGroupIdEdit${gljLineEditList.eglAccountLineId}"
																		class="textbox" value="${gljLineEditList.eaccGroupId}"
																		readonly />
																</spring:bind> <spring:bind path="glJournalCmd.accName">
																	<input type="text" name="accName"
																		id="accNameEdit${gljLineEditList.eglAccountLineId}"
																		class="textbox" value="${gljLineEditList.accName}"
																		readonly />
																</spring:bind></td>
															<td><spring:bind path="glJournalCmd.ecurrenId">
																	<input type="hidden" name="ecurrenId" class="textbox"
																		id="currenIdEdit${gljLineEditList.eglAccountLineId}"
																		value="${gljLineEditList.ecurrenId}" readonly />
																</spring:bind> <spring:bind path="glJournalCmd.currencyName">
																	<input type="text" name="currencyName" class="textbox"
																		id="currencyNameEdit${gljLineEditList.eglAccountLineId}"
																		value="${gljLineEditList.currencyName}" readonly />
																</spring:bind></td>
															<td><spring:bind path="glJournalCmd.edebitCredit">
																	<input type="text" name="edebitCredit" class="textbox"
																		id="debitCreditEdit${gljLineEditList.eglAccountLineId}"
																		value="${gljLineEditList.edebitCredit}" readonly />
																</spring:bind></td>

															<td><spring:bind path="glJournalCmd.eamount">
																	<input type="text" name="eamount" class="textbox"
																		id="amountEdit${gljLineEditList.eglAccountLineId}"
																		value="${gljLineEditList.eamount}" readonly />
																</spring:bind></td>
															<td><spring:bind path="glJournalCmd.etax">
																	<input type="text" name="etax" class="textbox"
																		id="taxEdit${gljLineEditList.eglAccountLineId}"
																		value="${gljLineEditList.etax}" readonly />
																</spring:bind></td>

															<td><spring:bind path="glJournalCmd.etotal">
																	<input type="text" name="etotal" class="textbox"
																		id="totalEdit${gljLineEditList.eglAccountLineId}"
																		value="${gljLineEditList.etotal}" readonly />
																</spring:bind></td>

															<td><a href="#"
																id="${gljLineEditList.eglAccountLineId}"
																onclick="javascript:editGLJLineInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${gljLineEditList.eglAccountLineId}"></img></a></td>

															<td><a href="#"
																id="${gljLineEditList.eglAccountLineId}"
																onclick="javascript:getIDGLJ(this.id)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px" id="${gljLineEditList.eglAccountLineId}"></img></a>


																<input type="hidden"
																name="Check${gljLineEditList.eglAccountLineId}"
																id="${gljLineEditList.eglAccountLineId}Check" value="0" /></td>
														</tr>

														<script>
															function getIDGLJ(
																	link) {
																//alert(link);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link
																				+ "Check").value = "1";
																document
																		.getElementById(link).style.display = "none";
															}
															function editGLJLineInEdit(
																	link) {
																//alert(""+ link.id);

																$(
																		"#dialog-form-GLJEdit")
																		.dialog(
																				"open");
																$(
																		'#accGroupIdEdit')
																		.val(
																				$(
																						'#accGroupIdEdit'
																								+ link.id)
																						.val());
																$(
																		'#currenIdEdit')
																		.val(
																				$(
																						'#currenIdEdit'
																								+ link.id)
																						.val());
																$(
																		'#debitCreditEdit')
																		.val(
																				$(
																						'#debitCreditEdit'
																								+ link.id)
																						.val());

																$('#amountEdit')
																		.val(
																				$(
																						'#amountEdit'
																								+ link.id)
																						.val());
																$('#taxEdit')
																		.val(
																				$(
																						'#taxEdit'
																								+ link.id)
																						.val());
																$('#totalEdit')
																		.val(
																				$(
																						'#totalEdit'
																								+ link.id)
																						.val());

																$(
																		'#hiddenIdJournalPopUpEdit')
																		.val(
																				link.id);

															}
														</script>

													</c:forEach>


												</tbody>

											</table>
										</div>
										<button id="create-AddGLJLineEdit" type="button">
											<spring:message code="label.gljlnew" />
										</button>

									</div>

								</div>
							</div>
							<table>
								<tr>
									<td colspan=""><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateid" /></td>

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