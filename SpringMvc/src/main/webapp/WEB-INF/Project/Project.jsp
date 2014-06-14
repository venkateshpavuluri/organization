<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
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
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>
 <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 

<script type="text/javascript">
$(function() {

	
	
	$("#startDT,#finishDT,#startDTEdit,#finishDTEdit").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true
		
	});
	
});

function numbersonly(myfield, e, dec) {

	var key;
	var keychar;

	if (window.event)
		key = window.event.keyCode;
	else if (e)
		key = e.which;
	else
		return true;
	keychar = String.fromCharCode(key);

	// control keys
	if ((key == null) || (key == 0) || (key == 8) || (key == 9)
			|| (key == 13) || (key == 27))
		return true;

	// numbers
	else if ((("0123456789.").indexOf(keychar) > -1))
		return true;

	// decimal point jump
	/* else if (dec && (keychar == ".")) {
		myfield.form.elements[dec].focus();
		return false;
	}  */
	else
		return false;
}



function doAjaxPost(id) {
	//alert("asd"+id);
	  if(id=='A')
		  {
	var code = $('#projectName').val();
	
		$.ajax({
			type : "POST",
			url : "projectCheck.mnt",
			data : "project=" + code+ "&projectId=0",
			success : function(response) {
				var checkResponse="Warning ! Project aleardy exists. Please try some other no";
				if(response!=0)
				{
				document.getElementById("projectDuplicateMess").style.display="block";
				//$('#projectDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("projectDuplicateMess").style.display="none";
				$('#save').show();
				}
			},
			error : function(e) {
				//alert('Error: ' + e);
			}

		});
		  }
	  if(id=='E')
		  { 
		  
		 
		  
			var codeIdEdit = $('#projectIdEdit').val();
			 var codeEdit = $('#projectNameEdit').val();
			
				$.ajax({
					type : "POST",
					url : "projectCheck.mnt",
					data : "project=" + codeEdit+ "&projectId=" + codeIdEdit,
					success : function(response) {
						//alert("data "+data);
						var checkResponse="Warning ! Project aleardy exists. Please try some other one";
						if(response!=0)
						{
						document.getElementById("projectDuplicateMessEdit").style.display="block";
						//$('#projectDuplicateMessEdit').html(data);
						$('#update').hide();
						}
						else
						{
						document.getElementById("projectDuplicateMessEdit").style.display="none";
						$('#update').show();
						}
					},
					error : function(e) {
						//alert('Error: ' + e);
					}

				});
		  
		  
		  }
	}



$(document).ready(function() {

	
	
	

	
	
	
	$('#save').click(function(event) {   
	
		
	 	$('#projectAdd').validate({ 
			rules : {
				projectName:{required:true,
					alphabets:true,
					specialcharacters:true},
				orgId : {required : true},
				
					
				
				
			},
			messages : {
				projectName :{required:"<font style='color: red;'><b>Project Name is Required</b></font>",
					alphabets:"<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
					specialcharacters:"<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
				},
				orgId : "<font style='color: red;'><b>Organisation is Required</b></font>",
				
				
					
				
			},
			

		}); 
		
	});

	
	
	
	
	$('#update').click(function(event) {
		
		//alert("ss");
	 	$('#projectEditLink').validate({
			rules : {
				
				projectName:{required:true,
					alphabets:true,
					specialcharacters:true},
				orgId : {required : true},
				
				
				
			},
			messages : {
				projectName : {
					
					required:"<font style='color: red;'><b>Project Name is Required</b></font>",
					alphabets:"<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
					specialcharacters:"<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
					
				},
				orgId : "<font style='color: red;'><b>Organisation is Required</b></font>",
				
					
				
			},
			

		}); 
		
	});
	
	
	
}); 

















</script>




<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});

		$('#add').click(function(e) {
			// alert("kiran add");
			$('#edit').hide();
			$('#tabs-1').hide(); 
		
			$('#projectName').val('');
			$('#orgId').val('');
			$('#successmessage').hide();
			$('#savemessage').hide();

		});

		$('#search').click(function(e) {
			$('#edit').hide();
			$('#tabs-1').hide();

		});
	});
</script>
<script>
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs").tabs();
	});

	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs1").tabs();
	});
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs2").tabs();
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
		if (document.getElementById("creditNoteDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
	}); 
	
	/* $(document).ready(function() {
		if (document.getElementById("purchaseAddDuplicateEdit").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-1"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
	}); */
</script> 

<!-- Horizantol scroll -->
<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 100%;
}
</style>

<!-- Horizantol scroll -->
<style type="text/css">
#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 70%;
	align: left;
}
</style>
<script type="text/javascript"> 
 $(function() {
	 if($('#advanceSearchHidden').val()=="1")
		{
		$('#advanceSearchDiv').show();
		$('#advanceSearchButtonId').show();
		$('#mainSearch').hide();
		$('#advanceSearch').hide();
		$('#basicSearch').show();
		} 
    $('#basicSearch').click(function() {
    	$("#advanceSearchHidden").val("0");
    	$('#advanceSearchButtonId').hide();
        $('#mainSearch').show();
        $('#advanceSearchDiv').hide();
        $('#advanceSearch').show();
		$('#basicSearch').hide();
        return false;
    });        
}); 













</script>





