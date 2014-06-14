/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.MaterialDisplay;

/**
 * @author pvenkateswarlu
 * @version 1.0 15-09-2013
 */
public interface MaterialService {
	public String saveMaterialDetails(Object object,String userId,String userName);

	public List<MaterialDisplay> searchMaterial();

	public List<Object> searchMaterialWithId(int id);

	public String updateMaterial(Object object);

	public String materialDelete(int id);

	public List<Object[]> selectMaterialIds();

	public Long duplicateCheck(String materialName);

	public Long updateDuplicateCheck(String materialName, int materialId);
	
	public List<Object[]> getMaterialName();
	
	public List<Object[]> materialIdGet();
	
	public List<Object[]> basicSearchMaterial(String label,String operator,String searchName);
	public List<Object[]> getMaterialName(String name);
	public List<Object[]> getMaterialNameEdit(int id);
	
	public String deleteChildDetails(int cid);


	public int materialStockGet(int materialId);

	public String materialStockUpdate(int materialId, float stock);
}
