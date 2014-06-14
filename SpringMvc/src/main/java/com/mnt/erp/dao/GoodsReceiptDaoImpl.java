package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.GoodsReceipt;
import com.mnt.erp.bean.GoodsReceiptLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;


public class GoodsReceiptDaoImpl extends HibernateDaoSupport implements
		GoodsReceiptDao {

	@Autowired
	AuditLogService auditLogService;
	String msg;
	public String saveGoodsReceipt(Object object,String userId,String userName) {

		try {
			
			GoodsReceipt gr = (GoodsReceipt) object;
			
			Serializable id=getHibernateTemplate().save(gr);
			System.out.println("the id is:"+id);

			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Goods Receipt",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	public List<GoodsReceipt> searchGoodsReceipt() {

		List<GoodsReceipt> objects = null;
		try {
			String hql = "from GoodsReceipt";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> editGoodsReceipWithId(int prid) {
		List<Object> objs = null;
		try {
			String hql = "from GoodsReceipt p where p.goodsReceipt_Id=" + prid
					+ " ";
			objs = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	public String updateGoodsReceipt(Object object) {
		GoodsReceiptLine pc = null;
		Iterator<GoodsReceiptLine> iterator1 = null;
		GoodsReceiptLine goodsReceiptLine = null;
		List<GoodsReceiptLine> list2 = null;
		try {

			GoodsReceipt pg = (GoodsReceipt) object;

			int id = pg.getGoodsReceipt_Id();

			GoodsReceipt po = (GoodsReceipt) getHibernateTemplate().get(
					GoodsReceipt.class, id);
			list2 = po.getGoodsReceiptLine();

			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				goodsReceiptLine = (GoodsReceiptLine) o;
				pc = new GoodsReceiptLine();
				pc.setGoodsReceiptLine_Id(goodsReceiptLine
						.getGoodsReceiptLine_Id());
				getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
			msg="S";
		} catch (Exception e) {
			msg="S";
			//e.printStackTrace();
		}
		return msg;
	}

	public String deleteGoodsReceipt(int id) {
		try {
	
			GoodsReceipt delGoodsReceipt = new GoodsReceipt();
			delGoodsReceipt.setGoodsReceipt_Id(id);
			GoodsReceipt deleteSales = getHibernateTemplate().get(
					GoodsReceipt.class, id);
			for (GoodsReceiptLine cbDelete : deleteSales
					.getGoodsReceiptLine()) {
		
				cbDelete.setMaterialDetails(new Material());
				cbDelete.setUomDetails(new Uom());
				cbDelete.setQtylUomDetails(new Uom());
				cbDelete.setQtywUomDetails(new Uom());
				cbDelete.setStoragelocDetails(new StorageLocation());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().delete(delGoodsReceipt);
			msg = "S";
            
			
	}
		 catch (Exception e) {

				msg = "F";
				e.printStackTrace();

			}
			return msg;
	}
	public int goodsReceiptDuplicate(String receivingID) {
		Long count = null;
		try {
			final String hql = "select count(*) from GoodsReceipt g where g.receivingID='"
					+ receivingID + "'";

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

	public int goodsReceiptEditDuplicate(String receivingId, int id) {
		Long count = null;
		try {
			final String hql = "select count(*) from GoodsReceipt g where g.receivingID='"
					+ receivingId + "' and g.goodsReceipt_Id!='" + id + "'";

			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
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

	public List<GoodsReceipt> basicSearchGoodsReceipt(String label, String operator,
			String searchName) {
		List<GoodsReceipt> list = null;
		try {

			String hql = "from GoodsReceipt p where p." + label + "" + operator
					+ " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteGoodsReceiptLine(int kk){
		// TODO Auto-generated method stub
		try {
			System.out.println("KK===="+kk);
			GoodsReceiptLine line=new GoodsReceiptLine();
			line.setGoodsReceiptLine_Id(kk);
			
			line.setMaterialDetails(new Material());
			line.setStatusDetails(new Status());
			line.setUomDetails(new Uom());
			line.setQtylUomDetails(new Uom());
			line.setQtywUomDetails(new Uom());
			
			getHibernateTemplate().delete(line);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Goods Receipt Line Deleted Successfully";
	}
	@Override
	public List<Object> goodsAdvanceSearch(String goods) {
		// TODO Auto-generated method stub
		String hql=null;
		if(goods.equalsIgnoreCase("ALL"))
		{
			hql="from GoodsReceipt";
	 
		}
		
		if(!goods.equalsIgnoreCase("ALL"))
		{	
		hql="from GoodsReceipt g where"+goods;
		System.out.println("the hql is:"+hql);
		
		}
		
	 List<Object> list=getHibernateTemplate().find(hql);
	
			return list;	
	}
	@Override
	public List<Object> setGoodsSearch(String goods) {
		String hql = null;
		if(goods.equalsIgnoreCase("ALL"))
		{
			hql="from GoodsReceipt";
	 
		}
		
		if(!goods.equalsIgnoreCase("ALL"))
		{	
		hql="from GoodsReceipt g where"+goods;
		System.out.println("the hql is:"+hql);
		
		}
		List<Object> list = getHibernateTemplate().find(hql);

		return list;

	}
	public List<Object> purchaseOrderMaterialGet(String poNum,int materilId){
		List<Object> objects=null;
		try{
		String hql="select pl.quantity from PurchaseOrderLine pl,PurchaseOrder po where pl.materialId=" + materilId + " and po.purchaseOrderNo='" + poNum + "' and po.purchaseOrderId=pl.purchaseOrderId";
		objects=getHibernateTemplate().find(hql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object> goodsReceiptLineMaterialQtyGet(String poNum,int materilId){
		List<Object> objects=null;
		try{
		String hql="select SUM(gl.receivedQty) from GoodsReceiptLine gl,GoodsReceipt gr where gl.material_Id=" + materilId + " and gr.goodsReceiptTypeNum='" + poNum + "' and gr.goodsReceipt_Id=gl.goodsReceipt_Id";
		objects=getHibernateTemplate().find(hql);
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
}
