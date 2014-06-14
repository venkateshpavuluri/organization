
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>My JSP 'Warehouse.jsp' starting page</title>
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
			$("#addWareHouseForm").validate({
				
				rules : {
					warehouse : {required : true},
					address : {required : true},
					city : {required : true},
					state : {required : true},
					countryId : {required : true},
					zip : {required : true,number : true},
					phone1 : {required : true,number : true},
					fax : {required : true,number : true},
					
				},
				messages : {
					warehouse : "<font style='color: red;'><b> Warehouse is Required</b></font>",
					address : "<font style='color: red;'><b> Address is Required</b></font>",
					city : "<font style='color: red;'><b> City is Required</b></font>",
					state : "<font style='color: red;'><b> State is Required</b></font>",
					countryId : "<font style='color: red;'><b> country is Required</b></font>",
					zip : "<font style='color: red;'><b> Zip Code is Required and must be an Integer</b></font>",
					phone1 : "<font style='color: red;'><b> Phone1 is Required and must be an Integer</b></font>",
					fax : "<font style='color: red;'><b> Fax is Required and must be an Integer</b></font>"
														
				},

			});
		});
		
		$('#updbut').click(function(event) {
			
			$("#updatewarehouseForm").validate({
				rules : {
					warehouseEdit : {required : true},
					addressEdit : {required : true},
					cityEdit : {required : true},
					stateEdit : {required : true},
					countryIdEdit : {required : true},
					zipEdit : {required : true,number : true},
					phone1Edit : {required : true,number : true},
					faxEdit : {required : true,number : true},
					
				},
				messages : {
					warehouseEdit : "<font style='color: red;'><b> Warehouse is Required</b></font>",
					addressEdit : "<font style='color: red;'><b> Address is Required</b></font>",
					cityEdit : "<font style='color: red;'><b> City is Required</b></font>",
					stateEdit : "<font style='color: red;'><b> State is Required</b></font>",
					countryIdEdit : "<font style='color: red;'><b> country is Required</b></font>",
					zipEdit : "<font style='color: red;'><b> Zip Code is Required and must be an Integer</b></font>",
					phone1Edit : "<font style='color: red;'><b> Phone1 is Required and must be an Integer</b></font>",
					faxEdit : "<font style='color: red;'><b> Fax is Required and must be an Integer</b></font>"
														
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
 <script type="text/javascript">
	$(document).ready(function() {
		
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
		}
	});
</script> <script type="text/javascript"> 
$(function() {
	$('#basicSearch').click(function() {
		$("#advanceSearchHidden").val("0");
		$("#aslink").show();
		$('#mainSearch').show();
		$('#advanceSearchDiv').hide();
		$('#advanceSearch').show();
		$('#basicSearch').hide();
		
		return false;
	});
});
</script>
 </head>
<body>
	<div class="divUserDefault">
	 <div class="PageTitle">WareHouse</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
			   <c:forEach var="warehouseValues" items="${warehouseValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message	code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			
     <!---================================ Search tab =======================================-->
	<div id="tabs-2" class="TabbedPanelsContent">
	 <div align="left">
		<table class="tableGeneral">
      <form:form action="warehouseSearch.mnt" method="get" commandName="warehouseAdd" >

<tr><td colspan="2"><c:forEach var="warehouseUpadted" items="${warehouseSave}"><div class="alert-success" id="savemessage"><c:out value="${warehouseSave}"></c:out></div></c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="warehouseUpadted" items="${warehouseUpadteSuccess}"><div class="alert-success" id="successmessage"><c:out value="${warehouseUpadteSuccess}"></c:out></div> </c:forEach> </td></tr>
	<tr><td colspan="2"><c:forEach var="warehouseUpadted" items="${warehouseUpadteFail}"><div class="alert-warning" id="successmessage"><c:out value="${warehouseUpadteFail}"></c:out></div> </c:forEach> </td></tr>
	<tr id="mainSearch"><td><spring:message code="label.searchby"/></td>
	
								<td><form:select path="xmlLabel" cssClass="select">
										
										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="warehouseAdd.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit" value="<spring:message code="label.search"/>"	class="btn btn-primary" /></td>
							</tr>
	 
</form:form>
	
	 <form:form action="warehouseAdvanceSearch.mnt" method="get"
							commandName="warehouseAdd" name="advanceSearchFinal">
						<tr><td>
						<a href="javascript: void(0);" id="advanceSearch" onclick="document.advanceSearchFinal.submit();return false;"><font style="color: blue" id="aslink"><u><b>Advanced Search</b></u></font></a>
						<a href="#" id="basicSearch" style="display: none" ><font style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td></tr>
					</form:form>
					
						
	</table>
			<form:form action="warehouseAdvanceSearchOperations.mnt" commandName="warehouseAdd">
						<div id="advanceSearchDiv" style="display: none">
						<table class="tableGeneral">
						<c:forEach
										var="xmlLabelValue" items="${warehouseSearchAdvance}">
						<tr>
								<td>
										<label>${xmlLabelValue.secondLabel}</label><form:hidden path="firstLabel" id="firstLabel" value="${xmlLabelValue.firstLabel}"/></td>
										 <td><form:select path="operations1" >
										<form:option value="0">-Select-</form:option>
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select>
									
									
									</td><td><form:input path="advanceSearchText" id="advanceSearch"/></td>
							</tr>
							
							</c:forEach>
							<tr><form:hidden path="advanceSearchHidden" id="advanceSearchHidden" /><td colspan="3"><input type="submit" id="advanceSearchButtonId" value="Advance Search"
									style="display: none" class="btn btn-primary" /></td></tr>
						
						</table>
						
						</div>
</form:form>			
					
	
	<c:forEach var="warehouseSearch" items="${warehouseSearch}">
	<c:set var="g" value="${warehouseSearch}"></c:set></c:forEach>
	<c:if test="${g!=null}">
	<display:table  id="warehouseRow" name="warehouseSearch"  requestURI="warehouseSearch.mnt" pagesize="5" class="table">

<display:column property="warehouse" titleKey="label.warehouse" media="html" sortable="true" ></display:column>
<display:column property="address" titleKey="label.whaddress" media="html" sortable="true" ></display:column>
<display:column property="city" titleKey="label.whcity" media="html" sortable="true" ></display:column>
<display:column property="state" titleKey="label.whState" media="html" sortable="true" ></display:column>
<display:column property="countryName" titleKey="label.Whcountry" media="html" sortable="true" ></display:column>
<display:column property="zip" titleKey="label.whzip" media="html" sortable="true" ></display:column>
<display:column property="phone1" titleKey="label.whphone1" media="html" sortable="true" ></display:column>
<display:column property="phone2" titleKey="label.whphone2" media="html" sortable="true" ></display:column>
<display:column property="fax" titleKey="label.whfax" media="html" sortable="true" ></display:column>


<display:column titleKey ="label.edit" style="color:white"><a href="warehouseEditHome.mnt?warehouseDetEdit=<c:out value="${warehouseRow.warehouseId}"/>" style="color: red"><img src="images/Edit.jpg" width="20px" height="20px" /> </a></display:column>

  <display:column titleKey="label.delete"><a href="warehouseDelete.mnt?warehouseIdDelete=<c:out value="${warehouseRow.warehouseId}"/>" style="color: red" onclick="return confirm('Do u want to delete the Record?')"><img src="images/Delete.jpg" width="20px" height="20px"  /></a></display:column>
<display:setProperty name="paging.banner.placement" value="bottom" />
<display:setProperty name="paging.banner.group_size" value="3" />
<display:setProperty name="paging.banner.some_items_found" value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
</display:table></c:if>  
               
	 </div>
     </div>
     
     
     
     <!---================================ Add tab =======================================-->
	<div id="tabs-3" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	  
				<form:form  action="warehouseAdd.mnt"  method="GET" commandName="warehouseAdd" id="addWareHouseForm" onsubmit="return validateForm()">
				<table class="tableGeneral">
	
				<tr><td colspan="2"><c:forEach var="warehouseUpadted" items="${warehouseSaveFail}"><div class="alert-warning" id="savemessage"><c:out value="${warehouseSaveFail}"></c:out></div></c:forEach> </td></tr>
<tr><td colspan="2"><c:forEach var="a" items="${WareHouseDuplicate }"><div class="alert-warning"><font color="red"> <c:out value="${a}"></c:out></font></div></c:forEach></td>
							</tr>
							<form:hidden path="warehouseId" />
				
			<tr><td><spring:message code="label.warehouse"/><span class="required">*</span></td><td><form:input path="warehouse" id="warehouse" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whaddress"/><span class="required">*</span></td><td><form:input path="address" id="address" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whcity"/><span class="required">*</span></td><td><form:input path="city" id="city" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whState"/><span class="required">*</span></td><td><form:input path="state" id="state" class="textbox" /></td> </tr>
				
					<tr><td><spring:message code="label.Whcountry"/><span class="required">*</span></td><td><form:select path="countryId" class="select">
										<form:option value="">--Select--</form:option>
									
										<form:options items="${CountrySearchIds}" /></form:select></td> </tr>
			<tr><td><spring:message code="label.whzip"/><span class="required">*</span></td><td><form:input path="zip" id="zip" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whphone1"/><span class="required">*</span></td><td><form:input path="phone1" id="phone1" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whphone2"/></td><td><form:input path="phone2" id="phone2" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whfax"/><span class="required">*</span></td><td><form:input path="fax" id="fax" class="textbox" /></td> </tr>
			
			<form:hidden path="aid" />
			
			
					<tr><td colspan="2"><input  type="submit" value="<spring:message code="label.save"/>"  class="btn btn-primary" id="sumbnid"/>
					<input type="reset" value="<spring:message code="label.reset"/>" class="btn btn-primary"/> </td> </tr>
					</table>
					</form:form>	
					
			</div>
			</div>
			 <!---================================ Edit tab =======================================-->
<div id="tabs-1" class="TabbedPanelsContent">
	<div align="left" class="TabbedPanelsContent">
	 
	  <c:forEach var="warehouseEditValues" items="${warehouseValues }">
			 <form:form action="warehouseUpdate.mnt" method="POST" commandName="warehouseAdd" id="updatewarehouseForm">
			<table class="tableGeneral">
			<tr><td colspan="2"><c:forEach var="warehouseUpadted" items="${warehouseUpadteFail}"><div class="alert-danger" id="successmessage"><c:out value="${warehouseUpadteFail}"></c:out></div> </c:forEach> </td></tr>
			<tr><td colspan="2"><c:forEach var="duplicate"items="${warehouseEditDuplicate }"><div class="alert-warning"><font color="red"> <c:out value="${duplicate}"></c:out></font></div></c:forEach></td></tr>
		<tr><td colspan="2"><c:forEach var="warehouseUpadted" items="${warehouseUpadte}"><div class="alert-warning" id="successmessage"><c:out value="${warehouseUpadted}"></c:out></div> </c:forEach> </td></tr> 
			<form:hidden path="warehouseIdEdit" />
				
			<tr><td><spring:message code="label.warehouse"/><span class="required">*</span></td><td><form:input path="warehouseEdit" id="warehouseEdit" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whaddress"/><span class="required">*</span></td><td><form:input path="addressEdit" id="addressEdit" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whcity"/><span class="required">*</span></td><td><form:input path="cityEdit" id="cityEdit" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whState"/><span class="required">*</span></td><td><form:input path="stateEdit" id="stateEdit" class="textbox" /></td> </tr>
					<tr><td><spring:message code="label.Whcountry"/><span class="required">*</span></td><td><form:select path="countryIdEdit" class="select">
										<form:option value="">--Select--</form:option>
									
										<form:options items="${CountrySearchIds}" /></form:select></td> </tr>
			<tr><td><spring:message code="label.whzip"/><span class="required">*</span></td><td><form:input path="zipEdit" id="zipEdit" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whphone1"/><span class="required">*</span></td><td><form:input path="phone1Edit" id="phone1Edit" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whphone2"/></td><td><form:input path="phone2Edit" id="phone2Edit" class="textbox" /></td> </tr>
			<tr><td><spring:message code="label.whfax"/><span class="required">*</span></td><td><form:input path="faxEdit" id="faxEdit" class="textbox" /></td> </tr>
	
			
			
					<tr><td colspan="2"><input type="submit" value="<spring:message code="label.update"/>" class="btn btn-primary" id="updbut"/> </td> </tr>
					</table></form:form></c:forEach>
	</div></div> 

		</div>
	</div>

</body>
</html>




