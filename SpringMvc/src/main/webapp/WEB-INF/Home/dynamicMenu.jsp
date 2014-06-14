<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page
	import="java.util.Map,
                 javax.servlet.jsp.jstl.sql.Result,
                 net.sf.navigator.menu.MenuComponent,
                 net.sf.navigator.menu.MenuRepository"%>

<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu"%>
<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu-el"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MNTERP</title>
 <script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script type='text/javascript' src='js/jquery.cookie.js'></script>
<script type='text/javascript' src='js/jquery.hoverIntent.minified.js'></script>
 <script type='text/javascript' src='js/jquery.dcjqaccordion.2.7.js'></script> 
  <link href="css/dcaccordion.css" rel="stylesheet" type="text/css" />  
 <link href="css/blue.css" rel="stylesheet" type="text/css" />  

<script type="text/javascript">
 $(document).ready(function($){
	$('.menuList').dcAccordion({
		eventType: 'click',
		autoClose: true,
		saveState: true,
		disableLink: false,
		showCount: false,
		speed: 'slow',
		
		});
}); 
</script>

</head>
<body>
	<table width="50%" border="0" cellspacing="0" cellpadding="0"
		id="wrapper">
		<tr>
			<td id="leftMenu" class="contextMenu" valign="top">
				<div class="PageTitle">Main Menu</div> <!--Navigation-->
				<div class="tmr">
					<sql:setDataSource var="db"
						url="jdbc:sqlserver://
						192.168.1.103:1433;databaseName=MNTERP_DEV"
						driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
						user="mnterpuser" password="mnterpuser" /> 
	
<%
String userId = (String)session.getAttribute("userId");
%>
<c:set var="requestValueKey" value="${userId}" />
					<sql:query dataSource="${db}" var="menus">	
										
					select * from MenuItems;
					<%-- 	<sql:param value="${requestValueKey}" />  --%>
					</sql:query>
					
					<%
						MenuRepository repository = new MenuRepository();
						MenuRepository defaultRepository = (MenuRepository) application
								.getAttribute(MenuRepository.MENU_REPOSITORY_KEY);
						repository.setDisplayers(defaultRepository.getDisplayers());
						Result result = (Result) pageContext.getAttribute("menus");
						Map[] rows = result.getRows();
						for (int i = 0; i < rows.length; i++) {
							MenuComponent mc = new MenuComponent();
							Map row = rows[i];
							String name = (String) row.get("name");
							mc.setName(name);
							String parent = (String) row.get("parent_name");
							if (parent != null) {
								MenuComponent parentMenu = repository.getMenu(parent);
								if (parentMenu == null)
								{
									parentMenu = new MenuComponent();
									parentMenu.setName(parent);
									repository.addMenu(parentMenu);
								}
								mc.setParent(parentMenu);
							}
							String title = (String) row.get("title");
							mc.setTitle(title);
							String location = (String) row.get("location");
							mc.setLocation(location);
							
							repository.addMenu(mc);
						}
						pageContext.setAttribute("repository", repository);
					%>
					<menu:useMenuDisplayer name="ListMenu" repository="repository">
						<c:forEach var="menu" items="${repository.topMenus}">
							<menu-el:displayMenu name="${menu.name}" />
						</c:forEach>
					</menu:useMenuDisplayer>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>