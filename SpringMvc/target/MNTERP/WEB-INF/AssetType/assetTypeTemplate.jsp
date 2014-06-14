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
<title>My JSP 'AssertTypeTemplate.jsp' starting page</title>
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
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {
											//alert($('#sdType').val());
											$('#addForm')
													.validate(
															{
																rules : {
																	assertTypeName : {
																		required : true
																	},
																},
																messages : {
																	assertTypeName : "<font style='color: red;'><b>Asset Type is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											var assetedit = $('#assetEditId')
													.val();
											//alert(assetedit);
											$('#editForm')
													.validate(
															{
																rules : {
																	assertTypeEditName : {
																		required : true
																	},

																},
																messages : {
																	assertTypeEditName : "<font style='color: red;'><b>Asset Type is Required</b></font>"
																},
															});

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
		<div class="PageTitle">Asset Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="assetTypeEdit" items="${assetTypeEdit}">
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
					<form:form method="get" action="assetTypeSearch.mnt"
						commandName="assertTypeAdd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addAssetsuccess"
										items="${param.addAssetsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${addAssetsuccess}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="updateAssetsuss"
										items="${param.updateAssetsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${updateAssetsuss}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="deleteAssetsus"
										items="${param.deleteAssetsus}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${deleteAssetsus}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<%--	<tr>
								<td><spring:message code="label.assetType" /></td>
								<td><form:select path="assertTypeId" cssClass="select">
										<form:option value="0">--All--</form:option>
										<form:options items="${assetTypeSelect}" />
									</form:select></td>
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>   --%>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">										
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
					<c:forEach var="asset" items="${assetTypeBean}">

						<c:set var="as" value="${asset}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">
						<display:table name="assetTypeBean" id="assetList" class="table"
							requestURI="assetTypeSearch.mnt" pagesize="5">
							<display:column property="assertTypeId" sortable="true"
								title="AssetTypeId" media="none" />
							<display:column property="assertTypeName" sortable="true"
								titleKey="label.assetType" media="html" />

							<display:column titleKey="label.edit">
								<a
									href="assetTypeEdit.mnt?assetTypeId=<c:out value="${assetList.assertTypeId}"/> "><img
									src="images/Edit.jpg" width="20px" height="20px" /></a>
							</display:column>
							<display:column titleKey="label.delete">
								<a
									href="assetTypeDelete.mnt?assetTypeId=<c:out value="${assetList.assertTypeId}"/> "
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
				<div align="left" class="TabbedPanelsContent">

					<form:form action="assertTypeAdd.mnt" id="addForm" method="POST"
						commandName="assertTypeAdd">
						<table class="tableGeneral">
							<form:hidden path="atId" />
							<tr>
								<td colspan="2"><c:forEach var="addAssetTypeDuplicate"
										items="${addAssetTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"> <c:out
												value="${addAssetTypeDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.assetType" /><span
									class="required">*</span> <form:input path="assertTypeName"
										class="textbox" id="assetTypeId" /></td>


							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /><input type="reset"
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
					<c:forEach var="assetTypeEditValues" items="${assetTypeEdit}">

						<form:form method="post" action="assetTypeUpdate.mnt"
							commandName="assertTypeAdd" id="editForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="updateAssetTypeDuplicate"
											items="${updateAssetTypeDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"> <c:out
													value="${updateAssetTypeDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="ateditId" id="ateditId" />
								<form:hidden path="assertTypeEditId" />
								<tr>
									<td><spring:message code="label.assetType" /><span
										class="required">*</span></td>
									<td><form:input path="assertTypeEditName"
											cssClass="textbox" id="assetEditId" /></td>

								</tr>
								<tr>
									<td colspan="2"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></td>

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
