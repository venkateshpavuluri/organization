/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 04-01-2014
 */
public interface GLJournalDao {

	public boolean saveGLJournal(Object object);

	public List<Object[]> searchGLJournal();
	
	public List<Object[]> advSearchGLJournal(String advSearch);

	public List<Object> searchGLJournalWithId(int glId);

	public boolean updateGLJournal(Object object);

	public boolean deleteGLJournal(int glId);

	public boolean deleteGLJournalLine(int gljId);

	public List<Object[]> basicSearchGLJournal(String label, String operator,
			String searchName);

}
