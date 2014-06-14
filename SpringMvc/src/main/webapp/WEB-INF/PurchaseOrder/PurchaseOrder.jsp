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

	$("#dueDate,#addrowdueDate,#purchaseOrderDate,#dueDateChild,#dueDateChildEdit,#purchaseOrderDateEdit,#dueDateEdit").datepicker({
		dateFormat : datePattern,
		changeMonth : true,
		changeYear : true
	});

}


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


$( document ).ready(function() {
	 
	$('#vendorId').change(function() {
		var a=$(this).val();
		if(a!=''){
			$('#quotationID').prop('disabled',true);
		}else{
			$('#quotationID').prop('disabled',false);
		}
			
	});
	

$('#quotationID').change(function() {	
	var msg;
	var res = $(this).val();
	if (res != 0) {
		msg = confirm("Do U Want Add Quotation Line Details?");
	} else {
		msg = confirm("Do U Want Remove Quotation LineDetails?");
	}
    if (msg==true) { 
      if(res!=0){
    	  $('#vendorId').prop('disabled', true);
      }else{
    	  $('#vendorId').prop('disabled', false);
      }
  	$.ajax({
        type: "POST",
        url : "purchaseOrderDetailsJson.mnt",
        data : "quotationId="+$(this).val(), 
        success: function(data) {
        		
        	$('#extender').empty();
        	 $("#purchaseOrderValue").val(0);
            var raw=JSON.parse(data);
        	$.each(raw, function(idx, item) {
       		$('#extender').show();	
			  $("#purchaseOrderValue").val(item.total);
		  	 forAddRow(item.count);
			 $("#externalId").hide();
			// $("#lineNumberChild"+item.count).val(item.quotationLineId);
			 $("#materialIdChild"+item.count).val(item.material_Id);
			 $("#materialNameChild"+item.count).val(item.materialName);
			 $("#quantityChild"+item.count).val(item.quantity);
			 $("#unitPriceChild"+item.count).val(item.perUnit);
			 $("#lineAmtChild"+item.count).val(item.lineAmount);
			 $("#uomChild"+item.count).val(item.uom);
			 $("#uomNameChild"+item.count).val(item.uomName);
			 $("#currencyCodeChild"+item.count).val(item.currencyId);
			 $("#currencyNameChild"+item.count).val(item.currencyName);
			
          });
       				    
           }
       });
	
		}
	
		});
		
$('#quotationIDEdit').change(function() {	
	//alert($(this).val());
	var box = confirm("Are you sure you want to Copy Quotation Line?");
    if (box==true)
       { 
    	//alert("dd");
    	$('#quotationIDEditH').val($(this).val());
	$.ajax({
        type: "POST",
        url : "purchaseOrderDetailsJson.mnt",
        data : "quotationId="+$(this).val(), 
        success: function(data) {
        	//alert("data  "+data);
        	//extender
        	$('#extenderEdit').empty();
        
            var raw=JSON.parse(data);
            //var countaa=1;
       			$.each(raw, function(idx, item) {
       			$('#extenderEdit').show();	
			
			$("#vendorIdEdit").val(item.vendorIdForJson);
			
			forEditRow(item.count);
			$("#externalIdEdit").hide();
			 $("#materialIdChildEdit"+item.count).val(item.material_Id);
			 $("#materialNameChildEdit"+item.count).val(item.materialName);
			 $("#quantityChildEdit"+item.count).val(item.quantity);
			 $("#unitPriceChildEdit"+item.count).val(item.perUnit);
			 $("#lineAmtChildEdit"+item.count).val(item.lineAmount);
			 $("#uomChildEdit"+item.count).val(item.uom);
			 $("#uomNameChildEdit"+item.count).val(item.uomName);
			 $("#currencyCodeChildEdit"+item.count).val(item.currencyId);
			 $("#currencyNameChildEdit"+item.count).val(item.currencyName);
			  $("#purchaseOrderValueEdit").val(parseFloat($("#purchaseOrderValueEdit").val())+parseFloat(item.totalEdit));
			// countaa++;
          });
       	
           }
   		
       });
	
       }
		});
		
	});

function doAjaxPost() {
	  
	var purchaseOrderNo = $('#purchaseOrderNoId').val();
	//alert("sdf"+purchaseOrderNo);
		$.ajax({
			type : "POST",
			url : "purchaseOrderNoCheck.mnt",
			data : "purchaseOrderNo=" + purchaseOrderNo,
			success : function(data) {
			//	alert("asd"+data);
				var checkResponse="Warning ! Purchase order no aleardy exists. Please try some other no";
				if(checkResponse==data)
				{
				document.getElementById("purchaseDuplicateMess").style.display="block";
				//$('#purchaseDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("purchaseDuplicateMess").style.display="none";
				$('#save').show();
				}
			},
			error : function(e) {
				//alert('Error: ' + e);
			}

		});
	}
