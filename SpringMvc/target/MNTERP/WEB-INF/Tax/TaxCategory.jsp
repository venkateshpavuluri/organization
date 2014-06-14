<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#submitid')
								.click(
										function(event) {
											//alert("hai");
											$('#addtaxform')
													.validate(
															{
																rules : {
																	taxCategory : {
																		required : true },
																		taxCategoryCode:{
																			required : true	
																		},
																	
																},
																messages : {
																	taxCategory : "<font style='color: red;'><b>Tax Category is Required</b></font>",
																	taxCategoryCode : "<font style='color: red;'><b>Tax Category Code is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
											
											$('#edittaxForm')
													.validate(
															{
																rules : {
																	taxCategoryEdit : {
																		required : true },
																		taxCategoryCodeEdit:{
																			required : true	
																		},

																},
																messages : {
																	taxCategoryEdit : "<font style='color: red;'><b>Tax Category is Required</b></font>",
																	taxCategoryCodeEdit : "<font style='color: red;'><b>Tax Category Code is Required</b></font>"
																},
															});

										}); 

					});
</script>


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
		<script type="text/javascript">
		$(document).ready(function(){
		
		
		$('#search,#add').click(function(e){
		$('#edit').hide();
		});
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
		 
		    $("#add").click(function(e) {
		   
		    $("#edit").hide();
		      $("#successmessage").hide();
		      $("#savemessage").hide();
		      $("#warningmessage").hide();
		   
		        });
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
		    $('#sumbnid').click(function(e) {
		    var aid=document.getElementById("aid").value=1;
		        });
		        });
		 </script>
		 
		 <script type="text/javascript">
		 $(document).ready(function() {
		
		    $("#add").click(function(e) {
		  
		    $("#edit").hide();
		      $("#successmessage").hide();
		      $("#savemessage").hide();
		      $("#warningmessage").hide();
		        });
		        });
		 </script>
 
 </head>
 <body>
	 <div class="divUserDefault">
	 <div class="PageTitle">Tax Category</div>
	 <div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
			   <c:forEach var="taxValues" items="${list}"> 
				  <li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
			   </c:forEach>
				  <li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				 <li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
	 <div id="tabs-2" class="TabbedPanelsContent">
	 <div align="left">
	
       <form:form action="taxCategorySearch.mnt" method="GET" commandName="taxCategoryCommand" >
         <table class="tableGeneral">
         <tr><td colspan="2"><c:forEach var="taxUpadted" items="${param.list}"><div class="alert-success" id="savemessage"><strong>Success!</strong><c:out value="${param.success}"></c:out></div></c:forEach> </td></tr>
	     <tr><td colspan="2"><c:forEach var="taxUpadted" items="${taxUpadte}"><div class="alert-success" id="successmessage"><strong>Success!</strong><c:out value="${taxUpadted}"></c:out></div> </c:forEach> </td></tr>
	     <tr><td colspan="2"><c:forEach var="itemUpadted" items="${param.list1}"><div class="alert-warning" id="warningmessage"><strong>Warning!</strong><c:out value="${param.warning}"></c:out></div> </c:forEach> </td></tr>
		 <tr><td>&nbsp;&nbsp;&nbsp;</td></tr>
		 <tr><td colspan="2"></td></tr>
		 <%-- <tr><td>Tax Category Id </td><td><form:input path="taxCategoryId" cssClass="textbox"/></td><td><input type="submit" value="Search" class="btn btn-primary"/></td></tr>  --%>
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
	 <c:forEach var="taxSearch" items="${taxCategorySearch}">
	 <c:set var="g" value="${taxSearch}"></c:set></c:forEach>
	 <c:if test="${g!=null}"> 
	 <display:table  id="taxCategoryRow" name="taxCategorySearch"  requestURI="taxCategorySearch.mnt" pagesize="5" class="table">

		  <display:column property="taxCategory"  title="Tax Category" media="html" sortable="true" />
		  <display:column property="taxCategoryCode" title="Tax Category Code" media="html"  sortable="true" />
		  <display:column title="Edit" style="color:white"><a href="taxCategoryIdEdit.mnt?taxCategoryIdEdit=<c:out value="${taxCategoryRow.taxCategoryId}"/>" style="color: red"><img src="images/Edit.jpg" width="20px" height="20px" /> </a></display:column>
		  <display:column title="Delete"><a href="taxCategoryIdDelete.mnt?taxCategoryIdDelete=<c:out value="${taxCategoryRow.taxCategoryId}"/>" style="color: red" onclick="return confirm('Do u want to delete the Record?')"><img src="images/Delete.jpg" width="20px" height="20px" /></a></display:column>
		  <display:setProperty name="paging.banner.placement" value="bottom" />
		  <display:setProperty name="paging.banner.group_size" value="3" />
		  <display:setProperty name="paging.banner.some_items_found" value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
     </display:table>
     </c:if>
       
	 </div>
     </div>
	 <div id="tabs-3" class="TabbedPanelsContent">
	 <div align="left" class="TabbedPanelsContent">
	 <form:form  action="TaxCategory.mnt"  method="POST" commandName="taxCategoryCommand" id="addtaxform">
	 <table class="tableGeneral">
	 			
	 			<form:hidden path="aid" />
                    <tr>
                            <td colspan="2" height="20px">
                            <c:forEach var="addTaxDuplicate" items="${addTaxDuplicate}">
                                            <div class="alert-warning" id="savemessage">
                                                    <font color="red"><c:out value="${addTaxDuplicate}"/></font>
                                            </div>
                            </c:forEach>
                            </td>
                    </tr>
	 			
				<tr><td>Tax Category<font color="red">*</font> </td><td><form:input path="taxCategory" id="taxCategory" class="textbox" /> </td> </tr>
			    <tr><td>Tax Category Code<font color="red">*</font> </td><td><form:input path="taxCategoryCode" id="taxCategoryCode" class="textbox" /> </td> </tr>
			    <tr><td colspan="2"><input  type="submit" value="Save" class="btn btn-primary" id="submitid"/><input type="reset" class="btn btn-primary"/> </td> </tr>
				</table>
				</form:form>	
	 
	</div>
	</div>

    <div id="tabs-1" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	<c:forEach var="taxValues" items="${list}"> 
			 <form:form action="taxCategoryEdit.mnt" method="POST" commandName="taxCategoryCommand" id="edittaxForm">
	    		<table class="tableGeneral">
	    		
                    <tr>
                            <td colspan="2" height="20px">
                            <c:forEach var="addTaxDuplicate" items="${addTaxDuplicate}">
                                            <div class="alert-warning" id="savemessage">
                                                    <font color="red"><c:out value="${addTaxDuplicate}"/></font>
                                            </div>
                            </c:forEach>
                            </td>
                    </tr>
				<form:hidden path="taxCategoryIdEdit"/>
				<tr><td>Tax Category<font color="red">*</font> </td><td><form:input path="taxCategoryEdit" id="taxCategory"  class="textbox" /> </td> </tr>
			    <tr><td>Tax Category Code<font color="red">*</font> </td><td><form:input path="taxCategoryCodeEdit" id="taxCategoryCode"  class="textbox" /> </td> </tr>
			    <tr><td colspan="2"><input type="submit" value="Update" class="btn btn-primary" id="updateid"/> </td> </tr>
				</table>
			 </form:form>
	</c:forEach>
	</div>
	</div>
	</div>
	</div>
</body>
</html>




