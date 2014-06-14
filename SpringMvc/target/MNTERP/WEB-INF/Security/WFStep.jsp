
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<link rel="stylesheet" href="/resources/demos/style.css" />

		<link href="accordionmenu.css" rel="stylesheet" type="text/css"/>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
		<link href="style.css" rel="stylesheet" type="text/css" />
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

		<script>
$(document).ready(function(){
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
.TabbedPanelsContent{

border: 5px;
font-style: Bold;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('#'+"sumbnid").click(function(event) {
			//alert($('#privilege').val());
			$("#addwfstepForm").validate({
				
				rules : {
					wfstepStageGUID : {required : true},
					wfstepStep : {required : true,number : true},
					wfstepName : {required : true},
					wfstepType : {required : true},
					wfstepStatus : {required : true,number : true},
					wfstepAssignedTo: {required : true},
					
				},
				messages : {
					wfstepStageGUID : "<font style='color: red;'><b> Stage Name is Required</b></font>",
					wfstepStep : "<font style='color: red;'><b> Step is Required and must be Integer</b></font>",
					wfstepName : "<font style='color: red;'><b> Name is Required</b></font>",
					wfstepType : "<font style='color: red;'><b> Type is Required</b></font>",
					wfstepStatus : "<font style='color: red;'><b> Status is Required</b></font>",
					wfstepAssignedTo : "<font style='color: red;'><b> Assigned To is Required</b></font>",
				},

			});
		});
		
		$('#updbut').click(function(event) {
			
			$("#updatewfstepForm").validate({
				rules : {
					wfstepStageGUIDEdit : {required : true},
					wfstepStepEdit : {required : true,number : true},
					wfstepNameEdit : {required : true},
					wfstepTypeEdit : {required : true},
					wfstepStatusEdit : {required : true,number : true},
					wfstepAssignedToEdit: {required : true},
				},
				messages : {
					wfstepStageGUIDEdit : "<font style='color: red;'><b> Stage Name is Required</b></font>",
					wfstepStepEdit : "<font style='color: red;'><b> Step is Required and must be Integer</b></font>",
					wfstepNameEdit : "<font style='color: red;'><b> Name is Required</b></font>",
					wfstepTypeEdit : "<font style='color: red;'><b> Type is Required</b></font>",
					wfstepStatusEdit : "<font style='color: red;'><b> Status is Required</b></font>",
					wfstepAssignedToEdit : "<font style='color: red;'><b> Assigned To is Required</b></font>",
				},
			});
		});
		
	});
</script>
 
 
<script type="text/javascript">
$(document).ready(function() {
if(document.getElementById("aid").value==1){
  var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));
  
$('#tabs').tabs({active: index});
}

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
	 <div class="PageTitle">My Preferences</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
			   <c:forEach var="wfstepValues" items="${wfstepValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message code="label.edit"></s:message> </a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			
     <!---================================ Search tab =======================================-->
	<div id="tabs-2" class="TabbedPanelsContent">
	 <div align="left">
   <form:form action="wfstepSearch.mnt" method="get" commandName="wfstepAdd" >
	<table class="tableGeneral">
<tr><td colspan="2"><c:forEach var="wfstepUpadted" items="${wfstepSave}"><div class="alert-success" id="savemessage"><c:out value="${wfstepSave}"></c:out></div></c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="wfstepUpadted" items="${wfstepUpadteSuccess}"><div class="alert-success" id="successmessage"><c:out value="${wfstepUpadteSuccess}"></c:out></div> </c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="wfstepUpadted" items="${wfstepUpadteFail}"><div class="alert-warning" id="successmessage"><c:out value="${wfstepUpadteFail}"></c:out></div> </c:forEach> </td></tr>
	<tr><td>Name</td><td><form:select path="wfstepNameSearch" class="select">
										<form:option value="all">--Select--</form:option>
										<form:option value="all">All</form:option>
										<form:options items="${WFStepSearchNames}" /></form:select></td><td><input type="submit" value="Search" class="btn btn-primary"/></td></tr> 
	 
	</table></form:form>
	
	<c:forEach var="wfstepSearch" items="${wfstepSearch}">
	<c:set var="g" value="${wfstepSearch}"></c:set></c:forEach>
	<c:if test="${g!=null}">
	<display:table  id="wfstepRow" name="wfstepSearch"  requestURI="wfstepSearch.mnt" pagesize="5" class="table">

 <display:column property="wfstageName"  title="Stage Name" media="html" sortable="true" />
 <display:column property="wfstepStep" title="Step" media="html"  sortable="true" />
 <display:column property="wfstepName" title="Name"  media="html" sortable="true"  />
 <display:column property="wfstepType"  title="Type" media="html" sortable="true" />
 <display:column property="wfstepStatus" title="Status" media="html"  sortable="true" />
 <display:column property="role" title="Assigned To"  media="html" sortable="true"  />
<display:column title="Edit" style="color:white"><a href="wfstepEditHome.mnt?wfstepDetEdit=<c:out value="${wfstepRow.wfstepid}"/>" style="color: red"><img src="images/Edit.jpg" width="20px" height="20px" /> </a></display:column>

  <display:column title="Delete"><a href="wfstepDelete.mnt?wfstepidDelete=<c:out value="${wfstepRow.wfstepid}"/>" style="color: red" onclick="return confirm('Do u want to delete the Record?')"><img src="images/Delete.jpg" width="20px" height="20px"  /></a></display:column>
<display:setProperty name="paging.banner.placement" value="bottom" />
<display:setProperty name="paging.banner.group_size" value="3" />
<display:setProperty name="paging.banner.some_items_found" value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
</display:table></c:if> 
              
	 </div>
     </div>
     
     
     
     <!---================================ Add tab =======================================-->
	<div id="tabs-3" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	
	 
				<form:form  action="wfstepAdd.mnt"  method="GET" commandName="wfstepAdd" id="addwfstepForm" >
			  <table class="tableGeneral">
				<tr><td colspan="2"><c:forEach var="wfstepUpadted" items="${wfstepSaveFail}"><div class="alert-warning" id="savemessage"><c:out value="${wfstepSaveFail}"></c:out></div></c:forEach> </td></tr>
							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${WFStepDuplicate }">
										<div class="alert-warning">
											<font color="red"> <c:out value="${a}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="wfstepid" />
				<tr><td>Stage Name</td><td><form:select path="wfstepStageGUID" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${StageSearchIds}" /></form:select></td> </tr>
			<tr><td>Step</td><td><form:input path="wfstepStep" id="wfstepStep" class="textbox" /></td> </tr>
			<tr><td>Name</td><td><form:input path="wfstepName" id="wfstepName" class="textbox" /></td> </tr>
			<tr><td>Type</td><td><form:input path="wfstepType" id="wfstepType" class="textbox" /></td> </tr>
			<tr><td>Status</td><td> <form:select path="wfstepStatus" id="wfstepStatus" class="select">
			
		 <form:option value="" >--Select--</form:option> 
	<form:option value="1" >Active</form:option>
	<form:option value="2" >In Active</form:option>
		
			</form:select></td> </tr> 
<form:hidden path="wfstepCreatedBy" />
			<form:hidden path="wfstepCreatedDate" /><form:hidden path="aid" />
				<tr><td>Assigned To</td><td><form:select path="wfstepAssignedTo" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${RolesSearchIds}" /></form:select></td> </tr>
			
			
					<tr><td colspan="2"><input  type="submit" value="Save" class="btn btn-primary" id="sumbnid"/><input type="reset" class="btn btn-primary"/> </td> </tr>
				</table>
					</form:form>	
					
			</div>
			</div>
			 <!---================================ Edit tab =======================================-->
<div id="tabs-1" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	 
	 <c:forEach var="wfstepEditValues" items="${wfstepValues }">
			 <form:form action="wfstepUpdate.mnt" method="POST" commandName="wfstepAdd" id="updatewfstepForm">
			<table class="tableGeneral">
			<tr><td colspan="2"><c:forEach var="wfstepUpadted" items="${wfstepUpadteFail}"><div class="alert-danger" id="successmessage"><c:out value="${wfstepUpadteFail}"></c:out></div> </c:forEach> </td></tr>
			<tr><td colspan="2"><c:forEach var="duplicate"items="${wfstepEditDuplicate }"><div class="alert-warning"><font color="red"> <c:out value="${duplicate}"></c:out></font></div></c:forEach></td></tr>
		<tr><td colspan="2"><c:forEach var="wfstepUpadted" items="${wfstepUpadte}"><div class="alert-warning" id="successmessage"><c:out value="${wfstepUpadted}"></c:out></div> </c:forEach> </td></tr> 
			<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${wfstepEditDuplicate }">
											<div class="alert-warning">
												<font color="red"> <c:out value="${duplicate}"></c:out></font>
											</div></c:forEach></td></tr>
		<tr><td colspan="2"><c:forEach var="wfstepUpadted" items="${wfstepUpadte}"><div class="alert-success" id="successmessage"><strong>Success!</strong><c:out value="${wfstepUpadted}"></c:out></div> </c:forEach> </td></tr> 
				<form:hidden path="wfstepidEdit" />
				<tr><td>Stage Name</td><td><form:select path="wfstepStageGUIDEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${StageSearchIds}" /></form:select></td> </tr>
			<tr><td>Step</td><td><form:input path="wfstepStepEdit" id="wfstepStep" class="textbox" /></td> </tr>
			<tr><td>Name</td><td><form:input path="wfstepNameEdit" id="wfstepName" class="textbox" /></td> </tr>
			<tr><td>Type</td><td><form:input path="wfstepTypeEdit" id="wfstepType" class="textbox" /></td> </tr>
			<tr><td>Status</td><td> <form:select path="wfstepStatusEdit" id="wfstepStatus" class="select">
			<form:option value="" >--Select--</form:option> 
	<form:option value="1" >Active</form:option>
	<form:option value="2" >In Active</form:option>
		
			</form:select></td> </tr>	
			
				<tr><td>Assigned To</td><td><form:select path="wfstepAssignedToEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${RolesSearchIds}" /></form:select></td> </tr>
			
					<tr><td colspan="2" ><input type="submit" value="Update" class="btn btn-primary" id="updbut"/> </td> </tr>
					<form:hidden path="wfstepCreatedByEdit" />
			<form:hidden path="wfstepCreatedDateEdit" />
			<form:hidden path="aid" />
					</table></form:form></c:forEach>
	</div></div>

		</div>
	</div>

</body>
</html>




