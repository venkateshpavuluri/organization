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
<title>My JSP 'Document .jsp' starting page</title>
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>


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
						//AddForm Validations
						$('#submit')
								.click(
										function(event) {

											$('#addform')
													.validate(
															{
																rules : {
																	
																	documentName : {
																		required : true
																	},
																	documentNo : {
																		required : true
																	},
																	documentCategoryId : {
																		required : true
																	},
																	
																	documentTypeId : {
																		required : true
																	},
																	documentPart : {
																		required : true
																	},
																	version : {
																		required : true
																	},
																	descripion : {
																		required : true
																	},
																	departmentId : {
																		required : true
																	},
																	employeeId : {
																		required : true
																	},
																	path : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	documentFile:{
																		required:true
																	}
																},
																messages : {
																	documentName : "<font style='color: red;'><b>Document Name is Required</b></font>",

																	documentNo : "<font style='color: red;'><b>Document No is Required</b></font>",
																	
																	documentCategoryId : "<font style='color: red;'><b>Document Category is Required</b></font>",
																	
																	documentTypeId : "<font style='color: red;'><b>Document Type is Required</b></font>",
																	
																	documentPart : "<font style='color: red;'><b>Document Part is Required</b></font>",
																	
																	version : "<font style='color: red;'><b>Version is Required</b></font>",
																	
																	descripion : "<font style='color: red;'><b>Description is Required</b></font>",
																	
																	departmentId : "<font style='color: red;'><b>Department is Required</b></font>",

																	employeeId : "<font style='color: red;'><b>Employee is Required</b></font>",
																	
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	
																	documentFile:"<font style='color: red;'><b>Document File is Required</b></font>",

																}
															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											
											//alert(assetedit);
											$('#editForm')
													.validate(
															{
																rules : {
																	documentName : {
																		required : true
																	},
																	documentNo : {
																		required : true
																	},
																	documentCategoryId : {
																		required : true
																	},
																	
																	documentTypeId : {
																		required : true
																	},
																	documentPart : {
																		required : true
																	},
																	version : {
																		required : true
																	},
																	descripion : {
																		required : true
																	},
																	departmentId : {
																		required : true
																	},
																	employeeId : {
																		required : true
																	},
																	path : {
																		required : true
																	},
																	statusId : {
																		required : true
																	},
																	documentFile:{
																		required:true
																	}
																	
																	
																},
																messages : {
																	documentName : "<font style='color: red;'><b>Document Name is Required</b></font>",

																	documentNo : "<font style='color: red;'><b>Document No is Required</b></font>",
																	
																	documentCategoryId : "<font style='color: red;'><b>Document Category is Required</b></font>",
																	
																	documentTypeId : "<font style='color: red;'><b>Document Type is Required</b></font>",
																	
																	documentPart : "<font style='color: red;'><b>Document Part is Required</b></font>",
																	
																	version : "<font style='color: red;'><b>Version is Required</b></font>",
																	
																	descripion : "<font style='color: red;'><b>Description is Required</b></font>",
																	
																	departmentId : "<font style='color: red;'><b>Department is Required</b></font>",

																	employeeId : "<font style='color: red;'><b>Employee is Required</b></font>",
																	
																	statusId : "<font style='color: red;'><b>Status is Required</b></font>",
																	
																	documentFile:"<font style='color: red;'><b>Document File is Required</b></font>",
										
 
																},
															});

										});

					});
</script>


<script>
	$(function() {
		$("#tabs").tabs();
	});

	$(function() {
		$("#tabsForAdd").tabs();
	});
	$(function() {
		$("#tabsForEdit").tabs();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("aid").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
		if ($('#advanceSearchHidden').val() == "1") {
			$("#aslink").hide();
			$('#advanceSearchDiv').show();
			$('#advanceSearchButtonId').show();
			$('#mainSearch').hide();
			$('#advanceSearch').hide();
			$('#basicSearch').show();
		}

	});
