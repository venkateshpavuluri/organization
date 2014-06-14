/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.UserGroupDao;

/**
 * @author anikesh
 *
 */
public class UserGroupServiceImpl implements UserGroupService{
UserGroupDao ugdao;
List<Object[]> objects;
String msg;

public UserGroupDao getUgdao() {
	return ugdao;
}

public void setUgdao(UserGroupDao ugdao) {
	this.ugdao = ugdao;
}


public String saveUserGroupDetails(Object object,String userId,String userName)
{
	try
	{
		
		msg=ugdao.saveUserGroupDetails(object,userId,userName);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		
	}
	return msg;


}
@Override
public Long duplicateUserGroupCheck(String usergroup) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=ugdao.duplicateUserGroupCheck(usergroup);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public List<Object[]> searchUserGroup() {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
		objects=ugdao.searchUserGroup();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return objects;
}

@Override
public List<Object[]> searchUserGroupWithName(String usergroupname) {
	List<Object[]> list=null;
	try
	{
		System.out.println("usergroup name in usergroup service billTypeDao impl is   "+usergroupname);
		list=ugdao.searchUserGroupWithName(usergroupname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> selectUserGroupNames() {

	 try
	 {
		 objects=ugdao.selectUserGroupNames();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
public List<Object[]> basicSearchUserGroup(String label,String operator,String searchName){
	try {
		objects = ugdao.basicSearchUserGroup(label, operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
@Override
public List<Object[]> searchUserGroupWithId(String usergroupname) {
	List<Object[]> list=null;
	try
	{
		list=ugdao.searchUserGroupWithId(usergroupname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateUserGroup(Object object) {
	try
	{
 msg=ugdao.updateUserGroup(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String usergroup,int usergroupid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=ugdao.updateDuplicateCheck(usergroup, usergroupid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String usergroupDelete(int id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=ugdao.usergroupDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
}
