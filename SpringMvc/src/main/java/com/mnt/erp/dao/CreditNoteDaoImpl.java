/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.CreditNote;
import com.mnt.erp.bean.CreditNoteDetail;
import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VendorInvoice;



/**
 * @author kirangangone	
 * @version 1.0
   @build 0.0
 * 
 *
 */
public class CreditNoteDaoImpl extends HibernateDaoSupport implements CreditNoteDao
{
	String msg;
	
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;

	@Override
	public String addCreditNote(Object object)
	{
		// TODO Auto-generated method stub

		try
		{
			
			CreditNote creditNote=(CreditNote)object;
			Serializable id=getHibernateTemplate().save(creditNote);
			//System.out.println("Quot Dao:"+purchaseOrder);
			if(id!=null)
			{
		    msg ="S";
			}
			else
			{
				  msg ="F";	
			}
		}
		catch(Exception e)
		{
			msg ="F";
			e.printStackTrace();
			
		}
		return msg;
	}
	
	public Long checkCreditNote(String pno) {

		try {
			String sql = "select count(*) from CreditNote cb where  cb.creditNoteNo='"
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
  
	public List<Object[]> basicSearchCreditNote() {
		try {
			
			
			
			String hql = "select c.creditNoteNo,c.creditNoteDT,c.customerInvoiceId,c.vendorInvoiceId,c.creditNoteId  from CreditNote c ";

			
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	
	@Override
	public List<Object[]> setCreditNoteAdvanceSearch(String credit) {
		String hql=null;
					hql= "select c.creditNoteNo,c.creditNoteDT,c.customerInvoiceId,c.vendorInvoiceId,c.creditNoteId  from CreditNote c  where "+credit;
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		//for (Object[] objects : list) {
			//System.out.println("with in the dao for credit Search=="+objects);
		//}
		//System.out.println("with in the dao for Bom Search=="+list);select c.creditNoteNo,c.creditNoteDT,c.customerInvoiceId,c.vendorInvoiceId,c.customerInvoiceDetails,c.vendorInvoiceDetails from CreditNote c  where
			return list;	
		
		
	}
	
	public List<Object[]> basicSearchCredit(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {

			String hql = "select c.creditNoteNo,c.creditNoteDT,c.customerInvoiceId,c.vendorInvoiceId,c.creditNoteId from CreditNote c  where c."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	public List<Object> editCreditNoteWithId(int Id) {
		try {
		//	System.out.println("editPoWith id "+Id);
			String hql = "from CreditNote c where c.creditNoteId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	public String deleteCreditNoteDetailList(int id) {
		String message = null;
		com.mnt.erp.bean.CreditNoteDetail creditNoteDetail = null;
		try {
			creditNoteDetail = (com.mnt.erp.bean.CreditNoteDetail) getHibernateTemplate().get(
					com.mnt.erp.bean.CreditNoteDetail.class, id);
			creditNoteDetail.setMaterialDetails(new Material());
			creditNoteDetail.setUomDetails(new Uom());
			getHibernateTemplate().delete(creditNoteDetail);
			
			message = "Credit Note Deleted Successfully";
			//System.out.println("deleteCreditNoteDetailList   =============="+message);
		} catch (Exception e) {
			 e.printStackTrace();
			message = "Sorry Cant be Deleted";
			//System.out.println(message);
		}
		return message;
	}
	
	
	@Override
	public String updateCreditNote(Object object) {
	
		
		try {
			CreditNote creditUp = (CreditNote) object;			
			getHibernateTemplate().update(creditUp);
			msg="S";

		} catch (Exception e) {
			
			
			e.printStackTrace();
			msg="F";
		}
		return msg;
	}
	
	public int updateCheckCredit(String custName, int custId) {
		try {
			String sql = "select count(*) from CreditNote cb where  cb.creditNoteNo='"
					+ custName + "' and cb.creditNoteId!='" + custId + "'";
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

	
	public String deleteCreditNote(int id) {
		String message = null;
		com.mnt.erp.bean.CreditNote purchaseOrder = null;
		try {
			purchaseOrder = (com.mnt.erp.bean.CreditNote) getHibernateTemplate().get(
					com.mnt.erp.bean.CreditNote.class, id);
			purchaseOrder.setCustomerInvoiceDetails(new CustomerInvoice());
			purchaseOrder.setVendorInvoiceDetails(new VendorInvoice());
			 List<CreditNoteDetail> puLine = purchaseOrder.getCreditNoteDetail();
				Iterator<CreditNoteDetail> iter = puLine.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					CreditNoteDetail puLineDelete = (CreditNoteDetail) o;
					puLineDelete.setCreditNoteDetailId(puLineDelete.getCreditNoteDetailId());
					puLineDelete.setMaterialDetails(new Material());
					puLineDelete.setUomDetails(new Uom());
					getHibernateTemplate().delete(puLineDelete);
				}
			getHibernateTemplate().delete(purchaseOrder);
			
			message = "S";
			//System.out.println("delete of Credit Note"+message);
		} catch (Exception e) {
			e.printStackTrace();
			message = "F";
			//System.out.println(message);
			return message;
		}
		return message;
	}
	
	
/*	
	
	
	
	

	
	
	
	
	
	
	
	
	public List<Object[]> purchaseOrderNumGet(String s){
		 List<Object[]> list=null;
		 if(s.equals("PurchaseOrder")){
		// TODO Auto-generated method stub
				String hql="select p.purchaseOrderId, p.purchaseOrderNo from "+s+" p ";
				//System.out.println("the Query is:"+hql);
				 list=getHibernateTemplate().find(hql);
		 }
		 else if(s.equals("ProductionOrder")){
			 String hql="select p.purchaseOrderId, p.purchaseOrderNo from "+s+" p ";
				//System.out.println("the Query is:"+hql);
				 list=getHibernateTemplate().find(hql);
		 }
			     return list;
	}
*/
	/*For Selecting Customer InvoiceId and Number*/
	
	public List<Object[]> getCustomerInvoiceId(){
		List<Object[]> list=null;
		String sql=null;
		try
		{
			sql="select  k.customerinvoiceid,k.customerinvoiceno from CustomerInvoice k "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	/*For Selecting Vendor InvoiceId and Number*/
	
	public List<Object[]> getVendorInvoiceId(){
		List<Object[]> list=null;
		String sql=null;
		try
		{
			sql="select k.vendorinvoiceid,k.vendorinvoiceno from VendorInvoice k "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}


	

	/*public String saveWorkFlowListDaoDetails(Object object){
		
	
			try
			{
				WorkFlowList wf=(WorkFlowList)object;
				getHibernateTemplate().save(object);
				msg ="success";
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				msg ="fail";
				return msg;
			}
			
            return msg;
		}
	*/
}
