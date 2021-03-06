<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author Srinivas
 @version 1.0    -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet" href="/resources/demos/style.css" />
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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#sumbnid')
								.click(
										function(event) {
											//alert($('#sdType').val());
											
											$('#addvoucherform')
													.validate(
															{
																rules : {
																	vouchertype : {
																		required : true,
																		alphabets:true,
																		specialcharacters:true },
																	
																},
																messages : {
																	vouchertype : {
																		required:"<font style='color: red;'><b>Voucher Type is Required</b></font>",
																		alphabets:"<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters:"<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>",
																	}
																},

															});
										});
						//UpdateForm Validations
						 $('#updated')
								.click(
										function(event) {
											//var assetedit = $('#assetEditId').val();
											//alert(assetedit);
											$('#editvoucherForm')
													.validate(
															{
																rules : {
																	evouchertype : {
																		required : true,
																		alphabets:true,
																		specialcharacters:true
																	},

																},
																messages : {
																	evouchertype : {
																		required:"<font style='color: red;'><b>Voucher Type is Required</b></font>",
																		alphabets:"<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters:"<font style='color: red;'><b>Special Characters except &,_ are not allowed.</b></font>",
																	}
																},
															});

										}); 

					});
</script>

<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("vthide").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
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




</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle"><spring:message code="label.vouchertype" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				 </c:forEach> 
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchVoucherDetails.mnt" method="GET"
						commandName="VoucherType">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="voucherTypeAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.vouchertype"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.vouchertype"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="VoucherTypeUpdate"
										items="${VoucherTypeUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.vouchertype"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="VoucherTypeUpdateError"
										items="${VoucherTypeUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.vouchertype"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="VoucherTypeDelete"
										items="${VoucherTypeDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.vouchertype"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="VoucherTypeDeleteError"
										items="${VoucherTypeDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.vouchertype"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="VoucherType.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind><form:input path="basicSearchId" cssClass="textbox" />
									 <c:set
										var="save" value="false"></c:set> <c:set var="edit"
										value="false"></c:set> <c:set var="delete" value="false"></c:set>
									<c:set var="update" value="false"></c:set> <c:set var="search"
										value="false"></c:set> <fmt:setBundle basename="button" /> <fmt:message
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

					<c:forEach var="vtbeans"
						items="${vocherValues}">
						<c:set var="ag" value="${vtbeans}"></c:set>
					</c:forEach>
					<c:if test="${ag!=null}">
						<display:table id="voucherid" name="vtbeans"
							requestURI="searchVoucherDetails.mnt" pagesize="5"
							class="table">
							<display:column property="vouchertypeid"
								title="Voucher ID" media="none" sortable="true"></display:column>
							<display:column property="vouchertype" title="Voucher Type"
								media="html" sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
							<c:choose>
							<c:when test="${edit }">
								<a
									href="VoucherTypesedit.mnt?voucheredit=<c:out value="${voucherid.vouchertypeid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
									</c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
									
							</display:column>
							<display:column title="Delete">
							<c:choose>
							<c:when test="${delete }">
								<a
									href="VoucherTypeDelete.mnt?voucherdelete=<c:out value="${voucherid.vouchertypeid}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
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
				<form:form action="saveVoucherType.mnt" method="POST"
							commandName="VoucherType" id="addvoucherform">
					<table class="tableGeneral">

						<tr>
							<td colspan="2"><c:forEach var="VtSuccessdup"
									items="${VtSuccessdup}">
									<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.vouchertype"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
								</c:forEach></td>
						</tr>
						
							<form:hidden path="vthide" />	
							<tr>
							<td><spring:message code="label.vouchertype" /><span
									class="required">*</span> <form:input path="vouchertype"
										class="textbox"  maxlength="50"/></td>						
								
								
							</tr>
						
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit" value="<spring:message code="label.save" />"
									class="btn btn-primary" id="sumbnid"/></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose><input
										type="reset" value="<spring:message code="label.reset" />" class="btn btn-primary"/></td>
							</tr>
							</table>
						</form:form>
					

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="VoucherEditValues" items="${editvalues }">
						<form:form action="VoucherTypeUpdate.mnt" method="POST"
							commandName="VoucherType" id="editvoucherForm">
							<table class="tableGeneral"><tr>
							<td colspan="2"><c:forEach var="VtSuccessdupedit"
									items="${VtSuccessdupedit}">
									<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.vouchertype"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
								</c:forEach></td></tr>
                                     <form:hidden path="evthide" />
								<form:hidden path="evouchertypeid" />
								<tr>
								<td><spring:message code="label.vouchertype" /><span
									class="required">*</span> <form:input path="evouchertype"
										class="textbox" maxlength="50" /></td>	
								</tr>

								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update" />" class="btn btn-primary" id="updated"/></c:when>
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




