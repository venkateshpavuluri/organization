
<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 15-09-2013 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" session="false"
	pageEncoding="UTF-8"%>

<!-- author pvenkateswarlu -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
  window.open ("http://localhost:1259/MNTERPA/login.mnt",
"mywindow","status=1,toolbar=0"); 
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css'>
	<script src="js/accordionmenu.js" type="text/javascript"></script>
	<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%-- <form:form action="login.mnt" commandName="command" method="post"> --%>
	<form action="login.mnt" method="post">

		<div id="header">
			<a href="#" class="logo"><img alt="" src="images/logo.jpg"></a>
			<div id="header-right">
				<p class="username">
					Welcome to <span class="color">ERP</span>
				</p>
				<!--<a href="#" class="logout">Logout</a>-->
			</div>
		</div>

		<div id="login-block">

			<table width="100%" border="0" cellspacing="0" cellpadding="0">



				<tr>
					<td><s:message code="label.language" /> : <a
						href="?language=en"><s:message code="label.english" /> </a>|<a
						href="?language=hi"><s:message code="label.hindi" /></a>|<a
						href="?language=te"><s:message code="label.telugu" /></a></td>
				</tr>
				
<%  response.setHeader("pragma", "no-cache");              
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");             
  response.setHeader("Expires", "0"); %>
				<tr>
					<th colspan="2" align="center"><span class="title"><s:message
								code="label.login" /></span></th>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><div class="log-top">
							<%-- <form:input path="userName"
								onblur="if(this.value=='') this.value='Username';"
								onfocus="if(this.value=='Username') this.value='';" /> --%>
								<input type="text" name="userName"/>
								
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><div class="log-bottom">
							<%-- <form:password path="password"
								onblur="if(this.value=='') this.value='Password';"
								onfocus="if(this.value=='Password') this.value='';" /> --%>
								<input type="password" name="password"/>
						</div></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td><a href="forgotPassword.jsp"><s:message
								code="label.forgotPassword" /></a></td>
					<td align="right"><input type="submit" class="login-btn"
						value="<s:message code="label.login"/>" /></td>
				</tr>
			</table>
		</div>
		<!--Footer-->
		<div id="footer" style="position:absolute; bottom:0;">
			<p class="left">
				All copy rights reserved <a href="#">Company Name</a>.
			</p>
			<p class="right">
				Powered by <a href="http://www.mntsoft.co.in" target="_blank">www.mntsoft.co.in</a>.
			</p>
		</div>
	<%-- </form:form> --%></form>
</body>
</html>
<html>

</html>