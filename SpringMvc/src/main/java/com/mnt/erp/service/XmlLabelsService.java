/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.Map;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 11-10-2013
 * 
 */
public interface XmlLabelsService {

	public Map<String, String> populateXmlLabels(String name);
	public List<Object[]> populateXml(String name);
}
