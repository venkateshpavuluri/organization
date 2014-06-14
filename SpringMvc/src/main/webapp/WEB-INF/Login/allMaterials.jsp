 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="en">

<head>
	<meta charset="utf-8">
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center" id="tabs-2" class="TabbedPanelsContent">
<table class="table">
  <c:if test="${allMaterials!=null }">
					<display:table id="purReqRow" name="allMaterials"
						pagesize="5" requestURI="allmaterialsDisplayHome.mnt" class="table">
						<display:column property="material" titleKey="label.material" ></display:column>
						<display:column property="quantity" titleKey="label.quantity" ></display:column>
						<display:setProperty name="paging.banner.placement" value="bottom" />

						<display:setProperty name="paging.banner.group_size" value="3" />

			

							<display:setProperty name="paging.banner.some_items_found"
								value="<span class='pagebanner'>{0} {1},listing {2} to {3}. </span>" />
					</display:table>
					</c:if>

</table>
</div>

<!-- <div id="chart1" align="center"> </div> -->
<%-- <div class="divUserDefault">
		<div class="PageTitle"><spring:message code="label.dashboard" /></div>
		<div id="tabs" class="TabbedPanels">
		
		<div class="column">
<!--------------------------------------------- Total Stock begin --------------------------------------------------------------------->	
	<div class="portlet">
		<div class="portlet-header"><spring:message code="label.top5Materials"/> </div>

		    <div id="chart1" class="portlet-content" style="width:500px; height:250px;"></div>
	</div>
	</div>
	</div>
	</div> --%></body>
	