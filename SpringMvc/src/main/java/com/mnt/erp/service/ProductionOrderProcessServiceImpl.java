/**
@copyright MNT SOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.mnt.erp.dao.ProductionOrderProcessDao;

/**
 * @author sailajach
 * @version 1.0 05-02-2014
 * @build 0.0
 *
 */

public class ProductionOrderProcessServiceImpl implements ProductionOrderProcessService{
	
	private Logger logger=Logger.getLogger(ProductionOrderProcessServiceImpl.class);
	List<Object[]> list = null;
	String message=null;
	
	public ProductionOrderProcessDao productionOrderProcessDao;

	public ProductionOrderProcessDao getProductionOrderProcessDao() {
		return productionOrderProcessDao;
	}

	public void setProductionOrderProcessDao(
			ProductionOrderProcessDao productionOrderProcessDao) {
		this.productionOrderProcessDao = productionOrderProcessDao;
	}

	@Override
	public List<Object[]> getProductionOrderNo() {
		// TODO Auto-generated method stub
	
		try {
			list = productionOrderProcessDao.getProductionOrderNo();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
		
	}

	@Override
	public List<Object[]> getWorkCenterName() {
		// TODO Auto-generated method stub
		try {
			list = productionOrderProcessDao.getWorkCenterName();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Object[]> getProcessDetail() {
		// TODO Auto-generated method stub
		try {
			list = productionOrderProcessDao.getProcessDetail();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public String addProductionOrderProcess(Object obj) {
		// TODO Auto-generated method stub
		try
		{
		
		message = productionOrderProcessDao.addProductionOrderProcess(obj);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Object[]> searchProductionOrderProcess() {
		// TODO Auto-generated method stub
		try {

			list = productionOrderProcessDao.searchProductionOrderProcess();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return list;
	}
	@Override
	public List<Object[]> basicSearchProductionOrderProcess(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		try {
			list = productionOrderProcessDao.basicSearchProductionOrderProcess(label, operator, searchName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Object> editProductionOrderProcessWithId(int popid) {
		// TODO Auto-generated method stub
	List<Object> list=null;
		try {
			list = productionOrderProcessDao.editProductionOrderProcessWithId(popid);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public String updateProductionOrderProcess(Object object) {
		// TODO Auto-generated method stub
		try
		{
			message = productionOrderProcessDao.updateProductionOrderProcess(object);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
		}
		return message;
	}

	@Override
	public String deleteProductionOrderProcess(int id) {
		// TODO Auto-generated method stub
		try {
			message = productionOrderProcessDao.deleteProductionOrderProcess(id);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return message;
	}

	@Override
	public int checkDuplicate(String checkProductionOrderNo) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = productionOrderProcessDao.checkDuplicate(checkProductionOrderNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list1;
	}

	@Override
	public int checkEditDuplicate(String checkProductionOrderNo, String id) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = productionOrderProcessDao.checkEditDuplicate(checkProductionOrderNo, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list1;
	}

	@Override
	public String deleteProductionOrderProcessChild(int pLineId) {
		// TODO Auto-generated method stub
		try {
			message = productionOrderProcessDao.deleteProductionOrderProcessChild(pLineId);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return message;
	}

	

}
