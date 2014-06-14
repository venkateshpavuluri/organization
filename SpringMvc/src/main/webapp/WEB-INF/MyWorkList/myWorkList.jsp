<!-- @Copyright MNTSOFT
@author pvenkateswarlu
@version 1.0 05-10-2013 -->


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>jQuery UI Tabs - Default functionality</title>
 <link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="js/jqueryui.css" />

<link href="style.css" rel="stylesheet" type="text/css" /> 
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
	 <link href="js/jquery.css" rel="stylesheet" type="text/css"/> 
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 
  
<!-- <script>
      function loadModalWindow() {
         // open your window here
         var sOptions = "width=300,height=300,location=0,menubar=0,toolbar=0,status=0";
         
     // window.showModalDialog(this.href,'targetWindow','toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=250px,height=250px');
				window.showModalDialog("purReqView.mnt","return false",sOptions,"false");	
      }
  </script>  --> 
<!--  <script language="javascript" type="text/javascript">
<!--
function popitup(url) {
	newwindow=window.open(url,'name','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=400,width=600');
	
	if (window.focus) {
		newwindow.focus();
		}
	return false;
}


</script> -->
 <script type="text/javascript">

     function tb_parseQuery(query) {
        var Params = {};
        if (!query) { return Params; }// return empty object
        var Pairs = query.split(/[;&]/);
        for (var i = 0; i < Pairs.length; i++) {
            var KeyVal = Pairs[i].split('=');
            if (!KeyVal || KeyVal.length != 2) { continue; }
            var key = unescape(KeyVal[0]);
            var val = unescape(KeyVal[1]);
            val = val.replace(/\+/g, ' ');
            Params[key] = val;
        }
        return Params;
    } 
    $(document).ready(function () {
        $('a.uimodal').click( function () {     /* $('a.uimodal').bind('click', function () { */

        var $this = $(this);
        var url = $this.attr("href");
        var queryString = url.replace(/^[^\?]+\??/, '');
        var params = tb_parseQuery(queryString);
        TB_WIDTH = (params['width'] * 1) + 30 || 630; //defaults to 630 if no paramaters were added to URL
        TB_HEIGHT = (params['height'] * 1) + 40 || $(document).height(); //defaults to 440 if no paramaters were added to URL
            TB_Title = (params['title']);
        $('<div>').dialog({
            modal: true,
            open: function () {
                $(this).load(url);
            },
            height: TB_HEIGHT,
            width: TB_WIDTH,
            title: TB_Title
        });
        return false;
    });
    });
</script> 


</head>

