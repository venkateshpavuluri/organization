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
<title>My JSP 'inspection Lot Ind Result.jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
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

<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
#scroll{
overflow: auto;
overflow-y:hidden;
overflow-x:scroll;
width: 45%;

}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {

											$('#addForm')
													.validate(
															{
																rules : {
																	inspLotId : {
																		required : true
																	},
																	processDetailId : {
																		required : true
																	},
																	
																	inspect : {
																		required : true,number:true
																		
																	},
																	inspected : {
																		required : true,
																		number : true
																		
																	}
																	
																},
																messages : {
																	
																	inspLotId : "<font style='color: red;'><b>Inspection Lot No is Required</b></font>",
																	processDetailId : "<font style='color: red;'><b>Process Detail is Required</b></font>",
																	inspect : {
																		required : "<font style='color: red;'><b>Inspect is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Allows Only Numbers</b></font>"
																	},
																	inspected : {
																		required : "<font style='color: red;'><b>Inspected is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Allows Only Numbers</b></font>"
																	}
																	
																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											$('#editForm')
													.validate(
															{
																rules : {
																	inspLotId : {
																		required : true
																	},
																	processDetailId : {
																		required : true
																	},
																	
																	inspect : {
																		required : true,number:true
																		
																	},
																	inspected : {
																		required : true,
																		number : true
																		
																	}
																},
																messages : {
																	inspLotId : "<font style='color: red;'><b>Inspection Lot No is Required</b></font>",
																	processDetailId : "<font style='color: red;'><b>Process Detail is Required</b></font>",
																	inspect : {
																		required : "<font style='color: red;'><b>Inspect is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Allows Only Numbers</b></font>"
																	},
																	inspected : {
																		required : "<font style='color: red;'><b>Inspected is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Allows Only Numbers</b></font>"
																	}
																},
															});

										});

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#tabs,#childTabs").tabs();
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#basicSearchId').focus();
			$('#inspLotId').focus();
			$('#inspLotId').val('');
			$('#processDetailId').val('');
			$('#inspect').val('');
			$('#inspected').val('');

		});
	});
