<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script type="text/javascript">

function globalAutoComplete(urlData)
{
	//alert("1      "+urlData+"   "+$('#materialName').val());
               $("#materialName").autocomplete({
	 			minLength:1,
               source: function( request, response ) {
               $.ajax({
                    type: "POST",
                    url : urlData,
                    //"/MNTERPA/materialIdAutoInit.mnt"
                    data : "materialIdAuto="+$("#materialName").val(), 
                    success: function(data) {
                    var raw=JSON.parse(data);
                   // alert(raw);
					 response($.map(raw, function(item) {
					    return {
                              label : item.MaterialName,
                              value : item.MaterialName,
                              ex:item.Id
                          }
                      }));
					    
                       }
                   });
               }, select: function(event, ui) {
					    //alert(ui.item.value);
					       $("#materialId").val(ui.item.ex);
					    }
               
            
           });
           
           }
           
function globalAutoCompleteEdit(urlData)
{
	//alert("1      "+urlData+"   "+$('#materialName').val());
               $("#materialNameEdit").autocomplete({
	 			minLength:1,
               source: function( request, response ) {
               $.ajax({
                    type: "POST",
                    url : urlData,
                    //"/MNTERPA/materialIdAutoInit.mnt"
                    data : "materialIdAuto="+$("#materialNameEdit").val(), 
                    success: function(data) {
                    var raw=JSON.parse(data);
                    //alert(raw);
					 response($.map(raw, function(item) {
					    return {
                              label : item.MaterialName,
                              value : item.MaterialName,
                              ex:item.Id
                          }
                      }));
					    
                       }
                   });
               }, select: function(event, ui) {
					    //alert(ui.item.value);
					       $("#materialIdEdit").val(ui.item.ex);
					    }
               
            
           });
           
           }

$(document).ready(function() {
	/* $('#aaaa').click(function(event) {
		alert("ccc");
		
		

	}); */
	$('#sumbnid').click(function(event) {
	
		
	 	$('#vendorAdd').validate({
			rules : {
				/* customerId:{required:true,
					number:true}, */
				vendorName : {required : true},
				address : {required : true},
				
				city : {required : true},
				state : {required : true},
				country : {required : true},
				phone : {required : true},
				mobile : {required : true},
				
				serviceTaxNo:{required: true},
				fax:{required:true},
				zip:{required:true},
				email : {required : true},
				tinNo: {required : true},
				panNo: {required : true},
				vatNo: {required : true}
				
				
				
			},
			messages : {
				vendorName : "<font style='color: red;'><b>Vendor Name is Required</b></font>",
				address : "<font style='color: red;'><b>Address is Required</b></font>",
				city : "<font style='color: red;'><b>City is Required</b></font>",
				state : "<font style='color: red;'><b>State is Required</b></font>",
				country : "<font style='color: red;'><b>Country is Required</b></font>",
				mobile : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
				phone : "<font style='color: red;'><b>Phone Number is Required</b></font>",
				fax: "<font style='color: red;'><b>Fax is Required</b></font>",
				zip: "<font style='color: red;'><b>Zip Code is Required</b></font>",
				email : "<font style='color: red;'><b>Email is Required</b></font>",
				tinNo : "<font style='color: red;'><b>Tin no is Required</b></font>",
				panNo : "<font style='color: red;'><b>Pan no is Required</b></font>",
				vatNo: "<font style='color: red;'><b>Vat no is Required</b></font>",
				serviceTaxNo : "<font style='color: red;'><b>Service Tax Number is Required</b></font>",
				/* customerId:"<font style='color: red;'><b>Customer Name is Required</b></font>", */
				
		
					
				
			},
			

		}); 
		
	});

	
	/* $('#updatebtn').click(function(event) {
		alert("upadte");
		$("#updateForm1").validate({
			rules : {
				vendorNameEdit : {required : true},
				addressEdit : {required : true},
				cityEdit : {required : true},
				stateEdit : {required : true},
				countryEdit : {required : true},
				phoneEdit : {required : true},
				mobileEdit : {required : true},
				serviceTaxNoEdit:{required: true},
				emailEdit : {required : true},
				tinNoEdit: {required : true},
				panNoEdit: {required : true},
				vatNoEdit: {required : true}
			
			},
			messages : {
				vendorNameEdit : "<font style='color: red;'><b>Vendor Name is Required</b></font>",
				addressEdit : "<font style='color: red;'><b>Address is Required</b></font>",
				cityEdit : "<font style='color: red;'><b>City is Required</b></font>",
				stateEdit : "<font style='color: red;'><b>State is Required</b></font>",
				countryEdit : "<font style='color: red;'><b>Country is Required</b></font>",
				mobileEdit : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
				phoneEdit : "<font style='color: red;'><b>Phone Number is Required</b></font>",
				emailEdit : "<font style='color: red;'><b>Email is Required</b></font>",
				tinNoEdit : "<font style='color: red;'><b>Tin no is Required</b></font>",
				panNoEdit : "<font style='color: red;'><b>Pan no is Required</b></font>",
				vatNoEdit: "<font style='color: red;'><b>Vat no is Required</b></font>",
				serviceTaxNoEdit : "<font style='color: red;'><b>Service Tax Number is Required</b></font>",
			
			},

		});
	});*/
	
	
	
	$('#updatebtn').click(function(event) {
		
		//alert("ss");
	 	$('#updateForm1').validate({
			rules : {
				
				vendorNameEdit : {required : true},
				addressEdit : {required : true},
				cityEdit : {required : true},
				stateEdit : {required : true},
				countryEdit : {required : true},
				phoneEdit : {required : true},
				mobileEdit : {required : true},
				serviceTaxNoEdit:{required: true},
				emailEdit : {required : true},
				tinNoEdit: {required : true},
				panNoEdit: {required : true},
				vatNoEdit: {required : true}
				
				
			},
			messages : {
				
				
				vendorNameEdit : "<font style='color: red;'><b>Vendor Name is Required</b></font>",
				addressEdit : "<font style='color: red;'><b>Address is Required</b></font>",
				cityEdit : "<font style='color: red;'><b>City is Required</b></font>",
				stateEdit : "<font style='color: red;'><b>State is Required</b></font>",
				countryEdit : "<font style='color: red;'><b>Country is Required</b></font>",
				mobileEdit : "<font style='color: red;'><b>Mobile Number is Required</b></font>",
				phoneEdit : "<font style='color: red;'><b>Phone Number is Required</b></font>",
				emailEdit : "<font style='color: red;'><b>Email is Required</b></font>",
				tinNoEdit : "<font style='color: red;'><b>Tin no is Required</b></font>",
				panNoEdit : "<font style='color: red;'><b>Pan no is Required</b></font>",
				vatNoEdit: "<font style='color: red;'><b>Vat no is Required</b></font>",
				serviceTaxNoEdit : "<font style='color: red;'><b>Service Tax Number is Required</b></font>",
					
				
			},
			

		}); 
		
	});
	
	
	
}); 

















</script>




<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});

		$('#add').click(function(e) {
			// alert("kiran add");
			$('#edit').hide();
			$('#tabs-1').hide();

			$('#successmessage').hide();
			$('#savemessage').hide();

		});

		$('#search').click(function(e) {
			$('#edit').hide();
			$('#tabs-1').hide();

		});
	});
</script>
<script>
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs").tabs();
	});

	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs1").tabs();
	});
	$(function() { /*  jldsfgjl;jg;dsgl;df */
		$("#tabs2").tabs();
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
<%-- <script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("vendorAddDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
	});
</script> --%>

<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("vendorAddDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
		if($('#advanceSearchHidden').val()=="1")
			{
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
        $('#mainSearch').show();
        $('#advanceSearchDiv').hide();
        $('#advanceSearch').show();
		$('#basicSearch').hide();
        return false;
    });        
});








function doAjaxPost() {
var vendorName = $('#vendorNameAdd').val();
//alert(vendorName);
	$.ajax({
		type : "POST",
		url : "/MNTERP/vendorNameCheck.mnt",
		data : "vendorName=" + vendorName,
		success : function(response) {
			//var checkResponse="Warning ! @Vendor@ Duplicate values are not allowed";
			if(response!="")
			{
			document.getElementById("vendorDuplicateMess").style.display="block";
			$('#vendorDuplicateMess').html("Warning ! Vendor Name aleardy exists. Please try some other name");
			$('#sumbnid').hide();
			}
			else
			{
			document.getElementById("vendorDuplicateMess").style.display="none";
			$('#sumbnid').show();
			}
		},
		error : function(e) {
			alert('Error: ' + e);
		}

	});
}



function  doAjaxPostEdit()
{
var vendorNameEdit=$('#vendorNameEdit').val();
var vendorIdEdit=$('#vendorIdEdit').val();
		$.ajax({
		type : "POST",
		url : "/MNTERP/vendorNameCheckEdit.mnt",
		data : "vendorNameEdit=" + vendorNameEdit+ "&vendorIdEdit=" + vendorIdEdit,
		success : function(response) {
		// we have the response
			var checkResponse="Warning ! @Vendor@ Duplicate values are not allowed";
			if(checkResponse==response)
			{
			document.getElementById("vendorDuplicateMessEdit").style.display="block";
			$('#vendorDuplicateMessEdit').html(response);
			$('#updatebtn').hide();
			
			}
			else
			{
			document.getElementById("vendorDuplicateMessEdit").style.display="none";
			$('#updatebtn').show();
			}
		

		},

		error : function(e) {

			alert('Error: ' + e);

		}

	});
	}



</script>





