/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.VehicleType;
import com.mnt.erp.dao.VehicleTypeDao;

/**
 * @author anikesh
 *@version 1.0 28-10-2013
 *@build 0.0
 *
 */
public class VehicleTypeServiceImpl implements VehicleTypeService{

	VehicleTypeDao vehTypeDao;
	List<Object[]> objects;
	String msg;

	
	public VehicleTypeDao getVehTypeDao() {
		return vehTypeDao;
	}
	public void setVehTypeDao(VehicleTypeDao vehTypeDao) {
		this.vehTypeDao = vehTypeDao;
	}
	public String saveVehicleTypeDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=vehTypeDao.saveVehicleTypeDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateVehicleTypeCheck(String vehicletype) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=vehTypeDao.duplicateVehicleTypeCheck(vehicletype);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchVehicleType() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			objects=vehTypeDao.searchVehicleType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchVehicleTypeWithName(String vehicletypename) {
		List<Object[]> list=null;
		try
		{
			System.out.println("vehicletype name in vehicletype service vehTypeDao impl is   "+vehicletypename);
			list=vehTypeDao.searchVehicleTypeWithName(vehicletypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectVehicleTypeNames() {

		 try
		 {
			 objects=vehTypeDao.selectVehicleTypeNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchVehicleTypeWithId(String vehicletypename) {
		List<Object[]> list=null;
		try
		{
			list=vehTypeDao.searchVehicleTypeWithId(vehicletypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateVehicleType(Object object) {
		try
		{
	 msg=vehTypeDao.updateVehicleType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String vehicletype,int vehicletypeid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=vehTypeDao.updateDuplicateCheck(vehicletype, vehicletypeid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String vehicletypeDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=vehTypeDao.vehicletypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> basicSearchVehicleType(String label,String operator,String searchName){
		try {
			objects = vehTypeDao.basicSearchVehicleType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
