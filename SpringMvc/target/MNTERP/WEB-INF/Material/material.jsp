<!-- author pvenkateswarlu -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->

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

						$('#sumbnid')
								.click(
										function(event) {
											$("#material")
													.validate(
															{
																rules : {
																	materialCode : {
																		required : true
																	},
																	materialName : {
																		required : true
																	},
																	materialDescription : {
																		required : true
																	},
																	materialCategory : {
																		required : true
																	},
																	materialType : {
																		required : true
																	},
																	taxCatogery : {
																		required : true
																	},
																	uom : {
																		required : true
																	}
																},
																messages : {
																	materialCode : "<font style='color: red;'><b>Material Code is Required</b></font>",
																	materialName : "<font style='color: red;'><b>Material Name  is Required</b></font>",
																	materialDescription : "<font style='color: red;'><b>MaterialDescription is Required</b></font>",
																	materialType : "<font style='color: red;'><b>Material Type is Required</b></font>",
																	taxCatogery : "<font style='color: red;'><b>Tax Catogeryis Required</b></font>",
																	uom : "<font style='color: red;'><b>UOM is Required</b></font>"

																},
															});
										});
						$('#updateBtn')
								.click(
										function(event) {
											$("#materialFormEdit")
													.validate(
															{
																rules : {
																	materialCodeEdit : {
																		required : true
																	},
																	materialNameEdit : {
																		required : true
																	},
																	materialCategoryEdit : {
																		required : true
																	},
																	materialCategory : {
																		required : true
																	},
																	materialType : {
																		required : true
																	},
																	taxCatogery : {
																		required : true
																	},
																	uom : {
																		required : true
																	}

																},
																messages : {
																	materialCodeEdit : "<font style='color: red;'><b>Material Code is Required</b></font>",
																	materialNameEdit : "<font style='color: red;'><b>Material Name  is Required</b></font>",
																	materialDescription : "<font style='color: red;'><b>MaterialDescription is Required</b></font>",
																	materialType : "<font style='color: red;'><b>Material Type is Required</b></font>",
																	taxCatogery : "<font style='color: red;'><b>Tax Catogeryis Required</b></font>",
																	uom : "<font style='color: red;'><b>UOM is Required</b></font>"
																},
															});

										});

					});
