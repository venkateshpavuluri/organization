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


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
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
	$(document).ready(function() {
						//AddForm Validations
						$('#subid')
								.click(
										function(event) {
											
											$('#addCiform')
													.validate(
															{
																rules : {
																	customerinvoiceno : {
																		required : true },
																		customerinvoicedate:{
																			required : true	
																		},
																		postingdate:{
																			required : true	
																		},
																		deliverynoteid:{
																			required : true	
																		},																		
																		amount:{
																			required : true	
																		},
																		currencyid:{
																			required : true	
																		},
																		reference:{
																			required : true	
																		},
																		description:{
																			required : true	
																		},
																		orgid:{
																			required : true
																		}, 
																		fy:{
																			required : true
																			
																		}, 
																		
																		
																},
																 messages : {
																	 customerinvoiceno : "<font style='color: red;'><b>Customer Invoice No is Required</b></font>",
																	 customerinvoicedate : "<font style='color: red;'><b>Customer Invoice Date is Required</b></font>",
																	 postingdate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	 deliverynoteid : "<font style='color: red;'><b>Delivery Note is Required</b></font>",
																	 amount : "<font style='color: red;'><b>Amount is Required</b></font>",
																	 currencyid : "<font style='color: red;'><b>Currency  is Required</b></font>",
																	 reference : "<font style='color: red;'><b>Reference is Required</b></font>",
																	 description : "<font style='color: red;'><b>Description is Required</b></font>",
																	 orgid : "<font style='color: red;'><b>Organization is Required</b></font>", 
																	 fy : "<font style='color: red;'><b>Financial Year is Required</b></font>",
																	 
																	 
																 },

															});
										});
	
						
						
						$('#updatevid')
						.click(
								function(event) {
									
									
									$('#editCustomerInvoiceForm')
											.validate(
													{
														rules : {
															editcustomerinvoiceno : {
																required : true },
																editcustomerinvoicedate:{
																	required : true	
																},
																editpostingdate:{
																	required : true	
																},
																editdeliverynoteid:{
																	required : true	
																},																		
																editamount:{
																	required : true	
																},
																editcurrencyid:{
																	required : true	
																},
																editreference:{
																	required : true	
																},
																editdescription:{
																	required : true	
																},
																editorgid:{
																	required : true
																}, 
																editfy:{
																	required : true
																	
																}, 
																
																
														},
														 messages : {
															 editcustomerinvoiceno : "<font style='color: red;'><b>Customer Invoice No is Required</b></font>",
															 editcustomerinvoicedate : "<font style='color: red;'><b>Customer Invoice Date is Required</b></font>",
															 editpostingdate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
															 editdeliverynoteid : "<font style='color: red;'><b>Delivery Note is Required</b></font>",
															 editamount : "<font style='color: red;'><b>Amount is Required</b></font>",
															 editcurrencyid : "<font style='color: red;'><b>Currency  is Required</b></font>",
															 editreference : "<font style='color: red;'><b>Reference is Required</b></font>",
															 editdescription : "<font style='color: red;'><b>Description is Required</b></font>",
															 editorgid : "<font style='color: red;'><b>Organization is Required</b></font>", 
															 editfy : "<font style='color: red;'><b>Financial Year is Required</b></font>",
															 
															 
														 },

													});
								});
						
						
						
						
						

					});

</script> 
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
	
	function addAmount()
	{
		var amount=$('#price').val();
		var totalAmount=$('#tax').val();
		
		
	var	sum = (parseFloat(amount) + parseFloat(totalAmount));
	var ji=Number(sum);
		//$('#amount').val(ji);
		$('#hiddenamount').val(ji);
		
	}
	function addtotalAmount()
	{
		var amount=0;
		 amount=$('#hiddenamount').val();
	
		var totalAmount=$('#amount').val();
		var	sum = (parseFloat(amount) + parseFloat(totalAmount));
		var ji=Number(sum);
		$('#amount').val(ji);
	}
	
	function addAmountEdit()
	{
		var amount=$('#editprice').val();
		var totalAmount=$('#edittax').val();
	var	sum = (parseFloat(amount) + parseFloat(totalAmount));
	var ji=Number(sum);
		//$('#amount').val(ji);
		$('#hiddenamountEdit').val(ji);
		
	}
	function addtotalAmountEdit()
	{
		var amount=0;
		 amount=$('#hiddenamountEdit').val();
		var totalAmount=$('#amountEdit').val();
		var	sum = (parseFloat(amount) + parseFloat(totalAmount));
		var ji=Number(sum);
		$('#amountEdit').val(ji);
	}
	
	
	
