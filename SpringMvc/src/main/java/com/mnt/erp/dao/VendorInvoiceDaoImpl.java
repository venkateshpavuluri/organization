package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.RFQLineBean;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.VendorInvoice;
import com.mnt.erp.bean.VendorInvoiceLine;

public class VendorInvoiceDaoImpl extends HibernateDaoSupport implements VendorInvoiceDao {
	String vimessage;
	List<Object[]> vilist=null;
	List <Object> vlist=null;
	List<VendorInvoice> vinvoicelist=null;
	@Override
	public String saveVendorInvoice(Object object) {
		try{
			VendorInvoice vin=(VendorInvoice) object;
			
			Serializable id= getHibernateTemplate().save(vin);
			if(id!=null)
			{
			vimessage="S"; 
			}
			else
			{
				vimessage="F"; 
			}
		}catch(Exception e){
			vimessage="F"; 
			e.printStackTrace();
		}
		return vimessage;
	}

	@Override
	public List<Object[]> selectorg() {
		try{
			String hql="select o.orgId,o.orgName from Organization o";
			vilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return vilist;
	}

	
	@Override
	public List<Object[]> selectcurrency() {
		try{
			String hql="select c.currencyId,c.currency from Currency c";
			vilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return vilist;
	}

	@Override
	public List<Object[]> selectVendor() {
		try{
			String hql="select v.vendorId,v.vendorName from Vendor v";
			vilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return vilist;
	}

	@Override
	public List<Object[]> selectpurchaseOrder() {
		try{
			String hql="select p.purchaseOrderId,p.purchaseOrderNo from PurchaseOrder p";
			vilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return vilist;
	}

	@Override
	public List<Object[]> searchVendorInvoice() {
		try{
			String hql="select v.vendorinvoiceid,v.vendorinvoiceno,v.vendorinvoicedate,v.postingdate,v.amount,v.currencybean,v.reference,v.description,v.purchaseorderbean,v.orgbean,v.fy,v.vendorbean from VendorInvoice v";
			vilist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return vilist;
	}

	@Override
	public List<Object[]> selectVendorInvoice() {
		try{
			String hql="select v.vendorinvoiceid,v.vendorinvoiceno,v.vendorinvoicedate,v.postingdate,v.amount,v.currencybean,v.reference,v.description,v.purchaseorderbean,v.orgbean,v.fy,v.vendorbean from VendorInvoice v";
			vilist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return vilist;
	}

	@Override
	public List<Object[]> selectMaterial() {
		try{
			String hql="select m.material_Id,m.materialName from Material m";
			vilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return vilist;
	}

	@Override
	public List<Object[]> selectUOM() {
		try{
			String hql="select u.uom_Id,u.uom from Uom u";
			vilist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return vilist;
	}

	@Override
	public List<VendorInvoice> EditVendorInvoice(int iid) {
		try{
			String hql="from VendorInvoice vi where vi.vendorinvoiceid="+iid+"";
			vinvoicelist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return vinvoicelist;
	}

	@Override
	public String updateVendorInvoice(Object object) {
		Iterator<VendorInvoiceLine> iterator = null;
		try {
			VendorInvoice vibean = (VendorInvoice) object;
			/*VendorInvoice vibean1 = (VendorInvoice) getHibernateTemplate().get(
					VendorInvoice.class, vibean.getEditvendorinvoiceid());
			List<VendorInvoiceLine> list = vibean1.getVendorinvoicelinebean();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object o = (Object) iterator.next();
				VendorInvoiceLine vilbean = (VendorInvoiceLine) o;
				//vilbean.setMaterialdetail(new Material());
				//vilbean.setUomdetail(new Uom());
				vilbean.setVendorinvoicelineid(vilbean.getVendorinvoicelineid());
			
              getHibernateTemplate().delete(vilbean);

			}*/
           
			getHibernateTemplate().update(vibean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "S";
	}

	@Override
	public String deleteVendorInvoice(int id) {
		VendorInvoiceLine bean=null;
		List<VendorInvoiceLine > list=null;
		try{
			//System.out.println("id isss==="+id);
			list=new ArrayList<VendorInvoiceLine>();
			VendorInvoice vibean=(VendorInvoice)getHibernateTemplate().get(VendorInvoice.class, id);
		//	System.out.println("inDao"+rfqbean);
			//		System.out.println("id isss==="+id+"=="+rfqbean);
					List<VendorInvoiceLine> beans=vibean.getVendorinvoicelinebean();
					Iterator<VendorInvoiceLine> iterator=beans.iterator();
					while(iterator.hasNext())

					{
						
						bean=(VendorInvoiceLine)iterator.next();
						bean.setMaterialdetail(new Material());
						bean.setUomdetail(new Uom());
						list.add(bean);
					}
					
					
			vibean.setVendorinvoicelinebean(list);
			vibean.setCurrencybean(new Currency());
			vibean.setPurchaseorderbean(new PurchaseOrder());
			vibean.setOrgbean(new Organization());
			vibean.setVendorbean(new Vendor());
			vibean.setMaterialbean(new Material());
			vibean.setUombean(new Uom());
			getHibernateTemplate().delete(vibean);
			vimessage="S";
		}catch(Exception e){
			vimessage="F";
			e.printStackTrace();
		}
		return vimessage;
		
	}

	@Override
	public String deleteChildDetails(int cid) {
		try{
			//System.out.println("cid isss==="+cid);
			VendorInvoiceLine rfbean=(VendorInvoiceLine)getHibernateTemplate().get(VendorInvoiceLine.class, cid);
			rfbean.setMaterialdetail(new Material());
			rfbean.setUomdetail(new Uom());
			getHibernateTemplate().delete(rfbean);
		 // System.out.println("del"+rfbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Customer Invoice Details Deleted Successfully";

	}

	@Override
	public List<Object[]> basicSearchVendorInvoice(String label,
			String operator, String searchName) {
try {
            
			String hql = "select v.vendorinvoiceid,v.vendorinvoiceno,v.vendorinvoicedate,v.postingdate,v.amount,v.currencybean,v.reference,v.description,v.purchaseorderbean,v.orgbean,v.fy,v.vendorbean from VendorInvoice v where v."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			vilist = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vilist;
	}

	@Override
	public List<Object[]> setVendorInvoiceAdvanceSearch(String name) {
		String hql=null;
		if(name.equalsIgnoreCase("ALL"))
		{
			hql="select v.vendorinvoiceid,v.vendorinvoiceno,v.vendorinvoicedate,v.postingdate,v.amount,v.currencybean,v.reference,v.description,v.purchaseorderbean,v.orgbean,v.fy,v.vendorbean from VendorInvoice v";
	 
		}
		
		if(!name.equalsIgnoreCase("ALL"))
		{	
		hql="select v.vendorinvoiceid,v.vendorinvoiceno,v.vendorinvoicedate,v.postingdate,v.amount,v.currencybean,v.reference,v.description,v.purchaseorderbean,v.orgbean,v.fy,v.vendorbean from VendorInvoice v where v."+name;
		
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		
			return list;	
	}

	@Override
	public List<Object[]> setVendorInvoiceSearch(String name) {
		String hql = null;
		if (name.equalsIgnoreCase("ALL")) {
			hql = "select v.vendorinvoiceid,v.vendorinvoiceno,v.vendorinvoicedate,v.postingdate,v.amount,v.currencybean,v.reference,v.description,v.purchaseorderbean,v.orgbean,v.fy,v.vendorbean from VendorInvoice v";

		}

		if (!name.equalsIgnoreCase("ALL")) {
			hql = "select v.vendorinvoiceid,v.vendorinvoiceno,v.vendorinvoicedate,v.postingdate,v.amount,v.currencybean,v.reference,v.description,v.purchaseorderbean,v.orgbean,v.fy,v.vendorbean from VendorInvoice v where v.vendorinvoiceno='"
					+ name + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		

		return list;
	}

	@Override
	public Long getVICount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from VendorInvoice v where  v.vendorinvoiceno ='"+name+"'";
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
	public Long getVICountedit(String name, int viid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from VendorInvoice ab where ab.vendorinvoiceno='"
					+ name + "'and ab.vendorinvoiceid!='" + viid + "'";
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
