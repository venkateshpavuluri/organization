/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.CapacityCategory;
import com.mnt.erp.dao.CapacityCategoryDao;

/**
 * @author anikesh
 *
 */
public class CapacityCategoryServiceImpl implements CapacityCategoryService{
	CapacityCategoryDao dao;
	List<Object[]> objects;
	String msg;

	public CapacityCategoryDao getDao() {
		return dao;
	}

	public void setDao(CapacityCategoryDao dao) {
		this.dao = dao;
	}
	public String saveCapacityCategoryDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=dao.saveCapacityCategoryDetails(object, userId, userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateCapacityCategoryCheck(String capcategory) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicateCapacityCategoryCheck(capcategory);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchCapacityCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchCapacityCategory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchCapacityCategory(String label,String operator,String searchName){
		try {
			objects = dao.basicSearchCapacityCategory(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchCapacityCategoryWithName(String capcategoryname) {
		List<Object[]> list=null;
		try
		{
			System.out.println("capcategory name in capcategory service dao impl is   "+capcategoryname);
			list=dao.searchCapacityCategoryWithName(capcategoryname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectCapacityCategoryNames() {

		 try
		 {
			 objects=dao.selectCapacityCategoryNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchCapacityCategoryWithId(String capcategoryname) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchCapacityCategoryWithId(capcategoryname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateCapacityCategory(Object object) {
		try
		{
	 msg=dao.updateCapacityCategory(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String capcategory,int capcategoryid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(capcategory, capcategoryid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String capcategoryDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.capcategoryDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

}
