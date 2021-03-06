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
<script type="text/javascript">
	$(document).ready(function() {
		$('#'+"sumbtnid").click(function(event) {
			
			$("#empAttAddForm").validate({
				rules : {
					
					employee_Id : {
					required : true
				},
				date : {
					required : true
				},
				shiftId : {
					required : true
				},
				inTime : {
					required : true
				},
				
				outTime : {
					required : true
				
				},
				attendance : {
					required : true
				},
				},
				messages : {
					employee_Id : "<font style='color: red;'><b>Employee is Required</b></font>",
					date : "<font style='color: red;'><b>Date is Required</b></font>",
					shiftId: "<font style='color: red;'><b>Shift is Required</b></font>",
					inTime: "<font style='color: red;'><b>In Time is Required</b></font>",
					outTime: "<font style='color: red;'><b>Out Time is Required</b></font>",
					attendance: "<font style='color: red;'><b>Attendance is Required</b></font>",		
							
				},

			});
		});
		
		$('#updateId').click(function(event) {
			
			$("#empAttUpdateForm").validate({
				rules : {
					
					employee_IdEditt : {
					required : true
				},
				dateEditt : {
					required : true
				},
				shiftIdEditt : {
					required : true
				},
				inTimeEditt : {
					required : true
				},
				
				outTimeEditt : {
					required : true
				
				},
				attendanceEditt : {
					required : true
				},
				},
				messages : {
					employee_IdEditt : "<font style='color: red;'><b>Employee is Required</b></font>",
					dateEditt : "<font style='color: red;'><b>Date is Required</b></font>",
					shiftIdEditt : "<font style='color: red;'><b>Shift is Required</b></font>",
					inTimeEditt : "<font style='color: red;'><b>In Time is Required</b></font>",
					outTimeEditt : "<font style='color: red;'><b>Out Time is Required</b></font>",
					attendanceEditt : "<font style='color: red;'><b>Attendance is Required</b></font>",		
							
				},

			});
		});
		

	});
</script>
<script type="text/javascript">
	function doAjaxPostEdit() {
			
		
		var employee_IdEditt = $('#employee_IdEditt').val();
	
		var dateEditt=$('#dateEditt').val();

		var shiftIdEditt=$('#shiftIdEditt').val();
	
	
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/employeeAttendanceEditDuplicateCheck.mnt",

					data : "employee_IdEditt=" +employee_IdEditt + "&dateEditt=" +dateEditt+ "&shiftIdEditt=" +shiftIdEditt,

					success : function(response) {

						var checkResponse = "Employee Attendance with this date and Shift is Already Exists Please try some other";

						if (checkResponse == response) {
							document.getElementById("editmessage").style.display = "block";
							$('#editmessage').html(response);
						} else {
							document.getElementById("editmessage").style.display = "none";
						}
					},

					error : function(e) {

										}

				});
	}
</script>
<script type="text/javascript">
	function doAjaxPost() {
		
		var employee_Id = $('#employee_Id').val();
	
		var date=$('#date').val();
	
		var shiftId=$('#shiftId').val();

	
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/employeeAttendanceDuplicateAddCheck.mnt",

					data : "employee_Id=" +employee_Id + "&date=" +date+ "&shiftId=" +shiftId,

					success : function(response) {

						var checkResponse = "Employee Attendance with this date and Shift is Already Exists Please try some other";

						if (checkResponse == response) {
							document.getElementById("addmessage").style.display = "block";
							$('#addmessage').html(response);
						} else {
							document.getElementById("addmessage").style.display = "none";
						}
					},

					error : function(e) {

										}

				});

	}
</script>

<script>
	$(function() {
		$("#tabs").tabs();

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#search,#add').click(function(e) {
			$('#edit').hide();
		});
	});
</script>
<!--  Date picker -->

	<script>
	function dateFun(datePattern) {
		
		$(
		'#date,#dateEditt')
		.datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
		});
		
	}
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

		$("#add").click(function(e) {

			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();
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
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {

			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();

		});
	});
</script>
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Employee Attendance</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
			<c:forEach var="employeeAttendanceValues" items="${list}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
								code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
								code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="empAttSearch.mnt" method="GET"
						commandName="empAttendanceCommand">
						<table class="tableGeneral">
						
