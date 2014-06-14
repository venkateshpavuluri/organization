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
$(function() {

	
	
	$("#startDate,#endDate,#reportingDate,#startDateEdit,#endDateEdit,#reportingDateEdit,#basicSearchId").datepicker({
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
	var startDate = $('#startDate').val();
	//alert("sdf"+purchaseOrderNo);
		$.ajax({
			type : "POST",
			url : "employeeLeaveCheck.mnt", 
			data : "employeeLeave=" + startDate+ "&employeeLeaveId=0",
			success : function(data) {
			//	alert("data"+data);
				var checkResponse="Warning ! EmployeeLeave aleardy exists. Please try some other no";
				if(checkResponse==data)
				{
				document.getElementById("employeeLeaveDuplicateMess").style.display="block";
				$('#employeeLeaveDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("employeeLeaveDuplicateMess").style.display="none";
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
		  
		 
		  
			var employeeLeaveId = $('#employeeLeaveId').val();
			 var startDate = $('#startDateEdit').val();
			
				$.ajax({
					type : "POST",
					url : "employeeLeaveCheck.mnt",
					data : "employeeLeave=" + startDate+ "&employeeLeaveId="+employeeLeaveId,
					success : function(data) {
						//alert("data "+data);
						var checkResponse="Warning ! EmployeeLeave aleardy exists. Please try some other no";
						if(checkResponse==data)
						{
						document.getElementById("employeeLeaveDuplicateMessEdit").style.display="block";
						$('#employeeLeaveDuplicateMessEdit').html(data);
						$('#update').hide();
						}
						else
						{
						document.getElementById("employeeLeaveDuplicateMessEdit").style.display="none";
						$('#update').show();
						}
					},
					error : function(e) {
						//alert('Error: ' + e);
					}

				});
		  
		  
		  }
	}
	
	
	function change()
	{
		if($('#recursiveHalf').val()==0)
		{
		$('#eDayPart').val(1);
		$('#sDayPart').val(1);
		}
		else
			{
			$('#eDayPart').val(0);
			$('#sDayPart').val(0);
			}
		
		if($('#recursiveHalfEdit').val()==0)
		{
		$('#eDayPartEdit').val(1);
		$('#sDayPartEdit').val(1);
		}
		else
			{
			$('#eDayPartEdit').val(0);
			$('#sDayPartEdit').val(0);
			}
	}



$(document).ready(function() {
	

	
	jQuery.validator.addMethod("alphaNumeric", function (value, element) {
        return this.optional(element) || /^[a-zA-Z][a-zA-Z0-9&_]*$/.test(value);
    });
	
	/* jQuery.validator.addMethod("emailWithComma", function (value, element) {
        return this.optional(element) || /^[a-zA-Z][@][a-zA-Z][.][a-zA-Z,]*$/.test(value);
    }); */
	
	jQuery.validator.addMethod("Numeric", function (value, element) {
        return this.optional(element) || /^[0-9]*$/.test(value);
    });
	
    jQuery.validator.addMethod("decimal", function (value, element) {
        return this.optional(element) || /^[0-9][.][0-9]*$/.test(value);
    });
	
	$('#save').click(function(event) {   
	
		
	 	$('#employeeLeaveAdd').validate({ 
			rules : {
			
				employeeId:{required:true},
				leaveTypeId:{required:true},
				reptMgrId:{required:true},
				noOfAvailableCL:{required:true},
				noOfAvailableCFL:{required:true},
				startDate:{required:true,minlength: 10},
				sDayPart:{required:true},
				endDate:{required:true,minlength: 10},
				eDayPart:{required:true},
				reportingDate:{required:true,minlength: 10},
				reason:{required:true,alphaNumeric:true,},
				mobile:{required:true,Numeric:true,minlength: 10,maxlength: 13},
				residence:{required:true},
				otherNo:{required:true,Numeric:true,minlength: 10,maxlength: 13},
				statusId:{required:true},
				declineReason:{required:true},
				emailCCList:{required:true},
				days:{required:true},
				
			},
			messages : {
		
				employeeId: "<font style='color: red;'><b>Employee is Required</b></font>",
				leaveTypeId: "<font style='color: red;'><b>Leave Type is Required</b></font>",
				reptMgrId: "<font style='color: red;'><b>Repected Manager is Required</b></font>",
				noOfAvailableCL: "<font style='color: red;'><b>No Of Available Causal Leaves is Required</b></font>",
				noOfAvailableCFL: "<font style='color: red;'><b>No Of Available Causal F Leaves is Required</b></font>",
				startDate: 
					{
					required:"<font style='color: red;'><b>Start Date is Required</b></font>",
					minlength: "<font style='color: red;'><b>Start Date is Required Eg: 2014-02-13</b></font>",
					},
				sDayPart: "<font style='color: red;'><b>Start Day Part is Required</b></font>",
				endDate: 
				{
					required:"<font style='color: red;'><b>End Date is Required</b></font>",
					minlength: "<font style='color: red;'><b>End Date is Required Eg: 2014-02-13</b></font>",
					},
					
					
				eDayPart: "<font style='color: red;'><b>End Day Part is Required</b></font>",
				reportingDate:
				{
					required:"<font style='color: red;'><b>Reporting Date is Required</b></font>",
					minlength: "<font style='color: red;'><b>Reporting Date is Required Eg: 2014-02-13</b></font>",
					},
					
					
				reason: "<font style='color: red;'><b>Reason is Required</b></font>",
				mobile: 
				{
					required:"<font style='color: red;'><b>Mobile is Required</b></font>",
					Numeric: "<font style='color: red;'><b>Accepts only Number</b></font>",
					minlength: "<font style='color: red;'><b>Mobile Number Should have 10 digits Minimum</b></font>",
					maxlength: "<font style='color: red;'><b>Mobile Number Should have 13 digits Maximum including +91</b></font>",
					},
					
					
			residence: "<font style='color: red;'><b>Residence is Required</b></font>",
		
				otherNo: 
				{
					required: "<font style='color: red;'><b>Other No is Required</b></font>",
					Numeric: "<font style='color: red;'><b>Accepts only digits</b></font>",
					minlength: "<font style='color: red;'><b>Other Number Should have 10 digits Minimum</b></font>",
					maxlength: "<font style='color: red;'><b>Other Number Should have 13 digits Maximum including +91</b></font>",
					},
				statusId: "<font style='color: red;'><b>Status is Required</b></font>",
				declineReason: 
				{
					required:"<font style='color: red;'><b>Decline Reason is Required</b></font>",
					
					},
					
				emailCCList: 
				{
					required:"<font style='color: red;'><b>Email CC List is Required</b></font>",
					//emailWithComma: "<font style='color: red;'><b>give correct syntaxEmail </b></font>",
					},
					
					
				days: 
				{
					required:"<font style='color: red;'><b>Days is Required</b></font>",
					decimal: "<font style='color: red;'><b>Accepts only Decimal</b></font>",
					},
				
					
				
			},
			

		}); 
	 	
	 	
	 
	 	
		
	});

	
	
	
	
	$('#update').click(function(event) {
		
		//alert("ss");
	 	$('#employeeLeaveEditLink').validate({ 
			rules : {
				
				employeeId:{required:true},
				leaveTypeId:{required:true},
				reptMgrId:{required:true},
				noOfAvailableCL:{required:true},
				noOfAvailableCFL:{required:true},
				startDate:{required:true,minlength: 10},
				sDayPart:{required:true},
				endDate:{required:true,minlength: 10},
				eDayPart:{required:true},
				reportingDate:{required:true,minlength: 10},
				reason:{required:true,alphaNumeric:true,},
				mobile:{required:true,Numeric:true,minlength: 10,maxlength: 13},
				residence:{required:true},
				otherNo:{required:true,Numeric:true,minlength: 10,maxlength: 13},
				statusId:{required:true},
				declineReason:{required:true},
				emailCCList:{required:true},
				days:{required:true,decimal:true,},

				
					
				
				
			},
			messages : {
		
				employeeId: "<font style='color: red;'><b>Employee is Required</b></font>",
				leaveTypeId: "<font style='color: red;'><b>Leave Type is Required</b></font>",
				reptMgrId: "<font style='color: red;'><b>Repected Manager is Required</b></font>",
				noOfAvailableCL: "<font style='color: red;'><b>No Of Available Causal Leaves is Required</b></font>",
				noOfAvailableCFL: "<font style='color: red;'><b>No Of Available Causal F Leaves is Required</b></font>",
				startDate: 
					{
					required:"<font style='color: red;'><b>Start Date is Required</b></font>",
					minlength: "<font style='color: red;'><b>Start Date is Required Eg: 2014-02-13</b></font>",
					},
				sDayPart: "<font style='color: red;'><b>Start Day Part is Required</b></font>",
				endDate: 
				{
					required:"<font style='color: red;'><b>End Date is Required</b></font>",
					minlength: "<font style='color: red;'><b>End Date is Required Eg: 2014-02-13</b></font>",
					},
					
					
				eDayPart: "<font style='color: red;'><b>End Day Part is Required</b></font>",
				reportingDate:
				{
					required:"<font style='color: red;'><b>Reporting Date is Required</b></font>",
					minlength: "<font style='color: red;'><b>Reporting Date is Required Eg: 2014-02-13</b></font>",
					},
					
					
				reason: "<font style='color: red;'><b>Reason is Required</b></font>",
				mobile: 
				{
					required:"<font style='color: red;'><b>Mobile is Required</b></font>",
					Numeric: "<font style='color: red;'><b>Accepts only Number</b></font>",
					minlength: "<font style='color: red;'><b>Mobile Number Should have 10 digits Minimum</b></font>",
					maxlength: "<font style='color: red;'><b>Mobile Number Should have 13 digits Maximum including +91</b></font>",
					},
					
					
			residence: "<font style='color: red;'><b>Residence is Required</b></font>",
		
				otherNo: 
				{
					required: "<font style='color: red;'><b>Other No is Required</b></font>",
					Numeric: "<font style='color: red;'><b>Accepts only digits</b></font>",
					minlength: "<font style='color: red;'><b>Other Number Should have 10 digits Minimum</b></font>",
					maxlength: "<font style='color: red;'><b>Other Number Should have 13 digits Maximum including +91</b></font>",
					},
				statusId: "<font style='color: red;'><b>Status is Required</b></font>",
				declineReason: 
				{
					required:"<font style='color: red;'><b>Decline Reason is Required</b></font>",
					
					},
					
				emailCCList: 
				{
					required:"<font style='color: red;'><b>Email CC List is Required</b></font>",
					//emailWithComma: "<font style='color: red;'><b>give correct syntaxEmail </b></font>",
					},
					
					
				days: 
				{
					required:"<font style='color: red;'><b>Days is Required</b></font>",
					decimal: "<font style='color: red;'><b>Accepts only Decimal</b></font>",
					},
				
					
				
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
		

			$('#employeeId').val('');
			$('#leaveTypeId').val('');
			$('#reptMgrId').val('');
			$('#noOfAvailableCL').val('');
			$('#noOfAvailableCFL').val('');
			$('#startDate').val('');
			$('#sDayPart').val('');
			$('#endDate').val('');
			$('#eDayPart').val('');
			$('#recursiveHalf').val(1);
			$('#reportingDate').val('');
			$('#reason').val('');
			$('#mobile').val('');
			$('#residence').val('');
			$('#otherNo').val('');
			$('#statusId').val(1);
			$('#declineReason').val('');
			$('#emailCCList').val('');
			$('#days').val('');

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
		<div class="PageTitle"><spring:message code="label.EmployeeLeave" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="employeeLeaveEditList" items="${employeeLeaveEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					
					
					
					<table class="tableGeneral">
					
					<form:form action="employeeLeaveSearch.mnt" method="GET"
							commandName="employeeLeaveCommand">
						  <tr>
								<td colspan="2"><c:forEach var="empLeaveAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.EmployeeLeave"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.EmployeeLeave"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="empLeaveUpdate"
										items="${empLeaveUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.EmployeeLeave"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="empLeaveUpdateError"
										items="${empLeaveUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.EmployeeLeave"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="empLeaveDelete"
										items="${empLeaveDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.EmployeeLeave"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="empLeaveDeleteError"
										items="${empLeaveDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.EmployeeLeave"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
						  

							
							
							
	                        <tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td> <form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="employeeLeaveCommand.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind>  <form:input path="basicSearchId" cssClass="textbox" id="basicSearchId" /></td>
								<td><input type="submit" 
									class="btn btn-primary" value="Search"/></td>
							</tr> 

						
					</form:form>
					
					</table>
					
					
					<c:forEach var="employeeLeaveList" items="${employeeLeaveList}">
						<c:set var="employeeLeave" value="${employeeLeaveList}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${employeeLeave!=null }">
						
						
						
					
							<display:table name="employeeLeaveList" id="EmployeeLeaveList" class="table"
								requestURI="employeeLeaveSearch.mnt" pagesize="5">
							
							
								 <display:column property="employeeId" 
									titleKey="label.employeeId" media="html" />


								 
								  <display:column property="leaveTypeId" 
									titleKey="label.leaveTypeId" media="html" />
								 
								 
								  <display:column property="reptMgrId" 
									titleKey="label.reptMgrId" media="html" />
								  
								 
								  <display:column property="startDate" 
									titleKey="label.startDate" media="html" />
									
									
									 <display:column property="endDate" 
									titleKey="label.endDate" media="html" />
								
								<display:column titleKey="label.edit">
									<a
										href="employeeLeaveEdit.mnt?employeeLeaveId=<c:out value="${EmployeeLeaveList.employeeLeaveId}"/> "><img
										src="images/Edit.jpg" width="20px" height="20px" /></a>
								</display:column>
								<display:column titleKey="label.delete">
									<a
										href="employeeLeaveDelete.mnt?employeeLeaveId=<c:out value="${EmployeeLeaveList.employeeLeaveId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" /> 

							</display:table>
						</c:when>

						
					</c:choose>	
					
				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
						<form:form action="employeeLeaveAdd.mnt" method="GET"
					commandName="employeeLeaveCommand" id="employeeLeaveAdd" >
							<table>
							
							
							<tr>
								<td colspan="2" height="35px"><%-- <form:hidden
										path="employeeLeaveDuplicate" /> --%> 	
										<div class="alert-warning" id="employeeLeaveDuplicateMess" style="display: none;"></div>
										</td>
							</tr>
							
							
							
								<tr>
									<td>Employee<span 
												class="required">*</span></td>
									<td><form:select path="employeeId"
											id="employeeId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${employeeIdDetails}" />
											</form:select></td>
									<td>Leave Type<span
												class="required">*</span></td>
									<td><form:select path="leaveTypeId"
											id="leaveTypeId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${leaveTypeIdDetails}" />
											</form:select></td></tr>
											
														
											
									<tr>
									<td>Respective Manager<span
												class="required">*</span></td>
									<td><form:select path="reptMgrId"
											id="reptMgrId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${reptMgrIdDetails}" />
											</form:select></td>
											
											
									
											
										 <td>Recursive Half</td>
									<td><form:select path="recursiveHalf"
											id="recursiveHalf" class="select" onchange="change()">
											<form:option value="2">-Select-</form:option>
											<form:option value="1">NO</form:option>
											<form:option value="0">YES</form:option>
											
											</form:select>
									</td> 
									</tr>	
    
    
    
    
      								<tr>
      								
      								
      								<td>No Of Available Casual Leave<span
												class="required">*</span></td>
									<td><form:select path="noOfAvailableCL"
											id="noOfAvailableCL" class="select" >
											 <option value="0.0">0.0</option>
									        <option value="0.5">0.5</option>
									        <option value="1.0">1.0</option>
									        <option value="1.5">1.5</option>
									        <option value="2.0">2.0</option>
									        <option value="2.5">2.5</option>
									        <option value="3.0">3.0</option>
									        <option value="3.5">3.5</option>
									        <option value="4.0">4.0</option>
									        <option value="4.5">4.5</option>
									        <option value="5.0">5.0</option>
									        <option value="5.5">5.5</option>
									        <option value="6.0">6.0</option>
									        </form:select>
									</td>
									
									
									<td>No Of Available Compoff Leave<span
												class="required">*</span></td>
									<td><form:select path="noOfAvailableCFL"
											id="noOfAvailableCFL" class="select">
											 <option value="0.0">0.0</option>
									        <option value="0.5">0.5</option>
									        <option value="1.0">1.0</option>
									        <option value="1.5">1.5</option>
									        <option value="2.0">2.0</option>
									        <option value="2.5">2.5</option>
									        <option value="3.0">3.0</option>
									        <option value="3.5">3.5</option>
									        <option value="4.0">4.0</option>
									        <option value="4.5">4.5</option>
									        <option value="5.0">5.0</option>
									        <option value="5.5">5.5</option>
									        <option value="6.0">6.0</option>
											</form:select>
									</td>
									
									
									</tr>	
      
      
      
      
     								 <tr>
     								 
     								 <td>Start Date<span
												class="required">*</span></td>
									<td><form:input path="startDate"
											id="startDate" class="textbox" onchange="doAjaxPost('A')"/>
									</td>
									<td>Start Day Part</td>
									<td><form:select path="sDayPart"
											id="sDayPart" class="select">
											 <option value="">SELECT</option>
											 <option value="1.00">AM</option>
        									<option value="2.00">PM</option>
        									</form:select>
									</td>
									
									
									
									
									</tr>	
									
      
      
      
     								 <tr>
     								 
     								 <td>End Date<span
												class="required">*</span></td>
									<td><form:input path="endDate"
											id="endDate" class="textbox" />
									</td>
									
									
									<td>End Day Part</td>
									<td><form:select path="eDayPart"
											id="eDayPart" class="select">
											<option value="">SELECT</option>
											 <option value="1">AM</option>
        									<option value="2">PM</option>
        									</form:select>
									</td>
									
									</tr>
									
									
										
      
     								 <tr>
     								 
     								 <td>Days<span
												class="required">*</span></td>
									<td><form:input path="days"
											id="days" class="textbox"/>
									</td>
									
										<td>Reporting Date<span
												class="required">*</span></td>
									<td><form:input path="reportingDate"
											id="reportingDate" class="textbox"/>
									</td>
									

									
									</tr>	
      
     										 <tr>
     										 
     										 <td>Reason<span
												class="required">*</span></td>
									<td><form:input path="reason"
											id="reason" class="textbox"/>
									</td>
     										 
									<td>Mobile No<span
												class="required">*</span></td>
									<td><form:input path="mobile"
											id="mobile" class="textbox" maxlength="15"/>
									</td>
									
									
									</tr>	
      
      
      
     									 <tr>
     									 
     									 <td>Other No<span
												class="required">*</span></td>
									<td><form:input path="otherNo"
											id="otherNo" class="textbox" maxlength="15"/>
									</td>
									<td>Residence<span
												class="required">*</span></td>
									<td><form:input path="residence"
											id="residence" class="textbox"/>
									</td>
								
								
									</tr>	
      
    								  <tr>
									<td>Decline Reason<span
												class="required">*</span></td>
									<td><form:input path="declineReason"
											id="declineReason" class="textbox"/>
									</td>
									
										<td>Status<span
												class="required">*</span></td>
									<td><form:select path="statusId"
											id="statusId" class="select">
											 <form:option value="0">-Select-</form:option>
											<form:options items="${status }" />
										</form:select>
										
										
										
									</td>
									
									</tr>	
      			
    									  <tr>
									<td>Email CC List<span
												class="required">*</span></td>
									<td><form:textarea path="emailCCList"
											id="emailCCList" class="textbox"/>
									</td>
									</tr>	
												
												
										
										
								

							</table>


						
				<input type="submit" value="Save" name="Save" id="save" class="btn btn-primary"/><input type="reset" class="btn btn-primary"/>	
			  	     </form:form>
			</div>


		</div>


<div id="tabs-1" class="TabbedPanelsContent" >
		<div align="left" class="TabbedPanelsContent">
		<form:form action="employeeLeaveUpdate.mnt" method="POST" commandName="employeeLeaveCommand" id="employeeLeaveEditLink" >
			 <c:forEach var="employeeLeaveEditList" items="${employeeLeaveEditList}">
			
				
						<table>
							
							
							<tr>
								<td colspan="4" height="35px">	
										<div class="alert-warning" id="employeeLeaveDuplicateMessEdit" style="display: none;"></div>
										</td>
							</tr>
							
							
								<tr>
									<td>Employee<span 
												class="required">*</span></td>
									<td><form:hidden path="employeeLeaveId"
											id="employeeLeaveId" class="textbox"/>
											
											
											<form:select path="employeeId"
											id="employeeId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${employeeIdDetails}" />
											</form:select></td>
									<td>Leave Type<span
												class="required">*</span></td>
									<td><form:select path="leaveTypeId"
											id="leaveTypeId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${leaveTypeIdDetails}" />
											</form:select></td></tr>
											
														
											
									<tr>
									<td>Respective Manager<span
												class="required">*</span></td>
									<td><form:select path="reptMgrId"
											id="reptMgrId" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${reptMgrIdDetails}" />
											</form:select></td>
											
											
									
											
										 <td>Recursive Half</td>
									<td><form:select path="recursiveHalf"
											id="recursiveHalfEdit" class="select" onchange="change()">
											<form:option value="2">-Select-</form:option>
											<form:option value="1">NO</form:option>
											<form:option value="0">YES</form:option>
											
											</form:select>
									</td> 
									</tr>	
    
    
    
    
      								<tr>
      								
      								
      								<td>No Of Available Casual Leave<span
												class="required">*</span></td>
									<td><form:select path="noOfAvailableCL"
											id="noOfAvailableCL" class="select" >
											 <option value="0.0">0.0</option>
									        <option value="0.5">0.5</option>
									        <option value="1.0">1.0</option>
									        <option value="1.5">1.5</option>
									        <option value="2.0">2.0</option>
									        <option value="2.5">2.5</option>
									        <option value="3.0">3.0</option>
									        <option value="3.5">3.5</option>
									        <option value="4.0">4.0</option>
									        <option value="4.5">4.5</option>
									        <option value="5.0">5.0</option>
									        <option value="5.5">5.5</option>
									        <option value="6.0">6.0</option>
									        </form:select>
									</td>
									
									
									<td>No Of Available Compoff Leave<span
												class="required">*</span></td>
									<td><form:select path="noOfAvailableCFL"
											id="noOfAvailableCFL" class="select">
											 <option value="0.0">0.0</option>
									        <option value="0.5">0.5</option>
									        <option value="1.0">1.0</option>
									        <option value="1.5">1.5</option>
									        <option value="2.0">2.0</option>
									        <option value="2.5">2.5</option>
									        <option value="3.0">3.0</option>
									        <option value="3.5">3.5</option>
									        <option value="4.0">4.0</option>
									        <option value="4.5">4.5</option>
									        <option value="5.0">5.0</option>
									        <option value="5.5">5.5</option>
									        <option value="6.0">6.0</option>
											</form:select>
									</td>
									
									
									</tr>	
      
      
      
      
     								 <tr>
     								 
     								 <td>Start Date<span
												class="required">*</span></td>
									<td><form:input path="startDate"
											id="startDateEdit" class="textbox" onchange="doAjaxPost('E')"/>
									</td>
									<td>Start Day Part</td>
									
									<td><form:select path="noOfAvailableCFL"
											id="noOfAvailableCFL" class="select">
											 <option value="0.0">0.0</option>
									        <option value="0.5">0.5</option>
									        <option value="1.0">1.0</option>
									        <option value="1.5">1.5</option>
									        <option value="2.0">2.0</option>
									        <option value="2.5">2.5</option>
									        <option value="3.0">3.0</option>
									        <option value="3.5">3.5</option>
									        <option value="4.0">4.0</option>
									        <option value="4.5">4.5</option>
									        <option value="5.0">5.0</option>
									        <option value="5.5">5.5</option>
									        <option value="6.0">6.0</option>
											</form:select>
									</td>
									<td><form:select path="sDayPart"
											id="sDayPartEditEdit" class="select">
											 <option value="">SELECT</option>
											 <option value="1.00">AM</option>
        									<option value="2.00">PM</option>
        									</form:select>
									</td>
									
									
									
									
									</tr>	
									
      
      
      
     								 <tr>
     								 
     								 <td>End Date<span
												class="required">*</span></td>
									<td><form:input path="endDate"
											id="endDateEdit" class="textbox" />
									</td>
									
									
									<td>End Day Part</td>
									<td><form:select path="eDayPart"
											id="eDayPartEdit" class="select">
											<option value="">SELECT</option>
											 <option value="1.00">AM</option>
        									<option value="2.00">PM</option>
        									</form:select>
									</td>
									
									</tr>
									
									
										
      
     								 <tr>
     								 
     								 <td>Days<span
												class="required">*</span></td>
									<td><form:input path="days"
											id="days" class="textbox"/>
									</td>
									
										<td>Reporting Date<span
												class="required">*</span></td>
									<td><form:input path="reportingDate"
											id="reportingDateEdit" class="textbox"/>
									</td>
									

									
									</tr>	
      
     										 <tr>
     										 
     										 <td>Reason<span
												class="required">*</span></td>
									<td><form:input path="reason"
											id="reason" class="textbox"/>
									</td>
     										 
									<td>Mobile No<span
												class="required">*</span></td>
									<td><form:input path="mobile"
											id="mobile" class="textbox" maxlength="15" />
									</td>
									
									
									</tr>	
      
      
      
     									 <tr>
     									 
     									 <td>Other No<span
												class="required">*</span></td>
									<td><form:input path="otherNo"
											id="otherNo" class="textbox" maxlength="15" />
									</td>
									<td>Residence<span
												class="required">*</span></td>
									<td><form:input path="residence"
											id="residence" class="textbox"/>
									</td>
								
								
									</tr>	
      
    								  <tr>
									<td>Decline Reason<span
												class="required">*</span></td>
									<td><form:input path="declineReason"
											id="declineReason" class="textbox"/>
									</td>
									
										<td>Status<span
												class="required">*</span></td>
									<td><form:select path="statusId"
											id="statusId" class="select">
											 <form:option value="0">-Select-</form:option>
											<form:options items="${status }" />
										</form:select>
										
										
										
									</td>
									
									</tr>	
      			
    									  <tr>
									<td>Email CC List<span
												class="required">*</span></td>
									<td><form:textarea path="emailCCList"
											id="emailCCList" class="textbox"/>
									</td>
									</tr>	
												
								
												
												
											
										
							</table>





							
							
						
				<input type="submit" value="Update" name="update" id="update" class="btn btn-primary"/>
					
					
					
					
					
					
					
					
					
					
					
					
					
						
					
					
					
					
						
						
						
					
</c:forEach> 
</form:form>
					</div>
				
			 
		</div>
	</div>


	</div>
	
	




</body>
</html>











