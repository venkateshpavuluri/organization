<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <link href="accordionmenu.css" rel="stylesheet" type="text/css">
</head>

<body>
<!--Header-->
<div id="header"><tiles:insertAttribute name="header" /></div>
<table width="99.2%" border="0" cellspacing="0" cellpadding="0" id="wrapper">
  <tr>
    <td id="leftMenu" class="contextMenu" valign="top">
		<tiles:insertAttribute name="menu" />
	</td>
    <td valign="middle" align="center" onclick="return ToogleLeftMenu();" class="ExpanCollapseimgExp" id="tdToogle" style="min-height: 300px;"><img class="Expand" alt="" id="imgToogle" src="images/expandCollapse_icon.png" style="vertical-align:middle;"></td>
    <td class="contentWrapper" valign="top">
    	<div id="divMyPreferences"><tiles:insertAttribute name="body" /></div>
    </td>
   </tr>    
</table>
<!--Footer-->
<div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>