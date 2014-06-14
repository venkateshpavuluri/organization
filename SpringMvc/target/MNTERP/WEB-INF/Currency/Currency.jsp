<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
						$('#sumbnid')
								.click(
										function(event) {
											//alert($('#sdType').val());
											$('#currencyadd')
													.validate(
															{
																rules : {
																	currency : { required : true},
																	symbol : { required : true},
																	isoCode  : { required : true}
																},
																messages : {
																	currency : "<font style='color: red;'><b>Currency is Required</b></font>",
																	isoCode : "<font style='color: red;'><b>ISOCode is Required</b></font>",
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
																	currencyEdit : {required : true},
																	isoCodeEdit : {required : true},
																	symbolEdit : {required : true}

																},
																messages : {
																	currencyEdit : "<font style='color: red;'><b>Currency is Required</b></font>",
																	isoCodeEdit : "<font style='color: red;'><b>ISOCode is Required</b></font>",
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
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="currencySearch.mnt" method="get"
						commandName="currencyForm">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="currencyUpadted"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong></strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="currencyUpadted"
										items="${currencyUpadte}">
										<div class="alert-success" id="successmessage">
											<strong></strong>
											<c:out value="${currencyUpadte}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td>Currency</td>
								<td><form:input path="currency" class="textbox" /></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary"/></td>
							</tr> --%>
							
							<tr>
								<td><s:message code="label.searchby" /></td>
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
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>
							

						</table>
					</form:form>

					<c:forEach var="bomSearch" items="${currencySearch}">
						<c:set var="g" value="${currencySearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
						<display:table id="currencyRow" name="currencySearch"
							requestURI="currencySearch.mnt" pagesize="5" class="table">

							<display:column property="currency" title="Currency" media="html"
								sortable="true"></display:column>
							<display:column property="isoCode" title="ISO Code" media="html"
								sortable="true"></display:column>
							<display:column property="symbol" title="Symbol" media="html"
								sortable="true"></display:column>


							<display:column title="Edit">
								<a
									href="currencyEdit.mnt?currencyEdit=<c:out value="${currencyRow.currencyId}"/>"
									style="color: red"><img src="images/Edit.jpg" title="Edit"
									width="20px" height="20px" /> </a>
							</display:column>

							<display:column title="Delete">
								<a
									href="currencyDelete.mnt?currencyDelete=<c:out value="${currencyRow.currencyId}"/>"
									style="color: red"><img src="images/Delete.jpg"
									title="Delete" width="20px" height="20px" /></a>
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
									<c:forEach var="currencyDuplicateAddValue"
										items="${currencyDuplicateAdd}">
										<div class="alert-warning" id="successmessage">
											<strong></strong>
											<c:out value="${currencyDuplicateAddValue}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td>Currency<label style="color: red">*</label></td>
								<td><form:input path="currency" id="currency"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>ISO Code<label style="color: red">*</label></td>
								<td><form:input path="isoCode" id="isoCode" class="textbox" />
								</td>
							</tr>
							<tr>
								<td>Symbol<label style="color: red">*</label></td>
								<td><form:input path="symbol" id="symbol" class="textbox" />
								</td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid"/><input
										type="reset" class="btn btn-primary"/></td>
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
									<td colspan="2" height="50px;"><form:hidden
											path="currencyAddDuplicateUpdate"
											id="currencyAddDuplicateUpdate" /> <c:forEach
											var="currencyDuplicateUpdateValue"
											items="${currencyDuplicateUpdate}">
											<div class="alert-warning" id="successmessage">
												<strong></strong>
												<c:out value="${currencyDuplicateUpdateValue}">
												</c:out>
											</div>
										</c:forEach></td>
								</tr>
								<%--  <tr><td>Bom Id</td><td><form:input path="bomCategoryIdEdit" id="bomCategoryId"  class="textbox" /> </td> </tr> --%>
								<%-- <tr><td>Bom Category</td><td><form:input path="bomCategoryEdit" id="bomCategory"  class="textbox" /> </td> </tr> --%>

								<tr>
									<td>Currency<label style="color: red">*</label></td>
									<td><form:input path="currencyEdit" id="currency"
											class="textbox" /> <form:hidden path="currencyEditUpdate"
											id="currencyUpdate" class="textbox" /></td>
								</tr>
								<tr>
									<td>ISO Code<label style="color: red">*</label></td>
									<td><form:input path="isoCodeEdit" id="isoCode"
											class="textbox" /> <form:hidden path="isoCodeEditUpdate"
											id="isoCodeUpdate" class="textbox" /></td>
								</tr>
								<tr>
									<td>Symbol<label style="color: red">*</label></td>
									<td><form:input path="symbolEdit" id="symbol"
											class="textbox" /> <form:hidden path="symbolEditUpdate"
											id="symbolUpdate" class="textbox" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><input type="submit"
										value="Update" class="btn btn-primary" id="upbtnId"/> </td>
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




