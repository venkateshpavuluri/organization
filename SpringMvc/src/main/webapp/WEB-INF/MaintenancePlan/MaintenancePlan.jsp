<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'maintenancePlan.jsp' starting page</title>
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


<!-- <script type="text/javascript">
	$(document).ready(function() {
		$("#formID").validationEngine('hide');

	});
</script>
 -->
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
function dateFun(datePattern) {
	$('#plannedDT,#plannedDTEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						jQuery.validator.addMethod("alphaNumeric", function (value, element) {
					        return this.optional(element) || /^[0-9a-zA-Z][0-9a-zA-Z&_ ]+$/.test(value);
					    });
						//AddForm Validations
						$('#wsubmit')
								.click(
										function(event) {

											$('#addform')
													.validate(
															{
																rules : {
																	maintenanceType_Id : {
																		required : true
																	},
																	plant_Id : {
																		required : true
																	},
																	description:{
																		
																		alphaNumeric: true
																	},
																	plannedDT : {
																		required : true
																	},
																	shift_Id : {
																		required : true
																	},
																	equipment_Id : {
																		required : true
																	},
																	status_Id : {
																		required : true
																	},															

																},
																messages : {
																	

																	maintenanceType_Id : "<font style='color: red;'><b>Maintenance Type is Required</b></font>",

																	plant_Id : "<font style='color: red;'><b>Plant is Required</b></font>",
																	
																	description : "<font style='color: red;'><b>Special Characters are not allowed</b></font>",

																	plannedDT : "<font style='color: red;'><b>Planed Date is Required</b></font>",

																	shift_Id : "<font style='color: red;'><b>Shift is Required</b></font>",
																	
																	equipment_Id : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	
																	status_Id : "<font style='color: red;'><b>Status is Required</b></font>",
																	

																	

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
																	maintenanceType_IdEdit : {
																		required : true
																	},
																	plant_IdEdit : {
																		required : true
																	},
																	
																	plannedDTEdit : {
																		required : true
																	},
																	shift_IdEdit : {
																		required : true
																	},
																	equipment_IdEdit : {
																		required : true
																	},
																	status_IdEdit : {
																		required : true
																	},
																	
																},
																messages : {
																	maintenanceType_IdEdit : "<font style='color: red;'><b>Maintenance Type is Required</b></font>",

																	plant_IdEdit : "<font style='color: red;'><b>Plant is Required</b></font>",

																	plannedDTEdit : "<font style='color: red;'><b>Planed Date is Required</b></font>",

																	shift_IdEdit : "<font style='color: red;'><b>Shift is Required</b></font>",
																	
																	equipment_IdEdit : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	
																	status_IdEdit : "<font style='color: red;'><b>Status is Required</b></font>",

																	

																	
																},
															});

										});

					});
</script>