</script>


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
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Material</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${materialValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit"></s:message> </a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search"></s:message></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add"></s:message></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<!-- ============================================Begin MaterialSearch ======================================================= -->

					<form:form action="materialSearch.mnt" method="get"
						commandName="materialAdd">
						<table class="tableGeneral">
							<tr>

								<td colspan="3"><c:forEach var="materialUpadted"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>

								<td colspan="3"><c:forEach var="materialUpadted"
										items="${materialUpadte}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${materialUpadted}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td><s:message code="label.materialCode"></s:message></td>

								<td><form:select path="material_Id" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${materialSearchIds}" />
									</form:select></td>

								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" "/></td>
							</tr>
 --%>
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
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>

						</table>
					</form:form>
					<!-- ============================================End Search ====================================== -->
					<c:forEach var="materialSearch" items="${materialSearch}">
						<c:set var="g" value="${materialSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<!-- ============================================Begin DisplayTable ================================================= -->
						<display:table id="materialRow" name="materialSearch"
							requestURI="materialSearch.mnt" pagesize="5" class="table">

							<display:column property="materialCodeName"
								titleKey="label.materialCode" sortable="true"></display:column>
							<display:column property="materialName"
								titleKey="label.materialName" sortable="true" />
							<display:column property="materialCategoryName"
								titleKey="label.materialCategory" sortable="true" />
							<display:column property="uomName" titleKey="label.uom"
								media="html" sortable="true" />
							<display:column property="taxCatogeryName"
								titleKey="label.taxCategory" media="html" sortable="true" />

							<display:column property="materialTypeName"
								titleKey="label.materialType" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
								<a
									href="materialEditHome.mnt?materialCodeEdit=<c:out value="${materialRow.material_Id}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>

							<display:column titleKey="label.delete">
								<a
									href="materialDelete.mnt?materialCodeDelete=<c:out value="${materialRow.material_Id}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

							<display:setProperty name="paging.banner.group_size" value="3" />

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>
					</c:if>

				</div>
			</div>
			<!-- ============================================End DisplayTable ================================================= -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">


					<!--=================== ============================================Begin MaterialAdd================================================= -->

					<form:form action="materialAdd.mnt" id="material" name="material"
						method="POST" commandName="materialAdd">

						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${materialDuplicate }">
										<div class="alert-warning">
											<font color="red"> <c:out value="${a}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="aid" />


							<tr>
								<td><s:message code="label.materialCode" /><font
									color="red">*</font></td>
								<td><form:input path="materialCode" id="materialCode"
										class="textbox" /></td>
							</tr>

							<tr>
								<td><s:message code="label.materialName" /><font
									color="red">*</font></td>
								<td><form:input path="materialName" id="materialName"
										class="textbox" /><font color="red"> <form:errors
											path="materialName"></form:errors></font></td>
							</tr>
							<tr>
								<td><s:message code="label.materialDescription"></s:message></td>
								<td><form:input path="materialDescription"
										id="materialDescription" class="textbox" /><font color="red">
										<form:errors path="materialDescription"></form:errors>
								</font></td>
							</tr>
							<tr>
								<td><s:message code="label.materialCategory"></s:message></td>
								<td><form:select path="materialCategory"
										id="materialCategory" class="select">
										<form:option value="0">--Select--</form:option>

										<form:options items="${materialCategory}" />
									</form:select> <font color="red"> <form:errors path="materialCategory"></form:errors></font></td>
							</tr>
							<tr>
								<td><s:message code="label.materialType"></s:message></td>
								<td><form:select path="materialType" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${materialType}" />
									</form:select><font color="red"> <form:errors path="materialType"></form:errors></font>
								</td>
							</tr>
							<tr>
								<td><s:message code="label.taxCategory"></s:message></td>
								<td><form:select path="taxCatogery" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${taxCategory}" />
									</form:select><font color="red"> <form:errors path="taxCategory"></form:errors></font>
								</td>
							</tr>
							<form:hidden path="aid" id="aid" />
							<tr>
								<td><s:message code="label.uom"></s:message></td>
								<td><form:select path="uom" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${uom}" />
									</form:select><font color="red"> <form:errors path="uom"></form:errors></font></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									value="<s:message code="label.save"/>" class="btn btn-primary"
									id="sumbnid" /><input type="reset" class="btn btn-primary"
									value="<s:message code="label.reset"/>" /></td>
							</tr>
						</table>
					</form:form>
					<!-- ============================================End MaterialAdd==================================================================================== -->
					<!-- </td></tr></table>	 -->

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<!-- ============================================Begin MaterialEdit==================================================================================== -->
					<c:forEach var="materialEditValues" items="${materialValues }">
						<form:form action="materialUpdate.mnt" name="materialFormEdit"
							id="materialFormEdit" method="POST" commandName="materialAdd">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${materialEditDuplicate }">
											<div class="alert-warning">
												<font color="red"> <c:out value="${duplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="materialIdEdit" />
								<tr>
									<td><s:message code="label.materialCode" /><font
										color="red">*</font></td>
									<td><form:input path="materialCodeEdit"
											id="materialCodeEdit" class="textbox" /></td>
								</tr>

								<tr>
									<td><s:message code="label.materialName" /><font
										color="red">*</font></td>
									<td><form:input path="materialNameEdit" id="materialName"
											class="textbox" /> <form:errors path="materialName"></form:errors></td>
								</tr>
								<tr>
									<td><s:message code="label.materialCategory"></s:message></td>
									<td><form:select path="materialCategoryEdit"
											id="materialCategory" class="select">

											<form:options items="${materialCategory}" />
										</form:select></td>
								</tr>

								<tr>
									<td><s:message code="label.materialType"></s:message></td>
									<td><form:select path="materialTypeEdit" class="select">
											<%-- <form:option value="<c:out value='${materialEditValues.materialType}'/>"><c:out value="${materialEditValues.materialTypeName}"/></form:option> --%>
											<form:options items="${materialType}" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.taxCategory"></s:message></td>
									<td><form:select path="taxCatogeryEdit" class="select">

											<form:options items="${taxCategory}" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.uom"></s:message></td>
									<td><form:select path="uomEdit" class="select">

											<form:options items="${uom}" />
										</form:select></td>
								</tr>

								<tr>
									<td colspan="2"><input type="submit"
										value="<s:message code="label.update"/>"
										class="btn btn-primary" id="updateBtn" /><input type="reset"
										value="<s:message code="label.reset"/>"
										class="btn btn-primary" /></td>
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
				<!-- ============================================End MaterialEdit==================================================================================== -->
			</div>
		</div>
</body>
</html>




