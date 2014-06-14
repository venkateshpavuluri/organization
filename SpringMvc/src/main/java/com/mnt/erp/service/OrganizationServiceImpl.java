/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.mnt.erp.bean.Organization;
import com.mnt.erp.dao.OrganizationDao;

/**
 * @author pvenkateswarlu
 * @version 1.0 18-09-2013
 */
public class OrganizationServiceImpl implements OrganizationService {

	static Logger logger = Logger.getLogger(OrganizationServiceImpl.class);
	OrganizationDao dao;

	/**
	 * @return the dao
	 */
	public OrganizationDao getDao() {
		return dao;
	}

	public void setDao(OrganizationDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveOrganizationDetails(Object object, String userId,
			String userName) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.saveOrganizationDetails(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> getOrganizationIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.getOrganizationIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Organization> searchOrganization() {
		List<Organization> organizations = null;
		try {
			organizations = dao.searchOrganization();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return organizations;
	}

	@Override
	public List<Organization> searchOrganizationWithId(int id) {
		List<Organization> organizations = null;
		try {
			organizations = dao.searchOrganizationWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return organizations;
	}

	@Override
	public String updateOrganization(Object object) {
		String msg = null;
		try {
			Organization organization = (Organization) object;
			organization.setAdd1(organization.getAdd1Edit());
			organization.setAdd2(organization.getAdd2Edit());
			organization.setAdd3(organization.getAdd3Edit());
			organization.setCity(organization.getCityEdit());
			organization.setCountryId(organization.getCountryIdEdit());
			organization.setEmail(organization.getEmailEdit());
			organization.setFax(organization.getFaxEdit());
			organization.setOrgId(organization.getOrgIdEdit());
			organization.setOrgName(organization.getOrgNameEdit());
			organization.setOrgType(organization.getOrgTypeEdit());
			organization.setOrgTypeId(organization.getOrgTypeIdEdit());
			organization.setPhone(organization.getPhoneEdit());
			organization.setState(organization.getStateEdit());
			organization.setImage(organization.getImageEdit());

			if (organization.getImageEdit() != null) {
				logger.info("image upgate=="
						+ organization.getImageEdit().length);
			}
			msg = dao.updateOrganization(organization);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteOrganization(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.deleteOrganization(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long duplicateCheck(String orgName) {
		// TODO Auto-generated method stub
		Long duid = 0l;
		try {
			duid = dao.duplicateCheck(orgName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return duid;
	}

	@Override
	public Long updateDuplicateCheck(String orgName, int orgId) {
		// TODO Auto-generated method stub
		Long duid = 0l;
		try {
			duid = dao.updateDuplicateCheck(orgName, orgId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return duid;
	}

	public List<Object[]> selectOrganizationDetails() {
		// TODO Auto-generated method stub
		// String msg=null;
		List<Object[]> list = null;
		try {
			list = dao.selectOrganizationDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Organization> basicSearchOrganization(String label,
			String operator, String searchName) {
		List<Organization> organizations = null;
		try {
			organizations = dao.basicSearchOrganization(label, operator,
					searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return organizations;

	}

	@Override
	public List<Object[]> getOrganizationAdvance(String columns,
			String opeator, String advanceSearchText) {
		String column[] = columns.split(",");
		String op[] = opeator.split(",");
		String advanceSearch[] = advanceSearchText.split(",");
		String finalStringForSearch = "";
		int count = 0;
		for (int i = 0; i < advanceSearch.length; i++) {
			if (!op[i].equals("0") && advanceSearch[i] != "") {

				if (op[i].equals("_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = advanceSearch[i] + "%";

				} else if (op[i].equals("%_")) {
					column[i] = column[i];
					op[i] = "like ";
					advanceSearch[i] = "%" + advanceSearch[i];

				} else if (op[i].equals("%_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = "%" + advanceSearch[i] + "%";

				} else if (op[i].equals("=")) {
					column[i] = column[i];
					op[i] = "=";
					advanceSearch[i] = advanceSearch[i];

				} else if (op[i].equals("!=")) {
					column[i] = column[i];
					op[i] = "!=";
					advanceSearch[i] = advanceSearch[i];

				}
				if (!"".equals(advanceSearch[i])) {
					if (count > 0) {
						finalStringForSearch += " and o." + column[i] + " "
								+ op[i] + "'" + advanceSearch[i] + "'";
					} else {
						finalStringForSearch += " o." + column[i] + " " + op[i]
								+ "'" + advanceSearch[i] + "'";
						count++;
					}

				}

			}

		}

		List<Object[]> list = null;
		if (finalStringForSearch.length() > 0) {
			list = dao.organizationAdvanceSearch(finalStringForSearch);
		} else {
			list = dao.organizationAdvanceSearch("ALL");
		}
		return list;
	}

	public List<Object[]> getOrganization(String organization) {
		List<Object[]> list = dao.setOrganizationSearch(organization);
		return list;
	}
}
