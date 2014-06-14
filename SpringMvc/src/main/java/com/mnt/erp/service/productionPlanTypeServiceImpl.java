package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.productionPlanTypeDao;

public class productionPlanTypeServiceImpl implements productionPlanTypeService{
	List<Object[]> list=null;
	productionPlanTypeDao ppdao;
	public productionPlanTypeDao getPpdao() {
		return ppdao;
	}
	public void setPpdao(productionPlanTypeDao ppdao) {
		this.ppdao = ppdao;
	}
	
	public String saveProductionPlanType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = ppdao.saveProductionPlanType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkProductionPlanType(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = ppdao.checkProductionPlanType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchProductionPlanType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = ppdao.searchProductionPlanType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchProductionPlanTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = ppdao.searchProductionPlanTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchProductionPlanType(String label,String operator,String searchName){
		try {
			list = ppdao.basicSearchProductionPlanType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteProductionPlanType(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = ppdao.deleteProductionPlanType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateProductionPlanType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = ppdao.updateProductionPlanType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectProductionPlanType() {
		// TODO Auto-generated method stub
		
		try {
			list = ppdao.searchProductionPlanType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProductionPlanType(String type, int Id) {
		long count = 0;
		try {
			count = ppdao.updateCheckProductionPlanType(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	

}
