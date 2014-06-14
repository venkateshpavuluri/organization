<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'AssertTypeTemplate.jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<!-- File Uploading Queue -->




<script type="text/javascript">
	$(function() {
		$("#tabs,#subtab").tabs();
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
<script>

  $(function() {
	 
    $( "#datepicker1,#datepicker2" ).datepicker();
  });
  

  </script>
  
  <!-- For File Uploading Using uploadify -->
<script type='text/javascript'>
function deleteRow(id)
{

	$('#f'+id).fadeOut(400, function(){
		$('#f'+id).remove();
	 });
	}
$(document).ready(function(){
	var counter = 2;
	
	$('#del_file').hide();
	$('#add_file').click(function(){
		$('#file_tools').before('<tr id="f'+counter+'"><td><spring:message code="label.eqDocumentName"/><span class="required">*</span></td><td>&nbsp;&nbsp;<input type="text" name="docName" class="textbox">&nbsp;&nbsp;</td><td><spring:message code="label.eqDocumentPath" /><span class="required">*</span></td><td>&nbsp;&nbsp;<input name="file" type="file"></td><td><img src="images/Delete.jpg" style="cursor:pointer; cursor:hand; width:20px; height:20px;" class="deleterow"  onclick="deleteRow('+counter+')"/></td></tr>');
		$('#del_file').fadeIn(0);
	counter++;
	});
	$('#del_file').click(function(){
		if(counter==3){
			$('#del_file').hide();
		}   
		counter--;
		$('#f'+counter).remove();
	});
	$("#doc .deleterow").click(function() {
		
        var td = $(this).parent();
        var tr = td.parent();
        

        tr.fadeOut(400, function(){
            tr.remove();
            return false;
        });
    });
	return false;
});
</script>
<script type="text/javascript">
function isValidDate() {
    var fromdate, todate, dt1, dt2, mon1, mon2, yr1, yr2, date1, date2;
    var chkFrom = document.getElementById("datepicker1").value;
    var chkTo = document.getElementById("datepicker2").value;
        date1 = new Date(chkFrom);
        date2 = new Date(chkTo);
 
        if (date2 <= date1) {
          alert("To date Should be greater than From date");
          chkFrom.value = '';
          chkFrom.focus();
          return false;
        }
     
   
   
  }
</script>
<!-- Duplication Checking with Ajax -->
<script type="text/javascript">
	function AjaxForDuplicate() {
		var eName = $('#equipmentName').val();
		//alert(cust);

		$
				.ajax({
					type : "POST",

					url : "/MNTERP/checkEquipAddDuplicate.mnt",
					data : "equipmentName=" + eName,
					success : function(response) {
						if (response != "") {

							document.getElementById("equipDuplMessage").style.display = "block";
							$('#equipDuplMessage').html(response);

						} else {
							document.getElementById("equipDuplMessage").style.display = "none";
						}

					},
					error : function(e) {
						
					}

				});

	}

	function AjaxUpdateDuplicate() {
		var equp = $('#equipmentNameEdit').val();
		var id = $('#equipmentIdEdit').val();
		$
				.ajax({
					type : "POST",

					url : "/MNTERP/checkUpdateEquipDuplicate.mnt",
					data : "equipmentName="+equp+"&eqId="+ id,
					success : function(response) {
						alert(response);
						if (response != "") {
							
							document.getElementById("equpUpDuplMessage").style.display = "block";
							$('#equpUpDuplMessage').html(response);

						} else {
							document.getElementById("equpUpDuplMessage").style.display = "none";
						}

					},
					error : function(e) {
						alert('Error' + e);
					}

				});

	}
</script>
 
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {
											
											$('#addForm')
													.validate(
															{
																rules : {
																	equipmentName : {
																		required : true
																	},
																	productionCapacity : {
																		required : true
																	},
																	make: {
																		required : true
																	},
																	model : {
																		required : true
																	},
																	validTo : {
																		required : true
																	},
																	validFrom : {
																		required : true
																	},
																	workInstruction : {
																		required : true
																	},
																	equipmentCategoryId:{
																		required : true
																	},
																	powerConsumptionInHours:{
																		required : true
																	},
																	productionCapacity:{
																		required : true
																	},
																	docName:{
																		required : true
																	},
																	file:{
																		required : true
																	},
																},
																messages : {
																	equipmentName : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	productionCapacity : "<font style='color: red;'><b>Production Capacity is Required</b></font>",
																	make : "<font style='color: red;'><b>Make is Required</b></font>",
																	model : "<font style='color: red;'><b>Model is Required</b></font>",
																	validTo : "<font style='color: red;'><b>Valid To is Required</b></font>",
																	validFrom : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	workInstruction : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	equipmentCategoryId:"<font style='color: red;'><b>EquipmentCategory is Required</b></font>",
																	powerConsumptionInHours:"<font style='color: red;'><b>powerConsumptionInHours is Required</b></font>",
																	productionCapacity:"<font style='color: red;'><b>productionCapacity is Required</b></font>",
																	docName:"<font style='color: red;'><b>DocumentName is Required</b></font>",
																	file:"<font style='color: red;'><b>File is Required</b></font>"
																},

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
																	equipmentNameEdit : {
																		required : true
																	},
																	productionCapacityEdit : {
																		required : true
																	},
																	makeEdit: {
																		required : true
																	},
																	modelEdit : {
																		required : true
																	},
																	validToEdit : {
																		required : true
																	},
																	validFromEdit : {
																		required : true
																	},
																	workInstructionEdit : {
																		required : true
																	},
																	equipmentCategoryIdEdit:{
																		required : true
																	},
																	powerConsumptionInHoursEdit:{
																		required : true
																	},
																	productionCapacityEdit:{
																		required : true
																	},
																},
																messages : {
																	equipmentNameEdit : "<font style='color: red;'><b>Equipment is Required</b></font>",
																	productionCapacityEdit : "<font style='color: red;'><b>Production Capacity is Required</b></font>",
																	makeEdit : "<font style='color: red;'><b>Make is Required</b></font>",
																	modelEdit : "<font style='color: red;'><b>Model is Required</b></font>",
																	validToEdit : "<font style='color: red;'><b>Valid To is Required</b></font>",
																	validFromEdit : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	workInstructionEdit : "<font style='color: red;'><b>Valid From is Required</b></font>",
																	equipmentCategoryIdEdit:"<font style='color: red;'><b>EquipmentCategory is Required</b></font>",
																	powerConsumptionInHoursEdit:"<font style='color: red;'><b>powerConsumptionInHours is Required</b></font>",
																	productionCapacityEdit:"<font style='color: red;'><b>productionCapacity is Required</b></font>",
																},

															});

										});

					});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("cId").value == 1) {

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
			document.getElementById("cId").value = 1;
			//alert(document.getElementById("atId").value);
		});
	});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		$('#updateid').click(function(e) {
			document.getElementById("ctIdEdit").value = 1;
			//alert(document.getElementById("ateditId").value);

		});
	});
