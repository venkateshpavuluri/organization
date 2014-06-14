<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/demos/style.css" />

<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		jQuery.validator.addMethod("alphaNumeric", function(value, element) {
			return this.optional(element) || /^[0-9a-zA-Z&_ ]+$/.test(value);
		});

	});
</script>

<script language="javascript" type="text/javascript">
<!--
function popitup() {
	var filepath =document.getElementById("docPathEdit").value;
	
	//$("#resumelink").attr('href', filepath);
	newwindow=window.open(filepath,'name','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=800,width=900');
	
	if (window.focus) {
		newwindow.focus();
		}
	return false;
}

// -->
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				jQuery.validator.addMethod("startWithAlphabet", function(value,
						element) {
					return this.optional(element)
							|| /^[a-zA-Z][0-9a-zA-Z&_ ]+$/.test(value);
				});

			});
</script>
<script type="text/javascript">
function textDisplay()
{
	var filepath =document.getElementById("docPathEdit").value;
	
	$("#resumelink").attr('href', filepath);
	}
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

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

		});
	});
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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumbnid')
								.click(
										function(event) {
										

											$("#applicantAdd")
													.validate(
															{
																rules : {
																	fname : {
																		required : true,
																		alphaNumeric:true,
																		startWithAlphabet:true
																	
																	},
																	lname : {
																		required : true,
																		alphaNumeric:true,
																		startWithAlphabet:true
																
																	},
																	phoneNo : {
																		required : true,
																		minlength: 10
																	},

																	email : {
																		required : true,
																		email: true
																	
																	},
																	vacancyDetailNo : {
																		required : true,
																		
																	
																	},
																	docPath : {
																		required : true,
																		
																		
																	},


																},
																messages : {
																	fname :
																		{
																		required:"<font style='color: red;'><b>FirstName is Required</b></font>",
																		alphaNumeric:"<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																		startWithAlphabet : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>"
																		
																		},
																		lname : {
																			required:"<font style='color: red;'><b>LastName is Required</b></font>",
																			alphaNumeric:"<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																			startWithAlphabet : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>"
																			
																		
																			},
																																																				
																			phoneNo : {
																		required:"<font style='color: red;'><b>Phone Number is Required</b></font>",
																		minlength:"<font style='color: red;'><b> Minimum 10 members required</b></font>",
																		
																		number:"<font style='color: red;'><b>Phone Number is not Valid</b></font>",
																		},
																	email :{
																		required:"<font style='color: red;'><b>Email is Required</b></font>",
																		email:"<font style='color: red;'><b>Email is a not a Valid Format</b></font>",
																		
																		},
																		vacancyDetailNo : "<font style='color: red;'><b>VacancyDetail Number is Required</b></font>",
																		docPath :"<font style='color: red;'><b>Select one file to upload</b></font>",
																		
																},

															});
										});

						$('#updateId')
								.click(
										function(event) {
											
											$("#applicantUpdateForm")
													.validate(
															{
																rules : {
																	fnameEdit : {
																		required : true,
																		alphaNumeric:true,
																		startWithAlphabet:true
																	
																	},
																	lnameEdit : {
																		required : true,
																		alphaNumeric:true,
																		startWithAlphabet:true
																
																	},
																	phoneNoEdit : {
																		required : true,
																		minlength: 10
																	},

																	emailEdit : {
																		required : true,
																		email: true
																	
																	},
																	vacancyDetailNoEdit : {
																		required : true,
																		number: true
																	
																	},
																	docPathEdit : {
																		required : true,
																		
																		
																	},


																},
																messages : {
																	fnameEdit :
																	{
																	required:"<font style='color: red;'><b>FirstName is Required</b></font>",
																	alphaNumeric:"<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	startWithAlphabet : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>"
																	
																	},
																	lnameEdit : {
																		required:"<font style='color: red;'><b>LastName is Required</b></font>",
																		alphaNumeric:"<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																		startWithAlphabet : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>"
																		
																	
																		},
																																																			
																phoneEdit : {
																	required:"<font style='color: red;'><b>Phone Number is Required</b></font>",
																	minlength:"<font style='color: red;'><b> Minimum 10 members required</b></font>",
																	
																	number:"<font style='color: red;'><b>Phone Number is not Valid</b></font>",
																	},
																emailEdit :{
																	required:"<font style='color: red;'><b>Email is Required</b></font>",
																	email:"<font style='color: red;'><b>Email is a not a Valid Format</b></font>",
																	
																	},
																	vacancyDetailNoEdit : "<font style='color: red;'><b>VacancyDetail Number is Required</b></font>",
																	docPathEdit :"<font style='color: red;'><b>Select one file to upload</b></font>",
														
																},

															});
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
		<div class="PageTitle">Applicant</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="applicantValues" items="${applicantValues}">
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
					<form:form action="applicantSearch.mnt" method="get"
						commandName="applicant">

						<table class="tableGeneral">
							<tr>
								<td colspan="3">
								
								<c:if test="${param.list!=null}"> 
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/></strong>
											<s:message code="label.applicant"/> <s:message code="label.saveSuccess"></s:message>
										</div>
									</c:if>
								<c:forEach var="applicantUpdateError"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error"/> </strong>
												<s:message code="label.applicant"/> <s:message code="label.saveFail"></s:message>
										</div>
									</c:forEach>
							
								
								<c:if test="${applicantUpdate!=null}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/></strong>
										<s:message code="label.applicant"/> <s:message code="label.updateSuccess"></s:message>
										</div>
									</c:if><c:if test="${applicantUpdateError!=null }">

										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.applicant"/> <s:message code="label.updateFail"></s:message>
										</div>
									</c:if><c:if test="${applicantDelete!=null }">

										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/></strong>
										<s:message code="label.applicant"/> <s:message code="label.deleteSuccess"></s:message>
										</div>
                                 </c:if>
								<c:if test="${applicantDeleteError!=null}">

										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.applicant"/> <s:message code="label.deleteFail"></s:message>
										</div>
									</c:if></td>

							</tr>
							

							<tr id="mainSearch">
								<td> <s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <s:bind path="applicant.operations">
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
										<c:when test="${true}">
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

							
						</table>
						
					</form:form>
					<!-- ============================================End OrganizationSearch=================================================================================================== -->

						<c:set var="g" value="${applicantSearch}"></c:set>
					
					<c:if test="${g!=null}">
						<!-- ============================================Begin OrgDisplayTable=================================================================================================== -->
						<display:table id="applicantRow" name="applicantSearch"
							requestURI="applicantSearch.mnt" pagesize="5" class="table">
							<display:column property="fname"
								titleKey="label.fname" media="html" sortable="true"></display:column>
							<display:column property="lname" titleKey="label.lname"
								media="html" sortable="true" />
							<display:column property="mname" titleKey="label.mname"
								media="html" sortable="true" />
							<display:column property="phoneNo" titleKey="label.phone"
								media="html" sortable="true" />
							<display:column property="email" titleKey="label.email"
								media="html" sortable="true" />
							<display:column property="vacancyDetailNo" titleKey="label.vacancyDetailNo"
								sortable="true" />
							<display:column property="refNo" titleKey="label.refNo"
								sortable="true" />
							<%-- <display:column property="docPath" titleKey="label.docPath"
								sortable="true" /> --%>
							<display:column property="shortListed" titleKey="label.shortListed"
								sortable="true" />
							<display:column property="selected" titleKey="label.selected"
								sortable="true" />
							<display:column property="joined"
								titleKey="label.joined" sortable="true" />

							<c:choose>
								<c:when test="${true}">
									<display:column titleKey="label.edit" style="color:white">
										<a
											href="applicantEditHome.mnt?applicantEdit=<c:out value="${applicantRow.applicant_Id}"/>"
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
								<c:when test="${true}">
										<a
											href="applicantDelete.mnt?applicantCodeDelete=<c:out value="${applicantRow.applicant_Id}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									
								</c:when>
								<c:otherwise>
								
										<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>

								</c:otherwise>

							</c:choose></display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
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
							<td colspan="2"><c:forEach var="duplicate"
									items="${duplicate}">
									<div class="alert-warning">
										<strong> <s:message code="label.warning"/> </strong>
										<s:message code="label.applicant"/> <s:message code="label.duplicateCheck"></s:message>
									<%-- 	<c:out value="${duplicatei}"></c:out> --%>
									</div>
								</c:forEach></td>
						</tr>
					</table>
					<form:form action="applicantAdd.mnt" method="POST"
						commandName="applicant" ENCTYPE="multipart/form-data"
						 id="applicantAdd"> 

						<table>
							<form:hidden path="aid" />
							<tr>
								<td><s:message code="label.fname"></s:message><font
									color="red">*</font></td>
								<td><form:input path="fname" id="fname" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.lname"></s:message><font
									color="red">*</font></td>
								<td><form:input path="lname" id="lname" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.mname"></s:message></td>
								<td><form:input path="mname" id="mname" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.phoneNo"></s:message><font color="red">*</font></td>
								<td><form:input path="phoneNo" id="phoneNo" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.email"></s:message><font
									color="red">*</font></td>
								<td><form:input path="email" id="email" class="textbox"
										maxlength="50" /></td>
							</tr>
							
							<tr>
								<td><s:message code="label.vacancyDetailNo"></s:message><font
									color="red">*</font></td>
								<td><form:select path="vacancyDetail_Id" id="vacancyDetailNo"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${vacancyIds}" />
									</form:select></td>
							</tr>
							
							<tr>
								<td><s:message code="label.refNo"></s:message>
									</td>
								<td><form:input path="refNo" id="refNo" class="textbox"
										maxlength="50" /></td>
							</tr>
							
													
							<tr>
								<td><s:message code="label.shortListed" /></td>
								
							<td><form:select path="shortListed" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">YES</form:option>
								         <form:option value="false">NO</form:option>
								</form:select></td>
							</tr>
							
							<tr>
								<td><s:message code="label.selected" /></td>
								
							<td><form:select path="selected" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">YES</form:option>
								         <form:option value="false">NO</form:option>
								</form:select></td>
							</tr>
							
							<tr>
								<td><s:message code="label.joined" /></td>
								
							<td><form:select path="joined" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">YES</form:option>
								         <form:option value="false">NO</form:option>
								</form:select></td>
							</tr>
							
							<tr>

								<td>Please select a file to upload :<font
									color="red">*</font></td>
								<td><form:input type="file" path="imageFile" id="imageId"/></td>
							</tr>
							
							
							<tr>

									<td>
										<c:choose>
									<c:when test="${true}">
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
					<c:forEach var="applicantValues" items="${applicantValues }">
						<form:form action="applicantUpdate.mnt" method="POST"
							commandName="applicant" ENCTYPE="multipart/form-data"
							id="applicantUpdateForm"> 
							<table>
								<tr>
									<td colspan="2"><c:forEach var="applicantUpdateDuplicate"
											items="${applicantUpdateDuplicate}">
											<div class="alert-warning">
												<strong><s:message code="label.warning"/> </strong>
											<s:message code="label.applicant"/> <s:message code="label.duplicateCheck"/>

											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="applicant_IdEdit" />
								<tr>
								<td><s:message code="label.fname"></s:message><font
									color="red">*</font></td>
								<td><form:input path="fnameEdit" id="fnameEdit" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.lname"></s:message><font
									color="red">*</font></td>
								<td><form:input path="lnameEdit" id="lnameEdit" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.mname"></s:message></td>
								<td><form:input path="mnameEdit" id="mnameEdit" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.phoneNo"></s:message><font
									color="red">*</font></td>
								<td><form:input path="phoneNoEdit" id="phoneNoEdit" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.email"></s:message><font
									color="red">*</font></td>
								<td><form:input path="emailEdit" id="emailEdit" class="textbox"
										maxlength="50" /></td>
							</tr>
							
							<tr>
								<td><s:message code="label.vacancyDetailNo"></s:message><font
									color="red">*</font></td>
								<td><form:select path="vacancyDetail_IdEdit" id="vacancyDetailNoEdit"
										class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${vacancyIds}" />
									</form:select></td>
							</tr>
							
							<tr>
								<td><s:message code="label.refNo"></s:message></td>
								<td><form:input path="refNoEdit" id="refNoEdit" class="textbox"
										maxlength="50" /></td>
							 </tr>
						
							 	<form:hidden path="dbDocPath" /> 
								
															
							
					<tr>
								<td><s:message code="label.shortListed" /></td>
								
							<td><form:select path="shortListedEdit" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">YES</form:option>
								         <form:option value="false">NO</form:option>
								</form:select></td>
							</tr>
							
							<tr>
								<td><s:message code="label.selected" /></td>
								
							<td><form:select path="selectedEdit" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">YES</form:option>
								         <form:option value="false">NO</form:option>
								</form:select></td>
							</tr>
							
							<tr>
								<td><s:message code="label.joined" /></td>
								
							<td><form:select path="joinedEdit" class="select">
										 <form:option value="">--Select--</form:option>
										 <form:option value="true">YES</form:option>
								         <form:option value="false">NO</form:option>
								</form:select></td>
							</tr>
							
                             <tr> 
                                       <form:hidden path="docPathEdit" id="docPathEdit"/>
									<td>Please select a File to upload :<font
									color="red">*</font></td>
									<td><form:input  alt="No Image" type="file"   path="imageFileEdit" /></td>
  
								<td><a href="" id="resumelink" onclick="return popitup()"><img src="images/viewimage.png"
											width="30px" height="30px" /></a></td>
		                      </tr>

                        							
							
								<tr>
									<c:choose>
										<c:when test="${true}">
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
		

</body>
</html>