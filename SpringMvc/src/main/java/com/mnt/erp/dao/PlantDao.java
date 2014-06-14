/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author pvenkateswarlu
 * @version 1.0 20-09-2013
 */
public interface PlantDao {
	
    public List<Object[]> plantAdvanceSearch(String name);
	
	public List<Object[]> setPlantSearch(String name);
	
	public String savePlantDetails(Object object,String userId,String UserName);

	public List<Object[]> getPlantIds();

	public List<Object[]> searchPlantDetails();

	public List<Object[]> searchPlantDetails(int id);

	public String updatePlantDetails(Object object);

	public String deletePlantDetails(Object object);

	public Long getPlantNameCount(String name);

	public Long updateDuplicate(String plantName, int plantId);
	
	public List<Object[]> selectPlantDetails();
	
	public List<Object[]> basicSearchPlant(String label, String operator,
			String searchName);

}
