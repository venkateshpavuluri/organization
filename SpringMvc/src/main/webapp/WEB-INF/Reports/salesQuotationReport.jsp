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
 
<title>Sales Quotation Report</title>
<script language="javascript" type="text/javascript">

function popitup(x) {
	
	
	if(x=='')
		{
				$('#salesQuo')
						.validate(
								{
									rules : {
										sqNo : {
											required : true
										},
										
									},
									messages : {
										sqNo : "<font style='color: red;'><b>Sales Quotation Number is Required</b></font>",
										
									},

								});
		}
	else
		{
			url='generateSalesQuoPwcReport.mnt?sqNo='+x;
			newwindow=window.open(url,'name','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=1000,width=1200');
	
			if (window.focus) {
				newwindow.focus();
			}
		return false;
	}
}

</script>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>

</head>
<body>
	<div id="userdefault" align="left">
		<div class="PageTitle">Sales Quotation Order Report</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="Report">Report</a></li>

			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="/generateSalesQuoPwcReport.mnt" id="salesQuo"
						method="GET" commandName="sqoReportCmd">
						<table class="tableGeneral">

							<tr>
									<td><s:message code="label.sqNo" /><font
									color="red"><strong>*</strong></font>:</td>
									<td><form:select path="sqNo"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${sqo}" />
									</form:select></td>
								</tr>
								<tr>
							<tr>
								<td colspan="2"><input type="submit" value="<s:message code="label.reportSubmit" />"
									id="subid" class="btn btn-primary" onclick="return popitup(document.getElementById('sqNo').value)" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>