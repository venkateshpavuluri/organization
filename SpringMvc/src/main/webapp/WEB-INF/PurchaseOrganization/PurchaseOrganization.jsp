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
						jQuery.validator.addMethod("alphabets", function(value,
								element) {
							return this.optional(element)
									|| /^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});

						jQuery.validator.addMethod("alphanumeric", function(
								value, element) {
							return this.optional(element)
									|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});

						jQuery.validator.addMethod("specialcharacters",
								function(value, element) {
									return this.optional(element)
											|| /^[0-9a-zA-Z&_ ]+$/.test(value);
								});
						$('#posubmit')
								.click(
										function(event) {

											$("#poADD")
													.validate(
															{
																rules : {
																	purOrg : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	plantId : {
																		required : true
																	},
																	orgId : {
																		required : true
																	}
																},
																messages : {

																	purOrg : {

																		required : "<font style='color: red;'><b>Purchase Organization is Required.</b></font>",

																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},

																	plantId : "<font style='color: red;'><b>Select atleast one Plant</b></font>",
																	orgId : "<font style='color: red;'><b>Select atleast one Company</b></font>"
																},

															});
										});

						$('#poUpdate')
								.click(
										function(event) {

											$("#poedit")
													.validate(
															{
																rules : {
																	editpurOrg : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true

																	},
																	editplantId : {
																		required : true
																	},
																	editorgId : {
																		required : true
																	},

																},
																messages : {
																	editpurOrg : {

																		required : "<font style='color: red;'><b>Purchase Organization is Required.</b></font>",

																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																	},
																	editplantId : "<font style='color: red;'><b>Select atleast one Plant Type</b></font>",

																	editorgId : "<font style='color: red;'><b>Select atleast one Company Type</b></font>",
																},

															});
										});
					});
</script>

<script>
function AjaxForPlants(id, Mode) {
	
	var pId = $('#' + id).val();

	var i = 1, msg = null;

	$.ajax({
				type : "POST",
				url : "forStorLocIdsPurchaseOrganization.mnt",
				data : "plantId=" + pId,
				success : function(response) {
					
					$("#slId").val(response);
				   
					var ss = "";
					if (Mode == 'AddMode') {
						ss = $("#slId").empty();
						msg = "The Selected Plant Name Does Not Contain Storage Locations";
					} else if (Mode == 'ToAddMode') {
						ss = $("#toSlId").empty();
						msg = "The Selected To Plant Name Does Not Contain Storage Locations";
					} else if (Mode == 'EditMode') {
						ss = $("#slIdEdit").empty();
						msg = "The Selected Plant Name Does Not Contain Storage Locations";
					} else {
						ss = $("#toSlIdEdit").empty();
						msg = "The Selected To Plant Name Does Not Contain Storage Locations";
					}
					if (response == "") {
						if (Mode == 'AddMode' || Mode == 'ToAddMode') {
							document.getElementById("addmessage").style.display = "block";
							$('#addmessage').html(msg);
						} else {
							document.getElementById("addmessage").style.display = "block";
							$('#addmessage').html(msg);
						}

					} else {
						document.getElementById("addmessage").style.display = "none";
						document.getElementById("addmessage").style.display = "none";

						$.each(response, function(key, value) {
							if (i == 1) {
								/* ss.append(new Option("-Select-", "")); */
								ss.append(new Option(value, key));
							} else {
								ss.append(new Option(value, key));
							}
							i++;
						});

					}

				},
				error : function(e) {
					alert('Error' + e);
				}

			});

}

</script>

