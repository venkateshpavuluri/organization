/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Privilege;
import com.mnt.erp.dao.PrivilegeDao;

/**
 * @author A Nikesh
 *
 */
public class PrivilegeServiceImpl implements PrivilegeService
{
	PrivilegeDao dao;
	List<Object[]> objects;
	String msg;
	

	public PrivilegeDao getDao() {
		return dao;
	}

	public void setDao(PrivilegeDao dao) {
		this.dao = dao;
	}
	
	
	public String savePrivilegeDetails(Object object,String userId,String userName)
	{
		try
		{
		
			msg=dao.savePrivilegeDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicatePrivilegeCheck(String privilege) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicatePrivilegeCheck(privilege);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchPrivilege() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchPrivilege();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchPrivilege(String label,String operator,String searchName){
		try {
			objects = dao.basicSearchPrivilege(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> searchPrivilegeWithName(String privilegename) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchPrivilegeWithName(privilegename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectPrivilegeNames() {

		 try
		 {
			 objects=dao.selectPrivilegeNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchPrivilegeWithId(String privilegename) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchPrivilegeWithId(privilegename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updatePrivilege(Object object) {
		try
		{
	 msg=dao.updatePrivilege(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String privilege,String privilegeid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(privilege, privilegeid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String privilegeDelete(String id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.privilegeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
}
