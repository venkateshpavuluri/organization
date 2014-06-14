/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Users;
import com.mnt.erp.dao.UsersDao;

/**
 * @author anikesh
 *
 */
public class UsersServiceImpl implements UsersService{

	UsersDao dao;
	List<Object[]> objects;
	String msg;

	public UsersDao getDao() {
		return dao;
	}

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	public String saveUsersDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=dao.saveUsersDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateUsersCheck(String users) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicateUsersCheck(users);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> selectRoleIds() {

		 try
		 {
			 objects=dao.selectRoleIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> selectUserGroupIds() {

		 try
		 {
			 objects=dao.selectUserGroupIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> selectFunctionIds() {

		 try
		 {
			 objects=dao.selectFunctionIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> selectOrganizationIds() {

		 try
		 {
			 objects=dao.selectOrganizationIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
		@Override
	public List<Users> searchUsers() {
		
		// TODO Auto-generated method stub
		List<Users> list=null;
		try
		{
			list=dao.searchUsers();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Users> searchUsersWithName(String usersname) {
		List<Users> list=null;
		try
		{
			list=dao.searchUsersWithName(usersname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectUsersNames() {

		 try
		 {
			 objects=dao.selectUsersNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Users> searchUsersWithId(String usersname) {
		List<Users> list=null;
		try
		{
			list=dao.searchUsersWithId(usersname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateUsers(Object object) {
		try
		{
	 msg=dao.updateUsers(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
@Override
	public String saveUserRoles(Object object) {
		try
		{
	 msg=dao.saveUserRoles(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String users,String usersid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(users, usersid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String usersDelete(String id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.usersDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String userRolesDelete(String id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.userRolesDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String saveUserOrganization(Object object) {
		try
		{
	 msg=dao.saveUserOrganization(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String userOrganizationDelete(String id) {
		String msg=null;
		try
		{
			msg=dao.userOrganizationDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public List<Object[]> selectThemeService() {
	try{
			
			objects=dao.getThemeIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
}
