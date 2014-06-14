 
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
<div  style="height: 550px; overflow-y:scroll; overflow-x: scroll;">
<table class="table">
		<tr>
		<c:choose>
		<c:when test="${ not empty allReoredeMaterials}">
		<th><spring:message code="label.material"/> </th>
		<th><spring:message code="label.qtyAvailable"/></th>
	    <th><spring:message code="label.reorderLevel"/></th>
		<th><spring:message code="label.uom"/></th>
		</c:when>
		<c:otherwise>
<spring:message code="label.noData"/>
		</c:otherwise>
		</c:choose>
		</tr>
		<c:forEach items="${allReoredeMaterials}" var="reorederMaterial">
		<tr>
		<td><c:out value="${reorederMaterial.materialName }"></c:out> </td>
			<td><c:out value="${reorederMaterial.qtyAvailabale }"></c:out> </td>
			<td><c:out value="${reorederMaterial.reorderLevel }"></c:out> </td>
			<td><c:out value="${reorederMaterial.uom }"></c:out> </td>		
						</tr>
		</c:forEach>
		</table>
</div>

</body>
</html>
	