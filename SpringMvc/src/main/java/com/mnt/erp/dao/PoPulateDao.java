/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author pvenkateswarlu
 *
 */
public interface PoPulateDao {
	public List<Object[]> poPulate(String sql);
	
	public List<Object> DuplicateCheck(String hql);

}
