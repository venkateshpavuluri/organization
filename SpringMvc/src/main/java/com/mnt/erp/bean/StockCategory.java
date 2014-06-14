/**
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;
/**
 * @author pvenkateswarlu
 * @version 1.0 28-10-2013
 */
public class StockCategory {
	private int stockCategoryId;
	private String stockCategoryName;
	private int aid;
	private int stockCategoryIdEditId;
	private String stockCategoryNameEdit;
	private int stockCategoryIdEdit;
	
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	public int getStockCategoryIdEdit() {
		return stockCategoryIdEdit;
	}
	public void setStockCategoryIdEdit(int stockCategoryIdEdit) {
		this.stockCategoryIdEdit = stockCategoryIdEdit;
	}
	public int getStockCategoryId() {
		return stockCategoryId;
	}
	public void setStockCategoryId(int stockCategoryId) {
		this.stockCategoryId = stockCategoryId;
	}
	public String getStockCategoryName() {
		return stockCategoryName;
	}
	public void setStockCategoryName(String stockCategoryName) {
		this.stockCategoryName = stockCategoryName;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getStockCategoryIdEditId() {
		return stockCategoryIdEditId;
	}
	public void setStockCategoryIdEditId(int stockCategoryIdEditId) {
		this.stockCategoryIdEditId = stockCategoryIdEditId;
	}
	public String getStockCategoryNameEdit() {
		return stockCategoryNameEdit;
	}
	public void setStockCategoryNameEdit(String stockCategoryNameEdit) {
		this.stockCategoryNameEdit = stockCategoryNameEdit;
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
	


}