</script>
<script type="text/javascript">
	
	function AjaxForDuplicate() {
		var inspNo = $('#inspLotNo').val();
		//alert(inspNo);
		$
				.ajax({
					type : "POST",
					url : "checkLotAddDuplicate.mnt",
					data : "inspLotNo=" + inspNo,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesDuplMessage").style.display = "block";
							//$('#salesDuplMessage').html(response);
							$('#subtnId').hide();

						} else {
							document.getElementById("salesDuplMessage").style.display = "none";
							$('#subtnId').show();
						}

					},
					error : function(e) {
						//alert('Error' + e);
					}

				});

	}

	function AjaxUpdateDuplicate() {
		var cust = $('#inspLotNoEdit').val();
		var id = $('#inspLotNoIdEdit').val();
		//alert(cust);
		$
				.ajax({
					type : "POST",
					url : "checkLotUpdateDuplicate.mnt",
					data : "inspLotNo=" + cust + "&inspLotNoId=" + id,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesUpDuplMessage").style.display = "block";
							//$('#salesUpDuplMessage').html(response);
							$('#updated').hide();

						} else {
							document.getElementById("salesUpDuplMessage").style.display = "none";
							$('#updated').show();
						}

					},
					error : function(e) {
						//alert('Error' + e);
					}

				});

	}
	
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Inspection Lot Individual Result</div>
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
					<form:form method="get" action="inspLotIndResSearch.mnt"
						commandName="inspLotIndResCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addLotsus"
										items="${param.addLotsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.inspindres" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addLotFail"
										items="${param.addLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.inspindres" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateLotssus"
										items="${param.updateLotssus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.inspindres" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="updateLotFail"
										items="${param.updateLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.inspindres" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteLotsus"
										items="${param.DeleteLotsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.inspindres" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteLotFail"
										items="${param.DeleteLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.inspindres" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr>
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="inspLotIndResCmd.operations">
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
								<c:set var="save" value="true"></c:set>
								<c:set var="edit" value="true"></c:set>
								<c:set var="delete" value="true"></c:set>
								<c:set var="update" value="true"></c:set>
								<c:set var="search" value="true"></c:set>
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


						</table>
					</form:form>

					<c:if test="${LOTList!=null }">
						<display:table name="LOTList" id="LOTIDList" class="table"
							requestURI="inspLotIndResSearch.mnt" pagesize="5">
							<display:column property="inspLotIndResId" sortable="true"
								title="inspLotIndResId" media="none" />

							<display:column property="inspLotId" sortable="true"
								titleKey="label.inspindlot" media="html" />
							<display:column property="processDetailId" sortable="true"
								titleKey="label.inspindpd" media="html" />

							<display:column property="inspect" sortable="true"
								titleKey="label.inspindip" media="html" />
							<display:column property="inspected" sortable="true"
								titleKey="label.inspindisp" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit }">
										<a
											href="inspLotIndResEdit.mnt?inspLotIndResId=<c:out value="${LOTIDList.inspLotIndResId}"/> "><img
											src="images/Edit.jpg" width="20px" height="20px" /></a>
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
											href="inspLotIndResDelete.mnt?inspLotIndResId=<c:out value="${LOTIDList.inspLotIndResId}"/> "
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
							<td colspan="2" id="salesDuplMessage" style="display: none;"
								class="alert-warning">
								<div>
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.insplno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="inspLotIndResAdd.mnt" id="addForm" method="POST"
						commandName="inspLotIndResCmd">
						<table class="tableGeneral">

							<tr>
								<td><spring:message code="label.inspindlot" /><span
									class="required">*</span></td>
								<td><form:select path="inspLotId" class="select"
										id="inspLotId">
										<form:option value="">-Select-</form:option>
										<form:options items="${inspLotSelect}" />
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.inspindpd" /><span
									class="required">*</span></td>
								<td><form:select path="processDetailId" class="select"
										id="processDetailId">
										<form:option value="">-Select-</form:option>
										<form:options items="${ProcessDetail}" />
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.inspindip" /><span
									class=required>*</span></td>
								<td><form:input path="inspect" id="inspect" class="textbox"
										maxlength="16" /></td>
							</tr>

							<tr>
								<td><spring:message code="label.inspindisp" /><span
									class="required">*</span></td>
								<td><form:input path="inspected" class="textbox"
										id="inspected" maxlength="16" /></td>

							</tr>

						</table>
						<!--Sub Tab Start  -->
						<div id="childTabs" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.indresline" /></a></li>
							</ul>

							<div id="tab1" align="left">
								<div align="left" >
									<script>
										var poptrid = 1;
										$(function() {
											var inspCharId = $("#inspCharId"),defClasId = $("#defectClsId"),defTypeId = $("#defectTypeId"),cGrpId = $("#codeGrpId"),mintl = $("#minTolerance"),maxtl = $("#maxTolerance"),
											codeId = $("#codeId"),uomId = $("#uomId"),sNo = $("#sampleNo"),uLimit = $("#upperLimit"),lLimit = $("#lowerLimit"),
											mVal = $("#measuredVal"),defLoc = $("#defectLoc"),valu = $("#valuation"),indecId = $("#inspDecisionId"),hiddenID = $("#hiddenIdInsp"), allFields = $(
													[]).add(inspCharId).add(defClasId).add(defTypeId).add(cGrpId).add(mintl).add(maxtl).add(codeId).add(uomId).add(sNo).add(uLimit).add(lLimit)
													.add(mVal).add(defLoc).add(valu).add(indecId)
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

											function Required(o, n) {
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

											$("#dialog-form-POP")
													.dialog(
															{
																autoOpen : false,
																height : 530,
																width : 450,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields
																				.removeClass("ui-state-error");

																		bValid = bValid&& Required(inspCharId,"inspection characteristic");
																		bValid = bValid&& Required(uomId,"Uom");
																		bValid = bValid&& Required(defClasId,"Defect Class");
																		bValid = bValid&& Required(defTypeId,"Defect Type");
																		bValid = bValid&& Required(cGrpId,"Code Group");
																		bValid = bValid&& Required(codeId,"Code");
																		bValid = bValid&& Required(sNo,"Sample No");
																		bValid = bValid&& Required(uLimit,"Upper Limit")&& checkRegexp(uLimit,/^([0-9.])+$/,"Upper Limit Allows only Numbers");
																		bValid = bValid&& Required(lLimit,"Lower Limit");
																		bValid = bValid&& Required(maxtl,"Max Tolerance");
																		bValid = bValid&& Required(mintl,"Min Tolerance");
																		bValid = bValid&& Required(mVal,"Measured Value")&& checkRegexp(mVal,/^([0-9.])+$/,"Measured Value Allows only Numbers");
																		bValid = bValid&& Required(defLoc,"Defect Location");
																		bValid = bValid&& Required(indecId,"Inspection Decision");
																		bValid = bValid&& Required(valu,"Valuation");
																				
																		if (bValid) {
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {

																				$(
																						"#InspLotResAdd tbody")
																						.append(
																								"<tr id="+poptrid+">"

																										+ "<td ><input type='hidden' name='inspCharId' id='inspCharId"
																										+ poptrid
																										+ "' value="
																										+ inspCharId.val()
																										+ "  class='textbox'readonly/><input type='text' name='inspCharName' id='inspCharName"
																										+ poptrid
																										+ "' value="
																										+ $('#inspCharId :selected').text()
																										+ "  class='textbox'readonly/></td>"
																										 + "<td ><input type='hidden' name='uomId' id='uomId"
																										+ poptrid
																										+ "' value="
																										+ uomId.val()
																										+ "  class='textbox'readonly/><input type='text' name='uomName' id='uomName"
																										+ poptrid
																										+ "' value="
																										+ $('#uomId :selected').text()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='hidden' name='defectClsId' id='defectClsId"
																										+ poptrid
																										+ "' value="
																										+ defClasId.val()
																										+ "  class='textbox'readonly/><input type='text' name='defClsName' id='defClsName"
																										+ poptrid
																										+ "' value="
																										+ $('#defectClsId :selected').text()
																										+ "  class='textbox'readonly/></td>"
																											+ "<td ><input type='hidden' name='defectTypeId' id='defectTypeId"
																										+ poptrid
																										+ "' value="
																										+ defTypeId.val()
																										+ "  class='textbox'readonly/><input type='text' name='defTypeName' id='defTypeName"
																										+ poptrid
																										+ "' value="
																										+ $('#defectTypeId :selected').text()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='hidden' name='codeGrpId' id='codeGrpId"
																										+ poptrid
																										+ "' value="
																										+ cGrpId.val()
																										+ "  class='textbox'readonly/><input type='text' name='codeGrpName' id='codeGrpName"
																										+ poptrid
																										+ "' value="
																										+ $('#codeGrpId :selected').text()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='hidden' name='codeId' id='codeId"
																										+ poptrid
																										+ "' value="
																										+ codeId.val()
																										+ "  class='textbox'readonly/><input type='text' name='codeName' id='codeName"
																										+ poptrid
																										+ "' value="
																										+ $('#codeId :selected').text()
																										+ "  class='textbox'readonly/></td>"
																										
																										+ "<td ><input type='text' name='sampleNo' id='sampleNo"
																										+ poptrid
																										+ "' value="
																										+ sNo.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='upperLimit' id='upperLimit"
																										+ poptrid
																										+ "' value="
																										+ uLimit.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='lowerLimit' id='lowerLimit"
																										+ poptrid
																										+ "' value="
																										+ lLimit.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='maxTolerance' id='maxTolerance"
																										+ poptrid
																										+ "' value="
																										+ maxtl.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='minTolerance' id='minTolerance"
																										+ poptrid
																										+ "' value="
																										+ mintl.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='measuredVal' id='measuredVal"
																										+ poptrid
																										+ "' value="
																										+ mVal.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='defectLoc' id='defectLoc"
																										+ poptrid
																										+ "' value="
																										+ defLoc.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='inspDecisionId' id='inspDecisionId"
																										+ poptrid
																										+ "' value="
																										+ indecId.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='valuation' id='valuation"
																										+ poptrid
																										+ "' value="
																										+ valu.val()
																										+ "  class='textbox'readonly/></td>" 
																										
																										+ "<td><a href='#'  onclick='editResLine("
																										+ poptrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeResLine("
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
																				$('#inspCharId'+ hiddenID.val()).val(inspCharId.val());
																				$('#inspCharName'+ hiddenID.val()).val($('#inspCharId :selected').text());
																				$('#uomId'+ hiddenID.val()).val(uomId.val());
																				$('#uomName'+ hiddenID.val()).val($('#uomId :selected').text());
																				$('#defectClsId'+ hiddenID.val()).val(defClasId.val());
																				$('#defClsName'+ hiddenID.val()).val($('#defectClsId :selected').text());
																				$('#defectTypeId'+ hiddenID.val()).val(defTypeId.val());
																				$('#defTypeName'+ hiddenID.val()).val($('#defectTypeId :selected').text());
																				$('#codeGrpId'+ hiddenID.val()).val(cGrpId.val());
																				$('#codeGrpName'+ hiddenID.val()).val($('#codeGrpId :selected').text());
																				$('#codeId'+ hiddenID.val()).val(codeId.val());
																				$('#codeName'+ hiddenID.val()).val($('#codeId :selected').text());
																				
																				$('#sampleNo'+ hiddenID.val()).val(sNo.val());
																				$('#upperLimit'+ hiddenID.val()).val(uLimit.val());
																				$('#lowerLimit'+ hiddenID.val()).val(lLimit.val());
																				$('#maxTolerance'+ hiddenID.val()).val(maxtl.val());
																				$('#minTolerance'+ hiddenID.val()).val(mintl.val());
																				$('#measuredVal'+ hiddenID.val()).val(mVal.val());
																				$('#defectLoc'+ hiddenID.val()).val(defLoc.val());
																				$('#valuation'+ hiddenID.val()).val(valu.val());
																				$('#inspDecisionId'+ hiddenID.val()).val(indecId.val());
																			
																				$('#hiddenIdInsp').val("0");
																				$(this).dialog("close");
																						
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

											$("#create-AddLine")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-POP")
																		.dialog(
																				"open");
																tips.text('');

															});
										});
										function removeResLine(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editResLine(id) {
											//alert("edit row " + id);
											$(".validateTips").text('');
											$("#dialog-form-POP")
													.dialog("open");

											$('#inspCharId').val($('#inspCharId' + id).val());
											$('#inspCharName').val($('#inspCharName' + id).val());
											$('#uomId').val($('#uomId' + id).val());
											$('#uomName').val($('#uomName' + id).val());
											$('#defectClsId').val($('#defectClsId' + id).val());
											$('#defClsName').val($('#defClsName' + id).val());
											$('#defectTypeId').val($('#defectTypeId' + id).val());
											$('#defTypeName').val($('#defTypeName' + id).val());
											$('#codeGrpId').val($('#codeGrpId' + id).val());
											$('#codeGrpName').val($('#codeGrpName' + id).val());
											$('#codeId').val($('#codeId' + id).val());
											$('#codeName').val($('#codeName' + id).val());
											$('#sampleNo').val($('#sampleNo' + id).val());
											$('#upperLimit').val($('#upperLimit' + id).val());
											$('#lowerLimit').val($('#lowerLimit' + id).val());
											$('#maxTolerance').val($('#maxTolerance' + id).val());
											$('#minTolerance').val($('#minTolerance' + id).val());
											$('#measuredVal').val($('#measuredVal' + id).val());
											$('#defectLoc').val($('#defectLoc' + id).val());
											$('#inspDecisionId').val($('#inspDecisionId' + id).val());
											$('#valuation').val($('#valuation' + id).val());

											$('#hiddenIdInsp').val(id);

										}
									</script>
									<div id="dialog-form-POP"
										title="<spring:message code="label.indresline"/>">
										<p class="validateTips" align="center" style="color: blue;"></p>
										<table class="tableGeneral">

											<tr>
												<td><spring:message code="label.indchar" /><font
													color="red">*</font></td>
												<td><form:select path="inspCharName" id="inspCharId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${InspChar }" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.induom" /><font
													color="red">*</font></td>
												<td><form:select path="uomName" id="uomId" class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${uomSelect }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.inddefcls" /><font
													color="red">*</font></td>
												<td><form:select path="defClsName" id="defectClsId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${DefectSelect }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.inddeftype" /><font
													color="red">*</font></td>
												<td><form:select path="defTypeName" id="defectTypeId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${DefectType }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.indcgrp" /><font
													color="red">*</font></td>
												<td><form:select path="codeGrpName" id="codeGrpId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${CodeGrp }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.indcode" /><font
													color="red">*</font></td>
												<td><form:select path="codeName" id="codeId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${CodeSelect }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.indsno" /><span
													class="required">*</span></td>
												<td><form:input path="sampleNo" class="textbox"
														id="sampleNo" maxlength="30" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indul" /><span
													class="required">*</span></td>
												<td><form:input path="upperLimit" class="textbox"
														id="upperLimit" maxlength="16" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indll" /><span
													class="required">*</span></td>
												<td><form:input path="lowerLimit" class="textbox"
														id="lowerLimit" maxlength="10" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indmaxtl" /><span
													class="required">*</span></td>
												<td><form:input path="maxTolerance" class="textbox"
														id="maxTolerance" maxlength="10" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indmintl" /><span
													class="required">*</span></td>
												<td><form:input path="minTolerance" class="textbox"
														id="minTolerance" maxlength="10" /></td>

											</tr>
											
											<tr>
												<td><spring:message code="label.indmsval" /><span
													class="required">*</span></td>
												<td><form:input path="measuredVal" class="textbox"
														id="measuredVal" maxlength="16" /></td>

											</tr>
											
											<tr>
												<td><spring:message code="label.inddefloc" /><span
													class="required">*</span></td>
												<td><form:input path="defectLoc" class="textbox"
														id="defectLoc" maxlength="30" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indindec" /><span
													class="required">*</span></td>
												<td><form:input path="inspDecisionId" class="textbox"
														id="inspDecisionId" maxlength="20" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indval" /><span
													class="required">*</span></td>
												<td><form:input path="valuation" class="textbox"
														id="valuation" maxlength="1" />
														 <input type="hidden" name="hiddenIdInsp" id="hiddenIdInsp"
													value="0" /></td>

											</tr>


										</table>
									</div>


									<div id="users-contain-POP" >
									<div id="scroll" align="center">
										<table id="InspLotResAdd" class="table">
											<thead>
												<tr>

													<th><spring:message code="label.indchar" /></th>
													<th><spring:message code="label.induom" /></th>
													<th><spring:message code="label.inddefcls" /></th>
													<th><spring:message code="label.inddeftype" /></th>
													<th><spring:message code="label.indcgrp" /></th>
													<th><spring:message code="label.indcode" /></th>
													<th><spring:message code="label.indsno" /></th>
													<th><spring:message code="label.indul" /></th>
													<th><spring:message code="label.indll" /></th>
													<th><spring:message code="label.indmaxtl" /></th>
													<th><spring:message code="label.indmintl" /></th>
													<th><spring:message code="label.indmsval" /></th>
													<th><spring:message code="label.inddefloc" /></th>
													<th><spring:message code="label.indindec" /></th>
													<th><spring:message code="label.indval" /></th>
													
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									
									<button id="create-AddLine" type="button">
										<spring:message code="label.indadd" />
									</button>
</div>
</div>
								</div>

							</div>

						</div>


						<!--Sub Tab End  -->

						<table>
							<tr>

								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="subtnId"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="subtnId" disabled="disabled"
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
							<td colspan="2" id="salesUpDuplMessage" style="display: none;"
								class="alert-warning">
								<div>
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.insplno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<c:forEach var="inspLotEdit" items="${inspLotEdit}">

						<form:form method="post" action="inspLotIndResUpdate.mnt"
							commandName="inspLotIndResCmd" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="inspLotIndResId" id="inspLotIndResIdEdit" />
								<tr>
								<td><spring:message code="label.inspindlot" /><span
									class="required">*</span></td>
								<td><form:select path="inspLotId" class="select"
										id="inspLotIdEdit">
										<form:option value="">-Select-</form:option>
										<form:options items="${inspLotSelect}" />
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.inspindpd" /><span
									class="required">*</span></td>
								<td><form:select path="processDetailId" class="select"
										id="processDetailIdEdit">
										<form:option value="">-Select-</form:option>
										<form:options items="${ProcessDetail}" />
									</form:select></td>

							</tr>


							<tr>
								<td><spring:message code="label.inspindip" /><span
									class=required>*</span></td>
								<td><form:input path="inspect" id="inspectEdit" class="textbox"
										maxlength="16" /></td>
							</tr>

							<tr>
								<td><spring:message code="label.inspindisp" /><span
									class="required">*</span></td>
								<td><form:input path="inspected" class="textbox"
										id="inspectedEdit" maxlength="16" /></td>

							</tr>
							</table>

							<!-- Sub tab in edit -->
							<div id="childTabs" align="left">
								<ul>
									<li><a href="#tab1"><spring:message
												code="label.indresline" /></a></li>
								</ul>

								<div id="tab1">

									<div align="left">
										<script>
											var btrid = 10;
											$(function() {

												var inspCharIdEdit = $("#inspCharIdEdit"),defClasIdEdit = $("#defectClsIdEdit"),defTypeIdEdit = $("#defectTypeIdEdit"),cGrpIdEdit = $("#codeGrpIdEdit"),mintlEdit = $("#minToleranceEdit"),maxtlEdit = $("#maxToleranceEdit"),
												codeIdEdit = $("#codeIdEdit"),uomIdEdit = $("#uomIdEdit"),sNoEdit = $("#sampleNoEdit"),uLimitEdit = $("#upperLimitEdit"),lLimitEdit = $("#lowerLimitEdit"),
												mValEdit = $("#measuredValEdit"),defLocEdit = $("#defectLocEdit"),valuEdit = $("#valuationEdit"),indecIdEdit = $("#inspDecisionIdEdit"),hiddenEdit = $("#hiddenIdInspEdit"), allFields = $(
														[]).add(inspCharIdEdit).add(defClasIdEdit).add(defTypeIdEdit).add(cGrpIdEdit).add(mintlEdit).add(maxtlEdit).add(codeIdEdit).add(uomIdEdit).add(sNoEdit).add(uLimitEdit).add(lLimitEdit)
														.add(mValEdit).add(defLocEdit).add(valuEdit).add(indecIdEdit).add(
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
													if (o.val().length == 0) {
														o
																.addClass("ui-state-error");
														updateTips("" + n);
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

												$("#dialog-form-EqpEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 530,
																	width : 450,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");
																			bValid1 = bValid1&& requiredEdit(inspCharIdEdit,"inspection characteristic");
																			bValid1 = bValid1&& requiredEdit(uomIdEdit,"Uom");
																			bValid1 = bValid1&& requiredEdit(defClasIdEdit,"Defect Class");
																			bValid1 = bValid1&& requiredEdit(defTypeIdEdit,"Defect Type");
																			bValid1 = bValid1&& requiredEdit(cGrpIdEdit,"Code Group");
																			bValid1 = bValid1&& requiredEdit(codeIdEdit,"Code");
																			bValid1 = bValid1&& requiredEdit(sNoEdit,"Sample No");
																			bValid1 = bValid1&& requiredEdit(uLimitEdit,"Upper Limit")&& checkRegexp(uLimitEdit,/^([0-9.])+$/,"Upper Limit Allows only Numbers");
																			bValid1 = bValid1&& requiredEdit(lLimitEdit,"Lower Limit");
																			bValid1 = bValid1&& requiredEdit(maxtlEdit,"Max Tolerance");
																			bValid1 = bValid1&& requiredEdit(mintlEdit,"Min Tolerance");
																			bValid1 = bValid1&& requiredEdit(mValEdit,"Measured Value")&& checkRegexp(mValEdit,/^([0-9.])+$/,"Measured Value Allows only Numbers");
																			bValid1 = bValid1&& requiredEdit(defLocEdit,"Defect Location");
																			bValid1 = bValid1&& requiredEdit(indecIdEdit,"Inspection Decision");
																			bValid1 = bValid1&& requiredEdit(valuEdit,"Valuation"); 

																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddEqpEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																									+ "<td ><input type='hidden' name='inspCharId' id='inspCharIdEdit"
																									+ btrid
																									+ "' value="
																									+ inspCharIdEdit.val()
																									+ "  class='textbox'readonly/><input type='text' name='inspCharName' id='inspCharNameEdit"
																									+ btrid
																									+ "' value="
																									+ $('#inspCharIdEdit :selected').text()
																									+ "  class='textbox'readonly/></td>"
																									 + "<td ><input type='hidden' name='uomId' id='uomIdEdit"
																									+ btrid
																									+ "' value="
																									+ uomIdEdit.val()
																									+ "  class='textbox'readonly/><input type='text' name='uomName' id='uomNameEdit"
																									+ btrid
																									+ "' value="
																									+ $('#uomIdEdit :selected').text()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='hidden' name='defectClsId' id='defectClsIdEdit"
																									+ btrid
																									+ "' value="
																									+ defClasIdEdit.val()
																									+ "  class='textbox'readonly/><input type='text' name='defClsName' id='defClsNameEdit"
																									+ btrid
																									+ "' value="
																									+ $('#defectClsIdEdit :selected').text()
																									+ "  class='textbox'readonly/></td>"
																										+ "<td ><input type='hidden' name='defectTypeId' id='defectTypeIdEdit"
																									+ btrid
																									+ "' value="
																									+ defTypeIdEdit.val()
																									+ "  class='textbox'readonly/><input type='text' name='defTypeName' id='defTypeNameEdit"
																									+ btrid
																									+ "' value="
																									+ $('#defectTypeIdEdit :selected').text()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='hidden' name='codeGrpId' id='codeGrpIdEdit"
																									+ btrid
																									+ "' value="
																									+ cGrpIdEdit.val()
																									+ "  class='textbox'readonly/><input type='text' name='codeGrpName' id='codeGrpNameEdit"
																									+ btrid
																									+ "' value="
																									+ $('#codeGrpIdEdit :selected').text()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='hidden' name='codeId' id='codeIdEdit"
																									+ btrid
																									+ "' value="
																									+ codeIdEdit.val()
																									+ "  class='textbox'readonly/><input type='text' name='codeName' id='codeNameEdit"
																									+ btrid
																									+ "' value="
																									+ $('#codeIdEdit :selected').text()
																									+ "  class='textbox'readonly/></td>"
																									
																									+ "<td ><input type='text' name='sampleNo' id='sampleNoEdit"
																									+ btrid
																									+ "' value="
																									+ sNoEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='upperLimit' id='upperLimitEdit"
																									+ btrid
																									+ "' value="
																									+ uLimitEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='lowerLimit' id='lowerLimitEdit"
																									+ btrid
																									+ "' value="
																									+ lLimitEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='maxTolerance' id='maxToleranceEdit"
																									+ btrid
																									+ "' value="
																									+ maxtlEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='minTolerance' id='minToleranceEdit"
																									+ btrid
																									+ "' value="
																									+ mintlEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='measuredVal' id='measuredValEdit"
																									+ btrid
																									+ "' value="
																									+ mValEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='defectLoc' id='defectLocEdit"
																									+ btrid
																									+ "' value="
																									+ defLocEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='inspDecisionId' id='inspDecisionIdEdit"
																									+ btrid
																									+ "' value="
																									+ indecIdEdit.val()
																									+ "  class='textbox'readonly/></td>"
																									+ "<td ><input type='text' name='valuation' id='valuationEdit"
																									+ btrid
																									+ "' value="
																									+ valuEdit.val()
																									+ "  class='textbox'readonly/></td>" 

																											+ "<input type='hidden' name='inspLotIndResLineId' id='inspLotIndResLineId' value='0'/></td>"
																											+ "<td><a href='#'  onclick='editEqpInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeEqpEditNew("
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
																					$('#inspCharIdEdit'+ hiddenEdit.val()).val(inspCharIdEdit.val());
																					$('#inspCharNameEdit'+ hiddenEdit.val()).val($('#inspCharIdEdit :selected').text());
																					$('#uomIdEdit'+ hiddenEdit.val()).val(uomIdEdit.val());
																					$('#uomNameEdit'+ hiddenEdit.val()).val($('#uomIdEdit :selected').text());
																					$('#defectClsIdEdit'+ hiddenEdit.val()).val(defClasIdEdit.val());
																					$('#defClsNameEdit'+ hiddenEdit.val()).val($('#defectClsIdEdit :selected').text());
																					$('#defectTypeIdEdit'+ hiddenEdit.val()).val(defTypeIdEdit.val());
																					$('#defTypeNameEdit'+ hiddenEdit.val()).val($('#defectTypeIdEdit :selected').text());
																					$('#codeGrpIdEdit'+ hiddenEdit.val()).val(cGrpIdEdit.val());
																					$('#codeGrpNameEdit'+ hiddenEdit.val()).val($('#codeGrpIdEdit :selected').text());
																					$('#codeIdEdit'+ hiddenEdit.val()).val(codeIdEdit.val());
																					$('#codeNameEdit'+ hiddenEdit.val()).val($('#codeIdEdit :selected').text());	
																					
																					$('#sampleNoEdit'+ hiddenEdit.val()).val($('#sampleNoEdit').val());
																					$('#upperLimitEdit'+ hiddenEdit.val()).val($('#upperLimitEdit').val());
																					$('#lowerLimitEdit'+ hiddenEdit.val()).val($('#lowerLimitEdit').val());
																					$('#maxToleranceEdit'+ hiddenEdit.val()).val($('#maxToleranceEdit').val());
																					$('#minToleranceEdit'+ hiddenEdit.val()).val($('#minToleranceEdit').val());
																					$('#measuredValEdit'+ hiddenEdit.val()).val($('#measuredValEdit').val());
																					$('#defectLocEdit'+ hiddenEdit.val()).val($('#defectLocEdit').val());
																					$('#inspDecisionIdEdit'+ hiddenEdit.val()).val($('#inspDecisionIdEdit').val());
																					$('#valuationEdit'+ hiddenEdit.val()).val($('#valuationEdit').val());
																					
																					$(
																							'#hiddenIdInspEdit')
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

												$("#create-AddEqpEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-EqpEdit")
																			.dialog(
																					"open");
																	tips
																			.text('');

																});
											});
											function removeEqpEditNew(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editEqpInEditNew(id) {
												//alert(id);
												$(".validateTips").text('');
												$("#dialog-form-EqpEdit")
														.dialog("open");
												$('#inspCharIdEdit').val($('#inspCharIdEdit' + id).val());
												$('#inspCharNameEdit').val($('#inspCharNameEdit' + id).val());
												$('#uomIdEdit').val($('#uomIdEdit' + id).val());
												$('#uomNameEdit').val($('#uomNameEdit' + id).val());
												$('#defectClsIdEdit').val($('#defectClsIdEdit' + id).val());
												$('#defClsNameEdit').val($('#defClsNameEdit' + id).val());
												$('#defectTypeIdEdit').val($('#defectTypeIdEdit' + id).val());
												$('#defTypeNameEdit').val($('#defTypeNameEdit' + id).val());
												$('#codeGrpIdEdit').val($('#codeGrpIdEdit' + id).val());
												$('#codeGrpNameEdit').val($('#codeGrpNameEdit' + id).val());
												$('#codeIdEdit').val($('#codeIdEdit' + id).val());
												$('#codeNameEdit').val($('#codeNameEdit' + id).val());
												$('#sampleNoEdit').val($('#sampleNoEdit' + id).val());
												$('#upperLimitEdit').val($('#upperLimitEdit' + id).val());
												$('#lowerLimitEdit').val($('#lowerLimitEdit' + id).val());
												$('#maxToleranceEdit').val($('#maxToleranceEdit' + id).val());
												$('#minToleranceEdit').val($('#minToleranceEdit' + id).val());
												$('#measuredValEdit').val($('#measuredValEdit' + id).val());
												$('#defectLocEdit').val($('#defectLocEdit' + id).val());
												$('#inspDecisionIdEdit').val($('#inspDecisionIdEdit' + id).val());
												$('#valuationEdit').val($('#valuationEdit' + id).val());
												
												$('#hiddenIdInspEdit').val(
														id);

											}
										</script>
										<div id="dialog-form-EqpEdit"
											title="<spring:message code="label.indresline"/>">
											<p class="validateTips" align="center" style="color: blue;"></p>
											<table class="tableGeneral">
												<form:hidden path="inspLotIndResLineId" value="0" />
												<tr>
												<td><spring:message code="label.indchar" /><font
													color="red">*</font></td>
												<td><form:select path="inspCharName" id="inspCharIdEdit"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${InspChar }" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.induom" /><font
													color="red">*</font></td>
												<td><form:select path="uomName" id="uomIdEdit" class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${uomSelect }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.inddefcls" /><font
													color="red">*</font></td>
												<td><form:select path="defClsName" id="defectClsIdEdit"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${DefectSelect }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.inddeftype" /><font
													color="red">*</font></td>
												<td><form:select path="defTypeName" id="defectTypeIdEdit"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${DefectType }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.indcgrp" /><font
													color="red">*</font></td>
												<td><form:select path="codeGrpName" id="codeGrpIdEdit"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${CodeGrp }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.indcode" /><font
													color="red">*</font></td>
												<td><form:select path="codeName" id="codeIdEdit"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${CodeSelect }" />
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.indsno" /><span
													class="required">*</span></td>
												<td><form:input path="sampleNo" class="textbox"
														id="sampleNoEdit" maxlength="30" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indul" /><span
													class="required">*</span></td>
												<td><form:input path="upperLimit" class="textbox"
														id="upperLimitEdit" maxlength="16" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indll" /><span
													class="required">*</span></td>
												<td><form:input path="lowerLimit" class="textbox"
														id="lowerLimitEdit" maxlength="10" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indmaxtl" /><span
													class="required">*</span></td>
												<td><form:input path="maxTolerance" class="textbox"
														id="maxToleranceEdit" maxlength="10" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indmintl" /><span
													class="required">*</span></td>
												<td><form:input path="minTolerance" class="textbox"
														id="minToleranceEdit" maxlength="10" /></td>

											</tr>
											
											<tr>
												<td><spring:message code="label.indmsval" /><span
													class="required">*</span></td>
												<td><form:input path="measuredVal" class="textbox"
														id="measuredValEdit" maxlength="16" /></td>

											</tr>
											
											<tr>
												<td><spring:message code="label.inddefloc" /><span
													class="required">*</span></td>
												<td><form:input path="defectLoc" class="textbox"
														id="defectLocEdit" maxlength="30" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indindec" /><span
													class="required">*</span></td>
												<td><form:input path="inspDecisionId" class="textbox"
														id="inspDecisionIdEdit" maxlength="20" /></td>

											</tr>
											<tr>
												<td><spring:message code="label.indval" /><span
													class="required">*</span></td>
												<td><form:input path="valuation" class="textbox"
														id="valuationEdit" maxlength="1" />
														 <input type="hidden" name="hiddenIdInspEdit" id="hiddenIdInspEdit"
													value="0" /></td>
											</tr>

											</table>
										</div>

										<div id="users-contain-EqpEdit">
										<div align="center" id="scroll">
											<table id=AddEqpEdit class="table">
												<thead>
													<tr>
													<th><spring:message code="label.indchar" /></th>
													<th><spring:message code="label.induom" /></th>
													<th><spring:message code="label.inddefcls" /></th>
													<th><spring:message code="label.inddeftype" /></th>
													<th><spring:message code="label.indcgrp" /></th>
													<th><spring:message code="label.indcode" /></th>
													<th><spring:message code="label.indsno" /></th>
													<th><spring:message code="label.indul" /></th>
													<th><spring:message code="label.indll" /></th>
													<th><spring:message code="label.indmaxtl" /></th>
													<th><spring:message code="label.indmintl" /></th>
													<th><spring:message code="label.indmsval" /></th>
													<th><spring:message code="label.inddefloc" /></th>
													<th><spring:message code="label.indindec" /></th>
													<th><spring:message code="label.indval" /></th>
													
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>
												</thead>
												<tbody>
													<c:forEach var="inspLotLineEdit" items="${inspLotLineEdit}">

														<tr id="${inspLotLineEdit.inspLotIndResLineId}">

															<spring:bind path="inspLotIndResCmd.inspLotIndResLineId">
																<input type="hidden" name="inspLotIndResLineId" class="textbox"
																	value="${inspLotLineEdit.inspLotIndResLineId}"
																	id="inspLotIndResLineId${inspLotLineEdit.inspLotIndResLineId}" />
															</spring:bind>

															<td><spring:bind path="inspLotIndResCmd.inspCharId">
																<input type="hidden" name="inspCharId" class="textbox"
																	value="${inspLotLineEdit.inspCharId}"
																	id="inspCharIdEdit${inspLotLineEdit.inspLotIndResLineId}" />
															</spring:bind>
															<spring:bind path="inspLotIndResCmd.inspCharName">
																	<input type="text" name="inspCharName" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.inspCharName}"
																		id="inspCharNameEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind> </td>
																
																<td><spring:bind path="inspLotIndResCmd.uomId">
																<input type="hidden" name="uomId" class="textbox"
																	value="${inspLotLineEdit.uomId}"
																	id="uomIdEdit${inspLotLineEdit.inspLotIndResLineId}" />
															</spring:bind>
															<spring:bind path="inspLotIndResCmd.uomName">
																	<input type="text" name="uomName" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.uomName}"
																		id="uomNameEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind> </td>
																
																<td><spring:bind path="inspLotIndResCmd.defectClsId">
																<input type="hidden" name="defectClsId" class="textbox"
																	value="${inspLotLineEdit.defectClsId}"
																	id="defectClsIdEdit${inspLotLineEdit.inspLotIndResLineId}" />
															</spring:bind>
															<spring:bind path="inspLotIndResCmd.defClsName">
																	<input type="text" name="defClsName" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.defClsName}"
																		id="defClsNameEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind> </td>
																
																<td><spring:bind path="inspLotIndResCmd.defectTypeId">
																<input type="hidden" name="defectTypeId" class="textbox"
																	value="${inspLotLineEdit.defectTypeId}"
																	id="defectTypeIdEdit${inspLotLineEdit.inspLotIndResLineId}" />
															</spring:bind>
															<spring:bind path="inspLotIndResCmd.defTypeName">
																	<input type="text" name="defTypeName" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.defTypeName}"
																		id="defTypeNameEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind> </td>
																
																<td><spring:bind path="inspLotIndResCmd.codeGrpId">
																<input type="hidden" name="codeGrpId" class="textbox"
																	value="${inspLotLineEdit.codeGrpId}"
																	id="codeGrpIdEdit${inspLotLineEdit.inspLotIndResLineId}" />
															</spring:bind>
															<spring:bind path="inspLotIndResCmd.codeGrpName">
																	<input type="text" name="codeGrpName" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.codeGrpName}"
																		id="codeGrpNameEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind> </td>
																
																<td><spring:bind path="inspLotIndResCmd.codeId">
																<input type="hidden" name="codeId" class="textbox"
																	value="${inspLotLineEdit.codeId}"
																	id="codeIdEdit${inspLotLineEdit.inspLotIndResLineId}" />
															</spring:bind>
															<spring:bind path="inspLotIndResCmd.codeName">
																	<input type="text" name="codeName" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.codeName}"
																		id="codeNameEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind> </td>
																<td>
																<spring:bind path="inspLotIndResCmd.sampleNo">
																	<input type="text" name="sampleNo" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.sampleNo}"
																		id="sampleNoEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																
																<td>
																<spring:bind path="inspLotIndResCmd.upperLimit">
																	<input type="text" name="upperLimit" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.upperLimit}"
																		id="upperLimitEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																<td>
																<spring:bind path="inspLotIndResCmd.lowerLimit">
																	<input type="text" name="lowerLimit" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.lowerLimit}"
																		id="lowerLimitEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																<td>
																<spring:bind path="inspLotIndResCmd.maxTolerance">
																	<input type="text" name="maxTolerance" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.maxTolerance}"
																		id="maxToleranceEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																<td>
																<spring:bind path="inspLotIndResCmd.minTolerance">
																	<input type="text" name="minTolerance" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.minTolerance}"
																		id="minToleranceEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																<td>
																<spring:bind path="inspLotIndResCmd.measuredVal">
																	<input type="text" name="measuredVal" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.measuredVal}"
																		id="measuredValEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																<td>
																<spring:bind path="inspLotIndResCmd.defectLoc">
																	<input type="text" name="defectLoc" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.defectLoc}"
																		id="defectLocEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																<td>
																<spring:bind path="inspLotIndResCmd.inspDecisionId">
																	<input type="text" name="inspDecisionId" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.inspDecisionId}"
																		id="inspDecisionIdEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind>
																</td>
																<td>
																<spring:bind path="inspLotIndResCmd.valuation">
																	<input type="text" name="valuation" class="textbox"
																		readonly="readonly" value="${inspLotLineEdit.valuation}"
																		id="valuationEdit${inspLotLineEdit.inspLotIndResLineId}" />
																</spring:bind><input type='hidden'
																name="${inspLotLineEdit.inspLotIndResLineId}Check"
																id="${inspLotLineEdit.inspLotIndResLineId}Check" value="0" />
																</td>

																
															<td><a href="#" id="${inspLotLineEdit.inspLotIndResLineId}"
																onclick="javascript:editPOPDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${inspLotLineEdit.inspLotIndResLineId}"></img></a></td>
															<td><a href="#" id="${inspLotLineEdit.inspLotIndResLineId}"
																onclick="javascript:getID(this)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px" id="${inspLotLineEdit.inspLotIndResLineId}"></img></a></td>
														</tr>

														<script type="text/javascript">
															function getID(
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
																//alert(link.id);
																			$("#dialog-form-EqpEdit")
																		.dialog(
																				"open");

																$('#inspCharIdEdit').val($('#inspCharIdEdit' + link.id).val());
																$('#uomIdEdit').val($('#uomIdEdit' + link.id).val());
																$('#defectClsIdEdit').val($('#defectClsIdEdit' + link.id).val());
																$('#defectTypeIdEdit').val($('#defectTypeIdEdit' + link.id).val());
																$('#codeGrpIdEdit').val($('#codeGrpIdEdit' + link.id).val());
																$('#codeIdEdit').val($('#codeIdEdit' + link.id).val());
																$('#sampleNoEdit').val($('#sampleNoEdit' + link.id).val());
																$('#upperLimitEdit').val($('#upperLimitEdit' + link.id).val());
																$('#lowerLimitEdit').val($('#lowerLimitEdit' + link.id).val());
																$('#maxToleranceEdit').val($('#maxToleranceEdit' + link.id).val());
																$('#minToleranceEdit').val($('#minToleranceEdit' + link.id).val());
																$('#measuredValEdit').val($('#measuredValEdit' + link.id).val());
																$('#defectLocEdit').val($('#defectLocEdit' + link.id).val());
																$('#inspDecisionIdEdit').val($('#inspDecisionIdEdit' + link.id).val());
																$('#valuationEdit').val($('#valuationEdit' + link.id).val());
																
																$('#hiddenIdInspEdit').val(link.id);
																		
															}
														</script>

													</c:forEach>

												</tbody>

											</table>
											<button id="create-AddEqpEdit" type="button">
											<spring:message code="label.indadd" />
										</button>
											</div>
										</div>
										
									</div>

								</div>
							</div>

							<!-- Sub tab in edit end -->

							<table>
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
