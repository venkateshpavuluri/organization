package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.ProductionPlanDao;

public class ProductionPlanServiceImpl implements ProductionPlanService {
	List<Object[]> objects = null;
	String sus=null;
	
	private ProductionPlanDao proPlanDao;
	
	public ProductionPlanDao getProPlanDao() {
		return proPlanDao;
	}
	public void setProPlanDao(ProductionPlanDao proPlanDao) {
		this.proPlanDao = proPlanDao;
	}
	
	public Long checkProductionPlan(String fiscalYear){
		Long l = proPlanDao.checkProductionPlan(fiscalYear);
		return l;
	}
	public Long updateCheckProductionPlan(String fiscalYear,int fiscalYearId) {
		Long l = proPlanDao.updateCheckProductionPlan(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String saveProductionPlanDetails(Object object,String userId,String userName) {
		try {
			sus = proPlanDao.saveProductionPlanDetails(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchProductionPlan() {
		
		try {
			objects = proPlanDao.searchProductionPlan();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> searchProductionPlanWithId(int id) {
		List<Object> list = null;
		try {
			list = proPlanDao.searchProductionPlanWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateProductionPlan(Object object) {
		try {
			sus = proPlanDao.updateProductionPlan(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteProductionPlan(int id) {
		try {
			sus = proPlanDao.deleteProductionPlan(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectPlant() {
		
		try {
			objects = proPlanDao.selectPlant();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public List<Object[]> selectProductionPlanType() {
		
		try {
			objects = proPlanDao.selectProductionPlanType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectStatus() {
		
		try {
			objects = proPlanDao.selectStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectProject() {
		
		try {
			objects = proPlanDao.selectProject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
public List<Object[]> selectMaterial() {
		
		try {
			objects = proPlanDao.selectMaterial();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

public List<Object[]> selectUom() {
	
	try {
		objects = proPlanDao.selectUom();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
public List<Object[]> selectProductionOrderNums() {
	
	try {
		objects = proPlanDao.selectProductionOrderNums();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
	public List<Object[]> basicSearchProductionPlan(String label,String operator,String searchName){
		try {
			objects = proPlanDao.basicSearchProductionPlan(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deleteProductionPlanLine(int kk){
		String msg = null;
		try {
			msg = proPlanDao.deleteProductionPlanLine(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	
}
