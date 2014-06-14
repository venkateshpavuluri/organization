/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 30-10-2013
 * @build 0.0
 *
 */
public interface ReasonForMovementService {
	
	public String addReasonForMovement(Object object);
	public List<Object[]> searchReasonForMovement();
	public List<Object[]> searchReasonForMovementWithId(int id);
	public String updateReasonForMovement(Object object);
	public String deleteReasonForMovement(int id);
	public int checkDuplicate(String checkReasonForMovement);
	public int checkEditDuplicate(String checkReasonForMovement,int id);
	public List<Object[]> basicSearchRFM(String label,String operator,String searchName);



}
