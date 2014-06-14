/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Plant;

/**
 * @author pvenkateswarlu
 * @version 1.0 20-09-2013
 */
public interface PlantService {
	
	
	public List<Object[]> getPlantAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> getPlant(String plant);
	
	public String savePlantDetails(Object object,String userId,String UserName);

	public List<Object[]> getPlantIds();

	public List<Plant> searchPlantDetails();

	public List<Plant> searchPlantDetails(int id);

	public String updatePlantDetails(Object object);

	public String deletePlantDetails(Object object);

	public Long getPlantNameCount(String name);

	public Long updateDuplicate(String plantName, int plantId);
	
	public List<Object[]> selectPlantDetails();
	public List<Plant> basicSearchPlant(String label, String operator,
			String searchName);

}
