<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
	<script type="text/javascript" src="SpryAssets/jquery.validate.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script src="SpryAssets/validationAll.js" type="text/javascript"></script>



<script type="text/javascript">
$(document).ready(function() {
	$('#sumbnid').click(function(event) {
		//alert($('#sdType').val());
		//alert("ljls");
		$("#auditLogadd").validate({
			rules : {
				bomCategory : {required : true},
			},
			messages : {
				bomCategory : "<font style='color: red;'><b>BOM Category is Required</b></font>"
			},

		});
	});
	
	$('#subbtnId').click(function(event) {
		
		$("#auditLogedit").validate({
			rules : {
				auditLogEdit : {
					required : true
				},
			},
			messages : {
				auditLogEdit : "<font style='color: red;'><b>BOM Category is Required</b></font>"
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
	$(document)
			.ready(
					function() {
						if (document
								.getElementById("duplicateMessageAuditLog").value == 1) {
							var index = $('#tabs li a').index(
									$('a[href="#tabs-3"]').get(0));

							$('#tabs').tabs({
								active : index
							});
						}

						if (document
								.getElementById("duplicateMessageAuditLogUpdate").value == 1) {
							var index = $('#tabs li a').index(
									$('a[href="#tabs-1"]').get(0));

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
		$('#add').click(function(event) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Audit Log</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="bomCategoryValues" items="${auditLogDetailsValues1}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Audit Log Details</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
			<!-- <li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>  -->
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="auditLogSearch.mnt" method="get"
						commandName="auditLogForm">
						 <table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="auditLogUpadted"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong></strong>
											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach><c:forEach var="auditLogUpadted"
										items="${auditLogUpadte}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${auditLogUpadte}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							
							
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

					<c:forEach var="bomSearch" items="${auditLogSearch}">
						<c:set var="g" value="${auditLogSearch}"></c:set>
					</c:forEach>
					<c:if test="${g!=null}">
					
			<script>
			
		
			//$( "#dialog-form-CustAccountEdit" ).dialog({ autoOpen: false });
			function ss(id){
			//alert("sss"+id);
			$.ajax({
			type : "POST",
			url : "auditLogDetailEdit.mnt",
			data : "auditLogDetailsEdit=" + id,
			success : function(response) {
				//alert(response);
			$('#extender').empty();	
				var raw=JSON.parse(response);
				$.each(raw, function(idx, item) {
			    $('#extender').show();	 
				forAddRow(item.count);
				$("#auditLogDetail_Id"+item.count).val(item.auditLogDetail_Id);
				$("#auditLog_Id"+item.count).val(item.auditLog_Id);
				$("#oldValue"+item.count).val(item.oldValue);
				$("#newValue"+item.count).val(item.newValue);
				//$("#count"+item.count).val(item.materialId);
				});
				},
			error : function(e) {
				alert('Error: ' + e);
			}

		});
		
		$("#dialog-form-CustAccountEdit").dialog({
		       	        width:'auto'
		});
			//alert("opend");
			}		
			
		
			</script> 
						<display:table id="auditLogRow" name="auditLogSearch"
							requestURI="auditLogSearch.mnt" pagesize="5" class="table">

							<display:column property="userName" title="User Name"
								media="html" sortable="true"></display:column>
								
														
								<display:column property="operation" title="Operation"
								media="html" sortable="true"></display:column>
								
								<display:column property="objectChanged" title="Object Changed"
								media="html" sortable="true"></display:column>
								
								<display:column property="objectType" title="Object Type"
								media="html" sortable="true"></display:column>
								
								<display:column property="status" title="Status"
								media="html" sortable="true"></display:column>
								
								<display:column property="timeStamp" title="Date"
								media="html" sortable="true"></display:column>
							
							
							<display:column title="Check" style="color:white">
							<c:set var="g1" value="${auditLogRow.operation}"></c:set>
							<c:if test="${g1=='UPDATE'}">
							
							<%-- 	<a
									href="auditLogDetailEdit.mnt?auditLogDetailsEdit=<c:out value="${auditLogRow.auditLog_Id}"/>"
									style="color: red" ><img src="images/Edit.jpg" title="Check"
									width="20px" height="20px" onclick="ss()" /> </a> --%>
								 	<img src="images/Edit.jpg" title="Check"
									width="20px" height="20px" onclick="ss(${auditLogRow.auditLog_Id})" /> 
							
							</c:if>
							</display:column>

							<display:column title="Delete">
								<a
									href="auditLogDelete.mnt?auditLogDelete=<c:out value="${auditLogRow.auditLog_Id}"/>"
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
			<%-- <div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					
						<form:form action="auditLogAdd.mnt" method="POST"
							commandName="auditLogForm" id="auditLogadd">
							 <table class="tableGeneral">
							<tr>
								<td colspan="2" height="50px;"><form:hidden	path="duplicateMessageAuditLog"
										id="duplicateMessageAuditLog" />
									<c:forEach var="auditLogDuplicateAddValue"
										items="${auditLogDuplicateAdd}">
										<div class="alert-warning" id="successmessage">
											<strong></strong>
											<c:out value="${auditLogDuplicateAdd}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td>User Name<label style="color: red">*</label></td>
								<td>
										
										<form:select path="userId" id="userId"
										class="select" >
										<form:option value="SELECT">SELECT</form:option>
										<form:options items="${usersId}"/>
										</form:select>
										
										
										</td>
							</tr>
							<tr>
								<td>Operation<label style="color: red">*</label></td>
								<td><form:input path="operation" id="operation"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Object Changed<label style="color: red">*</label></td>
								<td><form:select path="objectChanged" id="objectChanged"
										class="select" >
										<form:option value="SELECT">SELECT</form:option>
										<form:option value="Table">Table</form:option>
										<form:option value="Row">Row</form:option>
										</form:select></td>
							</tr>
							<tr>
								<td>Object Type<label style="color: red">*</label></td>
								<td><form:select path="objectType" id="objectType"
										class="select" >
										<form:option value="SELECT">SELECT</form:option>
										<form:option value="Table">Table</form:option>
										<form:option value="Row">Row</form:option>
										</form:select></td>
							</tr>
							<tr>
								<td>Status<label style="color: red">*</label></td>
								<td><form:select path="status" id="status"
										class="select" >
										<form:option value="select">SELECT</form:option>
										<form:option value="0">success</form:option>
										<form:option value="1">denied</form:option>
										</form:select></td>
							</tr>
							<tr>
								<td>Date<label style="color: red">*</label></td>
								<td><form:input path="timeStamp" id="timeStamp"
										class="textbox" value="1989-05-23"/></td>
							</tr>
							

							<tr>
								<td colspan="2"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid"/><input
										type="reset" class="btn btn-primary"/></td>
							</tr>
							</table> 
						</form:form>
				</div>
			</div> --%>
			<div id="tabs-1" class="TabbedPanelsContent">
			
			
				<div align="left" class="TabbedPanelsContent" id="dialog-form-CustAccountEdit" style="display: none">
				<table id="CustAccountEdit" class="table">
											<thead>
												<tr>
													<th>Audit Log Detail No</th>
													<th>Audit Log</th>
													<th>Old Value</th>
													<th>New Value</th>
												
												</tr>
											</thead>
											<tbody>
											
											
											
											</tbody>
											
										</table>
										
										 <script type="text/javascript">
														function forAddRow(id)
														{
														var options='<table class="table"><tr id='+id+'>'
																
																 +'<td><input type="text" name="auditLogDetail_Id" id="auditLogDetail_Id'+id+'"  class="textbox" readonly/></td>'
																 +'<td><input name="auditLog_Id" id="auditLog_Id'+id+'"  class="textbox" readonly /></td>'
																 +'<td><input name="oldValue" id="oldValue'+id+'" class="textbox" readonly /></td>'
																 +'<td><input name="newValue" id="newValue'+id+'" class="textbox"  /></td>'
																 $("#extender").append(options);
															
														}
															
															</script>
										<!-- </div> -->
								
									<div id="extender"></div>

												<c:forEach var="bomSearch1" items="${auditLogDetailsValues}">
						<c:set var="g2" value="${bomSearch1}"></c:set>
					</c:forEach>
					<c:if test="${g2!=null}">
							
							
						<display:table id="auditLogDetailsValues" name="auditLogDetailsValues"
							 pagesize="5" class="table" > 

							<display:column property="auditLogDetail_Id" title="Audit Log Detail No"
								media="html" sortable="true"></display:column>
								
								<display:column property="auditLog_Id" title="Audit Log"
								media="html" sortable="true"></display:column>
								
								<display:column property="oldValue" title="Old Value"
								media="html" sortable="true"></display:column>
								
								<display:column property="newValue" title="New Value"
								media="html" sortable="true"></display:column>
								
								
							<display:setProperty name="paging.banner.group_size" value="3" />

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
							
						</display:table>
					</c:if> 
							
							
							
							
							
							
							
							
							
							
							
							
					
				
				</div>
			</div>
</div>

		</div>
</body>
</html>
