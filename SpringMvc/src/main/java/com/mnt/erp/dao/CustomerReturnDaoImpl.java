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
import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.CustomerReturn;
import com.mnt.erp.bean.CustomerReturnLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.PurchaseReqLine;
import com.mnt.erp.bean.ReasonForRejection;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;

public class CustomerReturnDaoImpl extends HibernateDaoSupport implements CustomerReturnDao {
	@Autowired
	AuditLogService auditLogService;
	String msg;
	List<Object[]> objects = null;
	Iterator<Object[]>iterate=null;
	public List<Object[]> selectSalesOrders(){
		String sql=null;
		try
		{
		sql="select m.salesOrderId,m.salesOrderNo from SalesOrderBean m";
		objects=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			return objects;
	}
	public List<Object[]> selectMaterialIds(){
		String sql=null;
		try
		{
		sql="select m.material_Id,m.materialCode from Material m";
		objects=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			return objects;
	}
	public List<Object[]> selectReasonForRejection(){
		String sql=null;
		try
		{
		sql="select r.reasonForRejectionId,r.reasonForRejection from ReasonForRejection r";
		objects=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			return objects;
	}
	
	public String saveCustomerReturn(Object object,String userId,String userName){
		try {

			    Serializable id=getHibernateTemplate().save(object);
			    if (id != null) {

					Date date = new Date();
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(userId, "A", "Customer Return",
							"ROW", String.valueOf(id), "1", modifiedDate, userName);
					msg = "S";
				}
				
				

			} catch (Exception e) {
				msg="F";
				e.printStackTrace();
			}
			return msg;
	}
	public List<Object[]> searchCustomerReturn() {
		
		try {
			String hql = "select customerReturnId,customerReturnNo,customerReturnDate,reference,description,salesOrderBean from CustomerReturn";
			objects = getHibernateTemplate().find(hql);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchCustomerReturn(String label, String operator,
			String searchName) {
		try {

			String hql = "select c.customerReturnId,c.customerReturnNo,c.customerReturnDate,c.reference,c.description,c.salesOrderBean from CustomerReturn c where c."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deleteCustomerReturn(int id){
		
			// TODO Auto-generated method stub
			try {
				
				CustomerReturn customerReturn=new CustomerReturn();
				customerReturn.setCustomerReturnId(id);
				
				getHibernateTemplate().delete(customerReturn);
				msg="S";
			
			} catch (Exception e) {
				msg="F";
				//e.printStackTrace();
			}
			return msg;
		}
	  public List<Object> editCustomerReturnWithId(int id){
		  List<Object> obj=null;
	try {
		
		String hql = "from CustomerReturn c where c.customerReturnId=" + id
				+ " ";
		
		obj = getHibernateTemplate().find(hql);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return obj;
	  }
	  
	  public String updateCustomerReturn(Object object){
		  CustomerReturnLine pc = null;
			Iterator<CustomerReturnLine> iterator1 = null;
			CustomerReturnLine customerReturnLine = null;
			List<CustomerReturnLine> list2 = null;
			try {

				CustomerReturn pg = (CustomerReturn) object;
				int id = pg.getCustomerReturnIdEdit();
				

				CustomerReturn cr = (CustomerReturn) getHibernateTemplate().get(
						CustomerReturn.class, id);
				list2 = cr.getCustomerReturnLine();

				iterator1 = list2.iterator();
				while (iterator1.hasNext()) {
					Object o = (Object) iterator1.next();
					customerReturnLine = (CustomerReturnLine) o;
					pc = new CustomerReturnLine();
					pc.setCustomerReturnLineId(customerReturnLine.getCustomerReturnLineId());
					pc.setMaterial(new Material());
					pc.setUomDetails(new Uom());
					getHibernateTemplate().delete(pc);
				}

				getHibernateTemplate().update(pg);
				msg="S";
			} catch (Exception e) {
				msg="F";
				e.printStackTrace();
			}
			return msg;
	  }
	  
	  public int customerReturnDuplicate(String CRNo){
		  Long count = null;
			try {
				final String hql = "select count(*) from CustomerReturn a where a.customerReturnNo='"
						+ CRNo + "'";
				
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

	  public int customerReturnEditDuplicate(String CRNo,int id){
		  Long count = null;
			try {
				final String hql = "select count(*) from CustomerReturn a where a.customerReturnNo='"
						+ CRNo + "' and a.customerReturnId!='" + id + "'";
				
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
	  
	  public String deleteCustomerReturnLine(int kk){
		// TODO Auto-generated method stub
			try {
				
				CustomerReturnLine line=new CustomerReturnLine();
				
				line.setCustomerReturnLineId(kk);
				
				
				
				line.setMaterial(new Material());
				
				line.setUomDetails(new Uom());
				
				line.setReasonForRejectionDetails(new ReasonForRejection());
				
				line.setStorageLocationDetails(new StorageLocation());
				
				getHibernateTemplate().delete(line);
				msg="S";
				
			

			} catch (Exception e) {
				msg="F";
				e.printStackTrace();

			}
			return msg;
	  }
	  
	  public List<Object[]> getCustomerReturnAdvance(String name){
		  String hql=null;
			if(name.equalsIgnoreCase("ALL"))
			{
				
				hql="select customerReturnId,customerReturnNo,customerReturnDate,reference,description,salesOrderBean from CustomerReturn";
				
		  
			}
			
			if(!name.equalsIgnoreCase("ALL"))
			{	
			hql="select customerReturnId,customerReturnNo,customerReturnDate,reference,description,salesOrderBean from CustomerReturn where"+name;
			
			
			}
			
		 List<Object[]> list=getHibernateTemplate().find(hql);
			
			
				return list;	
			
			
	  }
	@Override
	public String getQuantity(int mid, int sid) {
		String quantity=null;
		try {
			
		String	hql = "select so.quantity from com.mnt.erp.bean.SalesOrderLineBean so,com.mnt.erp.bean.SalesOrderBean ss where  so.materialId='" + mid
					+ "' and  ss.salesOrderId!='" + sid + "'";
			objects = getHibernateTemplate().find(hql);
			iterate = objects.iterator();
			while (iterate.hasNext()) {
				Object object = (Object) iterate.next();
				quantity=(String)object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}
	
	}

