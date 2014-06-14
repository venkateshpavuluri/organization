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

											$('#addvendorReturnform')
													.validate(
															{
																rules : {
																	vendorReturnNo : {
																		required : true
																	},
																	vendorReturnDate : {
																		required : true
																	},
																	reference : {
																		required : true
																	},
																	description : {
																		required : true
																	},
																	purchaseOrderId : {
																		required : true
																	},
																	goodsReceiptId : {
																		required : true
																	}

																},
																messages : {
																	vendorReturnNo : "<font style='color: red;'><b>Vendor Return No is Required</b></font>",
																	vendorReturnDate : "<font style='color: red;'><b>Vendor Return Date is Required</b></font>",
																	reference : "<font style='color: red;'><b>Reference is Required</b></font>",
																	description : "<font style='color: red;'><b>Description is Required</b></font>",
																	purchaseOrderId : "<font style='color: red;'><b>Purchase Order is Required</b></font>",
																	goodsReceiptId : "<font style='color: red;'><b>Goods Receipt No is Required</b></font>"

																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editvendorReturnForm')
													.validate(
															{
																rules : {
																	vendorReturnNoEditt : {
																		required : true
																	},
																	vendorReturnDateEditt : {
																		required : true
																	},
																	referenceEditt : {
																		required : true
																	},
																	descriptionEditt : {
																		required : true
																	},
																	purchaseOrderIdEditt : {
																		required : true
																	},
																	goodsReceiptIdEdit : {
																		required : true
																	}

																},
																messages : {
																	vendorReturnNoEditt : "<font style='color: red;'><b>Vendor Return No is Required</b></font>",
																	vendorReturnDateEditt : "<font style='color: red;'><b>Vendor Return Date is Required</b></font>",
																	referenceEditt : "<font style='color: red;'><b>Reference is Required</b></font>",
																	descriptionEditt : "<font style='color: red;'><b>Description is Required</b></font>",
																	purchaseOrderIdEditt : "<font style='color: red;'><b>Purchase Order is Required</b></font>",
																	goodsReceiptIdEdit : "<font style='color: red;'><b>Goods Receipt No is Required</b></font>",

																},

															});

										});

						$('#purchaseOrderId').change(function() {
							var i = 1;
							var poId = $('#purchaseOrderId').val();

							$.ajax({

								type : "POST",

								url : "getMatIds.mnt",

								data : "purOrderId=" + poId,

								success : function(response) {
									//alert(response);
									mat = $('#mId').empty();
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
									alert("Error" + e);

								}

							});

						});
						$('#purchaseOrderIdEditt').change(function() {
							var i = 1;
							var poId = $('#purchaseOrderIdEditt').val();

							$.ajax({

								type : "POST",

								url : "getMatIds.mnt",

								data : "purOrderId=" + poId,

								success : function(response) {
									//alert(response);
									mat = $('#mIdEditt').empty();
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
									alert("Error" + e);

								}

							});

						});

					});
</script>

<script type="text/javascript">
	function doAjaxPostEdit() {

		var vendorReturnNo = $('#vendorReturnNoEditt').val();

		var vid = $('#vendorReturnIdEditt').val();

		$
				.ajax({

					type : "POST",

					url : "vendorReturnDuplicateEditCheck.mnt",

					data : "vendorReturnNo=" + vendorReturnNo + "&vid=" + vid,

					success : function(response) {

						var checkResponse = "Vendor Return Number is Already Exists Please try some other number";

						if (response != "") {
							document.getElementById("editmessage").style.display = "block";
							//$('#editmessage').html(response);
						} else {
							document.getElementById("editmessage").style.display = "none";
						}
					},

					error : function(e) {
						alert("Error" + e);

					}

				});

	}

	function RejQty(value) {
		if (value == 'A') {

			var poId = $('#purchaseOrderId').val();
			var grId = $('#goodsReceiptId').val();
			var mtId = $('#mId').val();
			var bNo = $('#batchNo').val();
			//alert(grId+" "+mtId+ " "+bNo);
			$.ajax({

				type : "POST",

				url : "getRejQty.mnt",

				data : "purOrderId=" + poId + "&grId=" + grId + "&mtId=" + mtId
						+ "&bNo=" + bNo,

				success : function(response) {
					//alert(response);
					$('#rejQty').val(response);

				},

				error : function(e) {
					alert("Error" + e);

				}

			});
		} else {
			var poId = $('#purchaseOrderIdEditt').val();
			var grId = $('#goodsReceiptIdEdit').val();
			var mtId = $('#mIdEditt').val();
			var bNo = $('#batchNoEdit').val();
			//alert(poId);
			$.ajax({

				type : "POST",

				url : "getRejQty.mnt",

				data : "purOrderId=" + poId + "&grId=" + grId + "&mtId=" + mtId
						+ "&bNo=" + bNo,

				success : function(response) {
					//alert(response);
					$('#rejQtyEdit').val(response);

				},

				error : function(e) {
					alert("Error" + e);

				}

			});
		}

	}
	function GetGoodsIds(value) {
		var i = 1;
		if (value == 'A') {

			var poId = $('#purchaseOrderId').val();

			$.ajax({

				type : "POST",
				url : "getGoodsIds.mnt",
				data : "purOrderId=" + poId,

				success : function(response) {
					//alert(response);
					mat = $('#goodsReceiptId').empty();
					mat.append(new Option("-Select-", ""));
					$.each(response, function(key, value) {
						//alert(key);
						if (i == 1) {
							mat.append(new Option(value, key));
						} else {
							mat.append(new Option(value, key));
						}
						i++;

					});

				},

				error : function(e) {
					alert("Error" + e);

				}

			});
		} else {
			var poId = $('#purchaseOrderIdEditt').val();
			//alert(poId);
			$.ajax({

				type : "POST",
				url : "getGoodsIds.mnt",
				data : "purOrderId=" + poId,

				success : function(response) {
					//alert(response);
					mat = $('#goodsReceiptIdEdit').empty();
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
					alert("Error" + e);

				}

			});
		}

	}

	function GetBatchNos(value) {
		var i = 1;
		if (value == 'A') {

			var grId = $('#goodsReceiptId').val();

			$.ajax({

				type : "POST",
				url : "getBatchNos.mnt",
				data : "grId=" + grId,

				success : function(response) {
					//alert(response);
					mat = $('#batchNo').empty();
					mat.append(new Option("-Select-", ""));
					$.each(response, function(key, value) {
						//alert(key);
						if (i == 1) {
							mat.append(new Option(value, key));
						} else {
							mat.append(new Option(value, key));
						}
						i++;

					});

				},

				error : function(e) {
					alert("Error" + e);

				}

			});
		} else {
			var grId = $('#goodsReceiptIdEdit').val();
			//alert(poId);
			$.ajax({

				type : "POST",
				url : "getBatchNos.mnt",
				data : "grId=" + grId,

				success : function(response) {
					//alert(response);
					mat = $('#batchNoEdit').empty();
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
					alert("Error" + e);

				}

			});
		}

	}
