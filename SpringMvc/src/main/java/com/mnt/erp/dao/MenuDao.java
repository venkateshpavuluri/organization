/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author venkateshp
 *
 */
public interface MenuDao {
	public int getMenuId(String location);
	public List<Object> getmenuPrivilige(String userId,int menuId);
	public String getPrivilegeName(String privilegeId);

}
