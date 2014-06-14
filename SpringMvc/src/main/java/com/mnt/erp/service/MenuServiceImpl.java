/**
 * 
 */
package com.mnt.erp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.mnt.erp.dao.MenuDao;

/**
 * @author venkateshp
 *
 */
public class MenuServiceImpl implements MenuService {
static Logger logger=Logger.getLogger(MenuServiceImpl.class);
	
	MenuDao dao;
	
	public MenuDao getDao() {
		return dao;
	}

	public void setDao(MenuDao dao) {
		this.dao = dao;
	}
	@Override
	public List<String> getPrivilige(String location,String userId) {
		// TODO Auto-generated method stub
		List<Object> list=null;
		List<String> getPrivilge=null;
		int menuId=0;
		Iterator<?> iterator=null;
		Object object=null;
		String privilegeName=null;
		try
		{
			menuId=dao.getMenuId(location);
			list=dao.getmenuPrivilige(userId, menuId);			
			getPrivilge=new ArrayList<String>();
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				object=(Object)iterator.next();
				privilegeName=dao.getPrivilegeName(object.toString());
				logger.info("privileges are=="+privilegeName);
				getPrivilge.add(privilegeName);
				
			}
		}
		catch(Exception e)
		{
		
			e.printStackTrace();
		}
		return getPrivilge;
	}

	
	

}
