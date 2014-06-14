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

<title>Insert title here</title>
<script language="javascript" type="text/javascript">
<!--
function popitup(x) {
	if(x==''){
		$('#poReport').validate(
				{
					rules : {
						poNo : {
							required : true,
						},
						
					},
					messages : {
						poNo : "<font style='color: red;'><b>Purchase Order  Number is Required</b></font>",
						
					},

				});
	}else{
		url='generatePOReportWithChild.mnt?poNo='+x;
		newwindow=window.open(url,'name','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=1000,width=1200');
		
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
</head>
<body>
	<div id="userdefault" align="left">
		<div class="PageTitle">Purchase Order With Child Report</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="Report">Report</a></li>

			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">

					<form:form action="/generatePOReportWithChild.mnt" id="poReport" method="GET" commandName="poReportCmd">
						<table class="tableGeneral">

							<tr>
								<td><s:message code="label.poNo" /><font
									color="red"><strong>*</strong></font>:</td>
								<td><form:select path="poNo"
										class="select">
										<form:option value="">-Select-</form:option>
										<form:options items="${po}" />
									</form:select></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="<s:message code="label.reportSubmit" />"
									id="subid" class="btn btn-primary" onclick="return popitup(document.getElementById('poNo').value)"/></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>