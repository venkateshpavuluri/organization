<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author Srinivas
 @version 1.0    -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
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
<script type="text/javascript" src="js/MntValidator.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#sumnid')
								.click(
										function(event) {
											//alert($('#sdType').val());
											
											$('#addproductionBatch')
													.validate(
															{
																rules : {
																	proId : {
																		required : true },
																		batchtype: {
																			required : true },
																			batchdate:{
																				required : true
																			},
																			batchqty:{
																				required : true,
																				number:true
																			},
																			batchstdt:{
																				required : true
																			},
																			deliverydt:{
																				required : true
																			},
																			statusId:{
																				required : true
																			},
																	
																},
																messages : {
																	proId : "<font style='color: red;'><b>Production Order is Required</b></font>",
																	batchtype : "<font style='color: red;'><b>Batch Type is Required</b></font>",
																	batchdate : "<font style='color: red;'><b>Batch Date is Required</b></font>",
																	batchqty :{
															                 required  : "<font style='color: red;'><b>Batch Quantity is Required</b></font>",
																	number:"<font style='color: red;'><b>Batch Quantity must be in Integers</b></font>",
																	},	
															        batchstdt : "<font style='color: red;'><b>Batch Start Date is Required</b></font>",
																	deliverydt : "<font style='color: red;'><b>Delivery Date is Required</b></font>",
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																},

															});
										});
						//UpdateForm Validations
						 $('#updated')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert(assetedit);
											$('#editproductionbatch')
													.validate(
															{
																rules : {
																	proIdedit : {
																		required : true },
																		batchtypeedit: {
																			required : true },
																			batchdateedit:{
																				required : true
																			},
																			batchqtyedit:{
																				required : true,
																				number:true
																			},
																			batchstdtedit:{
																				required : true
																			},
																			deliverydtedit:{
																				required : true
																			},
																			statusIdedit:{
																				required : true
																			},
																	
																},
																messages : {
																	proIdedit : "<font style='color: red;'><b>Production Order is Required</b></font>",
																	batchtypeedit : "<font style='color: red;'><b>Batch Type is Required</b></font>",
																	batchdateedit : "<font style='color: red;'><b>Batch Date is Required</b></font>",
																	batchqtyedit :{
														                 required  : "<font style='color: red;'><b>Batch Quantity is Required</b></font>",
																			number:"<font style='color: red;'><b>Batch Quantity must be in Integers</b></font>",
																			},	
																    batchstdtedit : "<font style='color: red;'><b>Batch Start Date is Required</b></font>",
																	deliverydtedit : "<font style='color: red;'><b>Delivery Date is Required</b></font>",
																	statusIdedit : "<font style='color: red;'><b>Status is Required</b></font>",
																},
															});

										}); 

					});
</script>
<!-- <script>
	$(function() {
		$("#tabs").tabs();
		$("#batchdate,#batchstdt,#deliverydt,#batchedt,#batchastdt,#batchaedt").datepicker();
		$("#batchdateedit,#batchstdtedit,#deliverydtedit,#batchedtedit,#batchastdtedit,#batchaedtedit").datepicker();
	});
</script> -->
<!--  Date picker -->
<script>
	function dateFun(datePattern) {
		$("#tabs").tabs();
		$(
		'#batchdate,#batchstdt,#deliverydt,#batchedt,#batchastdt,#batchaedt,#batchdateedit,#batchstdtedit,#deliverydtedit,#batchedtedit,#batchastdtedit,#batchaedtedit')
		.datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
		});
		
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("sohide").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

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




