/**
 * 
 */
package com.mnt.erp.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author venkateshp
 *
 */
public class DbConnection {
static{
	try
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
}
	
	public static Connection getConnection()
	{
		Connection connection=null;
		try
		{
			 connection=DriverManager.getConnection("jdbc:sqlserver://192.168.1.103:1433;databaseName=MobileTracking","mnterpuser", "mnterpuser");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
}
	
	

