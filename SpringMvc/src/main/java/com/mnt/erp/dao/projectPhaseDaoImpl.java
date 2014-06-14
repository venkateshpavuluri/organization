package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ProjectPhaseBean;
import com.mnt.erp.bean.ProjectResourceTypeBean;
import com.mnt.erp.service.AuditLogService;

public class projectPhaseDaoImpl extends HibernateDaoSupport implements projectPhaseDao{
	List<Object[]> list=null;
	@Autowired
	AuditLogService auditLogService;
	String msg=null;;
	
	@Override
	public String saveProjectPhase(Object object,String userId, String userName) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			Serializable id=getHibernateTemplate().save(object);
			
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Project phase",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkProjectPhase(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  ProjectPhaseBean ag where ag.projectPhase='"
					+ type + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchProjectPhase() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.projectPhase_Id,e.projectPhase from ProjectPhaseBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchProjectPhaseWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.projectPhase_Id,e.projectPhase,e.project from ProjectPhaseBean e where e.projectPhase_Id='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchProjectPhase(String label,String operator,String searchName){
		try {

			String hql = "select e.projectPhase_Id,e.projectPhase,e.projectBean from ProjectPhaseBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteProjectPhase(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		ProjectPhaseBean prBean  = null;
		try {
			prBean= (ProjectPhaseBean) getHibernateTemplate().get(ProjectPhaseBean.class, id);
			getHibernateTemplate().delete(prBean);
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public String updateProjectPhase(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			ProjectPhaseBean ptBean=(ProjectPhaseBean) object;
			
			getHibernateTemplate().update(ptBean);
			s = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectProjectPhase() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.projectPhase_Id,e.projectPhase from ProjectPhaseBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProjectPhase(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  ProjectPhaseBean ag where ag.projectPhase='"
					+ type + "' and ag.projectPhase_Id!='" + Id + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Object[]> getProjectIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select p.projectId,p.projectName from Project p";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
