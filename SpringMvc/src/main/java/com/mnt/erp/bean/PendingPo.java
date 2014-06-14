/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class PendingPo {
	private String purchaseOrderNo;
	private String  vendorName;
	private String dueDate;
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}
	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	

}
