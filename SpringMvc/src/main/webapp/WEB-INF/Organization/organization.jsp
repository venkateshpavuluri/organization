<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 18-09-2013 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
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
						$('#sumbnid')
								.click(
										function(event) {						
											$("#organizationAdd")
													.validate(
															{
																rules : {
																	orgName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	
																	},
																	add1 : {
																		required : true
																
																	},
																	countryId : {
																		required : true
																	},

																	state : {
																		required : true,
																		minlength:2
																	
																	},
																	city : {
																		required : true,
																		minlength:2
																	
																	},
																	phone : {
																		required : true,
																		number : true,
																		minlength:10
																		
																	},

																	email : {
																		required : true,
																		email : true
																		
																	},
																	orgTypeId : {
																		required : true
																	}

																},
																messages : {
																	orgName :
																		{
																		required:"<font style='color: red;'><b>Organization Name is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		
																		},
																		add1 : {
																			required:"<font style='color: red;'><b>Address1 is Required</b></font>",
																		
																			},
																	city : {
																		required:"<font style='color: red;'><b>City is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Minimum 2 Characters Required</b></font>",
																		
																		},
																	state : {
																		required:"<font style='color: red;'><b>State is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Minimum 2 Characters Required</b></font>",
																		
																		},
																	countryId :{
																		required:"<font style='color: red;'><b>Country is Required</b></font>",
																		
																		},
																	phone : {
																		required:"<font style='color: red;'><b>Phone Number is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Phone Number is Minimum 10 members required</b></font>",
																		
																		number:"<font style='color: red;'><b>Phone Number is not Valid</b></font>",
																		},
																	orgTypeId : "<font style='color: red;'><b>Organization Type is Required</b></font>",
																	email :{
																		required:"<font style='color: red;'><b>Email is Required</b></font>",
																		email:"<font style='color: red;'><b>Email is a not a Valid Format</b></font>",
																		
																		},
																},

															});
										});

						$('#updateId')
								.click(
										function(event) {
											
											$("#orgUpForm")
													.validate(
															{
																rules : {
																	  stateEdit: {
																			required : true,
																	       minlength:2,
																			maxlength:50
																		},  
																	orgNameEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	
																	
																	}, 
																	add1Edit : {
																		required : true,
																		maxlength:50
																	},
																	cityEdit : {
																		required : true,
																		minlength:2
																	},

																	countryIdEdit : {
																		required : true,
																		maxlength:50
																	},
																	
																	phoneEdit : {
																		required : true,
																		number : true,
																		minlength:10,
																		maxlength:50
																	},

																	emailEdit : {
																		required : true,
																		email : true,
																		maxlength:50
																	},
																	orgTypeIdEdit : {
																		required : true
																	}

																},
																messages : {
																	 stateEdit : {
																		required:"<font style='color: red;'><b>State is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Minimum 2 characters  Required</b></font>",
																		maxlength:"<font style='color: red;'><b>State only 50 Characters are allowed</b></font>"
																		},  
																 	orgNameEdit: {
																		required:"<font style='color: red;'><b>Organization Name is Required</b></font>",
																		
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																 	}, 
														 	add1Edit : {
																		required:"<font style='color: red;'><b>Address1 is Required</b></font>",
																		maxlength:"<font style='color: red;'><b>Address1 only 50 Characters are allowed</b></font>",
																		},

																	cityEdit :{
																		required:"<font style='color: red;'><b>City is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Minimum 2 characters  Required</b></font>",
																		maxlength:"<font style='color: red;'><b>City only 50 Characters are allowed</b></font>",
																		},
																		countryIdEdit : {
																			required:"<font style='color: red;'><b>Country is Required</b></font>",
																			
																		},
																	 
																	
																	phoneEdit :  {
																		required:"<font style='color: red;'><b>Phone Number is Required</b></font>",
																		minlength:"<font style='color: red;'><b>Phone Number is Minimum 10 members required</b></font>",
																		maxlength:"<font style='color: red;'><b>Phone Number only 50 Characters are allowed</b></font>",
																		},
																		emailEdit : {
																			required:"<font style='color: red;'><b>Email is Required</b></font>",
																			email:"<font style='color: red;'><b>Email is a not a Valid Format</b></font>",
																			maxlength:"<font style='color: red;'><b>Email only 50 Characters are allowed</b></font>",
																			number:"<font style='color: red;'><b>Phone Number is not Valid</b></font>",
																			},
																	orgTypeIdEdit : "<font style='color: red;'><b>Organization Type is Required</b></font>",
																	
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
		<div class="PageTitle">Organization</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${organizationValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<!-- ============================================Begin OrganizationSearch=================================================================================================== -->
					<form:form action="orgnizationSearch.mnt" method="get"
						commandName="organization">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">
								
								<c:if test="${param.list!=null}"> 
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/></strong>
											<s:message code="label.organization"/> <s:message code="label.saveSuccess"></s:message>
										</div>
									</c:if>
								<c:forEach var="organizationUpdateError"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error"/> </strong>
												<s:message code="label.organization"/> <s:message code="label.saveFail"></s:message>
										</div>
									</c:forEach>		
								<c:if test="${organizationUpdate!=null}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/></strong>
										<s:message code="label.organization"/> <s:message code="label.updateSuccess"></s:message>
										</div>
									</c:if><c:if test="${organizationUpdateError!=null }">

										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.organization"/> <s:message code="label.updateFail"></s:message>
										</div>
									</c:if><c:if test="${orgDelete!=null }">

										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/></strong>
										<s:message code="label.organization"/> <s:message code="label.deleteSuccess"></s:message>
										</div>
                                 </c:if>
								<c:if test="${orgDeleteError!=null}">

										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.organization"/> <s:message code="label.deleteFail"></s:message>
										</div>
									</c:if></td>
							</tr>

							<tr id="mainSearch">
								<td class="label" width="10%"> <s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <s:bind path="organization.operations">
										<select class="select" name="operations">
											<option value="<s:message code='assignedOperator'/>">
												<s:message code="label.equalsTo" />
											</option>
											<option value="<s:message code='notequalsOperator'/>">
												<s:message code="label.notEqualsTo" />
											</option>
											<option value="<s:message code='beginsWithOperator'/>">
												<s:message code="label.beginsWith" />
											</option>
											<option value="<s:message code='endsWithOperator'/>">
												<s:message code="label.endsWith" />
											</option>
											<option value="<s:message code='containsOperator'/>">
												<s:message code="label.contains" />
											</option>
										</select>
									</s:bind> <form:input path="basicSearchId" cssClass="textbox" /> <c:set
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
											<input type="submit" value="<s:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<s:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>

							</tr>

							<form:form action="organiztionAdvanceSearch.mnt" method="get"
								commandName="organization" name="advanceSearchFinal"
								id="advanceSearchFinal">
								<tr>
									<td colspan="2"><a href="organiztionAdvanceSearch.mnt"><font
											style="color: blue" id="aslink"><u><b>Advanced
														Search</b></u></font></a> <a href="#" id="basicSearch" style="display: none"><font
											style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td>

								</tr>
							</form:form> 
						</table>
						<form:form action="organiztionAdvanceSearchOperations.mnt"
							commandName="organization">
							<div id="advanceSearchDiv" style="display: none">
								<table class="tableGeneral">
									<c:forEach var="xmlLabelValue"
										items="${organizationSearchAdvance}">
										<tr>
											<td><label>${xmlLabelValue.secondLabel}</label><form:hidden
													path="firstLabel" id="firstLabel"
													value="${xmlLabelValue.firstLabel}" /></td>
													
											<td><s:bind path="organization.operations1">
													<select class="select" name="operations1">							
														<option value="<s:message code='assignedOperator'/>">
															<s:message code="label.equalsTo" />
														</option>
														<option value="<s:message code='notequalsOperator'/>">
															<s:message code="label.notEqualsTo" />
														</option>
														<option value="<s:message code='beginsWithOperator'/>">
															<s:message code="label.beginsWith" />
														</option>
														<option value="<s:message code='endsWithOperator'/>">
															<s:message code="label.endsWith" />
														</option>
														<option value="<s:message code='containsOperator'/>">
															<s:message code="label.contains" />
														</option>
													</select>
												</s:bind></td>

											<td><form:input path="advanceSearchText"
													 cssClass="textbox"/></td>
										</tr>

									</c:forEach>
									<c:forEach var="refList"
										items="${refList}">
										<tr>
											<td><label>${refList.secondLabel}</label> <form:hidden
													path="firstLabel" id="firstLabel"
													value="${refList.firstLabel}" /></td>
											<td><s:bind path="organization.operations1">
													<select class="select" name="operations1">							
														<option value="<s:message code='assignedOperator'/>">
															<s:message code="label.equalsTo" />
														</option>
														<option value="<s:message code='notequalsOperator'/>">
															<s:message code="label.notEqualsTo" />
														</option>
														<option value="<s:message code='beginsWithOperator'/>">
															<s:message code="label.beginsWith" />
														</option>
														<option value="<s:message code='endsWithOperator'/>">
															<s:message code="label.endsWith" />
														</option>
														<option value="<s:message code='containsOperator'/>">
															<s:message code="label.contains" />
														</option>
													</select>
												</s:bind></td>
												<c:choose>
												<c:when test="${select!=true}">
												<td>
													 <form:select class="select" path="advanceSearchText">							
														<form:option value="">--Select--</form:option>
														<form:options items="${organizationIds}" />
													 </form:select>
													 </td>
													</c:when>
													<c:otherwise>
													 <td>
													 <form:select class="select" path="advanceSearchText">							
														<form:option value="">--Select--</form:option>
														<form:options items="${country}" />
													 </form:select>
													 </td>
													 </c:otherwise>
													 </c:choose>
													 <c:set var="select" value="true"/>
										</tr>

									</c:forEach> 
									<tr>
										<form:hidden path="advanceSearchHidden"
											id="advanceSearchHidden" />
										<c:choose>
											<c:when test="${search }">
												<td colspan="3"><input type="submit"
													id="advanceSearchButtonId" value="Advance Search"
													style="display: none" class="btn btn-primary" /></td>
											</c:when>
											<c:otherwise>
												<td colspan="3"><input type="submit"
													disabled="disabled" id="advanceSearchButtonId"
													value="Advance Search" style="display: none"
													class="btn btn-danger" /></td>
											</c:otherwise>
										</c:choose>
									</tr>

								</table>

							</div>
						</form:form>
					</form:form>
					<!-- ============================================End OrganizationSearch=================================================================================================== -->

					
					<c:if test="${organizationSearch!=null}">
						<!-- ============================================Begin OrgDisplayTable=================================================================================================== -->
						<display:table id="organizationRow" name="organizationSearch"
							requestURI="orgnizationSearch.mnt" pagesize="5" class="table">
							<display:column property="orgName"
								titleKey="label.organizationName" media="html" sortable="true"></display:column>
							<display:column property="add1" titleKey="label.address1"
								media="html" sortable="true" />
							<display:column property="add2" titleKey="label.address2"
								media="none" sortable="true" />
							<display:column property="add3" titleKey="label.address3"
								media="none" sortable="true" />
							<display:column property="city" titleKey="label.city"
								media="html" sortable="true" />
							<display:column property="state" titleKey="label.state"
								sortable="true" />
							<display:column property="country" titleKey="label.country"
								sortable="true" />
							<display:column property="phone" titleKey="label.phoneNumber"
								sortable="true" />
							<display:column property="email" titleKey="label.email"
								sortable="true" />
							<display:column property="orgType"
								titleKey="label.organizationType" sortable="true" />
								
								<display:column property="fax" titleKey="label.fax"
								sortable="true" />

							<c:choose>
								<c:when test="${edit}">
									<display:column titleKey="label.edit" style="color:white">
										<a
											href="organizationEditHome.mnt?organizationEdit=<c:out value="${organizationRow.orgId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /></a>
									</display:column>
								</c:when>
								<c:otherwise>
									<display:column titleKey="label.edit" style="color:white">
										<a><img src="images/Edit.jpg" width="20px"
											height="20px"  class="btn btn-danger"/></a>
									</display:column>
								</c:otherwise>
							</c:choose>

							
									<display:column titleKey="label.delete">
									<c:choose>
								<c:when test="${delete}">
										<a
											href="organizationDelete.mnt?organizationCodeDelete=<c:out value="${organizationRow.orgId}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									
								</c:when>
								<c:otherwise>
								
										<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>

								</c:otherwise>

							</c:choose></display:column>

								<display:setProperty name="paging.banner.placement" value="bottom" />
							
						</display:table>
					</c:if>

				</div>
			</div>
			<!-- ============================================End OrgDisplayTable=================================================================================================== -->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table class="tableGeneral">
						<!-- ============================================Begin Organization Add=================================================================================================== -->
						<tr>
							<td colspan="2"><c:forEach var="duplicatei"
									items="${duplicate}">
									<div class="alert-warning">
										<strong> <s:message code="label.warning"/> </strong>
										<s:message code="label.organizationName"/> <s:message code="label.duplicateCheck"></s:message>
									<%-- 	<c:out value="${duplicatei}"></c:out> --%>
									</div>
								</c:forEach></td>
						</tr>
					</table>
					<form:form action="organizationAdd.mnt" method="POST"
						commandName="organization" ENCTYPE="multipart/form-data"
						id="organizationAdd">

						<table>
							<form:hidden path="aid" />
							<tr>
								<td><s:message code="label.organizationName"></s:message><font
									color="red">*</font></td>
								<td><form:input path="orgName" id="orgName" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.address1"></s:message><font
									color="red">*</font></td>
								<td><form:input path="add1" id="add1" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.address2"></s:message></td>
								<td><form:input path="add2" id="add2" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.address3"></s:message></td>
								<td><form:input path="add3" id="add3" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.city"></s:message><font
									color="red">*</font></td>
								<td><form:input path="city" id="city" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.state"></s:message><font
									color="red">*</font></td>
								<td><form:input path="state" id="state" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.country"></s:message><font
									color="red">*</font></td>
								<td><form:select path="countryId" id="countryId"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${country}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.phoneNumber"></s:message><font
									color="red">*</font></td>
								<td><form:input path="phone" id="phone" class="textbox"
										maxlength="12" /></td>
							</tr>
							<tr>
								<td><s:message code="label.fax"></s:message></td>
								<td><form:input path="fax" id="fax" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.email"></s:message><font
									color="red">*</font></td>
								<td><form:input path="email" id="email" class="textbox"
										maxlength="50" /></td>
							</tr>

							<tr>
								<td><s:message code="label.organizationType"></s:message><font
									color="red">*</font></td>
								<td><form:select path="orgTypeId" id="orgTypeId"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${organizationIds}" />
									</form:select></td>
							</tr>
							<tr>

								<td>Please select a file to upload :</td>
								<td><form:input type="file" path="imageFile" /></td>
							</tr>
							<tr>

								<%-- 	<c:if test="${privileges eq message}"> --%>
								

										<td>
										<c:choose>
									<c:when test="${save}">
										<input type="submit"
											value='<s:message code="label.save"/>'
											class="btn btn-primary" id="sumbnid" /> 
									</c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<s:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose><input type="reset"
											value='<s:message code="label.reset"/>'
											class="btn btn-primary" /> </td>

							</tr>
						</table>
					</form:form>
					<!-- ============================================End OrganizationAdd=================================================================================================== -->


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<!-- ============================================Begin organizationUpdate=================================================================================================== -->
					<c:forEach var="orgEditValues" items="${organizationValues }">
						<form:form action="organizationUpdate.mnt" method="POST"
							commandName="organization" enctype="multipart/form-data"
							id="orgUpForm">
							<table>
								<tr>
									<td colspan="2"><c:forEach var="orgDupId"
											items="${orgUpdateDuplicate}">
											<div class="alert-warning">
												<strong><s:message code="label.warning"/> </strong>
											<s:message code="label.organizationName"/> 	<s:message code="label.duplicateCheck"/>

											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="orgIdEdit" />
								<tr>
									<td><s:message code="label.organizationName" /><font
										color="red">*</font></td>
									<td><form:input path="orgNameEdit" 
											class="textbox"  /></td>
								</tr>
								<tr>
									<td><s:message code="label.address1" /><font color="red">*</font></td>
									<td><form:input path="add1Edit"  class="textbox"
											maxlength="50" /></td>
								</tr>
								<tr>
									<td><s:message code="label.address2" /></td>
									<td><form:input path="add2Edit"  class="textbox"
											maxlength="50" /></td>
								</tr>
								<tr>
									<td><s:message code="label.address3" /></td>
									<td><form:input path="add3Edit" class="textbox"
											maxlength="50" /></td>
								</tr>
								<tr>
									<td><s:message code="label.city" /><font color="red">*</font></td>
									<td><form:input path="cityEdit" 
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><s:message code="label.state" /><font color="red">*</font></td>
									<td><form:input path="stateEdit"
											class="textbox"  /></td>
								</tr>
								<tr>
									<td><s:message code="label.country" /><font color="red">*</font></td>
									<td><form:select path="countryIdEdit" 
											class="select">
											<form:option value="">--Select--</form:option>

											<form:options items="${country}" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.phoneNumber" /><font
										color="red">*</font></td>
									<td><form:input path="phoneEdit" 
											class="textbox" maxlength="12" /></td>
								</tr>
								<tr>
									<td><s:message code="label.fax" /></td>
									<td><form:input path="faxEdit"
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><s:message code="label.email" /><font color="red">*</font></td>
									<td><form:input path="emailEdit" 
											class="textbox" maxlength="50" /></td>
								</tr>

								<tr>
									<td><s:message code="label.organizationType" /><font
										color="red">*</font></td>
									<td><form:select path="orgTypeIdEdit" id="orgTypeIdEdit"
											class="select">
											<form:option value="">--Select--</form:option>

											<form:options items="${organizationIds}" />
										</form:select></td>
								</tr>
									<form:hidden path="imageEdit" />
								<c:forEach var="image" items="${image }"> 
									<tr>
							
										<td>Image</td>
										<td><img src="imageEdit.mnt?imageid=<c:out value="${imageId}"/>" width="70px"
											height="70px" /></td>
									</tr>
								</c:forEach> 
								<tr>

									<td>Please select a Image to upload :</td>
									<td><form:input  alt="No Image" type="file"   path="imageFile" /></td>

								</tr>
								<tr>


									<c:choose>
										<c:when test="${update}">
											<td><input type="submit"
												value="<s:message code="label.update"/>"
												class="btn btn-primary" id="updateId" /></td>
										</c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<s:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
										</c:otherwise>

									</c:choose>
								</tr>
							</table>
						</form:form>
						<!-- ============================================End organizationEdit=================================================================================================== -->
					</c:forEach>
				</div>
			</div>
		</div>
		</div>
</body>
</html>