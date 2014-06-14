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
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
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

<script>
	function dateFun(datePattern) {
		
		$(
		'#startDate,#endDate,#startDateEdit,#endDateEdit')
		.datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
		});
		
	}
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
																	fiscalYear : {
																		required : true,
																		number: true,
																		minlength:4,
																		maxlength:4
																	},
																	
																	startDate : {
																		required : true
																	},
																	endDate : {
																		required : true
																	},
																																	

																},
																messages : {
																	

																	fiscalYear : {
																		
																		 required: "<font style='color: red;'><b>Fiscal Year is Required.</b></font>",
																		 
																		   minlength: "<font style='color: red;'><b>Fiscal Year must be four digits.</b></font>",
														                	
															                maxlength: "<font style='color: red;'><b>Fiscal Year cannot exceed four digits.</b></font>",
															                
															                number: "<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	},

																	

																	startDate : "<font style='color: red;'><b>Start Date is Required</b></font>",

																	endDate : "<font style='color: red;'><b>End Date Of Joining is Required</b></font>",

																	

																	

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
																	fiscalYearEdit : {
																		required : true,
																		number: true,
																		maxlength:4,
																		minlength:4
																	},
																	calendarYearEdit : {
																		required : true
																	},
																	
																	startDateEdit : {
																		required : true
																	},
																	endDateEdit : {
																		required : true
																	},
																	
																},
																messages : {
																	fiscalYearEdit : {
																		 required: "<font style='color: red;'><b>Fiscal Year is Required.</b></font>",
														                	
																		 minlength: "<font style='color: red;'><b>Fiscal Year must be four digits.</b></font>",
														                	
															                maxlength: "<font style='color: red;'><b>Fiscal Year cannot exceed four digits.</b></font>",
															                
															                number: "<font style='color: red;'><b>Only Numbers are allowed.</b></font>",
																	},

																	calendarYearEdit : "<font style='color: red;'><b>CalendarYear is Required</b></font>",

																	startDateEdit : "<font style='color: red;'><b>Start Date is Required</b></font>",

																	endDateEdit : "<font style='color: red;'><b>End Date is Required</b></font>",

																	

																	
																},
															});

										});

					});
</script>

