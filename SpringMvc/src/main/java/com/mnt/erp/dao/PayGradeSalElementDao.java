/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author devi
 *
 */
public interface PayGradeSalElementDao {
	public String savePayGradeSalElement(Object shiftObject,String userId,String userName);
	public List<Object[]>searchPayGradeSalElementWithId(int id);
	public List<Object[]>searchPayGradeSalElement();
	public List<Object[]>selectPayGradeSalElement();
	public String updatePayGradeSalElement(Object shiftupdate);
	public String deletePayGradeSalElement(int id);
	public Long getPayGradeSalElementCount(String name);
	public Long getPayGradeSalElementCountedit(String name,int shiftid);
	public List<Object[]> basicSearchPayGradeSalElement(String label,String operator,String searchName);
	public List<Object[]> getPayGradeIds();
	public List<Object[]> getPayElementIds();

}
