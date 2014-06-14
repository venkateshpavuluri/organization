<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exception Messages</title>
</head>
<body>

	<c:if test="${not empty errCode}">
		<h2 style="color: red">${errCode} : System Errors</h2>
	</c:if>

	<c:if test="${empty errCode}">
		<h2 style="color: red">System Errors</h2>
		<br />
	</c:if>

	<c:if test="${not empty errMsg}">
		<h4>${name}</h4>
		<br />
		<%-- <h4>${errMsg}</h4> --%>
	</c:if>
</body>
</html>