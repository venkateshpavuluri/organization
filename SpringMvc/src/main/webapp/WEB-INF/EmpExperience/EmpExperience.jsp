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
 <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<script type="text/javascript" src="js/MntValidator.js"></script>
	<script type="text/javascript">
function dateFun(datePattern) {
	$('#fromDT,#todate,#fromDTEdit,#todateEdit').datepicker({
			dateFormat : datePattern,
			changeMonth : true,
			changeYear : true
});
}
</script>
<script type="text/javascript">

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
	
	var employee_Id = $('#employee_Id').val();
	var company = $('#company').val();
	var designation_Id = $('#designation_Id').val();
	//alert("sdf");
	if(employee_Id!="0" && company!="" && designation_Id!=0)
		{
	$.ajax({
			type : "POST",
			url : "empExperienceCheck.mnt",
			data : "employee_Id=" + employee_Id+ "&empExperienceId=0&company="+company+"&designation_Id="+designation_Id,
			success : function(data) {

				var checkResponse="Warning ! Employee Experience aleardy exists.";
				if(checkResponse==data)
				{
				document.getElementById("empExperienceDuplicateMess").style.display="block";
				$('#empExperienceDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("empExperienceDuplicateMess").style.display="none";
				$('#save').show();
				}
			},
			error : function(e) {
				//alert('Error: ' + e);
			}

		});
		  }
		  }
	  if(id=='E')
		  { 
		  
		 
		  var employee_Id = $('#employee_IdEdit').val();
			var company = $('#companyEdit').val();
			var designation_Id = $('#designation_IdEdit').val();
			var experience_Id = $('#experience_Id').val();
			if(employee_Id!="0" && company!="" && designation_Id!=0)
			{
				$.ajax({
					type : "POST",
					url : "empExperienceCheck.mnt",
					data : "employee_Id=" + employee_Id+ "&empExperienceId="+experience_Id+"&company="+company+"&designation_Id="+designation_Id,
					success : function(data) {
					//alert("data "+data);
						var checkResponse="Warning ! Employee Experience aleardy exists. Please try some other one";
						if(checkResponse==data)
						{
						document.getElementById("empExperienceDuplicateMessEdit").style.display="block";
						$('#empExperienceDuplicateMessEdit').html(data);
						$('#update').hide();
						}
						else
						{
						document.getElementById("empExperienceDuplicateMessEdit").style.display="none";
						$('#update').show();
						}
					},
					error : function(e) {
						//alert('Error: ' + e);
					}

				});
			}
		  
		  
		  }
	}



