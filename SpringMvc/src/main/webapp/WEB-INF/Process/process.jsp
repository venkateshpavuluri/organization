<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link rel="stylesheet"
	href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>

<script type="text/javascript">
	function one() {
		//alert($('#processtypeid1').text);
		$('#processNumber').val($('#processtypeid1 :selected').text());
		$('#processNumberEdit').val($('#processtypeidedit1 :selected').text());
		//alert($('#processtypeidedit1').val());
		//$('#processtypeidedit1'+$('#hiddenIdProcessPopUp').val()).val($('#processtypeidedit1 :selected').text());
	}

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
																		required : true
																	},
																	materialprocess:{
																		required:true
																	},
																	version:{
																		required:true,number:true
																	}
																	
																},
																messages : {
																	process : "<font style='color: red;'><b>Process is Required</b></font>",
																	materialprocess : "<font style='color: red;'><b>Material is Required</b></font>",
																	version : {
																		required:"<font style='color: red;'><b>Version is Required</b></font>",
																		number:"<font style='color: red;'><b>Version Allows Only Numbers</b></font>"
																	}
																},

															});
										});
						//	});
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
																		required : true
																	},
																	materialprocessEdit:{
																		required:true
																	},
																	versionEdit:{
																		required:true,number:true
																	}
																	
																},
																messages : {
																	processedit : "<font style='color: red;'><b>Process is Required</b></font>",
																	materialprocessEdit : "<font style='color: red;'><b>Material is Required</b></font>",
																	versionEdit : {
																		required:"<font style='color: red;'><b>Version is Required</b></font>",
																		number:"<font style='color: red;'><b>Version Allows Only Numbers</b></font>"
																	}
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
		$('#add,#search').click(function(e) {
			$('#edit').hide();
			$('#successmessage').hide();
			$('#savemessage').hide();

		});
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

#scroll {
	overflow: auto;
	overflow-x: scroll;
	overflow-y: hidden;
	width: 100px;
}

