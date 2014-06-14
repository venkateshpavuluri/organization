 
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
<div style="height: 550px; overflow-y:scroll; overflow-x: scroll;">
		<table class="table">
		<tr>
		<c:choose>
		<c:when test="${not empty allGoodsDelivery}">
		<th><spring:message code="label.materialName"/> </th>
		<th><spring:message code="label.deliveryQty"/></th>
		</c:when>
		<c:otherwise>
	<spring:message code="label.noData"/>
		</c:otherwise>
		</c:choose>
		</tr>
		<c:forEach items="${allGoodsDelivery}" var="deliveryInTheYears">
		<tr>
		<td><c:out value="${deliveryInTheYears.materialName }"></c:out> </td>
			<td><c:out value="${deliveryInTheYears.deliveredQty }"></c:out> </td>
						
						</tr>
		</c:forEach>
		</table>
</div>

</body>
</html>
	