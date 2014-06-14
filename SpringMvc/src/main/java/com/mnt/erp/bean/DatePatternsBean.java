/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Naresh
 * @version 1.0  15-04-2014
 */

@XmlRootElement
public class DatePatternsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String datePattern;
	private String conPattern;
	private String dbPattern;

	public String getDatePattern() {
		return datePattern;
	}

	public String getConPattern() {
		return conPattern;
	}

	public String getDbPattern() {
		return dbPattern;
	}

	@XmlElement
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	@XmlElement
	public void setConPattern(String conPattern) {
		this.conPattern = conPattern;
	}

	@XmlElement
	public void setDbPattern(String dbPattern) {
		this.dbPattern = dbPattern;
	}

}