</script>
<script type="text/javascript">
	function doAjaxPost() {

		var vendorReturnNo = $('#vendorReturnNo').val();
		//alert(vendorReturnNo);

		$
				.ajax({

					type : "POST",

					url : "vendorReturnDuplicateAddCheck.mnt",

					data : "vendorReturnNo=" + vendorReturnNo,

					success : function(response) {
						var checkResponse = "Vendor Return Number is Already Exists Please try some other number";

						if (response != "") {
							document.getElementById("addmessage").style.display = "block";
							//$('#addmessage').html(response);
						} else {
							document.getElementById("addmessage").style.display = "none";
						}
					},

					error : function(e) {
						alert("Error" + e);

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

		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});

	function dateFun(datePattern) {
		$("#vendorReturnDate,#vendorReturnDateEditt").datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
		});

	}
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
	width: 89%;
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
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Vendor Return</div>

		<!-- Tabs Declaration -->
		
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="vrEditList" items="${vrEditList}">
						<c:set var="vrEditList" value="${vrEditList }"></c:set>
					</c:forEach>
					<c:if test="${vrEditList!=null}">

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
						<form:form action="vendorReturnSearch.mnt" method="GET"
							commandName="vendorReturnCommand">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="vendorReturnAdd"
											items="${param.Addsuccess}">
											<div class="alert-success" id="savemessage">
												<strong><spring:message code="label.success" /> </strong>
												<spring:message code="label.vreturn" />
												<spring:message code="label.saveSuccess" />
											</div>
										</c:forEach> <c:forEach var="vendorReturnAdd" items="${param.AddFail}">
											<div class="alert-danger" id="savemessage">
												<strong><spring:message code="label.error" /> </strong>
												<spring:message code="label.vreturn" />
												<spring:message code="label.saveFail" />
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="vendorReturnUpdated"
											items="${param.updateSuccess}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /> </strong>
												<spring:message code="label.vreturn" />
												<spring:message code="label.updateSuccess" />
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="vendorReturnUpdated"
											items="${param.updateFail}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /> </strong>
												<spring:message code="label.vreturn" />
												<spring:message code="label.updateSuccess" />
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="vendorReturnUpdateFail"
											items="${param.deleteSuccess}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success" /> </strong>
												<spring:message code="label.vreturn" />
												<spring:message code="label.deleteSuccess" />
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="vendorReturnUpdateFail"
											items="${param.deleteFail}">
											<div class="alert-warning" id="successmessage">
												<strong><spring:message code="label.error" /> </strong>
												<spring:message code="label.vreturn" />
												<spring:message code="label.deleteFail" />
											</div>
										</c:forEach></td>
								</tr>
								<tr id="mainSearch">
									<td><spring:message code="label.searchby" /> <form:select
											path="xmlLabel" cssClass="select">

											<form:options items="${xmlItems}" />
										</form:select> <spring:bind path="vendorReturnCommand.operations">
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
										</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>


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
								<form:form action="vendorReturnAdvanceSearch.mnt" method="get"
									commandName="vendorReturnCommand" name="advanceSearchFinal"
									id="advanceSearchFinal">
									<tr>
										<td><a href="vendorReturnAdvanceSearch.mnt"><font
												style="color: blue" id="aslink"><u><b>Advanced
															Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
												style="color: blue"><u><b>Back To Basic
															Search</b></u></font></a></td>

									</tr>
								</form:form>
							</table>

							<form:form action="vendorReturnAdvanceSearchOperations.mnt"
								commandName="vendorReturnCommand">
								<div id="advanceSearchDiv" style="display: none">
									<table class="tableGeneral">
										<c:forEach var="xmlLabelValue"
											items="${vendorReturnSearchAdvance}">
											<tr>
												<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
														path="firstLabel" id="firstLabel"
														value="${xmlLabelValue.firstLabel}" /></td>
												<td><spring:bind path="vendorReturnCommand.operations1">
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
											<td colspan="3"><input type="submit"
												id="advanceSearchButtonId" value="Advance Search"
												style="display: none" class="btn btn-primary" /></td>
										</tr>

									</table>

								</div>
							</form:form>

						</form:form>

						<c:if test="${vendorReturnSearch!=null}">
							<display:table id="vendorReturnValue" name="vendorReturnSearch"
								requestURI="vendorReturnSearch.mnt" pagesize="5" class="table">
								<!-- Displaying  the Searched information by using display tag -->
								<display:column property="vendorReturnNo"
									titleKey="label.vendorreturnno" media="html" sortable="true" />

								<display:column property="vendorReturnDate"
									titleKey="label.vendorreturndate" media="html" sortable="true" />

								<display:column property="reference" titleKey="label.reference"
									media="html" sortable="true" />

								<display:column property="description" titleKey="label.desc"
									media="html" sortable="true" />

								<display:column property="purchaseOrderId"
									titleKey="label.purchaseorderno" media="html" sortable="true" />

								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${edit}">
											<a
												href="vendorReturnIdEdit1.mnt?vendorReturnId=<c:out value="${vendorReturnValue.vendorReturnId}"/>"
												style="color: red"><img src="images/Edit.jpg"
												width="20px" height="20px" /> </a>
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
												href="vendorReturnIdDelete.mnt?vendorReturnId=<c:out value="${vendorReturnValue.vendorReturnId}"/>"
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
						<table>
							<tr>

								<td colspan="2" id="addmessage" style="display: none;">
									<div class="alert-warning">
										<strong> <spring:message code="label.warning" /></strong>
										<spring:message code="label.vendorreturnno" />
										<spring:message code="label.duplicateCheck" />
									</div>

								</td>
							</tr>
						</table>
						<form:form action="vendorReturn.mnt" method="GET"
							commandName="vendorReturnCommand" id="addvendorReturnform">

							<table class="tableGeneral">
								<form:hidden path="aid" />
								<tr>
									<td colspan="2"><c:forEach var="addVendorReturnDuplicate"
											items="${addVendorReturnDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong>Warning!</strong> <font color="#C09853"><c:out
														value="${addVendorReturnDuplicate}" /></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="vendorReturnIdEditt" />
								<form:hidden path="vendorReturnLineIdEditt" />

								<tr>
									<td><spring:message code="label.vendorreturnno" /><font
										color="red">*</font></td>
									<td><form:input path="vendorReturnNo" id="vendorReturnNo"
											class="textbox" onkeyup="doAjaxPost()" maxlength="50" /></td>

								</tr>
								<tr>
									<td><spring:message code="label.vendorreturndate" /><font
										color="red">*</font></td>
									<td><form:input path="vendorReturnDate"
											id="vendorReturnDate" class="textbox" name="date" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.reference" /><font
										color="red">*</font></td>
									<td><form:input path="reference" id="reference"
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.desc" /><font color="red">*</font>
									</td>
									<td><form:textarea path="description" id="description"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.purchaseorder" /><font
										color="red">*</font></td>
									<td><form:select path="purchaseOrderId" class="select"
											id="purchaseOrderId" onchange="GetGoodsIds('A')">
											<form:option value="">-Select-</form:option>
											<form:options items="${purchaseorder}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.vgreceipt" /><font
										color="red">*</font></td>
									<td><form:select path="goodsReceiptId" class="select"
											id="goodsReceiptId" onchange="GetBatchNos('A')">
											<form:option value="">-Select-</form:option>
											<%-- <form:options items="${purchaseorder}" /> --%>
										</form:select></td>
								</tr>

							</table>

							<!-- Sub tabbing for adding Vendor Return details -->
							<div id="tabsForAdd">
								<div id="scroll1">
									<!-- Vendor Return Line tab -->
									<ul>
										<li><a href="#subtabs-1"><spring:message
													code="label.vedorreturnline" /> </a></li>

									</ul>

									<div align="center">

										<script>
											var bltrid = 1;
											$(function() {

												var mId = $("#mId"), mvalue = $("#mNumber"), batchNo = $('#batchNo'), rejQty = $("#rejQty"), quantity = $("#quantity"), uomm = $("#uomm"), uvalue = $("#uNumber"), price = $("#price"), rfrId = $("#rfrId"), rfrvalue = $("#rfrNumber"), stLId = $("#stLId"), stLvalue = $("#stLNumber"),

												hiddenID = $("#hiddenIdVendorReturnPopUp"),

												allFields = $([]).add(mId).add(
														mvalue).add(quantity)
														.add(batchNo).add(uomm)
														.add(uvalue).add(price)
														.add(rfrId).add(
																rfrvalue).add(
																stLId).add(
																stLvalue).add(
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
												function qty(o, k, n) {
													var qty = parseInt(o.val());
													var rqty = parseInt(k.val());
													if (qty != 0) {
														if (qty <= rqty) {
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
														"#dialog-form-VendorReturnLine")
														.dialog(
																{
																	autoOpen : false,
																	height : 350,
																	width : 400,
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
																					&& selectLength(
																							batchNo,
																							"Batch No");
																			bValid = bValid
																					&& checkLength(
																							quantity,
																							"Quantity",
																							1,
																							16);
																			bValid = bValid
																					&& qty(
																							quantity,
																							rejQty,
																							"Returns Quantity");
																			bValid = bValid
																					&& selectLength(
																							uomm,
																							"UOM");
																			bValid = bValid
																					&& checkLength(
																							price,
																							"Price",
																							1,
																							16);
																			bValid = bValid
																					&& selectLength(
																							rfrId,
																							"Reason For Rejection");
																			bValid = bValid
																					&& selectLength(
																							stLId,
																							"Storage Location");

																			bValid = bValid
																					&& checkRegexp(
																							price,
																							/^([0-9])+$/i,
																							"Price may consist of  0-9");

																			if (bValid) {

																				if (hiddenID
																						.val() == "0"
																						|| hiddenID
																								.val() == "") {

																					$(
																							"#vendorReturnLineAdd tbody")
																							.append(
																									"<tr id="+bltrid+">"
																											+ "<td ><input type='hidden' name='mId' id='mId"
																											+ bltrid
																											+ "' value="
																											+ mId
																													.val()
																											+ " class='textbox'/><input type='text' name='mNumber' id='mNumber"
																											+ bltrid
																											+ "' value="
																											+ $(
																													'#mId :selected')
																													.text()

																											+ "  class='textbox' readonly/> </td>"
																											+ "<td><input name='batchNo' id='batchNo"
																											+ bltrid
																											+ "' value="
																											+ batchNo
																													.val()
																											+ " class='textbox'readonly/></td>"
																											+ "<td><input name='quantity' id='quantity"
																											+ bltrid
																											+ "' value="
																											+ quantity
																													.val()
																											+ " class='textbox'readonly/></td>"
																											+ "<td><input type='hidden' name='uomm' id='uomm"
																											+ bltrid
																											+ "' value="
																											+ uomm
																													.val()
																											+ " class='textbox'/><input type='text' name='uNumber' id='uNumber"
																											+ bltrid
																											+ "' value="
																											+ $(
																													'#uomm :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"
																											+ "<td><input name='price' id='price"
																											+ bltrid
																											+ "' value="
																											+ price
																													.val()
																											+ " class='textbox' readonly/></td>"
																											+ "<td><input type='hidden' name='rfrId' id='rfrId"
																											+ bltrid
																											+ "' value="
																											+ rfrId
																													.val()
																											+ " class='textbox'/><input type='text' name='rfrNumber' id='rfrNumber"
																											+ bltrid
																											+ "' value="
																											+ $(
																													'#rfrId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"
																											+ "<td><input type='hidden' name='stLId' id='stLId"
																											+ bltrid
																											+ "' value="
																											+ stLId
																													.val()
																											+ " class='textbox'/><input type='text' name='stLNumber' id='stLNumber"
																											+ bltrid
																											+ "' value="
																											+ $(
																													'#stLId :selected')
																													.text()

																											+ "  class='textbox'readonly/></td>"
																											+ "<td><a href='#'  onclick='editMaterialm("
																											+ bltrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeMaterialm("
																											+ bltrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");

																					bltrid++;
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
																							'#batchNo'
																									+ hiddenID
																											.val())
																							.val(
																									batchNo
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
																							'#price'
																									+ hiddenID
																											.val())
																							.val(
																									price
																											.val());
																					$(
																							'#rfrId'
																									+ hiddenID
																											.val())
																							.val(
																									rfrId
																											.val());
																					$(
																							'#rfrNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#rfrId :selected')
																											.text());
																					$(
																							'#stLId'
																									+ hiddenID
																											.val())
																							.val(
																									stLId
																											.val());
																					$(
																							'#stLNumber'
																									+ hiddenID
																											.val())
																							.val(
																									$(
																											'#stLId :selected')
																											.text());

																					$(
																							'#hiddenIdVendorReturnPopUp')
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

												$("#create-AddVendorReturnLine")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-VendorReturnLine")
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

												$(
														"#dialog-form-VendorReturnLine")
														.dialog("open");

												$('#mId').val(
														$('#mId' + id).val());
												$('#mNumber').val(
														$('#mNumber' + id)
																.val());
												$('#batchNo').val(
														$('#batchNo' + id)
																.val());
												$('#quantity').val(
														$('#quantity' + id)
																.val());
												$('#uomm').val(
														$('#uomm' + id).val());
												$('#uNumber').val(
														$('#uNumber' + id)
																.val());
												$('#price').val(
														$('#price' + id).val());
												$('#rfrId').val(
														$('#rfrId' + id).val());
												$('#rfrNumber').val(
														$('#rfrNumber' + id)
																.val());
												$('#stLId').val(
														$('#stLId' + id).val());
												$('#stLNumber').val(
														$('#stLNumber' + id)
																.val());

												$('#hiddenIdVendorReturnPopUp')
														.val(id);

											}
										</script>


										<div id="dialog-form-VendorReturnLine"
											title="Add New Vendor Return Line Details">
											<p class="validateTips">All form fields are required.</p>
											<input type='hidden' id="mNumber" />
											<table class="tableGeneral">
												<tr>
													<td><spring:message code="label.qmaterial" /><font
														color="red">*</font></td>
													<td><form:select path="mId" class="select" id="mId"
															onchange="RejQty('A')">
															<form:option value="">-Select-</form:option>
															<%-- <form:options items="${material }" /> --%>
														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.vrbatchno" /><font
														color="red">*</font></td>
													<td><form:select path="batch" class="select"
															id="batchNo" onchange="RejQty('A')">
															<form:option value="">-Select-</form:option>
														</form:select></td>
												</tr>


												<tr>
													<td>Rejected Quantity<font color="red">*</font></td>
													<td><form:input path="rejQty" id="rejQty"
															class="textbox" readonly="true" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.vrqty" /><font
														color="red">*</font></td>
													<td><form:input path="quantity" id="quantity"
															class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.quom" /><font
														color="red">*</font></td>
													<td><form:select path="uomm" id="uomm" class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="uNumber" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.price" /><font
														color="red">*</font></td>
													<td><form:input path="price" id="price"
															class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.reasonforrejection" /><font
														color="red">*</font></td>
													<td><form:select path="rfrId" id="rfrId"
															class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${reasonforrejection }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="rfrNumber" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.storageLocation" /><font
														color="red">*</font></td>
													<td><form:select path="stLId" id="stLId"
															class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${storageId }" />
														</form:select></td>
												</tr>
												<tr>
													<td><input type='hidden' id="stLNumber" /><input
														type='hidden' id="hiddenIdVendorReturnPopUp"
														name="hiddenIdVendorReturnPopUp" value="0" /></td>
												</tr>
											</table>
										</div>

										<div id="users-contain-vendorReturnLine">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="vendorReturnLineAdd" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.qmaterial" /><font
															color="red"></font></th>
														<th><spring:message code="label.vrbatchno" /><font
															color="red"></font></th>
														<th><spring:message code="label.vrqty" /><font
															color="red"></font></th>
														<th><spring:message code="label.quom" /><font
															color="red"></font></th>
														<th><spring:message code="label.price" /><font
															color="red"></font></th>
														<th><spring:message code="label.reasonforrejection" /><font
															color="red"></font></th>
														<th><spring:message code="label.storageLocation" /><font
															color="red"></font></th>
														<th><spring:message code="label.edit" /><font
															color="red"></font></th>
														<th><spring:message code="label.delete" /><font
															color="red"></font></th>

													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
										<button id="create-AddVendorReturnLine" type="button">Add
											New Vendor Return Line</button>

									</div>
								</div>
							</div>
							<table>
								<tr>
									<c:choose>
										<c:when test="${save}">
											<td><input type="submit" id="sumbtnid"
												value='<spring:message code="label.save"/>'
												class="btn btn-primary" /><input type="reset"
												value='<spring:message code="label.reset"/>'
												class="btn btn-primary" /></td>
										</c:when>
										<c:otherwise>
											<td><input type="submit" id="sumbtnid"
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




				<!-- Edit tab -->

				<div id="tabs-1" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						<table>
							<tr>
								<td colspan="2" style="display: none;" id="editmessage">

									<div class="alert-warning">
										<strong> <spring:message code="label.warning" /></strong>
										<spring:message code="label.vendorreturnno" />
										<spring:message code="label.duplicateCheck" />
									</div>
								</td>
							</tr>
						</table>
						<form:form action="vendorReturnEdit.mnt" method="GET"
							commandName="vendorReturnCommand" id="editvendorReturnForm">
							<c:forEach var="vrEditList" items="${vrEditList}">
								<c:set var="editMode" value="${vrEditList}"></c:set>
							</c:forEach>

							<c:if test="${editMode!=null}">

								<table class="tableGeneral">

									<tr>
										<td colspan="2"><c:forEach
												var="updateVendorReturnDuplicate"
												items="${updateVendorReturnDuplicate}">
												<div class="alert-warning" id="savemessage">
													<strong>Warning!</strong> <font color="#C09853"><c:out
															value="${updateVendorReturnDuplicate}" /></font>
												</div>
											</c:forEach></td>
									</tr>

									<form:hidden path="vendorReturnIdEditt" />
									<tr>
										<td><spring:message code="label.vendorreturnno" /><font
											color="red">*</font></td>
										<td><form:input path="vendorReturnNoEditt"
												id="vendorReturnNoEditt" class="textbox"
												onkeyup="doAjaxPostEdit()" /></td>

									</tr>
									<tr>
										<td><spring:message code="label.vendorreturndate" /><font
											color="red">*</font></td>
										<td><form:input path="vendorReturnDateEditt"
												id="vendorReturnDateEditt" class="textbox" name="date" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.reference" /><font
											color="red">*</font></td>
										<td><form:input path="referenceEditt" id="referenceEditt"
												class="textbox" maxlength="50" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.desc" /><font
											color="red">*</font></td>
										<td><form:textarea path="descriptionEditt"
												id="descriptionEditt" class="textbox" /></td>
									</tr>
									<tr>
										<td><spring:message code="label.purchaseorder" /><font
											color="red">*</font></td>
										<td><form:select path="purchaseOrderIdEditt"
												id="purchaseOrderIdEditt" class="select"
												onchange="GetGoodsIds('E')">
												<form:option value="">-Select-</form:option>
												<form:options items="${purchaseorder}" />
											</form:select></td>
									</tr>
									<tr>
										<td><spring:message code="label.vgreceipt" /><font
											color="red">*</font></td>
										<td><form:select path="goodsReceiptIdEdit" class="select"
												id="goodsReceiptIdEdit" onchange="GetBatchNos('E')">
												<form:option value="">-Select-</form:option>
												<form:options items="${goodsReceipt}" />
											</form:select></td>
									</tr>
								</table>

								<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
										<div id="scroll1">
											<ul>

												<li><a href="#tab1"><spring:message
															code="label.vedorreturnline" /></a></li>

											</ul>

											<!--Sub Tab-1 -->
											<div id="tab1">
												<div align="center">
													<script>
														var btrid = 1;
														$(function() {

															var mIdEditt = $("#mIdEditt"), rejQtyEdit = $("#rejQtyEdit"), batchNoEdit = $("#batchNoEdit"),
															//mvalue=$("#mNumber"),
															quantityEditt = $("#quantityEditt"), uommEditt = $("#uommEditt"),
															//uvalue=$("#uNumber"),
															priceEditt = $("#priceEditt"), rfrIdEditt = $("#rfrIdEditt"),
															//rfrvalue=$("#rfrNumber"),
															stLIdEditt = $("#stLIdEditt"),
															//stLvalue=$("#stLNumber"),

															hiddenEdit = $("#hiddenIdEditVPopUp"),

															allFields = $([])
																	.add(
																			mIdEditt)
																	.add(
																			quantityEditt)
																	.add(
																			uommEditt)
																	.add(
																			priceEditt)
																	.add(
																			rfrIdEditt)
																	.add(
																			stLIdEditt)
																	.add(
																			batchNoEdit)
																	.add(
																			hiddenEdit),

															tips = $(".validateTips");

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
															function qtyEdit(o,
																	k, n) {

																if (o.val() != "") {

																	var qty = parseInt(o
																			.val());
																	var rqty = parseInt(k
																			.val());
																	if (qty != 0
																			&& qty <= rqty) {

																		return true;
																	} else {
																		o
																				.addClass("ui-state-error");
																		updateTips(""
																				+ n
																				+ " Should be less than or equal to Rejected qty ");
																		return false;
																	}

																}

																else {
																	return true;
																}

																/* else {
																	o
																			.addClass("ui-state-error");
																	updateTips(""
																			+ n
																			+ " Should be Greater Than Zero ");
																	return false;
																} */
															}

															$(
																	"#dialog-form-VendorReturnEdit")
																	.dialog(
																			{
																				autoOpen : false,
																				height : 350,
																				width : 400,
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
																								&& selectLength(
																										batchNoEdit,
																										"Batch No");
																						bValid1 = bValid1
																								&& checkLength(
																										quantityEditt,
																										"Quantity",
																										1,
																										16);
																						bValid1 = bValid1
																								&& qtyEdit(
																										quantityEditt,
																										rejQtyEdit,
																										"Returns Quantity");
																						bValid1 = bValid1
																								&& selectLength(
																										uommEditt,
																										"UOM");
																						bValid1 = bValid1
																								&& checkLength(
																										priceEditt,
																										"Price",
																										1,
																										16);
																						bValid1 = bValid1
																								&& selectLength(
																										rfrIdEditt,
																										"Reason For Rejection");
																						bValid1 = bValid1
																								&& selectLength(
																										stLIdEditt,
																										"Storage Location");

																						if (bValid1) {

																							if (hiddenEdit
																									.val() == "0"
																									|| hiddenEdit
																											.val() == "") {

																								$(
																										"#AddVendorReturnEdit tbody")
																										.append(
																												"<tr id="+btrid+">"
																														+ "<td><spring:bind path='vendorReturnCommand.vendorReturnLineIdEditt'><input type='hidden' name='vendorReturnLineIdEditt' id='vendorReturnLineIdEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='vendorReturnCommand.mIdEditt'><input type='hidden' name='mIdEditt' id='mIdEditt"
																														+ btrid
																														+ "' value="
																														+ mIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"

																														+ "<spring:bind path='vendorReturnCommand.materialName'><input type='text' name='materialName' id='materialName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#mIdEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"
																														+ "<td><spring:bind path='vendorReturnCommand.batchNoEdit'><input name='batchNoEdit' id='batchNoEdit"
																														+ btrid
																														+ "' value="
																														+ batchNoEdit
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='vendorReturnCommand.quantityEditt'><input name='quantityEditt' id='quantityEditt"
																														+ btrid
																														+ "' value="
																														+ quantityEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='vendorReturnCommand.uommEditt'><input type='hidden' name='uommEditt' id='uommEditt"
																														+ btrid
																														+ "' value="
																														+ uommEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='vendorReturnCommand.uomName'><input type='text' name='uomName' id='uomName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#uommEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='vendorReturnCommand.priceEditt'><input name='priceEditt' id='priceEditt"
																														+ btrid
																														+ "' value="
																														+ priceEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='vendorReturnCommand.rfrIdEditt'><input type='hidden' name='rfrIdEditt' id='rfrIdEditt"
																														+ btrid
																														+ "' value="
																														+ rfrIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='vendorReturnCommand.rfrName'><input type='text' name='rfrName' id='rfrName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#rfrIdEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind></td>"

																														+ "<td><spring:bind path='vendorReturnCommand.stLIdEditt'><input type='hidden' name='stLIdEditt' id='stLIdEditt"
																														+ btrid
																														+ "' value="
																														+ stLIdEditt
																																.val()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<spring:bind path='vendorReturnCommand.storageName'><input type='text' name='storageName' id='storageName"
																														+ btrid
																														+ "' value="
																														+ $(
																																'#stLIdEditt :selected')
																																.text()
																														+ " class='textbox' readonly/></spring:bind>"
																														+ "<input type='hidden' name='Check' id='Check' value='0' /></td>"
																														+ "<td><a href='#'  onclick='editVendorReturnDetailsInEditNew("
																														+ btrid
																														+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																														+ "<td><a href='#'  onclick='removeVendorReturnDetailsEditNew("
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
																										'#batchNoEdit'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#batchNoEdit')
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
																										'#priceEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#priceEditt')
																														.val());

																								$(
																										'#rfrIdEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#rfrIdEditt')
																														.val());
																								$(
																										'#rfrName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#rfrIdEditt :selected')
																														.text());
																								$(
																										'#stLIdEditt'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#stLIdEditt')
																														.val());
																								$(
																										'#storageName'
																												+ hiddenEdit
																														.val())
																										.val(
																												$(
																														'#stLIdEditt :selected')
																														.text());

																								$(
																										'#hiddenIdVendorReturnPopUpEdit')
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
																	"#create-AddVendorReturnEdit")
																	.button()
																	.click(
																			function() {
																				$(
																						"#dialog-form-VendorReturnEdit")
																						.dialog(
																								"open");

																			});
														});
														function removeVendorReturnDetailsEditNew(
																id) {
															$('#' + id)
																	.remove();
														}
														function editVendorReturnDetailsInEditNew(
																link) {

															$(
																	"#dialog-form-VendorReturnEdit")
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
															$('#batchNoEdit')
																	.val(
																			$(
																					'#batchNoEdit'
																							+ link)
																					.val());

															$('#uommEditt')
																	.val(
																			$(
																					'#uommEditt'
																							+ link)
																					.val());

															$('#priceEditt')
																	.val(
																			$(
																					'#priceEditt'
																							+ link)
																					.val());
															$('#rfrIdEditt')
																	.val(
																			$(
																					'#rfrIdEditt'
																							+ link)
																					.val());
															$('#stLIdEditt')
																	.val(
																			$(
																					'#stLIdEditt'
																							+ link)
																					.val());

															$(
																	'#hiddenIdEditVPopUp')
																	.val(link);

														}
													</script>


													<div id="dialog-form-VendorReturnEdit"
														title="Add New Vendor Return Details">
														<p class="validateTips">All form fields are required.</p>
														<table class="tableGeneral">

															<tr>
																<td><spring:message code="label.qmaterial" /><font
																	color="red">*</font></td>
																<td><form:select path="mIdEditt" class="select"
																		id="mIdEditt" cssStyle="height:25px"
																		onchange="RejQty('E')">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${material }" />
																	</form:select></td>
															</tr>

															<tr>
																<td><spring:message code="label.vrbatchno" /><font
																	color="red">*</font></td>
																<td><form:select path="batch" class="select"
																		id="batchNoEdit" cssStyle="height:25px"
																		onchange="RejQty('E')">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${batchNos}" />
																	</form:select></td>
															</tr>

															<tr>
																<td>Rejected Quantity<font color="red">*</font></td>
																<td><form:input path="rejQty" id="rejQtyEdit"
																		class="textbox" readonly="true" /></td>
															</tr>
															<tr>
																<td><spring:message code="label.vrqty" /><font
																	color="red">*</font></td>
																<td><form:input path="quantityEditt"
																		id="quantityEditt" class="textbox"
																		onkeyup="RejQty('E')" /></td>

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
																<td><spring:message code="label.price" /><font
																	color="red">*</font></td>
																<td><form:input path="priceEditt" id="priceEditt"
																		class="textbox" /></td>
															</tr>
															<tr>
																<td><spring:message code="label.reasonforrejection" /><font
																	color="red">*</font></td>
																<td><form:select path="rfrIdEditt" id="rfrIdEditt"
																		class="select" cssStyle="height:25px">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${reasonforrejection }" />
																	</form:select></td>
															</tr>
															<tr>
																<td><spring:message code="label.storageLocation" /><font
																	color="red">*</font></td>
																<td><form:select path="stLIdEditt" id="stLIdEditt"
																		class="select" cssStyle="height:25px">
																		<form:option value="0">-Select-</form:option>
																		<form:options items="${storageId }" />
																	</form:select><input type="hidden" name="hiddenIdEditVPopUp"
																	id="hiddenIdEditVPopUp" value="0" /></td>
															</tr>
														</table>
													</div>

													<div id="users-contain-VendorReturnEdit">
														<!-- class="ui-widget" -->
														<h3></h3>
														<table id="AddVendorReturnEdit" class="table">
															<thead>
																<tr>
																	<th><spring:message code="label.qmaterial" /><font
																		color="red"></font></th>
																	<th><spring:message code="label.vrbatchno" /><font
																		color="red"></font></th>
																	<th><spring:message code="label.vrqty" /><font
																		color="red"></font></th>
																	<th><spring:message code="label.quom" /><font
																		color="red"></font></th>
																	<th><spring:message code="label.price" /><font
																		color="red"></font></th>
																	<th><spring:message
																			code="label.reasonforrejection" /><font color="red"></font></th>
																	<th><spring:message code="label.storageLocation" /><font
																		color="red"></font></th>
																	<th><spring:message code="label.edit" /><font
																		color="red"></font></th>
																	<th><spring:message code="label.delete" /><font
																		color="red"></font></th>

																</tr>

															</thead>
															<tbody>
																<c:forEach var="vrLineEditList"
																	items="${vrLineEditList}">

																	<c:set var="edit1"
																		value="${vrLineEditList.vendorReturnLineId}"></c:set>
																	<%-- 	<c:if test="${edit1!=null}"> --%>
																	<tr id="${vrLineEditList.vendorReturnLineId}">


																		<spring:bind
																			path="vendorReturnCommand.vendorReturnLineIdEditt">
																			<input type="hidden" name="vendorReturnLineIdEditt"
																				class="textbox"
																				value="${vrLineEditList.vendorReturnLineId}"
																				id="vendorReturnLineIdEditt${vrLineEditList.vendorReturnLineId}" />
																		</spring:bind>

																		<spring:bind path="vendorReturnCommand.mIdEditt">
																			<input type="hidden" name="mIdEditt" class="textbox"
																				value="${vrLineEditList.material_IdEditt}"
																				id="mIdEditt${vrLineEditList.vendorReturnLineId}" />
																		</spring:bind>

																		<td><spring:bind
																				path="vendorReturnCommand.materialName">
																				<input type="text" name="materialName"
																					class="textbox" readonly="readonly"
																					value="${vrLineEditList.materialName}"
																					id="materialName${vrLineEditList.vendorReturnLineId}" />
																			</spring:bind></td>
																		<spring:bind path="vendorReturnCommand.stockEdit">
																			<input type="hidden" name="stockEdit" class="textbox"
																				readonly="readonly"
																				value="${vrLineEditList.stockEdit}"
																				id="stockEdit${vrLineEditList.vendorReturnLineId}" />

																		</spring:bind>
																		<td><spring:bind
																				path="vendorReturnCommand.batchNoEdit">
																				<input type="text" name="batchNoEdit"
																					class="textbox" readonly="readonly"
																					value="${vrLineEditList.batchNoEdit}"
																					id="batchNoEdit${vrLineEditList.vendorReturnLineId}" />
																			</spring:bind></td>
																		<td><spring:bind
																				path="vendorReturnCommand.quantityEditt">
																				<input type="text" name="quantityEditt"
																					class="textbox" readonly="readonly"
																					value="${vrLineEditList.quantityEditt}"
																					id="quantityEditt${vrLineEditList.vendorReturnLineId}" />
																			</spring:bind></td>


																		<spring:bind path="vendorReturnCommand.uommEditt">
																			<input type="hidden" name="uommEditt" class="textbox"
																				value="${vrLineEditList.uom_IdEditt}"
																				id="uommEditt${vrLineEditList.vendorReturnLineId}" />
																		</spring:bind>
																		<td><spring:bind
																				path="vendorReturnCommand.uomName">
																				<input type="text" name="uomName" class="textbox"
																					readonly="readonly"
																					value="${vrLineEditList.uomName}"
																					id="uomName${vrLineEditList.vendorReturnLineId}" />
																			</spring:bind></td>

																		<td><spring:bind
																				path="vendorReturnCommand.priceEditt">
																				<input type="text" name="priceEditt"
																					id="priceEditt${vrLineEditList.vendorReturnLineId}"
																					class="textbox" readonly="readonly"
																					value="${vrLineEditList.priceEditt }" />
																			</spring:bind></td>
																		<spring:bind path="vendorReturnCommand.rfrIdEditt">
																			<input type="hidden" name="rfrIdEditt"
																				class="textbox"
																				value="${vrLineEditList.reasonForRejectionIdEditt}"
																				id="rfrIdEditt${vrLineEditList.vendorReturnLineId}" />
																		</spring:bind>
																		<td><spring:bind
																				path="vendorReturnCommand.rfrName">
																				<input type="text" name="rfrName" class="textbox"
																					readonly="readonly"
																					value="${vrLineEditList.rfrName}"
																					id="rfrName${vrLineEditList.vendorReturnLineId}" />
																			</spring:bind></td>
																		<spring:bind path="vendorReturnCommand.stLIdEditt">
																			<input type="hidden" name="stLIdEditt"
																				class="textbox"
																				value="${vrLineEditList.storageLocationIdEditt}"
																				id="stLIdEditt${vrLineEditList.vendorReturnLineId}" />
																		</spring:bind>
																		<td><spring:bind
																				path="vendorReturnCommand.storageName">
																				<input type="text" name="storageName"
																					class="textbox" readonly="readonly"
																					value="${vrLineEditList.storageName}"
																					id="storageName${vrLineEditList.vendorReturnLineId}" />
																			</spring:bind> <input type="hidden"
																			name="${vrLineEditList.vendorReturnLineId}Check"
																			id="${vrLineEditList.vendorReturnLineId}Check"
																			value="0" /></td>
																		<td><a href="#"
																			id="${vrLineEditList.vendorReturnLineId}"
																			onclick="javascript:editVendorReturnDetailsInEdit(this)"><img
																				src="images/Edit.jpg" height="25px" width="25px"
																				id="${vrLineEditList.vendorReturnLineId}"></img></a></td>
																		<td><a href="#"
																			id="${vrLineEditList.vendorReturnLineId}"
																			onclick="javascript:getID1(this)"><img
																				src="images/button_cancel.png" height="25px"
																				width="25px"
																				id="${vrLineEditList.vendorReturnLineId}"></img></a></td>
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
																		function editVendorReturnDetailsInEdit(
																				link) {

																			$(
																					"#dialog-form-VendorReturnEdit")
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
																			//$('#rejQtyEdit').val($('#quantityEditt'+ link.id).val());		

																			$(
																					'#batchNoEdit')
																					.val(
																							$(
																									'#batchNoEdit'
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
																					'#priceEditt')
																					.val(
																							$(
																									'#priceEditt'
																											+ link.id)
																									.val());
																			$(
																					'#rfrIdEditt')
																					.val(
																							$(
																									'#rfrIdEditt'
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
																					'#hiddenIdEditVPopUp')
																					.val(
																							link.id);

																		}
																	</script>

																</c:forEach>


															</tbody>

														</table>
													</div>
													<button id="create-AddVendorReturnEdit" type="button">Add
														New Vendor Return Line</button>

												</div>

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
								</div>
							</c:if>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	
</body>

</html>