<script>
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

		$("#add,#search").click(function(e) {
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

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>

</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Purchase Organization</div>

		<!-- Tabs Declaration -->

		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="povalues" items="${povalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!-- Search tab part -->

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
                 <table><tr>
							<td colspan="4" class="alert-warning" id="addmessage"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
					</table>
					<form:form action="posearch.mnt" method="GET" commandName="poadd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="purOrgAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.porg" />
											<spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach> <c:if test="${param.listwar!=null }">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>

											<spring:message code="label.porg" />
											<spring:message code="label.saveFail" />
										</div>
									</c:if> <c:forEach var="purOrgUpadte" items="${purOrgUpadte}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.porg" />
											<spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach> <c:forEach var="purOrgUpadteError"
										items="${purOrgUpadteError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.porg" />
											<spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach> <c:forEach var="purOrgDelete" items="${purOrgDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success" /></strong>
											<spring:message code="label.porg" />
											<spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach> <c:forEach var="purOrgDeleteError"
										items="${purOrgDeleteError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error" /></strong>
											<spring:message code="label.porg" />
											<spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="poadd.operations">
										<select class="select" name="operations">
											<option value="<s:message code='assignedOperator'/>">
												<spring:message code="label.equalsTo" />
											</option>
											<option value="<s:message code='notequalsOperator'/>">
												<spring:message code="label.notEqualsTo" />
											</option>
											<option value="<s:message code='beginsWithOperator'/>">
												<spring:message code="label.beginsWith" />
											</option>
											<option value="<s:message code='endsWithOperator'/>">
												<spring:message code="label.endsWith" />
											</option>
											<option value="<s:message code='containsOperator'/>">
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
								<c:choose>
									<c:when test="${search}">

										<td><input type="submit"
											value="<spring:message code="label.search"/>"
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" disabled="disabled"
											value="<spring:message code="label.search"/>"
											class="btn btn-danger" /></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</table>
					</form:form>


					<!-- Displaying  the Searched information by using display tag -->

					<c:if test="${prvalues!=null }">
						<display:table id="purchaseOrganization"
							name="purchaseOrganization" requestURI="posearch.mnt"
							pagesize="4" class="table">

							<display:column property="purOrg" titleKey="label.porg"
								media="html" sortable="true"></display:column>

							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit }">
										<a
											href="purOrgEditHome.mnt?purOrgEdit=<c:out value="${purchaseOrganization.purOrg_Id}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px" height="20px"
											class="btn btn-danger" /></a>
									</c:otherwise>
								</c:choose>

							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete}">
										<a
											href="purOrgDelete.mnt?purOrgDelete=<c:out value="${purchaseOrganization.purOrg_Id}"/>"
											style="color: red"
											onclick="return confirm('Do u want to delete the Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>

										<a><img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>


							</display:column>

							<!-- For displaying the pagination part -->

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
							<display:setProperty name="paging.banner.group_size" value="3" />
							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>
					</c:if>

				</div>
			</div>

			<!-- Add tab details -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="purchaseOrganizationAdd.mnt" method="POST"
						commandName="poadd" id="poADD">
						<table>

							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach
										var="addPurchaseOrganizationDuplicate"
										items="${addPurchaseOrganizationDuplicate}">
										<div class="alert-warning" id="warningmesssage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.porg" />
											<spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.porg" /><font color="red">*</font></td>
								<td><form:input path="purOrg" id="purOrg" class="textbox"
										maxlength="50" /></td>
							</tr>



	<!-- Company Details tab -->

							<tr>
								<td><spring:message code="label.pocompany" /><font
									color="red">*</font></td>
								<td><form:select path="orgId" multiple="true" id="orgId"
										class="select" onclick="AjaxForPlants(this.id,'AddMode')">
										<%-- <form:option value="..Select.." >--Select--</form:option> --%>
										<form:options items="${PurOrgCompany}" />
									</form:select></td>

								<!-- <td><a href="#" id="addoc"><img src="images/add (1).png""></img></a></td> -->
							</tr>


							<tr>
								<td><spring:message code="label.poplant" /><font
									color="red">*</font></td>
								<td><form:select path="plantId" multiple="true"
										id="slId" class="select">
										<%-- <form:option value="..Select.." >--Select--</form:option> --%>
										<%-- <form:options items="${PurOrgPlant}" /> --%>
									</form:select></td>
								<%-- <td><font color="red"> <form:errors
														path="plantId"></form:errors></font></td> --%>
							</tr>





						
						</table>



						<c:choose>
							<c:when test="${save }">
								<input type="submit" value="Save"
									name="<spring:message
								code="label.save" />"
									class="btn btn-primary" id="posubmit" />
							</c:when>
							<c:otherwise>
								<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/> "
									class="btn btn-danger" id="orgTypeSubmit" />
							</c:otherwise>
						</c:choose>
						<input type="reset" class="btn btn-primary"
							value="<spring:message
								code="label.reset" />" />

					</form:form>
				</div>
			</div>
			<!-- Edit tab -->

			<div id="tabs-1" class="TabbedPanelsContent">

				<c:forEach var="povalues" items="${povalues}">
				<table>
						<tr>
							<td colspan="4" class="alert-warning" id="editmessage"
								style="display: none; width: 450px; height: 25px;"></td>
						</tr>
					</table>
					<form:form action="poedit.mnt" method="POST" commandName="poadd"
						id="poedit">

						<table>
							<%-- <form:hidden path="aid" /> --%>
							<tr>
								<td colspan="2" height="20px"><c:forEach
										var="addPurchaseOrganizationDuplicate"
										items="${addPurchaseOrganizationDuplicate}">

										<div class="alert-warning" id="warningmesssage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.porg" />
											<spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="purOrg_Id" id="purOrg_Id" />
							<tr>
								<td><spring:message code="label.porg" /><font color="red">*</font></td>
								<td><form:input path="editpurOrg" id="editpurOrg"
										class="textbox" maxlength="50" /></td>
							</tr>

							
							<!-- Tab for Company -->


							<tr>
								<td><spring:message code="label.pocompany" /><font
									color="red">*</font></td>
								<td><form:select path="editorgId" multiple="true"
										id="editorgId" class="select" onclick="AjaxForPlants(this.id,'EditMode')">
										<%-- <form:option value="..Select.." >--Select--</form:option> --%>
										<form:options items="${PurOrgCompany}" />
									</form:select></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.poplant" /><font
									color="red">*</font></td>
								<td><form:select path="editplantId" multiple="true"
										id="slIdEdit" class="select">
										<%-- <form:option value="..Select.." >--Select--</form:option> --%>
										 <form:options items="${PurOrgPlant}" /> 
									</form:select></td>
							</tr>





						</table>
						<c:choose>
							<c:when test="${update}">
								<input type="submit"
									value="<spring:message
								code="label.update" />"
									name="Update" class="btn btn-primary" id="poUpdate" />
							</c:when>
							<c:otherwise>
								<input type="submit" disabled="disabled"
									value="<spring:message code="label.update"/> "
									class="btn btn-danger" id="orgTypeSubmitupdate" />
							</c:otherwise>

						</c:choose>

					</form:form>
				</c:forEach>

			</div>

		</div>

	</div>
</body>

</html>




