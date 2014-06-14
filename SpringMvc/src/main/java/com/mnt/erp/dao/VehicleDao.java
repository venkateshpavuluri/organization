/**
copyright MNT Soft
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author anikesh
 *@version 1.0 29-10-2013
 *@build 0.0
 *
 */
public interface VehicleDao {
	public String saveVehicleDetails(Object object,String userId,String userName);
	public Long duplicateVehicleCheck(String registrationNum);
	public List<Object[]> selectVehicleTypeIds();
	public List<Object[]> searchVehicle();
	public List<Object[]> searchVehicleWithName(String regnum);
	public List<Object[]> setVehicleAdvanceSearch(String wfstage);
	
	public List<Object[]> selectVehicleNames();
	public List<Object[]> basicSearchVehicle(String label,String operator,String searchName);
	public List<Object[]> searchVehicleWithId(String regnum);
	public String updateVehicle(Object object);
	public Long updateDuplicateCheck(String regnum, int vehicleid);
	public String vehicleDelete(String id);
	
}
