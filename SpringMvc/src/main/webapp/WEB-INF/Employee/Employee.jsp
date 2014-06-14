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
<title>My JSP 'AssertTypeTemplate.jsp' starting page</title>
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
	$(document)
			.ready(
					function() {
						var x = document.getElementById("male").checked;
						//AddForm Validations
						$('#submit')
								.click(
										function(event) {

											$('#addform')
													.validate(
															{
																rules : {
																	employeeNo:{
																		required: true
																	},
																	fName :{
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},
																	lName : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},
																	gender : "required",
																	dOB : {
																		required : true
																	},
																	 dOJ : {
																		required : true
																	},
																	pAdd : {
																		required : true
																	},
																	pCity : {
																		required : true,
																		specialcharacters: true
																	},
																	pState : {
																		required : true,
																		specialcharacters: true
																	},
																	pCountry : {
																		required : true
																	},
																	tAdd : {
																		required : true
																	},
																	tCity : {
																		required : true,
																		specialcharacters: true
																	},
																	tState : {
																		required : true,
																		specialcharacters: true
																	},
																	tCountry : {
																		required : true
																	},
																	eMail : {
																		required : true,
																		email : true
																	},
																	phone : {
																		required : true,
																		number : true,
																		minlength : 10
																	},
																	mobile : {
																		required : true,
																		number : true,
																		minlength : 10
																	},
																	status : {
																		required : true
																	},
																	org_Id : {
																		required : true
																	},
																	department_Id : {
																		required : true
																	},
																	employeeGroup_Id : {
																		required : true
																	},
																																																	
																},
																messages : {
																	employeeNo:"<font style='color: red;'><b>Employee number is Required</b></font>",
																	fName : {
																		required: "<font style='color: red;'><b>FirstName is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},

																	lName : {
																		required: "<font style='color: red;'><b>LastName is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																	dOB : "<font style='color: red;'><b>Date Of Birth is Required</b></font>",

																	dOJ : "<font style='color: red;'><b>Date Of Joining is Required</b></font>",

																	pAdd : "<font style='color: red;'><b>Permanent Address is Required</b></font>",

																	pCity : {
																		required:"<font style='color: red;'><b>Permanent City is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},

																	pState :{
																		required:"<font style='color: red;'><b>Permanent State is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},
																	pCountry : "<font style='color: red;'><b>Permanent Country is Required</b></font>",

																	tAdd : "<font style='color: red;'><b>Temporary Address is Required</b></font>",

																	tCity : {
																		required:"<font style='color: red;'><b>Temporary City is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},

																	tState : {
																		required:"<font style='color: red;'><b>Temporary State is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},

																	tCountry : "<font style='color: red;'><b>Temporary Country is Required</b></font>",

																	eMail : "<font style='color: red;'><b>Email is Required And Must be Email Format</b></font>",

																	phone : "<font style='color: red;'><b>Phone Number is Required And Must be Number</b></font>",

																	mobile : "<font style='color: red;'><b>Mobile is Required And Must be 10 Numbers</b></font>",

																	status : "<font style='color: red;'><b>Status is Required</b></font>",
																	
																	org_Id : "<font style='color: red;'><b>Organization is Required</b></font>",

																	department_Id : "<font style='color: red;'><b>Department is Required</b></font>",

																	employeeGroup_Id : "<font style='color: red;'><b>Employee Group is Required</b></font>",


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
																	employeeNoEdit:{
																		required: true
																	},
																	fNameEdit : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},
																	lNameEdit : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},
																	genderEdit : {
																		required : true
																	},
																	dOBEdit : {
																		required : true
																	},
																	 dOJEdit : {
																		required : true
																	},
																	pAddEdit : {
																		required : true
																	},
																	pCityEdit :  {
																		required : true,
																		specialcharacters: true
																	},
																	pStateEdit :  {
																		required : true,
																		specialcharacters: true
																	},
																	pCountryEdit : {
																		required : true
																	},
																	tAddEdit : {
																		required : true
																	},
																	tCityEdit :  {
																		required : true,
																		specialcharacters: true
																	},
																	tStateEdit :  {
																		required : true,
																		specialcharacters: true
																	},
																	tCountryEdit : {
																		required : true
																	},
																	eMailEdit : {
																		required : true,
																		email : true
																	},
																	phoneEdit : {
																		required : true,
																		number : true,
																		minlength : 10
																	},
																	mobileEdit : {
																		required : true,
																		number : true,
																		minlength : 10
																	},
																	statusEdit : {
																		required : true
																	}, 
																	org_IdEdit : {
																		required : true
																	},
																	department_IdEdit : {
																		required : true
																	},
																	employeeGroup_IdEdit : {
																		required : true
																	},

																},
																messages : {
																	employeeNoEdit:"<font style='color: red;'><b>Employee number is Required</b></font>",
																	fNameEdit : {
																		required: "<font style='color: red;'><b>FirstName is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																	lNameEdit : {
																		required: "<font style='color: red;'><b>FirstName is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																	genderEdit : "<font style='color: red;'><b>Gender is Required</b></font>",

																	dOBEdit : "<font style='color: red;'><b>Date Of Birth is Required</b></font>",

																	 dOJEdit : "<font style='color: red;'><b>Date Of Joining is Required</b></font>",

																	pAddEdit : "<font style='color: red;'><b>Permanent Address is Required</b></font>",

																	pCityEdit : {
																		required:"<font style='color: red;'><b>Permanent City is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},
																	pStateEdit : {
																		required:"<font style='color: red;'><b>Permanent State is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},
																	pCountryEdit : "<font style='color: red;'><b>Permanent Country is Required</b></font>",

																	tAddEdit : "<font style='color: red;'><b>Temporary Address is Required</b></font>",

																	tCityEdit : {
																		required:"<font style='color: red;'><b>Temporary City is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},
																	tStateEdit : {
																		required:"<font style='color: red;'><b>Temporary State is Required</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																	},
																	tCountryEdit : "<font style='color: red;'><b>Temporary Country is Required</b></font>",

																	eMailEdit : "<font style='color: red;'><b>Email is Required And Must be Email Format</b></font>",

																	phoneEdit : "<font style='color: red;'><b>Phone Number is Required And Must be 10 Numbers</b></font>",

																	mobileEdit : "<font style='color: red;'><b>Mobile is Required And Must be 10 Numbers</b></font>",

																	statusEdit : "<font style='color: red;'><b>Status is Required</b></font>",
																	
																	org_IdEdit : "<font style='color: red;'><b>Organization is Required</b></font>",

																	department_IdEdit : "<font style='color: red;'><b>Department is Required</b></font>",

																	employeeGroup_IdEdit : "<font style='color: red;'><b>Employee Group is Required</b></font>",

 
																},
															});

										});

					});
</script>
<script>
function dateFun(datePattern) {
		$("#dob,#endDatepro,#startDatepro,#startDateproEdit,#endDateproEdit,#doj,#DOB,#startDate,#startDateEdit,#endDateEdit,#endDate,#dobEdit,#DOBEdit,#dojEdit").datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true,
		});
	}
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
		<div class="PageTitle">Employee</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="empedit" items="${empedit}">
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
					<form:form method="get" action="employeeSearch.mnt"
						commandName="EmployeeCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="employeeAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.employee"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.employee"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="employeeUpdate"
										items="${employeeUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.employee"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="employeeUpdateError"
										items="${employeeUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.employee"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="employeeDelete"
										items="${employeeDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.employee"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="employeeDeleteError"
										items="${employeeDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.employee"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" />
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

                   <c:forEach var="emp" items="${employees}">

						<c:set var="as" value="${emp}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">

					<display:table name="employeeBean" id="employee" class="table"
						requestURI="employeeSearch.mnt" pagesize="5">
						<display:column property="employeeNo" sortable="true"
							titleKey="label.empNo" media="html" />
						<display:column property="fName" sortable="true"
							titleKey="label.fName" media="html" />
						<display:column property="lName" sortable="true"
							titleKey="label.lName" media="html" />
						<display:column property="dOB" sortable="true"
							titleKey="label.dob" media="html" />
						<display:column property="dOJ" sortable="true"
							titleKey="label.doj" media="html" />
						<display:column property="mobile" sortable="true"
							titleKey="label.email" media="html" />
						<display:column property="eMail" sortable="true"
							titleKey="label.mobileNumber" media="html" />
						<display:column titleKey="label.edit">
						<c:choose>
							<c:when test="${edit }">
							<a
								href="employeeEdit.mnt?employeeId=<c:out value="${employee.employee_Id}"/> "><img
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
								href="employeeDelete.mnt?employeeId=<c:out value="${employee.employee_Id}"/> "
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

					<form:form action="employeeAdd.mnt" commandName="EmployeeCommand" id="addform" method="POST"
						>
						<table class="tableGeneral">
						
						<tr>
							<td colspan="2"><c:forEach var="addEmpDuplicate"
									items="${addEmpDuplicate}">
									<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.employee"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
								</c:forEach></td>
						</tr>
						<tr>
						<td><spring:message code="label.empNo"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="employeeNo" id="employeeNo" class="textbox" /></td>
								<td><spring:message code="label.employeeGroup"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="employeeGroup_Id" id="employeeGroup_Id" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employeeGroup }" />
									</form:select></td>
						</tr>
							<tr>
								<td><spring:message code="label.fName"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="fName" id="fname" class="textbox" /></td>
							
                                <td><spring:message code="label.tAddress"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="tAdd" id="TAdd" class="textbox" /></td>
                                  

							</tr>
							<tr>
								<td><spring:message code="label.lName"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="lName" id="lname" class="textbox" /></td>
                                <td><spring:message code="label.tCity"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="tCity" id="TCity" class="textbox" /></td>
                                

							</tr>
							<tr>
								<td><spring:message code="label.mName"></spring:message></td>
								<td><form:input path="mName" id="mname" class="textbox" /></td>
                              
                                  <td><spring:message code="label.tState"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="tState" id="TState" class="textbox" /></td>

							</tr>

							<tr>
								<td><spring:message code="label.gender"></spring:message><font
									color="red">*</font></td>
								<td><form:radiobutton path="gender" value="Male" id="male" />Male<form:radiobutton
										path="gender" value="Female" />Female</td>
                                   <td><spring:message code="label.tCountry"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="tCountry" id="TCountry"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${countrys }" />
									</form:select></td>
                                  
							</tr>
							<tr>
								<td><spring:message code="label.dob"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="dOB" id="dob" class="textbox" /></td>

                                  <td><spring:message code="label.email"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="eMail" id="Email" class="textbox" /></td>
                                  
							</tr>
							<tr>
								<td><spring:message code="label.doj"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="dOJ" id="doj" class="textbox" /></td>
                                 <td><spring:message code="label.phoneNumber"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="phone" id="Phone" class="textbox" /></td>
                                 

							</tr>

							<tr>
								<td><spring:message code="label.pAddress"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="pAdd" id="PAdd" class="textbox" /></td>
                                 <td><spring:message code="label.mobileNumber"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="mobile" id="Mobile" class="textbox" /></td>
                                 

							</tr>

							<tr>
								<td><spring:message code="label.pCity"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="pCity" id="PCity" class="textbox" /></td>
                                 <td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="status" id="status" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                    

							</tr>

							<tr>
								<td><spring:message code="label.pState"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="pState" id="PState" class="textbox" /></td>
                                	<td><spring:message code="label.org"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="org_Id" id="org_Id" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${organization }" />
									</form:select></td>
                                

							</tr>

							<tr>
								<td><spring:message code="label.pCountry"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="pCountry" id="PCountry"
										class="select">
										<form:option value="">--Select --</form:option>
										<form:options items="${countrys }" />
									</form:select></td>

                                <td><spring:message code="label.department"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="department_Id" id="department_Id" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${department }" />
									</form:select></td>
                                
							</tr>
							<tr><td><spring:message code="label.designation"></spring:message><font
									color="red">*</font></td><td><form:select path="designationId" id="designationId" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${designations }" />
									</form:select></td>
									<td><spring:message code="label.cemail"></spring:message></td><td><form:input path="ceMail"  class="textbox" /></td>
                                	
									</tr>
                              
</table>

							<div id="tabsForAdd">
								<!-- Employee Manager tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.employeeManager" /></a></li>
												<li><a href="#subtabs-2"><spring:message
												code="label.employeeProject" /></a></li>

								</ul> 
							<div id="scroll">
							<div  id="subtabs-1" align="center">
							
								
									<script>
										var btempid = 1;
										$(function() {

											var 
											managers = $("#managers"), 
										    mvalue=$("#mNumber"),
											pvalue=$("#mNumber"), 
											startDate = $("#startDate"),
											endDate=$("#endDate"),
											hiddenempID = $("#hiddenIdempPopUp"),
											
											
											
											allFields = $([]).add(managers).add(mvalue).add(pvalue).add(startDate).add(endDate).add(hiddenempID),
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
																				managers,
																				"Managers"
																				);
																		
																		
																		bValid1 = bValid1
																		&& checkLength(
																				startDate,
																				"StartDate",
																				1,
																				16);
																		 
																		 
																		 bValid1 = bValid1
																			&& checkLength(
																					endDate,
																					"EndDate",
																					1,
																					16);
																					
																	

																
																	 	if (bValid1) {
																			
																			
																			if (hiddenempID
																					.val() == "0"
																					|| hiddenempID
																							.val() == "") {
																				

																				$("#empAdd tbody")
																						.append(
																								"<tr id="+btempid+">"
																								
																								+ "<td ><spring:bind path='EmployeeCommand.managers'><input type='hidden' name='managers' id='managers"
																								+ btempid
																								+ "' value="
																								+ managers
																										.val()
																								+ " class='textbox'/></spring:bind> <input type='text' name='mNumber' id='mNumber"
																								+ btempid
																								+ "' value="
																								+ $('#managers :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>"
																								
																								     + "<td ><input type='text' name='startDate' id='startDate"
																								      + btempid
																								     + "' value="
																								     + startDate
																										.val()
																								     + "  class='textbox'readonly/></td>"
																										+ "<td ><input type='text' name='endDate' id='endDate"
																										+ btempid
																										+ "' value="
																										+ endDate
																												.val()
																										+ "  class='textbox'readonly/></td>"
																									    +"<td><a href='#'  onclick='editemp("
																										+ btempid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btempid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btempid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenempID
																					.val() != "0") {
																				
																				
																			 $(
																						'#managers'
																								+ hiddenempID
																										.val())
																						.val(
																								managers
																										.val());
																				$(
																						'#mNumber'
																								+ hiddenempID
																										.val())
																						.val(
																								 $('#managers :selected').text());
																				
																				
																				 
																				$(
																						'#startDate'
																								+ hiddenempID
																										.val())
																						.val(
																								startDate
																										.val());
																				
																				$(
																						'#endDate'
																								+ hiddenempID
																										.val())
																						.val(
																								endDate
																										.val());
																				
																				$(
																						'#hiddenIdempPopUp')
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
									
											$('#managers').val(
													$('#managers' + id).val());
											$('#mNumber').val(
													$('#mNumber' + id).val());
											
											
											$('#startDate').val($('#startDate' + id).val());
											$('#endDate').val($('#endDate' + id).val());
											
											$('#hiddenIdempPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-emp" title="Add New Employee Manager Details">
										<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
										<table class="tableGeneral">
												<tr><td></td></tr>
                                              <tr><td></td></tr>
									
															 
														<tr>	 	
												<td><spring:message code="label.Manager" /><font color="red">*</font></td>
											<td><form:select path="managers" id="managers" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${Employees}" /> 
													
												</form:select></td>
															</tr>
                                         
															
											 <tr>
												<td><spring:message code="label.startDate" /><font color="red">*</font></td>
												<td><form:input path="startDate" id="startDate"
															class="textbox"/>
															</td>
															</tr>
											<tr>
												<td><spring:message code="label.endDate" /><font color="red">*</font></td>
												<td><form:input path="endDate" id="endDate"
															class="textbox"/>
											<input type="hidden"
													name="hiddenIdempPopUp" id="hiddenIdempPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="empAdd" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.Manager" /></th>
													<th><spring:message code="label.startDate" /></th>
													<th><spring:message code="label.endDate" /></th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="Addemp"  type="button">Add New Employee Manager</button>
									

								</div>
							</div>
							<div id="subtabs-2" class="TabbedPanelsContent" align="center"> 
							<script>
										var btempid = 1;
										$(function() {

											var 
											projects = $("#projects"), 
											pvalue=$("#pNumber"), 
											startDate = $("#startDatepro"),
											endDate=$("#endDatepro"),
											hiddenempID = $("#hiddenIdempproPopUp"),
											
											
											
											allFields = $([]).add(projects).add(pvalue).add(startDate).add(endDate).add(hiddenempID),
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
											$("#dialog-form-emppro")
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
																					projects,
																					"Projects"
																					);
																		bValid1 = bValid1
																		&& checkLength(
																				startDate,
																				"StartDate",
																				1,
																				16);
																		 
																		 
																		 bValid1 = bValid1
																			&& checkLength(
																					endDate,
																					"EndDate",
																					1,
																					16);
																					
																	

																
																	 	if (bValid1) {
																			
																			
																			if (hiddenempID
																					.val() == "0"
																					|| hiddenempID
																							.val() == "") {
																				

																				$("#empAddPro tbody")
																						.append(
																								"<tr id="+btempid+">"
																								+ "<td ><spring:bind path='EmployeeCommand.projects'><input type='hidden' name='projects' id='projects"
																								+ btempid
																								+ "' value="
																								+ projects
																										.val()
																								+ " class='textbox'/></spring:bind> <input type='text' name='pNumber' id='pNumber"
																								+ btempid
																								+ "' value="
																								+ $('#projects :selected').text()
																																																		
																								+ " class='textbox'readonly/></td>" 
																								     + "<td align='center'><input type='text' name='startDatepro' id='startDatepro"
																								      + btempid
																								     + "' value="
																								     + startDate
																										.val()
																								     + "  class='textbox'readonly/></td>"
																										+ "<td align='center'><input type='text' name='endDatepro' id='endDatepro"
																										+ btempid
																										+ "' value="
																										+ endDate
																												.val()
																										+ "  class='textbox'readonly/></td>"
																									    +"<td><a href='#'  onclick='editemppro("
																										+ btempid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btempid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btempid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenempID
																					.val() != "0") {
																				
																				
																				$(
																						'#projects'
																								+ hiddenempID
																										.val())
																						.val(
																								projects 
																								        .val());
																				$(
																						'#pNumber'
																								+ hiddenempID
																										.val())
																						.val(
																								 $('#projects :selected').text());
																				 
																				$(
																						'#startDatepro'
																								+ hiddenempID
																										.val())
																						.val(
																								startDate
																										.val());
																				
																				$(
																						'#endDatepro'
																								+ hiddenempID
																										.val())
																						.val(
																								endDate
																										.val());
																				
																				$(
																						'#hiddenIdempproPopUp')
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

										
											$("#Addempproj")
													.button()
													.click(
															function() {
															
																$("#dialog-form-emppro")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editemppro(id) {
											$("#dialog-form-emppro").dialog("open");
											
											$('#projects').val(
													$('#projects' + id).val());
											$('#pNumber').val(
													$('#pNumber' + id).val()); 
											$('#startDatepro').val($('#startDatepro' + id).val());
											$('#endDatepro').val($('#endDatepro' + id).val());
											
											$('#hiddenIdempproPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-emppro" title="Add New Employee Project Details">
										<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
										<table class="tableGeneral">
												<tr><td></td></tr>
                                              <tr><td></td></tr>
									
															 
                                           <tr>
												<td><spring:message code="label.project" /><font color="red">*</font></td>
											<td><form:select path="projects" id="projects" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${projects}" /> 
													
												</form:select></td>
															</tr> 
											
															
											 <tr>
												<td><spring:message code="label.startDate" /><font color="red">*</font></td>
												<td><form:input path="startDatepro" id="startDatepro"
															class="textbox"/>
															</td>
															</tr>
											<tr>
												<td><spring:message code="label.endDate" /><font color="red">*</font></td>
												<td><form:input path="endDatepro" id="endDatepro"
															class="textbox"/>
											<input type="hidden"
													name="hiddenIdempproPopUp" id="hiddenIdempproPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="empAddPro" class="table">
											<thead>
												<tr>
													
													<th><spring:message code="label.project" /></th>
													<th><spring:message code="label.startDate" /></th>
													<th><spring:message code="label.endDate" /></th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="Addempproj"  type="button">Add New Employee Project</button>
									
							
							</div>
							</div><c:choose>
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
					<c:forEach var="empedit" items="${empedit}">

						<form:form method="post" action="employeeUpdate.mnt"
							commandName="EmployeeCommand" id="editForm">
							<table class="tableGeneral">


								<form:hidden path="employee_IdEdit" id="employee_IdEdit" />
                               
                               <tr>
						<td><spring:message code="label.empNo"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="employeeNoEdit" id="employeeNoEdit" class="textbox" /></td>
								<td><spring:message code="label.employeeGroup"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="employeeGroup_IdEdit" id="employeeGroup_IdEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employeeGroup }" />
									</form:select></td>
						</tr>

								<tr>
								<td><spring:message code="label.fName"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="fNameEdit" id="fnameEdit" class="textbox" /></td>
							
                                <td><spring:message code="label.tAddress"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="tAddEdit" id="TAddEdit" class="textbox" /></td>
                                  

							</tr>
							<tr>
								<td><spring:message code="label.lName"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="lNameEdit" id="lnameEdit" class="textbox" /></td>
                                <td><spring:message code="label.tCity"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="tCityEdit" id="TCityEdit" class="textbox" /></td>
                                

							</tr>
							<tr>
								<td><spring:message code="label.mName"></spring:message></td>
								<td><form:input path="mNameEdit" id="mnameEdit" class="textbox" /></td>
                              
                                  <td><spring:message code="label.tState"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="tStateEdit" id="TStateEdit" class="textbox" /></td>

							</tr>

							<tr>
								<td><spring:message code="label.gender"></spring:message><font
									color="red">*</font></td>
								<td><form:radiobutton path="genderEdit" value="Male" />Male<form:radiobutton
										path="genderEdit" value="Female" />Female</td>
                                   <td><spring:message code="label.tCountry"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="tCountryEdit" id="TCountryEdit"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${countrys }" />
									</form:select></td>
                                  
							</tr>
							<tr>
								<td><spring:message code="label.dob"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="dOBEdit" id="dobEdit" class="textbox" /></td>

                                  <td><spring:message code="label.email"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="eMailEdit" id="EmailEdit" class="textbox" /></td>
                                  
							</tr>
							<tr>
								<td><spring:message code="label.doj"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="dOJEdit" id="dojEdit" class="textbox" /></td>
                                 <td><spring:message code="label.phoneNumber"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="phoneEdit" id="PhoneEdit" class="textbox" /></td>
                                 

							</tr>

							<tr>
								<td><spring:message code="label.pAddress"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="pAddEdit" id="PAddEdit" class="textbox" /></td>
                                 <td><spring:message code="label.mobileNumber"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="mobileEdit" id="MobileEdit" class="textbox" /></td>
                                 

							</tr>

							<tr>
								<td><spring:message code="label.pCity"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="pCityEdit" id="PCityEdit" class="textbox" /></td>
                                 <td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="statusEdit" id="statusEdit" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
                                    

							</tr>

							<tr>
								<td><spring:message code="label.pState"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="pStateEdit" id="PStateEdit" class="textbox" /></td>
                                	<td><spring:message code="label.org"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="org_IdEdit" id="org_IdEdit" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${organization }" />
									</form:select></td>
                                

							</tr>

							<tr>
								<td><spring:message code="label.pCountry"></spring:message><font
									color="red">*</font></td>

								<td><form:select path="pCountryEdit" id="PCountryEdit"
										class="select">
										<form:option value="0">--Select --</form:option>
										<form:options items="${countrys }" />
									</form:select></td>

                                <td><spring:message code="label.department"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="department_IdEdit" id="department_IdEdit" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${department }" />
									</form:select></td>
                                
							</tr>
                            
							<tr><td><spring:message code="label.designation"></spring:message><font
									color="red">*</font></td><td><form:select path="designationIdEdit" id="designationIdEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${designations }" />
									</form:select></td>

                  <td><spring:message code="label.cemail"></spring:message></td><td><form:input path="ceMailEdit"  class="textbox" /></td></tr>
							</table>
							
								<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.employeeManager" /></a></li>
<li><a href="#tab2"><spring:message
												code="label.employeeProject" /></a></li>								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {

												var 
												manageresEdit=$("#manageresEdit"),
												projectsEdit=$("#projectsEdit"),
												startDateEdit = $("#startDateEdit"),
												endDateEdit=$("#endDateEdit"),
												hiddenEdit = $("#hiddenIdEmpPopUpEdit"),
												
												allFields = $([]).add(manageresEdit).add(projectsEdit).add(startDateEdit).add(endDateEdit)
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
																						manageresEdit,
																						"Managers"
																						);
																				
																				bValid1 = bValid1
																					&& selectLength(
																							projectsEdit,
																							"Projects"
																							);
																				bValid1 = bValid1
																				&& checkLength(
																						startDateEdit,
																						"Start Date",
																						1,
																						16);
																				 
																				 
																				 bValid1 = bValid1
																					&& checkLength(
																							endDateEdit,
																							"End Date",
																							1,
																							16);
																							


																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					
																					$(
																							
																							"#AddEmpEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<td><spring:bind path='EmployeeCommand.employeeManager_IdEditt'><input type='hidden' name='employeeManager_IdEditt' id='employeeManager_IdEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																											 + "<spring:bind path='EmployeeCommand.manageresEdit'><input type='hidden' name='manageresEdit' id='manageresEdit"
																												+ btrid
																												+ "' value="
																												+ manageresEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind>"
																												+"<spring:bind path='EmployeeCommand.managerName'><input type='text' name='managerName' id='managerName"
																												+ btrid
																												+ "' value="
																												+$('#manageresEdit :selected').text()
																												+ " class='textbox' readonly/></spring:bind></td>" 
																												
																											+ "<td><spring:bind path='EmployeeCommand.startDateEdit'><input name='startDateEdit' id='startDateEdit"
																											+ btrid
																											+ "' value="
																											+ startDateEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='EmployeeCommand.endDateEdit'><input name='endDateEdit' id='endDateEdit"
																											+ btrid
																											+ "' value="
																											+ endDateEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																										 	
																											+"<input type='hidden' name='employeeManager_IdEdit' id='employeeManager_IdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+
																											// "<td>" + password.val() + "</td>" +
																											"<td><a href='#'  onclick='editEmpManagerDetailsInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeEmpManagerDetailsEditNew'("
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
																						'#manageresEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#manageresEdit')
																										.val());
																				$(
																						'#managerName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#manageresEdit :selected').text()); 
																				$(
																						'#projectsEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#projectsEdit')
																										.val());
																				$(
																						'#projectName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#projectsEdit :selected').text());
																				$(
																						'#startDateEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#startDateEdit')
																										.val());
																				$(
																						'#endDateEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#endDateEdit')
																										.val());
																				
																				$(
																						'#hiddenIdEmpPopUpEdit')
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
											function removeEmpManagerDetailsEditNew(
													id) {
											
												$('#' + id).remove();
											}
											function editEmpManagerDetailsInEditNew(link) {
												
												$("#dialog-form-EmpEdit")
														.dialog("open");
												
										
												
												$('#manageresEdit').val(
														$(
																'#manageresEdit'
																		+ link)
																.val());
												$('#startDateEdit').val(
														$(
																'#startDateEdit'
																		+ link)
																.val());
												$('#endDateEdit').val(
														$(
																'#endDateEdit'
																		+ link)
																.val());

												$('#hiddenIdEmpPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-EmpEdit" title="Add New Employee Manager Details">
											<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
										<table class="tableGeneral">
												<tr><td></td></tr>
                                              <tr><td></td></tr>
															 
														<tr>	 	
												<td><spring:message code="label.Manager" /><font color="red">*</font></td>
											<td><form:select path="manageresEdit" id="manageresEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${Employees}" /> 
													
												</form:select></td>
															</tr>
                                          
															
											 <tr>
												<td><spring:message code="label.startDate" /><font color="red">*</font></td>
												<td><form:input path="startDateEdit" id="startDateEdit"
															class="textbox"/>
															</td>
															</tr>
											<tr>
												<td><spring:message code="label.endDate" /><font color="red">*</font></td>
												<td><form:input path="endDateEdit" id="endDateEdit"
															class="textbox"/><input type="hidden"
													name="hiddenIdEmpPopUpEdit" id="hiddenIdEmpPopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddEmpEdit" class="table">
												<thead>
													<tr>
													
													<th><spring:message code="label.Manager" /></th>
													<th><spring:message code="label.startDate" /></th>
													<th><spring:message code="label.endDate" /></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="emplinelist"
															items="${emplinelist}">

															<c:set var="edit1" value="${emplinelist.employeeManager_IdEdit}"></c:set> 
														
																<tr id="${emplinelist.employeeManager_IdEdit}">
																
                                                                    <spring:bind
																			path="EmployeeCommand.employeeManager_Id">
																			<input type="hidden" name="employeeManager_IdEditt"
																				class="textbox" 
																				value="${emplinelist.employeeManager_IdEdit}" id="employeeManager_Id${emplinelist.employeeManager_IdEdit}" />
																		</spring:bind>
																		
																		
																		<spring:bind
																			path="EmployeeCommand.manageresEdit">
																			<input type="hidden" name="manageresEdit"
																				class="textbox" 
																				value="${emplinelist.manager_IdEdit}" id="manageresEdit${emplinelist.employeeManager_IdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="EmployeeCommand.managerName">
																			<input type="text" name="managerName"
																				class="textbox" readonly="readonly"
																				value="${emplinelist.managerName}" id="managerName${emplinelist.employeeManager_IdEdit}" />
																		</spring:bind></td> 
																		
																		<td><spring:bind
																			path="EmployeeCommand.startDateEdit">
																			<input type="text" name="startDateEdit"
																				class="textbox" readonly="readonly"
																				value="${emplinelist.startDateEdit}"  id="startDateEdit${emplinelist.employeeManager_IdEdit}"/>
																		</spring:bind></td>
																			<td><spring:bind
																			path="EmployeeCommand.endDateEdit">
																			<input type="text" name="endDateEdit"
																				class="textbox" readonly="readonly"
																				value="${emplinelist.endDateEdit}"  id="endDateEdit${emplinelist.employeeManager_IdEdit}"/>
																		</spring:bind>
																
								
																	<input type="hidden" name="${emplinelist.employeeManager_IdEdit}Check" id="${emplinelist.employeeManager_IdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editEmpManagerDetailsInEditNew(${emplinelist.employeeManager_IdEdit})"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="${emplinelist.employeeManager_IdEdit}"></img></a></td>
														<td><a href="#"
															id="${emplinelist.employeeManager_IdEdit}"
															onclick="javascript:getIDpro1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																></img></a></td>
																</tr>
		
																<script type="text/javascript">
																function getIDpro1(
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
																	
																	$('#manageresEdit').val(
																			$(
																					'#manageresEdit'
																							+ link)
																					.val());
																	$('#projectsEdit').val(
																			$(
																					'#projectsEdit'
																							+ link)
																					.val());
																	$('#startDateEdit').val(
																			$(
																					'#startDateEdit'
																							+ link)
																					.val());
																	
																	$('#endDateEdit').val(
																			$(
																					'#endDateEdit'
																							+ link)
																					.val());								
																	
																	$('#hiddenIdEmpPopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddEmpEdit" type="button">Add New
											Employee Manager</button>

									</div>

								</div>
								<div id="tab2">
								<div align="center">
										<script>
											var btrid = 1;
											$(function() {

												var 
												projectsEdit=$("#projectsEdit"),
												startDateEdit = $("#startDateproEdit"),
												endDateEdit=$("#endDateproEdit"),
												hiddenEdit = $("#hiddenIdEmpproPopUpEdit"),
												
												allFields = $([]).add(projectsEdit).add(startDateEdit).add(endDateEdit)
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

												$("#dialog-form-EmpproEdit")
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
																							projectsEdit,
																							"Projects"
																							);
																				bValid1 = bValid1
																				&& checkLength(
																						startDateEdit,
																						"Start Date",
																						1,
																						16);
																				 
																				 
																				 bValid1 = bValid1
																					&& checkLength(
																							endDateEdit,
																							"End Date",
																							1,
																							16);
																							


																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					
																					$("#AddEmpprojectEdit tbody").append(
																								
																									"<tr id="+btrid+">"
																										
																											 + "<td><spring:bind path='EmployeeCommand.projectsEdit'><input type='hidden' name='projectsEdit' id='projectsEdit"
																											+ btrid
																											+ "' value="
																											+ projectsEdit.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='EmployeeCommand.projectName'><input type='text' name='projectName' id='projectName"
																											+ btrid
																											+ "' value="
																											+$('#projectsEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																											+ "<td><spring:bind path='EmployeeCommand.startDateEdit'><input name='startDateproEdit' id='startDateproEdit"
																											+ btrid
																											+ "' value="
																											+ startDateEdit.val()
																											+ " class='textbox' readonly/></spring:bind> </td>"
																											+ "<td><spring:bind path='EmployeeCommand.endDateEdit'><input name='endDateproEdit' id='endDateproEdit"
																											+ btrid
																											+ "' value="
																											+ endDateEdit
																													.val()
																											+ " class='textbox' readonly/></spring:bind><input type='hidden' name='employeeProject_IdEdit' id='employeeProject_IdEdit' value='0'/><input type='hidden' name='Checkp' id='Checkp' value='0' /> </td>"
																										 		
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
																						'#projectsEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#projectsEdit')
																										.val());
																				$(
																						'#projectName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#projectsEdit :selected').text());
																				$(
																						'#startDateproEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#startDateproEdit')
																										.val());
																				$(
																						'#endDateproEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#endDateproEdit')
																										.val());
																				
																				$(
																						'#hiddenIdEmpproPopUpEdit')
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

												$("#AddEmpproEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-EmpproEdit")
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
												
												
												$("#dialog-form-EmpproEdit")
														.dialog("open");
												
										
												$('#projectsEdit').val(
														$(
																'#projectsEdit'
																		+ link)
																.val());
												
												$('#startDateproEdit').val(
														$(
																'#startDateproEdit'
																		+ link)
																.val());
												$('#endDateproEdit').val(
														$(
																'#endDateproEdit'
																		+ link)
																.val());

												$('#hiddenIdEmpproPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-EmpproEdit" title="Add New Employee Project Details">
											<p class="validateTips" style="color:red;">Fields marked with * are mandatory</p>
										<table class="tableGeneral">
												<tr><td></td></tr>
                                              <tr><td></td></tr>
															 
													<form:hidden path="employeeProject_IdEdit" value="0" />
                                           <tr>
												<td><spring:message code="label.project" /><font color="red">*</font></td>
											<td><form:select path="projectsEdit" id="projectsEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="" >--Select--</form:option>
													<form:options items="${projects}" /> 
													
												</form:select></td>
															</tr>  
													
															
											 <tr>
												<td><spring:message code="label.startDate" /><font color="red">*</font></td>
												<td><form:input path="startDateproEdit" id="startDateproEdit"
															class="textbox"/>
															</td>
															</tr>
											<tr>
												<td><spring:message code="label.endDate" /><font color="red">*</font></td>
												<td><form:input path="endDateproEdit" id="endDateproEdit"
															class="textbox"/><input type="hidden"
													name="hiddenIdEmpproPopUpEdit" id="hiddenIdEmpproPopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											<table id="AddEmpprojectEdit" class="table">
												<thead>
													<tr>
													
													<th><spring:message code="label.project" /></th>
													<th><spring:message code="label.startDate" /></th>
													<th><spring:message code="label.endDate" /></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="empprojectlist"
															items="${empprojectlist}">

															<c:set var="edit1" value="${empprojectlist.employeeProject_IdEdit}"></c:set> 
														
																<tr id="${empprojectlist.employeeProject_IdEdit}">
																
                                                                    <spring:bind
																			path="EmployeeCommand.employeeProject_IdEdit">
																			<input type="hidden" name="employeeProject_IdEdit"
																				class="textbox" 
																				value="${empprojectlist.employeeProject_IdEdit}" id="employeeProject_IdEdit${empprojectlist.employeeProject_IdEdit}" />
																		</spring:bind>
																		
																		
																		
																		 <spring:bind
																			path="EmployeeCommand.projectsEdit">
																			<input type="hidden" name="projectsEdit"
																				class="textbox" 
																				value="${empprojectlist.project_IdEdit}" id="projectsEdit${empprojectlist.employeeProject_IdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="EmployeeCommand.projectName">
																			<input type="text" name="projectName"
																				class="textbox" readonly="readonly"
																				value="${empprojectlist.projectName}" id="projectName${empprojectlist.employeeProject_IdEdit}" />
																		</spring:bind></td> 
																		<td><spring:bind
																			path="EmployeeCommand.startDateproEdit">
																			<input type="text" name="startDateproEdit"
																				class="textbox" readonly="readonly"
																				value="${empprojectlist.startDateproEdit}"  id="startDateproEdit${empprojectlist.employeeProject_IdEdit}"/>
																		</spring:bind></td>
																			<td><spring:bind
																			path="EmployeeCommand.endDateproEdit">
																			<input type="text" name="endDateproEdit"
																				class="textbox" readonly="readonly"
																				value="${empprojectlist.endDateproEdit}"  id="endDateproEdit${empprojectlist.employeeProject_IdEdit}"/>
																		</spring:bind>
																
								
																	<input type="hidden" name="${empprojectlist.employeeProject_IdEdit}Checkp" id="${empprojectlist.employeeProject_IdEdit}Checkp" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editEmpDetailsInEdit(${empprojectlist.employeeProject_IdEdit})"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="${empprojectlist.employeeProject_IdEdit}"></img></a></td>
														<td><a href="#"
															id="${empprojectlist.employeeProject_IdEdit}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																></img></a></td>
																</tr>
		
																<script type="text/javascript">
																function getID1(
																		link) {
																	//alert(link.id);
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link.id
																					+ "Checkp").value = "1";
																document.getElementById(link.id).style.display = "none";
																}
																function editEmpDetailsInEdit(
																		link) {
																	
																
																	$(
																			"#dialog-form-EmpproEdit").dialog(
																					"open");
																	
																	
																	$('#projectsEdit').val(
																			$(
																					'#projectsEdit'
																							+ link)
																					.val());
																	$('#startDateproEdit').val(
																			$(
																					'#startDateproEdit'
																							+ link)
																					.val());
																	
																	$('#endDateproEdit').val(
																			$(
																					'#endDateproEdit'
																							+ link)
																					.val());								
																	
																	$('#hiddenIdEmpproPopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach>  


												</tbody>

											</table>
										</div>
										<button id="AddEmpproEdit" type="button">Add New
											Employee Project</button>

									</div>
								</div>
								</div>
								<table>
									<tr>
										<td colspan=""><c:choose>
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
