/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.dao.WarehouseDao;

/**
 * @author A Nikesh
 *@version 1.0 12-11-2013
 *@build 0.0
 *
 */
public class WarehouseServiceImpl implements WarehouseService{

	WarehouseDao warehousedao;
	List<Object[]> objects;
	String msg;


	
	public WarehouseDao getWarehousedao() {
		return warehousedao;
	}
	public void setWarehousedao(WarehouseDao warehousedao) {
		this.warehousedao = warehousedao;
	}
	public String saveWareHouseDetails(Object object)
	{
		try
		{
			
			msg=warehousedao.saveWareHouseDetails(object);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateWareHouseCheck(String storagetype) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=warehousedao.duplicateWareHouseCheck(storagetype);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> selectCountryIds() {

		 try
		 {
			 objects=warehousedao.selectCountryIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchWareHouse() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			objects=warehousedao.searchWareHouse();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchWareHouse(String label,String operator,String searchName){
		try {
			objects = warehousedao.basicSearchWareHouse(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> selectWareHouseNames() {

		 try
		 {
			 objects=warehousedao.selectWareHouseNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}

@Override
public List<Object[]> searchWareHouseWithId(String storagetypename) {
	List<Object[]> list=null;
	try
	{
		list=warehousedao.searchWareHouseWithId(storagetypename);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateWareHouse(Object object) {
	try
	{
 msg=warehousedao.updateWareHouse(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String storagetype,int storagetypeid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=warehousedao.updateDuplicateCheck(storagetype, storagetypeid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String WareHouseDelete(int id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=warehousedao.WareHouseDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}

public List<Object[]> getWarehouseAdvance(String columns,String opeator,String advanceSearchText) {
	String column[]=columns.split(",");
	String op[]=opeator.split(",");
	String advanceSearch[]=advanceSearchText.split(",");
	String finalStringForSearch="";
	
	for(int i=0;i<advanceSearch.length;i++){
		if(!op[i].equals("0") && advanceSearch[i]!="")
		{
		if (op[i].equals("_%")) {
			column[i]=column[i];
			op[i]=" like ";
			advanceSearch[i] = advanceSearch[i] +"%";
			

		} else if (op[i].equals("%_")) {
			column[i]=column[i];
			op[i]=" like ";
			advanceSearch[i] = "%" + advanceSearch[i];

		} else if (op[i].equals("%_%")) {
			column[i]=column[i];
			op[i]=" like ";
			advanceSearch[i] =  "%"  + advanceSearch[i] + "%" ;

		} else if (op[i].equals("=")) {
			column[i]=column[i];
			op[i]=" = ";
			advanceSearch[i] =   advanceSearch[i]  ;

		} else if (op[i].equals("!=")) {
			column[i]=column[i];
			op[i]=" != ";
			advanceSearch[i] =   advanceSearch[i]  ;

		}
		if(!op[i].equals("0") && advanceSearch[i]!="")
		{
		finalStringForSearch=finalStringForSearch+"  "+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
		}
		}
	
		
		
		
	}
	//System.out.println("String Value Kiran" +finalStringForSearch);
	List<Object[]> list=null;
	if(finalStringForSearch.length()>3)
	{
	 list = warehousedao.setWarehouseAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
	}
	else
	{
		list = warehousedao.searchWareHouse();
	}
	return list;
}
}
