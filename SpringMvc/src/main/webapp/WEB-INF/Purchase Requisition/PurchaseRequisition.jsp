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
<link rel="stylesheet"
	href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<!-- <script type="text/javascript" src="js/jquery.ui.datepicker.validation.js"></script> -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumbtnid')
								.click(
										function(event) {

											$('#prAddForm')
													.validate(
															{
																rules : {
																	purchaseReqNo : {
																		required : true,
																		alphanumeric:true
																	},
																	requestedDate : {
																		required : true,
																		date:true
																	},
																	reqDate : {
																		required : true
																		
																	},
																	org_Id : {
																		required : true
																	},
																	description : {
																		required : true
																	},
																	refNo : {
																		required : true,
																		number:true
																	},
																	status_id : {
																		required : true
																	},
																	material_Id : {
																		required : true
																	},
																	quantity : {
																		required : true
																	},
																	requiredDate : {
																		required : true
																	},
																	plantId : {
																		required : true
																	},
																	storageLocationId : {
																		required : true
																	},
																	uom_Id : {
																		required : true
																	}

																},
																messages : {

																	purchaseReqNo : {
																		required:"<font style='color: red;'><b>Purchase Requisition Number is Required</b></font>",
																		alphanumeric:"<font style='color: red;'><b>Purchase Requisition Number only allows AlphaNumeric</b></font>"
																	},
																	requestedDate : {
																		required:"<font style='color: red;'><b>Requested Date is Required</b></font>",
																		date:"<font style='color: red;'><b>Requested Date allows only date format</b></font>"
																	},

																	purchaseReqNo : "<font style='color: red;'><b>Purchase Req No is Required</b></font>",
																	requestedDate : "<font style='color: red;'><b>Requested Date is Required</b></font>",

																	reqDate : "<font style='color: red;'><b>Required Date is Required</b></font>",
																	org_Id : "<font style='color: red;'><b>Organization is Required</b></font>",
																	description : "<font style='color: red;'><b>Description is Required</b></font>",
																	refNo : {
																		required:"<font style='color: red;'><b>Reference Number is Required</b></font>",
																		number:"<font style='color: red;'><b>Reference Number Should be numeric</b></font>"
																		
																	},
																	status_id : "<font style='color: red;'><b>Status is Required</b></font>",

																	material_Id : "<font style='color: red;'><b>Material Id is Required</b></font>",
																	quantity : "<font style='color: red;'><b>Quantity is Required</b></font>",
																	requiredDate : "<font style='color: red;'><b>Required Date is Required</b></font>",
																	plantId : "<font style='color: red;'><b>Plant is Required</b></font>",
																	storageLocationId : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	uom_Id : "<font style='color: red;'><b>UOM is Required</b></font>"
																},

															});
										
						if($('#purchaseReqNo').val()!=0 && $('#requestedDate').val()!=0 && $('#reqDate').val()!=0 && $('#org_Id').val()!=0 && $('#description').val()!=0 && $('#refNo').val()!=0 && $('#status_id').val()!=0){
						if($('#valueForSubData').val()==0)
						{
		document.getElementById("addmessage").style.display = "block";

						$('#addmessage').html("Warning! Please Enter AtLeast One Purchase Requisition Line");

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

						$('#updateid')
								.click(
										function(event) {
											//alert("hai");
											$("#formEdit")
													.validate(
															{
																rules : {
																	purchaseReqNoEdit : {
																		required : true,
																		alphanumeric:true
																	},
																	requestedDateEdit : {
																		required : true
																	},
																	reqDateEdit : {
																		required : true
																	},
																	org_IdEdit : {
																		required : true
																	},
																	descriptionEdit : {
																		required : true
																	},
																	refNoEdit : {
																		required : true,
																		number:true
																	},
																	status_idEdit : {
																		required : true
																	},
																	material_IdEdit : {
																		required : true
																	},
																	quantityEdit : {
																		required : true
																	},
																	requiredDateEdit : {
																		required : true
																	},
																	plantIdEdit : {
																		required : true
																	},
																	storageLocationIdEdit : {
																		required : true
																	},
																	uom_IdEdit : {
																		required : true
																	}

																},
																messages : {

																	purchaseReqNoEdit : {
																		required:"<font style='color: red;'><b>Purchase Requisition Number is Required</b></font>",
																		alphanumeric:"<font style='color: red;'><b>Purchase Requisition Number only allows AlphaNumeric</b></font>"
																	},

																

																	requestedDateEdit : "<font style='color: red;'><b>Requested Date is Required</b></font>",
																	reqDateEdit : "<font style='color: red;'><b>Required Date is Required</b></font>",
																	org_IdEdit : "<font style='color: red;'><b>Organization is Required</b></font>",
																	descriptionEdit : "<font style='color: red;'><b>Description is Required</b></font>",
																	refNoEdit : {
																		required:"<font style='color: red;'><b>Reference Number is Required</b></font>",
																		number:"<font style='color: red;'><b>Reference Number Should be numeric</b></font>"
																		
																	},
																	status_idEdit : "<font style='color: red;'><b>Status is Required</b></font>",
																	material_IdEdit : "<font style='color: red;'><b>Material Id is Required</b></font>",
																	quantityEdit : "<font style='color: red;'><b>Quantity is Required</b></font>",
																	requiredDateEdit : "<font style='color: red;'><b>Required Date is Required</b></font>",
																	plantIdEdit : "<font style='color: red;'><b>Plant is Required</b></font>",
																	storageLocationIdEdit : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	uom_IdEdit : "<font style='color: red;'><b>UOM is Required</b></font>"
																},

															});
										});
					});
</script>

<!--  Date picker -->


<script type="text/javascript">
function dateFun(datePattern) {
	$('#requestedDate,#reqDate,#requireDate,#requestedDateEdit,#requiredDateEdit,#redates,#redatesEdit').datepicker({
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
	width: 90%;
}

<!--
Horizantol scroll -->#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 90%;
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
			$("#purchaseReqNo").val('');
			$("#requestedDate").val('');
			$("#requireDate").val('');
			$("#reqDate").val('');
			$("#org_Id").val('');
			$("#refNo").val('');
			$("#status_id").val('');
			$("#description").val('');
			
			

		});
	});
