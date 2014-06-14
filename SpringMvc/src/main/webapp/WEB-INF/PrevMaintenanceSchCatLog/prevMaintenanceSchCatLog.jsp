<!-- @author Venkatesh -->
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
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
 <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 

	<script type="text/javascript" src="js/MntValidator.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						
						
						$('#subid')
								.click(
										function(event) {
											
											$('#addDeliveryform')
													.validate(
															{
																rules : {
																	prevMaintenanceSchCatId : {
																		required : true },
																		
																		maintainedBy:{
																			required : true,
																		},
																		maintenanceDT:{
																			required : true	
																		},
																		statusId:{
																			required : true	
																		},	
																},
																 messages : {
																	 prevMaintenanceSchCatId : 
																		 {
																		 required: "<font style='color: red;'><b>Prevent Maintenance Category is Required</b></font>",
																
																		 },
																		 maintainedBy : 
																			 {
																			 required: "<font style='color: red;'><b>Maintained By is Required</b></font>",
																			 },
																			 maintenanceDT : "<font style='color: red;'><b>Maintenance Date is Required</b></font>",
																			 statusId : "<font style='color: red;'><b>Status is Required</b></font>",	
																},
																
																	});
															});
									//	});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
									
											$('#editDeliveryForm')
													.validate(
															{
																rules : {
																	prevMaintenanceSchCatId : {
																		required : true },
																		
																		maintainedBy:{
																			required : true,
																		},
																		maintenanceDT:{
																			required : true	
																		},
																		statusId:{
																			required : true	
																		},	
																},
																messages : {
																	 prevMaintenanceSchCatId : 
																	 {
																	 required: "<font style='color: red;'><b>Prevent Maintenance Category is Required</b></font>",
																	 },
																	 maintainedBy : 
																		 {
																		 required: "<font style='color: red;'><b>Maintained By is Required</b></font>",
																		 },
																		 maintenanceDT : "<font style='color: red;'><b>Maintenance Date is Required</b></font>",
																		 statusId : "<font style='color: red;'><b>Status is Required</b></font>",	
															},
															});

										}); 
						
					});
					
					
					
					function doAjaxPost() {
						var  prevMtCat= $('#prevMaintenanceSchCatId').val();
						
						$('.loaderImage').show();
						if(prevMtCat!="")
							{
							$.ajax({
								type : "POST", 
								url : "prevMtAddDuplicate.mnt",
								data : "prevMtCat=" + prevMtCat,
								success : function(response) {
									$('.loaderImage').hide();
								
									//var checkResponse="Warning ! @Vendor@ Duplicate values are not allowed";
									if(response=="")
									{
									document.getElementById("prevMtLogMess").style.display="block";
									//$('#vendorDuplicateMess').html("Warning ! Vendor Name aleardy exists. Please try some other name");
									$('#subid').hide();
									}
									else
									{
									document.getElementById("prevMtLogMess").style.display="none";
									$('#subid').show();
									}
								},
								error : function(e) {
									//alert('Error: ' + e);
								}

							});
							}
						}
					
					
					function  doAjaxPostEdit()
					{
					var prevCatId=$('#prevMaintenanceSchCatIdEdit').val();
					var prevMtId=$('#prevMaintenanceSchCatLogIdEdit').val();
					if(prevCatId!="")
						{
							$.ajax({
							type : "POST",
							url : "prevMtUpdateDuplicate.mnt",
							data : "prevCatId=" + prevCatId+ "&prevMtId=" + prevMtId,
							success : function(response) {
								if(response=="")
								{
								document.getElementById("prevMtLogDuplicateMess").style.display="block";
								//$('#vendorDuplicateMessEdit').html(response);
								$('#updateid').hide();
								
								}
								else
								{
								document.getElementById("prevMtLogDuplicateMess").style.display="none";
								$('#updateid').show();
								}
							

							},

							error : function(e) {

							//	alert('Error: ' + e);

							}

						});
						}
						}

					
</script>

 <script >
