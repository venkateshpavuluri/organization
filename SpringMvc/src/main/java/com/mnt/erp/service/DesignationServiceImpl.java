/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Designation;
import com.mnt.erp.dao.DesignationDao;

/**
 * @author anikesh
 *
 */
public class DesignationServiceImpl implements DesignationService{
DesignationDao dao;
List<Object[]> objects;
String msg;

public DesignationDao getDao() {
	return dao;
}

public void setDao(DesignationDao dao) {
	this.dao = dao;
}
public String saveDesignationDetails(Object object,String userId,String userName)
{
	try
	{
		
		msg=dao.saveDesignationDetails(object,userId,userName);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		
	}
	return msg;


}
@Override
public Long duplicateDesignationCheck(String designation) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.duplicateDesignationCheck(designation);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public List<Object[]> searchDesignation() {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
		list=dao.searchDesignation();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
public List<Object[]> basicSearchDesignation(String label,String operator,String searchName){
	try {
		objects = dao.basicSearchDesignation(label, operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
@Override
public List<Object[]> searchDesignationWithName(String designationname) {
	List<Object[]> list=null;
	try
	{
		System.out.println("designation name in designation service dao impl is   "+designationname);
		list=dao.searchDesignationWithName(designationname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> selectDesignationNames() {

	 try
	 {
		 objects=dao.selectDesignationNames();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> searchDesignationWithId(String designationname) {
	List<Object[]> list=null;
	try
	{
		list=dao.searchDesignationWithId(designationname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateDesignation(Object object) {
	try
	{
 msg=dao.updateDesignation(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String designation,int designationid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.updateDuplicateCheck(designation, designationid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String designationDelete(int id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=dao.designationDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
}
