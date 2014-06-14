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
<title>My JSP 'inspectionLot.jsp' starting page</title>
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
																	inspLotNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	refNo : {
																		required : true
																	},
																	quantity : {
																		required : true,
																		number : true
																	},
																	batchNo : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	materialId : {
																		required : true
																	},
																	uomId : {
																		required : true
																	},
																	inspTypeId : {
																		required : true
																	},
																	inspLotOriginId : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	desc : {
																		required : true
																	}

																},
																messages : {
																	inspLotNo : {
																		required : "<font style='color: red;'><b>Inspection Lot No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"

																	},
																	refNo : "<font style='color: red;'><b>Reference No is Required</b></font>",
																	quantity : {
																		required : "<font style='color: red;'><b>Quantity is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Allows Only Numbers</b></font>"
																	},
																	batchNo : "<font style='color: red;'><b>Batch No is Required</b></font>",
																	plantId : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	materialId : "<font style='color: red;'><b>Material Name is Required</b></font>",
																	uomId : "<font style='color: red;'><b>Uom Name is Required</b></font>",
																	inspTypeId : "<font style='color: red;'><b>Inspection Type is Required</b></font>",
																	inspLotOriginId : "<font style='color: red;'><b>Inspection Lot Origin is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	desc : "<font style='color: red;'><b>Description is Required</b></font>"
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
																	inspLotNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	refNo : {
																		required : true
																	},
																	quantity : {
																		required : true,
																		number : true
																	},
																	batchNo : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	materialId : {
																		required : true
																	},
																	uomId : {
																		required : true
																	},
																	inspTypeId : {
																		required : true
																	},
																	inspLotOriginId : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	desc : {
																		required : true
																	}
																},
																messages : {
																	inspLotNo : {
																		required : "<font style='color: red;'><b>Inspection Lot No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	refNo : "<font style='color: red;'><b>Reference No is Required</b></font>",
																	quantity : {
																		required : "<font style='color: red;'><b>Quantity is Required</b></font>",
																		number : "<font style='color: red;'><b>Quantity Allows Only Numbers</b></font>"
																	},
																	batchNo : "<font style='color: red;'><b>Batch No is Required</b></font>",
																	plantId : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	materialId : "<font style='color: red;'><b>Material Name is Required</b></font>",
																	uomId : "<font style='color: red;'><b>Uom Name is Required</b></font>",
																	inspTypeId : "<font style='color: red;'><b>Inspection Type is Required</b></font>",
																	inspLotOriginId : "<font style='color: red;'><b>Inspection Lot Origin is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	desc : "<font style='color: red;'><b>Description is Required</b></font>"
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
			$('#inspLotNo').focus();
			$('#inspLotNo').val('');
			$('#plantId').val('');
			$('#materialId').val('');
			$('#inspTypeId').val('');
			$('#inspLotOriginId').val('');
			$('#refNo').val('');
			$('#quantity').val('');
			$('#uomId').val('');
			$('#batchNo').val('');
			$('#desc').val('');

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
	function qtyTest(id) {
		if (id == 'A') {
			var qty = $('#quantity').val();
			var avalQty = $('#avalQty').val();
			//alert(qty + " " + avalQty);
			if (parseFloat(qty) > parseFloat(avalQty)) {
				document.getElementById("salesDuplMessage").style.display = "block";
				$('#salesDuplMessage')
						.html(
								"Quantity Must be Less Than or equal to Available Quantity");
				$('#subtnId').hide();

			} else {
				document.getElementById("salesDuplMessage").style.display = "none";
				$('#subtnId').show();
			}

		} else {
			var qty = $('#quantityEdit').val();
			var avalQty = $('#avalQtyEdit').val();
			//alert(qty + " " + avalQty);
			if (parseFloat(qty) > parseFloat(avalQty)) {
				document.getElementById("salesUpDuplMessage").style.display = "block";
				$('#salesUpDuplMessage')
						.html(
								"Quantity Must be Less Than or equal to Available Quantity");
				$('#updated').hide();

			} else {
				document.getElementById("salesUpDuplMessage").style.display = "none";
				$('#updated').show();
			}
		}
	}
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
	function ForMaterialIds(id) {
		var i = 1;
		if (id == 'A') {
			var ref = $('#refNo').val();
			//alert(ref);
			$.ajax({
				type : "POST",
				url : "getMaterialIds.mnt",
				data : "refNo=" + ref,

				success : function(response) {
					mat = $('#materialId').empty();
					mat.append(new Option("-Select-", ""));
					$.each(response, function(key, value) {
						//alert(value);
						if (i == 1) {
							mat.append(new Option(value, key));
						} else {
							mat.append(new Option(value, key));
						}
						i++;

					});

				},

				error : function(e) {
					alert('Error' + e);
				}

			});
		} else {
			var ref = $('#refNoEdit').val();
			//alert(ref);
			$.ajax({
				type : "POST",
				url : "getMaterialIds.mnt",
				data : "refNo=" + ref,

				success : function(response) {
					mat = $('#materialIdEdit').empty();
					mat.append(new Option("-Select-", ""));
					$.each(response, function(key, value) {
						//alert(value);
						if (i == 1) {
							mat.append(new Option(value, key));
						} else {
							mat.append(new Option(value, key));
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

	function AjaxBatchNos() {
		var i = 1;
		var matId = $('#materialId').val();
		//alert(matId);

		$.ajax({
			type : "POST",
			url : "getBatchNo.mnt",
			data : "materialId=" + matId,
			success : function(response) {
				var match = "";
				match = $('#batchNo').empty();
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
	function AjaxBatchNosEdit() {
		var i = 1;
		var matId = $('#materialIdEdit').val();
		//alert(matId);

		$.ajax({
			type : "POST",
			url : "getBatchNo.mnt",
			data : "materialId=" + matId,
			success : function(response) {
				var match = "";
				match = $('#batchNoEdit').empty();
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
		var baId = $('#batchNo').val();
		//alert(matId+" "+baId);
		$.ajax({
			type : "POST",
			url : "getGRLQty.mnt",
			data : "materialId=" + matId + "&batchNo=" + baId,
			success : function(response) {
				$('#avalQty').val(response);

			},
			error : function(e) {
				alert('Error' + e);
			}

		});

	}
	function AjaxGetQtyEdit() {

		var matId = $('#materialIdEdit').val();
		var baId = $('#batchNoEdit').val();
		//alert(matId+" "+baId);
		$.ajax({
			type : "POST",
			url : "getGRLQty.mnt",
			data : "materialId=" + matId + "&batchNo=" + baId,
			success : function(response) {
				$('#avalQtyEdit').val(response);

			},
			error : function(e) {
				alert('Error' + e);
			}

		});

	}

	function AjaxGetRefNos() {
		var i = 1;
		var lotOrigin = $('#inspLotOriginId').val();
		//alert(lotOrigin);
		$.ajax({
			type : "POST",
			url : "getRefNos.mnt",
			data : "lotOriginId=" + lotOrigin,
			success : function(response) {
				var match = "";
				match = $('#refNo').empty();
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
	function AjaxGetRefNosEdit() {
		var i = 1;
		var lotOrigin = $('#inspLotOriginIdEdit').val();
		//alert(lotOrigin);
		$.ajax({
			type : "POST",
			url : "getRefNos.mnt",
			data : "lotOriginId=" + lotOrigin,
			success : function(response) {
				var match = "";
				match = $('#refNoEdit').empty();
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
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Inspection Lot</div>
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
					<form:form method="get" action="inspLotSearch.mnt"
						commandName="inspLotCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addLotsus"
										items="${param.addLotsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.insplot" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="addLotFail"
										items="${param.addLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.insplot" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateLotssus"
										items="${param.updateLotssus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.insplot" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="updateLotFail"
										items="${param.updateLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.insplot" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteLotsus"
										items="${param.DeleteLotsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.insplot" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach var="DeleteLotFail"
										items="${param.DeleteLotFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.insplot" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr id="mainSearch">
								<td width="12%"><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="inspLotCmd.operations">
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
							<form:form action="inspAdvanceSearch.mnt" method="get"
								commandName="inspLotCmd" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="inspAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form>

						</table>
						<form:form action="inspAdvanceSearchOperations.mnt"
							commandName="inspLotCmd" method="get">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue" items="${stAdv}">
										<tr>
											<td><label>${xmlLabelValue.labels}</label> <form:hidden
													path="dbField" id="dbField"
													value="${xmlLabelValue.dbField}" /></td>
											<td><spring:bind path="inspLotCmd.asOpts">
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
											<td><spring:bind path="inspLotCmd.asOpts">
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
											<c:set var="materialId" value="materialId" />
											<c:set var="plantId" value="plantId" />
											<c:set var="inspLotOriginId" value="inspLotOriginId" />
											<c:if test="${bdField eq materialId}">
												<c:set var="selectBox" value="${materialSelect}" />
											</c:if>
											<c:if test="${bdField eq plantId}">
												<c:set var="selectBox" value="${PlantSelect}" />
											</c:if>
											<c:if test="${bdField eq inspLotOriginId}">
												<c:set var="selectBox" value="${InsplotOriginSelect}" />
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

					<c:if test="${LOTList!=null }">
						<c:choose>
							<c:when test="${Adv!=null}">
								<c:set var="search" value="inspAdvanceSearchOperations.mnt" />
							</c:when>
							<c:otherwise>
								<c:set var="search" value="inspLotSearch.mnt" />
							</c:otherwise>
						</c:choose>
						<display:table name="LOTList" id="LOTIDList" class="table"
							requestURI="${search}" pagesize="5">
							<display:column property="inspLotNoId" sortable="true"
								title="inspLotId" media="none" />

							<display:column property="inspLotNo" sortable="true"
								titleKey="label.insplno" media="html" />
							<display:column property="refNo" sortable="true"
								titleKey="label.insplref" media="html" />

							<display:column property="quantity" sortable="true"
								titleKey="label.insplqty" media="html" />
							<display:column property="batchNo" sortable="true"
								titleKey="label.inspbn" media="html" />

							<display:column property="plantId" sortable="true"
								titleKey="label.insplplant" media="html" />

							<display:column property="materialId" sortable="true"
								titleKey="label.insplmt" media="html" />

							<display:column property="uomId" sortable="true"
								titleKey="label.inspluom" media="html" />

							<display:column property="inspTypeId" sortable="true"
								titleKey="label.inspltype" media="html" />

							<display:column property="inspLotOriginId" sortable="true"
								titleKey="label.insplorg" media="html" />

							<display:column property="statusId" sortable="true"
								titleKey="label.insplsts" media="html" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit }">

										<a
											href="inspLotEdit.mnt?inspLotNoId=<c:out value="${LOTIDList.inspLotNoId}"/> "><img
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
											href="inspLotDelete.mnt?inspLotNoId=<c:out value="${LOTIDList.inspLotNoId}"/> "
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
					<form:form action="inspLotAdd.mnt" id="addForm" method="POST"
						commandName="inspLotCmd">
						<table class="tableGeneral">
							<tr>
								<td><spring:message code="label.insplno" /><span
									class="required">*</span></td>
								<td><form:input path="inspLotNo" class="textbox"
										id="inspLotNo" maxlength="50" onkeyup="AjaxForDuplicate()" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.insplorg" /><span
									class="required">*</span></td>
								<td><form:select path="inspLotOriginId" class="select"
										id="inspLotOriginId" onchange="AjaxGetRefNos()">
										<form:option value="">-Select-</form:option>
										<form:options items="${InsplotOriginSelect}" />
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.insplref" /><span
									class="required">*</span></td>
								<td><form:select path="refNo" class="select" id="refNo"
										onchange="ForMaterialIds('A')">
										<form:option value="">-Select-</form:option>
										<%-- <form:options items="${refNos}" /> --%>
									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.insplplant" /><span
									class="required">*</span></td>
								<td><form:select path="plantId" class="select" id="plantId">
										<form:option value="">-Select-</form:option>
										<form:options items="${PlantSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.insplmt" /><span
									class="required">*</span></td>
								<td><form:select path="materialId" class="select"
										id="materialId" onchange="AjaxBatchNos(),AjaxGetQty()">
										<form:option value="">-Select-</form:option>

									</form:select></td>

							</tr>

							<tr>
								<td><spring:message code="label.inspbn" /><span
									class="required">*</span></td>
								<td><form:select path="batchNo" class="select" id="batchNo"
										onchange="AjaxGetQty()">
										<form:option value="">-Select-</form:option>
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.stralqty" /><span
									class=required></span></td>
								<td><form:input path="avalQty" id="avalQty" class="textbox"
										readonly="true" /></td>
							</tr>

							<tr>
								<td><spring:message code="label.insplqty" /><span
									class="required">*</span></td>
								<td><form:input path="quantity" class="textbox"
										id="quantity" onkeyup="qtyTest('A')" maxlength="21" /></td>

							</tr>

							<tr>
								<td><spring:message code="label.inspluom" /><span
									class="required">*</span></td>
								<td><form:select path="uomId" class="select" id="uomId">
										<form:option value="">-Select-</form:option>
										<form:options items="${uomSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.inspltype" /><span
									class="required">*</span></td>
								<td><form:select path="inspTypeId" class="select"
										id="inspTypeId">
										<form:option value="">-Select-</form:option>
										<form:options items="${inspTypeSelect}" />
									</form:select></td>

							</tr>


							<tr>
								<td><spring:message code="label.insplsts" /><span
									class="required">*</span></td>
								<td><form:select path="statusId" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${statusSelect}" />
									</form:select></td>

							</tr>
							<tr>
								<td><spring:message code="label.inspldec" /><span
									class="required">*</span></td>
								<td><form:textarea path="desc" class="textbox" id="desc"
										maxlength="250" /></td>

							</tr>
						</table>
						<!--Sub Tab Start  -->
						<div id="childTabs" align="left">
							<ul>
								<li><a href="#tab1"><spring:message
											code="label.insploth" /></a></li>
							</ul>

							<div id="tab1">
								<div align="center">
									<script>
										var poptrid = 1;
										$(function() {
											var eqpId = $("#eqpId"), hiddenID = $("#hiddenIdPOPPopUp"), allFields = $(
													[]).add(eqpId)
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

											function selectLength(o, n) {
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
																height : 260,
																width : 320,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields
																				.removeClass("ui-state-error");

																		bValid = bValid
																				&& selectLength(
																						eqpId,
																						"Equipment Name");

																		if (bValid) {

																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {

																				$(
																						"#POPAdd tbody")
																						.append(
																								"<tr id="+poptrid+">"

																										+ "<td ><input type='hidden' name='equipmentId' id='eqpId"
																										+ poptrid
																										+ "' value="
																										+ eqpId
																												.val()
																										+ "  class='textbox'readonly/><input type='text' name='eqpName' id='eqpName"
																										+ poptrid
																										+ "' value="
																										+ $(
																												'#eqpId :selected')
																												.text()

																										+ "  class='textbox'readonly/></td>"

																										+ "<td><a href='#'  onclick='editPopEqp("
																										+ poptrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removePopEqp("
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
																						'#eqpId'
																								+ hiddenID
																										.val())
																						.val(
																								eqpId
																										.val());
																				$(
																						'#eqpName'
																								+ hiddenID
																										.val())
																						.val(
																								$(
																										'#eqpId :selected')
																										.text());

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

											$("#create-AddPOP")
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
										function removePopEqp(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editPopEqp(id) {
											//alert("edit row " + id);
											$(".validateTips").text('');
											$("#dialog-form-POP")
													.dialog("open");

											$('#eqpId').val(
													$('#eqpId' + id).val());
											$('#eqpName').val(
													$('#eqpName' + id).val());

											$('#hiddenIdPOPPopUp').val(id);

										}
									</script>
									<div id="dialog-form-POP"
										title="<spring:message code="label.insploth"/>">
										<p class="validateTips"></p>
										<table class="tableGeneral">

											<tr>
												<td><spring:message code="label.insploteqp" /><font
													color="red">*</font></td>
												<td><form:select path="eqpName" id="eqpId"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${equipmentSelect }" />
													</form:select> <input type="hidden" name="hiddenIdPOPPopUp"
													id="hiddenIdPOPPopUp" value="0" /></td>
											</tr>


										</table>
									</div>


									<div id="users-contain-POP">
										<table id="POPAdd" class="table">
											<thead>
												<tr>

													<th><spring:message code="label.insploteqp" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									</div>
									<button id="create-AddPOP" type="button">
										<spring:message code="label.insplotadd" />
									</button>

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

						<form:form method="post" action="inspLotUpdate.mnt"
							commandName="inspLotCmd" id="editForm">
							<table class="tableGeneral">

								<form:hidden path="inspLotNoId" id="inspLotNoIdEdit" />
								<tr>
									<td><spring:message code="label.insplno" /><span
										class="required">*</span></td>
									<td><form:input path="inspLotNo" id="inspLotNoEdit"
											class="textbox" maxlength="50"
											onkeyup="AjaxUpdateDuplicate()" /></td>

								</tr>

								<tr>
									<td><spring:message code="label.insplorg" /><span
										class="required">*</span></td>
									<td><form:select path="inspLotOriginId" class="select"
											id="inspLotOriginIdEdit" onchange="AjaxGetRefNosEdit()">
											<form:option value="">-Select-</form:option>
											<form:options items="${InsplotOriginSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.insplref" /><span
										class="required">*</span></td>
									<td><form:select path="refNo" id="refNoEdit"
											class="select" onchange="ForMaterialIds('E')">
											<form:option value="">-Select-</form:option>
											<form:options items="${refNos}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.insplplant" /><span
										class="required">*</span></td>
									<td><form:select path="plantId" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${PlantSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.insplmt" /><span
										class="required">*</span></td>
									<td><form:select path="materialId" class="select"
											id="materialIdEdit"
											onchange="AjaxBatchNosEdit(),AjaxGetQtyEdit()">
											<form:option value="">-Select-</form:option>
											<form:options items="${materialSelect}" />
										</form:select></td>

								</tr>

								<tr>
									<td><spring:message code="label.inspbn" /><span
										class="required">*</span></td>
									<td><form:select path="batchNo" class="select"
											id="batchNoEdit" onchange="AjaxGetQtyEdit()">
											<form:option value="">-Select-</form:option>
											<form:options items="${selectBatchNos}" />
										</form:select></td>


								</tr>
								<tr>
									<td><spring:message code="label.stralqty" /><span
										class=required></span></td>
									<td><form:input path="avalQty" id="avalQtyEdit"
											class="textbox" readonly="true" /></td>
								</tr>

								<tr>
									<td><spring:message code="label.insplqty" /><span
										class="required">*</span></td>
									<td><form:input path="quantity" class="textbox"
											id="quantityEdit" onkeyup="AjaxGetQtyEdit(),qtyTest('E')"
											maxlength="21" /></td>

								</tr>


								<tr>
									<td><spring:message code="label.inspluom" /><span
										class="required">*</span></td>
									<td><form:select path="uomId" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${uomSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.inspltype" /><span
										class="required">*</span></td>
									<td><form:select path="inspTypeId" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${inspTypeSelect}" />
										</form:select></td>

								</tr>

								<tr>
									<td><spring:message code="label.insplsts" /><span
										class="required">*</span></td>
									<td><form:select path="statusId" class="select"
											id="inspLotOriginId">
											<form:option value="">-Select-</form:option>
											<form:options items="${statusSelect}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.inspldec" /><span
										class="required">*</span></td>
									<td><form:textarea path="desc" class="textbox"
											maxlength="250" /></td>
								</tr>
							</table>

							<!-- Sub tab in edit -->
							<div id="childTabs" align="left">
								<ul>
									<li><a href="#tab1"><spring:message
												code="label.insploth" /></a></li>
								</ul>

								<div id="tab1">

									<div align="center">
										<script>
											var btrid = 10;
											$(function() {

												var eqpIdEdit = $("#eqpIdEdit"), hiddenEdit = $("#hiddenIdEqpPopUpEdit"),

												allFields = $([])
														.add(eqpIdEdit).add(
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
												function required(o, n) {
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
																	height : 260,
																	width : 300,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");
																			bValid1 = bValid1
																					&& required(
																							eqpIdEdit,
																							"Equipment Name is Required");

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
																											+ "<td ><spring:bind path='inspLotCmd.equipmentId'><input type='hidden' name='equipmentId' id='eqpIdEdit"
																											+ btrid
																											+ "' value="
																											+ eqpIdEdit
																													.val()
																											+ "  class='textbox'readonly/></spring:bind><input type='text' name='eqpName' id='eqpNameEdit"
																											+ btrid
																											+ "' value="
																											+ $(
																													'#eqpIdEdit :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"

																											+ "<input type='hidden' name='inspLotEqpId' id='inspLotEqpIdEdit' value='0'/></td>"
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
																					$(
																							'#eqpIdEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#eqpIdEdit')
																											.val());
																					$(
																							'#eqpNameEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#eqpIdEdit :selected')
																											.text());
																					$(
																							'#hiddenIdEqpPopUpEdit')
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
											function editEqpInEditNew(link) {
												//alert(link);
												$(".validateTips").text('');
												$("#dialog-form-EqpEdit")
														.dialog("open");
												$('#eqpIdEdit').val(
														$('#eqpIdEdit' + link)
																.val());
												$('#eqpNameEdit')
														.val(
																$(
																		'#eqpNameEdit'
																				+ link)
																		.val());
												$('#hiddenIdEqpPopUpEdit').val(
														link);

											}
										</script>
										<div id="dialog-form-EqpEdit"
											title="<spring:message code="label.insploth"/>">
											<p class="validateTips"></p>
											<table class="tableGeneral">
												<form:hidden path="inspLotEqpId" value="0" />
												<tr>
													<td><spring:message code="label.insploteqp" /><font
														color="red">*</font></td>
													<td><form:select path="eqpName" id="eqpIdEdit"
															class="select">
															<form:option value="">-Select-</form:option>
															<form:options items="${equipmentSelect }" />
														</form:select><input type="hidden" name="hiddenIdEqpPopUpEdit"
														id="hiddenIdEqpPopUpEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-contain-EqpEdit">
											<table id=AddEqpEdit class="table">
												<thead>
													<tr>

														<th><spring:message code="label.insploteqp" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>

													</tr>
												</thead>
												<tbody>
													<c:forEach var="eqpEditList" items="${inspLotEqpEdit}">

														<tr id="${eqpEditList.inspLotEqpId}">

															<spring:bind path="inspLotCmd.inspLotEqpId">
																<input type="hidden" name="inspLotEqpId" class="textbox"
																	value="${eqpEditList.inspLotEqpId}"
																	id="inspLotEqpId${eqpEditList.inspLotEqpId}" />
															</spring:bind>

															<spring:bind path="inspLotCmd.equipmentId">
																<input type="hidden" name="equipmentId" class="textbox"
																	value="${eqpEditList.equipmentId}"
																	id="eqpIdEdit${eqpEditList.inspLotEqpId}" />
															</spring:bind>

															<td><spring:bind path="inspLotCmd.eqpName">
																	<input type="text" name="eqpName" class="textbox"
																		readonly="readonly" value="${eqpEditList.eqpName}"
																		id="eqpNameEdit${eqpEditList.inspLotEqpId}" />
																</spring:bind> <input type='hidden'
																name="${eqpEditList.inspLotEqpId}Check"
																id="${eqpEditList.inspLotEqpId}Check" value="0" /></td>


															<td><a href="#" id="${eqpEditList.inspLotEqpId}"
																onclick="javascript:editPOPDetailsInEdit(this)"><img
																	src="images/Edit.jpg" height="25px" width="25px"
																	id="edit${eqpEditList.inspLotEqpId}"></img></a></td>
															<td><a href="#" id="${eqpEditList.inspLotEqpId}"
																onclick="javascript:getID1(this)"><img
																	src="images/button_cancel.png" height="25px"
																	width="25px" id="${eqpEditList.inspLotEqpId}"></img></a></td>
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
																//alert(link.id);

																$(
																		"#dialog-form-EqpEdit")
																		.dialog(
																				"open");

																$('#eqpIdEdit')
																		.val(
																				$(
																						'#eqpIdEdit'
																								+ link.id)
																						.val());

																$(
																		'#hiddenIdEqpPopUpEdit')
																		.val(
																				link.id);

															}
														</script>

													</c:forEach>

												</tbody>

											</table>
										</div>
										<button id="create-AddEqpEdit" type="button">
											<spring:message code="label.insplotadd" />
										</button>

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
