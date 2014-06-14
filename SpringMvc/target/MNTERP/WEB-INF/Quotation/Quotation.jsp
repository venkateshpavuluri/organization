<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

 <script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subid')
								.click(
										function(event) {
											
											$('#addquotationform')
													.validate(
															{
																rules : {
																	quotationNo : {
																		required : true },
																		vendorId:{
																			required : true	
																		},
																		rfqNo:{
																			required : true	
																		},
																		rfqDate:{
																			required : true	
																		},
																		quotationDate:{
																			required : true	
																		},
																		quotStatusId:{
																			required : true	
																		},
																		quantity:{
																			required : true	
																		},
																		deliveryDate:{
																			required : true,
																			date:true
																		},
																},
																messages : {
																	quotationNo : "<font style='color: red;'><b>Qutation No is Required</b></font>",
																	vendorId : "<font style='color: red;'><b>Vendor is Required</b></font>",
																	rfqNo : "<font style='color: red;'><b>RFQ No is Required</b></font>",
																	rfqDate : "<font style='color: red;'><b>RFQ Date is Required</b></font>",
																	quotationDate : "<font style='color: red;'><b>Qutation Date is Required</b></font>",
																	quotStatusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	quantity : "<font style='color: red;'><b>Quantity is Required</b></font>",
																	deliveryDate : "<font style='color: red;'><b>Delivery Date is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#Upbtnid')
								.click(
										function(event) {
											//alert("hai");
											$('#editquotationForm')
													.validate(
															{
																rules : {
																	quotationNoEditt : {
																		required : true },
																		vendorIdEditt:{
																			required : true	
																		},
																		rfqNoEditt:{
																			required : true	
																		},
																		rfqDateEditt:{
																			required : true	
																		},
																		quotationDateEditt:{
																			required : true	
																		},
																		quotStatusIdEditt:{
																			required : true	
																		},
																		quantityEditt:{
																			required : true	
																		},
																		deliveryDateEditt:{
																			required : true,
																			date:true
																		},
																},
																messages : {
																	quotationNoEditt : "<font style='color: red;'><b>Qutation No is Required</b></font>",
																	vendorIdEditt : "<font style='color: red;'><b>Vendor is Required</b></font>",
																	rfqNoEditt : "<font style='color: red;'><b>RFQ No is Required</b></font>",
																	rfqDateEditt : "<font style='color: red;'><b>RFQ Date is Required</b></font>",
																	quotationDateEditt : "<font style='color: red;'><b>Qutation Date is Required</b></font>",
																	quotStatusIdEditt : "<font style='color: red;'><b>Status is Required</b></font>",
																	quantityEditt : "<font style='color: red;'><b>Quantity is Required</b></font>",
																	deliveryDateEditt : "<font style='color: red;'><b>Delivery Date is Required</b></font>"
																},

															});

										}); 

					});
</script>

<script type="text/javascript">
	function doAjaxPostEdit() {

		//get the form values

		//var processnameedit = $('#processedit').val();
		var quotationId = $('#quotationNoEditt').val();
		//alert(qutationId);

		var qid = $('#quotationIdEditt').val();

		$
				.ajax({

					type : "POST",

					url : "/MNTERP/quotationDuplicateEditCheck.mnt",

					data : "quotationId=" + quotationId + "&qid=" + qid,

					success : function(response) {

						var checkResponse = "Quotation  Already Exists Choose Another One";

						if (checkResponse == response) {
							document.getElementById("editmessage").style.display = "block";
							$('#editmessage').html(response);
						} else {
							document.getElementById("editmessage").style.display = "none";
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
</script>
<script type="text/javascript">
	function doAjaxPost() {
		//alert("hey");
		//get the form values

		//var processnameedit = $('#processedit').val();
		var quotationno = $('#quotationNo').val();
		//alert(quotationno);

		//var qid=$('#quotationId').val();

		$
				.ajax({

					type : "POST",

					url : "/MNTERP/quotationDuplicateAddCheck.mnt",

					data : "quotationno=" + quotationno,

					success : function(response) {

						var checkResponse = "Quotation  Already Exists Choose Another One";

						if (checkResponse == response) {
							document.getElementById("addmessage").style.display = "block";
							$('#addmessage').html(response);
						} else {
							document.getElementById("addmessage").style.display = "none";
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
</script>

<!--  Date picker -->
<script>
	$(function() {

		$("#rfqDate").datepicker();
		$("#quotationDate").datepicker();
		$("#deliveryDate").datepicker();
		$("#adddeliveryDate").datepicker();
		$("#editrowdeliveryDate").datepicker();
		$("#addrowdeliveryDate").datepicker();
		$("#rfqDateEditt").datepicker();
		$("#quotationDateEditt").datepicker();
		$("#deliveryDatepickerEditt").datepicker();
	});
</script>



<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
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

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

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
	width: 58%;
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
		if (document.getElementById("aid").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();

		});
	});
</script>

<script type="text/javascript">
	function multiply() {
		var quantity = document.getElementById("quantity");
		var perUnit = document.getElementById("perUnit");
		var result = quantity.value * perUnit.value;
		document.getElementById("lineAmount").value = result;

	}
</script>
<script type="text/javascript">
	function ediMultiply() {
		var editquantity = document.getElementById("quantityEditt[]");
		var editperUnit = document.getElementById("perUnitEditt[]");
		var ediRresult = editquantity.value * editperUnit.value;
		document.getElementById("lineAmountEditt[]").value = ediRresult;

	}
</script>


</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Quotation</div>

		<!-- Tabs Declaration -->
		<div id="scroll">
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="quotationEditList" items="${quotationEditList}">
						<c:set var="quotationEditList" value="${quotationEditList }"></c:set>
					</c:forEach>
					<c:if test="${quotationEditList!=null}">

						<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
					</c:if>
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
				</ul>

				<!-- Search tab part -->

				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">
						<form:form action="quotationSearch.mnt" method="GET"
							commandName="quotationCommand">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="quotationUpdated"
											items="${param.list}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.success}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="quotationUpdated"
											items="${quotationUpdate}">
											<div class="alert-success" id="successmessage">
												<strong>Success!</strong>
												<c:out value="${quotationUpdated}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="quotUpdated"
											items="${param.list1}">
											<div class="alert-warning" id="warningmessage">
												<strong>Warning!</strong>
												<c:out value="${param.warning}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td>&nbsp;&nbsp;&nbsp;</td>
								</tr>
								<tr>
									<td colspan="2"></td>
								</tr>
								<%-- <tr>
									<td>Quotation Id</td>
									<td><form:input path="quotationId" cssClass="textbox" /></td>
									<td><input type="submit" value="Search"
										class="btn btn-primary" /></td>
								</tr> --%>
								<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">										
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>
								
							</table>
						</form:form>
						<c:forEach var="quotSearch" items="${quotationSearch}">
							<c:set var="g" value="${quotSearch}"></c:set>
						</c:forEach>
						<c:if test="${g!=null}">
							<display:table id="quotationValue" name="quotationSearch"
								requestURI="quotationSearch.mnt" pagesize="5" class="table">
								<!-- Displaying  the Searched information by using display tag -->
								<display:column property="quotationNo" title="Quotation No"
									media="html" sortable="true" />
								<display:column property="vendorname" title="Vendor"
									media="html" sortable="true" />
								<display:column property="rfqNo" title="RFQ No" media="html"
									sortable="true" />
								<display:column property="rfqDate" title="RFQ Date" media="html"
									sortable="true" />
								<display:column property="quotationDate" title="Quotation Date"
									media="html" sortable="true" />
								<display:column property="description" title="Description"
									media="html" sortable="true" />
								<display:column property="status" title="Status" media="html"
									sortable="true" />

								<display:column title="Edit" style="color:white">
									<a
										href="quotationIdEdit.mnt?quotationId=<c:out value="${quotationValue.quotationId}"/>"
										style="color: red"><img src="images/Edit.jpg" width="20px"
										height="20px" /> </a>
								</display:column>
								<display:column title="Delete">
									<a
										href="quotationIdDelete.mnt?quotationId=<c:out value="${quotationValue.quotationId}"/>"
										style="color: red"
										onclick="return confirm('Do u want to delete the Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
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
						<form:form action="quotation.mnt" method="GET"
							commandName="quotationCommand" id="addquotationform">

							<table class="tableGeneral">
								<form:hidden path="aid" />
								<tr>
									<td colspan="2" height="20px"><c:forEach
											var="addQuotDuplicate" items="${addQuotDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out value="${addQuotDuplicate}" /></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="quotationIdEditt" />
								<form:hidden path="quotationLineIdEditt" />
								<tr>
									<td>Quotation No<font color="red">*</font>
									</td>
									<td><form:input path="quotationNo" id="quotationNo"
											class="textbox" onkeyup="doAjaxPost()" /></td>
									<td style="display: none" id="addmessage" class="alert-warning"></td>

								</tr>
								<tr>
									<td>Vendor<font color="red">*</font>
									</td>
									<td><form:select path="vendorId" class="select">
											<form:option value="0">-Select-</form:option>
											<form:options items="${vendor}" />
										</form:select></td>
								</tr>
								<tr>
									<td>RFQ No<font color="red">*</font>
									</td>
									<td><form:input path="rfqNo" id="rfqNo" class="textbox" /></td>
								</tr>
								<tr>
									<td>RFQ Date<font color="red">*</font>
									</td>
									<td><form:input path="rfqDate" id="rfqDate" name="date"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Quotation Date<font color="red">*</font>
									</td>
									<td><form:input path="quotationDate" id="quotationDate"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Description</td>
									<td><form:textarea path="description" id="description"
											class="textarea" /></td>
								</tr>
								<tr>
									<td>Status<font color="red">*</font>
									</td>
									<td><form:select path="quotStatusId" id="quotStatusId"
											class="select" cssStyle="height:25px">
											<form:options items="${status }" />
										</form:select></td>
								</tr>

							</table>

							<!-- Sub tabbing for adding Quotation Line details -->
							<div id="tabsForAdd">
								<ul>
									<li><a href="#subtabs-1">Quotation Line</a></li>

								</ul>
								<!-- Quotation Line tab -->
								<div id="subtabs-1">
									<div align="left">
										<!-- Selecting Quotation Line details -->
										<div id="scroll1">
											<table class="table">
												<tr>
													<th>Material<font color="red">*</font></th>
													<th>UOM<font color="red">*</font></th>
													<th>Quantity<font color="red">*</font></th>
													<th>Per Unit</th>
													<th>Line Amount</th>
													<th>Net Price</th>
													<th>Currency<font color="red">*</font></th>
													<th>Delivery Date<font color="red">*</font></th>
													<th>Status<font color="red">*</font></th>
													<th>Plant<font color="red">*</font></th>
													<th>Storage Location<font color="red">*</font></th>
												</tr>
												<tr>

													<td><form:select path="material_Id" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
													<td><form:select path="uom" id="uom" class="select"
															cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
													<td><form:input path="quantity" id="quantity"
															class="textbox" onkeyup="multiply()" /></td>
													<td><form:input path="perUnit" id="perUnit"
															class="textbox" onkeyup="multiply()" /></td>
													<td><form:input path="lineAmount" id="lineAmount"
															class="textbox" readonly="true" /></td>
													<td><form:input path="netPrice" id="netPrice"
															class="textbox" /></td>


													<td><form:select path="currencyId" id="currencyId"
															class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${currency }" />
														</form:select></td>
													<td><form:input path="deliveryDate" id="deliveryDate"
															class="textbox" /></td>

													<td><form:select path="statusId" id="statusId"
															class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${status }" />
														</form:select></td>
													<td><form:select path="plantId" id="plantId"
															class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${plant }" />
														</form:select></td>
													<td><form:select path="storageLocId" id="storageLocId"
															class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${storageId }" />
														</form:select></td>
													<td><a href="#" id="addoc"><img
															src="images/add (1).png"></img></a> 
															<script src="js/jquery-1.7.2.js"></script>
															<script src="js/jquery-ui.js"></script>
															<script type="text/javascript" src="js/jquery.validate.min.js"></script>

														<script type="text/javascript">
															function emultiply() {

																var equantity = document
																		.getElementById("equantity[]");
																var eperUnit = document
																		.getElementById("eperUnit[]");
																var result = equantity.value
																		* eperUnit.value;
																document
																		.getElementById("elineAmount[]").value = result;

															}

															$(document)
																	.ready(
																			function() {
																				$(function() {

																					//fadeout selected item and remove
																					$(
																							'.remove')
																							.live(
																									'click',
																									function() {
																										$(
																												this)
																												.parent()
																												.fadeOut(
																														300,
																														function() {
																															$(
																																	this)
																																	.empty();
																															return false;
																														});
																									});
																					//alert("came to add")

																					var options = '<table style="width:100px"><tr><td><table class="table" >'
																							+ '<tr>'
																							+ '<td><form:select path="material_Id"  class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${material }"/></form:select></td>'
																							+ '<td><form:select path="uom" id="uom" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${uom }"/></form:select></td>'
																							+ '<td><form:input path="quantity"  id="equantity[]" class="textbox" onkeyup="emultiply()"/> </td>'
																							+ '<td><form:input path="perUnit"  id="eperUnit[]" class="textbox" onkeyup="emultiply()"/> </td>'
																							+ '<td><form:input path="lineAmount"  id="elineAmount[]" class="textbox" readonly="true" /> </td>'
																							+ '<td><form:input path="netPrice"  id="netPrice" class="textbox" /> </td>'
																							+ '<td><form:select path="currencyId" id="currencyId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${currency }"/></form:select></td>'
																							+ '<td><form:input path="deliveryDate"  id="addrowdeliveryDate" class="datepicker1 textbox" /></td>'
																							+ '<td><form:select path="statusId" id="statusId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${status }"/></form:select></td>'
																							+ '<td><form:select path="plantId" id="plantId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${plant }"/></form:select></td>'
																							+ '<td><form:select path="storageLocId" id="storageLocId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${storageId }"/></form:select></td>'
																							+ '</td></tr></table>'
																							+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
																					//add input
																					$(
																							'#addoc')
																							.click(
																									function() {
																										$(
																												options)
																												.fadeIn(
																														"slow")
																												.appendTo(
																														'#extender');
																										//	alert("affk");
																										i++;
																										return false;
																									});

																				});

																				$(
																						'.datepicker')
																						.live(
																								'click',
																								function() {
																									$(
																											this)
																											.datepicker(
																													'destroy')
																											.datepicker()
																											.focus();
																								});
																				$(
																						'.datepicker1')
																						.live(
																								'click',
																								function() {
																									$(
																											this)
																											.datepicker(
																													'destroy')
																											.datepicker()
																											.focus();
																								});

																			});
														</script></td>
												</tr>

											</table>
											<div id="extender"></div>
										</div>
									</div>
								</div>
							</div>
							<input type="submit" value="Save" name="Save"
								class="btn btn-primary" id="subid"/>
							<input type="reset" class="btn btn-primary" />
						</form:form>
					</div>

				</div>
				<!-- Edit tab -->

				<div id="tabs-1" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						<c:forEach var="quotationEditList" items="${quotationEditList}">
							<c:set var="edit" value="${quotationEditList}"></c:set>
						</c:forEach>

						<c:if test="${edit!=null}">
							<form:form action="quotationEdit.mnt" method="GET"
								commandName="quotationCommand" id="editquotationForm">

								<div id="tabs-3" class="TabbedPanelsContent">
									<div align="left" class="TabbedPanelsContent">
										<table class="tableGeneral">

											<%-- 	<tr>
												<td colspan="2" height="20px"><c:forEach
														var="updateQuotDuplicate" items="${updateQuotDuplicate}">
														<div class="alert-warning" id="savemessage">
															<font color="red"><c:out
																	value="${updateQuotDuplicate}" /></font>
														</div>
													</c:forEach></td>
											</tr> --%>

											<form:hidden path="quotationIdEditt" />
											<tr>
												<td>Quotation No<font color="red">*</font>
												</td>
												<td><form:input path="quotationNoEditt" class="textbox"
														onkeyup="doAjaxPostEdit()" /></td>
												<td id="editmessage" class="alert-warning"></td>
											</tr>
											<tr>
												<td>Vendor<font color="red">*</font>
												</td>
												<td><form:select path="vendorIdEditt" class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${vendor}" />
													</form:select></td>
											</tr>
											<tr>
												<td>RFQ No<font color="red">*</font>
												</td>
												<td><form:input path="rfqNoEditt" id="rfqNo"
														class="textbox" /></td>
											</tr>
											<tr>
												<td>RFQ Date<font color="red">*</font>
												</td>
												<td><form:input path="rfqDateEditt" id="rfqDateEditt"
														name="date" class="textbox" /></td>
											</tr>
											<tr>
												<td>Quotation Date<font color="red">*</font>
												</td>
												<td><form:input path="quotationDateEditt"
														id="quotationDateEditt" class="textbox" /></td>
											</tr>
											<tr>
												<td>Description</td>
												<td><form:textarea path="descriptionEditt"
														id="description" class="textarea" /></td>
											</tr>
											<tr>
												<td>Status<font color="red">*</font>
												</td>
												<td><form:select path="quotStatusIdEditt"
														id="quotStatusIdEditt" class="select"
														cssStyle="height:25px">
														<form:option value="0">-Select-</form:option>
														<form:options items="${status }" />
													</form:select></td>
											</tr>

										</table>

									</div>
								</div>

								<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
										<ul>
											<li><a href="#tabs-1">Quotation Line</a></li>
										</ul>

										<div id="subtabs-1">
											<div align="left">

												<div id="scroll1">
													<table class="table">
														<tr>
															<th>Material<font color="red">*</font></th>
															<th>UOM<font color="red">*</font></th>
															<th>Quantity<font color="red">*</font></th>
															<th>Per Unit</th>
															<th>Line Amount</th>
															<th>Net Price</th>
															<th>Currency<font color="red">*</font></th>
															<th>Delivery Date<font color="red">*</font></th>
															<th>Status<font color="red">*</font></th>
															<th>Plant<font color="red">*</font></th>
															<th>Storage Location<font color="red">*</font></th>
														</tr>

														<c:forEach var="quotationLineEditList"
															items="${quotationLineEditList}">

															<c:set var="edit1" value="${quotationLineEditList}"></c:set>
															<c:if test="${edit1!=null}">
																<tr>

																	<td><form:select path="material_IdEditt"
																			class="select" cssStyle="height:25px">
																			<form:option value="0">-Select-</form:option>
																			<form:options items="${material }" />
																		</form:select></td>
																	<td><form:select path="uomEditt" id="uom"
																			class="select" cssStyle="height:25px">
																			<form:option value="0">-Select-</form:option>
																			<form:options items="${uom }" />
																		</form:select></td>
																	<td><spring:bind
																			path="quotationCommand.quantityEditt">
																			<input type="text" name="quantityEditt"
																				class="textbox" onkeyup="multiply()"
																				value="${quotationLineEditList.quantityEditt}" />
																		</spring:bind></td>
																	<td><spring:bind
																			path="quotationCommand.perUnitEditt">
																			<input type="text" name="perUnitEditt" id="perUnit"
																				class="textbox" onkeyup="multiply()"
																				value="${quotationLineEditList.perUnitEditt }" />
																		</spring:bind></td>
																	<td><spring:bind
																			path="quotationCommand.lineAmountEditt">
																			<input type="text" name="lineAmountEditt"
																				id="lineAmount" class="textbox"
																				value="${quotationLineEditList.lineAmountEditt}"
																				readonly="readonly" />
																		</spring:bind></td>
																	<td><spring:bind
																			path="quotationCommand.netPriceEditt">
																			<input type="text" name="netPriceEditt" id="netPrice"
																				class="textbox"
																				value="${quotationLineEditList.netPriceEditt }" />
																		</spring:bind></td>
																	<td><form:select path="currencyIdEditt"
																			id="currencyId" class="select" cssStyle="height:25px">
																			<form:option value="0">-Select-</form:option>
																			<form:options items="${currency }" />
																		</form:select></td>
																	<td><spring:bind
																			path="quotationCommand.deliveryDateEditt">
																			<input type="text" name="deliveryDateEditt"
																				id="deliveryDatepickerEditt" class="textbox"
																				value="${quotationLineEditList.deliveryDateEditt }" />
																		</spring:bind></td>

																	<td><form:select path="statusIdEditt"
																			id="statusId" class="select" cssStyle="height:25px">
																			<form:option value="0">-Select-</form:option>
																			<form:options items="${status }" />
																		</form:select></td>
																	<td><form:select path="plantIdEditt" id="plantId"
																			class="select" cssStyle="height:25px">
																			<form:option value="0">-Select-</form:option>
																			<form:options items="${plant }" />
																		</form:select></td>
																	<td><form:select path="storageLocIdEditt"
																			id="storageLocId" class="select"
																			cssStyle="height:25px">
																			<form:option value="0">-Select-</form:option>
																			<form:options items="${storageId }" />
																		</form:select></td>
																	<td><a href="#" id="addocument"><img
																			src="images/add (1).png"></img></a> <script
																			src="http://code.jquery.com/jquery-1.8.2.js"></script>
																		<script
																			src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
																			<script type="text/javascript" src="js/jquery.validate.min.js"></script>
																		<script type="text/javascript">
																			$(
																					document)
																					.ready(
																							function() {

																								$(function() {

																									//fadeout selected item and remove
																									$(
																											'.remove')
																											.live(
																													'click',
																													function() {
																														$(
																																this)
																																.parent()
																																.fadeOut(
																																		300,
																																		function() {
																																			$(
																																					this)
																																					.empty();
																																			return false;
																																		});
																													});
																									//alert("came to add")

																									var options = '<table border="0" ><tr><td>'
																											+ '<table style="float:left;" border="0" ><tr>'
																											+ '<td><form:select path="material_IdEditt"  class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${material }" /></form:select></td>'
																											+ '<td><form:select path="uomEditt" id="uom" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${uom }"/></form:select></td>'
																											+ '<td><spring:bind path="quotationCommand.quantityEditt"><input type="text" name="quantityEditt" id="quantityEditt[] "class="textbox" onkeyup="editMultiply()" /></spring:bind ></td>'
																											+ '<td><spring:bind path="quotationCommand.perUnitEditt"><input type="text" name="perUnitEditt"  id="perUnitEditt[]" class="textbox" onkeyup="editMultiply()"/></spring:bind></td>'
																											+ '<td><spring:bind path="quotationCommand.lineAmountEditt"><input type="text" name="lineAmountEditt"  id="lineAmountEditt[]" class="textbox"  readonly="readonly"/></spring:bind></td>'
																											+ '<td><spring:bind path="quotationCommand.netPriceEditt"><input type="text" name="netPriceEditt"  id="netPrice" class="textbox" /></spring:bind></td>'
																											+ '<td><form:select path="currencyIdEditt" id="currencyId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${currency }"/></form:select></td>'
																											+ '<td><spring:bind path="quotationCommand.deliveryDateEditt" ><input type="text" name="deliveryDateEditt"  id="editrowdeliveryDate" class="datepicker1 textbox"/></spring:bind></td>'
																											+ '<td><form:select path="statusIdEditt" id="statusId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${status }"/></form:select></td>'
																											+ '<td><form:select path="plantIdEditt" id="plantId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${plant }"/></form:select></td>'
																											+ '<td><form:select path="storageLocIdEditt" id="storageLocId" class="select" cssStyle="height:25px"><form:option value="0">-Select-</form:option><form:options items="${storageId }"/></form:select></td> '
																											+ '</td></tr></table>'
																											+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
																									//add input
																									$(
																											"#addocument")
																											.click(

																													function() {

																														$(
																																options)
																																.fadeIn(
																																		"slow")
																																.appendTo(
																																		'#extender1');
																														//	alert("affk");
																														i++;
																														return false;
																													});

																								});
																								$(
																										'.datepicker')
																										.live(
																												'click',
																												function() {
																													$(
																															this)
																															.datepicker(
																																	'destroy')
																															.datepicker()
																															.focus();
																												});
																								$(
																										'.datepicker1')
																										.live(
																												'click',
																												function() {
																													$(
																															this)
																															.datepicker(
																																	'destroy')
																															.datepicker()
																															.focus();
																												});

																							});
																		</script></td>
																</tr>
															</c:if>
														</c:forEach>
													</table>
													<div id="extender1"></div>
												</div>
											</div>
										</div>
										<input type="submit" value="Update" class="btn btn-primary"
											id="Upbtnid" />
									</div>
								</div>
							</form:form>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>




