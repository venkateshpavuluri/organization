<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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

						jQuery.validator.addMethod("alphabets", function(value,
								element) {
							return this.optional(element)
									|| /^[A-Za-z][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});

						jQuery.validator.addMethod("alphanumeric", function(
								value, element) {
							return this.optional(element)
									|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+ ]*$/
											.test(value);
						});

						jQuery.validator.addMethod("specialcharacters",
								function(value, element) {
									return this.optional(element)
											|| /^[0-9a-zA-Z&_ ]+$/.test(value);
								});

						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {

											$('#addgreceiptform')
													.validate(
															{
																rules : {
																	goodsReceiptType : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true,
																		maxlength : 50
																	},

																},
																messages : {
																	goodsReceiptType : {
																		required : "<font style='color: red;'><b>Goods Receipt Type is Required.</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																		maxlength : "<font style='color: red;'><b>Goods Receipt Type only 50 Characters are allowed.</b></font>",
																	}
																},

															});
										});
						//UpdateForm Validations
						$('#updateid')
								.click(
										function(event) {

											$('#editgreceiptForm')
													.validate(
															{
																rules : {
																	goodsReceiptTypeEdit : {
																		required : true,
																		alphabets : true,
																		specialcharacters : true,
																		maxlength : 50
																	},

																},
																messages : {
																	goodsReceiptTypeEdit : {

																		required : "<font style='color: red;'><b>Goods Receipt Type is Required.</b></font>",
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>",
																		maxlength : "<font style='color: red;'><b>Goods Receipt Type only 50 Characters are allowed.</b></font>",
																	}
																},
															});

										});

					});
</script>

