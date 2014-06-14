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
                                      $('#addKPIForm')
                                              .validate(
                                                      {
                                                        rules: {
                                                          KPI: {
                                                            required: true,
                                                            alphabets: true,
                                                            specialcharacters: true
                                                          },
                                                          minRate: {
                                                            required: true,
                                                            number: true
                                                          },
                                                          maxRate: {
                                                            required: true,
                                                            number: true
                                                          },
                                                          KPIGroup: {
                                                            required: true,
                                                          }

                                                        },
                                                        messages: {
                                                          KPI: {
                                                            required: "<font style='color: red;'><b>KPI is required</b></font>",
                                                            alphabets: "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
                                                            specialcharacters: "<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
                                                          },
                                                          minRate: {
                                                            required: "<font style='color: red;'><b>Minmum Rate  is required</b></font>",
                                                            number: "<font style='color: red;'><b>Minimum rate allow only number</b></font>"
                                                          },
                                                          maxRate: {
                                                            required: "<font style='color: red;'><b>Maximum rate is required</b></font>",
                                                            number: "<font style='color: red;'><b>Maximum rate allow only number</b></font>"
                                                          },
                                                          KPIGroup: {
                                                            required: "<font style='color: red;'><b>Please select KPI Group</b></font>",
                                                          }
                                                        }

                                                      });
                                    });
                    //UpdateForm Validations
                    $('#editForm')
                            .validate(
                                    {
                                      rules: {
                                        KPIEdit: {
                                          required: true,
                                          alphabets: true,
                                          specialcharacters: true
                                        },
                                        minRateEdit: {
                                          required: true,
                                          number: true
                                        },
                                        maxRateEdit: {
                                          required: true,
                                          number: true
                                        },
                                        KPIGroupEdit: {
                                          required: true,
                                        }

                                      },
                                      messages: {
                                        KPIEdit: {
                                          required: "<font style='color: red;'><b>KPI is required</b></font>",
                                          alphabets: "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
                                          specialcharacters: "<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>"
                                        },
                                        minRateEdit: {
                                          required: "<font style='color: red;'><b>Minmum Rate  is required</b></font>",
                                          number: "<font style='color: red;'><b>Minimum rate allow only number</b></font>"
                                        },
                                        maxRateEdit: {
                                          required: "<font style='color: red;'><b>Maximum rate is required</b></font>",
                                          number: "<font style='color: red;'><b>Maximum rate allow only number</b></font>"
                                        },
                                        KPIGroupEdit: {
                                          required: "<font style='color: red;'><b>Please select KPI Group</b></font>",
                                        }
                                      }

                                    });

                  });
</script>



</head>
<body>

	<div class="divUserDefault" id="mainId">
		<div class="PageTitle">KPI</div>
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
					<form:form action="searchKPI.mnt" method="GET" commandName="KPICmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.KPI" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.KPI" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${KPIUpdate}">
										<div class="alert-success">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.KPI" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${KPIUpdateFail}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.KPI" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${KPIDelete}">
										<div class="alert-success" id="successmessage">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.KPI" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${KPIDeleteFail}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.KPI" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>



							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />

									</form:select> <spring:bind path="KPICmd.operations">
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
					<c:if test="${kpiValues!=null}">
						<display:table id="kpiRow" name="kpiValues"
							requestURI="searchKPI.mnt" pagesize="5" class="table">
							<display:column property="KPI" titleKey="label.KPI"
								sortable="true"></display:column>
							<display:column property="minRate" titleKey="label.KPIMinRate"
								sortable="true"></display:column>
							<display:column property="maxRate" titleKey="label.KPIMaxRate"
								sortable="true"></display:column>


							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit}">

										<a href="kpiEdit.mnt?KPIId=<c:out value="${kpiRow.KPIId}"/>"
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
										<a href="kpiDelete.mnt?KPIId=<c:out value="${kpiRow.KPIId}"/>"
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
					<form:form action="saveKPI.mnt" id="addKPIForm" method="POST"
						commandName="KPICmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="AGSuccessdup"
										items="${AGSuccessdup}">
										<div class="alert-warning" id="successmessage">

											<strong> <spring:message code="label.warning" />
											</strong>
											<spring:message code="label.KPI" />
											<spring:message code="label.duplicateCheck" />
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="aid" />
							<tr>
								<td><spring:message code="label.KPI" /><span
									class="required">*</span></td>
								<td><form:input path="KPI" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.KPIMinRate" /><span
									class="required">*</span></td>
								<td><form:input path="minRate" class="textbox" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.KPIMaxRate" /><span
									class="required">*</span></td>
								<td><form:input path="maxRate" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.kpigr" /><font color="red">*</font></td>
								<td><form:select path="KPIGroup" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${KPIGroupValues}" />
									</form:select></td>
							</tr>
							<tr>
								<td></td>
								<td><c:choose>
										<c:when test="${save}">
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
						<form:form action="kpiUpdate.mnt" method="POST"
							commandName="KPICmd" id="editForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach var="AGSuccessdupedit"
											items="${AGSuccessdupedit}">
											<div class="alert-warning" id="successmessage">

												<strong> <spring:message code="label.warning" />
												</strong>
												<spring:message code="label.KPI" />
												<spring:message code="label.duplicateCheck" />
											</div>
										</c:forEach></td>
								</tr>

								<form:hidden path="aid" />
								<form:hidden path="aid" />
								<form:hidden path="KPIIdEdit" />
								<tr>
									<td><spring:message code="label.KPI" /><span
										class="required">*</span></td>
									<td><form:input path="KPIEdit" class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.KPIMinRate" /><span
										class="required">*</span></td>
									<td><form:input path="minRateEdit" class="textbox" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.KPIMaxRate" /><span
										class="required">*</span></td>
									<td><form:input path="maxRateEdit" class="textbox" /></td>
								</tr>
								<tr>
									<td><s:message code="label.kpigr" /><span
										class="required">*</span></td>
									<td><form:select path="KPIGroupEdit" class="select">
											<form:option value="0">--Select--</form:option>
											<form:options items="${KPIGroupValues }" />
										</form:select></td>
								</tr>
								<tr>
									<form:hidden path="KPIId" class="textbox" />
								</tr>

								<tr>
									<td></td>
									<td><c:choose>
											<c:when test="${update}">
												<input type="submit"
													value="<spring:message
								code="label.update" />"
													class="btn btn-primary" id="updateid" />
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
