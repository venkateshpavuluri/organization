
 <!-- @author Srinivas -->
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

	 <script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						
						
						$('#subid')
								.click(
										function(event) {
											
											$('#addViform')
													.validate(
															{
																rules : {
																	vendorinvoiceno : {
																		required : true },
																		vendorinvoicedate:{
																			required : true	
																		},
																		postingdate:{
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
																		vendorid:{
																			required : true
																			
																		}, 
																		vendordup:{},
																		
																},
																 messages : {
																	 vendorinvoiceno : "<font style='color: red;'><b>Vendor Invoice No is Required</b></font>",
																	 vendorinvoicedate : "<font style='color: red;'><b>Vendor Invoice Date is Required</b></font>",
																	 postingdate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	 amount : "<font style='color: red;'><b>Amount is Required</b></font>",
																	 currencyid : "<font style='color: red;'><b>Currency  is Required</b></font>",
																	 reference : "<font style='color: red;'><b>Reference is Required</b></font>",
																	 description : "<font style='color: red;'><b>Description is Required</b></font>",
																	 orgid : "<font style='color: red;'><b>Organization is Required</b></font>", 
																	 fy : "<font style='color: red;'><b>Financial Year is Required</b></font>",
																	 vendorid : "<font style='color: red;'><b>Vendor is Required</b></font>" 
																	 
																},
																
																	});
															});
									//	});
						//UpdateForm Validations
						$('#updatevid')
								.click(
										function(event) {
											
											//alert("hehe");
											$('#editVendorInvoiceForm')
													.validate(
															{
																rules : {
																	editvendorinvoiceno : {
																		required : true },
																		editvendorinvoicedate:{
																			required : true	
																		},
																		editpostingdate:{
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
																		editvendorid:{
																			required : true
																			
																		},  
																		
																		
																},
																 messages : {
																	 editvendorinvoiceno : "<font style='color: red;'><b>Vendor Invoice No is Required</b></font>",
																	 editvendorinvoicedate : "<font style='color: red;'><b>Vendor Invoice Date is Required</b></font>",
																	 editpostingdate : "<font style='color: red;'><b>Posting Date is Required</b></font>",
																	 editamount : "<font style='color: red;'><b>Amount is Required</b></font>",
																	 editcurrencyid : "<font style='color: red;'><b>Currency  is Required</b></font>",
																	 editreference : "<font style='color: red;'><b>Reference is Required</b></font>",
																	 editdescription : "<font style='color: red;'><b>Description is Required</b></font>",
																	 editorgid : "<font style='color: red;'><b>Organization is Required</b></font>", 
																	 editfy : "<font style='color: red;'><b>Financial Year is Required</b></font>",
																	 editvendorid : "<font style='color: red;'><b>Vendor is Required</b></font>" 
																	 
																},
																
																	});
															});

					});
