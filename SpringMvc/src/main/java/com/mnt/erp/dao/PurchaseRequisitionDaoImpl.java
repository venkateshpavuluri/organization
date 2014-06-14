/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.PurchaseReqLine;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class PurchaseRequisitionDaoImpl extends HibernateDaoSupport implements
		PurchaseRequisitionDao {
	List<Object[]> objects = null;

	public String savePurchaseRequisitionDetails(Object object) {
		// TODO Auto-generated method stub
		// PurchaseReq purchaseReq=null;
		try {
			PurchaseReq purchaseReq = (PurchaseReq) object;
		
			getHibernateTemplate().save(purchaseReq);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Purchase Requisition Details Saved Successfully";
	}

	public List<Object[]> searchPurchaseReq() {
		List<Object[]> objects = null;

		try {
			String hql = "select p.purchaseReq_Id, p.purchaseReqNo, p.requestedDate,p.reqDate,r.orgName,p.refNo,s.status, p.description from PurchaseReq p,Status s,Organization r where s.statusId=p.status_id and r.orgId=p.org_Id order by p.purchaseReqNo";
			objects = getHibernateTemplate().find(hql);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> editPurchaseReqWithId(int prid) {
		List<Object> objs = null;
		try {
			String hql = "from PurchaseReq p where p.purchaseReq_Id=" + prid
					+ " ";
			objs = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	public String updatePurchaseRequisition(Object object) {
		PurchaseReqLine pc = null;
		Iterator<PurchaseReqLine> iterator1 = null;
		PurchaseReqLine pLine = null;
		List<PurchaseReqLine> list2 = null;
		try {

			PurchaseReq pg = (PurchaseReq) object;
			int id = pg.getPurchaseReq_Id();
			

			PurchaseReq po = (PurchaseReq) getHibernateTemplate().get(
					PurchaseReq.class, id);
			list2 = po.getPurchaseReqLine();

			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (PurchaseReqLine) o;
				pc = new PurchaseReqLine();
				
				pc.setPurchaseReqLine_Id(pLine.getPurchaseReqLine_Id());
				
				pc.setMaterial(new Material());
				pc.setUomDetails(new Uom());
				//getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Purchase Requition  Details Updated Successfully";
	}

	public String deletePurchaseRequisition(int id) {
		List<PurchaseReqLine> list=null;
		// TODO Auto-generated method stub
		try {
			PurchaseReqLine prline=null;
			list=new ArrayList<PurchaseReqLine>();
			PurchaseReq deletePurchaseReq = getHibernateTemplate().get(
					PurchaseReq.class, id);
			deletePurchaseReq.setOrganization(new Organization());
			deletePurchaseReq.setStatusDetails(new Status());
			List<PurchaseReqLine> beans=deletePurchaseReq.getPurchaseReqLine();
			Iterator<PurchaseReqLine> iterator=beans.iterator();
			while(iterator.hasNext())

			{
				
				prline=(PurchaseReqLine)iterator.next();
				prline.setMaterial(new Material());
				prline.setUomDetails(new Uom());
				prline.setPlantDetails(new Plant());
				prline.setStorageLocationDetails(new StorageLocation());
				prline.setStatusDetails(new Status());
				
				list.add(prline);
			}
			deletePurchaseReq.setPurchaseReqLine(list);
	
			getHibernateTemplate().delete(deletePurchaseReq);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Deleted";

	}

	public int purchaseRequisitionDuplicate(String purReqNo) {

		Long count = null;
		try {
			final String hql = "select count(*) from PurchaseReq a where a.purchaseReqNo='"
					+ purReqNo + "'";
			
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

	public int purchaseRquisitionEditDuplicate(String purReqNo, int id) {
		Long count = null;
		try {
			final String hql = "select count(*) from PurchaseReq a where a.purchaseReqNo='"
					+ purReqNo + "' and a.purchaseReq_Id!='" + id + "'";
			
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

	public List<Object[]> basicSearchPurchaseReq(String label, String operator,
			String searchName) {
		try {

			String hql = "select p.purchaseReq_Id, p.purchaseReqNo, p.requestedDate,p.reqDate,r.orgName,p.refNo,s.status, p.description from PurchaseReq p,Status s,Organization r where s.statusId=p.status_id and r.orgId=p.org_Id and p."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public String deletePuchseRequisitionLine(int kk){
		// TODO Auto-generated method stub
				try {
					
					PurchaseReqLine line=new PurchaseReqLine();
					line.setPurchaseReqLine_Id(kk);
					
					line.setMaterial(new Material());
					System.out.println("the materal is:"+line.getMaterial());
					line.setPlantDetails(new Plant());
					line.setUomDetails(new Uom());
					line.setStatusDetails(new Status());
					line.setStorageLocationDetails(new StorageLocation());
					getHibernateTemplate().delete(line);
					

				} catch (Exception e) {
					e.printStackTrace();

				}
				return "Purchase Requisition Line Deleted Successfully";
	}
	   public List<Object[]> getPurchaseRequisitionAdvance(String name){
		   String hql=null;
			if(name.equalsIgnoreCase("ALL"))
			{
				
				hql="select p.purchaseReq_Id, p.purchaseReqNo, p.requestedDate,p.reqDate,r.orgName,p.refNo,s.status, p.description from PurchaseReq p,Status s,Organization r where s.statusId=p.status_id and r.orgId=p.org_Id";
				
				
		  
			}
			
			if(!name.equalsIgnoreCase("ALL"))
			{	
			hql="select p.purchaseReq_Id, p.purchaseReqNo, p.requestedDate,p.reqDate,r.orgName,p.refNo,s.status, p.description from PurchaseReq p,Status s,Organization r where s.statusId=p.status_id and r.orgId=p.org_Id and"+name;
		
			
			}
			
		 List<Object[]> list=getHibernateTemplate().find(hql);
			
			
				return list;		
	   }
	   @Override
		public List<Object[]> selectPlantIds(int orgId) {
			try {
				String sql = "select p.plantId,p.plantName from Plant p where p.orgId="
						+ orgId;
				objects = getHibernateTemplate().find(sql);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return objects;
		}

		@Override
		public List<Object[]> populateStorLocIds(int plantId) {
			try {
				String sql = "select s.storageLocationId,s.storageLocation from StorageLocation s where s.plantId="
						+ plantId;
				objects = getHibernateTemplate().find(sql);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return objects;
		}

	   
		public List<Object[]> getStepUser(){
			List<Object[]> list=null;
			String sql=null;
			try
			                                                      //,p.statusDetaial,p.organization
			{
				
			
				//sql="select p.purchaseReqNo,p.requestedBy,p.requestedDate,p.requiredDate,p.description,p.refNo from PurchaseReq p";
				//sql="select w.wfstepid,u.userId from UserRoles u, WFStep w where u.roleId= w.wfstepAssignedTo and w.wfstepStep=1"; 
			
				//list=getHibernateTemplate().find(sql);
				list= getHibernateTemplate().findByNamedQuery("StepUserForPR");
				
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}

}
