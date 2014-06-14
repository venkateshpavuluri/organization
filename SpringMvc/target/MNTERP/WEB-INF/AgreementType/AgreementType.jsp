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
<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<script type="text/javascript">
$(document).ready(function() {
	$('#sumbnid').click(function(event) {
		//alert($('#sdType').val());
		//alert("ljls");
		$("#agreementType").validate({
			rules : {
				agreementType : {required : true},
			},
			messages : {
				agreementType : "<font style='color: red;'><b>Agreement Type is Required</b></font>"
			},

		});
	});
	
	$('#updateAgree').click(function(event) {
		
		$("#agreementUpdate").validate({
			rules : {
				editAgreementType : {
					required : true
				},
			},
			messages : {
				editAgreementType : "<font style='color: red;'><b>Agreement Type is Required</b></font>"
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
		$('#search').click(function(e) {
			$('#edit').hide();

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#add').click(function(e) {
			$('#edit').hide();

		});
	});
</script>

<script type="text/javascript" language="javascript">
	jQuery(document).ready(function() {
		jQuery("#mainForm").validationEngine();
	});
</script>


</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Agreement Type</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="agvalues" items="${agvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="AgreementTypeSearch.mnt" method="get"
						commandName="AgreementTypeadd" name="agreementform">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="aupdate"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success! </strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="aupdate" items="${aupdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success! </strong>
											<c:out value="${aupdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="aupdated"
										items="${atupdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success! </strong>
											<c:out value="${aupdated}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="adeleted"
										items="${adelete}">
										<div class="alert-success" id="successmessage">
											<strong>Success! </strong>
											<c:out value="${adeleted}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="adup"
										items="${param.list1}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning! </strong>
											<c:out value="${param.warning}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="aedup"
										items="${param.list2}">
										<div class="alert-warning" id="warningmessage">
											<strong>Warning! </strong>
											<c:out value="${param.warning}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td>Agreement Type Id:</td>
								<td><form:input path="agreementType_Id" class="textbox"/></td>
								<td><input type="submit" value="Search" id="searbut"
									class="btn btn-primary"/></td>
							</tr> --%>
							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> 
									<form:select path="operations" cssClass="select">										
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
					</form:form>

					<display:table id="agreementType" name="agreementType"
						requestURI="AgreementTypeSearch.mnt" pagesize="5" class="table">


						<%-- <display:column property="agreementType_Id" title="agreementType_Id" media="html" sortable="true" ></display:column> --%>
						<display:column property="agreementType" title="Agreement Type"
							media="html" sortable="true" />



						<display:column title="Edit" style="color:white">
							<a
								href="AgreementTypeEditHome.mnt?agreementTypeEdit=<c:out 

								value="${agreementType.agreementType_Id}"/>"
								style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a>
						</display:column>

						<display:column title="Delete">
							<a
								href="AgreementTypeDelete.mnt?agreementDelete=<c:out value="${agreementType.agreementType_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:setProperty name="paging.banner.placement" value="bottom" />

						<display:setProperty name="paging.banner.group_size" value="3" />

						<display:setProperty name="paging.banner.some_items_found"
							value="<span class='pagebanner'>{0} {1},listing {2} to {3}. 

						</span>" />
					</display:table>
					<%-- </c:if> --%>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="AgreementTypeadd.mnt" method="POST"
						commandName="AgreementTypeadd" id="agreementType">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2" height="20px"><c:forEach
										var="addAgreementTypeDuplicate"
										items="${addAgreementTypeDuplicate}">
										<div class="alert-warning" id="savemessage">
											<font color="red"><c:out
													value="${addAgreementTypeDuplicate}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td>Agreement Type <font color="red">*</font></td>
								<td><form:input path="agreementType" id="agreementType"
										class="textbox" /></td>
								<td><font color="red"></font></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
							</table>
							</form:form>
						
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="agvalues" items="${agvalues }">

						<form:form action="AgreementTypeEdit.mnt" method="POST"
							commandName="AgreementTypeadd" id="agreementUpdate">
							<table class="tableGeneral">

								<%-- <form:hidden path="eid" /> --%>
								<tr>
									<td colspan="2" height="20px"><c:forEach
											var="addAgreementTypeDuplicate"
											items="${addAgreementTypeDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out
														value="${addAgreementTypeDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
								<tr>
									<td></td>
									<td><form:hidden path="editAgreementType_Id"
											id="editAgreementType_Id" /></td>
								</tr>

								<tr>
									<td>Agreement Type</td>
									<td><form:input path="editAgreementType"
											id="editAgreementType" class="textbox"/></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="Update"
										class="btn btn-primary" id="updateAgree"/></td>
								</tr>
							</table>
						</form:form>
					</c:forEach>
				</div>
			</div>


		</div>
</body>
</html>




