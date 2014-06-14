package com.mnt.erp.dao;

import java.util.List;

public interface EquipmentCategoryDao {

	public String saveEquipmentCategoryDetails(Object object);

	public List<Object[]> searchEquipmentCategory();

	public List<Object[]> searchEquipmentCategoryWithId(int id);

	public String updateEquipmentCategory(Object object);

	public String deleteEquipmentCategory(int id);

	public List<Object[]> selectEquipmentCategory();

	public long checkEquipmentCategory(String type);

	public long updateCheckEquipmentCategory(String type, int eqpId);
	public List<Object[]> basicSearchEquipment(String label, String operator,
			String searchName);
}
