/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.MaterialDisplay;

/**
 * @author pvenkateswarlu
 * @version 1.0 15-09-2013
 */
public interface MaterialDao {
	public String saveMaterialDetails(Object object,String userId,String userName);

	public List<MaterialDisplay> searchMaterial();

	public List<Object> searchMaterialWithId(int id);

	public String updateMaterial(Object object);

	public String materialDelete(int id);

	public List<Object[]> selectMaterialIds();

	public Long duplicateCheck(String materialCode);

	public Long updateDuplicateCheck(String materialName,int materialId);
	public List<Object[]> getMaterialNameIds();
	public List<Object[]> materialIdGet();
	
	public List<Object[]> basicSearchMaterial(String label,String operator,String searchName);
	
	public List<Object[]> getMaterialNameIds(String name);
	public List<Object[]> getMaterialNameEdit(int id);
	
	public String deleteChildDetails(int cid);

	public int materialStockGet(int materialId);

	public String materialStockUpdate(int materialId, float stock);
}
