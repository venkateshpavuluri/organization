package com.mnt.erp.dao;
/**
 * @author pvenkateswarlu
 *
 */
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao{

	@Override
	public List<Object[]> getCredentials(String username,String password) {

		String hql="select h.user_Id,h.userName,h.password,h.tbean from Users h where h.userName='"+username+"' and h.password='"+password+"'";
	List<Object[]> list=getHibernateTemplate().find(hql);
	
		return list;
	}
	
//	@Override
	public List<Object[]> getDetails(String username) {

		String hql="select h.user_Id,h.userName,h.password from Users h where h.userName='"+username+"'";
	List<Object[]> list=getHibernateTemplate().find(hql);
	
		return list;
	}
	

}
