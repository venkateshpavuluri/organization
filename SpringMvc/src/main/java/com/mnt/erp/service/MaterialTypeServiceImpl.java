/**
 
 *
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.MaterialTypeDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class MaterialTypeServiceImpl implements MaterialTypeService
{
	List<Object[]> objects;
	public MaterialTypeDao mtdao;
	/*=========================Getter and Setters Of Dao==============================*/
	public MaterialTypeDao getDao()
	{
	return mtdao;
    }
    public void setDao(MaterialTypeDao dao)
	{
		this.mtdao = dao;
    }
    /*==========================Material Type Select Method==============================*/
	@Override
	public List<Object[]> selectMaterialType()
	{
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=mtdao.selectMaterialType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	String message;
	/*==========================Add Method==============================*/
	@Override
	public String addMaterialTypeDetails(Object object,String userId,String userName)
	{
		// TODO Auto-generated method stub
		
		 
	 message=mtdao.addMaterialTypeDetails(object,userId,userName);
	
	 return message;
		
	}
	
	/*==========================Search(All) Method==============================*/
	@Override
	public List<Object[]> searchMaterialType() 
	{
		// TODO Auto-generated method stub
	
		List<Object[]> list=null;
		try
		{
			list=mtdao.searchMaterialType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Search(With Id) Method==============================*/
	@Override
	public List<Object[]> searchMaterialTypeWithId(int id)
	{
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=mtdao.searchMaterialTypeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Update Method==============================*/
	@Override
	public String updateMaterialType(Object object)
	{
		// TODO Auto-generated method stub
		try
		{
	         message=mtdao.updateMaterialType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Delete Method==============================*/
	@Override
	public String materialTypeDelete(int id)
	{
		// TODO Auto-generated method stub
		
		try
		{
			message=mtdao.materialTypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Add Duplicate Check Method==============================*/
	@Override
	public int checkDuplicate(String checkMTType,String checkMTTypeCode)
	{
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=mtdao.checkDuplicate(checkMTType, checkMTTypeCode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*==========================Edit Duplicate Check Method==============================*/
	@Override
	public int checkEditDuplicate(String checkMTType, String checkMTTypeCode,int id)
	{
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=mtdao.checkEditDuplicate(checkMTType,checkMTTypeCode,id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchMaterialType(String label,
			String operator, String searchName) {
		try {
			objects = mtdao.basicSearchMaterialType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	

}
