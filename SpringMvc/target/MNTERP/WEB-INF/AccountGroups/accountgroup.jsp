<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 
 @author Srinivas
 @version 1.0    -->
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
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
		$('#sumbnid,#updateid').click(function(e) {
			
			var aid = document.getElementById("accountgrouphide").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("accountgrouphide").value == 1) {
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
																	accountgroup : {
																		required : true },
																	
																},
																messages : {
																	accountgroup : "<font style='color: red;'><b>Account Group is Required</b></font>"
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
																	accountgroupedit : {
																		required : true
																	},

																},
																messages : {
																	accountgroupedit : "<font style='color: red;'><b>Account Group  is Required</b></font>"
																},
															});

										}); 

					});
</script>



</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Account Group</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				 <c:forEach var="editvalues" items="${editvalues}"> 
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				 </c:forEach> 
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>



			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchGroups.mnt" method="GET"
						commandName="accountGroup" >
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="accountsuccess"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
<tr>
								<td colspan="2"><c:forEach var="AccountGroupUpdate"
										items="${AccountGroupUpdate}">
										<div class="alert-success" id="savemessage">
											<strong>Success!</strong>
											<c:out value="${AccountGroupUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<%-- <tr>
								<td>Account Group</td>
								<td><form:select path="accountgroupid" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${accountsearch}" />
								</form:select></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary"/></td>
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
					</form:form>

					<c:forEach var="accountGroupBeans" items="${accountGroupBeans}">
						<c:set var="ag" value="${accountGroupBeans}"></c:set>
					</c:forEach>
					<c:if test="${ag!=null}">
						<display:table id="accountGroupid" name="accountGroupBeans"
							requestURI="searchGroups.mnt" pagesize="5" class="table">
							<display:column property="accountgroupid" title="AccountGroupID"
								media="none" sortable="true"></display:column>
							<display:column property="accountgroup" title="Account Group"
								media="html" sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<a
									href="accountGroupsedit.mnt?accountgroupedit=<c:out value="${accountGroupid.accountgroupid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column title="Delete">
								<a
									href="accountGroupDelete.mnt?accountGroupDelete=<c:out value="${accountGroupid.accountgroupid}"/>"
									style="color: red"
									onclick="return confirm('Do u want to Delete The Record?')"><img
									src="images/Delete.jpg" width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent" >
				<div align="left" class="TabbedPanelsContent">
					
						<form:form action="accountGroup.mnt" id="addaccountform"  method="POST" 
							commandName="accountGroup" >
							<table class="tableGeneral">

						<tr>
							<td colspan="2"><c:forEach var="AGSuccessdup"
									items="${AGSuccessdup}">
									<div class="alert-warning" id="successmessage">
										
									<font color="red">	<c:out value="${AGSuccessdup}"></c:out></font>
									</div>
								</c:forEach></td>
						</tr>
							<form:hidden path="accountgrouphide" />
							<tr>
								<td><spring:message code="label.accountgroup" /><span
									class="required">*</span> <form:input path="accountgroup" id="accountgroups"
										class="textbox"  /></td>
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
					<c:forEach var="AccountEditValues" items="${editvalues }">
						<form:form action="accountGroupUpdate.mnt" method="POST" 
							commandName="accountGroup" id="editaccountForm">
							<table class="tableGeneral">
							
							<tr><td colspan="2"><c:forEach var="AGSuccessdupedit"
									items="${AGSuccessdupedit}">
									<div class="alert-warning" id="successmessage">
										
									<font color="red">	<c:out value="${AGSuccessdupedit}"></c:out></font>
									</div>
								</c:forEach></td></tr>
							
                              <form:hidden path="accountgrouphideedit" />
								<form:hidden path="accountgroupidedit" />
								<tr>
									<td><spring:message code="label.accountgroup" /><span
									class="required">*</span> <form:input path="accountgroupedit"
										class="textbox"  /></td>
								</tr>

								<tr>
									<td colspan="2" ><input type="submit"
										value="Update" id="updateid" class="btn btn-primary"/></td>
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




