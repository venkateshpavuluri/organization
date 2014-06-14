/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.erp.dao.ProdOrderProcessDao;

/**
 * @author Naresh
 * @version 1.0 14-05-2014
 */
@Service("popService")
public class ProdOrderProcessServiceImpl implements ProdOrderProcessService {
	@Autowired
	ProdOrderProcessDao prodOrderProcessDao;

	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;

	@Override
	public boolean saveProdOdrProcess(Object object) {
		try {

			flag = prodOrderProcessDao.saveProdOdrProcess(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchProdOdrProcess() {
		try {
			objects = prodOrderProcessDao.searchProdOdrProcess();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchProdOdrProcessWithId(int popId) {
		try {
			obj = prodOrderProcessDao.searchProdOdrProcessWithId(popId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateProdOdrProcess(Object object) {
		try {
			flag = prodOrderProcessDao.updateProdOdrProcess(object);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteProdOdrProcess(int popId) {
		try {
			flag = prodOrderProcessDao.deleteProdOdrProcess(popId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteProdOdrProcessEmp(int popEmpId) {
		try {
			flag = prodOrderProcessDao.deleteProdOdrProcessEmp(popEmpId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteProdOdrProcessEqp(int popEqpId) {
		try {
			flag = prodOrderProcessDao.deleteProdOdrProcessEqp(popEqpId);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchProdOdrProcess(String label,
			String operator, String searchName) {
		try {
			objects = prodOrderProcessDao.basicSearchProdOdrProcess(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
