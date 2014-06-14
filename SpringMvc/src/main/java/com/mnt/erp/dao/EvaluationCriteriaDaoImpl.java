package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.EvaluationCriteria;
import com.mnt.erp.bean.EvaluationSubCriteria;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.PurchaseReqLine;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;

public class EvaluationCriteriaDaoImpl extends HibernateDaoSupport implements EvaluationCriteriaDao{
	@Autowired
	AuditLogService auditLogService;
	String msg=null;;
	List<Object[]> list=null;
	public String saveEvaluationCriteria(Object object,String userId,String userName)
	{ 
		
		try{
			
			EvaluationCriteria at=(EvaluationCriteria)object;
			
			Serializable id=getHibernateTemplate().save(at);
			if (id != null) {

			
				msg = "S";
			}
		   } 
		catch(Exception e){
			msg="F";
			e.printStackTrace();
		   }
		return msg;
	}
	
	public List<Object[]> searchEvaluationCriteria(int id){
		
		List<Object[]> objects=null;
		try
		{
			String hql="select at.evaluationCriteriaId,at.evaluationCriteria,at.weightingFactor from EvaluationCriteria at order by at.evaluationCriteria";
			
	        objects=getHibernateTemplate().find(hql);
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	
	
	public List<EvaluationCriteria> editEvaluationCriteriaWithId(int id){
		List<EvaluationCriteria> objects=null;
		try
		{	
			
	      String hql="from EvaluationCriteria r where r.evaluationCriteriaId="+id+"";
	      
	      objects=getHibernateTemplate().find(hql);
	      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	
	public String updateEvaluationCriteria(Object object){
	
			
			EvaluationSubCriteria pc = null;
			Iterator<EvaluationSubCriteria> iterator1 = null;
			EvaluationSubCriteria pLine = null;
			List<EvaluationSubCriteria> list2 = null;
			try {

				EvaluationCriteria pg = (EvaluationCriteria) object;
				int id=pg.getEvaluationCriteriaId();
				

				EvaluationCriteria po = (EvaluationCriteria) getHibernateTemplate().get(
						EvaluationCriteria.class, id);
				list2 = po.getEvaluationSubCriterias();

				iterator1 = list2.iterator();
				while (iterator1.hasNext()) {
					Object o = (Object) iterator1.next();
					pLine = (EvaluationSubCriteria) o;
					pc = new EvaluationSubCriteria();
					
					pc.setEvaluationSubCriteriaId(pLine.getEvaluationSubCriteriaId());
					
					getHibernateTemplate().delete(pc);

				}

				getHibernateTemplate().update(pg);
			/*EvaluationCriteria evaluationCriteria=(EvaluationCriteria)object;
			
			int id=evaluationCriteria.getEvaluationCriteriaId();
			
			EvaluationCriteria agtype=(EvaluationCriteria)getHibernateTemplate().get(EvaluationCriteria.class,id);
			
			
			getHibernateTemplate().update(agtype);*/
			
			msg="S";
			
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;

	}
	public String EvaluationCriteriaDelete(int id){
		EvaluationCriteria at=null;
		
		try
		{
			at=(EvaluationCriteria)getHibernateTemplate().get(EvaluationCriteria.class,id);
			
			getHibernateTemplate().delete(at);
			
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	
	}

	public int EvaluationCriteriaDuplicate(String EvaluationCriteria){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from EvaluationCriteria a where a.evaluationCriteria='"+EvaluationCriteria+"'";
	   		    count = (Long) getHibernateTemplate().execute(
	   				new HibernateCallback<Object>(){
	   					public Object doInHibernate(org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query=session.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
	   				});
	       }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count.intValue();
	}
	
	public int EvaluationCriteriaEditDuplicate(String EvaluationCriteria,int id){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from EvaluationCriteria a where a.evaluationCriteria='"+EvaluationCriteria+"' and a.evaluationCriteriaId!='"+id+"'";
	   		    count = (Long) getHibernateTemplate().execute(
	   				new HibernateCallback<Object>(){
	   					public Object doInHibernate(org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query=session.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
	   				});
	       }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count.intValue();
	}

	@Override
	public List<Object[]> basicSearchEvaluationCriteria(String label,
			String operator, String searchName) {
		try {

			String hql = "select at.evaluationCriteriaId,at.evaluationCriteria,at.weightingFactor from EvaluationCriteria at where at."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteEvaluationCriteriaDetail(int kk){
		// TODO Auto-generated method stub
		try {
			
			EvaluationSubCriteria line=new EvaluationSubCriteria();
			line.setEvaluationSubCriteriaId(kk);
		
			
					
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}
}
