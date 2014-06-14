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
	$(document).ready(function() {
						//AddForm Validations
						$('#subid')
								.click(
										function(event) {

											$('#addagform')
													.validate(
															{
																rules : {
																	assettypeId : {
																		required : true
																	},
																	assetgroupId : {
																		required : true
																	},
																	model : {
																		required : true
																	},
																	serialNumber : {
																		required : true
																	},
																	status : {
																		required : true
																	},
																	
																	
																},
																messages : {
																	assettypeId : "<font style='color: red;'><b>Asset Type is Required</b></font>",
																	
																	assetgroupId : "<font style='color: red;'><b>Asset Group is Required</b></font>",
																	model : "<font style='color: red;'><b>Model is Required</b></font>",
																	serialNumber : "<font style='color: red;'><b>Serial Number is Required</b></font>",
																	status : "<font style='color: red;'><b>Status  is Required</b></font>",
																	},

															});
											 if($('#assettypeId').val()!=0 && $('#status').val()!=0){
												if($('#valueForSubData').val()==0)
												{
												document.getElementById("addmessage").style.display = "block";
												$('#addmessage').html("Warning! Please Enter AtLeast One Asset Assignment Line");
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
																	assettypeId : {
																		required : true
																	},
																	assetgroupId : {
																		required : true
																	},
																	model : {
																		required : true
																	},
																	serialNumber : {
																		required : true
																	},
																	status : {
																		required : true
																	},
																	
																	
																},
																messages : {
																	assettypeId : "<font style='color: red;'><b>Asset Type is Required</b></font>",
																	
																	assetgroupId : "<font style='color: red;'><b>Asset Group is Required</b></font>",
																	model : "<font style='color: red;'><b>Model is Required</b></font>",
																	serialNumber : "<font style='color: red;'><b>Serial Number is Required</b></font>",
																	status : "<font style='color: red;'><b>Status  is Required</b></font>",
																	},
															});

										});

					});
</script>

