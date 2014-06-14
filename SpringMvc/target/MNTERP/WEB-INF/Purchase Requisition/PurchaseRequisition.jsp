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
$(document).ready(function() {
	$('#addBtn').click(function(event) {
		
		$('#prAddForm').validate({
			rules : {
				purchaseReqNo : {required : true},
				requestedDate : {required : true},
				reqDate : {required : true},
				org_Id : {required : true},
				description : {required : true},
				refNo : {required : true},
				status_id : {required : true},
				material_Id : {required : true},
				quantity : {required : true},
				requiredDate : {required : true},
				plantId:{required: true},
				storageLocationId:{required: true},
				uom_Id:{required: true}
				
			},
			messages : {
				purchaseReqNo : "<font style='color: red;'><b>purchaseReqNo is Required</b></font>",
				requestedDate : "<font style='color: red;'><b>Requested Date is Required</b></font>",
				reqDate : "<font style='color: red;'><b>Required Date is Required</b></font>",
				org_Id : "<font style='color: red;'><b>Organization is Required</b></font>",
				description : "<font style='color: red;'><b>Description is Required</b></font>",
				refNo : "<font style='color: red;'><b>Reference Number is Required</b></font>",
				status_id : "<font style='color: red;'><b>Status is Required</b></font>",
				
				material_Id : "<font style='color: red;'><b>Material Id is Required</b></font>",
				quantity : "<font style='color: red;'><b>Quantity is Required</b></font>",
				requiredDate : "<font style='color: red;'><b>Required Date is Required</b></font>",
				plantId : "<font style='color: red;'><b>Plant is Required</b></font>",
				storageLocationId : "<font style='color: red;'><b>Storage Location is Required</b></font>",
					uom_Id:"<font style='color: red;'><b>UOM is Required</b></font>"
			},

		});
	});

	
	$('#updateid').click(function(event) {
		//alert("hai");
		$("#formEdit").validate({
			rules : {
				purchaseReqNoEdit : {required : true},
				requestedDateEdit : {required : true},
				reqDateEdit : {required : true},
				org_IdEdit : {required : true},
				descriptionEdit : {required : true},
				refNoEdit : {required : true},
				status_idEdit : {required : true},
				material_IdEdit : {required : true},
				quantityEdit : {required : true},
				requiredDateEdit : {required : true},
				plantIdEdit:{required: true},
				storageLocationIdEdit:{required: true},
				uom_IdEdit:{required: true}
				
			},
			messages : {
				purchaseReqNoEdit : "<font style='color: red;'><b>purchaseReqNo is Required</b></font>",
				requestedDateEdit : "<font style='color: red;'><b>Requested Date is Required</b></font>",
				reqDateEdit : "<font style='color: red;'><b>Required Date is Required</b></font>",
				org_IdEdit : "<font style='color: red;'><b>Organization is Required</b></font>",
				descriptionEdit : "<font style='color: red;'><b>Description is Required</b></font>",
				refNoEdit : "<font style='color: red;'><b>Reference Number is Required</b></font>",
				status_idEdit : "<font style='color: red;'><b>Status is Required</b></font>",
				
				material_IdEdit : "<font style='color: red;'><b>Material Id is Required</b></font>",
				quantityEdit : "<font style='color: red;'><b>Quantity is Required</b></font>",
				requiredDateEdit : "<font style='color: red;'><b>Required Date is Required</b></font>",
				plantIdEdit: "<font style='color: red;'><b>Plant is Required</b></font>",
				storageLocationIdEdit : "<font style='color: red;'><b>Storage Location is Required</b></font>",
					uom_IdEdit:"<font style='color: red;'><b>UOM is Required</b></font>"
			},

		});
	});
});

</script>

<!--  Date picker -->
<script>
	$(function() {
		$("#requestedDate").datepicker();
		$("#requiredate").datepicker();
		$("#requireDate").datepicker();
		$("#requestedDateEdit").datepicker();
		$("#requiredDateEdit").datepicker();

	});
