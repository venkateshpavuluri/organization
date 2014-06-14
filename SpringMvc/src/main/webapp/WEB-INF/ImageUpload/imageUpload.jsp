<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="imageUpload.mnt" method="POST"
						commandName="imageUpload" enctype="multipart/form-data">
						<table>
						<tr><td> Select File To Upload</td><td><form:input type="file" path="imageFile"/>  </td> </tr>
						<tr><td colspan="2"> <input type="submit" value="UploadImage"/></td> </tr>
						</table>
						</form:form>
</body>
</html>