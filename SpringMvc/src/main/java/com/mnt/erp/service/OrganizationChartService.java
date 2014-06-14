/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author tparvathi
 *
 */
public interface OrganizationChartService {

	public String saveOrganizationChart(Object object,String userId,String userName);
	
	public List<Object[]> searchOrganizationChart(int id);
	
	public List<Object[]> editOrganizationChartWithId(int id);
	
	public String updateOrganizationChart(Object object);
	
	public String OrganizationChartDelete(int id);
	
	public int OrganizationChartDuplicate(String org,String designation,String parentDesignation);
	
	public int OrganizationChartEditDuplicate(String org,String designation,String parentDesignation,int id);
	
	public List<Object[]> basicSearchOrganizationChart(String label,String operator,String searchName);
}
