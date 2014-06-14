package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.CustomerInvoiceLine;
import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;

import com.mnt.erp.bean.Uom;


public class CustomerInvoiceDaoImpl extends HibernateDaoSupport implements CustomerInvoiceDao {
	String cimessage;
	List<Object[]> cilist=null;
	List <Object> Clist=null;
	List<CustomerInvoice> cinvoicelist=null;
	@Override
	public String saveCustomerInvoice(Object object) {
		try{
			CustomerInvoice cin=(CustomerInvoice) object;
			
			Serializable id= getHibernateTemplate().save(cin);
			if(id!=null)
			{
			cimessage="S";
			}
			else
			{
				cimessage="F";
			}
		}catch(Exception e){
			cimessage="F";
			e.printStackTrace();
		}
		return cimessage;
	}

	@Override
	public List<Object[]> selectdeliverynote() {
		try{
			String hql="select d.deliveryNoteId,d.deliveryNoteDate from DeliveryNote d";
			cilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cilist;
	}

	@Override
	public List<Object[]> selectcurrency() {
		try{
			String hql="select c.currencyId,c.currency from Currency c";
			cilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cilist;
	}

	@Override
	public List<Object[]> selectorg() {
		try{
			String hql="select o.orgId,o.orgName from Organization o";
			cilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cilist;
	}

	@Override
	public List<Object[]> searchCustomerInvoice() {
		try{
			String hql="select c.customerinvoiceid,c.customerinvoiceno,c.customerinvoicedate,c.postingdate,c.deliverynotebean,c.amount,c.currencybean,c.reference,c.description,c.orgbean,c.fy from CustomerInvoice c";
			cilist=getHibernateTemplate().find(hql);
			//System.out.println("In dao"+cilist);
		}catch(Exception e){
			e.printStackTrace();
		}
			return cilist;
	}

	@Override
	public List<Object[]> selectCustomerInvoice() {
		try{
			String hql="select c.customerinvoiceid,c.customerinvoiceno,c.customerinvoicedate,c.postingdate,c.deliverynotebean,c.amount,c.currencybean,c.reference,c.description,c.orgbean,c.fy from CustomerInvoice c";
			cilist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return cilist;
	}

	@Override
	public List<Object[]> selectMaterial() {
		try{
			String hql="select m.material_Id,m.materialName from Material m";
			cilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cilist;
	}

	@Override
	public List<Object[]> selectUOM() {
		try{
			String hql="select u.uom_Id,u.uom from Uom u";
			cilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cilist;
	}

	@Override
	public List<CustomerInvoice> EditCustomerInvoice(int iid) {
		try{
			String hql="from CustomerInvoice ci where ci.customerinvoiceid="+iid+"";
			cinvoicelist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return cinvoicelist;
	}

	@Override
	public String updateCustomerInvoice(Object object) {
		Iterator<CustomerInvoiceLine> iterator = null;
		try {
			CustomerInvoice cibean = (CustomerInvoice) object;
			getHibernateTemplate().update(cibean);
			cimessage="S";
		} catch (Exception e) {
			cimessage="F";
			e.printStackTrace();
		}
		return cimessage;
	}

	@Override
	public String deleteCustomerInvoice(int id) {
		CustomerInvoiceLine bean=null;
		List<CustomerInvoiceLine > list=null;
		try{
			//System.out.println("id isss==="+id);
			list=new ArrayList<CustomerInvoiceLine>();
			CustomerInvoice vibean=(CustomerInvoice)getHibernateTemplate().get(CustomerInvoice.class, id);
		//	System.out.println("inDao"+rfqbean);
			//		System.out.println("id isss==="+id+"=="+rfqbean);
					List<CustomerInvoiceLine> beans=vibean.getCustomerinvoicelinebean();
					Iterator<CustomerInvoiceLine> iterator=beans.iterator();
					while(iterator.hasNext())

					{
						
						bean=(CustomerInvoiceLine)iterator.next();
						bean.setMaterialdetail(new Material());
						bean.setUomdetail(new Uom());
						list.add(bean);
					}
					
					
			vibean.setCustomerinvoicelinebean(list);
			vibean.setCurrencybean(new Currency());
			vibean.setDeliverynotebean(new DeliveryNote());
			vibean.setOrgbean(new Organization());
			vibean.setMaterialbean(new Material());
			vibean.setUombean(new Uom());
			getHibernateTemplate().delete(vibean);
			cimessage="S";
		}catch(Exception e){
			cimessage="F";
			e.printStackTrace();
		}
		return cimessage;
	}

	@Override
	public String deleteChildDetails(int cid) {
		try{
			
			CustomerInvoiceLine cbean=(CustomerInvoiceLine)getHibernateTemplate().get(CustomerInvoiceLine.class, cid);
			cbean.setMaterialdetail(new Material());
			cbean.setUomdetail(new Uom());
			getHibernateTemplate().delete(cbean);
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Customer Invoice Details Deleted Successfully";
	}

	@Override
	public List<Object[]> basicSearchCustomerInvoice(String label,
			String operator, String searchName) {
		try {
		            
					String hql = "select c.customerinvoiceid,c.customerinvoiceno,c.customerinvoicedate,c.postingdate,c.deliverynotebean,c.amount,c.currencybean,c.reference,c.description,c.orgbean,c.fy from CustomerInvoice c where c."
							+ label + "" + operator + " ? ";

					Object[] parameters = { searchName };
					cilist = getHibernateTemplate().find(hql, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return cilist;
	}

	@Override
	public List<Object[]> setCustomerInvoiceAdvanceSearch(String name) {
		String hql=null;
		if(name.equalsIgnoreCase("ALL"))
		{
			hql="select c.customerinvoiceid,c.customerinvoiceno,c.customerinvoicedate,c.postingdate,c.deliverynotebean,c.amount,c.currencybean,c.reference,c.description,c.orgbean,c.fy from CustomerInvoice c";
	 
		}
		
		if(!name.equalsIgnoreCase("ALL"))
		{	
		hql="select c.customerinvoiceid,c.customerinvoiceno,c.customerinvoicedate,c.postingdate,c.deliverynotebean,c.amount,c.currencybean,c.reference,c.description,c.orgbean,c.fy from CustomerInvoice c where c."+name;
		
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		
			return list;
	}

	@Override
	public List<Object[]> setCustomerInvoiceSearch(String name) {
		String hql = null;
		if (name.equalsIgnoreCase("ALL")) {
			hql = "select c.customerinvoiceid,c.customerinvoiceno,c.customerinvoicedate,c.postingdate,c.deliverynotebean,c.amount,c.currencybean,c.reference,c.description,c.orgbean,c.fy from CustomerInvoice c";

		}

		if (!name.equalsIgnoreCase("ALL")) {
			hql = "select c.customerinvoiceid,c.customerinvoiceno,c.customerinvoicedate,c.postingdate,c.deliverynotebean,c.amount,c.currencybean,c.reference,c.description,c.orgbean,c.fy from CustomerInvoice c where v.customerinvoiceno='"
					+ name + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		

		return list;
	}

	@Override
	public Long getCICount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from CustomerInvoice p where  p.customerinvoiceno ='"+name+"'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Long getCICountedit(String name, int cid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from CustomerInvoice ab where ab.customerinvoiceno='"
					+ name + "'and ab.customerinvoiceid!='" + cid + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

}
