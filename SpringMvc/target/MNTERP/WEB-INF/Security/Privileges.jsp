
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
			$("#addPrivilegeForm").validate({
				
				rules : {
					privilege : {required : true},
				},
				messages : {
					privilege : "<font style='color: red;'><b> Privilege is Required</b></font>"
				},

			});
		});
		
		$('#updbut').click(function(event) {
			
			$("#updatePrivilegeForm").validate({
				rules : {
					privilegeEdit : {required : true},
				},
				messages : {
					privilegeEdit : "<font style='color: red;'><b> Privilege is Required</b></font>"
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
			   <c:forEach var="privilegeValues" items="${privilegeValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message code="label.edit"></s:message> </a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			
     <!---================================ Search tab =======================================-->
	<div id="tabs-2" class="TabbedPanelsContent">
	 <div align="left">
	 
      <form:form action="privilegeSearch.mnt" method="get" commandName="privilegeAdd" >
	<table class="tableGeneral">
<tr><td colspan="2"><c:forEach var="privilegeUpadted" items="${privilegeSave}"><div class="alert-success" id="savemessage"><c:out value="${privilegeSave}"></c:out></div></c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="privilegeUpadted" items="${privilegeUpadteSuccess}"><div class="alert-success" id="successmessage"><c:out value="${privilegeUpadteSuccess}"></c:out></div> </c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="privilegeUpadted" items="${privilegeUpadteFail}"><div class="alert-warning" id="successmessage"><c:out value="${privilegeUpadteFail}"></c:out></div> </c:forEach> </td></tr> 
	<tr><td>Privilege</td><td><form:select path="privilegeSearch" class="select">
										<form:option value="all">--Select--</form:option>
										<form:option value="all" class="select">All</form:option>
										<form:options items="${PrivilegeSearchNames}" /></form:select></td><td><input type="submit" value="Search" class="btn btn-primary"/></td></tr> 
	 
	</table></form:form>
	
	<c:forEach var="privilegeSearch" items="${privilegeSearch}">
	<c:set var="g" value="${privilegeSearch}"></c:set></c:forEach>
	<c:if test="${g!=null}">
	<display:table  id="privilegeRow" name="privilegeSearch"  requestURI="privilegeSearch.mnt" pagesize="5" class="table">

 <display:column property="privilege"  title="Privilege Name" media="html" sortable="true" ></display:column>

<display:column title="Edit" style="color:white"><a href="privilegeEditHome.mnt?privilegeDetEdit=<c:out value="${privilegeRow.privilegeid}"/>" style="color: red"><img src="images/Edit.jpg" width="20px" height="20px" /> </a></display:column>

  <display:column title="Delete"><a href="privilegeDelete.mnt?privilegeidDelete=<c:out value="${privilegeRow.privilegeid}"/>" style="color: red" onclick="return confirm('Do u want to delete the Record?')"><img src="images/Delete.jpg" width="20px" height="20px"  /></a></display:column>
<display:setProperty name="paging.banner.placement" value="bottom" />
<display:setProperty name="paging.banner.group_size" value="3" />
<display:setProperty name="paging.banner.some_items_found" value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
</display:table></c:if> 
              
	 </div>
     </div>
     
     
     
     <!---================================ Add tab =======================================-->
	<div id="tabs-3" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	  
				<form:form  action="privilegeAdd.mnt"  method="GET" commandName="privilegeAdd" id="addPrivilegeForm">
				
						<table class="tableGeneral">
	 	
						<tr><td colspan="2"><c:forEach var="privilegeUpadted" items="${privilegeSaveFail}"><div class="alert-warning" id="savemessage"><c:out value="${privilegeSaveFail}"></c:out></div></c:forEach> </td></tr>
							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${PrivilegeDuplicate }">
										<div class="alert-warning">
											<font color="red"> <c:out value="${a}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="privilegeid" />
				
			<tr><td>privilege<span class="required">*</span></td><td><form:input path="privilege" id="privilege" class="textbox" /></td> </tr>
			<form:hidden path="aid" />
		
					<tr><td colspan="2"><input  type="submit" value="Save" class="btn btn-primary" id="sumbnid"/><input type="reset" class="btn btn-primary"/> </td> </tr>
					</table></form:form>	
					
			</div>
			</div>
			 <!---================================ Edit tab =======================================-->
<div id="tabs-1" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	 
	 <c:forEach var="privilegeEditValues" items="${privilegeValues }">
			 <form:form action="privilegeUpdate.mnt" method="POST" id="updatePrivilegeForm" commandName="privilegeAdd">
			<table class="tableGeneral">
			<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${privilegeEditDuplicate }">
											<div class="alert-warning">
												<font color="red"> <c:out value="${duplicate}"></c:out></font>
											</div></c:forEach></td></tr>
			<tr><td colspan="2"><c:forEach var="privilegeUpadted" items="${privilegeUpadteFail}"><div class="alert-danger" id="successmessage"><c:out value="${privilegeUpadteFail}"></c:out></div> </c:forEach> </td></tr>
			<tr><td colspan="2"><c:forEach var="duplicate"items="${privilegeEditDuplicate }"><div class="alert-warning"><font color="red"> <c:out value="${duplicate}"></c:out></font></div></c:forEach></td></tr>
		<tr><td colspan="2"><c:forEach var="privilegeUpadted" items="${privilegeUpadte}"><div class="alert-warning" id="successmessage"><c:out value="${privilegeUpadted}"></c:out></div> </c:forEach> </td></tr> 
			<form:hidden path="privilegeidEdit"/>
			
				<tr><td>privilege<span class="required">*</span></td><td><form:input path="privilegeEdit" id="privilegeEdit"  class="textbox" /> </td> </tr>
			
			
					<tr><td colspan="2"><input type="submit" value="Update" id="updbut" class="btn btn-primary"/> </td> </tr>
					</table></form:form></c:forEach>
	</div></div>

		</div>
	</div>

</body>
</html>




