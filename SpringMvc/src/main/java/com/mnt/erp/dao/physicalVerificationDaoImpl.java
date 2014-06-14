/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.physicalVerification;

/**
 * @author kirangangone
 * 
 */
public class physicalVerificationDaoImpl extends HibernateDaoSupport implements
		physicalVerificationDao {

	String msg;

	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;

	@Override
	public List<Object> addPhysicalVerification(Object object) {
		// TODO Auto-generated method stub
		try {

			physicalVerification pv = (physicalVerification) object;
			Serializable id = getHibernateTemplate().save(pv);
			String hql = "from physicalVerification po where po.verificationId="
					+ id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
			obj = null;
			return obj;
		}
		return obj;
	}

	public List<Object[]> basicSearchPV() {
		try {

			String hql = "select po.verificationId,po.verificationNo,po.orgDetails,po.plantDetails"
					+ ",po.storageLocDetails,po.verificationDate,po.verificationTypeId,po.verfTypeDetails from physicalVerification po";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> editPVWithId(int Id) {
		try {

			String hql = "from physicalVerification po where po.verificationId="
					+ Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List<Object[]> basicSearchPhysicalVerification(String label,
			String operator, String searchName) {
		List<Object[]> objs = null;
		try {

			String hql = "select po.verificationId,po.verificationNo,po.orgDetails,po.plantDetails"
					+ ",po.storageLocDetails,po.verificationDate,po.verificationTypeId,po.verfTypeDetails from physicalVerification po where po."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Object[]> setPhysicalVerificationAdvanceSearch(String purchase) {
		String hql = null;
		hql = "select po.verificationId,po.verificationNo,po.orgDetails,po.plantDetails"
				+ ",po.storageLocDetails,po.verificationDate,po.verificationTypeId,po.verfTypeDetails from physicalVerification po  where "
				+ purchase;

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public String updatePhysicalVerificationDao(Object object) {

		try {
			physicalVerification physicalVerificationUp = (physicalVerification) object;

			getHibernateTemplate().update(physicalVerificationUp);

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "Updated";
	}

	public int updateCheckPhysicalVerification(String custName, int custId) {
		try {
			String sql = "select count(*) from physicalVerification cb where  cb.verificationNo='"
					+ custName + "' and cb.verificationId!='" + custId + "'";
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l.intValue();

	}

	public Long checkPhysicalVerification(String pno) {

		try {
			String sql = "select count(*) from physicalVerification cb where  cb.verificationNo='"
					+ pno + "'";
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

	public String deletePhysicalVerificationLine(int id) {
		String message = null;
		com.mnt.erp.bean.physicalVerificationLine physicalVerificationLine = null;
		try {
			physicalVerificationLine = (com.mnt.erp.bean.physicalVerificationLine) getHibernateTemplate()
					.get(com.mnt.erp.bean.physicalVerificationLine.class, id);
			physicalVerificationLine.setMaterialDetails(new Material());
			physicalVerificationLine.setUomDetails(new Uom());
			getHibernateTemplate().delete(physicalVerificationLine);

			message = "Physical Verification Line Deleted Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			message = "Sorry Cant be Deleted";
		}
		return message;
	}

	@Override
	public List<Object[]> uomIdGet() {
		// TODO Auto-generated method stub
		String hql = "select u.uom_Id,u.uom from Uom u";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	@Override
	public List<Object[]> materialIdGet() {
		// TODO Auto-generated method stub
		String hql = "select m.material_Id,m.materialName from Material m";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	@Override
	public List<Object[]> verificationTypeIdSelect() {
		// TODO Auto-generated method stub
		String hql = "select m.verificationtypeid,m.verificationtype from VerificationtypeBean m";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	@Override
	public List<Object[]> orgIdSelect() {
		// TODO Auto-generated method stub
		String hql = "select m.orgId,m.orgName from Organization m";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	@Override
	public List<Object[]> plantIdSelect() {
		// TODO Auto-generated method stub
		String hql = "select m.plantId,m.plantName from Plant m";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	@Override
	public List<Object[]> storageLocationIdSelect() {
		// TODO Auto-generated method stub
		String hql = "select m.storageLocationId,m.storageLocation from StorageLocation m";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	public List<Object[]> getplantIdForOrg(String org) {
		// TODO Auto-generated method stub
		String hql = "select m.plantId,m.plantName from Plant m where m.orgId='"
				+ org + "'";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	public List<Object[]> getLocationIdForOrg(String plant) {
		// TODO Auto-generated method stub
		String hql = "select m.storageLocationId,m.storageLocation from StorageLocation m where m.plantId='"
				+ plant + "'";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	public List<Object[]> getGoodsIdForOrg(String goods) {
		// TODO Auto-generated method stub
		String hql = "select ms.materialId,ms.batchNo,ms.materialsDetails,ms.qtyAval,m.uomDetails,m.uom from MatStockBean ms,Material m  where ms.materialId=m.material_Id and ms.storLocId='"
				+ goods + "'";
		List<Object[]> listValues = getHibernateTemplate().find(hql);
		return listValues;
	}

	public Double getTotalReceviedGood(String goods, String materialId) {
		List<Object> list = null;
		Iterator<Object> it = null;
		Double count = null;
		try {

			String hql = "select sum(m.receivedQty) from GoodsReceiptLine m where m.material_Id='"
					+ materialId + "' AND m.batchNo='" + goods + "'";
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Double) object;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

}
