/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.OrgPlants;
import com.mnt.erp.bean.PurOrgCompany;
import com.mnt.erp.bean.PurOrgPlant;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.service.AuditLogService;

/**
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class PurchaseOrganizationDaoImpl extends HibernateDaoSupport implements
		PurchaseOrganizationDao {
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	String msg = null;

	public String savePurchaseOrganization(Object object, String userId,
			String userName) {
		try {
			PurchaseOrganization purchaseOrganization = (PurchaseOrganization) object;
			Serializable id = getHibernateTemplate().save(purchaseOrganization);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A",
						"Purchase Organization", "ROW", String.valueOf(id),
						"1", modifiedDate, userName);
				msg = "S";
			}

		}

		catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}

		return msg;

	}

	public List<Object[]> searchPurchaseOrganization() {

		try {
			String hql = "from PurchaseOrganization p order by p.purOrg";
			list = getHibernateTemplate().find(hql);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<OrgPlants> selectPlants(String orgId){
		//List<Object[]> listFinal = new ArrayList<Object[]>(list);
		List<OrgPlants> list2 = null;
		Iterator<Object[]> iterator = null;
		OrgPlants orgplant=null;
		//List<Object> list = null;
		try {
			
			list2=new ArrayList<OrgPlants>();
			if(!orgId.equals("null")){
			
				for (String retval: orgId.split(",")){
	         
	        int orgIds=Integer.parseInt(retval);
			String hql = "select p.plantId,p.plantName from Plant p where p.orgId="
					+ orgIds + "";
			
			list = getHibernateTemplate().find(hql);
			iterator = list.iterator();
			orgplant=new OrgPlants();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				orgplant.setPlantId((Integer)object[0]);
				orgplant.setPlantName((String)object[1]);
				list2.add(orgplant);

			}

				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}
	public List<PurchaseOrganization> editPurchaseOrganizationWithId(int id) {

		List<PurchaseOrganization> objects = null;
		try {

			String sql = "from PurchaseOrganization po where po.purOrg_Id="
					+ id + "";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public String updatePurchaseOrganization(Object object) {

		List<PurOrgCompany> list2 = null;
		List<PurOrgPlant> list3 = null;
		PurOrgPlant pp1 = null;
		PurOrgCompany pc = null;
		Iterator<PurOrgCompany> iterator1 = null;
		PurOrgCompany purOrgCompany = null;
		PurOrgPlant pp = null;
		Iterator<PurOrgPlant> iterator2 = null;

		try {

			PurchaseOrganization pg = (PurchaseOrganization) object;
			int id = pg.getPurOrg_Id();
			PurchaseOrganization po = (PurchaseOrganization) getHibernateTemplate()
					.get(PurchaseOrganization.class, id);
			list2 = po.getPurOrgCompany();
			list3 = po.getPurOrgPlants();
			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				purOrgCompany = (PurOrgCompany) iterator1.next();
				pc = new PurOrgCompany();
				pc.setPurOrgCompany_Id(purOrgCompany.getPurOrgCompany_Id());
				getHibernateTemplate().delete(pc);

			}
			iterator2 = list3.iterator();
			while (iterator2.hasNext()) {
				pp = (PurOrgPlant) iterator2.next();
				pp1 = new PurOrgPlant();
				pp1.setPurOrgPlant_Id(pp.getPurOrgPlant_Id());
				getHibernateTemplate().delete(pp1);

			}
			// Integer[] plant=pg.getPlantId();
			getHibernateTemplate().update(pg);
			msg = "S";
		}

		catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	public String deletePurchaseOrganization(int id) {
		String msg = null;
		PurchaseOrganization po = null;
		try {
			// po=(PurchaseOrganization)getHibernateTemplate().get(PurchaseOrganization.class,id);
			po = new PurchaseOrganization();
			po.setPurOrg_Id(id);
			getHibernateTemplate().delete(po);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;

	}

	public int purchaseOrganizationDuplicate(String purOrg) {

		Long count = null;
		try {

			final String hql = "select count(*) from PurchaseOrganization p where p.purOrg='"
					+ purOrg + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query = session
									.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();

	}

	public int purchaseOrganizationEditDuplicate(String purOrg, int id) {

		Long count = null;
		try {

			final String hql = "select count(*) from PurchaseOrganization p where p.purOrg='"
					+ purOrg + "'and p.purOrg_Id!='" + id + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query = session
									.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	@Override
	public List<Object[]> basicSearchPurchaseOrganization(String label,
			String operator, String searchName) {
		try {

			String hql = "from PurchaseOrganization po where po." + label + ""
					+ operator + " ? ORDER BY po.purOrg";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> selectPurchaseOrg() {
		// TODO Auto-generated method stub
		String hql = "select po.purOrg_Id,po.purOrg from PurchaseOrganization po ";

		List<Object[]> list = getHibernateTemplate().find(hql);
		return list;
	}

}
