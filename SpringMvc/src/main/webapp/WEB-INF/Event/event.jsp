<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event</title>
<link rel="stylesheet" href="/resources/demos/style.css"
	rel="stylesheet" />
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
<script type="text/javascript" src="js/timepicker.js"></script>



<!--  Date picker -->
<script type="text/javascript">
  function dateFun(datePattern) {
    $("#tabs,#tab").tabs();
    $('#fromDateId,#toDateId,#fromDateIdEdit,#toDateIdEdit').datepicker({
      dateFormat: datePattern,
      changeMonth: true,
      changeYear: true
    });
    
  }
  $(document).ready(function(){
	  $('#fromTMId,#toTMId,#fromTMIdEdit,#toTMIdEdit').timepicker(); 
  });
</script>
<!-- duplicate check -->
<script type="text/javascript">
function AjaxForDuplicate() {
	var eventName = $('#eventID').val();
	//alert(eventName);
	$
			.ajax({
				type : "POST",
				url : "checkEventAddDuplicate.mnt",
				data : "eventID=" + eventName,
				success : function(response) {
				 // alert(response);
					if (response != "") {
						document.getElementById("eventDuplMessage").style.display = "block";
						//$('#salesDuplMessage').html(response);
						$('#subtnId').hide();

					} else {
						document.getElementById("eventDuplMessage").style.display = "none";
						$('#subtnId').show();
					}

				},
				error : function(e) {
					//alert('Error' + e);
				}

			});

}

function AjaxUpdateDuplicate() {
	var cust = $('#eventEdit').val();
	var id = $('#eventIdEdit').val();
	//alert(cust);
	$
			.ajax({
				type : "POST",
				url : "checkEventUpdateDuplicate.mnt",
				data : "eventEdit=" + cust+"&eventIdEdit="+id,
				success : function(response) {
					if (response != "") {
						document.getElementById("eventUpDuplMessage").style.display = "block";
						//$('#salesUpDuplMessage').html(response);
						$('#updated').hide();

					} else {
						document.getElementById("eventUpDuplMessage").style.display = "none";
						$('#updated').show();
					}

				},
				error : function(e) {
					//alert('Error' + e);
				}

			});
}

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
                    $('#subtnId')
                            .click(
                                    function(event) {

                                      $('#addForm')
                                              .validate(
                                                      {
                                                        rules: {
                                                          event: {
                                                            required: true,
                                                            alphanumeric: true,
                                                            specialcharacters: true
                                                          },
                                                          fromDate: {
                                                            required: true
                                                          },
                                                          toDate: {
                                                            required: true

                                                          },
                                                          fromTM: {
                                                            required: true
                                                          },
                                                          toTM: {
                                                            required: true
                                                          },
                                                          contactPerson: {
                                                            required: true
                                                           
                                                          },
                                                          venue: {
                                                            required: true
                                                          },
                                                          contactPhone: {
                                                            required: true,
                                                            number: true,
                                                            minlength:10
                                                          },
                                                          reference: {
                                                            required: true
                                                          }

                                                        },
                                                        /*  errorPlacement :function(error){
                                                        	return false;
                                                        }, */
                                                        messages: {
                                                          event: {
                                                            required: "<font style='color: red;'><b>Event is Required</b></font>",
                                                            alphanumeric: "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
                                                            specialcharacters: "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
                                                          },
                                                          fromDate: "<font style='color: red;'><b>From date is Required</b></font>",
                                                          toDate: "<font style='color: red;'><b>To date is Required</b></font>",
                                                          fromTM: "<font style='color: red;'><b> From TM is Required</b></font>",
                                                          toTM: "<font style='color: red;'><b>To TM is Required</b></font>",
                                                          venue: "<font style='color: red;'><b>Venue is Required</b></font>",
                                                          contactPerson: {
                                                            required: "<font style='color: red;'><b>Contact person is Required</b></font>"
                                                           
                                                          },
                                                          contactPhone:{
                                                        	  required:"<font style='color: red;'><b>Contact phone is Required</b></font>",
                                                        	  number: "<font style='color: red;'><b>Contact Phone must be a number</b></font>",
                                                        	  minlength: "<font style='color: red;'><b>Length must be Minimum 10 Digits </b></font>"
                                                          },
                                                          reference: "<font style='color: red;'><b>Reference is Required</b></font>",
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
                                                        rules: {
                                                          event: {
                                                            required: true,
                                                            alphanumeric: true,
                                                            specialcharacters: true
                                                          },
                                                          fromDate: {
                                                            required: true
                                                          },
                                                          toDate: {
                                                            required: true

                                                          },
                                                          fromTM: {
                                                            required: true
                                                          },
                                                          toTM: {
                                                            required: true
                                                          },
                                                          contactPerson: {
                                                            required: true
                                                           
                                                          },
                                                          venue: {
                                                            required: true
                                                          },
                                                          contactPhone: {
                                                            required: true,
                                                            number: true,
                                                            minlength:10
                                                          },
                                                          reference: {
                                                            required: true
                                                          }

                                                        },
                                                        /*  errorPlacement :function(error){
                                                        	return false;
                                                        }, */
                                                        messages: {
                                                          event: {
                                                            required: "<font style='color: red;'><b>Event is Required</b></font>",
                                                            alphanumeric: "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
                                                            specialcharacters: "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
                                                          },
                                                          fromDate: "<font style='color: red;'><b>From date is Required</b></font>",
                                                          toDate: "<font style='color: red;'><b>To date is Required</b></font>",
                                                          fromTM: "<font style='color: red;'><b> From TM is Required</b></font>",
                                                          toTM: "<font style='color: red;'><b>To TM is Required</b></font>",
                                                          venue: "<font style='color: red;'><b>Venue is Required</b></font>",
                                                          contactPerson: {
                                                            required: "<font style='color: red;'><b>Contact person is Required</b></font>"
                                                           
                                                          },
                                                          contactPhone:{
                                                        	  required:"<font style='color: red;'><b>Contact phone is Required</b></font>",
                                                        	  number: "<font style='color: red;'><b>Contact Phone must be a number</b></font>",
                                                        		  minlength: "<font style='color: red;'><b>Length must be Minimum 10 Digits </b></font>"
                                                          },
                                                          reference: "<font style='color: red;'><b>Reference is Required</b></font>",
                                                        },

                                                      });
                                    });

                  });
