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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subtnId')
								.click(
										function(event) {
											
											 jQuery.validator.addMethod("alphaNumeric", function (value, element) {
											        return this.optional(element) || /^[0-9a-zA-Z][0-9a-zA-Z&_ ]+$/.test(value);
											    });
											 
											$('#addForm')
													.validate(
															{
																rules : {
																	workCenterName : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																	plant_Id: {
																		required : true
																	},
																	capacityCategory_Id: {
																		required : true
																	},
																	workCeterCategory_Id: {
																		required : true
																	},
																	shop_Id: {
																		required : true
																	},
																	
																	
																},
																messages : {
																	workCenterName : {
																		 required: "<font style='color: red;'><b>Work Center is Required.</b></font>",
														                	
															                maxlength: "<font style='color: red;'><b>Work Center only 50 Characters are allowed.</b></font>",
															                
															                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																		
																	},
																		plant_Id : "<font style='color: red;'><b>Plant is Required</b></font>",
																		shop_Id : "<font style='color: red;'><b>Shop is Required</b></font>",
																			capacityCategory_Id : "<font style='color: red;'><b>Capacity Category is Required</b></font>",
																				workCeterCategory_Id : "<font style='color: red;'><b>Work Center Category is Required</b></font>"
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
																	
																	workCenterNameEdit : {
																		required : true,
																		alphaNumeric:true,
																		maxlength: 50
																	},
																	
																	plant_IdEdit: {
																		required : true
																	},
																	
																	capacityCategory_IdEdit: {
																		required : true
																	},
																	
																	workCeterCategory_IdEdit: {
																		required : true
																	},

																},
																messages : {
																	workCenterNameEdit : {
																		
																		required: "<font style='color: red;'><b>Work Center is Required.</b></font>",
													                	
														                maxlength: "<font style='color: red;'><b>Work Center only 50 Characters are allowed.</b></font>",
														                
														                alphaNumeric: "<font style='color: red;'><b>Special Characters are not allowed.</b></font>",
																	},
																	plant_IdEdit : "<font style='color: red;'><b>Plant is Required</b></font>",
																	capacityCategory_IdEdit : "<font style='color: red;'><b>Capacity Category is Required</b></font>",
																	workCeterCategory_IdEdit : "<font style='color: red;'><b>Work Center Category is Required</b></font>"
																},
															});

										});

					});
</script>







<!-- Horizantol scroll -->
<style type="text/css">
#scroll {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 37%;
}
</style>

<!-- Horizantol scroll -->
<style type="text/css">
#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 95%;
}

<
style type ="text/css">.required {
	color: red;
	font-style: Bold;
}

.TabbedPanelsContent {
	border: 5px;
	font-style: Bold;
}
</style>

<script>
	$(document).ready(function() {
		$('#tdToogle').click(function() {
			$('#leftMenu').toggle('800');
		});
	});
</script>
<script>
	$(function() { /*  jldsfgjl;jg;dsgl;df */
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

		$("#add").click(function(e) {
			$("#edit").hide();
			$("#successmessage").hide();
			$("#savemessage").hide();
			$("#tabsForEdit").hide();
			$("#warningmesssage").hide();

		});
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
		$('#search').click(function(e) {
			$('#edit').hide();
			$("#tabsForEdit").hide();

		});
	});
</script>
</head>

