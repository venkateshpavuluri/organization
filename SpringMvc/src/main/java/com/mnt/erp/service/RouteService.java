/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author anikesh
 *
 */
public interface RouteService {
	public String saveRouteDetails(Object object,String userId,String userName);
	public Long duplicateRouteCheck(String route);
	public List<Object[]> selectOrganizationIds();
	public List<Object[]> selectUomIds();
	public List<Object[]> searchRoute();
	public List<Object[]> searchRouteWithName(String routecode);
	public List<Object[]> getRouteAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> selectRouteNames();
	public List<Object[]> basicSearchRoute(String label,String operator,String searchName);
	public List<Object[]> searchRouteWithId(String regnum);
	public String updateRoute(Object object);
	public Long updateDuplicateCheck(String regnum, int routeid);
	public String routeDelete(String id);
}
