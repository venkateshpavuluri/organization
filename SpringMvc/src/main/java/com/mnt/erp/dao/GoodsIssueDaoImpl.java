/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.AuditLogDetail;
import com.mnt.erp.bean.GoodsIssue;
import com.mnt.erp.bean.GoodsIssueLine;
import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 * 
 * 
 */
public class GoodsIssueDaoImpl extends HibernateDaoSupport implements
		GoodsIssueDao {
	boolean flag = false;

	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;

	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveGoodsIssue(Object object) {
		String s = "S";
		try {

			GoodsIssue goodsIssue = (GoodsIssue) object;
			Serializable id = getHibernateTemplate().save(goodsIssue);

		} catch (Exception e) {
			e.printStackTrace();
			s = "F";
		}
		return s;
	}

	public List<Object> editGoodsIssueWithId(int Id) {
		try {
			String hql = "from GoodsIssue i where i.goodsIssueId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List<Object[]> basicSearchGoodsIssue(String label, String operator,
			String searchName, String advBasic) {
		List<Object[]> objs = null;
		String hql = null;
		try {

			if (label == "" && operator == "" && searchName == ""
					&& advBasic == "") {
				hql = "select i.goodsIssueId,i.goodsIssueNo,i.goodsIssueDate,i.deliveryNoteId,i.producionOrderId,i.postingDate,i.reasonForMovementId,i.reference,i.reasonForMovementDetails from GoodsIssue i ";
				objs = getHibernateTemplate().find(hql);
			} else if (label == "" && operator == "" && searchName == ""
					&& advBasic != "") {
				hql = "select i.goodsIssueId,i.goodsIssueNo,i.goodsIssueDate,i.deliveryNoteId,i.producionOrderId,i.postingDate,i.reasonForMovementId,i.reference,i.reasonForMovementDetails  from GoodsIssue i  where "
						+ advBasic;
				objs = getHibernateTemplate().find(hql);
			} else if (label != "" && operator != "" && searchName != ""
					&& advBasic == "") {
				hql = "select i.goodsIssueId,i.goodsIssueNo,i.goodsIssueDate,i.deliveryNoteId,i.producionOrderId,i.postingDate,i.reasonForMovementId,i.reference,i.reasonForMovementDetails  from GoodsIssue i where i."
						+ label + "" + operator + " ? ";
				Object[] parameters = { searchName };
				objs = getHibernateTemplate().find(hql, parameters);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public boolean updateGoodsIssue(Object object, AuditLog a, int alength) {

		try {
			GoodsIssue goodsIssue = (GoodsIssue) object;
			getHibernateTemplate().update(goodsIssue);
			getMaterialStockUpdate(goodsIssue.getGoodsIssueLineDetails(),
					"Edit", a, alength);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public int checkGoodsIssue(String checkValue, String id) {
		try {

			String sql = null;

			if (id == "") {
				sql = "select count(*) from GoodsIssue cb where  cb.goodsIssueNo='"
						+ checkValue + "'";
			} else {
				sql = "select count(*) from GoodsIssue cb where  cb.goodsIssueNo='"
						+ checkValue + "' and cb.goodsIssueId!='" + id + "'";
			}
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

	public boolean deleteGoodsIssue(int id, String mainOrSub) {

		try {

			if (mainOrSub.equalsIgnoreCase("Sub")) {

				com.mnt.erp.bean.GoodsIssueLine purchaseOrderLine = null;
				try {
					purchaseOrderLine = (com.mnt.erp.bean.GoodsIssueLine) getHibernateTemplate()
							.get(com.mnt.erp.bean.GoodsIssueLine.class, id);
					// purchaseOrderLine.setInspectionMethodBeanDetails(new
					// InspectionMethodBean());
					purchaseOrderLine.setMaterialDetails(new Material());
					purchaseOrderLine.setUomDetails(new Uom());
					purchaseOrderLine.setPlantDetails(new Plant());
					purchaseOrderLine
							.setStorageLocDetails(new StorageLocation());
					getHibernateTemplate().delete(purchaseOrderLine);
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
					return flag;
				}
				return flag;
			} else {
				com.mnt.erp.bean.GoodsIssue GoodsIssue = null;
				GoodsIssue = getHibernateTemplate().get(
						com.mnt.erp.bean.GoodsIssue.class, id);
				// GoodsIssue.setUomDetails(new Uom());
				// GoodsIssue.setPaymentDetails(new PaymentTerms());

				/*
				 * List<GoodsIssueMethod> GoodsIssueMethod =
				 * GoodsIssue.getGoodsIssueMethodGroupDetails();
				 * Iterator<GoodsIssueMethod> iter =
				 * GoodsIssueMethod.iterator(); while (iter.hasNext()) { Object
				 * o = iter.next(); GoodsIssueMethod GoodsIssueMethodDelete =
				 * (GoodsIssueMethod) o;
				 * GoodsIssueMethodDelete.setGoodsIssueMethodId
				 * (GoodsIssueMethodDelete.getGoodsIssueMethodId());
				 * getHibernateTemplate().delete(GoodsIssueMethodDelete); }
				 */
				getHibernateTemplate().delete(GoodsIssue);

				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public double getAvailableQuantity(String material, String batchNo,
			String storageLocation) {
		List<Object> list = null;
		Double sql = null;
		try {

			list = getHibernateTemplate().findByNamedQueryAndNamedParam(
					"availableQuantity",
					new String[] { "material", "batchNo", "storageLocation" },
					new Object[] { Integer.parseInt(material), batchNo,
							Integer.parseInt(storageLocation) });

			Iterator<Object> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object obj = (Object) iterator.next();
				MatStockBean mt = (MatStockBean) obj;
				System.out.println(mt.getQtyAval());
				sql = (double) mt.getQtyAval();

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}

	public void getMaterialStockUpdate(List<GoodsIssueLine> goodsIssueLineList,
			String type, AuditLog a, int alength) {
		int auditChanged = 0;
		java.util.Set<AuditLogDetail> auditLogDetailLine = new HashSet<AuditLogDetail>();
		// AuditLogServiceImpl auditLogServiceImpl=new AuditLogServiceImpl();
		AuditLog auditLog = (AuditLog) a;
		AuditLogDetail auditLogDetails = null;

		try {

			Iterator<GoodsIssueLine> tt = goodsIssueLineList.iterator();

			while (tt.hasNext()) {
				GoodsIssueLine objects = (GoodsIssueLine) tt.next();
				final int material = Integer.parseInt(objects.getMaterialId());
				double qty = Double.parseDouble(objects.getQty());
				double qtyAcc = Double.parseDouble(objects.getQtyAcc());
				int mode = 0;
				auditChanged++;
				auditLogDetails = new AuditLogDetail();
				auditLogDetails.setOldValue(objects.getQtyAcc());
				auditLogDetails.setNewValue(objects.getQty());
				auditLogDetailLine.add(auditLogDetails);

				if (type.equalsIgnoreCase("Add")) {
					final double stockDeductedOrAdded = qty - qtyAcc;
					mode = -1;

					try {
						getHibernateTemplate().executeFind(
								new HibernateCallback() {
									List<Object> obj = null;

									@Override
									public Object doInHibernate(
											org.hibernate.Session session)
											throws HibernateException,
											SQLException {
										String hql = "update Material  set stock=stock-"
												+ stockDeductedOrAdded
												+ " where  material_Id="
												+ material + "";
										Query query = session.createQuery(hql);
										query.executeUpdate();

										return obj;
									}

								});

					} catch (Exception e) {
						e.printStackTrace();
						flag = false;
					}
					// getHibernateTemplate().findByNamedQueryAndNamedParam("materialStockUpdate",new
					// String[]{"materialid","stockDeductedOrAdded","mode"}, new
					// Object[]{material,stockDeductedOrAdded,mode});
				}
				if (type.equalsIgnoreCase("Edit") && a != null) {

					if (alength == auditChanged) {
						auditLog.setAuditLogDetails(auditLogDetailLine);
						auditLogService.addAuditLog(auditLog);

					}
					final double stockDeductedOrAdded = qtyAcc - qty;
					if (stockDeductedOrAdded > 0) {
						mode = 1;// 1 For Add
					}
					if (stockDeductedOrAdded < 0) {
						mode = -1;// -1 For sub
					}
					if (stockDeductedOrAdded == 0) {
						mode = 0;// 1 For equal
					}
					if (mode == 1 || mode == -1) {
						try {
							getHibernateTemplate().executeFind(
									new HibernateCallback() {
										List<Object> obj = null;

										@Override
										public Object doInHibernate(
												org.hibernate.Session session)
												throws HibernateException,
												SQLException {
											String hql = "update Material  set stock=stock+"
													+ stockDeductedOrAdded
													+ " where  material_Id="
													+ material + "";
											Query query = session
													.createQuery(hql);
											query.executeUpdate();

											return obj;
										}

									});

						} catch (Exception e) {
							e.printStackTrace();
							flag = false;
						}
						// return flag;

						// getHibernateTemplate().findByNamedQueryAndNamedParam("materialStockUpdate",new
						// String[]{"materialid","stockDeductedOrAdded","mode"},
						// new Object[]{material,stockDeductedOrAdded,mode});
					}

				}
				// //System.out.println("deducted");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

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
	public boolean saveOrUpdateMatStock(Object object) {
		boolean flag = true;
		try {
			MatStockBean stockBeanUp = (MatStockBean) object;
			getHibernateTemplate().saveOrUpdate(stockBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
