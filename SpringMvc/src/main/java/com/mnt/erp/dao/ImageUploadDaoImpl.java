/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author venkateshp
 *
 */
public class ImageUploadDaoImpl extends HibernateDaoSupport implements ImageUploadDao  {
	Logger logger=Logger.getLogger(ImageUploadDaoImpl.class);
	public boolean saveImagePath(Object object)
	{
		boolean flag=false;
		try
		{
		Serializable id=getHibernateTemplate().save(object);
		if(id!=null)
		{
			flag=true;
		}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return flag;
		
	}

}
