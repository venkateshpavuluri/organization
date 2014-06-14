/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Sailaja	
 * @version 1.0 29-10-2013
 * @build 0.0
 *
 */
public interface ReasonForRejectionDao {
	
	public String addReasonForRejection(Object object);
	public List<Object[]> searchReasonForRejection();
	public List<Object[]> searchReasonForRejectionWithId(int id);
	public String updateReasonForRejection(Object object);
	public String deleteReasonForRejection(int id);
	public int checkDuplicate(String checkReasonForRejection);
	public int checkEditDuplicate(String checkReasonForRejection,int id);
	public List<Object[]> basicSearchRFR(String label,String operator,String searchName);


}
