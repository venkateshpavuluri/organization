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
	<c:forEach var="claimView"
		items="${claimView}">


		<form:form action="claimWorkFlowUpdate.mnt" method="post"
			commandName="claimWorkFlow">
			<div>
			<table>
		<tr>
						<th><spring:message code="label.claimNo" /></th>
					<td><c:out value="${claims.claimNo}" /></td>
					<th><spring:message code="label.claimTypeName" /></th>
				<td><c:out value="${claims.claimTypeName}" /></td>
					<th><spring:message code="label.employeeId" /></th>
					<td><c:out value="${claims.empName}" /></td>
					
					</tr>
					<tr>
					<th><spring:message code="label.amount" /></th>		
					<td><c:out value="${claims.amount}" /></td>
						<th><spring:message code="label.status" /></th>
						<td><c:out value="${claims.statusName}" /></td>
					</tr>
					<form:hidden path="workFlowListId" />
					<tr></tr>
					<tr></tr>
					<tr></tr>
				</table>
				<br /> <br />
				<c:forEach var="claimDis" items="${claimDisplayOnly}">
					<c:set var="claimDisplay" value="${claimDis}"></c:set>

				</c:forEach>
				<c:if test="${claimDisplay!=null }">

					<display:table id="claimRow" name="claimDisplay"
						pagesize="5" requestURI="claimWorkFlowView.mnt" class="table">
						<%-- <display:column property="workFlowListId" media="html"  titleKey="label.purchaseReqNo"
								 sortable="true"></display:column> --%>
						<display:column property="documentPath" media="html"
							titleKey="label.docPath" />

						<display:setProperty name="paging.banner.placement" value="bottom" />

						<display:setProperty name="paging.banner.group_size" value="3" />

						<display:setProperty name="paging.banner.some_items_found"
							value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
					</display:table>
				</c:if>
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
