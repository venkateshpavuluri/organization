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
<title>My JSP 'inspLotResult.jsp' starting page</title>
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
	
	function dateFun(datePattern){
		
		$('#startDate,#endDate,#startDateEdit,#endDateEdit,#basicSearchId')
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
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {

											$('#addForm')
													.validate(
															{
																rules : {
																	inspLotNoId : {
																		required : true
																	},
																	startDate : {
																		required : true
																	},
																	endDate : {
																		required : true

																	},
																	inspected:{number:true},
																	accepted:{number:true},
																	nonConf:{number:true},
																	mean : {
																		required : true,
																		number : true
																	},
																	stdValue : {
																		required : true,
																		number : true
																	}

																},
																messages : {
																	inspLotNoId : "<font style='color: red;'><b>Inspection Lot no is Required</b></font>",
																	startDate : "<font style='color: red;'><b>Start Date is Required</b></font>",
																	endDate : "<font style='color: red;'><b>End Date is Required </b></font>",
																	inspected:{
																		number:"<font style='color:red;'><b>Inspected Allows Only Numbers</b></font>"
																	},
																	accepted:{
																		number:"<font style='color:red;'><b>Accepted Allows Only Numbers</b></font>"
																	},
																	nonConf:{
																		number:"<font style='color:red;'><b>Non Conf Allows Only Numbers</b></font>"
																	},
																	mean :{
																		required:"<font style='color: red;'><b>Mean is Required</b></font>",
																		number:"<font style='color:red;'><b>Mean Allows Only Numbers</b></font>"
																	} ,
																	stdValue :{
																		required:"<font style='color: red;'><b>Standard Value is Required</b></font>",
																		number:"<font style='color:red;'><b>Standard Value Allows Only Numbers</b></font>"
																	}
																},

															});

										});

						/* $('#submitid')
								.click(
										function(event) {
											var accepted = $('#accepted').val();
											var nonConf = $('#nonConf').val();
											var insp = $('#inspected').val();
											var skips = $('#skipp').val();
											//alert(skips);
											if (accepted == "" && insp == ""
													&& skips =="false") {
												document.getElementById("salesDuplMessage").style.display = "block";
												$('#salesDuplMessage').html("You Must Enter Accepted And Inspected OR Skip");
												return false;
											}else{
												//alert("In else");
												document.getElementById("salesDuplMessage").style.display = "none";
											return true;
											}
										});  */

						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											$('#editForm')
													.validate(
															{
																rules : {
																	inspLotNoId : {
																		required : true
																	},
																	startDate : {
																		required : true
																	},
																	endDate : {
																		required : true

																	},
																	inspected:{number:true},
																	accepted:{number:true},
																	nonConf:{number:true},
																	mean : {
																		required : true,
																		number : true
																	},
																	stdValue : {
																		required : true,
																		number : true
																	}

																},
																messages : {
																	inspLotNoId : "<font style='color: red;'><b>Inspection Lot no is Required</b></font>",
																	startDate : "<font style='color: red;'><b>Start Date is Required</b></font>",
																	endDate : "<font style='color: red;'><b>End Date is Required </b></font>",
																	inspected:{
																		number:"<font style='color:red;'><b>Inspected Allows Only Numbers</b></font>"
																	},
																	accepted:{
																		number:"<font style='color:red;'><b>Accepted Allows Only Numbers</b></font>"
																	},
																	nonConf:{
																		number:"<font style='color:red;'><b>Non Conf Allows Only Numbers</b></font>"
																	},
																	mean : {
																		required:"<font style='color: red;'><b>Mean is Required</b></font>",
																		number:"<font style='color:red;'><b>Mean Allows Only Numbers</b></font>"
																	},
																	stdValue :{
																		required:"<font style='color: red;'><b>Standard Value is Required</b></font>",
																		number:"<font style='color:red;'><b>Standard Value Allows Only Numbers</b></font>"
																	}

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
			$('#inspLotNoId').focus();
			$('#inspLotResultId').val('');
			$('#inspLotNoId').val('');
			$('#startDate').val('');
			$('#endDate').val('');
			$('#inspected').val('');
			$('#accepted').val('');
			$('#nonConf').val('');
			$('#mean').val('');
			$('#stdValue').val('');
			$('#skip').val('');

		});
	});
