<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>

<script type="text/javascript">

	$(document)
			.ready(
					function() {
						//AddForm Validations
						$('#subid')
								.click(
										function(event) {
											
											$('#addprocessform')
													.validate(
															{
																rules : {
																	process : {
																		required : true },
																		'processseq':{
																			required : true	
																		},
																		processtypeid:{
																			required : true	
																		},
																		processdescription:{
																			required : true	
																		},
																		predessor:{
																			required : true	
																		},
																		successor:{
																			required : true	
																		},
																		stageinspection:{
																			required : true	
																		},
																		serialcontrol:{
																			required : true
																		}, 
																		inspectionpct:{
																			required : true
																			
																		}, 
																},
																messages : {
																	process : "<font style='color: red;'><b>Process is Required</b></font>",
																	processseq : "<font style='color: red;'><b>Process Sequence is Required</b></font>",
																	processtypeid : "<font style='color: red;'><b>Process Type Id  is Required</b></font>",
																	processdescription : "<font style='color: red;'><b>Process Description is Required</b></font>",
																	predessor : "<font style='color: red;'><b>Predessor is Required</b></font>",
																	successor : "<font style='color: red;'><b>Successor is Required</b></font>",
																	stageinspection : "<font style='color: red;'><b>Stage Inspection is Required</b></font>",
																	serialcontrol : "<font style='color: red;'><b>Serial Control is Required</b></font>", 
																		inspectionpct : "<font style='color: red;'><b>Inspection PCT is Required</b></font>"
																},

															});
										});
						//UpdateForm Validations
						 $('#updateid')
								.click(
										function(event) {
											//alert("hai");
											$('#editprocessForm')
													.validate(
															{
																rules : {
																	processedit : {
																		required : true },
																		processseqedit:{
																			required : true	
																		},
																		processtypeidedit:{
																			required : true	
																		},
																		processdescriptionedit:{
																			required : true	
																		},
																		predessoredit:{
																			required : true	
																		},
																		successoredit:{
																			required : true	
																		},
																		stageinspectionedit:{
																			required : true	
																		},
																		serialcontroledit:{
																			required : true
																		}, 
																		inspectionpctedit:{
																			required : true
																			
																		}, 
																},
																messages : {
																	processedit : "<font style='color: red;'><b>Process is Required</b></font>",
																	processseqedit : "<font style='color: red;'><b>Process Sequence is Required</b></font>",
																	processtypeidedit : "<font style='color: red;'><b>Process Type Id  is Required</b></font>",
																	processdescriptionedit : "<font style='color: red;'><b>Process Description is Required</b></font>",
																	predessoredit : "<font style='color: red;'><b>Predessor is Required</b></font>",
																	successoredit : "<font style='color: red;'><b>Successor is Required</b></font>",
																	stageinspectionedit : "<font style='color: red;'><b>Stage Inspection is Required</b></font>",
																	serialcontroledit : "<font style='color: red;'><b>Serial Control is Required</b></font>", 
																		inspectionpctedit : "<font style='color: red;'><b>Inspection PCT is Required</b></font>"
																},
															});

										}); 

					});
</script>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
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

<script>
	function handleChange(input) {
		if (input.value < 0)
			input.value = 0;
		if (input.value > 100)
			input.value = 100;
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
	$(document).ready(function() {
		if (document.getElementById("processhide").value == 1) {
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
			var aid = document.getElementById("processhide").value = 1;
		});
	});
</script>
<script type="text/javascript">
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
		else if ((("0123456789").indexOf(keychar) > -1))
			return true;

		// decimal point jump
		else if (dec && (keychar == ".")) {
			myfield.form.elements[dec].focus();
			return false;
		} else
			return false;
	}
</script>


<script type="text/javascript">
	function doAjaxPost() {

		//get the form values

		var processname = $('#process').val();

		$.ajax({

					type : "POST",

					url : "/MNTERP/processDuplicateCheck.mnt",

					data : "processname=" + processname,

					success : function(response) {

						var checkResponse = "Warning ! Process already Exists";
						if (checkResponse == response) {
							document.getElementById("ProcessDupMessage").style.display = "block";
							$('#ProcessDupMessage').html(response);
						} else {
							document.getElementById("ProcessDupMessage").style.display = "none";
						}
					},

					error : function(e) {

						alert('Error: ' + e);

					}

				});

	}
