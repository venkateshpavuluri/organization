<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:plugin type="applet" code="com.mnt.report.ReportViewer"
		codebase="reportApplet"
		archive="MNTReport.jar,jasperreports-5.0.4.jar,commons-beanutils-1.8.0.jar,commons-collections-2.1.1.jar,commons-digester-2.1.jar,commons-logging-1.1.1.jar,log4j-1.2.15.jar"
		width="1200" height="1000">
		<jsp:params>
			<jsp:param name="jrPrintPath"
				value="${requestScope.jrPrintPath}" />

		</jsp:params>
		<jsp:fallback>
<p>Unable to load applet</p>
</jsp:fallback>


	</jsp:plugin>

</body>
</html>