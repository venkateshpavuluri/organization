<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
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
<script type="text/javascript" src="js/jstorage.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<c:url var="findPurchasedetails" value="/purchasedetails.mnt" />

<script type="text/javascript">


	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addGoodsForm')
													.validate(
															{
																rules : {
																	/* goodsReceiptType_Id : {
																		required : true

																	}, */
																	receivingID : {
																		required : true

																	},
																	receivingDate : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	
														

																},
																messages : {
																	
																	receivingID : "<font style='color: red;'><b>Receiving ID is Required</b></font>",
																	receivingDate : "<font style='color: red;'><b>Receiving Date is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	
																},

															});
											
											if($('#valueForSubData').val()==0)
												{
												alert("Please Enter Atleast One Goods Receipt Line");
												document.getElementById("addmessage").style.display = "block";
												$('#addmessage').html("Please Enter Goods Receipt Line");
												return false;
												}
											else
												{
												document.getElementById("addmessage").style.display = "none";
												$('#addmessage').html("");
												return true;
												}
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#updateGoodsForm')
													.validate(
															{
																rules : {
																	
																	receivingIDEdit : {
																		required : true

																	},
																	receivingDateEdit : {
																		required : true
																	},
																	statusIdEdit : {
																		required : true
																	},
													
																},
																messages : {
/* 																	goodsReceiptType_IdEdit : "<font style='color: red;'><b>Goods Receipt Type is Required</b></font>", */
																	receivingIDEdit : "<font style='color: red;'><b>Receiving ID is Required</b></font>",
																	receivingDateEdit : "<font style='color: red;'><b>Receiving Date is Required</b></font>",
																	statusIdEdit : "<font style='color: red;'><b>Status is Required</b></font>",
																	
																},
															});

										});

					});
</script>


