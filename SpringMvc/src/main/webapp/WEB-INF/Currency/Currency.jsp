<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						jQuery.validator.addMethod("alphaNumeric", function(
								value, element) {
							return this.optional(element)
									|| /^[a-zA-Z][a-zA-Z0-9&_]*$/.test(value);
						});

						//AddForm Validations
						$('#sumbnid')
								.click(
										function(event) {
											//alert($('#sdType').val());
											$('#currencyadd')
													.validate(
															{
																rules : {
																	currency : {
																		required : true,
																		alphaNumeric : true,
																	},
																	symbol : {
																		required : true
																	},
																	isoCode : {
																		required : true,
																		alphaNumeric : true,
																	}
																},
																messages : {
																	currency : {
																		required : "<font style='color: red;'><b>Currency is Required</b></font>",
																		alphaNumeric : "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	},

																	isoCode : {
																		required : "<font style='color: red;'><b>ISOCode is Required</b></font>",
																		alphaNumeric : "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	},

																	symbol : "<font style='color: red;'><b>Symbol is Required</b></font>"

																},

															});
										});
						//UpdateForm Validations
						$('#upbtnId')
								.click(
										function(event) {

											$('#currencyEdit')
													.validate(
															{
																rules : {
																	currencyEdit : {
																		required : true,
																		alphaNumeric : true,
																	},
																	isoCodeEdit : {
																		required : true,
																		alphaNumeric : true,
																	},
																	symbolEdit : {
																		required : true
																	}

																},
																messages : {
																	currencyEdit : {
																		required : "<font style='color: red;'><b>Currency is Required</b></font>",
																		alphaNumeric : "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	},

																	isoCodeEdit : {
																		required : "<font style='color: red;'><b>ISOCode is Required</b></font>",
																		alphaNumeric : "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	},
																	symbolEdit : "<font style='color: red;'><b>Symbol is Required</b></font>"

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
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs").tabs();
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
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("currencyAddDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search').click(function(e) {
			$('#edit').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#add').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Currency</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="currencyValues" items="${currencyValues}">
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
					<form:form action="currencySearch.mnt" method="get"
						commandName="currencyForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="currencyUpadted"
										items="${param.list}">
										<div class="alert-success">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.currency"/> <spring:message code="label.saveSuccess"/>
										</div>	
									</c:forEach>
									
									<c:forEach var="currencysaveError"
										items="${param.listwar}">
										<div class="alert-danger" >
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.currency"/>	<spring:message code="label.saveFail"/>
										</div>	
									</c:forEach>
									
										
									<c:forEach var="currencyUpadted" items="${currencyUpadte}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.currency"/> <spring:message code="label.updateSuccess"/>
										</div></c:forEach>
										
										<c:forEach items="${currencyUpadteError}">
										<div class="alert-danger">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.currency"/> <spring:message code="label.updateFail"/>
										</div></c:forEach>
										<c:forEach items="${currencyDelete}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.currency"/> <spring:message code="label.deleteSuccess"/>
										</div></c:forEach>
										
										<c:forEach items="${currencyDeleteError}">
										<div class="alert-danger">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.currency"/> <spring:message code="label.deleteFail"/>
										</div></c:forEach>
										
										
										
									</td>
							</tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="currencyForm.operations">
										<select class="select" name="operations">
											<option value="<spring:message code='assignedOperator'/>">
												<spring:message code="label.equalsTo" />
											</option>
											<option value="<spring:message code='notequalsOperator'/>">
												<spring:message code="label.notEqualsTo" />
											</option>
											<option value="<spring:message code='beginsWithOperator'/>">
												<spring:message code="label.beginsWith" />
											</option>
											<option value="<spring:message code='endsWithOperator'/>">
												<spring:message code="label.endsWith" />
											</option>
											<option value="<spring:message code='containsOperator'/>">
												<spring:message code="label.contains" />
											</option>
										</select>
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<c:set var="save" value="false"></c:set>
								<c:set var="edit" value="false"></c:set>
								<c:set var="delete" value="false"></c:set>
								<c:set var="update" value="false"></c:set>
								<c:set var="search" value="false"></c:set>
								<fmt:setBundle basename="button" />
								<fmt:message key="label.save" var="messagesav" />
								<fmt:message key="label.search" var="messagesea" />
								<fmt:message key="label.delete" var="messagedel" />
								<fmt:message key="label.update" var="messageup" />
								<fmt:message key="label.edit" var="messageed" />
								<c:forEach items="${sessionScope.privilegeList}"
									var="privileges">

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



								<td><c:choose>
										<c:when test="${search}">
											<input type="submit"
												value="<spring:message code="label.search"/>"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>
							</tr>


						</table>
					</form:form>

					<c:forEach var="bomSearch" items="${currencySearch}">
						<c:set var="g" value="${currencySearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="currencyRow" name="currencySearch"
							requestURI="currencySearch.mnt" pagesize="5" class="table">

							<display:column property="currency" titleKey="label.currency"
								media="html" sortable="true"></display:column>
							<display:column property="isoCode" titleKey="label.isocode"
								media="html" sortable="true"></display:column>
							<display:column property="symbol" titleKey="label.symbol"
								media="html" sortable="true"></display:column>


							<display:column titleKey="label.edit">

								<c:choose>
									<c:when test="${edit}">


										<a
											href="currencyEdit.mnt?currencyEdit=<c:out value="${currencyRow.currencyId}"/>"
											style="color: red"><img src="images/Edit.jpg"
											title="Edit" width="20px" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" title="Edit"
											class="btn btn-danger" width="20px" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete}">

										<a
											href="currencyDelete.mnt?currencyDelete=<c:out value="${currencyRow.currencyId}"/>"
											style="color: red"
											onclick="return confirm('Do You Want To Delete This Record?')"><img
											src="images/Delete.jpg" title="Delete" width="20px"
											height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" title="Edit"
											class="btn btn-danger" title="Delete" width="20px"
											height="20px"  /></a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

							<display:setProperty name="paging.banner.group_size" value="3" />

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
						</display:table>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">


					<form:form action="currencyAdd.mnt" method="POST"
						commandName="currencyForm" id="currencyadd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><form:hidden path="currencyAddDuplicate" />
									<c:forEach 
										items="${currencyDuplicateAdd}">
										
										<div class="alert-warning" id="successmessage">
											<strong><spring:message code="label.warning"/> </strong>
										<spring:message code="label.currency"/> <spring:message code="label.duplicateCheck"/>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td><spring:message code="label.currency" /><label
									style="color: red">*</label></td>
								<td><form:input path="currency" id="currency"
										class="textbox" maxlength="50" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.isocode" /><label
									style="color: red">*</label></td>
								<td><form:input path="isoCode" id="isoCode" class="textbox"
										maxlength="20" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.symbol" /><label
									style="color: red">*</label></td>
								<td><form:input path="symbol" id="symbol" class="textbox"
										maxlength="1" /></td>
							</tr>

							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save }">
											<input type="submit"
												value="<spring:message
								code="label.save" />"
												class="btn btn-primary" id="sumbnid" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message
								code="label.save" />"
												class="btn btn-danger" id="sumbnid" />
										</c:otherwise>
									</c:choose><input type="reset" class="btn btn-primary"
									value="<spring:message
								code="label.reset" />" /></td>
							</tr>
						</table>
					</form:form>


				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="currencyEditValues" items="${currencyValues }">
						<form:form action="currencyUpdate.mnt" method="POST"
							commandName="currencyForm" id="currencyEdit">
							<table class="tableGeneral">

								<form:hidden path="currencyIdEdit" />
								<tr>
									<td colspan="2"><form:hidden
											path="currencyAddDuplicateUpdate"
											id="currencyAddDuplicateUpdate" /> <c:forEach
											
											items="${currencyDuplicateUpdate}">
											<div class="alert-warning" id="successmessage">
											<strong><spring:message code="label.warning"/> </strong>
										<spring:message code="label.currency"/> <spring:message code="label.duplicateCheck"/>
										</div>
										</c:forEach></td>
								</tr>
								<%--  <tr><td>Bom Id</td><td><form:input path="bomCategoryIdEdit" id="bomCategoryId"  class="textbox" /> </td> </tr> --%>
								<%-- <tr><td>Bom Category</td><td><form:input path="bomCategoryEdit" id="bomCategory"  class="textbox" /> </td> </tr> --%>

								<tr>
									<td><spring:message code="label.currency" /><label
										style="color: red">*</label></td>
									<td><form:input path="currencyEdit" id="currency"
											class="textbox" /> <form:hidden path="currencyEditUpdate"
											id="currencyUpdate" class="textbox" maxlength="50" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.isocode" /><label
										style="color: red">*</label></td>
									<td><form:input path="isoCodeEdit" id="isoCode"
											class="textbox" /> <form:hidden path="isoCodeEditUpdate"
											id="isoCodeUpdate" class="textbox" maxlength="20" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.symbol" /><label
										style="color: red">*</label></td>
									<td><form:input path="symbolEdit" id="symbol"
											class="textbox" /> <form:hidden path="symbolEditUpdate"
											id="symbolUpdate" class="textbox" maxlength="1" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><c:choose>
											<c:when test="${update }">
												<input type="submit"
													value="<spring:message
								code="label.update" />"
													class="btn btn-primary" id="upbtnId" />
											</c:when>
											<c:otherwise>
												<input type="submit"
													value="<spring:message
								code="label.update" />"
													class="btn btn-danger" disabled="disabled" id="upbtnId" />
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




