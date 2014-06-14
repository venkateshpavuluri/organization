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
	$(document)
			.ready(
					function() {
						//AddForm Validations

						$('#subid')
								.click(
										function(event) {

											$('#addRfqform')
													.validate(
															{
																rules : {
																	rfqType : {
																		required : true
																	},
																	validFrom : {
																		required : true
																	},
																	rfqNo : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	validTo : {
																		required : true
																	},
																	rfqDate : {
																		required : true
																	},
																	storageLocation : {
																		required : true
																	},
																	quotationdeadline : {
																		required : true
																	},
																	palntRfq : {
																		required : true
																	},
																	itemCategory : {
																		required : true

																	},
																	refNumber : {
																		required : true,
																		number:true

																	},
																	deliveryDate : {
																		required : true

																	},
																	purchaseGrouprfq : {
																		required : true

																	},
																	statusid : {
																		required : true

																	},
																	
																},
																messages : {
																	rfqType : "<font style='color: red;'><b>RFQ Type is Required</b></font>",
																	validFrom : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	rfqNo : {
																		required:"<font style='color: red;'><b>RFQ No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	validTo : "<font style='color: red;'><b>Valid To is Required</b></font>",
																	rfqDate : "<font style='color: red;'><b>RFQ Date is Required</b></font>",
																	storageLocation : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	quotationdeadline : "<font style='color: red;'><b>Quotation DeadLine is Required</b></font>",
																	palntRfq : "<font style='color: red;'><b>Plant is Required</b></font>",
																	itemCategory : "<font style='color: red;'><b>Item Category is Required</b></font>",
																	refNumber : {
																	required:"<font style='color: red;'><b>Reference Number is Required</b></font>",
																	number:"<font style='color: red;'><b>Only numerics are allowed.</b></font>"
																	},
																	deliveryDate : "<font style='color: red;'><b>Delivery Date is Required</b></font>",
																	purchaseGrouprfq : "<font style='color: red;'><b>Purchase Group is Required</b></font>",
																	statusid : "<font style='color: red;'><b>Status is Required</b></font>"
																},

															});
											 if($('#purchaseGrouprfq').val()!=0 && $('#rfqType').val()!=0){
												if($('#valueForSubData').val()==0)
												{
												document.getElementById("addmessage").style.display = "block";
												$('#addmessage').html("Warning! Please Enter AtLeast One RFQ Line");
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
																	rfqTypeedit : {
																		required : true
																	},
																	validFromedit : {
																		required : true
																	},
																	rfqNoedit : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true
																	},
																	validToedit : {
																		required : true
																	},
																	rfqDateedit : {
																		required : true
																	},
																	storageLocationedit : {
																		required : true
																	},
																	quotationdeadlineedit : {
																		required : true
																	},
																	palntRfqedit : {
																		required : true
																	},
																	itemCategoryedit : {
																		required : true

																	},
																	refNumberedit : {
																		required : true,
																		number:true

																	},
																	deliveryDateedit : {
																		required : true

																	},
																	purchaseGrouprfqeit : {
																		required : true

																	},
																	statusidedit : {
																		required : true

																	},
																},
																messages : {
																	rfqTypeedit : "<font style='color: red;'><b>RFQ Type is Required</b></font>",
																	validFromedit : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	rfqNoedit : {
																		required:"<font style='color: red;'><b>RFQ No is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	validToedit : "<font style='color: red;'><b>Valid To is Required</b></font>",
																	rfqDateedit : "<font style='color: red;'><b>RFQ Date is Required</b></font>",
																	storageLocationedit : "<font style='color: red;'><b>Storage Location is Required</b></font>",
																	quotationdeadlineedit : "<font style='color: red;'><b>Quotation DeadLine is Required</b></font>",
																	palntRfqedit : "<font style='color: red;'><b>Plant is Required</b></font>",
																	itemCategoryedit : "<font style='color: red;'><b>Item Category is Required</b></font>",
																	refNumberedit:{
																		required:"<font style='color: red;'><b>Reference Number is Required</b></font>",
																		number:"<font style='color: red;'><b>Only numerics are allowed.</b></font>"
																		},
																		deliveryDateedit : "<font style='color: red;'><b>Delivery Date is Required</b></font>",
																	purchaseGrouprfqeit : "<font style='color: red;'><b>Purchase Group is Required</b></font>",
																	statusidedit : "<font style='color: red;'><b>Status is Required</b></font>"
																},
															});

										});

					});
