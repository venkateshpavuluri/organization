<!-- author pvenkateswarlu -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->

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

											$("#material")
													.validate(
															{
																rules : {
																	materialCode : {
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	materialName : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},

																	materialCategory : {
																		required : true
																	},
																	materialType : {
																		required : true
																	},

																	shelfLifeUOM : {
																		required : true
																	},
																	uom : {
																		required : true
																	},
																	avgVolume : {
																		number : true
																	},

																	shelfLife : {
																		required : true,
																		number : true
																	},
																	reorderLevel : {
																		required : true,
																		number : true
																	},
																	maxDeliveryTime : {
																		number : true
																	},
																	maxDeliveryTimeUOM : {
																		number : true
																	},
																	avgLength : {
																		number : true
																	},
																	avgWeight : {
																		number : true
																	},
																	avgHeight : {
																		number : true
																	}
																},
																messages : {
																	materialCode : {

																		required : "<font style='color: red;'><b>Material Code is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},
																	materialName : {
																		required : "<font style='color: red;'><b>Material Name is Required.</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},
																	materialCategory : "<font style='color: red;'><b>Material Category is Required</b></font>",
																	materialType : "<font style='color: red;'><b>Material Type is Required</b></font>",

																	uom : "<font style='color: red;'><b>UOM is Required</b></font>",
																	avgVolume : "<font style='color: red;'><b>Average Volume Must Be Number</b></font>",
																	dimension : "<font style='color: red;'><b>Dimension Must Be Number</b></font>",
																	shelfLife : {
																		required : "<font style='color: red;'><b>Shelf Life is Required </b></font>",
																		number : "<font style='color: red;'><b>Shelf Life is Must be Number </b></font>"
																	},
																	reorderLevel : {

																		required : "<font style='color: red;'><b>Reorder  Level is Required</b></font>",
																		number : "<font style='color: red;'><b>Reorder  Level is Must Be Number</b></font>"
																	},
																	maxDeliveryTime : "<font style='color: red;'><b>MaxDelivery Time Must Be Number</b></font>",
																	maxDeliveryTimeUOM : "<font style='color: red;'><b>MaxDeliveryTime UOM Must Be Number</b></font>",
																	avgLength : "<font style='color: red;'><b>Average Length Must Be Number</b></font>",
																	avgWeight : "<font style='color: red;'><b>Average Weight Must Be Number</b></font>",
																	avgHeight : "<font style='color: red;'><b>Average Height Must Be Number</b></font>",
																	shelfLifeUOM : "<font style='color: red;'><b>Shelf Life UOM Required </b></font>"

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
																		required : true,
																		alphanumeric : true,
																		specialcharacters : true

																	},
																	materialNameEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	materialCategoryEdit : {
																		required : true
																	},

																	materialTypeEdit : {
																		required : true
																	},

																	uomEdit : {
																		required : true
																	},
																	avgVolume : {
																		number : true
																	},

																	shelfLifeEdit : {
																		required : true,
																		number : true
																	},
																	shelfLifeUOMEdit : {
																		required : true
																	},
																	reorderLevelEdit : {
																		required : true,
																		number : true
																	},
																	maxDeliveryTimeEdit : {
																		number : true
																	},
																	maxDeliveryTimeUOMEdit : {
																		number : true
																	},
																	avgLengthEdit : {
																		number : true
																	},
																	avgWeightEdit : {
																		number : true
																	},
																	avgHeightEdit : {
																		number : true
																	},
																	avgVolumeEdit : {
																		number : true
																	}

																},
																messages : {
																	materialCodeEdit : {
																		required : "<font style='color: red;'><b>Material Code is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",

																	},
																	materialNameEdit : {

																		required : "<font style='color: red;'><b>Material Name is Required.</b></font>",

																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},
																	materialCategoryEdit : "<font style='color: red;'><b>Material Category is Required</b></font>",
																	materialTypeEdit : "<font style='color: red;'><b>Material Type is Required</b></font>",

																	uomEdit : "<font style='color: red;'><b>UOM is Required</b></font>",
																	avgVolumeEdit : "<font style='color: red;'><b>Average Volume Must Be Number</b></font>",
																	dimensionEdit : "<font style='color: red;'><b>Dimension Must Be Number</b></font>",
																	shelfLifeEdit : {
																		required : "<font style='color: red;'><b>Shelf Life is Required </b></font>",
																		number : "<font style='color: red;'><b>Shelf Life is Must Be Number</b></font>"
																	},
																	reorderLevelEdit : {
																		required : "<font style='color: red;'><b>Reorder Level Required and Must Be Number</b></font>",
																		number : "<font style='color: red;'><b>Reorder Level is Must Be Number</b></font>"
																	},
																	maxDeliveryTimeEdit : "<font style='color: red;'><b>MaxDelivery Time Must Be Number</b></font>",
																	maxDeliveryTimeUOMEdit : "<font style='color: red;'><b>MaxDeliveryTime UOM Must Be Number</b></font>",
																	avgLengthEdit : "<font style='color: red;'><b>Average Length Must Be Number</b></font>",
																	avgWeightEdit : "<font style='color: red;'><b>Average Weight Must Be Number</b></font>",
																	avgHeightEdit : "<font style='color: red;'><b>Average Height Must Be Number</b></font>",
																	shelfLifeUOMEdit : "<font style='color: red;'><b>Shelf Life UOM Required</b></font>"
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
		$("#tabs,#tabss").tabs();
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
		$('#search,#add').click(function(e) {
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

								<td colspan="3"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success" /> </strong>
											<s:message code="label.material" />
											<s:message code="label.saveSuccess" />

										</div>
									</c:forEach>
									<c:forEach items="${param.listw}">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error" /> </strong>
											<s:message code="label.material" />
											<s:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${materialUpadte}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success" /> </strong>
											<s:message code="label.material" />
											<s:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${materialUpadteError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error" /> </strong>
											<s:message code="label.material" />
											<s:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${materialDelete}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success" /> </strong>
											<s:message code="label.material" />
											<s:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${materialDeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error" /> </strong>
											<s:message code="label.material" />
											<s:message code="label.deleteFail" />
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
									</form:select> <s:bind path="materialAdd.operations">
										<select class="select" name="operations">
											<option value="<s:message code='assignedOperator'/>">
												<s:message code="label.equalsTo" />
											</option>
											<option value="<s:message code='notequalsOperator'/>">
												<s:message code="label.notEqualsTo" />
											</option>
											<option value="<s:message code='beginsWithOperator'/>">
												<s:message code="label.beginsWith" />
											</option>
											<option value="<s:message code='endsWithOperator'/>">
												<s:message code="label.endsWith" />
											</option>
											<option value="<s:message code='containsOperator'/>">
												<s:message code="label.contains" />
											</option>
										</select>
									</s:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<c:set var="save" value="true"></c:set>
								<c:set var="edit" value="true"></c:set>
								<c:set var="delete" value="true"></c:set>
								<c:set var="update" value="true"></c:set>
								<c:set var="search" value="true"></c:set>
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
										<c:when test="${privileges eq messageup }">
											<c:set var="update" value="true"></c:set>
										</c:when>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${search }">


										<td><input type="submit"
											value="<s:message code="label.search"/>"
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" disabled="disabled"
											value="<s:message code="label.search"/>"
											class="btn btn-primary" /></td>
									</c:otherwise>
								</c:choose>
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
							<display:column property="materialTypeName"
								titleKey="label.materialType" sortable="true" />
							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit}">


										<a
											href="materialEditHome.mnt?materialCodeEdit=<c:out value="${materialRow.material_Id}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px" height="20px" />
										</a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete }">
										<a
											href="materialDelete.mnt?materialCodeDelete=<c:out value="${materialRow.material_Id}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" width="20px"
											height="20px" /></a>
									</c:otherwise>

								</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

							<display:setProperty name="paging.banner.group_size" value="3" />

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>
					</c:if>
					<c:set var="f" value="${materialSearchNoData}"></c:set>

					<c:if test="${f!=null}">
						<c:out value="${f}"></c:out>
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
											<strong><s:message code="label.warning" /></strong>
											<s:message code="label.materialName" />
											<s:message code="label.duplicateCheck" />
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="aid" />


							<tr>
								<td><s:message code="label.materialCode" /><font
									color="red">*</font></td>
								<td><form:input path="materialCode" id="materialCode"
										class="textbox" maxlength="20" /></td>
								<td><s:message code="label.avgVolume" /></td>
								<td><form:input path="avgVolume" id="avgVolume"
										class="textbox" /></td>


							</tr>

							<tr>
								<td><s:message code="label.materialName" /><font
									color="red">*</font></td>
								<td><form:input path="materialName" id="materialName"
										class="textbox" maxlength="50" /></td>
								<td><s:message code="label.weightUOM" /></td>
								<td><form:select path="weightUOM" id="weightUOM"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uom}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.materialDescription"></s:message></td>
								<td><form:textarea path="materialDescription"
										id="materialDescription" class="textbox" maxlength="250" /></td>
								<td><s:message code="label.heightUOM" /></td>
								<td><form:select path="heightUOM" id="heightUOM"
										class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${uom}" />
									</form:select></td>

							</tr>
							<tr>
								<td><s:message code="label.materialCategory" /><font
									color="red">*</font></td>
								<td><form:select path="materialCategory"
										id="materialCategory" class="select">
										<form:option value="">--Select--</form:option>

										<form:options items="${materialCategory}" />
									</form:select></td>

								<td><s:message code="label.lengthUOM" /></td>
								<td><form:select path="lengthUOM" id="lengthUOM"
										class="select">
										<form:option value="">--Selcet--</form:option>
										<form:options items="${uom}" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.materialType" /><font
									color="red">*</font></td>
								<td><form:select path="materialType" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${materialType}" />
									</form:select></td>

								<td><s:message code="label.dimension" /></td>
								<td><form:input path="dimension" id="dimension"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.taxCategory" /></td>
								<td><form:select path="taxCatogery" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${taxCategory}" />
									</form:select></td>
								<td><s:message code="label.shelfLife" /><font color="red">*</font></td>
								<td><form:input path="shelfLife" id="shelfLife"
										class="textbox" maxlength="50" /></td>

							</tr>
							<form:hidden path="aid" id="aid" />
							<tr>
								<td><s:message code="label.uom" /><font color="red">*</font></td>
								<td><form:select path="uom" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uom}" />
									</form:select></td>

								<td><s:message code="label.shelfLifeUOM" /><font
									color="red">*</font></td>
								<td><form:select path="shelfLifeUOM" id="shelfLifeUOM"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uom}" />
									</form:select></td>


							</tr>
							<tr>
								<td><s:message code="label.active" /></td>
								<td><form:select path="active" cssClass="select">

										<form:option value="0">true</form:option>
										<form:option value="1">false</form:option>
									</form:select></td>

								<td><s:message code="label.reorderLevel" /><font
									color="red">*</font></td>
								<td><form:input path="reorderLevel" id="reorderLevel"
										class="textbox" maxlength="50" /></td>

							</tr>
							<tr>
								<td><s:message code="label.salesUOM" /></td>
								<td><form:select path="salesUOM" cssClass="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uom }" />
									</form:select></td>

								<td><s:message code="label.maxDeliveryTime" /></td>
								<td><form:input path="maxDeliveryTime" id="maxDeliveryTime"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><s:message code="label.purchaseUOM" /></td>
								<td><form:select path="purchaseUOM" cssClass="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uom }" />
									</form:select></td>

								<td><s:message code="label.maxDeliveryTimeUOM" /></td>
								<td><form:select path="maxDeliveryTimeUOM"
										id="maxDeliveryTimeUOM" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uom }" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.avgWeight" /></td>
								<td><form:input path="avgWeight" id="avgWeight"
										cssClass="textbox" maxlength="50" /></td>

								<td><s:message code="label.alternateUOM" /></td>
								<td><form:select path="alternateUOM" id="alternateUOM"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${uom }" />
									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.avgHeight" /></td>
								<td><form:input path="avgHeight" id="avgHeight"
										cssClass="textbox" maxlength="50" /></td>

								<td><s:message code="label.avgLength" /></td>
								<td><form:input path="avgLength" id="avgLength"
										cssClass="textbox" maxlength="50" /></td>
							</tr>
						</table>
						<div id="tabss" align="center">
							<ul>

								<li><a href="#tabss1"><s:message
											code="label.materialInspct" /></a></li>

							</ul>
							<!-- Tab-1 -->

							<div align="center">
								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

								<!-- <div align="center"> -->

								<script>
									var btrfqid = 1;
									$(function() {

										/* var currentText = $(this).find(":selected").text(); */

										var instypeid = $("#inspectiontypeid"), inspct = $("#inspectionpct"), serialc = $("#serialcontrol"), skip = $("#skip"), samproc = $("#samplingproc"), active = $("#activemi"), hiddenrfqID = $("#hiddenIdrfqPopUp"),

										allFields = $([]).add(instypeid).add(
												inspct).add(serialc).add(skip)
												.add(samproc).add(active).add(
														hiddenrfqID), tips = $(".validateTips");

										function updateTips(t) {
											tips.text(t).addClass(
													"ui-state-highlight");
											setTimeout(function() {
												tips.removeClass(
														"ui-state-highlight",
														1500);
											}, 500);
										}

										function checkLength(o, n, min, max) {
											if (o.val().length > max
													|| o.val().length < min) {
												o.addClass("ui-state-error");
												updateTips("Length of " + n
														+ " must be between "
														+ min + " and " + max
														+ ".");
												return false;
											} else {
												return true;
											}
										}
										function checkLength1(o, n) {
											if (o.val() == "") {
												o.addClass("ui-state-error");
												updateTips(n + " is Required");
												return false;
											} else {
												return true;
											}
										}

										function checkRegexp(o, regexp, n) {
											if (!(regexp.test(o.val()))) {
												o.addClass("ui-state-error");
												updateTips(n);
												return false;
											} else {
												return true;
											}
										}

										$("#dialog-form-Rfq")
												.dialog(
														{
															autoOpen : false,
															height : 250,
															width : 350,
															modal : true,
															buttons : {
																Submit : function() {
																	var bValid1 = true;
																	allFields
																			.removeClass("ui-state-error");
																	bValid1 = bValid1
																			&& checkLength1(
																					instypeid,
																					"Inspection Type");
																	bValid1 = bValid1
																			&& checkRegexp(
																					inspct,
																					/^([0-9.])+$/i,
																					"Inspection PCT is Required And Must be a Number");

																	bValid1 = bValid1
																			&& checkLength1(
																					serialc,
																					"SerialControl");

																	bValid1 = bValid1
																			&& checkLength1(
																					skip,
																					"Skip");
																	bValid1 = bValid1
																			&& checkLength1(
																					samproc,
																					"Sample Proc");
																	bValid1 = bValid1
																			&& checkLength1(
																					active,
																					"Active");

																	if (bValid1) {
																		//alert("hiddenid"+hiddenID.val());

																		if (hiddenrfqID
																				.val() == "0"
																				|| hiddenrfqID
																						.val() == "") {

																			$(
																					"#RfqAdd tbody")
																					.append(
																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='inspectionTypeId' id='inspectiontypeid"
																									+ btrfqid
																									+ "' value="
																									+ instypeid
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='inspectionName' id='inspectionName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#inspectiontypeid :selected')
																											.text()
																									+ "'"
																									+ " </td>"
																									+ "<td><input type='text' name='inspectionPct' id='inspectionpct"
																									+ btrfqid
																									+ "' value="
																									+ inspct
																											.val()
																									+ "  class='textbox'readonly/></td>"

																									+ "<td><input type='hidden' name='serialControl' id='serialcontrol"
																									+ btrfqid
																									+ "' value="
																									+ serialc
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='serialcontrolName' id='serialcontrolName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#serialcontrol :selected')
																											.text()
																									+ "'"
																									+ "</td>"
																									+ "<td><input type='hidden' name='skip' id='skip"
																									+ btrfqid
																									+ "' value="
																									+ skip
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='skipName' id='skipName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#skip :selected')
																											.text()
																									+ "'"
																									+ "</td>"
																									+ "<td><input name='sampleProc' id='samplingproc"
																									+ btrfqid
																									+ "' value="
																									+ samproc
																											.val()
																									+ " class='textbox'readonly/></td>"

																									+ "<td><input type='hidden' name='activemi' id='activemi"
																									+ btrfqid
																									+ "' value="
																									+ active
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='activeName' id='activeName"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#activemi :selected')
																											.text()
																									+ "'"
																									+ "</td>"

																									+ "<td><a href='#'  onclick='editRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																									+ "<td><a href='#'  onclick='removeRfq("
																									+ btrfqid
																									+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																									+ "</tr>");
																			$(
																					'#valueForSubData')
																					.val(
																							btrfqid);
																			btrfqid++;
																			$(
																					this)
																					.dialog(
																							"close");
																		}

																		if (hiddenrfqID
																				.val() != "0") {
																			$(
																					'#inspectiontypeid'
																							+ hiddenrfqID
																									.val())
																					.val(
																							instypeid
																									.val());

																			$(
																					'#inspectionName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#inspectiontypeid :selected')
																									.text());
																			$(
																					'#inspectionpct'
																							+ hiddenrfqID
																									.val())
																					.val(
																							inspct
																									.val());
																			$(
																					'#serialcontrol'
																							+ hiddenrfqID
																									.val())
																					.val(
																							serialc
																									.val());
																			$(
																					'#serialcontrolName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#serialcontrol :selected')
																									.text());

																			$(
																					'#skip'
																							+ hiddenrfqID
																									.val())
																					.val(
																							skip
																									.val());
																			$(
																					'#skipName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#skip :selected')
																									.text());
																			$(
																					'#samplingproc'
																							+ hiddenrfqID
																									.val())
																					.val(
																							samproc
																									.val());
																			$(
																					'#active'
																							+ hiddenrfqID
																									.val())
																					.val(
																							active
																									.val());
																			$(
																					'#activeName'
																							+ hiddenrfqID
																									.val())
																					.val(
																							$(
																									'#activemi :selected')
																									.text());
																			$(
																					'#hiddenIdrfqPopUp')
																					.val(
																							"0");
																			$(
																					this)
																					.dialog(
																							"close");
																		}
																	}
																},
																Cancel : function() {
																	$(this)
																			.dialog(
																					"close");
																}
															},
															close : function() {
																allFields
																		.val("")
																		.removeClass(
																				"ui-state-error");
															}
														});

										$("#Rfqlineadd").button().click(
												function() {
													$("#dialog-form-Rfq")
															.dialog("open");
													//alert("opened");
												});
									});
									function removeRfq(id) {
										//alert("removing row " + id);
										$('#' + id).remove();
										$('#valueForSubData')
												.val(
														parseFloat($(
																'#valueForSubData')
																.val())
																- parseFloat(1));
									}
									function editRfq(id) {
										//alert("edit row " + id);
										$("#dialog-form-Rfq").dialog("open");
										$('#inspectiontypeid').val(
												$('#inspectiontypeid' + id)
														.val());
										$('#inspectionpct').val(
												$('#inspectionpct' + id).val());
										$('#serialcontrol').val(
												$('#serialcontrol' + id).val());
										$('#skip').val($('#skip' + id).val());
										$('#samplingproc').val(
												$('#samplingproc' + id).val());
										$('#active').val(
												$('#activemi' + id).val());
										$('#hiddenIdrfqPopUp').val(id);

									}
								</script>


								<div id="dialog-form-Rfq" align="center"
									title="<s:message code="label.materiinspctadd"/>">
									<p class="validateTips" align="center">
										<font color="red"></font>
									</p>
									<table class="tableGeneral" cellspacing=0>

										<tr>
											<td><s:message code="label.instypeid" /><span
												class="required">*</span></td>
											<td><form:select path="inspectionTypeId"
													id="inspectiontypeid" class="select"
													cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${InspectionTypeIds}" />

												</form:select></td>
										</tr>
										<tr>
											<td><s:message code="label.inspectionpct" /><span
												class="required">*</span></td>
											<td><form:input path="inspectionPct" id="inspectionpct"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><s:message code="label.serialc" /><span
												class="required">*</span></td>
											<td><form:select path="serialControl" id="serialcontrol"
													class="select" cssStyle="height:25px;">
													<form:option value="1">True</form:option>
													<form:option value="0">false</form:option>
												</form:select></td>
										</tr>
										<tr>
											<td><s:message code="label.skip" /><span
												class="required">*</span></td>
											<td><form:select path="skip" id="skip" class="select"
													cssStyle="height:25px;">
													<form:option value="1">True</form:option>
													<form:option value="0">False</form:option>
												</form:select></td>
										</tr>

										<tr>
											<td><s:message code="label.sampleproc" /><span
												class="required">*</span></td>
											<td><form:input path="sampleProc" id="samplingproc"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><s:message code="label.active" /><span
												class="required">*</span></td>
											<td><form:select path="activemi" id="activemi"
													class="select" cssStyle="height:25px;">
													<form:option value="1">True</form:option>
													<form:option value="0">False</form:option>
												</form:select></td>
											<td><input type="hidden" name="hiddenIdrfqPopUp"
												id="hiddenIdrfqPopUp" value="0" /></td>
										</tr>

									</table>

								</div>



								<div id="users-contain-Rfq">
									<!-- class="ui-widget" -->
									<h3></h3>
									<table id="RfqAdd" class="table">
										<thead>
											<tr>
												<th><s:message code="label.instypeid" /></th>
												<th><s:message code="label.inspectionpct" /></th>
												<th><s:message code="label.serialc" /></th>
												<th><s:message code="label.skip" /></th>
												<th><s:message code="label.sampleproc" /></th>
												<th><s:message code="label.active" /></th>
												<th><s:message code="label.edit" /></th>
												<th><s:message code="label.remove" /></th>

											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<button id="Rfqlineadd" type="button">
										<s:message code="label.addminsp" />
									</button>
								</div>

								<%-- <form:hidden path="rfqhide" /> --%>

								<!-- </div> -->
							</div>
						</div>
						<table class="tableGeneral">
							<tr>
								<c:choose>
									<c:when test="${save}">
										<td colspan="2"><input type="submit"
											value="<s:message code="label.save"/>"
											class="btn btn-primary" id="sumbnid" /><input type="reset"
											class="btn btn-primary"
											value="<s:message code="label.reset"/>" /></td>
									</c:when>
									<c:otherwise>
										<td colspan="2"><input type="submit" disabled="disabled"
											value="<s:message code="label.save"/>"
											class="btn btn-primary" id="sumbnid" /><input type="reset"
											class="btn btn-primary"
											value="<s:message code="label.reset"/>" /></td>
									</c:otherwise>
								</c:choose>
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
												<strong> <s:message code="label.warning" />
												</strong>
												<s:message code="label.materialName" />
												<s:message code="label.duplicateCheck" />

											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="materialIdEdit" />
								<tr>
									<td><s:message code="label.materialCode" /><font
										color="red">*</font></td>
									<td><form:input path="materialCodeEdit"
											id="materialCodeEdit" class="textbox" maxlength="50" /></td>
									<td><s:message code="label.avgVolume" /></td>
									<td><form:input path="avgVolumeEdit" id="avgVolumeEdit"
											class="textbox" /></td>
								</tr>

								<tr>
									<td><s:message code="label.materialName" /><font
										color="red">*</font></td>
									<td><form:input path="materialNameEdit" id="materialName"
											class="textbox" maxlength="50" /></td>

									<td><s:message code="label.weightUOM" /></td>
									<td><form:select path="weightUOMEdit" id="weightUOMEdit"
											class="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${uom}" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.materialDescription"></s:message></td>
									<td><form:textarea path="materialDescriptionEdit"
											id="materialDescription" class="textbox" maxlength="250" /></td>
									<td><s:message code="label.heightUOM" /></td>
									<td><form:select path="heightUOMEdit" id="heightUOMEdit"
											class="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${uom}" />
										</form:select></td>

								</tr>
								<tr>
									<td><s:message code="label.materialCategory" /><font
										color="red">*</font></td>
									<td><form:select path="materialCategoryEdit"
											id="materialCategory" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${materialCategory}" />
										</form:select></td>

									<td><s:message code="label.lengthUOM" /></td>
									<td><form:select path="lengthUOMEdit" id="lengthUOMEdit"
											class="select">
											<form:option value="">--Selcet--</form:option>
											<form:options items="${uom}" />
										</form:select></td>

								</tr>

								<tr>
									<td><s:message code="label.materialType" /><font
										color="red">*</font></td>
									<td><form:select path="materialTypeEdit" class="select">
											<%-- <form:option value="<c:out value='${materialEditValues.materialType}'/>"><c:out value="${materialEditValues.materialTypeName}"/></form:option> --%>
											<form:option value="">--Select--</form:option>
											<form:options items="${materialType}" />
										</form:select></td>
									<td><s:message code="label.dimension" /></td>
									<td><form:input path="dimensionEdit" id="dimensionEdit"
											class="textbox" maxlength="150" /></td>
								</tr>
								<tr>
									<td><s:message code="label.taxCategory" /></td>
									<td><form:select path="taxCatogeryEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${taxCategory}" />
										</form:select></td>
									<td><s:message code="label.shelfLife" /><font color="red">*</font></td>
									<td><form:input path="shelfLifeEdit" id="shelfLifeEdit"
											class="textbox" /></td>

								</tr>
								<tr>
									<td><s:message code="label.uom" /><font color="red">*</font></td>
									<td><form:select path="uomEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${uom}" />
										</form:select></td>

									<td><s:message code="label.shelfLifeUOM" /><font
										color="red">*</font></td>
									<td><form:select path="shelfLifeUOMEdit"
											id="shelfLifeUOMEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${uom}" />
										</form:select></td>
								</tr>

								<tr>
									<td><s:message code="label.active" /></td>
									<td><form:select path="activeEdit" cssClass="select">
											<form:option value="0">true</form:option>
											<form:option value="1">false</form:option>
										</form:select></td>

									<td><s:message code="label.reorderLevel" /><font
										color="red">*</font></td>
									<td><form:input path="reorderLevelEdit"
											id="reorderLevelEdit" class="textbox" /></td>

								</tr>
								<tr>
									<td><s:message code="label.salesUOM" /></td>
									<td><form:select path="salesUOMEdit" cssClass="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${uom }" />
										</form:select></td>

									<td><s:message code="label.maxDeliveryTime" /></td>
									<td><form:input path="maxDeliveryTimeEdit"
											id="maxDeliveryTimeEdit" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.purchaseUOM" /></td>
									<td><form:select path="purchaseUOMEdit" cssClass="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${uom }" />
										</form:select></td>

									<td><s:message code="label.maxDeliveryTimeUOM" /></td>
									<td><form:select path="maxDeliveryTimeUOMEdit"
											id="maxDeliveryTimeUOMEdit" class="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${uom }" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.avgWeight" /></td>
									<td><form:input path="avgWeightEdit" id="avgWeightEdit"
											cssClass="textbox" /></td>

									<td><s:message code="label.alternateUOM" /></td>
									<td><form:select path="alternateUOMEdit" id="alternateUOM"
											class="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${uom }" />
										</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.avgHeight" /></td>
									<td><form:input path="avgHeightEdit" id="avgHeightEdit"
											cssClass="textbox" /></td>

									<td><s:message code="label.avgLength" /></td>
									<td><form:input path="avgLengthEdit" id="avgLengthEdit"
											cssClass="textbox" /></td>
								</tr>
							</table>
							<!-- Child Tab -->
							
						<div id="tabss" align="center">
							<ul>

								<li><a href="#tabss2"><spring:message
											code="label.materialInspct" /></a></li>

							</ul>
							<div align="center">

								<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

								<!-- <div align="center"> -->

								<script>
									var btrfqid = 1;
									$(function() {

										/* var currentText = $(this).find(":selected").text(); */

										var instypeidedit = $("#inspectiontypeidedit"), inspctedit = $("#inspectionpctedit"), serialcedit = $("#serialcontroledit"), skipedit = $("#skipedit"), samprocedit = $("#samplingprocedit"), activeedit = $("#activemiedit"), ehiddenrfqID = $("#hiddenIdrfqeditPopUp")

										allFields = $([]).add(instypeidedit)
												.add(inspctedit).add(
														serialcedit).add(
														skipedit).add(
														samprocedit).add(
														activeedit).add(
														ehiddenrfqID),
												tips = $(".validateTips");

										function updateTips(t) {
											tips.text(t).addClass(
													"ui-state-highlight");
											setTimeout(function() {
												tips.removeClass(
														"ui-state-highlight",
														1500);
											}, 500);
										}

										function checkLength2(o, n) {

											if (o.val().length == "") {
												o.addClass("ui-state-error");
												updateTips(n + "is Required");
												return false;
											} else {
												return true;
											}
										}

										function checkLength(o, n, min, max) {
											if (o.val().length > max
													|| o.val().length < min) {
												o.addClass("ui-state-error");
												updateTips("Length of " + n
														+ " must be between "
														+ min + " and " + max
														+ ".");
												return false;
											} else {
												return true;
											}
										}

										function checkRegexp(o, regexp, n) {
											if (!(regexp.test(o.val()))) {
												o.addClass("ui-state-error");
												updateTips(n);
												return false;
											} else {
												return true;
											}
										}

										$("#dialog-form-RfqEdit")
												.dialog(
														{
															autoOpen : false,
															height : 350,
															width : 350,
															modal : true,
															buttons : {
																Submit : function() {
																	var bValid2 = true;
																	allFields
																			.removeClass("ui-state-error");

																	bValid2 = bValid2
																			&& checkLength2(
																					instypeidedit,
																					"Inspection Type");
																	bValid2 = bValid2
																			&& checkRegexp(
																					inspctedit,
																					/^([0-9.])+$/i,
																					"Inspection PCT is Required And Must be a Number");

																	bValid2 = bValid2
																			&& checkLength2(
																					serialcedit,
																					"SerialControl");

																	bValid2 = bValid2
																			&& checkLength2(
																					skipedit,
																					"Skip");
																	bValid2 = bValid2
																			&& checkLength2(
																					samprocedit,
																					"Sample Proc");
																	bValid2 = bValid2
																			&& checkLength2(
																					activeedit,
																					"Active");
																	if (bValid2) {
																		//alert("hiddenid"+hiddenID.val());

																		if (ehiddenrfqID
																				.val() == "0"
																				|| ehiddenrfqID
																						.val() == "") {

																			$("#RFQEdit tbody")
																					.append(

																							"<tr id="+btrfqid+">"
																									+ "<td ><input type='hidden' name='inspectionTypeIdedit' id='inspectiontypeidedit"
																									+ btrfqid
																									+ "' value="
																									+ instypeidedit
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='inspectionNameedit' id='inspectionNameedit"
																									+ btrfqid
																									+ "' value='"
																									+ $('#inspectiontypeidedit :selected').text()
																									+ "'"
																									+ " </td>"
																									+ "<td><input type='text' name='inspectionPctedit' id='inspectionpctedit"
																									+ btrfqid
																									+ "' value="
																									+ inspctedit
																											.val()
																									+ "  class='textbox'readonly/></td>"

																									+ "<td><input type='hidden' name='serialControledit' id='serialcontroledit"
																									+ btrfqid
																									+ "' value="
																									+ serialcedit
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='serialcontrolNameedit' id='serialcontrolNameedit"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#serialcontroledit :selected')
																											.text()
																									+ "'"
																									+ "</td>"
																									+ "<td><input type='hidden' name='skipedit' id='skipedit"
																									+ btrfqid
																									+ "' value="
																									+ skipedit
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='skipNameedit' id='skipNameedit"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#skipedit :selected')
																											.text()
																									+ "'"
																									+ "</td>"
																									+ "<td><input name='sampleProcedit' id='samplingprocedit"
																									+ btrfqid
																									+ "' value="
																									+ samprocedit
																											.val()
																									+ " class='textbox'readonly/><input type='hidden' name='materialinspIdedit' value='0' id='materialinspIdedit'/><input type='hidden' name='Checkdelete' id='Checkdelete' value='0'/></td></td>"
																									
																									+ "<td><input type='hidden' name='activemiedit' id='activemiedit"
																									+ btrfqid
																									+ "' value="
																									+ activeedit
																											.val()
																									+ " class='textbox'readonly/>"
																									+ "<input type='text' readonly class='textbox' name='activeNameedit' id='activeNameedit"
																									+ btrfqid
																									+ "' value='"
																									+ $(
																											'#activemiedit :selected')
																											.text()
																									+ "'"
																									+ "</td>"
																								
																									+ "<td><a href='#'  onclick='editRfqEdit("
																									+ btrfqid
																									+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																									+ "<td><a href='#'  onclick='removeRfqEdit("
																									+ btrfqid
																									+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																									+ "</tr>");

																			btrfqid++;
																			$(
																					this)
																					.dialog(
																							"close");
																		}

																		if (ehiddenrfqID
																				.val() != "0") {
																			$(
																					'#inspectiontypeidedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							instypeidedit
																									.val());

																			$(
																					'#inspectionNameedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							$('#inspectiontypeidedit :selected')
																									.text());
																			$(
																					'#inspectionpctedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							inspctedit
																									.val());
																			$(
																					'#serialcontroledit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							serialcedit
																									.val());
																			$(
																					'#serialcontrolNameedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							$(
																									'#serialcontroledit :selected')
																									.text());

																			$(
																					'#skipedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							skipedit
																									.val());
																			$(
																					'#skipNameedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							$(
																									'#skipedit :selected')
																									.text());
																			$(
																					'#samplingprocedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							samprocedit
																									.val());
																			$(
																					'#activeedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							activeedit
																									.val());
																			$(
																					'#activeNameedit'
																							+ ehiddenrfqID
																									.val())
																					.val(
																							$(
																									'#activemiedit :selected')
																									.text());

																			$(
																					'#hiddenIdrfqeditPopUp')
																					.val(
																							"0");
																			$(
																					this)
																					.dialog(
																							"close");
																		}
																	}
																},
																Cancel : function() {
																	$(this)
																			.dialog(
																					"close");
																}
															},
															close : function() {
																allFields
																		.val("")
																		.removeClass(
																				"ui-state-error");
															}
														});

										$("#AddRFQEdit").button().click(
												function() {
													$("#dialog-form-RfqEdit")
															.dialog("open");
													//alert("opened");
												});
									});
									function removeRfqEdit(id) {
										//alert("removing row " + id);
										$('#' + id).remove();
									}

									function editRfqEdit(id) {
										//alert("edit row " + id);

										$("#dialog-form-RfqEdit")
												.dialog("open");

										$('#inspectiontypeidedit').val(
												$('#inspectiontypeidedit' + id).val());
										
										$('#inspectionpctedit').val(
												$('#inspectionpctedit' + id)
														.val());
										$('#serialcontroledit').val(
												$('#serialcontroledit' + id)
														.val());
										$('#skipedit').val(
												$('#skipedit' + id).val());
										$('#samplingprocedit').val(
												$('#samplingprocedit' + id)
														.val());
										$('#activemiedit').val(
												$('#activemiedit' + id).val());
										$('#hiddenIdrfqeditPopUp').val(id);
									}
								</script>


								<div id="dialog-form-RfqEdit" align="center"
									title="<spring:message code="label.addmindetails" />">
									<p class="validateTips" align="center">
										<font color="red"></font>
									</p>
									<table class="tableGeneral" cellspacing=0>

										<tr>
										<form:hidden path="materialinspIdedit" value="0"/>
											<td><s:message code="label.instypeid" /><span
												class="required">*</span></td>
											<td><form:select path="inspectionTypeIdedit"
													id="inspectiontypeidedit" class="select"
													cssStyle="height:25px;">
													<form:option value="">--Select--</form:option>
													<form:options items="${InspectionTypeIds}" />

												</form:select></td>
										</tr>
										<tr>
											<td><s:message code="label.inspectionpct" /><span
												class="required">*</span></td>
											<td><form:input path="inspectionPctedit" id="inspectionpctedit"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><s:message code="label.serialc" /><span
												class="required">*</span></td>
											<td><form:select path="serialControledit" id="serialcontroledit"
													class="select" cssStyle="height:25px;">
													<form:option value="1">True</form:option>
													<form:option value="0">False</form:option>
												</form:select></td>
										</tr>
										<tr>
											<td><s:message code="label.skip" /><span
												class="required">*</span></td>
											<td><form:select path="skipedit" id="skipedit" class="select"
													cssStyle="height:25px;">
													<form:option value="1">True</form:option>
													<form:option value="0">False</form:option>
												</form:select></td>
										</tr>

										<tr>
											<td><s:message code="label.sampleproc" /><span
												class="required">*</span></td>
											<td><form:input path="sampleProcedit" id="samplingprocedit"
													class="textbox" /></td>
										</tr>
										<tr>
											<td><s:message code="label.active" /><span
												class="required">*</span></td>
											<td><form:select path="activemiedit" id="activemiedit"
													class="select" cssStyle="height:25px;">
													<form:option value="1">True</form:option>
													<form:option value="0">False</form:option>
												</form:select></td>
											<td>
												<input type="hidden" name="hiddenIdrfqeditPopUp"
												id="hiddenIdrfqeditPopUp" value="0" /></td>
										</tr>

									</table>

								</div>



								<div id="users-contain-Process">
									<!-- class="ui-widget" -->
									<h3></h3>
									<table id="RFQEdit" class="table">
										<thead>
											<tr>

												<th><s:message code="label.instypeid" /></th>
												<th><s:message code="label.inspectionpct" /></th>
												<th><s:message code="label.serialc" /></th>
												<th><s:message code="label.skip" /></th>
												<th><s:message code="label.sampleproc" /></th>
												<th><s:message code="label.active" /></th>
												<th><s:message code="label.edit" /></th>
												<th><s:message code="label.remove" /></th>

											</tr>


										</thead>
										<tbody>
											<c:forEach items="${milist}"
												var="milist">



												<td><spring:bind path="materialAdd.materialinspIdedit">
														<input type="hidden" name="materialinspIdedit"
															id="materialinspIdedit${milist.materialinspIdedit}"
															value="${milist.materialinspIdedit}" />
													</spring:bind></td>


												<tr id="${milist.materialinspIdedit}">
													<td><spring:bind path="materialAdd.inspectionTypeIdedit">
															<input type="hidden" name="inspectionTypeIdedit"
																class="textbox"
																id="inspectiontypeidedit${milist.materialinspIdedit}"
																value="${milist.inspectionTypeIdedit}" />
														</spring:bind> <spring:bind path="materialAdd.insepectionTypeNameedit">
															<input type="text" name="insepectionTypeNameedit" class="textbox"
																id="inspectionNameedit${milist.materialinspIdedit}"
																value="${milist.insepectionTypeNameedit}" readonly />
														</spring:bind></td>

													<td><spring:bind path="materialAdd.inspectionPctedit">
															<input type="text" name="inspectionPctedit"
																id="inspectionpctedit${milist.materialinspIdedit}"
																class="textbox"
																value="${milist.inspectionPctedit}" readonly />
														</spring:bind></td>
														<td><spring:bind path="materialAdd.serialControledit">
															<input type="hidden" name="serialControledit"
																id="serialcontroledit${milist.materialinspIdedit}"
																class="textbox"
																value="${milist.serialControledit}"/>
																</spring:bind> <spring:bind path="materialAdd.serialcontrolNameedit">
															<input type="text" name="serialcontrolNameedit" class="textbox"
																id="serialcontrolNameedit${milist.materialinspIdedit}"
																value="${milist.serialcontrolNameedit}" readonly />
														</spring:bind></td>
														<td><spring:bind path="materialAdd.skipedit">
															<input type="hidden" name="skipedit"
																id="skipedit${milist.materialinspIdedit}"
																class="textbox"
																value="${milist.skipedit}"  />
														</spring:bind>
														<spring:bind path="materialAdd.skipNameedit">
															<input type="text" name="skipNameedit" class="textbox"
																id="skipNameedit${milist.materialinspIdedit}"
																value="${milist.skipNameedit}" readonly />
														</spring:bind></td>
														<td><spring:bind path="materialAdd.sampleProcedit">
															<input type="text" name="sampleProcedit"
																id="samplingprocedit${milist.materialinspIdedit}"
																class="textbox"
																value="${milist.sampleProcedit}" readonly />
														</spring:bind></td>
													<td><spring:bind path="materialAdd.activemiedit">
															<input type="hidden" name="activemiedit"
																id="activemiedit${milist.materialinspIdedit}"
																class="textbox"
																value="${milist.activemiedit}" />
														</spring:bind>
														<spring:bind path="materialAdd.activeNameedit">
															<input type="text" name="activeNameedit" class="textbox"
																id="activeNameedit${milist.materialinspIdedit}"
																value="${milist.activeNameedit}" readonly />
														</spring:bind>
														 <input type="hidden"
														name="Checkdelete${milist.materialinspIdedit}"
														id="${milist.materialinspIdedit}Checkdelete"
														value="0" /></td>


													<td><a href='#'
														id="${milist.materialinspIdedit}"
														onclick="editRfqEdit(this.id)"><strong><img
																src='images/Edit.jpg' height='25px' width='25px' /></strong></a></td>
													<td><a href='#'
														id="${milist.materialinspIdedit}"
														onclick="getID11(this)"><strong><img
																src='images/button_cancel.png' height='25px'
																width='25px' /></strong></a></td>
												</tr>



												<script type="text/javascript">
													function getID11(link) {
														alert(link.id);
														alert("Deleting Particular Row Will Deleted Once You Click Update Button");
														document
																.getElementById(link.id
																		+ "Checkdelete").value = "1";
														document
																.getElementById(link.id).style.display = "none";
													}
													function editProcessDetailsInEdit(
															link) {

														$(
																"#dialog-form-RfqEdit")
																.dialog("open");
														$(
																'#inspectionTypeIdedit'
																		+ link.id)
																.val(
																		$(
																				'#inspectionTypeIdedit')
																				.val());
														$('#inspectionPctedit')
																.val(
																		$(
																				'#inspectionPctedit'
																						+ link.id)
																				.val());
														$('#serialControledit')
																.val(
																		$(
																				'#serialControledit'
																						+ link.id)
																				.val());
														$('#skipedit')
																.val(
																		$(
																				'#skipedit'
																						+ link.id)
																				.val());
														$('#sampleProcedit')
														.val(
																$(
																		'#sampleProcedit'
																				+ link.id)
																		.val());
														$('#activemiedit')
														.val(
																$(
																		'#activemiedit'
																				+ link.id)
																		.val());

														$(
																'#hiddenIdrfqeditPopUp')
																.val(link.id);

													}
												</script>

											</c:forEach>
										</tbody>
									</table>
									<button id="AddRFQEdit" type="button">
										<s:message code="label.addminsp" />
									</button>
								</div>

							</div>

</div>


							<table class="tableGeneral">
								<tr>
									<c:choose>
										<c:when test="${update}">
											<td colspan="2"><input type="submit"
												value="<s:message code="label.update"/>"
												class="btn btn-primary" id="updateBtn" /></td>
										</c:when>
										<c:otherwise>
											<td colspan="2"><input type="submit" disabled="disabled"
												value="<s:message code="label.update"/>"
												class="btn btn-primary" id="updateBtn" /></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
				<!-- ============================================End MaterialEdit==================================================================================== -->
			</div>
		</div>
	</div>
</body>
</html>




