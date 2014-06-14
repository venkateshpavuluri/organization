/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.WarehouseBinTypeDao;

/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
public class WarehouseBinTypeServiceImpl implements WarehouseBinTypeService{

	
	WarehouseBinTypeDao whousebintype;
	List<Object[]> objects;
	String msg;

	
	
	public WarehouseBinTypeDao getWhousebintype() {
		return whousebintype;
	}
	public void setWhousebintype(WarehouseBinTypeDao whousebintype) {
		this.whousebintype = whousebintype;
	}
	public String saveWarehouseBinTypeDetails(Object object)
	{
		try
		{
			
			msg=whousebintype.saveWarehouseBinTypeDetails(object);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateWarehouseBinTypeCheck(String warehousebintype) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=whousebintype.duplicateWarehouseBinTypeCheck(warehousebintype);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchWarehouseBinType() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			objects=whousebintype.searchWarehouseBinType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchWarehouseBinTypeWithName(String warehousebintypename) {
		List<Object[]> list=null;
		try
		{
			System.out.println("warehousebintype name in warehousebintype service whousebintype impl is   "+warehousebintypename);
			list=whousebintype.searchWarehouseBinTypeWithName(warehousebintypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectWarehouseBinTypeNames() {

		 try
		 {
			 objects=whousebintype.selectWarehouseBinTypeNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchWarehouseBinTypeWithId(String warehousebintypename) {
		List<Object[]> list=null;
		try
		{
			list=whousebintype.searchWarehouseBinTypeWithId(warehousebintypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateWarehouseBinType(Object object) {
		try
		{
	 msg=whousebintype.updateWarehouseBinType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String warehousebintype,int warehousebintypeid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=whousebintype.updateDuplicateCheck(warehousebintype, warehousebintypeid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String warehousebintypeDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=whousebintype.warehousebintypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> basicSearchWarehouseBinType(String label,String operator,String searchName){
		try {
			objects = whousebintype.basicSearchWarehouseBinType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	

}
