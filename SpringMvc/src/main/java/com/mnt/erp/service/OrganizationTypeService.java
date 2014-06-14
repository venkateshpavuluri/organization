/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author pvenkateswarlu
 * @version 1.0 19-09-2013
 */
public interface OrganizationTypeService {
	public List<Object[]> getOrganizationTypeIds();

	public String saveOrganizationType(Object object,String userId,String userName);

	public List<Object[]> searchOrganizationType();

	public List<Object[]> searchOrganizationTypeWithId(int id);

	public String updateOrganization(Object object);

	public String deleteOrganizationType(Object object);

	public Long duplicateCheck(String orgType);

	public Long updateDuplicateCheck(String orgTypeName, int orgTypeId);
	public List<Object[]> basicSearchOrgType(String label, String operator,
			String searchName);

}