</script>
<script type="text/javascript">
function AjaxForStorLoc(id, Mode) {
	
		var pId = $('#' + id).val();
		
		var i = 1, msg = null;

		$.ajax({
					type : "POST",
					url : "forStorLocIdsPR.mnt",
					data : "plantId=" + pId,
					success : function(response) {
						
						$("#slId").val(response);
					
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
								document.getElementById("addmessage").style.display = "block";
								$('#addmessage').html(msg);
							} else {
								document.getElementById("addmessage").style.display = "block";
								$('#addmessage').html(msg);
							}

						} else {
							document.getElementById("addmessage").style.display = "none";
							document.getElementById("addmessage").style.display = "none";

							$.each(response, function(key, value) {
								if (i == 1) {
									ss.append(new Option("-Select-", "0"));
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
	</script>


<script type="text/javascript">
	function doAjaxPost() {

		//get the form values

		var purchaseReqNocheck = $('#purchaseReqNo').val();
		$
				.ajax({

					type : "POST",

					url : "purchaseReqNoCheck.mnt",

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

					url : "purchaseReqNoEditCheck.mnt",

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
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		 $("#bsId").focus();
		$('#search,#add').click(function(e) {
			$('#edit').hide();
			 $("#bsId").focus();
			 $("#purchaseReqNo").focus();
			 
			$("#tabsForEdit").hide();

		});
	});
</script>
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Purchase Requisition</div>

		<!-- Tabs Declaration -->
		<div >
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="purchaseReqEditList" items="${purchaseReqEditList}">
						<c:set var="purchaseReqEditList" value="${purchaseReqEditList }"></c:set>
					</c:forEach>
					<c:if test="${purchaseReqEditList!=null}">
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
						<form:form action="PurchaseRequisitionSearch.mnt" method="GET"
							commandName="PurchaseRequisitionCommand">
							
								<tr>
									<td colspan="2"><c:forEach var="padd"
											items="${param.list}">
											<div class="alert-success" id="savemessage">
												<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.purchaseRequisition"/> <spring:message code="label.saveSuccess"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
									<tr>
									<td colspan="2"><c:forEach var="purchaseReqUpdate"
											items="${purchaseReqUpdate}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.purchaseRequisition"/> <spring:message code="label.updateSuccess"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="purchaseReqDelete"
											items="${purchaseReqDelete}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.purchaseRequisition"/> <spring:message code="label.deleteSuccess"></spring:message>
											</div>
										</c:forEach></td>
								</tr>

							
								<tr id="mainSearch"><td><spring:message code="label.searchby"/>
	
								<form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="PurchaseRequisitionCommand.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 	<option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> <form:input path="basicSearchId" id="bsId" Class="textbox" /></td>
									<td><input type="submit" value="Search" class="btn btn-primary"/></td></tr>

							
						</form:form>
							<form:form action="purchaseRequisitionAdvanceSearch.mnt" method="get"
							commandName="PurchaseRequisitionCommand" name="advanceSearchFinal">
						<tr><td>
						<a href="javascript: void(0);" id="advanceSearch" onclick="document.advanceSearchFinal.submit();return false;"><font style="color: blue" id="aslink"><u><b>Advanced Search</b></u></font></a>
						<a href="#" id="basicSearch" style="display: none" ><font style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td></tr>
					</form:form>
					</table>
					
					
					
					<form:form action="purchaseRequisitionAdvanceSearchOperations.mnt" commandName="PurchaseRequisitionCommand">
						<div id="advanceSearchDiv" style="display: none">
						<table class="tableGeneral">
						<c:forEach
										var="xmlLabelValue" items="${purchaseRequisitionSearchAdvance}">
						<tr>
								<td>
										<label>${xmlLabelValue.secondLabel}</label><form:hidden path="firstLabel" id="firstLabel" value="${xmlLabelValue.firstLabel}"/></td>
										 <td> <spring:bind path="PurchaseRequisitionCommand.operations1">
								<select class="select" name="operations1">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind>
									
									
									</td><td><form:input path="advanceSearchText" id="advanceSearch" cssClass="textbox"/></td>
							</tr>
							
							</c:forEach>
							<tr><form:hidden path="advanceSearchHidden" id="advanceSearchHidden" /><td colspan="3"><input type="submit" id="advanceSearchButtonId" value="Advance Search"
									style="display: none" class="btn btn-primary" /></td></tr>
					
						</table>
						
						</div>
</form:form>
						<!-- Displaying  the Searched information by using display tag -->
                       
                       <c:forEach var="pr" items="${prvalues}">

						<c:set var="as" value="${pr}"></c:set>
					</c:forEach>
					

					<c:if test="${as!=null }">
                       
						<display:table id="purchaseRequi" name="purchaseRequi"
							requestURI="PurchaseRequisitionSearch.mnt" pagesize="4"
							class="table">
							<%-- <display:column property="purOrg_Id" title="purOrg_Id" media="html" sortable="true" ></display:column> --%>
							<display:column property="purchaseReqNo" titleKey="label.prno"
								media="html" sortable="true"></display:column>
							<display:column property="requestedDate" titleKey="label.reqdate"
								media="html" sortable="true"></display:column>
							<display:column property="reqDate" titleKey="label.requireddate"
								media="html" sortable="true"></display:column>
							<display:column property="orgname" titleKey="label.prorg"
								media="html" sortable="true" />
							<display:column property="description" titleKey="label.prdesc"
								media="html" sortable="true"></display:column>
							<display:column property="refNo" titleKey="label.prrefno"
								media="html" sortable="true"></display:column>
							<display:column property="status" titleKey="label.prstatus"
								media="html" sortable="true"></display:column>
							<%--  <display:column property="plantName" title="plantName" media="html" sortable="true"/>--%>

							<display:column titleKey="label.edit">
								<a
									href="purchaseReqEditHome.mnt?purchaseReqId=<c:out value="${purchaseRequi.purchaseReq_Id}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column titleKey="label.delete">
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
						<form:form action="PurchaseRequisition.mnt" method="GET"
							commandName="PurchaseRequisitionCommand" id="prAddForm">
							<table class="tableGeneral">
								<form:hidden path="aid" />
								<tr>
								<td colspan="2"><c:forEach
											var="addpurchaseReqDuplicate"
											items="${addpurchaseReqDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning" /></strong>
												<spring:message code="label.purchaseRequisition" />
												<spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
									
								</tr>
								<tr>
									<td><spring:message code="label.prno" /><font color="red">*</font></td>
									<td><form:input path="purchaseReqNo" id="purchaseReqNo"
											class="textbox" onkeyup="doAjaxPost()" /></td>
									
								</tr>
								<tr>
									<td><spring:message code="label.reqdate" /><font
										color="red">*</font></td>
									<td><form:input path="requestedDate" id="requestedDate"
											class="textbox" readonly="readonly" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.requireddate" /><font
										color="red">*</font></td>
									<td><form:input path="reqDate" id="reqDate"
											class="textbox"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.prorg" /><font
										color="red">*</font></td>
									<td><form:select path="org_Id" id="org_Id" class="select">
                                          <form:option value="">-Select-</form:option>
											<form:options items="${organization }" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.prdesc" /><font
										color="red">*</font></td>
									<td><form:textarea path="description" id="description"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.prrefno" /><font
										color="red">*</font></td>
									<td><form:input path="refNo" id="refNo" class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.prstatus" /><font
										color="red">*</font></td>
									<td><form:select path="status_id" id="status_id"
											class="select">
                                            <form:option value="">-Select-</form:option>
											<form:options items="${status }" />
										</form:select></td>
										<td>
										<input type="hidden" name="valueForSubData"
											id="valueForSubData" class="textbox" value="0"/>
											</td>
								</tr>

							</table>
							
                             <div id="tabsForAdd">
								<!-- PurchaseReq Line tab -->
								<ul>
									<li><a href="#subtabs-1"><spring:message code="label.prline"/> </a></li>

								</ul>
							<div id="scroll">
							<div align="center">
							
								
									<script type="text/javascript">
										var qltrid = 1;
										var list = [];
										$(function() {
											var material_Id = $("#materialids"), 
											 mvalue=$("#mNumber"),
											quantity = $("#quantity"),
											uom = $("#uoms"),
											qtyuom = $("#qtyuoms"),
											requiredDate = $("#redates"),
											plantId = $("#plants"),
											plantvalue=$("#pNumber"),
											statusId = $("#statusids"),
											statusvalue=$("#sNumber"),
											storageLocId = $("#slId"),
											storagelocvalue=$("#stNumber"),
											hiddenID = $("#hiddenIdBankPopUp"),
											allFields = $([]).add(material_Id).add(mvalue).add(quantity).add(uom).add(qtyuom).add(requiredDate).add(plantId).add(plantvalue).add(statusId).add(statusvalue).add(storageLocId).add(storagelocvalue).add(hiddenID),
											 tips = $(".validateTips");
											       // alert("hear "+material_Id.val());

	
											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}
											var n = 1;
											function DuplMaterials(
													m) {
												
												var mId = m
														.val();
												if (n == 1) {
													list
															.push(mId);
													n++;
													return true;
												} else {
													var flag = $
															.inArray(
																	mId,
																	list);
													if (flag != -1) {
														alert("Material Name Already Exists!");
														m
																.addClass("ui-state-error");
														updateTips("Warning! Material Name Already Exists");
														return false;

													} else {
														list
																.push(mId);
														updateTips('');
														return true;
													}

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
											
											function selectLength(o, n) {
												
												if (o.val()=='0') {
													o
															.addClass("ui-state-error");
													updateTips(n+" is Required");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp, n) {
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

											$("#dialog-form-QuotLine")
													.dialog(
															{
																autoOpen : false,
																height : 350,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																	
																	
																	var bValid = true, flag = true;
																	flag = DuplMaterials(material_Id
																			);
																	
																		allFields.removeClass("ui-state-error");
																		bValid = bValid
																		&& selectLength(
																				material_Id,
																				"Material"
																				);
																		
																		bValid = bValid
																			&& checkRegexp(
																					quantity,
																					/^([0-9.])+$/i,
																					"Quantity is Required And Must be Number"
																					);
																		bValid = bValid
																		&& selectLength(
																				uom,
																				"UOM"
																				);
																		 
																		 
																		 bValid = bValid
																			&& checkLength(
																					requiredDate,
																					"Required Date",
																					1,
																					16
																					);
																		 bValid = bValid
																			&& selectLength(
																					statusId,
																					"Status"
																					);
																		 bValid = bValid
																			&& selectLength(
																					plantId,
																					"Plant"
																					);
																		
																		 bValid = bValid
																			&& selectLength(
																					storageLocId,
																					"Storage Location"
																					);
																	
																		
																		 if (bValid
																					&& flag) {
																	
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
															$("#quotLineAdd tbody").append(
																								"<tr id="+qltrid+">"
																								+ "<td ><spring:bind path='PurchaseRequisitionCommand.materialids'><input type='hidden' name='materialids' id='materialids"
																								+ qltrid
																								+ "' value="
																								+ material_Id
																										.val()
																								+ " class='textbox'/></spring:bind> <input type='text' name='mNumber' id='mNumber"
																								+ qltrid
																								+ "' value="
																								+ $('#materialids :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																								+ "<td><input name='quantity' id='quantity"
																								+ qltrid
																								+ "' value="
																								+ quantity
																										.val()
																								+ " class='textboxSmall'readonly/></td>"
																								+ "<td><input type='hidden' name='uoms' id='uoms"
																								+ qltrid
																								+ "' value="
																								+ uom
																										.val()
																								+ " class='textbox'/><input type='text' name='qtyuoms' id='qtyuoms"
																								+ qltrid
																								+ "' value="
																								+ $('#uoms :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																								
																								+ "<td><input name='redates' id='redates"
																								+ qltrid
																								+ "' value="
																								+ requiredDate
																										.val()
																								+ " class='textbox'readonly/></td>"
																								+ "<td><input type='hidden' name='statusids' id='statusids"
																								+ qltrid
																								+ "' value="
																								+ statusId
																										.val()
																								+ " class='textbox'/><input type='text' name='sNumber' id='sNumber"
																								+ qltrid
																								+ "' value="
																								+ $('#statusids :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																								+ "<td><input type='hidden' name='plants' id='plants"
																								+ qltrid
																								+ "' value="
																								+ plantId
																										.val()
																								+ " class='textbox'/><input type='text' name='pNumber' id='pNumber"
																								+ qltrid
																								+ "' value="
																								+ $('#plants :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																								
																								+ "<td><input type='hidden' name='storagelocs' id='storagelocs"
																								+ qltrid
																								+ "' value="
																								+ storageLocId
																										.val()
																								+ " class='textbox'/><input type='text' name='stNumber' id='stNumber"
																								+ qltrid
																								+ "' value="
																								+ $('#slId :selected').text()
																								+ " class='textbox'readonly/></td>"
																								+"<td><a href='#'  onclick='editMaterialm("
																								+ qltrid
																								+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																								+ "<td><a href='#'  onclick='removeMaterialm("
																								+ qltrid
																								+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																								+ "</tr>");
															
															$('#valueForSubData').val(qltrid);
																								
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
																								 $('#materialids :selected').text());
																				
																				
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
																								 $('#uoms :selected').text());
																				
																				$(
																						'#requiredDate'
																								+ hiddenID
																										.val())
																						.val(
																								requiredDate
																										.val());
																				$(
																						'#quantity'
																								+ hiddenID
																										.val())
																						.val(
																								quantity.val());
														
																				
																				$(
																						'#plants'
																								+ hiddenID
																										.val())
																						.val(
																								plantId
																										.val());
																				$(
																						'#pNumber'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#plants :selected').text());
																				$(
																						'#statusids'
																								+ hiddenID
																										.val())
																						.val(
																								statusId
																										.val());
																				$(
																						'#sNumber'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#statusids :selected').text());
																				$(
																						'#storagelocs'
																								+ hiddenID
																										.val())
																						.val(
																								storageLocId.val());
																				
																				$(
																						'#stNumber'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#slId :selected').text());
																			
																				$(
																						'#hiddenIdBankPopUp')
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

											
											$("#create-AddQuotLine")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-QuotLine")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeMaterialm(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										
											$('#valueForSubData').val(parseFloat($('#valueForSubData').val())-parseFloat(1));
										}
										function editMaterialm(id) {

												
											$("#dialog-form-QuotLine").dialog(
													"open");
											
											$('#materialids').val(
													$('#materialids' + id).val());
											$('#mNumber').val(
													$('#mNumber' + id).val());
											$('#quantity').val(
													$('#quantity' + id).val());
											$('#uoms').val(
													$('#uoms'+id)
															.val());
											$('#qtyuoms').val($('#qtyuoms' + id).val());
											$('#redates').val(
													$('#redates' + id)
															.val());
											
											$('#plants').val(
													$('#plants' + id).val());
											$('#pNumber').val(
													$('#pNumber' + id).val());
											$('#statusids').val(
													$('#statusids' + id).val());
											$('#sNumber').val(
													$('#sNumber' + id).val());
											$('#slId').val(
													$('#storagelocs' + id)
															.val());
											$('#stNumber').val(
													$('#stNumber' + id).val());
										
											$('#hiddenIdBankPopUp').val(id);
											
										}
									</script>


									<div id="dialog-form-QuotLine" title="Purchase Requisition Line Details">
										<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
										<table class="tableGeneral">
                                              <tr><td></td></tr>
                                              <tr><td></td></tr>
											 <tr>
												<td><spring:message code="label.prmaterial" /><font color="red">*</font></td>
												<td><form:select path="materialids" class="select" id="materialids" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.prqty" /><font color="red">*</font></td>
												<td><form:input path="quantity" id="quantity"
															class="textboxSmall" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.quom" /><font color="red">*</font></td>
													<td><form:select path="uoms" id="uoms" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
											
										
											
											<tr>
												<td><spring:message code="label.requireddate" /><font color="red">*</font></td>
												<td><form:input path="redates" id="redates"
															class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.qstatus" /><font color="red">*</font></td>
												<td><form:select path="statusids" id="statusids" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${status }" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.qplant" /><font color="red">*</font></td>
												<td><form:select path="plants" id="plants" class="select" cssStyle="height:25px" onchange="AjaxForStorLoc(this.id,'AddMode')">
															<form:option value="0">-Select-</form:option>
															<form:options items="${plant }" /> 
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.storloc" /><font color="red">*</font></td>
												<td><form:select path="storagelocs" id="slId" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<%-- <form:options items="${storageId }" /> --%>
														</form:select><input type="hidden"
													name="hiddenIdBankPopUp" id="hiddenIdBankPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-quotLine">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="quotLineAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.prmaterial" /></th>
													<th><spring:message code="label.prqty"/></th>
													<th><spring:message code="label.quom" /></th>
													<th><spring:message code="label.requireddate" /></th>
													<th><spring:message code="label.qstatus" /></th>
													<th><spring:message code="label.qplant" /></th>
													<th><spring:message code="label.storloc" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="create-AddQuotLine" type="button">Add New Purchase Requisition Line</button>
									

								</div>
							</div>
							</div>
							
							<input type="submit" value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbtnid" /><input type="reset" value="<spring:message code="label.reset"/>"
									class="btn btn-primary" />
						</form:form>
					</div>

				</div>
                             
					

				
				<!-- Edit tab -->

				<div id="tabs-1">

					<div align="left" class="TabbedPanelsContent">
						<c:forEach var="purchaseReqEditList"
							items="${purchaseReqEditList}">
							<c:set var="edit" value="${purchaseReqEditList}"></c:set>
						</c:forEach>
   <table>
						<tr>
							<td colspan="4" class="alert-warning" id="editmessage"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
					</table>
						<c:if test="${edit!=null}">
                         
							<form:form action="PurchaseRequisitionedit.mnt" method="GET" commandName="PurchaseRequisitionCommand" id="formEdit">
								
										<table class="tableGeneral">

											<tr>
											<td colspan="2"><c:forEach
											var="addpurchaseReqEditDuplicate"
											items="${addpurchaseReqEditDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning" /></strong>
												<spring:message code="label.purchaseRequisition" />
												<spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
									
											
											</tr>


											<form:hidden path="purchaseReq_IdEdit"
												id="purchaseReq_IdEdit" />
											<form:hidden path="requestedByEdit" />
											<tr>
												<td><spring:message code="label.prno" /><font
													color="red">*</font></td>
												<td><form:input path="purchaseReqNoEdit"
														id="purchaseReqNoEdit" class="textbox"
														onkeyup="doAjaxPostEdit()" /></td>
											
											</tr>
											<tr>
												<td><spring:message code="label.reqdate" /><font
													color="red">*</font></td>
												<td><form:input path="requestedDateEdit"
														id="requestedDateEdit" name="ReqDate" class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.requireddate" /><font
													color="red">*</font></td>
												<td><form:input path="requiredDateEdit"
														id="requiredDateEdit" name="RequireDate" class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.prorg" /><font
													color="red">*</font></td>
												<td><form:select path="org_IdEdit" id="org_IdEdit"
														class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${organization }" />
													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.prdesc" /><font
													color="red">*</font></td>
												<td><form:textarea path="descriptionEdit"
														id="descriptionEdit" class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.prrefno" /><font
													color="red">*</font></td>
												<td><form:input path="refNoEdit" id="refNoEdit"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.prstatus" /><font
													color="red">*</font></td>
												<td><form:select path="status_idEdit"
														id="status_idEdit" class="select">
														<form:option value="">-Select-</form:option>
														<form:options items="${status }" />
													</form:select></td>
											</tr>

										</table>
									
								

					<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.prline" /></a></li>

								</ul>                                                   
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
										var listEdit = [];
										var btrid = 1;
										$(function() {
											var list = ${mList};
											$.each(list, function(index,
													value) {
												listEdit.push(value.toString());

											});
										$( document ).ready(function() {
										 	 
										 	 var updatevalueForSubmit=$('#status_idEdit').val();
										 	 if(updatevalueForSubmit!=1)
										 		 {
										 		// alert("sss");
										 		 document.getElementById("editmessage").style.display="block";
										 		 $('#editmessage').html("Warning ! PR can't be changed at this PR status");
										 		 
										 		 $('#updateid').hide();
										 		 }
										 });
										
											$(function() {

												var materialidsEdit = $("#materialidsEdit"),quantityEdit = $("#quantityEdit"), uomsEdit = $("#uomsEdit"),redatesEdit = $("#redatesEdit"), plantsEdit = $("#plantsEdit"),statusidsEdit = $("#statusidsEdit"),storagelocsEdit = $("#slIdEdit"), hiddenEdit = $("#hiddenIdBankPopUpEdit"),
												
												allFields = $([]).add(materialidsEdit)
														.add(quantityEdit)
														.add(uomsEdit)
														.add(redatesEdit)
														.add(statusidsEdit)
														.add(plantsEdit)
														.add(storagelocsEdit)
														.add(hiddenEdit),
														tips = $(".validateTips");

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
												function DuplMaterialEdit(m) {
													var mId = m.val();
													var flag = $.inArray(mId,
															listEdit);
													if (flag != -1) {
														//alert("Material Name Already Exists!");
														
														m.addClass("ui-state-error");
														updateTips("Warning! Material Name Already Exists");
														return false;

													} else {
														listEdit.push(mId);
														updateTips('');
														return true;
													};

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
																	
												function selectLength(o, n) {
													if (o.val()=='0') {
														o
																.addClass("ui-state-error");
														updateTips(n+" is Required");
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

												$("#dialog-form-BankEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 350,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			
																		  var bValid1 = true, flag = true;
																			
																			flag = DuplMaterialEdit(materialidsEdit);
																		
																			allFields
																					.removeClass("ui-state-error");
																			
																		 
																			bValid1 = bValid1
																			&& selectLength(
																					materialidsEdit,
																					"Material"
																					);
																			
																			bValid1 = bValid1
																				&& checkRegexp(
																						quantityEdit,
																						/^([0-9.])+$/i,
																						"Quantity is Required And Must be Number"
																						);
																			bValid1 = bValid1
																			&& selectLength(
																					uomsEdit,
																					"UOM"
																					);
																			 
																			 
																			 bValid1 = bValid1
																				&& checkLength(
																						redatesEdit,
																						"Required Date",
																						1,
																						16);
																			 bValid1 = bValid1
																				&& selectLength(
																						statusidsEdit,
																						"Status"
																						);
																			 bValid1 = bValid1
																				&& selectLength(
																						plantsEdit,
																						"Plant"
																						);
																			
																			 bValid1 = bValid1
																				&& selectLength(
																						storagelocsEdit,
																						"Storage Location"
																						); 



																			if (bValid1&& flag) {
																				
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					
																					
																					
																					$(
																							"#AddBankEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='PurchaseRequisitionCommand.purchaseReqLineIdEditt'><input type='hidden' name='purchaseReqLineIdEditt' id='purchaseReqLineIdEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											+ "<spring:bind path='PurchaseRequisitionCommand.materialidsEdit'><input type='hidden' name='materialidsEdit' id='materialidsEdit"
																											+ btrid
																											+ "' value="
																											+ materialidsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='PurchaseRequisitionCommand.materiaName'><input type='text' name='materiaName' id='materiaName"
																											+ btrid
																											+ "' value="
																											+$('#materialidsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																										
																										 	+ "<td><spring:bind path='PurchaseRequisitionCommand.quantityEdit'><input name='quantityEdit' id='quantityEdit"
																											+ btrid
																											+ "' value="
																											+ quantityEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='PurchaseRequisitionCommand.uomsEdit'><input type='hidden' name='uomsEdit' id='uomsEdit"
																											+ btrid
																											+ "' value="
																											+ uomsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='PurchaseRequisitionCommand.uomname'><input type='text' name='uomname' id='uomname"
																											+ btrid
																											+ "' value="
																											+$('#uomsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='PurchaseRequisitionCommand.redatesEdit'><input name='redatesEdit' id='redatesEdit"
																											+ btrid
																											+ "' value="
																											+ redatesEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='PurchaseRequisitionCommand.statusidsEdit'><input type='hidden' name='statusidsEdit' id='statusidsEdit"
																											+ btrid
																											+ "' value="
																											+ statusidsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='PurchaseRequisitionCommand.statuName'><input type='text' name='statuName' id='statuName"
																											+ btrid
																											+ "' value="
																											+$('#statusidsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='PurchaseRequisitionCommand.plantsEdit'><input type='hidden' name='plantsEdit' id='plantsEdit"
																											+ btrid
																											+ "' value="
																											+ plantsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='PurchaseRequisitionCommand.plantname'><input type='text' name='plantname' id='plantname"
																											+ btrid
																											+ "' value="
																											+$('#plantsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='PurchaseRequisitionCommand.storagelocsEdit'><input type='hidden' name='storagelocsEdit' id='storagelocsEdit"
																											+ btrid
																											+ "' value="
																											+ storagelocsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='PurchaseRequisitionCommand.storageLoName'><input type='text' name='storageLoName' id='storageLoName"
																											+ btrid
																											+ "' value="
																											+$('#slIdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<input type='hidden' name='purchaseReqLineIdEditt' id='purchaseReqLineIdEditt' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+
																											// "<td>" + password.val() + "</td>" +
																											"<td><a href='#'  onclick='editBankDetailsInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeBankDetailsEditNew("
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
																								$('#materialidsEdit :selected').text());
																				$(
																						'#quantityEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#quantityEdit')
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
																						'#uomname'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#uomsEdit :selected').text());
																				$(
																						'#redatesEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#redatesEdit')
																										.val());
																				$(
																						'#statusidsEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#statusidsEdit')
																										.val());
																				$(
																						'#statuName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#statusidsEdit :selected').text());
																				$(
																						'#plantsEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#plantsEdit')
																										.val());
																				$(
																						'#plantname'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#plantsEdit :selected').text());
																				$(
																						'#slIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#storagelocsEdit')
																										.val());
																				$(
																						'#storageLoName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#slIdEdit :selected').text());
																				$(
																						'#hiddenIdBankPopUpEdit')
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

												$("#create-AddBankEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-BankEdit")
																			.dialog(
																					"open");

																});
											});
										});
											function removeBankDetailsEditNew(
													id) {
												listEdit.pop(parseInt(id) - 1);
												//("removing row " + id);
												$('#' + id).remove();
											}
											function editBankDetailsInEditNew(
													link) {
												listEdit.pop(parseInt(link) - 1);
												//alert(link.id);
												//("hello");
												$("#dialog-form-BankEdit")
														.dialog("open");
												$('#materialidsEdit').val(
														$(
																'#materialidsEdit'
																		+ link)
																.val());
												$('#quantityEdit').val(
														$(
																'#quantityEdit'
																		+ link)
																.val());
												$('#uomsEdit').val(
														$(
																'#uomsEdit'
																		+ link)
																.val());
												$('#redatesEdit').val(
														$(
																'#redatesEdit'
																		+ link)
																.val());
												$('#statusidsEdit').val(
														$(
																'#statusidsEdit'
																		+ link)
																.val());
												$('#plantsEdit').val(
														$(
																'#plantsEdit'
																		+ link)
																.val());
												$('#slIdEdit').val(
														$(
																'#storagelocsEdit'
																		+ link)
																.val());
											   

												$('#hiddenIdBankPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-BankEdit" title="Add New Purchase Requisition Line Details">
											<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
											<table class="tableGeneral">

											 <tr>
												<td><spring:message code="label.prmaterial" /><font color="red">*</font></td>
												<td><form:select path="materialidsEdit" class="select" id="materialidsEdit" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.prqty" /><font color="red">*</font></td>
												<td><form:input path="quantityEdit" id="quantityEdit"
															class="textbox"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.quom" /><font color="red">*</font></td>
													<td><form:select path="uomsEdit" id="uomsEdit" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
											
										
											
											<tr>
												<td><spring:message code="label.requireddate" /><font color="red">*</font></td>
												<td><form:input path="redatesEdit" id="redatesEdit"
															class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.qstatus" /><font color="red">*</font></td>
												<td><form:select path="statusidsEdit" id="statusidsEdit" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${status }" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.qplant" /><font color="red">*</font></td>
												<td><form:select path="plantsEdit" id="plantsEdit" class="select" cssStyle="height:25px" onchange="AjaxForStorLoc(this.id,'EditMode')">
															<form:option value="0">-Select-</form:option>
															<form:options items="${plant }" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.storloc" /><font color="red">*</font></td>
												<td><form:select path="storagelocsEdit" id="slIdEdit" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<%-- <form:options items="${storageId }" /> --%>
														</form:select><input type="hidden"
													name="hiddenIdBankPopUpEdit" id="hiddenIdBankPopUpEdit" value="0" /></td>
											</tr>
 										</table>
										</div>

										<div id="users-contain-BankEdit">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="AddBankEdit" class="table">
												<thead>
													<tr>
													
													<th><spring:message code="label.prmaterial" /></th>
													<th><spring:message code="label.prqty"/></th>
													<th><spring:message code="label.quom" /></th>
													<th><spring:message code="label.requireddate" /></th>
													<th><spring:message code="label.qstatus" /></th>
													<th><spring:message code="label.qplant" /></th>
													<th><spring:message code="label.storloc" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="purchaseReqLineEditList"
															items="${purchaseReqLineEditList}">

															<c:set var="edit1" value="${purchaseReqLineEditList.purchaseReqLine_Id}"></c:set> 
														<%-- 	<c:if test="${edit1!=null}"> --%>
																<tr id="${purchaseReqLineEditList.purchaseReqLine_Id}">
																
                                                                    <spring:bind
																			path="PurchaseRequisitionCommand.purchaseReqLineIdEditt">
																			<input type="hidden" name="purchaseReqLineIdEditt"
																				class="textbox" 
																				value="${purchaseReqLineEditList.purchaseReqLine_Id}" id="purchaseReqLineIdEditt${purchaseReqLineEditList.purchaseReqLine_Id}" />
																		</spring:bind>
																	<spring:bind
																			path="PurchaseRequisitionCommand.materialidsEdit">
																			<input type="hidden" name="materialidsEdit"
																				class="textbox" 
																				value="${purchaseReqLineEditList.material_IdEdit}" id="materialidsEdit${purchaseReqLineEditList.purchaseReqLine_Id}" />
																		</spring:bind>
																		<td><spring:bind
																			path="PurchaseRequisitionCommand.materiaName">
																			<input type="text" name="materiaName"
																				class="textbox" readonly="readonly"
																				value="${purchaseReqLineEditList.materiaName}" id="materiaName${purchaseReqLineEditList.purchaseReqLine_Id}" />
																		</spring:bind></td>
																	<td><spring:bind
																			path="PurchaseRequisitionCommand.quantityEdit">
																			<input type="text" name="quantityEdit"
																				class="textbox" readonly="readonly"
																				value="${purchaseReqLineEditList.qtyEdit}"  id="quantityEdit${purchaseReqLineEditList.purchaseReqLine_Id}"/>
																		</spring:bind></td>
																	<spring:bind
																			path="PurchaseRequisitionCommand.uomsEdit">
																			<input type="hidden" name="uomsEdit"
																				class="textbox" 
																				value="${purchaseReqLineEditList.uomEdit}" id="uomsEdit${purchaseReqLineEditList.purchaseReqLine_Id}"/>
																		</spring:bind>
																		<td><spring:bind
																			path="PurchaseRequisitionCommand.uomname">
																			<input type="text" name="uomname"
																				class="textbox" readonly="readonly"
																				value="${purchaseReqLineEditList.uomname}" id="uomname${purchaseReqLineEditList.purchaseReqLine_Id}" />
																		</spring:bind></td>
																	<td><spring:bind
																			path="PurchaseRequisitionCommand.redatesEdit">
																			<input type="text" name="redatesEdit" id="redatesEdit${purchaseReqLineEditList.purchaseReqLine_Id}"
																				class="textbox" readonly="readonly"
																				value="${purchaseReqLineEditList.requiredDateEdit }" />
																		</spring:bind></td>
																	<spring:bind
																			path="PurchaseRequisitionCommand.statusidsEdit">
																			<input type="hidden" name="statusidsEdit"
																				id="statusidsEdit${purchaseReqLineEditList.purchaseReqLine_Id}" class="textbox"
																				value="${purchaseReqLineEditList.status_IdEdit}"
																				readonly="readonly" />
																		</spring:bind>
																		<td><spring:bind
																			path="PurchaseRequisitionCommand.statuName">
																			<input type="text" name="statuName"
																				class="textbox" readonly="readonly"
																				value="${purchaseReqLineEditList.statuName}" id="statuName${purchaseReqLineEditList.purchaseReqLine_Id}" />
																		</spring:bind></td>
																	<spring:bind
																			path="PurchaseRequisitionCommand.plantsEdit">
																			<input type="hidden" name="plantsEdit" id="plantsEdit${purchaseReqLineEditList.purchaseReqLine_Id}"
																				class="textbox" onchange="AjaxForStorLoc(this.id,'EditMode')"
																				value="${purchaseReqLineEditList.plant_IdEdit }" />
																		</spring:bind>
																		<td><spring:bind
																			path="PurchaseRequisitionCommand.plantname">
																			<input type="text" name="plantname"
																				class="textbox" readonly="readonly"
																				value="${purchaseReqLineEditList.plantname}" id="plantname${purchaseReqLineEditList.purchaseReqLine_Id}" />
																		</spring:bind></td>
																		<spring:bind
																			path="PurchaseRequisitionCommand.storagelocsEdit">
																			<input type="hidden" name="storagelocsEdit" id="storagelocsEdit${purchaseReqLineEditList.purchaseReqLine_Id}"
																				class="textbox" 
																				value="${purchaseReqLineEditList.storegeLoc_IdEdit }" />
																		</spring:bind>
																		<td><spring:bind
																			path="PurchaseRequisitionCommand.storageLoName">
																			<input type="text" name="storageLoName"
																				class="textbox" readonly="readonly"
																				value="${purchaseReqLineEditList.storageLoName}" id="storageLoName${purchaseReqLineEditList.purchaseReqLine_Id}" />
																		</spring:bind>
																	<input type="hidden" name="${purchaseReqLineEditList.purchaseReqLine_Id}Check" id="${purchaseReqLineEditList.purchaseReqLine_Id}Check" value="0"/></td>
																		<td><a href="#"
															id="${purchaseReqLineEditList.purchaseReqLine_Id}"
															onclick="javascript:editBankDetailsInEdit(this)"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="${purchaseReqLineEditList.purchaseReqLine_Id}"></img></a></td>
														<td><a href="#"
															id="${purchaseReqLineEditList.purchaseReqLine_Id}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																id="${purchaseReqLineEditList.purchaseReqLine_Id}"></img></a></td>
																</tr>
		
														
															<!-- <script src="http://code.jquery.com/jquery-1.8.2.js"/>
															<script	src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"/> -->
															<script type="text/javascript">
																function getID1(
																		link) {
																	//alert(link.id);
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link.id
																					+ "Check").value = "1";
																document.getElementById(link.id).style.display = "none";
																}
																function editBankDetailsInEdit(
																		link) {
																	//alert(link.id);
													
																	
																	
																	
																	$(
																			"#dialog-form-BankEdit")																			.dialog(
																					"open");
																	$('#materialidsEdit').val(
																			$(
																					'#materialidsEdit'
																							+ link.id)
																					.val());
																	$('#quantityEdit').val(
																			$(
																					'#quantityEdit'
																							+ link.id)
																					.val());
																	$('#uomsEdit').val(
																			$(
																					'#uomsEdit'
																							+ link.id)
																					.val());
																	$('#redatesEdit').val(
																			$(
																					'#redatesEdit'
																							+ link.id)
																					.val());
																	$('#statusidsEdit').val(
																			$(
																					'#statusidsEdit'
																							+ link.id)
																					.val());
																	$('#plantsEdit').val(
																			$(
																					'#plantsEdit'
																							+ link.id)
																					.val());
																
																	
																	$('#slIdEdit').val(
																			$(
																					'#storagelocsEdit'
																							+ link.id)
																					.val());
																
																	$('#hiddenIdBankPopUpEdit')
																			.val(
																					link.id);

																}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddBankEdit" type="button">Add New
											Purchase Requisition Line</button>

									</div>

								</div>
								</div>
								<table>
									<tr>
										<td colspan=""><input type="submit"
											value="<spring:message code="label.update"/>"
											class="btn btn-primary" id="updateid" /></td>

									</tr>

								</table>
								
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




