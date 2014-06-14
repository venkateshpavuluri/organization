<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="false" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="Lstyle.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"></link>
 <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' /> 
<script src="js/accordionmenu.js" type="text/javascript"></script>
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<style type="text/css">
            #shade, #modal { display: none; }
            #shade { position: fixed; z-index: 100; top: 0; left: 0; width: 100%; height: 100%; }
            #modal { position: fixed; z-index: 101; top: 33%; left: 25%; width: 50%; }
            #shade { background: silver; opacity: 0.5; filter: alpha(opacity=50); }
        </style>
<style type="text/css">
.inner {
  position: absolute;
}
</style>
         
        <script>
  $(function() {
	  $('#forgot').click(function() {
	 
    $( "#dialog" ).dialog();
     modal.style.display=shade.style.display= 'block';
   /* document.getElementById('getpass').onclick= function() {
        modal.style.display=shade.style.display= 'none';
        //$("dialog").attr("disabled", "disabled"); 
        
      //  dialog.style.display='none';
    }; */
	  });
  });
  
  </script>
</head>

<body>
<form action="home.mnt" method="post">
<div id="header">
 <a href="#" class="logo"><img alt="" src="images/logo.jpg" /></a>
 <div id="header-right">
    <p class="username">Welcome to <span class="color">ERP</span></p>
    <!-- <a href="#" class="logout">Logout</a> --> </div>
</div>

<%-- <table align="center" style="margin:0px auto;"><tr>
					<td><font color="blue"><s:message code="label.language" /> : </font><a
						href="?language=en"><font color="black"><s:message code="label.english" /></font> </a>|<a
						href="?language=hi"><font color="black"><s:message code="label.hindi" /></font> </a>|<a
						href="?language=te"><font color="black"><s:message code="label.telugu" /></font> </a></td>
				</tr></table>	 --%>		
<c:forEach var="roleUpadted" items="${checkmail}"><div class="alert-success" id="savemessage"><c:out value="${checkmail}"></c:out></div></c:forEach>
<div id="login-block1" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">

 <tr>
    <th width="288px"><span class="title"><s:message code="label.login" /></span></th>
    <th width="84px" rowspan="2"><input type="submit" class="login-btn" value="<s:message code="label.login"/>" /></th>
    </tr>
  <tr>
    <td>
      <div class="usname">
        <label>User Name</label>
        <span class="txtbox"><input type="text" name="userName" tabindex="0" /></span></div>
      <div class="password">
        <label>Password</label>
        <span class="txtbox"><input type="password" name="password" tabindex="1" /></span></div>
        
       <!-- <div id="forgot">Forgot Password</div> -->
      <div><a href="#" class="forgot" id="forgot"><s:message code="label.forgotPassword" /></a></div> 
    </td>
    </tr> 
</table>
</form>
  <div id="shade"></div>
   <div id="modal">
         <div id="dialog" title="Forgot Password">
<form action="forgot.mnt" method="post">
 <table><tr>
 <td>User Name</td>
 <td><input type="text" name="userNamefp"/></td></tr>
 <tr><td>Mail Id</td>
<td><input type="text" name="mailId"/></td>
 </tr>
 <tr><td><input type="submit" value="Get Password" id="getpass" /></td> </tr>
 </table>
 </form>
</div>
     
        </div>

<br></br>
<div>
			<center>
				<h4 style="color: RED">
					<c:forEach var="invalidup" items="${invalid}">
						<c:out value="${invalidup}"></c:out>
					</c:forEach>
				</h4>
			</center>
		</div>
		<div>
			<center>
				<h4 style="color: Green">
					<c:forEach var="validup" items="${valid}">
						<c:out value="${validup}"></c:out>
					</c:forEach>
				</h4>
			</center>
		</div>
</div>

<!--Footer-->
<div id="footer" style="position:absolute; bottom:0;">
 <p class="left">All copy rights reserved <a href="#">Company Name</a>.</p>
 <p class="right">Powered by <a href="http://www.mntsoft.co.in" target="_blank">www.mntsoft.co.in</a>.</p>
</div>

</body>
</html>