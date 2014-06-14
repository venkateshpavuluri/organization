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
<script type="text/javascript">
	$(document).ready(function() {
		if (document.getElementById("vendorAddDuplicate").value == 1) {
			var index = $('#tabs li a').index($('a[href="#tabs-3"]').get(0));

			$('#tabs').tabs({
				active : index
			});
		}
	});
</script>

</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">My Preferences</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<c:forEach var="vendorValues" items="${vendorValues}">
					<li class="TabbedPanelsTab"><a href="#tabs-1" id="edit">Edit</a></li>

				</c:forEach>
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="search">Search</a></li>
				<li class="TabbedPanelsTab"><a href="#tabs-3" id="add">Add</a></li>
			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
					<table class="tableGeneral">
						<tr>
							<td height="35px"><input type="hidden" name="search" /> <c:forEach
									var="vendorUpadted" items="${param.list}">
									<div class="alert-success" id="savemessage">
										<strong></strong>
										<c:out value="${param.success}"></c:out>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td colspan="3"><c:forEach var="vendorUpadted"
									items="${vendorUpadte}">
									<div class="alert-success" id="successmessage">
										<strong></strong>
										<c:out value="${vendorUpadte}"></c:out>
									</div>
								</c:forEach></td>
						</tr>
						<form:form action="vendorSearch.mnt" method="get"
							commandName="vendorForm">

							<tr>
								<td>Vendor Name</td>
								<td><form:input path="vendorName" class="textbox" /></td>
								<td><input type="submit" value="Search"
									class="btn btn-primary" /></td>
							</tr>
						</form:form>
					</table>

					<c:forEach var="vendorSearch" items="${vendorSearch}">
						<c:set var="g" value="${vendorSearch}"></c:set>
					</c:forEach>

					<c:if test="${g!=null}">
						<div class="scroll">
							<display:table id="vendorRow" name="vendorSearch"
								requestURI="vendorSearch.mnt" pagesize="5" class="table">

								<display:column property="customerId" title="Customer Id"
									media="none" sortable="true" />
								<display:column property="vendorName" title="Vendor Name"
									media="html" sortable="true" />
								<display:column property="address" title="Address" media="html"
									sortable="true" />
								<display:column property="city" title="City" media="html"
									sortable="true" />
								<display:column property="state" title="State" media="html"
									sortable="true" />
								<display:column property="country" title="Country" media="html"
									sortable="true" />
								<display:column property="zip" title="Zip Code" media="html"
									sortable="true" />
								<display:column property="email" title="Email Address"
									media="html" sortable="true" />
								<display:column property="phone" title="Phone No" media="html"
									sortable="true" />
								<display:column property="fax" title="Fax" media="html"
									sortable="true" />
								<display:column property="mobile" title="Mobile" media="html"
									sortable="true" />
								<display:column property="vendGroupId" title="Vendor Group Id"
									media="html" sortable="true" />
								<display:column property="blocked" title="Blocked" media="html"
									sortable="true" />
								<display:column property="tinNo" title="Tin No" media="html"
									sortable="true" />
								<display:column property="panNo" title="Pan No" media="html"
									sortable="true" />
								<display:column property="vatNo" title="Vat No" media="html"
									sortable="true" />
								<display:column property="serviceTaxNo" title="Service Tax No"
									media="html" sortable="true" />

								<display:column title="Edit" style="color:white">
									<a
										href="vendorEdit.mnt?vendorEdit=<c:out value="${vendorRow.vendorId}"/>"
										style="color: red"><img src="images/Edit.jpg" title="Edit"
										width="20px" height="20px" /> </a>
								</display:column>

								<display:column title="Delete">
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
						commandName="vendorForm" ENCTYPE="multipart/form-data">
						<table class="tableGeneral">
							<tr>
								<td colspan="2" height="50px"><form:hidden
										path="vendorAddDuplicate" /> <c:forEach
										var="vendorDuplicateAddValue" items="${vendorDuplicateAdd}">
										<div class="alert-warning" id="successmessage">
											<strong></strong>
											<c:out value="${vendorDuplicateAddValue}"></c:out>
										</div>
									</c:forEach></td>
							</tr>

							<tr>
								<td>Customer Id</td>
								<td>
									<!--<form:input path="customerId" id="customerId" class="textbox" /> -->
									<form:select path="customerId" id="customerId" class="select">
										<form:option value="0">--Select--</form:option>
										<%-- <form:option value="1" >one</form:option> --%>
										<form:options items="${customerIdDetails}" />
									</form:select>
								</td>
								<td>Vendor Name</td>
								<td><form:input path="vendorName" id="vendorName"
										class="textbox" /></td>
							</tr>
							<tr>
								<td>Address</td>
								<td><form:input path="address" id="Address" class="textbox" />
								</td>
								<td>City</td>
								<td><form:input path="city" id="City" class="textbox" /></td>
							</tr>
							<tr>
								<td>State</td>
								<td><form:input path="state" id="State" class="textbox" />
								</td>
								<td>Country</td>
								<td>
									<!--<form:input path="country" id="Country" class="textbox" />-->
									<form:select path="country" id="Country" class="select">
										<form:option value="0">--Select--</form:option>
										<form:options items="${country}" />
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Zip Code</td>
								<td><form:input path="zip" id="Zip" class="textbox" /></td>
								<td>Email Address</td>
								<td><form:input path="email" id="Email" class="textbox" />
								</td>
							</tr>
							<tr>
								<td>Service Tax No</td>
								<td><form:input path="serviceTaxNo" id="ServiceTaxNo"
										class="textbox" /></td>
								<td>Phone No</td>
								<td><form:input path="phone" id="Phone" class="textbox" />
								</td>
							</tr>
							<tr>
								<td>Fax</td>
								<td><form:input path="fax" id="Fax" class="textbox" /></td>
								<td>Mobile</td>
								<td><form:input path="mobile" id="Mobile" class="textbox" />
								</td>
							</tr>
							<tr>
								<td>Vendor Group Id</td>
								<td>
									<!--<form:input path="vendGroupId" id="vendGroupId" class="textbox" />-->
									<form:select path="vendGroupId" id="vendGroupId" class="select">
										<form:option value="0">--Select--</form:option>
										<%-- <form:option value="1" >one</form:option> --%>
										<form:options items="${vendorGroupIdDetails}" />
									</form:select>
								</td>
								<td>Blocked</td>
								<td><form:select path="blocked" id="Blocked" class="select">
										<form:option value="0">--Select--</form:option>
										<form:option value="1">YES</form:option>
										<form:option value="2">NO</form:option>

									</form:select></td>
							</tr>
							<tr>
								<td>Tin No</td>
								<td><form:input path="tinNo" id="TinNo" class="textbox" />
								</td>
								<td>Pan No</td>
								<td><form:input path="panNo" id="PanNo" class="textbox" />
								</td>
							</tr>
							<tr>
								<td>Vat No</td>
								<td><form:input path="vatNo" id="VatNo" class="textbox" />
								</td>
								<td></td>
							</tr>




							<tr align="center">
								<td colspan="4"><input type="submit" value="Save"
									class="btn btn-primary" id="sumbnid" /><input type="reset"
									class="btn btn-primary" /></td>
							</tr>
						</table>


						<div id="tabs1">
							<ul>
								<li><a href="#tabs-11">Bank Details</a></li>
								<li><a href="#tabs-21">Documents</a></li>
								<!-- <li><a href="#tabs-31">Material</a></li> -->
							</ul>
							<div id="tabs-11">
								<div align="center">
									<div align="center">

										<table>

											<tr>



												<td>BankName</td>
												<td>BankAddress</td>
												<td>MICRCode</td>
												<td>IFSCCode</td>
												<td>AccountType</td>
												<td>AccountNumber</td>
											</tr>
											<tr>

												<td><form:input path="bankName" id="bankName"
														class="textbox" /></td>
												<td><form:input path="bankAddress" id="bankAddress"
														class="textbox" /></td>
												<td><form:input path="micrCode" id="micrCode"
														class="textbox" /></td>
												<td><form:input path="ifscCode" id="ifscCode"
														class="textbox" /></td>
												<td><form:input path="accountType" id="accountType"
														class="textbox" /></td>
												<td><form:input path="accountNumber" id="accountNumber"
														class="textbox" /></td>


												<td><a href="#" id="addBank"><img
														src="images/add (1).png"></img></a></td>


												<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
												<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

												<script type="text/javascript">
													$(document)
															.ready(
																	function() {
																		$(function() {

																			//fadeout selected item and remove
																			$(
																					'.remove')
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
																			//alert("came to add")
																			var options = '<table border="0"><tr><td>'
																					+ '<table style="float:left;" border="0" ><tr>'
																					+ ' <td><form:input path="bankName" id="bankName" class="textbox" /></td><td><form:input path="bankAddress" id="bankAddress" class="textbox" /></td> <td><form:input path="micrCode" id="micrCode" class="textbox" /></td>	<td><form:input path="ifscCode" id="ifscCode" class="textbox" /></td><td><form:input path="accountType" id="accountType" class="textbox" /></td> <td><form:input path="accountNumber" id="accountNumber" class="textbox" /></td>'
																					+ '</td></tr></table>'
																					+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';

																			//add input
																			$(
																					'#addBank')
																					.click(
																							function() {
																								$(
																										options)
																										.fadeIn(
																												"slow")
																										.appendTo(
																												'#extender');
																								//	alert("affk");
																								i++;
																								return false;
																							});

																		});

																	});
												</script>



											</tr>



										</table>
										<div id="extender"></div>
									</div>

								</div>
							</div>
							<div id="tabs-21">
								<div align="center">
									<table class="tableGeneral">


										<tr>
											<td>Document Name</td>
											<td><form:input path="documentName" id="documentName"
													class="textbox" /></td>
											<td>Please select a file to upload :</td>
											<td><input type="file" name="file" /></td>
											<td><a href="#" id="addDocument"><img
													src="images/add (1).png"></img></a></td>
											<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

											<script type="text/javascript">
												$(document)
														.ready(
																function() {
																	$(function() {

																		//fadeout selected item and remove
																		$(
																				'.remove')
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
																		//alert("came to add")
																		var options = '<table border="0"><tr><td>'
																				+ '<table style="float:left;" border="0" ><tr>'
																				+ ' <td><td>Document Name</td><td><form:input path="documentName" id="documentName" class="textbox" /></td><td>Please select a file to upload :</td><td><input type="file" name="file"  /></td>'
																				+ '</td></tr></table>'
																				+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';

																		//add input
																		$(
																				'#addDocument')
																				.click(
																						function() {
																							$(
																									options)
																									.fadeIn(
																											"slow")
																									.appendTo(
																											'#extenderDocument');
																							//	alert("affk");
																							i++;
																							return false;
																						});

																	});

																});
											</script>
										</tr>
									</table>
									<div id="extenderDocument"></div>

								</div>
							</div>
							<!--  <div id="tabs-31">
    						<div align="center"> -->


							<div id="extenderMatrial"></div>
					</form:form>
				</div>
			</div>


		</div>

	</div>
	</div>
	<div id="tabs-1" class="TabbedPanelsContent" name="editTab">
		<div align="left" class="TabbedPanelsContent">
			<c:forEach var="vendorEditValues" items="${vendorValues }">
				<form:form action="vendorUpdate.mnt" method="POST"
					commandName="vendorForm" ENCTYPE="multipart/form-data">
					<table class="tableGeneral">

						<form:hidden path="vendorIdEdit" />
						<%-- 	<tr><td>Customer Id</td><td><form:input path="customerIdEdit" id="customerId" class="textbox" /> </td><td>Phone No</td><td><form:input path="phoneEdit" id="Phone" class="textbox" /> </td>  </tr>
			<tr><td>Vendor Name</td><td><form:input path="vendorNameEdit" id="vendorName" class="textbox" /> </td> <td>Fax</td><td><form:input path="faxEdit" id="Fax" class="textbox" /> </td></tr>
			<tr><td>Address</td><td><form:input path="addressEdit" id="Address" class="textbox" /> </td><td>Mobile</td><td><form:input path="mobileEdit" id="Mobile" class="textbox" /> </td> </tr>
			<tr><td>City</td><td><form:input path="cityEdit" id="City" class="textbox" /> </td> <td>Vendor Group Id</td><td><form:input path="vendGroupIdEdit" id="VendGroupIdId" class="textbox" /> </td></tr>
			<tr><td>State</td><td><form:input path="stateEdit" id="State" class="textbox" /> </td><td>Blocked</td><td><form:input path="blockedEdit" id="Blocked" class="textbox" /> </td> </tr>
			<tr><td>Country</td><td><form:input path="countryEdit" id="Country" class="textbox" /> </td><td>Tin No</td><td><form:input path="tinNoEdit" id="TinNo" class="textbox" /> </td>  </tr>
			<tr><td>Zip Code</td><td><form:input path="zipEdit" id="Zip" class="textbox" /> </td> <td>Pan No</td><td><form:input path="panNoEdit" id="PanNo" class="textbox" /> </td></tr>
			<tr><td>Email Address</td><td><form:input path="emailEdit" id="Email" class="textbox" /> </td><td>Vat No</td><td><form:input path="vatNoEdit" id="VatNo" class="textbox" /> </td>  </tr>
			
			<tr><td>Service Tax No</td><td><form:input path="serviceTaxNoEdit" id="ServiceTaxNo" class="textbox" /> </td><td></td> </tr> --%>


						<tr>
							<td>Customer Id</td>
							<td><form:select path="customerIdEdit" id="customerId"
									class="select">
									<form:option value="0">--Select--</form:option>
									<%-- <form:option value="1" >one</form:option> --%>
									<form:options items="${customerIdDetails}" />
								</form:select></td>
							<td>Vendor Name</td>
							<td><form:input path="vendorNameEdit" id="vendorName"
									class="textbox" /></td>
						</tr>
						<tr>
							<td>Address</td>
							<td><form:input path="addressEdit" id="Address"
									class="textbox" /></td>
							<td>City</td>
							<td><form:input path="cityEdit" id="City" class="textbox" />
							</td>
						</tr>
						<tr>
							<td>State</td>
							<td><form:input path="stateEdit" id="State" class="textbox" />
							</td>
							<td>Country</td>
							<td><form:select path="countryEdit" id="Country"
									class="select">
									<form:option value="0">--Select--</form:option>
									<form:options items="${country}" />
								</form:select></td>
						</tr>
						<tr>
							<td>Zip Code</td>
							<td><form:input path="zipEdit" id="Zip" class="textbox" />
							</td>
							<td>Email Address</td>
							<td><form:input path="emailEdit" id="Email" class="textbox" />
							</td>
						</tr>
						<tr>
							<td>Service Tax No</td>
							<td><form:input path="serviceTaxNoEdit" id="ServiceTaxNo"
									class="textbox" /></td>
							<td>Phone No</td>
							<td><form:input path="phoneEdit" id="Phone" class="textbox" />
							</td>
						</tr>
						<tr>
							<td>Fax</td>
							<td><form:input path="faxEdit" id="Fax" class="textbox" />
							</td>
							<td>Mobile</td>
							<td><form:input path="mobileEdit" id="Mobile"
									class="textbox" /></td>
						</tr>
						<tr>
							<td>Vendor Group Id</td>
							<td><form:select path="vendGroupIdEdit" id="vendGroupId"
									class="select">
									<form:option value="0">--Select--</form:option>
									<%-- <form:option value="1" >one</form:option> --%>
									<form:options items="${vendorGroupIdDetails}" />
								</form:select></td>
							<td>Blocked</td>
							<td><form:select path="blockedEdit" id="Blocked"
									class="select">
									<form:option value="0">--Select--</form:option>
									<form:option value="1">YES</form:option>
									<form:option value="2">NO</form:option>

								</form:select></td>
						</tr>
						<tr>
							<td>Tin No</td>
							<td><form:input path="tinNoEdit" id="TinNo" class="textbox" />
							</td>
							<td>Pan No</td>
							<td><form:input path="panNoEdit" id="PanNo" class="textbox" />
							</td>
						</tr>
						<tr>
							<td>Vat No</td>
							<td><form:input path="vatNoEdit" id="VatNo" class="textbox" />
							</td>
							<td></td>
						</tr>



						<tr align="center">
							<td colspan="4" align="center"><input type="submit"
								value="Update" class="btn btn-primary"></td>
						</tr>
					</table>

					<div id="tabs2">
						<ul>
							<li><a href="#tabs-21">Bank Details</a></li>
							<li><a href="#tabs-22">Documents</a></li>
							<!-- <li><a href="#tabs-23">Material</a></li> -->
						</ul>
						<div id="tabs-21">
							<div align="center">
								<div align="center">

									<table>

										<tr>



											<td>BankName</td>
											<td>BankAddress</td>
											<td>MICRCode</td>
											<td>IFSCCode</td>
											<td>AccountType</td>
											<td>AccountNumber</td>
											<td>Delete/Add</td>

										</tr>
										<c:forEach var="vendorBankEditValues"
											items="${vendorBankValues}">

											<tr id="${vendorBankEditValues.vendorBankDetId}">
												<%-- <c:out value="${vendorBankEditValues1.bankName}"/> --%>

												<td><input type="text" name="bankNameEdit"
													id="bankNameEdit" class="textbox"
													value="${vendorBankEditValues.bankName}" /></td>
												<td><input type="text" name="bankAddressEdit"
													id="bankAddressEdit" class="textbox"
													value="${vendorBankEditValues.bankAddress}" /></td>
												<td><input type="text" name="micrCodeEdit"
													id="micrCodeEdit" class="textbox"
													value="${vendorBankEditValues.micrCode}" /></td>
												<td><input type="text" name="ifscCodeEdit"
													id="ifscCodeEdit" class="textbox"
													value="${vendorBankEditValues.ifscCode}" /></td>
												<td><input type="text" name="accountTypeEdit"
													id="accountTypeEdit" class="textbox"
													value="${vendorBankEditValues.accountType}" /></td>
												<td><input type="text" name="accountNumberEdit"
													id="accountNumberEdit" class="textbox"
													value="${vendorBankEditValues.accountNumber}" /><input
													type="hidden" name="vendorBankDetIdEdit"
													id="vendorBankDetIdEdit" class="textbox"
													value="${vendorBankEditValues.vendorBankDetId}" /><input
													type="hidden"
													name="${vendorBankEditValues.vendorBankDetId}Check"
													id="${vendorBankEditValues.vendorBankDetId}Check" value="0" /></td>
												<td><a href="#"
													id="${vendorBankEditValues.vendorBankDetId}"
													onclick="check(this)"><img
														src="images/button_cancel.png" height="25px" width="25px"></img></a></td>

												<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
												<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
												<script type="text/javascript">
													/*  function imageClick(y)
													 {
													 alert("u clicked image"+y);
													 } */
													function check(link) {

														alert("Deleting Particular Row Will Deleted Once You Click Update Button");
														document
																.getElementById(link.id
																		+ "Check").value = "1";
														document
																.getElementById(link.id).style.display = "none";
													}
												</script>
											</tr>
										</c:forEach>
										<tr>

											<td><form:input path="bankNameEdit" id="bankNameEdit"
													class="textbox" /></td>
											<td><form:input path="bankAddressEdit"
													id="bankAddressEdit" class="textbox" /></td>
											<td><form:input path="micrCodeEdit" id="micrCodeEdit"
													class="textbox" /></td>
											<td><form:input path="ifscCodeEdit" id="ifscCodeEdit"
													class="textbox" /></td>
											<td><form:input path="accountTypeEdit"
													id="accountTypeEdit" class="textbox" /></td>
											<td><form:input path="accountNumberEdit"
													id="accountNumberEdit" class="textbox" /><input
												type="hidden" name="vendorBankDetIdEdit"
												id="vendorBankDetIdEdit" class="textbox" value="0" /><input
												type="hidden" name="Check" id="Check" value="0" /></td>

											<td><a href="#" id="addBankEdit"><img
													src="images/add (1).png"></img></a></td>


											<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
											<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

											<script type="text/javascript">
												$(document)
														.ready(
																function() {
																	$(function() {

																		//fadeout selected item and remove
																		$(
																				'.remove')
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

																		$(
																				'.updateDeleteBank')
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

																		//alert("came to add")
																		var options = '<table border="0"><tr><td>'
																				+ '<table style="float:left;" border="0" ><tr>'
																				+ ' <td><form:input path="bankNameEdit" id="bankNameEdit" class="textbox" /></td><td><form:input path="bankAddressEdit" id="bankAddressEdit" class="textbox" /></td> <td><form:input path="micrCodeEdit" id="micrCodeEdit" class="textbox" /></td>	<td><form:input path="ifscCodeEdit" id="ifscCodeEdit" class="textbox" /></td><td><form:input path="accountTypeEdit" id="accountTypeEdit" class="textbox" /></td> <td><form:input path="accountNumberEdit" id="accountNumberEdit" class="textbox" /></td>'
																				+ '</td></tr></table>'
																				+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';

																		//add input
																		$(
																				'#addBankEdit')
																				.click(
																						function() {
																							$(
																									options)
																									.fadeIn(
																											"slow")
																									.appendTo(
																											'#extenderEdit');
																							//	alert("affk");
																							i++;
																							return false;
																						});

																	});

																});
											</script>



										</tr>



									</table>
									<div id="extenderEdit"></div>




								</div>

							</div>
						</div>
						<div id="tabs-22">
							<div align="center">
								<table class="tableGeneral">

									<c:forEach var="vendorDocumentEditValues"
										items="${vendorDocumentsValues}">
										<tr id="${vendorDocumentEditValues.vendorDocId}">
											<td>Document Name</td>
											<td><input type="text" name="documentName"
												id="documentName" class="textbox"
												value="${vendorDocumentEditValues.documentName}" /></td>
											<td>Uploaded File Path :</td>
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
												onclick="checkDoc(this)"><img
													src="images/button_cancel.png" height="25px" width="25px"></img></a>
												<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
												<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
												<script type="text/javascript">
													function checkDoc(link) {

														alert("Deleting Particular Row Will Deleted Once You Click Update Button Doc");
														//alert(y);
														document
																.getElementById(link.id
																		+ "CheckDoc").value = "1";
														document
																.getElementById(link.id).style.display = "none";
													}
												</script></td>
										</tr>
									</c:forEach>

									<tr>
										<td>Document Name</td>
										<td><form:input path="documentNameEdit"
												id="documentNameEdit" class="textbox" /> <input
											type="hidden" name="checkPrevious" id="checkPrevious"
											value="0" /></td>
										<td>Please select a file to upload :</td>
										<td><input type="file" name="fileEdit" /></td>
										<td><a href="#" id="editDocument"><img
												src="images/add (1).png"></img></a></td>
										<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

										<script type="text/javascript">
											$(document)
													.ready(
															function() {
																$(function() {

																	//fadeout selected item and remove
																	$('.remove')
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
																	//alert("came to add")
																	var options = '<table border="0"><tr><td>'
																			+ '<table style="float:left;" border="0" ><tr>'
																			+ ' <td>Document Name</td><td><form:input path="documentNameEdit" id="documentNameEdit" class="textbox" /> </td><td>Please select a file to upload :</td><td><input type="file" name="fileEdit" /></td>'
																			+ '</td></tr></table>'
																			+ '<a href="#" style="float:left; margin:0px 0 0 5px;" class="remove"><strong><img src="images/button_cancel.png" height="25px" width="25px" /></strong></a></td></tr></table>';

																	//add input
																	$(
																			'#editDocument')
																			.click(
																					function() {
																						$(
																								options)
																								.fadeIn(
																										"slow")
																								.appendTo(
																										'#extenderDocumentEdit');
																						//	alert("affk");
																						i++;
																						return false;
																					});

																});

															});
										</script>
									</tr>






								</table>
								<div id="extenderDocumentEdit"></div>

							</div>
						</div>
						<!-- <div id="tabs-23">
    <div align="center">
	
						
						<div id="extenderMatrialEdit"/>
						
	</div>
  </div> -->


					</div>
				</form:form>
			</c:forEach>
		</div>
	</div>


	</div>

</body>
</html>




