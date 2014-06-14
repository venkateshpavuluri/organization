<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="js/jquery-ui-1.10.4.custom/jquery.ui.all.css" />
	<script src="js/jquery-ui-1.10.4.custom/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom/jquery.ui.core.js"></script>
	<script src="js/jquery-ui-1.10.4.custom/jquery.ui.widget.js"></script>
	<script src="js/jquery-ui-1.10.4.custom/jquery.ui.mouse.js"></script>
	<script src="js/jquery-ui-1.10.4.custom/jquery.ui.sortable.js"></script>
	<script type="text/javascript" src="js/google-chart.js"></script>
 <script type="text/javascript">	
 google.load("visualization", "1", {packages:["corechart"]});
 $(document).ready(function() {
		$.ajax({
			type : "POST",
			url : "getAllSalesOrderByYear.mnt",
			dataType: "json",
			success : function(dgd) {
				getYears(dgd);
				},
			error : function(e) {			
			}
		});
 });
var x,y;
function getYears(datad) {
	x='Material';
	y='MatPCT';
	 var s9=[];
	 s9.push([x,y]);
	$.each(datad, function(idxw, objw) {
		 x=objw.material;
		 y=objw.matpct;
		 s9.push([x,y]);
	});
	getSalesOrder(s9);
}</script>
   <script type="text/javascript">
   function getSalesOrder(Array)
   {google.load("visualization", "1", {packages:["corechart"]});google.setOnLoadCallback(drawChart(Array));  
   }
   function drawChart(Array) {
     var datai = google.visualization.arrayToDataTable(Array);
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
     chart.draw(datai); 
   }
    </script>  
	<style type="text/css">
    .note {
        font-size: 0.8em;
    }
    .jqplot-yaxis-tick {
      white-space: nowrap;
    }
  </style>
</head>
<body>
<div id="piechart"></div>
</body>
	