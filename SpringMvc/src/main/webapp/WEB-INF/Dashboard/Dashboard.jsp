
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="en">

<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="js/jquery-ui-1.10.4.custom/jquery.ui.all.css" />
<script src="js/jquery-ui-1.10.4.custom/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom/jquery.ui.core.js"></script>
<script src="js/jquery-ui-1.10.4.custom/jquery.ui.widget.js"></script>
<script src="js/jquery-ui-1.10.4.custom/jquery.ui.mouse.js"></script>
<script src="js/jquery-ui-1.10.4.custom/jquery.ui.sortable.js"></script>
<!-- <link rel="stylesheet" href="js/jquery-ui-1.10.4.custom/demos.css"/> -->

<!-- jqplot start -->

<!--    <link class="include" rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.4.custom/jquery.jqplot.min.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.4.custom/examples.min.css" />
    <link type="text/css" rel="stylesheet" href="js/jquery-ui-1.10.4.custom/shCoreDefault.min.css" />
    <link type="text/css" rel="stylesheet" href="js/jquery-ui-1.10.4.custom/shThemejqPlot.min.css" /> -->

<!-- jqplot end -->


<script type="text/javascript">
  function popitup(url) {
    //var filepath =document.getElementById("docPathEdit").value;
    newwindow = window
            .open(
                    url,
                    'name',
                    'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=800,width=900');

    if (window.focus) {
      newwindow.focus();
    }
    return false;
  }
</script>
<script type="text/javascript" src="js/google-chart.js"></script>



<script type="text/javascript">
  $(document)
          .ready(
                  function() {
                    $("#userdata thead th").remove();
                    $("#userdata tbody tr").remove();
                    $
                            .ajax({
                              type: "POST",
                              url: "getStockDetailsHome.mnt",

                              dataType: "json",
                              success: function(data) {
                                if (data == "") {
                                  $("#userdata thead th").remove();
                                } else {
                                  $('#noSortData').hide();
                                  var tHead = "<tr><th>Material</th><th>Storage Location</th><th>Batch Number</th> <th>Available Quantity</th></tr>";
                                  $(tHead).appendTo("#userdata thead");
                                  $('#result').show();
                                  $.each(data, function(i, user) {
                                    var tblRow = "<tr>" + "<td>"
                                            + user.materialName + "</td>"
                                            + "<td>" + user.storageLocName
                                            + "</td>" + "<td>" + user.batchNo
                                            + "</td>" + "<td>" + user.qtyAval
                                            + "</td></tr>";
                                    $(tblRow).appendTo("#userdata tbody");
                                  });
                                  $('#userdata').tablePagination({});
                                  //$('#sortlist').show();
                                }
                              },
                              error: function(e) {
                              }
                            });
                  });

  function getTotalStock(id) {
    var storageId = $('#' + id).val();

    $("#userdata thead th").remove();
    $("#userdata tbody tr").remove();
    $
            .ajax({
              type: "POST",
              url: "getStockDetails.mnt",
              data: "storageId=" + storageId,
              dataType: "json",
              success: function(data) {
                if (data == "") {
                  $("#userdata thead th").remove();
                } else {
                  $('#noSortData').hide();
                  var tHead = "<tr><th>Material</th><th>Storage Location</th><th>Batch Number</th> <th>Available Quantity</th></tr>";
                  $(tHead).appendTo("#userdata thead");
                  $('#result').show();
                  $.each(data, function(i, user) {
                    var tblRow = "<tr>" + "<td>" + user.materialName + "</td>"
                            + "<td>" + user.storageLocName + "</td>" + "<td>"
                            + user.batchNo + "</td>" + "<td>" + user.qtyAval
                            + "</td></tr>";
                    $(tblRow).appendTo("#userdata tbody");
                  });
                  $('#userdata').tablePagination({});
                  //$('#sortlist').show();
                }
              },
              error: function(e) {
              }
            });

  }
