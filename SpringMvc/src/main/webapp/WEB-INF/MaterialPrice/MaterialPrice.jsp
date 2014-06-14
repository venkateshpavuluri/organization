<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


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
<script type="text/javascript" src="js/MntValidator.js"></script>
 <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>

<!--  Date picker -->
<script type="text/javascript">
function dateFun(datePattern) {
	$('#validFrom,#validFromEdit,#validTo,#validToEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>

<script type="text/javascript">
	function AjaxForDuplicate() {

		//get the form values
	var materialId=$('#material_Id').val();
	var batchNo=$('#batchNo').val();
	var validFrom=$('#validFrom').val();
	var validTo=$('#validTo').val();
	
	

		$
				.ajax({

					type : "POST",

					url : "DuplicateCheck.mnt",

					data :"materialId="+materialId+ "&batchNo=" + batchNo +"&validFrom=" + validFrom + "&validTo=" + validTo,

					success : function(response) {

						var checkResponse = "Warning ! Material Price is Already exists.";
						
						if (checkResponse == response) {
                           
							document.getElementById("RFQSuccessdup").style.display = "block";
							$('#RFQSuccessdup').html(response);
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
	
	function AjaxForDuplicateEdit() {

		var materialIdEdit=$('#material_IdEdit').val();
			var batchNoEdit=$('#batchNoEdit').val();
			var validFromEdit=$('#validFromEdit').val();
			var validToEdit=$('#validToEdit').val();
			var materialPrice_IdEdit=$('#materialPrice_IdEdit').val();
		

				$
						.ajax({

							type : "POST",

							url : "DuplicateCheckEdit.mnt",

							data :"materialIdEdit="+materialIdEdit+ "&batchNoEdit=" + batchNoEdit +"&validFromEdit=" + validFromEdit + "&validToEdit=" + validToEdit+ "&materialPrice_IdEdit=" + materialPrice_IdEdit
							,

							success : function(response) {

								var checkResponse = "Warning ! Material Price is Already exists.";
								
								if (checkResponse == response) {
		                           
									document.getElementById("materialPriceEditDuplMessage").style.display = "block";
									$('#materialPriceEditDuplMessage').html(response);
									$('#subid').hide();
								} else {
									document.getElementById("materialPriceEditDuplMessage").style.display = "none";
									$('#subid').show();
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
	$(document)
			.ready(
					function() {
						$('#add,#search').click(function(e) {
							
							$('#edit').hide();
							$('#successmessage').hide();
							$('#savemessage').hide();

						});
						
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
										
											jQuery.validator.addMethod("alphaNumeric", function (value, element) {
										        return this.optional(element) || /^[0-9a-zA-Z&_]+$/.test(value);
										    });
											$('#addform')
													.validate(
															{
																rules : {
																	material_Id : {
																		required : true
																	},
																	batchNo:{
																		alphaNumeric:true,
																		maxlength: 50	
																	},
																	amount : {
																		required : true
																	},
																	currency_Id : {
																		required : true
																	},
																	perUnit : {
																		required : true
																	},
																	
																	validFrom : {
																		required : true
																	},
																	
																	
																	validTo : {
																		required : true
																	},
																	
																	
																	org_Id : {
																		required : true
																	},
																	
																		
																	
																},
																messages : {
																	
                                                                    batchNo:{
                                                                    	
																		maxlength: "<font style='color: red;'><b>Batch Number only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
														                
                                                                    },
                                                                    	
																	validFrom : "<font style='color: red;'><b>Valid From is Required</b></font>",

																	validTo : "<font style='color: red;'><b>Valid To is Required</b></font>",
						
																	material_Id : "<font style='color: red;'><b>Valid From is Required</b></font>",

																	amount : "<font style='color: red;'><b>Amount is Required</b></font>",

																	currency_Id : "<font style='color: red;'><b>Currency is Required</b></font>",
																	
																	perUnit : "<font style='color: red;'><b>Per Unit is Required</b></font>",
																	
																	
																	
																	org_Id : "<font style='color: red;'><b>Organization is Required</b></font>",
																	
																	

																	
																},
															});

										});

						
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {	
											$('#editForm')
													.validate(
															{
																rules : {
																	
																	
																	material_IdEdit : {
																		required : true
																	},
																	batchNoEdit:{
																		alphaNumeric:true,
																		maxlength: 50	
																	},
																	amountEdit : {
																		required : true
																	},
																	currency_IdEdit : {
																		required : true
																	},
																	perUnitEdit : {
																		required : true
																	},
																	
																	validFromEdit : {
																		required : true
																	},
																	
																
																	validToEdit : {
																		required : true
																	},
																	
																	
																	org_IdEdit : {
																		required : true
																	},
																	
																	
																},
																messages : {
																	
																	   batchNoEdit:{
	                                                                    	
																			maxlength: "<font style='color: red;'><b>Batch Number only 50 Characters are allowed.</b></font>",
															                
															                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
															                
	                                                                    },
																	validFromEdit : "<font style='color: red;'><b>Valid From is Required</b></font>",

																	validToEdit : "<font style='color: red;'><b>Valid To is Required</b></font>",
						
																	material_IdEdit : "<font style='color: red;'><b>Valid From is Required</b></font>",

																	amountEdit : "<font style='color: red;'><b>Amount is Required</b></font>",

																	currency_IdEdit : "<font style='color: red;'><b>Currency is Required</b></font>",
																	
																	perUnitEdit : "<font style='color: red;'><b>Per Unit is Required</b></font>",
																	
																	
																	
																	org_IdEdit : "<font style='color: red;'><b>Organization is Required</b></font>",

																	
																},
															});

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

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#submitid').click(function(e) {
			document.getElementById("aid").value = 1;
			//alert(document.getElementById("atId").value);
		});
	});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("aid").value == 1) {
			//alert("Hai");
			var index = $('#tabs li a').index($('a[href="#tabs-1"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$('#updateid').click(function(e) {
			document.getElementById("aid").value = 1;
			//alert(document.getElementById("ateditId").value);

		});
	});
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Material Price</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialPriceEdit" items="${materialPriceEdit}">
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
					<form:form method="get" action="MaterialPriceSearch.mnt"
						commandName="materialPriceCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="materialPriceAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.materialPrice"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.materialPrice"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="materialPriceUpdate"
										items="${materialPriceUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.materialPrice"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="materialPriceUpdateError"
										items="${materialPriceUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.materialPrice"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="materialPriceDeleted"
										items="${materialPriceDeleted}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.materialPrice"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="materialPriceDeletedError"
										items="${materialPriceDeletedError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.materialPrice"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							


							<tr><td>
							<spring:message code="label.searchby" />
								<form:select path="xmlLabel" cssClass="select">
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
										<c:when test="${true}">
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


                   <c:forEach var="mpvalues" items="${mpvalues}">

						<c:set var="as" value="${mpvalues}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">
					<display:table name="MaterialPrice" id="MaterialPrice" class="table"
						requestURI="MaterialPriceSearch.mnt" pagesize="5">
						<display:column property="materialName" title="Material"
									media="html" sortable="true"></display:column>
						<display:column property="batchNo" sortable="true"
							titleKey="label.batchNo" media="html" />
						<display:column property="validFrom" sortable="true"
							titleKey="label.validFrom" media="html" />
							<display:column property="validTo" sortable="true"
							titleKey="label.validTo" media="html" />
						
						
						
						<display:column titleKey="label.edit">
						<c:choose>
							<c:when test="${true }">
							<a
								href="MaterialPriceEdit.mnt?MaterialPriceId=<c:out value="${MaterialPrice.materialPrice_Id}"/> "><img
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
							<c:when test="${true}">
							<a
								href="MaterialPriceDelete.mnt?MaterialPriceId=<c:out value="${MaterialPrice.materialPrice_Id}"/> "
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
                    
                 <table>
						<tr>
							<td colspan="4" class="alert-warning" id="RFQSuccessdup"
								style="display: none; width:350px; height: 25px;"></td>
						</tr>
					</table> 
					<form:form commandName="materialPriceCommand" id="addform" method="POST"
						action="materialPriceAdd.mnt">
						<table class="tableGeneral">
						
						<form:hidden path="aid" />
							
						
							<tr>
								<td><spring:message code="label.material"></spring:message><font
									color="red">*</font></td>
									
									<td><form:select path="material_Id" id="material_Id" class="select"  >
                                          <form:option value="">-Select-</form:option>
											<form:options items="${material }" />
										</form:select></td>
								
							</tr>
							
								<tr>
								<td><spring:message code="label.batchNo"></spring:message></td>
								<td><form:input path="batchNo" id="batchNo" class="textbox"    /></td>
							</tr>
							<tr>
								<td><spring:message code="label.amount"></spring:message><font color="red">*</font></td>
								<td><form:input path="amount" id="amount" class="textbox"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.perunit"></spring:message><font color="red">*</font></td>
								<td><form:input path="perUnit" id="perUnit" class="textbox"/></td>
							</tr>
								<tr>
								<td><spring:message code="label.currency"></spring:message><font
									color="red">*</font></td>
									
									<td><form:select path="currency_Id" id="currency_Id" class="select">
                                          <form:option value="">-Select-</form:option>
											<form:options items="${SelectCurrency }" />
										</form:select></td>
								
							</tr>
							
							
							
							<tr>
								<td><spring:message code="label.validFrom"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="validFrom" id="validFrom" class="textbox" /></td>
							</tr>

							
							<tr>
								<td><spring:message code="label.validTo"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="validTo" id="validTo" class="textbox" onchange="AjaxForDuplicate()" /></td>
							</tr>
							
                             	<tr>
									<td><spring:message code="label.prorg" /><font
										color="red">*</font></td>
									<td><form:select path="org_Id" id="org_Id" class="select">
                                          <form:option value="">-Select-</form:option>
											<form:options items="${organization }" />
										</form:select></td>
								</tr>
                               
                                
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${true}"><input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="submitid" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise></c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
			 	 <div align="left" class="TabbedPanelsContent">
					<c:forEach var="materialPriceEdit" items="${materialPriceEdit}">
                      <table>
						<tr>
							<td colspan="4" class="alert-warning" id="materialPriceEditDuplMessage"
								style="display: none; width:350px; height: 25px;"></td>
						</tr>
					</table>
						<form:form method="post" action="MaterialPriceUpdate.mnt"
							commandName="materialPriceCommand" id="editForm">
							<table class="tableGeneral">

                            	
								 <form:hidden path="materialPrice_IdEdit" id="materialPrice_IdEdit" />


				              <tr>
								<td><spring:message code="label.material"></spring:message><font
									color="red">*</font></td>
									
									<td><form:select path="material_IdEdit" id="material_IdEdit" class="select">
                                          <form:option value="">-Select-</form:option>
											<form:options items="${material }" />
										</form:select></td>
								
							</tr>
							
								<tr>
								<td><spring:message code="label.batchNo"></spring:message></td>
								<td><form:input path="batchNoEdit" id="batchNoEdit" class="textbox"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.amount"></spring:message><font color="red">*</font></td>
								<td><form:input path="amountEdit" id="amountEdit" class="textbox"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.perunit"></spring:message><font color="red">*</font></td>
								<td><form:input path="perUnitEdit" id="perUnitEdit" class="textbox"/></td>
							</tr>
								<tr>
								<td><spring:message code="label.currency"></spring:message><font
									color="red">*</font></td>
									
									<td><form:select path="currency_IdEdit" id="currency_IdEdit" class="select">
                                          <form:option value="">-Select-</form:option>
											<form:options items="${SelectCurrency }" />
										</form:select></td>
								
							</tr>
							
							
							
							<tr>
								<td><spring:message code="label.validFrom"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="validFromEdit" id="validFromEdit" class="textbox" /></td>
							</tr>

							
							<tr>
								<td><spring:message code="label.validTo"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="validToEdit" id="validToEdit" class="textbox" onchange="AjaxForDuplicateEdit()"/></td>
							</tr>
							
                             	<tr>
									<td><spring:message code="label.prorg" /><font
										color="red">*</font></td>
									<td><form:select path="org_IdEdit" id="org_IdEdit" class="select">
                                          <form:option value="">-Select-</form:option>
											<form:options items="${organization }" />
										</form:select></td>
								</tr>


								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${true}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when>
										<c:otherwise>
						
				<input type="submit" value="Update" name="update" id="update" class="btn btn-primary"/>
										</c:otherwise>

									</c:choose></td>

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
