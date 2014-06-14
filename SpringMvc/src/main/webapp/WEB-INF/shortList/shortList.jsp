<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/demos/style.css" />

<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="js/jqueryui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>

<script type="text/javascript" src="js/pagination.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">

function popitup(url) {
	//var filepath =document.getElementById("docPathEdit").value;
	
	//$("#resumelink").attr('href', filepath);
	newwindow=window.open(url,'name','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=1,height=800,width=900');
	
	if (window.focus) {
		newwindow.focus();
		}
	return false;
}

	function AjaxForPlant(id) {
		var vacancyDetailLineId = $('#' + id).val();
	
		 $("#userdata thead th").remove();
		$("#userdata tbody tr").remove();
		$.ajax({
			type : "POST",
			url : "shortListSearch.mnt",
			data : "vacancyDetailLineId=" + vacancyDetailLineId,
			dataType: "json",
			success : function(data) {
			
				if(data==""){
					//alert("dfm");
					 $("#userdata thead th").remove();
						$("#userdata tbody tr").remove();
						$('#result').hide();
				
				} else{
					$('#noSortData').hide();
					 	var tHead="<tr><th>First Name</th><th>Email</th><th>Resume</th> <th>Phone Number</th><th>Short List</th></tr>";
		         		$(tHead).appendTo("#userdata thead"); 
		         		$('#result').show();
						$.each(data, function(i, user) {
			         		var tblRow = "<tr>" + "<td>" + user.fname + "</td>" + "<td>" + user.email + "</td>"+ '<td><a href="" id="'+user.docPath+'" onClick="return popitup(this.id)"><font color="black"> Click Here To Show Resume<font> </a> </td>'  + "<td>" + user.phoneNo + "</td>"  
			         		+'<td><input type="checkbox" name="sortList" value="'+user.applicant_Id+'"</td></tr>';
			         		$(tblRow).appendTo("#userdata tbody"); 
						});
						$('#userdata').tablePagination({});
						$('#sortlist').show();
				   }
				},
			error : function(e) {
				
			}

		});

	}

 </script> 
 <script type="text/javascript">
 $(document).ready(function() {
	 $(function () {
	      $('#sortlist').click( function(){
	  
	        var chkId = '';
	        $('input[name="sortList"]:checked').each(function() {
	          chkId += $(this).val() + ",";
	        });
	        chkId =  chkId.slice(0,-1);
	       
	      });

	      $('.chkSelectAll').click( function(){
	        $('input[name="sortList"]').prop('checked', $(this).is(':checked'));
	      });

	    });
 });
 </script>
 <script>
	$(function() {
		$("#tabs,#tabss").tabs();
	});
</script>
</head>

<body>

<div class="divUserDefault">
		<div class="PageTitle">Short List</div></div>
	<div id="tabs" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<li class="TabbedPanelsTab"><a href="#tabs-2" id="Report"></a></li>

		</ul>
		<div id="tabs-2" class="TabbedPanelsContent">
			<div align="left">

				<table class="tableGeneral">

				</table>
				<form:form action="shortListSave.mnt" method="POST"
					commandName="shortList" id="organizationAdd">
					<table>
						<tr>
							<td><s:message code="label.vacancyDetailNo"></s:message><font
								color="red">*</font></td>
							<td><form:select path="vacancyDetail_Id"
									id="vacancyDetail_Id" class="select"
									onchange="AjaxForPlant(this.id)">
									<form:option value="">--Select--</form:option>

									<form:options items="${vacancyDetailNo}" />
								</form:select></td>
						</tr>
					</table>



					<table id="userdata" border="1" class="table">
						<thead>
						</thead>
						<tbody>
						</tbody>

					</table>

					<div align="center">
						<h4 id="noSortData">No Data Found</h4>
					</div>
					<div align="right" id="result" style="display: none">
						<input type="checkbox" class="chkSelectAll" />SelectAll <input
							type="submit" class="btn btn-primary" id="sortlist"
							value="ShortList">

					</div>
				</form:form>
				<!-- ============================================End OrganizationAdd=================================================================================================== -->

			</div>
		</div>
	</div>


</body>
</html>