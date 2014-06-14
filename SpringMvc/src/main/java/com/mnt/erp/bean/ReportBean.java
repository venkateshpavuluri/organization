/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author madhav
 *
 */
public class ReportBean {
	
	private String rNo;
	private String rDate;
	private String purchaseOrderId;
	//For Gettobe Material Order
	private String materialId;
	private String materialName;
	//Purchase Requisition
	private String prNo;
	private String prDate;
	//Quotation
	private String qNo;
	private String qDate;
	//Purchase Order
	private String poNo;
	private String poDate;
	//Sales Inquiry
	private String siNo;
	private String siDate;
	//Sales Order
	private String soNo;
	private String soDate;
	//sales Purchase Order
	private String spoNo;
	private String spoDate;
	
	//sales Quotation
	private String sqNo;
	private String sqDate;
	
	//Voucher
	private String voucherNo;
	
	//StorageLocation
	private String sLocation;
	
	//Customer Return
	private String reportId;
	private String reportDate;
	
	//
	
	

	/**
	 * @return the sLocation
	 */
	public String getsLocation() {
		return sLocation;
	}
	/**
	 * @return the reportId
	 */
	public String getReportId() {
		return reportId;
	}
	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	/**
	 * @return the reportDate
	 */
	public String getReportDate() {
		return reportDate;
	}
	/**
	 * @param reportDate the reportDate to set
	 */
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	/**
	 * @param sLocation the sLocation to set
	 */
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	/**
	 * @return the voucherNo
	 */
	public String getVoucherNo() {
		return voucherNo;
	}
	/**
	 * @param voucherNo the voucherNo to set
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	/**
	 * @return the sqNo
	 */
	public String getSqNo() {
		return sqNo;
	}
	/**
	 * @param sqNo the sqNo to set
	 */
	public void setSqNo(String sqNo) {
		this.sqNo = sqNo;
	}
	/**
	 * @return the sqDate
	 */
	public String getSqDate() {
		return sqDate;
	}
	/**
	 * @param sqDate the sqDate to set
	 */
	public void setSqDate(String sqDate) {
		this.sqDate = sqDate;
	}
	/**
	 * @return the spoNo
	 */
	public String getSpoNo() {
		return spoNo;
	}
	/**
	 * @param spoNo the spoNo to set
	 */
	public void setSpoNo(String spoNo) {
		this.spoNo = spoNo;
	}
	/**
	 * @return the spoDate
	 */
	public String getSpoDate() {
		return spoDate;
	}
	/**
	 * @param spoDate the spoDate to set
	 */
	public void setSpoDate(String spoDate) {
		this.spoDate = spoDate;
	}
	/**
	 * @return the soNo
	 */
	public String getSoNo() {
		return soNo;
	}
	/**
	 * @param soNo the soNo to set
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	/**
	 * @return the soDate
	 */
	public String getSoDate() {
		return soDate;
	}
	/**
	 * @param soDate the soDate to set
	 */
	public void setSoDate(String soDate) {
		this.soDate = soDate;
	}
	/**
	 * @return the siNo
	 */
	public String getSiNo() {
		return siNo;
	}
	/**
	 * @param siNo the siNo to set
	 */
	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}
	/**
	 * @return the siDate
	 */
	public String getSiDate() {
		return siDate;
	}
	/**
	 * @param siDate the siDate to set
	 */
	public void setSiDate(String siDate) {
		this.siDate = siDate;
	}
	/**
	 * @return the poNo
	 */
	public String getPoNo() {
		return poNo;
	}
	/**
	 * @param poNo the poNo to set
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	/**
	 * @return the poDate
	 */
	public String getPoDate() {
		return poDate;
	}
	/**
	 * @param poDate the poDate to set
	 */
	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}
	/**
	 * @return the qNo
	 */
	public String getqNo() {
		return qNo;
	}
	/**
	 * @param qNo the qNo to set
	 */
	public void setqNo(String qNo) {
		this.qNo = qNo;
	}
	/**
	 * @return the qDate
	 */
	public String getqDate() {
		return qDate;
	}
	/**
	 * @param qDate the qDate to set
	 */
	public void setqDate(String qDate) {
		this.qDate = qDate;
	}
	/**
	 * @return the prDate
	 */
	public String getPrDate() {
		return prDate;
	}
	/**
	 * @param prDate the prDate to set
	 */
	public void setPrDate(String prDate) {
		this.prDate = prDate;
	}
	/**
	 * @return the prNo
	 */
	public String getPrNo() {
		return prNo;
	}
	/**
	 * @param prNo the prNo to set
	 */
	public void setPrNo(String prNo) {
		this.prNo = prNo;
	}
	/**
	 * @return the materialId
	 */
	public String getMaterialId() {
		return materialId;
	}
	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	/**
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 * @return the purchaseOrderId
	 */
	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}
	/**
	 * @param purchaseOrderId the purchaseOrderId to set
	 */
	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	
	public String getrNo() {
		return rNo;
	}
	public void setrNo(String rNo) {
		this.rNo = rNo;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	
	

}
