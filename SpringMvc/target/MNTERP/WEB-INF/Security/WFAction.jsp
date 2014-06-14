
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
			$("#addWfActionForm").validate({
				
				rules : {
					wfactionStepGUID : {required : true},
					wfactionAction : {required : true,number : true},
					wfactionName : {required : true},
					wfactionType : {required : true},
					wfactionCondition : {required : true},
					wfactionDirection : {required : true,number : true},
					wfactionGotoStep : {required : true,number : true},
					wfactionEmail : {required : true, email:true},
					wfactionWorkList : {required : true},
					wfactionComments : {required : true},
					wfactionMessage : {required : true},
					wfactionMessageDetails : {required : true},
				},
				messages : {
					wfactionStepGUID : "<font style='color: red;'><b> Step Name is Required</b></font>",
					wfactionAction : "<font style='color: red;'><b> Action is Required  Must be Integer</b></font>",
					wfactionName : "<font style='color: red;'><b> Name is Required</b></font>",
					wfactionType : "<font style='color: red;'><b> Type is Required</b></font>",
					wfactionCondition : "<font style='color: red;'><b> Condition is Required</b></font>",
					wfactionDirection : "<font style='color: red;'><b>  Direction is Required and Must be Integer</b></font>",
					wfactionGotoStep : "<font style='color: red;'><b>  Goto Step is Required and Must be Integer</b></font>",
					wfactionEmail : "<font style='color: red;'><b> Email is Required</b></font>",
					wfactionWorkList : "<font style='color: red;'><b> WorkList is Required</b></font>",
					wfactionComments : "<font style='color: red;'><b>  Comments is Required</b></font>",
					wfactionMessage : "<font style='color: red;'><b>  Message is Required</b></font>",
					wfactionMessageDetails : "<font style='color: red;'><b> Message Details is Required</b></font>",
				},

			});
		});
		
		$('#updbut').click(function(event) {
			
			$("#updateWfActionForm").validate({
				rules : {
					wfactionStepGUIDEdit : {required : true},
					wfactionActionEdit : {required : true,number : true},
					wfactionNameEdit : {required : true},
					wfactionTypeEdit : {required : true},
					wfactionConditionEdit : {required : true},
					wfactionDirectionEdit : {required : true,number : true},
					wfactionGotoStepEdit : {required : true,number : true},
					wfactionEmailEdit : {required : true, email:true},
					wfactionWorkListEdit : {required : true},
					wfactionCommentsEdit : {required : true},
					wfactionMessageEdit : {required : true},
					wfactionMessageDetailsEdit : {required : true},
				},
				messages : {
					wfactionStepGUIDEdit : "<font style='color: red;'><b> Step Name is Required</b></font>",
					wfactionActionEdit : "<font style='color: red;'><b> Action is Required  Must be Integer</b></font>",
					wfactionNameEdit : "<font style='color: red;'><b> Name is Required</b></font>",
					wfactionTypeEdit : "<font style='color: red;'><b> Type is Required</b></font>",
					wfactionConditionEdit : "<font style='color: red;'><b> Condition is Required</b></font>",
					wfactionDirectionEdit : "<font style='color: red;'><b>  Direction is Required and Must be Integer</b></font>",
					wfactionGotoStepEdit : "<font style='color: red;'><b>  Goto Step is Required  and Must be Integer</b></font>",
					wfactionEmailEdit : "<font style='color: red;'><b> Email is Required</b></font>",
					wfactionWorkListEdit : "<font style='color: red;'><b> WorkList is Required</b></font>",
					wfactionCommentsEdit : "<font style='color: red;'><b>  Comments is Required</b></font>",
					wfactionMessageEdit : "<font style='color: red;'><b>  Message is Required</b></font>",
					wfactionMessageDetailsEdit : "<font style='color: red;'><b> Message Details is Required</b></font>",
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
    $('#sumbnid').click(function(e) {
    var aid=document.getElementById("aid").value=1;
  
 
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
			   <c:forEach var="wfactionValues" items="${wfactionValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message code="label.edit"></s:message> </a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			
     <!---================================ Search tab =======================================-->
	<div id="tabs-2" class="TabbedPanelsContent">
	 <div align="left">
 <form:form action="wfactionSearch.mnt" method="get" commandName="wfactionAdd" >
	<table class="tableGeneral">
<tr><td colspan="2"><c:forEach var="wfactionUpadted" items="${wfactionSave}"><div class="alert-success" id="savemessage"><c:out value="${wfactionSave}"></c:out></div></c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="wfactionUpadted" items="${wfactionUpadteSuccess}"><div class="alert-success" id="successmessage"><c:out value="${wfactionUpadteSuccess}"></c:out></div> </c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="wfactionUpadted" items="${wfactionUpadteFail}"><div class="alert-warning" id="successmessage"><c:out value="${wfactionUpadteFail}"></c:out></div> </c:forEach> </td></tr> 
	<tr><td>Name</td><td><form:select path="wfactionNameSearch" class="select">
										<form:option value="all">--Select--</form:option>
										<form:option value="all">All</form:option>
										<form:options items="${WFActionSearchNames}" /></form:select></td><td><input type="submit" value="Search" class="btn btn-primary"/></td></tr> 
	 
	</table></form:form>
	
	<c:forEach var="wfactionSearch" items="${wfactionSearch}">
	<c:set var="g" value="${wfactionSearch}"></c:set></c:forEach>
	<c:if test="${g!=null}">
	<display:table  id="wfactionRow" name="wfactionSearch"  requestURI="wfactionSearch.mnt" pagesize="5" class="table">

 <display:column property="wfstepName"  title="Step Name" media="html" sortable="true" />
 <display:column property="wfactionAction" title="Action" media="html"  sortable="true" />
 <display:column property="wfactionName" title="Name"  media="html" sortable="true"  />
 <display:column property="wfactionType"  title="Type" media="html" sortable="true" />
 <display:column property="wfactionCondition" title="Condition" media="html"  sortable="true" />
 <display:column property="wfactionDirection" title="Direcion"  media="html" sortable="true"  />
<display:column property="wfactionGotoStep" title="Goto Step"  media="html" sortable="true"  />
<display:column property="wfactionEmail" title="Email"  media="html" sortable="true"  />

<display:column property="wfactionComments" title="Comments"  media="html" sortable="true"  />
<display:column property="wfactionMessage" title="Message"  media="html" sortable="true"  />
<display:column property="wfactionMessageDetails" title="Message Details"  media="html" sortable="true"  />

<display:column title="Edit" style="color:white"><a href="wfactionEditHome.mnt?wfactionDetEdit=<c:out value="${wfactionRow.wfactionId}"/>" style="color: red"><img src="images/Edit.jpg" width="20px" height="20px" /> </a></display:column>

  <display:column title="Delete"><a href="wfactionDelete.mnt?wfactionidDelete=<c:out value="${wfactionRow.wfactionId}"/>" style="color: red" onclick="return confirm('Do u want to delete the Record?')"><img src="images/Delete.jpg" width="20px" height="20px"  /></a></display:column>
<display:setProperty name="paging.banner.placement" value="bottom" />
<display:setProperty name="paging.banner.group_size" value="3" />
<display:setProperty name="paging.banner.some_items_found" value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
</display:table></c:if> 
             
	 </div>
     </div>
     
     
     
     <!---================================ Add tab =======================================-->
	<div id="tabs-3" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	  		<form:form  action="wfactionAdd.mnt"  method="GET" commandName="wfactionAdd" id="addWfActionForm" onsubmit="return validateForm()">
		<table class="tableGeneral">
	 
				<tr><td colspan="2"><c:forEach var="wfactionUpadted" items="${wfactionSaveFail}"><div class="alert-warning" id="savemessage"><c:out value="${wfactionSaveFail}"></c:out></div></c:forEach> </td></tr>	
							<tr>
								<td colspan="2"><c:forEach var="a"
										items="${WFActionDuplicate }">
										<div class="alert-warning">
											<font color="red"> <c:out value="${a}"></c:out></font>
										</div>
									</c:forEach></td>
							</tr>
							<form:hidden path="wfactionId" />
				<tr><td>Step Name</td><td><form:select path="wfactionStepGUID" class="select">
										<form:option value="">--Select--</form:option>
									
										<form:options items="${StepSearchIds}" /></form:select></td> </tr>
			<tr><td>Action</td><td><form:input path="wfactionAction" id="wfactionAction" class="textbox" /></td> </tr>
			<tr><td>Name</td><td><form:input path="wfactionName" id="wfactionName" class="textbox" /></td> </tr>
			<tr><td>Type</td><td><form:input path="wfactionType" id="wfactionType" class="textbox" /></td> </tr>
			<tr><td>Condition</td><td><form:input path="wfactionCondition" id="wfactionCondition" class="textbox" /></td> </tr>
			<tr><td>Direction</td><td><form:input path="wfactionDirection" id="wfactionDirection" class="textbox" /></td> </tr>
			<tr><td>Goto Step</td><td><form:input path="wfactionGotoStep" id="wfactionGotoStep" class="textbox" /></td> </tr>
			<tr><td>Email</td><td><form:input path="wfactionEmail" id="wfactionEmail" class="textbox" /></td> </tr>
			
			<tr><td>Comments</td><td><form:input path="wfactionComments" id="wfactionComments" class="textbox" /></td> </tr>
			<tr><td>Message</td><td><form:input path="wfactionMessage" id="wfactionMessage" class="textbox" /></td> </tr>
			<tr><td>Message Details</td><td><form:input path="wfactionMessageDetails" id="wfactionMessageDetails" class="textbox" /></td> </tr>
			<form:hidden path="aid" />
			
					<tr><td colspan="2"><input  type="submit" value="Save" class="btn btn-primary" id="sumbnid"/><input type="reset" class="btn btn-primary"/> </td> </tr>
					</table>
					</form:form>	
			</div>
			</div>
			 <!---================================ Edit tab =======================================-->
 <div id="tabs-1" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	 
	 <c:forEach var="wfactionEditValues" items="${wfactionValues }">
			 <form:form action="wfactionUpdate.mnt" method="POST" commandName="wfactionAdd" id="updateWfActionForm">
			<table class="tableGeneral">
			<tr><td colspan="2"><c:forEach var="wfactionUpadted" items="${wfactionUpadteFail}"><div class="alert-danger" id="successmessage"><c:out value="${wfactionUpadteFail}"></c:out></div> </c:forEach> </td></tr>
			<tr><td colspan="2"><c:forEach var="duplicate"items="${wfactionEditDuplicate }"><div class="alert-warning"><font color="red"> <c:out value="${duplicate}"></c:out></font></div></c:forEach></td></tr>
		<tr><td colspan="2"><c:forEach var="wfactionUpadted" items="${wfactionUpadte}"><div class="alert-warning" id="successmessage"><c:out value="${wfactionUpadted}"></c:out></div> </c:forEach> </td></tr> 
			<tr>
									<td colspan="2"><c:forEach var="duplicate"
											items="${wfactionEditDuplicate }">
											<div class="alert-warning">
												<font color="red"> <c:out value="${duplicate}"></c:out></font>
											</div></c:forEach></td></tr>
		<tr><td colspan="2"><c:forEach var="wfactionUpadted" items="${wfactionUpadte}"><div class="alert-success" id="successmessage"><strong>Success!</strong><c:out value="${wfactionUpadted}"></c:out></div> </c:forEach> </td></tr> 
				<form:hidden path="wfactionIdEdit" />
				<tr><td>Step Name</td><td><form:select path="wfactionStepGUIDEdit" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${StepSearchIds}" /></form:select></td> </tr>
			<tr><td>Action</td><td><form:input path="wfactionActionEdit" id="wfactionAction" class="textbox" /></td> </tr>
			<tr><td>Name</td><td><form:input path="wfactionNameEdit" id="wfactionName" class="textbox" /></td> </tr>
			<tr><td>Type</td><td><form:input path="wfactionTypeEdit" id="wfactionType" class="textbox" /></td> </tr>
			<tr><td>Condition</td><td><form:input path="wfactionConditionEdit" id="wfactionCondition" class="textbox" /></td> </tr>
			<tr><td>Direction</td><td><form:input path="wfactionDirectionEdit" id="wfactionDirection" class="textbox" /></td> </tr>
			<tr><td>Goto Step</td><td><form:input path="wfactionGotoStepEdit" id="wfactionGotoStep" class="textbox" /></td> </tr>
			<tr><td>Email</td><td><form:input path="wfactionEmailEdit" id="wfactionEmail" class="textbox" /></td> </tr>
			<tr><td>Comments</td><td><form:input path="wfactionCommentsEdit" id="wfactionComments" class="textbox" /></td> </tr>
			<tr><td>Message</td><td><form:input path="wfactionMessageEdit" id="wfactionMessage" class="textbox" /></td> </tr>
			<tr><td>Message Details</td><td><form:input path="wfactionMessageDetailsEdit" id="wfactionMessageDetails" class="textbox" /></td> </tr>
		<form:hidden path="aid" />
			<form:hidden path="wfactionCreatedByEdit" />
			<form:hidden path="wfactionCreateddateEdit" />
				
					<tr><td colspan="2" ><input type="submit" value="Update" class="btn btn-primary" id="updbut"/> </td> </tr>
					</table></form:form></c:forEach>
	</div></div>

		</div>
	</div>

</body>
</html>




