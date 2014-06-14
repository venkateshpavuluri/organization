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
	<c:forEach var="salesOrderViews"
		items="${salesOrderView}">


		<form:form action="salesOrderWorkFlowUpdate.mnt" method="post"
			commandName="salesOrderWorkFlow">
			<div>
				<table class="table1">
					<tr>
						<th><spring:message code="label.soordertype" />:</th>
					<td><c:out value="${salesOrderViews.orderTypeId}" /></td>
						<th><spring:message code="label.sopterms" />:</th>
					<td><c:out value="${salesOrderViews.paymentTermId}" /></td>
						<th><spring:message code="label.sosalesgroup" />:</th>
						<td><c:out value="${salesOrderViews.salesGroupId}" /></td>
					
						<th><spring:message code="label.souom" />:</th>
						<td><c:out value="${salesOrderViews.uom}" /></td>
					</tr>
					<tr>
						<th><spring:message code="label.sono" /> :</th>
							<td><c:out value="${salesOrderViews.salesOrderNo}" /></td>
						<th><spring:message code="label.sostat" />:</th>
						<td><c:out value="${salesOrderViews.statusId}" /></td>
						<th><spring:message code="label.sodate" />:</th>
						<td><c:out value="${salesOrderViews.custPODate }" /></td>
					 <th><spring:message code="label.sonw" />:</th>
						<td><c:out value="${salesOrderViews.netWeight }" /></td> 
					</tr>
					
						
					
					
					
						
					
					<form:hidden path="workFlowListId" />
					<tr></tr>
					<tr></tr>
					<tr></tr>
				</table>
				<br /> <br />
				<c:forEach var="salesOrederDis" items="${salesOrderDisplayOnly}">
					<c:set var="salesOrderDisplay" value="${salesOrederDis}"></c:set>





				</c:forEach>
				<c:if test="${salesOrderDisplay!=null }">

					<display:table id="salesOrderRow" name="salesOrderDisplayOnly"
						pagesize="5" requestURI="salesOrderView.mnt" class="table">
						<%-- <display:column property="workFlowListId" media="html"  titleKey="label.purchaseReqNo"
								 sortable="true"></display:column> --%>

						
						<display:column property="quantity" media="html"
							titleKey="label.quantity" />

						<display:column property="materialId" media="html"
							titleKey="label.material" />
					

						<display:column property="uomId" media="html"
							titleKey="label.uom" />

						<display:column property="currencyId" media="html"
							titleKey="label.currency" />
						<%-- <display:column property="orgName"  media="html" titleKey="label.organizationName"
								sortable="true" /> --%>
						<display:column property="netPrice" media="html"
							titleKey="label.sonprice"/>
								<display:column property="uPrice" media="html"
							titleKey="label.soup"/>
								<display:column property="tax" media="html"
							titleKey="label.sotax"/>
							<display:column property="discount" media="html"
							titleKey="label.sodisc"/>
								<display:column property="totalAmt" media="html"
							titleKey="label.sotamt"/>


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
