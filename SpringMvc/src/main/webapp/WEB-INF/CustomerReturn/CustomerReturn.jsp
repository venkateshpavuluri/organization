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
						$('#sumbtnid')
								.click(
										function(event) {

											$('#crAddForm')
													.validate(
															{
																rules : {
																	customerReturnNo : {
																		required : true
																	},
																	customerReturnDate : {
																		required : true
																	},
																	reference : {
																		required : true
																	},

																	description : {
																		required : true
																	},
																	salesOrderId : {
																		required : true
																	}

																},
																messages : {
																	customerReturnNo : "<font style='color: red;'><b>Customer Return Number is Required</b></font>",
																	customerReturnDate : "<font style='color: red;'><b>Customer Return Date is Required</b></font>",
																	reference : "<font style='color: red;'><b>Reference is Required</b></font>",
																	description : "<font style='color: red;'><b>Description is Required</b></font>",
																	salesOrderId : "<font style='color: red;'><b>Sales Order is Required</b></font>"

																},

															});
										});

						$('#updateid')
								.click(
										function(event) {
											//alert("hai");
											$("#formEdit")
													.validate(
															{
																rules : {
																	customerReturnNoEdit : {
																		required : true
																	},
																	customerReturnDateEdit : {
																		required : true
																	},
																	referenceEdit : {
																		required : true
																	},
																	descriptionEdit : {
																		required : true
																	},
																	salesOrderIdEdit : {
																		required : true
																	}

																},
																messages : {
																	customerReturnNoEdit : "<font style='color: red;'><b>Customer Return Number is Required</b></font>",
																	customerReturnDateEdit : "<font style='color: red;'><b>Customer Return Date is Required</b></font>",
																	referenceEdit : "<font style='color: red;'><b>Reference is Required</b></font>",
																	descriptionEdit : "<font style='color: red;'><b>Description is Required</b></font>",
																	salesOrderIdEdit : "<font style='color: red;'><b>Sales Order is Required</b></font>"

																},

															});
										});
					});
</script>



<script type="text/javascript">
	function callajax() {

		//get the form values

		var mid = $('#materialids').val();
		var salesorderid = $("#salesOrderId").val();

		$.ajax({

			type : "POST",

			url : "GetQuantity.mnt",

			data : "mid=" + mid + "&salesorderid=" + salesorderid,

			success : function(response) {
				$("#salesquantity").val(response);
			},

			error : function(e) {

				//alert('Error: ' + e);

			}

		});

	}
</script>
<script type="text/javascript">
	function callajaxedit() {

		//get the form values

		var midedit = $('#materialidsEdit').val();
		var salesorderidedit = $("#salesOrderIdEdit").val();
		var crid = $("#customerReturnIdEdit").val();

		$.ajax({

			type : "POST",

			url : "GetQuantityEdit.mnt",

			data : "midedit=" + midedit + "&salesorderidedit="
					+ salesorderidedit + "&crid=" + crid,

			success : function(response) {
				$("#salesquantityEdit").val(response);
			},

			error : function(e) {

				//alert('Error: ' + e);

			}

		});

	}
</script>

<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 95%;
}

<!--
Horizantol scroll -->#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 95%;
}

.required {
	color: red;
	font-style: Bold;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>
<script>
	$(function() {
		$("#tabs").tabs();
	});

	$(function() {
		$("#tabsForAdd").tabs();
	});
	$(function() {
		$("#tabsForEdit").tabs();
	});

	function dateFun(datePattern) {
		$('#customerReturnDate,#customerReturnDateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
			
		});
	}
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

</head>

