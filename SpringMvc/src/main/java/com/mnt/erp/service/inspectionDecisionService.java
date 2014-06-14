/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author devi
 *
 */
public interface inspectionDecisionService {
	public String saveInspectionDecision(Object object,String userId,String userName);
	public long checkInspectionDecision(String type);
	public List<Object[]> searchInspectionDecision();
	public List<Object[]> searchInspectionDecisionWithId(int id);
	public List<Object[]> basicSearchInspectionDecision(String label,String operator,String searchName);
	public String deleteInspectionDecision(int id);
	public String updateInspectionDecision(Object object);
	public List<Object[]> selectInspectionDecision();
	public long updateCheckInspectionDecision(String type, int Id);
	public List<Object[]>selectInspectionDecisionservice();

}
