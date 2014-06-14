<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script type="text/javascript" src="js/jquery.signature.js"></script>
<link type="text/css" href="js/jquery.signature.css" rel="stylesheet" />


<style type="text/css">
.kbw-signature {
	width: 200px;
	height: 100px;
}
</style>

<script type="text/javascript">
	function dateFun(datePattern) {
		$('#voucherDTEdit,#voucherDT').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
		});
	}
</script>
<script type="text/javascript">
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

		// numbers
		else if ((("0123456789.").indexOf(keychar) > -1))
			return true;
		// decimal point jump
		/* else if (dec && (keychar == ".")) {
			myfield.form.elements[dec].focus();
			return false;
		}  */
		else
			return false;
	}

	function doAjaxPost(id) {
		//alert("asd"+id);
		if (id == 'A') {
			var code = $('#voucherNo').val();
			$
					.ajax({
						type : "POST",
						url : "voucherCheck.mnt",
						data : "voucher=" + code + "&voucherId=0",
						success : function(data) {
							//	alert(data);
							var checkResponse = "Warning ! Voucher aleardy exists. Please try some other one";
							if (checkResponse == data) {
								document.getElementById("voucherDuplicateMess").style.display = "block";
								//$('#voucherDuplicateMess').html(data);
								$('#save').hide();
							} else {
								document.getElementById("voucherDuplicateMess").style.display = "none";
								$('#save').show();
							}
						},
						error : function(e) {
							alert('Error: ' + e);
						}

					});
		}
		if (id == 'E') {
			var coaIdEdit = $('#voucherIdEdit').val();
			var coaEdit = $('#voucherNoEdit').val();
			$
					.ajax({
						type : "POST",
						url : "voucherCheck.mnt",
						data : "voucher=" + coaEdit + "&voucherId=" + coaIdEdit,
						success : function(data) {
							//alert("data "+data);
							var checkResponse = "Warning ! Voucher aleardy exists. Please try some other one";
							if (checkResponse == data) {
								document
										.getElementById("voucherDuplicateMessEdit").style.display = "block";
								//$('#voucherDuplicateMessEdit').html(data);
								$('#update').hide();
							} else {
								document
										.getElementById("voucherDuplicateMessEdit").style.display = "none";
								$('#update').show();
							}
						},
						error : function(e) {
							alert('Error: ' + e);
						}

					});

		}
	}

	$(document)
			.ready(
					function() {
						$('#sig').signature();
						$('#sig').signature({
							syncField : '#signatureJSON'
						});
						$('#clear').click(function() {
							$('#sig').signature('clear');
						});

						$('#sigTo').signature({
							disabled : true
						});
						//alert($('#signatureJSONEdit').val());
						$('#sigTo').signature('draw',
								$('#signatureJSONEdit').val());
						$('#clearEdit').click(function() {
							$('#sigTo').signature('clear');
							$('#sigTo').signature({
								disabled : false
							});
							$('#signatureJSONEdit').val("");
							$('#sigTo').signature({
								syncField : '#signatureJSONEdit'
							});

						});

						$('#save')
								.click(
										function(event) {

											$('#codeAdd')
													.validate(
															{
																rules : {
																	voucherNo : {
																		required : true
																	},
																	voucherType_Id : {
																		required : true
																	},
																	signature : {
																		required : true
																	},
																	voucherDT : {
																		required : true
																	},
																	employeeId : {
																		required : true
																	},
																	amount : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},

																},
																messages : {
																	voucherNo : "<font style='color: red;'><b>Voucher No is Required</b></font>",
																	voucherType_Id : "<font style='color: red;'><b>Voucher Type is Required</b></font>",
																	signature : "<font style='color: red;'><b>Signature is Required</b></font>",
																	voucherDT : "<font style='color: red;'><b>Voucher Date is Required</b></font>",
																	employeeId : "<font style='color: red;'><b>Payee is Required</b></font>",
																	amount : "<font style='color: red;'><b>Amount is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},

															});

										});

						$('#update')
								.click(
										function(event) {

											//alert("ss");
											$('#voucherEditLink')
													.validate(
															{
																rules : {
																	voucherNo : {
																		required : true
																	},

																	voucherType_Id : {
																		required : true
																	},
																	signature : {
																		required : true
																	},
																	voucherDT : {
																		required : true
																	},
																	employeeId : {
																		required : true
																	},
																	amount : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},

																},
																messages : {
																	voucherNo : "<font style='color: red;'><b>Voucher No is Required</b></font>",
																	voucherType_Id : "<font style='color: red;'><b>Voucher Type is Required</b></font>",
																	signature : "<font style='color: red;'><b>Signature is Required</b></font>",
																	voucherDT : "<font style='color: red;'><b>Voucher Date is Required</b></font>",
																	employeeId : "<font style='color: red;'><b>Payee is Required</b></font>",
																	amount : "<font style='color: red;'><b>Amount is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",

																},

															});

										});

					});