#mainscroll {
	overflow: auto;
	overflow-x: hidden;
	overflow-y: hidden;
	width: 90px;
}
</style>
<style type="text/css">
#scroll1 {
	overflow: auto;
	overflow-y: hidden;
	overflow-x: scroll;
	width: 900px;
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

		$
				.ajax({

					type : "POST",

					url : "processDuplicateCheck.mnt",

					data : "processname=" + processname,

					success : function(response) {

						var checkResponse = "Warning ! Process is already exists. Please try some other name";
						if (checkResponse == response) {

							document.getElementById("ProcessDupMessage").style.display = "block";
							//$('#ProcessDupMessage').html(response);
							$('#subid').hide();
						} else {
							document.getElementById("ProcessDupMessage").style.display = "none";
							$('#subid').show();
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

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

					url : "processDuplicateEditCheck.mnt",

					data : "processnameedit=" + processnameedit + "&processid="
							+ processid,

					success : function(response) {

						var checkResponse = "Warning ! Process is already exists. Please try some other name";
						//alert(response);
						if (checkResponse == response) {
							document.getElementById("ProcessDupEditMessage").style.display = "block";
							//$('#ProcessDupEditMessage').html(response);
							$('#updateid').hide();
						} else {
							document.getElementById("ProcessDupEditMessage").style.display = "none";
							$('#updateid').show();
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

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

					url : "processdescriptionDuplicateCheck.mnt",

					data : "processdesc=" + processdesc,

					success : function(response) {

						var checkResponse = "Warning ! Process Description is already exists. Please try some other name";
						if (checkResponse == response) {
							document.getElementById("ProcessdescDupMessage").style.display = "block";
							$('#ProcessdescDupMessage').html(response);
						} else {
							document.getElementById("ProcessdescDupMessage").style.display = "none";
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

					}

				});

	}
</script>

<script type="text/javascript">
	function ProcessDescEdit() {

		//get the form values

		var processdescedit = $('#processdescriptionedit').val();
		var processid = $('#processidedit').val();

		$
				.ajax({

					type : "POST",

					url : "processDescDuplicateEditCheck.mnt",

					data : "processdescedit=" + processdescedit + "&processid="
							+ processid,

					success : function(response) {

						var checkResponse = "Warning ! Process Description is already exists. Please try some other name";
						//alert(response);
						if (checkResponse == response) {
							document
									.getElementById("ProcessdescEditDupMessage").style.display = "block";
							$('#ProcessdescEditDupMessage').html(response);
						} else {
							document
									.getElementById("ProcessdescEditDupMessage").style.display = "none";
						}
					},

					error : function(e) {

						//alert('Error: ' + e);

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
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit"><spring:message
								code="label.edit" /></a></li>

				</c:if>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search"><spring:message
							code="label.search" /></a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add"><spring:message
							code="label.add" /></a></li>
			</ul>

			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<form:form action="searchProcess.mnt" method="GET"
						commandName="Process">
						<table class="tableGeneral">
							<tr>
								<td colspan="2"><c:forEach items="${param.list}">
										<div class="alert-success">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.process" />
											<spring:message code="label.saveSuccess" />
										</div>
									</c:forEach> <c:forEach items="${param.listwar}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.process" />
											<spring:message code="label.saveFail" />
										</div>
									</c:forEach> <c:forEach items="${processUpdate}">
										<div class="alert-success">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.process" />
											<spring:message code="label.updateSuccess" />
										</div>
									</c:forEach> <c:forEach items="${processUpdateFail}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.process" />
											<spring:message code="label.updateFail" />
										</div>
									</c:forEach> <c:forEach items="${processDelete}">
										<div class="alert-success" id="successmessage">
											<strong> <spring:message code="label.success" />
											</strong>
											<spring:message code="label.process" />
											<spring:message code="label.deleteSuccess" />
										</div>
									</c:forEach> <c:forEach items="${processDeleteFail}">
										<div class="alert-danger">
											<strong> <spring:message code="label.error" />
											</strong>
											<spring:message code="label.process" />
											<spring:message code="label.deleteFail" />
										</div>
									</c:forEach></td>
							</tr>

							<tr>
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
										<c:when test="${privileges eq messageup }">
											<c:set var="update" value="true"></c:set>
										</c:when>
									</c:choose>
								</c:forEach>

								<td><c:choose>
										<c:when test="${search }">
											<input type="submit"
												value="<spring:message code="label.search"/>"
												class="btn btn-primary" id="searchid" onclick="searchajax()" />
										</c:when>
										<c:otherwise>
											<input type="submit" disabled="disabled"
												value="<spring:message code="label.search"/>"
												class="btn btn-danger" id="searchid" />
										</c:otherwise>
									</c:choose></td>
							</tr>

						</table>
					</form:form>

					<c:if test="${processBeans!=null}">
						<display:table id="processingid" name="processBeans"
							requestURI="searchProcess.mnt" pagesize="5" class="table">
							<display:column property="processid" title="ProcessID"
								media="none" sortable="true"></display:column>
							<display:column property="process" title="Process" media="html"
								sortable="true"></display:column>
							<display:column property="materialprocess" title="Material"
								media="html" sortable="true"></display:column>
							<display:column property="version" title="Version" media="html"
								sortable="true"></display:column>
							<display:column title="Edit" style="color:white">
								<c:choose>
									<c:when test="${edit }">
										<a
											href="processEdit.mnt?processedit=<c:out value="${processingid.processid}"/>"
											style="color: red"><img src="images/Edit.jpg"
											width="20px" onclick="toggleTable();" height="20px" /> </a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Edit.jpg" width="20px"
											class="btn btn-danger" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
							</display:column>
							<display:column title="Delete">
								<c:choose>
									<c:when test="${delete}">
										<a
											href="processDelete.mnt?processdelete=<c:out value="${processingid.processid}"/>"
											style="color: red"><img src="images/Delete.jpg"
											width="20px" height="20px"
											onclick="return confirm('Do You Want to Delete the Selected Record ?')" /></a>
									</c:when>
									<c:otherwise>
										<a><img src="images/Delete.jpg" width="20px"
											class="btn btn-danger" height="20px" /> </a>
									</c:otherwise>
								</c:choose>
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
								<td><spring:message code="label.process" /><span
									class="required">*</span></td>
								<td><form:input path="process" id="process" class="textbox"
										onkeyup="doAjaxPost()" maxlength="50" /></td>


								<td colspan="2" id="ProcessDupMessage" style="display: none;">
									<div class="alert-warning">
										<strong> <spring:message code="label.warning" /></strong>
										<spring:message code="label.process" />
										<spring:message code="label.duplicateCheck" />
									</div>
								</td>

							</tr>
							<tr>
								<td><spring:message code="label.materialprocess" /><span
									class="required">*</span></td>
								<td><form:select path="materialprocess" class="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${MaterialProcess}" />
									</form:select></td>
							</tr>
							<tr>
								<td><spring:message code="label.version" /><span
									class="required">*</span></td>
								<td><form:input path="version" class="textbox"
										maxlength="20" /></td>
							</tr>
						</table>

						<!-- window 2 -->

						<div id="tabss" align="left">
							<div id="scroll1">
								<ul>

									<li><a href="#tab1"><spring:message
												code="label.processdetail" /></a></li>

								</ul>

								<!-- Tab-1 -->

								<div align="center">
									<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

									<!-- <div align="center"> -->

									<script>
										var btrid = 1;
										$(function() {

											/* var currentText = $(this).find(":selected").text(); */

											var pseq = $("#processseq"), ptype = $("#processtypeid1"), pvalue = $("#processNumber"), pdes = $("#processdescription"), pred = $("#predessor"), succ = $("#successor"), sinspection = $("#stageinspection"), scontrol = $("#serialcontrol"), inspct = $("#inspectionpct"), hiddenID = $("#hiddenIdBankPopUp")

											allFields = $([]).add(pseq).add(
													ptype).add(pvalue)
													.add(pdes).add(pred).add(
															succ).add(
															sinspection).add(
															scontrol).add(
															inspct).add(
															hiddenID),
													tips = $(".validateTips");

											function updateTips(t) {
												tips.text(t).addClass(
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

											$("#dialog-form-Process")
													.dialog(
															{
																autoOpen : false,
																height : 380,
																width : 400,
																modal : true,
																buttons : {
																	Submit : function() {
																		var bValid1 = true;
																		allFields
																				.removeClass("ui-state-error");

																		bValid1 = bValid1
																				&& checkRegexp(
																						pseq,
																						/^([0-9])+$/i,
																						"Process Sequence is Required And Must be Numbers");
																		bValid1 = bValid1
																				&& checkRegexp(
																						ptype,
																						/^[0-9]()+$/i,
																						"Process Type is Required");
																		bValid1 = bValid1
																				&& checkRegexp(
																						pdes,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Process Description may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						pred,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Predessor  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						succ,
																						/^[a-z]([0-9a-z_])+$/i,
																						"Successor may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						sinspection,
																						/^[0-9]()+$/i,
																						"Stage Inspection  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						scontrol,
																						/^[0-9]()+$/i,
																						"SerialControl  may consist of a-z, 0-9, underscores, begin with a letter.");
																		bValid1 = bValid1
																				&& checkRegexp(
																						inspct,
																						/^([0-9])+$/i,
																						"Inspection PCT is Required And Must be Numbers");
																		if (bValid1) {
																			//alert("hiddenid"+hiddenID.val());

																			if (hiddenID
																					.val() == "0"
																					|| hiddenID
																							.val() == "") {

																				$(
																						"#ProcessAdd tbody")
																						.append(
																								"<tr id="+btrid+">"
																										+ "<td ><spring:bind path='Process.processseq'><input name='processseq' id='processseq"
																										+ btrid
																										+ "' value="
																										+ pseq
																												.val()
																										+ " class='textbox'readonly/></spring:bind>  </td>"
																										+ "<td align='center'><input type='hidden' name='processtypeid1' id='processtypeid1"
																										+ btrid
																										+ "' value="
																										+ ptype
																												.val()
																										+ "  class='textbox'readonly/><input type='text' name='processNumber' id='processNumber"
																										+ btrid
																										+ "' value="
																										+ pvalue
																												.val()
																										+ "  class='textbox'readonly/></td>"

																										+ "<td><input name='processdescription' id='processdescription"
																										+ btrid
																										+ "' value="
																										+ pdes
																												.val()
																										+ " class='textarea'readonly/></td>"
																										+ "<td><input name='predessor' id='predessor"
																										+ btrid
																										+ "' value="
																										+ pred
																												.val()
																										+ " class='textbox'readonly/></td>"
																										+ "<td><input name='successor' id='successor"
																										+ btrid
																										+ "' value="
																										+ succ
																												.val()
																										+ " class='textbox'readonly/></td>"
																										+ "<td align='center'><input type='hidden' name='stageinspection1' id='stageinspection"
																										+ btrid
																										+ "' value="
																										+ sinspection
																												.val()
																										+ "  class='textbox'readonly/>"
																										+ "<input type='text' readonly class='textbox' name='stageinspectionName' id='stageinspectionName"
																										+ btrid
																										+ "' value='"
																										+ $(
																												'#stageinspection :selected')
																												.text()
																										+ "'"
																										+ "</td>"
																										+ "<td align='center'><input type='hidden' name='serialcontrol1' id='serialcontrol"
																										+ btrid
																										+ "' value="
																										+ scontrol
																												.val()
																										+ "  class='textbox'readonly/>"
																										+ "<input type='text' readonly class='textbox' name='serialcontrolName' id='serialcontrolName"
																										+ btrid
																										+ "' value='"
																										+ $(
																												'#serialcontrol :selected')
																												.text()
																										+ "'"
																										+ "</td>"
																										+ "<td><input name='inspectionpct' id='inspectionpct"
																										+ btrid
																										+ "' value="
																										+ inspct
																												.val()
																										+ " class='textbox'readonly/></td>"
																										+

																										// "<td>" + password.val() + "</td>" +
																										"<td><a href='#'  onclick='editMaterialm("
																										+ btrid
																										+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																										+ "<td><a href='#'  onclick='removeMaterialm("
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
																		if (hiddenID
																				.val() != "0") {
																			$(
																					'#processseq'
																							+ hiddenID
																									.val())
																					.val(
																							pseq
																									.val());
																			$(
																					'#processtypeid1'
																							+ hiddenID
																									.val())
																					.val(
																							ptype
																									.val());
																			$(
																					'#processNumber'
																							+ hiddenID
																									.val())
																					.val(
																							pvalue
																									.val());

																			$(
																					'#processdescription'
																							+ hiddenID
																									.val())
																					.val(
																							pdes
																									.val());
																			$(
																					'#predessor'
																							+ hiddenID
																									.val())
																					.val(
																							pred
																									.val());
																			$(
																					'#successor'
																							+ hiddenID
																									.val())
																					.val(
																							succ
																									.val());
																			$(
																					'#stageinspection'
																							+ hiddenID
																									.val())
																					.val(
																							sinspection
																									.val());
																			$(
																					'#stageinspectionName'
																							+ hiddenID
																									.val())
																					.val(
																							$(
																									'#stageinspection :selected')
																									.text());
																			$(
																					'#serialcontrol'
																							+ hiddenID
																									.val())
																					.val(
																							scontrol
																									.val());
																			$(
																					'#serialcontrolName'
																							+ hiddenID
																									.val())
																					.val(
																							$(
																									'#stageinspection :selected')
																									.text());

																			$(
																					'#inspectionpct'
																							+ hiddenID
																									.val())
																					.val(
																							inspct
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

											$("#AddProcess")
													.button()
													.click(
															function() {
																$(
																		"#dialog-form-Process")
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

											$("#dialog-form-Process").dialog(
													"open");

											$('#processseq')
													.val(
															$(
																	'#processseq'
																			+ id)
																	.val());
											$('#processtypeid1').val(
													$('#processtypeid1' + id)
															.val());
											$('#processNumber').val(
													$('#processNumber' + id)
															.val());
											$('#processdescription')
													.val(
															$(
																	'#processdescription'
																			+ id)
																	.val());
											$('#predessor').val(
													$('#predessor' + id).val());
											$('#successor').val(
													$('#successor' + id).val());
											$('#stageinspection').val(
													$('#stageinspection' + id)
															.val());
											$('#serialcontrol').val(
													$('#serialcontrol' + id)
															.val());
											$('#inspectionpct').val(
													$('#inspectionpct' + id)
															.val());
											$('#hiddenIdBankPopUp').val(id);
											// document.getElementById("").value="edit";
										}
									</script>


									<div id="dialog-form-Process" align="center"
										title="<spring:message code="label.processbutton"/>">
										<p class="validateTips" align="center"></p>

										<table class="tableGeneral" cellspacing=0>

											<tr>
												<td><spring:message code="label.processseq" /><span class="required">*</span></td>
												<td><form:input path="processseq" id="processseq"
														class="textbox" /></td>

											</tr>

											<tr>
												<td><spring:message code="label.processtype" /><span class="required">*</span></td>
												<td><form:select path="processtypeid1"
														id="processtypeid1" class="select" cssStyle="height:25px;"
														onchange="one()">
														<form:option value="">--Select--</form:option>
														<form:options items="${processtypesearch}" />

													</form:select></td>


												<td><input type="hidden" id="processNumber"
													class="select" class="height:25px;" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.processdesc" /><span class="required">*</span></td>
												<td><form:textarea path="processdescription"
														id="processdescription" class="textbox"
														onkeyup="processdescAjax()" maxlength="250" /></td>
											</tr>

											<tr>
												<td><spring:message code="label.predessor" /><span class="required">*</span></td>
												<td><form:input path="predessor" id="predessor"
														cssClass="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.successor" /><span class="required">*</span></td>
												<td><form:input path="successor" id="successor"
														cssClass="textbox" /></td>
											</tr>
											<tr>
												<td><spring:message code="label.stagei" /><span class="required">*</span></td>
												<td><form:select path="stageinspection1" class="select"
														id="stageinspection">
														<form:option value="0">No</form:option>
														<form:option value="1">Yes</form:option>


													</form:select></td>
											</tr>
											<tr>
												<td><spring:message code="label.serialconr" /><span class="required">*</span></td>
												<td><form:select path="serialcontrol1" class="select"
														id="serialcontrol">
														<form:option value="0">No</form:option>
														<form:option value="1">Yes</form:option>


													</form:select></td>
											</tr>

											<tr>
												<td><spring:message code="label.inspectionpct" /><span class="required">*</span></td>
												<td><form:input path="inspectionpct" id="inspectionpct"
														cssClass="textbox"
														onKeyPress="return numbersonly(this, event)" /> <input
													type="hidden" name="hiddenIdBankPopUp"
													id="hiddenIdBankPopUp" value="0" /></td>
											</tr>

										</table>
										<table>
											<tr class="alert-warning" id="ProcessdescDupMessage"
												style="display: none; width: 300px;"></tr>
										</table>
									</div>



									<div id="users-contain-Bank">
										<!-- class="ui-widget" -->
										<h3></h3>
										<table id="ProcessAdd" class="table">
											<thead>
												<tr>
													<th><spring:message code="label.processseq" /></th>
													<th><spring:message code="label.processtype" /></th>
													<th><spring:message code="label.processdesc" /></th>
													<th><spring:message code="label.predessor" /></th>
													<th><spring:message code="label.successor" /></th>
													<th><spring:message code="label.stagei" /></th>
													<th><spring:message code="label.serialconr" /></th>
													<th><spring:message code="label.inspectionpct" /></th>
													<th><spring:message code="label.edit" /></th>
													<th><spring:message code="label.remove" /></th>

												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
										<button id="AddProcess" type="button">
											<spring:message code="label.processbutton" />
										</button>
									</div>



									<!-- </div> -->




									<form:hidden path="processhide" />



								</div>

							</div>
						</div>
						<table>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${save }">
											<input type="submit"
												value="<spring:message code="label.save"/>"
												class="btn btn-primary" id="subid" />
										</c:when>
										<c:otherwise>
											<input type="submit"
												value="<spring:message code="label.save"/>"
												disabled="disabled" class="btn btn-danger" id="subid" />
										</c:otherwise>
									</c:choose> <input type="reset" class="btn btn-primary"
									value="<spring:message code="label.reset"/>" /></td>
							</tr>
						</table>
						<!-- </div> -->

					</form:form>

				</div>
			</div>
			<div id="tabs-1" class="TabbedPanelsContent">
				<div align="left" class="TabbedPanelsContent">
					<form:form action="processUpdate.mnt" method="POST"
						commandName="Process" id="editprocessForm">
						<%-- <c:forEach var="editvalues" items="${editvalues }">
							<c:set var="edit" value="${editvalues}"></c:set>
						</c:forEach> --%>
						<c:if test="${editvalues!=null}">

							<table class="tableGeneral">

								<form:hidden path="processidedit" />
								<form:hidden path="processhideedit" />
								<tr>
									<td><spring:message code="label.process" /><span
									class="required">*</span></td>
									<td><form:input path="processedit" class="textbox"
											onkeyup="doAjaxPostEdit()" maxlength="50" /></td>
									<td class="alert-warning" id="ProcessDelMessage"
										style="display: none;"></td>
									<td id="ProcessDupEditMessage" style="display: none;">
										<div class="alert-warning">
											<strong> <spring:message code="label.warning" /></strong>
											<spring:message code="label.process" />
											<spring:message code="label.duplicateCheck" />
										</div>
									</td>

								</tr>
								<tr>
									<td><spring:message code="label.materialprocess" /><span
										class="required">*</span></td>
									<td><form:select path="materialprocessEdit" class="select">
											<form:option value="">--Select--</form:option>
											<form:options items="${MaterialProcess}" />
										</form:select></td>
								</tr>
								<tr>
									<td><spring:message code="label.version" /><span
										class="required">*</span></td>
									<td><form:input path="versionEdit" class="textbox"
											maxlength="20" /></td>
								</tr>
							</table>
							<div id="tabss" align="left">
								<div id="scroll1">
									<ul>

										<li><a href="#tab1"><spring:message
													code="label.processdetail" /></a></li>

									</ul>


									<div align="center">

										<!--  <div style="overflow-y:hidden;overflow-x:scroll;">  -->

										<!-- <div align="center"> -->

										<script>
											var betrid = 1;
											$(function() {

												var epseq = $("#processseqedit"), eptype = $("#processtypeidedit1"), epvalue = $("#processNumberEdit"), epdes = $("#processdescriptionedit"), epred = $("#predessoredit"), esucc = $("#successoredit"), esinspection = $("#stageinspectionedit1"), escontrol = $("#serialcontroledit1"), einspct = $("#inspectionpctedit"), ehiddenID = $("#hiddenIdProcessPopUp")

														allFields = $([]).add(
																epseq).add(
																eptype).add(
																epvalue).add(
																epdes).add(
																epred).add(
																esucc).add(
																esinspection)
																.add(escontrol)
																.add(einspct)
																.add(ehiddenID),
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

												function checkLength(o, n, min,
														max) {
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

												$("#dialog-form-ProcessEdit")
														.dialog(
																{
																	autoOpen : false,
																	height : 380,
																	width : 400,
																	modal : true,
																	buttons : {
																		Submit : function() {
																			var bValid = true;
																			allFields
																					.removeClass("ui-state-error");

																			bValid = bValid
																					&& checkRegexp(
																							epseq,
																							/^[0-9+]+$/i,
																							"Process Sequence is Required And Must be Numbers");
																			bValid = bValid
																					&& checkRegexp(
																							eptype,
																							/^[0-9]()+$/i,
																							"Process Type is Required");
																			bValid = bValid
																					&& checkRegexp(
																							epdes,
																							/^[a-z]([0-9a-z_])+$/i,
																							"Process Description may consist of a-z, 0-9, underscores, begin with a letter.");
																			bValid = bValid
																					&& checkRegexp(
																							epred,
																							/^[a-z]([0-9a-z_])+$/i,
																							"Predessor  may consist of a-z, 0-9, underscores, begin with a letter.");
																			bValid = bValid
																					&& checkRegexp(
																							esucc,
																							/^[a-z]([0-9a-z_])+$/i,
																							"Successor may consist of a-z, 0-9, underscores, begin with a letter.");
																			bValid = bValid
																					&& checkRegexp(
																							esinspection,
																							/^[0-9]()+$/i,
																							"Stage Inspection  may consist of a-z, 0-9, underscores, begin with a letter.");
																			bValid = bValid
																					&& checkRegexp(
																							escontrol,
																							/^[0-9]()+$/i,
																							"SerialControl  may consist of a-z, 0-9, underscores, begin with a letter.");
																			bValid = bValid
																					&& checkRegexp(
																							einspct,
																							/^([0-9])+$/i,
																							"Inspection PCT is Required And Must be Numbers ");

																			if (bValid) {
																				//	alert(epseq.val());
																				//	alert(" e  hiddenid"+ehiddenID.val());
																				if (ehiddenID
																						.val() == "0") {

																					//alert("for append");

																					$(
																							"#ProcessAddEdit tbody")
																							.append(
																									"<tr id="+betrid+">"
																											+ "<td ><input name='processseqedit' id='processseqedit"
																											+ betrid
																											+ "' value="
																											+ epseq
																													.val()
																											+ " class='textbox'/>  </td>"

																											+ "<td align='center'><input type='hidden' name='processtypeidedit1' id='processtypeidedit1"
																											+ btrid
																											+ "' value="
																											+ eptype
																													.val()
																											+ "  class='textbox'readonly/><input type='text' name='processTypeName' id='processTypeName"
																											+ btrid
																											+ "' value="
																											+ epvalue
																													.val()
																											+ "  class='textbox'readonly/></td>"

																											+ "<td><input name='processdescriptionedit' id='processdescriptionedit"
																											+ betrid
																											+ "' value="
																											+ epdes
																													.val()
																											+ " class='textarea'/></td>"
																											+ "<td><input name='predessoredit' id='predessoredit"
																											+ betrid
																											+ "' value="
																											+ epred
																													.val()
																											+ " class='textbox'/></td>"
																											+ "<td><input name='successoredit' id='successoredit"
																											+ betrid
																											+ "' value="
																											+ esucc
																													.val()
																											+ " class='textbox'/></td>"
																											+ "<td align='center'><input type='text'  name='stageinspectionedit1' id='stageinspectionedit1"
																											+ betrid
																											+ "' value="
																											+ $(
																													'#stageinspectionedit1 :selected')
																													.text()
																											+ " class='textbox' />"
																											+ "<input type='hidden' readonly class='textbox' name='stageinspectionNameEdit' id='stageinspectionNameEdit"
																											+ betrid
																											+ "' value='"
																											+ esinspection
																													.val()
																											+ "'"
																											+ "</td>"
																											+ "<td align='center'><input type='text'  name='serialcontroledit1' id='serialcontroledit1"
																											+ betrid
																											+ "' value="
																											+ $(
																													'#serialcontroledit1 :selected')
																													.text()
																											+ "  class='textbox'/>"
																											+ "<input type='hidden' readonly class='textbox' name='serialcontrolNameEdit' id='serialcontrolNameEdit"
																											+ betrid
																											+ "' value='"
																											+ escontrol
																													.val()
																											+ "'"
																											+ "</td>"
																											+ "<td><input name='inspectionpctedit' id='inspectionpctedit"
																											+ betrid
																											+ "' value="
																											+ einspct
																													.val()
																											+ " class='textbox' readOnly/><input type='hidden' name='processdetailidedit' value='0' id='processdetailidedit'/><input type='hidden' name='Check' id='Check' value='0'/></td>"
																											+

																											// "<td>" + password.val() + "</td>" +
																											"<td><a href='#'  onclick='editProcess("
																											+ betrid
																											+ ")'><strong><img src='images/Edit.jpg' height='25px' width='25px'/></strong></a></td>"
																											+ "<td><a href='#'  onclick='removeProcess("
																											+ betrid
																											+ ")'><strong><img src='images/button_cancel.png' height='25px' width='25px'/></strong></a></td>"
																											+ "</tr>");

																					betrid++;
																					$(
																							this)
																							.dialog(
																									"close");
																				}
																				if (ehiddenID
																						.val() != "0") {
																					$(
																							'#processseqedit'
																									+ ehiddenID
																											.val())
																							.val(
																									epseq
																											.val());
																					$(
																							'#processtypeidedit1'
																									+ ehiddenID
																											.val())
																							.val(
																									eptype
																											.val());
																					$(
																							'#processNumberEdit'
																									+ ehiddenID
																											.val())
																							.val(
																									eptype
																											.val());
																					$(
																							'#processTypeName'
																									+ ehiddenID
																											.val())
																							.val(
																									$(
																											'#processtypeidedit1 :selected')
																											.text());
																					$(
																							'#processdescriptionedit'
																									+ ehiddenID
																											.val())
																							.val(
																									epdes
																											.val());
																					$(
																							'#predessoredit'
																									+ ehiddenID
																											.val())
																							.val(
																									epred
																											.val());
																					$(
																							'#successoredit'
																									+ ehiddenID
																											.val())
																							.val(
																									esucc
																											.val());
																					$(
																							'#stageinspectionedit1'
																									+ ehiddenID
																											.val())
																							.val(
																									$(
																											'#stageinspectionedit1 :selected')
																											.text());
																					$(
																							'#stageinspectionNameEdit'
																									+ ehiddenID
																											.val())
																							.val(
																									esinspection
																											.val());
																					$(
																							'#serialcontroledit1'
																									+ ehiddenID
																											.val())
																							.val(
																									$(
																											'#serialcontroledit1 :selected')
																											.text());
																					$(
																							'#serialcontrolNameEdit'
																									+ ehiddenID
																											.val())
																							.val(
																									escontrol
																											.val());
																					$(
																							'#inspectionpctedit'
																									+ ehiddenID
																											.val())
																							.val(
																									einspct
																											.val());
																					$(
																							'#hiddenIdProcessPopUp')
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

												$("#AddProcessedit")
														.button()
														.click(
																function() {
																	$(
																			"#dialog-form-ProcessEdit")
																			.dialog(
																					"open");
																	//alert("opened");
																});
											});
											function removeProcess(id) {
												//alert("removing row " + id);
												$('#' + id).remove();
											}
											function editProcess(eid) {
												//alert("edit row " + eid);
												$('#hiddenIdProcessPopUp').val(
														eid);
												$("#dialog-form-ProcessEdit")
														.dialog("open");

												//alert("this value  "+$('#processseqedit' + eid).val());
												//alert("kkkkk"+$('#processseqedit107').val())
												$('#processseqedit').val(
														$(
																'#processseqedit'
																		+ eid)
																.val());
												$('#processtypeidedit1').val(
														$(
																'#processtypeidedit1'
																		+ eid)
																.val());
												$('#processNumberEdit').val(
														$(
																'#processNumberEdit'
																		+ eid)
																.val());
												$('#processdescriptionedit')
														.val(
																$(
																		'#processdescriptionedit'
																				+ eid)
																		.val());
												$('#predessoredit').val(
														$(
																'#predessoredit'
																		+ eid)
																.val());
												$('#successoredit').val(
														$(
																'#successoredit'
																		+ eid)
																.val());
												$('#stageinspectionedit1').val(
														$(
																'#stageinspectionNameEdit'
																		+ eid)
																.val());
												$('#serialcontroledit1').val(
														$(
																'#serialcontrolNameEdit'
																		+ eid)
																.val());
												$('#inspectionpctedit').val(
														$(
																'#inspectionpctedit'
																		+ eid)
																.val());

											}
										</script>


										<div id="dialog-form-ProcessEdit" align="center"
											title="<spring:message code="label.processbutton"/>">
											<p class="validateTips" align="center"></p>
											<table align="center" class="tableGeneral">
												<form:hidden path="processdetailidedit" />
												<tr>
													<td><spring:message code="label.processseq" /><span class="required">*</span></td>
													<td><form:input path="processseqedit"
															id="processseqedit" class="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.processtype" /><span class="required">*</span></td>
													<td><form:select path="processtypeidedit1"
															id="processtypeidedit1" class="select" onchange="one()">
															<form:option value="">--Select--</form:option>
															<form:options items="${processtypesearch}" />
														</form:select></td>

													<td><input type="hidden" id="processNumberEdit"
														class="select" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.processdesc" /><span class="required">*</span></td>
													<td><form:textarea path="processdescriptionedit"
															id="processdescriptionedit" class="textbox"
															onkeyup="ProcessDescEdit()" maxlength="250" /></td>

												</tr>
												<tr>
													<td><spring:message code="label.predessor" /><span class="required">*</span></td>
													<td><form:input path="predessoredit"
															id="predessoredit" cssClass="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.successor" /><span class="required">*</span></td>
													<td><form:input path="successoredit"
															id="successoredit" cssClass="textbox" /></td>
												</tr>
												<tr>
													<td><spring:message code="label.stagei" /><span class="required">*</span></td>
													<td><form:select path="stageinspectionedits"
															class="select" id="stageinspectionedit1">
															<form:option value="0">No</form:option>
															<form:option value="1">Yes</form:option>


														</form:select></td>
												</tr>
												<tr>
													<td><spring:message code="label.serialconr" /><span class="required">*</span></td>
													<td><form:select path="serialcontroledits"
															class="select" id="serialcontroledit1">
															<form:option value="0">No</form:option>
															<form:option value="1">Yes</form:option>


														</form:select></td>
												</tr>

												<tr>
													<td><spring:message code="label.inspectionpct" /><span class="required">*</span></td>
													<td><form:input path="inspectionpctedit"
															id="inspectionpctedit" cssClass="textbox"
															onKeyPress="return numbersonly(this, event)" /> <input
														type="hidden" name="hiddenIdProcessPopUp"
														id="hiddenIdProcessPopUp" value="0" /></td>
												</tr>
											</table>
											<table>
												<tr>
													<td class="alert-warning" id="ProcessdescEditDupMessage"
														style="display: none; width: 300px;"></td>
												</tr>
											</table>
										</div>



										<div id="users-contain-Process">
											<!-- class="ui-widget" -->
											<h3></h3>
											<table id="ProcessAddEdit" class="table">
												<thead>
													<tr>
														<th><spring:message code="label.processseq" /></th>
														<th><spring:message code="label.processtype" /></th>
														<th><spring:message code="label.processdesc" /></th>
														<th><spring:message code="label.predessor" /></th>
														<th><spring:message code="label.successor" /></th>
														<th><spring:message code="label.stagei" /></th>
														<th><spring:message code="label.serialconr" /></th>
														<th><spring:message code="label.inspectionpct" /></th>
														<th><spring:message code="label.edit" /></th>
														<th><spring:message code="label.remove" /></th>

													</tr>
												</thead>
												<tbody>
													<c:forEach items="${processDetailBeans}"
														var="processDetailBeans">



														<td><spring:bind path="Process.processdetailidedit">
																<input type="hidden" name="processdetailidedit"
																	id="processdetailidedit${processDetailBeans.processdetailidedit}"
																	value="${processDetailBeans.processdetailidedit}" />
															</spring:bind></td>

														<tr id="${processDetailBeans.processdetailidedit}">



															<%--  <spring:bind path="Process.processtypeidedit1">	
											<input type="hidden" name="processtypeidedit1"  id="ptNameEdit${processDetailBeans.processdetailidedit}"
																value="${processDetailBeans.processtypeidedit2}"  /></spring:bind> --%>


															<td><spring:bind path="Process.processseqedit">
																	<input type="text" name="processseqedit"
																		class="textbox"
																		id="processseqedit${processDetailBeans.processdetailidedit}"
																		value="${processDetailBeans.processseqedit}" />
																</spring:bind></td>

															<td><input type="hidden" name="processtypeidedit1"
																id="processtypeidedit1${processDetailBeans.processdetailidedit}"
																value="${processDetailBeans.processtypeidedit2}" /> <spring:bind
																	path="Process.processtypeidedit1">
																	<input type="text" name="processTypeName"
																		class="textbox"
																		id="processTypeName${processDetailBeans.processdetailidedit}"
																		value="${processDetailBeans.processTypeName}" />
																</spring:bind></td>
															<td><spring:bind
																	path="Process.processdescriptionedit">
																	<input type="text" name="processdescriptionedit"
																		id="processdescriptionedit${processDetailBeans.processdetailidedit}"
																		class="textarea"
																		value="${processDetailBeans.processdescriptionedit}" />
																</spring:bind></td>
															<td><spring:bind path="Process.predessoredit">
																	<input type="text" name="predessoredit"
																		id="predessoredit${processDetailBeans.processdetailidedit}"
																		class="textbox"
																		value="${processDetailBeans.predessoredit}" />
																</spring:bind></td>
															<td><spring:bind path="Process.successoredit">
																	<input type="text" name="successoredit"
																		id="successoredit${processDetailBeans.processdetailidedit}"
																		class="textbox"
																		value="${processDetailBeans.successoredit}" />
																</spring:bind></td>
															<td><spring:bind path="Process.stageinspectionedit1">
																	<input type="text" name="stageinspectionedit1"
																		id="stageinspectionedit1${processDetailBeans.processdetailidedit}"
																		class="textbox"
																		value="${processDetailBeans.stageinspectionedit}" />
																	<input type="hidden" name="stageinspectionNameEdit"
																		class="textbox"
																		id="stageinspectionNameEdit${processDetailBeans.processdetailidedit}"
																		value="${processDetailBeans.stageinspectionedit2}" />
																</spring:bind></td>
															<td><spring:bind path="Process.serialcontroledit1">
																	<input type="text" name="serialcontroledit1"
																		id="serialcontroledit1${processDetailBeans.processdetailidedit}"
																		class="textbox"
																		value="${processDetailBeans.serialcontroledit}" />
																	<input type="hidden" name="serialcontrolNameEdit"
																		class="textbox"
																		id="serialcontrolNameEdit${processDetailBeans.processdetailidedit}"
																		value="${processDetailBeans.serialcontroledit2}" />
																</spring:bind></td>
															<td><spring:bind path="Process.inspectionpctedit">
																	<input type="text" name="inspectionpctedit"
																		id="inspectionpctedit${processDetailBeans.processdetailidedit}"
																		class="textbox"
																		onKeyPress="return numbersonly(this, event)"
																		value="${processDetailBeans.inspectionpctedit}" />
																</spring:bind> <input type="hidden"
																name="Check${processDetailBeans.processdetailidedit}"
																id="${processDetailBeans.processdetailidedit}Check"
																value="0" /></td>

															<td><a href='#'
																id="${processDetailBeans.processdetailidedit}"
																onclick="editProcess(this.id)"><strong><img
																		src='images/Edit.jpg' height='25px' width='25px' /></strong></a></td>
															<td><a href='#'
																id="${processDetailBeans.processdetailidedit}"
																onclick="getID1(this)"><strong><img
																		src='images/button_cancel.png' height='25px'
																		width='25px' /></strong></a></td>
														</tr>



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
															function editProcessDetailsInEdit(
																	link) {
																//	alert("sdfsdf er"+link.id);
																$(
																		"#dialog-form-ProcessEdit")
																		.dialog(
																				"open");
																$(
																		'#processseqedit'
																				+ link.id)
																		.val(
																				$(
																						'#processseqedit')
																						.val());
																$(
																		'#processtypeidedit1')
																		.val(
																				$(
																						'#processtypeidedit1'
																								+ link.id)
																						.val());
																$(
																		'#processdescriptionedit')
																		.val(
																				$(
																						'#processdescriptionedit'
																								+ link.id)
																						.val());
																$(
																		'#predessoredit')
																		.val(
																				$(
																						'#predessoredit'
																								+ link.id)
																						.val());
																$(
																		'#successoredit')
																		.val(
																				$(
																						'#successoredit'
																								+ link.id)
																						.val());
																$(
																		'#stageinspectionedit1')
																		.val(
																				$(
																						'#stageinspectionedit1'
																								+ link.id)
																						.val());
																$(
																		'#serialcontroledit1')
																		.val(
																				$(
																						'#serialcontroledit1'
																								+ link.id)
																						.val());
																$(
																		'#inspectionpctedit')
																		.val(
																				$(
																						'#inspectionpctedit'
																								+ link.id)
																						.val());

																$(
																		'#hiddenIdProcessPopUp')
																		.val(
																				link.id);

															}
														</script>

													</c:forEach>
												</tbody>
											</table>
											<button id="AddProcessedit" type="button">
												<spring:message code="label.processbutton" />
											</button>
										</div>

									</div>
								</div>
							</div>

							<table>
								<tr>
									<td colspan="2" align="center"><c:choose>
											<c:when test="${update }">
												<input type="submit"
													value="<spring:message code="label.update"/>"
													class="btn btn-primary" id="updateid" />
											</c:when>
											<c:otherwise>
												<input type="submit" disabled="disabled"
													value="<spring:message code="label.update"/>"
													class="btn btn-danger" />
											</c:otherwise>
										</c:choose> <c:forEach var="processingid" items="${processDetailBeans}">
										</c:forEach></td>

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




