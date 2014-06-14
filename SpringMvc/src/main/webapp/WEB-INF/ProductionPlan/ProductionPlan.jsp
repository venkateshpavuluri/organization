<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script>
	$(function() {
		$("#tabs").tabs();
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
<!--  Date picker -->

<script type="text/javascript">
function dateFun(datePattern) {
	$('#planDate,#planDateEdit,#startDT,#finishDT,#startDTEdit,#finishDTEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submit')
								.click(
										function(event) {

											$('#addform')
													.validate(
															{
																rules : {
																	productionPlanType_Id : {
																		required : true
																	},
																	planDate : {
																		required : true
																	},
																	
																	plant_Id : {
																		required : true
																	},
																	project_Id : {
																		required : true
																	},
																	status_Id : {
																		required : true
																	},
																	
																	
																	

																},
																messages : {
																	productionPlanType_Id : "<font style='color: red;'><b>Production Plan Type is Required</b></font>",

																	planDate : "<font style='color: red;'><b>Plan Date is Required</b></font>",

																	plant_Id : "<font style='color: red;'><b>Plant is Required</b></font>",

																	project_Id : "<font style='color: red;'><b>Project is Required</b></font>",

																	status_Id : "<font style='color: red;'><b>Status is Required</b></font>",

																	

																	


																}
															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											
											//alert(assetedit);
											$('#editForm')
													.validate(
															{
																rules : {
																	productionPlanType_IdEdit : {
																		required : true
																	},
																	planDateEdit : {
																		required : true
																	},
																	
																	plant_IdEdit : {
																		required : true
																	},
																	project_IdEdit : {
																		required : true
																	},
																	status_IdEdit : {
																		required : true
																	},
																},
																messages : {
																	productionPlanType_IdEdit : "<font style='color: red;'><b>Production Plan Type is Required</b></font>",

																	planDateEdit : "<font style='color: red;'><b>Plan Date is Required</b></font>",

																	plant_IdEdit : "<font style='color: red;'><b>Plant is Required</b></font>",

																	project_IdEdit : "<font style='color: red;'><b>Project is Required</b></font>",

																	status_IdEdit : "<font style='color: red;'><b>Status is Required</b></font>",

 
																},
															});

										});

					});
</script>


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




</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Production Plan</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="productionPlanEdit" items="${productionPlanEdit}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!-- Tab-2 -->

			<div id="tabs-2" class="TabbedPanelsContent">
			<div align="left" class="TabbedPanelsContent">
					<form:form method="get" action="productionPlanSearch.mnt"
						commandName="productionPlanCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="prodPlanAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.productionPlan"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
								<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.productionPlan"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="proPlanUpdate"
										items="${proPlanUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.productionPlan"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
								<c:forEach var="proPlanUpdateError"
										items="${proPlanUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.productionPlan"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="prodPlanDelete"
										items="${prodPlanDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.productionPlan"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="prodPlanDeleteError"
										items="${prodPlanDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.productionPlan"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="0">-Select-</form:option>
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
										<c:when test="${search}">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>

                   <c:forEach var="productionPlan" items="${productionPlan}">

						<c:set var="as" value="${productionPlan}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">

					<display:table name="productionPlan" id="productionPlan" class="table"
						requestURI="productionPlanSearch.mnt" pagesize="5">
						<display:column property="productionPlanTypeName" sortable="true"
							titleKey="label.productionPlanType" media="html" />
						<display:column property="planDate" sortable="true"
							titleKey="label.plandate" media="html" />
						<display:column property="plantName" sortable="true"
							titleKey="label.plant" media="html" />
						<display:column property="projectName" sortable="true"
							titleKey="label.project" media="html" />
						<display:column property="statusName" sortable="true"
							titleKey="label.status" media="html" />
					
						<display:column titleKey="label.edit">
						<c:choose>
							<c:when test="${edit }">
							<a
								href="productionPlanEdit.mnt?productionPlanId=<c:out value="${productionPlan.productionPlan_Id}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
								</c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
								
						</display:column>
						<display:column titleKey="label.delete">
						<c:choose>
							<c:when test="${delete }">
							<a
								href="productionPlanDelete.mnt?productionPlanId=<c:out value="${productionPlan.productionPlan_Id}"/> "
								onclick="return confirm('Do You Want To Delete This Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
								</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
							</c:otherwise>
							</c:choose>
						</display:column>

						<display:setProperty name="paging.banner.placement" value="bottom" />
					</display:table>

</c:if>

				</div>

			</div>

			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form commandName="productionPlanCommand" id="addform" method="POST"
						action="productionPlanAdd.mnt">
						<table class="tableGeneral">
						<tr>
						<td><spring:message code="label.productionPlanType"></spring:message><font
									color="red">*</font></td>
								
								<td><form:select path="productionPlanType_Id" id="productionPlanType_Id" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${productionPlanType }" />
									</form:select></td>
						</tr>
							<tr>
								<td><spring:message code="label.plandate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="planDate" id="planDate" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.plant"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="plant_Id" id="plant_Id"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${plant }" />
									</form:select></td>
                                  
							</tr>
							
								<tr>
							
                                 <td><spring:message code="label.project"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="project_Id" id="project_Id" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${project }" />
									</form:select></td>
                                    

							</tr>
							<tr>
							
                                 <td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="status_Id" id="status_Id" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                    

							</tr>

							
                              
</table>

					 		<div id="tabsForAdd">
								<!-- Employee Manager tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.productionPlanLine" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
										var btproplanid = 1;
										$(function() {

											var 
											material_Id = $("#material_Id"), 
										    mvalue=$("#mNumber"),
										    qty=$("#qty"),
										    
										    uOM_Id = $("#uOM_Id"), 
											uvalue=$("#uNumber"), 
											startDT = $("#startDT"),
											finishDT=$("#finishDT"),
											productionOrder_Id = $("#productionOrder_Id"), 
												pvalue=$("#pNumber"), 
											
											hiddenProPlanID = $("#hiddenProPlanPopUp"),
											
											
											
											allFields = $([]).add(material_Id).add(mvalue).add(qty).add(uOM_Id).add(uvalue).add(startDT).add(finishDT).add(productionOrder_Id).add(pvalue).add(hiddenProPlanID),
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
											$("#dialog-form-emp")
													.dialog(
															{
																autoOpen : false,
																height : 270,
																width : 300,
																modal : true,
																buttons : {
																	Submit : function() {
																		
																		var bValid1 = true;
																		allFields.removeClass("ui-state-error");
                                    								
																		
																	  bValid1 = bValid1
																		&& selectLength(
																				material_Id,
																				"Material"
																				);
																		bValid1 = bValid1
																		&& checkLength(
																				qty,
																				"Quantity",
																				1,
																				16);
																		 
																		bValid1 = bValid1
																			&& selectLength(
																					uOM_Id,
																					"Uom"
																					);
																		bValid1 = bValid1
																		&& checkLength(
																				startDT,
																				"Start Date",
																				1,
																				16);
																		 
																		 
																		 bValid1 = bValid1
																			&& checkLength(
																					finishDT,
																					"Finish Date",
																					1,
																					16);
																					
																			/* bValid1 = bValid1
																			&& selectLength(
																					productionOrder_Id,
																					"Production Order Number"
																					); */
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenProPlanID
																					.val() == "0"
																					|| hiddenProPlanID
																							.val() == "") {
																				
																				var ff= $('#productionOrder_Id :selected').text();
																				if(ff=="--Select--")
																					{
																					ff=0;
																					
																					}
																				$("#proPlanAdd tbody")
																						.append(
																								"<tr id="+btproplanid+">"
																								
																								+ "<td ><spring:bind path='productionPlanCommand.material_Id'><input type='hidden' name='material_Id' id='material_Id"
																								+ btproplanid
																								+ "' value="
																								+ material_Id
																										.val()
																								+ " class='textbox'/></spring:bind> <input type='text' name='mNumber' id='mNumber"
																								+ btproplanid
																								+ "' value="
																								+ $('#material_Id :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																								+ "<td align='center'><input type='text' name='qty' id='qty"
																							      + btproplanid
																							     + "' value="
																							     + qty
																									.val()
																							     + "  class='textbox'readonly/></td>"
																								+ "<td ><spring:bind path='productionPlanCommand.uOM_Id'><input type='hidden' name='uOM_Id' id='uOM_Id"
																								+ btproplanid
																								+ "' value="
																								+ uOM_Id
																										.val()
																								+ " class='textbox'/></spring:bind> <input type='text' name='uNumber' id='uNumber"
																								+ btproplanid
																								+ "' value="
																								+ $('#uOM_Id :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>" 
																								     + "<td align='center'><input type='text' name='startDT' id='startDT"
																								      + btproplanid
																								     + "' value="
																								     + startDT
																										.val()
																								     + "  class='textbox'readonly/></td>"
																										+ "<td align='center'><input type='text' name='finishDT' id='finishDT"
																										+ btproplanid
																										+ "' value="
																										+ finishDT
																												.val()
																										+ "  class='textbox'readonly/></td>"
																										
																										+ "<td ><spring:bind path='productionPlanCommand.productionOrder_Id'><input type='hidden' name='productionOrder_Id' id='productionOrder_Id"
																										+ btproplanid
																										+ "' value="
																										+ productionOrder_Id
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='pNumber' id='pNumber"
																										+ btproplanid
																										+ "' value="
																										+ff
																										
																										+ " class='textbox'readonly/></td>" 
																									    +"<td><a href='#'  onclick='editemp("
																										+ btproplanid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btproplanid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btproplanid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenProPlanID
																					.val() != "0") {
																				
																				
																			 $(
																						'#material_Id'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								material_Id
																										.val());
																				$(
																						'#mNumber'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								 $('#material_Id :selected').text());
																				
																				$(
																						'#qty'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								qty
																										.val());
																				
																				$(
																						'#uOM_Id'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								uOM_Id 
																								        .val());
																				$(
																						'#uNumber'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								 $('#uOM_Id :selected').text());
																				 
																				$(
																						'#startDT'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								startDT
																										.val());
																				
																				$(
																						'#finishDT'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								finishDT
																										.val());
																				
																				
																				$(
																						'#productionOrder_Id'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								productionOrder_Id 
																								        .val());
																				$(
																						'#pNumber'
																								+ hiddenProPlanID
																										.val())
																						.val(
																								 $('#productionOrder_Id :selected').text());
																				
																				$(
																						'#hiddenProPlanPopUp')
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

										
											$("#Addemp")
													.button()
													.click(
															function() {
															
																$("#dialog-form-emp")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editemp(id) {
											//alert("edit row " + id);
											$("#dialog-form-emp").dialog("open");
								
											$('#material_Id').val(
													$('#material_Id' + id).val());
											$('#mNumber').val(
													$('#mNumber' + id).val());
											$('#qty').val($('#qty' + id).val());
											$('#uOM_Id').val(
													$('#uOM_Id' + id).val());
											$('#uNumber').val(
													$('#uNumber' + id).val()); 
											$('#startDT').val($('#startDT' + id).val());
											$('#finishDT').val($('#finishDT' + id).val());
											$('#productionOrder_Id').val(
													$('#productionOrder_Id' + id).val());
											$('#pNumber').val(
													$('#pNumber' + id).val()); 
											$('#hiddenProPlanPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-emp" title="Add New Production Plan Line Details">
										<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
										<table class="tableGeneral">
												<tr><td></td></tr>
                                              <tr><td></td></tr>
															 
														<tr>	 	
												<td><spring:message code="label.material" /><font color="red">*</font></td>
											<td><form:select path="material_Id" id="material_Id" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${material}" /> 
													
												</form:select></td>
															</tr>
															
															 <tr>
												<td><spring:message code="label.qty" /><font color="red">*</font></td>
												<td><form:input path="qty" id="qty"
															class="textbox"/>
															</td>
															</tr>
                                           <tr>
												<td><spring:message code="label.uom" /><font color="red">*</font></td>
											<td><form:select path="uOM_Id" id="uOM_Id" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${uom}" /> 
													
												</form:select></td>
															</tr> 
											
																 <tr>
												<td><spring:message code="label.startDate" /><font color="red">*</font></td>
												<td><form:input path="startDT" id="startDT"
															class="textbox"/>
															</td>
															</tr>
											
											<tr>
												<td><spring:message code="label.finishDate" /><font color="red">*</font></td>
												<td><form:input path="finishDT" id="finishDT"
															class="textbox"/></td>
															</tr>
														<tr>
												<td><spring:message code="label.productionOrderNum" /><font color="red">*</font></td>
											<td><form:select path="productionOrder_Id" id="productionOrder_Id" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${productionOrderNum}" /> 
													
												</form:select>	
											<input type="hidden"
													name="hiddenProPlanPopUp" id="hiddenProPlanPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="proPlanAdd" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.material" /><font color="red">*</font></th>
													<th><spring:message code="label.qty" /><font color="red">*</font></th>
													<th><spring:message code="label.uom" /><font color="red">*</font></th>
													<th><spring:message code="label.startDate" /><font color="red">*</font></th>
													<th><spring:message code="label.finishDate" /><font color="red">*</font></th>
													<th><spring:message code="label.productionOrderNum" /><font color="red">*</font></th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="Addemp" type="button">Add New Production Plan</button>
									

								</div>
							</div>
							</div>
							 <c:choose>
									<c:when test="${save}">
						<input type="submit" id="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary"/></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" />
						
					</form:form>

				</div>
			</div>

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="productionPlanEdit" items="${productionPlanEdit}">

						<form:form method="post" action="productionPlanUpdate.mnt"
							commandName="productionPlanCommand" id="editForm">
							<table class="tableGeneral">


								<form:hidden path="productionPlan_IdEdit" id="productionPlan_IdEdit" />
                               
                               <tr>
						<td><spring:message code="label.productionPlanType"></spring:message><font
									color="red">*</font></td>
								
								<td><form:select path="productionPlanType_IdEdit" id="productionPlanType_IdEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${productionPlanType }" />
									</form:select></td>
						</tr>
							<tr>
								<td><spring:message code="label.plandate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="planDateEdit" id="planDateEdit" class="textbox" /></td>
							
                                </tr>
                                <tr>
							<td><spring:message code="label.plant"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="plant_IdEdit" id="plant_IdEdit"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${plant }" />
									</form:select></td>
                                  
							</tr>
							
								<tr>
							
                                 <td><spring:message code="label.project"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="project_IdEdit" id="project_IdEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${project }" />
									</form:select></td>
                                    

							</tr>
							<tr>
							
                                 <td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="status_IdEdit" id="status_IdEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                    

							</tr>


							</table>
							
								<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.productionPlanLine" /></a></li>

								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {

												var 
												material_IdEdit=$("#material_IdEdit"),
												qtyEdit=$("#qtyEdit"),
												uOM_IdEdit = $("#uOM_IdEdit"),
												startDTEdit = $("#startDTEdit"),
												finishDTEdit=$("#finishDTEdit"),
												productionOrder_IdEdit=$("#productionOrder_IdEdit"),
												hiddenEdit = $("#hiddenProPlanPopUpEdit"),
												
												allFields = $([]).add(material_IdEdit).add(qtyEdit).add(uOM_IdEdit).add(startDTEdit).add(finishDTEdit).add(productionOrder_IdEdit)
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

												$("#dialog-form-EmpEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 310,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");
																			
																			
																			bValid1 = bValid1
																			&& selectLength(
																					material_IdEdit,
																					"Material"
																					);
																			bValid1 = bValid1
																			&& checkLength(
																					qtyEdit,
																					"Quantity",
																					1,
																					16);
																			 
																			bValid1 = bValid1
																				&& selectLength(
																						uOM_IdEdit,
																						"Uom"
																						);
																			bValid1 = bValid1
																			&& checkLength(
																					startDTEdit,
																					"Start Date",
																					1,
																					16);
																			 
																			 
																			 bValid1 = bValid1
																				&& checkLength(
																						finishDTEdit,
																						"Finish Date",
																						1,
																						16);
																						
																				/* bValid1 = bValid1
																				&& selectLength(
																						productionOrder_IdEdit,
																						"Production Order Number"
																						); */

																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					var fff= $('#productionOrder_IdEdit :selected').text();
																					alert("value:"+fff);
																					if(fff=="--Select--")
																						{
																						fff=0;
																						
																						}
																					$(
																							
																							"#AddEmpEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='productionPlanCommand.productionPlanLine_IdEditt'><input type='hidden' name='productionPlanLine_IdEditt' id='productionPlanLine_IdEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																											+ "<spring:bind path='productionPlanCommand.material_IdEdit'><input type='hidden' name='material_IdEdit' id='material_IdEdit"
																											+ btrid
																											+ "' value="
																											+ material_IdEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='productionPlanCommand.materialName'><input type='text' name='materialName' id='materialName"
																											+ btrid
																											+ "' value="
																											+$('#material_IdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																											
																											+ "<td><spring:bind path='productionPlanCommand.qtyEdit'><input name='qtyEdit' id='qtyEdit"
																											+ btrid
																											+ "' value="
																											+ qtyEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											
																											 + "<td><spring:bind path='productionPlanCommand.uOM_IdEdit'><input type='hidden' name='uOM_IdEdit' id='uOM_IdEdit"
																												+ btrid
																												+ "' value="
																												+ uOM_IdEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind>"
																												+"<spring:bind path='productionPlanCommand.uomName'><input type='text' name='uomName' id='uomName"
																												+ btrid
																												+ "' value="
																												
																												+$('#uOM_IdEdit :selected').text()
																												+ " class='textbox' readonly/></spring:bind></td>" 
																										+ "<td><spring:bind path='productionPlanCommand.startDTEdit'><input name='startDTEdit' id='startDTEdit"
																										+ btrid
																										+ "' value="
																										+ startDTEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind> </td>"
																										+ "<td><spring:bind path='productionPlanCommand.finishDTEdit'><input name='finishDTEdit' id='finishDTEdit"
																										+ btrid
																										+ "' value="
																										+ finishDTEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind> </td>"
																										
																										 + "<td><spring:bind path='productionPlanCommand.productionOrder_IdEdit'><input type='hidden' name='productionOrder_IdEdit' id='productionOrder_IdEdit"
																											+ btrid
																											+ "' value="
																											+ fff
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='productionPlanCommand.productionOrderNumber'><input type='text' name='productionOrderNumber' id='productionOrderNumber"
																											+ btrid
																											+ "' value="
																											
																											+$('#productionOrder_IdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																									 	
																											+"<input type='hidden' name='productionPlanLine_IdEdit' id='productionPlanLine_IdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+
																											// "<td>" + password.val() + "</td>" +
																											"<td><a href='#'  onclick='editEmpDetailsInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeEmpDetailsEditNew'("
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
																					.val() != 0) {
																			
																				
																				$(
																						'#material_IdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#material_IdEdit')
																										.val());
																				$(
																						'#materialName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#material_IdEdit :selected').text()); 
																				
																				$(
																						'#qtyEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#qtyEdit')
																										.val());
																				$(
																						'#uOM_IdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#uOM_IdEdit')
																										.val());
																				$(
																						'#uomName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#uOM_IdEdit :selected').text());
																				$(
																						'#startDTEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#startDTEdit')
																										.val());
																				$(
																						'#finishDTEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#finishDTEdit')
																										.val());
																				
																				$(
																						'#productionOrder_IdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#productionOrder_IdEdit')
																										.val());
																				$(
																						'#productionOrderNumber'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#productionOrder_IdEdit :selected').text());
																				
																				$(
																						'#hiddenProPlanPopUpEdit')
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

												$("#create-AddEmpEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-EmpEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(
													id) {
											
												$('#' + id).remove();
											}
											function editEmpDetailsInEditNew(
													link) {
												
												
												$("#dialog-form-EmpEdit")
														.dialog("open");
												
										
												$('#material_IdEdit').val(
														$(
																'#material_IdEdit'
																		+ link)
																.val());
												$('#qtyEdit').val(
														$(
																'#qtyEdit'
																		+ link)
																.val());
												$('#uOM_IdEdit').val(
														$(
																'#uOM_IdEdit'
																		+ link)
																.val());
												
												$('#startDTEdit').val(
														$(
																'#startDTEdit'
																		+ link)
																.val());
												$('#finishDTEdit').val(
														$(
																'#finishDTEdit'
																		+ link)
																.val());
												
												$('#productionOrder_IdEdit').val(
														$(
																'#productionOrder_IdEdit'
																		+ link)
																.val());

												$('#hiddenProPlanPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-EmpEdit" title="Add New Production Plan Line Details">
											<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
										<table class="tableGeneral">
												<tr><td></td></tr>
                                              <tr><td></td></tr>
											<tr>	 	
												<td><spring:message code="label.material" /><font color="red">*</font></td>
											<td><form:select path="material_IdEdit" id="material_IdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${material}" /> 
													
												</form:select></td>
															</tr>
															
															 <tr>
												<td><spring:message code="label.qty" /><font color="red">*</font></td>
												<td><form:input path="qtyEdit" id="qtyEdit"
															class="textbox"/>
															</td>
															</tr>
                                           <tr>
												<td><spring:message code="label.uom" /><font color="red">*</font></td>
											<td><form:select path="uOM_IdEdit" id="uOM_IdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${uom}" /> 
													
												</form:select></td>
															</tr> 
											
																 <tr>
												<td><spring:message code="label.startDate" /><font color="red">*</font></td>
												<td><form:input path="startDTEdit" id="startDTEdit"
															class="textbox"/>
															</td>
															</tr>
											
											<tr>
												<td><spring:message code="label.finishDate" /><font color="red">*</font></td>
												<td><form:input path="finishDTEdit" id="finishDTEdit"
															class="textbox"/></td>
															</tr>
														<tr>
												<td><spring:message code="label.productionOrderNum" /><font color="red">*</font></td>
											<td><form:select path="productionOrder_IdEdit" id="productionOrder_IdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${productionOrderNum}" /> 
													
												</form:select>	<input type="hidden"
													name="hiddenProPlanPopUpEdit" id="hiddenProPlanPopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddEmpEdit" class="table">
												<thead>
													<tr>
													
													<th><spring:message code="label.material" /><font color="red">*</font></th>
													<th><spring:message code="label.qty" /><font color="red">*</font></th>
													<th><spring:message code="label.uom" /><font color="red">*</font></th>
													<th><spring:message code="label.startDate" /><font color="red">*</font></th>
													<th><spring:message code="label.finishDate" /><font color="red">*</font></th>
													<th><spring:message code="label.productionOrderNum" /><font color="red">*</font></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="productionPlanLinelist"
															items="${productionPlanLinelist}">

															<c:set var="edit1" value="${productionPlanLinelist.productionPlanLine_IdEdit}"></c:set> 
														
																<tr id="${productionPlanLinelist.productionPlanLine_IdEdit}">
																
                                                                    <spring:bind
																			path="productionPlanCommand.productionPlanLine_Id">
																			<input type="hidden" name="productionPlanLine_IdEditt"
																				class="textbox" 
																				value="${productionPlanLinelist.productionPlanLine_IdEdit}" id="productionPlanLine_Id${productionPlanLinelist.productionPlanLine_IdEdit}" />
																		</spring:bind>
																		
																		
																		<spring:bind
																			path="productionPlanCommand.material_IdEdit">
																			<input type="hidden" name="material_IdEdit"
																				class="textbox" 
																				value="${productionPlanLinelist.material_IdEdit}" id="material_IdEdit${productionPlanLinelist.productionPlanLine_IdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="productionPlanCommand.materialName">
																			<input type="text" name="materialName"
																				class="textbox" readonly="readonly"
																				value="${productionPlanLinelist.materialName}" id="materialName${productionPlanLinelist.productionPlanLine_IdEdit}" />
																		</spring:bind></td> 
																		
																		<td><spring:bind
																			path="productionPlanCommand.qtyEdit">
																			<input type="text" name="qtyEdit"
																				class="textbox" readonly="readonly"
																				value="${productionPlanLinelist.qtyEdit}"  id="qtyEdit${productionPlanLinelist.productionPlanLine_IdEdit}"/>
																		</spring:bind></td>
																		
																		 <spring:bind
																			path="productionPlanCommand.uOM_IdEdit">
																			<input type="hidden" name="uOM_IdEdit"
																				class="textbox" 
																				value="${productionPlanLinelist.uOM_IdEdit}" id="uOM_IdEdit${productionPlanLinelist.productionPlanLine_IdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="productionPlanCommand.uomName">
																			<input type="text" name="uomName"
																				class="textbox" readonly="readonly"
																				value="${productionPlanLinelist.uomName}" id="uomName${productionPlanLinelist.productionPlanLine_IdEdit}" />
																		</spring:bind></td> 
																		<td><spring:bind
																			path="productionPlanCommand.startDTEdit">
																			<input type="text" name="startDTEdit"
																				class="textbox" readonly="readonly"
																				value="${productionPlanLinelist.startDTEdit}"  id="startDTEdit${productionPlanLinelist.productionPlanLine_IdEdit}"/>
																		</spring:bind></td>
																			<td><spring:bind
																			path="productionPlanCommand.finishDTEdit">
																			<input type="text" name="finishDTEdit"
																				class="textbox" readonly="readonly"
																				value="${productionPlanLinelist.finishDTEdit}"  id="finishDTEdit${productionPlanLinelist.productionPlanLine_IdEdit}"/>
																		</spring:bind>
																           </td>
																           <spring:bind
																			path="productionPlanCommand.productionOrder_IdEdit">
																			<input type="hidden" name="productionOrder_IdEdit"
																				class="textbox" 
																				value="${productionPlanLinelist.productionOrder_IdEdit}" id="productionOrder_IdEdit${productionPlanLinelist.productionPlanLine_IdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="productionPlanCommand.productionOrderNumber">
																			<input type="text" name="productionOrderNumber"
																				class="textbox" readonly="readonly"
																				value="${productionPlanLinelist.productionOrderNumber}" id="productionOrderNumber${productionPlanLinelist.productionPlanLine_IdEdit}" />
																		</spring:bind>
								
																	<input type="hidden" name="${productionPlanLinelist.productionPlanLine_IdEdit}Check" id="${productionPlanLinelist.productionPlanLine_IdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
				onclick="javascript:editEmpDetailsInEdit(${productionPlanLinelist.productionPlanLine_IdEdit})"><img src="images/Edit.jpg" height="25px" width="25px"
																id="${productionPlanLinelist.productionPlanLine_IdEdit}"></img></a></td>
														<td><a href="#"
															id="${productionPlanLinelist.productionPlanLine_IdEdit}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																></img></a></td>
																</tr>
		
																<script type="text/javascript">
																function getID1(
																		link) {
																	
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link.id
																					+ "Check").value = "1";
																document.getElementById(link.id).style.display = "none";
																}
																function editEmpDetailsInEdit(
																		link) {
																	
																
																	$(
																			"#dialog-form-EmpEdit").dialog(
																					"open");
																	
																	$('#material_IdEdit').val(
																			$(
																					'#material_IdEdit'
																							+ link)
																					.val());
																	$('#qtyEdit').val(
																			$(
																					'#qtyEdit'
																							+ link)
																					.val());
																	
																	
																	$('#uOM_IdEdit').val(
																			$(
																					'#uOM_IdEdit'
																							+ link)
																					.val());
																	
																	$('#startDTEdit').val(
																			$(
																					'#startDTEdit'
																							+ link)
																					.val());
																	
																	$('#finishDTEdit').val(
																			$(
																					'#finishDTEdit'
																							+ link)
																					.val());	
																	
																	
																	$('#productionOrder_IdEdit').val(
																			$(
																					'#productionOrder_IdEdit'
																							+ link)
																					.val());
																	
																	$('#hiddenProPlanPopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddEmpEdit" type="button">Add New
											Prouction Plan Line</button>

									</div>

								</div> 
								</div>
								<table>
									<tr>
										<td colspan="2"><c:choose>
										<c:when test="${update}"><input type="submit" id="updated"
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
					</c:forEach>

				</div>
			</div>

		</div>
	</div>
</body>
</html>
