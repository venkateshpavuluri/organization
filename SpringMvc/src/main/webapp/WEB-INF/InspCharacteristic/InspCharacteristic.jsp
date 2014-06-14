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
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
 <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 

<script type="text/javascript">
$(function() {

	$('#validFrom,#validFromEdit').datepicker();
	

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
	var InspCharacteristic = $('#inspCharacteristic').val();
	//alert("sdf"+purchaseOrderNo);
		$.ajax({
			type : "POST",
			url : "duplicateCheck.mnt",
			data : "InspCharacteristic=" + InspCharacteristic+ "&InspCharacteristicid=0",
			success : function(data) {
				//alert(data);
				var checkResponse="Warning ! Insp Characteristic aleardy exists.";
				if(checkResponse==data)
				{
				document.getElementById("inspCharacteristicDuplicateMess").style.display="block";
				$('#inspCharacteristicDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("inspCharacteristicDuplicateMess").style.display="none";
				$('#save').show();
				}
			},
			error : function(e) {
			
			}

		});
		  }
	  if(id=='E')
		  { 
		  
		 
		  
			var InspCharacteristicid = $('#inspCharacteristicId').val();
			 var InspCharacteristic = $('#inspCharacteristicEdit').val();
			
				$.ajax({
					type : "POST",
					url : "duplicateCheck.mnt",
					data : "InspCharacteristic=" + InspCharacteristic+ "&InspCharacteristicid=" + InspCharacteristicid,
					success : function(data) {
						//alert("data "+data);
						var checkResponse="Warning ! Insp Characteristic aleardy exists.";
						if(checkResponse==data)
						{
						document.getElementById("inspCharacteristicDuplicateMessEdit").style.display="block";
						$('#inspCharacteristicDuplicateMessEdit').html(data);
						$('#update').hide();
						}
						else
						{
						document.getElementById("inspCharacteristicDuplicateMessEdit").style.display="none";
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
	
		 
	 	$('#inspCharacteristicAdd').validate({
			rules : {
				
			      inspCharacteristicCode:{required:true},
			      inspCharacteristic:{required:true},
			      upperLimit:{required:true},
			      lowerLimit:{required:true},
			      uomId:{required:true},
			      validFrom:{required:true},
			      characteristicTypeId:{required:true},
			      priority:{required:true},
			      rules:{required:true},
			      minTolerance:{required:true},
			      maxTolerance:{required:true},
			      specification:{required:true},
				
				
			},
			messages : {
			
			      inspCharacteristicCode: "<font style='color: red;'><b>Insp Characteristic Code is Required</b></font>",
			      inspCharacteristic: "<font style='color: red;'><b>Insp Characteristic  is Required</b></font>",
			      upperLimit: "<font style='color: red;'><b>Upper Limit is Required</b></font>",
			      lowerLimit: "<font style='color: red;'><b>Lower Limit is Required</b></font>",
			      uomId: "<font style='color: red;'><b>Uom is Required</b></font>",
			      validFrom: "<font style='color: red;'><b>Valid From is Required</b></font>",
			      characteristicTypeId: "<font style='color: red;'><b>Characteristic Type is Required</b></font>",
			      priority: "<font style='color: red;'><b>Priority is Required</b></font>",
			      rules: "<font style='color: red;'><b>Rules is Required</b></font>",
			      minTolerance: "<font style='color: red;'><b>Min Tolerance is Required</b></font>",
			      maxTolerance: "<font style='color: red;'><b>Max Tolerance is Required</b></font>",
			      specification: "<font style='color: red;'><b>Specification is Required</b></font>",
				
					
				
			},
			

		}); 
		
	});

	
	
	
	
	
	$('#update').click(function(event) {
		
		//alert("ss");
	 	$('#inspCharacteristicUpdate').validate({
			rules : {
				
				   inspCharacteristicCode:{required:true},
				      inspCharacteristic:{required:true},
				      upperLimit:{required:true},
				      lowerLimit:{required:true},
				      uomId:{required:true},
				      validFrom:{required:true},
				      characteristicTypeId:{required:true},
				      priority:{required:true},
				      rules:{required:true},
				      minTolerance:{required:true},
				      maxTolerance:{required:true},
				      specification:{required:true},
				
				
			},
			messages : {
				
				
				 inspCharacteristicCode: "<font style='color: red;'><b>Insp Characteristic Code is Required</b></font>",
			      inspCharacteristic: "<font style='color: red;'><b>Insp Characteristic  is Required</b></font>",
			      upperLimit: "<font style='color: red;'><b>Upper Limit is Required</b></font>",
			      lowerLimit: "<font style='color: red;'><b>Lower Limit is Required</b></font>",
			      uomId: "<font style='color: red;'><b>Uom is Required</b></font>",
			      validFrom: "<font style='color: red;'><b>Valid From is Required</b></font>",
			      characteristicTypeId: "<font style='color: red;'><b>Characteristic Type is Required</b></font>",
			      priority: "<font style='color: red;'><b>Priority is Required</b></font>",
			      rules: "<font style='color: red;'><b>Rules is Required</b></font>",
			      minTolerance: "<font style='color: red;'><b>Min Tolerance is Required</b></font>",
			      maxTolerance: "<font style='color: red;'><b>Max Tolerance is Required</b></font>",
			      specification: "<font style='color: red;'><b>Specification is Required</b></font>",
				
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
			$('#inspCharacteristicId').val('');
					$('#inspCharacteristicCode').val('');
							$('#inspCharacteristic').val('');
									$('#upperLimit').val('');
											$('#lowerLimit').val('');
													$('#uomId').val('');
			$('#validFrom').val('');
		    $('#characteristicTypeId').val('');
		    		$('#priority').val('');
		    				$('#rules').val('');
		    						$('#minTolerance').val('');
		    								$('#maxTolerance').val('');
		    										$('#specification').val('');
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
		<div class="PageTitle"><spring:message code="label.inspCharacteristic" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vendorValues" items="${inspCharacteristicEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					
					
					
						<table class="tableGeneral">
					
				 <form:form action="inspCharacteristicSearch.mnt" method="GET"
							commandName="inspCharacteristicCommand">
						
<tr>
								<td colspan="2"><c:forEach var="inspCharAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.inspCharacteristic"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.inspCharacteristic"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="inspCharUpdate"
										items="${inspCharUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.inspCharacteristic"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="inspCharUpdateError"
										items="${inspCharUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.inspCharacteristic"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="inspCharDelete"
										items="${inspCharDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.inspCharacteristic"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="inspCharDeleteError"
										items="${inspCharDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.inspCharacteristic"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							

							<tr id="mainSearch">
								<td><form:hidden path="advanceBasicSearchHidden" id="advanceBasicSearchHidden" value="0" /><spring:message code="label.searchby" /></td>
								<td> <form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="inspCharacteristicCommand.operations">
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
					<form:form action="inspCharacteristicAdvanceSearch.mnt" method="GET"
							commandName="inspCharacteristicCommand" name="advanceSearchFinal">
						<tr>
						<td>
						<a href="javascript: void(0);" id="advanceSearch" onclick="document.advanceSearchFinal.submit();return false;"><font style="color: blue"><u><b>Advanced Search</b></u></font></a>
						<a href="#" id="basicSearch" style="display: none" ><font style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
						</td>
						</tr>
					</form:form>
					</table>
					<form:form action="inspCharacteristicSearch.mnt" commandName="inspCharacteristicCommand" method="GET">
						<div id="advanceSearchDiv" style="display: none" >
						<table class="tableGeneral">
						<c:forEach
										var="xmlLabelValue" items="${inspCharacteristicSearchAdvance}">
						<tr>
								<td>
										<label>${xmlLabelValue.secondLabel}</label><form:hidden path="firstLabel" id="firstLabel" value="${xmlLabelValue.firstLabel}"/></td>
										 <td><spring:bind path="inspCharacteristicCommand.operations1">
								<select class="select" name="operations1">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> 
									
									
									</td><td><form:input path="advanceSearchText" id="advanceSearch" class="textbox"/></td>
							</tr>
							<tr><form:hidden path="advanceBasicSearchHidden" id="advanceBasicSearchHidden" /><form:hidden path="advanceSearchHidden" id="advanceSearchHidden" /><td colspan="3"><input type="submit" id="advanceSearchButtonId" value="Advance Search"
									style="display: none" class="btn btn-primary" /></td></tr>
							
							</c:forEach>
							
						
						</table>
						
						</div>
</form:form>
					
					<c:forEach var="inspCharacteristic" items="${inspCharacteristicList}">
						<c:set var="purc" value="${inspCharacteristic}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${purc!=null }">
						
							<display:table name="inspCharacteristicList" id="purcList" class="table"
								requestURI="inspCharacteristicSearch.mnt" pagesize="5">
						
								<display:column property="inspCharacteristicCode" sortable="true"
									titleKey="label.inspCharacteristicCode" media="html" />
									
								<display:column property="inspCharacteristic" sortable="true"
									titleKey="label.inspCharacteristic" media="html" />

								<display:column property="uomId" sortable="true"
									titleKey="label.uomId" media="html" />
								

								<display:column property="validFrom" sortable="true"
									titleKey="label.validFrom" media="html" />
								<display:column property="charTypeName" sortable="true"
									titleKey="label.characteristicTypeId" media="html" />

								<display:column property="rules" sortable="true"
									titleKey="label.rules" media="html" />
								
	
								<display:column titleKey="label.edit">
								
								<c:choose>
							<c:when test="${true }">
									<a
										href="inspCharacteristicEdit.mnt?inspCharacteristicId=<c:out value="${purcList.inspCharacteristicId}"/> "><img
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
							<c:when test="${true}">
								
									<a
										href="inspCharacteristicDelete.mnt?inspCharacteristicId=<c:out value="${purcList.inspCharacteristicId}"/> "
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

						
					</c:choose>
					
					
					
			

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
						<form:form action="InspCharacteristicAdd.mnt" method="POST"
					commandName="inspCharacteristicCommand" id="inspCharacteristicAdd" name="inspCharacteristicAdd">
							<table>
							
							<tr>
								<td colspan="4"><form:hidden
										path="inspCharacteristicDuplicate" /> 	
										<div class="alert-warning" id="inspCharacteristicDuplicateMess" style="display: none;"></div>
										</td>
							</tr>
							
							
							
							
								<tr>
									<td>Inspection Characteristic Code<span
												class="required">*</span></td>
									<td><form:input path="inspCharacteristicCode"
											id="inspCharacteristicCode" class="textbox"  maxlength="50"/>
											</td>
									<td>Inspection Characteristic<span
												class="required">*</span></td>
									<td><form:input path="inspCharacteristic"
											id="inspCharacteristic" class="textbox" onkeyup="doAjaxPost('A')" /></td>
								</tr>
								<tr>
									<td>Upper Limit<span
												class="required">*</span></td>
									<td><form:input path="upperLimit"
											id="upperLimit" class="textbox" /></td>
									<td>Lower Limit<span
												class="required">*</span></td>
									<td><form:input path="lowerLimit"
											id="lowerLimit" class="textbox" />
											</td>
								</tr>
								
								
								<tr>
									<td>Uom<span
												class="required">*</span></td>
									<td><form:select path="uomId" id="uomId"
											class="select" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${Uom }" />
											</form:select>
											</td>
									<td>Valid From<span
												class="required">*</span></td>
									<td><form:input path="validFrom" id="validFrom" class="textbox" /></td>
								</tr>
								<tr>
									<td>Characteristic Type<span
												class="required">*</span></td>
									<td><form:select path="characteristicTypeId" id="characteristicTypeId"
											class="select" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${characteristicType }" />
										</form:select></td>
									<td>Priority<span
												class="required">*</span></td>
									<td><form:input path="priority" id="priority"
											class="textbox"/></td>
								</tr>
								<tr>
									<td>Rules<span
												class="required">*</span></td>
									<td><form:input path="rules" id="rules"
											class="textbox"/></td>
									<td>Max Tolerance<span
												class="required">*</span></td>
									<td><form:input path="maxTolerance" id="maxTolerance"
											class="textbox"/></td>
								</tr>
								<tr>
									<td>Specification<span
												class="required">*</span></td>
									<td><form:input path="specification" id="specification"
											class="textbox" /></td>
									<td>Min Toleance<span
												class="required">*</span></td>
									<td><form:input path="minTolerance" id="minTolerance"
											class="textbox" />
									</td>
								</tr>
								
								


							</table>


						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11">InspCharacteristic Details</a></li>
								
							</ul>
							<div id="tabs-11">
							
										
											
							<div align="left">
									
									<script>
										var btrid = 200;
										$(function() {  

											var  inspectionMethodId = $("#inspectionMethodId"),hiddenID = $("#hiddenIdPurchasePopUp"),
											
											allFields = $([])
											.add(inspectionMethodId)
											.add(hiddenID),
											 tips = $(".validateTips");
										
											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
											
											function checkLength1(o, n) {
												if (o.val() =='0') {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
													return false;
												} else {
													return true;
												}
											}
											function checkLength2(o, n) {
												//alert("sss"+o.val());
												if (o.val()=="") {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-inspectionMethod")
													.dialog(
															{
																autoOpen : false,
																height : 350,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");

																		bValid = bValid && checkLength1(inspectionMethodId ,"Inspection Method");
	
																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
																		    //alert("value "+);
																		    	
																		      
																				$(
																						"#inspectionAdd tbody")   
																						.append(
																								"<tr id="+btrid+">"      
																									
																										+ "<td><spring:bind path='inspCharacteristicCommand.inspectionMethodIdForView'><input type='hidden' name='inspectionMethodIdForView' id='inspectionMethodIdForView"
																										+ btrid
																										+ "' value="
																										+ inspectionMethodId
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='inspCharacteristicCommand.inspectionMethodName'><input type='text' name='inspectionMethodName' id='inspectionMethodName"
																										+ btrid
																										+ "' value='"
																										+ $('#inspectionMethodId :selected').text()
																										+ "' class='textbox' readonly/></spring:bind> </td>"
																										
																										+"<td><a href='#'  onclick='editInspInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeInspInAdd("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid++;
																			//	$('#inspCharacteristicValue').val(parseFloat($('#inspCharacteristicValue').val())+parseFloat($('#lineAmtChild').val()));
																				$(
																						this)
																						.dialog(
																								"close");
																				
																			}
																			if (hiddenID
																					.val() != "0") {
																				
																			  $('#inspectionMethodIdForView'+ hiddenID.val()).val(inspectionMethodId.val());
																			  $('#inspectionMethodName'+ hiddenID.val()).val($('#inspectionMethodId :selected').text());
																			  $('#hiddenIdPurchasePopUp').val("0");
																				$(this).dialog("close");
																			}

																		}

																	},
																	Cancel : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																close : function() {
																	allFields
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

										

											$("#create-AddInsprction")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-inspectionMethod")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeInspInAdd(id) {
											//alert("removing row " + id);
		                                	$('#' + id).remove();
										}
										function editInspInAdd(id) {
											//alert("edit row " + id);
											$("#dialog-form-inspectionMethod").dialog("open");
											$('#inspectionMethodId').val($('#inspectionMethodIdForView' + id).val());
											$('#hiddenIdPurchasePopUp').val(id);
											}
										
									</script>
									
									


									<div id="dialog-form-inspectionMethod" title="Add Inspection Method Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">



											
												<%-- <tr><td>Line Number</td>
												<td><form:input path="lineNumberChild" id="lineNumberChild" class="textbox" /></td>
											</tr> --%>
											<tr>
												<td>Inspection Method</td>
												<td><form:select path="inspectionMethodId" id="inspectionMethodId"
														class="select" >
														<form:option value="0">-Select-</form:option>
													<form:options items="${inspectionMethod}" />
													</form:select>
													
													
													<input type="hidden" name="hiddenIdPurchasePopUp" id="hiddenIdPurchasePopUp" value="0" />
													</td>
														
														
														
														
											</tr>
											
										
											
											


										</table>
									</div>

 
									<div id="scroll1">
									<div id="users-contain-Purchase">
										
										
										 <table id="inspectionAdd" class="table">
											
												<tr id="inspectionAddHead">
												
													<th>Inspection Method</th>
													<th>Edit</th>
													<th>Remove</th>
												 </tr>
												 
												 
												 	
												 </table>
												
												 <table>
												 		
											
											<tbody>
											</tbody>
										</table>
										
										
										
									
									</div>
								
									<div id="extender"></div>
									 <button id="create-AddInsprction" type="button">Add Inspection Method</button> 
									</div>
									
								</div>
									
							</div>
							
							
					
				</div><c:choose>
									<c:when test="${true}">
				<input type="submit" value="Save" name="Save" id="save" class="btn btn-primary"/>
				</c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise></c:choose>
				<input type="reset" class="btn btn-primary"/>	
			  	     </form:form>
			</div>


		</div>


<div id="tabs-1" class="TabbedPanelsContent" >
		<div align="left" class="TabbedPanelsContent">
		
		<form:form action="inspCharacteristicUpdate.mnt" method="POST"
					commandName="inspCharacteristicCommand" id="inspCharacteristicUpdate" >
						 <c:forEach var="inspCharacteristicEditList" items="${inspCharacteristicEditList}">
						
							<table>
							
							<tr>
								<td colspan="4"><form:hidden
										path="inspCharacteristicDuplicate" /> 	
										<div class="alert-warning" id="inspCharacteristicDuplicateMessEdit" style="display: none;"></div>
										</td>
							</tr>
							
							
							
							
								<tr>
									<td>Inspection Characteristic Code<span
												class="required">*</span></td>
									<td><form:hidden path="inspCharacteristicId"
											id="inspCharacteristicId" class="textbox" /><form:input path="inspCharacteristicCode"
											id="inspCharacteristicCode" class="textbox"  maxlength="50"/>
											</td>
									<td>Inspection Characteristic<span
												class="required">*</span></td>
									<td><form:input path="inspCharacteristic"
											id="inspCharacteristicEdit" class="textbox" onkeyup="doAjaxPost('E')" /></td>
								</tr>
								<tr>
									<td>Upper Limit<span
												class="required">*</span></td>
									<td><form:input path="upperLimit"
											id="upperLimit" class="textbox" /></td>
									<td>Lower Limit<span
												class="required">*</span></td>
									<td><form:input path="lowerLimit"
											id="lowerLimit" class="textbox" />
											</td>
								</tr>
								
								
								<tr>
									<td>Uom<span
												class="required">*</span></td>
									<td><form:select path="uomId" id="uomId"
											class="select" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${Uom }" />
											</form:select>
											</td>
									<td>Valid From<span
												class="required">*</span></td>
									<td><form:input path="validFrom" id="validFromEdit" class="textbox" /></td>
								</tr>
								<tr>
									<td>Characteristic Type<span
												class="required">*</span></td>
									<td><form:select path="characteristicTypeId" id="characteristicTypeId"
											class="select" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${characteristicType }" />
										</form:select></td>
									<td>Priority<span
												class="required">*</span></td>
									<td><form:input path="priority" id="priority"
											class="textbox"/></td>
								</tr>
								<tr>
									<td>Rules<span
												class="required">*</span></td>
									<td><form:input path="rules" id="rules"
											class="textbox"/></td>
									<td>Max Tolerance<span
												class="required">*</span></td>
									<td><form:input path="maxTolerance" id="maxTolerance"
											class="textbox"/></td>
								</tr>
								<tr>
									<td>Specification<span
												class="required">*</span></td>
									<td><form:input path="specification" id="specification"
											class="textbox" /></td>
									<td></td>
									<td>
									</td>
								</tr>
								
								


							</table>
		
	
					
					
					<div id="tabs2">
					
					
					
					
						<ul>
							<li><a href="#tabs-21">Inspection Method</a></li>
							
						</ul>
						<div id="tabs-21">
							
							<div align="left">
									
									<script>
										var btrid = 400;
										$(function() {  

											var  inspectionMethodId = $("#inspectionMethodIdEdit"),hiddenID = $("#hiddenIdPurchasePopUpEdit"),
											
											allFields = $([])
											.add(inspectionMethodId)
											.add(hiddenID),
											 tips = $(".validateTips");
										
											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
											
											function checkLength1(o, n) {
												if (o.val() =='0') {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
													return false;
												} else {
													return true;
												}
											}
											function checkLength2(o, n) {
												//alert("sss"+o.val());
												if (o.val()=="") {
													o
															.addClass("ui-state-error");
													updateTips("Select "+ n +" Value ");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-inspectionMethodEdit")
													.dialog(
															{
																autoOpen : false,
																height : 200,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");

																		bValid = bValid && checkLength1(inspectionMethodId ,"Inspection Method");
	
																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
																		    //alert("value "+);
																		    	
																		      
																				$(
																						"#inspectionAddEdit tbody")   
																						.append(
																								"<tr id="+btrid+">"      
																									
																										+ "<td><input type='hidden' name='inspCharacteristicMethodId' id='inspCharacteristicMethodId' value='0' /> <spring:bind path='inspCharacteristicCommand.inspectionMethodIdForView'><input type='hidden' name='inspectionMethodIdForView' id='inspectionMethodIdForViewEdit"
																										+ btrid
																										+ "' value="
																										+ inspectionMethodId
																												.val()
																										+ " class='textbox' readonly/></spring:bind><spring:bind path='inspCharacteristicCommand.inspectionMethodName'><input type='text' name='inspectionMethodName' id='inspectionMethodNameEdit"
																										+ btrid
																										+ "' value='"
																										+ $('#inspectionMethodIdEdit :selected').text()
																										+ "' class='textbox' readonly/></spring:bind> </td>"
																										
																										+"<td><a href='#'  onclick='editInspInAddEdit("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeInspInAddEdit("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid++;
																				$('#inspCharacteristicValue').val(parseFloat($('#inspCharacteristicValue').val())+parseFloat($('#lineAmtChild').val()));
																				$(
																						this)
																						.dialog(
																								"close");
																				
																			}
																			if (hiddenID
																					.val() != "0") {
																				
																			  $('#inspectionMethodIdForViewEdit'+ hiddenID.val()).val(inspectionMethodId.val());
																			  $('#inspectionMethodNameEdit'+ hiddenID.val()).val($('#inspectionMethodIdEdit :selected').text());
																			  $('#hiddenIdPurchasePopUpEdit').val("0");
																				$(this).dialog("close");
																			}

																		}

																	},
																	Cancel : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																close : function() {
																	allFields
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

										

											$("#create-AddInsprctionEdit")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-inspectionMethodEdit")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeInspInAddEdit(id) {
											//alert("removing row " + id);
		                                	$('#' + id).remove();
										}
										function editInspInAddEdit(id) {
											alert("edit row " + id +$('#inspectionMethodIdForViewEdit' + id).val());
											$("#dialog-form-inspectionMethodEdit").dialog("open");
											$('#inspectionMethodIdEdit').val($('#inspectionMethodIdForViewEdit' + id).val());
											$('#hiddenIdPurchasePopUpEdit').val(id);
											}
										function disabledInspInEdit(
												id) {
											//alert(link.id);
											alert("Deleting Particular Row Will Deleted Once You Click Update Button");
											document
													.getElementById("CheckInsp"+id).value = "1";
											document.getElementById(id).style.display = "none";
										}
									</script>
									
									


									<div id="dialog-form-inspectionMethodEdit" title="Add Inspection Method Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">



											
												<%-- <tr><td>Line Number</td>
												<td><form:input path="lineNumberChild" id="lineNumberChild" class="textbox" /></td>
											</tr> --%>
											<tr>
												<td>Inspection Method</td>
												<td><form:select path="inspectionMethodId" id="inspectionMethodIdEdit"
														class="select" >
														<form:option value="0">-Select-</form:option>
													<form:options items="${inspectionMethod}" />
													</form:select>
													
													
													<input type="hidden" name="hiddenIdPurchasePopUp" id="hiddenIdPurchasePopUpEdit" value="0" />
													</td>
														
														
														
														
											</tr>
											
										
											
											


										</table>
									</div>

 
									<div id="scroll1">
									<div id="users-contain-Purchase">
										
										
										 <table id="inspectionAddEdit" class="table">
											
												<tr id="inspectionAddHeadEdit">
												
													<th>Inspection Method</th>
													<th>Edit</th>
													<th>Remove</th>
												 </tr>
												 
												   <c:forEach var="inspCharacteristicMethodEditList" items="${inspCharacteristicMethodEditList }">
											  
											   <tr id="${inspCharacteristicMethodEditList.inspCharacteristicMethodId}">
												
													<td><spring:bind path="inspCharacteristicCommand.inspCharacteristicMethodId">
													<input type='hidden' name="inspCharacteristicMethodId" id="inspCharacteristicMethodId" 
													value="${inspCharacteristicMethodEditList.inspCharacteristicMethodId }"/></spring:bind>
													<spring:bind path="inspCharacteristicCommand.inspectionMethodId">
													<input type="hidden"  name="inspectionMethodIdForView" 
													id="inspectionMethodIdForViewEdit${inspCharacteristicMethodEditList.inspCharacteristicMethodId}" 
													class="textbox" value="${inspCharacteristicMethodEditList.inspectionMethodId }"  />
													</spring:bind>  
													<spring:bind path="inspCharacteristicCommand.inspectionMethodName">
													<input  name="inspectionMethodName" id="inspectionMethodName${inspCharacteristicMethodEditList.inspCharacteristicMethodId }" 
													class="textbox"  value="${inspCharacteristicMethodEditList.inspectionMethodName}" readonly="readonly"/>
													</spring:bind>
													
													<input type="hidden" name="CheckInsp${inspCharacteristicMethodEditList.inspCharacteristicMethodId}" id="CheckInsp${inspCharacteristicMethodEditList.inspCharacteristicMethodId}" value="0"/></td>

													<td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/Edit.jpg" height="20px" width="20px" onclick="editInspInAddEdit(${inspCharacteristicMethodEditList.inspCharacteristicMethodId })" /></strong></a></td><td><a href="#" style="float:left; margin:0px 0 0 5px;" class="remove" onclick="disabledInspInEdit(${inspCharacteristicMethodEditList.inspCharacteristicMethodId})"><strong><img src="images/button_cancel.png"  height="20px" width="20px" /></strong></a></td></tr> 
												
											 </c:forEach>
												 </table>
												
												 <table>
												 		
											
											<tbody>
											</tbody>
										</table>
										
										
										
									
									</div>
								
									<div id="extenderEdit"></div>
									 <button id="create-AddInsprctionEdit" type="button">Add Inspection Method</button> 
									</div>
									
								</div>
								</div>
							
							
							
						</div>
						
						
						
						
						<c:choose>
										<c:when test="${true}"><input type="submit" value="Update" name="Update"  id="update" class="btn btn-primary" align="top"/></c:when>
										<c:otherwise>
						
				<input type="submit" value="Update" name="update" id="update" class="btn btn-primary"/>
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











