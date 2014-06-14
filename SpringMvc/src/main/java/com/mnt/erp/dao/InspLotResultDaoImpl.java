/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.GoodsReceiptLine;
import com.mnt.erp.bean.InspLotResultBean;
import com.mnt.erp.bean.InspectionLotBean;
import com.mnt.erp.bean.MatStockBean;

/**
 * @author Naresh
 * @version 1.0 10-01-2014
 */
public class InspLotResultDaoImpl extends HibernateDaoSupport implements
		InspLotResultDao {

	boolean flag = true;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public boolean saveInspLotResultDetails(Object object) {
		try {
			InspLotResultBean inspLotBean = (InspLotResultBean) object;
			getHibernateTemplate().save(inspLotBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchInspLotResult() {
		try {
			String hql = "select dn.inspLotResultId,dn.inspLotNoId,dn.startDate,dn.endDate,dn.inspected,dn.accepted,dn.nonConf,dn.mean,dn.stdValue,dn.skip,dn.inspLotBean,dn.inspDecision from InspLotResultBean dn order by dn.inspLotNoId";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchInspLotResultWithId(int inspId) {
		try {
			String hql = "from InspLotResultBean dn where dn.inspLotResultId='"
					+ inspId + "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateInspLotResult(Object object) {
		try {
			InspLotResultBean debitBeanUp = (InspLotResultBean) object;
			getHibernateTemplate().update(debitBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspLotResult(int inspId) {
		try {
			InspLotResultBean dnb = new InspLotResultBean();
			dnb.setInspLotResultId(inspId);
			dnb.setInspLotBean(new InspectionLotBean());
			getHibernateTemplate().delete(dnb);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchInspLotResult(String label,
			String operator, String searchName) {
		try {
			String hql = "select dn.inspLotResultId,dn.inspLotNoId,dn.startDate,dn.endDate,dn.inspected,dn.accepted,dn.nonConf,dn.mean,dn.stdValue,dn.skip,dn.inspLotBean,dn.inspDecision from InspLotResultBean dn where dn."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public boolean getLotQty(int inspId, float inspected) {
		String s = null;
		float i = 0;
		try {
			String hql = "select dn.quantity from InspectionLotBean dn where  dn.inspLotNoId='"
					+ inspId + "'";
			obj = getHibernateTemplate().find(hql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				s = (String) object;
				i = Float.parseFloat(s);

			}
			if (inspected == i) {
				flag = true;

			} else {
				flag = false;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Object> getMaterialId(int inspid) {
		List<Object> listBean = new ArrayList<Object>();
		try {
			String hql = "from InspectionLotBean dn where dn.inspLotNoId='"
					+ inspid + "'";

			obj = getHibernateTemplate().find(hql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				InspectionLotBean lot = (InspectionLotBean) object;
				listBean.add(lot);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listBean;
	}

	@Override
	public boolean updateMaterial(final float stock, final int matId) {
		try {
			getHibernateTemplate().executeFind(new HibernateCallback() {
				List<Object> obj = null;

				@Override
				public Object doInHibernate(org.hibernate.Session session)
						throws HibernateException, SQLException {
					String hql = "update Material  set stock=" + stock
							+ " where  material_Id=" + matId + "";
					Query query = session.createQuery(hql);
					query.executeUpdate();

					return obj;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public float getStock(int materalId) {
		float stock = 0;
		try {
			String hql = "select m.stock from Material m where m.material_Id='"
					+ materalId + "'";

			obj = getHibernateTemplate().find(hql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				stock = (Integer) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stock;
	}

	public List<Object> getGoodsQty(int matId, String batchNo) {
		List<Object> goodsList = new ArrayList<Object>();
		try {
			String hql = "from GoodsReceiptLine gr where gr.material_Id='"
					+ matId + "' and gr.batchNo='" + batchNo + "'";
			// Object[] parameters = { matId, batchNo };
			obj = getHibernateTemplate().find(hql);
			iterator = obj.iterator();
			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				GoodsReceiptLine grl = (GoodsReceiptLine) object;
				goodsList.add(grl);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return goodsList;

	}

	@Override
	public boolean updateGoodsReceiptLine(final float totQtyInsp,
			final float totQtyAcp, final float totQtyRej, final int matId,
			final String batchNo) {
		try {
			getHibernateTemplate().executeFind(new HibernateCallback() {
				Object obj = null;

				@Override
				public Object doInHibernate(org.hibernate.Session sess)
						throws HibernateException, SQLException {
					String hql = "update GoodsReceiptLine set qtyInspected=?,qtyAccepted=?,qtyRejected=? where material_Id=? and batchNo=?";
					Query query = sess.createQuery(hql);
					query.setFloat(0, totQtyInsp);
					query.setFloat(1, totQtyAcp);
					query.setFloat(2, totQtyRej);
					query.setInteger(3, matId);
					query.setString(4, batchNo);
					query.executeUpdate();
					return obj;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdateMatStock(Object object) {
		try {
			MatStockBean stockBeanUp = (MatStockBean) object;
			getHibernateTemplate().saveOrUpdate(stockBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<MatStockBean> getMatStock(int mtId, int slId, String bNo) {
		List<MatStockBean> matStock = null;
		try {
			String hql = "from MatStockBean gr where gr.materialId='" + mtId
					+ "' and gr.batchNo='" + bNo + "' and gr.storLocId='"
					+ slId + "'";
			obj = getHibernateTemplate().find(hql);
			if (!obj.isEmpty()) {
				matStock = new ArrayList<MatStockBean>();
				iterator = obj.iterator();
				while (iterator.hasNext()) {
					Object objec = (Object) iterator.next();
					MatStockBean mb = (MatStockBean) objec;
					matStock.add(mb);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return matStock;
	}

	@Override
	public List<Object[]> advSearchInspLotResult(String advSearch) {
		String hql = null;
		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select dn.inspLotResultId,dn.inspLotNoId,dn.startDate,dn.endDate,dn.inspected,dn.accepted,dn.nonConf,dn.mean,dn.stdValue,dn.skip,dn.inspLotBean,dn.inspDecision from InspLotResultBean dn where dn."
					+ advSearch + " order by dn.inspLotNoId";

		} else {
			hql = "select dn.inspLotResultId,dn.inspLotNoId,dn.startDate,dn.endDate,dn.inspected,dn.accepted,dn.nonConf,dn.mean,dn.stdValue,dn.skip,dn.inspLotBean,dn.inspDecision from InspLotResultBean dn order by dn.inspLotNoId";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