</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle"><spring:message code="label.productionbatch" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
	<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				 </c:forEach> 
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>

			 <div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchProductionBatch.mnt" method="GET"
						commandName="productionBatch">
						<table class="tableGeneral">
							
							<tr>
								<td colspan="3"><c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.productionbatch"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.productionbatch"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										 <c:forEach var="SalesOrganizationDelete"
										items="${probDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.productionbatch"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach><c:forEach var="probDeleteError"
										items="${probDeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.productionbatch"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>
									<c:forEach var="pbatchUpdate"
										items="${pbatchUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.productionbatch"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="pbatchUpdateError"
										items="${pbatchUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.productionbatch"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
										</td></tr>
										
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select>  <spring:bind path="productionBatch.operations">
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
								
								<c:choose>
								<c:when test="${true }">
								<td><input type="submit"  value="<spring:message code='label.search'/>" class="btn btn-primary" /></td></c:when>
									<c:otherwise>
									<td><input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger"/></td>
									</c:otherwise></c:choose>
							</tr>

						</table>
					</form:form>

					<c:forEach var="pbBeans"
						items="${pbBeans}">
						<c:set var="so" value="${pbBeans}"></c:set>
					</c:forEach>
					<c:if test="${so!=null}">
						<display:table id="pbid" name="pbBeans"
							requestURI="searchProductionBatch.mnt" pagesize="5"
							class="table">
							<display:column property="probatchId"
								title="ProductionBatch Id" media="none" sortable="true"></display:column>
							<display:column property="proId" titleKey="label.productionOrder"
								media="html" sortable="true"></display:column>
								<display:column property="batchtype" titleKey="label.batchtype"
								media="html" sortable="true"></display:column>
								<display:column property="batchdate" titleKey="label.batchdate"
								media="html" sortable="true"></display:column>
								<display:column property="batchqty" titleKey="label.batchqty"
								media="html" sortable="true"></display:column>
								<display:column property="batchstdt" titleKey="label.batchstdt"
								media="html" sortable="true"></display:column>
								<display:column property="deliverydt" titleKey="label.deliverydt"
								media="html" sortable="true"></display:column>
								<display:column property="batchedt" titleKey="label.batchedt"
								media="html" sortable="true"></display:column>
								<display:column property="batchastdt" titleKey="label.batchastdt"
								media="html" sortable="true"></display:column>
								<display:column property="batchaedt" titleKey="label.batchaedt"
								media="html" sortable="true"></display:column>
								<display:column property="statusId" titleKey="label.statusId"
								media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
								<a
									href="ProBatchEdit.mnt?pbedit=<c:out value="${pbid.probatchId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
									height="20px" /></a>
									</c:otherwise></c:choose>
							</display:column>
							
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${true }">
							
								<a
									href="ProBatchDelete.mnt?pbdelete=<c:out value="${pbid.probatchId}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
								</c:when>
									<c:otherwise>
									<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a></c:otherwise>
						</c:choose>	</display:column> 
							
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>
					</c:if>

				</div>
			</div> 

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
				<form:form action="saveProBatch.mnt" method="POST"
							commandName="productionBatch" id="addproductionBatch">
					<table class="tableGeneral">
						<tr>
							<%-- <td colspan="2"><c:forEach var="salesOrgDup"
									items="${salesOrgDup}">
									<div class="alert-warning" id="successmessage">							
									<strong><spring:message code="label.warning"/> </strong>
										<spring:message code="label.salesorgnaization"/> <spring:message code="label.duplicateCheck"/>
											
									</div>
								</c:forEach></td> --%>
						</tr>
						
						
							
							<tr>
							 <td><spring:message code="label.productionOrder" /><span
									class="required">*</span></td><td><form:select path="proId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${productionorder}" />
								</form:select>
							</td> 
							</tr>
							<tr>
							<td><spring:message code="label.batchtype" /><span
									class="required">*</span></td><td> <form:input path="batchtype"
										class="textbox" maxlength="50" /></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchdate" /><span
									class="required">*</span></td><td> <form:input path="batchdate"
										class="textbox" maxlength="50" id="batchdate"/></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchqty" /><span
									class="required">*</span> </td><td><form:input path="batchqty"
										class="textbox" maxlength="20" /></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchstdt" /><span
									class="required">*</span></td><td> <form:input path="batchstdt"
										class="textbox" maxlength="20" id="batchstdt" /></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.deliverydt" /><span
									class="required">*</span></td><td> <form:input path="deliverydt"
										class="textbox" maxlength="20" id="deliverydt"/></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchedt" /></td><td> <form:input path="batchedt"
										class="textbox" maxlength="20" id="batchedt"/></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchastdt"/></td><td> <form:input path="batchastdt"
										class="textbox" maxlength="20" id="batchastdt"/></td>						
								
								
							</tr><tr>
							<td><spring:message code="label.batchaedt"/></td><td> <form:input path="batchaedt"
										class="textbox" maxlength="20" id="batchaedt" /></td>						
								
								
							</tr>
							<tr>
						<td><spring:message code="label.statusId" /><span
									class="required">*</span></td><td><form:select path="statusId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${Status}" />
								</form:select>
							</td>
							</tr>
							<tr>
					
								<td><c:choose>
					<c:when test="${true}"><input type="submit" id="sumnid"
									value='<spring:message code="label.save"/>' class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" id="sumnid" disabled="disabled"
									value='<spring:message code="label.save"/>' class="btn btn-danger" />
									</c:otherwise>
					</c:choose><input
									type="reset" value='<spring:message code="label.reset"/>'
									class="btn btn-primary" /></td>
							</tr>
						
							<%-- <tr>
								<td colspan="2"><input type="submit" value="<spring:message code="label.save" />"
									class="btn btn-primary" id="sumbnid"/><input
										type="reset" value="<spring:message code="label.reset" />" class="btn btn-primary"/></td>
							</tr> --%>
							</table>
						</form:form>
					

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="EditValues" items="${editvalues }">
						<form:form action="productionBatchUpdate.mnt" method="POST"
							commandName="productionBatch" id="editproductionbatch">
							<table class="tableGeneral">
							 
								<form:hidden path="probatchIdedit" />
							<tr>
							 <td><spring:message code="label.productionOrder" /><span
									class="required">*</span></td><td><form:select path="proIdedit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${productionorder}" />
								</form:select>
							</td> 
							</tr>
							<tr>
							<td><spring:message code="label.batchtype" /><span
									class="required">*</span></td><td> <form:input path="batchtypeedit"
										class="textbox" maxlength="50" /></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchdate" /><span
									class="required">*</span></td><td> <form:input path="batchdateedit"
										class="textbox" maxlength="50" id="batchdateedit"/></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchqty" /><span
									class="required">*</span> </td><td><form:input path="batchqtyedit"
										class="textbox" maxlength="20" /></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchstdt" /><span
									class="required">*</span></td><td> <form:input path="batchstdtedit"
										class="textbox" maxlength="20" id="batchstdtedit" /></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.deliverydt" /><span
									class="required">*</span></td><td> <form:input path="deliverydtedit"
										class="textbox" maxlength="20" id="deliverydtedit"/></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchedt" /></td><td> <form:input path="batchedtedit"
										class="textbox" maxlength="20" id="batchedtedit"/></td>						
								
								
							</tr>
							<tr>
							<td><spring:message code="label.batchastdt" /></td><td> <form:input path="batchastdtedit"
										class="textbox" maxlength="20" id="batchastdtedit"/></td>						
								
								
							</tr><tr>
							<td><spring:message code="label.batchaedt" /></td><td> <form:input path="batchaedtedit"
										class="textbox" maxlength="20" id="batchaedtedit" /></td>						
								
								
							</tr>
							<tr>
						<td><spring:message code="label.statusId" /><span
									class="required">*</span></td><td><form:select path="statusIdedit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${Status}" />
								</form:select>
							</td>
							</tr>
							
							
								<tr>
								<c:choose>
								<c:when test="${true }">
									<td colspan="2"><input type="submit"
										value="<spring:message code="label.update" />" class="btn btn-primary" id="updated"/></td>
								</c:when>
								<c:otherwise>
								<td><input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="updated" /></td>
										</c:otherwise></c:choose>
								
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
			</div> 
</div>

		</div>
</body>
</html>




