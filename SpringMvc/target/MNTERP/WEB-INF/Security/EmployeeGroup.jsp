
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
if(document.getElementById("aid").value==1){
  var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));
  
$('#tabs').tabs({active: index});
}

});
</script>
  
<script type="text/javascript">
	$(document).ready(function() {
		$('#'+"sumbnid").click(function(event) {
			//alert($('#privilege').val());
			$("#addEmployeeGroupForm").validate({
				
				rules : {
					employeeGroup : {required : true},
					
				},
				messages : {
					employeeGroup : "<font style='color: red;'><b> EmployeeGroup is Required</b></font>"
				},

			});
		});
		
		$('#updbut').click(function(event) {
			
			$("#updateEmployeeGroupForm").validate({
				rules : {
					employeeGroupEdit : {required : true},
				},
				messages : {
					employeeGroupEdit : "<font style='color: red;'><b> EmployeeGroup is Required</b></font>"
				},

			});
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
	 <div class="PageTitle">My Preferences</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
			   <c:forEach var="employeeGroupValues" items="${employeeGroupValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message code="label.edit"></s:message> </a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			
     <!---================================ Search tab =======================================-->
	<div id="tabs-2" class="TabbedPanelsContent">
	 <div align="left">
	 
      <form:form action="employeeGroupSearch.mnt" method="get" commandName="employeeGroupAdd" >
	<table class="tableGeneral">
<tr><td colspan="2"><c:forEach var="employeeGroupUpadted" items="${employeeGroupSave}"><div class="alert-success" id="savemessage"><c:out value="${employeeGroupSave}"></c:out></div></c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="employeeGroupUpadted" items="${employeeGroupUpadteSuccess}"><div class="alert-success" id="successmessage"><c:out value="${employeeGroupUpadteSuccess}"></c:out></div> </c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="employeeGroupUpadted" items="${employeeGroupUpadteFail}"><div class="alert-warning" id="successmessage"><c:out value="${employeeGroupUpadteFail}"></c:out></div> </c:forEach> </td></tr>
	<tr><td>EmployeeGroup</td><td><form:select path="employeeGroupSearch" class="select">
										<form:option value="all">--Select--</form:option>
										<form:options items="${EmployeeGroupSearchNames}" /></form:select></td><td><input type="submit" value="Search" class="btn btn-primary"/></td></tr> 
	 
	</table></form:form>
	
	<c:forEach var="employeeGroupSearch" items="${employeeGroupSearch}">
	<c:set var="g" value="${employeeGroupSearch}"></c:set></c:forEach>
	<c:if test="${g!=null}">
	<display:table  id="employeeGroupRow" name="employeeGroupSearch"  requestURI="employeeGroupSearch.mnt" pagesize="5" class="table">

 <display:column property="employeeGroup"  title="EmployeeGroup Name" media="html" sortable="true" ></display:column>


<display:column title="Edit" style="color:white"><a href="employeeGroupEditHome.mnt?employeeGroupDetEdit=<c:out value="${employeeGroupRow.employeeGroupId}"/>" style="color: red"><img src="images/Edit.jpg" width="20px" height="20px" /> </a></display:column>

  <display:column title="Delete"><a href="employeeGroupDelete.mnt?employeeGroupIdDelete=<c:out value="${employeeGroupRow.employeeGroupId}"/>" style="color: red" onclick="return confirm('Do u want to delete the Record?')"><img src="images/Delete.jpg" width="20px" height="20px"  /></a></display:column>
<display:setProperty name="paging.banner.placement" value="bottom" />
<display:setProperty name="paging.banner.group_size" value="3" />
<display:setProperty name="paging.banner.some_items_found" value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
</display:table></c:if> 
               
	 </div>
     </div>
     
     
     
     <!---================================ Add tab =======================================-->
	<div id="tabs-3" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	  
				<form:form  action="employeeGroupAdd.mnt"  method="GET" commandName="employeeGroupAdd" id="addEmployeeGroupForm" onsubmit="return validateForm()">
				<table class="tableGeneral">
	
				<tr><td colspan="2"><c:forEach var="employeeGroupUpadted" items="${employeeGroupSaveFail}"><div class="alert-warning" id="savemessage"><c:out value="${employeeGroupSaveFail}"></c:out></div></c:forEach> </td></tr>
<tr><td colspan="2"><c:forEach var="a" items="${EmployeeGroupDuplicate }"><div class="alert-warning"><font color="red"> <c:out value="${a}"></c:out></font></div></c:forEach></td>
							</tr>
							<form:hidden path="employeeGroupId" />
				
			<tr><td>EmployeeGroup<span class="required">*</span></td><td><form:input path="employeeGroup" id="employeeGroup" class="textbox" /></td> </tr>
			
			<form:hidden path="aid" />
			
			
					<tr><td colspan="2"><input  type="submit" value="Save" class="btn btn-primary" id="sumbnid"/><input type="reset" class="btn btn-primary"/> </td> </tr>
					</table>
					</form:form>	
					
			</div>
			</div>
			 <!---================================ Edit tab =======================================-->
<div id="tabs-1" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	 
	 <c:forEach var="employeeGroupEditValues" items="${employeeGroupValues }">
			 <form:form action="employeeGroupUpdate.mnt" method="POST" commandName="employeeGroupAdd" id="updateEmployeeGroupForm">
			<table class="tableGeneral">
			<tr><td colspan="2"><c:forEach var="employeeGroupUpadted" items="${employeeGroupUpadteFail}"><div class="alert-danger" id="successmessage"><c:out value="${employeeGroupUpadteFail}"></c:out></div> </c:forEach> </td></tr>
			<tr><td colspan="2"><c:forEach var="duplicate"items="${employeeGroupEditDuplicate }"><div class="alert-warning"><font color="red"> <c:out value="${duplicate}"></c:out></font></div></c:forEach></td></tr>
		<tr><td colspan="2"><c:forEach var="employeeGroupUpadted" items="${employeeGroupUpadte}"><div class="alert-warning" id="successmessage"><c:out value="${employeeGroupUpadted}"></c:out></div> </c:forEach> </td></tr> 
			<form:hidden path="employeeGroupIdEdit"/>
			
				<tr><td>EmployeeGroup<span class="required">*</span></td><td><form:input path="employeeGroupEdit" id="employeeGroup"  class="textbox" /> </td> </tr>
			
			
			
					<tr><td colspan="2"><input type="submit" value="Update" class="btn btn-primary" id="updbut"/> </td> </tr>
					</table></form:form></c:forEach>
	</div></div> 

		</div>
	</div>

</body>
</html>