</script> 
<script type="text/javascript">
function dateFun(datePattern) {
	$('#vendorinvoicedate,#postingdate,#editvendorinvoicedate,#editpostingdate').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>
 

<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
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

 <script type="text/javascript">
	$(document).ready(function() {
		$('#add').click(function(e) {
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
	function duplicatevicheckAjax() {

		//get the form values

		var vinno = $('#vendorinvoiceno').val();

		$
				.ajax({

					type : "POST",

					url : "VIDuplicateCheck.mnt",

					data : "vinno=" + vinno,

					success : function(response) {

						var checkResponse = "Warning ! Vendor Invoice No is already exists. Please try some other name";
						
						if (checkResponse == response) {

							document.getElementById("vendordup").style.display = "block";
							//$('#vendordup').html(response);
							$('#subid').hide();
							
						} else {
							document.getElementById("vendordup").style.display = "none";
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
	function duplicatevicheckinEdit() {

		//get the form values

		var vinameedit = $('#editvendorinvoiceno').val();
		var vieditid = $('#editvendorinvoiceid').val();

		$
				.ajax({

					type : "POST",

					url : "VIDuplicateEditCheck.mnt",

					data : "vinameedit=" + vinameedit + "&vieditid="
							+ vieditid,

					success : function(response) {

						var checkResponse = "Warning ! Vendor Invoice No is already exists. Please try some other name";
						//alert(response);
						if (checkResponse == response) {
							document.getElementById("visuccessdupedit").style.display = "block";
							//$('#visuccessdupedit').html(response);
							$('#updatevid').hide();
						} else {
							document.getElementById("visuccessdupedit").style.display = "none";
							$('#updatevid').show();
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
		<div class="PageTitle">Vendor Invoice</div>
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
						<form:form action="searchVendorinvoice.mnt" method="GET"
						commandName="VENDORINVOICE">
							<tr>
								<td colspan="2"><c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
                                 <strong><spring:message code="label.success"/> </strong>
                                 <spring:message code="label.vendorInvoice"/> <spring:message code="label.saveSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach var="success"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
                                 <strong><spring:message code="label.error"/> </strong>
                                 <spring:message code="label.vendorInvoice"/> <spring:message code="label.saveFail"/>
										</div>
									</c:forEach>
									
									
									<c:forEach items="${VIUpdateSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
                                 <spring:message code="label.vendorInvoice"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach>
									
                          <c:forEach items="${VIUpdateFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
                                 <spring:message code="label.vendorInvoice"/> <spring:message code="label.updateFail"/>
										</div>
									</c:forEach>
									
									<c:forEach items="${VIDeleteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
                                 <spring:message code="label.vendorInvoice"/> <spring:message code="label.deleteSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach items="${VIDeleteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
                                 <spring:message code="label.vendorInvoice"/> <spring:message code="label.deleteFail"/>
										</div>
									</c:forEach>
								
							</td>
								
							</tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" />
								<form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> 
									<spring:bind path="VENDORINVOICE.operations">
								<select class="select" name="operations">
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
							<form:form action="viAdvanceSearch.mnt" method="get"
							commandName="VENDORINVOICE" name="advanceSearchFinal">
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
					
	        <form:form action="viAdvanceSearchOperations.mnt" commandName="VENDORINVOICE">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${viSearchAdvance}">
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
					
					<c:if test="${vibeans!=null}">
					<div >
						<display:table id="videtailid" name="vibeans"
							requestURI="searchVendorinvoice.mnt" pagesize="5" class="table">
							<display:column property="vendorinvoiceid" title="viid"
								media="none" sortable="true"></display:column>
							<display:column property="vendorinvoiceno" titleKey="label.vino"  media="html"
								sortable="true"></display:column>
								<display:column property="vendorinvoicedate" titleKey="label.vid" media="html"
								sortable="true"></display:column>
								<display:column property="postingdate" titleKey="label.postDate" media="html"
								sortable="true"></display:column>
								<display:column property="amount" titleKey="label.amount" media="html"
								sortable="true"></display:column>
								<display:column property="currencyid" titleKey="label.curr" media="html"
								sortable="true"></display:column>
								<display:column property="reference" titleKey="label.ref" media="html"
								sortable="true"></display:column>
								<display:column property="description" titleKey="label.des" media="html"
								sortable="true"></display:column>
								<display:column property="purchaseorderid" titleKey="label.po" media="html"
								sortable="true"></display:column>
								<display:column property="orgid" titleKey="label.org" media="html"
								sortable="true"></display:column>
								<display:column property="fy" titleKey="label.fy" media="html"
								sortable="true"></display:column>
								<display:column property="vendorid" titleKey="label.vendor" media="html"
								sortable="true"></display:column>
								
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true}">
								<a
									href="vendorinvoiceEdit.mnt?viedit=<c:out value="${videtailid.vendorinvoiceid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px" onclick="toggleTable();" 
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px" class="btn btn-danger" height="20px" /> </a>
									</c:otherwise>
									</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${true}">
								<a
									href="viDelete.mnt?videlid=<c:out value="${videtailid.vendorinvoiceid}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a></c:when>
									<c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px"/> </a>
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

					<form:form action="savevendorinvoice.mnt" method="POST"
							commandName="VENDORINVOICE" id="addViform">
<!-- <div id="vendordup" class="alert-warning" style="display: none; width: 350px;"></div> -->

							<table class="tableGeneral">
                     <tr><td>
								<table class="tableGeneral">
								<tr>
							<td colspan="4" id="vendordup" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.vino" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
							
							<tr>
								<td><spring:message code="label.vino" /><span
									class="required">*</span> </td>
									<td><form:input path="vendorinvoiceno" 
										class="textbox" maxlength="50" onkeyup="duplicatevicheckAjax()"  /></td>
								
								<td><spring:message code="label.des" /><span
									class="required">*</span> </td>
									<td><form:input path="description" 
										class="textbox"  /></td></tr>
										
								<tr><td><spring:message code="label.vid" /><span
									class="required">*</span></td>
									<td> <form:input path="vendorinvoicedate" id="vendorinvoicedate"
										class="textbox"  /></td>
										
										<td><spring:message code="label.po" /></td>
									<td><form:select path="purchaseorderid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${po}" />
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
									<td>
									<input type="hidden" id="hiddenamount" value="0"/>
									<!-- <input type="text" name="amount"  id="amount" value="0"/> -->
								 <form:input path="amount" id="amount" readonly="true"
										class="textbox"   /></td>
										<td><spring:message code="label.fy" /><span
									class="required">*</span></td>
									<td><form:input path="fy" 
										class="textbox" maxlength="50"  /></td>
										</tr>
										
										<tr><td><spring:message code="label.curr" /><span
									class="required">*</span></td>
									<td><form:select path="currencyid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${currency}" />
								</form:select></td>
								<td><spring:message code="label.vendor" /><span
									class="required">*</span></td>
									<td><form:select path="vendorid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${vendor}" />
								</form:select></td></tr>
										
								<tr><td><spring:message code="label.ref" /><span
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

								<li><a href="#tab1"><spring:message code="label.vendorinvoiceline" /></a></li>

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

																				$("#VIAdd tbody").append("<tr id="+btviid+">"
																										+ "<td ><input type='hidden' name='materialid' id='materialid"
																										+ btviid
																										+ "' value="
																										+ matid.val()
																										+ " class='textbox'readonly/>"
																										+"<input type='text' readonly class='textbox' name='materialName' id='materialName"+btviid+"' value='"+$('#materialid :selected').text()+"'"
																										 +" </td>"
																										+ "<td align='center'><input type='text' name='qty' id='qty"
																										+ btviid
																										+ "' value="
																										+ qtid.val()
																										+ "  class='textbox'readonly/></td>"
																									
																										+ "<td><input type='hidden' name='uomid' id='uomid"
																										+ btviid
																										+ "' value="
																										+ umid.val()
																										+ " class='textbox'readonly/>"
																										+"<input type='text' readonly class='textbox' name='uomName' id='uomName"+btviid+"' value='"+$('#uomid :selected').text()+"'"
																										+"</td>"
																										+ "<td><input name='price' id='price"
																										+ btviid
																										+ "' value="
																										+ price.val()
																										+ " class='textbox'readonly/></td>"
																										+ "<td><input name='tax' id='tax"
																										+ btviid
																										+ "' value="
																										+ tax.val()
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
																				$(this).dialog("close");
																				
																			}
																	addtotalAmount();
																			
																			
																			
																			
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
											//alert("edit row== " +$('#price' + id).val());
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
											//alert("removing row " +$('#price'+hiddenviID.val()).val);
											
											$('#'+id).remove();
											
											
										}
										function editvi(id) {
										
											$("#dialog-form-VI").dialog("open");
										    $('#materialid').val($('#materialid' + id).val());
											$('#qty').val($('#qty' + id).val());
											$('#uomid').val($('#uomid' + id).val());
											$('#price').val($('#price' + id).val());
											$('#tax').val($('#tax' + id).val());
											$('#hiddenIdVIPopUp').val(id);
										
									}
									</script> 


									 <div id="dialog-form-VI" align="center" title="<spring:message code="label.addvidetails"/>">
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
										<button id="VendorInvoicelineadd" type="button"><spring:message code="label.addvidetails"/></button>
									</div>
									
								<%-- //<form:hidden path="rfqhide"  --%>

								<!-- </div> -->
									
									
									
									
									
									
									
			
									</div>
						</div>
									 <table>
										<tr>
											<td colspan="2">
											<c:choose>
											<c:when test="${true}">
											<input type="submit" value="<spring:message code="label.save"/>"
												class="btn btn-primary" id="subid" /></c:when>
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
								<!-- </div> -->
							
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="viUpdate.mnt" method="post" id="editVendorInvoiceForm" commandName="VENDORINVOICE" >
						<!-- <div id="visuccessdupedit" class="alert-warning" style="display: none; width: 350px;"></div> -->
						<%-- <c:forEach var="editvalues" items="${editvalues }">
							<c:set var="edit" value="${editvalues}"></c:set>
						</c:forEach> --%>
						
						<c:if test="${editvalues!=null}">
							<table class="tableGeneral">
								<tr>
							<td colspan="2" id="vendordup" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.quotationno" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
								<tr>
								<form:hidden path="editvendorinvoiceid" />
								<td><spring:message code="label.vino" /><span
									class="required">*</span> </td>
									<td><form:input path="editvendorinvoiceno" 
										cssClass="textbox" maxlength="50" onkeyup="duplicatevicheckinEdit()"  /></td>
								
								<td><spring:message code="label.des" /><span
									class="required">*</span> </td>
									<td><form:input path="editdescription" 
										class="textbox"  /></td></tr>
										
								<tr><td><spring:message code="label.vid" /><span
									class="required">*</span></td>
									<td> <form:input path="editvendorinvoicedate" id="editvendorinvoicedate"
										class="textbox"  /></td>
										
										<td><spring:message code="label.po" /></td>
									<td><form:select path="editpurchaseorderid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${po}" />
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
									
									<td><input type="hidden" id="hiddenamountEdit" value="0"/> <form:input path="editamount" id="amountEdit" readonly="true"
										class="textbox"  /></td>
										<td><spring:message code="label.fy" /><span
									class="required">*</span></td>
									<td><form:input path="editfy" 
										class="textbox" maxlength="50" /></td>
										</tr>
										
										<tr><td><spring:message code="label.curr" /><span
									class="required">*</span></td>
									<td><form:select path="editcurrencyid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${currency}" />
								</form:select></td>
								<td><spring:message code="label.vendor" /><span
									class="required">*</span></td>
									<td><form:select path="editvendorid" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${vendor}" />
								</form:select></td></tr>
										
								<tr><td><spring:message code="label.ref" /><span
									class="required">*</span></td>
									<td> <form:input path="editreference" 
										class="textbox" maxlength="50" /></td>
										</tr>
							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message code="label.vendorinvoiceline"/></a></li>

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
																										+ " class='textbox'readonly/><input type='hidden' name='editvendorinvoicelineid' value='0' id='editvendorinvoicelineid'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td>"
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
																				addtotalAmountEdit();
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
											//alert("removing row " + id);
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


									 <div id="dialog-form-ViEdit" align="center" title="<spring:message code="label.addvidetails"/>">
										<p class="validateTips" align="center" ></p>
										<table class="tableGeneral" cellspacing=0>
											<form:hidden path="editvendorinvoicelineid" value="0"/>
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
												<c:forEach items="${vilinelist}"
												var="vilinelist">
                                                
                                              
                                                
                                               <td><spring:bind path="VENDORINVOICE.editvendorinvoicelineid">
															<input type="hidden" name="editvendorinvoicelineid" id="editvendorinvoicelineid${vilinelist.editvendorinvoicelineid}"
																value="${vilinelist.editvendorinvoicelineid}"  />
														</spring:bind></td>
                                        			<tr id="${vilinelist.editvendorinvoicelineid}">
													<td><spring:bind path="VENDORINVOICE.editmaterialid">
															<input type="hidden" name="editmaterialid"  class="textbox" id="editmaterialid${vilinelist.editvendorinvoicelineid}"
																value="${vilinelist.editmaterialid}"  />
														</spring:bind>
														<spring:bind path="VENDORINVOICE.materialidName">
																	<input type="text" name="materialidName" class="textbox"
																		id="materialNameedit${vilinelist.editvendorinvoicelineid}"
																		value="${vilinelist.materialidName}" readonly/>
																</spring:bind></td>

													<td><spring:bind path="VENDORINVOICE.editqty">
															<input type="text" name="editqty" id="editqty${vilinelist.editvendorinvoicelineid}"
																class="textarea"
																value="${vilinelist.editqty}" readonly />
														</spring:bind></td>
													<td><spring:bind path="VENDORINVOICE.edituomid">
															<input type="hidden" name="edituomid" id="edituomid${vilinelist.editvendorinvoicelineid}"
																class="textbox"
																value="${vilinelist.edituomid}" readonly/>
														</spring:bind>
														<spring:bind path="VENDORINVOICE.uomidName">
															<input type="text" name="uomidName" id="uomNameedit${vilinelist.editvendorinvoicelineid}"
																class="textbox"
																value="${vilinelist.uomidName}" readonly/>
														</spring:bind></td>
														<td><spring:bind path="VENDORINVOICE.editprice">
															<input type="text" name="editprice" id="editprice${vilinelist.editvendorinvoicelineid}"
																class="textarea"
																value="${vilinelist.editprice}" readonly />
														</spring:bind></td>
													<td><spring:bind path="VENDORINVOICE.edittax"> 
															<input type="text" name="edittax" id="edittax${vilinelist.editvendorinvoicelineid}"
																class="textbox"
																value="${vilinelist.edittax}" readonly/>
														</spring:bind>
														<input type="hidden" name="Checkdelete${vilinelist.editvendorinvoicelineid}" id="${vilinelist.editvendorinvoicelineid}Checkdelete" value="0"/></td>
													
													
													<td><a href='#' id="${vilinelist.editvendorinvoicelineid}" onclick="editViEdit(this.id)"><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>
													<td><a href='#' id="${vilinelist.editvendorinvoicelineid}" onclick="getID11(this)"><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>
												</tr>

												
															<script type="text/javascript">
																function getID11(
																		link) {
																	//alert(link.id);
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
										<button id="AddVIEdit" type="button" ><spring:message code="label.addvidetails"/></button>
									</div>
									
									</div> 
								
							</div>
							
							<table>
								<tr>
									<td colspan="2" align="center">
									<c:choose>
									<c:when test="${true }">
									<input type="submit" value="<spring:message code="label.update"/>" class="btn btn-primary" id="updatevid" />
									</c:when>
									<c:otherwise>
									<input type="submit" value="<spring:message code="label.update"/>" class="btn btn-danger" disabled="disabled" id="updatevid" />
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




 