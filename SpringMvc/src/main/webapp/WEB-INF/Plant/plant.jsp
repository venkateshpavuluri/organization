
<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 20-09-2013 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>


<script type="text/javascript">
	$(document).ready(function() {

		$("#add,#search").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

		});
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						
						$('#sumnid')
								.click(
										function(event) {

											$('#plantAdd')
													.validate(
															{
																rules : {
																	plantName : {
																		required : true,
																		alphabets: true,
																		specialcharacters :true
																	},
																	add1 : {
																		required : true,
																		maxlength:50,
																		minlength:2
																	},
																	city : {
																		required : true,
																		maxlength:50,
																		minlength:2
																	},
																	state : {
																		required : true,
																		maxlength:50,
																		minlength:2
																	},
																	country : {
																		required : true
																	},
																	phone : {
																		required : true,
																		number:true,
																		maxlength:12,
																		minlength:10
																	},
																	mobile : {
																		required : true,
																		number:true,
																		minlength:10,
																		maxlength:12
																	},

																	orgId : {
																		required : true
																	}

																},
																messages : {
																	plantName : {
																		required: "<font style='color: red;'><b>Plant Name is Required.</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	add1 :  {
																		required: "<font style='color: red;'><b>Address1 is Required.</b></font>",
																		minlength:"<font style='color: red;'><b>Address must be 2 characters Required</b></font>",
														                maxlength: "<font style='color: red;'><b>Address1 only 50 Characters are allowed.</b></font>",
														                
														               
																	},

																	city :  {
																		required: "<font style='color: red;'><b>City is Required.</b></font>",
																		minlength:"<font style='color: red;'><b>City must be 2 characters Required</b></font>",
														                maxlength: "<font style='color: red;'><b>City only 50 Characters are allowed.</b></font>",
														                
														                
																	},
																	state : {
																		required: "<font style='color: red;'><b>State is Required.</b></font>",
																		minlength:"<font style='color: red;'><b>State must be 2 characters Required</b></font>",
														                maxlength: "<font style='color: red;'><b>State only 50 Characters are allowed.</b></font>",
														                
										  
																	},
																	country : {
																		required: "<font style='color: red;'><b>Country is Required.</b></font>",
													                	
														                
																	},

																	mobile : {
																		required: "<font style='color: red;'><b>Mobile is Required.</b></font>",
																		number:"<font style='color: red;'><b>Mobile Number Allows only Numbers.</b></font>",
																		minlength: "<font style='color: red;'><b>Mobile Number Minimum 10 digits required</b></font>",
														                maxlength: "<font style='color: red;'><b>Mobile Number only 50 Characters are allowed.</b></font>",
																	},
																	phone :  {
																		required: "<font style='color: red;'><b>Phone Number is Required.</b></font>",
																		number:"<font style='color: red;'><b>Phone Number Allows only Numbers.</b></font>",
																		minlength: "<font style='color: red;'><b>Phone Number  Minimum 10 digits required</b></font>",
														                maxlength: "<font style='color: red;'><b>Phone Number only 50 Characters are allowed.</b></font>",
														                
																	},

																	orgId : "<font style='color: red;'><b>Organization Name is Required</b></font>"

																},

															});
										});

						$('#sumbnid')
								.click(
										function(event) {
										

											$("#formEdit")
													.validate(
															{
																rules : {
																	plantNameEdit : {
																		required : true,
																		alphabets: true,
																		specialcharacters :true
																		
																	},
																	add1Edit : {
																		required : true,
																		maxlength:50,
																		minlength:2
																	},

																	cityEdit :  {
																		required: true,
																		minlength:2,
														                maxlength: 50
														                
																	},
																	stateEdit : {
																		required: true,
																		minlength:2,
														                maxlength: 50
														                
										  
																	},
																	countryEdit : {
																		required: true
													                	
														               
																	},
																	phoneEdit : {
																		required : true,
																		number:true,
																		minlength:10
																	},
																	mobileEdit : {
																		required : true,
																		number:true,
																		minlength:10
																	},

																	orgIdEdit : {
																		required : true
																	}

																},
																messages : {
																	plantNameEdit : {
																		required: "<font style='color: red;'><b>Plant Name is Required.</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	add1Edit :  {
																		required: "<font style='color: red;'><b>Address1 is Required.</b></font>",
																		minlength:"<font style='color: red;'><b>Address must be 2 characters Required</b></font>",
														                maxlength: "<font style='color: red;'><b>Address1 only 50 Characters are allowed.</b></font>",
														                
														               
																	},
																
																	cityEdit :  {
																		required: "<font style='color: red;'><b>City is Required.</b></font>",
																		minlength:"<font style='color: red;'><b>City must be 2 characters Required</b></font>",
														                maxlength: "<font style='color: red;'><b>City only 50 Characters are allowed.</b></font>",
														                
														                
																	},
																	stateEdit : {
																		required: "<font style='color: red;'><b>State is Required.</b></font>",
																		minlength:"<font style='color: red;'><b>State must be 2 characters Required</b></font>",
														                maxlength: "<font style='color: red;'><b>State only 50 Characters are allowed.</b></font>",
														                
										  
																	},
																	countryEdit : {
																		required: "<font style='color: red;'><b>Country is Required.</b></font>",
													                	
														                
																	},

																	mobileEdit : {
																		required: "<font style='color: red;'><b>Mobile Number is Required.</b></font>",
																		number:"<font style='color: red;'><b>Mobile Number Allows only Numbers.</b></font>",
																		minlength: "<font style='color: red;'><b>Mobile Number Minimum 10 digits required</b></font>",
														                maxlength: "<font style='color: red;'><b>Mobile Number only 50 Characters are allowed.</b></font>",
																	},
																	phoneEdit :  {
																		required: "<font style='color: red;'><b>Phone Number is Required.</b></font>",
																		number:"<font style='color: red;'><b>Phone Number Allows only Numbers.</b></font>",
																		minlength: "<font style='color: red;'><b>Phone Number Minimum 10 digits required</b></font>",
														                maxlength: "<font style='color: red;'><b>Phone Number only 50 Characters are allowed.</b></font>",
																	},

																	orgIdEdit : "<font style='color: red;'><b>Organization Name is Required</b></font>"
																},

															});
										});
					});
