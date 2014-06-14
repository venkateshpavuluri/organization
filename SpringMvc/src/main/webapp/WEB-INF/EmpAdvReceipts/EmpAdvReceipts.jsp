<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author Srinivas
 @version 1.0    -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#edit').hide();
			$('#month').val('');
			$('#earadvId').val('');
			$('#receivedamount').val('');
			$('#receiveddate').val('');
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
<script type="text/javascript">
function dateFun(datePattern) {
		$('#receiveddate,#receiveddateedit').datepicker({
			dateFormat :  datePattern,
			changeMonth : true,
			changeYear : true,
		});

	}
</script>

<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#sumbnid')
								.click(
										function(event) {

											$('#addaccountform')
													.validate(
															{
																rules : {
																	receivedamount : {
																		required : true,
																		number:true
																	},
																	earadvId:{
																required:true
															},
																	receiveddate:{
																		required:true
																	},
																	month:{
																		required:true,
																		number:true
																	},

																},
																messages : {
																	earadvId:"<font style='color: red;'><b>Employee Advance is Required</b></font>",
																	receivedamount : {
																		required:"<font style='color: red;'><b>Received Amount is Required</b></font>",
																		number : "<font style='color: red;'><b>Only numerics are allowed.</b></font>",
																	},
																	receiveddate: {
																		required:"<font style='color: red;'><b>Received Date is Required</b></font>",
																		number : "<font style='color: red;'><b>Only numerics are allowed.</b></font>",
																	},
																	month: {
																		required:"<font style='color: red;'><b>Month is Required</b></font>",
																		number : "<font style='color: red;'><b>Only numerics are allowed.</b></font>",
																	},
																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert("hai");
											$('#editaccountForm')
													.validate(
															{
																rules : {
																	receivedamount : {
																		required : true,
																		number:true
																	},
																	earadvId:{
																required:true
															},
																	receiveddate:{
																		required:true
																	},
																	month:{
																		required:true,
																		number:true
																	},

																},
																messages : {
																	earadvId:"<font style='color: red;'><b>Employee Advance is Required</b></font>",
																	receivedamount : {
																		required:"<font style='color: red;'><b>Received Amount is Required</b></font>",
																		number : "<font style='color: red;'><b>Only numerics are allowed.</b></font>",
																	},
																	receiveddate: {
																		required:"<font style='color: red;'><b>Received Date is Required</b></font>",
																		number : "<font style='color: red;'><b>Only numerics are allowed.</b></font>",
																	},
																	month: {
																		required:"<font style='color: red;'><b>Month is Required</b></font>",
																		number : "<font style='color: red;'><b>Only numerics are allowed.</b></font>",
																	},
																},
															});

										});

					});
</script>



</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Employee Advance Receipts</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
								code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
								code="label.add" /></a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchEar.mnt" method="GET"
						commandName="EAR">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="codeGroupAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.ear"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.ear"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="accountGroupUpdate"
										items="${accountGroupUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.ear"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="accountGroupUpdateError"
										items="${accountGroupUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.ear"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="accountGroupDelete"
										items="${accountGroupDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.ear"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="accountGroupDeleteError"
										items="${accountGroupDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.ear"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td>
							
	
								
								<form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
										
									</form:select> 
									
									<spring:bind path="EAR.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> 
									<form:input path="basicSearchId" cssClass="textbox" />
									<c:set
										var="save" value="true"></c:set> <c:set var="edit"
										value="true"></c:set> <c:set var="delete" value="true"></c:set>
									<c:set var="update" value="true"></c:set> <c:set var="search"
										value="true"></c:set> <fmt:setBundle basename="button" /> <fmt:message
										key="label.save" var="messagesav" /> <fmt:message
										key="label.search" var="messagesea" /> <fmt:message
										key="label.delete" var="messagedel" /> <fmt:message
										key="label.update" var="messageup" /> <fmt:message
										key="label.edit" var="messageed" /> <c:forEach
										items="${sessionScope.privilegeList}" var="privileges">
										<c:choose>
											<c:when test="${privileges eq messagesav }">
												<c:set var="save" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messagesea }">
												<c:set var="search" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messagedel }">
												<c:set var="delete" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messageed }">
												<c:set var="edit" value="true"></c:set>
											</c:when>
											<c:when test="${privileges eq messageup }">
												<c:set var="update" value="true"></c:set>
											</c:when>
										</c:choose>

									</c:forEach>
									
									 <c:choose>
										<c:when test="${search}">
								
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>

					<c:if test="${eaBeans!=null}">
						<display:table id="earid" name="eaBeans"
							requestURI="searchEar.mnt" pagesize="5" class="table">
							<display:column property="earId" title="EARID"
								media="none" sortable="true"></display:column>
							<display:column property="earadvId"
								titleKey="label.empadv" media="html" sortable="true"></display:column>
								<display:column property="receivedamount"
								titleKey="label.receivedamount" media="html" sortable="true"></display:column>
								<display:column property="receiveddate"
								titleKey="label.recieveddate" media="html" sortable="true"></display:column>
								<display:column property="month"
								titleKey="label.month" media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
							<c:choose>
							<c:when test="${edit }">
								<a
									href="earEdit.mnt?earedit=<c:out value="${earid.earId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
									
									</c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
									
							</display:column>
							<display:column titleKey="label.delete">
							<c:choose>
							<c:when test="${delete}">
								<a href="earDelete.mnt?eardelete=<c:out value="${earid.earId}"/>"
									style="color: red"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')"><img
									src="images/Delete.jpg" width="20px" height="20px"/></a>
									</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
							</c:otherwise>
							</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="saveear.mnt" id="addaccountform"
						method="POST" commandName="EAR">
						<table class="tableGeneral">

							
							
							<tr>
								<td><spring:message code="label.empadv" /><span
									class="required">*</span> </td><td> <form:select path="earadvId" id="earadvId" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${empAdvIds}" />
								</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.receivedamount" /><span
									class="required">*</span> </td><td> <form:input path="receivedamount"
										id="receivedamount" class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.recieveddate" /><span
									class="required">*</span> </td><td> <form:input path="receiveddate"
										id="receiveddate" class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.month" /><span
									class="required">*</span> </td><td> <form:input path="month"
										id="month" class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit" value="<spring:message code="label.save"/>"
									class="btn btn-primary" id="sumbnid" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose>
									<input type="reset" value="<spring:message code="label.reset"/>"  class="btn btn-primary" /></td>
									
							</tr>
						</table>
					</form:form>


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="AccountEditValues" items="${editvalues }">
						<form:form action="earUpdate.mnt" method="POST"
							commandName="EAR" id="editaccountForm">
							<table class="tableGeneral">

								
								<form:hidden path="earId" />
								<tr>
								<td><spring:message code="label.empadv" /><span
									class="required">*</span> </td><td> <form:select path="earadvId" class="select">
										<form:option value="">--Select--</form:option>
								         <form:options items="${empAdvIds}" />
								</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.receivedamount" /><span
									class="required">*</span> </td><td> <form:input path="receivedamount"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.recieveddate" /><span
									class="required">*</span> </td><td> <form:input path="receiveddate"
										id="receiveddateedit" class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.month" /><span
									class="required">*</span> </td><td> <form:input path="month"
										class="textbox" maxlength="50" /></td>
							</tr>

								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${update}"><input type="submit" value="<spring:message code="label.update"/>"
										id="updateid" class="btn btn-primary" /></c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<spring:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
										</c:otherwise>

									</c:choose></td>
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>
</body>
</html>