function doAjaxPostEdit() {
	  
	var purchaseOrderNoEdit = $('#purchaseOrderNoEdit').val();
	var purchaseOrderIdEdit = $('#purchaseOrderIdEdit').val();
	//alert(purchaseOrderNoEdit +" "+purchaseOrderIdEdit);
		$.ajax({
			type : "POST",
			url : "purchaseOrderNoCheckEdit.mnt",
			data : "purchaseOrderNoEdit=" + purchaseOrderNoEdit+ "&purchaseOrderIdEdit=" + purchaseOrderIdEdit,
			success : function(data) {
				var checkResponse="Warning ! Purchase order no aleardy exists. Please try some other no";
				if(checkResponse==data)
				{
				document.getElementById("purchaseDuplicateMessEdit").style.display="block";
				//$('#purchaseDuplicateMessEdit').html(data);
				$('#update').hide();
				}
				else
				{
				document.getElementById("purchaseDuplicateMessEdit").style.display="none";
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
	
	 	$('#purchaseAdd').validate({
			rules : {
				purchaseGroupId:{required:true},
				purchaseOrderNo:{required:true,alphanumeric : true,
					specialcharacters : true},
					purchaseOrderDate : {required : true},
					//purchaseOrderValue : {required : true},
					purchaseOrderStatus : {required : true},
					description : {required : true},
					//vendorId : {required : true,number:true},
					//quotationId : {required : true},
					paymentTerms : {required : true},
				
					memo:{required: true},
					currencyCode:{required:true},
					salesTaxAmt:{required:true},
					vatAmt : {required : true},
					exciseAmt: {required : true},
					frieghtCharges: {required : true},
					pnFCharges: {required : true},
					dueDate: {required : true},
				
				
			},
			messages : {
				purchaseOrderNo : {
					required:"<font style='color: red;'><b>Purchase Order No is Required</b></font>",
					alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
					specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
				},
				purchaseGroupId: "<font style='color: red;'><b>Purchase Group  is Required</b></font>",
				purchaseOrderDate : "<font style='color: red;'><b>Purchase Order Date is Required</b></font>",
				//purchaseOrderValue : "<font style='color: red;'><b>Purchase Order Value is Required</b></font>",
				purchaseOrderStatus : "<font style='color: red;'><b>Purchase Order Status is Required</b></font>",
				description : "<font style='color: red;'><b>Description is Required</b></font>",
				//vendorId : "<font style='color: red;'><b>Vendor  is Required</b></font>",
				//quotationId : "<font style='color: red;'><b>Quotation is Required</b></font>",
				paymentTerms: "<font style='color: red;'><b>Payment Terms is Required</b></font>",
				memo: "<font style='color: red;'><b>Memo is Required</b></font>",
				currencyCode : "<font style='color: red;'><b>Currency Code is Required</b></font>",
				salesTaxAmt : "<font style='color: red;'><b>Sales Tax Amt is Required</b></font>",
				vatAmt : "<font style='color: red;'><b>Vat Amount is Required</b></font>",
				exciseAmt: "<font style='color: red;'><b>Excise Amount is Required</b></font>",
				frieghtCharges : "<font style='color: red;'><b>Frieght Charges is Required</b></font>",
				pnFCharges:"<font style='color: red;'><b>PNF Charges is Required</b></font>",
				dueDate:"<font style='color: red;'><b>Due Date is Required</b></font>",
				
			},
			
		}); 
	 	
		if($('#purchaseOrderNo').val()!="" && $('#pnFCharges').val()!="" && $('#dueDate').val()!=""){
			if($('#checkChildData').val()==0)
			{
			alert("Please Enter AtLeast One Purchase Order Line");
			document.getElementById("addmessage").style.display = "block";
			$('#addmessage').html("Warning! Please Enter AtLeast One Purchase Order Line");
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
	$('#update').click(function(event) {
		
		//alert("ss");
	 	$('#purchaseEdit').validate({
			rules : {
				purchaseGroupIdEdit:{required:true},
				purchaseOrderNoEdit:{required:true,alphanumeric : true,
					specialcharacters : true},
				purchaseOrderDateEdit : {required : true},
				//purchaseOrderValueEdit : {required : true},
				purchaseOrderStatusEdit : {required : true},
				descriptionEdit : {required : true},
				//vendorIdEdit : {required : true,number:true},
				//quotationIdEdit : {required : true},
				paymentTermsEdit : {required : true},
			
				memoEdit:{required: true},
				currencyCodeEdit:{required:true},
				salesTaxAmtEdit:{required:true},
				vatAmtEdit : {required : true},
				exciseAmtEdit: {required : true},
				frieghtChargesEdit: {required : true},
				pnFChargesEdit: {required : true},
				dueDateEdit: {required : true},
				
			},
			messages : {
				
				purchaseGroupIdEdit: "<font style='color: red;'><b>Purchase Group  is Required</b></font>",
				purchaseOrderNoEdit : {
					required:"<font style='color: red;'><b>Purchase Order No is Required</b></font>",
					alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
					specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
				},
				purchaseOrderDateEdit : "<font style='color: red;'><b>Purchase Order Date is Required</b></font>",
				//purchaseOrderValueEdit : "<font style='color: red;'><b>Purchase Order Value is Required</b></font>",
				purchaseOrderStatusEdit : "<font style='color: red;'><b>Purchase Order Status is Required</b></font>",
				descriptionEdit : "<font style='color: red;'><b>Description is Required</b></font>",
				//vendorIdEdit : "<font style='color: red;'><b>Vendor  is Required</b></font>",
				//quotationIdEdit : "<font style='color: red;'><b>Quotation is Required</b></font>",
				paymentTermsEdit: "<font style='color: red;'><b>Payment Terms is Required</b></font>",
				memoEdit: "<font style='color: red;'><b>Memo is Required</b></font>",
				currencyCodeEdit : "<font style='color: red;'><b>Currency Code is Required</b></font>",
				salesTaxAmtEdit : "<font style='color: red;'><b>Sales Tax Amt is Required</b></font>",
				vatAmtEdit : "<font style='color: red;'><b>Vat Amount is Required</b></font>",
				exciseAmtEdit: "<font style='color: red;'><b>Excise Amount is Required</b></font>",
				frieghtChargesEdit : "<font style='color: red;'><b>Frieght Charges is Required</b></font>",
				pnFChargesEdit:"<font style='color: red;'><b>PNF Charges is Required</b></font>",
				dueDateEdit:"<font style='color: red;'><b>Due Date is Required</b></font>",
				
			},
			

		}); 
		
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
		if (document.getElementById("purchaseAddDuplicate").value == 1) {
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
	width: 80%;
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
<script type="text/javascript">
$(document).ready(function() {
	$('#bsId').focus();
$('#add,#search').click(function(e) {
	$('#bsId').focus();
	$("#purchaseOrderNoId").focus();
	$('#bsId').focus();
	$('#edit').hide();
	$('#tabs-1').hide();
	$('#successmessage').hide();
	$('#savemessage').hide();

});
});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">
			<spring:message code="label.purchaseOrder" />
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vendorValues" items="${purchaseOrderEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add" class="addclass"><spring:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<table class="tableGeneral">

						<form:form action="purchaseOrderSearch.mnt" method="GET"
							commandName="purchaseOrderCommand">

							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.purchaseOrder" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.purchaseOrder" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${purchaseOrderUpdate}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.purchaseOrder" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${purchaseOrderUpdateError}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.purchaseOrder" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${poDelete}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.purchaseOrder" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${poDeleteError}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.purchaseOrder" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /> <form:select
										path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="purchaseOrderCommand.operations">
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
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" id="bsId" /></td>
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
										<c:when test="${privileges eq messageup }">
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
						<form:form action="purchaseAdvanceSearch.mnt" method="GET"
							commandName="purchaseOrderCommand" name="advanceSearchFinal">
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
					<form:form action="purchaseAdvanceSearchOperations.mnt"
						commandName="purchaseOrderCommand" method="GET">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${purchaseSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><spring:bind path="purchaseOrderCommand.operations1">
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
											<c:when test="${search }">
												<input type="submit" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-primary" />
											</c:when>
											<c:otherwise>
												<input type="submit" id="advanceSearchButtonId"
													disabled="disabled" value="Advance Search"
													style="display: none" class="btn btn-danger" />
											</c:otherwise>
										</c:choose></td>
								</tr>
							</table>

						</div>
					</form:form>

					<c:if test="${purchaseOrderList!=null }">
						<display:table name="purchaseOrderList" id="purcList"
							class="table" requestURI="purchaseOrderSearch.mnt" pagesize="5">

							<%-- <display:column property="customerId" sortable="true"
									title="customerId" media="none" /> --%>
							<display:column property="purchaseOrderNo" sortable="true"
								titleKey="label.poNo" media="html" />

							<display:column property="purchaseOrderDate" sortable="true"
								titleKey="label.purchaseOrderDate" media="html" />


							<display:column property="purchaseOrderValue" sortable="true"
								titleKey="label.poValue" media="html" />
							<display:column property="purchaseOrderStatus" sortable="true"
								titleKey="label.poStatus1" media="html" />

							<display:column property="description" sortable="true"
								titleKey="label.poDes" media="html" />


							<display:column property="paymentTerms" sortable="true"
								titleKey="label.poPT" media="html" />
							<display:column property="memo" sortable="true"
								titleKey="label.memo" media="none" />

							<display:column property="dueDate" sortable="true"
								titleKey="label.dueDate" media="none" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${true }">
										<a
											href="purchaseOrderEdit.mnt?purchaseOrderId=<c:out value="${purcList.purchaseOrderId}"/> "><img
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
											href="purchaseOrderDelete.mnt?purchaseOrderId=<c:out value="${purcList.purchaseOrderId}"/> "
											onclick="return confirm('Do You Want To Delete This Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" width="20px"
											class="btn btn-danger" height="20px" /> </a>

									</c:otherwise>
								</c:choose>
							</display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>
					</c:if>

					<c:forEach var="purchaseOrderListAdvancedValues"
						items="${purchaseOrderListAdvancedValues}">
						<c:set var="purcAdvanced"
							value="${purchaseOrderListAdvancedValues}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${purcAdvanced!=null }">
							<display:table name="purchaseOrderListAdvancedValues"
								id="purcListAdv" class="table"
								requestURI="purchaseAdvanceSearchOperations.mnt" pagesize="5">

								<%-- <display:column property="customerId" sortable="true"
									title="customerId" media="none" /> --%>
								<display:column property="purchaseOrderNo" sortable="true"
									titleKey="label.poNo" media="html" />

								<display:column property="purchaseOrderDate" sortable="true"
									titleKey="label.purchaseOrderDate" media="html" />


								<display:column property="purchaseOrderValue" sortable="true"
									titleKey="label.poValue" media="html" />
								<display:column property="purchaseOrderStatus" sortable="true"
									titleKey="label.poStatus1" media="html" />

								<display:column property="description" sortable="true"
									titleKey="label.poDes" media="html" />


								<display:column property="paymentTerms" sortable="true"
									titleKey="label.poPT" media="html" />
								<display:column property="memo" sortable="true"
									titleKey="label.memo" media="none" />

								<display:column property="dueDate" sortable="true"
									titleKey="label.dueDate" media="none" />

								<display:column titleKey="label.edit">
									<a
										href="purchaseOrderEdit.mnt?purchaseOrderId=<c:out value="${purcListAdv.purchaseOrderId}"/> "><img
										src="images/Edit.jpg" width="20px" height="20px" /></a>
								</display:column>
								<display:column titleKey="label.delete">
									<a
										href="purchaseOrderDelete.mnt?purchaseOrderId=<c:out value="${purcListAdv.purchaseOrderId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" />

							</display:table>
						</c:when>

						<c:otherwise>

							<%-- <h3 style="color:red"><c:out value="No Data Found"></c:out></h3> --%>

						</c:otherwise>
					</c:choose>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
					<tr>
							<td colspan="4" class="alert-warning" id="addmessage"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
						<tr>
							<td colspan="4" id="purchaseDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.purchaseOrder" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
						
					</table>
					<form:form action="PurchaseOrderAdd.mnt" method="POST"
						commandName="purchaseOrderCommand" id="purchaseAdd"
						name="purchaseAdd">
						<table>
							<form:hidden path="purchaseAddDuplicate" />
							<tr>
								<td>Purchase Order No<span class="required">*</span></td>
								<td><form:input path="purchaseOrderNo"
										id="purchaseOrderNoId" class="textbox" onkeyup="doAjaxPost()"
										maxlength="50" /></td>


								<td>Purchase Order Date<span class="required">*</span></td>
								<td><form:input path="purchaseOrderDate"
										id="purchaseOrderDate" class="textbox" /></td>
							</tr>
							<tr>

								<td>Purchase Group<span class="required">*</span></td>
								<td><form:select path="purchaseGroupId"
										id="purchaseGroupId" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${purchaseGroup}" />
									</form:select></td>

								<td>Purchase Order Status<span class="required">*</span></td>
								<td><form:select path="purchaseOrderStatus"
										id="purchaseOrderStatus" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${status }" />
									</form:select></td>

							</tr>
							<tr>
								<td>Description<span class="required">*</span></td>
								<td><form:textarea path="description" id="description"
										class="textbox" maxlength="250" /></td>
								<td>Memo<span class="required">*</span></td>
								<td><form:textarea path="memo" id="memo" class="textbox" maxlength="250" /></td>

							</tr>
							<tr>
								<td>Purchase Order Value<span class="required"></span></td>
								<td><form:input path="purchaseOrderValue"
										id="purchaseOrderValue" class="textbox" readonly="true" value="0"/></td>
								<td>Payment Terms<span class="required">*</span></td>
								<td><form:select path="paymentTerms" id="paymentTerms"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${paymentTerm }" />
									</form:select></td>

							</tr>
							<tr>
								<td>Quotation<span class="required"></span></td>
								<td>
									<!-- <input type="hidden" name="quotationIdD"
									id="quotationIdHidden" value="" />  --> <form:select
										path="quotationId" id="quotationID" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${quotation }" />
									</form:select>
								</td>
								<td>Currency Code<span class="required">*</span></td>
								<td><form:select path="currencyCode" id="currencyCode"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${ccode }" />
									</form:select></td>

							</tr>
							<tr>
								<td>Vendor<span class="required"></span></td>
								<td><form:select path="vendorId" id="vendorId"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${vendor }" />
									</form:select> <!-- <input type="hidden" name="vendorId" id="vendorIdHidden" value="0" /> -->

								</td>
								<td>Vat Amount<span class="required">*</span></td>
								<td><form:input path="vatAmt" id="vatAmt" class="textbox"
										onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>

							</tr>
							<tr>
								<td>Sales Tax Amount<span class="required">*</span></td>
								<td><form:input path="salesTaxAmt" id="salesTaxAmt"
										class="textbox" onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>
								<td>Frieght Charges<span class="required">*</span></td>
								<td><form:input path="frieghtCharges" id="frieghtCharges"
										class="textbox" onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>

							</tr>
							<tr>
								<td>Excise Amount<span class="required">*</span></td>
								<td><form:input path="exciseAmt" id="exciseAmt"
										class="textbox" onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>
								<td>Due Date<span class="required">*</span></td>
								<td><form:input path="dueDate" id="dueDate" class="textbox" /></td>

							</tr>
							<tr>
								<td>PNF Charges<span class="required">*</span></td>
								<td><form:input path="pnFCharges" id="pnFCharges"
										class="textbox" onKeyPress="return numbersonly(this, event)" maxlength="12"/>
										<input type="hidden" name="checkChildData"
											id="checkChildData" class="textbox" value="0"/>
										</td>
							</tr>

						</table>

						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11">Purchase Order Line</a></li>

							</ul>
							<div id="tabs-11" align="center">

								<div align="left">

									<script>
										var btrid = 200;
										$(function() {  

											var  materialIdChildS = $("#materialIdChildL"), quantityChildS = $("#quantityChild"),
											unitPriceChildS = $("#unitPriceChild"), lineAmtChildS = $("#lineAmtChild"), uomChildS = $("#uomChildL"),
											currencyCodeChildS = $("#currencyCodeChildL1"), /* salesTaxAmtChildS = $("#salesTaxAmtChild"), vatTaxAmtChildS = $("#vatTaxAmtChild"),
											exciseAmtChildS = $("#exciseAmtChild"), frieghtChargesChildS = $("#frieghtChargesChild"), pnfChargesChildS = $("#pnfChargesChild"), */ 
											dueDateChildS = $("#dueDateChild"),hiddenID = $("#hiddenIdPurchasePopUp"),
											
											allFields = $([])
											.add(materialIdChildS)
											.add(quantityChildS)
											.add(unitPriceChildS)
											.add(lineAmtChildS)
											.add(uomChildS).add(currencyCodeChildS).add(dueDateChildS)
											.add(hiddenID),
											 tips = $(".validateTips");
										//add(salesTaxAmtChildS).add(vatTaxAmtChildS).add(exciseAmtChildS).add(frieghtChargesChildS).add(pnfChargesChildS).
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
													updateTips(n +"is Required ");
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

											$("#dialog-form-Purchase")
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

																		bValid = bValid && checkLength1(materialIdChildS ,"Material Name");
																		bValid = bValid && checkRegexp(quantityChildS,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Quantity may consist of 0-9.");
																		bValid = bValid && checkLength1(uomChildS,"Uom");
																		bValid = bValid && checkRegexp(unitPriceChildS,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Unit Price may consist of 0-9.");
																		bValid = bValid && checkRegexp(lineAmtChildS,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Line Amount may consist of 0-9.");
																		bValid = bValid && checkLength1(currencyCodeChildS,"Currency Name");
																		bValid = bValid && checkLength2(dueDateChildS,"Due Date");
																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {																												  						
																		      
																				$(
																						"#PurchaseAdd tbody")   
																						.append(
																								"<tr id="+btrid+">"      
																								
																										+ "<td><spring:bind path='purchaseOrderCommand.materialIdChild'><input type='hidden' name='materialIdChild' id='materialIdChild"
																										+ btrid
																										+ "' value="
																										+ materialIdChildS
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='purchaseOrderCommand.materialNameChild'><input type='text' name='materialNameChild' id='materialNameChild"
																										+ btrid
																										+ "' value='"
																										+ $('#materialIdChildL :selected').text()
																										+ "' class='textbox' readonly/></spring:bind> </td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.quantityChild'><input name='quantityChild' id='quantityChild"
																										+ btrid
																										+ "' value="
																										+ quantityChildS
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.unitPriceChild'><input name='unitPriceChild' id='unitPriceChild"
																										+ btrid
																										+ "' value="
																										+ unitPriceChildS
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.lineAmtChild'><input name='lineAmtChild' id='lineAmtChild"
																										+ btrid
																										+ "' value="
																										+ lineAmtChildS
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.uomChild'><input type='hidden' name='uomChild' id='uomChild"
																										+ btrid
																										+ "' value="
																										+ uomChildS
																												.val()
																										+ " class='textbox'/></spring:bind><spring:bind path='purchaseOrderCommand.uomNameChild'><input name='uomNameChild' id='uomNameChild"
																										+ btrid
																										+ "' value='" 
																										+$('#uomChildL :selected').text()
																										+ "' class='textbox'/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.currencyCodeChild'><input type='hidden' name='currencyCodeChild' id='currencyCodeChild"
																										+ btrid
																										+ "' value="
																										+ currencyCodeChildS
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='purchaseOrderCommand.currencyCodeNameChild'><input name='currencyCodeNameChild' id='currencyCodeNameChild"
																										+ btrid
																										+ "' value='"
																										+$('#currencyCodeChildL1 :selected').text()
																										+ "' class='textbox' readonly/></spring:bind></td>"
																								        + "<td><spring:bind path='purchaseOrderCommand.dueDateChild'><input name='dueDateChild' id='dueDateChild"
																										+ btrid
																										+ "' value="
																										+ dueDateChildS
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										
																										
																										+"<td><a href='#'  onclick='editPurchaseInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removePurchaseInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				$('#checkChildData').val(btrid);
																				
																				btrid++;
																			
																				$('#purchaseOrderValue').val(parseFloat($('#purchaseOrderValue').val())+parseFloat($('#lineAmtChild').val()));
																			
																					
																				
																				$(
																						this)
																						.dialog(
																								"close");
																				
																			}
																			if (hiddenID
																					.val() != "0") {
																				
																				//$('#lineNumberChild'+ hiddenID.val()).val(lineNumberChildS.val());
																				
																				  
																				$('#materialIdChild'+ hiddenID.val()).val(materialIdChildS.val());
																				
																				$('#materialNameChild'+ hiddenID.val()).val($('#materialIdChildL :selected').text());
																				$('#quantityChild'+ hiddenID.val()).val(quantityChildS.val());
																				$('#unitPriceChild'+ hiddenID.val()).val(unitPriceChildS.val());
																				$('#lineAmtChild'+ hiddenID.val()).val(lineAmtChildS.val());
																				
																				$('#uomChild'+ hiddenID.val()).val(uomChildS.val());
																				$('#uomNameChild'+ hiddenID.val()).val($('#uomChildL :selected').text());
																				$('#currencyCodeChild'+ hiddenID.val()).val(currencyCodeChildS.val());
																				
																				$('#currencyCodeNameChild'+ hiddenID.val()).val($('#currencyCodeChildL1 :selected').text());
																				$('#dueDateChild'+ hiddenID.val()).val(dueDateChildS.val());
																				
																				var a=parseFloat($('#lineAmtChildValueAdd').val());
																				var b=parseFloat(lineAmtChildS.val());
																				//$('#purchaseOrderValue').val(parseFloat($('#purchaseOrderValue').val())+parseFloat($('#lineAmtChild').val()));
																				if(a-b>0)
																					{
																					$('#purchaseOrderValue').val(parseFloat($('#purchaseOrderValue').val())-(a-b));
																					}
																				if(a-b<0)
																					{
																					$('#purchaseOrderValue').val(parseFloat($('#purchaseOrderValue').val())-(a-b));
																					}
																				

																				//salesadd(hiddenID.val());
																				$('#hiddenIdPurchasePopUp').val("0");
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

										

											$("#create-AddPurchase")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-Purchase")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removePurchaseInAdd(id) {
											//alert("removing row " + id);
		                                 $('#purchaseOrderValue').val(parseFloat($('#purchaseOrderValue').val())-parseFloat($('#lineAmtChild'+id).val()));
											$('#' + id).remove();
										}
										function editPurchaseInAdd(id) {
											//alert("edit row " + id);
											$("#dialog-form-Purchase").dialog("open");
											
										//	$('#lineNumberChild').val($('#lineNumberChild' + id).val());
											$('#materialIdChildL').val($('#materialIdChild' + id).val());
											
											$('#quantityChild').val($('#quantityChild' + id).val());

											$('#unitPriceChild').val($('#unitPriceChild' + id).val());
											$('#lineAmtChild').val($('#lineAmtChild' + id).val());
											$('#uomChildL').val($('#uomChild' + id).val());
										

											$('#currencyCodeChildL1').val($('#currencyCodeChild' + id).val());
											$('#lineAmtChildValueAdd').val($('#lineAmtChild' + id).val());
											
											$('#dueDateChild').val($('#dueDateChild' + id).val());
											$('#hiddenIdPurchasePopUp').val(id);
																					}
															
										function sumAdd()
										{
											//alert("ss");  
											$('#lineAmtChild').val(parseFloat($('#quantityChild').val())*parseFloat($('#unitPriceChild').val()));
											
										}
									</script>

									<div id="dialog-form-Purchase"
										title="Add Purchase Line Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">

											<%-- <tr><td>Line Number</td>
												<td><form:input path="lineNumberChild" id="lineNumberChild" class="textbox" /></td>
											</tr> --%>
											<tr>
												<td>Material Name<font color="red">*</font></td>
												<td><form:select path="materialIdChildL"
														id="materialIdChildL" class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${materialSelect}" />
													</form:select></td>

											</tr>


											<tr>
												<td>Quantity<font color="red">*</font></td>
												<td><spring:bind
														path="purchaseOrderCommand.quantityChild">
														<input type="text" name="quantityChild" id="quantityChild"
															class="textbox" onkeyup="sumAdd()" maxlength="23"/>
													</spring:bind></td>
											</tr>

											<tr>
												<td>Uom<font color="red">*</font></td>
												<td><form:select path="uomChildL" id="uomChildL"
														class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${SelectUom}" />
													</form:select></td>
											</tr>
											<tr>
												<td>Unit Price<font color="red">*</font></td>
												<td><form:input path="unitPriceChild"
														id="unitPriceChild" class="textbox" onkeyup="sumAdd()" maxlength="12"/></td>
											</tr>
											<tr>
												<td>Line Amount<font color="red">*</font></td>
												<td><form:input path="lineAmtChild" id="lineAmtChild"
														class="textbox" readonly="true" /></td>
											</tr>
											<tr>
												<td>Currency Name<font color="red">*</font></td>
												<td><form:select path="currencyCodeChildL"
														id="currencyCodeChildL1" class="select">
														<form:option value="0">-Select-</form:option>
														<form:options items="${SelectCurrency}" />
													</form:select></td>
											</tr>
											<tr>
												<td>Due Date<font color="red">*</font></td>
												<td><form:input path="dueDateChild" id="dueDateChild"
														class="textbox" /> 
														<input type="hidden"
													name="hiddenIdPurchasePopUp" id="hiddenIdPurchasePopUp"
													value="0" /> 
													<input type="hidden"
													name="lineAmtChildValueAdd" id="lineAmtChildValueAdd"
													value="0" /></td>
											</tr>


										</table>
									</div>


									<div id="scroll1">
										<div id="users-contain-Purchase" align="center">

											<table id="PurchaseAdd" class="table">
												<tr id="PurchaseAddHead">
													<th>Material Name</th>
													<th>Quantity</th>
													<th>Unit Price</th>
													<th>Line Amount</th>
													<th>Uom</th>
													<th>Currency Name</th>
													<th>Due Date</th>
													<th>Edit</th>
													<th>Remove</th>
												</tr>
											</table>
											<script type="text/javascript">
														function forAddRow(id)
														{
															//alert("came "+id)
															var options = ''
																
																+'<table class="table"><tr id='+id+'>'
																 
																 +'<td><spring:bind path="purchaseOrderCommand.materialIdChild"><input type="hidden" name="materialIdChild" id="materialIdChild'+id+'"  class="textbox" readonly/></spring:bind>'
																 +'<spring:bind path="purchaseOrderCommand.materialNameChild"><input type="text" name="materialNameChild" id="materialNameChild'+id+'"  class="textbox" readonly/></spring:bind> </td>'
																 +'<td><spring:bind path="purchaseOrderCommand.quantityChild"><input name="quantityChild" id="quantityChild'+id+'"  class="textbox" readonly /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.unitPriceChild"><input name="unitPriceChild" id="unitPriceChild'+id+'" class="textbox" readonly /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.lineAmtChild"><input name="lineAmtChild" id="lineAmtChild'+id+'" class="textbox" readonly/></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.uomChild"><input type="hidden" name="uomChild" id="uomChild'+id+'" class="textbox" readonly /></spring:bind>'
																 +'<spring:bind path="purchaseOrderCommand.uomNameChild"><input type="text" name="uomName" id="uomNameChild'+id+'" class="textbox" readonly /></spring:bind> </td>'
																 +'<td><spring:bind path="purchaseOrderCommand.currencyCodeChild"><input type="hidden" name="currencyCodeChild" id="currencyCodeChild'+id+'" class="textbox" readonly /></spring:bind> '
																 +'<spring:bind path="purchaseOrderCommand.currencyNameChild"><input type="text" name="currencyNameChild" id="currencyNameChild'+id+'" class="textbox" readonly /></spring:bind> </td>'
																 +'	<td><spring:bind path="purchaseOrderCommand.dueDateChild"><input type="text" name="dueDateChild" id="dueDateChild'+id+'" class="textbox" readonly /></spring:bind></td>'
																 +'</td>'
																 +'<td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/Edit.jpg" height="25px" width="25px" onclick="editPurchaseInAdd('+ id+ ')" /></strong></a></td><td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove" onclick="removePurchaseInAdd('+ id+ ')" ><strong><img src="images/button_cancel.png"   height="25px" width="25px" /></strong></a></td></tr></table>';
																
																					//$(options).fadeIn("slow").appendTo($("#PurchaseAdd tbody"));
															$(options).fadeIn("slow").appendTo('#extender');
														}
															
															</script>
											<table>

												<tbody>
												</tbody>
											</table>


											<div id="extender"></div>
											<button id="create-AddPurchase" type="button">Add
												Purchase Line</button>

										</div>

									</div>


								</div>

							</div>

						</div>
						<c:choose>
							<c:when test="${true }">
								<input type="submit" value="Save" name="Save" id="save"
									class="btn btn-primary" />
								<input type="reset" class="btn btn-primary" />
							</c:when>
							<c:otherwise>
								<input type="submit" value="Save" name="Save"
									disabled="disabled" id="save" class="btn btn-danger" />
								<input type="reset" class="btn btn-primary" />
							</c:otherwise>
						</c:choose>
					</form:form>
				</div>

			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>

							<td colspan="4" id="purchaseDuplicateMessEdit"
								style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.purchaseOrder" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>

						</tr>
					</table>

					<form:form action="PurchaseOrderUpdate.mnt" method="POST"
						commandName="purchaseOrderCommand" id="purchaseEdit"
						name="purchaseEdit">
						<c:forEach var="purchaseOrderEditList"
							items="${purchaseOrderEditList}">

							<table>
								<tr>
									<td>Purchase Order No<span class="required">*</span></td>
									<td><form:hidden path="purchaseOrderIdEdit"
											id="purchaseOrderIdEdit" class="textbox" /> <form:input
											path="purchaseOrderNoEdit" id="purchaseOrderNoEdit"
											class="textbox" onkeyup="doAjaxPostEdit()" maxlength="50" /></td>
									<td>Purchase Order Date<span class="required">*</span></td>
									<td><form:input path="purchaseOrderDateEdit"
											id="purchaseOrderDateEdit" class="textbox" /></td>
								</tr>
								<tr>
									<td>Purchase Group<span class="required">*</span></td>
									<td><form:select path="purchaseGroupIdEdit"
											id="purchaseGroupIdEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${purchaseGroup}" />
										</form:select></td>

									<td>Purchase Order Status<span class="required">*</span></td>
									<td><form:select path="purchaseOrderStatusEdit"
											id="purchaseOrderStatusEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${status }" />
										</form:select></td>
								</tr>

								<tr>
									<td>Description<span class="required">*</span></td>
									<td><form:textarea path="descriptionEdit"
											id="descriptionEdit" class="textbox" maxlength="250" /></td>
									<td>Memo<span class="required">*</span></td>
									<td><form:textarea path="memoEdit" id="memoEdit"
											class="textbox" maxlength="250" /></td>
								</tr>

								<tr>
									<td>Purchase Order Value<span class="required"></span></td>
									<td><form:input path="purchaseOrderValueEdit"
											id="purchaseOrderValueEdit" class="textbox" readonly="true" /></td>
									<td>Payment Terms<span class="required">*</span></td>
									<td><form:select path="paymentTermsEdit"
											id="paymentTermsEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${paymentTerm }" />
										</form:select></td>
								</tr>
								<tr>
									<td>Quotation<span class="required"></span></td>
									<td><input type="hidden" name="quotationIdEdit"
										id="quotationIDEditH"
										value="${purchaseOrderEditList.quotationIdEdit}" /> <form:select
											path="quotationIdEdit" id="quotationIDEdit" class="select"
											disabled="true">
											<form:option value="">-Select-</form:option>
											<form:options items="${quotation }" />
										</form:select></td>

									<td>Currency Code<span class="required">*</span></td>
									<td><form:select path="currencyCodeEdit"
											id="currencyCodeEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${ccode }" />
										</form:select></td>

								</tr>
								<tr>
									<td>Vendor<span class="required"></span></td>
									<td><input type="hidden" name="vendorIdEdit"
										id="quotationIDEdit"
										value="${purchaseOrderEditList.vendorIdEdit}" /> <form:select
											path="vendorIdEdit" id="vendorIdEdit" class="select"
											disabled="true">
											<form:option value="">-Select-</form:option>
											<form:options items="${vendor }" />
										</form:select></td>

									<td>Vat Amount<span class="required">*</span></td>
									<td><form:input path="vatAmtEdit" id="vatAmtEdit"
											class="textbox" onKeyPress="return numbersonly(this, event)" maxlength="12"/>
									</td>

								</tr>
								<tr>
									<td>Sales Tax Amount<span class="required">*</span></td>
									<td><form:input path="salesTaxAmtEdit"
											id="salesTaxAmtEdit" class="textbox"
											onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>
									<td>Frieght Charges<span class="required">*</span></td>
									<td><form:input path="frieghtChargesEdit"
											id="frieghtChargesEdit" class="textbox"
											onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>

								</tr>
								<tr>
									<td>Excise Amount<span class="required">*</span></td>
									<td><form:input path="exciseAmtEdit" id="exciseAmtEdit"
											class="textbox" onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>
									<td>Due Date<span class="required">*</span></td>
									<td><form:input path="dueDateEdit" id="dueDateEdit"
											class="textbox" /></td>


								</tr>
								<tr>
									<td>PNF Charges<span class="required">*</span></td>
									<td><form:input path="pnFChargesEdit" id="pnFChargesEdit"
											class="textbox" onKeyPress="return numbersonly(this, event)" maxlength="12"/></td>
								</tr>

							</table>

							<div id="tabs2">

								<ul>
									<li><a href="#tabs-21">Purchase Order Line</a></li>

								</ul>
								<div id="tabs-21">

									<div id="scroll1">
										<table class="table">
											<tr id="externalId">
												<th>Material</th>
												<th>Quantity</th>
												<th>Unit Price</th>
												<th>Line Amount</th>
												<th>Uom</th>
												<th>Currency Code</th>
												<th>Due Date</th>
												<th>Edit</th>
												<th>Remove</th>
											</tr>

											<c:forEach var="purchaseOrderLineEditList"
												items="${purchaseOrderLineEditList }">

												<tr id="${purchaseOrderLineEditList.purchaseOrderLineId}">

													<td><spring:bind
															path="purchaseOrderCommand.purchaseOrderLineIdChild">
															<input type='hidden' name="purchaseOrderLineIdChild"
																id="purchaseOrderLineIdChild"
																value="${purchaseOrderLineEditList.purchaseOrderLineId }" />
														</spring:bind> <spring:bind
															path="purchaseOrderCommand.materialIdChildEdit">
															<input type="hidden" name="materialIdChildEdit"
																id="materialIdChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.materialId }" />
														</spring:bind> <spring:bind path="purchaseOrderCommand.materialNameEdit">
															<input name="materialNameEdit"
																id="materialNameChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList. materialName}"
																readonly="readonly" />
														</spring:bind></td>

													<td><spring:bind
															path="purchaseOrderCommand.quantityChildEdit">
															<input name="quantityChildEdit"
																id="quantityChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.quantity }"
																readonly="readonly" />
														</spring:bind></td>
													<td><spring:bind
															path="purchaseOrderCommand.unitPriceChildEdit">
															<input name="unitPriceChildEdit"
																id="unitPriceChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.unitPrice }"
																readonly="readonly" />
														</spring:bind></td>
													<td><spring:bind
															path="purchaseOrderCommand.lineAmtChildEdit">
															<input name="lineAmtChildEdit"
																id="lineAmtChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.lineAmt }"
																readonly="readonly" />
														</spring:bind></td>
													<td><spring:bind
															path="purchaseOrderCommand.uomChildEdit">
															<input type="hidden" name="uomChildEdit"
																id="uomChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.uom }"
																readonly="readonly" />
														</spring:bind> <spring:bind path="purchaseOrderCommand.uomNameEdit">
															<input name="uomNameEdit"
																id="uomNameChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.uomName }"
																readonly="readonly" />
														</spring:bind></td>
													<td><spring:bind
															path="purchaseOrderCommand.currencyCodeChildEdit">
															<input type="hidden" name="currencyCodeChildEdit"
																id="currencyCodeChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.currencyCode }"
																readonly="readonly" />
														</spring:bind> <spring:bind path="purchaseOrderCommand.currencyNameEdit">
															<input name="currencyNameEdit"
																id="currencyCodeNameChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.currencyName }"
																readonly="readonly" />
														</spring:bind></td>

													<td><spring:bind
															path="purchaseOrderCommand.dueDateChildEdit">
															<input name="dueDateChildEdit"
																id="dueDateChildEdit${purchaseOrderLineEditList.purchaseOrderLineId }"
																class="textbox"
																value="${purchaseOrderLineEditList.dueDate }"
																readonly="readonly" />
														</spring:bind> <input type="hidden"
														name="CheckPurchase${purchaseOrderLineEditList.purchaseOrderLineId}"
														id="CheckPurchase${purchaseOrderLineEditList.purchaseOrderLineId}"
														value="0" /></td>

													<td><a href="#"
														style="float: left; margin: 0px 0 0 5px;" class="remove"><img
															src="images/Edit.jpg" height="25px" width="25px"
															onclick="editPurchaseInEdit(${purchaseOrderLineEditList.purchaseOrderLineId })" /></a></td>
													<td><a href="#" class="remove"
														onclick="disabledPurchaseInEdit(${purchaseOrderLineEditList.purchaseOrderLineId })"><img
															src="images/button_cancel.png" height="25px" width="25px" /></a></td>
												</tr>
											</c:forEach>


										</table>
										<script>
										var btrid1 = 400;
										$(function() {  

											var  materialIdChildSEdit = $("#materialIdChildLEdit"), quantityChildSEdit = $("#quantityChildEdit"),
											unitPriceChildSEdit = $("#unitPriceChildEdit"), lineAmtChildSEdit = $("#lineAmtChildEdit"), uomChildSEdit = $("#uomChildLEdit"),
											currencyCodeChildSEdit = $("#currencyCodeChildL1Edit"), /* salesTaxAmtChildS = $("#salesTaxAmtChild"), vatTaxAmtChildS = $("#vatTaxAmtChild"),
											exciseAmtChildS = $("#exciseAmtChild"), frieghtChargesChildS = $("#frieghtChargesChild"), pnfChargesChildS = $("#pnfChargesChild"), */ 
											dueDateChildSEdit = $("#dueDateChildEdit"),hiddenIDEdit = $("#hiddenIdPurchaseEditPopUp"),
											
											allFields = $([]).add(materialIdChildSEdit)
											.add(quantityChildSEdit)
											.add(unitPriceChildSEdit)
											.add(lineAmtChildSEdit)
											.add(uomChildSEdit).add(currencyCodeChildSEdit).add(dueDateChildSEdit)
											.add(hiddenIDEdit),
											 tips = $(".validateTips");
										//add(salesTaxAmtChildS).add(vatTaxAmtChildS).add(exciseAmtChildS).add(frieghtChargesChildS).add(pnfChargesChildS).
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
													updateTips( n +" is Required ");
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

											$("#dialog-form-PurchaseEdit")
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
																																		
																		//bValid = bValid && checkRegexp(lineNumberChildSEdit,/^[0-9]+$/i,"Line Number may consist of 0-9.");
																		bValid = bValid && checkLength1(materialIdChildSEdit ,"Material Name");
																		bValid = bValid && checkRegexp(quantityChildSEdit,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Quantity may consist of 0-9.");
																		bValid = bValid && checkLength1(uomChildSEdit,"Uom");
																		bValid = bValid && checkRegexp(unitPriceChildSEdit,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Unit Price may consist of 0-9.");
																		
																		bValid = bValid && checkRegexp(lineAmtChildSEdit,/^[0-9]*\.[0-9]+|[0-9]+$/i,"Line Amount may consist of 0-9.");
																		bValid = bValid && checkLength1(currencyCodeChildSEdit,"Currency Name");
																		bValid = bValid && checkLength2(dueDateChildSEdit,"Due Date");
																		
																		

																		if (bValid) {
																		//	alert("hiddenidEdit"+hiddenIDEdit.val());
																			
																			if (hiddenIDEdit.val() == "0"	|| hiddenIDEdit.val() == "") {
																				
																					$("#PurchaseEdit tbody")   
																						.append(
																								"<tr id="+btrid1+">"      
																										+ "<td ><spring:bind path='purchaseOrderCommand.purchaseOrderLineIdChild'><input type='hidden' name='purchaseOrderLineIdChild' id='purchaseOrderLineIdChild' value='0'/></spring:bind><spring:bind path='purchaseOrderCommand.materialIdChildEdit'><input type='hidden' name='materialIdChildEdit' id='materialIdChildEdit"
																										+ btrid1
																										+ "' value="
																										+ materialIdChildSEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='purchaseOrderCommand.materialNameChildEdit'><input type='text' name='materialNameChildEdit' id='materialNameChildEdit"
																										+ btrid1
																										+ "' value='"
																										+ $('#materialIdChildLEdit :selected').text()
																										+ "' class='textbox' readonly/></spring:bind> </td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.quantityChildEdit'><input name='quantityChildEdit' id='quantityChildEdit"
																										+ btrid1
																										+ "' value="
																										+ quantityChildSEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.unitPriceChildEdit'><input name='unitPriceChildEdit' id='unitPriceChildEdit"
																										+ btrid1
																										+ "' value="
																										+ unitPriceChildSEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.lineAmtChildEdit'><input name='lineAmtChildEdit' id='lineAmtChildEdit"
																										+ btrid1
																										+ "' value="
																										+ lineAmtChildSEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.uomChildEdit'><input type='hidden' name='uomChildEdit' id='uomChildEdit"
																										+ btrid1
																										+ "' value="
																										+ uomChildSEdit
																												.val()
																										+ " class='textbox'/></spring:bind><spring:bind path='purchaseOrderCommand.uomNameChildEdit'><input name='uomNameChildEdit' id='uomNameChildEdit"
																										+ btrid1
																										+ "' value='" 
																										+$('#uomChildLEdit :selected').text()
																										+ "' class='textbox'/></spring:bind></td>"
																										+ "<td><spring:bind path='purchaseOrderCommand.currencyCodeChildEdit'><input type='hidden' name='currencyCodeChildEdit' id='currencyCodeChildEdit"
																										+ btrid1
																										+ "' value="
																										+ currencyCodeChildSEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind><input type='hidden' name='CheckPurchase'  id='CheckPurchase"+btrid1+"' value='0'/><spring:bind path='purchaseOrderCommand.currencyCodeNameChildEdit'><input name='currencyCodeNameChildEdit' id='currencyCodeNameChildEdit"
																										+ btrid1
																										+ "' value='"
																										+$('#currencyCodeChildL1Edit :selected').text()
																										+ "' class='textbox' readonly/></spring:bind></td>"
																								        
																								        + "<td><spring:bind path='purchaseOrderCommand.dueDateChildEdit'><input name='dueDateChildEdit' id='dueDateChildEdit"
																										+ btrid1
																										+ "' value="
																										+ dueDateChildSEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										
																										
																										+"<td><a href='#'  onclick='editPurchaseInEdit("
																										+ btrid1
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removePurchaseInEdit("
																										+ btrid1
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid1++;
																				$('#purchaseOrderValueEdit').val(parseFloat($('#purchaseOrderValueEdit').val())+parseFloat($('#lineAmtChildEdit').val()));
																				

																				$(
																						this)
																						.dialog(
																								"close");
																			}
																			else
																			if (hiddenIDEdit
																					.val() != "0") {
																				//alert("came"+$('#hiddenIdPurchaseEditPopUp').val());
																			//	$('#lineNumberChildEdit'+ hiddenIDEdit.val()).val(lineNumberChildSEdit.val());
																				
																				$('#materialIdChildEdit'+ hiddenIDEdit.val()).val(materialIdChildSEdit.val());
																				
																				$('#materialNameChildEdit'+ hiddenIDEdit.val()).val($('#materialIdChildLEdit :selected').text());
																				$('#quantityChildEdit'+ hiddenIDEdit.val()).val(quantityChildSEdit.val());
																				$('#unitPriceChildEdit'+ hiddenIDEdit.val()).val(unitPriceChildSEdit.val());
																				$('#lineAmtChildEdit'+ hiddenIDEdit.val()).val(lineAmtChildSEdit.val());
																				
																				$('#uomChildEdit'+ hiddenIDEdit.val()).val(uomChildSEdit.val());
																				$('#uomNameChildEdit'+ hiddenIDEdit.val()).val($('#uomChildLEdit :selected').text());
																				$('#currencyCodeChildEdit'+ hiddenIDEdit.val()).val(currencyCodeChildSEdit.val());
																				$('#currencyCodeNameChildEdit'+ hiddenIDEdit.val()).val($('#currencyCodeChildL1Edit :selected').text());
																				$('#dueDateChildEdit'+ hiddenIDEdit.val()).val(dueDateChildSEdit.val());
																				$('#hiddenIdPurchaseEditPopUp').val("0");
																				var a=parseFloat($('#lineAmtChildValueEdit').val());
																				var b=parseFloat(lineAmtChildSEdit.val());
																				if(a-b>0)
																				{
																				$('#purchaseOrderValueEdit').val(parseFloat($('#purchaseOrderValueEdit').val())-(a-b));
																				}
																			if(a-b<0)
																				{
																				$('#purchaseOrderValueEdit').val(parseFloat($('#purchaseOrderValueEdit').val())-(a-b));
																				}
																				$(this)	.dialog("close");
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

										

											$("#create-EditPurchase")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-PurchaseEdit")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removePurchaseInEdit(id) {
											
											$('#CheckPurchase'+id).val("1");
											$('#purchaseOrderValueEdit').val(parseFloat($('#purchaseOrderValueEdit').val())-parseFloat($('#lineAmtChildEdit'+id).val()));
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function disabledPurchaseInEdit(
												id) {
											//alert(link.id);
											alert("Deleting Particular Row Will Deleted Once You Click Update Button");
											$('#purchaseOrderValueEdit').val(parseFloat($('#purchaseOrderValueEdit').val())-parseFloat($('#lineAmtChildEdit'+id).val()));
											document
													.getElementById("CheckPurchase"+id).value = "1";
											document
													.getElementById(id).style.display = "none";
										}
										function editPurchaseInEdit(id) {
										//	alert("edit row " + id +" val  "+$('#lineNumberChildEdit' + id).val());
											$("#dialog-form-PurchaseEdit").dialog("open");
											
											//$('#lineNumberChildEdit').val($('#lineNumberChildEdit' + id).val());
											$('#materialIdChildLEdit').val($('#materialIdChildEdit' + id).val());
											
											$('#quantityChildEdit').val($('#quantityChildEdit' + id).val());

											$('#unitPriceChildEdit').val($('#unitPriceChildEdit' + id).val());
											$('#lineAmtChildEdit').val($('#lineAmtChildEdit' + id).val());
											$('#uomChildLEdit').val($('#uomChildEdit' + id).val());
											$('#lineAmtChildValueEdit').val($('#lineAmtChildEdit' + id).val());

											$('#currencyCodeChildL1Edit').val($('#currencyCodeChildEdit' + id).val());
											
										
											$('#dueDateChildEdit').val($('#dueDateChildEdit' + id).val());
											$('#hiddenIdPurchaseEditPopUp').val(id);
																					}
										
										
										
										function sumEdit()
										{
											//alert("ss");  
											$('#lineAmtChildEdit').val(parseFloat($('#quantityChildEdit').val())*parseFloat($('#unitPriceChildEdit').val()));
											
										}
									</script>
										<div id="dialog-form-PurchaseEdit"
											title="Add Purchase Line Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">


												<%-- 	<tr><td>Line Number</td>
												<td><form:input path="lineNumberChildEdit" id="lineNumberChildEdit" class="textbox" /></td>
											</tr> --%>
												<tr>
													<td>Material Name<font color="red">*</font></td>
													<td><form:select path="materialIdChildLEdit"
															id="materialIdChildLEdit" class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${materialSelect}" />
														</form:select></td>

												</tr>


												<tr>
													<td>Quantity<font color="red">*</font></td>
													<td><form:input path="quantityChildEdit"
															id="quantityChildEdit" class="textbox"
															onkeyup="sumEdit()" maxlength="23"/></td>
												</tr>
												<tr>
													<td>Uom<font color="red">*</font></td>
													<td><form:select path="uomChildLEdit"
															id="uomChildLEdit" class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${SelectUom}" />
														</form:select></td>
												</tr>
												<tr>
													<td>Unit Price<font color="red">*</font></td>
													<td><form:input path="unitPriceChildEdit"
															id="unitPriceChildEdit" class="textbox"
															onkeyup="sumEdit()" maxlength="12"/></td>
												</tr>
												<tr>
													<td>Line Amount<font color="red">*</font></td>
													<td><form:input path="lineAmtChildEdit"
															id="lineAmtChildEdit" class="textbox" readonly="true" /></td>
												</tr>

												<tr>
													<td>Currency Name<font color="red">*</font></td>
													<td><form:select path="currencyCodeChildLEdit"
															id="currencyCodeChildL1Edit" class="select">
															<form:option value="0">-Select-</form:option>
															<form:options items="${SelectCurrency}" />
														</form:select></td>
												</tr>

												<tr>
													<td>Due Date<font color="red">*</font></td>
													<td><form:input path="dueDateChildEdit"
															id="dueDateChildEdit" class="textbox" /> <input
														type="hidden" name="hiddenIdPurchaseEditPopUp"
														id="hiddenIdPurchaseEditPopUp" value="0" /> <input
														type="hidden" name="lineAmtChildValueEdit"
														id="lineAmtChildValueEdit" value="0" /></td>
												</tr>


											</table>
										</div>

										<div id="users-contain-PurchaseEdit">
											<!-- class="ui-widget" -->

											<!-- <div style="height: 200px;width: 1000px;overflow: auto;border: 1px solid #666;background-color: #ccc;padding: 8px;">
										 -->
											<table id="PurchaseEdit" class="tableGeneral">

												<script type="text/javascript">

												 $( document ).ready(function() {
												 	 
												 	 var updatevalueForSubmit=$('#purchaseOrderStatusEdit').val();
												 	 if(updatevalueForSubmit!=1)
												 		 {
												 		// alert("sss");
												 		 document.getElementById("purchaseDuplicateMessEdit").style.display="block";
												 		 $('#purchaseDuplicateMessEdit').html("Warning ! Purchase order can't be changed at this Purchase order status");
												 		 
												 		 $('#update').hide();
												 		 }
												 });
														function forEditRow(id)
														{
															//alert("came "+id)
															var options = ''
																
																+'<table class="table"><tr id='+id+'>'
																 +'<td><spring:bind path="purchaseOrderCommand.purchaseOrderLineIdChild"><input type="hidden" name="purchaseOrderLineIdChild" id="purchaseOrderLineIdChild" value="0"/></spring:bind><spring:bind path="purchaseOrderCommand.materialIdChildEdit"><input type="hidden" name="materialIdChildEdit" id="materialIdChildEdit'+id+'"  class="textbox" readonly/></spring:bind>'
																 +'<spring:bind path="purchaseOrderCommand.materialNameChildEdit"><input type="text" name="materialNameChildEdit" id="materialNameChildEdit'+id+'"  class="textbox" readonly/></spring:bind> </td>'
																 +'<td><spring:bind path="purchaseOrderCommand.quantityChildEdit"><input name="quantityChildEdit" id="quantityChildEdit'+id+'"  class="textbox" readonly /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.unitPriceChildEdit"><input name="unitPriceChildEdit" id="unitPriceChildEdit'+id+'" class="textbox" readonly /></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.lineAmtChildEdit"><input name="lineAmtChildEdit" id="lineAmtChildEdit'+id+'" class="textbox" readonly/></spring:bind></td>'
																 +'<td><spring:bind path="purchaseOrderCommand.uomChildEdit"><input type="hidden" name="uomChildEdit" id="uomChildEdit'+id+'" class="textbox" readonly /></spring:bind>'
																 +'<spring:bind path="purchaseOrderCommand.uomNameChildEdit"><input type="text" name="uomNameEdit" id="uomNameChildEdit'+id+'" class="textbox" readonly /></spring:bind> </td>'
																 +'<td><spring:bind path="purchaseOrderCommand.currencyCodeChildEdit"><input type="hidden" name="currencyCodeChildEdit" id="currencyCodeChildEdit'+id+'" class="textbox" readonly /></spring:bind> '
																 +'<spring:bind path="purchaseOrderCommand.currencyNameChildEdit"><input type="text" name="currencyNameChildEdit" id="currencyNameChildEdit'+id+'" class="textbox" readonly /></spring:bind> </td>'
																 +'	<td><spring:bind path="purchaseOrderCommand.dueDateChildEdit"><input type="text" name="dueDateChildEdit" id="dueDateChildEdit'+id+'" class="textbox" readonly /></spring:bind></td>'
																 +'</td>'
																 +'<td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/Edit.jpg" height="25px" width="25px" onclick="editPurchaseInEdit('+ id+ ')" /></strong></a></td><td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove" onclick="removePurchaseInEdit('+ id+ ')"><strong><img src="images/button_cancel.png"  height="25px" width="25px" /></strong></a></td></tr></table>';
																
																					//$(options).fadeIn("slow").appendTo($("#PurchaseAdd tbody"));
															$(options).fadeIn("slow").appendTo('#extenderEdit');
														}
															
															</script>




												<tbody>
												</tbody>
											</table>

											<!-- </div> -->
										</div>
										<div id="extenderEdit"></div>
										<div align="center">
											<button id="create-EditPurchase" type="button">Add
												Purchase Line</button>
										</div>
									</div>
								</div>

							</div>

							<form:hidden path="puEditId" id="puEditId" />
							<c:choose>
								<c:when test="${true}">
									<input type="submit" value="Update" name="Update" id="update"
										class="btn btn-primary" align="top" />
								</c:when>
								<c:otherwise>
									<input type="submit" value="Update" name="Update"
										class="btn btn-danger" />
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</form:form>
				</div>


			</div>
		</div>

	</div>
	</div>
</body>
</html>
