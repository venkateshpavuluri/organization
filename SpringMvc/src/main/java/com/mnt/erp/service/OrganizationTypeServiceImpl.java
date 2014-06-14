/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.OrganizationTypeDao;

/**
 * @author pvenkateswarlu
 * @version 1.0 19-09-2013
 */
public class OrganizationTypeServiceImpl implements OrganizationTypeService {
	String msg = null;
	List<Object[]> list = null;

	/**
	 * @return the dao
	 */
	public OrganizationTypeDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(OrganizationTypeDao dao) {
		this.dao = dao;
	}

	public OrganizationTypeDao dao;

	@Override
	public List<Object[]> getOrganizationTypeIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.getOrganizationTypeIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String saveOrganizationType(Object object,String userId,String userName) {
		// TODO Auto-generated method stub

		try {
			msg = dao.saveOrganizationType(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchOrganizationType() {
		// TODO Auto-generated method stub

		try {
			list = dao.searchOrganizationType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchOrganizationTypeWithId(int id) {
		// TODO Auto-generated method stub
		try {
			list = dao.searchOrganizationTypeWithId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateOrganization(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = dao.updateOrganization(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteOrganizationType(Object object) {
		// TODO Auto-generated method stub
		try {
			msg = dao.deleteOrganizationType(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long duplicateCheck(String orgType) {
		// TODO Auto-generated method stub
		Long dupid = 0l;
		try {
			dupid = dao.duplicateCheck(orgType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dupid;
	}

	@Override
	public Long updateDuplicateCheck(String orgTypeName, int orgTypeId) {
		// TODO Auto-generated method stub
		Long dupid = 0l;
		try {
			dupid = dao.updateDuplicateCheck(orgTypeName, orgTypeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dupid;
	}

	public List<Object[]> basicSearchOrgType(String label, String operator,
			String searchName) {
		try {
			list = dao.basicSearchOrgType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
