<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/demos/style.css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<!-- -->
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<title>Insert title here</title>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>
<script>
$(document)
			.ready(
					function() {
						//AddForm Validations

						$('#subid')
								.click(
										function(event) {

											$('#batchReport')
													.validate(
															{
																rules : {
																	grid : {
																		required : true
																	},
																	
																},
																messages : {
																	grid : "<font style='color: red;'><b>Goods Receipt Id is Required</b></font>",
																	
																},

															});
										});
					});
						</script>
</head>
<body>
	<div id="userdefault" align="left">
		<div class="PageTitle">Batch Report</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="Report">Report</a></li>

			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">


						<form:form  action="/generateBatchReport.mnt" method="GET" commandName="GoodsReceiptCommand" >
						<table class="tableGeneral">
						
						  <tr>
												<td><spring:message code="label.prmaterial" /><font color="red">*</font></td>
												<td><form:select path="materialids" class="select" id="materialids" cssStyle="height:25px">
															<form:option value="0">-Select-</form:option>
															<form:options items="${material }" />
														</form:select></td>
											</tr>

							<tr>
									<td><spring:message code="label.vendor" /></td>
									<td><form:select path="vendor_Id" id="vendor_Id"
											class="select">
											<form:option value="0">--- Select ---</form:option>
											<form:options items="${vendor }" />
										</form:select></td>
									
								</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>