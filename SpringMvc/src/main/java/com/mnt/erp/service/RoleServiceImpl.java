package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.MaterialDisplay;
import com.mnt.erp.bean.Role;
import com.mnt.erp.dao.RoleDao;

/**
 * 
 */

/**
 * @author Nikesh
 *
 */
public class RoleServiceImpl implements RoleService{

	RoleDao dao;
	List<Object[]> objects;
	String msg;
	
	
public RoleDao getDao() {
		return dao;
	}



	public void setDao(RoleDao dao) {
		this.dao = dao;
	}



public String saveRoleDetails(Object object,String userId,String userName)
{
	try
	{
		
		msg=dao.saveRoleDetails(object,userId,userName);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		
	}
	return msg;


}
@Override
public Long duplicateRoleCheck(String role) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.duplicateRoleCheck(role);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public List<Object[]> searchRole() {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
		list=dao.searchRole();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
public List<Object[]> basicSearchRole(String label,String operator,String searchName){
	try {
		objects = dao.basicSearchRole(label, operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
@Override
public List<Object[]> searchRoleWithName(String rolename) {
	List<Object[]> list=null;
	try
	{
		System.out.println("role name in role service dao impl is   "+rolename);
		list=dao.searchRoleWithName(rolename);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> selectRoleNames() {

	 try
	 {
		 objects=dao.selectRoleNames();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> searchRoleWithId(String rolename) {
	List<Object[]> list=null;
	try
	{
		list=dao.searchRoleWithId(rolename);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateRole(Object object) {
	try
	{
 msg=dao.updateRole(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String role,String roleid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.updateDuplicateCheck(role, roleid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String roleDelete(String id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=dao.roleDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
}
