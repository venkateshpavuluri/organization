/**
 *@Copyright MNTSOFT  
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 28-11-2013
 */
public class StockTransferLineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stockTransferLineId;
	private int stockTransferId;
	private String materialId;
	private String UOMId;
	private String StorageLocationId;
	private String quantity;
	private String batchNo;

	private Material material;
	private Uom uom;
	//private StorageLocation storLoc;
	
	//Edit Varibles
	private int estockTransferLineId;
	private int estockTransferId;
	private String ematerialId;
	private String eUOMId;
	private String eStorageLocation_Id;
	private String equantity;
	private String ebatchNo;
	
	private String  ematerialName;
	private String euomName;
	private String estorLocName;
	private String ebatchName;

	// Setter And Getter Methods

	public int getStockTransferLineId() {
		return stockTransferLineId;
	}

	public void setStockTransferLineId(int stockTransferLineId) {
		this.stockTransferLineId = stockTransferLineId;
	}

	public int getStockTransferId() {
		return stockTransferId;
	}

	public void setStockTransferId(int stockTransferId) {
		this.stockTransferId = stockTransferId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUOMId() {
		return UOMId;
	}

	public void setUOMId(String uOMId) {
		UOMId = uOMId;
	}

	public String getStorageLocationId() {
		return StorageLocationId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public void setStorageLocationId(String storageLocationId) {
		StorageLocationId = storageLocationId;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Uom getUom() {
		return uom;
	}

	public int getEstockTransferLineId() {
		return estockTransferLineId;
	}

	public int getEstockTransferId() {
		return estockTransferId;
	}

	public String getEmaterialId() {
		return ematerialId;
	}

	public String geteUOMId() {
		return eUOMId;
	}

	public String geteStorageLocation_Id() {
		return eStorageLocation_Id;
	}

	public String getEquantity() {
		return equantity;
	}

	public String getEbatchNo() {
		return ebatchNo;
	}

	public String getEbatchName() {
		return ebatchName;
	}

	public void setEbatchNo(String ebatchNo) {
		this.ebatchNo = ebatchNo;
	}

	public void setEbatchName(String ebatchName) {
		this.ebatchName = ebatchName;
	}

	public void setEstockTransferLineId(int estockTransferLineId) {
		this.estockTransferLineId = estockTransferLineId;
	}

	public void setEstockTransferId(int estockTransferId) {
		this.estockTransferId = estockTransferId;
	}

	public void setEmaterialId(String ematerialId) {
		this.ematerialId = ematerialId;
	}

	public void seteUOMId(String eUOMId) {
		this.eUOMId = eUOMId;
	}

	public void seteStorageLocation_Id(String eStorageLocation_Id) {
		this.eStorageLocation_Id = eStorageLocation_Id;
	}

	public String getEmaterialName() {
		return ematerialName;
	}

	public String getEuomName() {
		return euomName;
	}

	public String getEstorLocName() {
		return estorLocName;
	}

	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}

	public void setEuomName(String euomName) {
		this.euomName = euomName;
	}

	public void setEstorLocName(String estorLocName) {
		this.estorLocName = estorLocName;
	}

	public void setEquantity(String equantity) {
		this.equantity = equantity;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	/*public StorageLocation getStorLoc() {
		return storLoc;
	}

	public void setStorLoc(StorageLocation storLoc) {
		this.storLoc = storLoc;
	}*/

}
