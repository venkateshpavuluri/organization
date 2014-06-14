<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


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
																		required : true
																	},
																},
																messages : {
																	shippingCondition : "<font style='color: red;'><b>Shipping Condition is Required</b></font>"
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
																		required : true
																	},
																},
																messages : {
																	shippingConditionEdit : "<font style='color: red;'><b>Shipping Condition is Required</b></font>"
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
			alert(document.getElementById("asId").value);
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
								<td colspan="2"><c:forEach var="addShipCndsus"
										items="${param.addShipCndsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${addShipCndsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="shipCndUp"
										items="${param.shipCndUp}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${shipCndUp}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="deleteShipCnd"
										items="${param.deleteShipCnd}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${deleteShipCnd}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- 
							<tr>
								<td><spring:message code="label.ShippingCondition"/></td>
								<td><form:select path="shippingConditionId" Class="select">
										<form:option value="0">--All--</form:option>
										<form:options items="${shipCndSelect}" />
									</form:select></td>
								<td><input type="submit" value="<spring:message code="label.search"/>"
									class="btn btn-primary"></td>
							</tr> --%>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<%-- <form:option value="0">--Select--</form:option> --%>
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<%--  <form:option value="0">-Select-</form:option>  --%>
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>


						</table>
					</form:form>
					<c:forEach var="ship" items="${shipCndBean}">
						<c:set var="scd" value="${ship}"></c:set>
					</c:forEach>

					<c:if test="${scd!=null }">
						<display:table name="shipCndBean" id="shipList" class="table"
							requestURI="shippingCndSearch.mnt" pagesize="5">
							<display:column property="shippingConditionId" sortable="true"
								title="shippingConditionId" media="none" />
							<display:column property="shippingCondition" sortable="true"
								titleKey="label.ShippingCondition" media="html" />

							<display:column titleKey="label.edit">
								<a
									href="shipCndEdit.mnt?shipCndId=<c:out value="${shipList.shippingConditionId}"/> "><img
									src="images/Edit.jpg" width="20px" height="20px" /></a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="shipCndDelete.mnt?shipCndId=<c:out value="${shipList.shippingConditionId}"/> "
									onclick="return confirm('Do You Want To Delete This Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
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
											<font color="red"><c:out value="${ShipCndDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="scId" />
							<tr>
								<td><spring:message code="label.ShippingCondition" /><span
									class="required">*</span> <form:input path="shippingCondition"
										cssClass="textbox" id="shipId" /></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									value="<spring:message code="label.save"/>" id="sumbtnid"
									class="btn btn-primary" /><input type="reset"
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
												<font color="red"><c:out
														value="${updateShipCndDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="scEditId" />
								<form:hidden path="shippingConditionEditId" />
								<tr>
									<td><spring:message code="label.ShippingCondition" /><span
										class="required">*</span></td>
									<td><form:input path="shippingConditionEdit"
											cssClass="textbox" /></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateId" /></td>

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
