<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
					
						$('#sumbtnid')
								.click(
										function(event) {
alert('Hellooooo');
											$('#addbomform')
													.validate(
															{
																rules : {
																	bmaterial_Id : {
																		required : true
																	},
																	plant_Id : {
																		required : true
																	},
																	usage : {
																		required : true
																	},
																	bomCategoryId : {
																		required : true
																	},
																	revisionLevel : {
																		required : true
																	},
																	bomNumber : {
																		required : true
																	},
																	
																},
																messages : {
																	bmaterial_Id : "<font style='color: red;'><b>Material is Required</b></font>",
																	plant_Id : "<font style='color: red;'><b>Plant is Required</b></font>",
																	usage : "<font style='color: red;'><b>Usage is Required</b></font>",
																	bomCategoryId : "<font style='color: red;'><b>Bom Category is Required</b></font>",
																	revisionLevel : "<font style='color: red;'><b>Revision level is Required</b></font>",
																	bomNumber : "<font style='color: red;'><b>Bom Number is Required</b></font>",
																	
																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {
											
											$('#editbomForm')
													.validate(
															{
																rules : {
																	bmaterial_IdEditt : {
																		required : true
																	},
																	plant_IdEditt : {
																		required : true
																	},
																	usageEditt : {
																		required : true
																	},
																	bomCategoryIdEditt : {
																		required : true
																	},
																	revisionLevelEditt : {
																		required : true
																	},
																	bomNumberEditt : {
																		required : true
																	},
																	
																},
																messages : {
																	bmaterial_IdEditt : "<font style='color: red;'><b>Material is Required</b></font>",
																	plant_IdEditt : "<font style='color: red;'><b>Plant is Required</b></font>",
																	usageEditt : "<font style='color: red;'><b>Usage is Required</b></font>",
																	bomCategoryIdEditt : "<font style='color: red;'><b>Bom Category is Required</b></font>",
																	revisionLevelEditt : "<font style='color: red;'><b>Revision Level is Required</b></font>",
																	bomNumberEditt : "<font style='color: red;'><b>Bom Number is Required</b></font>",
																	
																},

															});

										});
 
					});
</script>

<script type="text/javascript">
	function doAjaxPostEdit() {

		
		var materialId = $('#bmaterial_IdEditt').val();
		

		var bid = $('#bomIdEditt').val();

		$
				.ajax({

					type : "POST",

					url : "bomDuplicateEditCheck.mnt",

					data : "materialId=" + materialId + "&bid=" + bid,

					success : function(response) {

						var checkResponse = "Material is Already Exists Please try some other name";

						if (checkResponse == response) {
							document.getElementById("editmessage").style.display = "block";
							//$('#editmessage').html(response);
						} else {
							document.getElementById("editmessage").style.display = "none";
						}
					},

					error : function(e) {

						

					}

				});

	}
</script>
<script type="text/javascript">
	function doAjaxPost() {
		
		var material = $('#bmaterial_Id').val();
		
		$
				.ajax({

					type : "POST",

					url : "bomDuplicateAddCheck.mnt",

					data : "material=" + material,

					success : function(response) {

						var checkResponse = "Material is Already Exists Please try some other name";

						if (checkResponse == response) {
							document.getElementById("addmessage").style.display = "block";
							//$('#addmessage').html(response);
						} else {
							document.getElementById("addmessage").style.display = "none";
						}
					},

					error : function(e) {

										}

				});

	}
</script>

 
<!-- Horizantol scroll -->
<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 100%;
}
</style>

<!-- Horizantol scroll -->
<style type="text/css">
#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 95%;
}
</style>

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
 

<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();

	});

	$(function() {
		$("#tabsForAdd").tabs();
	});
	$(function() {
		$("#tabsForEdit").tabs();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#tabsForEdit").hide();
			$("#warningmesssage").hide();

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
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
		}

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#basicSearch').click(function() {
			$("#advanceSearchHidden").val("0");
			$("#aslink").show();

			$('#mainSearch').show();
			$('#advanceSearchDiv').hide();
			$('#advanceSearch').show();
			$('#basicSearch').hide();
			
			return false;
		});
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
			$("#tabsForEdit").hide();

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


<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();

		});
	});