<body>
	<div class="divUserDefault">
		<div class="PageTitle">Work Center</div>

		<!-- Tabs Declaration -->

			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<c:forEach var="wcvalues" items="${wcvalues}">
						<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>
					</c:forEach>
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
					<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
				</ul>

				<!-- Search tab part -->

 
				<div id="tabs-2" class="TabbedPanelsContent">
					
						<form:form action="WorkCenterSearch.mnt" method="GET"
							commandName="WorkCeterCommand">
							<table class="tableGeneral">
								<tr>
								<td colspan="2"><c:forEach var="workCenterAdd"
										items="${param.list}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.workCenter"/> <spring:message code="label.saveSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:if test="${param.listwar!=null }">							
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error"/> </strong>
											
								<spring:message code="label.workCenter"/>	<spring:message code="label.saveFail"/>
										</div>	</c:if>
								<c:forEach var="workcenterupdate"
										items="${workcenterupdate}">
										<div class="alert-success" id="successmessage">
											<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.workCenter"/> <spring:message code="label.updateSuccess"></spring:message>
										</div>
									</c:forEach>
							<c:forEach var="workcenterupdateError"
										items="${workcenterupdateError}">
										<div class="alert-danger" id="successmessage">
											<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.workCenter"/> <spring:message code="label.updateFail"></spring:message>
										</div>
									</c:forEach><c:forEach var="workCenterDelete"
										items="${workCenterDelete}">
										<div class="alert-success" id="successmessage">
										<strong><spring:message code="label.success"/></strong>
											<spring:message code="label.workCenter"/> <spring:message code="label.deleteSuccess"></spring:message>
										</div>
									</c:forEach><c:forEach var="workCenterDeleteError"
										items="${workCenterDeleteError}">
										<div class="alert-danger" id="successmessage">
										<strong><spring:message code="label.error"/></strong>
											<spring:message code="label.workCenter"/> <spring:message code="label.deleteFail"></spring:message>
										</div>
									</c:forEach></td>
							</tr>
								
									<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${xmlItems}" />
									</form:select>  <spring:bind path="WorkCeterCommand.operations">
								<select class="select" name="operations">
								<option value="<spring:message code='assignedOperator'/>"><spring:message code="label.equalsTo"/> </option>
								<option value="<spring:message code='notequalsOperator'/>"><spring:message code="label.notEqualsTo"/> </option>
							 <option value="<spring:message code='beginsWithOperator'/>"> <spring:message code="label.beginsWith"/> </option> 
								<option value="<spring:message code='endsWithOperator'/>"><spring:message code="label.endsWith"/> </option>
								<option value="<spring:message code='containsOperator'/>"><spring:message code="label.contains"/></option>
								</select>
									 </spring:bind> <form:input path="basicSearchId" cssClass="textbox" />
									 <c:set
										var="save" value="false"></c:set> <c:set var="edit"
										value="false"></c:set> <c:set var="delete" value="false"></c:set>
									<c:set var="update" value="false"></c:set> <c:set var="search"
										value="false"></c:set> <fmt:setBundle basename="button" /> <fmt:message
										key="label.save" var="messagesav" /> <fmt:message
										key="label.search" var="messagesea" /> <fmt:message
										key="label.delete" var="messagedel" /> <fmt:message
										key="label.update" var="messageup" /> <fmt:message
										key="label.edit" var="messageed" /> <c:forEach
										items="${sessionScope.privilegeList}" var="privileges">
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
											<c:when test="${privileges eq messageup }">
												<c:set var="update" value="true"></c:set>
											</c:when>
										</c:choose>

									</c:forEach>
									
									 <c:choose>
										<c:when test="${search}">
								
								<input type="submit"
									value="<spring:message code="label.search"/>"
									class="btn btn-primary" /></c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" />
										</c:otherwise>
									</c:choose></td>

							</tr>
							</table>
                            </form:form>
							  <c:forEach var="wc" items="${wcvalue}">
                              <c:set var="as" value="${wc}"></c:set>
					          </c:forEach>
						      <c:if test="${as!=null }">		
                <display:table id="workCenter" name="workCenter"
								requestURI="WorkCenterSearch.mnt" pagesize="4" class="table">
								<display:column property="workCenterName"
									title="Work Center Name" media="html" sortable="true"></display:column>
								<display:column property="plantName" title="Plant"
									media="html" sortable="true"></display:column>
								<display:column property="capcategory" title="Capacity Category"
									media="html" sortable="true"></display:column>
								<display:column property="workCeterCategory" title="Work Ceter Category"
									media="html" sortable="true"></display:column>

										<display:column title="Edit" style="color:white">
										<c:choose>
							<c:when test="${edit }">
									<a
										href="workcenterEditHome.mnt?workcenterId=<c:out value="${workCenter.workCenter_Id}"/>"
										style="color: red"><img src="images/Edit.jpg" width="20px"
										height="20px" /> </a>
										</c:when>
									<c:otherwise>
									<a><img src="images/Edit.jpg" width="20px"
									height="20px"  class="btn btn-danger"  /></a>
									</c:otherwise>
									</c:choose>
									
								</display:column>
									<display:column title="Delete">
									<c:choose>
							<c:when test="${delete }">
							<a
								href="workcenterDelete.mnt?workcenterId=<c:out value="${workCenter.workCenter_Id}"/>"
								style="color: red"
								onclick="return confirm('Do u want to delete the Record?')"><img
								src="images/Delete.jpg" width="20px" height="20px" /></a>
								</c:when>
							<c:otherwise>
							
								<a><img
									src="images/Delete.jpg" class="btn btn-danger" width="20px" height="20px" /></a>
							</c:otherwise>
							</c:choose>
						        </display:column>
						
						
								<!-- For displaying the pagination part -->

								<display:setProperty name="paging.banner.placement"
									value="bottom" />
								<display:setProperty name="paging.banner.group_size" value="3" />
								<display:setProperty name="paging.banner.some_items_found"
									value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
							    </display:table>

