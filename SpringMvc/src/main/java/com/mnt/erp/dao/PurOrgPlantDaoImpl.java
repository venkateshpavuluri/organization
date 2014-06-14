package com.mnt.erp.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PurOrgPlantDaoImpl extends HibernateDaoSupport implements PurOrgPlantDao{
public String savePurOrgPlant(Object object){
	getHibernateTemplate().save(object);
	return "po Saved Successfully";
	
}
}