<body>
	<c:forEach var="wkflowsuccess" items="${workflowupdatesuccess}">
		<c:out value="${wkflowsuccess}" />
	</c:forEach>
	<c:forEach var="purReqRow" items="${purchaseRequisition}">
					<c:set var="g" value="${purReqRow}"></c:set></c:forEach>
					
	
	<c:if test="${g!=null}">
	<center>
		<strong> Purchase Requisition Form</strong>
	</center>
		<div
			style="overflow-x:hidden;overflow-y:scroll;size:20px; height:150px;">

			<table class="table">

				<tr>
					<th><spring:message code="label.purchaseReqNo" /></th>
					<th><spring:message code="label.requestedBy" /></th>
					<th><spring:message code="label.requestedDate" /></th>
					<th><spring:message code="label.requiredDate" /></th>
					<th><spring:message code="label.description" /></th>
					<th><spring:message code="label.refNo" /></th>
					<th><spring:message code="label.status" /></th>
					<th><spring:message code="label.view" /></th>
				</tr>
				<c:forEach var="purReqRow" items="${purchaseRequisition}">
					<c:set var="g" value="${purReqRow}"></c:set>
					<tr>
						<td><c:out value="${purReqRow.purchaseReqNo}" /></td>
						<td><c:out value="${purReqRow.requestedBy}" /></td>
						<td><c:out value="${purReqRow.requestedDate}" /></td>
						<td><c:out value="${purReqRow.reqDate}" /></td>
						<td><c:out value="${purReqRow.description}" /></td>
						<td><c:out value="${purReqRow.refNo}" /></td>
						<td><c:out value="${purReqRow.status}" /></td>
						<td><a class="uimodal"
							href="purReqView.mnt?purReqviewId=<c:out value="${purReqRow.purchaseReq_Id}"/>&workFlowListId=<c:out value="${purReqRow.workFlowListId}"/>&height=350&width=700&title=WorkList"
							style="color:block"><img src="images/Edit.jpg" width="20px"
								height="20px" onclick="loadModalWindow()" /> </a></td>
				<%-- 	purReqView.mnt?purReqviewId=<c:out value="${purReqRow.purchaseReq_Id}"/>&workFlowListId=<c:out value="${purReqRow.workFlowListId}"/>" --%>
					</tr>
				</c:forEach>

			</table>
		
		</div></c:if>
	
	<c:forEach var="purOrderRow" items="${purchaseOrderDetails}">
					<c:set var="k" value="${purOrderRow}"></c:set></c:forEach>
				
					<c:if test="${k!=null}">
	<center>
		<strong> Purchase Order Form</strong>
	</center>
	
	<div
			style="overflow-x:hidden;overflow-y:scroll;size:20px; height:150px;">

			<table class="table">

				<tr>
					<th><spring:message code="label.purchaseOrderNbr" /></th>
					<th><spring:message code="label.purchaseOrderDate" /></th>
					<th><spring:message code="label.purchaseOrderValue" /></th>
					<th><spring:message code="label.purchaseOrderStatus" /></th>
					<th><spring:message code="label.description" /></th>
					<th><spring:message code="label.vendorName" /></th>
					<th><spring:message code="label.paymentTerms" /></th>
					<th><spring:message code="label.memo" /></th>
					<th><spring:message code="label.view" /></th>
				</tr>
				<c:forEach var="purOrderRow" items="${purchaseOrderDetails}">
					
					<tr>
						<td><c:out value="${purOrderRow.purchaseOrderNo}" /></td>
						<td><c:out value="${purOrderRow.purchaseOrderDate}" /></td>
						<td><c:out value="${purOrderRow.purchaseOrderValue}" /></td>
						<td><c:out value="${purOrderRow.statusName}" /></td>
						<td><c:out value="${purOrderRow.description}" /></td>
						<td><c:out value="${purOrderRow.vendorName}" /></td>
						<td><c:out value="${purOrderRow.paymentTerms}" /></td>
						<td><c:out value="${purOrderRow.memo}" /></td>
						<td><a class="uimodal"
							href="purOrderView.mnt?purOrderviewId=<c:out value="${purOrderRow.purchaseOrderId}"/>&workFlowListId=<c:out value="${purOrderRow.workFlowListId}"/>&height=350&width=700&title=WorkList"
							style="color: red"><img src="images/Edit.jpg" width="20px"
								height="20px" onclick="loadModalWindow()" /> </a></td>
				<%-- 	purReqView.mnt?purReqviewId=<c:out value="${purReqRow.purchaseReq_Id}"/>&workFlowListId=<c:out value="${purReqRow.workFlowListId}"/>" --%>
					</tr>
				</c:forEach>

			</table>
			<br /> <br />
		</div></c:if>
		
		
		
					<c:set var="k" value="${voucherDetails}"/>
			
					<c:if test="${not empty k}">
	<center>
		<strong>Voucher Form</strong>
	</center>
	
	<div
			style="overflow-x:hidden;overflow-y:scroll;size:20px; height:150px;">

			<table class="table">

				<tr>
					<th><spring:message code="label.voucherDT" /></th>
					<th><spring:message code="label.employeeId" /></th>
					<th><spring:message code="label.amount" /></th>
					<th><spring:message code="label.voucherNO" /></th>
					<th><spring:message code="label.voucherTypeName" /></th>
					<th><spring:message code="label.statusId" /></th>
				
				</tr>
				<c:forEach var="voucherRow" items="${voucherDetails}">
					
					<tr>
						<td><c:out value="${voucherRow.voucherDT}" /></td>
						<td><c:out value="${voucherRow.employeeId}" /></td>
						<td><c:out value="${voucherRow.amount}" /></td>
						<td><c:out value="${voucherRow.voucherNo}" /></td>
						<td><c:out value="${voucherRow.voucherTypeName}" /></td>
						<td><c:out value="${voucherRow.statusName}" /></td>
				
						<td><a  class="uimodal" href="voucherWorkFlowView.mnt?voucherviewId=<c:out value="${voucherRow.voucherId}"/>&workFlowListId=<c:out value="${voucherRow.workFlowListId}"/>&height=350&width=700&title=WorkList"
							style="color: red"  target="_blank"  onclick="return popitup('voucherWorkFlowView.mnt?voucherviewId=<c:out value="${voucherRow.voucherId}"/>&workFlowListId=<c:out value="${voucherRow.workFlowListId}"/>')" ><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a></td> <%----%>
				<%-- 	purReqView.mnt?purReqviewId=<c:out value="${purReqRow.purchaseReq_Id}"/>&workFlowListId=<c:out value="${purReqRow.workFlowListId}"/>" --%>
				<%-- <display:column title="View Calls History"><a href="searchCalls.mnt?mobileNumber=<c:out value="${employeeRow.mobileNumber}"/>&date=<c:out value="${employeeRow.doj}"/>" target="_blank"  onclick="return popitup('searchCalls.mnt?mobileNumber=<c:out value="${employeeRow.mobileNumber}"/>&date=<c:out value="${employeeRow.doj}"/> ')"><u><font color="blue">View Calls History</font></u></a></display:column> --%>
					
					</tr>
					
					
				</c:forEach> <!-- onclick="loadModalWindow()"  -->

			</table>
			<br /> <br />
		</div></c:if>
		
		
		<c:set var="salesOrder" value="${salesOrderDetails}"/>
					<c:if test="${not empty salesOrder}">
	<center>
		<strong>SalesOrder Form</strong>
	</center>
	<div
			style="overflow-x:hidden;overflow-y:scroll;size:20px; height:150px;">
			<table class="table">
				<tr>
					<th><spring:message code="label.soordertype" /></th>
					<th><spring:message code="label.sopterms" /></th>
					<th><spring:message code="label.sosalesgroup" /></th>
					<th><spring:message code="label.souom" /></th>
					<th><spring:message code="label.sono" /></th>
					<th><spring:message code="label.sostat" /></th>
				</tr>
				<c:forEach var="salesOrder" items="${salesOrderDetails}">
					<tr>
						<td><c:out value="${salesOrder.orderTypeId}" /></td>
						<td><c:out value="${salesOrder.paymentTermId}" /></td>
						<td><c:out value="${salesOrder.salesGroupId}" /></td>
						<td><c:out value="${salesOrder.uom}" /></td>
						<td><c:out value="${salesOrder.salesOrderNo}" /></td>
						<td><c:out value="${salesOrder.statusId}" /></td>
						<td><a  class="uimodal" href="salesOrederWorkFlowView.mnt?salesOrderviewId=<c:out value="${salesOrder.salesOrderId}"/>&workFlowListId=<c:out value="${salesOrder.workFlowListId}"/>&height=350&width=700&title=WorkList"
							style="color: red"  target="_blank"  onclick="return popitup('salesOrederWorkFlowView.mnt?salesOrderviewId=<c:out value="${salesOrder.salesOrderId}"/>&workFlowListId=<c:out value="${salesOrder.workFlowListId}"/>')" ><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a></td> <%----%>
				<%-- 	purReqView.mnt?purReqviewId=<c:out value="${purReqRow.purchaseReq_Id}"/>&workFlowListId=<c:out value="${purReqRow.workFlowListId}"/>" --%>
				<%-- <display:column title="View Calls History"><a href="searchCalls.mnt?mobileNumber=<c:out value="${employeeRow.mobileNumber}"/>&date=<c:out value="${employeeRow.doj}"/>" target="_blank"  onclick="return popitup('searchCalls.mnt?mobileNumber=<c:out value="${employeeRow.mobileNumber}"/>&date=<c:out value="${employeeRow.doj}"/> ')"><u><font color="blue">View Calls History</font></u></a></display:column> --%>
					</tr>
				</c:forEach> <!-- onclick="loadModalWindow()"  -->
			</table>
			<br /> <br />
		</div></c:if>
		
		
		<c:set var="employeeLeave" value="${employeeLeaveDetails}"/>
					<c:if test="${not empty employeeLeave}">
	<center>
		<strong>Employee Leave Form</strong>
	</center>
	<div
			style="overflow-x:hidden;overflow-y:scroll;size:20px; height:150px;">
			<table class="table">
				<tr>
					<th><spring:message code="label.employee" /></th>
					<th><spring:message code="label.leaveType" /></th>
					<th><spring:message code="label.reptMgrId" /></th>
					<th><spring:message code="label.NoOfAvailableCL" /></th>
					<th><spring:message code="label.NoOfAvailableCFL" /></th>
					<th><spring:message code="label.status" /></th>
					<th><spring:message code="label.startDate" /></th>
					<th><spring:message code="label.sDayPart" /></th>
					<th><spring:message code="label.endDate" /></th>
					<th><spring:message code="label.reason" /></th>
				</tr>
				<c:forEach var="employeeLeaves" items="${employeeLeaveDetails}">
					<tr>
						<td><c:out value="${employeeLeaves.employeeId}" /></td>
						<td><c:out value="${employeeLeaves.leaveTypeId}" /></td>
						<td><c:out value="${employeeLeaves.reptMgrId}" /></td>
						<td><c:out value="${employeeLeaves.noOfAvailableCL}" /></td>
						<td><c:out value="${employeeLeaves.noOfAvailableCFL}" /></td>
						<td><c:out value="${employeeLeaves.statusId}" /></td>
								<td><c:out value="${employeeLeaves.startDate}" /></td>
								<td><c:out value="${employeeLeaves.sDayPart}" /></td>
								<td><c:out value="${employeeLeaves.endDate}" /></td>
					<td><c:out value="${employeeLeaves.reason}" /></td>
							
						<td><a  class="uimodal" href="empLeaveWorkFlowView.mnt?employeeLeaveId=<c:out value="${employeeLeaves.employeeLeaveId}"/>&workFlowListId=<c:out value="${employeeLeaves.workFlowListId}"/>&height=350&width=700&title=WorkList"
							style="color: red"  target="_blank"  onclick="return popitup('empLeaveWorkFlowView.mnt?employeeLeaveId=<c:out value="${employeeLeaves.employeeLeaveId}"/>&workFlowListId=<c:out value="${employeeLeaves.workFlowListId}"/>')" ><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a></td> <%----%>
				<%-- 	purReqView.mnt?purReqviewId=<c:out value="${purReqRow.purchaseReq_Id}"/>&workFlowListId=<c:out value="${purReqRow.workFlowListId}"/>" --%>
				<%-- <display:column title="View Calls History"><a href="searchCalls.mnt?mobileNumber=<c:out value="${employeeRow.mobileNumber}"/>&date=<c:out value="${employeeRow.doj}"/>" target="_blank"  onclick="return popitup('searchCalls.mnt?mobileNumber=<c:out value="${employeeRow.mobileNumber}"/>&date=<c:out value="${employeeRow.doj}"/> ')"><u><font color="blue">View Calls History</font></u></a></display:column> --%>
					</tr>
				</c:forEach> <!-- onclick="loadModalWindow()"  -->
			</table>
			<br /> <br />
		</div></c:if>
		
		
		<c:set var="claim" value="${claimDetails}"/>
					<c:if test="${not empty claim}">
	<center>
		<strong>Claim</strong>
	</center>
	<div
			style="overflow-x:hidden;overflow-y:scroll;size:20px; height:150px;">
			<table class="table">
				<tr>
					<th><spring:message code="label.claimNo" /></th>
					<th><spring:message code="label.claimTypeName" /></th>
					<th><spring:message code="label.employeeId" /></th>
					<th><spring:message code="label.amount" /></th>
					<th><spring:message code="label.status" /></th>
				</tr>
				<c:forEach var="claims" items="${claimDetails}">
					<tr>
						<td><c:out value="${claims.claimNo}" /></td>
						<td><c:out value="${claims.claimTypeName}" /></td>
						<td><c:out value="${claims.empName}" /></td>
						<td><c:out value="${claims.amount}" /></td>
						<td><c:out value="${claims.statusName}" /></td>
						
						<td><a  class="uimodal" href="claimWorkFlowView.mnt?claimId=<c:out value="${claims.claimId}"/>&workFlowListId=<c:out value="${claims.workFlowListId}"/>&height=350&width=700&title=WorkList"
							style="color: red"  target="_blank" ><img src="images/Edit.jpg" width="20px"
								height="20px" /> </a></td> <%----%>
					</tr>
				</c:forEach> <!-- onclick="loadModalWindow()"  -->
			</table>
			<br /> <br />
		</div></c:if>
	
 
</body>
</html>
