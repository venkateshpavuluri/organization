<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'schedulingTemplate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
		$('#'+"sumbtnid").click(function(event) {
			//alert($('#sdType').val());
			$("#addForm").validate({
				rules : {
					shedulingType : {required : true,minlength: 2},
				},
				messages : {
				shedulingType : "<font style='color: red;'><b>Sheduling Type is Required</b></font>"
				},

			});
		});
		
		$('#updateId').click(function(event) {
			
			$("#updateForm").validate({
				rules : {
					shedulingEditType : {
						required : true
					},
				},
				messages : {
				shedulingEditType : "<font style='color: red;'><b>Sheduling Type is Required</b></font>"
				},

			});
		});
		
		

		if (document.getElementById("shdId").value == 1) {
			//alert("Hai");
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
			document.getElementById("asId").value = 1;
			alert(document.getElementById("asId").value);
		});
	});
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Sheduling Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="schedulingEditList" items="${schedulingEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit"/></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search"/></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add"/></a></li>
			</ul>



			<!-- Tab-2 -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form method="get" action="schedulingSearch.mnt"
						commandName="schedulingType">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="addSchedulingsus"
										items="${param.addSchedulingsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${addSchedulingsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="UpdateSchedulingsus"
										items="${param.UpdateSchedulingsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${UpdateSchedulingsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="DeleteSchedulingsus"
										items="${param.DeleteSchedulingsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${DeleteSchedulingsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<%-- <tr>
								<td><spring:message code="label.SchedulingType"/></td>
								<td><form:select path="shedulingTypeId" Class="select">
										<form:option value="0">--All--</form:option>
										<form:options items="${schedulingSelect}" />
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
					<c:forEach var="schduling" items="${schedulingList}">
						<c:set var="sch" value="${schduling}"></c:set>
					</c:forEach>

					<c:if test="${sch!=null }">
						<display:table name="schedulingList" id="schdList" class="table"
							requestURI="schedulingSearch.mnt" pagesize="5">
							<display:column property="shedulingTypeId" sortable="true"
								title="shedulingTypeId" media="none" />
							<display:column property="shedulingType" sortable="true"
								titleKey="label.SchedulingType" media="html" />

							<display:column titleKey="label.edit">
								<a
									href="schdulingEdit.mnt?schdulingId=<c:out value="${schdList.shedulingTypeId}"/> "><img
									src="images/Edit.jpg" width="20px" height="20px" /></a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="schdulingDelete.mnt?schdulingId=<c:out value="${schdList.shedulingTypeId}"/> "
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

					<form:form action="schedulingAdd.mnt" method="POST"
						commandName="schedulingType" id="addForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2" ><c:forEach var="SchedulingTypeDuplicate"
										items="${SchedulingTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${SchedulingTypeDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="shdId" />
							<tr>
								<td><spring:message code="label.SchedulingType"/><span class="required">*</span> <form:input
										path="shedulingType" cssClass="textbox" id="sdType" /></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="<spring:message code="label.save"/>"
									id="sumbtnid" class="btn btn-primary" /><input type="reset"
									value="<spring:message code="label.reset"/>" class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>


			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="schedulingEditList" items="${schedulingEditList}">
						<form:form method="post" action="schdulingUpdate.mnt"
							commandName="schedulingType" id="updateForm">
							<table class="tableGeneral">
							<tr>
								<td colspan="2" ><c:forEach var="updateSchdulingTypeDuplicate"
										items="${updateSchdulingTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${updateSchdulingTypeDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
								<form:hidden path="shedulingTypeEditId" />
								<tr>
									<td><spring:message code="label.SchedulingType"/><span class="required">*</span></td>
									<td><form:input path="shedulingEditType"
											cssClass="textbox" /></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updateId"/></td>

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