</script>
<script type="text/javascript">
	function doAjaxPostEdit() {

		//get the form values

		var processnameedit = $('#processedit').val();
		var processid = $('#processidedit').val();

		$
				.ajax({

					type : "POST",

					url : "/MNTERP/processDuplicateEditCheck.mnt",

					data : "processnameedit=" + processnameedit + "&processid="
							+ processid,

					success : function(response) {

						var checkResponse = "Warning ! Process already Exists";
						
						if (checkResponse == response) {
							document.getElementById("ProcessDupEditMessage").style.display = "block";
							$('#ProcessDupEditMessage').html(response);
						} else {
							document.getElementById("ProcessDupEditMessage").style.display = "none";
						}
					},

					error : function(e) {

						alert('Error: ' + e);

					}

				});

	}
</script>
<script type="text/javascript">
	function processdescAjax() {

		//get the form values

		var processdesc = $('#processdescription').val();

		$
				.ajax({

					type : "POST",

					url : "/MNTERP/processdescriptionDuplicateCheck.mnt",

					data : "processdesc=" + processdesc,

					success : function(response) {

						var checkResponse = "Warning ! Process Description already Exists";
						if (checkResponse == response) {
							document.getElementById("ProcessdescDupMessage").style.display = "block";
							$('#ProcessdescDupMessage').html(response);
						} else {
							document.getElementById("ProcessdescDupMessage").style.display = "none";
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
		<div class="PageTitle">Process</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="editvalues" items="${editvalues}">
					<c:set var="editvalues" value="${editvalues }"></c:set>
				</c:forEach>
				<c:if test="${editvalues!=null}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:if>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchProcess.mnt" method="GET"
						commandName="Process">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach var="accountsuccess"
										items="${param.list}">
										<div class="alert-success" id="savemessage">

											<c:out value="${param.success}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<tr>
								<td colspan="2"><c:forEach var="ProcessUpdate"
										items="${ProcessUpdate}">
										<div class="alert-success" id="successmessage">
											<strong>Success!</strong>
											<c:out value="${ProcessUpdate}"></c:out>
										</div>
									</c:forEach></td>
							</tr>
							<%-- <tr>
								<td>Process</td>
								<td><form:select path="processid" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="0" class="select">All</form:option>
										<form:options items="${processSearch}" />
									</form:select></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary" /></td>
							</tr> --%>
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

					<c:forEach var="processBeans" items="${processBeans}">
						<c:set var="ag" value="${processBeans}"></c:set>
					</c:forEach>
					<c:if test="${ag!=null}">
						<display:table id="processingid" name="processBeans"
							requestURI="searchProcess.mnt" pagesize="5" class="table">
							<display:column property="processid" title="ProcessID"
								media="none" sortable="true"></display:column>
							<display:column property="process" title="Process" media="html"
								sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<a
									href="processEdit.mnt?processedit=<c:out value="${processingid.processid}"/>"
									style="color: red"><img src="images/Edit.jpg" width="20px"
									height="20px" /> </a>
							</display:column>
							<display:column title="Delete">
								<a
									href="processDelete.mnt?processdelete=<c:out value="${processingid.processid}"/>"
									style="color: red"><img src="images/Delete.jpg"
									width="20px" height="20px"
									onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
							</display:column>
							<display:setProperty name="paging.banner.placement"
								value="bottom" />

						</display:table>
					</c:if>

				</div>
			</div>

			<div id="tabs-3" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="saveProcess.mnt" method="GET"
						commandName="Process" id="addprocessform">

						<table class="tableGeneral">
							<%-- <td colspan="2"><c:forEach var="processdup"
										items="${processdup}">
										<div class="alert-warning" id="successmessage">

											<font color="red"> <c:out value="${processdup}"></c:out></font>
										</div>
									</c:forEach></td> --%>

							<tr>
								<td>Process<span class="required">*</span></td>
								<td><form:input path="process" id="process" class="textbox"
										onkeyup="doAjaxPost()"/></td>
								<td class="alert-warning" id="ProcessDupMessage"
									style="display: none;width:250px; "></td>
								<td class="alert-warning" id="ProcessdescDupMessage"
									style="display: none;width:300px; "></td>
							</tr>
						</table>

						<!-- window 2 -->

						<div id="tabss" align="center">
							<ul>

								<li><a href="#tab1">Process Detail</a></li>

							</ul>

							<!-- Tab-1 -->

							<div align="left">
								<div style="overflow-y:hidden;overflow-x:scroll;" class = 'scroll1'>
									<table class="table">
										<tr>
											<th>Process Seq<span class="required">*</span></th>
											<th>Process Type<span class="required">*</span></th>
											<th>Process Description<span class="required">*</span></th>
											<th>Predessor<span class="required">*</span></th>
											<th>Successor<span class="required">*</span></th>
											<th>Stage Inspecion<span class="required">*</span></th>
											<th>Serial Control<span class="required">*</span></th>
											<th>Inspection PCT<span class="required">*</span></th>
										</tr>
										<form:hidden path="processhide" />
										<tr>
											<td align="center"><form:input path="processseq"
													cssClass="textboxsmall" /></td>
											<td><form:select path="processtypeid" class="select"
													cssStyle="height:25px;">
													<form:option value="0">--Select--</form:option>
													<form:options items="${processtypesearch}" />
												</form:select></td>


											<td><form:textarea path="processdescription" id="processdescription" class="textarea"
										onkeyup="processdescAjax()" /></td>

											<td align="center"><form:input path="predessor"
													cssClass="textboxsmall" /></td>
										
											<td align="center"><form:input path="successor"
													cssClass="textboxsmall" /></td>
											<td align="center"><form:checkbox path="stageinspection"
													value="0" class="checkbox"></form:checkbox></td>
											<td align="center"><form:checkbox path="serialcontrol"
													value="0" class="checkbox"></form:checkbox></td>
											<td><form:input path="inspectionpct"
													cssClass="textboxsmall"
													onKeyPress="return numbersonly(this, event)" maxlength="3" /></td>
											<td><a href="#" id="addCust"><img
													src="images/add (1).png"></img> </a></td>

										</tr>

										<tr>
										<td>
											<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
											<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
											<script type="text/javascript" src="js/jquery.validate.min.js"></script>
											<script type="text/javascript">
												$(function() {

													var row = '<table border="0" ><tr><td>'
															+ '<table border="0" class="table" style="float:left;"><tr><td><form:input path="processseq" value="" cssClass="textboxsmall" /></td><td><form:select path="processtypeid" class="select" cssStyle="height:25px"><form:option value="0">--Select--</form:option><form:options items="${processtypesearch}" /></form:select></td>'
															+ '<td><form:textarea path="processdescription"  cssClass="textarea" /></td><td><form:input path="predessor" cssClass="textboxsmall" /></td><td><form:input path="successor" cssClass="textboxsmall" /></td><td align="center"><form:checkbox path="stageinspection" value="0"  class="checkbox"></form:checkbox></td><td align="center"><form:checkbox path="serialcontrol" value="0"  class="checkbox" ></form:checkbox></td><td><form:input path="inspectionpct" cssClass="textboxsmall" onKeyPress="return numbersonly(this, event)" maxlength="3" /></td>'
															+ '</tr></table>'
															+ '<a href="#"  style="float:left; margin:0px 0 0 5px;" class="removerow"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
													//fadeIn
													$('#addCust')
															.click(
																	function() {
																		$(row)
																				.fadeIn(
																						"slow")
																				.appendTo(
																						"#newrow");
																		i++;
																		return false;

																	});

													//fadeout selected item and remove
													$('.removerow')
															.live(
																	'click',
																	function() {
																		$(this)
																				.parent()
																				.fadeOut(
																						300,
																						function() {
																							$(
																									this)
																									.empty();
																							return false;
																						});
																	});

												});
											</script>
</td>
										</tr>

									</table>
									<div id="newrow"></div>
									<table>
										<tr>
											<td colspan="2"><input type="submit" value="Save"
												class="btn btn-primary" id="subid" /><input type="reset"
												class="btn btn-primary" /></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="processUpdate.mnt" method="POST"
						commandName="Process" id="editprocessForm">
						<c:forEach var="editvalues" items="${editvalues }">
							<c:set var="edit" value="${editvalues}"></c:set>
						</c:forEach>
						<c:if test="${edit!=null}">

							<!-- <div class="alert-warning" id="ProcessDupEditMessage" style="display: none;width:250px;"></div> -->
							<table class="tableGeneral">

								<%-- <tr>
									<td colspan="2"><c:forEach var="processduplicatemessage"
											items="${processduplicatemessage}">
											<div class="alert-warning" id="savemessage">
												<font color="red"><c:out
														value="${processduplicatemessage}"></c:out></font>
											</div>
										</c:forEach></td>
								</tr> --%>
								<form:hidden path="processidedit" />
								<form:hidden path="processhideedit" />
								<tr>
									<td>Process<span class="required">*</span></td>
									<td><form:input path="processedit" class="textbox"
											onkeyup="doAjaxPostEdit()" /></td>
									<td class="alert-warning" id="ProcessDupEditMessage"
										style="display: none;width:250px;"></td>
								</tr>
							</table>
							<div id="tabss" align="center">
								<ul>

									<li><a href="#tab1">Process Detail</a></li>

								</ul>

								<div align="left">
									<div style="overflow-y:hidden;overflow-x:scroll;">
										<table class="table">

											<tr>
												<th>Process Seq<span class="required">*</span></th>
												<th>Process Type<span class="required">*</span></th>
												<th>Process Description<span class="required">*</span></th>
												<th>Predessor<span class="required">*</span></th>
												<th>Successor<span class="required">*</span></th>
												<th>Stage Inspecion<span class="required">*</span></th>
												<th>Serial Controller<span class="required">*</span></th>
												<th>Inspection PCT<span class="required">*</span></th>
											</tr>

											<c:forEach items="${processDetailBeans}"
												var="processDetailBeans">

												<tr>
													<td><spring:bind path="Process.processdetailidedit">
															<input type="hidden" name="processdetailidedit"
																value="${processDetailBeans.processdetailidedit}" />
														</spring:bind></td>

												</tr>
												<tr>
													<td><spring:bind path="Process.processseqedit">
															<input type="text" name="processseqedit" class="textbox"
																value="${processDetailBeans.processseqedit}" />
														</spring:bind></td>

													<td><form:select path="processtypeidedit"
															class="select" cssStyle="height:25px">
															<form:option value="0">--Select--</form:option>
															<form:options items="${processtypesearch}" />
														</form:select></td>

													<td><spring:bind path="Process.processdescriptionedit">
															<input type="text" name="processdescriptionedit"
																class="textarea"
																value="${processDetailBeans.processdescriptionedit}" />
														</spring:bind></td>
													<td><spring:bind path="Process.predessoredit">
															<input type="text" name="predessoredit"
																class="textboxsmall"
																value="${processDetailBeans.predessoredit}" />
														</spring:bind></td>
													<td><spring:bind path="Process.successoredit">
															<input type="text" name="successoredit"
																class="textboxsmall"
																value="${processDetailBeans.successoredit}" />
														</spring:bind></td>
													<td align="center"><spring:bind
															path="Process.stageinspectionedit">
															<input type="checkbox" name="stageinspectionedit"
																class="checkbox" checked="checked" value="1" />
														</spring:bind></td>
													<td align="center"><spring:bind
															path="Process.serialcontroledit">
															<input type="checkbox" name="serialcontroledit"
																class="checkbox" checked="checked" value="1" />
														</spring:bind></td>
													<td><spring:bind path="Process.inspectionpctedit">
															<input type="text" name="inspectionpctedit"
																class="textboxsmall"
																onKeyPress="return numbersonly(this, event)" maxlength="3" 
																value="${processDetailBeans.inspectionpctedit}" />
														</spring:bind></td>
													<td><a href="#" id="addCust2"><img
															src="images/add (1).png"></img> </a></td>
												</tr>

												<c:set var="data" value="${processDetailBeans }"></c:set>
											</c:forEach>
											<%-- <c:if test="${data==null}">

												<tr>
													<spring:bind path="Process.processdetailidedit">
														<input type="hidden" name="processdetailidedit" />
													</spring:bind>
													<td><form:input path="processseqedit" cssClass="textbox" /></td>
													<td><form:select path="processtypeidedit" class="select" cssStyle="height:25px">
													<form:option value="0">--Select--</form:option>
													<form:options items="${processtypesearch}" />
												</form:select></td>
													<td><form:input path="processdescriptionedit" cssClass="textbox" /></td>
													<td><form:input path="predessoredit"
															cssClass="textbox" /></td>
													<td><form:input path="successoredit" cssClass="textbox" /></td>
													<td><form:checkbox path="stageinspectionedit"
													value="0" class="checkbox"></form:checkbox></td>
													<td><form:checkbox path="serialcontroledit"
													value="0" class="checkbox"></form:checkbox></td>
													<td><form:input path="inspectionpctedit" cssClass="textbox" onKeyPress="return numbersonly(this, event)" /></td>
													<td><a href="#" id="addCust2"><img
															src="images/add (1).png"></img> </a></td>
												</tr>

											</c:if> 
 --%>
											<tr>
												<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
												<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
												<script type="text/javascript" src="js/jquery.validate.min.js"></script>
												<script type="text/javascript">
													$(function() {

														var row = '<table border="0"><tr><td>'
																+ '<table border="0" class="table" style="float:left;"><tr><spring:bind path="Process.processdetailidedit"><input type="hidden" name="processdetailidedit" value="0"/></spring:bind>'
																+ '<td><spring:bind path="Process.processseqedit"><input type="text" name="processseqedit" class="textbox"  /></spring:bind></td>'
																+ '<td><form:select path="processtypeidedit" class="select" cssStyle="height:25px;"><form:option value="0">--Select--</form:option><form:options items="${processtypesearch}" /></form:select></td>'
																+ '<td><spring:bind	path="Process.processdescriptionedit">	<input type="text" name="processdescriptionedit" class="textarea"  /></spring:bind></td>'
																+ '<td><spring:bind path="Process.predessoredit"> <input type="text" name="predessoredit" class="textboxsmall"/></spring:bind>'
																+ '<td><spring:bind path="Process.successoredit"> <input type="text" name="successoredit" class="textboxsmall"/></spring:bind></td>'
																+ '<td align="center"><spring:bind path="Process.stageinspectionedit"><input type="checkbox" name="stageinspectionedit" class="checkbox"   value="1" /></spring:bind></td>'
																+ '<td align="center"><spring:bind path="Process.serialcontroledit"><input type="checkbox" name="serialcontroledit" class="checkbox"  value="1" /></spring:bind></td>'
																+ '<td><spring:bind path="Process.inspectionpctedit"><input type="text" name="inspectionpctedit"  onKeyPress="return numbersonly(this, event)" maxlength="3"   class="textboxsmall"  /></spring:bind></td>'
																+ '</tr></table>'
																+ '<a href="#"  style="float:left; margin:0px 0 0 5px;" class="removerow1"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';
														//fadeIn
														$('#addCust2')
																.click(
																		function() {
																			$(
																					row)
																					.fadeIn(
																							"slow")
																					.appendTo(
																							"#newrow1");
																			i++;
																			return false;

																		});

														//fadeout selected item and remove
														$('.removerow1')
																.live(
																		'click',
																		function() {
																			$(
																					this)
																					.parent()
																					.fadeOut(
																							300,
																							function() {
																								$(
																										this)
																										.empty();
																								return false;
																							});
																		});

													});
												</script>

											</tr>

										</table>
									</div>
								</div>
							</div>
							<div id="newrow1"></div>
							<table>
								<tr>
									<td colspan="2" align="center"><input type="submit"
										value="Update" class="btn btn-primary" id="updateid" /></td>
								</tr>
							</table>
						</c:if>
					</form:form>


				</div>
			</div>



		</div>
	</div>
</body>
</html>




