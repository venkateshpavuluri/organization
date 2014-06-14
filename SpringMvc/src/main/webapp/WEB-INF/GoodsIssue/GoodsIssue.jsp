<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
function dateFun(datePattern) {
	$("#goodsIssueDate,#postingDate,#goodsIssueDateEdit,#postingDateEdit").datepicker({
		dateFormat : datePattern,
		changeMonth : true,
		changeYear : true
		
	});

}

 function doAjaxPost(id) {
	//alert("asd"+id);
	  if(id=='A')
		  {
	var goodsIssueNo = $('#goodsIssueNo').val();
	//alert("sdf"+purchaseOrderNo);
		$.ajax({
			type : "POST",
			url : "duplicateGoodsIssueNoCheck.mnt",
			data : "goodsIssueNo=" + goodsIssueNo+ "&goodsIssueId=0",
			success : function(data) {
				//alert(data);
				var checkResponse="Warning ! Goods Issue aleardy exists. Please try some other no";
				if(checkResponse==data)
				{
				document.getElementById("goodsIssueDuplicateMess").style.display="block";
				//$('#goodsIssueDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("goodsIssueDuplicateMess").style.display="none";
				$('#save').show();
				}
			},
			error : function(e) {
				alert('Error: ' + e);
			}

		});
		  }
	  if(id=='E')
		  { 
		  
			var goodsIssueId = $('#goodsIssueId').val();
			 var goodsIssueNo = $('#goodsIssueNoEdit').val();
			
				$.ajax({
					type : "POST",
					url : "duplicateGoodsIssueNoCheck.mnt",
					data : "goodsIssueNo=" + goodsIssueNo+ "&goodsIssueId=" + goodsIssueId,
					success : function(data) {
					//alert("data "+data);
						var checkResponse="Warning ! Goods Issue aleardy exists. Please try some other no";
						if(checkResponse==data)
						{
						document.getElementById("goodsIssueDuplicateMessEdit").style.display="block";
						//$('#goodsIssueDuplicateMessEdit').html(data);
						$('#update').hide();
						}
						else
						{
						document.getElementById("goodsIssueDuplicateMessEdit").style.display="none";
						$('#update').show();
						}
					},
					error : function(e) {
						//alert('Error: ' + e);
					}

				});
		  
		  
		  }
	}

