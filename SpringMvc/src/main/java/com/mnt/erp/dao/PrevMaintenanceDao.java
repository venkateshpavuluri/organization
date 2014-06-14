
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.PrevMaintenance;

/**
 * @author tparvathi
 *
 */
public interface PrevMaintenanceDao {
	public Long updateCheckPrevMaintenance(String equipment,int id);

	public Long checkPrevMaintenance(String equipment);
	
	public String savePrevMaintenanceDetails(Object object);

	public List<Object[]> searchPrevMaintenance();

	public List<PrevMaintenance> searchPrevMaintenanceWithId(int id);

	public String updatePrevMaintenance(Object object);

	public String deletePrevMaintenance(int id);
	
	public List<Object[]> selectEquipment();
	
	public List<Object[]> selectMaintenanceCategory();
	
	public List<Object[]> selectMaintenanceType();
	
	public String deletePrevMaintenanceDetail(int kk);
	
	public List<Object[]> basicSearchPrevMaintenance(String label,String operator,String searchName);

}
