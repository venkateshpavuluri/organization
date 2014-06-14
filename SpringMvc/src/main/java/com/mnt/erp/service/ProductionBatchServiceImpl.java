package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ProductionBatchDao;

public class ProductionBatchServiceImpl implements ProductionBatchService{
	String message;
	ProductionBatchDao pbdao;
	List<Object[]> objects;
	
	public ProductionBatchDao getPbdao() {
		return pbdao;
	}

	public void setPbdao(ProductionBatchDao pbdao) {
		this.pbdao = pbdao;
	}

	@Override
	public String saveProductionBatchservice(Object object, String userId,
			String userName) {
		try {
			message = pbdao.saveProductionBatch(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return message;
	}

	@Override
	public List<Object[]> searchProductionBatchWithId(int id) {
		try {
			objects = pbdao.searchProductionBatchWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchProductionBatch() {
		try {
			objects = pbdao.searchProductionBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectProductionOrderIds() {
		try {
			objects = pbdao.selectproductionorderIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectStatusIds() {
		try {
			objects = pbdao.selectStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public String updateProductionBatch(Object object) {
		try {
			message = pbdao.updateProductionBatch(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteProductionBatch(int id) {
		try {
			message = pbdao.deleteProductionBatch(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Long getProductionBatchCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getProductionBatchCountedit(String name, int accountgroupid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchProductionBatch(String label,
			String operator, String searchName) {
		try {
			objects = pbdao.basicSearchProductionBatch(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