$(document).ready(function() {

	$('#save').click(function(event) {
	 
	 	$('#goodsIssueAdd').validate({
			rules : {	
				
				goodsIssueNo:{required:true,alphaNumeric:true,},
			    goodsIssueDate:{required:true,minlength: 10},
			    deliveryNoteId:{required:true},
			    producionOrderId:{required:true},
			    postingDate:{required:true,minlength: 10},
			    reasonForMovementId:{required:true},
			    reference:{required:true,alphaNumeric:true,},
				
			},
			messages : {
							
				goodsIssueNo:{
					required: "<font style='color: red;'><b>Goods Issue No is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
				
				goodsIssueDate: 
				{
				required:"<font style='color: red;'><b>Goods Issue Date is Required</b></font>",
				minlength: "<font style='color: red;'><b>Start Date is Required Eg: 2014-02-13</b></font>",
				},
				
				deliveryNoteId: "<font style='color: red;'><b>Delivery Note is Required</b></font>",
			    producionOrderId: "<font style='color: red;'><b>Production Order is Required</b></font>",
			    
			    postingDate: 
				{
				required:"<font style='color: red;'><b>Posting Date is Required</b></font>",
				minlength: "<font style='color: red;'><b>Start Date is Required Eg: 2014-02-13</b></font>",
				},
				
			    reasonForMovementId: "<font style='color: red;'><b>Reason For Movement is Required</b></font>",
			    reference:{
					required: "<font style='color: red;'><b>Reference  is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
			     
				
			},
			

		}); 
		
	});

	
	$('#update').click(function(event) {
		
	 	$('#goodsIssueUpdate').validate({
			rules : {
				
				goodsIssueNo:{required:true,alphaNumeric:true,},
			    goodsIssueDate:{required:true,minlength: 10},
			    deliveryNoteId:{required:true},
			    producionOrderId:{required:true},
			    postingDate:{required:true,minlength: 10},
			    reasonForMovementId:{required:true},
			    reference:{required:true,alphaNumeric:true,},
				
			},
			messages : {
							
				goodsIssueNo:{
					required: "<font style='color: red;'><b>Goods Issue No is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
				
				goodsIssueDate: 
				{
				required:"<font style='color: red;'><b>Goods Issue Date is Required</b></font>",
				minlength: "<font style='color: red;'><b>Start Date is Required Eg: 2014-02-13</b></font>",
				},
				
				deliveryNoteId: "<font style='color: red;'><b>Delivery Note is Required</b></font>",
			    producionOrderId: "<font style='color: red;'><b>Production Order is Required</b></font>",
			    
			    postingDate: 
				{
				required:"<font style='color: red;'><b>Posting Date is Required</b></font>",
				minlength: "<font style='color: red;'><b>Start Date is Required Eg: 2014-02-13</b></font>",
				},
				
			    reasonForMovementId: "<font style='color: red;'><b>Reason For Movement is Required</b></font>",
			    reference:{
					required: "<font style='color: red;'><b>Reference  is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
			},
			

		}); 
		
	});
	
	
	
}); 


</script>

<script>
	$(document).ready(function() {

		$('#add').click(function(e) {
			// alert("kiran add");
			$('#edit').hide();
			$('#tabs-1').hide();
			$('#goodsIssueNo').val('');
					$('#goodsIssueDate').val('');
							$('#deliveryNoteId').val('');
									$('#producionOrderId').val('');
											$('#postingDate').val('');
													$('#reasonForMovementId').val('');
															$('#reference').val('');
			//$('#goodsIssueId').val('');
					
			//$('#successmessage').hide();
		//	$('#savemessage').hide();

		});

		$('#search').click(function(e) {
			$('#edit').hide();
			$('#tabs-1').hide();

		});
		
	});
	function callForProduction(val)
	 {	
		var producionOrderId=$('#producionOrderId').val();
		//alert(producionOrderId);
		if(producionOrderId!="0")
			{
			$('#deliveryNoteId').val("");
			}
	 }


	function callForDeliveryNote(val)
	 {
		var deliveryNoteId=$('#deliveryNoteId').val();
		//alert(deliveryNoteId);
		if(deliveryNoteId!="0")
			{
			$('#producionOrderId').val("");
			}
		
	 }
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
	align: center;
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
			<spring:message code="label.goodsIssue" />
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vendorValues" items="${goodsIssueEditList}">
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
						<form:form action="goodsIssueSearch.mnt" method="GET"
							commandName="goodsIssueCommand">
							<tr>
								<td colspan="2"><c:forEach var="addPursu"
										items="${param.addPursu}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.goodsIssue" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach var="fail" items="${fail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.goodsIssue" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="purcUpdate"
										items="${param.purcUpdate}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.goodsIssue" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach var="fail" items="${updatefail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.goodsIssue" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeletePursu"
										items="${deleteSus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.goodsIssue" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach var="fail" items="${deletefail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.goodsIssue" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>


							<tr id="mainSearch">
								<td><form:hidden path="advanceBasicSearchHidden"
										id="advanceBasicSearchHidden" value="0" /> <spring:message
										code="label.searchby" />
								<form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="goodsIssueCommand.operations">
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


						</form:form>
						<form:form action="goodsIssueAdvanceSearch.mnt" method="GET"
							commandName="goodsIssueCommand" name="advanceSearchFinal">
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
					<form:form action="goodsIssueSearch.mnt"
						commandName="goodsIssueCommand" method="GET">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue"
									items="${goodsIssueSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><spring:bind path="goodsIssueCommand.operations1">
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
									<tr>
										<form:hidden path="advanceBasicSearchHidden"
											id="advanceBasicSearchHidden" />
										<form:hidden path="advanceSearchHidden"
											id="advanceSearchHidden" />
										<td colspan="3"><input type="submit"
											id="advanceSearchButtonId" value="Advance Search"
											style="display: none" class="btn btn-primary" /></td>
									</tr>

								</c:forEach>

							</table>

						</div>
					</form:form>



					<c:if test="${goodsIssueList!=null }">

						<display:table name="goodsIssueList" id="purcList" class="table"
							requestURI="goodsIssueSearch.mnt" pagesize="5">

							<display:column property="goodsIssueNo" sortable="true"
								titleKey="label.goodsIssueNo" media="html" />

							<display:column property="goodsIssueDate" sortable="true"
								titleKey="label.goodsIssueDate" media="html" />

							<display:column property="deliveryNoteId" sortable="true"
								titleKey="label.deliveryNoteId" media="none" />


							<display:column property="producionOrderId" sortable="true"
								titleKey="label.producionOrderId" media="none" />
							<display:column property="postingDate" sortable="true"
								titleKey="label.postingDate" media="html" />

							<display:column property="reasonForMovementId" sortable="true"
								titleKey="label.reasonForMovementId" media="html" />

							<display:column property="reference" sortable="true"
								titleKey="label.reference" media="html" />


							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">

										<a
											href="goodsIssueEdit.mnt?goodsIssueId=<c:out value="${purcList.goodsIssueId}"/> "><img
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
											href="goodsIssueDelete.mnt?goodsIssueId=<c:out value="${purcList.goodsIssueId}"/> "
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
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2">
								<div class="alert-warning" id="goodsIssueDuplicateMess"
									style="display: none;">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.goodsIssueNo" />
									<spring:message code="label.duplicateCheck" />

								</div></td>
						</tr>
					</table>
					<form:form action="GoodsIssueAdd.mnt" method="POST"
						commandName="goodsIssueCommand" id="goodsIssueAdd"
						name="goodsIssueAdd">
						<form:hidden path="goodsIssueNoDuplicate" />
						<table>
							<tr>
								<td><spring:message code="label.goodsIssueNo" /><span
									class="required">*</span></td>
								<td><form:input path="goodsIssueNo" id="goodsIssueNo"
										class="textbox" maxlength="50" onkeyup="doAjaxPost('A')" /></td>
								<td><spring:message code="label.goodsIssueDate" /><span
									class="required">*</span></td>
								<td><form:input path="goodsIssueDate" id="goodsIssueDate"
										class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.deliveryNoteId" /><span
									class="required">*</span></td>
								<td><form:select path="deliveryNoteId" id="deliveryNoteId"
										class="select" onchange="callForDeliveryNote('A')">
										<form:option value="0">-Select-</form:option>
										<form:options items="${deliveryNote }" />
									</form:select></td>
								<td><spring:message code="label.producionOrderId" /><span
									class="required">*</span></td>
								<td><form:select path="producionOrderId"
										id="producionOrderId" class="select"
										onchange="callForProduction('A')">
										<form:option value="0">-Select-</form:option>
										<form:options items="${producionOrderId }" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.postingDate" /><span
									class="required">*</span></td>
								<td><form:input path="postingDate" id="postingDate"
										class="textbox" /></td>
								<td><spring:message code="label.reasonForMovementId" /><span
									class="required">*</span></td>
								<td><form:select path="reasonForMovementId"
										id="reasonForMovementId" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${reasonForMovement }" />
									</form:select></td>
							</tr>

							<tr>
								<td><spring:message code="label.reference" /><span
									class="required">*</span></td>
								<td><form:input path="reference" id="reference"
										class="textbox" /></td>
								<td></td>
								<td></td>
							</tr>

						</table>


						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11"><spring:message
											code="label.gidetails" /></a></li>

							</ul>
							<div id="tabs-11">

								<div align="left">

									<script>
										var btrid = 200;
										$(function() {  										 							  
											    
											   
											var  materialId = $("#materialId"),qty = $("#qty"),
											uOMId = $("#uOMId"),batchNo = $("#batchNo"),
											plantId = $("#plantId"),storageLocationId = $("#storageLocationId"),
											hiddenID = $("#hiddenIdGoodsIssuePopUp"),availableQty = $("#availableQty"),
											
											allFields = $([])
											.add(materialId).add(qty).add(uOMId).add(batchNo).add(plantId).add(storageLocationId)
											.add(hiddenID).add(availableQty),
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
											
											function checkLength3(o,k,n) {
											//alert("sss"+o.val()+"   kval    "+k.val()); 
											var qty=parseInt(o.val());
											var aqty=parseInt(k.val());
												if(qty<=aqty)
												{
												return true;
												}
												else
													{
													o.addClass("ui-state-error");
													updateTips(""+ n +" Should be less than or equal to available qty ");
													return false;
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

											$("#dialog-form-goodsIssue")
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
																		bValid = bValid && checkLength3(qty,availableQty,"Quantity");
																		bValid = bValid && checkLength1(uOMId ,"Uom");
																		bValid = bValid && checkLength2(batchNo ,"Batch No");
																		bValid = bValid && checkLength1(plantId ,"Plant");
																		bValid = bValid && checkLength1(storageLocationId ,"Storage Location");
																		
	
																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
																		    //alert("value "+);
																		    	
																		      
																				$("#goodsIssueLineAdd tbody")   
																						.append(
																								"<tr id="+btrid+">"   
																							
																								+ "<td><spring:bind path='goodsIssueCommand.materialId'><input type='hidden' name='materialId' id='materialId"
																								+ btrid
																								+ "' value="
																								+ materialId
																										.val()
																								+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.materialName'><input type='text' name='materialName' id='materialName"
																								+ btrid
																								+ "' value='"
																								+ $('#materialId :selected').text()
																								+ "' class='textbox' readonly/></spring:bind> </td>"
																								
																								
																								+ "<td><spring:bind path='goodsIssueCommand.qty'><input type='text' name='qty' id='qty"
																								+ btrid
																								+ "' value='"
																								+ qty
																								.val()
																								+ "' class='textbox' readonly/></spring:bind> "
																								+ "<spring:bind path='goodsIssueCommand.qtyAcc'>"
																								+ "<input type='hidden' name='qtyAcc'"
																								+ "	value='0'"
																								+ "	class='textbox' readonly='readonly' />"
																								+ "</spring:bind></td>"
																								
																								
																								+ "<td><spring:bind path='goodsIssueCommand.uOMId'><input type='hidden' name='uOMId' id='uOMId"
																								+ btrid
																								+ "' value="
																								+ uOMId
																										.val()
																								+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.uOMName'><input type='text' name='uOMName' id='uOMName"
																								+ btrid
																								+ "' value='"
																								+ $('#uOMId :selected').text()
																								+ "' class='textbox' readonly/></spring:bind> </td>"
																								
																								
																								+ "<td><spring:bind path='goodsIssueCommand.batchNo'><input type='text' name='batchNo' id='batchNo"
																								+ btrid
																								+ "' value='"
																								+ batchNo
																								.val()
																								+ "' class='textbox' readonly/></spring:bind> </td>"
																								+ "<td><spring:bind path='goodsIssueCommand.plantId'><input type='hidden' name='plantId' id='plantId"
																									+ btrid
																									+ "' value="
																									+ plantId
																											.val()
																									+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.plantName'><input type='text' name='plantName' id='plantName"
																									+ btrid
																									+ "' value='"
																									+ $('#plantId :selected').text()
																									+ "' class='textbox' readonly/></spring:bind> </td>"
																									
																									
																									+ "<td><spring:bind path='goodsIssueCommand.storageLocationId'><input type='hidden' name='storageLocationId' id='storageLocationId"
																									+ btrid
																									+ "' value="
																									+ storageLocationId
																											.val()
																									+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.storageLocationName'><input type='text' name='storageLocationName' id='storageLocationName"
																									+ btrid
																									+ "' value='"
																									+ $('#storageLocationId :selected').text()
																									+ "' class='textbox' readonly/></spring:bind> </td>"
																									
																										
																										+"<td><a href='#'  onclick='editGoodsIssueInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeGoodsIssueInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid++;
																			//	$('#goodsIssueValue').val(parseFloat($('#goodsIssueValue').val())+parseFloat($('#lineAmtChild').val()));
																				$(
																						this)
																						.dialog(
																								"close");
																				
																			}
																			if (hiddenID
																					.val() != "0") {
																				 
																				    
																				    
																			  $('#materialId'+ hiddenID.val()).val(materialId.val());
																			  $('#materialName'+ hiddenID.val()).val($('#materialId :selected').text());
																			  $('#batchNo'+hiddenID.val()).val(batchNo.val()); 
																			  $('#qty'+hiddenID.val()).val(qty.val());
																			  $('#uOMId'+ hiddenID.val()).val(uOMId.val());
																			  $('#uOMName'+ hiddenID.val()).val($('#uOMId :selected').text());
																			  $('#plantId'+ hiddenID.val()).val(plantId.val());
																			  $('#plantName'+ hiddenID.val()).val($('#plantId :selected').text());
                 														    $('#storageLocationId'+ hiddenID.val()).val(storageLocationId.val());
																		  $('#storageLocationName'+ hiddenID.val()).val($('#storageLocationId :selected').text());
																			    

																			  $('#hiddenIdGoodsIssuePopUp').val("0");
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

										

											$("#create-AddGoodsIssue")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-goodsIssue")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeGoodsIssueInAdd(id) {
											//alert("removing row " + id);
		                                	$('#' + id).remove();
										}
										function editGoodsIssueInAdd(id) {
											//alert("edit row " + id);
											$("#dialog-form-goodsIssue").dialog("open");
											$('#materialId').val($('#materialId' + id).val());
											$('#batchNo').val($('#batchNo' + id).val());
											$('#qty').val($('#qty' + id).val());
											$('#uOMId').val($('#uOMId' + id).val());
											$('#plantId').val($('#plantId' + id).val());
											$('#storageLocationId').val($('#storageLocationId' + id).val());
											$('#hiddenIdGoodsIssuePopUp').val(id);
											getAvailablity();
											}
										function getAvailablity()
										{
											 
										     var materialId = $('#materialId').val();
											 var batchNo = $('#batchNo').val();
											 var storageLocationId = $('#storageLocationId').val();
											 //alert(materialId+" "+batchNo+ " "+storageLocationId);
											 $("#availableQty").val('');
											if(materialId!="0" && batchNo!="0" &&  storageLocationId!="0"){
											$.ajax({
												type : "POST",
												url : "forAvailability.mnt",
												data : "materialId=" + materialId+ "&batchNo="+batchNo+"&storageLocationId="+storageLocationId,
												success : function(data) {
													//alert("Qty"+data);
													$("#availableQty").val(data);
												},
												error : function(e) {
													alert('Error: ' + e);
												}

											});
										}
											
										}
									</script>


									<div id="dialog-form-goodsIssue"
										title="Add Goods Issue Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">

											<tr>
												<td><spring:message code="label.gimaterial" /><span
													class="required">*</span></td>
												<td><form:select path="materialIdSelect"
														id="materialId" class="select" onchange="getAvailablity()">
														<form:option value="0">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select> <input type="hidden" name="hiddenIdGoodsIssuePopUp"
													id="hiddenIdGoodsIssuePopUp" value="0" /></td>

											</tr>

											<tr>
												<td><spring:message code="label.giuom" /><span
													class="required">*</span></td>
												<td><form:select path="uOMIdSelect" id="uOMId"
														class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>


											</tr>

											<tr>
												<td><spring:message code="label.gibno" /><span
													class="required">*</span></td>
												<td><form:select path="batchNoSelect" id="batchNo"
														class="select" onchange="getAvailablity()">
														<form:option value="0">-Select-</form:option>
														<form:options items="${batchNo}" />
													</form:select></td>


											</tr>

											<tr>
												<td><spring:message code="label.giplant" /><span
													class="required">*</span></td>
												<td><form:select path="plantIdSelect" id="plantId"
														class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${SelectPlant}" />
													</form:select></td>

											</tr>

											<tr>
												<td><spring:message code="label.gistrloc" /><span
													class="required">*</span></td>
												<td><form:select path="storageLocationIdSelect"
														id="storageLocationId" class="select"
														onchange="getAvailablity()">
														<form:option value="0">-Select-</form:option>
														<form:options items="${SelectStorageLocation}" />
													</form:select></td>

											</tr>
											<tr>
												<td><spring:message code="label.giavlqty" /></td>
												<td><input name="availableQty" id="availableQty"
													class="textbox" readonly="readonly" /></td>

											</tr>

											<tr>
												<td><spring:message code="label.giqty" /><span
													class="required">*</span></td>
												<td><form:input path="qty" id="qty" class="textbox" />

												</td>


											</tr>


										</table>
									</div>


									<div id="scroll1" align="center">
										<div id="users-contain-goodsIssue">


											<table id="goodsIssueLineAdd" class="table">

												<tr id="goodsIssueAddHead">

													<th><spring:message code="label.gimaterial" /></th>
													<th><spring:message code="label.giqty" /></th>
													<th><spring:message code="label.giuom" /></th>
													<th><spring:message code="label.gibno" /></th>
													<th><spring:message code="label.giplant" /></th>
													<th><spring:message code="label.gistrloc" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>

											</table>

											<table>


												<tbody>
												</tbody>
											</table>

										</div>

										<div id="extender"></div>
										<button id="create-AddGoodsIssue" type="button">
											<spring:message code="label.addgi" />
										</button>
									</div>

								</div>

							</div>

						</div>
						<table>
							<tr>
								<c:choose>
									<c:when test="${save}">
										<td><input type="submit" id="save"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="save" disabled="disabled"
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

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td>
								<div class="alert-warning" id="goodsIssueDuplicateMessEdit"
									style="display: none;">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.goodsIssueNo" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="goodsIssueUpdate.mnt" method="POST"
						commandName="goodsIssueCommand" id="goodsIssueUpdate">
						<c:forEach var="goodsIssueEditList" items="${goodsIssueEditList}">
							<form:hidden path="goodsIssueNoDuplicate" />
							<table>
								<tr>
									<td><spring:message code="label.goodsIssueNo" /><span
										class="required">*</span></td>
									<td><form:input path="goodsIssueNo" id="goodsIssueNoEdit"
											class="textbox" maxlength="50" onkeyup="doAjaxPost('E')" />
										<form:hidden path="goodsIssueId" id="goodsIssueId"
											class="textbox" /></td>
									<td><spring:message code="label.goodsIssueDate" /><span
										class="required">*</span></td>
									<td><form:input path="goodsIssueDate" id="goodsIssueDateEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.deliveryNoteId" /><span
										class="required">*</span></td>
									<td><form:select path="deliveryNoteId"
											id="deliveryNoteIdEdit" class="select"
											onchange="callForDeliveryNoteE('E') ">
											<form:option value="0">-Select-</form:option>
											<form:options items="${deliveryNote }" />
										</form:select></td>
									<td><spring:message code="label.producionOrderId" /><span
										class="required">*</span></td>
									<td><form:select path="producionOrderId"
											id="producionOrderIdEdit" class="select"
											onchange="callForProductionE('E')">
											<form:option value="0">-Select-</form:option>
											<form:options items="${producionOrderId }" />
										</form:select></td>
								</tr>


								<tr>
									<td><spring:message code="label.postingDate" /><span
										class="required">*</span></td>
									<td><form:input path="postingDate" id="postingDateEdit"
											class="textbox" /></td>
									<td><spring:message code="label.reasonForMovementId" /><span
										class="required">*</span></td>
									<td><form:select path="reasonForMovementId"
											id="reasonForMovementId" class="select">
											<form:option value="0">-Select-</form:option>
											<form:options items="${reasonForMovement }" />
										</form:select></td>
								</tr>

								<tr>
									<td><spring:message code="label.reference" /><span
										class="required">*</span></td>
									<td><form:input path="reference" id="reference"
											class="textbox" /></td>
									<td></td>
									<td></td>
								</tr>

							</table>

							<div id="tabs2">

								<ul>
									<li><a href="#tabs-21"><spring:message
												code="label.gidetails" /></a></li>

								</ul>
								<div id="tabs-21">

									<div align="left">

										<script>
										var btrid = 400;
										$(function() {  
											  											    									    
											   
											var  materialId = $("#materialIdEdit"),qty = $("#qtyEdit"),
											uOMId = $("#uOMIdEdit"),batchNo = $("#batchNoEdit"),
											plantId = $("#plantIdEdit"),storageLocationId = $("#storageLocationIdEdit"),
											hiddenID = $("#hiddenIdGoodsIssuePopUpEdit"),availableQty = $("#availableQtyEdit"),
											
											allFields = $([])
											.add(materialId).add(qty).add(uOMId).add(batchNo).add(plantId).add(storageLocationId)
											.add(hiddenID).add(availableQty),
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
											
											
											function checkLength3(o,k,n) {
											//	alert("sss"+o.val()+"   kval    "+k.val()); 
												var qty=parseInt(o.val());
												var aqty=parseInt(k.val());
													if(qty<=aqty)
													{
													return true;
													}
													else
														{
														o.addClass("ui-state-error");
														updateTips(""+ n +" Should be less than or equal to available qty ");
														return false;
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

											$("#dialog-form-goodsIssueEdit")
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
																		bValid = bValid && checkLength3(qty ,availableQty,"Quantity");
																		bValid = bValid && checkLength1(uOMId ,"Uom");
																		bValid = bValid && checkLength2(batchNo ,"Batch No");
																		bValid = bValid && checkLength1(plantId ,"Plant");
																		bValid = bValid && checkLength1(storageLocationId ,"Storage Location");
																		
	
																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
																		    //alert("value "+);
																		    	
																		      
																				$("#goodsIssueLineAddEdit tbody")   
																						.append(
																								"<tr id="+btrid+">"   
																							
																								+ "<td><spring:bind path='goodsIssueCommand.goodsIssueLineId'><input type='hidden' name='goodsIssueLineId' value='0' class='textbox'  /></spring:bind><spring:bind path='goodsIssueCommand.materialId'><input type='hidden' name='materialId' id='materialIdEdit"
																								+ btrid
																								+ "' value="
																								+ materialId
																										.val()
																								+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.materialName'><input type='text' name='materialName' id='materialNameEdit"
																								+ btrid
																								+ "' value='"
																								+ $('#materialIdEdit :selected').text()
																								+ "' class='textbox' readonly/></spring:bind> </td>"
																								
																								
																								+ "<td><spring:bind path='goodsIssueCommand.qty'><input type='text' name='qty' id='qtyEdit"
																								+ btrid
																								+ "' value='"
																								+ qty
																								.val()
																								+ "' class='textbox' readonly/></spring:bind>"
																								
																								+ "<spring:bind path='goodsIssueCommand.qtyAcc'>"
																								+ "<input type='hidden' name='qtyAcc'"
																								+ "	value='0'"
																								+ "	class='textbox' readonly='readonly' />"
																								+ "</spring:bind></td>"
																								
																								
																								+ "<td><spring:bind path='goodsIssueCommand.uOMId'><input type='hidden' name='uOMId' id='uOMIdEdit"
																								+ btrid
																								+ "' value="
																								+ uOMId
																										.val()
																								+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.uOMName'><input type='text' name='uOMName' id='uOMNameEdit"
																								+ btrid
																								+ "' value='"
																								+ $('#uOMIdEdit :selected').text()
																								+ "' class='textbox' readonly/></spring:bind> </td>"
																								
																								
																								+ "<td><spring:bind path='goodsIssueCommand.batchNo'><input type='text' name='batchNo' id='batchNoEdit"
																								+ btrid
																								+ "' value='"
																								+ batchNo
																								.val()
																								+ "' class='textbox' readonly/></spring:bind> </td>"
																								+ "<td><spring:bind path='goodsIssueCommand.plantId'><input type='hidden' name='plantId' id='plantIdEdit"
																									+ btrid
																									+ "' value="
																									+ plantId
																											.val()
																									+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.plantName'><input type='text' name='plantName' id='plantNameEdit"
																									+ btrid
																									+ "' value='"
																									+ $('#plantIdEdit :selected').text()
																									+ "' class='textbox' readonly/></spring:bind> </td>"
																									
																									
																									+ "<td><spring:bind path='goodsIssueCommand.storageLocationId'><input type='hidden' name='storageLocationId' id='storageLocationIdEdit"
																									+ btrid
																									+ "' value="
																									+ storageLocationId
																											.val()
																									+ " class='textbox' readonly/></spring:bind><spring:bind path='goodsIssueCommand.storageLocationName'><input type='text' name='storageLocationName' id='storageLocationNameEdit"
																									+ btrid
																									+ "' value='"
																									+ $('#storageLocationIdEdit :selected').text()
																									+ "' class='textbox' readonly/></spring:bind> </td>"
																									
																										
																										+"<td><a href='#'  onclick='editGoodsIssueInAddEdit("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeGoodsIssueInAddEdit("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid++;
																			//	$('#goodsIssueValue').val(parseFloat($('#goodsIssueValue').val())+parseFloat($('#lineAmtChild').val()));
																				$(
																						this)
																						.dialog(
																								"close");
																				
																			}
																			if (hiddenID
																					.val() != "0") {
																				 
																				    
																				    
																			  $('#materialIdEdit'+ hiddenID.val()).val(materialId.val());
																			  $('#materialNameEdit'+ hiddenID.val()).val($('#materialIdEdit :selected').text());
																			  $('#batchNoEdit'+hiddenID.val()).val(batchNo.val()); 
																			  $('#qtyEdit'+hiddenID.val()).val(qty.val());
																			  $('#uOMIdEdit'+ hiddenID.val()).val(uOMId.val());
																			  $('#uOMNameEdit'+ hiddenID.val()).val($('#uOMIdEdit :selected').text());
																			  $('#plantIdEdit'+ hiddenID.val()).val(plantId.val());
																			  $('#plantNameEdit'+ hiddenID.val()).val($('#plantIdEdit :selected').text());
																			  $('#storageLocationIdEdit'+ hiddenID.val()).val(storageLocationId.val());
																			  $('#storageLocationNameEdit'+ hiddenID.val()).val($('#storageLocationIdEdit :selected').text());
																			    

																			  $('#hiddenIdGoodsIssuePopUpEdit').val("0");
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

										

											$("#create-AddGoodsIssueEdit")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-goodsIssueEdit")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeGoodsIssueInAddEdit(id) {
											//alert("removing row " + id);
		                                	$('#' + id).remove();
										}
										function editGoodsIssueInAddEdit(id) {
											//alert("edit row " + id);
											$("#dialog-form-goodsIssueEdit").dialog("open");
											$('#materialIdEdit').val($('#materialIdEdit' + id).val());
											$('#batchNoEdit').val($('#batchNoEdit' + id).val());
											$('#qtyEdit').val($('#qtyEdit' + id).val());
											$('#uOMIdEdit').val($('#uOMIdEdit' + id).val());
											$('#plantIdEdit').val($('#plantIdEdit' + id).val());
											$('#storageLocationIdEdit').val($('#storageLocationIdEdit' + id).val());
											$('#hiddenIdGoodsIssuePopUpEdit').val(id);
											getAvailablityEdit();
											}
										function getAvailablityEdit()
										{
											  
											 
										     var materialId = $('#materialIdEdit').val();
											 var batchNo = $('#batchNoEdit').val();
											 var storageLocationId = $('#storageLocationIdEdit').val();
											 $("#availableQtyEdit").val('');
											if(materialId!="0" && batchNo!="0" &&  storageLocationId!="0"){
											$.ajax({
												type : "POST",
												url : "forAvailability.mnt",
												data : "materialId=" + materialId+ "&batchNo="+batchNo+"&storageLocationId="+storageLocationId,
												success : function(data) {
													//alert("asa"+data);
													$("#availableQtyEdit").val(data);
												},
												error : function(e) {
													alert('Error: ' + e);
												}

											});
										}
											
										}
										function disabledInspInEdit(
												id) {
											//alert(link.id);
											alert("Deleting Particular Row Will Deleted Once You Click Update Button");
											document
													.getElementById("CheckGoodsIssue"+id).value = "1";
											document.getElementById(id).style.display = "none";
										}
										
										

										function callForProductionE(val)
										 {
											
											var producionOrderIdEdit=$('#producionOrderIdEdit').val();
											if(producionOrderIdEdit!="0")
												{
												$('#deliveryNoteIdEdit').val("0");
												}
										 }


										function callForDeliveryNoteE(val)
										 {
											
											var deliveryNoteId=$('#deliveryNoteIdEdit').val();
											if(deliveryNoteId!="0")
												{
												$('#producionOrderIdEdit').val("0");
												}
											
										 }


										
									</script>



										<div id="dialog-form-goodsIssueEdit"
											title="Add Goods Issue Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

												<tr>
													<td><spring:message code="label.gimaterial" /><span
														class="required">*</span></td>
													<td><form:select path="materialIdSelect"
															id="materialIdEdit" class="select"
															onchange="getAvailablityEdit()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select> <input type="hidden" name="hiddenIdGoodsIssuePopUp"
														id="hiddenIdGoodsIssuePopUpEdit" value="0" /></td>


												</tr>


												<tr>
													<td><spring:message code="label.giuom" /><span
														class="required">*</span></td>
													<td><form:select path="uOMIdSelect" id="uOMIdEdit"
															class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>


												</tr>

												<tr>
													<td><spring:message code="label.gibno" /><span
														class="required">*</span></td>
													<td><form:select path="batchNoSelect" id="batchNoEdit"
															class="select" onchange="getAvailablityEdit()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${batchNo}" />
														</form:select></td>


												</tr>

												<tr>
													<td><spring:message code="label.giplant" /><span
														class="required">*</span></td>
													<td><form:select path="plantIdSelect" id="plantIdEdit"
															class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${SelectPlant}" />
														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.gistrloc" /><span
														class="required">*</span></td>
													<td><form:select path="storageLocationIdSelect"
															id="storageLocationIdEdit" class="select"
															onchange="getAvailablityEdit()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${SelectStorageLocation}" />
														</form:select></td>



												</tr>
												<tr>
													<td><spring:message code="label.giavlqty" /></td>
													<td><input name="availableQtyEdit"
														id="availableQtyEdit" class="textbox" readonly="readonly" />
													</td>


												</tr>


												<tr>
													<td><spring:message code="label.giqty" /><span
														class="required">*</span></td>
													<td><form:input path="qty" id="qtyEdit"
															class="textbox" onkeyup="getAvailablityEdit()" /></td>


												</tr>

											</table>
										</div>


										<div id="scroll1" align="center">
											<div id="users-contain-goodsIssueEdit">


												<table id="goodsIssueLineAddEdit" class="table">

													<tr id="goodsIssueAddHeadEdit">

														<th><spring:message code="label.gimaterial" /></th>
														<th><spring:message code="label.giqty" /></th>
														<th><spring:message code="label.giuom" /></th>
														<th><spring:message code="label.gibno" /></th>
														<th><spring:message code="label.giplant" /></th>
														<th><spring:message code="label.gistrloc" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>
													</tr>


													<c:forEach var="goodsIssueLineEditList"
														items="${goodsIssueLineEditList}">

														<tr id="${goodsIssueLineEditList.goodsIssueLineId}">

															<td><spring:bind
																	path="goodsIssueCommand.goodsIssueLineId">
																	<input type="hidden" name="goodsIssueLineId"
																		value="${goodsIssueLineEditList.goodsIssueLineId}"
																		class="textbox" readonly="readonly" />
																</spring:bind> <spring:bind path="goodsIssueCommand.materialId">
																	<input type="hidden" name="materialId"
																		id="materialIdEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.materialId}"
																		class="textbox" readonly="readonly" />
																</spring:bind> <spring:bind path="goodsIssueCommand.materialName">
																	<input type="text" name="materialName"
																		id="materialNameEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.materialName}"
																		class="textbox" readonly="readonly" />
																</spring:bind></td>

															<td><spring:bind path="goodsIssueCommand.qty">
																	<input type="text" name="qty"
																		id="qtyEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.qty}" class="textbox"
																		readonly="readonly" />
																</spring:bind> <spring:bind path="goodsIssueCommand.qtyAcc">
																	<input type="hidden" name="qtyAcc"
																		id="qtyAccEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.qty}" class="textbox"
																		readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind path="goodsIssueCommand.uOMId">
																	<input type="hidden" name="uOMId"
																		id="uOMIdEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.uOMId}"
																		class="textbox" readonly="readonly" />
																</spring:bind> <spring:bind path="goodsIssueCommand.uOMName">
																	<input type="text" name="uOMName"
																		id="uOMNameEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.uOMName}"
																		class="textbox" readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind path="goodsIssueCommand.batchNo">
																	<input type="text" name="batchNo"
																		id="batchNoEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.batchNo}"
																		class="textbox" readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind path="goodsIssueCommand.plantId">
																	<input type="hidden" name="plantId"
																		id="plantIdEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.plantId}"
																		class="textbox" readonly="readonly" />
																</spring:bind> <spring:bind path="goodsIssueCommand.plantName">
																	<input type="text" name="plantName"
																		id="plantNameEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.plantName}"
																		class="textbox" readonly="readonly" />
																</spring:bind></td>
															<td><spring:bind
																	path="goodsIssueCommand.storageLocationId">
																	<input type="hidden" name="storageLocationId"
																		id="storageLocationIdEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.storageLocationId}"
																		class="textbox" readonly="readonly" />
																</spring:bind> <spring:bind
																	path="goodsIssueCommand.storageLocationName">
																	<input type="text" name="storageLocationName"
																		id="storageLocationNameEdit${goodsIssueLineEditList.goodsIssueLineId}"
																		value="${goodsIssueLineEditList.storageLocationName}"
																		class="textbox" readonly="readonly" />
																</spring:bind><input type="hidden"
																name="CheckGoodsIssue${goodsIssueLineEditList.goodsIssueLineId}"
																id="CheckGoodsIssue${goodsIssueLineEditList.goodsIssueLineId}"
																value="0" /></td>

															<td><a href="#"
																style="float: left; margin: 0px 0 0 5px;" class="remove"><strong><img
																		src="images/Edit.jpg" height="20px" width="20px"
																		onclick="editGoodsIssueInAddEdit(${goodsIssueLineEditList.goodsIssueLineId})" /></strong></a></td>
															<td><a href="#" class="remove"
																style="float: left; margin: 0px 0 0 5px;"
																onclick="disabledInspInEdit(${goodsIssueLineEditList.goodsIssueLineId})"><strong><img
																		src="images/button_cancel.png" height="20px"
																		width="20px" /></strong></a></td>
														</tr>

													</c:forEach>
												</table>

												<table>

													<tbody>
													</tbody>
												</table>

											</div>

											<div id="extender"></div>
											<button id="create-AddGoodsIssueEdit" type="button">
												<spring:message code="label.addgi" />
											</button>
										</div>

									</div>
								</div>

							</div>

							<c:choose>

								<c:when test="${update}">

									<input type="submit"
										value="<spring:message code="label.update"/> "
										class="btn btn-primary" id="update" />
								</c:when>

								<c:otherwise>

									<input type="submit"
										value="<spring:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="update" />
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