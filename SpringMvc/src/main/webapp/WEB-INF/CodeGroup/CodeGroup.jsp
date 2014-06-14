<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'CodeGroupTemplate.jsp' starting page</title>
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
<script type="text/javascript" src="js/MntValidator.js"></script>
<script type="text/javascript">
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
	$(document)
			.ready(
					function() {
						
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event){
											$('#addForm')
													.validate(
															{
																rules : {
																	codeGroup : {
																		required : true, 
																		alphanumeric: true,
																		specialcharacters: true
																	},
																},
																messages : {
																	codeGroup : {
																		required: "<font style='color: red;'><b>Code Group is Required</b></font>",
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
											$('#editForm')
													.validate(
															{
																rules : {
																	codeGroupEdit : {
																		required : true,
																		alphanumeric: true,
																		specialcharacters: true
																		
																	},

																},
																messages : {
																	codeGroupEdit : {
																		required: "<font style='color: red;'><b>Code Group is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																			
																			},	
																},
															});

										});

					});
</script>


<script type="text/javascript">
	function doAjaxPost() {
		var codeGroup = $('#codeGroup').val();
		$.ajax({
			type : "POST",
			url : "codeGroupCheck.mnt",
			data : "codeGroup=" + codeGroup,
			success : function(response) {
				if (response != "") {
					document.getElementById("codeGroupMessage").style.display = "block";
					$('#codeGroupMessage').html(response);
					$('#submitid').hide();

				} else {
					document.getElementById("codeGroupMessage").style.display = "none";
					$('#submitid').show();
				}

			},
			error : function(e) {
				alert('Error' + e);
			}

		});
		}
		
	function doAjaxPostEdit() {
		var codeGroupEdit = $('#codeGroupEdit').val();
		var codeGroup_IdEdit = $('#codeGroup_IdEdit').val();
		
				$.ajax({
					type : "POST",
					url : "editcodeGroupCheck.mnt",
					data : "codeGroupEdit=" + codeGroupEdit + "&codeGroup_IdEdit=" + codeGroup_IdEdit,
					success : function(response) {
						if (response != "") {
							document.getElementById("codeGroupDuplMessage").style.display = "block";
							$('#codeGroupDuplMessage').html(response);
							$('#updateid').hide();

						} else {
							document.getElementById("codeGroupDuplMessage").style.display = "none";
							$('#updateid').show();
						}

					},
					error : function(e) {
						alert('Error' + e);
					}

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
		<div class="PageTitle">Code Group</div>
		<div id="tabs" class="TabbedPanels">
		
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="codeGroupEditValues" items="${codeGroupEditValues}">
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
				 <form:form method="get" action="codeGroupSearch.mnt"
						commandName="codeGroupCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="codeGroupAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.CodeGroup"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.CodeGroup"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="codeGroupUpdated"
										items="${codeGroupUpdated}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.CodeGroup"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="codeGroupUpdatedError"
										items="${codeGroupUpdatedError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.CodeGroup"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="codeGroupDeleted"
										items="${codeGroupDeleted}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.CodeGroup"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="codeGroupDeletedError"
										items="${codeGroupDeletedError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.CodeGroup"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

								<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="codeGroupCommand.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
									 
								<td>
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
					<%-- <c:forEach var="cgroup" items="${codeGroupValues}">

						<c:set var="as" value="${cgroup}"></c:set>
					</c:forEach> --%>

					<c:if test="${codeGroupValues!=null }">
						<display:table name="codeGroupBean" id="codeGroupBean" class="table"
							requestURI="codeGroupSearch.mnt" pagesize="5">
							<display:column property="codeGroup_Id" sortable="true"
								title="codeGroup_Id" media="none" />
							<display:column property="codeGroup" sortable="true"
								titleKey="label.CodeGroup" media="html" />

							<display:column titleKey="label.edit">
							<c:choose>
							<c:when test="${edit }">
							
								<a
									href="codeGroupEdit.mnt?codeGroupId=<c:out value="${codeGroupBean.codeGroup_Id}"/> "><img
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
									href="codeGroupDelete.mnt?codeGroupId=<c:out value="${codeGroupBean.codeGroup_Id}"/> "
									onclick="return confirm('Do You Want To Delete This Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
									
									</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
							</c:otherwise>
							</c:choose>
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
							<td colspan="4" class="alert-warning" id="codeGroupMessage"
								style="display: none; width: 300x; height: 25px;"></td>
						</tr>
					</table>
					<form:form action="codeGroupAdd.mnt" id="addForm" method="POST"
						commandName="codeGroupCommand">
						<table class="tableGeneral">
						
						<form:hidden path="aid" />
							<tr>
								<td><c:forEach var="addCodeGroupEditDuplicate" items="${addCodeGroupEditDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.CodeGroup"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.CodeGroup" /><span
									class="required">*</span> <form:input path="codeGroup" id="codeGroup"
										class="textbox" maxlength="50" onkeyup="doAjaxPost()"/></td>

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
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
		

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="codeGroupEditValues" items="${codeGroupEditValues}">
                      <table>
						<tr>
							<td colspan="4" class="alert-warning" id="codeGroupDuplMessage"
								style="display: none; width: 300px; height: 25px;"></td>
						</tr>
					</table>
					
					
						<form:form method="post" action="codeGroupUpdate.mnt"
							commandName="codeGroupCommand" id="editForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="updateAssetTypeDuplicate"
											items="${updateAssetTypeDuplicate}">
											<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.CodeGroup"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="codeGroup_IdEdit" />
								<tr>
									<td><spring:message code="label.CodeGroup" /><span
										class="required">*</span></td>
									<td><form:input path="codeGroupEdit" id="codeGroupEdit" class="textbox" onkeyup="doAjaxPostEdit()"/></td>
								</tr>
								
								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" />
										</c:when>
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
