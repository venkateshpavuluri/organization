<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
$(function() {

	
	
	$("#dueDate").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true
		
	});
	
});

function numbersonly(myfield, e, dec) {

	var key;
	var keychar;

	if (window.event)
		key = window.event.keyCode;
	else if (e)
		key = e.which;
	else
		return true;
	keychar = String.fromCharCode(key);

	// control keys
	if ((key == null) || (key == 0) || (key == 8) || (key == 9)
			|| (key == 13) || (key == 27))
		return true;

	// numbers
	else if ((("0123456789.").indexOf(keychar) > -1))
		return true;

	// decimal point jump
	/* else if (dec && (keychar == ".")) {
		myfield.form.elements[dec].focus();
		return false;
	}  */
	else
		return false;
}



function doAjaxPost(id) {
	//alert("asd"+id);
	  if(id=='A')
		  {
	var code = $('#coa').val();
	//alert("sdf");
		$.ajax({
			type : "POST",
			url : "chartofAccountCheck.mnt",
			data : "chartofAccount=" + code+ "&chartofAccountId=0",
			success : function(data) {
				//alert(data);
				var checkResponse="Warning ! Chart of Account aleardy exists.";
				if(checkResponse==data)
				{
				document.getElementById("chartofAccountDuplicateMess").style.display="block";
				$('#chartofAccountDuplicateMess').html(data);
				$('#save').hide();
				}
				else
				{
				document.getElementById("chartofAccountDuplicateMess").style.display="none";
				$('#save').show();
				}
			},
			error : function(e) {
				//alert('Error: ' + e);
			}

		});
		  }
	  if(id=='E')
		  { 
		  
		 
		  
			var coaIdEdit = $('#coaIdEdit').val();
			 var coaEdit = $('#coaEdit').val();
			
				$.ajax({
					type : "POST",
					url : "chartofAccountCheck.mnt",
					data : "chartofAccount=" + coaEdit+ "&chartofAccountId=" + coaIdEdit,
					success : function(data) {
					//alert("data "+data);
						var checkResponse="Warning ! Chart of Account aleardy exists.";
						if(checkResponse==data)
						{
						document.getElementById("chartofAccountDuplicateMessEdit").style.display="block";
						$('#chartofAccountDuplicateMessEdit').html(data);
						$('#update').hide();
						}
						else
						{
						document.getElementById("chartofAccountDuplicateMessEdit").style.display="none";
						$('#update').show();
						}
					},
					error : function(e) {
						//alert('Error: ' + e);
					}

				});
		  
		  
		  }
	}



