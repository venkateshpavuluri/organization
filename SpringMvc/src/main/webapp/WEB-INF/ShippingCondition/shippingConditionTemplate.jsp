<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'shippingConditionTemplate.jsp' starting page</title>

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
						$('#' + "sumbtnid")
								.click(
										function(event) {
											//alert($('#shipId').val());
											$("#addShipForm")
													.validate(
															{
																rules : {
																	shippingCondition : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																},
																messages : {
																	shippingCondition : {
																		required : "<font style='color: red;'><b>Shipping Condition is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	}
																},

															});
										});

						$('#updateId')
								.click(
										function(event) {

											$("#updateShipForm")
													.validate(
															{
																rules : {
																	shippingConditionEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	shippingConditionEdit : {
																		required : "<font style='color: red;'><b>Shipping Condition is Required</b></font>",
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

		if (document.getElementById("scId").value == 1) {
			//alert("Hai");
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

		if (document.getElementById("scEditId").value == 1) {
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
		$('#sumbnasid').click(function(e) {
			document.getElementById("asId").value = 1;
			//alert(document.getElementById("asId").value);
		});
	});
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
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Shipping Condition</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="shipCndBeanEdit" items="${shipCndBeanEdit}">
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
				<div align="left">
					<form:form method="get" action="shippingCndSearch.mnt"
						commandName="shippingCnd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.ShippingCondition" />
											<spring:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:forEach var="fail" items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.ShippingCondition" />
											<spring:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach var="shippingDel" items="${shippingDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.ShippingCondition" />
											<spring:message code="label.deleteSuccess" />

										</div>
									</c:forEach> <c:forEach var="shippingDelErr" items="${shippingDelErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.ShippingCondition" />
											<spring:message code="label.deleteFail" />

										</div>
									</c:forEach> <c:forEach var="shipUpdate" items="${shipUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.ShippingCondition" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach>
									<c:forEach var="shipUpdateErr" items="${shipUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="llabel.ShippingCondition" />
											<spring:message code="label.updateFail" />

										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<%-- <form:option value="0">--Select--</form:option> --%>
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="shippingCnd.operations">
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


						</table>
					</form:form>

					<c:if test="${shipCndBean!=null }">
						<display:table name="shipCndBean" id="shipList" class="table"
							requestURI="shippingCndSearch.mnt" pagesize="5">
							<display:column property="shippingConditionId" sortable="true"
								title="shippingConditionId" media="none" />
							<display:column property="shippingCondition" sortable="true"
								titleKey="label.ShippingCondition" media="html" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="shipCndEdit.mnt?shipCndId=<c:out value="${shipList.shippingConditionId}"/> "><img
											src="images/Edit.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete}">
										<a
											href="shipCndDelete.mnt?shipCndId=<c:out value="${shipList.shippingConditionId}"/> "
											onclick="return confirm('Do You Want To Delete This Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>

							</display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>

					</c:if>

				</div>

			</div>
			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="shippingCndAdd.mnt" method="POST"
						commandName="shippingCnd" id="addShipForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="ShipCndDuplicate"
										items="${ShipCndDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.ShippingCondition" />
											<spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="scId" />
							<tr>
								<td><spring:message code="label.ShippingCondition" /><span
									class="required">*</span> <form:input path="shippingCondition"
										cssClass="textbox" id="shipId" maxlength="50"/></td>
							</tr>


							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save}">
											<input type="submit"
												value="<spring:message code="label.save"/>" id="sumbtnid"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.save"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose> <input type="reset"
									value='<spring:message code="label.reset"/>'
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>



			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="shipCndBeanEditValues" items="${shipCndBeanEdit}">
						<form:form method="post" action="shipCndUpdate.mnt"
							commandName="shippingCnd" id="updateShipForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="updateShipCndDuplicate"
											items="${updateShipCndDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><spring:message code="label.warning" /></strong>
												<spring:message code="label.ShippingCondition" />
												<spring:message code="label.duplicateCheck"></spring:message>
											</div>
										</c:forEach></td>
								</tr>



								<form:hidden path="scEditId" />
								<form:hidden path="shippingConditionEditId" />
								<tr>
									<td><spring:message code="label.ShippingCondition" /><span
										class="required">*</span></td>
									<td><form:input path="shippingConditionEdit"
											cssClass="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${update}">
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateId" />
											</c:when>
											<c:otherwise>
												<input type="submit"
													value="<s:message code="label.update"/> "
													class="btn btn-danger" disabled="disabled" id="sumbnid" />
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
