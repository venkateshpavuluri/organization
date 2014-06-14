/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 *@version 1.0 20-11-2013
 */
public class SalesOrderSchLineBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int salesOrderSchLineId;
	private int salesOrderLineId;
	private String sosUomId;
	private String sosQuantity;
	private String sosDelDate;
	private Uom childUom;
	//Edit variables
	private int esalesOrderSchLineId;
	private int esalesOrderLineId;
	private String esosUomId;
	private String esosQuantity;
	private String esosDelDate;
	private String childUomName;
	
	// Setter And Getter Methods
	
	public int getEsalesOrderLineId() {
		return esalesOrderLineId;
	}
	public void setEsalesOrderLineId(int esalesOrderLineId) {
		this.esalesOrderLineId = esalesOrderLineId;
	}
	public String getEsosUomId() {
		return esosUomId;
	}
	public void setEsosUomId(String esosUomId) {
		this.esosUomId = esosUomId;
	}
	public String getEsosQuantity() {
		return esosQuantity;
	}
	public void setEsosQuantity(String esosQuantity) {
		this.esosQuantity = esosQuantity;
	}
	public String getEsosDelDate() {
		return esosDelDate;
	}
	public void setEsosDelDate(String esosDelDate) {
		this.esosDelDate = esosDelDate;
	}
	public int getSalesOrderSchLineId() {
		return salesOrderSchLineId;
	}
	public void setSalesOrderSchLineId(int salesOrderSchLineId) {
		this.salesOrderSchLineId = salesOrderSchLineId;
	}
	public int getSalesOrderLineId() {
		return salesOrderLineId;
	}
	public String getSosUomId() {
		return sosUomId;
	}
	public void setSosUomId(String sosUomId) {
		this.sosUomId = sosUomId;
	}
	public String getSosQuantity() {
		return sosQuantity;
	}
	public String getChildUomName() {
		return childUomName;
	}
	public void setChildUomName(String childUomName) {
		this.childUomName = childUomName;
	}
	public void setSosQuantity(String sosQuantity) {
		this.sosQuantity = sosQuantity;
	}
	public Uom getChildUom() {
		return childUom;
	}
	public void setChildUom(Uom childUom) {
		this.childUom = childUom;
	}
	public int getEsalesOrderSchLineId() {
		return esalesOrderSchLineId;
	}
	public void setEsalesOrderSchLineId(int esalesOrderSchLineId) {
		this.esalesOrderSchLineId = esalesOrderSchLineId;
	}
	public String getSosDelDate() {
		return sosDelDate;
	}
	public void setSosDelDate(String sosDelDate) {
		this.sosDelDate = sosDelDate;
	}
	public void setSalesOrderLineId(int salesOrderLineId) {
		this.salesOrderLineId = salesOrderLineId;
	}
	
}
