<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 19-09-2013 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
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

						$('#orgTypeSubmit')
								.click(
										function(event) {

											$("#orgTypeFormgh")
													.validate(
															{
																rules : {
																	orgType : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	}
																},
																messages : {
																	orgType : {
																		required : "<font style='color: red;'><b>Organization Type  is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																},

															});
										});

						$('#orgTypeSubmitupdate')
								.click(
										function(event) {

											$("#otUpdate")
													.validate(
															{
																rules : {
																	orgTypeEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true
																	},
																},
																messages : {
																	orgTypeEdit : {
																		required : "<font style='color: red;'><b>Organization Type is Required</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	},
																},

															});
										});
					});
</script>

<script type="text/javascript">
	function validateOrgType() {

		$("#orgTypeFormgh").validate({

			rules : {

				orgType : {
					required : true

				},

				orgType : "required"

			},

			messages : {

				orgType : "MaterialCode is required "

			}
		});

	}
</script>
<%-- <script type="text/javaScript">
function validateOrgType()
{
var x=document.getElementById("orgType").value;
if(x==""||x==null)
{
alert("Organization Type Name Required");
return false;
}
}
</script> --%>


<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#add.#search").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();

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

<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}

#spinner {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(images/Delete.jpg) 50% 50% no-repeat #ede9df;
}

.spinner {
	position: fixed;
	top: 50%;
	left: 50%;
	margin-left: -50px; /* half width of the spinner gif */
	margin-top: -50px; /* half height of the spinner gif */
	text-align: center;
	z-index: 1234;
	overflow: auto;
	width: 500px; /* width of the spinner gif */
	height: 502px; /*hight of the spinner gif +2px to fix IE8 issue */
}

#loading {
	display: none;
	position: absolute;
	left: 0;
	top: 0;
	z-index: 1000;
	width: 100%;
	height: 100%;
	min-height: 100%;
	background: #000;
	opacity: 0.8;
	text-align: center;
	color: #fff;
}

#loading_anim {
	position: absolute;
	left: 50%;
	top: 50%;
	z-index: 1010;
}
</style>

