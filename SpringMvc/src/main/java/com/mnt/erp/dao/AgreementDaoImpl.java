package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Agreement;
import com.mnt.erp.bean.AgreementLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.bean.Uom;

public class AgreementDaoImpl extends HibernateDaoSupport implements AgreementDao {
	String agreementmessage;
	List<Object[]> agglist=null;
	List <Object> alist=null;
	List<Agreement> agreementlist=null;
	@Override
	public String saveAgreement(Object object) {
		try{
			Agreement ag=(Agreement) object;
			
		Serializable id=getHibernateTemplate().save(ag);
		if(id!=null)
		{
			agreementmessage="S";
		}
		else
		{
			agreementmessage="F";
		}
		}catch(Exception e){
			agreementmessage="F";
			e.printStackTrace();
			
		}
		return agreementmessage;
	
	}

	@Override
	public List<Object[]> selectAgreementTypeid() {
		try{
			String hql="select a.agreementType_Id,a.agreementType from AgreementType a";
			agglist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return agglist;
	}

	@Override
	public List<Object[]> selectVendorId() {
		try{
			String hql="select r.vendorId,r.vendorName from Vendor r";
			agglist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return agglist;
	}

	@Override
	public List<Object[]> selectOrgId() {
		try{
			String hql="select o.orgId,o.orgName from Organization o";
			agglist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return agglist;
	}

	@Override
	public List<Object[]> selectpurOrgId() {
		try{
			String hql="select po.purOrg_Id,po.purOrg from PurchaseOrganization po";
			agglist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return agglist;
	}

	@Override
	public List<Object[]> selectMaterial() {
		try{
			String hql="select m.material_Id,m.materialName from Material m";
			agglist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return agglist;
	}

	@Override
	public List<Object[]> selectUom() {
		try{
			String hql="select u.uom_Id,u.uom from Uom u";
			agglist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return agglist;
	}

	@Override
	public List<Agreement> EditAgreement(int iid) {
		try{
			String hql="from Agreement pb where pb.agreementId="+iid+"";
			agreementlist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return agreementlist;
	}
	@Override
	public String updateAgreement(Object object) {
		try {
			Agreement agbean = (Agreement) object;
			getHibernateTemplate().update(agbean);
			agreementmessage="S";
		} catch (Exception e) {
			agreementmessage="F";
			e.printStackTrace();
		}
		return agreementmessage;
	}

	@Override
	public String deleteAgreement(int id) {
		AgreementLine bean=null;
		List<AgreementLine> list=null;
		try{
			list=new ArrayList<AgreementLine>();
			Agreement agbean=(Agreement)getHibernateTemplate().get(Agreement.class, id);
					List<AgreementLine> beans=agbean.getAgreementline();
					Iterator<AgreementLine> iterator=beans.iterator();
					while(iterator.hasNext())
					{
						bean=(AgreementLine)iterator.next();
						bean.setMaterialdetail(new Material());
						bean.setUomdetail(new Uom());
						list.add(bean);
					}
			/*rfqbean.setRfqlinebean(list);
			rfqbean.setRfqbean(new RFQType());
			rfqbean.setItemcategorybean(new ItemCategory());
			rfqbean.setStoragelocationbean(new StorageLocation());
			rfqbean.setPlantbean(new Plant());
			rfqbean.setPurchasegroupbean(new PurchaseGroup());
			rfqbean.setMaterialbean(new Material());
			rfqbean.setUombean(new Uom());
			rfqbean.setStatusbean(new Status());*/
			getHibernateTemplate().delete(agbean);
			agreementmessage="S";
		}catch(Exception e){
			agreementmessage="F";
			e.printStackTrace();
		}
		return agreementmessage;
	}

	@Override
	public String deleteChildDetails(int cid) {
		try{
			//System.out.println("cid isss==="+cid);
			AgreementLine rfbean=(AgreementLine)getHibernateTemplate().get(AgreementLine.class, cid);
			rfbean.setMaterialdetail(new Material());
			rfbean.setUomdetail(new Uom());
			getHibernateTemplate().delete(rfbean);
		 // System.out.println("del"+rfbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Agreement Details Deleted Successfully";
	}

	@Override
	public List<Object[]> basicSearchAgreement(String label, String operator,
			String searchName) {
	try {
            
			String hql = "select r.agreementId,r.agtypebean,r.agreementNo,r.vendorbean,r.orgbean,r.purorgbean,r.agreementDate,r.stdt,r.etdt from Agreement r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			agglist = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agglist;
	}

	@Override
	public List<Object[]> setAgreementAdvanceSearch(String name) {
		String hql=null;
		if(name.equalsIgnoreCase("ALL"))
		{
			hql="select r.agreementId,r.agtypebean,r.agreementNo,r.vendorbean,r.orgbean,r.purorgbean,r.agreementDate,r.stdt,r.etdt from Agreement r";
	 
		}
		
		if(!name.equalsIgnoreCase("ALL"))
		{	
		hql="select r.agreementId,r.agtypebean,r.agreementNo,r.vendorbean,r.orgbean,r.purorgbean,r.agreementDate,r.stdt,r.etdt from Agreement r where r."+name;
		
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		
			return list;	
	
	}

	@Override
	public List<Object[]> setAgreementSearch(String name) {
		String hql = null;
		if (name.equalsIgnoreCase("ALL")) {
			hql = "select r.agreementId,r.agtypebean,r.agreementNo,r.vendorbean,r.orgbean,r.purorgbean,r.agreementDate,r.stdt,r.etdt from Agreement r";

		}

		if (!name.equalsIgnoreCase("ALL")) {
			hql = "select r.agreementId,r.agtypebean,r.agreementNo,r.vendorbean,r.orgbean,r.purorgbean,r.agreementDate,r.stdt,r.etdt from Agreement r where r.agreementNo='"
					+ name + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		

		return list;
	}

	@Override
	public Long getAgreementCount(String name) {
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
	public Long getAgreementCountedit(String name, int Agreementid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from RfqBean ab where ab.rfqNo='"
					+ name + "'and ab.rfqid!='" + Agreementid + "'";
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
	public List<Object[]> searchAgreement() {
		try{
			String hql="select r.agreementId,r.agtypebean,r.agreementNo,r.vendorbean,r.orgbean,r.purorgbean,r.agreementDate,r.stdt,r.etdt from Agreement r order by r.agreementNo";
			agglist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return agglist;
	}

	@Override
	public List<PurchaseOrganization> selectPoIds(int orgId) {
		List <PurchaseOrganization> poc=null;
		try {
			String sql = "select p.orgbean from PurOrgCompany p where p.org_Id="+orgId;
			poc = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return poc;
	}

	@Override
	public List<PurchaseOrganization> selectPoIdsEdit(int orgId) {
		List <PurchaseOrganization> poc=null;
		try {
			String sql = "select p.orgbean from PurOrgCompany p where p.org_Id="+orgId;
			poc = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return poc;
	}

	
}