<script type="text/javascript">
	function doAjaxPost() {

		//get the form values

		var receivingIDcheck = $('#receivingID').val();
		$
				.ajax({

					type : "POST",

					url : "GoodsReceiptAddCheck.mnt",

					data : "receivingIDcheck=" + receivingIDcheck,

					success : function(response) {

						var checkResponse = "Receiving ID Already Exists Choose Another One";
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
	function loadXMLDocEdit() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("goodsReceiptTypeNum").innerHTML = xmlhttp.responseText;
			}
		};
		var goodsReceipt = document.getElementById("goodsReceiptType_Id");
		//alert(goodsReceipt);

		var selectedText = goodsReceipt.options[goodsReceipt.selectedIndex].text;
		//alert(selectedText);

		var url = "purchasedetails.mnt?goodsReceipt=" + selectedText;
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script>
<script type="text/javascript">
function qty(){
	var material=$('#materialids').val();
	var matid=$('#matids').val();
	if(matid==material){
	$("#qtyHidden").val($('#receivedQty').val());
	}
}
function qtyEdit(){
	var material=$('#materialidsEdit').val();
	var matid=$('#matids').val();
	if(matid==material){
	$("#qtyHidden").val($('#receivedQtyEdit').val());
	}
}
	function loadMaterials() {
		
		var goodsReceipt = $('#goodsReceiptTypeNum').val();
		var material=$('#materialids').val();
		var matid=$('#matids').val();
		
		
		var matHiddenId=$('#materialHidden').val();
		if(matid!=0){
		if(matid==material){
		if(matHiddenId==0){
			
			$('#materialHidden').val($('#materialids').val());
			$.ajax({
				type : "POST",
				url : "poMaterialsDetails.mnt",
				data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
				success : function(data) {
					
					$("#availableQty").val(data);
					$("#matids").val(material);
					
					
					
				},
				error : function(e) {
					alert('Error: ' + e);
				}

			});
		}
		else{
			
			var enterQty=$('#qtyHidden').val();
			
			$.ajax({
				type : "POST",
				url : "poMaterialsDetails.mnt",
				data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
				success : function(data) {
					//alert(data);
					var oldvalue=null;
					var newvalue=$("#qtyHidden").val();
					if($("#totHidden").val()==0){
						$("#totHidden").val(newvalue);
						 oldvalue=$("#totHidden").val();
						
					}else{
					oldvalue=parseFloat($("#totHidden").val())+parseFloat(newvalue);
					$("#totHidden").val(oldvalue);
					
				}
					
					
						
						$("#availableQty").val(data);
						
						var st=parseFloat($("#availableQty").val())-parseFloat(oldvalue);
						
						$("#availableQty").val(st);
						/* $.jStorage.set(material,st);
						alert('jstorage');
						 var value = $.jStorage.get(material);
						 alert("available Quantity"+value); */
					
					
				
					
					
				},
				error : function(e) {
					alert('Error: ' + e);
				}

			});
		
		}
		
		}
		else{
			
				$('#materialHidden').val($('#materialids').val());
				$.ajax({
					type : "POST",
					url : "poMaterialsDetails.mnt",
					data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
					success : function(data) {
						
						$("#availableQty").val(data);
						$("#matids").val(material);
						
						$("#qtyHidden").val(0);
						var t=$("#qtyHidden").val();
						
						
					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});
			}
			
		
		
		}else{
			if(matHiddenId==0){
				
				$('#materialHidden').val($('#materialids').val());
				$.ajax({
					type : "POST",
					url : "poMaterialsDetails.mnt",
					data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
					success : function(data) {
						
						$("#availableQty").val(data);
						$("#matids").val(material);
						
						$("#qtyHidden").val(0);
						var t=$("#qtyHidden").val();
						
						/* $.jStorage.set(material,data);
						alert('jstorage');
						 var value = $.jStorage.get(material);
						 alert("available Quantity"+value); */
						/* var data1=$("#qtyHidden").val();
						alert(data+" "+$("#qtyHidden").val())
						$("#qtyHidden").val(data1); */
						
					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});
			}
			
		}
		}
		
	
		

</script>
<script type="text/javascript">
function loadAvailabilityQuantity(){
	
	var goodsReceipt = $('#goodsReceiptTypeNumEdit').val();
	
	var material=$('#materialidsEdit').val();
	
	$.ajax({
		type : "POST",
		url : "poMaterialsDetails.mnt",
		data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
		success : function(data) {
			
			$("#availableQtyEdit").val(data);
			
	
			
		},
		error : function(e) {
			alert('Error: ' + e);
		}

	});
}


	function loadMaterialsEdit() {
		
		var goodsReceipt = $('#goodsReceiptTypeNumEdit').val();
		var material=$('#materialidsEdit').val();
		var matid=$('#matids').val();
	
		var matHiddenId=$('#materialHidden').val();
		if(matid!=0){
		if(matid==material){
		if(matHiddenId==0){
			
			$('#materialHidden').val($('#materialidsEdit').val());
			$.ajax({
				type : "POST",
				url : "poMaterialsDetails.mnt",
				data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
				success : function(data) {
					
					$("#availableQtyEdit").val(data);
					$("#matids").val(material);
					alert("the matids"+$("#matids").val());
					/* var data1=$("#qtyHidden").val();
					alert(data+" "+$("#qtyHidden").val())
					$("#qtyHidden").val(data1); */
					
				},
				error : function(e) {
					alert('Error: ' + e);
				}

			});
		}
		else{
			
			var enterQty=$('#qtyHidden').val();
		
			$.ajax({
				type : "POST",
				url : "poMaterialsDetails.mnt",
				data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
				success : function(data) {
					//alert(data);
					var oldvalue=null;
					var newvalue=$("#qtyHidden").val();
					if($("#totHidden").val()==0){
						$("#totHidden").val(newvalue);
						 oldvalue=$("#totHidden").val();
					
					}else{
					oldvalue=parseFloat($("#totHidden").val())+parseFloat(newvalue);
					$("#totHidden").val(oldvalue);
					
				}
				
				
						$("#availableQtyEdit").val(data);
						
						var st=parseFloat($("#availableQtyEdit").val())-parseFloat(oldvalue);
					
						$("#availableQtyEdit").val(st);
					
					
				
					
				
				},
				error : function(e) {
					alert('Error: ' + e);
				}

			});
		
		}
		
		}
		else{
			
			
				$('#materialHidden').val($('#materialidsEdit').val());
				$.ajax({
					type : "POST",
					url : "poMaterialsDetails.mnt",
					data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
					success : function(data) {
						
						$("#availableQtyEdit").val(data);
						$("#matids").val(material);
						alert("the matids"+$("#matids").val());
						$("#qtyHidden").val(0);
						var t=$("#qtyHidden").val();
						alert("qty hidden"+t);
						/* var data1=$("#qtyHidden").val();
						alert(data+" "+$("#qtyHidden").val())
						$("#qtyHidden").val(data1); */
						
					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});
			}
			
		
		
		}else{
			if(matHiddenId==0){
				alert("in else if");
				$('#materialHidden').val($('#materialidsEdit').val());
				$.ajax({
					type : "POST",
					url : "poMaterialsDetails.mnt",
					data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
					success : function(data) {
						
						$("#availableQtyEdit").val(data);
						$("#matids").val(material);
						alert("the matids"+$("#matids").val());
						$("#qtyHidden").val(0);
						var t=$("#qtyHidden").val();
						alert("qty hidden"+t);
						
						/* var data1=$("#qtyHidden").val();
						alert(data+" "+$("#qtyHidden").val())
						$("#qtyHidden").val(data1); */
						
					},
					error : function(e) {
						alert('Error: ' + e);
					}

				});
			}
			
		}
	}
		
		

</script>

<script type="text/javascript">
	function loadXMLDocEditt() {

		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();

		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("goodsReceiptTypeNumEdit").innerHTML = xmlhttp.responseText;
			}
		};
		var goodsReceipt = document.getElementById("goodsReceiptType_IdEdit");
		alert(goodsReceipt);

		var selectedText = goodsReceipt.options[goodsReceipt.selectedIndex].text;
		alert(selectedText);

		var url = "purchasedetails.mnt?goodsReceipt=" + selectedText;
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script> 

<script type="text/javascript">
	function doAjaxPostEdit() {

		//get the form values
		var goodsReceipt_IdEdit = $('#goodsReceipt_IdEdit').val();
		var receivingIDEdit = $('#receivingIDEdit').val();
		$
				.ajax({

					type : "POST",

					url : "GoodsReceiptEditCheck.mnt",

					data : "goodsReceipt_IdEdit=" + goodsReceipt_IdEdit
							+ "&receivingIDEdit=" + receivingIDEdit,

					success : function(response) {
						var checkResponse = "Receiving ID Already Exists Choose Another One";
						//	alert(response);
						if (checkResponse == response) {
							document.getElementById("editmessage").style.display = "block";
							$('#editmessage').html(response);
						} else {
							document.getElementById("editmessage").style.display = "none";
						}
					},

					error : function(e) {

						alert('Error: ' + e);

					}

				});

	}
</script>


<!--  Date picker -->

<script type="text/javascript">
function dateFun(datePattern) {
	$('#receivingDate,#DCDate,#DocketDate,#receivingDateEdit,#DCDateEdit,#DocketDateEdit,#inspectedDTTM,#inspectedDTTMEdit').datepicker({
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
	width: 55%;
}
</style>

<!-- Horizantol scroll -->
<style type="text/css">
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
	$(function() { /*  jldsfgjl;jg;dsgl;df */
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
			//alert(aid);
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
		<div class="PageTitle">Goods Receipt</div>

		<!-- Tabs Declaration -->

		
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="goodsReceiptEditList"
						items="${goodsReceiptEditList}">
						<c:set var="goodsReceiptEditList" value="${goodsReceiptEditList }"></c:set>
					</c:forEach>
					<c:if test="${goodsReceiptEditList!=null}">
						<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
					</c:if>
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
				</ul>

				<!-- Search tab part -->


				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">
						<form:form action="GoodsReceiptSearch.mnt" method="GET"
							commandName="GoodsReceiptCommand">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="gadd"
											items="${param.list}">
											<div class="alert-success" id="savemessage">
												<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.goodsReceipt"/> <spring:message code="label.saveSuccess"></spring:message>
											</div>
										</c:forEach>
								<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.goodsReceipt"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
							
									<c:forEach var="goodsReceiptUpdate"
											items="${goodsReceiptUpdate}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.goodsReceipt"/> <spring:message code="label.updateSuccess"></spring:message>
											</div>
										</c:forEach>
						
                                <c:forEach var="goodsReceiptUpdateError"
										items="${goodsReceiptUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.goodsReceipt"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="goodsReceiptDelete"
											items="${goodsReceiptDelete}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.goodsReceipt"/> <spring:message code="label.deleteSuccess"></spring:message>
											</div>
										</c:forEach><c:forEach var="goodsReceiptDeleteError"
											items="${goodsReceiptDeleteError}">
											<div class="alert-success" id="successmessage">
												<strong><spring:message code="label.Error"/></strong>
											<spring:message code="label.goodsReceipt"/> <spring:message code="label.deleteFail"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								
								<tr id="mainSearch">
									<spring:message code="label.searchby" />
									<form:select path="xmlLabel" cssClass="select">

											<form:options items="${xmlItems}" />
										</form:select> <form:select path="operations" cssClass="select">
											<form:option value="=">Equals To</form:option>
											<form:option value="!=">Not Equals To</form:option>
											<form:option value="_%">BeginsWith</form:option>
											<form:option value="%_">EndsWith</form:option>
											<form:option value="%_%">Contains</form:option>
										</form:select> <form:input path="basicSearchId" cssClass="textbox" />
										<c:set
										var="save" value="false"></c:set> <c:set var="edit"
										value="false"></c:set> <c:set var="delete" value="false"></c:set>
									<c:set var="update" value="false"></c:set> <c:set var="search"
										value="false"></c:set> <fmt:setBundle basename="button" /> <fmt:message
										key="label.save" var="messagesav" /> <fmt:message
										key="label.search" var="messagesea" /> <fmt:message
										key="label.delete" var="messagedel" /> <fmt:message
										key="label.update" var="messageup" /> <fmt:message
										key="label.edit" var="messageed" /> <c:forEach
										items="${sessionScope.privilegeList}" var="privileges">
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
									
									 <c:choose>
										<c:when test="${true}">
									<input type="submit"
										value="<spring:message code="label.search"/>"
										class="btn btn-primary" /></c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose>
								</tr>
								<form:form action="goodsAdvanceSearch.mnt" method="get"
							commandName="GoodsReceiptCommand" name="advanceSearchFinal" id="advanceSearchFinal">
							<tr>
								<td>
									<a href="goodsAdvanceSearch.mnt"><font
										style="color: blue" id="aslink"><u><b>Advanced Search</b></u></font></a>
										<a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							
							</tr>
						</form:form>
							</table>
							<form:form action="goodsAdvanceSearchOperations.mnt"
						commandName="GoodsReceiptCommand">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${goodsSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label><form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1">
												<form:option value="0">-Select-</form:option>
												<form:option value="=">Equals To</form:option>
												<form:option value="!=">Not Equals To</form:option>
												<form:option value="_%">BeginsWith</form:option>
												<form:option value="%_">EndsWith</form:option>
												<form:option value="%_%">Contains</form:option>
											</form:select></td>
										<td><form:input path="advanceSearchText"
												id="advanceSearchkk"  /></td>
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
						<c:forEach var="goodsreceipt" items="${goodsReceipt}">

						<c:set var="as" value="${goodsreceipt}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">
						<display:table id="GoodsReceip" name="GoodsReceip"
							requestURI="GoodsReceiptSearch.mnt" pagesize="4" class="table">
							<%-- <display:column property="goodsReceiptTypeNum"
								title="Goods Receipt Type Number" media="html" sortable="true"></display:column> --%>
							<display:column property="receivingID" title="Receiving ID"
								media="html" sortable="true"></display:column>
							<display:column property="dCNumber" title="DC Number"
								media="html" sortable="true"></display:column>
							<display:column property="docketNum" title="Docket Number"
								media="html" sortable="true"></display:column>

							<display:column title="Edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
								<a
									href="goodsReceiptEditHome.mnt?goodsReceiptId=<c:out value="${GoodsReceip.goodsReceipt_Id}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
									</c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
							</display:column>
							<display:column title="Delete">
							<c:choose>
							<c:when test="${true}">
								<a
									href="goodsReceiptDelete.mnt?goodsReceiptId=<c:out value="${GoodsReceip.goodsReceipt_Id}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
									
									</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
							</c:otherwise>
							</c:choose>
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
									style="display: none; width: 400px; height: 25px; color: red"></td>
							</tr>
						</table>
						<form:form action="GoodsReceiptAdd.mnt" method="POST"
							commandName="GoodsReceiptCommand" id="addGoodsForm">
							<table class="tableGeneral">
								<tr>
									<td><spring:message code="label.goodsReceiptType" /></td>
									<td><form:select path="goodsReceiptType_Id"
											id="goodsReceiptType_Id" class="select"
											onchange="loadXMLDocEdit(this)">
											<form:option value="0">--- Select ---</form:option>
											<form:options items="${goodsReceiptType }" />
										</form:select></td>
									<td></td>
									<td><spring:message code="label.goodsReceiptTypeNumber" /></td>
									<td><form:select path="goodsReceiptTypeNum"
											id="goodsReceiptTypeNum" class="select">
											<form:option value="0">--- Select ---</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.receivingId" /><font color="red">*</font></td>
									<td><form:input path="receivingID" id="receivingID"
											class="textbox" onkeyup="doAjaxPost()"/></td>
									<td></td>
									<td><spring:message code="label.recevingdate" /><font color="red">*</font></td>
									<td><form:input path="receivingDate" id="receivingDate"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.receivingStatus" /><font color="red">*</font></td>
									<td><form:select path="statusId" id="statusId"
											class="select" cssStyle="height:25px">
											<form:option value="0">---Select---</form:option>
											<form:options items="${status }" />
										</form:select></td>
									<td></td>
									<td><spring:message code="label.dcNumber" /></td>
									<td><form:input path="dCNumber" id="DCNumber"
											class="textbox"/></td>
								</tr>
								 <tr>
									<td><spring:message code="label.vendor" /></td>
									<td><form:select path="vendor_Id" id="vendor_Id"
											class="select">
											<form:option value="0">--- Select ---</form:option>
											<form:options items="${vendor }" />
										</form:select></td>
									<td></td>
									<td><spring:message code="label.dcDate" /></td>
									<td><form:input path="dCDate" id="DCDate" class="textbox" /></td>
								</tr>
								
								<tr>
									<td><spring:message code="label.transportAgency" /></td>
									<td><form:input path="transportAgency"
											id="transportAgency" class="textbox"/></td>
									<td></td>
									<td><spring:message code="label.docketNumber" /></td>
									<td><form:input path="docketNum" id="docketNum"
											class="textbox"/></td>
								</tr>
								
								<tr>
									<td><spring:message code="label.docketDate" /></td>
									<td><form:input path="docketDate" id="DocketDate"
											class="textbox" /></td>
									<td></td>
									<td><spring:message code="label.totalPackages" /></td>
									<td><form:input path="totalPackages" id="TotalPackages"
											class="textbox" /></td>
								</tr>
							
								<tr>
									<td><spring:message code="label.weight" /></td>
									<td><form:input path="weight"class="textbox" /></td>
									<td></td> 
									 <td><spring:message code="label.weightUom" /></td>
									<td><form:select path="uom_Id" id="uom_Id" class="select"
											cssStyle="height:25px">
											<form:option value="0">--- Select ---</form:option>
											<form:options items="${uom }" />
										</form:select></td> 
								</tr>
									
								<tr>
									<td><spring:message code="label.recevingAddress" /></td>
									<td><form:input path="receivingAddress"
											id="ReceivingAddress" class="textbox"/></td>
									<td></td>
									<td><spring:message code="label.freightCharges" /></td>
									<td><form:input path="freightCharges" id="FreightCharges"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.totalValue" /></td>
									<td><form:input path="totalValue" id="TotalValue"
											class="textbox" /></td>
									<td></td>
									<td><spring:message code="label.productionOrder" /></td>
									<td><form:input path="prodOrder_Id" id="ProdOrder_Id"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.batch" /></td>
									<td><form:input path="batch_Id" id="Batch_Id"
											class="textbox" /></td>
									<td></td>
									<td><spring:message code="label.routeCard" /></td>
									<td><form:input path="routeCard_Id" id="RouteCard_Id"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.memo" /></td>
									<td><form:input path="memo" id="memo" class="textbox"/></td>
									<td></td>
									<td><spring:message code="label.shippingAddress" /></td>
									<td><form:input path="shippingAddress"
											id="shippingAddress" class="textbox" />
											
											<input type="hidden" name="valueForSubData"
											id="valueForSubData" class="textbox" value="0"/>
											</td>
								</tr> 
							</table>
							<!-- Sub tabbing for adding  details -->

									<div id="tabsForAdd">
								<ul>
									<li><a href="#subtabs-1">GoodsReceiptLine</a></li>

								</ul>
                                
								
								
								
									<div >
							<div align="left">
							
								
									<script>
										var qltrid = 1;
										$(function() {
											var 
											 materialids = $("#materialids"), 
											 mvalue=$("#mNumber"),
											batchNo=$('#batchNo'),
											receivedQty = $("#receivedQty"),
											qtyuoms = $("#qtyuoms"),
											quvalue=$("#quNumber"),
											vendorMaterialNbr=$("#vendorMaterialNbr"),
											materialSpecs=$("#materialSpecs"),
											Storagelocs=$("#Storagelocs"),
											storagelocsvalue=$("#StoragelocsNumber"),
											qtyLength=$("#qtyLength"),
											QlUom=$("#QlUom"),
											qlvalue=$("#qlNumber"),
											qtyWeight=$("#qtyWeight"),
											QwUom=$("#QwUom"), 
											qwvalue=$("#qwNumber"),
											availableQty = $("#availableQty"),
											hiddenID = $("#hiddenIdBankPopUp"), 
											allFields = $([])
											 .add(materialids).add(mvalue).add(batchNo).add(receivedQty).add(qtyuoms).add(quvalue).
											add(vendorMaterialNbr).add(materialSpecs).add(Storagelocs).add(storagelocsvalue).add(qtyLength).add(QlUom).add(qlvalue).add(qtyWeight).add(QwUom).add(qwvalue).add(availableQty).add(hiddenID),
											 tips = $(".validateTips");
											        //alert("hear "+material_Id.val());
											        
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
												if (!(regexp.test(o.val()))) {
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
																height : 420,
																width : 400,
																modal : true,
																buttons : {
																	Submit : function() {
																		var aval=$("#availableQty").val();
																		alert("aval"+aval);
																		var rece=$("#receivedQty").val();
																		alert("rec:"+rece)
																		var result=aval-rece;
																		alert("result:"+result);
																		var materials=$("#materialids").val();
																		alert("material"+materials);
																		//$("#lastValue").val($("#availableQty").val());
																		   // alert("res:"+res);
																		   
																		   $.jStorage.set(materials,result);
						alert('jstorage');
						 var value = $.jStorage.get(materials);
						 alert("available Quantity"+value);
																		var bValid = true;
																		allFields.removeClass("ui-state-error");
																	 
																		  bValid = bValid
																		&& selectLength(
																				materialids,
																				"Material"
																				);
																		  bValid = bValid
																			&& checkLength(
																					batchNo,
																					"Batch Number",1,
																					10);
																		  bValid = bValid 
																		  && checkLength3(
																				  receivedQty,
																				  availableQty,
																				  "Received Quantity");
																		
																		  
																		  bValid = bValid
																			&& selectLength(
																					qtyuoms,
																					"Quantity UOM"
																					);
																		  
																		  bValid = bValid
																			&& checkLength(
																					vendorMaterialNbr,
																					"Vendor Material Nbr",
																					1,
																					16);
																		  bValid = bValid
																			&& checkLength(
																					materialSpecs,
																					"Material Specs",
																					1,
																					16);
																		  bValid = bValid
																			&& selectLength(
																					Storagelocs,
																					"Storage Location"
																					);
																		  bValid = bValid
																			&& checkLength(
																					qtyLength,
																					"Quantity Length",
																					1,
																					16);
																		  
																		  bValid = bValid
																			&& selectLength(
																					QlUom,
																					"Quantity Length UOM"
																					);
																		  bValid = bValid
																			&& checkLength(
																					qtyWeight,
																					"Quantity Weight",
																					1,
																					16);
																		  bValid = bValid
																			&& selectLength(
																					QwUom,
																					"Quantity Weight UOM"
																					); 
																		  
																		  
											
																		

																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
															 
															
															
															$("#quotLineAdd tbody")
																						.append(
																								
																								"<tr id=" +qltrid+">"
																							
																								
																								 + "<td><input type='hidden' name='materialids' id='materialids"
																								+ qltrid
																								+ "' value="
																								+ materialids
																										.val()
																								+ " class='textbox'/><input type='text' name='mNumber' id='mNumber"
																									+ qltrid
																									+ "' value="
																									+ $('#materialids :selected').text()
																																																			
																									+ " class='textbox'readonly/></td>"
																									
																								+ "<td><input name='batchNo' id='batchNo"
																									+qltrid
																									+ "' value="
																									+ batchNo
																											.val()
																									+ " class='textbox'/></td>"
																								
																								+ "<td><input type='hidden' name='qtyHidden' id='qtyHidden"
																								+qltrid
																								+"'value="
																								+receivedQty 
																								.val()
																								+" class='textbox'/><input name='receivedQty' id='receivedQty"
																								+ qltrid
																								+ "' value="
																								+ receivedQty 
																										.val()
																								+ " class='textbox'/></td>"
																							
																								+ "<td><input type='hidden' name='qtyuoms' id='qtyuoms"
																								+ qltrid
																								+ "' value="
																								+ qtyuoms
																										.val()
																								+ " class='textbox'/><input type='text' name='quvalue' id='quvalue"
																								+ qltrid
																								+ "' value="
																								+ $('#qtyuoms :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																							
																								
																								
																								+ "<td><input name='vendorMaterialNbr' id='vendorMaterialNbr"
																								+ qltrid
																								+ "' value="
																								+ vendorMaterialNbr
																										.val()
																								+ " class='textbox'/></td>"
																								
																								+ "<td><input name='materialSpecs' id='materialSpecs"
																								+ qltrid
																								+ "' value="
																								+ materialSpecs
																										.val()
																								+ " class='textbox'/></td>"
																								
																								+ "<td><input type='hidden' name='Storagelocs' id='Storagelocs"
																								+ qltrid
																								+ "' value="
																								+ Storagelocs
																										.val()
																								+ " class='textbox'/><input type='text' name='StoragelocsNumber' id='StoragelocsNumber"
																									+ qltrid
																									+ "' value="
																									+ $('#Storagelocs :selected').text()
																																																			
																									+ " class='textbox'readonly/></td>"
																								+ "<td><input name='qtyLength' id='qtyLength"
																								+ qltrid
																								+ "' value="
																								+ qtyLength
																										.val()
																								+ " class='textbox'/></td>"
																								
																								+ "<td><input type='hidden'name='QlUom' id='QlUom"
																								+ qltrid
																								+ "' value="
																								+ QlUom
																										.val()
																								+ " class='textbox'/><input type='text' name='qlNumber' id='qlNumber"
																								+ qltrid
																								+ "' value="
																								+ $('#QlUom :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																								
																								+ "<td><input name='qtyWeight' id='qtyWeight"
																								+ qltrid
																								+ "' value="
																								+ qtyWeight
																										.val()
																								+ " class='textbox'/></td>"
																								
																								+ "<td><input type='hidden' name='QwUom' id='QwUom"
																								+ qltrid
																								+ "' value="
																								+ QwUom
																										.val()
																								+ " class='textbox'/><input type='text' name='qwNumber' id='qwNumber"
																								+ qltrid
																								+ "' value="
																								+ $('#QwUom :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																							
 
																								// "<td>" + password.val() + "</td>" +
																								+"<td><a href='#'  onclick='editMaterialm("
																								+ qltrid
																								+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																								+ "<td><a href='#'  onclick=removeMaterialm("
																								+ qltrid
																								+ ")><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
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
																								materialids 
																										.val());
																										
																					$(
																							'#mNumber'
																									+ hiddenID
																											.val())
																							.val(
																									 $('#materialids :selected').text());
																				
																					
																					$('#batchNo'
																									+ hiddenID
																											.val())
																							.val(
																									batchNo 
																											.val());
																					
																				$(
																						'#receivedQty'
																								+ hiddenID
																										.val())
																						.val(
																								receivedQty 
																										.val());
																			
																				$(
																						'#qtyuoms'
																								+ hiddenID
																										.val())
																						.val(
																								qtyuoms.val());
																				$(
																						'#quvalue'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#qtyuoms :selected').text());
																				 $(
																						'#quNumber'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#qtyuoms :selected').text());
																				
																					
																				$(
																						'#vendorMaterialNbr'
																								+ hiddenID
																										.val())
																						.val(
																								vendorMaterialNbr
																										.val());
																				$(
																						'#materialSpecs'
																								+ hiddenID
																										.val())
																						.val(
																								materialSpecs
																										.val());
																				$(
																						'#Storagelocs'
																								+ hiddenID
																										.val())
																						.val(
																								Storagelocs 
																										.val());
																				 
																					$(
																							'#StoragelocsNumber'
																									+ hiddenID
																											.val())
																							.val(
																									 $('#Storagelocs :selected').text());
																				$(
																						'#qtyLength'
																								+ hiddenID
																										.val())
																						.val(
																								qtyLength
																										.val());
																				
																				$(
																						'#QlUom'
																								+ hiddenID
																										.val())
																						.val(
																								QlUom
																										.val());
																				$(
																						'#qtyWeight'
																								+ hiddenID
																										.val())
																						.val(
																								qtyWeight
																										.val());
																			
																				$(
																						'#QwUom'
																								+ hiddenID
																										.val())
																						.val(
																								QwUom
																										.val());
															
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
																
															});
										});
										function removeMaterialm(id) {
											alert("removing row " + id);
											$('#' + id).remove();
											alert($('#valueForSubData').val());
											$('#valueForSubData').val(parseFloat($('#valueForSubData').val())-parseFloat(1));
											
										}
										function editMaterialm(id) {
											//alert("edit row " + id);
											//$('#'+id).remove();
                                                alert("materialId:"+$('#materialids'+id).val());
                                                var value = $.jStorage.get($('#materialids' + id).val());
                                                var recivqty=$('#receivedQty'+id).val();
                                                var reQty=parseFloat(value)+parseFloat(recivqty);
                       						 alert("available Quantity"+value);
											$("#dialog-form-QuotLine").dialog(
													"open");
																					
											 $('#materialids').val(
													$('#materialids' + id).val());
											 
												$('#mNumber').val(
														$('#mNumber' + id).val());
												$('#batchNo').val(
														$('#batchNo' + id).val());
												 $('#availableQty').val(
														 reQty);
											$('#receivedQty').val(
													$('#receivedQty' + id)
															.val());
											$('#qtyuoms').val(
													$('#qtyuoms' + id)
															.val());

											$('#quNumber').val(
													$('#quNumber' + id).val());
											
											
											$('#vendorMaterialNbr').val(
													$('#vendorMaterialNbr' + id)
															.val());
											$('#materialSpecs').val(
													$('#materialSpecs' + id)
															.val());
											
											$('#Storagelocs').val(
													$('#Storagelocs' + id).val());
											 
												$('#StoragelocsNumber').val(
														$('#StoragelocsNumber' + id).val());
											$('#qtyLength').val(
													$('#qtyLength' + id)
															.val());
											$('#QlUom').val(
													$('#QlUom' + id)
															.val());

											$('#qlNumber').val(
													$('#qlNumber' + id).val());
											$('#qtyWeight').val(
													$('#qtyWeight' + id)
															.val());
											$('#QwUom').val(
													$('#QwUom' + id)
															.val()); 

											$('#qwNumber').val(
													$('#qwNumber' + id).val());
											
											$('#hiddenIdBankPopUp').val(id);
											
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-QuotLine" title="Add New Goods Receipt Line Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
                                            			
                                             
											  <tr>
												<td><spring:message code="label.prmaterial" /><font color="red">*</font></td>
												<td><form:select path="materialids" class="select" id="materialids" cssStyle="height:25px" onchange="loadMaterials()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
														<form:hidden path="materialHidden" id="materialHidden" value="0"/>
														<form:hidden path="qtyHidden" id="qtyHidden" />
														<form:hidden path="totHidden" id="totHidden" />
														<form:hidden path="lastValue" id="lastValue" />
														<form:hidden path="matids" id="matids" value="0" />
											</tr>
											<tr>
												<td><spring:message code="label.BatchNo" /><font color="red">*</font></td>
												<td><form:input path="batchNo" id="batchNo"
															class="textbox" /></td></tr>
															
                                             <tr>
												<td>Available Quantity<font color="red">*</font></td>
												<td><form:input path="avalQty" id="availableQty"
															class="textbox" readonly="true" /></td>
											</tr>
											  
											<tr>
												<td>Received Quantity<font color="red">*</font></td>
												<td><form:input path="receivedQty" id="receivedQty"
															class="textbox" onkeyup="qty()"/></td>
											</tr>
											
											 <tr>
												<td>Quantity UOM<font color="red">*</font></td>
												<td><form:select path="qtyuoms" class="select" id="qtyuoms" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
											
									
											<tr>
												<td>Vendor Material Nbr<font color="red">*</font></td>
												<td><form:input path="vendorMaterialNbr" id="vendorMaterialNbr"
															class="textbox"/></td>
											</tr>
											<tr>
												<td>MaterialSpecs<font color="red">*</font></td>
												<td><form:input path="materialSpecs" id="materialSpecs"
															class="textbox"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.storageLocation" /><font color="red">*</font></td>
													<td><form:select path="Storagelocs" id="Storagelocs" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${storageId }" />
														</form:select></td>
											</tr>
											
											<tr>
												<td>Quantity Length<font color="red">*</font></td>
												<td><form:input path="qtyLength" id="qtyLength"
															class="textbox"/></td>
											</tr>
											
											
											<tr>
												<td>Quantity Length UOM<font color="red">*</font></td>
												<td><form:select path="QlUom" id="QlUom" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
											<tr>
												<td>Quantity Weight<font color="red">*</font></td>
												<td><form:input path="qtyWeight" id="qtyWeight"
															class="textbox"/></td>
											</tr>
											<tr>
												<td>Quantity Weight UOM<font color="red">*</font></td>
												<td><form:select path="QwUom" id="QwUom" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select> <input type="hidden" name="hiddenIdBankPopUp" id="hiddenIdBankPopUp" value="0"/></td></tr>
 										</table>
									</div>

								<div id="scroll">
									<div id="users-contain-quotLine">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="quotLineAdd" class="table" >
											<thead>
												<tr>
												
												
															<th><spring:message code="label.material" /><font color="red">*</font></th>
															<th><spring:message code="label.BatchNo" /><font color="red">*</font></th>
															<th><spring:message code="label.receivedQuantity" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityUom" /><font color="red">*</font></th>
															<th><spring:message code="label.vendorMaterialNumber" /><font color="red">*</font></th>
															<th><spring:message code="label.materialSpecs" /><font color="red">*</font></th>
															<th><spring:message code="label.storageLocation" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityLength" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityLengthUom" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityWeight" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityWeightUom" /><font color="red">*</font></th>
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									
									<center><button id="create-AddQuotLine" type="button">Add New Goods Receipt Line</button></center>
									

								</div>
							</div>
							</div>
							</div>
                   <form:hidden path="aid"/>

							<c:choose>
									<c:when test="${true}"><input type="submit" value="Save" name="Save"
								class="btn btn-primary" id="submitid" />
							</c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> <input type="reset"
									class="btn btn-primary"
									value="<spring:message
								code="label.reset" />" />
									</c:otherwise>

								</c:choose>
						</form:form>
					
				
					</div>
				</div>

				<!-- Edit tab -->

				<div id="tabs-1">
					
					
<c:forEach var="goodsReceiptEditList"
							items="${goodsReceiptEditList}">
							<c:set var="goodsedit" value="${goodsReceiptEditList}"></c:set>
						</c:forEach>
							<table>
								<tr>
									<td colspan="4" class="alert-warning" id="editmessage"
										style="display: none; width: 400px; height: 25px; color: red"></td>
								</tr>
							</table>
							
							<c:if test="${goodsedit!=null}">
							<form:form action="GoodsReceiptedit.mnt" method="POST"
								commandName="GoodsReceiptCommand" id="updateGoodsForm">
								
										<table class="tableGeneral">
											<form:hidden path="goodsReceipt_IdEdit"
												id="goodsReceipt_IdEdit" /> 
											<tr>
												<td><spring:message code="label.goodsReceiptType" /></td>
												<td><form:select path="goodsReceiptType_IdEdit"
														id="goodsReceiptType_IdEdit" class="select"
														onchange="loadXMLDocEditt(this)">
														<form:option value="--- Select ---"></form:option>
														<form:options items="${goodsReceiptType }" />
													</form:select></td>
												<td></td>
												
											<td><spring:message code="label.goodsReceiptTypeNumber" /></td>
									<td><form:input path="GoodsReceiptTypeNumEdit"
											id="goodsReceiptTypeNumEdit" class="textbox"/>
										</td>
								</tr>
								<tr>
									<td><spring:message code="label.receivingId" /><font color="red">*</font></td>
									<td><form:input path="receivingIDEdit" id="receivingID"
											class="textbox" onkeyup="doAjaxPost()" maxlength="50"/></td>
									<td></td>
									<td><spring:message code="label.recevingdate" /><font color="red">*</font></td>
									<td><form:input path="receivingDateEdit" id="receivingDate"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.receivingStatus" /><font color="red">*</font></td>
									<td><form:select path="statusIdEdit" id="statusId"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${status }" />
										</form:select></td>
									<td></td>
									<td><spring:message code="label.dcNumber" /></td>
									<td><form:input path="dCNumberEdit" id="DCNumber"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.vendor" /></td>
									<td><form:select path="vendor_IdEdit" id="vendor_Id"
											class="select">
											<form:option value="--- Select ---"></form:option>
											<form:options items="${vendor }" />
										</form:select></td>
									<td></td>
									<td><spring:message code="label.dcDate" /></td>
									<td><form:input path="dCDateEdit" id="DCDate" class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.transportAgency" /></td>
									<td><form:input path="transportAgencyEdit"
											id="transportAgency" class="textbox" maxlength="50"/></td>
									<td></td>
									<td><spring:message code="label.docketNumber" /></td>
									<td><form:input path="docketNumEdit" id="docketNum"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.docketDate" /></td>
									<td><form:input path="docketDateEdit" id="DocketDate"
											class="textbox" /></td>
									<td></td>
									<td><spring:message code="label.totalPackages" /></td>
									<td><form:input path="totalPackagesEdit" id="TotalPackages"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.weight" /></td>
									<td><form:input path="weightEdit" id="Weight" class="textbox" /></td>
									<td></td>
									<td><spring:message code="label.weightUom" /></td>
									<td><form:select path="uom_IdEdit" id="uom_IdEdit" class="select"
											cssStyle="height:25px">
											<form:option value="0">---Select---</form:option>
											<form:options items="${uom }" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.recevingAddress" /></td>
									<td><form:input path="receivingAddressEdit"
											id="ReceivingAddress" class="textbox" maxlength="250"/></td>
									<td></td>
									<td><spring:message code="label.freightCharges" /></td>
									<td><form:input path="freightChargesEdit" id="FreightCharges"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.totalValue" /></td>
									<td><form:input path="totalValueEdit" id="TotalValue"
											class="textbox" /></td>
									<td></td>
									<td><spring:message code="label.productionOrder" /></td>
									<td><form:input path="prodOrder_IdEdit" id="ProdOrder_Id"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.batch" /></td>
									<td><form:input path="batch_IdEdit" id="Batch_Id"
											class="textbox" /></td>
									<td></td>
									<td><spring:message code="label.routeCard" /></td>
									<td><form:input path="routeCard_IdEdit" id="RouteCard_Id"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.memo" /></td>
									<td><form:input path="memoEdit" id="memo" class="textbox" maxlength="50"/></td>
									<td></td>
									<td><spring:message code="label.shippingAddress" /></td>
									<td><form:input path="shippingAddressEdit"
											id="shippingAddress" class="textbox" /></td>
								</tr>
										</table>

								
									<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1">Goods Receipt Line</a></li>

								</ul>
								<!--Sub Tab-1 -->
								<div id="tab1">
								<div id="scroll">
									<div align="center">
									
										<script>
											var btrid = 1;
											$(function() {

											var	materialidsEdit = $("#materialidsEdit"), 
												batchNoEdit=$("#batchNoEdit"),
												receivedQtyEdit = $("#receivedQtyEdit"),
												qtyuomsEdit = $("#qtyuomsEdit"),
												vendorMaterialNbrEdit=$("#vendorMaterialNbrEdit"),
												materialSpecsEdit=$("#materialSpecsEdit"),
												storagelocsEdit=$("#storagelocsEdit"),
												qtyLengthEdit=$("#qtyLengthEdit"),
												QlUomEdit=$("#QlUomEdit"),
												qtyWeightEdit=$("#qtyWeightEdit"),
												QwUomEdit=$("#QwUomEdit"), 
												availableQtyEdit=$("#availableQtyEdit"),
												hiddenEdit = $("#hiddenIdEditQPopUp"),
												
												allFields = $([]).add(materialidsEdit).add(batchNoEdit).add(receivedQtyEdit).add(qtyuomsEdit)
												.add(vendorMaterialNbrEdit).add(materialSpecsEdit).add(storagelocsEdit).add(qtyLengthEdit).add(QlUomEdit).add(qtyWeightEdit).add(QwUomEdit).add(availableQtyEdit).add(hiddenEdit),
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
												
												function checkLength3(o,k,n) {
														
														var qty=parseInt(o.val());
														var aqty=parseInt(k.val());
														if (k.val() != ''){
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
												else{
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
																	height : 420,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var aval=$("#availableQtyEdit").val();
																			alert("aval"+aval);
																			var rece=$("#receivedQtyEdit").val();
																			alert("rec:"+rece)
																			var result=aval-rece;
																			alert("result:"+result);
																			var materials=$("#materialidsEdit").val();
																			alert("material"+materials);
																			//$("#lastValue").val($("#availableQty").val());
																			   // alert("res:"+res);
																			   
																			   $.jStorage.set(materials,result);
							alert('jstorage');
							 var value = $.jStorage.get(materials);
							 alert("available Quantity"+value);
																			
																			//alert("aval"+$("#availableQtyEdit"));
																			var bValid1 = true;
																			
																			  bValid1 = bValid1
																			&& selectLength(
																					materialidsEdit,
																					"Material"
																					);
																			   bValid1 = bValid1
																				&& checkLength(
																						batchNoEdit,
																						"Batch No",
																						1,
																						16);
																			 bValid1 = bValid1 
																			  && checkLength3(
																					  receivedQtyEdit,
																					  availableQtyEdit,
																					  "Received Quantity"); 
																		
																			  
																			  bValid1 = bValid1
																				&& selectLength(
																						qtyuomsEdit,
																						"Quantity UOM"
																						);
																			 
																			  bValid1 = bValid1
																				&& checkLength(
																						vendorMaterialNbrEdit,
																						"Vendor Material Nbr",
																						1,
																						16);
																			  bValid1 = bValid1
																				&& checkLength(
																						materialSpecsEdit,
																						"Material Specs",
																						1,
																						16);
																			  bValid1 = bValid1
																				&& checkLength(
																						qtyLengthEdit,
																						"Quantity Length",
																						1,
																						16);
																			  
																			  bValid1 = bValid1
																				&& selectLength(
																						QlUomEdit,
																						"Quantity Length UOM"
																						);
																			  bValid1 = bValid1
																				&& checkLength(
																						qtyWeightEdit,
																						"Quantity Weight",
																						1,
																						16);
																			  bValid1 = bValid1
																				&& selectLength(
																						QwUomEdit,
																						"Quantity Weight UOM"
																						);
																			  

																			allFields
																					.removeClass("ui-state-error");
				

																			if (bValid1) {
																				
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddBankEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											
																											+ "<td><spring:bind path='GoodsReceiptCommand.materialidsEdit'><input  type='hidden' name='materialidsEdit' id='materialidsEdit"
																											+ btrid
																											+ "' value="
																											+ materialidsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='GoodsReceiptCommand.materialName'><input type='text' name='materialName' id='materialName"
																											+ btrid
																											+ "' value="
																											+$('#materialidsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											+ "<td><spring:bind path='GoodsReceiptCommand.batchNoEdit'><input name='batchNoEdit' id='batchNoEdit"
																											+ btrid
																											+ "' value="
																											+ batchNoEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+ "<td><spring:bind path='GoodsReceiptCommand.receivedQtyEdit'><input name='receivedQtyEdit' id='receivedQtyEdit"
																											+ btrid
																											+ "' value="
																											+ receivedQtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																										
																											+ "<td><spring:bind path='GoodsReceiptCommand.qtyuomsEdit'><input type='hidden' name='qtyuomsEdit' id='qtyuomsEdit"
																											+ btrid
																											+ "' value="
																											+ qtyuomsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='GoodsReceiptCommand.qtyUomName'><input type='text' name='qtyUomName' id='qtyUomName"
																											+ btrid
																											+ "' value="
																											+$('#qtyuomsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																										
																											
																										
																											+ "<td><spring:bind path='GoodsReceiptCommand.vendorMaterialNbrEdit'><input name='vendorMaterialNbrEdit' id='vendorMaterialNbrEdit"
																											+ btrid
																											+ "' value="
																											+ vendorMaterialNbrEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																										
																											+ "<td><spring:bind path='GoodsReceiptCommand.materialSpecsEdit'><input name='materialSpecsEdit' id='materialSpecsEdit"
																											+ btrid
																											+ "' value="
																											+ materialSpecsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																										     
																											
																											+ "<td><spring:bind path='GoodsReceiptCommand.storagelocsEdit'><input  type='hidden' name='storagelocsEdit' id='storagelocsEdit"
																											+ btrid
																											+ "' value="
																											+ storagelocsEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='GoodsReceiptCommand.storagelocName'><input type='text' name='storagelocName' id='storagelocName"
																											+ btrid
																											+ "' value="
																											+$('#storagelocsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																											
																											+ "<td><spring:bind path='GoodsReceiptCommand.qtyLengthEdit'><input name='qtyLengthEdit' id='qtyLengthEdit"
																											+ btrid
																											+ "' value="
																											+ qtyLengthEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																										
																											+ "<td><spring:bind path='GoodsReceiptCommand.QlUomEdit'><input type='hidden'name='QlUomEdit' id='QlUomEdit"
																											+ btrid
																											+ "' value="
																											+ QlUomEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='GoodsReceiptCommand.qtylname'><input type='text' name='qtylname' id='qtylname"
																											+ btrid
																											+ "' value="
																											+$('#QlUomEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																										
																											+ "<td><spring:bind path='GoodsReceiptCommand.qtyWeightEdit'><input name='qtyWeightEdit' id='qtyWeightEdit"
																											+ btrid
																											+ "' value="
																											+ qtyWeightEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																										
																											+ "<td><spring:bind path='GoodsReceiptCommand.QwUomEdit'><input type='hidden' name='QwUomEdit' id='QwUomEdit"
																											+ btrid
																											+ "' value="
																											+ QwUomEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											
																											+"<spring:bind path='GoodsReceiptCommand.qtywname'><input type='text' name='qtywname' id='qtywname"
																											+ btrid
																											+ "' value="
																											+$('#QwUomEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>"
																										
																											+"<input type='hidden' name='goodsReceiptLine_IdEdit' id='goodsReceiptLine_IdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																											
																											+
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
																							'#materialName'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#materialidsEdit :selected').text());

																					$(
																							'#batchNoEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#batchNoEdit')
																											.val());
																					
																					$(
																							'#receivedQtyEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#receivedQtyEdit')
																											.val());
																					$(
																							'#qtyuomsEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#qtyuomsEdit')
																											.val());
																					$(
																							'#qtyUomName'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#qtyuomsEdit :selected').text());
																					
																					
																					
																					
																					$(
																							'#vendorMaterialNbrEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#vendorMaterialNbrEdit')
																											.val());
																					$(
																							'#materialSpecsEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#materialSpecsEdit')
																											.val());
																					
																					
																					$(
																							'#storagelocsEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#storagelocsEdit')
																											.val());
																					$(
																							'#storagelocName'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#storagelocsEdit :selected').text());
																					
																					$(
																							'#qtyLengthEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#qtyLengthEdit')
																											.val());
																					$(
																							'#QlUomEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#QlUomEdit')
																											.val());
																					$(
																							'#qtylname'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#QlUomEdit :selected').text());
																					$(
																							'#qtyWeightEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#qtyWeightEdit')
																											.val());
																					$(
																							'#QwUomEdit'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#QwUomEdit')
																											.val());
																					$(
																							'#qtywname'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#QwUomEdit :selected').text());
																					$(
																							'#hiddenIdBankPopUpEdit')
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
											function removeBankDetailsEditNew(
													id) {
												alert('hello');
											$('#' + id).remove();
											}
											function editBankDetailsInEditNew(
													link) {
												
												$("#dialog-form-BankEdit")
														.dialog("open");
											
												
                                                var value = $.jStorage.get($('#materialidsEdit' + link).val());
                                                alert("value"+value);
                                                var recivqty=$('#receivedQtyEdit'+link).val();
                                                alert("recivqty:"+recivqty);
                                                var reQty=parseFloat(value)+parseFloat(recivqty);
                       						 alert("reQty:"+reQty);
												$('#materialidsEdit').val(
														$(
																'#materialidsEdit'
																		+ link)
																.val());
																
												$('#batchNoEdit').val(
														$(
																'#batchNoEdit'
																		+ link)
																.val());
												$('#availableQtyEdit').val(
														reQty);
												$('#receivedQtyEdit').val(
														$(
																'#receivedQtyEdit'
																		+ link)
																.val());
												$('#qtyuomsEdit').val(
														$(
																'#qtyuomsEdit'
																		+ link)
																.val());
												
												$('#vendorMaterialNbrEdit').val(
														$(
																'#vendorMaterialNbrEdit'
																		+ link)
																.val());
												$('#materialSpecsEdit').val(
														$(
																'#materialSpecsEdit'
																		+ link)
																.val());
												
												$('#storagelocsEdit').val(
														$(
																'#storagelocsEdit'
																		+ link)
																.val());
												$('#qtyLengthEdit').val(
														$(
																'#qtyLengthEdit'
																		+ link)
																.val());
												$('#QlUomEdit').val(
														$(
																'#QlUomEdit'
																		+ link)
																.val());
												$('#qtyWeightEdit').val(
														$(
																'#qtyWeightEdit'
																		+ link)
																.val());
												$('#QwUomEdit').val(
														$(
																'#QwUomEdit'
																		+ link)
																.val());
												
										
												$('#hiddenIdEditQPopUp')
														.val(link);

											}
										</script>


										<div id="dialog-form-BankEdit" title="Goods Receipt Line Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">
															
															  <tr>
												<td><spring:message code="label.prmaterial" /><font color="red">*</font></td>
												<td><form:select path="materialidsEdit" class="select" id="materialidsEdit" cssStyle="height:25px" onchange="loadMaterialsEdit()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
											</tr>
											<form:hidden path="materialHidden" id="materialHidden" value="0"/>
														<form:hidden path="qtyHidden" id="qtyHidden" />
														<form:hidden path="totHidden" id="totHidden" />
														<form:hidden path="lastValue" id="lastValue" />
														<form:hidden path="matids" id="matids" value="0" />
											<tr>
												<td>Batch Number</td>
												<td><form:input path="batchNoEdit" id="batchNoEdit"
															class="textbox" /></td></tr>
												 <tr>
												<td>Available Quantity<font color="red">*</font></td>
												<td><form:input path="avalQty" id="availableQtyEdit"
															class="textbox" readonly="true"/></td>
											</tr>		
											<tr>
												<td>Received Quantity<font color="red">*</font></td>
												<td><form:input path="receivedQtyEdit" id="receivedQtyEdit"
															class="textbox" onkeyup="qtyEdit()"/></td>
											</tr>
											
											<tr>
												<td>Quantity UOM<font color="red">*</font></td>
												<td><form:select path="qtyuomsEdit" class="select" id="qtyuomsEdit" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
											
											
											<tr>
												<td>Vendor Material Nbr<font color="red">*</font></td>
												<td><form:input path="vendorMaterialNbrEdit" id="vendorMaterialNbrEdit"
															class="textbox"/></td>
											</tr>
											<tr>
												<td>MaterialSpecs<font color="red">*</font></td>
												<td><form:input path="materialSpecsEdit" id="materialSpecsEdit"
															class="textbox"/></td>
											</tr>
											
											 <tr>
												<td>Storage Location<font color="red">*</font></td>
												<td><form:select path="storagelocsEdit" id="storagelocsEdit" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${storageId }" />
														</form:select></td>
											</tr> 
											<tr>
												<td>Quantity Length<font color="red">*</font></td>
												<td><form:input path="qtyLengthEdit" id="qtyLengthEdit"
															class="textbox"/></td>
											</tr>
											
											
											<tr>
												<td>Quantity Length UOM<font color="red">*</font></td>
												<td><form:select path="QlUomEdit" id="QlUomEdit" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
											<tr>
												<td>Quantity Weight<font color="red">*</font></td>
												<td><form:input path="qtyWeightEdit" id="qtyWeightEdit"
															class="textbox"/></td>
											</tr>
											<tr>
												<td>Quantity Weight UOM<font color="red">*</font></td>
												<td><form:select path="QwUomEdit" id="QwUomEdit" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select> 	
															
															
															
															
									<input type="hidden"
													name="hiddenIdEditQPopUp" id="hiddenIdEditQPopUp" value="0" /></td>
											</tr>
 										</table>
										</div>

										<div id="users-contain-BankEdit">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="AddBankEdit" class="table">
												<thead>
													<tr>
													
													      
													        <th><spring:message code="label.material" /><font color="red">*</font></th>
													        <th><spring:message code="label.BatchNo" /><font color="red">*</font></th>
															<th><spring:message code="label.receivedQuantity" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityUom" /><font color="red">*</font></th>
															<th><spring:message code="label.vendorMaterialNumber" /><font color="red">*</font></th>
															<th><spring:message code="label.materialSpecs" /><font color="red">*</font></th>
															<th><spring:message code="label.storageLocation" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityLength" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityLengthUom" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityWeight" /><font color="red">*</font></th>
															<th><spring:message code="label.quantityWeightUom" /><font color="red">*</font></th>
													
													
													
														
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="goodsReceiptLineEditList"
															items="${goodsReceiptLineEditList}">

															<c:set var="edit1" value="${goodsReceiptLineEditList.goodsReceiptLine_Id}"></c:set> 
														<%-- 	<c:if test="${edit1!=null}"> --%>
																<tr id="${goodsReceiptLineEditList.goodsReceiptLine_Id}">
																<spring:bind
																			path="GoodsReceiptCommand.goodsReceiptLine_IdEdit">
																			<input type="hidden" name="goodsReceiptLine_IdEdit"
																				class="textbox" 
																				value="${goodsReceiptLineEditList.goodsReceiptLine_Id}" id="goodsReceiptLine_IdEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}" />
																		</spring:bind>
																
																		
																																		
																		<spring:bind
																			path="GoodsReceiptCommand.materialidsEdit">
																			<input type="hidden" name="materialidsEdit"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.material_IdEdit}" id="materialidsEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}" />
																		</spring:bind>
																		<td><spring:bind
																			path="GoodsReceiptCommand.materialName">
																			<input type="text" name="materialName"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.materialName}" id="materialName${goodsReceiptLineEditList.goodsReceiptLine_Id}" />
																		</spring:bind></td>
																		<td><spring:bind
																			path="GoodsReceiptCommand.batchNoEdit">
																			<input type="text" name="batchNoEdit"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.batchNoEdit}" id="batchNoEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"/>
																		</spring:bind></td>
																	<spring:bind
																			path="GoodsReceiptCommand.stockEdit">
																			<input type="hidden" name="stockEdit"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.stockEdit}" id="stockEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"/>
																				
																		</spring:bind> 
																	 
																<td> <spring:bind
																			path="GoodsReceiptCommand.receivedQtyEdit">
																			<input type="text" name="receivedQtyEdit"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.receivedQtyEdit}"  id="receivedQtyEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"/>
																		</spring:bind></td>
																		
																	<spring:bind
																			path="GoodsReceiptCommand.qtyuomsEdit">
																			<input type="hidden" name="qtyuomsEdit"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.quantityUOMEdit}" id="qtyuomsEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"/>
																		</spring:bind>
																		<td><spring:bind
																			path="GoodsReceiptCommand.qtyUomName">
																			<input type="text" name="qtyUomName"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.qtyUomName}" id="qtyUomName${goodsReceiptLineEditList.goodsReceiptLine_Id}" />
																		</spring:bind></td>
																	
																		<td><spring:bind
																			path="GoodsReceiptCommand.vendorMaterialNbrEdit">
																			<input type="text" name="vendorMaterialNbrEdit" id="vendorMaterialNbrEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.vendorMaterialNbrEdit }" />
																		</spring:bind></td>
																		<td><spring:bind
																			path="GoodsReceiptCommand.materialSpecsEdit">
																			<input type="text" name="materialSpecsEdit" id="materialSpecsEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.materialSpecsEdit }" />
																		</spring:bind></td>
																		
																		<spring:bind
																			path="GoodsReceiptCommand.storagelocsEdit">
																			<input type="hidden" name="storagelocsEdit"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.storageLocationIdEdit}" id="storagelocsEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"/>
																		</spring:bind>
																		<td><spring:bind
																			path="GoodsReceiptCommand.storagelocName">
																			<input type="text" name="storagelocName"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.storagelocName}" id="storagelocName${goodsReceiptLineEditList.goodsReceiptLine_Id}" />
																		</spring:bind></td>
																		
																		<td><spring:bind
																			path="GoodsReceiptCommand.qtyLengthEdit">
																			<input type="text" name="qtyLengthEdit" id="qtyLengthEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.qtyLengthEdit }" />
																		</spring:bind></td>
																		<spring:bind
																			path="GoodsReceiptCommand.QlUomEdit">
																			<input type="hidden" name="QlUomEdit" id="QlUomEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.qtyLengthUOMEdit }" />
																		</spring:bind>
																		<td><spring:bind
																			path="GoodsReceiptCommand.qtylname">
																			<input type="text" name="qtylname"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.qtylname}" id="qtylname${goodsReceiptLineEditList.goodsReceiptLine_Id}" />
																		</spring:bind></td>
																		<td><spring:bind
																			path="GoodsReceiptCommand.qtyWeightEdit">
																			<input type="text" name="qtyWeightEdit" id="qtyWeightEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.qtyWeightEdit }" />
																		</spring:bind></td>
																		<spring:bind
																			path="GoodsReceiptCommand.QwUomEdit">
																			<input type="hidden" name="QwUomEdit" id="QwUomEdit${goodsReceiptLineEditList.goodsReceiptLine_Id}"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.qtyWeightUOMEdit }" />
																		</spring:bind>
																		<td><spring:bind
																			path="GoodsReceiptCommand.qtywname">
																			<input type="text" name="qtywname"
																				class="textbox" readonly="readonly"
																				value="${goodsReceiptLineEditList.qtywname}" id="qtywname${goodsReceiptLineEditList.goodsReceiptLine_Id}" />
																		</spring:bind>
																		
													<input type="hidden" name="${goodsReceiptLineEditList.goodsReceiptLine_Id}Check" id="${goodsReceiptLineEditList.goodsReceiptLine_Id}Check" value="0"/></td>
																		<td><a href="#"
															id="${goodsReceiptLineEditList.goodsReceiptLine_Id}"
															onclick="javascript:editBankDetailsInEdit(this)"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="${goodsReceiptLineEditList.goodsReceiptLine_Id}"></img></a></td>
														<td><a href="#"
															id="${goodsReceiptLineEditList.goodsReceiptLine_Id}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																id="${goodsReceiptLineEditList.goodsReceiptLine_Id}"></img></a></td>
																</tr>
		
														
														
															<script type="text/javascript">
																function getID1(
																		link) {
																	//alert(link.id);
																	alert("Deleting Particular Row Will Deleted Once You Click Ok");
																	 document
																			.getElementById(link.id
																					+ "Check").value = "1"; 
																	document
																			.getElementById(link.id).style.display = "none";
																}
																function editBankDetailsInEdit(
																		link) {
																	
																	/* alert("hai "+link.id); */
																	$(
																			"#dialog-form-BankEdit")
																			.dialog(
																					"open");
																	alert("hai");
																	var goodsReceipt = $('#goodsReceiptTypeNumEdit').val();
																	alert("goodsReceipt:"+goodsReceipt);
																	var material=$(
																			'#materialidsEdit'
																			+ link.id).val();
																	alert("material:"+material);
																	$.ajax({
																		type : "POST",
																		url : "poMaterialsDetails.mnt",
																		data : "goodsReceipt=" + goodsReceipt+ "&materials=" + material,
																		success : function(data) {
																			
																			$("#availableQtyEdit").val(data);
																			alert("the Quantity:"+$("#availableQtyEdit").val());
																	
																			
																		},
																		error : function(e) {
																			alert('Error: ' + e);
																		}

																	});
																
																	$('#materialidsEdit').val(
																			$(
																					'#materialidsEdit'
																							+ link.id)
																					.val());
																				
																	$('#batchNoEdit').val(
																			$(
																					'#batchNoEdit'
																							+ link.id)
																					.val());
																
																	
																	$('#receivedQtyEdit').val(
																			$(
																					'#receivedQtyEdit'
																							+ link.id)
																					.val());
																	
																	$('#qtyuomsEdit').val(
																			$(
																					'#qtyuomsEdit'
																							+ link.id)
																					.val());
																
																	
																					
																	$('#vendorMaterialNbrEdit').val(
																			$(
																					'#vendorMaterialNbrEdit'
																							+ link.id)
																					.val());
																	$('#materialSpecsEdit').val(
																			$(
																					'#materialSpecsEdit'
																							+ link.id)
																					.val());
																	$('#storagelocsEdit').val(
																			$(
																					'#storagelocsEdit'
																							+ link.id)
																					.val());
																	$('#qtyLengthEdit').val(
																			$(
																					'#qtyLengthEdit'
																							+ link.id)
																					.val());
																	$('#QlUomEdit').val(
																			$(
																					'#QlUomEdit'
																							+ link.id)
																					.val());
																	$('#qtyWeightEdit').val(
																			$(
																					'#qtyWeightEdit'
																							+ link.id)
																					.val());

																	$('#QwUomEdit').val(
																			$(
																					'#QwUomEdit'
																							+ link.id)
																					.val());
																	$('#hiddenIdEditQPopUp')
																			.val(
																					link.id);

																}
															</script>
														
												 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddBankEdit" type="button">Add New
											Goods Receipt Line</button>

									</div>

								</div>
								</div>
								
								<table>
									<tr>
										<td colspan=""><c:choose>
										<c:when test="${true}"><input type="submit"
											value="<spring:message code="label.update"/>"
											class="btn btn-primary" id="updateid" /></c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<spring:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
										</c:otherwise>

									</c:choose></td>

									</tr>

								</table>
								
								
								</div>
													</div>
			
		
							</form:form>
							</c:if>
							
								</div>
								
								</div>
							</div>
							 


</body>

</html>




