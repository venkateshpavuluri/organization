/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;
import java.util.Map;

import com.mnt.erp.dao.XmlLabelsDao;

/**
 * @author Naresh
 * @version 1.0 11-10-2013
 * 
 */
public class XmlLabelsServiceImpl implements XmlLabelsService {

	XmlLabelsDao xmlDao;

	public XmlLabelsDao getXmlDao() {
		return xmlDao;
	}

	public void setXmlDao(XmlLabelsDao xmlDao) {
		this.xmlDao = xmlDao;
	}

	public Map<String, String> populateXmlLabels(String name) {
		Map<String, String> map = null;
		try {
			map = xmlDao.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public List<Object[]> populateXml(String name) {
		   List<Object[]> returnString= null;
			try {
				returnString = xmlDao.populateXml(name);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return returnString;
		}

}
