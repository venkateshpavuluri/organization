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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						jQuery.validator.addMethod("alphabets", function(value,
								element) {
							return this.optional(element)
									|| /^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});
						
						jQuery.validator.addMethod("alphanumeric", function(value,
								element) {
							return this.optional(element)
									|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});

						jQuery.validator.addMethod("specialcharacters",
								function(value, element) {
									return this.optional(element)
											|| /^[0-9a-zA-Z&_ ]+$/.test(value);
								});

						$('#subid')
								.click(
										function(event) {

											$("#ProfitCenterForm")
											
													.validate(
															
															{
																
																rules : {
																	profitCenter : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																		
																	},
																},
																messages : {

																	profitCenter : {

																		required : "<font style='color: red;'><b>Profit Center is Required.</b></font>",

																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		
																	}
																},

															});
										});

						$('#updateProfit')
								.click(
										function(event) {

											$("#profitCenterUpdate")
													.validate(
															{
																rules : {
																	profitCenterEdit : {
																		required : true,
																		alphabets :true,
																		specialcharacters :true
																		
																	},
																},
																messages : {
																	profitCenterEdit : {

																		required : "<font style='color: red;'><b>Profit Center is Required.</b></font>",
																		
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"									

																		
																	}
																},

															});
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
		$('#search,#add').click(function(e) {
			$('#edit').hide();

		});
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Profit Center</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="ProfitCentervalues" items="${ProfitCentervalues}">
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
					<form:form action="ProfitCenterSearch.mnt" method="get"
						commandName="ProfitCenteradd" name="addform">
						<table class="tableGeneral">
						
						
					
							<tr>
								<td colspan="2"><c:forEach var="ProfitCenterAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.profitCenter"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.profitCenter"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="ProfitCenterUpdate"
										items="${ProfitCenterUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.profitCenter"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="ProfitCenterUpdateError"
										items="${ProfitCenterUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.profitCenter"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="ProfitCenterdelete"
										items="${ProfitCenterdelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.profitCenter"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="ProfitCenterdeleteError"
										items="${ProfitCenterdeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.profitCenter"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="ProfitCenteradd.operations">
										<select class="select" name="operations">
											<option value="<spring:message code='assignedOperator'/>">
												<spring:message code="label.equalsTo" />
											</option>
											<option value="<spring:message code='notequalsOperator'/>">
												<spring:message code="label.notEqualsTo" />
											</option>
											<option value="<spring:message code='beginsWithOperator'/>">
												<spring:message code="label.beginsWith" />
											</option>
											<option value="<spring:message code='endsWithOperator'/>">
												<spring:message code="label.endsWith" />
											</option>
											<option value="<spring:message code='containsOperator'/>">
												<spring:message code="label.contains" />
											</option>
										</select>
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /> <c:set
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
										<c:when test="${true}"><input type="submit"
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
					

					<c:if test="${agtvalues!=null }">
						<display:table id="ProfitCenter" name="ProfitCenter"
							requestURI="ProfitCenterSearch.mnt" pagesize="5" class="table">


							<%-- <display:column property="ProfitCenter_Id" title="ProfitCenter_Id" media="html" sortable="true" ></display:column> --%>
							<display:column property="profitCenter" titleKey="label.profitCenter"
								media="html" sortable="true" />



							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${true }">
								<a
									href="ProfitCenterEditHome.mnt?profitCenterEdit=<c:out 

								value="${ProfitCenter.profitCenterId}"/>"
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
							<c:when test="${true}">
							
								<a
									href="ProfitCenterDelete.mnt?profitCenterDelete=<c:out value="${ProfitCenter.profitCenterId}"/>"
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
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

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

					<form:form action="ProfitCenteradd.mnt" method="POST"
						commandName="ProfitCenteradd" id="ProfitCenterForm">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach var="addProfitCenterDuplicate"
										items="${addProfitCenterDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.profitCenter"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.profitCenter" /><font
									color="red">*</font> <form:input path="profitCenter"
										id="profitCenter" class="textbox" maxlength="50"/></td>

							</tr>
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${true}"><input type="submit"
									value="<spring:message
								code="label.save" />"
									class="btn btn-primary" id="subid" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose> <input type="reset"
									class="btn btn-primary"
									value="<spring:message
								code="label.reset" />" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="ProfitCentervalues" items="${ProfitCentervalues }">

						<form:form action="ProfitCenterUpdate.mnt" method="POST"
							commandName="ProfitCenteradd" id="profitCenterUpdate">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="editProfitCenterDuplicate"
											items="${editProfitCenterDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.profitCenter"/> <spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="profitCenterIdEdit"
									id="profitCenterIdEdit" />
								<tr>
									<td><spring:message code="label.profitCenter" /><font
										color="red">*</font></td>
									<td><form:input path="profitCenterEdit"
											id="profitCenterEdit" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${true}"><input type="submit"
										value="<spring:message
								code="label.update" />"
										class="btn btn-primary" id="updateProfit" /></c:when>
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




