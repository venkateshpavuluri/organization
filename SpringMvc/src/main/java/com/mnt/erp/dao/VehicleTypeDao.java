/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.VehicleType;

/**
 * @author anikesh
 *@version 1.0 28-10-2013
 *@build 0.0
 *
 */
public interface VehicleTypeDao {
	public String saveVehicleTypeDetails(Object object,String userId,String userName);
	public Long duplicateVehicleTypeCheck(String vehicletype);
	public List<Object[]> searchVehicleType();
	public List<Object[]> searchVehicleTypeWithName(String vehicletypename);
	public List<Object[]> selectVehicleTypeNames();
	public List<Object[]> searchVehicleTypeWithId(String vehicletypename);
	public String updateVehicleType(Object object);
	public Long updateDuplicateCheck(String vehicletype, int vehicletypeid);
	public String vehicletypeDelete(int id);
	public List<Object[]> basicSearchVehicleType(String label,String operator,String searchName);
}