</head>
<body>


	<div class="divUserDefault">
		<div class="PageTitle">Organization Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="materialValues" items="${organizationTypeValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message
								code="label.edit" /> </a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message
							code="label.search" /> </a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message
							code="label.add" /> </a></li>
			</ul>

			<!--=================== ============================================Begin OrgTypeSearch================================================= -->
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="organizationTypeSearch.mnt" method="get"
						commandName="organizationType">
						<table class="tableGeneral">
							<tr>
								<td colspan="3"><c:forEach var="organizationTypeUpdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success" /> </strong>
											<s:message code="label.organizationType" />
											<s:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:if test="${param.listw!=null }">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error" /> </strong>
											<%-- <c:out value="${param.warning}"></c:out> --%>
											<s:message code="label.organizationType" />
											<s:message code="label.saveFail" />
										</div>
									</c:if> <c:forEach items="${orgTypeUpdate}">
										<c:choose>
											<c:when test="${orgTypeUpdate=='U' }">
												<div class="alert-success" id="successmessage">
													<strong><s:message code="label.success" /> </strong>
													<s:message code="label.organizationType" />
													<s:message code="label.updateSuccess" />
												</div>
											</c:when>
											<c:otherwise>
												<div class="alert-success" id="successmessage">
													<strong><s:message code="label.success" /> </strong>
													<s:message code="label.organizationType" />
													<s:message code="label.deleteSuccess" />
												</div>
											</c:otherwise>
										</c:choose>

									</c:forEach> <c:forEach items="${orgTypeUpdateError}">
										<c:choose>
											<c:when test="${orgTypeUpdateError=='U'}">
												<div class="alert-danger" id="successmessage">
													<strong><s:message code="label.error" /> </strong>
													<s:message code="label.organizationType" />
													<s:message code="label.updateFail"></s:message>
												</div>
											</c:when>
											<c:otherwise>
												<div class="alert-danger" id="successmessage">
													<strong><s:message code="label.error"></s:message>
													</strong>
													<s:message code="label.organizationType" />
													<s:message code="label.deleteFail"></s:message>
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach></td>
							</tr>

							<tr>
								<td class="label"><s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <s:bind path="organizationType.operations">
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
											<input type="submit" value="<s:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<s:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>


						</table>
					</form:form>
					<!--=================== ============================================End OrgTypeSearch================================================= -->

					<!--=================== ============================================Begin DisplayTable================================================= -->

					<c:if test="${organizationTypeSearch!=null}">

						<display:table id="organizationTypeRow"
							name="organizationTypeSearch"
							requestURI="organizationTypeSearch.mnt" pagesize="5"
							class="table">
							<display:column property="orgType"
								titleKey="label.organizationType" media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="organizationTypeEditHome.mnt?organizationTypeEdit=<c:out value="${organizationTypeRow.orgTypeId}"/>"
											style="color: red" id="editid"><img src="images/Edit.jpg"
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
											href="organizationTypeDelete.mnt?organizationTypeCodeDelete=<c:out value="${organizationTypeRow.orgTypeId}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
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
			<!--=================== ============================================End DisplayTable================================================= -->


			<!--=================== ============================================Begin OrgTypeAdd================================================= -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table class="tableGeneral">
						<tr>
							<td colspan="2"><c:forEach var="orgTypeDuplicate"
									items="${duplicate}">
									<div class="alert-warning">
										<strong><s:message code="label.warning" /> </strong>
										<s:message code="label.organizationTypeName" />
										<s:message code="label.duplicateCheck" />
									</div>
								</c:forEach></td>
						</tr>
					</table>

					<form:form action="organizationTypeAdd.mnt" name="orgTypeFormgh"
						id="orgTypeFormgh" onsubmit="return validateOrgType(this);"
						method="POST" commandName="organizationType">
						<form:hidden path="OrgTypeIdEdit" />
						<form:hidden path="aid" />
						<table class="tableGeneral">
							<tr>
								<td><s:message code="label.organizationTypeName" /><font
									color="red">*</font></td>
								<td><form:input path="orgType" id="orgType" class="textbox"
										maxlength="50" /></td>
							</tr>
							<tr>

								<td colspan="2"><c:choose>
										<c:when test="${save }">
											<input type="submit" value="<s:message code="label.save"/> "
												class="btn btn-primary" id="orgTypeSubmit" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<s:message code="label.save"/> "
												class="btn btn-danger" id="orgTypeSubmit" />
										</c:otherwise>
									</c:choose> <input type="reset" value="<s:message code="label.reset"/> "
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>


				</div>
			</div>
			<!--=================== ============================================End OrgTypeAdd================================================= -->

			<!--=================== ============================================Begin OrgTypeEdit================================================= -->
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="orgTypeEditValues"
						items="${organizationTypeValues }">

						<form:form action="organizationTypeUpdate.mnt" method="POST"
							commandName="organizationType" id="otUpdate">
							<table>
								<tr>
									<td colspan="2"><c:forEach var="orgTypeUpdateDup"
											items="${orgTypeUpdateDuplicate}">
											<div class="alert-warning">
												<strong><s:message code="label.warning" /> </strong>
												<s:message code="label.organizationTypeName" />
												<s:message code="label.duplicateCheck" />

											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="orgTypeIdEdit" />
								<tr>
									<td><s:message code="label.organizationTypeName" /><font
										color="red">*</font></td>
									<td><form:input path="orgTypeEdit" id="orgName"
											class="textbox" maxlength="50" /></td>
								</tr>

								<tr>



									<td><c:choose>
											<c:when test="${update}">
												<input type="submit"
													value="<s:message code="label.update"/> "
													class="btn btn-primary" id="orgTypeSubmitupdate" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<s:message code="label.update"/> "
													class="btn btn-danger" id="orgTypeSubmitupdate" />
											</c:otherwise>

										</c:choose></td>
								</tr>
							</table>
						</form:form>
						<!--=================== ============================================End OrgTypeEdit================================================= -->
					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




