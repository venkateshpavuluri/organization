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
	<c:forEach var="purchaseOrderView"
		items="${purchaseOrderView}">


		<form:form action="purOrderWorkFlowUpdate.mnt" method="post"
			commandName="purOrderWorkFlow">
			<div>
				<table class="table1">
					<tr>
						<th><spring:message code="label.purchaseOrderNbr" />:</th>
						<td><c:out value="${purchaseOrderView.purchaseOrderNo }"></c:out></td>
						<th><spring:message code="label.purchaseOrderDate" />:</th>
						<td><c:out value="${purchaseOrderView.purchaseOrderDate }" /></td>
						<th><spring:message code="label.purchaseOrderValue" />:</th>
						<td><c:out value="${purchaseOrderView.purchaseOrderValue }" />
						</td>
						<th><spring:message code="label.purchaseOrderStatus" />:</th>
						<td><c:out value="${purchaseOrderView.statusName }" />
						</td>
					</tr>
					<tr>
						<th><spring:message code="label.vendorName" /> :</th>
						<td><c:out value="${purchaseOrderView.vendorName }" />
						</td>
						<th><spring:message code="label.paymentTerms" />:</th>
						<td><c:out value="${purchaseOrderView.paymentTerms }" /></td>
						<th><spring:message code="label.memo" />:</th>
						<td><c:out value="${purchaseOrderView.memo }" /></td>
					 <th><spring:message code="label.description" />:</th>
						<td><c:out value="${purchaseOrderView.description }" /></td> 
					</tr>
					<form:hidden path="workFlowListId" />
					<tr></tr>
					<tr></tr>
					<tr></tr>
				</table>
				<br /> <br />
				<c:forEach var="purOrederDis" items="${purchaseOrderDisplayOnly }">
					<c:set var="purOrderDisplay" value="${purOrederDis}"></c:set>





				</c:forEach>
				<c:if test="${purOrderDisplay!=null }">

					<display:table id="purOrderRow" name="purchaseOrderDisplayOnly"
						pagesize="5" requestURI="purReqView.mnt" class="table">
						<%-- <display:column property="workFlowListId" media="html"  titleKey="label.purchaseReqNo"
								 sortable="true"></display:column> --%>

						<display:column property="purchaseOrderId" media="html"
							titleKey="label.purchaseOrderLineId" />
						<display:column property="quantity" media="html"
							titleKey="label.quantity" />

						<display:column property="lineAmt" media="html"
							titleKey="label.lineNum" />
						<display:column property="materialName" media="html"
							titleKey="label.materialName" />

						<display:column property="uomName" media="html"
							titleKey="label.uom" />

						<display:column property="unitPrice" media="html"
							titleKey="label.unitPrice" />
						<%-- <display:column property="orgName"  media="html" titleKey="label.organizationName"
								sortable="true" /> --%>
						<display:column property="dueDate" media="html"
							titleKey="label.dueDate" />
					<%-- 	<display:column property="storageLocName" media="html"
							titleKey="label.storageLocationName" /> --%>


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
				<c:out value="${WFActions}"></c:out>
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
