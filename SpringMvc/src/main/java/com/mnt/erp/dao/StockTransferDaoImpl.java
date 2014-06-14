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
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.StockTransferBean;
import com.mnt.erp.bean.StockTransferLineBean;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;

/**
 * @author Naresh
 * @version 1.0 29-11-2013
 */
public class StockTransferDaoImpl extends HibernateDaoSupport implements
		StockTransferDao {

	String success;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	boolean flag = false;

	@Override
	public List<Object[]> selectOrgIds() {
		try {
			String sql = "select org.orgId,org.orgName from Organization org";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPlantIds(int orgId) {
		try {
			String sql = "select p.plantId,p.plantName from Plant p where p.orgId="
					+ orgId;
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateStorLocIds(int plantId) {
		try {
			String sql = "select s.storageLocationId,s.storageLocation from StorageLocation s where s.plantId="
					+ plantId;
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public int updateCheckStockTransfer(String salesNo, int siId) {
		try {
			String sql = "select count(*) from StockTransferBean sb where  sb.stockTransferNo='"
					+ salesNo + "' and sb.stockTransferId!='" + siId + "'";
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

	@Override
	public Long checkStockTransfer(String salesNo) {
		try {
			String sql = "select count(*) from StockTransferBean sb where  sb.stockTransferNo='"
					+ salesNo + "'";
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
	public String saveStockTransfer(Object object) {
		String msg="S";
		try {
			StockTransferBean stockTransBean = (StockTransferBean) object;
			getHibernateTemplate().save(stockTransBean);

		} catch (Exception e) {
			e.printStackTrace();
			msg="F";
		}
		return msg;
	}

	@Override
	public List<Object[]> searchStockTransfer() {
		try {
			String hql = "select cb.stockTransferId,cb.stockTransferNo,cb.stockTransferDate,cb.orgId,cb.plantId,cb.storageLocationId,cb.orgBean,cb.plantBean,cb.storLocBean from StockTransferBean cb order by cb.stockTransferNo";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchStockTransferWithId(int sId) {
		try {
			String hql = "from StockTransferBean st where st.stockTransferId="
					+ sId;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateStockTransfer(Object object) {
		try {
			StockTransferBean salesBeanUp = (StockTransferBean) object;
			StockTransferBean sBean = (StockTransferBean) getHibernateTemplate()
					.get(StockTransferBean.class,
							salesBeanUp.getStockTransferId());
			for (StockTransferLineBean cbDelete : sBean.getStockTransferLine()) {
				cbDelete.setMaterial(new Material());
				cbDelete.setUom(new Uom());
				// cbDelete.setStorLoc(new StorageLocation());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().update(salesBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Updated";
	}

	@Override
	public String deleteStockTransfer(int cId) {
		String msg = null;

		try {
			StockTransferBean delStock = new StockTransferBean();
			delStock.setStockTransferId(cId);
			StockTransferBean deleteStock = getHibernateTemplate().get(
					StockTransferBean.class, cId);
			deleteStock.setOrgBean(new Organization());
			deleteStock.setPlantBean(new Plant());
			deleteStock.setStorLocBean(new StorageLocation());
			for (StockTransferLineBean cbDelete : deleteStock
					.getStockTransferLine()) {
				cbDelete.setMaterial(new Material());
				cbDelete.setUom(new Uom());
				// cbDelete.setStorLoc(new StorageLocation());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().delete(delStock);
			msg = "Deleted";

		} catch (Exception e) {

			msg = "NotDeleted";
			e.printStackTrace();

		}
		return msg;
	}

	@Override
	public List<Object[]> basicSearchStockTransfer(String label,
			String operator, String searchName) {
		try {

			String hql = "select cb.stockTransferId,cb.stockTransferNo,cb.stockTransferDate,cb.orgId,cb.plantId,cb.storageLocationId,cb.orgBean,cb.plantBean,cb.storLocBean from StockTransferBean cb where cb."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateUOMIds() {
		try {
			String sql = "select u.uom_Id,u.uom from Uom u";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateMaterialIds(int storLocId) {
		List<Object[]> objects = null;
		try {
			String sql = "select m.material_Id,m.materialName from Material m,MatStockBean mt where m.material_Id=mt.materialId and mt.storLocId="
					+ storLocId + "";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateStorLocIds() {
		try {
			String sql = "select s.storageLocationId,s.storageLocation from StorageLocation s";

			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPlantIds() {
		try {
			String sql = "select p.plantId,p.plantName from Plant p";

			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteStockTransferLine(int sId) {
		try {
			StockTransferLineBean stockLine = (StockTransferLineBean) getHibernateTemplate()
					.get(StockTransferLineBean.class, sId);
			stockLine.setMaterial(new Material());
			stockLine.setUom(new Uom());
			// stockLine.setStorLoc(new StorageLocation());
			getHibernateTemplate().delete(stockLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";
	}

	@Override
	public List<Object[]> getBatchNOs(int materialId, String slId) {
		try {
			String hql = "select distinct gr.batchNo,gr.materialId from MatStockBean gr where gr.materialId='"
					+ materialId + "' and storLocId='" + Integer.parseInt(slId) + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<MatStockBean> getAvlQty(int matId, int stlId, String batchId) {
		List<MatStockBean> mtStock = null;
		try {
			String hql = "from MatStockBean st where st.materialId='" + matId
					+ "' and st.storLocId='" + stlId + "' and st.batchNo='"
					+ batchId + "'";
			mtStock = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
			mtStock = null;
		}
		return mtStock;
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
	public List<Object[]> selectBatchNos() {
		try {
			String sql = "select distinct gr.batchNo,gr.material_Id from GoodsReceiptLine gr";

			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public boolean updateMatStock(final float qty, final int mtId,
			final int slId, final String bNo) {

		try {

			getHibernateTemplate().execute(new HibernateCallback<Object>() {
				Object obj = null;

				public Object doInHibernate(Session sesssion)
						throws HibernateException, SQLException {
					String hql = "update MatStockBean set qtyAval=? where materialId=? and storLocId=? and batchNo=?";
					Query query = sesssion.createQuery(hql);
					query.setParameter(0, qty);
					query.setParameter(1, mtId);
					query.setParameter(2, slId);
					query.setParameter(3, bNo);
					query.executeUpdate();
					return obj;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Object[]> advSearchStockTransfer(String search) {
		String hql = null;
		
		if (!search.equalsIgnoreCase("ALL")) {
			hql = "select cb.stockTransferId,cb.stockTransferNo,cb.stockTransferDate,cb.orgId,cb.plantId,cb.storageLocationId,cb.orgBean,cb.plantBean,cb.storLocBean from StockTransferBean cb where cb."
					+ search + " order by cb.stockTransferNo";

		}
		else {
			hql = "select cb.stockTransferId,cb.stockTransferNo,cb.stockTransferDate,cb.orgId,cb.plantId,cb.storageLocationId,cb.orgBean,cb.plantBean,cb.storLocBean from StockTransferBean cb order by cb.stockTransferNo";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
