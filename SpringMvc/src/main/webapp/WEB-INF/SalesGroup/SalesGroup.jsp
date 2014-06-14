<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {
											
											$('#addForm')
													.validate(
															{
																rules : {
																	
																	salesOfficeId : {
																		required : true,
																		
																	},

																	salesGroup : {
																		required: true,
																		alphabets : true,
																		specialcharacters : true
																	},
																	
																},
																messages : {
																	salesOfficeId : "<font style='color: red;'><b>Sales Office is Required</b></font>",
																	
																	salesGroup :{
																		
																		required : "<font style='color: red;'><b>Sales Group is Required</b></font>",
														                	
																		alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																	}
																},

															});
										});
						//UpdateForm Validations
						$('#updated')
								.click(
										function(event) {
											
											$('#editForm')
													.validate(
															{
																rules : {
																	
																	salesOfficeIdEdit : {
																		required : true
																	},
																	salesGroupEdit : {
																		required: true,
																		alphabets : true,
																		specialcharacters : true
																	},

																},
																messages : {
																	
																	salesOfficeIdEdit : "<font style='color: red;'><b>Sales Office is Required</b></font>",
																	salesGroupEdit : {
																		
													                	required:"<font style='color: red;'><b>Sales Group is Required</b></font>",
													                	alphabets : "<font style='color: red;'><b>First letter should be an alphabet.</b></font>",
																		specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
																		
																	}
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
		if (document.getElementById("aid").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#sumbnid').click(function(e) {
			var aid = document.getElementById("aid").value = 1;
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#search,#add').click(function(e) {
			$('#edit').hide();

		});
	});
</script>
<script type="text/javascript" language="javascript">
	jQuery(document).ready(function() {
		jQuery("#mainForm").validationEngine();
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Sales Group</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="sgvalues" items="${sgvalues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
				 <form:form action="SalesGroupSearch.mnt" method="get"
						commandName="salesGroupCommand" name="agreementform">
						<table class="tableGeneral">
							<tr>
								<td colspan="2">
			
							<c:forEach var="success"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><s:message code="label.success"/> </strong>
											<s:message code="label.salesGroup"/> <s:message code="label.saveSuccess"/>
									
										</div>
										</c:forEach>
										<c:forEach var="fail"
										items="${param.listwar}">
										<div class="alert-danger" id="savemessage">
											<strong><s:message code="label.error"/> </strong>
											<s:message code="label.salesGroup"/> <s:message code="label.saveFail"/>
									
										</div>
										</c:forEach>
										
										<c:forEach var="sdelete"
										items="${sdelete}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/> </strong>
										<s:message code="label.salesGroup"/> <s:message code="label.deleteSuccess"/>
										
										</div>
									</c:forEach>
										
										
										<c:forEach var="sdeleteerr"
										items="${sdeleteerr}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/> </strong>
										<s:message code="label.salesGroup"/> <s:message code="label.deleteFail"/>
										
										</div>
									</c:forEach>

							<c:forEach var="sgupdate"
										items="${sgupdate}">
										<div class="alert-success" id="successmessage">
											<strong><s:message code="label.success"/> </strong>
											<s:message code="label.salesGroup"/> <s:message code="label.updateSuccess"/>
										</div>
									</c:forEach><c:forEach var="sgupdateerr"
										items="${sgupdateerr}">
										<div class="alert-danger" id="successmessage">
											<strong><s:message code="label.error"/> </strong>
										<s:message code="label.salesGroup"/> <s:message code="label.updateFail"/>
										
										</div>
									</c:forEach>
													
							</td></tr>
					         <tr>
								<td><s:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:options items="${xmlItems}" />
									</form:select> <s:bind path="salesGroupCommand.operations">
								<select class="select" name="operations">
								<option value="<s:message code='assignedOperator'/>"><s:message code="label.equalsTo"/> </option>
								<option value="<s:message code='notequalsOperator'/>"><s:message code="label.notEqualsTo"/> </option>
							 <option value="<s:message code='beginsWithOperator'/>"> <s:message code="label.beginsWith"/> </option> 
								<option value="<s:message code='endsWithOperator'/>"><s:message code="label.endsWith"/> </option>
								<option value="<s:message code='containsOperator'/>"><s:message code="label.contains"/></option>
								</select>
									 </s:bind><form:input path="basicSearchId" cssClass="textbox" /></td>
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
									 <c:choose>
									 <c:when test="${search}">
								<td><input type="submit"
									value="<s:message code="label.search"/>"
									class="btn btn-primary" /></td></c:when>
									<c:otherwise>
									<td><input type="submit" disabled="disabled"
									value="<s:message code="label.search"/>"
									class="btn btn-danger"/></td>
									</c:otherwise>
									</c:choose>
							</tr>
					         
							

						</table>
					</form:form>
        
					<c:if test="${SalesGroupSearch!=null }">
					<display:table id="salesGroup" name="salesGroup"
						requestURI="SalesGroupSearch.mnt" pagesize="5" class="table">
                    
                   
                     <display:column property="salesGroup" titleKey="label.salesGroup"
							media="html" sortable="true" />
                     						
						<display:column property="salesOffice" titleKey="label.salesOffice"
							media="html" sortable="true" />
								


						<display:column titleKey="label.edit" style="color:white">
						<c:choose>
						<c:when test="${edit }">
							<a
								href="SalesGroupEditHome.mnt?salesGroupId=<c:out 

								value="${salesGroup.salesGroup_Id}"/>"
								style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a></c:when>
								<c:otherwise>
									<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
									height="20px" /></a>
									</c:otherwise>
								</c:choose>
						</display:column>

						<display:column titleKey="label.delete">
						<c:choose>
						<c:when test="${delete}">
						<a
								href="SalesGroupDelete.mnt?salesGroupId=<c:out value="${salesGroup.salesGroup_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a></c:when>
								
								<c:otherwise>
							<a><img src="images/Edit.jpg" class="btn btn-danger" width="20px"
									height="20px" /></a>
							</c:otherwise>
						</c:choose>
							
						</display:column>
						<display:setProperty name="paging.banner.placement" value="bottom" />

						</display:table> 
					</c:if>
					 

				</div>
			</div>
			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">

					<form:form action="salesGroupadd.mnt" method="POST"
						commandName="salesGroupCommand" id="addForm">
						<table class="tableGeneral">
							<form:hidden path="aid" />
							<tr>
								<td colspan="2"><c:forEach
										var="addSalesGroupDuplicate"
										items="${addSalesGroupDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><s:message code="label.warning"/></strong>
											<s:message code="label.salesGroup"/> <s:message code="label.duplicateCheck"></s:message>
										</div>
									</c:forEach></td>
							</tr> 
						
								<tr>
								<td><s:message code="label.salesGroup"></s:message><font color="red">*</font></td>
								
								<td><form:input path="salesGroup" id="salesGroup"
										class="textbox" maxlength="50"/></td>
								<td><font color="red"></font></td>
							</tr>
							
							
						
							<tr>
								<td><s:message code="label.salesOffice"></s:message><font color="red">*</font></td>
							<td><form:select path="salesOfficeId" id="salesOfficeId"
											class="select" cssStyle="height:25px">
											<form:option value="">--Select--</form:option>
											<form:options items="${salesOffice }" />
										</form:select></td>
								<td><font color="red"></font></td>
							</tr>
							
							
							
							
							<tr>
							<td colspan="2">
							<c:choose>
							<c:when test="${save}">
							<input type="submit"
									value="<s:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
									<input type="submit" id="sumnid" disabled="disabled"
									value='<s:message code="label.save"/>' class="btn btn-danger" />
									</c:otherwise></c:choose>
								<input type="reset"
									value="<s:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
							</table>
							</form:form>
						
				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					 <c:forEach var="sgvalues" items="${sgvalues }">

						<form:form action="SalesGroupEdit.mnt" method="POST"
							commandName="salesGroupCommand" id="editForm">
							<table class="tableGeneral">

								<tr>
									<td colspan="2"><c:forEach
											var="editSalesGroupDuplicate"
											items="${editSalesGroupDuplicate}">
											<div class="alert-warning" id="savemessage">
												<strong><s:message code="label.warning"/></strong>
											<s:message code="label.salesGroup"/> <s:message code="label.duplicateCheck"></s:message>
											</div>
										</c:forEach></td>
								</tr> 
								
								<tr>
									<td></td>
									<td><form:hidden path="salesGroup_IdEdit"
											id="salesGroup_IdEdit" /></td>
								</tr>

                             <tr>
								<td><s:message code="label.salesGroup"></s:message><font color="red">*</font></td>
								
								<td><form:input path="salesGroupEdit" id="salesGroupEdit"
										class="textbox" maxlength="50"/></td>
								<td><font color="red"></font></td>
							</tr>
								
							<tr>
								<td><s:message code="label.salesOffice"></s:message><font color="red">*</font></td>
							<td><form:select path="salesOfficeIdEdit" id="salesOfficeIdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">--Select--</form:option>
											<form:options items="${salesOffice }" />
										</form:select></td>
								<td><font color="red"></font></td>
							</tr>
							
								
									<tr>
									<td colspan="2">
									<c:choose>
									<c:when test="${update}">
									<input type="submit"
										value="<s:message code="label.update"/>"
										class="btn btn-primary" id="updated" />
										</c:when>
										<c:otherwise>
										<input type="submit"
										value="<s:message code="label.update"/> "
										class="btn btn-danger" disabled="disabled" id="sumbnid" />
										</c:otherwise></c:choose>
										</td>

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




