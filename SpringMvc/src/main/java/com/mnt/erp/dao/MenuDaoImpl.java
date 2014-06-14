/**
 * 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author venkateshp
 *
 */
public class MenuDaoImpl extends HibernateDaoSupport implements MenuDao {
	String sql;
	@Override
	public int getMenuId(String location) {
		// TODO Auto-generated method stub
		Integer id=0;
		List<Object> list=null;
		Iterator<Object> iterator=null;
		Object object=null;
		try
		{
			sql="select m.menuId from MenuItems m where m.location='"+location+"'";
			list=getHibernateTemplate().find(sql);
			
			iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				object=(Object)iterator.next();
			 id=(Integer)object;
			
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public List<Object> getmenuPrivilige(String userId, int menuId) {
		// TODO Auto-generated method stub
		List<Object> list=null;
		try
		{
			list= getHibernateTemplate().findByNamedQueryAndNamedParam("GetMenuPrivilege",new String[] {"UserId","MenuId"},new Object[]{userId,menuId});
		
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String getPrivilegeName(String privilegeId) {
		// TODO Auto-generated method stub
		List<String> list=null;
		Iterator<String> iterator=null;
		String privilegeName=null;
		try
		{
			sql="select p.privilege from  Privilege p where p.privilegeid='"+privilegeId+"'";
			list=getHibernateTemplate().find(sql);
			
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				privilegeName=(String)iterator.next();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return privilegeName;
	}

}
