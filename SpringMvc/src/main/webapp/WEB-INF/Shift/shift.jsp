<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />

<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
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

											$("#addShiftForm")
													.validate(
															{

																rules : {
																	shiftcode : {
																		required : true,
																		alphanumeric : true
																	},
																	shift : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	starttime : {
																		required : true
																	},
																	endtime : {
																		required : true
																	},
																},
																messages : {
																	shiftcode : {
																		required : "<font style='color: red;'><b>Shift Code is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																	},
																	shift : {
																		required : "<font style='color: red;'><b>Shift is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	starttime : "<font style='color: red;'><b>Start Time is Required</b></font>",
																	endtime : "<font style='color: red;'><b>End Time is Required</b></font>"
																},

															});
										});

						$('#updateId')
								.click(
										function(event) {

											$("#upShiftForm")
													.validate(
															{
																rules : {
																	shiftcodeedit : {
																		required : true,
																		alphanumeric : true
																	},
																	shiftedit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	starttimeedit : {
																		required : true
																	},
																	endtimeedit : {
																		required : true
																	},
																},
																messages : {
																	shiftcodeedit : {
																		required : "<font style='color: red;'><b>Shift Code is Required</b></font>",
																		alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
																	},
																	shiftedit : {
																		required : "<font style='color: red;'><b>Shift is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																	starttimeedit : "<font style='color: red;'><b>Start Time is Required</b></font>",
																	endtimeedit : "<font style='color: red;'><b>End Time is Required</b></font>"
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
	function timedifference() {
		//alert("check");
		var start = $("#starttime").val();
		//alert(start);

		var end = $("#endtime").val();
		//alert(end);

		sum = (parseFloat(end) - parseFloat(start) + 24) % 24;
		$("#workhrs").val(sum);

	}
</script>
<script type="text/javascript">
	function timediff() {

		var start = $("#starttimeedit").val();
		//alert(start);
		var end = $("#endtimeedit").val();
		sum = (parseFloat(end) - parseFloat(start) + 24) % 24;
		$("#workhrsedit").val(sum);

	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#subid').click(function(e) {

			var aid = document.getElementById("shifthide").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById("shifthide").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

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
<script type="text/javascript">
	function numbersonly(myfield, e, dec) {

		var key;
		var keychar;

		if (window.event)
			key = window.event.keyCode;
		else if (e)
			key = e.which;
		else
			return true;
		keychar = String.fromCharCode(key);

		// control keys
		if ((key == null) || (key == 0) || (key == 8) || (key == 9)
				|| (key == 13) || (key == 27))
			return true;

		// numbers
		else if ((("0123456789.").indexOf(keychar) > -1))
			return true;

		// decimal point jump
		/* else if (dec && (keychar == ".")) {
			myfield.form.elements[dec].focus();
			return false;
		}  */
		else
			return false;
	}
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

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Shift Details</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
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
					<form:form action="searchShift.mnt" method="GET"
						commandName="Shift">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="accountsuccess"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success" /></strong>
											<s:message code="label.shift" />
											<s:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:forEach var="accountsuccess" items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error" /></strong>
											<s:message code="label.shift" />
											<s:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach var="ShiftUpdate" items="${ShiftUpdate}">
										<div class="alert-success">
											<strong><s:message code="label.success" /> </strong>
											<s:message code="label.shift" />
											<s:message code="label.updateSuccess" />

										</div>
									</c:forEach> <c:forEach var="ShiftUpdateError" items="${ShiftUpdateError}">
										<div class="alert-danger">
											<strong><s:message code="label.Error" /> </strong>
											<s:message code="label.shift" />
											<s:message code="label.updateFail" />

										</div>
									</c:forEach> <c:forEach var="ShiftDelete" items="${ShiftDelete}">
										<div class="alert-success">
											<strong><s:message code="label.success" /> </strong>
											<s:message code="label.shift" />
											<s:message code="label.deleteSuccess" />

										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td colspan="2"><c:forEach items="${ShiftDeleteError}">
										<div class="alert-danger">
											<strong><s:message code="label.error" /> </strong>
											<s:message code="label.shift" />
											<s:message code="label.deleteFail" />

										</div>
									</c:forEach></td>
							</tr>



							<%-- <tr>
							<td>Shift Code</td>
								<td><form:select path="shiftId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${shiftSearch}" />
								</form:select></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary"/></td>
							</tr>
 --%>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="Shift.operations">
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
										<c:when test="${privileges eq messageup }">
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

					<c:if test="${shiftBeans!=null}">
						<display:table id="shiftiid" name="shiftBeans"
							requestURI="searchShift.mnt" pagesize="5" class="table">
							<display:column property="shiftId" title="ShiftID" media="none"
								sortable="true"></display:column>
							<display:column property="shiftcode" titleKey="label.shiftcode"
								media="html" sortable="true"></display:column>
							<display:column property="shift" titleKey="label.shift"
								media="html" sortable="true"></display:column>
							<display:column property="starttime" titleKey="label.starttime"
								media="html" sortable="true"></display:column>
							<display:column property="endtime" titleKey="label.endtime"
								media="html" sortable="true"></display:column>
							<display:column property="workhrs" titleKey="label.workhours"
								media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit }">
										<a
											href="shiftEdit.mnt?shiftedit=<c:out value="${shiftiid.shiftId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete}">
										<a
											href="shiftDelete.mnt?shiftdelete=<c:out value="${shiftiid.shiftId}"/>"
											style="color: red"><img src="images/Delete.jpg"
											width="20px" height="20px"
											onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="saveShift.mnt" method="POST" id="addShiftForm"
						commandName="Shift">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="shiftsuccessdup"
										items="${shiftsuccessdup}">
										<div class="alert-warning">
											<strong> <s:message code="label.warning" />
											</strong>
											<s:message code="label.shiftcode" />
											<s:message code="label.duplicateCheck"></s:message>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="shifthide" id="shifthide" />
							<tr>
								<td><spring:message code="label.shiftcode" /><span
									class="required">*</span></td>
								<td><form:input path="shiftcode" id="shiftcode"
										name="shiftcode" class="textbox" maxlength="1" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.shift" /><span
									class="required">*</span></td>
								<td><form:input path="shift" id="shift" name="shift"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.starttime" /><span
									class="required">*</span></td>
								<%-- <td><form:input path="starttime" id="starttime"
										name="starttime" onselect="timedifference()" class="textbox" onKeyPress="return numbersonly(this, event)" /></td> --%>
								<td><form:select path="starttime" class="select"
										onchange="timedifference()">
										<form:option value="">-Select-</form:option>
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
										<form:option value="6">6</form:option>
										<form:option value="7">7</form:option>
										<form:option value="8">8</form:option>
										<form:option value="9">9</form:option>
										<form:option value="10">10</form:option>
										<form:option value="11">11</form:option>
										<form:option value="12">12</form:option>
										<form:option value="13">13</form:option>
										<form:option value="14">14</form:option>
										<form:option value="15">15</form:option>
										<form:option value="16">16</form:option>
										<form:option value="17">17</form:option>
										<form:option value="18">18</form:option>
										<form:option value="19">19</form:option>
										<form:option value="20">20</form:option>
										<form:option value="21">21</form:option>
										<form:option value="22">22</form:option>
										<form:option value="23">23</form:option>
										<form:option value="24">24</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.endtime" /><span
									class="required">*</span></td>
								<%--  <td><form:input path="endtime" 
										onselect="timedifference()" class="textbox" onKeyPress="return numbersonly(this, event)" /></td>  --%>
								<td><form:select path="endtime" class="select"
										onchange="timedifference()">
										<form:option value="">-Select-</form:option>
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
										<form:option value="6">6</form:option>
										<form:option value="7">7</form:option>
										<form:option value="8">8</form:option>
										<form:option value="9">9</form:option>
										<form:option value="10">10</form:option>
										<form:option value="11">11</form:option>
										<form:option value="12">12</form:option>
										<form:option value="13">13</form:option>
										<form:option value="14">14</form:option>
										<form:option value="15">15</form:option>
										<form:option value="16">16</form:option>
										<form:option value="17">17</form:option>
										<form:option value="18">18</form:option>
										<form:option value="19">19</form:option>
										<form:option value="20">20</form:option>
										<form:option value="21">21</form:option>
										<form:option value="22">22</form:option>
										<form:option value="23">23</form:option>
										<form:option value="24">24</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.workhours" /></td>
								<td><form:input path="workhrs" id="workhrs" name="workhrs"
										class="textbox" readonly="true" /></td>
							</tr>

							<tr>

								<td colspan="2"><c:choose>
										<c:when test="${save}">
											<input type="submit"
												value="<spring:message code="label.save"/>" id="sumbtnid"
												class="btn btn-primary" />
											<input type="reset" class="btn btn-primary"
												value="<spring:message code="label.reset"/>" />
										</c:when>
										<c:otherwise>
											<input type="submit"
												value="<spring:message code="label.save"/>"
												disabled="disabled" id="sumbtnid" class="btn btn-danger" />
											<input type="reset" class="btn btn-primary"
												value="<spring:message code="label.reset"/>" />
										</c:otherwise>

									</c:choose></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="ShiftEditValues" items="${editvalues }">
						<form:form action="shiftUpdate.mnt" method="POST"
							commandName="Shift" id="upShiftForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach var="shiftsuccessdup"
											items="${shiftsuccessdupedit}">
											<div class="alert-warning">
												<strong> <s:message code="label.warning" />
												</strong>
												<s:message code="label.shiftcode" />
												<s:message code="label.duplicateCheck"></s:message>
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="shiftdupedit" />
								<form:hidden path="shiftIdedit" />
								<tr>
									<td><spring:message code="label.shiftcode" /><span
										class="required">*</span></td>
									<td><form:input path="shiftcodeedit" id="shiftcode"
											class="textbox" maxlength="1" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.shift" /><span
										class="required">*</span></td>
									<td><form:input path="shiftedit" id="shift"
											class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.starttime" /><span
										class="required">*</span></td>
									<%-- <td><form:input path="starttimeedit" id="starttimeedit"
											onkeyup="timediff()" class="textbox" onKeyPress="return numbersonly(this, event)"/></td> --%>
									<td><form:select path="starttimeedit" class="select"
											onchange="timediff()">
											<form:option value="">-Select-</form:option>
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
										<form:option value="6">6</form:option>
										<form:option value="7">7</form:option>
										<form:option value="8">8</form:option>
										<form:option value="9">9</form:option>
										<form:option value="10">10</form:option>
										<form:option value="11">11</form:option>
										<form:option value="12">12</form:option>
										<form:option value="13">13</form:option>
										<form:option value="14">14</form:option>
										<form:option value="15">15</form:option>
										<form:option value="16">16</form:option>
										<form:option value="17">17</form:option>
										<form:option value="18">18</form:option>
										<form:option value="19">19</form:option>
										<form:option value="20">20</form:option>
										<form:option value="21">21</form:option>
										<form:option value="22">22</form:option>
										<form:option value="23">23</form:option>
										<form:option value="24">24</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.endtime" /><span
										class="required">*</span></td>
									<%-- <td><form:input path="endtimeedit" id="endtimeedit"
											onkeyup="timediff()" class="textbox" onKeyPress="return numbersonly(this, event)"/></td> --%>
									<td><form:select path="endtimeedit" class="select"
											onchange="timediff()">
											<form:option value="">-Select-</form:option>
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
										<form:option value="6">6</form:option>
										<form:option value="7">7</form:option>
										<form:option value="8">8</form:option>
										<form:option value="9">9</form:option>
										<form:option value="10">10</form:option>
										<form:option value="11">11</form:option>
										<form:option value="12">12</form:option>
										<form:option value="13">13</form:option>
										<form:option value="14">14</form:option>
										<form:option value="15">15</form:option>
										<form:option value="16">16</form:option>
										<form:option value="17">17</form:option>
										<form:option value="18">18</form:option>
										<form:option value="19">19</form:option>
										<form:option value="20">20</form:option>
										<form:option value="21">21</form:option>
										<form:option value="22">22</form:option>
										<form:option value="23">23</form:option>
										<form:option value="24">24</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.workhours" /></td>
									<td><form:input path="workhrsedit" id="workhrsedit"
											class="textbox" readonly="true" /></td>
								</tr>

								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${update }">

												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateId" />
											</c:when>

											<c:otherwise>
												<input type="submit"
													value="<spring:message code="label.update"/>"
													disabled="disabled" class="btn btn-danger" id="updateId" />
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