</script>



</head>

<body>
	<div class="divUserDefault">Equipment</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="equipmentEdit" items="${equipmentEdit}">
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
					<form:form method="get" action="equipmentSearch.mnt"
						commandName="equipmentCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="equipmentAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.equipment"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.equipment"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="equipUpdate"
										items="${equipUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.equipment"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="equipUpdateError"
										items="${equipUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.equipment"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="equipDeleted"
										items="${equipDeleted}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.equipment"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="equipDeletedError"
										items="${equipDeletedError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.equipment"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="equipmentCmd.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind>  <form:input path="basicSearchId" cssClass="textbox" />
									 
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
					<c:forEach var="equip" items="${equipmentBean}">
						<c:set var="equ" value="${equip}"></c:set>
					</c:forEach>

					<c:if test="${equ!=null }">
						<display:table name="equipmentBean" id="equipmentList" class="table"
							requestURI="equipmentSearch.mnt" pagesize="5">
							<display:column property="equipmentId" sortable="true"
								title="Equipment Id" media="none" />
							<display:column property="equipmentName" sortable="true"
								titleKey="label.equipmentName" media="html" />
							<display:column property="equipmentCategory" sortable="true"
								titleKey="label.equipmentcategory" media="html" />
							<display:column property="make" sortable="true"
								titleKey="label.make" media="html" />
							<display:column property="model" sortable="true"
								titleKey="label.model" media="html" />
							<display:column property="powerConsumptionInHours" sortable="true"
								titleKey="label.powerConsumptionInHours" media="html" />
							<display:column property="productionCapacity" sortable="true"
								titleKey="label.productionCapacity" media="html" />
							<display:column property="validFrom" sortable="true"
								titleKey="label.validFrom" media="html" />
							<display:column property="validTo" sortable="true"
								titleKey="label.validTo" media="html" />
							<display:column property="workInstruction" sortable="true"
								titleKey="label.workInstruction" media="html" />
							<display:column titleKey="label.edit">
								<a
									href="equipmentEdit.mnt?equipmentId=<c:out value="${equipmentList.equipmentId}"/> "><img
									src="images/Edit.jpg" width="20px" height="20px" /></a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="equipmentDelete.mnt?equipmentId=<c:out value="${equipmentList.equipmentId}"/> "
									onclick="return confirm('Do You Want To Delete This Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
							</display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>

					</c:if>

				</div>

			</div>
 
			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="4" class="alert-warning" id="equipDuplMessage"
								style="display: none; width: 350px; height: 25px; color: red"></td>
						</tr>
					</table>

					<form:form action="equipmentAdd.mnt" id="addForm" method="POST"
						commandName="equipmentCmd" enctype="multipart/form-data">
						<table class="tableGeneral">
							<form:hidden path="eId" />
							<tr>
								<td><spring:message code="label.equipmentName" /><span
									class="required">*</span></td><td> <form:input path="equipmentName"
										class="textbox" onkeyup="AjaxForDuplicate()" /></td>
								<td></td>
								<td></td>
								<td><spring:message code="label.productionCapacity" /><span
									class="required">*</span></td><td> <form:input path="productionCapacity"
										class="textbox" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.equipmentcategory" /><span
									class="required">*</span></td><td> <form:select path="equipmentCategoryId"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${equipmentCatSelect}" />
									</form:select></td>
								<td></td>
								<td></td>
								<td><spring:message code="label.validFrom" /><span
									class="required">*</span></td><td> <form:input path="validFrom"
										class="textbox"  id="datepicker1"/></td>

							</tr> 
							<tr>
								<td><spring:message code="label.make" /><span
									class="required">*</span></td><td> <form:input path="make"
										class="textbox"  /></td>
								<td></td>
								<td></td>
								<td><spring:message code="label.validTo" /><span
									class="required">*</span></td><td> <form:input path="validTo"
										class="textbox" id="datepicker2" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.model" /><span
									class="required">*</span></td><td> <form:input path="model"
										class="textbox"  /></td>
									<td></td>
									<td></td>
									<td><spring:message code="label.workInstruction" /><span
									class="required">*</span></td><td> <form:input path="workInstruction"
										class="textbox"  onfocus="isValidDate()"/></td>

							</tr>
							<tr>
								<td><spring:message code="label.powerConsumptionInHours" /><span
									class="required">*</span></td><td> <form:input path="powerConsumptionInHours"
										class="textbox" /></td>

							</tr>
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" />
								</td>
							</tr>
						</table>
					
					
					<!-- Sub Tabbing Details -->
					<div id="subtab" align="left">
						<ul>
							<li><a href="#tab1">Equipment Documents</a></li>
						</ul>

						<!--Sub Tab-1 -->
						<div id="tab1">
								<table id="doc">
								
								<tr id='f1'><td><spring:message code="label.eqDocumentName" /><span
									class="required">*</span>
								</td><td> &nbsp;&nbsp;<form:input path="docName" class="textbox" />&nbsp;&nbsp;</td>
								<td>
								<spring:message code="label.eqDocumentPath" /><span
									class="required">*</span></td><td>
								
								 &nbsp;&nbsp;<input name='file' id="upfile" type='file' />
							
								</td><td><img src="images/Delete.jpg" style="cursor:pointer; cursor:hand; width:20px; height:20px;"  class="deleterow" /></td></tr>
								<tr id='file_tools'><td></td></tr>
								<tr><td colspan="2"><input type="button" id='add_file' value="Add" class="btn btn-primary" style="cursor:hand;"/></td></tr>
								</table>
								
								
							</div>
					</div>
					</form:form>
					<hr><hr>
					
				</div>
			</div>
			

			 <!-- Tab-1 -->
				<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="equipmentEdit" items="${equipmentEdit}">

						<table>
						<tr>
							<td colspan="4" class="alert-warning" id="equipDuplMessage"
								style="display: none; width: 350px; height: 25px; color: red"></td>
						</tr>
					</table>

					<form:form action="equipmentUpdate.mnt"  method="POST"
						commandName="equipmentCmd" enctype="multipart/form-data" id="editForm">
						<table class="tableGeneral">
							<form:hidden path="eIdEdit" />
							<form:hidden path="equipmentIdEdit" />
							<tr>
								<td><spring:message code="label.equipmentName" /><span
									class="required">*</span></td><td> <form:input path="equipmentNameEdit"
										class="textbox"  onkeyup="AjaxForDuplicate()"/></td>
								<td></td>
								<td></td>
								<td><spring:message code="label.productionCapacity" /><span
									class="required">*</span></td><td> <form:input path="productionCapacityEdit"
										class="textbox" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.equipmentcategory" /><span
									class="required">*</span></td><td> <form:select path="equipmentCategoryIdEdit"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${equipmentCatSelect}" />
									</form:select></td>
								<td></td>
								<td></td>
								<td><spring:message code="label.validFrom" /><span
									class="required">*</span></td><td> <form:input path="validFromEdit"
										class="textbox" id="datepicker1"/></td>

							</tr> 
							<tr>
								<td><spring:message code="label.make" /><span
									class="required">*</span></td><td> <form:input path="makeEdit"
										class="textbox"  /></td>
								<td></td>
								<td></td>
								<td><spring:message code="label.validTo" /><span
									class="required">*</span></td><td> <form:input path="validToEdit"
										class="textbox" id="datepicker2" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.model" /><span
									class="required">*</span></td><td> <form:input path="modelEdit"
										class="textbox" /></td>
									<td></td>
									<td></td>
									<td><spring:message code="label.workInstruction" /><span
									class="required">*</span></td><td> <form:input path="workInstructionEdit"
										class="textbox" /></td>

							</tr>
							<tr>
								<td><spring:message code="label.powerConsumptionInHours" /><span
									class="required">*</span></td><td> <form:input path="powerConsumptionInHoursEdit"
										class="textbox" /></td>

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