<tr>
								<td colspan="2"><c:forEach var="empAttendenceAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.attendance"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.attendance"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="empAttendanceUpdate"
										items="${empAttendanceUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.attendance"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="empAttendanceUpdateError"
										items="${empAttendanceUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.attendance"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="empAttendanceDelete"
										items="${empAttendanceDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.attendance"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="empAttendanceDeleteError"
										items="${empAttendanceDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.attendance"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
								<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="empAttendanceCommand.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>

									 </spring:bind> 
									
						 <form:input path="basicSearchId" cssClass="textbox" /></td>
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
							
						       
								
								<td><c:choose>
								<c:when test="${search}"><input type="submit"

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
					 <c:forEach var="empAttendanceSearch" items="${empAttendanceSearchS}">
						<c:set var="g" value="${empAttendanceSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}"> 
						<display:table id="employeeAttendanceValue" name="employeeAttendanceValue"
							requestURI="empAttSearch.mnt" pagesize="5" class="table">
							
							<display:column property="fName" titleKey="label.employee"
								media="html" sortable="true" />
							<display:column property="date" titleKey="label.date"
								media="html" sortable="true" />
							<display:column property="shift" titleKey="label.shift"
								media="html" sortable="true" />
							<display:column property="inTime" titleKey="label.intime"
								media="html" sortable="true" />
							<display:column property="outTime" titleKey="label.outtime"
								media="html" sortable="true" />
							<display:column property="attendance" titleKey="label.attendance"
								media="html" sortable="true" />
							<display:column property="overTime" titleKey="label.overtime"
								media="html" sortable="true" />		
								
								
							<display:column titleKey="label.edit" style="color:white">

							<c:choose>
							<c:when test="${edit }">
							<a

									href="employeeAttendanceIdEdit.mnt?employeeAttendanceIdEdit=<c:out value="${employeeAttendanceValue.empAttendanceId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when><c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
								
							</display:column>
							<display:column titleKey="label.delete">

							

								<c:choose>
								<c:when test="${delete}"><a
					href="employeeAttendanceIdDelete.mnt?employeeAttendanceIdDelete=<c:out value="${employeeAttendanceValue.empAttendanceId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a></c:when><c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
							
						
						
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
								</display:table>
					
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="empAttAdd.mnt" method="POST"
						commandName="empAttendanceCommand" id="empAttAddForm">
						<table class="tableGeneral">
							 <form:hidden path="aid" />
							<tr>
								<td colspan="2">
								<c:forEach
										var="adddEmpAttDuplicate" items="${adddEmpAttDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong>Warning!</strong>
											<font color="#C09853"><c:out value="${adddEmpAttDuplicate}" /></font>
										</div>
									</c:forEach></td>
							</tr> 
							<tr>
								<td><spring:message code="label.employee"/><font color="red">*</font>
								</td>
								<td><form:select path="employee_Id" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${employee}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.date"/><font color="red">*</font>
								</td>
								<td><form:input path="date" id="date"
										class="textbox" maxlength="50"/></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.shift"/><font color="red">*</font>
								</td>
								<td><form:select path="shiftId" class="select" onchange="doAjaxPost()">
										<form:option value="">-Select-</form:option>
										<form:options items="${shift}" />
									</form:select></td>
									<td style="display: none" id="addmessage" class="alert-warning"></td>
							</tr>
							<tr>
								<td><spring:message code="label.intime"/><font color="red">*</font>
								</td>
								<td><form:input path="inTime" 
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.outtime"/><font color="red">*</font>
								</td>
								<td><form:input path="outTime" 
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.attendance"/><font color="red">*</font>
								</td>
								<td><form:input path="attendance" 
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.overtime"/>
								</td>
								<td><form:input path="overTime" 
										class="textbox" maxlength="50"/></td>
							</tr>							
							<tr>
			<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit" value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbtnid" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose><input type="reset" value="<spring:message code="label.reset"/>"

									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>



				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					 <c:forEach var="employeeAttendanceValues" items="${list}">
						<form:form action="empAttEdit.mnt" method="POST"
							commandName="empAttendanceCommand" id="empAttUpdateForm">
							<table class="tableGeneral">
								 <tr>
									<td colspan="2"><c:forEach
											var="adddEmpAttDuplicate" items="${adddEmpAttDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong>Warning!</strong>
												<font color="#C09853"><c:out value="${adddEmpAttDuplicate}" /></font>
											</div>
										</c:forEach></td>
								</tr> 
								<form:hidden path="empAttendanceIdEditt" />
								<tr>
								<td><spring:message code="label.employee"/><font color="red">*</font>
								</td>
								<td><form:select path="employee_IdEditt" class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${employee}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.date"/><font color="red">*</font>
								</td>
								<td><form:input path="dateEditt" id="dateEditt"
										class="textbox" maxlength="50"/></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.shift"/><font color="red">*</font>
								</td>
								<td><form:select path="shiftIdEditt" class="select" onchange="doAjaxPostEdit()">
										<form:option value="">-Select-</form:option>
										<form:options items="${shift}" />
									</form:select></td>
									<td style="display: none" id="editmessage" class="alert-warning"></td>
							</tr>
							<tr>
								<td><spring:message code="label.intime"/><font color="red">*</font>
								</td>
								<td><form:input path="inTimeEditt" 
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.outtime"/><font color="red">*</font>
								</td>
								<td><form:input path="outTimeEditt" 
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.attendance"/><font color="red">*</font>
								</td>
								<td><form:input path="attendanceEditt" 
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.overtime"/><font color="red">*</font>
								</td>
								<td><form:input path="overTimeEditt" 
										class="textbox" maxlength="50"/></td>
							</tr>							
							<tr>

									<td colspan="2" ><c:choose>
										<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-primary" id="updateId" />
										</c:when>
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
