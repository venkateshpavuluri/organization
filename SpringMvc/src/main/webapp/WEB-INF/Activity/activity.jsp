<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author yogi
 @version 1.0    -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script type="text/javascript" src="js/MntValidator.js"></script>

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
      document.getElementById("aid").value = 1;
    });
  });
</script>

<script type="text/javascript">
  $(document).ready(function() {
    if (document.getElementById("aid").value == 1) {
      var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

      $('#tabs').tabs({
        active: index
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
                                      $('#addForm')
                                              .validate(
                                                      {
                                                        rules: {
                                                          activity: {
                                                            required: true,
                                                            alphabets: true,
                                                            specialcharacters: true
                                                          }
                                                        },
                                                        messages: {
                                                          activity: {
                                                            required: "<font style='color: red;'><b>Activity is required</b></font>",
                                                            alphabets: "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
                                                            specialcharacters: "<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
                                                          }
                                                        }
                                                      });
                                    });
                    //UpdateForm Validations
                    $('#editForm')
                            .validate(
                                    {
                                      rules: {
                                        activityEdit: {
                                          required: true,
                                          alphabets: true,
                                          specialcharacters: true
                                        }

                                      },
                                      messages: {
                                        activityEdit: {
                                          required: "<font style='color: red;'><b>Activity is required</b></font>",
                                          alphabets: "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
                                          specialcharacters: "<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
                                        }
                                      }

                                    });

                  });
</script>



</head>
<body>

	<div class="divUserDefault" id="mainId">
		<div class="PageTitle">Activity</div>
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
					<form:form action="searchActivity.mnt" method="GET"
						commandName="activityCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.activity" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.activity" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${ActivityUpdate}">
										<div class="alert-success">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.activity" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${ActivityUpdateFail}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.activity" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${ActivityDelete}">
										<div class="alert-success" id="successmessage">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.activity" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${ActivityDeleteFail}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.activity" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>



							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />

									</form:select> <spring:bind path="activityCmd.operations">
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

								<td><c:choose>
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
									</c:choose></td>
							</tr>
						</table>
					</form:form>


					<c:if test="${activityBeans!=null}">
						<display:table id="Row" name="activityBeans"
							requestURI="searchActivity.mnt" pagesize="5" class="table">
							<display:column property="activity" titleKey="label.licence"
								sortable="true"></display:column>

							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit }">

										<a
											href="editActivity.mnt?activityId=<c:out value="${Row.activityId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" height="20px" id="editId" /> </a>
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
											href="deleteActivity.mnt?activityId=<c:out value="${Row.activityId}"/>"
											style="color: red"
											onclick="return confirm('Do you want to delete the record?')"><img
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
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="addActivity.mnt" id="addForm"
						method="POST" commandName="activityCmd">
						<table class="tableGeneral">

							<tr>
								<td colspan="2"><c:forEach var="AGSuccessdup"
										items="${AGSuccessdup}">
										<div class="alert-warning" id="successmessage">

											<strong> <spring:message code="label.warning" />
											</strong>
											<spring:message code="label.activity" />
											<spring:message code="label.duplicateCheck" />
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="aid" />
							<tr>
								<td><spring:message code="label.activity" /><span
									class="required">*</span></td>
								<td><form:input path="activity" class="textbox" /></td>
							</tr>
							<tr>
								<td></td>
								<td><c:choose>
										<c:when test="${save }">
											<input type="submit"
												value="<spring:message
								code="label.save" />"
												class="btn btn-primary" id="sumbnid" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.save"/> "
												class="btn btn-danger" id="orgTypeSubmit" />
										</c:otherwise>
									</c:choose> <input type="reset" id="resetId"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>

							</tr>
						</table>
					</form:form>


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="AccountEditValues" items="${editvalues }">
						<form:form action="updateActivity.mnt" method="POST"
							commandName="activityCmd" id="editForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="AGSuccessdupedit"
											items="${AGSuccessdupedit}">
											<div class="alert-warning" id="successmessage">

												<strong> <spring:message code="label.warning" />
												</strong>
												<spring:message code="label.activity" />
												<spring:message code="label.duplicateCheck" />
											</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="aid" />
								<form:hidden path="aid" />
								<tr>
									<td><spring:message code="label.activity" /><span
										class="required">*</span></td>
									<td><form:input path="activityEdit" class="textbox" /></td>
									<form:hidden path="activityId" class="textbox" />
								</tr>

								<tr>
									<td></td><td><c:choose>
											<c:when test="${update}">
												<input type="submit"
													value="<spring:message
								code="label.update" />"
													class="btn btn-primary" id="materailudate" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<spring:message code="label.update"/> "
													class="btn btn-danger" id="orgTypeSubmitupdate" />
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
