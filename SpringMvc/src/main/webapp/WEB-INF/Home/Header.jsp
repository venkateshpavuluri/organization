<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 10-09-2013 -->
<%@ page session="false"%>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"
	contentType="text/html; charset=ISO-8859-1"%>
<%@ page language="java" import="java.util.regex.*"
	contentType="text/html; charset=ISO-8859-1"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dashboard</title>
<link href="style.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<%
		//response.sendRedirect("home.mnt");
	%>
	<div id="header">
		<a href="#" class="logo"><img alt="" src="images/logo.jpg"></a>
		<div id="header-right">
			<%
				HttpSession session1 = request.getSession(false);

				if (session1.getAttribute("role") == null) {
					/*  response.sendRedirect(".././Login/login.jsp"); */

					RequestDispatcher dispatcher = request
							.getRequestDispatcher(".././Login/login.jsp");
					dispatcher.forward(request, response);
					//response.sendRedirect("home.mnt");
				}
			%>

			<p class="username">
				Welcome to <span class="color"><%=session1.getAttribute("role")%>
				</span>
			</p>
			<a href="logout.mnt" class="logout">Logout</a>
		</div>
	</div>