function dateFun(datePattern) {
	$('#maintenanceDT,#maintenanceDTEdit').datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : datePattern

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
</script>

 <script type="text/javascript">
	$(document).ready(function() {
		$('#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();
			$('#prevMaintenanceSchCatId').val('');
			$('#maintenanceDT').val('');
			$('#maintainedBy').val('');
			$('#statusId').val('');
		

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
		$('#search').click(function(e) {
			$('#edit').hide();

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
</head>
<body>
<div class="loaderImage" style="display:none"><img src="images/loader.gif" ></img> </div>



	<div class="divUserDefault">
		<div class="PageTitle"><spring:message code="label.prevMaintenanceSchCatLog"/> </div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editValues}">
				
				
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
						<form:form action="prevMtSchCatSearch.mnt" method="GET"
						commandName="prevMtSchCatLog">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
                                      <strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.prevMaintenanceSchCatLog"/> <spring:message code="label.saveSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
                              <strong><spring:message code="label.error"/> </strong>
                              <spring:message code="label.prevMaintenanceSchCatLog"/> <spring:message code="label.saveFail"/>
											
										</div>
									</c:forEach><c:forEach items="${prevMtSchLogUpdate}">
										<div class="alert-success" id="successmessage">
										  <strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.prevMaintenanceSchCatLog"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach items="${prevMtSchLogUpdateFail}">
										<div class="alert-danger" id="successmessage">
											  <strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.prevMaintenanceSchCatLog"/> <spring:message code="label.updateFail"/>
										</div>
									</c:forEach>
									<c:forEach items="${prevMtLogDelete}">
										<div class="alert-success" id="successmessage">
										  <strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.prevMaintenanceSchCatLog"/> <spring:message code="label.deleteSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach items="${prevMtLogDeleteFail}">
										<div class="alert-danger" id="successmessage">
											  <strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.prevMaintenanceSchCatLog"/> <spring:message code="label.deleteFail"/>
										</div>
									</c:forEach>
									
									
									</td>
								
							</tr>
							<tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> 
									<form:select path="operations" cssClass="select">										
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<c:set
										var="save" value="true"></c:set> <c:set var="edit"
										value="true"></c:set> <c:set var="delete" value="true"></c:set>
									<c:set var="update" value="true"></c:set> <c:set var="search"
										value="true"></c:set> <fmt:setBundle basename="button" /> <fmt:message
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
									
								
								
								<td>
								<c:choose>
								<c:when test="${save }">
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
							<%-- <form:form action="brkDownMtLogSearch.mnt" method="get"
							commandName="prevMtSchCatLog" name="advanceSearchFinal">
							<tr>
								<td colspan="2"><a href="javascript: void(0);" id="advanceSearch"
									onclick="document.advanceSearchFinal.submit();return false;"><font
										style="color: blue"><u><b>Advanced Search</b></u></font></a> <a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							</tr>
						</form:form> --%>
						</table>
					
	        <%-- form:form action="IVSheduleAdvanceSearchOperations.mnt" commandName="prevMtSchCatLog">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${listofIVSchedule}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label> <form:hidden
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
												id="advanceSearch" /></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3">
									<c:choose>
									<c:when test="${search}">
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
					</form:form> --%>
			
					<c:if test="${prevMt!=null}">
					<div >
					
						<display:table id="prevMt" name="prevMt"
							requestURI="prevMtSchCatSearch.mnt" pagesize="5" class="table">
				
  <display:column property="prevMtName" titleKey="label.PrevMaintenance" media="html"
								sortable="true"></display:column> 
								<display:column property="maintenanceDT" titleKey="label.maintenanceDT" media="html"
								sortable="true"></display:column>
								<display:column property="maintainedBy" titleKey="label.maintainedBy" media="html"
								sortable="true"></display:column>
								<display:column property="statusName" titleKey="label.status" media="html"
								sortable="true"></display:column> 
								
							
								
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
								<a
									href="prevMtLogEdit.mnt?prevMtLogId=<c:out value="${prevMt.prevMaintenanceSchCatLogId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px" onclick="toggleTable();" 
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px" class="btn btn-danger" height="20px" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
							 <a
									href="prevLogDelete.mnt?prevMtLogId=<c:out value="${prevMt.prevMaintenanceSchCatLogId}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a> </c:when>
									<c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger"
									width="20px" height="20px"/>  </a>
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
					<form:form action="saveprevMtSchCatLog.mnt" method="POST"
							commandName="prevMtSchCatLog" id="addDeliveryform">
							<table class="tableGeneral">
                     <tr><td>
								<table class="tableGeneral">
					 <tr>
				
						<td colspan="4" id="prevMtLogMess" style="display: none;">
						<div class="alert-warning">
						<strong> <spring:message code="label.warning" /></strong>
						<spring:message code="label.prevMaintenanceSchCat" /> <spring:message code="label.duplicateCheck" />
						</div>
						</td>
						</tr> 
							<tr>
								<td><spring:message code="label.prevMaintenanceSchCat" /><span
									class="required">*</span> </td>
									<td>
									<form:select path="prevMaintenanceSchCatId" id="prevMaintenanceSchCatId" onchange="doAjaxPost()" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options items="${prevMtSchCatDetails}"/>
									</form:select>
									</td> </tr>
								<tr><td><spring:message code="label.maintenanceDT" /><span
									class="required">*</span></td>
									<td> 
									<form:input path="maintenanceDT" id="maintenanceDT" cssClass="textbox"/>
										
										</td></tr>
										<tr><td><spring:message code="label.maintainedBy" /><span
									class="required">*</span></td>
								<td> <form:input path="maintainedBy" id="maintainedBy" cssClass="textbox"/></td> </tr>
							
				
				<tr>
								<td><spring:message code="label.status" /><span
									class="required">*</span> </td>
									<td>
									<form:select path="statusId" id="statusId" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options items="${statusDetails}"/>
									</form:select>
									</td> </tr>
							</table>
							</td>

							</tr>
							</table>
						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1"><spring:message code="label.prevMtSchCatLogSpare" /></a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->
									
									<!-- <div align="center"> -->
								<script>
										var btrfqid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */
											
											
											var materialId = $("#materialId"), quantity = $("#quantity"),uomId=$("#uomId"), comments = $("#comments"), hiddenDeliveryID = $("#hiddenIdDeliveryPopUp")
											
											
											allFields = $([]).add(materialId).add(uomId).add(quantity).add(comments).add(hiddenDeliveryID),
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

											$("#dialog-form-Rfq")
													.dialog(
															{
																autoOpen : false,
																height : 250,
																width : 300,
																modal : true,
																buttons : {
																	Submit : function() {
																		
																		
																		allFields.removeClass("ui-state-error");
																		var bValid1 = true;	
																		  bValid1 = bValid1
																			&& checkLength1(
																					materialId,
																					
																					"Material is Required");
																		  bValid1 = bValid1
																			&& checkLength1(
																					uomId,
																					
																					"uomId is Required");
																		  bValid1 = bValid1
																			&& checkLength1(
																					quantity,/^([0-9.])+$/i,"quantity is Required And Must be  Number");
																		
																		
																		  
																			/* bValid1 = bValid1
																			&& checkLength1(
																					nextRound,/^([0-9.])+$/i,"Quantity is Required And Must be  Number"); */
																			
																					
																	 	if (bValid1) {
																	 	
																			
																			if (hiddenDeliveryID
																					.val() == "0"
																					|| hiddenDeliveryID
																							.val() == "") {
																				
																				$("#deliveryAdd tbody")
																						.append(
																								
																								"<tr id="+btrfqid+">"
																								+ "<td ><input type='hidden' name='materialId' id='materialId"
																								+ btrfqid
																								+ "' value="
																								+ materialId
																										.val()
																								+ " class='textbox'readonly/>"
																								+" <input type='text' readonly class='textbox' name='materialName' id='materialName"+btrfqid+"' value='"+$('#materialId :selected').text()+"'"
																								 +" /></td>" 
																								+ "<td><input type='text' name='quantity' id='quantity"
																								+ btrfqid
																								+ "' value="
																								+ quantity
																										.val()
																								+ "  class='textbox'readonly/></td>"
																								+ "<td><input type='hidden' name='uomId' id='uomId"
																								+ btrfqid
																								+ "' value="
																								+ uomId
																										.val()
																								+ " class='textbox'readonly/>"
																								+"<input type='text' readonly class='textbox' name='uomName' id='uomName"+btrfqid+"' value='"+$('#uomId :selected').text()+"'"
																								+"/></td>"
																								+"<td><a href='#'  onclick='editRfq("
																								+ btrfqid
																								+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																								+ "<td><a href='#'  onclick='removeRfq("
																								+ btrfqid
																								+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																								+ "</tr>");
																				
																				btrfqid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																	 	if (hiddenDeliveryID
																				.val() != "0") {
																			$(
																					'#materialId'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							materialId
																									.val());
																			
																			
																			
																			
																			
																			$(
																					'#materialName'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							$('#materialId :selected').text());
																		
																			$(
																					'#quantity'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							quantity
																									.val());
																			$(
																					'#uomId'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							uomId
																									.val());
																			$(
																					'#uomName'
																							+ hiddenDeliveryID
																									.val())
																					.val(
																							$('#uomId :selected').text());
																			
																		
																			
																			$(
																					'#hiddenIdDeliveryPopUp')
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

										
											$("#Rfqlineadd")
													.button()
													.click(
															function() {
																$("#dialog-form-Rfq")
																		.dialog(
																				"open");
																
															});
										});
										function removeRfq(id) {
								
											$('#' + id).remove();
										}
										function editRfq(id) {
										
											$("#dialog-form-Rfq").dialog("open");
										    $('#materialId').val($('#materialId' + id).val());
										  
											$('#quantity').val($('#quantity' + id).val());
											$('#uomId').val($('#uomId' + id).val());
											$('#hiddenIdDeliveryPopUp').val(id);
										
									}  
									
									</script> 


								  <div id="dialog-form-Rfq" align="center" title="Add New Prevent Maintenance Schedule Ctegory Spare Details">
										<p class="validateTips" align="center" ></p>
										<table class="tableGeneral" cellspacing=0>
				
											
											<tr>
												<td><spring:message code="label.material"/><span
									class="required">*</span> </td>
												<td>
										<form:select path="materialId" id="materialId"  cssClass="select" >
												<form:option value="">--Select--</form:option>
												<form:options items="${materialDetails}" />
												</form:select>
												
												</td>
												
											</tr>
											<tr>
												<td> <spring:message code="label.quantity"/><span
									class="required">*</span>
												</td>
												<td>
												<form:input path="quantity"  id="quantity" cssClass="textbox" />
<form:hidden path="aid" />
												 </td>
											</tr>
									         											<tr>
												<td><spring:message code="label.uom"/><span
									class="required">*</span></td>
												<td> <form:select path="uomId" id="uomId" cssClass="select">
 	                                         <form:option value="">--Select--</form:option>  
											<form:options items="${uomDetails}" />
												</form:select>
													  
													 <input type="hidden" 
													name="hiddenIdDeliveryPopUp" id="hiddenIdDeliveryPopUp" value="0" /> </td>
											</tr>
										</table>
									
									</div> 


									
								<div id="users-contain-Rfq">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="deliveryAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.material"/></th>
													<th><spring:message code="label.quantity"/></th>
													<th><spring:message code="label.uom"/> </th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
												
											</tbody> 
										</table>
										<button id="Rfqlineadd" type="button"><spring:message code="label.addprevMtSchCatLogSpare"/></button>
									</div> 
									
								<%-- <form:hidden path="deliveryhide" /> --%>

						<!-- 	</div>   -->
									
									
									
									
									
									
									
			
								
								<!-- </div> -->
							</div>
								
								
						</div>
							 <table>
										<tr>
											<td colspan="2">
											<c:choose>
											<c:when test="${update }">
											<input type="submit" value="<spring:message code="label.save"/>"
												class="btn btn-primary" id="subid" /><!-- <input type="reset"
												class="btn btn-primary" /> -->
												</c:when>
												<c:otherwise>
												<input type="submit" value="<spring:message code="label.save"/>" 
												class="btn btn-danger" disabled="disabled" id="subid" />
												</c:otherwise>
												</c:choose>
												<input type="reset" value="<spring:message code="label.reset"/>"  class="btn btn-primary" />
												 </td>
										</tr>
									
									</table> 
					</form:form>

				</div>
			</div>
			
			
			
			
			
	
		<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
				 <form:form action="updatePrevMtLog.mnt" method="POST"
						commandName="prevMtSchCatLog" id="editDeliveryForm">
					
						<c:if test="${editValues!=null}">

							
					
								<table class="tableGeneral">
					 <tr>
						<td colspan="4" id="prevMtLogDuplicateMess" style="display: none;">
						<div class="alert-warning">
						
						<strong> <spring:message code="label.warning" /></strong>
						<spring:message code="label.prevMaintenanceSchCat" /> <spring:message code="label.duplicateCheck" />
						</div>
						</td>
						</tr> 
							<tr>
								<td><spring:message code="label.prevMaintenanceSchCat" /><span
									class="required">*</span> </td>
									<td>
									<form:select path="prevMaintenanceSchCatId" id="prevMaintenanceSchCatIdEdit" onchange="doAjaxPostEdit()" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options items="${prevMtSchCatDetails}"/>
									</form:select>
									</td> </tr>
								<tr><td><spring:message code="label.maintenanceDT" /><span
									class="required">*</span></td>
									<td> 
									<form:input path="maintenanceDT" id="maintenanceDTEdit" cssClass="textbox"/>
										</td></tr>
										<tr><td><spring:message code="label.maintainedBy" /><span
									class="required">*</span></td>
								<td> <form:input path="maintainedBy" id="maintainedByEdit" cssClass="textbox"/></td> </tr>
							
				
				<tr>
								<td><spring:message code="label.status" /><span
									class="required">*</span> </td>
									<td>
									<form:select path="statusId" id="statusIdEdit" cssClass="select">
									<form:option value="">--Select--</form:option>
									<form:options items="${statusDetails}"/>
									</form:select>
									</td> <form:hidden path="prevMaintenanceSchCatLogId"  id="prevMaintenanceSchCatLogIdEdit"/>	
									
									 </tr>
							</table>
							
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1"><spring:message code="label.prevMtSchCatLogSpare" /></a></li>

								</ul>
								
								
                         <div align="center">

								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->
									
									<!-- <div align="center"> -->
									
									<script>
										var btrfqid = 0;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */
											
											
											var materialIdEdit = $("#materialIdEdit"),uomIdEdit=$("#uomIdEdit"), quantityEdit = $("#quantityEdit"), ehiddenrfqID = $("#hiddenIddeliveryeditPopUp");
											
											allFields = $([]).add(materialIdEdit).add(uomIdEdit).add(quantityEdit).add(ehiddenrfqID),
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

											$("#dialog-form-RfqEdit")
													.dialog(
															{
																autoOpen : false,
																height : 250,
																width : 300,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid2 = true;
																		bValid2 = bValid2
																			&& checkLength2(
																					materialIdEdit,
																					
																					"Material is Required");
																		bValid2 = bValid2
																			&& checkLength2(
																					uomIdEdit,
																					
																					"Uom is Required");
																		bValid2 = bValid2
																			&& checkLength2(
																					quantityEdit,/^([0-9.])+$/i,"quantity is Required And Must be  Number");
																		
																		
															 if(bValid2){
																	
																																
																			if (ehiddenrfqID
																					.val() == "0"
																					|| ehiddenrfqID
																							.val() == "") {
																				 $("#RFQEdit tbody")
																						.append(
																								"<tr id="+btrfqid+">"
																										+ "<td ><spring:bind path='prevMtSchCatLog.prevMtSchCatLogSpareIdEdit' ><input type='hidden'name='prevMtSchCatLogSpareIdEdit'  value='0'/> <input type='hidden' name='materialIdEdit' id='materialIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ materialIdEdit
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  "
																										+"<spring:bind path='prevMtSchCatLog.materialName'><input type='text'class='textbox' name='materialName' id='materialName"+btrfqid+"' value='"+$('#materialIdEdit :selected').text()+"'"
																										+"</spring:bind></td>"
																										
																									 + "<td><spring:bind path='prevMtSchCatLog.quantityEdit'><input type='text' name='quantityEdit' id='quantityEdit"
																										+ btrfqid
																										+ "' value="
																										+ quantityEdit
																												.val()
																										+ " class='textbox'readonly/></spring:bind>" 
																										
																										+"</td>"
																										+ "<td ><spring:bind path='prevMtSchCatLog.uomIdEdit' ><input type='hidden' name='uomIdEdit' id='uomIdEdit"
																										+ btrfqid
																										+ "' value="
																										+ uomIdEdit
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  "
																										+"<spring:bind path='prevMtSchCatLog.uomName'><input type='text'class='textbox' name='uomName' id='uomName"+btrfqid+"' value='"+$('#uomIdEdit :selected').text()+"'"
																										+"</spring:bind></td>"
																										
																										+ "<input type='hidden' name='prevMtSchCatLogSpareIdEdit' value='0' id='prevMtSchCatLogSpareIdEdit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/>"
																										 
																										
																										// "<td>" + password.val() + "</td>" +
																										+"<td><a href='#'  onclick='editRfqEdit("
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
																				$('#materialIdEdit'+ ehiddenrfqID.val()).val(materialIdEdit.val());
																				$('#materialName'+ ehiddenrfqID.val()).val($('#materialIdEdit :selected').text());
																				$('#uomIdEdit'+ ehiddenrfqID.val()).val(uomIdEdit.val());
																				$('#uomName'+ ehiddenrfqID.val()).val($('#uomIdEdit :selected').text());
																				$('#quantityEdit'+ ehiddenrfqID.val()).val(quantityEdit.val()); 
																				$('#hiddenIddeliveryeditPopUp').val("0");
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

										
											$("#AddRFQEdit")
													.button()
													.click(
															function() {
																$("#dialog-form-RfqEdit")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeRfqEdit(id) {
									
											$('#' + id).remove();
										}
										
										function editRfqEdit(id) {
									
										
											

											$("#dialog-form-RfqEdit").dialog(
													"open");
										
											
											$('#materialIdEdit').val(
													$('#materialIdEdit' + id).val());
										
											$('#uomIdEdit').val(
													$('#uomIdEdit' + id)
															.val());
											$('#quantityEdit').val(
													$('#quantityEdit' + id).val()); 
											
									
										$('#hiddenIddeliveryeditPopUp').val(id);
										// document.getElementById("").value="edit";
									}
									</script> 


								 <div id="dialog-form-RfqEdit" align="center" title="Add New BreakDown Maintenance Spare Details">
										<p class="validateTips" align="center" ><font color="red">All form fields are required</font></p>
										<table class="tableGeneral" cellspacing=0>
                     <form:hidden path="prevMtSchCatLogSpareIdEdit" id="prevMtSchCatLogSpareIdEdit" value="0"/>   
								<tr>
												<td><spring:message code="label.material"/><span
									class="required">*</span> </td>
												<td>
										<form:select path="materialIdEdit" id="materialIdEdit"  cssClass="select" >
												<form:option value="">--Select--</form:option>
												<form:options items="${materialDetails}" />
												</form:select>
												  <input type="hidden" name="hiddenIddeliveryeditPopUp" id="hiddenIddeliveryeditPopUp" value="0" /> 
												</td>
												
											</tr>
			
												<tr>
												<td> <spring:message code="label.quantity"/><span
									class="required">*</span>
												</td>
												<td>
												<form:input path="quantityEdit"  id="quantityEdit" cssClass="textbox" />

												 </td>
											</tr>
											
																	<tr>
												<td><spring:message code="label.uom"/><span
									class="required">*</span></td>
												<td> <form:select path="uomIdEdit" id="uomIdEdit" cssClass="select">
 	                                         <form:option value="">--Select--</form:option>  
											<form:options items="${uomDetails}" />
												</form:select>
													  
											 </td>
											</tr>
										</table>
									</div> 


									
									<div id="users-contain-Process">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="RFQEdit" class="table">
											<thead>
												<tr>
	                                            <th><spring:message code="label.material"/></th>
	                                           
													<th><spring:message code="label.quantity"/></th>
													 <th><spring:message code="label.uom"/> </th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${brkdownSpareDetails}"
												var="brkdownSpareDetails">
                                                
                                              
                                                
                                               <spring:bind path="prevMtSchCatLog.prevMtSchCatLogSpareIdEdit">
															<input type="hidden" name="prevMtSchCatLogSpareIdEdit" id="prevMtSchCatLogSpareIdEdit${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}"
																value="${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}"  />
														</spring:bind>
                                                
												
													
						
	                                                <tr id="${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}">
												<spring:bind path="prevMtSchCatLog.materialIdEdit">
															<input type="hidden" name="materialIdEdit"  class="textbox" id="materialIdEdit${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}"
																value="${brkdownSpareDetails.materialIdEdit}"  />
														</spring:bind>														
													
													<td>	<spring:bind path="prevMtSchCatLog.materialName">
															<input type="text" name="materialName"  class="textbox" id="materialName${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}"
																value="${brkdownSpareDetails.materialName}"  />
														</spring:bind>
														
														</td>
													
																


														<td>
														
														
													<spring:bind path="prevMtSchCatLog.uomIdEdit">
															<input type="hidden" name="uomIdEdit" id="uomIdEdit${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}"
																class="textbox"
																value="${brkdownSpareDetails.uomIdEdit}" readonly="readonly" />
														</spring:bind>
														
														<spring:bind path="prevMtSchCatLog.quantityEdit">
															<input type="text" name="quantityEdit" id="quantityEdit${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}"
																class="textbox"
																value="${brkdownSpareDetails.quantityEdit}" readonly="readonly"/>
														</spring:bind>
														</td>
														
													<td>
															
														<spring:bind path="prevMtSchCatLog.uomName">
															<input type="text" name="uomName" id="uomName${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}"
																class="textbox"
																value="${brkdownSpareDetails.uomName}" readonly="readonly" />
														</spring:bind>
														<input type="hidden" name="Checkdelete${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}" id="${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}Checkdelete" value="0"/></td>
													<td><a href='#' id="${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}" onclick="editRfqEdit(this.id)"><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>
													<td><a href='#' id="${brkdownSpareDetails.prevMtSchCatLogSpareIdEdit}" onclick="getID11(this)"><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>
												</tr>

												
															
															<script type="text/javascript">
																function getID11(
																		link) {
													
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link.id+"Checkdelete").value = "1";
																	document
																			.getElementById(link.id).style.display = "none";
																}
																function editProcessDetailsInEdit(link) {
																
																	$(
																			"#dialog-form-RfqEdit")
																			.dialog(
																					"open");
																	$(
																			'#materialIdEdit'+link.id)
																			.val(
																					$(
																							'#materialIdEdit').val());
															
																	$('#uomIdEdit')
																			.val($('#uomIdEdit'+ link.id).val());
																	$('#quantityEdit')
																			.val(
																					$('#quantityEdit'
																									+ link.id)
																							.val());
																	

																	$('#hiddenIddeliveryeditPopUp')
																			.val(
																					link.id);

																}
															</script>
														
											</c:forEach>
											</tbody>
										</table>
										<button id="AddRFQEdit" type="button"><spring:message code="label.addprevMtSchCatLogSpare"/> </button>
									</div>
									
									</div> 
								
							</div>
							
							<table>
								<tr>
									<td colspan="2" align="center">
									<c:choose>
									<c:when test="${true }">
									
									<input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-primary" id="updateid" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/>" class="btn btn-danger" id="updateido" />
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
			
			
			
		