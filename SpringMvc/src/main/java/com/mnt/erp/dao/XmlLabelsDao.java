/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Naresh
 * @version 1.0 10-10-2013
 *
 */
public interface XmlLabelsDao {
	
	public Map<String, String> populateXmlLabels(String name);
	public List<Object[]> populateXml(String name);
}