</script>
<script type="text/javascript">
function compare() {
var childMaterial = document.getElementById("mId");
var parentMaterial = document.getElementById("parentMat");

	if (childMaterial.options[childMaterial.selectedIndex].value == parentMaterial.options[parentMaterial.selectedIndex].value)
	{
	   alert('Child Material and Parent Material Should not be same');
	   $("#parentMat").val( $("#parentMat option:first-child").val() );
	}
}
</script>
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">BOM</div>

		<!-- Tabs Declaration -->
		<div id="scroll">
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
				<c:forEach var="bomEditList" items="${bomEditList}">
						<c:set var="bomEditList" value="${bomEditList }"></c:set>
					</c:forEach>
					<c:if test="${bomEditList!=null}">

						<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
									code="label.edit" /></a></li>
					</c:if> 
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
								code="label.search" /></a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
								code="label.add" /></a></li>
				</ul>

				<!-- Search tab part -->

				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">
						<form:form action="bomSearch.mnt" method="GET"
							commandName="bomCommand">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach 
										items="${param.list}">
										<div class="alert-success" >
                                      <strong> <spring:message code="label.success"/> </strong>
                                      <spring:message code="label.bom"/>  <spring:message code="label.saveSuccess"/>
										</div>
									</c:forEach>
									
									<c:forEach 
										items="${param.listwar}">
										<div class="alert-danger" >
                                      <strong> <spring:message code="label.error"/> </strong>
                                      <spring:message code="label.bom"/>  <spring:message code="label.saveFail"/>
										</div>
									</c:forEach>
									

                                    <c:forEach items="${bomUpdate}">
										<div class="alert-success" >
											<strong> <spring:message code="label.success"/> </strong>
                                      <spring:message code="label.bom"/>  <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach>
									
									 <c:forEach items="${bomUpdateFail}">
										<div class="alert-danger" >
											<strong> <spring:message code="label.error"/> </strong>
                                      <spring:message code="label.bom"/>  <spring:message code="label.updateFail"/>
										</div>
									</c:forEach>
									
									<c:forEach items="${bomDelete}">
										<div class="alert-success" id="successmessage">
											<strong> <spring:message code="label.success"/> </strong>
                                      <spring:message code="label.bom"/>  <spring:message code="label.deleteSuccess"/>
										</div>
									</c:forEach>
										<c:forEach items="${bomDeleteFail}">
											<div class="alert-danger" >
											<strong> <spring:message code="label.error"/> </strong>
                                      <spring:message code="label.bom"/>  <spring:message code="label.deleteFail"/>
										</div>
									</c:forEach>
									
									
									
									</td>
							</tr>
								<tr id="mainSearch">
									<td><spring:message code="label.searchby" /><form:select path="xmlLabel" cssClass="select">

											<form:options items="${xmlItems}" />
										</form:select> <spring:bind path="bomCommand.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind>  <form:input path="basicSearchId" cssClass="textbox" /></td>
									
									
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
										<c:when test="${privileges eq messageup }">
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
										class="btn btn-danger" />
										</c:otherwise>
										</c:choose></td>
								</tr>
								<form:form action="bomAdvanceSearch.mnt" method="get"
							commandName="bomCommand" name="advanceSearchFinal" id="advanceSearchFinal">
							<tr>
								<td>
									<a href="bomAdvanceSearch.mnt"><font
										style="color: blue" id="aslink"><u><b>Advanced Search</b></u></font></a>
										<a
									href="#" id="basicSearch" style="display: none"><font
										style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
								</td>
							
							</tr>
						</form:form>
							</table>
							
								<form:form action="bomAdvanceSearchOperations.mnt"
						commandName="bomCommand">
						<div id="advanceSearchDiv" style="display: none">
							<table class="tableGeneral">
								<c:forEach var="xmlLabelValue" items="${bomSearchAdvance}">
									<tr>
										<td><label>${xmlLabelValue.secondLabel}</label><form:hidden
												path="firstLabel" id="firstLabel"
												value="${xmlLabelValue.firstLabel}" /></td>
										<td><form:select path="operations1">
												<form:option value="0">-Select-</form:option>
												<form:option value="=">Equals To</form:option>
												<form:option value="!=">Not Equals To</form:option>
												<form:option value="_%">BeginsWith</form:option>
												<form:option value="%_">EndsWith</form:option>
												<form:option value="%_%">Contains</form:option>
											</form:select></td>
										<td><form:input path="advanceSearchText"
												id="advanceSearchkk"  /></td>
									</tr>

								</c:forEach>
								<tr>
									<form:hidden path="advanceSearchHidden"
										id="advanceSearchHidden" />
									<td colspan="3">
									
									<c:choose>
									<c:when test="${search}">
									<input type="submit"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-primary" /></c:when>
										<c:otherwise>
										<input type="submit" disabled="disabled"
										id="advanceSearchButtonId" value="Advance Search"
										style="display: none" class="btn btn-danger" />
										</c:otherwise>
										</c:choose></td>
								</tr>
							
							</table>

						</div>
					</form:form>
					
						</form:form>
						
						<c:if test="${bomSearch!=null}">
							<display:table id="bomValue" name="bomSearch"
								requestURI="bomSearch.mnt" pagesize="5" class="table">
								<!-- Displaying  the Searched information by using display tag -->
								<display:column property="bmaterial_Id"
									titleKey="label.qmaterial" media="html" sortable="true" />
									
								<display:column property="plant_Id" titleKey="label.qplant"
									media="html" sortable="true" />
									
								<display:column property="usage" titleKey="label.usage"
									media="html" sortable="true" />
									
								<display:column property="bomCategoryId" titleKey="label.bomcategory"
									media="html" sortable="true" />
									
								<display:column property="revisionLevel"
									titleKey="label.revisionLevel" media="html" sortable="true" />
									
								<display:column property="bomNumber" titleKey="label.bomnumber"
									media="html" sortable="true" />
																									
								<display:column titleKey="label.edit" style="color:white">
								<c:choose>
								<c:when test="${edit}">
									<a
										href="bomIdEdit1.mnt?bomId=<c:out value="${bomValue.bomId}"/>"
										style="color: red"><img src="images/Edit.jpg" width="20px"
										height="20px" /> </a></c:when>
										<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
										height="20px" /></a>	
										</c:otherwise>
								</c:choose>
								</display:column>
								<display:column titleKey="label.delete">
								<c:choose>
								<c:when test="${delete }">
									<a
										href="bomIdDelete.mnt?bomId=<c:out value="${bomValue.bomId}"/>"
										style="color: red"
										onclick="return confirm('Do u want to delete the Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
										<c:otherwise>
										<a><img src="images/Delete.jpg" width="20px" height="20px" class="btn btn-danger"/> </a>
										</c:otherwise>
										</c:choose>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" />
								<%-- <display:setProperty name="paging.banner.group_size" value="3" />
								<display:setProperty name="paging.banner.some_items_found"
									value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" /> --%>
							</display:table>
						</c:if> 
					</div>
				</div>

				<!-- Add tab details -->


				<div id="tabs-3" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						<form:form action="bom.mnt" method="GET"
							commandName="bomCommand" id="addbomform">

							<table class="tableGeneral">
								<form:hidden path="aid" />
							 <tr>
									<%-- <td colspan="2"><c:forEach
											var="addBomDuplicate" items="${addBomDuplicate}">
											<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/> </strong>
												<spring:message code="qmaterial"/> <spring:message code="label.duplicateCheck"/>
											</div>
										</c:forEach></td> --%>
								</tr> 
								<form:hidden path="bomIdEditt" />
								<form:hidden path="bomLineIdEditt" />
								
								<tr>
									<td><spring:message code="label.qmaterial" /><font
										color="red">*</font> </td>
									<td><form:select path="bmaterial_Id" class="select" onchange="doAjaxPost()" >
											<form:option value="">-Select-</form:option>
											<form:options items="${material}" />
										</form:select></td>
										<!-- <td style="display: none" id="addmessage" class="alert-warning"></td> -->
									<td colspan="2" id="addmessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.qmaterial" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
								
								
								</tr>
								<tr>
									<td><spring:message code="label.qplant" /><font
										color="red">*</font> </td>
									<td><form:select path="plant_Id" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${plant}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.usage" /><font
										color="red">*</font> </td>
									<td><form:input path="usage" id="usage" class="textbox" maxlength="250"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.bomCategory" /><font
										color="red">*</font> </td>
									<td><form:select path="bomCategoryId" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${bomcategory}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.revisionLevel" /><font
										color="red">*</font> </td>
									<td><form:input path="revisionLevel" id="revisionLevel"
											class="textbox" /></td>
								</tr>
								
								<tr>
									<td><spring:message code="label.bomnumber" /><font
										color="red">*</font> </td>
									<td><form:input path="bomNumber" id="bomNumber"
											class="textbox" maxlength="20"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.qty" /><font
										color="red">*</font> </td>
									<td><form:input path="qty" id="qty"
											class="textbox" maxlength="20"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.uom" /><font
										color="red">*</font> </td>
									<td><form:select path="uOMId" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${uom}" />
										</form:select></td>
								</tr>
							</table>

							<!-- Sub tabbing for adding BOM Line details -->
							<div id="tabsForAdd">
							<div id="scroll1">
								<!-- BOM Line tab -->
								<ul>
									<li><a href="#subtabs-1"><spring:message code="label.bomline"/> </a></li>

								</ul>
							
							<div align="center">
								
									<script>
										var bltrid = 1;
										$(function() {


											var mId = $("#mId"),
											mvalue=$("#mNumber"),
											quantity = $("#quantity"), 
											uomm = $("#uomm"),
											uvalue=$("#uNumber"),
											explosionLevel = $("#explosionLevel"),
											predessor = $("#predessor"),
											parentMat = $("#parentMat"),
											parentMatValue=$("#parentMatNumber"),
											hiddenID = $("#hiddenIdBomPopUp"),
										
											allFields = $([]).add(mId).add(mvalue).add(quantity).add(uomm).add(uvalue).add(explosionLevel).add(predessor).add(parentMat).add(parentMatValue).add(hiddenID),
											 tips = $(".validateTips");
											    
												
											        function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
																
											function selectLength(o, n) {
												if (o.val()=='0') {
													o
															.addClass("ui-state-error");
													updateTips(n+" is Required");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-BomLine")
													.dialog(
															{
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");

																		bValid = bValid
																		&& selectLength(
																				mId,
																				"Material"
																				);
																		bValid = bValid
																		&& checkLength(
																				quantity,
																				"Quantity",
																				1,
																				16);
																		bValid = bValid
																		&& selectLength(
																				uomm,
																				"UOM"
																				);
																		bValid = bValid
																			&& checkLength(
																					explosionLevel,
																					"Explosion Level",
																					1,
																					16);
																		bValid = bValid
																		&& checkLength(
																				predessor,
																				"Predecessor",
																				1,
																				16);
																	
																	 	bValid = bValid
																				&& checkRegexp(
																						explosionLevel,
																						/^([0-9])+$/i,
																						"Explosion Level may consist of  0-9");
																		 bValid = bValid
																				&& checkRegexp(
																						predessor,
																						/^([0-9])+$/i,
																						"Predecessor may consist of  0-9"); 
																
																		if (bValid) {
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				
															
															
																		$("#bomLineAdd tbody")
																						.append(
																								"<tr id="+bltrid+">"
																										+ "<td ><input type='hidden'name='mId' id='mId"
																										+ bltrid
																										+ "' value="
																										+ mId
																												.val()
																										+ " class='textbox'/><input type='text' name='mNumber' id='mNumber"
																										+ bltrid
																										+ "' value="
																										+ $('#mId :selected').text()
																																																				
																										+ "  class='textbox' readonly /> </td>"
																										+ "<td><input name='quantity' id='quantity"
																										+ bltrid
																										+ "' value="
																										+ quantity
																												.val()
																										+ " class='textbox'readonly/></td>"
																										+ "<td><input type='hidden' name='uomm' id='uomm"
																										+ bltrid
																										+ "' value="
																										+ uomm
																												.val()
																										+ " class='textbox'/><input type='text' name='uNumber' id='uNumber"
																										+ bltrid
																										+ "' value="
																										+ $('#uomm :selected').text()
																																																				
																										+ "  class='textbox'readonly/></td>"
																										+ "<td><input name='explosionLevel' id='explosionLevel"
																										+ bltrid
																										+ "' value="
																										+ explosionLevel
																												.val()
																										+ " class='textbox' readonly/></td>"
																										+ "<td><input name='predessor' id='predessor"
																										+ bltrid
																										+ "' value="
																										+ predessor
																												.val()
																										+ " class='textbox' readonly/></td>"
																								     	
																										
																										
																										+"<td ><input type='hidden'name='parentMat' id='parentMat"
																										+ bltrid
																										+ "' value="
																										+ parentMat
																												.val()
																										+ " class='textbox'/><input type='text' name='parentMatNumber' id='parentMatNumber"
																										+ bltrid
																										+ "' value="
																										+ $('#parentMat :selected').text()
																																																				
																										+ "  class='textbox' readonly/> </td>"
																								     																							     	
																										+"<td><a href='#'  onclick='editMaterialm("
																										+ bltrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeMaterialm("
																										+ bltrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				bltrid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																			if (hiddenID
																					.val() != "0") {
																				$(
																						'#mId'
																								+ hiddenID
																										.val())
																						.val(
																								mId
																										.val());
																				$(
																						'#mNumber'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#mId :selected').text());
																				$(
																						'#quantity'
																								+ hiddenID
																										.val())
																						.val(
																								quantity
																										.val());
																				$(
																						'#uomm'
																								+ hiddenID
																										.val())
																						.val(
																								uomm
																										.val());
																				$(
																						'#uNumber'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#uomm :selected').text());
																				
																				$(
																						'#explosionLevel'
																								+ hiddenID
																										.val())
																						.val(
																								explosionLevel
																										.val());
																				$(
																						'#predessor'
																								+ hiddenID
																										.val())
																						.val(
																								predessor
																										.val());
																				$(
																						'#parentMat'
																								+ hiddenID
																										.val())
																						.val(
																								parentMat
																										.val());
																				$(
																						'#parentMatNumber'
																								+ hiddenID
																										.val())
																						.val(
																								 $('#parentMat :selected').text());
																																								
																				$(
																						'#hiddenIdBomPopUp')
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
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

							

											$("#create-AddBomLine")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-BomLine")
																		.dialog(
																				"open");
																
															});
										});
										function removeMaterialm(id) {
											alert("removing row " + id);
											$('#' + id).remove();
										}
										function editMaterialm(id) {
											alert("edit row " + id);
										

											$("#dialog-form-BomLine").dialog(
													"open");
									
											$('#mId').val(
													$('#mId' + id).val());
											$('#mNumber').val(
													$('#mNumber' + id).val());
											$('#quantity').val(
													$('#quantity' + id).val());
											$('#uomm').val(
													$('#uomm' + id)
															.val());
											$('#uNumber').val(
													$('#uNumber' + id).val());
											$('#explosionLevel').val(
													$('#explosionLevel' + id).val());
											$('#predessor').val(
													$('#predessor' + id)
															.val());
											$('#parentMat').val(
													$('#parentMat' + id).val());
											$('#parentMatNumber').val(
													$('#parentMatNumber' + id).val());
																			
											$('#hiddenIdBomPopUp').val(id);
										
										}
									</script>


									<div id="dialog-form-BomLine" title="Add New BomLine Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">

											 <tr>
												<td><spring:message code="label.qmaterial" /><font color="red">*</font></td>
												<td><form:select path="mId" class="select" id="mId" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
											</tr>
											<tr><td><input type='hidden' id="mNumber"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.qty" /><font color="red">*</font></td>
												<td><form:input path="quantity" id="quantity"
															class="textbox"  /></td>
											</tr>
											<tr>
												<td><spring:message code="label.quom" /><font color="red">*</font></td>
													<td><form:select path="uomm" id="uomm" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
											<tr><td><input type='hidden' id="uNumber"/></td>
											</tr>
											<tr>
												<td><spring:message code="label.explosionLevel" /></td>
												<td><form:input path="explosionLevel" id="explosionLevel"
															class="textbox" onkeyup="multiply()" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.predessor" /></td>
												<td><form:input path="predessor" id="predessor"
															class="textbox"  /></td></tr>
												 <tr>
												<td><spring:message code="label.parentmaterial" /><font color="red">*</font></td>
												<td><form:select path="parentMat" class="select" id="parentMat" cssStyle="height:25px" onchange="compare()">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td></tr>
													<tr><td><input type='hidden' id="parentMatNumber"/>
										                 <input type="hidden"
													name="hiddenIdBomPopUp" id="hiddenIdBomPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-quotLine">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="bomLineAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.qmaterial" /><font color="red">*</font> </th>
													<th><spring:message code="label.qty" /><font color="red">*</font> </th>
													<th><spring:message code="label.quom"/><font color="red">*</font> </th>
													<th><spring:message code="label.explosionLevel" /></th>
													<th><spring:message code="label.predessor" /></th>
													<th><spring:message code="label.parentmaterial" /></th>
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="create-AddBomLine" type="button">Add New Bom Line</button>
									

								</div>
							</div>
							</div>
							<c:choose>
							<c:when test="${save }">
							<input type="submit" value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbtnid" /></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled" value="<spring:message code="label.save"/>"
									class="btn btn-danger" id="sumbtnid" />
									</c:otherwise>
									</c:choose><input type="reset" value="<spring:message code="label.reset"/>"
									class="btn btn-primary" />
						</form:form>
					</div>

				</div>
			
				
				<!-- Edit tab -->

				<div id="tabs-1" class="TabbedPanelsContent">
					<div align="left" class="TabbedPanelsContent">
						
							<form:form action="bomEdit.mnt" method="GET"
								commandName="bomCommand" id="editbomForm">
							<%-- 	<c:forEach var="bomEditList" items="${bomEditList}">
							<c:set var="edit" value="${bomEditList}"></c:set>
						</c:forEach> --%>

						 <c:if test="${bomEditList!=null}"> 

										<table class="tableGeneral">

											 	<tr>
												<td colspan="2"><c:forEach
														var="updateBomDuplicate" items="${updateBomDuplicate}">
														<div class="alert-warning" id="savemessage">
														<strong>Warning!</strong>
															<font color="#C09853"><c:out value="${updateBomDuplicate}" /></font>
														</div>
													</c:forEach></td>
											</tr>

											<form:hidden path="bomIdEditt" />
											<tr>
									<td><spring:message code="label.qmaterial" /><font
										color="red">*</font> </td>
									<td><form:select path="bmaterial_IdEditt" class="select" onchange="doAjaxPostEdit()">
											<form:option value="">-Select-</form:option>
											<form:options items="${material}" />
										</form:select></td>
										<!-- <td style="display: none" id="editmessage" class="alert-warning"></td> -->
								<td colspan="2" id="editmessage" style="display: none;">
								<div class="alert-warning">
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.qmaterial" /> <spring:message code="label.duplicateCheck" />
								</div>
							</td>
							
								</tr>
								<tr>
									<td><spring:message code="label.qplant" /><font
										color="red">*</font> </td>
									<td><form:select path="plant_IdEditt" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${plant}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.usage" /><font
										color="red">*</font> </td>
									<td><form:input path="usageEditt" id="usageEditt" class="textbox" maxlength="250"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.bomCategory" /><font
										color="red">*</font> </td>
									<td><form:select path="bomCategoryIdEditt" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${bomcategory}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.revisionLevel" /><font
										color="red">*</font> </td>
									<td><form:input path="revisionLevelEditt" id="revisionLevelEditt"
											class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.bomnumber" /><font
										color="red">*</font> </td>
									<td><form:input path="bomNumberEditt" id="bomNumberEditt"
											class="textbox" maxlength="20"/></td>
								</tr>
									<tr>
									<td><spring:message code="label.qty" /><font
										color="red">*</font> </td>
									<td><form:input path="qtyEdit" id="qtyEdit"
											class="textbox" maxlength="20"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.uom" /><font
										color="red">*</font> </td>
									<td><form:select path="uOMIdEdit" class="select">
											<form:option value="">-Select-</form:option>
											<form:options items="${uom}" />
										</form:select></td>
								</tr>
								</table>

									

								<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
									<div id="scroll1">
											<ul>

									<li><a href="#tab1"><spring:message code="label.bomline"/></a></li>

								</ul>

								<!--Sub Tab-1 -->
								<div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {
												
												var mIdEditt = $("#mIdEditt"),
												quantityEditt = $("#quantityEditt"),uommEditt = $("#uommEditt"),explosionLevelEditt = $("#explosionLevelEditt"), predessorEditt = $("#predessorEditt"), parentMatEditt = $("#parentMatEditt"),hiddenEdit = $("#hiddenIdEditQPopUp"),
											
												allFields = $([]).add(parentMatEditt)
														.add(quantityEditt)
														.add(uommEditt)
														.add(explosionLevelEditt)
														.add(predessorEditt)
														.add(hiddenEdit),
														tips = $(".validateTips");
												
												function updateTips(t) {
													tips
															.text(t)
															.addClass(
																	"ui-state-highlight");
													setTimeout(
															function() {
																tips
																		.removeClass(
																				"ui-state-highlight",
																				1500);
															}, 500);
												}

												function checkLength(o, n, min, max) {
													if (o.val().length > max
															|| o.val().length < min) {
														o
																.addClass("ui-state-error");
														updateTips("Length of "
																+ n
																+ " must be between "
																+ min + " and "
																+ max + ".");
														return false;
													} else {
														return true;
													}
												}
																	
												function selectLength(o, n) {
													if (o.val()=='0') {
														o
																.addClass("ui-state-error");
														updateTips(n+" is Required");
														return false;
													} else {
														return true;
													}
												}
												function checkRegexp(o, regexp,
														n) {
													if (!(regexp.test(o.val()))) {
														o
																.addClass("ui-state-error");
														updateTips(n);
														return false;
													} else {
														return true;
													}
												}

												$("#dialog-form-BomEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 300,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			
																			allFields
																					.removeClass("ui-state-error");
																			bValid1 = bValid1
																			&& selectLength(
																					mIdEditt,
																					"Material"
																					);
																			bValid1 = bValid1
																			&& checkLength(
																					quantityEditt,
																					"Quantity",
																					1,
																					16);
																			bValid1 = bValid1
																			&& selectLength(
																					uommEditt,
																					"UOM"
																					);
																			bValid1 = bValid1
																				&& checkLength(
																						explosionLevelEditt,
																						"Explosion Level",
																						1,
																						16);
																			bValid1 = bValid1
																			&& checkLength(
																					predessorEditt,
																					"Predecessor",
																					1,
																					16);
																		
																		 	bValid1 = bValid1
																					&& checkRegexp(
																							explosionLevelEditt,
																							/^([0-9])+$/i,
																							"Explosion Level may consist of  0-9");
																			 bValid1 = bValid1
																					&& checkRegexp(
																							predessorEditt,
																							/^([0-9])+$/i,
																							"Predecessor may consist of  0-9"); 
																	

																			if (bValid1) {
																			
																				if (hiddenEdit
																						.val() == "0"
																						|| hiddenEdit
																								.val() == "") {
																					$(
																							"#AddBomEdit tbody")
																							.append(
																									"<tr id="+btrid+">"
																											 + "<td><spring:bind path='bomCommand.bomLineIdEditt'><input type='hidden' name='bomLineIdEditt' id='bomLineIdEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>" 
																											+ "<spring:bind path='bomCommand.mIdEditt'><input type='hidden' name='mIdEditt' id='mIdEditt"
																											+ btrid
																											+ "' value="
																											+ mIdEditt
																													.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											
																											+"<spring:bind path='bomCommand.materialName'><input type='text' name='materialName' id='materialName"
																												+ btrid
																												+ "' value="
																												+$('#mIdEditt :selected').text()
																												+ " class='textbox' readonly/></spring:bind></td>"
																											
																												+ "<td><spring:bind path='bomCommand.quantityEditt'><input name='quantityEditt' id='quantityEditt"
																												+ btrid
																												+ "' value="
																												+ quantityEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind></td>"
																												
																												+ "<td><spring:bind path='bomCommand.uommEditt'><input type='hidden' name='uommEditt' id='uommEditt"
																												+ btrid
																												+ "' value="
																												+ uommEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind>"
																												+"<spring:bind path='bomCommand.uomName'><input type='text' name='uomName' id='uomName"
																												+ btrid
																												+ "' value="
																												+$('#uommEditt :selected').text()
																												+ " class='textbox' readonly/></spring:bind></td>"
																												
																												+ "<td><spring:bind path='bomCommand.explosionLevelEditt'><input name='explosionLevelEditt' id='explosionLevelEditt"
																												+ btrid
																												+ "' value="
																												+ explosionLevelEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind></td>"
																												
																												+ "<td><spring:bind path='bomCommand.predessorEditt'><input name='predessorEditt' id='predessorEditt"
																												+ btrid
																												+ "' value="
																												+ predessorEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind></td>"
																												
																												
																												
																												+"<td><spring:bind path='bomCommand.parentMatEditt'><input type='hidden' name='parentMatEditt' id='parentMatEditt"
																												+ btrid
																												+ "' value="
																												+ parentMatEditt
																														.val()
																												+ " class='textbox' readonly/></spring:bind>"
																												
																												+"<spring:bind path='bomCommand.parentMaterialName'><input type='text' name='parentMaterialName' id='parentMaterialName"
																													+ btrid
																													+ "' value="
																													+$('#parentMatEditt :selected').text()
																													+ " class='textbox' readonly/></spring:bind>"
																																																					
																												+"<input type='hidden' name='Check' id='Check' value='0' /></td>"
																												+
																												"<td><a href='#'  onclick='editBomDetailsInEditNew("
																												+ btrid
																												+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																												+ "<td><a href='#'  onclick='removeBomDetailsEditNew("
																												+ btrid
																												+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																												+ "</tr>");
																					btrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																				
																				if (hiddenEdit
																						.val() != "0") {
																					$(
																							'#mIdEditt'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#mIdEditt')
																											.val());
																					$(
																							'#materialName'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#mIdEditt :selected').text());
																					
																					$(
																							'#quantityEditt'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#quantityEditt')
																											.val());
																					
																					$(
																							'#uommEditt'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#uommEditt')
																											.val());
																					$(
																							'#uomName'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#uommEditt :selected').text());
																																									
																					$(
																							'#explosionLevelEditt'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#explosionLevelEditt')
																											.val());
																					
																					$(
																							'#predessorEditt'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#predessorEditt')
																											.val());	
																					$(
																							'#parentMatEditt'
																									+ hiddenEdit
																											.val())
																							.val(
																									$(
																											'#parentMatEditt')
																											.val());
																					$(
																							'#parentMaterialName'
																									+ hiddenEdit
																											.val())
																							.val(
																									$('#parentMatEditt :selected').text());
																																			
																					$(
																							'#hiddenIdBomPopUpEdit')
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
																			$(
																					this)
																					.dialog(
																							"close");
																		}
																	},
																	close : function() {
																		allFields
																				.val(
																						"")
																				.removeClass(
																						"ui-state-error");
																	}
																});

												$("#create-AddBomEdit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-BomEdit")
																			.dialog(
																					"open");

																});
											});
											function removeBomDetailsEditNew(
													id) {
											$('#' + id).remove();
											}
											function editBomDetailsInEditNew(
													link) {
												
																
												$("#dialog-form-BomEdit")
														.dialog("open");
												
												$('#mIdEditt').val(
														$(
																'#mIdEditt'
																		+ link)
																.val());
												
												$('#quantityEditt').val(
														$(
																'#quantityEditt'
																		+ link)
																.val());
												
												
												$('#uommEditt').val(
														$(
																'#uommEditt'
																		+ link)
																.val());
											
												$('#explosionLevelEditt').val(
														$(
																'#explosionLevelEditt'
																		+ link)
																.val());
												$('#predessorEditt').val(
														$(
																'#predessorEditt'
																		+ link)
																.val());
												$('#parentMatEditt').val(
														$(
																'#parentMatEditt'
																		+ link)
																.val());
												$('#hiddenIdEditQPopUp')
														.val(link);

											}
										</script>


										<div id="dialog-form-BomEdit" title="Add New Bom Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

											 <tr>
												<td><spring:message code="label.qmaterial" /><font color="red">*</font></td>
												<td><form:select path="mIdEditt" class="select" id="mIdEditt" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.qty" /><font color="red">*</font></td>
												<td><form:input path="quantityEditt" id="quantityEditt"
															class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.quom" /><font color="red">*</font></td>
													<td><form:select path="uommEditt" id="uommEditt" class="select" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${uom }" />
														</form:select></td>
											</tr>
																			
											<tr>
												<td><spring:message code="label.explosionLevel" /></td>
												<td><form:input path="explosionLevelEditt" id="explosionLevelEditt"
															class="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.predessor" /></td>
												<td><form:input path="predessorEditt" id="predessorEditt"
															class="textbox" /></td>
											</tr>		
											<tr>
												<td><spring:message code="label.qmaterial" /><font color="red">*</font></td>
												<td><form:select path="parentMatEditt" class="select" id="parentMatEditt" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select><input type="hidden"
													name="hiddenIdEditQPopUp" id="hiddenIdEditQPopUp" value="0" /></td>
											</tr>
											
 										</table>
										</div>

										<div id="users-contain-BomEdit">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="AddBomEdit" class="table">
												<thead>
													<tr>
															<th><spring:message code="label.qmaterial" /><font color="red">*</font></th>
															<th><spring:message code="label.qty" /><font color="red">*</font></th>
															<th><spring:message code="label.quom" /><font color="red">*</font></th>
															<th><spring:message code="label.explosionLevel" /></th>
															<th><spring:message code="label.predessor" /></th>
															<th><spring:message code="label.qmaterial" /></th>
															
														</tr>

														</thead>
												<tbody>
													<c:forEach var="bomLineEditList"
															items="${bomLineEditList}">

															<c:set var="edit1" value="${bomLineEditList.bomLineId}"></c:set> 
														<%-- 	<c:if test="${edit1!=null}"> --%>
																<tr id="${bomLineEditList.bomLineId}">

																	
																	<spring:bind
																			path="bomCommand.bomLineIdEditt">
																			<input type="hidden" name="bomLineIdEditt"
																				class="textbox" 
																				value="${bomLineEditList.bomLineId}" id="bomLineIdEditt${bomLineEditList.bomLineId}" />
																		</spring:bind>
																
																		<spring:bind
																			path="bomCommand.mIdEditt">
																			<input type="hidden" name="mIdEditt"
																				class="textbox" 
																				value="${bomLineEditList.material_IdEditt}" id="mIdEditt${bomLineEditList.bomLineId}" />
																		</spring:bind>
																		
																	<td><spring:bind
																			path="bomCommand.materialName">
																			<input type="text" name="materialName"
																				class="textbox" readonly="readonly"
																				value="${bomLineEditList.materialName}" id="materialName${bomLineEditList.bomLineId}" />
																		</spring:bind></td>	
																		<td><spring:bind
																			path="bomCommand.quantityEditt">
																			<input type="text" name="quantityEditt"
																				class="textbox" readonly="readonly"
																				value="${bomLineEditList.quantityEditt}" id="quantityEditt${bomLineEditList.bomLineId}"/>
																		</spring:bind></td>
																		<spring:bind
																			path="bomCommand.uommEditt">
																			<input type="hidden" name="uommEditt" 
																				class="textbox" 
																				value="${bomLineEditList.uom_IdEditt}"  id="uommEditt${bomLineEditList.bomLineId}"/>
																		</spring:bind>
																		<td><spring:bind
																			path="bomCommand.uomName">
																			<input type="text" name="uomName"
																				class="textbox" readonly="readonly"
																				value="${bomLineEditList.uomName}" id="uomName${bomLineEditList.bomLineId}" />
																		</spring:bind></td>	
																																			
																	<td><spring:bind
																			path="bomCommand.explosionLevelEditt">
																			<input type="text" name="explosionLevelEditt" id="explosionLevelEditt${bomLineEditList.bomLineId}"
																				class="textbox" readonly="readonly"
																				value="${bomLineEditList.explosionLevelEditt }" />
																		</spring:bind></td>
																
																	<td><spring:bind
																			path="bomCommand.predessorEditt">
																			<input type="text" name="predessorEditt" 
																				id="predessorEditt${bomLineEditList.bomLineId}" class="textbox" readonly="readonly"
																				value="${bomLineEditList.predessorEditt }" />
																		</spring:bind></td>
																		
																		<spring:bind
																			path="bomCommand.parentMatEditt">
																			<input type="hidden" name="parentMatEditt"
																				class="textbox" 
																				value="${bomLineEditList.parentMaterialEditt}" id="parentMatEditt${bomLineEditList.bomLineId}" />
																		</spring:bind>
																		
																	<td><spring:bind
																			path="bomCommand.parentMaterialName">
																			<input type="text" name="parentMaterialName"
																				class="textbox" readonly="readonly"
																				value="${bomLineEditList.parentMaterialName}" id="parentMaterialName${bomLineEditList.bomLineId}" />
																		</spring:bind>											
																		<input type="hidden" name="${bomLineEditList.bomLineId}Check" id="${bomLineEditList.bomLineId}Check" value="0"/></td>
																		<td><a href="#"
															id="${bomLineEditList.bomLineId}"
															onclick="javascript:editBomDetailsInEdit(this)"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="${bomLineEditList.bomLineId}"></img></a></td>
														<td><a href="#"
															id="${bomLineEditList.bomLineId}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																id="${bomLineEditList.bomLineId}"></img></a></td>
																</tr>
		
														<tr>
														
															<script type="text/javascript">
																function getID1(
																		link) {
																	
																	alert("Deleting Particular Row Will Deleted Once You Click Ok");
																	 document
																			.getElementById(link.id
																					+ "Check").value = "1"; 
																	document
																			.getElementById(link.id).style.display = "none";
																}
																function editBomDetailsInEdit(
																		link) {
															
																	$(
																			"#dialog-form-BomEdit")
																			.dialog(
																					"open");
																	$('#mIdEditt').val(
																			$(
																					'#mIdEditt'
																							+ link.id)
																					.val());
																	$('#quantityEditt').val(
																			$(
																					'#quantityEditt'
																							+ link.id)
																					.val());
																	
																	$('#uommEditt').val(
																			$(
																					'#uommEditt'
																							+ link.id)
																					.val());
																	
																	$('#explosionLevelEditt').val(
																			$(
																					'#explosionLevelEditt'
																							+ link.id)
																					.val());
																	$('#predessorEditt').val(
																			$(
																					'#predessorEditt'
																							+ link.id)
																					.val());
																	$('#parentMatEditt').val(
																			$(
																					'#parentMatEditt'
																							+ link.id)
																					.val());
																	$('#hiddenIdEditQPopUp')
																			.val(
																					link.id);

																}
															</script>
														</tr>
												 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddBomEdit" type="button">Add New
											Bom Line</button>

									</div>

								</div>
								<table>
									<tr>
										<td colspan="">
										
										<c:choose>
										<c:when test="${update}">
										<input type="submit"
											value="<spring:message code="label.update"/>"
											class="btn btn-primary" id="updateid" /></c:when>
											<c:otherwise>
											<input type="submit" disabled="disabled"
											value="<spring:message code="label.update"/>"
											class="btn btn-danger" id="updateid" />
											</c:otherwise>
											</c:choose></td>

									</tr>

								</table>
									</div>
									</div>
								</div>
								</c:if>	
								
							</form:form>
					</div>
								</div>
					</div>
				</div>
			</div>
		
</body>

</html>




