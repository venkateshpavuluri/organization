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
<title>My JSP 'stockTransfer.jsp' starting page</title>

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
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addStockForm')
													.validate(
															{
																rules : {
																	stockTransferNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	stockTransferDate : {
																		required : true

																	},
																	orgId : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	storageLocationId : {
																		required : true
																	},
																	toOrgId : {
																		required : true
																	},
																	toPlantId : {
																		required : true
																	},
																	toStorageLocationId : {
																		required : true
																	},

																},
																messages : {
																	stockTransferNo : {
																		required : "<font style='color: red;'><b>Sales Inquiry No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	stockTransferDate : "<font style='color: red;'><b>Stock Transfer Date is Required</b></font>",
																	orgId : "<font style='color: red;'><b>Organization Name is Required</b></font>",
																	plantId : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	storageLocationId : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	toOrgId : "<font style='color: red;'><b>To Organization Name is Required</b></font>",
																	toPlantId : "<font style='color: red;'><b>To Plant Name  is Required</b></font>",
																	toStorageLocationId : "<font style='color: red;'><b>To Storage Location is Required</b></font>"

																},

															});
											if ($('#stockTransferNo').val() != ""
													&& $('#orgId').val() != ""
													&& $('#toOrgId').val() != ""
													&& $('#toStorageLocationId')
															.val() != "") {
												if ($('#stId').val() == 0) {
													//alert("Please Enter AtLeast One Stock Transfer Line");
													document
															.getElementById("childMsg").style.display = "block";
													$('#childMsg')
															.html(
																	"Warning! Please Enter AtLeast One Stock Transfer Line");
													return false;
												} else {
													document
															.getElementById("childMsg").style.display = "none";
													$('#childMsg').html("");
													return true;
												}
											}

										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editStockForm')
													.validate(
															{
																rules : {
																	estockTransferNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	estockTransferDate : {
																		required : true

																	},
																	eorgId : {
																		required : true
																	},
																	eplantId : {
																		required : true
																	},
																	estorageLocationId : {
																		required : true
																	},
																	etoOrgId : {
																		required : true
																	},
																	etoPlantId : {
																		required : true
																	},
																	etoStorageLocationId : {
																		required : true
																	},

																},
																messages : {
																	estockTransferNo : {
																		required : "<font style='color: red;'><b>Sales Inquiry No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	estockTransferDate : "<font style='color: red;'><b>Stock Transfer Date is Required</b></font>",
																	eorgId : "<font style='color: red;'><b>Organization Name is Required</b></font>",
																	eplantId : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	estorageLocationId : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	etoOrgId : "<font style='color: red;'><b>To Organization Name is Required</b></font>",
																	etoPlantId : "<font style='color: red;'><b>To Plant Name  is Required</b></font>",
																	etoStorageLocationId : "<font style='color: red;'><b>To Storage Location is Required</b></font>"

																},
															});

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

<script>
	$(function() {
		$("#tabs,#tabss,#edittabs").tabs();

	});

	function dateFun(datePattern) {
		$('#stockDate,#stockDateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
		});

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#basicSearchId').focus();
		$('#add,#search').click(function(e) {
			$('#basicSearchId').focus();
			$('#stockTransferNo').focus();
			$('#edit').hide();
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
	function AjaxForPlant(id, Mode) {
		var orgId = $('#' + id).val();
		//alert(orgId);
		var p = 0, msg = null;

		$
				.ajax({
					type : "POST",
					url : "forPlantIds.mnt",
					data : "orgId=" + orgId,
					success : function(response) {
						var options = "";
						if (Mode == 'AddMode') {
							options = $("#plantId").empty();
							msg = "The Selected Organization Name Does Not Contain Plants";
						} else if (Mode == 'ToAddMode') {
							options = $("#toPlantId").empty();
							msg = "The Selected To Organization Name Does Not Contain Plants";

						} else if (Mode == 'EditMode') {
							options = $("#plantIdEdit").empty();
							msg = "The Selected Organization Name Does Not Contain Plants";

						} else {
							options = $("#toPlantIdEdit").empty();
							msg = "The Selected To Organization Name Does Not Contain Plants";
						}

						if (response == "") {
							if (Mode == 'AddMode' || Mode == 'ToAddMode') {
								document.getElementById("salesDuplMessage").style.display = "block";
								$('#salesDuplMessage').html(msg);
							} else {
								document.getElementById("salesUpDuplMessage").style.display = "block";
								$('#salesUpDuplMessage').html(msg);
							}

						} else {

							document.getElementById("salesDuplMessage").style.display = "none";
							document.getElementById("salesUpDuplMessage").style.display = "none";
							options.append(new Option("-Select-", ""));
							$.each(response, function(key, value) {
								if (p == 0) {
									options.append(new Option(value, key));
								} else {
									options.append(new Option(value, key));
								}
								p++;
							});
						}

					},
					error : function(e) {
						alert('Error' + e);
					}

				});

	}

	function AjaxForStorLoc(id, Mode) {
		var pId = $('#' + id).val();
		//alert(pId);
		var i = 1, msg = null;

		$
				.ajax({
					type : "POST",
					url : "forStorLocIds.mnt",
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
								document.getElementById("salesDuplMessage").style.display = "block";
								$('#salesDuplMessage').html(msg);
							} else {
								document.getElementById("salesUpDuplMessage").style.display = "block";
								$('#salesUpDuplMessage').html(msg);
							}

						} else {
							document.getElementById("salesDuplMessage").style.display = "none";
							document.getElementById("salesUpDuplMessage").style.display = "none";
							ss.append(new Option("-Select-", ""));
							$.each(response, function(key, value) {
								if (i == 1) {
									//ss.append(new Option("-Select-", ""));
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

	function AjaxBatchNos() {
		var i = 1;
		var matId = $('#materialId').val();
		var slId = $('#slId').val();
		//alert(slId);
		//alert("m"+matId);

		$.ajax({
			type : "POST",
			url : "forBatchNo.mnt",
			data : "materialId=" + matId + "&slId=" + slId,
			success : function(response) {
				var match = "";
				match = $('#batchNoId').empty();
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

	function AjaxGetQty() {

		var matId = $('#materialId').val();
		var storLocId = $('#slId').val();
		var baId = $('#batchNoId').val();
		//alert(storLocId);
		$.ajax({
			type : "POST",
			url : "getStockQty.mnt",
			data : "materialId=" + matId + "&slId=" + storLocId + "&batchNo="
					+ baId,
			success : function(response) {
				$('#avalQty').val(response);

			},
			error : function(e) {
				alert('Error' + e);
			}

		});

	}

	function AjaxBatchNosEdit() {
		var i = 1;
		var matId = $('#materialIdEdit').val();
		var slId = $('#slIdEdit').val();
		//alert(matId);
		$.ajax({
			type : "POST",
			url : "forBatchNo.mnt",
			data : "materialId=" + matId + "&slId=" + slId,
			success : function(response) {
				var matchEdit = "";
				matchEdit = $('#batchNoEdit').empty();
				matchEdit.append(new Option("-Select-", ""));
				$.each(response, function(key, value) {
					if (i == 1) {
						matchEdit.append(new Option(value, key));
					} else {
						matchEdit.append(new Option(value, key));
					}
					i++;
				});

			},
			error : function(e) {
				alert('Error' + e);
			}

		});

	}

	function AjaxGetQtyEdit() {

		var matId = $('#materialIdEdit').val();
		var storLocId = $('#slIdEdit').val();
		var baId = $('#batchNoEdit').val();
		//alert(storLocId);
		$.ajax({
			type : "POST",
			url : "getStockQty.mnt",
			data : "materialId=" + matId + "&slId=" + storLocId + "&batchNo="
					+ baId,
			success : function(response) {
				$('#avalQtyEdit').val(response);

			},
			error : function(e) {
				alert('Error' + e);
			}

		});

	}

	function AjaxForDuplicate() {
		var cust = $('#stockTransferNo').val();
		//alert(cust);
		$
				.ajax({
					type : "POST",
					url : "checkStockAddDuplicate.mnt",
					data : "stockTransferNo=" + cust,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesDuplMessage").style.display = "block";
							//$('#salesDuplMessage').html(response);
							$('#submitid').hide();

						} else {
							document.getElementById("salesDuplMessage").style.display = "none";
							$('#submitid').show();
						}

					},
					error : function(e) {
						alert('Error' + e);
					}

				});

	}

	function AjaxUpdateDuplicate() {
		var cust = $('#estockTransferNo').val();
		var id = $('#estockTransferId').val();
		//alert(id);
		$
				.ajax({
					type : "POST",
					url : "checkStockUpdateDuplicate.mnt",
					data : "estockTransferNo=" + cust + "&stId=" + id,
					success : function(response) {
						if (response != "") {
							document.getElementById("salesUpDuplMessage").style.display = "block";
							//$('#salesUpDuplMessage').html(response);
							$('#updateid').hide();

						} else {
							document.getElementById("salesUpDuplMessage").style.display = "none";
							$('#updateid').show();
						}

					},
					error : function(e) {
						alert('Error' + e);
					}

				});

	}

	function AjaxMaterial(value) {
		var i = 1;
		if (value == 'A') {
			var storId = $('#slId').val();
			//alert(storId);
			$.ajax({
				type : "POST",
				url : "forMaterial.mnt",
				data : "storLocId=" + storId,
				success : function(response) {
					var match = "";
					match = $('#materialId').empty();
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
		} else {
			var storId = $('#slIdEdit').val();
			//alert(storId);
			$.ajax({
				type : "POST",
				url : "forMaterial.mnt",
				data : "storLocId=" + storId,
				success : function(response) {
					alert(response);
					var match = "";
					match = $('#materialIdEdit').empty();
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

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("stId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnasdStop').click(function(e) {
			document.getElementById("stId").value = 1;
			//alert(document.getElementById("asId").value);
		});
	});
</script>

</head>
<body>


	<div class="divUserDefault">

		<div class="PageTitle">Stock Transfer</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">

				<c:if test="${stockEditList!=null}">
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

					<form:form method="get" action="stockTransferSearch.mnt"
						commandName="stockTransferCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addSTSus"
										items="${param.addSTSus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.stock" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addSTFail"
										items="${param.addSTFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.stock" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSTsus"
										items="${param.UpdateSTsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.stock" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="UpdateSTFail"
										items="${param.UpdateSTFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.stock" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteSTsus"
										items="${param.DeleteSTsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.stock" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteSTFail"
										items="${param.DeleteSTFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.stock" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr id="mainSearch">
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox"
										id="basicSearchId" /></td>
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
									<c:when test="${search }">
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

							<form:form action="STAdvanceSearch.mnt" method="get"
								commandName="stockTransferCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="STAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>
						</table>

						<form:form action="STAdvanceSearchOperations.mnt"
							commandName="stockTransferCmd" method="get">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="stockTransferCmd.asOpts">
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

											<td><form:input path="advanceSearchText"
													cssClass="textbox" /></td>
										</tr>

									</c:forEach>


									<c:forEach var="refList" items="${refList}">
										<tr>
											<td><label>${refList.labels}</label> <form:hidden
													path="dbField" id="dbField" value="${refList.dbField}" /></td>
											<td><spring:bind path="stockTransferCmd.asOpts">
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
											<c:set var="orgId" value="orgId" />
											<c:set var="plantId" value="plantId" />
											<c:set var="storageLocationId" value="storageLocationId" />
											<c:if test="${bdField eq orgId}">
												<c:set var="selectBox" value="${OrgSelect}" />
											</c:if>
											<c:if test="${bdField eq plantId}">
												<c:set var="selectBox" value="${plantSelect}" />
											</c:if>
											<c:if test="${bdField eq storageLocationId}">
												<c:set var="selectBox" value="${storLocSelect}" />
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
										<c:choose>
											<c:when test="${search }">
												<td colspan="3"><input type="submit"
													id="advanceSearchButtonId" value="Advance Search"
													style="display: none" class="btn btn-primary" /></td>
											</c:when>
											<c:otherwise>
												<td colspan="3"><input type="submit"
													disabled="disabled" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-danger" /></td>
											</c:otherwise>
										</c:choose>
									</tr>

								</table>

							</div>
						</form:form>

					</form:form>


					<c:if test="${STList!=null }">
						<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="STAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="stockTransferSearch.mnt" />
							</c:otherwise>

						</c:choose>
						<display:table name="STList" id="STIdList" class="table"
							requestURI="${search}" pagesize="5">

							<display:column property="stockTransferId" sortable="true"
								title="stockTransferId" media="none" />

							<display:column property="stockTransferNo" sortable="true"
								titleKey="label.strno" media="html" />

							<display:column property="stockTransferDate" sortable="true"
								titleKey="label.strdate" media="html" />


							<display:column property="orgId" sortable="true"
								titleKey="label.strorgid" media="html" />

							<display:column property="plantId" sortable="true"
								titleKey="label.strplant" media="html" />

							<display:column property="storageLocationId" sortable="true"
								titleKey="label.strStorloc" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="stockTransferEdit.mnt?stockTransferId=<c:out value="${STIdList.stockTransferId}"/> "><img
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
											href="stockTransferDelete.mnt?stockTransferId=<c:out value="${STIdList.stockTransferId}"/> "
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
							<td colspan="4" class="alert-warning" id="childMsg"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
						<tr>
							<td colspan="2" id="salesDuplMessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.strno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="stockTransferAdd.mnt" method="POST"
						commandName="stockTransferCmd" id="addStockForm">

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">
										<tr>
											<td><spring:message code="label.strno" /><span
												class="required">*</span></td>
											<td><form:input path="stockTransferNo"
													id="stockTransferNo" cssClass="textbox"
													onkeyup="AjaxForDuplicate()" maxlength="20" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.strdate" /><span
												class="required">*</span></td>
											<td><form:input path="stockTransferDate"
													cssClass="textbox" id="stockDate" /></td>

										</tr>

										<tr>
											<td><spring:message code="label.strorgid" /><span
												class="required">*</span></td>
											<td><form:select path="orgId" id="orgId"
													cssClass="select"
													onchange="AjaxForPlant(this.id,'AddMode')">
													<form:option value="">-Select-</form:option>
													<form:options items="${OrgSelect}" />
												</form:select></td>
										</tr>

										<tr>
											<td><spring:message code="label.strplant" /><span
												class="required">*</span></td>
											<td><form:select path="plantId" cssClass="select"
													id="plantId" onchange="AjaxForStorLoc(this.id,'AddMode')">
													<form:option value="">-Select-</form:option>

												</form:select></td>

										</tr>

										<tr>
											<td><spring:message code="label.strStorloc" /><span
												class="required">*</span></td>
											<td><form:select path="storageLocationId"
													cssClass="select" id="slId" onchange="AjaxMaterial('A')">
													<form:option value="">-Select-</form:option>
												</form:select></td>

										</tr>

										<tr>
											<td><spring:message code="label.tostrorgid" /><span
												class="required">*</span></td>
											<td><form:select path="toOrgId" id="toOrgId"
													cssClass="select"
													onchange="AjaxForPlant(this.id,'ToAddMode')">
													<form:option value="">-Select-</form:option>
													<form:options items="${OrgSelect}" />
												</form:select></td>
										</tr>

										<tr>
											<td><spring:message code="label.tostrplant" /><span
												class="required">*</span></td>
											<td><form:select path="toPlantId" cssClass="select"
													id="toPlantId"
													onchange="AjaxForStorLoc(this.id,'ToAddMode')">
													<form:option value="">-Select-</form:option>

												</form:select></td>
										</tr>


										<tr>
											<td><spring:message code="label.tostrStorloc" /><span
												class="required">*</span></td>
											<td><form:select path="toStorageLocationId"
													cssClass="select" id="toSlId">
													<form:option value="">-Select-</form:option>
												</form:select> <input type="hidden" name="stId" id="stId" class="textbox"
												value="0" /></td>

										</tr>

									</table>

								</td>

							</tr>

						</table>

						<!-- window 2 -->

						<div id="tabss" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.strline" /></a></li>
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

															var matId = $("#materialId"), qty = $("#quantity"), uomId = $("#UOMId"), batch = $('#batchNoId'), avalQty = $('#avalQty'), hiddenID = $("#hiddenIdStockPopUp"),

															allFields = $([])
																	.add(matId)
																	.add(qty)
																	.add(uomId)
																	.add(batch)
																	.add(
																			avalQty)
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
															function qtyTest(
																	avalQty,
																	Qty) {
																//alert(avalQty.val()+ " "+Qty.val());
																var qty = parseFloat(Qty
																		.val());
																var avQty = parseFloat(avalQty
																		.val());
																if (qty > avQty) {
																	Qty
																			.addClass("ui-state-error");
																	updateTips("Quantity Must be LessThan or equal to Available Quantity");
																	return false;
																} else {
																	return true;
																}

															}

															$(
																	"#dialogformStockLine")
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
																										matId,

																										"Material Name");

																						bValid = bValid
																								&& required(
																										uomId,

																										"UOM Name");

																						bValid = bValid
																								&& required(
																										batch,

																										"Required Batch No");
																						bValid = bValid
																								&& checkRegexp(
																										qty,
																										/^([0-9.])+$/i,
																										"Quantity is Required And Must be  Number");
																						bValid = bValid
																								&& qtyTest(
																										avalQty,
																										qty);

																						if (bValid) {
																							//alert("hiddenid"+hiddenID.val());
																							if (hiddenID
																									.val() == "0"
																									|| hiddenID
																											.val() == "") {
																								$(
																										"#StockLineAdd tbody")
																										.append(

																												"<tr id="+btrid+">"
																														+ "<td ><spring:bind path='stockTransferCmd.materialId'><input type='hidden' name='materialId' id='materialId"
																														+ btrid
																														+ "' value="
																														+ matId
																																.val()

																														+ " class='textbox' readonly/></spring:bind> "
																														+ "<input type='text' readonly class='textbox' name='materialName' id='materialName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#materialId :selected')
																																.text()
																														+ "'"
																														+ "</td>"

																														+ "<td><input type='hidden' name='UOMId' id='UOMId"
																														+ btrid
																														+ "' value="
																														+ uomId
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='text' class='textbox' readonly name='uomName' id='uomName"
																														+ btrid
																														+ "' value='"
																														+ $(
																																'#UOMId :selected')
																																.text()
																														+ "'"
																														+ "</td>"

																														+ "<td><input name='batchNo' id='batchNoId"
																														+ btrid
																														+ "' value="
																														+ batch
																																.val()
																														+ " class='textbox' readonly/></td>"

																														+ "<td><input name='quantity' id='quantity"
																														+ btrid
																														+ "' value="
																														+ qty
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<input type='hidden' name='avalQty' id='avalQty"
																														+ btrid
																														+ "' value="
																														+ avalQty
																																.val()
																														+ " class='textbox' readonly/>"
																														+ "<td><a href='#'  onclick='editstockTransferLine("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removestockTransferLine("
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
																										'#materialId'
																												+ hiddenID
																														.val())
																										.val(
																												matId
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
																										'#quantity'
																												+ hiddenID
																														.val())
																										.val(
																												qty
																														.val());
																								$(
																										'#batchNoId'
																												+ hiddenID
																														.val())
																										.val(
																												batch
																														.val());
																								$(
																										'#avalQty'
																												+ hiddenID
																														.val())
																										.val(
																												avalQty
																														.val());

																								$(
																										'#UOMId'
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
																														'#UOMId :selected')
																														.text());

																								$(
																										'#hiddenIdStockPopUp')
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
																	'#createAddStockLine')
																	.button()
																	.click(
																			function() {

																				$(
																						"#dialogformStockLine")
																						.dialog(
																								"open");
																				//alert("opened");
																			});
														});

										function removestockTransferLine(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editstockTransferLine(id) {
											//alert("edit row " + id);

											$("#dialogformStockLine").dialog(
													"open");

											$('#materialId')
													.val(
															$(
																	'#materialId'
																			+ id)
																	.val());

											$('#quantity').val(
													$('#quantity' + id).val());
											$('#batchNoId').val(
													$('#batchNoId' + id).val());
											$('#avalQty').val(
													$('#avalQty' + id).val());

											$('#UOMId').val(
													$('#UOMId' + id).val());

											$('#hiddenIdStockPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialogformStockLine" align="center"
										title="<spring:message code="label.strform" />">
										<p class="validateTips" align="center" style="color: blue;">All
											Form Fields are Required</p>
										<table class="tableGeneral">
											<tr>
												<td><spring:message code="label.strmatId" /><span
													class=required>*</span></td>
												<td><form:select path="material_Id" id="materialId"
														class="select" onchange="AjaxBatchNos()">
														<form:option value="">-Select-</form:option>
														<%-- <form:options items="${materialSelect}" /> --%>
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.struomid" /> <span
													class=required>*</span></td>
												<td><form:select path="uom_Id" id="UOMId"
														class="select">

														<form:option value="">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>
											</tr>


											<tr>
												<td><spring:message code="label.strbatch" /> <span
													class=required>*</span></td>
												<td><form:select path="ebatchName" id="batchNoId"
														class="select" onchange="AjaxGetQty()">
														<form:option value="">-Select-</form:option>
														<%-- 	<form:options items="${SelectBatchNo}" /> --%>
													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.stralqty" /><span
													class=required>*</span></td>
												<td><form:input path="avalQty" id="avalQty"
														class="textbox" readonly="true" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.strqty" /><span
													class=required>*</span></td>
												<td><form:input path="quantity" id="quantity"
														class="textbox" /></td>
											</tr>


											<tr>
												<td><input type="hidden" name="hiddenIdStockPopUp"
													id="hiddenIdStockPopUp" value="0" /></td>
											</tr>

										</table>
									</div>

									<div id="users-StockLine">
										<table id="StockLineAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.strmatId" /></th>
													<th><spring:message code="label.struomid" /></th>
													<th><spring:message code="label.strbatch" /></th>
													<th><spring:message code="label.strqty" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>

									<button id="createAddStockLine" type="button">
										<spring:message code="label.newstrline" />
									</button>

								</div>

								<!-- Model Pop-up End-->
							</div>


						</div>

						<!-- window 2 -->
						<table>
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
										<td><input type="submit" id="sumnid" disabled="disabled"
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
			<!--Edit  Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="salesUpDuplMessage" style="display: none;">

								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.strno" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>

					</table>
					<form:form method="post" action="stockTransferUpdate.mnt"
						commandName="stockTransferCmd" id="editStockForm">
						<c:forEach var="stockEditList" items="${stockEditList}">
							<c:set var="editMode" value="${stockEditList}"></c:set>
						</c:forEach>

						<c:if test="${editMode!=null}">
							<table class="tableGeneral">
								<tr>
									<td>
										<div>

											<table class="tableGeneral">

												<form:hidden path="estockTransferId" id="estockTransferId" />

												<tr>
													<td><spring:message code="label.strno" /><span
														class="required">*</span></td>
													<td><form:input path="estockTransferNo"
															id="estockTransferNo" cssClass="textbox"
															onkeyup="AjaxUpdateDuplicate()" maxlength="20" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.strdate" /><span
														class="required">*</span></td>
													<td><form:input path="estockTransferDate"
															cssClass="textbox" id="stockDateEdit" /></td>

												</tr>

												<tr>
													<td><spring:message code="label.strorgid" /><span
														class="required">*</span></td>
													<td><form:select path="eorgId" id="orgIdEdit"
															cssClass="select"
															onchange="AjaxForPlant(this.id,'EditMode')">
															<form:option value="">-Select-</form:option>
															<form:options items="${OrgSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.strplant" /><span
														class="required">*</span></td>
													<td><form:select path="eplantId" cssClass="select"
															id="plantIdEdit"
															onchange="AjaxForStorLoc(this.id,'AddMode')">
															<form:option value="">-Select-</form:option>
															<form:options items="${plantSelect}" />

														</form:select></td>

												</tr>

												<tr>
													<td><spring:message code="label.strStorloc" /><span
														class="required">*</span></td>
													<td><form:select path="estorageLocationId"
															cssClass="select" id="slIdEdit"
															onchange="AjaxMaterial('E')">
															<form:option value="">-Select-</form:option>
															<form:options items="${storLocSelect}" />
														</form:select></td>

												</tr>

												<tr>
													<td><spring:message code="label.tostrorgid" /><span
														class="required">*</span></td>
													<td><form:select path="etoOrgId" id="toOrgIdEdit"
															cssClass="select"
															onchange="AjaxForPlant(this.id,'ToEditMode')">
															<form:option value="">-Select-</form:option>
															<form:options items="${OrgSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.tostrplant" /><span
														class="required">*</span></td>
													<td><form:select path="etoPlantId" cssClass="select"
															id="toPlantIdEdit"
															onchange="AjaxForStorLoc(this.id,'ToEditMode')">
															<form:option value="">-Select-</form:option>
															<form:options items="${plantSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.tostrStorloc" /><span
														class="required">*</span></td>
													<td><form:select path="etoStorageLocationId"
															cssClass="select" id="toSlIdEdit">
															<form:option value="">-Select-</form:option>
															<form:options items="${storLocSelect}" />

														</form:select></td>

												</tr>


											</table>
										</div>
									</td>

								</tr>

							</table>

							<!-- window 2 -->

							<div id="tabss" align="left">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.salesline" /></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 100;
											$(function() {

												var matIdEdit = $("#materialIdEdit"), qtyEdit = $("#quantityEdit"), uomIdEdit = $("#UOMIdEdit"), batchEdit = $('#batchNoEdit'), avalQtyEdit = $('#avalQtyEdit'), hiddenEdit = $("#hiddenIdStockPopUpEdit"),

												allFields = $([])
														.add(matIdEdit).add(
																qtyEdit).add(
																uomIdEdit).add(
																batchEdit).add(
																avalQtyEdit)
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

												function qtyTestEdit(avalQty,
														Qty) {
													//alert(parseFloat(avalQty.val())+ " "+parseFloat(Qty.val()));
													var q = parseFloat(Qty
															.val());
													var avalQ = parseFloat(avalQty
															.val());
													if (avalQty.val() != '') {
														if (q > avalQ) {
															Qty
																	.addClass("ui-state-error");
															updateTips("Quantity Must be LessThan or equal to Available Quantity");
															return false;
														} else {
															return true;
														}
													} else {
														return true;
													}

												}

												$("#dialog-form-StockLineEdit")
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
																							matIdEdit,

																							"Material Name");

																			bValid1 = bValid1
																					&& requiredEdit(
																							uomIdEdit,

																							"UOM Name");

																			bValid1 = bValid1
																					&& requiredEdit(
																							batchEdit,

																							"Required Batch No ");
																			bValid1 = bValid1
																					&& checkRegexp(
																							qtyEdit,
																							/^([0-9.])+$/i,
																							"Quantity is Required And Must be  Number");
																			bValid1 = bValid1
																					&& qtyTestEdit(
																							avalQtyEdit,
																							qtyEdit);

																			if (bValid1) {
																				//alert("edi"+ hiddenEdit	.val());
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddStockEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='stockTransferCmd.ematerialId'><input type='hidden' name='ematerialId' id='materialIdEdit"
																											+ btrid
																											+ "' value="
																											+ matIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text' readonly class='textbox' name='ematerialName' id='materialNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#materialIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<td><spring:bind path='stockTransferCmd.eUOMId'><input type='hidden' name='eUOMId' id='UOMIdEdit"
																											+ btrid
																											+ "' value="
																											+ uomIdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<input type='text'readonly class='textbox' name='euomName' id='uomNameEdit"
																											+ btrid
																											+ "' value='"
																											+ $(
																													'#UOMIdEdit :selected')
																													.text()
																											+ "'"
																											+ "</td>"

																											+ "<input type='hidden' name='estockTransferLineId' id='estockTransferId' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																											+ "<td><spring:bind path='stockTransferCmd.ebatchNo'><input name='ebatchNo' id='batchNoEdit"
																											+ btrid
																											+ "' value="
																											+ batchEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='stockTransferCmd.equantity'><input name='equantity' id='quantityEdit"
																											+ btrid
																											+ "' value="
																											+ qtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<spring:bind path='stockTransferCmd.avalQty'><input type='hidden' name='avalQty' id='avalQtyEdit"
																											+ btrid
																											+ "' value="
																											+ avalQtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><a href='#'  onclick='editStockDetailsInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeStockDetailsEditNew("
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
																					//alert("hidden valuye "+hiddenEdit.val());

																					$(
																							'#materialIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#materialIdEdit')
																											.val());
																					$(
																							'#materialNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#materialIdEdit :selected')
																											.text());
																					$(
																							'#UOMIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#UOMIdEdit')
																											.val());
																					$(
																							'#uomNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#UOMIdEdit :selected')
																											.text());

																					$(
																							'#quantityEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#quantityEdit')
																											.val());
																					$(
																							'#batchNoEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#batchNoEdit')
																											.val());
																					$(
																							'#avalQtyEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#avalQtyEdit')
																											.val());

																					$(
																							'#hiddenIdStockPopUpEdit')
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

												$("#create-AddSalesEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-StockLineEdit")
																			.dialog(
																					"open");

																});
											});
											function removeStockDetailsEditNew(
													id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editStockDetailsInEditNew(
													link) {
												//alert("link  id "+link);
												$("#dialog-form-StockLineEdit")
														.dialog("open");
												$('#materialIdEdit').val(
														$(
																'#materialIdEdit'
																		+ link)
																.val());
												$('#UOMIdEdit').val(
														$('#UOMIdEdit' + link)
																.val());
												$('#quantityEdit').val(
														$(
																'#quantityEdit'
																		+ link)
																.val());
												$('#batchNoEdit')
														.val(
																$(
																		'#batchNoEdit'
																				+ link)
																		.val());
												$('#avalQtyEdit')
														.val(
																$(
																		'#avalQtyEdit'
																				+ link)
																		.val());

												$('#hiddenIdStockPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-StockLineEdit"
											title="<spring:message code="label.saleslineform" />">
											<p class="validateTips" align="center" style="color: blue;">All
												Form Fields are Required</p>
											<table class="tableGeneral">
												<form:hidden path="estockTransferLineId" value="0" />

												<tr>
													<td><spring:message code="label.strmatId" /><span
														class=required>*</span></td>
													<td><form:select path="ematerial_Id"
															id="materialIdEdit" class="select"
															onchange="AjaxBatchNosEdit()">
															<form:option value="">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.struomid" /> <span
														class=required>*</span></td>
													<td><form:select path="euom_Id" id="UOMIdEdit"
															class="select">

															<form:option value="">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.strbatch" /> <span
														class=required>*</span></td>
													<td><form:select path="ebatchName" id="batchNoEdit"
															class="select" onchange="AjaxGetQtyEdit()">
															<form:option value="">-Select-</form:option>
															<form:options items="${SelectBatchNo}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.stralqty" /><span
														class=required>*</span></td>
													<td><form:input path="avalQty" id="avalQtyEdit"
															class="textbox" readonly="true" /></td>
												</tr>

												<tr>
													<td><spring:message code="label.strqty" /><span
														class=required>*</span></td>
													<td><form:input path="equantity" id="quantityEdit"
															class="textbox" onkeyup="AjaxGetQtyEdit()" /></td>
												</tr>

												<tr>
													<td><input type="hidden" name="hiddenIdStockPopUpEdit"
														id="hiddenIdStockPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-contain-StockEdit">

											<table id="AddStockEdit" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.strmatId" /></th>
														<th><spring:message code="label.struomid" /></th>
														<th><spring:message code="label.strbatch" /></th>
														<th><spring:message code="label.strqty" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>

													</tr>

												</thead>
												<tbody>

													<c:forEach var="stockLineEditList"
														items="${stockLineEditList}">

														<spring:bind path="stockTransferCmd.estockTransferLineId">
															<input type="hidden" name="estockTransferLineId"
																id="estockTransferLineId${stockLineEditList.estockTransferLineId}"
																value="${stockLineEditList.estockTransferLineId}" />
														</spring:bind>
														<tr id="${stockLineEditList.estockTransferLineId}">

															<td><spring:bind path="stockTransferCmd.ematerialId">
																	<input type="hidden" name="ematerialId" class="textbox"
																		id="materialIdEdit${stockLineEditList.estockTransferLineId}"
																		value="${stockLineEditList.ematerialId}" readonly />
																</spring:bind> <spring:bind path="stockTransferCmd.ematerialName">
																	<input type="text" name="ematerialName" class="textbox"
																		id="materialNameEdit${stockLineEditList.estockTransferLineId}"
																		value="${stockLineEditList.ematerialName}" readonly />
																</spring:bind></td>


															<td><spring:bind path="stockTransferCmd.eUOMId">
																	<input type="hidden" name="eUOMId"
																		id="UOMIdEdit${stockLineEditList.estockTransferLineId}"
																		class="textbox" value="${stockLineEditList.eUOMId}"
																		readonly />
																</spring:bind> <spring:bind path="stockTransferCmd.euomName">
																	<input type="text" name="euomName"
																		id="uomNameEdit${stockLineEditList.estockTransferLineId}"
																		class="textbox" value="${stockLineEditList.euomName}"
																		readonly />
																</spring:bind></td>

															<td><spring:bind path="stockTransferCmd.ebatchNo">
																	<input type="text" name="ebatchNo" class="textbox"
																		id="batchNoEdit${stockLineEditList.estockTransferLineId}"
																		value="${stockLineEditList.ebatchNo}" readonly />
																</spring:bind></td>

															<td><spring:bind path="stockTransferCmd.equantity">
																	<input type="text" name="equantity" class="textbox"
																		id="quantityEdit${stockLineEditList.estockTransferLineId}"
																		value="${stockLineEditList.equantity}" readonly />
																</spring:bind></td>

															<td><a href="#"
																id="${stockLineEditList.estockTransferLineId}"
																onclick="javascript:editStockDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${stockLineEditList.estockTransferLineId}"></img></a></td>
															<c:if test="${delBtn==true }">
																<td><a href="#"
																	id="${stockLineEditList.estockTransferLineId}"
																	onclick="javascript:getIDStock(this.id)"><img
																		src="images/button_cancel.png" height="25px"
																		width="25px"
																		id="${stockLineEditList.estockTransferLineId}"></img></a>
																	<input type="hidden"
																	name="Check${stockLineEditList.estockTransferLineId}"
																	id="${stockLineEditList.estockTransferLineId}Check"
																	value="0" /></td>
															</c:if>
															<c:set var="delBtn" value="true" />
														</tr>

														<script>
															function getIDStock(
																	link) {
																//alert(link);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link
																				+ "Check").value = "1";
																document
																		.getElementById(link).style.display = "none";
															}
															function editStockDetailsInEdit(
																	link) {
																//alert(""+ link.id);

																$(
																		"#dialog-form-StockLineEdit")
																		.dialog(
																				"open");
																$(
																		'#materialIdEdit')
																		.val(
																				$(
																						'#materialIdEdit'
																								+ link.id)
																						.val());
																$('#UOMIdEdit')
																		.val(
																				$(
																						'#UOMIdEdit'
																								+ link.id)
																						.val());
																$(
																		'#quantityEdit')
																		.val(
																				$(
																						'#quantityEdit'
																								+ link.id)
																						.val());
																$(
																		'#batchNoEdit')
																		.val(
																				$(
																						'#batchNoEdit'
																								+ link.id)
																						.val());

																$(
																		'#hiddenIdStockPopUpEdit')
																		.val(
																				link.id);

															}
														</script>

													</c:forEach>


												</tbody>

											</table>
										</div>
										<button id="create-AddSalesEdit" type="button">
											<spring:message code="label.newsalesline" />
										</button>
									</div>
								</div>
							</div>
							<table>
								<tr>

									<c:choose>

										<c:when test="${update}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updateid" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updateid" /></td>
										</c:otherwise>
									</c:choose>


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