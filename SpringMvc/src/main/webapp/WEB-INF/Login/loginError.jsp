<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script src="js/accordionmenu.js" type="text/javascript"></script>
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<form:form action="login.mnt" commandName="command" method="post">

		<div id="header">
			<a href="#" class="logo"><img alt="" src="images/logo.jpg" /></a>
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
					<th colspan="2" align="center"><span class="title">Login</span></th>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><div class="log-top">
							<form:input path="userName"
								onblur="if(this.value=='') this.value='Username';"
								onfocus="if(this.value=='Username') this.value='';" />
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><div class="log-bottom">
							<form:password path="password"
								onblur="if(this.value=='') this.value='Password';"
								onfocus="if(this.value=='Password') this.value='';" />
						</div></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td><a href="forgotPassword.jsp">Forgot your Password?</a></td>
					<td align="right"><input type="submit" class="login-btn"
						value="Login" /></td>
				</tr>
			</table>
		</div>
		<div>
			<center>
				<h4 style="color: RED">Invalid Username Password</h4>
			</center>
		</div>
		<!--Footer-->
		<div id="footer" style="position: absolute; bottom: 0;">
			<p class="left">
				All copy rights reserved <a href="#">Company Name</a>.
			</p>
			<p class="right">
				Powered by <a href="http://www.mntsoft.co.in" target="_blank">www.mntsoft.co.in</a>.
			</p>
		</div>
	</form:form>
</body>
</html>
