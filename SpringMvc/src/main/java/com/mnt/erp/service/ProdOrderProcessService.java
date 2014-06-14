/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 14-05-2014
 */
public interface ProdOrderProcessService {
	
	public boolean saveProdOdrProcess(Object object);

	public List<Object[]> searchProdOdrProcess();

	public List<Object> searchProdOdrProcessWithId(int popId);

	public boolean updateProdOdrProcess(Object object);

	public boolean deleteProdOdrProcess(int popId);

	public boolean deleteProdOdrProcessEmp(int popEmpId);

	public boolean deleteProdOdrProcessEqp(int popEqpId);

	public List<Object[]> basicSearchProdOdrProcess(String label,
			String operator, String searchName);

}