$(document).ready(function() {

	
	
	

	
	
	
	$('#save').click(function(event) {   
	
		
	 	$('#empAdd').validate({ 
			rules : {
				
				 employee_Id:{required:true},
				 fromDT:{required:true},
				 todate:{required:true},
				 designation_Id:{required:true},
				 company:{required:true},
				 compPhone:{required:true},
				 referenceName:{required:true},
				 redDesigntion_Id:{required:true},
				 email:{required:true}
				
					
				
				
			},
			messages : {
			
				 employee_Id: "<font style='color: red;'><b>Employee is Required</b></font>",
				 fromDT: "<font style='color: red;'><b>From Date is Required</b></font>",
				 todate: "<font style='color: red;'><b>To date is Required</b></font>",
				 designation_Id: "<font style='color: red;'><b>Designation is Required</b></font>",
				 company: "<font style='color: red;'><b>Company is Required</b></font>",
				 compPhone: "<font style='color: red;'><b>Company Phone is Required</b></font>",
				 referenceName: "<font style='color: red;'><b>Reference Name is Required</b></font>",
				 redDesigntion_Id: "<font style='color: red;'><b>Red Designtion is Required</b></font>",
				 email: "<font style='color: red;'><b>Email is Required</b></font>"
				
				
					
				
			},
			

		}); 
		
	});

	
	
	
	
	$('#update').click(function(event) {
		
		//alert("ss");
	 	$('#empEditLink').validate({
			rules : {
				
				 employee_Id:{required:true},
				 fromDT:{required:true},
				 todate:{required:true},
				 designation_Id:{required:true},
				 company:{required:true},
				 compPhone:{required:true},
				 referenceName:{required:true},
				 redDesigntion_Id:{required:true},
				 email:{required:true}
				
					
				
				
			},
			messages : {
			
				 employee_Id: "<font style='color: red;'><b>Employee is Required</b></font>",
				 fromDT: "<font style='color: red;'><b>From Date is Required</b></font>",
				 todate: "<font style='color: red;'><b>To date is Required</b></font>",
				 designation_Id: "<font style='color: red;'><b>Designation is Required</b></font>",
				 company: "<font style='color: red;'><b>Company is Required</b></font>",
				 compPhone: "<font style='color: red;'><b>Company Phone is Required</b></font>",
				 referenceName: "<font style='color: red;'><b>Reference Name is Required</b></font>",
				 redDesigntion_Id: "<font style='color: red;'><b>Red Designtion is Required</b></font>",
				 email: "<font style='color: red;'><b>Email is Required</b></font>"
				
				
					
				
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
		
			$('#coa').val('');
			$('#orgId').val(0);
			$('#employee_Id').val('');
			$('#fromDT').val('');
			$('#todate').val('');
			$('#designation_Id').val('');
					$('#company').val('');
							$('#compPhone').val('');
									$('#referenceName').val('');
											$('#redDesigntion_Id').val('');
													$('#email').val('');
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
		<div class="PageTitle"><spring:message code="label.empExperience" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="codeEditList" items="${empExperienceEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					
					
					
					<table class="tableGeneral">
					
					<form:form action="empExperienceSearch.mnt" method="GET"
							commandName="empExperienceCommand">
							
							
							<tr>
								<td colspan="2"><c:forEach var="empExpAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empExperience"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.empExperience"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="empExpUpdate"
										items="${empExpUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empExperience"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="empExpUpdateError"
										items="${empExpUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.empExperience"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="empExpDelete"
										items="${empExpDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.empExperience"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="empExpDeleteError"
										items="${empExpDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.empExperience"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
	                        <tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td> <form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="empExperienceCommand.operations">
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
										<c:when test="${true}">
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
					
					<c:forEach var="empExperienceList" items="${empExperienceList}">
						<c:set var="empExperience" value="${empExperienceList}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${empExperience!=null }">
						
							<display:table name="empExperienceList" id="EmpExperienceList" class="table"
								requestURI="empExperienceSearch.mnt" pagesize="5">
							
							
												
								 <display:column property="employee_Id" sortable="true"
																titleKey="label.employee_Id" media="html" />
							     <display:column property="fromDT" sortable="true"
																titleKey="label.fromDT" media="html" />
							     <display:column property="todate" sortable="true"
																titleKey="label.todate" media="html" />
							     <display:column property="designation_Id" sortable="true"
																titleKey="label.designation_Id" media="html" />
							     <display:column property="company" sortable="true"
																titleKey="label.company" media="html" />
							     <display:column property="compPhone" sortable="true"
																titleKey="label.compPhone" media="html" />
							     <display:column property="referenceName" sortable="true"
																titleKey="label.referenceName" media="html" />
							     <display:column property="redDesigntion_Id" sortable="true"
																titleKey="label.redDesigntion_Id" media="html" />
							     <display:column property="email" sortable="true"
																titleKey="label.email" media="html" />
								
								<display:column titleKey="label.edit">
								<c:choose>
							<c:when test="${true }">
									<a
										href="empExperienceEdit.mnt?experience_Id=<c:out value="${EmpExperienceList.experience_Id}"/> "><img
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
							<c:when test="${true }">
									<a
										href="empExperienceDelete.mnt?experience_Id=<c:out value="${EmpExperienceList.experience_Id}"/> "
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
						<form:form action="empExperienceAdd.mnt" method="POST"
					commandName="empExperienceCommand" id="empAdd" >
							<table>
							
							
							<tr>
								<td colspan="2"><form:hidden
										path="duplicate" /> 	
										<div class="alert-warning" id="empExperienceDuplicateMess" style="display: none;"></div>
										</td>
							</tr>
							
							
								<tr>
									<td>Employee<span
												class="required">*</span></td>
									<td>
									<form:select path="employee_Id"
											id="employee_Id" class="select" onchange="doAjaxPost('A')" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${employee_Id}" />
											</form:select>
									
									
											</td></tr>
											<tr>
									<td>From Date<span
												class="required">*</span></td>
									<td><form:input path="fromDT"
											id="fromDT" class="textbox" />
											</td></tr>
											
											<tr>
									<td>To Date<span
												class="required">*</span></td>
									<td><form:input path="todate"
											id="todate" class="textbox" />
											</td></tr>
											<tr>
									<td>Designation<span
												class="required">*</span></td>
									<td>
									<form:select path="designation_Id"
											id="designation_Id" class="select" onchange="doAjaxPost('A')" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${designation_Id}" />
											</form:select>
									
											</td></tr>
											<tr>
									<td>Company<span
												class="required">*</span></td>
									<td><form:input path="company"
											id="company" class="textbox" onkeyup="doAjaxPost('A')" />
											</td></tr>
											<tr>
									<td>Company Phone<span
												class="required">*</span></td>
									<td><form:input path="compPhone"
											id="compPhone" class="textbox" />
											</td></tr>
											<tr>
									<td>Reference Name<span
												class="required">*</span></td>
									<td><form:input path="referenceName"
											id="referenceName" class="textbox" />
											</td></tr>
											<tr>
									<td>Red Designtion<span
												class="required">*</span></td>
									<td>
									<form:select path="redDesigntion_Id"
											id="redDesigntion_Id" class="select" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${redDesigntion_Id}" />
											</form:select></td>
									</tr>
													<tr>
									<td>Email<span
												class="required">*</span></td>
									<td><form:input path="email"
											id="email" class="textbox" />
											</td></tr>
								
												
	</table>

				<c:choose>
									<c:when test="${true}">
						
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


<div id="tabs-1" class="TabbedPanelsContent" >
		<div align="left" class="TabbedPanelsContent">
		<form:form action="empExperienceUpdate.mnt" method="POST" commandName="empExperienceCommand" id="empEditLink" >
			 <c:forEach var="empExperienceEditList" items="${empExperienceEditList}">
			
				
						<table>
							
							
							<tr>
								<td colspan="4">	
										<div class="alert-warning" id="empExperienceDuplicateMessEdit" style="display: none;"></div>
										</td>
							</tr>
							
							
							
								<tr>
									<td>Employee<span
												class="required">*</span></td>
									<td><form:hidden path="experience_Id"
											id="experience_Id" class="textbox" />
									<form:select path="employee_Id"
											id="employee_IdEdit" class="select" onchange="doAjaxPost('E')" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${employee_Id}" />
											</form:select>
									
									
											</td></tr>
											<tr>
									<td>From Date <span
												class="required">*</span></td>
									<td><form:input path="fromDT"
											id="fromDTEdit" class="textbox" />
											</td></tr>
											
											<tr>
									<td>To Date<span
												class="required">*</span></td>
									<td><form:input path="todate"
											id="todateEdit" class="textbox" />
											</td></tr>
											<tr>
									<td>Designation<span
												class="required">*</span></td>
									<td>
									<form:select path="designation_Id"
											id="designation_IdEdit" class="select" onchange="doAjaxPost('E')" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${designation_Id}" />
											</form:select>
									
											</td></tr>
											<tr>
									<td>Company<span
												class="required">*</span></td>
									<td><form:input path="company"
											id="companyEdit" class="textbox" onkeyup="doAjaxPost('E')" />
											</td></tr>
											<tr>
									<td>Company Phone<span
												class="required">*</span></td>
									<td><form:input path="compPhone"
											id="compPhone" class="textbox" />
											</td></tr>
											<tr>
									<td>Reference Name<span
												class="required">*</span></td>
									<td><form:input path="referenceName"
											id="referenceName" class="textbox" />
											</td></tr>
											<tr>
									<td>Red Designtion<span
												class="required">*</span></td>
									<td>
									<form:select path="redDesigntion_Id"
											id="redDesigntion_Id" class="select" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${redDesigntion_Id}" />
											</form:select></td>
									</tr>
													<tr>
									<td>Email<span
												class="required">*</span></td>
									<td><form:input path="email"
											id="email" class="textbox" />
											</td></tr>
										
							</table>





							<c:choose>
										<c:when test="${true}">
							
						
				<input type="submit" value="Update" name="update" id="update" class="btn btn-primary"/></c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<spring:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
										</c:otherwise>

									</c:choose>
					
					
					
					
					
					
					
					
					
					
					
					
					
						
					
					
					
					
						
						
						
					
</c:forEach> 
</form:form>
					</div>
				
			 
		</div>
	</div>


	</div>
	
	




</body>
</html>











