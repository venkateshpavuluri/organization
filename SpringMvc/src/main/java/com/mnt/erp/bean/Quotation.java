/**
  

 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 */

public class Quotation  {

	/* ============================Bean Properties======================= */
	private int quotationId;
	private String quotationNo;
	private String vendorId;
	private String rfqid;
	private String quotationDate;
	private String description;
	private String quotStatusId;
	private String status;
	private String vendorname;	
	private int aid;
	private int checkChildData;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	

	private int quotationLineId;
	private String[] material_Id;
	private String mId;
	private Integer[] quantity;
	private String[] uom;
	private String uomm;
	private Float[] netPrice;
	private Integer[] perUnit;
	private Float[] lineAmount;
	private String[] currencyId;
	private String cId;
	private String[] deliveryDate;
	private String[] plantId;
	private String pId;
	private String[] statusId; 
	private String stId;
	private String[] storageLocId;
	private String stLId;
	
	
	/* ============================= Edit Properties======================================*/

	private int quotationIdEditt;
	private String quotationNoEditt;
	private String vendorIdEditt;
	private String rfqidEditt;
	
	private String quotationDateEditt;
	public int getCheckChildData() {
		return checkChildData;
	}

	public void setCheckChildData(int checkChildData) {
		this.checkChildData = checkChildData;
	}

	private String descriptionEditt;
	private String quotStatusIdEditt;

	private int[] quotationLineIdEditt;
	private String[] material_IdEditt;
	private String mIdEditt;
	private Integer[] quantityEditt;
	private String[] uomEditt;
	private String uommEditt;
	private Float[] netPriceEditt;
	private Integer[] perUnitEditt;
	private Float[] lineAmountEditt;
	private String[] currencyIdEditt;
	private String cIdEditt;
	private String[] deliveryDateEditt;
	private String[] plantIdEditt;
	private String pIdEditt;
	private String[] statusIdEditt;
	private String stIdEditt;
	private String[] storageLocIdEditt;
	private String stLIdEditt;
	
	
	/*==============================Extra========================*/

	private String materialName;
	private String plantName;
	private String uomName;
	private String currencyName;
	private String stlocName;
	private String statusName;
	
	
	private Vendor vendorBean;
	private Status statusBean;
	
	
	/*==============================Advance Search======================*/
	
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	public Vendor getVendorBean() {
		return vendorBean;
	}

	public void setVendorBean(Vendor vendorBean) {
		this.vendorBean = vendorBean;
	}

	public Status getStatusBean() {
		return statusBean;
	}

	public void setStatusBean(Status statusBean) {
		this.statusBean = statusBean;
	}