</script>
<script>
	$(function() {
		$("#tabs").tabs();
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
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();

		});
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
		<div class="PageTitle">Plant</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${plantValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /> </a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /> </a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<!--=================== ============================================Begin PlantSearch================================================= -->
					<form:form action="plantSearch.mnt" method="get"
						commandName="plant">
						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach var="plantUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/> </strong>
											<s:message code="label.plant"/> <s:message code="label.saveSuccess"/>
									
										</div>
									</c:forEach><c:forEach var="plantUpdate"
										items="${param.listw}">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error"/> </strong>
											<s:message code="label.plant"/> <s:message code="label.saveFail"/>
								
										</div>
									</c:forEach><c:forEach var="plantUpdate"
										items="${plantUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/> </strong>
											<s:message code="label.plant"/> <s:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="plantUpdateError"
										items="${plantUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/> </strong>
										<s:message code="label.plant"/> <s:message code="label.updateFail"/>
										
										</div>
									</c:forEach><c:forEach var="plantDelete"
										items="${plantDelete}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/> </strong>
										<s:message code="label.plant"/> <s:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach><c:forEach var="plantDeleteError"
										items="${plantDeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/> </strong>
										<s:message code="label.plant"/> <s:message code="label.deleteFail"/>
										
										</div>
									</c:forEach></td>
							</tr>
							
							
							<tr id="mainSearch">
								<td class="label"><s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <s:bind path="plant.operations">
								<select class="select" name="operations">
								<option value="<s:message code='assignedOperator'/>"><s:message code="label.equalsTo"/> </option>
								<option value="<s:message code='notequalsOperator'/>"><s:message code="label.notEqualsTo"/> </option>
							 <option value="<s:message code='beginsWithOperator'/>"> <s:message code="label.beginsWith"/> </option> 
								<option value="<s:message code='endsWithOperator'/>"><s:message code="label.endsWith"/> </option>
								<option value="<s:message code='containsOperator'/>"><s:message code="label.contains"/></option>
								</select>
									 </s:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
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
								<c:when test="${search }">
								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td></c:when>
									<c:otherwise>
									<td><input type="submit" disabled="disabled"
									value="<s:message code="label.search"/>"
									class="btn btn-danger" /></td>
									</c:otherwise>
								</c:choose>
							</tr>
							<form:form action="plantAdvanceSearch.mnt" method="get"
							commandName="plant" name="advanceSearchFinal" id="advanceSearchFinal">
							<tr>
								<td colspan="2">
									<a href="plantAdvanceSearch.mnt"><font
										style="color: blue" id="aslink"><u><b>Advanced Search</b></u></font></a>
										<a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							
							</tr>
						</form:form>

						</table>
						<form:form action="plantAdvanceSearchOperations.mnt"
						commandName="plant">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${plantSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label><form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><s:bind path="plant.operations1">
								<select class="select" name="operations1">
								<!-- <option value="0">--Select--</option> -->
								<option value="<s:message code='assignedOperator'/>"><s:message code="label.equalsTo"/> </option>
								<option value="<s:message code='notequalsOperator'/>"><s:message code="label.notEqualsTo"/> </option>
							 <option value="<s:message code='beginsWithOperator'/>"> <s:message code="label.beginsWith"/> </option> 
								<option value="<s:message code='endsWithOperator'/>"><s:message code="label.endsWith"/> </option>
								<option value="<s:message code='containsOperator'/>"><s:message code="label.contains"/></option>
								</select>
									 </s:bind></td>
										<td><form:input path="advanceSearchText"
												id="advanceSearchkk"  cssClass="textbox"/></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
										<c:choose>
										<c:when test="${search}">
									<td colspan="3"><input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" /></td></c:when>
										<c:otherwise>
										<td colspan="3"><input type="submit" disabled="disabled"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-danger" /></td>
										</c:otherwise>
										</c:choose>
								</tr>
							
							</table>

						</div>
					</form:form>
					</form:form>
					<!--=================== ============================================End PlantSearch================================================= -->
					
					<c:if test="${plantSearch!=null}">
						<!--=================== ============================================Begin DisplayTable================================================= -->
						<display:table id="plantRow" name="plantSearch"
							requestURI="plantSearch.mnt" pagesize="5" class="table">
							<display:column property="plantName" titleKey="label.plantName"
								media="html" sortable="true"></display:column>
							<display:column property="orgName"
								titleKey="label.organizationName" media="html" sortable="true"></display:column>
							<display:column property="add1" titleKey="label.address1"
								media="html" sortable="true" />
							<display:column property="add2" titleKey="label.address2"
								media="html" sortable="true" />
							<display:column property="add3" titleKey="label.address3"
								media="html" sortable="true" />
							<display:column property="city" titleKey="label.city"
								media="html" sortable="true" />
							<display:column property="state" titleKey="label.state"
								sortable="true" />
							<display:column property="countryName" titleKey="label.country"
								sortable="true" />
							<display:column property="phone" titleKey="label.phoneNumber"
								sortable="true" />
							<display:column property="fax" titleKey="label.fax"
								sortable="true" />
							<display:column property="mobile" titleKey="label.mobileNumber"
								sortable="true" />

							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit }">
								<a href="plantEdit.mnt?plantEdit=<c:out value="${plantRow.plantId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
									height="20px" /></a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete }">
								<a
									href="plantDelete.mnt?plantDelete=<c:out value="${plantRow.plantId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>	</c:when>
									<c:otherwise>
										<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise>
									
							</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						
						</display:table>
					</c:if>
					<!--=================== ============================================End DisplayTable================================================= -->
				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="plantAdd.mnt" method="POST" commandName="plant"
						id="plantAdd">
						<form:hidden path="aid" />
						<table class="tableGeneral">

							<!--=================== ============================================Begin PlantAdd================================================= -->
							<tr>
								<td colspan="2"><c:forEach var="duplicateId"
										items="${duplicate}">

										<div class="alert-warning">
											<strong> <s:message code="label.warning"/></strong>
											<s:message code="label.plantName"/> <s:message code="label.duplicateCheck"/>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><s:message code="label.plantName" /><font color="red">*</font></td>
								<td><form:input path="plantName" id="plantName"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><s:message code="label.address1" /><font color="red">*</font></td>
								<td><form:input path="add1" id="add1" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><s:message code="label.address2" /></td>
								<td><form:input path="add2" id="add2" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>

								<td><s:message code="label.address3" /></td>
								<td><form:input path="add3" id="add3" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><s:message code="label.city" /><font color="red">*</font></td>
								<td><form:input path="city" id="city" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><s:message code="label.state" /><font color="red">*</font></td>
								<td><form:input path="state" id="State" class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><s:message code="label.country" /><font color="red">*</font></td>
								<td><form:select path="country" id="country" class="select">
										<form:option value="" >--Select--</form:option>

										<form:options items="${country}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.phoneNumber" /><font color="red">*</font></td>
								<td><form:input path="phone" id="phone" class="textbox" maxlength="12"/></td>
							</tr>
							<tr>
								<td><s:message code="label.mobileNumber" /><font color="red">*</font></td>
								<td><form:input path="mobile" id="mobile" class="textbox" maxlength="12"/></td>
							</tr>
							<tr>
								<td><s:message code="label.fax" /></td>
								<td><form:input path="fax" id="fax" class="textbox" maxlength="15"/></td>
							</tr>


							<tr>
								<td><s:message code="label.organizationName" /><font color="red">*</font></td>
								<td><form:select path="orgId" id="orgId" class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${orgName}" />
									</form:select></td>
							</tr>
							<tr>
					<c:choose>
					<c:when test="${save}">
								<td><input type="submit" id="sumnid"
									value='<s:message code="label.save"/>' class="btn btn-primary" /><input
									type="reset" value='<s:message code="label.reset"/>'
									class="btn btn-primary" /></td></c:when>
									<c:otherwise>
									<td><input type="submit" id="sumnid" disabled="disabled"
									value='<s:message code="label.save"/>' class="btn btn-danger" /><input
									type="reset" value='<s:message code="label.reset"/>'
									class="btn btn-primary" /></td>
									</c:otherwise>
					</c:choose>
							</tr>

						</table>
					</form:form>
					<!--=================== ============================================End PlantAdd================================================= -->
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<!--=================== ============================================Begin PlantUpdate================================================= -->
					<c:forEach var="materialEditValues" items="${plantValues }">

						<form:form action="plantUpdate.mnt" method="POST"
							commandName="plant" id="formEdit">

							<form:hidden path="plantIdEdit" />
							<table>
								<tr>
									<td colspan="2"><c:forEach var="plantDuplicate"
											items="${plantDuplicate}">
											<div class="alert-warning">
												<strong><s:message code="label.warning"/> </strong>
												<s:message code="label.plantName"/> <s:message code="label.duplicateCheck"/>
										
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td><s:message code="label.plantName" /><font color="red">*</font></td>
									<td><form:input path="plantNameEdit" id="plantName"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><s:message code="label.address1" /><font color="red">*</font></td>
									<td><form:input path="add1Edit" id="add1" class="textbox" maxlength="50"/>
									</td>
								</tr>
								<tr>
									<td><s:message code="label.address2" /></td>
									<td><form:input path="add2Edit" id="add2" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><s:message code="label.address3" /></td>
									<td><form:input path="add3Edit" id="add3" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><s:message code="label.city" /><font color="red">*</font></td>
									<td><form:input path="cityEdit" id="city" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><s:message code="label.state" /><font color="red">*</font></td>
									<td><form:input path="stateEdit" id="State"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><s:message code="label.country" /><font color="red">*</font></td>
									<td><form:select path="countryEdit" id="country"
											class="select">

											<form:option value="">--Select--</form:option>

											<form:options items="${country}" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.phoneNumber" /><font color="red">*</font></td>
									<td><form:input path="phoneEdit" id="phone"
											class="textbox" maxlength="12"/></td>
								</tr>
								<tr>
									<td><s:message code="label.mobileNumber" /><font color="red">*</font></td>
									<td><form:input path="mobileEdit" id="mobileEdit"
											class="textbox" maxlength="12"/></td>
								</tr>
								<tr>
									<td><s:message code="label.fax" /></td>
									<td><form:input path="faxEdit" id="fax" class="textbox" maxlength="15"/></td>
								</tr>


								<tr>
									<td><s:message code="label.organizationName" /><font color="red">*</font></td>
									<td><form:select path="orgIdEdit" id="orgId"
											class="select">
											<form:option value="">--Select--</form:option>

											<form:options items="${orgName}" />
										</form:select></td>
								</tr>
								<tr>
								<c:choose>
								
								<c:when test="${update}">

									<td><input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-primary" id="sumbnid" /></td></c:when>
										
										<c:otherwise>
										
										<td><input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" /></td>
										</c:otherwise>
								</c:choose>
								</tr>
							</table>
						</form:form>


						<!--=================== ============================================End PlantUpdate================================================= -->
					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




