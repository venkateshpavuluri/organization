/**
 * Copyright MNTSOFT 
 */
package com.mnt.erp.service;

import java.util.Map;

/**
 * @author pvenkateswarlu
 * @version 1.0 09-10-2013
 */
public interface PopulateService {
	public java.util.List<Object[]> poPulate(String sql);

	public Map<String, String> populatePopUp(String sql);

	public Map<Integer, String> populateSelectBox(String sql);

	public Long DuplicateCheck(String hql);

}
