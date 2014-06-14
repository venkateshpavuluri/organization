package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.SalesGroupDao;

public class SalesGroupServiceImpl implements  SalesGroupService{
	
	public SalesGroupDao sgdao;
	
	public SalesGroupDao getSgdao() {
		return sgdao;
	}
	public void setSgdao(SalesGroupDao sgdao) {
		this.sgdao = sgdao;
	}

	String msg;
	
	
	public String saveSalesGroup(Object object, String userId, String userName){
		
		try
		{
			msg=sgdao.saveSalesGroup(object, userId, userName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return msg;
		
	}
	public List<Object[]> searchSalesGroup(){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=sgdao.searchSalesGroup();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
		
	}
	public List<Object[]> editSalesGroupWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=sgdao.editSalesGroupWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public String updateSalesGroup(Object object){
		try
		{
	         msg=sgdao.updateSalesGroup(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public String deleteSalesGroup(int id){
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=sgdao.salesGroupDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int salesGroupDuplicate(String salesGroup){
		// TODO Auto-generated method stub
		int list=0;
		try
		{
			list=sgdao.salesGroupDuplicate(salesGroup);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public int salesGroupEditDuplicate(String salesGroup,int id){
		int list=0;
		try
		{
			list=sgdao.salesGroupEditDuplicate(salesGroup, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> basicSearchSalesGroup(String label,String operator,String searchName){
		List<Object[]> objects=null;
		try {
			objects = sgdao.basicSearchSalesGroup(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public List<Object[]> salesOfficeIdGet(){
		List<Object[]> objects=null;
		try {
			objects = sgdao.salesOfficeIdGet();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}


}
