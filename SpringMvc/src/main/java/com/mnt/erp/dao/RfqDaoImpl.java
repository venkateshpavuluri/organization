package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.*;

public class RfqDaoImpl extends HibernateDaoSupport implements RfqDao {
	String rfqmessage;
	List<Object[]> rfqlist=null;
	List <Object> rlist=null;
	List<RfqBean> rflist=null;
	@Override
	public String saverfq(Object object) {
		try{
			RfqBean rfq=(RfqBean) object;
			
		Serializable id=getHibernateTemplate().save(rfq);
		if(id!=null)
		{
			rfqmessage="S";
		}
		else
		{
			rfqmessage="F";
		}
		}catch(Exception e){
			rfqmessage="F";
			e.printStackTrace();
			
		}
		return rfqmessage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectrfqType() {
		try{
			String hql="select r.rfqTypeId,r.rfqType from RFQType r";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}
    
	@Override
	public List<Object[]> selectItemCategory() {
		try{
			String hql="select i.itemCategoryId,i.itemCategory from ItemCategory i";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}

	@Override
	public List<Object[]> selectstorageLocation() {
		try{
			String hql="select st.storageLocationId,st.storageLocation from StorageLocation st";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}

	@Override
	public List<Object[]> selectplant() {
		try{
			String hql="select p.plantId,p.plantName from Plant p";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}

	@Override
	public List<Object[]> selectpurchaseGroup() {
		try{
			String hql="select pg.purchaseGroupId,pg.purchaseGroup from PurchaseGroup pg";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}

	/*@Override
	public List<Object[]> searchrfqWithId(int id) {
		try{
			String hql="select r.rfqid,p.process from RfqBean p where p.processid="+id+"";
			rfqlist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}*/

	@Override
	public List<Object[]> searchRfq() {
		try{
			String hql="select r.rfqid,r.rfqbean,r.rfqNo,r.rfqDate,r.quotationdeadline,r.itemcategorybean,r.deliveryDate,r.validFrom,r.validTo,r.storagelocationbean,r.plantbean,r.refNumber,r.purchasegroupbean,r.statusbean from RfqBean r order by r.rfqNo";
			rfqlist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return rfqlist;
	}

	@Override
	public List<Object[]> selectRfq() {
		try{
			String hql="select r.rfqid,r.rfqType,r.rfqNo,r.rfqDate,r.quotationdeadline,r.itemCategory,r.deliveryDate,r.validFrom,r.validTo,r.storageLocation,r.palntRfq,r.refNumber,r.purchaseGrouprfq,r.statusbean from RfqBean r";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;	}

	@Override
	public List<RfqBean> EditRfq(int iid) {
		try{
			String hql="from RfqBean pb where pb.rfqid="+iid+"";
			rflist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return rflist;
	}

	@Override
	public String updateRfq(Object object) {
		try {
			RfqBean rfqbean = (RfqBean) object;
			getHibernateTemplate().update(rfqbean);
			rfqmessage="S";
		} catch (Exception e) {
			rfqmessage="F";
			e.printStackTrace();
		}
		return rfqmessage;
	}

	@Override
	public String deleteRfq(int id) {
	//	String Msg=null;
		RFQLineBean bean=null;
		List<RFQLineBean > list=null;
		try{
			list=new ArrayList<RFQLineBean>();
			RfqBean rfqbean=(RfqBean)getHibernateTemplate().get(RfqBean.class, id);
					List<RFQLineBean> beans=rfqbean.getRfqlinebean();
					Iterator<RFQLineBean> iterator=beans.iterator();
					while(iterator.hasNext())
					{
						bean=(RFQLineBean)iterator.next();
						bean.setMaterialdetail(new Material());
						bean.setUomdetail(new Uom());
						list.add(bean);
					}
			rfqbean.setRfqlinebean(list);
			rfqbean.setRfqbean(new RFQType());
			rfqbean.setItemcategorybean(new ItemCategory());
			rfqbean.setStoragelocationbean(new StorageLocation());
			rfqbean.setPlantbean(new Plant());
			rfqbean.setPurchasegroupbean(new PurchaseGroup());
			rfqbean.setMaterialbean(new Material());
			rfqbean.setUombean(new Uom());
			rfqbean.setStatusbean(new Status());
			getHibernateTemplate().delete(rfqbean);
			rfqmessage="S";
		}catch(Exception e){
			rfqmessage="F";
			e.printStackTrace();
		}
		return rfqmessage;
	}

	@Override
	public List<Object[]> basicSearchRfq(String label, String operator,
			String searchName) {
		try {
            
			String hql = "select r.rfqid,r.rfqbean,r.rfqNo,r.rfqDate,r.quotationdeadline,r.itemcategorybean,r.deliveryDate,r.validFrom,r.validTo,r.storagelocationbean,r.plantbean,r.refNumber,r.purchasegroupbean,r.statusbean from RfqBean r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			rfqlist = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rfqlist;
	}

	@Override
	public List<Object[]> selectMaterial() {
		try{
			String hql="select m.material_Id,m.materialName from Material m";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}

	@Override
	public List<Object[]> selectUOM() {
		try{
			String hql="select u.uom_Id,u.uom from Uom u";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}

	@Override
	public String deleteChildDetails(int cid) {
		try{
			//System.out.println("cid isss==="+cid);
			RFQLineBean rfbean=(RFQLineBean)getHibernateTemplate().get(RFQLineBean.class, cid);
			rfbean.setMaterialdetail(new Material());
			rfbean.setUomdetail(new Uom());
			getHibernateTemplate().delete(rfbean);
		 // System.out.println("del"+rfbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "RFQ Details Deleted Successfully";
	}

	@Override
	public List<Object[]> setRfqAdvanceSearch(String name) {
		String hql=null;
		if(name.equalsIgnoreCase("ALL"))
		{
			hql="select r.rfqid,r.rfqbean,r.rfqNo,r.rfqDate,r.quotationdeadline,r.itemcategorybean,r.deliveryDate,r.validFrom,r.validTo,r.storagelocationbean,r.plantbean,r.refNumber,r.purchasegroupbean from RfqBean r";
	 
		}
		
		if(!name.equalsIgnoreCase("ALL"))
		{	
		hql="select r.rfqid,r.rfqbean,r.rfqNo,r.rfqDate,r.quotationdeadline,r.itemcategorybean,r.deliveryDate,r.validFrom,r.validTo,r.storagelocationbean,r.plantbean,r.refNumber,r.purchasegroupbean from RfqBean r where r."+name;
		
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		
			return list;	
	}

	@Override
	public List<Object[]> setRfqSearch(String name) {
		String hql = null;
		if (name.equalsIgnoreCase("ALL")) {
			hql = "select r.rfqid,r.rfqbean,r.rfqNo,r.rfqDate,r.quotationdeadline,r.itemcategorybean,r.deliveryDate,r.validFrom,r.validTo,r.storagelocationbean,r.plantbean,r.refNumber,r.purchasegroupbean from RfqBean r";

		}

		if (!name.equalsIgnoreCase("ALL")) {
			hql = "select r.rfqid,r.rfqbean,r.rfqNo,r.rfqDate,r.quotationdeadline,r.itemcategorybean,r.deliveryDate,r.validFrom,r.validTo,r.storagelocationbean,r.plantbean,r.refNumber,r.purchasegroupbean from RfqBean r where r.rfqNo='"
					+ name + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		

		return list;
	}

	@Override
	public Long getRfqCount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from RfqBean p where  p.rfqNo ='"+name+"'";
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
	public Long getRfqCountedit(String name, int Rfqid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from RfqBean ab where ab.rfqNo='"
					+ name + "'and ab.rfqid!='" + Rfqid + "'";
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
	public List<Object[]> selectStatus() {
		try{
			String hql="select s.statusId,s.status from Status s";
			rfqlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqlist;
	}

}
