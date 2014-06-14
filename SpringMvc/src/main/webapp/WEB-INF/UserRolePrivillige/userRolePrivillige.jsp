<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author venkatesh
 @version 1.0    -->

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mnt.erp.bean.Privilege"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<script>
	function populateUsers() {
		var roleId = $('#roleId').val();

		$.ajax({
			type : "POST",
			url : "forUsers.mnt",
			data : "roleId=" + roleId,
			success : function(response) {
				var options = "";
				options = $("#userId").empty();
				$.each(response, function(key, value) {
					options.append(new Option(value, key));
				});

			},
			error : function(e) {
				//alert('Error' + e);
			}

		});

	}
</script>

<script>
	function populateUsersEdit() {

		var roleId = $('#roleIdEdit').val();
		$.ajax({
			type : "POST",
			url : "forUsers.mnt",
			data : "roleId=" + roleId,
			success : function(response) {
				var options = "";
				options = $("#userIdEdit").empty();

				$.each(response, function(key, value) {

					options.append(new Option(value, key));
				});

			},
			error : function(e) {
				//alert('Error' + e);
			}

		});

	}
</script>
<script type="text/javascript">
	function duplicateCheck() {

		//get the form values

		var userId = $('#userId').val();
		var roleId = $('#roleId').val();

		$
				.ajax({

					type : "POST",

					url : "userRpDuplicateCheck.mnt",

					data : "userId=" + userId + "&roleId=" + roleId,

					success : function(response) {

						var checkResponse = "Warning !This User and Role  is already exists";

						if (checkResponse == response) {

							document.getElementById("UserrolePriSuccessdup").style.display = "block";
							$('#UserrolePriSuccessdup').html(response);
							$('#sumbnid').hide();
						} else {
							document.getElementById("UserrolePriSuccessdup").style.display = "none";
							$('#sumbnid').show();
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid,#updateid').click(function(e) {

			var aid = document.getElementById("aid").value = 1;
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
						$('#sumbnid')
								.click(
										function(event) {

											$('#addpriform')
													.validate(
															{
																rules : {
																	userId : {
																		required : true
																	},
																	roleId : {
																		required : true
																	},

																},
																messages : {
																	userId : "<font style='color: red;'><b>User  is Required</b></font>",
																	roleId : "<font style='color: red;'><b>Role is Required</b></font>",
																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert("hai");
											$('#editpriForm')
													.validate(
															{
																rules : {
																	userIdEdit : {
																		required : true
																	},
																	roleIdEdit : {
																		required : true
																	},

																},
																messages : {
																	userIdEdit : "<font style='color: red;'><b>User is Required</b></font>",
																	roleIdEdit : "<font style='color: red;'><b>Role is Required</b></font>"
																},
															});

										});

					});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">User Role Privileges</div>
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
					<form:form action="userRolePrivlegeSearch.mnt" method="GET"
						commandName="userRolePrivilege">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.userRolePrivileges" />
											<spring:message code="label.saveSuccess" />

										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger" id="savemessageError">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.userRolePrivileges" />
											<spring:message code="label.saveFail" />

										</div>
									</c:forEach> <c:forEach items="${userRolePriUpdate}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.userRolePrivileges" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${userRolePriUpdateError}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.userRolePrivileges" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${userRolePriDelete}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.userRolePrivileges" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${userRolePriUpdateError}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.userRolePrivileges" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<%-- <tr>
								<td>Account Group</td>
								<td><form:select path="accountgroupid" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${accountsearch}" />
								</form:select></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary"/></td>
							</tr> --%>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="userRolePrivilege.operations">
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

					<c:if test="${userRolePrivilegesSearch!=null}">
						<display:table id="userPrivRow" name="userRolePrivilegesSearch"
							requestURI="userRolePrivlegeSearch.mnt" pagesize="5"
							class="table">

							<display:column property="roleName" titleKey="label.role"
								sortable="true"></display:column>
							<display:column property="userName" titleKey="label.user"
								sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit}">


										<a
											href="userRolepriedit.mnt?useriedit=<c:out value="${userPrivRow.userIdEdit}"/>&roleIdEdit=<c:out value="${userPrivRow.roleIdEdit}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px" height="20px"
											class="btn btn-danger" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete}">
										<a
											href="userRolepriDelete.mnt?userRolepriDelete=<c:out value="${userPrivRow.userIdEdit}"/>&roleIdDelete=<c:out value="${userPrivRow.roleIdEdit}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px"
											onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
									</c:when>

									<c:otherwise>
										<a><img src="images/Delete.jpg" width="20px"
											class="btn btn-danger" height="20px" /> </a>
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
					<div id="UserrolePriSuccessdup" class="alert-warning"
						style="display: none;"></div>
					<form:form action="userRolePlgAdd.mnt" id="addpriform"
						method="POST" commandName="userRolePrivilege">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="duplicatei"
										items="${duplicateCheck}">
										<div class="alert-warning">
											<strong>Warning !</strong>
											<c:out value="${duplicatei}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="aid" />
							<tr>
								<td><spring:message code="label.role"></spring:message></td>
								<td><form:select path="roleId" id="roleId"
										onchange="populateUsers()" cssClass="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${roles}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.user"></spring:message></td>
								<td><form:select path="userId" id="userId"
										onchange="duplicateCheck()" cssClass="select">
										<form:option value="">--Select--</form:option>
									</form:select></td>
							</tr>
						</table>
						<table class="table">
							<tr>
								<th>Menu</th>
								<c:forEach var="privileges" items="${privileges}">
									<th><c:out value="${privileges}"></c:out></th>
								</c:forEach>
							</tr>
							<c:forEach var="menus" items="${mapofprivileges }">
								<tr>
									<c:set var="menuColors" value="${menus.value}"></c:set>
									<c:choose>
										<c:when test="${empty menuColors}">
											<td><strong> <c:out value="${menus.key}"></c:out></strong>
											</td>
										</c:when>
										<c:otherwise>
											<td bgcolor="green"><c:out value="${menus.key}"></c:out>
											</td>
										</c:otherwise>

									</c:choose>

									<c:forEach var="pname" items="${privileges }">
										<td><c:forEach var="privilegeValues"
												items="${menus.value}" varStatus="loop">
												<c:set var="privilegeName" value="${pname }"></c:set>
												<c:set var="secondprivilege"
													value="${privilegeValues.privilege }"></c:set>
												<c:if test="${pname==privilegeValues.privilege}">
													<input type="checkbox" class="checkbox" value="on"
														name="${menus.key}${privilegeValues.privilege}"></input>
												</c:if>
											</c:forEach></td>
									</c:forEach>
								</tr>
							</c:forEach>
						</table>
						<table class="table">
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save}">
											<input type="submit"
												value="<spring:message code="label.save"/>" id="sumbnid"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit"
												value="<spring:message code="label.save"/>"
												disabled="disabled" id="sumbnid" class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>
						</table>
					</form:form>


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="AccountEditValues" items="${editvalues }">
						<form:form action="userRolePlgUpdate.mnt" id="editpriForm"
							method="POST" commandName="userRolePrivilege">
							<table class="tableGeneral">
								<tr>
									<td><spring:message code="label.role"></spring:message></td>
									<td><form:select path="roleIdEdit"
											onchange="populateUsersEdit()" id="roleIdEdit"
											cssClass="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${roles}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.user"></spring:message></td>
									<td><form:select path="userIdEdit" id="userIdEdit"
											cssClass="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${users}" />
										</form:select></td>
								</tr>
							</table>
							<table class="table">
								<tr>
									<th>Menu</th>
									<%
										List<String> allPrivileges = (List<String>) request
														.getAttribute("privileges");
												Iterator iterator = allPrivileges.iterator();
												while (iterator.hasNext()) {
													String orginaPris = (String) iterator.next();
									%>
									<th><%=orginaPris%></th>
									<%
										}
									%>
								</tr>
								<%
									Map<String, List<Privilege>> allmenusPris = (Map<String, List<Privilege>>) request
													.getAttribute("editprivileges");
											Iterator allmenupriIter = allmenusPris.entrySet()
													.iterator();
											while (allmenupriIter.hasNext()) {
												Map.Entry entry = (Map.Entry) allmenupriIter.next();
								%>
								<tr>
									<%
										List<Privilege> editPris1 = (List<Privilege>) entry
															.getValue();
													if (editPris1.size() != 0) {
									%>
									<td><%=entry.getKey()%></td>
									<%
										} else {
									%>

									<td><Strong> <%=entry.getKey()%></Strong></td>




									<%
										}
													List<String> allPrivilegesfor = (List<String>) request
															.getAttribute("privileges");
													Iterator iteratorfor = allPrivilegesfor.iterator();
													while (iteratorfor.hasNext()) {
														String orginaPris = (String) iteratorfor.next();
									%>
									<td>
										<%
											List<Privilege> editPris = (List<Privilege>) entry
																	.getValue();
															Iterator editPrisItr = editPris.iterator();
															while (editPrisItr.hasNext()) {
																Privilege editprivelege = (Privilege) editPrisItr
																		.next();
																String pname = orginaPris + "check";

																if (pname.equals(editprivelege.getPrivilege())) {
										%> <input type="checkbox" checked="checked"
										id="<%=entry.getKey()%><%=editprivelege.getPrivilege()%>"
										onchange="changechecked(this.id)" class="checkbox"
										name="<%=entry.getKey()%><%=editprivelege.getPrivilege()%>"></input>
										<%
											} else {
																	if ((orginaPris.equals(editprivelege
																			.getPrivilege()))) {
										%> <input type="checkbox" class="checkbox"
										name="<%=entry.getKey()%><%=editprivelege.getPrivilege()%>"></input>
										<%
											}
																}

															}
										%>
									</td>
									<%
										}
									%>


								</tr>
								<%
									}
								%>

							</table>
							<table class="table">
								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${update}">

												<input type="submit"
													value="<spring:message code="label.update"/>" id="updateid"
													class="btn btn-primary" />
											</c:when>
											<c:otherwise>
												<input type="submit"
													value="<spring:message code="label.update"/>"
													disabled="disabled" id="updateid" class="btn btn-danger" />
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