<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
<script type="text/javascript" src="js/MntValidator.js"></script>

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
																	documentType : {
																		required : true,
																		alphabets:true,
																		specialcharacters:true,
																		maxlength: 50
																	},
																},
																messages : {
																	documentType :{
																		
																		required: "<font style='color: red;'><b>Document Type is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>Document Type only 50 Characters are allowed.</b></font>",
														                
														                alphabets:"<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
														                
																		specialcharacters:"<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
																	}
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
																	documentTypeEdit : {
																		required : true,
																		alphabets:true,
																		specialcharacters:true,
																		maxlength: 50
																	},

																},
																messages : {
																	documentTypeEdit:{
																		required: "<font style='color: red;'><b>Document Type is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>Document Type only 50 Characters are allowed.</b></font>",
														                
														                alphabets:"<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
														                
																		specialcharacters:"<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
																	}
																},
															});

										});

					});
</script>



<script type="text/javascript">
	$(document).ready(function() {
		jQuery.validator.addMethod("alphaNumeric", function(value, element) {
			return this.optional(element) || /^[0-9a-zA-Z&_ ]+$/.test(value);
		});

	});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				jQuery.validator.addMethod("startWithAlphabet", function(value,
						element) {
					return this.optional(element)
							|| /^[a-zA-Z][]|[0-9a-zA-Z&_ ]+$/.test(value);
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
		if (document.getElementById("aid").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
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

		});
	});
</script>

<script type="text/javascript" language="javascript">
	jQuery(document).ready(function() {
		jQuery("#mainForm").validationEngine();
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Document Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="dtvalues" items="${dtvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
				<form:form action="DocumentTypeSearch.mnt" method="get"
						commandName="DocumentTypeCommand" name="agreementform"> 
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="documentTypesave"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/></strong>
											<s:message code="label.documentType"/> <s:message code="label.saveSuccess"></s:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error"/> </strong>
											
								<s:message code="label.documentType"/>	<s:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="documentTypeUpdate"
										items="${documentTypeUpdate}">
										<div class="alert-success" id="successmessage">
										<strong><s:message code="label.success"/></strong>
											<s:message code="label.documentType"/> <s:message code="label.updateSuccess"></s:message>
										</div>
									</c:forEach><c:forEach var="documentTypeUpdateError"
										items="${documentTypeUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/></strong>
											<s:message code="label.documentType"/> <s:message code="label.updateFail"></s:message>
										</div>
									</c:forEach><c:forEach var="documentTypeDelete"
										items="${documentTypeDelete}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/></strong>
											<s:message code="label.documentType"/> <s:message code="label.deleteSuccess"></s:message>
										</div>
									</c:forEach><c:forEach var="documentTypeDeleteError"
										items="${documentTypeDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><s:message code="label.error"/></strong>
											<s:message code="label.documentType"/> <s:message code="label.deleteFail"></s:message>
										</div>
									</c:forEach></td>
							</tr>
					         <tr>
								<td><s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										
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
									value="<s:message code="label.search"/>"
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

			<c:forEach var="documentTypeSearch" items="${documentTypeSearch}">

						<c:set var="as" value="${documentTypeSearch}"></c:set>
					</c:forEach>
		 			

					<c:if test="${as!=null }">

					<display:table id="documentType" name="documentType"
						requestURI="DocumentTypeSearch.mnt" pagesize="5" class="table">


						
						<display:column property="documentType" titleKey="label.documentType"
							media="html" sortable="true" />



						<display:column titleKey="label.edit" style="color:white">
						
						<c:choose>
							<c:when test="${edit }">
							<a
								href="DocumentTypeEditHome.mnt?documentTypeId=<c:out 

								value="${documentType.documentType_Id}"/>"
								style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a>
								
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
								href="DocumentTypeDelete.mnt?documentTypeId=<c:out value="${documentType.documentType_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
								
								</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
							</c:otherwise>
							</c:choose>
						</display:column>
						<display:setProperty name="paging.banner.placement" value="bottom" />

						<display:setProperty name="paging.banner.group_size" value="3" />

						<display:setProperty name="paging.banner.some_items_found"
							value="<span class='pagebanner'>{0} {1},listing {2} to {3}. 

						</span>" />
					</display:table> 
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="DocumentTypeadd.mnt" method="POST"
						commandName="DocumentTypeCommand" id="addForm">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach
										var="addDocumentTypeDuplicate"
										items="${addDocumentTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
												<strong><s:message code="label.warning"/></strong>
											<s:message code="label.documentType"/> <s:message code="label.duplicateCheck"></s:message>
											</div>
									</c:forEach></td>
							</tr>
							
							
						
							<tr>
								<td><s:message code="label.documentType"></s:message><font color="red">*</font>
								<form:input path="documentType" id="documentType"
										class="textbox" /></td>
								<td><font color="red"></font></td>
							</tr>
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit"
									value="<s:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<s:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose>
								<input type="reset"
									value="<s:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
							</table>
							</form:form>
						
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					 <c:forEach var="dtvalues" items="${dtvalues }">

						<form:form action="DocumentTypeEdit.mnt" method="POST"
							commandName="DocumentTypeCommand" id="editForm">
							<table class="tableGeneral">

									<tr>
									<td colspan="2"><c:forEach
											var="editDocmentTypeDuplicate"
											items="${editDocmentTypeDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><s:message code="label.warning"/></strong>
											<s:message code="label.documentType"/> <s:message code="label.duplicateCheck"></s:message>
											</div>
										</c:forEach></td>
								</tr>
								
								<tr>
									<td></td>
									<td><form:hidden path="documentType_IdEdit"
											id="documentType_IdEdit" /></td>
								</tr>

								<tr>
									<td><s:message code="label.documentType"></s:message><font color="red">*</font>
									<form:input path="documentTypeEdit"
											id="documentTypeEdit" class="textbox" /></td>
								</tr>
									<tr>
									<td colspan="2"><c:choose>
										<c:when test="${update}"><input type="submit"
										value="<s:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<s:message code="label.update"/>"
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




