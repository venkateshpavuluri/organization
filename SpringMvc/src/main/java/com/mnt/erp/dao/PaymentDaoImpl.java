/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Payment;
import com.mnt.erp.bean.PaymentWithHold;

/**
 * @author venkateshp
 *
 */
public class PaymentDaoImpl extends HibernateDaoSupport implements PaymentDao {
	
public static	Logger logger=Logger.getLogger(PaymentDaoImpl.class);

String sql;


	public int savePaymentDetails(Object object) {
		// TODO Auto-generated method stub
		int msg=0;
		
		try
		{
		Serializable id=getHibernateTemplate().save(object);
		msg=(Integer)id;
		
		}
		catch(Exception e)
		{
			msg=0;
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long duplicateCheck(String name) {
		// TODO Auto-generated method stub
		Long duid=0l;
		List<Object> list=null;
		Iterator<Object> iterator=null;
		Object object=null;
		try
		{
			sql="select count(*) from Payment o where  o.paymentNo='" + name
					+ "'";
			list=getHibernateTemplate().find(sql);
		iterator=list.iterator();
		while(iterator.hasNext())
		{
			object=(Object)iterator.next();
			duid=(Long)object;
		}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duid;
		
	}

	@Override
	public List<Object[]> searchPayment() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails from Payment p ";
			list=getHibernateTemplate().find(sql);
			logger.info("in dao payment search==="+list);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> basicSearchPayment(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		Integer  basicId=Integer.parseInt(basicSearchId);
		try
		{
		String hql = "select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails from Payment p where p."
				+ dbField + "" + operation + " ? ";
logger.info("basicSearch=="+dbField+"=="+operation+"=="+basicSearchId);
		Object[] parameters = { basicSearchId };
		list = getHibernateTemplate().find(hql, basicId);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Payment> editPaymentDetails(int paymentId) {
		// TODO Auto-generated method stub
		List<Payment> list=null;
		try
		{
			//sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankId,p.paymentTypeId,p.vendorId,p.vendorInvoiceId,p.chequeNo,p.chequeDate,p.paymentStatus,p.description,p.chequeIssuedBy,p.chequeIssuedDate,p.chequeClearanceStatus,p.chequeClearanceDate,p.orgId,p.currecyId,p.paymentMethodId,p.paymentWithhold from Payment p where p.paymentId="+paymentId+"";
		sql="from Payment p where p.paymentId="+paymentId+"";
			list=getHibernateTemplate().find(sql);
			
			logger.info("paymentedit size iss=="+list.size());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public Long updateDuplicateCheck(String paymentName,int paymentId)
	{
		Long duid=0l;
		List<Object> list=null;
		Iterator<Object> iterator=null;
		Object object=null;
		try
		{
			sql="select count(*) from Payment o where  o.paymentNo='" + paymentName
					+ "' and o.paymentId!="+paymentId+"";
			list=getHibernateTemplate().find(sql);
		iterator=list.iterator();
		while(iterator.hasNext())
		{
			object=(Object)iterator.next();
			duid=(Long)object;
		}
		logger.info("dao dupid iss==="+duid+" ==pnumber=="+paymentName+"==id=="+paymentId );
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duid;
		
	}

	@Override
	public int updatePayment(Object object) {
		// TODO Auto-generated method stub
		int msg=0;
		try
		{
			getHibernateTemplate().update(object);
			msg=1;
		}
		catch(Exception e)
		{
			msg=0;
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public int deletePayment(int id) {
		// TODO Auto-generated method stub
		int sid=0;
		try
		{
			List<PaymentWithHold> holds=new ArrayList<PaymentWithHold>();
			Payment paymentp=new Payment();
			paymentp.setPaymentId(id);
			Payment payment=(Payment)getHibernateTemplate().get(Payment.class,id);
		getHibernateTemplate().deleteAll(payment.getPaymentWithhold());
			getHibernateTemplate().delete(paymentp);
			sid=1;
		}
		catch(Exception e)
		{
			sid=0;
			e.printStackTrace();
		}
		return sid;
	}
	
	@Override
	public List<Object[]> paymentAdvanceSearch(String payment) {
		// TODO Auto-generated method stub
		String hql=null;
		if(payment.equalsIgnoreCase("ALL"))
		{
			sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails,p.vendorInvoiceDetails from Payment p ";
			logger.info("all search");
	 
		}
		
		if(!payment.equalsIgnoreCase("ALL"))
		{	
			sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails,p.vendorInvoiceDetails from Payment p where"+payment;
		//hql="select orgId,orgName,add1,add2,add3,city,State,phone,fax,email from Organization  where "+organization;
			logger.info("where search=="+payment);
			logger.info("query=="+sql);
		}
		
	 List<Object[]> list=getHibernateTemplate().find(sql);
		logger.info("list isss=="+list);
	
			return list;	
	}

	@Override
	public List<Object[]> getPayment(String payment) {
		// TODO Auto-generated method stub
		String hql=null;
		if(payment.equalsIgnoreCase("ALL"))
		{
			hql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails,p.vendorInvoiceDetails from Payment p ";
	 
		}
		
		if(!payment.equalsIgnoreCase("ALL"))
		{	
			sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails,p.vendorInvoiceDetails from Payment p where+"+payment+ "'";
		//hql="select orgId,orgName,add1,add2,add3,city,State,phone,fax,email from Organization  where "+organization;
	
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
	
			return list;
	}
	
	
}
