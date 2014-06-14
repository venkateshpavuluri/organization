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

<script type="text/javascript">
$(function() {

	
	
	$("#dueDate").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true
		
	});
	
});

</script>
<script type="text/javascript">
$(document).ready(function() {
		
	$('#submitId').click(function(event) {   
			
	 	$('#codeAdd').validate({ 
			rules : {
				code:{
					required : true,
					alphanumeric : true,
					specialcharacters: true
				},
				codeGroupId : {
					required : true
					},
						
				
			},
			messages : {
				code:{
					required: "<font style='color: red;'><b>Code is Required</b></font>",
					alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
					specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
						
						},
				codeGroupId : "<font style='color: red;'><b>Code Group is Required</b></font>",
				
											
			},
			

		}); 
		
	});

			
	 $('#updatedId').click(function(event) {
		
		//alert("ss");
	 	$('#codeEditLink').validate({
			rules : {
				
				codeEdit:{
					required : true,
					alphanumeric : true,
					specialcharacters: true
					},
				codeGroupIdEdit : {
					required : true
					},
				
				
			},
			messages : {
				codeEdit:{
					required: "<font style='color: red;'><b>Code is Required</b></font>",
					alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
					specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
						
						},
				codeGroupIdEdit : "<font style='color: red;'><b>Code Group is Required</b></font>",
				
					
				
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
		
			$('#code').val('');
			$('#codeGroup').val(0);
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#submitId').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
			
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
		<div class="PageTitle"><spring:message code="label.code" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="codeEditList" items="${codeEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					
					
					
					<table class="tableGeneral">
					
					<form:form action="codeSearch.mnt" method="GET"
							commandName="codeCommand">
						

							<tr>
								<td colspan="2"><c:forEach var="codeAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.code"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.code"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="codeUpdate"
										items="${codeUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.code"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="codeUpdateError"
										items="${codeUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.code"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="codeDeleted"
										items="${codeDeleted}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.code"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="codeDeleteError"
										items="${codeDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.code"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
	                        <tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td> <form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="codeCommand.operations">
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
									</c:choose>
							
						
							</tr> 

						
					</form:form>
					
					
					</table>
					
					
					
					<c:choose>
						<c:when test="${codeList!=null }">
													
					
							<display:table name="codeList" id="CodeList" class="table"
								requestURI="codeSearch.mnt" pagesize="5">
							
							
								 <display:column property="code" sortable="true"
									titleKey="label.code" media="html" />

								 <display:column property="codeGroupId" sortable="true"
									titleKey="label.codeGroup" media="html" />
								
								<display:column titleKey="label.edit">
								<c:choose>
							<c:when test="${edit }">
									<a
										href="codeEdit.mnt?codeId=<c:out value="${CodeList.codeId}"/> "><img
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
							<c:when test="${delete}">
									<a
										href="codeDelete.mnt?codeId=<c:out value="${CodeList.codeId}"/> "
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

							

						</c:otherwise>
					</c:choose>
					
					
					
			
	
	

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
						<form:form action="codeAdd.mnt" method="POST"
					commandName="codeCommand" id="codeAdd" >
							<table>
							
						
								<tr>
								<td colspan="2"><c:forEach var="codeAddDuplicateCheck"
										items="${codeAddDuplicateCheck}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.code"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
							<form:hidden path="aid" />
							
							
								<tr>
									<td>Code<span
												class="required">*</span></td>
									<td><form:input path="code"
											id="code" class="textbox"/>
											</td></tr>
												<tr>
									<td>Code Group<span
												class="required">*</span></td>
									<td><form:select path="codeGroupId"
											id="codeGroup" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${codeGroups}" />
											</form:select>
											</td></tr>
										
								

							</table>


						<c:choose>
									<c:when test="${save}">
				<input type="submit" value="Save" name="Save" id="submitId" class="btn btn-primary"/></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="submitId" /> 
									</c:otherwise>

								</c:choose><input type="reset" class="btn btn-primary"/>	
			  	     </form:form>
			</div>


		</div>


<div id="tabs-1" class="TabbedPanelsContent" >
		<div align="left" class="TabbedPanelsContent">
		<form:form action="codeUpdate.mnt" method="POST" commandName="codeCommand" id="codeEditLink" >
			 <c:forEach var="codeEditList" items="${codeEditList}">
			
				
						<table>
							
							<tr>
								<td colspan="2"><c:forEach var="codeUpdateCheck"
										items="${codeUpdateCheck}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.code"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
						<form:hidden path="codeIdEdit"
											id="codeIdEdit" class="textbox"/>
								<tr>
									<td>Code<span
												class="required">*</span></td>
									<td><form:input path="codeEdit"	id="codeEdit" class="textbox" onkeyup="doAjaxPost('E')" maxlength="50"/>
											</td></tr>
											<tr>
									<td>Code Group<span
												class="required">*</span></td>
									<td><form:select path="codeGroupIdEdit"
											id="codeGroupEdit" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${codeGroups}" />
											</form:select>
											</td></tr>
										
							</table>





							
							<c:choose>
										<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updatedId" />
										</c:when>
										<c:otherwise>
						
				<input type="submit" value="Update" name="update" id="updatedId" class="btn btn-primary"/>
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











