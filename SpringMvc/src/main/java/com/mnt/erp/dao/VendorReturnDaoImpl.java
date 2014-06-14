/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ReasonForRejection;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VendorReturn;
import com.mnt.erp.bean.VendorReturnLine;

/**
 * @author Sailaja
 * @version 1.0 20-11-2013
 * @build 0.0
 */
public class VendorReturnDaoImpl extends HibernateDaoSupport implements
		VendorReturnDao {
	String msg = null;
	List<Object[]> obj = null;

	@Override
	public List<Object[]> getPurchaseOrderIds() {
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select p.purchaseOrderId , p.purchaseOrderNo from PurchaseOrder p";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public String addVendorReturn(Object object) {
		// TODO Auto-generated method stub
		try {

			VendorReturn vr = (VendorReturn) object;
			getHibernateTemplate().save(vr);

			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public List<Object> searchVendorReturn() {
		List<Object> object = null;

		String qry = "from  VendorReturn vr";
		object = getHibernateTemplate().find(qry);

		return object;
	}

	@Override
	public List<Object> searchVendorReturnWithId(int id) {
		// TODO Auto-generated method stub
		List<Object> object = null;

		String qry = " from VendorReturn vr  where vr.vendorReturnId=" + id
				+ "";
		object = getHibernateTemplate().find(qry);

		return object;
	}

	@Override
	public List<Object> vendorReturnAdvanceSearch(String vendorReturn) {
		// TODO Auto-generated method stub
		String hql = null;
		if (vendorReturn.equalsIgnoreCase("ALL")) {

			hql = "from VendorReturn";

		}

		if (!vendorReturn.equalsIgnoreCase("ALL")) {

			hql = " from VendorReturn vr where " + vendorReturn;

		}

		List<Object> list = getHibernateTemplate().find(hql);

		return list;
	}

	@Override
	public List<Object> setVendorReturnSearch(String vendorReturn) {
		// TODO Auto-generated method stub
		String hql = null;
		if (vendorReturn.equalsIgnoreCase("ALL")) {
			hql = " from VendorReturn";

		}

		if (!vendorReturn.equalsIgnoreCase("ALL")) {
			hql = " from VendorReturn where " + vendorReturn;

		}
		List<Object> list = getHibernateTemplate().find(hql);

		return list;
	}

	@Override
	public List<Object> basicSearchVendorReturn(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object> obj = null;
		try {

			String hql = "from VendorReturn vr where vr." + label + ""
					+ operator + " ? ";

			Object[] parameters = { searchName };
			obj = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String deleteVendorReturn(int id) {
		// TODO Auto-generated method stub
		try {

			VendorReturn deleteVr = getHibernateTemplate().get(
					VendorReturn.class, id);
			getHibernateTemplate().delete(deleteVr);
			return "Deleted";
		} catch (Exception e) {
			e.printStackTrace();
			return "Not Deleted";

		}

	}

	@Override
	public List<Object> editVendorReturnWithId(int vrid) {
		// TODO Auto-generated method stub
		List<Object> objs = null;
		try {
			String hql = "from VendorReturn vr where vr.vendorReturnId=" + vrid
					+ " ";
			objs = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public String updateVendorReturn(Object object) {
		// TODO Auto-generated method stub
		Iterator<VendorReturnLine> iterator = null;
		try {
			VendorReturn vr = (VendorReturn) object;
			VendorReturn vr1 = (VendorReturn) getHibernateTemplate().get(
					VendorReturn.class, vr.getVendorReturnIdEditt());
			List<VendorReturnLine> list = vr1.getVendorReturnLine();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object o = (Object) iterator.next();
				VendorReturnLine vrLine = (VendorReturnLine) o;
				vrLine.setMaterialDetails(new Material());
				vrLine.setUomDetails(new Uom());
				vrLine.setRfrDetails(new ReasonForRejection());
				vrLine.setStorageDetails(new StorageLocation());

				vrLine.setVendorReturnLineId(vrLine.getVendorReturnLineId());
				getHibernateTemplate().delete(vrLine);

			}

			getHibernateTemplate().update(vr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Vendor Return Details Updated Successfully";
	}

	@Override
	public int checkDuplicate(String checkVrNo) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from VendorReturn vr where vr.vendorReturnNo='"
					+ checkVrNo + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
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
	public int checkEditDuplicate(String checkVrNo, int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from VendorReturn vr where vr.vendorReturnNo='"
					+ checkVrNo + "' and vr.vendorReturnId!='" + id + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
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
	public String deleteVendorReturnLine(int kk) {
		// TODO Auto-generated method stub
		try {
			VendorReturnLine line = new VendorReturnLine();

			line.setVendorReturnLineId(kk);

			line.setMaterialDetails(new Material());

			line.setUomDetails(new Uom());
			line.setRfrDetails(new ReasonForRejection());
			line.setStorageDetails(new StorageLocation());

			getHibernateTemplate().delete(line);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Vendor Return Details Deleted Successfully";
	}

	@Override
	public List<Object[]> getRejQty(int poId, int grId, String mtId, String bNo) {
		List<Object[]> ob = null;
		try {
			String sql = "select grl.qtyRejected,grl.qtyReturned from GoodsReceiptLine grl where  grl.goodsReceipt_Id="
					+ grId
					+ " and grl.material_Id='"
					+ mtId
					+ "' and grl.batchNo='" + bNo + "' ";

			ob = getHibernateTemplate().find(sql);

			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return ob;
	}

	public boolean updateGRLQtyReturns(final int grId, final String matId,
			final String bNo, final float returnQty) {

		try {
			getHibernateTemplate().executeFind(new HibernateCallback() {
				Object obj;

				@Override
				public Object doInHibernate(org.hibernate.Session ses)
						throws HibernateException, SQLException {
					Query query = ses
							.createQuery("update GoodsReceiptLine set qtyReturned=? where goodsReceipt_Id=? and material_Id=? and batchNo=?");
					query.setParameter(0, returnQty);
					query.setParameter(1, grId);
					query.setParameter(2, matId);
					query.setParameter(3, bNo);
					query.executeUpdate();

					return obj;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean updateGRLQtys(final int grId, final String matId,
			final String bNo, final float retQty,final float rejQty) {

		try {
			getHibernateTemplate().executeFind(new HibernateCallback() {
				Object obj;

				@Override
				public Object doInHibernate(org.hibernate.Session ses)
						throws HibernateException, SQLException {
					Query query = ses
							.createQuery("update GoodsReceiptLine set qtyReturned=?,qtyRejected=? where goodsReceipt_Id=? and material_Id=? and batchNo=?");
					query.setParameter(0, retQty);
					query.setParameter(1, rejQty);
					query.setParameter(2, grId);
					query.setParameter(3, matId);
					query.setParameter(4, bNo);
					query.executeUpdate();

					return obj;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