</script>
<script language="javascript" type="text/javascript">
<!--
function popitup(paths) {
	alert("hai");
	alert("paths"+paths);
	/* var filepath =document.getElementById("paths").value;
	alert("url:"+filepath); */
	
	//$("#resumelink").attr('href', filepath);
	newwindow=window.open(paths,'name','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=800,width=900');
	
	if (window.focus) {
		newwindow.focus();
		}
	return false;
}

// -->
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#submit').click(function(e) {
			alert("hai");
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#DocumentSchNo').val('');
			$('#equipmentId').val('');
			$('#edit').hide();
			$("#tabsForEdit").hide();
			

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#documentName").val('');
			$("#documentNo").val('');
			$("#documentCategoryId").val('');
			$("#documentTypeId").val('');
			$("#documentPart").val('');
			$("#version").val('');
			$("#descripion").val('');
			$("#departmentId").val('');
			$("#employeeId").val('');
			$("#statusId").val('');
			$("#parentDocumentId").val('');
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#tabsForEdit").hide();
			$("#warningmesssage").hide();

		});
	});
</script>




</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Document</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="preMainEdit" items="${preMainEdit}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<!-- Tab-2 -->
	<div id="tabs-2" class="TabbedPanelsContent">
		 <div align="left" class="TabbedPanelsContent">
					<form:form method="get" action="DocumentSearch.mnt"
						commandName="documentCommand">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="resourceReqAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.Document"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.Document"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
						<c:forEach var="resourceReqUpdate"
										items="${prevMainUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.Document"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="prevMainUpdateError"
										items="${resourceReqUpdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.Document"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="prevMainDelete"
										items="${prevMainDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.Document"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="prevMainDeleteError"
										items="${prevMainDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.Document"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr> 
							


							<tr>
							 <form:hidden path="path" id="path"/>
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

                   <c:forEach var="preMainValues" items="${preMainValues}">

						<c:set var="as" value="${preMainValues}"></c:set>
					</c:forEach>

					<c:if test="${as!=null }">

					<display:table name="Document" id="Document" class="table"
						requestURI="DocumentSearch.mnt" pagesize="5">
						
					
						<display:column property="documentNo" sortable="true"
							titleKey="label.documentNo" media="html" />
							 <display:column property="documentName" sortable="true"
							titleKey="label.documentName" media="html" />
							 <display:column property="documentCategoryName" sortable="true"
							titleKey="label.documentCategory" media="html" />
							 <display:column property="documentTypeName" sortable="true"
							titleKey="label.documentType" media="html" />
							 <display:column property="statusName" sortable="true"
							titleKey="label.status" media="html" />
						
						
							<display:column title="edit">
							  <c:set var="paths" value="${Document.path}" />   
							<a href="${paths}" onclick="popitup(${paths})" ><img src="images/viewimage.png"
											width="30px" height="30px" /></a>
											</display:column>
						<display:column titleKey="label.edit">
							<a
								href="DocumentEdit.mnt?DocumentId=<c:out value="${Document.documentId}"/> "><img
								src="images/Edit.jpg" width="20px" height="20px" /></a>
						</display:column>
						<display:column titleKey="label.delete">
							<a
								href="DocumentDelete.mnt?DocumentId=<c:out value="${Document.documentId}"/> "
								onclick="return confirm('Do You Want To Delete This Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
						</display:column>

						<display:setProperty name="paging.banner.placement" value="bottom" />
					</display:table>

