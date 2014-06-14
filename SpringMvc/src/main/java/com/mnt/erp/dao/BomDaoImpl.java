/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Bom;
import com.mnt.erp.bean.BomLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;

/**
 * @author Sailaja
 * @version 1.0 08-11-2013
 * @build 0.0
 */
public class BomDaoImpl extends HibernateDaoSupport implements BomDao
{

	String msg;
	List<Object[]> obj = null;
	@Override
	public String addBom(Object object) {
		// TODO Auto-generated method stub
		try {

			Bom bom = (Bom) object;
		Serializable id=getHibernateTemplate().save(bom);
		if(id!=null)
		{

			msg = "S";
		}
		else
		{
			msg="F";
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchBom() {
		// TODO Auto-generated method stub
	

		
				String qry = "select b.bomId,b.materialBean,b.plantBean,b.usage,b.bomCategoryBean,b.revisionLevel,b.bomNumber from Bom b ";
				obj = getHibernateTemplate().find(qry);

				return obj;

	}
	@Override
	public List<Object[]> searchBomWithId(int id) {
		// TODO Auto-generated method stub
		String qry = "select b.bomId,b.materialBean,b.plantBean,b.usage,b.bomCategoryBean,b.revisionLevel,b.bomNumber from Bom b where b.bomId="
				+ id + "";
		obj = getHibernateTemplate().find(qry);

		return obj;
	}

	@Override
	public List<Object> editBomWithId(int qid) {
		// TODO Auto-generated method stub
		List<Object> objs = null;
		try {
			String hql = "from Bom b where b.bomId=" + qid + " ";
			objs = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public String updateBom(Object object) {
		// TODO Auto-generated method stub
		Iterator<BomLine> iterator = null;
		try {
			Bom bom = (Bom) object;
			
			Bom bom1 = (Bom) getHibernateTemplate().get(Bom.class, bom.getBomIdEditt());
			List<BomLine> list = bom1.getBomLine();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object o = (Object) iterator.next();
				BomLine bomL = (BomLine) o;
				bomL.setMaterialDetails(new Material());
				bomL.setUomDetails(new Uom());
				bomL.setParentMaterialDetails(new Material());
			
				bomL.setBomLineId(bomL.getBomLineId());
				getHibernateTemplate().delete(bomL);
			}
			
			getHibernateTemplate().update(bom);
			msg="S";
		}
		/*catch(ConstraintViolationException ce){
			ce.printStackTrace();
		}*/
		catch (Exception e) {
			msg="F";
			//e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public String deleteBom(int id) {
		// TODO Auto-generated method stub
		try {

			Bom deleteBom = new Bom();
			deleteBom.setBomId(id);
			getHibernateTemplate().delete(deleteBom);
			
			msg="S";
		} catch (Exception e) {
			e.printStackTrace();
			msg="F";
		}
		return msg;
	
	}

	@Override
	public String deleteBomLine(int bomLineId) {
		// TODO Auto-generated method stub
		try {
		
			BomLine line=new BomLine();
			line.setBomLineId(bomLineId);
			
			line.setMaterialDetails(new Material());
			
			line.setUomDetails(new Uom());
			
			getHibernateTemplate().delete(line);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Bom Details Deleted Successfully";
	}

	@Override
	public int checkDuplicate(String checkMaterial) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from Bom b where b.bmaterial_Id='"
					+ checkMaterial + "'";
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
		return count.intValue();
	}

	@Override
	public int checkEditDuplicate(String checkMaterial, int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from Bom b where b.bmaterial_Id='"
					+ checkMaterial + "' and b.bomId!='" + id + "'";
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
		return count.intValue();
	}

	@Override
	public List<Object[]> basicSearchBom(String label, String operator,
			String searchName) {
		try {

			String hql = "select b.bomId,b.materialBean,b.plantBean,b.usage,b.bomCategoryBean,b.revisionLevel,b.bomNumber from Bom b where b."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			obj = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Object[]> getBomCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String hsql;
		try {
			hsql = "select bc.bomCategoryId,bc.bomCategory from BomCategory bc";
			list = getHibernateTemplate().find(hsql);
		} catch (Exception e) {

		}
		return list;
	}
	@Override
	public List<Object[]> bomAdvanceSearch(String bom) {
		// TODO Auto-generated method stub
		String hql=null;
		if(bom.equalsIgnoreCase("ALL"))
		{
			hql="select b.bomId,b.materialBean,b.plantBean,b.usage,b.bomCategoryBean,b.revisionLevel,b.bomNumber from Bom b";
	 
		}
		
		if(!bom.equalsIgnoreCase("ALL"))
		{	
		hql="select b.bomId,b.materialBean,b.plantBean,b.usage,b.bomCategoryBean,b.revisionLevel,b.bomNumber from Bom b where "+bom;
		
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
	
			return list;	
	}
	@Override
	public List<Object[]> setBomSearch(String bom) {
		String hql = null;
		if(bom.equalsIgnoreCase("ALL"))
		{
			hql="select b.bomId,b.materialBean,b.plantBean,b.usage,b.bomCategoryBean,b.revisionLevel,b.bomNumber from Bom b";
	 
		}
		
		if(!bom.equalsIgnoreCase("ALL"))
		{	
		hql="select b.bomId,b.materialBean,b.plantBean,b.usage,b.bomCategoryBean,b.revisionLevel,b.bomNumber from Bom b where "+bom;
		
		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

}
