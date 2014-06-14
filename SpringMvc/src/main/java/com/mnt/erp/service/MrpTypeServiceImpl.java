/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.MrpTypeDao;

/**
 * @author sailajach
 * @version 1.0 25-01-2014
 * @build 0.0
 */
public class MrpTypeServiceImpl implements MrpTypeService{
	public MrpTypeDao mrtdao;
	String message;
	List<Object[]> objects=null;
	/*==============================Add Method=========================================*/
	@Override
	public String addMrpType(Object object) {
		// TODO Auto-generated method stub
		message=mrtdao.addMrpType(object);
		
		 return message;
	}
	/*==========================Getter and Setter Of Dao==============================*/
	
	public MrpTypeDao getMrtdao() {
		return mrtdao;
	}

	public void setMrtdao(MrpTypeDao mrtdao) {
		this.mrtdao = mrtdao;
	}
  /*==============================Search(All) Method=========================================*/
	@Override
	public List<Object[]> searchMrpType() {
		// TODO Auto-generated method stub

		List<Object[]> list=null;
		try
		{
			list=mrtdao.searchMrpType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==============================Search (With Id)Method=========================================*/
	@Override
	public List<Object[]> searchMrpTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=mrtdao.searchMrpTypeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==============================Update Method=========================================*/
	@Override
	public String updateMrpType(Object object) {
		// TODO Auto-generated method stub
		try
		{
	        message=mrtdao.updateMrpType(object);	
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==============================Delete Method=========================================*/
	@Override
	public String deleteMrpType(int id) {
		// TODO Auto-generated method stub
		try
		{
			message=mrtdao.deleteMrpType(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==============================Add Duplicate Checking Method=========================================*/
	@Override
	public int checkDuplicate(String checkMrpType) {
		// TODO Auto-generated method stub
		int addList=0;
		try
		{
			addList=mrtdao.checkDuplicate(checkMrpType);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return addList;
	}
	/*==============================Edit Duplicate Checking Method=========================================*/
	@Override
	public int checkEditDuplicate(String checkMrpType, int id) {
		// TODO Auto-generated method stub
		int EditList=0;
		try
		{
			EditList=mrtdao.checkEditDuplicate(checkMrpType, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return EditList;
	}
	/*==============================Search (With Id)Method=========================================*/
	@Override
	public List<Object[]> basicSearchMrpType(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		try {
			objects =mrtdao.basicSearchMrpType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

}