</script>
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
	function ajaxForQty() {
		var insp = $('#inspected').val();
		var inspId = $('#inspLotNoId').val();
		//alert(insp);
		//alert(inspId);

		$
				.ajax({
					type : "POST",
					url : "getLotQty.mnt",
					data : "inspected=" + insp + "&inspId=" + inspId,
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
						//alert(e);
					}

				});
	}

	function QtyAdd() {
		var accepted = parseFloat($('#accepted').val());
		var nonConf = parseFloat($('#nonConf').val());
		var insp = parseFloat($('#inspected').val());
		var result = accepted + nonConf;
		if (result != insp) {
			document.getElementById("salesDuplMessage").style.display = "block";
			$('#salesDuplMessage')
					.html(
							"Warning ! Addition of Accepted And Non Conf value Must be Equal to Inspected");
			$('#submitid').hide();
		} else {
			document.getElementById("salesDuplMessage").style.display = "none";
			$('#submitid').show();
		}

	}

	function ajaxForQtyEdit() {
		var insp = $('#inspectedEdit').val();
		var inspId = $('#inspLotNoIdEdit').val();
		//alert(insp);
		//alert(inspId);

		$
				.ajax({
					type : "POST",
					url : "getLotQty.mnt",
					data : "inspected=" + insp + "&inspId=" + inspId,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesUpDuplMessage").style.display = "block";
							$('#salesUpDuplMessage').html(response);
							$('#updated').hide();

						} else {
							document.getElementById("salesUpDuplMessage").style.display = "none";
							$('#updated').show();
						}

					},
					error : function(e) {
						//alert(e);
					}

				});
	}

	function QtyAddEdit() {
		var accepted = parseFloat($('#acceptedEdit').val());
		var nonConf = parseFloat($('#nonConfEdit').val());
		var insp = parseFloat($('#inspectedEdit').val());
		var result = accepted + nonConf;
		if (result != insp) {
			document.getElementById("salesUpDuplMessage").style.display = "block";
			$('#salesUpDuplMessage')
					.html(
							"Warning ! Addition of Accepted And Non Conf value Must be Equal to Inspected");
			$('#updated').hide();
		} else {
			document.getElementById("salesUpDuplMessage").style.display = "none";
			$('#updated').show();
		}

	}
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Inspection Lot Result</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="inspLotEdit" items="${inspLotEdit}">
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
					<form:form method="get" action="inspLotResSearch.mnt"
						commandName="inspLotResCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addLotsus"
										items="${param.addLotsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.insplotres" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addLotFail"
										items="${param.addLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.insplotres" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateLotsus"
										items="${param.updateLotsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.insplotres" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="updateLotFail"
										items="${param.updateLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.insplotres" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteLotsus"
										items="${param.DeleteLotsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.insplotres" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteLotFail"
										items="${param.DeleteLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.insplotres" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr id="mainSearch">
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="inspLotResCmd.operations">
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
									</spring:bind> <form:input path="basicSearchId" id="basicSearchId"
										cssClass="textbox" /></td>
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
							 <form:form action="inspResAdvanceSearch.mnt" method="get"
								commandName="inspLotResCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="inspResAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>
						</table>
						<form:form action="inspResAdvanceSearchOperations.mnt"
						commandName="inspLotResCmd" method="get">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="inspLotResCmd.asOpts">
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
												<c:set var="bdField" value="${xmlLabelValue.dbField}" />
											<c:set var="startDate" value="startDate" />
											<c:set var="endDate" value="endDate" />
												<c:if test="${bdField eq  startDate}">
												<td><form:input path="advanceSearchText"
													cssClass="textbox" id="startDate"/></td>
													</c:if>
													<c:if test="${bdField eq  endDate}">
												<td><form:input path="advanceSearchText"
													cssClass="textbox" id="endDate"/></td>
													</c:if>
										</tr>

									</c:forEach>
									

									<c:forEach var="refList" items="${refList}">
										<tr>
											<td><label>${refList.labels}</label> <form:hidden
													path="dbField" id="dbField" value="${refList.dbField}" /></td>
											<td><spring:bind path="inspLotResCmd.asOpts">
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
											<c:set var="inspLotNoId" value="inspLotNoId" />
											<c:set var="processDetailId" value="processDetailId" />
											
											<c:if test="${bdField eq inspLotNoId}">
												<c:set var="selectBox" value="${inspLotSelect}" />
											</c:if>
											<c:if test="${bdField eq processDetailId}">
												<c:set var="selectBox" value="${ProcessDetail}" />
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
									<td colspan="3"><c:choose>
											<c:when test="${search}">
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

					<c:if test="${LOTList!=null }">
					<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="inspResAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="inspLotResSearch.mnt" />
							</c:otherwise>

						</c:choose>
						<display:table name="LOTList" id="LOTIDList" class="table"
							requestURI="${search}" pagesize="5">
							<display:column property="inspLotResultId" sortable="true"
								title="InspLotResultId" media="none" />

							<display:column property="inspLotNoId" sortable="true"
								titleKey="label.inspreslot" media="html" />
								<display:column property="processDetailId" sortable="true"
								titleKey="label.insppd" media="html" />
								
							<display:column property="startDate" sortable="true"
								titleKey="label.inresdate" media="html" />

							<display:column property="endDate" sortable="true"
								titleKey="label.inresedate" media="html" />

							<display:column property="mean" sortable="true"
								titleKey="label.inresm" media="html" />

							<display:column property="stdValue" sortable="true"
								titleKey="label.inressv" media="html" />

							<display:column property="skip" sortable="true"
								titleKey="label.inressk" media="html" />

							<display:column titleKey="label.edit">
							<c:choose>
										<c:when test="${edit}">
								<a
									href="inspLotResEdit.mnt?inspLotResNoId=<c:out value="${LOTIDList.inspLotResultId}"/> "><img
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
									href="inspLotResDelete.mnt?inspLotResNoId=<c:out value="${LOTIDList.inspLotResultId}"/> "
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
							<td colspan="4" class="alert-warning" id="salesDuplMessage"
								style="display: none; width: 600px; height: 25px;"></td>
						</tr>
					</table>
					<form:form action="inspLotResAdd.mnt" id="addForm" method="POST"
						commandName="inspLotResCmd">
						<table class="tableGeneral">

							<tr>
								<td><spring:message code="label.inspreslot" /><span
									class="required">*</span></td>
								<td><form:select path="inspLotNoId" class="select"
										id="inspLotNoId">
										<form:option value="">-Select-</form:option>
										<form:options items="${inspLotSelect}" />
									</form:select></td>

							</tr>
							
							<tr>
								<td><spring:message code="label.insppd" /><span
									class="required">*</span></td>
								<td><form:select path="processDetailId" class="select"
										id="processDetailId">
										<form:option value="">-Select-</form:option>
										<form:options items="${ProcessDetail}" />
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.inresdate" /><span
									class="required">*</span></td>
								<td><form:input path="startDate" class="textbox"
										id="startDate" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.inresedate" /><span
									class="required">*</span></td>
								<td><form:input path="endDate" class="textbox" id="endDate" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.inresin" /><span
									class="required"></span></td>
								<td><form:input path="inspected" class="textbox"
										id="inspected" onkeyup="ajaxForQty()" maxlength="21"/></td>
							</tr>

							<tr>
								<td><spring:message code="label.inresacc" /><span
									class="required"></span></td>
								<td><form:input path="accepted" class="textbox"
										id="accepted" maxlength="21"/></td>

							</tr>
							<tr>
								<td><spring:message code="label.inresnc" /><span
									class="required"></span></td>
								<td><form:input path="nonConf" class="textbox" id="nonConf"
										onkeyup="QtyAdd()" maxlength="21"/></td>

							</tr>

							<tr>
								<td><spring:message code="label.inresm" /><span
									class="required">*</span></td>
								<td><form:input path="mean" class="textbox" id="mean" maxlength="21"/></td>

							</tr>

							<tr>
								<td><spring:message code="label.inressv" /><span
									class="required">*</span></td>
								<td><form:input path="stdValue" class="textbox"
										id="stdValue" maxlength="21"/></td>

							</tr>
							<tr>
								<td><spring:message code="label.inressk" /><span
									class="required"></span></td>
								<td><form:checkbox path="skip" value="true" id="skipp"
										onclick="return confirm('Do you want Skip Inspected Value?')" /></td>

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

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" class="alert-warning" id="salesUpDuplMessage"
								style="display: none; width: 600px; height: 25px;"></td>
						</tr>
					</table>
					<c:forEach var="inspLotEdit" items="${inspLotEdit}">

						<form:form method="post" action="inspLotResUpdate.mnt"
							commandName="inspLotResCmd" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="inspLotResultId" id="inspLotResultIdEdit" />
								<form:hidden path="acpInEdit" />
								<form:hidden path="inspInEdit" />
								<form:hidden path="nonCnfInEdit" />
								<tr>
									<td><spring:message code="label.inspreslot" /><span
										class="required">*</span></td>
									<td><form:select path="inspLotNoId" class="select"
											id="inspLotNoIdEdit">
											<form:option value="">-Select-</form:option>
											<form:options items="${inspLotSelect}" />
										</form:select></td>

								</tr>
								
								<tr>
								<td><spring:message code="label.insppd" /><span
									class="required">*</span></td>
								<td><form:select path="processDetailId" class="select"
										id="processDetailId">
										<form:option value="">-Select-</form:option>
										<form:options items="${ProcessDetail}" />
									</form:select></td>

							</tr>

								<tr>
									<td><spring:message code="label.inresdate" /><span
										class="required">*</span></td>
									<td><form:input path="startDate" class="textbox"
											id="startDateEdit" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.inresedate" /><span
										class="required">*</span></td>
									<td><form:input path="endDate" class="textbox"
											id="endDateEdit" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.inresin" /><span
										class="required"></span></td>
									<td><form:input path="inspected" class="textbox"
											id="inspectedEdit" onkeyup="ajaxForQtyEdit()" maxlength="21"/></td>
								</tr>

								<tr>
									<td><spring:message code="label.inresacc" /><span
										class="required"></span></td>
									<td><form:input path="accepted" class="textbox"
											id="acceptedEdit" maxlength="21"/></td>

								</tr>
								<tr>
									<td><spring:message code="label.inresnc" /><span
										class="required"></span></td>
									<td><form:input path="nonConf" class="textbox"
											id="nonConfEdit" onkeyup="QtyAddEdit()" maxlength="21"/></td>

								</tr>

								<tr>
									<td><spring:message code="label.inresm" /><span
										class="required">*</span></td>
									<td><form:input path="mean" class="textbox" id="meanEdit" maxlength="21"/></td>

								</tr>

								<tr>
									<td><spring:message code="label.inressv" /><span
										class="required">*</span></td>
									<td><form:input path="stdValue" class="textbox"
											id="stdValueEdit" maxlength="21"/></td>

								</tr>
								<tr>
									<td><spring:message code="label.inressk" /><span
										class="required"></span></td>
									<td><form:checkbox path="skip" id="skipEdit" /></td>

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
