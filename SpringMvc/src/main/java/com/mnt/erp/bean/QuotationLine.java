/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 *
 */
public class QuotationLine 
{
	/*======================Bean Properties=====================*/
	private int quotationLineId; 
	private int quotationId;
	private String material_Id;
	private int quantity;
	private String uom;
	private float netPrice;
	private int perUnit;
	private float  lineAmount;
	private String currencyId;
	private String deliveryDate;
	private String plantId;
	private String statusId;
	private String storageLocId;
	 private Material material;
	 private Uom uomName1;
	 private Currency currencyName1;
	 
	
	/*=======================Edit Properties====================*/
	private int quotationLineIdEditt; 
	private int quotationIdEditt;
	private String material_IdEditt;
	private int quantityEditt;
	private String uomEditt;
	private float netPriceEditt;
	private int perUnitEditt;
	private float  lineAmountEditt;
	private String currencyIdEditt;
	private String deliveryDateEditt;
	private String plantIdEditt;
	private String statusIdEditt;
	private String storageLocIdEditt;
	
	/*=================OtherObjects*========================/
	 * 
	 */
	
	private Material materialDetails;
	private String materialName;
	private Plant plantDetails;
	
	private Uom uomDetails;
	private String plantName;
	private String uomName;
	private String currencyName;
	private String stlocName;
	private String statusName;
	
	private Currency currencyDetails;
	
	private StorageLocation stLocDetails;
	
	private Status statusDetails;
	
	
	/*==================For Json Data In Purchase Order===============*/
	
   private 	int count;
   private float total;
   private float totalEdit;
   private int vendorIdForJson;

	
	/*=================Getters========================================*/
	
	public int getQuotationLineId() {
		return quotationLineId;
	}
	public Plant getPlantDetails() {
		return plantDetails;
	}
	public void setPlantDetails(Plant plantDetails) {
		this.plantDetails = plantDetails;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public Uom getUomDetails() {
		return uomDetails;
	}
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}
	public String getUomName() {
		return uomName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public Currency getCurrencyDetails() {
		return currencyDetails;
	}
	public void setCurrencyDetails(Currency currencyDetails) {
		this.currencyDetails = currencyDetails;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public StorageLocation getStLocDetails() {
		return stLocDetails;
	}
	public void setStLocDetails(StorageLocation stLocDetails) {
		this.stLocDetails = stLocDetails;
	}
	public String getStlocName() {
		return stlocName;
	}
	public void setStlocName(String stlocName) {
		this.stlocName = stlocName;
	}
	public Status getStatusDetails() {
		return statusDetails;
	}
	public void setStatusDetails(Status statusDetails) {
		this.statusDetails = statusDetails;
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
	public Material getMaterialDetails() {
		return materialDetails;
	}
	public void setMaterialDetails(Material materialDetails) {
		this.materialDetails = materialDetails;
	}
	public int getQuotationId() {
		return quotationId;
	}
	public String getMaterial_Id() {
		return material_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getUom() {
		return uom;
	}
	public float getNetPrice() {
		return netPrice;
	}
	public int getPerUnit() {
		return perUnit;
	}
	public float getLineAmount() {
		return lineAmount;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public String getPlantId() {
		return plantId;
	}
	public String getStatusId() {
		return statusId;
	}
	public String getStorageLocId() {
		return storageLocId;
	}
	public int getQuotationLineIdEditt() {
		return quotationLineIdEditt;
	}
	public int getQuotationIdEditt() {
		return quotationIdEditt;
	}
	public String getMaterial_IdEditt() {
		return material_IdEditt;
	}
	public int getQuantityEditt() {
		return quantityEditt;
	}
	public String getUomEditt() {
		return uomEditt;
	}
	public float getNetPriceEditt() {
		return netPriceEditt;
	}
	public int getPerUnitEditt() {
		return perUnitEditt;
	}
	public float getLineAmountEditt() {
		return lineAmountEditt;
	}
	public String getCurrencyIdEditt() {
		return currencyIdEditt;
	}
	public String getDeliveryDateEditt() {
		return deliveryDateEditt;
	}
	public String getPlantIdEditt() {
		return plantIdEditt;
	}
	public String getStatusIdEditt() {
		return statusIdEditt;
	}
	public String getStorageLocIdEditt() {
		return storageLocIdEditt;
	}

		/*=====================================Setters===================================*/
	public void setQuotationLineId(int quotationLineId) {
		this.quotationLineId = quotationLineId;
	}
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}
	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public void setNetPrice(float netPrice) {
		this.netPrice = netPrice;
	}
	public void setPerUnit(int perUnit) {
		this.perUnit = perUnit;
	}
	public void setLineAmount(float lineAmount) {
		this.lineAmount = lineAmount;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public void setStorageLocId(String storageLocId) {
		this.storageLocId = storageLocId;
	}
	public void setQuotationLineIdEditt(int quotationLineIdEditt) {
		this.quotationLineIdEditt = quotationLineIdEditt;
	}
	public void setQuotationIdEditt(int quotationIdEditt) {
		this.quotationIdEditt = quotationIdEditt;
	}
	public void setMaterial_IdEditt(String material_IdEditt) {
		this.material_IdEditt = material_IdEditt;
	}
	public void setQuantityEditt(int quantityEditt) {
		this.quantityEditt = quantityEditt;
	}
	public void setUomEditt(String uomEditt) {
		this.uomEditt = uomEditt;
	}
	public void setNetPriceEditt(float netPriceEditt) {
		this.netPriceEditt = netPriceEditt;
	}
	public void setPerUnitEditt(int perUnitEditt) {
		this.perUnitEditt = perUnitEditt;
	}
	public void setLineAmountEditt(float lineAmountEditt) {
		this.lineAmountEditt = lineAmountEditt;
	}
	public void setCurrencyIdEditt(String currencyIdEditt) {
		this.currencyIdEditt = currencyIdEditt;
	}
	public void setDeliveryDateEditt(String deliveryDateEditt) {
		this.deliveryDateEditt = deliveryDateEditt;
	}
	public void setPlantIdEditt(String plantIdEditt) {
		this.plantIdEditt = plantIdEditt;
	}
	public void setStatusIdEditt(String statusIdEditt) {
		this.statusIdEditt = statusIdEditt;
	}
	public void setStorageLocIdEditt(String storageLocIdEditt) {
		this.storageLocIdEditt = storageLocIdEditt;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Uom getUomName1() {
		return uomName1;
	}
	public void setUomName1(Uom uomName1) {
		this.uomName1 = uomName1;
	}
	public Currency getCurrencyName1() {
		return currencyName1;
	}
	public void setCurrencyName1(Currency currencyName1) {
		this.currencyName1 = currencyName1;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getTotalEdit() {
		return totalEdit;
	}
	public void setTotalEdit(float totalEdit) {
		this.totalEdit = totalEdit;
	}
	public int getVendorIdForJson() {
		return vendorIdForJson;
	}
	public void setVendorIdForJson(int vendorIdForJson) {
		this.vendorIdForJson = vendorIdForJson;
	}
		
	
}
