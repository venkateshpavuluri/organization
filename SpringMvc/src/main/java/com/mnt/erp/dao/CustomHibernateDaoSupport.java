/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Naresh
 * @version 1.0 15-05-2014
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {
	@Autowired
	public void anyMethodName(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