</script>

<script type="text/javascript">
	function dateFun(datePattern) {
		$('#validfrom,#validTo,#deliverydate,#quotationdeadline,#quotationdeadlineedit,#deliverydateedit,#validfromedit,#validToedit,')
		.datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true,
			minDate:0
		});
		$('#rfqdate,#ddate')
				.datepicker({
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
					onSelect: function (date) {
			            var date2 = $('#rfqdate').datepicker('getDate');
			            date2.setDate(date2.getDate() + 0);
			            $('#ddate').datepicker('option', 'minDate', date2);
			        }
				});
		$("#rfqdateedit,#ddateedit")
				.datepicker({
					dateFormat : datePattern,
					changeMonth : true,
					changeYear : true,
						onSelect: function (date) {
				            var date2 = $('#rfqdateedit').datepicker('getDate');
				            date2.setDate(date2.getDate() + 0);
				            $('#ddateedit').datepicker('option', 'minDate', date2);
				           
				        }
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
			$("#rfqnumber").focus();
			$("#basicSearchId").focus();
			$('#edit').hide();
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
<script type="text/javascript">
	function duplicatecheckAjax() {

		//get the form values

		var rfqno = $('#rfqnumber').val();

		$
				.ajax({

					type : "POST",

					url : "RFQDuplicateCheck.mnt",

					data : "rfqno=" + rfqno,

					success : function(response) {

						var checkResponse = "Warning ! RFQ No is already exists. Please try some other name";

						if (checkResponse == response) {

							document.getElementById("RFQSuccessdup").style.display = "block";
							//$('#RFQSuccessdup').html(response);
							$('#subid').hide();
						} else {
							document.getElementById("RFQSuccessdup").style.display = "none";
							$('#subid').show();
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}

	function GetStorLocIds(id) {
		if (id == 'A') {
			var pId = $('#plantRfq').val();
			//alert(pId);
			$.ajax({
				type : "POST",
				url : "getStorLocIds.mnt",
				data : "plantId=" + pId,
				success : function(data) {
					var slId = $('#storageLocation').empty();
					slId.append(new Option("--Select--", ""));
					$.each(data, function(key, value) {
						slId.append(new Option(value, key));

					});

				},
				error : function(e) {
					alert('Error' + e);

				}
			});
		} else {
			var pId = $('#palntRfqedit').val();
			//alert(pId);
			$.ajax({
				type : "POST",
				url : "getStorLocIds.mnt",
				data : "plantId=" + pId,
				success : function(data) {
					var slId = $('#storageLocationedit').empty();
					slId.append(new Option("--Select--", ""));
					$.each(data, function(key, value) {
						slId.append(new Option(value, key));

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
	function duplicatecheckinEdit() {

		//get the form values

		var rfqnameedit = $('#rfqNoedit').val();
		var rfqeditid = $('#rfqidedit').val();

		$
				.ajax({

					type : "POST",

					url : "RFQDuplicateEditCheck.mnt",

					data : "rfqnameedit=" + rfqnameedit + "&rfqeditid="
							+ rfqeditid,

					success : function(response) {

						var checkResponse = "Warning ! RFQ No is already exists. Please try some other name";
						//alert(response);
						if (checkResponse == response) {
							document.getElementById("RFQSuccessdupedit").style.display = "block";
							//$('#RFQSuccessdupedit').html(response);
							$('#updateid').hide();
						} else {
							document.getElementById("RFQSuccessdupedit").style.display = "none";
							$('#updateid').show();
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">RFQ</div>
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
						<form:form action="searchrfq.mnt" method="GET" commandName="RFQ">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.rfq" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.rfq" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${RfqUpdateSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.rfq" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${RfqUpdateFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.rfq" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${RfqDeleteSuccess}">
										<div class="alert-success">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.rfq" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${RfqDeleteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.rfq" />
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
						<form:form action="rfqAdvanceSearch.mnt" method="get"
							commandName="RFQ" name="advanceSearchFinal">
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

					<form:form action="rfqAdvanceSearchOperations.mnt"
						commandName="RFQ">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${rfqSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
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

					<c:if test="${rfqbeans!=null}">
						<div>
							<display:table id="rfqdetailid" name="rfqbeans"
								requestURI="searchrfq.mnt" pagesize="5" class="table">
								<display:column property="rfqid" title="RFQID" media="none"
									sortable="true"></display:column>
								<display:column property="rfqType" titleKey="label.rfqType"
									media="html" sortable="true"></display:column>
								<display:column property="rfqNo" titleKey="label.rfqNo"
									media="html" sortable="true"></display:column>
								<display:column property="rfqDate" titleKey="label.rfqDate"
									media="html" sortable="true"></display:column>
								<display:column property="quotationdeadline"
									titleKey="label.quotationdeadline" media="html" sortable="true"></display:column>
								<display:column property="itemCategory"
									titleKey="label.itemCategory" media="html" sortable="true"></display:column>
								<display:column property="deliveryDate"
									titleKey="label.deliveryDate" media="html" sortable="true"></display:column>
								<display:column property="validFrom" titleKey="label.validFrom"
									media="html" sortable="true"></display:column>
								<display:column property="validTo" titleKey="label.validTo"
									media="html" sortable="true"></display:column>
								<display:column property="storageLocation"
									titleKey="label.storagelocation" media="html" sortable="true"></display:column>
								<display:column property="palntRfq" titleKey="label.plantrfq"
									media="html" sortable="true"></display:column>
								<display:column property="refNumber" titleKey="label.refNumber"
									media="html" sortable="true"></display:column>
								<display:column property="purchaseGrouprfq"
									titleKey="label.purchaseGrouprfq" media="html" sortable="true"></display:column>
								<display:column property="statusid" titleKey="label.rfqstatus"
									media="html" sortable="true"></display:column>
								<display:column titleKey="label.edit" style="color:white">
									<c:choose>
										<c:when test="${true}">
											<a
												href="rfqEdit.mnt?rfqedit=<c:out value="${rfqdetailid.rfqid}"/>"
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
												href="rfqDelete.mnt?rfqdelid=<c:out value="${rfqdetailid.rfqid}"/>"
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
							<td colspan="4" id="RFQSuccessdup" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.rfqNo" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
							
							<td colspan="4" class="alert-warning" id="addmessage"
								style="display: none; width: 450px; height: 25px;"></td>
						
						</tr>
					</table>
					<form:form action="saverfq.mnt" method="POST" commandName="RFQ"
						id="addRfqform">

						<!-- <div id="RFQSuccessdup" class="alert-warning" style="display: none; "></div> -->

						<table class="tableGeneral">
							<tr>
								<td>
									<table class="tableGeneral">


										<form:hidden path="rfqhide" />

										<tr>
											<td><spring:message code="label.rfqNo" /><span
												class="required">*</span></td>
											<td><form:input path="rfqNo" class="textbox" id="rfqnumber"
													onkeyup="duplicatecheckAjax()" maxlength="20" /></td>

											<td><spring:message code="label.validFrom" /><span
												class="required">*</span></td>
											<td><form:input path="validFrom" id="validfrom"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.rfqType" /><span
												class="required">*</span></td>
											<td><form:select path="rfqType" id="rfqType"  class="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${rfqType}" />
												</form:select></td>


											<td><spring:message code="label.validTo" /><span
												class="required">*</span></td>
											<td><form:input path="validTo" id="validTo"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.rfqDate" /><span
												class="required">*</span></td>
											<td><form:input path="rfqDate" id="rfqdate"
													class="textbox" /></td>
											<td><spring:message code="label.plantrfq" /><span
												class="required">*</span></td>
											<td><form:select path="palntRfq" id="plantRfq"
													class="select" onchange="GetStorLocIds('A')">
													<form:option value="">--Select--</form:option>
													<form:options items="${plantrfq}" />
												</form:select></td>

										</tr>
										<tr>
											<td><spring:message code="label.quotationdeadline" /><span
												class="required">*</span></td>
											<td><form:input path="quotationdeadline"
													id="quotationdeadline" class="textbox" /></td>

											<td><spring:message code="label.storagelocation" /><span
												class="required">*</span></td>
											<td><form:select path="storageLocation" class="select"
													id="storageLocation">
													<form:option value="">--Select--</form:option>
													<%-- <form:options items="${storageLocation}" /> --%>
												</form:select></td>


										</tr>
										<tr>
											<td><spring:message code="label.itemCategory" /><span
												class="required">*</span></td>
											<td><form:select path="itemCategory" class="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${Itemcategory}" />
												</form:select></td>
											<td><spring:message code="label.refNumber" /><span
												class="required">*</span></td>
											<td><form:input path="refNumber" class="textbox"
													maxlength="20" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.deliveryDate" /><span
												class="required">*</span></td>
											<td><form:input path="deliveryDate" id="deliverydate"
													class="textbox" /></td>
											<td><spring:message code="label.purchaseGrouprfq" /><span
												class="required">*</span></td>
											<td><form:select path="purchaseGrouprfq" id="purchaseGrouprfq"   class="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${purchaseGroup}" />
												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.rfqstatus" /><span
												class="required">*</span></td>
											<td><form:select path="statusid" class="select">
													<form:option value="">--Select--</form:option>
													<form:options items="${status}" />
												</form:select></td>
											<td>	<input type="hidden" name="valueForSubData"
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
											code="label.rfqline" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

								<!-- <div align="center"> -->

								<script>
									var btrfqid = 1;
									$(function() {

										/* var currentText = $(this).find(":selected").text(); */

										var matid = $("#materialid"), qtid = $("#qty"), umid = $("#uomid"), ddate = $("#ddate"), hiddenrfqID = $("#hiddenIdrfqPopUp"),

										allFields = $([]).add(matid).add(qtid)
												.add(umid).add(ddate).add(
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
																					matid,
																					"Material");
																	bValid1 = bValid1
																			&& checkRegexp(
																					qtid,
																					/^([0-9])+$/i,
																					"Quantity is Required And Must be a Number");

																	bValid1 = bValid1
																			&& checkLength1(
																					umid,
																					"UOM");

																	bValid1 = bValid1
																			&& checkLength1(
																					ddate,

																					"Delivery Date");

																	if (bValid1) {
																		//alert("hiddenid"+hiddenID.val());

																		if (hiddenrfqID
																				.val() == "0"
																				|| hiddenrfqID
																						.val() == "") {

																			$(
																					"#RfqAdd tbody")
																					.append(
																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='materialid' id='materialid"
																									+ btrfqid
																									+ "' value="
																									+ matid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='materialName' id='materialName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#materialid :selected')
																											.text()
																									+ "'"
																									+ " </td>"
																									+ "<td><input type='text' name='qty' id='qty"
																									+ btrfqid
																									+ "' value="
																									+ qtid
																											.val()
																									+ "  class='textbox'readonly/></td>"

																									+ "<td><input type='hidden' name='uomid' id='uomid"
																									+ btrfqid
																									+ "' value="
																									+ umid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='uomName' id='uomName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#uomid :selected')
																											.text()
																									+ "'"
																									+ "</td>"
																									+ "<td><input name='deliverydate' id='ddate"
																									+ btrfqid
																									+ "' value="
																									+ ddate
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
																					'#materialid'
																							+ hiddenrfqID
																									.val())
																					.val(
																							matid
																									.val());

																			$(
																					'#materialName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#materialid :selected')
																									.text());
																			$(
																					'#qty'
																							+ hiddenrfqID
																									.val())
																					.val(
																							qtid
																									.val());
																			$(
																					'#uomid'
																							+ hiddenrfqID
																									.val())
																					.val(
																							umid
																									.val());
																			$(
																					'#uomName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#uomid :selected')
																									.text());

																			$(
																					'#ddate'
																							+ hiddenrfqID
																									.val())
																					.val(
																							ddate
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
										$('#materialid').val(
												$('#materialid' + id).val());
										$('#qty').val($('#qty' + id).val());
										$('#uomid').val($('#uomid' + id).val());
										$('#ddate').val($('#ddate' + id).val());
										$('#hiddenIdrfqPopUp').val(id);

									}
								</script>


								<div id="dialog-form-Rfq" align="center"
									title="<spring:message code="label.rfqlineadd" />">
									<p class="validateTips" align="center">
										<font color="red"></font>
									</p>
									<table class="tableGeneral" cellspacing=0>

										<tr>
											<td><spring:message code="label.materialrfq" /><span
												class="required">*</span></td>
											<td><form:select path="materialid" id="materialid"
													class="select" cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${materialid}" />

												</form:select></td>
										</tr>
										<tr>

											<!-- <td><input type="hidden" id="processNumber" class="select" 
													cssStyle="height:25px;" /> -->


										</tr>
										<tr>
											<td><spring:message code="label.qtyrfq" /><span
												class="required">*</span></td>
											<td><form:input path="qty" id="qty" class="textbox" /></td>
										</tr>
										<tr>
											<td><spring:message code="label.uomrfq" /><span
												class="required">*</span></td>
											<td><form:select path="uomid" id="uomid" class="select"
													cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${uom}" />

												</form:select></td>
										</tr>
										<tr>
											<td><spring:message code="label.ddrfq" /><span
												class="required">*</span></td>
											<td><form:input path="deliverydate" id="ddate"
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
												<th><spring:message code="label.materialrfq" /></th>
												<th><spring:message code="label.qtyrfq" /></th>
												<th><spring:message code="label.uomrfq" /></th>
												<th><spring:message code="label.ddrfq" /></th>
												<th><spring:message code="label.edit" /></th>
												<th><spring:message code="label.remove" /></th>

											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<button id="Rfqlineadd" type="button">
										<spring:message code="label.addrfqline" />
									</button>
								</div>

								<form:hidden path="rfqhide" />

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
					<table>
						<tr>
							<td id="RFQSuccessdupedit" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.rfqNo" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>

					<form:form action="rfqUpdate.mnt" method="POST" commandName="RFQ"
						id="editRfqForm">

						<c:if test="${editvalues!=null}">

							<table class="tableGeneral">
								<form:hidden path="rfqidedit" />
								<tr>

									<td><spring:message code="label.rfqNo" /><span
										class="required">*</span></td>
									<td><form:input path="rfqNoedit" id="rfqNoedit"
											onkeyup="duplicatecheckinEdit()" class="textbox"
											maxlength="20" /></td>
									<td><spring:message code="label.validFrom" /><span
										class="required">*</span></td>
									<td><form:input path="validFromedit" id="validfromedit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.rfqType" /><span
										class="required">*</span></td>
									<td><form:select path="rfqTypeedit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${rfqType}" />
										</form:select></td>

									<td><spring:message code="label.validTo" /><span
										class="required">*</span></td>
									<td><form:input path="validToedit" id="validToedit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.rfqDate" /><span
										class="required">*</span></td>
									<td><form:input path="rfqDateedit" id="rfqdateedit"
											class="textbox" /></td>

									<td><spring:message code="label.plantrfq" /><span
										class="required">*</span></td>
									<td><form:select path="palntRfqedit" class="select"
											id="palntRfqedit" onchange="GetStorLocIds('E')">
											<form:option value="">--Select--</form:option>
											<form:options items="${plantrfq}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.quotationdeadline" /><span
										class="required">*</span></td>
									<td><form:input path="quotationdeadlineedit"
											id="quotationdeadlineedit" class="textbox" /></td>

									<td><spring:message code="label.storagelocation" /><span
										class="required">*</span></td>
									<td><form:select path="storageLocationedit"
											id="storageLocationedit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${storageLocation}" />
										</form:select></td>

								</tr>
								<tr>
									<td><spring:message code="label.itemCategory" /><span
										class="required">*</span></td>
									<td><form:select path="itemCategoryedit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${Itemcategory}" />
										</form:select></td>
									<td><spring:message code="label.refNumber" /><span
										class="required">*</span></td>
									<td><form:input path="refNumberedit" class="textbox"
											maxlength="20" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.deliveryDate" /><span
										class="required">*</span></td>
									<td><form:input path="deliveryDateedit"
											id="deliverydateedit" class="textbox" /></td>
									<td><spring:message code="label.purchaseGrouprfq" /><span
										class="required">*</span></td>
									<td><form:select path="purchaseGrouprfqeit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${purchaseGroup}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.rfqstatus" /><span
										class="required">*</span></td>
									<td><form:select path="statusidedit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${status}" />
										</form:select></td>
								</tr>
							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.rfqline" /></a></li>

								</ul>


								<div align="center">

									<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

									<!-- <div align="center"> -->

									<script>
										var btrfqid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */

											var ematid = $("#materialidedit"), eqtid = $("#qtyedit"), eumid = $("#uomidedit"), eddate = $("#ddateedit"), ehiddenrfqID = $("#hiddenIdrfqeditPopUp")

											allFields = $([]).add(ematid).add(
													eqtid).add(eumid).add(
													eddate).add(ehiddenrfqID),
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

																						"Material");

																		bValid2 = bValid2
																				&& checkRegexp(
																						eqtid,
																						/^([0-9])+$/i,
																						"Quantity is Required And Must be a Number");

																		bValid2 = bValid2
																				&& checkLength2(
																						eumid,

																						"UOM");

																		bValid2 = bValid2
																				&& checkLength2(
																						eddate,
																						"Delivery Date");
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
																										+ "<td ><input type='hidden' name='materialidedit' id='materialidedit"
																										+ btrfqid
																										+ "' value="
																										+ ematid
																												.val()
																										+ " class='textbox'readonly/>  "
																										+ "<input type='text' readonly class='textbox' name='materialNameEdit' id='materialNameEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#materialidedit :selected')
																												.text()
																										+ "'"
																										+ "</td>"
																										+ "<td><input type='text' name='qtyedit' id='qtyedit"
																										+ btrfqid
																										+ "' value="
																										+ eqtid
																												.val()
																										+ "  class='textbox'readonly/></td>"

																										+ "<td><input type='hidden' name='uomidedit' id='uomidedit"
																										+ btrfqid
																										+ "' value="
																										+ eumid
																												.val()
																										+ " class='textbox'readonly/>"
																										+ "<input type='text' readonly class='textbox' name='uomNameEdit' id='uomNameEdit"
																										+ btrfqid
																										+ "' value='"
																										+ $(
																												'#uomidedit :selected')
																												.text()
																										+ "'"
																										+ "</td>"
																										+ "<td><input name='deliverydateedit' id='ddateedit"
																										+ btrfqid
																										+ "' value="
																										+ eddate
																												.val()
																										+ " class='textbox'readonly/><input type='hidden' name='rfqlineidedit' value='0' id='rfqlineidedit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
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
																						'#materialidedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								ematid
																										.val());
																				$(
																						'#materialNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#materialidedit :selected')
																										.text());
																				$(
																						'#qtyedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eqtid
																										.val());
																				$(
																						'#uomidedit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								eumid
																										.val());
																				$(
																						'#uomNameEdit'
																								+ ehiddenrfqID
																										.val())
																						.val(
																								$(
																										'#uomidedit :selected')
																										.text());

																				$(
																						'#ddateedit'
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

											$('#materialidedit').val(
													$('#materialidedit' + id)
															.val());
											$('#qtyedit').val(
													$('#qtyedit' + id).val());
											$('#uomidedit').val(
													$('#uomidedit' + id).val());
											$('#ddateedit').val(
													$('#ddateedit' + id).val());

											$('#hiddenIdrfqeditPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-RfqEdit" align="center"
										title="<spring:message code="label.rfqlineadd" />">
										<p class="validateTips" align="center">
											<font color="red"></font>
										</p>
										<table class="tableGeneral" cellspacing=0>
											<form:hidden path="rfqlineidedit" value="0" />
											<tr>
												<td><spring:message code="label.materialrfq" /><span
													class="required">*</span></td>
												<td><form:select path="materialidedit"
														id="materialidedit" class="select" cssStyle="height:25px;">
														<form:option value="">--Select--</form:option>
														<form:options items="${materialid}" />

													</form:select></td>
											</tr>
											<tr>

												<!-- <td><input type="hidden" id="processNumber" class="select" 
													cssStyle="height:25px;" /> -->


											</tr>
											<tr>
												<td><spring:message code="label.qtyrfq" /><span
													class="required">*</span></td>
												<td><form:input path="qtyedit" id="qtyedit"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.uomrfq" /><span
													class="required">*</span></td>
												<td><form:select path="uomidedit" id="uomidedit"
														class="select" cssStyle="height:25px;">
														<form:option value="">--Select--</form:option>
														<form:options items="${uom}" />

													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.ddrfq" /><span
													class="required">*</span></td>
												<td><form:input path="deliverydateedit" id="ddateedit"
														class="textbox" /> <input type="hidden"
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

													<th><spring:message code="label.materialrfq" /></th>
													<th><spring:message code="label.qtyrfq" /></th>
													<th><spring:message code="label.uomrfq" /></th>
													<th><spring:message code="label.ddrfq" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>


											</thead>
											<tbody>
												<c:forEach items="${rfqlindetails}" var="rfqlindetails">



													<td><spring:bind path="RFQ.rfqlineidedit">
															<input type="hidden" name="rfqlineidedit"
																id="rfqlineidedit${rfqlindetails.rfqlineidedit}"
																value="${rfqlindetails.rfqlineidedit}" />
														</spring:bind></td>





													<tr id="${rfqlindetails.rfqlineidedit}">
														<td><spring:bind path="RFQ.materialidedit">
																<input type="hidden" name="materialidedit"
																	class="textbox"
																	id="materialidedit${rfqlindetails.rfqlineidedit}"
																	value="${rfqlindetails.materialidedit}" />
															</spring:bind> <spring:bind path="RFQ.materialidName">
																<input type="text" name="materialidName" class="textbox"
																	id="materialNameEdit${rfqlindetails.rfqlineidedit}"
																	value="${rfqlindetails.materialidName}" readonly />
															</spring:bind></td>

														<td><spring:bind path="RFQ.qtyedit">
																<input type="text" name="qtyedit"
																	id="qtyedit${rfqlindetails.rfqlineidedit}"
																	class="textbox" value="${rfqlindetails.qtyedit}"
																	readonly />
															</spring:bind></td>
														<td><spring:bind path="RFQ.uomidedit">
																<input type="hidden" name="uomidedit"
																	id="uomidedit${rfqlindetails.rfqlineidedit}"
																	class="textbox" value="${rfqlindetails.uomidedit}"
																	readonly />
															</spring:bind> <spring:bind path="RFQ.uomidName">
																<input type="text" name="uomidName"
																	id="uomNameEdit${rfqlindetails.rfqlineidedit}"
																	class="textbox" value="${rfqlindetails.uomidName}"
																	readonly />
															</spring:bind></td>
														<td><spring:bind path="RFQ.deliverydateedit">
																<input type="text" name="deliverydateedit"
																	id="ddateedit${rfqlindetails.rfqlineidedit}"
																	class="textbox"
																	value="${rfqlindetails.deliverydateedit}" readonly />
															</spring:bind> <input type="hidden"
															name="Checkdelete${rfqlindetails.rfqlineidedit}"
															id="${rfqlindetails.rfqlineidedit}Checkdelete" value="0" /></td>


														<td><a href='#' id="${rfqlindetails.rfqlineidedit}"
															onclick="editRfqEdit(this.id)"><strong><img
																	src='images/Edit.jpg' height='25px' width='25px' /></strong></a></td>
														<td><a href='#' id="${rfqlindetails.rfqlineidedit}"
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
																	'#materialidedit'
																			+ link.id)
																	.val(
																			$(
																					'#materialidedit')
																					.val());
															$('#qtyedit')
																	.val(
																			$(
																					'#qtyedit'
																							+ link.id)
																					.val());
															$('#uomidedit')
																	.val(
																			$(
																					'#uomidedit'
																							+ link.id)
																					.val());
															$('#ddateedit')
																	.val(
																			$(
																					'#ddateedit'
																							+ link.id)
																					.val());

															$(
																	'#hiddenIdrfqeditPopUp')
																	.val(
																			link.id);

														}
													</script>

												</c:forEach>
											</tbody>
										</table>
										<button id="AddRFQEdit" type="button">
											<spring:message code="label.addrfqline" />
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