$(document).ready(function() {

	
	
	
	jQuery.validator.addMethod("alphaNumeric", function (value, element) {
        return this.optional(element) || /^[a-zA-Z][a-zA-Z0-9&_]*$/.test(value);
    });
	
	
	
	$('#save').click(function(event) {   
	//alert("save");
	
	
		
	 	$('#codeAdd').validate({ 
			rules : {
				coa:{required:true,alphaNumeric:true,},
				orgId : {required : true},
				
			},
			messages : {
				
				coa :{
					required:"<font style='color: red;'><b>Chart of Account is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
				orgId : "<font style='color: red;'><b>Organization is Required</b></font>",
				
				
					
				
			},
			

		}); 
		
	});

	
	
	
	
	$('#update').click(function(event) {
		
		//alert("ss");
	 	$('#chartofAccountEditLink').validate({
			rules : {
				
				coa:{required:true,alphaNumeric:true,},
				orgId : {required : true},
				
				
			},
			messages : {
				coa:{
					required:"<font style='color: red;'><b>Chart of Account is Required</b></font>",
					alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
						},
				orgId : "<font style='color: red;'><b>Organization is Required</b></font>",
				
					
				
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
		
			$('#coa').val('');
			$('#orgId').val(0);
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
 <script type="text/javascript">
	 $(document).ready(function() {
		if (document.getElementById("creditNoteDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
	}); 
	
	/* $(document).ready(function() {
		if (document.getElementById("purchaseAddDuplicateEdit").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-1"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
	}); */
</script> 

<!-- Horizantol scroll -->
<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 100%;
}
</style>

<!-- Horizantol scroll -->
<style type="text/css">
#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 70%;
	align: left;
}
</style>
<script type="text/javascript"> 
 $(function() {
	 if($('#advanceSearchHidden').val()=="1")
		{
		$('#advanceSearchDiv').show();
		$('#advanceSearchButtonId').show();
		$('#mainSearch').hide();
		$('#advanceSearch').hide();
		$('#basicSearch').show();
		} 
    $('#basicSearch').click(function() {
    	$("#advanceSearchHidden").val("0");
    	$('#advanceSearchButtonId').hide();
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
		<div class="PageTitle"><spring:message code="label.chartofAccount" /></div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="codeEditList" items="${chartofAccountEditList}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message code="label.edit" /></a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message code="label.add" /></a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					
					
					
					<table class="tableGeneral">
					
					<form:form action="chartofAccountSearch.mnt" method="GET"
							commandName="chartofAccountCommand">
						

							<tr>
								<td colspan="2">
							<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.chartofAccount"/> <spring:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											<spring:message code="label.chartofAccount"/> <spring:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										
										<c:forEach var="ChartDel"
										items="${ChartDel}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
										<spring:message code="label.chartofAccount"/> <spring:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="ChartDeleteErr"
										items="${ChartDeleteErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.chartofAccount"/> <spring:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="ChartOfAccUpdate"
										items="${ChartOfAccUpdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/> </strong>
											<spring:message code="label.chartofAccount"/> <spring:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="ChartOfAccUpdateErr"
										items="${ChartOfAccUpdateErr}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/> </strong>
										<spring:message code="label.chartofAccount"/> <spring:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
								</td></tr>
							
							
							
	                        <tr id="mainSearch">
								<td><spring:message code="label.searchby" /></td>
								<td> <form:select path="xmlLabelBasic" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select><spring:bind path="chartofAccountCommand.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind>  <form:input path="basicSearchId" cssClass="textbox" /></td>
									 <c:set var="save" value="false"></c:set>
                                   <c:set var="edit" value="false"></c:set>
                                   <c:set var="delete" value="false"></c:set>
                                   <c:set var="update" value="false"></c:set>
                                   <c:set var="search" value="false"></c:set>
								<fmt:setBundle basename="button" />
								<fmt:message key="label.save" var="messagesav" />
								<fmt:message key="label.search" var="messagesea" />
								<fmt:message key="label.delete" var="messagedel" />
								<fmt:message key="label.update" var="messageup" />
									<fmt:message key="label.edit" var="messageed" />
								<c:forEach items="${sessionScope.privilegeList}"
									var="privileges">
									
										<c:choose>
										<c:when test="${privileges eq messagesav }">
										<c:set var="save" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messagesea }">
										<c:set var="search" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messagedel }">
										<c:set var="delete" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messageed }">
										<c:set var="edit" value="true"></c:set>
										</c:when>
										<c:when test="${privileges eq messageup}">
										<c:set var="update" value="true"></c:set>
										</c:when>
										</c:choose>
								</c:forEach>
							 
								<td>
								<c:choose><c:when test="${true}">
								<input type="submit" 
									class="btn btn-primary" value="Search"/></c:when>
									<c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.search"/>"
									class="btn btn-danger" /></c:otherwise>
								</c:choose></td>
							</tr> 

						
					</form:form>
					
					 <%-- <form:form action="creditNoteAdvanceSearch.mnt" method="GET"
							commandName="creditNoteCommand" name="advanceSearchFinal">
						<tr><td>
						<a href="javascript: void(0);" id="advanceSearch" onclick="document.advanceSearchFinal.submit();return false;"><font style="color: blue"><u><b>Advanced Search</b></u></font></a>
						<a href="#" id="basicSearch" style="display: none" ><font style="color: blue"><u><b>Back To Basic Search</b></u></font></a>
									</td></tr>
					</form:form> --%>
					</table>
					<%-- <form:form action="creditNoteAdvanceSearchOperations.mnt" commandName="creditNoteCommand" method="GET">
						<div id="advanceSearchDiv" style="display: none" >
						<table class="tableGeneral">
						<c:forEach
										var="xmlLabelValue" items="${creditSearchAdvance}">
						<tr>
								<td>
										<label>${xmlLabelValue.secondLabel}</label><form:hidden path="firstLabel" id="firstLabel" value="${xmlLabelValue.firstLabel}"/></td>
										 <td><spring:bind path="creditNoteCommand.operations1">
								<select class="select" name="operations1">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> 
									
									
									</td><td><form:input path="advanceSearchText" id="advanceSearch" class="textbox"/></td>
							</tr>
							
							</c:forEach>
							<tr><form:hidden path="advanceSearchHidden" id="advanceSearchHidden" /><td colspan="3"><input type="submit" id="advanceSearchButtonId" value="Advance Search"
									style="display: none" class="btn btn-primary" /></td></tr>
						
						</table>
						
						</div>
</form:form> --%>
					
					<c:forEach var="chartofAccountList" items="${chartofAccountList}">
						<c:set var="chartofAccount" value="${chartofAccountList}"></c:set>
					</c:forEach>

					<c:choose>
						<c:when test="${chartofAccount!=null }">
						
						
						
					
							<display:table name="chartofAccountList" id="ChartofAccountList" class="table"
								requestURI="chartofAccountSearch.mnt" pagesize="5">
							
							
								 <display:column property="coa" sortable="true"
									titleKey="label.chartofAccount" media="html" />

								 <display:column property="orgId" sortable="true"
									titleKey="label.org" media="html" />
								
								<display:column titleKey="label.edit">
								<c:choose><c:when test="${true}">
									<a
										href="chartofAccountEdit.mnt?coaId=<c:out value="${ChartofAccountList.coaId}"/> "><img
										src="images/Edit.jpg" width="20px" height="20px" /></a></c:when><c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
								</display:column>
								<display:column titleKey="label.delete">
								<c:choose><c:when test="${true}">
									<a
										href="chartofAccountDelete.mnt?coaId=<c:out value="${ChartofAccountList.coaId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a></c:when><c:otherwise>
									<a><img src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
									</c:otherwise></c:choose>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" /> 

							</display:table>
						</c:when>

						
					</c:choose>
					
					
					
			<%-- <c:forEach var="creditNoteListAdvancedValues" items="${creditNoteListAdvancedValues}">
						<c:set var="creditAdvanced" value="${creditNoteListAdvancedValues}"></c:set>
					</c:forEach> 
 --%>
				 <%-- <c:choose>
						<c:when test="${creditAdvanced!=null }">
							<display:table name="creditNoteListAdvancedValues" id="purcListAdv" class="table"
								requestURI="creditNoteAdvanceSearchOperations.mnt" pagesize="5">
								
			 <display:column property="creditNoteNo" sortable="true"
									titleKey="label.creditNoteNo" media="html" />

								<display:column property="creditNoteDT" sortable="true"
									titleKey="label.creditNoteDT" media="html" />
								

								<display:column property="customerInvoiceId" sortable="true"
									titleKey="label.customerInvoiceId" media="html" />
								<display:column property="vendorInvoiceId" sortable="true"
									titleKey="label.vendorInvoiceId" media="html" />

								
								
								<display:column titleKey="label.edit">
									<a
										href="creditNoteEdit.mnt?creditNoteId=<c:out value="${purcListAdv.creditNoteId}"/> "><img
										src="images/Edit.jpg" width="20px" height="20px" /></a>
								</display:column>
								<display:column titleKey="label.delete">
									<a
										href="creditNoteDelete.mnt?creditNoteId=<c:out value="${purcListAdv.creditNoteId}"/> "
										onclick="return confirm('Do You Want To Delete This Record?')"><img
										src="images/Delete.jpg" width="20px" height="20px" /></a>
								</display:column>

								<display:setProperty name="paging.banner.placement"
									value="bottom" /> 

							</display:table>
						</c:when>
						
						
					</c:choose>  --%>
	
	

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
						<form:form action="chartofAccountAdd.mnt" method="POST"
					commandName="chartofAccountCommand" id="codeAdd" >
							<table>
							
							<tr>
								<td><c:forEach var="chartOfAccDup" items="${chartOfAccDup}">
										<div class="alert-warning" id="savemessage">
											Warning ! <c:out value="${chartOfAccDup}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2" height="35px"><form:hidden
										path="coaDuplicate" /> 	
										<div class="alert-warning" id="chartofAccountDuplicateMess" style="display: none;"></div>
										</td>
							</tr>
							
							
							
								<tr>
									<td>Chart of Account<span
												class="required">*</span></td>
									<td><form:input path="coa"
											id="coa" class="textbox" onkeyup="doAjaxPost('A')" maxlength="50"/>
											</td></tr>
												<tr>
									<td>Organization<span
												class="required">*</span></td>
									<td><form:select path="orgId"
											id="orgId" class="select" >
											 <form:option value="">-Select-</form:option>
											<form:options items="${orgId}" />
											</form:select>
											</td></tr>
										
								

							

          <tr><td colspan="2">
					<c:choose><c:when test="${true}">	
				<input type="submit" value="<spring:message code="label.save"/>"
									  class="btn btn-primary"/>
				</c:when><c:otherwise>
									<input type="submit" disabled="disabled"
									value="<spring:message code="label.save"/>"
									class="btn btn-danger" /></c:otherwise>
									</c:choose>	<input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td></tr>
			  	     </table></form:form>
			</div>


		</div>


<div id="tabs-1" class="TabbedPanelsContent" >
		<div align="left" class="TabbedPanelsContent">
		<form:form action="chartofAccountUpdate.mnt" method="POST" commandName="chartofAccountCommand" id="chartofAccountEditLink" >
			 <c:forEach var="chartofAccountEditList" items="${chartofAccountEditList}">
			
				
						<table>
							
							
							<tr>
								<td colspan="4" height="35px">	
										<div class="alert-warning" id="chartofAccountDuplicateMessEdit" style="display: none;"></div>
										</td>
							</tr>
							
							
							
								<tr>
									<td>Chart of Account<span
												class="required">*</span></td>
									<td><form:input path="coa"	id="coaEdit" class="textbox" onkeyup="doAjaxPost('E')" maxlength="50"/>
											<form:hidden path="coaId"
											id="coaIdEdit" class="textbox"/></td></tr>
											<tr>
									<td>Organization<span
												class="required">*</span></td>
									<td><form:select path="orgId"
											id="orgIdEdit" class="select">
											 <form:option value="">-Select-</form:option>
											<form:options items="${orgId}" />
											</form:select>
											</td></tr>
											
											
											<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${true}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" />
										</c:when><c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
										</c:otherwise></c:choose></td>

								</tr>
										
							</table>

</c:forEach> 
</form:form>
					</div>
				
			 
		</div>
	</div>


	</div>
	

</body>
</html>











