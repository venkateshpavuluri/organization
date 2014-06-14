<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page
	import="java.util.Map,
                 javax.servlet.jsp.jstl.sql.Result,
                 net.sf.navigator.menu.MenuComponent,
                 net.sf.navigator.menu.MenuRepository"%>

<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu"%>
<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu-el"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MNTERP</title>

<link href="style.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
<script src="js/accordionmenu.js" type="text/javascript"></script>
<script src="js/jquery-1.9.1.js" type="text/javascript"></script>
<link href="accordionmenu.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table width="50%" border="0" cellspacing="0" cellpadding="0"
		id="wrapper">
		<tr>
			<td id="leftMenu" class="contextMenu" valign="top">
				<div class="PageTitle">Main Menu</div> <!--Navigation-->
				<div id="acdnmenu">
					<sql:setDataSource var="db"
						url="jdbc:sqlserver://Kishore-pc:1433;databaseName=MNTERP_DEV"
						driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
						user="sa" password="ff" />
<!-- select * from dbo.MenuItems mi join dbo.UserRolePrivileges UP ON MI.Menu_Id = UP.Menu_Id -->
					<sql:query dataSource="${db}" var="menus">
						with MenuList as
						(			
  							select	M.Menu_Id, M.Parent_Name, M.Name, M.Title, M.Description, 
								M.Location, M.Target, M.OnClick, M.OnMouseOver, M.OnMouseOut, M.Image,
								M.AltImage, M.Tooltip, M.Page, M.Width, M.Height, M.Forward, M.Action
  							from MenuItems as M  inner join UserRolePrivileges URP ON M.Menu_Id=URP.Menu_Id

 							union all
 							select	M.Menu_Id, M.Parent_Name, M.Name, M.Title, M.Description, 
								M.Location, M.Target, M.OnClick, M.OnMouseOver, M.OnMouseOut, M.Image,
								M.AltImage, M.Tooltip, M.Page, M.Width, M.Height, M.Forward, M.Action
  							from MenuItems as M
    							inner join MenuList  on M.Menu_Id = MenuList.Parent_Name
      
						)
						select * from MenuList
					</sql:query>
					<%
						// I had issues using the existing repository - creating a new one
						// seems to solve the problem.  If you figure out how to use the default
						// Repository and keep your menus from duplicating themselves - please
						// let me know!

						MenuRepository repository = new MenuRepository();
						// Get the repository from the application scope - and copy the
						// DisplayerMappings from it.
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
								if (parentMenu == null) {

									// create a temporary parentMenu
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
						//System.out.println("Menu is Created");
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