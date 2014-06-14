/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.PrevMaintenance;

/**
 * @author tparvathi
 *
 */
public interface PrevMaintenanceService {
	public Long updateCheckPrevMaintenance(String fiscalYear,int fiscalYearId);

	public Long checkPrevMaintenance(String fiscalYear);
	
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
