/**
 * 
 */
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

import com.mnt.erp.bean.BreakTimeBean;
import com.mnt.erp.bean.PayGradeSalElementBean;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class PayGradeSalElementDaoImpl extends HibernateDaoSupport implements PayGradeSalElementDao {
	@Autowired
	AuditLogService auditLogService;
	
	String brmessage;
	List<Object[]> list=null;
	@Override
	public String savePayGradeSalElement(Object btObject,String userId,String userName) {
		// TODO Auto-generated method stub
		try{
			PayGradeSalElementBean btbean=(PayGradeSalElementBean)btObject;
		Serializable id=getHibernateTemplate().save(btbean);
		if(id!=null)
		{
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","PayGrade","ROW" ,String.valueOf(id),"1",modifiedDate,userName);		
		}
			brmessage="S";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	@Override
public List<Object[]> selectPayGradeSalElement() {
	try{
		String hql="select s.payGradeSalElement_Id,s.amount_Formulae from PayGradeSalElementBean s";
		list=getHibernateTemplate().find(hql);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchPayGradeSalElementWithId(int id ) {
	
		try{
			String hql="select s.payGradeSalElement_Id,s.payGrade_Id,s.payElement_Id,s.amount_Formulae,s.include from PayGradeSalElementBean s where s.payGradeSalElement_Id="+id+"";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchPayGradeSalElement() {
	try{
		String hql="select s.payGradeSalElement_Id,s.payGradeBean,s.payElementBean,s.amount_Formulae,s.include from PayGradeSalElementBean s";
		
		list=getHibernateTemplate().find(hql);
		
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public String updatePayGradeSalElement(Object btObject) {
		try{
			PayGradeSalElementBean btbean=(PayGradeSalElementBean)btObject;
				   
						
			getHibernateTemplate().update(btbean);
			
			
		}catch(Exception e){
			e.printStackTrace();
			return "F";
		}
		return "S";
	}

	@Override
	public String deletePayGradeSalElement(int id) {
		
		try{
			PayGradeSalElementBean btbean=(PayGradeSalElementBean)getHibernateTemplate().get(PayGradeSalElementBean.class, id);
			getHibernateTemplate().delete(btbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long getPayGradeSalElementCount(String name) {
		Iterator<Object> iterator=null;
		Long p=1L;
		try{
		String	sql="select count(*) from PayGradeSalElementBean s where  s.amount_Formulae='"+name+"'";
			List<Object> list=getHibernateTemplate().find(sql);
			iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				Object object=(Object)iterator.next();
				p=(Long)object;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return p;
	}
	
	//@SuppressWarnings("unchecked")
	public Long getPayGradeSalElementCountedit(String name,int pGradeid) {
		Iterator<Object> iterator=null;
		Long count=null;
		try{
			final String	sql="select count(*) from PayGradeSalElementBean s where  s.amount_Formulae ='"+name+"' and s.payGradeSalElement_Id!='"+pGradeid+"' ";
		
		    
		count = (Long) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(
							org.hibernate.Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						org.hibernate.Query query = session
								.createQuery(sql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}

				});

		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> basicSearchPayGradeSalElement(String label, String operator,
			String searchName) {
		try {

			String hql = "select s.payGradeSalElement_Id,s.payGradeBean,s.payElementBean,s.amount_Formulae,s.include from PayGradeSalElementBean s where s."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPayGradeIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select o.payGradeId,o.payGrade from PayGradeBean o";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPayElementIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.payelementId,s.payelement from PayElementBean s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