<script>
	$(function() {
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

		$("#add,#search").click(function(e) {

			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("aid").value == 1) {
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

		$("#add").click(function(e) {

			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#warningmessage").hide();
		});
	});
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Goods Receipt Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="goodsReceiptTypeValues"
					items="${goodsReceiptTypeValues}">
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
					<form:form action="searchGoodsReceiptType.mnt"
						commandName="goodsReceiptType" method="GET">
						<body>
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach items="${param.list}">
											<div class="alert-success" id="savemessage">
												<strong> <spring:message code="label.success" />
												</strong>
												<spring:message code="label.goodsRecieptType" />
												<spring:message code="label.saveSuccess" />
											</div>
										</c:forEach> <c:forEach items="${param.listwar}">
											<div class="alert-danger" id="savemessage">
												<strong> <spring:message code="label.error" /></strong>
												<spring:message code="label.goodsRecieptType" />
												<spring:message code="label.saveFail" />
											</div>
										</c:forEach> <c:forEach items="${gdsRecieptTypeUpdate}">
											<div class="alert-success" id="savemessage">
												<strong> <spring:message code="label.success" /></strong>
												<spring:message code="label.goodsRecieptType" />
												<spring:message code="label.updateSuccess" />
											</div>
										</c:forEach> <c:forEach items="${gdsRecieptTypeUpdateError}">
											<div class="alert-success" id="savemessage">
												<strong> <spring:message code="label.success" /></strong>
												<spring:message code="label.goodsRecieptType" />
												<spring:message code="label.updateFail" />
											</div>
										</c:forEach> <c:forEach items="${gdsRecieptTypeDelete}">
											<div class="alert-success" id="savemessage">
												<strong> <spring:message code="label.success" /></strong>
												<spring:message code="label.goodsRecieptType" />
												<spring:message code="label.deleteSuccess" />
											</div>
										</c:forEach> <c:forEach items="${gdsRecieptTypeDeleteError}">
											<div class="alert-success" id="savemessage">
												<strong> <spring:message code="label.danger" /></strong>
												<spring:message code="label.goodsRecieptType" />
												<spring:message code="label.deleteFail" />
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td><spring:message code="label.searchby" /></td>
									<td><form:select path="xmlLabel" cssClass="select">

											<form:options items="${xmlItems}" />
										</form:select> <spring:bind path="goodsReceiptType.operations">
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
											<c:when test="${privileges eq messageup}">
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

						</body>
					</form:form>

					<%-- 	<c:forEach var="goodsReceiptTypeSearch"
						items="${goodsReceiptTypeSearch}">
						<c:set var="as" value="${goodsReceiptTypeSearch}"></c:set>
					</c:forEach> --%>


					<c:if test="${goodsReceiptTypeSearch!=null}">
						<display:table id="goodsReceiptTypeRow" name="goodsReceiptTypeRow"
							requestURI="searchGoodsReceiptType.mnt" pagesize="5"
							class="table">
							<%-- 	<display:column property="goodsReceiptTypeId"
								title="GoodsReceiptTypeId" media="none" sortable="true"></display:column> --%>
							<display:column property="goodsReceiptType"
								titleKey="label.goodsreceipttype" media="html" sortable="true"></display:column>
							<display:column titleKey="label.edit" style="color:white">
								<c:choose>
									<c:when test="${edit}">
										<a
											href="goodsReceiptTypeEditHome.mnt?goodsReceiptTypeIdEdit=<c:out value="${goodsReceiptTypeRow.goodsReceiptTypeId}"/>"
											style="color: red"> <img src="images/Edit.jpg"
											width="20px" height="20px" />
										</a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px"
											class="btn btn-danger" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${delete}">
										<a
											href="goodsReceiptTypeDelete.mnt?goodsReceiptTypeIdDelete=<c:out value="${goodsReceiptTypeRow.goodsReceiptTypeId}"/>"
											style="color: red"
											onclick="return confirm('Do u want to Delete The Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" width="20px" height="20px"
											class="btn btn-danger" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />
							<%-- <display:setProperty name="paging.banner.group_size" value="3" />
							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" /> --%>
						</display:table>
					</c:if>
				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="addGoodsReceiptType.mnt"
						commandName="goodsReceiptType" method="post" id="addgreceiptform">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach
										var="addGoodsReceiptTypeDuplicate"
										items="${addGoodsReceiptTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning" /></strong>
											<spring:message code="label.goodsreceipttype" />
											<spring:message code="label.duplicateCheck" />
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" id="aid" />
							<tr>
								<td><spring:message code="label.goodsreceipttype" /><span
									class="required">*</span></td>
								<td><form:input path="goodsReceiptType" class="textbox" maxlength="50"/>
								</td>
							</tr>

							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save }">
											<input type="submit"
												value="<spring:message code="label.save"/>" id="submitid"
												class="btn btn-primary" />
										</c:when>
										<c:otherwise>
											<input type="submit"
												value="<spring:message code="label.save"/>" id="submitid"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
						</table>
					</form:form>

				</div>
			</div>

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="goodsReceiptTypeEditValues"
						items="${goodsReceiptTypeValues}">
						<form:form action="goodsReceiptTypeUpdate.mnt" method="POST"
							commandName="goodsReceiptType" id="editgreceiptForm">
							<table class="tableGeneral">
								<tr>
									<td colspan="2"><c:forEach
											var="updateGoodsReceiptTypeDuplicate"
											items="${updateGoodsReceiptTypeDuplicate}">
											<div class="alert-warning">
												<strong><spring:message code="label.warning" /></strong>
												<spring:message code="label.goodsreceipttype" />
												<spring:message code="label.duplicateCheck" />
											</div>
										</c:forEach></td>
								</tr>
								<form:hidden path="goodsReceiptTypeIdEdit" />
								<tr>
									<td><spring:message code="label.goodsreceipttype" /><span
										class="required">*</span></td>
									<td><form:input path="goodsReceiptTypeEdit"
											class="textbox" maxlength="50"/></td>
								</tr>
								<tr>
									<td colspan="2"><c:choose>
											<c:when test="${update}">
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateid" />
											</c:when>
											<c:otherwise>
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-danger" id="updateid" />
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