</script>


<script type="text/javascript">
  $(document).ready(function() {

    if (document.getElementById("eId").value == 1) {

      var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

      $('#tabs').tabs({
        active: index
      });
    }

  });
</script>

<script type="text/javascript">
  $(document).ready(function() {
    $('#sumbnasid').click(function(e) {
      document.getElementById("eId").value = 1;
      //alert(document.getElementById("atId").value);
    });
  });
</script>

<script type="text/javascript">
  $(document).ready(function() {
    $('#add,#search').click(function(e) {
      $('#edit').hide();
      $('#successmessage').hide();
      $('#savemessage').hide();
      $('#eventID').val('');
      $('#fromDateId').val('');
      $('#toDateId').val('');
      $('#fromTMId').val('');
      $('#toTMId').val('');
      $('#contactPersonId').val('');
      $('#contactPhoneId').val('');
      $('#venueId').val('');
      $('#referenceId').val('');
    });
  });
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">Event</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="EventEdit" items="${EventEdit}">
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
					<form:form method="get" action="EventSearch.mnt"
						commandName="eventCmd">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="addEventsus"
										items="${param.addEventsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.event" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach var="addEventFail" items="${param.addEventFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.event" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach var="updateEventsus"
										items="${param.updateEventsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.event" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach var="updateEventFail"
										items="${param.updateEventFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.event" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach var="deleteEventsus"
										items="${param.deleteEventsus}">
										<div class="alert-success" id="savemessage">
											<strong><spring:message code="label.success" /> </strong>
											<spring:message code="label.event" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach var="deleteEventFail"
										items="${param.deleteEventFail}">
										<div class="alert-danger" id="savemessage">
											<strong><spring:message code="label.error" /> </strong>
											<spring:message code="label.event" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td><spring:message code="label.searchby" /></td>
								<td><form:select path="xmlLabel" cssClass="select">

										<form:options items="${xmlItems}" />
									</form:select> <spring:bind path="eventCmd.operations">
										<select class="select" name="operations">
											<option value="<spring:message code='assignedOperator'/>">
												<spring:message code="label.equalsTo" />
											</option>
											<option value="<spring:message code='notequalsOperator'/>">
												<spring:message code="label.notEqualsTo" />
											</option>
											<option value="<spring:message code='beginsWithOperator'/>">
												<spring:message code="label.beginsWith" />
											</option>
											<option value="<spring:message code='endsWithOperator'/>">
												<spring:message code="label.endsWith" />
											</option>
											<option value="<spring:message code='containsOperator'/>">
												<spring:message code="label.contains" />
											</option>
										</select>
									</spring:bind> <form:input path="basicSearchId" cssClass="textbox" /></td>
								<c:set var="save" value="true"></c:set>
								<c:set var="edit" value="true"></c:set>
								<c:set var="delete" value="true"></c:set>
								<c:set var="update" value="true"></c:set>
								<c:set var="search" value="true"></c:set>
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
									<c:when test="${true}">
										<td><input type="submit"
											value="<spring:message code="label.search"/>"
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" disabled="disabled"
											value="<spring:message code="label.search"/>"
											class="btn btn-danger" /></td>
									</c:otherwise>
								</c:choose>
							</tr>

						</table>
					</form:form>


					<c:if test="${EventList!=null }">
						<display:table name="EventList" id="eventList" class="table"
							requestURI="EventSearch.mnt" pagesize="5">
							<display:column property="eventId" sortable="true"
								title="EventId" media="none" />
							<display:column property="event" sortable="true"
								titleKey="label.event" media="html" />
							<display:column property="fromDate" sortable="true"
								titleKey="label.fromDate" media="html" />
							<display:column property="toDate" sortable="true"
								titleKey="label.toDate" media="html" />
							<display:column property="fromTM" sortable="true"
								titleKey="label.fromTM" media="html" />
							<display:column property="toTM" sortable="true"
								titleKey="label.toTM" media="html" />
							<display:column property="venue" sortable="true"
								titleKey="label.venue" media="html" />
							<display:column property="contactPerson" sortable="true"
								titleKey="label.contactPerson" media="html" />
							<display:column property="contactPhone" sortable="true"
								titleKey="label.contactPhone" media="html" />
							<display:column property="reference" sortable="true"
								titleKey="label.reference" media="html" />

							<display:column titleKey="label.edit">
								<c:choose>
									<c:when test="${true}">
										<a
											href="EventEdit.mnt?EventId=<c:out value="${eventList.eventId}"/> "><img
											src="images/Edit.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column titleKey="label.delete">
								<c:choose>
									<c:when test="${true}">
										<a
											href="EventDelete.mnt?EventId=<c:out value="${eventList.eventId}"/> "
											onclick="return confirm('Do You Want To Delete This Record?')"><img
											src="images/Delete.jpg" width="20px" height="20px" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" class="btn btn-danger"
											width="20px" height="20px" /></a>
									</c:otherwise>
								</c:choose>
							</display:column>

							<display:setProperty name="paging.banner.placement"
								value="bottom" />
						</display:table>

					</c:if>

				</div>

			</div>

			<!-- Tab-3 -->

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<table>
						<tr>
							<td colspan="2" id="eventDuplMessage" style="display: none;"
								class="alert-warning">
								<div>
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.event" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
					<form:form action="EventAdd.mnt" id="addForm" method="POST"
						commandName="eventCmd">
						<form:hidden path="eId" />
						<table class="tableGeneral">

							<tr>
								<td><spring:message code="label.event" /><span
									class="required">*</span></td>
								<td><form:input path="event" cssClass="textbox" id="eventID" onkeyup="AjaxForDuplicate()"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.fromDate" /><span
									class="required">*</span></td>
								<td><form:input path="fromDate" cssClass="textbox"
										id="fromDateId" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.toDate" /><span
									class="required">*</span></td>
								<td><form:input path="toDate" cssClass="textbox"
										id="toDateId" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.fromTM" /><span
									class="required">*</span></td>
								<td><form:input path="fromTM" cssClass="textbox"
										id="fromTMId" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.toTM" /><span
									class="required">*</span></td>
								<td><form:input path="toTM" cssClass="textbox" id="toTMId" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.venue" /><span
									class="required">*</span></td>
								<td><form:input path="venue" cssClass="textbox"
										id="venueId" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.contactPerson" /><span
									class="required">*</span></td>
								<td><form:input path="contactPerson" cssClass="textbox"
										id="contactPersonId" /></td>
							</tr>
							<tr>
								<td><spring:message code="label.contactPhone" /><span
									class="required">*</span></td>
								<td><form:input path="contactPhone" cssClass="textbox"
										id="contactPhoneId" maxlength="12"/></td>
							</tr>
							<tr>
								<td><spring:message code="label.reference" /><span
									class="required">*</span></td>
								<td><form:input path="reference" cssClass="textbox"
										id="referenceId" /></td>
							</tr>


							<tr>
								<c:choose>
									<c:when test="${true}">
										<td><input type="submit" id="subtnId"
											value='<spring:message code="label.save"/>'
											class="btn btn-primary" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:when>
									<c:otherwise>
										<td><input type="submit" id="subtnId" disabled="disabled"
											value='<spring:message code="label.save"/>'
											class="btn btn-danger" /><input type="reset"
											value='<spring:message code="label.reset"/>'
											class="btn btn-primary" /></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</table>
					</form:form>

				</div>
			</div>

			<!-- Tab-1 -->

			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<c:forEach var="EventEdit" items="${EventEdit}">
					<table>
						<tr>
							<td colspan="2" id="eventUpDuplMessage" style="display: none;"
								class="alert-warning">
								<div>
									<strong> <spring:message code="label.warning" /></strong>
									<spring:message code="label.event" />
									<spring:message code="label.duplicateCheck" />
								</div>
							</td>
						</tr>
					</table>
						<form:form method="post" action="EventUpdate.mnt"
							commandName="eventCmd" id="editForm">
							<table class="tableGeneral">
								

								<form:hidden path="eventId" id="eventIdEdit" />
								<tr>
									<td><spring:message code="label.event" /><span
										class="required">*</span></td>
									<td><form:input path="event" cssClass="textbox"
											id="eventEdit" onkeyup="AjaxUpdateDuplicate()" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.fromDate" /><span
										class="required">*</span></td>
									<td><form:input path="fromDate" cssClass="textbox"
											id="fromDateIdEdit" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.toDate" /><span
										class="required">*</span></td>
									<td><form:input path="toDate" cssClass="textbox"
											id="toDateIdEdit" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.fromTM" /><span
										class="required">*</span></td>
									<td><form:input path="fromTM" cssClass="textbox"
											id="fromTMIdEdit" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.toTM" /><span
										class="required">*</span></td>
									<td><form:input path="toTM" cssClass="textbox"
											id="toTMIdEdit" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.venue" /><span
										class="required">*</span></td>
									<td><form:input path="venue" cssClass="textbox"
											id="venueIdEdit" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.contactPerson" /><span
										class="required">*</span></td>
									<td><form:input path="contactPerson" cssClass="textbox"
											id="contactPersonIdEdit" /></td>
								</tr>
								<tr>
									<td><spring:message code="label.contactPhone" /><span
										class="required">*</span></td>
									<td><form:input path="contactPhone" cssClass="textbox"
											id="contactPhoneIdEdit" maxlength="12"/></td>
								</tr>
								<tr>
									<td><spring:message code="label.reference" /><span
										class="required">*</span></td>
									<td><form:input path="reference" cssClass="textbox"
											id="referenceIdEdit" /></td>
								</tr>
								<tr>
									<c:choose>

										<c:when test="${true}">

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-primary" id="updated" /></td>
										</c:when>

										<c:otherwise>

											<td><input type="submit"
												value="<spring:message code="label.update"/> "
												class="btn btn-danger" disabled="disabled" id="updated" /></td>
										</c:otherwise>
									</c:choose>
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