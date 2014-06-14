 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="en">

<head>
	<meta charset="utf-8">
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="portlet-content" style="height: 550px; overflow-y:scroll; overflow-x: scroll;">
<table class="table">
		<tr>
		<c:choose>
		<c:when test="${not empty allInvoices}">
		<th><spring:message code="label.customerInvoiceNo"/> </th>
		<th><spring:message code="label.customer"/></th>
	      <th><spring:message code="label.amount"/></th>
		<th><spring:message code="label.recievedAmount"/></th>
		<th><spring:message code="label.pendingAmount"/></th>
		<th><spring:message code="label.currency"/></th>
			<th><spring:message code="label.date"/></th>
		</c:when>
		<c:otherwise>
	<spring:message code="label.noData"/>
		</c:otherwise>
		</c:choose>
		</tr>
		<c:forEach items="${allInvoices}" var="invoiceToCollects">
		<tr>
		<td><c:out value="${invoiceToCollects.customerNo}"></c:out> </td>
			<td><c:out value="${invoiceToCollects.customer}"></c:out> </td>
			<td><c:out value="${invoiceToCollects.amount}"></c:out> </td>
			<td><c:out value="${invoiceToCollects.recievedAmount}"></c:out> </td>		
			<td><c:out value="${invoiceToCollects.pendingAmount}"></c:out> </td>
			<td><c:out value="${invoiceToCollects.currency}"></c:out> </td>
			<td><c:out value="${invoiceToCollects.date}"></c:out> </td>
						</tr>
		</c:forEach>
	
		</table>
</div>

</body>
</html>
	