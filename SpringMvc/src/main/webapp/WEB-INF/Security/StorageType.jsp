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
<title>Storage Type</title>
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
.TabbedPanelsContent{

border: 5px;
font-style: Bold;
}
</style>


<script type="text/javascript">
$(document).ready(function() {
if(document.getElementById("aid").value==1){
  var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));
  
$('#tabs').tabs({active: index});
}

});
</script>
  
<script type="text/javascript">
	$(document).ready(function() {
		$('#'+"sumbnid").click(function(event) {
			//alert($('#privilege').val());
			$("#addStorageTypeForm").validate({
				
				rules : {
					storagetype : {
						
						required : true,
						alphabets : true,
						specialcharacters : true
						},
					
				},
				messages : {
					storagetype : {
						
					required:"<font style='color: red;'><b> StorageType is Required</b></font>",
					alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
					specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
			
					},
				},

			});
		});
		
		$('#updbut').click(function(event) {
			
			$("#updateStorageTypeForm").validate({
				rules : {
					storagetypeEdit :{
						
						required : true,
						alphabets : true,
						specialcharacters : true
						},
				},
				messages : {
						
					required:"<font style='color: red;'><b> StorageType is Required</b></font>",
					alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
					specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
			
					},

			});
		});
		
		

		

	});
</script>
 <script type="text/javascript">
 $(document).ready(function() {
 
    $('#search').click(function(e) {
    $('#edit').hide();
   
        });
        });
 </script>
 <script type="text/javascript">
 $(document).ready(function() {
    $('#add').click(function(e) {
   
    $('#edit').hide();
      $('#successmessage').hide();
      $('#savemessage').hide();
   
        });
        });
 </script>
 
 </head>
<body>
	<div class="divUserDefault">
	 <div class="PageTitle">Storage Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
			   <c:forEach var="storagetypeValues" items="${storagetypeValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message	code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			
     <!---================================ Search tab =======================================-->
	<div id="tabs-2" class="TabbedPanelsContent">
	 <div align="left">
	 
      <form:form action="storagetypeSearch.mnt" method="get" commandName="storagetypeAdd" >
	<table class="tableGeneral">
	<tr>
								<td colspan="2"><c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.storageType" />
											<spring:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:forEach var="fail" items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.storageType" />
											<spring:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach var="storageDel" items="${storageDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.storageType" />
											<spring:message code="label.deleteSuccess" />

										</div>
									</c:forEach> <c:forEach var="storageDelFail" items="${storageDelFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.storageType" />
											<spring:message code="label.deleteFail" />

										</div>
									</c:forEach> <c:forEach var="storagetypeUpadteSuccess" items="${storagetypeUpadteSuccess}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.storageType" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach>
									<c:forEach var="storagetypeUpadteFail"
										items="${storagetypeUpadteFail}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.assetType" />
											<spring:message code="label.updateFail" />

										</div>
									</c:forEach></td>
							</tr>
   <tr><td><spring:message code="label.searchby"/></td>
	
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select>  <spring:bind path="storagetypeAdd.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
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
								
								<td><c:choose>
										<c:when test="${search}">
											<input type="submit"
												value="<spring:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>

	 
	</table></form:form>
	
	
	<c:if test="${storagetypeSearch!=null}">
	<display:table  id="storagetypeRow" name="storagetypeSearch"  requestURI="storagetypeSearch.mnt" pagesize="5" class="table">

 <display:column property="storagetype" titleKey="label.storageType" media="html" sortable="true" ></display:column>

<c:choose>
<c:when test="${edit}">
<display:column titleKey ="label.edit" style="color:white"><a href="storagetypeEditHome.mnt?storagetypeDetEdit=<c:out value="${storagetypeRow.storagetypeId}"/>" style="color: red"><img src="images/Edit.jpg" width="20px" height="20px" /> </a></display:column>
</c:when><c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
									<c:choose>
									<c:when test="${delete}">
  <display:column titleKey="label.delete"><a href="storagetypeDelete.mnt?storagetypeIdDelete=<c:out value="${storagetypeRow.storagetypeId}"/>" style="color: red" onclick="return confirm('Do u want to delete the Record?')"><img src="images/Delete.jpg" width="20px" height="20px"  /></a></display:column>
</c:when><c:otherwise>
										<a><img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
<display:setProperty name="paging.banner.placement" value="bottom" />

</display:table></c:if> 
               
	 </div>
     </div>
     
     
     
     <!---================================ Add tab =======================================-->
	<div id="tabs-3" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	  
				<form:form  action="storagetypeAdd.mnt"  method="GET" commandName="storagetypeAdd" id="addStorageTypeForm" onsubmit="return validateForm()">
				<table class="tableGeneral">
	
				<tr>
								<td><c:forEach var="StorageTypeDuplicate"
										items="${StorageTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.storageType" />
											<spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
				
			<tr><td><spring:message code="label.storageType"/><span class="required">*</span></td><td><form:input path="storagetype" id="storagetype" class="textbox" /></td> </tr>
			
		  <form:hidden path="aid" /> 
			
			
					<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save}">
											<input type="submit"
												value="<spring:message code="label.save"/>" id="subtnId"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.save"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr></table>
					</form:form>	
					
			</div>
			</div>
			 <!---================================ Edit tab =======================================-->
<div id="tabs-1" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	 
	 <c:forEach var="storagetypeEditValues" items="${storagetypeValues }">
			 <form:form action="storagetypeUpdate.mnt" method="POST" commandName="storagetypeAdd" id="updateStorageTypeForm">
			<table class="tableGeneral">
			<tr>
								<td><c:forEach var="storagetypeEditDuplicate"
										items="${storagetypeEditDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.storageType" />
											<spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
			<form:hidden path="storagetypeIdEdit"/>
			
				<tr><td><spring:message code="label.storageType"/><span class="required">*</span></td><td><form:input path="storagetypeEdit" id="storagetype"  class="textbox" /> </td> </tr>
			
			
			
					<tr>
									<td colspan="2"><c:choose>
											<c:when test="${update}">
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updated" />
											</c:when>
											<c:otherwise>
												<input type="submit"
													value="<s:message code="label.update"/> "
													class="btn btn-danger" disabled="disabled" id="sumbnid" />
											</c:otherwise>
										</c:choose></td>

								</tr></table></form:form></c:forEach>
	</div></div> 

		</div>
	</div>

</body>
</html>