<script type="text/javascript">
	function doAjaxPost() {

		//get the form values

		var fiscalYearcheck = $('#fiscalYear').val();
		//alert("fiscal"+fiscalYearcheck);
		$
				.ajax({

					type : "POST",

					url : "fiscalYearCheck.mnt",

					data : "fiscalYearcheck=" + fiscalYearcheck,

					success : function(response) {
				
						var checkResponse = "Warning ! Fiscal Year already exists!";
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

		//get the form values

		var fiscalYearEdit = $('#fiscalYearEdit').val();
		var gLFiscalYear_IdEdit = $('#gLFiscalYear_IdEdit').val();
		$
				.ajax({

					type : "POST",

					url : "fiscalYearEditCheck.mnt",

					data : "fiscalYearEdit=" + fiscalYearEdit
							+ "&gLFiscalYear_IdEdit=" + gLFiscalYear_IdEdit,

					success : function(response) {

						var checkResponse = "Warning ! Fiscal Year already exists!";
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
		<div class="PageTitle">GLFiscalYear</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="glvalues" items="${glvalues}">
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
					<form:form method="get" action="GLFiscalYearSearch.mnt"
						commandName="gLFiscalYearCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">

						
                                       <c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.FiscalYear"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.FiscalYear"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										
										<c:forEach var="YearDelete"
										items="${YearDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.FiscalYear"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="YearDeleteErr"
										items="${YearDeleteErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.FiscalYear"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="YearUpdate"
										items="${YearUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.FiscalYear"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="YearUpdateErr"
										items="${YearUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.FiscalYear"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>


							
</td></tr>

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
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
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
							<td>
								<c:choose>
								<c:when test="${true}">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></c:otherwise>
								</c:choose></td>
							</tr>

						</table>
					</form:form>

					<c:if test="${glSearchvalues!=null }">
					<display:table name="GLFiscalYear" id="GLFiscalYear" class="table"
						requestURI="GLFiscalYearSearch.mnt" pagesize="5">
						<display:column property="fiscalYear" sortable="true"
							titleKey="label.FiscalYear" media="html" />
						<display:column property="calendarYear" sortable="true"
							titleKey="label.CalendarYear" media="html" />
						<display:column property="startDate" sortable="true"
							titleKey="label.StartDate" media="html" />
						<display:column property="endDate" sortable="true"
							titleKey="label.EndDate" media="html" />
						<display:column property="fiscalYearClosed" sortable="true"
							titleKey="label.FiscalYearClosed" media="html" />
						
						<display:column titleKey="label.edit">
						<c:choose>
						<c:when test="${true}">
							<a
								href="GLFiscalYearEdit.mnt?GLFiscalYearId=<c:out value="${GLFiscalYear.gLFiscalYear_Id}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a></c:when>
								<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
						</display:column>
						<display:column titleKey="label.delete">
						<c:choose>
						<c:when test="${true}">
							<a
								href="GLFiscalYearDelete.mnt?GLFiscalYearId=<c:out value="${GLFiscalYear.gLFiscalYear_Id}"/> "
								onclick="return confirm('Do You Want To Delete This Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a></c:when><c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
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
								style="display: none; width: 350px; height: 25px;"></td>
						</tr>
					</table>
					<form:form commandName="gLFiscalYearCommand" id="addform" method="POST"
						action="gLFiscalYearAdd.mnt">
						<table class="tableGeneral">
						
						<form:hidden path="aid" />
						
							<tr>
								<td><spring:message code="label.FiscalYear"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="fiscalYear" id="fiscalYear" class="textbox" onkeyup="doAjaxPost()"/></td>
								<!-- <td id="addmessage" class="alert-warning"></td>
									<td><font color="red"></font></td> -->
							</tr>
							
							
							<tr>
								<td><spring:message code="label.CalendarYear"></spring:message><font color="red">*</font></td>
								<td><form:radiobutton path="calendarYear" value="1"/>Yes
								<form:radiobutton path="calendarYear" value="0" checked="checked"/>No</td>
							</tr>
							
							<tr>
								<td><spring:message code="label.StartDate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="startDate" id="startDate" class="textbox" /></td>
							</tr>

							
							<tr>
								<td><spring:message code="label.EndDate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="endDate" id="endDate" class="textbox" /></td>
							</tr>
                             
                             <tr>
								<td><spring:message code="label.FiscalYearClosed"></spring:message><font color="red">*</font></td>
								<td><form:radiobutton path="fiscalYearClosed" value="1" />Yes
								<form:radiobutton path="fiscalYearClosed" value="0" checked="checked"/>No</td>
							</tr>   
                                
							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${true}">
								<input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="wsubmit" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>"
									class="btn btn-danger" /></c:otherwise>
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
					<c:forEach var="glvalues" items="${glvalues}">
                      <table>
						<tr>
							<td colspan="4" class="alert-warning" id="editmessage"
								style="display: none; width: 350px; height: 25px;"></td>
						</tr>
					</table>
						<form:form method="post" action="GLFiscalYearUpdate.mnt"
							commandName="gLFiscalYearCommand" id="editForm">
							<table class="tableGeneral">

                            	<tr>
									<td colspan="2"><c:forEach
											var="updateGLFiscalYearDuplicate"
											items="${updateGLFiscalYearDuplicate}">
											<div class="alert-warning" id="savemessage">
											<strong>Warning! </strong>
												<font color="#C09853"><c:out
														value="${updateGLFiscalYearDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								 <form:hidden path="gLFiscalYear_IdEdit" id="gLFiscalYear_IdEdit" />


				              <tr>
								<td><spring:message code="label.FiscalYear"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="fiscalYearEdit" id="fiscalYearEdit" class="textbox" onkeyup="doAjaxPostEdit()" /></td>
												

							  </tr>
							
							
							<tr>
								<td><spring:message code="label.CalendarYear"></spring:message><font color="red">*</font></td>
								<td><form:radiobutton path="calendarYearEdit" value="1" />Yes
								<form:radiobutton path="calendarYearEdit" value="0" />No</td>


							</tr>
							<tr>
								<td><spring:message code="label.StartDate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="startDateEdit" id="startDateEdit" class="textbox" /></td>


							</tr>

							
							<tr>
								<td><spring:message code="label.EndDate"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="endDateEdit" id="endDateEdit" class="textbox" /></td>


							</tr>
                             
                             <tr>
								<td><spring:message code="label.FiscalYearClosed"></spring:message><font color="red">*</font></td>
								<td><form:radiobutton path="fiscalYearClosedEdit" value="1" />Yes
								<form:radiobutton path="fiscalYearClosedEdit" value="0" />No</td>


							</tr>   


								<tr>
									<td colspan="2"><c:choose>
									<c:when test="${true}">
									<input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when>
										<c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
										</c:otherwise></c:choose></td>

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