<body>

	<div class="divUserDefault">
		<div class="PageTitle">Customer Return</div>

		<!-- Tabs Declaration -->
		<div>
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="customerReturnEditList"
						items="${customerReturnEditList}">
						<c:set var="customerReturnEditList"
							value="${customerReturnEditList }"></c:set>
					</c:forEach>
					<c:if test="${customerReturnEditList!=null}">
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
						<table class="tableGeneral">
							<form:form action="CustomerReturnSearch.mnt" method="GET"
								commandName="CustomerReturnCommand">

								<tr>
									<td colspan="2"><c:forEach var="customerReturnAdd"
											items="${param.list}">
											<div class="alert-success" id="savemessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.customerReturn" />
												<spring:message code="label.saveSuccess"></spring:message>
											</div>
										</c:forEach> <c:if test="${param.listwar!=null }">
											<div class="alert-danger" id="savemessage">
												<strong><spring:message code="label.error" /> </strong>

												<spring:message code="label.customerReturn" />
												<spring:message code="label.saveFail" />
											</div>
										</c:if> <c:forEach var="customerRetUpdate"
											items="${customerRetUpdate}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.customerReturn" />
												<spring:message code="label.updateSuccess"></spring:message>
											</div>
										</c:forEach> <c:forEach var="customerRetUpdateError"
											items="${customerRetUpdateError}">
											<div class="alert-danger" id="successmessage">
												<strong><spring:message code="label.error" /></strong>
												<spring:message code="label.customerReturn" />
												<spring:message code="label.updateFail"></spring:message>
											</div>
										</c:forEach>
										<c:forEach var="customerReturnDelete"
											items="${customerReturnDelete}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /></strong>
												<spring:message code="label.customerReturn" />
												<spring:message code="label.deleteSuccess"></spring:message>
											</div>
										</c:forEach>
										<c:forEach var="customerReturnDeleteError"
											items="${customerReturnDeleteError}">
											<div class="alert-danger" id="successmessage">
												<strong><spring:message code="label.error" /></strong>
												<spring:message code="label.customerReturn" />
												<spring:message code="label.deleteFail"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<tr id="mainSearch">
									<td><spring:message code="label.searchby" /> <form:select
											path="xmlLabel" cssClass="select">

											<form:options items="${xmlItems}" />
										</form:select> <spring:bind path="CustomerReturnCommand.operations">
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
												<input type="submit" value="Search" class="btn btn-primary" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<spring:message code="label.search"/>"
													class="btn btn-danger" />
											</c:otherwise>
										</c:choose></td>
								</tr>


							</form:form>
							<form:form action="CustomerReturnAdvanceSearch.mnt" method="get"
								commandName="CustomerReturnCommand" name="advanceSearchFinal">
								<tr>
									<td><a href="javascript: void(0);" id="advanceSearch"
										onclick="document.advanceSearchFinal.submit();return false;"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>
								</tr>
							</form:form>


						</table>




						<form:form action="CustomerReturnAdvanceSearchOperations.mnt"
							commandName="CustomerReturnCommand">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue"
										items="${customerReturnSearchAdvance}">
										<tr>
											<td><label>${xmlLabelValue.secondLabel}</label>
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
													id="advanceSearch" cssClass="textbox"/></td>
										</tr>

									</c:forEach>
									<tr>
										<form:hidden path="advanceSearchHidden"
											id="advanceSearchHidden" />
										<td colspan="3"><input type="submit"
											id="advanceSearchButtonId" value="Advance Search"
											style="display: none" class="btn btn-primary" /></td>
									</tr>

								</table>

							</div>

						</form:form>
						<!-- Displaying  the Searched information by using display tag -->


						<c:forEach var="cr" items="${crvalues}">
							<c:set var="as" value="${cr}"></c:set>
						</c:forEach>
						<c:if test="${as!=null }">
							<display:table id="customerReturn" name="customerReturn"
								requestURI="CustomerReturnSearch.mnt" pagesize="4" class="table">
								<%-- <display:column property="customerReturnId" title="customerReturnId" media="html" sortable="true" ></display:column> --%>
								<display:column property="customerReturnNo"
									titleKey="label.CustomerReturnNo" media="html" sortable="true"></display:column>
								<display:column property="customerReturnDate"
									titleKey="label.CustomerReturnDate" media="html"
									sortable="true"></display:column>
								<display:column property="reference" titleKey="label.Reference"
									media="html" sortable="true"></display:column>
								<display:column property="description"
									titleKey="label.Description" media="html" sortable="true" />


								<display:column titleKey="label.edit">
									<c:choose>
										<c:when test="${edit }">
											<a
												href="customerReturnEditHome.mnt?customerReturnId=<c:out value="${customerReturn.customerReturnId}"/>"
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
										<c:when test="${delete }">
											<a
												href="customerReturnDelete.mnt?customerReturnId=<c:out value="${customerReturn.customerReturnId}"/>"
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

								<!-- For displaying the pagination part -->

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
						<table>
							<tr>
								<td colspan="4" class="alert-warning" id="addmessage"
									style="display: none; width: 450px; height: 25px;"></td>
							</tr>
						</table>
						<form:form action="CustomerReturnAdd.mnt" method="POST"
							commandName="CustomerReturnCommand" id="crAddForm">
							<table class="tableGeneral">
								<form:hidden path="aid" />
								<tr>
									<td colspan="2"><c:forEach
											var="addCustomerReturnDuplicate"
											items="${addCustomerReturnDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning" /></strong>
												<spring:message code="label.customerReturn" />
												<spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td><spring:message code="label.CustomerReturnNo" /><font
										color="red">*</font></td>
									<td><form:input path="customerReturnNo"
											id="customerReturnNo" class="textbox" onkeyup="doAjaxPost()"
											maxlength="50" /></td>
									<!-- <td id="addmessage" class="alert-warning"></td>
									<td><font color="red"></font></td> -->
								</tr>
								<tr>
									<td><spring:message code="label.CustomerReturnDate" /><font
										color="red">*</font></td>
									<td><form:input path="customerReturnDate"
											id="customerReturnDate" name="customerReturnDate"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.Reference" /><font
										color="red">*</font></td>
									<td><form:input path="reference" id="reference"
											name="reference" class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.Description" /><font
										color="red">*</font></td>
									<td><form:input path="description" id="description"
											name="description" class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.SalesOrder" /><font
										color="red">*</font></td>
									<td><form:select path="salesOrderId" id="salesOrderId"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${salesOrder }" />
										</form:select></td>
								</tr>



							</table>

							<div id="tabsForAdd">
								<!-- PurchaseReq Line tab -->
								<ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.customerReturnLine" /> </a></li>

								</ul>
								<div id="scroll">
									<div align="center">


										<script>
											var qltrid = 1;
											$(function() {
												var material_Id = $("#materialids"), mvalue = $("#mNumber"), qty = $("#qty"), uom = $("#uoms"), qtyuom = $("#qtyuoms"), price = $("#price"), salesquantity = $("#salesquantity"), reasonForRejection = $("#reasonForRejection"), reasonForRejectionvalue = $("#reasonForRejectionNumber"), storageLocation = $("#storageLocation"), storageLocationvalue = $("#storageLocationNumber"), hiddenID = $("#hiddenIdCustomerReturnPopUp"), allFields = $(
														[])
														.add(material_Id)
														.add(mvalue)
														.add(qty)
														.add(uom)
														.add(qtyuom)
														.add(price)
														.add(reasonForRejection)
														.add(
																reasonForRejectionvalue)
														.add(storageLocation)
														.add(
																storageLocationvalue)
														.add(hiddenID), tips = $(".validateTips");
												/* alert("hear "+material_Id.val()); */

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
												function quanty(o, k, n) {
													var qty = parseFloat(o
															.val());
													var sqty = parseFloat(k
															.val());
													if (qty != 0) {
														if (qty <= sqty) {
															return true;
														} else {
															o
																	.addClass("ui-state-error");
															updateTips(""
																	+ n
																	+ " Should be less than or equal to Rejected Qty ");
															return false;
														}
													} else {
														o
																.addClass("ui-state-error");
														updateTips(""
																+ n
																+ " Should be Greater than Zero");
														return false;
													}
												}

												$(
														"#dialog-form-CustomerReturnLine")
														.dialog(
																{
																	autoOpen : false,
																	height : 280,
																	width : 335,
																	modal : true,
																	buttons : {
																		Submit : function() {
																			var bValid = true;
																			allFields
																					.removeClass("ui-state-error");
																			bValid = bValid
																					&& selectLength(
																							material_Id,
																							"Material");

																			bValid = bValid
																					&& checkLength(
																							qty,
																							"Quantity",
																							1,
																							16);
																			bValid = bValid
																					&& quanty(
																							qty,
																							salesquantity,
																							" Quantity");

																			bValid = bValid
																					&& selectLength(
																							uom,
																							"UOM");

																			bValid = bValid
																					&& checkLength(
																							price,
																							"Price",
																							1,
																							16);

																			bValid = bValid
																					&& selectLength(
																							reasonForRejection,
																							"Reason For Rejection");
																			bValid = bValid
																					&& selectLength(
																							storageLocation,
																							"Storage Location");

																			if (bValid) {
																				//alert("hiddenid"+hiddenID.val());
																				if (hiddenID
																						.val() == "0"
																						|| hiddenID
																								.val() == "") {

																					$(
																							"#customerReturnLineAdd tbody")
																							.append(

																									"<tr id="+qltrid+">"
																											+ "<td ><spring:bind path='CustomerReturnCommand.materialids'><input type='hidden' name='materialids' id='materialids"
																											+ qltrid
																											+ "' value="
																											+ material_Id
																													.val()
																											+ " class='textbox'/></spring:bind> <input type='text' name='mNumber' id='mNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#materialids :selected')
																													.text()

																											+ " class='textbox'readonly/></td>"
																											+ "<td><input name='qty' id='qty"
																											+ qltrid
																											+ "' value="
																											+ qty
																													.val()
																											+ " class='textbox'/></td>"
																											+ "<td><input type='hidden' name='uoms' id='uoms"
																											+ qltrid
																											+ "' value="
																											+ uom
																													.val()
																											+ " class='textbox'/><input type='text' name='qtyuoms' id='qtyuoms"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#uoms :selected')
																													.text()

																											+ " class='textbox'readonly/></td>"

																											+ "<td><input name='price' id='price"
																											+ qltrid
																											+ "' value="
																											+ price
																													.val()
																											+ " class='textbox'/></td>"
																											+ "<td><input type='hidden' name='reasonForRejection' id='reasonForRejection"
																											+ qltrid
																											+ "' value="
																											+ reasonForRejection
																													.val()
																											+ " class='textbox'/><input type='text' name='reasonForRejectionNumber' id='reasonForRejectionNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#reasonForRejection :selected')
																													.text()

																											+ " class='textbox'readonly/></td>"
																											+ "<td><input type='hidden' name='storageLocation' id='storageLocation"
																											+ qltrid
																											+ "' value="
																											+ storageLocation
																													.val()
																											+ " class='textbox'/><input type='text' name='storageLocationNumber' id='storageLocationNumber"
																											+ qltrid
																											+ "' value="
																											+ $(
																													'#storageLocation :selected')
																													.text()

																											+ " class='textbox'readonly/></td>"

																											+ "<td><a href='#'  onclick='editMaterialm("
																											+ qltrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeMaterialm("
																											+ qltrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");

																					qltrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																				if (hiddenID
																						.val() != "0") {
																					$(
																							'#materialids'
																									+ hiddenID
																											.val())
																							.val(
																									material_Id
																											.val());
																					$(
																							'#mNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#materialids :selected')
																											.text());

																					$(
																							'#qty'
																									+ hiddenID
																											.val())
																							.val(
																									qty
																											.val());
																					$(
																							'#uoms'
																									+ hiddenID
																											.val())
																							.val(
																									uom
																											.val());
																					$(
																							'#qtyuoms'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#uoms :selected')
																											.text());
																					$(
																							'#price'
																									+ hiddenID
																											.val())
																							.val(
																									price
																											.val());

																					$(
																							'#reasonForRejection'
																									+ hiddenID
																											.val())
																							.val(
																									reasonForRejection
																											.val());
																					$(
																							'#reasonForRejectionNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#reasonForRejection :selected')
																											.text());
																					$(
																							'#storageLocation'
																									+ hiddenID
																											.val())
																							.val(
																									storageLocation
																											.val());
																					$(
																							'#storageLocationNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#storageLocation :selected')
																											.text());

																					$(
																							'#hiddenIdCustomerReturnPopUp')
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
														"#create-AddCustomerReturnLine")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-CustomerReturnLine")
																			.dialog(
																					"open");
																	//alert("opened");
																});
											});
											function removeMaterialm(id) {
												alert("removing row " + id);
												$('#' + id).remove();
											}
											function editMaterialm(id) {

												//alert("edit row " + id);
												//$('#'+id).remove();

												$(
														"#dialog-form-CustomerReturnLine")
														.dialog("open");

												$('#materialids').val(
														$('#materialids' + id)
																.val());
												$('#mNumber').val(
														$('#mNumber' + id)
																.val());
												$('#qty').val(
														$('#qty' + id).val());
												$('#uoms').val(
														$('#uoms' + id).val());
												$('#qtyuoms').val(
														$('#qtyuoms' + id)
																.val());
												$('#price').val(
														$('#price' + id).val());

												$('#reasonForRejection').val(
														$(
																'#reasonForRejection'
																		+ id)
																.val());
												$('#reasonForRejectionNumber')
														.val(
																$(
																		'#reasonForRejectionNumber'
																				+ id)
																		.val());

												$('#storageLocation').val(
														$(
																'#storageLocation'
																		+ id)
																.val());
												$('#storageLocationNumber')
														.val(
																$(
																		'#storageLocationNumber'
																				+ id)
																		.val());

												$(
														'#hiddenIdCustomerReturnPopUp')
														.val(id);
												// document.getElementById("").value="edit";
											}
										</script>


										<div id="dialog-form-CustomerReturnLine"
											title="Add New Customer Return line Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

												<tr>
													<td><spring:message code="label.prmaterial" /><font
														color="red">*</font></td>
													<td><form:select path="materialids" class="select"
															id="materialids" onchange="callajax()"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
												</tr>
												<tr>
													<td>Available Quantity<font color="red">*</font></td>
													<td><form:input path="salesquantity"
															id="salesquantity" class="textbox" readonly="true" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.prqty" /><font
														color="red">*</font></td>
													<td><form:input path="qty" id="qty" class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.quom" /><font
														color="red">*</font></td>
													<td><form:select path="uoms" id="uoms" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
												</tr>



												<tr>
													<td><spring:message code="label.price" /><font
														color="red">*</font></td>
													<td><form:input path="price" id="price"
															class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.ReasonForRejection" /><font
														color="red">*</font></td>
													<td><form:select path="reasonForRejection"
															id="reasonForRejection" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${reasonForRejectionId}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.storloc" /><font
														color="red">*</font></td>
													<td><form:select path="storageLocation"
															id="storageLocation" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${storageId }" />
														</form:select><input type="hidden" name="hiddenIdCustomerReturnPopUp"
														id="hiddenIdCustomerReturnPopUp" value="0" /></td>
												</tr>
											</table>
										</div>



										<div id="users-contain-customerReturnLine">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="customerReturnLineAdd" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.material" /></th>
														<th><spring:message code="label.qty" /></th>
														<th><spring:message code="label.uom" /></th>
														<th><spring:message code="label.price" /></th>
														<th><spring:message code="label.ReasonForRejection" /></th>
														<th><spring:message code="label.StorageLocation" /></th>

													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
										<button id="create-AddCustomerReturnLine" type="button">Add
											New Customer Return Line</button>


									</div>
								</div>
							</div>
							<form:hidden path="aid" />
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

				<div id="tabs-1">
					<div align="left" class="TabbedPanelsContent">
						<%-- 	<c:forEach var="customerReturnEditList"
							items="${customerReturnEditList}">
							<c:set var="edit" value="${customerReturnEditList}"></c:set>
						</c:forEach> --%>
						<c:if test="${customerReturnEditList!=null}">


							<table>
								<tr>
									<td colspan="4" class="alert-warning" id="editmessage"
										style="display: none; width: 450px; height: 25px;"></td>
								</tr>
							</table>
							<form:form action="customerReturnUpdate1.mnt" method="POST"
								commandName="CustomerReturnCommand" id="formEdit">

								<table class="tableGeneral">

									<tr>
										<td colspan="2"><c:forEach
												var="addCustomerReturnEditDuplicate"
												items="${addCustomerReturnEditDuplicate}">
												<div class="alert-warning" id="savemessage">
													<strong><spring:message code="label.warning" /></strong>
													<spring:message code="label.customerReturn" />
													<spring:message code="label.duplicateCheck"></spring:message>
												</div>
											</c:forEach></td>
									</tr>


									<form:hidden path="customerReturnIdEdit"
										id="customerReturnIdEdit" />

									<tr>
										<td><spring:message code="label.CustomerReturnNo" /><font
											color="red">*</font></td>
										<td><form:input path="customerReturnNoEdit"
												id="customerReturnNoEdit" class="textbox" maxlength="50" /></td>

									</tr>
									<tr>
										<td><spring:message code="label.CustomerReturnDate" /><font
											color="red">*</font></td>
										<td><form:input path="customerReturnDateEdit"
												id="customerReturnDateEdit" name="customerReturnDateEdit"
												class="textbox" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.Reference" /><font
											color="red">*</font></td>
										<td><form:input path="referenceEdit" id="referenceEdit"
												name="referenceEdit" class="textbox" maxlength="50" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.Description" /><font
											color="red">*</font></td>
										<td><form:input path="descriptionEdit"
												id="descriptionEdit" name="descriptionEdit" class="textbox" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.SalesOrder" /><font
											color="red">*</font></td>
										<td><form:select path="salesOrderIdEdit"
												id="salesOrderIdEdit" class="select" cssStyle="height:25px">
												<form:option value="">---Select---</form:option>
												<form:options items="${salesOrder }" />
											</form:select></td>
									</tr>

								</table>


								<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
										<ul>

											<li><a href="#tab1"><spring:message
														code="label.customerReturnLine" /></a></li>

										</ul>

										<!--Sub Tab-1 -->
										<div id="tab1">
											<div align="center">
												<script>
													var btrid = 1;
													$(function() {
														var materialidsEdit = $("#materialidsEdit"), qtyEdit = $("#qtyEdit"), uomsEdit = $("#uomsEdit"), priceEdit = $("#priceEdit"), salesquantityEdit = $("#salesquantityEdit"), reasonForRejectionEdit = $("#reasonForRejectionEdit"), storageLocationEdit = $("#storageLocationEdit"), hiddenEdit = $("#hiddenIdCustomerReturnPopUpEdit"),

														allFields = $([])
																.add(
																		materialidsEdit)
																.add(qtyEdit)
																.add(uomsEdit)
																.add(priceEdit)
																.add(
																		reasonForRejectionEdit)
																.add(
																		storageLocationEdit)
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

														function checkLength(o,
																n, min, max) {
															if (o.val().length > max
																	|| o.val().length < min) {
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
														function quantyedit(o,
																k, n) {
															var qty = parseFloat(o
																	.val());
															var sqty = parseFloat(k
																	.val());
															if (qty != 0) {
																if (qty <= sqty) {
																	return true;
																} else {
																	o
																			.addClass("ui-state-error");
																	updateTips(""
																			+ n
																			+ " Should be less than or equal to Rejected Qty ");
																	return false;
																}
															} else {
																o
																		.addClass("ui-state-error");
																updateTips(""
																		+ n
																		+ " Should be Greater than Zero");
																return false;
															}
														}

														$(
																"#dialog-form-CustomerReturnEdit")
																.dialog(
																		{
																			autoOpen : false,
																			height : 310,
																			width : 350,
																			modal : true,
																			buttons : {
																				"Submit" : function() {
																					var bValid1 = true;
																					allFields
																							.removeClass("ui-state-error");

																					bValid1 = bValid1
																							&& selectLength(
																									materialidsEdit,
																									"Material");

																					bValid1 = bValid1
																							&& checkLength(
																									qtyEdit,
																									"Quantity",
																									1,
																									16);
																					bValid1 = bValid1
																							&& quantyedit(
																									qtyEdit,
																									salesquantityEdit,
																									"Quantity");
																					bValid1 = bValid1
																							&& selectLength(
																									uomsEdit,
																									"UOM");

																					bValid1 = bValid1
																							&& checkLength(
																									priceEdit,
																									"Price",
																									1,
																									16);
																					bValid1 = bValid1
																							&& selectLength(
																									reasonForRejectionEdit,
																									"Status");

																					bValid1 = bValid1
																							&& selectLength(
																									storageLocationEdit,
																									"Storage Location");

																					if (bValid1) {

																						if (hiddenEdit
																								.val() == "0"
																								|| hiddenEdit
																										.val() == "") {

																							$(
																									"#AddCustomerReturnEdit tbody")
																									.append(
																											"<tr id="+btrid+">"
																													+ "<td><spring:bind path='CustomerReturnCommand.customerReturnLineIdEdit'><input type='hidden' name='customerReturnLineIdEdit' id='customerReturnLineIdEdit"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																													+ "<spring:bind path='CustomerReturnCommand.materialidsEdit'><input type='hidden' name='materialidsEdit' id='materialidsEdit"
																													+ btrid
																													+ "' value="
																													+ materialidsEdit
																															.val()
																													+ " class='textbox' readonly/></spring:bind>"
																													+ "<spring:bind path='CustomerReturnCommand.materiaName'><input type='text' name='materiaName' id='materiaName"
																													+ btrid
																													+ "' value="
																													+ $(
																															'#materialidsEdit :selected')
																															.text()
																													+ " class='textbox' readonly/></spring:bind></td>"

																													+ "<td><spring:bind path='CustomerReturnCommand.qtyEdit'><input name='qtyEdit' id='qtyEdit"
																													+ btrid
																													+ "' value="
																													+ qtyEdit
																															.val()
																													+ " class='textbox' readonly/></spring:bind> </td>"
																													+ "<td><spring:bind path='CustomerReturnCommand.uomsEdit'><input type='hidden' name='uomsEdit' id='uomsEdit"
																													+ btrid
																													+ "' value="
																													+ uomsEdit
																															.val()
																													+ " class='textbox' readonly/></spring:bind>"
																													+ "<spring:bind path='CustomerReturnCommand.uomName'><input type='text' name='uomName' id='uomName"
																													+ btrid
																													+ "' value="
																													+ $(
																															'#uomsEdit :selected')
																															.text()
																													+ " class='textbox' readonly/></spring:bind></td>"
																													+ "<td><spring:bind path='CustomerReturnCommand.priceEdit'><input name='priceEdit' id='priceEdit"
																													+ btrid
																													+ "' value="
																													+ priceEdit
																															.val()
																													+ " class='textbox' readonly/></spring:bind></td>"
																													+ "<td><spring:bind path='CustomerReturnCommand.reasonForRejectionEdit'><input type='hidden' name='reasonForRejectionEdit' id='reasonForRejectionEdit"
																													+ btrid
																													+ "' value="
																													+ reasonForRejectionEdit
																															.val()
																													+ " class='textbox' readonly/></spring:bind>"
																													+ "<spring:bind path='CustomerReturnCommand.reasonForRejectionName'><input type='text' name='reasonForRejectionName' id='reasonForRejectionName"
																													+ btrid
																													+ "' value="
																													+ $(
																															'#reasonForRejectionEdit :selected')
																															.text()
																													+ " class='textbox' readonly/></spring:bind></td>"

																													+ "<td><spring:bind path='CustomerReturnCommand.storageLocationEdit'><input type='hidden' name='storageLocationEdit' id='storageLocationEdit"
																													+ btrid
																													+ "' value="
																													+ storageLocationEdit
																															.val()
																													+ " class='textbox' readonly/></spring:bind>"
																													+ "<spring:bind path='CustomerReturnCommand.storageLocName'><input type='text' name='storageLocName' id='storageLocName"
																													+ btrid
																													+ "' value="
																													+ $(
																															'#storageLocationEdit :selected')
																															.text()
																													+ " class='textbox' readonly/></spring:bind>"
																													+ "<spring:bind path='CustomerReturnCommand.customerReturnLineIdEdit'><input type='hidden' name='customerReturnLineIdEdit' id='customerReturnLineIdEdit' value='0'/></spring:bind><input type='hidden' name='Check' id='Check' value='0' /></td>"
																													+
																													// "<td>" + password.val() + "</td>" +
																													"<td><a href='#'  onclick='editCustomerReturnDetailsInEditNew("
																													+ btrid
																													+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																													+ "<td><a href='#'  onclick='removeCustomerReturnDetailsEditNew'("
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
																								'#materialidsEdit'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#materialidsEdit')
																												.val());
																						$(
																								'#materiaName'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#materialidsEdit :selected')
																												.text());
																						$(
																								'#qtyEdit'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#qtyEdit')
																												.val());
																						$(
																								'#uomsEdit'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#uomsEdit')
																												.val());
																						$(
																								'#uomName'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#uomsEdit :selected')
																												.text());
																						$(
																								'#priceEdit'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#priceEdit')
																												.val());
																						$(
																								'#reasonForRejectionEdit'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#reasonForRejectionEdit')
																												.val());
																						$(
																								'#reasonForRejectionName'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#reasonForRejectionEdit :selected')
																												.text());

																						$(
																								'#storageLocationEdit'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#storageLocationEdit')
																												.val());
																						$(
																								'#storageLocName'
																										+ hiddenEdit
																												.val())
																								.val(
																										$(
																												'#storageLocationEdit :selected')
																												.text());
																						$(
																								'#hiddenIdCustomerReturnPopUpEdit')
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

														$(
																"#create-AddCustomerReturnEdit")
																.button()
																.click(
																		function() {
																			$(
																					"#dialog-form-CustomerReturnEdit")
																					.dialog(
																							"open");

																		});
													});
													function removeCustomerReturnDetailsEditNew(
															id) {
														//alert("removing row " + id);
														$('#' + id).remove();
													}
													function editCustomerReturnDetailsInEditNew(
															link) {
														//alert(link.id);
														//alert("hello");
														$(
																"#dialog-form-CustomerReturnEdit")
																.dialog("open");
														$('#materialidsEdit')
																.val(
																		$(
																				'#materialidsEdit'
																						+ link)
																				.val());
														$('#qtyEdit')
																.val(
																		$(
																				'#qtyEdit'
																						+ link)
																				.val());
														$('#uomsEdit')
																.val(
																		$(
																				'#uomsEdit'
																						+ link)
																				.val());
														$('#priceEdit')
																.val(
																		$(
																				'#priceEdit'
																						+ link)
																				.val());
														$(
																'#reasonForRejectionEdit')
																.val(
																		$(
																				'#reasonForRejectionEdit'
																						+ link)
																				.val());

														$(
																'#storageLocationEdit')
																.val(
																		$(
																				'#storageLocationEdit'
																						+ link)
																				.val());

														$(
																'#hiddenIdCustomerReturnPopUpEdit')
																.val(link);

													}
												</script>


												<div id="dialog-form-CustomerReturnEdit"
													title="Add New Customer Return Line Details">
													<p class="validateTips">All form fields are required.</p>
													<table class="tableGeneral">

														<tr>
															<td><spring:message code="label.material" /><font
																color="red">*</font></td>
															<td><form:select path="materialidsEdit"
																	class="select" id="materialidsEdit"
																	onchange="callajaxedit()" cssStyle="height:25px">
																	<form:option value="0">-Select-</form:option>
																	<form:options items="${material }" />
																</form:select></td>
														</tr>
														<tr>
															<td>Available Quantity<font color="red">*</font></td>
															<td><form:input path="salesquantityEdit"
																	id="salesquantityEdit" class="textbox" readonly="true" /></td>
														</tr>
														<tr>
															<td><spring:message code="label.qty" /><font
																color="red">*</font></td>
															<td><form:input path="qtyEdit" id="qtyEdit"
																	class="textbox" /></td>
														</tr>

														<tr>
															<td><spring:message code="label.uom" /><font
																color="red">*</font></td>
															<td><form:select path="uomsEdit" id="uomsEdit"
																	class="select" cssStyle="height:25px">
																	<form:option value="0">-Select-</form:option>
																	<form:options items="${uom }" />
																</form:select></td>
														</tr>



														<tr>
															<td><spring:message code="label.price" /><font
																color="red">*</font></td>
															<td><form:input path="priceEdit" id="priceEdit"
																	class="textbox" /></td>
														</tr>

														<tr>
															<td><spring:message code="label.ReasonForRejection" /><font
																color="red">*</font></td>
															<td><form:select path="reasonForRejectionEdit"
																	id="reasonForRejectionEdit" class="select"
																	cssStyle="height:25px">
																	<form:option value="0">-Select-</form:option>
																	<form:options items="${reasonForRejectionId }" />
																</form:select></td>
														</tr>

														<tr>
															<td><spring:message code="label.StorageLocation" /><font
																color="red">*</font></td>
															<td><form:select path="storageLocationEdit"
																	id="storageLocationEdit" class="select"
																	cssStyle="height:25px">
																	<form:option value="0">-Select-</form:option>
																	<form:options items="${storageId }" />
																</form:select><input type="hidden"
																name="hiddenIdCustomerReturnPopUpEdit"
																id="hiddenIdCustomerReturnPopUpEdit" value="0" /></td>
														</tr>
													</table>
												</div>

												<div id="users-contain-CustomerReturnEdit">
													<!-- class="ui-widget" -->
													<h3></h3>
													<table id="AddCustomerReturnEdit" class="table">
														<thead>
															<tr>
																<th><spring:message code="label.material" /></th>
																<th><spring:message code="label.qty" /></th>
																<th><spring:message code="label.uom" /></th>
																<th><spring:message code="label.price" /></th>
																<th><spring:message code="label.ReasonForRejection" /></th>
																<th><spring:message code="label.StorageLocation" /></th>


															</tr>

														</thead>
														<tbody>
															<c:forEach var="customerReturnLineEditList"
																items="${customerReturnLineEditList}">

																<c:set var="edit1"
																	value="${customerReturnLineEditList.customerReturnLineId}"></c:set>
																<c:if test="${edit1!=null}">
																	<tr
																		id="${customerReturnLineEditList.customerReturnLineId}">
																		<spring:bind
																			path="CustomerReturnCommand.customerReturnLineIdEdit">
																			<input type="hidden" name="customerReturnLineIdEdit"
																				class="textbox"
																				value="${customerReturnLineEditList.customerReturnLineId}"
																				id="customerReturnLineIdEdit${customerReturnLineEditList.customerReturnLineId}" />
																		</spring:bind>
																		<spring:bind
																			path="CustomerReturnCommand.materialidsEdit">
																			<input type="hidden" name="materialidsEdit"
																				class="textbox"
																				value="${customerReturnLineEditList.materialIdEdit}"
																				id="materialidsEdit${customerReturnLineEditList.customerReturnLineId}" />
																		</spring:bind>
																		<td><spring:bind
																				path="CustomerReturnCommand.materiaName">
																				<input type="text" name="materiaName"
																					class="textbox"
																					value="${customerReturnLineEditList.materiaName}"
																					id="materiaName${customerReturnLineEditList.customerReturnLineId}" />
																			</spring:bind></td>
																		<spring:bind path="CustomerReturnCommand.stockEdit">
																			<input type="hidden" name="stockEdit" class="textbox"
																				readonly="readonly"
																				value="${customerReturnLineEditList.stockEdit}"
																				id="stockEdit${customerReturnLineEditList.customerReturnLineId}" />

																		</spring:bind>
																		<td><spring:bind
																				path="CustomerReturnCommand.qtyEdit">
																				<input type="text" name="qtyEdit" class="textbox"
																					value="${customerReturnLineEditList.qtyEdit}"
																					id="qtyEdit${customerReturnLineEditList.customerReturnLineId}" />
																			</spring:bind></td>
																		<spring:bind path="CustomerReturnCommand.uomsEdit">
																			<input type="hidden" name="uomsEdit" class="textbox"
																				value="${customerReturnLineEditList.uOMIdEdit}"
																				id="uomsEdit${customerReturnLineEditList.customerReturnLineId}" />
																		</spring:bind>
																		<td><spring:bind
																				path="CustomerReturnCommand.uomName">
																				<input type="text" name="uomName" class="textbox"
																					value="${customerReturnLineEditList.uomName}"
																					id="uomName${customerReturnLineEditList.customerReturnLineId}" />
																			</spring:bind></td>
																		<td><spring:bind
																				path="CustomerReturnCommand.priceEdit">
																				<input type="text" name="priceEdit"
																					id="priceEdit${customerReturnLineEditList.customerReturnLineId}"
																					class="textbox"
																					value="${customerReturnLineEditList.priceEdit }" />
																			</spring:bind></td>
																		<spring:bind
																			path="CustomerReturnCommand.reasonForRejectionEdit">
																			<input type="hidden" name="reasonForRejectionEdit"
																				id="reasonForRejectionEdit${customerReturnLineEditList.customerReturnLineId}"
																				class="textbox"
																				value="${customerReturnLineEditList.reasonForRejectionIdEdit}"
																				readonly="readonly" />
																		</spring:bind>
																		<td><spring:bind
																				path="CustomerReturnCommand.reasonForRejectionName">
																				<input type="text" name="reasonForRejectionName"
																					class="textbox"
																					value="${customerReturnLineEditList.reasonForRejectionName}"
																					id="reasonForRejectionName${customerReturnLineEditList.customerReturnLineId}" />
																			</spring:bind></td>

																		<spring:bind
																			path="CustomerReturnCommand.storageLocationEdit">
																			<input type="hidden" name="storageLocationEdit"
																				id="storageLocationEdit${customerReturnLineEditList.customerReturnLineId}"
																				class="textbox"
																				value="${customerReturnLineEditList.storageLocationIdEdit }" />
																		</spring:bind>
																		<td><spring:bind
																				path="CustomerReturnCommand.storageLocName">
																				<input type="text" name="storageLocName"
																					class="textbox"
																					value="${customerReturnLineEditList.storageLocName}"
																					id="storageLocName${customerReturnLineEditList.customerReturnLineId}" />
																			</spring:bind> <input type="hidden"
																			name="${customerReturnLineEditList.customerReturnLineId}Check"
																			id="${customerReturnLineEditList.customerReturnLineId}Check"
																			value="0" /></td>
																		<td><a href="#"
																			id="${customerReturnLineEditList.customerReturnLineId}"
																			onclick="javascript:editCustomerReturnDetailsInEdit(this)"><img
																				src="images/Edit.jpg" height="25px" width="25px"
																				id="${customerReturnLineEditList.customerReturnLineId}"></img></a></td>
																		<td><a href="#"
																			id="${customerReturnLineEditList.customerReturnLineId}"
																			onclick="javascript:getID1(this)"><img
																				src="images/button_cancel.png" height="25px"
																				width="25px"
																				id="${customerReturnLineEditList.customerReturnLineId}"></img></a></td>
																	</tr>


																	<script type="text/javascript">
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
																		function editCustomerReturnDetailsInEdit(
																				link) {
																			//alert(link.id);
																			$(
																					"#dialog-form-CustomerReturnEdit")
																					.dialog(
																							"open");
																			$(
																					'#materialidsEdit')
																					.val(
																							$(
																									'#materialidsEdit'
																											+ link.id)
																									.val());
																			$(
																					'#qtyEdit')
																					.val(
																							$(
																									'#qtyEdit'
																											+ link.id)
																									.val());
																			$(
																					'#uomsEdit')
																					.val(
																							$(
																									'#uomsEdit'
																											+ link.id)
																									.val());
																			$(
																					'#priceEdit')
																					.val(
																							$(
																									'#priceEdit'
																											+ link.id)
																									.val());
																			$(
																					'#reasonForRejectionEdit')
																					.val(
																							$(
																									'#reasonForRejectionEdit'
																											+ link.id)
																									.val());

																			$(
																					'#storageLocationEdit')
																					.val(
																							$(
																									'#storageLocationEdit'
																											+ link.id)
																									.val());

																			$(
																					'#hiddenIdCustomerReturnPopUpEdit')
																					.val(
																							link.id);

																		}
																	</script>
																</c:if>
															</c:forEach>


														</tbody>

													</table>
												</div>
												<button id="create-AddCustomerReturnEdit" type="button">Add
													New Customer Return Line</button>

											</div>

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


							</form:form>
						</c:if>
					</div>
				</div>
			</div>




		</div>
	</div>





</body>

</html>