</c:if>

				</div>  

			</div> 
			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form commandName="documentCommand" ENCTYPE="multipart/form-data" id="addform" method="POST"
						action="DocumentAdd.mnt">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
									<td colspan="2"><c:forEach
											var="addPrivMainDuplicate"
											items="${addPrivMainDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="#C09853"><c:out
														value="${addPrivMainDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
						<tr>
						<td><spring:message code="label.documentName"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="documentName" id="documentName" class="textbox" /></td>
								<td><spring:message code="label.documentNo"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="documentNo" id="documentNo" class="textbox" /></td>
                                </tr>
                           <tr>
							<td><spring:message code="label.documentCategory"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="documentCategoryId" id="documentCategoryId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${documentCategory }" />
									</form:select></td>
                                  <td><spring:message code="label.documentType"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="documentTypeId" id="documentTypeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${documentType }" />
									</form:select></td>
							</tr> 
								<tr>
						<td><spring:message code="label.documentPart"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="documentPart" id="documentPart" class="textbox" /></td>
								<td><spring:message code="label.version"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="version" id="version" class="textbox" /></td>
                                </tr>
											<tr>
						<td><spring:message code="label.descripion"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="descripion" id="descripion" class="textbox" /></td>
								<td><spring:message code="label.department"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="departmentId" id="departmentId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${department }" />
									</form:select></td>
								
							
                                </tr>
                                
                                		<tr>
						<td><spring:message code="label.employee"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="employeeId" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
								
								<%-- <td><spring:message code="label.path"></spring:message><font
									color="red">*</font></td> --%>
							<td>Please select a file to upload :<font
									color="red">*</font></td>
								<td><form:input type="file" path="documentFile" id="imageId"/></td>
								
							
                                </tr>
								
								<tr>
						<td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
									<td><spring:message code="label.parentDocument"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="parentDocId" id="parentDocId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${document }" />
									</form:select></td>
								
							
                                </tr>
                              