	public String getFirstLabel() {
		return firstLabel;
	}

	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	public String getSecondLabel() {
		return secondLabel;
	}

	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}

	public String getOperations1() {
		return operations1;
	}

	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getStlocName() {
		return stlocName;
	}

	public void setStlocName(String stlocName) {
		this.stlocName = stlocName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	/* ====================Child PoJO List============================ */
	private List<QuotationLine> quotationLine;

	public List<QuotationLine> getQuotationLine() {
		return quotationLine;
	}

	public void setQuotationLine(List<QuotationLine> quotationLine) {
		this.quotationLine = quotationLine;
	}

	/* ===============================Getters ========================= */
	
    
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
	public int getAid() {
		return aid;
	}

	public String getStatus() {
		return status;
	}

	public String getVendorname() {
		return vendorname;
	}

	public int getQuotationId() {
		return quotationId;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public String getVendorId() {
		return vendorId;

	}

	
	public String getRfqid() {
		return rfqid;
	}

	public String getQuotationDate() {
		return quotationDate;
	}

	public String getDescription() {
		return description;
	}

	public String getQuotStatusId() {
		return quotStatusId;
	}

	public int getQuotationLineId() {
		return quotationLineId;
	}

	public String[] getMaterial_Id() {
		return material_Id;
	}

	public String[] getUom() {
		return uom;
	}

	public Float[] getNetPrice() {
		return netPrice;
	}

	public Integer[] getQuantity() {
		return quantity;
	}

	public Integer[] getPerUnit() {
		return perUnit;
	}

	public Float[] getLineAmount() {
		return lineAmount;
	}

	public String[] getDeliveryDate() {
		return deliveryDate;
	}

	public String[] getPlantId() {
		return plantId;
	}

	public String[] getStatusId() {
		return statusId;
	}

	public String[] getStorageLocId() {
		return storageLocId;
	}

	public int getQuotationIdEditt() {
		return quotationIdEditt;
	}

	public String getQuotationNoEditt() {
		return quotationNoEditt;
	}

	public String getVendorIdEditt() {
		return vendorIdEditt;
	}

	public String getRfqidEditt() {
		return rfqidEditt;
	}

	public String getQuotationDateEditt() {
		return quotationDateEditt;
	}

	public String getDescriptionEditt() {
		return descriptionEditt;
	}

	public String getQuotStatusIdEditt() {
		return quotStatusIdEditt;
	}

	public String[] getMaterial_IdEditt() {
		return material_IdEditt;
	}

	public String[] getUomEditt() {
		return uomEditt;
	}

	public Float[] getNetPriceEditt() {
		return netPriceEditt;
	}

	public Integer[] getPerUnitEditt() {
		return perUnitEditt;
	}

	public Float[] getLineAmountEditt() {
		return lineAmountEditt;
	}

	public String[] getCurrencyIdEditt() {
		return currencyIdEditt;
	}

	public String[] getDeliveryDateEditt() {
		return deliveryDateEditt;
	}

	public String[] getPlantIdEditt() {
		return plantIdEditt;
	}

	public String[] getStatusIdEditt() {
		return statusIdEditt;
	}

	public String[] getStorageLocIdEditt() {
		return storageLocIdEditt;
	}

	public int[] getQuotationLineIdEditt() {
		return quotationLineIdEditt;
	}

	public Integer[] getQuantityEditt() {
		return quantityEditt;
	}
	public String getmId() {
		return mId;
	}

	public String getUomm() {
		return uomm;
	}

	public String getcId() {
		return cId;
	}

	public String getpId() {
		return pId;
	}

	public String getStId() {
		return stId;
	}

	public String getStLId() {
		return stLId;
	}

	public String getmIdEditt() {
		return mIdEditt;
	}

	public String getUommEditt() {
		return uommEditt;
	}

	public String getcIdEditt() {
		return cIdEditt;
	}

	public String getpIdEditt() {
		return pIdEditt;
	}

	public String getStIdEditt() {
		return stIdEditt;
	}

	public String getStLIdEditt() {
		return stLIdEditt;
	}


	/* ===============================Setters ========================= */

	
	

	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setRfqid(String rfqid) {
		this.rfqid = rfqid;
	}

	public void setQuotationDate(String quotationDate) {
		this.quotationDate = quotationDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuotStatusId(String quotStatusId) {
		this.quotStatusId = quotStatusId;
	}

	public void setQuotationLineId(int quotationLineId) {
		this.quotationLineId = quotationLineId;
	}

	public void setMaterial_Id(String[] material_Id) {
		this.material_Id = material_Id;
	}

	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}

	public void setUom(String[] uom) {
		this.uom = uom;
	}

	public void setNetPrice(Float[] netPrice) {
		this.netPrice = netPrice;
	}

	public void setPerUnit(Integer[] perUnit) {
		this.perUnit = perUnit;
	}

	public void setLineAmount(Float[] lineAmount) {
		this.lineAmount = lineAmount;
	}

	public String[] getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String[] currencyId) {
		this.currencyId = currencyId;
	}

	public void setDeliveryDate(String[] deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setPlantId(String[] plantId) {
		this.plantId = plantId;
	}

	public void setStatusId(String[] statusId) {
		this.statusId = statusId;
	}

	public void setStorageLocId(String[] storageLocId) {
		this.storageLocId = storageLocId;
	}

	public void setQuotationIdEditt(int quotationIdEditt) {
		this.quotationIdEditt = quotationIdEditt;
	}

	public void setQuotationNoEditt(String quotationNoEditt) {
		this.quotationNoEditt = quotationNoEditt;
	}

	public void setVendorIdEditt(String vendorIdEditt) {
		this.vendorIdEditt = vendorIdEditt;
	}

	public void setRfqidEditt(String rfqidEditt) {
		this.rfqidEditt = rfqidEditt;
	}

	public void setQuotationDateEditt(String quotationDateEditt) {
		this.quotationDateEditt = quotationDateEditt;
	}

	public void setDescriptionEditt(String descriptionEditt) {
		this.descriptionEditt = descriptionEditt;
	}

	public void setQuotStatusIdEditt(String quotStatusIdEditt) {
		this.quotStatusIdEditt = quotStatusIdEditt;
	}

	public void setQuotationLineIdEditt(int[] quotationLineIdEditt) {
		this.quotationLineIdEditt = quotationLineIdEditt;
	}

	public void setMaterial_IdEditt(String[] material_IdEditt) {
		this.material_IdEditt = material_IdEditt;
	}

	public void setQuantityEditt(Integer[] quantityEditt) {
		this.quantityEditt = quantityEditt;
	}

	public void setUomEditt(String[] uomEditt) {
		this.uomEditt = uomEditt;
	}

	public void setNetPriceEditt(Float[] netPriceEditt) {
		this.netPriceEditt = netPriceEditt;
	}

	public void setPerUnitEditt(Integer[] perUnitEditt) {
		this.perUnitEditt = perUnitEditt;
	}

	public void setLineAmountEditt(Float[] lineAmountEditt) {
		this.lineAmountEditt = lineAmountEditt;
	}

	public void setCurrencyIdEditt(String[] currencyIdEditt) {
		this.currencyIdEditt = currencyIdEditt;
	}

	public void setDeliveryDateEditt(String[] deliveryDateEditt) {
		this.deliveryDateEditt = deliveryDateEditt;
	}

	public void setPlantIdEditt(String[] plantIdEditt) {
		this.plantIdEditt = plantIdEditt;
	}

	public void setStatusIdEditt(String[] statusIdEditt) {
		this.statusIdEditt = statusIdEditt;
	}

	public void setStorageLocIdEditt(String[] storageLocIdEditt) {
		this.storageLocIdEditt = storageLocIdEditt;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public void setUomm(String uomm) {
		this.uomm = uomm;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public void setStLId(String stLId) {
		this.stLId = stLId;
	}

	public void setmIdEditt(String mIdEditt) {
		this.mIdEditt = mIdEditt;
	}

	public void setUommEditt(String uommEditt) {
		this.uommEditt = uommEditt;
	}

	public void setcIdEditt(String cIdEditt) {
		this.cIdEditt = cIdEditt;
	}

	public void setpIdEditt(String pIdEditt) {
		this.pIdEditt = pIdEditt;
	}

	public void setStIdEditt(String stIdEditt) {
		this.stIdEditt = stIdEditt;
	}

	public void setStLIdEditt(String stLIdEditt) {
		this.stLIdEditt = stLIdEditt;
	}

	
}
