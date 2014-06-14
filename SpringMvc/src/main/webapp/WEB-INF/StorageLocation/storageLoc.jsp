<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 23-09-2013 -->

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
	$(document)
			.ready(
					function() {
						
						$('#sumbnid')
								.click(
										function(event) {
									
											$('#slADD')
													.validate(
															{
																rules : {
																	storageLocation : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	add1 : {
																		required : true
																		
																	},

																	city : {
																		required : true,
																	      minlength:2
																		
																	},
																	state : {
																		required : true,
																		  minlength:2
																			
																	},
																	country : {
																		required : true
																	},
																	phone : {
																		required : true,
																		number:true,
																		minlength:10
																		
																	},
																	mobile : {
																		required : true,
																		number:true,
																		minlength:10
																		
																	},
																	plantId : {
																		required : true
																	},
																	

																},
																messages : {
																	storageLocation : {
																		required:"<font style='color: red;'><b>Storage Location is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	add1 : 
																		{
																		required:	"<font style='color: red;'><b>Address1 is Required</b></font>",
																	
																		},
																	city :
																		{
																		required:"<font style='color: red;'><b>City is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Minimum 2 Characters Required</b></font>"
																		
																		},
																		state : 
																			{
																		required:"<font style='color: red;'><b>State is Required</b></font>",
																			minlength:"<font style='color: red;'><b>Minimum 2 Characters Required</b></font>"
																			},
																	country : "<font style='color: red;'><b>Country is Required</b></font>",

																	mobile : {
																		
																		required:"<font style='color: red;'><b>Mobile Number is Required</b></font>",
																		number:"<font style='color: red;'><b>Mobile Number is Must be Number</b></font>",
																	    minlength:"<font style='color: red;'><b>Mobile Number  Must be 10 Number</b></font>"
																	  
																	},
																	plantId : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	phone :{
																	required:"<font style='color: red;'><b>Phone Number is Required</b></font>",
																	number:"<font style='color: red;'><b>Phone Number is Must be Number</b></font>",
																	minlength:"<font style='color: red;'><b>Phone Number  Must be 10 Number</b></font>"
																	
																	}

																},

															});
										});

						$('#editbtn')
								.click(
										function(event) {
											$("#slEdit")
													.validate(
															{
																rules : {
																 	  storageLocationEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	}, 
																	add1Edit : {
																		required : true
																	},

																	cityEdit : {
																		required : true,
																		 minlength:2
																	},
																	stateEdit : {
																		required : true,
																		 minlength:2
																	},
																	countryEdit : {
																		required : true
																	},
																	phoneEdit : {
																		required : true,
																		number:true,
																		minlength:10
																	},
																	
																	plantIdEdit : {
																		required : true
																	},
																	mobileEdit : {
																		required : true,
																		number:true,
																		minlength:10
																	}
																	
																},
																messages : {
																	
                                                               storageLocationEdit : {
																		required:"<font style='color: red;'><b>Storage Location is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
                                                               
                                                               },  
																	add1Edit : 
																		{
																		required:	"<font style='color: red;'><b>Address1 is Required</b></font>",
																	
																		},
																	cityEdit :
																		{
																		required:"<font style='color: red;'><b>City is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Minimum 2 Characters Required</b></font>"
																		
																		},
																		stateEdit : 
																			{
																		required:"<font style='color: red;'><b>State is Required</b></font>",
																			minlength:"<font style='color: red;'><b>Minimum 2 Characters Required</b></font>"
																			},
																	countryEdit : "<font style='color: red;'><b>Country is Required</b></font>",

																	mobileEdit : {
																		
																		required:"<font style='color: red;'><b>Mobile Number is Required</b></font>",
																		number:"<font style='color: red;'><b>Mobile Number is Must be Number</b></font>",
																	    minlength:"<font style='color: red;'><b>Mobile Number  Must be 10 Number</b></font>"
																	},
																	plantIdEdit : "<font style='color: red;'><b>Plant Name is Required</b></font>",
																	phoneEdit :{
																	required:"<font style='color: red;'><b>Phone Number is Required</b></font>",
																	number:"<font style='color: red;'><b>Phone Number is Must be Number</b></font>",
																	minlength:"<font style='color: red;'><b>Phone Number  Must be 10 Number</b></font>"
																	
																	}
																	
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
		$("#tabs1").tabs();
	});
</script>
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
			
			$("#advanceSearchButtonId").hide();
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
	$(function() {
		$('#basicSearch').click(function() {
			$('#advanceSearchButtonId').hide();
			$("#advanceSearchHidden").val("0");
			$("#aslink").show();
			$('#mainSearch').show();
			$('#advanceSearchDiv').hide();
			$('#advanceSearch').show();
			$('#basicSearch').hide();
			$('#advanceSearchButtonId').hide();
			
			
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
		<div class="PageTitle">
			<s:message code="label.storageLocation"></s:message>
		</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="storageSearch" items="${storageSearchEdit}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /> </a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /> </a></li>
			</ul>
			<!--=================== ============================================Begin Storage Location Search================================================= -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="storageSearch.mnt" method="get"
						commandName="storageLocation">
						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach var="organizationTypeUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/></strong>
											<s:message code="label.storageLocation"/> <s:message code="label.saveSuccess"/>
											
										</div>
									</c:forEach><c:forEach var="organizationTypeUpdate"
										items="${param.listw}">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.warning"/> </strong>
										<s:message code="label.storageLocation"/> <s:message code="label.saveFail"/>
								
										</div>
									</c:forEach><c:forEach var="storageUpdate"
										items="${storageUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/> </strong>
										<s:message code="label.storageLocation"/> <s:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="storageUpdateError"
										items="${storageUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.success"/></strong>
											<s:message code="label.storageLocation"/> <s:message code="label.updateFail"/>
										
										</div>
									</c:forEach><c:forEach var="storageDelete"
										items="${storageDelete}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/> </strong>
										<s:message code="label.storageLocation"/> <s:message code="label.deleteSuccess"/>
										</div>
									</c:forEach><c:forEach var="storageDeleteError"
										items="${storageDeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.storageLocation"/> <s:message code="label.deleteFail"/>
										
										</div>
									</c:forEach></td>
							</tr>
							
							
							
							
							<tr id="mainSearch">
								<td><s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <s:bind path="storageLocation.operations">
								<select class="select" name="operations">
								<option value="<s:message code='assignedOperator'/>"><s:message code="label.equalsTo"/> </option>
								<option value="<s:message code='notequalsOperator'/>"><s:message code="label.notEqualsTo"/> </option>
							 <option value="<s:message code='beginsWithOperator'/>"> <s:message code="label.beginsWith"/> </option> 
								<option value="<s:message code='endsWithOperator'/>"><s:message code="label.endsWith"/> </option>
								<option value="<s:message code='containsOperator'/>"><s:message code="label.contains"/></option>
								</select>
									 </s:bind>  <form:input path="basicSearchId" cssClass="textbox" /></td>
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
									 <c:choose>
									 <c:when test="${search }">
								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td> </c:when>
									<c:otherwise>
									<td><input type="submit" disabled="disabled"
									value="<s:message code="label.search"/>"
									class="btn btn-danger" /></td>
									</c:otherwise>
									 </c:choose>
							</tr>
							<form:form action="storageAdvanceSearch.mnt" method="get"
							commandName="storageLocation" name="advanceSearchFinal" id="advanceSearchFinal">
							<tr>
								<td colspan="2">
									<a href="storageAdvanceSearch.mnt"><font
										style="color: blue" id="aslink"><u><b>Advanced Search</b></u></font></a>
										<a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							
							</tr>
						</form:form>
						</table>
						<form:form action="storageAdvanceSearchOperations.mnt"
						commandName="storageLocation">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${storageSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label><form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td> <s:bind path="storageLocation.operations1">
								<select class="select" name="operations1">
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
										<c:when test="${search }">
						
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
					<!--=================== ============================================End Storage Location Search================================================= -->


					<!--=================== ============================================Begin Display Table================================================= -->

					<c:if test="${storageSearch!=null}">
						<display:table id="storageLocRow" name="storageSearch"
							requestURI="storageSearch.mnt" pagesize="5" class="table">
							<display:column property="storageLocation"
								titleKey="label.storageLocation" media="html" sortable="true"></display:column>
							<display:column property="plantName" titleKey="label.plantName"
								media="html" sortable="true"></display:column>
							<display:column property="add1" titleKey="label.address1"
								media="html" sortable="true" />
							<display:column property="add2" titleKey="label.address2"
								media="html" sortable="true" />
							<display:column property="add3" titleKey="label.address3"
								media="html" sortable="true" />
							<display:column property="city" titleKey="label.city"
								sortable="true" />
							<display:column property="state" titleKey="label.state"
								sortable="true" />
							<display:column property="zip" titleKey="label.zip" media="html"
								sortable="true"></display:column>
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
							
							
								<a
									href="storageLocEdit.mnt?storageLocEdit=<c:out value="${storageLocRow.storageLocationId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"  width="20px"
									height="20px" /> </a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete }">
							
						
								<a
									href="storageDelete.mnt?storageDelete=<c:out value="${storageLocRow.storageLocationId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>	</c:when>
									<c:otherwise>
									<a><img
									src="images/Delete.jpg" class="btn btn-danger"  width="20px" height="20px" /></a>
									</c:otherwise>
							</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
							<display:setProperty name="paging.banner.group_size" value="3" />

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>
					</c:if>
					<!--=================== ============================================End DisplayTable================================================= -->

				</div>
			</div>
			<!--=================== ============================================Begin Storage Location Add================================================= -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="storageLocAdd.mnt" method="POST"
						commandName="storageLocation" id="slADD">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="duplicateid"
										items="${duplicate}">
										<div class="alert-warning">
										<strong><s:message code="label.warning"/> </strong>
										<s:message code="label.storageLocationName"/> <s:message code="label.duplicateCheck"/>
										
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" />
							<tr>
								<td><s:message code="label.storageLocationName" /><font
									color="red">*</font></td>
								<td><form:input path="storageLocation"   class="textbox" maxlength="50" />
								</td>
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

										<form:option value="">--Select--</form:option>

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
								<td><s:message code="label.zip" /></td>
								<td><form:input path="zip" id="zip" class="textbox" maxlength="15"/></td>
							</tr>
							<tr>
								<td><s:message code="label.plantName"/><font color="red">*</font></td>
								<td><form:select path="plantId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${plantIds}" />
									</form:select></td>
							</tr>
							<%-- <tr>
								<td><s:message code="label.organizationName"/></td>
								<td><form:checkboxes cssClass="checkbox" items="${orgName}"
										path="orgId" element="ul"/></td>
							</tr> --%>

							<tr>
							<td>
							<c:choose>
							<c:when test="${save}">
								<input type="submit"
									value="<s:message code="label.save"/> " class="btn btn-primary"
									id="sumbnid" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<s:message code="label.save"/> " class="btn btn-danger"
									id="sumbnid" />
									</c:otherwise>
							</c:choose><input type="reset"
									value="<s:message code="label.reset"/> "
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<!--=================== ============================================End Storage Location Add================================================= -->


			<!--=================== ============================================Begin Storage Location Update================================================= -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="storageSearchEdit" items="${storageSearchEdit }">
						<table>

							<tr>
								<td colspan="2"><c:forEach var="storageDup"
										items="${storageLocUpdateDup }">
										<div class="alert-warning">
										<strong><s:message code="label.warning"/> </strong>
										<s:message code="label.storageLocationName"/> <s:message code="label.duplicateCheck"/>
									
										</div>
									</c:forEach></td>
							</tr>
						</table>
						<form:form action="storageUpdate.mnt" method="POST"
							commandName="storageLocation" id="slEdit">
							<table>

								<form:hidden path="storageLocationIdEdit" />
								<tr>
									<td><s:message code="label.storageLocationName" /><font
										color="red">*</font></td>
									<td><form:input path="storageLocationEdit" class="textbox" maxlength="50"/>
									</td>
								</tr>

								<tr>
									<td><s:message code="label.address1" /><font
										color="red">*</font></td>
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
									<td><s:message code="label.city" /><font
										color="red">*</font></td>
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
									<td><s:message code="label.phoneNumber" /><font
										color="red">*</font></td>
									<td><form:input path="phoneEdit" id="phoneEdit"
											class="textbox" maxlength="12"/></td>
								</tr>
								<tr>
									<td><s:message code="label.mobileNumber" /><font
										color="red">*</font></td>
									<td><form:input path="mobileEdit" id="phone"
											class="textbox" maxlength="12"/></td>
								</tr>
								<tr>
									<td><s:message code="label.fax" /></td>
									<td><form:input path="faxEdit" id="fax" class="textbox" maxlength="15"/></td>
								</tr>
								<tr>
									<td><s:message code="label.zip" /></td>
									<td><form:input path="zipEdit" id="zip" class="textbox" maxlength="15"/></td>
								</tr>
								<tr>
									<td><s:message code="label.plantName" /><font
										color="red">*</font></td>
									<td><form:select path="plantIdEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${plantIds}" />
										</form:select></td>
								</tr>
								<%-- <tr>
									<td><s:message code="label.organizationName" /></td>
									<td><form:checkboxes cssClass="checkbox" element="ul"
											items="${orgName}" path="orgIdEdit" /></td>
								</tr> --%>

								<tr>
								<c:choose>
								<c:when test="${update}">
								
								
									<td><input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-primary" id="editbtn" /></td></c:when>
										<c:otherwise>
										<td><input type="submit" disabled="disabled"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" id="editbtn" /></td>
										</c:otherwise>
								</c:choose>
								</tr>
							</table>
						</form:form>
					</c:forEach>
					<!--=================== ============================================End Storage Location Update================================================= -->

				</div>
			</div>


		</div>
</body>
</html>




