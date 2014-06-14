<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
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
	function loadXMLDocEdit() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("goodsReceiptTypeNum").innerHTML = xmlhttp.responseText;
			}
		};
		var goodsReceipt = document.getElementById("goodsReceiptType_Id");
		//alert(goodsReceipt);

		var selectedText = goodsReceipt.options[goodsReceipt.selectedIndex].text;
		//alert(selectedText);

		var url = "/MNTERP/purchasedetailsreport.mnt?goodsReceipt=" + selectedText;
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script>
<script type="text/javascript">
$( document ).ready(function() {
	$( "#receivingDate" ).datepicker({ dateFormat: "yy-mm-dd",changeMonth:true,
		changeYear:true });
	});

</script>
<script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>
<script language="javascript" type="text/javascript">
<!--
function popitup(x,y,r,s) {
	url='generateGRReport.mnt?goodsReceiptType_Id='+x+'&goodsReceiptTypeNum='+y+'&vendor_Id='+r+'&receivingDate='+s;
	newwindow=window.open(url,'name','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=1000,width=1200');
	
	if (window.focus) {
		newwindow.focus();
		}
	return false;
}

// -->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="userdefault" align="left">
		<div class="PageTitle">Goods Receipt Report</div>
		<div id="tabs" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<li class="TabbedPanelsTab"><a href="#tabs-2" id="Report">Report</a></li>

			</ul>
			<div id="tabs-2" class="TabbedPanelsContent">
				<div align="left">
	
 
	
	<form:form  action="/generateGRReport.mnt" method="GET" commandName="GoodsReceiptCommand" >
   <table class="tableGeneral">
  <tr>
									<td><spring:message code="label.goodsReceiptType" /></td>
									<td><form:select path="goodsReceiptType_Id"
											id="goodsReceiptType_Id" class="select"
											onchange="loadXMLDocEdit(this)">
											<form:option value="0">--- Select ---</form:option>
											<form:options items="${goodsReceiptType }" />
										</form:select></td></tr>
									<tr>
									<td><spring:message code="label.goodsReceiptTypeNumber" /></td>
									<td><form:select path="goodsReceiptTypeNum"
											id="goodsReceiptTypeNum" class="select">
											<form:option value="0">--- Select ---</form:option>
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
								<tr>
								<td><spring:message code="label.recevingdate" /><font color="red">*</font></td>
									<td><form:input path="receivingDate" id="receivingDate"
											class="textbox" /></td>
								</tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Generate Report" onclick="return popitup(document.getElementById('goodsReceiptType_Id').value,document.getElementById('goodsReceiptTypeNum').value,document.getElementById('vendor_Id').value,document.getElementById('receivingDate').value) " class="btn btn-primary" />
        </td>
    </tr>
</table>  
</form:form>
</div>
			</div>
		</div>
	</div>
</body>
</html>