</script>
<script>
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs").tabs();
	});

	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs1").tabs();
	});
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs2").tabs();
	});
</script>
<script>
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#voucherNo').focus();
			$('#basicSearchId').focus();
			$('#edit').hide();
			$('#signatureJSON').val('');
			$('#voucherDT').val('');
			$('#employeeId').val('');
			$('#amount').val('');
			$('#statusId').val('');
			$('#voucherType_Id').val('');
			$('#voucherNo').val('');
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
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("creditNoteDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
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
	width: 70%;
	align: left;
}
</style>
<script type="text/javascript">
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
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">
			<spring:message code="label.voucher" />
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:if var="codeEditList" test="${voucherEditList!=null}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:if>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<table class="tableGeneral">
						<form:form action="voucherSearch.mnt" method="GET"
							commandName="voucherCommand">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.voucher" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.voucher" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${voucherUpdate}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.voucher" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${voucherUpdateFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.voucher" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${voucherDelete}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.voucher" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${voucherDeleteFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.voucher" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="voucherCommand.operations">
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
										<c:when test="${privileges eq messageup }">
											<c:set var="update" value="true"></c:set>
										</c:when>
									</c:choose>
								</c:forEach>

								<td><c:choose>
										<c:when test="${true}">
											<input type="submit" class="btn btn-primary" value="Search" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												class="btn btn-danger" value="Search" />
										</c:otherwise>
									</c:choose></td>
							</tr>
						</form:form>
					</table>

					<c:if test="${voucherList!=null }">
						<display:table name="voucherList" id="VoucherList" class="table"
							requestURI="voucherSearch.mnt" pagesize="5">

							<display:column property="voucherNo" sortable="true"
								titleKey="label.voucherno" media="html" />

							<display:column property="voucherType_Id" sortable="true"
								titleKey="label.voucherId" media="html" />

							<display:column property="voucherDT" sortable="true"
								titleKey="label.voucherDT" media="html" />
							<display:column property="employeeId" sortable="true"
								titleKey="label.employeeId" media="html" />
							<display:column property="amount" sortable="true"
								titleKey="label.amount" media="html" />
							<display:column property="statusId" sortable="true"
								titleKey="label.statusId" media="html" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${true }">
										<a
											href="voucherEdit.mnt?coaId=<c:out value="${VoucherList.voucherId}"/> "><img
											src="images/Edit.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px" height="20px" />
										</a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${true }">
										<a
											href="voucherDelete.mnt?voucherId=<c:out value="${VoucherList.voucherId}"/> "
											onclick="return confirm('Do You Want To Delete This Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>

					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="voucherDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.voucherNO" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="voucherAdd.mnt" method="POST"
						commandName="voucherCommand" id="codeAdd">
						<form:hidden path="voucherDuplicate" />
						<table>
							<tr>
								<td>Voucher No<span class="required">*</span></td>
								<td><form:input path="voucherNo" id="voucherNo"
										class="textbox" onkeyup="doAjaxPost('A')" maxlength="50" /></td>
							</tr>
							<tr>
								<td>Voucher Type<span class="required">*</span></td>
								<td><form:select path="voucherType_Id" id="voucherType_Id"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${voucherType_Id}" />
									</form:select></td>
							</tr>

							<tr>
								<td>Voucher Date<span class="required">*</span></td>
								<td><form:input path="voucherDT" id="voucherDT"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td>Payee<span class="required">*</span></td>
								<td><form:input path="employeeId" id="employeeId"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td>Amount<span class="required">*</span></td>
								<td><form:input path="amount" id="amount" class="textbox"
										maxlength="16" onKeyPress="return numbersonly(this, event)" />
								</td>
							</tr>

							<tr>
								<td>Status<span class="required">*</span></td>
								<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${statusId}" />
									</form:select></td>
							</tr>
							<tr>
								<td>Signature<span class="required">*</span></td>
								<td><div id="sig"></div> <input type="button" name="Clear"
									id="clear" value="Clear" /> <form:hidden path="signature"
										id="signatureJSON" class="textbox" /></td>
							</tr>

						</table>

						<c:choose>
							<c:when test="${true }">
								<input type="submit" value="Save" name="Save" id="save"
									class="btn btn-primary" />
							</c:when>
							<c:otherwise>
								<input type="submit" value="Save" disabled="disabled"
									name="Save" id="save" class="btn btn-danger" />
							</c:otherwise>
						</c:choose>
						<input type="reset" class="btn btn-primary" />
					</form:form>
				</div>

				<!--<p style="clear: both;"><button id="clear">Clear</button> <button id="json">To JSON</button></p>

 <div id="sigTo"></div> -->

			</div>

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="voucherDuplicateMessEdit"
								style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.voucherNO" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>

					<form:form action="voucherUpdate.mnt" method="POST"
						commandName="voucherCommand" id="voucherEditLink">

						<c:if var="voucherEditList" test="${voucherEditList!=null}">

							<table>
								<tr>
									<td>Voucher No<span class="required">*</span></td>
									<td><form:input path="voucherNo" id="voucherNoEdit"
											class="textbox" onkeyup="doAjaxPost('E')" maxlength="50" /></td>
								</tr>

								<tr>
									<td>Voucher Type<span class="required">*</span></td>
									<td><form:select path="voucherType_Id" id="voucherType_Id"
											class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${voucherType_Id}" />
										</form:select></td>
								</tr>

								<tr>
									<td>Voucher Date<span class="required">*</span></td>
									<td><form:hidden path="voucherId" id="voucherIdEdit"
											class="textbox" /> <form:input path="voucherDT"
											id="voucherDTEdit" class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td>Payee<span class="required">*</span></td>
									<td><form:input path="employeeId" id="employeeId"
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td>Amount<span class="required">*</span></td>
									<td><form:input path="amount" id="amount" class="textbox"
											maxlength="16" onKeyPress="return numbersonly(this, event)" />
									</td>
								</tr>

								<tr>
									<td>Status<span class="required">*</span></td>
									<td><form:select path="statusId" id="statusId"
											class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${statusId}" />
										</form:select></td>

								</tr>
								<tr>
									<td>Signature<span class="required">*</span></td>
									<td><div id="sigTo"></div> <input type="button"
										name="Clear" id="clearEdit" value="Clear" /> <form:hidden
											path="signature" id="signatureJSONEdit" class="textbox" /></td>
								</tr>

							</table>
							<c:choose>
								<c:when test="${true }">
									<input type="submit" value="Update" name="update" id="update"
										class="btn btn-primary" />
								</c:when>
								<c:otherwise>
									<input type="submit" disabled="disabled" value="Update"
										name="update" id="update" class="btn btn-danger" />
								</c:otherwise>
							</c:choose>

						</c:if>
					</form:form>
				</div>

			</div>
		</div>

	</div>
</body>
</html>
