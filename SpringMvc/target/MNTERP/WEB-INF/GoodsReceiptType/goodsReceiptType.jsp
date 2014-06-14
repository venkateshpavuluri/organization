<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											
											$('#addgreceiptform')
													.validate(
															{
																rules : {
																	goodsReceiptType : {
																		required : true },
																	
																},
																messages : {
																	goodsReceiptType : "<font style='color: red;'><b>Goods Receipt Type is Required</b></font>"
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
																		required : true
																	},

																},
																messages : {
																	goodsReceiptTypeEdit : "<font style='color: red;'><b>Goods Receipt Type is Required</b></font>"
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

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Goods Receipt Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="goodsReceiptTypeValues"
					items="${goodsReceiptTypeValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="searchGoodsReceiptType.mnt"
						commandName="goodsReceiptType" method="GET">
						<body>
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach
											var="addGoodsReceiptTypeSuccess"
											items="${param.addGoodsReceiptTypeSuccess}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.addGoodsReceiptTypeSuccess}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>

								<tr>
									<td colspan="2"><c:forEach var="goodsReceiptTypeUpdate"
											items="${param.goodsReceiptTypeUpdate}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.goodsReceiptTypeUpdate}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td colspan="2"><c:forEach var="goodsReceiptTypeDelete"
											items="${param.goodsReceiptTypeDelete}">
											<div class="alert-success" id="savemessage">
												<strong>Success!</strong>
												<c:out value="${param.goodsReceiptTypeDelete}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>

								<%-- <tr>
									<td><spring:message code="label.goodsreceipttype"/><form:select
											path="goodsReceiptTypeId" class="textbox">
											<form:option value="0">..select..</form:option>
											<form:options items="${selectGoodsReceiptType}" />
										</form:select> <input type="submit" value="search" class="btn btn-primary" />
									</td>
								</tr> --%>
								
								<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">										
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>
								
								
							</table>

						</body>
					</form:form>

					<c:forEach var="goodsReceiptTypeSearch"
						items="${goodsReceiptTypeSearch}">
						<c:set var="i" value="${goodsReceiptTypeSearch}"></c:set>
					</c:forEach>

					<c:if test="${i!=null}">
						<display:table id="goodsReceiptTypeRow"
							name="goodsReceiptTypeSearch"
							requestURI="searchGoodsReceiptType.mnt" pagesize="5"
							class="table">
							<display:column property="goodsReceiptTypeId"
								title="GoodsReceiptTypeId" media="none" sortable="true"></display:column>
							<display:column property="goodsReceiptType"
								title="Goods Receipt Type" media="html" sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<a
									href="goodsReceiptTypeEditHome.mnt?goodsReceiptTypeIdEdit=<c:out value="${goodsReceiptTypeRow.goodsReceiptTypeId}"/>"
									style="color: red"> <img src="images/Edit.jpg" width="20px"
									height="20px" />
								</a>
							</display:column>

							<display:column title="Delete">
								<a
									href="goodsReceiptTypeDelete.mnt?goodsReceiptTypeIdDelete=<c:out value="${goodsReceiptTypeRow.goodsReceiptTypeId}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px" /></a>
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
					<form:form action="addGoodsReceiptType.mnt"
						commandName="goodsReceiptType" method="post" id="addgreceiptform">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach
										var="addGoodsReceiptTypeDuplicate"
										items="${addGoodsReceiptTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${addGoodsReceiptTypeDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>

							<form:hidden path="aid" id="aid" />
							<tr>
								<td><spring:message code="label.goodsreceipttype"/><span class="required">*</span></td>
								<td><form:input path="goodsReceiptType" class="textbox" />
								</td>
							</tr>

							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Save"
									id="submitid" class="btn btn-primary" /><input type="reset"
									value="Reset" class="btn btn-primary" /></td>
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
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${updateGoodsReceiptTypeDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
								<form:hidden path="goodsReceiptTypeIdEdit" />
								<tr>
									<td><spring:message code="label.goodsreceipttype"/><span class="required">*</span></td>
									<td><form:input path="goodsReceiptTypeEdit"
											class="textbox" /></td>
								</tr>
								<tr>
									<td colspan="2" ><input type="submit"
										value="Update" class="btn btn-primary" id="updateid" /></td>
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
