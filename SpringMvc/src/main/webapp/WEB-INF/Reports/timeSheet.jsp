<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
<script type="text/javascript" src="js/MntValidator.js"></script>
<title>Sales Order List</title>
<script language="javascript" type="text/javascript">
<!--
	function popitup(x, y) {
	if(x=='' || y==''){
		$('#attd')
		.validate(
				{
					rules : {
						reportId : {
							required : true
						},
						reportDate : {
							required : true
						},
						
					},
					messages : {
						reportId : "<font style='color: red;'><b>Month is Required</b></font>",
						reportDate:"<font style='color: red;'><b>Organization Name is Required</b></font>"
						
					},

				});
	}
		else{
		url = 'generateTimeSheetReport.mnt?reportId=' + x + '&reportDate=' + y;
		newwindow = window
				.open(
						url,
						'name',
						'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=1000,width=1200');

		if (window.focus) {
			newwindow.focus();
		}
		return false;
		}
	}
// -->
</script>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>
<%-- <script type="text/javascript">
$( document ).ready(function() {
	$( "#soDate" ).datepicker({ dateFormat: "yy-mm-dd",changeMonth:true,
		changeYear:true });
	});

</script> --%>

</head>
<body>
	<div id="userdefault" align="left">
		<div id="userdefault" align="left">
			<div class="PageTitle">Time Sheet Report</div>
			<div id="tabs" class="TabbedPanels">
				<ul class="TabbedPanelsTabGroup">
					<li class="TabbedPanelsTab"><a href="#tabs-2" id="Report">Report</a></li>

				</ul>
				<div id="tabs-2" class="TabbedPanelsContent">
					<div align="left">

						<form:form action="/generateTimeSheetReport.mnt" method="GET" commandName="tsCmd" id="attd">
							<table class="tableGeneral">
								<tr>
									<td>Enter Month<font
									color="red"><strong>*</strong></font>:</td>
									<td><form:select path="reportId"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${months}" />
									</form:select></td>
								</tr>
								<tr>
									<td><s:message code="label.organizationName" /><font
									color="red"><strong>*</strong></font></td>
									<td><form:select path="reportDate"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${org}" />
									</form:select></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="<s:message code="label.reportSubmit" />"
										onclick="return popitup(document.getElementById('reportId').value,document.getElementById('reportDate').value)"
										class="btn btn-primary" /></td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>