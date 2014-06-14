/**
 * 
 */
package com.mnt.erp.service;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.bean.MenuItems;
import com.mnt.erp.bean.Privilege;
import com.mnt.erp.bean.Role;
import com.mnt.erp.bean.UserRolePrivilege;
import com.mnt.erp.bean.Users;
import com.mnt.erp.dao.UserRolePrivilegeDao;

/**
 * @author venkateshp
 *
 */
public class UserRolePrivilegeServiceImpl implements UserRolePrivilegeService {

	@Autowired
	UserRolePrivilegeDao userRolePrivilegeDao;
	List<Object[]> list=null;
	
	@Override
	public List<Users> getUsers(String roleId) {
		// TODO Auto-generated method stub
		List<Users> list=null;
		try
		{
			list=userRolePrivilegeDao.getUsers(roleId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getMenus() {
		// TODO Auto-generated method stub
	
		try
		{
			list=userRolePrivilegeDao.getMenus();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getPrivileges() {
		// TODO Auto-generated method stub
		try
		{
			list=userRolePrivilegeDao.getPrivileges();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Privilege> getprivilegeNames(int menuId) {
		// TODO Auto-generated method stub
		List<Privilege> list=null;
		try
		{
			list=userRolePrivilegeDao.getprivilegeNames(menuId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getMenusAndPrivilegs() {
		// TODO Auto-generated method stub
		try
		{
			list=userRolePrivilegeDao.getMenusAndPrivilegs();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int saveUserRolePriviligeDetails(
			List<UserRolePrivilege> userRolePrivileges) {
		// TODO Auto-generated method stub
		int msg=0;
		try
		{
			msg=userRolePrivilegeDao.saveUserRolePriviligeDetails(userRolePrivileges);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<UserRolePrivilege> searchUserRolePriviligeDetails() {
		// TODO Auto-generated method stub
	UserRolePrivilege userRolePrivilege=null;
	List<UserRolePrivilege> liRolePrivileges=null;
		try
		{
			//hql="select p.userRolePrivilegeId,p.usersDetails,p.roleDetails,p.menuDetails,p.privilegeDetails from UserRolePrivilege p";
			list=userRolePrivilegeDao.searchUserRolePriviligeDetails();
			liRolePrivileges=new ArrayList<UserRolePrivilege>();
			Iterator<Object[]> iterator=list.iterator();
	
			while(iterator.hasNext())
			{
				userRolePrivilege=new UserRolePrivilege();
				Object[] objects=(Object[])iterator.next();
				//userRolePrivilege.setUserRolePrivilegeId((Integer)objects[0]);
				Users users=(Users)objects[0];
				Role role=(Role)objects[1];
		
				userRolePrivilege.setUserName(users.getUserName());
				userRolePrivilege.setRoleName(role.getRole());
				userRolePrivilege.setUserIdEdit(users.getUser_Id());
				userRolePrivilege.setRoleIdEdit(role.getRoleid());
				liRolePrivileges.add(userRolePrivilege);
				
				
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return liRolePrivileges;
	}

	@Override
	public List<UserRolePrivilege> basicSearchUserRolePriviligeDetails(
			String label, String operator, String searchName) {
		// TODO Auto-generated method stub
		UserRolePrivilege userRolePrivilege=null;
		List<UserRolePrivilege> liRolePrivileges=null;
			try
			{
			
				
		//hql="select p.userRolePrivilegeId,p.usersDetails,p.roleDetails,p.menuDetails,p.privilegeDetails from UserRolePrivilege p";
				list=userRolePrivilegeDao.basicSearchUserRolePriviligeDetails(label, operator, searchName);
				liRolePrivileges=new ArrayList<UserRolePrivilege>();
				Iterator<Object[]> iterator=list.iterator();
				if(iterator!=null)
				{
				while(iterator.hasNext())
				{
					userRolePrivilege=new UserRolePrivilege();
					Object[] objects=(Object[])iterator.next();
					userRolePrivilege.setUserRolePrivilegeId((Integer)objects[0]);
					Users users=(Users)objects[1];
					Role role=(Role)objects[2];
					
					userRolePrivilege.setUserName(users.getUserName());
					userRolePrivilege.setUserIdEdit(users.getUser_Id());
					userRolePrivilege.setRoleName(role.getRole());
					userRolePrivilege.setRoleIdEdit(role.getRoleid());
					
					liRolePrivileges.add(userRolePrivilege);
				}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return liRolePrivileges;
	}
	@Override
	public String getIds(String name) {
		// TODO Auto-generated method stub
		String id=null;
		try
		{
			id=userRolePrivilegeDao.getIds(name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> editUserRolePris(int id) {
		// TODO Auto-generated method stub
		try
		{
			list=userRolePrivilegeDao.editUserRolePris(id);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteUserRolePris(String roleId,String userId) {
		// TODO Auto-generated method stub
		int suid=0;
		try
		{
			suid=userRolePrivilegeDao.deleteUserRolePris(roleId, userId);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return suid;
	}

	@Override
	public List<Privilege> getPrivilegeDetailsForEdit(String userId,String roleId,int menuId) {
		// TODO Auto-generated method stub
		List<Privilege> list=null;
		try
		{
			list=userRolePrivilegeDao.getPrivilegeDetailsForEdit(userId,roleId,menuId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String deleteUserrolePriswithuidpid(String userId, String roleId) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=userRolePrivilegeDao.deleteUserrolePriswithuidpid(userId, roleId);
		}
		catch(Exception e)
		{e.printStackTrace();
		}
		
		return msg;
	

}

	@Override
	public Long userPrivDuplicateCheck(String userId, String roleId) {
		// TODO Auto-generated method stub
		Long duplicatId=0l;
		try
		{
			duplicatId=userRolePrivilegeDao.userPrivDuplicateCheck(userId, roleId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return duplicatId;
	}
}
