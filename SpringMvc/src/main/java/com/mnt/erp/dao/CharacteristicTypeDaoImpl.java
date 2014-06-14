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
import com.mnt.erp.bean.CharacteristicType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Parvathi
 * @version 1.0 04-1-2014
 */

public class CharacteristicTypeDaoImpl extends HibernateDaoSupport implements CharacteristicTypeDao{
	
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	String msg=null;

	@Override
	public String saveCharacteristicTypeDetails(Object object,String userId,String userName) {
	
		try {
			Serializable id=getHibernateTemplate().save(object);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Code",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}

		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchCharacteristicType() {
	
		List<Object[]> list = null;
		try {
			String q = "select c.characteristicType_Id,c.characteristicType from CharacteristicType c order by c.characteristicType";
			list = getHibernateTemplate().find(q);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchCharacteristicTypeWithId(int id) {
	

		List<Object[]> list = null;
		try {
			String q = "select c.characteristicType_Id,c.characteristicType from CharacteristicType c where c.characteristicType_Id="
					+ id + "";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateCharacteristicType(Object object) {
	
		try {
			CharacteristicType characteristicTypeGroup = (CharacteristicType) object;
			getHibernateTemplate().update(characteristicTypeGroup);
			msg="S";
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteCharacteristicType(int id) {
		
		CharacteristicType characteristicType = null;
		try {
			characteristicType = getHibernateTemplate().get(
					CharacteristicType.class, id);
			getHibernateTemplate().delete(characteristicType);
			msg="S";
			

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> selectCharacteristicType() {
		
	
		try {
			String q = "select c.characteristicType_Id,c.characteristicType from CharacteristicType c";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Long checkCharacteristicType(String characteristicType){
	

		Long count = null;
		try {
			final String hql = "select count(*) from  CharacteristicType ag where ag.characteristicType='"
					+ characteristicType + "'";
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

	public Long updateCheckCharacteristicType(String characteristicType,int characteristicTypeId) {
		Long count = null;
		try {
			final String hql = "select count(*) from  CharacteristicType c where c.characteristicType='"
					+ characteristicType + "' and c.characteristicType_Id!='" + characteristicTypeId + "'";
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
	
	public List<Object[]> basicSearchCharacteristicType(String label,String operator,String searchName){
		try {

			String hql = "select c.characteristicType_Id,c.characteristicType from CharacteristicType c where c."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
