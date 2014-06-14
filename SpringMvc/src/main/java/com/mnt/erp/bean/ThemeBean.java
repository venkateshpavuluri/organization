/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author devi
 *
 */
public class ThemeBean {
	private int theme_Id;
	private String theme;
	private int aid;

//Basic Search Properties

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

//Edit Properties
	private int theme_IdEdit;
	private String themeEdit;
	public int getTheme_Id() {
		return theme_Id;
	}
	public void setTheme_Id(int theme_Id) {
		this.theme_Id = theme_Id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	public int getTheme_IdEdit() {
		return theme_IdEdit;
	}
	public void setTheme_IdEdit(int theme_IdEdit) {
		this.theme_IdEdit = theme_IdEdit;
	}
	public String getThemeEdit() {
		return themeEdit;
	}
	public void setThemeEdit(String themeEdit) {
		this.themeEdit = themeEdit;
	}
	
	
	
	

}
