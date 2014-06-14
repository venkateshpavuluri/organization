/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author devi
 *
 */
public interface PayGradeSalElementService {
	public String savePayGradeSalElement(Object shiftserviceobject,String userId,String userName);
	public List<Object[]>searchPayGradeSalElementServiceWithId(int id);
	public List<Object[]>searchPayGradeSalElementService();
	public List<Object[]>selectPayGradeSalElementService();
	public String updatePayGradeSalElementService(Object updateshiftservice);
	public String deletePayGradeSalElementService(int id);
	public Long getPayGradeSalElementcount(String name);
	public Long getPayGradeSalElementcountedit(String name,int shiftid);
	public List<Object[]> basicSearchPayGradeSalElement(String label,String operator,String searchName);
	public List<Object[]>selectPayGradeService();
	public List<Object[]>selectPayElementService();

}
