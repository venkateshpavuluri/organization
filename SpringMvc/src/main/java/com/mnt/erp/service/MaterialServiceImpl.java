/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.MaterialDisplay;
import com.mnt.erp.dao.MaterialDao;
/**
 * @author pvenkateswarlu
 *@version 1.0 15-09-2013
 */
public class MaterialServiceImpl implements MaterialService{
	public MaterialDao dao;
String msg;
List<Object[]> objects;
	@Override
	public String saveMaterialDetails(Object object,String userId,String userName) {
		try
		{
			msg=dao.saveMaterialDetails(object,userId,userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public MaterialDao getDao() {
		return dao;
	}
	public void setDao(MaterialDao dao) {
		this.dao = dao;
	}
	@Override
	public List<MaterialDisplay> searchMaterial() {
		// TODO Auto-generated method stub
		List<MaterialDisplay> list=null;
		try
		{
			list=dao.searchMaterial();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object> searchMaterialWithId(int id) {
		List<Object> list=null;
		try
		{
			list=dao.searchMaterialWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateMaterial(Object object) {
		try
		{
	 msg=dao.updateMaterial(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String materialDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.materialDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public List<Object[]> selectMaterialIds() {
 
		 try
		 {
			 objects=dao.selectMaterialIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public Long duplicateCheck(String materialName) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicateCheck(materialName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public Long updateDuplicateCheck(String materialName,int materialId) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(materialName, materialId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	
	@Override
	public List<Object[]> getMaterialName() {
 
		 try
		 {
			 objects=dao.getMaterialNameIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	
	@Override
	public List<Object[]> materialIdGet() 
	{
		// TODO Auto-generated method stub
		List<Object[]> mId=dao.materialIdGet();
		return mId;
		
	
	}
	@Override
	public List<Object[]> basicSearchMaterial(String label, String operator,
			String searchName) {
		try {
			objects = dao.basicSearchMaterial(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	
	
	@Override
	public List<Object[]> getMaterialName(String name) {
 
		 try
		 {
			 objects=dao.getMaterialNameIds(name);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	
	public List<Object[]> getMaterialNameEdit(int name) {
		 
		 try
		 {
			 objects=dao.getMaterialNameEdit(name);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	
	
	public int materialStockGet(int materialId) {
		int f = 0;
		f = dao.materialStockGet(materialId);
		return f;
	}

	public String materialStockUpdate(int materialId, float stock) {
		String s = null;
		s = dao.materialStockUpdate(materialId, stock);
		return s;
	}
	@Override
	public String deleteChildDetails(int cid) {
		try{
			msg=dao.deleteChildDetails(cid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;
	}
	
	


}
