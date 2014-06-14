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
<script type="text/javascript" src="js/MntValidator.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#sumbnid')
								.click(
										function(event) {
											
											$("#deliveryType")
													.validate(
															{
																rules : {
																	deliveryType : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	}
																},
																messages : {
																	deliveryType : {
																		
																		required: "<font style='color: red;'><b>Delivery Type is Required.</b></font>",
													                	
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		}
																	}

															});
										});

						$('#updateId')
								.click(
										function(event) {

											$("#deliveryTypeup")
													.validate(
															{
																rules : {
																	editDeliveryType : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	editDeliveryType :{
																		
																		required: "<font style='color: red;'><b>Delivery Type is Required.</b></font>",
													                	
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add,#search").click(function(e) {

			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

		});
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
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Delivery Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="dtvalues" items="${dtvalues}">
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

					<form:form action="DeliveryTypeSearch.mnt" method="GET"
						commandName="DeliveryTypeCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">
						
						<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.deliverytype"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.deliverytype"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										<c:forEach var="deliveryTypedelete"
										items="${deliveryTypedelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.deliverytype"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="deliveryTypedeleteError"
										items="${deliveryTypedeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.deliverytype"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="deliveryTypeUpdate"
										items="${deliveryTypeUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.deliverytype"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="deliveryTypeUpdateError"
										items="${deliveryTypeUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.deliverytype"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
							
						
							
							
							</td></tr>
							
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="DeliveryTypeCommand.operations">
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
								 
								<td>
							<c:choose>
								<c:when test="${search}">	
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></c:otherwise></c:choose>
									</td>
							</tr>

						</table>
					</form:form>
				    <c:forEach var="dt" items="${dtvalue}">
                              <c:set var="as" value="${dt}"></c:set>
					          </c:forEach>
						      <c:if test="${as!=null }">	
					<display:table id="DeliveryType" name="DeliveryType"
						requestURI="DeliveryTypeSearch.mnt" pagesize="5" class="table">
						<display:column property="deliveryType"
							titleKey="label.deliverytype" media="html" sortable="true" />
						<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit}">
							<a
								href="DeliveryTypeIdEdit.mnt?DeliveryTypeIdEdit=<c:out value="${DeliveryType.deliveryType_Id}"/>"
								style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a>
								</c:when>
								<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
						</display:column>
						<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
							<a
								href="DeliveryTypeIdDelete.mnt?DeliveryTypeIdDelete=<c:out value="${DeliveryType.deliveryType_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
					
							
								<c:otherwise>
							<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
						</display:column>
						<display:setProperty name="paging.banner.placement" value="bottom" />
						
					</display:table>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="DeliveryTypeAdd.mnt" method="POST"
						commandName="DeliveryTypeCommand" id="deliveryType">

						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach
										var="addDeliveryTypeDuplicate"
										items="${addDeliveryTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
										<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.deliverytype"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.deliverytype" /><span
									class="required">*</span>
								<form:input path="deliveryType" id="deliveryType"
										class="textbox" maxlength="50"/></td>
							</tr>
							<tr>
								<td colspan="2">
								<c:choose>
								<c:when test="${save}">
								<input type="submit"
									value="<spring:message
								code="label.save" />"
									class="btn btn-primary" id="sumbnid" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>"
									class="btn btn-danger" /></c:otherwise>
								</c:choose>
								<input type="reset"
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
					<c:forEach var="dtValues" items="${dtvalues}">
						<form:form action="deliveryTypeEdit.mnt" method="POST"
							commandName="DeliveryTypeCommand" id="deliveryTypeup">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach
											var="addDeliveryTypeDuplicate"
											items="${addDeliveryTypeDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.deliverytype"/> <spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td></td>
									<td><form:hidden path="deliveryType_Id"
											id="deliveryType_Id" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.deliverytype" /><span
										class="required">*</span>
									<form:input path="editDeliveryType"
											id="editDeliveryType" class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${update}">
									<input type="submit"
										value="<spring:message
								code="label.update" />"
										class="btn btn-primary" id="updateId" />
										</c:when>
										<c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
										</c:otherwise></c:choose>
										
										</td>
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




