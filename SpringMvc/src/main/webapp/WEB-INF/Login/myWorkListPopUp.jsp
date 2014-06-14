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
  	
	<%request.setAttribute("purchaseReqDisplayOnly",request.getAttribute("purchaseReqDisplayOnly"));
	System.out.println("within worklist=="+request.getAttribute("purchaseReqDisplayOnly"));
	
	 %>
	<c:forEach var="wkflowsuccess" items="${workflowupdatesuccess}">
		<c:out value="${wkflowsuccess}" />
	</c:forEach>
	<c:forEach var="purchaseRequisitionView"
		items="${purchaseRequisitionView}">


		<form:form action="purReqWorkFlowUpdate.mnt" method="post"
			commandName="purReqWorkFlow">
			<div>
				<table class="table">
					<tr>
						<td><spring:message code="label.purchaseReqNo" />:</td>
						<td><c:out value="${purchaseRequisitionView.purchaseReqNo }"></c:out></td>
						<td><spring:message code="label.requestedBy" />:</td>
						<td><c:out value="${purchaseRequisitionView.requestedBy }" /></td>
						<td><spring:message code="label.requestedDate" />:</td>
						<td><c:out value="${purchaseRequisitionView.requestedDate }" />
						</td>
					</tr>
					<tr>
						<td><spring:message code="label.requiredDate" /> :</td>
						<td><c:out value="${purchaseRequisitionView.reqDate }" />
						</td>
						<td><spring:message code="label.description" />:</td>
						<td><c:out value="${purchaseRequisitionView.description }" /></td>
						<td><spring:message code="label.refNo" />:</td>
						<td><c:out value="${purchaseRequisitionView.refNo }" /></td>
					</tr>
					<form:hidden path="workFlowListId" />
					<tr></tr>
					<tr></tr>
					<tr></tr>
				</table>
				<br /> <br />
				<c:forEach var="purReqDis" items="${purchaseReqDisplayOnly }">
					<c:set var="purReqDisplay" value="${purReqDis}"></c:set>





				</c:forEach>
				<c:if test="${purReqDisplay!=null }">

					<display:table id="purReqRow" name="purchaseReqDisplayOnly"
						pagesize="5" requestURI="purReqView.mnt" class="table">
						<%-- <display:column property="workFlowListId" media="html"  titleKey="label.purchaseReqNo"
								 sortable="true"></display:column> --%>

						<display:column property="purchaseReqLine_Id" media="html"
							titleKey="label.purchaseReqLine" />
						<display:column property="purReqLineqty" media="html"
							titleKey="label.quantity" />

						<display:column property="purReqLineReqDate" media="html"
							titleKey="label.requiredDate" />
						<display:column property="materialName" media="html"
							titleKey="label.materialName" />

						<display:column property="uomName" media="html"
							titleKey="label.uom" />

						<display:column property="status" media="html"
							titleKey="label.status" />
						<%-- <display:column property="orgName"  media="html" titleKey="label.organizationName"
								sortable="true" /> --%>
						<display:column property="plantName" media="html"
							titleKey="label.plantName" />
						<display:column property="storageLocName" media="html"
							titleKey="label.storageLocationName" />


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
				<table class="table1">
					<tr></tr>
					<tr></tr>

					<tr>
						<c:forEach var="users" items="${actionBy}">
							<c:set var="userName" value="${users }" />
						</c:forEach>

						<c:if test="${userName!=null }">
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
							<td align="center"><spring:bind path="actionNames">
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
