/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author devi
 *
 */
public interface inspectionDecisionDao {
	public String saveInspectionDecision(Object object,String userId,String userName);
	public long checkInspectionDecision(String type);
	public List<Object[]> searchInspectionDecision();
	public String deleteInspectionDecision(int id);
	public List<Object[]> searchInspectionDecisionWithId(int id);
	public List<Object[]> basicSearchInspectionDecision(String label,String operator,String searchName);
	public String updateInspectionDecision(Object object);
	public List<Object[]> selectInspectionDecision();
	public long updateCheckInspectionDecision(String type, int Id);
	public List<Object[]> getInspectionLotOriginIds();
}