</script>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>
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
function dateFun(datePattern) {
	$('#customerinvoicedate,#postingdate,#editpostingdate,#editcustomerinvoicedate').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>
<!-- <script>
$(function() {
$("#customerinvoicedate,#postingdate,#editpostingdate,#editcustomerinvoicedate").datepicker();
});
</script> -->
<script type="text/javascript">
	function duplicatecicheckAjax() {

		//get the form values

		var cinno = $('#customerinvoiceno').val();
		$
				.ajax({

					type : "POST",

					url : "CIDuplicateCheck.mnt",

					data : "cinno=" + cinno,

					success : function(response) {

						var checkResponse = "Warning ! Customer Invoice No is already exists. Please try some other name";
						
						if (checkResponse == response) {

							document.getElementById("customerdup").style.display = "block";
							//$('#customerdup').html(response);
							$('#subid').hide();
						} else {
							document.getElementById("customerdup").style.display = "none";
							$('#subid').show();
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
</script>

<script type="text/javascript">
	function duplicatecheckinciEdit() {

		//get the form values

		var cinameedit = $('#editcustomerinvoiceno').val();
		var cieditid = $('#editcustomerinvoiceid').val();
	
		$
				.ajax({

					type : "POST",

					url : "CIDuplicateEditCheck.mnt",

					data : "cinameedit=" + cinameedit + "&cieditid="
							+ cieditid,

							success : function(response) {

								var checkResponse = "Warning ! Customer Invoice No is already exists. Please try some other name";
								
								if (checkResponse == response) {
									document.getElementById("cisuccessdupedit").style.display = "block";
									//$('#cisuccessdupedit').html(response);
									$('#updatevid').hide();
								} else {
									document.getElementById("cisuccessdupedit").style.display = "none";
									$('#updatevid').show();
								}
							},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
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
		$('#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Customer Invoice</div>
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
						<form:form action="searchCustomerinvoice.mnt" method="GET"
						commandName="CUSTOMERINVOICE">
							<tr>
								<td colspan="2"><c:forEach 
										items="${param.list}">
										<div class="alert-success" id="savemessage">
                                            <strong><spring:message code="label.success"/> </strong>
                                            <spring:message code="label.customerInvoice"/> <spring:message code="label.saveSuccess"/>
											
										</div>
									</c:forEach>
									
									<c:forEach 
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
                                            <strong><spring:message code="label.error"/> </strong>
                                            <spring:message code="label.customerInvoice"/> <spring:message code="label.saveFail"/>
											
										</div>
									</c:forEach>
									
									<c:forEach
										items="${CIUpdateSuccess}">
										<div class="alert-success" id="successmessage">
											 <strong><spring:message code="label.success"/> </strong>
                                            <spring:message code="label.customerInvoice"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach>
									
									
									<c:forEach items="${CIUpdateFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
                                            <spring:message code="label.customerInvoice"/> <spring:message code="label.updateFail"/>
										</div>
									</c:forEach>
									<c:forEach
										items="${CIDeleteSuccess}">
										<div class="alert-success" id="successmessage">
											 <strong><spring:message code="label.success"/> </strong>
                                            <spring:message code="label.customerInvoice"/> <spring:message code="label.deleteSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach
										items="${CIDeleteFail}">
										<div class="alert-danger" id="successmessage">
											 <strong><spring:message code="label.error"/> </strong>
                                            <spring:message code="label.customerInvoice"/> <spring:message code="label.deleteFail"/>
										</div>
									</c:forEach>
									
									</td>
								
							</tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" />
								<form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> 
									<spring:bind path="CUSTOMERINVOICE.operations">
								<select class="select" name="operations" >
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
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
							
								<td>
								<c:choose>
								<c:when test="${true }">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary"  /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger"  />
									</c:otherwise>
								</c:choose></td>
							</tr>
							</form:form>
							<form:form action="ciAdvanceSearch.mnt" method="get"
							commandName="CUSTOMERINVOICE" name="advanceSearchFinal">
							<tr>
								<td><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue"><u><b>Advanced Search</b></u></font></a> <a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							</tr>
						</form:form>
						</table>
					
	        <form:form action="ciAdvanceSearchOperations.mnt" commandName="CUSTOMERINVOICE">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${ciSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1" cssClass="textbox">
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
									<td colspan="3">
									
									<c:choose>
									<c:when test="${true }">
									<input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" /></c:when>
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
					<c:forEach var="cibeans" items="${cibeans}">
						<c:set var="ag" value="${cibeans}"></c:set>
						
						
					</c:forEach>
					<c:if test="${ag!=null}">
					<div >
						<display:table id="cidetailid" name="cibeans"
							requestURI="searchCustomerinvoice.mnt" pagesize="5" class="table">
							<display:column property="customerinvoiceid" title="ciid"
								media="none" sortable="true"></display:column>
							<display:column property="customerinvoiceno" titleKey="label.cino"  media="html"
								sortable="true"></display:column>
								<display:column property="customerinvoicedate" titleKey="label.cid" media="html"
								sortable="true"></display:column>
								<display:column property="postingdate" titleKey="label.postDate" media="html"
								sortable="true"></display:column>
								<display:column property="deliverynoteid" titleKey="label.deliverynote" media="html"
								sortable="true"></display:column>
								<display:column property="amount" titleKey="label.amount" media="html"
								sortable="true"></display:column>
								<display:column property="currencyid" titleKey="label.curr" media="html"
								sortable="true"></display:column>
								<display:column property="reference" titleKey="label.ref" media="html"
								sortable="true"></display:column>
								<display:column property="description" titleKey="label.des" media="html"
								sortable="true"></display:column>
								<display:column property="orgid" titleKey="label.org" media="html"
								sortable="true"></display:column>
								<display:column property="fy" titleKey="label.fy" media="html"
								sortable="true"></display:column>
								
								
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
								<a
									href="customerinvoiceEdit.mnt?ciedit=<c:out value="${cidetailid.customerinvoiceid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px" onclick="toggleTable();" 
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${true }">

								<a
									href="ciDelete.mnt?cidelid=<c:out value="${cidetailid.customerinvoiceid}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a></c:when>
									<c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger"
									width="20px" height="20px"/> </a>
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

					<form:form action="savecustomerinvoice.mnt" method="POST"
							commandName="CUSTOMERINVOICE" id="addCiform">

<!-- <div id="customerdup" class="alert-warning" style="display: none;"></div> -->



							<table class="tableGeneral">
                     	<tr><td>
								<table class="tableGeneral">
						
						<tr>
						<td  id="customerdup" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.cino" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
							
							<tr>
								<td><spring:message code="label.cino" /><span
									class="required">*</span> </td>
									<td><form:input path="customerinvoiceno" 
										class="textbox" maxlength="50" onkeyup="duplicatecicheckAjax()" /></td>
								
								<td><spring:message code="label.des" /><span
									class="required">*</span> </td>
									<td><form:input path="description" 
										class="textbox"  /></td></tr>
										
								<tr><td><spring:message code="label.cid" />
								<span class="required">*</span></td>
									<td> <form:input path="customerinvoicedate" id="customerinvoicedate"
										class="textbox"  /></td>
										
										<td><spring:message code="label.deliverynote" /><span class="required">*</span></td>
									<td><form:select path="deliverynoteid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${deliverynote}" />
								</form:select></td></tr>
										
						<tr><td><spring:message code="label.postDate" /><span
									class="required">*</span></td>
									<td> <form:input path="postingdate" id="postingdate"
										class="textbox"  /></td>
										<td><spring:message code="label.org" /><span
									class="required">*</span></td>
									<td><form:select path="orgid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${org}" />
								</form:select></td></tr>
								
								
						<tr><td><spring:message code="label.amount" /><span
									class="required">*</span> </td>
									<td> <input type="hidden" id="hiddenamount" value="0"/> <form:input path="amount" readonly="true" id="amount"
										class="textbox"  /></td>
										<td><spring:message code="label.fy" /><span
									class="required">*</span></td>
									<td><form:input path="fy" 
										class="textbox" maxlength="50" /></td>
										</tr>
										
										<tr><td><spring:message code="label.curr" /><span
									class="required">*</span></td>
									<td><form:select path="currencyid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${currency}" />
								</form:select></td>
								
										
								<td><spring:message code="label.ref" /><span
									class="required">*</span></td>
									<td> <form:input path="reference" 
										class="textbox" maxlength="50" /></td>
										</tr>
										
										
						
							
							</table>
							</td>

							</tr>
							</table>
						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message code="label.customerinvoiceline" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->
									
									<!-- <div align="center"> -->
									
									 <script>
										var btviid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */
											
											
											var matid = $("#materialid"), qtid = $("#qty"),umid=$("#uomid"), price = $("#price"), tax = $("#tax"), hiddenviID = $("#hiddenIdVIPopUp")
											
											
											allFields = $([]).add(matid).add(qtid).add(umid).add(price).add(tax).add(hiddenviID),
											 tips = $(".validateTips");

											

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
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
											function checkLength1(o, n) {
												if (o.val().length =="") {
													o
															.addClass("ui-state-error");
													updateTips("Required");
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

											$("#dialog-form-VI")
													.dialog(
															{
																autoOpen : false,
																height : 350,
																width : 400,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid1 = true;
																		allFields.removeClass("ui-state-error");
                                    										 	  bValid1 = bValid1
																					&& checkLength1(
																							matid,
																							
																							"Material is Required");
																			
																	 	bValid1 = bValid1
																					&& checkLength1(
																							umid,
																						
																							"UOM");
																			bValid1 = bValid1
																			&& checkLength1(
																					qtid,
																					/^([0-9])+$/i,
																					"Quantity is Required And Must be  Number");
																			bValid1 = bValid1
																					&& checkLength1(
																							price,
																							
																							"Price ");   
																			bValid1 = bValid1
																			&& checkLength1(
																					tax,
																					
																					"Tax "); 
																
																	 	if (bValid1) {
																			//alert("hiddenid"+hiddenID.val());
																			
																			if (hiddenviID
																					.val() == "0"
																					|| hiddenviID
																							.val() == "") {

																				$("#VIAdd tbody")
																						.append(
																								"<tr id="+btviid+">"
																										+ "<td ><input type='hidden' name='materialid' id='materialid"
																										+ btviid
																										+ "' value="
																										+ matid
																												.val()
																										+ " class='textbox'readonly/>"
																										+"<input type='text' readonly class='textbox' name='materialName' id='materialName"+btviid+"' value='"+$('#materialid :selected').text()+"'"
																										 +" </td>"
																										+ "<td align='center'><input type='text' name='qty' id='qty"
																										+ btviid
																										+ "' value="
																										+ qtid
																												.val()
																										+ "  class='textbox'readonly/></td>"
																									
																										+ "<td><input type='hidden' name='uomid' id='uomid"
																										+ btviid
																										+ "' value="
																										+ umid
																												.val()
																										+ " class='textbox'readonly/>"
																										+"<input type='text' readonly class='textbox' name='uomName' id='uomName"+btviid+"' value='"+$('#uomid :selected').text()+"'"
																										+"</td>"
																										+ "<td><input name='price' id='price"
																										+ btviid
																										+ "' value="
																										+ price
																												.val()
																										+ " class='textbox'readonly/></td>"
																										+ "<td><input name='tax' id='tax"
																										+ btviid
																										+ "' value="
																										+ tax
																												.val()
																										+ " class='textbox'readonly/></td>"
																										+

																										// "<td>" + password.val() + "</td>" +
																										"<td><a href='#'  onclick='editvi("
																										+ btviid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removevi("
																										+ btviid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btviid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																			if (hiddenviID
																					.val() != "0") {
																				$(
																						'#materialid'
																								+ hiddenviID
																										.val())
																						.val(
																								matid
																										.val());
																				
																				
																				
																				
																				
																				$(
																						'#materialName'
																								+ hiddenviID
																										.val())
																						.val(
																								$('#materialid :selected').text());
																				$(
																						'#qty'
																								+ hiddenviID
																										.val())
																						.val(
																								qtid
																										.val());
																				$(
																						'#uomid'
																								+ hiddenviID
																										.val())
																						.val(
																								umid
																										.val());
																				$(
																						'#uomName'
																								+ hiddenviID
																										.val())
																						.val(
																								$('#uomid :selected').text());
																				
																				
																				$(
																						'#price'
																								+ hiddenviID
																										.val())
																						.val(price.val());
																				
																				$(
																						'#tax'
																								+ hiddenviID
																										.val())
																						.val(tax.val());
																				
																				
																				$(
																						'#hiddenIdVIPopUp')
																						.val(
																								"0");
																				$(
																						this)
																						.dialog(
																								"close");
																				addtotalAmount();
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

										
											$("#VendorInvoicelineadd")
													.button()
													.click(
															function() {
																$("#dialog-form-VI")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removevi(id) {
											//alert("removing row " + id);
											var totalAmount=$('#amount').val();
											var price=0;
											var tax=0;
											price=$('#price'+id).val();
											tax=$('#tax'+id).val();
						
											var	sum = (parseFloat(price)+parseFloat(tax));
											var ji=Number(sum);
											var exactAmount=(parseFloat(totalAmount)-parseFloat(ji));
											//alert(exactAmount);
											$('#amount').val(exactAmount);
											$('#' + id).remove();
										}
										function editvi(id) {
											//alert("edit row " + id);
											$("#dialog-form-VI").dialog("open");
										    $('#materialid').val($('#materialid' + id).val());
											$('#qty').val($('#qty' + id).val());
											$('#uomid').val($('#uomid' + id).val());
											$('#price').val($('#price' + id).val());
											$('#tax').val($('#tax' + id).val());
											$('#hiddenIdVIPopUp').val(id);
										
									}
									</script> 


									 <div id="dialog-form-VI" align="center" title="<spring:message code="label.addcidetails"/>">
										<p class="validateTips" align="center" ></p>
										<table class="tableGeneral" cellspacing=0>
											
									<tr><td><spring:message code="label.materialvi"/>
												</td>
												<td><form:select path="materialid" id="materialid" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${materialid}" /> 
													
												</form:select></td>
											</tr>
											<tr>
												
												
													
											
											</tr>
											<tr>
												<td><spring:message code="label.qtyvi"/></td>
												<td><form:input path="qty" id="qty" class="textbox"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.uomvi"/> 
												</td>
												<td><form:select path="uomid" id="uomid" class="select" 
													cssStyle="height:25px;" >
													<form:option value="" >--Select--</form:option>
													<form:options items="${uom}" /> 
													
												</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.price"/></td>
												<td><form:input path="price" id="price" onkeyup="addAmount()" class="textbox"/></td>
											</tr>
									         <tr>
												<td><spring:message code="label.tax"/></td>
												<td><form:input path="tax" id="tax" onkeyup="addAmount()"
													  class="textbox"/> 
														<input type="hidden"
													name="hiddenIdVIPopUp" id="hiddenIdVIPopUp" value="0" /></td>
											</tr>

										</table>
										
									</div> 


									
									<div id="users-contain-VI">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="VIAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.materialvi"/></th>
													<th><spring:message code="label.qtyvi"/></th>
													<th><spring:message code="label.uomvi"/></th>
													<th><spring:message code="label.price"/> </th>
													<th><spring:message code="label.tax"/> </th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
			
												</tr>
											</thead>
											<tbody>
												
											</tbody> 
										</table>
										<button id="VendorInvoicelineadd" type="button"><spring:message code="label.addcidetails"/></button>
									</div>
								</div>
						</div>
									 <table>
										<tr>
											<td colspan="2">
											<c:choose>
											<c:when test="${true}">
											<input type="submit" value="<spring:message code="label.save"/>"
												class="btn btn-primary" id="subid" />
												</c:when>
												<c:otherwise>
													<input type="submit" disabled="disabled" value="<spring:message code="label.save"/>"
												class="btn btn-danger" id="subid" />
												</c:otherwise>
												
												</c:choose>
												<!-- <input type="reset"
												class="btn btn-primary" /> -->
												<input type="reset" value="<spring:message code="label.reset"/>"  class="btn btn-primary" />
												 </td>
										</tr>
									</table> 
								
					</form:form>

				</div>
			</div>
			 <div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="customerinvoiceUpdate.mnt" method="post"  commandName="CUSTOMERINVOICE" id="editCustomerInvoiceForm">
					
						<%-- <c:forEach var="editvalues" items="${editvalues }">
							<c:set var="edit" value="${editvalues}"></c:set>
						</c:forEach> --%>
						<c:if test="${editvalues!=null}">

							
							<table class="tableGeneral">
                    
                    <tr>
                    <tr>
						<td  id="cisuccessdupedit" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.cino" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
                    </tr>
								
								<tr>
								<form:hidden path="editcustomerinvoiceid" />
								
								<td><spring:message code="label.cino" /><span
									class="required">*</span> </td>
									<td><form:input path="editcustomerinvoiceno" id="editcustomerinvoiceno"
										cssClass="textbox" maxlength="50" onkeyup="duplicatecheckinciEdit()" /></td>
								
								<td><spring:message code="label.des" /><span
									class="required">*</span> </td>
									<td><form:input path="editdescription" 
										class="textbox"  /></td></tr>
										
								<tr><td><spring:message code="label.vid" /><span
									class="required">*</span></td>
									<td> <form:input path="editcustomerinvoicedate" id="editcustomerinvoicedate"
										class="textbox"  /></td>
										
										<td><spring:message code="label.deliverynote" /><span class="required">*</span></td>
									<td><form:select path="editdeliverynoteid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${deliverynote}" />
								</form:select></td></tr>
										
						<tr><td><spring:message code="label.postDate" /><span
									class="required">*</span></td>
									<td> <form:input path="editpostingdate" id="editpostingdate"
										class="textbox"  /></td>
										<td><spring:message code="label.org" /><span
									class="required">*</span></td>
									<td><form:select path="editorgid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${org}" />
								</form:select></td></tr>
								
								
						<tr><td><spring:message code="label.amount" /><span
									class="required">*</span> </td>
									<td> <input type="hidden" id="hiddenamountEdit" value="0"/> <form:input path="editamount"  id="amountEdit" readonly="true"
										class="textbox"  /></td>
										<td><spring:message code="label.fy" /><span
									class="required">*</span></td>
									<td><form:input path="editfy" 
										class="textbox" maxlength="50"  /></td>
										</tr>
										
										<tr><td><spring:message code="label.curr" /><span
									class="required">*</span></td>
									<td><form:select path="editcurrencyid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${currency}" />
								</form:select></td>
								
										
								<td><spring:message code="label.ref" /><span
									class="required">*</span></td>
									<td> <form:input path="editreference" 
										class="textbox" maxlength="50" /></td>
										</tr>
							</table>
							
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message code="label.customerinvoiceline"/></a></li>

								</ul>
								
								
                        <div align="center">

								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->
									
									<!-- <div align="center"> -->
									
									<script>
										var btvieid = 400;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */
											
											
											var ematid = $("#editmaterialid"), eqtid = $("#editqty"),eumid=$("#edituomid"), eprice = $("#editprice"),etax = $("#edittax"), ehiddenviID = $("#hiddenIdvieditPopUp")
											
											
											allFields = $([]).add(ematid).add(eqtid).add(eumid).add(eprice).add(etax).add(ehiddenviID),
											 tips = $(".validateTips");

											

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength2(o, n) {
												
												if (o.val().length =="") {
													o
															.addClass("ui-state-error");
													updateTips("Required");
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

											$("#dialog-form-ViEdit")
													.dialog(
															{
																autoOpen : false,
																height : 350,
																width : 400,
																modal : true,
																buttons : {
																	Submit : function() {
																		
																		//alert("hhe");
																		var bValid2 = true;
																		allFields.removeClass("ui-state-error");

																		 bValid2 = bValid2
																			&& checkLength2(
																					ematid,
																					
																					"Material is Required");
																	
															 	       bValid2 = bValid2
																			&& checkLength2(
																					eumid,
																				
																					"UOM");
																	bValid2 = bValid2
																	     && checkRegexp(
																			eqtid,
																			/^([0-9])+$/i,
																			"Quantity is Required And Must be  Number");
																 	bValid2 = bValid2
																			&& checkLength2(
																					eprice,
																					"Price ");
																	bValid2 = bValid2
																	&& checkLength2(
																			etax,
																			"Price ");   
																	 	if (bValid2) {
																			//alert("hiddenid"+hiddenID.val());
																			
																			if (ehiddenviID
																					.val() == "0"
																					|| ehiddenviID
																							.val() == "") {

																				$("#VIEdit tbody")
																						.append(
																								"<tr id="+btvieid+">"
																										+ "<td ><input type='hidden' name='editmaterialid' id='editmaterialid"
																										+ btvieid
																										+ "' value="
																										+ ematid
																												.val()
																										+ " class='textbox'readonly/>  "
																										+"<input type='text' readonly class='textbox' name='materialNameedit' id='materialNameedit"+btvieid+"' value='"+$('#editmaterialid :selected').text()+"'"
																										+"</td>"
																										+ "<td align='center'><input type='text' name='editqty' id='editqty"
																										+ btvieid
																										+ "' value="
																										+ eqtid
																												.val()
																										+ "  class='textbox'readonly/></td>"
																									
																										+ "<td><input type='hidden' name='edituomid' id='edituomid"
																										+ btvieid
																										+ "' value="
																										+ eumid
																												.val()
																										+ " class='textbox'readonly/>"
																										+"<input type='text' readonly class='textbox' name='uomNameedit' id='uomNameedit"+btvieid+"' value='"+$('#edituomid :selected').text()+"'"
																										+"</td>"
																										+ "<td align='center'><input type='text' name='editprice' id='editprice"
																										+ btvieid
																										+ "' value="
																										+ eprice
																												.val()
																										+ "  class='textbox'readonly/></td>"
																										+ "<td><input name='edittax' id='edittax"
																										+ btvieid
																										+ "' value="
																										+ etax
																												.val()
																										+ " class='textbox'readonly/><input type='hidden' name='editcustomerinvoicelineid' value='0' id='editcustomerinvoicelineid'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
																										+

																										// "<td>" + password.val() + "</td>" +
																										"<td><a href='#'  onclick='editViEdit("
																										+ btvieid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeViEdit("
																										+ btvieid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btvieid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																			if (ehiddenviID
																					.val() != "0") {
																				$('#editmaterialid'+ ehiddenviID.val()).val(ematid.val());
																				$('#materialNameedit'+ ehiddenviID.val()).val($('#editmaterialid :selected').text());
																				$('#editqty'+ ehiddenviID.val()).val(eqtid.val());
																				$('#edituomid'+ ehiddenviID.val()).val(eumid.val());
																				$('#uomNameedit'+ ehiddenviID.val()).val($('#edituomid :selected').text());
																				$('#editprice'+ ehiddenviID.val()).val(eprice.val());
																				$('#edittax'+ ehiddenviID.val()).val(etax.val());
																				
																				
																				$('#hiddenIdvieditPopUp').val("0");
																				$(this).dialog("close");
																				addtotalAmountEdit();
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

										
											$("#AddVIEdit")
													.button()
													.click(
															function() {
																$("#dialog-form-ViEdit")
																		.dialog(
																				"open");
																
															});
										});
										function removeViEdit(id) {
									
											var totalAmount=$('#amountEdit').val();
											var price=0;
											var tax=0;
											price=$('#editprice'+id).val();
											tax=$('#edittax'+id).val();
						
											var	sum = (parseFloat(price)+parseFloat(tax));
											var ji=Number(sum);
											var exactAmount=(parseFloat(totalAmount)-parseFloat(ji));
											//alert(exactAmount);
											$('#amountEdit').val(exactAmount);
											$('#' + id).remove();
										}
										
										function editViEdit(id) {
											//alert("edit row " + id);
											

											$("#dialog-form-ViEdit").dialog(
													"open");
										
											
											$('#editmaterialid').val(
													$('#editmaterialid' + id).val());
											$('#editqty').val(
													$('#editqty' + id)
															.val());
											$('#edituomid').val(
													$('#edituomid' + id)
															.val());
											 $('#editprice').val(
													$('#editprice' + id).val()); 
											$('#edittax').val(
													$('#edittax' + id).val());
											
									
										$('#hiddenIdvieditPopUp').val(id);
										// document.getElementById("").value="edit";
									}
									</script> 


									 <div id="dialog-form-ViEdit" align="center" title="<spring:message code="label.addcidetails"/>">
										<p class="validateTips" align="center" ></p>
										<table class="tableGeneral" cellspacing=0>
											<form:hidden path="editcustomerinvoicelineid" value="0"/>
									<tr><td><spring:message code="label.materialvi"/>
												</td>
												<td><form:select path="editmaterialid" id="editmaterialid" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${materialid}" /> 
													
												</form:select></td>
											</tr>
											<tr>
												
												
											
											</tr>
											<tr>
												<td><spring:message code="label.qtyvi"/></td>
												<td><form:input path="editqty" id="editqty" class="textbox"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.uomvi"/> 
												</td>
												<td><form:select path="edituomid" id="edituomid" class="select" 
													cssStyle="height:25px;" >
													<form:option value="" >--Select--</form:option>
													<form:options items="${uom}" /> 
													
												</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.price"/></td>
												<td><form:input path="editprice" id="editprice" onkeyup="addAmountEdit()" class="textbox"/></td>
											</tr>
									         	<tr>
												<td><spring:message code="label.tax"/></td>
												<td><form:input path="edittax" id="edittax" onkeyup="addAmountEdit()"
													  class="textbox"/> 
														<input type="hidden"
													name="hiddenIdvieditPopUp" id="hiddenIdvieditPopUp" value="0" /></td>
											</tr>

										</table>
										
									</div> 


									
									<div id="users-contain-Process">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="VIEdit" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.materialvi"/></th>
													<th><spring:message code="label.qtyvi"/></th>
													<th><spring:message code="label.uomvi"/></th>
													<th><spring:message code="label.price"/> </th>
													<th><spring:message code="label.tax"/> </th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
			
												</tr>
			
												
											</thead>
											<tbody>
												<c:forEach items="${cilinelist}"
												var="cilinelist">
                                                
                                              
                                                
                                               <td><spring:bind path="CUSTOMERINVOICE.editcustomerinvoicelineid">
															<input type="hidden" name="editcustomerinvoicelineid" id="editcustomerinvoicelineid${cilinelist.editcustomerinvoicelineid}"
																value="${cilinelist.editcustomerinvoicelineid}"  />
														</spring:bind></td>
                                        			<tr id="${cilinelist.editcustomerinvoicelineid}">
													<td><spring:bind path="CUSTOMERINVOICE.editmaterialid">
															<input type="hidden" name="editmaterialid"  class="textbox" id="editmaterialid${cilinelist.editcustomerinvoicelineid}"
																value="${cilinelist.editmaterialid}"  />
														</spring:bind>
														<spring:bind path="CUSTOMERINVOICE.materialidName">
																	<input type="text" name="materialidName" class="textbox"
																		id="materialNameedit${cilinelist.editcustomerinvoicelineid}"
																		value="${cilinelist.materialidName}" readonly/>
																</spring:bind></td>

													<td><spring:bind path="CUSTOMERINVOICE.editqty">
															<input type="text" name="editqty" id="editqty${cilinelist.editcustomerinvoicelineid}"
																class="textarea"
																value="${cilinelist.editqty}" readonly />
														</spring:bind></td>
													<td><spring:bind path="CUSTOMERINVOICE.edituomid">
															<input type="hidden" name="edituomid" id="edituomid${cilinelist.editcustomerinvoicelineid}"
																class="textbox"
																value="${cilinelist.edituomid}" readonly/>
														</spring:bind>
														<spring:bind path="CUSTOMERINVOICE.uomidName">
															<input type="text" name="uomidName" id="uomNameedit${cilinelist.editcustomerinvoicelineid}"
																class="textbox"
																value="${cilinelist.uomidName}" readonly/>
														</spring:bind></td>
														<td><spring:bind path="CUSTOMERINVOICE.editprice">
															<input type="text" name="editprice" id="editprice${cilinelist.editcustomerinvoicelineid}"
																class="textarea"
																value="${cilinelist.editprice}" readonly />
														</spring:bind></td>
													<td><spring:bind path="CUSTOMERINVOICE.edittax"> 
															<input type="text" name="edittax" id="edittax${cilinelist.editcustomerinvoicelineid}"
																class="textbox"
																value="${cilinelist.edittax}" readonly/>
														</spring:bind>
														<input type="hidden" name="Checkdelete${cilinelist.editcustomerinvoicelineid}" id="${cilinelist.editcustomerinvoicelineid}Checkdelete" value="0"/></td>
													
												 	
													<td><a href='#' id="${cilinelist.editcustomerinvoicelineid}" onclick="editViEdit(this.id)"><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>
													<td><a href='#' id="${cilinelist.editcustomerinvoicelineid}" onclick="getID11(this)"><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>
												</tr>

											
															
															<script type="text/javascript">
																function getID11(
																		link) {
																	
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	var totalAmount=$('#amountEdit').val();
																	var price=0;
																	var tax=0;
																	price=$('#editprice'+link.id).val();
																	tax=$('#edittax'+link.id).val();
												
																	var	sum = (parseFloat(price)+parseFloat(tax));
																	var ji=Number(sum);
																	var exactAmount=(parseFloat(totalAmount)-parseFloat(ji));
																	//alert(exactAmount);
																	$('#amountEdit').val(exactAmount);
																	document
																			.getElementById(link.id
																					+ "Checkdelete").value = "1";
																	document
																			.getElementById(link.id).style.display = "none";
																}
																function editProcessDetailsInEdit(
																		link) {
																	
																	$(
																			"#dialog-form-ViEdit")
																			.dialog(
																					"open");
																	$(
																			'#editmaterialid'+link.id)
																			.val(
																					$(
																							'#editmaterialid').val());
																	$('#editqty')
																			.val(
																					$('#editqty'
																									+ link.id)
																							.val());
																	$('#edituomid')
																			.val(
																					$('#edituomid'
																									+ link.id)
																							.val());
																	$('#editprice')
																			.val(
																					$('#editprice'
																									+ link.id)
																							.val());
																	$('#edittax')
																	.val(
																			$('#edittax'
																							+ link.id)
																					.val());
																	

																	$('#hiddenIdvieditPopUp')
																			.val(
																					link.id);

																}
															</script>
													
											</c:forEach>
											</tbody>
										</table>
										
										<button id="AddVIEdit" type="button"><spring:message code="label.addcidetails"/></button>
									</div>
									
									</div> 
								
							</div>
							
							<table>
								<tr>
									<td colspan="2" align="center">
									<c:choose>
									<c:when test="${true }">
									<input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-primary" id="updatevid" /></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/>" class="btn btn-danger" id="updatevid" />
										</c:otherwise>
										</c:choose>
										 
                                    </td>
										 
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