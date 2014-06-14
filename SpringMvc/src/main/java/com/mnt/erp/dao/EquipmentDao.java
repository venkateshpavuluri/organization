/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author madhav
 *
 */
public interface EquipmentDao {

public List<Object[]> selectEquipment(); 
	
	public int updateCheckEquipment(String equipmentName, int equipmentId);

	public Long addCheckEquipment(String equipmentName);

	public String saveEquipment(Object object);

	public List<Object[]> searchEquipment();

	public List<Object[]> searchEquipmentWithId(int id);

	public String updateEquipment(Object object);

	public String deleteEquipment(int id);

	public List<Object[]> selectEquipmentCategory();

	public List<Object[]> basicSearchEquipment(String label, String operator,
			String searchName);
	public String saveEquipmentDocuments(Object object);
}
