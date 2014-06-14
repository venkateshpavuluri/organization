/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author devi
 *
 */
public interface EmpTimeSheetService {
	public String saveEmpTimeSheet(Object shiftserviceobject,String userId,String userName);
	public List<Object[]>searchEmpTimeSheetWithId(int id);
	public List<Object[]>searchEmpTimeSheet();
	public List<Object[]>selectEmpTimeSheet();
	public String updateEmpTimeSheet(Object updateshiftservice);
	public String deleteEmpTimeSheet(int id);
	public Long getEmpTimeSheetCount(String name);
	public Long getEmpTimeSheetCountEdit(String name,int shiftid);
	public List<Object[]> basicSearchEmpTimeSheet(String label,String operator,String searchName);
	public List<Object[]>selectEmpService();
	public List<Object[]>selectActivityService();

}
