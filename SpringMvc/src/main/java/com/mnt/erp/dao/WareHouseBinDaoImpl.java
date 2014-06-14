package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Warehousebin;
import com.mnt.erp.service.AuditLogService;

public class WareHouseBinDaoImpl extends HibernateDaoSupport implements WareHouseBinDao  {
	String msg;
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	@Override
	public String saveWareHouseBin(Object object, String userId, String userName) {
		try {
			Warehousebin whbbean = (Warehousebin) object;
			Serializable id = getHibernateTemplate().save(whbbean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Ware House Bin",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}

		return msg;

	}

	@Override
	public List<Object[]> searchWareHouseBinWithId(int id) {
		try {
			String hql1 = "select ag.warehousebinId,ag.storagetypeId,ag.whbtypeid,ag.whbno,ag.whbname,ag.storagesectionId from Warehousebin ag where ag.warehousebinId="
					+ id + "";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchWareHouseBin() {
		try {
			String hql = "select ag.warehousebinId,ag.storagebean,ag.whbtypebean,ag.whbno,ag.whbname,ag.storagesectionbean from Warehousebin ag order by ag.whbname";
			list = getHibernateTemplate().find(hql);

		    } catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectWareHouseBinIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> selectstoragetype() {
		try {
			String hql = "select p.storagetypeId,p.storagetype from StorageType p";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectWareHouseBinTypeIds() {
		try {
			String hql = "select w.warehousebintypeId,w.warehousebintype from WarehouseBinType w";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectStorageSectionIds() {
		try {
			String hql = "select s.storageSectionId,s.storageSection from StorageSectionBean s";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateWareHouseBin(Object object) {
		try {
			Warehousebin wrbBean = (Warehousebin) object;
			getHibernateTemplate().update(wrbBean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteWareHouseBin(int id) {
		try {
			Warehousebin whbean = new Warehousebin();
			whbean.setWarehousebinId(id);
			getHibernateTemplate().delete(whbean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getWareHouseBinCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long geWareHouseBinedit(String name, int whbid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchWareHouseBin(String label,
			String operator, String searchName) {
		try {

			String hql = "select ag.warehousebinId,ag.storagebean,ag.whbtypebean,ag.whbno,ag.whbname,ag.storagesectionbean from Warehousebin ag where ag."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
