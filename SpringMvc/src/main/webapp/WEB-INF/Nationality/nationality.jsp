<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author Srinivas
 @version 1.0    -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<script type="text/javascript" src="js/MntValidator.js"></script>


<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#sumbnid')
								.click(
										function(event) {
											//alert($('#sdType').val());
											
											$('#addinspectionform')
													.validate(
															{
																rules : {
																	nationality : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},

																	
																},
																messages : {
																	nationality : {
																		required: "<font style='color: red;'><b>Nationality is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},
																			},

															});
										});
						//UpdateForm Validations
						 $('#updated')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert(assetedit);
											$('#editinspectionForm')
													.validate(
															{
																rules : {
																	nationalityedit : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters: true
																	},


																},
																messages : {
																	nationalityedit : {
																		required: "<font style='color: red;'><b>Nationality is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
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
	});
</script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("nhide").value == 1) {
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




</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle"><spring:message code="label.nationality" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
								code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
								code="label.add" /></a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchNationality.mnt" method="GET"
						commandName="NationalityCMD">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.nationality"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.nationality"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="NationalityDelete"
										items="${NationalityDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.nationality"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="NationalityDeleteErr"
										items="${NationalityDeleteErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.nationality"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="NationalityUpdate"
										items="${NationalityUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.nationality"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="NationalityUpdateErr"
										items="${NationalityUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.nationality"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
								
							</td></tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="NationalityCMD.operations">
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
								<td><c:choose><c:when test="${search}">
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></c:otherwise></c:choose></td>
							</tr>

						</table>
					</form:form>

					
					<c:if test="${ebeans!=null}">
						<display:table id="nid" name="ebeans"
							requestURI="searchNationality.mnt" pagesize="5"
							class="table">
							<display:column property="nationalityid" title="E ID" media="none" sortable="true"></display:column>
							<display:column property="nationality" titleKey="label.nationality"
								media="html" sortable="true"></display:column>
							 <display:column titleKey="label.edit" style="color:white">
								<c:choose>
								<c:when test="${edit}"><a
									href="NationalityEdit.mnt?Nationalityedit=<c:out value="${nid.nationalityid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a></c:when><c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
								<c:when test="${delete}"><a
									href="NationalityDelete.mnt?Nationalitydelete=<c:out value="${nid.nationalityid}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
							</c:when><c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose></display:column> 
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>
					</c:if>

				</div>
			</div> 

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
				<form:form action="saveNationality.mnt" method="POST"
							commandName="NationalityCMD" id="addinspectionform">
					<table class="tableGeneral">

						<tr>
							<td colspan="2"><c:forEach var="Nationalitysuccessdup"
									items="${Nationalitysuccessdup}">
									<div class="alert-warning" id="successmessage">
								<strong><spring:message code="label.warning"/>  </strong>
								<spring:message code="label.nationality"/> <spring:message code="label.duplicateCheck"/>
									</div>
								</c:forEach></td>
						</tr>
						
							<form:hidden path="nhide" />	
							<tr>
							<td><spring:message code="label.nationality" /><span
									class="required">*</span> <form:input path="nationality"
										class="textbox"  maxlength="50"/></td>						
								
								
							</tr>
						
							<tr>
								<td colspan="2"><c:choose>
								<c:when test="${save}"><input type="submit" value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbnid"/></c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>"
									class="btn btn-danger" /></c:otherwise></c:choose><input
										type="reset" value="<spring:message code="label.reset"/>" class="btn btn-primary"/></td>
							</tr>
							</table>
						</form:form>
					

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="EditValues" items="${editvalues }">
						<form:form action="NationalityUpdate.mnt" method="POST"
							commandName="NationalityCMD" id="editinspectionForm">
							<table class="tableGeneral">
						<tr>	<td><c:forEach var="Nationalitydupedit"
									items="${Nationalitydupedit}">
									<div class="alert-warning" id="successmessage">
											<strong><spring:message code="label.warning"/>  </strong>
								<spring:message code="label.nationality"/> <spring:message code="label.duplicateCheck"/>
									</div>
								</c:forEach></td></tr>
                                     <form:hidden path="nhideedit" />
								<form:hidden path="nationalityidedit" />
								<tr>
								<td><spring:message code="label.nationality" /><span  class="required">*</span> <form:input path="nationalityedit"
										class="textbox" maxlength="50" /></td>	
								</tr>

								<tr>
									<td colspan="2"><c:choose>
									<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>" class="btn btn-primary" id="updated"/></c:when><c:otherwise>
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