</script>
<script type="text/javascript">
  $(document).ready(function() {
    $.ajax({
      type: "POST",
      url: "getTop5OrderItems.mnt",
      dataType: "json",
      success: function(response) {

        if (response == "") {
          var msg = "No Data Availabel";
          document.getElementById('chart1').value = msg;
          $('#top5Material').hide();
        } else {
          load(response);
        }
      },
      error: function(e) {
      }
    });

  });
</script>

<script type="text/javascript">
  function getSalesOrderItemsByYear(id) {
    var years = $('#' + id).val();
    $.ajax({
      type: "POST",
      url: "getsalesOrderByYear.mnt",
      data: "years=" + years,
      dataType: "json",
      success: function(dgd) {
        getYears(dgd);
      },
      error: function(e) {
      }
    });
  }
  var x, y;
  function getYears(datad) {
    x = 'Material';
    y = 'MatPCT';
    var s9 = [];

    s9.push([x, y]);
    $.each(datad, function(idxw, objw) {
      x = objw.material;
      y = objw.matpct;
      s9.push([x, y]);
      //s2.push([b]);
    });
    getSalesOrder(s9);
  }
</script>


<script type="text/javascript">
  function getSalesOrder(Array) {
    google.load("visualization", "1", {
      packages: ["corechart"]
    });
    google.setOnLoadCallback(drawChart(Array));
  }
  function drawChart(Array) {
    var datai = google.visualization.arrayToDataTable(Array);
    /*   var optionsi = {
        title: 'Sales Order Items per year'
      }; */

    var chart = new google.visualization.PieChart(document
            .getElementById('piechart'));
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

<style>
body {
	min-width: 520px;
}

.column {
	width: 491px;
	float: left;
	padding-bottom: 100px;
}

.portlet {
	margin: 0 1em 1em 0;
	padding: 0.3em;
}

.portlet-header {
	padding: 0.2em 0.3em;
	margin-bottom: 0.5em;
	position: relative;
}

.portlet-toggle {
	position: absolute;
	top: 50%;
	right: 0;
	margin-top: -8px;
}

.portlet-content {
	padding: 4em;
}

.portlet-placeholder {
	border: 1px dotted black;
	margin: 0 1em 1em 0;
	height: 50px;
}
</style>
<script type="text/javascript">
  google.load("visualization", "1", {
    packages: ["corechart"]
  });
  var b, a, c;
  function load(data) {
    var s1 = [];
    $.each(data, function(idx, obj) {
      a = obj.material;
      b = obj.quantity;
      s1.push([a, b]);
      //s2.push([b]);
    });
    displayMaterials(s1);
    var barsVisualization;

    function displayMaterials(Array) {
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Material');
      data.addColumn('number', 'Quantity');
      data.addRows(Array);

      barsVisualization = new google.visualization.ColumnChart(document
              .getElementById('chart1'));
      barsVisualization.draw(data, {
        vAxis: {
          'title': 'Quantity'
        },
        hAxis: {
          'title': 'Material'
        }
      });

      // Add our over/out handlers.
      google.visualization.events.addListener(barsVisualization, 'onmouseover',
              barMouseOver);
      google.visualization.events.addListener(barsVisualization, 'onmouseout',
              barMouseOut);
    }

    function barMouseOver(e) {
      barsVisualization.setSelection([e]);
    }

    function barMouseOut(e) {
      barsVisualization.setSelection([{
        'row': null,
        'column': null
      }]);
    }
  }
  $(function() {
    $(".column").sortable({
      connectWith: ".column",
      handle: ".portlet-header",
      cancel: ".portlet-toggle",
      placeholder: "portlet-placeholder "
    });

    $(".portlet")
            .addClass(
                    "ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
            .find(".portlet-header")
            .addClass("ui-widget-header ui-corner-all")
            .prepend(
                    "<span class='ui-icon ui-icon-minusthick portlet-toggle'></span><span class='ui-icon ui-icon-close close'></span>");

    $(".portlet-toggle").click(function() {
      var icon = $(this);
      icon.toggleClass("ui-icon-minusthick ui-icon-plusthick");
      icon.closest(".portlet").find(".portlet-content").toggle();
    });

    $(".close").click(function() {
      $(this).parents(".portlet:first").remove();
    });

  });

  /* $(function() {
  	$("#scroll").draggable({ scroll: true });
  	//$( "#draggable2" ).draggable({ scroll: true, scrollSensitivity: 100 });
  	//$( "#draggable3" ).draggable({ scroll: true, scrollSpeed: 100 });
  }); */
</script>
</head>
<body>
	<div class="divUserDefault">
		<div class="PageTitle">
			<spring:message code="label.dashboard" />
		</div>
		<div id="tabs" class="TabbedPanels">

			<div class="column">
				<!--------------------------------------------- Total Stock begin --------------------------------------------------------------------->
				<div class="portlet">
					<div class="portlet-header">
						<spring:message code="label.top5Materials" />
					</div>

					<div align="left" id="chart1" class="portlet-content"
						style="width: 410px; height: 250px;">
						<div></div>

					</div>

					<div align="right" id="top5Materials">
						<a href="" onclick="return popitup('allmaterialsDisplayHome.mnt')">
							<h4>
								<u>View More</u>
							</h4>
						</a>
					</div>
				</div>

				<div class="portlet">
					<div class="portlet-header">
						<spring:message code="label.totalStock" />
					</div>
					<div class="portlet-content"
						style="height: 150px; overflow-y: scroll; overflow-x: scroll;">
						<form:form action="" commandName="dashboardCommand" method="POST">
							<table class="tableGeneral">
								<tr>
									<td><spring:message code="label.storageLocation" /></td>
									<td><form:select path="storageLocationId" id="storage"
											onchange="getTotalStock(this.id)">
											<form:option value="">--Select--</form:option>
											<form:options items="${storageDetails}"></form:options>
										</form:select></td>
								</tr>
							</table>
							<table id="userdata" border="1" class="table">
								<thead>
								</thead>
								<tbody>
								</tbody>
							</table>
						</form:form>
					</div>
				</div>
				<!--------------------------------------------- Total Stock End --------------------------------------------------------------------->

				<!--------------------------------------------- Invoice To Pay begin --------------------------------------------------------------------->
				<div class="portlet">
					<div class="portlet-header">
						<spring:message code="label.invoiceToPay" />
					</div>
					<div class="portlet-content" align="right"
						style="height: 150px; overflow-y: scroll; overflow-x: scroll;">
						<table class="table">
							<tr>
								<c:choose>
									<c:when test="${not empty invoiceToPays}">
										<th><spring:message code="label.vendorInvoiceNo" /></th>
										<th><spring:message code="label.vendor" /></th>
										<th><spring:message code="label.amount" /></th>
										<th><spring:message code="label.recievedAmount" /></th>
										<th><spring:message code="label.pendingAmount" /></th>
										<th><spring:message code="label.currency" /></th>
										<th><spring:message code="label.date" /></th>
									</c:when>
									<c:otherwise>
										<spring:message code="label.noData" />
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<c:forEach items="${invoiceToPays}" var="invoiceToPay">
									<tr>
										<td><c:out value="${invoiceToPay.vendorInvoiceNo}"></c:out>
										</td>
										<td><c:out value="${invoiceToPay.vendor}"></c:out></td>
										<td><c:out value="${invoiceToPay.amount}"></c:out></td>
										<td><c:out value="${invoiceToPay.recievedAmount}"></c:out>
										</td>
										<td><c:out value="${invoiceToPay.pendingAmount}"></c:out>
										</td>
										<td><c:out value="${invoiceToPay.currency}"></c:out></td>
										<td><c:out value="${invoiceToPay.date}"></c:out></td>
									</tr>
								</c:forEach>
							</tr>
						</table>
						<c:if test="${not empty invoiceToPays}">
							<a href="" onclick="return popitup('allinvoiceToPay.mnt')">
								<h4>
									<u>View More</u>
								</h4>
							</a>
						</c:if>
					</div>

				</div>

				<div class="portlet">
					<div class="portlet-header">
						<spring:message code="label.goodsDeliveryintheyear" />
					</div>
					<div class="portlet-content"
						style="height: 150px; overflow-y: scroll; overflow-x: scroll;">
						<table class="table">
							<tr>
								<c:choose>
									<c:when test="${not empty deliveryInTheYears}">
										<th><spring:message code="label.materialName" /></th>
										<th><spring:message code="label.deliveryQty" /></th>
									</c:when>
									<c:otherwise>
										<spring:message code="label.noData" />
									</c:otherwise>
								</c:choose>


							</tr>
							<c:forEach items="${deliveryInTheYears}" var="deliveryInTheYears">
								<tr>
									<td><c:out value="${deliveryInTheYears.materialName }"></c:out>
									</td>
									<td><c:out value="${deliveryInTheYears.deliveredQty }"></c:out>
									</td>

								</tr>
							</c:forEach>
						</table>
						<div align="right">

							<c:if test="${not empty deliveryInTheYears }">
								<a href="" onclick="return popitup('allGoodsDelivery.mnt')">
									<h4>
										<u>View More</u>
									</h4>
								</a>
							</c:if>
						</div>

					</div>
				</div>

				<!------------------- Get Pending Leave Request ------------------>

				<div class="portlet">
					<div class="portlet-header">
						<spring:message code="label.pendingLeaveRequest" />
					</div>
					<div class="portlet-content"
						style="height: 150px; overflow-y: scroll; overflow-x: scroll;">
						<table class="table">
							<tr>
								<c:choose>
									<c:when test="${not empty getPendingLeaveRequest}">
										<th><spring:message code="label.employee" /></th>
										<th><spring:message code="label.department" /></th>
										<th><spring:message code="label.leaveTypeId" /></th>
										<th><spring:message code="label.mobileNumber" /></th>
										<%-- <th><spring:message code="label.statusId" /></th> --%>
									</c:when>
									<c:otherwise>
										<spring:message code="label.noData" />
									</c:otherwise>
								</c:choose>


							</tr>
							<c:forEach items="${getPendingLeaveRequest}"
								var="getPendingLeaveRequest">
								<tr>
									<td><c:out value="${getPendingLeaveRequest.employee }"></c:out>
									</td>
									<td><c:out value="${getPendingLeaveRequest.department }"></c:out>
									</td>
									<td><c:out value="${getPendingLeaveRequest.leaveType }"></c:out>
									</td>
									<td><c:out value="${getPendingLeaveRequest.mobile}"></c:out>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>

				<!--------------------------------------------- Invoice To Pay End --------------------------------------------------------------------->


			</div>
		</div>

		<div class="column">
			<!--------------------------------------------- Invoice To Pay begin --------------------------------------------------------------------->
			<div class="portlet">
				<div class="portlet-header">
					<spring:message code="label.salesOrderItems" />
				</div>
				<div class="portlet-content" style="width: 390px; height: 250px;">
					<form:form commandName="dashboardCommand" method="POST">
						<table>
							<tr>
								<td><spring:message code="label.year" /></td>
								<td><form:select path="year" id="year"
										onchange="getSalesOrderItemsByYear(this.id)" cssClass="select">
										<form:option value="">--Select--</form:option>
										<form:options items="${allYears}" />
									</form:select></td>
							</tr>
						</table>
					</form:form>
					<div id="piechart"></div>
				</div>
				<div align="right" id="salesOrderItems">
					<a href="" onclick="return popitup('allSalesOrderItemsHome.mnt')">
						<h4>
							<u>View More</u>
						</h4>
					</a>
				</div>
			</div>


			<div class="portlet">
				<div class="portlet-header" align="top">
					<spring:message code="label.invoiceToCollect" />
				</div>
				<div class="portlet-content"
					style="height: 150px; overflow-y: scroll; overflow-x: scroll;">
					<table class="table">
						<tr>
							<c:choose>
								<c:when test="${ not empty invoiceToCollects}">
									<th><spring:message code="label.customerInvoiceNo" /></th>
									<th><spring:message code="label.customer" /></th>
									<th><spring:message code="label.amount" /></th>
									<th><spring:message code="label.recievedAmount" /></th>
									<th><spring:message code="label.pendingAmount" /></th>
									<th><spring:message code="label.currency" /></th>
									<th><spring:message code="label.date" /></th>
								</c:when>
								<c:otherwise>
									<spring:message code="label.noData" />
								</c:otherwise>
							</c:choose>
						</tr>

		
	
		</table>
		<c:if test="${not empty invoiceToPays}">
				<a href="" onclick="return popitup('allinvoiceToPay.mnt')"> <h4><u>View More</u></h4> </a>
		</c:if>
		</div>
			
	</div>
	
	
	<div class="portlet">
		<div class="portlet-header"><spring:message code="label.goodsDeliveryintheyear"/> </div>
		<div class="portlet-content"  style="height: 150px; overflow-y:scroll; overflow-x: scroll;">
		<table class="table">
		<tr>
		<c:choose>
		<c:when test="${not empty deliveryInTheYears}">
		<th><spring:message code="label.materialName"/> </th>
		<th><spring:message code="label.deliveryQty"/></th>
		</c:when>
		<c:otherwise>
	<spring:message code="label.noData"/>
		</c:otherwise>
		</c:choose>
		
=======
						<c:forEach items="${invoiceToCollects}" var="invoiceToCollects">
							<tr>
								<td><c:out value="${invoiceToCollects.customerNo}"></c:out>
								</td>
								<td><c:out value="${invoiceToCollects.customer}"></c:out></td>
								<td><c:out value="${invoiceToCollects.amount}"></c:out></td>
								<td><c:out value="${invoiceToCollects.recievedAmount}"></c:out>
								</td>
								<td><c:out value="${invoiceToCollects.pendingAmount}"></c:out>
								</td>
								<td><c:out value="${invoiceToCollects.currency}"></c:out></td>
								<td><c:out value="${invoiceToCollects.date}"></c:out></td>
							</tr>
						</c:forEach>
>>>>>>> .r8305

					</table>
					<c:if test="${ not empty invoiceToCollects}">
						<div align="right">

							<a href="" onclick="return popitup('allinvoiceToCollects.mnt')">
								<h4>
									<u>View More</u>
								</h4>
							</a>

						</div>
					</c:if>
				</div>

			</div>
			<!--------------------------------------------- Invoice To Collect End --------------------------------------------------------------------->

			<!--------------------------------------------- Pending PurchaseOrder begin --------------------------------------------------------------------->
			<div class="portlet">
				<div class="portlet-header">
					<spring:message code="label.pendingPurchaseOrder" />
				</div>
				<div class="portlet-content"
					style="height: 150px; overflow-y: scroll; overflow-x: scroll;">

					<table class="table">
						<tr>
							<c:choose>
								<c:when test="${not empty pendingPo }">
									<th><spring:message code="label.purchaseOrderNo" /></th>
									<th><spring:message code="label.vendor" /></th>
									<th><spring:message code="label.dueDate" /></th>
								</c:when>
								<c:otherwise>
									<spring:message code="label.noData" />
								</c:otherwise>
							</c:choose>

						</tr>

<<<<<<< .mine

<div class="column">
	<!--------------------------------------------- Invoice To Pay begin --------------------------------------------------------------------->
	<div  class="portlet" >
		<div class="portlet-header"><spring:message code="label.salesOrderItems"/> </div>
		<div class="portlet-content"  style="width: 390px; height: 250px;">
		<form:form commandName="dashboardCommand" method="POST">
		<table>
		<tr>
		<td><spring:message code="label.year"/> </td><td><form:select path="year" id="year" onchange="getSalesOrderItemsByYear(this.id)" cssClass="select">
		<form:option value="">--Select--</form:option>
		<form:options items="${allYears}"/>
		</form:select> </td>
		</tr>
		</table>
		</form:form>
		<div id="piechart">  </div> 
		</div>
		<div align="right" id="salesOrderItems" >	<a href="" onclick="return popitup('allSalesOrderItemsHome.mnt')"> <h4><u>View More</u></h4> </a> </div>
	</div>
	
=======
						<c:forEach items="${pendingPo}" var="pendingPo">
							<tr>
								<td><c:out value="${pendingPo.purchaseOrderNo }"></c:out></td>
								<td><c:out value="${pendingPo.vendorName }"></c:out></td>
								<td><c:out value="${pendingPo.dueDate }"></c:out></td>
							</tr>
						</c:forEach>
					</table>
					<c:if test="${not empty pendingPo }">
						<div align="right">
>>>>>>> .r8305

							<a href="" onclick="return popitup('allPendingPoOrder.mnt')">
								<h4>
									<u>View More</u>
								</h4>
							</a>
						</div>
					</c:if>
				</div>
			</div>
			<!--------------------------------------------- Pending PurchaseOrder End --------------------------------------------------------------------->

			<!--------------------------------------------- To be Reordered Material begin --------------------------------------------------------------------->
			<div class="portlet">
				<div class="portlet-header">
					<spring:message code="label.tobeReorderedMaterial" />
				</div>
				<div class="portlet-content"
					style="height: 150px; overflow-y: scroll; overflow-x: scroll;">

					<table class="table">
						<tr>
							<c:choose>
								<c:when test="${ not empty reorederMaterial}">
									<th><spring:message code="label.material" /></th>
									<th><spring:message code="label.qtyAvailable" /></th>
									<th><spring:message code="label.reorderLevel" /></th>
									<th><spring:message code="label.uom" /></th>
								</c:when>
								<c:otherwise>
									<spring:message code="label.noData" />
								</c:otherwise>
							</c:choose>
						</tr>
						<c:forEach items="${reorederMaterial}" var="reorederMaterial">
							<tr>
								<td><c:out value="${reorederMaterial.materialName }"></c:out>
								</td>
								<td><c:out value="${reorederMaterial.qtyAvailabale }"></c:out>
								</td>
								<td><c:out value="${reorederMaterial.reorderLevel }"></c:out>
								</td>
								<td><c:out value="${reorederMaterial.uom }"></c:out></td>
							</tr>
						</c:forEach>
					</table>
					<c:if test="${ not empty reorederMaterial}">
						<div align="right">
							<a href="" onclick="return popitup('allToBeReorderMatHome.mnt')">
								<h4>
									<u>View More</u>
								</h4>
							</a>
						</div>
					</c:if>
				</div>
			</div>
<!--------------------------------------------- To be Reordered Material End --------------------------------------------------------------------->
<div class="portlet">
				<div class="portlet-header">
					<spring:message code="label.scheduleInterviews" />
				</div>
				<div class="portlet-content"
					style="height: 150px; overflow-y: scroll; overflow-x: scroll;">
					<table class="table">
						<tr>
							<c:choose>
								<c:when test="${ not empty scheduleInterviewsBeans}">
									<th><spring:message code="label.applicant" /></th>
									<th><spring:message code="label.scheduledDate" /></th>
									<th><spring:message code="label.scheduledTime" /></th>
									<th><spring:message code="label.interviewRound" /></th>
									<th><spring:message code="label.assignedTo" /></th>
								</c:when>
								<c:otherwise>
									<spring:message code="label.noData" />
								</c:otherwise>
							</c:choose>
						</tr>
						<c:forEach items="${scheduleInterviewsBeans}" var="scheduleInterviewsBeans">
							<tr>
								<td><c:out value="${scheduleInterviewsBeans.applicantName }"></c:out>
								</td>
								<td><c:out value="${scheduleInterviewsBeans.scheduleDate }"></c:out>
								</td>
								<td><c:out value="${scheduleInterviewsBeans.scheduleTime }"></c:out>
								</td>
								<td><c:out value="${scheduleInterviewsBeans.interviewRound }"></c:out></td>
								<td><c:out value="${scheduleInterviewsBeans.assignTo }"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		
	</div>
</body>
</html>








