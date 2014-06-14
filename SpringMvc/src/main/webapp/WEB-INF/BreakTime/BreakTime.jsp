<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#' + "subtnId")
								.click(
										function(event) {

											$("#addForm")
													.validate(
															{

																rules : {
																	breakTimecode : {
																		required : true
																	},
																	starttime : {
																		required : true
																	},
																	endtime : {
																		required : true
																	},
																	shift : {
																		required : true
																	},
																	organization : {
																		required : true
																	},
																},
																messages : {
																	breakTimecode : "<font style='color: red;'><b>BreakTime Code is Required</b></font>",
																	starttime : "<font style='color: red;'><b>Start Time is Required</b></font>",
																	endtime : "<font style='color: red;'><b>End Time is Required</b></font>",
																	shift : "<font style='color: red;'><b>Shift is Required</b></font>",
																	organization : "<font style='color: red;'><b>Organization is Required</b></font>"
																},

															});
										});

						$('#updateId ')
								.click(
										function(event) {

											$("#upBreakForm")
													.validate(
															{
																rules : {
																	breakTimecodeEdit : {
																		required : true
																	},
																	starttimeEdit : {
																		required : true
																	},
																	endtimeEdit : {
																		required : true
																	},
																	shiftEdit : {
																		required : true
																	},
																	organizationEdit : {
																		required : true
																	},
																},
																messages : {
																	breakTimecodeEdit : "<font style='color: red;'><b>BreakTime Code is Required</b></font>",
																	starttimeEdit : "<font style='color: red;'><b>Start Time is Required</b></font>",
																	endtimeEdit : "<font style='color: red;'><b>End Time is Required</b></font>",
																	shiftEdit : "<font style='color: red;'><b>Shift is Required</b></font>",
																	organizationEdit : "<font style='color: red;'><b>Organization is Required</b></font>"
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
 function timedifference() {
//alert("check");
		var start = $("#starttime").val();
		//alert(start);

		var end = $("#endtime").val();
		//alert(end);

		sum = (parseFloat(end) - parseFloat(start)+24)%24;
	$("#length").val(sum);
		
	} 
	
</script>
<script type="text/javascript">
	function timediff() {

		var start = $("#starttimeEdit").val();
		//alert(start);
		var end = $("#endtimeEdit").val();
		sum = (parseFloat(end) - parseFloat(start)+24)%24;
       $("#lengthEdit ").val(sum);

	}
</script>
<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
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
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#subid').click(function(e) {

			var aid = document.getElementById("breakhide").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("breakhide").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>
<style>
.required{
color:red;

}
</style>
</head>
<body>
        <div class="divUserDefault">
		<div class="PageTitle">Break Time</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="breakValues" items="${editvalues}">
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
					<form:form action="searchBRTime.mnt" method="GET"
						commandName="BreakTime">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">
								
								<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.breakCode"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
											<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.breakCode"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="breakDel"
										items="${breakDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.breakCode"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="breakDelErr"
										items="${breakDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.breakCode"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="breakTimeUpdate"
										items="${breakTimeUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.breakCode"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="breakTimeUpdateErr"
										items="${breakTimeUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.breakCode"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
								
								</td></tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="BreakTime.operations">
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
										<c:when test="${privileges eq messageup }">
										<c:set var="update" value="true"></c:set>
										</c:when>
										</c:choose>
										
								</c:forEach> 
								<td><c:choose>
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

					<c:forEach var="breakBeans" items="${breakBeans}">
						<c:set var="sf" value="${breakBeans}"></c:set>
					</c:forEach>
					<c:if test="${sf!=null}">
						<display:table id="bTimeId" name="breakBeans"
							requestURI="searchBRTime.mnt" pagesize="5" class="table">
							<display:column property="breakTimeId" title="BreakTimeId" media="none"
								sortable="true"></display:column>
							<display:column property="breakTimecode" titleKey="label.breakCode"
								media="html" sortable="true"></display:column>
							<display:column property="starttime" titleKey="label.starttime"
								media="html" sortable="true"></display:column>
							<display:column property="endtime" titleKey="label.endtime"
								media="html" sortable="true"></display:column>
							<display:column property="length" titleKey="label.length"
								media="html" sortable="true"></display:column>
								<display:column property="shift" titleKey="label.shift"
								media="html" sortable="true"></display:column>
								<display:column property="organization" titleKey="label.orgId"
								media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
								<a
									href="breakTimeEdit.mnt?breakedit=<c:out value="${bTimeId.breakTimeId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
								<a
									href="breakTimeDelete.mnt?breakdelete=<c:out value="${bTimeId.breakTimeId}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
									</c:when>
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

				</div>
			</div>
			
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="addBRTime.mnt"
						commandName="BreakTime" method="post"  id="addForm">
						<table class="tableGeneral">

							<form:hidden path="aid" id="aid" />
							
							<tr>
								<td><spring:message code="label.breakCode" /><span
									class="required">*</span></td>
								<td><form:input path="breakTimecode" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.starttime" /><span
									class="required">*</span></td>
								
							<td><form:select path="starttime" class="select" onchange="timedifference()">
										 <form:option value="">--Select--</form:option>
										 <form:option value="24">24</form:option>
								         <form:option value="23">23</form:option>
								         <form:option value="22">22</form:option>
								         <form:option value="21">21</form:option>
								         <form:option value="20">20</form:option>
								         <form:option value="19">19</form:option>
								         <form:option value="18">18</form:option>
								         <form:option value="17">17</form:option>
								         <form:option value="16">16</form:option>
								         <form:option value="15">15</form:option>
								         <form:option value="14">14</form:option>
								         <form:option value="13">13</form:option>
								         <form:option value="12">12</form:option>
								         <form:option value="11">11</form:option>
								         <form:option value="10">10</form:option>
								         <form:option value="9">9</form:option>
								         <form:option value="8">8</form:option>
								         <form:option value="7">7</form:option>
								         <form:option value="6">6</form:option>
								         <form:option value="5">5</form:option>
								         <form:option value="4">4</form:option>
								         <form:option value="3">3</form:option>
								         <form:option value="2">2</form:option>
								         <form:option value="1">1</form:option>
								</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.endtime" /><span
									class="required">*</span></td>
							
							<td><form:select path="endtime" class="select"  onchange="timedifference()" >
										 <form:option value="">--Select--</form:option>
										 <form:option value="24">24</form:option>
								         <form:option value="23">23</form:option>
								         <form:option value="22">22</form:option>
								         <form:option value="21">21</form:option>
								         <form:option value="20">20</form:option>
								         <form:option value="19">19</form:option>
								         <form:option value="18">18</form:option>
								         <form:option value="17">17</form:option>
								         <form:option value="16">16</form:option>
								         <form:option value="15">15</form:option>
								         <form:option value="14">14</form:option>
								         <form:option value="13">13</form:option>
								         <form:option value="12">12</form:option>
								         <form:option value="11">11</form:option>
								         <form:option value="10">10</form:option>
								         <form:option value="9">9</form:option>
								         <form:option value="8">8</form:option>
								         <form:option value="7">7</form:option>
								         <form:option value="6">6</form:option>
								         <form:option value="5">5</form:option>
								         <form:option value="4">4</form:option>
								         <form:option value="3">3</form:option>
								         <form:option value="2">2</form:option>
								         <form:option value="1">1</form:option>
								</form:select></td> 
							</tr>
							<tr>
								<td><spring:message code="label.length" /></td>
								<td><form:input path="length" id="length" name="length"
										class="textbox" readonly="true" /></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.shift" /><span
									class="required">*</span></td>
									<td><form:select path="shift" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${shift}" />
								</form:select></td>
								</tr>
								<tr>
								<td><spring:message code="label.orgId" /><span
									class="required">*</span></td>
									<td><form:select path="organization" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${organization}" />
								</form:select></td>
								</tr>
								<tr>
								<td colspan="2"><c:choose>
							<c:when test="${save}"><input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/> " class="btn btn-danger"
									id="orgTypeSubmit" />
									</c:otherwise>
							</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="BreakEditValues" items="${editvalues }">
						<form:form action="breakUpdate.mnt" method="POST"
							commandName="BreakTime" id="upBreakForm">
							<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="breakTimeUpdate"
										items="${breakTimeUpdate}">
										<div class="alert-warning" id="successmessage">

											<c:out value="${breakTimeUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="breakTimeIdEdit" id="breakTimeIdEdit" />
							<tr>
								<td><spring:message code="label.breakCode" /><span
									class="required">*</span></td>
								<td><form:input path="breakTimecodeEdit" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.starttime" /><span
									class="required">*</span></td>
								
							<td><form:select path="starttimeEdit" class="select" onchange="timediff()">
										 <form:option value="">--Select--</form:option>
										 <form:option value="24">24</form:option>
								         <form:option value="23">23</form:option>
								         <form:option value="22">22</form:option>
								         <form:option value="21">21</form:option>
								         <form:option value="20">20</form:option>
								         <form:option value="19">19</form:option>
								         <form:option value="18">18</form:option>
								         <form:option value="17">17</form:option>
								         <form:option value="16">16</form:option>
								         <form:option value="15">15</form:option>
								         <form:option value="14">14</form:option>
								         <form:option value="13">13</form:option>
								         <form:option value="12">12</form:option>
								         <form:option value="11">11</form:option>
								         <form:option value="10">10</form:option>
								         <form:option value="9">9</form:option>
								         <form:option value="8">8</form:option>
								         <form:option value="7">7</form:option>
								         <form:option value="6">6</form:option>
								         <form:option value="5">5</form:option>
								         <form:option value="4">4</form:option>
								         <form:option value="3">3</form:option>
								         <form:option value="2">2</form:option>
								         <form:option value="1">1</form:option>
								</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.endtime" /><span
									class="required">*</span></td>
							
							<td><form:select path="endtimeEdit" class="select"  onchange="timediff()" >
										 <form:option value="">--Select--</form:option>
										 <form:option value="24">24</form:option>
								         <form:option value="23">23</form:option>
								         <form:option value="22">22</form:option>
								         <form:option value="21">21</form:option>
								         <form:option value="20">20</form:option>
								         <form:option value="19">19</form:option>
								         <form:option value="18">18</form:option>
								         <form:option value="17">17</form:option>
								         <form:option value="16">16</form:option>
								         <form:option value="15">15</form:option>
								         <form:option value="14">14</form:option>
								         <form:option value="13">13</form:option>
								         <form:option value="12">12</form:option>
								         <form:option value="11">11</form:option>
								         <form:option value="10">10</form:option>
								         <form:option value="9">9</form:option>
								         <form:option value="8">8</form:option>
								         <form:option value="7">7</form:option>
								         <form:option value="6">6</form:option>
								         <form:option value="5">5</form:option>
								         <form:option value="4">4</form:option>
								         <form:option value="3">3</form:option>
								         <form:option value="2">2</form:option>
								         <form:option value="1">1</form:option>
								</form:select></td> 
							</tr>
							<tr>
								<td><spring:message code="label.length" /></td>
								<td><form:input path="lengthEdit" id="lengthEdit" name="length"
										class="textbox" readonly="true" /></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.shift" /><span
									class="required">*</span></td>
									<td><form:select path="shiftEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${shift}" />
								</form:select></td>
								</tr>
								<tr>
								<td><spring:message code="label.orgId" /><span
									class="required">*</span></td>
									<td><form:select path="organizationEdit" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${organization}" />
								</form:select></td>
								</tr>
						<tr>
									<td colspan="2"><c:choose>
								<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateId" /></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										value="<spring:message code="label.update"/> "
										class="btn btn-danger" id="updateId" />
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