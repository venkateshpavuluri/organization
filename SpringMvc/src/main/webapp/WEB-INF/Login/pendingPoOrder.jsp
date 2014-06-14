 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="en">

<head>
	<meta charset="utf-8">
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
	
	<script type="text/javascript" src="js/google-chart.js"></script>

</head>
<body>
<div class="portlet-content" style="height: 550px; overflow-y:scroll; overflow-x: scroll;">
<table class="table">
		<tr>
		<c:choose>
		<c:when test="${not empty allPendingPo}">
	<th><spring:message code="label.purchaseOrderNo"/> </th>
		<th><spring:message code="label.vendor"/> </th>
		<th><spring:message code="label.dueDate"/></th>
		</c:when>
			<c:otherwise>
		<spring:message code="label.noData"/>
		</c:otherwise>
		</c:choose>
	
		</tr>
		
		<c:forEach items="${allPendingPo}" var="pendingPo">
		<tr>
		<td><c:out value="${pendingPo.purchaseOrderNo }"></c:out> </td>
			<td><c:out value="${pendingPo.vendorName }"></c:out> </td>
						<td><c:out value="${pendingPo.dueDate }"></c:out> </td>
						</tr>
		</c:forEach>
		</table>
</div>

</body>
</html>
	