</script>


<!-- Horizantol scroll -->
<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 95%;
}

<!-- Horizantol scroll -->

#scroll1 {
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
	function doAjaxPost() {

		//get the form values

		var purchaseReqNocheck = $('#purchaseReqNo').val();
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/purchaseReqNoCheck.mnt",

					data : "purchaseReqNocheck=" + purchaseReqNocheck,

					success : function(response) {

						var checkResponse = "Purchase Requisition Already Exists Choose Another One";
						//	alert(response);
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
<script type="text/javascript">
	function doAjaxPostEdit() {

		//get the form values

		var purchaseReqNoEdit = $('#purchaseReqNoEdit').val();
		var purchaseReqIdEdit = $('#purchaseReq_IdEdit').val();
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/purchaseReqNoEditCheck.mnt",

					data : "purchaseReqNoEdit=" + purchaseReqNoEdit
							+ "&purchaseReqIdEdit=" + purchaseReqIdEdit,

					success : function(response) {

						var checkResponse = "Purchase Requisition Already Exists Choose Another One";
						//	alert(response);
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
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Purchase Requisition</div>

		<!-- Tabs Declaration -->
		<div id="scroll">
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="purchaseReqEditList" items="${purchaseReqEditList}">
						<c:set var="purchaseReqEditList" value="${purchaseReqEditList }"></c:set>
					</c:forEach>
					<c:if test="${purchaseReqEditList!=null}">
						<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
					</c:if>
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
				</ul>

				<!-- Search tab part -->

				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">
						<form:form action="PurchaseRequisitionSearch.mnt" method="GET"
							commandName="PurchaseRequisitionCommand">
							<table class="tableGeneral">
								<tr>
									<td>&nbsp;&nbsp;&nbsp;</td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="padd"
											items="${param.list}">
											<div class="alert-success" id="savemessage">
												<strong>Success! </strong>
												<c:out value="${param.success}"></c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="purchaseReqDelete"
											items="${purchaseReqDelete}">
											<div class="alert-success" id="successmessage">
												<strong>Success! </strong>
												<c:out value="${purchaseReqDelete}"></c:out>
											</div>
										</c:forEach></td>
								</tr>

								<%-- <tr>
									<td>Purchase Requisition Id:</td>
									<td><form:input path="purchaseReq_Id" id="purchaseReq_Id"
											class="textbox" /></td>
									<td><input type="submit" value="Search" name="Search"
										id="sumbnid" class="btn btn-primary" /></td>
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
						<!-- Displaying  the Searched information by using display tag -->

						<display:table id="purchaseRequi" name="purchaseRequi"
							requestURI="PurchaseRequisitionSearch.mnt" pagesize="4"
							class="table">
							<%-- <display:column property="purOrg_Id" title="purOrg_Id" media="html" sortable="true" ></display:column> --%>
							<display:column property="purchaseReqNo"
								title="purchase Requisition No" media="html" sortable="true"></display:column>
							<display:column property="requestedDate" title="Requested Date"
								media="html" sortable="true"></display:column>
							<display:column property="reqDate" title="Required Date"
								media="html" sortable="true"></display:column>
							<display:column property="orgname" title="Organization"
								media="html" sortable="true" />
							<display:column property="description" title="Description"
								media="html" sortable="true"></display:column>
							<display:column property="refNo" title="Reference No"
								media="html" sortable="true"></display:column>
							<display:column property="status" title="Status" media="html"
								sortable="true"></display:column>
							<%--  <display:column property="plantName" title="plantName" media="html" sortable="true"/>--%>

							<display:column title="Edit">
								<a
									href="purchaseReqEditHome.mnt?purchaseReqId=<c:out value="${purchaseRequi.purchaseReq_Id}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column title="Delete">
								<a
									href="purchaseReqDelete.mnt?purchaseReqId=<c:out value="${purchaseRequi.purchaseReq_Id}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
							</display:column>

							<!-- For displaying the pagination part -->

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
							<display:setProperty name="paging.banner.group_size" value="3" />
							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>

					</div>
				</div>


				<!-- Add tab details -->

				<div id="tabs-3" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						<form:form action="PurchaseRequisition.mnt" method="GET"
							commandName="PurchaseRequisitionCommand" id="prAddForm">
							<table class="tableGeneral">
								<form:hidden path="aid" />
								<tr>
									<td colspan="2" height="20px"><c:forEach
											var="addpurchaseReqDuplicate"
											items="${addpurchaseReqDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out
														value="${addpurchaseReqDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td>Purchase Requisition No<font color="red">*</font></td>
									<td><form:input path="purchaseReqNo" id="purchaseReqNo"
											class="textbox" onkeyup="doAjaxPost()" /></td>
									<td id="addmessage" class="alert-warning"></td>
									<td><font color="red"></font></td>
								</tr>
								<tr>
									<td>Requested Date<font color="red">*</font></td>
									<td><form:input path="requestedDate" id="requestedDate"
											name="ReqDate" class="textbox" /></td>
								</tr>
								<tr>
									<td>Required Date<font color="red">*</font></td>
									<td><form:input path="reqDate" id="requiredate"
											name="RequireDate" class="textbox" /></td>
								</tr>
								<tr>
									<td>Organization<font color="red">*</font></td>
									<td><form:select path="org_Id" id="org_Id" class="select">

											<form:options items="${organization }" />
										</form:select></td>
								</tr>
								<tr>
									<td>Description<font color="red">*</font></td>
									<td><form:textarea path="description" id="description"
											class="textarea" /></td>
								</tr>
								<tr>
									<td>Reference No<font color="red">*</font></td>
									<td><form:input path="refNo" id="refNo" class="textbox" /></td>
								</tr>
								<tr>
									<td>Status<font color="red">*</font></td>
									<td><form:select path="status_id" id="status_id"
											class="select">

											<form:options items="${status }" />
										</form:select></td>
								</tr>

							</table>
							<!-- Sub tabbing for adding  details -->
							<div id="tabsForAdd">
								<ul>
									<li><a href="#subtabs-1">Purchase Requisition Line</a></li>

								</ul>
								<!-- Plant Details tab -->
								<div id="subtabs-1">
									<div align="left">
										<!-- Selecting the details -->
										<div id="scroll">
											<table class="table">
												<tr>
													<th>Material</th>
													<th>Quantity</th>
													<th>UOM</th>
													<th>Required Date</th>
													<th>Status</th>
													<th>Plant</th>
													<th>Storage Location</th>
												</tr>
												<tr>
													<td><form:select path="material_Id" id="material_Id"
															class="select" cssStyle="height:25px">

															<form:options items="${material }" />
														</form:select></td>
													<td><form:input path="quantity" id="quantity"
															class="textbox" /></td>
													<td><form:select path="uom_Id" id="uom_Id"
															class="select" cssStyle="height:25px">

															<form:options items="${uom }" />
														</form:select></td>
													<td><form:input path="requiredDate" id="requireDate"
															name="RequireDate" class="textbox" /></td>
													<td><form:select path="statusId" id="statusId"
															class="select" cssStyle="height:25px">

															<form:options items="${status }" />
														</form:select></td>
													<td><form:select path="plantId" id="plantId"
															class="select" cssStyle="height:25px">

															<form:options items="${plant }" />
														</form:select></td>

													<td><form:select path="storageLocationId"
															id="storageLocationId" class="select"
															cssStyle="height:25px">

															<form:options items="${storageId }" />
														</form:select></td>
													<td><a href="#" id="addoc"><img
															src="images/add (1).png"></img></a> <script
															src="http://code.jquery.com/jquery-1.8.2.js"></script> <script
															src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
															<script type="text/javascript" src="js/jquery.validate.min.js"></script>
														<script type="text/javascript">
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

																					var options = '<table border="0" ><tr><td>'
																							+ '<table style="float:left;" border="0" ><tr>'
																							+ '<td><form:select path="material_Id" id="material_Id" class="select" cssStyle="height:25px"> <form:options items="${material }"/></form:select></td><td><form:input path="quantity" id="quantity" class="textbox" /></td><td><form:select path="uom_Id" id="uom_Id" class="select" cssStyle="height:25px"><form:options items="${uom }"/></form:select></td><td><form:input path="requiredDate" id="requireDate" name="RequireDate" class="textbox"/></td><td><form:select path="statusId" id="statusId" class="select" cssStyle="height:25px"><form:options items="${status }"/></form:select></td><td><form:select path="plantId" id="plantId" class="select" cssStyle="height:25px"><form:options items="${plant }"/>	</form:select></td><td><form:select path="storageLocationId" id="storageLocationId" class="select" cssStyle="height:25px"><form:options items="${storageId }"/></form:select></td>'
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
								class="btn btn-primary"  id="addBtn"/>
							<input type="reset" class="btn btn-primary" />

						</form:form>

					</div>
				</div>

				<!-- Edit tab -->

				<div id="tabs-1">

					<div id="tabsForEdit">
						<c:forEach var="purchaseReqEditList"
							items="${purchaseReqEditList}">
							<c:set var="edit" value="${purchaseReqEditList}"></c:set>
						</c:forEach>

						<c:if test="${edit!=null}">

							<form:form action="PurchaseRequisitionedit.mnt" method="GET"
								commandName="PurchaseRequisitionCommand" id="formEdit">
								<div id="tabs-3" class="TabbedPanelsContent">
									<div align="left" class="TabbedPanelsContent">
										<table class="tableGeneral">

											<tr>
												<td colspan="2" height="20px"><c:forEach
														var="addpurchaseReqEditDuplicate"
														items="${addpurchaseReqEditDuplicate}">
														<div class="alert-warning" id="savemessage">
															<font color="red"><c:out
																	value="${addpurchaseReqEditDuplicate}" /></font>
														</div>
													</c:forEach></td>
											</tr>


											<form:hidden path="purchaseReq_IdEdit"
												id="purchaseReq_IdEdit" />
											<form:hidden path="requestedByEdit" />
											<tr>
												<td>Purchase Requisition No<font color="red">*</font></td>
												<td><form:input path="purchaseReqNoEdit"
														id="purchaseReqNoEdit" class="textbox"
														onkeyup="doAjaxPostEdit()" /></td>
												<td id="editmessage" class="alert-warning"></td>
												<td><font color="red"></font></td>
											</tr>
											<tr>
												<td>Requisition Date<font color="red">*</font></td>
												<td><form:input path="requestedDateEdit"
														id="requestedDateEdit" name="ReqDate" class="textbox" /></td>
											</tr>
											<tr>
												<td>Required Date<font color="red">*</font></td>
												<td><form:input path="requiredDateEdit"
														id="requiredDateEdit" name="RequireDate" class="textbox" /></td>
											</tr>
											<tr>
												<td>Organization<font color="red">*</font></td>
												<td><form:select path="org_IdEdit" id="org_IdEdit"
														class="select">
														<form:options items="${organization }" />
													</form:select></td>
											</tr>
											<tr>
												<td>Description<font color="red">*</font></td>
												<td><form:textarea path="descriptionEdit"
														id="descriptionEdit" class="textarea" /></td>
											</tr>
											<tr>
												<td>Reference No<font color="red">*</font></td>
												<td><form:input path="refNoEdit" id="refNoEdit"
														class="textbox" /></td>
											</tr>
											<tr>
												<td>Status<font color="red">*</font></td>
												<td><form:select path="status_idEdit"
														id="status_idEdit" class="select">
														<form:options items="${status }" />
													</form:select></td>
											</tr>

										</table>
									</div>
								</div>
								<div id="tabs-1" class="TabbedPanelsContent">
									<div align="left" class="TabbedPanelsContent">

										<div id="tabsForAdd">
											<ul>
												<li><a href="#tabs-1">PurchaseReq Line</a></li>
											</ul>
											<div id="tabs-1">
												<div align="left">

													<div id="scroll1">
														<table class="table">
															<tr>
																<th>Material</th>
																<th>Quantity</th>
																<th>UOM</th>
																<th>Required Date</th>
																<th>Status</th>
																<th>Plant</th>
																<th>Storage Location</th>
															</tr>
															<c:forEach var="purchaseReqLineEditList"
																items="${purchaseReqLineEditList}">
																<c:set var="edit1" value="${purchaseReqLineEditList}"></c:set>
																<c:if test="${edit1!=null}">


																	<tr>
																		<td><form:select path="material_IdEdit"
																				id="material_IdEdit" class="select"
																				cssStyle="height:25px">

																				<form:options items="${material }" />
																			</form:select></td>
																		<td><spring:bind
																				path="PurchaseRequisitionCommand.quantityEdit">
																				<input type="text" name="quantityEdit"
																					class="textbox"
																					value="${purchaseReqLineEditList.qtyEdit}" />
																			</spring:bind></td>
																		<td><form:select path="uom_IdEdit"
																				id="uom_IdEdit" class="select"
																				cssStyle="height:25px">

																				<form:options items="${uom }" />	requiredDateEdit
		                                                            </form:select></td>
																		<td><spring:bind
																				path="PurchaseRequisitionCommand.EditreqiuiredDate">
																				<input type="text" name="EditreqiuiredDate"
																					class="textbox"
																					value="${purchaseReqLineEditList.requiredDateEdit}" />
																			</spring:bind></td>
																		<td><form:select path="statusIdEdit"
																				id="statusIdEdit" class="select"
																				cssStyle="height:25px">

																				<form:options items="${status }" />
																			</form:select></td>
																		<td><form:select path="plantIdEdit"
																				id="plantIdEdit" class="select"
																				cssStyle="height:25px">

																				<form:options items="${plant }" />
																			</form:select></td>

																		<td><form:select path="storageLocationIdEdit"
																				id="storageLocationIdEdit" class="select"
																				cssStyle="height:25px">

																				<form:options items="${storageId }" />
																			</form:select></td>
																			<td><a href="#" id="addocment"><img
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
																												+ '<td><form:select path="material_IdEdit" id="material_IdEdit" class="select" cssStyle="height:25px"><form:options items="${material }"/></form:select></td><td><form:input path="quantityEdit" id="quantityEdit" class="textbox" /></td><td><form:select path="uom_IdEdit" id="uom_IdEdit" class="select" cssStyle="height:25px"><form:options items="${uom }"/></form:select></td><td><form:input path="EditreqiuiredDate" id="EditreqiuiredDate" name="RequireDate" class="textbox"/></td><td><form:select path="statusIdEdit" id="statusIdEdit" class="select" cssStyle="height:25px"><form:options items="${status }"/></form:select></td></td><td><form:select path="plantIdEdit" id="plantIdEdit" class="select" cssStyle="height:25px"><form:options items="${plant }"/>	</form:select></td><td><form:select path="storageLocationIdEdit" id="storageLocationIdEdit" class="select" cssStyle="height:25px"><form:options items="${storageId }"/></form:select></td>'
																												+ '</td></tr></table>'
																												+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
																										//add input
																										$(
																												'#addocment')
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
										</div>
									</div>
								</div>
								<input type="submit" value="Update" class="btn btn-primary"
									id="updateid" />
							</form:form>
						</c:if>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>

</html>




