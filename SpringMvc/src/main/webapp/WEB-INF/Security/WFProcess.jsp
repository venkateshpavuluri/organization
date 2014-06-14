<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
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
						
						 $('#' + "sumbnid").click(function(event) {
						
											//alert($('#privilege').val());
											$("#addWfProcessForm")
													.validate(
															{

																rules : {
																	wfprocessName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	wfprocessVersionNo : {
																		required : true,
																		number : true
																		
																	},
																																		

																},
																messages : {
																	
																	wfprocessName :
																	{
																		required :"<font style='color:red;'><b>Process Name is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		},
																		wfprocessVersionNo:{
																			required :"<font style='color:red;'><b>Version Number is required </b></font>",
																			number:"<font style='color:red;'><b>Version Number must be numbers</b></font>"
																		}
																},

															});
										});

						 $('#updbut')
								.click( 
										function(event) {

											$("#updateWfProcessForm")
													.validate(
															{
																rules : {
																	wfprocessNameEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	wfprocessVersionNoEdit : {
																		required : true,
																		number : true
																	
																	},

																},
																messages : {
																	wfprocessNameEdit :
																	{
																		required :"<font style='color:red;'><b>Process Name is required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		},
																		wfprocessVersionNoEdit:{
																			required :"<font style='color:red;'><b>Version Number is required </b></font>",
																			number:"<font style='color:red;'><b>Version Number must be numbers</b></font>"
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
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#search,#add').click(function(e) {
			$('#edit').hide();
			
			
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


<style>
.required{
color:red;

}
</style>
</head>
<body>
<div class="divUserDefault">
		<div class="PageTitle">Business Process</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="wfprocessValues" items="${wfprocessValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:forEach>

				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!---================================ Search tab =======================================-->
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="wfprocessSearch.mnt" method="get"
						commandName="wfprocessAdd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach 
										items="${param.list}">
										<div class="alert-success" id="savemessage">
										<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.businessprocess"/> <spring:message code="label.saveSuccess"/>
										</div>
									</c:forEach>
									
									
									<c:forEach
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
										<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.businessprocess"/> <spring:message code="label.saveFail"/>
										</div>
									</c:forEach>
									
									
									<c:forEach 
										items="${wfprocessUpadteSuccess}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
									<spring:message code="label.businessprocess"/>	<spring:message code="label.updateSuccess"/>
					
										</div>
									</c:forEach><c:forEach 
										items="${wfprocessUpadteFail}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.businessprocess"/>	<spring:message code="label.updateFail"/>				
										</div>
									</c:forEach>
									<c:forEach
										items="${wfprocessDeleteSuccess}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.businessprocess"/>	<spring:message code="label.deleteSuccess"/>				
										</div>
									</c:forEach>
									
									<c:forEach
										items="${wfprocessDeleteFail}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.businessprocess"/>	<spring:message code="label.deleteFail"/>				
										</div>
									</c:forEach>
									
									</td>
							</tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="wfprocessAdd.operations">
										<select class="select" name="operations">
											<option value="<spring:message code='assignedOperator'/>">
												<spring:message code="label.equalsTo" />
											</option>
											<option value="<spring:message code='notequalsOperator'/>">
												<spring:message code="label.notEqualsTo" />
											</option>
											<option value="<spring:message code='beginsWithOperator'/>">
												<spring:message code="label.beginsWith" />
											</option>
											<option value="<spring:message code='endsWithOperator'/>">
												<spring:message code="label.endsWith" />
											</option>
											<option value="<spring:message code='containsOperator'/>">
												<spring:message code="label.contains" />
											</option>
										</select>
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary" /></td>
							</tr>

						</table>
					
					<c:if test="${wfprocessSearch!=null}">
					
							<display:table id="wfprocessRow" name="wfprocessSearch"
							requestURI="wfprocessSearch.mnt" pagesize="5" class="table" >

							<display:column property="wfprocessName"
								titleKey="label.processName" media="html" sortable="true"></display:column>
							<display:column property="wfprocessVersionNo"
								titleKey="label.versionNo" media="html" sortable="true" />

							<display:column titleKey="label.edit" style="color:white">
								<a
									href="wfprocessEditHome.mnt?wfprocessDetEdit=<c:out value="${wfprocessRow.wfprocessId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>

							<display:column titleKey="label.delete">
								<a
									href="wfprocessDelete.mnt?wfprocessidDelete=<c:out value="${wfprocessRow.wfprocessId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to delete the Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
							</display:column>
										
						<display:setProperty name="paging.banner.placement" value="bottom" />

						
						</display:table>
						</c:if>
					
					</form:form>
				</div>
			</div>


			<!---================================ Add tab =======================================-->
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="wfprocessAdd.mnt" method="GET"
						commandName="wfprocessAdd" id="addWfProcessForm"
						 onsubmit="return validateForm()">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach 
										items="${WFProcessDuplicate}">
										<div class="alert-warning" id="savemessage">
										<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.processName"/> <spring:message code="label.duplicateCheck"/>
										
										</div>
									</c:forEach></td>
							</tr>

							
							<form:hidden path="wfprocessId" />

							<tr>
								<td><spring:message code="label.processName" /><span
									class="required">*</span></td>
								<td><form:input path="wfprocessName" id="wfprocessName"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.versionNo" /><span
									class="required">*</span></td>
								<td><form:input path="wfprocessVersionNo"
										id="wfprocessVersionNo" class="textbox" maxlength="15"/></td>
							</tr>
							<form:hidden path="aid" />


							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /><input type="reset"
									class="btn btn-primary" value="<spring:message
								code="label.reset" />"/></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			<!---================================ Edit tab =======================================-->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<c:forEach var="wfprocessEditValues" items="${wfprocessValues }">
						<form:form action="wfprocessUpdate.mnt" method="POST"
							commandName="wfprocessAdd" id="updateWfProcessForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach 
											items="${wfprocessEditDuplicate}">
											<div class="alert-warning" id="successmessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.processName"/> <spring:message code="label.duplicateCheck"/>
									
											</div>
										</c:forEach></td>
								</tr>
							
							

								
								<form:hidden path="wfprocessIdEdit" />

								<tr>
									<td><spring:message code="label.processName" /><span
										class="required">*</span></td>
									<td><form:input path="wfprocessNameEdit"
											id="wfprocessName" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.versionNo" /><span
										class="required">*</span></td>
									<td><form:input path="wfprocessVersionNoEdit"
											id="wfprocessVersionNo" class="textbox" maxlength="15"/></td>
								</tr>

								<tr>
									<td colspan="2"><input type="submit" value="Update"
										class="btn btn-primary" id="updbut" /></td>
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




