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
<title>My JSP 'MaintenanceOrderType.jsp' starting page</title>
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

		$("#startDate").datepicker();
		$("#endDate").datepicker();
	

	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						
						jQuery.validator.addMethod("alphaNumeric", function (value, element) {
					        return this.optional(element) || /^[0-9a-zA-Z][0-9a-zA-Z&_ ]+$/.test(value);
					    });
						
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
																	maintOrderType : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																
																																	

																},
																messages : {
																	

																	maintOrderType : {
																		
																		required: "<font style='color: red;'><b>Maintenance Order Type is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>Maintenance Order Type only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	}

																	

																	

																	

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
																	maintOrderTypeEdit : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																	
																},
																messages : {
																	maintOrderTypeEdit :{
																		
																		required: "<font style='color: red;'><b>Maintenance Order Type is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>Maintenance Order Type only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	}

																	

																	
																},
															});

										});

					});
</script>

<script type="text/javascript">
	function doAjaxPost() {

		//get the form values

		var maintOrderTypecheck = $('#maintOrderType').val();
		
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/maintOrderTypeCheck.mnt",

					data : "maintOrderTypecheck=" + maintOrderTypecheck,

					success : function(response) {

						var checkResponse = "Warning ! Maintenance Order Type already exists!";
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

		var maintOrderTypeEdit = $('#maintOrderTypeEdit').val();
		var maintOrderType_IdEdit = $('#maintOrderType_IdEdit').val();
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/maintOrderTypeEditCheck.mnt",

					data : "maintOrderTypeEdit=" + maintOrderTypeEdit
							+ "&maintOrderType_IdEdit=" + maintOrderType_IdEdit,

					success : function(response) {

						var checkResponse = "Warning ! Maintenance Order Type already exists!";
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
		<div class="PageTitle">MaintenanceOrder Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="mtvalues" items="${mtvalues}">
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
					<form:form method="get" action="MaintenanceOrderTypeSearch.mnt"
						commandName="maintenanceOrderTypeCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="maintOrderTypeAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.maintenanceOrderType"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.maintenanceOrderType"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="mainOrderTypeUpdated"
										items="${mainOrderTypeUpdated}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.maintenanceOrderType"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="mainOrderTypeUpdateError"
										items="${mainOrderTypeUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.maintenanceOrderType"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="mainOrderTypeDeleted"
										items="${mainOrderTypeDeleted}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.maintenanceOrderType"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="mainOrderTypeDeletedError"
										items="${mainOrderTypeDeletedError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.maintenanceOrderType"/> <spring:message code="label.deleteFail"></spring:message>
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
									</c:choose></td>
							</tr>

						</table>
					</form:form>


                   <c:forEach var="mtSearchvalues" items="${mtSearchvalues}">

						<c:set var="as" value="${mtSearchvalues}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">
					<display:table name="maintenanceOrderType" id="maintenanceOrderType" class="table"
						requestURI="MaintenanceOrderTypeSearch.mnt" pagesize="5">
						<display:column property="maintOrderType" sortable="true"
							titleKey="label.maintenanceOrderType" media="html" />
						
						
						<display:column titleKey="label.edit">
						<c:choose>
							<c:when test="${edit }">
							<a
								href="maintenanceOrderTypeEdit.mnt?maintenanceOrderTypeId=<c:out value="${maintenanceOrderType.maintOrderType_Id}"/> "><img
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
								href="maintenanceOrderTypeDelete.mnt?maintenanceOrderTypeId=<c:out value="${maintenanceOrderType.maintOrderType_Id}"/> "
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
								style="display: none; width:400px; height: 25px;"></td>
						</tr>
					</table>
					<form:form commandName="maintenanceOrderTypeCommand" id="addform" method="POST"
						action="maintenanceOrderTypeAdd.mnt">
						<table class="tableGeneral">
						
						<form:hidden path="aid" />
							
						
							<tr>
								<td><spring:message code="label.maintenanceOrderType"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="maintOrderType" id="maintOrderType" class="textbox" onkeyup="doAjaxPost()"/></td>
								
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
					<c:forEach var="mtvalues" items="${mtvalues}">
                      <table>
						<tr>
							<td colspan="4" class="alert-warning" id="editmessage"
								style="display: none; width: 400px; height: 25px;"></td>
						</tr>
					</table>
						<form:form method="post" action="MaintenanceOrderTypeUpdate.mnt"
							commandName="maintenanceOrderTypeCommand" id="editForm">
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
								 <form:hidden path="maintOrderType_IdEdit" id="maintOrderType_IdEdit" />


				              <tr>
								<td><spring:message code="label.maintenanceOrderType"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="maintOrderTypeEdit" id="maintOrderTypeEdit" class="textbox" onkeyup="doAjaxPostEdit()" /></td>
												

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
	</div>
</body>
</html>
