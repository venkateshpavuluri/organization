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
<title>My JSP 'shop.jsp' starting page</title>
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
<script>
	$(function() {

		$("#startDate").datepicker();
		$("#endDate").datepicker();
	

	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#add,#search').click(function(e) {
							
							$('#edit').hide();
							$('#successmessage').hide();
							$('#savemessage').hide();

						});
						 jQuery.validator.addMethod("alphaNumeric", function (value, element) {
						        return this.optional(element) || /^[0-9a-zA-Z][0-9a-zA-Z&_ ]+$/.test(value);
						    });
						
						//AddForm Validations
						$('#wsubmit')
								.click(
										function(event) {
											

											$('#addform')
													.validate(
															{
																rules : {
																	shopCode : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																	
																	
																	shopName : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																
																																	

																},
																messages : {
																	

																	shopCode : {
																		required: "<font style='color: red;'><b>ShopCode is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>ShopCode only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
														                
																	},

																	shopName :{
																		required: "<font style='color: red;'><b>Shop Name is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>Shop Name only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
														                
																	},

																															

																	

																}
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
																	
																	shopCodeEdit : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																	
																	
																	shopNameEdit : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																	
																},
																messages : {
																	
																	shopCodeEdit : {
																		required: "<font style='color: red;'><b>ShopCode is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>ShopCode only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
														                
																	},

																	shopNameEdit :{
																		
																		required: "<font style='color: red;'><b>Shop Name is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>Shop Name only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
														                
																	},

																	
																},
															});

										});

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#submitId').click(function(e) {
	
			var aid = document.getElementById("aid").value = 1;
		
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








</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Shop</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="shopEditValues" items="${shopEditValues}">
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
					<form:form method="get" action="shopSearch.mnt"
						commandName="shopCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="shopAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.shop"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.shop"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="shopUpdate"
										items="${shopUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.shop"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="shopUpdateError"
										items="${shopUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.shop"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="shopDelete"
										items="${shopDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.shop"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="shopDeleteError"
										items="${shopDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.shop"/> <spring:message code="label.deleteFail"></spring:message>
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


                   <c:forEach var="shopSearchvalues" items="${shopSearchvalues}">

						<c:set var="as" value="${shopSearchvalues}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">
					<display:table name="Shop" id="Shop" class="table"
						requestURI="shopSearch.mnt" pagesize="5">
						<display:column property="shopCode" sortable="true"
							titleKey="label.shopCode" media="html" />
						<display:column property="shopName" sortable="true"
							titleKey="label.shopName" media="html" />
					
						<display:column titleKey="label.edit">
						<c:choose>
							<c:when test="${edit }">
							<a
								href="ShopEdit.mnt?shopId=<c:out value="${Shop.shop_Id}"/> "><img
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
								href="ShopDelete.mnt?shopId=<c:out value="${Shop.shop_Id}"/> "
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
                    
                   
					<form:form commandName="shopCommand" id="addform" method="POST"
						action="shopAdd.mnt">
						<table class="tableGeneral">
						
						<form:hidden path="aid" />
							<tr>
									<td colspan="2"><c:forEach var="shopAddDuplicateCheck"
											items="${shopAddDuplicateCheck}">

											<div class="alert-warning" id="savemessage">

											<strong><spring:message code="label.warning"/> </strong>
											<spring:message code="label.shopName"/> <spring:message code="label.duplicateCheck"/>
											
										</div>
											

									

										</c:forEach></td>
								</tr>
						
							<tr>
								<td><spring:message code="label.shopCode"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="shopCode" id="shopCode" class="textbox" onkeyup="doAjaxPost()"/></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.shopName"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="shopName" id="shopName" class="textbox" onkeyup="doAjaxPost()"/></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.description"></spring:message></td>
								<td><form:input path="description" id="description" class="textbox" /></td>
							</tr>

							<tr>
											<td><spring:message code="label.plant" /></td>
									<td><form:select path="plant_Id" id="plant_Id"
											class="select" cssStyle="height:25px">
											<form:option value="0">---Select---</form:option>
											<form:options items="${plant }" />
										</form:select></td>
								</tr>
                             
                            
                                
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="submitId" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose><input type="reset"
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
					<c:forEach var="shopEditValues" items="${shopEditValues}">
                      <table>
						
								<tr>
									<td colspan="2"><c:forEach var="shopUpdateCheck"
											items="${shopUpdateCheck}">

											<div class="alert-warning" id="savemessage">

											<strong><spring:message code="label.warning"/> </strong>
											<spring:message code="label.shopName"/> <spring:message code="label.duplicateCheck"/>
											
										</div>
											

									

										</c:forEach></td>
								</tr>
					</table>
						<form:form method="post" action="shopUpdate.mnt"
							commandName="shopCommand" id="editForm">
							<table class="tableGeneral">

                            	
								 <form:hidden path="shop_IdEdit" id="shop_IdEdit" />


				             			<tr>
								<td><spring:message code="label.shopCode"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="shopCodeEdit" id="shopCodeEdit" class="textbox" onkeyup="doAjaxPost()"/></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.shopName"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="shopNameEdit" id="shopNameEdit" class="textbox" onkeyup="doAjaxPost()"/></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.description"></spring:message></td>
								<td><form:input path="descriptionEdit" id="descriptionEdit" class="textbox" /></td>
							</tr>

							<tr>
											<td><spring:message code="label.plant" /></td>
									<td><form:select path="plant_IdEdit" id="plant_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="0">---Select---</form:option>
											<form:options items="${plant }" />
										</form:select></td>
								</tr>
                             

								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<spring:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
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
