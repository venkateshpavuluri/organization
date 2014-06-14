 
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
		<c:when test="${not empty allInvoicesToPay}">
		<th><spring:message code="label.vendorInvoiceNo"/> </th>
		<th><spring:message code="label.vendor"/> </th>
	    <th><spring:message code="label.amount"/></th>
		<th><spring:message code="label.recievedAmount"/></th>
		<th><spring:message code="label.pendingAmount"/></th>
		<th><spring:message code="label.currency"/></th>
			<th><spring:message code="label.date"/></th>
		</c:when>
		<c:otherwise><spring:message code="label.noData"/></c:otherwise>
		</c:choose>
		</tr>
		<tr>
		<c:forEach items="${allInvoicesToPay}" var="invoiceToPay">
		<tr>
		<td><c:out value="${invoiceToPay.vendorInvoiceNo}"></c:out> </td>
			<td><c:out value="${invoiceToPay.vendor}"></c:out> </td>
			<td><c:out value="${invoiceToPay.amount}"></c:out> </td>
			<td><c:out value="${invoiceToPay.recievedAmount}"></c:out> </td>		
			<td><c:out value="${invoiceToPay.pendingAmount}"></c:out> </td>
			<td><c:out value="${invoiceToPay.currency}"></c:out> </td>
			<td><c:out value="${invoiceToPay.date}"></c:out> </td>
						</tr>
		</c:forEach>
		</tr>
		</table>
</div>

<!-- <div id="chart1" align="center"> </div> -->
<%-- <div class="divUserDefault">
		<div class="PageTitle"><spring:message code="label.dashboard" /></div>
		<div id="tabs" class="TabbedPanels">
		
		<div class="column">
<!--------------------------------------------- Total Stock begin --------------------------------------------------------------------->	
	<div class="portlet">
		<div class="portlet-header"><spring:message code="label.top5Materials"/> </div>

		    <div id="chart1" class="portlet-content" style="width:500px; height:250px;"></div>
	</div>
	</div>
	</div>
	</div> --%></body>
	