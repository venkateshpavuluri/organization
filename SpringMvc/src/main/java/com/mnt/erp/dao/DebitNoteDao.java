/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 02-01-2014
 */
public interface DebitNoteDao {

	public int updateCheckDebitNote(String debNo, int dnId);

	public Long checkDebitNote(String debNo);

	public boolean saveDebitNote(Object object);

	public List<Object[]> searchDebitNote();
	
	public List<Object[]> advSearchDebitNote(String advSearch);

	public List<Object> searchDebitNoteWithId(int dnId);

	public boolean updateDebitNote(Object object);

	public boolean deleteDebitNote(int dnId);

	public boolean deleteDebitNoteLine(int dndId);

	public List<Object[]> basicSearchDebitNote(String label, String operator,
			String searchName);

}
