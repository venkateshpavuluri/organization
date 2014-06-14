/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.service.AuditLogService;

/**
 * @author pvenkateswarlu
 * @version 1.0 23-09-2013
 */
public class StorageLocationDaoImpl extends HibernateDaoSupport implements
		StorageLocationDao {
	@Autowired
	AuditLogService auditLogService;
	String sql;
	List<Object[]> list;
	Iterator<Object> duplicateChekIterator;
	String msg;

	@Override
	public String saveStoragLocation(Object object, String userId,
			String userName) {
		// TODO Auto-generated method stub
		StorageLocation storageLocation = null;
		Serializable id = null;

		try {
			storageLocation = (StorageLocation) object;
			id = getHibernateTemplate().save(storageLocation);
			msg = "S";
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A",
						"Storage Location", "ROW", String.valueOf(id), "1",
						modifiedDate, userName);
			}
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public List<Object[]> searchStorageLocation() {
		try {
			sql = "select s.storageLocationId ,s.storageLocation,s.add1,s.add2,s.add3,s.city,s.state,s.phone,s.fax,s.mobile,s.zip,s.plants,s.countrysList  from StorageLocation s order by s.storageLocation ";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<StorageLocation> searchStorageWithId(int id) {
		// TODO Auto-generated method stub
		List<StorageLocation> list1 = null;
		Long count = 0l;
		try {

			sql = "from StorageLocation s where  s.storageLocationId=" + id
					+ "";

			list1 = getHibernateTemplate().find(sql);
			Iterator<StorageLocation> iterator = list1.iterator();
			while (iterator.hasNext()) {
				StorageLocation location = (StorageLocation) iterator.next();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public List<Object[]> getStorageIds() {
		// TODO Auto-generated method stub

		try {
			sql = "select s.storageLocationId,s.storageLocation from StorageLocation s";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String deleteStorageLoc(Object object) {
		// TODO Auto-generated method stub
		try {
			StorageLocation storageLocation = (StorageLocation) object;
			getHibernateTemplate().delete(storageLocation);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String updateStorageLocation(Object object) {
		// TODO Auto-generated method stub
		StorageLocation location = null;
		try {
			location = (StorageLocation) object;
			getHibernateTemplate().update(location);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	public Long duplicateCheck(String storageLocation) {
		Long code = 0l;
		List<Object> list = null;
		Object object = null;
		try {
			sql = "select count(*) from StorageLocation s where  s.storageLocation='"
					+ storageLocation + "'";
			list = getHibernateTemplate().find(sql);
			duplicateChekIterator = list.iterator();

			while (duplicateChekIterator.hasNext()) {
				object = (Object) duplicateChekIterator.next();
				code = (Long) object;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	@Override
	public Long updateDuplicateCheck(String storageLocation,
			int storageLocationId) {
		// TODO Auto-generated method stub
		Long duplicateId = 0l;
		List<Object> list = null;
		Object object = null;
		try {
			sql = "select count(*) from StorageLocation s where  s.storageLocation='"
					+ storageLocation
					+ "' and s.storageLocationId!="
					+ storageLocationId + "";
			list = getHibernateTemplate().find(sql);
			duplicateChekIterator = list.iterator();

			while (duplicateChekIterator.hasNext()) {
				object = (Object) duplicateChekIterator.next();
				duplicateId = (Long) object;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicateId;
	}

	public List<Object[]> basicSearchStorageLoc(String label, String operator,
			String searchName) {
		List<Object[]> list = null;
		try {

			String hql = "select s.storageLocationId ,s.storageLocation,s.add1,s.add2,s.add3,s.city,s.state,s.phone,s.fax,s.mobile,s.zip,s.plants,s.countrysList  from StorageLocation s where s."
					+ label + "" + operator + " ? order by s.storageLocation";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> storageAdvanceSearch(String storage) {
		// TODO Auto-generated method stub
		String hql = null;
		if (storage.equalsIgnoreCase("ALL")) {
			hql = "select s.storageLocationId ,s.storageLocation,s.add1,s.add2,s.add3,s.city,s.state,s.phone,s.fax,s.mobile,s.zip,s.plants,s.countrysList  from StorageLocation s";

		}

		if (!storage.equalsIgnoreCase("ALL")) {
			hql = "select s.storageLocationId ,s.storageLocation,s.add1,s.add2,s.add3,s.city,s.state,s.phone,s.fax,s.mobile,s.zip,s.plants,s.countrysList  from StorageLocation s where "
					+ storage;

		}

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

	@Override
	public List<Object[]> setStorageSearch(String plant) {
		String hql = null;
		if (plant.equalsIgnoreCase("ALL")) {
			hql = "select s.storageLocationId ,s.storageLocation,s.add1,s.add2,s.add3,s.city,s.state,s.phone,s.fax,s.mobile,s.zip,s.plants,s.countrysList  from StorageLocation s";

		}
		if (!plant.equalsIgnoreCase("ALL")) {
			hql = "select s.storageLocationId ,s.storageLocation,s.add1,s.add2,s.add3,s.city,s.state,s.phone,s.fax,s.mobile,s.zip,s.plants,s.countrysList  from StorageLocation s where+"
					+ plant + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

}
