/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class physicalVerificationLine {
	
	private int verificationId;
	private int verificationLineId; 
 	private String materialId; 
 	private String batchNo; 
 	private String bookQty; 
 	private String physicalQty;
 	private String uomId;
 	private Material materialDetails;
 	private Uom uomDetails;
 	
	private String materialName; 
	private String uomName;
	private int count;
 	
 	
 	
 	
	/**
	 * @return the verificationLineId
	 */
	public int getVerificationLineId() {
		return verificationLineId;
	}
	/**
	 * @param verificationLineId the verificationLineId to set
	 */
	public void setVerificationLineId(int verificationLineId) {
		this.verificationLineId = verificationLineId;
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
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}
	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	/**
	 * @return the bookQty
	 */
	public String getBookQty() {
		return bookQty;
	}
	/**
	 * @param bookQty the bookQty to set
	 */
	public void setBookQty(String bookQty) {
		this.bookQty = bookQty;
	}
	/**
	 * @return the physicalQty
	 */
	public String getPhysicalQty() {
		return physicalQty;
	}
	/**
	 * @param physicalQty the physicalQty to set
	 */
	public void setPhysicalQty(String physicalQty) {
		this.physicalQty = physicalQty;
	}
	/**
	 * @return the uomId
	 */
	public String getUomId() {
		return uomId;
	}
	/**
	 * @param uomId the uomId to set
	 */
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	/**
	 * @return the materialDetails
	 */
	public Material getMaterialDetails() {
		return materialDetails;
	}
	/**
	 * @param materialDetails the materialDetails to set
	 */
	public void setMaterialDetails(Material materialDetails) {
		this.materialDetails = materialDetails;
	}
	/**
	 * @return the uomDetails
	 */
	public Uom getUomDetails() {
		return uomDetails;
	}
	/**
	 * @param uomDetails the uomDetails to set
	 */
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}
	/**
	 * @return the verificationId
	 */
	public int getVerificationId() {
		return verificationId;
	}
	/**
	 * @param verificationId the verificationId to set
	 */
	public void setVerificationId(int verificationId) {
		this.verificationId = verificationId;
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
	 * @return the uomName
	 */
	public String getUomName() {
		return uomName;
	}
	/**
	 * @param uomName the uomName to set
	 */
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
 	
 	
 	
 	
 	

}
