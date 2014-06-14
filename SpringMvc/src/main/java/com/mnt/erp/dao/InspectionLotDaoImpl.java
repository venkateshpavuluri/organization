/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.GoodsReceiptLine;
import com.mnt.erp.bean.InspLotEqpBean;
import com.mnt.erp.bean.InspectionLotBean;
import com.mnt.erp.bean.InspectionType;
import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.Uom;

/**
 * @author Naresh
 * @version 1.0 07-01-2014
 */
public class InspectionLotDaoImpl extends HibernateDaoSupport implements
		InspectionLotDao {

	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public Long updateCheckInspectionLot(String inspNo, int inspId) {
		try {
			String sql = "select count(*) from InspectionLotBean db where  db.inspLotNo='"
					+ inspNo + "' and db.inspLotNoId!='" + inspId + "'";
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Long checkInspectionLotCout(String inspNo) {
		try {
			String sql = "select count(*) from InspectionLotBean dn where  dn.inspLotNo='"
					+ inspNo + "'";
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean saveInspectionLotDetails(Object object) {
		try {
			InspectionLotBean inspLotBean = (InspectionLotBean) object;
			getHibernateTemplate().save(inspLotBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchInspectionLot() {
		try {
			String hql = "select dn.inspLotNoId,dn.inspLotNo,dn.refNo,dn.quantity,dn.desc,dn.plant,dn.material,dn.uom,dn.inspType,dn.inspLotOrg,dn.status,dn.batchNo from InspectionLotBean dn order by dn.inspLotNo";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchInspectionLotWithId(int inspId) {
		try {
			String hql = "from InspectionLotBean dn where dn.inspLotNoId='"
					+ inspId + "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateInspectionLot(Object object) {
		try {
			InspectionLotBean debitBeanUp = (InspectionLotBean) object;
			InspectionLotBean delbean = getHibernateTemplate().get(
					InspectionLotBean.class, debitBeanUp.getInspLotNoId());
			for (InspLotEqpBean eqp : delbean.getInspLotEqpList()) {
				eqp.setEqpBean(new EquipmentBean());
				getHibernateTemplate().delete(eqp);
			}
			getHibernateTemplate().update(debitBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspectionLot(int inspId) {
		try {
			InspectionLotBean dnb = new InspectionLotBean();
			dnb.setInspLotNoId(inspId);
			dnb.setMaterial(new Material());
			dnb.setPlant(new Plant());
			dnb.setUom(new Uom());
			dnb.setInspType(new InspectionType());
			dnb.setInspLotOrg(new InsplotOrigin());

			getHibernateTemplate().delete(dnb);

		} catch (DataIntegrityViolationException ee) {
			flag = false;

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchInspectionLot(String label,
			String operator, String searchName) {
		try {
			String hql = "select dn.inspLotNoId,dn.inspLotNo,dn.refNo,dn.quantity,dn.desc,dn.plant,dn.material,dn.uom,dn.inspType,dn.inspLotOrg,dn.status,dn.batchNo from InspectionLotBean dn where dn."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<GoodsReceiptLine> getAvlQty(int matId, String batchNo) {
		List<GoodsReceiptLine> grl = null;
		try {
			String hql = "from GoodsReceiptLine st where st.material_Id='"
					+ matId + "' and st.batchNo='" + batchNo + "'";
			grl = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return grl;
	}

	@Override
	public boolean deleteInspectionLotEqp(int inspEqpId) {
		try {
			InspLotEqpBean dnb = new InspLotEqpBean();
			dnb.setInspLotEqpId(inspEqpId);
			dnb.setEqpBean(new EquipmentBean());
			getHibernateTemplate().delete(dnb);
		} catch (DataIntegrityViolationException ee) {
			flag = false;

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public List<Object[]> advSearchInspectionLot(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select dn.inspLotNoId,dn.inspLotNo,dn.refNo,dn.quantity,dn.desc,dn.plant,dn.material,dn.uom,dn.inspType,dn.inspLotOrg,dn.status,dn.batchNo from InspectionLotBean dn where dn."
					+ advSearch + " order by dn.inspLotNo";

		} else {
			hql = "select dn.inspLotNoId,dn.inspLotNo,dn.refNo,dn.quantity,dn.desc,dn.plant,dn.material,dn.uom,dn.inspType,dn.inspLotOrg,dn.status,dn.batchNo from InspectionLotBean dn order by dn.inspLotNo";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}
}
