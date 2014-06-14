<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<!--  Date picker -->
<script>
	function dateFun(datePattern) {

		$("#startDate,#finishDate,#finishDateEditt,#startDateEditt")
				.datepicker({
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,

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

		$("#add,#search").click(function(e) {
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
	
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();

			$('#mainSearch').hide();

			$('#basicSearch').show();
		}
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#basicSearch').click(function() {

			$("#aslink").show();
			$('#mainSearch').show();

			$('#basicSearch').hide();

			return false;
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
	function doAjaxPost() {

		var productionOrder = $('#productionOrder').val();

		$
				.ajax({

					type : "POST",

					url : "popDuplicateAddCheck.mnt",

					data : "productionOrder=" + productionOrder,

					success : function(response) {

						var checkResponse = "Production Order Number is Already Exists Please try some other number";

						if (checkResponse == response) {
							document.getElementById("addmessage").style.display = "block";
							$('#addmessage').html(response);
						} else {
							document.getElementById("addmessage").style.display = "none";
						}
					},

					error : function(e) {
					alert("Error"+e);
					}

				});

	}
</script>
<script type="text/javascript">
	function doAjaxPostEdit() {

		var productionOrder = $('#productionOrderEditt').val();

		var popId = $('#productionOrderProcessIdEditt').val();

		$
				.ajax({

					type : "POST",

					url : "popDuplicateEditCheck.mnt",

					data : "productionOrder=" + productionOrder + "&popId="
							+ popId,

					success : function(response) {

						var checkResponse = "Production Order Number is Already Exists Please try some other number";

						if (checkResponse == response) {
							document.getElementById("editmessage").style.display = "block";
							$('#editmessage').html(response);
						} else {
							document.getElementById("editmessage").style.display = "none";
						}
					},

					error : function(e) {

					}

				});

	}
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#sumbtnid')
								.click(
										function(event) {

											$('#addPOPform')
													.validate(
															{
																rules : {
																	productionOrder : {
																		required : true
																	},

																},
																messages : {
																	productionOrder : "<font style='color: red;'><b>Production Orderis Required</b></font>",

																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editPOPForm')
													.validate(
															{
																rules : {
																	productionOrderEditt : {
																		required : true
																	},

																},
																messages : {
																	productionOrderEditt : "<font style='color: red;'><b>Production Order is Required</b></font>",

																},

															});

										});

					});
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Production Order Process</div>

		<!-- Tabs Declaration -->
		<div>
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="popEditList" items="${popEditList}">
						<c:set var="popEditList" value="${popEditList }"></c:set>
					</c:forEach>
					<c:if test="${popEditList!=null}">
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
						<form:form action="popsSearch.mnt" method="GET"
							commandName="productionOrderProcessCommand">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="popAdd"
											items="${param.list}">
											<div class="alert-success" id="savemessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.saveSuccess"></spring:message>
											</div>
										</c:forEach> <c:if test="${param.listwar!=null }">
											<div class="alert-danger" id="savemessage">
												<strong><spring:message code="label.error" /> </strong>

												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.saveFail" />
											</div>
										</c:if> <c:forEach var="popUpdate" items="${popUpdate}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.updateSuccess"></spring:message>
											</div>
										</c:forEach> <c:forEach var="popUpdateError" items="${popUpdateError}">
											<div class="alert-danger" id="successmessage">
												<strong><spring:message code="label.error" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.updateFail"></spring:message>
											</div>
										</c:forEach>
										<c:forEach var="popDelete" items="${popDelete}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.deleteSuccess"></spring:message>
											</div>
										</c:forEach>
										<c:forEach var="popDeleteError" items="${popDeleteError}">
											<div class="alert-danger" id="successmessage">
												<strong><spring:message code="label.error" /></strong>
												<spring:message code="label.productionOrderProcess" />
												<spring:message code="label.deleteFail"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<tr id="mainSearch">
									<td><spring:message code="label.searchby" /> <form:select
											path="xmlLabel" cssClass="select">
											<form:options items="${xmlItems}" />
										</form:select> <spring:bind path="productionOrderProcessCommand.operations">
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
										</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /> <c:set
											var="save" value="false"></c:set> <c:set var="edit"
											value="false"></c:set> <c:set var="delete" value="false"></c:set>
										<c:set var="update" value="false"></c:set> <c:set var="search"
											value="false"></c:set> <fmt:setBundle basename="button" /> <fmt:message
											key="label.save" var="messagesav" /> <fmt:message
											key="label.search" var="messagesea" /> <fmt:message
											key="label.delete" var="messagedel" /> <fmt:message
											key="label.update" var="messageup" /> <fmt:message
											key="label.edit" var="messageed" /> <c:forEach
											items="${sessionScope.privilegeList}" var="privileges">
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

										</c:forEach> <c:choose>
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

						<c:if test="${popSearch!=null}">
							<display:table id="popValue" name="popSearch"
								requestURI="popSearch.mnt" pagesize="5" class="table">
								<!-- Displaying  the Searched information by using display tag -->
								<display:column property="productionOrder"
									titleKey="label.productionOrderNo" media="html" sortable="true" />
								<display:column property="processdetailid"
									titleKey="label.processDetail" media="html" sortable="true" />
								<display:column property="workCenter_Id"
									titleKey="label.workCenter" media="html" sortable="true" />
								<display:column property="startDate" titleKey="label.startDate"
									media="html" sortable="true" />
								<display:column property="finishDate"
									titleKey="label.finishDate" media="html" sortable="true" />
								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${edit }">
											<a
												href="productionOrderProcessIdEdit.mnt?productionOrder=<c:out value="${popValue.productionOrder}"/>"
												style="color: red"><img src="images/Edit.jpg"
												width="20px" height="20px" /> </a>
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
												href="productionOrderProcessIdDelete.mnt?productionOrder=<c:out value="${popValue.productionOrderProcessId}"/>"
												style="color: red"
												onclick="return confirm('Do u want to delete the Record?')"><img
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
								<display:setProperty name="paging.banner.group_size" value="3" />
								<display:setProperty name="paging.banner.some_items_found"
									value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
							</display:table>
						</c:if>
					</div>
				</div>

				<!-- Add tab details -->


				<div id="tabs-3" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						<form:form action="productionOrderProcessAdd.mnt" method="GET"
							commandName="productionOrderProcessCommand" id="addPOPform">
							<table class="tableGeneral">
								<form:hidden path="aid" />
								<tr>
									<td colspan="2"><c:forEach var="addPOPDuplicate"
											items="${addPOPDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong>Warning!</strong> <font color="#C09853"><c:out
														value="${addPOPDuplicate}" /></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="productionOrderProcessIdEditt" />

								<tr>
									<td><spring:message code="label.productionOrderNo" /><font
										color="red">*</font></td>
									<td><form:select path="productionOrder" class="select"
											id="productionOrder" onchange="doAjaxPost()">
											<form:option value="">-Select-</form:option>
											<form:options items="${productionOrder }" />
										</form:select></td>
									<td style="display: none" id="addmessage" class="alert-warning"></td>
								</tr>
							</table>

							<!-- Sub tabbing for adding Quotation Line details -->
							<div id="tabsForAdd">
								<div id="scroll1">
									<!-- Production Order Process tab -->
									<ul>
										<li><a href="#subtabs-1"><spring:message
													code="label.productionOrderProcess" /> </a></li>

									</ul>
									<div align="center">
										<script>
											var poptrid = 1;
											$(function() {

												var processdetailid = $("#processdetailid"), pdvalue = $("#pdNumber"), workCenter_Id = $("#workCenter_Id"), wcvalue = $("#wcNumber"), startDate = $("#startDate"), finishDate = $("#finishDate"), hiddenID = $("#hiddenIdPOPPopUp"),
													allFields = $([]).add(
														processdetailid).add(
														pdvalue).add(
														workCenter_Id).add(
														wcvalue).add(startDate)
														.add(finishDate).add(
																hiddenID), 
																tips = $(".validateTips");
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

												$("#dialog-form-POP")
														.dialog(
																{
																	autoOpen : false,
																	height : 260,
																	width : 290,
																	modal : true,
																	buttons : {
																		Submit : function() {
																			var bValid = true;
																			allFields
																					.removeClass("ui-state-error");

																			bValid = bValid
																					&& selectLength(
																							processdetailid,
																							"Process Detail");

																			bValid = bValid
																					&& selectLength(
																							workCenter_Id,
																							"Work Center");

																			bValid = bValid
																					&& selectLength(
																							startDate,
																							"Start Date"
																							);

																			bValid = bValid
																					&& selectLength(
																							finishDate,
																							"Finish Date");

																			if (bValid) {

																				if (hiddenID
																						.val() == "0"
																						|| hiddenID
																								.val() == "") {

																					$(
																							"#POPAdd tbody")
																							.append(
																									"<tr id="+poptrid+">"

																											+ "<td align='center'><input type='hidden' name='processdetailid' id='processdetailid"
																											+ poptrid
																											+ "' value="
																											+ processdetailid
																													.val()
																											+ "  class='textbox'readonly/><input type='text' name='pdNumber' id='pdNumber"
																											+ poptrid
																											+ "' value="
																											+ $(
																													'#processdetailid :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input type='hidden' name='workCenter_Id' id='workCenter_Id"
																											+ poptrid
																											+ "' value="
																											+ workCenter_Id
																													.val()
																											+ " class='textbox'/><input type='text' name='wcNumber' id='wcNumber"
																											+ poptrid
																											+ "' value="
																											+ $(
																													'#workCenter_Id :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input name='startDate' id='startDate"
																											+ poptrid
																											+ "' value="
																											+ startDate
																													.val()
																											+ " class='textbox' readonly/></td>"

																											+ "<td><input name='finishDate' id='finishDate"
																											+ poptrid
																											+ "' value="
																											+ finishDate
																													.val()
																											+ " class='textbox' readonly/></td>"

																											+ "<td><a href='#'  onclick='editMaterialm("
																											+ poptrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeMaterialm("
																											+ poptrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");

																					poptrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																				if (hiddenID
																						.val() != "0") {
																					$(
																							'#processdetailid'
																									+ hiddenID
																											.val())
																							.val(
																									processdetailid
																											.val());
																					$(
																							'#pdNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#processdetailid :selected')
																											.text());

																					$(
																							'#workCenter_Id'
																									+ hiddenID
																											.val())
																							.val(
																									workCenter_Id
																											.val());
																					$(
																							'#wcNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#workCenter_Id :selected')
																											.text());

																					$(
																							'#startDate'
																									+ hiddenID
																											.val())
																							.val(
																									startDate
																											.val());
																					$(
																							'#finishDate'
																									+ hiddenID
																											.val())
																							.val(
																									finishDate
																											.val());
																					$(
																							'#hiddenIdPOPPopUp')
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

												$("#create-AddPOP")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-POP")
																			.dialog(
																					"open");

																});
											});
											function removeMaterialm(id) {
												alert("removing row " + id);
												$('#' + id).remove();
											}
											function editMaterialm(id) {
												alert("edit row " + id);

												$("#dialog-form-POP").dialog(
														"open");

												$('#processdetailid').val(
														$(
																'#processdetailid'
																		+ id)
																.val());
												$('#pdNumber').val(
														$('#pdNumber' + id)
																.val());

												$('#workCenter_Id')
														.val(
																$(
																		'#workCenter_Id'
																				+ id)
																		.val());
												$('#wcNumber').val(
														$('#wcNumber' + id)
																.val());

												$('#startDate').val(
														$('#startDate' + id)
																.val());
												$('#finishDate').val(
														$('#finishDate' + id)
																.val());

												$('#hiddenIdPOPPopUp').val(id);

											}
										</script>
										<div id="dialog-form-POP"
											title="Add New Production Order Process Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

												<tr>
													<td><spring:message code="label.processDetail" /><font
														color="red">*</font></td>
													<td><form:select path="processdetailid" class="select"
															id="processdetailid" cssStyle="height:25px"
															onchange="one()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${processDetail }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="pdNumber" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.workCenter" /><font
														color="red">*</font></td>
													<td><form:select path="workCenter_Id"
															id="workCenter_Id" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${workCenter }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="wcNumber" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.startDate" /><font
														color="red">*</font></td>
													<td><form:input path="startDate" id="startDate"
															class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.finishDate" /><font
														color="red">*</font></td>
													<td><form:input path="finishDate" id="finishDate"
															class="textbox" readonly="true" /> <input type="hidden"
														name="hiddenIdPOPPopUp" id="hiddenIdPOPPopUp" value="0" />
													</td>
												</tr>
											</table>
										</div>


										<div id="users-contain-POP">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="POPAdd" class="table">
												<thead>
													<tr>

														<th><spring:message code="label.processDetail" /></th>
														<th><spring:message code="label.workCenter" /></th>
														<th><spring:message code="label.startDate" /></th>
														<th><spring:message code="label.finishDate" /></th>



													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
										<button id="create-AddPOP" type="button">Add New
											Production Order Process</button>

									</div>
								</div>
							</div>
							<c:choose>
								<c:when test="${save}">
									<input type="submit"
										value="<spring:message code="label.save"/>"
										class="btn btn-primary" id="sumbtnid" />
								</c:when>
								<c:otherwise>
									<input type="submit" disabled="disabled"
										value='<spring:message code="label.save"/>'
										class="btn btn-danger" id="sumbnid" />
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

						<form:form action="popEdit.mnt" method="GET"
							commandName="productionOrderProcessCommand" id="editPOPForm">

							<c:if test="${popEditList!=null}">
								<table class="tableGeneral">
									<tr>
										<td><spring:message code="label.productionOrderNo" /><font
											color="red">*</font></td>
										<td><form:select path="productionOrderEditt"
												class="select" id="productionOrderEditt"
												onchange="doAjaxPostEdit()">
												<form:option value="">-Select-</form:option>
												<form:options items="${productionOrder }" />
											</form:select></td>
										<td style="display: none" id="editmessage"
											class="alert-warning"></td>
									</tr>
								</table>

								<!-- Sub tabbing for adding Production Order Process details -->
								<div id="tabsForEdit">
									<div id="scroll1">
										<!-- Production Order Process tab -->
										<ul>
											<li><a href="#subtabs-1"><spring:message
														code="label.productionOrderProcess" /> </a></li>

										</ul>
										<div align="center">
											<script>
												var btrid = 1;
												$(function() {

													var processdetailidEditt = $("#processdetailidEditt"), workCenter_IdEditt = $("#workCenter_IdEditt"), startDateEditt = $("#startDateEditt"), finishDateEditt = $("#finishDateEditt"), hiddenEdit = $("#hiddenIdEditPPopUp"),

													allFields = $([])
															.add(processdetailidEditt)
															.add(workCenter_IdEditt)
															.add(startDateEditt)
															.add(finishDateEditt)
															.add(hiddenEdit), 
															
															
															
															tips = $(".validateTips");

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

													function selectLengthEdit(o, n) {
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
								
													$("#dialog-form-POPEdit")
															.dialog(
																	{
																		autoOpen : false,
																		height : 260,
																		width : 290,
																		modal : true,
																		buttons : {
																			"Submit" : function() {
																				var bValid1 = true;
																				allFields
																						.removeClass("ui-state-error");
																				bValid1 = bValid1
																				&& selectLengthEdit(
																						processdetailidEditt,
																						"Process Detail");

																		bValid1 = bValid1
																				&& selectLengthEdit(
																						workCenter_IdEditt,
																						"Work Center");

																		bValid1 = bValid1
																				&& selectLengthEdit(
																						startDateEditt,
																						"Start Date"
																						);

																		bValid1 = bValid1
																				&& selectLengthEdit(
																						finishDateEditt,
																						"Finish Date");

						

																				if (bValid1) {
																				
																					if (hiddenEdit
																							.val() == "0"
																							|| hiddenEdit
																									.val() == "") {
																						$(
																								"#AddPOPEdit tbody")
																								.append(
																										"<tr id="+btrid+">"
																												+ "<td><spring:bind path='productionOrderProcessCommand.productionOrderProcessIdEditt'><input type='hidden' name='productionOrderProcessIdEditt' id='productionOrderProcessIdEditt"
																												+ btrid
																												+ "' value='0' class='textbox' readonly/></spring:bind>"
																												+ "<spring:bind path='productionOrderProcessCommand.processdetailidEditt'><input type='hidden' name='processdetailidEditt' id='processdetailidEditt"
																												+ btrid
																												+ "' value="
																												+ processdetailidEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind>"

																												+ "<spring:bind path='productionOrderProcessCommand.processdescription'><input type='text' name='processdescription' id='processdescription"
																												+ btrid
																												+ "' value="
																												+ $(
																														'#processdetailidEditt :selected')
																														.text()
																												+ " class='textbox' readonly/></spring:bind></td>"

																												+ "<td><spring:bind path='productionOrderProcessCommand.workCenter_IdEditt'><input type='hidden' name='workCenter_IdEditt' id='workCenter_IdEditt"
																												+ btrid
																												+ "' value="
																												+ workCenter_IdEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind>"

																												+ "<spring:bind path='productionOrderProcessCommand.workCenterName'><input type='text' name='workCenterName' id='workCenterName"
																												+ btrid
																												+ "' value="
																												+ $('#workCenter_IdEditt :selected')
																														.text()
																												+ " class='textbox' readonly/></spring:bind></td>"

																												+ "<td><spring:bind path='productionOrderProcessCommand.startDateEditt'><input name='startDateEditt' id='startDateEditt"
																												+ btrid
																												+ "' value="
																												+ startDateEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind></td>"
																												+ "<td><spring:bind path='productionOrderProcessCommand.finishDateEditt'><input name='finishDateEditt' id='finishDateEditt"
																												+ btrid
																												+ "' value="
																												+ finishDateEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind>"
																												+ "<input type='hidden' name='productionOrderProcessIdEditt' id='productionOrderProcessIdEditt' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																												+ "<td><a href='#'  onclick='editPOPDetailsInEditNew("
																												+ btrid
																												+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																												+ "<td><a href='#'  onclick='removePOPDetailsEditNew("
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
																								'#processdetailidEditt'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#processdetailidEditt')
																												.val());
																						$(
																								'#processdescription'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#processdetailidEditt :selected')
																												.text());

																						$(
																								'#workCenter_IdEditt'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#workCenter_IdEditt')
																												.val());
																						$(
																								'#workCenterName'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#workCenter_IdEditt :selected')
																												.text());

																						$(
																								'#startDateEditt'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#startDateEditt')
																												.val());
																						$(
																								'#finishDateEditt'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#finishDateEditt')
																												.val());
																						$(
																								'#hiddenIdPOPPopUpEdit')
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

													$("#create-AddPOPEdit")
															.button()
															.click(
																	function() {
																		$(
																				"#dialog-form-POPEdit")
																				.dialog(
																						"open");

																	});
												});
												function removePOPDetailsEditNew(
														id) {
													$('#' + id).remove();
												}
												function editPOPDetailsInEditNew(
														link) {

													$("#dialog-form-POPEdit")
															.dialog("open");
													
													$('#processdetailidEditt')
															.val(
																	$(
																			'#processdetailidEditt'
																					+ link)
																			.val());

													$('#workCenter_IdEditt')
															.val(
																	$(
																			'#workCenter_IdEditt'
																					+ link)
																			.val());

													$('#startDateEditt')
															.val(
																	$(
																			'#startDateEditt'
																					+ link)
																			.val());
													$('#finishDateEditt')
															.val(
																	$(
																			'#finishDateEditt'
																					+ link)
																			.val());

													$('#hiddenIdEditPPopUp')
															.val(link);

												}
											</script>
											<div id="dialog-form-POPEdit"
												title="Add New ProductionOrder Process Details">
												<p class="validateTips">All form fields are required.</p>
												<table class="tableGeneral">

													<tr>
														<td><spring:message code="label.processDetail" /><font
															color="red">*</font></td>
														<td><form:select path="processdetailidEditt"
																class="select" id="processdetailidEditt"
																cssStyle="height:25px">
																<form:option value="0">-Select-</form:option>
																<form:options items="${processDetail }" />
															</form:select></td>
													</tr>

													<tr>
														<td><spring:message code="label.workCenter" /><font
															color="red">*</font></td>
														<td><form:select path="workCenter_IdEditt"
																id="workCenter_IdEditt" class="select"
																cssStyle="height:25px">
																<form:option value="0">-Select-</form:option>
																<form:options items="${workCenter }" />
															</form:select></td>
													</tr>

													<tr>
														<td><spring:message code="label.startDate" /><font
															color="red">*</font></td>
														<td><form:input path="startDateEditt"
																id="startDateEditt" class="textbox" /></td>
													</tr>
													<tr>
														<td><spring:message code="label.finishDate" /><font
															color="red">*</font></td>
														<td><form:input path="finishDateEditt"
																id="finishDateEditt" class="textbox" readonly="true" /><input
															type="hidden" name="hiddenIdEditPPopUp"
															id="hiddenIdEditPPopUp" value="0" /></td>
													</tr>
												</table>
											</div>

											<div id="users-contain-POPEdit">
												<!-- class="ui-widget" -->
												<h3></h3>
												<table id="AddPOPEdit" class="table">
													<thead>
														<tr>
															<th><spring:message code="label.processDetail" /></th>
															<th><spring:message code="label.workCenter" /></th>
															<th><spring:message code="label.startDate" /></th>
															<th><spring:message code="label.finishDate" /></th>


														</tr>

													</thead>
													<tbody>
														<c:forEach var="popLineEditList"
															items="${popLineEditList}">

															<c:set var="edit1" value="${popLineEditList}"></c:set>

															<tr id="${popLineEditList.productionOrderProcessId}">


																<spring:bind
																	path="productionOrderProcessCommand.productionOrderProcessId">
																	<input type="hidden"
																		name="productionOrderProcessIdEditt" class="textbox"
																		value="${popLineEditList.productionOrderProcessIdEditt}"
																		id="productionOrderProcessIdEditt${popLineEditList.processdetailidEditt}" />
																</spring:bind>

																<spring:bind
																	path="productionOrderProcessCommand.processdetailidEditt">
																	<input type="hidden" name="processdetailidEditt"
																		class="textbox"
																		value="${popLineEditList.processdetailidEditt}"
																		id="processdetailidEditt${popLineEditList.productionOrderProcessIdEditt}" />
																</spring:bind>

																<td><spring:bind
																		path="productionOrderProcessCommand.processdescription">
																		<input type="text" name="processdescription"
																			class="textbox" readonly="readonly"
																			value="${popLineEditList.processdescription}"
																			id="processdescription${popLineEditList.productionOrderProcessIdEditt}" />
																	</spring:bind></td>

																<spring:bind
																	path="productionOrderProcessCommand.workCenter_IdEditt">
																	<input type="hidden" name="workCenter_IdEditt"
																		class="textbox"
																		value="${popLineEditList.workCenter_IdEditt}"
																		id="workCenter_IdEditt${popLineEditList.productionOrderProcessIdEditt}" />
																</spring:bind>
																<td><spring:bind
																		path="productionOrderProcessCommand.workCenterName">
																		<input type="text" name="workCenterName"
																			class="textbox" readonly="readonly"
																			value="${popLineEditList.workCenterName}"
																			id="workCenterName${popLineEditList.productionOrderProcessIdEditt}" />
																	</spring:bind></td>

																<td><spring:bind
																		path="productionOrderProcessCommand.startDateEditt">
																		<input type="text" name="startDateEditt"
																			id="startDateEditt${popLineEditList.productionOrderProcessIdEditt}"
																			class="textbox" readonly="readonly"
																			value="${popLineEditList.startDateEditt }" />
																	</spring:bind></td>
																<td><spring:bind
																		path="productionOrderProcessCommand.finishDateEditt">
																		<input type="text" name="finishDateEditt"
																			id="finishDateEditt${popLineEditList.productionOrderProcessIdEditt}"
																			class="textbox"
																			value="${popLineEditList.finishDateEditt}"
																			readonly="readonly" />
																	</spring:bind> <input type='hidden'
																	name="${popLineEditList.productionOrderProcessIdEditt}Check"
																	id="${popLineEditList.productionOrderProcessIdEditt}Check"
																	value="0" /></td>
																<td><a href="#"
																	id="${popLineEditList.productionOrderProcessIdEditt}"
																	onclick="javascript:editPOPDetailsInEdit(this)"><img
																		src="images/Edit.jpg" height="25px" width="25px"
																		id="${popLineEditList.productionOrderProcessIdEditt}"></img></a></td>
																<td><a href="#"
																	id="${popLineEditList.productionOrderProcessIdEditt}"
																	onclick="javascript:getID1(this)"><img
																		src="images/button_cancel.png" height="25px"
																		width="25px"
																		id="${popLineEditList.productionOrderProcessIdEditt}"></img></a></td>
															</tr>



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
																	function editPOPDetailsInEdit(
																			link) {
																	
																							$(
																				"#dialog-form-POPEdit")
																				.dialog(
																						"open");
																		
																		$(
																				'#processdetailidEditt')
																				.val(
																						$(
																								'#processdetailidEditt'
																										+ link.id)
																								.val());

																		$(
																				'#workCenter_IdEditt')
																				.val(
																						$(
																								'#workCenter_IdEditt'
																										+ link.id)
																								.val());

																		$(
																				'#startDateEditt')
																				.val(
																						$(
																								'#startDateEditt'
																										+ link.id)
																								.val());
																		$(
																				'#finishDateEditt')
																				.val(
																						$(
																								'#finishDateEditt'
																										+ link.id)
																								.val());

																		$(
																				'#hiddenIdEditPPopUp')
																				.val(
																						link.id);

																	}
																</script>

														</c:forEach>

													</tbody>

												</table>
											</div>
											<button id="create-AddPOPEdit" type="button">Add New
												Production Order Process</button>

										</div>

									</div>
								</div>
								<table>
									<tr>
										<td colspan="2"><c:choose>
												<c:when test="${update}">
													<input type="submit"
														value="<spring:message code="label.update"/>"
														class="btn btn-primary" id="updateid" />
												</c:when>
												<c:otherwise>
													<td><input type="submit" disabled="disabled"
														value="<spring:message code="label.update"/>"
														class="btn btn-danger" id="updateId" /></td>
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
	</div>
</body>
</html>