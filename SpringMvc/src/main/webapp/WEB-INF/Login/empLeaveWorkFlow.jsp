<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myWorkListPopUp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  <body>
	<c:forEach var="wkflowsuccess" items="${workflowupdatesuccess}">
		<c:out value="${wkflowsuccess}" />
	</c:forEach>
	<c:forEach var="employeeLeaves" items="${employeeLeaveView}">
		<form:form action="empLeaveWorkFlowUpdate.mnt" method="post"
			commandName="empLeaveWorkFlow">
			<div>
				<table class="table1">
					<tr>
						<th><spring:message code="label.employee" /></th>
				<td><c:out value="${employeeLeaves.employeeId}" /></td>
						<th><spring:message code="label.leaveType" /></th>
					<td><c:out value="${employeeLeaves.leaveTypeId}" /></td>
					<th><spring:message code="label.reptMgrId" /></th>
						<td><c:out value="${employeeLeaves.reptMgrId}" /></td>
					<th><spring:message code="label.NoOfAvailableCL" /></th>
					<td><c:out value="${employeeLeaves.noOfAvailableCL}" /></td>
						<th><spring:message code="label.reason" /></th>
									<td><c:out value="${employeeLeaves.reason}" /></td>
					</tr>
					<tr>	<th><spring:message code="label.NoOfAvailableCFL" /></th>
						<td><c:out value="${employeeLeaves.noOfAvailableCFL}" /></td>
						<th><spring:message code="label.status" /></th>
						<td><c:out value="${employeeLeaves.statusId}" /></td>
						<th><spring:message code="label.startDate" /></th>
				<td><c:out value="${employeeLeaves.startDate}" /></td>
				<th><spring:message code="label.sDayPart" /></th>
						<td><c:out value="${employeeLeaves.sDayPart}" /></td>
							<th><spring:message code="label.endDate" /></th>
								<td><c:out value="${employeeLeaves.endDate}" /></td>
					</tr>
					<form:hidden path="workFlowListId" />
					<tr></tr>
					<tr></tr>
					<tr></tr>
				</table>
				<br /> <br />
			</div>
			<h1></h1>
			<%-- 	<tr><td><spring:message code="label.organizationName"/> </td><td><form:input path="orgName"/></td></tr>	 --%>
			<br/>
			<div>
				<table class="table">
					<tr></tr>
					<tr></tr>

					<tr>
						<c:forEach var="users" items="${actionBy}">
							<c:set var="userNames" value="${users }" />
						</c:forEach>
						<c:if test="${userNames!=null }">
							<td > <c:out
										value="${actionBy }" /> &nbsp;&nbsp;&nbsp;</td>
							<td ><spring:message code="label.comments"></spring:message><c:out
										value="${comments }" /></td>
						</c:if>
					</tr>
<tr><td colspan="2">&nbsp;</td> </tr>
					<tr>

						<td><spring:message code="label.comments" /></td>
						<td><form:textarea path="comments" /></td>
					</tr>
					<tr><td colspan="2">&nbsp;</td> </tr>
					<tr>
						<c:forEach var="actions" items="${WFActions}">
							<td align="center" colspan="2"><spring:bind path="actionNames">
									<input type="submit" name="actionNames" class="btn btn-primary"
										value="${actions.wfactionName}" />
								</spring:bind></td>
						</c:forEach>
					</tr>
				</table>
			</div>
		</form:form>
	</c:forEach>
  </body>
</html>