</c:if>
				
				</div>
				
				<!-- Add tab details -->

				
					<div id="tabs-3" class="TabbedPanelsContent">
						<div align="left" class="TabbedPanelsContent">
						
						
                       	<form:form action="WorkCeteradd.mnt" method="POST" 
					            commandName="WorkCeterCommand" id="addForm" >
							
							
								<form:hidden path="aid" />
						<table class="tableGeneral">
							 <tr>
								<td colspan="2"><c:forEach
										var="addWorkCentreDuplicate"
										items="${addWorkCentreDuplicate}">
										<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.workCenter"/> <spring:message code="label.duplicateCheck"></spring:message>
										</div>
									</c:forEach></td>
							</tr> 
							
								<tr>
									<td><spring:message code="label.workCenter" /><font color="red">*</font></td>
									<td><form:input path="workCenterName" id="work" class="textbox"/></td>
								
									
								</tr>
								<tr>
											<td><spring:message code="label.plant" /><font color="red">*</font></td>
									<td><form:select path="plant_Id" id="plant_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${plant }" />
										</form:select></td>
								</tr>
								
									<tr>
											<td><spring:message code="label.shop" /><font color="red">*</font></td>
									<td><form:select path="shop_Id" id="shop_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${shop }" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.capacityCategory" /><font color="red">*</font></td>
									<td><form:select path="capacityCategory_Id" id="capacityCategory_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${CapacityCategory }" />
										</form:select></td>
									
								</tr>
									<tr>
									<td><spring:message code="label.workCenterCategory" /><font color="red">*</font></td>
									<td><form:select path="workCeterCategory_Id" id="workCeterCategory_Id"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${WorkCeterCategory }" />
										</form:select></td>
									
								</tr>
                              
							<tr>
								<td colspan="2"><c:choose>
									<c:when test="${save}"><input type="submit"
									value="<spring:message code="label.save"/>" id="subtnId"
									class="btn btn-primary" /></c:when>
									<c:otherwise>
										<input type="submit" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" id="sumbnid" /> 
									</c:otherwise>

								</c:choose>
								<input type="reset"
									value="<spring:message code="label.reset"/>"
									class="btn btn-primary" /></td>
							</tr>
				</table>
							
							</form:form>
						
						
					</div>
			</div>
			
				<!-- Edit tab -->

				<div id="tabs-1">
					
						<c:forEach var="wcvalues" items="${wcvalues}">
						<form:form action="WorkCeterEdit.mnt" method="POST" commandName="WorkCeterCommand" id="editForm">
						
								<table class="tableGeneral">
							
								
								
									<tr>
									<td colspan="2"><c:forEach
											var="editWorkCentreDuplicate"
											items="${editWorkCentreDuplicate}">
											<div class="alert-warning" id="savemessage">
											<strong><spring:message code="label.warning"/></strong>
											<spring:message code="label.workCenter"/> <spring:message code="label.duplicateCheck"></spring:message>
										
											</div>
										</c:forEach></td>
								</tr>
									<form:hidden path="workCenter_IdEdit" id="workCenter_IdEdit" />
									<tr>
									<td><spring:message code="label.workCenter" /><font color="red">*</font></td>
								
												<td><form:input path="workCenterNameEdit"
														id="workCenterNameEdit" class="textbox"/></td>
							
								</tr>
								<tr>
											<td><spring:message code="label.plant" /><font color="red">*</font></td>
									<td><form:select path="plant_IdEdit" id="plant_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${plant }" />
										</form:select></td>
								</tr>
								
								<tr>
											<td><spring:message code="label.shop" /><font color="red">*</font></td>
									<td><form:select path="shop_IdEdit" id="shop_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${shop }" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.capacityCategory" /><font color="red">*</font></td>
									<td><form:select path="capacityCategory_IdEdit" id="capacityCategory_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${CapacityCategory }" />
										</form:select></td>
									
								</tr>
									<tr>
									<td><spring:message code="label.workCenterCategory" /><font color="red">*</font></td>
									<td><form:select path="workCeterCategory_IdEdit" id="workCeterCategory_IdEdit"
											class="select" cssStyle="height:25px">
											<form:option value="">---Select---</form:option>
											<form:options items="${WorkCeterCategory }" />
										</form:select></td>
									
								</tr>
								<tr>
									<td colspan="2"><c:choose>
										<c:when test="${update}"><input type="submit"
										value="<spring:message code="label.update"/>"
										class="btn btn-primary" id="updated" /></c:when>
										<c:otherwise>
											<td><input type="submit" disabled="disabled"
												value="<spring:message code="label.update"/>"
												class="btn btn-danger" id="updateId" /></td>
										</c:otherwise>

									</c:choose></td>

								</tr>
								</table>

						</form:form>
					</c:forEach>
			
					</div>
					</div>
				
			</div>
</body>

</html>




