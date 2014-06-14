<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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

 <script type="text/javascript">
	$(document).ready(function() {
		$('#'+"sumbtnid").click(function(event) {
			
			$("#addShiftForm").validate({
				
				rules : {
					shiftcode : {required : true},
					shift : {required : true},
					starttime : {required : true},
					endtime : {required : true},
				},
				messages : {
					shiftcode : "<font style='color: red;'><b>Shift Code is Required</b></font>",
					shift : "<font style='color: red;'><b>Shift is Required</b></font>",
					starttime : "<font style='color: red;'><b>Start Time is Required</b></font>",
					endtime : "<font style='color: red;'><b>End Time is Required</b></font>"
				},

			});
		});
		
		$('#updateId').click(function(event) {
			
			$("#upShiftForm").validate({
				rules : {
					shiftcodeedit : {required : true},
					shiftedit : {required : true},
					starttimeedit : {required : true},
					endtimeedit : {required : true},
				},
				messages : {
					shiftcodeedit : "<font style='color: red;'><b>Shift Code is Required</b></font>",
					shiftedit : "<font style='color: red;'><b>Shift is Required</b></font>",
					starttimeedit : "<font style='color: red;'><b>Start Time is Required</b></font>",
					endtimeedit : "<font style='color: red;'><b>End Time is Required</b></font>"
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

<script type="text/javascript">
	function timedifference(){

			var start = $("#starttime").val();
			//alert(start);
			
			var end = $("#endtime").val();
			//alert(end);
			sum = parseFloat(end) - parseFloat(start);
			
			$("#workhrs").val(sum);

		}
</script>
<script type="text/javascript">
	function timediff(){

			var start = $("#starttimeedit").val();
			//alert(start);
			var end = $("#endtimeedit").val();
			//alert(end);
			sum = parseFloat(end) - parseFloat(start);
			;
			$("#workhrsedit").val(sum);

	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#subid').click(function(e) {
		
			var aid = document.getElementById("shifthide").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
	
		if (document.getElementById("shifthide").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
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
		<div class="PageTitle">Shift Details</div>
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
					<form:form action="searchShift.mnt" method="GET"
						commandName="Shift">
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
								<td colspan="2"><c:forEach var="ShiftUpdate"
										items="${ShiftUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${ShiftUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
							<td>Shift Code</td>
								<td><form:select path="shiftId" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${shiftSearch}" />
								</form:select></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary"/></td>
							</tr>
 --%>
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

					<c:forEach var="shiftBeans" items="${shiftBeans}">
						<c:set var="sf" value="${shiftBeans}"></c:set>
					</c:forEach>
					<c:if test="${sf!=null}">
						<display:table id="shiftiid" name="shiftBeans"
							requestURI="searchShift.mnt" pagesize="5" class="table">
							<display:column property="shiftId" title="ShiftID" media="none"
								sortable="true"></display:column>
							<display:column property="shiftcode" title="ShiftCode"
								media="html" sortable="true"></display:column>
							<display:column property="shift" title="Shift" media="html"
								sortable="true"></display:column>
							<display:column property="starttime" title="StartTime"
								media="html" sortable="true"></display:column>
							<display:column property="endtime" title="EndTime" media="html"
								sortable="true"></display:column>
							<display:column property="workhrs" title="WorkHrs" media="html"
								sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<a
									href="shiftEdit.mnt?shiftedit=<c:out value="${shiftiid.shiftId}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column title="Delete">
								<a
									href="shiftDelete.mnt?shiftdelete=<c:out value="${shiftiid.shiftId}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
				<form:form action="saveShift.mnt" method="POST" id="addShiftForm"
							commandName="Shift">
					<table class="tableGeneral">

                          <tr>
								<td colspan="2"><c:forEach var="shiftsuccessdup"
										items="${shiftsuccessdup}">
										<div class="alert-warning" id="successmessage">
											
										<font color="red">	<c:out value="${shiftsuccessdup}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
						
							<form:hidden path="shifthide" id="shifthide"/>
							<tr>
								<td>Shift Code<span class="required">*</span></td>
								<td><form:input path="shiftcode" id="shiftcode"
										name="shiftcode" class="textbox" /></td>
							</tr>
							<tr>
								<td>Shift<span class="required">*</span></td>
								<td><form:input path="shift" id="shift" name="shift"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Start Time<span class="required">*</span></td>
								<td><form:input path="starttime" id="starttime" 
										name="starttime" onkeyup="timedifference()" class="textbox" /></td>
							</tr>
							<tr>
								<td>End Time<span class="required">*</span></td>
								<td><form:input path="endtime" id="endtime" name="endtime" onkeyup="timedifference()"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Work Hours<span class="required">*</span></td>
								<td><form:input path="workhrs" id="workhrs" name="workhrs"
										class="textbox" readonly="true" /></td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit" value="Save"
									id="sumbtnid" class="btn btn-primary"/><input type="reset"
										class="btn btn-primary"/></td>
							</tr>
							</table>
						</form:form>
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="ShiftEditValues" items="${editvalues }">
						<form:form action="shiftUpdate.mnt" method="POST"
							commandName="Shift" id="upShiftForm">
							<table class="tableGeneral">
                                  <form:hidden path="shiftdupedit" />
								<form:hidden path="shiftIdedit" />
								<tr>
									<td>Shift Code<span class="required">*</span></td>
									<td><form:input path="shiftcodeedit" id="shiftcode"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Shift<span class="required">*</span></td>
									<td><form:input path="shiftedit" id="shift"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Start Time<span class="required">*</span></td>
									<td><form:input path="starttimeedit" id="starttimeedit" onkeyup="timediff()"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>End Time<span class="required">*</span></td>
									<td><form:input path="endtimeedit" id="endtimeedit" onkeyup="timediff()"
											class="textbox" /></td>
								</tr>
								<tr>
									<td>Work Hours<span class="required">*</span></td>
									<td><form:input path="workhrsedit" id="workhrsedit"
											class="textbox" readonly="true" /></td>
								</tr>

								<tr>
									<td colspan="2"><input type="submit"
										value="Update" class="btn btn-primary" id="updateId"/></td>
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




