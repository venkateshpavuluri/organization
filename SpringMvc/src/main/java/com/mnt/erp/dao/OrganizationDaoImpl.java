/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.OrganizationType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author pvenkateswarlu
 * @version 1.0 18-09-2013
 */
public class OrganizationDaoImpl extends HibernateDaoSupport implements
		OrganizationDao {

	@Autowired
	AuditLogService auditLogService;
	private String o;
	private String sql;
	List<Object[]> list = null;

	@Override
	public String saveOrganizationDetails(Object object, String userId,
			String userName) {
		// TODO Auto-generated method stub
		Organization organization = (Organization) object;
		organization.setOrgId(1);
		try {

			Serializable id = getHibernateTemplate().save(organization);

			if (id != null) {
				o = "S";

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Organization",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			o = "F";
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public List<Object[]> getOrganizationIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select o.orgId,o.orgName from Organization o";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Organization> searchOrganization() {
		// TODO Auto-generated method stu
		List<Object[]> list = null;
		List<Organization> organizations = new ArrayList<Organization>();
		String sql = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		Organization organization = null;
		OrganizationType organizationType = null;
		CountrysList countrysList = null;
		try {
			sql = "select o.orgId,o.orgName,o.add1,o.add2,o.add3,o.city,o.state,o.countrysList,o.phone,o.fax,o.email,o.organizationType,o.image from Organization o order by o.orgName";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				organization = new Organization();
				organization.setOrgId((Integer) objects[0]);
				organization.setOrgName((String) objects[1]);
				organization.setAdd1((String) objects[2]);
				organization.setAdd2((String) objects[3]);
				organization.setAdd3((String) objects[4]);
				organization.setCity((String) objects[5]);
				organization.setState((String) objects[6]);
				countrysList = (CountrysList) objects[7];
				// organization.setCountryId((Integer)objects[7]);
				organization.setCountry(countrysList.getCountryName());
				organization.setPhone((String) objects[8]);
				organization.setFax((String) objects[9]);
				organization.setEmail((String) objects[10]);
				organizationType = (OrganizationType) objects[11];
				// Byte bytes=(Byte)objects[12];

				organization.setOrgTypeId(String.valueOf(organizationType
						.getOrgTypeId()));
				organization.setOrgType(organizationType.getOrgType());
				organizations.add(organization);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return organizations;
	}

	@Override
	public List<Organization> searchOrganizationWithId(int id) {

		List<Object[]> list = null;
		List<Organization> organizations = new ArrayList<Organization>();
		String sql = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		Organization organization = null;
		OrganizationType organizationType = null;
		CountrysList countrysList = null;
		try {
			sql = "select o.orgId,o.orgName,o.add1,o.add2,o.add3,o.city,o.state,o.countrysList,o.phone,o.fax,o.email,o.organizationType,o.orgTypeId,o.image from Organization o where o.orgId="
					+ id + " order by o.orgName";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				organization = new Organization();
				organization.setOrgId((Integer) objects[0]);
				organization.setOrgName((String) objects[1]);
				organization.setAdd1((String) objects[2]);
				organization.setAdd2((String) objects[3]);
				organization.setAdd3((String) objects[4]);
				organization.setCity((String) objects[5]);
				organization.setState((String) objects[6]);
				// organization.setCountry((String)objects[7]);
				countrysList = (CountrysList) objects[7];
				// organization.setCountryId((Integer)objects[7]);
				organization.setCountryId(String.valueOf(countrysList
						.getCountryId()));
				organization.setCountry(countrysList.getCountryName());
				organization.setPhone((String) objects[8]);
				organization.setFax((String) objects[9]);
				organization.setEmail((String) objects[10]);
				organizationType = (OrganizationType) objects[11];
				organization.setOrgTypeId(String.valueOf(organizationType
						.getOrgTypeId()));
				organization.setOrgType(organizationType.getOrgType());
				organization.setOrganizationType(organizationType);
				byte[] bytes = (byte[]) objects[13];
				organization.setImage(bytes);
				organizations.add(organization);

			}
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
			getHibernateTemplate().update(organization);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteOrganization(int id) {
		// TODO Auto-generated method stub
		Organization organization = null;
		String msg = null;
		try {
			organization = (Organization) getHibernateTemplate().get(
					Organization.class, id);
			organization.setOrganizationType(new OrganizationType());
			organization.setCountrysList(new CountrysList());
			getHibernateTemplate().delete(organization);
			msg = "S";

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	public Long duplicateCheck(String orgName) {
		Long duid = 0l;
		List<Object> list = null;
		Iterator<Object> iterator = null;
		Object object = null;
		try {
			sql = "select count(*) from Organization o where  o.orgName='"
					+ orgName + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object) iterator.next();
				duid = (Long) object;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return duid;

	}

	public Long updateDuplicateCheck(String orgName, int orgId) {
		Long duid = 0l;
		List<Object> list = null;
		Iterator<Object> iterator = null;
		Object object = null;
		try {
			sql = "select count(*) from Organization o where  o.orgName='"
					+ orgName + "' and o.orgId!=" + orgId + "";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object) iterator.next();
				duid = (Long) object;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return duid;

	}

	@Override
	public List<Object[]> selectOrganizationDetails() {

		String sql = null;
		try {

			sql = "select o.orgId,o.orgName from Organization o";

			list = getHibernateTemplate().find(sql);

		} catch (Exception e)

		{
			e.printStackTrace();
		}
		return list;
	}

	public List<Organization> basicSearchOrganization(String label,
			String operator, String searchName) {
		List<Organization> organizations = new ArrayList<Organization>();
		String sql = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		Organization organization = null;
		OrganizationType organizationType = null;
		CountrysList countrysList = null;
		try {

			String hql = "select o.orgId,o.orgName,o.add1,o.add2,o.add3,o.city,o.state,o.countrysList,o.phone,o.fax,o.email,o.organizationType,o.orgTypeId from Organization o where o."
					+ label + "" + operator + " ? order by o.orgName ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);

			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				organization = new Organization();
				organization.setOrgId((Integer) objects[0]);
				organization.setOrgName((String) objects[1]);
				organization.setAdd1((String) objects[2]);
				organization.setAdd2((String) objects[3]);
				organization.setAdd3((String) objects[4]);
				organization.setCity((String) objects[5]);
				organization.setState((String) objects[6]);
				countrysList = (CountrysList) objects[7];
				// organization.setCountryId((Integer)objects[7]);
				organization.setCountry(countrysList.getCountryName());
				organization.setPhone((String) objects[8]);
				organization.setFax((String) objects[9]);
				organization.setEmail((String) objects[10]);
				organizationType = (OrganizationType) objects[11];
				organization.setOrgTypeId(String.valueOf(organizationType
						.getOrgTypeId()));
				organization.setOrgType(organizationType.getOrgType());
				organizations.add(organization);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return organizations;
	}

	@Override
	public List<Object[]> organizationAdvanceSearch(String organization) {
		String hql = null;
		if (organization.equalsIgnoreCase("ALL")) {
			hql = "select o.orgId,o.orgName,o.add1,o.add2,o.add3,o.city,o.state,o.countrysList,o.phone,o.fax,o.email,o.organizationType from Organization o order by o.orgName";
		}

		if (!organization.equalsIgnoreCase("ALL")) {

			hql = "select o.orgId,o.orgName,o.add1,o.add2,o.add3,o.city,o.state,o.countrysList,o.phone,o.fax,o.email,o.organizationType,o.orgTypeId from Organization o where "
					+ organization + " order by o.orgName";
		}
		try {
		list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<Object[]> setOrganizationSearch(String organization) {
		String hql = null;
		if (organization.equalsIgnoreCase("ALL")) {
			hql = "select o.orgId,o.orgName,o.add1,o.add2,o.add3,o.city,o.state,o.countrysList,o.phone,o.fax,o.email,o.organizationType from Organization o";

		}
		if (!organization.equalsIgnoreCase("ALL")) {
			hql = "select o.orgId,o.orgName,o.add1,o.add2,o.add3,o.city,o.state,o.countrysList,o.phone,o.fax,o.email,o.organizationType,o.orgTypeId from Organization o where+"
					+ organization + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

}
