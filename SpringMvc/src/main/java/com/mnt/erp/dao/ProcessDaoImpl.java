package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ProcessBean;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.ProcessTypeBean;



public class ProcessDaoImpl extends HibernateDaoSupport implements ProcessDao {
	String processmessage;
	List<Object[]> list=null;
	List <Object> elist=null;
	List<ProcessBean> plist=null;
	@Override
	public String saveprocess(Object object) {
		try{
			ProcessBean processbean=(ProcessBean)object;
		Serializable id=getHibernateTemplate().save(processbean);
		if(id!=null)

			processmessage="S";
		
		}catch(Exception e){
			processmessage="F";
			e.printStackTrace();
		}
		return processmessage;
	}

	@Override
	public List<Object[]> searchProcessWithId(int id) {
		try{
			String hql="select p.processid,p.process from ProcessBean p where p.processid="+id+"";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchProcess() {
		try{
			String hql="select pd.processid,pd.process,pd.materialbean,pd.version from ProcessBean pd";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
	}

	@Override
	public List<Object[]> selectProcess() {
		try{
			String hql="select p.processid,p.process from ProcessBean p";
			list=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateProcess(Object object) {
		ProcessBean processBean=null;
		
		try{
			processBean=(ProcessBean)object;
	getHibernateTemplate().update(processBean);
	processmessage="S";
		}catch(Exception e){
			processmessage="F";
			e.printStackTrace();
		}
		return processmessage;
	}


	@Override
	public Long getProcessCount(String name) {
		Iterator<Object> iterator=null;
		Long p=1L;
		try{
		String	sql="select count(*) from ProcessBean p where  p.process ='"+name+"'";
		
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
	
	

	@Override
	public List<Object[]> selectProcessTypeDetail() {
		try{
			String hql="select pd.processtypeid,pd.processtype from ProcessTypeBean pd ";
		list=getHibernateTemplate().find(hql);
		}catch(Exception e){
	e.printStackTrace();		
		}
		return list;
	}

	@Override
	public List<ProcessBean> EditProcess(int iid) {
		try{
			String hql="from ProcessBean pb where pb.processid="+iid+"";
			plist=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return plist;
	}

	@Override
	public Long getProcessDetailCount(String desc) {
		Iterator<Object> iterator=null;
		Long pd=1L;
		try{
		String	sql="select count(*) from ProcessDetailBean pdb where  pdb.processdescription ='"+desc+"'";
		
			List<Object> list=getHibernateTemplate().find(sql);
			
			iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				Object object=(Object)iterator.next();
				pd=(Long)object;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pd;
	}

	@Override
	public Long getProcessDetailedit(String name, int processdid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from ProcessBean ab where ab.process='"+ name + "'and ab.processid!='"+processdid+"'";
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
	public Long getProcessDetailcountedit(String name, int processdetailsid) {
		
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from ProcessDetailBean ab where ab.processdescription='"+ name + "'and ab.processdetailid!='"+processdetailsid+"'";
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
	public List<Object[]> basicSearchProcess(String label, String operator,
			String searchName) {
		try {
                             
			String hql = "select pd.processid,pd.process,pd.materialbean,pd.version from ProcessBean pd where pd."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Long getProcessDescriptionedit(String name, int processdescid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from ProcessDetailBean ab where ab.processdescription='"+ name + "'and ab.processdetailid!='"+processdescid+"'";
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
	public String deleteProcess(int id) {
		ProcessDetailBean bean=null;
		List<ProcessDetailBean> list=null;
		try{
			//System.out.println("id isss==="+id);
			list=new ArrayList<ProcessDetailBean>();
			ProcessBean processBean=new ProcessBean();
			processBean.setProcessid(id);
			ProcessBean bean1=(ProcessBean)getHibernateTemplate().get(ProcessBean.class, id);
		//	System.out.println("inDao"+rfqbean);
			//		System.out.println("id isss==="+id+"=="+rfqbean);
					List<ProcessDetailBean> beans=bean1.getProcessdetailbean();
					
					Iterator<ProcessDetailBean> iterator=beans.iterator();
					while(iterator.hasNext())

					{
						
						bean=(ProcessDetailBean)iterator.next();
						bean.setPtbean(new ProcessTypeBean());
						list.add(bean);
					}
					getHibernateTemplate().deleteAll(list);
					
				/*	bean1.setProcessdetailbean(list);
			bean1.setPtbean(new ProcessTypeBean());*/
			
			getHibernateTemplate().delete(processBean);
			processmessage="S";
		}catch(Exception e){
			processmessage="F";
			e.printStackTrace();
		}
		return	processmessage;
	}
	@Override
	public String deleteChildDetails(int cid) {
		try{
			ProcessDetailBean processbean=(ProcessDetailBean)getHibernateTemplate().get(ProcessDetailBean.class, cid);
			getHibernateTemplate().delete(processbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "ProcessDetails Deleted Successfully";
	}

	@Override
	public List<Object[]> selectMaterial() {
		try{
			String hql="select i.material_Id,i.materialName from Material i";
			list=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	

}
