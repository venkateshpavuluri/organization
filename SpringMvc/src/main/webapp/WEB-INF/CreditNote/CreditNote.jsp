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
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
function dateFun(datePattern) {
	$('#dueDate,#creditNoteDTEdit').datepicker({
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
	else
		return false;
}



function doAjaxPost() {
	  
	var creditNoteNo = $('#creditNoteNo').val();
	//alert("sdf"+purchaseOrderNo);
		$.ajax({
			type : "POST",
			url : "creditNoteNoCheck.mnt",
			data : "creditNoteNo=" + creditNoteNo,
			success : function(data) {
				var checkResponse="Warning ! Credit Note no aleardy exists. Please try some other no";
				if(checkResponse==data)
				{
				document.getElementById("creditNoteDuplicateMess").style.display="block";
				//$('#creditNoteDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("creditNoteDuplicateMess").style.display="none";
				$('#save').show();
				}
			},
			error : function(e) {
				//alert('Error: ' + e);
			}

		});
	}
function doAjaxPostEdit() { 
	  
	var creditNoteNoEdit = $('#creditNoteNoEdit').val();
	var creditNoteIdEdit = $('#creditNoteIdEdit').val();
	//alert(purchaseOrderNoEdit +" "+purchaseOrderIdEdit);
		$.ajax({
			type : "POST",
			url : "creditNoteNoCheckEdit.mnt",
			data : "creditNoteNoEdit=" + creditNoteNoEdit+ "&creditNoteIdEdit=" + creditNoteIdEdit,
			success : function(data) {
				var checkResponse="Warning ! Credit Note no aleardy exists. Please try some other no";
				if(checkResponse==data)
				{
				document.getElementById("creditNoteDuplicateMessEdit").style.display="block";
				//$('#creditNoteDuplicateMessEdit').html(data);
				$('#update').hide();
				}
				else
				{
				document.getElementById("creditNoteDuplicateMessEdit").style.display="none";
				$('#update').show();
				}
			},
			error : function(e) {
				//alert('Error: ' + e);
			}

		});
	}



$(document).ready(function() {
	$('#save').click(function(event) {   
		
	 	$('#creditAdd').validate({
			rules : {
				creditNoteNo:{required:true,alphaNumeric:true,},
				creditNoteDT : {required : true},
				customerInvoiceId : {required : true},
				vendorInvoiceId : {required : true},
					
				
				
			},
			messages : {
			 creditNoteNo:{
					required:"<font style='color: red;'><b>Credit Note  No is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
				creditNoteDT : "<font style='color: red;'><b>Credit Note Date is Required</b></font>",
				customerInvoiceId : "<font style='color: red;'><b>Customer Invoice is Required</b></font>",
				vendorInvoiceId : "<font style='color: red;'><b>Vendor Invoice is Required</b></font>",
				
					
				
			},
			

		}); 
		
	});

	
	
	$('#update').click(function(event) {
		
		//alert("ss");
	 	$('#creditEdit').validate({
			rules : {
				
				creditNoteNo:{required:true,alphaNumeric:true,},
				creditNoteDT : {required : true},
				customerInvoiceId : {required : true},
				vendorInvoiceId : {required : true},
				
				
			},
			messages : {
				creditNoteNo:{
					required:"<font style='color: red;'><b>Credit Note  No is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
				creditNoteDT : "<font style='color: red;'><b>Credit Note Date is Required</b></font>",
				customerInvoiceId : "<font style='color: red;'><b>Customer Invoice is Required</b></font>",
				vendorInvoiceId : "<font style='color: red;'><b>Vendor Invoice is Required</b></font>",
				
					
				
			},
			

		}); 
		
	});
	
	
	
}); 

</script>

<script>
	$(document).ready(function() {
		$('#add,#search').click(function(e) {
			// alert("kiran add");
			$('#edit').hide();
			$('#tabs-1').hide();  
			$('#creditNoteNo').val('');
			$('#dueDate').val('');
			$('#customerInvoiceId').val(0);
			$('#vendorInvoiceId').val(0);
			$('#successmessage').hide();
			$('#savemessage').hide();

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
	width: 85%;
	align: left;
}
</style>
<script type="text/javascript"> 
 $(function() {
	 if($('#advanceSearchHidden').val()=="1")
		{
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
			<spring:message code="label.creditNote" />
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="creditNoteValues" items="${creditNoteEditList}">
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

						<form:form action="creditNoteSearch.mnt" method="GET"
							commandName="creditNoteCommand">


							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.creditNote" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.creditNote" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${creditNoteUpdate}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.creditNote" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${creditNoteUpdateFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.creditNote" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${creditNoteDelete}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.creditNote" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${creditNoteDeleteFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.creditNote" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>
							<%-- 
							<tr>
								<td><spring:message code="label.custName" /></td>
								<td><form:select path="customerId" Class="select">
										<form:option value="0">--All--</form:option>
										<form:options items="${customerSelect}" />
									</form:select></td>

								<td><input type="submit" value="<spring:message code="label.search"/>"
									class="btn btn-primary"></td>
							</tr> --%>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /> <form:select
										path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="creditNoteCommand.operations">
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


								<td><c:choose>
										<c:when test="${true }">
											<input type="submit" class="btn btn-primary" value="Search" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												class="btn btn-danger" value="Search" />
										</c:otherwise>
									</c:choose></td>
							</tr>


						</form:form>

						<form:form action="creditNoteAdvanceSearch.mnt" method="GET"
							commandName="creditNoteCommand" name="advanceSearchFinal">
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
					<form:form action="creditNoteAdvanceSearchOperations.mnt"
						commandName="creditNoteCommand" method="GET">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${creditSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><spring:bind path="creditNoteCommand.operations1">
												<select class="select" name="operations1">
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
											</spring:bind></td>
										<td><form:input path="advanceSearchText"
												id="advanceSearch" class="textbox" /></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3"><c:choose>
											<c:when test="${seach}">

												<input type="submit" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-primary" />
											</c:when>
											<c:otherwise>
												<input type="submit" id="advanceSearchButtonId"
													value="Advance Search" disabled="disabled"
													style="display: none" class="btn btn-danger" />
											</c:otherwise>

										</c:choose></td>
								</tr>

							</table>

						</div>
					</form:form>

					<c:if test="${creditNoteList!=null }">

						<display:table name="creditNoteList" id="CreditList" class="table"
							requestURI="creditNoteSearch.mnt" pagesize="5">


							<display:column property="creditNoteNo" sortable="true"
								titleKey="label.creditNoteNo" media="html" />

							<display:column property="creditNoteDT" sortable="true"
								titleKey="label.creditNoteDT" media="html" />


							<display:column property="customerInvoiceId" sortable="true"
								titleKey="label.customerInvoiceId" media="html" />
							<display:column property="vendorInvoiceId" sortable="true"
								titleKey="label.vendorInvoiceId" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${true }">
										<a
											href="creditNoteEdit.mnt?creditNoteId=<c:out value="${CreditList.creditNoteId}"/> "><img
											src="images/Edit.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px" height="20px"
											class="btn btn-danger" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${true }">
										<a
											href="creditNoteDelete.mnt?creditNoteId=<c:out value="${CreditList.creditNoteId}"/> "
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

					<c:forEach var="creditNoteListAdvancedValues"
						items="${creditNoteListAdvancedValues}">
						<c:set var="creditAdvanced"
							value="${creditNoteListAdvancedValues}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${creditAdvanced!=null }">
							<display:table name="creditNoteListAdvancedValues"
								id="purcListAdv" class="table"
								requestURI="creditNoteAdvanceSearchOperations.mnt" pagesize="5">

								<display:column property="creditNoteNo" sortable="true"
									titleKey="label.creditNoteNo" media="html" />

								<display:column property="creditNoteDT" sortable="true"
									titleKey="label.creditNoteDT" media="html" />


								<display:column property="customerInvoiceId" sortable="true"
									titleKey="label.customerInvoiceId" media="html" />
								<display:column property="vendorInvoiceId" sortable="true"
									titleKey="label.vendorInvoiceId" media="html" />



								<display:column titleKey="label.edit">
									<c:choose>
										<c:when test="${edit}">
											<a
												href="creditNoteEdit.mnt?creditNoteId=<c:out value="${purcListAdv.creditNoteId}"/> "><img
												src="images/Edit.jpg" width="20px" height="20px" /></a>
										</c:when>
										<c:otherwise>
											<a><img src="images/Edit.jpg" class="btn btn-danger"
												width="20px" height="20px" /> </a>
										</c:otherwise>
									</c:choose>
								</display:column>
								<display:column titleKey="label.delete">
									<c:choose>
										<c:when test="${delete}">
											<a
												href="creditNoteDelete.mnt?creditNoteId=<c:out value="${purcListAdv.creditNoteId}"/> "
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
						</c:when>


					</c:choose>



				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="creditNoteAdd.mnt" method="POST"
						commandName="creditNoteCommand" id="creditAdd">
						<table>


							<tr>
								<form:hidden path="creditNoteDuplicate" />
								<!-- <td colspan="4" height="35px">	
										<div class="alert-warning" id="creditNoteDuplicateMess" style="display: none;">j</div>
										</td> -->

								<td colspan="4" id="creditNoteDuplicateMess"
									style="display: none;">
									<div class="alert-warning">
										<strong> <spring:message code="label.warning" /></strong>
										<spring:message code="label.creditNoteNo" />
										<spring:message code="label.duplicateCheck" />
									</div>
								</td>
							</tr>



							<tr>
								<td>Credit Note No<span class="required">*</span></td>
								<td><form:input path="creditNoteNo" id="creditNoteNo"
										class="textbox" onkeyup="doAjaxPost()" maxlength="50" /></td>
							</tr>
							<tr>
								<td>Credit Note Date<span class="required">*</span></td>
								<td><form:input path="creditNoteDT" id="dueDate"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Customer Invoice<span class="required">*</span></td>
								<td><form:select path="customerInvoiceId"
										id="customerInvoiceId" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${customerInvoiceId}" />
									</form:select></td>
							</tr>
							<tr>
								<td>Vendor Invoice<span class="required">*</span></td>
								<td><form:select path="vendorInvoiceId"
										id="vendorInvoiceId" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${vendorInvoiceId }" />
									</form:select></td>
							</tr>

						</table>


						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11">Credit Note Details</a></li>

							</ul>
							<div id="tabs-11" align="center">

								<div align="left">

									<script>
										var btrid = 200;
										$(function() {       

											var  materialId = $("#materialId"),qty = $("#qty"),perUnit = $("#perUnit"),
											netPrice = $("#netPrice"),uomId = $("#uomId"),demitAmont = $("#demitAmont"),
											hiddenID = $("#hiddenIdCreditNotePopUp"),
											
											allFields = $([])
											.add(materialId)
											.add(qty)
											.add(perUnit)
											.add(netPrice)
											.add(uomId)
											.add(demitAmont)
											.add(hiddenID),
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
												if (o.val() =='0') {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
													return false;
												} else {
													return true;
												}
											}
											function checkLength2(o, n) {
												//alert("sss"+o.val());
												if (o.val()=="") {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
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
											function demitAmount(a,b,c)
											{
											//	alert("ddd");
												 
												/* if(!isNaN($('#netPrice').val()))
													{ */
													if(parseFloat(a.val())<parseFloat(b.val()))
														{
														b.addClass("ui-state-error");
														updateTips(c +" should be less than Net Price");
														return false;
														}
														else 
														{
														return true;
														}
													
													/* } */
											}
											

											$("#dialog-form-CreditNote")
													.dialog(
															{
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");
																		
																	

																		bValid = bValid && checkLength1(materialId ,"Material Name");
																		bValid = bValid && checkRegexp(qty,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Quantity may consist of 0-9.");
																		bValid = bValid && checkRegexp(perUnit,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Unit Price may consist of 0-9.");
																		bValid = bValid && checkRegexp(netPrice,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Net Price may consist of 0-9.");
																		bValid = bValid && checkLength1(uomId,"Uom");
																		bValid = bValid && checkLength1(demitAmont,"Demit Amount");
																	    bValid = bValid && demitAmount(netPrice,demitAmont,"Demit Amount");
																		//alert(bValid+"bValid");

																		if (bValid) {
																			//alert("hiddenid="+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
																				/* materialId ,qty,perUnit,netPrice,uomId demitAmont */
																		     
																				$("#CreditNotAdd tbody")   
																						.append(
																								"<tr id="+btrid+">"      
																										+ "<td><spring:bind path='creditNoteCommand.materialId'><input type='hidden' name='materialId' id='materialId"
																										+ btrid
																										+ "' value="
																										+ materialId
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='creditNoteCommand.materialName'><input type='text' name='materialName' id='materialName"
																										+ btrid
																										+ "' value='"
																										+ $('#materialId :selected').text()
																										+ "' class='textbox' readonly/></spring:bind> </td>"
																										
																										+ "<td><spring:bind path='creditNoteCommand.uomId'><input type='hidden' name='uomId' id='uomId"
																										+ btrid
																										+ "' value="
																										+ uomId
																												.val()
																										+ " class='textbox'/></spring:bind><spring:bind path='creditNoteCommand.uomName'><input name='uomName' id='uomName"
																										+ btrid
																										+ "' value='" 
																										+$('#uomId :selected').text()
																										+ "' class='textbox'/></spring:bind></td>"
																									
																										+ "<td><spring:bind path='creditNoteCommand.qty'><input name='qty' id='qty"
																										+ btrid
																										+ "' value="
																										+ qty
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='creditNoteCommand.perUnit'><input name='perUnit' id='perUnit"
																										+ btrid
																										+ "' value="
																										+ perUnit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='creditNoteCommand.netPrice'><input name='netPrice' id='netPrice"
																										+ btrid
																										+ "' value="
																										+ netPrice
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										
																										+ "<td><spring:bind path='creditNoteCommand.demitAmont'><input name='demitAmont' id='demitAmont"
																										+ btrid
																										+ "' value="
																										+ demitAmont
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										
																										
																										+"<td><a href='#'  onclick='editCreditNoteInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeCreditNoteInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid++;
																				$(this).dialog("close");
																				
																			}
																			if (hiddenID
																					.val() != "0") {
																				
																				
																				$('#materialId'+ hiddenID.val()).val(materialId.val());
																				$('#materialName'+ hiddenID.val()).val($('#materialId :selected').text());
																				$('#qty'+ hiddenID.val()).val(qty.val());
																				$('#perUnit'+ hiddenID.val()).val(perUnit.val());
																				$('#netPrice'+ hiddenID.val()).val(netPrice.val());
																				
																				$('#uomId'+ hiddenID.val()).val(uomId.val());
																				$('#uomName'+ hiddenID.val()).val($('#uomId :selected').text());
																				$('#demitAmont'+ hiddenID.val()).val(demitAmont.val());
																				$('#hiddenIdCreditNotePopUp').val("0");
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

										

											$("#create-AddCreditNote")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-CreditNote")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeCreditNoteInAdd(id) {
											//alert("removing row " + id);
		                               	$('#' + id).remove();
										}
										function editCreditNoteInAdd(id) {
											/* materialId ,qty,perUnit,netPrice,uomId demitAmont */
											$("#dialog-form-CreditNote").dialog("open");
											$('#materialId').val($('#materialId' + id).val());
											$('#qty').val($('#qty' + id).val());
											$('#perUnit').val($('#perUnit' + id).val());
											$('#netPrice').val($('#netPrice' + id).val());
											$('#uomId').val($('#uomId' + id).val());
											$('#demitAmont').val($('#demitAmont' + id).val());
										   $('#hiddenIdCreditNotePopUp').val(id);
																					}
										
										
										function cal()
										{
											$('#netPrice').val(parseFloat($('#qty').val())*parseFloat($('#perUnit').val()));
										}
										
										
									</script>
									<div id="dialog-form-CreditNote"
										title="Add Credit Note Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
											<tr>
												<td>Material Name</td>
												<td><form:select path="materialIdSelect"
														id="materialId" class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select></td>

											</tr>
											<tr>
												<td>Uom</td>
												<td><form:select path="uomIdSelect" id="uomId"
														class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>
											</tr>
											<tr>
												<td>Quantity</td>
												<td><form:input path="qty" id="qty" class="textbox"
														onkeyup="cal()" /></td>
											</tr>

											<tr>
												<td>Unit Price</td>
												<td><form:input path="perUnit" id="perUnit"
														class="textbox" onkeyup="cal()" /></td>
											</tr>

											<tr>
												<td>Net Price</td>
												<td><form:input path="netPrice" id="netPrice"
														class="textbox" readonly="true" /></td>
											</tr>
											<tr>
												<td>Demit Amount</td>
												<td><form:input path="demitAmont" id="demitAmont"
														class="textbox" onkeypress="demitAmount()" /><input
													type="hidden" name="hiddenIdCreditNotePopUp"
													id="hiddenIdCreditNotePopUp" value="0" /></td>
											</tr>


										</table>
									</div>


									<div id="scroll1" align="center">
										<div id="users-contain-CreditNote">

											<table id="CreditNotAdd" class="table">

												<tr id="CreditNoteAddHead">
													<th>Material Name</th>
													<th>Uom</th>
													<th>Quantity</th>
													<th>Unit Price</th>
													<th>Net Price</th>
													<th>Demit Amount</th>
													<th>Edit</th>
													<th>Remove</th>
												</tr>
											</table>


											<table class="table">
												<tbody />

											</table>

										</div>
										<button id="create-AddCreditNote" type="button">Add
											Credit Note Details</button>
									</div>

								</div>

							</div>



						</div>
						<c:choose>
							<c:when test="${true}">
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


			</div>


			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="creditNoteUpdate.mnt" method="POST"
						commandName="creditNoteCommand" id="creditEdit">
						<c:forEach var="creditNoteEditList" items="${creditNoteEditList}">


							<table>


								<tr>
									<!-- <td colspan="4" height="35px">	
										<div class="alert-warning" id="creditNoteDuplicateMessEdit" style="display: none;"></div>
										</td> -->

									<td colspan="4" id="creditNoteDuplicateMessEdit"
										style="display: none;">
										<div class="alert-warning">
											<strong> <spring:message code="label.warning" /></strong>
											<spring:message code="label.creditNoteNo" />
											<spring:message code="label.duplicateCheck" />
										</div>
									</td>
								</tr>



								<tr>
									<td>Credit Note No<span class="required">*</span></td>
									<td><form:input path="creditNoteNo" id="creditNoteNoEdit"
											class="textbox" onkeyup="doAjaxPostEdit()" maxlength="50" />
										<form:hidden path="creditNoteId" id="creditNoteIdEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Credit Note Date<span class="required">*</span></td>
									<td><form:input path="creditNoteDT" id="creditNoteDTEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Customer Invoice<span class="required">*</span></td>
									<td><form:select path="customerInvoiceId"
											id="customerInvoiceIdEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${customerInvoiceId}" />
										</form:select></td>
								</tr>
								<tr>
									<td>Vendor Invoice<span class="required">*</span></td>
									<td><form:select path="vendorInvoiceId"
											id="vendorInvoiceIdEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${vendorInvoiceId }" />
										</form:select></td>
								</tr>



							</table>







							<div id="tabs2">
								<ul>
									<li><a href="#tabs-21">Credit Note Details</a></li>

								</ul>
								<div id="tabs-21" align="center">

									<div align="left">

										<script>
										var btrid = 200;
										$(function() {       

											var  materialId = $("#materialIdEdit"),qty = $("#qtyEdit"),perUnit = $("#perUnitEdit"),
											netPrice = $("#netPriceEdit"),uomId = $("#uomIdEdit"),demitAmont = $("#demitAmontEdit"),
											hiddenID = $("#hiddenIdCreditNotePopUpEdit"),
											
											allFields = $([])
											.add(materialId)
											.add(qty)
											.add(perUnit)
											.add(netPrice)
											.add(uomId)
											.add(demitAmont)
											.add(hiddenID),
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
												if (o.val() =='0') {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
													return false;
												} else {
													return true;
												}
											}
											function checkLength2(o, n) {
												//alert("sss"+o.val());
												if (o.val()=="") {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
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
											
											function demitAmount(a,b,c)
											{
											//	alert("ddd");
												 
												/* if(!isNaN($('#netPrice').val()))
													{ */
													if(parseFloat(a.val())<parseFloat(b.val()))
														{
														b.addClass("ui-state-error");
														updateTips(c +" should be less than Net Price");
														return false;
														}
														else 
														{
														return true;
														}
													
													/* } */
											}
										    

											$("#dialog-form-CreditNoteEdit")
													.dialog(
															{
																autoOpen : false,
																height : 350,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");
																		
																	

																		bValid = bValid && checkLength1(materialId ,"Material Name");
																		bValid = bValid && checkRegexp(qty,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Quantity may consist of 0-9.");
																		bValid = bValid && checkRegexp(perUnit,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Unit Price may consist of 0-9.");
																		bValid = bValid && checkRegexp(netPrice,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Net Price may consist of 0-9.");
																		bValid = bValid && checkLength1(uomId,"Uom");
																		bValid = bValid && checkLength1(demitAmont,"Demit Amount");
																		bValid = bValid && demitAmount(netPrice,demitAmont,"Demit Amount");
																		//alert(bValid+"bValid");

																		if (bValid) {
																			//alert("hiddenid="+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
																				/* materialId ,qty,perUnit,netPrice,uomId demitAmont */
																		     
																				$("#CreditNotEdit tbody")   
																						.append(
																								"<tr id="+btrid+">"      
																										+ "<td><spring:bind path='creditNoteCommand.creditNoteDetailId'><input type='hidden' name='creditNoteDetailId' id='creditNoteDetailId' value='0'/></spring:bind><spring:bind path='creditNoteCommand.materialId'><input type='hidden' name='materialId' id='materialIdEdit"
																										+ btrid
																										+ "' value="
																										+ materialId
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='creditNoteCommand.materialName'><input type='text' name='materialName' id='materialNameEdit"
																										+ btrid
																										+ "' value='"
																										+ $('#materialIdEdit :selected').text()
																										+ "' class='textbox' readonly/></spring:bind> </td>"
																										+ "<td><spring:bind path='creditNoteCommand.uomId'><input type='hidden' name='uomId' id='uomIdEdit"
																										+ btrid
																										+ "' value="
																										+ uomId
																												.val()
																										+ " class='textbox'/></spring:bind><spring:bind path='creditNoteCommand.uomName'><input name='uomName' id='uomNameEdit"
																										+ btrid
																										+ "' value='" 
																										+$('#uomIdEdit :selected').text()
																										+ "' class='textbox'/></spring:bind></td>"
																									
																										
																										+ "<td><spring:bind path='creditNoteCommand.qty'><input name='qty' id='qtyEdit"
																										+ btrid
																										+ "' value="
																										+ qty
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='creditNoteCommand.perUnit'><input name='perUnit' id='perUnitEdit"
																										+ btrid
																										+ "' value="
																										+ perUnit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='creditNoteCommand.netPrice'><input name='netPrice' id='netPriceEdit"
																										+ btrid
																										+ "' value="
																										+ netPrice
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																									
																										+ "<td><spring:bind path='creditNoteCommand.demitAmont'><input name='demitAmont' id='demitAmontEdit"
																										+ btrid
																										+ "' value="
																										+ demitAmont
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										
																										
																										+"<td><a href='#'  onclick='editCreditNoteInEdit("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeCreditNoteInEdit("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid++;
																				$(this).dialog("close");
																				
																			}
																			if (hiddenID
																					.val() != "0") {
																				
																				
																				$('#materialIdEdit'+ hiddenID.val()).val(materialId.val());
																				$('#materialNameEdit'+ hiddenID.val()).val($('#materialIdEdit :selected').text());
																				$('#qtyEdit'+ hiddenID.val()).val(qty.val());
																				$('#perUnitEdit'+ hiddenID.val()).val(perUnit.val());
																				$('#netPriceEdit'+ hiddenID.val()).val(netPrice.val());
																				
																				$('#uomIdEdit'+ hiddenID.val()).val(uomId.val());
																				$('#uomNameEdit'+ hiddenID.val()).val($('#uomIdEdit :selected').text());
																				$('#demitAmontEdit'+ hiddenID.val()).val(demitAmont.val());
																				$('#hiddenIdCreditNotePopUpEdit').val("0");
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

										

											$("#create-EditCreditNote")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-CreditNoteEdit")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeCreditNoteInEdit(id) {
											//alert("removing row " + id);
		                               	$('#'+id).remove();
										}
										function disabledCreditInEdit(id) {
											//alert("wd"+id);
											alert("Deleting Particular Row Will Deleted Once You Click Update Button");
											document.getElementById("CheckCredit"+id).value = "1";
											document.getElementById(id).style.display = "none";
										}
										function editCreditNoteInEdit(id) {
											/* materialId ,qty,perUnit,netPrice,uomId demitAmont */
											$("#dialog-form-CreditNoteEdit").dialog("open");
											$('#materialIdEdit').val($('#materialIdEdit' + id).val());
											$('#qtyEdit').val($('#qtyEdit' + id).val());
											$('#perUnitEdit').val($('#perUnitEdit' + id).val());
											$('#netPriceEdit').val($('#netPriceEdit' + id).val());
											$('#uomIdEdit').val($('#uomIdEdit' + id).val());
											$('#demitAmontEdit').val($('#demitAmontEdit' + id).val());
										   $('#hiddenIdCreditNotePopUpEdit').val(id);
																					}
										
										
										function calEdit()
										{
											$('#netPriceEdit').val(parseFloat($('#qtyEdit').val())*parseFloat($('#perUnitEdit').val()));
										}
										
										
									</script>
										<div id="dialog-form-CreditNoteEdit"
											title="Add Credit Note Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">
												<tr>
													<td>Material Name</td>
													<td><form:select path="materialIdSelect"
															id="materialIdEdit" class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>

												</tr>
												<tr>
													<td>Uom</td>
													<td><form:select path="uomIdSelect" id="uomIdEdit"
															class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>
												</tr>
												<tr>
													<td>Quantity</td>
													<td><form:input path="qty" id="qtyEdit"
															class="textbox" onkeyup="calEdit()" /></td>
												</tr>

												<tr>
													<td>Unit Price</td>
													<td><form:input path="perUnit" id="perUnitEdit"
															class="textbox" onkeyup="calEdit()" /></td>
												</tr>

												<tr>
													<td>Net Price</td>
													<td><form:input path="netPrice" id="netPriceEdit"
															class="textbox" readonly="true" /></td>
												</tr>
												<tr>
													<td>Demit Amount</td>
													<td><form:input path="demitAmont" id="demitAmontEdit"
															class="textbox" /><input type="hidden"
														name="hiddenIdCreditNotePopUp"
														id="hiddenIdCreditNotePopUpEdit" value="0" /></td>
												</tr>



											</table>
										</div>


										<div id="scroll1" align="center">
											<div id="users-contain-CreditNoteEdit">


												<table id="CreditNotEdit" class="table">

													<tr id="CreditNoteEditHead">
														<th>Material Name</th>
														<th>Uom</th>
														<th>Quantity</th>
														<th>Unit Price</th>
														<th>Net Price</th>
														<th>Demit Amount</th>
														<th>Edit</th>
														<th>Remove</th>
													</tr>


													<c:forEach var="creditNoteDetailEditList"
														items="${creditNoteDetailEditList }">

														<tr id="${creditNoteDetailEditList.creditNoteDetailId}">

															<td><spring:bind
																	path="creditNoteCommand.creditNoteDetailId">
																	<input type='hidden' name="creditNoteDetailId"
																		id="creditNoteDetailId"
																		value="${creditNoteDetailEditList.creditNoteDetailId }" />
																</spring:bind> <spring:bind path="creditNoteCommand.materialId">
																	<input type="hidden" name="materialId"
																		id="materialIdEdit${creditNoteDetailEditList.creditNoteDetailId }"
																		class="textbox"
																		value="${creditNoteDetailEditList.materialId }" />
																</spring:bind> <spring:bind path="creditNoteCommand.materialName">
																	<input name="materialName"
																		id="materialNameEdit${creditNoteDetailEditList.creditNoteDetailId }"
																		class="textbox"
																		value="${creditNoteDetailEditList.materialName}"
																		readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind path="creditNoteCommand.uomId">
																	<input type="hidden" name="uomId"
																		id="uomIdEdit${creditNoteDetailEditList.creditNoteDetailId }"
																		class="textbox"
																		value="${creditNoteDetailEditList.uomId}"
																		readonly="readonly" />
																</spring:bind> <spring:bind path="creditNoteCommand.uomName">
																	<input name="uomName"
																		id="uomNameEdit${creditNoteDetailEditList.creditNoteDetailId }"
																		class="textbox"
																		value="${creditNoteDetailEditList.uomName }"
																		readonly="readonly" />
																</spring:bind></td>

															<td><spring:bind path="creditNoteCommand.qty">
																	<input name="qty"
																		id="qtyEdit${creditNoteDetailEditList.creditNoteDetailId }"
																		class="textbox"
																		value="${creditNoteDetailEditList.qty}"
																		readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind path="creditNoteCommand.perUnit">
																	<input name="perUnit"
																		id="perUnitEdit${creditNoteDetailEditList.creditNoteDetailId}"
																		class="textbox"
																		value="${creditNoteDetailEditList.perUnit}"
																		readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind path="creditNoteCommand.netPrice">
																	<input name="netPrice"
																		id="netPriceEdit${creditNoteDetailEditList.creditNoteDetailId }"
																		class="textbox"
																		value="${creditNoteDetailEditList.netPrice }"
																		readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind path="creditNoteCommand.demitAmont">
																	<input name="demitAmont"
																		id="demitAmontEdit${creditNoteDetailEditList.creditNoteDetailId }"
																		class="textbox"
																		value="${creditNoteDetailEditList.demitAmont }"
																		readonly="readonly" />
																</spring:bind> <input type="hidden"
																name="CheckCredit${creditNoteDetailEditList.creditNoteDetailId}"
																id="CheckCredit${creditNoteDetailEditList.creditNoteDetailId}"
																value="0" /></td>

															<td><a href="#" style="float: left;" class="remove"><strong><img
																		src="images/Edit.jpg" height="20px" width="20px"
																		onclick="editCreditNoteInEdit(${creditNoteDetailEditList.creditNoteDetailId})" /></strong></a></td>
															<td><a href="#"
																style="float: left; margin: 0px 0 0 5px;" class="remove"
																onclick="disabledCreditInEdit(${creditNoteDetailEditList.creditNoteDetailId})"><strong><img
																		src="images/button_cancel.png" height="20px"
																		width="20px" /></strong></a></td>
														</tr>

													</c:forEach>
												</table>


												<table class="table">
													<tbody />

												</table>

											</div>

											<button id="create-EditCreditNote" type="button">Add
												Credit Note Details</button>
										</div>

									</div>

								</div>


							</div>
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

						</c:forEach>
					</form:form>
				</div>


			</div>
		</div>


	</div>






</body>
</html>











