package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.MaterialPriceDao;

public class MaterialPriceServiceImpl implements MaterialPriceService {
	List<Object[]> objects = null;
	String sus=null;
	public MaterialPriceDao mpricedao;
	public MaterialPriceDao getMpricedao() {
		return mpricedao;
	}
	public void setMpricedao(MaterialPriceDao mpricedao) {
		this.mpricedao = mpricedao;
	}
	public Long checkMaterialPrice(int material,String batchNo,String validFrom,String validTo){
		Long l = mpricedao.checkMaterialPrice(material, batchNo, validFrom, validTo);
		return l;
	}
	public Long updateCheckMaterialPrice(int material,String batchNo,String validFrom,String validTo,int materialPrice_id){
		Long l = mpricedao.updateCheckMaterialPrice(material, batchNo, validFrom, validTo, materialPrice_id);
		return l;
	}
	
	
	public String saveMaterialPriceDetails(Object object,String userId,String userName) {
		try {
			sus = mpricedao.saveMaterialPriceDetails(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchMaterialPrice() {
		
		try {
			objects = mpricedao.searchMaterialPrice();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchMaterialPriceWithId(int id) {
		List<Object[]> list = null;
		try {
			list = mpricedao.searchMaterialPriceWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateMaterialPrice(Object object) {
		try {
			sus = mpricedao.updateMaterialPrice(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteMaterialPrice(int id) {
		try {
			sus = mpricedao.deleteMaterialPrice(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectMaterialPrice() {
		
		try {
			objects = mpricedao.selectMaterialPrice();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchMaterialPrice(String label,String operator,String searchName){
		try {
			objects = mpricedao.basicSearchMaterialPrice(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> populateCurrencyIds(){
		try {
			objects = mpricedao.populateCurrencyIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