</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Vendor Details</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vendorValues" items="${vendorValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><s:message code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><s:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><s:message code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<table class="tableGeneral">
						<tr>
							<td height="35px" colspan="5"><input type="hidden" name="search" /> <c:forEach
									var="vendorUpadted" items="${param.list}">
									<div class="alert-success" id="savemessage">
										<strong></strong>
										<c:out value="${param.success}"></c:out>
									</div>
								</c:forEach>
								<c:forEach var="vendorUpadted"
									items="${vendorUpadte}">
									<div class="alert-success" id="successmessage">
										<strong></strong>
										<c:out value="${vendorUpadte}"></c:out>
									</div>
								</c:forEach>
								<c:forEach var="vendorfail"
									items="${fail}">
									<div class="alert-danger" id="successmessage">
										<strong></strong>
										<c:out value="${fail}"></c:out>
									</div>
								</c:forEach>
								
								
								</td>
						</tr>
						<%-- <tr>
							<td colspan="5"><c:forEach var="vendorUpadted"
									items="${vendorUpadte}">
									<div class="alert-success" id="successmessage">
										<strong></strong>
										<c:out value="${vendorUpadte}"></c:out>
									</div>
								</c:forEach></td>
						</tr> --%>
						<form:form action="vendorSearch.mnt" method="get"
							commandName="vendorForm">

							<%-- <tr>
								<td>Vendor Name</td>
								<td><form:input path="vendorName" class="textbox" /></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary" /></td>
							</tr> --%>
							<tr id="mainSearch">
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
							
						</form:form>
						
						<form:form action="vendorAdvanceSearch.mnt" method="get"
							commandName="vendorForm" name="advanceSearchFinal">
						<tr><td>
						<a href="javascript: void(0);" id="advanceSearch" onclick="document.advanceSearchFinal.submit();return false;"><font style="color: blue"><u><b><s:message code="label.advanceSearchPO" /></b></u></font></a>
						<a href="#" id="basicSearch" style="display: none" ><font style="color: blue"><u><b><s:message code="label.backToBasicSearchPO" /></b></u></font></a>
									</td></tr>
					</form:form>
					</table>
					
					
					
					<form:form action="vendorAdvanceSearchOperations.mnt" commandName="vendorForm">
						<div id="advanceSearchDiv" style="display: none">
						<table class="tableGeneral">
						<c:forEach
										var="xmlLabelValue" items="${vendorSearchAdvance}">
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
						<%-- <tr>
								<td><s:message code="label.assetType" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${xmlItems}" />
									</form:select> <form:select path="operations" cssClass="select">
										<form:option value="0">-Select-</form:option>
										<form:option value="=">Equals To</form:option>
										<form:option value="!=">Not Equals To</form:option>
										<form:option value="_%">BeginsWith</form:option>
										<form:option value="%_">EndsWith</form:option>
										<form:option value="%_%">Contains</form:option>
									</form:select> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td>
							</tr>  --%>
						</table>
						
						</div>
</form:form>

					<c:forEach var="vendorSearch" items="${vendorSearch}">
						<c:set var="g" value="${vendorSearch}"></c:set>
					</c:forEach>

					<c:if test="${g!=null}">
						<div class="scroll">
							<display:table id="vendorRow" name="vendorSearch"
								requestURI="vendorSearch.mnt" pagesize="5" class="table">

								<display:column property="customerId" titleKey="label.custid" 
									media="none" sortable="true" />
								<display:column property="vendorName" titleKey="label.vendname"
									media="html" sortable="true" />
								<display:column property="address" titleKey="label.vaddress" 
									sortable="true" />
								<display:column property="city" titleKey="label.vcity"
									sortable="true" />
								<display:column property="state" titleKey="label.vstate"
									sortable="true" />
								<display:column property="country" titleKey="label.vcountry" 
									sortable="true" />
								<display:column property="zip" titleKey="label.vzip" 
									sortable="true" />
								<display:column property="email" titleKey="label.vemail" 
									media="html" sortable="true" />
								<display:column property="phone" titleKey="label.phno" 
									sortable="true" />
								<display:column property="fax" titleKey="label.vfax" 
									sortable="true" />
								<display:column property="mobile" titleKey="label.mobile" 
									sortable="true" />
								<display:column property="vendGroupId" titleKey="label.vendgrid"
									media="html" sortable="true" />
								<display:column property="blocked" titleKey="label.blocked" 
									sortable="true" />
								<display:column property="tinNo" titleKey="label.tinno" 
									sortable="true" />
								<display:column property="panNo" titleKey="label.panno" 
									sortable="true" />
								<display:column property="vatNo" titleKey="label.vatno" 
									sortable="true" />
								<display:column property="serviceTaxNo" titleKey="label.sertaxno" 
									media="html" sortable="true" />

								<display:column titleKey="label.edit" style="color:white">
									<a
										href="vendorEdit.mnt?vendorEdit=<c:out value="${vendorRow.vendorId}"/>"
										style="color: red"><img src="images/Edit.jpg" title="Edit"
										width="20px" height="20px" /> </a>
								</display:column>

								<display:column titleKey="label.delete" >
									<a
										href="vendorDelete.mnt?vendorDelete=<c:out value="${vendorRow.vendorId}"/>"
										style="color: red"><img src="images/Delete.jpg"
										title="Delete" width="20px" height="20px" /></a>
								</display:column>
								<display:setProperty name="paging.banner.placement"
									value="bottom" />

								<display:setProperty name="paging.banner.group_size" value="3" />

								<display:setProperty name="paging.banner.some_items_found"
									value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
							</display:table>
						</div>
					</c:if>

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="vendorAdd.mnt" method="POST"
						commandName="vendorForm" ENCTYPE="multipart/form-data" id="vendorAdd" name="formDD">
						
						<table class="tableGeneral">
						
							<%-- <tr>
								<td colspan="2" height="50px"><form:hidden
										path="vendorAddDuplicate" /> <c:forEach
										var="vendorDuplicateAddValue" items="${vendorDuplicateAdd}">
										<div class="alert-warning" id="successmessage">
											<strong></strong>
											<c:out value="${vendorDuplicateAddValue}"></c:out>
										</div>
									</c:forEach></td>
							</tr> --%>
								<tr>
								<td colspan="4"><form:hidden
										path="vendorAddDuplicate" /> 	
										<div class="alert-warning" id="vendorDuplicateMess" style="display: none;"></div>
										</td>
							</tr>
							<tr>
								<td><s:message code="label.custid" /></td>
								<td>
									<!--<form:input path="customerId" id="customerId" class="textbox" /> -->
									<form:select path="customerId" id="customerId" class="select">
										<form:option value="0">--Select--</form:option>
										<%-- <form:option value="1" >one</form:option> --%>
										<form:options items="${customerIdDetails}" />
									</form:select>
								</td>
								<td><s:message code="label.vendname" /><span
												class="required">*</span></td>
								<td><form:input path="vendorName" id="vendorNameAdd"
										class="textbox" onkeyup="doAjaxPost()"/></td>
							</tr>
							<tr>
								<td><s:message code="label.vaddress" /><span
												class="required">*</span></td>
								<td><form:input path="address" id="Address" class="textbox" />
								</td>
								<td><s:message code="label.vcity" /><span
												class="required">*</span></td>
								<td><form:input path="city" id="City" class="textbox" /></td>
							</tr>
							<tr>
								<td><s:message code="label.vstate" /><span
												class="required">*</span></td>
								<td><form:input path="state" id="State" class="textbox" />
								</td>
								<td><s:message code="label.vcountry" /><span
												class="required">*</span></td>
								<td>
									<!--<form:input path="country" id="Country" class="textbox" />-->
									<form:select path="country" id="Country" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${country}" />
									</form:select>
								</td>
							</tr>
							<tr>
								<td><s:message code="label.vzip" /><span
												class="required">*</span></td>
								<td><form:input path="zip" id="Zip" class="textbox" /></td>
								<td><s:message code="label.vemail" /></td>
								<td><form:input path="email" id="Email" class="textbox" />
								</td>
							</tr>
							<tr>
								<td><s:message code="label.sertaxno" /><span
												class="required">*</span></td>
								<td><form:input path="serviceTaxNo" id="ServiceTaxNo"
										class="textbox" /></td>
								<td><s:message code="label.phone" /><span
												class="required">*</span></td>
								<td><form:input path="phone" id="Phone" class="textbox" />
								</td>
							</tr>
							<tr>
								<td><s:message code="label.vfax" /><span
												class="required">*</span></td>
								<td><form:input path="fax" id="Fax" class="textbox" /></td>
								<td><s:message code="label.mobile" /></td>
								<td><form:input path="mobile" id="Mobile" class="textbox" />
								</td>
							</tr>
							<tr>
								<td><s:message code="label.vendgrid" /><span
												class="required">*</span></td>
								<td>
									<!--<form:input path="vendGroupId" id="vendGroupId" class="textbox" />-->
									<form:select path="vendGroupId" id="vendGroupId" class="select">
										<form:option value="0">--Select--</form:option>
										<%-- <form:option value="1" >one</form:option> --%>
										<form:options items="${vendorGroupIdDetails}" />
									</form:select>
								</td>
								<td><s:message code="label.blocked" /><span
												class="required">*</span></td>
								<td><form:select path="blocked" id="Blocked" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="1">YES</form:option>
										<form:option value="2">NO</form:option>

									</form:select></td>
							</tr>
							<tr>
								<td><s:message code="label.tinno" /><span
												class="required">*</span></td>
								<td><form:input path="tinNo" id="TinNo" class="textbox" />
								</td>
								<td><s:message code="label.panno" /><span
												class="required">*</span></td>
								<td><form:input path="panNo" id="PanNo" class="textbox" />
								</td>
							</tr>
							<tr>
								<td><s:message code="label.vatno" /><span
												class="required">*</span></td>
								<td><form:input path="vatNo" id="VatNo" class="textbox" />
								</td>
								<td></td>
							</tr>




							<tr align="center">
								<td colspan="4"><input type="submit" value="<s:message code="label.save" />" 
									class="btn btn-primary" id="sumbnid" /><input type="reset" value="<s:message code="label.reset" />"
									class="btn btn-primary" /></td>
							</tr>
						</table>


						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11"><s:message code="label.BankDetailsv" /></a></li>
								<li><a href="#tabs-21"><s:message code="label.Documentsv" /></a></li>
						<li><a href="#tabs-31"><s:message code="label.Materialv" /></a></li> 
						<li><a href="#tabs-41"><s:message code="label.VendorAccounts" /></a></li> 
							</ul>
							<div id="tabs-11">
								<div align="center">
									
									<script>
										var btrid = 1;
										$(function() {

											/*  var hiddenid=$('#hiddenIdBankPopUp').val();
											        alert("kk"+hiddenid); */

											var name = $("#bankName"), address = $("#bankAddress"), micrCode = $("#micrCode"), ifscCode = $("#ifscCode"), accountType = $("#accountType"), accountNumber = $("#accountNumber"), hiddenID = $("#hiddenIdBankPopUp"),
											// password = $( "#password" ),
											// allFields = $( [] ).add( name ).add( email ).add( password ),
											allFields = $([]).add(name).add(address).add(micrCode).add(ifscCode).add(accountType).add(accountNumber).add(hiddenID),
											 tips = $(".validateTips");

											/*  var nameedit = $( "#bankNameAddEdit" ),
											   addressedit = $( "#bankAddressAddEdit" ),
											   micrCodeedit=$( "#micrCodeAddEdit" ),
											   ifscCodeedit=$( "#ifscCodeAddEdit" ),
											   accountTypeedit=$( "#accountTypeAddEdit" ),
											   accountNumberedit=$( "#accountNumberAddEdit" ),id=$( "#accountNumberAddEdit" ),
											// password = $( "#password" ),
											// allFields = $( [] ).add( name ).add( email ).add( password ),
											 allFields = $( [] ).add( nameedit ).add(addressedit).add( micrCodeedit ).add(ifscCodeedit).add( accountTypeedit ).add(accountNumberedit).add(id),
											 tips = $( ".validateTips" ); */

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-Bank")
													.dialog(
															{
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");

																		/* bValid = bValid
																				&& checkLength(
																						name,
																						"Bank Name",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						address,
																						"Bank Address",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						micrCode,
																						"MICR Code",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						ifscCode,
																						"IFSC Code",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						accountType,
																						"Account Type",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						accountNumber,
																						"Account Number",
																						3,
																						16); */
																		//bValid = bValid && checkLength( x, "x", 6, 80 );
																		//  bValid = bValid && checkLength( y, "y", 5, 16 );

																		bValid = bValid
																				&& checkRegexp(
																						name,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Bank Name may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						address,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Bank Address  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						micrCode,
																						/^[a-z]([0-9a-z_])+$/i,
																						"MICR Code may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						ifscCode,
																						/^[a-z]([0-9a-z_])+$/i,
																						"IFSC Code  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						accountType,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Type may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						accountNumber,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Number  may consist of a-z, 0-9, underscores, begin with a letter.");
																		// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
																		//bValid = bValid && checkRegexp( x, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. x" );
																		// bValid = bValid && checkRegexp( y, /^([0-9a-zA-Z])+$/, "y field only allow : a-z 0-9" );

																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {

																				$(
																						"#BankAdd tbody")
																						.append(
																								"<tr id="+btrid+">"
																										+ "<td ><spring:bind path='vendorForm.bankName'><input name='bankName' id='bankName"
																										+ btrid
																										+ "' value="
																										+ name
																												.val()
																										+ " class='textbox' readonly /></spring:bind>  </td>"
																										+ "<td><spring:bind path='vendorForm.bankAddress'><input name='bankAddress' id='bankAddress"
																										+ btrid
																										+ "' value="
																										+ address
																												.val()
																										+ " class='textbox' readonly/></spring:bind> </td>"
																										+ "<td><spring:bind path='vendorForm.micrCode'><input name='micrCode' id='micrCode"
																										+ btrid
																										+ "' value="
																										+ micrCode
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='vendorForm.ifscCode'><input name='ifscCode' id='ifscCode"
																										+ btrid
																										+ "' value="
																										+ ifscCode
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='vendorForm.accountType'><input name='accountType' id='accountType"
																										+ btrid
																										+ "' value="
																										+ accountType
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='vendorForm.accountNumber'><input name='accountNumber' id='accountNumber"
																										+ btrid
																										+ "' value="
																										+ accountNumber
																												.val()
																										+ " class='textbox'/></spring:bind></td>"
																										+

																										// "<td>" + password.val() + "</td>" +
																										"<td><a href='#'  onclick='editMaterialm("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='20px' width='20px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeMaterialm("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btrid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																			if (hiddenID
																					.val() != "0") {
																				$(
																						'#bankName'
																								+ hiddenID
																										.val())
																						.val(
																								name
																										.val());
																				$(
																						'#bankAddress'
																								+ hiddenID
																										.val())
																						.val(
																								address
																										.val());
																				$(
																						'#micrCode'
																								+ hiddenID
																										.val())
																						.val(
																								micrCode
																										.val());
																				$(
																						'#ifscCode'
																								+ hiddenID
																										.val())
																						.val(
																								ifscCode
																										.val());
																				$(
																						'#accountType'
																								+ hiddenID
																										.val())
																						.val(
																								accountType
																										.val());
																				$(
																						'#accountNumber'
																								+ hiddenID
																										.val())
																						.val(
																								accountNumber
																										.val());
																				$(
																						'#hiddenIdBankPopUp')
																						.val(
																								"0");
																				$(
																						this)
																						.dialog(
																								"close");
																			}

																		}

																	},
																	Cancel : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																close : function() {
																	allFields
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

										

											$("#create-AddBank")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-Bank")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeMaterialm(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										
										function editMaterialm(id) {
											//alert("edit row " + id);
											//$('#'+id).remove();

											$("#dialog-form-Bank").dialog(
													"open");
											
											$('#bankName').val(
													$('#bankName' + id).val());
											$('#bankAddress').val(
													$('#bankAddress' + id)
															.val());
											$('#micrCode').val(
													$('#micrCode' + id).val());
											$('#ifscCode').val(
													$('#ifscCode' + id).val());
											$('#accountType').val(
													$('#accountType' + id)
															.val());
											$('#accountNumber').val(
													$('#accountNumber' + id)
															.val());
											$('#hiddenIdBankPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-Bank" title="<s:message code="label.AddNewBankDetails" />">
										<p class="validateTips"><s:message code="label.Allformfieldsarerequired." /></p>
										<table class="tableGeneral" >



											<tr>
												<td><s:message code="label.vbankname" /><span
												class="required">*</span></td>
												<td><form:input path="bankName" id="bankName"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vbankaddr" /><span
												class="required">*</span></td>
												<td><form:input path="bankAddress" id="bankAddress"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vmicrcode" /><span
												class="required">*</span></td>
												<td><form:input path="micrCode" id="micrCode"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vifsccode" /><span
												class="required">*</span></td>
												<td><form:input path="ifscCode" id="ifscCode"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vacttype" /><span
												class="required">*</span></td>
												<td><form:input path="accountType" id="accountType"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vactno" /><span
												class="required">*</span></td>
												<td><form:input path="accountNumber" id="accountNumber"
														class="textbox" /> <input type="hidden"
													name="hiddenIdBankPopUp" id="hiddenIdBankPopUp" value="0" /></td>
											</tr>

										</table>
									</div>


									<%--  <div id="dialog-form-BankAddEdit" title="Edit Bank Details">
	  <p class="validateTips"><s:message code="label.Allformfieldsarerequired." /></p>
	 <table class="tableGeneral"> 
	 
	 
	
	  	<tr><td>Bank Name</td><td><input type="text" name="hiddenIdAddEdit" id="hiddenIdAddEdit"/><form:input  path="bankName" id="bankNameAddEdit" class="textbox" /></td></tr>
	    <tr><td>Bank Address</td><td><form:input  path="bankAddress" id="bankAddressAddEdit" class="textbox" /></td></tr>
	    <tr><td>MICR Code</td><td><form:input path="micrCode" id="micrCodeAddEdit" class="textbox" /></td></tr>
		<tr><td>IFSC Code</td><td><form:input path="ifscCode" id="ifscCodeAddEdit" class="textbox" /></td></tr>
		<tr><td>Account Type</td><td><form:input path="accountType" id="accountTypeAddEdit" class="textbox" /></td></tr>
		<tr><td>Account Number</td><td><form:input path="accountNumber" id="accountNumberAddEdit" class="textbox" /></td></tr>
	 
	  </table>
	</div>
	  --%>
									<div id="users-contain-Bank">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="BankAdd" class="table">
											<thead>
												<tr>
													<th><s:message code="label.vbankname" /><span
												class="required">*</span></th>
													<th><s:message code="label.vbankaddr" /><span
												class="required">*</span></th>
													<th><s:message code="label.vmicrcode" /><span
												class="required">*</span></th>
													<th><s:message code="label.vifsccode" /><span
												class="required">*</span></th>
													<th><s:message code="label.vacttype" /><span
												class="required">*</span></th>
													<th><s:message code="label.vactno" /><span
												class="required">*</span></th>
													<th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>
													<!--   <th>Email</th>
	        <th>Password</th> -->
												</tr>
											</thead>
											<tbody>
												<!-- <tr>
	        <td>John Doe</td>
	        <td>john.doe@example.com</td>
	        <td>johndoe1</td>
	      </tr> -->
											</tbody>
										</table>
									</div>
									<button id="create-AddBank" type="button"><s:message code="label.AddNewVendorBankDetails" /></button>
									

								</div>
							</div>
							<div id="tabs-21">
								<div align="center">
									
									
									<div align="center">
									
									<script type="text/javascript">
									
									var dmrid=1;
									function addDocument()
									{
										var cc=dmrid-1;
										//var document=$('#documentName'+cc).val();
										//var fil=$('#file'+cc).val();
										//alert("file  "+$('#file'+cc).val());
										if($('#documentName'+cc).val()!="" &&  $('#file'+cc).val()!="" )
											{
											
										
									$("#DocumentAdd tbody").append(
											"<tr id="+dmrid+">"
													+ "<td ><spring:bind path='vendorForm.documentName'><input name='documentName' id='documentName"
													+ dmrid
													+ "' "
													+ " class='textbox' /></spring:bind>  </td>"
													+ "<td><input type='file' name='file' id='file"
													+ dmrid
													+ "'  /></td>"
													+ "<td><a href='#'  onclick='removeDocumentm("
													+ dmrid
													+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
													+ "</tr>");
									dmrid++;
									
											}
										else
											{
											alert("Please Fill The Available Document Name And File");
											}
									}
									function removeDocumentm(id) {
										//alert("removing row " + id);
										$('#' + id).remove();
									}
									</script>
												

									

								
									<div id="users-contain-Document">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="DocumentAdd" class="table">
											<thead>
												<tr>
												
													<th><s:message code="label.docname" /><span
												class="required">*</span></th>
													<th><s:message code="label.docpath" /><span
												class="required">*</span></th>
													
													
													<th><s:message code="label.remove" /></th>
													<th><s:message code="label.add" /></th>
												
													<!--   <th>Email</th>
	        <th>Password</th> -->
												</tr>
											</thead>
											<tbody>
												



											<tr id="0">
												
												<td><form:input path="documentName" id="documentName0"  
														class="textbox" /></td>
											
												
												<td><input type="file" name="file" id="file0"/></td>
											<td><a href='#'  onclick='removeDocumentm(0)'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>
											 <td><a href='#'  onclick='addDocument()'><strong><img src='images/add (1).png' height='20px' width='20px'/></strong></a></td>
											</tr>

										
											</tbody>
										</table>
									</div>
									<%-- <button id="create-AddDocuments" type="button"><s:message code="label.AddNewVendorDocuments" /></button> --%>
									

								</div>
									
									
									

								</div>
							</div>
							  <div id="tabs-31">
    						<div align="center">
							
							
							
							
							
							<script>
										var mmrid = 1;
										$(function() {

											/*  var hiddenid=$('#hiddenIdBankPopUp').val();
											        alert("kk"+hiddenid); */
											        //documentName file
											var materialname = $("#materialName"), materialId = $("#materialId"),hiddenID = $("#hiddenIdMaterialPopUp"),
											// password = $( "#password" ),
											// allFields = $( [] ).add( name ).add( email ).add( password ),
									
											allFields = $([]).add(materialname).add(materialId).add(hiddenID),
											 tips = $(".validateTips");
											      //  alert("filename"+filename);
											/*  var nameedit = $( "#bankNameAddEdit" ),
											   addressedit = $( "#bankAddressAddEdit" ),
											   micrCodeedit=$( "#micrCodeAddEdit" ),
											   ifscCodeedit=$( "#ifscCodeAddEdit" ),
											   accountTypeedit=$( "#accountTypeAddEdit" ),
											   accountNumberedit=$( "#accountNumberAddEdit" ),id=$( "#accountNumberAddEdit" ),
											// password = $( "#password" ),
											// allFields = $( [] ).add( name ).add( email ).add( password ),
											 allFields = $( [] ).add( nameedit ).add(addressedit).add( micrCodeedit ).add(ifscCodeedit).add( accountTypeedit ).add(accountNumberedit).add(id),
											 tips = $( ".validateTips" ); */

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
											
											function materialIdReq(o, n) {
												if (o.val()=="") {
													o.addClass("ui-state-error");
													updateTips("Specified Details Not Available");
													return false;
												} else {
													return true;
												}
											}


											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-Material")
													.dialog(
															{
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");

																		 bValid = bValid
																				&& materialIdReq(
																						materialId,
																						"MaterialId"
																						);
																		/*bValid = bValid
																				&& checkLength(
																						address,
																						"Bank Address",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						micrCode,
																						"MICR Code",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						ifscCode,
																						"IFSC Code",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						accountType,
																						"Account Type",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						accountNumber,
																						"Account Number",
																						3,
																						16); */
																		//bValid = bValid && checkLength( x, "x", 6, 80 );
																		//  bValid = bValid && checkLength( y, "y", 5, 16 );

																		bValid = bValid
																				&& checkRegexp(
																						materialname,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Material Name may consist of a-z, 0-9, underscores, begin with a letter.");
																		/* bValid = bValid
																				&& checkRegexp(
																						address,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Bank Address  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						micrCode,
																						/^[a-z]([0-9a-z_])+$/i,
																						"MICR Code may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						ifscCode,
																						/^[a-z]([0-9a-z_])+$/i,
																						"IFSC Code  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						accountType,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Type may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						accountNumber,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Number  may consist of a-z, 0-9, underscores, begin with a letter."); */
																		// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
																		//bValid = bValid && checkRegexp( x, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. x" );
																		// bValid = bValid && checkRegexp( y, /^([0-9a-zA-Z])+$/, "y field only allow : a-z 0-9" );

																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				//alert("Material Id        "+materialId
																					//	.val());
																				//documentName file
																				$(
																						"#MaterialAdd tbody")
																						.append(
																								"<tr id="+mmrid+">"
																										+ "<td ><spring:bind path='vendorForm.MaterialName'><input name='materialName' id='materialName"
																										+ mmrid
																										+ "' value="
																										+ materialname
																												.val()
																										+ " class='textbox'  readonly/></spring:bind>  "
																										+ "<input type='hidden' name='materialId' id='materialId"
																										+ mmrid
																										+ "' value='"
																										+ materialId
																												.val()
																										+ "' class='textbox' /></td>"
																										+"<td><a href='#'  onclick='editMaterialAdd("
																										+ mmrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeMaterialAdd("
																										+ mmrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				dmrid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																			if (hiddenID
																					.val() != "0") {
																				$('#materialName'+hiddenID.val()).val(materialname.val());
																				$('#materialId'+hiddenID.val()).val(materialId.val());		
																				//$('#file'+ hiddenID.val()).val(address.val());
																				$('#hiddenIdMaterialPopUp')	.val("0");
																				$(this).dialog("close");
																			}

																		}

																	},
																	Cancel : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																close : function() {
																	allFields
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

											

											$("#create-AddMaterial")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-Material")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeMaterialAdd(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editMaterialAdd(id) {
											//alert("edit row " + id);
											//$('#'+id).remove();

											$("#dialog-form-Material").dialog(
													"open");
											/*  $('#bankNameAddEdit').val($('#bankName'+id).val());
											 $('#bankAddressAddEdit').val($('#bankAddress'+id).val());
											 $('#micrCodeAddEdit').val($('#micrCode'+id).val());
											 $('#ifscCodeAddEdit').val($('#ifscCode'+id).val());
											 $('#accountTypeAddEdit').val($('#accountType'+id).val());
											 $('#accountNumberAddEdit').val($('#accountNumber'+id).val());
											 $('#hiddenIdAddEdit').val(id); */

											//alert($('#bankName'+id).val());
											//$('#bankName').val($('#bankName'+id).val());
											$('#materialName').val(
													$('#materialName'+ id).val());
											$('#materialId').val(
													$('#materialId' + id)
															.val());
											$('#hiddenIdMaterialPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-Material" title="<s:message code="label.AddNewMaterialDetails" />">
										<p class="validateTips"><s:message code="label.Allformfieldsarerequired." /></p>
										<table class="tableGeneral">



											<tr>
												<td><s:message code="label.materialNamev" /><span
												class="required">*</span></td>
												<td><input name="materialName" id="materialName"  onkeypress="globalAutoComplete('/MNTERP/materialIdAuto.mnt')" 
												
														class="textbox" />
														<input type="hidden" name="materialId" id="materialId"/>
											 <input type="hidden"
													name="hiddenIdMaterialPopUp" id="hiddenIdMaterialPopUp" value="0" />
											</td></tr>
											

										</table>
									</div>


								
									<div id="users-contain-MaterialAdd">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="MaterialAdd" class="table">
											<thead>
												<tr>
													<th><s:message code="label.materialNamev" /><span
												class="required">*</span></th>
												    <th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>
													<!--   <th>Email</th>
	        <th>Password</th> -->
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="create-AddMaterial" type="button"><s:message code="label.AddNewVendorSuppliedMaterials" /></button>
									

								</div>
							
							
							
							
							
							
							
							
							
							
							
							
							</div>
							
							
							
							
							<div id="tabs-41">
    						<div align="center">
							
							 <script type="text/javascript">
										var btrid = 1;
										
										$(document).ready(function() {			
																													
											 var  acGr = $("#acGroupIdChild"),recnd = $("#reCondIdChild"),payTerm = $("#paymentTermIdChild"),payMthd = $("#paymentMethodIdChild"),hiddenID = $("#hiddenIdAccountPopUp"),
											
											allFields = $([]).add(acGr).add(recnd).add(payTerm).add(payMthd).add(hiddenID), 
											tips = $(".validateTips");																	
											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 500);
															
											}
												
											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o.addClass("ui-state-error");								
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
											function required(o, n) {
												if (o.val()=='') {
													o
															.addClass("ui-state-error");
													updateTips(n+" is Required");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o.addClass("ui-state-error");							
													updateTips(n);
													return false;
												} else {
													return true;
												}
											} 

											  $("#dialogformCustAccount").dialog({
															
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																Submit : function() {
																		var bValid = true;
																		allFields
																				.removeClass("ui-state-error");

																		//bValid = bValid && required(cust,"Customer Name");
																		bValid = bValid && required(acGr,"Account Group");
																		bValid = bValid && required(recnd,"Reconciliation");
																		bValid = bValid && required(payTerm,"Payment Term");
																		bValid = bValid && required(payMthd,"Payment Method");
																		
																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID.val() == "0" || hiddenID.val() == "") {					
																				$("#CustAccountAdd tbody").append(
																																									
																								"<tr id="+btrid+">"
																										
																										
																										+ "<td><input type='hidden' name='acGroupId' id='acGroupIdChild"
																										+ btrid
																										+ "' value="
																										+ acGr
																												.val()
																										+ " class='textbox' readonly/>"
																										+"<input type='text' class='textbox' readonly name='acGroupName' id='acGroupName"+btrid+"' value='"+$('#acGroupIdChild :selected').text()+"'"
																										+"</td>"
																										
																										+ "<td><input type='hidden' name='reCondId' id='reCondIdChild"
																										+ btrid
																										+ "' value="
																										+ recnd
																												.val()
																										+ " class='textbox' readonly/>"
																										+"<input type='text' class='textbox' readonly name='reCondName' id='reCondName"+btrid+"'  value='"+$('#reCondIdChild :selected').text()+"'"
																										+"</td>"
																										
																										+ "<td><input type='hidden' name='paymentTermId' id='paymentTermIdChild"
																										+ btrid
																										+ "' value="
																										+ payTerm
																												.val()
																										+ " class='textbox' readonly/>"
																										+"<input type='text' class='textbox' readonly name='paymentTermName' id='paymentTermName"+btrid+"' value='"+$('#paymentTermIdChild :selected').text()+"'"
																										+"</td>"
																										
																										+ "<td><input type='hidden' name='paymentMethodId' id='paymentMethodIdChild"
																										+ btrid
																										+ "' value="
																										+ payMthd
																												.val()
																										+ " class='textbox' readonly/>"
																										+"<input type='text' class='textbox' readonly name='paymentMethodName' id='paymentMethodName"+btrid+"' value='"+$('#paymentMethodIdChild :selected').text()+"'"
																										+"</td>"
																										
																										
																										+"<td><a href='#'  onclick='editCustAccount("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeCustAccount("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");

																				btrid++;
																				$(this).dialog("close");
																			}																																									

																			if (hiddenID.val() != "0"){
																				/* $('#customIdChild'+ hiddenID.val()).val(cust.val());
																				$('#customName'+hiddenID.val()).val($('#customIdChild :selected').text()); */
																				$('#acGroupIdChild'+ hiddenID.val()).val(acGr.val());
																				$('#acGroupName'+hiddenID.val()).val($('#acGroupIdChild :selected').text());
																				$('#reCondIdChild'+ hiddenID.val()).val(recnd.val());
																				$('#reCondName'+hiddenID.val()).val($('#reCondIdChild :selected').text());
																				$('#paymentTermIdChild'+ hiddenID.val()).val(payTerm.val());
																				$('#paymentTermName'+hiddenID.val()).val($('#paymentTermIdChild :selected').text());
																				$('#paymentMethodIdChild'+ hiddenID.val()).val(payMthd.val());
																				$('#paymentMethodName'+hiddenID.val()).val($('#paymentMethodIdChild :selected').text());
																				$('#hiddenIdAccountPopUp').val("0");																																									
																				$(this).dialog("close");																																								
																								
																			}

																		}

																	},
																	Cancel : function() {
																		$(this).dialog("close");
																																	
																	}
																},
																close : function() {
																	allFields.val("").removeClass("ui-state-error");																												
																					
																}
															}); 
											 
												$('#createAddCustAccount').button().click(function() {
												 												
													$("#dialogformCustAccount").dialog("open");																																																					
													//alert("opened");
												});
								});	
										
										 function removeCustAccount(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editCustAccount(id) {
											//alert("edit row " + id);
											$("#dialogformCustAccount").dialog("open");
											//$('#customIdChild').val($('#customIdChild' + id).val());
											$('#acGroupIdChild').val($('#acGroupIdChild' + id).val());
											$('#reCondIdChild').val($('#reCondIdChild' + id).val());
											$('#paymentTermIdChild').val($('#paymentTermIdChild' + id).val());
											$('#paymentMethodIdChild').val($('#paymentMethodIdChild' + id).val());
											$('#hiddenIdAccountPopUp').val(id);
											// document.getElementById("").value="edit";
										} 
									</script>  

									 <div id="dialogformCustAccount" align="center" title="<s:message code="label.vendacform" />">
										<p class="validateTips" align="center" style="color:blue;">All Form Fields are Required</p>
										<table class="tableGeneral">
											
											
											<tr>
												<td><s:message code="label.vendacgrid" /> <span
													class=required>*</span></td>
												<td><form:select path="acGroupName" id="acGroupIdChild"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${AccGroupSelect}" />
														</form:select></td>
											</tr>
											
											<tr>
												<td><s:message code="label.vendacrecondid" /> <span
													class=required>*</span></td>
												<td><form:select path="reCondName" id="reCondIdChild"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${AccGroupSelect}" />
														</form:select></td>
											</tr>
											
											<tr>
												<td><s:message code="label.vendacpt" /> <span
													class=required>*</span></td>
												<td><form:select path="paymentTermName" id="paymentTermIdChild"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${PaymentTermSelect}" />
														</form:select></td>
											</tr>
											
											<tr>
												<td><s:message code="label.vendacpm" /> <span
													class=required>*</span></td>
												<td><form:select path="paymentMethodName" id="paymentMethodIdChild"
														class="select" >
														
														<form:option value="">-Select-</form:option>
													<form:options items="${PaymentMethodSelect}" />
														</form:select></td>
											</tr>
											
											<tr>																							
											<td><input type="hidden"
													name="hiddenIdAccountPopUp" id="hiddenIdAccountPopUp" value="0" /></td>
											</tr>

										</table>
									</div>  

									 <div id="users-CustAccount">
										<table id="CustAccountAdd" class="table">
											<thead>
												<tr>
													
													<th><s:message code="label.vendacgrid" /><span
														class=required>*</span></th>
													<th><s:message code="label.vendacrecondid" /> <span
														class=required>*</span></th>
													<th><s:message code="label.vendacpt" /><span
														class=required>*</span></th>
													<th><s:message code="label.vendacpm" /><span
														class=required>*</span></th>
													<th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div> 
									
									<button id="createAddCustAccount" type="button"><s:message code="label.newaddvendac" /></button>
							
							</div>
							
							
							
							
							
							
							
							
							
							
							
							
							</div>
							</div>
							<!-- <div id="extenderMatrial"></div> -->
					</form:form>
				</div>
			</div>


		</div>

	</div>
	
	<div id="tabs-1" class="TabbedPanelsContent" >
		<div align="left" class="TabbedPanelsContent">
		&nbsp;
		<form:form action="vendorUpdate.mnt" method="POST"
					commandName="vendorForm" ENCTYPE="multipart/form-data" id="updateForm1">
			<c:forEach var="vendorEditValues" items="${vendorValues }">
				<div class="alert-warning" id="vendorDuplicateMessEdit" style="display: none;"></div>
					<table class="tableGeneral">

						<form:hidden path="vendorIdEdit" />
						

						<tr>
								<td ><form:hidden
										path="vendorAddDuplicateEdit" /> 	
									
										
										
									
									</td>
							</tr>
						<tr>
							<td><s:message code="label.custid" /></td>
							<td><form:select path="customerIdEdit" id="customerId"
									class="select">
									<form:option value="0">--Select--</form:option>
									<%-- <form:option value="1" >one</form:option> --%>
									<form:options items="${customerIdDetails}" />
								</form:select></td>
							<td><s:message code="label.vendname" /><span
												class="required">*</span></td>
							<td><form:input path="vendorNameEdit" id="vendorNameEdit"
									class="textbox" onkeyup="doAjaxPostEdit()" /></td>
						</tr>
						<tr>
							<td><s:message code="label.vaddress" /><span
												class="required">*</span></td>
							<td><form:input path="addressEdit" id="addressEdit"
									class="textbox" /></td>
							<td><s:message code="label.vcity" /><span
												class="required">*</span></td>
							<td><form:input path="cityEdit" id="City" class="textbox" />
							</td>
						</tr>
						<tr>
							<td><s:message code="label.vstate" /><span
												class="required">*</span></td>
							<td><form:input path="stateEdit" id="State" class="textbox" />
							</td>
							<td><s:message code="label.vcountry" /><span
												class="required">*</span></td>
							<td><form:select path="countryEdit" id="Country"
									class="select">
									<form:option value="0">--Select--</form:option>
									<form:options items="${country}" />
								</form:select></td>
						</tr>
						<tr>
							<td><s:message code="label.vzip" /><span
												class="required">*</span></td>
							<td><form:input path="zipEdit" id="Zip" class="textbox" />
							</td>
							<td><s:message code="label.vemail" /><span
												class="required">*</span></td>
							<td><form:input path="emailEdit" id="Email" class="textbox" />
							</td>
						</tr>
						<tr>
							<td><s:message code="label.sertaxno" /><span
												class="required">*</span></td>
							<td><form:input path="serviceTaxNoEdit" id="ServiceTaxNo"
									class="textbox" /></td>
							<td><s:message code="label.phno" /><span
												class="required">*</span></td>
							<td><form:input path="phoneEdit" id="Phone" class="textbox" />
							</td>
						</tr>
						<tr>
							<td><s:message code="label.vfax" /><span
												class="required">*</span></td>
							<td><form:input path="faxEdit" id="Fax" class="textbox" />
							</td>
							<td><s:message code="label.mobile" /><span
												class="required">*</span></td>
							<td><form:input path="mobileEdit" id="Mobile"
									class="textbox" /></td>
						</tr>
						<tr>
							<td><s:message code="label.vendgrid" /><span
												class="required">*</span></td>
							<td><form:select path="vendGroupIdEdit" id="vendGroupId"
									class="select">
									<form:option value="0">--Select--</form:option>
									<%-- <form:option value="1" >one</form:option> --%>
									<form:options items="${vendorGroupIdDetails}" />
								</form:select></td>
							<td><s:message code="label.blocked" /><span
												class="required">*</span></td>
							<td><form:select path="blockedEdit" id="Blocked"
									class="select">
									<form:option value="0">--Select--</form:option>
									<form:option value="1">YES</form:option>
									<form:option value="2">NO</form:option>

								</form:select></td>
						</tr>
						<tr>
							<td><s:message code="label.tinno" /><span
												class="required">*</span></td>
							<td><form:input path="tinNoEdit" id="TinNo" class="textbox" />
							</td>
							<td><s:message code="label.panno" /><span
												class="required">*</span></td>
							<td><form:input path="panNoEdit" id="PanNo" class="textbox" />
							</td>
						</tr>
						<tr>
							<td><s:message code="label.vatno" /><span
												class="required">*</span></td>
							<td><form:input path="vatNoEdit" id="VatNo" class="textbox" />
							</td>
							<td></td>
						</tr>



						<tr align="center">
							<td colspan="4" align="center"><input type="submit"
								value="<s:message code="label.update" />" class="btn btn-primary" id="updatebtn"/></td>
						</tr>
					</table>

					<div id="tabs2">
					
						<ul>
								<li><a href="#tabs-21"><s:message code="label.BankDetailsv" /></a></li>
								<li><a href="#tabs-22"><s:message code="label.Documentsv" /></a></li>
						<li><a href="#tabs-23"><s:message code="label.Materialv" /></a></li> 
							</ul>
							
						<div id="tabs-21">
							<div align="center">
								<div align="center">





									<script>
										var btrid = 1;
										$(function() {

											var nameEdit = $("#bankNameEdit"), addressEdit = $("#bankAddressEdit"), micrCodeEdit = $("#micrCodeEdit"), ifscCodeEdit = $("#ifscCodeEdit"), accountTypeEdit = $("#accountTypeEdit"), accountNumberEdit = $("#accountNumberEdit"), hiddenEdit = $("#hiddenIdBankPopUpEdit"),
											// password = $( "#password" ),
											// allFields = $( [] ).add( name ).add( email ).add( password ),
											allFields = $([]).add(nameEdit)
													.add(addressEdit).add(micrCodeEdit).add(ifscCodeEdit).add(accountTypeEdit).add(accountNumberEdit).add(hiddenEdit),
													 tips = $(".validateTips");

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);
														}, 500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
											
											
											
											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-BankEdit").dialog({
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																	"Submit" : function() {
																		var bValid1 = true;
																		allFields.removeClass("ui-state-error");

																		bValid1 = bValid1	&& checkLength(	nameEdit,
																						"Bank Name",
																						3,
																						16);
																		bValid1 = bValid1
																				&& checkLength(
																						addressEdit,
																						"Bank Address",
																						3,
																						16);
																		bValid1 = bValid1
																				&& checkLength(
																						micrCodeEdit,
																						"MICR Code",
																						3,
																						16);
																		bValid1 = bValid1
																				&& checkLength(
																						ifscCodeEdit,
																						"IFSC Code",
																						3,
																						16);
																		bValid1 = bValid1
																				&& checkLength(
																						accountTypeEdit,
																						"Account Type",
																						3,
																						16);
																		bValid1 = bValid1
																				&& checkLength(
																						accountNumberEdit,
																						"Account Number",
																						3,
																						16);
																		//bValid = bValid && checkLength( email, "email", 6, 80 );
																		//  bValid = bValid && checkLength( password, "password", 5, 16 );

																		bValid1 = bValid1 && checkRegexp(	nameEdit,/^[a-z]([0-9a-z_])+$/i,"Bank Name may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						addressEdit,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Bank Address  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						micrCodeEdit,
																						/^[a-z]([0-9a-z_])+$/i,
																						"MICR Code may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						ifscCodeEdit,
																						/^[a-z]([0-9a-z_])+$/i,
																						"IFSC Code  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						accountTypeEdit,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Type may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						accountNumberEdit,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Number  may consist of a-z, 0-9, underscores, begin with a letter.");
																		// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
																		//bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
																		// bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

																		if (bValid1) {
																			//alert("edi"+ hiddenEdit	.val());
																			if (hiddenEdit.val() == "0"
																					|| hiddenEdit
																							.val() == "") {
																				$(
																						"#AddBankEdit tbody")
																						.append(
																								"<tr id="+btrid+">"
																										+ "<td><spring:bind path='vendorForm.bankNameEdit'><input name='bankNameEdit' id='bankNameEdit"
																										+ btrid
																										+ "' value="
																										+ nameEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='vendorForm.bankAddressEdit'><input name='bankAddressEdit' id='bankAddressEdit"
																										+ btrid
																										+ "' value="
																										+ addressEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind> </td>"
																										+ "<td><spring:bind path='vendorForm.micrCodeEdit'><input name='micrCodeEdit' id='micrCodeEdit"
																										+ btrid
																										+ "' value="
																										+ micrCodeEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='vendorForm.ifscCodeEdit'><input name='ifscCodeEdit' id='ifscCodeEdit"
																										+ btrid
																										+ "' value="
																										+ ifscCodeEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='vendorForm.accountTypeEdit'><input name='accountTypeEdit' id='accountTypeEdit"
																										+ btrid
																										+ "' value="
																										+ accountTypeEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind></td>"
																										+ "<td><spring:bind path='vendorForm.accountNumberEdit'><input name='accountNumberEdit' id='accountNumberEdit"
																										+ btrid
																										+ "' value="
																										+ accountNumberEdit
																												.val()
																										+ " class='textbox' readonly/></spring:bind><input type='hidden' name='vendorBankDetIdEdit' id='vendorBankDetIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"
																										+
																										// "<td>" + password.val() + "</td>" +
																										"<td><a href='#'  onclick='editBankDetailsInEditNew("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeBankDetailsEditNew("
																										+ btrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				btrid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		}
																		if (hiddenEdit
																				.val() != "0") {
																			$(
																					'#bankNameEdit'
																							+ hiddenEdit
																									.val())
																					.val(
																							$(
																									'#bankNameEdit')
																									.val());
																			$(
																					'#bankAddressEdit'
																							+ hiddenEdit
																									.val())
																					.val(
																							$(
																									'#bankAddressEdit')
																									.val());
																			$(
																					'#micrCodeEdit'
																							+ hiddenEdit
																									.val())
																					.val(
																							$(
																									'#micrCodeEdit')
																									.val());
																			$(
																					'#ifscCodeEdit'
																							+ hiddenEdit
																									.val())
																					.val(
																							$(
																									'#ifscCodeEdit')
																									.val());
																			$(
																					'#accountTypeEdit'
																							+ hiddenEdit
																									.val())
																					.val(
																							$(
																									'#accountTypeEdit')
																									.val());
																			$(
																					'#accountNumberEdit'
																							+ hiddenEdit
																									.val())
																					.val(
																							$(
																									'#accountNumberEdit')
																									.val());
																			$(
																					'#hiddenIdBankPopUpEdit')
																					.val(
																							"0");
																			$(
																					this)
																					.dialog(
																							"close");
																		}
																	},
																	Cancel : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																close : function() {
																	allFields
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

											$("#create-AddBankEdit")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-BankEdit")
																		.dialog(
																				"open");

															});
										});
										function removeBankDetailsEditNew(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editBankDetailsInEditNew(link) {
											//alert(link.id);
											$("#dialog-form-BankEdit").dialog(
													"open");
											$('#bankNameEdit').val(
													$('#bankNameEdit' + link)
															.val());
											$('#bankAddressEdit')
													.val(
															$(
																	'#bankAddressEdit'
																			+ link)
																	.val());
											$('#micrCodeEdit').val(
													$('#micrCodeEdit' + link)
															.val());
											$('#ifscCodeEdit').val(
													$('#ifscCodeEdit' + link)
															.val());
											$('#accountTypeEdit')
													.val(
															$(
																	'#accountTypeEdit'
																			+ link)
																	.val());
											$('#accountNumberEdit').val(
													$(
															'#accountNumberEdit'
																	+ link)
															.val());

											$('#hiddenIdBankPopUpEdit').val(
													link);

										}
									</script>


									<div id="dialog-form-BankEdit" title="<s:message code="label.AddNewBankDetails" />">
										<p class="validateTips"><s:message code="label.Allformfieldsarerequired." /></p>
										<table class="tableGeneral">


	
											<tr>
												<td><s:message code="label.vbankname" /><span
												class="required">*</span></td>
												<td><form:input path="bankNameEdit" id="bankNameEdit"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vbankaddr" /><span
												class="required">*</span></td>
												<td><form:input path="bankAddressEdit"
														id="bankAddressEdit" class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vmicrcode" /><span
												class="required">*</span></td>
												<td><form:input path="micrCodeEdit" id="micrCodeEdit"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vifsccode" /><span
												class="required">*</span></td>
												<td><form:input path="ifscCodeEdit" id="ifscCodeEdit"
														class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vacttype" /><span
												class="required">*</span></td>
												<td><form:input path="accountTypeEdit"
														id="accountTypeEdit" class="textbox" /></td>
											</tr>
											<tr>
												<td><s:message code="label.vactno" /><span
												class="required">*</span></td>
												<td><form:input path="accountNumberEdit"
														id="accountNumberEdit" class="textbox" /> <input
													type="hidden" name="hiddenIdBankPopUpEdit"
													id="hiddenIdBankPopUpEdit" value="0" /></td>
											</tr>

										</table>
									</div>


									<div id="users-contain-BankEdit">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="AddBankEdit" class="table">
											<thead>
												<tr>
												
													<th><s:message code="label.vbankname" /><span
												class="required">*</span></th>
													<th><s:message code="label.vbankaddr" /><span
												class="required">*</span></th>
													<th><s:message code="label.vmicrcode" /><span
												class="required">*</span></th>
													<th><s:message code="label.vifsccode" /><span
												class="required">*</span></th>
													<th><s:message code="label.vacttype" /><span
												class="required">*</span></th>
													<th><s:message code="label.vactno" /><span
												class="required">*</span></th>
													<th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>
													
													<!--   <th>Email</th>
        <th>Password</th> -->
												</tr>
											
											</thead>
											<tbody>

												<c:forEach var="vendorBankEditValues"
													items="${vendorBankValues}">
													<c:set var="idn"
														value="${vendorBankEditValues.vendorBankDetId}"></c:set>
													<tr id="${vendorBankEditValues.vendorBankDetId}">
														<c:out value="${vendorBankEditValues1.bankName}" />


														<td><input type="text" name="bankNameEdit"
															id="bankNameEdit${vendorBankEditValues.vendorBankDetId}"
															class="textbox" readonly="readonly"
															value="${vendorBankEditValues.bankName}" /></td>
														<td><input type="text" name="bankAddressEdit"
															id="bankAddressEdit${vendorBankEditValues.vendorBankDetId}"
															class="textbox" readonly="readonly"
															value="${vendorBankEditValues.bankAddress}" /></td>
														<td><input type="text" name="micrCodeEdit"
															id="micrCodeEdit${vendorBankEditValues.vendorBankDetId}"
															class="textbox" readonly="readonly"
															value="${vendorBankEditValues.micrCode}" /></td>
														<td><input type="text" name="ifscCodeEdit"
															id="ifscCodeEdit${vendorBankEditValues.vendorBankDetId}"
															class="textbox" readonly="readonly"
															value="${vendorBankEditValues.ifscCode}" /></td>
														<td><input type="text" name="accountTypeEdit"
															id="accountTypeEdit${vendorBankEditValues.vendorBankDetId}"
															class="textbox" readonly="readonly"
															value="${vendorBankEditValues.accountType}" /></td>
														<td><input type="text" name="accountNumberEdit"
															id="accountNumberEdit${vendorBankEditValues.vendorBankDetId}"
															class="textbox" readonly="readonly"
															value="${vendorBankEditValues.accountNumber}" /><input
															type="hidden" name="vendorBankDetIdEdit"
															id="vendorBankDetIdEdit" class="textbox"
															value="${vendorBankEditValues.vendorBankDetId}" /><input
															type="hidden"
															name="${vendorBankEditValues.vendorBankDetId}Check"
															id="${vendorBankEditValues.vendorBankDetId}Check"
															value="0" /></td>
														<td><a href="#"
															id="${vendorBankEditValues.vendorBankDetId}"
															onclick="javascript:editBankDetailsInEdit(this)"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="${vendorBankEditValues.vendorBankDetId}"></img></a></td>
														<td><a href="#"
															id="${vendorBankEditValues.vendorBankDetId}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																id="${vendorBankEditValues.vendorBankDetId}"></img></a>

														<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
														<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
														<script type="text/javascript">
															function getID1(
																	link) {
																//alert(link.id);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link.id
																				+ "Check").value = "1";
																document
																		.getElementById(link.id).style.display = "none";
															}
															function editBankDetailsInEdit(
																	link) {
																//alert(link.id);
																$(
																		"#dialog-form-BankEdit")
																		.dialog(
																				"open");
																$(
																		'#bankNameEdit')
																		.val(
																				$(
																						'#bankNameEdit'
																								+ link.id)
																						.val());
																$(
																		'#bankAddressEdit')
																		.val(
																				$(
																						'#bankAddressEdit'
																								+ link.id)
																						.val());
																$(
																		'#micrCodeEdit')
																		.val(
																				$(
																						'#micrCodeEdit'
																								+ link.id)
																						.val());
																$(
																		'#ifscCodeEdit')
																		.val(
																				$(
																						'#ifscCodeEdit'
																								+ link.id)
																						.val());
																$(
																		'#accountTypeEdit')
																		.val(
																				$(
																						'#accountTypeEdit'
																								+ link.id)
																						.val());
																$(
																		'#accountNumberEdit')
																		.val(
																				$(
																						'#accountNumberEdit'
																								+ link.id)
																						.val());

																$(
																		'#hiddenIdBankPopUpEdit')
																		.val(
																				link.id);

															}
														</script></td>
													</tr>
												</c:forEach>
												
											</tbody>
										</table>
									</div>
									<button id="create-AddBankEdit" type="button"><s:message code="label.AddNewVendorBankDetails" /></button>






								</div>

							</div>
						</div>
						
						
						
						<div id="tabs-22">
								<div align="center">
									
									<div align="center">
									
									
									
									

									


								
									<div id="users-contain-DocumentEdit">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="DocumentEdit" class="table">
											<thead>
												<tr>
												<th><s:message code="label.docname" /><span
												class="required">*</span></th>
													<th><s:message code="label.docpath" /><span
												class="required">*</span></th>
													
													
													<th><s:message code="label.remove" /></th>
													<th><s:message code="label.edit" /></th>
													<!--   <th>Email</th>
	        <th>Password</th> -->
												</tr>
											</thead>
											<tbody>
												<c:forEach var="vendorDocumentEditValues"
										items="${vendorDocumentsValues}">
										<tr id="${vendorDocumentEditValues.vendorDocId}">
										
											<td><input type="text" name="documentName"
												id="documentName${vendorDocumentEditValues.vendorDocId}" class="textbox"
												value="${vendorDocumentEditValues.documentName}" readonly="readonly" /></td>
											
											<td><a
												href="download.mnt?id=${vendorDocumentEditValues.documentPath}">Click
													here to download file</a> <input type="hidden"
												name="vendorDocIdEdit" id="vendorDocIdEdit"
												value="${vendorDocumentEditValues.vendorDocId}" /> <input
												type="hidden" name="vendorDocumentPathEdit"
												id="vendorDocumentPathEdit"
												value="${vendorDocumentEditValues.documentPath}" /> <input
												type="hidden"
												name="${vendorDocumentEditValues.vendorDocId}CheckDoc"
												id="${vendorDocumentEditValues.vendorDocId}CheckDoc"
												value="0" /> <input type="hidden" name="checkPrevious"
												id="checkPrevious" value="1" /></td>
											<td><a href="#"
												id="${vendorDocumentEditValues.vendorDocId}"
												onclick="checkDocEdit(this)"><img
													src="images/button_cancel.png" height="20px" width="20px"></img></a>
												</td>
												<td></td>
										</tr>
									</c:forEach>
									<tr id="200">
												
												<td><form:input path="documentNameEdit" id="documentName200"  
														class="textbox" /></td>
											
												
												<td><input type="file" name="file" id="file200"/></td>
											<td><a href='#'  onclick='removeDocumentEdit(200)'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>
											 <td>
											 <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
												<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
												<script type="text/javascript">
													function checkDocEdit(link) {

														alert("Deleting Particular Row Will Deleted Once You Click Update Button Doc");
														//alert(y);
														document
																.getElementById(link.id
																		+ "CheckDoc").value = "1";
														document
																.getElementById(link.id).style.display = "none";
													}
													
													function removeDocumentEdit(id) {
														//alert("removing row " + id);
														$('#' + id).remove();
													}
													var deditmrid=201;
													var cc=deditmrid-1;
													function addDocumentEdit(){
														if($('#documentNameEdit'+cc).val()!="" &&  $('#file'+cc).val()!="" )
														{
															
													$("#DocumentEdit tbody")
													.append(
															"<tr id="+deditmrid+">"
																	+ "<td ><spring:bind path='vendorForm.documentNameEdit'><input name='documentNameEdit' id='documentName"
																	+ deditmrid
																	+ "'"
																	+ " class='textbox' /></spring:bind>  <input type='hidden' name='checkPreviousEdit' id='checkPreviousEdit'"
									                                +" value='0' /></td>"
																	+ "<td><input type='file' name='file' id='file"
																	+ deditmrid
																	+ "'  /></td>"
																	
																	+ "<td><a href='#'  onclick='removeDocumentEdit("
																	+ deditmrid
																	+ ")'><strong><img src='images/button_cancel.png' height='20px' width='20px'/></strong></a></td>"
																	+ "</tr>");
											
											deditmrid++;
														}
														else
															{
															alert("Please Fill The Available Document Name And File");
															}
													
											
										}
												</script>
											 
											 
											 <a href='#'  onclick='addDocumentEdit()'><strong><img src='images/add (1).png' height='20px' width='20px'/></strong></a></td>
											</tr>
									
									
									
									
											</tbody>
										</table>
									</div>
									
									

								</div>
									
									
									

								</div>
							</div>
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						 <div id="tabs-23">
    						<div align="center">
							
							
							
							
							
							<script>
										var memrid = 1;
										$(function() {

											/*  var hiddenid=$('#hiddenIdBankPopUp').val();
											        alert("kk"+hiddenid); */
											        //documentName file
											var materialname = $("#materialNameEdit"), materialId = $("#materialIdEdit"),vendorMatIdEdit=$("#vendorMatIdEdit"),hiddenID = $("#hiddenIdMaterialEditPopUp"),
											// password = $( "#password" ),
											// allFields = $( [] ).add( name ).add( email ).add( password ),
									
											allFields = $([]).add(materialname).add(materialId).add(vendorMatIdEdit).add(hiddenID),
											 tips = $(".validateTips");
											      //  alert("filename"+filename);
											/*  var nameedit = $( "#bankNameAddEdit" ),
											   addressedit = $( "#bankAddressAddEdit" ),
											   micrCodeedit=$( "#micrCodeAddEdit" ),
											   ifscCodeedit=$( "#ifscCodeAddEdit" ),
											   accountTypeedit=$( "#accountTypeAddEdit" ),
											   accountNumberedit=$( "#accountNumberAddEdit" ),id=$( "#accountNumberAddEdit" ),
											// password = $( "#password" ),
											// allFields = $( [] ).add( name ).add( email ).add( password ),
											 allFields = $( [] ).add( nameedit ).add(addressedit).add( micrCodeedit ).add(ifscCodeedit).add( accountTypeedit ).add(accountNumberedit).add(id),
											 tips = $( ".validateTips" ); */

											function updateTips(t) {
												tips.text(t).addClass(
														"ui-state-highlight");
												setTimeout(
														function() {
															tips.removeClass("ui-state-highlight",1500);}, 
															500);
											}

											function checkLength(o, n, min, max) {
												if (o.val().length > max
														|| o.val().length < min) {
													o
															.addClass("ui-state-error");
													updateTips("Length of "
															+ n
															+ " must be between "
															+ min + " and "
															+ max + ".");
													return false;
												} else {
													return true;
												}
											}
											
											function materialIdReq(o, n) {
												if (o.val()=="") {
													o.addClass("ui-state-error");
													updateTips("Specified Details Not Available");
													return false;
												} else {
													return true;
												}
											}
											
											
											

											function checkRegexp(o, regexp, n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}

											$("#dialog-form-MaterialEdit")
													.dialog(
															{
																autoOpen : false,
																height : 300,
																width : 350,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid = true;
																		allFields.removeClass("ui-state-error");

																		 bValid = bValid
																				&& materialIdReq(
																						materialId,
																						"MaterialId"
																						);
																		/*bValid = bValid
																				&& checkLength(
																						address,
																						"Bank Address",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						micrCode,
																						"MICR Code",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						ifscCode,
																						"IFSC Code",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						accountType,
																						"Account Type",
																						3,
																						16);
																		bValid = bValid
																				&& checkLength(
																						accountNumber,
																						"Account Number",
																						3,
																						16); */
																		//bValid = bValid && checkLength( x, "x", 6, 80 );
																		//  bValid = bValid && checkLength( y, "y", 5, 16 );

																		bValid = bValid
																				&& checkRegexp(
																						materialname,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Material Name may consist of a-z, 0-9, underscores, begin with a letter.");
																		/* bValid = bValid
																				&& checkRegexp(
																						address,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Bank Address  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						micrCode,
																						/^[a-z]([0-9a-z_])+$/i,
																						"MICR Code may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						ifscCode,
																						/^[a-z]([0-9a-z_])+$/i,
																						"IFSC Code  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						accountType,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Type may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid = bValid
																				&& checkRegexp(
																						accountNumber,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Account Number  may consist of a-z, 0-9, underscores, begin with a letter."); */
																		// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
																		//bValid = bValid && checkRegexp( x, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. x" );
																		// bValid = bValid && checkRegexp( y, /^([0-9a-zA-Z])+$/, "y field only allow : a-z 0-9" );

																		if (bValid) {
																			//alert("hiddenid"+hiddenID.val());
																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {
																				//alert("Material Id        "+materialId
																						//.val());
																				//documentName file
																				$(
																						"#MaterialEdit tbody")
																						.append(
																								"<tr id="+memrid+">"
																										+ "<td ><spring:bind path='vendorForm.MaterialNameEdit'><input name='materialNameEdit' id='materialNameEdit"
																										+ memrid
																										+ "' value="
																										+ materialname
																												.val()
																										+ " class='textbox' readonly/></spring:bind>  "
																										+ "<input type='hidden' name='materialIdEdit' id='materialIdEdit"
																										+ memrid
																										+ "' value='"
																										+ materialId
																												.val()
																										+ "' class='textbox'  /><input type='hidden' name='vendorMatIdEdit'id='vendorMatIdEdit' value='0'/></td>"
																										+"<td><a href='#'  onclick='editMaterialEdit("
																										+ memrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeMaterialEdit("
																										+ memrid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				dmrid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																			if (hiddenID
																					.val() != "0") {
																				$('#materialNameEdit'+hiddenID.val()).val(materialname.val());
																				$('#materialIdEdit'+hiddenID.val()).val(materialId.val());		
																				//$('#file'+ hiddenID.val()).val(address.val());
																				$('#hiddenIdMaterialEditPopUp')	.val("0");
																				$(this).dialog("close");
																			}

																		}

																	},
																	Cancel : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																},
																close : function() {
																	allFields
																			.val(
																					"")
																			.removeClass(
																					"ui-state-error");
																}
															});

											

											$("#create-EditMaterial")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-MaterialEdit")
																		.dialog(
																				"open");
																//alert("opened");
															});
										});
										function removeMaterialEdit(id) {
											//alert("removing row " + id);
											$('#' + id).remove();
										}
										function editMaterialEdit(id) {
											//alert("edit row " + id);
											//$('#'+id).remove();

											$("#dialog-form-MaterialEdit").dialog(
													"open");
											/*  $('#bankNameAddEdit').val($('#bankName'+id).val());
											 $('#bankAddressAddEdit').val($('#bankAddress'+id).val());
											 $('#micrCodeAddEdit').val($('#micrCode'+id).val());
											 $('#ifscCodeAddEdit').val($('#ifscCode'+id).val());
											 $('#accountTypeAddEdit').val($('#accountType'+id).val());
											 $('#accountNumberAddEdit').val($('#accountNumber'+id).val());
											 $('#hiddenIdAddEdit').val(id); */

											//alert($('#bankName'+id).val());
											//$('#bankName').val($('#bankName'+id).val());
											$('#materialNameEdit').val(
													$('#materialNameEdit'+ id).val());
											$('#materialIdEdit').val(
													$('#materialIdEdit' + id)
															.val());
											$('#hiddenIdMaterialEditPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-MaterialEdit" title="<s:message code="label.AddNewMaterialDetails" />">
										<p class="validateTips"><s:message code="label.Allformfieldsarerequired." /></p>
										<table class="tableGeneral">



											<tr>
												<td><s:message code="label.materialNamev" /><span
												class="required">*</span></td>
												<td><input name="materialNameEdit" id="materialNameEdit"  onkeypress="globalAutoCompleteEdit('/MNTERP/materialIdAuto.mnt')" 
												
														class="textbox" /><input type="hidden" name="vendorMatIdEdit" id="vendorMatIdEdit" value="0"/>
														<input type="hidden" name="materialIdEdit" id="materialIdEdit"/>
											 <input type="hidden"
													name="hiddenIdMaterialEditPopUp" id="hiddenIdMaterialEditPopUp" value="0" />
											</td></tr>
											

										</table>
									</div>


								
									<div id="users-contain-MaterialEdit">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="MaterialEdit" class="table">
											<thead>
												<tr>
													<th><s:message code="label.materialNamev" /><span
												class="required">*</span></th>
												    <th><s:message code="label.edit" /></th>
													<th><s:message code="label.remove" /></th>
													<!--   <th>Email</th>
	        <th>Password</th> -->
												</tr>
												
												
												
											</thead>
											<tbody>
												<c:forEach var="vendorMaterialEditValues"
													items="${vendorMaterialValues}">
													<c:set var="idn1"
														value="${vendorMaterialEditValues.vendorMatId}"></c:set>
													<tr id="${vendorMaterialEditValues.vendorMatId}">
														


														<td><input type="text" name="materialNameEdit"
															id="materialNameEdit${vendorMaterialEditValues.vendorMatId}"
															class="textbox" readonly="readonly"
															value="${vendorMaterialEditValues.materialName}" /></td>
														<td><input type="hidden" name="materialIdEdit"
															id="materialIdEdit${vendorMaterialEditValues.vendorMatId}"
															class="textbox" readonly="readonly"
															value="${vendorMaterialEditValues.materialId}" />
															<input
															type="hidden"
															name="vendorMatIdEdit"
															id="vendorMatIdEdit"
															value="${vendorMaterialEditValues.vendorMatId}" />
														<input
															type="hidden"
															name="${vendorMaterialEditValues.vendorMatId}CheckMaterial"
															id="${vendorMaterialEditValues.vendorMatId}CheckMaterial"
															value="0" /></td>
														<td><a href="#"
															id="${vendorMaterialEditValues.vendorMatId}"
															onclick="javascript:editMaterialDetailsInEdit(this)"><img
																src="images/Edit.jpg" height="25px" width="25px"
																id="${vendorMaterialEditValues.materialId}"></img></a></td>
														<td><a href="#"
															id="${vendorMaterialEditValues.vendorMatId}"
															onclick="javascript:getMaterialID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																id="${vendorMaterialEditValues.vendorMatId}"></img></a>

														<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
														<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
														<script type="text/javascript">
															function getMaterialID1(
																	link) {
																//alert(link.id);
																alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																document
																		.getElementById(link.id
																				+ "CheckMaterial").value = "1";
																document
																		.getElementById(link.id).style.display = "none";
															}
															function editMaterialDetailsInEdit(
																	link) {
																//alert(link.id);
																$(
																		"#dialog-form-MaterialEdit")
																		.dialog(
																				"open");
																$(
																		'#materialNameEdit')
																		.val(
																				$(
																						'#materialNameEdit'
																								+ link.id)
																						.val());
																$(
																		'#materialIdEdit')
																		.val(
																				$(
																						'#materialIdEdit'
																								+ link.id)
																						.val());
																

																$(
																		'#hiddenIdMaterialEditPopUp')
																		.val(
																				link.id);

															}
														</script>
													</td></tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<button id="create-EditMaterial" type="button"><s:message code="label.AddNewVendorSuppliedMaterials" /></button>
									

								</div>
							
							
							
							
							
							
							
							
							
							
							
							
							</div>


					</div>
					</c:forEach>
				</form:form>
			
		</div>
	</div>




</body>
</html>