<script type="text/javascript">
function dateFun(datePattern) {
		$('#warranty,#assignedon,#returnedon,#assignedonedit,#returnedonedit').datepicker({
			dateFormat :  datePattern,
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
			$('#warranty').val('');
			$('#assettypeId').val('');
			$('#assetgroupId').val('');
			$('#model').val('');
			$('#serialNumber').val('');
			$('#status').val('');
			$('#successmessage').hide();
			$('#savemessage').hide();
			

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
		<div class="PageTitle">Asset</div>
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
						<form:form action="searchasset.mnt" method="GET" commandName="ASSET">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.asset" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.asset" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${RfqUpdateSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.asset" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${RfqUpdateFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.asset" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${RfqDeleteSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.asset" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${RfqDeleteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.asset" />
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
						<form:form action="assetAdvanceSearch.mnt" method="get"
							commandName="ASSET" name="advanceSearchFinal">
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

					<form:form action="assetAdvanceSearchOperations.mnt"
						commandName="ASSET">
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

					<c:if test="${searchbeans!=null}">
						<div>
							<display:table id="asetid" name="searchbeans"
								requestURI="searchasset.mnt" pagesize="5" class="table">
								<display:column property="assetid" title="ASSETID" media="none"
									sortable="true"></display:column>
								<display:column property="assettypeId" titleKey="label.assetType"
									media="html" sortable="true"></display:column>
								<display:column property="assetgroupId" titleKey="label.assetGroup"
									media="html" sortable="true"></display:column>
								<display:column property="model" titleKey="label.model"
									media="html" sortable="true"></display:column>
								<display:column property="serialNumber"
									titleKey="label.serialNumber" media="html" sortable="true"></display:column>
								<display:column property="status"
									titleKey="label.status" media="html" sortable="true"></display:column>
								<display:column property="weon"
									titleKey="label.weon" media="html" sortable="true"></display:column>
								
								 <display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${true}">
											<a
												href="assetEdit.mnt?assetedit=<c:out value="${asetid.assetid}"/>"
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
												href="assetDelete.mnt?assetdelete=<c:out value="${asetid.assetid}"/>"
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
							
							<td colspan="4" class="alert-warning" id="addmessage"
								style="display: none; width: 450px; height: 25px;"></td>
						
						</tr>
					</table>
					<form:form action="saveAsset.mnt" method="POST" commandName="ASSET"
						id="addagform">

						<!-- <div id="RFQSuccessdup" class="alert-warning" style="display: none; "></div> -->

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">

										<%-- <form:hidden path="rfqhide" /> --%>
										<tr>
											<td><spring:message code="label.assetType" /><span
												class="required">*</span></td>
											<td><form:select path="assettypeId" id="assettypeId"
													class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${assetTypeIds}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.assetGroup" /><span
												class="required">*</span></td>
											<td><form:select path="assetgroupId" id="assetgroupId" class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${assetGroupIds}" />
												</form:select></td>
										</tr>
										<tr>
												<td><spring:message code="label.model" /><span
												class="required">*</span></td>
											<td><form:input path="model" id="model"
													class="textbox" /></td>
										</tr>
										<tr>
												<td><spring:message code="label.serialNumber" /><span
												class="required">*</span></td>
											<td><form:input path="serialNumber" id="serialNumber"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.status" /><span
												class="required">*</span></td>
											<td><form:input path="status" id="status"
													class="textbox" /></td>
													</tr>
													<tr>
													<td><spring:message code="label.weon" /></td>
											<td><form:input path="weon" id="warranty"
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
											code="label.assetassignment" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

								<!-- <div align="center"> -->

								<script>
									var btrfqid = 1;
									$(function() {

										/* var currentText = $(this).find(":selected").text(); */

										var eid = $("#employeeId"), asson = $("#assignedon"), reton = $("#returnedon"), hiddenrfqID = $("#hiddenIdrfqPopUp"),

										allFields = $([]).add(eid).add(asson)
												.add(reton).add(
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
																					eid,
																					"Employee");
																	bValid1 = bValid1
																			&& checkLength1(
																					asson,
																					"Assigned On ");

																	bValid1 = bValid1
																			&& checkLength1(
																					reton,
																					"Returned On"); 

																	

																	if (bValid1) {
																		//alert("hiddenid"+hiddenID.val());

																		if (hiddenrfqID
																				.val() == "0"
																				|| hiddenrfqID
																						.val() == "") {

																			$("#RfqAdd tbody")
																					.append(
																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='employeeId' id='employeeId"
																									+ btrfqid
																									+ "' value="
																									+ eid.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='employeename' id='employeename"
																									+ btrfqid
																									+ "' value='"
																									+ $('#employeeId :selected')
																											.text()
																									+ "'"
																									+ " </td>"
																									+ "<td><input type='text' name='assignedon' id='assignedon"
																									+ btrfqid
																									+ "' value="
																									+ asson
																											.val()
																									+ "  class='textbox'readonly/></td>"

																									+ "<td><input name='returnedon' id='returnedon"
																									+ btrfqid
																									+ "' value="
																									+ reton
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
																					'#employeeId'
																							+ hiddenrfqID
																									.val())
																					.val(
																							eid
																									.val());

																			$(
																					'#employeename'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#employeeId :selected')
																									.text());
																			$(
																					'#assignedon'
																							+ hiddenrfqID
																									.val())
																					.val(
																							asson
																									.val());
																		

																			$(
																					'#returnedon'
																							+ hiddenrfqID
																									.val())
																					.val(
																							reton
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
										$('#employeeId').val($('#employeeId' + id).val());
										$('#assignedon').val($('#assignedon' + id).val());
										$('#returnedon').val($('#returnedon' + id).val());
										$('#hiddenIdrfqPopUp').val(id);

									}
								</script>


								<div id="dialog-form-Rfq" align="center"
									title="<spring:message code="label.assetassignment" />">
									<p class="validateTips" align="center">
										<font color="red"></font>
									</p>
									<table class="tableGeneral" cellspacing=0>

										<tr>
											<td><spring:message code="label.emp" /><span
												class="required">*</span></td>
											<td><form:select path="employeeId" id="employeeId"
													class="select" cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${employeeIds}" />

												</form:select></td>
										</tr>
										<tr>

											<!-- <td><input type="hidden" id="processNumber" class="select" 
													cssStyle="height:25px;" /> -->


										</tr>
										<tr>
											<td><spring:message code="label.assignedon" /><span
												class="required">*</span></td>
											<td><form:input path="assignedon" id="assignedon" class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.returnedon" /><span
												class="required">*</span></td>
											<td><form:input path="returnedon" id="returnedon"
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
												<th><spring:message code="label.emp" /></th>
												<th><spring:message code="label.assignedon" /></th>
												<th><spring:message code="label.returnedon" /></th>
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>

											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<button id="Rfqlineadd" type="button">
										<spring:message code="label.addasset" />
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

					<form:form action="assetUpdate.mnt" method="POST" commandName="ASSET"
						id="editRfqForm">

						<c:if test="${editvalues!=null}">

							<table class="tableGeneral">
								<form:hidden path="assetid" />
								<tr>
											<td><spring:message code="label.assetType" /><span
												class="required">*</span></td>
											<td><form:select path="assettypeId" 
													class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${assetTypeIds}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.assetGroup" /><span
												class="required">*</span></td>
											<td><form:select path="assetgroupId" class="select" >
													<form:option value="">--Select--</form:option>
													<form:options items="${assetGroupIds}" />
												</form:select></td>
										</tr>
										<tr>
												<td><spring:message code="label.model" /><span
												class="required">*</span></td>
											<td><form:input path="model" 
													class="textbox" /></td>
										</tr>
										<tr>
												<td><spring:message code="label.serialNumber" /><span
												class="required">*</span></td>
											<td><form:input path="serialNumber" 
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.status" /><span
												class="required">*</span></td>
											<td><form:input path="status" id="st"
													class="textbox" /></td>
													</tr>
													<tr>
													<td><spring:message code="label.weon" /></td>
											<td><form:input path="weon" id="warranty"
													class="textbox" /></td>
											<td><input type="hidden" name="valueForSubData"
											id="valueForSubData" class="textbox" value="0"/></td>
										</tr>
							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.assetassignment" /></a></li>

								</ul>


								<div align="center">

									<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

									<!-- <div align="center"> -->

									<script>
										var btrfqid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */

											var ematid = $("#employeeIdedit"), eqtid = $("#assignedonedit"), eddate = $("#returnedonedit"), ehiddenrfqID = $("#hiddenIdrfqeditPopUp")

											allFields = $([]).add(ematid).add(
													eqtid).add(eddate).add(ehiddenrfqID),
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

																						"Employee");

																		bValid2 = bValid2
																				&& checkLength(
																						eqtid,
																						"Assigned On is Required ");


																		bValid2 = bValid2
																				&& checkLength(
																						eddate,
																						"Returned on");
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
																										+ "<td ><input type='hidden' name='employeeIdedit' id='employeeIdedit"
																										+ btrfqid
																										+ "' value="
																										+ ematid
																												.val()
																										+ " class='textbox'readonly/>  "
																										+ "<input type='text' readonly class='textbox' name='employeenameedit' id='employeenameedit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#employeeIdedit :selected')
																												.text()
																										+ "'"
																										+ "</td>"
																										+ "<td><input type='text' name='assignedonedit' id='assignedonedit"
																										+ btrfqid
																										+ "' value="
																										+ eqtid
																												.val()
																										+ "  class='textbox'readonly/></td>"

																										+ "<td><input name='returnedonedit' id='returnedonedit"
																										+ btrfqid
																										+ "' value="
																										+ eddate
																												.val()
																										+ " class='textbox'readonly/><input type='hidden' name='assetasgmntIdedit' value='0' id='assetasgmntIdedit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
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
																						'#employeeIdedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								ematid
																										.val());
																				$(
																						'#employeenameedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#employeeIdedit :selected')
																										.text());
																				$(
																						'#assignedonedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eqtid
																										.val());
																				

																				$(
																						'#returnedonedit'
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
											//alert("edit row " + id);

											$("#dialog-form-RfqEdit").dialog(
													"open");

											$('#employeeIdedit').val(
													$('#employeeIdedit' + id)
															.val());
											$('#assignedonedit').val(
													$('#assignedonedit' + id).val());
											$('#returnedonedit').val(
													$('#returnedonedit' + id).val());

											$('#hiddenIdrfqeditPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-RfqEdit" align="center"
										title="<spring:message code="label.addasset" />">
										<p class="validateTips" align="center">
											<font color="red"></font>
										</p>
										<table class="tableGeneral" cellspacing=0>
											<form:hidden path="assetasgmntIdedit" value="0" />
											<tr>
											<td><spring:message code="label.employeeId" /><span
												class="required">*</span></td>
											<td><form:select path="employeeIdedit" id="employeeIdedit"
													class="select" cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${employeeIds}" />

												</form:select></td>
										</tr>
										<tr>

											<!-- <td><input type="hidden" id="processNumber" class="select" 
													cssStyle="height:25px;" /> -->


										</tr>
										<tr>
											<td><spring:message code="label.assignedon" /><span
												class="required">*</span></td>
											<td><form:input path="assignedonedit" id="assignedonedit"  cssClass="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.returnedon" /><span
												class="required">*</span></td>
											<td><form:input path="returnedonedit" id="returnedonedit"
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

													<th><spring:message code="label.emp" /></th>
													<th><spring:message code="label.assignedon" /></th>
													<th><spring:message code="label.returnedon" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>


											</thead>
											<tbody>
												<c:forEach items="${assetlinelistdetails}" var="assetlinelistdetails">



													<td><spring:bind path="ASSET.assetasgmntIdedit">
															<input type="hidden" name="assetasgmntIdedit"
																id="agreementlineidedit${assetlinelistdetails.assetasgmntIdedit}"
																value="${assetlinelistdetails.assetasgmntIdedit}" />
														</spring:bind></td>


													<tr id="${assetlinelistdetails.assetasgmntIdedit}">
														<td><spring:bind path="ASSET.employeeIdedit">
																<input type="hidden" name="employeeIdedit"
																	class="textbox"
																	id="employeeIdedit${assetlinelistdetails.assetasgmntIdedit}"
																	value="${assetlinelistdetails.employeeIdedit}" />
															</spring:bind> <spring:bind path="ASSET.employeenameedit">
																<input type="text" name="employeenameedit" class="textbox"
																	id="employeenameedit${assetlinelistdetails.assetasgmntIdedit}"
																	value="${assetlinelistdetails.employeenameedit}" readonly />
															</spring:bind></td>

														<td><spring:bind path="ASSET.assignedonedit">
																<input type="text" name="assignedonedit"
																	id="assignedonedit${assetlinelistdetails.assetasgmntIdedit}"
																	class="textbox" value="${assetlinelistdetails.assignedonedit}"
																	readonly />
															</spring:bind></td>
														<td><spring:bind path="ASSET.returnedonedit">
																<input type="text" name="returnedonedit"
																	id="returnedonedit${assetlinelistdetails.assetasgmntIdedit}"
																	class="textbox"
																	value="${assetlinelistdetails.assignedonedit}" readonly />
															</spring:bind> <input type="hidden"
															name="Checkdelete${assetlinelistdetails.assetasgmntIdedit}"
															id="${assetlinelistdetails.assetasgmntIdedit}Checkdelete" value="0" /></td>


														<td><a href='#' id="${assetlinelistdetails.assetasgmntIdedit}"
															onclick="editRfqEdit(this.id)"><strong><img
																	src='images/Edit.jpg' height='25px' width='25px' /></strong></a></td>
														<td><a href='#' id="${assetlinelistdetails.assetasgmntIdedit}"
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
																	'#employeeIdedit'
																			+ link.id)
																	.val(
																			$(
																					'#employeeIdedit')
																					.val());
															$('#assignedonedit').val($('#assignedonedit'
																							+ link.id)
																					.val());
															$('#returnedonedit')
																	.val(
																			$(
																					'#returnedonedit'
																							+ link.id)
																					.val());
															

															$('#hiddenIdrfqeditPopUp')
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
