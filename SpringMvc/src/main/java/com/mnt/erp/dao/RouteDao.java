/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author anikesh
 *
 */
public interface RouteDao {
	public String saveRouteDetails(Object object,String userId,String userName);
	public Long duplicateRouteCheck(String route);
	public List<Object[]> selectOrganizationIds();
	public List<Object[]> selectUomIds();
	public List<Object[]> searchRoute();
	public List<Object[]> searchRouteWithName(String regnum);
	public List<Object[]> setRouteAdvanceSearch(String route);
	public List<Object[]> selectRouteNames();
	public List<Object[]> basicSearchRoute(String label,String operator,String searchName);
	public List<Object[]> searchRouteWithId(String regnum);
	public String updateRoute(Object object);
	public Long updateDuplicateCheck(String regnum, int routeid);
	public String routeDelete(String id);
}
