/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 07-11-2013
 */
public class SalesInquiryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int siId;
	private int EditsiId;
	private int salesInquiryId;
	private String salesInquiryNo;
	private String customerId;
	private String requestedDate;
	private String validFrom;
	private String validTo;
	private String requiredDeliveryDate;
	private String salesGroupId;
	private String description;
	private String statusId;

	private List<SalesInquiryLineBean> salesEnquiryLine;
	private CustomerBean custBean;
	private SalesGroup salesGroup;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;

	// Child Variables

	private int[] salesInquiryLineId;
	private String[] salesInquiry_Id;
	private String[] materialId;
	private String[] quantity;
	private String[] UOMId;
	private String[] requiredDate;
	private String material_Id;
	private String uom_Id;

	// Edit Variables

	private int esalesInquiryId;
	private String esalesInquiryNo;
	private String ecustomerId;
	private String erequestedDate;
	private String evalidFrom;
	private String evalidTo;
	private String erequiredDeliveryDate;
	private String esalesGroupId;
	private String edescription;
	private String estatusId;

	private int[] esalesInquiryLineId;
	private String[] esalesInquiry_Id;
	private String[] ematerialId;
	private String[] equantity;
	private String[] eUOMId;
	private String[] erequiredDate;

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

	private String ematerial_Id;
	private String euom_Id;

	private String ematerialName;
	private String eUomName;

	// Setter And Getter Methods

	public String getEmaterialName() {
		return ematerialName;
	}

	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}

	public String geteUomName() {
		return eUomName;
	}

	public void seteUomName(String eUomName) {
		this.eUomName = eUomName;
	}

	public String getEmaterial_Id() {
		return ematerial_Id;
	}

	public void setEmaterial_Id(String ematerial_Id) {
		this.ematerial_Id = ematerial_Id;
	}

	public String getEuom_Id() {
		return euom_Id;
	}

	public void setEuom_Id(String euom_Id) {
		this.euom_Id = euom_Id;
	}

	public String getMaterial_Id() {
		return material_Id;
	}

	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}

	public String getUom_Id() {
		return uom_Id;
	}

	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
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

	public int getEditsiId() {
		return EditsiId;
	}

	public void setEditsiId(int editsiId) {
		EditsiId = editsiId;
	}

	public int getSiId() {
		return siId;
	}

	public void setSiId(int siId) {
		this.siId = siId;
	}

	public int[] getSalesInquiryLineId() {
		return salesInquiryLineId;
	}

	public void setSalesInquiryLineId(int[] salesInquiryLineId) {
		this.salesInquiryLineId = salesInquiryLineId;
	}

	public String[] getSalesInquiry_Id() {
		return salesInquiry_Id;
	}

	public void setSalesInquiry_Id(String[] salesInquiry_Id) {
		this.salesInquiry_Id = salesInquiry_Id;
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

	public String[] getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String[] requiredDate) {
		this.requiredDate = requiredDate;
	}

	public List<SalesInquiryLineBean> getSalesEnquiryLine() {
		return salesEnquiryLine;
	}

	public int getEsalesInquiryId() {
		return esalesInquiryId;
	}

	public void setEsalesInquiryId(int esalesInquiryId) {
		this.esalesInquiryId = esalesInquiryId;
	}

	public String getEsalesInquiryNo() {
		return esalesInquiryNo;
	}

	public void setEsalesInquiryNo(String esalesInquiryNo) {
		this.esalesInquiryNo = esalesInquiryNo;
	}

	public String getEcustomerId() {
		return ecustomerId;
	}

	public void setEcustomerId(String ecustomerId) {
		this.ecustomerId = ecustomerId;
	}

	public int[] getEsalesInquiryLineId() {
		return esalesInquiryLineId;
	}

	public void setEsalesInquiryLineId(int[] esalesInquiryLineId) {
		this.esalesInquiryLineId = esalesInquiryLineId;
	}

	public String[] getEsalesInquiry_Id() {
		return esalesInquiry_Id;
	}

	public void setEsalesInquiry_Id(String[] esalesInquiry_Id) {
		this.esalesInquiry_Id = esalesInquiry_Id;
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

	public String[] getErequiredDate() {
		return erequiredDate;
	}

	public void setErequiredDate(String[] erequiredDate) {
		this.erequiredDate = erequiredDate;
	}

	public String getErequestedDate() {
		return erequestedDate;
	}

	public void setErequestedDate(String erequestedDate) {
		this.erequestedDate = erequestedDate;
	}

	public String getEvalidFrom() {
		return evalidFrom;
	}

	public void setEvalidFrom(String evalidFrom) {
		this.evalidFrom = evalidFrom;
	}

	public String getEvalidTo() {
		return evalidTo;
	}

	public void setEvalidTo(String evalidTo) {
		this.evalidTo = evalidTo;
	}

	public String getErequiredDeliveryDate() {
		return erequiredDeliveryDate;
	}

	public void setErequiredDeliveryDate(String erequiredDeliveryDate) {
		this.erequiredDeliveryDate = erequiredDeliveryDate;
	}

	public String getEsalesGroupId() {
		return esalesGroupId;
	}

	public void setEsalesGroupId(String esalesGroupId) {
		this.esalesGroupId = esalesGroupId;
	}

	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	public String getEstatusId() {
		return estatusId;
	}

	public void setEstatusId(String estatusId) {
		this.estatusId = estatusId;
	}

	public void setSalesEnquiryLine(List<SalesInquiryLineBean> salesEnquiryLine) {
		this.salesEnquiryLine = salesEnquiryLine;
	}

	public SalesGroup getSalesGroup() {
		return salesGroup;
	}

	public void setSalesGroup(SalesGroup salesGroup) {
		this.salesGroup = salesGroup;
	}

	public CustomerBean getCustBean() {
		return custBean;
	}

	public void setCustBean(CustomerBean custBean) {
		this.custBean = custBean;
	}

	public int getSalesInquiryId() {
		return salesInquiryId;
	}

	public void setSalesInquiryId(int salesInquiryId) {
		this.salesInquiryId = salesInquiryId;
	}

	public String getSalesInquiryNo() {
		return salesInquiryNo;
	}

	public void setSalesInquiryNo(String salesInquiryNo) {
		this.salesInquiryNo = salesInquiryNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public String getRequiredDeliveryDate() {
		return requiredDeliveryDate;
	}

	public void setRequiredDeliveryDate(String requiredDeliveryDate) {
		this.requiredDeliveryDate = requiredDeliveryDate;
	}

	public String getSalesGroupId() {
		return salesGroupId;
	}

	public void setSalesGroupId(String salesGroupId) {
		this.salesGroupId = salesGroupId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

}