</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle"><spring:message code="label.projectNameFor" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="codeEditList" items="${projectEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					
					
					
					<table class="tableGeneral">
					
					<form:form action="projectSearch.mnt" method="GET"
							commandName="projectCommand">
						    
						    <tr>
								<td colspan="2"><c:forEach var="projectAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.project"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.project"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="projectUpdate"
										items="${projectUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.project"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="projectUpdateError"
										items="${projectUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.project"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="projectDelete"
										items="${projectDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.project"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="projectDeleteError"
										items="${projectDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.project"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							
	                        <tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td> <form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="projectCommand.operations">
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
									class="btn btn-primary" value="Search"/></c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							
							</tr> 

						
					</form:form>
									</table>
									
					<c:forEach var="projectList" items="${projectList}">
						<c:set var="project" value="${projectList}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${project!=null }">
							<display:table name="projectList" id="ProjectList" class="table"
								requestURI="projectSearch.mnt" pagesize="5">
							
							
								 <display:column property="projectName" sortable="true"
									titleKey="label.projectName" media="html" />

								 <display:column property="orgId" sortable="true"
									titleKey="label.orgId" media="html" />
									 <display:column property="startDT" sortable="true"
									titleKey="label.StartDate" media="html" />
									 <display:column property="finishDT" sortable="true"
									titleKey="label.finishDate" media="html" />
												
								<display:column titleKey="label.edit">
									<c:choose>
							<c:when test="${edit }">
									<a
										href="projectEdit.mnt?projectId=<c:out value="${ProjectList.projectId}"/> "><img
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
										href="projectDelete.mnt?projectId=<c:out value="${ProjectList.projectId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
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
						</c:when>

						<c:otherwise>

							 <h5><c:out value="Nothing found to display"></c:out></h5>

						</c:otherwise>
					</c:choose>
					
	
				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
						<form:form action="projectAdd.mnt" method="POST"
							commandName="projectCommand" id="projectAdd" >
							<table>
							<form:hidden path="aid" />
					
							
							
								<tr>
									<td>Project Name<span
												class="required">*</span></td>
									<td><form:input path="projectName"
											id="projectName" class="textbox" onkeyup="doAjaxPost('A')" maxlength="50"/>
											</td>
											<td colspan="2" id="projectDuplicateMess" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.projectName" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
											
											</tr>
												<tr>
									<td>Organisation<span
												class="required">*</span></td>
									<td><form:select path="orgId"
											id="orgId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${orgId}" />
											</form:select>
											</td></tr>
											
														<tr>
									<td>Sales Order</td>
									<td><form:select path="salesOrderId"
											id="salesOrderId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${salesOrder}" />
											</form:select>
											</td></tr>
										
										<tr>
										
									<td>Start Date</td>
									<td><form:input path="startDT"
											id="startDT" class="textbox"/>
											</td></tr>
											<tr>
									<td>Finish Date</td>
									<td><form:input path="finishDT"
											id="finishDT" class="textbox" />
											</td></tr>
								<tr>
									<td>Project</td>
									<td><form:select path="parentProject_Id"
											id="parentProject_Id" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${projectId}" />
											</form:select>
											</td></tr>
										<tr>
									<td>Project Manager</td>
									<td><form:select path="projectManager"
											id="projectManager" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${managerId}" />
											</form:select>
											</td></tr>
											
									<tr>
									<td>Status</td>
									<td><form:select path="status_Id"
											id="status_Id" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${statusId}" />
											</form:select>
											</td></tr>
										
										

							</table>


						<c:choose>
									<c:when test="${save}">
				<input type="submit" value="Save" name="Save" id="save" class="btn btn-primary"/></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose><input type="reset" class="btn btn-primary"/>	
			  	     </form:form>
			</div>

</div>
		</div>


<div id="tabs-1" class="TabbedPanelsContent" >
		<div align="left" class="TabbedPanelsContent">
		<form:form action="projectUpdate.mnt" method="POST" commandName="projectCommand" id="projectEditLink" >
			 <c:forEach var="projectEditList" items="${projectEditList}">
			
				
						<table>
								<tr>
									<td>Project Name<span
												class="required">*</span></td>
									<td><form:input path="projectNameEdit"	id="projectNameEdit" class="textbox" onkeyup="doAjaxPost('E')" maxlength="50"/>
											<form:hidden path="projectIdEdit"
											id="projectIdEdit" class="textbox"/></td><td colspan="2" id="projectDuplicateMessEdit" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.projectName" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td></tr>
											<tr>
									<td>Organisation<span
												class="required">*</span></td>
									<td><form:select path="orgidEdit"
											id="orgEdit" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${orgId}" />
											</form:select>
											</td></tr>
											
											
																<tr>
									<td>Sales Order</td>
									<td><form:select path="salesOrderIdEdit"
											id="salesOrderIdEdit" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${salesOrder}" />
											</form:select>
											</td></tr>
										
											
										<tr>
										
										
									<td>Start Date</td>
									<td><form:input path="startDTEdit"
											id="startDTEdit" class="textbox"/>
											</td></tr>
											<tr>
									<td>Finish Date</td>
									<td><form:input path="finishDTEdit"
											id="finishDTEdit" class="textbox" />
											</td></tr>
								<tr>
									<td>Project</td>
									<td><form:select path="parentProject_IdEdit"
											id="parentProject_Id" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${projectId}" />
											</form:select>
											</td></tr>
										<tr>
									<td>Project Manager</td>
									<td><form:select path="projectManagerEdit"
											id="projectManager" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${managerId}" />
											</form:select>
											</td></tr>
										<tr>
									<td>Status</td>
									<td><form:select path="status_IdEdit"
											id="status_Id" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${statusId}" />
											</form:select>
											</td></tr>
										
						<tr>
						

		<c:choose>
										<c:when test="${update}">
						
			<td>	<input type="submit" value="Update" name="update" id="update" class="btn btn-primary"/></td>
									</c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<spring:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
										</c:otherwise>

									</c:choose>
									</tr>
					</table>
</c:forEach> 				
							
</form:form>
					</div>
				
			 
		</div>
	</div>


	</div>
	
	




</body>
</html>











