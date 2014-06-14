/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Naresh
 *  @version 1.0 03-12-2013
 */
public class SalesPurchaseOrderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int spoId;
	private int EditspoId;
	private int salesPOId;
	private String salesPONbr;
	private String salesPODate;
	private String salesPOValue;
	private String statusId;
	private String description;
	private String customerId;
	private String salesQuotationId;
	private String paymentTermId;
	private String memo;
	private String currencyId;
	private String salesTaxAmount;
	private String VATAmount;
	private String exiciseAmount;
	private String frieghtCharges;
	private String PnFCharges;
	private String dueDate;
	private String createdBy;
	private String createdDTTM;
	private String modifiedBy;
	private Date modifiedDTTM;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	private List<SalesPOLineBean> salesPOLine;
	private CustomerBean custBean;
	private PaymentTerms paymentTerm;
	private SalesQuotationBean salesQuotation;
	private Status status;
	private Currency currency;
	
	private String material_Id;
	private String uom_Id;
	private String currency_Id;
	private String materialName;
	private String uomName;
	private String CurrencyName;
	
	//Child Variables
	private String[] materialId;
	private String[] curId;
	private String[] UOMId;
	private String[] quantity;
	private String[] unitPrice;
	private String[] lineAmount;
	private String[] dueDateChild;
	
	//Child Edit Variables
	private int[] esalesPOLineId;
	private String[] ematerialId;
	private String[] ecurId;
	private String[] eUOMId;
	private String[] equantity;
	private String[] eunitPrice;
	private String[] elineAmount;
	private String[] edueDateChild;
	
	//Edit Variables
	private int esalesPOId;
	private String esalesPONbr;
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
	private String esalesPODate;
	private String esalesPOValue;
	private String estatusId;
	private String edescription;
	private String ecustomerId;
	private String esalesQuotationId;
	private String epaymentTermId;
	private String ememo;
	private String ecurrencyId;
	private String esalesTaxAmount;
	private String eVATAmount;
	private String eexiciseAmount;
	private String efrieghtCharges;
	private String ePnFCharges;
	private String edueDate;
	private String ecreatedBy;
	private String ecreatedDTTM;
	private String emodifiedBy;
	private Date emodifiedDTTM;
	
	private String ematerial_Id;
	private String euom_Id;
	private String ecurrency_Id;
	private String ematerialName;
	private String euomName;
	private String ecurrencyName;
	
	// Setter And Getter Methods
	
	public int getSpoId() {
		return spoId;
	}
	public int getEditspoId() {
		return EditspoId;
	}
	public void setSpoId(int spoId) {
		this.spoId = spoId;
	}
	public void setEditspoId(int editspoId) {
		EditspoId = editspoId;
	}
	
	public int getSalesPOId() {
		return salesPOId;
	}
	public String getSalesPONbr() {
		return salesPONbr;
	}
	public String getSalesPODate() {
		return salesPODate;
	}
	public String getSalesPOValue() {
		return salesPOValue;
	}
	public String getStatusId() {
		return statusId;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public String getCustomerId() {
		return customerId;
	}
	public String getSalesQuotationId() {
		return salesQuotationId;
	}
	public String getPaymentTermId() {
		return paymentTermId;
	}
	public String getMemo() {
		return memo;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public String getSalesTaxAmount() {
		return salesTaxAmount;
	}
	public String getVATAmount() {
		return VATAmount;
	}
	public String getExiciseAmount() {
		return exiciseAmount;
	}
	public int[] getEsalesPOLineId() {
		return esalesPOLineId;
	}
	public void setEsalesPOLineId(int[] esalesPOLineId) {
		this.esalesPOLineId = esalesPOLineId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public String getUomName() {
		return uomName;
	}
	public String getCurrencyName() {
		return CurrencyName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}
	public String getEmaterialName() {
		return ematerialName;
	}
	public String getEuomName() {
		return euomName;
	}
	public String getEcurrencyName() {
		return ecurrencyName;
	}
	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}
	public void setEuomName(String euomName) {
		this.euomName = euomName;
	}
	public void setEcurrencyName(String ecurrencyName) {
		this.ecurrencyName = ecurrencyName;
	}
	public String[] getMaterialId() {
		return materialId;
	}
	public String[] getCurId() {
		return curId;
	}
	public String[] getUOMId() {
		return UOMId;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public String[] getUnitPrice() {
		return unitPrice;
	}
	public String[] getLineAmount() {
		return lineAmount;
	}
	public String[] getDueDateChild() {
		return dueDateChild;
	}
	public void setMaterialId(String[] materialId) {
		this.materialId = materialId;
	}
	public void setCurId(String[] curId) {
		this.curId = curId;
	}
	public void setUOMId(String[] uOMId) {
		UOMId = uOMId;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public void setUnitPrice(String[] unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setLineAmount(String[] lineAmount) {
		this.lineAmount = lineAmount;
	}
	public void setDueDateChild(String[] dueDateChild) {
		this.dueDateChild = dueDateChild;
	}
	public String getFrieghtCharges() {
		return frieghtCharges;
	}
	public String getPnFCharges() {
		return PnFCharges;
	}
	public String getDueDate() {
		return dueDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public List<SalesPOLineBean> getSalesPOLine() {
		return salesPOLine;
	}
	public void setSalesPOLine(List<SalesPOLineBean> salesPOLine) {
		this.salesPOLine = salesPOLine;
	}
	public String getCreatedDTTM() {
		return createdDTTM;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public String getMaterial_Id() {
		return material_Id;
	}
	public String getUom_Id() {
		return uom_Id;
	}
	public String getCurrency_Id() {
		return currency_Id;
	}
	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}
	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
	}
	public void setCurrency_Id(String currency_Id) {
		this.currency_Id = currency_Id;
	}
	public Date getModifiedDTTM() {
		return modifiedDTTM;
	}
	public void setSalesPOId(int salesPOId) {
		this.salesPOId = salesPOId;
	}
	public void setSalesPONbr(String salesPONbr) {
		this.salesPONbr = salesPONbr;
	}
	public void setSalesPODate(String salesPODate) {
		this.salesPODate = salesPODate;
	}
	public String getXmlLabel() {
		return xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	public void setSalesPOValue(String salesPOValue) {
		this.salesPOValue = salesPOValue;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public CustomerBean getCustBean() {
		return custBean;
	}
	public PaymentTerms getPaymentTerm() {
		return paymentTerm;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setCustBean(CustomerBean custBean) {
		this.custBean = custBean;
	}
	public void setPaymentTerm(PaymentTerms paymentTerm) {
		this.paymentTerm = paymentTerm;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setSalesQuotationId(String salesQuotationId) {
		this.salesQuotationId = salesQuotationId;
	}
	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public void setSalesTaxAmount(String salesTaxAmount) {
		this.salesTaxAmount = salesTaxAmount;
	}
	public void setVATAmount(String vATAmount) {
		VATAmount = vATAmount;
	}
	public void setExiciseAmount(String exiciseAmount) {
		this.exiciseAmount = exiciseAmount;
	}
	public void setFrieghtCharges(String frieghtCharges) {
		this.frieghtCharges = frieghtCharges;
	}
	public void setPnFCharges(String pnFCharges) {
		PnFCharges = pnFCharges;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	public SalesQuotationBean getSalesQuotation() {
		return salesQuotation;
	}
	public void setSalesQuotation(SalesQuotationBean salesQuotation) {
		this.salesQuotation = salesQuotation;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public void setModifiedDTTM(Date modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}
	public String[] getEmaterialId() {
		return ematerialId;
	}
	public String[] getEcurId() {
		return ecurId;
	}
	public String[] geteUOMId() {
		return eUOMId;
	}
	public String[] getEquantity() {
		return equantity;
	}
	public String[] getEunitPrice() {
		return eunitPrice;
	}
	public String[] getElineAmount() {
		return elineAmount;
	}
	public String[] getEdueDateChild() {
		return edueDateChild;
	}
	public int getEsalesPOId() {
		return esalesPOId;
	}
	public String getEsalesPONbr() {
		return esalesPONbr;
	}
	public String getEsalesPODate() {
		return esalesPODate;
	}
	public String getEsalesPOValue() {
		return esalesPOValue;
	}
	public String getEstatusId() {
		return estatusId;
	}
	public String getEdescription() {
		return edescription;
	}
	public String getEcustomerId() {
		return ecustomerId;
	}
	public String getEsalesQuotationId() {
		return esalesQuotationId;
	}
	public String getEpaymentTermId() {
		return epaymentTermId;
	}
	public String getEmemo() {
		return ememo;
	}
	public String getEcurrencyId() {
		return ecurrencyId;
	}
	public String getEsalesTaxAmount() {
		return esalesTaxAmount;
	}
	public String geteVATAmount() {
		return eVATAmount;
	}
	public String getEexiciseAmount() {
		return eexiciseAmount;
	}
	public String getEfrieghtCharges() {
		return efrieghtCharges;
	}
	public String getePnFCharges() {
		return ePnFCharges;
	}
	public String getEdueDate() {
		return edueDate;
	}
	public String getEcreatedBy() {
		return ecreatedBy;
	}
	public String getEcreatedDTTM() {
		return ecreatedDTTM;
	}
	public String getEmodifiedBy() {
		return emodifiedBy;
	}
	public Date getEmodifiedDTTM() {
		return emodifiedDTTM;
	}
	public String getEmaterial_Id() {
		return ematerial_Id;
	}
	public String getEuom_Id() {
		return euom_Id;
	}
	public String getEcurrency_Id() {
		return ecurrency_Id;
	}
	public void setEmaterialId(String[] ematerialId) {
		this.ematerialId = ematerialId;
	}
	public void setEcurId(String[] ecurId) {
		this.ecurId = ecurId;
	}
	public void seteUOMId(String[] eUOMId) {
		this.eUOMId = eUOMId;
	}
	public void setEquantity(String[] equantity) {
		this.equantity = equantity;
	}
	public void setEunitPrice(String[] eunitPrice) {
		this.eunitPrice = eunitPrice;
	}
	public void setElineAmount(String[] elineAmount) {
		this.elineAmount = elineAmount;
	}
	public void setEdueDateChild(String[] edueDateChild) {
		this.edueDateChild = edueDateChild;
	}
	public void setEsalesPOId(int esalesPOId) {
		this.esalesPOId = esalesPOId;
	}
	public void setEsalesPONbr(String esalesPONbr) {
		this.esalesPONbr = esalesPONbr;
	}
	public void setEsalesPODate(String esalesPODate) {
		this.esalesPODate = esalesPODate;
	}
	public void setEsalesPOValue(String esalesPOValue) {
		this.esalesPOValue = esalesPOValue;
	}
	public void setEstatusId(String estatusId) {
		this.estatusId = estatusId;
	}
	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}
	public void setEcustomerId(String ecustomerId) {
		this.ecustomerId = ecustomerId;
	}
	public void setEsalesQuotationId(String esalesQuotationId) {
		this.esalesQuotationId = esalesQuotationId;
	}
	public void setEpaymentTermId(String epaymentTermId) {
		this.epaymentTermId = epaymentTermId;
	}
	public void setEmemo(String ememo) {
		this.ememo = ememo;
	}
	public void setEcurrencyId(String ecurrencyId) {
		this.ecurrencyId = ecurrencyId;
	}
	public void setEsalesTaxAmount(String esalesTaxAmount) {
		this.esalesTaxAmount = esalesTaxAmount;
	}
	public void seteVATAmount(String eVATAmount) {
		this.eVATAmount = eVATAmount;
	}
	public void setEexiciseAmount(String eexiciseAmount) {
		this.eexiciseAmount = eexiciseAmount;
	}
	public void setEfrieghtCharges(String efrieghtCharges) {
		this.efrieghtCharges = efrieghtCharges;
	}
	public void setePnFCharges(String ePnFCharges) {
		this.ePnFCharges = ePnFCharges;
	}
	public void setEdueDate(String edueDate) {
		this.edueDate = edueDate;
	}
	public void setEcreatedBy(String ecreatedBy) {
		this.ecreatedBy = ecreatedBy;
	}
	public void setEcreatedDTTM(String ecreatedDTTM) {
		this.ecreatedDTTM = ecreatedDTTM;
	}
	public void setEmodifiedBy(String emodifiedBy) {
		this.emodifiedBy = emodifiedBy;
	}
	public void setEmodifiedDTTM(Date emodifiedDTTM) {
		this.emodifiedDTTM = emodifiedDTTM;
	}
	public void setEmaterial_Id(String ematerial_Id) {
		this.ematerial_Id = ematerial_Id;
	}
	public void setEuom_Id(String euom_Id) {
		this.euom_Id = euom_Id;
	}
	public void setEcurrency_Id(String ecurrency_Id) {
		this.ecurrency_Id = ecurrency_Id;
	}
	
	
	
	

}
