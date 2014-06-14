/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 28-11-2013
 */
public class StockTransferBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int stId;
	private int EditstId;
	private int stockTransferId;
	private String stockTransferNo;
	private String stockTransferDate;
	private String orgId;
	private String plantId;
	private String storageLocationId;
	private String toOrgId;
	private String toPlantId;
	private String toStorageLocationId;
	
	private List<StockTransferLineBean> stockTransferLine;
	private Organization orgBean;
	private Plant plantBean;
	private StorageLocation storLocBean;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String material_Id;
	private String uom_Id;
	private String storLoc_Id;
	private String ematerial_Id;
	private String euom_Id;
	private String estorLoc_Id;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	//Child Variables
	private int[] stockTransferLineId;
	private String[] materialId;
	private String[] UOMId;
	private String[] StorageLocation_Id;
	private String[] quantity;
	private String[] batchNo;
	private String avalQty;
	
	//Edit Variables
	private int estockTransferId;
	private String estockTransferNo;
	private String estockTransferDate;
	private String eorgId;
	private String eplantId;
	private String estorageLocationId;
	private String etoOrgId;
	private String etoPlantId;
	private String etoStorageLocationId;
	
	//Edit Child variables
	private int[] estockTransferLineId;
	private String[] ematerialId;
	private String[] eUOMId;
	private String[] eStorageLocation_Id;
	private String[] equantity;
	private String[] ebatchNo;
	private String ebatchName;
	private String  ematerialName;
	private String euomName;
	private String estorLocName;
	
	//Setter And Getter Methods
	
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	public int getStockTransferId() {
		return stockTransferId;
	}
	public String getEmaterial_Id() {
		return ematerial_Id;
	}
	public String getEuom_Id() {
		return euom_Id;
	}
	public String getEstorLoc_Id() {
		return estorLoc_Id;
	}
	public void setEmaterial_Id(String ematerial_Id) {
		this.ematerial_Id = ematerial_Id;
	}
	public String getAvalQty() {
		return avalQty;
	}
	public void setAvalQty(String avalQty) {
		this.avalQty = avalQty;
	}
	public void setEuom_Id(String euom_Id) {
		this.euom_Id = euom_Id;
	}
	public void setEstorLoc_Id(String estorLoc_Id) {
		this.estorLoc_Id = estorLoc_Id;
	}
	public void setStockTransferId(int stockTransferId) {
		this.stockTransferId = stockTransferId;
	}
	public String getStockTransferNo() {
		return stockTransferNo;
	}
	public void setStockTransferNo(String stockTransferNo) {
		this.stockTransferNo = stockTransferNo;
	}
	public String getStockTransferDate() {
		return stockTransferDate;
	}
	public void setStockTransferDate(String stockTransferDate) {
		this.stockTransferDate = stockTransferDate;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getPlantId() {
		return plantId;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public String getStorageLocationId() {
		return storageLocationId;
	}
	public String[] getBatchNo() {
		return batchNo;
	}
	public String[] getEbatchNo() {
		return ebatchNo;
	}
	public String getEbatchName() {
		return ebatchName;
	}
	public void setBatchNo(String[] batchNo) {
		this.batchNo = batchNo;
	}
	public void setEbatchNo(String[] ebatchNo) {
		this.ebatchNo = ebatchNo;
	}
	public void setEbatchName(String ebatchName) {
		this.ebatchName = ebatchName;
	}
	public void setStorageLocationId(String storageLocationId) {
		this.storageLocationId = storageLocationId;
	}
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public int getEditstId() {
		return EditstId;
	}
	public void setEditstId(int editstId) {
		EditstId = editstId;
	}
	public String getToOrgId() {
		return toOrgId;
	}
	public void setToOrgId(String toOrgId) {
		this.toOrgId = toOrgId;
	}
	public String getStorLoc_Id() {
		return storLoc_Id;
	}
	public void setStorLoc_Id(String storLoc_Id) {
		this.storLoc_Id = storLoc_Id;
	}
	public String getToPlantId() {
		return toPlantId;
	}
	public void setToPlantId(String toPlantId) {
		this.toPlantId = toPlantId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMaterial_Id() {
		return material_Id;
	}
	public String getUom_Id() {
		return uom_Id;
	}
	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}
	public int[] getEstockTransferLineId() {
		return estockTransferLineId;
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
	public String[] getEmaterialId() {
		return ematerialId;
	}
	public String[] geteUOMId() {
		return eUOMId;
	}
	public String[] geteStorageLocation_Id() {
		return eStorageLocation_Id;
	}
	public String[] getEquantity() {
		return equantity;
	}
	public void setEstockTransferLineId(int[] estockTransferLineId) {
		this.estockTransferLineId = estockTransferLineId;
	}
	public void setEmaterialId(String[] ematerialId) {
		this.ematerialId = ematerialId;
	}
	public void seteUOMId(String[] eUOMId) {
		this.eUOMId = eUOMId;
	}
	public void seteStorageLocation_Id(String[] eStorageLocation_Id) {
		this.eStorageLocation_Id = eStorageLocation_Id;
	}
	public void setEquantity(String[] equantity) {
		this.equantity = equantity;
	}
	public int getEstockTransferId() {
		return estockTransferId;
	}
	public String getEstockTransferNo() {
		return estockTransferNo;
	}
	public String getEstockTransferDate() {
		return estockTransferDate;
	}
	public String getEorgId() {
		return eorgId;
	}
	public String getEplantId() {
		return eplantId;
	}
	public String getEstorageLocationId() {
		return estorageLocationId;
	}
	public String getEtoOrgId() {
		return etoOrgId;
	}
	public String getEtoPlantId() {
		return etoPlantId;
	}
	public String getEtoStorageLocationId() {
		return etoStorageLocationId;
	}
	public void setEstockTransferId(int estockTransferId) {
		this.estockTransferId = estockTransferId;
	}
	public void setEstockTransferNo(String estockTransferNo) {
		this.estockTransferNo = estockTransferNo;
	}
	public void setEstockTransferDate(String estockTransferDate) {
		this.estockTransferDate = estockTransferDate;
	}
	public void setEorgId(String eorgId) {
		this.eorgId = eorgId;
	}
	public void setEplantId(String eplantId) {
		this.eplantId = eplantId;
	}
	public void setEstorageLocationId(String estorageLocationId) {
		this.estorageLocationId = estorageLocationId;
	}
	public void setEtoOrgId(String etoOrgId) {
		this.etoOrgId = etoOrgId;
	}
	public void setEtoPlantId(String etoPlantId) {
		this.etoPlantId = etoPlantId;
	}
	public void setEtoStorageLocationId(String etoStorageLocationId) {
		this.etoStorageLocationId = etoStorageLocationId;
	}
	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
	}
	public String getToStorageLocationId() {
		return toStorageLocationId;
	}
	public void setToStorageLocationId(String toStorageLocationId) {
		this.toStorageLocationId = toStorageLocationId;
	}
	public String[] getStorageLocation_Id() {
		return StorageLocation_Id;
	}
	public void setStorageLocation_Id(String[] storageLocation_Id) {
		this.StorageLocation_Id = storageLocation_Id;
	}
	public Organization getOrgBean() {
		return orgBean;
	}
	public void setOrgBean(Organization orgBean) {
		this.orgBean = orgBean;
	}
	public int[] getStockTransferLineId() {
		return stockTransferLineId;
	}
	public void setStockTransferLineId(int[] stockTransferLineId) {
		this.stockTransferLineId = stockTransferLineId;
	}
	public String[] getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String[] materialId) {
		this.materialId = materialId;
	}
	public String[] getUOMId() {
		return UOMId;
	}
	public void setUOMId(String[] uOMId) {
		UOMId = uOMId;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
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
	public Plant getPlantBean() {
		return plantBean;
	}
	public void setPlantBean(Plant plantBean) {
		this.plantBean = plantBean;
	}
	public StorageLocation getStorLocBean() {
		return storLocBean;
	}
	public void setStorLocBean(StorageLocation storLocBean) {
		this.storLocBean = storLocBean;
	}
	public List<StockTransferLineBean> getStockTransferLine() {
		return stockTransferLine;
	}
	public String getLabels() {
		return labels;
	}
	public String getDbField() {
		return dbField;
	}
	public String getAsOpts() {
		return asOpts;
	}
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	public void setDbField(String dbField) {
		this.dbField = dbField;
	}
	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}
	public void setStockTransferLine(List<StockTransferLineBean> stockTransferLine) {
		this.stockTransferLine = stockTransferLine;
	}

}
