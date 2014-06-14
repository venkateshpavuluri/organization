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
<title>My JSP 'empQualification.jsp' starting page</title>
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

		$("#plannedDT").datepicker();
		$("#plannedDTEdit").datepicker();
	

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
						
						//AddForm Validations
						$('#wsubmit')
								.click(
										function(event) {

											$('#addform')
													.validate(
															{
																rules : {
																	employee_Id : {
																		required : true
																	},
																	qualification_Id : {
																		required : true
																	},
																	
																	yearPassed : {
																		required : true,
																		number: true,
																		minlength:4,
																		maxlength:4
																	},
																	grade : {
																		required : true
																	},
																	board : {
																		required : true
																	},
																	totMarks : {
																		required : true,
																		number: true,
																	},
																	percentage : {
																		required : true,
																		number: true,
																	},															

																},
																messages : {
																	

																	employee_Id : "<font style='color: red;'><b>Employee Type is Required</b></font>",

																	qualification_Id : "<font style='color: red;'><b>Qualification is Required</b></font>",

																	yearPassed : {
																		 required: "<font style='color: red;'><b>Year Of Passed is Required.</b></font>",
																		 
																		   minlength: "<font style='color: red;'><b>Year Of Passed must be four digits.</b></font>",
														                	
															                maxlength: "<font style='color: red;'><b>Year Of Passed cannot exceed four digits.</b></font>",
															                
															                number: "<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	},
																	grade : "<font style='color: red;'><b>Grade is Required</b></font>",
																	
																	board : "<font style='color: red;'><b>Board is Required</b></font>",
																	
																	totMarks :{
																		required:"<font style='color: red;'><b>Total Marks is Required.</b></font>",
																		number:"<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	},
																	
																	percentage : {
																		required:"<font style='color: red;'><b>Percentage is Required.</b></font>",
																		number:"<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	}
																	
																	

																	

																}
															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											var assetedit = $('#assetEditId')
													.val();
											//alert(assetedit);
											$('#editForm')
													.validate(
															{
																rules : {
																	employee_IdEdit : {
																		required : true
																	},
																	qualification_IdEdit : {
																		required : true
																	},
																	
																	yearPassedEdit : {
																		required : true,
																		number: true,
																		minlength:4,
																		maxlength:4
																
																	},
																	gradeEdit : {
																		required : true
																	},
																	boardEdit : {
																		required : true
																	},
																	totMarksEdit : {
																		required : true,
																		number: true,
																	},
																	percentageEdit : {
																		required : true,
																		number: true,
																	},															

																},
																messages : {
																	
																	employee_IdEdit : "<font style='color: red;'><b>Employee Type is Required</b></font>",

																	qualification_IdEdit : "<font style='color: red;'><b>Qualification is Required</b></font>",

																	yearPassedEdit :{
																		
																		required: "<font style='color: red;'><b>Year Of Passed is Required.</b></font>",
																		 
																		   minlength: "<font style='color: red;'><b>Year Of Passed must be four digits.</b></font>",
														                	
															                maxlength: "<font style='color: red;'><b>Year Of Passed cannot exceed four digits.</b></font>",
															                
															                number: "<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	},

																	gradeEdit : "<font style='color: red;'><b>Grade is Required</b></font>",
																	
																	boardEdit : "<font style='color: red;'><b>Board is Required</b></font>",
																	
																	totMarksEdit : {
																		required:"<font style='color: red;'><b>Total Marks is Required.</b></font>",
																			number:"<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	},
																	
																	percentageEdit : {
																		equired:"<font style='color: red;'><b>Percentage is Required.</b></font>",
																		number:"<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	}
																	


																	

																	
																},
															});

										});

					});
</script>

<script type="text/javascript">
	function doAjaxPost() {
alert("hai");
		//get the form values

		var equipment_Id = $('#equipment_Id').val();
		var plannedDT=$('#plannedDT').val();
		alert("equp"+equipment_Id);
		alert("p:"+plannedDT);
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/maintenancePlanCheck.mnt",

					data : "equipment_Id=" + equipment_Id
					+ "&plannedDT=" + plannedDT,

					success : function(response) {

						var checkResponse = "Equipment and PlanedDate Already Exists Choose Another One";
						//	alert(response);
						if (checkResponse == response) {
							document.getElementById("addmessage").style.display = "block";
							$('#addmessage').html(response);
						} else {
							document.getElementById("addmessage").style.display = "none";
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
</script>

<script type="text/javascript">
	function doAjaxPostEdit() {
     alert("hai");
		//get the form values
var equipment_IdEdit = $('#equipment_IdEdit').val();
		var plannedDTEdit=$('#plannedDTEdit').val();
		alert("equ:"+equipment_IdEdit);
		alert("plan:"+plannedDTEdit);
		var maintenancePlan_IdEdit = $('#maintenancePlan_IdEdit').val();
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/maintenancePlanEditCheck.mnt",

					data : "equipment_IdEdit=" + equipment_IdEdit + "&plannedDTEdit=" + plannedDTEdit
							+ "&maintenancePlan_IdEdit=" + maintenancePlan_IdEdit,

					success : function(response) {

						var checkResponse = "Equipment and PlanedDate Already Exists Choose Another One";
						//	alert(response);
						if (checkResponse == response) {
							document.getElementById("editmessage").style.display = "block";
							$('#editmessage').html(response);
						} else {
							document.getElementById("editmessage").style.display = "none";
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("atId").value == 1) {

			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnasid').click(function(e) {
			document.getElementById("atId").value = 1;
			//alert(document.getElementById("atId").value);
		});
	});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("ateditId").value == 1) {
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
			document.getElementById("ateditIde").value = 1;
			//alert(document.getElementById("ateditId").value);

		});
	});
</script>

</head>

<body>


	 <div class="divUserDefault">
 	<div class="PageTitle">Employee Qualification</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="eqEditvalues" items="${eqEditvalues}">
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
					<form:form method="get" action="empQualificationSearch.mnt"
						commandName="empQualificationCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="empQualAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empQualification"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.empQualification"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="empQualificationUpdate"
										items="${empQualificationUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empQualification"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="empQualificationUpdateError"
										items="${empQualificationUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.empQualification"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="empQualificationDeleted"
										items="${empQualificationDeleted}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empQualification"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="empQualificationDeletedError"
										items="${empQualificationDeletedError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.empQualification"/> <spring:message code="label.deleteFail"></spring:message>
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
									</c:choose>
							
							</tr>

						</table>
					</form:form>


                   <c:forEach var="empqvalue" items="${empqvalue}">

						<c:set var="as" value="${empqvalue}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">
					<display:table name="EmpQualification" id="EmpQualification" class="table"
						requestURI="empQualificationSearch.mnt" pagesize="5">
						<display:column property="empName" sortable="true"
							titleKey="label.employee" media="html" />
						<display:column property="qualificationName" sortable="true"
							titleKey="label.qualification" media="html" />
						<display:column property="yearPassed" sortable="true"
							titleKey="label.yearPassed" media="html" />
						<display:column property="grade" sortable="true"
							titleKey="label.grade" media="html" />
						<display:column property="board" sortable="true"
							titleKey="label.board" media="html" />
							<display:column property="totMarks" sortable="true"
							titleKey="label.totMarks" media="html" />
							<display:column property="percentage" sortable="true"
							titleKey="label.percentage" media="html" />
						
						<display:column titleKey="label.edit">
						<c:choose>
							<c:when test="${edit }">
							<a
								href="empQualificationEdit.mnt?empQualificationId=<c:out value="${EmpQualification.empQual_Id}"/> "><img
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
								href="empQualificationDelete.mnt?empQualificationId=<c:out value="${EmpQualification.empQual_Id}"/> "
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
							<td colspan="4" class="alert-warning" id="addmessage"
								style="display: none; width: 500px; height: 25px;"></td>
						</tr>
					</table>
					<form:form commandName="empQualificationCommand" id="addform" method="POST"
						action="empQualificationAdd.mnt">
						<table class="tableGeneral">
						
						<form:hidden path="aid" />
							
						
							<tr>
							<td><spring:message code="label.employee" /><font color="red">*</font></td>
									<td><form:select path="employee_Id" id="employee_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${Employees }" />
										</form:select></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.qualification" /><font color="red">*</font></td>
									<td><form:select path="qualification_Id" id="qualification_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${Qualification }" />
										</form:select></td>
							</tr>
							
							
                       <tr>
								<td><spring:message code="label.yearPassed"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="yearPassed" id="yearPassed" class="textbox" /></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.grade"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="grade" id="grade" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.board"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="board" id="board" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.totMarks"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="totMarks" id="totMarks" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.percentage"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="percentage" id="percentage" class="textbox" /></td>
							</tr>
                             
                             
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="wsubmit" /></c:when>
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
					<c:forEach var="eqEditvalues" items="${eqEditvalues}">
                      <table>
						<tr>
							<td colspan="4" class="alert-warning" id="editmessage"
								style="display: none; width: 550px; height: 25px;"></td>
						</tr>
					</table>
						<form:form method="post" action="empQualificationUpdate.mnt"
							commandName="empQualificationCommand" id="editForm">
							<table class="tableGeneral">

                            	
								 <form:hidden path="empQual_IdEdit" id="empQual_IdEdit" />


				           <tr>
							<td><spring:message code="label.employee" /><font color="red">*</font></td>
									<td><form:select path="employee_IdEdit" id="employee_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${Employees }" />
										</form:select></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.qualification" /><font color="red">*</font></td>
									<td><form:select path="qualification_IdEdit" id="qualification_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${Qualification }" />
										</form:select></td>
							</tr>
							
							
                            <tr>
								<td><spring:message code="label.yearPassed"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="yearPassedEdit" id="yearPassedEdit" class="textbox" /></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.grade"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="gradeEdit" id="gradeEdit" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.board"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="boardEdit" id="boardEdit" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.totMarks"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="totMarksEdit" id="totMarksEdit" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.percentage"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="percentageEdit" id="percentageEdit" class="textbox" /></td>
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
</body>
</html>
