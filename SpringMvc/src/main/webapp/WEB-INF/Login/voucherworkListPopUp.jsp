<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>VoucherWorkFlow</title>
    


<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>

<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="js/jquery.validate.min.js"></script> -->
<script type="text/javascript" src="js/jquery.signature.js"></script>
 <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
	
<link type="text/css" href="js/jquery.signature.css" rel="stylesheet" />
<style type="text/css">
.kbw-signature { width: 200px; height: 100px; }
</style>
	

<!--  <script type="text/javascript">
function closewindos(id)
 {
 		 alert("id iss"+id);
 		 window.close(id);
 		 
 }
 </script> -->
  
  <script type="text/javascript">
 
$(document).ready(function() {

	$('.sig').signature();
		$('.sig').signature({syncField: '.signatureJSON'}); 
	 $('#clear1').click(function() {
		$('#sig').signature('clear');
	}); 
	
	/* $('#sigTo').signature({disabled: true}); 
	 $('#sigTo').signature('draw', $('#signatureJSONEdit').val());
	 $('#clear').click(function() {
		$('#sigTo').signature('clear');
		$('#sigTo').signature({disabled: false}); 
		$('#signatureJSONEdit').val("");
		$('#sigTo').signature({syncField: '#signatureJSONEdit'}); 
	 }); */

});
	 </script>
   </head>
  <body background="red" onload="JavaScript:reloading()">
  
	<c:forEach var="wkflowsuccess" items="${workflowupdatesuccess}">
		<c:out value="${wkflowsuccess}" />
	</c:forEach>
	<form:form action="voucherWorkFlowUpdate.mnt" method="post"
			commandName="voucherWorkFlow">
		
	<c:forEach var="vocherView"
		items="${vocherView}">


		
			
			<div>
				<table class="table">
					
					<tr>
						<td><strong><spring:message code="label.voucherDT" />:</strong> </td>
						<td><c:out value="${vocherView.voucherDT }"></c:out></td>
						<td><strong><spring:message code="label.employeeId" />:</strong></td>
						<td><c:out value="${vocherView.employeeId }" /></td>
						<td><strong><spring:message code="label.amount" />:</strong></td>
						<td><c:out value="${vocherView.amount }" />
						</td>
					</tr>
					<tr>
						<td><strong><spring:message code="label.voucherNO" /> :</strong></td>
						<td><c:out value="${vocherView.voucherNo }" />
						</td>
						<td><strong><spring:message code="label.voucherTypeName" />:</strong></td>
						<td><c:out value="${vocherView.voucherTypeName }" /></td>
						<td><strong><spring:message code="label.statusId" />:</strong></td>
						<td><c:out value="${vocherView.statusName }" /></td>
					</tr>
					
					<form:hidden path="workFlowListId" />
					<tr></tr>
					<tr></tr>
						<tr>
					<td>Signature<span>*</span></td>
									<td><div  class="sig"></div> <!-- <input type="button" name="Clear" id="clear1" value="Clear" /> -->  <form:hidden path="signature"
											 class="signatureJSON"  /></td>
										
				</tr> 
				</table>
				<br /> <br />
				
			</div>
			<h1></h1>
			<%-- 	<tr><td><spring:message code="label.organizationName"/> </td><td><form:input path="orgName"/></td></tr>	 --%>
			<br/>
			<div>
				<table class="table1">
					<tr></tr>
					<tr></tr>
				
					

					<tr>
						<c:forEach var="users" items="${actionBy}">
							<c:set var="userNames" value="${users }" />
						</c:forEach>

						<c:if test="${userNames!=null }">
							<td > <c:out
										value="${actionBy }" /> &nbsp;&nbsp;&nbsp;</td>
							<td ><spring:message code="label.comments"></spring:message><c:out
										value="${comments }" /></td>
						</c:if>
					</tr>
<tr><td colspan="2">&nbsp;</td> </tr>
					<tr>

						<td><spring:message code="label.comments" /></td>
						<td><form:textarea path="comments" /></td>
					</tr>
					<tr><td colspan="2">&nbsp;</td> </tr>
					<tr>
						<c:forEach var="actions" items="${WFActions}" varStatus="op">
					
							<td align="center"><spring:bind path="actionNames">
									<input type="submit" name="actionNames" id="butt${op.index}" onclick="closewindos(this.id)" class="btn btn-primary"
										value="${actions.wfactionName}" />
								</spring:bind></td>
								
						</c:forEach>
					</tr>
				</table>
				
				
			</div>
			
			
				</c:forEach>
			
		</form:form>

  </body>
</html>