<script type="text/javascript">
	function doAjaxPost() {

		//get the form values

		var equipment_Id = $('#equipment_Id').val();
		var plannedDT=$('#plannedDT').val();
	
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/maintenancePlanCheck.mnt",

					data : "equipment_Id=" + equipment_Id
					+ "&plannedDT=" + plannedDT,

					success : function(response) {

						var checkResponse = "Warning ! Maintenance Plan already exists!";

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
var equipment_IdEdit = $('#equipment_IdEdit').val();
		var plannedDTEdit=$('#plannedDTEdit').val();
	
		var maintenancePlan_IdEdit = $('#maintenancePlan_IdEdit').val();
		$
				.ajax({

					type : "POST",

					url : "/MNTERP/maintenancePlanEditCheck.mnt",

					data : "equipment_IdEdit=" + equipment_IdEdit + "&plannedDTEdit=" + plannedDTEdit
							+ "&maintenancePlan_IdEdit=" + maintenancePlan_IdEdit,

					success : function(response) {

						var checkResponse = "Warning ! Maintenance Plan already exists!";
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
		<div class="PageTitle">Maintenance Plan</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="mpEditvalues" items="${mpEditvalues}">
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
					<form:form method="get" action="maintenancePlanSearch.mnt"
						commandName="maintenancePlanCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="codeGroupAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.maintenancePlan"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.maintenancePlan"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="maintenancePlanUpdate"
										items="${maintenancePlanUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.maintenancePlan"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="maintenancePlanUpdateError"
										items="${maintenancePlanUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.maintenancePlan"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="maintenacePlanDelete"
										items="${maintenacePlanDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.maintenancePlan"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="maintenacePlanDeleteError"
										items="${maintenacePlanDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.maintenancePlan"/> <spring:message code="label.deleteFail"></spring:message>
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
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>

						</table>
					</form:form>


                   <c:forEach var="mpvalue" items="${mpvalue}">

						<c:set var="as" value="${mpvalue}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">
					<display:table name="MaintenancePlan" id="MaintenancePlan" class="table"
						requestURI="maintenancePlanSearch.mnt" pagesize="5">
						<display:column property="maintenanceTypeName" sortable="true"
							titleKey="label.maintenanceType" media="html" />
						<display:column property="plantName" sortable="true"
							titleKey="label.plant" media="html" />
						<display:column property="equipmentName" sortable="true"
							titleKey="label.equipment" media="html" />
						<display:column property="shiftName" sortable="true"
							titleKey="label.shift" media="html" />
						<display:column property="statusName" sortable="true"
							titleKey="label.status" media="html" />
						
						<display:column titleKey="label.edit">
							<a
								href="maintenancePlanEdit.mnt?maintenancePlanId=<c:out value="${MaintenancePlan.maintenancePlan_Id}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:column titleKey="label.delete">
							<a
								href="maintenancePlanDelete.mnt?maintenancePlanId=<c:out value="${MaintenancePlan.maintenancePlan_Id}"/> "
								onclick="return confirm('Do You Want To Delete This Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
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
					<form:form commandName="maintenancePlanCommand" id="addform" method="POST"
						action="maintenancePlanAdd.mnt">
						<table class="tableGeneral">
						
						<%-- <form:hidden path="aid" /> --%>
							
						
							<tr>
							<td><spring:message code="label.maintenanceType" /><font color="red">*</font></td>
									<td><form:select path="maintenanceType_Id" id="maintenanceType_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${maintenanceType }" />
										</form:select></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.plant" /><font color="red">*</font></td>
									<td><form:select path="plant_Id" id="plant_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${plant }" />
										</form:select></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.equipment" /><font color="red">*</font></td>
									<td><form:select path="equipment_Id" id="equipment_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${equipment }" />
										</form:select></td>
							</tr>

							
							<tr>
								<td><spring:message code="label.plannedDT"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="plannedDT" id="plannedDT" class="textbox" onchange="doAjaxPost()"/></td>
							</tr>
                             
                             <tr>
								<td><spring:message code="label.shift" /><font color="red">*</font></td>
									<td><form:select path="shift_Id" id="shift_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${shift }" />
										</form:select></td>
							</tr>   
                                <tr>
								<td><spring:message code="label.description"></spring:message></td>
								<td><form:input path="description" id="description" class="textbox" /></td>
							</tr>
							
							  <tr>
								<td><spring:message code="label.status" /><font color="red">*</font></td>
									<td><form:select path="status_Id" id="status_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${status }" />
										</form:select></td>
							</tr>  
							<tr>
								<td colspan="2"><input type="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="wsubmit" /><input type="reset"
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
					<c:forEach var="mpEditvalues" items="${mpEditvalues}">
                      <table>
						<tr>
							<td colspan="4" class="alert-warning" id="editmessage"
								style="display: none; width: 350px; height: 25px;"></td>
						</tr>
					</table>
						<form:form method="post" action="maintenancePlanUpdate.mnt"
							commandName="maintenancePlanCommand" id="editForm">
							<table class="tableGeneral">

                            	
								 <form:hidden path="maintenancePlan_IdEdit" id="maintenancePlan_IdEdit" />


				            <tr>
							<td><spring:message code="label.maintenanceType" /><font color="red">*</font></td>
									<td><form:select path="maintenanceType_IdEdit" id="maintenanceType_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${maintenanceType }" />
										</form:select></td>
								
							</tr>
							
							
							<tr>
								<td><spring:message code="label.plant" /><font color="red">*</font></td>
									<td><form:select path="plant_IdEdit" id="plant_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${plant }" />
										</form:select></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.equipment" /><font color="red">*</font></td>
									<td><form:select path="equipment_IdEdit" id="equipment_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${equipment }" />
										</form:select></td>
							</tr>

							
							<tr>
								<td><spring:message code="label.plannedDT"></spring:message><font
									color="red">*</font></td>
								<td><form:input path="plannedDTEdit" id="plannedDTEdit" class="textbox" onchange="doAjaxPostEdit()"/></td>
							</tr>
                             
                             <tr>
								<td><spring:message code="label.shift" /><font color="red">*</font></td>
									<td><form:select path="shift_IdEdit" id="shift_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${shift }" />
										</form:select></td>
							</tr>   
                                <tr>
								<td><spring:message code="label.description"></spring:message></td>
								<td><form:input path="descriptionEdit" id="descriptionEdit" class="textbox" /></td>
							</tr>
							
							  <tr>
								<td><spring:message code="label.status" /><font color="red">*</font></td>
									<td><form:select path="status_IdEdit" id="status_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${status }" />
										</form:select></td>
							</tr>  

								<tr>
									<td colspan="2"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></td>

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