</table>

					 	 <div id="tabsForAdd">
								<!-- Employee Manager tab -->
								 <ul>
									<li><a href="#subtabs-1"><spring:message
												code="label.documentObjectDetails" /></a></li>

								</ul> 
							<div id="scroll">
							<div align="center">
							
								
									<script>
										var btPrevMainid = 1;
										$(function() {

											var
										    
										    objectRefId = $("#objectRefId"), 
										  
											
											
										    	objectId = $("#objectId"), 
												ovalue=$("#obNumber"), 
												
												hiddenDocumentID = $("#hiddenDocumentPopUp"),
											
											
											
											allFields = $([]).add(objectRefId).add(objectId).add(ovalue).add(hiddenDocumentID),
											 tips = $(".validateTips");

											

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
																
											function selectLength(o, n) {
												if (o.val()=='0') {
													o
															.addClass("ui-state-error");
													updateTips(n+" is Required");
													return false;
												} else {
													return true;
												}
											}

											function checkRegexp(o, regexp,
													n) {
												if (!(regexp.test(o.val()))) {
													o
															.addClass("ui-state-error");
													updateTips(n);
													return false;
												} else {
													return true;
												}
											}
											$("#dialog-form-PrevMain")
													.dialog(
															{
																autoOpen : false,
																height : 270,
																width : 300,
																modal : true,
																buttons : {
																	Submit : function() {
																		
																		var bValid1 = true;
																		allFields.removeClass("ui-state-error");
                                    								
																		
																	  bValid1 = bValid1
																		&& selectLength(
																				objectId,
																				"Object"
																				);
																	
																		 
																	
																		 
																		 
																		 bValid1 = bValid1
																			&& checkLength(
																					objectRefId,
																					"Object Reference",
																					1,
																					16); 
																					
																		
																
																	 	if (bValid1) {
																			
																			
																			if (hiddenDocumentID
																					.val() == "0"
																					|| hiddenDocumentID
																							.val() == "") {
																				
																				
																				$("#PrevMainAdd tbody")
																						.append(
																								"<tr id="+btPrevMainid+">"
																								
																																										   
																								 

																								     + "<td><spring:bind path='documentCommand.objectId'><input type='hidden' name='objectId' id='objectId"
																										+ btPrevMainid
																										+ "' value="
																										+ objectId
																												.val()
																										+ " class='textbox'/></spring:bind> <input type='text' name='obNumber' id='obNumber"
																										+ btPrevMainid
																										+ "' value="
																										+ $('#objectId :selected').text()
																																																				
																										+ " class='textbox'readonly/></td>" 

																									    
																											  
																										 	+ "<td><input type='text' name='objectRefId' id='objectRefId"
																										      + btPrevMainid
																										     + "' value="
																										     + objectRefId
																												.val()
																										     + "  class='textbox'readonly/></td>"
																										     
																									    +"<td><a href='#'  onclick='editDocument("
																										+ btPrevMainid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeemp("
																										+ btPrevMainid
																										+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																										+ "</tr>");
																				
																				btPrevMainid++;
																				$(
																						this)
																						.dialog(
																								"close");
																			}
																		
																		
																			if (hiddenDocumentID
																					.val() != "0") {
																				
																		
																				
																				$(
																						'#objectRefId'
																								+ hiddenDocumentID
																										.val())
																						.val(
																								objectRefId 
																								        .val());

																				 
																			
																		
																				
																				$(
																						'#objectId'
																								+ hiddenDocumentID
																										.val())
																						.val(
																								objectId 
																								        .val());
																				$(
																						'#obNumber'
																								+ hiddenDocumentID
																										.val())
																						.val(
																								 $('#objectId :selected').text());
																				

																				
																				$(
																						'#hiddenDocumentPopUp')
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

										
											$("#AddPrevMain")
													.button()
													.click(
															function() {
														
																$("#dialog-form-PrevMain")
																		.dialog(
																				"open");
															
															});
										});
										function removeemp(id) {
											
											$('#' + id).remove();
										}
										function editDocument(id) {
									
											$("#dialog-form-PrevMain").dialog("open");
								
											
											
											
											
											$('#objectRefId').val($('#objectRefId' + id).val());
											


											
											$('#objectId').val(
													$('#objectId' + id).val());
											
											$('#obNumber').val(
													$('#obNumber' + id).val()); 
											
											
										
											$('#hiddenDocumentPopUp').val(id);
										
									}
									</script> 


									<div id="dialog-form-PrevMain" title="Add New
											Document Object Details">
										<p class="validateTips">All form fields are required.</p>
										<table class="tableGeneral">
									
									
																 <tr>
												<td><spring:message code="label.object" /><font color="red">*</font></td>
											<td><form:select path="objectId" id="objectId" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${objects}" /> 
													
												</form:select>	
												</td>
												</tr>
									
																 
															 
									
												  <tr>
						<td><spring:message code="label.objectRefId"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="objectRefId" id="objectRefId" class="textbox" />
											<input type="hidden"
													name="hiddenDocumentPopUp" id="hiddenDocumentPopUp" value="0" /></td>
											</tr>
 										</table>
									</div>


								
									<div id="users-contain-emp">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="PrevMainAdd" class="table">
											<thead>
												<tr>
													
													
													<th><spring:message code="label.object" /></th>
													<th><spring:message code="label.objectRefId" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>
													
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
									<button id="AddPrevMain" type="button">Add New
											Document Object Details</button>
									

								</div>
							</div>
							</div> 
						<input type="submit" id="submit"
									value="<spring:message code="label.save"/>"
									class="btn btn-primary"/><input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" />
						
					</form:form>

				</div>
			</div>

			<!-- Tab-1 -->

			 <div id="tabs-1" class="TabbedPanelsContent">
				 <div align="left" class="TabbedPanelsContent">
					<c:forEach var="preMainEdit" items="${preMainEdit}">

						<form:form method="post" action="DocumentUpdate.mnt"
							commandName="documentCommand" ENCTYPE="multipart/form-data" id="editForm">
							<table class="tableGeneral">


								<%-- <form:hidden path="DocumentSchIdEdit" id="DocumentSchIdEdit" /> --%>
								<tr>
									<td colspan="2"><c:forEach
											var="addPreMainEditDuplicate"
											items="${addPreMainEditDuplicate}">
											<div class="alert-warning" id="savemessage">
												<font color="#C09853"><c:out
														value="${addPreMainEditDuplicate}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr>
                               <tr>
						<td><spring:message code="label.documentName"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="documentName" id="documentName" class="textbox" /></td>
								<td><spring:message code="label.documentNo"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="documentNo" id="documentNo" class="textbox" /></td>
                                </tr>
                           <tr>
							<td><spring:message code="label.documentCategory"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="documentCategoryId" id="documentCategoryId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${documentCategory }" />
									</form:select></td>
                                  <td><spring:message code="label.documentType"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="documentTypeId" id="documentTypeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${documentType }" />
									</form:select></td>
							</tr> 
								<tr>
						<td><spring:message code="label.documentPart"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="documentPart" id="documentPart" class="textbox" /></td>
								<td><spring:message code="label.version"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="version" id="version" class="textbox" /></td>
                                </tr>
											<tr>
						<td><spring:message code="label.descripion"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="descripion" id="descripion" class="textbox" /></td>
								<td><spring:message code="label.department"></spring:message><font
									color="red">*</font></td>
								<td><form:select path="departmentId" id="departmentId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${department }" />
									</form:select></td>
								
							
                                </tr>
                                
                                		<tr>
						<td><spring:message code="label.employee"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="employeeId" id="employeeId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${employee }" />
									</form:select></td>
								
								<form:hidden path="path" id="path"/>
									<td>Please select a File to upload :<font
									color="red">*</font></td>
									<td><form:input  alt="No Image" type="file"   path="documentFileEdit" /></td>
  
								<td><a href="" id="resumelink" onclick="return popitup()"><img src="images/viewimage.png"
											width="30px" height="30px" /></a></td>
								
							
                                </tr>
								
								<tr>
						<td><spring:message code="label.status"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="statusId" id="statusId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${status }" />
									</form:select></td>
									<td><spring:message code="label.parentDocument"></spring:message><font
									color="red">*</font></td>
								
									<td><form:select path="parentDocId" id="parentDocId"
										class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${document }" />
									</form:select></td>
								
							
                                </tr>
                              
                               

							</table>
							
							<div id="tabs-1" class="TabbedPanelsContent">
									<div id="tabsForEdit">
											<ul>

									<li><a href="#tab1"><spring:message
												code="label.documentObjectDetails" /></a></li>

								</ul>
<div id="scroll">
								<!--Sub Tab-1 -->
								 <div id="tab1">
									<div align="center">
										<script>
											var btrid = 1;
											$(function() {
									
												var 
											
												objectRefIdEdit = $("#objectRefIdEdit"),
												
												objectIdEdit = $("#objectIdEdit"),
											
												hiddenEdit = $("#hiddenDocumentPopUpEdit"),
												
												allFields = $([]).add(objectRefIdEdit).add(objectIdEdit)
														.add(hiddenEdit),
														tips = $(".validateTips");

												function updateTips(t) {
													tips
															.text(t)
															.addClass(
																	"ui-state-highlight");
													setTimeout(
															function() {
																tips
																		.removeClass(
																				"ui-state-highlight",
																				1500);
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
																	
												function selectLength(o, n) {
													if (o.val()=='0') {
														o
																.addClass("ui-state-error");
														updateTips(n+" is Required");
														return false;
													} else {
														return true;
													}
												}

												function checkRegexp(o, regexp,
														n) {
													if (!(regexp.test(o.val()))) {
														o
																.addClass("ui-state-error");
														updateTips(n);
														return false;
													} else {
														return true;
													}
												}

												$("#dialog-form-PrevMainEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 310,
																	width : 350,
																	modal : true,
																	buttons : {
																		"Submit" : function() {
																			var bValid1 = true;
																			allFields
																					.removeClass("ui-state-error");
																			
																			
																			
																			 
																			bValid1 = bValid1
																				&& selectLength(
																						objectIdEdit,
																						"Object"
																						);
																		
																			
																			 
																			 bValid1 = bValid1
																				&& checkLength(
																						objectRefIdEdit,
																						"Object Reference",
																						1,
																						16); 
																						
																				
																			if (bValid1) {
																				

																				if (hiddenEdit.val() == 0)
																				{
																					alert("objectId:"+$("#objectIdEdit"));
																					$(
																							
																							"#AddPrevMainEdit tbody")
																							.append(
																								
																									"<tr id="+btrid+">"
																											+ "<spring:bind path='documentCommand.documentEditt'><input type='hidden' name='documentEditt' id='documentEditt"
																											+ btrid
																											+ "' value='0' class='textbox' readonly/></spring:bind>"
																											 
																										
																											
																											
																											
																										
																									
																										
																										 + "<td><spring:bind path='documentCommand.objectIdEdit'><input type='hidden' name='objectIdEdit' id='objectIdEdit"
																											+ btrid
																											+ "' value="
																											+ objectIdEdit.val()
																											+ " class='textbox' readonly/></spring:bind>"
																											+"<spring:bind path='documentCommand.objectName'><input type='text' name='objectName' id='objectName"
																											+ btrid
																											+ "' value="
																											
																											+$('#objectIdEdit :selected').text()
																											+ " class='textbox' readonly/></spring:bind></td>" 
																											

																											 

																												
																												+ "<td><spring:bind path='documentCommand.objectRefIdEdit'><input name='objectRefIdEdit' id='objectRefIdEdit"
																												+ btrid
																												+ "' value="
																												+ objectRefIdEdit
																														.val()
																												+ " class='textbox' readonly/></spring:bind> </td>"
																									 	
																											+"<input type='hidden' name='documentObjectIdEdit' id='documentObjectIdEdit' value='0'/><input type='hidden' name='Check' id='Check' value='0' /></td>"	
																											+"<td><a href='#'  onclick='editDocumentDetailsInEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeEmpDetailsEditNew("
																											+ btrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");
																					btrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																			
																			if (hiddenEdit
																					.val() != 0) {
																			
																				
																			
																				$(
																						'#objectRefIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#objectRefIdEdit')
																										.val());
																				
																			
																				
																				$(
																						'#objectIdEdit'
																								+ hiddenEdit
																										.val())
																						.val(
																								$(
																										'#objectIdEdit')
																										.val());
																				$(
																						'#objectName'
																								+ hiddenEdit
																										.val())
																						.val(
																								$('#objectIdEdit :selected').text());

																			
																				$(
																						'#hiddenDocumentPopUpEdit')
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
																			$(
																					this)
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

												$("#create-AddPrevMainEdit")
														.button()
														.click(
															
																function() {
																
																	$(
																			"#dialog-form-PrevMainEdit")
																			.dialog(
																					"open");

																});
											});
											function removeEmpDetailsEditNew(
													id) {
											alert("id is:"+id);
												$('#' + id).remove();
											}
											function editDocumentDetailsInEditNew(
													link) {
												
												
												$("#dialog-form-PrevMainEdit")
														.dialog("open");
												
										   ;
												
												$('#objectRefIdEdit').val(
														$(
																'#objectRefIdEdit'
																		+ link)
																.val());
												
											
												$('#objectIdEdit').val(
														$(
																'#objectIdEdit'
																		+ link)
																.val());
												
											

												$('#hiddenDocumentPopUpEdit')
														.val(link);

											}
										</script>


										<div id="dialog-form-PrevMainEdit" title="Add New
											Document Object Details">
											<p class="validateTips">All form fields are required.</p>
											<table class="tableGeneral">

															 
												 
																					 <tr>
												<td><spring:message code="label.object" /><font color="red">*</font></td>
											<td><form:select path="objectIdEdit" id="objectIdEdit" class="select" 
													cssStyle="height:25px;">
													<form:option value="0" >--Select--</form:option>
													<form:options items="${objects}" /> 
													
												</form:select>	
												</td>
												</tr>
									
																 
															 
									
												  <tr>
						<td><spring:message code="label.objectRefId"></spring:message><font
									color="red">*</font></td>
								
								
								<td><form:input path="objectRefIdEdit" id="objectRefIdEdit" class="textbox" />
													<input type="hidden"
													name="hiddenDocumentPopUpEdit" id="hiddenDocumentPopUpEdit" value="0" /></td>
											</tr> 
 										</table>
										</div>

										<div id="users-contain-EmpEdit">
											
											<h3></h3>
											<table id="AddPrevMainEdit" class="table">
												<thead>
													<tr>
													<th><spring:message code="label.object" /></th>
													<th><spring:message code="label.objectRefId" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>		
														</tr>

														</thead>
												<tbody>
													<c:forEach var="preMainCatList"
															items="${preMainCatList}">

															<c:set var="edit1" value="${preMainCatList.documentObjectIdEdit}"></c:set> 
														
																<tr id="${preMainCatList.documentObjectIdEdit}">
																
                                                                    <spring:bind
																			path="documentCommand.documentObjectId">
																			<input type="hidden" name="documentEditt"
																				class="textbox" 
																				value="${preMainCatList.documentObjectIdEdit}" id="documentObjectId${preMainCatList.documentObjectIdEdit}" />
																		</spring:bind>
																
																		
																		

																			
																           <spring:bind
																			path="documentCommand.objectIdEdit">
																			<input type="hidden" name="objectIdEdit"
																				class="textbox" 
																				value="${preMainCatList.objectIdEdit}" id="objectIdEdit${preMainCatList.documentObjectIdEdit}" />
																		</spring:bind>
																		<td><spring:bind
																			path="documentCommand.objectName">
																			<input type="text" name="objectName"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.objectName}" id="objectName${preMainCatList.documentObjectIdEdit}" />
																		</spring:bind></td>
																		 
																		<td><spring:bind
																			path="documentCommand.objectRefIdEdit">
																			<input type="text" name="objectRefIdEdit"
																				class="textbox" readonly="readonly"
																				value="${preMainCatList.objectRefIdEdit}"  id="objectRefIdEdit${preMainCatList.documentObjectIdEdit}"/>
																		</spring:bind>
								
																	<input type="hidden" name="${preMainCatList.documentObjectIdEdit}Check" id="${preMainCatList.documentObjectIdEdit}Check" value="0"/></td>
																		<td><a href="#"
															
															onclick="javascript:editDocumentDetailsInEdit(${preMainCatList.documentObjectIdEdit})"><img src="images/Edit.jpg" height="25px" width="25px"
																id="${preMainCatList.documentObjectIdEdit}"></img></a></td>
														<td><a href="#"
															id="${preMainCatList.documentObjectIdEdit}"
															onclick="javascript:getID1(this)"><img
																src="images/button_cancel.png" height="25px"
																width="25px"
																></img></a></td>
																</tr>
		
																<script type="text/javascript">
																function getID1(
																		link) {
																	
																	alert("Deleting Particular Row Will Deleted Once You Click Update Button");
																	document
																			.getElementById(link.id
																					+ "Check").value = "1";
																document.getElementById(link.id).style.display = "none";
																}
																function editDocumentDetailsInEdit(
																		link) {
																	
																
																	$(
																			"#dialog-form-PrevMainEdit").dialog(
																					"open");
																	
																
																	
																	
																	$('#objectRefIdEdit').val(
																			$(
																					'#objectRefIdEdit'
																							+ link)
																					.val());
																
																	
																	$('#objectIdEdit').val(
																			$(
																					'#objectIdEdit'
																							+ link)
																					.val());	
																	
																																
																	$('#hiddenDocumentPopUpEdit')
																			.val(
																					link);

												}
															</script>
														
									 	</c:forEach> 


												</tbody>

											</table>
										</div>
										<button id="create-AddPrevMainEdit" type="button">Add New
											Document Object Details</button>

									</div>

								</div> 
								</div>
								<table>
									<tr>
										<td colspan=""><input type="submit" id="updated"
											value="<spring:message code="label.update"/>"
											class="btn btn-primary" id="updateid" /></td>

									</tr>

								</table>
								
								</div>
								</div> 
							
						</form:form>
					</c:forEach>

				</div>
			</div>

		</div>
	</div>
</body>
</html>
