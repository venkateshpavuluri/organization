package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Agreement;
import com.mnt.erp.bean.AgreementLine;
import com.mnt.erp.bean.AssetAssignmentBean;
import com.mnt.erp.bean.AssetBean;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;

public class AssetDaoImpl extends HibernateDaoSupport implements AssetDao {
	String assetmessage;
	List<Object[]> assetlist=null;
	List <Object> asslist=null;
	List<AssetBean> assetbeanlist=null;
	@Override
	public String saveAsset(Object object) {
		try{
			AssetBean ag=(AssetBean) object;
			
		Serializable id=getHibernateTemplate().save(ag);
		if(id!=null)
		{
			assetmessage="S";
		}
		else
		{
			assetmessage="F";
		}
		}catch(Exception e){
			assetmessage="F";
			e.printStackTrace();
			
		}
		return assetmessage;
	}

	@Override
	public List<Object[]> selectAssetTypeid() {
		try{
			String hql="select a.assertTypeId,a.assertTypeName from AssertTypeBean a";
			assetlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return assetlist;
	}

	@Override
	public List<Object[]> selectAssetGroupId() {
		try{
			String hql="select ag.assetGroupId,ag.assetGroupType from AssetGroup ag";
			assetlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return assetlist;
	}

	@Override
	public List<Object[]> selectEmpId() {
		try{
			String hql="select e.employee_Id,e.fName,e.mName,e.lName from Employee e";
			assetlist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return assetlist;
	}

	@Override
	public List<Object[]> searchAsset() {
		try{
			String hql="select r.assetid,r.assetTypeBean,r.assetGroupBean,r.model,r.serialNumber,r.status,r.weon from AssetBean r";
			assetlist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return assetlist;
	}

	@Override
	public List<AssetBean> EditAsset(int iid) {
		try{
			String hql="from AssetBean b where b.assetid="+iid+"";
			assetbeanlist=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return assetbeanlist;
	}
	@Override
	public String updateAsset(Object object) {
		try {
			AssetBean agbean = (AssetBean) object;
			getHibernateTemplate().update(agbean);
			assetmessage="S";
		} catch (Exception e) {
			assetmessage="F";
			e.printStackTrace();
		}
		return assetmessage;
	}

	@Override
	public String deleteAsset(int id) {
		AssetAssignmentBean bean=null;
		List<AssetAssignmentBean> list=null;
		try{
			list=new ArrayList<AssetAssignmentBean>();
			AssetBean agbean=(AssetBean)getHibernateTemplate().get(AssetBean.class, id);
					List<AssetAssignmentBean> beans=agbean.getAssetasgnmentbean();
					Iterator<AssetAssignmentBean> iterator=beans.iterator();
					while(iterator.hasNext())
					{
						bean=(AssetAssignmentBean)iterator.next();
						bean.setEmployeebean(new Employee());
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
			assetmessage="S";
		}catch(Exception e){
			assetmessage="F";
			e.printStackTrace();
		}
		return assetmessage;
	}

	@Override
	public String deleteChildDetails(int cid) {
		try{
			AssetAssignmentBean asbean=(AssetAssignmentBean)getHibernateTemplate().get(AssetAssignmentBean.class, cid);
			asbean.setEmployeebean(new Employee());
			getHibernateTemplate().delete(asbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Asset Details Deleted Successfully";
	}

	@Override
	public List<Object[]> basicSearchAsset(String label, String operator,
			String searchName) {
	try {
            
			String hql = "select r.assetid,r.assetTypeBean,r.assetGroupBean,r.model,r.serialNumber,r.status,r.weon from AssetBean r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			assetlist = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assetlist;
	}

	@Override
	public List<Object[]> setAssetAdvanceSearch(String name) {
		String hql=null;
		if(name.equalsIgnoreCase("ALL"))
		{
			hql="select r.assetid,r.assetTypeBean,r.assetGroupBean,r.model,r.serialNumber,r.status,r.weon from AssetBean r";
	 
		}
		
		if(!name.equalsIgnoreCase("ALL"))
		{	
		hql="select r.assetid,r.assetTypeBean,r.assetGroupBean,r.model,r.serialNumber,r.status,r.weon from AssetBean r where r."+name;
		
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		
			return list;	
	}

	@Override
	public List<Object[]> setAssetSearch(String name) {
		String hql = null;
		if (name.equalsIgnoreCase("ALL")) {
			hql = "select r.assetid,r.assetTypeBean,r.assetGroupBean,r.model,r.serialNumber,r.status,r.weon from AssetBean r";
		}
		if (!name.equalsIgnoreCase("ALL")) {
			hql = "select r.assetid,r.assetTypeBean,r.assetGroupBean,r.model,r.serialNumber,r.status,r.weon from AssetBean r where r.serialNumber='"
					+ name + "'";
		}
		List<Object[]> list = getHibernateTemplate().find(hql);
		return list;
	}
	

}
