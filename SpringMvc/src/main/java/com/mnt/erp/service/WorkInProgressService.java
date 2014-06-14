/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0  17-04-2014
 */
public interface WorkInProgressService {
	
	public Long updateCheckWIP(String recNo, int wipId);

	public Long checkWIPCout(String wip);

	public boolean saveWIPDetails(Object object);

	public List<Object[]> searchWIP();

	public List<Object> searchWIPWithId(int wipId);

	public boolean updateWIP(Object object);

	public boolean deleteWIP(int wipId);

	public List<Object[]> basicSearchWIP(String label, String operator,
			String searchName);
}
