/**
 *@Copyright MNTSOFT    
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Naresh
 * @version 1.0 14-11-2013
 * 
 */
public class SalesQuotationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sqId;
	private int EditsqId;
	private int salesQuotationId;
	private String salesQuotationNo;
	private String customerId;
	private String salesInquiryId;
	private String salesQuotationDate;
	private String description;
	private int statusId;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;

	private Set<SalesQuotationLineBean> salesQuotationLineBean;
	private CustomerBean custBean;
	/*private SalesInquiryBean salesInquiryBean;*/

	private String currency_Id;
	private String uom_Id;
	private String material_Id;
	private String materialName;
	private String uomName;
	private String currencyName;
	
	private String ecurrency_Id;
	private String euom_Id;
	private String ematerial_Id;
	private String ematerialName;
	private String euomName;
	private String ecurrencyName;
	
	private int esalesQuotationId;
	private String esalesQuotationNo;
	private String ecustomerId;
	private String esalesInquiryId;
	private String esalesQuotationDate;
	private String edescription;
	private int estatusId;

	// Child variables
	private int[] salesQuotationLineId;
	private int[] salesQuotation_Id;
	private String[] materialId;
	private String[] quantity;
	private String[] UOMId;
	private String[] currencyId;
	private String[] requiredDate;
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

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
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

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	private String[] deliveryDate;
	private int[] perUnit;
	private float[] netPrice;
	private float[] lineAmount;
	
	//Edit child Variables
	private int[] esalesQuotationLineId;
	private int[] esalesQuotation_Id;
	private String[] ematerialId;
	private String[] equantity;
	private String[] eUOMId;
	private String[] ecurrencyId;
	private String[] erequiredDate;
	private String[] edeliveryDate;
	private int[] eperUnit;
	private float[] enetPrice;
	
	// Setter And Getter Methods
	
	public String getEmaterialName() {
		return ematerialName;
	}

	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}

	public String getEuomName() {
		return euomName;
	}

	public void setEuomName(String euomName) {
		this.euomName = euomName;
	}

	public String getEcurrencyName() {
		return ecurrencyName;
	}

	public void setEcurrencyName(String ecurrencyName) {
		this.ecurrencyName = ecurrencyName;
	}

	
	public String getEcurrency_Id() {
		return ecurrency_Id;
	}

	public void setEcurrency_Id(String ecurrency_Id) {
		this.ecurrency_Id = ecurrency_Id;
	}

	public String getEuom_Id() {
		return euom_Id;
	}

	public void setEuom_Id(String euom_Id) {
		this.euom_Id = euom_Id;
	}

	public String getEmaterial_Id() {
		return ematerial_Id;
	}

	public void setEmaterial_Id(String ematerial_Id) {
		this.ematerial_Id = ematerial_Id;
	}

	private float[] elineAmount;


	public int getEditsqId() {
		return EditsqId;
	}

	public void setEditsqId(int editsqId) {
		EditsqId = editsqId;
	}

	public int getSqId() {
		return sqId;
	}

	public void setSqId(int sqId) {
		this.sqId = sqId;
	}

	public int getSalesQuotationId() {
		return salesQuotationId;
	}

	public void setSalesQuotationId(int salesQuotationId) {
		this.salesQuotationId = salesQuotationId;
	}

	public String getSalesQuotationNo() {
		return salesQuotationNo;
	}

	public void setSalesQuotationNo(String salesQuotationNo) {
		this.salesQuotationNo = salesQuotationNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSalesInquiryId() {
		return salesInquiryId;
	}

	public void setSalesInquiryId(String salesInquiryId) {
		this.salesInquiryId = salesInquiryId;
	}

	public String getSalesQuotationDate() {
		return salesQuotationDate;
	}

	public void setSalesQuotationDate(String salesQuotationDate) {
		this.salesQuotationDate = salesQuotationDate;
	}

	public String getDescription() {
		return description;
	}

	public Set<SalesQuotationLineBean> getSalesQuotationLineBean() {
		return salesQuotationLineBean;
	}

	public void setSalesQuotationLineBean(
			Set<SalesQuotationLineBean> salesQuotationLineBean) {
		this.salesQuotationLineBean = salesQuotationLineBean;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEsalesQuotationId() {
		return esalesQuotationId;
	}

	public void setEsalesQuotationId(int esalesQuotationId) {
		this.esalesQuotationId = esalesQuotationId;
	}

	public String getEsalesQuotationNo() {
		return esalesQuotationNo;
	}

	public void setEsalesQuotationNo(String esalesQuotationNo) {
		this.esalesQuotationNo = esalesQuotationNo;
	}

	public String getEcustomerId() {
		return ecustomerId;
	}

	public void setEcustomerId(String ecustomerId) {
		this.ecustomerId = ecustomerId;
	}

	public String getEsalesInquiryId() {
		return esalesInquiryId;
	}

	public void setEsalesInquiryId(String esalesInquiryId) {
		this.esalesInquiryId = esalesInquiryId;
	}

	public int[] getEsalesQuotationLineId() {
		return esalesQuotationLineId;
	}

	public void setEsalesQuotationLineId(int[] esalesQuotationLineId) {
		this.esalesQuotationLineId = esalesQuotationLineId;
	}

	public int[] getEsalesQuotation_Id() {
		return esalesQuotation_Id;
	}

	public void setEsalesQuotation_Id(int[] esalesQuotation_Id) {
		this.esalesQuotation_Id = esalesQuotation_Id;
	}

	public String[] getEmaterialId() {
		return ematerialId;
	}

	public void setEmaterialId(String[] ematerialId) {
		this.ematerialId = ematerialId;
	}

	public String[] getEquantity() {
		return equantity;
	}

	public void setEquantity(String[] equantity) {
		this.equantity = equantity;
	}

	public String[] geteUOMId() {
		return eUOMId;
	}

	public void seteUOMId(String[] eUOMId) {
		this.eUOMId = eUOMId;
	}

	public String[] getEcurrencyId() {
		return ecurrencyId;
	}

	public void setEcurrencyId(String[] ecurrencyId) {
		this.ecurrencyId = ecurrencyId;
	}

	public String[] getErequiredDate() {
		return erequiredDate;
	}

	public void setErequiredDate(String[] erequiredDate) {
		this.erequiredDate = erequiredDate;
	}

	public String[] getEdeliveryDate() {
		return edeliveryDate;
	}

	public void setEdeliveryDate(String[] edeliveryDate) {
		this.edeliveryDate = edeliveryDate;
	}

	public int[] getEperUnit() {
		return eperUnit;
	}

	public void setEperUnit(int[] eperUnit) {
		this.eperUnit = eperUnit;
	}

	public float[] getEnetPrice() {
		return enetPrice;
	}

	public void setEnetPrice(float[] enetPrice) {
		this.enetPrice = enetPrice;
	}

	public float[] getElineAmount() {
		return elineAmount;
	}

	public void setElineAmount(float[] elineAmount) {
		this.elineAmount = elineAmount;
	}

	public String getEsalesQuotationDate() {
		return esalesQuotationDate;
	}

	public void setEsalesQuotationDate(String esalesQuotationDate) {
		this.esalesQuotationDate = esalesQuotationDate;
	}

	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	public int getEstatusId() {
		return estatusId;
	}

	public void setEstatusId(int estatusId) {
		this.estatusId = estatusId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getCurrency_Id() {
		return currency_Id;
	}

	public void setCurrency_Id(String currency_Id) {
		this.currency_Id = currency_Id;
	}

	public String getUom_Id() {
		return uom_Id;
	}

	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
	}

	public String getMaterial_Id() {
		return material_Id;
	}

	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}

	public CustomerBean getCustBean() {
		return custBean;
	}

	public void setCustBean(CustomerBean custBean) {
		this.custBean = custBean;
	}

	/*public SalesInquiryBean getSalesInquiryBean() {
		return salesInquiryBean;
	}

	public void setSalesInquiryBean(SalesInquiryBean salesInquiryBean) {
		this.salesInquiryBean = salesInquiryBean;
	}
*/
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

	public int[] getSalesQuotationLineId() {
		return salesQuotationLineId;
	}

	public void setSalesQuotationLineId(int[] salesQuotationLineId) {
		this.salesQuotationLineId = salesQuotationLineId;
	}

	public int[] getSalesQuotation_Id() {
		return salesQuotation_Id;
	}

	public void setSalesQuotation_Id(int[] salesQuotation_Id) {
		this.salesQuotation_Id = salesQuotation_Id;
	}

	public String[] getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String[] materialId) {
		this.materialId = materialId;
	}

	public String[] getQuantity() {
		return quantity;
	}

	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}

	public String[] getUOMId() {
		return UOMId;
	}

	public void setUOMId(String[] uOMId) {
		UOMId = uOMId;
	}

	public String[] getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String[] currencyId) {
		this.currencyId = currencyId;
	}

	public String[] getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String[] requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String[] getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String[] deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int[] getPerUnit() {
		return perUnit;
	}

	public void setPerUnit(int[] perUnit) {
		this.perUnit = perUnit;
	}

	public float[] getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(float[] netPrice) {
		this.netPrice = netPrice;
	}

	public float[] getLineAmount() {
		return lineAmount;
	}

	public void setLineAmount(float[] lineAmount) {
		this.lineAmount = lineAmount;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
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

}
